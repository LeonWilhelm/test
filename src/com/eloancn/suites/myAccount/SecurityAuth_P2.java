package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.AccountInfoPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RegisterPage;
import com.eloancn.shared.pages.SecurityAuthPage;

/**
 * ����Ԫ
 * ��ȫ��֤
 */
public class SecurityAuth_P2 {
	LoginPage loginPage = new LoginPage();
	Base base = new Base();
	Data data = new Data();
	RegisterPage registerPage = new RegisterPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	
	String tel = "13111111228";
	String emailUserd = "13111111171@qq.com";//��ʹ�õ�����
	String telUserd = "13111111171";//��ʹ�õ�����
	String email = "123@126.com";
	String user = "15095663196";//��ȫ��֤
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_ECunBao_register;
			emailUserd = "ff@qq.com";
			email = "aa@qq.com";
			user = email;
			telUserd = "18880000200";
		}
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
	}

	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(priority = 1)
	public void checkAccountInfoEmail_web_1273(){
		Reporter.log("��ȫ��֤P2:�˻���Ϣ��д-������֤,����1@qq.com������1234567890123456789012345678901234@qq.com��"
				+"����123456789012345678901234567890123@qq.com������!#$%^@qq.com������abc_123@qq.com��"
				+"�����Ѿ�ʹ�ù������䡢��������ǰ׺��ͣ������ȫ�ǣ������@qq.com<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, "111111");
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.updateInfo("1@qq.com","email");
		accountInfoPage.isUpdateInfoOK("ok","pemail");
		accountInfoPage.updateInfo("1234567890123456789012345678901234@qq.com","email");
		accountInfoPage.isUpdateInfoOK("Email��ַ̫������������Ч��Email��","pemail");
		accountInfoPage.updateInfo("123456789012345678901234567890123@qq.com","email");
		accountInfoPage.isUpdateInfoOK("ok","pemail");
		accountInfoPage.updateInfo("ok","email");
		accountInfoPage.isUpdateInfoOK("��������Ч��Email��","pemail");
		accountInfoPage.updateInfo("!#$%^@qq.com","email");
		accountInfoPage.isUpdateInfoOK("��������Ч��Email��","pemail");
		accountInfoPage.updateInfo("abc_123@qq.com","email");
		accountInfoPage.isUpdateInfoOK("ok","pemail");
		accountInfoPage.updateInfo("�������@qq.com","email");
		accountInfoPage.isUpdateInfoOK("��������Ч��Email��","pemail");
		//�������ַ�ѱ�ʹ�ã�
		accountInfoPage.updateInfo(emailUserd,"email");
		accountInfoPage.isUpdateInfoOK("�������ַ�ѱ�ʹ�ã�","pemail");
	}

	@Test(priority = 2)
	public void checkAccountInfoName_web_1270(){
		Reporter.log("��ȫ��֤P2:�˻���Ϣ��д-����,����һ������һ�����������߰˾�ʮ�㡢����һ�����������߰˾�ʮ������!@#$%��"
				+"����abcdef���������� (�ĺ�����ո�)����������(��ǰ����ո�)����������(�м���ո�)����������123����������abc����������!@#<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(tel, "111111");
			myAccountPage.turnToMyAccount("�˻���Ϣ");
			accountInfoPage.clickUpdateBtn();
		}
		accountInfoPage.updateInfo("һ","name");
		accountInfoPage.isUpdateInfoOK("��ʵ����������һ��������!","prealnametip");
		accountInfoPage.updateInfo("һ�����������߰˾�ʮ��","name");//����������(2-10λ����)
		accountInfoPage.isUpdateInfoOK("ok","prealnametip");
		accountInfoPage.updateInfo("һ�����������߰˾�ʮ","name");
		accountInfoPage.isUpdateInfoOK("ok","prealnametip");
		accountInfoPage.updateInfo("!@#$%","name");
		accountInfoPage.isUpdateInfoOK("��ʵ��������ȫ��Ϊ����!","prealnametip");
		accountInfoPage.updateInfo("abcdef","name");
		accountInfoPage.isUpdateInfoOK("��ʵ��������ȫ��Ϊ����!","prealnametip");
		accountInfoPage.updateInfo("�� ��","name");
		accountInfoPage.isUpdateInfoOK("��ʵ��������ȫ��Ϊ����!","prealnametip");
		accountInfoPage.updateInfo("����123","name");
		accountInfoPage.isUpdateInfoOK("��ʵ��������ȫ��Ϊ����!","prealnametip");
		accountInfoPage.updateInfo("����abc","name");
		accountInfoPage.isUpdateInfoOK("��ʵ��������ȫ��Ϊ����!","prealnametip");
		accountInfoPage.updateInfo("����!@#","name");
		accountInfoPage.isUpdateInfoOK("��ʵ��������ȫ��Ϊ����!","prealnametip");
		accountInfoPage.updateInfo("���� ","name");
		accountInfoPage.isUpdateInfoOK("ok","prealnametip");//ok  ��ʵ��������ȫ��Ϊ����!
		accountInfoPage.updateInfo(" ����","name");
		accountInfoPage.isUpdateInfoOK("","prealnametip");//""  ��ʵ��������ȫ��Ϊ����!
	}
	
	@Test(priority = 3)
	public void checkAccountInfoIdCard_web_1271(){
		Reporter.log("��ȫ��֤P2:�˻���Ϣ��д-���֤��,����11010519850423007X������11010519850423007x������110105198504230������110105198504230071"
				+"���������������������������������������ġ�����!!!!!!!!!!!!!!!!!!������11010519850423007X1�����룱���������������������������������ء�����abcdabcdabcdabcdcd<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(tel, "111111");
			myAccountPage.turnToMyAccount("�˻���Ϣ");
			accountInfoPage.clickUpdateBtn();
		}
		accountInfoPage.updateInfo("11010519850423007X","idCard");
		accountInfoPage.isUpdateInfoOK("ok","pidcardtip");
		accountInfoPage.updateInfo("11010519850423007x","idCard");//����������(2-10λ����)
		accountInfoPage.isUpdateInfoOK("ok","pidcardtip");
		accountInfoPage.updateInfo("110105198504230","idCard");
		accountInfoPage.isUpdateInfoOK("���֤��������,����!","pidcardtip");
		accountInfoPage.updateInfo("110105198504230071","idCard");
		accountInfoPage.isUpdateInfoOK("���֤��������,����!","pidcardtip");
		accountInfoPage.updateInfo("������������������������������������","idCard");
		accountInfoPage.isUpdateInfoOK("���֤��������,����!","pidcardtip");
		accountInfoPage.updateInfo("!!!!!!!!!!!!!!!!!!","idCard");
		accountInfoPage.isUpdateInfoOK("���֤��������,����!","pidcardtip");
		accountInfoPage.updateInfo("������������������������������������","idCard");
		accountInfoPage.isUpdateInfoOK("���֤��������,����!","pidcardtip");
		accountInfoPage.updateInfo("abcdabcdabcdabcdcd","idCard");
		accountInfoPage.isUpdateInfoOK("���֤��������,����!","pidcardtip");
	}
	
	@Test(priority = 4)
	public void checkAccountInfoTel_web_1272(){
		Reporter.log("��ȫ��֤P2:�˻���Ϣ��д-�ֻ���,������ȷ���ֻ��š�����10λ�ֻ��š�����12λ�ֻ��š������Ѿ�ע����ֻ���"
				+"!@#$)(*^%%�����������������ġ�����������Ч���ֻ��š�����������Ч���ֻ��š��������ֻ���<br/>");
		base.logout();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(email, "111111");
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.updateInfo(new Data().phoneConcatenation(0),"tel");
		accountInfoPage.isUpdateInfoOK("ok","pmobile");
		accountInfoPage.updateInfo("1311111111","tel");//����������(2-10λ����)
		accountInfoPage.isUpdateInfoOK("��������ȷ���ֻ��ţ�","pmobile");
		accountInfoPage.updateInfo("131111111111","tel");
		accountInfoPage.isUpdateInfoOK("��������ȷ���ֻ��ţ�","pmobile");
		accountInfoPage.updateInfo(telUserd,"tel");
		accountInfoPage.isUpdateInfoOK("���ֻ����Ѿ���ע�����","pmobile");
		accountInfoPage.updateInfo("!@#$)(*^%%","tel");
		accountInfoPage.isUpdateInfoOK("��������ȷ���ֻ��ţ�","pmobile");
		accountInfoPage.updateInfo("������������","tel");
		accountInfoPage.isUpdateInfoOK("��������ȷ���ֻ��ţ�","pmobile");
		accountInfoPage.updateInfo(base.desc(new Data().phoneConcatenation(0)),"tel");
		accountInfoPage.isUpdateInfoOK("��������ȷ���ֻ��ţ�","pmobile");
		accountInfoPage.updateInfo(base.confuse(new Data().phoneConcatenation(0)),"tel");
		accountInfoPage.isUpdateInfoOK("��������ȷ���ֻ��ţ�","pmobile");
		accountInfoPage.updateInfo("","tel");
		accountInfoPage.isUpdateInfoOK("��������֤���ֻ��ţ�","pmobile");
		accountInfoPage.updateInfo(base.btoQ(new Data().phoneConcatenation(0)),"tel");
		accountInfoPage.isUpdateInfoOK("��������ȷ���ֻ��ţ�","pmobile");
	}
	
	@Test(priority = 5)
	public void checkIdentityAuthenticationNameNull_web_3529(){
		Reporter.log("��ȫ��֤P2����ȫ��֤-���֤��֤������Ϊ��,��ʾ��ʵ��������Ϊ��!<br/>");
		base.logout();
		//ע��
//		String tel = data.phoneConcatenation(0);
//		String password = Data.password;
//		base.openBrowser(base.indexURL + "/page/register/register.jsp");
//		tel = registerPage.register("credit", tel, password);
//		registerPage.clickRecharge();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(user, "111111");
		//�����֤
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendName("");
		securityAuthPage.sendIDCard(data.idConcatenation());
		//У��
		securityAuthPage.checkName("��ʵ��������Ϊ��!");
	}
	
	@Test(priority = 6)
	public void checkIdentityAuthenticationIdCardNull_web_3530(){
		Reporter.log("��ȫ��֤P2����ȫ��֤-���֤��֤�����֤��Ϊ��������ȷ��д,��ʾ���֤���벻��Ϊ��!<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(user, "111111");
		}
		//�����֤
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendIDCard("");
		securityAuthPage.sendName("����");
		//У��
		securityAuthPage.checkIdCard("���֤���벻��Ϊ��!");
	}
	
	@Test(priority = 7)
	public void checkIdentityAuthenticationIdCardAndNameOneChar_web_3533(){
		Reporter.log("��ȫ��֤P2����ȫ��֤�����������֤�����������С�ַ�1����<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//��¼
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(user, "111111");
		}
		//�����֤
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendName("��");
		securityAuthPage.sendIDCard("1");
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		//У��
		securityAuthPage.checkName("��ʵ����������2~20������֮��!");
		securityAuthPage.checkIdCard("���֤��������,����!");
	}
	
	@Test(priority = 8)
	public void checkIdentityAuthenticationIdCardMoreThanLenth_web_3534(){
		Reporter.log("��ȫ��֤P2����ȫ��֤�����֤������������߽��ַ�,����18λ<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//��¼
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(user, "111111");
		}
		//�����֤
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendIDCard(data.idConcatenation()+"1");
		securityAuthPage.sendName("����");
		//У��
		securityAuthPage.checkIdCard("���֤��������,����!");
	}
	
	@Test(priority = 9)
	public void checkIdentityAuthenticationIdCardAndNameSpecialChar_web_3537(){
		Reporter.log("��ȫ��֤P2����ȫ��֤���������֤�����������ַ�<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//��¼
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(user, "111111");
		}
		//�����֤
		myAccountPage.turnToMyAccount("��ȫ��֤");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendName("�� ��");
		securityAuthPage.sendIDCard("110105@98504230");
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		//У��
		securityAuthPage.checkIdCard("���֤��������,����!");
		securityAuthPage.checkName("��ʵ��������ȫ��Ϊ����!");
	}
}
