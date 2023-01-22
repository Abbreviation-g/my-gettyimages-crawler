package com.my.crawler.common;

import java.io.File;

public class CommonTest {
	public static void main(String[] args) {
		test1();
	}
	static void test1() {
		File outputFolder = new File("D:\\weibo\\赵露思");
		for(File sub:outputFolder.listFiles()) {
			String subName = sub.getName();
			if(subName.contains("ๅนด")) {
				subName =subName.replace("ๅนด", "年");
			}
			sub.renameTo(new File(outputFolder, subName));
		}
	}
}
