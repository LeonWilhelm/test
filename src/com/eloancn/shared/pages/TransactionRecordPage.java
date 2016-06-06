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
 * “我的账户”-“交易记录”页面
 */
public class TransactionRecordPage {
	
	Base base = new Base();
	DBData dbData = new DBData();
	
	//交易记录
	public static By TransactionRecordTxt = By.cssSelector("div.newtitle>h3");
	By availableBalance = By.cssSelector("#canBeUsedTotalMoney");                            //可用余额
	
	//时间查找
	By SearchBtn = By.cssSelector("input.time_submit");                                      //“查询”按钮
	
	//结果列表
	By NoRecordTxt = By.cssSelector("table.mt10.global_table.font14>tbody>tr");
	By tabList = By.cssSelector(".mt10.global_table.font14 > tbody > tr");                   //Tab列表
	
	By recordsList = By.cssSelector(".mt10.global_table.font14");                            //交易记录列表
	By IncomeMoney= By.xpath("//div[@id='_content']/div/div[3]/table/tbody/*/td[3]");        //当前页的所有“收入金额”
	By SpentMoney = By.xpath("//div[@id='_content']/div/div[3]/table/tbody/*/td[4]");
	By BalanceMoney = By.xpath("//div[@id='_content']/div/div[3]/table/tbody/tr/td[5]");     //当前页的所有“余额”
	By Description = By.xpath("//div[@id='_content']/div/div[3]/table/tbody/*/td[7]");
	
	By balanceRecords = By.cssSelector("tbody > .bgF1:nth-child(1) > td:nth-child(5)");      //第一条交易记录的余额
	By explainRecords = By.cssSelector("tbody > .bgF1:nth-child(1) > td:nth-child(7)");      //第一条交易记录的说明
	
	//翻页
	By SixPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");							 //页数的第6个链接
	By AllPaginationLnk = By.xpath("//div[@id='Pagination']/ul/li");						 //页数
	By FirstPage = By.xpath("//div[@id='Pagination']/ul/li[text()='首页']");
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");
	By LastPage = By.xpath("//div[@id='Pagination']/ul/li[text()='末页']");
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
	//获得交易记录的页数
	public int getRecordPagesNum(){
		if(base.getElementTextWithWait(NoRecordTxt).equals("无资金流水！")){
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
	//获取上个月的收入总额，投资总额，充值总额
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
				if(des.contains("购买编号为:") && des.contains("的债权")){
					SpentCreditNum=SpentCreditNum+1;
					SpentCredit= SpentCredit+Double.parseDouble(money1);//支出购买债权
				}else if(des.contains("返还债权为:")&& des.contains("的冻结资金")){
					SpentCreditNum = SpentCreditNum-1;
					SpentCredit = SpentCredit-Double.parseDouble(money2);
				}else if(des.contains("成功转让*")&& des.contains("的债权")){
					TransferCreditNum=TransferCreditNum+1;
					TransferCredit= TransferCredit+Double.parseDouble(money2);
				}else if(des.substring(0, 1).equals("给")&& des.substring(des.length()-2).equals("投标")){
					SpentSBNum=SpentSBNum+1;
					SpentSB= SpentSB+Double.parseDouble(money1);
				}else if(des.contains("收款:来自")&& des.contains("的还款")){
					IncomeNum= IncomeNum+1;
					Income = Income+Double.parseDouble(money2);
				}else if((des.contains("给")&& des.contains("投标的网站服务费"))){
					FeeNum=FeeNum+1;
					Fee=Fee+Double.parseDouble(money1);
				}else if(des.contains("财富管理费(系统收购")&& des.contains("的债权)")||(des.contains("转让*")&& des.contains("的债权成交服务费"))){
					FeeNum=FeeNum+1;
					Fee=Fee+Double.parseDouble(money1);
				}else if(des.contains("充值")){
					RechargeNum=RechargeNum+1;
					Recharge=Recharge+Double.parseDouble(money2);
				}
			}
			base.clickWithWait(LastOnePage);	
		}
		//收入笔数，收入金额，购买债权笔数，购买债权金额，购买散标笔数，购买散标金额，散标债权手续费笔数，散标债权手续费金额，充值笔数，充值金额,债权转让笔数，债权转让金额
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
				if((des.contains("给")&& des.contains("投标的网站服务费"))){
					managefee=managefee+Double.parseDouble(money1);
				}	
			}	
			base.clickWithWait(LastOnePage);	
		}
		return managefee;
	}
	
	//获取上个月底的剩余可用余额
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
	 * 获取可用余额
	 * @return 可用余额
	 * @author 江渤洋 2015-10-23
	 */
	public String getAvailableBalance(){
		String availableBalanceStr;
		base.checkElement(availableBalance);
		availableBalanceStr = base.getElementText(availableBalance);
		availableBalanceStr = base.stringToReplace(availableBalanceStr,",","");
		return availableBalanceStr;
	}
	
	/**
	 * 获取Tab的值
	 * @param tabName Tab名称
	 * @return Tab的值
	 * @author 江渤洋 2015-10-23
	 */
	private String getTabValue(String tabName){
		
		String num;
		switch (tabName) {
			case "全部": num = "0";break;
			case "充值": num = "1";break;
			case "放款": num = "2";break;
			case "提现": num = "3";break;
			case "债权": num = "4";break;
			default: num = "0";break;
		}
		return num;
	}

	/**
	 * 获取Tab对象
	 * @param tabName Tab名称
	 * @return Tab对象
	 * @author 江渤洋 2015-10-23
	 */
	public By getTab(String tabName){
		
		String num = getTabValue(tabName);
		By tab = By.cssSelector("#query_type_" + num);
		base.checkElement(tab);
		return tab;
	}
	
	/**
	 * 校验Tab是否被选中
	 * @param tabName Tab名称
	 * @author 江渤洋 2015-10-23
	 */
	public void checkIsClickTab(String tabName){
		
		String num = getTabValue(tabName);
		By tab = By.xpath("//li[span[a[@id='query_type_" + num + "']]]");
		base.checkElement(tab);
		boolean isTrue = base.isElementContainsValue(tab, "class", "all");
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
	}
	
	/**
	 * 点击Tab
	 * @param tabName Tab名称
	 * @author 江渤洋 2015-10-23
	 */
	public void clickTab(String tabName){
		By by = getTab(tabName);
		base.clickWithWait(by);
		checkIsClickTab(tabName);
	}
	
	/**
	 * 获取体验期翼存宝的产品信息
	 * @param email
	 * @return 加入金额，年化收益率，合约期限，计息时间，到期时间
	 * @author 江渤洋 2015-10-23
	 */
	public HashMap<String, String> getRecordTable(String email){
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		String uid = dbData.getUID(email);
		hashMap = dbData.getD_wmps_recordTable(uid);
		return hashMap;
	}
	
	/**
	 * 计算翼存宝每日利息
	 * @param amount 加入金额
	 * @param interestrate 年化收益率
	 * @return 每日利息
	 * @author 江渤洋 2015-10-23
	 */
	public String calculationInterest(String amount, String interestrate){
		
		String interest;
		double amountDou = Double.valueOf(amount);
		double interestrateDou = Double.valueOf(interestrate);
		interest = String.valueOf(base.setRound(amountDou * interestrateDou / 365, 2, true));
		return interest;
	}
	
	/**
	 * 获取体验期翼存宝每日利息
	 * @param email 用户邮箱
	 * @return 每日利息
	 * @author 江渤洋 2015-10-23
	 */
	public String getInterest(String email){
		
		String interest;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap = getRecordTable(email);
		String amount = hashMap.get("amount");//加入金额
		String interestrate = hashMap.get("interestrate");//年化收益率
		interest = calculationInterest(amount, interestrate);
		return interest;
	}
	
	/**
	 * 计算“累计收益”
	 * 备注： 累计收益 = 利息 * (当前日期-计息时间)
	 * @param interest 利息
	 * @param interdate 计息时间
	 * @return 累计收益
	 * @author 江渤洋 2015-10-27
	 */
	public String calcCumulativeGain(String interest, String interdate){
		
		Double interestDou = Double.parseDouble(interest);
		long interDateLong = Long.parseLong(interdate) * 1000;//计息时间
		long currentDataLong = base.getcurrentTimeMillis();   //当前日期
		long subLong = base.getDifferenceOfDate(currentDataLong, interDateLong);
		System.out.println("当前日期：" + currentDataLong);
		System.out.println("计息日期：" + interDateLong);
		System.out.println("当前日期与计息日期相差" + subLong + "天");
		String cumulative = (base.setRound((interestDou * subLong), 2, true)) + "";
		return cumulative;
	}

	/**
	 * 获取某行的元素
	 * @param num 行号
	 * @return 行元素
	 * @author 江渤洋 2015-12-1
	 */
	public By getRowValueInTabList(String num){
		By row = By.cssSelector("tbody > tr:nth-child(" + num +") td");
		base.checkElementVisible(row);
		return row;
	}
	
	/**
	 * 获取某行的值
	 * @param num 行号
	 * @return 一行的所有值
	 * @author 江渤洋 2015-12-1
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
	 * 检查一行中某列的值是否一致
	 * @param list 某行的值
	 * @param columnName 列名
	 * @param columnValue 列值
	 * @author 江渤洋
	 */
	public void checkColumnValueInRow(List<String> list, String columnName, String columnValue){
		int columnNum;
		columnNum = getColumnNumInTabList(columnName);
		base.assertEqualsActualExpected(list.get(columnNum), columnValue);
	}
	
	/**
	 * 获取某列的值
	 * @param columnName 列名
	 * @return 某列的值
	 * @author 江渤洋 2015-10-23
	 */
	private int getColumnNumInTabList(String columnName){
		
		int columnNum;
		switch (columnName) {
		case "序号":
			columnNum = 0;break;
		case "流水号":  
			columnNum = 1;break;
		case "收入金额": 
			columnNum = 2;break;
		case "支出金额": 
			columnNum = 3;break;
		case "余额":    
			columnNum = 4;break;
		case "操作时间":  
			columnNum = 5;break;
		case "说明":    
			columnNum = 6;break;
		default:
			columnNum = 0;break;
		}
		return columnNum;
	}
	
	/**
	 * 获取交易记录列表页中某列的值
	 * @param columnName 列名
	 * @return 某列的集合
	 * @author 江渤洋 2015-10-23
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
	 * 校验交易记录列表页中某列的值
	 * @param email 用户邮箱
	 * @param columnName 列名
	 * @author 江渤洋 2015-10-23
	 */
	public void checkColumnValueInTabList(String email, String columnName){
		
		List<String> list = new ArrayList<String>();
		list = getColumnValueInTabList(columnName);
		String interest = getInterest(email);//利息
		String Balance = interest;//余额
		
		if(columnName.equals("收入金额")){
			for (String listValue : list) {
				base.assertEqualsActualExpected(listValue, interest);
			}
		}
		else if(columnName.equals("支出金额")){
			for (String listValue : list) {
				base.assertEqualsActualExpected(listValue, "0");
			}
		}
		else if(columnName.equals("余额")){
			Collections.reverse(list);//倒序
			int length = list.size();
			for(int i = 0; i < length; i++){
				base.assertEqualsActualExpected(list.get(i), Balance);//校验每行余额是否正确
				if(i == length - 1){
					break;
				}
				else{
					Balance = (Float.valueOf(Balance) + Float.valueOf(interest)) + "";
				}
			}
			Balance = (Float.valueOf(Balance) + 9900) + "";
			//校验“可用余额”与交易记录中“余额”是否一致
			base.assertEqualsActualExpected(Balance, getAvailableBalance());
		}
	}
}
