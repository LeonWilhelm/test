package com.eloancn.suites.credit;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.pages.EStarPlanListPage;
/**
 * ���Ǽƻ�P2_2 
 * @author ����Ԫ
 */
public class EStarPlan_P2_2 {
	Base base = new Base();
	EStarPlanListPage eStarPlanListPage = new EStarPlanListPage();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/*****************************���������*****************************/
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * ��Ϣʱ��,�����Ϣʱ��,У�鵯��������
	 */
	@Test(priority = 1)
	public void showDateWindow_web_516(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������-��Ϣʱ��,�����Ϣʱ��,У�鵯��������<br/>");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//�����Ϣʱ��
		eStarPlanListPage.clickDate();
		//У�鵯��������
		eStarPlanListPage.showDate();
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * Ͷ�ʽ��,���룺10000�����֣�,û�д�����ʾ
	 */
	@Test(priority = 2)
	public void inputRriteMoney_web_517_1(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������--Ͷ�ʽ��,���룺10000�����֣�,û�д�����ʾ<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//������10000
		eStarPlanListPage.inputMoney("10000");
		//��������
		eStarPlanListPage.inputLoanRate("11");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases("1");
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//У������������������ݣ�����ʾ����ʾ������
		eStarPlanListPage.isCalculateNoAlert();
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * Ͷ�ʽ��,���룺6541dddd,��ʾ��Ͷ�ʽ���ȷ��
	 */
	@Test(priority = 3)
	public void inputWrongMoney_web_517_2(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������--Ͷ�ʽ��,���룺6541dddd,��ʾ��Ͷ�ʽ���ȷ��<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//������10000
		eStarPlanListPage.inputMoney("6541dddd");
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//У����ʾ��Ͷ�ʽ���ȷ��
		base.checkAlertText("Ͷ�ʽ���ȷ��");
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * Ͷ������,���룺1���£���Сֵ��,û�д�����ʾ
	 */
	@Test(priority = 4)
	public void inputLoanPhases_web_519_1(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������--Ͷ������,���룺1���£���Сֵ��,û�д�����ʾ<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//������10000
		eStarPlanListPage.inputMoney("10000");
		//��������
		eStarPlanListPage.inputLoanRate("11");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases("1");
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//У������������������ݣ�����ʾ����ʾ������
		eStarPlanListPage.isCalculateNoAlert();
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * Ͷ������,���룺12���£��м�ֵ��,û�д�����ʾ
	 */
	@Test(priority = 5)
	public void inputLoanPhases_web_519_2(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������--Ͷ������,���룺12���£��м�ֵ��,û�д�����ʾ<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//������10000
		eStarPlanListPage.inputMoney("10000");
		//��������
		eStarPlanListPage.inputLoanRate("11");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases("12");
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//У������������������ݣ�����ʾ����ʾ������
		eStarPlanListPage.isCalculateNoAlert();
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * Ͷ������,���룺24����,û�д�����ʾ
	 */
	@Test(priority = 6)
	public void inputLoanPhases_web_519_3(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������--Ͷ������,���룺12���£��м�ֵ��,û�д�����ʾ<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//������10000
		eStarPlanListPage.inputMoney("10000");
		//��������
		eStarPlanListPage.inputLoanRate("11");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases("24");
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//У������������������ݣ�����ʾ����ʾ������
		eStarPlanListPage.isCalculateNoAlert();
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * Ͷ������,���룺3.5���£���������,��ʾ��������޲���ȷ��
	 */
	@Test(priority = 7)
	public void inputLoanPhases_web_519_4(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������--Ͷ������,���룺3.5���£���������,��ʾ��������޲���ȷ��<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//������10000
		eStarPlanListPage.inputMoney("10000");
		//��������
		eStarPlanListPage.inputLoanRate("11");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases("3.5");
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//��ʾ��������޲���ȷ��
		base.checkAlertText("������޲���ȷ��");
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * Ͷ������,���룺0����,��ʾ��������޲���ȷ��
	 */
	@Test(priority = 8)
	public void inputLoanPhases_web_519_5(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������--Ͷ������,���룺0����,��ʾ��������޲���ȷ��<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//������10000
		eStarPlanListPage.inputMoney("10000");
		//��������
		eStarPlanListPage.inputLoanRate("11");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases("0");
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//��ʾ��������޲���ȷ��
		base.checkAlertText("������޲���ȷ��");
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * Ͷ������,���룺25����,��ʾ���������Ӧ��1-24����֮�䣬��������д��
	 */
	@Test(priority = 9)
	public void inputLoanPhases_web_519_6(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������--Ͷ������,���룺25����,��ʾ���������Ӧ��1-24����֮�䣬��������д��<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//������10000
		eStarPlanListPage.inputMoney("10000");
		//��������
		eStarPlanListPage.inputLoanRate("11");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases("25");
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//��ʾ��������޲���ȷ��
		base.checkAlertText("�������Ӧ��1-24����֮�䣬��������д��");
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * Ͷ������,���룺fffd#(�����ַ�),��ʾ��������޲���ȷ��
	 */
	@Test(priority = 10)
	public void inputLoanPhases_web_519_7(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������--Ͷ������,���룺fffd#(�����ַ�),��ʾ��������޲���ȷ��<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//������10000
		eStarPlanListPage.inputMoney("10000");
		//��������
		eStarPlanListPage.inputLoanRate("11");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases("fffd#");
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//��ʾ��������޲���ȷ��
		base.checkAlertText("������޲���ȷ��");
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * �鿴�����ʽ����ʾ��Ĭ�ϣ�������Ϣ
	 */
	@Test(priority = 11)
	public void inputLoanPhases_web_527(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--������������鿴�����ʽ����ʾ��Ĭ�ϣ�������Ϣ<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//У��鿴�����ʽ����ʾ��Ĭ�ϣ�������Ϣ
		base.isElementContainsValue(By.cssSelector(".count-txt.wd70.ml5"),"value","������Ϣ");
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * ��ʾ�ƻ�ʱ�������ϼ��㰴ť����ѡ��ʾ�ƻ�ʱ���������ϼ��㰴ť���տ��ܶ����Ϣ
	 */
	@Test(priority = 12)
	public void inputLoanPhases_web_529_1(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--�������������ʾ�ƻ�ʱ�������ϼ��㰴ť����ѡ��ʾ�ƻ�ʱ���������ϼ��㰴ť���տ��ܶ����Ϣ,У���տ��ܶ� ����Ϣ�������ʾ�տ�ʱ���  <br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//��������������ļ�Ϣʱ��
		eStarPlanListPage.inputDate("2015-01-01");
		//������10000
		eStarPlanListPage.inputMoney("10000");
		//��������
		eStarPlanListPage.inputLoanRate("15");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases("3");
		//�����ʾ�տ�ʱ���
		eStarPlanListPage.clickDateList();
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//У���������ȷ   �տ��ܶ�  ��Ϣ  
		eStarPlanListPage.isCalculateOK(10000,15,3);
		//У�� У����ʾ�տ�ʱ���
		eStarPlanListPage.isShowDateList();
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * ��ʾ�ƻ�ʱ�������ϼ��㰴ť������ѡ��ʾ�ƻ�ʱ���������ϼ��㰴ť���տ��ܶ����Ϣ
	 */
	@Test(priority = 13)
	public void inputLoanPhases_web_529_2(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--�������������ʾ�ƻ�ʱ�������ϼ��㰴ť������ѡ��ʾ�ƻ�ʱ���������ϼ��㰴ť���տ��ܶ����Ϣ,У���տ��ܶ� ����Ϣ���<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//��������������ļ�Ϣʱ��
		eStarPlanListPage.inputDate("2015-01-01");
		//������10000
		eStarPlanListPage.inputMoney("10000");
		//��������
		eStarPlanListPage.inputLoanRate("15");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases("3");
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//У���������ȷ   �տ��ܶ�  ��Ϣ
		eStarPlanListPage.isCalculateOK(10000,15,3);
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * �տ�ʱ���
	 */
	@Test(priority = 14)
	public void checkDateList_web_947_1(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--�����������У���տ�ʱ�����ȷ<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		String date = "2015-2-5";//����ʱ��
		double money = 10000;//Ͷ�ʽ��
		double rate = 15;//����
		int phases = 3;//����
		Reporter.log("�����Ϣʱ�䣺"+date+"��Ͷ�ʽ�"+money+"�����ʣ�"+rate+"�����ޣ�"+phases);
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//��������������ļ�Ϣʱ��
		eStarPlanListPage.inputDate(date);
		//������10000
		eStarPlanListPage.inputMoney(money+"");
		//��������
		eStarPlanListPage.inputLoanRate(rate+"");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases(phases+"");
		//�����ʾ�տ�ʱ���
		eStarPlanListPage.clickDateList();
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//У���������ȷ   �տ��ܶ�  ��Ϣ
		eStarPlanListPage.isCalculateOK(money,rate,phases);
		//У�� У����ʾ�տ�ʱ���
		eStarPlanListPage.isShowDateList();
		//У���տ�ʱ�����������
		eStarPlanListPage.isDateListOK(date,money,rate,phases);
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * �տ�ʱ���
	 */
	@Test(priority = 15)
	public void checkDateList_web_947_2(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--�����������У���տ�ʱ�����ȷ<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		String date = "2015-2-21";//����ʱ��
		double money = 10000;//Ͷ�ʽ��
		double rate = 15;//����
		int phases = 3;//����
		Reporter.log("�����Ϣʱ�䣺"+date+"��Ͷ�ʽ�"+money+"�����ʣ�"+rate+"�����ޣ�"+phases);
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//��������������ļ�Ϣʱ��
		eStarPlanListPage.inputDate(date);
		//������10000
		eStarPlanListPage.inputMoney(money+"");
		//��������
		eStarPlanListPage.inputLoanRate(rate+"");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases(phases+"");
		//�����ʾ�տ�ʱ���
		eStarPlanListPage.clickDateList();
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//У���������ȷ   �տ��ܶ�  ��Ϣ
		eStarPlanListPage.isCalculateOK(money,rate,phases);
		//У�� У����ʾ�տ�ʱ���
		eStarPlanListPage.isShowDateList();
		//У���տ�ʱ�����������
		eStarPlanListPage.isDateListOK(date,money,rate,phases);
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * �տ�ʱ���
	 */
	@Test(priority = 16)
	public void checkDateList_web_947_3(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--�����������У���տ�ʱ�����ȷ<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		String date = "2016-2-25";//����ʱ��
		double money = 10000;//Ͷ�ʽ��
		double rate = 15;//����
		int phases = 3;//����
		Reporter.log("�����Ϣʱ�䣺"+date+"��Ͷ�ʽ�"+money+"�����ʣ�"+rate+"�����ޣ�"+phases);
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//��������������ļ�Ϣʱ��
		eStarPlanListPage.inputDate(date);
		//������10000
		eStarPlanListPage.inputMoney(money+"");
		//��������
		eStarPlanListPage.inputLoanRate(rate+"");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases(phases+"");
		//�����ʾ�տ�ʱ���
		eStarPlanListPage.clickDateList();
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//У���������ȷ   �տ��ܶ�  ��Ϣ
		eStarPlanListPage.isCalculateOK(money,rate,phases);
		//У�� У����ʾ�տ�ʱ���
		eStarPlanListPage.isShowDateList();
		//У���տ�ʱ�����������
		eStarPlanListPage.isDateListOK(date,money,rate,phases);
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--���������
	 * �տ�ʱ���
	 */
	@Test(priority = 17)
	public void checkDateList_web_947_4(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--�����������У���տ�ʱ�����ȷ<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		String date = "2016-2-28";//����ʱ��
		double money = 10000;//Ͷ�ʽ��
		double rate = 15;//����
		int phases = 3;//����
		Reporter.log("�����Ϣʱ�䣺"+date+"��Ͷ�ʽ�"+money+"�����ʣ�"+rate+"�����ޣ�"+phases);
		//������������
		eStarPlanListPage.clickIncomeCalculatorLnk();
		//��������������ļ�Ϣʱ��
		eStarPlanListPage.inputDate(date);
		//������10000
		eStarPlanListPage.inputMoney(money+"");
		//��������
		eStarPlanListPage.inputLoanRate(rate+"");
		//����Ͷ������
		eStarPlanListPage.inputLoanPhases(phases+"");
		//�����ʾ�տ�ʱ���
		eStarPlanListPage.clickDateList();
		//������ϼ���
		eStarPlanListPage.clickCalculate();
		//У���������ȷ   �տ��ܶ�  ��Ϣ
		eStarPlanListPage.isCalculateOK(money,rate,phases);
		//У�� У����ʾ�տ�ʱ���
		eStarPlanListPage.isShowDateList();
		//У���տ�ʱ�����������
		eStarPlanListPage.isDateListOK(date,money,rate,phases);
		//�ر����������
		eStarPlanListPage.clickCloseCalculatorBtn();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--��Ʒ����--��Ʒ������
	 * ״̬ͼ׼ȷ�ԡ��ƻ��ܶ�=������+������+������ļ���ܶʣ��������ȷ��
	 */
	@Test(priority = 18)
	public void checkDataOfEStarList_web_335_337_342(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--��Ʒ����--��Ʒ�����飬״̬ͼ׼ȷ�ԡ��ƻ��ܶ�=������+������+������ļ���ܶʣ��������ȷ��<br/>");
		//base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		eStarPlanListPage.isDataOfEStarListOK();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--��Ʒ����--��Ʒ������
	 * �������Ʒ���⡱����,��ת��Ͷ���б�����ҳ��,��飺��Ʒ�����Ϣ��Ͷ���б���һ�£�״̬�����ȣ�Ͷ�ʰ�ť���ƻ��ܶ�ȣ�
	 */
	@Test(priority = 19)
	public void checkLinkAndDetailData_web_340(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--��Ʒ����--��Ʒ�����飬�������Ʒ���⡱����,��ת��Ͷ���б�����ҳ��,��飺��Ʒ�����Ϣ��Ͷ���б���һ�£�״̬�����ȣ�Ͷ�ʰ�ť���ƻ��ܶ�ȣ�<br/>");
		base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		eStarPlanListPage.isLinkAndDetailDataOK();
	}
	
	/**
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--��Ʒ����--����������
	 * ��֤���㷽ʽ��ʾ��ȷ��,������Ϣ
	 */
	@Test(priority = 20)
	public void checkBaoZhanStarData_web_343(){
		Reporter.log("ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--��Ʒ����--���������飬��֤���㷽ʽ��ʾ��ȷ��,������Ϣ<br/>");
		base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		eStarPlanListPage.idBaoZhangStarDataOK();
	}
}
