package com.eloancn.suites.credit;

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

/*
 * “散标投资注册流程”用例-徐天元
 */
public class Credit {
//	static Logger logger = Logger.getLogger(Credit.class);
	Base base = new Base();
	RegisterPage registerPage = new RegisterPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	RechargePage rechargePage = new RechargePage();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	WithDrawPage withDrawPage = new WithDrawPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	
	public String tel2 = Data.tel2;
	String password = Data.password;
	String idCard2 = new Data().idConcatenation();
	String realName2 = Data.realName2;
	String email2 = Data.email2;
	String zzmm = Data.zzmm;
	String bank = Data.bankAccount;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel2 = Data.test_register_credit_tel;
			idCard2 = Data.test_register_credit_idCard;
			realName2 = Data.test_register_credit_realName;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.logout();
		base.tearDown();
	}
	
	/********************投资用户2*********************/
	/**
	 * 徐天元
	 * 我要投资-注册-充值-跳转至“充值”页面
	 */
	@Test
	public void register_AT_474(){
		Reporter.log("散标投资流程-投资者注册：我要投资-注册-充值-跳转至“充值”页面<br/>");
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		System.out.println("散标投资流程-投资者注册,初始手机："+tel2+"  身份证："+idCard2+"  姓名："+realName2);
		Reporter.log("初始手机："+tel2+"  身份证："+idCard2+"  姓名："+realName2);
		tel2 = registerPage.register("credit", tel2, password);
		//验证注册成功
		registerPage.isRegisterOK();
		//点击'去充值'
		registerPage.clickRecharge();
		//判断是否跳转至充值界面,并提示身份认证
		//rechargePage.closeInfo();
		rechargePage.isIdentityInfo();
		myAccountPage.isGoMyAccount("充值");	
	}
	/**
	 * 徐天元
	 * 完善个人信息
	 */
	@Test(dependsOnMethods="register_AT_474")
	public void setInfo_AT_477(){
		Reporter.log("散标投资流程：完善个人信息<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("充值");
		String info[] = rechargePage.setInfo(realName2,idCard2,zzmm);
		realName2 = info[0];
		idCard2 = info[1];
		base.sleep(5000);
	}
	
	/**
	 * 徐天元
	 * 已认证的账户，修改邮箱
	 */
	@Test (dependsOnMethods="setInfo_AT_477")
	public void setEmailAccountInfo_AT_482(){
		Reporter.log("散标投资流程：已认证的账户，修改邮箱<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("账户信息");
		accountInfoPage.updateEmailInfo(email2,realName2,idCard2);
		accountInfoPage.isUpdateOK("保存成功!");
	}
}
