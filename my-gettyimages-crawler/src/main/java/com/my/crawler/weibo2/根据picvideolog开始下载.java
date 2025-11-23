package com.my.crawler.weibo2;

import static com.my.crawler.weibo2.WeiboImageDownloaderExt.start;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.my.crawler.weibo2.Constants.IDNameEntity;

public class 根据picvideolog开始下载 {
	public static void main(String[] args) throws IOException {
//		下载MOVs();

//		下载部分生图();
//		下载(Constants.半年可见(), "H:/weibo-" + "半年可见");
//		下载(Constants.特别关注(), "H:/weibo-" + "特别关注");
//		下载(Constants.网红(), "H:/weibo-网红");
     
//		下载(Constants.欧阳娜娜(), "H:/weibo-" + "欧阳娜娜");
//		下载(Constants.宋妍霏(), "H:/weibo-" + "宋妍霏");
//		下载(Constants.王紫璇(), "H:/weibo-" + "王紫璇");
//		下载(Constants.赵露思(), "H:/weibo-" + "赵露思");
//		下载(Constants.张天爱(), "H:/weibo-" + "张天爱");
//		下载(Constants.王鸥(), "H:/weibo-" + "王鸥");
//		下载(Constants.娜扎(), "H:/weibo-" + "娜扎");
//		下载(Constants.林允(), "H:/weibo-" + "林允");
//		下载(Constants.韩雪(), "H:/weibo-" + "韩雪");
//		下载(Constants.关晓彤(), "H:/weibo-" + "关晓彤");
//		下载(Constants.吴宣仪(), "H:/weibo-" + "吴宣仪");
//		下载(Constants.热巴(), "H:/weibo-" + "热巴");
//		下载(Constants.宋祖儿(), "H:/weibo-" + "宋祖儿");
//		下载(Constants.程潇(), "H:/weibo-" + "程潇");
//
//		下载(Constants.王玉雯(), "H:/weibo-" + "王玉雯");
//		下载(Constants.王秀竹(), "H:/weibo-" + "王秀竹");
//		下载(Constants.吴优(), "H:/weibo-" + "吴优");
//		下载(Constants.王楚然(), "H:/weibo-" + "王楚然");
//		下载(Constants.赵今麦(), "H:/weibo-" + "赵今麦");
//		下载(Constants.蒋依依(), "H:/weibo-" + "蒋依依");
//		下载(Constants.张婧仪(), "H:/weibo-" + "张婧仪");
//		下载(Constants.张予曦(), "H:/weibo-" + "张予曦");
//		下载(Constants.陈都灵(), "H:/weibo-" + "陈都灵");
//		下载(Constants.胡连馨(), "H:/weibo-" + "胡连馨");
//		下载(Constants.许佳琪(), "H:/weibo-" + "许佳琪");
//		下载(Constants.杨幂(), "H:/weibo-" + "杨幂");
//		下载(Constants.孟佳(), "H:/weibo-" + "孟佳");
//		下载(Constants.秦岚(), "H:/weibo-" + "秦岚");
//		下载(Constants.范冰冰(), "H:/weibo-" + "范冰冰");
//		下载(Constants.蔡文静(), "H:/weibo-" + "蔡文静");
//		下载(Constants.白鹿(), "H:/weibo-" + "白鹿");
//		下载(Constants.倪妮(), "H:/weibo-" + "倪妮");
//		下载(Constants.李一桐(), "H:/weibo-" + "李一桐");
//		下载(Constants.王鹤润(), "H:/weibo-" + "王鹤润");
//		下载(Constants.周洁琼(), "H:/weibo-" + "周洁琼");
//		下载(Constants.孟子义(), "H:/weibo-" + "孟子义");
//		下载(Constants.李沁(), "H:/weibo-" + "李沁");
//		下载(Constants.江疏影(), "H:/weibo-" + "江疏影");
//		下载(Constants.景甜(), "H:/weibo-" + "景甜");
//		
//		下载(Constants.孙芮(), "H:/weibo-" + "孙芮");
//		下载(Constants.周也(), "H:/weibo-" + "周也");
//		下载(Constants.章若楠(), "H:/weibo-" + "章若楠");
//		下载(Constants.杨超越(), "H:/weibo-" + "杨超越");
//		下载(Constants.鞠婧祎(), "H:/weibo-" + "鞠婧祎");
//		下载(Constants.傅菁(), "H:/weibo-" + "傅菁");
//		下载(Constants.田曦薇(), "H:/weibo-" + "田曦薇");
//		下载(Constants.钟楚曦(), "H:/weibo-" + "钟楚曦");
//		下载(Constants.张雪迎(), "H:/weibo-" + "张雪迎");
//		下载(Constants.辛芷蕾(), "H:/weibo-" + "辛芷蕾");
//		下载(Constants.曾黎(), "H:/weibo-" + "曾黎");
//		下载(Constants.刘诗诗(), "H:/weibo-" + "刘诗诗");
//		下载(Constants.代斯(), "H:/weibo-" + "代斯");
//		下载(Constants.梁洁(), "H:/weibo-" + "梁洁");
//		下载(Constants.张嘉倪(), "H:/weibo-" + "张嘉倪");
//		下载(Constants.徐璐(), "H:/weibo-" + "徐璐");
//
//		下载(Constants.黄杨钿甜(), "H:/weibo-" + "黄杨钿甜");
//		下载明星1();
//		下载明星2();
//		下载明星3();
//
		下载部分日本写真();
//		下载日本演员();
//		下载();

//		下载生图();
//		下载部分明星图片();

//		下载欧美();
	}

	private static void 下载MOVs() throws IOException {
		下载MOV(Constants.半年可见());
		下载MOV(Constants.特别关注());
		下载MOV(Constants.网红());

		下载MOV(Constants.明星1());
		下载MOV(Constants.明星2());
		下载MOV(Constants.明星3());

		下载MOV(Constants.倪妮());
		下载MOV(Constants.白鹿());
		下载MOV(Constants.蔡文静());
		下载MOV(Constants.许佳琪());
		下载MOV(Constants.蒋依依());
		下载MOV(Constants.张婧仪());
		下载MOV(Constants.张嘉倪());
		下载MOV(Constants.王楚然());
		下载MOV(Constants.王秀竹());
		下载MOV(Constants.吴优());
		下载MOV(Constants.热巴());
		下载MOV(Constants.王玉雯());
		下载MOV(Constants.王紫璇());
		下载MOV(Constants.程潇());
		下载MOV(Constants.赵露思());
		下载MOV(Constants.王鸥());
		下载MOV(Constants.欧阳娜娜());
		下载MOV(Constants.林允());
		下载MOV(Constants.张天爱());
		下载MOV(Constants.关晓彤());
		下载MOV(Constants.娜扎());
		下载MOV(Constants.胡连馨());
		下载MOV(Constants.韩雪());
		下载MOV(Constants.赵今麦());
		下载MOV(Constants.宋祖儿());
		下载MOV(Constants.吴宣仪());
		下载MOV(Constants.宋妍霏());
		下载MOV(Constants.张予曦());
		下载MOV(Constants.范冰冰());
		下载MOV(Constants.秦岚());
		下载MOV(Constants.孟佳());
		下载MOV(Constants.杨幂());
		下载MOV(Constants.陈都灵());
	}

	private static void 下载明星1() throws IOException {
		for (Constants.IDNameEntity entity : Constants.明星1()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("H:/weibo1", entity.screen_name), 2025, 1, 1, 2099, 12, 31);
		}
	}

	private static void 下载明星2() throws IOException {
		for (Constants.IDNameEntity entity : Constants.明星2()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("H:/weibo2", entity.screen_name), 2025, 1, 1, 2099, 12, 31);
		}
	}

	private static void 下载明星3() throws IOException {
		for (Constants.IDNameEntity entity : Constants.明星3()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("H:/weibo3", entity.screen_name), 2025, 1, 1, 2099, 12, 31);
		}
	}

	private static void 下载日本演员() throws IOException {
		下载(Constants.日本演员(), "H:/weibo-" + "日本演员");
	}

	private static void 下载欧美() throws IOException {
//		下载(Constants.欧美());
		for (Constants.IDNameEntity entity : Constants.欧美()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("H:/weibo-欧美", entity.screen_name), 2000, 1, 1, 2011, 5, 4);
			start(new File("F:/weibo_log", entity.screen_name), new File("H:/weibo-欧美", entity.screen_name), 2024, 9, 1, 2099, 5, 4);
		}
	}

	static void 下载Mov2(Constants.IDNameEntity entity) throws IOException {
		File picVideoLogFolder = new File("F:/weibo_log", entity.screen_name);
		File picVideoLogFile = new File(picVideoLogFolder, Constants.PICS_VIDEOS_FILE_NAME);
		WeiboImageDownloaderExt.startMov(picVideoLogFile, new File("H:/weibo-mov", entity.screen_name), picVideoLogFolder);
	}

	static void 下载MOV(Collection<IDNameEntity> entities) throws IOException {
		for (Constants.IDNameEntity entity : entities) {
			下载Mov2(entity);
		}
	}

	private static void 下载(Collection<IDNameEntity> entities, String baseOutputFolder) throws IOException {
		for (Constants.IDNameEntity entity : entities) {
			start(new File("F:/weibo_log", entity.screen_name), new File(baseOutputFolder, entity.screen_name));
		}
	}

	private static void 下载部分生图() throws IOException {
		Set<String> searchKeys = Constants.searchKeys1();

		Set<String> weiboLogFolerNames = Constants.生图().stream().map(entity -> entity.screen_name).collect(Collectors.toCollection(LinkedHashSet::new));

		File mainWeiboLogFolder = new File("F:\\weibo_log");
		File mainOutputFolder = new File("H:\\weibo-生图");
		searchAndDownload(weiboLogFolerNames, searchKeys, mainWeiboLogFolder, mainOutputFolder);
	}

	private static void 下载部分明星图片() throws IOException {
		Set<String> searchKeys = new TreeSet<>(Set.of());
//		searchKeys.addAll(Set.of("王鸥", "唐艺昕", "张蓝心", "郭珍霓", "梁洁", "代斯"));
//		searchKeys.addAll(Set.of("就是阿朱啊", "阿朱", "阿珠"));
//		searchKeys.addAll(Set.of("李若嘉"));
//		searchKeys.addAll(Set.of("rachel cook", "Rachel Cook", "Rachel cook", "rachel Cook", "rachelcook", "RachelCook", "Rachelcook", "rachelCook", "rachelc00k"));
		searchKeys.addAll(Set.of("Caylee Cowan", "caylee cowan", "CayleeCowan", "cayleecowan", "Caylee-Cowan"));
//		searchKeys.addAll(Set.of("克拉拉"));
		Set<String> weiboLogFolerNames = Constants.明星图片().stream().map(entity -> entity.screen_name).collect(Collectors.toCollection(LinkedHashSet::new));

		File mainWeiboLogFolder = new File("F:\\weibo_log");
		File mainOutputFolder = new File("F:\\weibo3");
		searchAndDownload(weiboLogFolerNames, searchKeys, mainWeiboLogFolder, mainOutputFolder);
	}

	private static void searchAndDownload(Collection<String> weiboLogFolerNames, Collection<String> searchKeys, File mainWeiboLogFolder, File mainOutputFolder) throws IOException {
		for (String weiboLogFolderName : weiboLogFolerNames) {
			System.out.println("-->>\t" + weiboLogFolderName);
			File weiboLogFolder = new File(mainWeiboLogFolder, weiboLogFolderName);
			for (String searchKey : searchKeys) {
				File outputFolder = new File(new File(mainOutputFolder, weiboLogFolderName), searchKey.replace("*", ""));
//				File outputFolder = new File(mainOutputFolder, weiboLogFolderName);
//				File outputFolder = new File(mainOutputFolder, searchKey);

				start(weiboLogFolder, outputFolder, false, 2000, 1, 1, 2099, 1, 1, searchKey);
			}
		}
	}

	@SuppressWarnings("unused")
	private static void searchAndDownload(List<String> weiboLogFolerNames, Map<String, String> searchKeyOutputFolderMap, File mainWeiboLogFolder, File mainOutputFolder) throws IOException {
		for (String weiboLogFolderName : weiboLogFolerNames) {
			File weiboLogFolder = new File(mainWeiboLogFolder, weiboLogFolderName);
			for (Entry<String, String> entry : searchKeyOutputFolderMap.entrySet()) {
				String searchKey = entry.getKey();
				String outputFolderName = entry.getValue();
				File outputFolder = new File(mainOutputFolder, outputFolderName);

				start(weiboLogFolder, outputFolder, false, 2000, 1, 1, 2025, 1, 1, searchKey);
			}
		}
	}

	private static void 下载部分日本写真() throws IOException {
		Set<String> searchKeys = Constants.searchKeys2();

		List<String> weiboLogFolerNames = Constants.日本写真().stream().map(entity -> entity.screen_name).collect(Collectors.toList());
		;

		File mainWeiboLogFolder = new File("F:\\weibo_log");
		File mainOutputFolder = new File("H:\\weibo-日本写真");
		searchAndDownload(weiboLogFolerNames, searchKeys, mainWeiboLogFolder, mainOutputFolder);
	}

	private static void 下载() throws IOException {
//		start(new File("F:/weibo_log", "梦醒忒远"), new File("H:\\weibo", "梦醒忒远"), "童谣");
//		start(new File("F:\\weibo_log\\洋气YOUNGCHIC"), new File("F:\\weibo2\\洋气YOUNGCHIC"), "宋妍霏");
//		start(new File("F:\\weibo_log\\洋气YOUNGCHIC"), new File("F:\\weibo2\\洋气YOUNGCHIC"), "妍霏");
//		start(new File("F:\\weibo_log\\洋气YOUNGCHIC"), new File("F:\\weibo2\\洋气YOUNGCHIC"), "宋妍");
//		start(new File("F:\\weibo_log\\BellaHadidCN"), new File("H:\\weibo-欧美\\BellaHadidCN"));
//		start(new File("F:\\weibo_log\\KendallJCN"), new File("H:\\weibo-欧美\\KendallJCN"));
//		start(new File("F:/weibo_log", "安雅泰勒-乔伊"), new File("H:\\weibo", "安雅泰勒-乔伊"));
//		start(new File("F:/weibo_log", "安雅泰勒乔伊"), new File("H:\\weibo", "安雅泰勒乔伊"));
//		start(new File("F:/weibo_log", "SydneySweeneyCN"), new File("H:\\weibo", "SydneySweeneyCN"));
//		start(new File("F:/weibo_log", "MadisonBeerUpdates"), new File("H:\\weibo", "MadisonBeerUpdates"));
//		start(new File("F:/weibo_log", "凯瑟琳纽顿0208"), new File("H:\\weibo", "凯瑟琳纽顿0208"));
//		start(new File("F:/weibo_log", "MckennaGraceCN"), new File("H:\\weibo", "MckennaGraceCN"));
//		start(new File("F:/weibo_log", "Angel_AlessandraAmbrosio"), new File("H:\\weibo", "Angel_AlessandraAmbrosio"));
//		start(new File("F:/weibo_log", "Rachelcook1995"), new File("H:\\weibo", "Rachelcook1995"),"RachelCook");
//		start(new File("F:/weibo_log", "Rachelcook1995"), new File("H:\\weibo", "Rachelcook1995"),"rachelc00k");
//		start(new File("F:/weibo_log", "Rachelcook1995"), new File("H:\\weibo", "Rachelcook1995"),"rachel cook​​​");
//		start(new File("F:/weibo_log", "Rachelcook1995"), new File("H:\\weibo", "Rachelcook1995"),"Rachel Cook");
//		start(new File("F:/weibo_log", "rachelcook14"), new File("H:\\weibo", "rachelcook14"));
//		start(new File("F:/weibo_log", "MetFreckle"), new File("H:\\weibo", "MetFreckle"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "·AllForZendaya·"), new File("H:\\weibo", "·AllForZendaya·"), 2024, 12, 1, 2099, 1, 11);
//		
//		start(new File("F:/weibo_log", "Official_权恩妃"), new File("H:\\weibo", "Official_权恩妃"));
//		start(new File("F:/weibo_log", "伊藤舞雪_real"), new File("H:\\weibo", "伊藤舞雪_real"));
//		start(new File("F:/weibo_log", "EstherHeesch吧"), new File("H:\\weibo", "EstherHeesch吧"));
//		start(new File("F:/weibo_log", "希岛爱理Yua"), new File("H:\\weibo", "希岛爱理Yua"));
//		start(new File("F:/weibo_log", "八掛海_real"), new File("H:\\weibo", "八掛海_real"));
//		start(new File("F:/weibo_log", "瀧本雫葉_real"), new File("H:\\weibo", "瀧本雫葉_real"));
//		start(new File("F:/weibo_log", "七濑爱丽丝_real"), new File("H:\\weibo", "七濑爱丽丝_real"));
//		start(new File("F:/weibo_log", "小宵虎南_konancmore"), new File("H:\\weibo", "小宵虎南_konancmore"));
//		start(new File("F:/weibo_log", "河北彩伽-元河北彩花"), new File("H:\\weibo", "河北彩伽-元河北彩花"));
//		start(new File("F:/weibo_log", "河北彩伽"), new File("H:\\weibo", "河北彩伽"));
//		start(new File("F:/weibo_log", "松岡李那LinahM"), new File("H:\\weibo", "松岡李那LinahM"), 2024, 12, 1, 2099, 1, 11);

//		start(new File("F:\\weibo_log\\田丽"), new File("F:\\weibo2\\田丽"), 2000, 1, 1, 2014, 12, 31);
//		start(new File("F:\\weibo_log\\Nana谈莉娜"), new File("F:\\weibo2\\Nana谈莉娜"), false, 2000, 1, 1, 2015, 6, 18);
//		start(new File("F:/weibo_log", "凉森明里MiaMio"), new File("F:\\weibo5", "凉森明里MiaMio"), 2023, 10, 25, 2024, 04, 20);

//		start(new File("F:/weibo_log/那年今日丨吴宣仪"), new File("F:/weibo/那年今日丨吴宣仪"), 2000, 1, 1, 2019, 3, 14);
//		start(new File("F:\\weibo_log\\火箭少女101官博"), new File("F:\\weibo\\火箭少女101官博"), false, 2000, 1, 1, 2025, 1, 1, "吴宣仪");
//		start(new File("F:\\weibo_log\\高叶ChLoe"), new File("E:\\weibo2\\高叶ChLoe"), 2000, 1, 1, 2010, 8, 15);
//		start(new File("F:\\weibo_log\\金晨工作室"), new File("E:\\weibo2\\金晨工作室"), 2000, 1, 1, 2019, 3, 7);
//		start(new File("F:\\weibo_log\\古晨"), new File("F:\\weibo2\\古晨"), 2000, 1, 1, 2019, 5, 7);

//		start(new File("F:\\weibo_log\\嘉行传媒"), new File("H:\\weibo-祝绪丹\\嘉行传媒"), "祝绪丹");
//		start(new File("F:\\weibo_log\\嘉行传媒"), new File("H:\\weibo-代斯\\嘉行传媒"), "代斯");
//		start(new File("F:\\weibo_log\\嘉行传媒"), new File("H:\\weibo\\黄杨钿甜"), "黄杨钿甜");
//		start(new File("F:/weibo_log", "黄杨钿甜"), new File("H:\\weibo3", "黄杨钿甜"));
//		start(new File("F:/weibo_log", "邓恩熙"), new File("H:\\weibo2", "邓恩熙"));
//		start(new File("F:/weibo_log", "董璇"), new File("H:\\weibo1", "董璇"));
//		start(new File("F:/weibo_log", "董璇工作室"), new File("H:\\weibo1", "董璇工作室"));
//		start(new File("F:/weibo_log", "夏梦微博"), new File("H:\\weibo1", "夏梦微博"));
//		start(new File("F:/weibo_log", "夏梦工作室官微"), new File("H:\\weibo1", "夏梦工作室官微"));
//		start(new File("F:/weibo_log", "高露"), new File("H:\\weibo1", "高露"));
//		start(new File("F:/weibo_log", "赵樱子"), new File("H:\\weibo1", "赵樱子"));
//		start(new File("F:/weibo_log", "赵奕欢Chloe"), new File("H:\\weibo1", "赵奕欢Chloe"));
//		start(new File("F:/weibo_log", "李欣汝"), new File("H:\\weibo1", "李欣汝"));
//		start(new File("F:/weibo_log", "袁嘉敏Kaman"), new File("H:\\weibo1", "袁嘉敏Kaman"));
//		start(new File("F:/weibo_log", "周秀娜Chrissienana"), new File("H:\\weibo1", "周秀娜Chrissienana"));
//		start(new File("F:/weibo_log", "周韦彤Cica"), new File("H:\\weibo1", "周韦彤Cica"));
//		start(new File("F:/weibo_log", "演员王智"), new File("H:\\weibo1", "演员王智"));
//		start(new File("F:/weibo_log", "蒋勤勤"), new File("H:\\weibo1", "蒋勤勤"));
//		start(new File("F:/weibo_log", "艾尚真"), new File("H:\\weibo1", "艾尚真"));
//		start(new File("F:/weibo_log", "龙一一Adela"), new File("H:\\weibo", "龙一一Adela"));
//		start(new File("F:/weibo_log", "龙一一工作室"), new File("H:\\weibo", "龙一一工作室"));
//		start(new File("F:/weibo_log", "成果成果成狗"), new File("H:\\weibo", "成果成果成狗"));
//		start(new File("F:/weibo_log", "犬八工作室"), new File("H:\\weibo", "犬八工作室"));
//		start(new File("F:/weibo_log", "童瑶工作室"), new File("H:\\weibo", "童瑶工作室"));
//		start(new File("F:/weibo_log", "邓家佳工作室"), new File("H:\\weibo", "邓家佳工作室"));
//		start(new File("F:/weibo_log", "董璇工作室"), new File("H:\\weibo", "董璇工作室"));
//		start(new File("F:/weibo_log", "董璇粉丝团"), new File("H:\\weibo", "董璇粉丝团"));
//		start(new File("F:/weibo_log", "董璇"), new File("H:\\weibo", "董璇"));
//		start(new File("F:/weibo_log", "林妍柔"), new File("H:\\weibo", "林妍柔"));
//		start(new File("F:/weibo_log", "O0笨笨呀0O-梁洁"), new File("H:\\weibo", "O0笨笨呀0O-梁洁"));
//		start(new File("F:/weibo_log", "Vlinder·蝴蝶效应丨关晓彤"), new File("H:\\weibo", "Vlinder·蝴蝶效应丨关晓彤"));
//		start(new File("F:/weibo_log", "高海寧"), new File("H:\\weibo", "高海寧"));
//		start(new File("F:/weibo_log", "吉娜爱丽丝Gina"), new File("H:\\weibo", "吉娜爱丽丝Gina"));
//		start(new File("F:/weibo_log", "黄梦莹工作室"), new File("H:\\weibo", "黄梦莹工作室"));
//		start(new File("F:/weibo_log", "高圆圆"), new File("H:\\weibo", "高圆圆"));
//		start(new File("F:/weibo_log", "甘婷婷工作室"), new File("H:\\weibo", "甘婷婷工作室"));
//		start(new File("F:/weibo_log", "甘婷婷_TT"), new File("H:\\weibo", "甘婷婷_TT"));
//		start(new File("F:/weibo_log", "隋俊波"), new File("H:\\weibo", "隋俊波"));
//		start(new File("F:/weibo_log", "赵柯"), new File("H:\\weibo", "赵柯"));
//		start(new File("F:/weibo_log", "冯文娟"), new File("H:\\weibo", "冯文娟"));
//		start(new File("F:/weibo_log", "冯文娟工作室"), new File("H:\\weibo", "冯文娟工作室"));
//		start(new File("F:/weibo_log", "倪虹洁"), new File("H:\\weibo", "倪虹洁"));
//		
//		start(new File("F:/weibo_log", "hThT__"), new File("H:\\weibo", "hThT__"));
//		start(new File("F:/weibo_log", "汪小敏"), new File("H:\\weibo", "汪小敏"));
//		start(new File("F:/weibo_log", "Yakisa彭雅琦"), new File("H:\\weibo", "Yakisa彭雅琦"));
//		start(new File("F:/weibo_log", "王瑞子715"), new File("H:\\weibo", "王瑞子715"));
//		start(new File("F:/weibo_log", "月与玫瑰__娜然Naran"), new File("H:\\weibo", "月与玫瑰__娜然Naran"));
//		start(new File("F:/weibo_log", "AprilFox_Naran娜然"), new File("H:\\weibo", "AprilFox_Naran娜然"));
//		start(new File("F:/weibo_log", "娜然丨NaranDaily"), new File("H:\\weibo", "娜然丨NaranDaily"));
//		start(new File("F:/weibo_log", "娜然Naran工作室"), new File("H:\\weibo", "娜然Naran工作室"));
//		start(new File("F:/weibo_log", "娜然Naran"), new File("H:\\weibo", "娜然Naran"));
//		start(new File("F:/weibo_log", "张芷溪"), new File("H:\\weibo", "张芷溪"));
//		start(new File("F:/weibo_log", "李佳桐sep"), new File("H:\\weibo", "李佳桐sep"));
//		start(new File("F:/weibo_log", "李如儒"), new File("H:\\weibo", "李如儒"));
//		start(new File("F:/weibo_log", "王乐君"), new File("H:\\weibo", "王乐君"));
//		start(new File("F:/weibo_log", "金佳悦-"), new File("H:\\weibo", "金佳悦-"));
//		start(new File("F:/weibo_log", "丹琳"), new File("H:\\weibo", "丹琳"));
//		start(new File("F:/weibo_log", "刘美彤"), new File("H:\\weibo", "刘美彤"));
//		start(new File("F:/weibo_log", "刘美含"), new File("H:\\weibo", "刘美含"));
//		start(new File("F:/weibo_log", "孙嘉璐Ruby"), new File("H:\\weibo", "孙嘉璐Ruby"));
//		start(new File("F:/weibo_log", "包上恩"), new File("H:\\weibo", "包上恩"));
//		start(new File("F:/weibo_log", "孙雪宁ooo"), new File("H:\\weibo", "孙雪宁ooo"));
//		start(new File("F:/weibo_log", "YUNAN男男"), new File("H:\\weibo", "YUNAN男男"));
//		start(new File("F:/weibo_log", "老余那些事"), new File("H:\\weibo", "老余那些事"));
//		start(new File("F:/weibo_log", "张芷溪"), new File("H:\\weibo", "张芷溪"));
//		start(new File("F:/weibo_log", "不2不叫周淑怡"), new File("H:\\weibo", "不2不叫周淑怡"));
//		start(new File("F:/weibo_log", "刘芊螢_LQY"), new File("H:\\weibo", "刘芊螢_LQY"));
//		start(new File("F:/weibo_log", "曲尼次仁"), new File("H:\\weibo", "曲尼次仁"));
//		start(new File("F:/weibo_log", "蓝心ZoeZhang"), new File("H:\\weibo", "蓝心ZoeZhang"));
//		start(new File("F:/weibo_log", "吳千語全球官方後援會"), new File("H:\\weibo", "吳千語全球官方後援會"));
//		start(new File("F:/weibo_log", "青蛙公主爱凌"), new File("H:\\weibo", "青蛙公主爱凌"));
//		start(new File("F:/weibo_log", "蔡卓宜工作室"), new File("H:\\weibo", "蔡卓宜工作室"));
//		start(new File("F:/weibo_log", "是蔡卓宜"), new File("H:\\weibo", "是蔡卓宜"));
//		start(new File("F:/weibo_log", "毛晓彤"), new File("H:\\weibo", "毛晓彤"));
//		start(new File("F:/weibo_log", "李若嘉"), new File("H:\\weibo", "李若嘉"));
//		start(new File("F:/weibo_log", "李若嘉工作室"), new File("H:\\weibo", "李若嘉工作室"));
//		start(new File("F:/weibo_log", "火箭少女101官博"), new File("H:\\weibo", "火箭少女101官博"), "吴宣仪");
//		start(new File("F:/weibo_log", "青蛙公主爱凌"), new File("H:\\weibo", "青蛙公主爱凌"));
//		start(new File("F:/weibo_log", "张馨予工作室"), new File("H:\\weibo", "张馨予工作室"));
//		start(new File("F:/weibo_log", "唐嫣工作室"), new File("H:\\weibo", "唐嫣工作室"));
//		start(new File("F:/weibo_log", "洋气YOUNGCHIC"), new File("H:\\weibo", "洋气YOUNGCHIC"), "宋妍霏");
//		start(new File("F:/weibo_log", "沈羽洁er"), new File("H:\\weibo", "沈羽洁er"));
//		start(new File("F:/weibo_log", "于雯_"), new File("H:\\weibo", "于雯_"));
//		start(new File("F:/weibo_log", "Karena吳千語"), new File("H:\\weibo", "Karena吳千語"));
//		start(new File("F:/weibo_log", "徐璐工作室"), new File("H:\\weibo", "徐璐工作室"));
//		start(new File("F:/weibo_log", "姜珮瑶"), new File("H:\\weibo", "姜珮瑶"));
//		start(new File("F:/weibo_log", "无尽热恋丨1226x1109"), new File("H:\\weibo", "无尽热恋丨1226x1109"));
//		start(new File("F:/weibo_log", "潘霜霜Shayla"), new File("H:\\weibo", "潘霜霜Shayla"));
//		start(new File("F:/weibo_log", "李凯馨Eleanor工作室"), new File("H:\\weibo", "李凯馨Eleanor工作室"));
//		start(new File("F:/weibo_log", "Ming奚梦瑶"), new File("H:\\weibo", "Ming奚梦瑶"));
//		start(new File("F:/weibo_log", "BDD东"), new File("H:\\weibo", "BDD东"));
//		start(new File("F:/weibo_log", "康可人"), new File("H:\\weibo", "康可人"));
//		start(new File("F:/weibo_log", "陈乔恩"), new File("H:\\weibo", "陈乔恩"));
//		start(new File("F:/weibo_log", "林逸欣Shara"), new File("H:\\weibo", "林逸欣Shara"));
//		start(new File("F:/weibo_log", "一个阿茶-"), new File("H:\\weibo", "一个阿茶-"));
//		start(new File("F:/weibo_log", "李則慧"), new File("H:\\weibo", "李則慧"));
//		start(new File("F:/weibo_log", "汤梦佳"), new File("H:\\weibo", "汤梦佳"));
//		start(new File("F:/weibo_log", "董维嘉"), new File("H:\\weibo", "董维嘉"));
//		start(new File("F:/weibo_log", "董维嘉工作室"), new File("H:\\weibo", "董维嘉工作室"));
//		start(new File("F:/weibo_log", "李小冉工作室"), new File("H:\\weibo", "李小冉工作室"));
//		start(new File("F:/weibo_log", "朱珠工作室官方微博"), new File("H:\\weibo", "朱珠工作室官方微博"));
//		start(new File("F:/weibo_log", "朱珠ZhuZhu"), new File("H:\\weibo", "朱珠ZhuZhu"));
//		start(new File("F:/weibo_log", "乔欣Bridgette"), new File("H:\\weibo", "乔欣Bridgette"));
//		start(new File("F:/weibo_log", "毛林林NIKITA"), new File("H:\\weibo", "毛林林NIKITA"));
//		start(new File("F:/weibo_log", "徐小舒_"), new File("H:\\weibo", "徐小舒_"));
//		start(new File("F:/weibo_log", "彭小苒工作室"), new File("H:\\weibo", "彭小苒工作室"));
//		start(new File("F:/weibo_log", "彭小苒"), new File("H:\\weibo", "彭小苒"));
//		start(new File("F:/weibo_log", "关慧卿hq"), new File("H:\\weibo", "关慧卿hq"));
//		start(new File("F:/weibo_log", "吴静一就是我"), new File("H:\\weibo", "吴静一就是我"));
//		start(new File("F:/weibo_log", "杨净如"), new File("H:\\weibo", "杨净如"));
//		start(new File("F:/weibo_log", "徐百慧V"), new File("H:\\weibo", "徐百慧V"));
//		start(new File("F:/weibo_log", "陈昊宇Amy"), new File("H:\\weibo", "陈昊宇Amy"));
//		start(new File("F:/weibo_log", "杨采钰工作室"), new File("H:\\weibo", "杨采钰工作室"));
//		start(new File("F:/weibo_log", "袁冰妍"), new File("H:\\weibo", "袁冰妍"));
//		start(new File("F:/weibo_log", "刘令姿__"), new File("H:\\weibo", "刘令姿__"));
//		start(new File("F:/weibo_log", "刘令姿的彤话书"), new File("H:\\weibo", "刘令姿的彤话书"));
//		start(new File("F:/weibo_log", "周扬"), new File("H:\\weibo", "周扬"));
//		start(new File("F:/weibo_log", "刘洋1105"), new File("H:\\weibo", "刘洋1105"));
//		start(new File("F:/weibo_log", "劉心悠Annie"), new File("H:\\weibo", "劉心悠Annie"));
//		start(new File("F:/weibo_log", "刘雨欣yoyoliu"), new File("H:\\weibo", "刘雨欣yoyoliu"));
//		start(new File("F:/weibo_log", "许晴随行笔记"), new File("H:\\weibo", "许晴随行笔记"));
//		start(new File("F:/weibo_log", "Summer许晴工作室"), new File("H:\\weibo", "Summer许晴工作室"));
//		start(new File("F:/weibo_log", "郭珍霓"), new File("H:\\weibo", "郭珍霓"));
//		start(new File("F:/weibo_log", "演员牟星"), new File("H:\\weibo", "演员牟星"));
//		start(new File("F:/weibo_log", "蓝心妍工作室"), new File("H:\\weibo", "蓝心妍工作室"));
//		start(new File("F:/weibo_log", "蓝心妍"), new File("H:\\weibo", "蓝心妍"));
//		start(new File("F:/weibo_log", "小艾同学下课了吗"), new File("H:\\weibo", "小艾同学下课了吗"));
//		start(new File("F:/weibo_log", "_黃芯靈"), new File("H:\\weibo", "_黃芯靈"));
//		start(new File("F:/weibo_log", "大鹅鹅Ran"), new File("H:\\weibo", "大鹅鹅Ran"));
//		start(new File("F:/weibo_log", "徐艺真的微博"), new File("H:\\weibo", "徐艺真的微博"));
//		start(new File("F:/weibo_log", "河北彩伽2"), new File("H:\\weibo", "河北彩伽"));
//		start(new File("F:/weibo_log", "钟晨瑶"), new File("H:\\weibo", "钟晨瑶"));
//		start(new File("F:/weibo_log", "柴蔚"), new File("H:\\weibo", "柴蔚"));
//		start(new File("F:/weibo_log", "Gen1es_欧阳娣娣"), new File("H:\\weibo", "Gen1es_欧阳娣娣"));
//		start(new File("F:/weibo_log", "刘承羽Natasha"), new File("H:\\weibo", "刘承羽Natasha"));
//		start(new File("F:/weibo_log", "明星生图严选"), new File("H:\\weibo", "明星生图严选"));
//		start(new File("F:/weibo_log", "李庚希Teresa"), new File("H:\\weibo", "李庚希Teresa"));
//		start(new File("F:/weibo_log", "刘芸"), new File("H:\\weibo", "刘芸"));
		start(new File("F:/weibo_log", "刘芸工作室官方微博"), new File("H:\\weibo", "刘芸工作室官方微博"));
	}
}
