package com.eloancn.suites.myAccount;

import java.util.HashMap;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.InsideLetterPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyRewardPage;
import com.eloancn.shared.pages.TransactionRecordPage;

/**
 * “我的账户”P1——我的体验金
 * test环境没有账户
 * @author 江渤洋
 */
public class MyExperience_P2 {
	
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	IndexPage indexPage = new IndexPage();
	MyRewardPage myRewardPage = new MyRewardPage();
	InsideLetterPage insideLetterPage = new InsideLetterPage();
	TransactionRecordPage transactionRecordPage = new TransactionRecordPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	
	String tel_NoInterest;
	String tel_Interest;
	String email_Interest;
	String pass;
	
	String url;
	String MyAccountUrl = base.indexURL + "/page/userMgr/myHome.jsp";
	
	String tel_NoInterest_client = Data.tel_ExperienceNoInterest_client;
	String tel_Interest_client = Data.tel_ExperienceInterest_client;
	String email_Interest_client = Data.email_ExperienceInterest_client;
	String pass_client = Data.zzmm;
	
	String tel_NoInterest_test = Data.tel_ExperienceNoInterest_test;
	String tel_Interest_test = Data.tel_ExperienceInterest_test;
	String email_Interest_test = Data.email_ExperienceInterest_test;
	String pass_test = Data.zzmm;
	
	String insideLetterIDByInvestment = "9559131";      //投资体验期翼存宝的站内信ID，也可从页面获取
	String insideLetterIDByInterest = "10059584";       //利息体验期翼存宝的站内信ID，也可从页面获取
	String insideLetterIDByEnd = "10017118";       		//结束体验期翼存宝的站内信ID，也可从页面获取
	
	
	@BeforeClass
	public void classBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		url = base.getWebsiteServerName(base.indexURL);
		
		if(url.equals("client") || url.equals("inclient")){
			tel_NoInterest = tel_NoInterest_client;
			tel_Interest = tel_Interest_client;
			email_Interest = email_Interest_client;
			pass = pass_client;
		}
		else if(url.equals("test") || url.equals("www")){
			tel_NoInterest = tel_NoInterest_test;
			tel_Interest = tel_Interest_test;
			email_Interest = email_Interest_test;
			pass = pass_test;
		}
	}

	@BeforeMethod
	public void methodBefore(){
		base.openBrowser(MyAccountUrl);
	}
	
	@AfterMethod
	public void methodAfter(){
		base.logout();
	}
	
	@AfterClass
	public void classAfter(){
		base.tearDown();
	}
	
	//操作步骤：
	//1.后台——>活动——>体验活动产品——>添加体验翼存宝——>发布
	//2.前台——>投满刚发布的翼存宝（体验期的不匹配债权的）
	//3.后台——>风控管理——>手机随机码管理 ——>找没有对应手机号的随机码
	//4.http://192.168.1.229:8780/61/index61.jsp，注册新手机号（页面无法访问，找范庆辉）
	//5.前台——>注册——>投资人——>实名认证
	//备注：该账户不能购买其他翼存宝或充值等操作
	
	/**
	 * 验证我的体验金-详情（名称、金额）
	 * @author 江渤洋
	 */
	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void checkTheDetailsOfMyExperiences1_web_909(){
		Reporter.log("我的账户_P2：我的账户——>我的奖励——>验证我的体验金-详情（名称、金额）");
		System.out.println("我的账户_P2：我的账户——>我的奖励——>验证我的体验金-详情（名称、金额）");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_NoInterest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("账户：" + tel_NoInterest + " 登录失败！");
				Reporter.log("账户：" + tel_NoInterest + " 登录失败！");
			}
			
			base.openBrowser(MyAccountUrl);
			myAccountPage.turnToMyAccount("我的奖励");
			base.sleep(2000);
			myRewardPage.isMyRewardPage();
			myRewardPage.clickMyExperiencesLnk();
			//校验显示体验金额记录
			myRewardPage.checkMyExperiencesOfData();
			//校验“我的体验金”列表中的元素
			myRewardPage.checkMyExperiencesOfValue();
		}
		else{
			Reporter.log("test/www环境，没有账户，暂不执行");
			System.out.println("test/www环境，没有账户，暂不执行");
		}
	}
	
	/**
	 * 验证我的体验金-详情（有效截止日、状态、操作）
	 * @author 江渤洋
	 */
	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void checkTheDetailsOfMyExperiences1_web_910(){
		
		Reporter.log("我的账户_P2：我的账户——>我的奖励——>验证我的体验金-详情（有效截止日、状态、操作）");
		System.out.println("我的账户_P2：我的账户——>我的奖励——>验证我的体验金-详情（有效截止日、状态、操作）");
		
		if(url.equals("client") || url.equals("inclient")){
			
			loginPage.loginWithNoFrame(tel_NoInterest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("账户：" + tel_NoInterest + " 登录失败！");
				Reporter.log("账户：" + tel_NoInterest + " 登录失败！");
			}
			
			myAccountPage.turnToMyAccount("我的奖励");
			base.sleep(2000);
			myRewardPage.isMyRewardPage();
			myRewardPage.clickMyExperiencesLnk();
			//校验显示体验金额记录
			myRewardPage.checkMyExperiencesOfData();
	//		tel = "aWeOZxqrMg0M0TKNMWgSlg==";
			//校验“我的体验金”列表中的元素
			if(url.equals("client") || url.equals("inclient")){
				//“有效截止日”
				myRewardPage.checkEffectiveClosingDate(tel_NoInterest);
			}
			if(!base.checkInvisibility(myRewardPage.getMyExperiencesOfBy("状态_失效"))){
				//校验"状态"为有效和"操作"为马上使用
				myRewardPage.checkMyExperiencesOfValue(0);
				myRewardPage.clickOperation();
				//校验体验期翼存宝记录是否显示，且只显示一条
				myRewardPage.isWMPSListDivShowAndOnlyOne();
			}
			else{
				Reporter.log("error_体验金已失效，请重新注册申请");
				System.out.println("error_体验金已失效，请重新注册申请");
			}
		}
		else{
			Reporter.log("test/www环境，没有账户，暂不执行");
			System.out.println("test/www环境，没有账户，暂不执行");
		}
	}
	
	/**
	 * 验证我的体验金-体验期翼存宝规则
	 * @author 江渤洋
	 */
	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void checkTheDetailsOfExperiencePeriodECunBao_web_924(){
		Reporter.log("我的账户_P2：我的账户——>我的奖励——>验证我的体验金-体验期翼存宝规则");
		System.out.println("我的账户_P2：我的账户——>我的奖励——>验证我的体验金-体验期翼存宝规则");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_NoInterest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("账户：" + tel_NoInterest + " 登录失败！");
				Reporter.log("账户：" + tel_NoInterest + " 登录失败！");
			}
			
			myAccountPage.turnToMyAccount("我的奖励");
			base.sleep(2000);
			myRewardPage.isMyRewardPage();
			myRewardPage.clickMyExperiencesLnk();
			//校验显示体验金额记录
			myRewardPage.checkMyExperiencesOfData();
			//校验体验期翼存宝规则
			myRewardPage.checkExperiencePeriodRule();
		}
		else{
			Reporter.log("test/www环境，没有账户，暂不执行");
			System.out.println("test/www环境，没有账户，暂不执行");
		}
	}
	
	/**
	 * 验证我的体验金-体验期翼存宝详情
	 * 备注：执行完体验金无法再用
	 * @author 江渤洋
	 */
	@Test(priority = 4, enabled = false, invocationCount = 1)
	public void checkTheDetailsOfExperiencePeriodECunBao_web_911(){
		
		Reporter.log("我的账户_P2：我的账户——>我的奖励——>验证我的体验金-体验期翼存宝详情（年化收益、锁定期限、已募集金额、体验投资按钮）");
		System.out.println("我的账户_P2：我的账户——>我的奖励——>验证我的体验金-体验期翼存宝详情（年化收益、锁定期限、已募集金额、体验投资按钮）");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_NoInterest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("账户：" + tel_NoInterest + " 登录失败！");
				Reporter.log("账户：" + tel_NoInterest + " 登录失败！");
			}
			
			myAccountPage.turnToMyAccount("我的奖励");
			base.sleep(2000);
			myRewardPage.isMyRewardPage();
			myRewardPage.clickMyExperiencesLnk();
			//校验显示体验金额记录
			myRewardPage.checkMyExperiencesOfData();
			myRewardPage.clickOperation();
			//验证“年化收益”、“锁定期限”、“已募集金额”
			myRewardPage.checkExperiencePeriodECunBao();
			//校验“体验投资”成功
			myRewardPage.checkExperienceInvestment();
			myRewardPage.checkMyExperiencesOfValue(1);
		}
		else{
			Reporter.log("test环境，用例无法执行");
			System.out.println("test环境，用例无法执行");
		}
	}
	
	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void checkTransactionDtails_F_3689(){
		
		//这个d_funds_info表保存交易记录
		
		Reporter.log("我的账户_P2：我的账户——>交易记录——>可用余额和列表页_全部Tab中的“收入金额”，“支出金额”，“余额”");
		System.out.println("我的账户_P2：我的账户——>交易记录——>可用余额和列表页_全部Tab中的“收入金额”，“支出金额”，“余额”");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_Interest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("账户：" + tel_Interest + " 登录失败！");
				Reporter.log("账户：" + tel_Interest + " 登录失败！");
			}
			
			myAccountPage.turnToMyAccount("交易记录");
			transactionRecordPage.clickTab("全部");
			transactionRecordPage.checkColumnValueInTabList(email_Interest, "收入金额");
			transactionRecordPage.checkColumnValueInTabList(email_Interest, "支出金额");
			transactionRecordPage.checkColumnValueInTabList(email_Interest, "余额");
		}
		else{
			Reporter.log("test环境，用例无法执行");
			System.out.println("test环境，用例无法执行");
		}
	}
	
	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void checkInsideLetterInvestmentInfo_F_3686(){
		
		Reporter.log("我的账户_P2：我的账户——>站内信——>验证站内信显示投资信息（标题、内容、收件时间）");
		System.out.println("我的账户_P2：我的账户——>站内信——>验证站内信显示投资信息（标题、内容、收件时间）");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_Interest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("账户：" + tel_Interest + " 登录失败！");
				Reporter.log("账户：" + tel_Interest + " 登录失败！");
			}
			
			insideLetterPage.checkInsideLetterNum(email_Interest);
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkUpdateReceiverStatus(insideLetterIDByInvestment, "未读");
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInvestment, false);
			insideLetterPage.checkInsideLetterInvestmentInListPage(insideLetterIDByInvestment);
			insideLetterPage.clickInsideLetterTitleByIDInListPage(insideLetterIDByInvestment);
			insideLetterPage.checkInsideLetterInvestmentInDetailsPage(insideLetterIDByInvestment);
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInvestment, true);
			insideLetterPage.checkUpdateReceiverStatus(insideLetterIDByInvestment, "未读");
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInvestment, false);
		}
		else {
			Reporter.log("test环境，用例无法执行");
			System.out.println("test环境，用例无法执行");
		}
	}
	
	
	
	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void checkInsideLetterInterestInfo_F_3687(){
		
		Reporter.log("我的账户_P2：我的账户——>站内信——>验证站内信显示利息信息（标题、内容、收件时间）");
		System.out.println("我的账户_P2：我的账户——>站内信——>验证站内信显示利息信息（标题、内容、收件时间）");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_Interest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("账户：" + tel_Interest + " 登录失败！");
				Reporter.log("账户：" + tel_Interest + " 登录失败！");
			}
			
			insideLetterPage.checkInsideLetterNum(email_Interest);
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInterest, false);
			insideLetterPage.checkInsideLetterInvestmentInListPage(insideLetterIDByInterest);
			insideLetterPage.clickInsideLetterTitleByIDInListPage(insideLetterIDByInterest);
			insideLetterPage.checkInsideLetterInvestmentInDetailsPage(insideLetterIDByInterest);
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInterest, true);
			insideLetterPage.checkUpdateReceiverStatus(insideLetterIDByInterest, "未读");
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByInterest, false);
		}
		else {
			Reporter.log("test环境，用例无法执行");
			System.out.println("test环境，用例无法执行");
		}
	}
	
	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void checkInsideLetterEndInfo_F_3688(){
		
		Reporter.log("我的账户_P2：我的账户——>站内信——>验证站内信显示利息信息（标题、内容、收件时间）");
		System.out.println("我的账户_P2：我的账户——>站内信——>验证站内信显示利息信息（标题、内容、收件时间）");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame("13800138002", pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (Exception e1) {
				System.out.println("账户：" + "13800138002" + " 登录失败！");
				Reporter.log("账户：" + "13800138002" + " 登录失败！");
			}
			
			insideLetterPage.checkInsideLetterNum("yh2@11.com");
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkUpdateReceiverStatus(insideLetterIDByEnd, "未读");
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByEnd, false);
			insideLetterPage.checkInsideLetterInvestmentInListPage(insideLetterIDByEnd);
			insideLetterPage.clickInsideLetterTitleByIDInListPage(insideLetterIDByEnd);
			base.sleep(5000);
			insideLetterPage.checkInsideLetterInvestmentInDetailsPage(insideLetterIDByEnd);
			insideLetterPage.clickInsideLetter();
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByEnd, true);
			insideLetterPage.checkUpdateReceiverStatus(insideLetterIDByEnd, "未读");
			insideLetterPage.checkMailIsReadByInsideLetterID(insideLetterIDByEnd, false);
		}
		else{
			Reporter.log("test环境，用例无法执行");
			System.out.println("test环境，用例无法执行");
		}
	}
	
	@Test(priority = 9, enabled = false, invocationCount = 1)//集成环境定时任务有问题，无法测试，故删除
	public void checkBannerToData_F_3679(){
		
		Reporter.log("我的账户_P2：我的账户——>站内信——>验证站内信显示利息信息（标题、内容、收件时间）");
		System.out.println("我的账户_P2：我的账户——>站内信——>验证站内信显示利息信息（标题、内容、收件时间）");
		
		if(url.equals("client") || url.equals("inclient")){
			loginPage.loginWithNoFrame(tel_Interest, pass);
			try {
				base.assertEqualsActualExpectedByBoolean(loginPage.ifLogin(), true);
			} catch (AssertionError e1) {
				System.out.println("账户：" + tel_Interest + " 登录失败！");
				Reporter.log("账户：" + tel_Interest + " 登录失败！");
			}
			
			base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
			
			HashMap<String, String> hashMap = new HashMap<String, String>();
			hashMap = transactionRecordPage.getRecordTable(email_Interest);
			
			//在翼存宝列表页，校验Banner中“昨日收益”、“累计收益”、“待收笔数”
			eCunBaoPage.checkBannerToData(hashMap);
		}
		else{
			Reporter.log("test环境，用例无法执行");
			System.out.println("test环境，用例无法执行");
		}
	}
	
}
