package com.my.crawler.weibo2;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class Constants {
	static {
		System.setProperty("line.separator", "\n");
	}

	public static final boolean isProxy = false;
	public static final Random random = new Random();

	public static void randomSleepLong() {
		try {
			Thread.sleep(Constants.random.nextInt(16) * 1278 + 6789);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void randomSleepShort() {
		try {
			Thread.sleep(Constants.random.nextInt(16) * 100 + 512);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static final String WEIBO_ARRAY_FILE_NAME = "weibo.log";
	public static final String PICS_VIDEOS_FILE_NAME = "pics_videos.log";
	public static final String FAVORITES_PICS_VIDEOS_FILE_NAME = "favorites_pics_videos.log";
	public static final String DONE_LIST_FILE_NAME = "done.list";

	public static final String DATE_ID_FORMAT = "%04d-%02d-%02d-%s";
	public static final String DATE_FORMAT = "%04d-%02d-%02d";
	public static final String PICS_ID = "pics";
	public static final String VIDEOS_ID = "videos";
	public static final String TEXT_ID = "text_raw";
	public static final String PAGE_URL_ID = "page_url";
	public static final String PAGE_URL_FORMAT = "https://weibo.com/%s/%s";
	public static final String SCREEN_NAME_ID = "screen_name";
	public static final String TAGS_ID = "tags";

	public static class IDNameEntity implements Comparable<IDNameEntity>{
		public String id;
		public String screen_name;

		public IDNameEntity(String id, String screen_name) {
			this.id = id;
			this.screen_name = screen_name;
		}

		public String getId() {
			return id;
		}

		public String getScreen_name() {
			return screen_name;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			IDNameEntity other = (IDNameEntity) obj;
			return Objects.equals(id, other.id) && Objects.equals(screen_name, other.screen_name);
		}

		@Override
		public String toString() {
			return id + ": " + screen_name;
		}

		@Override
		public int compareTo(IDNameEntity o) {
			return this.id.compareTo(o.id);
		}
	}

	public static Set<IDNameEntity> 网红() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
//		entities.add(new IDNameEntity("1243273752", "古晨"));
		entities.add(new IDNameEntity("6363000838", "林允的小号r"));
		entities.add(new IDNameEntity("6634226106", "叶舒华_G-I-DLE"));
		entities.add(new IDNameEntity("5878805423", "BDD东"));
		entities.add(new IDNameEntity("7854658294", "镕馨二"));
		entities.add(new IDNameEntity("2564113492", "陈瑜Estelle"));
		entities.add(new IDNameEntity("5512873304", "王星辰辰辰"));
		entities.add(new IDNameEntity("6521611081", "食梦鲨"));
		entities.add(new IDNameEntity("2656078013", "阿白啊"));
		entities.add(new IDNameEntity("3932503454", "潘敏-"));
		entities.add(new IDNameEntity("2389396110", "Fyuan方圆"));
		entities.add(new IDNameEntity("1516617405", "Cokey斯琦"));
		entities.add(new IDNameEntity("5976513930", "EE-52"));
		entities.add(new IDNameEntity("6564121066", "陈斯文cissie"));
		entities.add(new IDNameEntity("5578993193", "王緒緒Annabella"));
		entities.add(new IDNameEntity("2672500515", "李梦颖aggiem"));
		entities.add(new IDNameEntity("3733026753", "于雯_"));
		entities.add(new IDNameEntity("5635369993", "鸡腿诺"));
		entities.add(new IDNameEntity("5397349535", "一个阿茶-"));
		entities.add(new IDNameEntity("2846104240", "咕噜小_"));
		entities.add(new IDNameEntity("7861479245", "佳怡一路佳境"));
		entities.add(new IDNameEntity("7650313931", "山一几Eleanor"));
		entities.add(new IDNameEntity("1547371213", "一栗莎子"));
		entities.add(new IDNameEntity("1890196401", "不2不叫周淑怡"));
		entities.add(new IDNameEntity("5650846803", "婴宁lasw"));
		entities.add(new IDNameEntity("1632440911", "王熙然Crystal"));
		entities.add(new IDNameEntity("1910183793", "琬琬_"));
		entities.add(new IDNameEntity("2157399004", "MAYA张曼源"));
		entities.add(new IDNameEntity("1948537163", "小乔切克闹"));
		entities.add(new IDNameEntity("6047705183", "茂木希子1840"));
		entities.add(new IDNameEntity("1874288121", "王瑞子715"));
		entities.add(new IDNameEntity("2684753901", "上淇Bolla"));
		entities.add(new IDNameEntity("1787697542", "超Carry的柴西"));
		entities.add(new IDNameEntity("2134823031", "鄧伊婷Irina"));
		entities.add(new IDNameEntity("5880225155", "花样滑冰陈虹伊"));
		entities.add(new IDNameEntity("5991895370", "镕馨Rongxiiin"));
		entities.add(new IDNameEntity("1931519363", "王筱沫沫丶"));
		entities.add(new IDNameEntity("6472949434", "是小冰心啊"));
		entities.add(new IDNameEntity("2185613090", "晗卓-"));
		entities.add(new IDNameEntity("2316623200", "在下刀哥"));
		entities.add(new IDNameEntity("5577929883", "夏天要有冰镇西瓜"));
		entities.add(new IDNameEntity("1913248565", "郑琴心"));
		entities.add(new IDNameEntity("2079592581", "依涵妹纸"));
//		entities.add(new IDNameEntity("2591247200", "沫子Mozz"));
		entities.add(new IDNameEntity("1858002662", "轩子巨2兔"));
		entities.add(new IDNameEntity("3620180771", "黑嘉嘉94"));
		entities.add(new IDNameEntity("6519552504", "陈梦儿-myYY"));
		entities.add(new IDNameEntity("1787965887", "叫我赵赵赵丽娜"));
		entities.add(new IDNameEntity("7726453840", "普通小柴"));
		entities.add(new IDNameEntity("2639048961", "陈玮模特"));
		entities.add(new IDNameEntity("5885708534", "GNZ48-刘倩倩-"));
		entities.add(new IDNameEntity("3860480819", "霓哑"));
		entities.add(new IDNameEntity("6447697223", "Sherry_Go"));
		entities.add(new IDNameEntity("6063018876", "Rosie的瑜伽乐园"));
		entities.add(new IDNameEntity("2022939422", "伍淑怡yoyo"));
		entities.add(new IDNameEntity("2331498495", "半藏森林"));
		entities.add(new IDNameEntity("3793748881", "海洋饼干Sophie"));
		entities.add(new IDNameEntity("5787520494", "曾霏鬼鬼Jasmia"));
		entities.add(new IDNameEntity("5161709111", "你的笑儿啊"));
		entities.add(new IDNameEntity("5279748872", "yesyanbaby"));
		entities.add(new IDNameEntity("5292770234", "Enndme"));
		entities.add(new IDNameEntity("1994587137", "车晓贝Cherry"));
		entities.add(new IDNameEntity("6449803160", "許藍方博士DrGracie"));
		entities.add(new IDNameEntity("1691931715", "孙嘉一Zoe"));
		entities.add(new IDNameEntity("1726938950", "迪拜奶奶"));
		entities.add(new IDNameEntity("2526864315", "六金yE"));
		entities.add(new IDNameEntity("2677561361", "我是小爱薇"));
		entities.add(new IDNameEntity("6693897228", "张丹三FireCoolNiceGood"));
		entities.add(new IDNameEntity("1978605597", "张曼伶bella"));
		entities.add(new IDNameEntity("2027847203", "小白金金"));
		entities.add(new IDNameEntity("3165665983", "维姿娅摄影机构"));
		entities.add(new IDNameEntity("2950251663", "吉尼Gini"));
		entities.add(new IDNameEntity("5631258292", "王语会yy"));
		entities.add(new IDNameEntity("3831124742", "王梓莼"));
		entities.add(new IDNameEntity("1961422704", "欧阳子月"));
		entities.add(new IDNameEntity("3259102532", "·1saye"));
		entities.add(new IDNameEntity("1951705377", "郝娉婷"));
		entities.add(new IDNameEntity("7607376925", "是你的程儿"));
		entities.add(new IDNameEntity("2882083237", "陈暖央"));
		entities.add(new IDNameEntity("5487129036", "一个蟹蟹梨"));
		entities.add(new IDNameEntity("1780172395", "今天也吃面包了吗"));
		entities.add(new IDNameEntity("2383785520", "森林北-"));
		entities.add(new IDNameEntity("7684302341", "蜜桃老师真人"));
		return entities;
	}

	public static Set<IDNameEntity> 明星图片() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("7122808864", "MeetStar"));
		entities.add(new IDNameEntity("1706922787", "鹗立矫矫"));
//		entities.add(new IDNameEntity("2387903701", "明星爱街拍"));
		entities.add(new IDNameEntity("7621564678", "丝图侦探"));
		entities.add(new IDNameEntity("7246316530", "少女私房画册"));
		entities.add(new IDNameEntity("2707432380", "疯狂娱乐_控"));
		entities.add(new IDNameEntity("2990845874", "满屏都是小仙女"));
		entities.add(new IDNameEntity("5246417862", "吴倩mine4ever图库"));
		entities.add(new IDNameEntity("5721033646", "北电中戏的校花"));
		entities.add(new IDNameEntity("7200803751", "美足榜"));
		entities.add(new IDNameEntity("6401257647", "哥谭F1"));
		entities.add(new IDNameEntity("5585252366", "拜见老夫子"));
		entities.add(new IDNameEntity("6012485384", "K-POP时光机"));
		entities.add(new IDNameEntity("5731190652", "幂极品"));
		entities.add(new IDNameEntity("6965504325", "酷爱0507"));
		entities.add(new IDNameEntity("6054829629", "只想发现更多更多"));
		entities.add(new IDNameEntity("5311514508", "小餓图很多么"));
		entities.add(new IDNameEntity("6558950686", "Queeniok"));
		entities.add(new IDNameEntity("7719494852", "SF女星高跟鞋"));
		entities.add(new IDNameEntity("6476860689", "娱乐小活宝Iym"));
		entities.add(new IDNameEntity("7379285492", "生图星赏"));
		entities.add(new IDNameEntity("7389951593", "星颜星色"));
		entities.add(new IDNameEntity("7444217547", "星腿"));
		entities.add(new IDNameEntity("7725260725", "星颜悦色"));
		entities.add(new IDNameEntity("7749543406", "明星生图合集"));
		entities.add(new IDNameEntity("5591995971", "明星美"));
		entities.add(new IDNameEntity("6015462061", "饭爱豆明星街拍"));
		entities.add(new IDNameEntity("6337948455", "明星腿新"));
		entities.add(new IDNameEntity("6514989592", "女明星高跟图鉴"));
		entities.add(new IDNameEntity("6574894850", "明星图赏"));
		entities.add(new IDNameEntity("6614373438", "明星腿wiki"));
		entities.add(new IDNameEntity("7111779343", "女明星美图写真"));
		entities.add(new IDNameEntity("7286876766", "明星欣赏"));

		return entities;
	}

	public static Set<IDNameEntity> 半年可见() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1197755162", "韩雪"));

		entities.add(new IDNameEntity("1350995007", "我是娜扎"));
		entities.add(new IDNameEntity("1757744065", "蓝盈莹Lyric"));
		entities.add(new IDNameEntity("6321557477", "蓝盈莹工作室"));
		entities.add(new IDNameEntity("5658519205", "余冰慧的微博"));
		entities.add(new IDNameEntity("1852554501", "Kelly于文文"));
		entities.add(new IDNameEntity("1729370543", "郭碧婷"));
		entities.add(new IDNameEntity("5954919139", "蒋梦婕工作室"));
		entities.add(new IDNameEntity("1779963950", "张小斐0110"));
		entities.add(new IDNameEntity("1712539910", "陈乔恩"));
		entities.add(new IDNameEntity("1378010100", "王子文Ava"));
		entities.add(new IDNameEntity("1246850033", "徐冬冬"));
		entities.add(new IDNameEntity("5790112354", "程潇"));
		entities.add(new IDNameEntity("1345566427", "佟丽娅"));
		entities.add(new IDNameEntity("6521611081", "食梦鲨"));
		entities.add(new IDNameEntity("7409360499", "小蓝蓝plus"));
		entities.add(new IDNameEntity("2646681810", "林允Jelly"));
		entities.add(new IDNameEntity("1256018912", "张雯"));
		entities.add(new IDNameEntity("3262625014", "唐艺昕工作室"));
		entities.add(new IDNameEntity("1662068793", "唐艺昕"));
		entities.add(new IDNameEntity("2579189065", "聂小雨YU"));
		entities.add(new IDNameEntity("1642351362", "angelababy"));
		entities.add(new IDNameEntity("1662262590", "张予曦"));
		entities.add(new IDNameEntity("1221923871", "王鸥Angel"));
		entities.add(new IDNameEntity("7861479245", "佳怡一路佳境"));
		entities.add(new IDNameEntity("7650313931", "山一几Eleanor"));
		entities.add(new IDNameEntity("1547371213", "一栗莎子"));
		entities.add(new IDNameEntity("1890196401", "不2不叫周淑怡"));
		entities.add(new IDNameEntity("5650846803", "婴宁lasw"));
		entities.add(new IDNameEntity("1910183793", "琬琬_"));
		entities.add(new IDNameEntity("5197213436", "金佳悦-"));
		entities.add(new IDNameEntity("3543321521", "徐梓钧"));
		entities.add(new IDNameEntity("1628482500", "陆妍淇"));
		entities.add(new IDNameEntity("1685903494", "刘敏"));
		entities.add(new IDNameEntity("1667629881", "汪聪"));
		entities.add(new IDNameEntity("3250619894", "王悦伊"));
		entities.add(new IDNameEntity("3050731261", "吴哲晗_RenRen"));
		entities.add(new IDNameEntity("1856253582", "赵圆瑗"));
		entities.add(new IDNameEntity("1959325517", "吴佩柔vianna"));
		entities.add(new IDNameEntity("6333714154", "冯琳Fairy"));
		entities.add(new IDNameEntity("1792997800", "林夏薇"));
		entities.add(new IDNameEntity("1592609155", "演员郑清文"));
		entities.add(new IDNameEntity("5581473993", "裴佳欣"));
		entities.add(new IDNameEntity("1235919683", "舒畅"));
		entities.add(new IDNameEntity("1237313773", "热依扎"));
		entities.add(new IDNameEntity("1301064830", "柴蔚"));
		entities.add(new IDNameEntity("1750403737", "何穗"));
		entities.add(new IDNameEntity("1632234453", "蓝心ZoeZhang"));
		entities.add(new IDNameEntity("5509838501", "刘玮婷V"));
		entities.add(new IDNameEntity("1863148892", "何慧香"));
		entities.add(new IDNameEntity("6206252683", "BEJ48-孙晓艳"));
		entities.add(new IDNameEntity("1197354837", "左小青"));
		entities.add(new IDNameEntity("1199430302", "赵子琪"));
		entities.add(new IDNameEntity("2259682244", "严尚嘉"));
		entities.add(new IDNameEntity("7742588757", "朱梓橦工作室"));
		entities.add(new IDNameEntity("2995886832", "朱梓橦"));
		entities.add(new IDNameEntity("1746280511", "張榕容"));
		entities.add(new IDNameEntity("1836623917", "主持人郭玮"));
		entities.add(new IDNameEntity("1278603180", "吴谨言"));
		entities.add(new IDNameEntity("1957663211", "张芷溪"));
		entities.add(new IDNameEntity("1843875727", "菅纫姿"));
		entities.add(new IDNameEntity("1653556670", "颖儿Yinger"));
		entities.add(new IDNameEntity("5073735131", "精灵少女Gen1es_欧阳娣娣"));
		entities.add(new IDNameEntity("1730502654", "郭雪芙HF_K"));
		entities.add(new IDNameEntity("1731769015", "郭采洁"));
		entities.add(new IDNameEntity("1990241370", "演员洪爽"));
		entities.add(new IDNameEntity("1290193560", "李念"));
		entities.add(new IDNameEntity("2344543981", "-靳梦佳"));
		entities.add(new IDNameEntity("1242213702", "王晓晨"));
		entities.add(new IDNameEntity("1278364204", "李斯羽"));
		entities.add(new IDNameEntity("1347680337", "叶璇"));
		entities.add(new IDNameEntity("1444153597", "牛欣欣"));
		entities.add(new IDNameEntity("1195381367", "胡可"));
		entities.add(new IDNameEntity("1237024972", "白冰"));
		entities.add(new IDNameEntity("1247063043", "颜丹晨"));
		entities.add(new IDNameEntity("2602190401", "孙晓伦呀"));
		entities.add(new IDNameEntity("1809054937", "李沁"));
		entities.add(new IDNameEntity("6057355845", "李沁工作室"));
		entities.add(new IDNameEntity("6020985643", "王鸥工作室"));
		entities.add(new IDNameEntity("1284876111", "万茜"));
		entities.add(new IDNameEntity("1340552632", "王丽坤"));
		entities.add(new IDNameEntity("1640016932", "张雨绮"));
		entities.add(new IDNameEntity("1192515960", "李冰冰"));
		entities.add(new IDNameEntity("1197191492", "刘涛tamia"));
		entities.add(new IDNameEntity("1192329893", "秦岚"));
		entities.add(new IDNameEntity("6062055731", "秦岚工作室"));
		entities.add(new IDNameEntity("1235576307", "马苏"));
		entities.add(new IDNameEntity("1231654104", "刘芸"));
		entities.add(new IDNameEntity("1213239282", "宋佳"));
		entities.add(new IDNameEntity("1158709993", "李溪芮"));
		entities.add(new IDNameEntity("6368929929", "王子文工作室微博"));
		entities.add(new IDNameEntity("1192504607", "童瑶"));
		entities.add(new IDNameEntity("1309862862", "苏青"));
		entities.add(new IDNameEntity("1246229612", "毛晓彤"));
		entities.add(new IDNameEntity("1858065064", "杨蓉"));
		entities.add(new IDNameEntity("3952070245", "范冰冰"));
		entities.add(new IDNameEntity("5644764907", "杨超越"));
		entities.add(new IDNameEntity("3828809034", "-王楚然-"));
		entities.add(new IDNameEntity("5620452341", "虞书欣Esther"));
		entities.add(new IDNameEntity("5397477824", "周雨彤微博"));
		entities.add(new IDNameEntity("1246788271", "李菲儿love"));
		entities.add(new IDNameEntity("5686102278", "张柏芝工作室"));
		entities.add(new IDNameEntity("6118375776", "张柏芝"));
		entities.add(new IDNameEntity("1259110474", "赵丽颖"));
		entities.add(new IDNameEntity("1934403631", "孙怡微博"));
		entities.add(new IDNameEntity("1239315002", "张嘉倪"));
		entities.add(new IDNameEntity("1222062284", "张萌"));
		entities.add(new IDNameEntity("1347118243", "陳妍希michelle"));
		entities.add(new IDNameEntity("1662532110", "张佳宁"));
		entities.add(new IDNameEntity("1665256992", "蒋欣"));
		entities.add(new IDNameEntity("1240008360", "王媛可"));
		entities.add(new IDNameEntity("1722686885", "王卓淇erin__kay"));
		entities.add(new IDNameEntity("1756505825", "李小冉"));
		entities.add(new IDNameEntity("1313228221", "李佳桐sep"));
		entities.add(new IDNameEntity("1307243944", "李依晓"));
		entities.add(new IDNameEntity("5796662600", "吴宣仪_Betty"));
		entities.add(new IDNameEntity("1773061573", "陈小纭"));
		entities.add(new IDNameEntity("1239439810", "施诗Kira"));
		entities.add(new IDNameEntity("2607803303", "章若楠"));
		entities.add(new IDNameEntity("1741661732", "顾璇"));
		entities.add(new IDNameEntity("2569522534", "孟子义"));
		entities.add(new IDNameEntity("1213395722", "黄奕"));
		entities.add(new IDNameEntity("6671129497", "演员艾米"));
		entities.add(new IDNameEntity("1442378302", "米露"));
		entities.add(new IDNameEntity("1965681503", "林小宅"));
		entities.add(new IDNameEntity("1719397245", "JaniceMan文咏珊"));
		entities.add(new IDNameEntity("1319911982", "张雪迎Sophie"));
		entities.add(new IDNameEntity("1304194202", "刘诗诗"));
		entities.add(new IDNameEntity("1230663070", "唐嫣"));
		entities.add(new IDNameEntity("1847672711", "徐璐LULU"));
		entities.add(new IDNameEntity("6519552504", "陈梦儿-myYY"));
		entities.add(new IDNameEntity("5991895370", "镕馨Rongxiiin"));
		return entities;
	}

	public static Set<IDNameEntity> 特别关注() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2687827715", "歐陽娜娜Nana"));
		entities.add(new IDNameEntity("5943076204", "歐陽娜娜Nana工作室"));
		entities.add(new IDNameEntity("6387099968", "张婧仪"));
		entities.add(new IDNameEntity("7610808848", "张婧仪工作室"));
		entities.add(new IDNameEntity("5617960493", "徐璐工作室"));
		entities.add(new IDNameEntity("1749964961", "张馨予"));
		entities.add(new IDNameEntity("1669879400", "Dear-迪丽热巴"));
		entities.add(new IDNameEntity("1549364094", "江疏影"));
		entities.add(new IDNameEntity("2554404125", "倪妮V"));
		entities.add(new IDNameEntity("2106192855", "赵今麦angel"));
		entities.add(new IDNameEntity("2687827715", "歐陽娜娜Nana"));
		entities.add(new IDNameEntity("2389396110", "Fyuan方圆"));
		entities.add(new IDNameEntity("1943405723", "钟楚曦"));
		entities.add(new IDNameEntity("1913244047", "钟楚曦工作室"));
		entities.add(new IDNameEntity("5187459538", "王秀竹"));
		entities.add(new IDNameEntity("3261134763", "刘亦菲"));
		entities.add(new IDNameEntity("5653796775", "赵露思的微博"));
		entities.add(new IDNameEntity("1318119365", "蒋依依"));
		entities.add(new IDNameEntity("1644461042", "柳岩"));
		entities.add(new IDNameEntity("1320135280", "袁姗姗"));
		entities.add(new IDNameEntity("1788283193", "Crystal张天爱"));
		entities.add(new IDNameEntity("2174204211", "唐嫣工作室"));
		entities.add(new IDNameEntity("2007341923", "代斯daisy"));
//		entities.add(new IDNameEntity("7720744067", "明星生图现场"));
//		entities.add(new IDNameEntity("7543862954", "女明星生图-"));
		entities.add(new IDNameEntity("1659390800", "蒋梦婕"));
		entities.add(new IDNameEntity("2808966557", "李凱馨Eleanor"));
		entities.add(new IDNameEntity("6323957970", "梁洁工作室"));
		entities.add(new IDNameEntity("1078007814", "徐娇"));
		entities.add(new IDNameEntity("1941345837", "黄梦莹maggie"));
		entities.add(new IDNameEntity("6523291767", "吴千语工作室"));
		entities.add(new IDNameEntity("2626304873", "杨颖工作室"));
		entities.add(new IDNameEntity("5704068886", "张予曦studio"));
		entities.add(new IDNameEntity("1774182292", "杨采钰Ora"));
		entities.add(new IDNameEntity("1738498871", "马思纯"));
		entities.add(new IDNameEntity("1656214784", "甘婷婷_TT"));
		entities.add(new IDNameEntity("3701937467", "Hello佟丽娅"));
		entities.add(new IDNameEntity("5368454432", "奚梦瑶Studio"));
		entities.add(new IDNameEntity("6219767932", "乔欣工作室"));
		entities.add(new IDNameEntity("7555511345", "白鹿资讯站"));
		entities.add(new IDNameEntity("6670517617", "赵今麦工作室official"));
		entities.add(new IDNameEntity("1262456801", "张歆艺"));
		entities.add(new IDNameEntity("6138359020", "毛晓彤工作室"));
		entities.add(new IDNameEntity("1819325063", "ice艾晓琪"));
		entities.add(new IDNameEntity("7473157651", "吴宣仪的快乐碎片"));
		entities.add(new IDNameEntity("5133022135", "热依扎官微"));
		entities.add(new IDNameEntity("5295502496", "袁姗姗工作室"));
		entities.add(new IDNameEntity("5902979020", "江疏影工作室"));
		entities.add(new IDNameEntity("7474425160", "程潇已上线"));
		entities.add(new IDNameEntity("5943076204", "歐陽娜娜Nana工作室"));
		entities.add(new IDNameEntity("6001863056", "娜扎工作室"));
		entities.add(new IDNameEntity("3516848557", "王丽坤工作室"));
		entities.add(new IDNameEntity("6100206722", "关晓彤工作室"));
		entities.add(new IDNameEntity("3014125367", "倪妮工作室"));
		entities.add(new IDNameEntity("5885799032", "林允Team"));
		entities.add(new IDNameEntity("2804630987", "梁洁Little"));
		entities.add(new IDNameEntity("3034045004", "赵蕴卓同学"));
		entities.add(new IDNameEntity("5455220518", "景甜Studio"));
		entities.add(new IDNameEntity("3867221552", "周冬雨工作室"));
		entities.add(new IDNameEntity("2744950651", "杨幂工作室"));
		entities.add(new IDNameEntity("6269329742", "嘉行迪丽热巴工作室"));
		entities.add(new IDNameEntity("1769202531", "韩雪工作室"));
		return entities;
	}

	public static Set<IDNameEntity> 欧美() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2280514454", "PrettyBarbiesss"));
		entities.add(new IDNameEntity("2929157581", "itsnotkk"));
		entities.add(new IDNameEntity("5666687855", "BellaHadidCN"));
		entities.add(new IDNameEntity("5611022610", "HayleyAtwellCN海莉小象乐园"));
		entities.add(new IDNameEntity("5907547517", "Angel_AlessandraAmbrosio"));
		entities.add(new IDNameEntity("5335569701", "凯瑟琳纽顿0208"));
		entities.add(new IDNameEntity("2493285800", "斯嘉丽约翰逊吧"));
		entities.add(new IDNameEntity("2039735544", "KristenStewart409"));
		entities.add(new IDNameEntity("6526473633", "Chloe_Moretz"));
		entities.add(new IDNameEntity("2971546913", "Gal_Gadot_News"));
		entities.add(new IDNameEntity("3387184100", "MARTAKRYLOVA"));
		entities.add(new IDNameEntity("3540719202", "Gabi_Baylee小熊屋"));
		entities.add(new IDNameEntity("2606860061", "KristenStewart_CN"));
		entities.add(new IDNameEntity("5690051916", "MckennaGraceNews"));
		entities.add(new IDNameEntity("5209679694", "梅根福克斯MeganFox吧"));
		entities.add(new IDNameEntity("3923782646", "梅根福克斯网站"));
		entities.add(new IDNameEntity("1903373171", "-莫妮卡贝鲁奇"));
		entities.add(new IDNameEntity("5995299749", "Official_Gal_Gadot"));
		entities.add(new IDNameEntity("7329838548", "SydneySweeneyCN"));
		entities.add(new IDNameEntity("6433932676", "ZendayaOnline"));
		entities.add(new IDNameEntity("1725456042", "HiyaSonya"));
		entities.add(new IDNameEntity("6869649307", "HaileeSteinfeld"));
		return entities;
	}

	public static Set<IDNameEntity> 韩国() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5235570809", "文佳煐的月光笔记"));
		entities.add(new IDNameEntity("5316703570", "hyominnn00"));
		entities.add(new IDNameEntity("2316856933", "朴孝敏_HyoMinus"));
		entities.add(new IDNameEntity("6380423180", "Seojin_Ban潘南奎"));
		entities.add(new IDNameEntity("5443673845", "宋智孝_Official"));
		entities.add(new IDNameEntity("3739825350", "ClaraLee克拉拉"));
		entities.add(new IDNameEntity("6799093411", "韩素希_1118"));
		return entities;
	}

	public static Set<IDNameEntity> 日本写真() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("7727697684", "ZERO摄影写真集"));
		entities.add(new IDNameEntity("7655724324", "万米独行田伯光"));
		entities.add(new IDNameEntity("6707377011", "随缘更新希美社"));
		entities.add(new IDNameEntity("7842543071", "永远的梦1988"));
		entities.add(new IDNameEntity("7720294681", "二号机v"));
		entities.add(new IDNameEntity("2400603821", "PHOTOIDOL"));
		entities.add(new IDNameEntity("7511135744", "晴天大风扇"));
		entities.add(new IDNameEntity("6488464342", "zatoichii"));
		entities.add(new IDNameEntity("7885820294", "麻美探长"));
		entities.add(new IDNameEntity("3987554835", "麻美酱的夏天"));
		entities.add(new IDNameEntity("1801710007", "霓虹饭"));
		entities.add(new IDNameEntity("2610794641", "世界第一的美少女"));
		entities.add(new IDNameEntity("2670224681", "拳击男友"));
		entities.add(new IDNameEntity("7111616630", "語溺"));
		entities.add(new IDNameEntity("6134829687", "周刊杂志社"));
		entities.add(new IDNameEntity("3911112223", "你亲爱的犬宝"));
		return entities;
	}

	public static Set<IDNameEntity> 日本() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5234093606", "本庄铃_Honjo"));
		entities.add(new IDNameEntity("5494121361", "Papakey中国官方微博"));
		entities.add(new IDNameEntity("6345083206", "森泽佳奈_real"));
		entities.add(new IDNameEntity("5330430588", "森泽佳奈_official"));
		entities.add(new IDNameEntity("2232872280", "小嶋阳菜HarunaKojima"));
		entities.add(new IDNameEntity("6427309237", "橘玛丽_official"));
		entities.add(new IDNameEntity("5474534259", "水原希子_Official"));
		entities.add(new IDNameEntity("6268637382", "铃木友菜的小辫子"));
		entities.add(new IDNameEntity("7195313110", "三吉彩花MiyoshiAyaka"));
		entities.add(new IDNameEntity("7207679455", "光希-Koki"));
		entities.add(new IDNameEntity("5991247442", "胖胖小蛋糕"));
		entities.add(new IDNameEntity("5152487407", "惠亲的惠亲"));
		entities.add(new IDNameEntity("1862896261", "松岡李那LinahM"));
		entities.add(new IDNameEntity("5161430241", "花家没有花"));
		return entities;
	}

	public static Set<IDNameEntity> 生图() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5697928291", "剧淘娱乐"));
		entities.add(new IDNameEntity("6525010965", "狐厂大拷问"));
		entities.add(new IDNameEntity("7090942012", "星同事"));

		entities.add(new IDNameEntity("6489906026", "星图驿站"));
		entities.add(new IDNameEntity("7237314735", "星素鉴赏"));
		entities.add(new IDNameEntity("7731444226", "明星生图大侦探"));
		entities.add(new IDNameEntity("7444688404", "全是生图"));
		entities.add(new IDNameEntity("7760118734", "星图欣赏i"));
		entities.add(new IDNameEntity("3290016493", "美颜滤镜粉碎机·真实很美好"));
		entities.add(new IDNameEntity("7828075583", "明星生图大赏V"));
		entities.add(new IDNameEntity("7399398633", "明星女神时光机"));
		entities.add(new IDNameEntity("7755667765", "素妍星途"));
		entities.add(new IDNameEntity("7748973700", "明星现场生图"));
		entities.add(new IDNameEntity("7720744067", "明星生图现场"));
		entities.add(new IDNameEntity("7594293642", "水月近星"));
		entities.add(new IDNameEntity("7500355509", "明星定妆照"));
		entities.add(new IDNameEntity("7471836107", "mxstjz"));
		entities.add(new IDNameEntity("7689183881", "大作Photo"));
		entities.add(new IDNameEntity("3176566060", "老叮当GG"));
		entities.add(new IDNameEntity("7379285492", "生图星赏"));
		entities.add(new IDNameEntity("7543862954", "女明星生图-"));
		entities.add(new IDNameEntity("7566511986", "stars生图-"));
		entities.add(new IDNameEntity("7584118653", "明星生图狂魔"));
		entities.add(new IDNameEntity("7644611287", "明星生图Martin"));
		entities.add(new IDNameEntity("7749543406", "明星生图合集"));
		entities.add(new IDNameEntity("7790063400", "生图欣赏2023"));
		return entities;
	}

	public static Set<IDNameEntity> 关晓彤() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1288739185", "关晓彤"));
		entities.add(new IDNameEntity("6100206722", "关晓彤工作室"));
		entities.add(new IDNameEntity("5402265265", "7Gabrielle-关晓彤奇迹站"));
		entities.add(new IDNameEntity("5692909619", "立彤霄丨关晓彤"));
		entities.add(new IDNameEntity("7677651544", "微醺丨关晓彤"));
		return entities;
	}

	public static Set<IDNameEntity> 吴优() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("7727264797", "芙蕖在搬砖"));
		entities.add(new IDNameEntity("7781702861", "Chestnut丨吴优"));
		entities.add(new IDNameEntity("1799982833", "今日无忧丨吴优"));
		entities.add(new IDNameEntity("5186875860", "FAIRY丨吴优"));
		entities.add(new IDNameEntity("5590904347", "吴优全球后援会"));
		entities.add(new IDNameEntity("1877916515", "吴优"));
		entities.add(new IDNameEntity("6898708751", "吴优油菜花工作室"));
		return entities;
	}

	public static Set<IDNameEntity> 吴宣仪() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("6679575878", "FirstLove丨吴宣仪初恋站"));
		entities.add(new IDNameEntity("5608446239", "与归·吴宣仪"));
		entities.add(new IDNameEntity("6872534285", "那年今日丨吴宣仪"));
		entities.add(new IDNameEntity("2657844303", "你爹乐园丨吴宣仪"));
		entities.add(new IDNameEntity("7339651466", "Bking丨吴宣仪"));
		entities.add(new IDNameEntity("7533435405", "RomanticBetty_吴宣仪"));
		entities.add(new IDNameEntity("7532076092", "VortexAperture_吴宣仪"));
		entities.add(new IDNameEntity("6570945531", "JanuaryOpal_吴宣仪"));
		entities.add(new IDNameEntity("6040031599", "Gardenia丨吴宣仪"));
		entities.add(new IDNameEntity("6719740130", "米勒星球丨吴宣仪"));
		entities.add(new IDNameEntity("6602638364", "Coincidence_吴宣仪"));
		entities.add(new IDNameEntity("5796662600", "吴宣仪_Betty"));
		entities.add(new IDNameEntity("7473157651", "吴宣仪的快乐碎片"));
		return entities;
	}

	public static Set<IDNameEntity> 林允() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("6138225849", "林允图文组"));
		entities.add(new IDNameEntity("6597139198", "霞思云想-林允"));
		entities.add(new IDNameEntity("7779944184", "Fairy丨0416林允Jelly"));
		entities.add(new IDNameEntity("5884985164", "BubbleTea丨林允"));
		entities.add(new IDNameEntity("6363000838", "林允的小号r"));
		entities.add(new IDNameEntity("2646681810", "林允Jelly"));
		entities.add(new IDNameEntity("5885799032", "林允Team"));
		return entities;
	}

	public static Set<IDNameEntity> 宋妍霏() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("6168194816", "娜只怪可爱小C"));
		entities.add(new IDNameEntity("7427641706", "CCmermaid"));
		entities.add(new IDNameEntity("6464066846", "Leaf1022_宋妍霏"));
		entities.add(new IDNameEntity("2164553494", "-限定心动贩卖机"));
		entities.add(new IDNameEntity("6218657109", "FallinU·风信丨宋妍霏"));
		entities.add(new IDNameEntity("5985657669", "半糖甜白丨宋妍霏"));
		entities.add(new IDNameEntity("7486518080", "今天宋妍霏在干嘛"));
		entities.add(new IDNameEntity("7659235750", "Cecilia宋妍霏·时光备忘录"));
		entities.add(new IDNameEntity("7292780687", "宋妍霏官方粉丝后援会"));
		entities.add(new IDNameEntity("1915843283", "Cecilia宋妍霏"));
		entities.add(new IDNameEntity("5705673548", "CSIDE宋妍霏工作室"));
		return entities;
	}

	public static Set<IDNameEntity> 韩雪() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1197755162", "韩雪"));
		entities.add(new IDNameEntity("1769202531", "韩雪工作室"));
		entities.add(new IDNameEntity("7030655624", "Bewith韩雪资源小站"));
		entities.add(new IDNameEntity("6080303946", "Happy的哈皮小站"));
//		entities.add(new IDNameEntity("7392463906", "素桃花债La"));
		return entities;
	}

	public static Set<IDNameEntity> 张嘉倪() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("7576796941", "Flechazo-张嘉倪"));
		entities.add(new IDNameEntity("7724780699", "兔子日记·张嘉倪"));
		entities.add(new IDNameEntity("6242790104", "喜欢倪张嘉倪工作室"));
		entities.add(new IDNameEntity("1239315002", "张嘉倪"));
		return entities;
	}

	public static Set<IDNameEntity> 王秀竹() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5187459538", "王秀竹"));
		entities.add(new IDNameEntity("5664713958", "王秀竹工作室"));
		return entities;
	}

	public static Set<IDNameEntity> 王楚然() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("6391231488", "王楚然工作室"));
		entities.add(new IDNameEntity("3828809034", "-王楚然-"));
		entities.add(new IDNameEntity("7591634875", "如梦之旅丨王楚然"));
		entities.add(new IDNameEntity("7899689894", "Eleven十一丨王楚然"));
		return entities;
	}

	public static Set<IDNameEntity> 娜扎() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("6001863056", "娜扎工作室"));
		entities.add(new IDNameEntity("1350995007", "我是娜扎"));
		entities.add(new IDNameEntity("6139969641", "娜么美丽_娜扎"));
		entities.add(new IDNameEntity("7844745279", "Utopia_娜扎"));
		entities.add(new IDNameEntity("6394439453", "StrawberryField0502_娜扎"));
		entities.add(new IDNameEntity("6391118252", "Tuesbelle_娜扎个人图博"));
		entities.add(new IDNameEntity("7555401382", "Redamancy丨娜扎"));
		entities.add(new IDNameEntity("6677421854", "Anonymous_娜扎"));
		entities.add(new IDNameEntity("7207656894", "Johenr·古力娜扎"));
		return entities;
	}

	public static Set<IDNameEntity> 热巴() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1669879400", "Dear-迪丽热巴"));
		entities.add(new IDNameEntity("6269329742", "嘉行迪丽热巴工作室"));
		entities.add(new IDNameEntity("2721687801", "六棱镜丨迪丽热巴"));
		entities.add(new IDNameEntity("7650111634", "半夜汽笛·迪丽热巴"));
		entities.add(new IDNameEntity("6714555117", "心动胶卷丨迪丽热巴"));
		entities.add(new IDNameEntity("6226984623", "FM603丨迪丽热巴"));
		entities.add(new IDNameEntity("7623229686", "NGC2237·迪丽热巴"));
		entities.add(new IDNameEntity("7578426019", "808BASS·迪丽热巴"));
		entities.add(new IDNameEntity("6365021036", "CrushOn·D丨迪丽热巴"));
		entities.add(new IDNameEntity("5595262735", "引力方程0603-迪丽热巴"));
		entities.add(new IDNameEntity("7642523952", "Aphrodite·迪丽热巴"));
		return entities;
	}

	public static Set<IDNameEntity> 张天爱() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5025635043", "张天爱工作室"));
		entities.add(new IDNameEntity("1788283193", "Crystal张天爱"));
		entities.add(new IDNameEntity("3987016433", "张天爱Crystal粉丝会"));
		entities.add(new IDNameEntity("5816671902", "张天爱吧官博"));
		entities.add(new IDNameEntity("6441395399", "QuesoRosa_ZTA"));
		entities.add(new IDNameEntity("7829105098", "Click定格丨张天爱"));
		entities.add(new IDNameEntity("7752230862", "·GodsLove张天爱·"));
		entities.add(new IDNameEntity("2687725604", "GodsLove·张天爱"));
		entities.add(new IDNameEntity("2845335540", "PinkBowknot丨张天爱"));
		return entities;
	}

	public static Set<IDNameEntity> 宋祖儿() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2440179153", "宋祖儿lareina"));
		entities.add(new IDNameEntity("6215719995", "宋祖儿工作室"));
		entities.add(new IDNameEntity("7183239970", "5·23水星记丨宋祖儿"));
		entities.add(new IDNameEntity("7355446449", "Dolphin_小海豚记事本"));
		entities.add(new IDNameEntity("6224018889", "TheWestFor宋祖儿"));
		entities.add(new IDNameEntity("6148560151", "等距離玫瑰-宋祖儿"));
		entities.add(new IDNameEntity("7723801051", "吉祥如意丨宋祖儿"));
		entities.add(new IDNameEntity("6870514929", "Heroine0523_宋祖儿"));
		entities.add(new IDNameEntity("2187530390", "-Estrella-宋祖儿"));
		entities.add(new IDNameEntity("7321971931", "绕日飞行_宋祖儿"));
		entities.add(new IDNameEntity("6861582559", "坠落凡尘·宋祖儿"));
		entities.add(new IDNameEntity("7765048281", "七盏颂恋·宋祖儿"));
		entities.add(new IDNameEntity("7512537913", "sweetieswan_523"));
		entities.add(new IDNameEntity("7191919757", "宋祖儿生图bot"));
		return entities;
	}

	public static Set<IDNameEntity> 欧阳娜娜() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2687827715", "歐陽娜娜Nana"));
		entities.add(new IDNameEntity("5943076204", "歐陽娜娜Nana工作室"));
		entities.add(new IDNameEntity("5934409275", "歐陽娜娜陪伴站For_Nana"));
		entities.add(new IDNameEntity("7519099824", "Deercarol·欧阳娜娜"));
		entities.add(new IDNameEntity("6113559321", "向日班小葵丨欧阳娜娜"));
		entities.add(new IDNameEntity("7508618171", "G大调第一前奏曲·欧阳娜娜"));
		entities.add(new IDNameEntity("6616072960", "欧阳娜娜Na图文博"));
		entities.add(new IDNameEntity("7204118121", "Na丨study丨欧阳娜娜"));
		return entities;
	}

	public static Set<IDNameEntity> 王鸥() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1221923871", "王鸥Angel"));
		entities.add(new IDNameEntity("6020985643", "王鸥工作室"));
		entities.add(new IDNameEntity("1658684945", "海鸟观测日记丨王鸥"));
		entities.add(new IDNameEntity("5868488138", "王鸥Angel图库"));
		entities.add(new IDNameEntity("6083562868", "StarryAngel_王鸥"));
		entities.add(new IDNameEntity("2958820061", "OnlyForAngel·王鸥"));
		entities.add(new IDNameEntity("7859248458", "OATH誓言·王鸥"));
		entities.add(new IDNameEntity("7537137471", "AngelStore_王鸥"));
		entities.add(new IDNameEntity("7286727073", "Black-White-王鸥"));
		return entities;
	}

	public static Set<IDNameEntity> 赵露思() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5653796775", "赵露思的微博"));
		entities.add(new IDNameEntity("7327934610", "赵露思工作室官微"));
		entities.add(new IDNameEntity("7785945817", "Her_赵露思"));
		entities.add(new IDNameEntity("7620757898", "熱吻_趙露思"));
		entities.add(new IDNameEntity("6742246978", "Sweetheart1109丨赵露思"));
		entities.add(new IDNameEntity("7496812362", "起司甜茶·赵露思"));
		entities.add(new IDNameEntity("7468211442", "Lotusleaf_赵露思的时光隧道"));
		entities.add(new IDNameEntity("7907167531", "赵财进宝丨Rosy赵露思"));
		entities.add(new IDNameEntity("7528815696", "Forever_赵露思"));
		entities.add(new IDNameEntity("3089548484", "OvertheRain1109·赵露思"));
		entities.add(new IDNameEntity("7763755148", "RedbayberryRosy_赵露思"));
		entities.add(new IDNameEntity("6169587075", "Brillante1109·赵露思"));
		entities.add(new IDNameEntity("6312621484", "月光藏匿丨赵露思"));
		entities.add(new IDNameEntity("5241449649", "SpringWind·赵露思"));
		entities.add(new IDNameEntity("7370777409", "Starry_赵露思"));
		entities.add(new IDNameEntity("7827280856", "Esperar_1109赵露思"));
		entities.add(new IDNameEntity("7816627117", "Onlyone_赵露思"));
		entities.add(new IDNameEntity("7870691736", "暗夜骑士_赵露思"));
		entities.add(new IDNameEntity("7711209515", "ColuliRosy1109-赵露思"));
		return entities;
	}

	public static Set<IDNameEntity> 程潇() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5790112354", "程潇"));
		entities.add(new IDNameEntity("7474425160", "程潇已上线"));
		entities.add(new IDNameEntity("7518385248", "All程潇_考古博"));
		entities.add(new IDNameEntity("5788865425", "程潇吧_CXBar"));
		entities.add(new IDNameEntity("5725592314", "月夜浔程_"));
		entities.add(new IDNameEntity("7005735672", "星夜兼程Neon·程潇"));
		entities.add(new IDNameEntity("6447243227", "程潇·PIKA发电中"));
		entities.add(new IDNameEntity("5271226175", "OrangeCatcher丨程潇"));
		entities.add(new IDNameEntity("6612401492", "Mellifluous0715丨程潇"));
		entities.add(new IDNameEntity("7777990903", "Eternal_吟韩松琐"));
		entities.add(new IDNameEntity("7835845346", "iocat_零碎小猫"));
		entities.add(new IDNameEntity("7823399659", "babyC_0715"));
		entities.add(new IDNameEntity("1764475655", "_球球球纸"));
		entities.add(new IDNameEntity("2949742691", "漫溯星河"));
		entities.add(new IDNameEntity("2642002604", "oh-大大kimi"));
		entities.add(new IDNameEntity("6406161568", "不讲究的号"));

		return entities;
	}

	public static Set<IDNameEntity> 王紫璇() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1917053352", "王紫璇CiCi"));
		entities.add(new IDNameEntity("5938323171", "王紫璇工作室"));
		entities.add(new IDNameEntity("7729414098", "山野之间_王紫璇"));
		entities.add(new IDNameEntity("7253974196", "Antarctica南极星·王紫璇"));
		entities.add(new IDNameEntity("1011219571", "Chamomile_王紫璇"));
		entities.add(new IDNameEntity("7789141669", "DaisyGarden_王紫璇"));
		return entities;
	}

	public static Set<IDNameEntity> 王玉雯() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2449552120", "王玉雯Uvin"));
		entities.add(new IDNameEntity("7336991317", "王玉雯工作室"));
		entities.add(new IDNameEntity("6251303755", "新雯播报-王玉雯"));
		entities.add(new IDNameEntity("7866982954", "雯声而来_王玉雯"));
		entities.add(new IDNameEntity("1774719045", "trnia_英雯"));
		return entities;
	}

	public static Set<IDNameEntity> 赵今麦() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2106192855", "赵今麦angel"));
		entities.add(new IDNameEntity("6670517617", "赵今麦工作室official"));
		entities.add(new IDNameEntity("5707863261", "晴与雾丨赵今麦"));
		entities.add(new IDNameEntity("7808750260", "MaiPolaroid丨赵今麦"));
		entities.add(new IDNameEntity("7337508397", "Maltose_In_Sep·赵今麦糖站"));
		entities.add(new IDNameEntity("6614201185", "梦中寻·赵今麦"));
		return entities;
	}

	public static Set<IDNameEntity> 蒋依依() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1318119365", "蒋依依"));
		entities.add(new IDNameEntity("7877002193", "蒋依依11号频道"));
		entities.add(new IDNameEntity("7783855304", "摇摇帮小卧底"));
		entities.add(new IDNameEntity("7909366283", "春望山楹·蒋依依"));
		entities.add(new IDNameEntity("2425022790", "ONLY引力丨蒋依依"));
		entities.add(new IDNameEntity("1318119365", "森林无边_"));
		return entities;
	}

	public static Set<IDNameEntity> 张婧仪() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("6387099968", "张婧仪"));
		entities.add(new IDNameEntity("7610808848", "张婧仪工作室"));
		entities.add(new IDNameEntity("2376796901", "JOYLAND·张婧仪"));
		entities.add(new IDNameEntity("6518817886", "PeaPrincess·张婧仪"));
		entities.add(new IDNameEntity("7801988372", "MORPHEUS·张婧仪"));
		entities.add(new IDNameEntity("7801971534", "张婧仪ins"));
		entities.add(new IDNameEntity("7577663706", "PATRONUM-张婧仪"));
		entities.add(new IDNameEntity("6369769560", "今日仪分享丨张婧仪"));
		entities.add(new IDNameEntity("7827225572", "备忘录丨张婧仪"));
		entities.add(new IDNameEntity("7804076708", "DokiDoki张婧仪"));
		return entities;
	}

	public static Set<IDNameEntity> 张予曦() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1662262590", "张予曦"));
		entities.add(new IDNameEntity("5704068886", "张予曦studio"));
		entities.add(new IDNameEntity("7900395839", "AYW丨张予曦"));
		entities.add(new IDNameEntity("2791651933", "南瓜花____"));
		entities.add(new IDNameEntity("6378411686", "张予曦_Stars星辰"));
		entities.add(new IDNameEntity("7808941069", "予_Serendipity聆听曦"));
		entities.add(new IDNameEntity("7740332051", "时予曦光_张予曦"));
		entities.add(new IDNameEntity("7520131264", "胡啊花瓜"));
		entities.add(new IDNameEntity("5701182030", "尔晚夏丨张予曦"));
		entities.add(new IDNameEntity("7847693497", "Neverfall-张予曦"));
		return entities;
	}

	public static Set<IDNameEntity> 陈都灵() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5589792153", "陈都灵"));
		entities.add(new IDNameEntity("6797200800", "陈都灵工作室_"));
		entities.add(new IDNameEntity("7083512236", "芒果October_陈都灵"));
		return entities;
	}

// document.open();document.close(); 
// var data = ;
// data.forEach(item=>{
//    var line = `entities.add(new IDNameEntity("${item.id}", "${item.screen_name}"));`
//    document.write(line);
//    document.write("<br>")
//});

}
