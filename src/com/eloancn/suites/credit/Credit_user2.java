package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.RegisterPage;

public class Credit_user2 {
	Base base = new Base();
	RegisterPage registerPage = new RegisterPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	RechargePage rechargePage = new RechargePage();
	
	public String tel3 = Data.tel3;//13611111116
	String password = Data.password;
	String idCard3 = new Data().idConcatenation();
	String realName3 = "��ά��";
	String zzmm = Data.zzmm;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/********************Ͷ���û�3*********************/
	/**
	 * ����Ԫ
	 * ��ҪͶ��-ע��-��ֵ-��ת������ֵ��ҳ��
	 */
	@Test(priority = 1)
	public void register2_AT_474(){
		Reporter.log("ɢ��Ͷ������-Ͷ����ע�ᣬ�û�2����ҪͶ��-ע��-��ֵ-��ת������ֵ��ҳ��");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel3 = "13681358762";
			idCard3 = "362233198811053033";
			realName3 = "�ƾ�";
		}
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		System.out.println(tel3);
		//��ҳ���ע��
		//indexPage.clickRegisterLink();
		//ע��
		registerPage.register("credit", tel3, password);
		//��֤ע��ɹ�
		registerPage.isRegisterOK();
		//���'ȥ��ֵ'
		registerPage.clickRecharge();
		base.sleep(3000);
		//�ж��Ƿ���ת����ֵ����,����ʾ�����֤
		rechargePage.isIdentityInfo();
		myAccountPage.isGoMyAccount("��ֵ");
		
	}
	/**
	 * ����Ԫ
	 * ���Ƹ�����Ϣ
	 */
	@Test(priority = 2)
	public void setInfo2_AT_734(){
		Reporter.log("ɢ��Ͷ�����̣��û�2�����Ƹ�����Ϣ");
		rechargePage.setInfo(realName3,idCard3,zzmm);
		base.sleep(5000);
	}
}
