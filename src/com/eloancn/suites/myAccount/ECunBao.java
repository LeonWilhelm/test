package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.TotalPage;
import com.eloancn.shared.pages.YCBPage;

/**
 * 我的账户——>翼存宝
 */
public class ECunBao {

	Base base = new Base();
	
	YCBPage yCBPage = new YCBPage();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
	String tel;			//手机号
	String pass;		//密码
	String day;         //合约期限
	String eCunBaoName;  //翼存宝产品名称
	
	String tel_client = Data.tel_run_EcunBao; 
	String pass_client = Data.zzmm;
	String day_client = "365";
	String eCunBaoName_client = "dongcai3";
	
	String tel_test = Data.test2_tel;
	String pass_test = Data.test2_password;
	String day_test = "365";
	String eCunBaoName_test = "1979期";
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			
			tel = tel_client;
			pass = pass_client;
			day = day_client;
			eCunBaoName = eCunBaoName_client;
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			
			tel = tel_test;
			pass = pass_test;
			day = day_test;
			eCunBaoName = eCunBaoName_test;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}

	/*****************************************************/
	/************    翼存宝_参与中_查看详情_债权详情          ************/
	/*****************************************************/
	
	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void checkBondDetails_AT_5265(){
		
		Reporter.log("我的账户_参与中 ——>1.根据翼存宝期数、Title，点击查看详情_债权详情，再点击“债权详情”链接，窗口是否打开<br/>");
		Reporter.log("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常<br/>");
		Reporter.log("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息<br/>");
		Reporter.log("4.再次点击“查看详情”按钮，标详情关闭<br/>");
		Reporter.log("5.点击关闭按钮，窗口关闭<br/>");
		System.out.println("我的账户_参与中 ——>1.根据翼存宝期数、Title，点击查看详情_债权详情，再点击“债权详情”链接，窗口是否打开");
		System.out.println("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常");
		System.out.println("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息");
		System.out.println("4.再次点击“查看详情”按钮，标详情关闭");
		System.out.println("5.点击关闭按钮，窗口关闭");
		
		if(loginPage.ifLogin()){//如果登录，则登出
			base.logout();
		}
		loginPage.loginByMyAccount(tel, pass);
		
		TotalPage.openPage("我的账户", true);
		myAccountPage.turnToMyAccount("翼存宝");
		
		yCBPage.clickPartake();								//点击“参与中”
		yCBPage.checkPartake();
		yCBPage.clickAppointViewDetails(day);
		yCBPage.checkViewDetails(day);
		yCBPage.checkViewDetailsByValue(eCunBaoName);
		yCBPage.clickOperate(eCunBaoName, "债权详情");
		yCBPage.checkCreditorDetailsDIV();
		yCBPage.checkBondDetailsDIVColumnName();
		yCBPage.checkBondDetailsDIVColumnValue("借款标题");
		yCBPage.checkBondDetailsDIVColumnValue("借款人姓名");
		yCBPage.checkBondDetailsDIVColumnValue("身份证号");
		yCBPage.checkBondDetailsDIVColumnValue("操作");
		yCBPage.checkBondDetails();
	}
}
