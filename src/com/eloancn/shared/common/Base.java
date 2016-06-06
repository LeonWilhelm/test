package com.eloancn.shared.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.until.CssUtils;


public class Base extends Assert {
	public static WebDriver webDriver;
	public String browserType;
	public String indexURL;
	public String clientBackURL = "http://main.eloancn.com/wpf/admin/BDED4F051354CCE14DA598E666D28F72.jsp";// http://inback.eloancn.com/wpf/admin/BDED4F051354CCE14DA598E666D28F72.jsp(本地环境)
	public final int DEFAULT_WAIT_TIME = 30;
	
	public Base(){
		String properties = "parameters.properties";
		String curPath = new File("").getAbsolutePath();//当前路径
     	InputStream is = null;
		try {
			is = new FileInputStream(curPath+File.separator+properties);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties property = new Properties();
		try {
			property.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		browserType= property.getProperty("browserType");
		indexURL = property.getProperty("indexURL");
	}
	
	/**
	 *web工程获取当前路径
	 */
	public static String getContentPath(Class classNmae){
		String root = classNmae.getResource("/").getFile();
		String absolutePath ="";
		try {
			absolutePath = new File(root).getParentFile().getParentFile().getCanonicalPath()+"\\webapps\\registerTool";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return absolutePath;
	}
	
	public void setup(){
		
		try{		
			System.out.println("The browser is: " + browserType + "\n");
			System.out.println("The testing site is:" +indexURL);
	        if(browserType.equalsIgnoreCase("ff")){
	        	
	        	setup_ff();
	        }else if(browserType.equalsIgnoreCase("chrome")){
	        	
	        	setup_chrome();
	        }else if(browserType.toLowerCase().contains("ie")){
	        	
	        	setup_ie();
	        }  	        
		 	drivermanage();
		 	
		}catch(Exception e ){
	    	System.out.println("[ERROR]: Fail creating driver.");
	    	System.out.println(e.toString());
	    	System.exit(1);
		}
		
	}
	
	public void setup_ff(){
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);//设置成0代表下载到浏览器默认下载路径；设置成2则可以保存到指定目录；设置成1保存到桌面
		profile.setPreference("browser.download.dir", "C:\\");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/msword,application/octet-stream");
		webDriver=new FirefoxDriver(profile);
	}
	
	public void setup_chrome(){
		ChromeOptions options=new ChromeOptions();
		Map<String, Object> prefs=new HashMap<String, Object>();
		prefs.put("download.default_directory", "C:\\");
		options.setExperimentalOption("prefs", prefs);
		
	 	options.addArguments("test-type");
		System.setProperty("webdriver.chrome.driver","."+"\\libs\\chromedriver-2.20.exe");
	 	webDriver=new ChromeDriver(options);
	}
	
	public void setup_ie(){
		
		System.setProperty("webdriver.ie.driver","."+"\\libs\\IEDriverServer.exe");
	 	webDriver=new InternetExplorerDriver();
	}
	
	public void setup_ie_x86(){
		System.setProperty("webdriver.ie.driver","."+"\\libs\\IEDriverServer_x86.exe");
		//UK地址：C:\Windows\SysWOW64\ET99_FULL.dll
	 	webDriver=new InternetExplorerDriver();
	 	drivermanage();
	}
	
	public void drivermanage(){
		webDriver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 	webDriver.manage().window().maximize();
	}

    
    /**********************************cookie操作***********************************/
    
	//获取网址Cookie
    public Set<Cookie> getCookies(){
    	return webDriver.manage().getCookies();
    }
    
    //获取Cookie的个数
    public int getCookiesNum(Set<Cookie> cookies){
    	return cookies.size();
    }
    
    //获取Cookie名字
    public Cookie getCookie(String name){
    	return webDriver.manage().getCookieNamed(name);
    }
	
    public String getCookieInfo(Cookie cookie, String name){
    	String info = "";
    	switch(name){
    	case "作用域":	info = cookie.getDomain();				break;
    	case "名称":		info = cookie.getName();				break;
    	case "值" :		info = cookie.getValue();				break;
    	case "范围":		info = cookie.getPath();				break;
    	case "过期时间":	info = cookie.getExpiry().toString();	break;
    	}
    	return info;
    }
    
    public void printCookiesInfo(Set<Cookie> cookies){
    	for (Cookie cookie : cookies) {
			System.out.println(
					"作用域："		+ cookie.getDomain() 	+ "， " +
					"名称："		+ cookie.getName() 		+ "， " +
					"值：" 		+ cookie.getValue() 	+ "， " +
					"范围：" 		+ cookie.getPath() 		+ "， " +
					"过期时间：" 	+ cookie.getExpiry() 	+ "， "
					);
		}
    }
    
    public Cookie addCookie(String name, String value, String path, Date expiry){
    	return new Cookie(name, value, path, expiry);
    }
    
    public void addCookie(Cookie cookie){
    	webDriver.manage().addCookie(cookie);
    }
    
    public void delCookie(String name){
    	webDriver.manage().deleteCookieNamed(name);
    }
    
    public void delCookie(Cookie cookie){
    	webDriver.manage().deleteCookie(cookie);
    }
    
    public void delCookies(){
    	webDriver.manage().deleteAllCookies();
    }
    
	/**********************************url操作***********************************/
	
	//登出系统
    public void logout(){
    	this.openBrowser(indexURL + "/logout.jsp");
    }
    
    public WebDriver getWebDriver(){  	
    	return webDriver;
    }

    //获取当前Url
    public String getCurrentUrl(){
    	return webDriver.getCurrentUrl();
    }
    
    //打开网页
    public void openBrowser(String url){
    	webDriver.get(url);	
    	if (getElementTextWithPresence(By.cssSelector("body")).contains("系统繁忙")) {
			refreshPage();
		}
    if (getElementTextWithPresence(By.cssSelector("body")).contains("503 Service Unavailable")) {
			Reporter.log(CssUtils.red("系统服务器挂掉：503"));
			//tearDown();
			assertTrueByBoolean(false);
		}
    }

    //关闭
    public void tearDown(){
    	webDriver.quit();		
    }
    
    public void tearDownByClose(){
    	webDriver.close();
    }
    
    //跳转网页
    public void navigateTo(String url){
    	webDriver.navigate().to(url);
    }
    //页面刷新
    public void refreshPage(){
    	webDriver.navigate().refresh();
    }
    //返回上一页
    public void goBack(){
    	webDriver.navigate().back();
    }   
    
	/**
	 * 截取网址的服务器名
	 * 例如：http://mail.163.com/index.html
	 * 	   http://:是协议
	 *     mail：是服务器名
	 *     mail.163.com：是网站名
	 *     /：这个是根目录
	 *     index.html：这个是根目录下的默认网页
	 *     http://mail.163.com/index.html:这个叫做URL
	 * @param webSite(网站地址)
	 * @return 服务器名
	 */
	public String getWebsiteServerName(String webSite){
		//获取/后的内容。[0]：http:。[1]：空
		String interceptWebsite = webSite.split("/")[2];
		//获取第一个“.”的为索引
		int index = interceptWebsite.indexOf(".");
		//截取第一个点前面的字符串
		interceptWebsite = interceptWebsite.substring(0,index);
		//返回截取后的字符串
		return interceptWebsite;
	}
	
    /**
     * 获取当前网址中的服务器名。如：www.eloancn.com中的www
     * @return 返回服务器名
     * @author 江渤洋 2015-6-4
     */
	public String getServerNameByURL(){
		String interceptWebsite = getCurrentUrl();
		interceptWebsite = getWebsiteServerName(interceptWebsite);
		return interceptWebsite;
	}    
	
	
	/*****************************************************/
	/*****************      等待元素              ********************/
	/*****************************************************/
	
	
	/***********************    等待元素出现，并确认是否可点击         ****************************/
	
	public void checkElementClickable(By by,int time){
	    new WebDriverWait(webDriver, time).until(ExpectedConditions.elementToBeClickable(by));
	}
	
	/***********************    等待元素出现，并确认是否可选择         ****************************/
	
    public void checkElementSelected(By by,int time){
    	new WebDriverWait(webDriver, time).until(ExpectedConditions.elementToBeSelected(by));
    }
	
	/***********************    等待元素出现，并确认Title是否一致        **************************/
	
    public void checkTitle(String title){
    	new WebDriverWait(webDriver, 30).until(ExpectedConditions.titleIs(title));
    }
	
    public void checkContainsTitle(String title){
    	new WebDriverWait(webDriver, DEFAULT_WAIT_TIME).until(ExpectedConditions.titleContains(title));
    }
    
    public void checkContainsTitle(String title, int time){
    	new WebDriverWait(webDriver, time).until(ExpectedConditions.titleContains(title));
    }
    
    @Deprecated
    public boolean checkTitleContains(String title){
    	try {
			new WebDriverWait(webDriver, 30).until(ExpectedConditions.titleContains(title));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    @Deprecated
    public boolean checkTitleContains(String title,int time){
    	try {
			new WebDriverWait(webDriver, time).until(ExpectedConditions.titleContains(title));
			return true;
		} catch (Exception e) {
			return false;
		}
    }
	
	/***********************      等待Alert出现、显示                      ****************************/
    
    public void checkAlert(){
    	new WebDriverWait(webDriver, 20).until(ExpectedConditions.alertIsPresent());
    }
    
    public void checkAlert(int time){
    	new WebDriverWait(webDriver, time).until(ExpectedConditions.alertIsPresent());
    }
    
    /*********************      等待元素出现、且DOM显示                     *****************************/
    @Deprecated
    public void checkElement(By by){
    	new WebDriverWait(webDriver, 20).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    @Deprecated
    public void checkElement(By by,int time){
    	new WebDriverWait(webDriver, time).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    @Deprecated
    public void checkElements(By by){
    	new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    @Deprecated
    public void checkNoElement(By by){
    	new WebDriverWait(webDriver, 20).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    
    @Deprecated
    public boolean checkElementPresent(By by,int time){
    	try {
    		new WebDriverWait(webDriver, time).until(ExpectedConditions.presenceOfElementLocated(by));
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public void checkElementPresence(By by){
    	new WebDriverWait(webDriver, DEFAULT_WAIT_TIME).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    
    public void checkElementPresence(By by,int time){
    	new WebDriverWait(webDriver, time).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    
    public void checkElementsPresence(By by){
    	new WebDriverWait(webDriver, DEFAULT_WAIT_TIME).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    
    public void checkElementInvisible(By by){
    	new WebDriverWait(webDriver, DEFAULT_WAIT_TIME).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    
    /*********************      等待元素出现、且页面可见                      *****************************/
    
    public void checkElementVisible(By by){
    	new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
    public void checkElementVisible(By by, int time){
    	new WebDriverWait(webDriver, time).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void checkElementsVisible(By by){
    	new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    
    @Deprecated
    public boolean checkVisible(By by){
    	try {
    		new WebDriverWait(webDriver, 20).until(ExpectedConditions.visibilityOfElementLocated(by));
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    @Deprecated
    public boolean checkVisible(By by,int time){
    	try {
    		new WebDriverWait(webDriver, time).until(ExpectedConditions.visibilityOfElementLocated(by));
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    @Deprecated
    public boolean checkVisibleNoWaite(By by){
    	try {
    		new WebDriverWait(webDriver, 0).until(ExpectedConditions.visibilityOfElementLocated(by));
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    @Deprecated
    public boolean checkInvisibility(By by){
    	try {
			new WebDriverWait(webDriver, 20).until(ExpectedConditions.invisibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    /******************      等待元素出现、并校验元素值是否相同                    **************************/
    
    public void checkElmentText(By by, String text){  	
    	new WebDriverWait(webDriver, DEFAULT_WAIT_TIME).until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }
    
    public void checkElementwithValue(By by,String value){
    	new WebDriverWait(webDriver, 30).until(ExpectedConditions.textToBePresentInElementValue(by, value));
    }
    
    /*******************************判断元素是否存在、显示******************************/
    
    //不等待检查元素是否存在
    @Deprecated
    public boolean isElementPresentNoWait(By by) {
        try {
      	  webDriver.findElement(by);
      	  return true;
        	} catch (Exception e) {
        		return false;
        	}
    }
   //等待并检查元素是否存在
    @Deprecated
    public boolean isElementPresent(By by) {
      try {
    	  checkElement(by);
    	  webDriver.findElement(by);
    	  return true;
      	} catch (Exception e) {
      		return false;
      	}
    }
    //检查元素是否不存在
    @Deprecated
    public boolean isElementEmpty(By by){
    	return getElements(by).isEmpty();
    }
    
    public boolean isElementVisibleNoWait(By by){
    	try {
    		checkElementVisible(by,0);
    		return true;
		} catch (Exception e) {
			return false;
		}
    }

    //检查元素是否可见
    public boolean isElementVisible(By by){
    	try{
    		checkElementVisible(by);
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
    
    public boolean isElementVisible(By by, int time){
    	try {
    		checkElementVisible(by,time);
    		return true;
		} catch (Exception e) {
			return false;
		}
    }   
    
    //不等待检查元素是否存在
    public boolean isElementPresenceNoWait(By by) {
        try {
      	  webDriver.findElement(by);
      	  return true;
        	} catch (Exception e) {
        		return false;
        	}
    }
    
   //等待并检查元素是否存在
    public boolean isElementPresence(By by) {
      try {
    	  checkElementPresence(by);
    	  webDriver.findElement(by);
    	  return true;
      	} catch (Exception e) {
      		return false;
      	}
    }

    public boolean isElementPresence(By by,int time){
    	try {
    		checkElementPresence(by,time);
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public boolean isElementInvisibility(By by){
    	try {
			checkElementInvisible(by);
			return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public boolean isTitle(String title){
    	try {
    		checkTitle(title);
			return true;
    	} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public boolean isTitleContains(String title){
    	try {
    		checkContainsTitle(title);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public boolean isTitleContains(String title,int time){
    	try {
    		checkContainsTitle(title,time);
			return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    //检查alert是否显示
    public boolean isAlertPresent() {
        try {
        	checkAlert();
        	webDriver.switchTo().alert();
        	return true;
          } catch (Exception e) {
            return false;
          }
    }
    
    //检查alert是否显示
    public boolean isAlertPresent(int time) {
        try {
        	checkAlert(time);
        	webDriver.switchTo().alert();
        	return true;
          } catch (Exception e) {
            return false;
          }
    }
    
    /**
     * 徐天元
     * 用style属性判断是否显示
     */
    public Boolean isBlock(By by){
    	Boolean result = false;
    	if(isElementContainsValue(by, "style", "block")){
    		result = true;
    	}
    	return result;
    }
    
    /**
     * 用style属性判断是否显示
     * @param by
     * @return true：为不显示，false：为显示
     * @author 江渤洋 2015-7-10
     */
    public boolean isNone(By by){
    	if(isElementContainsValue(by, "style", "none")){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    //判断元素是否显示（不好使，建议用isElementVisible（）方法）
    public boolean isDisplayed(By by){
    	Boolean result = false;
    	try {
    		//webDriver.findElement(by).isDisplayed();
    		getElementWithWait(by).isDisplayed();
    		result = true;
		} catch (Exception e) {
			result = false;
		}
    	return result;
    }
    
    public boolean isDisplayed(By by,int time){
    	Boolean result = false;
    	try {
    		//webDriver.findElement(by).isDisplayed();
    		new WebDriverWait(webDriver, time).until(ExpectedConditions.presenceOfElementLocated(by)).isDisplayed();
    		result = true;
		} catch (Exception e) {
			result = false;
		}
    	return result;
    }
    
    /**
     * 页面元素是否包含某值
     * @param by 页面元素
     * @param elementName 元素名称
     * @param value 元素值
     * @return true为包含，false为不包含
     * @author 江渤洋 2015-7-22
     */
    public boolean isElementContainsValue(By by, String elementName, String value){
    	checkElement(by);
    	boolean isContains = webDriver.findElement(by).getAttribute(elementName).contains(value);
    	return isContains;
    }
    
    public boolean isElementContainsValue2(By by, String elementName, String value){
    	checkElementVisible(by);
    	boolean isContains = webDriver.findElement(by).getAttribute(elementName).contains(value);
    	return isContains;
    }
    /**
     * 判断是否只读
     * @param by
     * @return 徐天元
     */
    public boolean isReadonly(By by){
    	try {
    		//sleep(2000);
    		getElementWithWait(by).getAttribute("readonly").equals(true);
    		return true;
		} catch (NullPointerException e) {
			return false;
		}
    }
    
    
    /*****************************    获取元素、title    *****************************/
    
    //获取页面元素，不等待
    public WebElement getElementNoWait(By by){
    	return webDriver.findElement(by);
    }

    //等待获取页面元素
    public WebElement getElementWithWait(By by){
    	checkElement(by);
    	return webDriver.findElement(by);
    }
    
    public WebElement getElementWithVisible(By by){
    	checkElementVisible(by);
    	return webDriver.findElement(by);
    }
    
    /**
     * 获取元素列表
     * @param search
     * @return
     */
    public List<WebElement> getElements(By search){  
    	//checkElements(search);
    	return webDriver.findElements(search);
    }
    
    /**
     * 获取可见的页面元素集合
     * @param by 页面元素 
     * @return 元素集合
     * @author 江渤洋 2015-11-05
     */
    public List<WebElement> getVisibleElements(By by){  
    	checkElementsVisible(by);
    	return webDriver.findElements(by);
    }
    
    //获取页面标签内容
    public String getPageTitle(){
    	return webDriver.getTitle();
    }
    
    //不等待获取元素Text
    public String getElementText(By by){
    	return webDriver.findElement(by).getText().trim();
    }
    
    public String getElementTextWithPresence(By by){
    	checkElement(by);
    	return webDriver.findElement(by).getText().trim();
    }
    
	//等待并获取元素Text
    public String getElementTextWithWait(By by){
    	checkElement(by);
    	return webDriver.findElement(by).getText().trim();
    }
    
    public String getElementTextWithVisible(By by){
    	checkElementVisible(by);
    	return webDriver.findElement(by).getText().trim();
    }
    
    public String getElementTextWithWait(By by,int time){
    	checkElementVisible(by,time);
    	return webDriver.findElement(by).getText().trim();
    }
    
    public String getElementTextWithWait(WebElement webElement){
    	return webElement.getText().trim();
    }
    
    //获取元素组中的某个元素
    public WebElement getWebElementByElements(By by, int index){
    	return webDriver.findElements(by).get(index);
    }
    
    //获取元素组中的某个元素的Text
    public String getIndexElementText(By by,int index){
    	return webDriver.findElements(by).get(index).getText().trim();
    }

    /******************************************获取元素的属性值***************************************/
    
    //获取按钮text
    public String getLnkElementText(By by, String txt){
    	return webDriver.findElement(by).getAttribute(txt);
    }
    
    public String getAttribute(By by,String attr){
    	return getElementWithWait(by).getAttribute(attr);
    }
    
    public String getAttribute(WebElement webElement, String attr){
    	return webElement.getAttribute(attr);
    }
    
    /**
     * 获取元素的属性值
     * @param by 页面元素
     * @param attr 属性（例如：id，type等）
     * @return 属性值
     * @author 江渤洋 2015-12-18
     */
    public String getAttributeWithVisible(By by, String attr){
    	return getElementWithVisible(by).getAttribute(attr);
    }
    
    /******************************************点击元素***************************************/
    //不等待查找某元素并点击
    @Deprecated
    public void clickElementNoWait(By by){
    	try{
    		webDriver.findElement(by).click();
    	}catch(TimeoutException e){
    	}   	
    }
    
    //等待并点击元素
    @Deprecated
    public void clickWithWait(By by){
    	try {
    		checkElementVisible(by);
        	webDriver.findElement(by).click(); 
		} catch (NoSuchElementException e) {
			fail(by + " not found");
		} catch(TimeoutException e){
			fail(by + " Time out");
		}
    }

    //查找元素组并点击某个元素
    @Deprecated
    public void clickElement(By by, int index){
    	webDriver.findElements(by).get(index).click();
    }
    
    //不等待查找某元素并点击
    public void clickElement(By by){
    	webDriver.findElement(by).click();
    }
    
    //等待并点击元素
    public void clickElementByVisible(By by){
    	checkElementVisible(by);
        webDriver.findElement(by).click(); 
    }

    //查找元素组并点击某个元素
    public void clickElementByIndex(By by, int index){
    	webDriver.findElements(by).get(index).click();
    }
    
    public void clickElementVisibleByIndex(By by, int index){
    	checkElementsVisible(by);
    	webDriver.findElements(by).get(index).click();
    }
    
    /***********************************************文本框中输入值***************************************************/
    //不等待时，不清空文本框输入值
    public void elementSendkeyNoClear(By by,String value){
    	checkElement(by,30);
    	WebElement element = webDriver.findElement(by);
    	element.sendKeys(value);
    }
    //不等待时，清空文本框并输入值
    public void elementSendkey(By by,String value){
    	WebElement element = webDriver.findElement(by);
    	element.clear();
    	element.sendKeys(value);
    }
    
    //等待并输入值
    public void sendKeyAndWait(By by, String value){
    	getElementWithWait(by).clear();
    	webDriver.findElement(by).sendKeys(value);
    }
    
    //等待并输入值
    public void sendKeysWithWait(By by,String value){
    	try {
    		checkElement(by);
    		webDriver.findElement(by).click();
	    	webDriver.findElement(by).clear();
	    	webDriver.findElement(by).sendKeys(value);
    	} catch (Exception e) {
			fail(by + " not found");
		}
    }  
    //清空输入文本框
    public void clearTxt(By by){
    	getElementWithWait(by).clear();
    }
    
    /*********************************浏览器窗口*******************************/
    
    /**
     * 使用快捷键，新建窗口
     * @author 江渤洋 2015-8-3
     */
    public void openNewWindowByShortcuts(){
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(browserType.equals("ie")){
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
    }
    
    /**
     * 使用JavaScript，新建窗口
     * @param url:需要跳转的网址
     * @param type:打开网址的类型("_blank"(新窗口), _media, _parent, _search, "_self"(本窗口), _top)
     * @author 江渤洋 2015-8-3
     */
    public void openNewWindowByJavaScirpt(String url, String type){
//    	 ((JavascriptExecutor)webDriver).executeScript("window.open('http://client.eloancn.com','_blank')");
    	 ((JavascriptExecutor)webDriver).executeScript("window.open('" + url + "','" + type + "')");
    }
    
    /**
     * 获得当前窗口句柄
     * @author 江渤洋 2015-4-28
     */
    public String getCurrentWindowHandle(){
    	return webDriver.getWindowHandle();
    }
    
    /**
     * 获得当前所有窗口句柄
     * @return 江渤洋 2015-6-5
     */
    public Set<String> getCurrentWindowHandles(){
    	return webDriver.getWindowHandles();
    }
    
    //获取所有窗口的个数
    public int Windowsize(){
    	return webDriver.getWindowHandles().size();
    }
    
    /**
     * 跳转指定窗口
     * @param  窗口句柄
     * @author 江渤洋 2015-4-28
     */
    public void jumpToWindow(String windowHandle){
    	webDriver.switchTo().window(windowHandle);
    }
    
    public void jumpToNewWindow(){
		String BeforeHandel = getCurrentWindowHandle();
    	if(browserType.contains("ie")){
			sleep(5000);
		}
    	sleep(3000);
    	for(String winHandle : webDriver.getWindowHandles()){
    		if (winHandle.equals(BeforeHandel)) {
    			continue;
    		}
    		webDriver.switchTo().window(winHandle); 
    	}
    	webDriver.manage().window().maximize();
    }
    
    public void closeAndjumptoOldWindow(){
    	closeWindow(getCurrentWindowHandle());
    	sleep(3000);
    	for(String winHandle : getCurrentWindowHandles()){  
    		jumpToWindow(winHandle);
    	}
    }
    
    /**
     * 关闭页面窗口
     * @param  窗口句柄
     * @author 江渤洋 2015-4-28
     */
    public void closeWindow(String windowHandle){
    	this.jumpToWindow(windowHandle);
		if(browserType.contains("ie")){
			sleep(2000);
		}
    	webDriver.close();
    }
    
    /**
     * 获取子窗口句柄
     * @param  父窗口(当前窗口)句柄
     * @return 子窗口句柄
     * @author 江渤洋 2015-4-29
     */
    public String getChildWindowHandle(String parentWindowHandle){
        String childWindowHandle = "";
    	//得到所有窗口的句柄
        Set<String> windowHandles = webDriver.getWindowHandles();//System.out.println("所有窗口句柄大小： " + windowHandles.size());//---------测试
        Iterator<String> it = windowHandles.iterator();
        while(it.hasNext()){
        	//如果是父窗口则跳过
        	if(parentWindowHandle == it.next()){
        		continue;
        	}
        	//返回子窗口的句柄
        	childWindowHandle =  it.next();
        }
		return childWindowHandle;
    }
    
    /**
     * 获取子窗口句柄2
     * @param parentWindowHandle 父窗口句柄
     * @return 子窗口句柄
     * @author 江渤洋 2015-11-27
     */
    public String getChildWindowHandle2(String parentWindowHandle){
    	
        String childWindowHandle = "";
    	for(String winHandle : webDriver.getWindowHandles()){
    		if (winHandle.equals(parentWindowHandle)){
    			continue;
    		}
    		childWindowHandle = winHandle; 
    	}
		return childWindowHandle;
    }
    
    /**
     * 关闭父窗口以外的窗口
     * @param  父窗口(当前窗口)句柄
     * @author 江渤洋 2015-6-8
     */
    public void closeOtherWindowHandle(String parentWindowHandle){
    	//得到所有窗口的句柄
        Set<String> windowHandles = webDriver.getWindowHandles();   //System.out.println("所有窗口个数: " + windowHandles.size());//-----------测试
        Iterator<String> it = windowHandles.iterator();
        String otherHandle = "";
        while(it.hasNext()){
        	//如果不是父窗口则删除
        	otherHandle = it.next();    //System.out.println("其他窗口句柄: " + otherHandle);//-----------测试
        	if(!otherHandle.equals(parentWindowHandle)){
        		webDriver.switchTo().window(otherHandle);
        		sleep(2000);
        		webDriver.close();
        	}
        }
    }
    
    //_blank跳转至新页
    public void turnToNewPage(){
		String currentHandel = getCurrentWindowHandle();
		closeWindow(currentHandel);
		if(browserType.contains("ie")){
			sleep(5000);
		}
		sleep(2000);
		for(String winHandler : webDriver.getWindowHandles()){
			jumpToWindow(winHandler);
		}
	}
    
    /**
     * 调到目标页  关闭其他
     * @param title  标题
     * @author 徐天元
     * @return flag 0:失败    1：成功
     */
    public int turnToTargetCloseOtherPage(String title){
    	int flag = 0;
    	String handel = getCurrentWindowHandle();
    	for(String winHandler : webDriver.getWindowHandles()){
			jumpToWindow(winHandler);
			if (checkTitleContains(title,5)) {
				handel = winHandler;
				flag = 1;
			}else if (webDriver.getWindowHandles().size()==1) {
				handel = getCurrentWindowHandle();
    		}else {
				closeWindow(winHandler);
			}
		}
    	jumpToWindow(handel);
    	return flag;
	}
    
    public void turnToOldPage(){
    	String currentHandel = getCurrentWindowHandle();
		String newHandel = getChildWindowHandle(currentHandel);
		closeWindow(newHandel);
    	jumpToWindow(currentHandel);
    }

    
    /**
     * 徐天元
     * 关闭其他handles 新手专区 快速投资中用到
     */
    public String closeOtherHandle(){
    	Set<String> windowHandles = webDriver.getWindowHandles();
        System.out.println(windowHandles.size());
        String handels[] = new String[windowHandles.size()];
        int i=0;
        for (String str : windowHandles) {  
            System.out.println(str);  
            handels[i] = str;
            i++;
        } 
       closeWindow(handels[0]);
       jumpToWindow(handels[1]);
       return handels[1];
    }
    
    /**
     * 徐天元
     * 返回handels个数
     */
    public int gethandelsNum(){
    	Set<String> windowHandles = webDriver.getWindowHandles();  
    	return windowHandles.size();
    }
    
    //关闭新打开的窗口
    public void closeWebDriver(){ 
    	if(webDriver == null) return; 
    	try{ 
    		String current = webDriver.getWindowHandle(); 
    		Set<String> otherWins = webDriver.getWindowHandles(); 
    		for(String winId : otherWins){ 
    			if(winId.equals(current)) continue; 
    			else{
    				webDriver.switchTo().window(winId).close();    				
    			}
    		}
    		jumpToWindow(current);
    	}catch(Exception ex){ 
    		//ignore 
    	}
    }
    
    /**
     * 三个窗口获取最后一个窗口句柄
     * @param  父窗口(当前窗口)句柄
     * @return 子窗口句柄
     * @author 徐天元 2015-5-5
     */
    public String getLastWindowHandle(String firstWindowHandle,String senWindowHandle){
        String lastWindowHandle = "";
    	//得到所有窗口的句柄
        Set<String> windowHandles = webDriver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        while(it.hasNext()){
        	//如果是父窗口则跳过
        	if(firstWindowHandle == it.next() || senWindowHandle == it.next()){
        		continue;
        	}
        	//返回子窗口的句柄
        	lastWindowHandle =  it.next();
        }
		return lastWindowHandle;
    }
    
    /******************************    选择框           ***************************************/
    
    /**
     * 获取select
     * @param 
     * @author 徐天元
     */
    public Select elementSelect(By by){
    	return new Select(getElementWithWait(by));
    }
    /**
     * 根据索引选择
     * @param 
     * @author 徐天元
     */
    public void elementSelectByIndex(By by,int index){
    	elementSelect(by).selectByIndex(index);
    }
    /**
     * 根据value选择
     * @param 
     * @author 徐天元
     */
    public void elementSelectByIndex(By by,String value){
    	elementSelect(by).selectByValue(value);
    }
    /**
     * 通过下拉列表中选项的可见文本选择
     * @param 
     * @author 徐天元
     */
    public void elementSelectByVisibleText(By by,String value){
    	elementSelect(by).selectByVisibleText(value);
    }
    //获取选中选项的文本
    public String getSelectedOptionTxt(By by){
    	return elementSelect(by).getFirstSelectedOption().getText();
    }
    
    /****************************************Assert判断***********************************************/
    
    /**
     * 判断期盼结果 
     * @param 
     * @author 徐天元
     */
    public void assertNotNullBy(By by){
    	Assert.assertNotNull(getElementWithWait(by));
    }
    /**
     * 判断期盼结果
     * @param webElement
     * @author 江渤洋 2015-5-8
     */
    public void assertNotNullWebElement(WebElement webElement){
    	Assert.assertNotNull(webElement);
    }
    /**
     * @param 
     * @author 徐天元
     */
    public void assertNullBy(By by){
    	Assert.assertNull(getElementWithWait(by));
    }
	
    public void assertTrueBy(By by){
    	Assert.assertTrue(getElementWithWait(by).isDisplayed());
    }

    /**
     * @param 
     * @author 徐天元
     */
    public void assertEqualsActualExpected(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }
    
    public void assertEqualsActualExpectedByBoolean(boolean actual, boolean expected){
    	Assert.assertEquals(actual, expected);
    }
    
    public void assertEqualsActualExpectedByInt(int actual, int expected){
    	Assert.assertEquals(actual, expected);
    }
    
    public void assertEqualsActualExpectedByDouble(double actual, double expected){
    	Assert.assertEquals(actual, expected);
    }
    
    public void assertEqualsActualExpectedByLong(long actual, long expected){
    	Assert.assertEquals(actual, expected);
    }
    
    public void assertTrueByBoolean(Boolean result){
    	Assert.assertTrue(result);
    }

    public void assertNotEqualsActualExpected(String actual, String expected){
        Assert.assertNotEquals(actual, expected);
    }
    
    /*******************************************页面强制等待************************************/

	/**
	 * 页面等待
	 * @param time等待时间（单位：毫秒）
	 */
	public void sleep(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    /**************************************鼠标**********************************/
    
    /**
     * 鼠标悬停
     * @param 页面元素
     * @author 江渤洋 2015-4-28
     */
    public void mouseToElement(By by){
    	checkElement(by);
    	new Actions(webDriver).moveToElement(this.getElementWithWait(by)).perform();
    }
    public void mouseToIndexElement(By by, int index){
    	new Actions(webDriver).moveToElement(webDriver.findElements(by).get(index)).perform();
    }
    
    /**************************************键盘操作*************************************/
    /**
     * 徐天元
     * 键盘向下次数
     */
//    public void keyBoard(int times){
//    	for (int i = 0; i < times; i++) {
//    		((HasInputDevices) webDriver).getKeyboard().sendKeys(Keys.ARROW_DOWN); 
//    		System.out.println("次数");
//		}
//   	    //注意这里不能用Keys.ENTER   
//   	    ((HasInputDevices) webDriver).getKeyboard().sendKeys(Keys.RETURN);  
//    }
    
    public void tabKeyBoard(){
    	new Actions(webDriver).keyDown(Keys.TAB).sendKeys(Keys.F5).keyUp(Keys.TAB).perform();   
    }
    
    public void spaceKeyBoard(){
    	new Actions(webDriver).keyDown(Keys.SPACE).sendKeys(Keys.F5).keyUp(Keys.SPACE).perform();   
    }
    
    /**************************************滚动条*************************************/
    
    /**
     * 拖拽指定ID的窗口中的滚动条至指定位置
     * @param id 窗口ID
     * @param height 滚动条高度：0是顶部；10000是底部
     * @author 江渤洋 2015-4-30
     */
    public void setDivScrollById(String id, int height){
    	try {
			String scrollString = "document.getElementById('" + id + "').scrollTop=" + height;
			JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
			jsExecutor.executeScript(scrollString);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 拖拽浏览器滚动条至指定位置
     * @param height 滚动条高度：0是顶部；10000是底部
     * @author 江渤洋 2015-4-30
     */
    public void setBrowserScroll(int height){
    	try {
			String scrollString = "document.documentElement.scrollTop=" + height;
			JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
			jsExecutor.executeScript(scrollString);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	 /*************************************frame层************************************/
	 
    /**
     * 跳转至frame
     * @param frame名称
     * @author 徐天元 2015-5-4
     */
    public void switchToFrame(String frameName){
    	webDriver.switchTo().frame(frameName);
    }
    
    /**
     * 跳转至frame
     * @param webelement
     * @author 江渤洋 2015-7-29
     */
    public void switchToFrameByWebElement(WebElement webelement){
    	webDriver.switchTo().frame(webelement);
    }
    
    /**
     * 从frame回到原先内容页面
     * @author 徐天元 2015-5-4
     */
    public void fromFrameToDefaultContent(){
    	webDriver.switchTo().defaultContent();
    }
    
    /***********************************alert confirm prompt*************************************/
    /**
     * 获取alert/confirm/prompt  方法一样
     * @author 徐天元 2015-5-4
     */
    public Alert getAlert(){
    	return webDriver.switchTo().alert();
    }
    
    public Alert getAlertwithWait(){
    	checkAlert();
    	return webDriver.switchTo().alert(); 
    }
    
    /**
     * 获取Alert提示信息
     * @return Alert提示信息
     * @author 江渤洋 2015-7-30
     */
    public String getTextByAlert(){
    	return webDriver.switchTo().alert().getText();
    }
    
    public void acceptAlert(){
    	webDriver.switchTo().alert().accept();
    }
    
    /**
     * 点击"取消"或者叉掉对话框
     * @author 江渤洋 2015-8-12
     */
    public void dismissAlert(){
    	webDriver.switchTo().alert().dismiss();
    }
    
    /**
     * 徐天元
     * 校验alert的text值是否正确  先accept后校验
     */
    public void checkAlertText(String message){
    	Alert alert = getAlertwithWait();
    	sleep(1000);
    	String msg = alert.getText();
    	alert.accept();
    	this.assertEqualsActualExpected(msg, message);
    }
    
    /**********************************获取Table中列的值********************************/
    
	/**
     * 检查收款表数据
     * @param  by table对象
     * @param  rowNum 行数
     * @param  cellNum 列数
     * @return 列的值
     * @author 江渤洋 2015-5-6
	 */
	public WebElement getCellElement(By by, int rowNum, int cellNum){
		checkElementVisible(by);
		//获取Table对象
		WebElement tableElement = webDriver.findElement(by);
		//获取“行”元素的集合
		List<WebElement> rows = tableElement.findElements(By.tagName("tr"));   //System.out.println("Base: 行数" + rowNum);//-----测试
		//获取指定“行”对象
		WebElement rowWebElement = rows.get(rowNum);  //System.out.println("Base: 列数" + cellNum);//-----测试
		//获取“列”对象
		WebElement cellWebElement = getCell(rowWebElement, cellNum);
		//返回“列”的值
		return cellWebElement;
	}
	
	/**
     * 检查收款表数据
     * @param rowWebElement “行”对象 
	 * @param cellNum “列”的位置
     * @return “列”对象
     * @author 江渤洋 2015-5-6
	 */
	public WebElement getCell(WebElement rowWebElement, int cellNum){
		//定义“列”元素
		WebElement cellWebElement = null;
		//定义“列”元素的集合
		List<WebElement> cellWebElements = null;
		//“列”标签有两种：<td>和<th>
		//“行”元素下元素是<td>标签
		if(rowWebElement.findElements(By.tagName("td")).size()>0){
			//获取所有“行”标签下的<td>标签
			cellWebElements = rowWebElement.findElements(By.tagName("td"));
			//根据“列”的位置，获取“列”对象
			cellWebElement = cellWebElements.get(cellNum);
		}
		//“行”元素下元素是<th>标签
		else if(rowWebElement.findElements(By.tagName("th")).size()>0){
			//获取所有“行”标签下的<th>标签
			cellWebElements = rowWebElement.findElements(By.tagName("th"));
			//根据“列”的位置，获取“列”对象
			cellWebElement = cellWebElements.get(cellNum);
		}
		
		if(cellWebElement == null){
			System.out.println("Base: 列对象为空！");
		}
		
		//返回“列”元素
		return cellWebElement;
	}
    
    /*********************************字符串、数字*******************************/	
	
	/**
	 * 徐天元
	 * 金额精确到小数点第二位
	 * @param money
	 * @return  10,375.22
	 */
	public String roundingMoney(double money){
		DecimalFormat df = new DecimalFormat("###,##0.00");
		return df.format(money);
	}
	public String roundMoney(double money){
		DecimalFormat df = new DecimalFormat("####0.00");
		return df.format(money);
	}
	public String Money(double money){
		DecimalFormat df = new DecimalFormat("###0.##");
		return df.format(money);
	}
	public String cutMoney(double money){
		DecimalFormat df = new DecimalFormat("###,##0.##");
		return df.format(money);
	}
	public String getInt(double money){
		DecimalFormat df = new DecimalFormat("###0");
		return df.format(money);
	}
	
	/**
	 * 徐天元
	 * 金额223.00->223  223.0->223  223.30->223.3
	 * @param money
	 */
	public String integerMoney(String money){
		if (money.contains(".00")) {
			money = money.substring(0, money.length()-3);
		}
		if (money.contains(".0")) {
			money = money.substring(0, money.length()-2);
		}
		if (money.contains(".") && money.charAt(money.length()-1)=='0' && money.charAt(money.length()-2)!='0' ) {
			money = money.substring(0, money.length()-1);
		}
		return money;
	}
	
	//223.00->223   223.20->223.20  223.23->223.23
	public String intMoney(double money){
		
		DecimalFormat df = new DecimalFormat("###,##0.00");
		String money1 = df.format(money);
		if (money1.contains(".00")) {
			return money1.substring(0, money1.length()-3);
		}else{
			return money1;
		}
	}
	//保留小数点后两位，直接舍掉 12.256->12.25
	public String CutMoney(double money){
		String money1 = String.valueOf(money)+"0";
		if(money1.contains(".")){
			money1 = money1.substring(0, money1.indexOf(".")+3);
		}
		money1=new DecimalFormat("###,##0.##").format(Double.parseDouble(money1));
		return money1;
	}
	
	/**
	 * 将数字格式化为.00格式
	 * @param num
	 * @return
	 */
	public String appendZero(String num){
		int length;
		int pointIndex;
		length = num.length();
		pointIndex = num.indexOf(".");
		//如果字符串不包含“.”，则添加“.00”
		if(pointIndex!= -1){
			//将小数改为保留2位小数
			if((length - 1) - pointIndex == 1){
				num = num + "0";
			}
		}
		else{
			num = num + ".00";
		}
		return num;
	}
	
	/**
	 * 将金额字符串移.00
	 * @param money 
	 * @return 
	 * @author 江渤洋 2016-1-5
	 */
	public String removeZero(String money){
		
		int num = money.indexOf(".");
		if(num != -1){
			money = money.substring(0, money.indexOf("."));
		}
		return money;
	}
	
	/**
	 * 将金额字符串移,
	 * @param money 
	 * @return
	 * @author 江渤洋 2016-1-5
	 */
	public String removeComma(String money){
		
		money = money.replaceAll(",", "");
		return money;
	}
	
	/**
	 * double不显示成科学计数法
	 * @param number 显示成科学计数法的数字
	 * @return 不含科学计数法的数字
	 */
	public String doubleFormat(double number){
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false);
		return numberFormat.format(number);
	}
	
    /**
     * 替换字符串中的字符
     * @param  originalString（原字符串），ExcludeString（被替换的字符），replaceString（替换字符）
     * @return 替换后的字符
     * @author 江渤洋 2015-5-4
     * 
     * 例如：原字符："1,066.66" 被替换的字符："6," 替换字符:"a" 结果:1a0aa.aa
     */
	public String stringToReplace(String originalString, String ExcludeString, String replaceString){
		//循环替换“ExcludeString”字符串中的字符
		for(int i=0;i<ExcludeString.length();i++){
			//charAt()获取字符数组中的值，结果再转化成字符串
			originalString = originalString.replaceAll(ExcludeString.charAt(i)+"",replaceString);
		}
		return originalString;
	}
	
	/**
	 * 金钱字符串每三位隔开
	 * @param money 金钱
	 * @return 返回如下格式：1,314,321,300
	 * @author 江渤洋 2015-8-11
	 */
	public String stringToMoney(String money){
		NumberFormat nf = new DecimalFormat("#,###,###");
		money = nf.format(Double.parseDouble(money));
		return money;
	}	  
	
	/**
	  * 金钱格式化
	  * 备注：结果四舍五入
	  * @param number 需要格式化的数字
	  * @param digit 保留几位小数
	  * @param isShowDefault 是否显示默认值0.true为显示，false：为不显示
	  * @return 格式化后的数字
	  * @author 江渤洋 2015-9-2
	  * 
	  * 例如：
	  *     原字符："16666666666.666" 保留位数："2" 显示默认值       结果:16,666,666,666.67
	  *     原字符："16666666666.666" 保留位数："4" 显示默认值       结果:16,666,666,666.6660
	  *     原字符："16666666666.666" 保留位数："2" 不显示默认值   结果:16,666,666,666.67
	  *     原字符："16666666666.666" 保留位数："4" 不显示默认值   结果:16,666,666,666.666
	  */
	 public String moneyFormat(double number, int digit, boolean isShowDefault){
	  
		 DecimalFormat decimalFormat = new DecimalFormat();
		 StringBuilder digitSB = new StringBuilder();
		 String defaultStr = "";
		 
		 //是否显示默认值0。"0"表示显示，"#"表示不显示
		 if(isShowDefault){
			 defaultStr = "0";
		 }
		 else{
			 defaultStr = "#";
		 }
		 for(int index = 0; index < digit; index++){
			 digitSB = digitSB.append(defaultStr);
		 }
		 decimalFormat = new DecimalFormat("###,###,###,##0." + digitSB);
		  
		 return decimalFormat.format(number);
	 }
		
	/**
	 * 保留小数点后几位
	 * @param number 需要格式化的数字
	 * @param digit 位数
	 * @param isRound true为四舍五入，false为直接舍值
	 * @return 格式化后的数字
	 * @author 江渤洋 2015-9-2
	 * 
	 * 例如：
	 *     原字符："16.66666667" 保留位数(四舍五入)："3" 结果:16.666
     *     原字符："-16.66666667" 保留位数(无四舍五入)："3" 结果:-16.666
     *     原字符："16.66666667" 保留位数(无四舍五入)："0" 结果:16.0
	 */
	  public double setRound(double number, int digit, boolean isRound){
		  double result = 0.0;
		  String numberStr = number + "";
		  BigDecimal bigDecimal = new BigDecimal(numberStr);
		  //如果位数为0，则为不保留小数部分，直接取整
		  if(digit == 0){
			  result = Math.floor(number);
		  }
		  else{
			  //根据位数，四舍五入
			  if(isRound){
				  result = bigDecimal.setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
			  }
			  //根据位数，直接舍值
			  else{
				  result = bigDecimal.setScale(digit, BigDecimal.ROUND_DOWN).doubleValue();
			  }
		  }
		  return result;
	  }
	  
    /**
     * 保留小数点后几位，无四舍五入
     * @param  num 数字
	 * @param  digit 保留的位数
     * @return 保留后的数字
     * @author 江渤洋 2015-5-4
     * 
     * 例如：原字符："16.66666667" 保留位数："3" 结果:16.666
     *     原字符："-16.66666667" 保留位数："3" 结果:-16.666
     */
	public double numNotRoundedUpDown(double num, int digit){
		if(num == 0){
			return 0;
		}else if(num>0){
			//将位数 转化成 10次幂
			int multiples = (int) Math.pow(10, digit);
			//乘以 保留位数的10次幂，舍去小数点后面的数
			num = Math.floor(num * multiples);
			//除以 保留位数的10次幂，得到结果
			return num / multiples;
		}else{
			//将位数 转化成 10次幂
			int multiples = (int) Math.pow(10, digit);
			//乘以 保留位数的10次幂，舍去小数点后面的数
			num = Math.ceil(num * multiples);
			//除以 保留位数的10次幂，得到结果
			return num / multiples;
		}
	}
	
	/**
	 * 双精度浮点型定义类型_相加
	 * @param numOne 第一个数
	 * @param numTwo 第二个数
	 * @return 两数之和
	 * @author 江渤洋 2015-9-7
	 */
	public double add(double numOne, double numTwo){
		BigDecimal bigDecimalOne = new BigDecimal(numOne + "");
		BigDecimal bigDecimalTwo = new BigDecimal(numTwo + "");
		return bigDecimalOne.add(bigDecimalTwo).doubleValue();
	}
	
	/**
	 * 双精度浮点型定义类型_相减
	 * @param numOne 第一个数
	 * @param numTwo 第二个数
	 * @return 两数之差
	 * @author 江渤洋 2015-10-8
	 */
	public double subtract(double numOne, double numTwo){
		BigDecimal bigDecimalOne = new BigDecimal(numOne + "");
		BigDecimal bigDecimalTwo = new BigDecimal(numTwo + "");
		return bigDecimalOne.subtract(bigDecimalTwo).doubleValue();
	}
	
	/**
	 * 双精度浮点型定义类型_相乘
	 * @param numOne 第一个数
	 * @param numTwo 第二个数
	 * @return 两数之积
	 * @author 江渤洋 2016-1-4
	 */
	public double multiply(double numOne, double numTwo){
		BigDecimal bigDecimalOne = new BigDecimal(numOne + "");
		BigDecimal bigDecimalTwo = new BigDecimal(numTwo + "");
		return bigDecimalOne.multiply(bigDecimalTwo).doubleValue();
	}
	
	/**
	 * 双精度浮点型定义类型_相除
	 * @param numOne 第一个数
	 * @param numTwo 第二个数
	 * @return 两数之商
	 * @author 江渤洋 2016-1-4
	 */
	public double divide(double numOne, double numTwo){
		BigDecimal bigDecimalOne = new BigDecimal(numOne + "");
		BigDecimal bigDecimalTwo = new BigDecimal(numTwo + "");
		return bigDecimalOne.divide(bigDecimalTwo).doubleValue();
	}
	
	/***************************************排序************************************/
	
	/**
	 * 徐天元
	 * 倒序排序
	 * @param str
	 * @return
	 */
	public String desc(String str){
		String result = "";
		for (int i = str.length()-1; i >= 0 ; i--) {
			result  += str.charAt(i);
		}
		return result;
	}
	
	/**
	 * 徐天元
	 * 乱序
	 * @param str
	 * @return
	 */
	public String confuse(String str){
		String result = "";
		for (int i = str.length()-1; i >= str.length()/2 ; i--) {
			result  += str.charAt(i);
		}
		for (int i = 0; i < str.length()/2; i++) {
			result  += str.charAt(i);
		}
		return result;
	}
		
	/************************************浏览器名称、版本******************************************/	
	
	/**
	 * 获取当前浏览器名称
	 * @return 浏览器名称
	 * @return 江渤洋 2015-6-30
	 */
	public String getBrowserName(){
		//获取“HTML DOM userAgent”属性 并赋值给浏览器变量
		String userAgent = (String) ((JavascriptExecutor)webDriver).executeScript("var userAgent = window.navigator.userAgent; return userAgent");
		//IE浏览器
		if(userAgent.contains("MSIE")){
			return "IE";
		}
		//谷歌浏览器
		else if(userAgent.contains("Chrome")){
			return "Chrome";
		}
		//火狐浏览器
		else if(userAgent.contains("Firefox")){
			return "Firefox" ;
		}
		return "非主流浏览器，自己手动测去！";
	}
	
	/**
	 * 获取当前浏览器版本
	 * @return 浏览器版本
	 * @return 江渤洋 2015-6-30
	 */
	public String getBrowserEdition(){
		//获取“HTML DOM userAgent”属性 并赋值给浏览器变量
		String userAgent = (String) ((JavascriptExecutor)webDriver).executeScript("var userAgent = window.navigator.userAgent; return userAgent");
		String edition = "";//浏览器版本号
		if(userAgent.contains("MSIE")){//IE浏览器
			edition = userAgent.substring(userAgent.indexOf("MSIE") + "MSIE".length(), userAgent.indexOf(".0;"));//获取版本号
			return edition;
		}
		else if(userAgent.contains("Chrome")){//谷歌浏览器
			edition = userAgent.substring(userAgent.indexOf("Chrome/") + "Chrome/".length(), userAgent.indexOf("Safari"));
			edition = edition.substring(0, edition.indexOf("."));
			return edition;
		}
		else if(userAgent.contains("Firefox")){//火狐浏览器
			edition = userAgent.substring(userAgent.indexOf("Firefox/") + "Firefox/".length(), userAgent.lastIndexOf("."));
			return  edition;
		}
		return "无法识别该浏览器";
	}
	
	/***************************************日期、时间************************************/
    
    /**
     * 两个日期相差的天数
     * @param smdate
     * @param bdate
     * @return
     * @author 刘京
     */
	public int daysBetween(String smdate,String bdate) {  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        try {
			cal.setTime(sdf.parse(smdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}    
        long time1 = cal.getTimeInMillis();                 
        try {
			cal.setTime(sdf.parse(bdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    }  
	
	/**
	 * 获取日期之差
	 * @param dateOne 时间1
	 * @param dateTwo 时间2
	 * @return 日期差
	 * @author 江渤洋 2015-10-27
	 */
	public long getDifferenceOfDate(long dateOne, long dateTwo){
		
		return (dateOne - dateTwo)/(1000*3600*24);  
	}
	
	/**
	 * 获取当前日期毫秒数
	 * @return 当前日期毫秒数
	 * @author 江渤洋 2015-10-27
	 */
	public long getcurrentTimeMillis(){
		
		return System.currentTimeMillis();
	}
	
	/**
	 * 获取当前日期时间戳
	 * @param millis 当前日期毫秒数
	 * @return 当前日期时间戳
	 * @author 江渤洋 2016-1-4
	 */
	public String getTimeStamp(String millis){
		
		int time = (int)Long.parseLong(millis);
		return time + "";
	}
	
	/**
	 * 获取当前日期时间戳
	 * @return 当前日期时间戳
	 * @author 江渤洋 2016-1-4
	 */
	public String getTimeStamp(){
		
		return (int) (System.currentTimeMillis() / 1000) + "";
	}
	
	//获取当前的日
	public int getCurrentDay(){
		Calendar cal = Calendar.getInstance();	
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	/**
	 * 返回日期的毫秒数
	 * @param dateString:日期(需跟format的格式匹配)例如：2015-10-16 00:00:00
	 * @param format:格式(yyyy-MM-dd-HH-mm-ss、yyyy:MM:dd:HH:mm:ss等日期格式)
	 * @return 毫秒数
	 * @author 江渤洋 2015-8-31
	 */
	public long getMilliseconds(String dateString, String format){
		
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		//创建Calendar实例
		Calendar calender = Calendar.getInstance();
		//提取格式中的日期
		try 
		{
			date = sdf.parse(dateString);
		} catch (ParseException e) {}
		//设置时间
		calender.setTime(date);
		//获得毫秒数
		long time = calender.getTimeInMillis();
		return time;
	}
	
	/**
	 * 获取系统当前时间
	 * @return
	 */
	public Date getTime(){
		Date nowDate = new Date();
		return nowDate;
	}
	
	/**
	 * 格式化日期
	 * @param date：时间
	 * @param format:格式。例如："yyyy-MM-dd HH:mm:ss"
	 * @return 格式化后的日期
	 */
	public String dateFormat(Date date, String format){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String dateStr = simpleDateFormat.format(date);
		return dateStr;
	}

	//获取前几个月的第一天的日期：yyyy-MM-dd  上个月：previousmonth=-1   上上个月：previousmonth=-2
	public String getLastMonthDate(int previousmonth){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.MONTH, previousmonth);//2015-09-16
		calendar.set(Calendar.DAY_OF_MONTH, 1);//2015-09-01
		String time = df.format(calendar.getTime());
		return time;
	}
	//获取前几个月的最后一天的日期：yyyy-MM-dd 上个月：previousmonth=-1   上上个月：previousmonth=-2
	public String getLastMonthDay(int previousmonth){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.MONTH, previousmonth);
		int MaxDay=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, MaxDay);
//		calendar.set(Calendar.DAY_OF_MONTH, 1);//2015-10-01
//		calendar.add(Calendar.DAY_OF_MONTH, -1);//2015-09-30
		String time = df.format(calendar.getTime());
		return time;
	}
	//获取上几个月的年月份
	public String getMonthDate(int previousmonth){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, previousmonth);			//上个月
		String lastmonth=sdf.format(cal.getTime());//2015-09
		return lastmonth;
	}
	//把字符串型的日期转换成date
	public Date getDate(String date){
//		 Calendar calendar = Calendar.getInstance();
		 Date day = null;
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			day= df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return day;
	}
	
	/***************************************其他************************************/
	
    /**
     * 徐天元
     * 半角->全角
     * @param input
     * @return
     */
    public String btoQ(String input){  
	    char c[] = input.toCharArray();  
	    for ( int i=0; i<c.length;i++ ){  
		    if (c[i] ==' ') {  
		    	c[i] = '\u3000';  
		    }   
		    else if (c[i]<'\177') {  
		    	c[i]= (char) (c[i]+65248);  
		    }  
	    }  
	    return new String(c);  
    }  

    
    /**
     * 徐天元
     * 日期控件，设置日期
     */
    public void setDate(String id,String date){
    	String str = "document.getElementById('"+id+"').readonly=false";  
		 String strDate = "document.getElementById('"+id+"').value='"+date+"'";  
		 ((JavascriptExecutor)webDriver).executeScript(str);  
		 ((JavascriptExecutor)webDriver).executeScript(strDate);
    }
    
    /**
     * 徐天元
     * 设置value
     */
    public void setValueById(String id,String value){
		 String strValue = "document.getElementById('"+id+"').value='"+value+"'";  
		 ((JavascriptExecutor)webDriver).executeScript(strValue);
    }
    
    /**
     * 设置页面元素是否显示
     * @param className 元素ClassName
     * @param value block：显示，none：隐藏
     * @author 江渤洋 2015-12-21
     */
    public void setDisplayByClassName(String className, String value){
    	String valueStr = "document.getElementsByClassName('" + className + "')[0].style.display='" + value + "';";
    	((JavascriptExecutor)webDriver).executeScript(valueStr);
    }
    
    public void setDisplayById(String id, String value){
    	String valueStr = "document.getElementById('" + id + "').style.display='" + value + "';";
    	((JavascriptExecutor)webDriver).executeScript(valueStr);
    }
    
    public String getCSSValue(By by, String styleName){
    	return getElementWithVisible(by).getCssValue(styleName);
    }
	
    /**
     * 校验页面样式
     * @param by 页面对象
     * @param styleName 样式名称
     * @param styleValue 样式值
     * @author 江渤洋 2016-2-24
     */
    public void checkCSSValue(By by, String styleName, String styleValue){
    	assertEquals(getCSSValue(by, styleName), styleValue);
    }
    
    /**
     * 获取页面元素的样式
     * @param by：对象
     * @param styleName：样式名
     * @return 样式的值
     * @author 江渤洋 2015-9-1
     */
    public String getStyle(String element, String styleName){
    	String executor = "var style = window.getComputedStyle("+element+",'').getPropertyValue('" + styleName + "').toLowerCase(); return style";
    	String styleValue = (String) ((JavascriptExecutor)webDriver).executeScript(executor);  
    	return styleValue;
	}

    /**
      * 将标签的readonly属性去掉
      */
    public void removeReadOnly(String id){
    	JavascriptExecutor removeAttribute = (JavascriptExecutor)webDriver;
    	//remove readonly attribute
        removeAttribute.executeScript("var setDate=document.getElementById('"+id+"');setDate.removeAttribute('readonly');") ;  
    }
    
    //模拟按下向下键并释放,然后按下"Enter"键
    public void pressEnter(){
    	try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			sleep(5000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
    }
    
    //模拟同时按下"Alt"键和字符键
    public void pressAltandS(int keyvalue){
    	
    	try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(keyvalue);
			robot.keyRelease(keyvalue);
			robot.keyRelease(KeyEvent.VK_ALT);
			sleep(5000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
    }
	
	//模拟同时按下"Ctrl"键和字符键
    public void pressKeyWithCtrl(Robot robot, int keyvalue){
        //模拟按下
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(keyvalue);
        
        //模拟弹起
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(keyvalue);
    }
    
	//全选、复制、粘贴的操作
	public void CopyAndPaste(){
		try {
			Robot robot = new Robot();
			//全选	
			pressKeyWithCtrl(robot,KeyEvent.VK_A);
			//复制
			pressKeyWithCtrl(robot,KeyEvent.VK_C);
			//粘贴
			pressKeyWithCtrl(robot,KeyEvent.VK_V);
			pressKeyWithCtrl(robot,KeyEvent.VK_V);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	//得到匹配文件的个数
	public int matchFileNum(String regex,String path){
		 File file = new File(path);
		 String[] files = file.list();
		 int j=0;
		 for(int i=0;i<files.length;i++){
//			 File f = new File(path+File.separator+files[i]);
			 if(Pattern.matches(regex, files[i])){
				j = j+1;
			 }
		 }
		 System.out.println(j);
		 return j;
	}
	
	//获取几年后的本息
	public String benxi(double benji,double lixi,int year){
		double benxi1 = benji*Math.pow(1+lixi, year);
		return String.format("%.2f", benxi1);
	}
	
	/**
	 * 徐天元
	 * 获取一年有多少天
	 */
	public int getDaysOfYear(int year){
		//四年一闰，百年不闰，四百年再闰
		if((year%4==0 && year%100!=0)||year%400==0){
			return 366;
		}else {
			return 365;
		}
	}
	//4位的随机数
	public String RandomNumber(){
		Random rand = new Random();
		String randomNum = Long.toString(rand.nextInt(10000));
		return randomNum;
	}
	//判断字符串是否为数字
	public boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	} 
	//判断字符串是否为汉字
	public boolean isChinese(String str){
		Pattern p_str = Pattern.compile("[\\u4e00-\\u9fb0]+");
		return p_str.matcher(str).matches();
	}
	//判断字符串是否为手机号
	public boolean isTelephone(String str){
		Pattern p_str = Pattern.compile("^1[3578]\\d{9}");
		return p_str.matcher(str).matches();
	}
	
	public String ExecuteJS(String search){
		return (String) ((JavascriptExecutor) webDriver).executeScript(search);
	}
}
