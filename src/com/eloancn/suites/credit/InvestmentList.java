package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.DebentureTransferPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.TotalPage;

/**
 * 投资列表
 * @author 江渤洋
 */
public class InvestmentList {
	
	Base base = new Base();
	
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();	
	DebentureTransferPage debentureTransferPage = new DebentureTransferPage();
	InvestmentListPage investmentListPage = new InvestmentListPage();
	
	String name,pass,payPass,money;
	
	@BeforeClass
	public void setupBefore(){
		
		base.setup();
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			name = Data.tel_run_EcunBao;
    		pass = Data.password;
			payPass = Data.zzmm;
			money = "50";
		}
		else if(base.indexURL.contains("www") || base.indexURL.contains("test")){
			name = Data.test2_tel;
    		pass = Data.test2_password;
			payPass = Data.test2_zzmm;
			money = "50";
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * 用例名称：列表页_未登录
	 * 用例编号：SBTZ_017
	 * @author 江渤洋
	 */
	@Test (priority = 1)
	public void checkListPageLoginWindow_AT_510(){
		
		Reporter.log("散标投资流程:投资列表页面_未登录——>点击“快速投资”——>校验是否弹出“登录”窗口</br>");
		System.out.println("散标投资流程:投资列表页面_未登录——>点击“快速投资”——>校验是否弹出“登录”窗口");
		//跳转到“投资列表”页
		base.openBrowser(base.indexURL + "/new/loadAllTender.action");
		base.isTitle(PageTitles.touZiLieBiao);
		//如果“快速投资”按钮存在，则点击，并校验登录DIV是否显示
		investmentListPage.clickFastInvestBtn();
	}
	
	/**
	 * 用例名称：列表页
	 * 用例编号：SBTZ_016
	 * @author 江渤洋
	 */
	@Test (priority = 2)
	public void checkListPageData_AT_509(){
		
		Reporter.log("散标投资流程:投资列表页面_已登录——>1.检查首页、尾页最多显示10条数据；2.检查点击用户图片，跳转正确性；3.检查点击投资标题，跳转正确性</br>");
		System.out.println("散标投资流程:投资列表页面_已登录——>1.检查首页、尾页最多显示10条数据；2.检查点击用户图片，跳转正确性；3.检查点击投资标题，跳转正确性");

		TotalPage.openPage("投资列表", false);
		if(loginPage.ifLogin()){//登录
			base.logout();
		}
		loginPage.homeLogin(name, pass);
		TotalPage.openPage("投资列表", true);//跳转到“投资列表”页
		base.assertEqualsActualExpectedByBoolean(loginPage.isLogout(), false);
		//检查首页、尾页最多显示10条数据
		investmentListPage.checkMaxDisplay();
		//检查点击用户图片，跳转正确性
		investmentListPage.checkUserImgJumpList();
		//检查点击投资标题，跳转正确性
		investmentListPage.checkUserTitleList();
	}
	
	/**
	 * 用例名称：借款标详情页_页面显示及跳转
	 * 用例编号：SBTZ_019
	 * @author 江渤洋
	 */
	@Test (priority = 3)
	public void checkBorrowDetailsPageData_AT_512(){
		
		Reporter.log("散标投资流程:借款标详情页——>校验点击相关链接时，弹出或链接页面正确。1.点击借款详情页图片，跳转至信用评价页;2.点击详情，查看还款计划</br>");
		System.out.println("散标投资流程:借款标详情页——>校验点击相关链接时，弹出或链接页面正确。1.点击借款详情页图片，跳转至信用评价页;2.点击详情，查看还款计划");
		
//		TotalPage.openPage("投资列表", false);
//		if(loginPage.ifLogin()){//登录
//			base.logout();
//		}
//		loginPage.homeLogin(name, pass);
//		TotalPage.openPage("投资列表", true);//跳转到“投资列表”页
//		base.assertEqualsActualExpectedByBoolean(loginPage.isLogout(), false);
		//校验“借款标详情”页
		investmentListPage.checkDetailsInfoLinks();
	}
	
	/**
	 * 用例名称：投资窗口_投资
	 * 用例编号：SBTZ_018
	 * @author 江渤洋
	 */
	@Test (priority = 4)
	public void checkInvestmentWindow_AT_511(){
		
		Reporter.log("散标投资流程:投资列表页面——>点击“快速投资”——>验证投资是否成功</br>");
		System.out.println("散标投资流程:投资列表页面——>点击“快速投资”——>验证投资是否成功");
		
		TotalPage.openPage("投资列表", false);
		if(loginPage.ifLogin()){//登录
			base.logout();
		}
		loginPage.homeLogin(name, pass);
		TotalPage.openPage("投资列表", true);//跳转到“投资列表”页
		base.assertEqualsActualExpectedByBoolean(loginPage.isLogout(), false);
		
		if(money.equals("50")){
			//校验“快速投资”按钮，进行投资
			investmentListPage.checkFastInvest(money, payPass);
		}
	}
	
	/**
	 * 用例名称：借款标详情页_投资
	 * 用例编号：SBTZ_020
	 * @author 江渤洋
	 */
	@Test (priority = 5)
	public void checkBorrowDetailsPageInvestment_AT_513(){
		
		Reporter.log("散标投资流程:借款标详情页——>点击“借钱给他”——>验证投资是否成功");
		System.out.println("散标投资流程:借款标详情页——>点击“借钱给他”——>验证投资是否成功");
		/*
		//重新登录
		//loginPage.reLogin();
		//跳转到“投资列表”页
		//indexPage.clickInvestmentListLink();
		//校验“借钱给他”按钮，进行投资
		 */
		if(money.equals("50")){
			investmentListPage.checkBorrowMoney(money, payPass);
		}
	}
	
	@Test (priority = 6)
	public void checkReserveBidJump_AT_5251(){
		
		Reporter.log("散标投资列表，点击“预约投标”按钮，查看跳转是否成功</br>");
		System.out.println("散标投资列表，点击“预约投标”按钮，查看跳转是否成功");
		
		base.openBrowser(base.indexURL + "/new/loadAllTender.action");
		base.isTitle(PageTitles.touZiLieBiao);
		investmentListPage.clickReserveBidBtn();
	}
}

