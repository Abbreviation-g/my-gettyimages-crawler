package com.my.crawler.common;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class 解析微博网页输出到json文件并下载图片 {
	public static void main(String[] args) throws IOException {
		File outputFolder = new File("D:\\weibo\\袁姗姗");
		outputFolder = new File("D:\\weibo\\袁冰妍工作室");
		downloadFromFolder(outputFolder);

	}

	private static void downloadFromFolder(File outputFolder) throws IOException {
		File jsonLogFile = new File(outputFolder, "json.log");
		if (!jsonLogFile.exists()) {
			return;
		}
		JSONArray jsonArray = getImgMap(jsonLogFile);
		File doneFile = new File(outputFolder, "done.list");
		List<String> alreadyList;
		if (doneFile.exists()) {
			alreadyList = Files.readAllLines(doneFile.toPath());
		} else {
			alreadyList = new ArrayList<>();
		}
		int i = 0;
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
				if (alreadyList.contains(imgUrlStr)) {
					System.out.println("文件已被备份" + i++ + ":" + imgUrlStr);
					continue;
				}
				alreadyList.add(imgUrlStr);
				System.out.println("正在下载" + i++ + ":" + imgUrlStr);
				try {
					downLoadFromUrl(imgUrlStr, monthFolder, null);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Files.write(doneFile.toPath(), alreadyList);
	}

	public static void downLoadFromUrl(String urlStr, File saveDir, String toekn) throws IOException {
		// https://thehentaiworld.com/wp-content/uploads/2020/04/Haruno-Sakura-Uchiha-Sarada-and-Uzumaki-Boruto-Criquet-Naruto-Hentai.jpeg
		URL url = new URL(urlStr);
		IPath path = new Path(url.getPath());
		path = path.removeFirstSegments(1);
		String newImgFileName = String.join("-", path.segments());

		File imgFile = new File(saveDir, newImgFileName);

		// 文件保存位置
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		if (imgFile.exists()) {
			System.out.println(imgFile + "\t already exist. ");
			return;
		}
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置超时间为3秒
		conn.setConnectTimeout(3 * 1000);
		// 防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:106.0) Gecko/20100101 Firefox/106.0");
		conn.setRequestProperty("Accept", "https://wx1.sinaimg.cn/large/005Mno6Aly1h7q1mzwd8gj32m83xcnpi.jpg");
		conn.setRequestProperty("referer", "https://weibo.com/u/5295502496?tabtype=album&uid=5295502496&index=0");

		// 得到输入流
		InputStream inputStream = conn.getInputStream();
		// 获取自己数组
		byte[] getData = readInputStream(inputStream);

		FileOutputStream fos = new FileOutputStream(imgFile);
		fos.write(getData);
		if (fos != null) {
			fos.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}
		System.out.println(imgFile + "\t done");
	}

	/**
	 * 从输入流中获取字节数组
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	public static JSONArray getImgMap(File logFile) throws IOException {
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
