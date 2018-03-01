package com.tianyu.customgps;

/**
 * 消息发送时的标识
 * 
 * @author shigb
 * 
 * @time 2012-12-13
 */
public class MessageBox {
	public static final int CONNECTION_ERROR = 9999;// 联网故障
	public static final int NO_DATA_ERROR = 8888;// 無數據

	// 获取数据失败
	public static final int GET_DATE_ERROR = 1001;
	// 应用升级失败
	public static final int DOWN_APP_ERROR = 1008;
	// 下载应用成功
	public static final int DOWN_APP_SU = 1009;
	// 应用升级检测成功，有新的应用
	public static final int CHECK_APP_UPDATE_SU = 1010;
	// 视频下载成功
	public static final int DOWN_VIDEO_SU = 1011;
	// 获取GPS成功
	public static final int DOWN_INTERLOCUTION_SU = 1013;
	// 上传GPS失败
	public static final int UPLOAD_INTERL_SB = 1015;
	// 登陆成功
	public static final int LOGIN_SU = 1016;
	// 密码修改成功
	public static final int UPDATE_PASSWORD_SU = 1017;
	// 密码修改失败
	public static final int UPDATE_PASSWORD_SB = 1018;
	// 串码不存在
	public static final int LOGIN_ISMINO = 1021;
	// 注册成功
	public static final int USERREG_SU = 1022;
	// 注册失败
	public static final int USERREG_ERROR = 1023;
	// 视频上传成功
	public static final int UPLOAD_VIDEO_SU = 1110;
	// 视频上传失败
	public static final int UPLOAD_VIDEO_ERROR = 1111;
	// 语音上传成功
	public static final int UPLOAD_AUDIO_SU = 1232;
	// 语音上传失败
	public static final int UPLOAD_AUDIO_ERROR = 1233;
	// 视频上传成功
	public static final int UPLOAD_VIDEOEND_SU = 1135;
	// 音频上传成功
	public static final int GET_AUDIO_SU = 1136;
	// 记录查询成功
	public static final int GET_CHECKFLOW_SU = 1137;
	// 记录查询失败
	public static final int GET_CHECKFLOW_ERROR = 1138;
	// 答题记录成功
	public static final int GET_ASKRECORD_SU = 1139;
	// 下载文件成功
	public static final int GET_DOWNLOADFILE_SU = 1145;
	// 下载文件失败
	public static final int GET_DOWNLOADFILE_ERROR = 1146;
	// 查询GPS成功
	public static final int GET_QUERYGPS_SU = 1147;
	// 查询GPS失败
	public static final int GET_QUERYGPS_ERROR = 1148;
	// 查询排名失败
	public static final int GET_RANK_ERROR = 1149;
	// 查询排名成功
	public static final int GET_RANK_SU = 1150;
	// 获取品牌失败
	public static final int GET_BRADN_ERROR = 1151;
	// 获取品牌成功
	public static final int GET_BRADN_SU = 1152;
	// 获取车型成功
	public static final int GET_MODEL_SU = 1153;
	// 获取车型失败
	public static final int GET_MODEL_ERROR = 1154;
	// 获取GPS成功
	public static final int GET_GPS_SU = 1155;
	// 获取GPS失败
	public static final int GET_GPS_ERROR = 1156;
	// 获取GPS线程成功
	public static final int GET_GPSTHREAD_SU = 1157;
	// 获取GPS线程成功
	public static final int GET_GPSTHREAD_ERROR = 1158;
	// info上传成功
	public static final int UPLOAD_INFOGPS_RESULT_SU = 1159;
	// info上传失败
	public static final int UPLOAD_INFOGPS_RESULT_ERROR = 1160;
	// 获取所有GPS结果成功
	public static final int GET_ALLGPS_RESULT_SU = 1161;
	// 获取所有GPS结果失败
	public static final int GET_ALLGPS_RESULT_ERROR = 1162;
	// 采集信息上传失败
	public static final int UPDATE_INFOMATION_ERROR = 1163;
	// 采集信息上传成功
	public static final int UPDATE_INFOMATION_SU = 1164;
	// 报价成功
	public static final int GET_CHECK_SU = 1165;
	// 报价失败
	public static final int GET_CHECK_ERROR = 1166;
	// 上传图片失败
	public static final int UPLOAD_PHOTO_ERROR = 1167;
	// 上传图片成功
	public static final int UPLOAD_PHOTO_SU = 1168;
	// 获取GPS采集成功
	public static final int GET_GPS_COLLECTION_SU = 1169;
	// 获取本地GPS成功
	public static final int GET_GPS_LOCATION_SU = 1170;
	// 获取所有GPS成功
	public static final int GET_ALLGPSC_RESULT_SU = 1171;
	// 获取所有GPS失败
	public static final int GET_ALLGPSC_RESULT_ERROR = 1172;
	// 获取我要维修GPS成功
	public static final int GET_MAINTAIN_GPS_SU = 1173;
	// 获取预览成功
	public static final int SEARCH_GPS_RESULT_SU = 1174;
	// 获取预览成功
	public static final int SEARCH_GPS_RESULT_ERROR = 1175;
	// 上传回复失败
	public static final int UPLOAD_REPLAY_ERROR = 1176;
	// 上传回复成功
	public static final int UPLOAD_REPLAY_SU = 1177;
	// 上传评论失败
	public static final int UPLOAD_EVALUAME_ERROR = 1178;
	// 上传评论成功
	public static final int UPLOAD_EVALUAME_SU = 1179;
	// 获取回复失败
	public static final int GET_REPLAY_ERROR = 1180;
	// 获取回复成功
	public static final int GET_REPLAY_SU = 1181;
	// 上传报价成功
	public static final int UPLOAD_PRICE_SU = 1182;
	// 上传报价失败
	public static final int UPLOAD_PRICE_ERROR = 1183;
	// 获取报价成功
	public static final int GET_PRICE_SU = 1184;
	// 获取报价失败
	public static final int GET_PRICE_ERROR = 1185;
	// 获取问题描述成功
	public static final int GET_QUESTION_SU = 1186;
	// 获取问题描述失败
	public static final int GET_QUESTION_ERROR = 1187;
	// 获取评论失败
	public static final int GET_EVALUAME_ERROR = 1188;
	// 获取评论成功
	public static final int GET_EVALUAME_SU = 1189;
	// 注册车主失败
	public static final int USER_CAR_PHOTO_ERROR = 1190;
	// 车主已经注册
	public static final int USER_CAR_PHOTO_READY = 1128;
	// 注册车主成功
	public static final int USER_CAR_PHOTO_SU = 1191;
	// 获取登录类型失败
	public static final int GET_LOGIN_TYPE_ERROR = 1192;
	// 获取登录类型成功
	public static final int GET_LOGIN_TYPE_SU = 1193;
	// 登录失败
	public static final int LOGIN_ERROR = 1194;
	// 已经注册
	public static final int USERREG_READY = 1195;
	// 获取维修记录失败
	public static final int GET_REPORT_ERROR = 1196;
	// 获取维修记录成功
	public static final int GET_REPORT_SU = 1197;
	// 获取抢单失败
	public static final int GET_GRAB_ORDER_ERROR = 1198;
	// 获取抢单成功
	public static final int GET_GRAB_ORDER_SU = 1199;
	// 抢单失败
	public static final int UPLOAD_GRAB_FLAG_ERROR = 1120;
	// 抢单成功
	public static final int UPLOAD_GRAB_FLAG_SU = 1121;
	// 获取我的订单失败
	public static final int GET_MY_ORDER_ERROR = 1122;
	// 获取我的订单成功
	public static final int GET_MY_ORDER_SU = 1123;
	// 获取预约ID失败
	public static final int GET_SPEAK_ERROR = 1124;
	// 获取预约ID成功
	public static final int GET_SPEAK_SU = 1125;
	// 上传预约失败
	public static final int UPDATE_SPEAK_ERROR = 1126;
	// 上传预约成功
	public static final int UPDATE_SPEAK_SU = 1127;
}
