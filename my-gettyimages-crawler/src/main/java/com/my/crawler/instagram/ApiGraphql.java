package com.my.crawler.instagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class ApiGraphql {
	public static void main(String[] args) throws IOException {
		final CloseableHttpClient httpClient = HttpClients.createDefault();
		List<Header> headers = Headers.readHeader();
		Crawler crawler = new Crawler(headers, httpClient);
		crawler.start();
	}

	private static class Crawler {
		private String uid;
		private int page = 0;
		private List<Header> headers;
		private CloseableHttpClient httpClient;

		public Crawler(List<Header> headers, CloseableHttpClient httpClient) {
			this.headers = headers;
			this.httpClient = httpClient;
		}

		private String createUrlStr() {
			final String urlStrFormat = "https://www.instagram.com/api/graphql";
			String urlStr = String.format(urlStrFormat, uid, page);
			return urlStr;
		}

		public void start() throws ClientProtocolException, IOException {
			String content = sendGet();
			if (content != null && !content.isBlank()) {
			}
		}

		private void parseContent(String content) {
			System.out.println(content);
		}

		private String sendGet() throws ClientProtocolException, IOException {
			HttpHost proxy = new HttpHost("127.0.0.1", 10809);
			RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

			String urlStr = createUrlStr();
			HttpPost httpPost = new HttpPost(urlStr);
			httpPost.setConfig(config);
			
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(UrlEncodedFormEntityBuilder.getPairs());
			
			httpPost.setEntity(formEntity);
			httpPost.setHeaders(headers.toArray(new Header[headers.size()]));

			// 响应对象
			CloseableHttpResponse response = null;
			try {
				// 使用HttpClient发起请求
				response = httpClient.execute(httpPost);
				System.out.println("--------------------------------------------------------");
				System.out.println(urlStr);

				// 判断响应状态码是否为200
				if (response.getStatusLine().getStatusCode() == 200) {
					System.out.println(response.getStatusLine());

					// 获取返回数据
					HttpEntity httpEntity = response.getEntity();
					System.out.println(httpEntity);
//					InputStream inputStream = httpEntity.getContent();
//					try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
//						System.out.println(reader.readLine());
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//					StringEntity entity = new StringEntity(httpEntity.getContent(), ContentType.create(httpEntity.getContentType(), "UTF-8"));
					String content = EntityUtils.toString(httpEntity, "UTF-8");

					System.out.println(content);
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

	}
}
