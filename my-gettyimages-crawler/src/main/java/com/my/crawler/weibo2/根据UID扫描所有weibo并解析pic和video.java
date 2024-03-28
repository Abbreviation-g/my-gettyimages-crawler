package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class 根据UID扫描所有weibo并解析pic和video {
	public static void main(String[] args) throws IOException {
		String uid = "2602190401";
		String folderPath = "F:\\weibo_log\\孙晓伦呀";

		uid = "2383785520";
		folderPath = "F:\\weibo_log\\森林北-";
		uid = "1221923871";
		folderPath = "F:\\weibo_log\\王鸥Angel";
		uid = "1195238435";
		folderPath = "F:\\weibo_log\\曾黎";
		uid = "1642351362";
		folderPath = "F:\\weibo_log\\angelababy";
		uid = "2007341923";
		folderPath = "F:\\weibo_log\\代斯daisy";
		uid = "5653796775";
		folderPath = "F:\\weibo_log\\赵露思的微博";
		uid = "7327934610";
		folderPath = "F:\\weibo_log\\赵露思工作室官微";
		uid = "1078007814";
		folderPath = "F:\\weibo_log\\徐娇";
		uid = "1270344441";
		folderPath = "F:\\weibo_log\\景甜";
		uid = "5705673548";
		folderPath = "F:\\weibo_log\\CSIDE宋妍霏工作室";
		uid = "1210604004";
		folderPath = "F:\\weibo_log\\蓝心妍";
		uid = "2106192855";
		folderPath = "F:\\weibo_log\\赵今麦angel";
		uid = "6387099968";
		folderPath = "F:\\weibo_log\\张婧仪";
		uid = "7610808848";
		folderPath = "F:\\weibo_log\\张婧仪工作室";
		uid = "1712539910";
		folderPath = "F:\\weibo_log\\陈乔恩";
		uid = "2808966557";
		folderPath = "F:\\weibo_log\\李凱馨Eleanor";
		uid = "2687827715";
		folderPath = "F:\\weibo_log\\歐陽娜娜Nana";
		uid = "5943076204";
		folderPath = "F:\\weibo_log\\歐陽娜娜Nana工作室";
		uid = "5187459538";
		folderPath = "F:\\weibo_log\\王秀竹";
		uid = "3828809034";
		folderPath = "F:\\weibo_log\\-王楚然-";
		uid = "6391231488";
		folderPath = "F:\\weibo_log\\王楚然工作室";
		uid = "5664713958";
		folderPath = "F:\\weibo_log\\王秀竹工作室";
		uid = "6001863056";
		folderPath = "F:\\weibo_log\\娜扎工作室";
		uid = "1350995007";
		folderPath = "F:\\weibo_log\\我是娜扎";
		uid = "1738498871";
		folderPath = "F:\\weibo_log\\马思纯";
		uid = "1916655407";
		folderPath = "F:\\weibo_log\\周冬雨";
		uid = "5984352414";
		folderPath = "F:\\weibo_log\\李菲儿工作室";
		uid = "1943405723";
		folderPath = "F:\\weibo_log\\钟楚曦";
		uid = "1913244047";
		folderPath = "F:\\weibo_log\\钟楚曦工作室";
		uid = "1934403631";
		folderPath = "F:\\weibo_log\\孙怡微博";
		uid = "2730123575";
		folderPath = "F:\\weibo_log\\孙怡工作室";
		uid = "5885708534";
		folderPath = "F:\\weibo_log\\GNZ48-刘倩倩-";
		uid = "6564121066";
		folderPath = "F:\\weibo_log\\陈斯文cissie";
		uid = "2185613090";
		folderPath = "F:\\weibo_log\\晗卓-";
		uid = "5038633340";
		folderPath = "F:\\weibo_log\\沈羽洁er";
		uid = "1197755162";
		folderPath = "F:\\weibo_log\\韩雪";
//		uid = "1769202531";
//		folderPath = "F:\\weibo_log\\韩雪工作室";
//		uid = "3194073462";
//		folderPath = "F:\\weibo_log\\MetFreckle";
//		uid = "5748979953";
//		folderPath = "F:\\weibo_log\\八掛海_real";
//		uid = "5409037849";
//		folderPath = "F:\\weibo_log\\胡连馨儿";
//		uid = "7779944184";
//		folderPath = "F:\\weibo_log\\Fairy丨0416林允Jelly";
//		uid = "2646681810";
//		folderPath = "F:\\weibo_log\\林允Jelly";
//		uid = "5653796775";
//		folderPath = "F:\\weibo_log\\赵露思的微博";
//		uid = "7327934610";
//		folderPath = "F:\\weibo_log\\赵露思工作室官微";
//		uid = "3603256695";
//		folderPath = "F:\\weibo_log\\梦醒忒远";
//		uid = "2804630987";
//		folderPath = "F:\\weibo_log\\梁洁Little";
//		uid = "6323957970";
//		folderPath = "F:\\weibo_log\\梁洁工作室";
//		uid = "1644461042";
//		folderPath = "F:\\weibo_log\\柳岩";
		uid = "3034045004";
		folderPath = "F:\\weibo_log\\赵蕴卓同学";
		uid = "1915843283";
		folderPath = "F:\\weibo_log\\Cecilia宋妍霏";
		
		start(uid, new File(folderPath));
	}

	public static void start(String uid, File folder) throws IOException {
		JSONArray newWeiboArray = WeiboUIDToWeiboArray.getWeiboArray(uid);
		JSONObject newObject = WeiboArrayToPicsVideos.weiboArrayToPicsVideos(newWeiboArray);
		if (newObject.isEmpty()) {
			System.err.println("解析 \t" + uid + "\t失败");
			return;
		}
		File weiboArrayFile = new File(folder, Constants.WEIBO_ARRAY_FILE_NAME);
		if (weiboArrayFile.exists()) {
			JSONObject oldObject = WeiboArrayToPicsVideos.weiboArrayLogToPicsVideos(weiboArrayFile);
			newObject = WeiboArrayToPicsVideos.mergeOldAndNew(oldObject, newObject);
		}
		if (!folder.exists()) {
			folder.mkdirs();
		}
		Files.writeString(weiboArrayFile.toPath(), newWeiboArray.toString(SerializerFeature.PrettyFormat));
		Files.writeString(new File(folder, Constants.PICS_VIDEOS_FILE_NAME).toPath(),
				newObject.toString(SerializerFeature.PrettyFormat));
	}
}
