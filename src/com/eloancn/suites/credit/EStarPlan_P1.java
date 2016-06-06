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
 * “翼星计划”P1用例
 * @author 江渤洋 
 */
public class EStarPlan_P1 {
	
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	IndexPage indexPage = new IndexPage();
	MyDebitPlan myDebitPlan = new MyDebitPlan();
	
	String EStarPlanByMyAccountURL = base.indexURL + "/page/userMgr/myHome.jsp";
	String name = "";//Data.tel_run_MyAccount;//"lzyadam@sohu.com";//--------李志远账户有数据，需要修改
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
	 * 测试一次性还清功能及其窗口相关功能
	 * @author 江渤洋  2015-7-21
	 */
	@Test(priority = 1)
	public void checkLoanList_web_418(){
		
		Reporter.log("我的账户_P1：我的账户—>翼星计划—>我的借入计划—>测试一次性还清功能及其窗口相关功能");
		Reporter.log("1.校验“一次性还清”链接；2.校验“我要充值”链接；3.校验“检查账户余额”、“还款方式”以及“应还金额”显示是否正确；4.校验关闭“还款确认”窗口后，原借款还在还款列表");
		System.out.println("我的账户_P1：我的账户—>翼星计划—>我的借入计划—>测试一次性还清功能及其窗口相关功能");
		//进入我的账户页面
		base.openBrowser(EStarPlanByMyAccountURL);
		base.sleep(5000);
		//获取“可用余额”
		String numberinAvailableBalanceStr = myAccountPage.getNumberinAvailableBalance();
		//进入“我的借入计划”
		myAccountPage.turnToMyAccount("我的借入计划");
		base.sleep(2000);
		//判断是否进入“我的借入计划”
		myAccountPage.isGoMyAccount("我的借入计划");	
		//判断“正在还款的借款”是否被选中
		myDebitPlan.isRepayingTabSelected();
		//验证一次性还清功能及其窗口相关功能
		myDebitPlan.checkLoanList(numberinAvailableBalanceStr);
	}
}