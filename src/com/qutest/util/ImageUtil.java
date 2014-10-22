package com.qutest.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;

import com.qutest.MainActivity;

public class ImageUtil {

	// android读取指定Resourceid的图片
	public static Bitmap getBmpByResId(int resId) {
		Resources res = MainActivity.activity.getResources();
		return BitmapFactory.decodeResource(res, resId);
	}

	// assets 目录下
	public static Bitmap loadAssetsImage(String folder, String imgName) {
		//Log.i("LoadRes", "图片：" + imgName);
		DataInputStream dis = null;
		InputStream in = null;

		try {
			in = MainActivity.activity.getResources().getAssets()
					.open(folder + "/" + imgName);

			dis = new DataInputStream(in);
			int len = dis.available();
			byte[] b = new byte[len];
			dis.read(b);

			return BitmapFactory.decodeByteArray(b, 0, b.length);
		} catch (IOException e) {
			Log.e("ImageUtil", " 读取图片异常  imgName ==  " + imgName);
		}
		return null;
	}
	
	// assets 目录,文件夹
	public static Bitmap [] loadFolderImage(String folder, String... imgName) {
		Bitmap [] arr = new Bitmap [imgName.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = loadAssetsImage(folder, imgName[i]);
		}
		return arr;
	}
	
	
	public static Bitmap resizeImage(Bitmap bitmap, int w, int h,int rotate ) {

		// load the origial Bitmap

		Bitmap BitmapOrg = bitmap;

		int width = BitmapOrg.getWidth();

		int height = BitmapOrg.getHeight();

		int newWidth = w;

		int newHeight = h;

		// calculate the scale

		float scaleWidth = ((float) newWidth) / width;

		float scaleHeight = ((float) newHeight) / height;

		// create a matrix for the manipulation

		Matrix matrix = new Matrix();

		// resize the Bitmap

		matrix.postScale(scaleWidth, scaleHeight);

		// if you want to rotate the Bitmap

		 matrix.postRotate(rotate);

		// recreate the new Bitmap

		Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width,

		height, matrix, true);

		// make a Drawable from Bitmap to allow to set the Bitmap
		// to the ImageView, ImageButton or what ever

		return resizedBitmap;
		//return new BitmapDrawable(resizedBitmap);

	}

	
}
