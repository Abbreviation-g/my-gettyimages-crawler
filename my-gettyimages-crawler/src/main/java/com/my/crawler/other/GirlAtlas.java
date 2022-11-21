package com.my.crawler.other;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlUnorderedList;
import com.my.crawler.model.DownloadUtil;

public class GirlAtlas {
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		final String url = "http://girl-atlas.net/album/5ef7953b478a021a38761e42?display=2";
		final File outputFolder = new File("C:\\games\\桥本爱实","EX180 橋本マナミ　HASHIMOTO MANAMI");
		
		final WebClient webClient = new WebClient();
		webClient.getOptions().setUseInsecureSSL(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setPrintContentOnFailingStatusCode(false);
		webClient.getOptions().setTimeout(10 * 1000);

		Page page = webClient.getPage(url);
		HtmlPage htmlPage = (HtmlPage) page;
		System.out.println(htmlPage);
		
		HtmlElement document = htmlPage.getDocumentElement();
		List<HtmlElement> elements =document.getElementsByAttribute("ul", "class", "gridview");
		System.out.println(elements);
		HtmlUnorderedList ul= (HtmlUnorderedList) elements.get(0);
		
		List<String> imgUrls = new ArrayList<String>(); 
		List<HtmlElement> aElements = ul.getElementsByTagName("a");
		for (HtmlElement element : aElements) {
			HtmlAnchor anchor = (HtmlAnchor) element;
			imgUrls.add(anchor.getHrefAttribute());
		}
		
		for (String imgUrl : imgUrls) {
			download(imgUrl, url, outputFolder);
		}
		
		webClient.close();
	}
	
	public static void download(String urlStr, String Referer, File outputFolder) {
		String fileName = urlStr.substring(urlStr.lastIndexOf("/") + 1, urlStr.length());
		fileName = fileName.substring(0, fileName.lastIndexOf("!"));
		File imgFile = new File(outputFolder, fileName);
		if (imgFile.exists()) {
			System.out.println(imgFile + " already exists. ");
			return;
		}
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Referer", Referer);
			InputStream inputStream = connection.getInputStream();
			if (!outputFolder.exists())
				outputFolder.mkdirs();
			FileOutputStream writer = new FileOutputStream(imgFile);
			byte[] data = new byte[1024];
			int n = 0;
			while ((n = inputStream.read(data)) != -1) {
				writer.write(data, 0, n);
			}
			inputStream.close();
			writer.close();

			System.out.println("Download " + imgFile + " is done. ");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
