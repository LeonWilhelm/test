package com.eloancn.shared.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Reporter;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;

/**
 * “我的账户”-“提现”页面
 */
public class WithDrawPage {

	Base base = new Base();
	Data data = new Data();
	
	public static By WithDrawTip = By.cssSelector("h2.u-tt");					//“安全认证”提示
	public static By WithDrawTxt = By.cssSelector("div.newtitle.notice>h3");
    //提现金额
	By moneyTxt = By.cssSelector("#money");
	//支付密码
	By paypasswordTxt = By.cssSelector("#paypassword");
	//验证码
	By randTxt = By.cssSelector("#rand");
	//验证码图片
	By randImg = By.cssSelector("#checkverificationCode>img");
	//提现按钮
	By submitBtn = By.cssSelector("#askForWithDrawButton");
	
	/**
	 * 徐天元
	 * 提现
	 */
	public void withDraw(String money,String paypassword){
		base.sendKeysWithWait(moneyTxt, money);
		base.sendKeysWithWait(paypasswordTxt, paypassword);
		//String randCode = data.get(base.getElementWithWait(randImg), base.getWebDriver());
		//base.sendKeysWithWait(randTxt, randCode);
		base.clickWithWait(submitBtn);//chrome不兼容
	}
	
	/**
	 * 徐天元
	 * 验证提现是否成功
	 */
	public void isWithDrawOK(){
		try {
			boolean isTrue = false;
			Alert alert = base.getAlertwithWait();
			//base.assertEqualsActualExpected(alert.getText(), "申请成功，请等待工作人员核实！");
//			logger.info("提现结果："+alert.getText());
			Reporter.log("提现结果："+alert.getText()+"<br/>");
			isTrue = alert.getText().contains("成功");
			alert.accept();
			base.assertTrueByBoolean(isTrue);
		} catch (Exception e) {
			base.assertEqualsActualExpectedByBoolean(true, false);
		}
	}
	
	/**
	 * 徐天元
	 * 点击提现  提示安全认证
	 */
	public void prompt(String msg){
		base.checkElementVisible(By.cssSelector("#drawtip"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#drawtip .lyct>p")), msg);
	}
	
	/**
	 * 徐天元
	 * 点击安全认证
	 */
	public void clickAuthentication(){
		base.checkElementVisible(By.cssSelector("#drawtip"));
		base.clickWithWait(By.cssSelector(".btn1>a"));
	}
}
