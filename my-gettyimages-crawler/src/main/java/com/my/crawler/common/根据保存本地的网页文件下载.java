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
//		folderPath = "F:\\女星\\gettyimages\\chen-tingjia";
		folderPath = "F:\\女星\\gettyimages\\coulee-nazha";
		folderPath = "F:\\女星\\gettyimages\\wang-ou";
//		folderPath = "F:\\女星\\gettyimages\\xu-qing";
//		folderPath = "F:\\女星\\gettyimages\\zhang-xueying";
//		folderPath = "F:\\女星\\gettyimages\\yuan-shanshan";
		folderPath = "F:\\女星\\gettyimages\\guan-xiaotong";
//		folderPath = "F:\\女星\\gettyimages\\jing-tian";
//		folderPath = "F:\\女星\\gettyimages\\rayza";
		folderPath = "F:\\女星\\gettyimages\\lin-yun";
		folderPath = "F:\\女星\\gettyimages\\tang-yan";
		folderPath = "F:\\女星\\gettyimages\\jiang-shuying";
		folderPath = "F:\\女星\\gettyimages\\jiang-mengjie";
		folderPath = "F:\\女星\\gettyimages\\hao-lei";
//		folderPath = "F:\\女星\\gettyimages\\gong-li";
		folderPath = "F:\\女星\\gettyimages\\yifei-liu";
//		folderPath = "F:\\女星\\gettyimages\\huo-siyan";
		folderPath = "F:\\女星\\gettyimages\\angelina-jolie";
		folderPath = "F:\\女星\\gettyimages\\song zuer";
		folderPath = "F:\\女星\\gettyimages\\dilraba";
		folderPath = "F:\\女星\\gettyimages\\liu tao";
		folderPath = "F:\\女星\\gettyimages\\li yitong";
		folderPath = "F:\\女星\\gettyimages\\song jia";
		folderPath = "F:\\女星\\gettyimages\\nana-ouyang";
		folderPath = "F:\\女星\\gettyimages\\zhang xueying";
		folderPath = "G:\\女星\\gettyimages\\chloe-moretz\\1";
		folderPath = "G:\\女星\\gettyimages\\chloe-moretz\\2";
		folderPath = "G:\\女星\\gettyimages\\chloe-moretz\\3";
		folderPath = "G:\\女星\\gettyimages\\Leelee-Sobieski";
		folderPath = "G:\\女星\\gettyimages\\chloe-moretz\\5";
		folderPath = "G:\\女星\\gettyimages\\chloe-moretz\\leg";
		folderPath = "G:\\女星\\gettyimages\\chloe-moretz\\close-up";
		folderPath = "G:\\女星\\gettyimages\\kristen-stewart\\close up";
		folderPath = "G:\\女星\\gettyimages\\angelina-jolie";
		folderPath = "G:\\女星\\gettyimages\\angelina-jolie\\lips";
//		folderPath = "G:\\女星\\gettyimages\\angelina-jolie\\legs";
		folderPath = "G:\\女星\\gettyimages\\willow-shields\\close-up";
		folderPath = "G:\\女星\\gettyimages\\angelina-jolie\\close up";
		folderPath = "G:\\女星\\gettyimages\\isabelle-fuhrman\\close up";
		folderPath = "G:\\女星\\gettyimages\\emma-watson\\close up";
		folderPath = "G:\\女星\\gettyimages\\nicole-kidman\\face";
		folderPath = "G:\\女星\\gettyimages\\amber-heard\\close-up";
		folderPath = "G:\\女星\\gettyimages\\hailee-steinfeld\\leg";
		folderPath = "G:\\女星\\gettyimages\\sophie-turner\\close up";
		folderPath = "G:\\女星\\gettyimages\\maisie-williams\\close up";
		folderPath = "G:\\女星\\gettyimages\\gal-gadot\\close up";
		folderPath = "G:\\女星\\gettyimages\\欧美\\monica-bellucci\\close up";
		folderPath = "G:\\女星\\gettyimages\\欧美\\Jennifer-Lawrence\\close up";
		folderPath = "G:\\女星\\gettyimages\\欧美\\Jennifer-Lawrence";
		folderPath = "G:\\女星\\gettyimages\\欧美\\scarlett-johansson\\close up";
		folderPath = "G:\\女星\\gettyimages\\欧美\\scarlett-johansson\\face";
		folderPath = "G:\\女星\\gettyimages\\欧美\\scarlett-johansson\\feet";
		folderPath = "G:\\女星\\gettyimages\\欧美\\scarlett-johansson\\sexy";
		folderPath = "G:\\女星\\gettyimages\\欧美\\chloe-moretz\\close-up";
		folderPath = "G:\\女星\\gettyimages\\欧美\\sophie-turner\\close up";
		folderPath = "G:\\女星\\gettyimages\\欧美\\kristen-stewart\\black sock";
		folderPath = "G:\\女星\\gettyimages\\欧美\\kristen-stewart\\leg";
		folderPath = "G:\\女星\\gettyimages\\欧美\\nicole-kidman\\mouth";
		folderPath = "G:\\女星\\gettyimages\\欧美\\nicole-kidman\\tongue";
		folderPath = "G:\\女星\\gettyimages\\欧美\\monica-bellucci\\close up";
		folderPath = "G:\\女星\\gettyimages\\欧美\\Charlize-Theron\\gq";
		folderPath = "G:\\女星\\gettyimages\\欧美\\Charlize-Theron\\backless";
		folderPath = "G:\\女星\\gettyimages\\欧美\\nicole-kidman\\backless";
		folderPath = "G:\\女星\\gettyimages\\欧美\\jessica-henwick";
		folderPath = "G:\\女星\\gettyimages\\欧美\\keisha-castle-hughes";
		folderPath = "G:\\女星\\gettyimages\\欧美\\elizabeth-olsen";
		folderPath = "G:\\女星\\gettyimages\\欧美\\carice-van-houten";
		folderPath = "G:\\女星\\gettyimages\\欧美\\rose-leslie-detail";
		folderPath = "G:\\女星\\gettyimages\\欧美\\natalie-dormer";
		folderPath = "G:\\女星\\gettyimages\\华人\\guan-xiaotong";
		folderPath = "G:\\女星\\gettyimages\\华人\\coulee-nazha";
		folderPath = "G:\\女星\\gettyimages\\华人\\nana-ouyang";
		folderPath = "G:\\女星\\gettyimages\\华人\\zhou-dongyu";
		folderPath = "G:\\女星\\gettyimages\\华人\\zhang-yuqi";
		folderPath = "G:\\女星\\gettyimages\\欧美\\alicia-vikander\\detail";
//		folderPath = "G:\\女星\\gettyimages\\欧美\\alicia-vikander\\chest";
		folderPath = "G:\\女星\\gettyimages\\欧美\\riley-keough";
		folderPath = "G:\\女星\\gettyimages\\欧美\\monica-bellucci\\chest";
		folderPath = "G:\\女星\\gettyimages\\欧美\\ivanka-trump\\chest";
		folderPath = "G:\\女星\\gettyimages\\欧美\\ivanka-trump\\pregnant";
		folderPath = "G:\\女星\\gettyimages\\欧美\\gal-gadot\\2020-12-19";
		folderPath = "G:\\女星\\gettyimages\\欧美\\gal-gadot\\close up";
		folderPath = "G:\\女星\\gettyimages\\欧美\\gal-gadot\\29";
		folderPath = "G:\\女星\\gettyimages\\欧美\\kate-winslet";
		folderPath = "G:\\女星\\gettyimages\\欧美\\salma-hayek";
//		folderPath = "G:\\女星\\gettyimages\\欧美\\salma-hayek/chest";
		folderPath = "G:\\女星\\gettyimages\\欧美\\lynda-carter";
		folderPath = "G:\\女星\\gettyimages\\欧美\\demi-moore";
		folderPath = "G:\\女星\\gettyimages\\欧美\\joey-king";
		folderPath = "G:\\女星\\gettyimages\\欧美\\megan-fox\\glass";
		folderPath = "G:\\女星\\gettyimages\\欧美\\chloe-moretz\\jeans";
//		folderPath = "G:\\女星\\gettyimages\\欧美\\chloe-moretz\\close-up";
		folderPath = "G:\\女星\\gettyimages\\欧美\\keeley-hazell";
		folderPath = "G:\\女星\\gettyimages\\欧美\\angelina-jolie\\backless";
		folderPath = "G:\\女星\\gettyimages\\欧美\\angelina-jolie\\lips";
		folderPath = "G:\\女星\\gettyimages\\欧美\\angelina-jolie\\Cleavage";
		folderPath = "G:\\女星\\gettyimages\\欧美\\Natalie-Portman\\nipples";
		folderPath = "G:\\女星\\gettyimages\\欧美\\nicole-kidman\\Cleavage";
		folderPath = "G:\\女星\\gettyimages\\欧美\\nicole-kidman\\tight";
		folderPath = "G:\\女星\\gettyimages\\欧美\\nicole-kidman\\75154182";
		folderPath = "G:\\女星\\gettyimages\\欧美\\nicole-kidman\\glass";
		folderPath = "G:\\女星\\gettyimages\\欧美\\nicole-kidman\\tight2";
//		folderPath = "G:\\女星\\gettyimages\\欧美\\nicole-kidman\\backless";
//		folderPath = "G:\\女星\\gettyimages\\欧美\\nicole-kidman\\592787479";
		folderPath = "G:\\女星\\gettyimages\\欧美\\hayley-atwell\\detail";
//		folderPath = "G:\\女星\\gettyimages\\欧美\\hayley-atwell\\2";
		folderPath = "G:\\女星\\gettyimages\\华人\\yang-mi\\2021-12-01";
		folderPath = "G:\\女星\\gettyimages\\华人\\dilraba\\2021-12-01";
		folderPath = "G:\\女星\\gettyimages\\华人\\guan-xiaotong\\2021-12-01";
//		folderPath = "G:\\女星\\gettyimages\\华人\\zhou-dongyu\\2021-12-01";
		folderPath = "G:\\女星\\gettyimages\\欧美\\brie-larson";
		
		
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
		Elements elements = document.getElementsByAttributeValue("class","MosaicAsset-module__thumb___yvFP5");
		
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
