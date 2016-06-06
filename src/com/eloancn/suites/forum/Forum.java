package com.eloancn.suites.forum;

import org.testng.Reporter;
import org.testng.annotations.*;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ForumPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.until.CssUtils;

/*
 * “论坛”用例
 */
public class Forum {
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	ForumPage forumPage = new ForumPage();
	LoginPage loginPage = new LoginPage();
	
	public String username = Data.tel_run_debit2;//Data.tel Data.email //1112@126.com  //现网："ff@qq.com"  13111111112
	public String password = Data.password;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			username = Data.test_tel;//Data.email  18880000200
			password = Data.test_password;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**********未登录，各页面链接至论坛,并显示未登录状态（徐天元）**********/
	@Test(priority = 1)
	public void creditLinkToForum_AT_593_594(){
		Reporter.log("论坛：未登录，我要贷出页面链接至论坛,并显示未登录状态<br/>");
		indexPage.linkToForum("我要贷出");
		forumPage.isForum();
		loginPage.isForumNotLogin();
		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("翼存宝");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("翼星计划");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("投资列表");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("如何贷出");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("工具箱");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
	}
	
//	@Test(priority = 2)
//	public void debitLinkToForum_AT_593_594(){
//	    Reporter.log("论坛：未登录，各页面链接至论坛,并显示未登录状态");
//		indexPage.linkToForum("我要借入");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("申请借入");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("如何借入");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("公益贷");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//	}
//	
//	@Test(priority = 3)
//	public void noviceAreaLinkToForum_AT_593_594(){
//      Reporter.log("论坛：未登录，各页面链接至论坛,并显示未登录状态");
//		indexPage.linkToForum("新手专区");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//	    forumPage.closeForumTrunBeforePage();
//	}
//	
//	@Test(priority = 4)
//	public void debentureTransferLinkToForum_AT_593_594(){
//      Reporter.log("论坛：未登录，各页面链接至论坛,并显示未登录状态");
//		indexPage.linkToForum("债权转让");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//	    forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("转让列表");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("如何转让");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//	}
//	
	@Test(priority = 2)
	public void aboutUsLinkToForum_AT_593_594(){
	    Reporter.log("论坛：未登录，关于我们页面链接至论坛,并显示未登录状态<br/>");
		base.openBrowser(base.indexURL);
		indexPage.linkToForum("关于我们");
		forumPage.isForum();
		loginPage.isForumNotLogin();
		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("公司介绍");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("领导介绍");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("公司理念");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("招贤纳士");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
////		indexPage.linkToForum("联系我们");
////		forumPage.isForum();
////		loginPage.isNotLogin();
////		forumPage.closeForumTrunBeforePage();
	}
	
	/***未登录，论坛页点击“首页/翼龙贷logo”，跳转至“翼龙贷”首页，显示为未登录状态（徐天元）***/
	@Test(priority = 3)
	public void notLoginClicklogo_AT_687(){
		Reporter.log("论坛：未登录，论坛页点击“首页/翼龙贷logo”，跳转至“翼龙贷”首页，显示为未登录状态<br/>");
		base.openBrowser("http://bbs.eloancn.com/");
		//点击logo
		forumPage.clickLogo();
		//验证跳转至“翼龙贷”首页
		indexPage.isturnToIndexPage();
		//显示为未登录状态
		loginPage.isNotLogin();
	}
	
	/***登录，论坛页点击“首页/翼龙贷logo”，跳转至“翼龙贷”首页，显示为登录状态（徐天元）***/
	@Test(priority = 4)
	public void loginClicklogo_AT_688(){
		Reporter.log("论坛：登录，论坛页点击“首页/翼龙贷logo”，跳转至“翼龙贷”首页，显示为登录状态<br/>");
//		base.openBrowser(base.indexURL);
//		//点击“登录”
//		indexPage.clickLoginLink();
//		//登录
//		loginPage.login(username, password);
		if (base.indexURL.contains("www")) {
			username = Data.test_tel;//Data.email  18880000200
			password = Data.test_password;
			base.openBrowser("http://bbs.eloancn.com/");
			forumPage.forumClickLogin();
			loginPage.loginWithNoFrame(username, password);
			//验证登录是否成功
			loginPage.isForumLoginOK();
			//进入论坛页，点击logo
			forumPage.clickLogo();
			//验证跳转至“翼龙贷”首页
			indexPage.isturnToIndexPage();
			//点击登录
			indexPage.clickLoginLink();
			//显示为登录状态
			base.sleep(10000);
			loginPage.isLoginOK();
			//退出
			base.logout();
		}else {
			Reporter.log(CssUtils.red("仅现网能测，其余环境无法测试"));
		}
	}
	
	/**********登录状态，翼龙贷各页面点击“论坛”,跳转至“论坛”首页面，显示为登录状态（徐天元）**********/
	@Test(priority = 5)
	public void loginLinkToForum_AT_595(){
		Reporter.log("论坛:登录状态，翼龙贷各页面点击“论坛”,跳转至“论坛”首页面，显示为登录状态<br/>");
//		//点击“登录”
//		indexPage.clickLoginLink();
//		//登录
//		loginPage.login(username, password);
		if (base.indexURL.contains("www")) {
			username = Data.test_tel;//Data.email  18880000200
			password = Data.test_password;
			base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(username, password);
			//验证登录是否成功
			loginPage.isLoginOK();
	//		indexPage.linkToForum("我要贷出");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("翼存宝");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
			indexPage.linkToForum("翼星计划");
			forumPage.isForum();
			loginPage.isForumLoginOK();
			forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("投资列表");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("如何贷出");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("工具箱");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		
	//		indexPage.linkToForum("我要借入");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("申请借入");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("如何借入");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("公益贷");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
			
			indexPage.linkToForum("新手专区");
			forumPage.isForum();
			loginPage.isForumLoginOK();
			forumPage.closeForumTrunBeforePage();
			
	//		indexPage.linkToForum("债权转让");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("转让列表");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("如何转让");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		
	//		indexPage.linkToForum("关于我们");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("公司介绍");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("领导介绍");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("公司理念");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("招贤纳士");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("联系我们");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
			//base.logout();
		}else {
			Reporter.log(CssUtils.red("仅现网能测，其余环境无法测试"));
		}
	}
}
