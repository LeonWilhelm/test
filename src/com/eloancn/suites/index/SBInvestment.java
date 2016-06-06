package com.eloancn.suites.index;

import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.TotalPage;

public class SBInvestment {

	Base base = new Base();
	Data data = new Data();
	DBData dbData = new DBData();
	
	IndexPage indexPage = new IndexPage();
	InvestmentListPage investmentListPage = new InvestmentListPage();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		base.isTitle(PageTitles.shouYe);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test (priority = 1, enabled = true)
	public void checkSanBiaoHomeData_AT_5253(){
		
		Reporter.log("首页：散标投资——>校验1、最多显示3期数据   2、显示格式  3、数据与列表页一致<br/>");
		System.out.println("首页：散标投资——>校验1、最多显示3期数据   2、显示格式  3、数据与列表页一致");
		
		TotalPage.openPage("投资列表", false);
		List<String> sbTitleList = investmentListPage.getSBInvestmentDataStr("借款标题");
		List<String> sbLevelList = investmentListPage.getSBInvestmentDataStr("借款级别");
		List<String> sbMoneyList = investmentListPage.getSBInvestmentDataStr("借款金额");
		List<String> sbRateList = investmentListPage.getSBInvestmentDataStr("借款利率");
		List<String> sbPeriodsList = investmentListPage.getSBInvestmentDataStr("借款期限");
		TotalPage.openPage("首页", false);
		indexPage.checkProductTitleStyle("散标投资","text-align", "center");
		List<String> homeTitleList = indexPage.getSBDataStr("标题");
		indexPage.checkSBTableColumnName();
		indexPage.checkSBDataNum(homeTitleList);
		indexPage.checkSBData(sbTitleList, sbLevelList, sbMoneyList, sbRateList, sbPeriodsList);
	}

}
