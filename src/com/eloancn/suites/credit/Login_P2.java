package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
/**
 * 徐天元
 * 登录P1
 */
public class Login_P2 {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	
	String tel = "";
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}

	@Test(priority=1)
	public void checkTelLengthLogin_web_1308(){
		Reporter.log("输入10位的手机号、输入12位手机号、输入11位的非手机号数字,提示错误信息<br/>");
		indexPage.clickLoginLink();
		//输入10位的手机号
		loginPage.login("1312123123", "111111");
		loginPage.wrongMsg("用户名必须是email或手机号或18位身份证号!");
		//输入12位手机号
		loginPage.inputTel("131212312311");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("用户名必须是email或手机号或18位身份证号!");
		//输入11位的非手机号数字
		loginPage.inputTel("11121231231");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("手机号码格式不正确!");
		loginPage.closeLogin();
	}
	
	@Test(priority=2)
	public void checkTelTypeLogin_web_1309(){
		Reporter.log("输入11的英文字母、输入11位的汉字、输入11位的特殊符号、输入11位手机号，中间有空格、输入11位的手机号，手机号前面有空格，提示错误信息<br/>");
		indexPage.clickLoginLink();
		//输入11的英文字母
		loginPage.login("aaaaaaaaaaa", "111111");
		loginPage.wrongMsg("手机号码格式不正确!");
		//输入11位的汉字
		loginPage.login("阿阿阿阿阿阿阿阿阿阿阿", "111111");
		loginPage.wrongMsg("手机号码格式不正确!");
		//输入11位的特殊符号
		loginPage.inputTel("!!!!!!!!!!!");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("手机号码格式不正确!");
		//输入11位手机号，中间有空格
		loginPage.inputTel("131 11111171");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("用户名必须是email或手机号或18位身份证号!");
		//输入11位的手机号，手机号前面有空格
		loginPage.inputTel(" 13111111171");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("手机号码格式不正确!");
		loginPage.closeLogin();
	}
	
	@Test(priority=3)
	public void checkEmailLogin_web_1310(){
		Reporter.log("输入邮箱不含@符号、输入邮箱不含.com、输入邮箱不含域名、输入邮箱地址含有空格，提示错误信息<br/>");
		indexPage.clickLoginLink();
		//输入邮箱不含@符号
		loginPage.login("123126.com", "111111");
		loginPage.wrongMsg("用户名必须是email或手机号或18位身份证号!");
		//输入邮箱不含.com
		loginPage.login("123@126", "111111");
		loginPage.wrongMsg("email格式不符合要求!");
		//输入邮箱不含域名
		loginPage.inputTel("123@.com");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("email格式不符合要求!");
		//输入邮箱地址含有空格
		loginPage.inputTel("12 3@126.com");
		loginPage.clickLoginBtn();
		loginPage.wrongMsg("email格式不符合要求!");
		loginPage.closeLogin();
	}
	
	@Test(priority=4)
	public void checkIDcardLenthLogin_web_1313(){
		Reporter.log("输入17位的身份证号、输入19位的身份证号，提示错误信息<br/>");
		indexPage.clickLoginLink();
		//输入17位的身份证号
		loginPage.login("11010519850423007", "111111");
		loginPage.wrongMsg("用户名必须是email或手机号或18位身份证号!");
		//输入19位的身份证号
		loginPage.login("110105198504230071X", "111111");
		loginPage.wrongMsg("用户名必须是email或手机号或18位身份证号!");
		loginPage.closeLogin();
	}
	
	@Test(priority=5)
	public void checkIDcardTypeLogin_web_1316(){
		Reporter.log("输入18位的英文字母、输入18位的特殊符号、输入18位汉字、输入数字,英文字母,特殊符号的组合、输入18位的身份证号，含有前空格、输入18位的身份证号，中间含有空格、输入18位的身份证号，含有后空格，提示错误信息<br/>");
		indexPage.clickLoginLink();
		//输入18位的英文字母
		loginPage.login("aaaaaaaaaaaaaaaaaa", "111111");
		loginPage.wrongMsg("身份证号码有误,请检查!");
		//输入18位的特殊符号
		loginPage.login("!!!!!!!!!!!!!!!!!!", "111111");
		loginPage.wrongMsg("身份证号码有误,请检查!");
		//输入18位汉字
		loginPage.login("阿阿阿阿阿阿阿阿阿阿阿阿阿阿阿阿阿阿", "111111");
		loginPage.wrongMsg("身份证号码有误,请检查!");
		//输入数字,英文字母,特殊符号的组合
		loginPage.login("12345!!!!!a!!1!!!!", "111111");
		loginPage.wrongMsg("身份证号码有误,请检查!");
		//输入18位的身份证号，含有前空格
		loginPage.login(" 11010519850423007X", "111111");
		loginPage.wrongMsg("身份证号码有误,请检查!");
		//输入18位的身份证号，中间含有空格
		loginPage.login("1101051985 0423007X", "111111");
		loginPage.wrongMsg("用户名必须是email或手机号或18位身份证号!");
		//输入18位的身份证号，含有后空格
		loginPage.login("11010519850423007X ", "111111");
		loginPage.wrongMsg("身份证号码有误,请检查!");
		loginPage.closeLogin();
	}
	
	@Test(priority=6)
	public void checkIDcardContainsXLogin_web_1317(){
		Reporter.log("输入身份证号开头含有字母X、输入身份证号中间含有X、输入身份证号末尾为非X的字母、输入身份证末尾为小写x，提示错误信息<br/>");
		indexPage.clickLoginLink();
		//输入身份证号开头含有字母X
		loginPage.login("X11010519850423007", "111111");
		loginPage.wrongMsg("身份证号码有误,请检查!");
		//输入身份证号中间含有X
		loginPage.login("110105X19850423007", "111111");
		loginPage.wrongMsg("身份证号码有误,请检查!");
		//输入身份证号末尾为非X的字母
		loginPage.login("11010519850423007V", "111111");
		loginPage.wrongMsg("身份证号码有误,请检查!");
		//输入身份证末尾为小写x
		loginPage.login("11010519850423007x", "111111");
		loginPage.wrongMsg("用户名与密码不匹配。");
		loginPage.closeLogin();
	}
}
