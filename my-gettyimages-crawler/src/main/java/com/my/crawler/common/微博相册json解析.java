package com.my.crawler.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.alibaba.fastjson.JSONObject;

public class 微博相册json解析 {
	private static String timeline_month;
	private static String timeline_year;

	/**
	 * url工具类
	 */
	public static class UrlEntity {
		/**
		 * 基础url
		 */
		public String baseUrl;
		/**
		 * url参数
		 */
		public Map<String, String> params;
	}

	/**
	 * 解析url
	 * 
	 * @param url
	 * @return
	 */
	public static UrlEntity parse(String url) {
		UrlEntity entity = new UrlEntity();
		if (url == null) {
			return entity;
		}
		url = url.trim();
		if (url.equals("")) {
			return entity;
		}
		String[] urlParts = url.split("\\?");
		entity.baseUrl = urlParts[0];
		// 没有参数
		if (urlParts.length == 1) {
			return entity;
		}
		// 有参数
		String[] params = urlParts[1].split("&");
		entity.params = new HashMap<>();
		for (String param : params) {
			String[] keyValue = param.split("=");
			if (keyValue.length > 1) {
				entity.params.put(keyValue[0], keyValue[1]);
			}
		}

		return entity;
	}

	/**
	 * 获取url指定参数值
	 * 
	 * @param url
	 * @param key 参数名
	 * @return
	 */
	public static String getParamsByKey(String url, String key) {
		UrlEntity entity = parse(url);
		return entity.params.get(key);
	}

	private static class Crawler {
		private String uid;
		private String sinceid;
		private List<Header> headers;
		private CloseableHttpClient httpClient;

		private ContentEntity contentEntity;

		public Crawler(String uid, String sinceid, List<Header> headers, CloseableHttpClient httpClient) {
			this.uid = uid;
			if (sinceid == null) {
				this.sinceid = "0";
			} else {
				this.sinceid = sinceid;
			}
			this.headers = headers;
			this.httpClient = httpClient;
		}

		private String createUrlStr() {
			final String urlStrFormat = "https://weibo.com/ajax/profile/getImageWall?uid=%s&sinceid=%s";
			sinceid = sinceid.replace("|", "%7C");
			String urlStr = String.format(urlStrFormat, uid, sinceid);
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

		private void download(String folderPath) throws ClientProtocolException, IOException {
			if (contentEntity == null || contentEntity.data == null) {
				return;
			}
			if (contentEntity.data.list == null || contentEntity.data.list.isEmpty()) {
				return;
			}
			for (PicEntity picEntity : contentEntity.data.list) {
				download(picEntity, folderPath);
			}
		}

		private void download(PicEntity picEntity, String folderPath) throws ClientProtocolException, IOException {
			File doneFile = new File(folderPath, "done.list");
			List<String> alreadyList;
			if (doneFile.exists()) {
				alreadyList = Files.readAllLines(doneFile.toPath());
			} else {
				alreadyList = new ArrayList<>();
			}

			String currentYear = picEntity.timeline_year;
			if (currentYear == null || currentYear.isEmpty()) {
				currentYear = timeline_year;
			} else {
				timeline_year = picEntity.timeline_year;
			}
			String currentMonth = picEntity.timeline_month;
			if (currentMonth == null || currentMonth.isEmpty()) {
				currentMonth = timeline_month;
			} else {
				timeline_month = picEntity.timeline_month;
			}

			String monthName = String.format("%s年%s月", currentYear, currentMonth);

			File folder = new File(folderPath, monthName);
			if (!folder.exists()) {
				folder.mkdirs();
			}
//			System.out.println("文件夹名: " + folderName);

			// https://wx3.sinaimg.cn/large/d6c55577ly1hey365yn4pj22c0340b2c.jpg
			int[] wxIndexs = { 1, 2, 3, 4 };
			String suffix = "jpg";
			if ("gif".equals(picEntity.type)) {
				suffix = "gif";
			}

			String filename = String.format("%s.%s", picEntity.pid, suffix);
			File imgFile = new File(folder, filename);
			if (imgFile.exists()) {
				System.out.println(imgFile + "\t already exist. ");
				return;
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(doneFile, true));
			String largePicUrlFormat = "https://wx%d.sinaimg.cn/large/%s.%s";
			for (int index : wxIndexs) {
				String picUrl = String.format(largePicUrlFormat, index, picEntity.pid, suffix);
				if (alreadyList.contains(picUrl)) {
					System.out.println(picUrl + "\t already exist. ");
					break;
				}

//				System.out.println(picUrl);
				boolean result = downloadFromPicUrl(picUrl, imgFile);
				if (result) {
					writer.append(picUrl);
					writer.append("\n");
					writer.flush();
					break;
				}
			}

			writer.close();
		}

		private boolean downloadFromPicUrl2(String urlStr) {
			try {
				URL url = new URL(urlStr);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// 设置超时间为3秒
				conn.setConnectTimeout(3 * 1000);
				// 防止屏蔽程序抓取而返回403错误
				conn.setRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:106.0) Gecko/20100101 Firefox/106.0");
				conn.setRequestProperty("Accept", "https://wx1.sinaimg.cn/large/005Mno6Aly1h7q1mzwd8gj32m83xcnpi.jpg");
				conn.setRequestProperty("referer",
						"https://weibo.com/u/5295502496?tabtype=album&uid=5295502496&index=0");
			} catch (IOException ex) {
				ex.printStackTrace();
				return false;
			}
			return true;

		}

		private boolean downloadFromPicUrl(String urlStr, File imgFile) {
			HttpGet httpGet = new HttpGet(urlStr);
			httpGet.setHeader("Host", "wx1.sinaimg.cn");
			httpGet.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/117.0");
			httpGet.setHeader("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8");
			httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
			httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
			httpGet.setHeader("Referer", "https://weibo.com/");
			httpGet.setHeader("Connection", "keep-alive");
			httpGet.setHeader("Upgrade-Insecure-Requests", "1");
			httpGet.setHeader("Sec-Fetch-Dest", "document");
			httpGet.setHeader("Sec-Fetch-Mode", "navigate");
			httpGet.setHeader("Sec-Fetch-Site", "same-origin");
			httpGet.setHeader("Sec-Fetch-User", "?1");
			httpGet.setHeader("TE", "trailers");
			httpGet.setHeader("If-Modified-Since", "Mon, 08 Jul 2013 18:06:40 GMT");
			httpGet.setHeader("If-None-Match", "\"1-58df2d43132552140742a1e04d7c15ba\"");
			httpGet.setHeader("Pragma", "no-cache");
			httpGet.setHeader("Cache-Control", "no-cache");

			// 响应对象
			CloseableHttpResponse response = null;
			try {
				// 使用HttpClient发起请求
				response = httpClient.execute(httpGet);
				// 判断响应状态码是否为200
				if (response.getStatusLine().getStatusCode() == 200) {
					// 获取返回数据
					HttpEntity httpEntity = response.getEntity();

					// 得到输入流
					InputStream inputStream = httpEntity.getContent();
					// 获取自己数组
					byte[] getData = readInputStream(inputStream);

					FileOutputStream fos = new FileOutputStream(imgFile);
					fos.write(getData);
					if (fos != null) {
						fos.close();
					}
					if (inputStream != null) {
						inputStream.close();
					}

					System.out.println(imgFile + "\t done");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
				return false;
			} finally {
				// 释放连接
				if (response != null) {
					try {
						response.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return true;
		}

		/**
		 * 从输入流中获取字节数组
		 * 
		 * @param inputStream
		 * @return
		 * @throws IOException
		 */
		public static byte[] readInputStream(InputStream inputStream) throws IOException {
			byte[] buffer = new byte[1024];
			int len = 0;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while ((len = inputStream.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.close();
			return bos.toByteArray();
		}

		private String sendGet() throws ClientProtocolException, IOException {
			HttpGet httpGet = new HttpGet(createUrlStr());
			httpGet.setHeaders(headers.toArray(new Header[headers.size()]));

			// 响应对象
			CloseableHttpResponse response = null;
			try {
				// 使用HttpClient发起请求
				response = httpClient.execute(httpGet);

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

		private ContentEntity parseContent(String content) {
			JSONObject dataEntityJson = JSON.parseObject(content);
			ContentEntity contentEntity = dataEntityJson.toJavaObject(ContentEntity.class);
			return contentEntity;
		}
	}

	private static class ContentEntity {
		public DataEntity data;
	}

	private static class DataEntity {
		public String since_id;
		public List<PicEntity> list;
	}

	private static class PicEntity {
		public String pid;
		public String timeline_month;
		public String timeline_year;
		public String type;
	}

	private static String getUid(String urlStr) {
		return getParamsByKey(urlStr, "uid");
	}

	static {
		Calendar instenac = Calendar.getInstance();
		int year = instenac.get(Calendar.YEAR);
		int month = instenac.get(Calendar.MONTH) + 1;
		timeline_year = Integer.toString(year);
		timeline_month = Integer.toString(month);
	}

	public static void start(String folderPath) throws IOException {
		String urlStart = readUrl();
		final List<Header> headers = readHeader();
		final String uid = getUid(urlStart);
		final CloseableHttpClient httpClient = HttpClients.createDefault();

		String sinceid = "0";
		while (sinceid != null) {
			Crawler crawler = new Crawler(uid, sinceid, headers, httpClient);
			crawler.start();
			crawler.download(folderPath);

			sinceid = crawler.getSinceId();
		}
	}

	public static void main(String[] args) throws IOException {
		String folderPath = "D:\\weibo\\宋芸樺Vivian";
		start(folderPath);
	}

	static List<Header> readHeader() throws IOException {
		List<Header> headers = new ArrayList<>();
		InputStream stream = 微博相册json解析.class.getResourceAsStream("weibo_json_url_headers.txt");
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

	static String readUrl() throws IOException {
		InputStream stream = 微博相册json解析.class.getResourceAsStream("weibo_json_url.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line = reader.readLine();
		reader.close();
		return line;
	}
}
