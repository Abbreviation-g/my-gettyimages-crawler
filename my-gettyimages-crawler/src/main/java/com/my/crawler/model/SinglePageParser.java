package com.my.crawler.model;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlElement;

public class SinglePageParser {
	private HtmlElement document;
	protected List<String> imgUrlList;

	public SinglePageParser(HtmlElement document) {
		this.document = document;
		this.imgUrlList = new ArrayList<>();
		parsePage();
	}
	
	public void parsePage() {
		List<HtmlElement> imgEles = document.getElementsByAttribute("img", "class", "gallery-asset__thumb gallery-mosaic-asset__thumb");
		for (HtmlElement imgEle : imgEles) {
			String imgUrlStr  = imgEle.getAttribute("src");
			imgUrlStr = imgUrlStr.substring(0, imgUrlStr.indexOf("?"));
			imgUrlStr = imgUrlStr+"?s=2048x2048";
			this.imgUrlList.add(imgUrlStr);
			
			System.out.println(imgUrlStr);
		}
	}
	
	public List<String> getImgUrlList() {
		return imgUrlList;
	}
}
