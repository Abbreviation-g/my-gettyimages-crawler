package com.my.crawler.common.wenjian;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 文件夹管理 {
	public static void main(String[] args) {
		String folderPath = "G:\\女星\\gettyimages\\kristen-stewart";
		folderPath = "G:\\女星\\gettyimages\\willow-shields";
		folderPath = "G:\\女星\\gettyimages\\isabelle-fuhrman";
		folderPath = "G:\\女星\\gettyimages\\nicole-kidman";
		folderPath = "G:\\女星\\gettyimages\\sophie-turner";
		folderPath = "G:\\女星\\gettyimages\\maisie-williams";
		folderPath = "G:\\女星\\gettyimages\\gal-gadot";
		folderPath = "G:\\女星\\gettyimages\\saoirse-ronan";
		folderPath = "G:\\女星\\gettyimages\\emilia-clarke";
		folderPath = "G:\\女星\\gettyimages\\gong-li";
		folderPath = "G:\\女星\\gettyimages\\isabela-moner";
		folderPath = "G:/女星/gettyimages/ivanka-trump";
		folderPath = "G:\\女星\\gettyimages\\julianne-moore";
		folderPath = "G:\\女星\\gettyimages\\kate-upton";
		folderPath = "G:\\女星\\gettyimages\\kathleen-robertson";
		folderPath = "G:\\女星\\gettyimages\\kathryn-newton";
		folderPath = "G:\\女星\\gettyimages\\angelina-jolie";
		folderPath = "G:\\女星\\gettyimages\\maggie-q";
//		folderPath = "G:\\女星\\gettyimages\\欧美\\mckenna-grace";
		folderPath = "G:\\女星\\gettyimages\\欧美\\megan-fox";
		folderPath = "G:\\女星\\gettyimages\\欧美\\monica-bellucci";
		folderPath = "G:\\女星\\gettyimages\\欧美\\monica-bellucci\\close up";
		folderPath = "G:\\女星\\gettyimages\\欧美\\megan-fox";
		folderPath = "G:\\女星\\gettyimages\\欧美\\hayley-atwell\\detail";
		
		cutFolder(folderPath,200);
	}
	
	public static <T> List<List<T>> subList(List<T> list,int subSize){
		List<List<T>> result = new ArrayList<>();
		int offset = 0;
		while(offset < list.size()) {
			int fromIndex = offset;
			int toIndex = offset +subSize;
			if((offset +subSize)>list.size()) {
				toIndex = list.size();
			}
			List<T> subList = list.subList(fromIndex, toIndex);
			result.add(subList);
			offset += subSize;
		}
		return result;
	}
	
	public static void cutFolder(String folderPath,int subSize) {

		File folder = new File(folderPath);
        File[] files = folder.listFiles(File::isFile);
        if(files==null || files.length == 0) {
        	return ;
        }
        Arrays.sort(files, new Comparator<File>() {
            public int compare(File f1, File f2) {
                long diff = f1.lastModified() - f2.lastModified();
                if(diff <0) {
                	return 1;
                }
                if(diff >0) {
                	return -1;
                }
                return 0;
            }

            public boolean equals(Object obj) {
                return true;
            }

        });
        List<File> fileList = new ArrayList<File>();
        fileList.addAll(Arrays.asList(files));
        System.out.println("文件夹扫描完毕." + fileList.size());
        if(fileList.size() < 400) {
        	System.out.println("该文件夹不需要拆分");
        	return;
        }
        System.out.println("开始拆分文件夹");
        List<List<File>> result = subList(fileList, subSize);
        for (int i = 0; i < result.size(); i++) {
        	List<File> subList = result.get(i);
        	File subFolder = new File(folderPath, Integer.toString(i+1));
        	subFolder.mkdirs();
        	for (File file : subList) {
        		File newFile = new File(subFolder, file.getName());
				file.renameTo(newFile);
			}
        	System.out.println(subFolder+": 整理完毕");
		}
        
	}
}
