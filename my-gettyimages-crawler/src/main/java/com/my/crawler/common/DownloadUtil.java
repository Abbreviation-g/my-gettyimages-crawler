package com.my.crawler.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class DownloadUtil {
	/**
	 * 从网络Url中下载文件
	 * 
	 * @param urlStr
	 * @param fileName
	 * @param savePath
	 * @throws IOException
	 */
	public static void downLoadFromUrl(String urlStr, File saveDir, String toekn)
			throws IOException {
		URL url = new URL(urlStr);
		IPath path = new Path(url.getPath());
		path = path.makeRelativeTo(new Path("photos"));
		
		File imgFile = new File(saveDir, path+".jpg");
		
		// 文件保存位置
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		if(imgFile.exists()){
			System.out.println("File "+imgFile+" already exist. ");
			return;
		}
		imgFile.createNewFile();
		
		InetSocketAddress addr = new InetSocketAddress("127.0.0.1",10809);  
        Proxy proxy = new Proxy(Proxy.Type.HTTP, addr); // http 代理  
        URLConnection conn = url.openConnection(proxy);  
        
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
		System.out.println("Download "+imgFile +" success.");
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

	public static void main(String[] args) throws IOException {
		String urlStr = "https://media.gettyimages.com/photos/elle-fanning-and-angelina-jolie-attend-a-photocall-for-maleficent-of-picture-id1180216909?s=2048x2048";
		String savePath = "F:\\女星\\gettyimages\\angelina-jolie";
		downLoadFromUrl(urlStr, new File(savePath), null);
	}
}
