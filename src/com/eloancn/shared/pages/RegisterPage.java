package com.eloancn.shared.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.common.VerifyMethod;


/*
 	名称		类型				后缀		示例
	文本框	TextBox			txt		nameTxt
	下拉列表框	DropDownList	drop	nameDrop
	复选框	CheckBox		chk		nameChk
	按钮		Button			btn		nameBtn
	图片                Image           img     nameImg

 */
/*
 * 注册页
 */
public class RegisterPage {
	Base base = new Base();
	Data data = new Data();
	DBData dbData = new DBData();
	VerifyMethod verifyMethod = new VerifyMethod();
	BackPage backPage = new BackPage();
	
	String registerHandle = "";
	String idCardHandle = "";
	String code = "";
	
	//我要投资
//	By creditBtn = By.xpath("//a[text()='我要投资']");
	By creditBtn = By.xpath("//*[@id='registerinit']/p/a[1]");
	//我要借款
//	By debitBtn = By.xpath("//a[text()='我要借款']");
	By debitBtn = By.xpath("//*[@id='registerinit']/p/a[2]");
	/*************注册***********/
	//手机号
	By phoneTxt = By.cssSelector("#phone");
	//密码提示栏
//	By dlmm_sTxt = By.id("dlmm_s");
	By dlmm_sTxt = By.cssSelector("#dlmm_s");
	//密码输入栏
	By passwordTxt = By.cssSelector("#password");
	//下一步
	By nextStepBtn = By.cssSelector(".btn");//xpath("//input[@value='下一步']");
	//验证码图片
	By yanZhengMaImg = By.xpath("//*[@id='yancode']/img");
	//验证码
//	By ranCodeTxt = By.id("rancode");
	By ranCodeTxt = By.cssSelector("#rancode");
	/**********手机认证*********/
	//获取短信验证码
	By sendCodeBtn = By.cssSelector("#sendcode");
	//输入验证码
	By mobileCodeTxt = By.id("mobileCode");
	//完成注册
	By submitBtn = By.id("registersubmit");
	//注册成功
	By registerOK = By.cssSelector("p.gx");//By.id("//p[text()='恭喜您，注册成功！']")
	//我要借款>>>>>>>>>>>>>>>>>>
	//通过运营商借款用户
	By operatorDebiterBtn = By.cssSelector("#jiekuan>a");////a[text()='通过运营商借款用户']
	//我要贷出>>>>>>>>>>>>>>>>>>
	//去充值
	By rechargeBtn = By.xpath(".//*[@id='touzi']/a[1]");
	/*********身份认证***********/
	//您已完成手机认证！请继续！
	By telIdentificationOK = By.cssSelector(".stepnote.visible");
	//真实姓名
	By realNameTxt = By.cssSelector("#realname");
	//身份证号码
	By idCardTxt = By.cssSelector("#idcard");
	//身份认证按钮
	By idCardIdentificationBtn = By.cssSelector(".certifisub1");
	//充值
	By Rechargelink = By.cssSelector(".g_secr_a2");
	//身份认证确认按钮
	By idCardOK = By.cssSelector(".tipbuttok");
	/*************填写资料*************/
	//您已完成身份认证！请继续！
	By idCardIdentificationOK = By.cssSelector(".//*[@id='stepnote']/span");
	//借款地  省
	By provinceSel = By.id("provinceid");
	//市
	By citySel = By.id("cityid");
	//区
	By countySel = By.id("countyid");
	//户籍
	By nativePlaceSel = By.id("nativePlace");
	//现居住地地址
	By addressTxt = By.id("address");
	//教育程度
	By educationSel = By.xpath("//td[text()='教育程度：']/following-sibling::td//select");
	//职业
	By workSel = By.xpath("//td[text()='职业：']/following-sibling::td//select");
	//长期居住地
	By addressSel = By.xpath("//td[text()='长期居住地：']/following-sibling::td//select");
	//年收入
	By moneySel = By.xpath("//td[text()='年收入：']/following-sibling::td//select");
	//提交
	By infoSubmitBtn = By.id("personalmaterialok");
	/********发标借款*********/
	//您已完成资料填写！请继续！
	By writeInfoOK = By.cssSelector(".stepnote.visible");
	//a[text()='完善信息']
	//a[text()='发标借款']    title:翼龙贷我的账户   //a[contains(@class,'cur')]  申请借款
	//a[text()='发布翼星借款']
	//退出
	By quitBtn = By.xpath("a[text()='退出']");////a[text()='退出'] //a[@href='/logout.jsp']

	/**
	 * 注册
	 * @param type credit：我要投资  debit：我要借款
	 * @param tel
	 * @param password
	 */
	public String register(String type,String tel,String password){
		if (type.equals("debit")) {
			base.clickWithWait(debitBtn);
		}else {
			base.clickWithWait(creditBtn);
		}
		if (base.gethandelsNum()==2) {
			base.turnToNewPage();
		}
		base.sendKeysWithWait(phoneTxt, tel);
//		int i = 0;
//		do {
//			i++;
//			base.clickWithWait(dlmm_sTxt);
//		} while (base.checkVisible(dlmm_sTxt, 5) && i<3);
		base.setDisplayById("dlmm_s","none");
		base.setDisplayById("password","block");
		base.sendKeysWithWait(passwordTxt, password);
		//此手机号已经被注册过！更换手机号
		if (base.checkVisible(By.cssSelector("#phoneErrorMsg"),3)) {
			Reporter.log(base.getElementTextWithWait(By.cssSelector("#phoneErrorMsg"))+"<br/>");
			if (base.getElementText(By.cssSelector("#phoneErrorMsg")).equals("此手机号已经被注册过！")) {
				Reporter.log(tel+"此手机号已经被注册过！"+"<br/>");
				System.out.println(tel+"此手机号已经被注册过！");
				if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
					System.out.println("此手机号已使用");
					base.assertTrueByBoolean(false);
				}else{
					tel = data.phoneConcatenation(0);
				}
				Reporter.log("注册手机号更换为："+tel+"<br/>");
				System.out.println("注册手机号更换为："+tel);
				base.sendKeysWithWait(phoneTxt, tel);
			}
		}
		String identifyingCode = data.get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
		base.sendKeysWithWait(ranCodeTxt,identifyingCode);
		onblur();
		//base.sleep(2000);
		//验证码错误
		if (base.checkVisible(By.cssSelector("#rancodeMsg"),3)) {
			if (base.getElementTextWithWait(By.cssSelector("#rancodeMsg")).equals("验证码错误！")) {
				System.out.println(base.getElementTextWithWait(By.cssSelector("#rancodeMsg")).equals("验证码错误！"));
				identifyingCode = data.get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
				base.sendKeysWithWait(ranCodeTxt,identifyingCode);
			}
		}
		onblur();
		base.clickWithWait(nextStepBtn);
		
		//获取短信验证码
		registerHandle = base.getCurrentWindowHandle();
		int j = 0;
		do {
			j++;
			inputPicCode();
		} while (base.isElementContainsValue(By.cssSelector("#rancode"), "class", "yzm") && j<3);
		System.out.println(tel);
		//验证码
		String code = "";
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {//预上线环境
			//String registerHandel = base.getCurrentWindowHandle();
//			base.clickWithWait(By.cssSelector(".global.helper>a"));//为了开启一个新的标签页
			base.clickWithWait(By.cssSelector(".global.helper>a[href='http://bbs.eloancn.com']"));//为了开启一个新的标签页
			String BBSHandel = base.getChildWindowHandle(registerHandle);
			base.jumpToWindow(BBSHandel);
			code = backPage.getCode(tel,"SMS");
			base.closeOtherWindowHandle(registerHandle);
			base.jumpToWindow(registerHandle);
		}else {
			code = dbData.getPhoneCode(tel);
		}
		base.sendKeysWithWait(mobileCodeTxt, code);
		//base.setValueById("tfat",DESUtils.getEncryptString("99"));//绕过身份认证
		base.sleep(2000);
		base.getElementWithWait(submitBtn).click();
		base.sleep(2000);
		return tel;
	}
	
	/**
	 * 徐天元
	 * 短信验证码的输入图片验证码
	 */
	public void inputPicCode(){
		base.clickWithWait(sendCodeBtn);
		base.sleep(1500);
		base.checkElementVisible(By.cssSelector("#out_all"));
		String code = data.get(base.getElementWithWait(By.cssSelector("#yancode>img")), base.webDriver);
		base.sendKeysWithWait(By.cssSelector("#rancode"), code);
		//base.sleep(2000);
		base.clickWithWait(By.cssSelector("input[value='获取验证码']"));
		base.sleep(5000);
	}
	
	/**
	 * 徐天元
	 * 点击'退出'
	 */
	public void logout(){
		base.clickWithWait(quitBtn);
	}
	
	/**
	 * 徐天元
	 * 判断注册成功
	 */
	public void isRegisterOK(){
		//base.assertNotNullBy(By.cssSelector(".gx"));//By.xpath("//span[text()='注册成功']"
		//verifyMethod.verifyTrue(base.getElementWithWait(By.cssSelector(".step3")).getAttribute("class").contains("st"));
		verifyMethod.verifyEquals("恭喜您，注册成功！", base.getElementWithWait(registerOK).getText());
		base.checkElement(By.cssSelector("#jiekuan>a"));
	}
	
	/**
	 * 徐天元
	 * 点击'通过运营商借款用户'
	 */
	public void clickOperatorDebiterBtn(){
		base.clickWithWait(operatorDebiterBtn);
	}
	
	/**
	 * 徐天元
	 * 手机认证完判断进入借入验证界面，进入身份验证界面
	 */
	public void isDebitVerifyPage(){
		if (base.gethandelsNum() == 2) {
			base.turnToNewPage();
		}
		base.checkTitle(PageTitles.jieRuYanZheng);
		//您已完成手机认证！请继续！
		verifyMethod.verifyEquals("您已完成手机认证！请继续！", base.getElementText(telIdentificationOK));//By.xpath("//span[text()='您已完成手机认证！请继续！']")
		//身份证认证步骤,1步骤跳过
		base.assertTrueByBoolean(base.getElementWithWait(By.cssSelector("#steps")).getAttribute("class").contains("step1"));
	}
	
	/**
	 * 徐天元
	 * 身份验证
	 */
	public String[] idCardIdentification(String realName,String idCard){
		String info[] = {realName,idCard};
		idCardInfo(realName,idCard);
		//此身份证号已经被注册！   认证结果：姓名和身份证号不匹配！
		//Reporter.log("test环境，请更新Data的借入者注册的数据test_register_credit_realName、test_register_credit_idCard");
		if (base.isElementPresent(By.cssSelector(".stepnote.visible")) && !base.getElementTextWithWait(By.cssSelector(".stepnote.visible")).equals("您已完成身份认证！请继续！")) {
			Reporter.log(realName+","+idCard+base.getElementTextWithWait(By.cssSelector(".stepnote.visible"))+"<br/>");
			if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
				System.out.println("此身份证号已使用");
				base.assertTrueByBoolean(false);
			}else {
				info[1] = new Data().idConcatenation();
			}
			Reporter.log("更换信息为："+info[0]+","+info[1]+"<br/>");
			idCardInfo(info[0],info[1]);
		}
		Reporter.log(info[0]+","+info[1]+base.getElementTextWithWait(By.cssSelector(".stepnote.visible"))+"<br/>");
		return info;
	}
	
	public void idCardInfo(String realName,String idCard){
		base.sendKeysWithWait(realNameTxt, realName);
		base.sendKeysWithWait(idCardTxt, idCard);
		base.clickWithWait(idCardIdentificationBtn);
		//base.getElementWithWait(idCardIdentificationBtn).submit();
		base.clickWithWait(idCardOK);
	}
	
	/**
	 * 徐天元
	 * 身份认证完判断进入资料填写界面
	 */
	public void isInfoPage(){
		//String infoPageHandle = base.getChildWindowHandle(idCardHandle);
		//base.jumpToWindow(infoPageHandle);
		base.sleep(5000);
		//您已完成手机认证！请继续！
		//verifyMethod.verifyEquals("您已完成身份认证！请继续！", base.getElementText(idCardIdentificationOK));//By.xpath("//span[text()='您已完成手机认证！请继续！']")
		base.assertNotNullBy(By.cssSelector(".step2"));
	}
	
	/**
	 * 徐天元
	 * 资料填写
	 */
	public void writeInfo(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		base.elementSelectByIndex(provinceSel, 1);
		base.elementSelectByIndex(citySel, 1);
		base.elementSelectByIndex(countySel, 1);
		base.elementSelectByIndex(nativePlaceSel, 3);
		base.elementSelectByIndex(provinceSel, 1);
		base.sendKeysWithWait(addressTxt, "北京海淀区科实大厦");
		base.elementSelectByIndex(educationSel, 1);
		base.elementSelectByIndex(workSel, 1);
		base.elementSelectByIndex(addressSel, 1);
		base.elementSelectByIndex(moneySel, 3);
		base.clickWithWait(infoSubmitBtn);
	}
	
	/**
	 * 徐天元
	 * 判断是否进入发标借款界面
	 */
	public void isSuingLoansPage(){
		verifyMethod.verifyEquals("您已完成资料填写！请继续！", base.getElementText(writeInfoOK));
	}
	
	/**
	 * 徐天元
	 * 发标借款按钮点击   完善信息  发标借款  发布翼星借款
	 */
	public void suingLoansBtnClick(String name){
		base.clickWithWait(By.xpath("//a[text()='" + name + "']"));
		try {
			Thread.sleep(3000);
			Alert alert = base.getAlert();
			alert.accept();
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	/*****************投资者******************/
	/**
	 * 徐天元
	 * 注册完，点击“去充值”
	 */
	public void clickRecharge(){
		base.clickWithWait(rechargeBtn);
		if (base.gethandelsNum()==2) {
			base.turnToNewPage();
		}
	}
	
	/******************************P1********************************/
	/**
	 * 徐天元
	 * 选择角色
	 */
	public void selectRole(String type){
		if (type.equals("我要投资")) {
			base.clickWithWait(By.xpath("//*[@id='registerinit']/p/a[1]"));
		}else {
			base.clickWithWait(By.xpath("//*[@id='registerinit']/p/a[2]"));
		}
		if (base.gethandelsNum()==2) {
			base.turnToNewPage();
		}
	}
	
	/**
	 * 徐天元
	 * 更换角色
	 */
	public void updateRole(){
		base.clickWithWait(By.cssSelector("#checkregisterForm>p>a"));
	}
	
	/**
	 * 徐天元
	 * 返回上一级页面,显示角色选择
	 */
	public void isUpdateRoleOK(){
		base.checkTitle(PageTitles.zhuCe);
		base.checkElement(By.cssSelector(".tzr>a:nth-child(1)"));
		base.checkElement(By.cssSelector(".tzr>a:nth-child(2)"));
	}
	
	/**
	 * 徐天元
	 * 鼠标移开输入框   模拟onblur事件  点击“个人账户”
	 */
	public void onblur(){
		base.clickWithWait(By.cssSelector(".xz.zh2"));
	}
	
	/**
	 * 徐天元
	 * 输入手机号
	 */
	public void inputTel(String tel){
		base.sendKeysWithWait(By.cssSelector("#phone"), tel);
	}
	
	/**
	 * 徐天元
	 * 校验手机号输入正确
	 */
	public void isInputTelOK(){
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#phoneRightMsg")));
	}
	
	/**
	 * 徐天元
	 * 校验提示消息是否正确
	 * type:phoneError,手机;  password,密码;  rancode,验证码; #msgerror,短信验证码
	 */
	public void isMsgOK(String type,String expectedMsg){
		if (type.equals("msgerror")) {//短信验证码
			//base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#"+type)));
			base.checkElement(By.cssSelector("#"+type));
			//base.checkElement(By.xpath("//*[@id='"+type+"' and text()='"+expectedMsg+"']"));
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#"+type)), expectedMsg);
		}else {//#rancodeMsg  #passwordMsg  #phoneErrorMsg
			base.checkElement(By.cssSelector("#"+type+"Msg"));
			//base.checkElement(By.xpath("//*[@id='"+type+"Msg' and text()='"+expectedMsg+"']"));
			//base.assertTrueByBoolean(base.checkElement(By.cssSelector("#"+type+"Msg")));
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#"+type+"Msg")), expectedMsg);
		}
	}
	
	/**
	 * 徐天元
	 * 输入密码
	 */
	public void clickPassword(){
		base.clickWithWait(By.cssSelector("#dlmm_s"));
	}
	
	/**
	 * 徐天元
	 * 输入密码，若调用此方法需先调用上边方法，分开有其他用途
	 */
	public void inputPassword(String password){
		base.sendKeysWithWait(By.cssSelector("#password"), password);
	}
	
	/**
	 * 徐天元
	 * 输入验证码
	 */
	public void inputRandcode(String type){
		String identifyingCode = "";
		if (!type.equals("refreshInputNew") && !type.equals("no")) {
			identifyingCode = data.get(base.getElementWithWait(By.cssSelector("#yancode>img")), base.getWebDriver());
		}
		if (type.equals("desc")) {//倒叙
			identifyingCode = base.desc(identifyingCode);
		}
		if (type.contains("refresh")) {
			base.clickWithWait(By.cssSelector("#yancode>img"));//点击刷新按钮   .sx
		}
		if (type.equals("refreshInputNew")) {//点击刷新  输入新验证码
			identifyingCode = data.get(base.getElementWithWait(By.cssSelector("#yancode>img")), base.getWebDriver());
		}
		if (type.equals("SBCCase")) {//转换成全角
			identifyingCode = base.btoQ(identifyingCode.substring(0,4));
		}
		if (type.equals("no")) {//不输入验证码
			identifyingCode = "";
		}
		base.sendKeysWithWait(By.cssSelector("#rancode"),identifyingCode);
	}
	
	/**
	 * 徐天元
	 * 下一步
	 */
	public void clickNestStep(){
		base.clickWithWait(By.cssSelector(".btn"));
	}
	
	/**
	 * 徐天元
	 * 是否进入验证手机界面  上方导航栏显示验证手机号页面
	 */
	public void isTurnVerifyTelPage(){
		base.assertTrueByBoolean(base.isElementPresent(By.cssSelector(".step2.st")));
	}
	
	/**
	 * 徐天元
	 * 填写账户信息
	 */
	public void setTelInfo(String tel,String password){
		//输入手机号
		inputTel(tel);
		//输入密码
		clickPassword();
		inputPassword(password);
		//输入正确短信验证码
		inputRandcode("");
		//下一步
		clickNestStep();
	}
	
	/**
	 * 徐天元
	 * 短信验证码
	 * type: other,点击获取短信验证码,之后,再修改手机号为其他未注册的手机号,然后输入验证码;otherTel,设目前手机号为A,未注册手机号为B,修改手机号为B,然后获取手机号B的验证码,然后再次修改手机号为A,输入手机号B的验证码
	 */
	public void inputSMSCode(String tel,String type){
		String tel2 = data.phoneConcatenation(0);
		//获取短信验证码
		registerHandle = base.getCurrentWindowHandle();
		inputPicCode();
//		if (type.equals("first")) {//先后获取2次验证码,收到第二次验证码以后,输入第一次验证码
//			inputPicCode();
//		}
		if (type.contains("other")) {// other:点击获取短信验证码,之后,再修改手机号为其他未注册的手机号,然后输入验证码
			updateTel(tel2);
		}
		if (type.equals("otherTel")) {
			//inputPicCode();
			inputTel(tel);
			tel = tel2;//目的：获取tel2的验证码
		}
		//验证码
		code = "";
		//获取手机验证码
		code = getTelCode(tel);
		if (type.equals("first")) {//先后获取2次验证码,收到第二次验证码以后,输入第一次验证码
			base.sleep(62000);
			inputPicCode();
		}
		base.sleep(5000);
		base.sendKeysWithWait(mobileCodeTxt, code);
		base.clickWithWait(By.cssSelector("#registersubmit"));
	}
	
	public void inputSMSCodeByCode(String code,String type){
		switch (type) {
		case "SBCCase":
			//输入全角验证码
			code = base.btoQ(code);
			break;
		case "desc":
			//倒序输入验证码
			code = base.desc(code);
			break;
		case "confuse":
			//乱序输入验证码
			code = base.confuse(code);
			break;
		case "no":
			//乱序输入验证码
			code = "";
			break;
		default:
			code = type;
			break;
		}
		base.sendKeysWithWait(mobileCodeTxt, code);
	}
	
	/**
	 * xty
	 * 获取验证码的等待时间消失  显示为获取验证码
	 */
	public void waiterGetCodeBtn(){
		base.checkElement(By.cssSelector("input[value='获取短信验证码']"),62000);
	}
	
	/**
	 * 徐天元
	 * 更新手机号
	 */
	public void updateTel(String tel){
		base.clickWithWait(By.cssSelector("#changeMobile"));
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
//		String OtherTelhandel = base.getChildWindowHandle(registerHandle);
//		base.closeWindow(OtherTelhandel);
//		base.jumpToWindow(registerHandle);
		inputTel(tel);
	}
	
	/**
	 * 徐天元
	 * 获取手机验证码
	 */
	public String getTelCode(String tel){
		String code = "";
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {//预上线环境
			String registerHandel = base.getCurrentWindowHandle();
			base.clickWithWait(By.cssSelector(".global.helper>a[href='http://bbs.eloancn.com']"));//为了开启一个新的标签页
			String BBSHandel = base.getChildWindowHandle(registerHandel);
			base.jumpToWindow(BBSHandel);
			code = backPage.getCode(tel,"SMS");
			base.closeOtherWindowHandle(registerHandel);
			base.jumpToWindow(registerHandel);
			//base.sleep(2000);
		}else {
			code = dbData.getPhoneCode(tel);
		}
		return code;
	}
	
	/**
	 * 徐天元
	 * 短信校验码 “完成注册”
	 */
	public void submit(){
		base.getElementWithWait(submitBtn).submit();
		//base.sleep(20000);
	}
	
	/**
	 * 徐天元
	 * 验证手机号页面  返回重新填写信息
	 */
	public void goback(){
		base.clickWithWait(By.cssSelector(".wc>a"));
		if (base.gethandelsNum()==2) {
			base.turnToNewPage();
		}
		//base.sleep(2000);
	}
	
	/**
	 * 徐天元
	 * 验证手机号页面  点击“返回重新填写信息”  验证返回上一级页面,验证码刷新,密码框清空
	 */
	public void isGoback(){
		base.assertTrueByBoolean(!base.isDisplayed(By.cssSelector(".step2.st")));
		base.assertTrueByBoolean(base.isDisplayed(By.cssSelector("#dlmm_s")));
		base.assertTrueByBoolean(!base.isBlock(By.cssSelector("#password")));
		String newCode = data.get(base.getElementWithWait(By.cssSelector("#yancode>img")), base.getWebDriver());
		base.assertNotEqualsActualExpected(code, newCode);
	}
	
	/**
	 * 徐天元
	 * 不输入短信验证码  提示校验
	 */
	public void isNoSMSCodeMesOK(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//p[@class='ts'][2]")), "验证码有误，请核对！");
	}
	
	/**
	 * 徐天元
	 * 完成通用注册信息后点击完成注册  点击浏览器返回上一级页面   
	 */
	public void isGoback404(){
		base.assertTrueByBoolean(base.checkTitleContains("出错"));
		//base.assertTrueByBoolean(base.getElementTextWithWait(By.cssSelector("html>body>h1")).contains("404"));
	}
	
	/**
	 * 徐天元
	 * 是否进入注册页
	 */
	public void isTurnRegisterPage(){
		base.assertTrueByBoolean(base.checkTitleContains(PageTitles.zhuCe));
	}
	
	/**
	 * 点击邀请码选项
	 * 徐天元
	 */
	public void clickYaoQingMa(){
		base.clickWithWait(By.cssSelector("#incodespan"));
	}
	
	/**
	 * 徐天元
	 * 输入邀请码
	 */
	public void inputYaoQingMa(String value){
		base.sendKeyAndWait(By.cssSelector("#refranchiseecode"), value);
		base.clickWithWait(By.cssSelector("#rancode"));
	}
	
	/**
	 * 徐天元
	 * 清除邀请码
	 */
	public void clearYaoQingMa(){
		base.getElementWithWait(By.cssSelector("#refranchiseecode")).clear();
	}
	
	/**
	 * 徐天元
	 * 邀请码错误提示  请填写正确的邀请码，无可不填！
	 */
	public void isYaoQingMaWrong(String msg){
		base.isElementContainsValue(By.cssSelector("#refranchiseecodeMsg"), "class", "zym");
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#refranchiseecodeMsg")), msg);
	}
	
	/**
	 * 徐天元
	 * 邀请码正确
	 */
	public void isYaoQingMaOK(){
		base.isElementContainsValue(By.cssSelector("#refranchiseecodeMsg"), "class", "zq");
	}
	
	/**
	 * 徐天元
	 * 点击同意翼龙贷协议
	 */
	public void clickAgree(){
		base.clickWithWait(By.cssSelector("#checkregisterForm>a"));
	}
	
	/**
	 * 徐天元
	 * 显示协议
	 */
	public void showAgree(){
		base.checkElementVisible(By.cssSelector("#to_agree"));
	}
	
	/**
	 * 徐天元
	 * 关闭协议
	 */
	public void closeAgree(){
		base.clickWithWait(By.cssSelector(".tip_close.cpt"));
	}
	
	/**
	 * 徐天元
	 * 点击取消协议复选框
	 */
	public void cancleAgree(){
		base.clickWithWait(By.cssSelector("#agreebox"));
	}
	
	/**
	 * 徐天元
	 * 提示勾选同意协议
	 */
	public void isAgreeWrong(){
		base.isElementContainsValue(By.cssSelector("#agreeMsg"), "class", "zym");
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#agreeMsg")), "请勾选同意翼龙贷协议！");
	}
}
