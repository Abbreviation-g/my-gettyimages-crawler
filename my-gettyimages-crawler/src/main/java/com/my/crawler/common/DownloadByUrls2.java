package com.my.crawler.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.file.Files;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class DownloadByUrls2 {
	public static void main(String[] args) throws IOException {
		File outputFolder = new File("D:\\output\\fappeningbook.com");

		String lastUrl;

		lastUrl = "https://fappeningbook.com/photos/k/a/kate-upton/3000/2393.jpg";
//		lastUrl = "https://fappeningbook.com/photos/z/e/zendaya/2000/1845.jpg";
		lastUrl = "https://fappeningbook.com/photos/s/c/scarlett-johansson/3000/2689.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/e/kelly-brook/4000/3787.jpg";
//		lastUrl = "https://fappeningbook.com/photos/a/m/amber-heard/2000/1868.jpg";
//		lastUrl = "https://fappeningbook.com/photos/b/e/bella-thorne/13000/12421.jpg";
//		lastUrl = "https://fappeningbook.com/photos/m/a/margot-robbie/2000/1790.jpg";
//		lastUrl = "https://fappeningbook.com/photos/m/i/miley-cyrus/7000/6506.jpg";
//		lastUrl = "https://fappeningbook.com/photos/j/e/jennifer-lawrence/3000/2195.jpg";
//		lastUrl = "https://fappeningbook.com/photos/b/r/brooke-shields/1000/124.jpg";
//		lastUrl = "https://fappeningbook.com/photos/n/a/natalie-portman/2000/1255.jpg";
//		lastUrl = "https://fappeningbook.com/photos/m/o/monica-bellucci/2000/1051.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/r/kristanna-loken/1000/258.jpg";
//		lastUrl = "https://fappeningbook.com/photos/s/o/sofia-vergara/3000/2355.jpg";
//		lastUrl = "https://fappeningbook.com/photos/r/i/riley-keough/1000/446.jpg";
//		lastUrl = "https://fappeningbook.com/photos/m/e/megan-fox/5000/4289.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/i/kiko-mizuhara/1000/87.jpg";
//		lastUrl = "https://fappeningbook.com/photos/a/m/amanda-seyfried/1000/917.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/e/keisha-castle-hughes/1000/21.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/i/kiernan-shipka/1000/444.jpg";
//		lastUrl = "https://fappeningbook.com/photos/c/a/carice-van-houten/1000/224.jpg";
//		lastUrl = "https://fappeningbook.com/photos/j/e/jessica-henwick/1000/210.jpg";
//		lastUrl = "https://fappeningbook.com/photos/j/e/jennifer-connelly/1000/566.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/l/elizabeth-banks/1000/459.jpg";
//		lastUrl = "https://fappeningbook.com/photos/m/i/milla-jovovich/1000/312.jpg";
//		lastUrl = "https://fappeningbook.com/photos/r/o/rosabell-laurenti-sellers/1000/28.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/e/keeley-hazell/1000/814.jpg";
//		lastUrl = "https://fappeningbook.com/photos/s/a/saoirse-ronan/1000/210.jpg";
//		lastUrl = "https://fappeningbook.com/photos/r/o/rose-byrne/1000/539.jpg";
//		lastUrl = "https://fappeningbook.com/photos/n/i/nicola-peltz/1000/426.jpg";
//		lastUrl = "https://fappeningbook.com/photos/r/o/rosie-huntington-whiteley/2000/1639.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/a/kathleen-robertson/1000/173.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/m/emily-bett-rickards/1000/104.jpg";
//		lastUrl = "https://fappeningbook.com/photos/m/e/melissa-benoist/1000/167.jpg";
//		lastUrl = "https://fappeningbook.com/photos/r/o/roxane-mesquida/1000/228.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/m/emmanuelle-seigner/1000/152.jpg";
//		lastUrl = "https://fappeningbook.com/photos/d/i/diane-kruger/1000/694.jpg";
//		lastUrl = "https://fappeningbook.com/photos/l/e/lea-seydoux/1000/311.jpg";
//		lastUrl = "https://fappeningbook.com/photos/p/a/paula-patton/1000/414.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/m/emily-browning/1000/299.jpg";
//		lastUrl = "https://fappeningbook.com/photos/d/a/dakota-fanning/1000/544.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/l/elle-fanning/2000/1111.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/i/kirsten-dunst/1000/824.jpg";
//		lastUrl = "https://fappeningbook.com/photos/c/o/cobie-smulders/1000/203.jpg";
//		lastUrl = "https://fappeningbook.com/photos/b/l/blake-lively/1000/936.jpg";
//		lastUrl = "https://fappeningbook.com/photos/v/i/virginie-ledoyen/1000/201.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/l/elodie-yung/1000/31.jpg";
//		lastUrl = "https://fappeningbook.com/photos/g/a/gal-gadot/1000/636.jpg";
//		lastUrl = "https://fappeningbook.com/photos/g/o/golshifteh-farahani/1000/68.jpg";
//		lastUrl = "https://fappeningbook.com/photos/j/e/jessica-biel/2000/1563.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/a/kate-beckinsale/2000/1710.jpg";
//		lastUrl = "https://fappeningbook.com/photos/l/a/lara-pulver/1000/65.jpg";
//		lastUrl = "https://fappeningbook.com/photos/r/h/rhona-mitra/1000/246.jpg";
//		lastUrl = "https://fappeningbook.com/photos/j/e/jessica-gomes/1000/129.jpg";
//		lastUrl = "https://fappeningbook.com/photos/a/l/alicia-vikander/1000/462.jpg";
//		lastUrl = "https://fappeningbook.com/photos/j/a/january-jones/1000/298.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/m/emily-blunt/1000/178.jpg";
//		lastUrl = "https://fappeningbook.com/photos/j/e/jessica-brown-findlay/1000/160.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/a/katy-perry/5000/4612.jpg";
//		lastUrl = "https://fappeningbook.com/photos/s/a/sarah-paulson/1000/93.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/m/emma-roberts/2000/1164.jpg";
//		lastUrl = "https://fappeningbook.com/photos/g/i/gillian-anderson/1000/438.jpg";
//		lastUrl = "https://fappeningbook.com/photos/m/a/madison-beer/6000/5129.jpg";
//		lastUrl = "https://fappeningbook.com/photos/l/e/leelee-sobieski/1000/489.jpg";
		lastUrl = "https://fappeningbook.com/photos/a/n/anya-taylor-joy/2000/1399.jpg";
		lastUrl = "https://fappeningbook.com/photos/m/o/molly-jane/1000/18.jpg";
		lastUrl = "https://fappeningbook.com/photos/b/i/billie-eilish/1000/995.jpg";
		lastUrl = "https://fappeningbook.com/photos/t/a/taylor-swift/3000/2454.jpg";
		lastUrl = "https://fappeningbook.com/photos/a/b/abbey-lee-kershaw/1000/127.jpg";
		lastUrl = "https://fappeningbook.com/photos/c/o/courtney-eaton/1000/161.jpg";
		lastUrl = "https://fappeningbook.com/photos/b/e/bella-hadid/11000/10315.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/v/eva-green/1000/522.jpg";
//		lastUrl = "https://fappeningbook.com/photos/y/v/yvonne-strahovski/1000/603.jpg";
//		lastUrl = "https://fappeningbook.com/photos/a/n/anna-kendrick/1000/280.jpg";
//		lastUrl = "https://fappeningbook.com/photos/a/d/adria-arjona/1000/166.jpg";
//		lastUrl = "https://fappeningbook.com/photos/o/l/olivia-cooke/1000/247.jpg";
//		lastUrl = "https://fappeningbook.com/photos/j/u/julianne-moore/1000/160.jpg";
//		lastUrl = "https://fappeningbook.com/photos/o/l/olga-kurylenko/1000/488.jpg";
//		lastUrl = "https://fappeningbook.com/photos/a/n/andrea-riseborough/1000/89.jpg";

//		lastUrl = "https://fappeningbook.com/photos/l/i/lindsay-lohan/3000/2631.jpg";
//		lastUrl = "https://fappeningbook.com/photos/p/a/paris-hilton/4000/3728.jpg";
//		lastUrl = "https://fappeningbook.com/photos/h/e/heidi-klum/6000/5410.jpg";
//		lastUrl = "https://fappeningbook.com/photos/j/e/jessica-alba/4000/3006.jpg";
//		lastUrl = "https://fappeningbook.com/photos/h/i/hilary-duff/2000/1580.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/e/kelly-macdonald/1000/30.jpg";
//		lastUrl = "https://fappeningbook.com/photos/g/r/gretchen-mol/1000/261.jpg";
//		lastUrl = "https://fappeningbook.com/photos/p/a/paz-de-la-huerta/1000/280.jpg";
//		lastUrl = "https://fappeningbook.com/photos/h/a/hannah-ware/1000/73.jpg";
//		lastUrl = "https://fappeningbook.com/photos/c/h/charlize-theron/2000/1805.jpg";
//		lastUrl = "https://fappeningbook.com/photos/n/a/naomi-watts/1000/426.jpg";
//		lastUrl = "https://fappeningbook.com/photos/l/a/laura-harring/1000/157.jpg";
//		lastUrl = "https://fappeningbook.com/photos/j/e/jennifer-garner/1000/546.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/m/emma-stone/1000/443.jpg";
//		lastUrl = "https://fappeningbook.com/photos/s/i/sigourney-weaver/1000/195.jpg";
//		lastUrl = "https://fappeningbook.com/photos/s/y/sylvia-kristel/1000/203.jpg";
//		lastUrl = "https://fappeningbook.com/photos/c/a/caylee-cowan/2000/1218.jpg";
//		lastUrl = "https://fappeningbook.com/photos/d/o/dove-cameron/2000/1079.jpg";
//		lastUrl = "https://fappeningbook.com/photos/o/l/olivia-wilde/3000/2064.jpg";
//		lastUrl = "https://fappeningbook.com/photos/l/a/laetitia-casta/1000/594.jpg";
//		lastUrl = "https://fappeningbook.com/photos/j/a/jaimie-alexander/1000/220.jpg";
//		lastUrl = "https://fappeningbook.com/photos/l/i/lily-rose-depp/2000/1540.jpg";
//		lastUrl = "https://fappeningbook.com/photos/a/n/angela-lindvall/1000/90.jpg";
//		lastUrl = "https://fappeningbook.com/photos/h/a/hayley-atwell/1000/588.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/l/elizabeth-olsen/1000/893.jpg";
//		lastUrl = "https://fappeningbook.com/photos/g/e/genesis-rodriguez/1000/55.jpg";
//		lastUrl = "https://fappeningbook.com/photos/r/o/rose-leslie/1000/176.jpg";
//		lastUrl = "https://fappeningbook.com/photos/l/i/lily-collins/1000/733.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/i/eiza-gonzalez/4000/3303.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/v/eva-mendes/1000/620.jpg";
//		lastUrl = "https://fappeningbook.com/photos/s/h/shantel-vansanten/1000/664.jpg";
//		lastUrl = "https://fappeningbook.com/photos/c/h/christa-theret/1000/21.jpg";
//		lastUrl = "https://fappeningbook.com/photos/r/a/rachel-brosnahan/1000/193.jpg";
//		lastUrl = "https://fappeningbook.com/photos/m/a/maggie-grace/1000/153.jpg";
//		lastUrl = "https://fappeningbook.com/photos/f/l/florence-pugh/2000/1102.jpg";
//		lastUrl = "https://fappeningbook.com/photos/w/i/willa-fitzgerald/1000/117.jpg";
		lastUrl = "https://fappeningbook.com/photos/h/e/helen-hunt/1000/398.jpg";
//		lastUrl = "https://fappeningbook.com/photos/m/a/maggie-q/1000/172.jpg";
//		lastUrl = "https://fappeningbook.com/photos/p/o/polly-walker/1000/71.jpg";
//		lastUrl = "https://fappeningbook.com/photos/m/a/madeline-zima/1000/124.jpg";
//		lastUrl = "https://fappeningbook.com/photos/m/a/marley-shelton/1000/65.jpg";
//		lastUrl = "https://fappeningbook.com/photos/e/m/emmanuelle-chriqui/2000/1119.jpg";
//		lastUrl = "https://fappeningbook.com/photos/p/a/paulina-gaitan/1000/207.jpg";
//		lastUrl = "https://fappeningbook.com/photos/w/i/winona-ryder/1000/148.jpg";
		lastUrl = "https://fappeningbook.com/photos/j/e/jessica-clark/1000/84.jpg";
		lastUrl = "https://fappeningbook.com/photos/a/n/ana-alexander/1000/84.jpg";

		lastUrl = "https://fappeningbook.com/photos/h/a/hannah-john-kamen/1000/77.jpg";
//		lastUrl = "https://fappeningbook.com/photos/k/a/kaya-scodelario/1000/223.jpg";
//		lastUrl = "https://fappeningbook.com/photos/u/m/uma-thurman/1000/335.jpg";
		lastUrl = "https://fappeningbook.com/photos/j/o/joan-chen/1000/45.jpg";
		lastUrl = "https://fappeningbook.com/photos/k/e/keegan-connor-tracy/1000/71.jpg";
		lastUrl = "https://fappeningbook.com/photos/s/h/sharon-stone/1000/587.jpg";
		lastUrl = "https://fappeningbook.com/photos/c/a/carla-quevedo/1000/73.jpg";
		lastUrl = "https://fappeningbook.com/photos/b/r/brie-larson/1000/686.jpg";
		lastUrl = "https://fappeningbook.com/photos/n/o/noemie-merlant/1000/31.jpg";
		lastUrl = "https://fappeningbook.com/photos/v/a/valeria-golino/1000/178.jpg";
		lastUrl = "https://fappeningbook.com/photos/m/a/marine-vacth/1000/73.jpg";

		lastUrl = "https://fappeningbook.com/photos/c/l/claire-foy/1000/27.jpg";
		lastUrl = "https://fappeningbook.com/photos/r/a/rachel-weisz/1000/211.jpg";
//		lastUrl = "https://fappeningbook.com/photos/p/e/penelope-cruz/2000/1488.jpg";
		lastUrl = "https://fappeningbook.com/photos/m/a/marion-cotillard/1000/459.jpg";
		lastUrl = "https://fappeningbook.com/photos/a/b/abbie-cornish/1000/325.jpg";
		lastUrl = "https://fappeningbook.com/photos/a/m/amira-casar/1000/57.jpg";
		lastUrl = "https://fappeningbook.com/photos/e/m/emilia-clarke/2000/1158.jpg";
		lastUrl = "https://fappeningbook.com/photos/n/a/nathalie-emmanuel/1000/353.jpg";
		lastUrl = "https://fappeningbook.com/photos/n/a/natalie-dormer/1000/177.jpg";
		lastUrl = "https://fappeningbook.com/photos/s/i/sibel-kekilli/1000/138.jpg";
		lastUrl = "https://fappeningbook.com/photos/a/n/ana-de-armas/3000/2755.jpg";
		lastUrl = "https://fappeningbook.com/photos/a/n/ana-de-la-reguera/1000/209.jpg";
		lastUrl = "https://fappeningbook.com/photos/r/e/reese-witherspoon/1000/552.jpg";
		lastUrl = "https://fappeningbook.com/photos/z/o/zoe-kravitz/1000/857.jpg";
		lastUrl = "https://fappeningbook.com/photos/e/v/evanna-lynch/1000/41.jpg";
		lastUrl = "https://fappeningbook.com/photos/s/t/stella-maxwell/3000/2317.jpg";
		lastUrl = "https://fappeningbook.com/photos/l/a/laura-linney/1000/81.jpg";
		lastUrl = "https://fappeningbook.com/photos/k/a/kathryn-newton/1000/147.jpg";
		lastUrl = "https://fappeningbook.com/photos/k/e/kerry-bishe/1000/24.jpg";
		lastUrl = "https://fappeningbook.com/photos/k/a/katheryn-winnick/1000/387.jpg";
		lastUrl = "https://fappeningbook.com/photos/j/u/julia-garner/1000/147.jpg";
		String[] arr = lastUrl.split("\\/");
		String title = arr[arr.length - 3];

		String lastIndexStr = lastUrl.substring(lastUrl.lastIndexOf('/') + 1, lastUrl.lastIndexOf('.'));
		int end = Integer.parseInt(lastIndexStr);

		File saveDir = new File(outputFolder, title);
		saveDir.mkdir();
		int last = lastUrl.lastIndexOf("/");
		String urlPrefix = lastUrl.substring(0, last);
		last = urlPrefix.lastIndexOf("/");
		urlPrefix = urlPrefix.substring(0, last);
		for (int index = 1; index <= end; index++) {
			int range = 1000 * (index / 1000 + 1);
			String urlString = urlPrefix + "/" + range + "/" + index + ".jpg";

			System.out.println("正在下载" + index + ":" + urlString);
			try {
				downLoadFromUrl(urlString, saveDir, null);
			} catch (SocketException | SocketTimeoutException | FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	public static void downLoadFromUrl(String urlStr, File saveDir, String toekn) throws IOException {
		URL url = new URL(urlStr);
		IPath path = new Path(url.getPath());
		String newImgFileName = path.segment(path.segmentCount() - 1);

		File imgFile = new File(saveDir, newImgFileName);

		// 文件保存位置
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		if (imgFile.exists()) {
			System.out.println("File " + imgFile + " already exist. ");
			return;
		}
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 10809));
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
		// 设置超时间为3秒
		conn.setConnectTimeout(3 * 1000);
		// 防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		// conn.setRequestProperty("lfwywxqyh_token", toekn);

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
		System.out.println("Download " + imgFile + " success.");
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

	public static JSONArray getImgMap(File outputFolder) throws IOException {
		File logFile = new File(outputFolder, "json.log");
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
