package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
/**
 * ����Ԫ
 * ��¼P1
 */
public class Login_P2 {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	
	String tel = "";
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}

	@Test(priority=1)
	public void checkTelLengthLogin_web_1308(){
		Reporter.log("����10λ���ֻ��š�����12λ�ֻ��š�����11λ�ķ��ֻ�������,��ʾ������Ϣ<br/>");
		indexPage.clickLoginLink();
		//����10λ���ֻ���
		loginPage.login("1312123123", "111111");
		loginPage.wrongMsg("�û���������email���ֻ��Ż�18λ���֤��!");
		//����12λ�ֻ���
		loginPage.inputTel("131212312311");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("�û���������email���ֻ��Ż�18λ���֤��!");
		//����11λ�ķ��ֻ�������
		loginPage.inputTel("11121231231");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("�ֻ������ʽ����ȷ!");
		loginPage.closeLogin();
	}
	
	@Test(priority=2)
	public void checkTelTypeLogin_web_1309(){
		Reporter.log("����11��Ӣ����ĸ������11λ�ĺ��֡�����11λ��������š�����11λ�ֻ��ţ��м��пո�����11λ���ֻ��ţ��ֻ���ǰ���пո���ʾ������Ϣ<br/>");
		indexPage.clickLoginLink();
		//����11��Ӣ����ĸ
		loginPage.login("aaaaaaaaaaa", "111111");
		loginPage.wrongMsg("�ֻ������ʽ����ȷ!");
		//����11λ�ĺ���
		loginPage.login("����������������������", "111111");
		loginPage.wrongMsg("�ֻ������ʽ����ȷ!");
		//����11λ���������
		loginPage.inputTel("!!!!!!!!!!!");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("�ֻ������ʽ����ȷ!");
		//����11λ�ֻ��ţ��м��пո�
		loginPage.inputTel("131 11111171");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("�û���������email���ֻ��Ż�18λ���֤��!");
		//����11λ���ֻ��ţ��ֻ���ǰ���пո�
		loginPage.inputTel(" 13111111171");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("�ֻ������ʽ����ȷ!");
		loginPage.closeLogin();
	}
	
	@Test(priority=3)
	public void checkEmailLogin_web_1310(){
		Reporter.log("�������䲻��@���š��������䲻��.com���������䲻�����������������ַ���пո���ʾ������Ϣ<br/>");
		indexPage.clickLoginLink();
		//�������䲻��@����
		loginPage.login("123126.com", "111111");
		loginPage.wrongMsg("�û���������email���ֻ��Ż�18λ���֤��!");
		//�������䲻��.com
		loginPage.login("123@126", "111111");
		loginPage.wrongMsg("email��ʽ������Ҫ��!");
		//�������䲻������
		loginPage.inputTel("123@.com");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("email��ʽ������Ҫ��!");
		//���������ַ���пո�
		loginPage.inputTel("12 3@126.com");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("email��ʽ������Ҫ��!");
		loginPage.closeLogin();
	}
	
	@Test(priority=4)
	public void checkIDcardLenthLogin_web_1313(){
		Reporter.log("����17λ�����֤�š�����19λ�����֤�ţ���ʾ������Ϣ<br/>");
		indexPage.clickLoginLink();
		//����17λ�����֤��
		loginPage.login("11010519850423007", "111111");
		loginPage.wrongMsg("�û���������email���ֻ��Ż�18λ���֤��!");
		//����19λ�����֤��
		loginPage.login("110105198504230071X", "111111");
		loginPage.wrongMsg("�û���������email���ֻ��Ż�18λ���֤��!");
		loginPage.closeLogin();
	}
	
	@Test(priority=5)
	public void checkIDcardTypeLogin_web_1316(){
		Reporter.log("����18λ��Ӣ����ĸ������18λ��������š�����18λ���֡���������,Ӣ����ĸ,������ŵ���ϡ�����18λ�����֤�ţ�����ǰ�ո�����18λ�����֤�ţ��м京�пո�����18λ�����֤�ţ����к�ո���ʾ������Ϣ<br/>");
		indexPage.clickLoginLink();
		//����18λ��Ӣ����ĸ
		loginPage.login("aaaaaaaaaaaaaaaaaa", "111111");
		loginPage.wrongMsg("���֤��������,����!");
		//����18λ���������
		loginPage.login("!!!!!!!!!!!!!!!!!!", "111111");
		loginPage.wrongMsg("���֤��������,����!");
		//����18λ����
		loginPage.login("������������������������������������", "111111");
		loginPage.wrongMsg("���֤��������,����!");
		//��������,Ӣ����ĸ,������ŵ����
		loginPage.login("12345!!!!!a!!1!!!!", "111111");
		loginPage.wrongMsg("���֤��������,����!");
		//����18λ�����֤�ţ�����ǰ�ո�
		loginPage.login(" 11010519850423007X", "111111");
		loginPage.wrongMsg("���֤��������,����!");
		//����18λ�����֤�ţ��м京�пո�
		loginPage.login("1101051985 0423007X", "111111");
		loginPage.wrongMsg("�û���������email���ֻ��Ż�18λ���֤��!");
		//����18λ�����֤�ţ����к�ո�
		loginPage.login("11010519850423007X ", "111111");
		loginPage.wrongMsg("���֤��������,����!");
		loginPage.closeLogin();
	}
	
	@Test(priority=6)
	public void checkIDcardContainsXLogin_web_1317(){
		Reporter.log("�������֤�ſ�ͷ������ĸX���������֤���м京��X���������֤��ĩβΪ��X����ĸ���������֤ĩβΪСдx����ʾ������Ϣ<br/>");
		indexPage.clickLoginLink();
		//�������֤�ſ�ͷ������ĸX
		loginPage.login("X11010519850423007", "111111");
		loginPage.wrongMsg("���֤��������,����!");
		//�������֤���м京��X
		loginPage.login("110105X19850423007", "111111");
		loginPage.wrongMsg("���֤��������,����!");
		//�������֤��ĩβΪ��X����ĸ
		loginPage.login("11010519850423007V", "111111");
		loginPage.wrongMsg("���֤��������,����!");
		//�������֤ĩβΪСдx
		loginPage.login("11010519850423007x", "111111");
		loginPage.wrongMsg("�û��������벻ƥ�䡣");
		loginPage.closeLogin();
	}
}
