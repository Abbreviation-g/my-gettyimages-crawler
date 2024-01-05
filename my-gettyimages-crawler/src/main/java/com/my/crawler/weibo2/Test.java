package com.my.crawler.weibo2;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		清空文件夹("F:\\weibo_log");
	}

	private static void 清空文件夹(String folderPath) {
		File folder = new File(folderPath);

		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		File[] subFolders = folder.listFiles((File dir) -> dir.isDirectory());
		for (int i = 0; i < subFolders.length; i++) {
			int j = i;
			File subFolder = subFolders[i];
			threadPool.execute(() -> {
				File[] subSubFolders = subFolder.listFiles((File dir) -> dir.isDirectory());
				for (File subSubFolder : subSubFolders) {
					deleteFolder(subSubFolder);
					System.out.println(subSubFolder + "\t deleted. ");
				}
				System.out.println(j + "\t" + subFolder + "\t deleted. ");
			});
		}

		threadPool.shutdown();
		while (!threadPool.isTerminated()) {

		}

	}

	private static boolean deleteFolder(File file) {
		if (file.isFile()) {
			return file.delete();
		}
		for (File subFile : file.listFiles()) {
			deleteFolder(subFile);
		}
		return file.delete();
	}
}
