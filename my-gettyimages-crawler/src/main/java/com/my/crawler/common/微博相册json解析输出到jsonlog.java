package com.my.crawler.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
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
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.my.crawler.common.解析微博网页输出到json文件并下载图片.MonthUrl;

public class 微博相册json解析输出到jsonlog {
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
		uid = "1780172395";
		folderPath = "D:\\weibo\\今天也吃面包了吗";
		uid = "3932503454";
		folderPath = "D:\\weibo\\潘敏";
		uid = "2670224681";
		folderPath = "D:\\weibo\\阿香的拳击男友";
		uid = "1301064830";
		folderPath = "D:\\weibo\\柴蔚";
		uid = "1941345837";
		folderPath = "D:\\weibo\\黄梦莹";
		uid = "7409360499";
		folderPath = "D:\\weibo\\小蓝蓝plus";
		uid = "1547371213";
		folderPath = "D:\\weibo\\一栗莎子";
		uid = "3259102532";
		folderPath = "D:\\weibo\\1saye";
		uid = "6447697223";
		folderPath = "D:\\weibo\\Sherry_Go";
		uid = "3261134763";
		folderPath = "D:\\weibo\\刘亦菲";
		uid = "3793748881";
		folderPath = "D:\\weibo\\海洋饼干Sophie";
		uid = "6063018876";
		folderPath = "D:\\weibo\\Rosie的瑜伽乐园";
		uid = "1749964961";
		folderPath = "D:\\weibo\\张馨予";
		uid = "1662262590";
		folderPath = "D:\\weibo\\张予曦";
		uid = "2079592581";
		folderPath = "D:\\weibo\\依涵妹纸";
		uid = "1722686885";
		folderPath = "D:\\weibo\\王卓淇";
		uid = "2383785520";
		folderPath = "D:\\weibo\\森林北-";
		uid = "7072842867";
		folderPath = "D:\\weibo\\项偞婧Cici工作室";
		uid = "7520131264";
		folderPath = "D:\\weibo\\胡啊花瓜";
		uid = "5991895370";
		folderPath = "D:\\weibo\\镕馨Rongxiiin";
		uid = "2185613090";
		folderPath = "D:\\weibo\\晗卓-";
		uid = "1873771623";
		folderPath = "D:\\weibo\\康可人";
		
		start(uid, folderPath);
	}

	private static Map<String, MonthUrl> monthUrls = new LinkedHashMap<>();

	private static String timeline_month;
	private static String timeline_year;

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

		private void addToMonthUrls() throws ClientProtocolException, IOException {
			if (contentEntity == null || contentEntity.data == null) {
				return;
			}
			if (contentEntity.data.list == null || contentEntity.data.list.isEmpty()) {
				return;
			}
			for (PicEntity picEntity : contentEntity.data.list) {
				addToMonthUrls(picEntity);
			}
		}

		private String getMonthName(PicEntity picEntity) {
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
			return monthName;
		}

		private void addToMonthUrls(PicEntity picEntity) throws ClientProtocolException, IOException {
			String monthName = getMonthName(picEntity);
			MonthUrl monthUrl = monthUrls.get(monthName);
			if (monthUrl == null) {
				monthUrl = new MonthUrl();
				monthUrl.month = monthName;
				monthUrls.put(monthName, monthUrl);
			}
			// https://wx1.sinaimg.cn/large/d6c55577ly1hey365yn4pj22c0340b2c.jpg
			String suffix = "jpg";
			if ("gif".equals(picEntity.type)) {
				suffix = "gif";
			}
			monthUrl.arr.add(String.format("https://wx1.sinaimg.cn/large/%s.%s", picEntity.pid, suffix));
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

					System.out.println(sinceid);
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

	static {
		Calendar instenac = Calendar.getInstance();
		int year = instenac.get(Calendar.YEAR);
		int month = instenac.get(Calendar.MONTH) + 1;
		timeline_year = Integer.toString(year);
		timeline_month = Integer.toString(month);
	}

	public static void start(String uid, String folderPath) throws IOException {
		final List<Header> headers = readHeader();
		final CloseableHttpClient httpClient = HttpClients.createDefault();

		String sinceid = "0";
		while (sinceid != null) {
			Crawler crawler = new Crawler(uid, sinceid, headers, httpClient);
			crawler.start();
			crawler.addToMonthUrls();

			sinceid = crawler.getSinceId();
			if ("0".equals(sinceid)) {
				break;
			}
		}

		MonthUrl[] monthUrlArr = monthUrls.values().toArray(new MonthUrl[monthUrls.size()]);
		String monthUrlsJsonStr = JSON.toJSONString(monthUrlArr, SerializerFeature.PrettyFormat);
		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		Files.writeString(new File(folder, "json.log").toPath(), monthUrlsJsonStr);
	}

	static List<Header> readHeader() throws IOException {
		List<Header> headers = new ArrayList<>();
		InputStream stream = 微博相册json解析输出到jsonlog.class.getResourceAsStream("weibo_json_url_headers.txt");
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
