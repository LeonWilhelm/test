package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eloancn.shared.common.Base;

/*
 * ���Ǽƻ�-ծȨ�Ƽ�������ҳ
 */
public class CreditReferrerDetailPage {
	
	Base base = new Base();
	public static By ReferrerPage = By.cssSelector("div.content.wrap.mt20");
	public static By BasicInfoTxt = By.cssSelector("div.red_border>span");				//������Ϣ
	By AccountManageInfoTxt = By.cssSelector("div.red_guanli > span");					//�˻�������Ϣ
	By SXManageInfoTxt = By.xpath("//div[9]/div/span");						  			//���Ź�����Ϣ
	public static By QualifiedPhoto = By.cssSelector("div.pic");
	public static By QualifiedPhotoTxt = By.cssSelector("p.zp_des");
	
	By FivePartsTxt = By.cssSelector("div.comperson>div.border_xia");		            //5����
	By UnfoldLnk = By.cssSelector("div.normal.posiR>abbr");								//���Ź�����Ϣ�е�չ������
	By CMUnfoldLnk = By.xpath("/html/body/div[4]/div/div[15]/abbr");					//���ù�����Ϣ�е�չ������
	By DefaultsLines = By.cssSelector("div.mrl165");									
	
	public static By ReferrerName = By.cssSelector("span.qy_name1");	//���Ƽ��ˡ�����
	
	//��������Ϣ
	By OverdueNum = By.xpath("//span[4]");												//���ڱ���
	
	
	public Boolean ifinReferrerPage(){
		return base.isElementPresent(CreditReferrerDetailPage.BasicInfoTxt);
	}
	//���ծȨ�Ƽ��˵���ϸ��Ϣ
	public void verifyReferrerDetailPage(){
		try{
			String [] Titles = {"������Ϣ","�˻�������Ϣ","���Ź�����Ϣ","���ù�����Ϣ","��������Ϣ"};
			List<WebElement> FivePart = base.getElements(FivePartsTxt);
			for(int i = 0;i<FivePart.size();i++){
				base.assertEqualsActualExpected(FivePart.get(i).getText(), Titles[i]);
			}
			base.assertTrueByBoolean(base.getElementText(UnfoldLnk).contains("չ��"));
			base.assertTrueByBoolean(base.getIndexElementText(UnfoldLnk,1).contains("չ��"));
			base.closeWebDriver();
		}catch(Exception e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//��������Ź�����Ϣ����չ������
	public void clickSXUnfoldLnk(){
		base.clickElementNoWait(UnfoldLnk);
		base.checkElmentText(UnfoldLnk, "����"+"\n"+"+");
	}
	//��������ù�����Ϣ����չ������
	public void clickCMUnfoldLnk(){
		base.clickElement(UnfoldLnk, 1);
//		base.waitPage(2000);
//		base.assertEqualsActualExpected(base.getIndexElementText(UnfoldLnk, 1), "����"+"\n"+"+");
		if(base.isElementPresent(DefaultsLines)){
			int num = base.getElements(DefaultsLines).size()+15;
			base.checkElmentText(By.xpath("/html/body/div[4]/div/div["+num+"]/abbr"), "����"+"\n"+"+");
		}else{
			base.checkElmentText(CMUnfoldLnk, "����"+"\n"+"+");
		}
	}
	
	public void checkLoanManageInfo(){
		
		try{
			if(base.getElementTextWithWait(OverdueNum).equals("0��")){
				String [][] LoanInfos = {{"�����ʣ�","0%","���ڱ�����","0��","�����ʣ�","100%"},{"�����ʣ�","0%","���������","0��","������ʧ��","0Ԫ"},{"��Ѻ�ﴦ���ʣ�\n����","��Ѻ�ﴦ�ñ�����","����"},{"���ڽ�","0Ԫ"},{"ͨ��ƽ̨ļ�����ʽ�","40000Ԫ"}};
				for(int i=0;i<5;i++){
					for(int j=0;j<LoanInfos[i].length;j++){
						if(i==4 && j==1){
							String money = base.getElementTextWithWait(By.xpath("//div[23]/span[2]"));
							base.assertTrueByBoolean(money.contains("Ԫ"));
							String amount = money.substring(0,money.length()-1);
							base.assertTrueByBoolean(Integer.valueOf(amount)>=0);
						}else{
							base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div["+(19+i)+"]/span["+(j+1)+"]")), LoanInfos[i][j]);
						}	
					}
				}
			}else{
				System.out.println("�����ڵĽ�");
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
