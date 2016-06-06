package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.*;
import com.eloancn.shared.pages.*;
/*
 * “我的账户”用例-刘京
 */
public class MyAccount {

	Base base = new Base();
	LoginPage loginpage = new LoginPage();
	MyAccountPage myaccount = new MyAccountPage();
	IndexPage indexpage = new IndexPage();
	AutoBidPage autobid = new AutoBidPage();
	CreditAssignPage creditassign = new CreditAssignPage();
	SBInvestPage SBInvest = new SBInvestPage();
	private String MemberAPayPwd;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(myaccount.MyAccountUrl);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}	
	
	@Test(priority = 1) 
	//检查“我的账户”页面的数据
	public void verifyDatainMyAccount_AT_520(){
		Reporter.log("账户总览 页面数据显示正确");
		MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		myaccount.verifyLeftnavigationData();
		myaccount.verifyMyAccountData();		
	}
	
	@Test(priority = 2) 
  	//检查“充值”,“提现”按钮的链接
    public void verifyCashLnk_AT_520(){
		Reporter.log("账户总览页面 充值和提现链接到正确页面");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
		myaccount.clickAccountOverviewLnk();
    	myaccount.clickFreezeStatisticsImg();
    	myaccount.clickCloseFreezeLnk();
		myaccount.clickRechargeBtn();
		myaccount.clickAccountOverviewLnk();
		myaccount.clickWithDrawBtn();
    }
    
    @Test(priority = 3) 
    //检查“我的借入”中的链接
    public void verifyMyLoanLnk_AT_520(){
    	Reporter.log("账户总览页面 申请借款和我的借款连接到正确页面");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
    	myaccount.clickAccountOverviewLnk();
    	myaccount.clickLoanApplicationLnk();
    	myaccount.clickAccountOverviewLnk();
    	myaccount.clickMyLoanLnk();
    }
     
    @Test(priority = 4) 
    //债权密转
    public void SecretAssignDebt_AT_526(){
    	Reporter.log("我的账户-债权转让-可转出的债权-密转模式转让债权成功");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
    	myaccount.clickCreditAssignLnk();
    	if(!creditassign.ifshowCredit()){
    		System.out.println("切换账户查看是否存在可转出的债权！");
    		Reporter.log("<br/>切换账户查看是否存在可转出的债权！");
    		base.logout();
    		loginpage.loginByMyAccount(Data.tel_run_zhaiquan2,Data.password, Data.zzmm,Data.test4_tel,Data.test4_password,Data.test4_zzmm);
    		myaccount.clickCreditAssignLnk();
    	}   	
    	if(creditassign.ifshowCredit()){
    		creditassign.clickCreditAssignLnk();
    		creditassign.InputAssignReason();
    		creditassign.chooseSecretAssign();
    		creditassign.InputTransforCode();
    		creditassign.InputPayPwd(MemberAPayPwd);
    		creditassign.clickOKBtn();
    	}else{
    		System.out.println("没有可转出的债权！所以不能密转！");
    		Reporter.log("<br/>没有可转出的债权！所以不能密转！");
    	}
    }
    
    @Test(priority = 5) 
    //债权一口价转让
    public void APriceAssignDebt_AT_523(){
    	Reporter.log("我的账户-债权转让-可转出的债权-一口价模式转让债权成功");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
    	myaccount.clickCreditAssignLnk();
    	if(creditassign.ifshowCredit()){
        	creditassign.clickCreditAssignLnk();
        	creditassign.InputAssignReason();
        	creditassign.chooseFixedPrice();
        	creditassign.selectRemainTime("1天");
        	creditassign.InputPayPwd(MemberAPayPwd);
        	creditassign.clickOKBtn();
    	}else{
    		System.out.println("没有可转出的债权！所以不能一口价转让！");
    		Reporter.log("<br/>没有可转出的债权！所以不能一口价转让！");
    	}
    }  

    @Test(priority = 6) 
    //债权拍卖转让
    public void AuctionAssignDebt_AT_524(){
    	Reporter.log("我的账户-债权转让-可转出的债权-拍卖模式转让债权成功");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
    	myaccount.clickCreditAssignLnk();
    	if(creditassign.ifshowCredit()){
    		creditassign.clickCreditAssignLnk();
    		creditassign.InputAssignReason();
    		creditassign.chooseAuction();
    		creditassign.selectRemainTime("1天");
    		creditassign.InputLowPrice();
    		creditassign.InputPayPwd(MemberAPayPwd);
    		creditassign.clickOKBtn();
    	}else{
    		System.out.println("没有可转出的债权！所以不能拍卖！");
    		Reporter.log("<br/>没有可转出的债权！所以不能拍卖！");
    	}
    }  
    
    @Test(priority = 7) 
    //债权-批量转让
    public void BulkTransferDebt_AT_528(){
    	Reporter.log("我的账户-债权转让-可转出的债权-批量转让模式转让债权成功");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
    	myaccount.clickCreditAssignLnk();
    	if(creditassign.ifshowCredit()){
    		creditassign.checkFirstCredit();
    		creditassign.clickBulkTransferBtn();
    		creditassign.InputAssignReason();
    		creditassign.InputPayPwd(MemberAPayPwd);
    		creditassign.clickOKBtn();
    	}else{
    		System.out.println("没有可转出的债权！所以不能批量转让！");
    		Reporter.log("<br/>没有可转出的债权！所以不能批量转让！");
    	}
    }   
	    
	 @Test(priority = 8) 
	 //自动投标-固额投标
	 public void FixedAmountBid_AT_522(){
	 	Reporter.log("我的账户-自动投标-固额投标成功-验证数据");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
	 	myaccount.clickAutoBidLnk();
	 	if(autobid.ifshowAutoBidSetLnk()){
	 		autobid.clickAutoBidBtn();
	 		autobid.checkFixedAmountBid(MemberAPayPwd);
	 	}else{
	 		System.out.println("固额投标的权限不够！");
	 		Reporter.log("<br/>固额投标的权限不够！");
	 	}
	 }
	
	 @Test(priority = 9) 
	 //自动投标-余额投标
	 public void BalanceBid_AT_521(){
	 	Reporter.log("我的账户-自动投标-余额投标成功-验证数据");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
	 	myaccount.clickAutoBidLnk();
	 	if(autobid.ifshowAutoBidSetLnk()){
	 		autobid.clickAutoBidBtn();
	 		autobid.checkBalanceBid(MemberAPayPwd);
	 	}else{
	 		System.out.println("余额投标的权限不够！");
	 		Reporter.log("<br/>余额投标的权限不够！");
	 	}   	
	 }
	 
	 @Test(priority = 10)
	 //关闭自动投标
	 public void CloseAutoBid(){
	 	Reporter.log("我的账户-自动投标-关闭自动投标");
		if(!loginpage.ifMyAccountLogin()){
			loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
	 	myaccount.clickAutoBidLnk();
	 	if(autobid.ifshowAutoBidSetLnk()){
	 		if(autobid.ifAutoBidOpen()){
	 			autobid.clickCloseAutoBidBtn();
	 		}
	 	}
	 }

}
