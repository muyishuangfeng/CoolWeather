package com.tianyu.customgps;

public class UploadErrorFlowThread extends Thread {

	private final String url;

	public UploadErrorFlowThread(String url) {

		this.url = url;

	}

	@Override
	public void run() {
		HttpDownloader httpDownloader = new HttpDownloader();
		String json = httpDownloader.download(url);

		if (json != null && json.equals("1")) {

		} else {

		}

		super.run();
	}

}
