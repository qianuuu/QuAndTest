package com.qutest.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期 util
 * @author zjq
 *
 */
public class DateUtil {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//private static SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * @return 当前日期  yyyy-MM-dd HH:mm:ss 格式
	 */
	public static String getNowDate(){
		String nowDate = sdf.format(new Date(System.currentTimeMillis()));
		return nowDate;
	}
	
	public static String getFormatDate(long time){
		String nowDate = sdf.format(new Date(time));
		return nowDate;
	}

	//得到本月的第一天 
	public static Calendar getMonthFirstDay(Calendar _caldar) {    
		Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.DAY_OF_MONTH, _caldar     
	            .getActualMinimum(Calendar.DAY_OF_MONTH));     
	    return calendar;     
	}
	
	//得到本月的最后一天
	public static Calendar getMonthLastDay( Calendar _caldar) {  
		Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.DAY_OF_MONTH, _caldar     
	            .getActualMaximum(Calendar.DAY_OF_MONTH));     
	    return calendar;     
	}
	
	
	//得到本周的第一天 
	public static Calendar getWeekFirstDay() {     
	    Calendar calendar = Calendar.getInstance();     
	    calendar.set(Calendar.DAY_OF_WEEK, calendar     
	            .getActualMinimum(Calendar.DAY_OF_WEEK));    
	    //需要加一天，默认第一天是星期天
	    calendar.add(Calendar.DAY_OF_MONTH, 1);
	    
	    return calendar;     
	}     
	    

	//得到本周的最后一天
	public static Calendar getWeekLastDay() {     
	    Calendar calendar = Calendar.getInstance();     
	    calendar.set(Calendar.DAY_OF_WEEK, calendar     
	            .getActualMaximum(Calendar.DAY_OF_WEEK));   
	    
	    //需要加一天，默认最后一天 是周六
	    calendar.add(Calendar.DAY_OF_MONTH, 1);
	    return calendar;     
	}
	
	//是否是同一天
	public static  boolean isSameDay(Calendar c1,Calendar c2){
		if(c1.get(Calendar.YEAR)==c2.get(Calendar.YEAR)&&
				c1.get(Calendar.MONTH)==c2.get(Calendar.MONTH)&&
				     c1.get(Calendar.DAY_OF_MONTH)==c2.get(Calendar.DAY_OF_MONTH)){
			return true;
		}
		return false;
	}
	
	public static  boolean isSameDay(long c1,long c2){
		Calendar cc1 = Calendar.getInstance();
		cc1.setTimeInMillis(c1);
		
		Calendar cc2 = Calendar.getInstance();
		cc2.setTimeInMillis(c2);
		
		return isSameDay(cc1, cc2);
	}
	
	//得到一个月内的所有天
	public static ArrayList<Calendar> getMonthDays(Calendar calendar){
		
		ArrayList<Calendar> list = new ArrayList<Calendar>();
		
		Calendar firstDay = getMonthFirstDay(calendar);
		Calendar endDay = getMonthLastDay(calendar);
		
		for (int i = 0; i <31; i++) {
			long addTime = i*24*3600*1000L;
			Calendar tmpDay = Calendar.getInstance();
			tmpDay.setTimeInMillis(firstDay.getTimeInMillis()+addTime);
			if (tmpDay.get(Calendar.DAY_OF_MONTH)<=
					endDay.get(Calendar.DAY_OF_MONTH)) {
				list.add(tmpDay);
			}else{
				break;
			}
		}
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(getFormatDate(list.get(i).getTimeInMillis())
//					+",week seq = "+list.get(i).get(Calendar.DAY_OF_WEEK));
//		}
		return list;
	}
	
	
	//------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		//DateUtil.getMonthDays(Calendar.getInstance());
	}
}
