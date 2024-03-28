package com.my.crawler.common;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 文件夹按文件数量拆分 {
	static final int MAX_SIZE = 200;

	public static void main(String[] args) {
		String folderPath = "D:\\weibo\\梦醒忒远\\2022年12月";
		folderPath = "D:\\weibo\\梦醒忒远\\2023年01月";
		folderPath = "D:\\weibo\\梦醒忒远\\2023年02月";
		folderPath = "D:\\weibo\\梦醒忒远\\2023年04月";
		folderPath = "D:\\weibo\\梦醒忒远\\2023年05月";
		folderPath = "D:\\weibo\\梦醒忒远\\2023年10月";

		File folder = new File(folderPath);
		File[] listFiles = folder.listFiles(file -> file.isFile());
		List<File> fileList = Arrays.stream(listFiles).collect(Collectors.toList());
		if (fileList.size() <= MAX_SIZE) {
			return;
		}

		for (int i = 0, folderIndex = 1; i < fileList.size(); i += MAX_SIZE, folderIndex++) {
			int toIndex = i + MAX_SIZE;
			if (toIndex >= fileList.size()) {
				toIndex = fileList.size();
			}
			List<File> subList = fileList.subList(i, toIndex);
			File subFolder = new File(folder, Integer.toString(folderIndex));
			subFolder.mkdir();
			subList.stream().forEach(file -> file.renameTo(new File(subFolder, file.getName())));
		}
	}
}
