package com.my.crawler.weibo2;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 清理空文件 {
	public static void main(String[] args) {
//		清空文件夹("F:\\weibo_log");
//		清理空文件("F:\\weibo4");
//		清理空文件("F:\\thefappeningblog-output");
//		清理空文件("F:\\weibo2");
//		清理空文件("F:\\weibo\\胡连馨后援会官博");
		清理空文件("F:\\xasiat-output");
	}

	private static void 清理空文件(String folderPath) {
		try {
			Files.walkFileTree(Paths.get(folderPath), new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
					File file = path.toFile();
					if (file.length() == 0L) {
						System.out.println(file + "\t deleted");
						file.delete();
					}
					return super.visitFile(path, attrs);
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
