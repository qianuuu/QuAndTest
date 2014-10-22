package com.qutest.ui.ani;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.qutest.MainActivity;
import com.qutest.R;
public class TweenAnim extends View  {
	
	
	//Alpha动画 - 渐变透明度
	private Animation alphaAnimation = null;
	
	//Sacle动画 - 渐变尺寸缩放
	private Animation scaleAnimation = null;
	
	//Translate动画 - 位置移动
	private Animation translateAnimation = null;
	
	//Rotate动画 - 画面旋转
	private Animation rotateAnimation = null;
	
	public TweenAnim(Context context) {
		super(context);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Log.e("Tween", "onDraw");
		//加载一个图片
		canvas.drawBitmap(((BitmapDrawable)getResources().getDrawable(R.drawable.test1)).getBitmap(), 100, 100, null);
	
	}
//	@Override
//	public boolean onKeyUp(int keyCode, KeyEvent event) {
//		
//		
//		Log.e("Tween", "onKeyDown");
//		switch (keyCode) {
//			case KeyEvent.KEYCODE_DPAD_UP:
//				Log.e("Tween", "onKeyDown - KEYCODE_DPAD_UP");
//				alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
//				//设置动画时间
//				alphaAnimation.setDuration(3000);
//				this.startAnimation(alphaAnimation);
//				break;
//			case KeyEvent.KEYCODE_DPAD_DOWN:
//				Log.e("Tween", "onKeyDown - KEYCODE_DPAD_DOWN");
//				rotateAnimation = new RotateAnimation(0f, 360f);
//				rotateAnimation.setDuration(1000);
//				this.startAnimation(rotateAnimation);
//				break;
//			case KeyEvent.KEYCODE_DPAD_LEFT:
//				Log.e("Tween", "onKeyDown - KEYCODE_DPAD_LEFT");
//				//初始化
//				scaleAnimation = new ScaleAnimation(0.1f, 1.0f,0.1f,1.0f);
//				//设置动画时间
//				scaleAnimation.setDuration(500);
//				this.startAnimation(scaleAnimation);
//				break;
//			case KeyEvent.KEYCODE_DPAD_RIGHT:
//				Log.e("Tween", "onKeyDown - KEYCODE_DPAD_RIGHT");
//				//初始化
//				translateAnimation = new TranslateAnimation(0.1f, 100.0f,0.1f,100.0f);
//				//设置动画时间
//				translateAnimation.setDuration(1000);
//				
//				this.startAnimation(translateAnimation);
//				break;
//			case KeyEvent.KEYCODE_DPAD_CENTER:
//				Log.e("Tween", "onKeyDown - KEYCODE_DPAD_CENTER");
//				//初始化 Translate动画
//				translateAnimation = new TranslateAnimation(0.1f, 100.0f,0.1f,100.0f);
//				//初始化 Alpha动画
//				alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
//				
//				//动画集
//				AnimationSet set = new AnimationSet(true);
//				set.addAnimation(translateAnimation);
//				set.addAnimation(alphaAnimation);
//				
//				//设置动画时间 (作用到每个动画)
//				set.setDuration(1000);
//				this.startAnimation(set);
//				break;
//			default:
//				break;
//		}
//		return true;
//	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.i("Tween", "onTouch,x="+event.getX());
		//用该方法代替上面方法
		float x = event.getX();
		float y = event.getY();
		
		if (x>300&y<100) {//右上角关闭
			MainActivity.activity.init();
			return false;
		}
		
		if (y<200) {
			Log.e("Tween", "onKeyDown - KEYCODE_DPAD_UP");
			alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
			//设置动画时间
			alphaAnimation.setDuration(3000);
			this.startAnimation(alphaAnimation);
		}else if (y<400) {
			Log.e("Tween", "onKeyDown - KEYCODE_DPAD_DOWN");
			rotateAnimation = new RotateAnimation(0f, 360f);
			rotateAnimation.setDuration(1000);
			this.startAnimation(rotateAnimation);
		}else if (y<600) {
			Log.e("Tween", "onKeyDown - KEYCODE_DPAD_LEFT");
			//初始化
			scaleAnimation = new ScaleAnimation(0.1f, 1.0f,0.1f,1.0f);
			//设置动画时间
			scaleAnimation.setDuration(500);
			this.startAnimation(scaleAnimation);
		}else if (y<700) {
			Log.e("Tween", "onKeyDown - KEYCODE_DPAD_RIGHT");
			//初始化
			translateAnimation = new TranslateAnimation(0.1f, 100.0f,0.1f,100.0f);
			//设置动画时间
			translateAnimation.setDuration(1000);
			
			this.startAnimation(translateAnimation);
		}else{
			Log.e("Tween", "onKeyDown - KEYCODE_DPAD_CENTER");
			//初始化 Translate动画
			translateAnimation = new TranslateAnimation(0.1f, 100.0f,0.1f,100.0f);
			//初始化 Alpha动画
			alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
			
			//动画集
			AnimationSet set = new AnimationSet(true);
			set.addAnimation(translateAnimation);
			set.addAnimation(alphaAnimation);
			
			//设置动画时间 (作用到每个动画)
			set.setDuration(1000);
			this.startAnimation(set);
		}
		
		return false;
		
	}

//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if( keyCode == KeyEvent.KEYCODE_BACK){//退出游戏
//			MainActivity.activity.setContentView(R.layout.activity_main);  
//		}
//		
//		
//		return true;
//		
//	}
	
}
