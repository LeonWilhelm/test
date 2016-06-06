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
 * “我的账户”-“安全认证”页面
 */
public class SecurityAuthPage {
	Base base = new Base();
	DBData dbData = new DBData();
	
	List<WebElement> bankLists;
	
	public static By SecurityAuthTxt = By.cssSelector("div.newtitle.notice>h3");
	/*********************银行卡设置********************/
	
	public By accountModeBtn = By.id("accountMode");                            //银行卡管理
	public By addBackDiv = By.cssSelector("#bankcardDiv");                             //添加银行卡层
	By addBankBtn = By.cssSelector(".addbank");                                 //新增银行卡
	By accountTxt = By.id("account");                                           //银行卡号
	By bankTypeSel = By.id("type");                                             //银行
	By provinceSel = By.id("province");                                         //省
	By citySel = By.id("city");                                                 //市
	By bankNameTxt = By.id("bankname");                                         //支行
	By sendCodeBtn = By.id("sendCheckCodeBtn");                                 //获取验证码按钮
	By codeTxt = By.id("rcheckCode");                                           //验证码
	By saveBtn = By.id("upLoadBut ");                                        	//保存
	By cancelBtn = By.xpath("//input[@value='取消' and @style='color:black']");	//取消按钮
	By reminder = By.xpath("//p[@id='confirmbank']");							//温馨提示
	By guide = By.cssSelector("#investmentStatistics");//By.xpath("//a[@id='investmentStatistics']");                     //填写支行指南
	//修改手机号码--------------------------------------------------------------------------------------
	By changTel = By.xpath("//a[contains(@href,'changTelMobile')]");                //手机修改
	By changeByOldTel = By.xpath("//a[contains(@onclick,'changeByOldMobile')]");    //手机号+验证码 修改
	By msgCodeBtn = By.xpath("//div[@id='checkVerifyCode']//input[@id='ducode']");  //获取短信验证码按钮
	By msgCodeAlert = By.xpath("//div[@id='alertname']");                           //发送验证码成功弹出框
	By msgOkBtn = By.xpath("//div[@id='alertemailmsg']/a");                         //验证码成功弹出框-确认按钮
	By msgCodeTxt = By.xpath("//input[@id='checkCode']");							//验证码文本框
	By nextBtn = By.xpath("//input[@onclick='checkVerifyCode4FindPwd()']");         //下一步按钮
	By newTeltxt = By.xpath("//input[@id='newTelNum']");                            //新手机号文本框
	By newMsgCodeBtn = By.xpath("//input[@id='newducode']");                        //新手机号-获取短信验证码按钮
	By newMsgCodeTxt = By.xpath("//div[@id='changeByMobile']//input[@id='checkingCode']"); //新手机号-验证码文本框
	By newPayPasTxt = By.xpath("//input[@id='payPassword']");                              //新手机号-支付密码文本框
	By newOKBtn = By.xpath("//input[contains(@onclick,'changTelNum')]");                   //新手机号-确认按钮
	By newTelNum = By.cssSelector("#telNum");//By.xpath("//span[@id='telNum']");           //新手机号-改后手机号
	//请选择手机获取验证码方式   
	By sureBtn = By.cssSelector("#mobileChose .ensureBtn[value='确定']");//确定
	//卡尾号
	//By tailsTxt = By.cssSelector(".account.pdr10");
	
	/**********************视频认证***************************/
	
	By videoBtn = By.xpath("//span[contains(@class,'icon_video')]/parent::p//following-sibling::a");
	
	/**
	 * 徐天元
	 * 有尾号相同的银行卡是否已删除
	 */
	public Boolean ifHasSameBank(String bank){
		Boolean result = true;
		//相同的尾号
		By tailsTxt = By.xpath("//span[text()='"+bank.substring(bank.length()-4)+"']");
		List<WebElement> tails = base.getElements(tailsTxt);
		System.out.println("尾号卡："+tails.size());
		if (tails.size()>0) {
			//相同尾号的删除
			base.sleep(2000);
			if(base.isDisplayed(tailsTxt)){
				for (int i = 0; i < tails.size(); i++) {
					base.getElementWithWait(By.xpath("//p[span/span[text()='"+bank.substring(bank.length()-4)+"']]/following-sibling::p//a[text()='删除']")).click();
					base.sleep(2000);
					//确定删除
					base.clickWithWait(By.id("okDeleteCardDiv"));
					base.sleep(2000);
					Alert alert = base.getAlert();
					System.out.println(alert.getText());
					if (alert.getText().equals("该卡有关联的未提现，暂时不可删除!")) {
						Reporter.log("提现：该卡有关联的未提现，暂时不可删除!"+"<br/>");
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
	 * 徐天元
	 * 点击 银行卡管理
	 */
	public void clickBankManage(){
		base.sleep(3000);
		//点击银行卡管理
		base.clickWithWait(accountModeBtn);
	}
	
	/**
	 * 徐天元
	 * 添加银行卡
	 */
	public void addBank(String account,String bankStyle,String province,String city,String bankName,String tel){
		//判断是否有尾号相同的卡  有的话并且未删除  就换卡号
		if (!ifHasSameBank(account)) {
			account = new Data().getBank();
			System.out.println("更换新的卡号为："+account);
			Reporter.log("更换新的卡号为："+account+"<br/>");
			//addBank(account,bankStyle,province,city,bankName,tel);
		}
		//银行卡数
		bankLists = base.getElements(By.cssSelector(".bdbn"));
		
		base.clickWithWait(addBankBtn);
		//添加银行卡
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
//		//获取验证码
//		String code = dbData.getPhoneCode(tel);
//		base.sendKeysWithWait(codeTxt, code);
//		base.sleep(2000);
		base.clickWithWait(saveBtn);
		//不用验证码，变成确认银行信息
		base.clickWithWait(By.id("upLoadBut"));
		base.sleep(3000);
	}
	
	/**
	 * 校验添加银行页面显示
	 * @author 江渤洋
	 */
	public void checkAddBankPageByShow(){
		
		base.clickWithWait(addBankBtn);
		String reminderStr = "温馨提醒：\n1、如果您填写的开户行支行名称不正确，添加银行卡将不能保存成功，提现交易将无法成功。\n2、如果您不确定开户行支行名称，可打电话到当地所在银行的营业网点询问或上网查询。\n3、用户尽量填写比较大众的银行(如农行、工行、建行、中国银行等)，避免填写那些比较少见的银行\n(如农村信用社、平安银行、恒丰银行等)，否则提现资金很容易被退票。";
		String[] rowName = {"开户人真实姓名","银行账户类型","","","*银行卡号","*选择银行","","*开户行所在地","*开户行支行名称"};
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
	 * 徐天元
	 * 添加银行卡是否成功
	 */
	public void isAddBankOK(){
		if(bankLists.size()==5){
			try {
				Alert alert = base.getAlert();
				base.sleep(3000);
				base.assertEqualsActualExpected(alert.getText(), "最多仅能添加5张银行卡!");
				alert.accept();
				Reporter.log("未添加银行卡：最多仅能添加5张银行卡!已满"+"<br/>");
				System.out.println("未添加银行卡：最多仅能添加5张银行卡!已满");
			} catch (Exception e) {
			}
		}else {
			base.assertTrueByBoolean(base.getElementText(By.id("changebank")).contains("成功"));
			base.clickWithWait(By.cssSelector("#btn1yes>input"));
		}
	}
	
	/**
	 * 徐天元
	 * 安全认证 点击视频认证的“认证”
	 */
	public void clickVideoIdentificationBtn(){
		base.sleep(3000);
		base.clickWithWait(videoBtn);
		base.sleep(5000);
	}
	
	/**
	 * 徐天元
	 * 视频认证
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
	 * 徐天元
	 * 验证视频录制成功
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
			if(msg2.contains("失败") || msg2.contains("有误")){
				base.assertTrueByBoolean(false);
			}
		} catch (Exception e) {
			base.assertTrueByBoolean(false);
		}
		base.assertTrueByBoolean(msg.contains("成功"));
		base.sleep(5000);
	}
	
	/**
	 * 徐天元
	 * 身份认证--完整
	 */
	public void identityAuthentication(String name,String idCard){
		int i = 0;
		do {
			i++;
			clickIdentityAuthenticationBtn();
		} while (base.checkElementPresent(By.cssSelector("#realname"), 3) && i<3);
		//base.turnToTargetCloseOtherPage("我的账户");
		sendName(name);
		sendIDCard(idCard);
		clickIdentityAuthenticationSureBtn();
	}
	
	/**
	 * 徐天元
	 * 邮箱认证--完整
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
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {//预上线环境
			String curHandle = base.getCurrentWindowHandle();
			base.clickWithWait(By.cssSelector(".global.helper>a[href='http://bbs.eloancn.com']"));//为了开启一个新的标签页
			String BBSHandel = base.getChildWindowHandle(curHandle);
			base.jumpToWindow(BBSHandel);
			emailCode = backPage.getCode(email,"email");
			base.closeOtherWindowHandle(curHandle);
			base.jumpToWindow(curHandle);
		}else {
			emailCode = dbData.getEmailCode(email);
		}
		base.sendKeysWithWait(By.cssSelector("#checkingCode"), emailCode);
		base.clickWithWait(By.cssSelector(".btn1.mt20>input[value='绑定邮箱']"));
		Alert alert = base.getAlertwithWait();
		base.assertEqualsActualExpected(alert.getText(), "邮箱绑定成功");
		alert.accept();
	}
	
	/**
	 * 徐天元
	 * 点击身份认证
	 */
	public void clickIdentityAuthenticationBtn(){
		base.clickWithWait(By.xpath(".//*[@id='tabList2']/ul/li[1]/div[1]/a/i"));
	}
	
	/**
	 * 徐天元
	 * 显示身份认证界面
	 */
	public void showIdentityAuthentication(){
		base.checkElementVisible(By.cssSelector("#shiming"));
	}
	
	/**
	 * 徐天元
	 * 校验是否认证
	 */
	public void isAuthentication(String type,String msg){
		String css = "";
		switch (type) {
		case "手机号":
			css = ".setedtext";
			break;
		case "姓名":
			css = "#realnameauth";
			break;
		case "身份证号":
			css = "#realnameauth";
			break;
		case "邮箱":
			css = "#emailauth";
			break;
		case "支付密码":
			css = "#paypasswordauth";
			break;
		default:
			break;
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(css)), msg);
	}
	
	/**
	 * 徐天元
	 * 身份认证 输入真实姓名
	 */
	public void sendName(String value){
		base.clickWithWait(By.cssSelector("#realname"));
		base.sendKeysWithWait(By.cssSelector("#realname"), value);
	}
	
	/**
	 * 徐天元
	 * 身份认证 校验真实姓名
	 */
	public void checkName(String msg){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#realnametipMsg")), msg);
	}
	
	/**
	 * 身份认证错误提示
	 * 徐天元
	 * 您输入的姓名与设置的不一致,请到账户设置里面更改!  此次认证非首次认证！  您输入的身份证号与设置的不一致,请到账户设置里面更改!  余额不足10.0元，请先充值！如您已直接汇款转账，请等待审核后再试！
	 */
	public void checkIdAuth(String msg){
		base.checkElementVisible(By.cssSelector("#idAuthMsg"));
		if (msg.equals("此次认证非首次认证！")) {
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#confirmauth>.colorE6.textC.mt20.h35")), msg);
		}else{
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#authtips>p")), msg);
		}
	}
	
	/**
	 * 徐天元
	 * 点击继续
	 */
	public void clickGoOn(){
		base.clickWithWait(By.cssSelector(".pub_btn_66_b"));
	}
	
	/**
	 * 徐天元
	 * 身份认证 输入身份证号
	 */
	public void sendIDCard(String value){
		base.clickWithWait(By.cssSelector("#idcard"));
		base.sendKeysWithWait(By.cssSelector("#idcard"), value);
	}
	
	/**
	 * 徐天元
	 * 身份认证 校验身份证号
	 */
	public void checkIdCard(String msg){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#idcardtipMsg")), msg);
	}
	
	/**
	 * 徐天元
	 * 点击身份认证确认按钮
	 */
	public void clickIdentityAuthenticationSureBtn(){
		base.clickWithWait(By.cssSelector(".btn1.mt20>input[value='身份认证']"));
	}
	
	/**
	 * 徐天元
	 * 认证成功
	 */
	public void isIdentityAuthenticationOK(){
		base.checkElementVisible(By.cssSelector("#idAuthMsg"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(".colorE6.textC.mt20")), "身份证认证成功");
	}
	
	/**
	 * 徐天元
	 * 校验身份认证成功  "身份认证成功"  认证失败！
	 */
	public void isIdentityAuthenticationOK(String msg){
		base.checkElementVisible(By.cssSelector("#idAuthMsg"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(".colorE6.textC.mt20")), msg);
	}
	
	/**
	 * 徐天元
	 * 关闭提示窗口
	 */
	public void closePrompty(){
		base.clickWithWait(By.cssSelector("#g_tip_close"));
	}
	
	/**
	 * 徐天元
	 * 点击提升
	 */
	public void clickUp(){
		base.clickWithWait(By.cssSelector("#safeLevelW"));
	}
}
