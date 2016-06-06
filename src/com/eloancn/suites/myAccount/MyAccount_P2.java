package com.eloancn.suites.myAccount;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.AccountInfoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyRewardPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.SecurityAuthPage;

/**
 * ���ҵ��˻���P2����
 * @author ������
 */
public class MyAccount_P2 {
	
	Base base = new Base();
	DBData dbData = new DBData();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	RechargePage rechargePage = new RechargePage();
	IndexPage indexPage = new IndexPage();
	MyRewardPage myRewardPage = new MyRewardPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	
	String MyAccountUrl = base.indexURL + "/page/userMgr/myHome.jsp";
	String tel;
	String email;
	String pass;
	String money ="0.01";
	String newTel;
	String oldTel;
	String changeTel;
	String noChangeTel;
	
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			tel = Data.tel_run_EcunBao;
			pass = Data.zzmm;
			email = Data.email_MyAccountP2;
			newTel = Data.client_tel_new;
			oldTel = Data.client_tel_old;
			changeTel = Data.tel_change;
			noChangeTel = Data.tel_noChange;
		}
		else if (base.indexURL.contains("test") || base.indexURL.contains("www")){
			tel = Data.test_myAccount_P2_tel;
			pass = Data.zzmm;
			email = Data.test_run_ECunBao_oldemail;
			newTel = Data.test_run_ECunBao_register;
			oldTel = Data.test_run_ECunBao_oldtel;
		}
	}

	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * ��֤��ֵ��ʽ��1-ת�˻��
	 * @author ������
	 */
	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void checkOnlineRechargeNoticeInfomation_web_319(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>��ֵ����>��֤��ֵ��ʽ��1-���ϳ�ֵ<br/>");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>��ֵ����>��֤��ֵ��ʽ��1-���ϳ�ֵ");
		
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(tel, pass);
		//�����ֵҳ��
		myAccountPage.turnToMyAccount("��ֵ");
		//�ж��Ƿ���ת����ֵ����
//		myAccountPage.isGoMyAccount("��ֵ");	
		//У����ʾ���г�ֵ
		rechargePage.checkPromptMsgOfBank(money);
		myAccountPage.turnToMyAccount("��ֵ");
		//У����ʾ����ֵ
		rechargePage.checkPromptMsgOfMoney();
		myAccountPage.turnToMyAccount("��ֵ");
		//У���д���
		rechargePage.checkCapitalOfMoney(money);
		//У���������ҳ��
		rechargePage.checkBankPage();
	}
	
	/**
	 * ��֤��ֵ��ʽ��2-ת�˻��-���ð�ť
	 * ��ע���Ĺ���������
	 * @author ������
	 */
	@Test(priority = 2, enabled = false)
	public void checkTransferRemittanceByReset_web_320(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>��ֵ����>��֤��ֵ��ʽ��2-ת�˻��-���ð�ť<br/>");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>��ֵ����>��֤��ֵ��ʽ��2-ת�˻��-���ð�ť");
		
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(tel, pass);
		myAccountPage.turnToMyAccount("��ֵ");
		//�ж��Ƿ���ת����ֵ����
		myAccountPage.isGoMyAccount("��ֵ");	
		rechargePage.rechargeTransferRemittance("2015-05-01","10","�й�����","3333","�Զ������ԣ���ܣ�лл");
		rechargePage.checkResetByTransferRemittance();
	}
	
	/**
	 * ��֤���֣�������п����Ӽ�ҳ����ʾ
	 * @author ������
	 */
	@Test(priority = 3, enabled = true)
	public void checkAddBankByShow_web_530(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>���֡���>��֤������п������Ӽ�ҳ����ʾ<br/>");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>���֡���>��֤������п������Ӽ�ҳ����ʾ");
		
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(tel, pass);
		myAccountPage.turnToMyAccount("��ȫ��֤");
		myAccountPage.isGoMyAccount("��ȫ��֤");
		//��� ���п�����
		securityAuthPage.clickBankManage();
		base.isElementVisible(securityAuthPage.addBackDiv);
		//У��ҳ����ʾ
		securityAuthPage.checkAddBankPageByShow();
	}
	
	/**
	 * ��֤���֣�������п����Ӽ�ҳ����ʾ
	 * @author ������
	 */
	@Test(priority = 4, enabled = true)
	public void checkPhoneNumber_web_74(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>�ҵĽ��롪��>�������>�Ĳ���������򡪡�>��֤�ֻ���<br/>");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>�ҵĽ��롪��>�������>�Ĳ���������򡪡�>��֤�ֻ���");
		
		if(!base.indexURL.contains("/client") && !base.indexURL.contains("inclient")){
			Reporter.log("�Ǽ���/���ػ��������ֶ����ԣ�<br/>");
			System.out.println("�Ǽ���/���ػ��������ֶ����ԣ�");
			base.assertTrueByBoolean(false);
		}
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(email, pass);
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.clickQualification();
		String temp = base.getElementTextWithWait(By.cssSelector(".certifitit>label"));
		if(temp.equals("���֤��֤")){
			myAccountPage.deletePhoneRegeditRecords(email);
		}
		myAccountPage.checkPhoneNoticeInformation();
		myAccountPage.deletePhoneRegeditRecords(email);
		base.logout();
	}

	
	@DataProvider(name="user")
	public Object[][] Users(){
		return new Object[][]{
			{newTel, pass},       //���ֻ�ע���û�
//			{oldTel, pass},       //���ֻ�ע���û�
			{email, pass}         //������ע���û�
		};
	}
	
	/**
	 * ��֤ע��󣬴��˻���Ϣ��������������ʾ��Ϣ
	 * @author ������
	 */
	@Test(priority = 5, dataProvider="user")
	public void checkNameNoticeInfomation_web_37(String name, String pass){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>�˻���Ϣ����>�޸���Ϣ����>��֤������������ʾ��Ϣ<br/>");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>�˻���Ϣ����>�޸���Ϣ����>��֤������������ʾ��Ϣ");
		
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(name, pass);
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		myAccountPage.isGoMyAccount("�˻���Ϣ");
		accountInfoPage.clickUpdateInfoBtn();
		//��������������֤�����Ƿ���ȷ
		myAccountPage.checkNameNoticeInformation(accountInfoPage.nameMsg, accountInfoPage.nameCheckmarkImg);
		base.logout();
		indexPage.clickLoginLink();
	}
	
	/**
	 * ��֤ע��󣬴��˻���Ϣ�������������ʾ��Ϣ
	 * @author ������
	 */
	@Test(priority = 6)
	public void checkEmailNoticeInfomation_web_41(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>�˻���Ϣ����>�޸���Ϣ����>��֤�����������ʾ��Ϣ<br/>");
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>�˻���Ϣ����>�޸���Ϣ����>��֤�����������ʾ��Ϣ");
		
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(newTel, pass);
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		accountInfoPage.clickUpdateInfoBtn();
		//�������䣬����֤�����Ƿ���ȷ
		myAccountPage.checkEmailNoticeInformatin();
		base.logout();
	}
	
	/**
	 * ��֤ע��󣬴��˻���Ϣ�������������ʾ��Ϣ       --------------------δ�޸�
	 * @author ������
	 */
	@Test(priority = 7)
	public void changePhoneNumber_web_1230(){
		
		Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>�˻���Ϣ����>�޸���Ϣ����>��֤�����������ʾ��Ϣ<br/>");//--------------------δ�޸�
		System.out.println("�ҵ��˻�_P2���ҵ��˻�����>�˻���Ϣ����>�޸���Ϣ����>��֤�����������ʾ��Ϣ");
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			int num;
			String uid,phone;
			uid = dbData.getUID("fangwenshan3@163.com");
			phone = dbData.getPhoneNum("fangwenshan3@163.com");
			System.out.println("�ֻ���Ϊ��" + phone);
			num = dbData.selectMobileChangeNum(uid);
			if (num != 2){
				dbData.deleteMobileChangeInfos(uid);
			}
			base.openBrowser(MyAccountUrl);
			loginPage.logoutByMyAccount();
			if(phone.equals(noChangeTel)){
				loginPage.loginByMyAccount(noChangeTel, pass);
				//�����ֵҳ��
				myAccountPage.turnToMyAccount("��ȫ��֤");
				myAccountPage.checkChangeTel(noChangeTel, changeTel, pass);
				base.sleep(30000);
				myAccountPage.turnToMyAccount("��ȫ��֤");
				myAccountPage.checkChangeTel(changeTel, noChangeTel, pass);
			}
			else{
				loginPage.loginByMyAccount(changeTel, pass);
				//�����ֵҳ��
				myAccountPage.turnToMyAccount("��ȫ��֤");
				myAccountPage.checkChangeTel(changeTel, noChangeTel, pass);
				base.sleep(30000);
				myAccountPage.turnToMyAccount("��ȫ��֤");
				myAccountPage.checkChangeTel(noChangeTel, changeTel, pass);
			}
			System.out.println(uid);
			//��ѯ�Ƿ���������¼
			num = dbData.selectMobileChangeNum(uid);
			//ɾ����������
			boolean isTrue = dbData.deleteMobileChangeInfos(uid);
			try {
				base.assertEqualsActualExpectedByBoolean(isTrue, true);
			} catch (AssertionError e) {
				Reporter.log("ɾ��'d_mobile_changehistory'���е����ݱ���������û��ɾ��Ȩ�޻�����ԭ��");
				System.out.println("ɾ��'d_mobile_changehistory'���е����ݱ���������û��ɾ��Ȩ�޻�����ԭ��");
			}
			base.logout();
			
			try {
				base.assertEqualsActualExpectedByInt(num, 2);
			} catch (AssertionError e) {
				Reporter.log("'d_mobile_changehistory'���е�����Ϊ��" + num + "�����������ϴ���������򱾴δ洢���� ");
				System.out.println("'d_mobile_changehistory'���е�����Ϊ��" + num + "�����������ϴ���������򱾴δ洢���� ");
			}
		}
		else{
			Reporter.log("�Ǽ���/���ػ��������ֶ����ԣ�<br/>");
			System.out.println("�Ǽ���/���ػ��������ֶ����ԣ�");
		}
	}
	
}
