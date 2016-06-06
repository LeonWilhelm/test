package com.eloancn.suites.debit;

//import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyDebitPlan;
import com.eloancn.shared.pages.MyLoanPage;
import com.eloancn.shared.pages.SecurityAuthPage;

public class Debit2 {
//	static Logger logger = Logger.getLogger(Debit2.class); 
	
	Base base = new Base();
	MyAccountPage myAccountPage = new MyAccountPage();
	LoginPage loginPage = new LoginPage();
	MyLoanPage myLoanPage = new MyLoanPage();
	MyDebitPlan myDebitPlan = new MyDebitPlan();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	
	public String tel = Data.tel;//13611111116
	String password = Data.password;
	String zzmm = Data.zzmm;
	String idCard = new Data().idConcatenation();
	String bankAccount = Data.bankAccount;
	String realName = "";
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_tel;
			password = Data.test_password;
			zzmm = Data.test_zzmm;
			realName = Data.test_realName;
		}else {
			tel = Data.tel_run_debit2;
			realName = Data.realName_run_debit2;
			idCard = Data.idCard_run_debit2;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * ����Ԫ
	 * ��Ƶ��֤
	 */
	@Test (priority = 1)
	public void videoIdentification_AT_468(){
		Reporter.log("�������̣���ȫ����-��Ƶ��֤");
		//base.openBrowser("http://www.eloancn.com/page/userMgr/myHome.jsp");
		//loginPage.loginWithNoFrame("13834569527", "13834569527");//"13111111138"  "13834569527", "13834569527"
		
		//indexPage.clickMenu("�ҵ��˻�");
		loginPage.loginWithNoFrame(tel, password);
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.clickVideoIdentificationBtn();
		securityAuthPage.videoIdentification();
		securityAuthPage.isVideoIdentificationOK();
	}
	
	/**
	 * ����Ԫ
	 * ������
	 */
	@Test (priority = 2)
	public void loanApplication1_AT_469(){
		Reporter.log("�������̣��ҵĽ���--��������ֱ�");
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.loanApplication(true, false, "���ֱ�", "500", "6����","", "16", "5", "����", "bj", "��������", tel+"�Զ������ԣ�����վ����--��ͨ��", "�Զ������ԣ����������뵣����ͬ�ǵ�����ͬ�Ⲣ���ɹ��󣬸���ͬ�ǵ�����ʵ�ʽ����2%�ķ��á�ͬʱ��ʹ���ܹ��������Ľ赽����Ľ�");
		loanApplicationPage.isLoanApplicationOK();
	}
	
	/**
	 * ����Ԫ
	 * ������
	 */
	@Test (priority = 3)
	public void loanApplication2_AT_470(){
		Reporter.log("�������̣��ҵĽ���--��������ֱ�");
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.loanApplication(true, false, "���ֱ�", "500", "6����","", "18", "7", "����", "fx", "������ת", tel+"�Զ������ԣ�����վ����--���ֱ�", "�Զ������ԣ����������뵣����ͬ�ǵ�����ͬ�Ⲣ���ɹ��󣬸���ͬ�ǵ�����ʵ�ʽ����2%�ķ��á�ͬʱ��ʹ���ܹ��������Ľ赽����Ľ�");
		loanApplicationPage.isLoanApplicationOK();
	}
	
	/**
	 * ����Ԫ
	 * ���Ǽƻ� �ҵĽ���ƻ� �������
	 */
	@Test (priority = 4)
	public void shenQingDaikuan_AT_471(){
		Reporter.log("�������̣��ҵĽ���--�ҵĽ��--�ѷ����Ľ��궼��Ͷ�����ܲ�����ʱ����ͨ�������ȷ�Ͻ���ͨ�ֻ���ݻ��¼��ȷ����Ƶ�������ͬ���");
		myAccountPage.turnToMyAccount("�ҵĽ���ƻ�");
		myDebitPlan.clickShenQingDaiKuan();
		myDebitPlan.shenQingDaiKuan("1000","��ҵ","6����","��������","�Զ������ԣ����Ǽƻ�--��ҵ��","�Զ������ԣ����Ǽƻ�--��ҵ�����Ǽƻ�--��ҵ�����Ǽƻ�--��ҵ�����Ǽƻ�--��ҵ�����Ǽƻ�--��ҵ�����Ǽƻ�--��ҵ�����Ǽƻ�--��ҵ�����Ǽƻ�--��ҵ��");
		myDebitPlan.isShenQingDaiKuanOK();
	}
	
	/**
	 * ����Ԫ
	 * �ҵĽ���--�ҵĽ��--�ѷ����Ľ��--ȷ�Ͻ��
	 */
	@Test (priority = 5)
	public void sureDebit_AT_472(){
		Reporter.log("�������̣����Ǽƻ�--�ҵĽ���ƻ�,�������,����");
		myAccountPage.turnToMyAccount("�ҵĽ��");
		//�ѷ����Ľ��
		myLoanPage.clickPublishedTab();
		base.sleep(3000);
		if (myLoanPage.isDisplayed("ȷ�Ͻ��")) {
			//�����ȷ�Ͻ����
			myLoanPage.sureDebit();
			if (myLoanPage.isDisplayed("��ͨ�ֻ���ݻ���ҵ��")) {
				//�������ͨ�ֻ���ݻ���ҵ��
				myLoanPage.clickBtn_SureDebit("��ͨ�ֻ���ݻ���ҵ��");
				//��ͨ�ֻ���ݻ���ҵ��
				myLoanPage.openMobilePay(idCard,bankAccount,tel,"������","������","������֧��");//idcard
				//"110106193710137259","622848181111111","13111111154","������","������","������֧��"
				//�Ƿ��ֻ���ͨ��ݻ���ɹ�
				myLoanPage.isOpenMobilePayOK(realName);
//				logger.info("<��ͨ�ֻ���ݻ���ҵ��>�ɹ�");
				Reporter.log("<��ͨ�ֻ���ݻ���ҵ��>�ɹ�");
			}
			if(myLoanPage.isDisplayed("¼�Ʊ�ȷ����Ƶ")){
				//���  ¼�Ʊ�ȷ����Ƶ
				myLoanPage.clickBtn_SureDebit("¼�Ʊ�ȷ����Ƶ");
				securityAuthPage.videoIdentification();
				myLoanPage.closeVedio();
				myLoanPage.isVedioOK();
//				logger.info("<¼�Ʊ�ȷ����Ƶ>�ɹ�");
				Reporter.log("<¼�Ʊ�ȷ����Ƶ>�ɹ�");
			}
			myLoanPage.agree();
//			logger.info("<ͬ��>�ɹ�");
			Reporter.log("<ͬ��>�ɹ�");
		}else {
//			logger.info("û��<ȷ�Ͻ��>");
			Reporter.log("û��<ȷ�Ͻ��>");
		}
	}	
}
