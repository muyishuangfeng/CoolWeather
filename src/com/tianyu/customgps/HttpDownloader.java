package com.tianyu.customgps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络资源下载类。<BR>
 * 
 * @Create
 * @Create Date: 2012-12-13
 **/
public class HttpDownloader {

	// 网络资源地址
	private URL url = null;
	// 新建connection对象 默认值为:null
	HttpURLConnection httpUrlconnection = null;

	/**
	 * 构造函数
	 */
	public HttpDownloader() {
	}

	/**
	 * 根据传入的URL参数下载网络资源
	 * 
	 * @param url
	 *            网络资源地址
	 * @return 返回下载的数据
	 */
	public String download(String urlStr) {
		// 存储http请求返回的信息 并以String 类型返回
		StringBuffer sb = new StringBuffer();
		// 临时存储信息
		String line = null;
		// 缓存字符流信息
		// bufferedreader 可以一次读取大量的数据，减少了io次数，提升效率
		BufferedReader buffer = null;

		// 同过url字符串转化成url对象
		try {
			url = new URL(urlStr);

			// 根据URL的请求协议生成的URLconnection类

			httpUrlconnection = (HttpURLConnection) url.openConnection();

			// 设置链接超时时间为5秒
			httpUrlconnection.setConnectTimeout(5000);
			// 设置读取超时时间为5秒
			httpUrlconnection.setReadTimeout(5000);
			// 允许connection读入 默认值为:true 没特殊要求可以不写
			// httpUrlconnection.setDoInput(true);
			// httpUrlconnection.setRequestProperty("Content-Type",
			// "text;charset=UTF-8");

			// 判断链接状态 HttpURLConnection.HTTP_OK为链接正常 值为200
			if (httpUrlconnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				// 链接出错 返回空
				return null;
			}

			// 通过getInputStream() 发送请求 把获得的字节流转换成字符流 并存储在appBufferedReader
			buffer = new BufferedReader(new InputStreamReader(
					httpUrlconnection.getInputStream()));

			// 从buffer中逐行取出数据 并添加到sb中 直到 buffer.readLine() 为空
			while ((line = buffer.readLine()) != null) {
				// 向sb中追加信息
				sb.append(line);
			}

		} catch (MalformedURLException e) {
			// url转换失败 返回null
			return null;

		} catch (IOException e) {
			// connection对象生成异常 返回空
			// 获取链接状态异常 返回空
			// 通过getInputStream() 发送请求异常 返回null
			// buffer中逐行取出数据 返回null
			return null;

		} catch (Exception e) {
			// 其他异常 返回空
			return null;
		}

		finally {
			try {
				// 关闭流
				buffer.close();
				httpUrlconnection.disconnect();
			} catch (Exception e) {
				// 关闭流失败 清空sb中的内容
				sb = null;
			}
		}
		String httpDownStr = null;
		if (sb != null) {
			httpDownStr = sb.toString();
		}
		// 返回下载结果
		return httpDownStr;
	}
}
