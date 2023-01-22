package com.my.crawler.instagram;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class InstagramDownload {
	public static void main(String[] args) throws IOException {
		String path = "C:\\work\\sorce_code\\mine\\my-gettyimages-crawler\\my-gettyimages-crawler\\src\\main\\java\\com\\my\\crawler\\instagram\\query_hash.json";
		String content = Files.readString(Paths.get(path));
		JSONObject jsonObject = (JSONObject) JSON.parse(content);
		JSONArray datas = jsonObject.getJSONObject("data").getJSONObject("user")
				.getJSONObject("edge_owner_to_timeline_media").getJSONArray("edges");

		JSONObject page_info = jsonObject.getJSONObject("data").getJSONObject("user")
				.getJSONObject("edge_owner_to_timeline_media").getJSONObject("page_info");

		Boolean has_next_page = page_info.getBoolean("has_next_page");
		System.out.println(has_next_page);

		for (Object data : datas) {
			JSONObject i = (JSONObject) data;
			String img_link = i.getJSONObject("node").getString("display_url");
			System.out.println(img_link);

		}

	}
}
