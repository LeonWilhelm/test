package com.eloancn.suites.credit;

import java.util.ArrayList;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.model.DWutGuaranteeModel;
import com.eloancn.shared.pages.*;

/*
 * “翼星计划”P2用例-刘京
 */
public class EStarPlan_P2 {

	Base base = new Base();
	Data data = new Data();
	
	LoginPage loginpage = new LoginPage();
	MyAccountPage myaccount = new MyAccountPage();
	MyDebitPlan mydebitplan = new MyDebitPlan();
	ElectronicIOU  ioupage = new ElectronicIOU();
	EStarPlanListPage ListPage = new EStarPlanListPage();
	EStarDetailPage DetailPage = new EStarDetailPage();
	CreditReferrerDetailPage ReferrerPage = new CreditReferrerDetailPage();
	EStarPlanLoanDetailPage loandetailpage = new EStarPlanLoanDetailPage();
	
	DWutGuaranteeModel baoZhengRenZrr;	//自然人
	DWutGuaranteeModel baoZhengRenFr;	//法人
	
	private String UserName,Photo,Age;
	
	@BeforeClass
	public void setupBefore(){
		
		base.setup();//27条
		loginpage.loginByMyAccount(Data.tel_Loan, Data.password,"",Data.tel_Loan, Data.password,"");
		myaccount.clickAccountInfoLnk();
		base.checkElementVisible(AccountInfoPage.UserNameTxt);
		UserName = base.getElementTextWithWait(AccountInfoPage.UserNameTxt);	
		Photo = base.getLnkElementText(AccountInfoPage.photoPic, "src");
		myaccount.clickMyDebitPlanLnk();
		Age = mydebitplan.clickPerfectInfoLnk();
		baoZhengRenZrr = new DWutGuaranteeModel(data.getFullName(),data.idConcatenation(), "北京市", "北京市", data.phoneConcatenation(3), data.emailConcatenation(6, 2), "自然人");
		baoZhengRenFr  = new DWutGuaranteeModel(data.getFullName(), data.getFullName(), "北京市", data.phoneConcatenation(3), data.emailConcatenation(6, 2), "法人");		
		mydebitplan.ApplyforQiYeLoan("10000", "企业", "3个月", "生意周转", "自动化测试使用", data.phoneConcatenation(3), data.emailConcatenation(7, 2), baoZhengRenZrr, baoZhengRenFr);
		base.openBrowser(myaccount.MyAccountUrl);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(priority = 1) 
	//检查“翼星计划”-“我的借入计划”-“企业标详情页”中的用户头像、姓名、年龄
	public void AccountInfoonBidDetail_web_573(){
		Reporter.log("检查“翼星计划”-“我的借入计划”-“企业标详情页”中的用户头像、姓名、年龄");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickPublishingLoanLnk();
		if(mydebitplan.ifFirstBidisQiYeBid()){
			mydebitplan.clickLoanTitleLnk();
			loandetailpage.checkUserInfo(Photo,UserName,Age,1);
		}else{
			System.out.println("第一条借款标不是企业标！");
			Reporter.log("<br/>第一条借款标不是企业标！");
		}
	}
	
	@Test(priority = 2)
	//检查“翼星计划”-“我的借入计划”-“企业标详情页”中的企业基本信息
	public void QYInfoonBidDetail_web_574(){
		Reporter.log("检查“翼星计划”-“我的借入计划”-“企业标详情页”中的企业基本信息");
		if(loandetailpage.ifinLoanDetailPage()){
			loandetailpage.checkQiYeBasicInfo(1);
		}else{
			myaccount.clickMyDebitPlanLnk();
			mydebitplan.clickPublishingLoanLnk();
			if(mydebitplan.ifFirstBidisQiYeBid()){
				mydebitplan.clickLoanTitleLnk();
				loandetailpage.checkQiYeBasicInfo(2);
			}else{
				System.out.println("第一条借款标不是企业标！");
				Reporter.log("<br/>第一条借款标不是企业标！");
			}
		}
	}
	
	@Test(priority = 3)
	//检查“翼星计划”-“我的借入计划”-“企业标详情页”中的还款来源、债权推荐人、担保措施/意见
	public void QYOtherInfo_web_575(){
		Reporter.log("检查“翼星计划”-“我的借入计划”-“企业标详情页”中的还款来源、债权推荐人、担保措施/意见");
		if(loandetailpage.ifinLoanDetailPage()){
			loandetailpage.checkQiYeOtherInfo(1);
		}else{
			myaccount.clickMyDebitPlanLnk();
			mydebitplan.clickPublishingLoanLnk();
			if(mydebitplan.ifFirstBidisQiYeBid()){
				mydebitplan.clickLoanTitleLnk();
				loandetailpage.checkQiYeOtherInfo(2);
			}else{
				System.out.println("第一条借款标不是企业标！");
				Reporter.log("<br/>第一条借款标不是企业标！");
			}
		}
	}
	
	@Test(priority = 4) 
	//检查“翼星计划”-“我的借入计划”-“企业标详情页”中的借款标信息(信用等级可能需要修改)
	public void LoanInfoonBidDetail_web_539(){
		Reporter.log("检查“翼星计划”-“我的借入计划”-“企业标详情页”中的借款标信息");
		if(loandetailpage.ifinLoanDetailPage()){
			loandetailpage.checkBidInfo(1);
		}else{
			myaccount.clickMyDebitPlanLnk();
			mydebitplan.clickPublishingLoanLnk();
			if(mydebitplan.ifFirstBidisQiYeBid()){
				mydebitplan.clickLoanTitleLnk();
				loandetailpage.checkBidInfo(2);	
			}else{
				System.out.println("第一条借款标不是企业标！");
				Reporter.log("<br/>第一条借款标不是企业标！");
			}
		}
	}
	
	@Test(priority = 5) 
	//检查“我的账户”-“我的借入计划”的页面显示
	public void checkMyLoanPlanPage_web_58(){
		Reporter.log("检查“我的账户”-“我的借入计划”的页面显示");
		base.openBrowser(myaccount.MyAccountUrl);
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.checkDatainPage();
	}
	
	
	@Test(priority = 6) 
	//“企业信息材料页面”-“债权推荐人名称”--输入框功能
	public void checkReferrerName_web_473(){
		Reporter.log("检查“企业信息材料页面”-“债权推荐人名称”的输入框功能");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickShenQingDaiKuan();
		mydebitplan.selectBorrowerType("企业");
		mydebitplan.clickFillInQYInfoLnk();
		mydebitplan.checkQYReferrerName();
		mydebitplan.clickCancelBtn();
	}
	
	@Test(priority = 7) 
	//"企业信息材料页面"-"债权推荐人简介"--输入框功能
	public void checkReferrerIntro_web_476(){
		Reporter.log("检查“企业信息材料页面”-“债权推荐人简介”的输入框功能");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickShenQingDaiKuan();
		mydebitplan.selectBorrowerType("企业");
		mydebitplan.clickFillInQYInfoLnk();
		mydebitplan.checkQYReferrerIntro();
		mydebitplan.clickCancelBtn();
	}
	
	@Test(priority = 8) 
	//"企业信息材料页面"-"注册金额"--输入框功能
	public void checkRegisteredAmount_web_481(){
		Reporter.log("检查“企业信息材料页面”-“注册金额”的输入框功能");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickShenQingDaiKuan();
		mydebitplan.selectBorrowerType("企业");
		mydebitplan.clickFillInQYInfoLnk();
		mydebitplan.checkQYRegisterAmount();
		mydebitplan.clickCancelBtn();
	}
	
	@Test(priority = 9) 
	//检查“我的借入计划”-“尚未发布的借款”-列表的标信息
	public void checkPublishingLoanData_web_852(){
		Reporter.log("检查“我的借入页面”-“尚未发布的借款”-列表的标信息");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickPublishingLoanLnk();
		mydebitplan.checkPublishingLoanData();
	}
	
	@Test(priority = 10) 
	//“我的借入计划”-“尚未发布的借款”-预览功能及预览页面信息
	public void checkPreviewfunction_web_334(){
		Reporter.log("检查“我的借入页面”-“尚未发布的借款”-预览功能及预览页面信息");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickPublishingLoanLnk();
		mydebitplan.clickPreviewLnk();
		loandetailpage.checkUserInfo(Photo,UserName,Age,2);
		loandetailpage.checkBidInfo(2);
	}
	
	@Test(priority = 11) 
	//“我的借入计划”-“尚未发布的借款”-发布功能
	public void checkPublishfunction_web_366(){
		if(base.indexURL.contains("client")){
			Reporter.log("检查“我的借入页面”-“尚未发布的借款”-发布功能");
			myaccount.clickMyDebitPlanLnk();
			mydebitplan.clickPublishedLoanLnk();
			int num1 = mydebitplan.getNumofAllLoan();
			mydebitplan.clickPublishingLoanLnk();
			int num2 = mydebitplan.getNumofAllLoan();
			mydebitplan.clickPublishLnk();
			mydebitplan.checkBorrowedInfo();
			mydebitplan.clickPublishBtn();
			mydebitplan.checkPublishedLoan(num1,num2);
		}
	}
	
	@Test(priority = 12) 
	//“我的借入计划”-“已发布的借款”-列表的标信息
	public void checkPublishedLoanData_web_853(){
		if(base.indexURL.contains("client")){
			Reporter.log("检查“我的借入页面”-“已发布的借款”-列表的标信息");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickPublishedLoanLnk()){
				mydebitplan.checkPublishedLoanData();
			}else{
				System.out.println("没有已发布的借款！");
				Reporter.log("<br/>没有已发布的借款！");
			}
		}
	}
	
	@Test(priority = 13) 
	//“我的借入计划”-“已发布的借款”-待初审状态
	public void checkPublishedAuditStatus_web_383(){
		if(base.indexURL.contains("client")){
			Reporter.log("“我的借入页面”-“已发布的借款”-检查前台待初审状态");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickPublishedLoanLnk()){
				mydebitplan.checkPublishedAuditStatus();
			}else{
				System.out.println("没有已发布的借款！");
				Reporter.log("<br/>没有已发布的借款！");
			}
		}
	}
	
	@Test(priority = 14) 
	//“我的借入计划”-“正在还款的借款”-列表的标信息
	public void checkRepayingLoanData_web_877(){
		if(base.indexURL.contains("client")){
			Reporter.log("检查“我的借入页面”-“正在还款的借款”-列表的标信息");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayingLoanLnk()){
				String borrow[] = mydebitplan.clickLoanDetailLnk();
				mydebitplan.clickLoanPurpose();
				mydebitplan.checkRepayingLoanInfo(borrow);	//实还本息,未还金额还需要调整
			}else{
				System.out.println("没有正在还款的借款！");
				Reporter.log("<br/>没有正在还款的借款！");
			}
		}
	}
	
	@Test(priority = 15) 
	//“我的借入计划”-“正在还款的借款”-列表的查看下载电子借条(借款投资人都是单点1账户)
	public void checkElectronicLoan_web_416(){
		if(base.indexURL.contains("client")){
			Reporter.log("检查“我的借入页面”-“正在还款的借款”-列表的查看下载电子借条");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayingLoanLnk()){
//				String name = base.getElementText(IndexPage.userName);
				String company = "北京长青";//改为申请借款的企业名称，详情咨询李晓英
				String id = base.getLnkElementText(mydebitplan.LoanDetailLnk,"href").split("=")[1];
				String data[] = mydebitplan.clickLoanDetailLnk();
				mydebitplan.clickRepayingIOULnk();
				ioupage.checkElectronicIOUInfo(company,data,UserName,id);
			}else{
				System.out.println("没有正在还款的借款！");
				Reporter.log("<br/>没有正在还款的借款！");
			}
		}
	}
	
	@Test(priority = 16) 
	//“我的借入计划”-“正在还款的借款”-列表的查看下载电子借条-下载成功
	public void checkDownloadElectronicLoan_web_416(){
		if(base.indexURL.contains("client")){
			Reporter.log("检查“我的借入页面”-“正在还款的借款”-列表的查看下载电子借条-下载成功");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayingLoanLnk()){
				mydebitplan.clickRepayingIOULnk();
				ioupage.clickPDFLnk();
			}else{
				System.out.println("没有正在还款的借款！");
				Reporter.log("<br/>没有正在还款的借款！");
			}
		}
	}
	
	@Test(priority = 17) 
	//“我的借入计划”-“已全部还清的借款”-列表的标信息
	public void checkRepayedLoanData_web_433(){
		if(base.indexURL.contains("client")){
			Reporter.log("检查“我的借入页面”-“已全部还清的借款”-列表的标信息");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayedLoanLnk()){
				mydebitplan.clickLoanPurpose();
				String time = mydebitplan.clickRepayedIOULnk();
				mydebitplan.checkRepayedLoanInfo(time);
			}else{
				System.out.println("没有已全部还清的借款！");
				Reporter.log("<br/>没有已全部还清的借款！");
			}
		}
	}
	
	@Test(priority = 18) 
	//“我的借入计划”-“已全部还清的借款”-还款列表
	public void checkRepayedList_web_882(){
		if(base.indexURL.contains("client")){
			Reporter.log("检查“我的借入页面”-“已全部还清的借款”-还款列表");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayedLoanLnk()){
				String RepayTime = mydebitplan.clickLoanPurpose();
				String time = mydebitplan.clickRepayedIOULnk();
				mydebitplan.checkRepayList(RepayTime,time);
			}else{
				System.out.println("没有已全部还清的借款！");
				Reporter.log("<br/>没有已全部还清的借款！");
			}
		}
	}
	
	@Test(priority = 19) 
	//“我的借入计划”-“正在还款的借款”-有逾期未还款时
	public void checkOverdue_web_900(){
		if(base.indexURL.contains("client")){
			Reporter.log("检查“我的借入页面”-“正在还款的借款”-有逾期未还款时数据显示");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayingLoanLnk()){
				if(mydebitplan.ifshowOverdueLoan()){
					mydebitplan.checkOverdue();
				}else{
					System.out.println("正在还款的借款中没有逾期的借款！");
					Reporter.log("<br/>正在还款的借款中没有逾期的借款！");
				}
			}else{
				System.out.println("没有正在还款的借款！");
				Reporter.log("<br/>没有正在还款的借款！");
			}
		}
	}
	
	@Test(priority = 20) 
	//投资列表-债权推荐人详情页-检查借款管理信息中无逾期数据
	public void checkLoanManageInfo_web_426(){
		Reporter.log("检查投资列表-债权推荐人详情页-检查借款管理信息中无逾期数据");
		base.openBrowser(ListPage.EStarPlanUrl);
		if(ListPage.ifshowEStarPlan()){
			ListPage.clickFirstEStarTitle();
			DetailPage.clickCreditReferrerLnk();
			DetailPage.clickReferrerAddressLnk();
			ReferrerPage.checkLoanManageInfo();
		}else{
			System.out.println("翼星计划列表页没有产品！");
			Reporter.log("<br/>翼星计划列表页没有产品！");
		}
	}
	
	@Test(priority = 21) 
	//投资列表-翼星计划投资详情页-状态图显示与投资页面状态一致
	public void checkLoanManageInfo_web_427(){
		Reporter.log("检查投资列表-债权推荐人详情页-状态图显示与投资页面状态一致");
		base.openBrowser(ListPage.EStarPlanUrl);
		ListPage.clickIcon(ListPage.compluteIcon, DetailPage.compluteIcon);
		ListPage.clickIcon(ListPage.endIcon, DetailPage.endIcon);
		ListPage.clickIcon(ListPage.goingIcon, DetailPage.goingIcon);
	}
	
	@Test(priority = 22) 
	//投资列表-翼星计划投资详情页-检查投资人次、计划总额、资产包标题显示
	public void checkInvestInfo_web_428(){
		Reporter.log("投资列表-债权推荐人详情页-检查投资人次、计划总额、资产包标题显示");
		if(ListPage.ifshowEStarPlan()){
			String planmoney = base.getElementTextWithWait(ListPage.PlanMoney);
			ListPage.clickFirstEStarTitle();
			DetailPage.checkInvestInfo(planmoney);
		}else{
			System.out.println("翼星计划列表页没有产品！");
			Reporter.log("<br/>翼星计划列表页没有产品！");
		}
	}
	
	@Test(priority = 23) 
	//投资列表-翼星计划投资详情页-检查保障星—募集金额、利率、借款期限、清算方式跟列表页显示一致
	public void checkBZStarLoanInfo_web_429(){
		Reporter.log("投资列表-债权推荐人详情页-检查保障星—募集金额、利率、借款期限、清算方式跟列表页显示一致");
		base.openBrowser(ListPage.EStarPlanUrl);
		if(ListPage.ifshowEStarPlan()){
			ArrayList<String> BZInfo = ListPage.BZStarInfo();
			ListPage.clickFirstEStarTitle();
			DetailPage.checkBZStarLoanDetail(BZInfo);
		}else{
			System.out.println("翼星计划列表页没有产品！");
			Reporter.log("<br/>翼星计划列表页没有产品！");
		}
	}
	
	@Test(priority = 24) 
	//投资列表-翼星计划投资详情页-检查保障星—详情介绍
	public void checkBZStarDetailIntro_web_430(){
		Reporter.log("投资列表-债权推荐人详情页-检查保障星—详情介绍");
		if(DetailPage.ifinDetailPage()){
			DetailPage.checkBZStarDetailIntro(1);
		}else{	
			base.openBrowser(ListPage.EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.checkBZStarDetailIntro(2);
			}else{
				System.out.println("翼星计划列表页没有产品！");
				Reporter.log("<br/>翼星计划列表页没有产品！");
			}
		}

	}
	
	@Test(priority = 25) 
	//投资列表-翼星计划投资详情页-检查收益星—募集金额、利率、借款期限、清算方式跟列表页显示一致
	public void checkSYStarLoanInfo_web_434(){
		Reporter.log("投资列表-债权推荐人详情页-检查收益星的募集金额、利率、借款期限、清算方式跟列表页显示一致");
		base.openBrowser(ListPage.EStarPlanUrl);
		if(ListPage.ifshowEStarPlan()){
			ArrayList<String> SYInfo = ListPage.SYStarInfo();
			ListPage.clickFirstEStarTitle();
			DetailPage.checkSYStarLoanDetail(SYInfo);
		}else{
			System.out.println("翼星计划列表页没有产品！");
			Reporter.log("<br/>翼星计划列表页没有产品！");
		}
	}
	
	@Test(priority = 26) 
	//投资列表-翼星计划投资详情页-检查收益星—详情介绍
	public void checkSYStarDetailIntro_web_436(){
		Reporter.log("投资列表-债权推荐人详情页-检查收益星的详情介绍");
		if(DetailPage.ifinDetailPage()){
			DetailPage.checkSYStarDetailIntro(1);
		}else{
			base.openBrowser(ListPage.EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.checkSYStarDetailIntro(2);
			}else{
				System.out.println("翼星计划列表页没有产品！");
				Reporter.log("<br/>翼星计划列表页没有产品！");
			}
		}
	}
	
	@Test(priority = 27) 
	//投资列表-翼星计划投资详情页-检查详细规则中的数据显示
	public void checkDetailedRulesData_web_439(){
		Reporter.log("投资列表-债权推荐人详情页-检查详细规则中的数据显示");
		if(DetailPage.ifinDetailPage()){
			DetailPage.clickDetailedRulesLnk();
			DetailPage.checkDetailedRulesData(1);
		}else{
			base.openBrowser(ListPage.EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.checkDetailedRulesData(2);
			}else{
				System.out.println("翼星计划列表页没有产品！");
				Reporter.log("<br/>翼星计划列表页没有产品！");
			}
		}
	}
	
	@Test(priority = 28, enabled = false) //“投资评论”已在现网去掉，该用例废弃
	//投资列表-翼星计划投资详情页-检查未登录时投资评论
	public void checkComment_web_456(){
		Reporter.log("投资列表-债权推荐人详情页-检查未登录时投资评论");
		base.logout();
		base.openBrowser(ListPage.EStarPlanUrl);
		if(ListPage.ifshowEStarPlan()){
			ListPage.clickFirstEStarTitle();
			DetailPage.clickInvestCommentLnk();
			DetailPage.checkCommentwithoutLogin();
		}else{
			System.out.println("翼星计划列表页没有产品！");
			Reporter.log("<br/>翼星计划列表页没有产品！");
		}	
	}
	
	@Test(priority = 29, enabled = false)  //“投资评论”已在现网去掉，该用例废弃
	//投资列表-翼星计划投资详情页-检查登录时投资评论
	public void checkCommentwithLogin_web_456(){
		Reporter.log("投资列表-债权推荐人详情页-检查登录时投资评论");
		loginpage.loginByMyAccount(Data.tel_Loan, Data.password);
		if(DetailPage.ifinDetailPage()){
			DetailPage.clickInvestCommentLnk();
			DetailPage.checkCommentwithLogin(1);
		}else{
			base.openBrowser(ListPage.EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.clickInvestCommentLnk();
				DetailPage.checkCommentwithLogin(2);
			}
		}
	}

}
