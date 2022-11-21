package com.my.crawler.common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class 按照月份分类微博图片 {
	public static void main(String[] args) throws IOException {
		File outputFolder = new File("D:\\weibo\\关晓彤");
//		outputFolder = new File("D:\\weibo\\关晓彤工作室");
		List<File> files = searchFile(outputFolder);

		JSONArray jsonArray = getImgMap(outputFolder);
		for (Object object : jsonArray) {
			JSONObject monthArr = (JSONObject) object;
			String month = monthArr.getString("month");
			JSONArray arr = monthArr.getJSONArray("arr");
			System.out.println(month);
			System.out.println(arr);

			System.out.println("总大小: " + arr.size());
			Iterator<Object> iterator = arr.iterator();
			while (iterator.hasNext()) {

				File monthFolder = new File(outputFolder, month);
				if (!monthFolder.exists()) {
					monthFolder.mkdir();
				}
				String imgUrlStr = (String) iterator.next();
				String fileName = imgUrlStr.substring(imgUrlStr.lastIndexOf('/') + 1);
				File newFile = new File(monthFolder, fileName);
				if (newFile.exists()) {
					continue;
				}

				ListIterator<File> listIterator = files.listIterator();
				while (listIterator.hasNext()) {
					File oldFile = (File) listIterator.next();
					if (oldFile.getName().equals(fileName)) {
						if(oldFile.exists()) {
							oldFile.renameTo(newFile);
						}
					}
				}
			}
		}
	}

	public static List<File> searchFile(File outputFolder) throws IOException {
		List<File> files = new ArrayList<File>();
		Files.walkFileTree(outputFolder.toPath(), new SimpleFileVisitor<java.nio.file.Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				files.add(file.toFile());
				return super.visitFile(file, attrs);
			}
		});
		return files;
	}

	public static JSONArray getImgMap(File outputFolder) throws IOException {
		File logFile = new File(outputFolder, "json.log");
		if (logFile.exists()) {
			byte[] allBytes = Files.readAllBytes(logFile.toPath());
			String content = new String(allBytes);
			if ((content.startsWith("\"") && content.endsWith("\"")) || content.startsWith("'") && content.endsWith("'")
					|| content.startsWith("`") && content.endsWith("`")) {
				content = content.substring(1, content.length() - 1);
			}
			JSONArray jsonArray = (JSONArray) JSON.parse(content);
			return jsonArray;
		}
		return null;
	}
}
