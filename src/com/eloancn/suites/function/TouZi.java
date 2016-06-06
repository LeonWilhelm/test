package com.eloancn.suites.function;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.AccountInfoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.RegisterPage;
import com.eloancn.shared.pages.SecurityAuthPage;
import com.eloancn.shared.pages.WithDrawPage;

public class TouZi {
	Base base = new Base();
	Data data = new Data();
	RegisterPage registerPage = new RegisterPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	RechargePage rechargePage = new RechargePage();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	WithDrawPage withDrawPage = new WithDrawPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
	}
	
	@AfterClass
	public void teardownAfter(){
		base.logout();
		base.tearDown();
	}
	
	@Test(priority = 1,invocationCount=2)
	public void register_AT_474(){
		String tel2 = data.phoneConcatenation(0);
		String password = Data.password;
		String idCard2 = data.idConcatenation();//new Data().idConcatenation();
		String realName2 = data.getFullName();
		String email2 = data.emailConcatenation(3,2);
		String zzmm = Data.zzmm;
		String bank = Data.bankAccount;
		Reporter.log("散标投资流程-投资者注册：我要投资-注册-充值-跳转至“充值”页面<br/>");
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		Reporter.log("初始手机："+tel2+"  身份证："+idCard2+"  姓名："+realName2);
		tel2 = registerPage.register("credit", tel2, password);
		System.out.println("散标投资流程-投资者注册,初始手机："+tel2+"  姓名："+realName2);
		//验证注册成功
		registerPage.isRegisterOK();
		//点击'去充值'
		registerPage.clickRecharge();
		//判断是否跳转至充值界面,并提示身份认证
		//rechargePage.closeInfo();
		rechargePage.isIdentityInfo();
		myAccountPage.isGoMyAccount("充值");	
		System.out.println("注册成功");
		Reporter.log("散标投资流程：完善个人信息<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("充值");
		String info[] = rechargePage.setInfo(realName2,idCard2,zzmm);
		realName2 = info[0];
		idCard2 = info[1];
		System.out.println("身份证："+idCard2);
		System.out.println("身份认证成功");
	}
	
}
