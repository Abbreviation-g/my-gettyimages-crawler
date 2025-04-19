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

//		下载半年可见();
//		下载特别关注();
//		下载部分生图();
		下载网红();

//		下载欧阳娜娜();
//		下载宋妍霏();
//		下载王紫璇();
//		下载赵露思();
//		下载张天爱();
//		下载王鸥();
//		下载娜扎();
//		下载林允();
//		下载韩雪();
//		下载关晓彤();
//		下载吴宣仪();
//		下载热巴();
//		下载宋祖儿();
//		下载程潇();

		下载王玉雯();
		下载王秀竹();
		下载吴优();
		下载王楚然();
		下载赵今麦();
		下载蒋依依();
		下载张婧仪();
		下载张予曦();
		下载陈都灵();
		下载胡连馨();
		下载许佳琪();
		下载杨幂();
		下载孟佳();
		下载秦岚();
		下载范冰冰();
		下载蔡文静();
		下载白鹿();
		下载倪妮();
		下载李一桐();
		下载王鹤润();
		下载周洁琼();
		下载孟子义();
		下载李沁();
		下载江疏影();

//		下载明星1();
//		下载明星2();
//		下载明星3();
//
//		下载部分日本写真();
//		下载日本演员();
//		下载();

//		下载生图();
//		下载部分明星图片();
//		下载梦醒忒远();

//		下载张嘉倪();
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

	private static void 下载半年可见() throws IOException {
		下载(Constants.半年可见(), "H:/weibo-" + "半年可见");
	}

	private static void 下载特别关注() throws IOException {
		下载(Constants.特别关注(), "H:/weibo-" + "特别关注");
	}

	private static void 下载江疏影() throws IOException {
		下载(Constants.江疏影(), "H:/weibo-" + "江疏影");
	}
	private static void 下载李沁() throws IOException {
		下载(Constants.李沁(), "H:/weibo-" + "李沁");
	}
	private static void 下载周洁琼() throws IOException {
		下载(Constants.周洁琼(), "H:/weibo-" + "周洁琼");
	}
	private static void 下载孟子义() throws IOException {
		下载(Constants.孟子义(), "H:/weibo-" + "孟子义");
	}
	private static void 下载王鹤润() throws IOException {
		下载(Constants.王鹤润(), "H:/weibo-" + "王鹤润");
	}
	private static void 下载黛薇卡() throws IOException {
		下载(Constants.黛薇卡(), "H:/weibo-" + "黛薇卡");
	}
	private static void 下载李一桐() throws IOException {
		下载(Constants.李一桐(), "H:/weibo-" + "李一桐");
	}
	private static void 下载倪妮() throws IOException {
		下载(Constants.倪妮(), "H:/weibo-" + "倪妮");
	}

	private static void 下载白鹿() throws IOException {
		下载(Constants.白鹿(), "H:/weibo-" + "白鹿");
	}

	private static void 下载蔡文静() throws IOException {
		下载(Constants.蔡文静(), "H:/weibo-" + "蔡文静");
	}

	private static void 下载许佳琪() throws IOException {
		下载(Constants.许佳琪(), "H:/weibo-" + "许佳琪");
	}

	private static void 下载日本演员() throws IOException {
		下载(Constants.日本演员(), "H:/weibo-" + "日本演员");
//		for (Constants.IDNameEntity entity : Constants.日本演员()) {
//			start(new File("F:/weibo_log", entity.screen_name), new File("H:/weibo", entity.screen_name), 2000, 1, 1, 2011, 5, 4);
//			start(new File("F:/weibo_log", entity.screen_name), new File("H:/weibo", entity.screen_name), 2023, 12, 1, 2099, 5, 4);
//		}
	}

	private static void 下载欧美() throws IOException {
//		下载(Constants.欧美());
		for (Constants.IDNameEntity entity : Constants.欧美()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("H:/weibo", entity.screen_name), 2000, 1, 1, 2011, 5, 4);
			start(new File("F:/weibo_log", entity.screen_name), new File("H:/weibo", entity.screen_name), 2024, 9, 1, 2099, 5, 4);
		}
	}

	private static void 下载网红() throws IOException {
		下载(Constants.网红(), "H:/weibo-网红");
	}

	private static void 下载蒋依依() throws IOException {
		下载(Constants.蒋依依(), "H:/weibo-" + "蒋依依");
	}

	private static void 下载张婧仪() throws IOException {
		下载(Constants.张婧仪(), "H:/weibo-" + "张婧仪");
	}

	private static void 下载张嘉倪() throws IOException {
		下载(Constants.张嘉倪(), "H:/weibo-" + "张嘉倪");
	}

	private static void 下载王楚然() throws IOException {
		下载(Constants.王楚然(), "H:/weibo-" + "王楚然");
	}

	private static void 下载吴优() throws IOException {
		下载(Constants.吴优(), "H:/weibo-" + "吴优");
	}

	private static void 下载王秀竹() throws IOException {
		下载(Constants.王秀竹(), "H:/weibo-" + "王秀竹");
	}

	private static void 下载热巴() throws IOException {
		下载(Constants.热巴(), "H:/weibo-" + "热巴");
	}

	private static void 下载王玉雯() throws IOException {
		下载(Constants.王玉雯(), "H:/weibo-" + "王玉雯");
	}

	private static void 下载王紫璇() throws IOException {
		下载(Constants.王紫璇(), "H:/weibo-" + "王紫璇");
	}

	private static void 下载程潇() throws IOException {
		下载(Constants.程潇(), "H:/weibo-" + "程潇");
	}

	private static void 下载赵露思() throws IOException {
		下载(Constants.赵露思(), "H:/weibo-" + "赵露思");
	}

	private static void 下载王鸥() throws IOException {
		下载(Constants.王鸥(), "H:/weibo-" + "王鸥");
	}

	private static void 下载欧阳娜娜() throws IOException {
		下载(Constants.欧阳娜娜(), "H:/weibo-" + "欧阳娜娜");
	}

	private static void 下载林允() throws IOException {
		下载(Constants.林允(), "H:/weibo-" + "林允");
	}

	private static void 下载张天爱() throws IOException {
		下载(Constants.张天爱(), "H:/weibo-" + "张天爱");
	}

	private static void 下载关晓彤() throws IOException {
		下载(Constants.关晓彤(), "H:/weibo-" + "关晓彤");
	}

	private static void 下载娜扎() throws IOException {
		下载(Constants.娜扎(), "H:/weibo-" + "娜扎");
	}

	private static void 下载胡连馨() throws IOException {
		下载(Constants.胡连馨(), "H:/weibo-" + "胡连馨");
	}

	private static void 下载韩雪() throws IOException {
		下载(Constants.韩雪(), "H:/weibo-" + "韩雪");
	}

	private static void 下载赵今麦() throws IOException {
		下载(Constants.赵今麦(), "H:/weibo-" + "赵今麦");
	}

	private static void 下载宋祖儿() throws IOException {
		下载(Constants.宋祖儿(), "H:/weibo-" + "宋祖儿");
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

	private static void 下载(Collection<IDNameEntity> entities) throws IOException {
		下载(entities, "H:/weibo");
	}

	private static void 下载吴宣仪() throws IOException {
		下载(Constants.吴宣仪(), "H:/weibo-" + "吴宣仪");
	}

	private static void 下载宋妍霏() throws IOException {
		下载(Constants.宋妍霏(), "H:/weibo-" + "宋妍霏");
	}

	private static void 下载张予曦() throws IOException {
		下载(Constants.张予曦(), "H:/weibo-" + "张予曦");
	}

	private static void 下载范冰冰() throws IOException {
		下载(Constants.范冰冰(), "H:/weibo-" + "范冰冰");
	}

	private static void 下载秦岚() throws IOException {
		下载(Constants.秦岚(), "H:/weibo-" + "秦岚");
	}

	private static void 下载孟佳() throws IOException {
		下载(Constants.孟佳(), "H:/weibo-" + "孟佳");
	}

	private static void 下载杨幂() throws IOException {
		下载(Constants.杨幂(), "H:/weibo-" + "杨幂");
	}

	private static void 下载陈都灵() throws IOException {
		下载(Constants.陈都灵(), "H:/weibo-" + "陈都灵");
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
//		start(new File("F:\\weibo_log\\洋气YOUNGCHIC"), new File("F:\\weibo2\\洋气YOUNGCHIC"), "宋妍霏");
//		start(new File("F:\\weibo_log\\洋气YOUNGCHIC"), new File("F:\\weibo2\\洋气YOUNGCHIC"), "妍霏");
//		start(new File("F:\\weibo_log\\洋气YOUNGCHIC"), new File("F:\\weibo2\\洋气YOUNGCHIC"), "宋妍");
//		start(new File("F:\\weibo_log\\BellaHadidCN"), new File("F:\\weibo2\\BellaHadidCN"), 2024, 6, 1, 2099, 12, 31);
//		start(new File("F:\\weibo_log\\MetFreckle"), new File("F:\\weibo2\\MetFreckle"), 2000, 1, 1, 2018, 1, 1);
//		start(new File("F:\\weibo_log\\吉尼Gini"), new File("F:\\weibo2\\吉尼Gini"),2000,1,1,2019,3,9);
//		start(new File("F:\\weibo_log\\田丽"), new File("F:\\weibo2\\田丽"), 2000, 1, 1, 2014, 12, 31);
//		start(new File("F:\\weibo_log", "明星女神时光机"), new File("F:\\weibo2", "明星女神时光机"), false, 2020, 1, 1, 2020, 12, 31);
//		start(new File("F:\\weibo_log\\Nana谈莉娜"), new File("F:\\weibo2\\Nana谈莉娜"), false, 2000, 1, 1, 2015, 6, 18);
//		start(new File("F:/weibo_log", "凉森明里MiaMio"), new File("F:\\weibo5", "凉森明里MiaMio"), 2023, 10, 25, 2024, 04, 20);

//		start(new File("F:/weibo_log/那年今日丨吴宣仪"), new File("F:/weibo/那年今日丨吴宣仪"), 2000, 1, 1, 2019, 3, 14);
//		start(new File("F:\\weibo_log\\火箭少女101官博"), new File("F:\\weibo\\火箭少女101官博"), false, 2000, 1, 1, 2025, 1, 1, "吴宣仪");
//		start(new File("F:\\weibo_log\\高叶ChLoe"), new File("E:\\weibo2\\高叶ChLoe"), 2000, 1, 1, 2010, 8, 15);
//		start(new File("F:\\weibo_log\\金晨工作室"), new File("E:\\weibo2\\金晨工作室"), 2000, 1, 1, 2019, 3, 7);
//		start(new File("F:\\weibo_log\\古晨"), new File("F:\\weibo2\\古晨"), 2000, 1, 1, 2019, 5, 7);

//		start(new File("F:\\weibo_log\\嘉行传媒"), new File("F:\\weibo2\\嘉行传媒\\黄梦莹"), "黄梦莹");
//		start(new File("F:\\weibo_log\\嘉行传媒"), new File("F:\\weibo2\\嘉行传媒\\李溪芮"), "李溪芮");

//		start(new File("F:\\weibo_log\\嘉行传媒"), new File("H:\\weibo\\嘉行传媒\\祝绪丹"), "祝绪丹");
//		start(new File("F:\\weibo_log\\嘉行传媒"), new File("H:\\weibo\\嘉行传媒\\代斯"), "代斯");
//		start(new File("F:/weibo_log", "陈梦儿-myYY"), new File("F:\\weibo", "陈梦儿-myYY"));
//		start(new File("F:/weibo_log", "童瑶工作室"), new File("H:\\weibo", "童瑶工作室"));
//		start(new File("F:/weibo_log", "蔡文静"), new File("H:\\weibo", "蔡文静"));
//		start(new File("F:/weibo_log", "蔡文静工作室"), new File("H:\\weibo", "蔡文静工作室"));
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
//		start(new File("F:/weibo_log", "孙芮工作室"), new File("H:\\weibo", "孙芮工作室"));
//		start(new File("F:/weibo_log", "冯文娟"), new File("H:\\weibo", "冯文娟"));
//		start(new File("F:/weibo_log", "冯文娟工作室"), new File("H:\\weibo", "冯文娟工作室"));
//		start(new File("F:/weibo_log", "倪虹洁"), new File("H:\\weibo", "倪虹洁"));
//		start(new File("F:/weibo_log", "伊藤舞雪_real"), new File("H:\\weibo", "伊藤舞雪_real"));
//		start(new File("F:/weibo_log", "安雅泰勒-乔伊"), new File("H:\\weibo", "安雅泰勒-乔伊"));
//		start(new File("F:/weibo_log", "EstherHeesch吧"), new File("H:\\weibo", "EstherHeesch吧"));
//		start(new File("F:/weibo_log", "希岛爱理Yua"), new File("H:\\weibo", "希岛爱理Yua"));
//		start(new File("F:/weibo_log", "八掛海_real"), new File("H:\\weibo", "八掛海_real"));

//		start(new File("F:/weibo_log", "瀧本雫葉_real"), new File("H:\\weibo", "瀧本雫葉_real"));
//		start(new File("F:/weibo_log", "七濑爱丽丝_real"), new File("H:\\weibo", "七濑爱丽丝_real"));
//		start(new File("F:/weibo_log", "小宵虎南_konancmore"), new File("H:\\weibo", "小宵虎南_konancmore"));
//		start(new File("F:/weibo_log", "hThT__"), new File("H:\\weibo", "hThT__"));
//		start(new File("F:/weibo_log", "汪小敏"), new File("H:\\weibo", "汪小敏"));
//		start(new File("F:/weibo_log", "倪妮V"), new File("H:\\weibo", "倪妮V"));
//		start(new File("F:/weibo_log", "倪妮工作室"), new File("H:\\weibo", "倪妮工作室"));
//		start(new File("F:/weibo_log", "Penicillin·倪妮"), new File("H:\\weibo", "Penicillin·倪妮"));
//		start(new File("F:/weibo_log", "北纬26度想Ni·倪妮"), new File("H:\\weibo", "北纬26度想Ni·倪妮"));
//		start(new File("F:/weibo_log", "Yakisa彭雅琦"), new File("H:\\weibo", "Yakisa彭雅琦"));
//		start(new File("F:/weibo_log", "KleinBlue·倪妮"), new File("H:\\weibo", "KleinBlue·倪妮"));
//		start(new File("F:/weibo_log", "六金yE"), new File("H:\\weibo", "六金yE"));
//		start(new File("F:/weibo_log", "是你的程儿"), new File("H:\\weibo", "是你的程儿"));
//		start(new File("F:/weibo_log", "小白金金"), new File("H:\\weibo", "小白金金"));
//		start(new File("F:/weibo_log", "王瑞子715"), new File("H:\\weibo", "王瑞子715"));
//		start(new File("F:/weibo_log", "yesyanbaby"), new File("H:\\weibo", "yesyanbaby"));
//		start(new File("F:/weibo_log", "河北彩伽-元河北彩花"), new File("H:\\weibo", "河北彩伽-元河北彩花"));
//		start(new File("F:/weibo_log", "河北彩伽"), new File("H:\\weibo", "河北彩伽"));
//		start(new File("F:/weibo_log", "月与玫瑰__娜然Naran"), new File("H:\\weibo", "月与玫瑰__娜然Naran"));
//		start(new File("F:/weibo_log", "AprilFox_Naran娜然"), new File("H:\\weibo", "AprilFox_Naran娜然"));
//		start(new File("F:/weibo_log", "娜然丨NaranDaily"), new File("H:\\weibo", "娜然丨NaranDaily"));
//		start(new File("F:/weibo_log", "娜然Naran工作室"), new File("H:\\weibo", "娜然Naran工作室"));
//		start(new File("F:/weibo_log", "娜然Naran"), new File("H:\\weibo", "娜然Naran"));
//		start(new File("F:/weibo_log", "林允Jelly"), new File("H:\\weibo", "林允Jelly"));
//		start(new File("F:/weibo_log", "热依扎"), new File("H:\\weibo", "热依扎"));
//		start(new File("F:/weibo_log", "张芷溪"), new File("H:\\weibo", "张芷溪"));
//		start(new File("F:/weibo_log", "王子文工作室微博"), new File("H:\\weibo", "王子文工作室微博"));
//		start(new File("F:/weibo_log", "张萌"), new File("H:\\weibo", "张萌"));
//		start(new File("F:/weibo_log", "李佳桐sep"), new File("H:\\weibo", "李佳桐sep"));
//		start(new File("F:/weibo_log", "李依晓"), new File("H:\\weibo", "李依晓"));
//		start(new File("F:/weibo_log", "顾璇"), new File("H:\\weibo", "顾璇"));
//		start(new File("F:/weibo_log", "食梦鲨"), new File("H:\\weibo", "食梦鲨"));
//		start(new File("F:/weibo_log", "李如儒"), new File("H:\\weibo", "李如儒"));
//		start(new File("F:/weibo_log", "王乐君"), new File("H:\\weibo", "王乐君"));
//		start(new File("F:/weibo_log", "顾璇"), new File("H:\\weibo", "顾璇"));
//		start(new File("F:/weibo_log", "李依晓"), new File("H:\\weibo", "李依晓"));
//		start(new File("F:/weibo_log", "金佳悦-"), new File("H:\\weibo", "金佳悦-"));
//		start(new File("F:/weibo_log", "唐艺昕工作室"), new File("H:\\weibo", "唐艺昕工作室"));
//		start(new File("F:/weibo_log", "张嘉倪"), new File("H:\\weibo", "张嘉倪"));
//		start(new File("F:/weibo_log", "丹琳"), new File("H:\\weibo", "丹琳"));
//		start(new File("F:/weibo_log", "松岡李那LinahM"), new File("H:\\weibo", "松岡李那LinahM"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "刘美彤"), new File("H:\\weibo", "刘美彤"));
//		start(new File("F:/weibo_log", "刘美含"), new File("H:\\weibo", "刘美含"));
//		start(new File("F:/weibo_log", "孙嘉璐Ruby"), new File("H:\\weibo", "孙嘉璐Ruby"));
//		start(new File("F:/weibo_log", "包上恩"), new File("H:\\weibo", "包上恩"));
//		start(new File("F:/weibo_log", "孙雪宁ooo"), new File("H:\\weibo", "孙雪宁ooo"));
//		start(new File("F:/weibo_log", "YUNAN男男"), new File("H:\\weibo", "YUNAN男男"));
//		start(new File("F:/weibo_log", "老余那些事"), new File("H:\\weibo", "老余那些事"));
//		start(new File("F:/weibo_log", "蓝盈莹工作室"), new File("H:\\weibo", "蓝盈莹工作室"));
//		start(new File("F:/weibo_log", "韩雪"), new File("H:\\weibo", "韩雪"));
//		start(new File("F:/weibo_log", "张芷溪"), new File("H:\\weibo", "张芷溪"));
//		start(new File("F:/weibo_log", "不2不叫周淑怡"), new File("H:\\weibo", "不2不叫周淑怡"));
//		start(new File("F:/weibo_log", "刘芊螢_LQY"), new File("H:\\weibo", "刘芊螢_LQY"));
//		start(new File("F:/weibo_log", "曲尼次仁"), new File("H:\\weibo", "曲尼次仁"));
//		start(new File("F:/weibo_log", "蓝心ZoeZhang"), new File("H:\\weibo", "蓝心ZoeZhang"));
//		start(new File("F:/weibo_log", "胡连馨儿"), new File("H:\\weibo", "胡连馨儿"));
//		start(new File("F:/weibo_log", "胡连馨studio"), new File("H:\\weibo", "胡连馨studio"));
//		start(new File("F:/weibo_log", "郭四火-"), new File("H:\\weibo", "郭四火-"));
//		start(new File("F:/weibo_log", "吳千語全球官方後援會"), new File("H:\\weibo", "吳千語全球官方後援會"));
//		start(new File("F:/weibo_log", "青蛙公主爱凌"), new File("H:\\weibo", "青蛙公主爱凌"));
//		start(new File("F:/weibo_log", "许佳琪_OFFICIAL"), new File("H:\\weibo", "许佳琪_OFFICIAL"));
//		start(new File("F:/weibo_log", "许佳琪kiki"), new File("H:\\weibo", "许佳琪kiki"));
//		start(new File("F:/weibo_log", "蔡卓宜工作室"), new File("H:\\weibo", "蔡卓宜工作室"));
//		start(new File("F:/weibo_log", "是蔡卓宜"), new File("H:\\weibo", "是蔡卓宜"));
//		start(new File("F:/weibo_log", "孟佳工作室"), new File("H:\\weibo", "孟佳工作室"));
//		start(new File("F:/weibo_log", "江疏影"), new File("H:\\weibo", "江疏影"));
//		start(new File("F:/weibo_log", "毛晓彤"), new File("H:\\weibo", "毛晓彤"));
//		start(new File("F:/weibo_log", "李依晓"), new File("H:\\weibo", "李依晓"));
//		start(new File("F:/weibo_log", "孟子义"), new File("H:\\weibo", "孟子义"));
//		start(new File("F:/weibo_log", "李若嘉工作室"), new File("H:\\weibo", "李若嘉工作室"));
//		start(new File("F:/weibo_log", "火箭少女101官博"), new File("H:\\weibo", "火箭少女101官博"), "吴宣仪");
//		start(new File("F:/weibo_log", "青蛙公主爱凌"), new File("H:\\weibo", "青蛙公主爱凌"));
//		start(new File("F:/weibo_log", "傅嘉莉KellyFu"), new File("H:\\weibo", "傅嘉莉KellyFu"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "张馨予工作室"), new File("H:\\weibo", "张馨予工作室"));
//		start(new File("F:/weibo_log", "李若嘉"), new File("H:\\weibo", "李若嘉"));
//		start(new File("F:/weibo_log", "星图驿站"), new File("H:\\weibo", "星图驿站"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "星素鉴赏"), new File("H:\\weibo", "星素鉴赏"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "唐嫣工作室"), new File("H:\\weibo", "唐嫣工作室"));
//		start(new File("F:/weibo_log", "歐陽娜娜Nana"), new File("H:\\weibo", "歐陽娜娜Nana"));
//		start(new File("F:/weibo_log", "歐陽娜娜Nana工作室"), new File("H:\\weibo", "歐陽娜娜Nana工作室"));
//		start(new File("F:/weibo_log", "洋气YOUNGCHIC"), new File("H:\\weibo", "洋气YOUNGCHIC"), "宋妍霏");
//		start(new File("F:/weibo_log", "张婧仪"), new File("H:\\weibo", "张婧仪"));
//		start(new File("F:/weibo_log", "张婧仪工作室"), new File("H:\\weibo", "张婧仪工作室"));
//		start(new File("F:/weibo_log", "沈羽洁er"), new File("H:\\weibo", "沈羽洁er"));
//		start(new File("F:/weibo_log", "于雯_"), new File("H:\\weibo", "于雯_"));
//		start(new File("F:/weibo_log", "Karena吳千語"), new File("H:\\weibo", "Karena吳千語"));
//		start(new File("F:/weibo_log", "徐璐工作室"), new File("H:\\weibo", "徐璐工作室"));
//		start(new File("F:/weibo_log", "蒋梦婕工作室"), new File("H:\\weibo", "蒋梦婕工作室"));
//		start(new File("F:/weibo_log", "张馨予"), new File("H:\\weibo", "张馨予"));
//		start(new File("F:/weibo_log", "江疏影"), new File("H:\\weibo", "江疏影"));
//		start(new File("F:/weibo_log", "姜珮瑶"), new File("H:\\weibo", "姜珮瑶"), 2023, 1, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "蒋梦婕"), new File("H:\\weibo", "蒋梦婕"));
//		start(new File("F:/weibo_log", "王子文Ava"), new File("H:\\weibo", "王子文Ava"));
//		start(new File("F:/weibo_log", "无尽热恋丨1226x1109"), new File("H:\\weibo", "无尽热恋丨1226x1109"));
//		start(new File("F:/weibo_log", "歐陽娜娜Nana"), new File("H:\\weibo", "歐陽娜娜Nana"));
//		start(new File("F:/weibo_log", "潘霜霜Shayla"), new File("H:\\weibo", "潘霜霜Shayla"));
//		start(new File("F:/weibo_log", "李凯馨Eleanor工作室"), new File("H:\\weibo", "李凯馨Eleanor工作室"));
//		start(new File("F:/weibo_log", "Ming奚梦瑶"), new File("H:\\weibo", "Ming奚梦瑶"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "赵今麦angel"), new File("H:\\weibo", "赵今麦angel"));
//		start(new File("F:/weibo_log", "食梦鲨"), new File("H:\\weibo", "食梦鲨"));
//		start(new File("F:/weibo_log", "徐冬冬"), new File("H:\\weibo", "徐冬冬"));
//		start(new File("F:/weibo_log", "李則慧"), new File("H:\\weibo", "李則慧"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "BDD东"), new File("H:\\weibo", "BDD东"));
//		start(new File("F:/weibo_log", "王紫璇CiCi"), new File("H:\\weibo", "王紫璇CiCi"));
//		start(new File("F:/weibo_log", "林允的小号r"), new File("H:\\weibo", "林允的小号r"));
//		start(new File("F:/weibo_log", "康可人"), new File("H:\\weibo", "康可人"));
//		start(new File("F:/weibo_log", "陈乔恩"), new File("H:\\weibo", "陈乔恩"));
//		start(new File("F:/weibo_log", "吉尼Gini"), new File("H:\\weibo", "吉尼Gini"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "汤梦佳"), new File("H:\\weibo", "汤梦佳"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "明星生图现场"), new File("H:\\weibo", "明星生图现场"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "Fyuan方圆"), new File("H:\\weibo", "Fyuan方圆"));
//		start(new File("F:/weibo_log", "林逸欣Shara"), new File("H:\\weibo", "林逸欣Shara"));
//		start(new File("F:/weibo_log", "刘湘_11"), new File("H:\\weibo", "刘湘_11"));
//		start(new File("F:/weibo_log", "钟楚曦工作室"), new File("H:\\weibo", "钟楚曦工作室"));
//		start(new File("F:/weibo_log", "钟楚曦"), new File("H:\\weibo", "钟楚曦"));
//		start(new File("F:/weibo_log", "一个阿茶-"), new File("H:\\weibo", "一个阿茶-"));
//		start(new File("F:/weibo_log", "周也资讯站"), new File("H:\\weibo", "周也资讯站"));
//		start(new File("F:/weibo_log", "MetFreckle"), new File("H:\\weibo", "MetFreckle"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "·AllForZendaya·"), new File("H:\\weibo", "·AllForZendaya·"), 2024, 12, 1, 2099, 1, 11);
//		start(new File("F:/weibo_log", "SydneySweeneyCN"), new File("H:\\weibo", "SydneySweeneyCN"));
//		start(new File("F:/weibo_log", "MadisonBeerUpdates"), new File("H:\\weibo", "MadisonBeerUpdates"));
//		start(new File("F:/weibo_log", "凯瑟琳纽顿0208"), new File("H:\\weibo", "凯瑟琳纽顿0208"));
//		start(new File("F:/weibo_log", "MckennaGraceCN"), new File("H:\\weibo", "MckennaGraceCN"));
//		start(new File("F:/weibo_log", "Angel_AlessandraAmbrosio"), new File("H:\\weibo", "Angel_AlessandraAmbrosio"));
//		start(new File("F:/weibo_log", "安雅泰勒乔伊"), new File("H:\\weibo", "安雅泰勒乔伊"));
//		start(new File("F:/weibo_log", "安雅泰勒-乔伊"), new File("H:\\weibo", "安雅泰勒-乔伊"));
//		start(new File("F:/weibo_log", "BellaHadidCN"), new File("H:\\weibo", "BellaHadidCN"));
//		start(new File("F:/weibo_log", "Rachelcook1995"), new File("H:\\weibo", "Rachelcook1995"),"RachelCook");
//		start(new File("F:/weibo_log", "Rachelcook1995"), new File("H:\\weibo", "Rachelcook1995"),"rachelc00k");
//		start(new File("F:/weibo_log", "Rachelcook1995"), new File("H:\\weibo", "Rachelcook1995"),"rachel cook​​​");
//		start(new File("F:/weibo_log", "Rachelcook1995"), new File("H:\\weibo", "Rachelcook1995"),"Rachel Cook");
//		start(new File("F:/weibo_log", "rachelcook14"), new File("H:\\weibo", "rachelcook14"));
	}
}
