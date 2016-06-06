package com.eloancn.suites.myAccount;

import java.util.HashMap;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.InsideLetterPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyRewardPage;
import com.eloancn.shared.pages.TransactionRecordPage;

/**
 * ���ҵ��˻���P1�����ҵ������
 * test����û���˻�
 * @author ������
 */
public class MyExperience_P2 {
	
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	IndexPage indexPage = new IndexPage();
	MyRewardPage myRewardPage = new MyRewardPage();
	InsideLetterPage insideLetterPage = new InsideLetterPage();
	TransactionRecordPage transactionRecordPage = new TransactionRecordPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	
	String tel_NoInterest;
	String tel_Interest;
	String email_Interest;
	String pass;
	
	String url;
	String MyAccountUrl = base.indexURL + "/page/userMgr/myHome.jsp";
	
	String tel_NoInterest_client = Data.tel_ExperienceNoInterest_client;
	String tel_Interest_client = Data.tel_ExperienceInterest_client;
	String email_Interest_client = Data.email_ExperienceInterest_client;
	String pass_client = Data.zzmm;
	
	String tel_NoInterest_test = Data.tel_ExperienceNoInterest_test;
	String tel_Interest_test = Data.tel_ExperienceInterest_test;
	String email_Interest_test = Data.email_ExperienceInterest_test;
	String pass_test = Data.zzmm;
	
	String insideLetterIDByInvestment = "9559131";      //Ͷ����������汦��վ����ID��Ҳ�ɴ�ҳ���ȡ
	String insideLetterIDByInterest = "10059584";       //��Ϣ��������汦��վ����ID��Ҳ�ɴ�ҳ���ȡ
	String insideLetterIDByEnd = "10017118";       		//������������汦��վ����ID��Ҳ�ɴ�ҳ���ȡ
	
	
	@BeforeClass
	public void classBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		url = base.getWebsiteServerName(base.indexURL);
		
		if(url.equals("client") || url.equals("inclient")){
			tel_NoInterest = tel_NoInterest_client;
			tel_Interest = tel_Interest_client;
			email_Interest = email_Interest_client;
			pass = pass_client;
		}
		else if(url.equals("test") || url.equals("www")){
			tel_NoInterest = tel_NoInterest_test;
			tel_Interest = tel_Interest_test;
			email_Interest = email_Interest_test;
			pass = pass_test;
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
	public void classAfter(){
		base.tearDown();
	}
	
	//�������裺
	//1.��̨����>�����>������Ʒ����>���������汦����>����
	//2.ǰ̨����>Ͷ���շ�������汦�������ڵĲ�ƥ��ծȨ�ģ�
	//3.��̨����>��ع�����>�ֻ��������� ����>��û�ж�Ӧ�ֻ��ŵ������
	//4.http://192.168.1.229:8780/61/index61.jsp��ע�����ֻ��ţ�ҳ���޷����ʣ��ҷ���ԣ�
	//5.ǰ̨����>ע�ᡪ��>Ͷ���ˡ���>ʵ����֤
	//��ע�����˻����ܹ���������汦���ֵ�Ȳ���
	
	/**
	 * ��֤�ҵ������-���飨���ơ���
	 * @author ������
	 */
	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void checkTheDetailsOfMyExperiences1_web_909(){
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>�ҵĽ�������>��֤�ҵ������-���飨���ơ���");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>�ҵĽ�������>��֤�ҵ������-���飨���ơ���");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_NoInterest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("�˻���" + tel_NoInterest + " ��¼ʧ�ܣ�");
				Reporter.log("�˻���" + tel_NoInterest + " ��¼ʧ�ܣ�");
			}
			
			base.openBrowser(MyAccountUrl);
			myAccountPage.turnToMyAccount("�ҵĽ���");
			base.sleep(2000);
			myRewardPage.isMyRewardPage();
			myRewardPage.clickMyExperiencesLnk();
			//У����ʾ�������¼
			myRewardPage.checkMyExperiencesOfData();
			//У�顰�ҵ�������б��е�Ԫ��
			myRewardPage.checkMyExperiencesOfValue();
		}
		else{
			Reporter.log("test/www������û���˻����ݲ�ִ��");
			System.out.println("test/www������û���˻����ݲ�ִ��");
		}
	}
	
	/**
	 * ��֤�ҵ������-���飨��Ч��ֹ�ա�״̬��������
	 * @author ������
	 */
	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void checkTheDetailsOfMyExperiences1_web_910(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>�ҵĽ�������>��֤�ҵ������-���飨��Ч��ֹ�ա�״̬��������");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>�ҵĽ�������>��֤�ҵ������-���飨��Ч��ֹ�ա�״̬��������");
		
		if(url.equals("client") || url.equals("inclient")){
			
			loginPage.loginWithNoFrame(tel_NoInterest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("�˻���" + tel_NoInterest + " ��¼ʧ�ܣ�");
				Reporter.log("�˻���" + tel_NoInterest + " ��¼ʧ�ܣ�");
			}
			
			myAccountPage.turnToMyAccount("�ҵĽ���");
			base.sleep(2000);
			myRewardPage.isMyRewardPage();
			myRewardPage.clickMyExperiencesLnk();
			//У����ʾ�������¼
			myRewardPage.checkMyExperiencesOfData();
	//		tel = "aWeOZxqrMg0M0TKNMWgSlg==";
			//У�顰�ҵ�������б��е�Ԫ��
			if(url.equals("client") || url.equals("inclient")){
				//����Ч��ֹ�ա�
				myRewardPage.checkEffectiveClosingDate(tel_NoInterest);
			}
			if(!base.checkInvisibility(myRewardPage.getMyExperiencesOfBy("״̬_ʧЧ"))){
				//У��"״̬"Ϊ��Ч��"����"Ϊ����ʹ��
				myRewardPage.checkMyExperiencesOfValue(0);
				myRewardPage.clickOperation();
				//У����������汦��¼�Ƿ���ʾ����ֻ��ʾһ��
				myRewardPage.isWMPSListDivShowAndOnlyOne();
			}
			else{
				Reporter.log("error_�������ʧЧ��������ע������");
				System.out.println("error_�������ʧЧ��������ע������");
			}
		}
		else{
			Reporter.log("test/www������û���˻����ݲ�ִ��");
			System.out.println("test/www������û���˻����ݲ�ִ��");
		}
	}
	
	/**
	 * ��֤�ҵ������-��������汦����
	 * @author ������
	 */
	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void checkTheDetailsOfExperiencePeriodECunBao_web_924(){
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>�ҵĽ�������>��֤�ҵ������-��������汦����");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>�ҵĽ�������>��֤�ҵ������-��������汦����");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_NoInterest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("�˻���" + tel_NoInterest + " ��¼ʧ�ܣ�");
				Reporter.log("�˻���" + tel_NoInterest + " ��¼ʧ�ܣ�");
			}
			
			myAccountPage.turnToMyAccount("�ҵĽ���");
			base.sleep(2000);
			myRewardPage.isMyRewardPage();
			myRewardPage.clickMyExperiencesLnk();
			//У����ʾ�������¼
			myRewardPage.checkMyExperiencesOfData();
			//У����������汦����
			myRewardPage.checkExperiencePeriodRule();
		}
		else{
			Reporter.log("test/www������û���˻����ݲ�ִ��");
			System.out.println("test/www������û���˻����ݲ�ִ��");
		}
	}
	
	/**
	 * ��֤�ҵ������-��������汦����
	 * ��ע��ִ����������޷�����
	 * @author ������
	 */
	@Test(priority = 4, enabled = false, invocationCount = 1)
	public void checkTheDetailsOfExperiencePeriodECunBao_web_911(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>�ҵĽ�������>��֤�ҵ������-��������汦���飨�껯���桢�������ޡ���ļ��������Ͷ�ʰ�ť��");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>�ҵĽ�������>��֤�ҵ������-��������汦���飨�껯���桢�������ޡ���ļ��������Ͷ�ʰ�ť��");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_NoInterest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("�˻���" + tel_NoInterest + " ��¼ʧ�ܣ�");
				Reporter.log("�˻���" + tel_NoInterest + " ��¼ʧ�ܣ�");
			}
			
			myAccountPage.turnToMyAccount("�ҵĽ���");
			base.sleep(2000);
			myRewardPage.isMyRewardPage();
			myRewardPage.clickMyExperiencesLnk();
			//У����ʾ�������¼
			myRewardPage.checkMyExperiencesOfData();
			myRewardPage.clickOperation();
			//��֤���껯���桱�����������ޡ�������ļ����
			myRewardPage.checkExperiencePeriodECunBao();
			//У�顰����Ͷ�ʡ��ɹ�
			myRewardPage.checkExperienceInvestment();
			myRewardPage.checkMyExperiencesOfValue(1);
		}
		else{
			Reporter.log("test�����������޷�ִ��");
			System.out.println("test�����������޷�ִ��");
		}
	}
	
	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void checkTransactionDtails_F_3689(){
		
		//���d_funds_info���潻�׼�¼
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>���׼�¼����>���������б�ҳ_ȫ��Tab�еġ����������֧����������");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>���׼�¼����>���������б�ҳ_ȫ��Tab�еġ����������֧����������");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_Interest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("�˻���" + tel_Interest + " ��¼ʧ�ܣ�");
				Reporter.log("�˻���" + tel_Interest + " ��¼ʧ�ܣ�");
			}
			
			myAccountPage.turnToMyAccount("���׼�¼");
			transactionRecordPage.clickTab("ȫ��");
			transactionRecordPage.checkColumnValueInTabList(email_Interest, "������");
			transactionRecordPage.checkColumnValueInTabList(email_Interest, "֧�����");
			transactionRecordPage.checkColumnValueInTabList(email_Interest, "���");
		}
		else{
			Reporter.log("test�����������޷�ִ��");
			System.out.println("test�����������޷�ִ��");
		}
	}
	
	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void checkInsideLetterInvestmentInfo_F_3686(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>վ���š���>��֤վ������ʾͶ����Ϣ�����⡢���ݡ��ռ�ʱ�䣩");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>վ���š���>��֤վ������ʾͶ����Ϣ�����⡢���ݡ��ռ�ʱ�䣩");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_Interest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("�˻���" + tel_Interest + " ��¼ʧ�ܣ�");
				Reporter.log("�˻���" + tel_Interest + " ��¼ʧ�ܣ�");
			}
			
			insideLetterPage.checkInsideLetterNum(email_Interest);
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkUpdateReceiverStatus(insideLetterIDByInvestment, "δ��");
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInvestment, false);
			insideLetterPage.checkInsideLetterInvestmentInListPage(insideLetterIDByInvestment);
			insideLetterPage.clickInsideLetterTitleByIDInListPage(insideLetterIDByInvestment);
			insideLetterPage.checkInsideLetterInvestmentInDetailsPage(insideLetterIDByInvestment);
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInvestment, true);
			insideLetterPage.checkUpdateReceiverStatus(insideLetterIDByInvestment, "δ��");
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInvestment, false);
		}
		else {
			Reporter.log("test�����������޷�ִ��");
			System.out.println("test�����������޷�ִ��");
		}
	}
	
	
	
	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void checkInsideLetterInterestInfo_F_3687(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>վ���š���>��֤վ������ʾ��Ϣ��Ϣ�����⡢���ݡ��ռ�ʱ�䣩");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>վ���š���>��֤վ������ʾ��Ϣ��Ϣ�����⡢���ݡ��ռ�ʱ�䣩");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_Interest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("�˻���" + tel_Interest + " ��¼ʧ�ܣ�");
				Reporter.log("�˻���" + tel_Interest + " ��¼ʧ�ܣ�");
			}
			
			insideLetterPage.checkInsideLetterNum(email_Interest);
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInterest, false);
			insideLetterPage.checkInsideLetterInvestmentInListPage(insideLetterIDByInterest);
			insideLetterPage.clickInsideLetterTitleByIDInListPage(insideLetterIDByInterest);
			insideLetterPage.checkInsideLetterInvestmentInDetailsPage(insideLetterIDByInterest);
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInterest, true);
			insideLetterPage.checkUpdateReceiverStatus(insideLetterIDByInterest, "δ��");
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInterest, false);
		}
		else {
			Reporter.log("test�����������޷�ִ��");
			System.out.println("test�����������޷�ִ��");
		}
	}
	
	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void checkInsideLetterEndInfo_F_3688(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>վ���š���>��֤վ������ʾ��Ϣ��Ϣ�����⡢���ݡ��ռ�ʱ�䣩");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>վ���š���>��֤վ������ʾ��Ϣ��Ϣ�����⡢���ݡ��ռ�ʱ�䣩");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame("13800138002", pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("�˻���" + "13800138002" + " ��¼ʧ�ܣ�");
				Reporter.log("�˻���" + "13800138002" + " ��¼ʧ�ܣ�");
			}
			
			insideLetterPage.checkInsideLetterNum("yh2@11.com");
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkUpdateReceiverStatus(insideLetterIDByEnd, "δ��");
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByEnd, false);
			insideLetterPage.checkInsideLetterInvestmentInListPage(insideLetterIDByEnd);
			insideLetterPage.clickInsideLetterTitleByIDInListPage(insideLetterIDByEnd);
			base.sleep(5000);
			insideLetterPage.checkInsideLetterInvestmentInDetailsPage(insideLetterIDByEnd);
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByEnd, true);
			insideLetterPage.checkUpdateReceiverStatus(insideLetterIDByEnd, "δ��");
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByEnd, false);
		}
		else{
			Reporter.log("test�����������޷�ִ��");
			System.out.println("test�����������޷�ִ��");
		}
	}
	
	@Test(priority = 9, enabled = false, invocationCount = 1)//���ɻ�����ʱ���������⣬�޷����ԣ���ɾ��
	public void checkBannerToData_F_3679(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>վ���š���>��֤վ������ʾ��Ϣ��Ϣ�����⡢���ݡ��ռ�ʱ�䣩");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>վ���š���>��֤վ������ʾ��Ϣ��Ϣ�����⡢���ݡ��ռ�ʱ�䣩");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_Interest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (AssertionError e1) {
				System.out.println("�˻���" + tel_Interest + " ��¼ʧ�ܣ�");
				Reporter.log("�˻���" + tel_Interest + " ��¼ʧ�ܣ�");
			}
			
			base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
			
			HashMap<String, String> hashMap = new HashMap<String, String>();
			hashMap = transactionRecordPage.getRecordTable(email_Interest);
			
			//����汦�б�ҳ��У��Banner�С��������桱�����ۼ����桱�������ձ�����
			eCunBaoPage.checkBannerToData(hashMap);
		}
		else{
			Reporter.log("test�����������޷�ִ��");
			System.out.println("test�����������޷�ִ��");
		}
	}
	
}
