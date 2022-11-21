package com.my.crawler.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class 重命名无后缀名文件 {
	public static void main(String[] args) throws IOException {
		File outputFolder = new File("D:\\weibo\\杨之楹");
		searchFile(outputFolder);
	}
	
	public static void searchFile(File outputFolder) throws IOException {
		Files.walkFileTree(outputFolder.toPath(), new SimpleFileVisitor<java.nio.file.Path>() {
			@Override
			public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
				File file = path.toFile();
				String fileName = file.getName();
				if(fileName.indexOf('.') == -1) {
					fileName = fileName+".jpg";
					file.renameTo(new File(file.getParentFile(), fileName));
				}
				return super.visitFile(path, attrs);
			}
		});
	}
}
