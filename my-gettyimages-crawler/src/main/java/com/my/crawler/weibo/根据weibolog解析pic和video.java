package com.my.crawler.weibo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class 根据weibolog解析pic和video {
	public static final String SINGLE_LOG_FILENAME = "single_weibo.log";
	public static final String WEIBO_LOG_FILENAME = "weibo.log";
	public static final String VIDEO_LOG_FILENAME = "video.log";
	public static final String PICTURE_LOG_FILENAME = "pic.log";
	public static final String FOLDER_NAME_FORMAT = "%04d-%02d-%02d-%s";

	public static void main(String[] args) throws IOException {
		String folderPath = "D:\\weibo\\钟楚曦";

		folderPath = "D:\\weibo2\\唐艺昕";
//		uid = "5617960493";
//		folderPath = "D:\\weibo2\\徐璐工作室";
//		uid = "1197755162";
//		folderPath = "D:\\weibo2\\韩雪";
//		uid = "2174204211";
//		folderPath = "D:\\weibo2\\唐嫣工作室";
		folderPath = "F:\\weibo_log\\梦醒忒远";

		splitWeibosToDateIdFolder(new File(folderPath));
	}

	public static void splitWeibosToDateIdFolder(File folder) throws IOException {
		File weiboLogFile = new File(folder, WEIBO_LOG_FILENAME);
		if (!weiboLogFile.exists()) {
			return;
		}
		String content = Files.readString(weiboLogFile.toPath());
		try {
			JSONArray array = JSON.parseArray(content);

			createYearMonthDayWeiboFolders(array, folder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void splitWeibosToDateIdFolder(JSONArray array, File folder) throws IOException {
		File weiboLogFile = new File(folder, WEIBO_LOG_FILENAME);
		if (!weiboLogFile.exists()) {
			return;
		}
		try {
			createYearMonthDayWeiboFolders(array, folder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createYearMonthDayWeiboFolders(JSONArray array, File folder) throws IOException {
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);

			File dateIdFolder = getYearMonthDayIdFolder(object, folder);
			if (dateIdFolder.exists()) {
				System.out.println(dateIdFolder + "\t exits.");
				continue;
			}

			List<String> videos = new ArrayList<>();
			List<String> pics = new ArrayList<>();
			getVideos(object, videos);
			getPics(object, pics);
			getVideosPics(object, videos, pics);

			if (videos.isEmpty() && pics.isEmpty()) {
				continue;
			}

			dateIdFolder.mkdirs();
			System.out.println(dateIdFolder + "\t done.");

			if (!videos.isEmpty()) {
				Files.write(new File(dateIdFolder, VIDEO_LOG_FILENAME).toPath(), videos);
			}
			if (!pics.isEmpty()) {
				Files.write(new File(dateIdFolder, PICTURE_LOG_FILENAME).toPath(), pics);
			}
			String text = object.getString("text");
			if (text != null && !text.isBlank()) {
				String uid = object.getJSONObject("user").getString("id");
				if (uid.equals("3603256695")) {
					try {
						Files.writeString(new File(dateIdFolder, text + ".txt").toPath(), text);
					} catch (InvalidPathException e) {
						Files.writeString(new File(dateIdFolder, WEIBO_LOG_FILENAME).toPath(), text);
					}
				} else {
					Files.writeString(new File(dateIdFolder, SINGLE_LOG_FILENAME).toPath(), text);
				}
			}
		}

		try (PrintWriter writer = new PrintWriter(new FileWriter(new File(folder, WEIBO_LOG_FILENAME)))) {
			writer.println(array.toString(SerializerFeature.PrettyFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static File getYearMonthDayIdFolder(JSONObject object, File folder) throws IOException {
		String created_at = object.getString("created_at");
		String id = object.getString("id");

		@SuppressWarnings("deprecation")
		Date date = new Date(created_at);
		Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
		calendar.setTime(date);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		String dateFolderName = String.format(FOLDER_NAME_FORMAT, year, month, day, id);
		return new File(folder, dateFolderName);
	}

	private static void getVideos(JSONObject object, List<String> videos) throws IOException {
		JSONObject page_info = object.getJSONObject("page_info");
		if (page_info == null) {
			return;
		}
		Object media_info_object = page_info.get("media_info");
		if (!(media_info_object instanceof JSONObject)) {
			return;
		}

		JSONObject media_info = (JSONObject) media_info_object;
		JSONArray playbackList = media_info.getJSONArray("playback_list");
		if (playbackList == null || playbackList.isEmpty()) {
			return;
		}
		JSONObject play_info = playbackList.getJSONObject(0).getJSONObject("play_info");
		String videoUrl = play_info.getString("url");
		videos.add(videoUrl);
	}

	private static void getPics(JSONObject object, List<String> pics) throws IOException {
		JSONArray pic_ids = object.getJSONArray("pic_ids");
		if (pic_ids == null || pic_ids.isEmpty()) {
			return;
		}
//		pic_infos	
		JSONObject pic_infos = object.getJSONObject("pic_infos");
		if (pic_infos == null) {
			return;
		}

		for (int i = 0; i < pic_ids.size(); i++) {
			JSONObject pic_info = pic_infos.getJSONObject(pic_ids.getString(i));

			String type = pic_info.getString("type");
			if ("livephoto".equals(type)) {
				String videoUrl = pic_info.getString("video");
				pics.add(videoUrl);
			}
			JSONObject largest = pic_info.getJSONObject("largest");
			String url = largest.getString("url");
			pics.add(url);
		}
	}

	private static void getVideosPics(JSONObject object, List<String> pics, List<String> videos) throws IOException {
//		mix_media_info
		JSONObject mix_media_info = object.getJSONObject("mix_media_info");
		if (mix_media_info == null) {
			return;
		}
		JSONArray items = mix_media_info.getJSONArray("items");
		if (items == null || items.isEmpty()) {
			return;
		}

		for (int i = 0; i < items.size(); i++) {
			JSONObject item = items.getJSONObject(i);
			JSONObject data = item.getJSONObject("data");
			if (data == null) {
				continue;
			}
			String type = item.getString("type");
			if ("pic".equalsIgnoreCase(type)) {
				JSONObject largest = data.getJSONObject("largest");
				if (largest == null) {
					continue;
				}
				String url = largest.getString("url");

				pics.add(url);
			} else if ("video".equalsIgnoreCase(type)) {
				JSONObject media_info = data.getJSONObject("media_info");
				if (media_info == null) {
					continue;
				}
				String stream_url = media_info.getString("stream_url");

				videos.add(stream_url);
			}
		}
	}
}
