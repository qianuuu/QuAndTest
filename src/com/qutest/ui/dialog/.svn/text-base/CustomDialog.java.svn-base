package com.qutest.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;


/**
 * 不直接继承Dialog 原因：按钮无法添加事件
 *
 */
public class CustomDialog implements OnKeyListener {

	protected Window window = null;
    protected WindowManager.LayoutParams wl=null;
    protected Dialog dialog;
    protected Activity activity;
    private int titleType;
    private int type;//dialog 类型
    
    //标题类型
    public static final int TITLE_TYPE_SYS=0;//系统标题
    public static final int TITLE_TYPE_CLIENT=1;//自定义标题
    public static final int TITLE_TYPE_NULL=2;//无标题
    
    public CustomDialog(Activity _activity, int styleResID,int _type,int _titleType,boolean fullScree)
    {
    	
    	this.activity = _activity;
    	this.type = _type;
    	this.titleType = _titleType;
    	
		switch (titleType) {
		
		  case TITLE_TYPE_SYS:
			dialog = new Dialog(activity);
			break;
		  case TITLE_TYPE_CLIENT:
			dialog = new Dialog(activity,
					android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
			dialog.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
			break;
		  case TITLE_TYPE_NULL:
			dialog = new Dialog(activity,
					android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			break;
		}
    	
    	
        window = dialog.getWindow(); //得到对话框
        wl = window.getAttributes();
        //window.setWindowAnimations(R.style.dialogWindowAnim);
        
    	if(fullScree){
    		// 全屏
    		window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    		window.setBackgroundDrawable(new ColorDrawable(0));
    	}
    	
    	dialog.setContentView(styleResID);
    	dialog.setOnKeyListener(this);
    	dialog.setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss(DialogInterface paramDialogInterface) {
				DialogUtil.closeDiaLog(type);
				closeDialog();
			}
		});
       
    }
    
    
    public void showDialog( int x, int y){
        windowDeploy(x, y);
        //设置触摸对话框意外的地方取消对话框
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }
    
//    //头部标题
//    public void setTitle(String title){
//       	switch (titleType) {
//		case TITLE_TYPE_SYS:
//			dialog.setTitle(title);
//			break;
//		case TITLE_TYPE_CLIENT:
//    		TextView tv = (TextView)dialog.findViewById(R.id.dia_title);
//    		tv.setText(title);
//			break;
//		case TITLE_TYPE_NULL:
//			break;
//		}
//    }


    public int getType() {
		return type;
	}


	//大小
    public void setSize(int width, int height){
    	dialog.getWindow().setLayout(width, height);
    }
    
    
    public boolean isShowing()
    {
    	return dialog.isShowing();
    }

    //关闭窗口
	public void closeDialog()
	{
		if (dialog!=null&&dialog.isShowing()) {
			dialog.dismiss();
		}
	}
    
	/**设置窗口显示*/
    public void windowDeploy(int x, int y){
        //根据x，y坐标设置窗口需要显示的位置
        wl.x = x; //x小于0左移，大于0右移
        wl.y = y; //y小于0上移，大于0下移  
        window.setAttributes(wl);
    }
    
    /**
     * 屏幕中心坐标不为（0,0）
     * @param x
     * @param y
     */
//    public void windowDeploy_ex(int x, int y)
//    {
//    	
//        wl.x = x-GameView.screenWidth/2; 
//        wl.y = y-GameView.screenHeight/2; 
//        window.setAttributes(wl);
//    }
    
    /**设置动画*/
    protected void setAnim(int animId)
    {
    	window.setWindowAnimations(animId); //设置窗口弹出动画
    }
    /**设置透明度*/
    protected void setAlpha(float alp)
    {
    	wl.alpha=alp; 
    }
    /**设置重力*/
    protected void setGravity(int g)
    {
    	wl.gravity = g;
    }
    public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public WindowManager.LayoutParams getWl() {
		return wl;
	}

	public void setWl(WindowManager.LayoutParams wl) {
		this.wl = wl;
	}

	public Dialog getDialog() {
		return dialog;
	}

	public void setDialog(Dialog dialog) {
		this.dialog = dialog;
	}

	public Context getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}


	@Override
	public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
		return false;
	}

	//dialog 数据 更新   子类重写该方法
    public void updateDialog(){}


    
    
    

    
}
