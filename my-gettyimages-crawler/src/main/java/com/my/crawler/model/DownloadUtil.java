package com.my.crawler.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;

public class DownloadUtil {
	public static void downloadImg(final WebClient webClient, String urlStr, File outputFolder)
			throws MalformedURLException {
		for (int i = 0; i < 4; i++) {
			try {
				// https://media.gettyimages.com/id/94831811/zh/%E7%85%A7%E7%89%87/actress-kate-beckinsale-announces-the-nominations-for-the-63rd-annual-golden-globe-awards-at-the.jpg?s=2048x2048&w=gi&k=20&c=sp0sk-ULgLv8PEZpcWBtGFbvMpnYC1ovGOucbBZ2Zlo=
				URL url = new URL(urlStr);

				int indexOfId = urlStr.indexOf("/id/");
				indexOfId = indexOfId + "/id/".length();
				
				int indexOfPhoto = urlStr.indexOf("/",indexOfId+1);
				String id = urlStr.substring(indexOfId, indexOfPhoto);
				int end = urlStr.indexOf('?');
				int start = urlStr.lastIndexOf('/')+1;
				String imgFileName = id +"-" + urlStr.substring(start, end);

				File imgFile = new File(outputFolder, imgFileName);
				if (imgFile.exists()) {
					System.out.println(imgFile + " already exist. ");
					return;
				}
				File parentFolder = imgFile.getParentFile();
				if (!parentFolder.exists()) {
					parentFolder.mkdirs();
				}

				Thread.sleep(10 * 1000);
				Page page = webClient.getPage(url);
				if (page instanceof UnexpectedPage) {
					UnexpectedPage unexpectedPage = (UnexpectedPage) page;
					InputStream inputStream = unexpectedPage.getInputStream();
					downloadImg(inputStream, imgFile);
					return;
				}
			} catch (FailingHttpStatusCodeException e) {
				System.err.println(e.getMessage());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static void downloadImg(InputStream inputStream, File imgFile) {
		try (FileOutputStream writer = new FileOutputStream(imgFile);) {
			byte[] data = new byte[1024];
			int n = 0;
			while ((n = inputStream.read(data)) != -1) {
				writer.write(data, 0, n);
			}
			inputStream.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Download " + imgFile + " failed. ");
		}

		System.out.println("Download " + imgFile + " is done. ");
	}
	
	public static void main(String[] args) {
		String urlStr =  "https://media.gettyimages.com/id/94831811/zh/%E7%85%A7%E7%89%87/actress-kate-beckinsale-announces-the-nominations-for-the-63rd-annual-golden-globe-awards-at-the.jpg?s=2048x2048&w=gi&k=20&c=sp0sk-ULgLv8PEZpcWBtGFbvMpnYC1ovGOucbBZ2Zlo=";

		int indexOfId = urlStr.indexOf("/id/");
		indexOfId = indexOfId + "/id/".length();
		
		int indexOfPhoto = urlStr.indexOf("/",indexOfId+1);
		String id = urlStr.substring(indexOfId, indexOfPhoto);
		int end = urlStr.indexOf('?');
		int start = urlStr.lastIndexOf('/')+1;
		String imgFileName = id +"-" + urlStr.substring(start, end);
		System.out.println(imgFileName);
	}
}
