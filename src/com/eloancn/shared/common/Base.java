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
	public String clientBackURL = "http://main.eloancn.com/wpf/admin/BDED4F051354CCE14DA598E666D28F72.jsp";// http://inback.eloancn.com/wpf/admin/BDED4F051354CCE14DA598E666D28F72.jsp(���ػ���)
	public final int DEFAULT_WAIT_TIME = 30;
	
	public Base(){
		String properties = "parameters.properties";
		String curPath = new File("").getAbsolutePath();//��ǰ·��
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
	 *web���̻�ȡ��ǰ·��
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
		profile.setPreference("browser.download.folderList", 2);//���ó�0�������ص������Ĭ������·�������ó�2����Ա��浽ָ��Ŀ¼�����ó�1���浽����
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
		//UK��ַ��C:\Windows\SysWOW64\ET99_FULL.dll
	 	webDriver=new InternetExplorerDriver();
	 	drivermanage();
	}
	
	public void drivermanage(){
		webDriver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 	webDriver.manage().window().maximize();
	}

    
    /**********************************cookie����***********************************/
    
	//��ȡ��ַCookie
    public Set<Cookie> getCookies(){
    	return webDriver.manage().getCookies();
    }
    
    //��ȡCookie�ĸ���
    public int getCookiesNum(Set<Cookie> cookies){
    	return cookies.size();
    }
    
    //��ȡCookie����
    public Cookie getCookie(String name){
    	return webDriver.manage().getCookieNamed(name);
    }
	
    public String getCookieInfo(Cookie cookie, String name){
    	String info = "";
    	switch(name){
    	case "������":	info = cookie.getDomain();				break;
    	case "����":		info = cookie.getName();				break;
    	case "ֵ" :		info = cookie.getValue();				break;
    	case "��Χ":		info = cookie.getPath();				break;
    	case "����ʱ��":	info = cookie.getExpiry().toString();	break;
    	}
    	return info;
    }
    
    public void printCookiesInfo(Set<Cookie> cookies){
    	for (Cookie cookie : cookies) {
			System.out.println(
					"������"		+ cookie.getDomain() 	+ "�� " +
					"���ƣ�"		+ cookie.getName() 		+ "�� " +
					"ֵ��" 		+ cookie.getValue() 	+ "�� " +
					"��Χ��" 		+ cookie.getPath() 		+ "�� " +
					"����ʱ�䣺" 	+ cookie.getExpiry() 	+ "�� "
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
    
	/**********************************url����***********************************/
	
	//�ǳ�ϵͳ
    public void logout(){
    	this.openBrowser(indexURL + "/logout.jsp");
    }
    
    public WebDriver getWebDriver(){  	
    	return webDriver;
    }

    //��ȡ��ǰUrl
    public String getCurrentUrl(){
    	return webDriver.getCurrentUrl();
    }
    
    //����ҳ
    public void openBrowser(String url){
    	webDriver.get(url);	
    	if (getElementTextWithPresence(By.cssSelector("body")).contains("ϵͳ��æ")) {
			refreshPage();
		}
    if (getElementTextWithPresence(By.cssSelector("body")).contains("503 Service Unavailable")) {
			Reporter.log(CssUtils.red("ϵͳ�������ҵ���503"));
			//tearDown();
			assertTrueByBoolean(false);
		}
    }

    //�ر�
    public void tearDown(){
    	webDriver.quit();		
    }
    
    public void tearDownByClose(){
    	webDriver.close();
    }
    
    //��ת��ҳ
    public void navigateTo(String url){
    	webDriver.navigate().to(url);
    }
    //ҳ��ˢ��
    public void refreshPage(){
    	webDriver.navigate().refresh();
    }
    //������һҳ
    public void goBack(){
    	webDriver.navigate().back();
    }   
    
	/**
	 * ��ȡ��ַ�ķ�������
	 * ���磺http://mail.163.com/index.html
	 * 	   http://:��Э��
	 *     mail���Ƿ�������
	 *     mail.163.com������վ��
	 *     /������Ǹ�Ŀ¼
	 *     index.html������Ǹ�Ŀ¼�µ�Ĭ����ҳ
	 *     http://mail.163.com/index.html:�������URL
	 * @param webSite(��վ��ַ)
	 * @return ��������
	 */
	public String getWebsiteServerName(String webSite){
		//��ȡ/������ݡ�[0]��http:��[1]����
		String interceptWebsite = webSite.split("/")[2];
		//��ȡ��һ����.����Ϊ����
		int index = interceptWebsite.indexOf(".");
		//��ȡ��һ����ǰ����ַ���
		interceptWebsite = interceptWebsite.substring(0,index);
		//���ؽ�ȡ����ַ���
		return interceptWebsite;
	}
	
    /**
     * ��ȡ��ǰ��ַ�еķ����������磺www.eloancn.com�е�www
     * @return ���ط�������
     * @author ������ 2015-6-4
     */
	public String getServerNameByURL(){
		String interceptWebsite = getCurrentUrl();
		interceptWebsite = getWebsiteServerName(interceptWebsite);
		return interceptWebsite;
	}    
	
	
	/*****************************************************/
	/*****************      �ȴ�Ԫ��              ********************/
	/*****************************************************/
	
	
	/***********************    �ȴ�Ԫ�س��֣���ȷ���Ƿ�ɵ��         ****************************/
	
	public void checkElementClickable(By by,int time){
	    new WebDriverWait(webDriver, time).until(ExpectedConditions.elementToBeClickable(by));
	}
	
	/***********************    �ȴ�Ԫ�س��֣���ȷ���Ƿ��ѡ��         ****************************/
	
    public void checkElementSelected(By by,int time){
    	new WebDriverWait(webDriver, time).until(ExpectedConditions.elementToBeSelected(by));
    }
	
	/***********************    �ȴ�Ԫ�س��֣���ȷ��Title�Ƿ�һ��        **************************/
	
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
	
	/***********************      �ȴ�Alert���֡���ʾ                      ****************************/
    
    public void checkAlert(){
    	new WebDriverWait(webDriver, 20).until(ExpectedConditions.alertIsPresent());
    }
    
    public void checkAlert(int time){
    	new WebDriverWait(webDriver, time).until(ExpectedConditions.alertIsPresent());
    }
    
    /*********************      �ȴ�Ԫ�س��֡���DOM��ʾ                     *****************************/
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
    
    /*********************      �ȴ�Ԫ�س��֡���ҳ��ɼ�                      *****************************/
    
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
    
    /******************      �ȴ�Ԫ�س��֡���У��Ԫ��ֵ�Ƿ���ͬ                    **************************/
    
    public void checkElmentText(By by, String text){  	
    	new WebDriverWait(webDriver, DEFAULT_WAIT_TIME).until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }
    
    public void checkElementwithValue(By by,String value){
    	new WebDriverWait(webDriver, 30).until(ExpectedConditions.textToBePresentInElementValue(by, value));
    }
    
    /*******************************�ж�Ԫ���Ƿ���ڡ���ʾ******************************/
    
    //���ȴ����Ԫ���Ƿ����
    @Deprecated
    public boolean isElementPresentNoWait(By by) {
        try {
      	  webDriver.findElement(by);
      	  return true;
        	} catch (Exception e) {
        		return false;
        	}
    }
   //�ȴ������Ԫ���Ƿ����
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
    //���Ԫ���Ƿ񲻴���
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

    //���Ԫ���Ƿ�ɼ�
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
    
    //���ȴ����Ԫ���Ƿ����
    public boolean isElementPresenceNoWait(By by) {
        try {
      	  webDriver.findElement(by);
      	  return true;
        	} catch (Exception e) {
        		return false;
        	}
    }
    
   //�ȴ������Ԫ���Ƿ����
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
    
    //���alert�Ƿ���ʾ
    public boolean isAlertPresent() {
        try {
        	checkAlert();
        	webDriver.switchTo().alert();
        	return true;
          } catch (Exception e) {
            return false;
          }
    }
    
    //���alert�Ƿ���ʾ
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
     * ����Ԫ
     * ��style�����ж��Ƿ���ʾ
     */
    public Boolean isBlock(By by){
    	Boolean result = false;
    	if(isElementContainsValue(by, "style", "block")){
    		result = true;
    	}
    	return result;
    }
    
    /**
     * ��style�����ж��Ƿ���ʾ
     * @param by
     * @return true��Ϊ����ʾ��false��Ϊ��ʾ
     * @author ������ 2015-7-10
     */
    public boolean isNone(By by){
    	if(isElementContainsValue(by, "style", "none")){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    //�ж�Ԫ���Ƿ���ʾ������ʹ��������isElementVisible����������
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
     * ҳ��Ԫ���Ƿ����ĳֵ
     * @param by ҳ��Ԫ��
     * @param elementName Ԫ������
     * @param value Ԫ��ֵ
     * @return trueΪ������falseΪ������
     * @author ������ 2015-7-22
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
     * �ж��Ƿ�ֻ��
     * @param by
     * @return ����Ԫ
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
    
    
    /*****************************    ��ȡԪ�ء�title    *****************************/
    
    //��ȡҳ��Ԫ�أ����ȴ�
    public WebElement getElementNoWait(By by){
    	return webDriver.findElement(by);
    }

    //�ȴ���ȡҳ��Ԫ��
    public WebElement getElementWithWait(By by){
    	checkElement(by);
    	return webDriver.findElement(by);
    }
    
    public WebElement getElementWithVisible(By by){
    	checkElementVisible(by);
    	return webDriver.findElement(by);
    }
    
    /**
     * ��ȡԪ���б�
     * @param search
     * @return
     */
    public List<WebElement> getElements(By search){  
    	//checkElements(search);
    	return webDriver.findElements(search);
    }
    
    /**
     * ��ȡ�ɼ���ҳ��Ԫ�ؼ���
     * @param by ҳ��Ԫ�� 
     * @return Ԫ�ؼ���
     * @author ������ 2015-11-05
     */
    public List<WebElement> getVisibleElements(By by){  
    	checkElementsVisible(by);
    	return webDriver.findElements(by);
    }
    
    //��ȡҳ���ǩ����
    public String getPageTitle(){
    	return webDriver.getTitle();
    }
    
    //���ȴ���ȡԪ��Text
    public String getElementText(By by){
    	return webDriver.findElement(by).getText().trim();
    }
    
    public String getElementTextWithPresence(By by){
    	checkElement(by);
    	return webDriver.findElement(by).getText().trim();
    }
    
	//�ȴ�����ȡԪ��Text
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
    
    //��ȡԪ�����е�ĳ��Ԫ��
    public WebElement getWebElementByElements(By by, int index){
    	return webDriver.findElements(by).get(index);
    }
    
    //��ȡԪ�����е�ĳ��Ԫ�ص�Text
    public String getIndexElementText(By by,int index){
    	return webDriver.findElements(by).get(index).getText().trim();
    }

    /******************************************��ȡԪ�ص�����ֵ***************************************/
    
    //��ȡ��ťtext
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
     * ��ȡԪ�ص�����ֵ
     * @param by ҳ��Ԫ��
     * @param attr ���ԣ����磺id��type�ȣ�
     * @return ����ֵ
     * @author ������ 2015-12-18
     */
    public String getAttributeWithVisible(By by, String attr){
    	return getElementWithVisible(by).getAttribute(attr);
    }
    
    /******************************************���Ԫ��***************************************/
    //���ȴ�����ĳԪ�ز����
    @Deprecated
    public void clickElementNoWait(By by){
    	try{
    		webDriver.findElement(by).click();
    	}catch(TimeoutException e){
    	}   	
    }
    
    //�ȴ������Ԫ��
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

    //����Ԫ���鲢���ĳ��Ԫ��
    @Deprecated
    public void clickElement(By by, int index){
    	webDriver.findElements(by).get(index).click();
    }
    
    //���ȴ�����ĳԪ�ز����
    public void clickElement(By by){
    	webDriver.findElement(by).click();
    }
    
    //�ȴ������Ԫ��
    public void clickElementByVisible(By by){
    	checkElementVisible(by);
        webDriver.findElement(by).click(); 
    }

    //����Ԫ���鲢���ĳ��Ԫ��
    public void clickElementByIndex(By by, int index){
    	webDriver.findElements(by).get(index).click();
    }
    
    public void clickElementVisibleByIndex(By by, int index){
    	checkElementsVisible(by);
    	webDriver.findElements(by).get(index).click();
    }
    
    /***********************************************�ı���������ֵ***************************************************/
    //���ȴ�ʱ��������ı�������ֵ
    public void elementSendkeyNoClear(By by,String value){
    	checkElement(by,30);
    	WebElement element = webDriver.findElement(by);
    	element.sendKeys(value);
    }
    //���ȴ�ʱ������ı�������ֵ
    public void elementSendkey(By by,String value){
    	WebElement element = webDriver.findElement(by);
    	element.clear();
    	element.sendKeys(value);
    }
    
    //�ȴ�������ֵ
    public void sendKeyAndWait(By by, String value){
    	getElementWithWait(by).clear();
    	webDriver.findElement(by).sendKeys(value);
    }
    
    //�ȴ�������ֵ
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
    //��������ı���
    public void clearTxt(By by){
    	getElementWithWait(by).clear();
    }
    
    /*********************************���������*******************************/
    
    /**
     * ʹ�ÿ�ݼ����½�����
     * @author ������ 2015-8-3
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
     * ʹ��JavaScript���½�����
     * @param url:��Ҫ��ת����ַ
     * @param type:����ַ������("_blank"(�´���), _media, _parent, _search, "_self"(������), _top)
     * @author ������ 2015-8-3
     */
    public void openNewWindowByJavaScirpt(String url, String type){
//    	 ((JavascriptExecutor)webDriver).executeScript("window.open('http://client.eloancn.com','_blank')");
    	 ((JavascriptExecutor)webDriver).executeScript("window.open('" + url + "','" + type + "')");
    }
    
    /**
     * ��õ�ǰ���ھ��
     * @author ������ 2015-4-28
     */
    public String getCurrentWindowHandle(){
    	return webDriver.getWindowHandle();
    }
    
    /**
     * ��õ�ǰ���д��ھ��
     * @return ������ 2015-6-5
     */
    public Set<String> getCurrentWindowHandles(){
    	return webDriver.getWindowHandles();
    }
    
    //��ȡ���д��ڵĸ���
    public int Windowsize(){
    	return webDriver.getWindowHandles().size();
    }
    
    /**
     * ��תָ������
     * @param  ���ھ��
     * @author ������ 2015-4-28
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
     * �ر�ҳ�洰��
     * @param  ���ھ��
     * @author ������ 2015-4-28
     */
    public void closeWindow(String windowHandle){
    	this.jumpToWindow(windowHandle);
		if(browserType.contains("ie")){
			sleep(2000);
		}
    	webDriver.close();
    }
    
    /**
     * ��ȡ�Ӵ��ھ��
     * @param  ������(��ǰ����)���
     * @return �Ӵ��ھ��
     * @author ������ 2015-4-29
     */
    public String getChildWindowHandle(String parentWindowHandle){
        String childWindowHandle = "";
    	//�õ����д��ڵľ��
        Set<String> windowHandles = webDriver.getWindowHandles();//System.out.println("���д��ھ����С�� " + windowHandles.size());//---------����
        Iterator<String> it = windowHandles.iterator();
        while(it.hasNext()){
        	//����Ǹ�����������
        	if(parentWindowHandle == it.next()){
        		continue;
        	}
        	//�����Ӵ��ڵľ��
        	childWindowHandle =  it.next();
        }
		return childWindowHandle;
    }
    
    /**
     * ��ȡ�Ӵ��ھ��2
     * @param parentWindowHandle �����ھ��
     * @return �Ӵ��ھ��
     * @author ������ 2015-11-27
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
     * �رո���������Ĵ���
     * @param  ������(��ǰ����)���
     * @author ������ 2015-6-8
     */
    public void closeOtherWindowHandle(String parentWindowHandle){
    	//�õ����д��ڵľ��
        Set<String> windowHandles = webDriver.getWindowHandles();   //System.out.println("���д��ڸ���: " + windowHandles.size());//-----------����
        Iterator<String> it = windowHandles.iterator();
        String otherHandle = "";
        while(it.hasNext()){
        	//������Ǹ�������ɾ��
        	otherHandle = it.next();    //System.out.println("�������ھ��: " + otherHandle);//-----------����
        	if(!otherHandle.equals(parentWindowHandle)){
        		webDriver.switchTo().window(otherHandle);
        		sleep(2000);
        		webDriver.close();
        	}
        }
    }
    
    //_blank��ת����ҳ
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
     * ����Ŀ��ҳ  �ر�����
     * @param title  ����
     * @author ����Ԫ
     * @return flag 0:ʧ��    1���ɹ�
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
     * ����Ԫ
     * �ر�����handles ����ר�� ����Ͷ�����õ�
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
     * ����Ԫ
     * ����handels����
     */
    public int gethandelsNum(){
    	Set<String> windowHandles = webDriver.getWindowHandles();  
    	return windowHandles.size();
    }
    
    //�ر��´򿪵Ĵ���
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
     * �������ڻ�ȡ���һ�����ھ��
     * @param  ������(��ǰ����)���
     * @return �Ӵ��ھ��
     * @author ����Ԫ 2015-5-5
     */
    public String getLastWindowHandle(String firstWindowHandle,String senWindowHandle){
        String lastWindowHandle = "";
    	//�õ����д��ڵľ��
        Set<String> windowHandles = webDriver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        while(it.hasNext()){
        	//����Ǹ�����������
        	if(firstWindowHandle == it.next() || senWindowHandle == it.next()){
        		continue;
        	}
        	//�����Ӵ��ڵľ��
        	lastWindowHandle =  it.next();
        }
		return lastWindowHandle;
    }
    
    /******************************    ѡ���           ***************************************/
    
    /**
     * ��ȡselect
     * @param 
     * @author ����Ԫ
     */
    public Select elementSelect(By by){
    	return new Select(getElementWithWait(by));
    }
    /**
     * ��������ѡ��
     * @param 
     * @author ����Ԫ
     */
    public void elementSelectByIndex(By by,int index){
    	elementSelect(by).selectByIndex(index);
    }
    /**
     * ����valueѡ��
     * @param 
     * @author ����Ԫ
     */
    public void elementSelectByIndex(By by,String value){
    	elementSelect(by).selectByValue(value);
    }
    /**
     * ͨ�������б���ѡ��Ŀɼ��ı�ѡ��
     * @param 
     * @author ����Ԫ
     */
    public void elementSelectByVisibleText(By by,String value){
    	elementSelect(by).selectByVisibleText(value);
    }
    //��ȡѡ��ѡ����ı�
    public String getSelectedOptionTxt(By by){
    	return elementSelect(by).getFirstSelectedOption().getText();
    }
    
    /****************************************Assert�ж�***********************************************/
    
    /**
     * �ж����ν�� 
     * @param 
     * @author ����Ԫ
     */
    public void assertNotNullBy(By by){
    	Assert.assertNotNull(getElementWithWait(by));
    }
    /**
     * �ж����ν��
     * @param webElement
     * @author ������ 2015-5-8
     */
    public void assertNotNullWebElement(WebElement webElement){
    	Assert.assertNotNull(webElement);
    }
    /**
     * @param 
     * @author ����Ԫ
     */
    public void assertNullBy(By by){
    	Assert.assertNull(getElementWithWait(by));
    }
	
    public void assertTrueBy(By by){
    	Assert.assertTrue(getElementWithWait(by).isDisplayed());
    }

    /**
     * @param 
     * @author ����Ԫ
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
    
    /*******************************************ҳ��ǿ�Ƶȴ�************************************/

	/**
	 * ҳ��ȴ�
	 * @param time�ȴ�ʱ�䣨��λ�����룩
	 */
	public void sleep(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    /**************************************���**********************************/
    
    /**
     * �����ͣ
     * @param ҳ��Ԫ��
     * @author ������ 2015-4-28
     */
    public void mouseToElement(By by){
    	checkElement(by);
    	new Actions(webDriver).moveToElement(this.getElementWithWait(by)).perform();
    }
    public void mouseToIndexElement(By by, int index){
    	new Actions(webDriver).moveToElement(webDriver.findElements(by).get(index)).perform();
    }
    
    /**************************************���̲���*************************************/
    /**
     * ����Ԫ
     * �������´���
     */
//    public void keyBoard(int times){
//    	for (int i = 0; i < times; i++) {
//    		((HasInputDevices) webDriver).getKeyboard().sendKeys(Keys.ARROW_DOWN); 
//    		System.out.println("����");
//		}
//   	    //ע�����ﲻ����Keys.ENTER   
//   	    ((HasInputDevices) webDriver).getKeyboard().sendKeys(Keys.RETURN);  
//    }
    
    public void tabKeyBoard(){
    	new Actions(webDriver).keyDown(Keys.TAB).sendKeys(Keys.F5).keyUp(Keys.TAB).perform();   
    }
    
    public void spaceKeyBoard(){
    	new Actions(webDriver).keyDown(Keys.SPACE).sendKeys(Keys.F5).keyUp(Keys.SPACE).perform();   
    }
    
    /**************************************������*************************************/
    
    /**
     * ��קָ��ID�Ĵ����еĹ�������ָ��λ��
     * @param id ����ID
     * @param height �������߶ȣ�0�Ƕ�����10000�ǵײ�
     * @author ������ 2015-4-30
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
     * ��ק�������������ָ��λ��
     * @param height �������߶ȣ�0�Ƕ�����10000�ǵײ�
     * @author ������ 2015-4-30
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
	
	 /*************************************frame��************************************/
	 
    /**
     * ��ת��frame
     * @param frame����
     * @author ����Ԫ 2015-5-4
     */
    public void switchToFrame(String frameName){
    	webDriver.switchTo().frame(frameName);
    }
    
    /**
     * ��ת��frame
     * @param webelement
     * @author ������ 2015-7-29
     */
    public void switchToFrameByWebElement(WebElement webelement){
    	webDriver.switchTo().frame(webelement);
    }
    
    /**
     * ��frame�ص�ԭ������ҳ��
     * @author ����Ԫ 2015-5-4
     */
    public void fromFrameToDefaultContent(){
    	webDriver.switchTo().defaultContent();
    }
    
    /***********************************alert confirm prompt*************************************/
    /**
     * ��ȡalert/confirm/prompt  ����һ��
     * @author ����Ԫ 2015-5-4
     */
    public Alert getAlert(){
    	return webDriver.switchTo().alert();
    }
    
    public Alert getAlertwithWait(){
    	checkAlert();
    	return webDriver.switchTo().alert(); 
    }
    
    /**
     * ��ȡAlert��ʾ��Ϣ
     * @return Alert��ʾ��Ϣ
     * @author ������ 2015-7-30
     */
    public String getTextByAlert(){
    	return webDriver.switchTo().alert().getText();
    }
    
    public void acceptAlert(){
    	webDriver.switchTo().alert().accept();
    }
    
    /**
     * ���"ȡ��"���߲���Ի���
     * @author ������ 2015-8-12
     */
    public void dismissAlert(){
    	webDriver.switchTo().alert().dismiss();
    }
    
    /**
     * ����Ԫ
     * У��alert��textֵ�Ƿ���ȷ  ��accept��У��
     */
    public void checkAlertText(String message){
    	Alert alert = getAlertwithWait();
    	sleep(1000);
    	String msg = alert.getText();
    	alert.accept();
    	this.assertEqualsActualExpected(msg, message);
    }
    
    /**********************************��ȡTable���е�ֵ********************************/
    
	/**
     * ����տ������
     * @param  by table����
     * @param  rowNum ����
     * @param  cellNum ����
     * @return �е�ֵ
     * @author ������ 2015-5-6
	 */
	public WebElement getCellElement(By by, int rowNum, int cellNum){
		checkElementVisible(by);
		//��ȡTable����
		WebElement tableElement = webDriver.findElement(by);
		//��ȡ���С�Ԫ�صļ���
		List<WebElement> rows = tableElement.findElements(By.tagName("tr"));   //System.out.println("Base: ����" + rowNum);//-----����
		//��ȡָ�����С�����
		WebElement rowWebElement = rows.get(rowNum);  //System.out.println("Base: ����" + cellNum);//-----����
		//��ȡ���С�����
		WebElement cellWebElement = getCell(rowWebElement, cellNum);
		//���ء��С���ֵ
		return cellWebElement;
	}
	
	/**
     * ����տ������
     * @param rowWebElement ���С����� 
	 * @param cellNum ���С���λ��
     * @return ���С�����
     * @author ������ 2015-5-6
	 */
	public WebElement getCell(WebElement rowWebElement, int cellNum){
		//���塰�С�Ԫ��
		WebElement cellWebElement = null;
		//���塰�С�Ԫ�صļ���
		List<WebElement> cellWebElements = null;
		//���С���ǩ�����֣�<td>��<th>
		//���С�Ԫ����Ԫ����<td>��ǩ
		if(rowWebElement.findElements(By.tagName("td")).size()>0){
			//��ȡ���С��С���ǩ�µ�<td>��ǩ
			cellWebElements = rowWebElement.findElements(By.tagName("td"));
			//���ݡ��С���λ�ã���ȡ���С�����
			cellWebElement = cellWebElements.get(cellNum);
		}
		//���С�Ԫ����Ԫ����<th>��ǩ
		else if(rowWebElement.findElements(By.tagName("th")).size()>0){
			//��ȡ���С��С���ǩ�µ�<th>��ǩ
			cellWebElements = rowWebElement.findElements(By.tagName("th"));
			//���ݡ��С���λ�ã���ȡ���С�����
			cellWebElement = cellWebElements.get(cellNum);
		}
		
		if(cellWebElement == null){
			System.out.println("Base: �ж���Ϊ�գ�");
		}
		
		//���ء��С�Ԫ��
		return cellWebElement;
	}
    
    /*********************************�ַ���������*******************************/	
	
	/**
	 * ����Ԫ
	 * ��ȷ��С����ڶ�λ
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
	 * ����Ԫ
	 * ���223.00->223  223.0->223  223.30->223.3
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
	//����С�������λ��ֱ����� 12.256->12.25
	public String CutMoney(double money){
		String money1 = String.valueOf(money)+"0";
		if(money1.contains(".")){
			money1 = money1.substring(0, money1.indexOf(".")+3);
		}
		money1=new DecimalFormat("###,##0.##").format(Double.parseDouble(money1));
		return money1;
	}
	
	/**
	 * �����ָ�ʽ��Ϊ.00��ʽ
	 * @param num
	 * @return
	 */
	public String appendZero(String num){
		int length;
		int pointIndex;
		length = num.length();
		pointIndex = num.indexOf(".");
		//����ַ�����������.��������ӡ�.00��
		if(pointIndex!= -1){
			//��С����Ϊ����2λС��
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
	 * ������ַ�����.00
	 * @param money 
	 * @return 
	 * @author ������ 2016-1-5
	 */
	public String removeZero(String money){
		
		int num = money.indexOf(".");
		if(num != -1){
			money = money.substring(0, money.indexOf("."));
		}
		return money;
	}
	
	/**
	 * ������ַ�����,
	 * @param money 
	 * @return
	 * @author ������ 2016-1-5
	 */
	public String removeComma(String money){
		
		money = money.replaceAll(",", "");
		return money;
	}
	
	/**
	 * double����ʾ�ɿ�ѧ������
	 * @param number ��ʾ�ɿ�ѧ������������
	 * @return ������ѧ������������
	 */
	public String doubleFormat(double number){
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false);
		return numberFormat.format(number);
	}
	
    /**
     * �滻�ַ����е��ַ�
     * @param  originalString��ԭ�ַ�������ExcludeString�����滻���ַ�����replaceString���滻�ַ���
     * @return �滻����ַ�
     * @author ������ 2015-5-4
     * 
     * ���磺ԭ�ַ���"1,066.66" ���滻���ַ���"6," �滻�ַ�:"a" ���:1a0aa.aa
     */
	public String stringToReplace(String originalString, String ExcludeString, String replaceString){
		//ѭ���滻��ExcludeString���ַ����е��ַ�
		for(int i=0;i<ExcludeString.length();i++){
			//charAt()��ȡ�ַ������е�ֵ�������ת�����ַ���
			originalString = originalString.replaceAll(ExcludeString.charAt(i)+"",replaceString);
		}
		return originalString;
	}
	
	/**
	 * ��Ǯ�ַ���ÿ��λ����
	 * @param money ��Ǯ
	 * @return �������¸�ʽ��1,314,321,300
	 * @author ������ 2015-8-11
	 */
	public String stringToMoney(String money){
		NumberFormat nf = new DecimalFormat("#,###,###");
		money = nf.format(Double.parseDouble(money));
		return money;
	}	  
	
	/**
	  * ��Ǯ��ʽ��
	  * ��ע�������������
	  * @param number ��Ҫ��ʽ��������
	  * @param digit ������λС��
	  * @param isShowDefault �Ƿ���ʾĬ��ֵ0.trueΪ��ʾ��false��Ϊ����ʾ
	  * @return ��ʽ���������
	  * @author ������ 2015-9-2
	  * 
	  * ���磺
	  *     ԭ�ַ���"16666666666.666" ����λ����"2" ��ʾĬ��ֵ       ���:16,666,666,666.67
	  *     ԭ�ַ���"16666666666.666" ����λ����"4" ��ʾĬ��ֵ       ���:16,666,666,666.6660
	  *     ԭ�ַ���"16666666666.666" ����λ����"2" ����ʾĬ��ֵ   ���:16,666,666,666.67
	  *     ԭ�ַ���"16666666666.666" ����λ����"4" ����ʾĬ��ֵ   ���:16,666,666,666.666
	  */
	 public String moneyFormat(double number, int digit, boolean isShowDefault){
	  
		 DecimalFormat decimalFormat = new DecimalFormat();
		 StringBuilder digitSB = new StringBuilder();
		 String defaultStr = "";
		 
		 //�Ƿ���ʾĬ��ֵ0��"0"��ʾ��ʾ��"#"��ʾ����ʾ
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
	 * ����С�����λ
	 * @param number ��Ҫ��ʽ��������
	 * @param digit λ��
	 * @param isRound trueΪ�������룬falseΪֱ����ֵ
	 * @return ��ʽ���������
	 * @author ������ 2015-9-2
	 * 
	 * ���磺
	 *     ԭ�ַ���"16.66666667" ����λ��(��������)��"3" ���:16.666
     *     ԭ�ַ���"-16.66666667" ����λ��(����������)��"3" ���:-16.666
     *     ԭ�ַ���"16.66666667" ����λ��(����������)��"0" ���:16.0
	 */
	  public double setRound(double number, int digit, boolean isRound){
		  double result = 0.0;
		  String numberStr = number + "";
		  BigDecimal bigDecimal = new BigDecimal(numberStr);
		  //���λ��Ϊ0����Ϊ������С�����֣�ֱ��ȡ��
		  if(digit == 0){
			  result = Math.floor(number);
		  }
		  else{
			  //����λ������������
			  if(isRound){
				  result = bigDecimal.setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
			  }
			  //����λ����ֱ����ֵ
			  else{
				  result = bigDecimal.setScale(digit, BigDecimal.ROUND_DOWN).doubleValue();
			  }
		  }
		  return result;
	  }
	  
    /**
     * ����С�����λ������������
     * @param  num ����
	 * @param  digit ������λ��
     * @return �����������
     * @author ������ 2015-5-4
     * 
     * ���磺ԭ�ַ���"16.66666667" ����λ����"3" ���:16.666
     *     ԭ�ַ���"-16.66666667" ����λ����"3" ���:-16.666
     */
	public double numNotRoundedUpDown(double num, int digit){
		if(num == 0){
			return 0;
		}else if(num>0){
			//��λ�� ת���� 10����
			int multiples = (int) Math.pow(10, digit);
			//���� ����λ����10���ݣ���ȥС����������
			num = Math.floor(num * multiples);
			//���� ����λ����10���ݣ��õ����
			return num / multiples;
		}else{
			//��λ�� ת���� 10����
			int multiples = (int) Math.pow(10, digit);
			//���� ����λ����10���ݣ���ȥС����������
			num = Math.ceil(num * multiples);
			//���� ����λ����10���ݣ��õ����
			return num / multiples;
		}
	}
	
	/**
	 * ˫���ȸ����Ͷ�������_���
	 * @param numOne ��һ����
	 * @param numTwo �ڶ�����
	 * @return ����֮��
	 * @author ������ 2015-9-7
	 */
	public double add(double numOne, double numTwo){
		BigDecimal bigDecimalOne = new BigDecimal(numOne + "");
		BigDecimal bigDecimalTwo = new BigDecimal(numTwo + "");
		return bigDecimalOne.add(bigDecimalTwo).doubleValue();
	}
	
	/**
	 * ˫���ȸ����Ͷ�������_���
	 * @param numOne ��һ����
	 * @param numTwo �ڶ�����
	 * @return ����֮��
	 * @author ������ 2015-10-8
	 */
	public double subtract(double numOne, double numTwo){
		BigDecimal bigDecimalOne = new BigDecimal(numOne + "");
		BigDecimal bigDecimalTwo = new BigDecimal(numTwo + "");
		return bigDecimalOne.subtract(bigDecimalTwo).doubleValue();
	}
	
	/**
	 * ˫���ȸ����Ͷ�������_���
	 * @param numOne ��һ����
	 * @param numTwo �ڶ�����
	 * @return ����֮��
	 * @author ������ 2016-1-4
	 */
	public double multiply(double numOne, double numTwo){
		BigDecimal bigDecimalOne = new BigDecimal(numOne + "");
		BigDecimal bigDecimalTwo = new BigDecimal(numTwo + "");
		return bigDecimalOne.multiply(bigDecimalTwo).doubleValue();
	}
	
	/**
	 * ˫���ȸ����Ͷ�������_���
	 * @param numOne ��һ����
	 * @param numTwo �ڶ�����
	 * @return ����֮��
	 * @author ������ 2016-1-4
	 */
	public double divide(double numOne, double numTwo){
		BigDecimal bigDecimalOne = new BigDecimal(numOne + "");
		BigDecimal bigDecimalTwo = new BigDecimal(numTwo + "");
		return bigDecimalOne.divide(bigDecimalTwo).doubleValue();
	}
	
	/***************************************����************************************/
	
	/**
	 * ����Ԫ
	 * ��������
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
	 * ����Ԫ
	 * ����
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
		
	/************************************��������ơ��汾******************************************/	
	
	/**
	 * ��ȡ��ǰ���������
	 * @return ���������
	 * @return ������ 2015-6-30
	 */
	public String getBrowserName(){
		//��ȡ��HTML DOM userAgent������ ����ֵ�����������
		String userAgent = (String) ((JavascriptExecutor)webDriver).executeScript("var userAgent = window.navigator.userAgent; return userAgent");
		//IE�����
		if(userAgent.contains("MSIE")){
			return "IE";
		}
		//�ȸ������
		else if(userAgent.contains("Chrome")){
			return "Chrome";
		}
		//��������
		else if(userAgent.contains("Firefox")){
			return "Firefox" ;
		}
		return "��������������Լ��ֶ���ȥ��";
	}
	
	/**
	 * ��ȡ��ǰ������汾
	 * @return ������汾
	 * @return ������ 2015-6-30
	 */
	public String getBrowserEdition(){
		//��ȡ��HTML DOM userAgent������ ����ֵ�����������
		String userAgent = (String) ((JavascriptExecutor)webDriver).executeScript("var userAgent = window.navigator.userAgent; return userAgent");
		String edition = "";//������汾��
		if(userAgent.contains("MSIE")){//IE�����
			edition = userAgent.substring(userAgent.indexOf("MSIE") + "MSIE".length(), userAgent.indexOf(".0;"));//��ȡ�汾��
			return edition;
		}
		else if(userAgent.contains("Chrome")){//�ȸ������
			edition = userAgent.substring(userAgent.indexOf("Chrome/") + "Chrome/".length(), userAgent.indexOf("Safari"));
			edition = edition.substring(0, edition.indexOf("."));
			return edition;
		}
		else if(userAgent.contains("Firefox")){//��������
			edition = userAgent.substring(userAgent.indexOf("Firefox/") + "Firefox/".length(), userAgent.lastIndexOf("."));
			return  edition;
		}
		return "�޷�ʶ��������";
	}
	
	/***************************************���ڡ�ʱ��************************************/
    
    /**
     * ����������������
     * @param smdate
     * @param bdate
     * @return
     * @author ����
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
	 * ��ȡ����֮��
	 * @param dateOne ʱ��1
	 * @param dateTwo ʱ��2
	 * @return ���ڲ�
	 * @author ������ 2015-10-27
	 */
	public long getDifferenceOfDate(long dateOne, long dateTwo){
		
		return (dateOne - dateTwo)/(1000*3600*24);  
	}
	
	/**
	 * ��ȡ��ǰ���ں�����
	 * @return ��ǰ���ں�����
	 * @author ������ 2015-10-27
	 */
	public long getcurrentTimeMillis(){
		
		return System.currentTimeMillis();
	}
	
	/**
	 * ��ȡ��ǰ����ʱ���
	 * @param millis ��ǰ���ں�����
	 * @return ��ǰ����ʱ���
	 * @author ������ 2016-1-4
	 */
	public String getTimeStamp(String millis){
		
		int time = (int)Long.parseLong(millis);
		return time + "";
	}
	
	/**
	 * ��ȡ��ǰ����ʱ���
	 * @return ��ǰ����ʱ���
	 * @author ������ 2016-1-4
	 */
	public String getTimeStamp(){
		
		return (int) (System.currentTimeMillis() / 1000) + "";
	}
	
	//��ȡ��ǰ����
	public int getCurrentDay(){
		Calendar cal = Calendar.getInstance();	
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	/**
	 * �������ڵĺ�����
	 * @param dateString:����(���format�ĸ�ʽƥ��)���磺2015-10-16 00:00:00
	 * @param format:��ʽ(yyyy-MM-dd-HH-mm-ss��yyyy:MM:dd:HH:mm:ss�����ڸ�ʽ)
	 * @return ������
	 * @author ������ 2015-8-31
	 */
	public long getMilliseconds(String dateString, String format){
		
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		//����Calendarʵ��
		Calendar calender = Calendar.getInstance();
		//��ȡ��ʽ�е�����
		try 
		{
			date = sdf.parse(dateString);
		} catch (ParseException e) {}
		//����ʱ��
		calender.setTime(date);
		//��ú�����
		long time = calender.getTimeInMillis();
		return time;
	}
	
	/**
	 * ��ȡϵͳ��ǰʱ��
	 * @return
	 */
	public Date getTime(){
		Date nowDate = new Date();
		return nowDate;
	}
	
	/**
	 * ��ʽ������
	 * @param date��ʱ��
	 * @param format:��ʽ�����磺"yyyy-MM-dd HH:mm:ss"
	 * @return ��ʽ���������
	 */
	public String dateFormat(Date date, String format){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String dateStr = simpleDateFormat.format(date);
		return dateStr;
	}

	//��ȡǰ�����µĵ�һ������ڣ�yyyy-MM-dd  �ϸ��£�previousmonth=-1   ���ϸ��£�previousmonth=-2
	public String getLastMonthDate(int previousmonth){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.MONTH, previousmonth);//2015-09-16
		calendar.set(Calendar.DAY_OF_MONTH, 1);//2015-09-01
		String time = df.format(calendar.getTime());
		return time;
	}
	//��ȡǰ�����µ����һ������ڣ�yyyy-MM-dd �ϸ��£�previousmonth=-1   ���ϸ��£�previousmonth=-2
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
	//��ȡ�ϼ����µ����·�
	public String getMonthDate(int previousmonth){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, previousmonth);			//�ϸ���
		String lastmonth=sdf.format(cal.getTime());//2015-09
		return lastmonth;
	}
	//���ַ����͵�����ת����date
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
	
	/***************************************����************************************/
	
    /**
     * ����Ԫ
     * ���->ȫ��
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
     * ����Ԫ
     * ���ڿؼ�����������
     */
    public void setDate(String id,String date){
    	String str = "document.getElementById('"+id+"').readonly=false";  
		 String strDate = "document.getElementById('"+id+"').value='"+date+"'";  
		 ((JavascriptExecutor)webDriver).executeScript(str);  
		 ((JavascriptExecutor)webDriver).executeScript(strDate);
    }
    
    /**
     * ����Ԫ
     * ����value
     */
    public void setValueById(String id,String value){
		 String strValue = "document.getElementById('"+id+"').value='"+value+"'";  
		 ((JavascriptExecutor)webDriver).executeScript(strValue);
    }
    
    /**
     * ����ҳ��Ԫ���Ƿ���ʾ
     * @param className Ԫ��ClassName
     * @param value block����ʾ��none������
     * @author ������ 2015-12-21
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
     * У��ҳ����ʽ
     * @param by ҳ�����
     * @param styleName ��ʽ����
     * @param styleValue ��ʽֵ
     * @author ������ 2016-2-24
     */
    public void checkCSSValue(By by, String styleName, String styleValue){
    	assertEquals(getCSSValue(by, styleName), styleValue);
    }
    
    /**
     * ��ȡҳ��Ԫ�ص���ʽ
     * @param by������
     * @param styleName����ʽ��
     * @return ��ʽ��ֵ
     * @author ������ 2015-9-1
     */
    public String getStyle(String element, String styleName){
    	String executor = "var style = window.getComputedStyle("+element+",'').getPropertyValue('" + styleName + "').toLowerCase(); return style";
    	String styleValue = (String) ((JavascriptExecutor)webDriver).executeScript(executor);  
    	return styleValue;
	}

    /**
      * ����ǩ��readonly����ȥ��
      */
    public void removeReadOnly(String id){
    	JavascriptExecutor removeAttribute = (JavascriptExecutor)webDriver;
    	//remove readonly attribute
        removeAttribute.executeScript("var setDate=document.getElementById('"+id+"');setDate.removeAttribute('readonly');") ;  
    }
    
    //ģ�ⰴ�����¼����ͷ�,Ȼ����"Enter"��
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
    
    //ģ��ͬʱ����"Alt"�����ַ���
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
	
	//ģ��ͬʱ����"Ctrl"�����ַ���
    public void pressKeyWithCtrl(Robot robot, int keyvalue){
        //ģ�ⰴ��
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(keyvalue);
        
        //ģ�ⵯ��
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(keyvalue);
    }
    
	//ȫѡ�����ơ�ճ���Ĳ���
	public void CopyAndPaste(){
		try {
			Robot robot = new Robot();
			//ȫѡ	
			pressKeyWithCtrl(robot,KeyEvent.VK_A);
			//����
			pressKeyWithCtrl(robot,KeyEvent.VK_C);
			//ճ��
			pressKeyWithCtrl(robot,KeyEvent.VK_V);
			pressKeyWithCtrl(robot,KeyEvent.VK_V);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	//�õ�ƥ���ļ��ĸ���
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
	
	//��ȡ�����ı�Ϣ
	public String benxi(double benji,double lixi,int year){
		double benxi1 = benji*Math.pow(1+lixi, year);
		return String.format("%.2f", benxi1);
	}
	
	/**
	 * ����Ԫ
	 * ��ȡһ���ж�����
	 */
	public int getDaysOfYear(int year){
		//����һ�򣬰��겻���İ�������
		if((year%4==0 && year%100!=0)||year%400==0){
			return 366;
		}else {
			return 365;
		}
	}
	//4λ�������
	public String RandomNumber(){
		Random rand = new Random();
		String randomNum = Long.toString(rand.nextInt(10000));
		return randomNum;
	}
	//�ж��ַ����Ƿ�Ϊ����
	public boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	} 
	//�ж��ַ����Ƿ�Ϊ����
	public boolean isChinese(String str){
		Pattern p_str = Pattern.compile("[\\u4e00-\\u9fb0]+");
		return p_str.matcher(str).matches();
	}
	//�ж��ַ����Ƿ�Ϊ�ֻ���
	public boolean isTelephone(String str){
		Pattern p_str = Pattern.compile("^1[3578]\\d{9}");
		return p_str.matcher(str).matches();
	}
	
	public String ExecuteJS(String search){
		return (String) ((JavascriptExecutor) webDriver).executeScript(search);
	}
}
