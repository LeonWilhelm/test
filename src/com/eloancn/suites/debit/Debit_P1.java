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
 * “提前偿还部分本金”P1用例
 * @author 江渤洋 
 *暂时不测试，因为没有“正在还款的借款”时无法测试，另外定时任务
 */
public class Debit_P1 {

	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	MyLoanPage myLoanPage = new MyLoanPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	MyDebitPlan myDebitPlan = new MyDebitPlan();
	
//	String name = "chr12@t01.com";//Data.tel_run_MyAccount; //"chr12@t01.com";此账户有数据
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
	 * 还款成功后的变化
	 */
	@Test(priority = 1)
	public void checkRepaymentChanges_web_908(){
		Reporter.log("我的账户_P1:我的账户——>我的借入—>我的借款—>校验还款成功后的变化<br/>");
		Reporter.log("1.校验还款列表；2.校验交易记录；3.校验站内信<br/>");
		System.out.println("我的账户_P1:我的账户——>我的借入—>我的借款—>校验还款成功后的变化");
		if(base.indexURL.contains("client")){
			base.openBrowser(myAccountPage.MyAccountUrl);
			base.sleep(2000);
			//进入“我的借款”
			myAccountPage.clickMyDebtLnk();
			//判断“正在还款的借款”是否被选中
			myDebitPlan.isRepayingTabSelected();
			//验证还款成功后的变化
			myLoanPage.checkRepaymentChanges();
			base.sleep(2000);
			base.openBrowser(myAccountPage.MyAccountUrl);
		}
	}
}