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
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.SimpleFileVisitor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class DownloadBySearchLog {
	public static void main(String[] args) throws IOException {
		File outputFolder = new File("G:\\xhamster9.com2\\gretchen-mol\\listlogs");
		outputFolder = new File("G:\\xhamster9.com2");
		outputFolder = new File("G:\\女星\\xhamster9.com");
		// outputFolder = new File("G:\\女星\\xhamster9.com\\jennifer-connelly");

		ExecutorService executorService = Executors.newFixedThreadPool(16);
		Files.walkFileTree(outputFolder.toPath(), new SimpleFileVisitor<java.nio.file.Path>() {
			@Override
			public FileVisitResult postVisitDirectory(java.nio.file.Path dir, IOException exc) throws IOException {
				executorService.submit(() -> {
					File logFile = dir.resolve("list.log").toFile();
					if (logFile.exists()) {
						File doneFile = new File(logFile.getParentFile(), "done");
//						if(doneFile.exists()) {
//							return;
//						}
						download(logFile);
						try {
							doneFile.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				return super.postVisitDirectory(dir, exc);
			}
		});
		executorService.shutdown();
	}

	private static void download(File logFile) {
		Map<String, String> nameUrlMap = getNameUrlMap(logFile);
		if (nameUrlMap == null)
			return;
		System.out.println("总大小: " + nameUrlMap.size());
		Iterator<Entry<String, String>> iterator = nameUrlMap.entrySet().iterator();
		int i = 0;
		// ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		while (iterator.hasNext()) {
			// fixedThreadPool.execute(()->{

			Entry<String, String> entry = iterator.next();
			System.out.println(Thread.currentThread().getName() + " 正在下载" + i++ + ":" + entry.getValue());
			try {
				downLoadFromUrl(entry.getKey(), entry.getValue(), logFile.getParentFile(), null);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			// });
		}
	}

	public static void downLoadFromUrl(String indexName, String urlStr, File saveDir, String toekn) throws IOException {
		// https://thehentaiworld.com/wp-content/uploads/2020/04/Haruno-Sakura-Uchiha-Sarada-and-Uzumaki-Boruto-Criquet-Naruto-Hentai.jpeg
		// 文件保存位置
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}

		URL url = new URL(urlStr);
		IPath path = new Path(url.getPath());
		path = path.removeFirstSegments(2);
		String newImgFileName = String.join("-", path.segments());
		String suffix = newImgFileName.substring(newImgFileName.lastIndexOf('.'));

		File imgFile = new File(saveDir, newImgFileName);
		File indexNameFile = new File(saveDir, indexName+suffix);
		if (indexNameFile.exists()) {
			if(imgFile.exists()) {
				indexNameFile.delete();
			} else {
				indexNameFile.renameTo(imgFile);
			}
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

	public static Map<String, String> getNameUrlMap(File logFile) {
		if (logFile.exists()) {
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(logFile), "UTF-8"));) {

				String line = null;
				Map<String, String> nameUrlMap = new LinkedHashMap<>();
				while ((line = reader.readLine()) != null) {
					if (line.isEmpty())
						continue;
					IPath path = new Path(line);
					if (path.lastSegment().indexOf('.') == -1) {
						continue;
					}
					int index = line.indexOf("=");
					if (index != -1) {
						String name = line.substring(0, index);
						String url = line.substring(index + 1);
						nameUrlMap.put(name, url);
					}
				}
				return nameUrlMap;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
}
