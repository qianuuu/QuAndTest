package com.qutest.util;

import com.qutest.Constant;
import com.qutest.MainActivity;


/**
 * 屏幕适配相关
 * @author zhoujiqian
 *
 */
public class ScaleUtil {
	
	
	public  static float [] getXY(float _x ,float _y){
		
		float x = _x * Constant.S_WIDTH / MainActivity.screenWidth;
		float y = _y * Constant.S_HEIGHT / MainActivity.screenWidth;
		
		return new float[]{x,y};
	}
	
	public  static float [] getWeight(float _w ,float _h){
		
		float w = _w * MainActivity.screenWidth / Constant.S_WIDTH;
		float h = _h *  MainActivity.screenHeight /Constant.S_HEIGHT;
		
		return new float[]{w,h};
	}
	
	

}
