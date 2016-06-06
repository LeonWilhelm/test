package com.eloancn.suites.credit;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.pages.EStarPlanListPage;
/**
 * 翼星计划P2_2 
 * @author 徐天元
 */
public class EStarPlan_P2_2 {
	Base base = new Base();
	EStarPlanListPage eStarPlanListPage = new EStarPlanListPage();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/*****************************收益计算器*****************************/
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 计息时间,点击计息时间,校验弹出日历框
	 */
	@Test(priority = 1)
	public void showDateWindow_web_516(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器-计息时间,点击计息时间,校验弹出日历框<br/>");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//点击计息时间
		eStarPlanListPage.clickDate();
		//校验弹出日历框
		eStarPlanListPage.showDate();
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 投资金额,输入：10000（数字）,没有错误提示
	 */
	@Test(priority = 2)
	public void inputRriteMoney_web_517_1(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器--投资金额,输入：10000（数字）,没有错误提示<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入金额10000
		eStarPlanListPage.inputMoney("10000");
		//输入利率
		eStarPlanListPage.inputLoanRate("11");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases("1");
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//校验正常输入计算器内容，无提示，显示计算结果
		eStarPlanListPage.isCalculateNoAlert();
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 投资金额,输入：6541dddd,提示“投资金额不正确”
	 */
	@Test(priority = 3)
	public void inputWrongMoney_web_517_2(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器--投资金额,输入：6541dddd,提示“投资金额不正确”<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入金额10000
		eStarPlanListPage.inputMoney("6541dddd");
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//校验提示“投资金额不正确”
		base.checkAlertText("投资金额不正确！");
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 投资期限,输入：1个月（最小值）,没有错误提示
	 */
	@Test(priority = 4)
	public void inputLoanPhases_web_519_1(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器--投资期限,输入：1个月（最小值）,没有错误提示<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入金额10000
		eStarPlanListPage.inputMoney("10000");
		//输入利率
		eStarPlanListPage.inputLoanRate("11");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases("1");
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//校验正常输入计算器内容，无提示，显示计算结果
		eStarPlanListPage.isCalculateNoAlert();
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 投资期限,输入：12个月（中间值）,没有错误提示
	 */
	@Test(priority = 5)
	public void inputLoanPhases_web_519_2(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器--投资期限,输入：12个月（中间值）,没有错误提示<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入金额10000
		eStarPlanListPage.inputMoney("10000");
		//输入利率
		eStarPlanListPage.inputLoanRate("11");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases("12");
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//校验正常输入计算器内容，无提示，显示计算结果
		eStarPlanListPage.isCalculateNoAlert();
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 投资期限,输入：24个月,没有错误提示
	 */
	@Test(priority = 6)
	public void inputLoanPhases_web_519_3(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器--投资期限,输入：12个月（中间值）,没有错误提示<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入金额10000
		eStarPlanListPage.inputMoney("10000");
		//输入利率
		eStarPlanListPage.inputLoanRate("11");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases("24");
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//校验正常输入计算器内容，无提示，显示计算结果
		eStarPlanListPage.isCalculateNoAlert();
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 投资期限,输入：3.5个月（非整数）,提示：借款期限不正确！
	 */
	@Test(priority = 7)
	public void inputLoanPhases_web_519_4(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器--投资期限,输入：3.5个月（非整数）,提示：借款期限不正确！<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入金额10000
		eStarPlanListPage.inputMoney("10000");
		//输入利率
		eStarPlanListPage.inputLoanRate("11");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases("3.5");
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//提示：借款期限不正确！
		base.checkAlertText("借款期限不正确！");
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 投资期限,输入：0个月,提示：借款期限不正确！
	 */
	@Test(priority = 8)
	public void inputLoanPhases_web_519_5(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器--投资期限,输入：0个月,提示：借款期限不正确！<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入金额10000
		eStarPlanListPage.inputMoney("10000");
		//输入利率
		eStarPlanListPage.inputLoanRate("11");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases("0");
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//提示：借款期限不正确！
		base.checkAlertText("借款期限不正确！");
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 投资期限,输入：25个月,提示：借款期限应在1-24个月之间，请重新填写！
	 */
	@Test(priority = 9)
	public void inputLoanPhases_web_519_6(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器--投资期限,输入：25个月,提示：借款期限应在1-24个月之间，请重新填写！<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入金额10000
		eStarPlanListPage.inputMoney("10000");
		//输入利率
		eStarPlanListPage.inputLoanRate("11");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases("25");
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//提示：借款期限不正确！
		base.checkAlertText("借款期限应在1-24个月之间，请重新填写！");
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 投资期限,输入：fffd#(其他字符),提示：借款期限不正确！
	 */
	@Test(priority = 10)
	public void inputLoanPhases_web_519_7(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器--投资期限,输入：fffd#(其他字符),提示：借款期限不正确！<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入金额10000
		eStarPlanListPage.inputMoney("10000");
		//输入利率
		eStarPlanListPage.inputLoanRate("11");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases("fffd#");
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//提示：借款期限不正确！
		base.checkAlertText("借款期限不正确！");
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 查看“还款方式”显示，默认：还本付息
	 */
	@Test(priority = 11)
	public void inputLoanPhases_web_527(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器，查看“还款方式”显示，默认：还本付息<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//校验查看“还款方式”显示，默认：还本付息
		base.isElementContainsValue(By.cssSelector(".count-txt.wd70.ml5"),"value","还本付息");
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 显示计划时间表和马上计算按钮：购选显示计划时间表，点击马上计算按钮，收款总额和利息
	 */
	@Test(priority = 12)
	public void inputLoanPhases_web_529_1(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器，显示计划时间表和马上计算按钮：购选显示计划时间表，点击马上计算按钮，收款总额和利息,校验收款总额 、利息结果并显示收款时间表  <br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入收益计算器的计息时间
		eStarPlanListPage.inputDate("2015-01-01");
		//输入金额10000
		eStarPlanListPage.inputMoney("10000");
		//输入利率
		eStarPlanListPage.inputLoanRate("15");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases("3");
		//点击显示收款时间表
		eStarPlanListPage.clickDateList();
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//校验计算结果正确   收款总额  利息  
		eStarPlanListPage.isCalculateOK(10000,15,3);
		//校验 校验显示收款时间表
		eStarPlanListPage.isShowDateList();
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 显示计划时间表和马上计算按钮：不购选显示计划时间表，点击马上计算按钮，收款总额和利息
	 */
	@Test(priority = 13)
	public void inputLoanPhases_web_529_2(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器，显示计划时间表和马上计算按钮：不购选显示计划时间表，点击马上计算按钮，收款总额和利息,校验收款总额 、利息结果<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入收益计算器的计息时间
		eStarPlanListPage.inputDate("2015-01-01");
		//输入金额10000
		eStarPlanListPage.inputMoney("10000");
		//输入利率
		eStarPlanListPage.inputLoanRate("15");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases("3");
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//校验计算结果正确   收款总额  利息
		eStarPlanListPage.isCalculateOK(10000,15,3);
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 收款时间表
	 */
	@Test(priority = 14)
	public void checkDateList_web_947_1(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器，校验收款时间表正确<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		String date = "2015-2-5";//计算时间
		double money = 10000;//投资金额
		double rate = 15;//利率
		int phases = 3;//期限
		Reporter.log("输入计息时间："+date+"，投资金额："+money+"，利率："+rate+"，期限："+phases);
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入收益计算器的计息时间
		eStarPlanListPage.inputDate(date);
		//输入金额10000
		eStarPlanListPage.inputMoney(money+"");
		//输入利率
		eStarPlanListPage.inputLoanRate(rate+"");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases(phases+"");
		//点击显示收款时间表
		eStarPlanListPage.clickDateList();
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//校验计算结果正确   收款总额  利息
		eStarPlanListPage.isCalculateOK(money,rate,phases);
		//校验 校验显示收款时间表
		eStarPlanListPage.isShowDateList();
		//校验收款时间表数据正常
		eStarPlanListPage.isDateListOK(date,money,rate,phases);
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 收款时间表
	 */
	@Test(priority = 15)
	public void checkDateList_web_947_2(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器，校验收款时间表正确<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		String date = "2015-2-21";//计算时间
		double money = 10000;//投资金额
		double rate = 15;//利率
		int phases = 3;//期限
		Reporter.log("输入计息时间："+date+"，投资金额："+money+"，利率："+rate+"，期限："+phases);
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入收益计算器的计息时间
		eStarPlanListPage.inputDate(date);
		//输入金额10000
		eStarPlanListPage.inputMoney(money+"");
		//输入利率
		eStarPlanListPage.inputLoanRate(rate+"");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases(phases+"");
		//点击显示收款时间表
		eStarPlanListPage.clickDateList();
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//校验计算结果正确   收款总额  利息
		eStarPlanListPage.isCalculateOK(money,rate,phases);
		//校验 校验显示收款时间表
		eStarPlanListPage.isShowDateList();
		//校验收款时间表数据正常
		eStarPlanListPage.isDateListOK(date,money,rate,phases);
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 收款时间表
	 */
	@Test(priority = 16)
	public void checkDateList_web_947_3(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器，校验收款时间表正确<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		String date = "2016-2-25";//计算时间
		double money = 10000;//投资金额
		double rate = 15;//利率
		int phases = 3;//期限
		Reporter.log("输入计息时间："+date+"，投资金额："+money+"，利率："+rate+"，期限："+phases);
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入收益计算器的计息时间
		eStarPlanListPage.inputDate(date);
		//输入金额10000
		eStarPlanListPage.inputMoney(money+"");
		//输入利率
		eStarPlanListPage.inputLoanRate(rate+"");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases(phases+"");
		//点击显示收款时间表
		eStarPlanListPage.clickDateList();
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//校验计算结果正确   收款总额  利息
		eStarPlanListPage.isCalculateOK(money,rate,phases);
		//校验 校验显示收款时间表
		eStarPlanListPage.isShowDateList();
		//校验收款时间表数据正常
		eStarPlanListPage.isDateListOK(date,money,rate,phases);
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器
	 * 收款时间表
	 */
	@Test(priority = 17)
	public void checkDateList_web_947_4(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--收益计算器，校验收款时间表正确<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		String date = "2016-2-28";//计算时间
		double money = 10000;//投资金额
		double rate = 15;//利率
		int phases = 3;//期限
		Reporter.log("输入计息时间："+date+"，投资金额："+money+"，利率："+rate+"，期限："+phases);
		//点击收益计算器
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//输入收益计算器的计息时间
		eStarPlanListPage.inputDate(date);
		//输入金额10000
		eStarPlanListPage.inputMoney(money+"");
		//输入利率
		eStarPlanListPage.inputLoanRate(rate+"");
		//输入投资期限
		eStarPlanListPage.inputLoanPhases(phases+"");
		//点击显示收款时间表
		eStarPlanListPage.clickDateList();
		//点击马上计算
		eStarPlanListPage.clickCalculate();
		//校验计算结果正确   收款总额  利息
		eStarPlanListPage.isCalculateOK(money,rate,phases);
		//校验 校验显示收款时间表
		eStarPlanListPage.isShowDateList();
		//校验收款时间表数据正常
		eStarPlanListPage.isDateListOK(date,money,rate,phases);
		//关闭收益计算器
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--产品详情--产品总详情
	 * 状态图准确性、计划总额=保障星+收益星+责任星募集总额、剩余期限正确性
	 */
	@Test(priority = 18)
	public void checkDataOfEStarList_web_335_337_342(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--产品详情--产品总详情，状态图准确性、计划总额=保障星+收益星+责任星募集总额、剩余期限正确性<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		eStarPlanListPage.isDataOfEStarListOK();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--产品详情--产品总详情
	 * 点击“产品标题”链接,跳转到投资列表详情页面,检查：产品相关信息与投资列表保持一致（状态，进度，投资按钮，计划总额等）
	 */
	@Test(priority = 19)
	public void checkLinkAndDetailData_web_340(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--产品详情--产品总详情，点击“产品标题”链接,跳转到投资列表详情页面,检查：产品相关信息与投资列表保持一致（状态，进度，投资按钮，计划总额等）<br/>");
		base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		eStarPlanListPage.isLinkAndDetailDataOK();
	}
	
	/**
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--产品详情--保障星详情
	 * 验证清算方式显示正确性,还本付息
	 */
	@Test(priority = 20)
	public void checkBaoZhanStarData_web_343(){
		Reporter.log("前台-翼星计划--投资列表--翼型计划投资列表页--产品详情--保障星详情，验证清算方式显示正确性,还本付息<br/>");
		base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		eStarPlanListPage.idBaoZhangStarDataOK();
	}
}
