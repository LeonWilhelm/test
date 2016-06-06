package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
/**
 * ����Ԫ
 * ��¼P1
 */
public class Login_P1 {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	
	String tel = "";
	
	@BeforeMethod
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
	}
	
	@AfterMethod
	public void teardownAfter(){
		base.tearDown();
	}

	@Test(priority=1)
	public void wrongTelAndPassLogin_web_1256(){
		Reporter.log("��ҳ��¼���������˻������룬��ʾ�˻�����������˻��������������գ�����ʾ��֤������ģ�飻���X��ť,�رյ�¼����<br/>");//���ٴε�¼������ȷ���˻������룬�˻���½�ɹ�
		indexPage.clickLoginLink();
		loginPage.login("13121231232", "222222");
		//��ʾ�˻�����������˻��������������գ�����ʾ��֤������ģ��
		loginPage.isLoginWrong();
		//���X��ť,�رյ�¼����
		loginPage.closeLogin();
		/*//�ٴε�¼������ȷ���˻������룬�˻���½�ɹ�
		indexPage.clickLoginLink();
		loginPage.login("13111111171", "111111");
		base.sleep(5000);
		loginPage.isLoginOK();*/
	}
	
	@Test(priority=2)
	public void trueTelWrongPassLogin_web_1304_1(){
		Reporter.log("������ȷ���˺š��������룬���ܵ�¼<br/>");
		indexPage.clickLoginLink();
		tel = "13111111171";
		String pwd = "222222";
		loginPage.login(tel, pwd);
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_tel;
		}
		//��ʾ�˻�����������˻��������������գ�����ʾ��֤������ģ��
		loginPage.isLoginWrong();
	}
	
	@Test(priority=3)
	public void wrongTelTruePassLogin_web_1304_2(){
		Reporter.log("������˻�����ȷ������,���ܵ�¼<br/>");
		indexPage.clickLoginLink();
		loginPage.login("13121231232", "111111");
		loginPage.isLoginWrong();
	}
}
