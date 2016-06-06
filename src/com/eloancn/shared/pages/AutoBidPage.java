package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.eloancn.shared.common.Base;

/*
 *  ���ҵ��˻���-���Զ�Ͷ�ꡱҳ��
 */
public class AutoBidPage {
	Base base = new Base();
	
	public static By Main = By.cssSelector("div.g-main-c");
	public static By AutoBidSetLnk = By.id("autoTenderSet");			 //�Զ�Ͷ������
	By FirstInfo = By.cssSelector("#tabList0>div");
	public static By SetRecordLnk = By.id("autoTenderRecord");			//�������ü�¼
	public static By AutoBidRecordLnk = By.id("autoLendingMoney");		//�Զ�Ͷ���¼	
	By ShowCloseStatus = By.id("showCloseDiv");
	By ShowCloseTxt = By.xpath("//div[@id='showCloseDiv']/p");
	By AutoBidBtn = By.cssSelector("input[type='button']");
	public static By AvailableBalanceTxt = By.cssSelector("td.wd150.textR");//�˻������������
	public static By BalanceTxt = By.id("statField");					//���
	public static By BalanceYuanTxt = By.id("statField2");				//���
	By RateRangeTxt = By.id("showEditTable.1.0");						//�ȼ���Χ
	
	//���õȼ���Χ��
	By SelectLowLevel = By.id("objbu091"); 								//�͵ȼ�ѡ���
	By LowLevelOptions = By.cssSelector("#objbu091>option");			//�͵ȼ�ѡ����
	By SelectHighLevel = By.id("objbu092");								//�ߵȼ�ѡ���
	By HighLevelOptions = By.cssSelector("#objbu092>option");			//�ߵȼ�ѡ����
	By AnnualInterestTxt = By.cssSelector("td.wd150 textR");			//�����ʱ���
	By InputLowInterest = By.id("objbul21");							//�������������
	By InputHighInterest = By.id("objbul22");							//�������������
	By LoanTimeTxt = By.xpath("//table[@id='showEditTable']/tbody/tr[4]/td");//�����������
	By ShortLoanTime = By.id("objbul41");								//��̽������
	By LongLoanTime = By.id("objbul42");								//��������
	
	By MatchPrincipalCheckbox = By.id("repaymenttype1");				//�ȶ��
	By MatchPICheckbox = By.id("repaymenttype2");						//�ȶϢ
	By RepayPICheckbox = By.id("repaymenttype3");						//������Ϣ
	
	By BalanceBidRadio = By.id("wuxian_giveamount");					//���Ͷ��
	By FixedAmountBidRadio = By.id("giveamount");								//�̶�Ͷ��
	
	By InputBidMoney = By.id("giveamount1");							//Ͷ���������
	By InputReservedAmount = By.id("minbalance");						//�˻�������������
	By InputPayPwd = By.id("payPwd");									//֧�����������
	
	By OKBtn = By.xpath("//input[@value='ȷ��']");						//ȷ����ť
	By CancelBtn = By.xpath("//input[@value='ȡ��']");					//ȡ����ť
	
	//�����Զ�Ͷ����ҳ��
	By AutoBidSuccessTxt = By.cssSelector("caption");					//�Զ�Ͷ������״̬�ѿ���
	By RankValue = By.cssSelector("div.tbpm_num");						//������ֵ
	By LevelValue = By.cssSelector("td.wd470");							//���õȼ���Χ��ֵ
	By InterestValue = By.xpath("//table[@id='showRecordTable']/tbody/tr[3]/td[2]");	//�����ʵ�ֵ
	By RepayModeValue = By.xpath("//table[@id='showRecordTable']/tbody/tr[4]/td[2]");	//���ʽ��ֵ
	By LoanTimeValue = By.xpath("//table[@id='showRecordTable']/tbody/tr[5]/td[2]");	//������޵�ֵ
	By BidModeValue = By.xpath("//table[@id='showRecordTable']/tbody/tr[6]/td[2]");		//���뷽ʽ��ֵ
	By BidMoneyValue = By.cssSelector("#giveAmountID > td.wd470");
	By RemainAmountValue = By.xpath("//table[@id='showRecordTable']/tbody/tr[7]/td[2]");//���Ͷ�����˻���������ֵ
	By RemainAmountValue1 = By.xpath("//table[@id='showRecordTable']/tbody/tr[8]/td[2]");//�̶�Ͷ�걣������ֵ
	By CloseAutoBidBtn = By.cssSelector("input[type=\"button\"]");						//�ر��Զ�Ͷ�갴ť
	By UpdateAutoBidBtn = By.cssSelector("div.btn1 > input[type=\"button\"]");			//�޸��Զ�Ͷ�갴ť	
	
	/**
	 * ����Ԫ
	 * �Զ�Ͷ��ҳ��
	 */
	public void checkAutoBidPage(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(".current.wd140")), "�Զ�Ͷ������");
	}
	
	//�Ƿ���Ȩ�������Զ�Ͷ��
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
	//����������Զ�Ͷ�ꡱ��ť
	public void clickAutoBidBtn(){
		if(ifAutoBidOpen()){
			System.out.println("�ѿ����Զ�Ͷ�꣡");
			clickCloseAutoBidBtn();
		}		
		//base.sleep(5000);
		base.clickWithWait(AutoBidBtn);
		base.checkElmentText(AvailableBalanceTxt, "�˻�������");
	}
	//��顰�̶�Ͷ�ꡱ����
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
	//��顰���Ͷ�ꡱ����
	public void checkBalanceBid(String MemberAPayPwd){
		String Money = InputReserveMoney();
		InputPayPwd(MemberAPayPwd);
		clickOKBtn();
		verifyDefaultAutoBid(Money);
	}
	
	//ѡ��������õȼ���B��
	public void selectLowLevel(){
		base.checkElement(SelectLowLevel);
		base.elementSelectByVisibleText(SelectLowLevel,"B");
	}
	
	/*
	 * ѡ��������õȼ�
	 * ����Ԫ
	 */
	public void selectLowLevel(String levelTxt){
		base.checkElement(SelectLowLevel);
		base.elementSelectByVisibleText(SelectLowLevel,levelTxt);
	}

	//ѡ��������õȼ���AAA������AA+��������
	public void selectHighLevel(String value){
		base.checkElement(SelectHighLevel);
		base.elementSelectByVisibleText(SelectHighLevel, value);
	}
	
	/**
	 * xty 
	 * У��ȼ���ʾ
	 * type :low,У��͵ȼ�     high��У��ߵȼ�
	 * value���ȼ���ֵ
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
	
	//�������������18
	public void InputLowInterest(){
		base.elementSendkey(InputLowInterest, "18");
	}
	
	public void InputLowInterest(String value){
		base.elementSendkey(InputLowInterest, value);
	}
	
	//�������������18
	public void InputHighInterest(){
		base.elementSendkey(InputHighInterest, "18");
	}
	
	//�������������
	public void InputHighInterest(String value){
		base.elementSendkey(InputHighInterest, value);
	}
	
	/**
	 * xty У������ֵ
	 * @param type  high:�������  low:�������
	 * @param value ����ֵ
	 */
	public void checkInterest(String type,String value){
		if (type.equals("high")) {
			base.assertEqualsActualExpected(base.getAttribute(InputHighInterest, "value"), value);
		}else {
			base.assertEqualsActualExpected(base.getAttribute(InputLowInterest, "value"), value);
		}
	}
	//ѡ����̽������
	public void selectShortLoanTime(){
		base.elementSelectByVisibleText(ShortLoanTime, "6����");		
	}
	
	public void selectShortLoanTime(String month){
		base.elementSelectByVisibleText(ShortLoanTime, month+"����");		
	}
	
	//ѡ����������
	public void selectLongLoanTime(){
		base.elementSelectByVisibleText(LongLoanTime, "12����");		
	}
	
	public void selectLongLoanTime(String month){
		base.elementSelectByVisibleText(LongLoanTime, month+"����");		
	}
	
	/**
	 * xty У������ֵ
	 * @param type  high:�������  low:�������
	 * @param value ����ֵ
	 */
	public void checkLoanTime(String type,String value){
		if (type.equals("short")) {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath(".//select[@id='objbul41']/option[text()='"+value+"����']")).isSelected());
		}else {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath(".//select[@id='objbul42']/option[text()='"+value+"����']")).isSelected());
		}
	}
	
	//ѡ�񡰻��ʽ��Ϊ���ȶ��
	public void checkMatchPrincipal(){
		base.clickElementNoWait(MatchPrincipalCheckbox);
	}
	//ѡ�񡰻��ʽ��Ϊ���ȶϢ��
	public void checkMatchPI(){
		base.clickElementNoWait(MatchPICheckbox);
	}
	//ѡ�񡰻��ʽ��Ϊ��������Ϣ ��
	public void checkRepayPI(){
		base.clickElementNoWait(RepayPICheckbox);
	}
	
	/**
	 * xty У�黹�ʽ
	 * @param type  �ȶ�� �ȶϢ ������Ϣ
	 */
	public void checkRepaymentMethod(String type){
		By by = null;
		if(type.equals("�ȶ��")){
			by = MatchPrincipalCheckbox;
		}else if(type.equals("�ȶϢ")){
			by = MatchPICheckbox;
		}else {
			by = RepayPICheckbox;
		}
		base.assertTrueByBoolean(base.getElementWithWait(by).isSelected());
	}
	
	//ѡ�����Ͷ�ꡱ
	public void chooseBalanceBid(){
		base.clickElementNoWait(BalanceBidRadio);
	}
	//ѡ�񡰹̶�Ͷ�ꡱ
	public void chooseFixedAmountBid(){
		base.clickElementNoWait(FixedAmountBidRadio);
		base.checkElement(InputBidMoney);
	}
	
	/**
	 * xty У����뷽ʽ
	 * @param type  ��� �̶�
	 */
	public void checkParticipationMode(String type){
		if (type.equals("���")) {
			base.assertTrueByBoolean(base.getElementWithWait(BalanceBidRadio).isSelected());
			base.assertTrueByBoolean(!base.getElementWithWait(FixedAmountBidRadio).isSelected());
		}else {
			base.assertTrueByBoolean(base.getElementWithWait(FixedAmountBidRadio).isSelected());
			base.assertTrueByBoolean(!base.getElementWithWait(BalanceBidRadio).isSelected());
		}
	}
	
	//����̶�Ͷ���е�Ͷ����
	public void InputBidMoney(){
		base.elementSendkey(InputBidMoney, "50");
	}
	
	//����̶�Ͷ���е�Ͷ����
	public void InputBidMoney(String value){
		base.elementSendkey(InputBidMoney, value);
	}
	
	/**
	 * ����Ԫ
	 * У��Ͷ����
	 */
	public void checkBidMoney(String value){
		base.assertEqualsActualExpected(base.getAttribute(InputBidMoney, "value"), value);
	}
		
	//�����˻��������
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
	 * �����˻��������
	 * @param money
	 * ����Ԫ
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
	 * У���˻���������Ƿ��Ԥ��һ��
	 * @param money
	 * ����Ԫ
	 */
	public void checkReserveMoney(String money){
		base.assertEqualsActualExpected(base.getElementTextWithWait(InputReservedAmount), money);
	}
		
	//����֧������
	public void InputPayPwd(String pwd){
		base.elementSendkey(InputPayPwd, pwd);
	}
	
	//����֧������
	public void checkPayPwd(String pwd){
		base.assertEqualsActualExpected(base.getElementTextWithWait(InputPayPwd), pwd);
	}
		
	//�����ȷ������ť
	public boolean clickOKBtn(){
		boolean result = true;
		base.clickElementNoWait(OKBtn);
		Alert open = base.getAlertwithWait();
		System.out.println(open.getText());
		if (open.getText().equals("�Բ����������˻���������������")) {
			open.accept();
			base.sendKeyAndWait(InputReservedAmount, String.valueOf(900000));
			base.clickElementNoWait(OKBtn);
			System.out.println("�˻������������Ϊ��"+900000);
			result = false;
		}
		base.assertEqualsActualExpected(open.getText(), "�����Զ�Ͷ��ɹ�");
		open.accept();
		base.checkElmentText(AutoBidSuccessTxt, "�Զ�Ͷ������״̬�ѿ���");
		return result;
	}
	
	/**
	 * �����ȷ������ť
	 * ����Ԫ
	 */
	public void clickOKBtn(String msg){
		base.clickElementNoWait(OKBtn);
		Alert open = base.getAlertwithWait();
		base.assertEqualsActualExpected(open.getText(), msg);
		open.accept();
	}
		
	//�����ȡ������ť
	public void clickCancelBtn(){
		base.clickElementNoWait(CancelBtn);
	}
	//������ر��Զ�Ͷ�ꡱ
	public void clickCloseAutoBidBtn(){
		Alert close = closeConfirm();
		close.accept();
		Alert success = base.getAlertwithWait();
		base.assertEqualsActualExpected(success.getText(), "�����ɹ���");
		success.accept();
		base.checkElmentText(ShowCloseTxt, "�Զ�Ͷ��״̬���ر�״̬");
//		base.checkElement(ShowCloseStatus);
	}
	
	public Alert closeConfirm(){
		base.clickWithWait(CloseAutoBidBtn);
		Alert close = base.getAlertwithWait();
		base.assertEqualsActualExpected(close.getText(), "��ȷ��Ҫ�ر��Զ�Ͷ����");
		return close;
	}
	
	//��֤�����Զ�Ͷ�������
	public void verifyDefaultAutoBid(String remainAmount){
		
		String Rank = base.getElementText(RankValue);
		String Num = Rank.substring(0,Rank.length()-1);
		int num = Integer.valueOf(Num).intValue();
		if(num<=0){
			Assert.fail("������ʾ�쳣������Ϊ������");
		}
		base.assertEqualsActualExpected(base.getElementText(LevelValue),"HR-AAA");
		base.assertEqualsActualExpected(base.getElementText(InterestValue), "10-22%");
		base.assertEqualsActualExpected(base.getElementText(RepayModeValue), "�ȶ�𣬵ȶϢ��������Ϣ");
		base.assertEqualsActualExpected(base.getElementText(LoanTimeValue), "2����-24����");
		base.assertEqualsActualExpected(base.getElementText(BidModeValue), "���Ͷ��");
		String Amount = base.getElementText(RemainAmountValue);
		if(Amount.contains(",")){
			Amount = Amount.replace(",", "");
		}
		base.assertEqualsActualExpected(Amount, remainAmount+"Ԫ");
		base.assertEqualsActualExpected(base.getLnkElementText(CloseAutoBidBtn, "value"), "�ر��Զ�Ͷ��");
		base.assertEqualsActualExpected(base.getLnkElementText(UpdateAutoBidBtn, "value"), "�޸��Զ�Ͷ��");
	}
	//��֤�����̶�Ͷ�������
	public void verifyFixedAmountBid(String reserveMoney){
		String Rank = base.getElementText(RankValue);
		System.out.println("������"+Rank);
		String Num = Rank.substring(0,Rank.length()-1);
		int num = Integer.valueOf(Num).intValue();
		if(num<=0){
			Assert.fail("������ʾ�쳣������Ϊ������");
		}
		base.assertEqualsActualExpected(base.getElementText(LevelValue),"B-AAA");
		base.assertEqualsActualExpected(base.getElementText(InterestValue), "18%");
		base.assertEqualsActualExpected(base.getElementText(RepayModeValue), "�ȶϢ,������Ϣ");
		base.assertEqualsActualExpected(base.getElementText(LoanTimeValue), "6����-12����");
		base.assertEqualsActualExpected(base.getElementText(BidModeValue), "�̶�Ͷ��");
		base.assertEqualsActualExpected(base.getElementText(BidMoneyValue), "50Ԫ");
		base.assertEqualsActualExpected(base.getElementText(RemainAmountValue1).replaceAll(",", "").replaceAll("Ԫ", ""), reserveMoney);
		base.assertEqualsActualExpected(base.getLnkElementText(CloseAutoBidBtn, "value"), "�ر��Զ�Ͷ��");
		base.assertEqualsActualExpected(base.getLnkElementText(UpdateAutoBidBtn, "value"), "�޸��Զ�Ͷ��");
	}
	
	public void verifyFixedAmountBid(String values[]){
		String Rank = base.getElementText(RankValue);
		System.out.println("������"+Rank);
		String Num = Rank.substring(0,Rank.length()-1);
		int num = Integer.valueOf(Num).intValue();
		if(num<=0){
			Assert.fail("������ʾ�쳣������Ϊ������");
		}
		base.assertEqualsActualExpected(base.getElementText(LevelValue),values[0]);
		base.assertEqualsActualExpected(base.getElementText(InterestValue), values[1]);
		base.assertEqualsActualExpected(base.getElementText(RepayModeValue), values[2]);
		base.assertEqualsActualExpected(base.getElementText(LoanTimeValue), values[3]);
		base.assertEqualsActualExpected(base.getElementText(BidModeValue), values[4]);
		base.assertEqualsActualExpected(base.getElementText(BidMoneyValue), values[5]);
		base.assertEqualsActualExpected(base.getElementText(RemainAmountValue1).replaceAll(",", "").replaceAll("Ԫ", ""), values[6].replaceAll(",", ""));
		base.assertEqualsActualExpected(base.getLnkElementText(CloseAutoBidBtn, "value"), "�ر��Զ�Ͷ��");
		base.assertEqualsActualExpected(base.getLnkElementText(UpdateAutoBidBtn, "value"), "�޸��Զ�Ͷ��");
	}
	
	//��֤�Զ�Ͷ��ĳ�ʼ������
	public void verifyAutoBidSet(double balance){
		//����
		String expextedTitles[] = {"�˻�������","���õȼ���Χ��","�����ʣ�","������ޣ�","���ʽ��","���뷽ʽ��","","�˻�������","֧�����룺"};
		List<WebElement> titles = base.getElements(By.cssSelector(".textR"));
		for (int i = 0; i < titles.size(); i++) {
			base.assertEqualsActualExpected(titles.get(i).getText(), expextedTitles[i]);
		}
		//�˻����
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
		//�ȼ���Χ
		String [] Levels = {"HR", "D", "C", "C+", "CC", "CC+", "B", "B+", "BB", "BB+", "A", "A+", "AA", "AA+", "AAA"};
		String [] subLevels = {"AAA", "AA+", "AA", "A+", "A", "BB+", "BB", "B+", "B", "CC+", "CC", "C+", "C", "D", "HR"};
		List<WebElement> LevelOption = base.getElements(LowLevelOptions);
		List<WebElement> subLevelOption = base.getElements(HighLevelOptions);
		for(int i=0; i<LevelOption.size();i++){
			base.assertEqualsActualExpected(LevelOption.get(i).getText(),Levels[i]);
			base.assertEqualsActualExpected(subLevelOption.get(i).getText(),subLevels[i]);
		}
		//������
		base.assertEqualsActualExpected(base.getLnkElementText(InputLowInterest, "value"),"10");
		base.assertEqualsActualExpected(base.getLnkElementText(InputHighInterest, "value"),"22");	
		//�������
		String qixians[] = {"2","3","4","5","6","7","8","9","10","11","12","15","18","21","24"};
		List<WebElement> qiXianStart = base.getElements(By.cssSelector("#objbul41 option"));
		List<WebElement> qiXianEnd = base.getElements(By.cssSelector("#objbul42 option"));
		for (int i = 0; i < qiXianStart.size(); i++) {
			base.assertEqualsActualExpected(qiXianStart.get(i).getText(),qixians[i]+"����");
			base.assertEqualsActualExpected(qiXianEnd.get(i).getText(),qixians[14-i]+"����");
		}
		//���ʽ��δѡ��
		List<WebElement> hkfs = base.getElements(By.cssSelector("input[type='checkbox']"));
		List<WebElement> hkfsName = base.getElements(By.cssSelector(".wd300>label>label"));
		String names[] = {"�ȶ��","�ȶϢ","������Ϣ"};
		for (int i = 0; i < hkfs.size(); i++) {
			base.assertEqualsActualExpectedByBoolean(hkfs.get(i).isSelected(), false);
			base.assertEqualsActualExpected(hkfsName.get(i).getText(), names[i]);
		}
		//�˻������
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#minbalance")), "");
		//֧������
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#payPwd")), "");
	}
	
	/**
	 * xty 
	 * У�����볤��
	 */
	public void checkPwdLength(){
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(By.cssSelector("#payPwd"), "maxlength", "20"), true);
	}
	
	/**
	 * xty
	 * �޸��Զ�Ͷ��
	 */
	public void clickUpdate(){
		base.clickWithWait(By.cssSelector("#showRecordTable input[value='�޸��Զ�Ͷ��']"));
	}
	
	public void checkEdit(boolean result){
		if (result) {
			base.assertTrueByBoolean(base.getAttribute(By.cssSelector("#showRecordTable"), "class").contains("hide"));
		}else {
			base.assertTrueByBoolean(base.getAttribute(By.cssSelector("#showEditTable"), "class").contains("hide"));
		}
		
	}
}
