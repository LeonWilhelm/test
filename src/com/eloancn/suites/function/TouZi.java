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
		Reporter.log("ɢ��Ͷ������-Ͷ����ע�᣺��ҪͶ��-ע��-��ֵ-��ת������ֵ��ҳ��<br/>");
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		Reporter.log("��ʼ�ֻ���"+tel2+"  ���֤��"+idCard2+"  ������"+realName2);
		tel2 = registerPage.register("credit", tel2, password);
		System.out.println("ɢ��Ͷ������-Ͷ����ע��,��ʼ�ֻ���"+tel2+"  ������"+realName2);
		//��֤ע��ɹ�
		registerPage.isRegisterOK();
		//���'ȥ��ֵ'
		registerPage.clickRecharge();
		//�ж��Ƿ���ת����ֵ����,����ʾ�����֤
		//rechargePage.closeInfo();
		rechargePage.isIdentityInfo();
		myAccountPage.isGoMyAccount("��ֵ");	
		System.out.println("ע��ɹ�");
		Reporter.log("ɢ��Ͷ�����̣����Ƹ�����Ϣ<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ֵ");
		String info[] = rechargePage.setInfo(realName2,idCard2,zzmm);
		realName2 = info[0];
		idCard2 = info[1];
		System.out.println("���֤��"+idCard2);
		System.out.println("�����֤�ɹ�");
	}
	
}
