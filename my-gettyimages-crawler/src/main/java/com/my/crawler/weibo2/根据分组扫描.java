package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.my.crawler.weibo2.GroupMembersCrawler.UserEntity;

public class 根据分组扫描 {
	public static void main(String[] args) throws IOException {
//		扫描明星图片();
		// 扫描半年可见();
//		扫描生图();
//		扫描美欧日();
//		扫描特别关注();
		扫描网红();
	}

	public static void 扫描特别关注() throws IOException {
		start("特别关注.log", GroupMembersCrawler.特别关注分组ID);
	}

	public static void 扫描明星图片() throws IOException {
		start("明星图片.log", GroupMembersCrawler.明星图片分组ID);
	}

	public static void 扫描半年可见() throws IOException {
		start("半年可见.log", GroupMembersCrawler.半年可见分组ID);
	}

	public static void 扫描生图() throws IOException {
		start("生图.log", GroupMembersCrawler.生图分组ID);
	}

	public static void 扫描美欧日() throws IOException {
		start("美欧日.log", GroupMembersCrawler.美欧日分组ID);
	}

	public static void 扫描网红() throws IOException {
		start("网红.log", "4973738839774902");
	}

	private static void start(String followFileName, String groupId) throws IOException {
		File folder = new File("F:\\weibo_log");

		File followFile = new File(folder, followFileName);
		List<UserEntity> userEntities = null;
		if (followFile.exists()) {
			userEntities = readFollows(followFile);
		} else {
			userEntities = GroupMembersCrawler.startCrawler(groupId);
			saveFollows(userEntities, followFile);
		}

		for (UserEntity userEntity : userEntities) {
			String screen_name = userEntity.screen_name;
			String id = userEntity.id;

			System.out.println("id: " + id + "\t name: " + screen_name);

			File followFolder = new File(folder, screen_name);
			根据UID扫描所有weibo并解析pic和video.start(id, followFolder);
			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.gc();
		}
	}

	private static void saveFollows(List<UserEntity> userEntities, File followFile) throws IOException {
		Files.writeString(followFile.toPath(), JSON.toJSONString(userEntities, SerializerFeature.PrettyFormat));
	}

	private static List<UserEntity> readFollows(File followFile) throws IOException {
		String content = Files.readString(followFile.toPath());
		JSONArray jsonArray = JSON.parseArray(content);
		List<UserEntity> userEntities = jsonArray.toJavaList(UserEntity.class);
		return userEntities;
	}
}
