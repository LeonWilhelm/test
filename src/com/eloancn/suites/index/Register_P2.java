package com.eloancn.suites.index;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.RegisterPage;
/**
 * 注册P2
 * @author 徐天元
 */
public class Register_P2 {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	RegisterPage registerPage = new RegisterPage();
	Data data = new Data();

	@BeforeClass
	public void setupBefore(){
		base.setup();
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * 点击首页的导航栏的注册按钮,跳转注册页面
	 */
	@Test(priority=1)
	public void indexRegister_web_15_1(){
		Reporter.log("注册P2:点击首页的导航栏的注册按钮,跳转注册页面<br/>");
		base.openBrowser(base.indexURL);
		//首页点击“注册”
		indexPage.clickRegisterLink();
		//判断跳转注册页面
		registerPage.isTurnRegisterPage();
	}

	/**
	 * 点击首页的点击导航栏下面的广告条中的免费注册按钮,跳转注册页面
	 */
	@Test(priority=2,enabled=false)
	public void indexFreeRegister_web_15_2(){
		Reporter.log("注册P2:点击首页的点击导航栏下面的广告条中的免费注册按钮,跳转注册页面<br/>");
		base.openBrowser(base.indexURL);
		//首页点击“注册”
		indexPage.clickFreeRegister();
		//判断跳转注册页面
		registerPage.isTurnRegisterPage();
	}
	
	/**
	 * 点击点击我的账户免费注册按钮,跳转注册页面
	 */
	@Test(priority=3)
	public void myAccountFreeRegister_web_15_3(){
		Reporter.log("注册P2:点击点击我的账户免费注册按钮,跳转注册页面<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//首页点击“注册”
		loginPage.clickFreeRegister();
		//判断跳转注册页面
		registerPage.isTurnRegisterPage();
	}
	
	/**
	 * 体验店校验  A010BJS_CES043  A010BJS_CES042
	 */
	@Test(priority=4)
	public void checkTiYanDianRegister_web_1263(){
		Reporter.log("注册P2:输入正确邀请码,邀请码正确;多输入体验店邀请码，提示错误;少输入体验店邀请码，提示错误;邀请码使用全角输入,提示错误;点击同意翼龙贷协议  显示协议;点击取消勾选翼龙贷协议,点击下一步,提示请选择翼龙贷协议<br/>");
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		registerPage.selectRole("我要借贷");
		//点击邀请码选项
		registerPage.clickYaoQingMa();
		if (base.indexURL.contains("/client") || base.indexURL.contains("inclient")) {
			//输入正确邀请码,邀请码正确
			registerPage.inputYaoQingMa("A010BJS_CES043");
			registerPage.isYaoQingMaOK();
		}
		//多输入体验店邀请码，提示错误
		registerPage.inputYaoQingMa("A010BJS_CES043A010BJS_CES042");
		registerPage.isYaoQingMaWrong("请填写正确的邀请码，无可不填！");
		//少输入体验店邀请码，提示错误
		registerPage.inputYaoQingMa("A010BJS_CES04");
		registerPage.isYaoQingMaWrong("请填写正确的邀请码，无可不填！");
		//邀请码使用全角输入,提示错误
		registerPage.inputYaoQingMa(base.btoQ("A010BJS_CES04"));
		registerPage.isYaoQingMaWrong("请填写正确的邀请码，无可不填！");
		//点击同意翼龙贷协议  显示协议
		registerPage.clickAgree();
		registerPage.showAgree();
		registerPage.closeAgree();
		//点击取消勾选翼龙贷协议,点击下一步,提示请选择翼龙贷协议
		registerPage.inputTel(data.phoneConcatenation(0));
		registerPage.clickPassword();
		registerPage.inputPassword("111111");
		registerPage.inputRandcode("");
		registerPage.clearYaoQingMa();
		registerPage.cancleAgree();
		registerPage.clickNestStep();
		registerPage.isAgreeWrong();
	}
}
