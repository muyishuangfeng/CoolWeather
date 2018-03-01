package com.tianyu.customgps;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;

public class GetGpsThread extends Thread {
	private final MyLocationListenner myListener = new MyLocationListenner();
	private final Handler handler;
	private final LocationClient mLocClient;
	private String getgpstime = "0";
	private final Context context;
	private final String username;

	public GetGpsThread(Context context, Handler handler, String getgpstime,
			String username) {
		super();
		this.handler = handler;
		this.getgpstime = getgpstime;
		this.context = context;
		this.username = username;
		mLocClient = new LocationClient(context);
		mLocClient.registerLocationListener(myListener);
	}

	@Override
	public void run() {
		super.run();
		InitLocation();
		if (mLocClient.isStarted()) {
			mLocClient.stop();
		}
		mLocClient.start();

	}

	private void sendMessage(int what, Object obj) {
		Message msg = new Message();
		msg.what = what;
		msg.obj = obj;
		handler.sendMessage(msg);
	}

	protected void onStop() {
		mLocClient.unRegisterLocationListener(myListener);
		mLocClient.stop();
		super.stop();
	}

	private class MyLocationListenner implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			// map view 销毁后不在处理新接收的位置
			if (location == null
					|| location.getLocType() == BDLocation.TypeServerError)
				return;
			// 经纬度和城市
			GpsModel getgpsinfo = new GpsModel();
			if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
				getgpsinfo.setCity_name(location.getCity());
				getgpsinfo.setLongitude(location.getLongitude());
				getgpsinfo.setLatitude(location.getLatitude());
				Util.debug("gps posi " + location.getCity());

			} else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
				getgpsinfo.setCity_name(location.getCity());
				getgpsinfo.setLongitude(location.getLongitude());
				getgpsinfo.setLatitude(location.getLatitude());
				Util.debug("net posi su" + location.getCity());

			} else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
				getgpsinfo.setCity_name(location.getCity());
				getgpsinfo.setLongitude(location.getLongitude());
				getgpsinfo.setLatitude(location.getLatitude());
				Util.debug("offline posi su" + location.getCity());
			} else if (location.getLocType() == BDLocation.TypeServerError) {
				Util.debug("服务端网络定位失败");

			} else if (location.getLocType() == BDLocation.TypeNetWorkException) {
				Util.debug("网络不同导致定位失败，请检查网络是否通畅");

			} else if (location.getLocType() == BDLocation.TypeCriteriaException) {
				Util.debug("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");

			}

			sendMessage(MessageBox.GET_QUERYGPS_SU, getgpsinfo);
			if (getgpstime.equals("0")) {
				mLocClient.stop();
			}

		}

		public void onReceivePoi(BDLocation poiLocation) {
		}
	}

	// 定位参数设置

	private void InitLocation() {
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);// 设置定位模式
		option.setCoorType("bd09ll");// 返回的定位结果是百度经纬度，默认值gcj02
		option.setOpenGps(true); // 打开gps
		int span = 50;
		option.setScanSpan(span);// 设置发起定位请求的间隔时间为5000ms
		option.setIsNeedAddress(true);
		mLocClient.setLocOption(option);
	}

}
