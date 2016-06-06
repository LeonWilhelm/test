package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.*;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RegisterPage;

/*
 * “登录”用例
 */
public class Login {
	IndexPage indexPage = new IndexPage();
	RegisterPage registerPage = new RegisterPage();
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
	String tel = Data.tel_run_debit2;//Data.email
	String password = Data.password;
	String idCord = Data.idCard_run_credit;
	String email = Data.email_run_debit2;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_tel;//Data.email
			idCord = Data.test_idCard;
			email = Data.test_email;
			password = Data.test_password;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}

	/**
	 * 徐天元
	 * 首页登录--回到首页
	 */
	@Test (priority=1)
	public void login_AT_493(){
		Reporter.log("散标投资流程：首页登录--回到首页<br/>");
		//点击“登录”
		indexPage.clickLoginLink();
		//登录
		loginPage.login(tel, password);//1112@126.com  //现网："ff@qq.com"
		//验证登录是否成功
		loginPage.isLoginOK();
		//验证是否跳转至首页
		indexPage.isturnToIndexPage();
	}
	
	/**
	 * 徐天元
	 * 我的账户登录--跳转到我的账户--账户总览页面
	 */
	@Test (priority=2)
	public void loginMyAccount_AT_497(){
		Reporter.log("散标投资流程：我的账户手机登录--跳转到我的账户--账户总览页面<br/>");
		//退出
		base.logout();
		//点击“我的账户”
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//登录
		loginPage.loginWithNoFrame(tel, password);//1231@qq.com  //现网："ff@qq.com"
		//验证登录是否成功
		loginPage.isLoginOK();
		//验证是否进入我的账户-账户总览页面
		myAccountPage.isGoMyAccount("账户总览");
	}

	/**
	 * 徐天元
	 * 我的账户身份证号登录--跳转到我的账户--账户总览页面
	 */
	@Test (priority=3)
	public void loginMyAccountByIdCard_AT_735(){
		Reporter.log("散标投资流程：我的账户身份证号登录--跳转到我的账户--账户总览页面<br/>");
		//退出
		base.logout();
		//点击“我的账户”
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//登录
		loginPage.loginWithNoFrame(idCord, password);//1231@qq.com  //现网："ff@qq.com"
		//验证登录是否成功
		loginPage.isLoginOK();
		//验证是否进入我的账户-账户总览页面
		myAccountPage.isGoMyAccount("账户总览");
	}
	
	/**
	 * 徐天元
	 * 我的账户邮箱登录--跳转到我的账户--账户总览页面
	 */
	@Test (priority=4)
	public void loginMyAccountByEmail(){
		Reporter.log("散标投资流程：我的账户邮箱登录--跳转到我的账户--账户总览页面<br/>");
		//退出
		base.logout();
		//点击“我的账户”
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//登录
		loginPage.loginWithNoFrame(email, password);//1231@qq.com  //现网："ff@qq.com"
		//验证登录是否成功
		loginPage.isLoginOK();
		//验证是否进入我的账户-账户总览页面
		myAccountPage.isGoMyAccount("账户总览");
	}
}
