package com.tianyu.customgps;

/**
 * 接口地址
 * 
 * @author Administrator
 * @time 2012-12-13
 */
public class ConnectURL {
	// 手机串码
	public static String IMEI = "357143043031589";
	// public static String IP_POST = "http://siptalkserver.imwork.net:8088";//
	public static String IP_POST = "http://192.168.0.117:8080";//
	//
	public static String UDP_POST = IP_POST;// UD
	// 地址
	public static String ADD_ADDERROR_RUL = "/pctoad.do?op=erroradd&";
	// 登陆接口
	public static String LOGIN_URL = "/Car/logininfo.action?method=userLogin&userNo&userPass";
	// 登录类型接口
	public static String LOGIN_TYPE_URL = "/Car/logintype.action?method=LoginType&user_no=";
	// 注册接口
	public static String REGISTER_URL = "/Car/reginfo.action?method=UserReg";
	// 上传视频接口
	public static String Upload_Img_URL = "/lovecar/pctoad.do?op=uploadimg";
	// 应用升级检测接口
	public static String APP_UPDATE_URL = "/coalinfo/pctoad.do?op=ptaapk";
	// 修改密码接口
	public static String UPDATE_PASSWORD_RUL = "/Car/chainfo.action?method=Change";
	// 获取品牌
	public static String GET_BRAND_URL = "/Car/brandinfo.action?method=VehicleBrand";
	// 获取车型
	public static String GET_MODEL_URL = "/Car/modelinfo.action?method=VehicleModel";
	// 获取gpsURL
	public static String GET_INFOGPSPOSI_URL = "/Car/collectinfo.action?method=Information";
	// 上传采集结果
	public static String UPLOAD_INFORMATION_CONTENT_URL = "/Car/collectioninfo.action?method=AddInforCollection";
	// 问题描述
	public static String UPLOAD_Image_URL = "/Car/descinfo.action?method=Description";
	// 获取gps数量接口
	public static String GET_INFOGPSPOSICOUNT_URL = "/Car/collectinfo.action?method=Information";
	// 获取周边的车厂
	public static String GET_GPSPOSI_URL = "/Car/collectinfo.action?method=Information";
	// 上传回复
	public static String UPLOAD_COMMENT_URL = "/Car/continfo.action?method=AddReply";
	// 上传评论
	public static String UPLOAD_EVALUAME_URL = "/Car/addcontinfo.action?method=AddComment";
	// 获取评论
	public static String GET_EVALUAME_URL = "/Car/commentinfo.action?method=Comment&user_no=";
	// 获取回复
	public static String GET_REPLAY_URL = "/Car/replayinfo.action?method=ReplayInfo&user_content=";
	// 获取问题描述接口
	public static String GET_QUESTION_URL = "/Car/descsearchinfo.action?method=DescSearch&oper_no=";
	// 查询报价接口
	public static String GET_PRICE_URL = "/Car/priceinfo.action?method=PriceSearch&user_no=";
	// 上传报价接口
	public static String UPLOAD_PRICE_URL = "/Car/insertPriceinfo.action?method=InsertPrice";
	// 查询采集接口
	public static String GET_INFORMATION_URL = "/Car/collectinfo.action?method=Information&id=";
	// 抢单接口
	public static String GET_GRAB_ORDER_URL = "/Car/descsearchinfo.action?method=DescSearch";
	// 上传抢单接口
	public static String UPDATE_GRAB_FLAG_URL = "/Car/grabinfo.action?method=GrabChange";
	// 获取我的订单接口
	public static String GET_MY_ORDER_URL = "/Car/grabsearchinfo.action?method=GrabSearch&repair_no=";
	// 根据类型查询位置
	public static String GET_SERARCH_GPS_URL = "/Car/gpssearchtype.action?method=GpsSearchType";
	// 维修记录
	public static String GET_REPAIR_REPORT_URL = "/Car/repairreportinfo.action?method=RepairReport&oper_no=";
	// 获取当前预约ID
	public static String GET_REPAIR_SPEAK_URL = "/Car/repairspeakinfo.action?method=RepairSpeak";
	// 上传预约时间接口
	public static String UPDATE_SPEAK_TIME_URL = "/Car/speaktimeinfo.action?method=SpeakTimeChange";
}
