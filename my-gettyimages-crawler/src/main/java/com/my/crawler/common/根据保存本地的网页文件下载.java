package com.my.crawler.common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 根据保存本地的网页文件下载 {
	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		String folderPath = "F:\\女星\\gettyimages\\yang-mi";
		folderPath = "G:\\女星\\gettyimages\\欧美\\kate-beckinsale";
		
		
		start(folderPath, false);
	}
	
	static void start(String folderPath, boolean isMultiThread) {
		File folder = new File(folderPath);

		List<File> searchedFiles = new ArrayList<>();
		searchTextFiles(folder, searchedFiles);

		if (isMultiThread) {

			ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

			for (File file : searchedFiles) {
				fixedThreadPool.execute(() -> {
					System.out.println("开始读取文件: " + file);
					try {
						downloadFromFile(file);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
			}
		} else {
			for (File file : searchedFiles) {
				System.out.println("开始读取文件: " + file);
				try {
					downloadFromFile(file);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static void searchTextFiles(File file, List<File> searched) {
		if(file.isFile()) {
			if(file.getName().endsWith(".txt")) {
				searched.add(file);
			} else if(file.getName().endsWith(".html")) {
				searched.add(file);
			}
			return;
		}
		for(File subFile: file.listFiles()) {
			searchTextFiles(subFile, searched);
		}
	}
	
	static void downloadFromFile(final File savedHtmlFile) throws IOException, InterruptedException {
		final File outputFolder = savedHtmlFile.getParentFile();
		
		Document document = Jsoup.parse(savedHtmlFile, "UTF-8");
		Elements elements = document.getElementsByAttributeValue("class","gallery-asset__thumb gallery-mosaic-asset__thumb");
		if(elements.isEmpty()) {
			elements = document.getElementsByAttributeValue("class", "MosaicAsset-module__thumb___yvFP5");
		}
		final List<String> imgUrlList = new ArrayList<String>();
		for (Element figureEle : elements) {
			String imgUrlStr  = figureEle.attr("src");
			imgUrlStr = imgUrlStr.substring(0, imgUrlStr.indexOf("?"));
			imgUrlStr = imgUrlStr+"?s=2048x2048";
			imgUrlList.add(imgUrlStr);
			
			System.out.println(imgUrlStr);
		}
		System.out.println("正在下载:"+imgUrlList.size());
		Iterator<String> iterator = imgUrlList.iterator();
		
//		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		while(iterator.hasNext()) {
//			fixedThreadPool.execute(()->{
				
				String imgUrlStr = iterator.next();
				System.out.println(Thread.currentThread().getName()+" 正在下载:" + imgUrlStr);
				try {
					DownloadUtil.downLoadFromUrl(imgUrlStr, outputFolder, null);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
//			});
		}
	}
}	
