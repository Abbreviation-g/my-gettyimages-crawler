package com.my.crawler.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

import com.gargoylesoftware.htmlunit.WebClient;

public class Downloader {
	private URL url;
	private File outputFolder;

	public Downloader(final URL url, File outputFolder) throws MalformedURLException {
		this.url = url;
		String subFolder = new Path(url.getPath()).lastSegment();
		this.outputFolder = new File(outputFolder, subFolder);
	}

	public void startDownload(IProgressMonitor monitor) {

		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.NoOpLog");
		final WebClient webClient = new WebClient();
		webClient.getOptions().setUseInsecureSSL(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setPrintContentOnFailingStatusCode(false);
		webClient.getOptions().setTimeout(10*1000);
		try {

			Set<String> imgList = getImgList(webClient, url, outputFolder);
			if (imgList == null) {
				MultiPageParser pageParser = new MultiPageParser(webClient, url);
				pageParser.parsePage(monitor);
				imgList = pageParser.getImgUrlList();
			}

			writeLogFile(url.toString(), imgList, outputFolder);
			monitor.beginTask("正在下载:", imgList.size());
			Iterator<String> iterator = imgList.iterator();
			int i = 0;
			while(iterator.hasNext()) {
				String imgUrlStr = iterator.next();
				if (monitor.isCanceled()) {
					break;
				}
				monitor.setTaskName("正在下载:" + (i + 1) + "/" + imgList.size());
				monitor.subTask(imgUrlStr);
				System.out.println(i + 1 + "/" + imgList.size());
				DownloadUtil.downloadImg(webClient, imgUrlStr, outputFolder);
				monitor.worked(1);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		webClient.close();
	}

	public static Set<String> getImgList(WebClient webClient, URL url, File outputFolder) {
		File logFile = new File(outputFolder, "list.log");
		if (logFile.exists()) {
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(logFile), "UTF-8"));) {

				String line = null;
				Set<String> imgList = new LinkedHashSet<>();
				reader.readLine();// 跳过第一行
				while ((line = reader.readLine()) != null) {
					// imgList.add(line.split("=")[1]);
					int index = line.indexOf('=');
					if(index!=-1) {
						String imgUrlStr = line.substring(index + 1);
						imgList.add(imgUrlStr);
					}
				}
				return imgList;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static void writeLogFile(String url, Set<String> imgList, File outputFolder) {
		if (!outputFolder.exists()) {
			outputFolder.mkdirs();
		}

		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(new File(outputFolder, "list.log")), "UTF-8"));) {
			writer.write(url);
			writer.newLine();
			Iterator<String> iterator = imgList.iterator();
			int i = 0;
			while(iterator.hasNext()) {
				String imgUrl = iterator.next();
				writer.write(i + "=" + imgUrl);
				writer.newLine();
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws MalformedURLException {
		String urlStr = "https://www.gettyimages.fr/photos/mi-yang?family=editorial&phrase=Mi%20Yang&recency=anydate&sort=mostpopular&page=1&suppressfamilycorrection=true";
		urlStr = "https://www.gettyimages.fr/photos/shannon-woodward?family=editorial&phrase=Shannon%20Woodward&sort=mostpopular#license";
		urlStr = "https://www.gettyimages.com/photos/gong-li?family=editorial&phrase=gong%20li&sort=mostpopular";
		urlStr = "https://www.gettyimages.com/photos/gong-li?family=editorial&phrase=gong%20li&sort=mostpopular";
		File outputFolder = new File("F:\\女星\\gettyimages\\monica-bellucci");
		URL url = new URL(urlStr);
		Downloader downloader = new Downloader(url, outputFolder);
		downloader.startDownload(new NullProgressMonitor());
	}
}
