package com.eloancn.shared.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eloancn.shared.common.Base;
/*
 * 翼星计划借款详情页
 */
public class EStarPlanLoanDetailPage {

	Base base = new Base();
	
	public static By LoanInfoonTop = By.className("ld_leftpart");						//借款标上部信息
	public static By BidFullTime = By.xpath("//p[@class='ld_status_list0 ml15 pdt5']/span[2]");		//“标满”的时间
	public static By Photo = By.cssSelector("img[alt='借贷人上传头像']");					//借款人头像	
	public static By UserName = By.cssSelector("div.ld_user.fl>p>a");					//用户名
	public static By UserInfoBelowPhoto = By.cssSelector("div.ld_user.fl>p");			//姓名城市年龄
	public static By BorrowTypeAndTitleTxt = By.cssSelector("h2.mt10");					//头像旁边的借款类型和目的
	By BorrowTxt = By.cssSelector("div.ld_info.fl>ul>li"); 								//借款金额，利率，期限等信息
	public static By BorrowMoney = By.cssSelector("span.font22.colorE6");						//借款金额:10,000
	public static By Rate = By.xpath("//div[2]/ul/li[2]/span");								//利率:10.10
	public static By Phase = By.cssSelector("li.wd180 > span.font22.colorE6");					//期限:3
	By RepayModeImg = By.cssSelector("li.wd180 > img");									//“还款方式”图标
	By RepayTipTxt = By.id("ui-tooltip-0-content");										//“还款方式”图标下的tip
	By RepayDetailLnk = By.cssSelector("li.clear.wd270 > a");							//还款计划的详情链接
	public static By QYBasicInfoTxt = By.cssSelector("#record0>h4.record-title");		//“企业基本信息”
	By ReferrerNameLnk = By.xpath("//div[@id='record2']/table/tbody/tr/td/a");			//"债权推荐人名称"链接
	
	//弹出的还款计划详情页
	By CheckRepayPlanTitle = By.xpath("//div[@id='showRepayPlan']/div[2]/div/span");	//“查看还款计划”标题
	By subRepayTitle = By.cssSelector("#showRepayPlan>div.c>div.cont>table>thead>tr>th");//序号、应还款时间、应还本息、应还本金、应还利息
	By closeRepalyPlan = By.xpath("//div[@id='showRepayPlan']/div[2]/div/a");			//关闭
	
	//检查“尚未发布的借款”-“借款标详情页”的标信息
	public void checkBidInfo(int num){
		
		try{
			base.assertEqualsActualExpected(base.getElementTextWithWait(BorrowTypeAndTitleTxt), "【生意周转】 自动化测试使用");
			String BorrowInfo[] = null;
			if(base.indexURL.contains("client") || base.indexURL.contains("inclient")){
				BorrowInfo = new String[]{"借款金额：10,000元","利率：10.30%/年","期限：3个月","信用等级：C","借款进度：\n0%","还款方式：先息后本","还款计划：详情"};
			}else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
				BorrowInfo = new String[]{"借款金额：10,000元","利率：10.30%/年","期限：3个月","信用等级：C","借款进度：\n0%","还款方式：先息后本","还款计划：详情"};
			}
			List<WebElement> BorrowInfos = base.getElements(BorrowTxt);
			for(int i=0;i<7;i++){
				base.assertEqualsActualExpected(BorrowInfos.get(i).getText(), BorrowInfo[i]);
			}
			checkRepayModeImg();
			clickRepayDetailLnk();
			checkReplayPlan();
			if(num == 2){
				base.closeAndjumptoOldWindow();
			}
		}catch(Exception e){
			if(num == 2){
				base.closeAndjumptoOldWindow();
			}
			Assert.fail(e.toString());
		}
		catch(AssertionError e){
			if(num == 2)    base.closeAndjumptoOldWindow();
			Assert.fail(e.toString());
		}
	}
	//检查“还款方式”后面的“？”图标
	public void checkRepayModeImg(){
		base.mouseToElement(RepayModeImg);
		base.checkElementVisible(RepayTipTxt);
		base.assertEqualsActualExpected(base.getElementText(RepayTipTxt), "先息后本：是指在还款期内，每月偿还规定额度的利息，最后一个月偿还该月利息及所有本金");
	}
	//点击“还款计划：详情”链接
	public void clickRepayDetailLnk(){
		base.clickWithWait(RepayDetailLnk);
		base.checkElementVisible(CheckRepayPlanTitle);
	}
	//检查“查看还款计划"窗口中的还款计划
	public void checkReplayPlan(){
		
		double benJin = 10000;	//本金
		double liLv = 0.103;	//利率
		double lixiOfDay;		//第一期按天计算利息
		double lixiOfMonth;		//月利息
		int daysOfYear;			//当年天数
		int daysOfMotnth;		//这个月的几日
		int chaday = 0;
		int qishu;
		
		String [] subs = {"序号","应还款时间","应还本息","应还本金","应还利息"};	
		List<WebElement> subtitles = base.getElements(subRepayTitle);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM"); 
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		daysOfYear = base.getDaysOfYear(cal.get(Calendar.YEAR));
		daysOfMotnth = cal.get(Calendar.DAY_OF_MONTH); 		//这个月的几日
		String currentDay = d.format(cal.getTime());		//当日时间：2015-09-16
		String currentDate = date.format(cal.getTime());	//当月时间：2015-09
		cal.add(Calendar.MONTH, 1);
		String nextDate= date.format(cal.getTime());		//下个月时间：2015-10		
		cal.add(Calendar.MONTH, 1);
		String next2Date = date.format(cal.getTime());		//下下个月：2015-11	
		cal.add(Calendar.MONTH, 1);
		String next3Date = date.format(cal.getTime());		//下下下个月：2015-12		
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String next4Date = d.format(cal.getTime());			//下下下个月的前一天：2015-12-15	
		 
		if(1 <= daysOfMotnth && daysOfMotnth < 21){
			chaday= base.daysBetween(currentDay, currentDate + "-20")+1;
		}
		else if(21 < daysOfMotnth && daysOfMotnth <= 31){
			chaday= base.daysBetween(currentDay,nextDate + "-20")+1;
		}
		
		lixiOfDay = benJin * liLv / daysOfYear * chaday;
		lixiOfMonth = benJin * liLv / 12;				
		lixiOfMonth = base.setRound(lixiOfMonth, 2, true);  
		lixiOfDay = base.setRound(lixiOfDay, 2, true);
		String interest = base.intMoney(lixiOfDay);
		String lastInterest = base.intMoney(lixiOfMonth - lixiOfDay);
		String benxi = base.intMoney(benJin + lixiOfMonth -lixiOfDay);
		
		String [][] Plan =		 {{"1", currentDate + "-20",	interest+"元",	"0元",		interest+"元"},
								  {"2", nextDate + "-20",	 	"85.83元",		"0元",		"85.83元"},
								  {"3", next2Date + "-20",		"85.83元",		"0元",		"85.83元"},
								  {"4", next4Date,		 		benxi+"元",		"10,000元",	lastInterest+"元"}};
			
		String [][] RepayPlans = {{"1", nextDate + "-20",		"85.83元",		"0元",		"85.83元"},
								  {"1", next2Date + "-20",		"85.83元",		"0元",		"85.83元"},
								  {"1", next3Date + "-20",		"1,0084.17元",	"10,000元",	"85.83元"}};
		
		String [][] details = 	 {{"1", nextDate + "-20",		interest+"元",	"0元",		interest+"元"},
							   	  {"2", next2Date + "-20",	    "85.83元",		"0元",		"85.83元"},
							      {"3", next3Date + "-20",	 	"85.83元",		"0元",		"85.83元"},
							      {"4", next4Date,			  	benxi+"元",		"10,000元",	lastInterest+"元"}};
		
		String [][] Plans;
		if(1 <= daysOfMotnth && daysOfMotnth < 21){
			qishu = 4;
			Plans = Plan;
		}else if(daysOfMotnth == 21){
			qishu = 3;
			Plans = RepayPlans;
		}else{
			qishu = 4;
			Plans = details;
		}
		for(int i = 1; i <= 5; i++){
			for(int j = 1; j <= qishu; j++){
				base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='showRepayPlan']/div[2]/div[2]/table/tbody/tr["+j+"]/td["+i+"]")), Plans[j-1][i-1]);
			}
			base.assertEqualsActualExpected(subtitles.get(i-1).getText(), subs[i-1]);
		}
	}
	//点击关闭“查看还款计划"窗口
	public void clickcloseRepalyPlan(){
		base.clickWithWait(closeRepalyPlan);
		base.checkNoElement(closeRepalyPlan);
	}
	//检查“我的借入计划”-“借款标详情页”中的用户头像、姓名、年龄
	public void checkUserInfo(String photo,String userName,String userAge,int i){
		try{
			String Photo1 = base.getLnkElementText(Photo, "src");
			String UserName1 = base.getElementTextWithWait(UserName);
			String UserInfo = base.getElementTextWithWait(UserInfoBelowPhoto);
			int EndPosition = UserInfo.lastIndexOf("]");
			String UserAge1 = UserInfo.substring(EndPosition+1).trim();
			
			userName = userName.replaceFirst(userName.substring(0, 1), "*");
			base.assertEqualsActualExpected(Photo1, photo);
			base.assertEqualsActualExpected(UserName1, userName);
			base.assertEqualsActualExpected(UserAge1, userAge+"岁");
			if(i==1){
				base.closeWebDriver();
			}
		}catch(Exception e){
			if(i==1)	base.closeWebDriver();
			e.printStackTrace();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			if(i==1)	base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//点击借款人头像
	public void clickUserPhoto(){
		
	}
	//检查是否在翼星计划借款标详细页面
	public boolean ifinLoanDetailPage(){
		return base.isElementPresent(LoanInfoonTop);
	}
	//检查“企业基本信息”
	public void checkQiYeBasicInfo(int num){
		
		try{
			base.assertEqualsActualExpected(base.getElementTextWithWait(QYBasicInfoTxt), "企业基本信息");
			String [][] Info = {{"名称:","北京长青","成立时间:","2015年08月"},{"地址:","北京海淀中关村","注册资本:","1,000,000元(实缴1,000,000元)"},
					{"经营范围:","目前主要投资和经营的产业有：银行、证券等金融产业、现代农业、港口交通产业、信息产业"},{"借款用途:","主要用于活动基金"},{"经营情况:","从公司成立至今，投资的大部分公司都已经有了较高的盈利回报，发展良好"}};
			for(int i=0;i<5;i++){
				for(int j =0;j<Info[i].length;j++){
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='record0']/table/tbody/tr["+(i+1)+"]/td["+(j+1)+"]")), Info[i][j]);
				}
			}
			if(num == 2){
				base.closeWebDriver();
			}
		}catch(Exception e){
			if(num == 2){
				base.closeWebDriver();
			}
			e.printStackTrace();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			if(num == 2)	base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//检查“企业其他信息”
	public void checkQiYeOtherInfo(int num){
		try{
			String [] subtitle = {"还款来源","债权推荐人","担保措施/意见"};
			String [][] Info = {{"主要是从众多的投资公司的盈利中来偿还借款，或者是从其他地方拆借而来"},{"北京东方有限公司","北京东方有限公司是一家大型的投资公司，它是一个家族企业，成立于2003年"},
					{"保障措施：","担保：如不能如期偿还，有北京东方有限公司来进行偿还，有北京东方有限公司来偿还","反担保措施：","反担保：北京东方有限公司北京东方有限公司北京东方有限公司北京东方有限公司","担保意见：","担保意见：因为只是用于活动基金，所以相信这个公司完全有能力来偿还借款"}};
			for(int i=1;i<=3;i++){
				for(int j=1;j<=Info[i-1].length;j++){
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='record"+i+"']/table/tbody/tr["+j+"]/td")), Info[i-1][j-1]);
					if(i==2 && j==1){			
						clickReferrerName();
					}
				}
				base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#record"+i+">h4.record-title")), subtitle[i-1]);	
			}
			if(num == 2){
				base.closeWebDriver();
			}
		}catch(Exception e){
			if(num == 2){
				base.closeWebDriver();
			}
			Assert.fail(e.toString());
		}catch(AssertionError e){
			if(num == 2) 	base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//点击“债权推荐人”名称
	public void clickReferrerName(){
		base.clickWithWait(ReferrerNameLnk);
		base.jumpToNewWindow();
		base.checkTitle("推荐人详情");
		if(base.indexURL.contains("client")||base.indexURL.contains("inclient")){
			base.assertEqualsActualExpected(base.getElementTextWithWait(CreditReferrerDetailPage.ReferrerName), "自动化测试");
		}else if(base.indexURL.contains("test")||base.indexURL.contains("www")){
			base.assertEqualsActualExpected(base.getElementTextWithWait(CreditReferrerDetailPage.ReferrerName), "河北华瑞担保有限公司");
		}	
		base.closeAndjumptoOldWindow();
	}
}
