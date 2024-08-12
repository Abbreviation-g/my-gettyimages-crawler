package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.my.crawler.weibo2.Constants.IDNameEntity;

public class 根据UID扫描所有weibo并解析pic和video {
	static String folderBasePath = "F:\\weibo_log";

	public static void main(String[] args) throws IOException {
//		扫描半年可见();
//		扫描特别关注();
		扫描生图();
		扫描网红();

//		扫描欧阳娜娜();
//		扫描宋妍霏();
//		扫描王紫璇();
//		扫描赵露思();
//		扫描张天爱();
//		扫描王鸥();
//		扫描娜扎();
//		扫描林允();
//		扫描吴优();
//		扫描韩雪();
//		扫描关晓彤();
//		扫描吴宣仪();
//		扫描程潇();
//		扫描王玉雯();
//		扫描热巴();
//		扫描王楚然();
//		扫描王秀竹();
//		扫描赵今麦();
//		扫描蒋依依();
//		扫描张婧仪();
//		扫描张予曦();
//		扫描陈都灵();

//		扫描欧美();
//		扫描韩国();
//		扫描日本写真();
//		扫描日本();

//		扫描宋祖儿();
//		扫描张嘉倪();

		开始扫描();
	}

	private static void 扫描陈都灵() throws IOException {
		扫描(Constants.陈都灵());
	}

	private static void 扫描半年可见() throws IOException {
		扫描(Constants.半年可见());
	}

	private static void 扫描特别关注() throws IOException {
		扫描(Constants.特别关注());
	}

	private static void 扫描赵今麦() throws IOException {
		扫描(Constants.赵今麦());
	}

	private static void 扫描王秀竹() throws IOException {
		扫描(Constants.王秀竹());
	}

	private static void 扫描王楚然() throws IOException {
		扫描(Constants.王楚然());
	}

	private static void 扫描热巴() throws IOException {
		扫描(Constants.热巴());
	}

	private static void 扫描王玉雯() throws IOException {
		扫描(Constants.王玉雯());
	}

	private static void 扫描王紫璇() throws IOException {
		扫描(Constants.王紫璇());
	}

	private static void 扫描程潇() throws IOException {
		扫描(Constants.程潇());
	}

	private static void 扫描宋祖儿() throws IOException {
		扫描(Constants.宋祖儿());
	}

	private static void 扫描欧阳娜娜() throws IOException {
		扫描(Constants.欧阳娜娜());
	}

	private static void 扫描王鸥() throws IOException {
		扫描(Constants.王鸥());
	}

	private static void 扫描赵露思() throws IOException {
		扫描(Constants.赵露思());
	}

	private static void 扫描张婧仪() throws IOException {
		扫描(Constants.张婧仪());
	}

	private static void 扫描(Collection<IDNameEntity> entities) throws IOException {
		for (IDNameEntity idNameEntity : entities) {
			start(idNameEntity.getId(), new File(folderBasePath, idNameEntity.screen_name));
			Constants.randomSleepLong();
		}
	}

	private static void 扫描娜扎() throws IOException {
		扫描(Constants.娜扎());
	}

	private static void 扫描张天爱() throws IOException {
		扫描(Constants.张天爱());
	}

	private static void 扫描张嘉倪() throws IOException {
		扫描(Constants.张嘉倪());
	}

	private static void 扫描关晓彤() throws IOException {
		扫描(Constants.关晓彤());
	}

	private static void 扫描欧美() throws IOException {
		扫描(Constants.欧美());
	}

	private static void 扫描韩国() throws IOException {
		扫描(Constants.韩国());
	}

	private static void 扫描日本写真() throws IOException {
		扫描(Constants.日本写真());
	}

	private static void 扫描日本() throws IOException {
		扫描(Constants.日本());
	}

	private static void 扫描生图() throws IOException {
		扫描(Constants.生图());
	}

	private static void 扫描吴优() throws IOException {
		扫描(Constants.吴优());
	}

	private static void 扫描吴宣仪() throws IOException {
		扫描(Constants.吴宣仪());
	}

	private static void 扫描林允() throws IOException {
		扫描(Constants.林允());
	}

	private static void 扫描宋妍霏() throws IOException {
		扫描(Constants.宋妍霏());
	}

	private static void 扫描韩雪() throws IOException {
		扫描(Constants.韩雪());
	}

	private static void 扫描蒋依依() throws IOException {
		扫描(Constants.蒋依依());
	}

	private static void 扫描网红() throws IOException {
		扫描(Constants.网红());
	}

	private static void 扫描张予曦() throws IOException {
		扫描(Constants.张予曦());
	}

	private static void 开始扫描() throws IOException {
//		start("1549364094", new File(folderBasePath, "江疏影"));
//		start("1246229612", new File(folderBasePath, "毛晓彤"));
//		start("1307243944", new File(folderBasePath, "李依晓"));
//		start("2569522534", new File(folderBasePath, "孟子义"));
//		start("5044684628", 1000, new File(folderBasePath, "嘉行传媒"));
//		start("7120634645", new File(folderBasePath, "李若嘉工作室"));
//		start("6576856192", new File(folderBasePath, "火箭少女101官博"));
//		start("1243273752", new File(folderBasePath, "古晨"));
//		start("3639470012", new File(folderBasePath, "青蛙公主爱凌"));
//		start("1714246692", new File(folderBasePath, "傅嘉莉KellyFu"));
//		start("2012998250", new File(folderBasePath, "张馨予工作室"));
//		start("1304048383", new File(folderBasePath, "李若嘉"));
//		start("6489906026", new File(folderBasePath, "星图驿站"));
//		start("7237314735", new File(folderBasePath, "星素鉴赏"));
//		start("2174204211", new File(folderBasePath, "唐嫣工作室"));
//		start("2687827715", new File(folderBasePath, "歐陽娜娜Nana"));
//		start("5943076204", new File(folderBasePath, "歐陽娜娜Nana工作室"));
//		start("1297916241", new File(folderBasePath, "洋气YOUNGCHIC"));
//		start("6387099968", new File(folderBasePath, "张婧仪"));
//		start("7610808848", new File(folderBasePath, "张婧仪工作室"));
//		start("5038633340", new File(folderBasePath, "沈羽洁er"));
//		start("5666687855", new File(folderBasePath, "BellaHadidCN"));
//		start("3733026753", new File(folderBasePath, "于雯_"));
//		start("2153913104", new File(folderBasePath, "Karena吳千語"));
//		start("5617960493", new File(folderBasePath, "徐璐工作室"));
//		start("5954919139", new File(folderBasePath, "蒋梦婕工作室"));
//		start("1749964961", new File(folderBasePath, "张馨予"));
//		start("1549364094", new File(folderBasePath, "江疏影"));
//		start("1848949921", new File(folderBasePath, "姜珮瑶"));
//		start("1659390800", new File(folderBasePath, "蒋梦婕"));
//		start("1378010100", new File(folderBasePath, "王子文Ava"));
//		start("6525010965", new File(folderBasePath, "狐厂大拷问"));
//		start("7782739992", new File(folderBasePath, "无尽热恋丨1226x1109"));
		start("3603256695", new File(folderBasePath, "梦醒忒远"));
//		start("2687827715", new File(folderBasePath, "歐陽娜娜Nana"));
//		start("1590144567", new File(folderBasePath, "潘霜霜Shayla"));
//		start("6650714202", new File(folderBasePath, "李凯馨Eleanor工作室"));
//		start("1756505647", new File(folderBasePath, "Ming奚梦瑶"));
//		start("2106192855", new File(folderBasePath, "赵今麦angel"));
//		start("6521611081", new File(folderBasePath, "食梦鲨"));
//		start("1246850033", new File(folderBasePath, "徐冬冬"));
//		start("2717603311", new File(folderBasePath, "李則慧"));
//		start("5878805423", new File(folderBasePath, "BDD东"));
//		start("1917053352", new File(folderBasePath, "王紫璇CiCi"));
//		start("6363000838", new File(folderBasePath, "林允的小号r"));
//		start("1873771623", new File(folderBasePath, "康可人"));
//		start("1712539910", new File(folderBasePath, "陈乔恩"));
//		start("7749127987", new File(folderBasePath, "·AllForZendaya·"));
//		start("3635953843", new File(folderBasePath, "MadisonBeerUpdates"));
//		start("5335569701", new File(folderBasePath, "凯瑟琳纽顿0208"));
//		start("2950251663", new File(folderBasePath, "吉尼Gini"));
//		start("1586249967", new File(folderBasePath, "汤梦佳"));
//		start("7720744067", new File(folderBasePath, "明星生图现场"));
//		start("2389396110", new File(folderBasePath, "Fyuan方圆"));
//		start("1747837917", new File(folderBasePath, "林逸欣Shara"));
//		start("3194073462", new File(folderBasePath, "MetFreckle"));
//		start("1915458005", new File(folderBasePath, "刘湘_11"));
//		start("1913244047", new File(folderBasePath, "钟楚曦工作室"));
//		start("1943405723", new File(folderBasePath, "钟楚曦"));
//		start("1229385395", new File(folderBasePath, "董璇"));
//		start("5397349535", new File(folderBasePath, "一个阿茶-"));
//		start("7832948489", new File(folderBasePath, "周也资讯站"));
//		start("5666687855", new File(folderBasePath, "BellaHadidCN"));
//		start("7329838548", new File(folderBasePath, "SydneySweeneyCN"));
	}

	public static void start(String uid, File folder) throws IOException {
		start(uid, 0, folder);
	}

	private static void start(String uid, int beginPage, File folder) throws IOException {
//		File weiboArrayFile = new File(folder, Constants.WEIBO_ARRAY_FILE_NAME);
		File picVideoLogFile = new File(folder, Constants.PICS_VIDEOS_FILE_NAME);
		Date lastestDate = null;
		JSONObject oldObject = null;
//		JSONArray oldArray = null;
		if (picVideoLogFile.exists()) {
//			String content = Files.readString(picVideoLogFile.toPath());
//			oldObject = JSON.parseObject(content);

			String content = Files.readString(picVideoLogFile.toPath());
			oldObject = JSON.parseObject(content);
			lastestDate = getLastestDate(oldObject);
		}

		JSONArray newWeiboArray = WeiboUIDToWeiboArray.getWeiboArray(uid, beginPage, lastestDate);
		JSONObject picVideoObjects = WeiboArrayToPicsVideos.weiboArrayToPicsVideos(newWeiboArray);
		if (picVideoObjects.isEmpty()) {
			System.err.println("解析 \t" + uid + "\t失败");
			return;
		}
		if (oldObject != null) {
			picVideoObjects = WeiboArrayToPicsVideos.mergeOldAndNew(oldObject, picVideoObjects);
//			for (int i = 0; i < oldArray.size(); i++) {
//				newWeiboArray.add(oldArray.get(i));
//			}
		}

		if (!folder.exists()) {
			folder.mkdirs();
		}
		System.gc();
//		try {
//			Files.writeString(weiboArrayFile.toPath(), newWeiboArray.toString(SerializerFeature.PrettyFormat));
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
		try {
			Files.writeString(picVideoLogFile.toPath(), picVideoObjects.toString(SerializerFeature.PrettyFormat));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static Date getLastestDate(JSONObject jsonObject) {
		Date lastestDate = null;
		Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
		for (String key : jsonObject.keySet()) {
			// 2021-06-15-4648163283830571
			String[] split = key.split("-");
			calendar.set(Integer.parseInt(split[0]), Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2]), 0, 0, 0);

			Date currentDate = calendar.getTime();
			if (lastestDate == null) {
				lastestDate = currentDate;
			}
			if (currentDate.after(lastestDate)) {
				lastestDate = currentDate;
			}
		}
		return lastestDate;
	}

	private static Date getLastestDate(File picVideoLogFile) {
		return new Date(picVideoLogFile.lastModified());
	}

	private static Date getLastestDate(JSONArray array) {
		Date lastestDate = null;
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
			String created_at = jsonObject.getString("created_at");
			@SuppressWarnings("deprecation")
			Date currentDate = new Date(created_at);
			if (lastestDate == null) {
				lastestDate = currentDate;
			}
			if (currentDate.after(lastestDate)) {
				lastestDate = currentDate;
			}
		}
		return lastestDate;
	}
}
