package com.tianyu.customgps;

import android.os.AsyncTask;

public class SaveShareThread extends AsyncTask<Void, Integer, Integer> {
	private final String ippara;
	private final String invalue;
	SharedPreferencesUtil sp;

	public SaveShareThread(String para, String paravalue,
			SharedPreferencesUtil sp) {
		this.ippara = para;
		this.sp = sp;
		this.invalue = paravalue;
	}

	@Override
	protected Integer doInBackground(Void... params) {

		sp.saveString(ippara, invalue);
		System.out.println(invalue);
		return null;
	}

}
