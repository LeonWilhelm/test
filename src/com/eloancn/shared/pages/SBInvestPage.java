package com.eloancn.shared.pages;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.PageTitles;
/*
 * “我的账户”-“散标投资”页面
 */
public class SBInvestPage {
	Base base = new Base();
	
	public static By SBInvestTxt = By.xpath("//div[2]/div/h1");				//页面标题
	By EarnedInterestImg = By.id("qt1");										//“已赚利息”图标
	By ReceivedFeesImg = By.id("qt2");											//“已收财富管理费”图标
	By ReceivingBXImg = By.id("qt3");											//“待收本息”图标
	By ReceivingInterestImg = By.id("qt4");										//“待收利息”图标
	By EarnedInterestMoney = By.id("totalBorrowMoney");							//“已赚利息”的金额
	By ManagementFeeMoney = By.id("managerAccountMoney");						//“已收财富管理费”的金额
	By ReceivingBXMoney = By.id("totalToCollectAllMoney");						//“待收本息”的金额
	By ReceivingLXMoney = By.id("totalToCollectInterest");						//“待收利息”的金额
	By ReceivingBJMoney = By.id("totalToCollectMoney");							//“待收本金”的金额
	
	By waitPrincipalNumByLend = By.cssSelector("#totalToCollectMoney");         //待收本金
	By waitInterestNumByLend = By.cssSelector("#totalToCollectInterest");       //待收利息
	By PaybackLnk = By.id("backing");											//"回收中的投资"链接
	By JoiningInvestLnk= By.id("tender");										//“参与中的投资”链接
	By ClosedInvestLnk = By.id("backed");										//“已结清的投资”链接
    By EBillLnk = By.cssSelector("li.tb1>a");									//"电子账单"链接
	By retrieveTxt = By.cssSelector("#backing");                                //"回收中的投资"链接
	
	
    By MyReportLnk = By.xpath("//div[@id='_content']/div/div/div[2]/ul/li[3]/a");//“我的举报”链接
    By MyBlacklistLnk = By.cssSelector("li.tb5>a.pdl25");						//“我的黑名单”链接
    By LocalPreBidLnk = By.cssSelector("li.tb3 > a");							//“同城预投标”链接
    By SubTitle = By.xpath("//div[@id='_content']/div/div/h1");					//子标题
    
     //电子账单
//    By EBillTitle = By.cssSelector("h1.f-fc333");								//"电子账单"标题行
    By EBillTime = By.xpath("//div[@id='_content']/div/div/h1/span/span");		//“电子账单”时间段
    By EBillTxt = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div");  //"电子账单"内容
    //空的电子账单
    By BalanceTxt = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/p");//账户余额文本
    By NoRecordTipTxt = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/p[2]");//没有记录的文本提示
    By GoInvestBtn = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/p[3]/a");	//“去投资”按钮
    //有数据的电子账单
    By TotalIncomeTipImg = By.cssSelector("img.imgTip");						//"收入总额"的提示图标
    By TipTxt = By.cssSelector("div.ui-tooltip-content");						//"收入总额"的提示内容
    By IncomeAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div/p");//"收入总额"的金额
    By InvestAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div[2]/p");//"投资总额"的金额
    By RechargeAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div[4]/p");//"充值总额"的金额
    By TXAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div[5]/p");//"提现总额"的金额
    By AccountBalanceTxt = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div[3]/p");//“账户余额”的金额
    By FreezeMoney = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div[6]/p");//"冻结金额"的金额
    By FuTouLnk = By.cssSelector("a.fuTou");												//“复投”链接
    By NormalPayAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p/span[2]");//“正常还款”的金额
    By NormalPayNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p/span[3]");//“正常还款”的笔数
    By ReceivedOverdueAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[2]/span[2]");//“逾期已还”的金额
    By ReceivedOverdueNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[2]/span[3]");//“逾期已还”的笔数	
    By OverdueAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[3]/span[2]");//“逾期未还”的金额
    By OverdueNum1 = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[3]/span[3]");//“逾期未还”的笔数
    By TransferAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[4]/span[2]");//"债权转让"的金额
    By TransferNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[4]/span[3]");//"债权转让"的笔数
    By InvestSBAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[5]/span[2]");
    By InvestSBNum =By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[5]/span[3]");
    By BuyCreditAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[6]/span[2]");
    By BuyCreditNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[6]/span[3]");
    By RechargeAmount1 = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[7]/span[2]");
    By RechargeNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[7]/span[3]");
    By WithdrawAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[8]/span[2]");
    By WithdrawNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[8]/span[3]");
    By FeeAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[9]/span[2]");
    By FeeNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[9]/span[3]");
    By NormalPayViewLnk  = By.cssSelector("a.see");										//“正常还款”的查看链接
    By NormalPayTxt = By.id("title1");													//"该月正常还款6笔,共计54.66"文本
    By PayLines = By.cssSelector("#detailstable1>tbody>tr");							//"正常还款"的条数
    By DealAmount = By.xpath("//table[@id='detailstable1']/tbody/*/td[3]");				//所有的“交易金额”
    By ExportRecordBtn = By.xpath("//div[@id='messageBoxCard']/input");					//“交易记录导出 ”按钮
    
    //“我的举报”
//    By MyReportTitle = By.xpath("//div[@id='_content']/div/div/h1");					//“我的举报”标题
    By FirstLine = By.cssSelector("table.mt10.global_table>tbody>tr");					//第一行的数据
    By FirstLineInfos = By.cssSelector("table.mt10.global_table>tbody>tr>td");			//第一行中的信息
    By ReportedUser = By.xpath("//div[@id='_content']/div/div[2]/div[2]/table/tbody/tr/td/a");//第一行中的被举报人 
    
    //“我的黑名单”
    By FirstLine1 = By.xpath("//form[@id='form1']/table/tbody/tr");						//“我的黑名单”第一行
    By FirstLineInfos1 = By.xpath("//form[@id='form1']/table/tbody/tr/td");				//“我的黑名单”第一行中的信息
    By Checkbox = By.id("id");															//“我的黑名单”第一行中的复选框
    By UserName = By.xpath("//form[@id='form1']/table/tbody/tr/td[2]/a");				//用户姓名
    By DeleteLnk = By.xpath("//form[@id='form1']/table/tbody/tr/td[5]/a");				//“删除”链接
    
    //“同城预投标”
    
    //"投资收益表"
    By IncomeStatement = By.cssSelector("div.alert_title");								//"投资收益表"标题
    By BalanceTxtinTable = By.xpath("//div[@id='showincome1']/p");						//"您的可用余额为9691.08,若干年后您将拥有："
    By SubTitleinTable = By.xpath("//div[@id='showincome1']/table/thead/tr/th");		//每一列的小标题
    By CloseTableLnk = By.cssSelector("a.alert_close");
    
	//回收中的投资
	By huoChuMoneysNum = By.cssSelector(".record_info>li:nth-child(2)");        //货出金额
	By BidStatusTxt = By.cssSelector("#tenderStatus > span.ml8"); 				//"回收中的投资"页面中的“按标状态”文本
	By InputBorrower = By.id("borrowName");										//输入“ 按借款人 ”查找的姓名
	By SearchBtn = By.cssSelector("input.time_submit");							//“查询”按钮
	By BackingContent = By.cssSelector("#_content_child>div");					//"回收中的投资"页面显示
	By NoPaybackTxt = By.cssSelector("div.global_tip.textC");					//没有“回收中的投资”时的显示
	By BackingTitle = By.xpath("//div[@id='_content_child']/*/div/a");			//每个“回收中的投资”中的标题
	By Borrower = By.xpath("//div[@id='_content_child']/*/div[2]/ul/li/a");		//借入者
	By InvestMoney = By.xpath("//div[@id='_content_child']/*/div[2]/ul/li[2]");//贷出金额
	By Rate = By.xpath("//div[@id='_content_child']/*/div[2]/ul/li[3]");		//年利率
	By ReceivingMoney = By.xpath("//div[@id='_content_child']/*/div[2]/ul/li[6]/span");//待收金额
	By PayPlanDetail = By.cssSelector("table.record_table");					//点击“回收中的投资”中的标题弹出的收款计划
	By ReceivingBXinTable = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/*/td[5]");//未收本息
	By SixPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");				//页数的第6个链接
	By LastPage = By.xpath("//div[@id='Pagination']/ul/li[text()='末页']");		//末页
	By LastOnePage = By.xpath("//div[@id='Pagination']/ul/li[text()='>']");		//末页的前一个链接
	By LastTwoPage = By.xpath("//div[@id='Pagination']/ul/li[last()-2]");		//末页的前两个链接
	By FirstPage = By.xpath("//div[@id='Pagination']/ul/li[text()='首页']");		//首页
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");				//目前页

	//本月应收的投资
	By Content = By.cssSelector("div.global_table.overflowV>table>tbody");		//"本月应收的投资"页面显示
	By ReceivedPrincipal = By.xpath("//div[@id='_content_child']/div/div/ul/li/span");//“已收本金”的金额
	By ReceivedInterest = By.xpath("//div[@id='_content_child']/div/div/ul/li[2]/span");//“已收利息”的金额
	By ReceivingPrincipal = By.xpath("//div[@id='_content_child']/div/div/ul/li[3]/span");//"待收本金"的金额
	By ReceivingInterest = By.xpath("//div[@id='_content_child']/div/div/ul/li[4]/span");//"待收利息"的金额
	By OverdueNum = By.xpath("//div[@id='_content_child']/div/div/ul[2]/li[3]/span");//“逾期笔数”
	By ReceivedOverdue = By.xpath("//div[@id='_content_child']/div/div/ul[2]/li[4]/span");//“已收逾期罚息”
	By CreditAssignLnk = By.cssSelector("a.fr record_otherlink colorF8");		//散标中的"债权转让"链接
	By InvestLines = By.xpath("//div[@id='_content_child']/div[2]/table/tbody/tr");//"本月应收的投资"的条数
	By RealPayDate = By.xpath("//div[@id='_content_child']/div[2]/table/tbody/*/td[9]");//所有的“实还时间”
	By PaymentPlanLnk = By.xpath("//div[@id='_content_child']/div[2]/table/tbody/*/td[10]/a");//"收款计划"链接
	By PaymentPlanTitle = By.id("saveTitle");									//弹出的“收款计划”标题
	By PlanPayDate = By.xpath("//table[@id='detailstable']/tbody/*/td[2]");		//所有的"应收款日期"
	By RealDate = By.xpath("//table[@id='detailstable']/tbody/*/td[3]");		//所有的"实际收款日期"
	By ReceivedBX = By.xpath("//table[@id='detailstable']/tbody/*/td[4]");		//所有的"已收本息"
	By ReceivingBX = By.xpath("//table[@id='detailstable']/tbody/*/td[5]");		//所有的"未收本息"
	By FaKuan = By.xpath("//table[@id='detailstable']/tbody/*/td[6]");			//所有的"逾期罚息"
	By StatusTxt = By.cssSelector("span.record_statusY");						//所有的“状态”
	By ClosePlanLnk = By.xpath("//div[@id='messageBoxCard']/div/span[2]/a");	//关闭弹出的“收款计划”
	
	//参与中的投资
	By NoJoiningInvestTxt = By.xpath("//div[@id='_content_child']/div/div/p");//您目前还没有参与中的投资款！
	By JoiningLines = By.xpath("//div[@id='_content_child']/div/table/tbody/tr");//列表行
	By Status = By.xpath("//div[@id='_content_child']/div/table/tbody/*/td[8]");//状态
	By LoanTitle = By.xpath("//div[@id='_content_child']/div/table/tbody/*/td[2]/a");//借款标题
	By LoanUser = By.xpath("//div[@id='_content_child']/div/table/tbody/*/td[3]");//创建标人
	By EffectiveMoney = By.xpath("//div[@id='_content_child']/div/table/tbody/*/td[5]");//有效金额 
	By JoinedRate = By.xpath("//div[@id='_content_child']/div/table/tbody/*/td[6]");//利率
	
	//已结清的投资
	By ClosedContent = By.cssSelector("#_content_child>div.mt10");					//"已结清的投资"页面的投资
	public By BorrowTitle = By.xpath("//div[@id='_content_child']/div/div/a");				//借款标题
	By ViewElectronicIOULnk = By.xpath("//div[@id='_content_child']/div/div/a[3]");//"查看下载电子借条"链接
	By LoanDetailLnk = By.xpath("//div[@id='_content_child']/div/div/a[2]");				//“借款详情”链接
	public By FirstBorrower = By.xpath("//div[@id='_content_child']/div/div[2]/ul/li/a");		//第一条的“借入者”
	public By FirstRate = By.xpath("//div[@id='_content_child']/div/div[2]/ul/li[2]");				//第一条的“年利率”
	By FirstPhase = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/tr/td");		//收款计划列表的第一期
	
	//弹出窗口“债权转让”
	By PopCreditAssignTxt = By.cssSelector("div.RT_tit > span.fl");				//债权转让标题
	By InputAssignReason = By.id("title");										//转让原因输入框
	By FixedPriceRadio = By.id("ykjmode");										//一口价
	By AuctionRadio = By.id("paimaimode");										//拍卖
	By SecretAssignRadio = By.id("mizhuanmode");								//密转
	By SelectRemainTime = By.id("duration");									//有效时间
	By WaitPrincipalTxt = By.id("daishou");										//待收本金
	By InputLowPrice = By.id("upsetprice");										//转让底价输入框
	By InputTransforCode = By.id("transforCode");								//密转码输入框
	By InputPayPwd = By.id("upsetpaypassword");									//支付密码输入框
	By OKBtn = By.cssSelector("button.RT_ok");									//确定
	By CancelBtn = By.cssSelector("button.RT_cancel");							//取消
	
	/**
	 * 徐天元
	 * 点击自动投标按钮
	 */
	public void clickAutoBidBtn(){
		base.clickWithWait(By.cssSelector(".lend_tip_bgimg"));
	}
	
	//检查左上方图标及已收未收利息等数据
	public void CheckTopLeftData(boolean collect){
		moveToImgs(EarnedInterestImg,"散标+购买债权的净收益，收益不包含财富管理费，包含逾期平台回收所支付的40天利息");
		moveToImgs(ReceivedFeesImg,"借款人每月还款时，系统自动扣除利息的10%作为财富管理费，逾期平台回收所支付的40天利息也包含财富管理费");
		moveToImgs(ReceivingBXImg,"散标+购买债权待收的本金和利息，利息包含财富管理费");
		moveToImgs(ReceivingInterestImg,"散标+购买债权待收的利息，利息包含财富管理费");
		String begin=base.getLastMonthDate(-24);
		String end=base.getLastMonthDay(24);		
		inputSearchDate(begin,end);	
		clickSearchBtn();
		clickSearchBtn();
		String waitBJ = base.getElementTextWithWait(ReceivingPrincipal).split(" 元")[0];
		String waitLX = base.getElementTextWithWait(ReceivingInterest).split(" 元")[0];
		double waitBX = Double.parseDouble(waitBJ)+Double.parseDouble(waitLX);
		String ReceivedLX = base.getElementTextWithWait(ReceivedInterest).split(" 元")[0];
		String topEarnedLX = base.getElementTextWithWait(EarnedInterestMoney);
		String topFee= base.getElementTextWithWait(ManagementFeeMoney);
		if(collect){
			base.assertEqualsActualExpected(base.roundingMoney(Double.parseDouble(topEarnedLX)+Double.parseDouble(topFee)), ReceivedLX);
		}	
		base.assertEqualsActualExpected(base.getElementTextWithWait(ReceivingBXMoney), base.roundingMoney(waitBX));
		base.assertEqualsActualExpected(base.getElementTextWithWait(ReceivingLXMoney), base.roundingMoney(Double.parseDouble(waitLX)));
		base.assertEqualsActualExpected(base.getElementTextWithWait(ReceivingBJMoney), base.roundingMoney(Double.parseDouble(waitBJ)));
	}
	//把鼠标放在图标上检查显示
	public void moveToImgs(By by,String content){
		base.checkElementVisible(by);
		base.mouseToElement(by); base.sleep(2000);
		String id = base.getLnkElementText(by, "aria-describedby")+"-content";
		base.checkElementVisible(By.id(id));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.id(id)), content);
	}

	//点击“电子账单”链接(每月5号时间才会更新到上个月的日期，否则1到5号显示上上个月的日期)
	public void clickEBillLnk(){
		base.clickWithWait(EBillLnk);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, 1);//2015-11-01
		if(day>=1 && day<5){		
			calendar.add(Calendar.MONTH,-1);//2015-10-01			
		}
		calendar.add(Calendar.DAY_OF_MONTH, -1);//2015-09-30
		String end = df.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_MONTH, 1);//2015-09-01
		String begin = df.format(calendar.getTime());
		base.checkElmentText(EBillTime, begin+" 00:00 — "+end+" 23:59");
		base.assertTrueByBoolean(base.getElementTextWithWait(SubTitle).contains("电子账单"));
	}

	//检查是否有上个月的电子账单信息
	public boolean ifNoEBill(){
		if(base.getLnkElementText(EBillTxt, "class").equals("eleBill_noData")){//电子账单中无数据
			System.out.println("电子账单中无数据!");
			Reporter.log("<br/>电子账单中无数据!");
			return true;
		}else{
			return false;
		}
	}
	//检查电子账单为空的数据
	public void checkNoEBillData(Double balance){
		String yue = base.roundingMoney(balance);
		Calendar cal = Calendar.getInstance();	
		int day = cal.get(Calendar.DAY_OF_MONTH);System.out.println(day);
		if(day>=1 && day<5){	
			cal.add(Calendar.MONTH,-2);
		}else{
			cal.add(Calendar.MONTH,-1);
		}
		String month=String.valueOf(cal.get(Calendar.MONTH)+1);System.out.println(month);
		base.assertEqualsActualExpected(base.getElementTextWithWait(BalanceTxt), "账户余额："+yue+"元");
		base.assertEqualsActualExpected(base.getElementTextWithWait(NoRecordTipTxt),"抱歉您"+month+"月份还没有记录，去翼龙贷投一笔吧！");
		base.assertEqualsActualExpected(base.getElementTextWithWait(GoInvestBtn), "去投资");
		base.assertEqualsActualExpected(base.getLnkElementText(GoInvestBtn, "href"), base.indexURL+"/new/loadAllTender.action");
	}
	//没有电子账单信息时点击“去投资”按钮
	public void clickGoInvestBtn(){
		base.clickWithWait(GoInvestBtn);
		base.jumpToNewWindow();
//		base.checkTitle("【我要贷出】-翼龙贷");
		base.checkElmentText(new InvestmentListPage().InvestmentListTxt, "投资列表");
		base.closeAndjumptoOldWindow();
	}
	//移动鼠标到“·月份收入总额”的提示图标
	public void movetoTotalIncomeTip(){
		base.mouseToElement(TotalIncomeTipImg);
		base.checkElementVisible(TipTxt);
		base.assertEqualsActualExpected(base.getElementText(TipTxt), "包含手续费");
	}
	//检查电子账单不为空时“收入总额”，“投资总额”，“充值总额”，“提现总额”数据
	public void checktopleftData(double LastMonthTX[],double amount[],double purchaseddebt[]){
		base.assertEqualsActualExpected(base.getElementTextWithWait(IncomeAmount), "￥"+base.roundingMoney(amount[1]+amount[11]));
		base.assertEqualsActualExpected(base.getElementTextWithWait(InvestAmount), "￥"+base.roundingMoney(purchaseddebt[1]+amount[5]));
//		base.assertEqualsActualExpected(base.getElementTextWithWait(InvestAmount), "￥"+base.roundingMoney(amount[3]+amount[5]));
		base.assertEqualsActualExpected(base.getElementTextWithWait(RechargeAmount), "￥"+base.roundingMoney(amount[9]));
		base.assertEqualsActualExpected(base.getElementTextWithWait(TXAmount), "￥"+base.roundingMoney(LastMonthTX[1]));
	}
	//检查“账户余额”，“冻结金额”数据
	public void checktoprightData(double freezemoney,String balance){
		DecimalFormat df = new DecimalFormat("###,##0.00");
//		if(balance.contains(",")){
			balance= balance.replaceAll(",", "");
//		}
		String remain = df.format(freezemoney+Double.parseDouble(balance));
		String freeze = df.format(freezemoney);
		if(base.getCurrentDay()<5){
			base.assertEqualsActualExpected(base.getElementTextWithWait(BalanceTxt), "截至 "+base.getLastMonthDay(-2)+" 23:59");
		}else{
			base.assertEqualsActualExpected(base.getElementTextWithWait(BalanceTxt), "截至 "+base.getLastMonthDay(-1)+" 23:59");
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(FreezeMoney), "￥"+freeze);
		base.assertEqualsActualExpected(base.getElementTextWithWait(AccountBalanceTxt), "￥"+remain);
	}
	//点击“复投”链接
	public void clickFuTouLnk(){
		base.clickWithWait(FuTouLnk);
		base.checkElementVisible(IncomeStatement);
		base.assertEqualsActualExpected(base.getElementText(IncomeStatement), "X\n投资收益表");
	}
	//检查“投资收益表”中的数据
	public void checkIncomeStatementData(String balance){
		String balanceDes = base.getElementTextWithWait(BalanceTxtinTable).replaceAll(",", "");
		base.assertEqualsActualExpected(base.getElementTextWithWait(BalanceTxtinTable), "您的可用余额为"+balance.replaceAll(",", "")+",若干年后您将拥有：");
		double balance1 = Double.parseDouble(balanceDes.substring(balanceDes.indexOf("为")+1, balanceDes.lastIndexOf("若")));
		List<WebElement> titles = base.getElements(SubTitleinTable);
		String subtitle[] = {"年限/收益","15%","18%","20%","22%"};
		String money[][] ={{"1年","5年","10年","15年","20年","25年","30年"},{base.benxi(balance1, 0.15, 1),base.benxi(balance1, 0.15, 5),base.benxi(balance1, 0.15, 10),base.benxi(balance1, 0.15, 15),
		base.benxi(balance1, 0.15, 20),base.benxi(balance1, 0.15, 25),base.benxi(balance1, 0.15, 30)},{base.benxi(balance1, 0.18, 1),base.benxi(balance1, 0.18, 5),base.benxi(balance1, 0.18, 10),
		base.benxi(balance1, 0.18, 15),base.benxi(balance1, 0.18, 20),base.benxi(balance1, 0.18, 25),base.benxi(balance1, 0.18, 30)},{base.benxi(balance1, 0.20, 1),base.benxi(balance1, 0.20, 5),
		base.benxi(balance1, 0.20, 10),base.benxi(balance1, 0.20, 15),base.benxi(balance1, 0.20, 20),base.benxi(balance1, 0.20, 25),base.benxi(balance1, 0.20, 30)},{base.benxi(balance1, 0.22, 1),
		base.benxi(balance1, 0.22, 5),base.benxi(balance1, 0.22, 10),base.benxi(balance1, 0.22, 15),base.benxi(balance1, 0.22, 20),base.benxi(balance1, 0.22, 25),base.benxi(balance1, 0.22, 30)}};
		int size = titles.size();
		for(int i=1;i<=size;i++){
			base.assertEqualsActualExpected(titles.get(i-1).getText(), subtitle[i-1]);
			for(int j=2;j<=8;j++){
					base.assertEqualsActualExpected(base.getElementText(By.xpath("//div[@id='showincome1']/table/thead/tr["+j+"]/td["+i+"]")), money[i-1][j-2]);
			}
		}
	}
	
	//关闭“投资收益表”
	public void closeIncomeTableLnk(){
		base.clickWithWait(CloseTableLnk);
		base.checkNoElement(CloseTableLnk);
	}
	//检查上个月账单详情
	public void checkMiddleData(double overdue[],double SBamount[],double amount[],double LastMonthTX[],double purchaseddebt[]){
		base.assertEqualsActualExpected(base.getElementTextWithWait(NormalPayNum), (int)SBamount[0]+"笔");
		base.assertEqualsActualExpected(base.getElementTextWithWait(NormalPayAmount), base.roundingMoney(SBamount[1]));
		base.assertEqualsActualExpected(base.getElementText(ReceivedOverdueNum), (int)SBamount[4]+"笔");
		base.assertEqualsActualExpected(base.getElementText(ReceivedOverdueAmount), base.roundingMoney(SBamount[5]+SBamount[6]));
		base.assertEqualsActualExpected(base.getElementText(OverdueNum1), (int)(SBamount[2]+overdue[0])+"笔");
		base.assertEqualsActualExpected(base.getElementText(OverdueAmount), base.roundingMoney(SBamount[3]+overdue[1]));
		base.assertEqualsActualExpected(base.getElementText(TransferNum), (int)amount[10]+"笔");
		base.assertEqualsActualExpected(base.getElementText(TransferAmount), base.roundingMoney(amount[11]));
		base.assertEqualsActualExpected(base.getElementText(InvestSBNum), (int)amount[4]+"笔");
		base.assertEqualsActualExpected(base.getElementText(InvestSBAmount), base.roundingMoney(amount[5]));
//		base.assertEqualsActualExpected(base.getElementText(BuyCreditNum), (int)amount[2]+"笔");
//		base.assertEqualsActualExpected(base.getElementText(BuyCreditAmount), base.roundingMoney(amount[3]));
		base.assertEqualsActualExpected(base.getElementText(BuyCreditNum), (int)purchaseddebt[0]+"笔");
		base.assertEqualsActualExpected(base.getElementText(BuyCreditAmount), base.roundingMoney(purchaseddebt[1]));
		base.assertEqualsActualExpected(base.getElementText(RechargeNum), (int)amount[8]+"笔");
		base.assertEqualsActualExpected(base.getElementText(RechargeAmount1), base.roundingMoney(amount[9]));
		base.assertEqualsActualExpected(base.getElementText(FeeNum), (int)amount[6]+"笔");
		base.assertEqualsActualExpected(base.getElementText(FeeAmount), base.roundingMoney(amount[7]));
		base.assertEqualsActualExpected(base.getElementText(WithdrawNum), (int)LastMonthTX[0]+"笔");
		base.assertEqualsActualExpected(base.getElementText(WithdrawAmount), base.roundingMoney(LastMonthTX[1]));	
	}
	//点击正常还款的“查看”按钮
	public void clickNormalPayViewLnk(){
		base.clickWithWait(NormalPayViewLnk);
		base.checkElementVisible(ExportRecordBtn);
		base.assertEqualsActualExpected(base.getLnkElementText(ExportRecordBtn,"value"), "交易记录导出 ");
	}
	//检查“正常还款”数据列表
	public void checkNormalPayData(double num,double Paymoney){
		DecimalFormat df = new DecimalFormat("###0.00");
		base.assertEqualsActualExpected(base.getElementTextWithWait(NormalPayTxt), "该月正常还款"+(int)num+"笔,共计"+df.format(Paymoney));
		base.assertEqualsActualExpectedByInt(base.getElements(PayLines).size(), (int) num);
		double amount=0;
		List<WebElement> money = base.getElements(DealAmount);
		for(int i=1;i<=num;i++){
			String money1 = money.get(i-1).getText();//18437.37
			amount= amount+Double.parseDouble(money1);
		}
		base.assertEqualsActualExpectedByDouble(amount, Paymoney);
		clickClosePlanLnk();
	}
	//点击“交易记录导出”按钮
	public void clickExportRecordBtn(){
		base.clickWithWait(ExportRecordBtn);
		base.sleep(5000);
	}
	//点击“我的举报”链接
	public void clickMyReportLnk(){
		base.clickWithWait(MyReportLnk);
		base.checkElmentText(SubTitle, "我的举报");
		if(base.getElementTextWithWait(FirstLine).equals("无举报记录！")){
			System.out.println("没有任何的举报信息！");
		}else{
			base.assertTrueByBoolean(base.getElements(FirstLine).size()>0);
		}
	}
	//点击“被举报人”姓名
	public void clickReportedName(){
		base.clickWithWait(ReportedUser);
		base.jumpToNewWindow();
		base.checkTitleContains(PageTitles.xinYongPingJiaYe);
		base.closeAndjumptoOldWindow();
	}
	//检查“我的举报”中的信息
	public void checkReportInformation(String username,String type,String des,String date){
		String report[] = {username,type,des,date,"","---"};
		List<WebElement> info =  base.getElements(FirstLineInfos);
		for(int i=0;i<6;i++){
			base.assertEqualsActualExpected(info.get(i).getText(), report[i]);
		}
	}
	//点击“我的黑名单”链接
	public int clickMyBlacklistLnk(){
		base.clickWithWait(MyBlacklistLnk);
		base.checkElmentText(SubTitle, "我的黑名单");
		if(base.getElementTextWithWait(FirstLine1).equals("无黑名单记录！")){
			System.out.println("没有任何的黑名单信息！");
			return 0;
		}else{
			int size = base.getElements(FirstLine1).size();
			base.assertTrueByBoolean(size>0);
			return size;
		}
	}
	//检查“我的黑名单”中的信息
	public void checkBlacklistInfo(String username,String reason,String date){
		String blacklist[] = {"",username,reason,date,"删除"};
		List<WebElement> info =  base.getElements(FirstLineInfos1);
		for(int i=0;i<5;i++){
			base.assertEqualsActualExpected(info.get(i).getText(), blacklist[i]);
		}
	}
	//点击“我的黑名单”中借款人姓名
	public void clickBlacklistName(){
		base.clickWithWait(UserName);
		base.jumpToNewWindow();
		base.checkTitleContains(PageTitles.xinYongPingJiaYe);
		base.closeAndjumptoOldWindow();
	}
	//选中“我的黑名单”中第一条前面的复选框
	public void checkFirstCheckbox(){
		base.clickWithWait(Checkbox);
		base.assertTrueByBoolean(base.getElementWithWait(Checkbox).isSelected());
	}
	//点击“删除”黑名单操作
	public void clickDeleteBlacklistLnk(boolean acceptNextAlert){
		base.clickWithWait(DeleteLnk);
		base.assertEqualsActualExpected(base.getAlertwithWait().getText(), "您确定将此用户从您的黑名单中移除吗？");
		if(acceptNextAlert){
			base.acceptAlert();
			base.checkAlertText("该信息删除成功！");
		}else{
			base.dismissAlert();
			base.checkElementVisible(SubTitle);
		}
	}
	//验证删除一条黑名单后记录小时
	public void checkDeleteoneBlacklist(int num){
		int num1=0;
		if(base.getElementTextWithWait(FirstLine1).equals("无黑名单记录！")){
			System.out.println("没有任何的黑名单信息！");
		}else{
			int size = base.getElements(FirstLine1).size();
			num1=size;
		}
		base.assertEqualsActualExpectedByInt(num1, num-1);
	}
	//点击“同城预投标”链接
	public int clickLocalPreBidLnk(){
		base.clickWithWait(LocalPreBidLnk);
		base.checkElmentText(SubTitle, "同城预投标");
		if(base.getElementTextWithWait(FirstLine).equals("暂无可投标")){
			return 0;
		}else{
			int size = base.getElements(FirstLine).size();
			base.assertTrueByBoolean(size>0);
			return size;
		}
	}
	//点击“已结清的投资”
	public boolean clickClosedInvestLnk(){	
		base.clickWithWait(ClosedInvestLnk);
		if(base.getElementTextWithWait(BackingContent).equals("您目前还没有已结清的投资款！")){
			System.out.println("您目前还没有已结清的投资款！");
			Reporter.log("<br/>您目前还没有已结清的投资款！");
			return false;
		}else{
			base.assertTrueByBoolean(base.getElements(ClosedContent).size()>0);
			return true;
		}
	}
	//点击“已结清的投资”中首条投资标题
	public String clickClosedInvestTitle(){
		base.clickWithWait(BorrowTitle);
		base.checkElementVisible(PayPlanDetail);
		return base.getElementTextWithWait(FirstPhase).split("/")[1];
	}
	//“已结清的投资”中点击“查看下载电子借条”链接
	public void clickElectronicIOULnk(){
		base.clickWithWait(ViewElectronicIOULnk);
		base.jumpToNewWindow();
		base.checkTitle("电子借条");
	}
	//“已结清的投资”中点击“借款详情”链接
	public String[] clickLoanDetailLnk(){
		base.clickWithWait(LoanDetailLnk);
		base.jumpToNewWindow();
		String time = base.getElementTextWithWait(InvestmentDetailPage.BidFullTime);//2015-09-01
		String goal=base.getElementTextWithWait(InvestmentDetailPage.BorrowType);
		String type= goal.substring(goal.indexOf("【")+1,goal.indexOf("】"));
		String des = base.getElementTextWithWait(InvestmentDetailPage.BorrowDescription);
		String data[]={time,type,des};
		base.closeAndjumptoOldWindow();
		return data;
	}
	//点击“回收中的投资”
	public void clickPaybackLnk(){
		base.clickElementNoWait(PaybackLnk);
		base.checkElmentText(BidStatusTxt, "按标状态");

	}
	//获取“回收中的投资”列表的页数
	public int getBackingPages(){
		if(base.getElementTextWithWait(BackingContent).equals("您目前还没有回收中的投资款！")){
			return 0;
		}else{
			if(base.isElementEmpty(SixPageLnk)){
				return 1;
			}else{
				base.clickWithWait(LastPage);
				base.checkElementVisible(LastTwoPage);
				int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
				base.clickWithWait(FirstPage);
				base.checkElmentText(CurrentPage, "1");
				return lastPageNum;
			}
		}
	}
	
	//点击“参与中的投资”
	public boolean clickJoiningInvestLnk(){
		base.clickWithWait(JoiningInvestLnk);
		if(base.isElementPresent(NoJoiningInvestTxt)){
			base.assertEqualsActualExpected(base.getElementText(NoJoiningInvestTxt), "您目前还没有参与中的投资款！");
			return false;
		}else{
			base.assertTrueByBoolean(base.getElements(JoiningLines).size()>0);
			return true;
		}
	}
//	public double checkMoneyinBacking(){
//		int page = getBackingPages();
//		double receivingamout=0,receivingLX=0,receivingBJ=0;
//		if(page==0){
//			return 0;
//		}else{
//			for(int i=1;i<=page;i++){
//				
//				List<WebElement> investmoney =  base.getElements(InvestMoney);//贷出金额
//				List<WebElement> rate =  base.getElements(Rate);//年利率
//				List<WebElement> receivingmoney =  base.getElements(ReceivingMoney);//待收金额
//				List<WebElement> title =  base.getElements(BackingTitle);//标题
//				int num=receivingmoney.size();System.out.println(num);
//				for(int j=0;j<num;j++){
//					String money = receivingmoney.get(j).getText().substring(1);
//					receivingamout=receivingamout+Double.parseDouble(money);//待收本息
//					String investmoney1 = investmoney.get(j).getText().split("￥")[1];
//					String ratenum = rate.get(j).getText().substring(5, rate.get(j).getText().length()-1);
//					String interests = base.roundingMoney(Double.parseDouble(investmoney1)*Double.parseDouble(ratenum)/12);
//					title.get(j).click();
//					base.checkElementVisible(PayPlanDetail);
//					List<WebElement> receivingbenxi =  base.getElements(ReceivingBXinTable);//未收本息
//					int size = receivingbenxi.size();
//					for(int k=0;k<size;k++){
//						String receivingBX1 = receivingbenxi.get(k).getText();
//						if(receivingBX1.equals(interests)){
//							receivingLX=receivingLX+Double.parseDouble(receivingBX1);
//						}else if(receivingBX1.equals(interests+investmoney1)){
//							receivingLX=receivingLX+Double.parseDouble(interests);
//							receivingBJ=receivingBJ+Double.parseDouble(investmoney1);
//						}else if(receivingBX1.equals(Double.parseDouble(investmoney1))){
//							
//						}
//					}				
//				}
//				base.clickWithWait(LastOnePage);
//			}
//			return receivingamout;
//		}
//	}
	//输入查询的开始时间和结束时间
	public void inputSearchDate(String startdate,String enddate){
		base.setDate("begindate", startdate);
		base.setDate("enddate", enddate);
	}
	//输入借入者
	public void InputBorrower(String name){
		base.sendKeysWithWait(InputBorrower, name);
	}
	//点击“查询”按钮
	public void clickSearchBtn(){
		base.clickWithWait(SearchBtn);
		base.sleep(2000);
	}
	//“本月应收的投资”中是否有数据
	public boolean ifExistInvest(){
		if(base.getElementTextWithWait(Content).equals("")){
			return false;
		}else{
			return true;
		}
	}

	public void clickClosePlanLnk(){
		base.clickWithWait(ClosePlanLnk);
		base.checkNoElement(ClosePlanLnk);
	}
	//本月应收的投资
	public int getPagesNum(){
		if(base.getElementTextWithWait(Content).equals("")){
			return 0;
		}else{
			if(!base.isElementPresent(SixPageLnk)){
				return 1;
			}else{
				base.clickWithWait(LastPage);
				base.checkElementVisible(LastTwoPage);
				int lastPageNum = Integer.valueOf(base.getElementText(LastTwoPage));
				base.clickWithWait(FirstPage);
				base.checkElmentText(CurrentPage, "1");
				return lastPageNum;
			}
		}
	}
	//获取上个月准时还款,逾期未收,逾期已收还款金额和笔数
	public double[] getAmountandNum(){
		int day = base.getCurrentDay();
		String begin,end,lastmonth;
		if(day<5){
			end = base.getLastMonthDay(-2);
			begin = base.getLastMonthDate(-3);
		}
		else{
			end = base.getLastMonthDay(-1);
			begin = base.getLastMonthDate(-2);
		}
		inputSearchDate(begin,end);	
		clickSearchBtn();
		clickSearchBtn();
		if(day<5){
			lastmonth=base.getMonthDate(-2);
		}else{
			lastmonth=base.getMonthDate(-1);
		}		
		int receivednum=0,receivingnum=0,receivedOverdueNum=0;
		double receivedmoney=0,payingOverdue=0,paidOverdue =0,fakuanmoney=0;
		int page = getPagesNum();
		if(page==0){
			double a[]= {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
			return a;
		}else{
			for(int p=1;p<=page;p++){
				List<WebElement> realpaytime = base.getElements(RealPayDate);
				List<WebElement> PlanLnk = base.getElements(PaymentPlanLnk);
				int size = realpaytime.size();
				for(int i=0;i<size;i++){
					if(realpaytime.get(i).getText().contains(lastmonth)){
//					if(realpaytime.get(i).getText().substring(0,7).equals(lastmonth)){
						PlanLnk.get(i).click();//点击“收款计划”链接弹出"收款计划"详情窗口
						base.checkElmentText(PaymentPlanTitle, "收款计划");
						List<WebElement> realdate = base.getElements(RealDate);
						List<WebElement> status = base.getElements(StatusTxt);
						List<WebElement> received = base.getElements(ReceivedBX);
						List<WebElement> receiving = base.getElements(ReceivingBX);
						List<WebElement> fakuan = base.getElements(FaKuan);
						int num = realdate.size();
						for(int j=0;j<num;j++){
							String month = realdate.get(j).getText();
							if(month.contains(lastmonth) && status.get(j).getText().equals("准时收款")){
								receivednum=receivednum+1;
								String received1 =received.get(j).getText().substring(1);
//								if(received1.contains(",")){
									received1=received1.replaceAll(",", "");
//								}
								receivedmoney =receivedmoney+Double.parseDouble(received1);
							}else if(month.contains(lastmonth) && status.get(j).getText().equals("逾期待收")){
								receivingnum=receivingnum+1;
								String receiving1 =receiving.get(j).getText().substring(1);
//								if(receiving1.contains(",")){
									receiving1=receiving1.replaceAll(",", "");
//								}
								payingOverdue=payingOverdue+Double.parseDouble(receiving1);
							}else if(month.contains(lastmonth) && status.get(j).getText().equals("逾期收款")){
								receivedOverdueNum=receivedOverdueNum+1;
								String received2 =received.get(j).getText().substring(1);
								String fakuan1 = fakuan.get(j).getText().substring(1);
//								if(received2.contains(",")){
									received2=received2.replaceAll(",", "");
//								}
//								if(fakuan1.contains(",")){
									fakuan1=fakuan1.replaceAll(",", "");
//								}
								paidOverdue =paidOverdue+Double.parseDouble(received2);
								fakuanmoney = fakuanmoney+Double.parseDouble(fakuan1);
							}
						}
						clickClosePlanLnk();
					}
				}	
				base.clickWithWait(LastOnePage);	
			}
			double data[]= {receivednum,receivedmoney,receivingnum,payingOverdue,receivedOverdueNum,paidOverdue,fakuanmoney};//准时收款笔数,准时收款金额,逾期未收笔数，逾期未收金额,逾期已收笔数,逾期已收金额,逾期罚息
			return data;
		}
	}
	
	//点击第一个投资中的“债权转让”链接
	public void clickCreditAssignLnk(){
		if(base.getElementWithWait(NoPaybackTxt).isDisplayed()){
			base.assertEqualsActualExpected(base.getElementText(NoPaybackTxt), "您目前还没有回收中的投资款！");
		}else{
			base.clickWithWait(CreditAssignLnk);
			base.checkElmentText(PopCreditAssignTxt, "债权转让");
		}
	}
	//输入“转让原因”
	public void InputAssignReason(){
		base.elementSendkey(InputAssignReason, "测试债权转让功能是否正确");
	}
	//选择转让模式“一口价”
	public void chooseFixedPriceRadio(){
		base.clickElementNoWait(FixedPriceRadio);
	}
	//选择转让模式“拍卖”
	public void chooseAuctionRadio(){
		base.clickElementNoWait(AuctionRadio);
	}
	//输入“支付密码”
	public void InputPayPwd(){
		base.elementSendkey(InputPayPwd, "111111");
	}
	//点击“确定”按钮
	public void clickOKBtn(){
		base.clickElementNoWait(OKBtn);
	}
	
	/**
	 * 徐天元
	 * 点击同城预投标
	 */
	public void clickBit(){
		base.clickWithWait(By.cssSelector(".tb3>a"));
	}
	
	/**
	 * 徐天元
	 * 判断是否有同城预投标 有的话点击第一个
	 */
	public boolean ifHasSameCityBit(){
		List<WebElement> lists = base.getElements(By.cssSelector(".mt10.global_table a"));
		if (lists.size()==0) {
			Reporter.log("没有同城预投标"+"<br/>");
		}else {
			lists.get(0).click();
		}
		return false;
	}
	
	/**
	 * 点击“回收中的投资”
	 * @author 江渤洋
	 */
	public void clickRetrieve(){
		base.clickWithWait(retrieveTxt);
	}
	
	/**
	 * 获取散标投资相关信息的值（例如：待收本金、待收利息）
	 * @param infoName：信息名称
	 * @return 信息的值
	 * @author 江渤洋 2015-10-8
	 */
	public String getRetrieveInfoNum(String infoName){
		
		String value = null;
		if(infoName.equals("待收本金")){
			value = base.getElementTextWithWait(waitPrincipalNumByLend);
		}
		else if(infoName.equals("待收利息")){
			value = base.getElementTextWithWait(waitInterestNumByLend);
		}
		value = base.stringToReplace(value, ",", "");
		value = value.trim();
		return value;
	}
	
}
