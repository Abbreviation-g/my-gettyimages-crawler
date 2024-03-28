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

public class 根据picvideolog开始下载 {
	public static void main(String[] args) throws IOException {
		start(new File("F:\\weibo_log", "苏青工作室"), new File("F:\\weibo2", "苏青工作室"));
		start(new File("F:\\weibo_log\\Cecilia宋妍霏"), new File("F:\\weibo2\\Cecilia宋妍霏"), false, 2023, 1, 1, 2024, 12, 31);
		start(new File("F:\\weibo_log\\Nana谈莉娜"), new File("F:\\weibo2\\Nana谈莉娜"), false, 2000, 1, 1, 2015, 6, 18);
//		start(new File("F:\\weibo_log\\赵蕴卓同学"), new File("F:\\weibo2\\赵蕴卓同学"), false, 2020, 1, 1, 2020, 12, 31);
		start(new File("F:\\weibo_log\\柳岩"), new File("F:\\weibo2\\柳岩"), false, 2009, 1, 1, 2016, 6, 31);
//		start(new File("F:\\weibo_log", "梁洁Little"), new File("F:\\weibo2", "梁洁Little"));
//		start(new File("F:\\weibo_log", "梁洁工作室"), new File("F:\\weibo2", "梁洁工作室"));
//		start(new File("F:\\weibo_log", "梦醒忒远"), new File("F:\\weibo2", "梦醒忒远"), false, 2011, 1, 1, 2022, 12, 31);
//		start(new File("F:\\weibo_log", "代斯daisy"), new File("F:\\weibo2", "代斯daisy"), false, 2023, 12, 1, 2024, 2, 21);
//		start(new File("F:\\weibo_log", "赵露思的微博"), new File("F:\\weibo2", "赵露思的微博"), false, 2024, 2, 21, 2099, 1, 1);
//		start(new File("F:\\weibo_log", "赵露思工作室官微"), new File("F:\\weibo2", "赵露思工作室官微"), false, 2024, 2, 21, 2099, 1, 1);
//		start(new File("F:\\weibo_log", "明星女神时光机"), new File("F:\\weibo2", "明星女神时光机"), false, 2020, 1, 1, 2020, 12, 31);
//		start(new File("F:\\weibo_log"), "徐娇", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log", "景甜"), new File("F:\\weibo2", "景甜"), false, 2023, 10, 1, 2024, 2, 22);
//		start(new File("F:\\weibo_log", "CSIDE宋妍霏工作室"), new File("F:\\weibo2", "CSIDE宋妍霏工作室"), false, 2023, 11, 1, 2024, 2, 22);
//		start(new File("F:\\weibo_log", "蓝心妍"), new File("F:\\weibo2", "蓝心妍"));
//		start(new File("F:\\weibo_log", "我是娜扎"), new File("F:\\weibo2", "我是娜扎"));
//		start(new File("F:\\weibo_log", "娜扎工作室"), new File("F:\\weibo2", "娜扎工作室"));
//		start(new File("F:\\weibo_log", "马思纯"), new File("F:\\weibo2", "马思纯"));
//		start(new File("F:\\weibo_log", "李菲儿工作室"), new File("F:\\weibo2", "李菲儿工作室"));
//		start(new File("F:\\weibo_log", "孙怡工作室"), new File("F:\\weibo2", "孙怡工作室"));
//		start(new File("F:\\weibo_log", "钟楚曦"), new File("F:\\weibo2", "钟楚曦"));
//		start(new File("F:\\weibo_log", "钟楚曦工作室"), new File("F:\\weibo2", "钟楚曦工作室"));
//		start(new File("F:\\weibo_log", "GNZ48-刘倩倩-"), new File("F:\\weibo2", "GNZ48-刘倩倩-"));
//		start(new File("F:\\weibo_log", "陈斯文cissie"), new File("F:\\weibo2", "陈斯文cissie"));
//		start(new File("F:\\weibo_log", "沈羽洁er"), new File("F:\\weibo2", "沈羽洁er"));
//		start(new File("F:\\weibo_log"), "郭碧婷", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log"), "晗卓-", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log"), "韩雪工作室", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log"), "八掛海_real", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log"), "Fairy丨0416林允Jelly", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log"), "潘敏-", new File("F:\\weibo2"));

//		start(new File("F:\\weibo_log"), "张雯", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "韩雪", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "聂小雨YU", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "镕馨二", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "angelababy", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "张予曦", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "刘湘_11", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "王鸥Angel", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "全是生图", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "佳怡一路佳境", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "努力的十八魔", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "山一几Eleanor", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "林允的小号r", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "叶舒华_G-I-DLE", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "介个菜很辣的喔", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "一栗莎子", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "不2不叫周淑怡", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "婴宁lasw", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "BDD东", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "琬琬_", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "程潇", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "金佳悦-", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "SNH48-许杨玉琢", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "李則慧", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "徐梓钧", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "陆妍淇", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "刘敏", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "汪聪", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "乃万N1NEONE", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "王悦伊", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "吴哲晗_RenRen", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "赵圆瑗", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "吴佩柔vianna", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "冯琳Fairy", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "林夏薇", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "演员郑清文", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "裴佳欣", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "舒畅", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "热依扎", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "柴蔚", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "唐艺昕", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "林允Jelly", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "何穗", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "蓝心ZoeZhang", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "空蛹出蝶", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "刘玮婷V", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "何慧香", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "BEJ48-孙晓艳", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "左小青", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "赵子琪", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "严尚嘉", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "朱梓橦工作室", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "朱梓橦", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "張榕容", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "主持人郭玮", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "吴谨言", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "张芷溪", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "菅纫姿", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "颖儿Yinger", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "创造营亚洲-欧阳娣娣", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "郭雪芙HF_K", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "郭采洁", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "演员洪爽", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "演员文淇", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "李念", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "-靳梦佳", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "王晓晨", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "李斯羽", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "叶璇", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "牛欣欣", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "胡可", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "白冰", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "颜丹晨", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "孙晓伦呀", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "徐冬冬", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "李沁", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "李沁工作室", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "王鸥工作室", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "万茜", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "王丽坤", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "张雨绮", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "李冰冰", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "刘涛tamia", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "秦岚", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "秦岚工作室", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "马苏", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "唐艺昕工作室", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "刘芸", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "宋佳", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "李溪芮", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "王子文工作室微博", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "童瑶", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "苏青", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "毛晓彤", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "杨蓉", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "范冰冰", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "杨超越", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "-王楚然-", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "虞书欣Esther", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "周雨彤微博", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "李菲儿love", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "张柏芝工作室", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "张柏芝", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "赵丽颖", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "孙怡微博", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "张嘉倪", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "张萌", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "陳妍希michelle", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "张佳宁", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "蒋欣", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "王媛可", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "王卓淇erin__kay", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "李小冉", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "李佳桐sep", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "李依晓", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "吴宣仪_Betty", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "陈小纭", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "施诗Kira", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "章若楠", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "顾璇", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "孟子义", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "黄奕", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "演员艾米", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "米露", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "林小宅", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "JaniceMan文咏珊", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "张雪迎Sophie", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "刘诗诗", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "唐嫣", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "徐璐LULU", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "陈梦儿-myYY", new File("F:\\weibo"));
//		start(new File("F:\\weibo_log"), "镕馨Rongxiiin", new File("F:\\weibo"));
	}

	public static void start(File inputFolder, String screenName, File outputFolder) throws IOException {
		start(new File(inputFolder, screenName), new File(outputFolder, screenName), false, Integer.MIN_VALUE,
				Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, null);
	}

	public static void start(File folder, File outputFolder) throws IOException {
		start(folder, outputFolder, false, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE, Integer.MAX_VALUE, null);
	}

	public static void start(File folder) throws IOException {
		start(folder, folder, false, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE, Integer.MAX_VALUE, null);
	}

	public static void start(File folder, String weiboStr) throws IOException {
		start(folder, folder, false, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE, Integer.MAX_VALUE, weiboStr);
	}

	public static void start(File folder, int startYear, int startMonth, int startDay) throws IOException {
		start(folder, folder, false, startYear, startMonth, startDay, Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE, null);
	}

	public static void start(File folder, File outputFolder, boolean isDownloadVideo, int startYear, int startMonth,
			int startDay, int endYear, int endMonth, int endDay) throws IOException {
		start(folder, outputFolder, isDownloadVideo, startYear, startMonth, startDay, endYear, endMonth, endDay, null);
	}

	public static void start(File folder, File outputFolder, boolean isDownloadVideo, int startYear, int startMonth,
			int startDay, int endYear, int endMonth, int endDay, String weiboStr) throws IOException {
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
		@SuppressWarnings("unchecked")
		TreeMap<String, JSONObject> object = JSON.parseObject(content, TreeMap.class);
		if (object.isEmpty()) {
			System.err.println(picVideoLogFile + "\t is empty.");
			return;
		}

		Set<String> doneList = readDoneList(outputFolder);
		Set<String> keySet = object.keySet();
		Iterator<String> iterator = keySet.iterator();

		if (!outputFolder.exists()) {
			outputFolder.mkdir();
		}
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

			String dateStr = String.format(Constants.DATE_ID, year, month, day);
			JSONObject singleObject = object.get(dateId);

			if (weiboStr != null && !weiboStr.isEmpty()) {
				if (!singleObject.containsKey(Constants.TEXT_ID)) {
					continue;
				}
				String text = singleObject.getString(Constants.TEXT_ID);
				if (!text.contains(weiboStr)) {
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
			File doneListFile = new File(outputFolder, Constants.DONE_LIST_FILE_NAME);
			Files.write(doneListFile.toPath(), doneList);
		}
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

	@SuppressWarnings("unused")
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

	private static void startDownload(List<String> urls, Set<String> doneList, String dateStr, File folder)
			throws IOException {
		for (String line : urls) {
			if (doneList.contains(line)) {
				continue;
			}
			File imgFile = new File(folder, getImageName(line, dateStr));
			if (imgFile.exists()) {
				doneList.add(line);
				System.out.println(imgFile + "\t" + "exits");
				continue;
			}
			boolean result = downloadFormPicUrlByConnection(new URL(line), imgFile);
			if (result) {
				doneList.add(line);
				System.out.println(imgFile + "\t" + "done");
			} else {
				System.out.println(imgFile + "\t" + "failed");
			}
		}
	}

	@SuppressWarnings("unused")
	private static void startDownload(List<String> urls, String dateStr, File folder) throws IOException {
		for (String line : urls) {
			File imgFile = new File(folder, getImageName(line, dateStr));
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
