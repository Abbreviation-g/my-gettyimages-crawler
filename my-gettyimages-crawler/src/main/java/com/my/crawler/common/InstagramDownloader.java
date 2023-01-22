package com.my.crawler.common;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;

public class InstagramDownloader {
	static String getCookieStr() {
		String cookie = "ig_did=6460CD91-019B-4F79-BA21-E9BEC468C232; ig_nrcb=1; mid=Y0oa9AALAAFlhOWVaVVhKO5eUIDK; csrftoken=97WDnx3w82qsoxRC3TLGWAhnykYivvWf; ds_user_id=46532699628; datr=FRtKY4E-TWn2N5XdnpuaNxhD; dpr=1.25; shbid=\"8982\\05446532699628\\0541704888766:01f7e910413951b140d19c56ecf1a1621316498b48f2ee1bac8c51c6b0d951848d2528a8\"; shbts=\"1673352766\\05446532699628\\0541704888766:01f7318ba4c86ebdc11a0050183a4d04dc7ce3e404f223300306762b6d863a89f511d8a3\"; sessionid=46532699628%3AAfaFBM2umG4hUO%3A26%3AAYdIbMmw1oLi_J-Xq8uUYAXoBfGOlocOHJuRB0HQ6g; rur=\"PRN\\05446532699628\\0541704890029:01f79323725d5ee9d36b9754e6c32a0da0d4833846567384c8c4a8f36a503ebcf95b8984\"";

		return cookie;
	}
	static List<Cookie> getCookie(String domain) {
		String cookie = getCookieStr();
		String[] arr = cookie.split(";\\s");

		List<Cookie> cookies = new ArrayList<>();
		for (String str : arr) {
			String[] arr2 = str.split("=");
			cookies.add(new Cookie(domain, arr2[0], arr2[1]));
		}
		return cookies;
	}

	static void addCookie(String domain, CookieManager cookieManager) {
		List<Cookie> cookies = getCookie(domain);
		for (Cookie cookie : cookies) {
			cookieManager.addCookie(cookie);
		}
	}

	public static void main(String[] args) {
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.NoOpLog");
		final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60, "127.0.0.1", 10809);
		webClient.getOptions().setUseInsecureSSL(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setPrintContentOnFailingStatusCode(false);
		webClient.getOptions().setTimeout(10 * 1000);
		webClient.getCookieManager().setCookiesEnabled(true);

		try {
			final String domain = "www.instagram.com";
			String imgPageUrl = "https://www.instagram.com//p/CdX5UXkpA1y/";
			imgPageUrl = "https://www.instagram.com/api/v1/media/2834986578804477298/info/";
			CookieManager cookieManager = webClient.getCookieManager();
			addCookie(domain, cookieManager);

			final WebRequest request = new WebRequest(new URL(imgPageUrl),
					webClient.getBrowserVersion().getHtmlAcceptHeader());
			request.setCharset(StandardCharsets.UTF_8);
			request.setAdditionalHeaders(getHeader());
			
			
			Page page = webClient.getPage(webClient.getCurrentWindow().getTopWindow(), request);
			System.out.println(page);
			
			

		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		}

		webClient.close();
	}
	
	public static Map<String, String> getHeader(){
		String headers = ":authority: www.instagram.com\r\n"
				+ ":method: GET\r\n"
				+ ":path: /api/v1/media/2834986578804477298/info/\r\n"
				+ ":scheme: https\r\n"
				+ "accept: */*\r\n"
				+ "accept-encoding: gzip, deflate, br\r\n"
				+ "accept-language: zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7\r\n"
				+ "cookie: ig_did=6460CD91-019B-4F79-BA21-E9BEC468C232; ig_nrcb=1; mid=Y0oa9AALAAFlhOWVaVVhKO5eUIDK; csrftoken=97WDnx3w82qsoxRC3TLGWAhnykYivvWf; ds_user_id=46532699628; datr=FRtKY4E-TWn2N5XdnpuaNxhD; dpr=1.25; shbid=\"8982\\05446532699628\\0541704888766:01f7e910413951b140d19c56ecf1a1621316498b48f2ee1bac8c51c6b0d951848d2528a8\"; shbts=\"1673352766\\05446532699628\\0541704888766:01f7318ba4c86ebdc11a0050183a4d04dc7ce3e404f223300306762b6d863a89f511d8a3\"; sessionid=46532699628%3AAfaFBM2umG4hUO%3A26%3AAYdIbMmw1oLi_J-Xq8uUYAXoBfGOlocOHJuRB0HQ6g; rur=\"PRN\\05446532699628\\0541704891793:01f75fa4b9847ec64f8db6a200fb2b6f84720c998533245bed04a3df95c940b4d6f51c23\"\r\n"
				+ "referer: https://www.instagram.com//p/CdX5UXkpA1y/\r\n"
				+ "sec-ch-prefers-color-scheme: dark\r\n"
				+ "sec-ch-ua: \"Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108\"\r\n"
				+ "sec-ch-ua-mobile: ?0\r\n"
				+ "sec-ch-ua-platform: \"Windows\"\r\n"
				+ "sec-fetch-dest: empty\r\n"
				+ "sec-fetch-mode: cors\r\n"
				+ "sec-fetch-site: same-origin\r\n"
				+ "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36\r\n"
				+ "viewport-width: 1536\r\n"
				+ "x-asbd-id: 198387\r\n"
				+ "x-csrftoken: 97WDnx3w82qsoxRC3TLGWAhnykYivvWf\r\n"
				+ "x-ig-app-id: 936619743392459\r\n"
				+ "x-ig-www-claim: hmac.AR2TsHuZKrtsmtefmiTonhuLIkuAMoLVDd55_o_OC6t9gBkz\r\n"
				+ "x-requested-with: XMLHttpRequest";
		
		Map<String, String> map = new LinkedHashMap<>();
		String[] arr0 = headers.split("\\r\\n");
		for (String header : arr0) {
			System.out.println(header);
			String[] arr1 = header.split(":\\s");
			map.put(arr1[0], arr1[1]);
		}
		return map;
	}
}
