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
 * ��¼ҳ
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
//	By nameTxt = By.id("loginName"); //�û���
	By nameTxt = By.cssSelector("#loginName"); //�û���
	By nameTxtByXpath = By.xpath("//input[@id='loginName']"); //�û���
	By passTxt = By.cssSelector("#tpassword");//��ҳ����
	By passTxtByXpath = By.xpath("//input[@id='tpassword']");//��ҳ����
	By passOtherPageTxt = By.cssSelector("#pwdshowtext");//�ҵ��˻�������ҳ�����ĵ�¼����
//	By loginBtn = By.xpath("//input[@class='loginBtn']");//ȷ��
	By loginBtn = By.cssSelector(".loginBtn");
	By loginBtnByXpath = By.xpath("//input[@class='loginBtn']");
	By loginLink = By.xpath("//a[text()='��¼']");
	By loginOtherPageBtn = By.cssSelector(".h50>input[type='button']");//By.xpath("//input[@class='loginBtn-new ']");
//	By quitBtn = By.xpath("//a[text()='�˳�']");//�˳�   //a[text()='�˳�'] //a[@href='/logout.jsp'] //li[@class='global'][1]/a
	By quitBtn = By.cssSelector(".vwmy>a");//.topBarR.fr > li:nth-child(3) > a
	By loginTxt = By.xpath("//*[@id='form_login1']//span[text()='��¼']");
	By freeRegisterLink = By.cssSelector(".fr.lh40>a");//���ע��
	
	/**
	 * ��ȡ���˳�������Ԫ��
	 * @return �˳�Ԫ��
	 * @author ������ 2015-5-15
	 */
	public WebElement getQuitBtn(){
		return base.getElementWithVisible(quitBtn);
	}
	
	/**
	 * �ǳ���ֻ����֤��ҳ�Ƿ��¼��
	 * @author ������ 2015-12-21
	 */
    public void logoutByIndex(){
		if(!isLogout()){
			base.logout();
		}
    }
    
	/**
	 * �ǳ���ֻ����֤�ҵ��˻��Ƿ��¼��
	 * @author ������ 2015-12-21
	 */
    public void logoutByMyAccount(){
		if(ifMyAccountLogin()){
			base.logout();
		}
    }
	
	/**
	 * ����Ԫ
	 * �����ֻ���
	 */
	public void inputTel(String tel){
		base.sendKeysWithWait(nameTxt, tel);
	}
	
	/**
	 * ����Ԫ
	 * �����¼
	 */
	public void clickLoginBtn(){
		base.clickWithWait(loginBtn);
	}
	
	/**
	 * ��ʾ�˻�����������˻��������������գ�����ʾ��֤������ģ��  
	 */
	public void isLoginWrong(){
		base.switchToFrame("loginBoxFrame");
		//��ʾ�˻����������
		base.checkElementVisible(By.cssSelector("#errorMessage"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#errorMessage")), "�û��������벻ƥ�䡣");
		//�˻��������
		base.isElementContainsValue(By.cssSelector("#loginName"),"value","����/���֤/�ֻ���");
		base.assertEqualsActualExpected(base.getAttribute(By.cssSelector("#tpassword"),"value"), "");
		//��ʾ��֤������ģ��
		base.checkElementVisible(By.cssSelector("#randCode"));
	}
	
	public void wrongMsg(String msg){
		if(base.isElementPresentNoWait(Iframe)){
			base.switchToFrame("loginBoxFrame");
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#errorMessage")), msg);
	}
	
	/**
	 * ����Ԫ
	 * ������ע��
	 */
	public void clickFreeRegister(){
		base.clickWithWait(freeRegisterLink);
	}
	
	/**
	 * ����Ԫ
	 * �رյ�¼����
	 */
	public void closeLogin(){
		base.clickWithWait(By.cssSelector(".close"));
		base.fromFrameToDefaultContent();
		//base.isElementEmpty(By.cssSelector(".loginCont2"));
		base.checkNoElement(By.cssSelector(".loginCont2"));
	}
	
	/**********************************��վ��ҳ��¼***************************************/
	
	/**
	 * ����Ԫ
	 * ��ҳ��¼
	 * �޸�  ������ 2015-6-25
	 */
	public void login(String name, String pass){
		if (base.gethandelsNum()>=2) {
			base.closeWebDriver();
		}
		//�ж��Ƿ����iframe��
//		if(base.isElementPresent(By.xpath("//iframe[@id='loginBoxFrame']"))){
		if(base.isElementPresenceNoWait(Iframe)){
			base.switchToFrame("loginBoxFrame");
		}
		base.sendKeysWithWait(nameTxt, name);
		base.sendKeysWithWait(passTxt, pass);
		/*if (base.checkVisibleNoWaite(By.cssSelector("#randCodeP"))) {
			String imgCode = data.get(base.getElementWithWait(By.cssSelector("#randCodeImg")), base.getWebDriver());
			System.out.println("��֤���ǣ�"+imgCode);
			base.sendKeysWithWait(By.cssSelector("#randCode"), imgCode);
		}*/
		base.clickWithWait(loginBtn);
		base.fromFrameToDefaultContent();
		base.isTitleContains(PageTitles.shouYe);
		//base.checkElmentwithTxt(quitBtn, "�˳�");
		//isLoginOK();
	}

	//��ҳ��¼
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
	 * ��ҳ��¼
	 * ��XPath��ȡҳ��Ԫ�أ�ʹ��IE
	 * �޸�  ������ 2015-6-25
	 */
	public void loginWithXpath(String name, String pass){
		//�ж��Ƿ����iframe��
		if(base.isElementPresent(By.cssSelector("#loginBoxFrame"))){
			base.switchToFrame("loginBoxFrame");
		}
		base.sleep(3000);
		base.sendKeysWithWait(nameTxtByXpath, name);
		base.sendKeysWithWait(passTxtByXpath, pass);
		base.clickWithWait(loginBtnByXpath);
		base.fromFrameToDefaultContent();
	}
	
	/**********************************��վ�ҵ��˻���¼***************************************/
	
	/**
	 * ����Ԫ
	 * �ҵ��˻�������ҳ��ĵ�¼(û��frame)
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
		base.clickWithWait(loginOtherPageBtn);//��¼
		base.sleep(3000);
	}
	
	/**
	 * ���ҵ��˻���¼
	 * @param logiName �û���
	 * @param password ����
	 * @author ������ 2015-7-10
	 */
	public void loginByMyAccount(String loginName, String password){
		
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		TotalPage.openPage("�ҵ��˻�", false);
		loginWithNoFrame(loginName, password);
		TotalPage.openPage("�ҵ��˻�", true);
		try {
			base.assertEqualsActualExpectedByBoolean(ifLogin(), true);
		} catch (Exception e1) {
			System.out.println("�˻���" + loginName + " ��¼ʧ�ܣ�");
			Reporter.log("�˻���" + loginName + " ��¼ʧ�ܣ�");
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
	
	//����-�ҵ��˻���¼
	public void LogininMyAccount(String name, String pass){
		base.sendKeysWithWait(nameTxt, name);
		base.checkElementClickable(passOtherPageTxt,10);
		base.clickWithWait(passOtherPageTxt);
		base.checkNoElement(passOtherPageTxt);
		base.checkElementVisible(passTxt);
		base.sendKeysWithWait(passTxt, pass);
		base.clickWithWait(loginOtherPageBtn);//��¼
		base.sleep(3000);
	}
	
	/**********************************��վ����ר����¼***************************************/
	
	/**
	 * ����Ԫ
	 * ����ר�� ����Ͷ��  ��¼
	 */
	public void fastInvestLogin(String name, String pass){
		base.sendKeysWithWait(nameTxt, name);
		base.sendKeysWithWait(passTxt, pass);
		base.clickWithWait(loginBtn);
	}
	
	/**********************************��վ�ж��Ƿ��¼���ǳ�***************************************/
	
	/**
	 * ����Ԫ
	 * ��֤�ǵ�¼״̬  web
	 */
	public void isLoginOK(){
		//base.assertNotNullBy(quitBtn);
		base.refreshPage();
		//���˳�������
		base.assertTrueByBoolean(!base.getElementWithWait(By.xpath("//a[text()='�˳�']/parent::li")).getAttribute("class").contains("hide"));
	}
	
	/**
	 * �Ƿ�ǳ�(��ҳ�����жϣ��ҵ��˻�ҳ�����ж�)
	 * @return true���ǳ���false����¼
	 * @author ������ 2015-12-11 
	 */
	public boolean isLogout(){
		return base.getElementWithWait(By.xpath("//a[text()='�˳�']/parent::li")).getAttribute("class").contains("hide");//���˳�������
	}
	
	/**
	 * ����Ԫ
	 * ��֤��δ��¼״̬
	 */
	public void isNotLogin(){
		try {
			base.assertNotNullBy(loginLink);
		} catch (AssertionError e) {
			base.assertNotNullBy(loginTxt);
		}
	}
	
	/**
	 * �ж��Ƿ��¼(�ҵ��˻�)
	 * �������޸� 2015-11-4
	 */
	public Boolean ifLogin(){
		base.checkElement(RegisterLnk);
		if(base.getLnkElementText(RegisterLnk, "class").equals("account_name")){
			return true;// �ѵ�¼
		}
		return false;// δ��¼
	}
	
	/**
	 * ����Ԫ
	 * �ҵ��˻��Ƿ��¼
	 */
	public boolean ifMyAccountLogin(){
		if (base.checkVisible(loginTxt, 3)) {
			return false;
		}
		return true;
	}
	
	//���µ�¼
	public void reLogin(String name, String pass){
		base.logout();
		indexPage.clickLoginLink();
		login(name, pass);
	}
	
	/**
	 * ��ҳ��¼
	 * @param name
	 * @param pass
	 */
	public void homeLogin(String name, String pass){
		indexPage.clickLoginLink();
		loginWithXpath(name, pass);
	}
	
	/**********************************��̳��¼���ǳ�***************************************/
	
	/**
	 * ����Ԫ
	 * ��֤��̳�ǵ�¼״̬
	 */
	public void isForumLoginOK(){
		base.assertNotNullBy(quitBtn);
	}
	
	/**
	 * ����Ԫ
	 * ��֤��̳��δ��¼״̬
	 */
	public void isForumNotLogin(){
		base.sleep(3000);
		base.assertNotNullBy(By.xpath("//button[text()='��¼']"));
	}
	
}
