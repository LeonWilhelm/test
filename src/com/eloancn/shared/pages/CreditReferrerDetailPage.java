package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eloancn.shared.common.Base;

/*
 * 翼星计划-债权推荐人详情页
 */
public class CreditReferrerDetailPage {
	
	Base base = new Base();
	public static By ReferrerPage = By.cssSelector("div.content.wrap.mt20");
	public static By BasicInfoTxt = By.cssSelector("div.red_border>span");				//基本信息
	By AccountManageInfoTxt = By.cssSelector("div.red_guanli > span");					//账户管理信息
	By SXManageInfoTxt = By.xpath("//div[9]/div/span");						  			//授信管理信息
	public static By QualifiedPhoto = By.cssSelector("div.pic");
	public static By QualifiedPhotoTxt = By.cssSelector("p.zp_des");
	
	By FivePartsTxt = By.cssSelector("div.comperson>div.border_xia");		            //5部分
	By UnfoldLnk = By.cssSelector("div.normal.posiR>abbr");								//授信管理信息中的展开链接
	By CMUnfoldLnk = By.xpath("/html/body/div[4]/div/div[15]/abbr");					//信用管理信息中的展开链接
	By DefaultsLines = By.cssSelector("div.mrl165");									
	
	public static By ReferrerName = By.cssSelector("span.qy_name1");	//“推荐人”名称
	
	//借款管理信息
	By OverdueNum = By.xpath("//span[4]");												//逾期笔数
	
	
	public Boolean ifinReferrerPage(){
		return base.isElementPresent(CreditReferrerDetailPage.BasicInfoTxt);
	}
	//检查债权推荐人的详细信息
	public void verifyReferrerDetailPage(){
		try{
			String [] Titles = {"基本信息","账户管理信息","授信管理信息","信用管理信息","借款管理信息"};
			List<WebElement> FivePart = base.getElements(FivePartsTxt);
			for(int i = 0;i<FivePart.size();i++){
				base.assertEqualsActualExpected(FivePart.get(i).getText(), Titles[i]);
			}
			base.assertTrueByBoolean(base.getElementText(UnfoldLnk).contains("展开"));
			base.assertTrueByBoolean(base.getIndexElementText(UnfoldLnk,1).contains("展开"));
			base.closeWebDriver();
		}catch(Exception e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//点击“授信管理信息”中展开链接
	public void clickSXUnfoldLnk(){
		base.clickElementNoWait(UnfoldLnk);
		base.checkElmentText(UnfoldLnk, "收起"+"\n"+"+");
	}
	//点击“信用管理信息”中展开链接
	public void clickCMUnfoldLnk(){
		base.clickElement(UnfoldLnk, 1);
//		base.waitPage(2000);
//		base.assertEqualsActualExpected(base.getIndexElementText(UnfoldLnk, 1), "收起"+"\n"+"+");
		if(base.isElementPresent(DefaultsLines)){
			int num = base.getElements(DefaultsLines).size()+15;
			base.checkElmentText(By.xpath("/html/body/div[4]/div/div["+num+"]/abbr"), "收起"+"\n"+"+");
		}else{
			base.checkElmentText(CMUnfoldLnk, "收起"+"\n"+"+");
		}
	}
	
	public void checkLoanManageInfo(){
		
		try{
			if(base.getElementTextWithWait(OverdueNum).equals("0笔")){
				String [][] LoanInfos = {{"逾期率：","0%","逾期笔数：","0笔","催收率：","100%"},{"贷损率：","0%","贷损笔数：","0笔","贷款损失金额：","0元"},{"抵押物处置率：\n暂无","抵押物处置笔数：","暂无"},{"逾期金额：","0元"},{"通过平台募资总资金：","40000元"}};
				for(int i=0;i<5;i++){
					for(int j=0;j<LoanInfos[i].length;j++){
						if(i==4 && j==1){
							String money = base.getElementTextWithWait(By.xpath("//div[23]/span[2]"));
							base.assertTrueByBoolean(money.contains("元"));
							String amount = money.substring(0,money.length()-1);
							base.assertTrueByBoolean(Integer.valueOf(amount)>=0);
						}else{
							base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div["+(19+i)+"]/span["+(j+1)+"]")), LoanInfos[i][j]);
						}	
					}
				}
			}else{
				System.out.println("有逾期的借款！");
			}
			base.closeAndjumptoOldWindow();
		}catch(Exception e){
			base.closeAndjumptoOldWindow();
			e.printStackTrace();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeAndjumptoOldWindow();
			Assert.fail(e.toString());
		}
	}
	
	
}
