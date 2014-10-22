package com.qutest.util;

import java.util.Random;

/**
 * @author zhoujiqian 2012-9-28
 * 随机数生成类
 */
public class RandomUtil {
	private static Random random = new Random();
	
	//1~max
	public static int getRandom(int max){
		return getRandomExcept(max)+1;
	}
	
	//0~max-1
	public static int getRandomExcept(int max){
		return random.nextInt(max);
	}

	public static boolean getRandomBoolean(){
		return random.nextBoolean();
	}
	
	//随机 count 个 字符（字母，数字）
	public static String getCharacter(int count){
		String [] arr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
				"O","P","Q","R","S","T","U","V","W","X","Y","Z",
				"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
				"o","p","q","r","s","t","u","v","w","x","y","z",
				"0","1","2","3","4","5","6","7","8","9"};
		StringBuffer buffer = new StringBuffer();
		int len = arr.length;
		
		for (int i = 0; i < count; i++) {
			buffer.append(arr[RandomUtil.getRandomExcept(len)]);
		}
		
		return buffer.toString();
	}
}
