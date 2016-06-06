package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.RegisterPage;

public class Credit_user2 {
	Base base = new Base();
	RegisterPage registerPage = new RegisterPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	RechargePage rechargePage = new RechargePage();
	
	public String tel3 = Data.tel3;//13611111116
	String password = Data.password;
	String idCard3 = new Data().idConcatenation();
	String realName3 = "高维佳";
	String zzmm = Data.zzmm;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/********************投资用户3*********************/
	/**
	 * 徐天元
	 * 我要投资-注册-充值-跳转至“充值”页面
	 */
	@Test(priority = 1)
	public void register2_AT_474(){
		Reporter.log("散标投资流程-投资者注册，用户2：我要投资-注册-充值-跳转至“充值”页面");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel3 = "13681358762";
			idCard3 = "362233198811053033";
			realName3 = "黄军";
		}
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		System.out.println(tel3);
		//首页点击注册
		//indexPage.clickRegisterLink();
		//注册
		registerPage.register("credit", tel3, password);
		//验证注册成功
		registerPage.isRegisterOK();
		//点击'去充值'
		registerPage.clickRecharge();
		base.sleep(3000);
		//判断是否跳转至充值界面,并提示身份认证
		rechargePage.isIdentityInfo();
		myAccountPage.isGoMyAccount("充值");
		
	}
	/**
	 * 徐天元
	 * 完善个人信息
	 */
	@Test(priority = 2)
	public void setInfo2_AT_734(){
		Reporter.log("散标投资流程，用户2：完善个人信息");
		rechargePage.setInfo(realName3,idCard3,zzmm);
		base.sleep(5000);
	}
}
