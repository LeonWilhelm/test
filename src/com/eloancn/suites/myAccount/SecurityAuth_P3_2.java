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
public class SecurityAuth_P3_2 {
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
	public void checkDebitIdentityAuthentication_web_3536(){
		Reporter.log("��ȫ��֤P2�����û�������֤�����֤,���û�ע��ɹ���δ���������֤<br/>");
		Reporter.log("��ȫ��֤P2�������ҵ��˻�-�ҵĽ���-�ҵĽ���������Ȱ�ť,��ת���������ʸ���֤��ʾҳ��;����ʸ���֤,��ת��������ʸ���֤�����֤��֤����<br/>");
		Reporter.log("��ȫ��֤P2�������ҵ��˻�-�ҵĽ���-�ҵĽ���������ť,��ת���������ʸ���֤��ʾҳ��;����ʸ���֤,��ת��������ʸ���֤�����֤��֤����<br/>");
		Reporter.log("��ȫ��֤P2�������ҵ��˻�-�ҵ��˻�-�˻�����������·��ҵĽ��������������,��ת���������ʸ���֤��ʾҳ��;����ʸ���֤,��ת��������ʸ���֤�����֤��֤����<br/>");
		Reporter.log("��ȫ��֤P2�������ҵ��˻�-�ҵĽ���-������,��ת���������ʸ���֤��ʾҳ��;����ʸ���֤,��ת��������ʸ���֤�����֤��֤����;��д��ȷ�������Ϣ������֤,��֤�ɹ�<br/>");
		base.logout();
		//ע��
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel8;
			realName = Data.test_run_SecurityAuth_P3_realName8;
			idCard = Data.test_run_SecurityAuth_P3_idCard8;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("debit", tel, password);
		//�����ҵ��˻�-�ҵĽ���-�ҵĽ���������Ȱ�ť
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("�ҵĽ��");
		myLoanPage.clickBtn("������");
		checkDIA();
		//�����ҵ��˻�-�ҵĽ���-�ҵĽ���������ť
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("�ҵĽ��");
		myLoanPage.clickLoanApplication();
		checkDIA();
		//�����ҵ��˻�-�ҵ��˻�-�˻�����������·��ҵĽ��������������
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.clickLoanApplicationLnk();
		checkDIA();
		//�����ҵ��˻�-�ҵĽ���-������,��ת���������ʸ���֤��ʾҳ��;����ʸ���֤,��ת��������ʸ���֤�����֤��֤����;��д��ȷ�������Ϣ������֤,��֤�ɹ�
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("������");
		checkDIA();
		String info[] = registerPage.idCardIdentification(realName,idCard);
		realName = info[0];
		idCard = info[1];
		Reporter.log("�������֤:"+realName+","+idCard+","+tel+"<br/>");
		System.out.println("�������֤:"+realName+","+idCard+","+tel);
		//����������д����
		registerPage.isInfoPage();
	}
	
	//У������ʸ���֤
	public void checkDIA(){
		base.checkElmentText(LoanApplicationPage.VerifyAuthBtn, "�ʸ���֤");
		base.clickWithWait(LoanApplicationPage.VerifyAuthBtn);
		base.assertEqualsActualExpectedByInt(base.turnToTargetCloseOtherPage("������֤"), 1);
		registerPage.isDebitVerifyPage();
	}
	
	@Test(priority = 2)
	public void checkRegisterIdentityAuthentication_web_3538(){
		Reporter.log("��ȫ��֤P2�����û�������ʾ��ȫ��֤�����֤,���û�ע��ɹ������������ߣ�����վ����ҳ�����<br/>");
		Reporter.log("��ȫ��֤P2�������ҵ��˻�-�ҵ��˻�-����,��ʾ��֤�������ȥ��ȫ��֤����ť����ת������ȫ��֤��ҳ�棬ѡ��ʵ����֤���������֤�����·������������֤�����ҳ��<br/>");
		Reporter.log("��ȫ��֤P2�������ҵ��˻�-�ҵ��˻�-�˻��������ѹ�������˻����Աߵġ�С�ˡ������֡�ȥ��֤�����ӣ������ȥ��֤������ת������ȫ��֤��ҳ�棬ѡ��ʵ����֤���������֤�����·������������֤�����ҳ��<br/>");
		Reporter.log("��ȫ��֤P2�������ҵ��˻�-�ҵ��˻�-�˻�����������˻���һ�к���ġ����������ӣ���ת������ȫ��֤��ҳ�棬ѡ��ʵ����֤���������֤�����·������������֤�����ҳ��<br/>");
		Reporter.log("��ȫ��֤P2�������ҵ��˻�-�˻�����-��ȫ��֤��ѡ��ʵ����֤���������֤�����·������������֤�����ҳ�棬��д��ȷ�������Ϣ������֤����֤�ɹ�<br/>");
		base.logout();
		//ע��
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel9;
			realName = Data.test_run_SecurityAuth_P3_realName9;
			idCard = Data.test_run_SecurityAuth_P3_idCard9;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("debit", tel, password);
		//�����ҵ��˻�-�ҵ��˻�-����,��ʾ��֤�������ȥ��ȫ��֤����ť����ת������ȫ��֤��ҳ�棬ѡ��ʵ����֤���������֤�����·������������֤�����ҳ��
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("����");
		withDrawPage.prompt("Ϊ�˱��������˻���ȫ,������ɰ�ȫ��֤����֧���������ú������֣�");
		withDrawPage.clickAuthentication();
		checkIA();
		//�����ҵ��˻�-�ҵ��˻�-�˻��������ѹ�������˻����Աߵġ�С�ˡ������֡�ȥ��֤�����ӣ������ȥ��֤������ת������ȫ��֤��ҳ�棬ѡ��ʵ����֤���������֤�����·������������֤�����ҳ��
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		myAccountPage.clickAuthentication();
		checkIA();
		//�����ҵ��˻�-�ҵ��˻�-�˻�����������˻���һ�к���ġ����������ӣ���ת������ȫ��֤��ҳ�棬ѡ��ʵ����֤���������֤�����·������������֤�����ҳ��
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		securityAuthPage.clickUp();
		checkIA();
		securityAuthPage.sendName(realName);
		securityAuthPage.sendIDCard(idCard);
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		securityAuthPage.isIdentityAuthenticationOK("�����֤�ɹ�");
	}
	
	//У�鰲ȫ��֤
	public void checkIA(){
		base.checkContainsTitle(PageTitles.woDeZhangHu,10);
		//base.assertEqualsActualExpectedByInt(base.turnToTargetCloseOtherPage("�ҵ��˻�"), 1);
		myAccountPage.isGoMyAccount("��ȫ��֤");
		//base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.showIdentityAuthentication();
	}
	
	@Test(priority = 3)
	public void checkRegisterIdentityAuthentication_web_3798(){
		Reporter.log("��ȫ��֤P2����ע����˻���δ�����֤,���������ֻ��Ŵ��������ŵ��ֻ��Ŵ�������������ʾ�����������ӣ���ֵ�����֡�Ͷ��<br/>");
		Reporter.log("��ȫ��֤P2�������ʾ��������ĳ�ֵ����,��ת����ֵҳ��,�������Ƹ��������Ϣ������<br/>");
		Reporter.log("��ȫ��֤P2�������ʾ�����������������,��ת������ҳ��,�����ȥ��ȫ��֤����ť,��ʾ��֤�����ȥ��֤��ť����ת����ȫ��֤--ʵ����֤ҳ��<br/>");
		Reporter.log("��ȫ��֤P2�������ʾ���������Ͷ�����ӣ���ת����汦Ͷ��ҳ��<br/>");
		base.logout();
		//ע��
//		String tel = data.phoneConcatenation(0);
//		String password = Data.password;
//		base.openBrowser(base.indexURL + "/page/register/register.jsp");
//		tel = registerPage.register("debit", tel, password);
		
		//�����ʾ��������ĳ�ֵ����,��ת����ֵҳ��,�������Ƹ��������Ϣ������
		String tel = "15095663196";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel1;
		}
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, "111111");
		
		myAccountPage.mouseToTel("1");
		rechargePage.isIdentityInfo();
		rechargePage.closeInfo();
		base.checkContainsTitle(PageTitles.woDeZhangHu,10);
		myAccountPage.isGoMyAccount("��ֵ");
		//�����ʾ�����������������,��ת������ҳ��,�����ȥ��ȫ��֤����ť,��ʾ��֤�����ȥ��֤��ť����ת����ȫ��֤--ʵ����֤ҳ��
		myAccountPage.mouseToTel("2");
		base.checkContainsTitle(PageTitles.woDeZhangHu,10);
		myAccountPage.isGoMyAccount("����");
		withDrawPage.clickAuthentication();
		checkIA();
		//#drawtip .lywrap
		//�����ʾ���������Ͷ�����ӣ���ת����汦Ͷ��ҳ��
		myAccountPage.mouseToTel("3");
		base.checkTitle(PageTitles.yiCunBao);
	}
	
	@Test(priority = 4,enabled=false)
	public void checkIdentityAuthenticationFail_web_3541(){
		Reporter.log("��ȫ��֤P2���û�ע��ɹ���δ���������֤,����ʵ�������ı�������N���ַ�����ʵ����֤����ʾ��֤ʧ��<br/>");
		Reporter.log("��ȫ��֤P2������ֵ��ҳ��ġ���֤������ֻ��ʾ���á�֧�����롱�������������֤ <br/>");
		Reporter.log("��ȫ��֤P2������ˡ��ʸ���֤�����������֤<br/>");
		Reporter.log("��ȫ��֤P2����ȫ��֤�е�ʵ����֤��ʾδ��֤<br/>");
		//ע��
		base.logout();
		String tel = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel11;
		}else {
			tel = data.phoneConcatenation(0);
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("debit", tel, password);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.identityAuthentication("���Ϳ��Լ�������������֤��ȡ���ߵ��������ۺͽ�������Ϳ��Լ�������������֤��ȡ���ߵ��������ۺͽ����",data.idConcatenation());
		//base.turnToTargetCloseOtherPage("�ҵ��˻�");
		securityAuthPage.isIdentityAuthenticationOK("��֤ʧ�ܣ�");
		securityAuthPage.closePrompty();
		//�����ʾ��������ĳ�ֵ����,��ת����ֵҳ��,�������Ƹ��������Ϣ������
//		String tel = "13590647625";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		myAccountPage.turnToMyAccount("��ֵ");
		rechargePage.checkShowUserInfoInput(false,false,true);
		rechargePage.closeInfo();
		//����ˡ��ʸ���֤�����������֤"
		myAccountPage.turnToMyAccount("������");
		base.checkElmentText(LoanApplicationPage.VerifyAuthBtn, "�ʸ���֤");
		//��ȫ��֤�е�ʵ����֤��ʾδ��֤
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.isAuthentication("���֤��","δ��֤");
	}
	
	
	@Test(priority = 5,enabled=false)//15758824744
	public void checkIdentityAuthenticationFail_web_3546(){
		Reporter.log("��ȫ��֤P2����֤ʧ�ܣ����ҵ��˻�-�˻�����-�˻���Ϣ�������û���Ϣ<br/>");
		Reporter.log("��ȫ��֤P2�����ҵ��˻�-�˻�����-��ȫ��֤�н��������֤,�������˻���Ϣ��ͬ������,��ʾ���������˻���Ϣ�в�һ��;�������˻���Ϣ��ͬ�����֤��,��ʾ�����֤�����˻���Ϣ�в�һ��,��ʱ���û����Ը���ʵ������޸ĳ���ȷ�����������֤��<br/>");
		//ע��
		base.logout();
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel9;
			realName = Data.test_run_SecurityAuth_P3_realName9;
			idCard = Data.test_run_SecurityAuth_P3_idCard9;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("debit", tel, password);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//��ȫ��֤  ��֤ʧ��
		myAccountPage.turnToMyAccount("��ȫ��֤");
		//base.turnToTargetCloseOtherPage("�ҵ��˻�");
		securityAuthPage.identityAuthentication("���Ϳ��Լ�������������֤��ȡ���ߵ��������ۺͽ�������Ϳ��Լ�������������֤��ȡ���ߵ��������ۺͽ����",idCard);
		securityAuthPage.isIdentityAuthenticationOK("��֤ʧ�ܣ�");
		securityAuthPage.closePrompty();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//�˻���Ϣ�޸�
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		accountInfoPage.clickUpdateBtn();
		//base.turnToTargetCloseOtherPage("�ҵ��˻�");
		accountInfoPage.updateInfo(realName,idCard,"",tel+"@qq.com");
		accountInfoPage.isUpdateOK("����ɹ�!");
		//��ȫ��֤  ���˻���Ϣ��ͬ������
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendName("����");
		securityAuthPage.sendIDCard(idCard);
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		securityAuthPage.checkIdAuth("����������������õĲ�һ��,�뵽�˻������������!");
		securityAuthPage.closePrompty();
		//��ȫ��֤  ���˻���Ϣ��ͬ�����֤
		securityAuthPage.sendName(realName);
		String idCard2 = data.idConcatenation();
		securityAuthPage.sendIDCard(idCard2);
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		securityAuthPage.checkIdAuth("�˴���֤���״���֤��");
		securityAuthPage.clickGoOn();
		securityAuthPage.checkIdAuth("����������֤�������õĲ�һ��,�뵽�˻������������!");
		securityAuthPage.closePrompty();
		//��ȫ��֤  ���˻���Ϣ���������֤��ͬ
		securityAuthPage.sendName(realName);
		securityAuthPage.sendIDCard(idCard);
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		securityAuthPage.checkIdAuth("����10.0Ԫ�����ȳ�ֵ��������ֱ�ӻ��ת�ˣ���ȴ���˺����ԣ�");
		securityAuthPage.closePrompty();
	}
	
	@Test(priority = 6)
	public void checkIdentityAuthenticationuniversal_web_3539(){
		Reporter.log("��ȫ��֤P2����֤�����֤ͨ����,ע����3�����û�����δ���������֤<br/>");
		Reporter.log("��ȫ��֤P2���û�1�ڡ���ֵ��ҳ�棬�����ġ���֤��������֤�ɹ�,�ҵ��˻�-�˻�����-��ȫ��֤�У���ʵ����֤����ʾ������֤���������ҵ��˻�-�ҵĽ���-�����������ʸ���֤�������ʸ���֤��ҳ�桰���֤��֤������֤ͨ����ֱ�ӵ���һ����<br/>");
		Reporter.log("��ȫ��֤P2���û�2�ڡ���ȫ��֤��ҳ�棬ʵ����֤�������֤�ɹ�������ֵ��ҳ�浯���ġ���֤�����ڣ�����ʵ�������͡����֤�š������޸ģ�֧�������Կ��ڸô������ã������ҵ��˻�-�ҵĽ���-�����������ʸ���֤�������ʸ���֤��ҳ�桰���֤��֤������֤ͨ����ֱ�ӵ���һ����<br/>");
		Reporter.log("��ȫ��֤P2���û�3ͨ������ˡ��ʸ���֤�������֤�ɹ�,�ҵ��˻�-�˻�����-��ȫ��֤�У���ʵ����֤����ʾ������֤��,����ֵ��ҳ�浯���ġ���֤�����ڣ�����ʵ�������͡����֤�š������޸ģ�֧�������Կ��ڸô�������<br/>");
		//�û�1�ڡ���ֵ��ҳ�棬�����ġ���֤��������֤�ɹ�,�ҵ��˻�-�˻�����-��ȫ��֤�У���ʵ����֤����ʾ������֤���������ҵ��˻�-�ҵĽ���-�����������ʸ���֤�������ʸ���֤��ҳ�桰���֤��֤������֤ͨ����ֱ�ӵ���һ����
		base.logout();
		String tel1 = "";
		String idCard1 = "";
		String realName1 = "�û�һ";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel1 = Data.test_run_SecurityAuth_P3_tel13_1;
			realName1 = Data.test_run_SecurityAuth_P3_idCard13_1;
			idCard1 = Data.test_run_SecurityAuth_P3_realName13_1;
		}else {
			tel1 = data.phoneConcatenation(0);
			idCard1 = new Data().idConcatenation();
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel1 = registerPage.register("debit", tel1, password);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ֵ");
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
		String info[] = rechargePage.setInfo(realName1,idCard1,"111111");
		idCard1 = info[1];
		myAccountPage.turnToMyAccount("������");
		checkIAOver();
		//�û�2�ڡ���ȫ��֤��ҳ�棬ʵ����֤�������֤�ɹ�������ֵ��ҳ�浯���ġ���֤�����ڣ�����ʵ�������͡����֤�š������޸ģ�֧�������Կ��ڸô������ã������ҵ��˻�-�ҵĽ���-�����������ʸ���֤�������ʸ���֤��ҳ�桰���֤��֤������֤ͨ����ֱ�ӵ���һ����
		base.logout();
		String tel2 = "";
		String idCard2 = "";
		String realName2 = "�û���";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel2 = Data.test_run_SecurityAuth_P3_tel13_2;
			idCard2 = Data.test_run_SecurityAuth_P3_idCard13_2;
			realName2 = Data.test_run_SecurityAuth_P3_realName13_2;
		}else {
			tel2 = data.phoneConcatenation(0);
			idCard2 = new Data().idConcatenation();
		}
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel2 = registerPage.register("debit", tel2, password);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		if(base.gethandelsNum()==2){
			base.turnToTargetCloseOtherPage("�ҵ��˻�");
		}
		securityAuthPage.identityAuthentication(realName2, idCard2);
		securityAuthPage.closePrompty();
		base.turnToTargetCloseOtherPage("�ҵ��˻�");
		myAccountPage.turnToMyAccount("��ֵ");
		rechargePage.checkShowUserInfoInput(false,false,true);
		myAccountPage.turnToMyAccount("������");
		checkIAOver();
		//�û�3ͨ������ˡ��ʸ���֤�������֤�ɹ�,�ҵ��˻�-�˻�����-��ȫ��֤�У���ʵ����֤����ʾ������֤��,����ֵ��ҳ�浯���ġ���֤�����ڣ�����ʵ�������͡����֤�š������޸ģ�֧�������Կ��ڸô�������
		base.logout();
		String tel3 = "";
		String idCard3 = "";
		String realName3 = "�û���";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel3 = Data.test_run_SecurityAuth_P3_tel13_2;
			idCard3 = Data.test_run_SecurityAuth_P3_idCard13_2;
			realName3 = Data.test_run_SecurityAuth_P3_realName13_2;
		}else {
			tel3 = data.phoneConcatenation(0);
			idCard3 = new Data().idConcatenation();
		}
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel3 = registerPage.register("debit", tel3, password);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("������");
		checkDIA();
		registerPage.idCardInfo(realName3,idCard3);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.isAuthentication("���֤��","����֤");
		myAccountPage.turnToMyAccount("��ֵ");
		rechargePage.checkShowUserInfoInput(false,false,true);
	}
	
	public void checkIAOver(){
		base.checkElmentText(LoanApplicationPage.VerifyAuthBtn, "�ʸ���֤");
		base.clickWithWait(LoanApplicationPage.VerifyAuthBtn);
		base.assertEqualsActualExpectedByInt(base.turnToTargetCloseOtherPage("������֤"), 1);
		registerPage.isInfoPage();
	}
}
