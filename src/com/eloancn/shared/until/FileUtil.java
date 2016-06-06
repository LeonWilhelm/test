package com.eloancn.shared.until;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *	�ļ���ȡ��
 */
public class FileUtil {
	
	/**
	 * ��ȡ��ǰ·��
	 * @param proName
	 * @param params
	 * @return
	 */
	public static String getCurrentPath(){
		return new File("").getAbsolutePath();//��ǰ·��
	}
	
	public static String[] getProperties(String proName,String params[]){
		String properties = proName;
		String curPath = getCurrentPath();//��ǰ·��
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
	 * �ж�һ���ļ����ļ����Ƿ����
	 * @param path �ļ����ļ��еľ���·��
	 * @return true�����ڣ�false��������
	 * @author ������ 2016-3-16
	 */
	public boolean isFileExists(String path){
		File file = new File(path);
		return file.exists();
	}
}
