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
 * ��ɢ��Ͷ�ʡ�����-����Ԫ
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
	
	/********************Ͷ���û�2*********************/
	/**
	 * ����Ԫ
	 * ��ֵ ������ֵ
	 */
	@Test(priority = 1)
	public void rechargeCyberBank_AT_478(){
		Reporter.log("Ͷ�����̣���ֵ ������ֵ����ת�����������С���ֵ����<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(tel2, password);
		}
		myAccountPage.turnToMyAccount("��ֵ");
		rechargePage.rechargeCyberBank("10");
		rechargePage.isJianShePage();
	}
	
	/**
	 * ����Ԫ
	 * ��ֵ ת�˻��
	 */
	@Test(priority = 2,enabled=false)
	public void rechargeTransferRemittance_AT_479(){
		Reporter.log("Ͷ�����̣���ֵ ת�˻���ʾ�ɹ�<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel2, password);
		}
		myAccountPage.turnToMyAccount("��ֵ");
		System.out.print("������"+realName2 +"\n"+"���֤�ţ�"+idCard2);
		rechargePage.rechargeTransferRemittance(realName2, idCard2, zzmm,"2015-05-01","10","�й�����","3333","�Զ������ԣ���ܣ�лл");
		//�ж��Ƿ��ֵ�ɹ�
		rechargePage.isRecharge();
	}
	
	/**
	 * ����Ԫ
	 * ��ȫ��֤ ���п�����
	 */
	@Test (priority = 3)
	public void addBank_AT_483(){
		Reporter.log("Ͷ�����̣���ȫ��֤--���п����ã�������п�<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel2, password);
		}
		myAccountPage.turnToMyAccount("��ȫ��֤");
		//��� ���п�����
		securityAuthPage.clickBankManage();
		//������п�
		securityAuthPage.addBank(bank, "��������","����","����", "�������йɷ����޹�˾����������֧��",tel2);//"13111111150"
		securityAuthPage.isAddBankOK();		
	}
	
	/**
	 * ����Ԫ
	 * ����
	 */
	@Test (priority = 4)
	public void withDraw_AT_490(){
		Reporter.log("Ͷ�����̣�����<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel2, password);
		}
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("����");
		withDrawPage.withDraw("3", zzmm);//"sunny783117"
		withDrawPage.isWithDrawOK();
	}
}
