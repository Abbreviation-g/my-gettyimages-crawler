package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Test2 {
	public static void main(String[] args) throws IOException {
		File weiboLogsFolder = new File("F:\\weibo_log");
		for(File weiboFolder: weiboLogsFolder.listFiles(f->f.isDirectory())) {
			start(weiboFolder);
		}
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
}
