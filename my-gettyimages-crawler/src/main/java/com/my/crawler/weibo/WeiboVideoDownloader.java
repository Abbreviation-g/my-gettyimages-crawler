//package com.my.crawler.weibo;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//
//public class WeiboVideoDownloader {
//
//	public static String getImageName(String urlStr) {
//		if (urlStr.contains("livephoto=")) {
//			int index = urlStr.lastIndexOf("%2f");
//			if (index == -1) {
//				index = urlStr.lastIndexOf("%2F");
//			}
//			return urlStr.substring(index + "%2f".length());
//		}
//
//		int index = urlStr.lastIndexOf("/");
//
//		int endIndex = urlStr.indexOf("?");
//		if (endIndex == -1) {
//			endIndex = urlStr.length();
//		}
//		String fileName = urlStr.substring(index + 1, endIndex);
//		return fileName;
//	}
//
//	private static boolean downloadFromVideoUrlByHttpGet(String urlStr, CloseableHttpClient httpClient, File imgFile) {
//		HttpGet httpGet = new HttpGet(urlStr);
//		httpGet.setHeader("Host", "f.video.weibocdn.com");
//		httpGet.setHeader("User-Agent",
//				"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/117.0");
//		httpGet.setHeader("Accept", "video/webm,video/ogg,video/*;q=0.9,application/ogg;q=0.7,audio/*;q=0.6,*/*;q=0.5");
//		httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
//		httpGet.setHeader("Range", "bytes=80630-");
//		httpGet.setHeader("Connection", "keep-alive");
//		httpGet.setHeader("Referer", "https://weibo.com/");
//		httpGet.setHeader("Sec-Fetch-Dest", "video");
//		httpGet.setHeader("Sec-Fetch-Mode", "no-cors");
//		httpGet.setHeader("Sec-Fetch-Site", "cross-site");
//		httpGet.setHeader("Accept-Encoding", "identity");
//		
////		Host: f.video.weibocdn.com
////		User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:121.0) Gecko/20100101 Firefox/121.0
////		Accept: video/webm,video/ogg,video/*;q=0.9,application/ogg;q=0.7,audio/*;q=0.6,*/*;q=0.5
////		Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
////		Range: bytes=80630-
////		Connection: keep-alive
////		Referer: https://weibo.com/
////		Sec-Fetch-Dest: video
////		Sec-Fetch-Mode: no-cors
////		Sec-Fetch-Site: cross-site
////		Accept-Encoding: identity
//
//		// 响应对象
//		CloseableHttpResponse response = null;
//		try {
//			// 使用HttpClient发起请求
//			response = httpClient.execute(httpGet);
//			// 判断响应状态码是否为200
//			int statusCode = response.getStatusLine().getStatusCode();
//			if (statusCode == 200 || statusCode == 206) {
//				// 获取返回数据
//				HttpEntity httpEntity = response.getEntity();
////				System.out.println(httpEntity.isChunked());
////				System.out.println(httpEntity.getContentLength());
////				System.out.println(httpEntity.getContentType());
//
//				// 得到输入流
//				InputStream inputStream = httpEntity.getContent();
//				// 获取自己数组
//				byte[] getData = readInputStream(inputStream);
//
//				FileOutputStream fos = new FileOutputStream(imgFile, false);
//				fos.write(getData);
//				if (fos != null) {
//					fos.close();
//				}
//				if (inputStream != null) {
//					inputStream.close();
//				}
//
////				System.out.println(imgFile + "\t done");
//			} else {
//				System.out.println(response.getStatusLine());
//			}
//		} catch (IOException ex) {
//			ex.printStackTrace();
//			return false;
//		} finally {
//			// 释放连接
//			if (response != null) {
//				try {
//					response.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return true;
//	}
//
//	public static byte[] readInputStream(InputStream inputStream) throws IOException {
//		byte[] buffer = new byte[1024];
//		int len = 0;
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		while ((len = inputStream.read(buffer)) != -1) {
//			bos.write(buffer, 0, len);
//		}
//		bos.close();
//		return bos.toByteArray();
//	}
//
//	public static void main(String[] args) throws MalformedURLException, IOException {
//		String urlStr = "https://wx4.sinaimg.cn/large/c277b4f6ly1hknblkuicpj244e60v4qu.jpg";
//		urlStr = "https://f.video.weibocdn.com/o0/zwehasOXlx07SmKKkcbS01041201pY7J0E010.mp4?label=mp4_1080p&template=1080x1080.null&trans_finger=29b4e2632eecf57041482ba4ad6c4dce&media_id=4717266152128619&tp=8x8A3El:YTkl0eM8&us=0&ori=1&bf=3&ot=h&lp=000026VK9x&ps=mZ6WB&uid=3VQTFt&ab=,3601-g31,3601-g34,1192-g0,1046-g2,1258-g0,6447-g4,3601-g15&Expires=1703399854&ssig=qhu8wR3Q3T&KID=unistore,video";
//		urlStr = "https://f.video.weibocdn.com/lClj09Fllx089rk9dgSI01041200qte00E010.mp4?label=mp4_hd&template=1440x2560.25.0&media_id=4957774472216624&tp=8x8A3El:YTkl0eM8&us=0&ori=1&bf=4&ot=v&lp=0000ntyUc&ps=mZ6WB&uid=3VQTFt&ab=11243-g2,8012-g2,3601-g32,8143-g0,8013-g0,12192-g0,3601-g39,3601-g36,3601-g19,3601-g36,3601-g27&Expires=1702366343&ssig=BSB73IN70n&KID=unistore,video";
//		urlStr = "https://f.video.weibocdn.com/q6JY19Inlx07GVchzUnC010412004o8f0E010.mp4?label=mp4_hd&template=720x1280.24.0&trans_finger=e8a052b5584408bcb51fcafb9761cd6d&media_id=4556055267704874&tp=BFmU6wukWiEV5OZ:BFmU6wukWiEV5OZ&us=0&ori=1&bf=4&ot=v&lp=00002GBFPv&ps=mZ6WB&uid=3VQTFt&ab=&Expires=1703493902&ssig=%2B6GmRtZFxU&KID=unistore,video";
//		urlStr = "http://f.video.weibocdn.com/q6JY19Inlx07GVchzUnC010412004o8f0E010.mp4?label=mp4_hd&template=720x1280.24.0&trans_finger=e8a052b5584408bcb51fcafb9761cd6d&ori=0&ps=1CwnkDw1GXwCQx&Expires=1703483535&ssig=Vlr9tPE%2Bxq&KID=unistore,video";
//		urlStr = "https://f.video.weibocdn.com/q6JY19Inlx07GVchzUnC010412004o8f0E010.mp4?label=mp4_hd&template=720x1280.24.0&trans_finger=e8a052b5584408bcb51fcafb9761cd6d&media_id=4556055267704874&tp=BFmU6wukWiEV5OZ:BFmU6wukWiEV5OZ&us=0&ori=1&bf=4&ot=v&lp=0000ntyUc&ps=mZ6WB&uid=3VQTFt&ab=&Expires=1703483535&ssig=Vlr9tPE%2Bxq&KID=unistore,video";
//		urlStr = "http://f.video.weibocdn.com/q6JY19Inlx07GVchzUnC010412004o8f0E010.mp4?"
//				+ "label=mp4_hd"
//				+ "&template=720x1280.24.0"
//				+ "&trans_finger=e8a052b5584408bcb51fcafb9761cd6d"
//				+"&media_id=4556055267704874"
//				+"&tp=BFmU6wukWiEV5OZ:BFmU6wukWiEV5OZ"
//				+ "&ori=0"
//				+ "&ps=1CwnkDw1GXwCQx"
//				+ "&Expires=1703483535"
//				+ "&ssig=Vlr9tPE%2Bxq"
//				+ "&KID=unistore,video";
//		
//		urlStr = "https://f.video.weibocdn.com/q6JY19Inlx07GVchzUnC010412004o8f0E010.mp4?label=mp4_hd&template=720x1280.24.0&trans_finger=e8a052b5584408bcb51fcafb9761cd6d&media_id=4556055267704874&tp=BFmU6wukWiEV5OZ:BFmU6wukWiEV5OZ&us=0&ori=1&bf=4&ot=v&lp=00002GBFPv&ps=mZ6WB&uid=3VQTFt&ab=&Expires=1703495327&ssig=atgaedUgMf&KID=unistore,video";
////		urlStr = "https://f.video.weibocdn.com/q6JY19Inlx07GVchzUnC010412004o8f0E010.mp4?label=mp4_hd&template=720x1280.24.0&trans_finger=e8a052b5584408bcb51fcafb9761cd6d&media_id=4556055267704874&tp=BFmU6wukWiEV5OZ:BFmU6wukWiEV5OZ&us=0&ori=1&bf=4&ot=v&lp=00002GBFPv&ps=mZ6WB&uid=3VQTFt&ab=&Expires=1703495327&ssig=atgaedUgMf&KID=unistore,video";
//		
//		
//		String imgName = getImageName(urlStr);
//		System.out.println(imgName);
//
//		final CloseableHttpClient httpClient = HttpClients.createDefault();
//		downloadFromVideoUrlByHttpGet(urlStr, httpClient, new File("D:\\temp", imgName));
//		httpClient.close();
//	}
//}
