package com.my.crawler.weibo2;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import com.my.crawler.weibo2.Constants.IDNameEntity;

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
	public static final String FAILED_LIST_FILE_NAME = "failed.list";

	public static final String DATE_ID_FORMAT = "%04d-%02d-%02d-%s";
	public static final String DATE_FORMAT = "%04d-%02d-%02d";
	public static final String PICS_ID = "pics";
	public static final String VIDEOS_ID = "videos";
	public static final String TEXT_ID = "text_raw";
	public static final String PAGE_URL_ID = "page_url";
	public static final String PAGE_URL_FORMAT = "https://weibo.com/%s/%s";
	public static final String SCREEN_NAME_ID = "screen_name";
	public static final String TAGS_ID = "tags";

	public static class IDNameEntity implements Comparable<IDNameEntity> {
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
//		entities.add(new IDNameEntity("1749783560", "周扬青"));
		entities.add(new IDNameEntity("5777825630", "小宁姐姐real"));
		entities.add(new IDNameEntity("6404442960", "Ctan是炭炭"));
		entities.add(new IDNameEntity("7873159813", "奥奥咩Ao"));
		entities.add(new IDNameEntity("7912411933", "Yimails"));
		entities.add(new IDNameEntity("3182486392", "易梦玲-"));
		entities.add(new IDNameEntity("5885246452", "宇宙超级无敌美少女之队长崽崽"));
		entities.add(new IDNameEntity("3193535674", "李昀芊"));
		entities.add(new IDNameEntity("2459142683", "Una优娜儿"));
		entities.add(new IDNameEntity("2677652880", "解说天云"));
		entities.add(new IDNameEntity("2707954175", "爱喝美式的美力"));
		entities.add(new IDNameEntity("1853627313", "卓仕琳"));
		entities.add(new IDNameEntity("6130786243", "流星牛角"));
		entities.add(new IDNameEntity("2286190722", "宋可燃"));
		entities.add(new IDNameEntity("5709609378", "婷逸婷"));
		entities.add(new IDNameEntity("1758929805", "张馨月Carina"));
		entities.add(new IDNameEntity("7976325029", "MaryAmber"));
		entities.add(new IDNameEntity("2123222037", "张艺宣viggie"));
		entities.add(new IDNameEntity("5230510382", "曾宥臻"));
		entities.add(new IDNameEntity("2382243211", "hThT__"));
		entities.add(new IDNameEntity("2017376052", "郭四火-"));
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
//		entities.add(new IDNameEntity("7684302341", "蜜桃老师真人"));
		return entities;
	}

	public static Set<IDNameEntity> 明星图片() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("7040041221", "潇骑校尉曹操"));
		entities.add(new IDNameEntity("1233965570", "川外川"));
		entities.add(new IDNameEntity("7772266364", "Rachelcook1995"));
		entities.add(new IDNameEntity("6518263844", "镜头兄"));
		entities.add(new IDNameEntity("6467863545", "tbbhktjj"));
//		entities.add(new IDNameEntity("6472458430", "SkyPictorial"));
		entities.add(new IDNameEntity("1197002213", "男人装"));
		entities.add(new IDNameEntity("2966904732", "美好身体bo"));
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

		entities.add(new IDNameEntity("2433827884", "周依然6"));
		entities.add(new IDNameEntity("1885611142", "孔雪儿"));
		entities.add(new IDNameEntity("3807003830", "张若晞Roxie"));
		entities.add(new IDNameEntity("1649540795", "郭小仙儿-郭珺"));
		entities.add(new IDNameEntity("5677291460", "张婉莹stone"));
		entities.add(new IDNameEntity("1258859614", "我是江一燕"));
		entities.add(new IDNameEntity("1765945663", "李云霄-lyx"));
		entities.add(new IDNameEntity("1758929805", "张馨月Carina"));
		entities.add(new IDNameEntity("1227086635", "霍思燕"));
		entities.add(new IDNameEntity("1224685661", "邓家佳"));
		entities.add(new IDNameEntity("5559031781", "邓家佳工作室"));
		entities.add(new IDNameEntity("1273259633", "司雯嘉"));
		entities.add(new IDNameEntity("2007347307", "孙佳奇Titania"));
		entities.add(new IDNameEntity("1604236990", "斓曦"));
		entities.add(new IDNameEntity("1722594714", "舒淇"));
		entities.add(new IDNameEntity("1725217600", "高海寧"));
		entities.add(new IDNameEntity("1943405723", "钟楚曦"));
		entities.add(new IDNameEntity("1135822512", "倪虹洁"));
		entities.add(new IDNameEntity("1734442735", "汪小敏"));
		entities.add(new IDNameEntity("2595359142", "Yakisa彭雅琦"));
		entities.add(new IDNameEntity("1915458005", "刘湘_11"));
		entities.add(new IDNameEntity("1951027255", "李如儒"));
		entities.add(new IDNameEntity("7914552633", "刘芊螢工作室"));
		entities.add(new IDNameEntity("7499320208", "刘芊螢_LQY"));
		entities.add(new IDNameEntity("5392607329", "焕儿90210"));
		entities.add(new IDNameEntity("3987559881", "赵昭仪_Melek"));
		entities.add(new IDNameEntity("1907518591", "余霜YSCandice"));
		entities.add(new IDNameEntity("1802626467", "M孟佳J"));
		entities.add(new IDNameEntity("7731444226", "明星生图大侦探"));
//		entities.add(new IDNameEntity("6937940705", "金晨工作室"));
		entities.add(new IDNameEntity("1713031610", "金晨"));
//		entities.add(new IDNameEntity("1577680003", "高叶ChLoe"));
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
		entities.add(new IDNameEntity("6221687685", "孙伊雯_"));
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
		entities.add(new IDNameEntity("5658396874", "安雅泰勒乔伊"));
		entities.add(new IDNameEntity("5511171110", "安雅泰勒-乔伊"));
		entities.add(new IDNameEntity("2003380701", "MckennaGraceCN"));
		entities.add(new IDNameEntity("2280514454", "PrettyBarbiesss"));
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
		entities.add(new IDNameEntity("2105498463", "金志垣__LIZ"));
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
		entities.add(new IDNameEntity("3628401054", "老夫子1054"));
		entities.add(new IDNameEntity("3133475081", "旧时写真集"));
		entities.add(new IDNameEntity("5251812591", "小小夏天sami"));
		entities.add(new IDNameEntity("7727697684", "ZERO摄影写真集"));
		entities.add(new IDNameEntity("7655724324", "万米独行田伯光"));
		entities.add(new IDNameEntity("6707377011", "随缘更新希美社"));
		entities.add(new IDNameEntity("7842543071", "永远的梦1988"));
//		entities.add(new IDNameEntity("7720294681", "二号机v"));
//		entities.add(new IDNameEntity("2400603821", "PHOTOIDOL"));
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
		entities.add(new IDNameEntity("5234093606", "日韩动态"));
		entities.add(new IDNameEntity("5494121361", "Papakey中国官方微博"));
		entities.add(new IDNameEntity("5161430241", "花家没有花"));
		entities.add(new IDNameEntity("7879961298", "凉森明里MiaMio"));
		return entities;
	}

	public static Set<IDNameEntity> 日本演员() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("7820233694", "石川澪_Real"));
		entities.add(new IDNameEntity("6536563928", "枫花恋_kaedekaren"));
		entities.add(new IDNameEntity("6345083206", "森泽佳奈_real"));
		entities.add(new IDNameEntity("5330430588", "森泽佳奈_official"));
		entities.add(new IDNameEntity("2232872280", "小嶋阳菜HarunaKojima"));
//		entities.add(new IDNameEntity("6427309237", "橘玛丽_official"));
//		entities.add(new IDNameEntity("3194073462", "水原希子_MetFreckle"));
		entities.add(new IDNameEntity("5474534259", "水原希子_Official"));
		entities.add(new IDNameEntity("6268637382", "铃木友菜的小辫子"));
		entities.add(new IDNameEntity("7195313110", "三吉彩花MiyoshiAyaka"));
		entities.add(new IDNameEntity("7207679455", "光希-Koki"));
		entities.add(new IDNameEntity("5991247442", "胖胖小蛋糕"));
		entities.add(new IDNameEntity("5152487407", "惠亲的惠亲"));
		entities.add(new IDNameEntity("1862896261", "松岡李那LinahM"));
		entities.add(new IDNameEntity("5540080695", "伊藤舞雪_real"));
		entities.add(new IDNameEntity("3561627892", "EstherHeesch吧"));
//		entities.add(new IDNameEntity("7486336543", "希岛爱理Yua"));
		entities.add(new IDNameEntity("5748979953", "八掛海_real"));
		entities.add(new IDNameEntity("1866634995", "瀧本雫葉_real"));
		entities.add(new IDNameEntity("3135715863", "七濑爱丽丝_real"));
		entities.add(new IDNameEntity("1796335245", "小宵虎南_konancmore"));
		entities.add(new IDNameEntity("3987343279", "河北彩伽-元河北彩花"));
		entities.add(new IDNameEntity("5732211644", "河北彩伽"));

		return entities;
	}

	public static Set<IDNameEntity> 生图() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
//		entities.add(new IDNameEntity("6530289599", "Trendmo趋势"));
//
//		entities.add(new IDNameEntity("6078431728", "星伴网娱乐"));
//		entities.add(new IDNameEntity("6459256544", "上戏啦"));
//		entities.add(new IDNameEntity("6891885433", "戏客Seeker"));
//		entities.add(new IDNameEntity("5737793661", "MZSY-木子"));
//		entities.add(new IDNameEntity("5697928291", "剧淘娱乐"));
//		entities.add(new IDNameEntity("6525010965", "狐厂大拷问"));
//		entities.add(new IDNameEntity("7090942012", "星同事"));
//		entities.add(new IDNameEntity("3290016493", "美颜滤镜粉碎机·真实很美好"));
//
		entities.add(new IDNameEntity("7889296993", "星图生图折扣出出出"));
		entities.add(new IDNameEntity("7094749867", "爱豆赏图"));
		entities.add(new IDNameEntity("7548593844", "明星生图鉴赏大全"));
		entities.add(new IDNameEntity("5347967496", "明星生图写真素材"));
		entities.add(new IDNameEntity("5578214762", "明星生图全集"));
//		entities.add(new IDNameEntity("6489906026", "星图驿站"));
//		entities.add(new IDNameEntity("7237314735", "星素鉴赏"));
//		entities.add(new IDNameEntity("7731444226", "明星生图大侦探"));
//		entities.add(new IDNameEntity("7760118734", "星图欣赏i"));
//		entities.add(new IDNameEntity("7828075583", "明星生图大赏V"));
//		entities.add(new IDNameEntity("7399398633", "明星女神时光机"));
//		entities.add(new IDNameEntity("7720744067", "明星生图现场"));
//		entities.add(new IDNameEntity("7471836107", "mxstjz"));
//		entities.add(new IDNameEntity("7689183881", "大作Photo"));
//		entities.add(new IDNameEntity("3176566060", "老叮当GG"));
//		entities.add(new IDNameEntity("7379285492", "生图星赏"));
//		entities.add(new IDNameEntity("7584118653", "明星生图狂魔"));
//		entities.add(new IDNameEntity("7644611287", "明星生图Martin"));
//		entities.add(new IDNameEntity("7790063400", "生图欣赏2023"));
		
//		entities.add(new IDNameEntity("7566511986", "stars生图-"));
//		entities.add(new IDNameEntity("7543862954", "女明星生图-"));
//		entities.add(new IDNameEntity("7500355509", "明星定妆照"));
//		entities.add(new IDNameEntity("7594293642", "水月近星"));
//		entities.add(new IDNameEntity("7748973700", "明星现场生图"));
//		entities.add(new IDNameEntity("7755667765", "素妍星途"));
//		entities.add(new IDNameEntity("7444688404", "全是生图"));
//		entities.add(new IDNameEntity("7749543406", "明星生图合集"));
		return entities;
	}

	public static Set<IDNameEntity> 关晓彤() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1288739185", "关晓彤"));
		entities.add(new IDNameEntity("6100206722", "关晓彤工作室"));
		entities.add(new IDNameEntity("5402265265", "7Gabrielle-关晓彤奇迹站"));
		entities.add(new IDNameEntity("7944592298", "Vlinder·蝴蝶效应丨关晓彤"));
		entities.add(new IDNameEntity("7808129632", "OrangeCc_关晓彤"));

//		entities.add(new IDNameEntity("7677651544", "微醺丨关晓彤"));
//		entities.add(new IDNameEntity("5692909619", "立彤霄丨关晓彤"));
		return entities;
	}

	public static Set<IDNameEntity> 吴优() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1877916515", "吴优"));
		entities.add(new IDNameEntity("6898708751", "吴优油菜花工作室"));
		entities.add(new IDNameEntity("5186875860", "FAIRY丨吴优"));
		
//		entities.add(new IDNameEntity("5590904347", "吴优全球后援会"));
//		entities.add(new IDNameEntity("1799982833", "今日无忧丨吴优"));
//		entities.add(new IDNameEntity("7781702861", "Chestnut丨吴优"));
//		entities.add(new IDNameEntity("7727264797", "芙蕖在搬砖"));
		return entities;
	}

	public static Set<IDNameEntity> 吴宣仪() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5796662600", "吴宣仪_Betty"));
		entities.add(new IDNameEntity("7473157651", "吴宣仪的快乐碎片"));
//		entities.add(new IDNameEntity("6872534285", "那年今日丨吴宣仪"));
		entities.add(new IDNameEntity("5608446239", "与归·吴宣仪"));
		entities.add(new IDNameEntity("7533435405", "RomanticBetty_吴宣仪"));
		entities.add(new IDNameEntity("7532076092", "VortexAperture_吴宣仪"));
		entities.add(new IDNameEntity("5194143726", "你的小希呀_"));

//		entities.add(new IDNameEntity("6602638364", "Coincidence_吴宣仪"));
//		entities.add(new IDNameEntity("6719740130", "米勒星球丨吴宣仪"));
//		entities.add(new IDNameEntity("6040031599", "Gardenia丨吴宣仪"));
//		entities.add(new IDNameEntity("6570945531", "JanuaryOpal_吴宣仪"));
//		entities.add(new IDNameEntity("7339651466", "Bking丨吴宣仪"));
//		entities.add(new IDNameEntity("2657844303", "你爹乐园丨吴宣仪"));
//		entities.add(new IDNameEntity("6679575878", "FirstLove丨吴宣仪初恋站"));
		return entities;
	}

	public static Set<IDNameEntity> 林允() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2646681810", "林允Jelly"));
		entities.add(new IDNameEntity("5885799032", "林允Team"));
		entities.add(new IDNameEntity("6363000838", "林允的小号r"));
		entities.add(new IDNameEntity("7821921085", "长长久久-林允"));

//		entities.add(new IDNameEntity("5884985164", "BubbleTea丨林允"));
//		entities.add(new IDNameEntity("7779944184", "Fairy丨0416林允Jelly"));
//		entities.add(new IDNameEntity("6597139198", "霞思云想-林允"));
//		entities.add(new IDNameEntity("6138225849", "林允图文组"));
		return entities;
	}

	public static Set<IDNameEntity> 宋妍霏() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1915843283", "Cecilia宋妍霏"));
		entities.add(new IDNameEntity("5705673548", "CSIDE宋妍霏工作室"));
		entities.add(new IDNameEntity("7486518080", "今天宋妍霏在干嘛"));
		entities.add(new IDNameEntity("6179584013", "霏页Drift丨宋妍霏"));
		entities.add(new IDNameEntity("7267132157", "zero_oxh"));
		entities.add(new IDNameEntity("7427641706", "CCmermaid"));
		entities.add(new IDNameEntity("2164553494", "-限定心动贩卖机"));
		entities.add(new IDNameEntity("6218657109", "FallinU·风信丨宋妍霏"));
		entities.add(new IDNameEntity("5985657669", "半糖甜白丨宋妍霏"));
		entities.add(new IDNameEntity("7659235750", "Cecilia宋妍霏·时光备忘录"));
		entities.add(new IDNameEntity("7292780687", "宋妍霏官方粉丝后援会"));

//		entities.add(new IDNameEntity("6464066846", "Leaf1022_宋妍霏"));
//		entities.add(new IDNameEntity("6168194816", "娜只怪可爱小C"));
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
		entities.add(new IDNameEntity("1239315002", "张嘉倪"));
		entities.add(new IDNameEntity("6242790104", "喜欢倪张嘉倪工作室"));

//		entities.add(new IDNameEntity("7724780699", "兔子日记·张嘉倪"));
//		entities.add(new IDNameEntity("7576796941", "Flechazo-张嘉倪"));
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
		entities.add(new IDNameEntity("3828809034", "-王楚然-"));
		entities.add(new IDNameEntity("6391231488", "王楚然工作室"));
		entities.add(new IDNameEntity("7591634875", "如梦之旅丨王楚然"));
		entities.add(new IDNameEntity("7899689894", "Eleven十一丨王楚然"));
		entities.add(new IDNameEntity("7655501526", "ANCHOR丨王楚然"));
		entities.add(new IDNameEntity("5790966596", "RandomEvent·王楚然"));
		entities.add(new IDNameEntity("7388132732", "初見FLIPPED丨王楚然")); 
		entities.add(new IDNameEntity("7950630333", "掬水是只猫")); 
		entities.add(new IDNameEntity("1886807073", "Mina_Chuanchuan")); 
		return entities;
	}

	public static Set<IDNameEntity> 娜扎() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1350995007", "我是娜扎"));
		entities.add(new IDNameEntity("6001863056", "娜扎工作室"));

//		entities.add(new IDNameEntity("6677421854", "Anonymous_娜扎"));
//		entities.add(new IDNameEntity("7207656894", "Johenr·古力娜扎"));
//		entities.add(new IDNameEntity("7555401382", "Redamancy丨娜扎"));
//		entities.add(new IDNameEntity("6391118252", "Tuesbelle_娜扎个人图博"));
//		entities.add(new IDNameEntity("6394439453", "StrawberryField0502_娜扎"));
//		entities.add(new IDNameEntity("7844745279", "Utopia_娜扎"));
//		entities.add(new IDNameEntity("6139969641", "娜么美丽_娜扎"));
		return entities;
	}

	public static Set<IDNameEntity> 热巴() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1669879400", "Dear-迪丽热巴"));
		entities.add(new IDNameEntity("6269329742", "嘉行迪丽热巴工作室"));
		entities.add(new IDNameEntity("6365021036", "CrushOn·D丨迪丽热巴"));

//		entities.add(new IDNameEntity("7642523952", "Aphrodite·迪丽热巴"));
//		entities.add(new IDNameEntity("5595262735", "引力方程0603-迪丽热巴"));
//		entities.add(new IDNameEntity("7623229686", "NGC2237·迪丽热巴"));
//		entities.add(new IDNameEntity("6226984623", "FM603丨迪丽热巴"));
//		entities.add(new IDNameEntity("6714555117", "心动胶卷丨迪丽热巴"));
//		entities.add(new IDNameEntity("7650111634", "半夜汽笛·迪丽热巴"));
//		entities.add(new IDNameEntity("2721687801", "六棱镜丨迪丽热巴"));
//		entities.add(new IDNameEntity("7578426019", "808BASS·迪丽热巴"));
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

//		entities.add(new IDNameEntity("2845335540", "PinkBowknot丨张天爱"));
//		entities.add(new IDNameEntity("2687725604", "GodsLove·张天爱"));
//		entities.add(new IDNameEntity("7752230862", "·GodsLove张天爱·"));
		return entities;
	}

	public static Set<IDNameEntity> 宋祖儿() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2440179153", "宋祖儿lareina"));
		entities.add(new IDNameEntity("6215719995", "宋祖儿工作室"));
		entities.add(new IDNameEntity("7355446449", "Dolphin_小海豚记事本"));
		entities.add(new IDNameEntity("6148560151", "等距離玫瑰-宋祖儿"));

//		entities.add(new IDNameEntity("7191919757", "宋祖儿生图bot"));
//		entities.add(new IDNameEntity("7512537913", "sweetieswan_523"));
//		entities.add(new IDNameEntity("7765048281", "七盏颂恋·宋祖儿"));
//		entities.add(new IDNameEntity("6861582559", "坠落凡尘·宋祖儿"));
//		entities.add(new IDNameEntity("7321971931", "绕日飞行_宋祖儿"));
//		entities.add(new IDNameEntity("2187530390", "-Estrella-宋祖儿"));
//		entities.add(new IDNameEntity("6870514929", "Heroine0523_宋祖儿"));
//		entities.add(new IDNameEntity("7723801051", "吉祥如意丨宋祖儿"));
//		entities.add(new IDNameEntity("6224018889", "TheWestFor宋祖儿"));
//		entities.add(new IDNameEntity("7183239970", "5·23水星记丨宋祖儿"));
		return entities;
	}

	public static Set<IDNameEntity> 欧阳娜娜() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2687827715", "歐陽娜娜Nana"));
		entities.add(new IDNameEntity("5943076204", "歐陽娜娜Nana工作室"));
		entities.add(new IDNameEntity("5934409275", "歐陽娜娜陪伴站For_Nana"));
		entities.add(new IDNameEntity("7508618171", "G大调第一前奏曲·欧阳娜娜"));

//		entities.add(new IDNameEntity("7204118121", "Na丨study丨欧阳娜娜"));
//		entities.add(new IDNameEntity("6616072960", "欧阳娜娜Na图文博"));
//		entities.add(new IDNameEntity("6113559321", "向日班小葵丨欧阳娜娜"));
//		entities.add(new IDNameEntity("7519099824", "Deercarol·欧阳娜娜"));
		return entities;
	}

	public static Set<IDNameEntity> 王鸥() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1221923871", "王鸥Angel"));
		entities.add(new IDNameEntity("6020985643", "王鸥工作室"));
		entities.add(new IDNameEntity("1658684945", "海鸟观测日记丨王鸥"));
		entities.add(new IDNameEntity("7859248458", "OATH誓言·王鸥"));

//		entities.add(new IDNameEntity("7286727073", "Black-White-王鸥"));
//		entities.add(new IDNameEntity("7537137471", "AngelStore_王鸥"));
//		entities.add(new IDNameEntity("2958820061", "OnlyForAngel·王鸥"));
//		entities.add(new IDNameEntity("6083562868", "StarryAngel_王鸥"));
//		entities.add(new IDNameEntity("5868488138", "王鸥Angel图库"));
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
		entities.add(new IDNameEntity("7907167531", "赵财进宝丨Rosy赵露思"));
		entities.add(new IDNameEntity("7528815696", "Forever_赵露思"));
		entities.add(new IDNameEntity("7954622203", "KUKULU_赵露思"));
		entities.add(new IDNameEntity("7870691736", "暗夜骑士_赵露思"));
		
//		entities.add(new IDNameEntity("7711209515", "ColuliRosy1109-赵露思"));
//		entities.add(new IDNameEntity("7816627117", "Onlyone_赵露思"));
//		entities.add(new IDNameEntity("7827280856", "Esperar_1109赵露思"));
//		entities.add(new IDNameEntity("7370777409", "Starry_赵露思"));
//		entities.add(new IDNameEntity("5241449649", "SpringWind·赵露思"));
//		entities.add(new IDNameEntity("6312621484", "月光藏匿丨赵露思"));
//		entities.add(new IDNameEntity("6169587075", "Brillante1109·赵露思"));
//		entities.add(new IDNameEntity("7763755148", "RedbayberryRosy_赵露思"));
//		entities.add(new IDNameEntity("3089548484", "OvertheRain1109·赵露思"));
//		entities.add(new IDNameEntity("7468211442", "Lotusleaf_赵露思的时光隧道"));
		return entities;
	}

	public static Set<IDNameEntity> 程潇() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5790112354", "程潇"));
		entities.add(new IDNameEntity("7474425160", "程潇已上线"));
		entities.add(new IDNameEntity("5788865425", "程潇吧_CXBar"));
		entities.add(new IDNameEntity("5725592314", "月夜浔程_"));
		entities.add(new IDNameEntity("7835845346", "iocat_零碎小猫"));
		entities.add(new IDNameEntity("2949742691", "漫溯星河"));
		entities.add(new IDNameEntity("2642002604", "oh-大大kimi"));

//		entities.add(new IDNameEntity("6406161568", "不讲究的号"));
//		entities.add(new IDNameEntity("1764475655", "_球球球纸"));
//		entities.add(new IDNameEntity("7823399659", "babyC_0715"));
//		entities.add(new IDNameEntity("6612401492", "Mellifluous0715丨程潇"));
//		entities.add(new IDNameEntity("5271226175", "OrangeCatcher丨程潇"));
//		entities.add(new IDNameEntity("6447243227", "程潇·PIKA发电中"));
//		entities.add(new IDNameEntity("7005735672", "星夜兼程Neon·程潇"));
//		entities.add(new IDNameEntity("7518385248", "All程潇_考古博"));
//		entities.add(new IDNameEntity("7777990903", "Eternal_吟韩松琐"));
		return entities;
	}

	public static Set<IDNameEntity> 王紫璇() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1917053352", "王紫璇CiCi"));
		entities.add(new IDNameEntity("5938323171", "王紫璇工作室"));
		entities.add(new IDNameEntity("7729414098", "山野之间_王紫璇"));
		entities.add(new IDNameEntity("1011219571", "Chamomile_王紫璇"));
		entities.add(new IDNameEntity("7253974196", "Antarctica南极星·王紫璇"));
		
//		entities.add(new IDNameEntity("7789141669", "DaisyGarden_王紫璇"));
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
		entities.add(new IDNameEntity("6614201185", "梦中寻·赵今麦"));
		entities.add(new IDNameEntity("7934683092", "Echoes·赵今麦"));
		
//		entities.add(new IDNameEntity("7337508397", "Maltose_In_Sep·赵今麦糖站"));
		return entities;
	}

	public static Set<IDNameEntity> 蒋依依() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1318119365", "蒋依依"));
		entities.add(new IDNameEntity("7877002193", "蒋依依11号频道"));
		entities.add(new IDNameEntity("7783855304", "摇摇帮小卧底"));
		entities.add(new IDNameEntity("7909366283", "春望山楹·蒋依依"));
		entities.add(new IDNameEntity("1318119365", "森林无边_"));
		
//		entities.add(new IDNameEntity("2425022790", "ONLY引力丨蒋依依"));
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
		entities.add(new IDNameEntity("6369769560", "今日仪分享丨张婧仪"));
		entities.add(new IDNameEntity("7827225572", "备忘录丨张婧仪"));

//		entities.add(new IDNameEntity("7804076708", "DokiDoki张婧仪"));
//		entities.add(new IDNameEntity("7577663706", "PATRONUM-张婧仪"));
		return entities;
	}

	public static Set<IDNameEntity> 张予曦() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1662262590", "张予曦"));
		entities.add(new IDNameEntity("5704068886", "张予曦studio"));
		entities.add(new IDNameEntity("7520131264", "胡啊花瓜"));
		entities.add(new IDNameEntity("2791651933", "南瓜花____"));
		entities.add(new IDNameEntity("6378411686", "张予曦_Stars星辰"));
		entities.add(new IDNameEntity("7808941069", "予_Serendipity聆听曦"));
		entities.add(new IDNameEntity("5701182030", "尔晚夏丨张予曦"));
		
//		entities.add(new IDNameEntity("7847693497", "Neverfall-张予曦"));
//		entities.add(new IDNameEntity("7740332051", "时予曦光_张予曦"));
//		entities.add(new IDNameEntity("7900395839", "AYW丨张予曦"));
		return entities;
	}

	public static Set<IDNameEntity> 陈都灵() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5589792153", "陈都灵"));
		entities.add(new IDNameEntity("6797200800", "陈都灵工作室_"));
		entities.add(new IDNameEntity("7083512236", "芒果October_陈都灵"));
		entities.add(new IDNameEntity("7961236520", "胡萝卜雨丨陈都灵"));
		return entities;
	}

	public static Set<IDNameEntity> 胡连馨() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5409037849", "胡连馨儿"));
		entities.add(new IDNameEntity("6163077792", "胡连馨studio"));
		entities.add(new IDNameEntity("7431916957", "胡连馨后援会官博"));
		
//		entities.add(new IDNameEntity("7746048399", "今天也想见到你_胡连馨"));
//		entities.add(new IDNameEntity("7800066386", "胡桃夹子丨胡连馨"));
//		entities.add(new IDNameEntity("7851640514", "Veil-胡连馨"));
		return entities;
	}

	public static Set<IDNameEntity> 许佳琪() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("3050737061", "许佳琪kiki"));
		entities.add(new IDNameEntity("7723825329", "许佳琪_OFFICIAL"));
		entities.add(new IDNameEntity("6073816836", "The7thSense_许佳琪"));
		entities.add(new IDNameEntity("6973729551", "HeartSniper_许佳琪"));
		entities.add(new IDNameEntity("7818574196", "SeventhPersonality_许佳琪"));
		entities.add(new IDNameEntity("5986422975", "BrilliantMomentwithQ许佳琪"));

//		entities.add(new IDNameEntity("7394831296", "狐狸渡春记_许佳琪"));
//		entities.add(new IDNameEntity("7413989971", "Escort·许佳琪"));
//		entities.add(new IDNameEntity("7276835241", "Eternity_许佳琪KIKI"));
//		entities.add(new IDNameEntity("6656049413", "墨色狙擊·许佳琪"));
//		entities.add(new IDNameEntity("7359028043", "BlackVelvet·许佳琪"));
//		entities.add(new IDNameEntity("6446516297", "Parkour丨许佳琪"));
//		entities.add(new IDNameEntity("7079972226", "GeheimTraum·许佳琪"));
//		entities.add(new IDNameEntity("7386143465", "SUNSET晓雾日暮·许佳琪"));
//		entities.add(new IDNameEntity("3585212292", "狐狸星球丨许佳琪"));
//		entities.add(new IDNameEntity("7373174930", "Sinkheart许佳琪"));
//		entities.add(new IDNameEntity("3168073007", "0827号战舰丨许佳琪"));
//		entities.add(new IDNameEntity("6140761553", "Melancholy丨许佳琪"));
//		entities.add(new IDNameEntity("7372094965", "PetitPrince0827·许佳琪"));
//		entities.add(new IDNameEntity("1879729705", "KIKIsDelivery_许佳琪"));
//		entities.add(new IDNameEntity("5945832484", "SAILORMOON·许佳琪"));
		return entities;
	}

	public static Set<IDNameEntity> 杨幂() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1195242865", "杨幂"));
		entities.add(new IDNameEntity("2744950651", "杨幂工作室"));
		entities.add(new IDNameEntity("6427553901", "CrescentMI·杨幂·"));
		entities.add(new IDNameEntity("6458560128", "Unicorn0912·杨幂"));
		entities.add(new IDNameEntity("6588978280", "Mercury水星記·杨幂"));
		entities.add(new IDNameEntity("7587903509", "玫瑰劇場·杨幂"));
		entities.add(new IDNameEntity("5247499601", "MISSING丨杨幂"));
		entities.add(new IDNameEntity("5427574026", "YUMMYMI杨幂"));
		entities.add(new IDNameEntity("7761776121", "采莲子HYLL_杨幂"));
		entities.add(new IDNameEntity("7876853381", "SH肆季-杨幂"));
		entities.add(new IDNameEntity("7805882892", "TracesEchoes杨幂"));
		entities.add(new IDNameEntity("6229469807", "OriginalForest_杨幂"));
		entities.add(new IDNameEntity("7878165964", "Telepathy_MI"));
		entities.add(new IDNameEntity("6229469807", "OriginalForest_杨幂"));
		entities.add(new IDNameEntity("7955872415", "时序TimeSequence_杨幂"));

//		entities.add(new IDNameEntity("7756247751", "EscapeNight·杨幂"));
//		entities.add(new IDNameEntity("7695102608", "Serendipity·杨幂"));
//		entities.add(new IDNameEntity("7280113896", "心动Everysecond-杨幂"));
		return entities;
	}
	public static Set<IDNameEntity> 孟佳() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1802626467", "M孟佳J"));
		entities.add(new IDNameEntity("6361119454", "孟佳工作室"));
		entities.add(new IDNameEntity("7623226478", "飞鸽传书0203-孟佳"));
		entities.add(new IDNameEntity("7340519783", "MC·JIA丨孟佳"));
		
//		entities.add(new IDNameEntity("5312934809", "AQR0203丨孟佳"));
//		entities.add(new IDNameEntity("7545877161", "JIA·Butterfly丨孟佳"));
//		entities.add(new IDNameEntity("6681178916", "PrivateRose_孟佳"));
//		entities.add(new IDNameEntity("7558075075", "寻鸽日记丨孟佳"));
//		entities.add(new IDNameEntity("5850310051", "有JIA鸽舍丨孟佳小站"));
		return entities;
	}
	public static Set<IDNameEntity> 秦岚() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("6062055731", "秦岚工作室"));
		entities.add(new IDNameEntity("1192329893", "秦岚"));
		entities.add(new IDNameEntity("7107328873", "相遇FourSeasons_秦岚"));
		entities.add(new IDNameEntity("6444834177", "白日梦Fantasy_秦岚0717"));
		entities.add(new IDNameEntity("7366922780", "岚心_Love秦岚"));
		entities.add(new IDNameEntity("7559836658", "局部包郵丨秦岚"));
		entities.add(new IDNameEntity("7857037634", "懒思日记丨Journalfor秦岚"));
		entities.add(new IDNameEntity("7928068699", "Phalaenopsis丨秦岚"));
		
//		entities.add(new IDNameEntity("1814726347", "限時可見丨秦岚"));
//		entities.add(new IDNameEntity("6664681946", "苏打水0717_秦岚"));
//		entities.add(new IDNameEntity("6232829324", "马岚山·美少女__秦岚"));
		return entities;
	}
	public static Set<IDNameEntity> 范冰冰() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("3952070245", "范冰冰"));
		entities.add(new IDNameEntity("2292986033", "范冰冰工作室"));
		entities.add(new IDNameEntity("1254133000", "范冰冰粉丝团"));
		entities.add(new IDNameEntity("6058837784", "范冰冰吧"));
		entities.add(new IDNameEntity("5977305776", "Krystal-27"));
		entities.add(new IDNameEntity("2653045491", "Jersey张馨灵"));
		return entities;
	}
	public static Set<IDNameEntity> 蔡文静() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1428392852", "蔡文静"));
		entities.add(new IDNameEntity("6043275728", "蔡文静工作室"));
		entities.add(new IDNameEntity("7914320535", "我想静静_蔡文静"));
		entities.add(new IDNameEntity("3858277778", "FallingMeteor丨蔡文静"));
		entities.add(new IDNameEntity("3059787291", "BabyJam·蔡文静"));
		
//		entities.add(new IDNameEntity("5332818741", "溯洄从之·蔡文静"));
		return entities;
	}
	public static Set<IDNameEntity> 白鹿() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2616380702", "白鹿my"));
		entities.add(new IDNameEntity("7555511345", "白鹿资讯站"));
		entities.add(new IDNameEntity("7484269836", "Alongtheway妍途·白鹿"));
		entities.add(new IDNameEntity("7770468125", "Alwayswithyou·白鹿"));
		entities.add(new IDNameEntity("7464227091", "一盏茸光丨白鹿"));
		entities.add(new IDNameEntity("7950859763", "Heart_白鹿"));
		entities.add(new IDNameEntity("7951112334", "Spoil_白鹿"));
		return entities;
	}
	public static Set<IDNameEntity> 倪妮() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2554404125", "倪妮V"));
		entities.add(new IDNameEntity("3014125367", "倪妮工作室"));
		entities.add(new IDNameEntity("3846133223", "倪妮ins搬运工"));
		entities.add(new IDNameEntity("7974473396", "InfiNityAmor丨倪妮"));
		entities.add(new IDNameEntity("7489613730", "北纬26度想Ni·倪妮"));
		entities.add(new IDNameEntity("7309784142", "Penicillin·倪妮"));
		
//		entities.add(new IDNameEntity("5866148360", "倪妮杂志汇总"));
//		entities.add(new IDNameEntity("7457436869", "KleinBlue·倪妮"));
		return entities;
	}
	public static Set<IDNameEntity> 黛薇卡() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("6157517778", "倾心之夏_Odelia"));
		entities.add(new IDNameEntity("7904896004", "黛薇卡Mai"));
		entities.add(new IDNameEntity("7753156169", "OnlyFor_MaiDavika"));
		entities.add(new IDNameEntity("5891755165", "MAIDAVIKA"));
		return entities;
	}
	public static Set<IDNameEntity> 李一桐() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5372556014", "李一桐Q"));
		entities.add(new IDNameEntity("5973698579", "李一桐工作室"));
		entities.add(new IDNameEntity("7589216489", "今夜小雪·李一桐"));
		entities.add(new IDNameEntity("2807852834", "906AM丨李一桐"));
		entities.add(new IDNameEntity("5850875384", "Pokemon_Tung丨李一桐"));
		entities.add(new IDNameEntity("1850120983", "Beckoning_李一桐"));
		return entities;
	}
	public static Set<IDNameEntity> 周洁琼() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("6434760509", "周洁琼JIE"));
		entities.add(new IDNameEntity("7360594033", "周洁琼工作室官微"));
		entities.add(new IDNameEntity("5896692979", "周洁琼_Pinky琵琶"));
		entities.add(new IDNameEntity("5859100281", "周洁琼-Squirtle"));
		entities.add(new IDNameEntity("7971129171", "Jietaime·周洁琼"));
		entities.add(new IDNameEntity("7502919453", "周洁琼_Guardian1216"));
		
//		entities.add(new IDNameEntity("7630125215", "CAPTURETIME丨周洁琼"));
//		entities.add(new IDNameEntity("6545880369", "周洁琼·Cherrysoda1216"));
//		entities.add(new IDNameEntity("7257766575", "Gummybear1216丨周洁琼"));
		return entities;
	}
	public static Set<IDNameEntity> 王鹤润() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("3809672324", "王鹤润rain"));
		entities.add(new IDNameEntity("6346476844", "王鹤润工作室"));
		entities.add(new IDNameEntity("5869476441", "王鹤润官方后援会"));
		entities.add(new IDNameEntity("7967981549", "Accompany丨王鹤润"));
		entities.add(new IDNameEntity("7952653973", "Hi_Rain王鹤润"));
//		
//		entities.add(new IDNameEntity("7210289301", "一期一润丨王鹤润"));
//		entities.add(new IDNameEntity("7380128704", "Sunflower-王鹤润"));
//		entities.add(new IDNameEntity("7880153346", "Flechazo恋爱权-王鹤润"));
//		entities.add(new IDNameEntity("7533346493", "她的来信_Rain王鹤润"));
//		entities.add(new IDNameEntity("7883266941", "壹玖玖肆-王鹤润"));
//		entities.add(new IDNameEntity("5636534867", "SweetRain玉润冰甜_王鹤润"));
		return entities;
	}
	public static Set<IDNameEntity> 孟子义() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2569522534", "孟子义"));
		entities.add(new IDNameEntity("6556217546", "孟子义工作室"));
		entities.add(new IDNameEntity("7912300269", "Night丨孟子义"));
		entities.add(new IDNameEntity("7972669430", "PINKTOXIC丨孟子义"));
		entities.add(new IDNameEntity("7930880989", "BLOSSOM丨孟子义"));
		entities.add(new IDNameEntity("7961738503", "GOLD-孟子义"));
		entities.add(new IDNameEntity("7970838701", "A_Rose丨孟子义"));
		entities.add(new IDNameEntity("7984535034", "MUSE-孟子义"));
		
		entities.add(new IDNameEntity("7476659402", "1205Reike_孟子义"));
		entities.add(new IDNameEntity("6219252164", "爱义共感_孟子义"));
		entities.add(new IDNameEntity("7880153346", "Flechazo恋爱权-王鹤润"));
		entities.add(new IDNameEntity("6094669604", "Insieme1205_孟子义"));
		return entities;
	}
	public static Set<IDNameEntity> 李沁() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1809054937", "李沁"));
		entities.add(new IDNameEntity("6057355845", "李沁工作室"));
		entities.add(new IDNameEntity("7348697838", "ooze0927丨李沁"));
		entities.add(new IDNameEntity("6474028423", "有一种风格叫李沁"));
		
//		entities.add(new IDNameEntity("6577369106", "周末航班0927·李沁"));
		return entities;
	}
	public static Set<IDNameEntity> 江疏影() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("1549364094", "江疏影"));
		entities.add(new IDNameEntity("5902979020", "江疏影工作室"));
		entities.add(new IDNameEntity("3980415650", "0901的暖阳"));
		entities.add(new IDNameEntity("7471004776", "欢赢光临·江疏影"));
		
//		entities.add(new IDNameEntity("7284275957", "坠落星空·江疏影"));
//		entities.add(new IDNameEntity("5991775524", "江疏影veg站站"));
//		entities.add(new IDNameEntity("1367796410", "APHRODITE0901_江疏影"));
//		entities.add(new IDNameEntity("6882676148", "一包榨菜江疏影"));
//		entities.add(new IDNameEntity("7213765542", "Begonia-江疏影"));
		return entities;
	}

	public static Set<IDNameEntity> 明星1() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("7912411933", "Yimails"));
		entities.add(new IDNameEntity("3182486392", "易梦玲-"));
		entities.add(new IDNameEntity("1715351501", "辛芷蕾"));
		entities.add(new IDNameEntity("5945340823", "辛芷蕾工作室"));
		entities.add(new IDNameEntity("1229385395", "董璇"));
		entities.add(new IDNameEntity("1741661732", "顾璇"));
		entities.add(new IDNameEntity("1307243944", "李依晓"));
		entities.add(new IDNameEntity("1313228221", "李佳桐sep"));
		entities.add(new IDNameEntity("1222062284", "张萌"));
		entities.add(new IDNameEntity("6368929929", "王子文工作室微博"));
		entities.add(new IDNameEntity("1957663211", "张芷溪"));
		entities.add(new IDNameEntity("1237313773", "热依扎"));
		entities.add(new IDNameEntity("1712539910", "陈乔恩"));
		entities.add(new IDNameEntity("6321557477", "蓝盈莹工作室"));
		entities.add(new IDNameEntity("1802626467", "M孟佳J"));
		entities.add(new IDNameEntity("1500894097", "朱珠ZhuZhu"));
		entities.add(new IDNameEntity("5954919139", "蒋梦婕工作室"));
		entities.add(new IDNameEntity("6163077792", "胡连馨studio"));
		entities.add(new IDNameEntity("5372556014", "李一桐Q"));
		entities.add(new IDNameEntity("5853484329", "舒畅工作室"));
		entities.add(new IDNameEntity("1241314924", "杨子姗"));
		entities.add(new IDNameEntity("6556217546", "孟子义工作室"));
		entities.add(new IDNameEntity("6242790104", "喜欢倪张嘉倪工作室"));
		entities.add(new IDNameEntity("7758220316", "薛凯琪Studio"));
		entities.add(new IDNameEntity("7640055211", "孙芮工作室"));
		entities.add(new IDNameEntity("1320135280", "袁姗姗"));
		entities.add(new IDNameEntity("1788283193", "Crystal张天爱"));
		entities.add(new IDNameEntity("1304048383", "李若嘉"));
		entities.add(new IDNameEntity("7842391335", "NINGx2宁艺卓"));
		entities.add(new IDNameEntity("1756505647", "Ming奚梦瑶"));
		entities.add(new IDNameEntity("2440179153", "宋祖儿lareina"));
		entities.add(new IDNameEntity("5473880509", "诗诗的小板报"));
		entities.add(new IDNameEntity("2007341923", "代斯daisy"));
		entities.add(new IDNameEntity("5418804832", "张慧雯工作室wen"));
		entities.add(new IDNameEntity("5230898012", "文咏珊工作室"));
		entities.add(new IDNameEntity("2411492615", "红星坞娱乐传媒"));
		entities.add(new IDNameEntity("1944091470", "徐小舒_"));
		entities.add(new IDNameEntity("1262719025", "毛林林NIKITA"));
		entities.add(new IDNameEntity("1798111971", "在下黄尧"));
		entities.add(new IDNameEntity("1941345837", "黄梦莹maggie"));
		entities.add(new IDNameEntity("1873771623", "康可人"));
		entities.add(new IDNameEntity("1327036111", "于明加Lorla"));
		entities.add(new IDNameEntity("1254878080", "常鹤凡Cindy"));
		entities.add(new IDNameEntity("1838905357", "安悦溪"));
		entities.add(new IDNameEntity("2002453951", "唐紫睿Hazel"));
		entities.add(new IDNameEntity("1603034341", "苗苗-vivi"));
		entities.add(new IDNameEntity("1738498871", "马思纯"));
		entities.add(new IDNameEntity("1280761142", "刘雯"));
		entities.add(new IDNameEntity("3285031871", "刘美彤"));
		entities.add(new IDNameEntity("6276289472", "演员-刘佳"));
		entities.add(new IDNameEntity("6872420512", "彭小苒工作室"));
		entities.add(new IDNameEntity("1590144567", "潘霜霜Shayla"));
		entities.add(new IDNameEntity("1895567845", "潘晓婷"));
		entities.add(new IDNameEntity("1824780557", "柴柴柴碧云"));
		entities.add(new IDNameEntity("1848949921", "姜珮瑶"));
		entities.add(new IDNameEntity("7372106981", "孔雪儿Snow事务所"));
		entities.add(new IDNameEntity("1218494871", "施予斐"));
		entities.add(new IDNameEntity("1260427471", "何泓姗VivaHo"));
		entities.add(new IDNameEntity("1728945512", "何超蓮Laurinda"));
		entities.add(new IDNameEntity("1748699555", "许雅婷Kabby"));
		entities.add(new IDNameEntity("3050737061", "许佳琪kiki"));
		entities.add(new IDNameEntity("7322506850", "许玮甯FansClub"));
		entities.add(new IDNameEntity("1211836225", "杨雪"));
		entities.add(new IDNameEntity("1285420734", "杨童舒"));
		entities.add(new IDNameEntity("1630504061", "杨净如"));
		entities.add(new IDNameEntity("1774182292", "杨采钰Ora"));
		entities.add(new IDNameEntity("1837360030", "杨之楹"));
		entities.add(new IDNameEntity("5829543885", "陈钰琪Yukee"));
		entities.add(new IDNameEntity("1235069760", "吴静一就是我"));
		entities.add(new IDNameEntity("1877916515", "吴优"));
		entities.add(new IDNameEntity("7473157651", "吴宣仪的快乐碎片"));
		entities.add(new IDNameEntity("1197069394", "周韦彤Cica"));
		entities.add(new IDNameEntity("1705338574", "周秀娜Chrissienana"));
		entities.add(new IDNameEntity("2131819280", "i周迅"));
		entities.add(new IDNameEntity("1557349447", "孙耀琦"));
		entities.add(new IDNameEntity("3669091483", "孙芮"));
		entities.add(new IDNameEntity("5983451319", "孙千"));
		entities.add(new IDNameEntity("1266788915", "赵文琪"));
		entities.add(new IDNameEntity("1526451275", "赵樱子"));
		entities.add(new IDNameEntity("1780676151", "赵奕欢Chloe"));
		entities.add(new IDNameEntity("3034045004", "赵蕴卓同学"));
		entities.add(new IDNameEntity("1233614375", "李倩real"));
		entities.add(new IDNameEntity("1265743747", "李兰迪"));
		entities.add(new IDNameEntity("1661202865", "李欣汝"));
		entities.add(new IDNameEntity("1726644942", "李嘉欣Michele"));
		entities.add(new IDNameEntity("1736695537", "李昕岳Sienna"));
		entities.add(new IDNameEntity("2808966557", "李凱馨Eleanor"));
		entities.add(new IDNameEntity("6530832577", "李兰迪Official"));
		entities.add(new IDNameEntity("1632538541", "演员王智"));
		entities.add(new IDNameEntity("1819744725", "王乐君"));
		entities.add(new IDNameEntity("6634138844", "王媛可工作室"));
		entities.add(new IDNameEntity("1858019230", "袁嘉敏Kaman"));
		entities.add(new IDNameEntity("7474425160", "程潇已上线"));
		entities.add(new IDNameEntity("1659390800", "蒋梦婕"));
		entities.add(new IDNameEntity("2889149433", "蒋勤勤"));
		entities.add(new IDNameEntity("5368454432", "奚梦瑶Studio"));
		entities.add(new IDNameEntity("5455220518", "景甜Studio"));
		entities.add(new IDNameEntity("6028401108", "李纯Studio"));
		entities.add(new IDNameEntity("6098499772", "苗苗studio"));
		entities.add(new IDNameEntity("6246325804", "陈妍希Studio"));
		entities.add(new IDNameEntity("7657809193", "何超莲Studio"));
		entities.add(new IDNameEntity("1172294045", "张含韵"));
		entities.add(new IDNameEntity("1196624615", "张梓琳"));
		entities.add(new IDNameEntity("1262456801", "张歆艺"));
		entities.add(new IDNameEntity("1274518607", "张彤"));
		entities.add(new IDNameEntity("2130434435", "张韶涵"));
		entities.add(new IDNameEntity("5704068886", "张予曦studio"));
		entities.add(new IDNameEntity("7610808848", "张婧仪工作室"));
		entities.add(new IDNameEntity("7723825329", "许佳琪_OFFICIAL"));
		entities.add(new IDNameEntity("6463277233", "娜然Naran"));
		entities.add(new IDNameEntity("1819325063", "ice艾晓琪"));
		entities.add(new IDNameEntity("1829351520", "艾尚真"));
		entities.add(new IDNameEntity("6361119454", "孟佳工作室"));
		entities.add(new IDNameEntity("2390774047", "章子怡工作室"));
		entities.add(new IDNameEntity("2730123575", "孙怡工作室"));
		entities.add(new IDNameEntity("5157038370", "赵丽颖工作室"));
		entities.add(new IDNameEntity("5464750286", "董维嘉工作室"));
		entities.add(new IDNameEntity("5984352414", "李菲儿工作室"));
		entities.add(new IDNameEntity("6124543369", "董璇工作室"));
		entities.add(new IDNameEntity("6304276977", "周雨彤工作室"));
		entities.add(new IDNameEntity("6323957970", "梁洁工作室"));
		entities.add(new IDNameEntity("7920554800", "鞠婧祎_Official"));
		entities.add(new IDNameEntity("6346966579", "鞠婧祎个人工作室"));
		entities.add(new IDNameEntity("6391231488", "王楚然工作室"));
		entities.add(new IDNameEntity("6409176005", "杨丞琳工作室"));
		entities.add(new IDNameEntity("6512224059", "杨童舒工作室"));
		entities.add(new IDNameEntity("6523291767", "吴千语工作室"));
		entities.add(new IDNameEntity("6635781168", "徐洁儿工作室"));
		entities.add(new IDNameEntity("6797200800", "陈都灵工作室_"));
		entities.add(new IDNameEntity("7360594033", "周洁琼工作室官微"));
		entities.add(new IDNameEntity("7447677038", "杨超越工作室"));
		entities.add(new IDNameEntity("1913244047", "钟楚曦工作室"));
		entities.add(new IDNameEntity("2012998250", "张馨予工作室"));
		entities.add(new IDNameEntity("2292986033", "范冰冰工作室"));
		entities.add(new IDNameEntity("2626304873", "杨颖工作室"));
		entities.add(new IDNameEntity("3719104540", "王智工作室"));
		entities.add(new IDNameEntity("5690876593", "杨蓉工作室"));
		entities.add(new IDNameEntity("5973698579", "李一桐工作室"));
		entities.add(new IDNameEntity("6138359020", "毛晓彤工作室"));
		entities.add(new IDNameEntity("6320382376", "苏青工作室"));
		entities.add(new IDNameEntity("6355674955", "童瑶工作室"));
		entities.add(new IDNameEntity("6590217564", "曾黎工作室微博"));
		entities.add(new IDNameEntity("6707016858", "李溪芮工作室"));
		entities.add(new IDNameEntity("7094432554", "李小冉工作室"));
		entities.add(new IDNameEntity("7327934610", "赵露思工作室官微"));
		entities.add(new IDNameEntity("7335040269", "朱珠工作室官方微博"));
		entities.add(new IDNameEntity("7389767441", "黄圣依工作室"));
		entities.add(new IDNameEntity("1750107832", "陳喬恩工作室"));
		entities.add(new IDNameEntity("1827485102", "刘萌萌工作室"));
		entities.add(new IDNameEntity("2309719057", "吴倩工作室"));
		entities.add(new IDNameEntity("2386048403", "高圆圆工作室"));
		entities.add(new IDNameEntity("2931242653", "宋佳工作室"));
		entities.add(new IDNameEntity("3014125367", "倪妮工作室"));
		entities.add(new IDNameEntity("3234057332", "刘芸工作室官方微博"));
		entities.add(new IDNameEntity("5617960493", "徐璐工作室"));
		entities.add(new IDNameEntity("5799804656", "阚清子工作室"));
		entities.add(new IDNameEntity("5816652783", "马苏工作室"));
		entities.add(new IDNameEntity("5938323171", "王紫璇工作室"));
		entities.add(new IDNameEntity("5943076204", "歐陽娜娜Nana工作室"));
		entities.add(new IDNameEntity("6144131561", "张子枫工作室"));
		entities.add(new IDNameEntity("6159468263", "陈数工作室"));
		entities.add(new IDNameEntity("6670517617", "赵今麦工作室official"));
		entities.add(new IDNameEntity("7120430358", "刘涛tamia工作室"));
		entities.add(new IDNameEntity("1769202531", "韩雪工作室"));
		entities.add(new IDNameEntity("2540665637", "李冰冰工作室"));
		entities.add(new IDNameEntity("2814849003", "张雨绮工作室"));
		entities.add(new IDNameEntity("3516848557", "王丽坤工作室"));
		entities.add(new IDNameEntity("3701559511", "杨子姗工作室"));
		entities.add(new IDNameEntity("3867221552", "周冬雨工作室"));
		entities.add(new IDNameEntity("5025635043", "张天爱工作室"));
		entities.add(new IDNameEntity("5295502496", "袁姗姗工作室"));
		entities.add(new IDNameEntity("5849579100", "张雪迎Sophie工作室"));
		entities.add(new IDNameEntity("5902979020", "江疏影工作室"));
		entities.add(new IDNameEntity("5903871159", "俞飞鸿工作室"));
		entities.add(new IDNameEntity("5999766824", "万茜工作室"));
		entities.add(new IDNameEntity("6001863056", "娜扎工作室"));
		entities.add(new IDNameEntity("6215719995", "宋祖儿工作室"));
		entities.add(new IDNameEntity("6269329742", "嘉行迪丽热巴工作室"));
		entities.add(new IDNameEntity("6324570962", "张钧甯工作室"));
		entities.add(new IDNameEntity("6681522638", "郭碧婷Bea工作室"));
		entities.add(new IDNameEntity("5705673548", "CSIDE宋妍霏工作室"));
		entities.add(new IDNameEntity("6219767932", "乔欣工作室"));
		entities.add(new IDNameEntity("2744950651", "杨幂工作室"));
		entities.add(new IDNameEntity("6100206722", "关晓彤工作室"));
		return entities;
	}
	public static Set<IDNameEntity> 明星2() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("2548926044", "林妍柔"));
		entities.add(new IDNameEntity("1747837917", "林逸欣Shara"));
		entities.add(new IDNameEntity("1751986312", "Zmx曾梦雪"));
		entities.add(new IDNameEntity("1624095323", "曲尼次仁"));
		entities.add(new IDNameEntity("6053090489", "王影璐_"));
		entities.add(new IDNameEntity("2868803181", "罗秋韵-Wendy"));
		entities.add(new IDNameEntity("1632234453", "蓝心ZoeZhang"));
		entities.add(new IDNameEntity("1731864915", "李施嬅selena"));
		entities.add(new IDNameEntity("6074810564", "高叶工作室"));
		entities.add(new IDNameEntity("1970193877", "刘令姿__"));
		entities.add(new IDNameEntity("7565710132", "刘令姿的彤话书"));
		entities.add(new IDNameEntity("1765945663", "李云霄-lyx"));
		entities.add(new IDNameEntity("7336991317", "王玉雯工作室"));
		entities.add(new IDNameEntity("1791633801", "胡冰卿"));
		entities.add(new IDNameEntity("2717603311", "李則慧"));
		entities.add(new IDNameEntity("1679517897", "Nana谈莉娜"));
		entities.add(new IDNameEntity("1349044517", "董维嘉"));
		entities.add(new IDNameEntity("7887248910", "黄尧工作室"));
		entities.add(new IDNameEntity("1428392852", "蔡文静"));
		entities.add(new IDNameEntity("2932188335", "肖雨Sylvia"));
		entities.add(new IDNameEntity("5409037849", "胡连馨儿"));
		entities.add(new IDNameEntity("2180249535", "马心瑞_Marie"));
		entities.add(new IDNameEntity("6520171114", "劉穎鏇_Tiffany"));
		entities.add(new IDNameEntity("1731313694", "唐詩詠Natalie"));
		entities.add(new IDNameEntity("3974745953", "By2_Miko孙涵"));
		entities.add(new IDNameEntity("1075715583", "袁冰妍"));
		entities.add(new IDNameEntity("3106248957", "孙佳雨_PaNdA"));
		entities.add(new IDNameEntity("1642337390", "韩晓"));
		entities.add(new IDNameEntity("1874288121", "王瑞子715"));
		entities.add(new IDNameEntity("1258824907", "高露"));
		entities.add(new IDNameEntity("1307651590", "陳意涵"));
		entities.add(new IDNameEntity("2219969573", "祝绪丹Bambi"));
		entities.add(new IDNameEntity("1768305123", "贾静雯"));
		entities.add(new IDNameEntity("1733838873", "鍾欣潼"));
		entities.add(new IDNameEntity("1744825334", "蔡卓妍"));
		entities.add(new IDNameEntity("1305651895", "车晓"));
		entities.add(new IDNameEntity("1635105850", "关慧卿hq"));
		entities.add(new IDNameEntity("1280435871", "YUNAN男男"));
		entities.add(new IDNameEntity("1522622622", "李彩华rainli李彩桦"));
		entities.add(new IDNameEntity("1013657184", "邬靖靖"));
		entities.add(new IDNameEntity("3476825950", "曲芷含"));
		entities.add(new IDNameEntity("1668712097", "邓莎"));
		entities.add(new IDNameEntity("1730336902", "大S"));
		entities.add(new IDNameEntity("1842601547", "殷旭2011"));
		entities.add(new IDNameEntity("1193250954", "陈紫函"));
		entities.add(new IDNameEntity("1357579865", "牛莉"));
		entities.add(new IDNameEntity("1193254871", "田海蓉"));
		entities.add(new IDNameEntity("2769149134", "星时代杨钰莹"));
		entities.add(new IDNameEntity("6559685576", "陳慧琳-KellyChen"));
		entities.add(new IDNameEntity("1704116960", "小S"));
		entities.add(new IDNameEntity("5211643249", "哈妮克孜"));
		entities.add(new IDNameEntity("1356289201", "赵柯"));
		entities.add(new IDNameEntity("1352611904", "-傅晶-"));
		entities.add(new IDNameEntity("1678682530", "陈秀丽630"));
		entities.add(new IDNameEntity("1193256814", "胡静"));
		entities.add(new IDNameEntity("1737350632", "麦迪娜"));
		entities.add(new IDNameEntity("6403553546", "巩俐是有粉丝的"));
		entities.add(new IDNameEntity("5779215743", "吴靖萱"));
		entities.add(new IDNameEntity("6029591417", "王晓晨工作室"));
		entities.add(new IDNameEntity("6741964788", "周也yeah"));
		entities.add(new IDNameEntity("1744080731", "葛布"));
		entities.add(new IDNameEntity("1752919037", "甘露Vera"));
		entities.add(new IDNameEntity("1727687652", "章乐韵"));
		entities.add(new IDNameEntity("2303490360", "郑合惠子"));
		entities.add(new IDNameEntity("1503718664", "演员牟星"));
		entities.add(new IDNameEntity("6407628036", "李念工作室"));
		entities.add(new IDNameEntity("1277316722", "高洋"));
		entities.add(new IDNameEntity("6503815411", "柯蓝工作室"));
		entities.add(new IDNameEntity("1277053657", "陈芋米"));
		entities.add(new IDNameEntity("1599134143", "白卉子"));
		entities.add(new IDNameEntity("2616380702", "白鹿my"));
		entities.add(new IDNameEntity("1197930844", "林熙蕾"));
		entities.add(new IDNameEntity("5451204214", "studio_KTC"));
		entities.add(new IDNameEntity("2153913104", "Karena吳千語"));
		entities.add(new IDNameEntity("1374841922", "赵昕zhaozhao"));
		entities.add(new IDNameEntity("1691008262", "演员杨力蕲"));
		entities.add(new IDNameEntity("1564417750", "演员邢宇菲"));
		entities.add(new IDNameEntity("1671545692", "周放是个小欢喜"));
		entities.add(new IDNameEntity("7473093519", "傅菁工作室Official"));
		entities.add(new IDNameEntity("5058591689", "颖儿工作室"));
		entities.add(new IDNameEntity("6425537032", "弦子工作室"));
		entities.add(new IDNameEntity("6128880967", "杨雨潼Nice"));
		entities.add(new IDNameEntity("1215091561", "徐百慧V"));
		entities.add(new IDNameEntity("2304209827", "殷桃"));
		entities.add(new IDNameEntity("1807776872", "陈欣予maggie"));
		entities.add(new IDNameEntity("1861203461", "姜妍二胖"));
		entities.add(new IDNameEntity("1237973207", "爱戴Edell"));
		entities.add(new IDNameEntity("2323836621", "击剑孙一文"));
		entities.add(new IDNameEntity("2113270200", "毛晓慧是一朵毛大球"));
		entities.add(new IDNameEntity("1804399107", "张纯烨微博"));
		entities.add(new IDNameEntity("1813620273", "赖雨濛"));
		entities.add(new IDNameEntity("1210604004", "蓝心妍"));
		entities.add(new IDNameEntity("6043275728", "蔡文静工作室"));
		entities.add(new IDNameEntity("6106249012", "邓恩熙"));
		entities.add(new IDNameEntity("1275238313", "郭晓婷"));
		entities.add(new IDNameEntity("6204112825", "菅纫姿工作室"));
		entities.add(new IDNameEntity("1395738842", "梁田-Eliza"));
		entities.add(new IDNameEntity("6714754164", "是蔡卓宜"));
		entities.add(new IDNameEntity("6689887028", "吴谨言资讯站"));
		entities.add(new IDNameEntity("2972459861", "田依桐_Tian"));
		entities.add(new IDNameEntity("2864280474", "陈瑶Sebrina"));
		entities.add(new IDNameEntity("3173600751", "关之琳"));
		entities.add(new IDNameEntity("1992429663", "这是邱天"));
		entities.add(new IDNameEntity("1588460680", "周楚濋"));
		entities.add(new IDNameEntity("3669102477", "鞠婧祎"));
		entities.add(new IDNameEntity("5303415839", "祁忆_"));
		entities.add(new IDNameEntity("1620504162", "_蒲萄"));
		entities.add(new IDNameEntity("6392725319", "陳凱琳GC"));
		entities.add(new IDNameEntity("1254216400", "何杜娟"));
		entities.add(new IDNameEntity("5796478513", "邢菲工作室"));
		entities.add(new IDNameEntity("1722803755", "熊黛林Lynn"));
		entities.add(new IDNameEntity("1314749965", "庄达菲要一直努力"));
		entities.add(new IDNameEntity("5590043013", "张俪工作室"));
		entities.add(new IDNameEntity("6386605524", "Amelie许龄月工作室"));
		entities.add(new IDNameEntity("6689120770", "加奈那_Na"));
		entities.add(new IDNameEntity("6520054992", "卢靖姗工作室"));
		entities.add(new IDNameEntity("1851083083", "周开开童鞋"));
		entities.add(new IDNameEntity("6501380814", "张榕容工作室"));
		entities.add(new IDNameEntity("1779644250", "袁艾菲"));
		entities.add(new IDNameEntity("2271242580", "袁雨萱呢"));
		entities.add(new IDNameEntity("6178586973", "江铠同工作室"));
		entities.add(new IDNameEntity("5081978012", "蔡思貝Sisley"));
		entities.add(new IDNameEntity("1736859777", "陳煒"));
		entities.add(new IDNameEntity("1713696033", "陳自瑤yoyo"));
		entities.add(new IDNameEntity("1264674527", "穆婷婷Monica"));
		entities.add(new IDNameEntity("1269742744", "曲栅栅"));
		entities.add(new IDNameEntity("6913574141", "左小青工作室"));
		entities.add(new IDNameEntity("1788813773", "陈维涵Vivian"));
		entities.add(new IDNameEntity("1729859377", "王君馨GraceWong"));
		entities.add(new IDNameEntity("2257401393", "马泽涵"));
		entities.add(new IDNameEntity("2731935637", "田曦薇"));
		entities.add(new IDNameEntity("2509769273", "陈雨锶Sr"));
		entities.add(new IDNameEntity("3050709151", "戴萌"));
		entities.add(new IDNameEntity("5682216571", "许潇晗Hami"));
		entities.add(new IDNameEntity("5861115930", "孙珍妮的微博"));
		entities.add(new IDNameEntity("1265017651", "张洋benben"));
		entities.add(new IDNameEntity("1864555331", "张洋Yang"));
		entities.add(new IDNameEntity("5991353253", "马迪妮Yilia"));
		entities.add(new IDNameEntity("1222729470", "卫莱pp"));
		entities.add(new IDNameEntity("5031163331", "宋芸樺Vivian"));		
		return entities;
	}
	public static Set<IDNameEntity> 明星3() {
		Set<IDNameEntity> entities = new LinkedHashSet<>();
		entities.add(new IDNameEntity("5678190861", "李宛妲Vanda"));
		entities.add(new IDNameEntity("1849966047", "演员张歆滢"));
		entities.add(new IDNameEntity("1513932075", "张恩齐Enki"));
		entities.add(new IDNameEntity("2691814893", "演员孙艺燃"));
		entities.add(new IDNameEntity("1271394395", "姚笛"));
		entities.add(new IDNameEntity("1180721740", "银雪crystal"));
		entities.add(new IDNameEntity("2165931464", "曹斐然"));
		entities.add(new IDNameEntity("7848097543", "陈冰工作室"));
		entities.add(new IDNameEntity("1781116564", "陈冰KiKi"));
		entities.add(new IDNameEntity("2174889293", "张梦露也是小鹿"));
		entities.add(new IDNameEntity("5632828302", "主持人齐彤彤"));
		entities.add(new IDNameEntity("1807391080", "Constence刘彦池"));
		entities.add(new IDNameEntity("1452975451", "栗子Chen__"));
		entities.add(new IDNameEntity("5503575607", "卢昱晓_"));
		entities.add(new IDNameEntity("7375118665", "犬八工作室"));
		entities.add(new IDNameEntity("2732448712", "就是嘉泽"));
		entities.add(new IDNameEntity("1879617197", "張曦雯Kelly"));
		entities.add(new IDNameEntity("2123222037", "张艺宣viggie"));
		entities.add(new IDNameEntity("5951996116", "许诗悦"));
		entities.add(new IDNameEntity("5230510382", "曾宥臻"));
		entities.add(new IDNameEntity("1784213863", "何宣林350"));
		entities.add(new IDNameEntity("1265149745", "李曼"));
		entities.add(new IDNameEntity("3257580834", "穆梦娇-格格"));
		entities.add(new IDNameEntity("7832319303", "孙千予-"));
		entities.add(new IDNameEntity("1066317210", "伊一"));
		entities.add(new IDNameEntity("1232647805", "杨诚诚"));
		entities.add(new IDNameEntity("1267610971", "肖雨雨"));
		entities.add(new IDNameEntity("1263762522", "刘璇"));
		entities.add(new IDNameEntity("5677291460", "张婉莹stone"));
		entities.add(new IDNameEntity("2265582003", "杨肸子的微博"));
		entities.add(new IDNameEntity("2548926044", "林妍柔"));
		entities.add(new IDNameEntity("5935241027", "郁葱Yukio"));
		entities.add(new IDNameEntity("6001612742", "赵晴HT"));
		entities.add(new IDNameEntity("2670135051", "徐轸轸Zzz"));
		entities.add(new IDNameEntity("2694664177", "吴佳怡_six"));
		entities.add(new IDNameEntity("1768653271", "宁心Lincy"));
		entities.add(new IDNameEntity("3639470012", "青蛙公主爱凌"));
		entities.add(new IDNameEntity("1909118595", "张馨月Krystal"));
		entities.add(new IDNameEntity("2597748803", "张净桐"));
		entities.add(new IDNameEntity("1305176070", "演员程澄"));
		entities.add(new IDNameEntity("6141320842", "魏嘉weijia"));
		entities.add(new IDNameEntity("3987559881", "赵昭仪_Melek"));
		entities.add(new IDNameEntity("5994952329", "包上恩"));
		entities.add(new IDNameEntity("1714246692", "傅嘉莉KellyFu"));
		entities.add(new IDNameEntity("2152553204", "何瑞贤"));
		entities.add(new IDNameEntity("6033924165", "GNZ48-王炯义"));
		entities.add(new IDNameEntity("1823455165", "王姿允Rain"));
		entities.add(new IDNameEntity("3260168841", "廖帕姿"));
		entities.add(new IDNameEntity("2197685160", "邹思扬Seven"));
		entities.add(new IDNameEntity("5418912902", "符雅凝·YENNY"));
		entities.add(new IDNameEntity("7890278462", "陈昊宇小宇宙"));
		entities.add(new IDNameEntity("5500705525", "高曼尔"));
		entities.add(new IDNameEntity("1345943410", "刘美含"));
		entities.add(new IDNameEntity("1821257283", "黄圣依"));
		entities.add(new IDNameEntity("2835043514", "唐弋婷"));
		entities.add(new IDNameEntity("5386562975", "吐提古丽热杰"));
		entities.add(new IDNameEntity("1798381277", "曾泳醍"));
		entities.add(new IDNameEntity("1657685223", "葛天_PANDA"));
		entities.add(new IDNameEntity("1405932271", "刘宸希"));
		entities.add(new IDNameEntity("1768887231", "徐飒716"));
		entities.add(new IDNameEntity("1721425872", "王双Shuang"));
		entities.add(new IDNameEntity("1955105211", "张小婉Vivian"));
		entities.add(new IDNameEntity("1231067520", "演员贾青Ting"));
		entities.add(new IDNameEntity("6142442691", "夏梦微博"));
		entities.add(new IDNameEntity("1660050527", "演员汪飏"));
		entities.add(new IDNameEntity("1927305954", "成果成果成狗"));
		entities.add(new IDNameEntity("7029360847", "曾梦雪工作室"));
		entities.add(new IDNameEntity("2007347307", "孙佳奇Titania"));
		entities.add(new IDNameEntity("2350442141", "张月YueZhang"));
		entities.add(new IDNameEntity("1066706794", "dada陳靜"));
		entities.add(new IDNameEntity("1823974325", "刘琪奕"));
		entities.add(new IDNameEntity("2449767237", "程慕轩HERA"));
		entities.add(new IDNameEntity("2449552120", "王玉雯Uvin"));
		entities.add(new IDNameEntity("1764654382", "江祖平"));
		entities.add(new IDNameEntity("1286090741", "练练"));
		entities.add(new IDNameEntity("1886702380", "王初伊"));
		entities.add(new IDNameEntity("6041482371", "林辰涵mm"));
		entities.add(new IDNameEntity("1312108820", "邱晔Cindy"));
		entities.add(new IDNameEntity("1662022257", "林鹏_芃妃"));
		entities.add(new IDNameEntity("2914757325", "阮巨"));
		entities.add(new IDNameEntity("1322288524", "马秋子球球"));
		entities.add(new IDNameEntity("1639881303", "卫诗雅Michelle"));
		entities.add(new IDNameEntity("2264191914", "海铃Karina"));
		entities.add(new IDNameEntity("2600268623", "就叫赵艺"));
		entities.add(new IDNameEntity("7461315648", "乃万NINEONE工作室"));
		entities.add(new IDNameEntity("2169289455", "孙雪宁ooo"));
		entities.add(new IDNameEntity("1799605655", "潘之琳"));
		entities.add(new IDNameEntity("1370584371", "唐菀zoey"));
		entities.add(new IDNameEntity("2452664844", "阳蕾crystal"));
		entities.add(new IDNameEntity("1882611787", "michelle胡然"));
		entities.add(new IDNameEntity("1739266037", "溫心Wenny"));
		entities.add(new IDNameEntity("2044833997", "王艺瑾"));
		entities.add(new IDNameEntity("1871878225", "张豆豆ZDD"));
		entities.add(new IDNameEntity("2925687443", "劉芷希KimmyLow"));
		entities.add(new IDNameEntity("1252743172", "何彦霓"));
		entities.add(new IDNameEntity("1898664535", "殷飞cici"));
		entities.add(new IDNameEntity("1264818097", "孙晶晶0401"));
		entities.add(new IDNameEntity("1701025774", "王妍苏"));
		entities.add(new IDNameEntity("1223919192", "刘一含0102"));
		entities.add(new IDNameEntity("1649818571", "曾可妮Jenny-Z"));
		entities.add(new IDNameEntity("1311062917", "田蕾希"));
		entities.add(new IDNameEntity("1308133077", "演员陈洁"));
		entities.add(new IDNameEntity("1363537703", "周庭伊judy"));
		entities.add(new IDNameEntity("5558329456", "吴佳尼Niki"));
		entities.add(new IDNameEntity("1266832557", "于越"));
		entities.add(new IDNameEntity("1797054534", "程砚秋Eva"));
		entities.add(new IDNameEntity("1289631817", "丹琳"));
		entities.add(new IDNameEntity("1707894104", "李蘊Renee"));
		entities.add(new IDNameEntity("1135885071", "主持人方亭"));
		entities.add(new IDNameEntity("1243273752", "古晨"));
		entities.add(new IDNameEntity("2687678670", "徐艺洋-Yiyang"));
		entities.add(new IDNameEntity("3272806315", "姜贞羽Aisling工作室"));
		entities.add(new IDNameEntity("1664032085", "马梦乔13"));
		entities.add(new IDNameEntity("2864280474", "陈瑶Sebrina"));
		entities.add(new IDNameEntity("5541361691", "边丽_Jessica"));
		entities.add(new IDNameEntity("2269438254", "美娜呀美La"));
		entities.add(new IDNameEntity("1267478805", "温峥嵘"));
		entities.add(new IDNameEntity("1874998095", "万鹏er"));
		entities.add(new IDNameEntity("3171342687", "万籽麟"));
		entities.add(new IDNameEntity("6254914541", "苏诗丁工作室"));
		entities.add(new IDNameEntity("1396844901", "王晓甜Brenda"));
		entities.add(new IDNameEntity("1931202433", "张馨元Katherine"));
		entities.add(new IDNameEntity("6525850639", "向涵之"));
		entities.add(new IDNameEntity("5886191812", "李庚希Teresa"));
		entities.add(new IDNameEntity("1357605833", "王梓桐Ivy"));
		entities.add(new IDNameEntity("1767041352", "曾之乔"));
		entities.add(new IDNameEntity("6086111661", "演员尚娜"));
		entities.add(new IDNameEntity("2143524297", "刘秦杉是个重庆妹儿"));
		entities.add(new IDNameEntity("1713100305", "陈敏之"));
		entities.add(new IDNameEntity("1882011520", "徐晓璐"));
		entities.add(new IDNameEntity("1690695920", "谢闻轩"));
		entities.add(new IDNameEntity("1573517133", "端木崇慧"));
		entities.add(new IDNameEntity("1240780154", "隋俊波"));
		entities.add(new IDNameEntity("1669181407", "房程程cici"));
		entities.add(new IDNameEntity("3301230815", "高晴Sunny"));
		entities.add(new IDNameEntity("1792911155", "黄日莹"));
		entities.add(new IDNameEntity("1271359943", "肖茵的微博"));
		entities.add(new IDNameEntity("7716259425", "LUFFLOVE_OFFICIAL"));
		entities.add(new IDNameEntity("1269636175", "演员赵圆圆"));
		entities.add(new IDNameEntity("1576959453", "曾一萱"));
		entities.add(new IDNameEntity("2824029983", "洪司洋_"));
		entities.add(new IDNameEntity("1569703027", "潘时七"));
		entities.add(new IDNameEntity("2856548130", "夏嫣Sheng"));
		entities.add(new IDNameEntity("2099728494", "朱圣祎Shengyi"));
		entities.add(new IDNameEntity("1781369453", "何美璇"));
		entities.add(new IDNameEntity("2954430550", "金兜兜Chris"));
		entities.add(new IDNameEntity("1679824627", "莎莎于"));
		entities.add(new IDNameEntity("1723873823", "沈卓盈jesssum"));
		entities.add(new IDNameEntity("3809672324", "王鹤润rain"));
		entities.add(new IDNameEntity("1838093651", "演员王思思"));
		entities.add(new IDNameEntity("2794764282", "陈梦希Nikki"));
		entities.add(new IDNameEntity("7735668873", "黄婷婷"));
		entities.add(new IDNameEntity("6634214154", "宋雨琦_G-I-DLE"));
		entities.add(new IDNameEntity("1877253217", "赵予熙IrisZ"));
		entities.add(new IDNameEntity("1908312165", "武笑羽"));
		entities.add(new IDNameEntity("2964598280", "演员王彦懿"));
		entities.add(new IDNameEntity("1957856867", "姜瑞佳的微博"));
		entities.add(new IDNameEntity("1586249967", "汤梦佳"));
		entities.add(new IDNameEntity("1882754552", "王艺嘉Cherry"));
		entities.add(new IDNameEntity("2406145701", "韩与诺-Nora"));
		entities.add(new IDNameEntity("1808719422", "许芳铱"));
		entities.add(new IDNameEntity("2304610951", "罗予彤"));
		entities.add(new IDNameEntity("2513966702", "姚晓棠"));
		entities.add(new IDNameEntity("2163994123", "戚砚笛"));
		entities.add(new IDNameEntity("2742586765", "孙嘉璐Ruby"));
		entities.add(new IDNameEntity("1736360395", "何佩瑜小瑜兒"));
		entities.add(new IDNameEntity("1805606247", "吴映香Lucia"));
		entities.add(new IDNameEntity("1703296145", "潘辰"));
		entities.add(new IDNameEntity("1836312141", "Crystal张熙媛"));
		entities.add(new IDNameEntity("2526371597", "艺家阿歆"));
		entities.add(new IDNameEntity("6220640286", "GingLe_王淨"));
		entities.add(new IDNameEntity("2254763605", "安冬冬"));
		entities.add(new IDNameEntity("1961422704", "欧阳子月"));
		entities.add(new IDNameEntity("1587395023", "卢杉"));
		entities.add(new IDNameEntity("1861368700", "逯恣祯_淘淘"));
		entities.add(new IDNameEntity("2680736212", "黄羿Piggy"));
		entities.add(new IDNameEntity("5038633340", "沈羽洁er"));
		entities.add(new IDNameEntity("1250929263", "徐悦yy"));
		entities.add(new IDNameEntity("2949899183", "lllarine邓月平"));
		entities.add(new IDNameEntity("5675478244", "胡嘉欣Josie"));
		entities.add(new IDNameEntity("6190524603", "张艺上工作室"));
		entities.add(new IDNameEntity("2532609337", "梦秦osc"));
		entities.add(new IDNameEntity("1728518287", "何天儿LILY"));
		entities.add(new IDNameEntity("1251796895", "李春嬡大点"));
		entities.add(new IDNameEntity("2036172122", "舒思瑶"));
		entities.add(new IDNameEntity("6047467945", "赵小棠啊"));
		entities.add(new IDNameEntity("2433827884", "周依然6"));
		entities.add(new IDNameEntity("2119365067", "陆翊Change"));
		entities.add(new IDNameEntity("3675865547", "林思意Sissi"));
		entities.add(new IDNameEntity("2696689543", "肖然心-"));
		entities.add(new IDNameEntity("5444134921", "郑水晶Christine"));
		entities.add(new IDNameEntity("1922320923", "沈唯VIAN"));
		entities.add(new IDNameEntity("3182366014", "演员刘姝彤"));
		entities.add(new IDNameEntity("2283956151", "谢子然Meredith"));
		entities.add(new IDNameEntity("6513562778", "顾语涵-"));
		entities.add(new IDNameEntity("6179279336", "刘些宁"));

		return entities;
	}

	public static Set<String> searchKeys1(){
		Set<String> searchKeys = new TreeSet<>(Set.of());
//		searchKeys.addAll(Set.of("早期", "大腿", "舌", "走光", "腿","瑜伽", "比基尼", "泳装", "泳衣", "网袜", "黑丝", "丝袜", "牛仔裤" ));
//		searchKeys.addAll(Set.of("网袜", "黑丝", "丝袜", "瑜伽"));

		searchKeys.addAll(Set.of("林*允", "关晓*彤", "关*晓彤", "宋妍*霏", "宋*妍霏", "韩*雪", "秦*岚", "宋*祖儿", "宋祖*儿"));
		searchKeys.addAll(Set.of("艾晓琪", "童瑶", "娜扎", "宋妍", "娜娜", "赵今麦", "程潇"));
		searchKeys.addAll(Set.of("张彤", "张萌", "黄梦莹", "许晴", "唐艺昕", "王鸥"));
		searchKeys.addAll(Set.of("韩雪", "舒畅", "马思纯", "周秀娜", "王秀竹", "苏青"));
		searchKeys.addAll(Set.of("赵露思", "蒋梦婕", "江疏影", "李菲儿", "朱珠", "徐娇", "欧阳娜娜"));
		searchKeys.addAll(Set.of("代斯", "梁洁", "徐璐", "璐璐", "张蓝心", "张天爱", "张嘉倪", "宋妍霏"));
		searchKeys.addAll(Set.of("李小冉", "王紫璇", "宋祖儿", "关晓彤", "郭珍霓", "李一桐", "刘芸", "孙耀琦"));
		searchKeys.addAll(Set.of("大幂幂", "杨幂", "姗姗", "娜比", "林允", "孙芮", "李凯馨", "蓝燕", "蓝心妍", "柳岩"));
		searchKeys.addAll(Set.of("曾黎", "王楚然", "蒋依依", "张含韵", "陈乔恩"));
		searchKeys.addAll(Set.of("白冰", "佟丽娅", "董璇", "张予曦", "蓝盈莹", "蔡卓宜"));
		searchKeys.addAll(Set.of("程潇", "奶潇", "潇潇", "周冬雨", "李冰冰", "范冰冰"));
		searchKeys.addAll(Set.of("田曦薇", "刘诗诗", "诗诗", "阚清子", "秦岚"));
		searchKeys.addAll(Set.of("景甜", "李沁", "张雪迎", "倪妮", "苗苗", "辛芷蕾"));
		searchKeys.addAll(Set.of("陈瑶", "陈都灵", "鞠婧祎", "张婧仪", "杨超越", "娜然", "沈羽洁"));
		searchKeys.addAll(Set.of("蔡文静", "王子文", "贾静雯"));
		searchKeys.addAll(Set.of("孙千"));
		searchKeys.addAll(Set.of("宫胁咲良", "宮脇咲良"));
		searchKeys.addAll(Set.of("胡连馨"));
		searchKeys.addAll(Set.of("彭小苒"));
		searchKeys.addAll(Set.of("李溪芮", "宋佳"));
		searchKeys.addAll(Set.of("孟佳", "牛欣欣", "夏梦", "李佳桐", "张芷溪", "杨子姗", "张慧雯", "徐小舒", "康可人"));
		searchKeys.addAll(Set.of("钟丽缇", "舒淇"));
		searchKeys.addAll(Set.of("姜珮瑶"));
		searchKeys.addAll(Set.of("江一燕"));
		searchKeys.addAll(Set.of("陈浩宇", "陈昊宇"));
		searchKeys.addAll(Set.of("傅菁"));
		searchKeys.addAll(Set.of("蒋欣"));
		searchKeys.addAll(Set.of("巩俐"));
		searchKeys.addAll(Set.of("冯文娟"));
		searchKeys.addAll(Set.of("虞书欣"));
		searchKeys.addAll(Set.of("王智"));
		searchKeys.addAll(Set.of("何佩瑜"));
		searchKeys.addAll(Set.of("白鹿"));
		searchKeys.addAll(Set.of("孙怡"));
		searchKeys.addAll(Set.of("克拉拉"));
		searchKeys.addAll(Set.of("吉娜"));
		searchKeys.addAll(Set.of("杨颖", "Angelababy" ,"angelababy", "baby"));
		searchKeys.addAll(Set.of("阿娇" ,"陈紫函"));
		searchKeys.addAll(Set.of("钟欣潼" ,"钟欣桐"));
		searchKeys.addAll(Set.of("陈意涵"));
		searchKeys.addAll(Set.of("王艳", "冯文娟"));
		searchKeys.addAll(Set.of("高圆圆", "谷爱凌"));
		searchKeys.addAll(Set.of("赵柯", "赵樱子" ,"赵韩樱子"));
		searchKeys.addAll(Set.of("邱淑贞"));
		searchKeys.addAll(Set.of("孟广美"));
		searchKeys.addAll(Set.of("张馨予", "张雨绮"));
		searchKeys.addAll(Set.of("张敏"));
		searchKeys.addAll(Set.of("李嘉欣"));
		searchKeys.addAll(Set.of("人间富贵花"));
		searchKeys.addAll(Set.of("张曼源"));
		searchKeys.addAll(Set.of("许佳琪"));
		searchKeys.addAll(Set.of("奚梦瑶"));
		searchKeys.addAll(Set.of("徐冬冬"));
		searchKeys.addAll(Set.of("钟楚曦"));
		searchKeys.addAll(Set.of("周也"));
		searchKeys.addAll(Set.of("方圆"));
		searchKeys.addAll(Set.of("潘霜霜","甘婷婷"));
		searchKeys.addAll(Set.of("李依晓"));
		searchKeys.addAll(Set.of("周韦彤"));
		searchKeys.addAll(Set.of("张钧甯"));
		searchKeys.addAll(Set.of("何瑞贤"));
		searchKeys.addAll(Set.of("曾可妮"));
		searchKeys.addAll(Set.of("包上恩"));
		searchKeys.addAll(Set.of("高叶"));
		searchKeys.addAll(Set.of("吴宣仪"));
		searchKeys.addAll(Set.of("王玉雯"));
		searchKeys.addAll(Set.of("吴千语"));
		searchKeys.addAll(Set.of("吴优"));
		searchKeys.addAll(Set.of("露思"));
		searchKeys.addAll(Set.of("宣仪"));
		searchKeys.addAll(Set.of("蒋勤勤"));
		searchKeys.addAll(Set.of("冯琳","于文文" , "高海宁" ));
		searchKeys.addAll(Set.of("周洁琼"));
		searchKeys.addAll(Set.of("张纯烨", "何瑞贤"));
		searchKeys.addAll(Set.of("孟子义"));
		searchKeys.addAll(Set.of("金佳悦"));
		searchKeys.addAll(Set.of("丹琳"));
		searchKeys.addAll(Set.of("刘美彤"));
		searchKeys.addAll(Set.of("宣璐"));
		searchKeys.addAll(Set.of("刘美含", "刘湘"));
		searchKeys.addAll(Set.of("刘萌萌" , "刘芊螢", "刘倩", "刘涛"));
		searchKeys.addAll(Set.of("刘雯", "叶璇", "何穗"));
		searchKeys.addAll(Set.of("郭碧婷", "郭采洁"));
		searchKeys.addAll(Set.of("马秋子","麦迪娜"));
		searchKeys.addAll(Set.of("毛晓彤"));
		searchKeys.addAll(Set.of("霍思燕"));
		searchKeys.addAll(Set.of("姜妍"));
		searchKeys.addAll(Set.of("梁田"));
		searchKeys.addAll(Set.of("周迅"));
		searchKeys.addAll(Set.of("金晨"));
		searchKeys.addAll(Set.of("薛凯琪"));
		searchKeys.addAll(Set.of("热依扎"));
		searchKeys.addAll(Set.of("宁心"));
		searchKeys.addAll(Set.of("李云霄", "章若楠","易梦玲"));
		searchKeys.addAll(Set.of("林志玲","志玲"));
		searchKeys.addAll(Set.of("文咏珊", "张梓琳"));
		searchKeys.addAll(Set.of("王鹤润"));
		return searchKeys;
	}
	public static Set<String> searchKeys2(){
		Set<String> searchKeys = new TreeSet<>(Set.of());
		searchKeys.addAll(Set.of("出口亜梨沙", "奥山かずさ", "奥山和纱", "奥山", "都丸", "片山", "橋本愛実", "壇蜜", "武井咲", "相川 結", "上西怜", "上西惠"));
		searchKeys.addAll(Set.of("水川スミレ", "Miri Mizuki", "Emiri Momota", "水川堇", "百多えみり", "水喜れい", "水稀みり"));
		searchKeys.addAll(Set.of("Kazusa Okuyama", "奥山かずさ", "奥山和纱", "奥山"));
		searchKeys.addAll(Set.of("Tomaru Sayaka", "都丸 紗也華", "都丸紗也華", "都丸纱也华", "都丸"));
		searchKeys.addAll(Set.of("Moemi Katayama", "かたやまもえみ", "かたやま もえみ", "片山 萌美", "片山萌美", "片山"));
		searchKeys.addAll(Set.of("Deguchi Arisa", "Arisa Deguchi", "でぐちありさ", "出口亜梨沙", "出口亚梨沙", "出口"));
		searchKeys.addAll(Set.of("MitsuDan", "Mitsu Dan", "Dan Mitsu", "DanMitsu", "壇蜜", "出口亜梨沙", "坛蜜"));
		searchKeys.addAll(Set.of("HashimotoManami", "Hashimoto Manami", "ManamiHashimoto", "Manami Hashimoto", "橋本マナミ", "細川愛実", "橋本愛実", "桥本真奈美", "桥本爱实"));
		searchKeys.addAll(Set.of("JonishiKei", "Jonishi Kei", "KeiJonishi", "Kei Jonishi", "じょうにし けい", "上西恵", "上西惠"));
		searchKeys.addAll(Set.of("Yumi Asahina", "YumiAsahina", "AsahinaYumi", "Asahina Yumi", "あさひな ゆみ", "朝比奈 祐未", "朝比奈祐未", "上西惠"));
		searchKeys.addAll(Set.of("Watanabe Mayu", "WatanabeMayu", "渡辺麻友", "わたなべ まゆ", "渡边麻友"));
		searchKeys.addAll(Set.of("Ayaka Miyoshi", "AyakaMiyoshi", "Miyoshi Ayaka", "みよし あやか", "アヤカ", "菜花", "三吉彩花"));
		searchKeys.addAll(Set.of("Yuka Kuramoti", "YukaKuramoti", "KuramotiYuka", "Kuramoti Yuka", "倉持由香", "くらもち ゆか", "仓持由香"));
		searchKeys.addAll(Set.of("高橋 凛", "高橋凛", "高桥凛", "Rin Takahashi", "RinTakahashi", "Rin Tachibana", "RinTachibana", "橘花凛"));
		searchKeys.addAll(Set.of("奈月塞娜", "奈月セナ", "Sena Natsuki", "奈月", "Natsuki", "Natsuki Sena"));
		searchKeys.addAll(Set.of("izumi rika", "Izumi Rika", "イズミリカ", "泉里香", "泉里果"));
		searchKeys.addAll(Set.of("小嶋阳菜", "小岛阳菜", "Kojiharu", "小嶋陽菜"));
		searchKeys.addAll(Set.of("河北彩伽", "河北彩花", "かわきたさいか", "Saika Kawakita", "河北菜花"));
		searchKeys.addAll(Set.of("儿玉遥", "兒玉遥", "Kodama Haruka", "Haruka Kodama"));
		searchKeys.addAll(Set.of("宫胁咲良", "宮脇咲良"));
		searchKeys.addAll(Set.of("染谷有香"));
		searchKeys.addAll(Set.of("小宵虎南"));
		searchKeys.addAll(Set.of("河北彩", "橋本萌花", "桥本萌花", "本萌花", "都丸", "高橋", "伊藤舞雪", "サイバ-"));
		searchKeys.addAll(Set.of("相楽伊織", "相乐伊织", "佐野ひなこ", "片山萌美", "泉里香"));
		searchKeys.addAll(Set.of("小嶋陽菜", "片山"));
		searchKeys.addAll(Set.of("朝比奈祐未", "石川澪"));
		searchKeys.addAll(Set.of("8woman"));
		searchKeys.addAll(Set.of("杉本有美"));
		searchKeys.addAll(Set.of("西野翔"));
		searchKeys.addAll(Set.of("澄田綾乃", "澄田绫乃", "Sumida Ayano"));
		searchKeys.addAll(Set.of("草野綾", "草野绫", "kusano Aya"));
		searchKeys.addAll(Set.of("北向珠夕"));
		searchKeys.addAll(Set.of("沢口愛華", "泽口爱华"));
		searchKeys.addAll(Set.of("奥山かずさ", "奥山", "奧山"));
		searchKeys.addAll(Set.of("大和田南那"));
		searchKeys.addAll(Set.of("叶加濑麻衣", "葉加瀬マイ"));
		searchKeys.addAll(Set.of("祝绪丹", "韩雪", "娜扎", "舒淇", "陈宝莲"));
		searchKeys.addAll(Set.of("儿玉遥", "兒玉遥"));
		searchKeys.addAll(Set.of("淺川梨奈", "浅川梨奈"));
		searchKeys.addAll(Set.of("櫻井音乃"));
		searchKeys.addAll(Set.of("八挂海", "八掛海"));
		searchKeys.addAll(Set.of("大竹一重"));
		searchKeys.addAll(Set.of("宫胁咲良", "宮脇咲良"));
		searchKeys.addAll(Set.of("染谷有香"));
		searchKeys.addAll(Set.of("小野六花"));
		searchKeys.addAll(Set.of("本庄"));
		searchKeys.addAll(Set.of("間宮夕貴", "间宫夕贵"));
		searchKeys.addAll(Set.of("rachel cook", "Rachel Cook", "Rachel cook", "rachel Cook", "rachelcook", "RachelCook", "Rachelcook", "rachelCook"));
		searchKeys.addAll(Set.of("麻生希", "水菜丽", "水菜麗"));
		searchKeys.addAll(Set.of("相川結", "相川结", "相川洁", "Yu Aikawa"));
		searchKeys.addAll(Set.of("伊東紗冶子", "伊东纱冶子"));
		searchKeys.addAll(Set.of("田中美久", "高崎加奈美", "高崎かなみ", "久保史绪里", "白间美瑠", "白間美瑠", "danatar"));
		searchKeys.addAll(Set.of("鈴木友菜", "铃木友菜", "逢沢りな", "逢泽莉娜"));
		searchKeys.addAll(Set.of("戸田れい", "户田玲香", "户田怜", "户田玲"));
		searchKeys.addAll(Set.of("明日葉みつは", "明日叶蜜", "明日叶三叶", "明日葉三葉"));
		searchKeys.addAll(Set.of("神菜美舞", "神菜美まい", "山岸逢花", "やまぎしあいか", "あいパン", "立花瑠莉", "白咲莉乃", "白咲りの", "枫富爱", "楓ふうあ", "藤森里穂"));
		searchKeys.addAll(Set.of("瀧本雫叶", "泷本雫叶", "瀧本雫葉", "たきもと しずは"));
		searchKeys.addAll(Set.of("川口春奈", "かわぐち", "はるな", "Haruna Kawaguchi"));
		searchKeys.addAll(Set.of("矢吹春奈", "Haruna Yabuki", "阿部真理子", "阿部真理", "阿布真理", "Mari Abe", "Mariko Abe", "やぶき はるな", "春奈"));
		searchKeys.addAll(Set.of("秋乃櫻子", "秋乃樱子", "郭绮莉", "秋乃桜子", "宝生桜子", "山本絵里歌 ", "Sakurako Akino"));
		searchKeys.addAll(Set.of("松岛枫", "松島かえで", "松島楓", "Kaede Matsushma"));
		searchKeys.addAll(Set.of("星野あかり", "星野明", "星野光", "星野亚加利 ", "Akari Hoshino"));
		searchKeys.addAll(Set.of("一乃あおい", "一乃葵"));
		searchKeys.addAll(Set.of("寺田兰世", "寺田蘭世"));
		searchKeys.addAll(Set.of("つじもとあん", "辻本杏", "An Tsujimoto"));
		searchKeys.addAll(Set.of("纱纱原百合", "ささはらゆり", "紗々原ゆり", "Yuri Sasahara"));
		searchKeys.addAll(Set.of("八卦海", "八掛海", "Umi Yatsugake", "八掛うみ"));
		searchKeys.addAll(Set.of("园都", "園都", "Miyako Sono"));
		searchKeys.addAll(Set.of("FHM 男人幫", "男人幫", "男人帮"));
		searchKeys.addAll(Set.of("凉森玲梦"));
		searchKeys.addAll(Set.of("原干惠", "原幹惠", "Mikie Hara", "はら みきえ"));
		searchKeys.addAll(Set.of("入江纱绫", "入江紗綾", "紗綾", "Saaya Irie", "Saaya"));
		searchKeys.addAll(Set.of("武田久美子" ,"青山知可子"));
		searchKeys.addAll(Set.of("Ayase Haruka","绫濑遥", "綾瀬はるか", "Haruka Ayase", "奶遥"));
		searchKeys.addAll(Set.of("AMAKI JUN", "天木じゅん", "天木纯", "JUN AMAKI", "天木じΦ"));
		searchKeys.addAll(Set.of("菊地則江"));
		searchKeys.addAll(Set.of("淸原なのは","Nanoha Kiyohara"));
		searchKeys.addAll(Set.of("松本若菜","まつもと わかな","Wakana Matsumoto","Matsumoto Wakana"));
		searchKeys.addAll(Set.of("大槻响","Hibiki Otsuki"));
		searchKeys.addAll(Set.of("小島みゆ","小岛美优","Miyu Kojima"));
		
		
		return searchKeys;
	}
	
// document.open();document.close(); 
// var data = ;
// data.forEach(item=>{
//    var line = `entities.add(new IDNameEntity("${item.id}", "${item.screen_name}"));`
//    document.write(line);
//    document.write("<br>")
//});

}
