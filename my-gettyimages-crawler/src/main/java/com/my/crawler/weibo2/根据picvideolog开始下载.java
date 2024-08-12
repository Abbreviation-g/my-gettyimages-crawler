package com.my.crawler.weibo2;

import static com.my.crawler.weibo2.WeiboImageDownloaderExt.start;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
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
		下载半年可见();
		下载特别关注();
//		下载部分生图();
//		下载网红();

//		下载欧阳娜娜();
//		下载王紫璇();
//		下载王鸥();
//		下载娜扎();
//		下载韩雪();
//		下载林允();
//		下载宋妍霏();
//		下载吴宣仪();
//		下载关晓彤();
//		下载宋祖儿();
//		下载张天爱();
//		下载王玉雯();
//		下载程潇();
//		下载王秀竹();
//		下载吴优();
//		下载赵今麦();
//		下载王楚然();
//		下载热巴();
//		下载蒋依依();
//		下载张婧仪();
//		下载张予曦();
//		下载陈都灵();

//		下载生图();
//		下载部分日本写真();
//		下载部分明星图片();
//		下载梦醒忒远();

//		下载张嘉倪();
//		下载();
	}

	private static void 下载半年可见() throws IOException {
		for (Constants.IDNameEntity entity : Constants.半年可见()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo2", entity.screen_name));
		}
	}

	private static void 下载特别关注() throws IOException {
//		下载(Constants.特别关注());
		for (Constants.IDNameEntity entity : Constants.特别关注()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo4", entity.screen_name), 2000, 1, 1, 2017, 5, 30);
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo4", entity.screen_name), 2022, 8, 15, 2099, 2, 3);
		}
	}

	private static void 下载网红() throws IOException {
//		下载(Constants.网红());
		for (Constants.IDNameEntity entity : Constants.网红()) {
//			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo5", entity.screen_name), 2000, 1, 1, 2013, 12, 31);
//			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo5", entity.screen_name), 2024, 7, 1, 2099, 12, 31);
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo5", entity.screen_name), 2000, 1, 1, 2014, 8, 30);
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo5", entity.screen_name), 2023, 11, 1, 2099, 12, 31);
		}
	}

	private static void 下载蒋依依() throws IOException {
		下载(Constants.蒋依依());
	}

	private static void 下载张婧仪() throws IOException {
		下载(Constants.张婧仪());
	}

	private static void 下载张嘉倪() throws IOException {
		下载(Constants.张嘉倪());
	}

	private static void 下载王楚然() throws IOException {
		下载(Constants.王楚然());
	}

	private static void 下载吴优() throws IOException {
		下载(Constants.吴优());
	}

	private static void 下载王秀竹() throws IOException {
		下载(Constants.王秀竹());
	}

	private static void 下载热巴() throws IOException {
//		下载(Constants.热巴());
		for (Constants.IDNameEntity entity : Constants.热巴()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo", entity.screen_name), 2023, 12, 1, 2024, 12, 31);
		}
	}

	private static void 下载王玉雯() throws IOException {
		下载(Constants.王玉雯());
	}

	private static void 下载王紫璇() throws IOException {
		下载(Constants.王紫璇());
	}

	private static void 下载程潇() throws IOException {
//		下载(Constants.程潇());
		for (Constants.IDNameEntity entity : Constants.程潇()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo", entity.screen_name), 2000, 1, 1, 2016, 11, 02);
//			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo", entity.screen_name), 2023, 12, 1, 2024, 12, 31);
		}
	}

	private static void 下载赵露思() throws IOException {
		下载(Constants.赵露思());
	}

	private static void 下载王鸥() throws IOException {
		下载(Constants.王鸥());
	}

	private static void 下载欧阳娜娜() throws IOException {
//		下载(Constants.欧阳娜娜());
		for (Constants.IDNameEntity entity : Constants.欧阳娜娜()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo2", entity.screen_name), 2000, 1, 1, 2016, 6, 02);
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo2", entity.screen_name), 2024, 7, 1, 2024, 12, 31);
		}
	}

	private static void 下载林允() throws IOException {
		下载(Constants.林允());
	}

	private static void 下载张天爱() throws IOException {
		下载(Constants.张天爱());
	}

	private static void 下载关晓彤() throws IOException {
		下载(Constants.关晓彤());
	}

	private static void 下载娜扎() throws IOException {
		下载(Constants.娜扎());
	}

	private static void 下载韩雪() throws IOException {
		下载(Constants.韩雪());
	}

	private static void 下载赵今麦() throws IOException {
		下载(Constants.赵今麦());
	}

	private static void 下载宋祖儿() throws IOException {
		下载(Constants.宋祖儿());
	}

	private static void 下载(Collection<IDNameEntity> entities) throws IOException {
		for (Constants.IDNameEntity entity : entities) {
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo", entity.screen_name));
		}
	}

	private static void 下载吴宣仪() throws IOException {
//		下载(Constants.吴宣仪());
		for (Constants.IDNameEntity entity : Constants.吴宣仪()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo", entity.screen_name), 2000, 1, 1, 2019, 1, 3);
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo", entity.screen_name), 2024, 7, 1, 2099, 12, 31);
		}
	}

	private static void 下载宋妍霏() throws IOException {
		下载(Constants.宋妍霏());
	}

	private static void 下载张予曦() throws IOException {
		下载(Constants.张予曦());
	}

	private static void 下载陈都灵() throws IOException {
//		下载(Constants.陈都灵());
		for (Constants.IDNameEntity entity : Constants.陈都灵()) {
			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo", entity.screen_name), 2000, 1, 1, 2015, 5, 9);
//			start(new File("F:/weibo_log", entity.screen_name), new File("F:/weibo", entity.screen_name), 2024, 8, 8, 2099, 12, 31);
		}
	}

	private static void 下载部分生图() throws IOException {
//		searchKeys.addAll(Set.of("林*允", "关晓*彤", "关*晓彤", "宋妍*霏", "宋*妍霏", "韩*雪", "秦*岚", "宋*祖儿", "宋祖*儿"));
		Set<String> searchKeys = new TreeSet<>(Set.of());
		searchKeys.addAll(Set.of("早期", "舌", "走光", "腿", "瑜伽"));
		searchKeys.addAll(Set.of("大腿", "比基尼", "泳装", "泳衣", "网袜", "黑丝", "丝袜", "牛仔裤"));
		searchKeys.addAll(Set.of("艾晓琪", "童瑶", "娜扎", "宋妍", "娜娜", "赵今麦", "程潇"));
		searchKeys.addAll(Set.of("张彤", "张萌", "黄梦莹", "许晴", "唐艺昕", "王鸥"));
		searchKeys.addAll(Set.of("韩雪", "舒畅", "马思纯", "周秀娜", "王秀竹", "苏青"));
		searchKeys.addAll(Set.of("赵露思", "蒋梦婕", "江疏影", "李菲儿", "朱珠", "徐娇", "欧阳娜娜"));
		searchKeys.addAll(Set.of("代斯", "梁洁", "徐璐", "璐璐", "张蓝心", "张天爱", "张嘉倪", "宋妍霏"));
		searchKeys.addAll(Set.of("李小冉", "王紫璇", "宋祖儿", "关晓彤", "郭珍霓", "李一桐", "刘芸", "孙耀琦"));
		searchKeys.addAll(Set.of("大幂幂", "杨幂", "姗姗", "娜比", "林允", "孙芮", "李凯馨", "蓝燕", "蓝心妍", "柳岩"));
		searchKeys.addAll(Set.of("曾黎", "王楚然", "蒋依依", "张含韵"));
		searchKeys.addAll(Set.of("白冰", "佟丽娅", "董璇", "张予曦", "蓝盈莹"));
		searchKeys.addAll(Set.of("程潇", "奶潇", "潇潇", "周冬雨", "李冰冰", "范冰冰"));
		searchKeys.addAll(Set.of("田曦薇", "刘诗诗", "诗诗", "阚清子", "秦岚"));
		searchKeys.addAll(Set.of("景甜", "李沁", "张雪迎", "倪妮", "苗苗", "辛芷蕾"));
		searchKeys.addAll(Set.of("陈瑶", "陈都灵", "鞠婧祎", "张婧仪", "杨超越", "娜然", "沈羽洁"));
		searchKeys.addAll(Set.of("陈乔恩"));

		Set<String> weiboLogFolerNames = Constants.生图().stream().map(entity -> entity.screen_name).collect(Collectors.toCollection(LinkedHashSet::new));

		File mainWeiboLogFolder = new File("F:\\weibo_log");
		File mainOutputFolder = new File("F:\\weibo4");
		searchAndDownload(weiboLogFolerNames, searchKeys, mainWeiboLogFolder, mainOutputFolder);
	}

	private static void 下载部分明星图片() throws IOException {
		Set<String> searchKeys = new TreeSet<>(Set.of());
//		searchKeys.addAll(Set.of("王鸥", "唐艺昕", "张蓝心", "郭珍霓", "梁洁", "代斯"));
//		searchKeys.addAll(Set.of("就是阿朱啊", "阿朱", "阿珠"));
		searchKeys.addAll(Set.of("李若嘉"));
		Set<String> weiboLogFolerNames = Constants.明星图片().stream().map(entity -> entity.screen_name).collect(Collectors.toCollection(LinkedHashSet::new));

		File mainWeiboLogFolder = new File("F:\\weibo_log");
		File mainOutputFolder = new File("F:\\weibo3");
		searchAndDownload(weiboLogFolerNames, searchKeys, mainWeiboLogFolder, mainOutputFolder);
	}

	private static void 下载梦醒忒远() throws IOException {
//		Set<String> searchKeys = Set.of("程潇", "张彤", "张萌", "黄梦莹", "许晴", "唐艺昕", "王鸥", "韩雪", "舒畅", "马思纯", "周秀娜", "王秀竹", "苏青", "赵露思", "蒋梦婕", "江疏影", "李菲儿", "朱珠", "徐娇", "欧阳娜娜", "代斯", "梁洁", "徐璐", "张蓝心", "张天爱", "张嘉倪", "宋妍霏", "李小冉", "王紫璇", "宋祖儿", "关晓彤", "郭珍霓", "李一桐", "刘芸", "孙耀琦");
		Set<String> searchKeys = Set.of("娜娜", "瑜伽", "早期", "舌", "赵今麦", "走光", "腿");
		List<String> weiboLogFolerNames = List.of("梦醒忒远");

		File mainWeiboLogFolder = new File("F:\\weibo_log");
		File mainOutputFolder = new File("F:\\weibo2");
		searchAndDownload(weiboLogFolerNames, searchKeys, mainWeiboLogFolder, mainOutputFolder);
	}

	private static void searchAndDownload(Collection<String> weiboLogFolerNames, Collection<String> searchKeys, File mainWeiboLogFolder, File mainOutputFolder) throws IOException {
		for (String weiboLogFolderName : weiboLogFolerNames) {
			System.out.println("-->>\t" + weiboLogFolderName);
			File weiboLogFolder = new File(mainWeiboLogFolder, weiboLogFolderName);
			for (String searchKey : searchKeys) {
				File outputFolder = new File(new File(mainOutputFolder, weiboLogFolderName), searchKey);
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
//		List<String> searchKeys = List.of("出口亜梨沙", "奥山かずさ", "奥山和纱", "奥山", "都丸", "片山", "出口", "橋本愛実", "壇蜜", "武井咲", "相川 結", "上西怜", "上西惠");
//		List<String> searchKeys = List.of("Kazusa Okuyama", "奥山かずさ", "奥山和纱", "奥山");
//		List<String> searchKeys = List.of("Tomaru Sayaka", "都丸 紗也華", "都丸紗也華", "都丸纱也华", "都丸");
//		List<String> searchKeys = List.of("Moemi Katayama", "かたやまもえみ", "かたやま もえみ", "片山 萌美", "片山萌美", "片山");
//		List<String> searchKeys = List.of("Deguchi Arisa", "Arisa Deguchi", "でぐちありさ", "出口亜梨沙", "出口亚梨沙", "出口");
//		List<String> searchKeys = List.of("MitsuDan", "Mitsu Dan", "Dan Mitsu", "DanMitsu", "壇蜜", "出口亜梨沙", "坛蜜");
//		List<String> searchKeys = List.of("HashimotoManami", "Hashimoto Manami", "ManamiHashimoto", "Manami Hashimoto", "橋本マナミ", "細川愛実", "橋本愛実", "桥本真奈美", "桥本爱实");
//		List<String> searchKeys = List.of("JonishiKei", "Jonishi Kei", "KeiJonishi", "Kei Jonishi", "じょうにし けい", "上西恵", "上西惠");
//		List<String> searchKeys = List.of("Yumi Asahina", "YumiAsahina", "AsahinaYumi", "Asahina Yumi", "あさひな ゆみ", "朝比奈 祐未", "朝比奈祐未", "朝比奈未祐", "朝比奈");
//		List<String> searchKeys = List.of("Watanabe Mayu", "WatanabeMayu", "Mayu", "渡辺麻友", "わたなべ まゆ", "渡边麻友");
//		List<String> searchKeys = List.of("Ayaka Miyoshi", "AyakaMiyoshi", "Miyoshi Ayaka", "Miyoshi Ayaka", "みよし あやか", "アヤカ", "菜花", "三吉彩花");
//		List<String> searchKeys = List.of("Yuka Kuramoti", "YukaKuramoti", "KuramotiYuka", "Kuramoti Yuka", "倉持由香", "くらもち ゆか", "仓持由香");
		List<String> searchKeys = List.of("高橋 凛", "高橋凛", "高桥凛", "Rin Takahashi", "RinTakahashi", "Rin Tachibana", "RinTachibana", "橘花凛");
		List<String> weiboLogFolerNames = Constants.日本写真().stream().map(entity -> entity.screen_name).collect(Collectors.toList());
		;

		File mainWeiboLogFolder = new File("F:\\weibo_log");
		File mainOutputFolder = new File("F:\\weibo2");
		searchAndDownload(weiboLogFolerNames, searchKeys, mainWeiboLogFolder, mainOutputFolder);
	}

	private static void 下载() throws IOException {
//		start(new File("F:\\weibo_log\\洋气YOUNGCHIC"), new File("F:\\weibo2\\洋气YOUNGCHIC"), "宋妍霏");
//		start(new File("F:\\weibo_log\\洋气YOUNGCHIC"), new File("F:\\weibo2\\洋气YOUNGCHIC"), "妍霏");
//		start(new File("F:\\weibo_log\\洋气YOUNGCHIC"), new File("F:\\weibo2\\洋气YOUNGCHIC"), "宋妍");
//		start(new File("F:\\weibo_log\\BellaHadidCN"), new File("F:\\weibo2\\BellaHadidCN"), 2024, 6, 1, 2024, 12, 31);
//		start(new File("F:\\weibo_log\\MetFreckle"), new File("F:\\weibo2\\MetFreckle"), 2000, 1, 1, 2018, 1, 1);
//		start(new File("F:\\weibo_log\\吉尼Gini"), new File("F:\\weibo2\\吉尼Gini"),2000,1,1,2019,3,9);
//		start(new File("F:\\weibo_log\\田丽"), new File("F:\\weibo2\\田丽"), 2000, 1, 1, 2014, 12, 31);
//		start(new File("F:\\weibo_log", "明星女神时光机"), new File("F:\\weibo2", "明星女神时光机"), false, 2020, 1, 1, 2020, 12, 31);
//		start(new File("F:\\weibo_log\\Nana谈莉娜"), new File("F:\\weibo2\\Nana谈莉娜"), false, 2000, 1, 1, 2015, 6, 18);

//		start(new File("F:\\weibo_log\\嘉行传媒"), new File("F:\\weibo2\\嘉行传媒"), false, 2000, 1, 1, 2017, 1, 31, "代斯");
//		start(new File("F:\\weibo_log\\嘉行传媒"), new File("F:\\weibo2\\嘉行传媒"), false, 2019, 1, 1, 2019, 1, 31, "代斯");
//		start(new File("F:/weibo_log/那年今日丨吴宣仪"), new File("F:/weibo/那年今日丨吴宣仪"), 2000, 1, 1, 2019, 3, 14);
//		start(new File("F:\\weibo_log\\火箭少女101官博"), new File("F:\\weibo\\火箭少女101官博"), false, 2000, 1, 1, 2025, 1, 1, "吴宣仪");
		start(new File("F:\\weibo_log\\古晨"), new File("F:\\weibo2\\古晨"), 2000, 1, 1, 2014, 3, 31);
//		start(new File("F:\\weibo_log\\毛晓彤"), new File("F:\\weibo2\\毛晓彤"));
//		start(new File("F:\\weibo_log\\李依晓"), new File("F:\\weibo2\\李依晓"));
//		start(new File("F:\\weibo_log\\孟子义"), new File("F:\\weibo2\\孟子义"));
//		start(new File("F:/weibo_log/李若嘉工作室"), new File("F:/weibo/李若嘉工作室"));
//		start(new File("F:/weibo_log/张馨予工作室"), new File("F:/weibo/张馨予工作室"));
//		start(new File("F:/weibo_log/李若嘉"), new File("F:/weibo/李若嘉"));
//		start(new File("F:/weibo_log/蓝盈莹工作室"), new File("F:/weibo/蓝盈莹工作室"));
//		start(new File("F:/weibo_log/Karena吳千語"), new File("F:/weibo/Karena吳千語"));
//		start(new File("F:/weibo_log/唐嫣工作室"), new File("F:/weibo/唐嫣工作室"));
//		start(new File("F:\\weibo_log", "嘉行迪丽热巴工作室"), new File("F:\\weibo", "嘉行迪丽热巴工作室"));
//		start(new File("F:\\weibo_log", "徐璐工作室"), new File("F:\\weibo", "徐璐工作室"));
//		start(new File("F:\\weibo_log", "景甜Studio"), new File("F:\\weibo", "景甜Studio"));
//		start(new File("F:\\weibo_log", "王姿允Rain"), new File("F:\\weibo2", "王姿允Rain"));
//		start(new File("F:\\weibo_log\\王紫璇工作室"), new File("F:\\weibo2/王紫璇工作室"));
//		start(new File("F:\\weibo_log\\张天爱工作室"), new File("F:\\weibo/张天爱工作室"));
//		start(new File("F:\\weibo_log\\无尽热恋丨1226x1109"), new File("F:\\weibo/无尽热恋丨1226x1109"));
//		start(new File("F:\\weibo_log\\潘霜霜Shayla"), new File("F:\\weibo/潘霜霜Shayla"));
//		start(new File("F:\\weibo_log\\林允的小号r"), new File("F:\\weibo/林允的小号r"));
//		start(new File("F:\\weibo_log\\康可人"), new File("F:\\weibo2\\康可人"));
//		start(new File("F:\\weibo_log\\MadisonBeerUpdates"), new File("F:\\weibo2\\MadisonBeerUpdates"));
//		start(new File("F:\\weibo_log\\SydneySweeneyCN"), new File("F:\\weibo2\\SydneySweeneyCN"));
//		start(new File("F:\\weibo_log\\凯瑟琳纽顿0208"), new File("F:\\weibo2\\凯瑟琳纽顿0208"));
//		start(new File("F:\\weibo_log\\周也资讯站"), new File("F:\\weibo2\\周也资讯站"));
//		start(new File("F:\\weibo_log\\一个阿茶-"), new File("F:\\weibo2\\一个阿茶-"));
//		start(new File("F:\\weibo_log\\董璇"), new File("F:\\weibo2\\董璇"));
//		start(new File("F:\\weibo_log\\李凯馨Eleanor工作室"), new File("F:\\weibo2\\李凯馨Eleanor工作室"));
//		start(new File("F:\\weibo_log\\刘湘_11"), new File("F:\\weibo2\\刘湘_11"));
		start(new File("F:\\weibo_log\\林逸欣Shara"), new File("F:\\weibo2\\林逸欣Shara"));
//		start(new File("F:\\weibo_log\\郭珍霓"), new File("F:\\weibo2\\郭珍霓"));
//		start(new File("F:\\weibo_log\\yesyanbaby"), new File("F:\\weibo2\\yesyanbaby"));
//		start(new File("F:\\weibo_log\\陈钰琪Yukee"), new File("F:\\weibo2\\陈钰琪Yukee"));
//		start(new File("F:\\weibo_log\\Summer许晴工作室"), new File("F:\\weibo2\\Summer许晴工作室"));
//		start(new File("F:\\weibo_log\\许晴随行笔记"), new File("F:\\weibo3\\许晴随行笔记"));
//		start(new File("F:\\weibo_log"), "晗卓-", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log", "Fyuan方圆"), new File("F:\\weibo2", "Fyuan方圆"));
//		start(new File("F:\\weibo_log", "赵露思的微博"), new File("F:\\weibo2", "赵露思的微博"));
//		start(new File("F:\\weibo_log\\王鸥Angel图库"), new File("F:\\weibo2\\王鸥Angel图库"));
//		start(new File("F:\\weibo_log", "朱珠ZhuZhu"), new File("F:\\weibo2", "朱珠ZhuZhu"));
//		start(new File("F:\\weibo_log\\王紫璇CiCi"), new File("F:\\weibo2\\王紫璇CiCi"));
//		start(new File("F:\\weibo_log", "王秀竹"), new File("F:\\weibo2", "王秀竹"));
//		start(new File("F:\\weibo_log", "兔子日记·张嘉倪"), new File("F:\\weibo2", "兔子日记·张嘉倪"));
//		start(new File("F:\\weibo_log", "孙芮工作室"), new File("F:\\weibo2", "孙芮工作室"));
//		start(new File("F:\\weibo_log", "刘秦杉是个重庆妹儿"), new File("F:\\weibo2", "刘秦杉是个重庆妹儿"));
//		start(new File("F:\\weibo_log", "隋俊波"), new File("F:\\weibo2", "隋俊波"));
//		start(new File("F:\\weibo_log", "代斯daisy"), new File("F:\\weibo2", "代斯daisy"));
//		start(new File("F:\\weibo_log\\徐娇工作室"), new File("F:\\weibo2\\徐娇工作室"));
//		start(new File("F:\\weibo_log\\徐娇"), new File("F:\\weibo2\\徐娇"));
//		start(new File("F:\\weibo_log", "演员王智"), new File("F:\\weibo2", "演员王智"));
//		start(new File("F:\\weibo_log", "苏青工作室"), new File("F:\\weibo2", "苏青工作室"));
//		start(new File("F:\\weibo_log\\赵蕴卓同学"), new File("F:\\weibo2\\赵蕴卓同学"));
//		start(new File("F:\\weibo_log\\柳岩"), new File("F:\\weibo2\\柳岩"));
//		start(new File("F:\\weibo_log", "梁洁Little"), new File("F:\\weibo2", "梁洁Little"));
//		start(new File("F:\\weibo_log", "梁洁工作室"), new File("F:\\weibo2", "梁洁工作室"));
//		start(new File("F:\\weibo_log", "赵露思工作室官微"), new File("F:\\weibo2", "赵露思工作室官微"));
//		start(new File("F:\\weibo_log", "景甜"), new File("F:\\weibo2", "景甜"));
//		start(new File("F:\\weibo_log", "蓝心妍"), new File("F:\\weibo2", "蓝心妍"));
//		start(new File("F:\\weibo_log", "我是娜扎"), new File("F:\\weibo2", "我是娜扎"));
//		start(new File("F:\\weibo_log", "娜扎工作室"), new File("F:\\weibo2", "娜扎工作室"));
//		start(new File("F:\\weibo_log", "马思纯"), new File("F:\\weibo2", "马思纯"));
//		start(new File("F:\\weibo_log", "李菲儿工作室"), new File("F:\\weibo2", "李菲儿工作室"));
//		start(new File("F:\\weibo_log", "孙怡工作室"), new File("F:\\weibo2", "孙怡工作室"));
//		start(new File("F:\\weibo_log", "GNZ48-刘倩倩-"), new File("F:\\weibo2", "GNZ48-刘倩倩-"));
//		start(new File("F:\\weibo_log", "陈斯文cissie"), new File("F:\\weibo2", "陈斯文cissie"));
//		start(new File("F:\\weibo_log", "沈羽洁er"), new File("F:\\weibo2", "沈羽洁er"));
//		start(new File("F:\\weibo_log"), "郭碧婷", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log"), "韩雪工作室", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log"), "八掛海_real", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log"), "Fairy丨0416林允Jelly", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log"), "潘敏-", new File("F:\\weibo2"));
//		start(new File("F:\\weibo_log\\胡冰卿"), new File("F:\\weibo2\\胡冰卿"));
//		start(new File("F:\\weibo_log\\张彤"), new File("F:\\weibo2\\张彤"));
	}
}
