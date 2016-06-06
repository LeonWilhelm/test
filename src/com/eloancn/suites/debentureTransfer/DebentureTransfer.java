package com.eloancn.suites.debentureTransfer;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.DebentureTransferPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;

/*
 * “散标投资新手专区”用例
 */
public class DebentureTransfer {
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	DebentureTransferPage debentureTransferPage = new DebentureTransferPage();
	
	//public String usname = "13111111150";//Data.email  ff@qq.com
	public String tel = Data.tel;		//随机手机号
	String password = Data.password;
	String zzmm = Data.zzmm;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL+"/new/loadNewUserTender.action");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_tel;
			password = Data.test_password;
			zzmm = Data.test_zzmm;
		}else {
			tel = Data.tel_run_DebentureTransfer;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * 徐天元
	 * 校验新手专区-投资列表最多显示10条数据
	 */
	@Test (priority = 1)
	public void verifyDataSize_AT_505(){
		Reporter.log("投资流程-新手专区：列表页，每页最多显示10条借款标数据信息<br/>");
		//indexPage.clickMenu("新手专区");
		debentureTransferPage.isInvestDataSizeOK();
	}
	
	
	/**
	 * 徐天元
	 * 点击“快速投资”，弹出登录
	 * 2015-7-20    江渤洋，添加checkLoginTitle()方法
	 */
	@Test (priority = 2)
	public void fastInvestLogin_AT_499(){
		Reporter.log("投资流程-新手专区：列表页，用户未登录，点击“快速投资”，弹出登录<br/>");
		//是否有“快速投资按钮”
		if (base.indexURL.contains("client")) {
			if (!debentureTransferPage.ifHaveFastInvestBtn()) {//没有新手标就先创建
				debentureTransferPage.makeNewUserBid();
				base.logout();
			}
			fastInvestLogin();
		}else {
			if (debentureTransferPage.ifHaveFastInvestBtn()) {
				fastInvestLogin();
			}
		}
	}
	
	public void fastInvestLogin(){
		//点击“快读投资”
		debentureTransferPage.clickFastInvest();
		//判断是否弹出登录窗口
		indexPage.checkLoginTitle();
		//关闭登录窗口
		debentureTransferPage.closeLogin();
	}
	
	/**
	 * 徐天元
	 * 校验投资列表各链接是否正确
	 */
	@Test (priority = 3)
	public void verifyDataLinks_AT_505(){
		Reporter.log("投资流程-新手专区：列表页，点击相关链接时，弹出或链接页面正确<br/>");
		base.openBrowser(base.indexURL+"/new/loadNewUserTender.action");
		//点击“登录”
		indexPage.clickLoginLink();
		//登录
		loginPage.login(tel, password);//1112@126.com  //现网："ff@qq.com"
		//验证登录是否成功
		loginPage.isLoginOK();
		//校验投资列表各链接是否正确
		debentureTransferPage.isInvestDataLinkOK();
	}
	
	/**
	 * 徐天元
	 * 详情页各链接正常
	 */
	@Test (priority = 4)
	public void verifyDetailsLinks_AT_507(){
		Reporter.log("投资流程-新手专区：借款标详情页，点击相关链接时，弹出或链接页面正确<br/>");
		base.openBrowser(base.indexURL+"/new/loadNewUserTender.action");
		if (!loginPage.ifLogin()) {
			//点击“登录”
			indexPage.clickLoginLink();
			//登录
			loginPage.login(tel, password);//1112@126.com  //现网："ff@qq.com"
			//验证登录是否成功
			loginPage.isLoginOK();
		}
		debentureTransferPage.verifyDetailsInfoLinks();
	}
	
	/**
	 * 徐天元
	 * “快速投资”
	 */
	@Test (priority = 5)
	public void fastInvest_AT_500(){
		Reporter.log("投资流程-新手专区：列表页，点击“快速投资”，提示投资成功<br/>");
		base.openBrowser(base.indexURL+"/new/loadNewUserTender.action");
		//是否有“快速投资按钮”
		if (base.indexURL.contains("client")) {
			if (!debentureTransferPage.ifHaveFastInvestBtn()) {//没有新手标就先创建
				debentureTransferPage.makeNewUserBid();
				base.logout();
				//点击“登录”
				indexPage.clickLoginLink();
				//登录
				loginPage.login(tel, password);
			}
			fastInvest();
		}else {
			if (debentureTransferPage.ifHaveFastInvestBtn()) {
				fastInvest();
			}
		}
	}

	public void fastInvest(){
		if (!loginPage.ifLogin()) {
			//点击“登录”
			indexPage.clickLoginLink();
			//登录
			loginPage.login(tel, password);//1112@126.com  //现网："ff@qq.com"
			//验证登录是否成功
			loginPage.isLoginOK();
		}
		debentureTransferPage.clickFastInvest();
		//投资
		debentureTransferPage.fastInvest("50",zzmm);
		//校验是否投资成功
		if (!debentureTransferPage.isFastInvestOK()) {
			if (debentureTransferPage.ifHaveFastInvestBtn()) {
				debentureTransferPage.clickFastInvest();
				//投资
				debentureTransferPage.fastInvest("50",zzmm);
				if (!debentureTransferPage.isFastInvestOK()) {
					Reporter.log("验证码输入有误，请重新输入！");
					Assert.assertTrue(false);
				}
			}
		}
	}
	
	/**
	 * 徐天元
	 * 详情页 “借钱给他”
	 */
	@Test (priority = 6)
	public void detailsFastInvest_AT_504(){
		Reporter.log("投资流程-新手专区：借款标详情页，点击“借钱给他”，提示投资成功<br/>");
		base.openBrowser(base.indexURL+"/new/loadNewUserTender.action");
		//是否有“快速投资”按钮
		if (base.indexURL.contains("client")) {
			if (!debentureTransferPage.ifHaveFastInvestBtn()) {//没有新手标就先创建
				debentureTransferPage.makeNewUserBid();
				base.logout();
				//点击“登录”
				indexPage.clickLoginLink();
				//登录
				loginPage.login(tel, password);//1112@126.com  //现网："ff@qq.com"
			}
			detailFastInvest();
		}else {
			if (debentureTransferPage.ifHaveFastInvestBtn()) {
				detailFastInvest();
			}
		}
	}
	
	public void detailFastInvest(){
		if (!loginPage.ifLogin()) {
			//点击“登录”
			indexPage.clickLoginLink();
			//登录
			loginPage.login(tel, password);//1112@126.com  //现网："ff@qq.com"
			//验证登录是否成功
			loginPage.isLoginOK();
		}
		//详情页 “借钱给他”
		if (!debentureTransferPage.detailsFastInvest("50",zzmm,tel,password)) {
			if (debentureTransferPage.ifHaveFastInvestBtn()) {
				if (!debentureTransferPage.detailsFastInvest("50",zzmm,tel,password)){
					Reporter.log("验证码输入有误，请重新输入！");
					Assert.assertTrue(false);
				}
			}
		}
	}
}
