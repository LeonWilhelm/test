package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.AccountInfoPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RegisterPage;
import com.eloancn.shared.pages.SecurityAuthPage;

/**
 * 徐天元
 * 安全认证
 */
public class SecurityAuth_P2 {
	LoginPage loginPage = new LoginPage();
	Base base = new Base();
	Data data = new Data();
	RegisterPage registerPage = new RegisterPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	
	String tel = "13111111228";
	String emailUserd = "13111111171@qq.com";//已使用的邮箱
	String telUserd = "13111111171";//已使用的邮箱
	String email = "123@126.com";
	String user = "15095663196";//安全认证
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_ECunBao_register;
			emailUserd = "ff@qq.com";
			email = "aa@qq.com";
			user = email;
			telUserd = "18880000200";
		}
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
	}

	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(priority = 1)
	public void checkAccountInfoEmail_web_1273(){
		Reporter.log("安全认证P2:账户信息填写-邮箱认证,输入1@qq.com、输入1234567890123456789012345678901234@qq.com、"
				+"输入123456789012345678901234567890123@qq.com、输入!#$%^@qq.com、输入abc_123@qq.com、"
				+"输入已经使用过的邮箱、输入邮箱前缀暂停后、输入全角ａｂｃｄｅｆ@qq.com<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, "111111");
		myAccountPage.turnToMyAccount("账户信息");
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.updateInfo("1@qq.com","email");
		accountInfoPage.isUpdateInfoOK("ok","pemail");
		accountInfoPage.updateInfo("1234567890123456789012345678901234@qq.com","email");
		accountInfoPage.isUpdateInfoOK("Email地址太长，请输入有效的Email！","pemail");
		accountInfoPage.updateInfo("123456789012345678901234567890123@qq.com","email");
		accountInfoPage.isUpdateInfoOK("ok","pemail");
		accountInfoPage.updateInfo("ok","email");
		accountInfoPage.isUpdateInfoOK("请输入有效的Email！","pemail");
		accountInfoPage.updateInfo("!#$%^@qq.com","email");
		accountInfoPage.isUpdateInfoOK("请输入有效的Email！","pemail");
		accountInfoPage.updateInfo("abc_123@qq.com","email");
		accountInfoPage.isUpdateInfoOK("ok","pemail");
		accountInfoPage.updateInfo("ａｂｃｄｅｆ@qq.com","email");
		accountInfoPage.isUpdateInfoOK("请输入有效的Email！","pemail");
		//此邮箱地址已被使用！
		accountInfoPage.updateInfo(emailUserd,"email");
		accountInfoPage.isUpdateInfoOK("此邮箱地址已被使用！","pemail");
	}

	@Test(priority = 2)
	public void checkAccountInfoName_web_1270(){
		Reporter.log("安全认证P2:账户信息填写-姓名,输入一、输入一二三四五六七八九十零、输入一二三四五六七八九十、输入!@#$%、"
				+"输入abcdef、输入中文 (文后面带空格)、输入中文(中前面带空格)、输入中文(中间带空格)、输入中文123、输入中文abc、输入中文!@#<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(tel, "111111");
			myAccountPage.turnToMyAccount("账户信息");
			accountInfoPage.clickUpdateBtn();
		}
		accountInfoPage.updateInfo("一","name");
		accountInfoPage.isUpdateInfoOK("真实姓名必须是一个字以上!","prealnametip");
		accountInfoPage.updateInfo("一二三四五六七八九十零","name");//请输入姓名(2-10位汉字)
		accountInfoPage.isUpdateInfoOK("ok","prealnametip");
		accountInfoPage.updateInfo("一二三四五六七八九十","name");
		accountInfoPage.isUpdateInfoOK("ok","prealnametip");
		accountInfoPage.updateInfo("!@#$%","name");
		accountInfoPage.isUpdateInfoOK("真实姓名必须全部为中文!","prealnametip");
		accountInfoPage.updateInfo("abcdef","name");
		accountInfoPage.isUpdateInfoOK("真实姓名必须全部为中文!","prealnametip");
		accountInfoPage.updateInfo("中 文","name");
		accountInfoPage.isUpdateInfoOK("真实姓名必须全部为中文!","prealnametip");
		accountInfoPage.updateInfo("中文123","name");
		accountInfoPage.isUpdateInfoOK("真实姓名必须全部为中文!","prealnametip");
		accountInfoPage.updateInfo("中文abc","name");
		accountInfoPage.isUpdateInfoOK("真实姓名必须全部为中文!","prealnametip");
		accountInfoPage.updateInfo("中文!@#","name");
		accountInfoPage.isUpdateInfoOK("真实姓名必须全部为中文!","prealnametip");
		accountInfoPage.updateInfo("中文 ","name");
		accountInfoPage.isUpdateInfoOK("ok","prealnametip");//ok  真实姓名必须全部为中文!
		accountInfoPage.updateInfo(" 中文","name");
		accountInfoPage.isUpdateInfoOK("","prealnametip");//""  真实姓名必须全部为中文!
	}
	
	@Test(priority = 3)
	public void checkAccountInfoIdCard_web_1271(){
		Reporter.log("安全认证P2:账户信息填写-身份证号,输入11010519850423007X、输入11010519850423007x、输入110105198504230、输入110105198504230071"
				+"输入中文中文中文中文中文中文中文中文中文、输入!!!!!!!!!!!!!!!!!!、输入11010519850423007X1、输入１１０１０５１９８５０４２３００７Ｘ、输入abcdabcdabcdabcdcd<br/>");
		if (!loginPage.ifMyAccountLogin()) {
			base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(tel, "111111");
			myAccountPage.turnToMyAccount("账户信息");
			accountInfoPage.clickUpdateBtn();
		}
		accountInfoPage.updateInfo("11010519850423007X","idCard");
		accountInfoPage.isUpdateInfoOK("ok","pidcardtip");
		accountInfoPage.updateInfo("11010519850423007x","idCard");//请输入姓名(2-10位汉字)
		accountInfoPage.isUpdateInfoOK("ok","pidcardtip");
		accountInfoPage.updateInfo("110105198504230","idCard");
		accountInfoPage.isUpdateInfoOK("身份证号码有误,请检查!","pidcardtip");
		accountInfoPage.updateInfo("110105198504230071","idCard");
		accountInfoPage.isUpdateInfoOK("身份证号码有误,请检查!","pidcardtip");
		accountInfoPage.updateInfo("中文中文中文中文中文中文中文中文中文","idCard");
		accountInfoPage.isUpdateInfoOK("身份证号码有误,请检查!","pidcardtip");
		accountInfoPage.updateInfo("!!!!!!!!!!!!!!!!!!","idCard");
		accountInfoPage.isUpdateInfoOK("身份证号码有误,请检查!","pidcardtip");
		accountInfoPage.updateInfo("１１０１０５１９８５０４２３００７Ｘ","idCard");
		accountInfoPage.isUpdateInfoOK("身份证号码有误,请检查!","pidcardtip");
		accountInfoPage.updateInfo("abcdabcdabcdabcdcd","idCard");
		accountInfoPage.isUpdateInfoOK("身份证号码有误,请检查!","pidcardtip");
	}
	
	@Test(priority = 4)
	public void checkAccountInfoTel_web_1272(){
		Reporter.log("安全认证P2:账户信息填写-手机号,输入正确的手机号、输入10位手机号、输入12位手机号、输入已经注册的手机号"
				+"!@#$)(*^%%、输入中文中文中文、倒序输入有效的手机号、乱序输入有效的手机号、不输入手机号<br/>");
		base.logout();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(email, "111111");
		myAccountPage.turnToMyAccount("账户信息");
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.updateInfo(new Data().phoneConcatenation(0),"tel");
		accountInfoPage.isUpdateInfoOK("ok","pmobile");
		accountInfoPage.updateInfo("1311111111","tel");//请输入姓名(2-10位汉字)
		accountInfoPage.isUpdateInfoOK("请输入正确的手机号！","pmobile");
		accountInfoPage.updateInfo("131111111111","tel");
		accountInfoPage.isUpdateInfoOK("请输入正确的手机号！","pmobile");
		accountInfoPage.updateInfo(telUserd,"tel");
		accountInfoPage.isUpdateInfoOK("此手机号已经被注册过！","pmobile");
		accountInfoPage.updateInfo("!@#$)(*^%%","tel");
		accountInfoPage.isUpdateInfoOK("请输入正确的手机号！","pmobile");
		accountInfoPage.updateInfo("中文中文中文","tel");
		accountInfoPage.isUpdateInfoOK("请输入正确的手机号！","pmobile");
		accountInfoPage.updateInfo(base.desc(new Data().phoneConcatenation(0)),"tel");
		accountInfoPage.isUpdateInfoOK("请输入正确的手机号！","pmobile");
		accountInfoPage.updateInfo(base.confuse(new Data().phoneConcatenation(0)),"tel");
		accountInfoPage.isUpdateInfoOK("请输入正确的手机号！","pmobile");
		accountInfoPage.updateInfo("","tel");
		accountInfoPage.isUpdateInfoOK("请输入认证的手机号！","pmobile");
		accountInfoPage.updateInfo(base.btoQ(new Data().phoneConcatenation(0)),"tel");
		accountInfoPage.isUpdateInfoOK("请输入正确的手机号！","pmobile");
	}
	
	@Test(priority = 5)
	public void checkIdentityAuthenticationNameNull_web_3529(){
		Reporter.log("安全认证P2：安全认证-身份证认证，姓名为空,提示真实姓名不能为空!<br/>");
		base.logout();
		//注册
//		String tel = data.phoneConcatenation(0);
//		String password = Data.password;
//		base.openBrowser(base.indexURL + "/page/register/register.jsp");
//		tel = registerPage.register("credit", tel, password);
//		registerPage.clickRecharge();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(user, "111111");
		//身份认证
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendName("");
		securityAuthPage.sendIDCard(data.idConcatenation());
		//校验
		securityAuthPage.checkName("真实姓名不能为空!");
	}
	
	@Test(priority = 6)
	public void checkIdentityAuthenticationIdCardNull_web_3530(){
		Reporter.log("安全认证P2：安全认证-身份证认证，身份证号为空姓名正确填写,提示身份证号码不能为空!<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(user, "111111");
		}
		//身份认证
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendIDCard("");
		securityAuthPage.sendName("张三");
		//校验
		securityAuthPage.checkIdCard("身份证号码不能为空!");
	}
	
	@Test(priority = 7)
	public void checkIdentityAuthenticationIdCardAndNameOneChar_web_3533(){
		Reporter.log("安全认证P2：安全认证，姓名、身份证输入框输入最小字符1个字<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//登录
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(user, "111111");
		}
		//身份认证
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendName("张");
		securityAuthPage.sendIDCard("1");
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		//校验
		securityAuthPage.checkName("真实姓名必须在2~20个汉字之间!");
		securityAuthPage.checkIdCard("身份证号码有误,请检查!");
	}
	
	@Test(priority = 8)
	public void checkIdentityAuthenticationIdCardMoreThanLenth_web_3534(){
		Reporter.log("安全认证P2：安全认证，身份证输入框输入最大边界字符,超过18位<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//登录
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(user, "111111");
		}
		//身份认证
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendIDCard(data.idConcatenation()+"1");
		securityAuthPage.sendName("张三");
		//校验
		securityAuthPage.checkIdCard("身份证号码有误,请检查!");
	}
	
	@Test(priority = 9)
	public void checkIdentityAuthenticationIdCardAndNameSpecialChar_web_3537(){
		Reporter.log("安全认证P2：安全认证，姓名身份证号输入特殊字符<br/>");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//登录
		if (!loginPage.ifMyAccountLogin()) {
			loginPage.loginWithNoFrame(user, "111111");
		}
		//身份认证
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendName("张 三");
		securityAuthPage.sendIDCard("110105@98504230");
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		//校验
		securityAuthPage.checkIdCard("身份证号码有误,请检查!");
		securityAuthPage.checkName("真实姓名必须全部为中文!");
	}
}
