package com.my.crawler.weibo2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GetHalfYearFollowers {
	public static void main(String[] args) throws IOException {
		// https://weibo.com/ajax/profile/followContent?sortType=all
		List<UserEntity> userEntities = start(); 

		userEntities.forEach(u -> System.out.println(u.id + "\t" + u.screen_name));
	}

	public static List<UserEntity> start() throws IOException {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		final List<Header> headers = Headers.readHeader();
		final CloseableHttpClient httpClient = HttpClients.createDefault();

		int page = 1;
		List<UserEntity> users = new ArrayList<>();
		List<UserEntity> userEntities = new ArrayList<>();
		do {
			Crawler crawler = new Crawler(page, headers, httpClient);
			crawler.start();

			page++;
			users = crawler.contentEntity.data.users;

			userEntities.addAll(crawler.contentEntity.data.users);
			try {
				Thread.sleep(1 * 1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (!users.isEmpty());

		httpClient.close();

		return userEntities;
	}

	public static class ContentEntity {
		public DataEntity data;
	}

	public static class DataEntity {
		public List<UserEntity> users;
		public int next_cursor;
	}

	public static class UserEntity {
		public String screen_name;
		public String id;
	}

	private static class Crawler {
		private int page = 1;
		private List<Header> headers;
		private CloseableHttpClient httpClient;
		private ContentEntity contentEntity;

		public Crawler(int page, List<Header> headers, CloseableHttpClient httpClient) {
			this.page = page;
			this.headers = headers;
			this.httpClient = httpClient;
		}

		private String createUrlStr() {
			final String urlStrFormat = "https://weibo.com/ajax/profile/getGroupMembers?list_id=4979748384016703&page=%d";
			String urlStr = String.format(urlStrFormat, page);
			return urlStr;
		}

		public void start() throws ClientProtocolException, IOException {
			String content = sendGet();
			this.contentEntity = parseContent(content);
		}

		private ContentEntity parseContent(String content) {
			JSONObject dataEntityJson = JSON.parseObject(content);
			ContentEntity contentEntity = dataEntityJson.toJavaObject(ContentEntity.class);
			return contentEntity;
		}

		private String sendGet() throws ClientProtocolException, IOException {
			String urlStr = createUrlStr();
			HttpGet httpGet = new HttpGet(urlStr);
			httpGet.setHeaders(headers.toArray(new Header[headers.size()]));

			// 响应对象
			CloseableHttpResponse response = null;
			try {
				// 使用HttpClient发起请求
				response = httpClient.execute(httpGet);
				System.out.println("-------");
				System.out.println(urlStr);
				System.out.println(response.getStatusLine());

				// 判断响应状态码是否为200
				if (response.getStatusLine().getStatusCode() == 200) {
					// 获取返回数据
					HttpEntity httpEntity = response.getEntity();
					String content = EntityUtils.toString(httpEntity, "UTF-8");

//					System.out.println(content);
					return content;
				} else {
					return null;
				}
			} finally {
				// 释放连接
				if (response != null) {
					response.close();
				}
			}
		}
	}
}
