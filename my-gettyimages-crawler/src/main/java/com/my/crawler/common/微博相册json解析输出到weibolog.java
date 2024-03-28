package com.my.crawler.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class 微博相册json解析输出到weibolog {
	public static void main(String[] args) throws IOException {
		String uid = "1943405723";
		String folderPath = "D:\\weibo\\钟楚曦";

		uid = "3262625014";
		folderPath = "D:\\weibo2\\唐艺昕";

		start(uid, folderPath);
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
			this.contentEntity = parseContent(content);
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
				System.out.println("-------");
				System.out.println(response.getStatusLine());

				// 判断响应状态码是否为200
				if (response.getStatusLine().getStatusCode() == 200) {
					// 获取返回数据
					HttpEntity httpEntity = response.getEntity();
					String content = EntityUtils.toString(httpEntity, "UTF-8");

					System.out.println(content);
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

	public static void start(String uid, String folderPath) throws IOException {
		final List<Header> headers = readHeader();
		final CloseableHttpClient httpClient = HttpClients.createDefault();

		String sinceid = "0";
		int page = 0;
		JSONArray array = new JSONArray();
		while (sinceid != null) {
			Crawler crawler = new Crawler(uid, page, headers, httpClient);
			crawler.start();
			page++;

			sinceid = crawler.getSinceId();
			array.addAll(crawler.getContentEntity().data.list);
			if (sinceid.isEmpty() || "0".equals(sinceid)) {
				break;
			}

			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
//		Files.write(new File(folder, "weibo.log").toPath(), contents);

		try (PrintWriter writer = new PrintWriter(new FileWriter(new File(folder, "weibo.log")))) {
			writer.println(array.toString(SerializerFeature.PrettyFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static List<Header> readHeader() throws IOException {
		List<Header> headers = new ArrayList<>();
		InputStream stream = 微博相册json解析输出到weibolog.class.getResourceAsStream("weibo_json_url_headers.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line = reader.readLine();

		String name = null;
		String value = null;
		while ((line = reader.readLine()) != null) {

			int index = line.indexOf(":");
			name = line.substring(0, index);
			value = line.substring(index + 2);

			Header header = new BasicHeader(name, value);
			headers.add(header);
//			System.out.println(line);
		}
		reader.close();
		return headers;
	}

}
