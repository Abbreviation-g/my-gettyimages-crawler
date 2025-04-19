package com.my.crawler.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class 解析微博网页输出到json文件并下载图片 {
	public static void main(String[] args) throws IOException {
		File outputFolder = new File("D:\\weibo\\袁姗姗");
		outputFolder = new File("D:\\weibo\\虞书欣");
		outputFolder = new File("D:\\weibo\\虞书欣工作室");
		outputFolder = new File("D:\\weibo\\董璇");
		outputFolder = new File("D:\\weibo\\李菲儿工作室");
		outputFolder = new File("D:\\weibo\\张曼源");
		outputFolder = new File("D:\\weibo\\徐娇");
//		outputFolder = new File("D:\\weibo\\孙耀琦");
//		outputFolder = new File("D:\\weibo\\赵樱子");
		outputFolder = new File("D:\\weibo\\张歆艺");
		outputFolder = new File("D:\\weibo\\张嘉倪");
		outputFolder = new File("D:\\weibo\\赵露思");
		outputFolder = new File("D:\\weibo\\李菲儿");
		outputFolder = new File("D:\\weibo\\李菲儿工作室");
		outputFolder = new File("D:\\weibo\\赵露思工作室");
		outputFolder = new File("D:\\weibo\\吴千语工作室");
		outputFolder = new File("D:\\weibo\\吴千语");
		outputFolder = new File("D:\\weibo\\郝娉婷");
		outputFolder = new File("D:\\weibo\\陆翊");
//		outputFolder = new File("D:\\weibo\\周依然");
		outputFolder = new File("D:\\weibo\\程潇");
		outputFolder = new File("D:\\weibo\\程潇工作室");
//		outputFolder = new File("D:\\weibo\\徐梓钧");
		outputFolder = new File("D:\\weibo\\袁雨萱");
		outputFolder = new File("D:\\weibo\\潘敏");
		outputFolder = new File("D:\\weibo\\洪司洋");
		outputFolder = new File("D:\\weibo\\yesyanbaby");
		outputFolder = new File("D:\\weibo\\阮巨");
		outputFolder = new File("D:\\weibo\\oh-大大kimi");
//		outputFolder = new File("D:\\weibo\\程潇安利星球");
		outputFolder = new File("D:\\weibo\\王秀竹");
		outputFolder = new File("D:\\weibo\\黄尧官方资讯博");
		outputFolder = new File("D:\\weibo\\李凯馨");
		outputFolder = new File("D:\\weibo\\刘美彤");
		outputFolder = new File("D:\\weibo2\\林允");
		outputFolder = new File("D:\\weibo2\\艾晓琪");
		outputFolder = new File("D:\\weibo2\\牟星");
		outputFolder = new File("D:\\weibo2\\赵蕴卓");
		outputFolder = new File("D:\\weibo2\\刘玮婷");
		outputFolder = new File("D:\\weibo2\\一个蟹蟹梨");
		outputFolder = new File("D:\\weibo2\\马泽涵");
		outputFolder = new File("D:\\weibo\\周放");
		outputFolder = new File("D:\\weibo\\娜扎的天鹅颈");
//		outputFolder = new File("D:\\weibo\\一个蟹蟹梨");
		outputFolder = new File("D:\\weibo\\张婧仪工作室");
//		outputFolder = new File("D:\\weibo\\张婧怡");
		outputFolder = new File("D:\\weibo\\张天爱");

		outputFolder = new File("D:\\weibo\\明星生图Martin");
		outputFolder = new File("D:\\weibo\\徐小舒");

//		outputFolder = new File("D:\\weibo\\Nebulae丨徐璐");
//		outputFolder = new File("D:\\weibo\\林逸欣");
//		outputFolder = new File("D:\\weibo\\林志玲");
//		outputFolder = new File("D:\\weibo\\林志玲工作室");
//		outputFolder = new File("D:\\weibo\\谭卓");
//		outputFolder = new File("D:\\weibo\\谭卓工作室");
//		outputFolder = new File("D:\\weibo\\赵今麦工作室");

		outputFolder = new File("D:\\weibo\\林允");
		outputFolder = new File("D:\\weibo\\徐璐");
		outputFolder = new File("D:\\weibo\\徐娇");
//		outputFolder = new File("D:\\weibo\\徐娇");
		outputFolder = new File("D:\\weibo\\唐艺昕");
		outputFolder = new File("D:\\weibo\\唐艺昕工作室");

		outputFolder = new File("D:\\weibo\\李凯馨");
//		outputFolder = new File("D:\\weibo\\蒋依依");
//		outputFolder = new File("D:\\weibo\\陈梦儿");
		outputFolder = new File("D:\\weibo\\吴宣仪工作室");
//		outputFolder = new File("D:\\weibo\\孙晓伦");

//		outputFolder = new File("D:\\weibo\\娜扎");
//		outputFolder = new File("D:\\weibo\\娜扎工作室");
//		outputFolder = new File("D:\\weibo\\赵今麦");
//		outputFolder = new File("D:\\weibo\\吴宣仪");
//		outputFolder = new File("D:\\weibo\\张歆艺");
//		outputFolder = new File("D:\\weibo\\王卓琪");
//		outputFolder = new File("D:\\weibo\\张彤");
		outputFolder = new File("D:\\weibo\\李依晓");
		outputFolder = new File("D:\\weibo\\代斯");
//		outputFolder = new File("D:\\weibo\\斯人轨迹丨代斯");	
//		outputFolder = new File("D:\\weibo\\蒋梦婕");
//		outputFolder = new File("D:\\weibo\\蒋梦婕工作室");
//		outputFolder = new File("D:\\weibo\\欧阳娜娜");
		outputFolder = new File("D:\\weibo\\程潇工作室");
		outputFolder = new File("D:\\weibo\\程潇");
		outputFolder = new File("D:\\weibo\\关晓彤");
		outputFolder = new File("D:\\weibo\\景甜");
		outputFolder = new File("D:\\weibo\\景甜工作室");
		outputFolder = new File("D:\\weibo\\关晓彤工作室");
		outputFolder = new File("D:\\weibo\\赵蕴卓");
		outputFolder = new File("D:\\weibo\\女明星生图");
		outputFolder = new File("D:\\weibo\\欧阳娜娜工作室");
		outputFolder = new File("D:\\weibo\\乔欣");
		outputFolder = new File("D:\\weibo\\森泽佳奈_real");
		outputFolder = new File("D:\\weibo\\柳岩");
		outputFolder = new File("D:\\weibo\\乔欣工作室");
		outputFolder = new File("D:\\weibo\\森泽佳奈OFFICIAL");
		outputFolder = new File("D:\\weibo\\李若嘉");
		outputFolder = new File("D:\\weibo\\娜然Naran");
		outputFolder = new File("D:\\weibo\\张蓝心");
		outputFolder = new File("D:\\weibo\\梁洁");
		outputFolder = new File("D:\\weibo\\王星辰");
		outputFolder = new File("D:\\weibo\\梁洁工作室");
		outputFolder = new File("D:\\weibo\\娜扎工作室");
		outputFolder = new File("D:\\weibo\\娜扎");
		outputFolder = new File("D:\\weibo\\橘玛丽_real");
		outputFolder = new File("D:\\weibo\\yesyanbaby");
		outputFolder = new File("D:\\weibo\\张馨予工作室");
		outputFolder = new File("D:\\weibo\\江疏影");
		outputFolder = new File("D:\\weibo\\江疏影工作室");
//		outputFolder = new File("D:\\weibo\\杨超越");
		outputFolder = new File("D:\\weibo\\白鹿");
		outputFolder = new File("D:\\weibo\\袁姗姗");
//		outputFolder = new File("D:\\weibo\\迪丽热巴工作室");
//		outputFolder = new File("D:\\weibo\\迪丽热巴");
		outputFolder = new File("D:\\weibo\\赵露思工作室");
//		outputFolder = new File("D:\\weibo\\赵露思");
		outputFolder = new File("D:\\weibo\\苏青");
		outputFolder = new File("D:\\weibo\\苏青工作室");
		outputFolder = new File("D:\\weibo\\孙怡");
		outputFolder = new File("D:\\weibo\\艾晓琪");
		outputFolder = new File("D:\\weibo\\杨幂");
		outputFolder = new File("D:\\weibo\\刘诗诗");
		outputFolder = new File("D:\\weibo\\杨幂工作室");
		outputFolder = new File("D:\\weibo\\咕噜小_");
		outputFolder = new File("D:\\weibo\\孙怡工作室");
		outputFolder = new File("D:\\weibo\\宋祖儿");
		outputFolder = new File("D:\\weibo\\宋祖儿工作室");
		outputFolder = new File("D:\\weibo\\石川澪_offical");
		outputFolder = new File("D:\\weibo\\凯瑟琳纽顿0208");
		outputFolder = new File("D:\\weibo\\聂小雨");
		outputFolder = new File("D:\\weibo\\宋妍霏");
		outputFolder = new File("D:\\weibo\\宋妍霏工作室");
		outputFolder = new File("D:\\weibo\\蒋依依工作室");
		outputFolder = new File("D:\\weibo\\艾尚真");
		outputFolder = new File("D:\\weibo\\蔡思贝");
		outputFolder = new File("D:\\weibo\\王紫璇");
		outputFolder = new File("D:\\weibo\\王鸥");
		outputFolder = new File("D:\\weibo\\徐冬冬");
		outputFolder = new File("D:\\weibo\\王子文工作室");
		outputFolder = new File("D:\\weibo\\王子文");
		outputFolder = new File("D:\\weibo\\孟子义");
		outputFolder = new File("D:\\weibo\\明星生图Martin");
		outputFolder = new File("D:\\weibo\\徐璐工作室");
		outputFolder = new File("D:\\weibo\\王紫璇工作室");
		outputFolder = new File("D:\\weibo\\Alessandra Ambrosio");
		outputFolder = new File("D:\\weibo\\宋芸樺Vivian");
		outputFolder = new File("D:\\weibo\\孟子义工作室");
		outputFolder = new File("D:\\weibo\\是你的程儿");
		outputFolder = new File("D:\\weibo\\潘敏");
		outputFolder = new File("D:\\weibo\\柴蔚");
		outputFolder = new File("D:\\weibo\\梦醒忒远");
		outputFolder = new File("D:\\weibo\\颜丹晨");
		outputFolder = new File("D:\\weibo\\李小冉");
//		outputFolder = new File("D:\\weibo\\黄梦莹");
//		outputFolder = new File("D:\\weibo\\今天也吃面包了吗");
//		outputFolder = new File("D:\\weibo\\钟楚曦");
		outputFolder = new File("D:\\weibo\\Gal_Gadot_News");
		outputFolder = new File("D:\\weibo\\钟楚曦工作室");
		outputFolder = new File("D:\\weibo\\柴蔚官方粉丝后援会");
		outputFolder = new File("D:\\weibo\\小蓝蓝plus");
		outputFolder = new File("D:\\weibo\\一栗莎子");
		outputFolder = new File("D:\\weibo\\1saye");
		outputFolder = new File("D:\\weibo\\张予曦");
		outputFolder = new File("D:\\weibo\\张馨予");
		outputFolder = new File("D:\\weibo\\刘亦菲");
		outputFolder = new File("D:\\weibo\\Sherry_Go");
		outputFolder = new File("D:\\weibo\\王卓淇");
		outputFolder = new File("D:\\weibo\\Rosie的瑜伽乐园");
		outputFolder = new File("D:\\weibo\\海洋饼干Sophie");
		outputFolder = new File("D:\\weibo\\许佳琪");
		outputFolder = new File("D:\\weibo\\艾晓琪");
//		outputFolder = new File("D:\\weibo\\白冰");
		outputFolder = new File("D:\\weibo\\森林北-");
		outputFolder = new File("D:\\weibo\\胡啊花瓜");
		outputFolder = new File("D:\\weibo\\张予曦工作室");
		outputFolder = new File("D:\\weibo\\镕馨Rongxiiin");
		outputFolder = new File("D:\\weibo\\晗卓-");

		outputFolder = new File("D:\\weibo\\项偞婧Cici工作室");
		outputFolder = new File("D:\\weibo\\依涵妹纸");
//		outputFolder = new File("D:\\weibo\\康可人");
		outputFolder = new File("G:\\林允");

		
//		downloadFromFolder(outputFolder);
		downloadFromFolder(new File("G:\\林允"), new File("G:\\林允-output"));
	}

	static class MonthUrl {
		String month;
		LinkedHashSet<String> arr = new LinkedHashSet<>();

		public void setMonth(String month) {
			this.month = month;
		}

		public String getMonth() {
			return month;
		}

		public void setArr(LinkedHashSet<String> arr) {
			this.arr = arr;
		}

		public LinkedHashSet<String> getArr() {
			return arr;
		}

		public static Map<String, MonthUrl> toMap(File jsonLogFile) throws IOException {
			JSONArray jsonArrayBak = getImgMap(jsonLogFile);
			List<MonthUrl> list = jsonArrayBak.toJavaList(MonthUrl.class);
//			Collections.reverse(list);
			Map<String, MonthUrl> map = new LinkedHashMap<>();
			for (MonthUrl monthUrl : list) {
				map.put(monthUrl.month, monthUrl);
			}
			return map;
		}

		public static Collection<MonthUrl> mergeMap(Map<String, MonthUrl> bakMap, Map<String, MonthUrl> newMap) {
			if (bakMap == null) {
				return newMap.values();
			}
			for (Entry<String, MonthUrl> entry : bakMap.entrySet()) {
				String month = entry.getKey();
				MonthUrl monthUrl = entry.getValue();
				if (newMap.containsKey(month)) {
					monthUrl.getArr().addAll(newMap.get(month).getArr());
					newMap.remove(month);
				}
			}
			bakMap.putAll(newMap);
			return bakMap.values();
		}
	}


	public static String[] convertDate(String date) { 
		String regex = "(\\d+)年(\\d+)月(\\d+日)?"; 
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(date); 
		if (matcher.matches()) { 
			String year = matcher.group(1);
			year = String.format("%04d", Integer.parseInt(year));
			String month = matcher.group(2);
			month = String.format("%02d", Integer.parseInt(month)); // 补齐月份前的零 
			return new String[] { year , year + "-" + month}; 
		} else { 
			return new String[] {date};
		}
	}
    
    private static File createOutputFolder(File outputFolder, String monthStr) {
    	String[] convertDate = convertDate(monthStr);
    	String year = convertDate[0];
    	File monthFolder = new File(outputFolder, year);
    	if (convertDate.length ==2) {
    		String month = convertDate[1];
    		monthFolder = new File(monthFolder, month);
    	}
    	if (!monthFolder.exists()) {
			monthFolder.mkdirs();
		}
		return monthFolder;  
    }
	
	private static void downloadFromFolder(File jsonLogFolder, File outputFolder) throws IOException {
		File jsonLogFile = new File(jsonLogFolder, "json.log");
		if (!jsonLogFile.exists()) {
			return;
		}
		Map<String, MonthUrl> newMap = MonthUrl.toMap(jsonLogFile);
		File jsonLogBakFile = new File(jsonLogFolder, "json.log.bak");
		if (jsonLogBakFile.exists()) {
			Map<String, MonthUrl> bakMap = MonthUrl.toMap(jsonLogBakFile);
			Collection<MonthUrl> mergeJsonLog = MonthUrl.mergeMap(bakMap, newMap);
			String mergeJsonLogString = JSON.toJSONString(mergeJsonLog);
			System.out.println(mergeJsonLogString);
			Files.writeString(jsonLogFile.toPath(), mergeJsonLogString);
		}

		File doneFile = new File(jsonLogFolder, "done.list");
		List<String> alreadyList;
		if (doneFile.exists()) {
			alreadyList = Files.readAllLines(doneFile.toPath());
		} else {
			alreadyList = new ArrayList<>();
		}
		List<String> alreadyFileNameList = alreadyList.stream().map((urlstr) -> getFileName(urlstr))
				.collect(Collectors.toList());
		int i = 0;
		for (MonthUrl monthUrl : newMap.values()) {
			String month = monthUrl.getMonth();
			Set<String> arr = monthUrl.getArr();
			System.out.println(month);
			// System.out.println(arr);

			System.out.println("总大小: " + arr.size());
			Iterator<String> iterator = arr.iterator();
			int currentIndex = 0;
			while (iterator.hasNext()) {
				File monthFolder = createOutputFolder(outputFolder, month);
				String imgUrlStr = (String) iterator.next();
				if (alreadyList.contains(imgUrlStr)) {
					System.out.println(
							String.format("%d 文件已备份(%d/%d) : %s", (++i), ++currentIndex, arr.size(), imgUrlStr));
					continue;
				}
				alreadyList.add(imgUrlStr);
				System.out.println(String.format("%d 正在下载(%d/%d) : %s", (++i), ++currentIndex, arr.size(), imgUrlStr));
				System.out.println("正在下载" + (i++) + "/" + arr.size() + ":" + imgUrlStr);
				try {
					downLoadFromUrl(imgUrlStr, monthFolder, alreadyFileNameList);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Files.write(doneFile.toPath(), alreadyList);
	}

	private static void downloadFromFolder(File outputFolder) throws IOException {
		downloadFromFolder(outputFolder, outputFolder);
	}

	private static String getFileName(String urlStr) {
		try {
			URL url = new URL(urlStr);
			IPath path = new Path(url.getPath());
			path = path.removeFirstSegments(1);
			String newImgFileName = String.join("-", path.segments());
			return newImgFileName;
		} catch (Exception e) {
			return "";
		}
	}

	public static void downLoadFromUrl(String urlStr, File saveDir, List<String> alreadyFileNameList)
			throws IOException {
		// https://thehentaiworld.com/wp-content/uploads/2020/04/Haruno-Sakura-Uchiha-Sarada-and-Uzumaki-Boruto-Criquet-Naruto-Hentai.jpeg
		URL url = new URL(urlStr);
		IPath path = new Path(url.getPath());
		path = path.removeFirstSegments(1);
		String newImgFileName = String.join("-", path.segments());
		if (alreadyFileNameList.contains(newImgFileName)) {
			System.out.println(alreadyFileNameList + "\t already exist. ");
			return;
		}

		File imgFile = new File(saveDir, newImgFileName);

		// 文件保存位置
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		if (imgFile.exists()) {
			System.out.println(imgFile + "\t already exist. ");
			return;
		}

//		downloadFormPicUrlByConnection(url, imgFile);

		final CloseableHttpClient httpClient = HttpClients.createDefault();
		downloadFromPicUrlByHttpGet(urlStr, httpClient, imgFile);
		System.out.println(imgFile + "\t done");
	}

	@SuppressWarnings("unused")
	private static void downloadFormPicUrlByConnection(URL url, File imgFile) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置超时间为3秒
		conn.setConnectTimeout(3 * 1000);
		// 防止屏蔽程序抓取而返回403错误
//		conn.setRequestProperty("User-Agent",
//				"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:106.0) Gecko/20100101 Firefox/106.0");
//		conn.setRequestProperty("Accept", "https://wx1.sinaimg.cn/large/005Mno6Aly1h7q1mzwd8gj32m83xcnpi.jpg");
//		conn.setRequestProperty("referer", "https://weibo.com/u/5295502496?tabtype=album&uid=5295502496&index=0");

		conn.setRequestProperty("Host", "wx1.sinaimg.cn");
		conn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/117.0");
		conn.setRequestProperty("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8");
		conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
		conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		conn.setRequestProperty("Referer", "https://weibo.com/");
		conn.setRequestProperty("Connection", "keep-alive");
		conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
		conn.setRequestProperty("Sec-Fetch-Dest", "document");
		conn.setRequestProperty("Sec-Fetch-Mode", "navigate");
		conn.setRequestProperty("Sec-Fetch-Site", "same-origin");
		conn.setRequestProperty("Sec-Fetch-User", "?1");
		conn.setRequestProperty("TE", "trailers");
		conn.setRequestProperty("If-Modified-Since", "Mon, 08 Jul 2013 18:06:40 GMT");
		conn.setRequestProperty("If-None-Match", "\"1-58df2d43132552140742a1e04d7c15ba\"");
		conn.setRequestProperty("Pragma", "no-cache");
		conn.setRequestProperty("Cache-Control", "no-cache");

		// 得到输入流
		InputStream inputStream = conn.getInputStream();
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
	}

	private static boolean downloadFromPicUrlByHttpGet(String urlStr, CloseableHttpClient httpClient, File imgFile) {
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

//				System.out.println(imgFile + "\t done");
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

	public static JSONArray getImgMap(File logFile) throws IOException {
		if (logFile.exists()) {
			byte[] allBytes = Files.readAllBytes(logFile.toPath());
			String content = new String(allBytes);
			if ((content.startsWith("\"") && content.endsWith("\"")) || content.startsWith("'") && content.endsWith("'")
					|| content.startsWith("`") && content.endsWith("`")) {
				content = content.substring(1, content.length() - 1);
			}
			JSONArray jsonArray = (JSONArray) JSON.parse(content);
			return jsonArray;
		}
		return null;
	}
}
