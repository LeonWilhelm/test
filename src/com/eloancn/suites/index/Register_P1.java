package com.eloancn.suites.index;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.RegisterPage;

public class Register_P1 {
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	RegisterPage registerPage =  new RegisterPage();
	Data data = new Data();
	
	String tel = data.phoneConcatenation(0);
	String password = Data.password;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@AfterMethod
	public void logout(){
		base.logout();
	}
	
	/****************************角色*****************************/

	/**
	 * 徐天元
	 * 注册 -更换角色  投资-借款
	 */
	@Test(priority = 1)
	public void registerUpdateRole_web_18() {
		Reporter.log("注册P1:更换角色  投资-借款;借款-投资");
		//进入注册页面
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		//点击“我要投资”
		registerPage.selectRole("我要投资");
		//更换角色
		registerPage.updateRole();
		//校验更换角色  返回上一级页面,显示角色选择
		registerPage.isUpdateRoleOK();
		//点击“我要借款”
		registerPage.selectRole("我要借款");
		//更换角色
		registerPage.updateRole();
		//校验更换角色  返回上一级页面,显示角色选择
		registerPage.isUpdateRoleOK();
	}
	
	/***************************手机号*****************************/

	/**
	 * 徐天元
	 * 注册 -正确手机号  
	 */
	@Test(priority = 2)
	public void registerCheckTel_web_19() {
		Reporter.log("注册P1:手机号,正确手机号,可以注册,无错误提示;<br/>");
		Reporter.log("注册P1:手机号,输入10位手机号,提示请填写有效的11位手机号码<br/>");
		Reporter.log("注册P1:手机号,输入12位手机号,提示请填写有效的11位手机号码<br/>");
		Reporter.log("注册P1:手机号,输入已经注册的手机号,提示此手机号已经被注册过！<br/>");
		Reporter.log("注册P1:手机号,输入!@#$)(*^%%,提示请填写有效的11位手机号码<br/>");
		Reporter.log("注册P1:手机号,输入中文中文中文,提示请填写有效的11位手机号码<br/>");
		Reporter.log("注册P1:手机号,倒序输入有效的手机号,提示请填写有效的11位手机号码<br/>");
		Reporter.log("注册P1:手机号,不输入手机号,提示请输入手机号码<br/>");
		Reporter.log("注册P1:手机号,全角状态输入手机号,提示请填写有效的11位手机号码<br/>");
		//进入注册页面
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//点击“我要投资”
		registerPage.selectRole("我要借款");
		//输入正确的手机号
		tel = data.phoneConcatenation(0);
		/**手机号,正确手机号,可以注册,无错误提示**/
		registerPage.inputTel(tel);
		//离开手机号输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验手机号输入是否正确
		registerPage.isInputTelOK();
		/**输入10位手机号,提示请填写有效的11位手机号码**/
		//输入10位手机号
		registerPage.inputTel("131111111");
		//离开手机号输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验手机号输入是否正确
		registerPage.isMsgOK("phoneError","请填写有效的11位手机号码");
		/**输入12位手机号,提示请填写有效的11位手机号码**/
		//输入12位手机号
		registerPage.inputTel("131111111111");
		//离开手机号输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验手机号输入是否正确
		registerPage.isMsgOK("phoneError","请填写有效的11位手机号码");
		/**输入已经注册的手机号,提示此手机号已经被注册过！**/
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_tel;
		}else {
			tel = Data.tel_run_debit2;
		}
		registerPage.inputTel(tel);
		//离开手机号输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验手机号输入是否正确
		registerPage.isMsgOK("phoneError","此手机号已经被注册过！");
		/**输入!@#$)(*^%% 提示请填写有效的11位手机号码**/
		registerPage.inputTel("!@#$)(*^%%");
		//离开手机号输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验手机号输入是否正确
		registerPage.isMsgOK("phoneError","请填写有效的11位手机号码");
		/**输入中文中文中文**/
		registerPage.inputTel("中文中文中文");
		//离开手机号输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验手机号输入是否正确
		registerPage.isMsgOK("phoneError","请填写有效的11位手机号码");
		/**倒序输入有效的手机号**/
		registerPage.inputTel("87111111131");
		//离开手机号输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验手机号输入是否正确
		registerPage.isMsgOK("phoneError","请填写有效的11位手机号码");
		/**不输入手机号**/
		registerPage.inputTel("");
		//离开手机号输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验手机号输入是否正确
		registerPage.isMsgOK("phoneError","请输入手机号码");
		/**全角状态输入手机号**/
		registerPage.inputTel("１３１１１１１１１７８");
		//离开手机号输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验手机号输入是否正确
		registerPage.isMsgOK("phoneError","请填写有效的11位手机号码");
	}
	
	/****************************密码*****************************/
	
	/**
	 * 徐天元
	 * 注册 -密码  不输入登录密码
	 */
	@Test(priority = 3)
	public void registerCheckPassword_web_21() {
		Reporter.log("注册P1:密码,不输入登录密码,提示请输入6-16字符的登录密码<br/>");
		Reporter.log("注册P1:密码,输入12345,提示密码太短，最少6个字符<br/>");
		Reporter.log("注册P1:密码,输入12345678912345678,提示密码太长，最多16个字符<br/>");
		Reporter.log("注册P1:密码,输入1234567891234567,无错误提示<br/>");
		Reporter.log("注册P1:密码,输入12345 （5后面带空格）,提示您的密码中不能包含空格<br/>");
		Reporter.log("注册P1:密码,输入 12345（1前面带空格）,提示您的密码中不能包含空格<br/>");
		Reporter.log("注册P1:密码,输入12 345（3前面带空格）,提示您的密码中不能包含空格<br/>");
		Reporter.log("注册P1:密码,输入六个空格,提示您的密码中不能包含空格<br/>");
		Reporter.log("注册P1:密码,输入!@#$~$%^,无错误提示<br/>");
		Reporter.log("注册P1:密码,输入中文测试中文,提示密码不能输入中文<br/>");
		Reporter.log("注册P1:密码,输入手机号码,无错误提示<br/>");
		Reporter.log("注册P1:密码,输入　　　　　　六个全角空格,无错误提示<br/>");
		Reporter.log("注册P1:密码,输入ａｂｃabc,提示密码不能输入中文<br/>");
		//进入注册页面
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//点击“我要投资”
		registerPage.selectRole("我要借款");
		/**不输入密码**/
		registerPage.clickPassword();
		registerPage.inputPassword("");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","请输入6-16字符的登录密码");
		/** 输入12345**/
		registerPage.clickPassword();
		registerPage.inputPassword("12345");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","密码太短，最少6个字符");
		/**输入12345678912345678**/
		registerPage.inputPassword("12345678912345678");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","密码太长，最多16个字符");
		/**输入1234567891234567**/
		registerPage.inputPassword("1234567891234567");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","");
		/**输入12345 5后面带空格**/
		registerPage.inputPassword("12345 ");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","您的密码中不能包含空格");
		/**输入123451前面带空格**/
		registerPage.inputPassword(" 12345");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","您的密码中不能包含空格");
		/**输入12 345   3前面带空格**/
		registerPage.inputPassword("12 345");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","您的密码中不能包含空格");
		/**输入六个空格**/
		registerPage.inputPassword("      ");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","您的密码中不能包含空格");
		/**输入六个空格**/
		registerPage.inputPassword("!@#$~$%^");
		//离开手机号输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","");
		/**输入中文测试中文测试**/
		registerPage.inputPassword("中文测试中文测试");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","密码不能输入中文");
		/**输入手机号码**/
		registerPage.inputPassword(tel);
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","");
		/**输入　　　　　　六个全角空格**/
		registerPage.inputPassword("　　　　　　");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","");
		/**输入ａｂｃabc**/
		registerPage.inputPassword("ａｂｃabc");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验密码输入是否正确
		registerPage.isMsgOK("password","密码不能输入中文");
	}
	
	/****************************验证码*****************************/
	/**
	 * 徐天元
	 * 注册 -验证码   输入正确的验证码,点击下一步
	 */
	@Test(priority = 4)
	public void registerRandcode_web_22() {
		Reporter.log("注册P1:验证码,输入倒叙验证码,提示验证码错误！<br/>");
		Reporter.log("注册P1:验证码,记下验证码后,点击刷新按钮,再输入之前的验证码,提示验证码错误！<br/>");
		Reporter.log("注册P1:验证码,输入正确的验证码,点击下一步，无错误提示信息,上方导航栏显示验证手机号页面<br/>");
		Reporter.log("注册P1:验证码,全角状态输入验证码,提示验证码错误！<br/>");
		Reporter.log("注册P1:验证码,不输入验证码,提示验证码错误！<br/>");
		Reporter.log("注册P1:验证码,记下验证码后,点击刷新按钮,再输入新的验证码,无错误提示<br/>");
		//进入注册页面
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//点击“我要投资”
		registerPage.selectRole("我要借款");
		tel = data.phoneConcatenation(0);
		/**输入倒叙验证码**/
		registerPage.inputRandcode("desc");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验验证码输入是否正确
		registerPage.isMsgOK("rancode","验证码错误！");
		/**输入旧验证码**/
		registerPage.inputRandcode("refreshInputOld");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验验证码输入是否正确
		registerPage.isMsgOK("rancode","验证码错误！");
		/**输入新验证码**/
		registerPage.inputRandcode("refreshInputNew");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验验证码输入是否正确
		registerPage.isMsgOK("rancode","");
		/**全角状态输入验证码**/
		registerPage.inputRandcode("SBCCase");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验验证码输入是否正确
		registerPage.isMsgOK("rancode","验证码错误！");
		/**不输入验证码**/
		registerPage.inputRandcode("no");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验验证码输入是否正确
		registerPage.isMsgOK("rancode","请输入验证码！");
		/**正确验证码**/
		//输入手机号
		registerPage.inputTel(tel);
		//输入密码
		registerPage.clickPassword();
		registerPage.inputPassword(password);
		//输入正确验证码
		registerPage.inputRandcode("");
		//离开密码输入框
		registerPage.onblur();
		base.sleep(2000);
		//校验验证码输入是否正确
		registerPage.isMsgOK("rancode","");
		//下一步
		registerPage.clickNestStep();
		base.sleep(2000);
		//上方导航栏显示验证手机号页面
		registerPage.isTurnVerifyTelPage();
	}
	
	/**********************短信验证码************************/
	/**
	 * 徐天元
	 * 注册 -短信验证码   输入正确的短信验证码
	 */
	@Test(priority = 5)
	public void registerTrueSMSCode_web_26_1() {
		Reporter.log("注册P1:短信验证码,输入正确的短信验证码,无错误提示<br/>");
		if (base.indexURL.contains("/client") || base.indexURL.contains("inclient")) {
			tel = data.phoneConcatenation(0);
			//进入注册页面
			base.openBrowser(base.indexURL  + "/page/register/register.jsp");
			//点击“我要投资”
			registerPage.selectRole("我要借款");
			//填写账户信息
			registerPage.setTelInfo(tel,password);
			//是否进入验证手机界面  上方导航栏显示验证手机号页面
			//registerPage.isTurnVerifyTelPage();
			//输入正确短信验证码
			registerPage.inputSMSCode(tel,"");
//			//完成注册
//			registerPage.submit();
			//没有提示信息  验证注册成功
			registerPage.isRegisterOK();
			Reporter.log(tel+"注册成功");
		}
	}
	
	/**
	 * 徐天元
	 * 注册 -短信验证码   点击获取短信验证码,之后,再修改手机号为其他未注册的手机号,然后输入验证码
	 */
	@Test(priority = 6)
	public void registerOtherSMSCode_web_26_2() {
		Reporter.log("注册P1:短信验证码,点击获取短信验证码,之后,再修改手机号为其他未注册的手机号,然后输入验证码,提示手机号码与验证码不一致！<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_Register_tel;
		}else {
			tel = data.phoneConcatenation(0);
		}
		//进入注册页面
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//点击“我要投资”
		registerPage.selectRole("我要借款");
		//填写账户信息
		registerPage.setTelInfo(tel,password);
		//是否进入验证手机界面  上方导航栏显示验证手机号页面
		//registerPage.isTurnVerifyTelPage();
		//点击获取短信验证码,之后,再修改手机号为其他未注册的手机号,然后输入验证码
		registerPage.inputSMSCode(tel,"other");
		//提示手机号码与验证码不一致！
		registerPage.isMsgOK("msgerror","校验码不正确！");//手机号码与验证码不一致！
	}
	
	/**
	 * 徐天元
	 * 注册 -短信验证码   设目前手机号为A,未注册手机号为B,修改手机号为B,然后获取手机号B的验证码,然后再次修改手机号为A,输入手机号B的验证码
	 */
	@Test(priority = 7)
	public void registerOtherTelSMSCode_web_26_3() {
		Reporter.log("注册P1:短信验证码,设目前手机号为A,未注册手机号为B,修改手机号为B,然后获取手机号B的验证码,然后再次修改手机号为A,输入手机号B的验证码,提示手机号码与验证码不一致！<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_Register_tel;
		}else {
			tel = data.phoneConcatenation(0);
		}
		//进入注册页面
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//点击“我要投资”
		registerPage.selectRole("我要借款");
		//填写账户信息
		registerPage.setTelInfo(tel,password);
		//是否进入验证手机界面  上方导航栏显示验证手机号页面
		//registerPage.isTurnVerifyTelPage();
		//设目前手机号为A,未注册手机号为B,修改手机号为B,然后获取手机号B的验证码,然后再次修改手机号为A,输入手机号B的验证码
		registerPage.inputSMSCode(tel,"otherTel");
		//提示手机号码与验证码不一致！
		registerPage.isMsgOK("msgerror","校验码不正确！");//校验码不正确！   手机号码与验证码不一致！
	}
	
	/**
	 * 徐天元
	 * 注册 -短信验证码   先后获取2次验证码,收到第二次验证码以后,输入第一次验证码
	 */
	@Test(priority = 8)
	public void registerFirstSMSCode_web_26_4() {
		Reporter.log("注册P1:短信验证码, 先后获取2次验证码,收到第二次验证码以后,输入第一次验证码,提示验证码有误，请核对！<br/>");
		Reporter.log("注册P1:短信验证码, 输入全角验证码,提示验证码有误，请核对！<br/>");
		Reporter.log("注册P1:短信验证码,倒序输入验证码,提示验证码有误，请核对！<br/>");
		Reporter.log("注册P1:短信验证码,乱序输入验证码,提示验证码有误，请核对！<br/>");
		Reporter.log("注册P1:短信验证码,输入1234567,提示验证码有误，请核对！<br/>");
		Reporter.log("注册P1:短信验证码,输入中文中文中文,提示验证码有误，请核对！<br/>");
		Reporter.log("注册P1:短信验证码,输入abcabc,提示验证码有误，请核对！<br/>");
		Reporter.log("注册P1:短信验证码,输入!!!!!!,提示验证码有误，请核对！<br/>");
		Reporter.log("注册P1:短信验证码,不输入短信验证码,点击下一步，提示验证码有误，请核对！<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_Register_tel;
		}else {
			tel = data.phoneConcatenation(0);
		}
		//进入注册页面
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//点击“我要投资”
		registerPage.selectRole("我要借款");
		//填写账户信息
		registerPage.setTelInfo(tel,password);
		//是否进入验证手机界面  上方导航栏显示验证手机号页面
		//registerPage.isTurnVerifyTelPage();
		//先后获取2次验证码,收到第二次验证码以后,输入第一次验证码
		registerPage.inputSMSCode(tel,"first");
		base.sleep(3000);
		//提示验证码有误，请核对！
		try {
			registerPage.isMsgOK("msgerror","校验码不正确！");
		} catch (AssertionError e) {
			registerPage.isMsgOK("msgerror","验证码有误，请核对！");
		}
		/////////////////////////////
		String code = registerPage.getTelCode(tel);
		//输入全角验证码
		registerPage.inputSMSCodeByCode(code,"SBCCase");
		//提示验证码有误，请核对！
		registerPage.isMsgOK("msgerror","验证码有误，请核对！");
		//倒序输入验证码
		registerPage.inputSMSCodeByCode(code,"desc");
		//提示验证码有误，请核对！
		registerPage.isMsgOK("msgerror","验证码有误，请核对！");
		registerPage.inputSMSCodeByCode(code,"confuse");
		//提示验证码有误，请核对！
		registerPage.isMsgOK("msgerror","验证码有误，请核对！");
		//输入1234567
		registerPage.inputSMSCodeByCode(code,"1234567");
		base.sleep(5000);
		//提示验证码有误，请核对！
		registerPage.isMsgOK("msgerror","验证码错误");
		//输入中文中文中文
		registerPage.inputSMSCodeByCode(code,"中文中文中文");
		//提示验证码有误，请核对！
		registerPage.isMsgOK("msgerror","验证码有误，请核对！");
		//输入abcabc
		registerPage.inputSMSCodeByCode(code,"abcabc");
		//提示验证码有误，请核对！
		registerPage.isMsgOK("msgerror","验证码有误，请核对！");
		//输入!!!!!!
		registerPage.inputSMSCodeByCode(code,"!!!!!!");
		//提示验证码有误，请核对！
		registerPage.isMsgOK("msgerror","验证码有误，请核对！");
		//不输入短信验证码,点击下一步
		registerPage.inputSMSCodeByCode(tel,"no");
		registerPage.submit();
		//提示验证码有误，请核对！
		registerPage.isNoSMSCodeMesOK();
	}
	
	/**
	 * 徐天元
	 * 注册 -短信验证码   点击返回重新填写信息按钮   返回上一级页面,验证码刷新,密码框清空
	 */
	@Test(priority = 9)
	public void registerGobackSMSCode_web_26_16() {
		Reporter.log("注册P1:短信验证码,点击返回重新填写信息按钮   返回上一级页面,验证码刷新,密码框清空<br/>");
		if (!base.browserType.contains("ie")) {
			if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
				tel = Data.test_run_Register_tel;
			}else {
				tel = data.phoneConcatenation(0);
			}
			//进入注册页面
			base.openBrowser(base.indexURL  + "/page/register/register.jsp");
			//点击“我要投资”
			registerPage.selectRole("我要借款");
			//填写账户信息
			registerPage.setTelInfo(tel,password);
			//点击返回重新填写信息按钮
			registerPage.goback();
			//验证返回上一级页面  密码框清空
			registerPage.isGoback();
		}else {
			Reporter.log("IE:返回上级功能不兼容！（注册 -短信验证码   点击返回重新填写信息按钮   返回上一级页面,验证码刷新,密码框清空）<br/>");
		}
	}
	
	/**************************注册成功页面提示***********************/
//	/**
//	 * 徐天元
//	 * 注册 -短信验证码   不输入短信验证码,点击下一步
//	 */
//	@Test(priority = 10)
//	public void registerNoSMSCode_web_26_17() {
//		Reporter.log("注册P1:短信验证码,不输入短信验证码,点击下一步，提示验证码有误，请核对！");
//		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
//			tel = Data.test_run_Register_tel;
//		}else {
//			tel = data.phoneConcatenation(0);
//		}
//		//进入注册页面
//		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
//		//点击“我要投资”
//		registerPage.selectRole("我要借款");
//		//填写账户信息
//		registerPage.setTelInfo(tel,password);
//		//不输入短信验证码,点击下一步
//		registerPage.inputSMSCode(tel,"no");
//		registerPage.submit();
//		//提示验证码有误，请核对！
//		registerPage.isNoSMSCodeMesOK();
//	}
	
	/**************************注册成功页面提示***********************/
	/**
	 * 徐天元
	 * 注册 -完成通用注册信息后点击完成注册  显示成功页面显示,通过运营商借款用户;点击浏览器返回上一级页面,页面失效或者数据清空
	 */
	@Test(priority = 11,enabled=false)
	public void registerOK_web_12_1() {
		Reporter.log("注册P1:完成通用注册信息后点击完成注册  显示成功页面显示,通过运营商借款用户;点击浏览器返回上一级页面,页面失效或者数据清空<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_Register_tel;
		}else {
			tel = data.phoneConcatenation(0);
		}
		//进入注册页面
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//点击“我要投资”
		registerPage.register("debit", tel, password);
		registerPage.isRegisterOK();
		Reporter.log(tel+"注册成功");
		if (base.browserType.equals("ff")) {
			base.goBack();
			registerPage.isGoback404();
		}else {
			Reporter.log("IE，chrome:忽略!，只适用于火狐(注册 -完成通用注册信息后点击完成注册  显示成功页面显示,通过运营商借款用户;点击浏览器返回上一级页面,页面失效或者数据清空)<br/>");
		}
	}
	
	/**
	 * 徐天元
	 * 注册 -完成通用注册信息后点击完成注册  显示成功页面显示,通过运营商借款用户,显示借款认证流程,显示在 "2身份证认证"步骤,1步骤跳过
	 */
	@Test(priority = 12,enabled=false)
	public void registerOK_web_12_3(){
		Reporter.log("注册P1:完成通用注册信息后点击完成注册  显示成功页面显示,通过运营商借款用户,显示借款认证流程,显示在 “2身份证认证”步骤,1步骤跳过<br/>");
		tel = data.phoneConcatenation(0);
		//首页点击注册
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		Reporter.log("借入者注册>>>>>>>>");
		Reporter.log("手机："+tel);
		//注册
		registerPage.register("debit", tel, password);
		//验证注册成功
		registerPage.isRegisterOK();
		//点击'通过运营商借款用户'
		registerPage.clickOperatorDebiterBtn();
		//判断进入借入验证界面
		registerPage.isDebitVerifyPage();		
	}
}
