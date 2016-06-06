package com.eloancn.suites.index;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.RegisterPage;
/**
 * ע��P2
 * @author ����Ԫ
 */
public class Register_P2 {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	RegisterPage registerPage = new RegisterPage();
	Data data = new Data();

	@BeforeClass
	public void setupBefore(){
		base.setup();
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * �����ҳ�ĵ�������ע�ᰴť,��תע��ҳ��
	 */
	@Test(priority=1)
	public void indexRegister_web_15_1(){
		Reporter.log("ע��P2:�����ҳ�ĵ�������ע�ᰴť,��תע��ҳ��<br/>");
		base.openBrowser(base.indexURL);
		//��ҳ�����ע�ᡱ
		indexPage.clickRegisterLink();
		//�ж���תע��ҳ��
		registerPage.isTurnRegisterPage();
	}

	/**
	 * �����ҳ�ĵ������������Ĺ�����е����ע�ᰴť,��תע��ҳ��
	 */
	@Test(priority=2,enabled=false)
	public void indexFreeRegister_web_15_2(){
		Reporter.log("ע��P2:�����ҳ�ĵ������������Ĺ�����е����ע�ᰴť,��תע��ҳ��<br/>");
		base.openBrowser(base.indexURL);
		//��ҳ�����ע�ᡱ
		indexPage.clickFreeRegister();
		//�ж���תע��ҳ��
		registerPage.isTurnRegisterPage();
	}
	
	/**
	 * �������ҵ��˻����ע�ᰴť,��תע��ҳ��
	 */
	@Test(priority=3)
	public void myAccountFreeRegister_web_15_3(){
		Reporter.log("ע��P2:�������ҵ��˻����ע�ᰴť,��תע��ҳ��<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//��ҳ�����ע�ᡱ
		loginPage.clickFreeRegister();
		//�ж���תע��ҳ��
		registerPage.isTurnRegisterPage();
	}
	
	/**
	 * �����У��  A010BJS_CES043  A010BJS_CES042
	 */
	@Test(priority=4)
	public void checkTiYanDianRegister_web_1263(){
		Reporter.log("ע��P2:������ȷ������,��������ȷ;����������������룬��ʾ����;����������������룬��ʾ����;������ʹ��ȫ������,��ʾ����;���ͬ��������Э��  ��ʾЭ��;���ȡ����ѡ������Э��,�����һ��,��ʾ��ѡ��������Э��<br/>");
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		registerPage.selectRole("��Ҫ���");
		//���������ѡ��
		registerPage.clickYaoQingMa();
		if (base.indexURL.contains("/client") || base.indexURL.contains("inclient")) {
			//������ȷ������,��������ȷ
			registerPage.inputYaoQingMa("A010BJS_CES043");
			registerPage.isYaoQingMaOK();
		}
		//����������������룬��ʾ����
		registerPage.inputYaoQingMa("A010BJS_CES043A010BJS_CES042");
		registerPage.isYaoQingMaWrong("����д��ȷ�������룬�޿ɲ��");
		//����������������룬��ʾ����
		registerPage.inputYaoQingMa("A010BJS_CES04");
		registerPage.isYaoQingMaWrong("����д��ȷ�������룬�޿ɲ��");
		//������ʹ��ȫ������,��ʾ����
		registerPage.inputYaoQingMa(base.btoQ("A010BJS_CES04"));
		registerPage.isYaoQingMaWrong("����д��ȷ�������룬�޿ɲ��");
		//���ͬ��������Э��  ��ʾЭ��
		registerPage.clickAgree();
		registerPage.showAgree();
		registerPage.closeAgree();
		//���ȡ����ѡ������Э��,�����һ��,��ʾ��ѡ��������Э��
		registerPage.inputTel(data.phoneConcatenation(0));
		registerPage.clickPassword();
		registerPage.inputPassword("111111");
		registerPage.inputRandcode("");
		registerPage.clearYaoQingMa();
		registerPage.cancleAgree();
		registerPage.clickNestStep();
		registerPage.isAgreeWrong();
	}
}
