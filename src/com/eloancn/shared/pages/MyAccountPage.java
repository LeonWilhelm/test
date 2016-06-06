package com.eloancn.shared.pages;

import java.awt.Robot;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.*;

/*
 * “我的账户”-“账户总览”页面
 */
public class MyAccountPage {
	Base base = new Base();
	DBData dbData = new DBData();
	
	RechargePage rechargePage = new RechargePage();
	InsideLetterPage insideLetterPage = new InsideLetterPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	ElectronicIOU electronicIOU = new ElectronicIOU();
	public String MyAccountUrl = base.indexURL + "/page/userMgr/myHome.jsp";
	
	By userName = By.id("accountRealName");	//用户名
	By isLoginTrueTxt = By.xpath("//*[contains(text(),'欢迎您')]");
	By MyAccountLink = By.xpath("//li/a[text()='我的账户']");
	
	//左侧“我的账户”部分
	By MyAccountTxtinLeft = By.cssSelector("div.m-navlist>h2");			//“我的账户”文本
	By FivePartinLeft = By.cssSelector("div.m-navlist>ul");
	By AccountOverviewLnk = By.id("myhome_1");							//账户总览	
	By TransactionRecordLnk = By.id("myhome_2");						//交易记录	
	By RechargeLnk = By.id("myhome_3");									//充值	
	By WithdrawLnk = By.id("myhome_4");									//提现	
	By MyRewardLnk = By.id("myhome_5");									//我的奖励

	//左侧“我的贷出”部分
	By YiCunBao = By.id("myhome_6");									//翼存宝
	By SanBiao = By.id("myhome_7");										//散标投资
	By CreditAssignment = By.id("myhome_8");							//债权转让	
	By AutoBid = By.id("myhome_9");										//自动投标	
//	By AppointBid = By.id("myhome_10");									//预约投标
	
	//左侧“翼星计划”部分
	By MyInvestPlanLnk = By.id("myhome_16");							//我的投资计划
	By MyLoanPlanLnk = By.id("myhome_17");								//我的借入计划
	
	
	//左侧“我的借入”部分
	By MyBorrowLnk = By.id("myhome_11");								//我的借款
	By ApplyforLoanLnk = By.id("myhome_12");							//申请借款
	
	//左侧“账户设置”部分
	By AccountInfoLnk = By.id("myhome_13");								//账户信息
	By SecurityAuthLnk = By.id("myhome_14");							//安全认证
	By noticeSettingLnk = By.id("myhome_15");							//通知设置
	
	public static By SelectedLnk = By.cssSelector("a.ico-accuntinfo.accountpandect.cur");//被选中的模块
			
	/****************************我的账户-账户总览页面******************************/
	//用户信息部分
	By AccountOverviewTxt = By.cssSelector("div.main-top-lw.ofv>h1");		//“账户总览”标题
	By Image = By.cssSelector("a.head > img[title=\"头像\"]");				//账户头像
	By TimeTxt = By.id("time_greet2");										//时间
	By UserNameTxt = By.cssSelector("div.tit>span");						//用户名
	By GreetingTxt = By.id("time_greet");									//问候语
	By AccountNameTxt = By.cssSelector("span.user-name");					//“账户名：...”
	By Icon = By.cssSelector("div.user-rz.ofv>a");							//4个验证图标
	By GoMobileAuth = By.cssSelector("div.userrz-tip-c");					//图标提示信息
//	By MobileCertification = By.id("icon-h-1");
//	By Authentication = By.id("icon-h-2");
//	By EmailCertification = By.id("icon-h-3-y");
//	By PayCode = By.id("icon-h-4");
	By SecurityLevel = By.cssSelector("span.safe");							//“安全级别”
	By SecurityImage = By.id("safeLevel");									//安全级别图标
	By UpgradeLnk = By.id("safeLevelW");									//“提升”			
	By HighLevel = By.id("safeLevelW2");									//“高”安全级别
	
	//“已赚总利息”和“账户总资产”部分
	By TotalPart = By.cssSelector("div.add-money.overflowV");
	By TotalInterestTxt = By.cssSelector("p.tit");								//“已赚总利息”
	By TotalAssetsTxt = By.cssSelector("div.overflowV.clear > span");			//“账户总资产”
	By NumberinTotalInterest = By.id("accumulative");							//总利息金额
	public By NumberinTotalAssets = By.id("total_assets");								   //总资产金额		
	By MoneyIconinTotalInterest = By.cssSelector("div.money-icon.posiR.counttotalnumico1");//利息图标
	By MoneyIconinTotalAssets =	By.cssSelector("div.money-icon.posiR.counttotalnumico");	//资产图标
	By EarnInterestTxt = By.cssSelector("#tank3>ul.tankul>li");								//利息图标提示
	By TotalAssertsTxt = By.cssSelector("div.tank1>ul.tankul>li");							//资产图标提示
	By sanBiaoWaitPrincipalNum = By.cssSelector("#total_balance_info_11");		//“散标待收本金”
	By yCBWaitPrincipalNum = By.cssSelector("#total_balance_info_12");			//“翼存宝待收本金”
	By totalWaitInterestNum = By.cssSelector("#total_balance_info_13");			//“待收利息”
	By availableBalanceNum = By.cssSelector("#total_balance_info_14");			//“可用余额”
	By frozenMoneyNum = By.cssSelector("#total_balance_info_15");				//“冻结金额”
	By totalAssetsNum = By.cssSelector("#total_balance_info_17"); 				//“账户总资产”
	
	//"可用余额"和"冻结金额"部分
	By BalancePart = By.cssSelector("div.minus-money");
	By AvailableBalance = By.cssSelector("div.minus-money>div.tit");			//“余额”，“冻结”	
//	By FrozenMoney = By.cssSelector("div.minus-money>div.tit");					
	public By NumberinAvailableBalance = By.id("statField2");					//“可用余额”金额
	public By NumberinFrozenMoney = By.id("statField3");						//“冻结金额”金额
	By FreezingStatisticsImg = By.xpath("//a[@id='freezingStatistics']/img");	//冻结明细图标
	By FreezedetailTitleTxt = By.id("saveTitle");								//“冻结明细”标题
	By FreezeTime = By.xpath("//table[@id='detailstable']/tbody/*/td[2]");		//冻结时间
	By FreezeMoney = By.xpath("//table[@id='detailstable']/tbody/*/td[1]");		//冻结金额
	By FirstFreeze = By.cssSelector("#detailstable>tbody>tr>td");				//第一天冻结信息
//	By FreezeMoney = By.cssSelector("#detailstable>tbody>tr>td.colorG");
	By CloseFreezeLnk = By.cssSelector("a.tip_close.cpt");
	By rechargeBtn = By.cssSelector("div.buttn-cz>a.BtnOrange.fl.mt10");		//“充值”
//	By rechargeBtn = By.xpath("(//a[contains(text(),'充值')])[3]");
	By ImproveProfileTxt = By.xpath("//form[@id='userFrom']/div/table/tbody/tr/td/div/div/h2");						//“完善个人信息”提示
	By WithDrawBtn = By.cssSelector("div.buttn-tx>a.BtnBlue.fl.mt10.ml10");		//“提现”
	By WithDrawTip = By.cssSelector("h2.u-tt");					//“安全认证”提示
	
	//“您还没有投资哦，赶快来加入...”部分或者“此页面数据不包括翼星计划...”
	By NoInvestmentTxt = By.cssSelector("div.tzyd > p");			//没有投资或不包括翼星计划的信息
	By InvestNowLnk = By.cssSelector("div.tzyd > p > a");			//“即刻投资”或“点击查看翼星计划”
	
	//"翼存宝投资"部分
	By YiCunBaoInvestTxt = By.cssSelector("div.tzcp > h1");				//“翼存宝投资”
	By YCBEarnInterestTxt = By.cssSelector("div.tzcp-fl > p.tit");		//“已赚利息”
	public By YCBEarnInterestNum= By.id("ycb_had_interest");					//已赚利息金额
	By YCBWaitInterestTxt = By.cssSelector("div.tzcp-fr > p.tit");		//“待收利息”
	By YCBWaitPrincipalTxt = By.cssSelector("div.tzcp-fr > p.tit");		//“待收本金”
	By YCBWaitInterestNum = By.id("ycb_wait_interest");					//待收利息金额
	By YCBWaitPrincipalNum = By.id("ycb_wait_principal");				//待收本金金额
	By YCBViewDetailsLnk = By.cssSelector("p.link > a");				//查看详情
	
	//“散标投资”部分
//	By SanBiaoInvestTxt = By.cssSelector("div.tzcp > h1");//YiCunBaoInvestTxt
	By SanBiaoInvestTxt = By.xpath("//div[@id='_content']/div/div[4]/div[2]/h1");
	By SanBiaoInfoTxt = By.cssSelector("div.tzcp >h1 > small");
	By SBEarnInterestTxt = By.xpath("//div[@id='_content']/div/div[4]/div[2]/div/div/p");
	By SBEarnInterestIcon = By.id("qt2s");
	By SBInterestIcon = By.cssSelector("div.tzcp-box>div>p.tit>a.money-icon");
	By SBTootip = By.cssSelector("div.ui-tooltip-content");
	By SBEarnInterestNum = By.id("tender_had_interest");
	By SBWaitPITxt = By.xpath("//div[@id='_content']/div/div[4]/div[2]/div/div[2]/p");
	By SBWaitPINum =By.id("tender_wait_principal_interest");
	By SBWaitPIIcon = By.id("qt3");
	By SBWaitInterestTxt = By.xpath("//div[@id='_content']/div/div[4]/div[2]/div/div[2]/p[2]");
	By SBWaitInterestNum = By.id("tender_wait_interest");
	By SBWaitInterestIcon = By.id("qa4");
	By SBWaitPrincipalTxt = By.xpath("//div[@id='_content']/div/div[4]/div[2]/div/div[2]/p[3]");
	By SBWaitPrincipalNum = By.id("tender_wait_principal");
	By SBViewDetailsLnk = By.xpath("//div[@id='_content']/div/div[4]/div[2]/div/div[2]/p[4]/a");
	
	//“我的借入”部分
	By MyLoanTxt = By.cssSelector("div.main-jrzh-lw > h1");
	By WaitRepayTxt = By.cssSelector("div.main-jrzh-lw > div.tzcp-fl > p.tit");
	By WaitRepayNum = By.id("myloan_wait_money");
	By WaitRepayPITxt = By.cssSelector("div.jrzh-fr > p.tit");
	By WaitRepayPINum = By.id("myloan_wait_principal");
	By WaitRepayInterestTxt = By.xpath("//div[@id='_content']/div/div[5]/div[2]/p[2]");
	By WaitRepayInterestNum = By.id("myloan_wait_interest");
	By LateFeeTxt = By.xpath("//div[@id='_content']/div/div[5]/div[2]/p[3]");
	By LateFeeNum = By.id("myloan_overdue_money");
	By LoanApplicationLnk = By.cssSelector("div.jrzh>p.link>a");
	By MyLoanLnk = By.xpath("//div[3]/p[2]/a");	
	
	/****************************我的账户-公共******************************/
	
	//点击上部导航“我的账户”链接
	public void clickMyAccountLink(){
		base.clickWithWait(MyAccountLink);
		base.checkElementVisible(AccountOverviewTxt);
	}
	//点击左侧导航“账户总览”链接
	public void clickAccountOverviewLnk(){
		base.clickElementNoWait(AccountOverviewLnk);
		base.checkElementVisible(AccountOverviewTxt);
	}
	//点击左侧导航“交易记录”链接
	public void clickTransactionRecord(){
		base.clickElementNoWait(TransactionRecordLnk);
		base.assertEqualsActualExpected(base.getElementText(TransactionRecordPage.TransactionRecordTxt), "交易记录");
	}
	//点击左侧导航“充值”链接
	public void clickRechargeLnk(){
		base.clickElementNoWait(RechargeLnk);
		base.assertEqualsActualExpected(base.getElementText(RechargePage.OnlineRechargeTxt), "充值");
	}
	//点击左侧导航“提现”链接
	public void clickWithDrawLnk(){
		base.clickElementNoWait(WithdrawLnk);
		base.assertEqualsActualExpected(base.getElementText(WithDrawPage.WithDrawTxt), "提现");
	}
	//点击左侧导航“我的奖励”链接
	public void clickMyRewardLnk(){
		base.clickElementNoWait(MyRewardLnk);
		base.assertEqualsActualExpected(base.getElementText(MyRewardPage.MyRedPacksLnk), "我的红包");		
	}
	//点击左侧导航“我的贷出”中的5个链接
	public void clickYCBLnk(){		
		base.clickElementNoWait(YiCunBao);
		base.checkElmentText(YCBPage.YCBTxt, "翼存宝");
	}
	//点击左侧导航“散标投资”链接
	public void clickSBInvestLnk(){
		base.clickWithWait(SanBiao);
		base.checkElmentText(SBInvestPage.SBInvestTxt, "散标投资 （散标+购买债权）");
		new SBInvestPage().ifExistInvest();
	}
	//点击左侧导航“债权转让”链接
	public void clickCreditAssignLnk(){
		base.clickWithWait(CreditAssignment);
		base.checkElmentText(CreditAssignPage.CreditAssignTxt, "债权转让");
		new CreditAssignPage().ifshowCredit();
	}
	//点击左侧导航“自动投标”链接
	public void clickAutoBidLnk(){
		
		base.clickElementNoWait(AutoBid);
		base.checkElement(AutoBidPage.Main);
	}
	//点击左侧导航“我的投资计划”链接
	public void clickMyInvestPlanLnk(){
		base.clickWithWait(MyInvestPlanLnk);
//		base.checkElement();
	}
	//点击左侧导航“我的借入计划”链接
	public void clickMyDebitPlanLnk(){
		base.clickWithWait(MyLoanPlanLnk);
		base.checkElementVisible(MyDebitPlan.ListContent);
	}
	//点击左侧导航“我的借款”链接
	public void clickMyDebtLnk(){
		base.clickWithWait(MyBorrowLnk);
		base.checkElmentText(MyLoanPage.MyLoanTxt, "我的借款");
		if(base.Windowsize()>1){
			base.closeWebDriver();
		}
	}
	//点击左侧导航“账户信息”链接
	public void clickAccountInfoLnk(){
		base.clickWithWait(AccountInfoLnk);
		base.checkElement(AccountInfoPage.AccountInfoTxt);
	}
	
	//点击左侧导航“预约投标”链接
//	public void clickAppointBitLnk(){
//		base.clickElementNoWait(AppointBid);
//		base.checkElmentText(AppointBidPage.AppointBidTxt, "预约投标");
//	}
	
	public String getUserID(){
		String text=base.ExecuteJS("var obj1=document.getElementsByTagName('body');var obj2=obj1[0].getElementsByTagName('script');return obj2[11].innerHTML");
		int begin=text.indexOf("cumember['mid']")+17;
		String userid=text.substring(begin, text.indexOf("'", begin));
		return userid;
	}
	
	/****************************我的账户-账户总览******************************/
	
	public void checkDefaultImg(){
		String src = base.getLnkElementText(Image, "src");
		if(base.indexURL.contains("client")){
			base.assertEqualsActualExpected(src.split("\\?")[0], base.indexURL+"/page/userMgr/images/userimg.png");
		}else if(base.indexURL.contains("test")){
			base.assertEqualsActualExpected(src.split("\\?")[0], "http://static66.eloancn.com//page/userMgr/images/userimg.png");
		}else if(base.indexURL.contains("www")){
			base.assertEqualsActualExpected(src.split("\\?")[0], "http://static7.eloancn.com//page/userMgr/images/userimg.png");
		}
	}
	
	//点击用户头像
	public void clickUserImageLnk(){
		base.clickElementNoWait(Image);
		base.checkElmentText(AccountInfoPage.AccountInfoTxt, "账户信息");
	}
	//点击四个认证icon
	public void clickAuthIcon(){
		
		String [] GoAuthTxt = {"手机未认证，去认证","身份未认证，去认证","邮件未认证，去认证","未设置支付密码，去设置"};
		for(int i=0;i<4;i++){
			List<WebElement> IconElements = base.getElements(Icon);
			base.mouseToIndexElement(Icon, i+1);
			if(base.getIndexElementText(GoMobileAuth,i).equals(GoAuthTxt[i])){
				IconElements.get(i+1).click();
				base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "安全认证");
				clickAccountOverviewLnk();
			}
		}
	}
	
	/**
	 * 我的账户-账户总览页，校验 认证Icon提示信息
	 * @param iconName Icon名称
	 * @param promptMsg 提示信息
	 * @author 江渤洋 2015-12-30
	 */
	public void checkUserIconMsgByOne(String iconName, String promptMsg){
		
		List<WebElement> IconElements = base.getElements(Icon);
		int size = IconElements.size();
		String position = "";
		if(size == 4){
			switch (iconName) {
			case "手机":		position = "2"; break;
			case "身份": 		position = "3"; break;
			case "邮箱":		position = "4"; break;
			case "支付密码": 	position = "5"; break;
			default:		position = "2"; break;
			}
		}
		else if(size == 5){
			switch (iconName) {
			case "VIP":		position = "2"; promptMsg = "年利率" + promptMsg; break;
			case "手机":		position = "3"; break;
			case "身份": 		position = "4"; break;
			case "邮箱":		position = "5"; break;
			case "支付密码": 	position = "6"; break;
			default:		position = "2"; promptMsg = "年利率" + promptMsg; break;
			}
		}
		By iconby = By.cssSelector("div.user-rz.ofv>a:nth-child(" + position + ")");
		By msgBy = By.cssSelector("div.user-rz.ofv>a:nth-child(" + position + ") > div >div:nth-child(2)");

		base.mouseToElement(iconby);
		System.out.println("网页获取：" + iconName + " 元素，值为：" + base.getElementText(msgBy));
		base.assertEqualsActualExpected(base.getElementText(msgBy), promptMsg);
	}
	
	/**
	 * 我的账户-账户总览页，校验 所有认证Icon提示信息
	 * @param vipMsg VIP提示信息(根据等级不同，提示而不同)，传值格式：+0.1%
	 * @author 江渤洋 2015-12-30
	 */
	public void checkUserIconMsgByAll(String vipMsg){
		
		String [] renZhengTxt =	   {"手机已认证",     "身份已认证",      "邮件已认证",     "支付密码已设置"};
		String [] weiRenZhengTxt = {"手机未认证，去认证","身份未认证，去认证","邮件未认证，去认证","未设置支付密码，去设置"};
		
		String msg = "";
		List<WebElement> IconElements = base.getElements(Icon);
		int size = IconElements.size();
		int i = 0;
		if(size == 5){//如果有VIP认证，则先校验VIP认证
			msg = IconElements.get(0).getText();
			base.assertEqualsActualExpected(msg, "年利率" + vipMsg);
			i = 1;
		}
		for(; i < size; i++){
			base.mouseToIndexElement(Icon, i);
			msg = IconElements.get(i).getText();
			if(IconElements.get(i).getAttribute("id").contains("-y")){
				base.assertEqualsActualExpected(msg, renZhengTxt[i]);
			}
			else{
				base.assertEqualsActualExpected(msg, weiRenZhengTxt[i]);
			}
		}
	}
	
	//点击“手机认证”icon
	public void clickMobileAuthIcon(){
		
		base.clickElement(Icon, 1);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "安全认证");
	}
	//点击“手机认证”提示链接
	public void clickGoMobileAuth(){
		
		base.mouseToIndexElement(Icon, 1);
		base.assertEqualsActualExpected(base.getIndexElementText(GoMobileAuth,0),"手机未认证，去认证");
		base.clickElement(GoMobileAuth, 0);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "安全认证");
	}
	//点击“身份认证”icon
	public void clickIdentityAuthIcon(){
		
		base.clickElement(Icon, 2);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "安全认证");
	}
	//点击“手机认证”提示链接
	public void clickGoIdentityAuth(){
		
		base.mouseToIndexElement(Icon, 2);
		base.assertEqualsActualExpected(base.getIndexElementText(GoMobileAuth,1),"身份未认证，去认证");	
		base.clickElement(GoMobileAuth, 1);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "安全认证");
	}
	//验证“邮箱认证”
	public void checkEmailAuth(){
		
		base.mouseToIndexElement(Icon, 3);
		base.assertEqualsActualExpected(base.getIndexElementText(GoMobileAuth,2),"邮箱已认证");
	}
	//点击“邮箱认证”icon
	public void clickEmailAuthIcon(){
		
		base.clickElement(Icon, 3);		
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "安全认证");
	}
	//点击“邮箱认证”提示链接
	public void clickGoEmailAuth(){
		
		base.mouseToIndexElement(Icon, 3);
		base.assertEqualsActualExpected(base.getIndexElementText(GoMobileAuth,2),"邮件未认证，去认证");	
		base.clickElement(GoMobileAuth, 2);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "安全认证");
	}
	//点击“支付密码”icon
	public void clickPayPwdIcon(){
		
		base.clickElement(Icon, 4);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "安全认证");
	}
	//点击“支付密码”提示链接
	public void clickGoPayPwdAuth(){
		
		base.mouseToIndexElement(Icon, 4);
		base.assertEqualsActualExpected(base.getIndexElementText(GoMobileAuth,3),"未设置支付密码，去设置");	
		base.clickElement(GoMobileAuth, 3);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "安全认证");
	}
	//点击安全级别“提升”链接
	public void clickUpgradeLnk(){
		
		if(base.getElementText(HighLevel).equals("高")){
			System.out.println("安全级别已经最高了！");
		}else{
			base.clickElement(UpgradeLnk, 0);
			base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "安全认证");
		}
	}
	
	//检查“已赚总利息”icon
	public void checkTotalInterestIcon(){		
		
		base.mouseToIndexElement(MoneyIconinTotalInterest, 0);
		String [] EarnInterest = {"翼存宝已赚利息","","散标已赚利息","","已赚总利息"};
		List<WebElement> TxtEarnElement = base.getElements(EarnInterestTxt);
		for(int i=0;i<TxtEarnElement.size();i++){
			switch(i){			
				case 1: base.assertEqualsActualExpected(TxtEarnElement.get(1).getText(),"+");break;
				case 3:	
					base.assertEqualsActualExpected(TxtEarnElement.get(3).getText(),"=");break;
				default: base.assertEqualsActualExpected(TxtEarnElement.get(i).findElement(By.tagName("p")).getText(),EarnInterest[i]);
						 TxtEarnElement.get(i).findElement(By.tagName("span")).isDisplayed();
			}
		}		
	}
	
	//检查“账户总资产”icon
	public void checkTotalAssetIcon(){
		
		base.mouseToIndexElement(MoneyIconinTotalAssets, 0);
		String [] TotalAsset = {"散标待收本金","","翼存宝待收本金","","待收利息","","可用余额","","冻结金额","","账户总资产"};	
		List<WebElement> TxtAssets = base.getElements(TotalAssertsTxt);
		for(int i=0;i<TxtAssets.size();i++){
			switch(i){	
				case 1:case 3:case 5: case 7: base.assertEqualsActualExpected(TxtAssets.get(i).getText(),"+");break;
				case 9:base.assertEqualsActualExpected(TxtAssets.get(i).getText(),"=");break;
				default: base.assertEqualsActualExpected(TxtAssets.get(i).findElement(By.tagName("p")).getText(),TotalAsset[i]);
						 TxtAssets.get(i).findElement(By.tagName("span")).isDisplayed();
			}
		}
	}
	
	/**
	 * 获取“可用余额”
	 * @return 可用余额
	 * @author 江渤洋 2015-7-22
	 */
	public String getNumberinAvailableBalance(){
		base.sleep(2000);
		//获取可用余额
		String NumberinAvailableBalanceStr = base.getElementTextWithWait(NumberinAvailableBalance);
		NumberinAvailableBalanceStr = NumberinAvailableBalanceStr.substring(0, NumberinAvailableBalanceStr.indexOf(" "));
		return NumberinAvailableBalanceStr;
	}	
	
	/**
	 * 获取账户总览中的金额(包括：已赚总利息，账户总资产，可用余额，冻结金额等)
	 * @return 金额
	 * @author 江渤洋 2015-10-9
	 */
	public String getMoneyNum(By by){
		String moneyNum = base.getElementTextWithWait(by);
		int length = moneyNum.length();
		moneyNum = moneyNum.substring(0, length-1);        //42,200.00 元 改为 42,200.00
		moneyNum = base.stringToReplace(moneyNum, ",", "");//42,200.00 改为 42200.00
		moneyNum = moneyNum.trim();
		return moneyNum;
	}
	
	/**
	 * 点击冻结明细图片
	 * @author 江渤洋 2015-10-9
	 */
	public void clickFreezingStatisticsImg(){
		base.clickWithWait(FreezingStatisticsImg);
	}
	
	/**
	 * 获取“冻结资金明细”中某列的集合
	 * @param columnName: 列名 
	 * @return 某列的集合
	 * @author 江渤洋 2015-10-8
	 */
	public List<WebElement> getFreezingStatistics(String columnName){
		
		By by = null;
		if(columnName.equals("冻结金额")){
			by = By.cssSelector(".colorG");
		}
		List<WebElement> list = new ArrayList<WebElement>();
		list = base.getElements(by);
		return list;
	}
	
	/**
	 * 冻结资金明细中冻结金额之和
	 * @param list：所有冻结金额
	 * @return 冻结金额之和
	 * @author 江渤洋 2015-10-8
	 */
	public double getFreezeMoneySum(List<WebElement> list){
		
		double sum = 0;
		String temp;
		for (WebElement webElement : list) {
			temp = webElement.getText();
			sum += Double.valueOf(temp);
		}
		return sum;
	}
	
	public void isLoginTrue(){
		base.assertNotNullBy(isLoginTrueTxt);
	}
	
	/**
	 * 获取账户总资产详细信息（包含：散标待收本金、翼存宝待收本金、待收利息、可用余额、冻结金额、账户总资产）
	 * @return 信息集合
	 * @author 江渤洋 2015-10-9
	 */
	public List<String> getAssets(){
		
		base.mouseToElement(MoneyIconinTotalAssets);
		List<WebElement> TxtAssets = base.getElements(TotalAssertsTxt);
		List<String> assetsList = new ArrayList<String>();
		String temp = null;
		for (int i = 0; i < TxtAssets.size(); i++) {
			switch (i) {
			case 0:case 4:
				temp = TxtAssets.get(i).findElement(By.cssSelector("p:nth-child(2) > span")).getText();break;
			case 2:case 8:case 10:
				temp = TxtAssets.get(i).findElement(By.tagName("span")).getText();break;
			case 6:
				temp = TxtAssets.get(i).findElement(By.tagName("span")).getText();break;
			default:
				break;
			}
			//没有数据，不添加至数组
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 9){
				continue;
			}
			temp = base.stringToReplace(temp, ",", "");
			assetsList.add(temp);
		}
		return assetsList;
	}
	
	/**
	 * 校验账户总资产，及其明细是否正确
	 * @param list：账户总览中 “账户总资产”的明细
	 * @param waitPrincipalNumStrByLend：散标投资中 “待收本金”
	 * @param waitPrincipalNumStrByECB：翼存宝“待收本金”
	 * @param waitInterestNum：账户总览中 “待收利息”
	 * @param availableBalanceNum：账户总览中 “可用余额”
	 * @param frozenMoneyNum：账户总览中 “冻结金额”
	 * @param totalAssetsNum：账户总览中“账户总资产”
	 * @author 江渤洋 2015-10-9
	 */
	public void checkAssets(List<String> list, String waitPrincipalNumStrByLend, String waitPrincipalNumStrByECB, String waitInterestNum, String availableBalanceNum, String frozenMoneyNum, String totalAssetsNum){
		
		double sum = 0;
		//不含最后一项，即“账户总资产”
		for(int i = 0; i < list.size()-1; i++){
			sum = base.add(sum, Double.valueOf(list.get(i)));
			switch (i) {
			case 0:base.assertEqualsActualExpected(list.get(i), waitPrincipalNumStrByLend);break;
			case 1:base.assertEqualsActualExpected(list.get(i), waitPrincipalNumStrByECB);break;
			case 2:base.assertEqualsActualExpected(list.get(i), waitInterestNum);break;
			case 3:base.assertEqualsActualExpected(list.get(i), availableBalanceNum);break;
			case 4:base.assertEqualsActualExpected(list.get(i), frozenMoneyNum);break;
			default:
				break;
			}
		}
		base.assertEqualsActualExpected(base.appendZero(base.doubleFormat(sum)), totalAssetsNum);
	}
	
	/****************************我的账户-账户总览-冻结金额******************************/
	
	//点击“冻结资金明细”图标
	public void clickFreezeStatisticsImg(){
		base.clickWithWait(FreezingStatisticsImg);
		base.checkElmentText(FreezedetailTitleTxt, "冻结资金明细");
	}
	//获取到目前为止的冻结金额：15248.26
	public double getAllFrozenMoney(){
		String froze = base.getElementTextWithWait(NumberinFrozenMoney);
//		if(froze.contains(",")){
		froze = froze.replaceAll(",", "");
//		}
		froze = froze.replaceAll("元", "");
		return Double.parseDouble(froze);
	}
	//获取上个月的冻结金额
	public double[] getLastMonthFreezeMoney(){	

		clickFreezeStatisticsImg();
		if(base.getElementTextWithWait(FirstFreeze).equals("无冻结资金！")){
			clickCloseFreezeLnk();
			double a[] = {0,0.00};
			return a;
		}else{
			Calendar cal = Calendar.getInstance();
			int day = cal.get(Calendar.DAY_OF_MONTH);
			if(day>=1 && day<5){	
				cal.add(Calendar.MONTH,-1);
			}
			cal.add(Calendar.MONTH, -1);
			String time = new SimpleDateFormat("yyyy-MM").format(cal.getTime());
			List<WebElement> times = base.getElements(FreezeTime);
			List<WebElement> money = base.getElements(FreezeMoney);
			int size = times.size(),withdrawnum=0;
			double amount = 0.0;
			for(int i=0;i<size;i++){
				String freezetime = times.get(i).getText().substring(0,7);
				double freezemoney = Double.parseDouble(money.get(i).getText());
				if(freezetime.equals(time)){
					withdrawnum=withdrawnum+1;
					amount= amount+freezemoney;
				}
			}
			clickCloseFreezeLnk();
			double withdraw[]={withdrawnum,amount};
			return withdraw;
		}
	}
	//获取截止到上个月底的冻结金额
	public Double getFreezeMoneyUntilLastMonth(){

		clickFreezeStatisticsImg();
		if(base.getElementTextWithWait(FirstFreeze).equals("无冻结资金！")){
			clickCloseFreezeLnk();
			return 0.00;
		}else{
			String time;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			int day = base.getCurrentDay();
			if(day>=1 && day<=5){	
				time = base.getLastMonthDay(-2);
			}else{
				time = base.getLastMonthDay(-1);
			}
			List<WebElement> times = base.getElements(FreezeTime);
			List<WebElement> money = base.getElements(FreezeMoney);
			int size = times.size();
			double amount = 0.0;
			for(int i=0;i<size;i++){
				String freezetime = times.get(i).getText().substring(0,10);
				double freezemoney = Double.parseDouble(money.get(i).getText());
				try {
					if(df.parse(freezetime).getTime()<=df.parse(time).getTime()){
						amount= amount+freezemoney;
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			clickCloseFreezeLnk();
			return amount;
		}	
	}
	public void clickCloseFreezeLnk(){
		base.clickElementNoWait(CloseFreezeLnk);
	}
	
	/****************************我的账户-账户总览-充值/提现/翼星计划******************************/
	
	//点击“充值”按钮
	public void clickRechargeBtn(){
				
		base.clickWithWait(rechargeBtn);
//		base.checkElmentText(RechargePage.OnlineRechargeTxt, "网银充值");
		if(base.isElementVisible(RechargePage.OnlineRechargeTxt)){
			base.assertEqualsActualExpected(base.getElementText(RechargePage.OnlineRechargeTxt),"网银充值");
		}else{
			base.assertEqualsActualExpected(base.getElementText(RechargePage.ImproveProfileTxt),"完善个人身份信息");
			new RechargePage().closeInfo();
		}
	}
	public void clickCloseImproveBox(){
		
	}
	//点击“提现”按钮
	public void clickWithDrawBtn(){
		
		base.clickWithWait(WithDrawBtn);
//		base.acceptAlert();
		base.checkElmentText(WithDrawPage.WithDrawTxt, "提现");
/*		if(base.getElements(WithDrawPage.WithDrawTxt).isEmpty()){
			base.checkElement(WithDrawPage.WithDrawTip);
		}else{
			base.assertEqualsActualExpected(base.getElementText(WithDrawPage.WithDrawTxt), "提现");
		}
*/	}
	//点击“即刻投资>>”链接
	public void clickInvestNowLnk(){
		
		base.clickElementNoWait(InvestNowLnk);
		base.assertEqualsActualExpected(base.getPageTitle(),PageTitles.yiCunBao);
	}
	
	/****************************我的账户-账户总览-翼存宝******************************/
	
	//点击翼存宝投资“查看详情”链接
	public void clickYCBViewDetailLnk(){
		
		base.clickElementNoWait(YCBViewDetailsLnk);
		base.checkElmentText(YCBPage.YCBTxt, "翼存宝");
	}
	
	/****************************我的账户-账户总览-散标投资******************************/
	
	//检查“散标投资”中的icon
	public void checkSBInterestIcon(){
		
		String [] Tootips = {"散标+购买债权的净收益，收益不包含财富管理费，包含逾期平台回收所支付的40天利息","散标+购买债权待收的本金和利息，利息包含财富管理费","散标+购买债权待收的利息，利息包含财富管理费"}; 
		for(int i =0; i<3; i++){				
			base.mouseToIndexElement(SBInterestIcon, i);
			base.sleep(1000);
			List<WebElement> ThreeTooltip = base.getElements(SBTootip);		
			base.assertEqualsActualExpected(Tootips[i],ThreeTooltip.get(i).getText());			
		}		
	}
	//点击散标投资“查看详情”链接
	public void clickSBViewDetailLnk(){
		
		base.clickElementNoWait(SBViewDetailsLnk);
		base.assertEqualsActualExpected(base.getElementText(SBInvestPage.SBInvestTxt),"散标投资 （散标+购买债权）");
	}
	
	/****************************我的账户-账户总览-我的借入******************************/
	
	//点击“申请借款”链接
	public void clickLoanApplicationLnk(){
		
		base.clickElementNoWait(LoanApplicationLnk);
		base.checkElement(LoanApplicationPage.Main);
		if(base.getElements(LoanApplicationPage.ApplyforLoanTxt).isEmpty()){
			base.checkElmentText(LoanApplicationPage.VerifyAuthBtn, "资格验证");
		}else{
			base.assertEqualsActualExpected(base.getElementText(LoanApplicationPage.ApplyforLoanTxt), "申请借款");
		}	
/*		
		if(base.getElementNoWait(LoanApplicationPage.ApplyforLoanTxt).isDisplayed()){
			base.assertEqualsActualExpected(base.getElementText(LoanApplicationPage.ApplyforLoanTxt), "申请借款");
		}else if(base.getElementNoWait(LoanApplicationPage.VerifyAuthBtn).isDisplayed()){
			base.checkElmentText(LoanApplicationPage.VerifyAuthBtn, "资格验证");
		}
*/	}
	
	//点击“我的借款”链接
	public void clickMyLoanLnk(){
		base.clickElementNoWait(MyLoanLnk);
		base.checkElmentText(MyLoanPage.MyLoanTxt, "我的借款");
	}
	//检查“我的账户”页面左侧导航数据
	public void verifyLeftnavigationData(){
		
		String [] TxtinLeft = {"我的账户", "我的贷出", "翼星计划","我的借入","账户设置"};
		String [][] LinkTxtinLeft = {{"账户总览","交易记录","充值","提现","我的奖励"},{"翼存宝","散标投资","债权转让","自动投标","预约投标"},{"我的投资计划","我的借入计划"},{"我的借款","申请借款"},{"账户信息","安全认证","通知设置"}};
		base.checkElement(MyAccountTxtinLeft);
		List<WebElement> TxtElementinLeft = base.getElements(MyAccountTxtinLeft);
		List<WebElement> FivePartsinLeft = base.getElements(FivePartinLeft);
		for(int i =0; i<TxtElementinLeft.size();i++){	
			base.assertEqualsActualExpected(TxtElementinLeft.get(i).getText(),TxtinLeft[i]);
		}
		for(int i = 0; i<FivePartsinLeft.size();i++){
			List<WebElement> LinksinLeft = FivePartsinLeft.get(i).findElements( By.tagName("li"));			
			for(int j = 0;j<LinksinLeft.size();j++){				
				base.assertEqualsActualExpected(LinkTxtinLeft[i][j],LinksinLeft.get(j).getText());
			}			
		}
	}
	public void verifyMyAccountData(){
		try{
			base.getElementText(AccountOverviewTxt).contains("账户总览");
			base.assertTrueBy(TotalPart);
			base.assertTrueBy(BalancePart);
			base.assertEqualsActualExpected(base.getLnkElementText(FreezingStatisticsImg, "src"),base.indexURL+"/page/userMgr/images/icon.png");	
			base.assertEqualsActualExpected(base.getElementText(rechargeBtn),"充值");
			base.assertEqualsActualExpected(base.getElementText(WithDrawBtn),"提现");
			base.assertEqualsActualExpected(base.getElementText(YiCunBaoInvestTxt),"翼存宝投资");
			base.assertEqualsActualExpected(base.getElementText(YCBViewDetailsLnk),"查看详情>>");
			base.assertEqualsActualExpected(base.getElementText(SanBiaoInvestTxt),"散标投资(散标+购买债权)");
			base.assertEqualsActualExpected(base.getElementText(SBViewDetailsLnk),"查看详情>>");	
			base.assertEqualsActualExpected(base.getElementText(MyLoanTxt),"我的借入");
			base.assertEqualsActualExpected(base.getElementText(LoanApplicationLnk),"申请借款");
			base.assertEqualsActualExpected(base.getElementText(MyLoanLnk),"我的借款");
			clickYCBViewDetailLnk();
			clickAccountOverviewLnk();
			clickSBViewDetailLnk();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	public void verifyAccountOverviewData(){
		try{
			
		//上部的账户的数据验证
		base.getElementText(AccountOverviewTxt).contains("账户总览");
		base.assertEqualsActualExpected(base.getElementText(SecurityLevel),"安全级别：");

		//总利息总资产数据验证
		base.assertEqualsActualExpected(base.getElementText(TotalInterestTxt),"已赚总利息");
		base.assertEqualsActualExpected(base.getElementText(TotalAssetsTxt),"账户总资产");
		base.assertTrueBy(NumberinTotalInterest);
		base.assertTrueBy(NumberinTotalAssets);
		
		//可用冻结金额数据验证
		base.getElementText(AvailableBalance).contains("可用余额：");
		base.getWebElementByElements(AvailableBalance,1).getText().contains("冻结金额：");
		base.assertTrueBy(NumberinAvailableBalance);
		base.assertTrueBy(NumberinFrozenMoney);		
		base.assertEqualsActualExpected(base.getLnkElementText(FreezingStatisticsImg, "src"),base.indexURL+"/page/userMgr/images/icon.png");	
		base.assertEqualsActualExpected(base.getElementText(rechargeBtn),"充值");
		base.assertEqualsActualExpected(base.getElementText(WithDrawBtn),"提现");
		
		//“翼存宝投资”数据验证
		base.assertEqualsActualExpected(base.getElementText(YiCunBaoInvestTxt),"翼存宝投资");
		base.assertEqualsActualExpected(base.getElementText(YCBEarnInterestTxt),"已赚利息");
		base.assertTrueBy(YCBEarnInterestNum);
		base.getElementText(YCBWaitInterestTxt).contains("待收利息：");
		base.assertTrueBy(YCBWaitInterestNum);
		base.getElementText(YCBWaitPrincipalTxt).contains("待收本金：");
		base.assertTrueBy(YCBWaitPrincipalNum);
		base.assertEqualsActualExpected(base.getElementText(YCBViewDetailsLnk),"查看详情>>");
		//“散标投资”数据验证
		base.assertEqualsActualExpected(base.getElementText(SanBiaoInvestTxt),"散标投资(散标+购买债权)");
		base.assertEqualsActualExpected(base.getElementText(SBEarnInterestTxt),"已赚利息");
		base.assertTrueBy(SBEarnInterestNum);
		base.getElementText(SBWaitPITxt).contains("待收本息：");
		base.assertTrueBy(SBWaitPINum);
		base.getElementText(SBWaitInterestTxt).contains("待收利息：");
		base.assertTrueBy(SBWaitInterestNum);
		base.getElementText(SBWaitPrincipalTxt).contains("待收本金：");
		base.assertTrueBy(SBWaitPrincipalNum);
		base.assertEqualsActualExpected(base.getElementText(SBViewDetailsLnk),"查看详情>>");	
		//“我的借入”数据验证
		base.assertEqualsActualExpected(base.getElementText(MyLoanTxt),"我的借入");
		base.assertEqualsActualExpected(base.getElementText(WaitRepayTxt),"待还总金额");
		base.assertTrueBy(WaitRepayNum);
		base.getElementText(WaitRepayPITxt).contains("待收本金：");
		base.assertTrueBy(WaitRepayPINum);
		base.getElementText(WaitRepayInterestTxt).contains("待还利息：");
		base.assertTrueBy(WaitRepayInterestNum);
		base.getElementText(LateFeeTxt).contains("逾期费用：");
		base.assertTrueBy(LateFeeNum);
		base.assertEqualsActualExpected(base.getElementText(LoanApplicationLnk),"申请借款");
		base.assertEqualsActualExpected(base.getElementText(MyLoanLnk),"我的借款");
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	//验证是否跳转至我的账户的某个模块
	public void isGoMyAccount(String module){
		base.sleep(2000);
		base.assertNotNullBy(By.xpath("//div[@class='m-navlist']//a[text()='" + module + "' and contains(@class,'cur')]"));
	}

	//跳转至我的账户的某个模块
	public void turnToMyAccount(String module){
		base.clickWithWait(By.xpath("//div[@class='m-navlist']//a[text()='" + module + "']"));
	}
	
	
	/**
	 * “翼龙君正在玩命加载中...请稍候！”是否显示
	 * @author 江渤洋 2015-1-5 
	 */
	public void isHardLoadShow(){
		boolean isShow = base.isElementPresent(By.xpath("//div[@id='loadingsx']"));
		if(isShow){
			base.refreshPage();
		}
	}
	
	/**
	 * 徐天元
	 * 获取账户可用余额
	 */
	public double getBalance(){
		String balance = "";
		String money = "";
		for (int i = 0; i < 3; i++) {
			if (base.checkElementPresent(By.xpath("//*[@id='statField2']/small[contains(text(),'元')]"), 20)) {
				balance = base.getElementTextWithWait(By.xpath("//*[@id='statField2']"));
				//处理账户余额  例如87,897.00 元->87897.00
				String myBalance[]=balance.split(",");
				for (int j = 0; j < myBalance.length; j++) {
					money += myBalance[j];
				}
				money = money.replaceAll("元", "");
				break;
			}else {
				base.refreshPage();
			}
		}
		System.out.println("账户余额："+money);
		return Double.parseDouble(money);
	}
	
	/**
	 * 参看徐天元的getBalance()
	 * @return 账户余额
	 * @author 江渤洋 2015-11-25
	 */
	public String getBalance_1(){
		String balance = base.getElementTextWithWait(By.xpath("//*[@id='statField2' and contains(text(),'.')]"));
		if(balance.contains("加载中")){
			base.refreshPage();
			base.sleep(3000);
			balance = base.getElementTextWithWait(By.xpath("//*[@id='statField2' and contains(text(),'.')]"));
		}
		//处理账户余额  例如87,897.00 元->87897.00
		String myBalance[]=balance.split(",");
		String money = "";
		for (int i = 0; i < myBalance.length; i++) {
			money += myBalance[i];
		}
		money = money.replaceAll("元", "");
		return money;
	}

	
	By phontTxt = By.cssSelector("#mobile");           //手机号码
	By submintBtn = By.cssSelector(".certifisub1");    //确认提交
	
	/**
	 * 点击“确认提交”按钮
	 * @author 江渤洋 2015-9-7
	 */
	public void clickSubmintBtn(){
		base.clickWithWait(submintBtn);
	}
	
	/**
	 * 修改手机号
	 * @param noChangeTel：原手机号
	 * @param changeTel：修改后手机号
	 * @param payPass：支付密码
	 * @author 江渤洋 2015-9-9
	 */
	public void checkChangeTel(String noChangeTel, String changeTel, String payPass){
		String code = "";
		base.clickWithWait(securityAuthPage.changTel);
		base.clickWithWait(securityAuthPage.changeByOldTel);
		do{
			base.clickWithWait(securityAuthPage.msgCodeBtn);
			if(base.isAlertPresent()){
				base.acceptAlert();
				base.sleep(2000);
			}
			else{
				break;
			}
		}while(true);
		base.sleep(2000);
		boolean actualBool = base.isElementContainsValue(securityAuthPage.msgCodeAlert, "style", "none");
		//验证发送验证码成功弹出框是否弹出
		base.assertEqualsActualExpectedByBoolean(actualBool, false);
		base.clickWithWait(securityAuthPage.msgOkBtn);
		//获取验证码
		code = dbData.getPhoneCode(noChangeTel);
		//输入验证码
		base.sendKeysWithWait(securityAuthPage.msgCodeTxt, code);
		base.sleep(2000);
		//点击下一步按钮
		base.clickWithWait(securityAuthPage.nextBtn);
		base.sleep(1000);
		base.sendKeysWithWait(securityAuthPage.newTeltxt, changeTel);
		base.clickWithWait(securityAuthPage.newMsgCodeBtn);
		code = dbData.getPhoneCode(changeTel);
		base.sendKeysWithWait(securityAuthPage.newMsgCodeTxt, code);
		base.sendKeysWithWait(securityAuthPage.newPayPasTxt, payPass);
		base.clickWithWait(securityAuthPage.newOKBtn);
		base.assertEqualsActualExpected(base.getElementTextWithVisible(securityAuthPage.newTelNum), changeTel);
	}
	
	/**
	 * 验证充值首次姓名验证，姓名提示信息
	 * @param msgBy 姓名错误提示信息
	 * @param nameCheckmarkImg //姓名正确提示图片
	 * @author 江渤洋  2015-9-2
	 */
	public void checkNameNoticeInformation(By msgBy, By nameCheckmarkImgBy){
		String [] nameArray = {"一", "一二三四五六七八九十零", "一二三四五六七八九十", "!@#$%", "abcdef", "中文 ", " 中文", "中 文", "中文123", "中文abc", "中文!@#"};
		String [] noticeInformationArray = {"真实姓名必须是一个字以上!", "无错误提示信息,返回True", "无错误提示信息,返回True", "真实姓名必须全部为中文!", "真实姓名必须全部为中文!", "真实姓名必须全部为中文!", "真实姓名必须全部为中文!", "真实姓名必须全部为中文!", "真实姓名必须全部为中文!", "真实姓名必须全部为中文!", "真实姓名必须全部为中文!"};
		int arrayLength = nameArray.length;
		for(int i = 0; i < arrayLength; i++){
			//输入姓名
			rechargePage.setInfoByRealName(nameArray[i]);
			//点击身份证文本框
			base.clickWithWait(rechargePage.pidcardTxt);
			//提示信息校验
			if(i == 1 || i == 2){
				//验证姓名对勾图片，是否显示
				try {
					base.assertTrueByBoolean(base.isElementVisible(nameCheckmarkImgBy));
				} catch (AssertionError e) {
					Reporter.log("姓名输入：\'" + nameArray[i] + "\' 时，对勾图片未显示。");
					System.out.println("姓名输入：\'" + nameArray[i] + "\' 时，对勾图片未显示。");
				}
				
			}
			else{
				String msg = base.getElementTextWithWait(msgBy);
				//验证提示信息
				try {
					base.assertEqualsActualExpected(msg, noticeInformationArray[i]);
				} catch (AssertionError e) {
					String nameMsg = base.getElementTextWithWait(By.cssSelector("#prealnametipMsg"));
					Reporter.log("姓名输入：\'" + nameArray[i] + "\' 时，提示信息：" + nameMsg + " 与预期结果不符，预期结果： " + noticeInformationArray[i]);
					System.out.println("姓名输入：\'" + nameArray[i] + "\' 时，提示信息：" + nameMsg + " 与预期结果不符，预期结果： " + noticeInformationArray[i]);
				}
			}
		}
	}
	
	
	/**
	 * 我的账户——>账户信息，输入值
	 * @param by：姓名，身份证，手机号，邮箱
	 * @param inputString：输入的值
	 */
	public void setUserInfo(By by, String inputString){
		base.clickWithWait(by);
		base.sendKeysWithWait(by, inputString);
		base.sleep(2000);
	}
	
	/**
	 * 输入手机号码
	 * @param phoneNum：手机号
	 * @author 江渤洋 2015-9-7
	 */
	public void setPhone(String phoneNum){
		base.clickWithWait(phontTxt);
		base.sendKeysWithWait(phontTxt, phoneNum);
		base.sleep(2000);
	}
	
	/**
	 * 验证邮箱提示信息
	 * @author 江渤洋 2015-9-8
	 */
	public void checkEmailNoticeInformatin(){
		String [] emailArray = {"1@qq.com","1234567890123456789012345678901234@qq.com","123456789012345678901234567890123@qq.com","abc_123@qq.com","!#$%^@qq.com","ａｂｃｄｅｆ@qq.com","123@126.com"};//f@qq.com
		String [] noticeInformationArray = {"无错误提示信息,返回True","Email地址太长，请输入有效的Email！","无错误提示信息,返回True","无错误提示信息,返回True","请输入有效的Email！","请输入有效的Email！","无错误提示信息,返回True"};
		int arrayLength = emailArray.length;
		for(int index = 0; index < arrayLength; index++){
			//输入邮箱
			setUserInfo(accountInfoPage.emailTxt, emailArray[index]);
			//点击身份证文本框
			base.clickWithWait(rechargePage.pidcardTxt);
			base.sleep(2000);
			if(index == emailArray.length-1){
				setUserInfo(accountInfoPage.realNameTxt, "方文山一");
				setUserInfo(accountInfoPage.idCardTxt, "110102194412308661");
				accountInfoPage.clickOkBtn();
				base.sleep(2000);
				base.acceptAlert();
				base.sleep(2000);
				base.assertEqualsActualExpected(base.getTextByAlert(), "此邮箱地址已被使用！");
				base.acceptAlert();
			}
			else if(index == 1 || index == 4 || index == 5){
				String msg = base.getElementTextWithWait(accountInfoPage.emailMsg);
				//验证提示信息
				try {
					base.assertEqualsActualExpected(msg, noticeInformationArray[index]);
				} catch (Exception e) {
					Reporter.log("姓名输入：\'" + emailArray[index] + "\' 时，提示信息：" + msg + " 与预期结果不符，预期结果： " + noticeInformationArray[index]);
					System.out.println("姓名输入：\'" + emailArray[index] + "\' 时，提示信息：" + msg + " 与预期结果不符，预期结果： " + noticeInformationArray[index]);
				}//System.out.println("提示信息：" + base.getElementTextWithWait(rechargePage.nameMsg) + " 预期结果： " + noticeInfomationArray[i]);//--------测试
			}
			else{
				//验证姓名对勾图片，是否显示
				try {
					base.assertEqualsActualExpectedByBoolean(base.isElementPresent(accountInfoPage.emailCheckmarkImg), true);
				} catch (AssertionError e) {
					Reporter.log("姓名输入：\'" + emailArray[index] + "\' 时，对勾图片未显示。");
					System.out.println("姓名输入：\'" + emailArray[index] + "\' 时，对勾图片未显示。");
				}//System.out.println("提示信息是否存在：" + !base.isNone(rechargePage.nameMsg));//--------测试
			}
			base.sleep(3000);
		}
	}
	
	/**
	 * 验证手机号提示信息
	 * @author 江渤洋 2015-9-7
	 */
	public void checkPhoneNoticeInformation(){
		String msg = "";
		String [] phoneArray = {"1358156770","13581568800","!@#$)(*&^%%","中文中文中文","00886518531","53658818001","","１３５８１５６７７０２","13581567702"};
		String [] noticeInformationArray = {"您输入的手机号码有误!","此手机号已经被使用！","您输入的手机号码有误!","您输入的手机号码有误!","您输入的手机号码有误!","您输入的手机号码有误!","手机号码不能为空!","您输入的手机号码有误!","您已完成手机认证！请继续！"};
		int arrayLength = phoneArray.length;
		for(int index = 0; index < arrayLength; index++){
			setPhone(phoneArray[index]);
			base.sleep(1000);
			clickSubmintBtn();
			base.sleep(2000);
			msg = base.getElementTextWithWait(By.cssSelector("#stepnote"));
			base.assertEqualsActualExpected(msg, noticeInformationArray[index]);
		}
	}
	
	/**
	 * 删除手机注册的记录，使其成为只有邮箱注册的账户，即老账户。
	 * @param email:用户邮箱
	 * @author 江渤洋 2015-9-7
	 */
	public void deletePhoneRegeditRecords(String email){
		String uid = dbData.getUID(email);
		boolean isTrue = dbData.deletePhoneRegeditRecords(uid);
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
	}
	
	/**
	 * 验证充值首次身份验证，身份证号提示信息
	 * @author 江渤洋  2015-7-21
	 */
	public void checkIdCardNoticeInformation(){
		String [] idCardArray = {"11010519850423007X", "11010519850423007x", "110105198504230", "110105198504230071", "中文中文中文中文中文中文中文中文中文", "!!!!!!!!!!!!!!!!!!", "11010519850423007X1", "11010519850423007x1", "abcdabcdabcdabcdcd"};
		String [] noticeInformationArray = {"无错误提示信息,返回True", "无错误提示信息,返回True", "身份证号码有误,请检查!", "身份证号码有误,请检查!", "身份证号码有误,请检查!", "身份证号码有误,请检查!", "身份证号码有误,请检查!", "身份证号码有误,请检查!", "身份证号码有误,请检查!"};
		int arrayLength = idCardArray.length;
		for(int i = 0; i < arrayLength; i++){
			//输入身份号
			rechargePage.setInfoByIdCard(idCardArray[i]);
			//点击姓名文本框
			do{
				base.clickWithWait(rechargePage.prealnameTxt);
				base.sleep(2000);//System.out.println("姓名提示信息是否显示： " + base.isElementPresent(By.cssSelector("#prealnametipMsg >span")));//--------测试
			}while(!base.isElementPresent(By.cssSelector("#prealnametipMsg >span")));
			//提示信息校验
			if(i == 0 || i == 1){
				//验证提示信息，是否不显示
				base.assertEqualsActualExpectedByBoolean(base.isNone(rechargePage.idMsg), true);//System.out.println("提示信息是否存在：" + !base.isNone(rechargePage.idMsg));//--------测试
			}
			else{
				//验证提示信息
				base.assertEqualsActualExpected(base.getElementTextWithWait(rechargePage.idMsg), noticeInformationArray[i]);//System.out.println("提示信息：" + base.getElementTextWithWait(rechargePage.idMsg) + " 预期结果： " + noticeInfomationArray[i]);//--------测试
			}
			base.sleep(2000);
		}
	}
	
	/**
	 * 验证充值首次身份验证，支付密码提示信息
	 * 备注：执行时不可移动鼠标
	 * @author 江渤洋  2015-7-21
	 */
	public void checkPayPasswordNoticeInformation(){
		String [] payPasswordArray = {"12345", "12345678901234567", "123456", "ABCabc", "!@#$%^", "Abc!123", "中文中文中文", "   "};
		String [] noticeInformationArray = {"支付密码不符合要求，请输入6-16个字符", "支付密码不符合要求，请输入6-16个字符", "", "", "", "", "", "支付密码不符合要求，请输入6-16个字符"};
		int arrayLength = payPasswordArray.length;
		//密码框是否为空。true：空,false：非空
		boolean isEmpty = true;
		for(int i = 0; i < arrayLength; i++){System.out.println(payPasswordArray[i]);
			//第6个数据是通过复制粘贴实现的
			if(i != 6){
				//输入支付密码
				rechargePage.setInfoByPayPassword(payPasswordArray[i], isEmpty);
				//点击姓名文本框
				rechargePage.clickInfoByRealName();
				//提示信息校验
				if(i == 0 || i == 1 || i == 7){
					//验证提示信息
					base.assertEqualsActualExpected(base.getElementTextWithWait(rechargePage.payMsg), noticeInformationArray[i]);
				}
				else{
					//验证提示信息，是否不显示
					base.assertEqualsActualExpectedByBoolean(base.isNone(rechargePage.payMsg), true);
				}
				base.sleep(2000);
				isEmpty = false;
			}
			else{
				Robot robot = null;
				try {
					robot = new Robot();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//点击“姓名”文本框
				rechargePage.clickInfoByRealName();
				
				//全选“姓名”
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				//复制“姓名”
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				//输入支付密码
				rechargePage.clickInfoByPayPassword();
				
				//粘贴姓名
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				//验证提示信息，是否不显示
				base.assertEqualsActualExpectedByBoolean(base.isNone(rechargePage.payMsg), true);
				base.sleep(2000);
				isEmpty = false;
			}
		}
	}
	
	/**
	 * xty
	 * 把光标移至账户名旁边的“小人”，出现“去认证”链接，点击“去认证”
	 */
	public void clickAuthentication(){
		base.mouseToElement(By.cssSelector("#icon-h-2"));
		base.clickWithWait(By.cssSelector("#icon-h-2 .userrz-tip-c>i"));
	}
	
	/**
	 * 徐天元
	 * 顶部导航手机号处，将光标放到手机号处，出现晓得提示窗有三个链接：充值、提现、投资
	 * type 1:充值  2：提现   3：投资
	 */
	public void mouseToTel(String type){
		base.mouseToElement(By.cssSelector("#accountRealName>a"));
		base.clickWithWait(By.xpath("//p[@class='a_n_o clear']/a["+type+"]"));
	}
	
}
