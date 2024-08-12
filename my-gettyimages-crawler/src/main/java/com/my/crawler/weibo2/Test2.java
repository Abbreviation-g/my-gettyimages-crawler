package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.my.crawler.weibo2.Constants.IDNameEntity;

public class Test2 {
	public static void main(String[] args) throws IOException {
//		System.out.println(Constants.半年可见().size());
//		Constants.半年可见().retainAll(Constants.特别关注());
//		System.out.println(Constants.半年可见().size());
//		System.out.println(Constants.半年可见());
		System.out.println(new IDNameEntity("1", "1").equals(new IDNameEntity("1", "1")));

		Set<IDNameEntity> setA = new TreeSet<>(Constants.半年可见());
		setA.add(new IDNameEntity("1", "1"));
		Set<IDNameEntity> setB = new TreeSet<>(Constants.特别关注());
		setB.add(new IDNameEntity("1", "1"));
		// 求交集
		setA.retainAll(setB);

		// 输出交集结果
		System.out.println("交集：" + setA);
	}

	public static void start(File folder) throws IOException {
		File weiboArrayFile = new File(folder, Constants.WEIBO_ARRAY_FILE_NAME);
		if (weiboArrayFile.exists()) {
			File picsVideosFile = new File(folder, Constants.PICS_VIDEOS_FILE_NAME);
			if (!picsVideosFile.exists()) {
				JSONObject oldObject = WeiboArrayToPicsVideos.weiboArrayLogToPicsVideos(weiboArrayFile);
				Files.writeString(picsVideosFile.toPath(), oldObject.toString(SerializerFeature.PrettyFormat));
			}
		}
	}

	private static void test2() {
		Map<String, String> searchKeyOutputFolderMap = new LinkedHashMap<>();
		searchKeyOutputFolderMap.put("张天爱", "张天爱");
		searchKeyOutputFolderMap.put("袁姗姗", "袁姗姗");
		searchKeyOutputFolderMap.put("关晓彤", "关晓彤");
		searchKeyOutputFolderMap.put("宋妍", "宋妍霏");
		searchKeyOutputFolderMap.put("王紫璇", "王紫璇");
		searchKeyOutputFolderMap.put("黄梦莹", "黄梦莹");
		searchKeyOutputFolderMap.put("唐艺昕", "唐艺昕");
		searchKeyOutputFolderMap.put("王鸥", "王鸥");
		searchKeyOutputFolderMap.put("林允儿", "林允儿");
		searchKeyOutputFolderMap.put("林允", "林允");
		searchKeyOutputFolderMap.put("蒋依依", "蒋依依");
		searchKeyOutputFolderMap.put("陈钰琪", "陈钰琪");
		searchKeyOutputFolderMap.put("孟子义", "孟子义");

		String result = searchKeyOutputFolderMap.keySet().stream().map(str -> "\"" + str + "\"").reduce((s1, s2) -> s1 + ", " + s2).get();
		System.out.println(result);
	}
}
