package com.eloancn.shared.pages;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;

/*
 * ���ҵ��˻���-�����׼�¼��ҳ��
 */
public class TransactionRecordPage {
	
	Base base = new Base();
	DBData dbData = new DBData();
	
	//���׼�¼
	public static By TransactionRecordTxt = By.cssSelector("div.newtitle>h3");
	By availableBalance = By.cssSelector("#canBeUsedTotalMoney");                            //�������
	
	//ʱ�����
	By SearchBtn = By.cssSelector("input.time_submit");                                      //����ѯ����ť
	
	//����б�
	By NoRecordTxt = By.cssSelector("table.mt10.global_table.font14>tbody>tr");
	By tabList = By.cssSelector(".mt10.global_table.font14 > tbody > tr");                   //Tab�б�
	
	By recordsList = By.cssSelector(".mt10.global_table.font14");                            //���׼�¼�б�
	By IncomeMoney= By.xpath("//div[@id='_content']/div/div[3]/table/tbody/*/td[3]");        //��ǰҳ�����С������
	By SpentMoney = By.xpath("//div[@id='_content']/div/div[3]/table/tbody/*/td[4]");
	By BalanceMoney = By.xpath("//div[@id='_content']/div/div[3]/table/tbody/tr/td[5]");     //��ǰҳ�����С���
	By Description = By.xpath("//div[@id='_content']/div/div[3]/table/tbody/*/td[7]");
	
	By balanceRecords = By.cssSelector("tbody > .bgF1:nth-child(1) > td:nth-child(5)");      //��һ�����׼�¼�����
	By explainRecords = By.cssSelector("tbody > .bgF1:nth-child(1) > td:nth-child(7)");      //��һ�����׼�¼��˵��
	
	//��ҳ
	By SixPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");							 //ҳ���ĵ�6������
	By AllPaginationLnk = By.xpath("//div[@id='Pagination']/ul/li");						 //ҳ��
	By FirstPage = By.xpath("//div[@id='Pagination']/ul/li[text()='��ҳ']");
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");
	By LastPage = By.xpath("//div[@id='Pagination']/ul/li[text()='ĩҳ']");
	By LastOnePage = By.xpath("//div[@id='Pagination']/ul/li[text()='>']");
	By LastTwoPage = By.xpath("//div[@id='Pagination']/ul/li[last()-2]");
	
	
	public void inputSearchDate(String startdate,String enddate){
		base.setDate("startdate2", startdate);
		base.setDate("enddate2", enddate);
	}
	public void clickSearchBtn(){
		base.clickWithWait(SearchBtn);
		base.sleep(2000);
	}
	//��ý��׼�¼��ҳ��
	public int getRecordPagesNum(){
		if(base.getElementTextWithWait(NoRecordTxt).equals("���ʽ���ˮ��")){
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
	//��ȡ�ϸ��µ������ܶͶ���ܶ��ֵ�ܶ�
	public double[] checkMoney(){
		Calendar calendar = Calendar.getInstance();
		String begin,end;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		if(day>=1 && day<5){	
			begin = base.getLastMonthDate(-2);
			end = base.getLastMonthDay(-2);
		}else{
			begin = base.getLastMonthDate(-1);
			end = base.getLastMonthDay(-1);
		}
		inputSearchDate(begin,end);		
		clickSearchBtn();
		clickSearchBtn();
		int IncomeNum=0,SpentCreditNum=0,TransferCreditNum=0,SpentSBNum=0,RechargeNum=0,FeeNum=0;
		double Income=0,SpentCredit=0,TransferCredit=0,SpentSB=0,Recharge=0,Fee=0;
		int num = getRecordPagesNum();
		for(int i=1;i<=num;i++){
			List<WebElement> descriptions = base.getElements(Description);
			int size =	descriptions.size();	
			List<WebElement> incomes = base.getElements(IncomeMoney);
			List<WebElement> spent = base.getElements(SpentMoney);
			for(int j=0;j<size;j++){
				String des = descriptions.get(j).getText();
				String money1 = spent.get(j).getText();//10,025.15
				String money2 = incomes.get(j).getText();
				money1 = money1.replaceAll(",", "");
				money2 = money2.replaceAll(",", "");
				if(des.contains("������Ϊ:") && des.contains("��ծȨ")){
					SpentCreditNum=SpentCreditNum+1;
					SpentCredit= SpentCredit+Double.parseDouble(money1);//֧������ծȨ
				}else if(des.contains("����ծȨΪ:")&& des.contains("�Ķ����ʽ�")){
					SpentCreditNum = SpentCreditNum-1;
					SpentCredit = SpentCredit-Double.parseDouble(money2);
				}else if(des.contains("�ɹ�ת��*")&& des.contains("��ծȨ")){
					TransferCreditNum=TransferCreditNum+1;
					TransferCredit= TransferCredit+Double.parseDouble(money2);
				}else if(des.substring(0, 1).equals("��")&& des.substring(des.length()-2).equals("Ͷ��")){
					SpentSBNum=SpentSBNum+1;
					SpentSB= SpentSB+Double.parseDouble(money1);
				}else if(des.contains("�տ�:����")&& des.contains("�Ļ���")){
					IncomeNum= IncomeNum+1;
					Income = Income+Double.parseDouble(money2);
				}else if((des.contains("��")&& des.contains("Ͷ�����վ�����"))){
					FeeNum=FeeNum+1;
					Fee=Fee+Double.parseDouble(money1);
				}else if(des.contains("�Ƹ������(ϵͳ�չ�")&& des.contains("��ծȨ)")||(des.contains("ת��*")&& des.contains("��ծȨ�ɽ������"))){
					FeeNum=FeeNum+1;
					Fee=Fee+Double.parseDouble(money1);
				}else if(des.contains("��ֵ")){
					RechargeNum=RechargeNum+1;
					Recharge=Recharge+Double.parseDouble(money2);
				}
			}
			base.clickWithWait(LastOnePage);	
		}
		//������������������ծȨ����������ծȨ������ɢ�����������ɢ���ɢ��ծȨ�����ѱ�����ɢ��ծȨ�����ѽ���ֵ��������ֵ���,ծȨת�ñ�����ծȨת�ý��
		double amount[] = {IncomeNum,Income,SpentCreditNum,SpentCredit,SpentSBNum,SpentSB,FeeNum,Fee,RechargeNum,Recharge,TransferCreditNum,TransferCredit};
		return amount;
	}
	public double getManagementFee(){
		
		inputSearchDate("","");	
		clickSearchBtn();
		clickSearchBtn();
		double managefee=0;
		int num = getRecordPagesNum();
		for(int i=1;i<=num;i++){
			List<WebElement> descriptions = base.getElements(Description);
			int size =	descriptions.size();	
			List<WebElement> spent = base.getElements(SpentMoney);
			for(int j=0;j<size;j++){
				String des = descriptions.get(j).getText();
				String money1 = spent.get(j).getText().replaceAll(",", "");
				if((des.contains("��")&& des.contains("Ͷ�����վ�����"))){
					managefee=managefee+Double.parseDouble(money1);
				}	
			}	
			base.clickWithWait(LastOnePage);	
		}
		return managefee;
	}
	
	//��ȡ�ϸ��µ׵�ʣ��������
	public String checkRemainBalance(){
		String end;
		if(base.getCurrentDay()<5){
			end = base.getLastMonthDay(-2);
		}else{
			end = base.getLastMonthDay(-1);
		}
		inputSearchDate("",end);	
		clickSearchBtn();
		clickSearchBtn();
		String balance = base.getElementTextWithWait(BalanceMoney);
		return balance;
	}
	
	/**
	 * ��ȡ�������
	 * @return �������
	 * @author ������ 2015-10-23
	 */
	public String getAvailableBalance(){
		String availableBalanceStr;
		base.checkElement(availableBalance);
		availableBalanceStr = base.getElementText(availableBalance);
		availableBalanceStr = base.stringToReplace(availableBalanceStr,",","");
		return availableBalanceStr;
	}
	
	/**
	 * ��ȡTab��ֵ
	 * @param tabName Tab����
	 * @return Tab��ֵ
	 * @author ������ 2015-10-23
	 */
	private String getTabValue(String tabName){
		
		String num;
		switch (tabName) {
			case "ȫ��": num = "0";break;
			case "��ֵ": num = "1";break;
			case "�ſ�": num = "2";break;
			case "����": num = "3";break;
			case "ծȨ": num = "4";break;
			default: num = "0";break;
		}
		return num;
	}

	/**
	 * ��ȡTab����
	 * @param tabName Tab����
	 * @return Tab����
	 * @author ������ 2015-10-23
	 */
	public By getTab(String tabName){
		
		String num = getTabValue(tabName);
		By tab = By.cssSelector("#query_type_" + num);
		base.checkElement(tab);
		return tab;
	}
	
	/**
	 * У��Tab�Ƿ�ѡ��
	 * @param tabName Tab����
	 * @author ������ 2015-10-23
	 */
	public void checkIsClickTab(String tabName){
		
		String num = getTabValue(tabName);
		By tab = By.xpath("//li[span[a[@id='query_type_" + num + "']]]");
		base.checkElement(tab);
		boolean isTrue = base.isElementContainsValue(tab, "class", "all");
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
	}
	
	/**
	 * ���Tab
	 * @param tabName Tab����
	 * @author ������ 2015-10-23
	 */
	public void clickTab(String tabName){
		By by = getTab(tabName);
		base.clickWithWait(by);
		checkIsClickTab(tabName);
	}
	
	/**
	 * ��ȡ��������汦�Ĳ�Ʒ��Ϣ
	 * @param email
	 * @return ������껯�����ʣ���Լ���ޣ���Ϣʱ�䣬����ʱ��
	 * @author ������ 2015-10-23
	 */
	public HashMap<String, String> getRecordTable(String email){
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		String uid = dbData.getUID(email);
		hashMap = dbData.getD_wmps_recordTable(uid);
		return hashMap;
	}
	
	/**
	 * ������汦ÿ����Ϣ
	 * @param amount ������
	 * @param interestrate �껯������
	 * @return ÿ����Ϣ
	 * @author ������ 2015-10-23
	 */
	public String calculationInterest(String amount, String interestrate){
		
		String interest;
		double amountDou = Double.valueOf(amount);
		double interestrateDou = Double.valueOf(interestrate);
		interest = String.valueOf(base.setRound(amountDou * interestrateDou / 365, 2, true));
		return interest;
	}
	
	/**
	 * ��ȡ��������汦ÿ����Ϣ
	 * @param email �û�����
	 * @return ÿ����Ϣ
	 * @author ������ 2015-10-23
	 */
	public String getInterest(String email){
		
		String interest;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap = getRecordTable(email);
		String amount = hashMap.get("amount");//������
		String interestrate = hashMap.get("interestrate");//�껯������
		interest = calculationInterest(amount, interestrate);
		return interest;
	}
	
	/**
	 * ���㡰�ۼ����桱
	 * ��ע�� �ۼ����� = ��Ϣ * (��ǰ����-��Ϣʱ��)
	 * @param interest ��Ϣ
	 * @param interdate ��Ϣʱ��
	 * @return �ۼ�����
	 * @author ������ 2015-10-27
	 */
	public String calcCumulativeGain(String interest, String interdate){
		
		Double interestDou = Double.parseDouble(interest);
		long interDateLong = Long.parseLong(interdate) * 1000;//��Ϣʱ��
		long currentDataLong = base.getcurrentTimeMillis();   //��ǰ����
		long subLong = base.getDifferenceOfDate(currentDataLong, interDateLong);
		System.out.println("��ǰ���ڣ�" + currentDataLong);
		System.out.println("��Ϣ���ڣ�" + interDateLong);
		System.out.println("��ǰ�������Ϣ�������" + subLong + "��");
		String cumulative = (base.setRound((interestDou * subLong), 2, true)) + "";
		return cumulative;
	}

	/**
	 * ��ȡĳ�е�Ԫ��
	 * @param num �к�
	 * @return ��Ԫ��
	 * @author ������ 2015-12-1
	 */
	public By getRowValueInTabList(String num){
		By row = By.cssSelector("tbody > tr:nth-child(" + num +") td");
		base.checkElementVisible(row);
		return row;
	}
	
	/**
	 * ��ȡĳ�е�ֵ
	 * @param num �к�
	 * @return һ�е�����ֵ
	 * @author ������ 2015-12-1
	 */
	public List<String> getColumnValueInRow(String num){
		List<WebElement> tdList = new ArrayList<WebElement>();
		List<String> list = new ArrayList<String>();
		
		By rowValue = getRowValueInTabList(num);
		tdList = base.getElements(rowValue);
		int size = tdList.size();
		for(int i = 0; i < size; i++){
			list.add(tdList.get(i).getText());
		}
		return list;
	}
	
	/**
	 * ���һ����ĳ�е�ֵ�Ƿ�һ��
	 * @param list ĳ�е�ֵ
	 * @param columnName ����
	 * @param columnValue ��ֵ
	 * @author ������
	 */
	public void checkColumnValueInRow(List<String> list, String columnName, String columnValue){
		int columnNum;
		columnNum = getColumnNumInTabList(columnName);
		base.assertEqualsActualExpected(list.get(columnNum), columnValue);
	}
	
	/**
	 * ��ȡĳ�е�ֵ
	 * @param columnName ����
	 * @return ĳ�е�ֵ
	 * @author ������ 2015-10-23
	 */
	private int getColumnNumInTabList(String columnName){
		
		int columnNum;
		switch (columnName) {
		case "���":
			columnNum = 0;break;
		case "��ˮ��":  
			columnNum = 1;break;
		case "������": 
			columnNum = 2;break;
		case "֧�����": 
			columnNum = 3;break;
		case "���":    
			columnNum = 4;break;
		case "����ʱ��":  
			columnNum = 5;break;
		case "˵��":    
			columnNum = 6;break;
		default:
			columnNum = 0;break;
		}
		return columnNum;
	}
	
	/**
	 * ��ȡ���׼�¼�б�ҳ��ĳ�е�ֵ
	 * @param columnName ����
	 * @return ĳ�еļ���
	 * @author ������ 2015-10-23
	 */
	public List<String> getColumnValueInTabList(String columnName){
		
		List<WebElement> trList = new ArrayList<WebElement>();
		List<WebElement> tdList = new ArrayList<WebElement>();
		List<String> list = new ArrayList<String>();
		
		int num = getColumnNumInTabList(columnName);
		
		trList = base.getElements(tabList);
		for(int i = 0; i < trList.size(); i++){
			tdList = trList.get(i).findElements(By.tagName("td"));
			for(int j = 0; j < tdList.size(); j++){
				if(num == j){
					list.add(tdList.get(j).getText());
					continue;
				}
			}
		}
		return list;
	}
	
	/**
	 * У�齻�׼�¼�б�ҳ��ĳ�е�ֵ
	 * @param email �û�����
	 * @param columnName ����
	 * @author ������ 2015-10-23
	 */
	public void checkColumnValueInTabList(String email, String columnName){
		
		List<String> list = new ArrayList<String>();
		list = getColumnValueInTabList(columnName);
		String interest = getInterest(email);//��Ϣ
		String Balance = interest;//���
		
		if(columnName.equals("������")){
			for (String listValue : list) {
				base.assertEqualsActualExpected(listValue, interest);
			}
		}
		else if(columnName.equals("֧�����")){
			for (String listValue : list) {
				base.assertEqualsActualExpected(listValue, "0");
			}
		}
		else if(columnName.equals("���")){
			Collections.reverse(list);//����
			int length = list.size();
			for(int i = 0; i < length; i++){
				base.assertEqualsActualExpected(list.get(i), Balance);//У��ÿ������Ƿ���ȷ
				if(i == length - 1){
					break;
				}
				else{
					Balance = (Float.valueOf(Balance) + Float.valueOf(interest)) + "";
				}
			}
			Balance = (Float.valueOf(Balance) + 9900) + "";
			//У�顰�������뽻�׼�¼�С����Ƿ�һ��
			base.assertEqualsActualExpected(Balance, getAvailableBalance());
		}
	}
}
