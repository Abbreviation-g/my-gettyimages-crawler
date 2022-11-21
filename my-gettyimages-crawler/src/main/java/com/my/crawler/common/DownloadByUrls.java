package com.my.crawler.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class DownloadByUrls {
	public static void main(String[] args) throws IOException {
		File outputFolder = new File("D:\\output");
		
		String firstUrl = "https://i5.nhentai.net/galleries/2343226/1.jpg";
		String title = "Ero Jii san to Ecchi na Keiyaku o Shita Bakunyuu Hitozuma";
		int length = 44;
		
		firstUrl = "https://i7.nhentai.net/galleries/2303406/7.jpg";
		title = "[oreomanko]扶她佐良娜NTR鸣人(djsymq机翻汉化)FutaSara (Boruto)";
		length = 16;
		firstUrl = "https://i3.nhentai.net/galleries/2142776/1.jpg";
		title = "Boruto Erotic Adventure chapter1 Boruto is in trouble";
		length = 35;
		firstUrl = "https://i5.nhentai.net/galleries/2089869/1.jpg";
		title = "borutos birthday clash";
		length = 42;
//		firstUrl = "https://i3.nhentai.net/galleries/1986422/1.jpg";
//		title = "While daddy sleeps 1 (Boruto)";
//		length = 18;
		
		File saveDir = new File(outputFolder,title);
		saveDir.mkdir();
		String prefix = firstUrl.substring(0, firstUrl.lastIndexOf('/'));
		for(int i=1;i<=length;i++) {
			String url = prefix+"/" + i+".jpg";
			System.out.println(Thread.currentThread().getName() + " 正在下载" + i + ":" + url);
			try {
				downLoadFromUrl(url,saveDir, null);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static void downLoadFromUrl(String urlStr, File saveDir, String toekn) throws IOException {
		URL url = new URL(urlStr);
		IPath path = new Path(url.getPath());
		String newImgFileName = path.segment(path.segmentCount()-1);

		File imgFile = new File(saveDir, newImgFileName);

		// 文件保存位置
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		if (imgFile.exists()) {
			System.out.println("File " + imgFile + " already exist. ");
			return;
		}
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 10809));
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
		// 设置超时间为3秒
		conn.setConnectTimeout(3 * 1000);
		// 防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		// conn.setRequestProperty("lfwywxqyh_token", toekn);

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
		System.out.println("Download " + imgFile + " success.");
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

	public static JSONArray getImgMap(File outputFolder) throws IOException {
		File logFile = new File(outputFolder, "json.log");
		if (logFile.exists()) {
			byte[] allBytes = Files.readAllBytes(logFile.toPath()); 
			String content = new String(allBytes);
			if((content.startsWith("\"") && content.endsWith("\"")) || content.startsWith("'") && content.endsWith("'") ||
					content.startsWith("`") && content.endsWith("`")) {
				content = content.substring(1, content.length()-1);
			}
			JSONArray jsonArray = (JSONArray) JSON.parse(content);
			return jsonArray;
		}
		return null;
	}
}
