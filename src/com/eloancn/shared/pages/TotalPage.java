package com.eloancn.shared.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.PageTitles;

public abstract class TotalPage {

	static Base base = new Base();
	
	
	static By nextBtn = By.xpath("//li[text()='>']");		//下一页按钮
	static By nextTd = By.xpath("//td[@id='next']");		//下一页按钮的Td标签
	
	/**
	 * 进入某页面
	 * @param pageName 页面名字
	 * @param isLogin 是否登录，true:登录，false：未登录
	 * @author 江渤洋 2015-12-16
	 */
	public static void openPage(String pageName, boolean isLogin){
		
		String url = "",pageTitle = "";
		
		switch (pageName) {
		case "首页":			pageTitle = PageTitles.shouYe;			break;
		case "翼存宝列表页":	url = "/new/loadAllWmpsRecords.action";
							pageTitle = PageTitles.yiCunBao;		break;
		case "投资列表":		url = "/new/loadAllTender.action";
							pageTitle = PageTitles.touZiLieBiao;	break;
		case "我的账户":		url = "/page/userMgr/myHome.jsp";
							if(isLogin){
								pageTitle = PageTitles.woDeZhangHu;
							}
							else {
								pageTitle = PageTitles.huiYuanDengLu;
							}
							break;
		default:			pageTitle = PageTitles.shouYe;			break;
		}
		base.openBrowser(base.indexURL + url);
		base.isTitle(pageTitle);
	}
	
	/**
	 * 翻页查找内容
	 * @param listBy 查找字段集合
	 * @param searchField 查找字段
	 * @return true 查找字段存在；false 查找字段不存在
	 * @author 江渤洋 2016-1-6
	 */
	public static boolean isSearchFieldByList(By listBy, String searchField){
		
		boolean isTrue = false;				//是否存在
		String tempNameString = "";
		List<WebElement> fieldList = null;	//被查找字段列表
		
		System.out.println("\n-------------开始_翻页查找----------------\n");//------------测试
		do{
			fieldList = new ArrayList<WebElement>();
			fieldList = base.getVisibleElements(listBy);
			int size = fieldList.size();
			//如果找到相同姓名则跳出循环
			for(int i = 0; i < size; i++){
				tempNameString = base.getElementTextWithWait(fieldList.get(i));
				if(searchField.equals(tempNameString)){
					isTrue = true;
				}
			}
			//如果本页没有，点击下一页
			if(!isTrue){
				//判断当前页是否是最后一页，即下一页按钮是否隐藏;true为隐藏，false为显示
				if(base.isElementContainsValue(nextBtn, "class", "pgEmpty")){
					System.out.println("error_翻页查找，没有找到");
					Reporter.log("error_翻页查找，没有找到");
					break;
				}
				else{
					base.clickWithWait(nextBtn);
				}
			}
			base.sleep(3000);
		}while(!isTrue);

		System.out.println("\n-------------结束_翻页查找----------------\n");//------------测试
		return isTrue;
	}

}
