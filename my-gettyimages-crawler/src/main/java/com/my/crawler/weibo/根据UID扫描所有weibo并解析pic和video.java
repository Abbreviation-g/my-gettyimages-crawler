package com.my.crawler.weibo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class 根据UID扫描所有weibo并解析pic和video {
	public static void main(String[] args) {

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
		Files.writeString(new File(folder, Constants.PICS_VIDEOS_FILE_NAME).toPath(),
				newObject.toString(SerializerFeature.PrettyFormat));
	}
}
