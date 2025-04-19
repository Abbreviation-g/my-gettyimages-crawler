package com.my.crawler.weibo2;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class WeiboUIDToWeiboArray {
	public static CloseableHttpClient createHttpClients() {
		if (!Constants.isProxy) {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			return httpClient;
		} else {
			// 创建代理服务器的配置
			HttpHost proxy = new HttpHost("127.0.0.1", 10809);
			// 创建HttpClientBuilder
			HttpClientBuilder builder = HttpClients.custom();
			// 设置代理
			builder.setProxy(proxy);
			return builder.build();
		}
	}

	private static class Crawler {
		private String uid;
		private int page = 0;
		private List<Header> headers;
		private CloseableHttpClient httpClient;
		private ContentEntity contentEntity;

		public Crawler(String uid, int page, List<Header> headers, CloseableHttpClient httpClient) {
			this.uid = uid;
			this.page = page;
			this.headers = headers;
			this.httpClient = httpClient;
		}

		private String createUrlStr() {
			final String urlStrFormat = "https://weibo.com/ajax/statuses/mymblog?uid=%s&page=%d&feature=0";
			String urlStr = String.format(urlStrFormat, uid, page);
			return urlStr;
		}

		public void start() throws ClientProtocolException, IOException {
			String content = sendGet();
			if (content != null && !content.isBlank()) {
				this.contentEntity = parseContent(content);
			}
		}

		private String getSinceId() {
			String sinceid = null;
			if (contentEntity != null && contentEntity.data != null) {
				sinceid = contentEntity.data.since_id;
			}
			return sinceid;
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
				System.out.println("--------------------------------------------------------");
				System.out.println(urlStr);

				// 判断响应状态码是否为200
				if (response.getStatusLine().getStatusCode() == 200) {
					System.out.println(response.getStatusLine());

					// 获取返回数据
					HttpEntity httpEntity = response.getEntity();
					String content = EntityUtils.toString(httpEntity, "UTF-8");

//					System.out.println(content);
					return content;
				} else {
					System.err.println(response.getStatusLine());
					return null;
				}
			} finally {
				// 释放连接
				if (response != null) {
					response.close();
				}
			}
		}

		public ContentEntity getContentEntity() {
			return contentEntity;
		}
	}

	private static class ContentEntity {
		public DataEntity data;
	}

	private static class DataEntity {
		public String since_id;
		public JSONArray list;
	}

	public static JSONArray getWeiboArray(String uid) throws IOException {
		return getWeiboArray(uid, null);
	}

	public static JSONArray getWeiboArray(String uid, Date lastestDate) throws IOException {
		return getWeiboArray(uid, 0, lastestDate);
	}
	
	public static JSONArray getWeiboArray(String uid, Integer beginPage,int endPage, Date lastestDate) throws IOException {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		final List<Header> headers = Headers.readHeader();
		// TODO
		final CloseableHttpClient httpClient = createHttpClients();

		String sinceid = "0";
		int page = beginPage;
		JSONArray array = new JSONArray();
		while (sinceid != null) {
			Crawler crawler = new Crawler(uid, page, headers, httpClient);
			crawler.start();
			page++;

			sinceid = crawler.getSinceId();
			ContentEntity contentEntity = crawler.getContentEntity();
			if (contentEntity == null || contentEntity.data == null || contentEntity.data.list == null) {
				continue;
			}
			JSONArray list = contentEntity.data.list;
			array.addAll(list);
			if (lastestDate != null) {
				boolean shouldBreak = shouldBreak(list, lastestDate);
				if (shouldBreak) {
					break;
				}
			}

			if (sinceid == null || sinceid.isEmpty() || "0".equals(sinceid)) {
				break;
			}

			if (page >= endPage) {
				break;
			}
			Constants.randomSleepLong();
		}
		httpClient.close();

		return array;
	}

	public static JSONArray getWeiboArray(String uid, Integer beginPage, Date lastestDate) throws IOException {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		final List<Header> headers = Headers.readHeader();
		// TODO
		final CloseableHttpClient httpClient = createHttpClients();

		String sinceid = "0";
		int page = beginPage;
		JSONArray array = new JSONArray();
		while (sinceid != null) {
			Crawler crawler = new Crawler(uid, page, headers, httpClient);
			crawler.start();
			page++;

			sinceid = crawler.getSinceId();
			ContentEntity contentEntity = crawler.getContentEntity();
			if (contentEntity == null || contentEntity.data == null || contentEntity.data.list == null) {
				continue;
			}
			JSONArray list = contentEntity.data.list;
			array.addAll(list);
			if (lastestDate != null) {
				boolean shouldBreak = shouldBreak(list, lastestDate);
				if (shouldBreak) {
					break;
				}
			}

			if (sinceid == null || sinceid.isEmpty() || "0".equals(sinceid)) {
				break;
			}

			Constants.randomSleepLong();
		}
		httpClient.close();

		return array;
	}

	private static boolean shouldBreak(JSONArray list, Date lastestDate) {
//		for (int i = 0; i < list.size(); i++) {
//			JSONObject jsonObject = list.getJSONObject(i);
//			if ("1".equals(jsonObject.getString("isTop"))) {
//				continue;
//			}
//			String created_at = jsonObject.getString("created_at");
//			@SuppressWarnings("deprecation")
//			Date currentDate = new Date(created_at);
//			if (currentDate.before(lastestDate)) {
//				return true;
//			}
//		}
		if (list.isEmpty()) {
			return false;
		}

		JSONObject jsonObject = list.getJSONObject(list.size() - 1);
		if ("1".equals(jsonObject.getString("isTop"))) {
			return false;
		}
		String created_at = jsonObject.getString("created_at");
		@SuppressWarnings("deprecation")
		Date currentDate = new Date(created_at);
		if (currentDate.before(lastestDate)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		String uid = "2602190401";
		getWeiboArray(uid);
	}
}
