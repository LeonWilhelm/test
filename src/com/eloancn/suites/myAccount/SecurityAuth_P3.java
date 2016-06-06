package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.until.DESUtils;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.AccountInfoPage;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.EStarPlanListPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyLoanPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.RegisterPage;
import com.eloancn.shared.pages.SBInvestPage;
import com.eloancn.shared.pages.SecurityAuthPage;
import com.eloancn.shared.pages.WithDrawPage;

/**
 * ����Ԫ
 * ��ȫ��֤
 */
public class SecurityAuth_P3 {
	LoginPage loginPage = new LoginPage();
	RechargePage rechargePage = new RechargePage();
	Base base = new Base();
	Data data = new Data();
	MyLoanPage myLoanPage = new MyLoanPage();
	RegisterPage registerPage = new RegisterPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	IndexPage indexPage = new IndexPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	EStarPlanListPage eStarPlanListPage = new EStarPlanListPage();
	SBInvestPage sBInvestPage = new SBInvestPage();
	InvestmentListPage investmentListPage = new InvestmentListPage();
	WithDrawPage withDrawPage = new WithDrawPage();
	LoanApplicationPage LoanApplicationPage = new LoanApplicationPage();
	DBData dbData = new DBData();
	DESUtils desUtils = new DESUtils();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
	}

	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(priority = 1)
	public void checkRegisterStatus_web_1275_1(){
		Reporter.log("��ȫ��֤P2����ע���ֻ��û�,��,ȥ�˻���Ϣ�鿴,����-��/���֤����-��/�ֻ�����-��ʾע���ֻ�����,��ʾǰ��λ,����λ,�м���4��*��ʾ/�ص�-��/����-��,���ֻ�������,����Ϊ�ɱ༭״̬ ��ȫ���ĵ���,�ֻ�Ϊ����֤״̬<br/>");
		//ע��
		String tel = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel1;
		}else {
			tel = data.phoneConcatenation(0);
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
//		String tel = "15095663196";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		//У��
		String list[] = {"","",tel.substring(0, 3)+"****"+tel.substring(7, 11),"---"};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.isWrite(true,true,false,true);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.isAuthentication("���֤��","δ��֤");
		securityAuthPage.isAuthentication("�ֻ���","����֤");
	}
	
	@Test(priority = 2)
	public void checkRegisterStatus_web_1275_2(){
		Reporter.log("��ȫ��֤P2����ע���û�,��ɳ�ֵҳ����ʾ�ĸ�����Ϣ��֤��,����˻���Ϣ,����/���֤����/��ʾ�Ѿ���֤,���ɱ༭״̬/�ֻ�����-��/�־�ס��-��ʾע����д/����-��ʾע����д���ɱ༭״̬    �ֻ�����Ϊ�ɱ༭״̬<br/>");
		base.logout();
		//ע��
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel2;
			realName = Data.test_run_SecurityAuth_P3_realName2;
			idCard = Data.test_run_SecurityAuth_P3_idCard2;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		String zzmm = Data.zzmm;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		String info[] = rechargePage.setInfo(realName,idCard,zzmm);
		realName = info[0];
		idCard = info[1];
//		String tel = "13757009155";
//		String realName = "�޺�ѩ";
//		String idCard = "110112194004261174";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		//У��
		tel = tel.substring(0, 3)+"****"+tel.substring(7, 11);
		idCard = idCard.substring(0,3)+"********"+idCard.substring(16,18).toLowerCase();
		String list[] = {realName,idCard,tel,"---"};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.isWrite(false,false,false,true);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.isAuthentication("���֤��","����֤");
		securityAuthPage.isAuthentication("�ֻ���","����֤");
		securityAuthPage.isAuthentication("����","δ��");
		securityAuthPage.isAuthentication("֧������","������");
	}
	
	@Test(priority = 3)
	public void checkRegisterStatus_web_1275_3(){
		Reporter.log("��ȫ��֤P2�����ֻ�ע���û���,ȥ��ȫ��֤��,����������֤,Ȼ��鿴�˻���Ϣ״̬,����-��/���֤����-��/�ֻ�����-����֤/�ص�-��/����-����֤,����༭��,������,�ֻ����붼Ϊ�ɱ༭״̬<br/>");
		base.logout();
		//ע��
		String tel = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel3;
		}else {
			tel = data.phoneConcatenation(0);
		}
		String password = Data.password;
		String email = data.emailConcatenation(3,2);
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.emailAuthentication(email);
		
//		String tel = "15895606240";
//		String email = "15895606240@qq.com";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");`
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		//У��
		tel = tel.substring(0, 3)+"****"+tel.substring(7, 11);
		email = email.substring(0,2)+"****"+email.substring(email.indexOf("@"));
		String list[] = {"","",tel,email};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.isWrite(true,true,false,false);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.isAuthentication("���֤��","δ��֤");
		securityAuthPage.isAuthentication("�ֻ���","����֤");
		securityAuthPage.isAuthentication("֧������","δ����");
		securityAuthPage.isAuthentication("����","�Ѱ�");
	}
	
	@Test(priority = 4)
	public void checkRegisterStatus_web_1275_4(){
		Reporter.log("��ȫ��֤P2�������ֻ��û�,ע���Ժ�,ȫ����֤��,�鿴�˻���Ϣ,�˻���Ϣ��,���֤,�ֻ�,����,��Ϊ����֤״̬�����޸�<br/>");
		base.logout();
		//ע��
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel4;
			realName = Data.test_run_SecurityAuth_P3_realName4;
			idCard = Data.test_run_SecurityAuth_P3_idCard4;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		String email = data.emailConcatenation(3,2);//tel+"@qq.com";
		String zzmm = Data.zzmm;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		String info[] = rechargePage.setInfo(realName,idCard,zzmm);
		realName = info[0];
		idCard = info[1];
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.emailAuthentication(email);
//		String tel = "15847123674";
//		String name = "�޺�ѩ";
//		String email = "15895606240@qq.com";
//		String idCard = "110114198105070343";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		//У��
		idCard = idCard.substring(0,3)+"********"+idCard.substring(16,18).toLowerCase();
		tel = tel.substring(0, 3)+"****"+tel.substring(7, 11);
		email = email.substring(0,2)+"****"+email.substring(email.indexOf("@"));
		String list[] = {realName,idCard,tel,email};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.updateBtnVisible();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.isAuthentication("���֤��","����֤");
		securityAuthPage.isAuthentication("�ֻ���","����֤");
		securityAuthPage.isAuthentication("֧������","������");
		securityAuthPage.isAuthentication("����","�Ѱ�");
	}
	
	@Test(priority = 5)
	public void checkRegisterStatus_web_1275_5(){
		Reporter.log("��ȫ��֤P2�������ֻ��û�,ע���Ժ�,��ȫ������֤���֤,�鿴�˻���Ϣ,�˻���Ϣ������&���֤����-�Ѿ���֤/�ֻ���-����֤/�ص�-��/����-��/����༭��ť,����Ϊ�ɱ༭״̬<br/>");
		base.logout();
		//ע��
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel5;
			realName = Data.test_run_SecurityAuth_P3_realName5;
			idCard = Data.test_run_SecurityAuth_P3_idCard5;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.identityAuthentication(realName, idCard);
//		String tel = "15847123674";
//		String name = "�޺�ѩ";
//		String email = "15895606240@qq.com";
//		String idCard = "110114198105070343";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		//У��
		idCard = idCard.substring(0,3)+"********"+idCard.substring(16,18).toLowerCase();
		tel = tel.substring(0, 3)+"****"+tel.substring(7, 11);
		String list[] = {realName,idCard,tel,"---"};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.isWrite(false,false,false,true);
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.isAuthentication("���֤��","����֤");
		securityAuthPage.isAuthentication("�ֻ���","����֤");
		securityAuthPage.isAuthentication("֧������","δ����");
		securityAuthPage.isAuthentication("����","δ��");
	}
	
	@Test(priority = 6)
	public void checkRegisterStatus_web_1275_6(){
		Reporter.log("��ȫ��֤P2�����ֻ�ע���û�,ע���Ժ�,ȥ�˻���Ϣ��д��Ϣ,��д����,���֤����,�ص�,�����������,ȥ��ȫ���Ĳ鿴����ȫ������,���֤,����,֧�������δ��֤,�ֻ�����֤<br/>");
		base.logout();
		//ע��
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel6;
			realName = Data.test_run_SecurityAuth_P3_realName6;
			idCard = Data.test_run_SecurityAuth_P3_idCard6;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		String email = data.emailConcatenation(3,2);
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		accountInfoPage.updateInfo(realName,idCard,tel,email);
		accountInfoPage.isUpdateOK("����ɹ�!");
//		String tel = "15847123674";
//		String name = "�޺�ѩ";
//		String email = "15895606240@qq.com";
//		String idCard = "110114198105070343";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		//У��
		idCard = idCard.substring(0,3)+"********"+idCard.substring(16,18).toLowerCase();
		tel = tel.substring(0, 3)+"****"+tel.substring(7, 11);
		email = email.substring(0,2)+"****"+email.substring(email.indexOf("@"));
		String list[] = {realName,idCard,tel,email};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.isWrite(true,true,false,true);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.isAuthentication("���֤��","δ��֤");
		securityAuthPage.isAuthentication("�ֻ���","����֤");
		securityAuthPage.isAuthentication("֧������","δ����");
		securityAuthPage.isAuthentication("����","δ��");
	}
	
	@Test(priority = 7)
	public void checkCreditRechargePrompt_web_3532(){
		Reporter.log("��ȫ��֤P2��������û�,δ���������֤����汦Ͷһ�� ��������ʾ����ʾ�� ����ȥ��ֵ����Ͷ�ʣ������ֵ����ת����ֵ����<br/>");
		Reporter.log("��ȫ��֤P2��������û�,δ���������֤�����Ǽƻ� ������ʾ����ʾ�� ����ȥ��ֵ����Ͷ�ʣ� ��ʾ�����и�ȥ��ֵ�������ֵ����ת����ֵ����<br/>");
		Reporter.log("��ȫ��֤P2��������û�,δ���������֤�������ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-ͬ��ԤͶ�� ҳ�棬����������µ�Ͷ������,�����Ǯ������ť,�����ȥ��ֵ������ť,�ڡ���֤��������д��ȷ��Ϣ������֤<br/>");
		base.logout();
		String tel = "13111111245";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel1;
		}
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, "111111");
		//��汦ǹͷ ��������ʾ����ʾ�� ����ȥ��ֵ����Ͷ�ʣ� ��ʾ�����и�ȥ��ֵ����ť
		base.openBrowser(base.indexURL+"/new/loadAllWmpsRecords.action");
		if (eCunBaoPage.clickCreditBtn()) {
			eCunBaoPage.promptRecharge();
			eCunBaoPage.goRecharge();
			base.checkContainsTitle(PageTitles.woDeZhangHu,10);
			myAccountPage.isGoMyAccount("��ֵ");
		}
		//���Ǽƻ� ������ʾ����ʾ�� ����ȥ��ֵ����Ͷ�ʣ� ��ʾ�����и�ȥ��ֵ����ť
		base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		if (eStarPlanListPage.ifshowBZStarInvestNowLnk()) {
			base.clickWithWait(eStarPlanListPage.BZStarInvestNowLnk);
			eStarPlanListPage.promptRecharge();
			eStarPlanListPage.goRecharge();
			base.checkContainsTitle(PageTitles.woDeZhangHu,10);
			myAccountPage.isGoMyAccount("��ֵ");
		}
		if (base.indexURL.contains("/client") || base.indexURL.contains("inclient")) {
			//�����ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-ͬ��ԤͶ�� ҳ�棬����������µ�Ͷ������,�����Ǯ������ť,�����ȥ��ֵ������ť,�ڡ���֤��������д��ȷ��Ϣ������֤
			myAccountPage.turnToMyAccount("ɢ��Ͷ��");
			sBInvestPage.clickBit();
			if (sBInvestPage.ifHasSameCityBit()) {
				base.turnToNewPage();
				investmentListPage.clickBorrow();
				investmentListPage.isShowRecharge();
				investmentListPage.clickRecharge();
				base.checkContainsTitle(PageTitles.woDeZhangHu,10);
				myAccountPage.isGoMyAccount("��ֵ");
				rechargePage.checkShowUserInfoInput(false,false,true);
			}
		}
	}
}
