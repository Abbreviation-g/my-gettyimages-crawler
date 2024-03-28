package com.my.crawler.weibo;

import static com.my.crawler.weibo.根据weibolog解析pic和video.*;

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

public class 根据UID解析微博并保存为本地log {
	public static void main(String[] args) throws IOException {
		String uid = "1943405723";
		String folderPath = "D:\\weibo\\钟楚曦";

		uid = "3262625014";
		folderPath = "D:\\weibo2\\唐艺昕";
//		uid = "5617960493";
//		folderPath = "D:\\weibo2\\徐璐工作室";
//		uid = "1197755162";
//		folderPath = "D:\\weibo2\\韩雪";
//		uid = "2174204211";
//		folderPath = "D:\\weibo2\\唐嫣工作室";
		uid = "3603256695";
		folderPath = "F:\\weibo_log\\梦醒忒远";

		createWeiLogFile(uid, folderPath);
		splitWeibosToDateIdFolder(new File(folderPath));
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

	public static JSONArray createWeiLogFile(String uid, String folderPath) throws IOException {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		final List<Header> headers = Headers.readHeader();
		final CloseableHttpClient httpClient = HttpClients.createDefault();

		String sinceid = "0";
		int page = 0;
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
			array.addAll(contentEntity.data.list);

			if (sinceid == null || sinceid.isEmpty() || "0".equals(sinceid)) {
				break;
			}

			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		httpClient.close();

		if (!array.isEmpty()) {
			File folder = new File(folderPath);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			File weiboLogFile = new File(folder, WEIBO_LOG_FILENAME);
			Files.writeString(weiboLogFile.toPath(), array.toString(SerializerFeature.PrettyFormat));
		} else {
			System.err.println("解析失败: \t" + uid);
		}

		return array;
	}
}
