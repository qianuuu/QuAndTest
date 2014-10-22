package com.qutest.ui.ani;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

import com.qutest.R;
public class TweenAnim2 extends View {
	
	//Alpha动画 - 渐变透明度
	private Animation alphaAnimation = null;
	
	//Sacle动画 - 渐变尺寸缩放
	private Animation scaleAnimation = null;
	
	//Translate动画 - 位置移动
	private Animation translateAnimation = null;
	
	//Rotate动画 - 画面旋转
	private Animation rotateAnimation = null;
	
	public TweenAnim2(Context context) {
		super(context);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Log.e("Tween", "onDraw");
		//加载一个图片
		canvas.drawBitmap(((BitmapDrawable)getResources().getDrawable(R.drawable.test1)).getBitmap(), 0, 0, null);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		Log.e("Tween", "onKeyDown");
		return true;
	}
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		Log.e("Tween", "onKeyDown");
		switch (keyCode) {
			case KeyEvent.KEYCODE_DPAD_UP:
				Log.e("Tween", "onKeyDown - KEYCODE_DPAD_UP");
				
				alphaAnimation = AnimationUtils.loadAnimation(this.getContext(), R.anim.alpha_anim);
				
				this.startAnimation(alphaAnimation);
				break;
			case KeyEvent.KEYCODE_DPAD_DOWN:
				Log.e("Tween", "onKeyDown - KEYCODE_DPAD_DOWN");
				
				rotateAnimation = AnimationUtils.loadAnimation(this.getContext(), R.anim.rotate_anim);
				
				this.startAnimation(rotateAnimation);
				break;
			case KeyEvent.KEYCODE_DPAD_LEFT:
				Log.e("Tween", "onKeyDown - KEYCODE_DPAD_LEFT");
				
				scaleAnimation = AnimationUtils.loadAnimation(this.getContext(), R.anim.scale_anim);
				
				this.startAnimation(scaleAnimation);
				break;
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				Log.e("Tween", "onKeyDown - KEYCODE_DPAD_RIGHT");
				
				translateAnimation = AnimationUtils.loadAnimation(this.getContext(), R.anim.translate_anim);
				
				this.startAnimation(translateAnimation);
				break;
			case KeyEvent.KEYCODE_DPAD_CENTER:
				Log.e("Tween", "onKeyDown - KEYCODE_DPAD_CENTER");
				//初始化 Translate动画
				translateAnimation = AnimationUtils.loadAnimation(this.getContext(), R.anim.translate_anim);
				
				//初始化 Alpha动画
				alphaAnimation = AnimationUtils.loadAnimation(this.getContext(), R.anim.alpha_anim);
				
				//动画集
				AnimationSet set = new AnimationSet(true);
				set.addAnimation(translateAnimation);
				set.addAnimation(alphaAnimation);
				
				//设置动画时间 (作用到每个动画)
				set.setDuration(1000);
				this.startAnimation(set);
				break;
			default:
				break;
		}
		return true;
	}
	
}
