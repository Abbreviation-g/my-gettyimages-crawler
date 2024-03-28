package com.my.crawler.weibo;

import static com.my.crawler.weibo.WeiboImageDownloader.downloadFormPicUrlByConnection;
import static com.my.crawler.weibo.WeiboImageDownloader.getImageName;
import static com.my.crawler.weibo.根据weibolog解析pic和video.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class 扫描文件夹log文件下载视频图片 {
	public static void main(String[] args) throws MalformedURLException {
		String folderPath = null;
		folderPath = "D:\\weibo2\\唐艺昕";
		folderPath = "D:\\weibo2\\唐艺昕\\2023\\12\\9\\4976825819726343";
		folderPath = "F:\\weibo_log\\超Carry的柴西\\2023-05-18-4902891083799401";
		folderPath = "F:\\weibo\\普通小柴";
		folderPath = "F:\\weibo\\秦丽0729";
		folderPath = "F:\\weibo\\景一JING";
		
		start(folderPath);
	}

	public static void start(String folderPath) {
		List<Path> picLogFiles = new ArrayList<>();
		List<Path> videoFiles = new ArrayList<>();
		try {
			Files.walkFileTree(new File(folderPath).toPath(), new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					String name = file.getFileName().toString();
					if (PICTURE_LOG_FILENAME.equals(name)) {
						picLogFiles.add(file);
					} else if (VIDEO_LOG_FILENAME.equals(name)) {
						videoFiles.add(file);
					}
					return FileVisitResult.CONTINUE;
				}
			});
			startDownloadPics(picLogFiles);
			startDownloadPics(videoFiles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void startDownloadPics(List<Path> picLogFiles) throws IOException {
		for (Path picLogFile : picLogFiles) {
			File folder = picLogFile.getParent().toFile();
			List<String> allLines = Files.readAllLines(picLogFile);
			for (String line : allLines) {
				File imgFile = new File(folder, getImageName(line));
				if (imgFile.exists()) {
					System.out.println(imgFile + "\t" + "exits");
					continue;
				}
				boolean result = downloadFormPicUrlByConnection(new URL(line), imgFile);
				if (result) {
					System.out.println(imgFile + "\t" + "done");
				} else {
					System.out.println(imgFile + "\t" + "failed");
				}
			}
		}
	}
}
