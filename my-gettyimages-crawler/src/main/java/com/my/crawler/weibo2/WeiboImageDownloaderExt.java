package com.my.crawler.weibo2;

import static com.my.crawler.weibo2.WeiboImageDownloader.downloadFormPicUrlByConnection;
import static com.my.crawler.weibo2.WeiboImageDownloader.getImageName;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class WeiboImageDownloaderExt {
	public static void start(File inputFolder, String screenName, File outputFolder) throws IOException {
		start(new File(inputFolder, screenName), new File(outputFolder, screenName), false, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, null);
	}

	public static void start(File folder, File outputFolder) throws IOException {
		start(folder, outputFolder, false, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, null);
	}

	public static void start(File folder) throws IOException {
		start(folder, folder, false, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, null);
	}

	public static void start(File folder, File outputFolder, String weiboStr) throws IOException {
		start(folder, outputFolder, false, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, weiboStr);
	}

	public static void start(File folder, int startYear, int startMonth, int startDay) throws IOException {
		start(folder, folder, false, startYear, startMonth, startDay, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, null);
	}

	public static void start(File folder, File outputFolder, int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) throws IOException {
		start(folder, outputFolder, false, startYear, startMonth, startDay, endYear, endMonth, endDay, null);
	}

	public static void start(File folder, File outputFolder, boolean isDownloadVideo, int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) throws IOException {
		start(folder, outputFolder, isDownloadVideo, startYear, startMonth, startDay, endYear, endMonth, endDay, null);
	}

	public static void start(File folder, File outputFolder, boolean isDownloadVideo, int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay, String weiboStr) throws IOException {
		start(folder, outputFolder, folder, isDownloadVideo, startYear, startMonth, startDay, endYear, endMonth, endDay, weiboStr);
	}

	public static void start(File folder, File outputFolder, File doneListFolder) throws IOException {
		start(folder, outputFolder, doneListFolder, false, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, null);
	}

	public static void start(File folder, File outputFolder, File doneListFolder, boolean isDownloadVideo, int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay, String weiboStr) throws IOException {
		start(folder, outputFolder, doneListFolder, isDownloadVideo, startYear, startMonth, startDay, endYear, endMonth, endDay, weiboStr, null);
	}

	public static void start(File folder, File outputFolder, File doneListFolder, boolean isDownloadVideo, int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay, String weiboStr, String screen_name) throws IOException {
		File picVideoLogFile = new File(folder, Constants.PICS_VIDEOS_FILE_NAME);
		startByLogFile(picVideoLogFile, outputFolder, doneListFolder, isDownloadVideo, startYear, startMonth, startDay, endYear, endMonth, endDay, weiboStr, screen_name);
	}

	public static void startByLogFile(File picVideoLogFile, File outputFolder, File doneListFolder, boolean isDownloadVideo, int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay, String weiboStr, String screen_name) throws IOException {
		if (!picVideoLogFile.exists()) {
			System.err.println(picVideoLogFile + "\t not exits.");
			return;
		}
		String content = Files.readString(picVideoLogFile.toPath());
		if (content.isEmpty()) {
			System.err.println(picVideoLogFile + "\t is empty.");
			return;
		}
		@SuppressWarnings("unchecked")
		TreeMap<String, JSONObject> object = JSON.parseObject(content, TreeMap.class);
		if (object.isEmpty()) {
			System.err.println(picVideoLogFile + "\t is empty.");
			return;
		}

		Set<String> doneList = readDoneList(doneListFolder);
		Set<String> keySet = object.keySet();
		Iterator<String> iterator = keySet.iterator();

		Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
		Date startDate = getStartDate(calendar, startYear, startMonth, startDay);
		Date endDate = getEndDate(calendar, endYear, endMonth, endDay);

		while (iterator.hasNext()) {
			String dateId = (String) iterator.next();

			String[] split = dateId.split("-");
			int year = Integer.parseInt(split[0]);
			int month = Integer.parseInt(split[1]);
			int day = Integer.parseInt(split[2]);

			calendar.set(year, month - 1, day, 0, 0, 0);
			Date date = calendar.getTime();
			if (!(date.getTime() >= startDate.getTime() && date.getTime() <= endDate.getTime())) {
				continue;
			}

//			String dateStr = String.format(Constants.DATE_FORMAT, year, month, day);
			String dateStr = dateId;
			JSONObject singleObject = object.get(dateId);

			if (!filteByText(singleObject, weiboStr)) {
				continue;
			}
			if (screen_name != null && !screen_name.isEmpty()) {
				if (!singleObject.containsKey(Constants.SCREEN_NAME_ID)) {
					continue;
				}
				String text = singleObject.getString(Constants.SCREEN_NAME_ID);
				if (!text.contains(screen_name)) {
					continue;
				}
			}

			if (singleObject.containsKey(Constants.PICS_ID)) {
				JSONArray picArray = singleObject.getJSONArray(Constants.PICS_ID);
				List<String> pics = picArray.toJavaList(String.class);

				startDownload(pics, doneList, dateStr, outputFolder);
			}
			if (isDownloadVideo && singleObject.containsKey(Constants.VIDEOS_ID)) {
				JSONArray videoArray = singleObject.getJSONArray(Constants.VIDEOS_ID);
				List<String> videos = videoArray.toJavaList(String.class);

				startDownload(videos, doneList, dateStr, outputFolder);
			}
		}

		if (!doneList.isEmpty()) {
			File doneListFile = new File(doneListFolder, Constants.DONE_LIST_FILE_NAME);
			Files.write(doneListFile.toPath(), doneList);
		}
	}

	private static boolean filteByText(JSONObject singleObject, String weiboStr) {
		if (weiboStr == null || weiboStr.isEmpty()) {
			return true;
		}
		String text = getText(singleObject);
		if (text == null || text.isEmpty()) {
			return true;
		}
		if (text.contains(weiboStr)) {
			return true;
		}
		return false; // 表示跳过
	}

	private static String getText(JSONObject singleObject) {
		String text = singleObject.getString(Constants.TEXT_ID);
		if (text != null) {
			return text;
		}
		text = singleObject.getString("text");
		return text;
	}

	private static Date getStartDate(Calendar calendar, int startYear, int startMonth, int startDay) {
		if (startYear == Integer.MIN_VALUE) {
			startYear = 1970;
		}
		if (startMonth == Integer.MIN_VALUE) {
			startMonth = 1;
		}
		if (startDay == Integer.MIN_VALUE) {
			startDay = 1;
		}
		calendar.set(startYear, startMonth - 1, startDay, 0, 0, 0);
		Date startDate = calendar.getTime();
		return startDate;
	}

	private static Date getEndDate(Calendar calendar, int endYear, int endMonth, int endDay) {
		if (endYear == Integer.MAX_VALUE) {
			endYear = 2099;
		}
		if (endMonth == Integer.MAX_VALUE) {
			endMonth = 12;
		}
		if (endDay == Integer.MAX_VALUE) {
			endDay = 31;
		}
		calendar.set(endYear, endMonth - 1, endDay, 23, 59, 59);
		Date endDate = calendar.getTime();
		return endDate;
	}

	private static Set<String> readDoneList(File outputFolder) throws IOException {
		File doneListFile = new File(outputFolder, Constants.DONE_LIST_FILE_NAME);
		if (!doneListFile.exists()) {
			return new TreeSet<>();
		}
		return new TreeSet<>(Files.readAllLines(doneListFile.toPath()));
	}

	private static void startDownload(List<String> urls, Set<String> doneList, String dateStr, File folder) throws IOException {
		for (String line : urls) {
//			File imgFile2 = new File(folder, getImageName(line, dateStr));
//			if (imgFile2.exists() && imgFile2.length() == 0L) {
//				System.out.println(imgFile2 + "\t" + "imgFile2.exists() && imgFile2.length() == 0L");
//				downloadFormPicUrlByConnection(new URL(line), imgFile2);
//				continue;
//			}

			if (doneList.contains(line)) {
//				System.out.println(line + "\t" + "contains");
				continue;
			}
			if (!folder.exists()) {
				folder.mkdirs();
			}
			File imgFile = new File(folder, getImageName(line, dateStr));
			if (imgFile.exists()) {
				doneList.add(line);
				System.out.println(imgFile + "\t" + "exits");
				continue;
			}
			Constants.randomSleepShort();
			boolean result = downloadFormPicUrlByConnection(new URL(line), imgFile);
			if (result) {
				doneList.add(line);
				System.out.println(imgFile + "\t" + "done");
			} else {
				System.out.println(imgFile + "\t" + "failed");
			}
		}
	}
}
