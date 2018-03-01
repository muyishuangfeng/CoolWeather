package com.tianyu.customgps;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button mBtnCity;
	Button mBtnNext;
	SharedPreferencesUtil mPreferencesUtil;
	// GPS标记
	private boolean mGpsFlag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		getGpsposition();
	}

	private void initView() {
		mPreferencesUtil = new SharedPreferencesUtil(this);
		mBtnCity = (Button) findViewById(R.id.btn_main_city);
		// 设置城市名
		mBtnCity.setText(mPreferencesUtil.getcityname());
		System.out.println(mPreferencesUtil.getcityname());
		mBtnNext = (Button) findViewById(R.id.btn_main_next);
		mBtnNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						RepairActivity.class);
				intent.putExtra("Longitude", mPreferencesUtil.getLongitude());
				intent.putExtra("Latitude", mPreferencesUtil.getLatitude());
				intent.putExtra("username", mPreferencesUtil.getcityname()
						.trim());
				startActivity(intent);
			}
		});
	}

	/**
	 * Handler
	 */
	@SuppressLint("HandlerLeak")
	private final Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case MessageBox.GET_QUERYGPS_SU: {// 定位
				GpsModel gpsbean = (GpsModel) msg.obj;
				mPreferencesUtil.saveString("cityname", gpsbean.getCity_name());
				SaveShareThread saveapthread = new SaveShareThread("cityname",
						mPreferencesUtil.getcityname(), mPreferencesUtil);
				saveapthread.execute();

				SaveShareThread saveapthreadef = new SaveShareThread(
						"gps_Longitude", gpsbean.getLongitude() + "",
						mPreferencesUtil);
				saveapthreadef.execute();

				SaveShareThread saveapthreadg = new SaveShareThread(
						"gps_Latitude", gpsbean.getLatitude() + "",
						mPreferencesUtil);
				saveapthreadg.execute();
			}
				break;

			default:
				break;
			}
		};
	};

	/**
	 * 获取gps坐标
	 */

	private void getGpsposition() {

		mGpsFlag = false;
		GetGpsThread mGpsThread = new GetGpsThread(this, handler, "50",
				mPreferencesUtil.getUserName());
		mGpsThread.start();

	}

}
