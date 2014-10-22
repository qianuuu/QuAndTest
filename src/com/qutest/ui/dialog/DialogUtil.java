package com.qutest.ui.dialog;

import java.util.ArrayList;

import com.qutest.util.ScaleUtil;

/**
 * 弹出窗dialog 管理
 * 
 */

public class DialogUtil {

	//private static CustomDialog customDialog = null;
	public static ArrayList<CustomDialog> dialogList = new ArrayList<CustomDialog>();


	public static void createTestDialog() {
		 QianDaoDia dia = new QianDaoDia();
		
		 float [] arr = ScaleUtil.getWeight(480, 480);
		 dia.setSize((int)arr[0], (int)arr[1]);
		 dia.showDialog(0, 0);
		 dialogList.add(dia);
	}

	// 根据类型取dialog
	public static CustomDialog getDialogByType(int type) {
		for (int i = 0; i < dialogList.size(); i++) {
			CustomDialog dia = (CustomDialog) dialogList.get(i);
			if (dia.getType() == type) {
				return dia;
			}
		}
		return null;
	}
	
	public static void closeDiaLog(int type) {
		for (int i = 0; i < dialogList.size(); i++) {
			CustomDialog dia = (CustomDialog) dialogList.get(i);
			if (dia.getType() == type) {
				dialogList.remove(i);
				dia.closeDialog();
				break;
			}
		}
	}

}
