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
 * “我的账户”-“翼存宝”页面
 */
public class YCBPage {
	
	Base base = new Base();
	ElectronicIOU electronicIOU = new ElectronicIOU();
	
	//翼存宝
	public static By YCBTxt = By.cssSelector("h1.f-fc333");				 //翼存宝标题
	By eCunBaoName = By.cssSelector(".pdb8");							 //“翼存宝相关名称”（包括待收本金、待收利息、已赚利息、昨日总收息）
	By eCunBaoData = By.cssSelector(".cont.f-cb  span");           		 //“翼存宝相关数据”（包括待收本金、待收利息、已赚利息、昨日总收息、代收笔数）
	By waitPrincipalNumByECB = By.cssSelector("#dueingPrincipal"); 		 //“待收本金”
	By waitInterestNumByECB = By.cssSelector("#daishoulixi");      	 	 //“待收利息”
	By waitEachNumByECB = By.cssSelector("#dueingNum");            	 	 //“待收笔数”
	By interestEarnedByECB = By.cssSelector("#loanSumInter");			 //“已赚利息”
	By yesterdayTotalIncomeByECB  = By.cssSelector("#strYesterdayInter");//“昨日总收息”
	By investmentECunBao = By.cssSelector(".lineh24>a");            	 //“去投资翼存宝”
	
	/******************************/
	/******    翼存宝_债权详情           ******/
	/******************************/
	
	By eCBBondDetailsDIV = By.cssSelector("#messageBoxCard");									//债权详情_窗口
	By eCBBondDetailsDIVTitle = By.cssSelector("#saveTitle");									//债权详情_窗口_Title
	By eCBBondDetailsDIVColumnName = By.cssSelector("#detailstable>thead>tr>th");				//债权详情_窗口_列名(包括：借款标题、借款人姓名、身份证号、借款人地区、借款总额、操作)
	By eCBBondDetailsDIVInfo = By.cssSelector("#tenderBody .font14.color6>td");					//债权详情_窗口_信息(包括：借款标题、借款人姓名、身份证号、借款人地区、借款总额)
	By eCBBondDetailsDIVBtn = By.cssSelector(".xqbtn");											//债权详情_窗口_所有“查看详情”按钮
	By eCBBondDetailsSeeDIV = By.cssSelector("#xq_content");									//债权详情_窗口_查看详情_窗口
	By eCBBondDetailsDIVTab = By.cssSelector(".xq_content_t");									//债权详情_窗口_查看详情_所有Tab按钮
	By eCBBondDetailsDIVClose = By.cssSelector(".tip_close");									//债权详情_窗口_查看详情_关闭按钮

	//每日收益
	By detailTxt = By.cssSelector("#xiangQing");										  //每日收益明细
	
	//参与中
//	By partakeTxt = By.cssSelector("#canYuZhong");                                        //参与中
	By partakeTxt = By.xpath("//span[@id='canYuZhong']");
	By investTotalEachNumsByPartake = By.cssSelector("table>tbody>tr>td:nth-child(2)");   //“参与中”的所有“投资总笔数”
	By joinTotalMoneysByPartake = By.cssSelector("table>tbody>tr>td:nth-child(3)");       //“参与中”的所有“加入总金额”
	By expectTotalMoneysByPartake = By.cssSelector("table>tbody>tr>td:nth-child(4)");     //“参与中”的所有“预计总收益”
	By haveTotalMoneysByPartake = By.cssSelector("table>tbody>tr>td:nth-child(5)");       //“参与中”的所有“已获总收益”
	By financeAgreementLink = By.xpath("//a[text()='理财协议']"); 							  //“参与中”——>“操作”——>“理财协议”
	By creditorDetailsLink = By.xpath("//a[text()='债权详情']"); 							  //“参与中”——>“操作”——>“债权详情”
	By creditorDetailsDiv = By.cssSelector("#messageBoxCard");							  //“参与中”——>“操作”——>“债权详情”——>“债权详情列表”
	
	//已结清
	By settleTxt = By.cssSelector("#yiJieQing");										   //已结清
	
	/****************************综合******************************/
	
	/**
	 * 获取页面按钮元素
	 * @param pageName 按钮名称
	 * @return 按钮元素
	 * @author 江渤洋 2015-11-9
	 */
	public By getPageNum(String pageName){
		
		By by = null;
		if(pageName.equals("首页")){
			by = By.xpath("//div[@id='Pagination']/ul/li[text()='首页']");
		}
		else if(pageName.equals("上一页")){
			by = By.xpath("//div[@id='Pagination']/ul/li[text()='<']");
		}
		else if(pageName.equals("下一页")){
			by = By.xpath("//div[@id='Pagination']/ul/li[text()='>']");
		}
		else if(pageName.equals("末页")){
			by = By.xpath("//div[@id='Pagination']/ul/li[text()='末页']");
		}
		else{
			by = By.xpath("//div[@id='Pagination']/ul/li[text()='" + pageName + "']");
		}
		base.checkVisible(by);
		return by;
	}
	
	/**
	 * 跳转页面按钮是否可用
	 * @param pageName 按钮名称
	 * @return 是否可用（true:可用，false：不可用）
	 * @author 江渤洋 2015-11-9
	 */
	public boolean isAvailableByPageNum(String pageName){
		
		boolean isShow = false;
		By by = getPageNum(pageName);
		isShow = !(base.isElementContainsValue(by, "class", "pgEmpty"));
		return isShow;
	}
	
	/**
	 * 点击跳转页面按钮
	 * @param pageName 按钮名称
	 * @author 江渤洋 2015-11-9
	 */
	public void chickPageNum(String pageName){
		
		By by = getPageNum(pageName);
		base.clickElementNoWait(by);
	}
	
	/****************************翼存宝******************************/
	
	/**
	 * 获取翼存宝某个信息的值（例如：待收本金、待收利息、待收笔数）
	 * @param infoName：信息名称
	 * @return 信息的值
	 * @author 江渤洋 2015-10-8
	 */
	public String getECunBaoInfoData(String infoName){
		
		By by = null;
		String value;
		if(infoName.equals("待收本金")){
			by = waitPrincipalNumByECB;
		}
		else if(infoName.equals("待收利息")){
			by = waitInterestNumByECB;
		}
		else if(infoName.equals("待收笔数")){
			by = waitEachNumByECB;
		}
		else if(infoName.equals("已赚利息")){
			by = interestEarnedByECB;
		}
		else if(infoName.equals("昨日总收息")){
			by = yesterdayTotalIncomeByECB;
		}
		value = base.getElementTextWithWait(by);
		value = base.stringToReplace(value, ",", "");
		return value;
	}
	
	/**
	 * 获取翼存宝相关信息值的集合
	 * 备注：包括待收本金、待收利息、待收笔数、已赚利息、昨日总收息
	 * @return 值的集合
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
	 * 我的账户->翼存宝->校验翼存宝各个名称是否正确
	 * @author 江渤洋 2016-1-6
	 */
	public void checkECunBaoInfoName(){
		
		String[] name = {"待收本金","待收利息","已赚利息","昨日总收息"}; 
		List<WebElement> listWeb = new ArrayList<WebElement>();
		listWeb = base.getVisibleElements(eCunBaoName);
		for(int i = 0; i < listWeb.size(); i++){
			base.assertEqualsActualExpected(listWeb.get(i).getText(), name[i]);
		}
	}
	
	
	/*******************************************/
	/**************   每日收益明细      ****************/
	/*******************************************/
	
	/**
	 * 点击“每日收益明细”
	 * @author 江渤洋 2016-1-6
	 */
	public void clickDetail(){
		base.clickWithWait(detailTxt);
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(detailTxt, "class", "current"), true);
		checkDetailColumnName();
		base.isTitle(PageTitles.woDeZhangHu);
	}
	
	/**
	 * 我的账户->翼存宝->校验“每日收益明细”列名是否正确
	 * @author 江渤洋 2016-1-6
	 */
	public void checkDetailColumnName(){
		
		String[] name = {"收息时间", "当日总收益", "操作"};
		List<WebElement> listWeb = new ArrayList<WebElement>();
		By by = By.cssSelector("#_content_child div.global_table.mt10>table th");
		listWeb = base.getVisibleElements(by);
		for(int i = 0; i < listWeb.size(); i++){
			base.assertEqualsActualExpected(listWeb.get(i).getText(), name[i]);
		}
	}
	
	/*******************************************/
	/**************     已结清            ****************/
	/*******************************************/
	
	/**
	 * 点击“已结清”
	 * @author 江渤洋 2016-1-6
	 */
	public void clickSettle(){
		base.clickWithWait(settleTxt);
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(settleTxt, "class", "current"), true);
		checkSettleColumnName();
		base.isTitle(PageTitles.woDeZhangHu);
	}
	
	/**
	 * 我的账户->翼存宝->校验“已结清”列名是否正确
	 * @author 江渤洋 2016-1-6
	 */
	public void checkSettleColumnName(){
		
		String[] name = {"合约期限", "投资总笔数", "加入总金额", "已获总收益", "操作"};
		List<WebElement> listWeb = new ArrayList<WebElement>();
		By by = By.cssSelector(".global_table.mt10>table>thead>tr>th");
		listWeb = base.getVisibleElements(by);
		for(int i = 0; i < listWeb.size(); i++){
			base.assertEqualsActualExpected(listWeb.get(i).getText(), name[i]);
		}
	}
	
	/*******************************************/
	/****************   参与中      ******************/
	/*******************************************/
	
	/**
	 * 点击“参与中”
	 * @author 江渤洋 2016-1-6
	 */
	public void clickPartake(){
		int count = 0;
		base.clickWithWait(partakeTxt);
		base.clickWithWait(detailTxt);
		base.clickWithWait(partakeTxt);
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(partakeTxt, "class", "current"), true);
//		do{
//			if(base.isElementVisible(By.xpath("//th[text()='合约期限']"))){
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
	 * 我的账户->翼存宝->校验“参与中”列名是否正确
	 * @author 江渤洋 2016-1-6
	 */
	public void checkPartakeColumnName(){
		
		String[] name = {"合约期限", "投资总笔数", "加入总金额", "预计总收益", "已获总收益", "操作"};
		List<WebElement> listWeb = new ArrayList<WebElement>();
		By by = By.cssSelector(".global_table.mt10>table>thead>tr>th");
		listWeb = base.getVisibleElements(by);
		for(int i = 0; i < listWeb.size(); i++){
			base.assertEqualsActualExpected(listWeb.get(i).getText(), name[i]);
		}
	}
	
	/**
	 * 校验“参与中”是否可见
	 * @author 江渤洋
	 */
	public void checkPartake(){
		base.assertEqualsActualExpectedByBoolean(base.checkVisible(By.cssSelector("#_content_child")), true);
	}
	
	/**
	 * 我的账户->翼存宝->参与中，根据“合约期限”获取该行的值。（如：合约期限、投资总笔数、加入总金额、预计总收益、已获总收益）
	 * @param limit 合约期限
	 * @param columnName 列值
	 * @return 对应值
	 * @author 江渤洋 2016-1-4
	 */
	public String getPartakeValue(String limit, String columnName){
		
		String num = "";
		String columnValue = "";
		switch (columnName) {
		case "合约期限":	num = "1";break;
		case "投资总笔数":	num = "2";break;
		case "加入总金额":	num = "3";break;
		case "预计总收益":	num = "4";break;
		case "已获总收益":	num = "5";break;
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
	 * 格式化“投资总笔数”（例如：11笔->11）
	 * @param str “投资总笔数”
	 * @return 格式化后的“投资总笔数”
	 * @author 江渤洋 2016-1-5
	 */
	public String formatInvestSum(String str){
		
		if(str.indexOf("笔") != -1){
			str = str.substring(0, str.indexOf("笔"));
		}
		return str;
	}
	
	/**
	 * 获取“参与中”表格的某列之和
	 * @param columnName：列名
	 * @return 某列之和
	 * @author 江渤洋 2015-10-9
	 */
	public double getColumnSumByPartake(String columnName){
		double totalNum = 0;
		String temp;
		List<WebElement> list = new ArrayList<WebElement>();
		if(columnName.equals("投资总笔数")){
			list = base.getElements(investTotalEachNumsByPartake);
			for (WebElement webElement : list) {
				temp = webElement.getText();
				temp = temp.substring(0, temp.length()-1);
				totalNum = base.add(totalNum, Double.parseDouble(temp));
			}
		}
		else if(columnName.equals("加入总金额")){
			list = base.getElements(joinTotalMoneysByPartake);
			for (WebElement webElement : list) {
				temp = webElement.getText();
				temp = base.stringToReplace(temp, ",", "");
				totalNum = base.add(totalNum, Double.parseDouble(temp));
			}
		}
		else if(columnName.equals("预计总收益")){
			list = base.getElements(expectTotalMoneysByPartake);
			for (WebElement webElement : list) {
				temp = webElement.getText();
				temp = base.stringToReplace(temp, ",", "");
				totalNum = base.add(totalNum, Double.parseDouble(temp));
			}
		}
		else if(columnName.equals("已获总收益")){
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
	/************** 参与中_查看详情    ****************/
	/*******************************************/
	
	
	/*******************************************/
	/************ 参与中_查看详情_按钮   ***************/
	/*******************************************/
	
	/**
	 * 根据“合约期限”点击“查看详情”按钮 
	 * @param ViewDetails 合约期限（例如：7/30/90/180/720）
	 * @author 江渤洋 2015-10-13
	 */
	public void clickAppointViewDetails(String ViewDetails){
		
		base.clickWithWait(By.cssSelector("#phasestypetr" + ViewDetails + " input"));
	}
	
	/*******************************************/
	/************ 参与中_查看详情_内容   ***************/
	/*******************************************/
	
	/**
	 * 校验“查看详情”列表是否显示
	 * @param ViewDetails
	 */
	public void checkViewDetails(String ViewDetails){
		
		base.assertEqualsActualExpectedByBoolean(base.checkVisible(By.cssSelector("#phasestypetr" + ViewDetails + " > #_contenthtml")), true);
	}
	
	/**
	 * 检查“查看详情”列表中是否有匹配的列值
	 * @param columnValue 列值
	 * @author 江渤洋 2015-10-14
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
			for(int i = 1; i < trLength; i++){//排除第一行列表头
				tdList = trList.get(i).findElements(By.tagName("td"));
				tdLength = tdList.size();
				for(int j = 0; j < tdLength; j++){
					columnStr = tdList.get(j).getText();
					if(columnStr.equals(columnValue)){
						isShow = true;
					}
				}
			}
			
			//如果没有，点击下一页
			if(!isShow){
				boolean isAvailable = false;
				//是否可用;true为隐藏，false为显示
				isAvailable = isAvailableByPageNum("下一页");
				//判断当前页是否是最后一页，即下一页按钮是否隐藏
				if(isAvailable){
					chickPageNum("下一页");
					base.sleep(2000);
				}
				else{
					Reporter.log("error_“查看详情”列表没有相关的翼存宝信息");
					System.out.println("error_“查看详情”列表没有相关的翼存宝信息");
					break;
				}
			}
		}
		while(!isShow);
		base.assertEqualsActualExpectedByBoolean(isShow, true);
	}
	
	
	/**
	 * 我的账户->翼存宝->参与中->查看详情，获取某列值
	 * @param investPeriod 投资期数（翼存宝名称）
	 * @param columnName 列值（例如：投资期数、年化收益率、加入金额、预计收益、已获收益、计息时间、到期时间）
	 * @return 某列值
	 * @author 江渤洋 2016-1-4
	 */
	public String getViewDetailsValue(String investPeriod, String columnName){
		
		String num = "";
		switch (columnName) {
		case "投资期数":		num = "1";	break;
		case "年化收益率":		num = "2";	break;
		case "加入金额":		num = "3";	break;
		case "预计收益":		num = "4";	break;
		case "已获收益":		num = "5";	break;
		case "计息时间":		num = "6";	break;
		case "到期时间":		num = "7";	break;
		default:			num = "1";	break;
		}
		By by = By.xpath("//td[text()='" + investPeriod + "']//parent::tr/td[" + num + "]");
		return base.getElementTextWithVisible(by);
	}
	
	/**
	 * 我的账户->翼存宝->参与中->查看详情，获取某列所有值的对象
	 * @param columnName 列值（例如：投资期数、年化收益率、加入金额、预计收益、已获收益、计息时间、到期时间）
	 * @return 某列所有值的对象
	 * @author 江渤洋 2016-1-6
	 */
	public By getViewDetailsBy(String columnName){
		
		String num = "";
		switch (columnName) {
		case "投资期数":		num = "1";	break;
		case "年化收益率":		num = "2";	break;
		case "加入金额":		num = "3";	break;
		case "预计收益":		num = "4";	break;
		case "已获收益":		num = "5";	break;
		case "计息时间":		num = "6";	break;
		case "到期时间":		num = "7";	break;
		default:			num = "1";	break;
		}
		By by = By.cssSelector("table.ciyaotable>tbody>tr>td:nth-child(" + num + ")");
		return by;
	}
	
	/*******************************************/
	/************* 参与中_理财协议_债权详情    ***********/
	/*******************************************/
	
	/**
	 * 点击操作下的“理财协议”或“债权详情”
	 * @param operateName
	 * @author 江渤洋 2015-10-14
	 */
	public void clickOperate(String eCunBaoName, String operateName){
		if(operateName.equals("理财协议")){
			base.clickWithWait(By.xpath("//td[text()='" + eCunBaoName + "']/parent::tr//a[text()='理财协议']"));
		}
		else if(operateName.equals("债权详情")){
			base.clickWithWait(By.xpath("//td[text()='" + eCunBaoName + "']/parent::tr//a[text()='债权详情']"));
		}
	}
	
	/**
	 * 校验“债权详情”层是否显示
	 * @author 江渤洋
	 */
	public void checkCreditorDetailsDIV(){
		base.assertEqualsActualExpectedByBoolean(base.checkVisible(creditorDetailsDiv), true);
	}
		
	/**
	 * 校验“债权详情”列表值是否正确
	 * @author 江渤洋 2015-10-14
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
	 * 关闭“债权详情”层是否显示
	 * @author 江渤洋
	 */
	public void closeCreditorDetails(){
		base.clickWithWait(By.cssSelector(".tip_close"));
	}
	
	/**
	 * 校验“债权详情”
	 * @author 江渤洋
	 */
	public void checkCreditorDetails(String eCunBaoName,String[] creditorDetails){
		clickOperate(eCunBaoName, "债权详情");
		checkCreditorDetailsDIV();
		checkCreditorDetailsByValue(creditorDetails);
		closeCreditorDetails();
	}
	
	/**
	 * 校验“债权详情”
	 * @param eCunBaoName 翼存宝的投资期数（产品名称，例如：翼存宝1979期）
	 */
	public void checkCreditorDetails(String eCunBaoName){
		clickOperate(eCunBaoName, "债权详情");
		checkCreditorDetailsDIV();
		
		
		closeCreditorDetails();
	}
	
	/**
	 * 我的账户——>翼存宝——>点击“债权详情”按钮，校验窗口列名显示是否正常
	 * @author 江渤洋 2016-2-5
	 */
	public void checkBondDetailsDIVColumnName(){
		String[] columnName = {"借款标题","借款人姓名","身份证号","借款人地区","借款总额","借款利率","借款期限","操作"};
		List<WebElement> webList = base.getVisibleElements(eCBBondDetailsDIVColumnName);
		int size = webList.size();
		base.assertEqualsActualExpectedByInt(size, columnName.length);
		for(int i = 0; i < size; i++){
			base.assertEqualsActualExpected(webList.get(i).getText(), columnName[i]);
		}
	}
	
	/**
	 * 我的账户——>翼存宝——>点击“债权详情”按钮，获取窗口某列的值
	 * @param columnName 列名
	 * @return 某列值的集合
	 * @author 江渤洋 2016-2-4
	 */
	public List<String> getBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String index = "1";
		switch (columnName) {
		case "借款标题":	index = "1";	break;		
		case "借款人姓名":	index = "2";	break;	
		case "身份证号":	index = "3";	break;	
		case "借款人地区":	index = "4";	break;	
		case "借款总额":	index = "5";	break;	
		case "借款利率":	index = "6";	break;
		case "借款期限":	index = "7";	break;
		case "操作":		index = "8";	break;	
		default:		index = "1";	break;	
		}
		List<WebElement> webList = base.getVisibleElements(By.cssSelector(".font14.color6>td:nth-child(" + index + ")"));
		for(int i = 0; i < webList.size(); i++){
			strList.add(webList.get(i).getText());
		}
		return strList;
	}
	
	/**
	 * 我的账户——>翼存宝——>债权详情——>查看详情——>获取Tab对象
	 * @param tabName Tab名称
	 * @return Tab对象
	 * @author 江渤洋 2016-2-5
	 */
	public By getBondDetailsSeeTab(String tabName){
		String index;
		By by;
		switch (tabName) {
		case "基本信息":	index = "1";	break;
		case "个人资料":	index = "2";	break;
		case "担保增额":	index = "3";	break;
		case "历史统计":	index = "4";	break;
		case "材料信息":	index = "5";	break;
		default:		index = "1";	break;
		}
		by = By.cssSelector(".xq_content_t > li:nth-child(" + index + ")");
		return by;
	}
	
	/**
	 * 我的账户——>翼存宝——>债权详情——>查看详情——>点击Tab
	 * @param tabName Tab名称
	 * @author 江渤洋 2016-2-5
	 */
	public void clickBondDetailsSeeTab(String tabName){
		By by = getBondDetailsSeeTab(tabName);
		base.clickWithWait(by);
		base.assertTrueByBoolean(base.isElementContainsValue2(by, "class", "cur"));
	}
	
	/**
	 *  我的账户——>翼存宝——>债权详情——>查看详情——>点击X按钮
	 * @author 江渤洋 2016-2-5
	 */
	public void clickBondDetailsDIVClose(){
		base.clickWithWait(eCBBondDetailsDIVClose);
		base.checkInvisibility(eCBBondDetailsDIV);
	}
	
	/**
	 * 我的账户——>翼存宝——>点击“债权详情”按钮——>点击“查看详情”按钮，校验查看详情1.只显示被打开详情的借款标；2.分四栏显示标详情（基本信息）（个人资料）（担保/增额）（历史统计），统计信息与借款标信息匹配
	 * @author 江渤洋 2016-2-5
	 */
	public void checkBondDetails(){
		
		List<WebElement> bondDetailsDIVBtnList;
		List<String> titleList = getBondDetailsDIVColumnValue("借款标题");
		bondDetailsDIVBtnList = base.getVisibleElements(eCBBondDetailsDIVBtn);
		for(int i = 0; i < 1; i++){
			bondDetailsDIVBtnList.get(i).click();//点击“查看详情”按钮
			base.isElementVisible(By.xpath("//td[text()='" + titleList.get(i) + "']"));
			base.assertEqualsActualExpected(base.getElementTextWithVisible(By.cssSelector(".xq_content_tab_block.border>h3")), "借款描述");
			clickBondDetailsSeeTab("个人资料");
			clickBondDetailsSeeTab("担保增额");
			clickBondDetailsSeeTab("历史统计");
			clickBondDetailsSeeTab("材料信息");
			checkBondDetailsSeeMaterial();
			bondDetailsDIVBtnList.get(i).click();//点击“查看详情”按钮
			base.isElementContainsValue(eCBBondDetailsSeeDIV, "style", "none");
			clickBondDetailsDIVClose();
			base.isElementContainsValue(By.cssSelector("#out_all3"), "style", "none");
		}
	}
	
	/**
	 * 校验历史材料，图片是否能打开
	 * @author 江渤洋 2016-2-5
	 */
	public void checkBondDetailsSeeMaterial(){
		boolean isShow = false;
		String[] btnTxt = {"场所照片","与直系亲属合影照","住处相关照片"};
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
	 * 首页——>翼存宝——>点击“债权详情”按钮，校验窗口某列的值显示是否正常
	 * @param columnName 列名
	 * @author 江渤洋 2016-2-5
	 */
	public void checkBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String temp;
		strList = getBondDetailsDIVColumnValue(columnName);
		if(columnName.equals("借款标题")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				if(temp.length() > 5){
					temp = temp.substring(5);
					base.assertTrueByBoolean(temp.equals("..."));
				}
			}
		}
		else if(columnName.equals("借款人姓名")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(1);
				base.assertTrueByBoolean(temp.contains("*"));
			}
		}
		else if(columnName.equals("身份证号")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(10);
				base.assertTrueByBoolean(temp.equals("********"));
			}
		}
		else if(columnName.equals("操作")){
			for(int i = 0; i < strList.size(); i++){
				base.assertEqualsActualExpected(strList.get(i), "查看详情");
			}
		}
	}
	

	/**
	 * 校验“理财协议”下载PDF
	 * @author 江渤洋
	 */
	public void checkFinanceAgreement(String eCunBaoName){
		clickOperate(eCunBaoName, "理财协议");
		base.jumpToNewWindow();
		base.checkTitle("翼龙贷在线居间服务协议");
		electronicIOU.clickPDFLnk();
	}
	
	public void checkFinanceAgreementByOld(String eCunBaoName){
		clickOperate(eCunBaoName, "理财协议");
		base.jumpToNewWindow();
		base.checkTitle("理财协议");
		electronicIOU.clickPDFLnk();
	}
}