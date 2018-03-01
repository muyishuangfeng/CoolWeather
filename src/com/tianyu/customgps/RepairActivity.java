package com.tianyu.customgps;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.gesture.GesturePoint;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

/**
 * 维修保养
 * 
 * @author Administrator
 * 
 */
public class RepairActivity extends Activity implements OnClickListener {
	//
	private MapView mMapView;
	// 百度地图
	private BaiduMap mBaiduMap;
	// private Marker marker;
	private SharedPreferencesUtil mPreferencesUtil;
	LocationListener mLocationListener = null;
	GesturePoint myLastPoint;
	GesturePoint myPoint;
	private String gps_Longitude, gps_Latitude;
	private String username;
	private View mConvertView;
	private float zoom_level = 21.0f;
	private float last_leve = 0;
	private SDKReceiver mReceiver;
	// 返回
	private Button mBtnLocBack;
	// 查找的结果
	String mFindResult = "";

	// 宽、高
	private int mWidth, mHeight;

	private String ls_lastareaurl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 设置全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// 在使用SDK各组件之前初始化context信息，传入ApplicationContext
		// 注意该方法要再setContentView方法之前实现
		SDKInitializer.initialize(LocationApplation.getInstance());
		setContentView(R.layout.activity_repair);
		initView();

	}

	/**
	 * 初始化控件
	 */
	private void initView() {

		mPreferencesUtil = new SharedPreferencesUtil(getApplicationContext());
		mMapView = (MapView) findViewById(R.id.map_location_view);
		mBaiduMap = mMapView.getMap();
		mBaiduMap.setMyLocationEnabled(true);

		mBtnLocBack = (Button) findViewById(R.id.btn_location_back);
		mBtnLocBack.setOnClickListener(this);

		IntentFilter iFilter = new IntentFilter();
		iFilter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
		iFilter.addAction(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
		mReceiver = new SDKReceiver();
		registerReceiver(mReceiver, iFilter);

		Intent intent = getIntent();
		gps_Longitude = intent.getStringExtra("Longitude");
		gps_Latitude = intent.getStringExtra("Latitude");
		username = intent.getStringExtra("username");

		LayoutInflater factory = LayoutInflater.from(this);
		// 把视图转换成Bitmap
		// 再转换成Drawable
		mConvertView = factory.inflate(R.layout.gps_overlay_view, null);

		if (mPreferencesUtil.getzoonlevel().equals("-1")) {
			zoom_level = 16.0f;
		} else {
			zoom_level = Float.valueOf(mPreferencesUtil.getzoonlevel());
		}

		last_leve = Math.round(zoom_level);
		MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(zoom_level - 1);
		mBaiduMap.setMapStatus(msu);

		LatLng ll = new LatLng(Double.valueOf(gps_Latitude),
				Double.valueOf(gps_Longitude));

		MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);

		ImageView markerico = (ImageView) mConvertView
				.findViewById(R.id.imageView_gps_overlay_ico);

		markerico.setBackgroundResource(R.drawable.iconmarka);

		TextView initext = (TextView) mConvertView
				.findViewById(R.id.textView_gps_overlay_title);

		initext.setText(username);

		OverlayOptions ownposi = new MarkerOptions().position(ll).icon(
				BitmapDescriptorFactory
						.fromBitmap(getBitmapFromView(mConvertView)));

		mBaiduMap.addOverlay(ownposi);
		mBaiduMap.animateMapStatus(u);

		/**
		 * 地图上的标志点击事件
		 */
		mBaiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {
			@Override
			public boolean onMarkerClick(final Marker marker) {

				return true;
			}
		});
		mBaiduMap.setOnMapStatusChangeListener(new OnMapStatusChangeListener() {
			@Override
			public void onMapStatusChangeStart(MapStatus status) {

			}

			/**
			 * 地图状态变化中
			 * 
			 * @param status
			 *            当前地图状态
			 */
			@Override
			public void onMapStatusChange(MapStatus status) {
			}

			/**
			 * 地图状态改变结束
			 * 
			 * @param status
			 *            地图状态改变结束后的地图状态
			 */
			@Override
			public void onMapStatusChangeFinish(MapStatus status) {

				int li_level = (int) status.zoom;

				if (li_level >= 18) {

					Point pt = new Point();
					pt.x = 0;
					pt.y = 0;
					LatLng ll = mBaiduMap.getProjection()
							.fromScreenLocation(pt);

					pt.x = mWidth;
					pt.y = mHeight;
					// LatLng lly =
					// mBaiduMap.getProjection().fromScreenLocation(
					// pt);
					// ls_lastareaurl = "&inputa=" + ll.latitude + "&inputb="
					// + lly.latitude + "&inputd=" + ll.longitude
					// + "&inpute=" + lly.longitude;

					if (mBaiduMap != null) {
						mBaiduMap.clear();
					}

				}
				last_leve = li_level;

			}

		});

	}

	/**
	 * 把View转换为bitmap
	 * 
	 * @param view
	 * @return
	 */
	public static Bitmap getBitmapFromView(View view) {
		view.destroyDrawingCache();

		view.measure(View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
				.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
		view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
		view.setDrawingCacheEnabled(true);
		Bitmap bitmap = view.getDrawingCache(true);
		return bitmap;
	}

	/**
	 * 广播
	 * 
	 * @author Administrator
	 * 
	 */
	public class SDKReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String s = intent.getAction();
			Log.d("aaa", "action: " + s);

			if (s.equals(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR)) {
				Log.d("aaa", "请在 AndroidManifest.xml 文件中检查 key 设置: ");
			} else if (s
					.equals(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR)) {
				Toast.makeText(getBaseContext(), "网络出错:", 1).show();
				Log.d("aaa", "网络出错: ");

			}
		}

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_location_back: {// 返回

			finish();
		}

		default:
			break;
		}

	}

	@Override
	protected void onPause() {
		// MapView的生命周期与Activity同步，当activity挂起时需调用MapView.onPause()
		if (mMapView != null) {
			mMapView.onPause();
		}

		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mMapView.onResume();
	}

	public void clearOverlay(View view) {
		mBaiduMap.clear();
	}

	public void resetOverlay(View view) {
		clearOverlay(null);

	}

	@Override
	protected void onDestroy() {
		// MapView的生命周期与Activity同步，当activity销毁时需调用MapView.destroy()
		mMapView.onDestroy();
		mMapView = null;
		unregisterReceiver(mReceiver);
		super.onDestroy();

		System.out.println("==================");

	}
}
