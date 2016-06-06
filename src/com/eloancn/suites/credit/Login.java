package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.*;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RegisterPage;

/*
 * ����¼������
 */
public class Login {
	IndexPage indexPage = new IndexPage();
	RegisterPage registerPage = new RegisterPage();
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
	String tel = Data.tel_run_debit2;//Data.email
	String password = Data.password;
	String idCord = Data.idCard_run_credit;
	String email = Data.email_run_debit2;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_tel;//Data.email
			idCord = Data.test_idCard;
			email = Data.test_email;
			password = Data.test_password;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}

	/**
	 * ����Ԫ
	 * ��ҳ��¼--�ص���ҳ
	 */
	@Test (priority=1)
	public void login_AT_493(){
		Reporter.log("ɢ��Ͷ�����̣���ҳ��¼--�ص���ҳ<br/>");
		//�������¼��
		indexPage.clickLoginLink();
		//��¼
		loginPage.login(tel, password);//1112@126.com  //������"ff@qq.com"
		//��֤��¼�Ƿ�ɹ�
		loginPage.isLoginOK();
		//��֤�Ƿ���ת����ҳ
		indexPage.isturnToIndexPage();
	}
	
	/**
	 * ����Ԫ
	 * �ҵ��˻���¼--��ת���ҵ��˻�--�˻�����ҳ��
	 */
	@Test (priority=2)
	public void loginMyAccount_AT_497(){
		Reporter.log("ɢ��Ͷ�����̣��ҵ��˻��ֻ���¼--��ת���ҵ��˻�--�˻�����ҳ��<br/>");
		//�˳�
		base.logout();
		//������ҵ��˻���
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//��¼
		loginPage.loginWithNoFrame(tel, password);//1231@qq.com  //������"ff@qq.com"
		//��֤��¼�Ƿ�ɹ�
		loginPage.isLoginOK();
		//��֤�Ƿ�����ҵ��˻�-�˻�����ҳ��
		myAccountPage.isGoMyAccount("�˻�����");
	}

	/**
	 * ����Ԫ
	 * �ҵ��˻����֤�ŵ�¼--��ת���ҵ��˻�--�˻�����ҳ��
	 */
	@Test (priority=3)
	public void loginMyAccountByIdCard_AT_735(){
		Reporter.log("ɢ��Ͷ�����̣��ҵ��˻����֤�ŵ�¼--��ת���ҵ��˻�--�˻�����ҳ��<br/>");
		//�˳�
		base.logout();
		//������ҵ��˻���
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//��¼
		loginPage.loginWithNoFrame(idCord, password);//1231@qq.com  //������"ff@qq.com"
		//��֤��¼�Ƿ�ɹ�
		loginPage.isLoginOK();
		//��֤�Ƿ�����ҵ��˻�-�˻�����ҳ��
		myAccountPage.isGoMyAccount("�˻�����");
	}
	
	/**
	 * ����Ԫ
	 * �ҵ��˻������¼--��ת���ҵ��˻�--�˻�����ҳ��
	 */
	@Test (priority=4)
	public void loginMyAccountByEmail(){
		Reporter.log("ɢ��Ͷ�����̣��ҵ��˻������¼--��ת���ҵ��˻�--�˻�����ҳ��<br/>");
		//�˳�
		base.logout();
		//������ҵ��˻���
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//��¼
		loginPage.loginWithNoFrame(email, password);//1231@qq.com  //������"ff@qq.com"
		//��֤��¼�Ƿ�ɹ�
		loginPage.isLoginOK();
		//��֤�Ƿ�����ҵ��˻�-�˻�����ҳ��
		myAccountPage.isGoMyAccount("�˻�����");
	}
}
