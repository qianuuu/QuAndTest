package com.qutest.ui.adapter;

import java.util.ArrayList;
import java.util.Calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qutest.MainActivity;
import com.qutest.R;
import com.qutest.ui.uidata.QianDaoData;
import com.qutest.util.DateUtil;
import com.qutest.util.RandomUtil;

public class QianDaoAdapter extends BaseAdapter {

	private int selectIndex;
	private ArrayList<QianDaoData> dataList;
	private ArrayList<QianDaoData> monthList;

	public QianDaoAdapter() {
		dataList = new ArrayList<QianDaoData>();
		ArrayList<Calendar> list = DateUtil
				.getMonthDays(Calendar.getInstance());
		for (Calendar tmp : list) {
			int date = tmp.get(Calendar.DAY_OF_MONTH);
			int weekday = tmp.get(Calendar.DAY_OF_WEEK);

			QianDaoData data = new QianDaoData();
			data.setDate(date);
			data.setWeekday(weekday);
			data.setQiandao(RandomUtil.getRandomBoolean());
			dataList.add(data);
		}
		// 按周分开 6*7 的方格
		monthList = new ArrayList<QianDaoData>();
		for (int i = 0; i < 6; i++) {
			for (int j = 1; j <= 7; j++) {
				QianDaoData tmpDay = getFromDataList(j);
				monthList.add(tmpDay);
			}
		}
	}

	private QianDaoData getFromDataList(int j) {
		if (dataList.size() == 0) {
			return null;
		}
		QianDaoData fistDay = dataList.get(0);
		int dayOfWeek = fistDay.getWeekday();
		if (dayOfWeek == j) {
			dataList.remove(0);
			return fistDay;
		}
		return null;
	}

	@Override
	public int getCount() {
		return monthList.size();
	}

	@Override
	public Object getItem(int position) {
		return monthList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	class ViewHolder {
		ImageView imageView;
		TextView textView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			
			convertView = LayoutInflater.from(MainActivity.activity)
					.inflate(R.layout.grid_view_item, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) convertView.findViewById(R.id.img_back);
			holder.textView = (TextView) convertView.findViewById(R.id.text1);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}


		QianDaoData data = this.monthList.get(position);

		if (data != null) {
			holder.textView.setText(String.valueOf(data.getDate()));
			if (RandomUtil.getRandomBoolean()) {
				
				holder.imageView.setVisibility(View.INVISIBLE);
			}else{
				// Bitmap bitmap = ImageUtil.getBmpByResId(R.drawable.a_gou);
				 //holder.imageView.setImageBitmap(bitmap);
				// convertView = holder.imageView;
			}
			
		} else {
			//其他月
			holder.textView.setText("");
		}

		return convertView;
	}

	public int getSelectIndex() {
		return selectIndex;
	}

	public void setSelectIndex(int selectIndex) {
		this.selectIndex = selectIndex;
	}

}
