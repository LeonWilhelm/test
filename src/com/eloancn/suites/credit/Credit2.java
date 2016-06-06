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
 * “散标投资”用例-徐天元
 */
public class Credit2 {

	Base base = new Base();
	RegisterPage registerPage = new RegisterPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	RechargePage rechargePage = new RechargePage();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	WithDrawPage withDrawPage = new WithDrawPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	
	public String tel2 = Data.tel2;//13611111116
	String password = Data.password;
	String idCard2 = new Data().idConcatenation();
	String realName2 = Data.realName2;
	String email2 = Data.email2;
	String zzmm = Data.zzmm;
	String bank = Data.bankAccount;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if (base.indexURL.contains("/client")) {
			tel2 = Data.tel_run_debit2;
		}
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel2 = Data.test_tel;
			password = Data.test_password;
			zzmm = Data.test_zzmm;
			realName2 = Data.test_realName;
			idCard2 = Data.test_idCard;
			email2 = Data.test_email;
		}
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//loginPage.loginWithNoFrame(tel2, password);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/********************投资用户2*********************/
	/**
	 * 徐天元
	 * 充值 网银充值
	 */
	@Test(priority = 1)
	public void rechargeCyberBank_AT_478(){
		Reporter.log("投资流程：充值 网银充值，跳转至“建设银行”充值界面<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(tel2, password);
		}
		myAccountPage.turnToMyAccount("充值");
		rechargePage.rechargeCyberBank("10");
		rechargePage.isJianShePage();
	}
	
	/**
	 * 徐天元
	 * 充值 转账汇款
	 */
	@Test(priority = 2,enabled=false)
	public void rechargeTransferRemittance_AT_479(){
		Reporter.log("投资流程：充值 转账汇款，提示成功<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel2, password);
		}
		myAccountPage.turnToMyAccount("充值");
		System.out.print("姓名："+realName2 +"\n"+"身份证号："+idCard2);
		rechargePage.rechargeTransferRemittance(realName2, idCard2, zzmm,"2015-05-01","10","中国银行","3333","自动化测试，请拒！谢谢");
		//判断是否充值成功
		rechargePage.isRecharge();
	}
	
	/**
	 * 徐天元
	 * 安全认证 银行卡设置
	 */
	@Test (priority = 3)
	public void addBank_AT_483(){
		Reporter.log("投资流程：安全认证--银行卡设置，添加银行卡<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel2, password);
		}
		myAccountPage.turnToMyAccount("安全认证");
		//点击 银行卡管理
		securityAuthPage.clickBankManage();
		//添加银行卡
		securityAuthPage.addBank(bank, "招商银行","北京","北京", "招商银行股份有限公司北京北三环支行",tel2);//"13111111150"
		securityAuthPage.isAddBankOK();		
	}
	
	/**
	 * 徐天元
	 * 提现
	 */
	@Test (priority = 4)
	public void withDraw_AT_490(){
		Reporter.log("投资流程：提现<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel2, password);
		}
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("提现");
		withDrawPage.withDraw("3", zzmm);//"sunny783117"
		withDrawPage.isWithDrawOK();
	}
}
