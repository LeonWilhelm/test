package com.eloancn.shared.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;

/**
 * 首页
 */
public class IndexPage {

	Base base = new Base();
	Data data = new Data();

	RegisterPage registerPage = new RegisterPage();
	InvestmentDetailPage investmentDetailPage = new InvestmentDetailPage();
	
	public By registerLinkXpath = By.cssSelector("#login_2 > a");//By.xpath("//a[text()='注册']");
	//首页的点击导航栏下面的广告条中的免费注册按钮
	By freeRegisterBtn = By.cssSelector(".regLoading_btn.fl");
	By loginBtn = By.cssSelector("#login_1 > a");  //#login_1 > a   #login_1>.colorFc
	public static By userName = By.id("accountRealName");
	By joinIn = By.xpath("//li/a[text()='招商合作']");						//我要加盟
	By forumLink = By.xpath("//a[text()='论坛']");						//论坛
	
	/******************************/
	/*********   顶部导航        **********/
	/******************************/
	
	By credit = By.cssSelector("#load > a");										//我要贷出
	By eCuBao = By.cssSelector("#load > ul > li:nth-child(1) > a");					//翼存宝
	By eStarPlan = By.cssSelector("#load > ul > li:nth-child(2) > a");				//翼星计划
	By investmentList = By.cssSelector("#load > ul > li:nth-child(3) > a");			//散标列表
	By howLending = By.cssSelector("#load > ul > li:nth-child(4) > a");				//如何贷出
	By toolBox = By.cssSelector("#load > ul > li:nth-child(5) > a");				//工具箱
	
	By debit = By.cssSelector("#loan > a");											//我要借入
	By borrow = By.cssSelector("#loan > ul > li:nth-child(1) >a");					//申请借入
	By howBorrow = By.cssSelector("#loan > ul > li:nth-child(2) >a");				//如何借入
	By welfareLoan = By.cssSelector("#loan > ul > li:nth-child(3) >a");				//公益贷	
	
	By noviceArea = By.cssSelector("#newUserLink");									//新手专区
	
	By debentureTransfer = By.cssSelector("#loadAll > a");							//债权转让
	By transferList = By.cssSelector("#loadAll > ul > li:nth-child(1) > a");		//转让列表
	By howTransfer = By.cssSelector("#loadAll > ul > li:nth-child(2) > a");			//如何转让
	
	By aboutUs = By.cssSelector("#about > a");											//关于我们
	By aboutUsContent = By.cssSelector("#contentPanel span.wd110");
	By companyIntroduction = By.cssSelector("#about > ul > li:nth-child(1) > a");		//公司介绍
	By companyIntroductionContent = By.cssSelector("#contentPanel span.wd110");
	By leaderIntroduction = By.cssSelector("#about > ul > li:nth-child(2) > a");		//领导介绍
	By leaderIntroductionContent = By.cssSelector("#contentPanel span.wd110");
	By companyPhilosophy = By.cssSelector("#about > ul > li:nth-child(3) > a");			//公司理念
	By companyPhilosophyContent = By.cssSelector("#contentPanel div:nth-child(1) span");
	By recruit = By.cssSelector("#about > ul > li:nth-child(4) > a");					//招贤纳士
	By recruitContent = By.cssSelector("#contentPanel span.wd110");
	By contactUs = By.cssSelector("#about > ul > li:nth-child(5) > a");					//联系我们
	By contactUsContent = By.cssSelector("#contentPanel span.wd110");
	
	By myAccount = By.cssSelector("#about ~ li >a");						//我的账户
	By myAccountBtn = By.xpath("//li/a[text()='我的账户']");					//我的账户
	
	/******************************/
	/********    banner   *********/
	/******************************/


	
	/******************************/
	/********    普惠金融           *********/
	/******************************/
	
	By financeImg = By.cssSelector(".wrap.overflowV > div:nth-child(1) div.phjr_img");	//普惠金融_图片
	By financeInfo = By.cssSelector(".wrap.overflowV div.phjr_info1.bgf60");			//普惠金融_内容
	
	By profitImg = By.cssSelector(".wrap.overflowV > div:nth-child(2) div.phjr_img");	//收益可观图片
	By profitInfo = By.cssSelector(".wrap.overflowV div.phjr_info.bge2");				//收益可观内容
	
	By securityImg = By.cssSelector(".wrap.overflowV > div:nth-child(3) div.phjr_img");	//安全保障图片
	By securityInfo = By.cssSelector(".wrap.overflowV div.phjr_info.bg40");				//安全保障内容
	
	By patternImg = By.cssSelector(".wrap.overflowV > div:nth-child(4) div.phjr_img");	//同城模式图片
	By patternInfo = By.cssSelector(".wrap.overflowV div.phjr_info1.bg7c");				//同城模式内容
	
	By brandImg = By.cssSelector(".wrap.overflowV > div:nth-child(5) div.phjr_img");	//品牌权威图片
	By brandInfo = By.cssSelector(".wrap.overflowV div.phjr_info1.bgf30");				//品牌权威内容
	
	/******************************/
	/********    收益计算器       *********/
	/******************************/
	
	By incomeCalculatorBtn = By.xpath("//a[text()='收益计算器']");									//收益计算器
	By incomeCalculatorH1 = By.xpath("//div[@class='count-tit']//h1");							//收益计算器窗口Title
	By investmentMoneyTxt = By.xpath("//th[@class='wd80']/parent::tr//input[@name='money']");	//投资金额
	By annualInterestRateTxt = By.xpath("//input[@name='rate']");								//年利率
	By investmentPeriodTxt = By.xpath("//input[@name='phases']");								//投资期限
	By repaymentDrop = By.xpath("//select[@name='type']");										//还款方式
	By showScheduleChk = By.xpath("//input[@id='intercheck']");									//显示计划时间表
	By immediatelyCalculateBtn = By.xpath("//a[text()='马上计算']");								//马上计算
	//月收取利息 
	String monthlyInterest = "";
	By monthlyInterestTxt = By.xpath("//td[text()='" + monthlyInterest + "]/parent::tr//td[3]");
	//月收取总额
	String monthlyTotal  = "";
	By monthlyTotalTxt = By.xpath("//td[text()='" + monthlyInterest + "]/parent::tr//td[5]");
	
	/******************************/
	/***    翼存宝_散标投资_翼星计划          ***/
	/******************************/
	
	By productTitle = By.cssSelector(".index_part_title>h2");		//Title(翼存宝，散标投资，翼星计划)
	By productMoreLink = By.cssSelector(".hFP_index_more>a");		//查看更多(查看更多翼存宝项目，查看更多散标项目，查看更多翼星计划项目)
	By productTable = By.cssSelector(".index_table > tbody"); 		//数据表格
	
	/******************************/
	/********     翼存宝            *********/
	/******************************/
	
	By loginTitle = By.xpath("//span[@class='fl font20']");														//登录窗口标题
	By closeBtn = By.xpath("//a[@class='close']");																//登录窗口关闭按钮
	
	/******************************/
	/******   翼存宝_第一条数据       *******/
	/******************************/
	
	By eCunBaoDataHomeId = By.xpath("//div[@class='hFP_count_idx fontW']/input");								//翼存宝第1条数据_id
	By eCunBaoDataHomeTitleOne = By.xpath("//div[@class='font30 fontW fl overflowV']/span");					//翼存宝第1条数据_“标题”(例如：（3785期）)
	By eCunBaoDataHomeAnnualReturnsOne = By.xpath("//span[@id='realvipInterestrate']");							//翼存宝第1条数据_“年化收益”
	By eCunBaoDataHomeContractTermOne  = By.xpath("//p[@class='lineT colorFF font20']/span[@class='wd120']");	//翼存宝第1条数据_“合同期限”
	By eCunBaoDataHomeRaiseMoneyOne = By.xpath("//p[@class='lineT colorFF font20']/span[@class='wd150']");		//翼存宝第1条数据_“已募集金额”
	By eCunBaoDataHomeRaiseTotalMoneyOne = By.xpath("//p[@class='lineT colorFF font20']/span[4]");				//翼存宝第1条数据_“总募集金额”
	By eCunBaoDataHomeZhaiQuanOne = By.cssSelector(".hFPHead.mt30.overflowV>a");								//翼存宝第1条数据_“债权详情”
	By redEnvelopesLink = By.xpath("//div[@class='hF-red-paper hF-red-paper_index']/a");						//翼存宝第1条数据_“点我！红包变现”
	By InvestmentBtn = By.xpath("//span[@class='hFP_btn_idx']/a");												//翼存宝第1条数据_“马上投资”按钮
	
	
	/******************************/
	/*****   翼存宝_第2~4条数据        ******/
	/******************************/
	
	By eCunBaoHomeTable = By.xpath("//div[text()='翼存宝']/parent::div/parent::div/following-sibling::table[1]");	//翼存宝第2~4条数据_数据表格
	By eCunBaoDataTFBondLink = By.xpath("//span[text()='债权']");													//翼存宝第2~4条数据_所有“债权”链接
	By touYiBiLink = By.xpath("//table[1]//td[@class='hFP_index_more']/parent::tr/preceding-sibling::tr//a[text()='投一笔']");
	
	/******************************/
	/******    翼存宝_查看更多           ******/
	/******************************/

	By moreLink = By.xpath("//td[@class='hFP_index_more']/a");													//“查看更多翼存宝项目” 链接
	
	
	/******************************/
	/****    翼存宝_投资金额窗口            *****/
	/******************************/
	
	By investmentDiv = By.cssSelector("#fastLender_1");										//投资金额窗口
	By buyBalance = By.cssSelector("#userBalance"); 										//投资金额窗口_可用余额
	By investmentBondDetails = By.cssSelector(".fr.zqbtn.font14");							//投资金额窗口_“债权详情”链接
	By investmentRechargeBtn = By.cssSelector(".fr.hFP_cz.mt2");							//投资金额窗口_“充值”按钮
	By buyShareTxt = By.id("wmpsYuGouAmount");												//投资金额窗口_“购买份额”文本框
	By payPwdTxt = By.cssSelector("#payPwd");												//投资金额窗口_“支付密码”文本框
	By eCunBaoProtocolAgreeChk = By.id("xy");												//投资金额窗口_“翼龙贷在线居间服务协议”复选框
	By eCunBaoProtocol = By.cssSelector(".mt15.textC.font14>a");							//投资金额窗口_“我已阅读并同意《翼龙贷在线居间服务协议》”链接
	By verificationCodeImg = By.xpath("//span[@id='checkverificationCode_fast']/a/img");	//投资金额窗口_“验证码”图片
	By verificationCodeTxt = By.id("wmpsRandCode");											//投资金额窗口_“验证码”文本框  
	By investmentOKBtn = By.xpath("//input[@class='hFP_Ok ml35']");							//投资金额窗口_“确认”按钮
	By investmentCloseBtn = By.cssSelector("div#fastLender_1 .close.fr");  					//投资金额窗口_“关闭”按钮


	/******************************/
	/******    翼存宝_债权详情           ******/
	/******************************/
	
	By eCBBondDetailsDIV = By.cssSelector("#messageBoxCard");									//债权详情_窗口
	By eCBBondDetailsDIVTitle = By.cssSelector("#saveTitle");									//债权详情_窗口_Title
	By eCBBondDetailsDIVColumnName = By.cssSelector("#detailstable>thead>tr>th");				//债权详情_窗口_列名(包括：借款标题、借款人姓名、身份证号、借款人地区、借款总额、操作)
	By eCBBondDetailsDIVInfo = By.cssSelector("#tenderBody .font14.color6>td");					//债权详情_窗口_信息(包括：借款标题、借款人姓名、身份证号、借款人地区、借款总额)
	By eCBBondDetailsDIVBtn = By.cssSelector(".xqbtn");											//债权详情_窗口_所有“查看详情”按钮
	By eCBBondDetailsSeeDIV = By.cssSelector("#xq_content");									//债权详情_窗口_查看详情_窗口
	By eCBBondDetailsDIVTab = By.cssSelector(".xq_content_t");									//债权详情_窗口_查看详情_所有Tab按钮
	By eCBBondDetailsDIVClose = By.cssSelector(".tip_close");									//债权详情_窗口_查看详情_关闭按钮
	
	/******************************/
	/**********   散标投资        *********/
	/******************************/
	
	By sbColumnName = By.cssSelector(".index_table>tbody>tr>th");		//散标投资标题
	
	/******************************/
	/**********   翼星计划        *********/
	/******************************/
	
	By eStarPlanTalbe = By.xpath("//div[text()='翼存宝']/parent::div/parent::div/following-sibling::table[2]");	//翼星计划数据表格
	
	/******************************/
	/********    尾部导航栏       *********/
	/******************************/
	
	By joinInOfBottom = By.xpath("//p/a[text()='招商合作']");		//招商合作

	//点击“我已阅读并同意《翼存宝投资协议》”
	public void clickECunBaoProtocol(){
		base.clickWithWait(eCunBaoProtocol);
	}
	
	//关闭“投资金额”窗口
	public void clickInvestmentCloseBtn(){
		base.clickWithWait(investmentCloseBtn);
		base.isElementContainsValue(investmentDiv, "style", "none");
	}
	
	//验证“我已阅读并同意《翼存宝投资协议》”
	public void checkECunBaoProtocol(){
		clickECunBaoProtocol();
		if(base.gethandelsNum() > 1){
			base.jumpToNewWindow();
		}
		base.assertEqualsActualExpectedByBoolean(base.isTitleContains(PageTitles.yiCunBaoTouZiXieYi), true);//"翼存宝投资协议"
		base.turnToNewPage();
	}
	
	//检查是否登录
	public void checkLogout(){
		registerPage.logout();
	}
	
	//点击“注册”链接
	public void clickRegisterLink(){
		base.clickElementNoWait(registerLinkXpath);
	}
	//点击“登录”链接
	public void clickLoginLink(){
		boolean isShow = false;
		int count = 0;
		do{
			base.clickElementByVisible(loginBtn);
			if(base.isElementPresenceNoWait(By.id("loginBoxFrame"))){
				base.switchToFrame("loginBoxFrame");
			}
			isShow  = base.isElementVisible(By.cssSelector("#loginName"), 20);
			System.out.println("是否存在" + isShow);
//			base.fromFrameToDefaultContent();
			if(!isShow){
				base.refreshPage();
				base.isTitleContains(PageTitles.shouYe);
				count += 1;
			}
			System.out.println("执行次数:" + count);
		}while(!isShow && count < 3);
		//关闭弹出空白页
		System.out.println("登录："+base.gethandelsNum());
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
	}
	
	/**
	 * 点击“我要加盟”
	 */
	public void clickJoinIn(){
		base.clickWithWait(joinIn);
		base.isTitle(PageTitles.zhaoShangHeZuo);
	}
	
	/************导航_方法*************/
	
	//点击“我要贷出”链接
	public void clickCreditLink(){
		base.clickWithWait(credit);
	}
	//鼠标悬停“我要贷出”，点击“翼存宝”链接
	public void clickECuBaoLink(){
		base.mouseToElement(credit);
		base.clickWithWait(eCuBao);
	}
	//鼠标悬停“我要贷出”，点击“翼星计划”链接
	public void clickEStarPlanLink(){
		base.mouseToElement(credit);
		base.clickWithWait(eStarPlan);
		if(base.Windowsize()!=1){
			base.turnToNewPage();
		}	
	}
	//鼠标悬停“我要贷出”，点击“投资列表”链接
	public void clickInvestmentListLink(){
		base.mouseToElement(credit);
		base.clickWithWait(investmentList);
	}
	//鼠标悬停“我要贷出”，点击“如何贷出”链接
	public void clickHowLendingLink(){
		base.mouseToElement(credit);
		base.clickWithWait(howLending);
	}
	//鼠标悬停“我要贷出”，点击“工具箱”链接
	public void clickToolBoxLink(){
		base.mouseToElement(credit);
		base.clickWithWait(toolBox);
	}

	//点击“我要借入”链接
	public void clickDebitLink(){
		base.clickWithWait(debit);
	}
	//鼠标悬停“我要借入”，点击“申请借入”链接
	public void clickBorrowLink(){
		base.mouseToElement(debit);
		base.clickWithWait(borrow);
	}
	//鼠标悬停“我要借入”，点击“如何借入”链接
	public void clickHowBorrowLink(){
		base.mouseToElement(debit);
		base.clickWithWait(howBorrow);
	}
	//鼠标悬停“我要借入”，点击“公益贷”链接
	public void clickWelfareLoanLink(){
		base.mouseToElement(debit);
		base.clickWithWait(welfareLoan);
	}
	
	//点击“新手专区”链接
	public void clickNoviceAreaLink(){
		base.clickWithWait(noviceArea);
	}
	
	//点击“债权转让”链接
	public void clickDebentureTransferLink(){
		base.clickWithWait(debentureTransfer);
		if(base.Windowsize()>1){
			base.turnToNewPage();
		}	
	}
	//鼠标悬停“债权转让”，点击“转让列表”链接
	public void clicktransferListLink(){
		base.mouseToElement(debentureTransfer);
		base.clickWithWait(transferList);
	}
	//鼠标悬停“债权转让”，点击“如何转让”链接
	public void clickHowTransferLink(){
		base.mouseToElement(debentureTransfer);
		base.clickWithWait(howTransfer);
	}
	
	//点击“关于我们”链接
	public void clickAboutUsLink(){
		base.clickWithWait(aboutUs);
	}
	//鼠标悬停“关于我们”，点击“公司介绍”链接
	public void clickCompanyIntroductionLink(){
		base.mouseToElement(aboutUs);
		base.clickWithWait(companyIntroduction);
	}
	//鼠标悬停“关于我们”，点击“领导介绍”链接
	public void clickLeaderIntroductionLink(){
		base.mouseToElement(aboutUs);
		base.clickWithWait(leaderIntroduction);
	}
	//鼠标悬停“关于我们”，点击“公司理念”链接
	public void clickCompanyPhilosophyLink(){
		base.mouseToElement(aboutUs);
		base.clickWithWait(companyPhilosophy);
	}
	//鼠标悬停“关于我们”，点击“招贤纳士”链接
	public void clickRecruitLink(){
		base.mouseToElement(aboutUs);
		base.clickWithWait(recruit);
	}
	//鼠标悬停“关于我们”，点击“联系我们”链接
	public void clickContactUsLink(){
		base.mouseToElement(aboutUs);
		base.clickWithWait(contactUs);
	}
	
	//点击“我的账户”链接
	public void clickMyAccountLink(){
		base.clickWithWait(myAccount);
	}
	
	//点击“收益计算器”按钮
	public void clickIncomeCalculatorBtn(){
		base.clickWithWait(incomeCalculatorBtn);
	}
	//输入“投资金额”
	public void sendKeyInvestmentMoneyTxt(String value){
		base.elementSendkey(investmentMoneyTxt, value);
	}
	//输入“年利率”
	public void sendKeyAnnualInterestRateTxt(String value){
		base.elementSendkey(annualInterestRateTxt, value);
	}
	//输入“投资期限”
	public void sendKeyInvestmentPeriodTxt(String value){
		base.elementSendkey(investmentPeriodTxt, value);
	}
	//勾选“显示计划时间表”
	public void clickShowScheduleChk(){
		base.clickWithWait(showScheduleChk);
	}
	//点击“马上计算”按钮
	public void clickImmediatelyCalculateBtn(){
		base.clickWithWait(immediatelyCalculateBtn);
	}
	
//	/**
//	 * 检查 弹出“温馨提示”窗口Title
//	 */
//	public void checkPromptTitle(){
//		base.assertEqualsActualExpected(base.getElementText(By.xpath("//h2[@class='u-tt']")), "温馨提示");
//		base.clickElementNoWait(By.xpath("//div[@class='lytt']/a"));
//	}
	
	//首页链接
	//eCuBao,eStarPlan,investmentList,howLending,toolBox,debit,borrow,howBorrow,welfareLoan,noviceArea,debentureTransfer,transferList,howTransfer,aboutUs,aboutUsContent,companyIntroduction,leaderIntroduction,leaderIntroductionContent,companyPhilosophy,companyPhilosophyContent,recruit,recruitContent,contactUs,contactUsContent,myAccount
	
	public String getBannerHref(By by){
		String bannerHref = base.getLnkElementText(by, "href");
		if(!bannerHref.contains("http://")){
			bannerHref = base.indexURL + bannerHref;
		}
		return bannerHref;
	}
	
	/**
	 * 徐天元
	 * 各页面链接至论坛
	 * @param modelName 模块名称
	 */
	public void linkToForum(String modelName){
		System.out.println(modelName + "begin...");
		clickMenu(modelName);
		base.assertNotNullBy(forumLink);
		base.clickWithWait(forumLink);
		System.out.println(modelName + "end...");
	}
	
	/**
	 * 徐天元
	 * 到论坛页
	 */
	public void goToForm(){
		base.clickWithWait(forumLink);
	}
	
	/**
	 * 点击进入相应模块
	 * @author 徐天元
	 * @修改  江渤洋 2016-3-15
	 */
	public void clickMenu(String modelName){
		if(modelName.equals("我要贷出") || modelName.equals("翼存宝") || modelName.equals("翼星计划") || modelName.equals("散标列表") || modelName.equals("如何贷出") || modelName.equals("工具箱")){
			base.mouseToElement(credit);
		}else if(modelName.equals("我要借入") || modelName.equals("申请借入") || modelName.equals("如何借入") || modelName.equals("公益贷")){
			base.mouseToElement(debit);
		}else if(modelName.equals("新手专区")){
			base.mouseToElement(noviceArea);
		}else if(modelName.equals("债权转让") || modelName.equals("转让列表") || modelName.equals("如何转让")){
			base.mouseToElement(debentureTransfer);
		}else if(modelName.equals("关于我们") || modelName.equals("公司介绍") || modelName.equals("领导介绍") || modelName.equals("公司理念") || modelName.equals("招贤纳士") || modelName.equals("联系我们")){
			base.mouseToElement(aboutUs);
		}
		base.clickWithWait(By.xpath("//div[@class='menu fr']//a[text()='" + modelName + "']"));
		if(modelName.equals("工具箱")){
			base.closeAndjumptoOldWindow();
		}
	}
	
	/**
	 * 徐天元
	 * 判断是否跳转至首页   
	 */
	public void isturnToIndexPage(){
		base.assertEqualsActualExpected(base.getPageTitle(), PageTitles.shouYe);
	}
	
	/**
	 * 徐天元
	 * 首页的点击导航栏下面的广告条中的免费注册按钮
	 */
	public void clickFreeRegister(){
		base.clickWithWait(freeRegisterBtn);
	}
	
	/********************************************/
	/****************   收益计算器       ****************/
	/********************************************/
	
	//返回“月收取利息”元素 
	public By getMonthlyInterestTxtElement(String investmentPeriod){
		return By.xpath("//td[text()='" + investmentPeriod + "']/parent::tr//td[3]");
	}
	
	//返回“月收取本金”元素 
	public By getMonthlyPrincipalTxtElement(String investmentPeriod){
		return By.xpath("//td[text()='" + investmentPeriod + "']/parent::tr//td[4]");
	}
	
	//返回“月收取总额”元素 
	public By getmonthlyTotalTxtElement(String investmentPeriod){
		return By.xpath("//td[text()='" + investmentPeriod + "']/parent::tr//td[5]");
	}
	
	/**
     * 检查收款表数据
     * @param  InvestmentMoney(投资金额)_1000, annualInterestRate(年利率)_20, investmentPeriod(投资期限)_24, repaymentDrop(还款方式”)
     * @author 江渤洋 2015-5-4
	 */
	public boolean checkReceivablesListData(String InvestmentMoney, String annualInterestRate, String investmentPeriod, String repaymentDrop){
		
		//月收取本金
		double monthlyPrincipalDouble = -1;
		String monthlyPrincipalStr = "";
		//月收取利息
		double monthlyInterestDouble = -1;
		String monthlyInterestStr = "";
		//月收取总额 
		double monthlyTotalDouble = -1;
		String monthlyTotalStr = "";
		//原字符串
		String originalString = "";
		//被替换字符
		String ExcludeString = ",";
		//替换字符
		String replaceString = "";
		
		boolean isPass = true;
		
		//获取“月收取利息 ”的值
		monthlyInterestStr = base.getElementText(getMonthlyInterestTxtElement(investmentPeriod));
		monthlyInterestDouble = Double.parseDouble(monthlyInterestStr);
//		System.out.println(monthlyInterestDouble);//-------------测试
		
		//获取“月收取本金”的值
		originalString = base.getElementText(getMonthlyPrincipalTxtElement(investmentPeriod));
		monthlyPrincipalStr = base.stringToReplace(originalString, ExcludeString, replaceString);
		monthlyPrincipalDouble =  Double.parseDouble(monthlyPrincipalStr);
//		System.out.println(monthlyPrincipalDouble);//-------------测试
		
		//页面获取“月收取总额”：1,016.66
		originalString = base.getElementText(getmonthlyTotalTxtElement(investmentPeriod));
		//将“1,016.66” 转化成“1016.66”
		monthlyTotalStr = base.stringToReplace(originalString, ExcludeString, replaceString);
		//将 String 转 double
		monthlyTotalDouble = Double.parseDouble(monthlyTotalStr);
//		System.out.println(monthlyTotalDouble);//-------------测试
		
		//最后一期的 “月收取本金” 与 “投资金额 ” 是否相等
		if(!(InvestmentMoney.equals(monthlyPrincipalStr))){System.out.println("1");isPass = false;}
//		System.out.println("InvestmentMoney:" + InvestmentMoney);//-----------------------测试
//		System.out.println("monthlyPrincipalStr:" + monthlyPrincipalStr);//-----------------------测试
		
		//最后一期的“月收取利息 ”是否正确
		Double InvestmentMoneyDouble = Double.parseDouble(InvestmentMoney);
		Double annualInterestRateDouble = Double.parseDouble(annualInterestRate);
//		System.out.println("InvestmentMoneyDouble:" + InvestmentMoneyDouble);//-----------------------测试
//		System.out.println("annualInterestRateDouble:" + annualInterestRateDouble);//-----------------------测试
//		System.out.println("结果在这里" + base.setRound((InvestmentMoneyDouble * (annualInterestRateDouble * 0.01)) / 12, 2, true));//-----------------------测试
		double monthlyInterestCalculationDouble = base.setRound((InvestmentMoneyDouble * (annualInterestRateDouble * 0.01)) / 12, 2, true);
		if((monthlyInterestDouble)!=(monthlyInterestCalculationDouble)){System.out.println("2");isPass = false;}
 		
 		//最后一期的“月收取总额”是否正确
// 		System.out.println("monthlyTotalDouble:" + monthlyTotalDouble);//-----------------------测试
// 		System.out.println("monthlyPrincipalDouble:" + monthlyPrincipalDouble);//-----------------------测试
// 		System.out.println("monthlyInterestDouble:" + monthlyInterestDouble);//-----------------------测试
		if((monthlyTotalDouble)!=(monthlyPrincipalDouble + monthlyInterestDouble)){System.out.println("3");isPass = false;}
 		
		return isPass;
	}
	
	/*****************************************/
	/****************  banner ****************/
	/*****************************************/
	
	/**
	 * 首页大图链接
	 * @author 徐天元
	 * @修改 江渤洋
	 */
	public void isBannerOK(String[] banners){
		
		List<WebElement> numList = base.getElements(By.cssSelector("#yq_banner_list a"));	//数字
		List<WebElement> imgList = base.getElements(By.cssSelector(".bannger_inbox>img"));	//图片
		int step = 0;
		Reporter.log("共"+numList.size()+"个大图"+"<br/>");
		System.out.println("共"+numList.size()+"个大图");
		for (int i = (numList.size() - 1); i >= 0; i--) {
			int j = i + 1;
			numList.get(i).click();//点击数字i,显示第i个大图
			imgList.get(i).click();//点击第i个大图
			if (base.gethandelsNum() == 2) {
				base.jumpToNewWindow();
				try {
					base.assertTrueByBoolean(base.isTitleContains(banners[i]));
					step += 1;
					Reporter.log("第" + j + "个大图校验成功" + "<br/>");
					System.out.println("第" + j + "个大图校验成功");
				} catch (AssertionError e) {
					Reporter.log("第" + j + "个大图校验失败"+"<br/>");
					System.out.println("第" + j + "个大图校验失败");
				}
				base.closeAndjumptoOldWindow();
			}
		}
		Assert.assertEquals(step, banners.length);
	}
	
	/*****************************************/
	/****************  普惠金融     ****************/
	/*****************************************/
	
	/**
	 * 获取惠普金融图片元素
	 * @param name 元素名称
	 * @return 元素对象
	 * @author 江渤洋 2015-11-27
	 */
	public By getProjectIcon(String name){
		String icon = null;
		switch(name){
			case "惠普金融": icon = "1"; break;
			case "收益可观": icon = "2"; break;
			case "安全保障": icon = "3"; break;
			case "同城模式": icon = "4"; break;
			case "品牌权威": icon = "5"; break;
		}
		By iconBy = By.cssSelector(".icon" + icon);
		base.isElementVisible(iconBy);
		return iconBy;
	}
	
	/**
	 * 获取惠普金融内容元素
	 * @param name 元素名称
	 * @return 元素对象
	 * @author 江渤洋  2015-11-27
	 */
	public By getProjectInfo(String name){
		String info = null;
		switch(name){
		case "惠普金融": info = "1.bgf60"; break;
		case "收益可观": info = ".bge2"; break;
		case "安全保障": info = ".bg40"; break;
		case "同城模式": info = "1.bg7c"; break;
		case "品牌权威": info = "1.bgf30"; break;
	}
		By infoBy = By.cssSelector(".phjr_info" + info);
		base.isElementVisible(infoBy);
		return infoBy;
	}
	
	/**
	 * 校验惠普金融跳转Title
	 * @param name 元素名称
	 * @author 江渤洋 2015-11-27
	 */
	public void checkProjectTitle(String name){
		String title = null;
		switch(name){
			case "惠普金融": 
				title = PageTitles.huiPuJinRong;
				base.assertTrueByBoolean(base.isTitle(title));
				base.assertNotNullBy(By.xpath("//h2[text()='三农金融服务体系亟待完善']"));
				break;
			case "收益可观": 
				title = PageTitles.shouYiKeGuan;
				base.assertTrueByBoolean(base.isTitle(title));
				base.assertNotNullBy(By.xpath("//h2[text()='收益可观']"));
				break;
			case "安全保障":
				title = PageTitles.anQuanBaoZhang;
				base.assertTrueByBoolean(base.isTitle(title));
				base.assertNotNullBy(By.xpath("//h3[text()='收益保障']"));
				break;
			case "同城模式":
				title = PageTitles.tongChengMoShi;
				base.assertTrueByBoolean(base.isTitle(title));
				base.assertNotNullBy(By.xpath("//h2[text()='什么是同城O2O模式？']"));
				break;
			case "品牌权威": 
				title = PageTitles.pinPaiQuanWei;
				base.assertTrueByBoolean(base.isTitle(title));
				base.assertNotNullBy(By.xpath("//h2[text()='【央视推荐】']"));
				break;
		}
		Reporter.log(title + "  校验成功！");
		System.out.println(title + "  校验成功！");
	}
	
	/**
	 * 校验惠普金融跳转链接
	 * @param name 元素名称
	 * @author 江渤洋 2015-11-27
	 */
	public void checkProjectLink(String name){
		
		By icon,info;
		String parentHandle,childHandle;
		icon = getProjectIcon(name);
		base.mouseToElement(icon);
		parentHandle = base.getCurrentWindowHandle();
		info = getProjectInfo(name);
		base.clickWithWait(info);
		childHandle = base.getChildWindowHandle2(parentHandle);
		base.jumpToWindow(childHandle);
		try {
			checkProjectTitle(name);
		} catch (AssertionError e) {
			base.jumpToWindow(parentHandle);
			System.out.println("error_惠普金融跳转Title验证错误");
			Reporter.log("error_惠普金融跳转Title验证错误");
			base.assertTrueByBoolean(false);
		}
		base.closeAndjumptoOldWindow();
	}
	
	/******************************/
	/***    翼存宝_散标投资_翼星计划          ***/
	/******************************/
	
	/**
	 * 首页，获取产品Title（例如：翼存宝、散标投资、翼星计划、投资专区）
	 * @param productName 产品名称
	 * @return Title对象
	 * @author 江渤洋 2016-2-24
	 */
	public By getProductTitle(String productName){
		return By.xpath("//h2[text()='" + productName + "']");
	}
	
	/**
	 * 首页，校验产品名称样式
	 * @param productName 产品名称（例如：翼存宝、散标投资、翼星计划、投资专区）
	 * @param styleName 样式名称
	 * @param styleValue 样式值
	 * @author 江渤洋 2016-2-24
	 */
	public void checkProductTitleStyle(String productName, String styleName, String styleValue){
		base.checkCSSValue(getProductTitle(productName), styleName, styleValue);
	}
	
	public List<String> getTableDataOfRow(String name){
		List<WebElement> productTableList = base.getVisibleElements(productTable);
		List<WebElement> productTrList;
		List<WebElement> productTdList;
		List<WebElement> productSpanList;
		List<String> productValueList = new ArrayList<String>();
		
		if(name.equals("翼存宝")){
			
		}
		else if(name.equals("散标投资")){
			productTrList = productTableList.get(1).findElements(By.tagName("tr"));
			for(int i = 0; i < productTrList.size(); i++){//1：标题，最后一个：查看更多散标项目
				if(i != 0 || i != (productTrList.size() - 1)){
					productTdList = productTrList.get(i).findElements(By.tagName("td"));
					for(int j = 0; j < productTdList.size(); j++){
						if(j == 0 || j == (productTdList.size() - 1)){//0：标题值、1：借款金额、最后一个：按钮Text
							productSpanList = productTdList.get(j).findElements(By.tagName("span"));
							for(int k = 0; k < productSpanList.size(); k++){
								productValueList.add(productSpanList.get(k).getText());
							}
						}
						else if(j == 1){
							productSpanList = productTdList.get(j).findElements(By.tagName("span"));
							for(int k = 0; k < 1; k++){//第二个值为空，所以不取值
								productValueList.add(productSpanList.get(k).getText());
							}
						}
						else{
							productValueList.add(productTdList.get(j).getText());
						}
					}
				}
			}
		}
		
		return productValueList;
	}
	
	/**
	 * 首页，获取“查看更多”对象
	 * @param linkName 链接名称
	 * @return “查看更多”对象
	 * @author 江渤洋 2016-2-24
	 */
	public By getMoreLinkBy(String linkName){
		return By.xpath("//a[text()='查看更多" + linkName + "项目']");
	}
	
	/**
	 * 首页，获取“查看更多”对象
	 * @param linkName 链接名称
	 * @return “查看更多”对象
	 * @author 江渤洋 2016-2-3
	 */
	public WebElement getMoreLink(String linkName){
		List<WebElement> webList = base.getVisibleElements(productMoreLink);
		WebElement webElement;
		int index;
		switch (linkName) {
		case "翼存宝":	
					index = 0;
					webElement = webList.get(index);
					base.assertEqualsActualExpected(webElement.getText(), "查看更多翼存宝项目");
					break;
		case "散标投资":	
					index = 1;
					webElement = webList.get(index);
					base.assertEqualsActualExpected(webElement.getText(), "查看更多散标项目");
					break;
		case "翼星计划":	
					index = 2;
					webElement = webList.get(index);
					base.assertEqualsActualExpected(webElement.getText(), "查看更多翼星计划项目");
					break;
		default:		
					index = 0;
					webElement = webList.get(index);
					base.assertEqualsActualExpected(webElement.getText(), "查看更多翼存宝项目");
					break;
		}
		return webElement;
	}
	
	/**
	 * 首页，点击“查看更多”链接
	 * @param linkName 链接名称
	 * @author 江渤洋
	 */
	public void clickMoreLink(String linkName){
		getMoreLink(linkName).click();
		base.jumpToNewWindow();
		switch (linkName) {
		case "翼存宝":	base.isTitle(PageTitles.yiCunBao);			break;
		case "散标投资":	base.isTitle(PageTitles.touZiLieBiao);		break;
		case "翼星计划":	base.isTitle(PageTitles.yiXingJiHua);		break;
		default:		base.isTitle(PageTitles.yiCunBao);			break;
		}
		base.closeAndjumptoOldWindow();
	}
	
	/**
	 * 首页，获取“查看更多”样式
	 * @param linkName 链接名称
	 * @author 江渤洋 2016-2-24
	 */
	public void checkMoreLinkStyle(String linkName, String styleName){
		base.assertEqualsActualExpected(base.getCSSValue(getMoreLinkBy(linkName), "text-align"), styleName);
	}
	
	
	

	/*****************************************/
	/****************   翼存宝      ****************/
	/*****************************************/
	
	
	/****************   翼存宝_第一条数据      ****************/
	
	//点击“债权详情”链接
	public void clickeZhaiQuanXiangQing(){
		base.clickWithWait(eCunBaoDataHomeZhaiQuanOne);
	}
	
	//点击“点我！红包变现”链接
	public void clickRedEnvelopesLink(){
		base.clickWithWait(redEnvelopesLink);
	}
	
	//点击“马上投资”按钮
	public void clickInvestmentBtn(){
		base.clickWithWait(InvestmentBtn);
	}
	
	//判断是“马上投资”按钮是否能点击
	public boolean isInvestmentBtn(){
		boolean isInvestmentBtn = base.getElementTextWithVisible(InvestmentBtn).equals("马上投资");
		if(isInvestmentBtn){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * 检查 弹出“红包变现规则”窗口Title
	 * @author 江渤洋 2015-5-11
	 */
	public void checkRedEnvelopesTitle(){
		base.assertEqualsActualExpected(base.getElementTextWithVisible(By.xpath("//div[@class='g_con']/h3")), "翼存宝红包变现规则");
		base.clickElementNoWait(By.xpath("//div[@class='gui_close']"));
	}
	
	//获取翼存宝第一条数据的标题
	public String getECunBaoOneHomeTitleText(){
		String eCunBaoDataHomeTitleOneStr = base.getElementTextWithVisible(eCunBaoDataHomeTitleOne);
		return eCunBaoDataHomeTitleOneStr.substring(1, eCunBaoDataHomeTitleOneStr.length()-1);
	}
	
	/**
	 * 获取首页翼存宝第一条数据的id
	 * @return id
	 * @author 江渤洋 2015-12-11
	 */
	public String getECunBaoHomeDataOneId(){
		base.isElementPresence(eCunBaoDataHomeId);
		String id = base.getAttribute(eCunBaoDataHomeId,"id");
		id = id.substring(id.indexOf("id")+2);
		return id;
	}
	
	/**
	 * 获取首页翼存宝第一条数据，数据为1行5列
	 * @param cellNum(列数)
	 * @return 数据集合
	 * @author 江渤洋 2015-5-7
	 */
	public List<String> getECunBaoHomeDataOne(int cellNum){
		List<String> eCunBaoDataList = new ArrayList<String>();
		//如果列数为0，则返回标题
		if(cellNum==0){
			eCunBaoDataList.add(this.getECunBaoOneHomeTitleText());//“标题”
		}
		//返回全部数据
		else{
			eCunBaoDataList.add(this.getECunBaoOneHomeTitleText());									//“标题”
			eCunBaoDataList.add(base.getElementTextWithVisible(eCunBaoDataHomeAnnualReturnsOne));	//“年化收益”
			eCunBaoDataList.add(base.getElementTextWithVisible(eCunBaoDataHomeContractTermOne));	//“合同期限”
			eCunBaoDataList.add(base.getElementTextWithVisible(eCunBaoDataHomeRaiseMoneyOne));		//“已募集金额”
			eCunBaoDataList.add(base.getElementTextWithVisible(eCunBaoDataHomeRaiseTotalMoneyOne));	//“总募集金额”
		}
		return eCunBaoDataList;
	}
	
	/****************   翼存宝_第二~四条数据      ****************/
	
	//获取翼存宝第二条~第四条数据
	public String getECunBaoHomeTableAppointText(int rowNum, int cellNum){
		return base.getCellElement(eCunBaoHomeTable, rowNum, cellNum).getText().trim();
	}
	
	//点击“投一笔”按钮
	public void clickAnIinvestmentBtn(WebElement AnIinvestmentWebElement){
		AnIinvestmentWebElement.click();
	}
	
	/**
	 * 判断“投一笔”按钮是否显示
	 * @return true：显示；false：不显示
	 * @author 江渤洋 2016-2-4
	 */
	public boolean isAnIinvestmentBtn(){
		return base.isElementVisible(touYiBiLink);
	}
	
	/**
	 * 点击“投一笔”按钮
	 * @author 江渤洋 2016-2-4
	 */
	public void clickAnIinvestmentBtn(){
		List<WebElement> touYiBiList = base.getElements(touYiBiLink);
		for(int i = 0; i < 1; i++){
			touYiBiList.get(i).click();
			base.isElementVisible(By.cssSelector("#fastLender_1"));
		}
	}
	/**
	 * 获取“投一笔”按钮
	 * @param rowNum 行数
	 * @param cellNum 列数
	 * @return “投一笔”对象
	 * @author 江渤洋
	 */
	public WebElement getAnIinvestmentBtn(int rowNum, int cellNum){
		
		//通过行列数，在Table中获取“行”元素
		WebElement cellWebElement = base.getCellElement(eCunBaoHomeTable, rowNum, cellNum);
		//在“行”元素中获取a标签
		WebElement tagA = cellWebElement.findElement(By.tagName("a"));   //System.out.println(tagA.getText());//------------测试
		//如果标签值为“投一笔”，则点击
		if(tagA.getText().equals("投一笔")){
			return tagA;
		}
		else{
			System.out.println("IndexPage: 无'投一笔'按钮！");
			return null;
		}
	}

	/**
	 * 首页翼存宝，获取第2~4行中某列的所有值
	 * @param name 列名(标题、年化收益、已募集金额、总募集金额、投一笔)
	 * @return 某列的值对象
	 * @author 江渤洋 2015-12-30
	 */
	public List<WebElement> getECunBaoCellDataBy(String name){
		
		List<WebElement> list = new ArrayList<WebElement>();
		String cell = "";
		switch (name) {
		case "标题":		cell = "1";break;
		case "年化收益":	cell = "2";break;
		case "已募集金额":	cell = "3";break;
		case "总募集金额":	cell = "4";break;
		case "投一笔":	cell = "5";break;
		default:
			break;
		}
		By cellby = By.xpath("//table[1]//tr[@class='effect']//td[" + cell + "]");
		list = base.getVisibleElements(cellby);
		return list;
	}
	
	/**
	 * 首页翼存宝，获取第2~4行中某列的所有值
	 * @param listWebElement 对象集合
	 * @return 字符集合
	 * @author 江渤洋 2015-12-30
	 */
	public List<String> getECunBaoCellDataStr(String name){
		
		List<WebElement> listWebElement = getECunBaoCellDataBy(name);
		List<String> list = new ArrayList<String>();
		int size = listWebElement.size();
		
		for(int i = 0; i < size; i++){
			list.add(listWebElement.get(i).getText());
		}
		return list;
	}
	
	/**
	 * 首页翼存宝，校验年化收益的VIP利率和图标
	 * @param list 年化收益列的集合
	 * @param rate VIP利率
	 * @author 江渤洋 2015-12-30
	 */
	public void checkAnnualReturns(List<String> list, String rate){

		//第1条翼存宝数据
		//校验+0.1%
		By rateOneBy = By.xpath("//span[@id='realvipInterestrate']/span/span/span");
		System.out.println("第1条数据利率：" +  base.getElementTextWithVisible(rateOneBy));
		base.assertEqualsActualExpected(base.getElementTextWithVisible(rateOneBy), rate);
		//校验VIP图标
		By vipICOOneBy = By.xpath("//span[@id='realvipInterestrate']//i");
		base.checkElementVisible(vipICOOneBy);
		
		//第2~4条翼存宝数据
		//校验+0.1%
		for (String str : list) {
			str = str.substring(str.lastIndexOf("+"));System.out.println("第2~4条数据利率：" + str);//测试-----------------
			base.assertEqualsActualExpected(str, rate);
		}
		//校验VIP图标
		By vipICOby = By.xpath("//tr[@class='effect']//td[2]//span/i");
		base.checkElementsVisible(vipICOby);
	}
	
	/****************      翼存宝_投资金额_窗口              ****************/
	
	//输入“购买份额”
	public void sendKeyBuyShareTxt(String buyShare){
		base.sendKeysWithWait(buyShareTxt, buyShare);
	}
		
	//输入“支付密码”
	public void sendKeyPayPwdTxt(String payPwd){
		base.checkElementVisible(payPwdTxt);
		base.sendKeysWithWait(payPwdTxt, payPwd);
	}
		
	//勾选“翼存宝投资协议”复选框
	public void checkECunBaoProtocolAgree(){
		base.clickWithWait(eCunBaoProtocolAgreeChk);
	}
		
	//获取验证码图片
	public WebElement getVerificationCodeImg(){
		return base.getElementNoWait(verificationCodeImg);
	}
		
	//输入“验证码”
	public void sendKeyVerificationCode(String verificationCode){
		base.sendKeysWithWait(verificationCodeTxt, verificationCode);
	}
		
	//点击投资“确定”按钮
	public void clickInvestmentOKBtn(){
		base.clickWithWait(investmentOKBtn);
		if(base.isAlertPresent()){
			if(base.getTextByAlert().equals("验证码不能为空！")){
				base.acceptAlert();
				sendKeyVerificationCode(data.get(getVerificationCodeImg(), base.getWebDriver()));
				base.clickWithWait(investmentOKBtn);
			}
		}
	}
	
	/**
	 * 检查投资窗口
	 * 情况1：账户有钱，弹出投资窗口，校验窗口Title为“投资金额”
	 * 情况2：账户没钱，弹出充值提示窗口，校验窗口Title为“温馨提示”
	 * 情况3：产品已结束，校验窗口Title为“出错了”
	 * @author 江渤洋
	 */
	public void checkInvestmentTitle(){
		if(base.getElementNoWait(By.xpath("//div[@id='bcardtip']")).isDisplayed()){    //System.out.println(base.getElementText(By.xpath("//h2[@class='u-tt']")));//-----------测试
			base.assertEqualsActualExpected(base.getElementText(By.xpath("//h2[@class='u-tt']")), "温馨提示");
			base.clickElementNoWait(By.xpath("//div[@class='lytt']/a"));
			System.out.println("翼存宝投资窗口：账户没钱，弹出充值提示窗口");
			Reporter.log("翼存宝投资窗口：账户没钱，弹出充值提示窗口");
		}
		else if(base.isBlock(By.id("fastLender_1"))){
			base.assertEqualsActualExpected(base.getElementText(By.xpath("//span[text()='投资金额']")), "投资金额");
			base.clickWithWait(By.xpath("//div[@id='fastLender_1']/div/a"));
//			System.out.println("翼存宝投资窗口：账户有钱，弹出投资窗口");
//			Reporter.log("翼存宝投资窗口：账户有钱，弹出投资窗口");
		}
		else if(base.isBlock(By.id("fastLender_2"))){
			base.assertEqualsActualExpected(base.getElementText(By.xpath("//span[text()='出错了']")), "出错了");
			base.clickWithWait(By.xpath("//div[@id='fastLender_2']/div/a"));
			System.out.println("翼存宝投资窗口：产品已结束");
			Reporter.log("翼存宝投资窗口：产品已结束");
		}
		else{
			System.out.println("翼存宝投资窗口：账户没钱，无法测试！或 按钮失效");
			Reporter.log("翼存宝投资窗口：账户没钱，无法测试！或 按钮失效");
		}
	}
	
	/**
	 * 校验“投资成功”信息提示框
	 * @author 江渤洋 2015-5-21
	 */
	public void checkInvestmentSuccessWindow(){
		//获取“投资成功”DIV的display属性值是否为block，如果是则DIV显示
		boolean isInvestmentSuccess = base.isBlock(By.id("fastLender_2"));
		//判断DIV是否显示
		base.assertEqualsActualExpectedByBoolean(isInvestmentSuccess, true);
		String success = base.getElementTextWithVisible(By.xpath("//div[@id='fastLender_2']/div/span[text()='投资成功']"));
		//判断窗口Title投资成功
		base.assertEqualsActualExpected(success, "投资成功");
		//点击“关闭”按钮
		base.clickWithWait(By.xpath("//span[@id='backMsg']/parent::div/a"));
	}
	
	/**
	 * 获取首页翼存宝账户余额
	 * @author 江渤洋 2015-11-23
	 */
	public String getECunBaoBalance(){
		return base.getElementTextWithWait(buyBalance);
	}
	
	/**
	 * 余额是否够买翼存宝
	 * @param buyNumber 购买份数
	 * @return true：购买；false:余额不足
	 * @author 江渤洋 2015-11-23
	 */
	public boolean checkECunBaoBalance(String buyNumber){
		
		String buyBalanceStr = getECunBaoBalance();
		int index  = buyBalanceStr.indexOf(".");
		if(index != -1){
			buyBalanceStr = buyBalanceStr.substring(0, index);
		}
		int buyBalanceInt = Integer.valueOf(buyBalanceStr);//账户余额
		int payAble = Integer.valueOf(buyNumber) * 100;//需要花费金额
		System.out.println("账户余额：" + buyBalanceInt + " 所需花费：" + payAble);
		if(buyBalanceInt > payAble){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*****************************************************/
	/****************      翼存宝_债权详情              ****************/
	/*****************************************************/
	
	/**
	 * 首页——>翼存宝_第1条数据——>点击“马上投资”按钮——>点击“债权详情”链接，校验窗口是否打开，数据是否加载
	 * @author 江渤洋 2016-2-4
	 */
	public void clickInvestmentBondDetails(){
		base.clickWithWait(investmentBondDetails);
		base.checkElementVisible(eCBBondDetailsDIV);
		base.assertEqualsActualExpected(base.getElementTextWithVisible(eCBBondDetailsDIVTitle), "债权详情");
		base.assertTrueByBoolean(base.isElementVisible(By.cssSelector("#aq")));//校验翻页按钮是否存在
	}
	
	/**
	 * 首页——>翼存宝_第2~4条数据——>点击“债权详情”按钮，并校验窗口是否打开，数据是否加载
	 * @author 江渤洋 2016-2-4
	 */
	public void clickECunBaoDataTFBondLink(){
		List<WebElement> webList = base.getVisibleElements(eCunBaoDataTFBondLink);
		for(int i = 0; i < 1; i++){
			webList.get(i).click();
			base.checkElementVisible(eCBBondDetailsDIV);
			base.assertEqualsActualExpected(base.getElementTextWithVisible(eCBBondDetailsDIVTitle), "债权详情");
			base.assertTrueByBoolean(base.isElementVisible(By.cssSelector("#aq")));//校验翻页按钮是否存在
		}
	}
	
	/**
	 * 首页——>翼存宝_第1条数据——>点击“债权详情”按钮，并校验窗口是否打开，数据是否加载
	 * @author 江渤洋 2016-2-4
	 */
	public void clickECunBaoDataHomeZhaiQuanOne(){
		base.clickWithWait(eCunBaoDataHomeZhaiQuanOne);
		base.checkElementVisible(eCBBondDetailsDIV);
		base.assertEqualsActualExpected(base.getElementTextWithVisible(eCBBondDetailsDIVTitle), "债权详情");
		base.assertTrueByBoolean(base.isElementVisible(By.cssSelector("#aq")));//校验翻页按钮是否存在
	}
	
	/**
	 * 首页——>翼存宝——>点击“债权详情”按钮，校验窗口列名显示是否正常
	 * @author 江渤洋 2016-2-4
	 */
	public void checkECBBondDetailsDIVColumnName(){
		String[] columnName = {"借款标题","借款人姓名","身份证号","借款人地区","借款总额","操作"};
		List<WebElement> webList = base.getVisibleElements(eCBBondDetailsDIVColumnName);
		int size = webList.size();
		base.assertEqualsActualExpectedByInt(size, columnName.length);
		for(int i = 0; i < size; i++){
			base.assertEqualsActualExpected(webList.get(i).getText(), columnName[i]);
		}
	}
	
	/**
	 * 首页——>翼存宝——>点击“债权详情”按钮，获取窗口某列的值
	 * @param columnName 列名
	 * @return 某列值的集合
	 * @author 江渤洋 2016-2-4
	 */
	public List<String> getECBBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String index = "1";
		switch (columnName) {
		case "借款标题":	index = "1";	break;		
		case "借款人姓名":	index = "2";	break;	
		case "身份证号":	index = "3";	break;	
		case "借款人地区":	index = "4";	break;	
		case "借款总额":	index = "5";	break;	
		case "操作":		index = "6";	break;	
		default:		index = "1";	break;	
		}
		List<WebElement> webList = base.getVisibleElements(By.cssSelector(".font14.color6>td:nth-child(" + index + ")"));
		for(int i = 0; i < webList.size(); i++){
			strList.add(webList.get(i).getText());
		}
		return strList;
	}
	
	/**
	 * 首页——>翼存宝——>点击“债权详情”按钮，校验窗口某列的值显示是否正常
	 * @param columnName 列名
	 * @author 江渤洋 2016-2-4
	 */
	public void checkECBBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String temp;
		strList = getECBBondDetailsDIVColumnValue(columnName);
		if(columnName.equals("借款标题")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				if(temp.length() > 5){
					temp = temp.substring(5);
					base.assertTrueByBoolean(temp.equals("..."));
				}
			}
		}
		else if(columnName.equals("借款人姓名")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(1);
				base.assertTrueByBoolean(temp.contains("*"));
			}
		}
		else if(columnName.equals("身份证号")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(10);
				base.assertTrueByBoolean(temp.equals("********"));
			}
		}
		else if(columnName.equals("操作")){
			for(int i = 0; i < strList.size(); i++){
				base.assertEqualsActualExpected(strList.get(i), "查看详情");
			}
		}
	}
	
	/**
	 * 首页——>翼存宝——>点击“债权详情”按钮——>点击“查看详情”按钮，校验查看详情1.只显示被打开详情的借款标；2.分四栏显示标详情（基本信息）（个人资料）（担保/增额）（历史统计），统计信息与借款标信息匹配
	 * @author 江渤洋 2016-2-4
	 */
	public void checkBondDetails(){
		
		List<WebElement> bondDetailsDIVBtnList;
		List<String> titleList = getECBBondDetailsDIVColumnValue("借款标题");
		bondDetailsDIVBtnList = base.getVisibleElements(eCBBondDetailsDIVBtn);
		for(int i = 0; i < 1; i++){
			bondDetailsDIVBtnList.get(i).click();//点击“查看详情”按钮
			base.isElementVisible(By.xpath("//td[text()='" + titleList.get(i) + "']"));
			base.assertEqualsActualExpected(base.getElementTextWithVisible(By.cssSelector(".xq_content_tab_block.border>h3")), "借款描述");
			clickBondDetailsSeeTab("个人资料");
			clickBondDetailsSeeTab("担保增额");
			clickBondDetailsSeeTab("历史统计");
			bondDetailsDIVBtnList.get(i).click();//点击“查看详情”按钮
			base.isElementContainsValue(eCBBondDetailsSeeDIV, "style", "none");
			clickBondDetailsDIVClose();
			base.isElementContainsValue(By.cssSelector("#out_all3"), "style", "none");
		}
	}
	
	/**
	 * 首页——>翼存宝——>债权详情——>查看详情——>获取Tab对象
	 * @param tabName Tab名称
	 * @return Tab对象
	 * @author 江渤洋 2016-2-4
	 */
	public By getBondDetailsSeeTab(String tabName){
		String index;
		By by;
		switch (tabName) {
		case "基本信息":	index = "1";	break;
		case "个人资料":	index = "2";	break;
		case "担保增额":	index = "3";	break;
		case "历史统计":	index = "4";	break;
		default:		index = "1";	break;
		}
		by = By.cssSelector(".xq_content_t > li:nth-child(" + index + ")");
		return by;
	}
	
	/**
	 * 翼存宝列表页——>债权详情——>查看详情——>点击Tab
	 * @param tabName Tab名称
	 * @author 江渤洋 2016-2-4
	 */
	public void clickBondDetailsSeeTab(String tabName){
		By by = getBondDetailsSeeTab(tabName);
		base.clickWithWait(by);
		base.assertTrueByBoolean(base.isElementContainsValue2(by, "class", "cur"));
	}
	
	/**
	 * 翼存宝列表页——>债权详情——>查看详情——>点击X按钮
	 * @author 江渤洋 2016-2-4
	 */
	public void clickBondDetailsDIVClose(){
		base.clickWithWait(eCBBondDetailsDIVClose);
		base.isElementInvisibility(eCBBondDetailsDIV);
	}
	 
	/****************      翼存宝_其他               ****************/
	
	//点击“查看更多翼存宝项目”链接
	public void clickMoreLink(){
		base.clickElementNoWait(moreLink);
	}
	
	//获取弹出登录页面标题
	public String getloginTitle(){
		return base.getElementTextWithVisible(loginTitle);
	}
	
	//关闭登录页面窗口
	public void closeLogin(){
		base.clickWithWait(closeBtn);
	}

	/**
	 * 获取翼存宝首页显示的四条数据
	 * @param rowNum(行数)，cellNum(列数)
	 * @return 四条数据集合
	 * @author 江渤洋 2015-5-7
	 */
	public List<String> getECunBaoHomeDataAll(int rowNum, int cellNum){
		List<String> eCunBaoDataList = new ArrayList<String>();
		//获取第一条数据
		eCunBaoDataList = getECunBaoHomeDataOne(cellNum);   //System.out.println("IndexPage:" + cellNum);//---------------测试
		//获取第二条至第四条数据。一共是4行5列的数据
		for(int i = 1; i <= rowNum; i++){
			for(int j = 0; j <= cellNum; j++){   //System.out.println(getECunBaoHomeTableAppointText(i,j));//---------------测试
				eCunBaoDataList.add(getECunBaoHomeTableAppointText(i,j));
			}
		}
		return eCunBaoDataList;
	}
	
	/**
	 * 校验翼存宝首页是否显示4条数据
	 * @param titleList(首页获取的翼存宝数据集合)
	 * @author 江渤洋 2015-6-9
	 */
	public void checkECunBaoDataNum(List<String> titleList){
		base.assertEqualsActualExpectedByInt(titleList.size(), 4);
	}
	
	/**
	 * 检查首页翼存宝标题 与 数据库显示一致
	 * 标题排序规则：先按状态值从小到大排序；再按时间倒序排列
	 * @param frontPageTitleList (前台标题数组)
	 * @param databasesTitleList (数据库标题数组)
	 * @author 江渤洋 2015-5-7
	 */
	public void checkECunBaoHomeTitle(List<String> frontPageTitleList, List<String> databasesTitleList){
		System.out.println("开始------检查首页翼存宝标题 与 数据库显示一致------");
		System.out.print("前台一共  " + frontPageTitleList.size() + " 条数据\t");
		System.out.println("后台一共  " + databasesTitleList.size() + " 条数据");
		for(int i= 0; i < frontPageTitleList.size(); i++){
			System.out.print("前台数据： " + frontPageTitleList.get(i));System.out.println("   后台/列表页数据： " + databasesTitleList.get(i));
			base.assertEqualsActualExpected(frontPageTitleList.get(i), databasesTitleList.get(i));
		}
		System.out.println("结束------检查首页翼存宝标题 与 数据库显示一致------");
	}
	
	/**
	 * 修改翼存宝的格式(例如：2,721,600 ——> 272.16)
	 * @param money 金额
	 * @return
	 */
	public String getECunBaoMoney(String money){
		money = money.replaceAll(",", "");
		money = (Double.valueOf(money)/10000) + "";
		if(money.indexOf('.') != -1){
			if(money.substring(money.indexOf('.')).equals(".0")){
				money = money.substring(0, money.indexOf('.'));
			}
		}
		return money;
	}
	
	/**
	 * 校验首页翼存宝数据_“标题”、“年化收益”、“合约期限”、“已募集金额”、“总募集金额”与翼存宝列表页中相应期数数据一致
	 * 备注：“已募集金额”无法测试故代码注掉
	 * @param homePageList 首页翼存宝数据
	 * @param eCunbaoPageList 列表页翼存宝数据
	 * @author 江渤洋 2015-12-14
	 */
	public void checkECunBaoDataOne(List<String> homePageList, List<String> eCunbaoPageList){
		
		System.out.println("开始------检查首页翼存宝数据 与 列表页显示一致------");
		String homeStr,eCunbaoStr;
		int size = eCunbaoPageList.size();//列表页比首页少1
		for(int i = 0; i < size; i++){
			homeStr = homePageList.get(i);
			eCunbaoStr = eCunbaoPageList.get(i);
			//校验“年化收益”
			if (i == 1) {
				System.out.print("首页数据： " + homeStr);System.out.println("   列表页数据： " + eCunbaoStr);
				base.assertEqualsActualExpected(homeStr.replaceAll(" ", ""), eCunbaoStr);//“年化收益”去空格
			}
			//校验“已募集金额”、“总募集金额”
			else if(i == size-1){
				//String yiMu;
				String total;
				//yiMu = getECunBaoMoney(homeStr);
				total = getECunBaoMoney(homePageList.get((i + 1)));
				//homeStr = yiMu + "/" + total;
				//System.out.print("首页数据： " + homeStr);System.out.println("   列表页数据： " + eCunbaoStr);
				//base.assertEqualsActualExpected(homeStr, eCunbaoStr);
				eCunbaoStr = eCunbaoStr.substring(eCunbaoStr.indexOf("/") + 1);
				System.out.print("首页数据： " + total);System.out.println("   列表页数据： " + eCunbaoStr);
				base.assertEqualsActualExpected(total, eCunbaoStr);
			}
			//校验“年化收益”、“合约期限”
			else{
				System.out.print("首页数据： " + homeStr);System.out.println("   列表页数据： " + eCunbaoStr);
				base.assertEqualsActualExpected(homeStr, eCunbaoStr);
			}
		}
		System.out.println("结束------检查首页翼存宝数据 与 列表页显示一致------");
	}
	
	/**
	 * 校验弹出登录窗口
	 * @author 江渤洋 2015-5-8
	 */
	public void checkLoginTitle(){
		
		boolean isBlock = base.isBlock(By.xpath("//div[@class='login']"));    //System.out.println("是否显示： " + isBlock);//--------测试
		if(isBlock){
			try {
				//跳转到登录窗口
				base.switchToFrame("loginBoxFrame");
			} catch (Exception e) {
			}
			//校验Title是否一致
			base.assertEqualsActualExpected(getloginTitle(), "登录");
			//关闭窗口
			closeLogin();
			//获取当前窗口
			base.fromFrameToDefaultContent();
		}
		else{
			//关闭窗口
			base.clickWithWait(By.cssSelector(".login .close"));
		}
	}
	
	/**
	 * 检查 链接至“翼存宝”投资列表页
	 * @author 江渤洋 2015-5-11
	 */
	public void checkInvestmentListTitle(String CurrentWindowHandleString){
		String ChildWindowHandle = base.getChildWindowHandle(CurrentWindowHandleString);
		base.jumpToWindow(ChildWindowHandle);
		base.isTitle(PageTitles.yiCunBao);
		base.closeWindow(ChildWindowHandle);
		base.jumpToWindow(CurrentWindowHandleString);
	}
	

	/*****************************************/
	/***************   散标投资        ***************/
	/*****************************************/
	
	/**
	 * 首页，散标投资，校验数据列名
	 * @author 江渤洋 2016-2-2
	 */
	public void checkSBTableColumnName(){
		String[] nameArr = {"标题","年化收益","合约期限","已募集金额（元）","总募集金额（元）"};
		List<WebElement> webList = base.getVisibleElements(sbColumnName);
		for(int i = 0; i < nameArr.length; i++){
			base.assertEqualsActualExpected(webList.get(i).getText(), nameArr[i]);
		}
	}
	
	/**
	 * 首页，散标投资，获取某列的所有值的对象
	 * @param name 列名
	 * @return 某列的所有值的对象
	 * @author 江渤洋 2016-2-2
	 */
	public List<WebElement> getSBCellDataBy(String name){
		
		List<WebElement> list = new ArrayList<WebElement>();
		String cell = "";
		switch (name) {
		case "标题":		cell = "1";break;
		case "借款金额":	cell = "2";break;
		case "借款利率":	cell = "3";break;
		case "借款期限":	cell = "4";break;
		case "剩余金额":	cell = "5";break;
		case "按钮":		cell = "6";break;
		default:		cell = "1";break;
		}
		By cellby = By.xpath("//table[2]//tr[@class='effect']//td[" + cell + "]");
		list = base.getVisibleElements(cellby);
		return list;
	}
	
	/**
	 * 首页，散标投资，获取标题对象（即，没有标级别，只是Title）
	 * @param name 标题
	 * @return 标题对象
	 * @author 江渤洋 2016-2-3
	 */
	public List<WebElement> getSBCellTitleDataWebElement(String name){
		List<WebElement> spanList = new ArrayList<WebElement>();
		List<WebElement> aList = new ArrayList<WebElement>();
		spanList = getSBCellDataBy(name);
		for(int i = 0; i < spanList.size(); i++){
			aList.add(spanList.get(i).findElement(By.tagName("a")));
		}
		return aList;
	}
	
	/**
	 * 首页，校验点击散标投资中的标题跳转是否正常
	 * @param colName 列名（如：标题）
	 * @author 江渤洋 2016-2-3
	 */
	public void checkSBTitleJump(String colName){
		List<WebElement> titleList = new ArrayList<WebElement>();
		titleList = getSBCellTitleDataWebElement(colName);
		String title;
		for(int i = 0; i < titleList.size(); i++){
			title = titleList.get(i).getText();
			titleList.get(i).click();
			if(base.gethandelsNum() == 2){
				base.jumpToNewWindow();
				base.isTitleContains(title);
				base.closeAndjumptoOldWindow();
			}
		}
	}
	
	/**
	 * 首页，校验点击散标投资中的标题跳转是否正常，
	 * @param colName 列名（如：标题）
	 * @param tabName tab名称（如：材料信息）
	 * @author 江渤洋 2016-2-3
	 */
	public void checkSBTitleJumpAndMaterialImgNum(String colName, String tabName){
		List<WebElement> titleList = new ArrayList<>();
		titleList = getSBCellTitleDataWebElement(colName);
		String title;
		for(int i = 0; i < titleList.size(); i++){
			title = titleList.get(i).getText();
			if(title.indexOf(".") != -1){
				title = title.substring(0, title.indexOf("."));
			}
			titleList.get(i).click();
			if(base.gethandelsNum() == 2){
				base.jumpToNewWindow();
				base.isTitleContains(title);
				investmentDetailPage.clickTab(tabName);
				investmentDetailPage.checkMaterialImgNum();
				base.closeAndjumptoOldWindow();
			}
		}
	}
	
	/**
	 * 首页散标投资，获取某列的所有值
	 * @param name 列名
	 * @return 某列的所有值的值
	 * @author 江渤洋 2016-2-2
	 */
	public List<String> getSBDataStr(String name){
		
		List<WebElement> listWebElement = getSBCellDataBy(name);
		List<String> list = new ArrayList<String>();
		int size = listWebElement.size();
		
		for(int i = 0; i < size; i++){
			list.add(listWebElement.get(i).getText());
		}
		return list;
	}
	
	/**
	 * 首页，校验散标投资显示个数
	 * @param homeList
	 */
	public void checkSBDataNum(List<String> homeList){
		base.assertEqualsActualExpectedByInt(homeList.size(), 3);
	}
	
	/**
	 * 首页，校验散标投资数据是否与列表页相同
	 * @param sbTitleList   列表页_标题
	 * @param sbLevelList   列表页_级别
	 * @param sbMoneyList   列表页_借款金额
	 * @param sbRateList    列表页_借款利率
	 * @param sbPeriodsList 列表页_借款期限
	 * @author 江渤洋 2016-2-2
	 */
	public void checkSBData(List<String> sbTitleList, List<String> sbLevelList, List<String> sbMoneyList, List<String> sbRateList, List<String> sbPeriodsList){

		List<String> list;
		String sbMoney,homeMoney,sbTitle;
		
		list = getSBDataStr("标题");
		for(int i = 0; i < list.size(); i++){
			sbTitle = sbTitleList.get(i);
			sbTitle = sbTitle.substring(sbTitle.indexOf("】") + 2);//】后面有空格所以+2
			base.assertEqualsActualExpected(list.get(i).replaceAll("\n", ""), sbLevelList.get(i) + sbTitle);
		}
		list = getSBDataStr("借款金额");
		for(int i = 0; i < list.size(); i++){
			homeMoney = list.get(i);
			sbMoney = sbMoneyList.get(i);
			homeMoney = homeMoney.replaceAll("元", "");
			sbMoney = sbMoney.replaceAll("￥", "");
			base.assertEqualsActualExpected(homeMoney, sbMoney);
		}
		list = getSBDataStr("借款利率");
		for(int i = 0; i < list.size(); i++){
			base.assertEqualsActualExpected(list.get(i), sbRateList.get(i));
		}
		list = getSBDataStr("借款期限");
		for(int i = 0; i < list.size(); i++){
			base.assertEqualsActualExpected(list.get(i), sbPeriodsList.get(i));
		}
		list = getSBDataStr("剩余金额");
		for(int i = 0; i < list.size(); i++){
			base.assertEqualsActualExpected(list.get(i), "0元");
		}
		list = getSBDataStr("按钮");
		for(int i = 0; i < list.size(); i++){
			base.assertEqualsActualExpected(list.get(i), "已结束");
		}
	}
	
	/**********************************/
	/************底部导航_方法*************/
	/**********************************/
	
	/**
	 * 点击“我要加盟”
	 */
	public void clickJoinInOfBottom(){
		base.clickWithWait(joinInOfBottom);
		base.isTitle(PageTitles.zhaoShangHeZuo);
	}
}







