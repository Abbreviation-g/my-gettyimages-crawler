package com.my.crawler.common;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

import com.gargoylesoftware.htmlunit.WebClient;
import com.my.crawler.model.DownloadUtil;
import com.my.crawler.model.Downloader;

public class DownloadByList {
	public static void main(String[] args) throws MalformedURLException {
		File outputFolder = new File("F:\\女星\\gettyimages\\nicole-kidman");
		downloadByList(outputFolder);
	}
	
	static void downloadByList(File outputFolder) throws MalformedURLException {
		final WebClient webClient = new WebClient();
		webClient.getOptions().setUseInsecureSSL(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setPrintContentOnFailingStatusCode(false);
		webClient.getOptions().setTimeout(10*1000);
		
		Set<String> imgSet =  Downloader.getImgList(null, null, outputFolder);
		System.out.println("正在下载:"+imgSet.size());
		Iterator<String> iterator = imgSet.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			String imgUrlStr = iterator.next();
			System.out.println("正在下载:" + (i + 1) + "/" + imgSet.size());
			System.out.println(imgUrlStr);
			System.out.println(i + 1 + "/" + imgSet.size());
			DownloadUtil.downloadImg(webClient, imgUrlStr, outputFolder);
			i++;
		}
	}
}
