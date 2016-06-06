package com.eloancn.shared.until;

/**
 *	样式类
 */
public class CssUtils {
	/**
	 * xty
	 * 红色字体  用于Report.log
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
