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
 * ��ȫ��֤
 * ����Ԫ
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
	String realName = "����";
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
		Reporter.log("��ȫ��֤P1����ȫ��֤-���֤��֤�����֤����������ȷ��ƥ��,��ȫ��֤��ʵ����֤��ʾΪ����֤,���г�ֵ������ʸ���֤��������ʾ��Ҫ�����֤<br/>");
		//ע��
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		//�����֤
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.identityAuthentication(realName,idCard);
		//��֤�ɹ�
		securityAuthPage.isIdentityAuthenticationOK("�����֤�ɹ�");
		myAccountPage.turnToMyAccount("��ֵ");
		rechargePage.isIdentityInfo();
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.isAuthentication("���֤��","����֤");
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.isShowIdentityAuthentication(true);
	}
}
