package com.qutest.ui.dialog;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.qutest.Constant;
import com.qutest.MainActivity;
import com.qutest.R;
import com.qutest.ui.adapter.QianDaoAdapter;

public class QianDaoDia extends CustomDialog implements OnTouchListener {

	private LayoutInflater inflater ;
	private GridView gv;
	
	public QianDaoDia() {
		super(MainActivity.activity,R.layout.grid_view,
				Constant.DIALOG_QIANDAO,TITLE_TYPE_NULL,false);
		init();
	}

	private void init() {
    	inflater = LayoutInflater.from(MainActivity.activity);
		findView();
		addListener();
		loadQianDao();

	}

	private void findView() {
		gv = (GridView)dialog.findViewById(R.id.gridview);
	}

	private void addListener() {

    	gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> paramAdapterView,
					View paramView, int paramInt, long paramLong) {
				
				//String str =  ((String)gv.getAdapter().getItem(paramInt));
				
			}
		});
	
	}
	
	private void loadQianDao() {
		gv.setAdapter(new QianDaoAdapter()); 
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {

		switch (event.getAction()) {

		case MotionEvent.ACTION_UP:

			break;

		}
		return false;
	}


}
