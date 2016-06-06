package com.eloancn.suites.index;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.pages.IndexPage;


/*
 * “首页收益计算器”-江渤洋
 */
public class IncomeCalculator {

	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * 用例名称：收益计算器
	 * 用例编号：SY_004
	 * @author 江渤洋
	 */
	@Test
	public void checkIncomeCalculator_AT_588(){
		Reporter.log("首页：收益计算器——>点击“收益计算器”按钮——>1.校验弹出窗口；2.计算数据显示正常，有滚动条可下拉查看数据");
		//投资金额
		String InvestmentMoney = "1000";
		//年利率
		String annualInterestRate = "20";
		//投资期限
		String investmentPeriod = "24";
		//还款方式
		String repaymentDrop = "还本付息";
		
		//点击“收益计算器”按钮
		indexPage.clickIncomeCalculatorBtn();
		//校验弹出窗口
		base.assertNotNullBy(By.xpath("//div[@class='count-tit']//h3"));
		//输入“投资金额”
		indexPage.sendKeyInvestmentMoneyTxt(InvestmentMoney);
		//输入“年利率”
		indexPage.sendKeyAnnualInterestRateTxt(annualInterestRate);
		//输入“投资期限”
		indexPage.sendKeyInvestmentPeriodTxt(investmentPeriod);
		//选择“还款方式”
		base.elementSelectByVisibleText(By.xpath("//select[@name='type']"), repaymentDrop);
		//勾选“显示计划时间表”
		indexPage.clickShowScheduleChk();
		//点击“马上计算”按钮
		indexPage.clickImmediatelyCalculateBtn();
		base.sleep(1000);
		//拖动滚动条
		base.setDivScrollById("tiemst", 10000);
		base.sleep(2000);
		//检查最后一条数据
		base.assertEqualsActualExpectedByBoolean(indexPage.checkReceivablesListData(InvestmentMoney, annualInterestRate, investmentPeriod, repaymentDrop), true);
	}
}
