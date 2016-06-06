package com.eloancn.suites.credit;

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
/**
 * 徐天元
 * 登录P1
 */
public class Login_P1 {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	
	String tel = "";
	
	@BeforeMethod
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
	}
	
	@AfterMethod
	public void teardownAfter(){
		base.tearDown();
	}

	@Test(priority=1)
	public void wrongTelAndPassLogin_web_1256(){
		Reporter.log("首页登录输入错误的账户和密码，提示账户或密码错误，账户和密码输入框清空，并显示验证码输入模块；点击X按钮,关闭登录窗口<br/>");//；再次登录输入正确的账户和密码，账户登陆成功
		indexPage.clickLoginLink();
		loginPage.login("13121231232", "222222");
		//提示账户或密码错误，账户和密码输入框清空，并显示验证码输入模块
		loginPage.isLoginWrong();
		//点击X按钮,关闭登录窗口
		loginPage.closeLogin();
		/*//再次登录输入正确的账户和密码，账户登陆成功
		indexPage.clickLoginLink();
		loginPage.login("13111111171", "111111");
		base.sleep(5000);
		loginPage.isLoginOK();*/
	}
	
	@Test(priority=2)
	public void trueTelWrongPassLogin_web_1304_1(){
		Reporter.log("输入正确的账号、错误密码，不能登录<br/>");
		indexPage.clickLoginLink();
		tel = "13111111171";
		String pwd = "222222";
		loginPage.login(tel, pwd);
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_tel;
		}
		//提示账户或密码错误，账户和密码输入框清空，并显示验证码输入模块
		loginPage.isLoginWrong();
	}
	
	@Test(priority=3)
	public void wrongTelTruePassLogin_web_1304_2(){
		Reporter.log("错误的账户、正确的密码,不能登录<br/>");
		indexPage.clickLoginLink();
		loginPage.login("13121231232", "111111");
		loginPage.isLoginWrong();
	}
}
