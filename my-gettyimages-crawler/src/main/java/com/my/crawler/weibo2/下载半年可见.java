package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.my.crawler.weibo2.GetHalfYearFollowers.UserEntity;

public class 下载半年可见 {
	public static void main(String[] args) throws IOException {
		File folder = new File("F:\\weibo_log");
		File outputFolder = new File("F:\\weibo");

		File followFile = new File(folder, "半年可见.log");
		List<UserEntity> userEntities = null;
		userEntities = readFollows(followFile);

		for (UserEntity userEntity : userEntities) {
			File userFolder = new File(folder, userEntity.screen_name);
			File userOutputFolder = new File(outputFolder, userEntity.screen_name);
//			if (userOutputFolder.exists()) {
//				continue;
//			}
			if (!userOutputFolder.exists()) {
				userOutputFolder.mkdirs();
			}
			根据picvideolog开始下载.start(userFolder, userOutputFolder);
		}
	}

	private static List<UserEntity> readFollows(File followFile) throws IOException {
		String content = Files.readString(followFile.toPath());
		JSONArray jsonArray = JSON.parseArray(content);
		List<UserEntity> userEntities = jsonArray.toJavaList(UserEntity.class);
		return userEntities;
	}
}
