package com.eloancn.suites.myAccount;

import java.util.Date;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.SBInvestPage;
import com.eloancn.shared.pages.TotalPage;
import com.eloancn.shared.pages.YCBPage;

/**
 * 投资翼存宝
 */
public class ECunBao_P1 {
	
	Base base = new Base();
	DBData dbData = new DBData();
	YCBPage yCBPage = new YCBPage();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	RechargePage rechargePage = new RechargePage();
	SBInvestPage sBInvestPage = new SBInvestPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
	
	String[] telArray;
	String[] nameArray;
	String[] password;
	String[] payPass;   //支付密码
	String day;         //合约期限
	String eCunBaoName; //产品名称
	String[] creditorDetails;
	String cancel_Tel;   //注销身份证账户
	String cancel_Pass;
	String cancel_PayPass;
	
	//借款人账号
	String[] jieKuanRen_Tel;
	String[] jieKuanRen_Pass;
	String   jieKuanRen_PayPass;
	
	//金额对比
	String jinErDuiBi_Tel;
	String jinErDuiBi_Pass;
	
	//VIP等级
	String[] vip_Tel;
	String vip_Pass;
	String[] vip_Rate;//VIP利率
	
	//普通用户计息
	String normalInterestAccrual_Tel;
	String normalInterestAccrual_Pass;
	
	String[] telArray_client = {"13581567705","13581567706","13581567707","15255555555"};  //集成与本地环境使用账户//[0]：普通用户；[1]：VIP1.0用户；[2]：VIP1.5用户；[3]:虚拟用户（即每日收益明细无数据）
	String[] nameArray_client = {"张莹","张莹一","张莹二","林尚春"};							   //姓名
	String[] password_client = {Data.zzmm, Data.zzmm, Data.zzmm, Data.zzmm};               //登录密码
	String[] payPass_client = {Data.zzmm, Data.zzmm, Data.zzmm, Data.zzmm};                //支付密码
	String day_client = "730";
	String eCunBaoName_client = "jby测试";
	String[] creditorDetails_chient = {"jby测试","借**","3501011983********","北京市","￥100000","18%","730天","查看详情"};
	String cancel_tel_client = "15924193586";											   //注销过身份证的账户
	String cancel_pass_client = Data.zzmm;
	String cancel_payPass_client = Data.zzmm;
	//[0]未发布借款的[1]发布借款（未审核）[2]发布借款（审核通过），还款中（未逾期）[3]发布借款（审核通过），结束还款[4]三次借款成功，最后一次还款(未逾期)[5]:有逾期记录，还款中（未逾期）[6]:逾期中
	String[] jieKuanRen_tel_client = {"13581568821","13581568822","13581568823","13581568824","13581568825","13581568826","13581568827"};
	String[] jieKuanRen_pass_client = {Data.zzmm,Data.zzmm,Data.zzmm,Data.zzmm,Data.zzmm,Data.zzmm,Data.zzmm};
	String jieKuanRen_PayPass_client = Data.zzmm;
	String jinErDuiBi_tel_client = "17665694718";
	String jinErDuiBi_pass_client = Data.zzmm;
	//[0]VIP1 +0.1,[0]VIP2 +0.2,[0]VIP3 +0.3,[0]VIP4 +0.4,[0]VIP5 +0.5,[0]VIP6 +0.6,[0]VIP7 +0.7,[0]VIP8 +0.8,[0]VIP9 +0.9,[0]VIP10 +1,[0]VIP11 +1.5
	String[] vip_tel_client = {"13581595501","13581595502","13581595503","13581595504","13581595505","13581595506","13581595507","13581595508","13581595509","13581595510","13581595511"};
	String vip_pass_client = Data.zzmm;
	String[] vip_rate_client = {"+0.1%","+0.2%","+0.3%","+0.4%","+0.5%","+0.6%","+0.7%","+0.8%","+0.9%","+1.0%","+1.5%"};
	
	String normalInterestAccrual_tel_client = "13581565500";
	String normalInterestAccrual_pass_client = Data.zzmm;
	
	String[] telArray_test = {"18880000199","eloancn04@163.com","13834569527"};            //现网与test环境使用账户//[0]：普通用户；[1]：VIP1.0用户；[2]：VIP1.5用户；无虚拟账户
	String[] nameArray_test = {"耿新之","赵桂芝","于晓莉"};	     							   //姓名
	String[] password_test = {"111111","111111","13834569527"};						       //登录密码
	String[] payPass_test = {Data.test2_zzmm, Data.zzmm, "sunny783117"};                   //支付密码
	String day_test = "365";
	String eCunBaoName_test = "2645期";
	String[] creditorDetails_test = {"二次贷用于...","曾**","3505211983********","泉州市","￥50000","11.60%","365天","查看详情"};
	String cancel_tel_test = "13011876410";													//注销过身份证的账户
	String cancel_pass_test = Data.zzmm;
	String cancel_payPass_test = Data.zzmm;
	String jinErDuiBi_tel_test = Data.test2_tel;
	String jinErDuiBi_pass_test = Data.test2_password;
	
	double balance;                            //账户可用余额
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			
			telArray = telArray_client;
			nameArray = nameArray_client;
			password = password_client;
			payPass = payPass_client;
			day = day_client;
			eCunBaoName = eCunBaoName_client;
			cancel_Tel = cancel_tel_client;
			cancel_Pass = cancel_pass_client;
			cancel_PayPass = cancel_payPass_client;
			jieKuanRen_Tel = jieKuanRen_tel_client;
			jieKuanRen_Pass = jieKuanRen_pass_client;
			jieKuanRen_PayPass = jieKuanRen_PayPass_client;
			jinErDuiBi_Tel = jinErDuiBi_tel_client;
			jinErDuiBi_Pass = jinErDuiBi_pass_client;
			vip_Tel = vip_tel_client;
			vip_Pass = vip_pass_client;
			vip_Rate = vip_rate_client;
			normalInterestAccrual_Tel = normalInterestAccrual_tel_client;
			normalInterestAccrual_Pass = normalInterestAccrual_pass_client;
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			
			telArray = telArray_test;
			nameArray = nameArray_test;
			password = password_test;
			payPass = payPass_test;
			day = day_test;
			eCunBaoName = eCunBaoName_test;
			cancel_Tel = cancel_tel_test;
			cancel_Pass = cancel_pass_test;
			cancel_PayPass = cancel_payPass_test;
			jinErDuiBi_Tel = jinErDuiBi_tel_test;
			jinErDuiBi_Pass = jinErDuiBi_pass_test;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}

	@DataProvider(name="user")
	public Object[][] Users(){
		
		Object[][] users = null;
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			users = new Object[][]{
				{telArray[0], nameArray[0], password[0], payPass[0]},       //普通用户
				{telArray[1], nameArray[1], password[1], payPass[1]},       //VIP1.0用户
				{telArray[2], nameArray[2], password[2], payPass[2]},       //VIP1.5用户
				{telArray[3], nameArray[3], password[3], payPass[3]}        //虚拟用户
			};
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			users = new Object[][]{
				{telArray[0], nameArray[0], password[0], payPass[0]},       //普通用户
//				{telArray[1], nameArray[1], password[1], payPass[1]},       //VIP1.0用户
//				{telArray[2], nameArray[2], password[2], payPass[2]},       //VIP1.5用户
			};
		}
	
		return users;
	}
	
	@DataProvider(name="VIP")
	public Object[][] VIP_Client_Users(){
		
		Object[][] users = null;
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			users = new Object[][]{
				{vip_tel_client[0], vip_pass_client, vip_rate_client[0]},       
				{vip_tel_client[1], vip_pass_client, vip_rate_client[1]}, 
				{vip_tel_client[2], vip_pass_client, vip_rate_client[2]}, 
				{vip_tel_client[3], vip_pass_client, vip_rate_client[3]}, 
				{vip_tel_client[4], vip_pass_client, vip_rate_client[4]}, 
				{vip_tel_client[5], vip_pass_client, vip_rate_client[5]}, 
				{vip_tel_client[6], vip_pass_client, vip_rate_client[6]}, 
				{vip_tel_client[7], vip_pass_client, vip_rate_client[7]}, 
				{vip_tel_client[8], vip_pass_client, vip_rate_client[8]}, 
				{vip_tel_client[9], vip_pass_client, vip_rate_client[9]}, 
				{vip_tel_client[10], vip_pass_client, vip_rate_client[10]}
			};
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			users = new Object[][]{
					{vip_tel_client[0], vip_pass_client, vip_rate_client[0]}
				};
		}
	
		return users;
	}
	
	/*****************************************************/
	/******************   翼存宝_翼存宝投资          *****************/
	/*****************************************************/
	
	/**
	 * 首页购买翼存宝（使用不同账户）
	 * 备注：借鉴928_2
	 * @param tel:手机号
	 * @param pass：登录密码
	 */
	@Test(priority = 1, dataProvider = "user", enabled = true)
	public void buyECunBaoByHomePage_F_1339_1344_1348_1355(String tel, String name, String pass, String payPass){
		
		Reporter.log("翼存宝投资_P1:首页——>普通用户/VIP1.0/VIP1.5/虚拟账户投资翼存宝");
		
		base.logout();
		loginPage.loginByMyAccount(tel, pass);
		//获取账户可用余额
		try {
			balance = myAccountPage.getBalance();
		} catch (Exception e) {
			System.out.println("我的账户：账户可用余额获取失败");
			Reporter.log("我的账户：账户可用余额获取失败");
		}
		base.openBrowser(base.indexURL);
		base.checkTitle(PageTitles.shouYe);
		//投一笔
		try {
			eCunBaoPage.touYiBi("1",payPass,0,balance);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("账户：" + tel + "首页翼存宝：投一笔 操作失败！");
			Reporter.log("账户：" + tel + "首页翼存宝：投一笔 操作失败！");
		}
		//马上投资
		System.out.println("首页翼存宝：马上投资 操作");
		Reporter.log("首页翼存宝：马上投资 操作");
		try {
			eCunBaoPage.maShangTouZi("1",payPass,0,balance);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("账户：" + tel + "首页翼存宝：马上投资  操作失败！");
			Reporter.log("账户：" + tel + "首页翼存宝：马上投资  操作失败！");
		}
	}
	
	/**
	 * 翼存宝列表页购买翼存宝（使用不用账户）
	 * 备注：前台“加入记录”有延迟，故无法校验投资人姓名、投资时间、投资金额、购买方式
	 * @param tel 手机号
	 * @param name 姓名
	 * @param pass 登录密码
	 * @param payPass 支付密码
	 * @author 江渤洋
	 */
	@Test(priority = 2, dataProvider = "user", enabled = true)
	public void buyECunBaoByECunBaoPage_F_1340_1347_1349_1357(String tel, String name, String pass, String payPass){
		
		Reporter.log("翼存宝投资_P1:翼存宝列表页——>普通用户/VIP1.0/VIP1.5/虚拟账户投资翼存宝");
		
		String productId = ""; //翼存宝产品ID
		String amount = "100";
		String joinTime = ""; //购买翼存宝的时间
		
		base.logout();
		loginPage.loginByMyAccount(tel, pass);
		//获取账户可用余额
		try {
			balance = myAccountPage.getBalance();
		} catch (Exception e) {
			System.out.println("我的账户：账户可用余额获取失败");
			Reporter.log("我的账户：账户可用余额获取失败");
		}
		base.openBrowser(base.indexURL+"/new/loadAllWmpsRecords.action");
		base.checkTitle(PageTitles.yiCunBao);
		//点击“抢投”按钮
		productId = eCunBaoPage.checkTenderTotalBtnRecharge();  //System.out.println("ECunBao id: " + id);//----------测试
		//如果没有弹出无法抢投对话框，则抢投。-1 代表没有按钮，0 代表弹出错误框
		if(!productId.equals("0") && !productId.equals("-1")){
			//输入金额
			eCunBaoPage.inputInvestmentAmountTxt(productId, amount);
			//点击“同意协议并投资”
			eCunBaoPage.clickAgreeInvestmentBtn(productId);      //System.out.println("ECunBao2 id: " + id);
			joinTime = base.dateFormat(base.getTime(), "yyyy-MM-dd HH:mm");
			//获取操作失败DIV
			if(eCunBaoPage.getOperationFailureDiv()){
				eCunBaoPage.closeOperationFailureDiv();
				System.out.println("翼存宝投资后，显示操作失败~");
			}
			//购买后有2分钟延迟，故无法校验-----------------
//			//重新登录
//			loginPage.reLogin(tel, pass);
//			base.openBrowser(base.indexURL+"/new/loadAllWmpsRecords.action");
//			base.checkTitle("【翼存宝】-翼龙贷");
//			//点击并校验（系统延迟，无法校验）
//			eCunBaoPage.checkRecord(productId, "1", name, amount, joinTime);
		}
	}
	
	@Test(priority = 3, dataProvider = "user", enabled = false)
	public void checkFundRunningWater_F_1239_1240_1241_1305(String tel, String name, String pass, String payPass){
		
		Reporter.log("翼存宝投资_P1:我的账户——>翼存宝页——>普通用户/VIP1.0/VIP1.5/虚拟账户查看翼存宝资金流水");
	
		String waitPrincipalNumStrByLend = "0.00";
		String waitInterestNumStrByLend = "0.00";
	
		base.logout();
		loginPage.loginByMyAccount(tel, pass);
		
		//散标投资————校验“待收本金”、“待收利息”
		myAccountPage.turnToMyAccount("散标投资");
		base.checkVisible(SBInvestPage.SBInvestTxt);
		base.sleep(2000);
		//散标投资中 “待收本金” 无法校验故从页面获取
		waitPrincipalNumStrByLend =	sBInvestPage.getRetrieveInfoNum("待收本金");
		//散标投资中 “待收利息” 无法校验故从页面获取
		waitInterestNumStrByLend = sBInvestPage.getRetrieveInfoNum("待收利息");
		
		//翼存宝————校验“待收本金”、“待收利息”、“待收笔数”
		myAccountPage.turnToMyAccount("翼存宝");
		base.checkVisible(YCBPage.YCBTxt);
		yCBPage.clickPartake();  //点击“参与中”
		
		String waitPrincipalNumStrByECB = yCBPage.getECunBaoInfoData("待收本金");
		String waitInterestNumStrByECB = yCBPage.getECunBaoInfoData("待收利息");
		String waitEachNumStrByECB = yCBPage.getECunBaoInfoData("待收笔数");
		
		double waitPrincipalNumDouByECB = yCBPage.getColumnSumByPartake("加入总金额");
		double waitInterestNumDouByECB = base.subtract(yCBPage.getColumnSumByPartake("预计总收益"), yCBPage.getColumnSumByPartake("已获总收益"));
		double waitEachNumByDouECB = yCBPage.getColumnSumByPartake("投资总笔数");
	
		//翼存宝“待收本金” = 参与中（“加入总金额”之和）
		base.assertEqualsActualExpected(waitPrincipalNumStrByECB, base.appendZero(String.valueOf(waitPrincipalNumDouByECB)));
		//翼存宝“待收利息” = 参与中（“预计总收益”之和 - “已获总收益”）
		base.assertEqualsActualExpected(waitInterestNumStrByECB, base.appendZero(String.valueOf(waitInterestNumDouByECB)));
		//翼存宝“待收笔数” = 参与中（“投资总笔数”之和）
		base.assertEqualsActualExpected(waitEachNumStrByECB + ".0", String.valueOf(waitEachNumByDouECB));

		//账户总览————检验“账户总资产”（散标代收本金 + 翼存宝待收本金 + 待收利息 + 可用余额 + 冻结金额）
		//账户总览中 “散标代收本金” = 散标投资中 “待收本金”
		//账户总览中 “翼存宝待收本金” = 翼存宝中 “待收本金”
		myAccountPage.turnToMyAccount("账户总览");
		base.sleep(2000);
		//账户总览中“账户总资产”
		String totalAssetsNum = myAccountPage.getMoneyNum(myAccountPage.NumberinTotalAssets); 
		//账户总览中 “待收利息” = 散标投资中“待收利息” + 翼存宝中“待收利息”
		String waitInterestNum = base.add(Double.valueOf(waitInterestNumStrByLend), Double.valueOf(waitInterestNumStrByECB)) + "";
		waitInterestNum = base.appendZero(waitInterestNum);
		//账户总览中 “可用余额” 无法校验故从页面获取
		String availableBalanceNum = String.valueOf(base.doubleFormat(myAccountPage.getBalance()));
		availableBalanceNum = base.appendZero(availableBalanceNum);
		//冻结金额
		String frozenMoneyNum = myAccountPage.getMoneyNum(myAccountPage.NumberinFrozenMoney);
		
		//账户总览中 “冻结金额” 冻结资金明细中 “冻结金额”之和
		myAccountPage.clickFreezingStatisticsImg();
		String frozenMoneyNumByMA = myAccountPage.getFreezeMoneySum(myAccountPage.getFreezingStatistics("冻结金额")) + "";
		frozenMoneyNumByMA = base.appendZero(frozenMoneyNumByMA);
		myAccountPage.clickCloseFreezeLnk();
		base.assertEqualsActualExpected(frozenMoneyNum, frozenMoneyNumByMA);
		//账户总资产详细信息
		List<String> assetsList = myAccountPage.getAssets();
		myAccountPage.checkAssets(assetsList, waitPrincipalNumStrByLend, waitPrincipalNumStrByECB, waitInterestNum, availableBalanceNum, frozenMoneyNum, totalAssetsNum);
	}
	
	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void checkCancelIDCardInvestECunBao_F_4673(){
		
		Reporter.log("翼存宝投资_P1:注销过身份证的投资翼存宝</br>");
		System.out.println("翼存宝投资_P1:注销过身份证的投资翼存宝");
		
		String buyShareNum = "1";//购买份数
		String money = "100";
		base.logout();
		loginPage.loginByMyAccount(cancel_Tel, cancel_Pass);
		TotalPage.openPage("首页", true);
		eCunBaoPage.immediatelyInvestment(buyShareNum, cancel_PayPass);
		TotalPage.openPage("翼存宝列表页", true);
		eCunBaoPage.qiangTou(money);
	}
	
	
	/*****************************************************/
	/******************     翼存宝_参与中            *****************/
	/*****************************************************/
	
	@Test(priority = 5, dataProvider = "user", enabled = true)
	public void checkDownloadFinancialAgreement_F_1320_1366_1367_1368(String tel, String name, String pass, String payPass){

		Reporter.log("翼存宝投资_P1:我的账户——>翼存宝页——>参与中——>普通用户/VIP1.0/VIP1.5/虚拟账户查看翼存宝详情");
	
		if(name.equals("张莹") || name.equals("张莹一") || name.equals("张莹二") || name.equals("林尚春")){
			creditorDetails = creditorDetails_chient;
		}
		else if(name.equals("耿新之") || name.equals("于晓莉") || name.equals("赵桂芝")){
			creditorDetails = creditorDetails_test;
		}
		
		if(base.Windowsize() != 1){
			base.closeAndjumptoOldWindow();
		}
		
		base.logout();
		loginPage.loginByMyAccount(tel, pass);
		
		//翼存宝————校验“待收本金”、“待收利息”、“待收笔数”
		myAccountPage.turnToMyAccount("翼存宝");
		//点击“参与中”
		yCBPage.clickPartake();
		yCBPage.checkPartake();
		yCBPage.clickAppointViewDetails(day);
		yCBPage.checkViewDetails(day);
		yCBPage.checkViewDetailsByValue(eCunBaoName);
		//校验“债权详情”列表信息
		yCBPage.checkCreditorDetails(eCunBaoName, creditorDetails);
		//校验“理财协议”下载PDF
		yCBPage.checkFinanceAgreementByOld(eCunBaoName);
	}
	
	/*****************************************************/
	/****************** 翼存宝_借款人投资翼存宝    *****************/
	/*****************************************************/
	
	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4888(){
		Reporter.log("翼存宝_借款人投资翼存宝_P1:未发布借款投资翼存宝</br>");
		System.out.println("翼存宝_借款人投资翼存宝_P1:未发布借款投资翼存宝</br>");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//购买份数
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[0], jieKuanRen_Pass[0]);
			TotalPage.openPage("首页", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("翼存宝列表页", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4889(){
		Reporter.log("翼存宝_借款人投资翼存宝_P1：正在审核中的借款投资翼存宝</br>");
		System.out.println("翼存宝_借款人投资翼存宝_P1：正在审核中的借款投资翼存宝");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//购买份数
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[1], jieKuanRen_Pass[1]);
			TotalPage.openPage("首页", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("翼存宝列表页", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4890(){
		Reporter.log("翼存宝_借款人投资翼存宝_P1:还款中投资翼存宝</br>");
		System.out.println("翼存宝_借款人投资翼存宝_P1:还款中投资翼存宝");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//购买份数
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[2], jieKuanRen_Pass[2]);
			TotalPage.openPage("首页", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("翼存宝列表页", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 9, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4891(){
		Reporter.log("翼存宝_借款人投资翼存宝_P1:一次借款已还完款投资翼存宝</br>");
		System.out.println("翼存宝_借款人投资翼存宝_P1:一次借款已还完款投资翼存宝");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//购买份数
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[3], jieKuanRen_Pass[3]);
			TotalPage.openPage("首页", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("翼存宝列表页", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 10, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4892(){
		Reporter.log("翼存宝_借款人投资翼存宝_P1:多次借款没有逾期记录投资翼存宝</br>");
		System.out.println("翼存宝_借款人投资翼存宝_P1:多次借款没有逾期记录投资翼存宝");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//购买份数
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[4], jieKuanRen_Pass[4]);
			TotalPage.openPage("首页", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("翼存宝列表页", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 11, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4893(){
		Reporter.log("翼存宝_借款人投资翼存宝_P1:借款人投资翼存宝</br>");
		System.out.println("翼存宝投资_P1:借款人投资翼存宝");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//购买份数
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[5], jieKuanRen_Pass[5]);
			TotalPage.openPage("首页", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("翼存宝列表页", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 12, enabled = true, invocationCount = 1)
	public void checkcheckBorrowerInvestmentECunBao_F_4895(){
		
		Reporter.log("翼存宝_借款人投资翼存宝_P1:正在借款逾期投资翼存宝</br>");
		System.out.println("翼存宝投资_P1:正在借款逾期投资翼存宝");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String msg = "抱歉，您发布的借款出现了逾期，账户被冻结，请先还款再执行此操作!";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[6], jieKuanRen_Pass[6]);
			TotalPage.openPage("首页", true);
			eCunBaoPage.checkImmediatelyInvestmentErrorMsg(msg);
			TotalPage.openPage("翼存宝列表页", true);
			eCunBaoPage.checkQiangTouBtnErrorMsg(msg);
		}
	}
	
	/*****************************************************/
	/******************    翼存宝_金额对比           *****************/
	/*****************************************************/
	
	@Test(priority = 13, enabled = true, invocationCount = 1)
	public void checkInterestEarned_F_1323(){
		
		Reporter.log("翼存宝_金额比对_P1:投资翼存宝后查看所有金额变动</br>");
		System.out.println("翼存宝_金额比对_P1:投资翼存宝后查看所有金额变动");
		
		String money = "100";
		base.logout();
		loginPage.loginByMyAccount(jinErDuiBi_Tel, jinErDuiBi_Pass);
		TotalPage.openPage("翼存宝列表页", true);
		eCunBaoPage.qiangTou(money);
		
		TotalPage.openPage("我的账户", true);
		String yesterdayTotalIncomeByMA = myAccountPage.getMoneyNum(myAccountPage.YCBEarnInterestNum);//我的账户->账户总览->已赚利息
		System.out.println("我的账户->账户总览->已赚利息: " + yesterdayTotalIncomeByMA);
		myAccountPage.turnToMyAccount("翼存宝");
		String yesterdayTotalIncomeByECB = yCBPage.getECunBaoInfoData("已赚利息");//我的账户->翼存宝->已赚利息
		System.err.println("我的账户->翼存宝->已赚利息: " + yesterdayTotalIncomeByECB);
		TotalPage.openPage("翼存宝列表页", true);
		String accumulatedIncomeBy = eCunBaoPage.getBannerData("累计收益");//翼存宝列表页->banner->累计收益
		System.out.println("累计收益: " + accumulatedIncomeBy);
	}
	
	/*****************************************************/
	/******************    翼存宝_VIP测试          *****************/
	/*****************************************************/
	
	
	/*****************************************************/
	/*************    翼存宝_VIP测试_页面V图标测试          ************/
	/*****************************************************/
	
	@Test(priority = 14, enabled = true, invocationCount = 1, dataProvider = "VIP")
	public void checkVIPIconByMyAccount_F_4028(String tel, String pass, String rate){
		
		Reporter.log("翼存宝_VIP测试_页面V图标测试_P1:账户总览页检查V图标</br>");
		System.out.println("翼存宝_VIP测试_页面V图标测试_P1:账户总览页检查V图标");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			base.logout();
			loginPage.loginByMyAccount(tel, pass);
			TotalPage.openPage("我的账户", true);
			myAccountPage.checkUserIconMsgByOne("VIP", rate);
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			Reporter.log("test环境，没有数据，请手工测试");
			System.out.println("test环境，没有数据，请手工测试");
		}
	}
	
	@Test(priority = 15, enabled = true, invocationCount = 1, dataProvider = "VIP")
	public void checkVIPIconByHomePage_F_4029(String tel, String pass, String rate){
		
		Reporter.log("翼存宝_VIP测试_页面V图标测试_P1:首页投资窗口页检查V图标</br>");
		System.out.println("翼存宝_VIP测试_页面V图标测试_P1:首页投资窗口页检查V图标");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			base.logout();
			loginPage.loginByMyAccount(tel, pass);
			TotalPage.openPage("首页", true);
			List<String> strLists = indexPage.getECunBaoCellDataStr("年化收益");
			indexPage.checkAnnualReturns(strLists, rate);
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			Reporter.log("test环境，没有数据，请手工测试");
			System.out.println("test环境，没有数据，请手工测试");
		}
	}
	
	@Test(priority = 16, enabled = true, invocationCount = 1, dataProvider = "VIP")
	public void checkVIPIconByECunBaoPage_F_4030(String tel, String pass, String rate){
		
		Reporter.log("翼存宝_VIP测试_页面V图标测试_P1:检查翼存宝个页面利率的显示</br>");
		System.out.println("翼存宝_VIP测试_页面V图标测试_P1:检查翼存宝个页面利率的显示");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			base.logout();
			loginPage.loginByMyAccount(tel, pass);
			TotalPage.openPage("翼存宝列表页", true);
			eCunBaoPage.checkECunBaoInfoByVIP(rate);
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			Reporter.log("test环境，没有数据，请手工测试");
			System.out.println("test环境，没有数据，请手工测试");
		}
	}
	
	/*****************************************************/
	/***********  翼存宝_VIP测试_分散投资合并计息及次数        ***********/
	/*****************************************************/
	
	@Test(priority = 17, enabled = true, invocationCount = 1)
	public void checkbuyECunBaoAccrualAndCount_F_4048(){
		
		Reporter.log("翼存宝_VIP测试_分散投资合并计息及次数_P1:普通用户分散投资合并计息及次数</br>");
		System.out.println("翼存宝_VIP测试_分散投资合并计息及次数_P1:普通用户分散投资合并计息及次数");
		
		String eCunBaoName = "auto"; 		//翼存宝名称
		String amount = "1000";				//购买金额
		String rate = "0.125";				//购买利率
		String validity = "1";				//购买有效期（小时）
		String limit = "3";					//合约期限（天）
		String createData = "";				//创建日期
		String publishedDate = "";			//发布日期
		String accrualData = "";			//计息日期
		String repaymentData = "";			//还本日期
		String investSumBefore = "";		//投资总笔数
		String investSumAfter = "";
		String addSumBefore = ""; 			//加入总金额
		String addSumAfter = "";
		String eCunBaoID = "";				//翼存宝ID
		String money = "100";				//购买翼存宝钱数
		String addBefore = "";				//加入金额
		String addAfter = "";				
		String anticipatedIncome = "";//预计收益
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
		
			eCunBaoName = eCunBaoName + base.dateFormat(new Date(), "MMddHHmmss");
			createData = publishedDate = base.getTimeStamp();
			accrualData = eCunBaoPage.calculateAccrualData(publishedDate, validity);
			repaymentData = eCunBaoPage.calculateRepaymentData(accrualData, limit);	
			
			base.logout();
			eCunBaoPage.checkPublishECaoBao(eCunBaoName, amount, rate, validity, limit, createData, publishedDate, accrualData, repaymentData);
			loginPage.loginByMyAccount(normalInterestAccrual_Tel, normalInterestAccrual_Pass);
			TotalPage.openPage("我的账户", true);
			myAccountPage.turnToMyAccount("翼存宝");
			myAccountPage.isGoMyAccount("翼存宝");
			yCBPage.clickPartake();
			investSumBefore = yCBPage.getPartakeValue(limit, "投资总笔数");
			investSumBefore = yCBPage.formatInvestSum(investSumBefore);
			addSumBefore = yCBPage.getPartakeValue(limit, "加入总金额");
			addSumBefore = base.removeComma(addSumBefore);
			addSumBefore = base.removeZero(addSumBefore);
			System.out.println("投资总笔数（投资前）:" + investSumBefore + " 笔，加入总金额（投资前）:" + addSumBefore + " 元");
			Reporter.log("投资总笔数（投资前）:" + investSumBefore + " 笔，加入总金额（投资前）:" + addSumBefore + " 元");
			
			//首次购买翼存宝
			TotalPage.openPage("翼存宝列表页", true);
			eCunBaoID = eCunBaoPage.getProductIDByECunBaoTitle(eCunBaoName);
			eCunBaoPage.qiangTou(eCunBaoID, money);
			
			//首次校验“投资总笔数”、“投入总金额”
			myAccountPage.turnToMyAccount("翼存宝");
			myAccountPage.isGoMyAccount("翼存宝");
			yCBPage.clickPartake();
			investSumAfter = yCBPage.getPartakeValue(limit, "投资总笔数");
			investSumAfter = yCBPage.formatInvestSum(investSumAfter);
			addSumAfter = yCBPage.getPartakeValue(limit, "加入总金额");
			addSumAfter = base.removeComma(addSumAfter);
			addSumAfter = base.removeZero(addSumAfter);
			System.out.println("投资总笔数（投资后）:" + investSumAfter + " 笔，加入总金额（投资后）:" + addSumAfter + " 元");
			Reporter.log("投资总笔数（投资后）:" + investSumAfter + " 笔，加入总金额（投资后）:" + addSumAfter + " 元");
			base.assertEqualsActualExpected(investSumAfter, (Integer.parseInt(investSumBefore) + 1) + "");
			base.assertEqualsActualExpected(addSumAfter, (Integer.parseInt(addSumBefore) + Integer.parseInt(money)) + "");
			investSumBefore = investSumAfter;
			addSumBefore = addSumAfter;
			
			//首次校验“加入金额”、“预计收益”
			yCBPage.clickAppointViewDetails(limit);
			base.assertTrueByBoolean(TotalPage.isSearchFieldByList(yCBPage.getViewDetailsBy("投资期数"), eCunBaoName));
			addBefore = yCBPage.getViewDetailsValue(eCunBaoName, "加入金额");
			addBefore = base.removeComma(addBefore);
			addBefore = base.removeZero(addBefore);
			anticipatedIncome = yCBPage.getViewDetailsValue(eCunBaoName, "预计收益");
			System.out.println("加入金额（投资前）:" + addBefore + " 元，预计收益（投资前）:" + anticipatedIncome + " 元");
			Reporter.log("加入金额（投资前）:" + addBefore + " 元，预计收益（投资前）:" + anticipatedIncome + " 元");
			base.assertEqualsActualExpected(addBefore, money);
			base.assertEqualsActualExpected(anticipatedIncome, eCunBaoPage.calculateECunBaoIncome(money, rate, limit));
			
			//二次购买翼存宝
			TotalPage.openPage("翼存宝列表页", true);
			eCunBaoPage.qiangTou(eCunBaoID, money);
			
			//二次校验“投资总笔数”、“投入总金额”
			myAccountPage.turnToMyAccount("翼存宝");
			myAccountPage.isGoMyAccount("翼存宝");
			yCBPage.clickPartake();
			investSumAfter = yCBPage.getPartakeValue(limit, "投资总笔数");
			investSumAfter = yCBPage.formatInvestSum(investSumAfter);
			addSumAfter = yCBPage.getPartakeValue(limit, "加入总金额");
			addSumAfter = base.removeComma(addSumAfter);
			addSumAfter = base.removeZero(addSumAfter);
			System.out.println("投资总笔数（二次投资后）:" + investSumAfter + " 笔，加入总金额（二次投资后）: " + addSumAfter + " 元");
			Reporter.log("投资总笔数（二次投资后）:" + investSumAfter + " 笔，加入总金额（二次投资后）: " + addSumAfter + " 元");
			base.assertEqualsActualExpected(investSumAfter, investSumBefore);
			base.assertEqualsActualExpected(addSumAfter, (Integer.parseInt(addSumBefore) + Integer.parseInt(money)) + "");
			
			//二次校验“加入金额”、“预计收益”
			yCBPage.clickAppointViewDetails(limit);
			base.assertTrueByBoolean(TotalPage.isSearchFieldByList(yCBPage.getViewDetailsBy("投资期数"), eCunBaoName));
			addAfter = yCBPage.getViewDetailsValue(eCunBaoName, "加入金额");
			addAfter = base.removeComma(addAfter);
			addAfter = base.removeZero(addAfter);
			anticipatedIncome = yCBPage.getViewDetailsValue(eCunBaoName, "预计收益");
			System.out.println("加入金额（投资后）:" + addAfter + " 元，预计收益（投资后）:" + anticipatedIncome + " 元");
			Reporter.log("加入金额（投资后）:" + addAfter + " 元，预计收益（投资后）:" + anticipatedIncome + " 元");
			base.assertEqualsActualExpected(addAfter, (Integer.parseInt(addBefore) + Integer.parseInt(money)) + "");
			base.assertEqualsActualExpected(anticipatedIncome, eCunBaoPage.calculateECunBaoIncome(addAfter, rate, limit));
		}
		else{
			Reporter.log("error_现网环境，请手动测试!");
			System.out.println("error_现网环境，请手动测试!");
		}
	}
}






