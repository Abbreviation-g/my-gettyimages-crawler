package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class 根据UID扫描所有weibo并解析pic和video {
	public static void main(String[] args) throws IOException {
		String uid = "2602190401";
		String folderPath = "F:\\weibo_log\\孙晓伦呀";

		uid = "2383785520";
		folderPath = "F:\\weibo_log\\森林北-";
		uid = "1221923871";
		folderPath = "F:\\weibo_log\\王鸥Angel";
		start(uid, new File(folderPath));
	}

	public static void start(String uid, File folder) throws IOException {
		JSONArray newWeiboArray = WeiboUIDToWeiboArray.getWeiboArray(uid);
		JSONObject newObject = WeiboArrayToPicsVideos.weiboArrayToPicsVideos(newWeiboArray);
		if (newObject.isEmpty()) {
			System.err.println("解析 \t" + uid + "\t失败");
			return;
		}
		File weiboArrayFile = new File(folder, Constants.WEIBO_ARRAY_FILE_NAME);
		if (weiboArrayFile.exists()) {
			JSONObject oldObject = WeiboArrayToPicsVideos.weiboArrayLogToPicsVideos(weiboArrayFile);
			newObject = WeiboArrayToPicsVideos.mergeOldAndNew(oldObject, newObject);
		}
		if (!folder.exists()) {
			folder.mkdirs();
		}
		Files.writeString(weiboArrayFile.toPath(), newWeiboArray.toString(SerializerFeature.PrettyFormat));
		Files.writeString(new File(folder, Constants.PICS_VIDEOS_FILE_NAME).toPath(),
				newObject.toString(SerializerFeature.PrettyFormat));
	}
}
