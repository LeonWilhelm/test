package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.CreditAssignPage;
import com.eloancn.shared.pages.ElectronicIOU;
import com.eloancn.shared.pages.InvestmentDetailPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.SBInvestPage;
import com.eloancn.shared.pages.TransactionRecordPage;
/*
 * 我的账户-散标投资
 */
public class SBInvestment_P2{
	Base base = new Base();
	LoginPage loginpage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	SBInvestPage sbinvestpage = new SBInvestPage();
	TransactionRecordPage recordpage = new TransactionRecordPage();
	CreditAssignPage creditassignpage = new CreditAssignPage();
	InvestmentDetailPage investDetailPage = new InvestmentDetailPage();
	InvestmentListPage investListPage = new InvestmentListPage();
	ElectronicIOU  ioupage = new ElectronicIOU();

	@BeforeClass
	public void setupBefore(){
		base.setup();
		loginpage.loginByMyAccount(Data.tel_Loan, Data.password);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test (priority = 1)
	//我的账户-我的贷出-散标投资-检查电子账单为空的数据
//需要账户的电子账单为空(账户不投散标)	
	public void checkEmptyEBill_3925(){
		Reporter.log("-检查我的账户-我的贷出-散标投资中电子账单为空的数据<br/>");
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickEBillLnk();
		if(sbinvestpage.ifNoEBill()){
			myAccountPage.clickMyAccountLink();
			double balance = myAccountPage.getBalance()+myAccountPage.getAllFrozenMoney();
			myAccountPage.clickSBInvestLnk();
			sbinvestpage.clickEBillLnk();
			sbinvestpage.checkNoEBillData(balance);
			sbinvestpage.clickGoInvestBtn();
		}
	}

	@Test (priority = 2)
	//我的账户-我的贷出-散标投资-检查电子账单不为空时左上方上个月收入、投资、充值、提现数据
//需要账户的电子账单不为空（账户投资散标）	
	public void checktopleftDataonEBill_3926(){
		Reporter.log("检查我的账户-我的贷出-散标投资中电子账单不为空时，左上方上个月收入、投资、充值、提现数据<br/>");
		base.logout();
//		loginpage.login(Data.tel_Invest, Data.password,"",Data.tel_Invest, Data.password,"");
		loginpage.login("13581838710","111111", "111111", "18880000198","111111", "");//13581838712 集成
		myAccountPage.clickMyAccountLink();
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickEBillLnk();
		if(!sbinvestpage.ifNoEBill()){
			myAccountPage.clickMyAccountLink();
			double LastMonthTX[] = myAccountPage.getLastMonthFreezeMoney();
			myAccountPage.clickTransactionRecord();
			double[] amount=recordpage.checkMoney();
			myAccountPage.clickCreditAssignLnk();
			double purchaseddebt[]= creditassignpage.getPurchasedDebtMoneyandNum();
			myAccountPage.clickSBInvestLnk();
			sbinvestpage.clickEBillLnk();
			sbinvestpage.movetoTotalIncomeTip();
			sbinvestpage.checktopleftData(LastMonthTX,amount,purchaseddebt);
		}else{
			Reporter.log("散标投资中电子账单为空！<br/>");
		}
	}
	
	@Test (priority = 3)
	//我的账户-我的贷出-散标投资-检查电子账单不为空时右上方账户余额、冻结金额数据
//需要账户的电子账单不为空
	public void checktoprightDataonEBill_3927(){
		Reporter.log("检查我的账户-我的贷出-散标投资中电子账单不为空时，右上方账户余额、冻结金额数据<br/>");
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickEBillLnk();
		if(!sbinvestpage.ifNoEBill()){
			myAccountPage.clickMyAccountLink();
			double freezemoney=myAccountPage.getFreezeMoneyUntilLastMonth();
			myAccountPage.clickTransactionRecord();
			String balance =recordpage.checkRemainBalance();
			myAccountPage.clickSBInvestLnk();
			sbinvestpage.clickEBillLnk();			
			sbinvestpage.checktoprightData(freezemoney,balance);
			sbinvestpage.clickFuTouLnk();
			sbinvestpage.checkIncomeStatementData(balance);
			sbinvestpage.closeIncomeTableLnk();
		}
	}
	
	@Test (priority = 4)
	//我的账户-我的贷出-散标投资-检查电子账单不为空时上个月账单详情的数据
//需要账户的电子账单不为空	
	public void checkMiddleDataonEBill_3928(){
		Reporter.log("检查我的账户-我的贷出-散标投资-电子账单不为空时,上个月账单详情的数据<br/>");
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickEBillLnk();
		if(!sbinvestpage.ifNoEBill()){
			myAccountPage.clickMyAccountLink();
			double LastMonthTX[] = myAccountPage.getLastMonthFreezeMoney();
			myAccountPage.clickTransactionRecord();
			double[] amount=recordpage.checkMoney();
			myAccountPage.clickCreditAssignLnk();
			double overdue[]=creditassignpage.collectedSBAmountandNum();
			double purchaseddebt[]= creditassignpage.getPurchasedDebtMoneyandNum();
			myAccountPage.clickSBInvestLnk();
			double SBamount[]=sbinvestpage.getAmountandNum();
			sbinvestpage.clickEBillLnk();
			sbinvestpage.checkMiddleData(overdue,SBamount,amount,LastMonthTX,purchaseddebt);
			sbinvestpage.clickNormalPayViewLnk();
			sbinvestpage.checkNormalPayData(SBamount[0],SBamount[1]);
		}
	}
	
	@Test (priority = 5)
	//我的账户-我的贷出-散标投资-我的举报-检查取消举报后关闭举报窗口
	public void checkCancelReport_3930(){
		Reporter.log("检查我的账户-我的贷出-散标投资-我的举报中取消举报后关闭举报窗口<br/>");
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickMyReportLnk();
		base.openBrowser(investListPage.Url);
		if(investListPage.ifExistSB()){
			investListPage.clickFirstTitle();
			investDetailPage.clickReportLnk();
			investDetailPage.clickCancelReportBtn();
		}
	}
	
	@Test (priority = 6)
	//我的账户-我的贷出-散标投资-我的举报-检查成功举报
	public void checkReportSuccess_3930(){
		Reporter.log("我的账户-我的贷出-散标投资-我的举报-检查成功举报<br/>");
		if(base.indexURL.contains("client")){
			base.openBrowser(investListPage.Url);
			if(investListPage.ifExistSB()){
				String username=investListPage.clickFirstTitle();
				investDetailPage.clickReportLnk();
				String type=investDetailPage.selectReportType("怀疑此人有虚假信息");
				String des=investDetailPage.inputDescription();
				String date=investDetailPage.clickOKReportBtn();
				if(date!=null){
					base.openBrowser(myAccountPage.MyAccountUrl);
					myAccountPage.clickSBInvestLnk();
					sbinvestpage.clickMyReportLnk();
					sbinvestpage.checkReportInformation(username,type,des,date);
					sbinvestpage.clickReportedName();
				}
			}
		}
	}
	
	@Test (priority = 7)
	//我的账户-我的贷出-散标投资-我的黑名单-检查取消加入黑名单后关闭加入黑名单窗口
//需要我的黑名单为空	
	public void checkCancelJoinBlacklist_3931(){
		Reporter.log("我的账户-我的贷出-散标投资-我的黑名单-检查取消加入黑名单后关闭加入黑名单窗口<br/>");
		base.openBrowser(myAccountPage.MyAccountUrl);
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickMyBlacklistLnk();
		base.openBrowser(investListPage.Url);
		if(investListPage.ifExistSB()){
			investListPage.clickFirstTitle();
			investDetailPage.clickJoinBlacklistLnk();
			investDetailPage.clickCancelJoinBlacklistBtn();
		}	
	}

	@Test (priority = 8)
	//我的账户-我的贷出-散标投资-我的黑名单-检查取消确认加入黑名单和成功确认加入黑名单
	public void checkConfirmJoinBlacklist_3931(){
		base.openBrowser(investListPage.Url);
		if(investListPage.ifExistSB()){
			String username=investListPage.clickFirstTitle();
			investDetailPage.clickJoinBlacklistLnk();
			String reason=investDetailPage.InputSetReason();
			investDetailPage.clickOkJoinBlacklistBtn(false);
			String date=investDetailPage.clickOkJoinBlacklistBtn(true);
			if(date!=null){
				base.openBrowser(myAccountPage.MyAccountUrl);
				myAccountPage.clickSBInvestLnk();
				sbinvestpage.clickMyBlacklistLnk();
				sbinvestpage.checkBlacklistInfo(username,reason,date);
				sbinvestpage.clickBlacklistName();
			}
		}
	}	
	
	@Test (priority = 9)
	//我的账户-我的贷出-散标投资-我的黑名单-检查取消删除黑名单和成功删除黑名单
	public void checkConfirmDeleteBlacklist_3931(){	
		Reporter.log("我的账户-我的贷出-散标投资-我的黑名单-检查取消删除黑名单和成功删除黑名单<br/>");
		myAccountPage.clickSBInvestLnk();
		int num=sbinvestpage.clickMyBlacklistLnk();
		sbinvestpage.checkFirstCheckbox();
		sbinvestpage.clickDeleteBlacklistLnk(false);
		sbinvestpage.clickDeleteBlacklistLnk(true);
		sbinvestpage.checkDeleteoneBlacklist(num);
	}
	
	@Test (priority = 10,enabled = false)
	//我的账户-我的贷出-散标投资-检查同城预投标
	public void checkLocalPreBid_3932(){
		Reporter.log("我的账户-我的贷出-散标投资-检查同城预投标<br/>");
		myAccountPage.clickSBInvestLnk();
		int num=sbinvestpage.clickLocalPreBidLnk();		
		base.assertTrueByBoolean(num==0);
	}
	
	@Test (priority = 10)
	//我的账户-我的贷出-散标投资-检查左上方数据待收本息,利息,本金的显示
	public void checkTopLeftData_3933(){
		Reporter.log("我的账户-我的贷出-散标投资-检查左上方数据待收本息,利息,本金的显示<br/>");
		myAccountPage.clickCreditAssignLnk();
		boolean collect=creditassignpage.ifExistCollect();
		myAccountPage.clickSBInvestLnk();		
		sbinvestpage.CheckTopLeftData(collect);
	}

	@Test (priority = 11)
	//我的账户-我的贷出-散标投资-已结清的投资-检查电子借条信息
//需要已结清的投资中不为空	
	public void checkClosedInvest_3937(){
		Reporter.log("我的账户-我的贷出-散标投资-已结清的投资-检查电子借条信息<br/>");
		base.openBrowser(myAccountPage.MyAccountUrl);
		myAccountPage.clickSBInvestLnk();		
		if(sbinvestpage.clickClosedInvestLnk()){
			String phase=sbinvestpage.clickClosedInvestTitle();
			String title = base.getElementTextWithWait(sbinvestpage.BorrowTitle);
			String Borrower = base.getElementText(sbinvestpage.FirstBorrower);
			String rate = base.getElementText(sbinvestpage.FirstRate).split(": ")[1];
			String data[] = sbinvestpage.clickLoanDetailLnk();
			sbinvestpage.clickElectronicIOULnk();
			ioupage.checkElectronicIOUInfoforInvest(data,Borrower,phase,rate,title);
		}
	}
	
	@Test (priority = 12)
	//我的账户-我的贷出-散标投资-已结清的投资-检查下载电子借条成功
	public void checkDownloadIOU_3937(){
		base.openBrowser(myAccountPage.MyAccountUrl);
		myAccountPage.clickSBInvestLnk();	
		if(sbinvestpage.clickClosedInvestLnk()){
			sbinvestpage.clickElectronicIOULnk();
			ioupage.clickPDFLnk();
		}
	}		

}
