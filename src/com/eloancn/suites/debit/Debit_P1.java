package com.eloancn.suites.debit;

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
import com.eloancn.shared.pages.MyLoanPage;

/**
 * ����ǰ�������ֱ���P1����
 * @author ������ 
 *��ʱ�����ԣ���Ϊû�С����ڻ���Ľ�ʱ�޷����ԣ����ⶨʱ����
 */
public class Debit_P1 {

	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	MyLoanPage myLoanPage = new MyLoanPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	MyDebitPlan myDebitPlan = new MyDebitPlan();
	
//	String name = "chr12@t01.com";//Data.tel_run_MyAccount; //"chr12@t01.com";���˻�������
//	String pass = Data.zzmm;
	String name=Data.tel_Loan;
	String pass=Data.password;
	
	@BeforeClass
	public void setupBefore(){
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
	 * ����ɹ���ı仯
	 */
	@Test(priority = 1)
	public void checkRepaymentChanges_web_908(){
		Reporter.log("�ҵ��˻�_P1:�ҵ��˻�����>�ҵĽ��롪>�ҵĽ�>У�黹��ɹ���ı仯<br/>");
		Reporter.log("1.У�黹���б�2.У�齻�׼�¼��3.У��վ����<br/>");
		System.out.println("�ҵ��˻�_P1:�ҵ��˻�����>�ҵĽ��롪>�ҵĽ�>У�黹��ɹ���ı仯");
		if(base.indexURL.contains("client")){
			base.openBrowser(myAccountPage.MyAccountUrl);
			base.sleep(2000);
			//���롰�ҵĽ�
			myAccountPage.clickMyDebtLnk();
			//�жϡ����ڻ���Ľ��Ƿ�ѡ��
			myDebitPlan.isRepayingTabSelected();
			//��֤����ɹ���ı仯
			myLoanPage.checkRepaymentChanges();
			base.sleep(2000);
			base.openBrowser(myAccountPage.MyAccountUrl);
		}
	}
}