package com.eloancn.shared.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.IndexPage;
import com.gargoylesoftware.htmlunit.Page;

/*
 * 登录页
 */
public class LoginPage {
	
	Base base = new Base();
	Data data = new Data();
	
	IndexPage indexPage = new IndexPage();
	
	public static By Iframe = By.id("loginBoxFrame");
	public static By LoginBox = By.id("loginFrameBox");
	public static By LoginTitle = By.cssSelector("span.fl.font20");
	public static By LoginLnk = By.id("login_1");
	public static By LoginPart = By.id("form_login1");
	static By RegisterLnk = By.xpath("//ul[@class='topBarR fr']/li");
//	By nameTxt = By.id("loginName"); //用户名
	By nameTxt = By.cssSelector("#loginName"); //用户名
	By nameTxtByXpath = By.xpath("//input[@id='loginName']"); //用户名
	By passTxt = By.cssSelector("#tpassword");//首页密码
	By passTxtByXpath = By.xpath("//input[@id='tpassword']");//首页密码
	By passOtherPageTxt = By.cssSelector("#pwdshowtext");//我的账户等其他页面进入的登录密码
//	By loginBtn = By.xpath("//input[@class='loginBtn']");//确定
	By loginBtn = By.cssSelector(".loginBtn");
	By loginBtnByXpath = By.xpath("//input[@class='loginBtn']");
	By loginLink = By.xpath("//a[text()='登录']");
	By loginOtherPageBtn = By.cssSelector(".h50>input[type='button']");//By.xpath("//input[@class='loginBtn-new ']");
//	By quitBtn = By.xpath("//a[text()='退出']");//退出   //a[text()='退出'] //a[@href='/logout.jsp'] //li[@class='global'][1]/a
	By quitBtn = By.cssSelector(".vwmy>a");//.topBarR.fr > li:nth-child(3) > a
	By loginTxt = By.xpath("//*[@id='form_login1']//span[text()='登录']");
	By freeRegisterLink = By.cssSelector(".fr.lh40>a");//免费注册
	
	/**
	 * 获取“退出”链接元素
	 * @return 退出元素
	 * @author 江渤洋 2015-5-15
	 */
	public WebElement getQuitBtn(){
		return base.getElementWithVisible(quitBtn);
	}
	
	/**
	 * 登出（只能验证首页是否登录）
	 * @author 江渤洋 2015-12-21
	 */
    public void logoutByIndex(){
		if(!isLogout()){
			base.logout();
		}
    }
    
	/**
	 * 登出（只能验证我的账户是否登录）
	 * @author 江渤洋 2015-12-21
	 */
    public void logoutByMyAccount(){
		if(ifMyAccountLogin()){
			base.logout();
		}
    }
	
	/**
	 * 徐天元
	 * 输入手机号
	 */
	public void inputTel(String tel){
		base.sendKeysWithWait(nameTxt, tel);
	}
	
	/**
	 * 徐天元
	 * 点击登录
	 */
	public void clickLoginBtn(){
		base.clickWithWait(loginBtn);
	}
	
	/**
	 * 提示账户或密码错误，账户和密码输入框清空，并显示验证码输入模块  
	 */
	public void isLoginWrong(){
		base.switchToFrame("loginBoxFrame");
		//提示账户或密码错误
		base.checkElementVisible(By.cssSelector("#errorMessage"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#errorMessage")), "用户名与密码不匹配。");
		//账户密码清空
		base.isElementContainsValue(By.cssSelector("#loginName"),"value","邮箱/身份证/手机号");
		base.assertEqualsActualExpected(base.getAttribute(By.cssSelector("#tpassword"),"value"), "");
		//显示验证码输入模块
		base.checkElementVisible(By.cssSelector("#randCode"));
	}
	
	public void wrongMsg(String msg){
		if(base.isElementPresentNoWait(Iframe)){
			base.switchToFrame("loginBoxFrame");
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#errorMessage")), msg);
	}
	
	/**
	 * 徐天元
	 * 点击免费注册
	 */
	public void clickFreeRegister(){
		base.clickWithWait(freeRegisterLink);
	}
	
	/**
	 * 徐天元
	 * 关闭登录窗口
	 */
	public void closeLogin(){
		base.clickWithWait(By.cssSelector(".close"));
		base.fromFrameToDefaultContent();
		//base.isElementEmpty(By.cssSelector(".loginCont2"));
		base.checkNoElement(By.cssSelector(".loginCont2"));
	}
	
	/**********************************网站首页登录***************************************/
	
	/**
	 * 徐天元
	 * 首页登录
	 * 修改  江渤洋 2015-6-25
	 */
	public void login(String name, String pass){
		if (base.gethandelsNum()>=2) {
			base.closeWebDriver();
		}
		//判断是否出现iframe层
//		if(base.isElementPresent(By.xpath("//iframe[@id='loginBoxFrame']"))){
		if(base.isElementPresenceNoWait(Iframe)){
			base.switchToFrame("loginBoxFrame");
		}
		base.sendKeysWithWait(nameTxt, name);
		base.sendKeysWithWait(passTxt, pass);
		/*if (base.checkVisibleNoWaite(By.cssSelector("#randCodeP"))) {
			String imgCode = data.get(base.getElementWithWait(By.cssSelector("#randCodeImg")), base.getWebDriver());
			System.out.println("验证码是："+imgCode);
			base.sendKeysWithWait(By.cssSelector("#randCode"), imgCode);
		}*/
		base.clickWithWait(loginBtn);
		base.fromFrameToDefaultContent();
		base.isTitleContains(PageTitles.shouYe);
		//base.checkElmentwithTxt(quitBtn, "退出");
		//isLoginOK();
	}

	//首页登录
	public String login(String clientname, String clientpass,String clientpaypass,String testname,String testpass,String testpaypass){
		if(base.getLnkElementText(RegisterLnk, "class").contains("hide")){
			new IndexPage().clickLoginLink();
			if(base.Windowsize()!=1){
				base.turnToOldPage();
			}
			if(base.indexURL.contains("www") || base.indexURL.contains("test")){
				login(testname,testpass);
				return testpaypass;
			}else{
				login(clientname,clientpass);
				return clientpaypass;
			}
		}else{
			if(base.indexURL.contains("www") || base.indexURL.contains("test")){
				return testpaypass;
			}
			else{
				return clientpaypass;
			}
		}
	}
		
	/**
	 * 首页登录
	 * 用XPath获取页面元素，使用IE
	 * 修改  江渤洋 2015-6-25
	 */
	public void loginWithXpath(String name, String pass){
		//判断是否出现iframe层
		if(base.isElementPresent(By.cssSelector("#loginBoxFrame"))){
			base.switchToFrame("loginBoxFrame");
		}
		base.sleep(3000);
		base.sendKeysWithWait(nameTxtByXpath, name);
		base.sendKeysWithWait(passTxtByXpath, pass);
		base.clickWithWait(loginBtnByXpath);
		base.fromFrameToDefaultContent();
	}
	
	/**********************************网站我的账户登录***************************************/
	
	/**
	 * 徐天元
	 * 我的账户等其他页面的登录(没有frame)
	 */
	public void loginWithNoFrame(String name, String pass){
		base.sendKeysWithWait(nameTxt, name);
//		int i = 0;
//		do {
//		    i++;
//			base.clickWithWait(passOtherPageTxt);
//		} while (!base.checkVisible(passTxt, 2) && i<5);
		base.setDisplayById("pwdshowtext","none");
		base.setDisplayById("tpassword","block");
		base.sendKeysWithWait(passTxt, pass);
		base.clickWithWait(loginOtherPageBtn);//登录
		base.sleep(3000);
	}
	
	/**
	 * 从我的账户登录
	 * @param logiName 用户名
	 * @param password 密码
	 * @author 江渤洋 2015-7-10
	 */
	public void loginByMyAccount(String loginName, String password){
		
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		TotalPage.openPage("我的账户", false);
		loginWithNoFrame(loginName, password);
		TotalPage.openPage("我的账户", true);
		try {
			base.assertEqualsActualExpectedByBoolean(ifLogin(), true);
		} catch (Exception e1) {
			System.out.println("账户：" + loginName + " 登录失败！");
			Reporter.log("账户：" + loginName + " 登录失败！");
		}
	}

	public String loginByMyAccount(String clientuserName, String clientpassword,String clientpaypassword,String testuserName,String testpassword,String testpaypassword){
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		if(base.indexURL.contains("client")){
			loginWithNoFrame(clientuserName, clientpassword);
			return clientpaypassword;
		}else{
			loginWithNoFrame(testuserName, testpassword);
			return testpaypassword;
		}
	}
	
	//刘京-我的账户登录
	public void LogininMyAccount(String name, String pass){
		base.sendKeysWithWait(nameTxt, name);
		base.checkElementClickable(passOtherPageTxt,10);
		base.clickWithWait(passOtherPageTxt);
		base.checkNoElement(passOtherPageTxt);
		base.checkElementVisible(passTxt);
		base.sendKeysWithWait(passTxt, pass);
		base.clickWithWait(loginOtherPageBtn);//登录
		base.sleep(3000);
	}
	
	/**********************************网站新手专区登录***************************************/
	
	/**
	 * 徐天元
	 * 新手专区 快速投资  登录
	 */
	public void fastInvestLogin(String name, String pass){
		base.sendKeysWithWait(nameTxt, name);
		base.sendKeysWithWait(passTxt, pass);
		base.clickWithWait(loginBtn);
	}
	
	/**********************************网站判断是否登录、登出***************************************/
	
	/**
	 * 徐天元
	 * 验证是登录状态  web
	 */
	public void isLoginOK(){
		//base.assertNotNullBy(quitBtn);
		base.refreshPage();
		//“退出”隐藏
		base.assertTrueByBoolean(!base.getElementWithWait(By.xpath("//a[text()='退出']/parent::li")).getAttribute("class").contains("hide"));
	}
	
	/**
	 * 是否登出(首页可以判断，我的账户页不能判断)
	 * @return true：登出，false：登录
	 * @author 江渤洋 2015-12-11 
	 */
	public boolean isLogout(){
		return base.getElementWithWait(By.xpath("//a[text()='退出']/parent::li")).getAttribute("class").contains("hide");//“退出”隐藏
	}
	
	/**
	 * 徐天元
	 * 验证是未登录状态
	 */
	public void isNotLogin(){
		try {
			base.assertNotNullBy(loginLink);
		} catch (AssertionError e) {
			base.assertNotNullBy(loginTxt);
		}
	}
	
	/**
	 * 判断是否登录(我的账户)
	 * 江渤洋修改 2015-11-4
	 */
	public Boolean ifLogin(){
		base.checkElement(RegisterLnk);
		if(base.getLnkElementText(RegisterLnk, "class").equals("account_name")){
			return true;// 已登录
		}
		return false;// 未登录
	}
	
	/**
	 * 徐天元
	 * 我的账户是否登录
	 */
	public boolean ifMyAccountLogin(){
		if (base.checkVisible(loginTxt, 3)) {
			return false;
		}
		return true;
	}
	
	//重新登录
	public void reLogin(String name, String pass){
		base.logout();
		indexPage.clickLoginLink();
		login(name, pass);
	}
	
	/**
	 * 首页登录
	 * @param name
	 * @param pass
	 */
	public void homeLogin(String name, String pass){
		indexPage.clickLoginLink();
		loginWithXpath(name, pass);
	}
	
	/**********************************论坛登录、登出***************************************/
	
	/**
	 * 徐天元
	 * 验证论坛是登录状态
	 */
	public void isForumLoginOK(){
		base.assertNotNullBy(quitBtn);
	}
	
	/**
	 * 徐天元
	 * 验证论坛是未登录状态
	 */
	public void isForumNotLogin(){
		base.sleep(3000);
		base.assertNotNullBy(By.xpath("//button[text()='登录']"));
	}
	
}
