package com.eloancn.suites.debit;

//import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyDebitPlan;
import com.eloancn.shared.pages.MyLoanPage;
import com.eloancn.shared.pages.SecurityAuthPage;

public class Debit2 {
//	static Logger logger = Logger.getLogger(Debit2.class); 
	
	Base base = new Base();
	MyAccountPage myAccountPage = new MyAccountPage();
	LoginPage loginPage = new LoginPage();
	MyLoanPage myLoanPage = new MyLoanPage();
	MyDebitPlan myDebitPlan = new MyDebitPlan();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	
	public String tel = Data.tel;//13611111116
	String password = Data.password;
	String zzmm = Data.zzmm;
	String idCard = new Data().idConcatenation();
	String bankAccount = Data.bankAccount;
	String realName = "";
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_tel;
			password = Data.test_password;
			zzmm = Data.test_zzmm;
			realName = Data.test_realName;
		}else {
			tel = Data.tel_run_debit2;
			realName = Data.realName_run_debit2;
			idCard = Data.idCard_run_debit2;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * 徐天元
	 * 视频认证
	 */
	@Test (priority = 1)
	public void videoIdentification_AT_468(){
		Reporter.log("借入流程：安全中心-视频认证");
		//base.openBrowser("http://www.eloancn.com/page/userMgr/myHome.jsp");
		//loginPage.loginWithNoFrame("13834569527", "13834569527");//"13111111138"  "13834569527", "13834569527"
		
		//indexPage.clickMenu("我的账户");
		loginPage.loginWithNoFrame(tel, password);
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.clickVideoIdentificationBtn();
		securityAuthPage.videoIdentification();
		securityAuthPage.isVideoIdentificationOK();
	}
	
	/**
	 * 徐天元
	 * 申请借款
	 */
	@Test (priority = 2)
	public void loanApplication1_AT_469(){
		Reporter.log("借入流程：我的借入--申请借款，房抵标");
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.loanApplication(true, false, "房抵标", "500", "6个月","", "16", "5", "满标", "bj", "个人消费", tel+"自动化测试：走网站流程--普通标", "自动化测试：借入者申请担保，同城担保人同意并借款成功后，给予同城担保人实际借款金额2%的费用。同时，使您能够快速足额的借到所需的借款。");
		loanApplicationPage.isLoanApplicationOK();
	}
	
	/**
	 * 徐天元
	 * 申请借款
	 */
	@Test (priority = 3)
	public void loanApplication2_AT_470(){
		Reporter.log("借入流程：我的借入--申请借款，车抵标");
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.loanApplication(true, false, "车抵标", "500", "6个月","", "18", "7", "满标", "fx", "生意周转", tel+"自动化测试：走网站流程--车抵标", "自动化测试：借入者申请担保，同城担保人同意并借款成功后，给予同城担保人实际借款金额2%的费用。同时，使您能够快速足额的借到所需的借款。");
		loanApplicationPage.isLoanApplicationOK();
	}
	
	/**
	 * 徐天元
	 * 翼星计划 我的借入计划 申请贷款
	 */
	@Test (priority = 4)
	public void shenQingDaikuan_AT_471(){
		Reporter.log("借入流程：我的借入--我的借款--已发布的借款，标都被投满，总部终审时初审通过，点击确认借款，开通手机快捷还款，录制确认视频，点击“同意借款”");
		myAccountPage.turnToMyAccount("我的借入计划");
		myDebitPlan.clickShenQingDaiKuan();
		myDebitPlan.shenQingDaiKuan("1000","企业","6个月","个人消费","自动化测试：翼星计划--企业标","自动化测试：翼星计划--企业标翼星计划--企业标翼星计划--企业标翼星计划--企业标翼星计划--企业标翼星计划--企业标翼星计划--企业标翼星计划--企业标");
		myDebitPlan.isShenQingDaiKuanOK();
	}
	
	/**
	 * 徐天元
	 * 我的借入--我的借款--已发布的借款--确认借贷
	 */
	@Test (priority = 5)
	public void sureDebit_AT_472(){
		Reporter.log("借入流程：翼星计划--我的借入计划,申请贷款,发布");
		myAccountPage.turnToMyAccount("我的借款");
		//已发布的借款
		myLoanPage.clickPublishedTab();
		base.sleep(3000);
		if (myLoanPage.isDisplayed("确认借贷")) {
			//点击“确认借贷”
			myLoanPage.sureDebit();
			if (myLoanPage.isDisplayed("开通手机快捷还款业务")) {
				//点击“开通手机快捷还款业务”
				myLoanPage.clickBtn_SureDebit("开通手机快捷还款业务");
				//开通手机快捷还款业务
				myLoanPage.openMobilePay(idCard,bankAccount,tel,"北京市","北京市","北三环支行");//idcard
				//"110106193710137259","622848181111111","13111111154","北京市","北京市","北三环支行"
				//是否手机开通快捷还款成功
				myLoanPage.isOpenMobilePayOK(realName);
//				logger.info("<开通手机快捷还款业务>成功");
				Reporter.log("<开通手机快捷还款业务>成功");
			}
			if(myLoanPage.isDisplayed("录制标确认视频")){
				//点击  录制标确认视频
				myLoanPage.clickBtn_SureDebit("录制标确认视频");
				securityAuthPage.videoIdentification();
				myLoanPage.closeVedio();
				myLoanPage.isVedioOK();
//				logger.info("<录制标确认视频>成功");
				Reporter.log("<录制标确认视频>成功");
			}
			myLoanPage.agree();
//			logger.info("<同意>成功");
			Reporter.log("<同意>成功");
		}else {
//			logger.info("没有<确认借贷>");
			Reporter.log("没有<确认借贷>");
		}
	}	
}
