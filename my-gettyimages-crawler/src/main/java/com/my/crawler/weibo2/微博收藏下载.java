package com.my.crawler.weibo2;

import static com.my.crawler.weibo2.WeiboImageDownloaderExt.startByLogFile;

import java.io.File;
import java.io.IOException;

public class 微博收藏下载 {
	public static void main(String[] args) throws IOException {
		File logFolder = new File("F:\\weibo_log\\梦醒忒远");
		File logFile = new File(logFolder, Constants.FAVORITES_PICS_VIDEOS_FILE_NAME);
		startByLogFile(logFile, new File("F:\\weibo2\\梦醒忒远\\董维嘉"), logFolder, false, 2000, 1, 1, 2024, 12, 31, null, "董维嘉");
		startByLogFile(logFile, new File("F:\\weibo2\\梦醒忒远\\DOUBLE_大伯"), logFolder, false, 2000, 1, 1, 2024, 12, 31, null, "DOUBLE_大伯");
		startByLogFile(logFile, new File("F:\\weibo2\\梦醒忒远\\叶一雲"), logFolder, false, 2000, 1, 1, 2024, 12, 31, null, "叶一雲");
		startByLogFile(logFile, new File("F:\\weibo2\\梦醒忒远\\宋妍霏"), logFolder, false, 2000, 1, 1, 2024, 12, 31, "宋妍霏", null);
		startByLogFile(logFile, new File("F:\\weibo2\\梦醒忒远\\宋妍霏"), logFolder, false, 2000, 1, 1, 2024, 12, 31, null, "宋妍霏");
		startByLogFile(logFile, new File("F:\\weibo2\\梦醒忒远\\牟星"), logFolder, false, 2000, 1, 1, 2024, 12, 31, null, "牟星");
		startByLogFile(logFile, new File("F:\\weibo2\\梦醒忒远\\牟星"), logFolder, false, 2000, 1, 1, 2024, 12, 31, "牟星", null);
		startByLogFile(logFile, new File("F:\\weibo2\\梦醒忒远\\谭卓"), logFolder, false, 2000, 1, 1, 2024, 12, 31, null, "谭卓");
		startByLogFile(logFile, new File("F:\\weibo2\\梦醒忒远\\谭卓"), logFolder, false, 2000, 1, 1, 2024, 12, 31, "谭卓", null);
//		startByLogFile(logFile, new File("F:\\weibo2\\梦醒忒远\\袁嘉敏"), logFolder, false, 2000, 1, 1, 2024, 12, 31, null, "袁嘉敏");
//		startByLogFile(logFile, new File("F:\\weibo2\\梦醒忒远\\袁嘉敏"), logFolder, false, 2000, 1, 1, 2024, 12, 31, "袁嘉敏", null);
	}
}
