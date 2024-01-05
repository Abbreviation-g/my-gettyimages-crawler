package com.my.crawler.weibo2;

import static com.my.crawler.weibo.WeiboImageDownloader.downloadFormPicUrlByConnection;
import static com.my.crawler.weibo.WeiboImageDownloader.getImageName;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class 根据picvideolog开始下载 {
	public static void main(String[] args) throws IOException {
		start(new File("F:\\weibo_log\\-傅晶-"));
	}

	public static void start(File folder) throws IOException {
		File picVideoLogFile = new File(folder, Constants.PICS_VIDEOS_FILE_NAME);
		if (!picVideoLogFile.exists()) {
			System.err.println(picVideoLogFile + "\t not exits.");
			return;
		}
		String content = Files.readString(picVideoLogFile.toPath());
		if (content.isEmpty()) {
			System.err.println(picVideoLogFile + "\t is empty.");
			return;
		}
		JSONObject object = JSON.parseObject(content);
		if (object.isEmpty()) {
			System.err.println(picVideoLogFile + "\t is empty.");
			return;
		}
		Set<String> keySet = object.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String dateId = (String) iterator.next();
//			List<String> pics = 
			JSONObject singleObject = object.getJSONObject(dateId);
			File dateIdFolder = new File(folder, dateId);
			if (singleObject.containsKey(Constants.PICS_ID)) {
				JSONArray picArray = singleObject.getJSONArray(Constants.PICS_ID);
				List<String> pics = picArray.toJavaList(String.class);

				startDownload(pics, dateIdFolder);
			}
			if (singleObject.containsKey(Constants.VIDEOS_ID)) {
				JSONArray videoArray = singleObject.getJSONArray(Constants.VIDEOS_ID);
				List<String> videos = videoArray.toJavaList(String.class);

				startDownload(videos, dateIdFolder);
			}
		}
	}

	private static void startDownload(List<String> urls, File folder) throws IOException {
		for (String line : urls) {
			File imgFile = new File(folder, getImageName(line));
			if (imgFile.exists()) {
				System.out.println(imgFile + "\t" + "exits");
				continue;
			}
			boolean result = downloadFormPicUrlByConnection(new URL(line), imgFile);
			if (result) {
				System.out.println(imgFile + "\t" + "done");
			} else {
				System.out.println(imgFile + "\t" + "failed");
			}
		}
	}
}
