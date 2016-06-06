package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.AccountInfoPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.RegisterPage;
import com.eloancn.shared.pages.SecurityAuthPage;

/**
 * 安全认证
 * 徐天元
 */
public class SecurityAuth_P1 {
	Data data = new Data();
	LoginPage loginPage = new LoginPage();
	Base base = new Base();
	MyAccountPage myAccountPage = new MyAccountPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	RegisterPage registerPage = new RegisterPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	RechargePage rechargePage = new RechargePage();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	
	String tel = data.phoneConcatenation(0);
	String realName = "张三";
	String idCard = data.idConcatenation();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P1_tel;
			realName = Data.test_run_SecurityAuth_P1_realName;
			idCard = Data.test_run_SecurityAuth_P1_idCard;
		}
	}

	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(priority = 1)
	public void identityAuthentication_web_3527(){//15285411043
		Reporter.log("安全认证P1：安全认证-身份证认证，身份证号姓名都正确且匹配,安全认证中实名认证显示为已认证,进行充值或借入资格认证不会再提示需要身份认证<br/>");
		//注册
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		//身份认证
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.identityAuthentication(realName,idCard);
		//认证成功
		securityAuthPage.isIdentityAuthenticationOK("身份认证成功");
		myAccountPage.turnToMyAccount("充值");
		rechargePage.isIdentityInfo();
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.isAuthentication("身份证号","已认证");
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.isShowIdentityAuthentication(true);
	}
}
