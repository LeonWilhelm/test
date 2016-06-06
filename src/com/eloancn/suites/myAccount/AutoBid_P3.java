package com.eloancn.suites.myAccount;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.AutoBidPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.SBInvestPage;

public class AutoBid_P3 {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	AutoBidPage autoBidPage = new AutoBidPage();
	IndexPage indexPage = new IndexPage();
	SBInvestPage sbInvestPage = new SBInvestPage();
	
	String tel = "13111111201";
	String zfmm = "111111";
	String password = Data.password;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_tel;
			zfmm = Data.test_zzmm;
			password = Data.test_password;
		}
	}

	@AfterClass
	public void teardownAfter(){
		//关闭自动投标
		myAccountPage.turnToMyAccount("自动投标");
 		if(autoBidPage.ifAutoBidOpen()){
 			autoBidPage.clickCloseAutoBidBtn();
 		}
		base.tearDown();
	}
	
	@Test(priority = 1)
	public void checkMoney_web_3941(){
		Reporter.log("自动投标P3:我的账户-自动投标，点击“我的贷出”-“投资列表”的“自动投标”,正确显示默认的“自动投标设置”项<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标，检查默认值是否符合需求<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		//检查默认值是否符合需求
		myAccountPage.turnToMyAccount("我的账户");
		double balance = myAccountPage.getBalance();
		myAccountPage.turnToMyAccount("自动投标");
		autoBidPage.clickAutoBidBtn();
		autoBidPage.verifyAutoBidSet(balance);
		//自动投标设置
		String reserveMoney = autoBidPage.checkFixedAmountBid(zfmm);
		//点击“我的贷出”-“投资列表”的“自动投标”
		indexPage.clickMenu("投资列表");
		sbInvestPage.clickAutoBidBtn();
		autoBidPage.verifyFixedAmountBid(reserveMoney);
		//关闭自动投标
		autoBidPage.clickCloseAutoBidBtn();
	}
	
	@Test(priority = 2)
	public void checkMoney_web_3942(){
		Reporter.log("自动投标P3:我的账户-自动投标-账户保留金额,保持默认直接点击确定按钮,提示：请输入账户保留金额<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-账户保留金额,在账户保留金额文本框中输入负数,自动转换成正数<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-账户保留金额,在账户保留金额文本框中输入小数点击确定按钮,自动转换成正数<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-账户保留金额,在账户保留金额文本框中输入字母、汉字、特殊符号点击确定按钮,自动取消输入的非数字字符<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-账户保留金额,在账户保留金额文本框输入大于账户可用余额的正整数点击确定按钮,提示您的账户保留金额不应该大于您的账户可用金额！<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-账户保留金额,在账户保留金额文本框输入小于账户可用余额的正整数点击确定按钮,提示支付密码不能为空！<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		//账户保留金额,保持默认直接点击确定按钮,提示：请输入账户保留金额
		myAccountPage.turnToMyAccount("自动投标");
		autoBidPage.clickAutoBidBtn();
		autoBidPage.clickOKBtn("请填写：您的账户保留金额！");
		//账户保留金额,在账户保留金额文本框中输入负数,自动转换成正数
		autoBidPage.inputReserveMoney("-");
		autoBidPage.checkReserveMoney("");
		//账户保留金额,在账户保留金额文本框中输入小数点击确定按钮,自动转换成正数
		autoBidPage.inputReserveMoney(".");
		autoBidPage.checkReserveMoney("");
		//账户保留金额,在账户保留金额文本框中输入字母、汉字、特殊符号点击确定按钮,自动取消输入的非数字字符
		autoBidPage.inputReserveMoney("s");
		autoBidPage.checkReserveMoney("");
		autoBidPage.inputReserveMoney("三");
		autoBidPage.checkReserveMoney("");
		autoBidPage.inputReserveMoney("@");
		autoBidPage.checkReserveMoney("");
		//账户保留金额,在账户保留金额文本框输入大于账户可用余额的正整数点击确定按钮,提示您的账户保留金额不应该大于您的账户可用金额！
		autoBidPage.inputReserveMoney("big");
		autoBidPage.clickOKBtn("您的账户保留金额不应该大于您的账户可用金额！");
		//账户保留金额,在账户保留金额文本框输入小于账户可用余额的正整数点击确定按钮,提示支付密码不能为空！
		autoBidPage.InputReserveMoney();
		autoBidPage.clickOKBtn("支付密码不能为空！");
	}
	
	@Test(priority = 3)
	public void checkPassword_web_3943(){
		Reporter.log("自动投标P3:我的账户-自动投标-支付密码,输入错误的支付密码，点击“确定”按钮,提示：支付密码错误<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-支付密码,输入小于6个字符的支付密码，点击“确定”按钮,提示：支付密码不得小于六个字符<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-支付密码,输入大于20个字符支付密码,无法输入超过20个字符<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-支付密码,输入正确的支付密码点击“确定”按钮,提示：开启自动投标成功<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-支付密码,在自动投标开启成功提示框中点击“确定”按钮,自动投标设置界面变为不可编辑状态，显示排名和开启状态<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		//支付密码,输入错误的支付密码，点击“确定”按钮,提示：支付密码错误
		myAccountPage.turnToMyAccount("自动投标");
		autoBidPage.clickAutoBidBtn();
		autoBidPage.InputReserveMoney();
		autoBidPage.InputPayPwd("123456");
		autoBidPage.clickOKBtn("支付密码错误！");
		//支付密码,输入小于6个字符的支付密码，点击“确定”按钮,提示：支付密码不得小于六个字符
		autoBidPage.InputPayPwd("11111");
		autoBidPage.clickOKBtn("支付密码不得小于六位字符！");
		autoBidPage.checkPwdLength();
		//支付密码,输入正确的支付密码点击“确定”按钮,提示：开启自动投标成功
		autoBidPage.InputPayPwd(zfmm);
		autoBidPage.clickOKBtn();
		autoBidPage.clickCloseAutoBidBtn();
	}
	
	@Test(priority = 4)
	public void checkCreditRatingRange_web_3944(){
		Reporter.log("自动投标P3:我的账户-自动投标-信用等级范围下拉列表,点击信用等级范围下拉框,可以弹出下拉列表<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-信用等级范围下拉列表,最小范围选择最大值，点击最大范围选择除最大值之外的所有值列表项,不允许选择，默认显示最大值<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-信用等级范围下拉列表,最小值和最大值都选择最大值,可以选择<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-信用等级范围下拉列表,最大范围选择最小值，最小范围选择除最小值之外的值,不允许选择，点击无反应<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-信用等级范围下拉列表,都选择最小值，可以选择<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-信用等级范围下拉列表,选最小值小于最大值，可以选择<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		myAccountPage.turnToMyAccount("自动投标");
		autoBidPage.clickAutoBidBtn();
		//最小范围选择最大值，点击最大范围选择除最大值之外的所有值列表项,不允许选择，默认显示最大值
		autoBidPage.selectLowLevel("AAA");
		autoBidPage.selectHighLevel("A");
		autoBidPage.checkCreditRatingRange("high","AAA");
		autoBidPage.clickCancelBtn();
		//最小值和最大值都选择最大值,可以选择
		autoBidPage.clickAutoBidBtn();
		autoBidPage.selectLowLevel("AAA");
		autoBidPage.selectHighLevel("AAA");
		autoBidPage.checkCreditRatingRange("high","AAA");
		autoBidPage.clickCancelBtn();
		//最大范围选择最小值，最小范围选择除最小值之外的值,不允许选择，点击无反应
		autoBidPage.clickAutoBidBtn();
		autoBidPage.selectLowLevel("HR");
		autoBidPage.selectHighLevel("HR");
		autoBidPage.checkCreditRatingRange("low","HR");
		autoBidPage.selectLowLevel("D");
		autoBidPage.checkCreditRatingRange("low","HR");
		autoBidPage.clickCancelBtn();
		//都选择最小值，可以选择
		autoBidPage.clickAutoBidBtn();
		autoBidPage.selectHighLevel("HR");
		autoBidPage.selectLowLevel("HR");
		autoBidPage.checkCreditRatingRange("low","HR");
		autoBidPage.clickCancelBtn();
		//选最小值小于最大值，可以选择
		autoBidPage.clickAutoBidBtn();
		autoBidPage.selectLowLevel("B");
		autoBidPage.selectHighLevel("A");
		autoBidPage.checkCreditRatingRange("high","A");
		autoBidPage.clickCancelBtn();
	}
	                                                                   
	@Test(priority = 5)
	public void checkBidMoney_web_3945(){
		Reporter.log("自动投标P3:我的账户-自动投标-选择固额投标，投标金额输入为空点击“确定”按钮，提示请填写：每次投标金额！<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-选择固额投标，投标金额输入金额小于50点击“确定”按钮，提示每次投标金额必须是50的倍数<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-选择固额投标，投标金额 输入金额为小数点击“确定”按钮，自动取消小数点<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-选择固额投标，投标金额输入金额为负数点击“确定”按钮，自动取消负号<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-选择固额投标，投标金额输入字母、汉字点击“确定”按钮，自动取消字母、汉子<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		//选择固额投标，投标金额输入为空点击“确定”按钮，提示请填写：每次投标金额！
		myAccountPage.turnToMyAccount("自动投标");
		autoBidPage.clickAutoBidBtn();
		autoBidPage.chooseFixedAmountBid();
		autoBidPage.clickOKBtn("请填写：每次投标金额！");
		//选择固额投标，投标金额输入金额小于50点击“确定”按钮，提示每次投标金额必须是50的倍数
		autoBidPage.InputBidMoney("49");
		autoBidPage.clickOKBtn("每次投标金额必须是50的倍数");
		int money = autoBidPage.getBalance()/50*50+50;
		autoBidPage.InputBidMoney(money+"");
		autoBidPage.clickOKBtn("您的每次投标金额不应该大于您的账户可用金额！");
		//选择固额投标，投标金额 输入金额为小数点击“确定”按钮，自动取消小数点
		autoBidPage.InputBidMoney("1.1");
		autoBidPage.checkBidMoney("11");
		//选择固额投标，投标金额输入金额为负数点击“确定”按钮，自动取消负号
		autoBidPage.InputBidMoney("-");
		autoBidPage.checkBidMoney("");
		//选择固额投标，投标金额输入字母、汉字点击“确定”按钮，自动取消字母、汉子
		autoBidPage.InputBidMoney("s");
		autoBidPage.checkBidMoney("");
		autoBidPage.InputBidMoney("大");
		autoBidPage.checkBidMoney("");
	}
	
	@Test(priority = 6)
	public void checkLiLv_web_3946(){
		Reporter.log("自动投标P3:我的账户-自动投标-年利率范围，最小值输入为空，其他项填写正确点击“确定”按钮，提示：年利率最小值不对，10%-22%为有效利率范围！<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-年利率范围，年利率最大值输入为空，其他项填写正确点击“确定”按钮，提示：年利率最大值不对，10%-22%为有效利率范围！<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-年利率范围，年利率最小值输入小于10大于22的正整数，其他项填写正确点击“确定”按钮，提示年利率最小值不对，10%-22%为有效利率范围！<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-年利率范围，年利率最大值输入小于10大于22的正整数，其他项填写正确点击“确定”按钮，提示：年利率最大值不对，10%—22%为有效值<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-年利率范围，年利率文本框输入三位数，无法输入三位数，只能输入两位数<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-年利率范围，输入正确的年利率范围，其他项填写正确点击“确定”按钮，开启自动投标成功（数据填写正确）<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		myAccountPage.turnToMyAccount("自动投标");
		autoBidPage.clickAutoBidBtn();
		//年利率范围，最小值输入为空，其他项填写正确点击“确定”按钮，提示：年利率最小值不对，10%-22%为有效利率范围！
		autoBidPage.InputLowInterest("");
		autoBidPage.clickOKBtn("年利率最小值不对，10%-22%为有效利率范围！");
		//年利率范围，年利率最大值输入为空，其他项填写正确点击“确定”按钮，提示：年利率最大值不对，10%-22%为有效利率范围！
		autoBidPage.InputLowInterest("10");
		autoBidPage.InputHighInterest("");
		autoBidPage.clickOKBtn("年利率最大值不对，10%-22%为有效利率范围！");
		//年利率最小值输入小于10大于22的正整数，其他项填写正确点击“确定”按钮，提示年利率最小值不对，10%-22%为有效利率范围！
		autoBidPage.InputLowInterest("9");
		autoBidPage.clickOKBtn("年利率最小值不对，10%-22%为有效利率范围！");
		autoBidPage.InputLowInterest("23");
		autoBidPage.clickOKBtn("年利率最小值不对，10%-22%为有效利率范围！");
		//年利率范围，年利率最大值输入小于10大于22的正整数，其他项填写正确点击“确定”按钮，提示：年利率最大值不对，10%—22%为有效值
		autoBidPage.InputLowInterest("10");
		autoBidPage.InputHighInterest("9");
		autoBidPage.clickOKBtn("年利率最大值不对，10%-22%为有效利率范围！");
		autoBidPage.InputHighInterest("23");
		autoBidPage.clickOKBtn("年利率最大值不对，10%-22%为有效利率范围！");
		//年利率范围，年利率文本框输入三位数，无法输入三位数，只能输入两位数
		autoBidPage.InputLowInterest("101");
		autoBidPage.InputHighInterest("221");
		autoBidPage.checkInterest("low","10");
		autoBidPage.checkInterest("high","22");
		//年利率范围，输入正确的年利率范围，其他项填写正确点击“确定”按钮，开启自动投标成功（数据填写正确）
		autoBidPage.checkBalanceBid(zfmm);
		autoBidPage.clickCloseAutoBidBtn();
	}
	
	@Test(priority = 7)
	public void checkQiXian_web_3947(){
		Reporter.log("自动投标P3:我的账户-自动投标-借款期限，点击借款期限最小值或最大值文本框，弹出下拉列表项<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-借款期限，最小值选择24个月选择最大值，最大值只能选择24个月，其他点击无反应<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-借款期限，最大值选择2个月选择最小值,最小值只能选择2个月，其他点击无反应<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-借款期限，最小值选择2个月选择最大值,最大值可以任意选择<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-借款期限，最大值选择24个月选择最小值,最小值可以任意选择<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		//借款期限，最小值选择24个月选择最大值，最大值只能选择24个月，其他点击无反应
		myAccountPage.turnToMyAccount("自动投标");
		autoBidPage.clickAutoBidBtn();
		autoBidPage.selectShortLoanTime("24");
		autoBidPage.selectLongLoanTime("24");
		autoBidPage.checkLoanTime("long","24");
		autoBidPage.selectLongLoanTime("21");
		autoBidPage.checkLoanTime("long","24");
		//借款期限，最大值选择2个月选择最小值,最小值只能选择2个月，其他点击无反应
		autoBidPage.selectShortLoanTime("2");
		autoBidPage.selectLongLoanTime("2");
		autoBidPage.selectShortLoanTime("2");
		autoBidPage.checkLoanTime("short","2");
		autoBidPage.selectLongLoanTime("3");
		autoBidPage.checkLoanTime("short","2");
		//借款期限，最小值选择2个月选择最大值,最大值可以任意选择
		autoBidPage.selectShortLoanTime("2");
		autoBidPage.selectLongLoanTime("2");
		autoBidPage.checkLoanTime("long","2");
		autoBidPage.selectLongLoanTime("24");
		autoBidPage.checkLoanTime("long","24");
		//借款期限，最大值选择24个月选择最小值,最小值可以任意选择
		autoBidPage.selectLongLoanTime("24");
		autoBidPage.selectShortLoanTime("2");
		autoBidPage.checkLoanTime("short","2");
		autoBidPage.selectShortLoanTime("24");
		autoBidPage.checkLoanTime("short","24");
	}
	
	@Test(priority = 8)
	public void checkRepaymentMethod_web_3948(){
		Reporter.log("自动投标P3:我的账户-自动投标-还款方式，勾选等额本金前复选框，可勾选<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-还款方式，勾选等额本息前复选框，可勾选<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-还款方式，勾选还本付息前复选框，可勾选<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-还款方式，同时勾选三种还款方式复选框，可勾选<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-还款方式，勾选任意两种还款方式复选框，可勾选<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		myAccountPage.turnToMyAccount("自动投标");
		autoBidPage.clickAutoBidBtn();
		//还款方式，勾选等额本金前复选框，可勾选
		autoBidPage.checkMatchPrincipal();
		autoBidPage.checkRepaymentMethod("等额本金");
		//还款方式，勾选等额本息前复选框，可勾选
		autoBidPage.checkMatchPrincipal();
		autoBidPage.checkMatchPI();
		autoBidPage.checkRepaymentMethod("等额本息");
		//还款方式，勾选还本付息前复选框，可勾选
		autoBidPage.checkMatchPI();
		autoBidPage.checkRepayPI();
		autoBidPage.checkRepaymentMethod("还本付息");
		//还款方式，同时勾选三种还款方式复选框，可勾选
		autoBidPage.checkMatchPrincipal();
		autoBidPage.checkMatchPI();
		autoBidPage.checkRepaymentMethod("等额本金");
		autoBidPage.checkRepaymentMethod("等额本息");
		autoBidPage.checkRepaymentMethod("还本付息");
		//还款方式，勾选任意两种还款方式复选框，可勾选
		autoBidPage.checkMatchPrincipal();
		autoBidPage.checkRepaymentMethod("等额本息");
		autoBidPage.checkRepaymentMethod("还本付息");
		autoBidPage.checkMatchPrincipal();
		autoBidPage.checkMatchPI();
		autoBidPage.checkRepaymentMethod("等额本金");
		autoBidPage.checkRepaymentMethod("还本付息");
		autoBidPage.checkRepayPI();
		autoBidPage.checkMatchPI();
		autoBidPage.checkRepaymentMethod("等额本金");
		autoBidPage.checkRepaymentMethod("等额本息");
	}
	
	@Test(priority = 9)
	public void checkParticipationMode_web_3949(){
		Reporter.log("自动投标P3:我的账户-自动投标-参与方式，点击余额投标前单选钮，可选择<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-参与方式，点击固额投标前单选钮，可选择<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标-参与方式，同时选择两种投标方式单选钮，不可同时选择，只能选择一项<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		myAccountPage.turnToMyAccount("自动投标");
		autoBidPage.clickAutoBidBtn();
		//参与方式，点击余额投标前单选钮，可选择  参与方式，同时选择两种投标方式单选钮，不可同时选择，只能选择一项
		autoBidPage.chooseBalanceBid();
		autoBidPage.checkParticipationMode("余额");
		//参与方式，点击固额投标前单选钮，可选择  参与方式，同时选择两种投标方式单选钮，不可同时选择，只能选择一项
		autoBidPage.chooseFixedAmountBid();
		autoBidPage.checkParticipationMode("固额");
	}
	
	@Test(priority = 10)
	public void checkAutoBid_web_3950(){
		Reporter.log("自动投标P3:我的账户-自动投标，1.点击开启自动投标按钮，显示自动投标设置界面<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标，2.填写正确的设置信息点击“确定”按钮，弹出开启自动投标成功提示框<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标，3-1.点击提示框中“确定”按钮，设置界面变为不可编辑并显示排名和开启状态<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标，4-1.在自动投标设置界面点击“修改自动投标”按钮，设置界面变为可编辑状态<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标，4-2.选择参与方式为“固额投标”方式，投标金额文本框默认显示100<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标，4-3.输入支付密码点击“确定”按钮，弹出修改成功提示框<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标，4-4.在提示框中点击“确定”按钮，设置界面变为不可编辑状态,更新修改过的功能项,条件设置记录中更新修改过功能项详情<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标，5-1.在自动投标中设置界面点击“关闭自动投标”按钮，弹出确认关闭提示框<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标，5-2.点击提示框中的“取消”按钮，提示框关闭关闭不做任何修改<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标，5-3.点击提示框中的“确定”按钮，弹出成功提示框<br/>");
		Reporter.log("自动投标P3:我的账户-自动投标，5-4.在成功提示框中点击“确定”按钮，自动投标设置页面变成未开启时的初始页面,条件设置记录列表中开启记录状态变为关闭，在操作时间列增加关闭时间，且设置详情变为空<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(tel, password);
		}
		myAccountPage.turnToMyAccount("自动投标");
		autoBidPage.clickAutoBidBtn();
		//1.点击开启自动投标按钮，显示自动投标设置界面
		autoBidPage.checkAutoBidPage();
		//2.填写正确的设置信息点击“确定”按钮，弹出开启自动投标成功提示框
		//3-1.点击提示框中“确定”按钮，设置界面变为不可编辑并显示排名和开启状态
	 	if(autoBidPage.ifshowAutoBidSetLnk()){
	 		autoBidPage.clickAutoBidBtn();
	 		autoBidPage.checkBalanceBid(zfmm);
	 		autoBidPage.checkEdit(false);
	 	}else{
	 		System.out.println("固额投标的权限不够！");
	 		Reporter.log("<br/>固额投标的权限不够！");
	 	}
	 	//4-1.在自动投标设置界面点击“修改自动投标”按钮，设置界面变为可编辑状态
	 	autoBidPage.clickUpdate();
	 	autoBidPage.checkEdit(true);
	 	//4-2.选择参与方式为“固额投标”方式，投标金额文本框默认显示100
	 	autoBidPage.chooseFixedAmountBid();
	 	autoBidPage.checkBidMoney("100");
	 	//4-3.输入支付密码点击“确定”按钮，弹出修改成功提示框
	 	autoBidPage.InputPayPwd(zfmm);
	 	autoBidPage.selectLowLevel("D");
	 	autoBidPage.selectHighLevel("A");
	 	autoBidPage.InputLowInterest("11");
	 	autoBidPage.InputHighInterest("13");
	 	autoBidPage.checkMatchPrincipal();
	 	autoBidPage.selectShortLoanTime("4");
	 	autoBidPage.selectLongLoanTime("11");
	 	String reserveMoney = autoBidPage.getReserveMoney();
	 	System.out.println(reserveMoney);
	 	//4-4.在提示框中点击“确定”按钮，设置界面变为不可编辑状态,更新修改过的功能项,条件设置记录中更新修改过功能项详情
	 	if (!autoBidPage.clickOKBtn()) {
	 		reserveMoney = "900000";
		}
	 	autoBidPage.checkEdit(false);
	 	String values[] = {"D-A","11-13%","等额本息,还本付息","4个月-11个月","固额投标","100元",reserveMoney};
	 	autoBidPage.verifyFixedAmountBid(values);
	 	//5-1.在自动投标中设置界面点击“关闭自动投标”按钮，弹出确认关闭提示框
	 	Alert close = autoBidPage.closeConfirm();
	 	//5-2.点击提示框中的“取消”按钮，提示框关闭关闭不做任何修改
	 	close.dismiss();
	 	//5-3.点击提示框中的“确定”按钮，弹出成功提示框
	 	//5-4.在成功提示框中点击“确定”按钮，自动投标设置页面变成未开启时的初始页面,条件设置记录列表中开启记录状态变为关闭，在操作时间列增加关闭时间，且设置详情变为空
	 	autoBidPage.clickCloseAutoBidBtn();
	 	base.assertTrueByBoolean(autoBidPage.ifshowAutoBidSetLnk());
	}
}
