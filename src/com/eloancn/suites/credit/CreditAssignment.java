package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.*;
import com.eloancn.shared.pages.*;

/*
 * “债权转让”页面用例-刘京
 */
public class CreditAssignment {
	
	Base base = new Base();
	IndexPage indexpage= new IndexPage();
	LoginPage loginpage = new LoginPage();
	CreditAssignListPage list = new CreditAssignListPage();
	CreditDetailPage detailpage = new CreditDetailPage();
	private String MemberBPayPwd;
	
	@BeforeClass
	public void setupBefore(){
		
		base.setup();
		base.openBrowser(list.CreditAssignmentUrl);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(priority = 1) 
	//检查“债权转让列表”页面的数据和链接
	public void verifyListDataLnk_AT_531(){
		Reporter.log("债权转让列表页-检查数据及链接");
		list.verifyCreditPagination();
		list.verifyDataLnk();
	}
	
	@Test(priority = 2) 
	//检查未登录的“立即购买/立即出价”链接
	public void FastBuyBtninList_AT_534(){
		Reporter.log("债权转让列表页-未登录时的 立即购买/立即出价 链接");
		if(list.ifshowBuyNowBtn()){
			list.clickFirstBuyNowBtn();
			list.clickCloseLoginLnk();
		}else{
			System.out.println("没有可购买的债权！");
			Reporter.log("<br/>没有可购买的债权！");
		}
	}
	
	@Test(priority = 3)
	//检查成功购买拍卖的债权
	public void BuyAuctionDebt_AT_535(){
		Reporter.log("债权转让列表页-购买拍卖的债权成功");
		MemberBPayPwd=loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		list.clickAuctionMode();
		if(list.ifshowBuyNowBtn()){
			if(list.compareCreditMoney()){
				list.clickAddLnk();
				list.InputPayPwd(MemberBPayPwd);
				list.InputValidateCode();
				base.sleep(2000);
				list.clickOkBtn();					
				list.clickContinueBtn();			
				list.CheckBuySuccess("恭喜您出价成功");
			}else{
				System.out.println("拍卖的债权金额较大，或者竞拍金额等于或高于待收本息！");
				Reporter.log("<br/>拍卖的债权金额较大，或者竞拍金额等于或高于待收本息！");
			}
		}else{
			System.out.println("没有可购买的拍卖债权！");
			Reporter.log("<br/>没有可购买的拍卖债权！");
		}	
	}	
	
	@Test(priority = 4)
	//检查成功购买一口价的债权
	public void BuyFixedPriceDebt_AT_536(){
		Reporter.log("债权转让列表页-购买一口价的债权成功");
		MemberBPayPwd=loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		list.clickFixedPriceMode();
		if(list.ifshowBuyNowBtn()){
			if(list.compareCreditMoney()){
				list.InputPayPwd(MemberBPayPwd);
				list.InputValidateCode();
				base.sleep(2000);
				list.clickOkBtn();
				list.CheckBuySuccess("恭喜您购买债权成功");
			}else{
				System.out.println("一口价的债权金额较大，不予购买！");
				Reporter.log("<br/>一口价的债权金额较大，不予购买！");
			}
		}else{
			System.out.println("没有可购买的一口价债权！");
			Reporter.log("<br/>没有可购买的一口价债权！");
		}	
	}
	
	@Test(priority = 5)	
	//检查成功购买密转的债权
	public void BuySecretTransferDebt_AT_537(){
		Reporter.log("债权转让列表页-购买密转的债权成功");
		MemberBPayPwd=loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		list.clickSecretTransferMode();
		if(list.ifshowBuyNowBtn()){
			if(list.compareCreditMoney()){
				list.InputTransferCode();
				list.InputPayPwd(MemberBPayPwd);
				list.InputValidateCode();
				base.sleep(2000);
				list.clickOkBtn();
				list.CheckBuySuccess("恭喜您购买债权成功");
			}else{
				System.out.println("密转的债权金额较大，不予购买！");
				Reporter.log("<br/>密转的债权金额较大，不予购买！");
			}
		}else{
			System.out.println("没有可购买的密转债权！");
			Reporter.log("<br/>没有可购买的密转债权！");
		}	
	}
	
	@Test(priority = 6)
	//检查债权转让详情页
	public void verifyDebtDetailPage_AT_538(){
		Reporter.log("检查债权转让详情页的数据和链接");
		base.openBrowser(list.CreditAssignmentUrl);
		if(list.ifshowCreditAssign()){
			list.clickFirstDebtTitle();
			detailpage.verifyCreditDetail();
		}else{
			System.out.println("债权列表页没有债权！");
			Reporter.log("<br/>债权列表页没有债权！");
		}
	}
	
	@Test(priority = 7)
	//检查可购买的债权
	public void verifyDebtDetailData_AT_736(){
		Reporter.log("检查可购买的债权的详情页，数据跟列表页中的数据一致");
		if(list.ifshowCreditforBuy()){
				list.verifyDebtData();
		}else{
			System.out.println("债权列表页没有可购买的债权！");
			Reporter.log("<br/>债权列表页没有可购买的债权！");
		}
	}	

}
