package com.eloancn.suites.myAccount;


import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RechargePage;

/**
 * “我的账户”P1用例
 * @author 江渤洋
 */
public class MyAccount_P1 {
	
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	RechargePage rechargePage = new RechargePage();
	IndexPage indexPage = new IndexPage();
	
	String url;
	String MyAccountUrl = base.indexURL + "/page/userMgr/myHome.jsp";
	String tel = "";
	String tel_client = Data.tel_run_MyAccount;
	String tel_test = Data.test_tel_run_MyAccount;
	String pass = Data.zzmm;
	String name = "";
	String name_client = Data.name_run_MyAccount;
	String name_test = Data.test2_realName;
	String id = Data.id_run_MyAccount;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		url = base.getWebsiteServerName(base.indexURL);
		
		if(url.equals("client") || url.equals("inclient")){
			tel = tel_client;
			name = name_client;
		}
		else if(url.equals("test") || url.equals("www")){
			tel = tel_test;
			name = name_test;
		}
	}
	
	@BeforeMethod
	public void methodBefore(){
		base.openBrowser(MyAccountUrl);
	}

	@AfterMethod
	public void methodAfter(){
		base.logout();
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * 验证充值首次姓名，姓名提示信息
	 * 备注：新用例编号：4613
	 * @author 江渤洋
	 */
	@Test(priority = 1)
	public void checkNameNoticeInfomation_web_29(){
		
		Reporter.log("我的账户_P2：我的账户——>验证充值首次姓名，姓名提示信息");
		loginPage.loginWithNoFrame(tel, pass);
		base.openBrowser(MyAccountUrl);
		//进入充值页面
		myAccountPage.turnToMyAccount("充值");
		base.sleep(2000);
		//判断是否跳转至充值界面
		rechargePage.isIdentityInfo();
		myAccountPage.isGoMyAccount("充值");	
		//输入姓名
		rechargePage.setInfoByIdCard(id);
		//输入姓名，并验证输入是否正确
		myAccountPage.checkNameNoticeInformation(rechargePage.nameMsg, rechargePage.nameCheckmarkImg);
	}
	
	/**
	 * 验证充值首次身份验证，身份证号提示信息
	 * 备注：新用例编号：4614
	 * @author 江渤洋
	 */
	@Test(priority = 2)
	public void checkIdCardNoticeInfomation_web_30(){
		
		Reporter.log("我的账户_P1：我的账户——>验证充值首次身份验证，身份证号提示信息");
		loginPage.loginWithNoFrame(tel, pass);
		base.openBrowser(MyAccountUrl);
		//进入充值页面
		myAccountPage.turnToMyAccount("充值");
		base.sleep(2000);
		//判断是否跳转至充值界面
		rechargePage.isIdentityInfo();
		myAccountPage.isGoMyAccount("充值");	
		//输入姓名
		rechargePage.setInfoByRealName(name);
		//输入身份证号，并验证输入是否正确
		myAccountPage.checkIdCardNoticeInformation();
	}
	
	
	/**
	 * 验证充值首次身份验证，支付密码提示信息
	 * 备注：现网手机号：18810882570，提示信息以现网为准
	 * 备注：新用例编号：4616
	 * @author 江渤洋
	 */
	@Test(priority = 3)
	public void checkPayPasswordNoticeInfomation_web_34(){
		
		Reporter.log("我的账户_P1:我的账户——>验证充值首次身份验证，支付密码提示信息");
		loginPage.loginWithNoFrame(tel, pass);
		base.openBrowser(MyAccountUrl);
		//进入充值页面
		myAccountPage.turnToMyAccount("充值");
		base.sleep(2000);
		//判断是否跳转至充值界面
		rechargePage.isIdentityInfo();
//		myAccountPage.isGoMyAccount("充值");	
		//输入姓名
		rechargePage.setInfoByRealName(name);
		//输入身份证号
		rechargePage.setInfoByIdCard(id);
		//输入支付密码，并验证输入是否正确
		myAccountPage.checkPayPasswordNoticeInformation();
	}
}
