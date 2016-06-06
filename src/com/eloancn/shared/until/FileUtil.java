package com.eloancn.shared.until;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *	文件读取类
 */
public class FileUtil {
	
	/**
	 * 获取当前路径
	 * @param proName
	 * @param params
	 * @return
	 */
	public static String getCurrentPath(){
		return new File("").getAbsolutePath();//当前路径
	}
	
	public static String[] getProperties(String proName,String params[]){
		String properties = proName;
		String curPath = getCurrentPath();//当前路径
	 	InputStream is = null;
		try {
			is = new FileInputStream(curPath+File.separator+properties);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties property = new Properties();
		try {
			property.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < params.length; i++) {
			params[i] = property.getProperty(params[i]);
		}
		return params;
	}
	
	/**
	 * 判断一个文件或文件夹是否存在
	 * @param path 文件或文件夹的绝对路径
	 * @return true：存在，false：不存在
	 * @author 江渤洋 2016-3-16
	 */
	public boolean isFileExists(String path){
		File file = new File(path);
		return file.exists();
	}
}
