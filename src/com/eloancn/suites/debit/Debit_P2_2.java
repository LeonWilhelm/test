package com.eloancn.suites.debit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ClientBackPage;
import com.eloancn.shared.pages.InvestmentDetailPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyLoanPage;
/**
 * 当需要还款的借款标时调用，不需要每次执行
 */
public class Debit_P2_2{

	Base base = new Base();
	DBData dbdata = new DBData();
	MyAccountPage myAccountPage = new MyAccountPage();
	LoginPage loginpage = new LoginPage();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	MyLoanPage myloanpage = new MyLoanPage();
	InvestmentListPage investlistpage = new InvestmentListPage();
	InvestmentDetailPage investdetailpage = new InvestmentDetailPage();
	ClientBackPage backpage = new ClientBackPage();
	String tenderid="";
	String UserID="";
	String blx="翼农贷";
	public String borrowtype="fx";

	@AfterClass	
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test (priority = 1)
	//申请借款并且总部初审通过
	public void PassFirstAudit(){
		if(base.indexURL.contains("client")){
			base.setup_ff();
			base.drivermanage();
			loginpage.loginByMyAccount(Data.tel_Loan, Data.password);
			base.openBrowser(myAccountPage.MyAccountUrl);
			UserID=myAccountPage.getUserID();
			myAccountPage.turnToMyAccount("申请借款");
			String LoanPurpose=loanApplicationPage.loanApplication(false, false, blx, "500", "3个月","","5", "7", "满标", borrowtype, "个人消费", "自动"+base.RandomNumber(), "自动化：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			tenderid= myloanpage.getTenderId(LoanPurpose);
			myloanpage.UpdateTenderStatuswithSQL(tenderid,"1");
		}
	}
		
	@Test (priority =2,dependsOnMethods={"PassFirstAudit"})
	//一个用户投满标
	public void InvestSB(){
		if(base.indexURL.contains("client")){
			base.logout();
			base.openBrowser(investlistpage.Url);
			String paypwd=loginpage.login("13581838712","111111","111111", Data.tel_Invest, Data.test_password, Data.tel_Invest_PayPwd);
			investlistpage.clickInvestmentDataTitleById(tenderid);
			base.turnToNewPage();
			investdetailpage.clickInvestLnk();
			investdetailpage.clickAutoInputLnk();
			investdetailpage.InputPayPwd(paypwd);
			investdetailpage.InputValidateCode();
			investdetailpage.clickOKBtn();
			investdetailpage.checkInvestSuccess();		
		}
	}
	
	@Test (priority =3,dependsOnMethods={"InvestSB"})
	//用户确认借贷
	public void ConfirmBorrow(){
		if(base.indexURL.contains("client")){
			base.logout();
			loginpage.loginByMyAccount(Data.tel_Loan, Data.password);
			myloanpage.OpenMobilePaywithSQL(UserID);
			myloanpage.ConfirmVideowithSQL(UserID,tenderid);
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickPublishedTab();
			myloanpage.clickSureDebitBtn(tenderid);
			myloanpage.agree();
			base.tearDown();
		}
	}
	
	@Test (priority =4,dependsOnMethods={"ConfirmBorrow"})
	//总部终审通过(不能通过改数据库状态实现，必须通过后台操作)
	public void PassFinalAudit(){
		if(base.indexURL.contains("client")){			
			base.setup_ie();
			base.drivermanage();
			backpage.backLogin(base.clientBackURL, Data.noticeCode, "lj1", "eloancn888");
			backpage.clickFirstMenu("风控管理");
			backpage.clickSubMenu("待终审借款列表");
			backpage.FinalAudit(tenderid);
			base.tearDown();
		}
	}
	
}
