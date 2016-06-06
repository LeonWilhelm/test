package com.eloancn.suites.myAccount;


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
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RechargePage;

/**
 * ���ҵ��˻���P1����
 * @author ������
 */
public class MyAccount_P1 {
	
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	RechargePage rechargePage = new RechargePage();
	IndexPage indexPage = new IndexPage();
	
	String url;
	String MyAccountUrl = base.indexURL + "/page/userMgr/myHome.jsp";
	String tel = "";
	String tel_client = Data.tel_run_MyAccount;
	String tel_test = Data.test_tel_run_MyAccount;
	String pass = Data.zzmm;
	String name = "";
	String name_client = Data.name_run_MyAccount;
	String name_test = Data.test2_realName;
	String id = Data.id_run_MyAccount;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		url = base.getWebsiteServerName(base.indexURL);
		
		if(url.equals("client") || url.equals("inclient")){
			tel = tel_client;
			name = name_client;
		}
		else if(url.equals("test") || url.equals("www")){
			tel = tel_test;
			name = name_test;
		}
	}
	
	@BeforeMethod
	public void methodBefore(){
		base.openBrowser(MyAccountUrl);
	}

	@AfterMethod
	public void methodAfter(){
		base.logout();
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * ��֤��ֵ�״�������������ʾ��Ϣ
	 * ��ע����������ţ�4613
	 * @author ������
	 */
	@Test(priority = 1)
	public void checkNameNoticeInfomation_web_29(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>��֤��ֵ�״�������������ʾ��Ϣ");
		loginPage.loginWithNoFrame(tel, pass);
		base.openBrowser(MyAccountUrl);
		//�����ֵҳ��
		myAccountPage.turnToMyAccount("��ֵ");
		base.sleep(2000);
		//�ж��Ƿ���ת����ֵ����
		rechargePage.isIdentityInfo();
		myAccountPage.isGoMyAccount("��ֵ");	
		//��������
		rechargePage.setInfoByIdCard(id);
		//��������������֤�����Ƿ���ȷ
		myAccountPage.checkNameNoticeInformation(rechargePage.nameMsg, rechargePage.nameCheckmarkImg);
	}
	
	/**
	 * ��֤��ֵ�״������֤�����֤����ʾ��Ϣ
	 * ��ע����������ţ�4614
	 * @author ������
	 */
	@Test(priority = 2)
	public void checkIdCardNoticeInfomation_web_30(){
		
		Reporter.log("�ҵ��˻�_P1���ҵ��˻�����>��֤��ֵ�״������֤�����֤����ʾ��Ϣ");
		loginPage.loginWithNoFrame(tel, pass);
		base.openBrowser(MyAccountUrl);
		//�����ֵҳ��
		myAccountPage.turnToMyAccount("��ֵ");
		base.sleep(2000);
		//�ж��Ƿ���ת����ֵ����
		rechargePage.isIdentityInfo();
		myAccountPage.isGoMyAccount("��ֵ");	
		//��������
		rechargePage.setInfoByRealName(name);
		//�������֤�ţ�����֤�����Ƿ���ȷ
		myAccountPage.checkIdCardNoticeInformation();
	}
	
	
	/**
	 * ��֤��ֵ�״������֤��֧��������ʾ��Ϣ
	 * ��ע�������ֻ��ţ�18810882570����ʾ��Ϣ������Ϊ׼
	 * ��ע����������ţ�4616
	 * @author ������
	 */
	@Test(priority = 3)
	public void checkPayPasswordNoticeInfomation_web_34(){
		
		Reporter.log("�ҵ��˻�_P1:�ҵ��˻�����>��֤��ֵ�״������֤��֧��������ʾ��Ϣ");
		loginPage.loginWithNoFrame(tel, pass);
		base.openBrowser(MyAccountUrl);
		//�����ֵҳ��
		myAccountPage.turnToMyAccount("��ֵ");
		base.sleep(2000);
		//�ж��Ƿ���ת����ֵ����
		rechargePage.isIdentityInfo();
//		myAccountPage.isGoMyAccount("��ֵ");	
		//��������
		rechargePage.setInfoByRealName(name);
		//�������֤��
		rechargePage.setInfoByIdCard(id);
		//����֧�����룬����֤�����Ƿ���ȷ
		myAccountPage.checkPayPasswordNoticeInformation();
	}
}
