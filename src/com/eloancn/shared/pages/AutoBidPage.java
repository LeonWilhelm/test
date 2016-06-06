package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.eloancn.shared.common.Base;

/*
 *  “我的账户”-“自动投标”页面
 */
public class AutoBidPage {
	Base base = new Base();
	
	public static By Main = By.cssSelector("div.g-main-c");
	public static By AutoBidSetLnk = By.id("autoTenderSet");			 //自动投标设置
	By FirstInfo = By.cssSelector("#tabList0>div");
	public static By SetRecordLnk = By.id("autoTenderRecord");			//条件设置记录
	public static By AutoBidRecordLnk = By.id("autoLendingMoney");		//自动投标记录	
	By ShowCloseStatus = By.id("showCloseDiv");
	By ShowCloseTxt = By.xpath("//div[@id='showCloseDiv']/p");
	By AutoBidBtn = By.cssSelector("input[type='button']");
	public static By AvailableBalanceTxt = By.cssSelector("td.wd150.textR");//账户可用余额文字
	public static By BalanceTxt = By.id("statField");					//余额
	public static By BalanceYuanTxt = By.id("statField2");				//余额
	By RateRangeTxt = By.id("showEditTable.1.0");						//等级范围
	
	//信用等级范围：
	By SelectLowLevel = By.id("objbu091"); 								//低等级选择框
	By LowLevelOptions = By.cssSelector("#objbu091>option");			//低等级选择项
	By SelectHighLevel = By.id("objbu092");								//高等级选择框
	By HighLevelOptions = By.cssSelector("#objbu092>option");			//高等级选择项
	By AnnualInterestTxt = By.cssSelector("td.wd150 textR");			//年利率本子
	By InputLowInterest = By.id("objbul21");							//低年利率输入框
	By InputHighInterest = By.id("objbul22");							//高年利率输入框
	By LoanTimeTxt = By.xpath("//table[@id='showEditTable']/tbody/tr[4]/td");//借款期限文字
	By ShortLoanTime = By.id("objbul41");								//最短借款期限
	By LongLoanTime = By.id("objbul42");								//最长借款期限
	
	By MatchPrincipalCheckbox = By.id("repaymenttype1");				//等额本金
	By MatchPICheckbox = By.id("repaymenttype2");						//等额本息
	By RepayPICheckbox = By.id("repaymenttype3");						//还本付息
	
	By BalanceBidRadio = By.id("wuxian_giveamount");					//余额投标
	By FixedAmountBidRadio = By.id("giveamount");								//固额投标
	
	By InputBidMoney = By.id("giveamount1");							//投标金额输入框
	By InputReservedAmount = By.id("minbalance");						//账户保留金额输入框
	By InputPayPwd = By.id("payPwd");									//支付密码输入框
	
	By OKBtn = By.xpath("//input[@value='确定']");						//确定按钮
	By CancelBtn = By.xpath("//input[@value='取消']");					//取消按钮
	
	//开启自动投标后的页面
	By AutoBidSuccessTxt = By.cssSelector("caption");					//自动投标设置状态已开启
	By RankValue = By.cssSelector("div.tbpm_num");						//排名的值
	By LevelValue = By.cssSelector("td.wd470");							//信用等级范围的值
	By InterestValue = By.xpath("//table[@id='showRecordTable']/tbody/tr[3]/td[2]");	//年利率的值
	By RepayModeValue = By.xpath("//table[@id='showRecordTable']/tbody/tr[4]/td[2]");	//还款方式的值
	By LoanTimeValue = By.xpath("//table[@id='showRecordTable']/tbody/tr[5]/td[2]");	//借款期限的值
	By BidModeValue = By.xpath("//table[@id='showRecordTable']/tbody/tr[6]/td[2]");		//参与方式的值
	By BidMoneyValue = By.cssSelector("#giveAmountID > td.wd470");
	By RemainAmountValue = By.xpath("//table[@id='showRecordTable']/tbody/tr[7]/td[2]");//余额投标下账户保留金额的值
	By RemainAmountValue1 = By.xpath("//table[@id='showRecordTable']/tbody/tr[8]/td[2]");//固定投标保留金额的值
	By CloseAutoBidBtn = By.cssSelector("input[type=\"button\"]");						//关闭自动投标按钮
	By UpdateAutoBidBtn = By.cssSelector("div.btn1 > input[type=\"button\"]");			//修改自动投标按钮	
	
	/**
	 * 徐天元
	 * 自动投标页面
	 */
	public void checkAutoBidPage(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(".current.wd140")), "自动投标设置");
	}
	
	//是否有权限设置自动投标
	public Boolean ifshowAutoBidSetLnk(){
		return base.isElementPresent(AutoBidSetLnk);
	}
	public Boolean ifAutoBidOpen(){
		boolean result = true;
		if(base.getLnkElementText(FirstInfo, "id").equals("tabList0")){
			result = false;
		}
		return result;
//		return base.isElementEmpty(ShowCloseStatus);
	}
	//点击“开启自动投标”按钮
	public void clickAutoBidBtn(){
		if(ifAutoBidOpen()){
			System.out.println("已开启自动投标！");
			clickCloseAutoBidBtn();
		}		
		//base.sleep(5000);
		base.clickWithWait(AutoBidBtn);
		base.checkElmentText(AvailableBalanceTxt, "账户可用余额：");
	}
	//检查“固额投标”数据
	public String checkFixedAmountBid(String MemberAPayPwd){
		selectLowLevel();
		InputLowInterest();
		InputHighInterest();
		selectShortLoanTime();
		selectLongLoanTime();
		checkMatchPI();
		checkRepayPI();
		chooseFixedAmountBid();
		InputBidMoney();
		String reserveMoney = InputReserveMoney();
		InputPayPwd(MemberAPayPwd);
		if (!clickOKBtn()) {
			reserveMoney = "900000";
		}
		verifyFixedAmountBid(reserveMoney);
		return reserveMoney;
	}
	//检查“余额投标”数据
	public void checkBalanceBid(String MemberAPayPwd){
		String Money = InputReserveMoney();
		InputPayPwd(MemberAPayPwd);
		clickOKBtn();
		verifyDefaultAutoBid(Money);
	}
	
	//选择最低信用等级“B”
	public void selectLowLevel(){
		base.checkElement(SelectLowLevel);
		base.elementSelectByVisibleText(SelectLowLevel,"B");
	}
	
	/*
	 * 选择最低信用等级
	 * 徐天元
	 */
	public void selectLowLevel(String levelTxt){
		base.checkElement(SelectLowLevel);
		base.elementSelectByVisibleText(SelectLowLevel,levelTxt);
	}

	//选择最高信用等级“AAA”，“AA+”。。。
	public void selectHighLevel(String value){
		base.checkElement(SelectHighLevel);
		base.elementSelectByVisibleText(SelectHighLevel, value);
	}
	
	/**
	 * xty 
	 * 校验等级显示
	 * type :low,校验低等级     high，校验高等级
	 * value：等级的值
	 */
	public void checkCreditRatingRange(String type,String value){
		String css = "";
		if (type.equals("low")) {
			css = "//*[@id='objbu091']";
		}else {
			css = "//*[@id='objbu092']";
		}
		base.assertTrueByBoolean(base.getElementWithWait(By.xpath(css+"/option[text()='"+value+"']")).isSelected());
	}
	
	//输入最低年利率18
	public void InputLowInterest(){
		base.elementSendkey(InputLowInterest, "18");
	}
	
	public void InputLowInterest(String value){
		base.elementSendkey(InputLowInterest, value);
	}
	
	//输入最高年利率18
	public void InputHighInterest(){
		base.elementSendkey(InputHighInterest, "18");
	}
	
	//输入最高年利率
	public void InputHighInterest(String value){
		base.elementSendkey(InputHighInterest, value);
	}
	
	/**
	 * xty 校验利率值
	 * @param type  high:最高利率  low:最低利率
	 * @param value 利率值
	 */
	public void checkInterest(String type,String value){
		if (type.equals("high")) {
			base.assertEqualsActualExpected(base.getAttribute(InputHighInterest, "value"), value);
		}else {
			base.assertEqualsActualExpected(base.getAttribute(InputLowInterest, "value"), value);
		}
	}
	//选择最短借款期限
	public void selectShortLoanTime(){
		base.elementSelectByVisibleText(ShortLoanTime, "6个月");		
	}
	
	public void selectShortLoanTime(String month){
		base.elementSelectByVisibleText(ShortLoanTime, month+"个月");		
	}
	
	//选择最长借款期限
	public void selectLongLoanTime(){
		base.elementSelectByVisibleText(LongLoanTime, "12个月");		
	}
	
	public void selectLongLoanTime(String month){
		base.elementSelectByVisibleText(LongLoanTime, month+"个月");		
	}
	
	/**
	 * xty 校验期限值
	 * @param type  high:最高期限  low:最低期限
	 * @param value 期限值
	 */
	public void checkLoanTime(String type,String value){
		if (type.equals("short")) {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath(".//select[@id='objbul41']/option[text()='"+value+"个月']")).isSelected());
		}else {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath(".//select[@id='objbul42']/option[text()='"+value+"个月']")).isSelected());
		}
	}
	
	//选择“还款方式”为“等额本金”
	public void checkMatchPrincipal(){
		base.clickElementNoWait(MatchPrincipalCheckbox);
	}
	//选择“还款方式”为“等额本息”
	public void checkMatchPI(){
		base.clickElementNoWait(MatchPICheckbox);
	}
	//选择“还款方式”为“还本付息 ”
	public void checkRepayPI(){
		base.clickElementNoWait(RepayPICheckbox);
	}
	
	/**
	 * xty 校验还款方式
	 * @param type  等额本金 等额本息 还本付息
	 */
	public void checkRepaymentMethod(String type){
		By by = null;
		if(type.equals("等额本金")){
			by = MatchPrincipalCheckbox;
		}else if(type.equals("等额本息")){
			by = MatchPICheckbox;
		}else {
			by = RepayPICheckbox;
		}
		base.assertTrueByBoolean(base.getElementWithWait(by).isSelected());
	}
	
	//选择“余额投标”
	public void chooseBalanceBid(){
		base.clickElementNoWait(BalanceBidRadio);
	}
	//选择“固额投标”
	public void chooseFixedAmountBid(){
		base.clickElementNoWait(FixedAmountBidRadio);
		base.checkElement(InputBidMoney);
	}
	
	/**
	 * xty 校验参与方式
	 * @param type  余额 固额
	 */
	public void checkParticipationMode(String type){
		if (type.equals("余额")) {
			base.assertTrueByBoolean(base.getElementWithWait(BalanceBidRadio).isSelected());
			base.assertTrueByBoolean(!base.getElementWithWait(FixedAmountBidRadio).isSelected());
		}else {
			base.assertTrueByBoolean(base.getElementWithWait(FixedAmountBidRadio).isSelected());
			base.assertTrueByBoolean(!base.getElementWithWait(BalanceBidRadio).isSelected());
		}
	}
	
	//输入固额投标中的投标金额
	public void InputBidMoney(){
		base.elementSendkey(InputBidMoney, "50");
	}
	
	//输入固额投标中的投标金额
	public void InputBidMoney(String value){
		base.elementSendkey(InputBidMoney, value);
	}
	
	/**
	 * 徐天元
	 * 校验投标金额
	 */
	public void checkBidMoney(String value){
		base.assertEqualsActualExpected(base.getAttribute(InputBidMoney, "value"), value);
	}
		
	//输入账户保留金额
	public String InputReserveMoney(){
		int BalanceNum = getBalance();
		base.sendKeyAndWait(InputReservedAmount, String.valueOf(BalanceNum-10));
		return String.valueOf(BalanceNum-10);
	}
	
	public String getReserveMoney(){
		return base.getAttributeWithVisible(InputReservedAmount,"value");
	}
	
	public int getBalance(){
		String Balance = "";
		for (int i = 0; i < 5; i++) {
			Balance = base.getElementTextWithWait(BalanceTxt);
			if (Balance.equals("")) {
				base.sleep(3000);
			}else {
				break;
			}
		}
		if(Balance.contains(".")){
			Balance = Balance.split("\\.")[0].replaceAll(",", "");
		}
		int BalanceNum = Integer.valueOf(Balance).intValue();
		return BalanceNum;
	}
	
	/**
	 * 输入账户保留金额
	 * @param money
	 * 徐天元
	 */
	public void inputReserveMoney(String money){
		if (money.equals("big")) {
			String Balance = "";
			for (int i = 0; i < 5; i++) {
				Balance = base.getElementTextWithWait(BalanceTxt);
				if (Balance.equals("")) {
					base.sleep(3000);
				}else {
					break;
				}
			}
			if(Balance.contains(".")){
				Balance = Balance.split("\\.")[0].replaceAll(",", "");
			}
			int BalanceNum = Integer.valueOf(Balance).intValue();
			money = (BalanceNum + 10)+"";
		}
		base.sendKeyAndWait(InputReservedAmount, money);
	}
	
	/**
	 * 校验账户保留金额是否和预期一致
	 * @param money
	 * 徐天元
	 */
	public void checkReserveMoney(String money){
		base.assertEqualsActualExpected(base.getElementTextWithWait(InputReservedAmount), money);
	}
		
	//输入支付密码
	public void InputPayPwd(String pwd){
		base.elementSendkey(InputPayPwd, pwd);
	}
	
	//输入支付密码
	public void checkPayPwd(String pwd){
		base.assertEqualsActualExpected(base.getElementTextWithWait(InputPayPwd), pwd);
	}
		
	//点击“确定”按钮
	public boolean clickOKBtn(){
		boolean result = true;
		base.clickElementNoWait(OKBtn);
		Alert open = base.getAlertwithWait();
		System.out.println(open.getText());
		if (open.getText().equals("对不起，您输入账户保留金额数额过大！")) {
			open.accept();
			base.sendKeyAndWait(InputReservedAmount, String.valueOf(900000));
			base.clickElementNoWait(OKBtn);
			System.out.println("账户保留金额已设为："+900000);
			result = false;
		}
		base.assertEqualsActualExpected(open.getText(), "开启自动投标成功");
		open.accept();
		base.checkElmentText(AutoBidSuccessTxt, "自动投标设置状态已开启");
		return result;
	}
	
	/**
	 * 点击“确定”按钮
	 * 徐天元
	 */
	public void clickOKBtn(String msg){
		base.clickElementNoWait(OKBtn);
		Alert open = base.getAlertwithWait();
		base.assertEqualsActualExpected(open.getText(), msg);
		open.accept();
	}
		
	//点击“取消”按钮
	public void clickCancelBtn(){
		base.clickElementNoWait(CancelBtn);
	}
	//点击“关闭自动投标”
	public void clickCloseAutoBidBtn(){
		Alert close = closeConfirm();
		close.accept();
		Alert success = base.getAlertwithWait();
		base.assertEqualsActualExpected(success.getText(), "操作成功！");
		success.accept();
		base.checkElmentText(ShowCloseTxt, "自动投标状态：关闭状态");
//		base.checkElement(ShowCloseStatus);
	}
	
	public Alert closeConfirm(){
		base.clickWithWait(CloseAutoBidBtn);
		Alert close = base.getAlertwithWait();
		base.assertEqualsActualExpected(close.getText(), "您确定要关闭自动投标吗？");
		return close;
	}
	
	//验证开启自动投标的数据
	public void verifyDefaultAutoBid(String remainAmount){
		
		String Rank = base.getElementText(RankValue);
		String Num = Rank.substring(0,Rank.length()-1);
		int num = Integer.valueOf(Num).intValue();
		if(num<=0){
			Assert.fail("排名显示异常，不能为负数！");
		}
		base.assertEqualsActualExpected(base.getElementText(LevelValue),"HR-AAA");
		base.assertEqualsActualExpected(base.getElementText(InterestValue), "10-22%");
		base.assertEqualsActualExpected(base.getElementText(RepayModeValue), "等额本金，等额本息，还本付息");
		base.assertEqualsActualExpected(base.getElementText(LoanTimeValue), "2个月-24个月");
		base.assertEqualsActualExpected(base.getElementText(BidModeValue), "余额投标");
		String Amount = base.getElementText(RemainAmountValue);
		if(Amount.contains(",")){
			Amount = Amount.replace(",", "");
		}
		base.assertEqualsActualExpected(Amount, remainAmount+"元");
		base.assertEqualsActualExpected(base.getLnkElementText(CloseAutoBidBtn, "value"), "关闭自动投标");
		base.assertEqualsActualExpected(base.getLnkElementText(UpdateAutoBidBtn, "value"), "修改自动投标");
	}
	//验证开启固额投标的数据
	public void verifyFixedAmountBid(String reserveMoney){
		String Rank = base.getElementText(RankValue);
		System.out.println("排名："+Rank);
		String Num = Rank.substring(0,Rank.length()-1);
		int num = Integer.valueOf(Num).intValue();
		if(num<=0){
			Assert.fail("排名显示异常，不能为负数！");
		}
		base.assertEqualsActualExpected(base.getElementText(LevelValue),"B-AAA");
		base.assertEqualsActualExpected(base.getElementText(InterestValue), "18%");
		base.assertEqualsActualExpected(base.getElementText(RepayModeValue), "等额本息,还本付息");
		base.assertEqualsActualExpected(base.getElementText(LoanTimeValue), "6个月-12个月");
		base.assertEqualsActualExpected(base.getElementText(BidModeValue), "固额投标");
		base.assertEqualsActualExpected(base.getElementText(BidMoneyValue), "50元");
		base.assertEqualsActualExpected(base.getElementText(RemainAmountValue1).replaceAll(",", "").replaceAll("元", ""), reserveMoney);
		base.assertEqualsActualExpected(base.getLnkElementText(CloseAutoBidBtn, "value"), "关闭自动投标");
		base.assertEqualsActualExpected(base.getLnkElementText(UpdateAutoBidBtn, "value"), "修改自动投标");
	}
	
	public void verifyFixedAmountBid(String values[]){
		String Rank = base.getElementText(RankValue);
		System.out.println("排名："+Rank);
		String Num = Rank.substring(0,Rank.length()-1);
		int num = Integer.valueOf(Num).intValue();
		if(num<=0){
			Assert.fail("排名显示异常，不能为负数！");
		}
		base.assertEqualsActualExpected(base.getElementText(LevelValue),values[0]);
		base.assertEqualsActualExpected(base.getElementText(InterestValue), values[1]);
		base.assertEqualsActualExpected(base.getElementText(RepayModeValue), values[2]);
		base.assertEqualsActualExpected(base.getElementText(LoanTimeValue), values[3]);
		base.assertEqualsActualExpected(base.getElementText(BidModeValue), values[4]);
		base.assertEqualsActualExpected(base.getElementText(BidMoneyValue), values[5]);
		base.assertEqualsActualExpected(base.getElementText(RemainAmountValue1).replaceAll(",", "").replaceAll("元", ""), values[6].replaceAll(",", ""));
		base.assertEqualsActualExpected(base.getLnkElementText(CloseAutoBidBtn, "value"), "关闭自动投标");
		base.assertEqualsActualExpected(base.getLnkElementText(UpdateAutoBidBtn, "value"), "修改自动投标");
	}
	
	//验证自动投标的初始化数据
	public void verifyAutoBidSet(double balance){
		//标题
		String expextedTitles[] = {"账户可用余额：","信用等级范围：","年利率：","借款期限：","还款方式：","参与方式：","","账户保留金额：","支付密码："};
		List<WebElement> titles = base.getElements(By.cssSelector(".textR"));
		for (int i = 0; i < titles.size(); i++) {
			base.assertEqualsActualExpected(titles.get(i).getText(), expextedTitles[i]);
		}
		//账户余额
		base.assertTrueBy(BalanceYuanTxt);
		String showBalance = "";
		for (int i = 0; i < 5; i++) {
			showBalance = base.getElementTextWithWait(By.cssSelector("#statField"));
			if (showBalance.equals("")) {
				base.sleep(2000);
			}else {
				break;
			}
		}
		System.out.println("#statField:"+showBalance+","+balance);
		base.assertEqualsActualExpected(base.roundingMoney(Double.parseDouble(showBalance)), base.roundingMoney(balance));
		//等级范围
		String [] Levels = {"HR", "D", "C", "C+", "CC", "CC+", "B", "B+", "BB", "BB+", "A", "A+", "AA", "AA+", "AAA"};
		String [] subLevels = {"AAA", "AA+", "AA", "A+", "A", "BB+", "BB", "B+", "B", "CC+", "CC", "C+", "C", "D", "HR"};
		List<WebElement> LevelOption = base.getElements(LowLevelOptions);
		List<WebElement> subLevelOption = base.getElements(HighLevelOptions);
		for(int i=0; i<LevelOption.size();i++){
			base.assertEqualsActualExpected(LevelOption.get(i).getText(),Levels[i]);
			base.assertEqualsActualExpected(subLevelOption.get(i).getText(),subLevels[i]);
		}
		//年利率
		base.assertEqualsActualExpected(base.getLnkElementText(InputLowInterest, "value"),"10");
		base.assertEqualsActualExpected(base.getLnkElementText(InputHighInterest, "value"),"22");	
		//借款期限
		String qixians[] = {"2","3","4","5","6","7","8","9","10","11","12","15","18","21","24"};
		List<WebElement> qiXianStart = base.getElements(By.cssSelector("#objbul41 option"));
		List<WebElement> qiXianEnd = base.getElements(By.cssSelector("#objbul42 option"));
		for (int i = 0; i < qiXianStart.size(); i++) {
			base.assertEqualsActualExpected(qiXianStart.get(i).getText(),qixians[i]+"个月");
			base.assertEqualsActualExpected(qiXianEnd.get(i).getText(),qixians[14-i]+"个月");
		}
		//还款方式都未选中
		List<WebElement> hkfs = base.getElements(By.cssSelector("input[type='checkbox']"));
		List<WebElement> hkfsName = base.getElements(By.cssSelector(".wd300>label>label"));
		String names[] = {"等额本金","等额本息","还本付息"};
		for (int i = 0; i < hkfs.size(); i++) {
			base.assertEqualsActualExpectedByBoolean(hkfs.get(i).isSelected(), false);
			base.assertEqualsActualExpected(hkfsName.get(i).getText(), names[i]);
		}
		//账户保余额
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#minbalance")), "");
		//支付密码
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#payPwd")), "");
	}
	
	/**
	 * xty 
	 * 校验密码长度
	 */
	public void checkPwdLength(){
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(By.cssSelector("#payPwd"), "maxlength", "20"), true);
	}
	
	/**
	 * xty
	 * 修改自动投标
	 */
	public void clickUpdate(){
		base.clickWithWait(By.cssSelector("#showRecordTable input[value='修改自动投标']"));
	}
	
	public void checkEdit(boolean result){
		if (result) {
			base.assertTrueByBoolean(base.getAttribute(By.cssSelector("#showRecordTable"), "class").contains("hide"));
		}else {
			base.assertTrueByBoolean(base.getAttribute(By.cssSelector("#showEditTable"), "class").contains("hide"));
		}
		
	}
}
