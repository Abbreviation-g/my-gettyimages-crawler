package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

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
		扫描网红();
//		扫描生图();

//		扫描欧阳娜娜();
//		扫描宋妍霏();
//		扫描王紫璇();
//		扫描赵露思();
//		扫描张天爱();
//		扫描王鸥();
//		扫描娜扎();
//		扫描林允();
//		扫描韩雪();
//		扫描关晓彤();
//		扫描吴宣仪();
//		扫描热巴();
//		扫描宋祖儿();
//		扫描程潇();
//
//		扫描王玉雯();
//		扫描王秀竹();
//		扫描吴优();
//		扫描王楚然();
//		扫描赵今麦();
//		扫描蒋依依();
//		扫描张婧仪();
//		扫描张予曦();
//		扫描陈都灵();
//		扫描胡连馨();
//		扫描许佳琪();
//		扫描杨幂();
//		扫描孟佳();
//		扫描秦岚();
//		扫描范冰冰();
//		扫描蔡文静();
//		扫描白鹿();
//		扫描倪妮();
//		扫描黛薇卡();
//		扫描李一桐();
//		扫描周洁琼();
//		扫描王鹤润();
//		扫描孟子义();
//		扫描李沁();
//		扫描江疏影();

//		扫描欧美();
//		扫描韩国();
//		扫描日本写真();
//		扫描日本演员();
//		扫描明星图片();
//		扫描明星1();
//		扫描明星2();
//		扫描明星3();
		
//		扫描张嘉倪();

//		开始扫描();
	}

	private static void 扫描江疏影() throws IOException {
		扫描(Constants.江疏影());
	}
	private static void 扫描李沁() throws IOException {
		扫描(Constants.李沁());
	}
	private static void 扫描孟子义() throws IOException {
		扫描(Constants.孟子义());
	}
	private static void 扫描王鹤润() throws IOException {
		扫描(Constants.王鹤润());
	}
	private static void 扫描周洁琼() throws IOException {
		扫描(Constants.周洁琼());
	}
	private static void 扫描李一桐() throws IOException {
		扫描(Constants.李一桐());
	}
	private static void 扫描黛薇卡() throws IOException {
		扫描(Constants.黛薇卡());
	}
	private static void 扫描倪妮() throws IOException {
		扫描(Constants.倪妮());
	}
	private static void 扫描白鹿() throws IOException {
		扫描(Constants.白鹿());
	}
	private static void 扫描蔡文静() throws IOException {
		扫描(Constants.蔡文静());
	}
	private static void 扫描范冰冰() throws IOException {
		扫描(Constants.范冰冰());
	}
	private static void 扫描秦岚() throws IOException {
		扫描(Constants.秦岚());
	}
	private static void 扫描孟佳() throws IOException {
		扫描(Constants.孟佳());
	}
	private static void 扫描杨幂() throws IOException {
		扫描(Constants.杨幂());
	}

	private static void 扫描许佳琪() throws IOException {
		扫描(Constants.许佳琪());
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

	private static void 扫描胡连馨() throws IOException {
		扫描(Constants.胡连馨());
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
			System.out.println("id: " + idNameEntity.id + "\t name: " + idNameEntity.screen_name);
			start(idNameEntity.getId(), new File(folderBasePath, idNameEntity.screen_name));
			Constants.randomSleepLong();
			根据picvideolog开始下载.下载Mov2(idNameEntity);
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

	private static void 扫描日本演员() throws IOException {
		扫描(Constants.日本演员());
	}

	private static void 扫描生图() throws IOException {
//		扫描(Constants.生图());
		for (IDNameEntity idNameEntity : Constants.生图()) {
			System.out.println("id: " + idNameEntity.id + "\t name: " + idNameEntity.screen_name);
			start(idNameEntity.getId(), new File(folderBasePath, idNameEntity.screen_name));
			Constants.randomSleepLong();
		}
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

	private static void 扫描明星图片() throws IOException {
		扫描(Constants.明星图片());
	}
	private static void 扫描明星3() throws IOException {
		扫描(Constants.明星3());
	}
	private static void 扫描明星2() throws IOException {
		扫描(Constants.明星2());
	}
	private static void 扫描明星1() throws IOException {
		扫描(Constants.明星1());
	}

	private static void 开始扫描() throws IOException {
//		start("7772266364", new File(folderBasePath, "Rachelcook1995"));
		start("5638789392", new File(folderBasePath, "rachelcook14"));
//		start("6459256544", new File(folderBasePath, "上戏啦"));
//		start("3807003830", new File(folderBasePath, "张若晞Roxie"));
//		start("7284275957", new File(folderBasePath, "坠落星空·江疏影"));
//		start("6891885433",1, 300, new File(folderBasePath, "戏客Seeker"));
//		start("1807391080", new File(folderBasePath, "Constence刘彦池"));
//		根据picvideolog开始下载.下载Mov2(new IDNameEntity("1807391080", "Constence刘彦池"));
//		start("2595359142", new File(folderBasePath, "Yakisa彭雅琦"));
//		根据picvideolog开始下载.下载Mov2(new IDNameEntity("2595359142", "Yakisa彭雅琦"));
//		start("6521611081", new File(folderBasePath, "食梦鲨"));
//		根据picvideolog开始下载.下载Mov2(new IDNameEntity("6521611081", "食梦鲨"));
//		start("1378010100", new File(folderBasePath, "王子文Ava"));
//		根据picvideolog开始下载.下载Mov2(new IDNameEntity("1378010100", "王子文Ava"));
//		start("1722686885", new File(folderBasePath, "王卓淇erin__kay"));
//		根据picvideolog开始下载.下载Mov2(new IDNameEntity("1722686885", "王卓淇erin__kay"));
//		start("1231654104", new File(folderBasePath, "刘芸"));
//		根据picvideolog开始下载.下载Mov2(new IDNameEntity("1231654104", "刘芸"));
//		start("1240008360", new File(folderBasePath, "王媛可"));
//		根据picvideolog开始下载.下载Mov2(new IDNameEntity("1240008360", "王媛可"));
//		start("1258859614", new File(folderBasePath, "我是江一燕"));
//		根据picvideolog开始下载.下载Mov2(new IDNameEntity("1258859614", "我是江一燕"));
//		start("6519552504", new File(folderBasePath, "陈梦儿-myYY"));
//		根据picvideolog开始下载.下载Mov2(new IDNameEntity("6519552504", "陈梦儿-myYY"));
//		start("1853627313", new File(folderBasePath, "卓仕琳"));
//		根据picvideolog开始下载.下载Mov2(new IDNameEntity("1853627313", "卓仕琳"));
//		start("6130786243", new File(folderBasePath, "流星牛角"));
//		根据picvideolog开始下载.下载Mov2(new IDNameEntity("6130786243", "流星牛角"));
//		start("5044684628", new File(folderBasePath, "嘉行传媒"));
//		start("1715351501", new File(folderBasePath, "辛芷蕾"));
//		start("5945340823", new File(folderBasePath, "辛芷蕾工作室"));
//		start("1264948457", new File(folderBasePath, "董璇粉丝团"));
//		start("2883701284", new File(folderBasePath, "O0笨笨呀0O-梁洁"));
//		start("2283247914", new File(folderBasePath, "JunoTieN"));
////		start("5489873079", new File(folderBasePath, "先锋大队长的后腿"));
//		start("5503504780", new File(folderBasePath, "吉娜爱丽丝Gina"));
//		start("7362539881", new File(folderBasePath, "黄梦莹工作室"));
//		start("1676082433", new File(folderBasePath, "高圆圆"));
//		start("5234965173", new File(folderBasePath, "甘婷婷工作室"));
//		start("7040041221", new File(folderBasePath, "潇骑校尉曹操"));
//		start("6349746169", new File(folderBasePath, "冯文娟工作室"));
//		start("1504964033", new File(folderBasePath, "冯文娟"));
//		start("5658396874", new File(folderBasePath, "安雅泰勒乔伊"));
//		start("5511171110", new File(folderBasePath, "安雅泰勒-乔伊"));
//		start("3561627892", new File(folderBasePath, "EstherHeesch吧"));
//		start("7607376925", new File(folderBasePath, "是你的程儿"));
//		start("2382243211", new File(folderBasePath, "hThT__"));
//		start("1734442735", new File(folderBasePath, "汪小敏"));
//		start("7309784142", new File(folderBasePath, "Penicillin·倪妮"));
//		start("7489613730", new File(folderBasePath, "北纬26度想Ni·倪妮"));
//		start("7457436869", new File(folderBasePath, "KleinBlue·倪妮"));
//		start("2595359142", new File(folderBasePath, "Yakisa彭雅琦"));
//		start("1233965570", new File(folderBasePath, "川外川"));
//		start("7772266364", new File(folderBasePath, "Rachelcook1995"));
//		start("6518263844", new File(folderBasePath, "镜头兄"));
//		start("6467863545", new File(folderBasePath, "tbbhktjj"));
//		start("6472458430", new File(folderBasePath, "SkyPictorial"));
//		start("1197002213", new File(folderBasePath, "男人装"));
//		start("2966904732", new File(folderBasePath, "美好身体bo"));
//		start("6973729551", new File(folderBasePath, "HeartSniper_许佳琪"));
//		start("1874288121", new File(folderBasePath, "王瑞子715"));
//		start("5279748872", new File(folderBasePath, "yesyanbaby"));
//		start("3987343279", new File(folderBasePath, "河北彩伽-元河北彩花"));
//		start("5732211644", new File(folderBasePath, "河北彩伽"));
//		start("7409628440", new File(folderBasePath, "AprilFox_Naran娜然"));
//		start("7415540957", new File(folderBasePath, "月与玫瑰__娜然Naran"));
//		start("7014245539", new File(folderBasePath, "娜然丨NaranDaily"));
//		start("7863307524", new File(folderBasePath, "娜然Naran工作室"));
//		start("6463277233", new File(folderBasePath, "娜然Naran"));
//		start("2646681810", new File(folderBasePath, "林允Jelly"));
//		start("1237313773", new File(folderBasePath, "热依扎"));
//		start("1957663211", new File(folderBasePath, "张芷溪"));
//		start("6368929929", new File(folderBasePath, "王子文工作室微博"));
//		start("1222062284", new File(folderBasePath, "张萌"));
//		start("1313228221", new File(folderBasePath, "李佳桐sep"));
//		start("1307243944", new File(folderBasePath, "李依晓"));
//		start("1741661732", new File(folderBasePath, "顾璇"));
//		start("6521611081", new File(folderBasePath, "食梦鲨"));
//		start("1951027255", new File(folderBasePath, "李如儒"));
//		start("1819744725", new File(folderBasePath, "王乐君"));
//		start("5197213436", new File(folderBasePath, "金佳悦-"));
//		start("3262625014", new File(folderBasePath, "唐艺昕工作室"));
//		start("1862896261", new File(folderBasePath, "松岡李那LinahM"));
//		start("3285031871", new File(folderBasePath, "刘美彤"));
//		start("1345943410", new File(folderBasePath, "刘美含"));
//		start("2742586765", new File(folderBasePath, "孙嘉璐Ruby"));
//		start("5994952329", new File(folderBasePath, "包上恩"));
//		start("2169289455", new File(folderBasePath, "孙雪宁ooo"));
//		start("1280435871", new File(folderBasePath, "YUNAN男男"));
//		start("6079596473", new File(folderBasePath, "老余那些事"));
//		start("1890196401", new File(folderBasePath, "不2不叫周淑怡"));
//		start("7499320208", new File(folderBasePath, "刘芊螢_LQY"));
//		start("1624095323", new File(folderBasePath, "曲尼次仁"));
//		start("1898812132", new File(folderBasePath, "吳千語全球官方後援會"));
//		start("5849619820", new File(folderBasePath, "蔡卓宜工作室"));
//		start("7120634645", new File(folderBasePath, "李若嘉工作室"));
//		start("6576856192", new File(folderBasePath, "火箭少女101官博"));
//		start("1243273752", new File(folderBasePath, "古晨"));
//		start("1714246692", new File(folderBasePath, "傅嘉莉KellyFu"));
//		start("1297916241", new File(folderBasePath, "洋气YOUNGCHIC"));
//		start("7782739992", new File(folderBasePath, "无尽热恋丨1226x1109"));
//		start("3603256695", new File(folderBasePath, "梦醒忒远"));
//		start("6650714202", new File(folderBasePath, "李凯馨Eleanor工作室"));
//		start("7749127987", new File(folderBasePath, "·AllForZendaya·"));
//		start("3635953843", new File(folderBasePath, "MadisonBeerUpdates"));
//		start("5335569701", new File(folderBasePath, "凯瑟琳纽顿0208"));
//		start("3194073462", new File(folderBasePath, "MetFreckle"));
//		start("7832948489", new File(folderBasePath, "周也资讯站"));
//		start("5666687855", new File(folderBasePath, "BellaHadidCN"));
//		start("7329838548", new File(folderBasePath, "SydneySweeneyCN"));
	}

	public static void start(String uid, File folder) throws IOException {
		start(uid, 0, folder);
	}
	
	private static void start(String uid, int beginPage,int endPage, File folder) throws IOException {
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
			if (beginPage == 0) {
				lastestDate = getLastestDate(oldObject);
			}
		}

		JSONArray newWeiboArray = WeiboUIDToWeiboArray.getWeiboArray(uid, beginPage,endPage, lastestDate);
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
			if (beginPage == 0) {
				lastestDate = getLastestDate(oldObject);
			}
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
