package com.my.crawler.weibo;

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

public class GetFollowers {
	public static void main(String[] args) throws IOException {
		// https://weibo.com/ajax/profile/followContent?sortType=all
		List<UserEntity> userEntities = start();

		userEntities.forEach(u -> System.out.println(u.id + "\t" + u.screen_name));
	}

	public static List<UserEntity> start() throws IOException {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		final List<Header> headers = Headers.readHeader();
		final CloseableHttpClient httpClient = HttpClients.createDefault();

		int total_number = 0;
		int next_cursor = 50;
		int page = 1;
		List<UserEntity> userEntities = new ArrayList<>();
		do {
			Crawler crawler = new Crawler(page, next_cursor, headers, httpClient);
			crawler.start();

			page++;
			next_cursor += 50;
			total_number = crawler.contentEntity.data.total_number;

			userEntities.addAll(crawler.contentEntity.data.follows.users);
			try {
				Thread.sleep(1 * 1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (next_cursor <= total_number + 50);

		httpClient.close();

		return userEntities;
	}

	public static class ContentEntity {
		public DataEntity data;
	}

	public static class DataEntity {
		public FollowsEntity follows;
		public int total_number;
	}

	public static class FollowsEntity {
		public List<UserEntity> users;
	}

	public static class UserEntity {
		public String screen_name;
		public String id;
	}

	private static class Crawler {
		private int next_cursor = 50;
		private int page = 1;
		private List<Header> headers;
		private CloseableHttpClient httpClient;
		private ContentEntity contentEntity;

		public Crawler(int page, int next_cursor, List<Header> headers, CloseableHttpClient httpClient) {
			this.next_cursor = next_cursor;
			this.page = page;
			this.headers = headers;
			this.httpClient = httpClient;
		}

		private String createUrlStr() {
			final String urlStrFormat = "https://weibo.com/ajax/profile/followContent?page=%d&next_cursor=%d";
			String urlStr = String.format(urlStrFormat, page, next_cursor);
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
