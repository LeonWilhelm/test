package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.AccountInfoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.RegisterPage;
import com.eloancn.shared.pages.SecurityAuthPage;
import com.eloancn.shared.pages.WithDrawPage;

/*
 * ��ɢ��Ͷ��ע�����̡�����-����Ԫ
 */
public class Credit {
//	static Logger logger = Logger.getLogger(Credit.class);
	Base base = new Base();
	RegisterPage registerPage = new RegisterPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	RechargePage rechargePage = new RechargePage();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	WithDrawPage withDrawPage = new WithDrawPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	
	public String tel2 = Data.tel2;
	String password = Data.password;
	String idCard2 = new Data().idConcatenation();
	String realName2 = Data.realName2;
	String email2 = Data.email2;
	String zzmm = Data.zzmm;
	String bank = Data.bankAccount;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel2 = Data.test_register_credit_tel;
			idCard2 = Data.test_register_credit_idCard;
			realName2 = Data.test_register_credit_realName;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.logout();
		base.tearDown();
	}
	
	/********************Ͷ���û�2*********************/
	/**
	 * ����Ԫ
	 * ��ҪͶ��-ע��-��ֵ-��ת������ֵ��ҳ��
	 */
	@Test
	public void register_AT_474(){
		Reporter.log("ɢ��Ͷ������-Ͷ����ע�᣺��ҪͶ��-ע��-��ֵ-��ת������ֵ��ҳ��<br/>");
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		System.out.println("ɢ��Ͷ������-Ͷ����ע��,��ʼ�ֻ���"+tel2+"  ���֤��"+idCard2+"  ������"+realName2);
		Reporter.log("��ʼ�ֻ���"+tel2+"  ���֤��"+idCard2+"  ������"+realName2);
		tel2 = registerPage.register("credit", tel2, password);
		//��֤ע��ɹ�
		registerPage.isRegisterOK();
		//���'ȥ��ֵ'
		registerPage.clickRecharge();
		//�ж��Ƿ���ת����ֵ����,����ʾ�����֤
		//rechargePage.closeInfo();
		rechargePage.isIdentityInfo();
		myAccountPage.isGoMyAccount("��ֵ");	
	}
	/**
	 * ����Ԫ
	 * ���Ƹ�����Ϣ
	 */
	@Test(dependsOnMethods="register_AT_474")
	public void setInfo_AT_477(){
		Reporter.log("ɢ��Ͷ�����̣����Ƹ�����Ϣ<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("��ֵ");
		String info[] = rechargePage.setInfo(realName2,idCard2,zzmm);
		realName2 = info[0];
		idCard2 = info[1];
		base.sleep(5000);
	}
	
	/**
	 * ����Ԫ
	 * ����֤���˻����޸�����
	 */
	@Test (dependsOnMethods="setInfo_AT_477")
	public void setEmailAccountInfo_AT_482(){
		Reporter.log("ɢ��Ͷ�����̣�����֤���˻����޸�����<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("�˻���Ϣ");
		accountInfoPage.updateEmailInfo(email2,realName2,idCard2);
		accountInfoPage.isUpdateOK("����ɹ�!");
	}
}
