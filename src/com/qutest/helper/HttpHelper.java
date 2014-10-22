package com.qutest.helper;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * 客户端http 请求(web服务器 )
 * 
 * @author zjq
 * 
 */
public class HttpHelper {

	private static final int REQUEST_TIMEOUT = 5 * 1000;// 设置请求超时秒
	private static final int DATA_RECEIVE_TIMEOUT = 5 * 1000; // 设置等待数据超时时间秒
	
	
	//url 和参数map
	public static String sendGetReq(String url,Map<String,String> kvMap) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(url);
        if (!url.endsWith("?")) {
        	buffer.append("?");
		}
        
        int pIndex =0;
		Iterator<String> it = kvMap.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = kvMap.get(key);
			//conn.setRequestProperty(key,value);
			pIndex++;
			if (pIndex>1) {
				buffer.append("&"+key+"="+value);
			}else{
				buffer.append(key+"="+value);
			}
		}
	
		return sendGetReq(buffer.toString());
	}
	
	//拼好的url
	public static String sendGetReq(String urlStr) {

		String result = null;
		try {
			if (urlStr.startsWith("http://")) {

				// Send data
				URL url = new URL(urlStr);
				URLConnection conn = url.openConnection();
				//设置是否 发送接收
				conn.setDoOutput(true);  
				conn.setDoInput(true);  

				conn.setConnectTimeout(REQUEST_TIMEOUT);
				conn.setReadTimeout(DATA_RECEIVE_TIMEOUT);

				// Get the response
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuffer sb = new StringBuffer();
				String line;
				while ((line = rd.readLine()) != null) {
					sb.append(line);
				}
				rd.close();
				result = sb.toString();
			}
		} catch (Exception e) {
			return null;
		}

		return result;
	}
	
	static String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
	static String PREFIX = "--", LINE_END = "\r\n";
	static String CONTENT_TYPE = "text/plain"; // 内容类型
	
	//post 请求
	public static String sendPostReq(String urlStr,Map<String,String> kvMap){
		try {
			
			if (urlStr.startsWith("http://")) {
				// Send data
				URL url = new URL(urlStr);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();

				conn.setConnectTimeout(REQUEST_TIMEOUT);
				conn.setReadTimeout(DATA_RECEIVE_TIMEOUT);
				conn.setRequestMethod("POST");
				
				conn.setDoInput(true); // 允许输入流
				conn.setDoOutput(true); // 允许输出流
				conn.setUseCaches(false); // 不允许使用缓存
				conn.setRequestMethod("POST"); // 请求方式
				conn.setRequestProperty("Charset", "utf-8"); // 设置编码
				
				//conn.setRequestProperty("connection", "keep-alive");
				conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
				
				StringBuffer buffer = new StringBuffer();
	            int pIndex =0;
				Iterator<String> it = kvMap.keySet().iterator();
				while (it.hasNext()) {
					String key = it.next();
					String value = kvMap.get(key);
					//conn.setRequestProperty(key,value);
					pIndex++;
					if (pIndex>1) {
						buffer.append("&"+key+"="+value);
					}else{
						buffer.append(key+"="+value);
					}
				}
				
	            byte[] b = buffer.toString().getBytes(); 
	            conn.getOutputStream().write(b, 0, b.length); 
	            conn.getOutputStream().flush(); 
	            conn.getOutputStream().close(); 

				// Get the response
				int res = conn.getResponseCode();
				//String desc = conn.getHeaderField("desc");
				//System.out.println("---desc--="+desc);
				if ((res == 200))
				{
					InputStream iStream = conn.getInputStream();// 得到网络返回的输入流
					String resp = readData(iStream, "UTF-8");
					System.out.println(" success receive, resp="+resp);
					return resp;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		return "";
	}
	
	
	
	/**
	 * 类型转换InputStream --> String
	 * @param inSream InputStream对象
	 * @param charsetName 编码格式
	 * @return 字符串
	 * @throws Exception
	 */
	private static String readData(InputStream inSream, String charsetName) throws Exception
	{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = inSream.read(buffer)) != -1)
		{
			outStream.write(buffer, 0, len);
		}
		byte[] data = outStream.toByteArray();
		outStream.close();
		inSream.close();
		return new String(data, charsetName);
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(sendGetReq("http://121.199.26.59:8080/ddzlsvr/login?userName=100552&userPass=100552"));
		System.out.println(sendGetReq("http://121.199.26.59/charge/ecard/order.php?userid=1&goodsId=2"));
		
	}
	

}
