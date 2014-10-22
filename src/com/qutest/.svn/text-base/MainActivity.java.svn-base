package com.qutest;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.qutest.ui.ani.TweenAnim;

public class MainActivity extends Activity  implements OnClickListener{
	
	public static int screenWidth;  //屏幕宽度
	public static int screenHeight; //屏幕高度
	public static float density;    //屏幕密度
	
	public static MainActivity activity;
	public static Handler handler;
	
	private Button btn_qiandao;
	private Button btn_ani;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
        //context = this;
        activity = this;
        
        //屏幕设置
        initScreen();
        
        init();
		
	}

	public void init() {
        handler = UIHandler.MsgListener();
		
		setContentView(R.layout.activity_main);
		findViewById();
		addListener();
		
	}

	private void findViewById() {
		btn_qiandao = (Button)findViewById(R.id.btn_qiandao);
		btn_ani= (Button)findViewById(R.id.btn_ani);
		
	}
	private void addListener() {
		btn_qiandao.setOnClickListener(this);
		btn_ani.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		if (v==btn_qiandao) {//签到
			sendGameMessage(Constant.GAMEMSG_SHOW_DIA_QIANDAO);
		}
		else if (v==btn_ani) {//动画
			TweenAnim anim = new TweenAnim(MainActivity.this);  
			anim.setFocusable(true);  
			setContentView(anim);  
		}
		

		
	}
	
	//发送游戏内部消息
    public static void sendGameMessage(int what){
    	Message message = new Message();
    	message.what = what;
    	handler.sendMessage(message);
    }
    
    public static void sendGameMessage(int what,Object obj){
    	Message message = new Message();
    	message.what = what;
    	message.obj = obj;
    	handler.sendMessage(message);
    }
	
    
	//屏幕设置
	private void initScreen() {
		
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 取消标题栏
		this.getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN, // 全屏
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.getWindow().setBackgroundDrawable(new ColorDrawable(0));
		
		//this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);// 设置横屏
		
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        density = dm.density;
        
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}





}
