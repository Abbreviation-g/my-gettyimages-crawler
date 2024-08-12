package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class 微博收藏json解析输出到favoritelog {
	public static void main(String[] args) throws IOException {
		String uid = "3603256695";
		String folderPath = "F:\\weibo_log\\梦醒忒远";

		start(uid, folderPath);
	}

	private static class Crawler {
		private String uid;
		private int page = 0;
		private List<Header> headers;
		private CloseableHttpClient httpClient;
		private ContentEntity contentEntity;
		private String content;

		public Crawler(String uid, int page, List<Header> headers, CloseableHttpClient httpClient) {
			this.uid = uid;
			this.page = page;
			this.headers = headers;
			this.httpClient = httpClient;
		}

		private String createUrlStr() {
			final String urlStrFormat = "https://weibo.com/ajax/favorites/all_fav?uid=%s&page=%d&with_total=true";
			String urlStr = String.format(urlStrFormat, uid, page);
			return urlStr;
		}

		public void start() throws ClientProtocolException, IOException {
			this.content = sendGet();
			System.out.println("-------------------------------------");
//			System.out.println(content);
			this.contentEntity = parseContent(content);
		}

		public ContentEntity getContentEntity() {
			return contentEntity;
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

	private static class ContentEntity {
		public DataEntity data;
	}

	private static class DataEntity {
		@SuppressWarnings("unused")
		public int total_number;
		public JSONArray status;
	}

	public static void start(String uid, String folderPath) throws IOException {
		final List<Header> headers = Headers.readHeader();
		final CloseableHttpClient httpClient = HttpClients.createDefault();

		int page = 1;
		JSONArray contents = new JSONArray();
		JSONArray status = new JSONArray();
		do {
			Crawler crawler = new Crawler(uid, page, headers, httpClient);
			crawler.start();
			page++;

			status = crawler.getContentEntity().data.status;
			contents.addAll(status);

			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			if (page >= 3) {
//				break;
//			}
		} while (status != null && !status.isEmpty());

		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		try {
			System.out.println(contents.size());
			Files.writeString(new File(folder, "favorites.log").toPath(),
					contents.toString(SerializerFeature.PrettyFormat));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			JSONObject picVideoJson = WeiboArrayToPicsVideos.weiboArrayToPicsVideos(contents, true);
			Files.writeString(new File(folder, "favorites_pics_videos.log").toPath(),
					picVideoJson.toString(SerializerFeature.PrettyFormat));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
