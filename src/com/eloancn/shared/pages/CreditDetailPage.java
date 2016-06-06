package com.eloancn.shared.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.eloancn.shared.common.Base;

/*
 * ծȨת������ҳ
 */
public class CreditDetailPage {
	
	Base base = new Base();
	
	public static By DetailPart = By.cssSelector("div.wd660.fl.pdt20.pdl20");
	public static By CreditTitleinDetail = By.cssSelector("span.color06");			//�������ҳ�ı���
	public static By NextRepayDate = By.cssSelector("span.color8");					//�¸�������
	public static By LoanInfoTxt = By.xpath("//h2");								//���ſ�
//	public static By MoreDetailLnk = By.xpath("//a[text()='��������>>']");			//��������
	public static By MoreDetailLnk = By.cssSelector(".h30.lineh30.textR.font12.mr20>a");		
	public static By Record = By.cssSelector("span.current");						//���ļ�¼
//	public static By DebtPayDetail = By.xpath("//div[2]/span[2]");					//ծȨ�տ�����
	public static By DebtPayDetail = By.cssSelector(".records.bgFF.clear.mt20>span:nth-child(2)");
	public static By ConsultRecordTxt = By.cssSelector("h3 > span");				//��ѯ��¼
	public static By PostMessageBtn = By.cssSelector("a.ask");						//��������
	
	public static By WaitPrincipalTxt = By.xpath("//li/p");
	public static By InterestRateTxt = By.cssSelector("p.clear > span.colorE6.font20");
	public static By RemainDateTxt = By.xpath("//p[3]/span");
	public static By TransferModeTxt = By.xpath("//p/i");
	public static By BuyNowBtn = By.xpath("//li[@class='fl wd213 mt20 mb20']/p[2]/input");
	
	public boolean ifinDetailPage(){
		return base.isElementPresent(CreditTitleinDetail);
	}
	
	//�޸� ���ɻ�����У������ ������ 2015-7-17
	public void verifyCreditDetail(){
		try{
			base.getElementText(NextRepayDate).contains("�¸�������");
			base.assertEqualsActualExpected("���ſ�", base.getElementText(LoanInfoTxt));
			
			if(!base.indexURL.contains("/client") || !base.indexURL.contains("inclient")){
				base.assertTrueBy(MoreDetailLnk);
				base.assertEqualsActualExpected("ծȨ�տ�����",base.getElementText(DebtPayDetail));
			}
			base.assertEqualsActualExpected("���ļ�¼",base.getElementText(Record));
			base.assertEqualsActualExpected("��ѯ��¼",base.getElementText(ConsultRecordTxt));
			base.closeAndjumptoOldWindow();
		}catch(Exception e){
			base.closeAndjumptoOldWindow();
			Assert.fail(e.toString());
		}
	}	
}
