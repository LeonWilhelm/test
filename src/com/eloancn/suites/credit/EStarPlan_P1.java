package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyDebitPlan;

/**
 * �����Ǽƻ���P1����
 * @author ������ 
 */
public class EStarPlan_P1 {
	
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	IndexPage indexPage = new IndexPage();
	MyDebitPlan myDebitPlan = new MyDebitPlan();
	
	String EStarPlanByMyAccountURL = base.indexURL + "/page/userMgr/myHome.jsp";
	String name = "";//Data.tel_run_MyAccount;//"lzyadam@sohu.com";//--------��־Զ�˻������ݣ���Ҫ�޸�
	String pass = "";
	
	String name_client = "lzyadam@sohu.com";
	String pass_client = Data.zzmm;
	String name_test = Data.test2_tel;
	String pass_test = Data.test2_password;
	
	@BeforeClass
	public void setupBefore(){
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			name = name_client;
			pass = pass_client;
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			name = name_test;
			pass = pass_test;
		}
		
		base.setup();
		base.openBrowser(base.indexURL);
		base.sleep(2000);
		indexPage.clickLoginLink();
		try {
			loginPage.login(name, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * ����һ���Ի��幦�ܼ��䴰����ع���
	 * @author ������  2015-7-21
	 */
	@Test(priority = 1)
	public void checkLoanList_web_418(){
		
		Reporter.log("�ҵ��˻�_P1���ҵ��˻���>���Ǽƻ���>�ҵĽ���ƻ���>����һ���Ի��幦�ܼ��䴰����ع���");
		Reporter.log("1.У�顰һ���Ի��塱���ӣ�2.У�顰��Ҫ��ֵ�����ӣ�3.У�顰����˻����������ʽ���Լ���Ӧ������ʾ�Ƿ���ȷ��4.У��رա�����ȷ�ϡ����ں�ԭ���ڻ����б�");
		System.out.println("�ҵ��˻�_P1���ҵ��˻���>���Ǽƻ���>�ҵĽ���ƻ���>����һ���Ի��幦�ܼ��䴰����ع���");
		//�����ҵ��˻�ҳ��
		base.openBrowser(EStarPlanByMyAccountURL);
		base.sleep(5000);
		//��ȡ��������
		String numberinAvailableBalanceStr = myAccountPage.getNumberinAvailableBalance();
		//���롰�ҵĽ���ƻ���
		myAccountPage.turnToMyAccount("�ҵĽ���ƻ�");
		base.sleep(2000);
		//�ж��Ƿ���롰�ҵĽ���ƻ���
		myAccountPage.isGoMyAccount("�ҵĽ���ƻ�");	
		//�жϡ����ڻ���Ľ��Ƿ�ѡ��
		myDebitPlan.isRepayingTabSelected();
		//��֤һ���Ի��幦�ܼ��䴰����ع���
		myDebitPlan.checkLoanList(numberinAvailableBalanceStr);
	}
}