package com.eloancn.shared.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eloancn.shared.common.Base;

/*
 * “我的账户”-“债权转让”页面
 */
public class CreditAssignPage {
	Base base = new Base();
	
	public static By CreditAssignTxt = By.cssSelector("h1.f-fc333");			//债权转让子标题
	By SelectedSubTab = By.cssSelector("span.wd140.current");
	public static By NoCreditTxt = By.cssSelector("div.global_tip.textC");					//没有可转出的债权
//	By CreditContent = By.cssSelector("#cred_tb>tbody");						//"可转出的债权"内容
	By CreditAssignLnk = By.xpath("//table[@id='cred_tb']/tbody/tr/td[8]/a");	//“债权转让”操作
	public static By FirstCredit = By.cssSelector("#cred_tb>tbody");
	By Credits = By.cssSelector("#cred_tb>tbody>tr");							//显示几条债权信息
	By FirstCreditCheckbox = By.id("subcheck");									//第一个债权复选框	
	By WaitBJ = By.xpath("//table[@id='cred_tb']/tbody/*/td[4]");			//所有待收本金金额
	By WaitPrincipal = By.xpath("//table[@id='cred_tb']/tbody/tr/td[4]");	//待收本金的数量
	By WaitBX = By.xpath("//table[@id='cred_tb']/tbody/*/td[5]");			//所有待收本息金额
	By BulkTransferBtn = By.cssSelector("div.btn1 > input[type=\"button\"]");	//批量转让
	
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
	
//	String WaitPrincipalNum = base.getElementText(WaitPrincipal);
	
	//转出的债权
	By TransferDebtLnk = By.id("creditassignlist");
	By collectOverdueLnk = By.xpath("//ul[@id='assignbutton']/li[3]/a");//系统逾期回收
	By SearchBtn = By.cssSelector("input.time_submit");
	By FirstTransferDebtTitle = By.cssSelector("#form1>table>tbody>tr>td");
	By SixPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");				//页数的第6个链接
	By LastPage = By.xpath("//div[@id='Pagination']/ul/li[text()='末页']");		//末页
	By LastOnePage = By.xpath("//div[@id='Pagination']/ul/li[text()='>']");		//末页的前一个链接
	By LastTwoPage = By.xpath("//div[@id='Pagination']/ul/li[last()-2]");		//末页的前两个链接(倒数第三个链接)
	By FirstPage = By.xpath("//div[@id='Pagination']/ul/li[text()='首页']");		//首页
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");				//目前页
	By DealingAmount = By.xpath("//form[@id='form1']/table/tbody/*/td[3]");		//"转出的债权"列表中的成交金额
	By TransferStatus = By.xpath("//form[@id='form1']/table/tbody/*/td[7]");	//"转出的债权"列表中的状态
	By DetailActionLnk = By.xpath("//form[@id='form1']/table/tbody/*/td[8]/a[2]");//详情操作
	By TransferDetailTitle = By.cssSelector("div.tit");//转让详情
	By PayDate= By.xpath("//div[@id='showincome1']/table/tbody/*/td[2]");//应收款日期
	By ReceivingBX = By.xpath("//div[@id='showincome1']/table/tbody/*/td[5]");//待还本息
	By Status = By.xpath("//div[@id='showincome1']/table/tbody/*/td[6]/span");//状态
	By closeDetailLnk = By.cssSelector("a.close");//关闭“转让详情”窗口
	public static By WithDrawLnk = By.cssSelector("a.colorF8");//撤回
	By WithDrawTransferTitle = By.cssSelector("span.fl");//借款标题
	By InputWithDrawPwd = By.id("paypassword");//
	
	//已购买的债权
	By PurchasedDebtLnk = By.id("purchase");
	By PurchasedDebtContent = By.id("tabList0");
	By PurchasedMoney = By.xpath("//div[@id='tabList0']/table/tbody/*/td[2]");
	
	
	//是否有“可转出的债权”
	public Boolean ifshowCredit(){
		if(base.getElementTextWithWait(FirstCredit).equals("")){
			return false;
		}else{
			return true;
		}
	}
	//点击第一个“债权转让”操作
	public void clickCreditAssignLnk(){
			base.clickWithWait(CreditAssignLnk);
			base.checkElmentText(PopCreditAssignTxt, "债权转让");
	}
	//输入“转让原因”
	public void InputAssignReason(){
		base.elementSendkey(InputAssignReason, "测试债权转让功能是否正确");
	}
	//选择转让模式“一口价”
	public void chooseFixedPrice(){
		base.clickElementNoWait(FixedPriceRadio);
	}
	//选择转让模式“拍卖”
	public void chooseAuction(){
		base.clickElementNoWait(AuctionRadio);
	}
	//选择转让模式“密转”
	public void chooseSecretAssign(){
		base.clickElementNoWait(SecretAssignRadio);
	}	
	//选择“有效时间”
	public void selectRemainTime(String TimeTxt){
		base.elementSelectByVisibleText(SelectRemainTime, TimeTxt);
	}
	//输入“转让底价”
	public void InputLowPrice(){
		String WaitPrincipal = base.getElementText(WaitPrincipalTxt);
		if(WaitPrincipal.contains(".")){
			WaitPrincipal = WaitPrincipal.split("\\.")[0];
		}
		base.elementSendkey(InputLowPrice, WaitPrincipal);
	}
	//输入“密转码”
	public void InputTransforCode(){
		base.elementSendkey(InputTransforCode, "4521");
	}
//	public void verifyWaitPrincipal(){
//		String num=base.getElementText(WaitPrincipalTxt);
//		String num1= base.getHideElementText(WaitPrincipal);
//		base.assertEqualsActualExpected(base.getHideElementText(WaitPrincipal), num);
//	}
	//输入“支付密码”
	public void InputPayPwd(String pwd){
		base.elementSendkey(InputPayPwd, pwd);
	}
	//点击“确定”按钮
	public void clickOKBtn(){
		base.clickElementNoWait(OKBtn);
		if(base.getAlertwithWait().getText().equals("恭喜！债权转让信息已发布！")){
			base.getAlert().accept();
		}else{
			base.assertEqualsActualExpected(base.getAlert().getText(), "批量转让成功!");
			base.getAlert().accept();
		}
	}
	//点击“取消”按钮
	public void clickCancelBtn(){
		base.clickWithWait(CancelBtn);
	}
	//选中第一个债券
	public void checkFirstCredit(){		
			base.clickWithWait(FirstCreditCheckbox);
	}
	//点击“批量转让”按钮
	public void clickBulkTransferBtn(){
		base.clickWithWait(BulkTransferBtn);
	}
	//点击“转出的债权”
	public void clickTransferDebtLnk(){
		base.clickWithWait(TransferDebtLnk);
		base.checkElementVisible(FirstTransferDebtTitle);
	}
	//点击“已购买的债权”
	public void clickPurchasedDebtLnk(){
		base.clickWithWait(PurchasedDebtLnk);
		base.checkElmentText(SelectedSubTab, "已购买的债权");
		base.checkElementsVisible(PurchasedDebtContent);
	}
	//点击“系统逾期回收”
	public void clickcollectOverdueLnk(){
		base.clickWithWait(collectOverdueLnk);
		base.checkElementVisible(FirstTransferDebtTitle);
	}
	//获得“可转出的债权”的页数
	public int getCreditNum(){
		if(base.getElementTextWithWait(FirstCredit).equals("")){
			return 0;
		}else{
			if(base.isElementEmpty(SixPageLnk)){
				return 1;
			}else{
				base.clickWithWait(LastPage);
				int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
				base.clickWithWait(FirstPage);
				base.checkElmentText(CurrentPage, "1");
				return lastPageNum;
			}
		}
	}
	//点击“撤回”
	public void clickWithDrawLnk(){
		base.clickElementNoWait(WithDrawLnk);
		base.checkElement(WithDrawTransferTitle);
	}
	//输入“债权转让撤回”密码
	public void InputWithDrawPwd(){
		base.elementSendkey(InputWithDrawPwd, "111111");
	}
	//点击“债权转让撤回”确定按钮
	public void clickWithdrawOkBtn(){
		base.clickElementNoWait(OKBtn);
		base.assertEqualsActualExpected(base.getAlert().getText(), "该债权转让已撤回！");
		base.getAlert().accept();
	}
	//输入查询的开始时间和结束时间
	public void inputSearchDate(String startdate,String enddate){
		base.setDate("startdate", startdate);
		base.setDate("enddate", enddate);
	}
	//点击“查询”按钮
	public void clickSearchBtn(){
		base.clickWithWait(SearchBtn);
		base.sleep(2000);
	}
	public void clickCloseDetailLnk(){
		base.clickWithWait(closeDetailLnk);
		base.checkNoElement(closeDetailLnk);
	}
	public int getTransferedCreditNum(){
		if(base.getElementTextWithWait(FirstTransferDebtTitle).equals("您目前还没有“转出的债权”！")){
			return 0;
		}else{
			if(!base.isElementPresent(SixPageLnk)){
				return 1;
			}else{
				base.clickWithWait(LastPage);
				base.checkElementsVisible(LastTwoPage);
				int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
				base.clickWithWait(FirstPage);
				base.checkElmentText(CurrentPage, "1");
				return lastPageNum;
			}
		}
	}
	//获取“可购买的债权”的页数
	public int getPurchasedDebtPages(){
		if(base.getElementTextWithWait(PurchasedDebtContent).equals("您目前还没有“已购买的债权”！")){
			return 0;
		}else{
			base.clickWithWait(LastPage);
			base.checkElementsVisible(LastTwoPage);
			int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
			base.clickWithWait(FirstPage);
			base.checkElmentText(CurrentPage, "1");
			return lastPageNum;
		}
	}
	//获取上个月或上上个月购买债权的总金额和笔数（用于散标投资-电子账单）
	public double[] getPurchasedDebtMoneyandNum(){
		clickPurchasedDebtLnk();
		Calendar calendar = Calendar.getInstance();
		String begin= base.getLastMonthDate(-1),end= base.getLastMonthDay(-1);
		int day = calendar.get(Calendar.DAY_OF_MONTH);	
		if(day>=1 && day<5){	
			begin = base.getLastMonthDate(-2);
			end = base.getLastMonthDay(-2);
		}
		inputSearchDate(begin,end);		
		clickSearchBtn();
		clickSearchBtn();
		int purchasednum=0;
		double purchasedmoney=0;
		int page = getPurchasedDebtPages();
		if(page==0){
			double a[]={0,0};
			return a;
		}else{
			for(int i=1;i<=page;i++){
				base.checkElmentText(CurrentPage, String.valueOf(i));
				List<WebElement> money = base.getElements(PurchasedMoney);
				int size = money.size();
				for(int j=0;j<size;j++){
					String Money = money.get(j).getText();
					purchasedmoney=purchasedmoney+Double.parseDouble(Money);
				}
				purchasednum=purchasednum+size;
				base.clickWithWait(LastOnePage);
			}
		}System.out.println(purchasedmoney);
		double data[]={purchasednum,purchasedmoney};
		return data;
	}
	//获取上个月债权转让的总金额和笔数
	public double[] getTransferAmountandNum(){
		clickTransferDebtLnk();
		String begin=base.getLastMonthDate(0);
		inputSearchDate(begin,base.dateFormat(base.getTime(), "yyyy-MM-dd"));
		clickSearchBtn();
		clickSearchBtn();
		int transfernum =0;
		double transferamount = 0;
		int page = getTransferedCreditNum();
		if(page==0){
			double a[]={0,0};
			return a;
		}else{
			for(int i=1;i<=page;i++){
				List<WebElement> status = base.getElements(TransferStatus);
				List<WebElement> amount = base.getElements(DealingAmount);
				int size = status.size();
				for(int j=0;j<size;j++){
					String status1 = status.get(j).getText();
					if(status1.equals("已转出")||status1.equals("逾期已回收")){
						transfernum =transfernum+1;
						String Amount = amount.get(j).getText();//22900.79
						transferamount=transferamount+Double.parseDouble(Amount);
					}
				}				
				base.clickWithWait(LastOnePage);	
			}
		}
		double data[] = {transfernum,transferamount};
		return data;
	}
	//获取上个月逾期已回收(转出的债权里)的总金额和笔数,逾期未还
	public double[] collectedSBAmountandNum(){
		clickTransferDebtLnk();
		clickcollectOverdueLnk();
		String begin,end,lastmonth;
		int day=base.getCurrentDay();
		if(day<5){
			begin=base.getLastMonthDate(-1);//上个月的第一天
			end = base.getLastMonthDay(-1);//上个月的最后一天
		}else{
			begin=base.getLastMonthDate(0);//这个月的第一天
			end = base.dateFormat(base.getTime(), "yyyy-MM-dd");//这个月的当天
		}
		inputSearchDate(begin,end);
		clickSearchBtn();
		clickSearchBtn();
		if(day<5){
			lastmonth=base.getMonthDate(-2);
		}else{
			lastmonth=base.getMonthDate(-1);
		}
		int overdueNum=0;
		double overdueAmount=0;
		int page = getTransferedCreditNum();
		if(page==0){
			double a[]={0,0};
			return a;
		}else{
			for(int i=1;i<=page;i++){
				List<WebElement> detail = base.getElements(DetailActionLnk);
				int size = detail.size();
				for(int j=0;j<size;j++){
					detail.get(j).click();
					base.checkElmentText(By.xpath("//div["+(4+j)+"]/div[2]/div"), "X\n转让详情");
					List<WebElement> Paydate = base.getElements(By.xpath("//div[@id='_content_child']/div["+(4+j)+"]/div[2]/div[2]/table/tbody/*/td[2]"));//应收款日期
					List<WebElement> benxi = base.getElements(By.xpath("//div["+(4+j)+"]/div[2]/div[2]/table/tbody/*/td[5]"));
					List<WebElement> status = base.getElements(By.xpath("//div["+(4+j)+"]/div[2]/div[2]/table/tbody/*/td[6]/span"));
					int s = Paydate.size();
					for(int k=0;k<s;k++){
						if(Paydate.get(k).getText().contains(lastmonth)&&status.get(k).getText().equals("已转让")){
							overdueNum= overdueNum+1;
							String benxi1 = benxi.get(k).getText();//2,033.33
//							if(benxi1.contains(",")){
							benxi1=benxi1.replaceAll(",", "");
//							}
							overdueAmount = overdueAmount+Double.parseDouble(benxi1);
						}
					}
					base.clickWithWait(By.xpath("//div["+(4+j)+"]/div[2]/div/a"));
					base.checkNoElement(By.xpath("//div["+(4+j)+"]/div[2]/div/a"));
				}
				base.clickWithWait(LastOnePage);	
			}
			double data[]={overdueNum,overdueAmount};
			return data;
		}	
	}
	//检查是否存在系统逾期回收
	public boolean ifExistCollect(){
		clickTransferDebtLnk();
		clickcollectOverdueLnk();
		if(base.getElementText(FirstTransferDebtTitle).equals("您目前还没有“转出的债权”！")){
			return false;
		}else{
			return true;
		}
	}
	
	//获取总得待收利息，待收本金，待收本息
//	public double[] getReceivingData(){
//		int page= getCreditNum();
//		double receivingBJ=0,receivingBX=0;
//		if(page==0){
//			double a[]={0.00,0.00,0.00};
//			return a;
//		}else{
//			for(int i=1;i<=page;i++){
//				List<WebElement> credit = base.getElements(Credits);
//				int num = credit.size();
//				List<WebElement> bj = base.getElements(WaitBJ);//19524.42
//				List<WebElement> bx = base.getElements(WaitBX);
//				for(int j=0;j<num;j++){
//					receivingBJ=receivingBJ+Double.parseDouble(bj.get(j).getText());
//					receivingBX = receivingBX +Double.parseDouble(bx.get(j).getText());
//				}
//				base.clickWithWait(LastOnePage);	
//			}
//			double data[]= {receivingBX-receivingBJ,receivingBJ,receivingBX};
//			return data;
//		}				
//	}
}
