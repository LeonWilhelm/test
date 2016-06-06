package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.TotalPage;
import com.eloancn.shared.pages.YCBPage;

/**
 * �ҵ��˻�����>��汦
 */
public class ECunBao {

	Base base = new Base();
	
	YCBPage yCBPage = new YCBPage();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
	String tel;			//�ֻ���
	String pass;		//����
	String day;         //��Լ����
	String eCunBaoName;  //��汦��Ʒ����
	
	String tel_client = Data.tel_run_EcunBao; 
	String pass_client = Data.zzmm;
	String day_client = "365";
	String eCunBaoName_client = "dongcai3";
	
	String tel_test = Data.test2_tel;
	String pass_test = Data.test2_password;
	String day_test = "365";
	String eCunBaoName_test = "1979��";
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			
			tel = tel_client;
			pass = pass_client;
			day = day_client;
			eCunBaoName = eCunBaoName_client;
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			
			tel = tel_test;
			pass = pass_test;
			day = day_test;
			eCunBaoName = eCunBaoName_test;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}

	/*****************************************************/
	/************    ��汦_������_�鿴����_ծȨ����          ************/
	/*****************************************************/
	
	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void checkBondDetails_AT_5265(){
		
		Reporter.log("�ҵ��˻�_������ ����>1.������汦������Title������鿴����_ծȨ���飬�ٵ����ծȨ���顱���ӣ������Ƿ��<br/>");
		Reporter.log("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����<br/>");
		Reporter.log("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ<br/>");
		Reporter.log("4.�ٴε�����鿴���顱��ť��������ر�<br/>");
		Reporter.log("5.����رհ�ť�����ڹر�<br/>");
		System.out.println("�ҵ��˻�_������ ����>1.������汦������Title������鿴����_ծȨ���飬�ٵ����ծȨ���顱���ӣ������Ƿ��");
		System.out.println("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����");
		System.out.println("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ");
		System.out.println("4.�ٴε�����鿴���顱��ť��������ر�");
		System.out.println("5.����رհ�ť�����ڹر�");
		
		if(loginPage.ifLogin()){//�����¼����ǳ�
			base.logout();
		}
		loginPage.loginByMyAccount(tel, pass);
		
		TotalPage.openPage("�ҵ��˻�", true);
		myAccountPage.turnToMyAccount("��汦");
		
		yCBPage.clickPartake();								//����������С�
		yCBPage.checkPartake();
		yCBPage.clickAppointViewDetails(day);
		yCBPage.checkViewDetails(day);
		yCBPage.checkViewDetailsByValue(eCunBaoName);
		yCBPage.clickOperate(eCunBaoName, "ծȨ����");
		yCBPage.checkCreditorDetailsDIV();
		yCBPage.checkBondDetailsDIVColumnName();
		yCBPage.checkBondDetailsDIVColumnValue("������");
		yCBPage.checkBondDetailsDIVColumnValue("���������");
		yCBPage.checkBondDetailsDIVColumnValue("���֤��");
		yCBPage.checkBondDetailsDIVColumnValue("����");
		yCBPage.checkBondDetails();
	}
}
