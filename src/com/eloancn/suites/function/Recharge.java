package com.eloancn.suites.function;

//import org.apache.log4j.Logger;
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
public class Recharge {
//	static Logger logger = Logger.getLogger(Credit2.class);
	Base base = new Base();
	RegisterPage registerPage = new RegisterPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	RechargePage rechargePage = new RechargePage();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	WithDrawPage withDrawPage = new WithDrawPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	
	public String tel2 = "15663677071";//13611111116
	String password = "15663677071";
	String idCard2 = new Data().idConcatenation();
	String realName2 = Data.realName2;
	String email2 = Data.email2;
	String zzmm = Data.zzmm;
	String bank = Data.bankAccount;
	int times=0;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		/*if (base.indexURL.contains("/client")) {
			tel2 = Data.tel_run_debit2;
		}*/
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel2 = Data.test_tel;
			password = Data.test_password;
			zzmm = Data.test_zzmm;
			realName2 = Data.test_realName;
			idCard2 = Data.test_idCard;
			email2 = Data.test_email;
		}
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel2, password);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/********************Ͷ���û�2*********************/
//	/**
//	 * ����Ԫ
//	 * ��ֵ ������ֵ
//	 */
//	@Test(priority = 2)
//	public void rechargeCyberBank_AT_478(){
//		Reporter.log("Ͷ�����̣���ֵ ������ֵ����ת�����������С���ֵ����<br/>");
//		myAccountPage.turnToMyAccount("��ֵ");
//		rechargePage.rechargeCyberBank("10");
//		rechargePage.isJianShePage();
//	}
	
	/**
	 * ����Ԫ
	 * ��ֵ ת�˻��
	 */
	@Test(priority = 1,invocationCount=100)
	public void rechargeTransferRemittance_AT_479(){
		Reporter.log("Ͷ�����̣���ֵ ת�˻���ʾ����ϲ���������֤�ѳɹ���<br/>");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		myAccountPage.turnToMyAccount("��ֵ");
		System.out.print("������"+realName2 +"\n"+"���֤�ţ�"+idCard2);
		rechargePage.rechargeTransferRemittance(realName2, idCard2, zzmm,"2015-05-01","99000000","�й�����","3333","�Զ������ԣ���ܣ�лл");
		//�ж��Ƿ��ֵ�ɹ�
		rechargePage.isRecharge();
		times++;
		System.out.println("��"+times+"��ֵ�ɹ�");
	}
	
//	/**
//	 * ����Ԫ
//	 * ��ȫ��֤ ���п�����
//	 */
//	@Test (priority = 3)
//	public void addBank_AT_483(){
//		Reporter.log("Ͷ�����̣���ȫ��֤--���п����ã�������п�<br/>");
//		myAccountPage.turnToMyAccount("��ȫ��֤");
//		//��� ���п�����
//		securityAuthPage.clickBankManage();
//		//������п�
//		securityAuthPage.addBank(bank, "��������","����","����", "�������йɷ����޹�˾����������֧��",tel2);//"13111111150"
//		securityAuthPage.isAddBankOK();		
//	}
//	
//	/**
//	 * ����Ԫ
//	 * ����
//	 */
//	@Test (priority = 4)
//	public void withDraw_AT_490(){
//		Reporter.log("Ͷ�����̣�����<br/>");
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		myAccountPage.turnToMyAccount("����");
//		withDrawPage.withDraw("3", zzmm);//"sunny783117"
//		withDrawPage.isWithDrawOK();
//	}
}
