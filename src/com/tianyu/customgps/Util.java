package com.tianyu.customgps;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPOutputStream;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.SmsMessage;
import android.util.Log;

public class Util {
	public static byte[] concat(byte[] paramArrayOfByte1,
			byte[] paramArrayOfByte2) {
		int i = paramArrayOfByte1.length;
		int j = paramArrayOfByte2.length;
		byte[] arrayOfByte = new byte[i + j];
		int k = arrayOfByte.length;
		int l = paramArrayOfByte1.length;
		int i1 = 0;
		if (i1 >= k)
			return arrayOfByte;
		if (i1 < l) {

			arrayOfByte[i1] = paramArrayOfByte1[i1];
		}
		while (true) {
			++i1;

			int i3 = i1 - l;
			// int i4 = paramArrayOfByte2[i3];
			arrayOfByte[i1] = paramArrayOfByte2[i3];
			return arrayOfByte;
		}

	}

	public static void debug(String paramString) {
		Log.e("手机对讲", paramString);
	}

	public static void debugzx(String paramString) {
		Log.e("占线", paramString);
	}

	public static void error(String paramString) {
		Log.e("手机对讲", paramString);
	}

	public static String formatDate(long date) {
		Date currentdate = new Date(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(currentdate);
	}

	public static Date StrToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;

		try {
			date = format.parse(str);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	public static String formatDatetime(long date) {
		Date currentdate = new Date(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(currentdate);
	}

	public static boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	public static int HexToDec(String strvalue) {
		try {

			int sum = 0, tmp = 0;
			char args[] = strvalue.toCharArray();
			for (int i = 0; i < args.length; i++) {

				if (args[i] >= '0' && args[i] <= '9')
					tmp = args[i] - '0';
				else if (args[i] >= 'A' && args[i] <= 'F')
					tmp = args[i] - 'A' + 10;
				else {
					System.out.println("有非法字符");
					break;
				}
				sum = sum * 16 + tmp;
			}
			return sum;

		} catch (Exception e) {

			return 0;
		}
	}

	public static String encrypt(String str) {
		try {
			if (str == null || str.length() == 0) {
				return str;
			}
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(out);
			str = new String(str.getBytes(), "utf-8");
			gzip.write(str.getBytes());
			gzip.close();
			return out.toString("ISO-8859-1");
		} catch (Exception e) {

			return "";
		}

	}

	public static void killProcess(String pid) {
		Process sh = null;
		DataOutputStream os = null;
		try {
			sh = Runtime.getRuntime().exec("su");
			os = new DataOutputStream(sh.getOutputStream());
			final String Command = "kill -9 " + pid + "\n";
			os.writeBytes(Command);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			sh.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static String toChinese(String strvalue) {
		try {
			if (strvalue == null || strvalue.equals("")) {
				String s = "";
				return s;
			}
			strvalue = new String(strvalue.getBytes(), "gbk");
			// strvalue = strvalue.replace(',', '\uFF0C');
			// strvalue = strvalue.replace('\'', '\u2018');
			// if(strvalue.substring(0, 1).equals("\""))
			// strvalue =
			// "".concat(String.valueOf(String.valueOf(strvalue.substring(1,
			// strvalue.length()))));
			String s1 = strvalue;
			return s1;
		} catch (Exception e) {
			String s2 = "";
			return s2;
		}
	}

	public static byte[] toByteArray(int iSource, int iArrayLen) {
		byte[] bLocalArr = new byte[iArrayLen];
		for (int i = 0; (i < 4) && (i < iArrayLen); i++) {
			bLocalArr[i] = (byte) (iSource >> 8 * i & 0xFF);
		}
		return bLocalArr;
	}

	public final static String trimSmsNumber(String prefix, String number) {
		String s = number;

		if (prefix.length() > 0 && number.startsWith(prefix)) {
			s = number.substring(prefix.length());
		}

		return s;
	}

	public final static SmsMessage[] getMessagesFromIntent(Intent intent) {
		Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
		byte[][] pduObjs = new byte[messages.length][];
		for (int i = 0; i < messages.length; i++) {
			pduObjs[i] = (byte[]) messages[i];
		}

		byte[][] pdus = new byte[pduObjs.length][];
		int pduCount = pdus.length;
		SmsMessage[] msgs = new SmsMessage[pduCount];

		for (int i = 0; i < pduCount; i++) {
			pdus[i] = pduObjs[i];
			msgs[i] = SmsMessage.createFromPdu(pdus[i]);
		}

		return msgs;
	}

}