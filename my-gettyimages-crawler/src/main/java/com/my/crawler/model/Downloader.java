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
import java.util.ArrayList;
import java.util.List;

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

		try {

			List<String> imgList = getImgList(webClient, url, outputFolder);
			if (imgList == null) {
				MultiPageParser pageParser = new MultiPageParser(webClient, url);
				pageParser.parsePage(monitor);
				imgList = pageParser.getImgUrlList();
			}

			writeLogFile(url.toString(), imgList, outputFolder);
			monitor.beginTask("正在下载:", imgList.size());
			for (int i = 0; i < imgList.size(); i++) {
				if (monitor.isCanceled()) {
					break;
				}
				String imgUrlStr = imgList.get(i);
				monitor.setTaskName("正在下载:" + (i + 1) + "/" + imgList.size());
				monitor.subTask(imgUrlStr);
				System.out.println(i + 1 + "/" + imgList.size());
				DownloadUtil.downloadImg(webClient, imgUrlStr, outputFolder);
				monitor.worked(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		webClient.close();
	}

	public static List<String> getImgList(WebClient webClient, URL url, File outputFolder) {
		File logFile = new File(outputFolder, "list.log");
		if (logFile.exists()) {
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(logFile), "UTF-8"));) {

				String line = null;
				List<String> imgList = new ArrayList<>();
				while ((line = reader.readLine()) != null) {
					// imgList.add(line.split("=")[1]);
					String imgUrlStr = line.substring(line.indexOf("=") + 1, line.length());
					imgList.add(imgUrlStr);
				}
				return imgList;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static void writeLogFile(String url, List<String> imgList, File outputFolder) {
		if (!outputFolder.exists()) {
			outputFolder.mkdirs();
		}

		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(new File(outputFolder, "list.log")), "UTF-8"));) {
			for (int i = 0; i < imgList.size(); i++) {
				String imgUrl = imgList.get(i);
				writer.write(i + "=" + imgUrl);
				writer.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws MalformedURLException {
		String urlStr = "https://www.gettyimages.fr/photos/mi-yang?family=editorial&phrase=Mi%20Yang&recency=anydate&sort=mostpopular&page=1&suppressfamilycorrection=true";
		File outputFolder = new File("F:\\");
		URL url = new URL(urlStr);
		Downloader downloader = new Downloader(url, outputFolder);
		downloader.startDownload(new NullProgressMonitor());
	}
}
