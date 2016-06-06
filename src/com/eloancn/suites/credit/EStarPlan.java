package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.*;
import com.eloancn.shared.pages.*;
/*
 * “翼星计划”页面用例-刘京
 */
public class EStarPlan {
	
	Base base = new Base();
	IndexPage indexpage = new IndexPage();
	LoginPage loginpage = new LoginPage();
	EStarPlanListPage ListPage = new EStarPlanListPage();
	EStarDetailPage DetailPage = new EStarDetailPage();
	CreditReferrerDetailPage ReferrerPage = new CreditReferrerDetailPage();
	String EStarPlanUrl = base.indexURL+"/wut/loadAllWutRecords.action";
	private String MemberBPayPwd;

	@BeforeClass
	public void setupBefore(){
		
		base.setup();
		base.openBrowser(EStarPlanUrl);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(priority = 1) 
	//检查“翼星计划”列表页数据和链接
	public void verifyListData_AT_547(){
		Reporter.log("翼星计划列表页-检查数据和链接");
		ListPage.verifyYXPlanPagination();
		ListPage.verifyDataLnk();
	}
	
	@Test(priority = 2)
	//检查未登录的“快速投资”链接
	public void FastInvestLnkinList_AT_548(){
		Reporter.log("翼星计划列表页-检查未登录的 快速投资 链接");
		if(ListPage.ifshowInvestNowLnk()){
			ListPage.clickFastInvestLnk();
			ListPage.clickCloseLoginLnk();
		}else{
			System.out.println("翼星计划列表页没有可投资的产品！");
			Reporter.log("<br/>翼星计划列表页没有可投资的产品！");
		}
	}
	
	@Test(priority = 3)
	//检查翼星计划详情页
	public void verifyDatainDetailPage_AT_555(){
		Reporter.log("翼星计划详情页-检查数据和链接");
		if(ListPage.ifshowEStarPlan()){
			ListPage.clickFirstEStarTitle();
			DetailPage.verifyEStarDetail();
		}else{
			System.out.println("翼星计划列表页没有产品！");
			Reporter.log("<br/>翼星计划列表页没有产品！");
		}
	}
	
	@Test(priority = 4)
	//检查翼星计划详情页未登录的“快速投资”链接
	public void FastInvestLnkinDetail_AT_559(){
		Reporter.log("翼星计划详情页-检查未登录的 快速投资 链接");		
		if(ListPage.ifshowInvestNowLnk()){
			ListPage.clickEStarTitleforInvest();
			DetailPage.clickFastInvestLnk();
			base.closeAndjumptoOldWindow();
		}else{
			System.out.println("翼星计划详情页没有可投资的产品！");
			Reporter.log("<br/>翼星计划详情页没有可投资的产品！");
		}
	}
	
	@Test(priority = 5)
	//检查翼星计划推荐人详情页
	public void verifyReferrerDetailPage_AT_562(){
		Reporter.log("翼星计划推荐人详情页-检查数据和链接");
		if(ListPage.ifshowEStarPlan()){
			ListPage.clickFirstEStarTitle();
			DetailPage.clickCreditReferrerLnk();
			DetailPage.clickReferrerAddressLnk();
			ReferrerPage.verifyReferrerDetailPage();
		}else{
			System.out.println("翼星计划列表页没有产品！");
			Reporter.log("<br/>翼星计划列表页没有产品！");
		}
	}
	
	@Test(priority = 6)
	//检查未登录的翼星计划推荐人详情页的图片
	public void NoQualifiedPhoto_AT_563(){
		Reporter.log("翼星计划推荐人详情页-检查未登录时不显示图片");
		if(ReferrerPage.ifinReferrerPage()){
			base.assertTrueByBoolean(!base.isElementPresent(CreditReferrerDetailPage.QualifiedPhoto));	
		}else{
			base.openBrowser(EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.clickCreditReferrerLnk();
				DetailPage.clickReferrerAddressLnk();
				base.checkNoElement(CreditReferrerDetailPage.QualifiedPhoto);
				base.closeWebDriver();
			}else{
				System.out.println("翼星计划列表页没有产品！");
				Reporter.log("<br/>翼星计划列表页没有产品！");
			}
		}
	}
	
	@Test(priority = 7)
	//检查已登录的翼星计划推荐人详情页的图片
	public void ShowQualifiedPhoto_AT_564(){
		Reporter.log("翼星计划推荐人详情页-检查已登录时显示图片");
		loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		if(ReferrerPage.ifinReferrerPage()){
			base.checkElement(CreditReferrerDetailPage.QualifiedPhoto);	
		}else{
			base.openBrowser(EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.clickCreditReferrerLnk();
				DetailPage.clickReferrerAddressLnk();
				base.assertTrueByBoolean(base.isElementPresentNoWait(CreditReferrerDetailPage.QualifiedPhoto));
				base.closeWebDriver();
			}else{
				System.out.println("翼星计划列表页没有产品！");
				Reporter.log("<br/>翼星计划列表页没有产品！");
			}
		}
	}
	
	@Test(priority = 8)
	//检查首次投资列表页收益星
	public void FirstInvestSYStarinList_AT_737(){
		Reporter.log("翼星计划列表页-检查首次投资收益星");
		loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		base.openBrowser(EStarPlanUrl);
		if(ListPage.ifshowSYStarInvestNowLnk()){
			ListPage.clickSYStarInvestNowLnk();	
			if(ListPage.ifFirstInvest()){
				ListPage.clickDenyBtn();
				ListPage.clickSYStarInvestNowLnk();				
				ListPage.clickAgreeBtn();
				ListPage.clickSYStarCancelBtn();		
			}else{
				ListPage.clickSYStarCancelBtn();
				System.out.println("非首次投资列表页收益星！");
				Reporter.log("<br/>非首次投资列表页收益星！");
			}
		}else{
			System.out.println("翼星计划列表页没有可投资的收益星！所以首次投资不能验证！");
			Reporter.log("<br/>翼星计划列表页没有可投资的收益星！所以首次投资不能验证！");
		}
	}
	
	@Test(priority = 9)
	//检查首次投资详情页收益星
	public void FirstInvestSYStarinDetail_AT_738(){
		Reporter.log("翼星计划详情页-检查首次投资收益星");
		if(ListPage.ifshowSYStarInvestNowLnk()){
			ListPage.clickTitleforInvestSYStar();
			DetailPage.clickSYStarInvestNowLnk();
			if(ListPage.ifFirstInvest()){
				DetailPage.clickDenyBtn();
				DetailPage.clickSYStarInvestNowLnk();
				DetailPage.clickAgreeBtn();
			}else{
				System.out.println("非首次投资详情页收益星！");
				Reporter.log("<br/>非首次投资详情页收益星！");
			}	
			base.closeAndjumptoOldWindow();
		}else{
			System.out.println("翼星计划详情页没有可投资的收益星！所以首次投资不能验证！");
			Reporter.log("<br/>翼星计划详情页没有可投资的收益星！所以首次投资不能验证！");
		}	
	}

	@Test(priority = 10)
	//检查成功投资列表页保障星
	public void InvestBZStarinList_AT_549(){
		Reporter.log("翼星计划列表页-检查投资保障星成功");
		MemberBPayPwd=loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		if(ListPage.ifshowBZStarInvestNowLnk()){
			ListPage.clickBZStarInvestNowLnk();
 			if(ListPage.BZStarCompareAmount()){
 				ListPage.InputInvestAmount();
				ListPage.InputPayPwd(MemberBPayPwd);
				ListPage.InputValidateCode();
				ListPage.CheckAgreeDeal();
				ListPage.clickBZStarOkBtn();
				ListPage.CheckInvestSuccess();
			}else{
				System.out.println("余额不足！");
				Reporter.log("余额不足！");
			}
		}else{
			System.out.println("翼星计划列表页没有可投资的保障星！");
			Reporter.log("<br/>翼星计划列表页没有可投资的保障星！");
		}
	}
	
	@Test(priority = 11)
	//检查详情页保障星的自动输入
	public void AutoInputinBZStarDetail_AT_560(){
		Reporter.log("翼星计划详情页-检查保障星的自动输入");
		if(ListPage.ifshowBZStarInvestNowLnk()){
			ListPage.clickTitleforInvestBZStar();
			DetailPage.clickBZStarInvestNowLnk();
			DetailPage.clickAutoInputBZStarLnk();
			DetailPage.checkBZStarAutoInput();
		}else{
			System.out.println("翼星计划详情页没有可投资的保障星！");
			Reporter.log("<br/>翼星计划详情页没有可投资的保障星！");
		}
	}
	
	@Test(priority = 12)
	//检查详情页收益星的自动输入
	public void AutoInputinSYStarDetail_AT_561(){
		Reporter.log("翼星计划详情页-检查收益星的自动输入");
		base.openBrowser(EStarPlanUrl);
		if(ListPage.ifshowSYStarInvestNowLnk()){
			ListPage.clickTitleforInvestSYStar();
			DetailPage.clickSYStarInvestNowLnk();
			if(ListPage.ifFirstInvest()){
				DetailPage.clickAgreeBtn();
			}
			DetailPage.clickAutoInputSYStarLnk();
			DetailPage.checkSYStarAutoInput();
		}else{
			System.out.println("翼星计划详情页没有可投资的收益星！");
			Reporter.log("<br/>翼星计划详情页没有可投资的收益星！");
		}	
	}

}


