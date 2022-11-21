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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class GettyImagesDownloadByLog {
	public static void main(String[] args) {
		File outputFolder ;
		outputFolder = new File("G:\\女星\\gettyimages\\欧美\\monica-bellucci");
		Set<String> imgList = getImgList(outputFolder);
		System.out.println("总大小: "+imgList.size());
		Iterator<String> iterator = imgList.iterator();
		int i = 0;
		// ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		while (iterator.hasNext()) {
			// fixedThreadPool.execute(()->{

			String imgUrlStr = iterator.next();
			System.out.println(Thread.currentThread().getName() + " 正在下载" + i++ + ":" + imgUrlStr);
			try {
				downLoadFromUrl(imgUrlStr, outputFolder, null);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// });
		}
	}

	public static void downLoadFromUrl(String urlStr, File saveDir, String toekn) throws IOException {
		// https://thehentaiworld.com/wp-content/uploads/2020/04/Haruno-Sakura-Uchiha-Sarada-and-Uzumaki-Boruto-Criquet-Naruto-Hentai.jpeg
		URL url = new URL(urlStr);
		IPath path = new Path(url.getPath());

		File imgFile = new File(saveDir, path.lastSegment()+".jpg");

		// 文件保存位置
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		if (imgFile.exists()) {
			System.out.println("File " + imgFile + " already exist. ");
			return;
		}
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
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

	public static Set<String> getImgList(File outputFolder) {
		File logFile = new File(outputFolder, "list.log");
		if (logFile.exists()) {
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(logFile), "UTF-8"));) {

				String line = null;
				Set<String> imgList = new LinkedHashSet<>();
				while ((line = reader.readLine()) != null) {
					if (!line.isEmpty())
						imgList.add(line);
				}
				return imgList;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
}
