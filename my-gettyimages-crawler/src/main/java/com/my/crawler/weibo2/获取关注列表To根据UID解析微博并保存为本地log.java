package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.my.crawler.weibo2.GetFollowers.UserEntity;

public class 获取关注列表To根据UID解析微博并保存为本地log {
	private static final boolean OVERWRITE = false;

	public static void main(String[] args) throws IOException {
		File folder = new File("F:\\weibo_log");

		File followFile = new File(folder, "follow.log");
		List<UserEntity> userEntities = null;
		if (followFile.exists()) {
			userEntities = readFollows(followFile);
		} else {
			userEntities = GetFollowers.start();
			saveFollows(userEntities, followFile);
		}

		for (UserEntity userEntity : userEntities) {
			String screen_name = userEntity.screen_name;
			String id = userEntity.id;

			System.out.println("id: " + id + "\t name: " + screen_name);

			File followFolder = new File(folder, screen_name);
			File weiboLogFile = new File(followFolder, Constants.WEIBO_ARRAY_FILE_NAME);
			if (weiboLogFile.exists() && !OVERWRITE) {
//				File picVideosFile = new File(followFolder, Constants.PICS_VIDEOS_FILE_NAME);
//				if(!picVideosFile.exists()) {
//					JSONObject newObject = WeiboArrayToPicsVideos.weiboArrayLogToPicsVideos(weiboLogFile);
//					Files.writeString(new File(followFolder, Constants.PICS_VIDEOS_FILE_NAME).toPath(),
//							newObject.toString(SerializerFeature.PrettyFormat));
//				}
//				JSONObject newObject = WeiboArrayToPicsVideos.weiboArrayLogToPicsVideos(weiboLogFile);
//				Files.writeString(new File(followFolder, Constants.PICS_VIDEOS_FILE_NAME).toPath(),
//						newObject.toString(SerializerFeature.PrettyFormat));			
				continue;
			} else {
				根据UID扫描所有weibo并解析pic和video.start(id, followFolder);
			}
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
