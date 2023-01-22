package com.my.crawler.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.conn.ConnectTimeoutException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class MultiPageParser {
	protected final WebClient webClient;

	protected URL url;
	protected Set<String> imgUrlList;

	public MultiPageParser(final WebClient webClient, URL url) {
		this.webClient = webClient;
		this.url = url;
		this.imgUrlList = new LinkedHashSet<>();
	}

	public void parsePage(IProgressMonitor monitor)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		monitor.beginTask("正在解析" + url, IProgressMonitor.UNKNOWN);
		System.out.println("PageParser" + "-->>" + url);

		HtmlPage htmlPage = getHtmlPage(webClient, url, monitor);
		initImgList(htmlPage, monitor);
	}

	protected HtmlPage getHtmlPage(final WebClient webClient, URL url, IProgressMonitor monitor) {
		for (int i = 0; i < 5; i++) {
			if (monitor.isCanceled()) {
				break;
			}
			try {
				Thread.sleep(10 * 1000);
				Page page = webClient.getPage(url);
				if (page instanceof HtmlPage) {
					HtmlPage htmlPage = (HtmlPage) page;
					return htmlPage;
				}
			} catch (FailingHttpStatusCodeException e) {
				System.err.println(e.getMessage());
			} catch (ConnectTimeoutException | java.net.SocketTimeoutException e) {
				System.err.println(e.getMessage());
				return getHtmlPage(webClient, url, monitor);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	protected void initImgList(HtmlPage htmlPage, IProgressMonitor monitor)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		if (monitor.isCanceled() || htmlPage == null) {
			return;
		}

		HtmlElement document = htmlPage.getDocumentElement();

		List<HtmlElement> imgPageEles = document.getElementsByAttribute("a", "class",
				"MosaicAsset-module__link___wwW2J");
		for (HtmlElement htmlElement : imgPageEles) {
			HtmlAnchor anchor = (HtmlAnchor) htmlElement;
			String imgPageUrl = "https://www.gettyimages.com" + anchor.getHrefAttribute();
			HtmlPage imgPage = webClient.getPage(imgPageUrl);
			HtmlElement imgPageDoc = imgPage.getDocumentElement();
			List<HtmlElement> pictureEles = imgPageDoc.getElementsByAttribute("picture", "data-testid", "hero-picture");
			HtmlElement pictureEle = pictureEles.get(0);
			DomNodeList<HtmlElement> sourceEles = pictureEle.getElementsByTagName("source");
			HtmlElement lastSourceEle = sourceEles.get(sourceEles.getLength() - 1);
			String srcsetImgUrl = lastSourceEle.getAttribute("srcset");
			this.imgUrlList.add(srcsetImgUrl);
		}

//		this.imgUrlList.addAll(new SinglePageParser(document).getImgUrlList());
//		//search-pagination__button search-pagination__button--next
//		List<HtmlElement> aElements = document.getElementsByAttribute("a", "class", "search-pagination__button search-pagination__button--next");
//		if(aElements!= null && aElements.size()==1) {
//			HtmlElement aElement = aElements.get(0);
//			String nextPageHref = aElement.getAttribute("href");
//			nextPageHref = url.getProtocol()+"://"+url.getHost()+"/"+nextPageHref;
//			
//			try {
//				MultiPageParser pageParser = new MultiPageParser(webClient, new URL(nextPageHref));
//				pageParser.parsePage(monitor);
//				this.imgUrlList.addAll(pageParser.getImgUrlList());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

	}

	public Set<String> getImgUrlList() {
		return imgUrlList;
	}
}
