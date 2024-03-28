package com.my.crawler.weibo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.my.crawler.weibo.GetFollowers.UserEntity;
import static com.my.crawler.weibo.根据weibolog解析pic和video.*;
import static com.my.crawler.weibo.根据UID解析微博并保存为本地log.*;

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
			File weiboLogFile = new File(followFolder, WEIBO_LOG_FILENAME);
			if (!weiboLogFile.exists() || OVERWRITE) {
				JSONArray array = createWeiLogFile(id, followFolder.getPath());
				splitWeibosToDateIdFolder(array, followFolder);
			} else {
				splitWeibosToDateIdFolder(followFolder);
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
