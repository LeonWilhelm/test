package com.eloancn.shared.until;

/**
 *	��ʽ��
 */
public class CssUtils {
	/**
	 * xty
	 * ��ɫ����  ����Report.log
	 * @param msg
	 * @return
	 */
	public static String red(String msg){
		StringBuffer result = new StringBuffer("<font style=\"color:red;font-size:16px;\">");
		result.append(msg);
		result.append("</font></br>");
		return result.toString();
	}
}
