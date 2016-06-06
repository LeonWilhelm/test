package com.eloancn.shared.pages;

import java.io.File;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
/*
 * ���ҵ��˻���-����ȫ��֤��ҳ��
 */
public class SecurityAuthPage {
	Base base = new Base();
	DBData dbData = new DBData();
	
	List<WebElement> bankLists;
	
	public static By SecurityAuthTxt = By.cssSelector("div.newtitle.notice>h3");
	/*********************���п�����********************/
	
	public By accountModeBtn = By.id("accountMode");                            //���п�����
	public By addBackDiv = By.cssSelector("#bankcardDiv");                             //������п���
	By addBankBtn = By.cssSelector(".addbank");                                 //�������п�
	By accountTxt = By.id("account");                                           //���п���
	By bankTypeSel = By.id("type");                                             //����
	By provinceSel = By.id("province");                                         //ʡ
	By citySel = By.id("city");                                                 //��
	By bankNameTxt = By.id("bankname");                                         //֧��
	By sendCodeBtn = By.id("sendCheckCodeBtn");                                 //��ȡ��֤�밴ť
	By codeTxt = By.id("rcheckCode");                                           //��֤��
	By saveBtn = By.id("upLoadBut ");                                        	//����
	By cancelBtn = By.xpath("//input[@value='ȡ��' and @style='color:black']");	//ȡ����ť
	By reminder = By.xpath("//p[@id='confirmbank']");							//��ܰ��ʾ
	By guide = By.cssSelector("#investmentStatistics");//By.xpath("//a[@id='investmentStatistics']");                     //��д֧��ָ��
	//�޸��ֻ�����--------------------------------------------------------------------------------------
	By changTel = By.xpath("//a[contains(@href,'changTelMobile')]");                //�ֻ��޸�
	By changeByOldTel = By.xpath("//a[contains(@onclick,'changeByOldMobile')]");    //�ֻ���+��֤�� �޸�
	By msgCodeBtn = By.xpath("//div[@id='checkVerifyCode']//input[@id='ducode']");  //��ȡ������֤�밴ť
	By msgCodeAlert = By.xpath("//div[@id='alertname']");                           //������֤��ɹ�������
	By msgOkBtn = By.xpath("//div[@id='alertemailmsg']/a");                         //��֤��ɹ�������-ȷ�ϰ�ť
	By msgCodeTxt = By.xpath("//input[@id='checkCode']");							//��֤���ı���
	By nextBtn = By.xpath("//input[@onclick='checkVerifyCode4FindPwd()']");         //��һ����ť
	By newTeltxt = By.xpath("//input[@id='newTelNum']");                            //���ֻ����ı���
	By newMsgCodeBtn = By.xpath("//input[@id='newducode']");                        //���ֻ���-��ȡ������֤�밴ť
	By newMsgCodeTxt = By.xpath("//div[@id='changeByMobile']//input[@id='checkingCode']"); //���ֻ���-��֤���ı���
	By newPayPasTxt = By.xpath("//input[@id='payPassword']");                              //���ֻ���-֧�������ı���
	By newOKBtn = By.xpath("//input[contains(@onclick,'changTelNum')]");                   //���ֻ���-ȷ�ϰ�ť
	By newTelNum = By.cssSelector("#telNum");//By.xpath("//span[@id='telNum']");           //���ֻ���-�ĺ��ֻ���
	//��ѡ���ֻ���ȡ��֤�뷽ʽ   
	By sureBtn = By.cssSelector("#mobileChose .ensureBtn[value='ȷ��']");//ȷ��
	//��β��
	//By tailsTxt = By.cssSelector(".account.pdr10");
	
	/**********************��Ƶ��֤***************************/
	
	By videoBtn = By.xpath("//span[contains(@class,'icon_video')]/parent::p//following-sibling::a");
	
	/**
	 * ����Ԫ
	 * ��β����ͬ�����п��Ƿ���ɾ��
	 */
	public Boolean ifHasSameBank(String bank){
		Boolean result = true;
		//��ͬ��β��
		By tailsTxt = By.xpath("//span[text()='"+bank.substring(bank.length()-4)+"']");
		List<WebElement> tails = base.getElements(tailsTxt);
		System.out.println("β�ſ���"+tails.size());
		if (tails.size()>0) {
			//��ͬβ�ŵ�ɾ��
			base.sleep(2000);
			if(base.isDisplayed(tailsTxt)){
				for (int i = 0; i < tails.size(); i++) {
					base.getElementWithWait(By.xpath("//p[span/span[text()='"+bank.substring(bank.length()-4)+"']]/following-sibling::p//a[text()='ɾ��']")).click();
					base.sleep(2000);
					//ȷ��ɾ��
					base.clickWithWait(By.id("okDeleteCardDiv"));
					base.sleep(2000);
					Alert alert = base.getAlert();
					System.out.println(alert.getText());
					if (alert.getText().equals("�ÿ��й�����δ���֣���ʱ����ɾ��!")) {
						Reporter.log("���֣��ÿ��й�����δ���֣���ʱ����ɾ��!"+"<br/>");
						result = false;
					}
					base.sleep(2000);
					alert.accept();
				}
			}
		}
		return result;
	}
	
	/**
	 * ����Ԫ
	 * ��� ���п�����
	 */
	public void clickBankManage(){
		base.sleep(3000);
		//������п�����
		base.clickWithWait(accountModeBtn);
	}
	
	/**
	 * ����Ԫ
	 * ������п�
	 */
	public void addBank(String account,String bankStyle,String province,String city,String bankName,String tel){
		//�ж��Ƿ���β����ͬ�Ŀ�  �еĻ�����δɾ��  �ͻ�����
		if (!ifHasSameBank(account)) {
			account = new Data().getBank();
			System.out.println("�����µĿ���Ϊ��"+account);
			Reporter.log("�����µĿ���Ϊ��"+account+"<br/>");
			//addBank(account,bankStyle,province,city,bankName,tel);
		}
		//���п���
		bankLists = base.getElements(By.cssSelector(".bdbn"));
		
		base.clickWithWait(addBankBtn);
		//������п�
		base.sendKeysWithWait(accountTxt, account);
		base.sleep(1000);
		base.elementSelectByVisibleText(bankTypeSel, bankStyle);
		base.elementSelectByVisibleText(provinceSel, province);
		base.elementSelectByVisibleText(citySel, city);
		base.sendKeysWithWait(bankNameTxt, bankName);
//		base.clickWithWait(sendCodeBtn);
//		base.sleep(5000);
//		base.clickWithWait(sureBtn);
//		base.sleep(3000);
//		//��ȡ��֤��
//		String code = dbData.getPhoneCode(tel);
//		base.sendKeysWithWait(codeTxt, code);
//		base.sleep(2000);
		base.clickWithWait(saveBtn);
		//������֤�룬���ȷ��������Ϣ
		base.clickWithWait(By.id("upLoadBut"));
		base.sleep(3000);
	}
	
	/**
	 * У���������ҳ����ʾ
	 * @author ������
	 */
	public void checkAddBankPageByShow(){
		
		base.clickWithWait(addBankBtn);
		String reminderStr = "��ܰ���ѣ�\n1���������д�Ŀ�����֧�����Ʋ���ȷ��������п������ܱ���ɹ������ֽ��׽��޷��ɹ���\n2���������ȷ��������֧�����ƣ��ɴ�绰�������������е�Ӫҵ����ѯ�ʻ�������ѯ��\n3���û�������д�Ƚϴ��ڵ�����(��ũ�С����С����С��й����е�)��������д��Щ�Ƚ��ټ�������\n(��ũ�������硢ƽ�����С�������е�)�����������ʽ�����ױ���Ʊ��";
		String[] rowName = {"��������ʵ����","�����˻�����","","","*���п���","*ѡ������","","*���������ڵ�","*������֧������"};
		List<WebElement> rowNameList = base.getElements(By.xpath("//div[@id='addnewCardForm']//label[contains(@class,'bankLabel')]"));
		int length = rowName.length;
		for(int index = 0; index < length; index++){
			if(index == 2 || index == 3 || index == 6){
				continue;
			}
			String actual = base.getElementTextWithWait(rowNameList.get(index));
			base.assertEqualsActualExpected(actual, rowName[index]);
		}
		base.isElementPresent(saveBtn);
		base.isElementPresent(cancelBtn);
		base.isElementPresent(reminder);
		base.assertEqualsActualExpected(base.getElementTextWithWait(reminder), reminderStr);
		base.mouseToElement(guide);
		base.sleep(1000);
		base.isElementContainsValue(By.xpath("//div[@class='txzhzn']"), "style", "block");
		base.mouseToElement(cancelBtn);
		base.sleep(1000);
		base.clickWithWait(cancelBtn);
	}
	
	
	/**
	 * ����Ԫ
	 * ������п��Ƿ�ɹ�
	 */
	public void isAddBankOK(){
		if(bankLists.size()==5){
			try {
				Alert alert = base.getAlert();
				base.sleep(3000);
				base.assertEqualsActualExpected(alert.getText(), "���������5�����п�!");
				alert.accept();
				Reporter.log("δ������п������������5�����п�!����"+"<br/>");
				System.out.println("δ������п������������5�����п�!����");
			} catch (Exception e) {
			}
		}else {
			base.assertTrueByBoolean(base.getElementText(By.id("changebank")).contains("�ɹ�"));
			base.clickWithWait(By.cssSelector("#btn1yes>input"));
		}
	}
	
	/**
	 * ����Ԫ
	 * ��ȫ��֤ �����Ƶ��֤�ġ���֤��
	 */
	public void clickVideoIdentificationBtn(){
		base.sleep(3000);
		base.clickWithWait(videoBtn);
		base.sleep(5000);
	}
	
	/**
	 * ����Ԫ
	 * ��Ƶ��֤
	 */
	public void videoIdentification(){
		base.setBrowserScroll(10000);
		Screen screen = new Screen();
		Pattern yunxuBtn = new Pattern(new File("").getAbsolutePath()+"\\images\\yunxu3.png");
		Pattern startBtn = new Pattern(new File("").getAbsolutePath()+"\\images\\kaishiluzhi.png");
		Pattern stopBtn = new Pattern(new File("").getAbsolutePath()+"\\images\\tingzhiluzhi.png");
		Pattern submitBtn = new Pattern(new File("").getAbsolutePath()+"\\images\\tijiao.png");
		Pattern OKBtn = new Pattern(new File("").getAbsolutePath()+"\\images\\saveOK_sp.png");
		try {
			base.sleep(8000);
			screen.click(yunxuBtn);
			base.sleep(3000);
			screen.click(startBtn);
			base.sleep(5000);
			screen.click(stopBtn);
			base.sleep(2000);
			screen.click(submitBtn);
			base.sleep(2000);
			screen.click(OKBtn);
			base.sleep(20000);
			screen.click(OKBtn);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		base.sleep(5000);
	}
	
	/**
	 * ����Ԫ
	 * ��֤��Ƶ¼�Ƴɹ�
	 */
	public void isVideoIdentificationOK(){
		
		Alert alert = base.getAlert();
		alert.accept();
		base.sleep(2000);
		alert = base.getAlert();
		String msg = alert.getText();
		alert.accept();
		try {
			alert = base.getAlert();
			String msg2 = alert.getText();
			if(msg2.contains("ʧ��") || msg2.contains("����")){
				base.assertTrueByBoolean(false);
			}
		} catch (Exception e) {
			base.assertTrueByBoolean(false);
		}
		base.assertTrueByBoolean(msg.contains("�ɹ�"));
		base.sleep(5000);
	}
	
	/**
	 * ����Ԫ
	 * �����֤--����
	 */
	public void identityAuthentication(String name,String idCard){
		int i = 0;
		do {
			i++;
			clickIdentityAuthenticationBtn();
		} while (base.checkElementPresent(By.cssSelector("#realname"), 3) && i<3);
		//base.turnToTargetCloseOtherPage("�ҵ��˻�");
		sendName(name);
		sendIDCard(idCard);
		clickIdentityAuthenticationSureBtn();
	}
	
	/**
	 * ����Ԫ
	 * ������֤--����
	 */
	public void emailAuthentication(String email){
		BackPage backPage = new BackPage();
		int i = 0;
		do {
			i++;
			base.clickWithWait(By.cssSelector("#emailBound"));
			base.sleep(1500);
		} while (!base.checkVisibleNoWaite(By.cssSelector("#byt")) && i<3);
		base.sendKeysWithWait(By.cssSelector("#email"), email);
		base.clickWithWait(By.cssSelector("#ducode"));
		base.clickWithWait(By.cssSelector("#alertname .lyclose"));
		String emailCode = "";
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {//Ԥ���߻���
			String curHandle = base.getCurrentWindowHandle();
			base.clickWithWait(By.cssSelector(".global.helper>a[href='http://bbs.eloancn.com']"));//Ϊ�˿���һ���µı�ǩҳ
			String BBSHandel = base.getChildWindowHandle(curHandle);
			base.jumpToWindow(BBSHandel);
			emailCode = backPage.getCode(email,"email");
			base.closeOtherWindowHandle(curHandle);
			base.jumpToWindow(curHandle);
		}else {
			emailCode = dbData.getEmailCode(email);
		}
		base.sendKeysWithWait(By.cssSelector("#checkingCode"), emailCode);
		base.clickWithWait(By.cssSelector(".btn1.mt20>input[value='������']"));
		Alert alert = base.getAlertwithWait();
		base.assertEqualsActualExpected(alert.getText(), "����󶨳ɹ�");
		alert.accept();
	}
	
	/**
	 * ����Ԫ
	 * ��������֤
	 */
	public void clickIdentityAuthenticationBtn(){
		base.clickWithWait(By.xpath(".//*[@id='tabList2']/ul/li[1]/div[1]/a/i"));
	}
	
	/**
	 * ����Ԫ
	 * ��ʾ�����֤����
	 */
	public void showIdentityAuthentication(){
		base.checkElementVisible(By.cssSelector("#shiming"));
	}
	
	/**
	 * ����Ԫ
	 * У���Ƿ���֤
	 */
	public void isAuthentication(String type,String msg){
		String css = "";
		switch (type) {
		case "�ֻ���":
			css = ".setedtext";
			break;
		case "����":
			css = "#realnameauth";
			break;
		case "���֤��":
			css = "#realnameauth";
			break;
		case "����":
			css = "#emailauth";
			break;
		case "֧������":
			css = "#paypasswordauth";
			break;
		default:
			break;
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(css)), msg);
	}
	
	/**
	 * ����Ԫ
	 * �����֤ ������ʵ����
	 */
	public void sendName(String value){
		base.clickWithWait(By.cssSelector("#realname"));
		base.sendKeysWithWait(By.cssSelector("#realname"), value);
	}
	
	/**
	 * ����Ԫ
	 * �����֤ У����ʵ����
	 */
	public void checkName(String msg){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#realnametipMsg")), msg);
	}
	
	/**
	 * �����֤������ʾ
	 * ����Ԫ
	 * ����������������õĲ�һ��,�뵽�˻������������!  �˴���֤���״���֤��  ����������֤�������õĲ�һ��,�뵽�˻������������!  ����10.0Ԫ�����ȳ�ֵ��������ֱ�ӻ��ת�ˣ���ȴ���˺����ԣ�
	 */
	public void checkIdAuth(String msg){
		base.checkElementVisible(By.cssSelector("#idAuthMsg"));
		if (msg.equals("�˴���֤���״���֤��")) {
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#confirmauth>.colorE6.textC.mt20.h35")), msg);
		}else{
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#authtips>p")), msg);
		}
	}
	
	/**
	 * ����Ԫ
	 * �������
	 */
	public void clickGoOn(){
		base.clickWithWait(By.cssSelector(".pub_btn_66_b"));
	}
	
	/**
	 * ����Ԫ
	 * �����֤ �������֤��
	 */
	public void sendIDCard(String value){
		base.clickWithWait(By.cssSelector("#idcard"));
		base.sendKeysWithWait(By.cssSelector("#idcard"), value);
	}
	
	/**
	 * ����Ԫ
	 * �����֤ У�����֤��
	 */
	public void checkIdCard(String msg){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#idcardtipMsg")), msg);
	}
	
	/**
	 * ����Ԫ
	 * ��������֤ȷ�ϰ�ť
	 */
	public void clickIdentityAuthenticationSureBtn(){
		base.clickWithWait(By.cssSelector(".btn1.mt20>input[value='�����֤']"));
	}
	
	/**
	 * ����Ԫ
	 * ��֤�ɹ�
	 */
	public void isIdentityAuthenticationOK(){
		base.checkElementVisible(By.cssSelector("#idAuthMsg"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(".colorE6.textC.mt20")), "���֤��֤�ɹ�");
	}
	
	/**
	 * ����Ԫ
	 * У�������֤�ɹ�  "�����֤�ɹ�"  ��֤ʧ�ܣ�
	 */
	public void isIdentityAuthenticationOK(String msg){
		base.checkElementVisible(By.cssSelector("#idAuthMsg"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(".colorE6.textC.mt20")), msg);
	}
	
	/**
	 * ����Ԫ
	 * �ر���ʾ����
	 */
	public void closePrompty(){
		base.clickWithWait(By.cssSelector("#g_tip_close"));
	}
	
	/**
	 * ����Ԫ
	 * �������
	 */
	public void clickUp(){
		base.clickWithWait(By.cssSelector("#safeLevelW"));
	}
}
