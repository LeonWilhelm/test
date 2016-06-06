package com.eloancn.shared.pages;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.PageTitles;

/*
 * ���ҵ��˻���-����汦��ҳ��
 */
public class YCBPage {
	
	Base base = new Base();
	ElectronicIOU electronicIOU = new ElectronicIOU();
	
	//��汦
	public static By YCBTxt = By.cssSelector("h1.f-fc333");				 //��汦����
	By eCunBaoName = By.cssSelector(".pdb8");							 //����汦������ơ����������ձ��𡢴�����Ϣ����׬��Ϣ����������Ϣ��
	By eCunBaoData = By.cssSelector(".cont.f-cb  span");           		 //����汦������ݡ����������ձ��𡢴�����Ϣ����׬��Ϣ����������Ϣ�����ձ�����
	By waitPrincipalNumByECB = By.cssSelector("#dueingPrincipal"); 		 //�����ձ���
	By waitInterestNumByECB = By.cssSelector("#daishoulixi");      	 	 //��������Ϣ��
	By waitEachNumByECB = By.cssSelector("#dueingNum");            	 	 //�����ձ�����
	By interestEarnedByECB = By.cssSelector("#loanSumInter");			 //����׬��Ϣ��
	By yesterdayTotalIncomeByECB  = By.cssSelector("#strYesterdayInter");//����������Ϣ��
	By investmentECunBao = By.cssSelector(".lineh24>a");            	 //��ȥͶ����汦��
	
	/******************************/
	/******    ��汦_ծȨ����           ******/
	/******************************/
	
	By eCBBondDetailsDIV = By.cssSelector("#messageBoxCard");									//ծȨ����_����
	By eCBBondDetailsDIVTitle = By.cssSelector("#saveTitle");									//ծȨ����_����_Title
	By eCBBondDetailsDIVColumnName = By.cssSelector("#detailstable>thead>tr>th");				//ծȨ����_����_����(�����������⡢��������������֤�š�����˵���������ܶ����)
	By eCBBondDetailsDIVInfo = By.cssSelector("#tenderBody .font14.color6>td");					//ծȨ����_����_��Ϣ(�����������⡢��������������֤�š�����˵���������ܶ�)
	By eCBBondDetailsDIVBtn = By.cssSelector(".xqbtn");											//ծȨ����_����_���С��鿴���顱��ť
	By eCBBondDetailsSeeDIV = By.cssSelector("#xq_content");									//ծȨ����_����_�鿴����_����
	By eCBBondDetailsDIVTab = By.cssSelector(".xq_content_t");									//ծȨ����_����_�鿴����_����Tab��ť
	By eCBBondDetailsDIVClose = By.cssSelector(".tip_close");									//ծȨ����_����_�鿴����_�رհ�ť

	//ÿ������
	By detailTxt = By.cssSelector("#xiangQing");										  //ÿ��������ϸ
	
	//������
//	By partakeTxt = By.cssSelector("#canYuZhong");                                        //������
	By partakeTxt = By.xpath("//span[@id='canYuZhong']");
	By investTotalEachNumsByPartake = By.cssSelector("table>tbody>tr>td:nth-child(2)");   //�������С������С�Ͷ���ܱ�����
	By joinTotalMoneysByPartake = By.cssSelector("table>tbody>tr>td:nth-child(3)");       //�������С������С������ܽ�
	By expectTotalMoneysByPartake = By.cssSelector("table>tbody>tr>td:nth-child(4)");     //�������С������С�Ԥ�������桱
	By haveTotalMoneysByPartake = By.cssSelector("table>tbody>tr>td:nth-child(5)");       //�������С������С��ѻ������桱
	By financeAgreementLink = By.xpath("//a[text()='���Э��']"); 							  //�������С�����>������������>�����Э�顱
	By creditorDetailsLink = By.xpath("//a[text()='ծȨ����']"); 							  //�������С�����>������������>��ծȨ���顱
	By creditorDetailsDiv = By.cssSelector("#messageBoxCard");							  //�������С�����>������������>��ծȨ���顱����>��ծȨ�����б�
	
	//�ѽ���
	By settleTxt = By.cssSelector("#yiJieQing");										   //�ѽ���
	
	/****************************�ۺ�******************************/
	
	/**
	 * ��ȡҳ�水ťԪ��
	 * @param pageName ��ť����
	 * @return ��ťԪ��
	 * @author ������ 2015-11-9
	 */
	public By getPageNum(String pageName){
		
		By by = null;
		if(pageName.equals("��ҳ")){
			by = By.xpath("//div[@id='Pagination']/ul/li[text()='��ҳ']");
		}
		else if(pageName.equals("��һҳ")){
			by = By.xpath("//div[@id='Pagination']/ul/li[text()='<']");
		}
		else if(pageName.equals("��һҳ")){
			by = By.xpath("//div[@id='Pagination']/ul/li[text()='>']");
		}
		else if(pageName.equals("ĩҳ")){
			by = By.xpath("//div[@id='Pagination']/ul/li[text()='ĩҳ']");
		}
		else{
			by = By.xpath("//div[@id='Pagination']/ul/li[text()='" + pageName + "']");
		}
		base.checkVisible(by);
		return by;
	}
	
	/**
	 * ��תҳ�水ť�Ƿ����
	 * @param pageName ��ť����
	 * @return �Ƿ���ã�true:���ã�false�������ã�
	 * @author ������ 2015-11-9
	 */
	public boolean isAvailableByPageNum(String pageName){
		
		boolean isShow = false;
		By by = getPageNum(pageName);
		isShow = !(base.isElementContainsValue(by, "class", "pgEmpty"));
		return isShow;
	}
	
	/**
	 * �����תҳ�水ť
	 * @param pageName ��ť����
	 * @author ������ 2015-11-9
	 */
	public void chickPageNum(String pageName){
		
		By by = getPageNum(pageName);
		base.clickElementNoWait(by);
	}
	
	/****************************��汦******************************/
	
	/**
	 * ��ȡ��汦ĳ����Ϣ��ֵ�����磺���ձ��𡢴�����Ϣ�����ձ�����
	 * @param infoName����Ϣ����
	 * @return ��Ϣ��ֵ
	 * @author ������ 2015-10-8
	 */
	public String getECunBaoInfoData(String infoName){
		
		By by = null;
		String value;
		if(infoName.equals("���ձ���")){
			by = waitPrincipalNumByECB;
		}
		else if(infoName.equals("������Ϣ")){
			by = waitInterestNumByECB;
		}
		else if(infoName.equals("���ձ���")){
			by = waitEachNumByECB;
		}
		else if(infoName.equals("��׬��Ϣ")){
			by = interestEarnedByECB;
		}
		else if(infoName.equals("��������Ϣ")){
			by = yesterdayTotalIncomeByECB;
		}
		value = base.getElementTextWithWait(by);
		value = base.stringToReplace(value, ",", "");
		return value;
	}
	
	/**
	 * ��ȡ��汦�����Ϣֵ�ļ���
	 * ��ע���������ձ��𡢴�����Ϣ�����ձ�������׬��Ϣ����������Ϣ
	 * @return ֵ�ļ���
	 */
	public String[] getECunBaoInfoData(){
		String info[] = new String[5];
		List<WebElement> listWeb =  base.getElements(eCunBaoData);
		int listWebLength = listWeb.size();
		for (int i = 0; i < listWebLength; i++) {
			info[i]= listWeb.get(i).getText();
		}		
		return info;
	}
	
	/**
	 * �ҵ��˻�->��汦->У����汦���������Ƿ���ȷ
	 * @author ������ 2016-1-6
	 */
	public void checkECunBaoInfoName(){
		
		String[] name = {"���ձ���","������Ϣ","��׬��Ϣ","��������Ϣ"}; 
		List<WebElement> listWeb = new ArrayList<WebElement>();
		listWeb = base.getVisibleElements(eCunBaoName);
		for(int i = 0; i < listWeb.size(); i++){
			base.assertEqualsActualExpected(listWeb.get(i).getText(), name[i]);
		}
	}
	
	
	/*******************************************/
	/**************   ÿ��������ϸ      ****************/
	/*******************************************/
	
	/**
	 * �����ÿ��������ϸ��
	 * @author ������ 2016-1-6
	 */
	public void clickDetail(){
		base.clickWithWait(detailTxt);
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(detailTxt, "class", "current"), true);
		checkDetailColumnName();
		base.isTitle(PageTitles.woDeZhangHu);
	}
	
	/**
	 * �ҵ��˻�->��汦->У�顰ÿ��������ϸ�������Ƿ���ȷ
	 * @author ������ 2016-1-6
	 */
	public void checkDetailColumnName(){
		
		String[] name = {"��Ϣʱ��", "����������", "����"};
		List<WebElement> listWeb = new ArrayList<WebElement>();
		By by = By.cssSelector("#_content_child div.global_table.mt10>table th");
		listWeb = base.getVisibleElements(by);
		for(int i = 0; i < listWeb.size(); i++){
			base.assertEqualsActualExpected(listWeb.get(i).getText(), name[i]);
		}
	}
	
	/*******************************************/
	/**************     �ѽ���            ****************/
	/*******************************************/
	
	/**
	 * ������ѽ��塱
	 * @author ������ 2016-1-6
	 */
	public void clickSettle(){
		base.clickWithWait(settleTxt);
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(settleTxt, "class", "current"), true);
		checkSettleColumnName();
		base.isTitle(PageTitles.woDeZhangHu);
	}
	
	/**
	 * �ҵ��˻�->��汦->У�顰�ѽ��塱�����Ƿ���ȷ
	 * @author ������ 2016-1-6
	 */
	public void checkSettleColumnName(){
		
		String[] name = {"��Լ����", "Ͷ���ܱ���", "�����ܽ��", "�ѻ�������", "����"};
		List<WebElement> listWeb = new ArrayList<WebElement>();
		By by = By.cssSelector(".global_table.mt10>table>thead>tr>th");
		listWeb = base.getVisibleElements(by);
		for(int i = 0; i < listWeb.size(); i++){
			base.assertEqualsActualExpected(listWeb.get(i).getText(), name[i]);
		}
	}
	
	/*******************************************/
	/****************   ������      ******************/
	/*******************************************/
	
	/**
	 * ����������С�
	 * @author ������ 2016-1-6
	 */
	public void clickPartake(){
		int count = 0;
		base.clickWithWait(partakeTxt);
		base.clickWithWait(detailTxt);
		base.clickWithWait(partakeTxt);
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(partakeTxt, "class", "current"), true);
//		do{
//			if(base.isElementVisible(By.xpath("//th[text()='��Լ����']"))){
//				break;
//			}
//			else{
//				base.clickWithWait(detailTxt);
//				base.clickWithWait(partakeTxt);
//				count++;
//			}
//		}while(count < 3);
		checkPartakeColumnName();
		base.isTitle(PageTitles.woDeZhangHu);
	}
	
	/**
	 * �ҵ��˻�->��汦->У�顰�����С������Ƿ���ȷ
	 * @author ������ 2016-1-6
	 */
	public void checkPartakeColumnName(){
		
		String[] name = {"��Լ����", "Ͷ���ܱ���", "�����ܽ��", "Ԥ��������", "�ѻ�������", "����"};
		List<WebElement> listWeb = new ArrayList<WebElement>();
		By by = By.cssSelector(".global_table.mt10>table>thead>tr>th");
		listWeb = base.getVisibleElements(by);
		for(int i = 0; i < listWeb.size(); i++){
			base.assertEqualsActualExpected(listWeb.get(i).getText(), name[i]);
		}
	}
	
	/**
	 * У�顰�����С��Ƿ�ɼ�
	 * @author ������
	 */
	public void checkPartake(){
		base.assertEqualsActualExpectedByBoolean(base.checkVisible(By.cssSelector("#_content_child")), true);
	}
	
	/**
	 * �ҵ��˻�->��汦->�����У����ݡ���Լ���ޡ���ȡ���е�ֵ�����磺��Լ���ޡ�Ͷ���ܱ����������ܽ�Ԥ�������桢�ѻ������棩
	 * @param limit ��Լ����
	 * @param columnName ��ֵ
	 * @return ��Ӧֵ
	 * @author ������ 2016-1-4
	 */
	public String getPartakeValue(String limit, String columnName){
		
		String num = "";
		String columnValue = "";
		switch (columnName) {
		case "��Լ����":	num = "1";break;
		case "Ͷ���ܱ���":	num = "2";break;
		case "�����ܽ��":	num = "3";break;
		case "Ԥ��������":	num = "4";break;
		case "�ѻ�������":	num = "5";break;
		default:		num = "1";break;
		}
		By by = By.cssSelector("#phasestypetr" + limit + " td:nth-child(" + num + ")");
		try {
			columnValue = base.getElementTextWithVisible(by);
		} catch (Exception e) {
			columnValue = "0";
		}
		return columnValue;
	}
	
	/**
	 * ��ʽ����Ͷ���ܱ����������磺11��->11��
	 * @param str ��Ͷ���ܱ�����
	 * @return ��ʽ����ġ�Ͷ���ܱ�����
	 * @author ������ 2016-1-5
	 */
	public String formatInvestSum(String str){
		
		if(str.indexOf("��") != -1){
			str = str.substring(0, str.indexOf("��"));
		}
		return str;
	}
	
	/**
	 * ��ȡ�������С�����ĳ��֮��
	 * @param columnName������
	 * @return ĳ��֮��
	 * @author ������ 2015-10-9
	 */
	public double getColumnSumByPartake(String columnName){
		double totalNum = 0;
		String temp;
		List<WebElement> list = new ArrayList<WebElement>();
		if(columnName.equals("Ͷ���ܱ���")){
			list = base.getElements(investTotalEachNumsByPartake);
			for (WebElement webElement : list) {
				temp = webElement.getText();
				temp = temp.substring(0, temp.length()-1);
				totalNum = base.add(totalNum, Double.parseDouble(temp));
			}
		}
		else if(columnName.equals("�����ܽ��")){
			list = base.getElements(joinTotalMoneysByPartake);
			for (WebElement webElement : list) {
				temp = webElement.getText();
				temp = base.stringToReplace(temp, ",", "");
				totalNum = base.add(totalNum, Double.parseDouble(temp));
			}
		}
		else if(columnName.equals("Ԥ��������")){
			list = base.getElements(expectTotalMoneysByPartake);
			for (WebElement webElement : list) {
				temp = webElement.getText();
				temp = base.stringToReplace(temp, ",", "");
				totalNum = base.add(totalNum, Double.parseDouble(temp));
			}
		}
		else if(columnName.equals("�ѻ�������")){
			list = base.getElements(haveTotalMoneysByPartake);
			for (WebElement webElement : list) {
				temp = webElement.getText();
				temp = base.stringToReplace(temp, ",", "");
				totalNum = base.add(totalNum, Double.parseDouble(temp));
			}
		}
		return totalNum;
	}
	
	/*******************************************/
	/************** ������_�鿴����    ****************/
	/*******************************************/
	
	
	/*******************************************/
	/************ ������_�鿴����_��ť   ***************/
	/*******************************************/
	
	/**
	 * ���ݡ���Լ���ޡ�������鿴���顱��ť 
	 * @param ViewDetails ��Լ���ޣ����磺7/30/90/180/720��
	 * @author ������ 2015-10-13
	 */
	public void clickAppointViewDetails(String ViewDetails){
		
		base.clickWithWait(By.cssSelector("#phasestypetr" + ViewDetails + " input"));
	}
	
	/*******************************************/
	/************ ������_�鿴����_����   ***************/
	/*******************************************/
	
	/**
	 * У�顰�鿴���顱�б��Ƿ���ʾ
	 * @param ViewDetails
	 */
	public void checkViewDetails(String ViewDetails){
		
		base.assertEqualsActualExpectedByBoolean(base.checkVisible(By.cssSelector("#phasestypetr" + ViewDetails + " > #_contenthtml")), true);
	}
	
	/**
	 * ��顰�鿴���顱�б����Ƿ���ƥ�����ֵ
	 * @param columnValue ��ֵ
	 * @author ������ 2015-10-14
	 */
	public void checkViewDetailsByValue(String columnValue){
		
		List<WebElement> trList = new ArrayList<WebElement>();
		List<WebElement> tdList = new ArrayList<WebElement>();
		String columnStr;
		boolean isShow = false;
		
		do{
			trList = base.getElements(By.cssSelector("#_contenthtml .ciyaotable tr"));
			int trLength = trList.size();
			int tdLength;
			for(int i = 1; i < trLength; i++){//�ų���һ���б�ͷ
				tdList = trList.get(i).findElements(By.tagName("td"));
				tdLength = tdList.size();
				for(int j = 0; j < tdLength; j++){
					columnStr = tdList.get(j).getText();
					if(columnStr.equals(columnValue)){
						isShow = true;
					}
				}
			}
			
			//���û�У������һҳ
			if(!isShow){
				boolean isAvailable = false;
				//�Ƿ����;trueΪ���أ�falseΪ��ʾ
				isAvailable = isAvailableByPageNum("��һҳ");
				//�жϵ�ǰҳ�Ƿ������һҳ������һҳ��ť�Ƿ�����
				if(isAvailable){
					chickPageNum("��һҳ");
					base.sleep(2000);
				}
				else{
					Reporter.log("error_���鿴���顱�б�û����ص���汦��Ϣ");
					System.out.println("error_���鿴���顱�б�û����ص���汦��Ϣ");
					break;
				}
			}
		}
		while(!isShow);
		base.assertEqualsActualExpectedByBoolean(isShow, true);
	}
	
	
	/**
	 * �ҵ��˻�->��汦->������->�鿴���飬��ȡĳ��ֵ
	 * @param investPeriod Ͷ����������汦���ƣ�
	 * @param columnName ��ֵ�����磺Ͷ���������껯�����ʡ������Ԥ�����桢�ѻ����桢��Ϣʱ�䡢����ʱ�䣩
	 * @return ĳ��ֵ
	 * @author ������ 2016-1-4
	 */
	public String getViewDetailsValue(String investPeriod, String columnName){
		
		String num = "";
		switch (columnName) {
		case "Ͷ������":		num = "1";	break;
		case "�껯������":		num = "2";	break;
		case "������":		num = "3";	break;
		case "Ԥ������":		num = "4";	break;
		case "�ѻ�����":		num = "5";	break;
		case "��Ϣʱ��":		num = "6";	break;
		case "����ʱ��":		num = "7";	break;
		default:			num = "1";	break;
		}
		By by = By.xpath("//td[text()='" + investPeriod + "']//parent::tr/td[" + num + "]");
		return base.getElementTextWithVisible(by);
	}
	
	/**
	 * �ҵ��˻�->��汦->������->�鿴���飬��ȡĳ������ֵ�Ķ���
	 * @param columnName ��ֵ�����磺Ͷ���������껯�����ʡ������Ԥ�����桢�ѻ����桢��Ϣʱ�䡢����ʱ�䣩
	 * @return ĳ������ֵ�Ķ���
	 * @author ������ 2016-1-6
	 */
	public By getViewDetailsBy(String columnName){
		
		String num = "";
		switch (columnName) {
		case "Ͷ������":		num = "1";	break;
		case "�껯������":		num = "2";	break;
		case "������":		num = "3";	break;
		case "Ԥ������":		num = "4";	break;
		case "�ѻ�����":		num = "5";	break;
		case "��Ϣʱ��":		num = "6";	break;
		case "����ʱ��":		num = "7";	break;
		default:			num = "1";	break;
		}
		By by = By.cssSelector("table.ciyaotable>tbody>tr>td:nth-child(" + num + ")");
		return by;
	}
	
	/*******************************************/
	/************* ������_���Э��_ծȨ����    ***********/
	/*******************************************/
	
	/**
	 * ��������µġ����Э�顱��ծȨ���顱
	 * @param operateName
	 * @author ������ 2015-10-14
	 */
	public void clickOperate(String eCunBaoName, String operateName){
		if(operateName.equals("���Э��")){
			base.clickWithWait(By.xpath("//td[text()='" + eCunBaoName + "']/parent::tr//a[text()='���Э��']"));
		}
		else if(operateName.equals("ծȨ����")){
			base.clickWithWait(By.xpath("//td[text()='" + eCunBaoName + "']/parent::tr//a[text()='ծȨ����']"));
		}
	}
	
	/**
	 * У�顰ծȨ���顱���Ƿ���ʾ
	 * @author ������
	 */
	public void checkCreditorDetailsDIV(){
		base.assertEqualsActualExpectedByBoolean(base.checkVisible(creditorDetailsDiv), true);
	}
		
	/**
	 * У�顰ծȨ���顱�б�ֵ�Ƿ���ȷ
	 * @author ������ 2015-10-14
	 */
	public void checkCreditorDetailsByValue(String[] creditorDetails){
		
		List<WebElement> list = new ArrayList<WebElement>();
		list = base.getElements(By.cssSelector("#detailstable>tbody>tr>td"));
		int size = list.size();
		for(int i = 0; i < size; i++){
			if(i != (size - 1) ){
				base.assertEqualsActualExpected(list.get(i).getText(), creditorDetails[i]);
			}
			else{
				base.assertEqualsActualExpected(list.get(i).findElement(By.tagName("a")).getText(), creditorDetails[i]);
			}
			
		}
	}
	
	/**
	 * �رա�ծȨ���顱���Ƿ���ʾ
	 * @author ������
	 */
	public void closeCreditorDetails(){
		base.clickWithWait(By.cssSelector(".tip_close"));
	}
	
	/**
	 * У�顰ծȨ���顱
	 * @author ������
	 */
	public void checkCreditorDetails(String eCunBaoName,String[] creditorDetails){
		clickOperate(eCunBaoName, "ծȨ����");
		checkCreditorDetailsDIV();
		checkCreditorDetailsByValue(creditorDetails);
		closeCreditorDetails();
	}
	
	/**
	 * У�顰ծȨ���顱
	 * @param eCunBaoName ��汦��Ͷ����������Ʒ���ƣ����磺��汦1979�ڣ�
	 */
	public void checkCreditorDetails(String eCunBaoName){
		clickOperate(eCunBaoName, "ծȨ����");
		checkCreditorDetailsDIV();
		
		
		closeCreditorDetails();
	}
	
	/**
	 * �ҵ��˻�����>��汦����>�����ծȨ���顱��ť��У�鴰��������ʾ�Ƿ�����
	 * @author ������ 2016-2-5
	 */
	public void checkBondDetailsDIVColumnName(){
		String[] columnName = {"������","���������","���֤��","����˵���","����ܶ�","�������","�������","����"};
		List<WebElement> webList = base.getVisibleElements(eCBBondDetailsDIVColumnName);
		int size = webList.size();
		base.assertEqualsActualExpectedByInt(size, columnName.length);
		for(int i = 0; i < size; i++){
			base.assertEqualsActualExpected(webList.get(i).getText(), columnName[i]);
		}
	}
	
	/**
	 * �ҵ��˻�����>��汦����>�����ծȨ���顱��ť����ȡ����ĳ�е�ֵ
	 * @param columnName ����
	 * @return ĳ��ֵ�ļ���
	 * @author ������ 2016-2-4
	 */
	public List<String> getBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String index = "1";
		switch (columnName) {
		case "������":	index = "1";	break;		
		case "���������":	index = "2";	break;	
		case "���֤��":	index = "3";	break;	
		case "����˵���":	index = "4";	break;	
		case "����ܶ�":	index = "5";	break;	
		case "�������":	index = "6";	break;
		case "�������":	index = "7";	break;
		case "����":		index = "8";	break;	
		default:		index = "1";	break;	
		}
		List<WebElement> webList = base.getVisibleElements(By.cssSelector(".font14.color6>td:nth-child(" + index + ")"));
		for(int i = 0; i < webList.size(); i++){
			strList.add(webList.get(i).getText());
		}
		return strList;
	}
	
	/**
	 * �ҵ��˻�����>��汦����>ծȨ���顪��>�鿴���顪��>��ȡTab����
	 * @param tabName Tab����
	 * @return Tab����
	 * @author ������ 2016-2-5
	 */
	public By getBondDetailsSeeTab(String tabName){
		String index;
		By by;
		switch (tabName) {
		case "������Ϣ":	index = "1";	break;
		case "��������":	index = "2";	break;
		case "��������":	index = "3";	break;
		case "��ʷͳ��":	index = "4";	break;
		case "������Ϣ":	index = "5";	break;
		default:		index = "1";	break;
		}
		by = By.cssSelector(".xq_content_t > li:nth-child(" + index + ")");
		return by;
	}
	
	/**
	 * �ҵ��˻�����>��汦����>ծȨ���顪��>�鿴���顪��>���Tab
	 * @param tabName Tab����
	 * @author ������ 2016-2-5
	 */
	public void clickBondDetailsSeeTab(String tabName){
		By by = getBondDetailsSeeTab(tabName);
		base.clickWithWait(by);
		base.assertTrueByBoolean(base.isElementContainsValue2(by, "class", "cur"));
	}
	
	/**
	 *  �ҵ��˻�����>��汦����>ծȨ���顪��>�鿴���顪��>���X��ť
	 * @author ������ 2016-2-5
	 */
	public void clickBondDetailsDIVClose(){
		base.clickWithWait(eCBBondDetailsDIVClose);
		base.checkInvisibility(eCBBondDetailsDIV);
	}
	
	/**
	 * �ҵ��˻�����>��汦����>�����ծȨ���顱��ť����>������鿴���顱��ť��У��鿴����1.ֻ��ʾ��������Ľ��ꣻ2.��������ʾ�����飨������Ϣ�����������ϣ�������/�������ʷͳ�ƣ���ͳ����Ϣ�������Ϣƥ��
	 * @author ������ 2016-2-5
	 */
	public void checkBondDetails(){
		
		List<WebElement> bondDetailsDIVBtnList;
		List<String> titleList = getBondDetailsDIVColumnValue("������");
		bondDetailsDIVBtnList = base.getVisibleElements(eCBBondDetailsDIVBtn);
		for(int i = 0; i < 1; i++){
			bondDetailsDIVBtnList.get(i).click();//������鿴���顱��ť
			base.isElementVisible(By.xpath("//td[text()='" + titleList.get(i) + "']"));
			base.assertEqualsActualExpected(base.getElementTextWithVisible(By.cssSelector(".xq_content_tab_block.border>h3")), "�������");
			clickBondDetailsSeeTab("��������");
			clickBondDetailsSeeTab("��������");
			clickBondDetailsSeeTab("��ʷͳ��");
			clickBondDetailsSeeTab("������Ϣ");
			checkBondDetailsSeeMaterial();
			bondDetailsDIVBtnList.get(i).click();//������鿴���顱��ť
			base.isElementContainsValue(eCBBondDetailsSeeDIV, "style", "none");
			clickBondDetailsDIVClose();
			base.isElementContainsValue(By.cssSelector("#out_all3"), "style", "none");
		}
	}
	
	/**
	 * У����ʷ���ϣ�ͼƬ�Ƿ��ܴ�
	 * @author ������ 2016-2-5
	 */
	public void checkBondDetailsSeeMaterial(){
		boolean isShow = false;
		String[] btnTxt = {"������Ƭ","��ֱϵ������Ӱ��","ס�������Ƭ"};
		int imgNum = 0;
		List<WebElement> numList = base.getVisibleElements(By.cssSelector(".hmuch"));
		for(int i = 0; i < numList.size(); i++){
			imgNum = Integer.valueOf(numList.get(i).getText());
			if(imgNum < 1){
				isShow = false;
			}
			base.assertTrueByBoolean(imgNum <= 1?true:false);
		}
		
		List<WebElement> btnList = base.getVisibleElements(By.cssSelector(".otherinf"));
		for(int i = 0; i < btnList.size(); i++){
			base.assertEqualsActualExpected(btnList.get(i).getText(), btnTxt[i]);
		}
		
		if(isShow){
			List<WebElement> imgList = base.getVisibleElements(By.cssSelector(".cpic"));
			for(int i = 0; i < imgList.size(); i++){
				imgList.get(i).click();
				base.checkElementVisible(By.cssSelector(".ui-dialog.ui-widget.ui-widget-content.ui-corner-all.ui-draggable.ui-resizable"));
				base.assertEqualsActualExpected(base.getElementTextWithVisible(By.cssSelector("#ui-dialog-title-showWmpsTenderPubDataDiv")), btnTxt[i]);
				base.clickWithWait(By.cssSelector(".ui-icon.ui-icon-closethick"));
			}
		}
	}
	
	/**
	 * ��ҳ����>��汦����>�����ծȨ���顱��ť��У�鴰��ĳ�е�ֵ��ʾ�Ƿ�����
	 * @param columnName ����
	 * @author ������ 2016-2-5
	 */
	public void checkBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String temp;
		strList = getBondDetailsDIVColumnValue(columnName);
		if(columnName.equals("������")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				if(temp.length() > 5){
					temp = temp.substring(5);
					base.assertTrueByBoolean(temp.equals("..."));
				}
			}
		}
		else if(columnName.equals("���������")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(1);
				base.assertTrueByBoolean(temp.contains("*"));
			}
		}
		else if(columnName.equals("���֤��")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(10);
				base.assertTrueByBoolean(temp.equals("********"));
			}
		}
		else if(columnName.equals("����")){
			for(int i = 0; i < strList.size(); i++){
				base.assertEqualsActualExpected(strList.get(i), "�鿴����");
			}
		}
	}
	

	/**
	 * У�顰���Э�顱����PDF
	 * @author ������
	 */
	public void checkFinanceAgreement(String eCunBaoName){
		clickOperate(eCunBaoName, "���Э��");
		base.jumpToNewWindow();
		base.checkTitle("���������߾Ӽ����Э��");
		electronicIOU.clickPDFLnk();
	}
	
	public void checkFinanceAgreementByOld(String eCunBaoName){
		clickOperate(eCunBaoName, "���Э��");
		base.jumpToNewWindow();
		base.checkTitle("���Э��");
		electronicIOU.clickPDFLnk();
	}
}