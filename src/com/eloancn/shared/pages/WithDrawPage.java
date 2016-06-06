package com.eloancn.shared.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Reporter;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;

/**
 * ���ҵ��˻���-�����֡�ҳ��
 */
public class WithDrawPage {

	Base base = new Base();
	Data data = new Data();
	
	public static By WithDrawTip = By.cssSelector("h2.u-tt");					//����ȫ��֤����ʾ
	public static By WithDrawTxt = By.cssSelector("div.newtitle.notice>h3");
    //���ֽ��
	By moneyTxt = By.cssSelector("#money");
	//֧������
	By paypasswordTxt = By.cssSelector("#paypassword");
	//��֤��
	By randTxt = By.cssSelector("#rand");
	//��֤��ͼƬ
	By randImg = By.cssSelector("#checkverificationCode>img");
	//���ְ�ť
	By submitBtn = By.cssSelector("#askForWithDrawButton");
	
	/**
	 * ����Ԫ
	 * ����
	 */
	public void withDraw(String money,String paypassword){
		base.sendKeysWithWait(moneyTxt, money);
		base.sendKeysWithWait(paypasswordTxt, paypassword);
		//String randCode = data.get(base.getElementWithWait(randImg), base.getWebDriver());
		//base.sendKeysWithWait(randTxt, randCode);
		base.clickWithWait(submitBtn);//chrome������
	}
	
	/**
	 * ����Ԫ
	 * ��֤�����Ƿ�ɹ�
	 */
	public void isWithDrawOK(){
		try {
			boolean isTrue = false;
			Alert alert = base.getAlertwithWait();
			//base.assertEqualsActualExpected(alert.getText(), "����ɹ�����ȴ�������Ա��ʵ��");
//			logger.info("���ֽ����"+alert.getText());
			Reporter.log("���ֽ����"+alert.getText()+"<br/>");
			isTrue = alert.getText().contains("�ɹ�");
			alert.accept();
			base.assertTrueByBoolean(isTrue);
		} catch (Exception e) {
			base.assertEqualsActualExpectedByBoolean(true, false);
		}
	}
	
	/**
	 * ����Ԫ
	 * �������  ��ʾ��ȫ��֤
	 */
	public void prompt(String msg){
		base.checkElementVisible(By.cssSelector("#drawtip"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#drawtip .lyct>p")), msg);
	}
	
	/**
	 * ����Ԫ
	 * �����ȫ��֤
	 */
	public void clickAuthentication(){
		base.checkElementVisible(By.cssSelector("#drawtip"));
		base.clickWithWait(By.cssSelector(".btn1>a"));
	}
}
