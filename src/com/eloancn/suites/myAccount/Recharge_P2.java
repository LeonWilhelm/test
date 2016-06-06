package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RechargePage;

/**
 * ��ֵ-P2
 * @author ����Ԫ
 */
public class Recharge_P2 {
	Base base = new Base();
	LoginPage loginPage =  new LoginPage();
	RechargePage rechargePage =  new RechargePage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		String tel = "13111111161";
		String password = "111111";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_tel;
			password = Data.test_password;
		}
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
	}

	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}

	@Test
	public void checkLimt_web_3523(){
		Reporter.log("��ֵP2��������ֵ����֤�������޶����ȷ��<br/>");
		myAccountPage.turnToMyAccount("��ֵ");
		rechargePage.checkAllBankLimit();
	}

}
