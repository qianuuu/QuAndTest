package com.qutest;

import com.qutest.ui.dialog.DialogUtil;

import android.os.Handler;
import android.os.Message;

/**
 * 游戏内部消息 2012-12-12
 * 
 * @author zhoujiqian
 * 
 */
public class UIHandler {

	public static Handler MsgListener() {

		Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				//String text = String.valueOf(msg.obj);
				switch (msg.what) {
				  case Constant.GAMEMSG_SHOW_DIA_QIANDAO:
					  DialogUtil.createTestDialog();
					  break;
				}
			}
		};

		return handler;
	}

}
