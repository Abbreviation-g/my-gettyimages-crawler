package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class 根据weibolog解析pic和video {
	public static void main(String[] args) throws IOException {
		start(new File("F:\\weibo_log\\-傅晶-"));
	}

	public static void start(File folder) throws IOException {
		File weiboArrayFile = new File(folder, Constants.WEIBO_ARRAY_FILE_NAME);
		if (weiboArrayFile.exists()) {
			JSONObject oldObject = WeiboArrayToPicsVideos.weiboArrayLogToPicsVideos(weiboArrayFile);
			Files.writeString(new File(folder, Constants.PICS_VIDEOS_FILE_NAME).toPath(),
					oldObject.toString(SerializerFeature.PrettyFormat));
		}
	}
}
