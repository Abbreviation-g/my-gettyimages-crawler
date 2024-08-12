package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class WeiboArrayToPicsVideos {
	public static void main(String[] args) throws IOException {
		String folderPath = "F:\\weibo_log\\童瑶";
		File weiboLogFile = new File(folderPath, Constants.WEIBO_ARRAY_FILE_NAME);
		JSONObject jsonObject = weiboArrayLogToPicsVideos(weiboLogFile);
		System.out.println(jsonObject.toString(SerializerFeature.PrettyFormat));
	}

	public static JSONObject mergeOldAndNew(JSONObject oldObject, JSONObject newObject) {
		JSONObject allWeiboPicsVideos = new JSONObject(new TreeMap<>());

		Iterator<String> oldIterator = oldObject.keySet().iterator();
		while (oldIterator.hasNext()) {
			String oldId = (String) oldIterator.next();
			allWeiboPicsVideos.put(oldId, oldObject.get(oldId));
		}

		Iterator<String> newIterator = newObject.keySet().iterator();
		while (newIterator.hasNext()) {
			String newId = (String) newIterator.next();
			allWeiboPicsVideos.put(newId, newObject.get(newId));
		}

		return allWeiboPicsVideos;
	}

	public static JSONObject weiboArrayLogToPicsVideos(File weiboLogFile) throws IOException {
		if (!weiboLogFile.exists()) {
			return null;
		}
		String content = Files.readString(weiboLogFile.toPath());
		JSONArray array = JSON.parseArray(content);
		return weiboArrayToPicsVideos(array);
	}

	public static JSONObject weiboArrayToPicsVideos(JSONArray array) {
		JSONObject allWeiboPicsVideos = new JSONObject(new TreeMap<>());
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			String idStr = object.getString("id");

			final String dateId = getYearMonthDayId(object, idStr);

			final List<String> videos = new ArrayList<>();
			final List<String> pics = new ArrayList<>();
			getVideos(object, videos);
			getPics(object, pics);
			getVideosPics(object, videos, pics);

			if (videos.isEmpty() && pics.isEmpty()) {
				continue;
			}
			String text = object.getString(Constants.TEXT_ID);

			JSONObject singleObject = new JSONObject();
			if (!videos.isEmpty()) {
				singleObject.put(Constants.VIDEOS_ID, videos);
			}
			if (!pics.isEmpty()) {
				singleObject.put(Constants.PICS_ID, pics);
			}
			singleObject.put(Constants.TEXT_ID, text);

			allWeiboPicsVideos.put(dateId, singleObject);
		}
		return allWeiboPicsVideos;
	}

	public static JSONObject weiboArrayToPicsVideos(JSONArray array, boolean needUserName) {
		JSONObject allWeiboPicsVideos = new JSONObject(new TreeMap<>());
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			String idStr = object.getString("id");

			final String dateId = getYearMonthDayId(object, idStr);

			final List<String> videos = new ArrayList<>();
			final List<String> pics = new ArrayList<>();
			getVideos(object, videos);
			getPics(object, pics);
			getVideosPics(object, videos, pics);

			if (videos.isEmpty() && pics.isEmpty()) {
				continue;
			}
			String text = object.getString(Constants.TEXT_ID);

			JSONObject singleObject = new JSONObject();
			if (!videos.isEmpty()) {
				singleObject.put(Constants.VIDEOS_ID, videos);
			}
			if (!pics.isEmpty()) {
				singleObject.put(Constants.PICS_ID, pics);
			}
			singleObject.put(Constants.TEXT_ID, text);

			JSONObject userJsonObject = object.getJSONObject("user");
			if (userJsonObject != null) {
				String userId = userJsonObject.getString("idstr");
				String pageUrl = String.format(Constants.PAGE_URL_FORMAT, userId, idStr);
				singleObject.put(Constants.PAGE_URL_ID, pageUrl);
				if (needUserName) {
					String screen_name = userJsonObject.getString(Constants.SCREEN_NAME_ID);
					singleObject.put(Constants.SCREEN_NAME_ID, screen_name);
				}
			}
			JSONArray tagsArray = object.getJSONArray(Constants.TAGS_ID);
			if (tagsArray != null) {
				Optional<String> optional = tagsArray.stream().map(JSONObject.class::cast)
						.map(obj -> obj.getString("tag")).reduce((a, b) -> a + " " + b);
				optional.ifPresent(tagsStr -> singleObject.put(Constants.TAGS_ID, tagsStr));
			}

			allWeiboPicsVideos.put(dateId, singleObject);
		}
		return allWeiboPicsVideos;
	}

	private static String getYearMonthDayId(JSONObject object, String idStr) {
		String created_at = object.getString("created_at");

		@SuppressWarnings("deprecation")
		Date date = new Date(created_at);
		Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
		calendar.setTime(date);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		String dateId = String.format(Constants.DATE_ID_FORMAT, year, month, day, idStr);
		return dateId;
	}

	private static void getVideos(JSONObject object, List<String> videos) {
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

	private static void getPics(JSONObject object, List<String> pics) {
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

	private static void getVideosPics(JSONObject object, List<String> videos, List<String> pics) {
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
