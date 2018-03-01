package com.tianyu.customgps;

import android.app.Application;
import android.os.Process;
import android.os.Vibrator;
import android.util.Log;

public class LocationApplation extends Application {
	private String mData;
	public String mTv;
	public Vibrator mVibrator01;
	public static String TAG = "gps";

	boolean m_bKeyRight = true;

	private static LocationApplation instance;

	public static LocationApplation getInstance() {
		return instance;
	}

	@Override
	public void onCreate() {

		MyCrashHandler handler = MyCrashHandler.getInstance();
		handler.init(this);
		Thread.setDefaultUncaughtExceptionHandler(handler);
		super.onCreate();
		instance = this;
		Log.d(TAG, "... Application onCreate... pid=" + Process.myPid());

	}

	/**
	 * 
	 * 
	 * @param str
	 */
	public void logMsg(String str) {
		try {
			mData = str;
			mTv = mData;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}