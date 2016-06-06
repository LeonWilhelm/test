package com.eloancn.shared.pages;

import org.openqa.selenium.By;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;

/**
 *	申请加盟（首页——>我要加盟）
 */
public class JoinInPage {
	
	Base base = new Base();
	Data data = new Data();

	/*********************************/
	/**********   加盟申请表          **********/
	/*********************************/
	
	By name = By.cssSelector("#name");						//您的姓名
	By tel = By.cssSelector("#mobile");						//您的电话
	By level = By.cssSelector(".rad>label>input");			//您的加盟意向层级(包括：地市级运营中心、区县级盟商、单项产品 )
	By province = By.cssSelector("#province");				//您的加盟意向区域_省
	By city = By.cssSelector("#city");						//您的加盟意向区域_市
	By county = By.cssSelector("#county");					//您的加盟意向区域_区
	By refereeMobile = By.cssSelector("#refereeMobile");	//推荐人手机号
	By joinInBtn = By.cssSelector(".sqjm");					//“申请加盟”按钮
	
	/**
	 * 填写加盟申请信息
	 */
	public void inputJoinInInfo(){
		
		base.sendKeysWithWait(name, data.getFullName());
		base.sendKeysWithWait(tel, data.phoneConcatenation(3));
		clickLevel("区县级盟商");
		base.elementSelectByIndex(province, 1);
		base.elementSelectByIndex(city, 1);
		base.elementSelectByIndex(county, 1);
		base.sendKeysWithWait(refereeMobile, data.phoneConcatenation(3));
	}
	
	/**
	 * 点击“您的加盟意向层级”单选按钮
	 * @param name 层级名称(包括：地市级运营中心、区县级盟商、单项产品 )
	 */
	public void clickLevel(String name){
		
		int index = 0;
		switch (name) {
		case "地市级运营中心":	index = 0;break;
		case "区县级盟商":		index = 1;break;	
		case "单项产品 ":		index = 2;break;
		default:			index = 1;break;
		}
		base.clickElementVisibleByIndex(level, index);
	}
	
	/**
	 * 点击“我要加盟”按钮
	 */
	public void clickJoinInBtn(){
		
		base.clickWithWait(joinInBtn);
	}
	
	/**
	 * 校验提交加盟信息表，跳转是否正常（未登录）
	 */
	public void checkJoinInInfoJumpNoLogin(){
		inputJoinInInfo();
		clickJoinInBtn();
		base.isTitle(PageTitles.huiYuanDengLu);
	}
}
