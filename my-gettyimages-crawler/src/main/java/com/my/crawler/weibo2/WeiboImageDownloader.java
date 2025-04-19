package com.my.crawler.weibo2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeiboImageDownloader {

	public static String getImageName(String urlStr) {
		if (urlStr.contains("livephoto=")) {
			int index = urlStr.lastIndexOf("%2f");
			if (index == -1) {
				index = urlStr.lastIndexOf("%2F");
			}
			return urlStr.substring(index + "%2f".length());
		}

		int index = urlStr.lastIndexOf("/");

		int endIndex = urlStr.indexOf("?");
		if (endIndex == -1) {
			endIndex = urlStr.length();
		}
		String fileName = urlStr.substring(index + 1, endIndex);
		return fileName;
	}

	public static String getImageName(String urlStr, String dateStr) {
		return dateStr + "-" + getImageName(urlStr);
	}

	public static boolean downloadFormPicUrlByConnection(URL url, File imgFile) {
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置超时间为3秒
			conn.setConnectTimeout(5 * 1000);
			// 防止屏蔽程序抓取而返回403错误
//			conn.setRequestProperty("User-Agent",
//					"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:106.0) Gecko/20100101 Firefox/106.0");
//			conn.setRequestProperty("Accept", "https://wx1.sinaimg.cn/large/005Mno6Aly1h7q1mzwd8gj32m83xcnpi.jpg");
//			conn.setRequestProperty("referer", "https://weibo.com/u/5295502496?tabtype=album&uid=5295502496&index=0");

			conn.setRequestProperty("Host", "wx1.sinaimg.cn");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/117.0");
			conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
			conn.setRequestProperty("Referer", "https://weibo.com/");
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
			conn.setRequestProperty("Sec-Fetch-Dest", "document");
			conn.setRequestProperty("Sec-Fetch-Mode", "navigate");
			conn.setRequestProperty("Sec-Fetch-Site", "same-origin");
			conn.setRequestProperty("Sec-Fetch-User", "?1");
			conn.setRequestProperty("TE", "trailers");
			conn.setRequestProperty("If-Modified-Since", "Mon, 08 Jul 2013 18:06:40 GMT");
			conn.setRequestProperty("If-None-Match", "\"1-58df2d43132552140742a1e04d7c15ba\"");
			conn.setRequestProperty("Pragma", "no-cache");
			conn.setRequestProperty("Cache-Control", "no-cache");

			// 得到输入流
			InputStream inputStream = conn.getInputStream();
			byte[] getData = readInputStream(inputStream);
			try (FileOutputStream fos = new FileOutputStream(imgFile)) {
				fos.write(getData);
			}
			if (inputStream != null) {
				inputStream.close();
			}
		} catch (IOException ex) {
			System.err.println(url);
			return false;
		}
		return true;
	}

	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		String urlStr = "https://wx4.sinaimg.cn/large/c277b4f6ly1hknblkuicpj244e60v4qu.jpg";
		urlStr = "https://f.video.weibocdn.com/o0/zwehasOXlx07SmKKkcbS01041201pY7J0E010.mp4"
				+ "?label=mp4_1080p&template=1080x1080.null&trans_finger=29b4e2632eecf57041482ba4ad6c4dce&media_id=4717266152128619&tp=8x8A3El:YTkl0eM8&us=0&ori=1&bf=3&ot=h&lp=000026VK9x&ps=mZ6WB&uid=3VQTFt&ab=,3601-g31,3601-g34,1192-g0,1046-g2,1258-g0,6447-g4,3601-g15&Expires=1703399854&ssig=qhu8wR3Q3T&KID=unistore,video";
		String imgName = getImageName(urlStr);
		System.out.println(imgName);
		downloadFormPicUrlByConnection(new URL(urlStr), new File("D:\\temp", imgName));
	}
}
