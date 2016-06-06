package com.eloancn.suites.myAccount;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.AutoBidPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.SBInvestPage;

public class AutoBid_P3 {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	AutoBidPage autoBidPage = new AutoBidPage();
	IndexPage indexPage = new IndexPage();
	SBInvestPage sbInvestPage = new SBInvestPage();
	
	String tel = "13111111201";
	String zfmm = "111111";
	String password = Data.password;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_tel;
			zfmm = Data.test_zzmm;
			password = Data.test_password;
		}
	}

	@AfterClass
	public void teardownAfter(){
		//�ر��Զ�Ͷ��
		myAccountPage.turnToMyAccount("�Զ�Ͷ��");
 		if(autoBidPage.ifAutoBidOpen()){
 			autoBidPage.clickCloseAutoBidBtn();
 		}
		base.tearDown();
	}
	
	@Test(priority = 1)
	public void checkMoney_web_3941(){
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬������ҵĴ�����-��Ͷ���б��ġ��Զ�Ͷ�ꡱ,��ȷ��ʾĬ�ϵġ��Զ�Ͷ�����á���<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬���Ĭ��ֵ�Ƿ��������<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		//���Ĭ��ֵ�Ƿ��������
		myAccountPage.turnToMyAccount("�ҵ��˻�");
		double balance = myAccountPage.getBalance();
		myAccountPage.turnToMyAccount("�Զ�Ͷ��");
		autoBidPage.clickAutoBidBtn();
		autoBidPage.verifyAutoBidSet(balance);
		//�Զ�Ͷ������
		String reserveMoney = autoBidPage.checkFixedAmountBid(zfmm);
		//������ҵĴ�����-��Ͷ���б��ġ��Զ�Ͷ�ꡱ
		indexPage.clickMenu("Ͷ���б�");
		sbInvestPage.clickAutoBidBtn();
		autoBidPage.verifyFixedAmountBid(reserveMoney);
		//�ر��Զ�Ͷ��
		autoBidPage.clickCloseAutoBidBtn();
	}
	
	@Test(priority = 2)
	public void checkMoney_web_3942(){
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�˻��������,����Ĭ��ֱ�ӵ��ȷ����ť,��ʾ���������˻��������<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�˻��������,���˻���������ı��������븺��,�Զ�ת��������<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�˻��������,���˻���������ı���������С�����ȷ����ť,�Զ�ת��������<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�˻��������,���˻���������ı�����������ĸ�����֡�������ŵ��ȷ����ť,�Զ�ȡ������ķ������ַ�<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�˻��������,���˻���������ı�����������˻������������������ȷ����ť,��ʾ�����˻�������Ӧ�ô��������˻����ý�<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�˻��������,���˻���������ı�������С���˻������������������ȷ����ť,��ʾ֧�����벻��Ϊ�գ�<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		//�˻��������,����Ĭ��ֱ�ӵ��ȷ����ť,��ʾ���������˻��������
		myAccountPage.turnToMyAccount("�Զ�Ͷ��");
		autoBidPage.clickAutoBidBtn();
		autoBidPage.clickOKBtn("����д�������˻�������");
		//�˻��������,���˻���������ı��������븺��,�Զ�ת��������
		autoBidPage.inputReserveMoney("-");
		autoBidPage.checkReserveMoney("");
		//�˻��������,���˻���������ı���������С�����ȷ����ť,�Զ�ת��������
		autoBidPage.inputReserveMoney(".");
		autoBidPage.checkReserveMoney("");
		//�˻��������,���˻���������ı�����������ĸ�����֡�������ŵ��ȷ����ť,�Զ�ȡ������ķ������ַ�
		autoBidPage.inputReserveMoney("s");
		autoBidPage.checkReserveMoney("");
		autoBidPage.inputReserveMoney("��");
		autoBidPage.checkReserveMoney("");
		autoBidPage.inputReserveMoney("@");
		autoBidPage.checkReserveMoney("");
		//�˻��������,���˻���������ı�����������˻������������������ȷ����ť,��ʾ�����˻�������Ӧ�ô��������˻����ý�
		autoBidPage.inputReserveMoney("big");
		autoBidPage.clickOKBtn("�����˻�������Ӧ�ô��������˻����ý�");
		//�˻��������,���˻���������ı�������С���˻������������������ȷ����ť,��ʾ֧�����벻��Ϊ�գ�
		autoBidPage.InputReserveMoney();
		autoBidPage.clickOKBtn("֧�����벻��Ϊ�գ�");
	}
	
	@Test(priority = 3)
	public void checkPassword_web_3943(){
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-֧������,��������֧�����룬�����ȷ������ť,��ʾ��֧���������<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-֧������,����С��6���ַ���֧�����룬�����ȷ������ť,��ʾ��֧�����벻��С�������ַ�<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-֧������,�������20���ַ�֧������,�޷����볬��20���ַ�<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-֧������,������ȷ��֧����������ȷ������ť,��ʾ�������Զ�Ͷ��ɹ�<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-֧������,���Զ�Ͷ�꿪���ɹ���ʾ���е����ȷ������ť,�Զ�Ͷ�����ý����Ϊ���ɱ༭״̬����ʾ�����Ϳ���״̬<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		//֧������,��������֧�����룬�����ȷ������ť,��ʾ��֧���������
		myAccountPage.turnToMyAccount("�Զ�Ͷ��");
		autoBidPage.clickAutoBidBtn();
		autoBidPage.InputReserveMoney();
		autoBidPage.InputPayPwd("123456");
		autoBidPage.clickOKBtn("֧���������");
		//֧������,����С��6���ַ���֧�����룬�����ȷ������ť,��ʾ��֧�����벻��С�������ַ�
		autoBidPage.InputPayPwd("11111");
		autoBidPage.clickOKBtn("֧�����벻��С����λ�ַ���");
		autoBidPage.checkPwdLength();
		//֧������,������ȷ��֧����������ȷ������ť,��ʾ�������Զ�Ͷ��ɹ�
		autoBidPage.InputPayPwd(zfmm);
		autoBidPage.clickOKBtn();
		autoBidPage.clickCloseAutoBidBtn();
	}
	
	@Test(priority = 4)
	public void checkCreditRatingRange_web_3944(){
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���õȼ���Χ�����б�,������õȼ���Χ������,���Ե��������б�<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���õȼ���Χ�����б�,��С��Χѡ�����ֵ��������Χѡ������ֵ֮�������ֵ�б���,������ѡ��Ĭ����ʾ���ֵ<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���õȼ���Χ�����б�,��Сֵ�����ֵ��ѡ�����ֵ,����ѡ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���õȼ���Χ�����б�,���Χѡ����Сֵ����С��Χѡ�����Сֵ֮���ֵ,������ѡ�񣬵���޷�Ӧ<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���õȼ���Χ�����б�,��ѡ����Сֵ������ѡ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���õȼ���Χ�����б�,ѡ��СֵС�����ֵ������ѡ��<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		myAccountPage.turnToMyAccount("�Զ�Ͷ��");
		autoBidPage.clickAutoBidBtn();
		//��С��Χѡ�����ֵ��������Χѡ������ֵ֮�������ֵ�б���,������ѡ��Ĭ����ʾ���ֵ
		autoBidPage.selectLowLevel("AAA");
		autoBidPage.selectHighLevel("A");
		autoBidPage.checkCreditRatingRange("high","AAA");
		autoBidPage.clickCancelBtn();
		//��Сֵ�����ֵ��ѡ�����ֵ,����ѡ��
		autoBidPage.clickAutoBidBtn();
		autoBidPage.selectLowLevel("AAA");
		autoBidPage.selectHighLevel("AAA");
		autoBidPage.checkCreditRatingRange("high","AAA");
		autoBidPage.clickCancelBtn();
		//���Χѡ����Сֵ����С��Χѡ�����Сֵ֮���ֵ,������ѡ�񣬵���޷�Ӧ
		autoBidPage.clickAutoBidBtn();
		autoBidPage.selectLowLevel("HR");
		autoBidPage.selectHighLevel("HR");
		autoBidPage.checkCreditRatingRange("low","HR");
		autoBidPage.selectLowLevel("D");
		autoBidPage.checkCreditRatingRange("low","HR");
		autoBidPage.clickCancelBtn();
		//��ѡ����Сֵ������ѡ��
		autoBidPage.clickAutoBidBtn();
		autoBidPage.selectHighLevel("HR");
		autoBidPage.selectLowLevel("HR");
		autoBidPage.checkCreditRatingRange("low","HR");
		autoBidPage.clickCancelBtn();
		//ѡ��СֵС�����ֵ������ѡ��
		autoBidPage.clickAutoBidBtn();
		autoBidPage.selectLowLevel("B");
		autoBidPage.selectHighLevel("A");
		autoBidPage.checkCreditRatingRange("high","A");
		autoBidPage.clickCancelBtn();
	}
	                                                                   
	@Test(priority = 5)
	public void checkBidMoney_web_3945(){
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-ѡ��̶�Ͷ�꣬Ͷ��������Ϊ�յ����ȷ������ť����ʾ����д��ÿ��Ͷ���<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-ѡ��̶�Ͷ�꣬Ͷ����������С��50�����ȷ������ť����ʾÿ��Ͷ���������50�ı���<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-ѡ��̶�Ͷ�꣬Ͷ���� ������ΪС�������ȷ������ť���Զ�ȡ��С����<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-ѡ��̶�Ͷ�꣬Ͷ����������Ϊ���������ȷ������ť���Զ�ȡ������<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-ѡ��̶�Ͷ�꣬Ͷ����������ĸ�����ֵ����ȷ������ť���Զ�ȡ����ĸ������<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		//ѡ��̶�Ͷ�꣬Ͷ��������Ϊ�յ����ȷ������ť����ʾ����д��ÿ��Ͷ���
		myAccountPage.turnToMyAccount("�Զ�Ͷ��");
		autoBidPage.clickAutoBidBtn();
		autoBidPage.chooseFixedAmountBid();
		autoBidPage.clickOKBtn("����д��ÿ��Ͷ���");
		//ѡ��̶�Ͷ�꣬Ͷ����������С��50�����ȷ������ť����ʾÿ��Ͷ���������50�ı���
		autoBidPage.InputBidMoney("49");
		autoBidPage.clickOKBtn("ÿ��Ͷ���������50�ı���");
		int money = autoBidPage.getBalance()/50*50+50;
		autoBidPage.InputBidMoney(money+"");
		autoBidPage.clickOKBtn("����ÿ��Ͷ���Ӧ�ô��������˻����ý�");
		//ѡ��̶�Ͷ�꣬Ͷ���� ������ΪС�������ȷ������ť���Զ�ȡ��С����
		autoBidPage.InputBidMoney("1.1");
		autoBidPage.checkBidMoney("11");
		//ѡ��̶�Ͷ�꣬Ͷ����������Ϊ���������ȷ������ť���Զ�ȡ������
		autoBidPage.InputBidMoney("-");
		autoBidPage.checkBidMoney("");
		//ѡ��̶�Ͷ�꣬Ͷ����������ĸ�����ֵ����ȷ������ť���Զ�ȡ����ĸ������
		autoBidPage.InputBidMoney("s");
		autoBidPage.checkBidMoney("");
		autoBidPage.InputBidMoney("��");
		autoBidPage.checkBidMoney("");
	}
	
	@Test(priority = 6)
	public void checkLiLv_web_3946(){
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�����ʷ�Χ����Сֵ����Ϊ�գ���������д��ȷ�����ȷ������ť����ʾ����������Сֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�����ʷ�Χ�����������ֵ����Ϊ�գ���������д��ȷ�����ȷ������ť����ʾ�����������ֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�����ʷ�Χ����������Сֵ����С��10����22������������������д��ȷ�����ȷ������ť����ʾ��������Сֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�����ʷ�Χ�����������ֵ����С��10����22������������������д��ȷ�����ȷ������ť����ʾ�����������ֵ���ԣ�10%��22%Ϊ��Чֵ<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�����ʷ�Χ���������ı���������λ�����޷�������λ����ֻ��������λ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-�����ʷ�Χ��������ȷ�������ʷ�Χ����������д��ȷ�����ȷ������ť�������Զ�Ͷ��ɹ���������д��ȷ��<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		myAccountPage.turnToMyAccount("�Զ�Ͷ��");
		autoBidPage.clickAutoBidBtn();
		//�����ʷ�Χ����Сֵ����Ϊ�գ���������д��ȷ�����ȷ������ť����ʾ����������Сֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��
		autoBidPage.InputLowInterest("");
		autoBidPage.clickOKBtn("��������Сֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��");
		//�����ʷ�Χ�����������ֵ����Ϊ�գ���������д��ȷ�����ȷ������ť����ʾ�����������ֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��
		autoBidPage.InputLowInterest("10");
		autoBidPage.InputHighInterest("");
		autoBidPage.clickOKBtn("���������ֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��");
		//��������Сֵ����С��10����22������������������д��ȷ�����ȷ������ť����ʾ��������Сֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��
		autoBidPage.InputLowInterest("9");
		autoBidPage.clickOKBtn("��������Сֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��");
		autoBidPage.InputLowInterest("23");
		autoBidPage.clickOKBtn("��������Сֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��");
		//�����ʷ�Χ�����������ֵ����С��10����22������������������д��ȷ�����ȷ������ť����ʾ�����������ֵ���ԣ�10%��22%Ϊ��Чֵ
		autoBidPage.InputLowInterest("10");
		autoBidPage.InputHighInterest("9");
		autoBidPage.clickOKBtn("���������ֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��");
		autoBidPage.InputHighInterest("23");
		autoBidPage.clickOKBtn("���������ֵ���ԣ�10%-22%Ϊ��Ч���ʷ�Χ��");
		//�����ʷ�Χ���������ı���������λ�����޷�������λ����ֻ��������λ��
		autoBidPage.InputLowInterest("101");
		autoBidPage.InputHighInterest("221");
		autoBidPage.checkInterest("low","10");
		autoBidPage.checkInterest("high","22");
		//�����ʷ�Χ��������ȷ�������ʷ�Χ����������д��ȷ�����ȷ������ť�������Զ�Ͷ��ɹ���������д��ȷ��
		autoBidPage.checkBalanceBid(zfmm);
		autoBidPage.clickCloseAutoBidBtn();
	}
	
	@Test(priority = 7)
	public void checkQiXian_web_3947(){
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-������ޣ�������������Сֵ�����ֵ�ı��򣬵��������б���<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-������ޣ���Сֵѡ��24����ѡ�����ֵ�����ֵֻ��ѡ��24���£���������޷�Ӧ<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-������ޣ����ֵѡ��2����ѡ����Сֵ,��Сֵֻ��ѡ��2���£���������޷�Ӧ<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-������ޣ���Сֵѡ��2����ѡ�����ֵ,���ֵ��������ѡ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-������ޣ����ֵѡ��24����ѡ����Сֵ,��Сֵ��������ѡ��<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		//������ޣ���Сֵѡ��24����ѡ�����ֵ�����ֵֻ��ѡ��24���£���������޷�Ӧ
		myAccountPage.turnToMyAccount("�Զ�Ͷ��");
		autoBidPage.clickAutoBidBtn();
		autoBidPage.selectShortLoanTime("24");
		autoBidPage.selectLongLoanTime("24");
		autoBidPage.checkLoanTime("long","24");
		autoBidPage.selectLongLoanTime("21");
		autoBidPage.checkLoanTime("long","24");
		//������ޣ����ֵѡ��2����ѡ����Сֵ,��Сֵֻ��ѡ��2���£���������޷�Ӧ
		autoBidPage.selectShortLoanTime("2");
		autoBidPage.selectLongLoanTime("2");
		autoBidPage.selectShortLoanTime("2");
		autoBidPage.checkLoanTime("short","2");
		autoBidPage.selectLongLoanTime("3");
		autoBidPage.checkLoanTime("short","2");
		//������ޣ���Сֵѡ��2����ѡ�����ֵ,���ֵ��������ѡ��
		autoBidPage.selectShortLoanTime("2");
		autoBidPage.selectLongLoanTime("2");
		autoBidPage.checkLoanTime("long","2");
		autoBidPage.selectLongLoanTime("24");
		autoBidPage.checkLoanTime("long","24");
		//������ޣ����ֵѡ��24����ѡ����Сֵ,��Сֵ��������ѡ��
		autoBidPage.selectLongLoanTime("24");
		autoBidPage.selectShortLoanTime("2");
		autoBidPage.checkLoanTime("short","2");
		autoBidPage.selectShortLoanTime("24");
		autoBidPage.checkLoanTime("short","24");
	}
	
	@Test(priority = 8)
	public void checkRepaymentMethod_web_3948(){
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���ʽ����ѡ�ȶ��ǰ��ѡ�򣬿ɹ�ѡ<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���ʽ����ѡ�ȶϢǰ��ѡ�򣬿ɹ�ѡ<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���ʽ����ѡ������Ϣǰ��ѡ�򣬿ɹ�ѡ<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���ʽ��ͬʱ��ѡ���ֻ��ʽ��ѡ�򣬿ɹ�ѡ<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���ʽ����ѡ�������ֻ��ʽ��ѡ�򣬿ɹ�ѡ<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		myAccountPage.turnToMyAccount("�Զ�Ͷ��");
		autoBidPage.clickAutoBidBtn();
		//���ʽ����ѡ�ȶ��ǰ��ѡ�򣬿ɹ�ѡ
		autoBidPage.checkMatchPrincipal();
		autoBidPage.checkRepaymentMethod("�ȶ��");
		//���ʽ����ѡ�ȶϢǰ��ѡ�򣬿ɹ�ѡ
		autoBidPage.checkMatchPrincipal();
		autoBidPage.checkMatchPI();
		autoBidPage.checkRepaymentMethod("�ȶϢ");
		//���ʽ����ѡ������Ϣǰ��ѡ�򣬿ɹ�ѡ
		autoBidPage.checkMatchPI();
		autoBidPage.checkRepayPI();
		autoBidPage.checkRepaymentMethod("������Ϣ");
		//���ʽ��ͬʱ��ѡ���ֻ��ʽ��ѡ�򣬿ɹ�ѡ
		autoBidPage.checkMatchPrincipal();
		autoBidPage.checkMatchPI();
		autoBidPage.checkRepaymentMethod("�ȶ��");
		autoBidPage.checkRepaymentMethod("�ȶϢ");
		autoBidPage.checkRepaymentMethod("������Ϣ");
		//���ʽ����ѡ�������ֻ��ʽ��ѡ�򣬿ɹ�ѡ
		autoBidPage.checkMatchPrincipal();
		autoBidPage.checkRepaymentMethod("�ȶϢ");
		autoBidPage.checkRepaymentMethod("������Ϣ");
		autoBidPage.checkMatchPrincipal();
		autoBidPage.checkMatchPI();
		autoBidPage.checkRepaymentMethod("�ȶ��");
		autoBidPage.checkRepaymentMethod("������Ϣ");
		autoBidPage.checkRepayPI();
		autoBidPage.checkMatchPI();
		autoBidPage.checkRepaymentMethod("�ȶ��");
		autoBidPage.checkRepaymentMethod("�ȶϢ");
	}
	
	@Test(priority = 9)
	public void checkParticipationMode_web_3949(){
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���뷽ʽ��������Ͷ��ǰ��ѡť����ѡ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���뷽ʽ������̶�Ͷ��ǰ��ѡť����ѡ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ��-���뷽ʽ��ͬʱѡ������Ͷ�귽ʽ��ѡť������ͬʱѡ��ֻ��ѡ��һ��<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		myAccountPage.turnToMyAccount("�Զ�Ͷ��");
		autoBidPage.clickAutoBidBtn();
		//���뷽ʽ��������Ͷ��ǰ��ѡť����ѡ��  ���뷽ʽ��ͬʱѡ������Ͷ�귽ʽ��ѡť������ͬʱѡ��ֻ��ѡ��һ��
		autoBidPage.chooseBalanceBid();
		autoBidPage.checkParticipationMode("���");
		//���뷽ʽ������̶�Ͷ��ǰ��ѡť����ѡ��  ���뷽ʽ��ͬʱѡ������Ͷ�귽ʽ��ѡť������ͬʱѡ��ֻ��ѡ��һ��
		autoBidPage.chooseFixedAmountBid();
		autoBidPage.checkParticipationMode("�̶�");
	}
	
	@Test(priority = 10)
	public void checkAutoBid_web_3950(){
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬1.��������Զ�Ͷ�갴ť����ʾ�Զ�Ͷ�����ý���<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬2.��д��ȷ��������Ϣ�����ȷ������ť�����������Զ�Ͷ��ɹ���ʾ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬3-1.�����ʾ���С�ȷ������ť�����ý����Ϊ���ɱ༭����ʾ�����Ϳ���״̬<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬4-1.���Զ�Ͷ�����ý��������޸��Զ�Ͷ�ꡱ��ť�����ý����Ϊ�ɱ༭״̬<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬4-2.ѡ����뷽ʽΪ���̶�Ͷ�ꡱ��ʽ��Ͷ�����ı���Ĭ����ʾ100<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬4-3.����֧����������ȷ������ť�������޸ĳɹ���ʾ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬4-4.����ʾ���е����ȷ������ť�����ý����Ϊ���ɱ༭״̬,�����޸Ĺ��Ĺ�����,�������ü�¼�и����޸Ĺ�����������<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬5-1.���Զ�Ͷ�������ý��������ر��Զ�Ͷ�ꡱ��ť������ȷ�Ϲر���ʾ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬5-2.�����ʾ���еġ�ȡ������ť����ʾ��رչرղ����κ��޸�<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬5-3.�����ʾ���еġ�ȷ������ť�������ɹ���ʾ��<br/>");
		Reporter.log("�Զ�Ͷ��P3:�ҵ��˻�-�Զ�Ͷ�꣬5-4.�ڳɹ���ʾ���е����ȷ������ť���Զ�Ͷ������ҳ����δ����ʱ�ĳ�ʼҳ��,�������ü�¼�б��п�����¼״̬��Ϊ�رգ��ڲ���ʱ�������ӹر�ʱ�䣬�����������Ϊ��<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		myAccountPage.turnToMyAccount("�Զ�Ͷ��");
		autoBidPage.clickAutoBidBtn();
		//1.��������Զ�Ͷ�갴ť����ʾ�Զ�Ͷ�����ý���
		autoBidPage.checkAutoBidPage();
		//2.��д��ȷ��������Ϣ�����ȷ������ť�����������Զ�Ͷ��ɹ���ʾ��
		//3-1.�����ʾ���С�ȷ������ť�����ý����Ϊ���ɱ༭����ʾ�����Ϳ���״̬
	 	if(autoBidPage.ifshowAutoBidSetLnk()){
	 		autoBidPage.clickAutoBidBtn();
	 		autoBidPage.checkBalanceBid(zfmm);
	 		autoBidPage.checkEdit(false);
	 	}else{
	 		System.out.println("�̶�Ͷ���Ȩ�޲�����");
	 		Reporter.log("<br/>�̶�Ͷ���Ȩ�޲�����");
	 	}
	 	//4-1.���Զ�Ͷ�����ý��������޸��Զ�Ͷ�ꡱ��ť�����ý����Ϊ�ɱ༭״̬
	 	autoBidPage.clickUpdate();
	 	autoBidPage.checkEdit(true);
	 	//4-2.ѡ����뷽ʽΪ���̶�Ͷ�ꡱ��ʽ��Ͷ�����ı���Ĭ����ʾ100
	 	autoBidPage.chooseFixedAmountBid();
	 	autoBidPage.checkBidMoney("100");
	 	//4-3.����֧����������ȷ������ť�������޸ĳɹ���ʾ��
	 	autoBidPage.InputPayPwd(zfmm);
	 	autoBidPage.selectLowLevel("D");
	 	autoBidPage.selectHighLevel("A");
	 	autoBidPage.InputLowInterest("11");
	 	autoBidPage.InputHighInterest("13");
	 	autoBidPage.checkMatchPrincipal();
	 	autoBidPage.selectShortLoanTime("4");
	 	autoBidPage.selectLongLoanTime("11");
	 	String reserveMoney = autoBidPage.getReserveMoney();
	 	System.out.println(reserveMoney);
	 	//4-4.����ʾ���е����ȷ������ť�����ý����Ϊ���ɱ༭״̬,�����޸Ĺ��Ĺ�����,�������ü�¼�и����޸Ĺ�����������
	 	if (!autoBidPage.clickOKBtn()) {
	 		reserveMoney = "900000";
		}
	 	autoBidPage.checkEdit(false);
	 	String values[] = {"D-A","11-13%","�ȶϢ,������Ϣ","4����-11����","�̶�Ͷ��","100Ԫ",reserveMoney};
	 	autoBidPage.verifyFixedAmountBid(values);
	 	//5-1.���Զ�Ͷ�������ý��������ر��Զ�Ͷ�ꡱ��ť������ȷ�Ϲر���ʾ��
	 	Alert close = autoBidPage.closeConfirm();
	 	//5-2.�����ʾ���еġ�ȡ������ť����ʾ��رչرղ����κ��޸�
	 	close.dismiss();
	 	//5-3.�����ʾ���еġ�ȷ������ť�������ɹ���ʾ��
	 	//5-4.�ڳɹ���ʾ���е����ȷ������ť���Զ�Ͷ������ҳ����δ����ʱ�ĳ�ʼҳ��,�������ü�¼�б��п�����¼״̬��Ϊ�رգ��ڲ���ʱ�������ӹر�ʱ�䣬�����������Ϊ��
	 	autoBidPage.clickCloseAutoBidBtn();
	 	base.assertTrueByBoolean(autoBidPage.ifshowAutoBidSetLnk());
	}
}
