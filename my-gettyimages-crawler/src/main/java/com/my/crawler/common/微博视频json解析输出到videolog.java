package com.my.crawler.common;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
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

public class 微博视频json解析输出到videolog {
	private static List<String> videoList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		String uid = "1943405723";
		String folderPath = "D:\\weibo\\钟楚曦";

		uid = "1913244047";
		folderPath = "D:\\weibo\\钟楚曦工作室";
		uid = "1632538541";
		folderPath = "D:\\weibo\\王智";
		uid = "5704068886";
		folderPath = "D:\\weibo\\张予曦工作室";
		uid = "1656214784";
		folderPath = "D:\\weibo\\甘婷婷";
		uid = "3828809034";
		folderPath = "D:\\weibo\\王楚然";
		uid = "1590144567";
		folderPath = "D:\\weibo\\潘霜霜";
		uid = "1258824907";
		folderPath = "D:\\weibo\\高露";
		uid = "3050737061";
		folderPath = "D:\\weibo\\许佳琪";
		uid = "5413842332";
		folderPath = "D:\\weibo\\柴蔚官方粉丝后援会";
		uid = "1689055184";
		folderPath = "D:\\weibo\\刘萌萌";
		uid = "1756505825";
		folderPath = "D:\\weibo\\李小冉";
		uid = "1247063043";
		folderPath = "D:\\weibo\\颜丹晨";
		uid = "1705338574";
		folderPath = "D:\\weibo\\周秀娜";
		uid = "7607376925";
		folderPath = "D:\\weibo\\是你的程儿";
//		uid = "1780172395";
//		folderPath = "D:\\weibo\\今天也吃面包了吗";
		uid = "7409360499";
		folderPath = "D:\\weibo\\小蓝蓝plus";
		uid = "1547371213";
		folderPath = "D:\\weibo\\一栗莎子";
		uid = "3259102532";
		folderPath = "D:\\weibo\\1saye";
		uid = "1662262590";
		folderPath = "D:\\weibo\\张予曦";


		start(uid, folderPath);
	}

	private static class Crawler {
		private String uid;
		private String cursor;
		private String nextCursor;
		private List<Header> headers;
		private CloseableHttpClient httpClient;

		public Crawler(String uid, String sinceid, List<Header> headers, CloseableHttpClient httpClient) {
			this.uid = uid;
			if (sinceid == null) {
				this.cursor = "0";
			} else {
				this.cursor = sinceid;
			}
			this.headers = headers;
			this.httpClient = httpClient;
		}

		private String createUrlStr() {
			final String urlStrFormat = "https://weibo.com/ajax/profile/getWaterFallContent?uid=%s&cursor=%s";
			cursor = cursor.replace("|", "%7C");
			String urlStr = String.format(urlStrFormat, uid, cursor);
			return urlStr;
		}

		private String getNextCursor() {
			return this.nextCursor;
		}

		public void start() throws ClientProtocolException, IOException {
			String content = sendGet();
			parseContent(content);

		}

		private void parseContent(String content) {
			JSONObject jsonObject = JSON.parseObject(content);
			JSONObject dataObject = jsonObject.getJSONObject("data");
			String nextCursor = dataObject.getString("next_cursor");
			this.nextCursor = nextCursor;

			JSONArray listArray = dataObject.getJSONArray("list");
			if (listArray.isEmpty()) {
				return;
			}
			for (int i = 0; i < listArray.size(); i++) {
				JSONObject listObject = listArray.getJSONObject(i);
				JSONObject page_info = listObject.getJSONObject("page_info");
				if (page_info == null) {
					continue;
				}
				JSONObject media_info = page_info.getJSONObject("media_info");
				if (media_info == null) {
					continue;
				}
				JSONArray playbackList = media_info.getJSONArray("playback_list");
				if (playbackList == null || playbackList.isEmpty()) {
					continue;
				}
				JSONObject play_info = playbackList.getJSONObject(0).getJSONObject("play_info");
				String videoUrl = play_info.getString("url");
				videoList.add(videoUrl);
				System.out.println(videoUrl);
			}
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
	}

	public static void start(String uid, String folderPath) throws IOException {
		final List<Header> headers = readHeader();
		final CloseableHttpClient httpClient = HttpClients.createDefault();

		String cursor = "0";
		while (cursor != null) {
			Crawler crawler = new Crawler(uid, cursor, headers, httpClient);
			crawler.start();

			cursor = crawler.getNextCursor();
			if ("-1".equals(cursor)) {
				break;
			}
		}

		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		Files.write(new File(folder, "video.log").toPath(), videoList);

		downloadFromVideoLog(folder, videoList, httpClient);
	}

	private static void downloadFromVideoLog(File folder, List<String> videoList, CloseableHttpClient httpClient) {
		File videoFolder = new File(folder, "video");
		if (!videoFolder.exists()) {
			videoFolder.mkdirs();
		}
		for (String videoUrl : videoList) {
			String videoFileName = videoUrl.substring(videoUrl.lastIndexOf("/") + 1, videoUrl.indexOf("?"));
			System.out.println("开始下载: " + videoFileName);
			downloadFromVideoUrlByHttpGet(videoUrl, httpClient, new File(videoFolder, videoFileName));
		}
	}

	private static boolean downloadFromVideoUrlByHttpGet(String urlStr, CloseableHttpClient httpClient, File imgFile) {
		HttpGet httpGet = new HttpGet(urlStr);
		httpGet.setHeader("Host", "f.video.weibocdn.com");
		httpGet.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/117.0");
		httpGet.setHeader("Accept", "video/webm,video/ogg,video/*;q=0.9,application/ogg;q=0.7,audio/*;q=0.6,*/*;q=0.5");
		httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
		httpGet.setHeader("Range", "bytes=0-");
		httpGet.setHeader("Connection", "keep-alive");
		httpGet.setHeader("Referer", "https://weibo.com/");
		httpGet.setHeader("Sec-Fetch-Dest", "video");
		httpGet.setHeader("Sec-Fetch-Mode", "no-cors");
		httpGet.setHeader("Sec-Fetch-Site", "cross-site");
		httpGet.setHeader("Accept-Encoding", "identity");

		// 响应对象
		CloseableHttpResponse response = null;
		try {
			// 使用HttpClient发起请求
			response = httpClient.execute(httpGet);
			// 判断响应状态码是否为200
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200 || statusCode == 206) {
				// 获取返回数据
				HttpEntity httpEntity = response.getEntity();
//				System.out.println(httpEntity.isChunked());
//				System.out.println(httpEntity.getContentLength());
//				System.out.println(httpEntity.getContentType());

				// 得到输入流
				InputStream inputStream = httpEntity.getContent();
				// 获取自己数组
				byte[] getData = readInputStream(inputStream);

				FileOutputStream fos = new FileOutputStream(imgFile, false);
				fos.write(getData);
				if (fos != null) {
					fos.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}

//				System.out.println(imgFile + "\t done");
			} else {
				System.out.println(response.getStatusLine());
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

	static List<Header> readHeader() throws IOException {
		List<Header> headers = new ArrayList<>();
		InputStream stream = 微博视频json解析输出到videolog.class.getResourceAsStream("weibo_json_url_headers.txt");
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
