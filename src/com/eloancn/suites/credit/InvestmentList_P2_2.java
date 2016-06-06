package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.DebentureTransferPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoginPage;
/*
 * 投资列表
 */
public class InvestmentList_P2_2 {

	Base base = new Base();
	LoginPage loginpage = new LoginPage();
	InvestmentListPage investListPage = new InvestmentListPage();
	DebentureTransferPage newUserPage = new DebentureTransferPage();

	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(investListPage.Url);
		loginpage.login(Data.tel_Invest, Data.password,"",Data.tel_Invest, Data.password,"");
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}	
	
	@Test (priority = 1)
	//我要贷出-投资列表-检查列表页面显示
	public void checkDatawithLogin_3897(){	
		Reporter.log("我要贷出-投资列表-检查列表页面显示");
		investListPage.checkInvestListDatawithLogin();
	}
	
	@Test (priority = 2)
	//我要贷出-投资列表-检查登录和未登录时"自动投标"跳转
	public void checkAutoBidLnk_3897(){
		Reporter.log("我要贷出-投资列表-检查登录和未登录时“自动投标”的跳转");
		investListPage.clickAutoBidBtn(1);
		base.logout();
		base.refreshPage();
		base.openBrowser(investListPage.Url);
		investListPage.clickAutoBidBtn(0);
	}
	
	@Test (priority = 3)
	//我要贷出-投资列表-没有充值过的老手机用户投资
	public void checkTelUserInvestTip_3908(){
		Reporter.log("我要贷出-投资列表-没有充值过的老手机用户投资");
		base.openBrowser(investListPage.Url);
		loginpage.login(Data.run_ECunBao_oldtel, Data.password, "", Data.test_run_ECunBao_oldtel, Data.password, "");
		if(investListPage.clickFastInvestBtn()){
			investListPage.clickCloseRechargeLnk();
		}
	}
	
	@Test (priority = 4)
	//新手专区-没有充值过的老手机用户投资
	public void checkOldTelInvestTip_3924(){
		base.openBrowser(newUserPage.PageUrl);
		newUserPage.clickFastInvestBtn();
		newUserPage.clickCloseRechargeBtn();		
	}
	
	@Test (priority = 5)
	//我要贷出-投资列表-没有充值过的老邮箱用户投资
	public void checkEmailUserInvestTip_3908(){
		Reporter.log("我要贷出-散标列表-没有充值过的老邮箱用户投资");
		base.logout();
		loginpage.login(Data.run_ECunBao_oldemail, Data.password, "", Data.test_run_ECunBao_oldemail, Data.password, "");
		base.openBrowser(investListPage.Url);
		if(investListPage.clickFastInvestBtn()){
			investListPage.clickCloseRechargeLnk();
		}
	}
	
	@Test (priority = 6)
	//新手专区-没有充值过的老邮箱用户投资
	public void checkOldEmailInvestTip_3924(){
		base.openBrowser(newUserPage.PageUrl);
		newUserPage.clickFastInvestBtn();
		newUserPage.clickCloseRechargeBtn();	
	}	

	@Test (priority = 7)
	//我要贷出-投资列表-收益计算器-检查输入“投资金额”
	public void checkInputInvestMoney_3899(){
		Reporter.log("我要贷出-投资列表-收益计算器-检查输入“投资金额”");
		base.openBrowser(investListPage.Url);
		investListPage.clickIncomeCalculatorLnk();
		investListPage.InputInvestInfos("10000", "10", "1", 1, "");
		investListPage.InputInvestInfos("6541dddd", "", "", 0, "投资金额不正确！");
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test (priority = 8)
	//我要贷出-投资列表-收益计算器-检查输入“年利率”
	public void checkInputLoanRate_3900(){
		Reporter.log("我要贷出-投资列表-收益计算器-检查输入“年利率”");
		investListPage.clickIncomeCalculatorLnk();
		investListPage.InputInvestInfos("10000", "0", "", 0, "年利率不正确！");
		investListPage.InputInvestInfos("10000", "js@#", "", 0, "年利率不正确！");
		investListPage.InputInvestInfos("10000", "12", "1", 1, "");
		investListPage.InputInvestInfos("10000", "12.5", "1", 1, "");
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test (priority = 9)
	//我要贷出-投资列表-收益计算器-检查输入“投资期限”
	public void checkInputLoanPhase_3901(){
		Reporter.log("我要贷出-投资列表-收益计算器-检查输入“投资期限”");
		investListPage.clickIncomeCalculatorLnk();
		investListPage.InputInvestInfos("10000", "10", "1", 1, "");
		investListPage.InputInvestInfos("10000", "10", "12", 1, "");
		investListPage.InputInvestInfos("10000", "10", "24", 1, "");
		investListPage.InputInvestInfos("10000", "10", "3.5", 0, "借款期限不正确！");
		investListPage.InputInvestInfos("10000", "10", "0", 0, "借款期限不正确！");
		investListPage.InputInvestInfos("10000", "10", "25", 0, "借款期限应在1-24个月之间，请重新填写！");
		investListPage.InputInvestInfos("10000", "10", "fffd#", 0, "借款期限不正确！");
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test (priority = 10)
	//我要贷出-投资列表-收益计算器-检查“还款方式”
	public void checkRepayMode_3902(){
		Reporter.log("我要贷出-投资列表-收益计算器-检查“还款方式”");
		investListPage.clickIncomeCalculatorLnk();
		investListPage.checkDropdownList();
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test (priority = 11)
	//我要贷出-投资列表-收益计算器-检查收款总额和利息
	public void checkAmountAndInterest_3903(){
		Reporter.log("我要贷出-投资列表-收益计算器-检查收款总额和利息");
		investListPage.clickIncomeCalculatorLnk();
		investListPage.InputInvestInfos("10000", "18", "12", 2, "");
		investListPage.checkAmountAndInterest(false, 10000, 18, 12);
		investListPage.InputInvestInfos("10000", "15", "3", 2, "");
		investListPage.checkShowPlanTable();
		investListPage.clickCalculateNowBtn();
		investListPage.checkAmountAndInterest(true, 10000, 15, 3);
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test (priority = 12)
	//我要贷出-投资列表-收益计算器-检查收款时间表中的数据
	public void checkDatainTable_3904(){
		Reporter.log("我要贷出-投资列表-收益计算器-检查收款时间表中的数据");
		investListPage.clickIncomeCalculatorLnk();
		investListPage.InputInvestInfos("10000", "17", "5", 2, "");
		investListPage.checkShowPlanTable();
		investListPage.clickCalculateNowBtn();
		investListPage.checkDatainTable(10000,17,5);
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test(priority = 13)
	//我要贷出-投资列表-检查投资列表筛选的默认值
	public void checkDefaultOptions_3909_3913(){
		Reporter.log("我要贷出-投资列表-检查投资列表筛选的默认值");
		base.openBrowser(investListPage.Url);
		investListPage.checkDefaultOptions();
	}
	
	@Test (priority = 14)
	//我要贷出-投资列表-检查还款方式筛选功能
	public void checkRepayMode_3909(){
		Reporter.log("我要贷出-投资列表-检查“还款方式”的筛选功能");
		base.openBrowser(investListPage.Url);
		String [] mode = {"等额本金","等额本息","还本付息"};
		investListPage.clickRepayModeOption(mode[0]);
		investListPage.checkOption(mode[0],"","","");
		investListPage.clickRepayModeOption(mode[1]);
		investListPage.checkOption(mode[1],"","","");
		investListPage.clickRepayModeOption(mode[2]);
		investListPage.checkOption(mode[2],"","","");
	}
	
	@Test (priority = 15)
	//我要贷出-投资列表-检查借款期限筛选功能
	public void checkLoanPhase_3910(){
		Reporter.log("我要贷出-投资列表-检查“借款期限”的筛选功能");
		base.openBrowser(investListPage.Url);
		String [] phase = {"3个月以下","4～6个月","7～11个月","12个月以上"};
		investListPage.clickPhaseOption(phase[0]);
		investListPage.checkOption(phase[0],"","","");
		investListPage.clickPhaseOption(phase[1]);
		investListPage.checkOption(phase[1],"","","");
		investListPage.clickPhaseOption(phase[2]);
		investListPage.checkOption(phase[2],"","","");
		investListPage.clickPhaseOption(phase[3]);
		investListPage.checkOption(phase[3],"","","");
	}
	
	@Test (priority = 16)
	//我要贷出-投资列表-检查借款利率筛选功能
	public void checkLoanRate_3911(){
		Reporter.log("我要贷出-投资列表-检查“借款利率”的筛选功能");
		base.openBrowser(investListPage.Url);
		String [] rate = {"12%以下","12%～15%","15%～18%","18%以上"};
		investListPage.clickRateOption(rate[0]);
		investListPage.checkOption(rate[0],"","","");
		investListPage.clickRateOption(rate[1]);
		investListPage.checkOption(rate[1],"","","");
		investListPage.clickRateOption(rate[2]);
		investListPage.checkOption(rate[2],"","","");
		investListPage.clickRateOption(rate[3]);
		investListPage.checkOption(rate[3],"","","");
	}
	
	@Test (priority = 17)
	//我要贷出-投资列表-检查多种条件组合筛选功能
	public void checkFilterFunction1_3913(){
		Reporter.log("我要贷出-投资列表-检查多种条件组合筛选功能");
		base.openBrowser(investListPage.Url);
		investListPage.clickRepayModeOption("等额本金");
		investListPage.clickPhaseOption("3个月以下");
		investListPage.clickRateOption("12%以下");
		investListPage.clickType("信用借款");
		investListPage.checkOption("等额本金","3个月以下","12%以下","信用借款");
	}
	
	@Test (priority = 18)
	//我要贷出-投资列表-检查多种条件组合筛选功能
	public void checkFilterFunction2_3913(){
		Reporter.log("我要贷出-投资列表-检查多种条件组合筛选功能");
		base.openBrowser(investListPage.Url);
		investListPage.clickRepayModeOption("等额本息");
		investListPage.clickPhaseOption("4～6个月");
		investListPage.clickRateOption("12%～15%");
		investListPage.clickType("车辆抵押");
		investListPage.checkOption("等额本息","4～6个月","12%～15%","车辆抵押");
	}
	
	@Test (priority = 19)
	//我要贷出-投资列表-检查多种条件组合筛选功能
	public void checkFilterFunction3_3913(){
		Reporter.log("我要贷出-投资列表-检查多种条件组合筛选功能");
		base.openBrowser(investListPage.Url);
		investListPage.clickRepayModeOption("还本付息");
		investListPage.clickPhaseOption("7～11个月");
		investListPage.clickRateOption("15%～18%");
		investListPage.clickType("房屋抵押");
		investListPage.checkOption("还本付息","7～11个月","15%～18%","房屋抵押");
	}
	
	@Test (priority = 20)
	//我要贷出-投资列表-检查多种条件组合筛选功能
	public void checkFilterFunction4_3913(){
		Reporter.log("我要贷出-投资列表-检查多种条件组合筛选功能");
		base.openBrowser(investListPage.Url);
		investListPage.clickRepayModeOption("等额本息");
		investListPage.clickPhaseOption("12个月以上");
		investListPage.clickRateOption("18%以上");
		investListPage.clickType("信用借款");
		investListPage.checkOption("等额本息","12个月以上","18%以上","信用借款");
	}

}
