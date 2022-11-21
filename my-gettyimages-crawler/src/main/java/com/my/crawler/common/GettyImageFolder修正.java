package com.my.crawler.common;

import java.io.File;

public class GettyImageFolder修正 {
	public static void main(String[] args) {
		String folderPath = "G:\\女星\\gettyimages\\欧美\\monica-bellucci";
		File folder = new File(folderPath);
		File[] listFiles = folder.listFiles(File::isFile);
		for (File file : listFiles) {
			String name = file.getName();
			if(name.indexOf('.') == -1) {
				name = name+".jpg";
			}
			boolean renameResult = file.renameTo(new File(file.getParent(), name)); 
			if(renameResult) {
				System.out.println(name);
			} else {
				System.out.println(name+" already exist.");
				file.delete();
			}
		}
	}
}
