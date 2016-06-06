package com.eloancn.suites.index;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.pages.IndexPage;


/*
 * ����ҳ�����������-������
 */
public class IncomeCalculator {

	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * �������ƣ����������
	 * ������ţ�SY_004
	 * @author ������
	 */
	@Test
	public void checkIncomeCalculator_AT_588(){
		Reporter.log("��ҳ���������������>������������������ť����>1.У�鵯�����ڣ�2.����������ʾ�������й������������鿴����");
		//Ͷ�ʽ��
		String InvestmentMoney = "1000";
		//������
		String annualInterestRate = "20";
		//Ͷ������
		String investmentPeriod = "24";
		//���ʽ
		String repaymentDrop = "������Ϣ";
		
		//������������������ť
		indexPage.clickIncomeCalculatorBtn();
		//У�鵯������
		base.assertNotNullBy(By.xpath("//div[@class='count-tit']//h3"));
		//���롰Ͷ�ʽ�
		indexPage.sendKeyInvestmentMoneyTxt(InvestmentMoney);
		//���롰�����ʡ�
		indexPage.sendKeyAnnualInterestRateTxt(annualInterestRate);
		//���롰Ͷ�����ޡ�
		indexPage.sendKeyInvestmentPeriodTxt(investmentPeriod);
		//ѡ�񡰻��ʽ��
		base.elementSelectByVisibleText(By.xpath("//select[@name='type']"), repaymentDrop);
		//��ѡ����ʾ�ƻ�ʱ���
		indexPage.clickShowScheduleChk();
		//��������ϼ��㡱��ť
		indexPage.clickImmediatelyCalculateBtn();
		base.sleep(1000);
		//�϶�������
		base.setDivScrollById("tiemst", 10000);
		base.sleep(2000);
		//������һ������
		base.assertEqualsActualExpectedByBoolean(indexPage.checkReceivablesListData(InvestmentMoney, annualInterestRate, investmentPeriod, repaymentDrop), true);
	}
}
