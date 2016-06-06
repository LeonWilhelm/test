package com.eloancn.shared.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.eloancn.shared.common.Base;

/*
 * 债权转让详情页
 */
public class CreditDetailPage {
	
	Base base = new Base();
	
	public static By DetailPart = By.cssSelector("div.wd660.fl.pdt20.pdl20");
	public static By CreditTitleinDetail = By.cssSelector("span.color06");			//借款详情页的标题
	public static By NextRepayDate = By.cssSelector("span.color8");					//下个还款日
	public static By LoanInfoTxt = By.xpath("//h2");								//借款概况
//	public static By MoreDetailLnk = By.xpath("//a[text()='更多详情>>']");			//更多详情
	public static By MoreDetailLnk = By.cssSelector(".h30.lineh30.textR.font12.mr20>a");		
	public static By Record = By.cssSelector("span.current");						//竞拍记录
//	public static By DebtPayDetail = By.xpath("//div[2]/span[2]");					//债权收款详情
	public static By DebtPayDetail = By.cssSelector(".records.bgFF.clear.mt20>span:nth-child(2)");
	public static By ConsultRecordTxt = By.cssSelector("h3 > span");				//咨询记录
	public static By PostMessageBtn = By.cssSelector("a.ask");						//发表留言
	
	public static By WaitPrincipalTxt = By.xpath("//li/p");
	public static By InterestRateTxt = By.cssSelector("p.clear > span.colorE6.font20");
	public static By RemainDateTxt = By.xpath("//p[3]/span");
	public static By TransferModeTxt = By.xpath("//p/i");
	public static By BuyNowBtn = By.xpath("//li[@class='fl wd213 mt20 mb20']/p[2]/input");
	
	public boolean ifinDetailPage(){
		return base.isElementPresent(CreditTitleinDetail);
	}
	
	//修改 集成环境下校验内容 江渤洋 2015-7-17
	public void verifyCreditDetail(){
		try{
			base.getElementText(NextRepayDate).contains("下个还款日");
			base.assertEqualsActualExpected("借款概况", base.getElementText(LoanInfoTxt));
			
			if(!base.indexURL.contains("/client") || !base.indexURL.contains("inclient")){
				base.assertTrueBy(MoreDetailLnk);
				base.assertEqualsActualExpected("债权收款详情",base.getElementText(DebtPayDetail));
			}
			base.assertEqualsActualExpected("竞拍记录",base.getElementText(Record));
			base.assertEqualsActualExpected("咨询记录",base.getElementText(ConsultRecordTxt));
			base.closeAndjumptoOldWindow();
		}catch(Exception e){
			base.closeAndjumptoOldWindow();
			Assert.fail(e.toString());
		}
	}	
}
