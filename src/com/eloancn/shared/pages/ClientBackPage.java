package com.eloancn.shared.pages;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;

/*
 * 集成环境后台页面
 */
public class ClientBackPage {

	Base base = new Base();
	Data data = new Data();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	DBData dbData = new DBData();

	/****************************通知码页面******************************/
	
	//通知码文本框
	By noticeCodeTxt = By.cssSelector("#noticeCode");
	//通知码提交按钮
	By noticeCodeBtn = By.cssSelector("#subm");
	
	/****************************后台登录页面******************************/
	
	//用户名文本框
	By userNameTxt = By.id("uname");
	//密码文本框
	By passwordTxt = By.id("upwd");
	//验证码图片
	By randImg = By.cssSelector(".yzm>img");
	//验证码文本框
	By randTxt = By.id("rand");
	//登录按钮
//	By LoginBtn = By.id("subm");
	By LoginBtn = By.xpath("//input[@id='subm']");
	
	/****************************后台公告页面******************************/
	
	//系统通告窗口
	By proclamationDiv = By.cssSelector(".tip_box");  
    //确定按钮
	By enterSystemBtn = By.cssSelector("#enterSystem");
	
	/******************************后台页面-导航栏*******************************/
	
	
	/******************************后台页面-菜单栏*******************************/
	
	
	/******************************后台页面-内容栏*******************************/
	
	//Tab关闭按钮
	By tabClose = By.xpath("//a[@class='tabs-close']");
	//下一页按钮
	By nextBtn = By.xpath("//td[@id='next']/span");
	//下一页按钮的Td标签
	By nextTd = By.xpath("//td[@id='next']");
	
	/******************************后台页面-内容栏-理财产品*******************************/
	
	//iframe------------
	//理财产品iframe
	public String wmpsIframe = "//iframe[@src='/admin/wmps.jsp']";
	
	//按钮------------
	//添加理财产品发行记录
	By addWMP = By.xpath("//button[text()='添加理财产品发行记录']");
	//匹配债权
	By matchingBondBtnByWMP = By.xpath("//button[text()='匹配债权']");
	
	//列表------------
	//刷新按钮
	public By refreshBtnByWMPSrecordList = By.xpath("//td[@id='refresh_wmpsrecordlist']//span");
	//理财产品列表_当前页_所有标题
	public By wmpsListByTitle = By.xpath("//td[@aria-describedby='wmpsrecordlist_title']");
	
	/******************************后台页面-内容栏-理财产品-添加理财产品发行记录*******************************/
	
	//产品类型
	By productTypeDropByWMP = By.xpath("//select[@id='type']");
	//标题
	By titleTxtByWMP = By.xpath("//input[@id='title1']");
	//最大金额
	By maxAmountTxtByWMP = By.xpath("//input[@id='maxAmount']");
	//发行利率
	By issueRateTxtByWMP = By.xpath("//input[@id='interestrate']");
	//主利率
	By mainIssueRateTxtByWMP = By.xpath("//input[@id='firstInter']");
	//副利率
	By viceIssueRateTxtByWMP = By.xpath("//input[@id='secInter']");
	//购买有效期
	By validityPeriodTxtByWMP = By.xpath("//input[@id='valitime']");
	//期限
	By timeLimitTxtByWMP = By.xpath("//input[@id='phases1']");
	//发行按钮
	By issueBtnByWMP = By.xpath("//span[text()='发行']/parent::button");
	
	/******************************后台页面-内容栏-待初审借款列表*******************************/
	
	//iframe------------
	//待初审借款列表iframe
	public String trialTendersIframe = "//iframe[@src='/admin/waitTrialTenders.jsp']";
	
	//按钮------------
	//审核(new)
	public By auditNewBtn = By.xpath("//button[text()='审核(new)']");
	
	//列表------------
	//待初审借款列表_当前页_所有借款人姓名
	public By tendlistByBorrowerName = By.xpath("//td[@aria-describedby='tendlist_brealname']");
	//借款人所在行
	By borrowerRow = By.xpath("//td[@title='汤仁琬']/parent::tr");
	//借款人所在行的复选框
	By borrowerChk = By.xpath("//tr[@id='91586']//input");
	
	/******************************后台页面-内容栏-待初审借款列表-查找标*******************************/
	
	//标类型
	By selType = By.xpath("//select[@id='selType']");
	//还款方式
	By repayType = By.xpath("//select[@id='repayType']");
	
	/******************************后台页面-内容栏-待初审借款列表-审核(new)*******************************/
	
	//“加盟商审核意见”按钮
//	By allianceBusinessAuditOpinionBtn = By.xpath("//input[@id='hqCheckWTTenderIdea']");
	By allianceBusinessAuditOpinionBtn = By.id("hqCheckWTTenderIdea");
	//“总部审核意见”按钮
	By headquartersAuditOpinionBtn = By.xpath("//input[@id='FranCheckWTTenderIdea']");
	//“此标初审通过”按钮
	By firstCheckBtn = By.xpath("//input[@id='btnfirstCheck']");
	//“流标”按钮
	By tenderFailBtn = By.xpath("//input[@id='btncheckWTTenderFail']");
	
	/******************************后台页面-内容栏-待初审借款列表-审核标*******************************/
	
	//流标“原因”
	By tenderFailTxt = By.xpath("//textarea[@id='reason' and @rows='12']");
	//“流标”按钮
	By failBtn = By.xpath("//span[text()='流标']/parent::button");
	
	/******************************后台页面-内容栏-待初审借款列表-加盟商审核意见*******************************/
	
	//通过单选按钮
	By passRdo = By.xpath("//input[@id='checkWTType' and @value='1']");
	//加盟商法务风控
	By legalRdoByH = By.xpath("//input[@id='checkWTRole' and @value='11']");
	//综合意见
	By synthesizeTxt = By.xpath("//textarea[@id='checkWTIdea']");
	//补充材料意见
	By supplyTxt = By.xpath("//textarea[@id='checkWTdataIdea']");
	//确定按钮
	public By okBtn = By.xpath("//span[text()='确定']/parent::button");//div[@id='ukVerifyDialog']/parent::div//span[text()='确定']/parent::button
	By okBtn2 = By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'][1]");
	//取消按钮
	public By cancelBtn = By.xpath("//span[text()='取消']/parent::button");
	
	//输入密码
	By passwordTxtByH = By.xpath("//input[@id='deviceRandomCode']");

	/******************************后台页面-内容栏-待初审借款列表-总部审核意见*******************************/
	
	//总部法务风控
	By legalRdoByA = By.xpath("//input[@id='checkWTRole' and @value='01']");
	//仅总部可见意见
	By onlyTxt = By.xpath("//textarea[@id='onlyIdea']");
	
	/******************************后台页面-内容栏-待初审借款列表-批量加入债权池*******************************/
	
	//“批量加入债权池”按钮
	By joinBondBtn = By.xpath("//button[text()='批量加入债权池']");
	//“类型”下拉列表
	By productTypeDropByFinancial = By.xpath("//select[@id='wtype']");
	
	/******************************后台页面-内容栏-债权池标*******************************/
	
	//iframe------------
	//债权池标iframe
	public String tenderThirdpartyIframe = "//iframe[@src='/admin/tenderThirdparty.jsp']";
	
	//按钮------------
	//“查询”按钮
	By selectBtnByBond = By.xpath("//button[text()='查询']");
	//“标题”文本框
	By titleTxt = By.xpath("//input[@id='title']");
	//“状态”下拉列表
	public By statusDropByBond = By.xpath("//select[@id='status']");
	//“加入到产品”按钮
	By joinProductBtnByBond = By.xpath("//button[text()='加入到产品']");
	//“加入到该产品”按钮
	By joinTheProductBtnByBond = By.xpath("//span[text()='加入到该产品']");
	
	//列表------------
	//债权池标_当前页_所有借款人姓名
	public By tendThirdpartyByBorrowerName = By.xpath("//td[@aria-describedby='tendlist_realname']");
	
	/******************************后台页面-内容栏-待终审借款列表*******************************/
	
	//iframe------------
	//待终审借款列表iframe
	public String tenderCheckIframe = "//iframe[@src='/admin/tenderCheck.jsp']";
	
	//按钮------------
	//添加理财产品发行记录
	By auditNewBtnByFinalJudgment = By.xpath("//button[text()='审核(new)']");//待删除
	
	//“对此标审核通过”或“交易确认通过”
	By auditThroughBtnByFinalJudgment = By.xpath("//input[@id='checkSuccess']");
	
	//列表------------
	//待终审借款列表_当前页_所有借款人姓名
	public By tenderCheckByBorrowerName = By.xpath("//td[@aria-describedby='tendlist_brealname']");
	//刷新按钮
	public By refreshBtnByTendList = By.xpath("//td[@id='refresh_tendlist']//span");
	
	/******************************后台页面-内容栏-待终审借款列表-查找标*******************************/
	
	//省市
	By provinceDrop = By.xpath("//select[@id='provinceid']");
	//地市
	By municipalityDrop = By.xpath("//select[@id='cityid']");
	//区县
	By districtDrop = By.xpath("//select[@id='countyid']");
	//标类型“翼企贷标”
	By loanTypeDrop = By.xpath("//select[@id='selType']");
	
	/******************************后台页面-内容栏-二次借款待初审列表*******************************/
	
	//iframe------------
	//二次借款待初审列表iframe
	public String waitTrialTenders2Iframe = "//iframe[@src='/admin/waitTrialTenders2.jsp']";
	
	
	/****************************通知码页面******************************/
			
	/**
	 * 通知码登录
	 * @param noticeCode:通知码
	 * @author 江渤洋 2015-7-29
	 */
	public void LoginByNoticeCode(String noticeCode){
		base.sendKeysWithWait(noticeCodeTxt, noticeCode);
		base.sleep(1000);
		do{
			base.clickWithWait(noticeCodeBtn);
			base.sleep(2000);System.out.println("跳转后页面Title: " + base.getPageTitle());
			if(base.getPageTitle().equals("后台管理登录")){break;}
		}while(true);
	}
	
	/****************************后台登录页面******************************/
	
	/**
	 * 后台系统登录
	 * @param userName:用户名
	 * @param password:密码
	 * @author 江渤洋 2015-7-29
	 */
	public void LoginByClientBack(String userName, String password){

		String imgCode = "";
		//如果验证码输入错误则循环输入，直到输入正确为止
		do{
			String currentURL = "";
			base.checkElementVisible(userNameTxt);
			imgCode = data.get(base.getElementWithWait(randImg), base.getWebDriver());
			base.sendKeysWithWait(randTxt, imgCode);
			base.sendKeysWithWait(userNameTxt, userName);
			base.sendKeysWithWait(passwordTxt, password);
//			System.out.println("请手动输入验证码....");
//			base.sleep(8000);
//			System.out.println("准备点击登录按钮");
			base.assertEqualsActualExpectedByBoolean(base.isElementPresent(LoginBtn), true);
			base.clickWithWait(LoginBtn);
			System.out.println("登录按钮点击完毕");
			base.sleep(5000);
			currentURL = base.getCurrentUrl();
			if(currentURL.equals("http://main.eloancn.com/maintenance.html")){
				base.goBack();base.goBack();
				base.sleep(2000);
			}
			else{
				break;
			}
		}while(true);
		//系统通告窗口弹出时，单击确定按钮
		if(!base.isNone(proclamationDiv)){
			base.sleep(15000);
			//校验“确定”按钮是否显示
			base.assertEqualsActualExpectedByBoolean(base.isDisplayed(enterSystemBtn), true);//System.out.println("确定按钮是否显示：" + base.isDisplayed(enterSystemBtn));//--------测试
			base.clickWithWait(enterSystemBtn);
		}
		base.fromFrameToDefaultContent();
		base.sleep(5000);
	}
	
	/**
	 * 后台登录
	 * @param URL：后台地址
	 * @param noticeCode：通知码
	 * @param userName：用户名
	 * @param password：密码
	 */
	public void backLogin(String URL, String noticeCode, String userName, String password){
		base.openBrowser(URL);
		base.sleep(2000);
		LoginByNoticeCode(noticeCode);
		LoginByClientBack(userName, password);
	}
	
	/******************************后台页面-左侧-菜单栏*******************************/
	
	/**
	 * 点击一级菜单
	 * @param panelExpandName：菜单名称
	 * @author 江渤洋 2015-7-30
	 */
	public void clickFirstMenu(String menuName){
		By firstMenu = By.xpath("//div[text()='" + menuName + "']");
		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(firstMenu), true);
		base.clickWithWait(firstMenu);
		base.sleep(3000);
	}
	
	/**
	 * 点击二级菜单
	 * @author 江渤洋 2015-7-30
	 */
	public void clickSubMenu(String menuName){
		By subMenu = By.xpath("//a[text()='" + menuName + "']");
		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(subMenu), true);
		base.clickWithWait(subMenu);
		base.sleep(5000);
	}
	
	/******************************后台页面-内容栏-公共*******************************/
	
	/**
	 * 跳转至iframe
	 * @param iframeURL(例如：//iframe[@src='/admin/wmps.jsp'])
	 * @author 江渤洋 2015-8-4
	 */
	public void jumpIframe(String iframeURL){
		boolean isTrue = base.isElementPresent(By.xpath(iframeURL));
		if(isTrue){
			//跳转到对应页
			base.switchToFrameByWebElement(base.getElementWithWait(By.xpath(iframeURL)));
		}
		else{
			System.out.println("该iframe不存在");
		}
	}
	
	/**
	 * 点击后台-内容页-按钮
	 * @param btnText：按钮名称
	 */
	public void clickBtnByList(String btnText){
		By tempBtn = By.xpath("//button[text()='" + btnText + "']");
		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(tempBtn), true);
		base.clickWithWait(tempBtn);
	}
	
	/**
	 * 点击列表刷新按钮
	 */
	public void clickRefreshBtn(By by){
		base.clickWithWait(by);
	}
	
	/**
	 * 查找后台列表中某个字段下是否有“需要找的值”（例如：借款人姓名）
	 * 备注：只能找到第一个显示的值（例如：借款者姓名）
	 * @param iframeURL：列表iframe地址（例如：//iframe[@src='/admin/waitTrialTenders.jsp']）
	 * @param ListBy：某个字段集合（例如：tendlistByBorrowerName = By.xpath("//td[@aria-describedby='tendlist_brealname']")）
	 * @param searchField:查找字段（例如：借款人姓名为“用户二”）
	 * @return true:查找字段存在；false：查找字段不存在
	 * @author 江渤洋 2015-7-30
	 */
	public boolean isSearchFieldByList(String iframeURL, By listBy, String searchField){
		
		//是否存在
		boolean isTrue = false;
		String tempNameString = "";
		List<WebElement> borrowerNameList = null;
		
		//跳转到“待初审借款列表”页
		jumpIframe(iframeURL);
		//翻页查找姓名
		do{
			System.out.println("\n-------------开始_查找借款人----------------\n");//------------测试
			borrowerNameList = new ArrayList<WebElement>();
			borrowerNameList = base.getElements(listBy);
			int size = borrowerNameList.size();System.out.println("列表大小：" + size);//------------测试
			//如果找到相同姓名则跳出循环
			for(int i = 0; i < size; i++){
				tempNameString = base.getElementTextWithWait(borrowerNameList.get(i));System.out.println("第" + (i + 1) + "条: " + tempNameString);//------------测试
				if(searchField.equals(tempNameString)){
					isTrue = true;
				}
			}
			
			System.out.println("\n-------------结束_查找借款人----------------\n");//------------测试
			
			//如果没有，点击下一页
			if(!isTrue){
				boolean isBtnDisabled = false;
				//是否隐藏;true为隐藏，false为显示
				isBtnDisabled = base.isElementContainsValue(nextTd, "class", "disabled");System.out.println("下一页按钮是否隐藏： " + isBtnDisabled);//------------测试
				//判断当前页是否是最后一页，即下一页按钮是否隐藏
				if(isBtnDisabled){
//					System.out.println("error_列表没有找到借款人");
//					break;
					base.clickWithWait(By.xpath("//td[@id='tendpager_left']//span"));
					base.sleep(2000);
				}
				else{
					base.clickWithWait(nextBtn);
				}
			}
			base.sleep(5000);
		}while(!isTrue);

		return isTrue;
	}
	
	/******************************后台页面-内容栏-待初审借款列表*******************************/
	
	/**
	 * 获取借款人所在行的ID
	 * @param 借款人姓名
	 * @return 行的ID
	 */
	public String getBorrowerID(String borrowerName){
		
		//借款人的行ID
		String borrowerID = "";
		//获取借款人所在行
		By borrowerRow = org.openqa.selenium.By.xpath("//td[@title='" + borrowerName + "']/parent::tr");
		//获取行ID
		borrowerID = base.getLnkElementText(borrowerRow, "id");System.out.println("借款人所在行的ID：" + borrowerID);
		return borrowerID;
	}
	
	/**
	 * 勾选借款人复选框
	 * @author 江渤洋 2015-7-30
	 */
	public void clickBorrowerChk(String borrowerID){
		
		By borrowerChk = org.openqa.selenium.By.xpath("//tr[@id='" + borrowerID + "']//input");
		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(borrowerChk), true);
		base.clickWithWait(borrowerChk);
	}
	
	/**
	 * 查询标
	 * @author 江渤洋 2015-8-17
	 */
	public void selectLoan(String iframeURL){
		jumpIframe(iframeURL);
		//点击“查询”按钮
		clickBtnByList("查找");
		base.sleep(3000);
		//标类型
		base.elementSelectByVisibleText(selType, "翼企贷标");
		base.sleep(1000);
		//标还款方式
		base.elementSelectByVisibleText(repayType, "还本付息");
		//点击“确定”按钮
		base.clickWithWait(okBtn);
		base.sleep(2000);
	}
	
	/**
	 * 待初审借款列表——审核借款(三次加盟商审核意见，再一次加盟商置初审通过，一次总部审核意见)
	 * 备注：未来实现根据UK用户ID判断是否审核过
	 * @param borrowerName:借款人姓名 
	 * @param auditName:审核账户
	 * @param lastSecondCheck:是否为最后一次为初审通过
	 * @param passwordByBack:后台确认密码
	 * @author 江渤洋 2015-7-30
	 */
	public void tendlistAuditLoan(String borrowerName, String auditName, boolean lastSecondCheck, String passwordByBack){

		//借款人行ID
		String borrowerID = "";
		//Alter提示信息
		String alertString = "";
		//窗口句柄
		String parentWindowHandle = "";
		String childWindowHandle = "";
		//“综合意见”
		String synthesizeString = "江渤洋，自动化测试，综合意见。江渤洋，自动化测试，综合意见。江渤洋，自动化测试，综合意见。";
		//“补充材料意见”
		String supplyString = "江渤洋，自动化测试，补充材料意见。江渤洋，自动化测试，补充材料意见。";
		//“仅总部可见意见”
		String onlyString = "江渤洋，自动化测试，仅总部可见意见。江渤洋，自动化测试，仅总部可见意见。";
		
		parentWindowHandle = base.getCurrentWindowHandle();System.out.println("父窗口句柄：" + parentWindowHandle);
		//获取借款人所在行的ID
		borrowerID = getBorrowerID(borrowerName);
		//根据ID勾选“是否可审”的复选框
		clickBorrowerChk(borrowerID);
		base.sleep(5000);
		//点击“审核(new)”按钮
		clickBtnByList("审核(new)");
		base.sleep(5000);
		if(base.isAlertPresent()){
			//弹出“总部已禁用杠杆”，点击确定
			alertString = base.getTextByAlert();System.out.println("审核(new)弹出提示信息：" + alertString);//---------测试
//			base.assertEqualsActualExpected(alertString, "总部已禁用杠杆");
			base.acceptAlert();
		}
		//弹出新窗口，获取子窗口并跳转
		base.sleep(5000);
		if(base.Windowsize()>1){
			childWindowHandle = base.getChildWindowHandle(parentWindowHandle);System.out.println("子窗口句柄：" + childWindowHandle);//---------测试
			base.jumpToWindow(childWindowHandle);System.out.println("当前窗口句柄：" + base.getCurrentWindowHandle());//---------测试
			if(childWindowHandle.equals(parentWindowHandle)){
				base.turnToNewPage();
			}
		}
		base.sleep(8000);//System.out.println("用户名：" + auditName + " 是否包含'_': " + auditName.contains("_"));//---------测试
		//包含“_”为加盟商用户，否则为总部用户
		if(auditName.contains("_")){
			//点击“加盟商审核意见”
			do{
				base.clickWithWait(allianceBusinessAuditOpinionBtn);
				base.sleep(2000);
				if(base.isElementContainsValue(By.xpath("//div[@id='checkWTTenderIdeaDiv']/div"), "style", "block")){break;}
			}while(true);
			//点击“通过”单选按钮
			base.clickWithWait(passRdo);
			base.sleep(1000);
			//点击“加盟商法务风控”单选按钮
			base.clickWithWait(legalRdoByH);
			base.sleep(1000);
			//填写“综合意见”
			base.sendKeyAndWait(synthesizeTxt, synthesizeString);
			base.sleep(1000);
			//填写“补充材料意见”
			base.sendKeyAndWait(supplyTxt, supplyString);
			base.sleep(1000);
			base.assertEqualsActualExpectedByBoolean(base.isElementPresent(okBtn), true);
			//点击“确定按钮”
			base.clickWithWait(okBtn);
			base.sleep(2000);
			//获取Alter的内容
			alertString = base.getTextByAlert();System.out.println("加盟商审核确定按钮提示信息：" + alertString);//---------测试
			if(alertString.equals("您对该标已提过意见，不能再次操作！")){
				base.acceptAlert();
				base.sleep(2000);
				base.clickWithWait(cancelBtn);
			}
			else{
				base.acceptAlert();
			}
			base.sleep(5000);
			//如果为倒数第二次，即为加盟商置初审通过
			if(lastSecondCheck){
				do {
					if(base.isElementPresent(firstCheckBtn)){
						break;
					}
				} while (true);
				//点击“此标初审通过”
				base.clickWithWait(firstCheckBtn);
				base.sleep(2000);
				//输入密码
				base.sendKeyAndWait(passwordTxtByH, passwordByBack);
				base.sleep(5000);
				//点击确定按钮
				base.clickWithWait(By.xpath("html/body/div[23]/div[11]/div/button[1]"));
				base.sleep(2000);
				//获取Alter的内容
				alertString = base.getTextByAlert();System.out.println("加盟商初审通过确定按钮提示信息1：" + alertString);//---------测试
				base.sleep(1000);
				base.acceptAlert();
				base.sleep(3000);
				alertString = base.getTextByAlert();System.out.println("加盟商初审通过确定按钮提示信息2：" + alertString);//---------测试
				base.sleep(1000);
				base.acceptAlert();
			}
		}
		else{
			//点击“总部审核意见”
			do{
				base.clickWithWait(headquartersAuditOpinionBtn);
				base.sleep(2000);
				if(base.isElementContainsValue(By.xpath("//div[@id='checkWTTenderIdeaDiv']/div"), "style", "block")){break;}
			}while(true);
			base.sleep(1000);
			//点击“通过”单选按钮
			base.clickWithWait(passRdo);
			base.sleep(1000);
			//点击“加盟商法务风控”单选按钮
			base.clickWithWait(legalRdoByA);
			base.sleep(1000);
			//填写“综合意见”
			base.sendKeyAndWait(synthesizeTxt, synthesizeString);
			base.sleep(1000);
			//填写“补充材料意见”
			base.sendKeyAndWait(supplyTxt, supplyString);
			base.sleep(1000);
			//填写“仅总部可见意见”
			base.assertEqualsActualExpectedByBoolean(base.isElementPresent(onlyTxt), true);
			base.sendKeyAndWait(onlyTxt, onlyString);
			base.sleep(1000);
			//点击“确定按钮”
			base.clickWithWait(okBtn);
			//获取Alter的内容
			alertString = base.getTextByAlert();System.out.println("总部审核确定按钮提示信息：" + alertString);//---------测试
			base.assertEqualsActualExpected(alertString, "操作成功！");
			base.acceptAlert();
			base.sleep(1000);
		}
		//如果弹出“请求出错!”窗口，点击确定并报错，估计是session过期
		//关闭当前窗口
		System.out.println("窗口大小：" + base.Windowsize());
		if(base.Windowsize()>1){
			base.closeWindow(childWindowHandle);
			base.sleep(3000);
			base.jumpToWindow(parentWindowHandle);
		}
	}
	
	/**
	 * 流标
	 * @param borrowerName:借款人姓名
	 * @param passwordByBack:后台确认密码
	 * @author 江渤洋 2015-8-25
	 */
	public void tenderFail(String borrowerName, String passwordByBack){
		//借款人行ID
		String borrowerID = "";
		//Alter提示信息
		String alertString = "";
		//窗口句柄
		String parentWindowHandle = "";
		String childWindowHandle = "";
		
		//流标“原因”
		String reasonString = "江渤洋，自动化测试，流标意见。江渤洋，自动化测试，流标意见。";
		
		parentWindowHandle = base.getCurrentWindowHandle();System.out.println("父窗口句柄：" + parentWindowHandle);
		//获取借款人所在行的ID
		borrowerID = getBorrowerID(borrowerName);
		//根据ID勾选“是否可审”的复选框
		clickBorrowerChk(borrowerID);
		base.sleep(5000);
		//点击“审核(new)”按钮
		clickBtnByList("审核(new)");
		base.sleep(5000);
		if(base.isAlertPresent()){
			//弹出“总部已禁用杠杆”，点击确定
			alertString = base.getTextByAlert();System.out.println("审核(new)弹出提示信息：" + alertString);//---------测试
			base.assertEqualsActualExpected(alertString, "总部已禁用杠杆");
			base.acceptAlert();
		}
		//弹出新窗口，获取子窗口并跳转
		base.sleep(5000);
		if(base.Windowsize()>1){
			childWindowHandle = base.getChildWindowHandle(parentWindowHandle);System.out.println("子窗口句柄：" + childWindowHandle);//---------测试
			base.jumpToWindow(childWindowHandle);System.out.println("当前窗口句柄：" + base.getCurrentWindowHandle());//---------测试
			if(childWindowHandle.equals(parentWindowHandle)){
				base.turnToNewPage();
			}
		}
		base.sleep(8000);
		//点击“流标”按钮
		base.clickWithWait(tenderFailBtn);
		base.sleep(2000);
		//输入密码
		base.sendKeyAndWait(passwordTxtByH, passwordByBack);
		base.sleep(5000);
		//点击确定按钮
		base.clickWithWait(By.xpath("html/body/div[24]/div[11]/div/button[1]"));
		base.sleep(2000);
		base.sendKeyAndWait(tenderFailTxt, reasonString);
		base.sleep(1000);
		//点击“流标”按钮
		base.clickWithWait(failBtn);
		base.sleep(2000);
		alertString = base.getTextByAlert();System.out.println("流标弹出提示信息：" + alertString);//---------测试
		base.assertEqualsActualExpected(alertString, "确定撤销此标吗？");
		base.acceptAlert();
		base.sleep(2000);
		base.acceptAlert();
		if(base.Windowsize()>1){
			base.closeWindow(childWindowHandle);
			base.sleep(3000);
			base.jumpToWindow(parentWindowHandle);
		}
	}
	
	/******************************后台页面-内容栏-二次借款待初审列表*******************************/
	
	/**
	 * 查询标
	 * @author 江渤洋 2015-8-17
	 */
	public void selectLoanByTwice(String iframeURL){
		jumpIframe(iframeURL);
		//点击“查询”按钮
		clickBtnByList("查找");
		base.sleep(3000);
		//标类型
		base.elementSelectByVisibleText(selType, "翼企贷");
		base.sleep(1000);
		//点击“确定”按钮
		base.clickWithWait(okBtn);
		base.sleep(2000);
	}
	
	/******************************后台页面-内容栏-理财产品-添加理财产品发行记录*******************************/
	
	/**
	 * 添加理财产品
	 * @param loanPurpose:借款目的
	 * @param loanAmount:借款金额
	 * @author 江渤洋 2015-7-31
	 */
	public void addWMP(String loanPurpose, String loanAmount){
		
		//Alert提示信息
		String alertString = "";
		
		//跳转到“理财产品”页
		jumpIframe(wmpsIframe);
		base.sleep(2000);
		//点击“添加理财产品发行记录”
//		base.clickWithWait(addWMP);
		clickBtnByList("添加理财产品发行记录");
		base.sleep(2000);
		//输入密码
		base.sendKeyAndWait(passwordTxtByH, Data.passwordByBack);
		//点击“确定”按钮
		base.clickWithWait(okBtn);
		base.sleep(2000);
		//填写产品信息
		base.elementSelectByVisibleText(productTypeDropByWMP, "翼存宝");
		//标题
		base.sendKeyAndWait(titleTxtByWMP, "自动化测试" + loanAmount);
		//最大金额
		base.sendKeyAndWait(maxAmountTxtByWMP, loanAmount);
		//发行利率
		base.sendKeyAndWait(issueRateTxtByWMP, "12");
		//主利率
		base.sendKeyAndWait(mainIssueRateTxtByWMP, "10.5");
		//副利率
		base.sendKeyAndWait(viceIssueRateTxtByWMP, "1.5");
		//购买有效期
		base.sendKeyAndWait(validityPeriodTxtByWMP, "24");
		//期限
		base.sendKeyAndWait(timeLimitTxtByWMP, "30");
		//点击“发行”按钮
		base.clickWithWait(issueBtnByWMP);
		base.sleep(3000);
		//Alert
		alertString = base.getTextByAlert();System.out.println("添加理财产品发行记录弹出提示信息：" + alertString);//---------测试
//		base.assertEqualsActualExpected(alertString, "总部已禁用杠杆");
		base.acceptAlert();
		base.sleep(3000);
		alertString = base.getTextByAlert();System.out.println("添加成功提示信息：" + alertString);//---------测试
		base.assertEqualsActualExpected(alertString, "操作成功");
		base.acceptAlert();
	}
	
	/**
	 * 根据ID，查看产品“状态”
	 * @param id
	 */
	public void checkProductStatus(String id){
		System.out.println(base.getLnkElementText(By.xpath(".//*[@id='" + id + "']/td[17]"), "title"));//-------测试
		boolean isTrue = base.isElementContainsValue(By.xpath(".//*[@id='" + id + "']/td[17]"), "title", "认购完成，审核中 ");
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
	}
	

	/******************************后台页面-内容栏-待初审借款列表-批量加入债权池*******************************/

	/**
	 * 批量加入债权池
	 * @author 江渤洋 2015-8-4
	 */
	public void joinBond(String borrowerName, String passwordByBack){
		
		String borrowerID = "";
		//Alert提示信息
		String alertString = "";
		//获取借款人所在行的ID
		borrowerID = getBorrowerID(borrowerName);
		base.sleep(2000);
		//根据ID勾选“是否可审”的复选框
		clickBorrowerChk(borrowerID);
		do{
			//点击“批量加入债券池”按钮
			clickBtnByList("批量加入债权池");
			if(base.isElementContainsValue(By.xpath("//div[@aria-labelledby='ui-dialog-title-ukVerifyDialog']"), "style", "block")){break;}
		}while(true);
		//输入密码
		base.sendKeyAndWait(passwordTxtByH, passwordByBack);
		//点击“确定”按钮
		base.clickWithWait(By.xpath("//div[@id='ukVerifyDialog']/parent::div//span[text()='确定']/parent::button"));
		//选择理财类型为“理财包产品”
		base.elementSelectByVisibleText(productTypeDropByFinancial,"理财包产品");
		//点击“确定”按钮
		base.clickWithWait(By.xpath("//div[@id='wmpsTender_dialog_target']//span[text()='确定']/parent::button"));
		//弹出Alter，点击确定
		alertString = base.getTextByAlert();System.out.println("批量加入债权池弹出提示信息：" + alertString);//---------测试
		base.acceptAlert();
		base.assertEqualsActualExpected(alertString, "操作成功!");
		base.sleep(2000);
	}
	
	/******************************后台页面-内容栏-债权池标-加入到产品*******************************/
	
	/**
	 * 查询债权
	 */
	public void selectDebt(String iframeURL){
		
		jumpIframe(iframeURL);
		base.sleep(2000);
		//点击“查询”按钮
		clickBtnByList("查询");
		base.sleep(3000);
		base.sendKeyAndWait(titleTxt, "...");
		//状态为“未匹配”
		base.elementSelectByVisibleText(statusDropByBond, "未匹配");
		//点击“确定”按钮
		base.clickWithWait(okBtn);
		base.sleep(2000);
	}
	
	/**
	 * 根据标题名，点击所在行
	 * @param loanPurpose：标题
	 * @author 江渤洋 2015-8-6
	 */
	public void clickRowByLoanPurposeTitle(String loanPurpose){
		//获取标题所在行
		By loanPurposeRow = org.openqa.selenium.By.xpath("//td[@title='" + loanPurpose + "']/parent::tr");
		base.sleep(2000);
		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(loanPurposeRow), true);
		base.clickWithWait(By.xpath("//td[@title='" + loanPurpose + "']"));
		//校验是否被选中（aria-selected）属性值
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(loanPurposeRow, "aria-selected", "true"), true);
	}

	/**
	 * 加入到产品
	 * @author 江渤洋 2015-8-5
	 */
	public void joinProduct(String borrowerName, String loanPurpose, String passwordByBack){
		
		//标题行ID
		String loanPurposeTitleID = "";
		//借款人行ID
		String borrowerID = "";
		//Alert提示信息
		String alertString = "";
		//获取借款人所在行的ID
		borrowerID = getBorrowerID(borrowerName);
		base.sleep(2000);
		//根据ID勾选“是否可审”的复选框
		clickBorrowerChk(borrowerID);
		//点击“加入到产品”按钮 
		clickBtnByList("加入到产品");
		base.sleep(2000);
		//输入密码
		base.sendKeyAndWait(passwordTxtByH, passwordByBack);
		base.sleep(2000);
//		do{
//			base.assertEqualsActualExpectedByBoolean(base.isElementPresent(okBtn2), true);
			//点击“确定”按钮
		base.clickWithWait(By.xpath("html/body/div[9]/div[11]/div/button[1]"));
		base.sleep(2000);
//			boolean isShow = base.isElementContainsValue(By.xpath("//div[@aria-labelledby='ui-dialog-title-wmpsRecordDialog']"), "style", "display: block;");
//			if(isShow){
//				break;
//			}
//		}while(true);
		//点击第一行的数据
		clickRowByLoanPurposeTitle(loanPurpose);
		base.sleep(2000);
		//点击“加入到该产品”按钮
		base.clickWithWait(joinTheProductBtnByBond);
		//Alter点击确定
		alertString = base.getTextByAlert();System.out.println("加入到产品弹出提示信息：" + alertString);//---------测试
		base.acceptAlert();
		//Alter点击确定
		alertString = base.getTextByAlert();System.out.println("加入到产品成功弹出提示信息：" + alertString);//---------测试
		base.acceptAlert();
		base.assertEqualsActualExpected(alertString, "操作成功");
		base.sleep(5000);
		
	}
	
	/******************************后台页面-内容栏-理财产品-匹配债权*******************************/
	
	/**
	 * 匹配债权
	 * @author 江渤洋 2015-8-5
	 */
	public void matchingBond(String loanPurpose, String passwordByBack){
		
		//Alert提示信息
		String alertString = "";
		//点击第一行的数据
		clickRowByLoanPurposeTitle(loanPurpose);
		base.sleep(2000);
		//点击“债券匹配”按钮
//		base.clickWithWait(matchingBondBtnByWMP);
		clickBtnByList("匹配债权");
		//输入密码
		base.sendKeyAndWait(passwordTxtByH, passwordByBack);
		//点击“确定”按钮
		base.clickWithWait(okBtn);
		//Alter点击确定
		alertString = base.getTextByAlert();System.out.println("债权匹配弹出提示信息：" + alertString);//---------测试
		base.acceptAlert();
		base.assertEqualsActualExpected(alertString, "操作成功");
	}

	/******************************后台页面-内容栏-待终审借款列表*******************************/
	
	/**
	 * 根据用户名，金额点击数据
	 * @param borrowerName:借款人姓名
	 * @param loanAmount:借款金额
	 */
	public void clickLoanByFinalJudgment(String borrowerName, String loanAmount){
		
		boolean isSelected = false;
		do{
			By loan = By.xpath("//tr/td[@title='" + loanAmount + "']/preceding-sibling::td[@title='" + borrowerName + "']");
			base.clickWithWait(loan);
			By loanRow = By.xpath("//tr/td[@title='" + loanAmount + "']/preceding-sibling::td[@title='" + borrowerName + "']/parent::tr");
			isSelected = base.isElementContainsValue(loanRow, "aria-selected", "true");
//			base.assertEqualsActualExpectedByBoolean(isSelected, true);
		}while(!isSelected);
	}
	
	/**
	 * 获取标状态
	 * @param borrowerName：借款人姓名
	 * @param loanAmount：借款金额
	 */
	public String getTenderState(String borrowerName, String loanAmount){
		By loan = By.xpath("//tr/td[@title='" + loanAmount + "']/preceding-sibling::td[@title='" + borrowerName + "']/parent::tr/td[19]");
		String tenderState = base.getElementTextWithWait(loan);
		return tenderState;
	}
	
	/**
	 * 查找标
	 * @author 江渤洋 2015-8-7
	 */
	public void selectTender(){
//		//省市选择“北京市”
//		base.elementSelectByVisibleText(provinceDrop, "北京市");
//		//地市选择“北京市”
//		base.elementSelectByVisibleText(municipalityDrop, "北京市");
//		//区县选择“东城”
//		base.elementSelectByVisibleText(districtDrop, "东城");
		//标类型“翼企贷标”
		base.elementSelectByVisibleText(loanTypeDrop, "翼企贷标");
		//点击“确定”按钮
		base.clickWithWait(okBtn);
	}
	
	/**
	 * 总部终审
	 * @param borrowerName：借款人姓名
	 * @param loanAmount：借款金额
	 * @param passwordByBack：后台确认密码
	 * @author 江渤洋 2015-8-7
	 */
	public void finalJudgment(String borrowerName, String loanAmount, String passwordByBack){
		
		String currentWindowHandle = "";
		String childWindowHandle = "";
		//Alert提示信息
		String alertString = "";
		
		currentWindowHandle = base.getCurrentWindowHandle();System.out.println("父窗口句柄：" + currentWindowHandle);
		//跳转到“待终审借款列表”页
		jumpIframe(tenderCheckIframe);
		//点击“查找”按钮
		clickBtnByList("查找");
		base.sleep(3000);
		//查找标
		selectTender();
		base.sleep(5000);
		//根据用户名，金额点击数据
		clickLoanByFinalJudgment(borrowerName, loanAmount);
		base.sleep(3000);
		//点击“审核(new)”按钮
		clickBtnByList("审核(new)");
		if(base.Windowsize()>1){
			childWindowHandle = base.getChildWindowHandle(currentWindowHandle);System.out.println("子窗口句柄：" + childWindowHandle);
			base.jumpToWindow(childWindowHandle);
			if(childWindowHandle.equals(currentWindowHandle)){
				base.turnToNewPage();
			}
		}
		//点击“对此标审核通过”或“交易确认通过”
		base.clickWithWait(auditThroughBtnByFinalJudgment);
		//输入密码
		base.sendKeyAndWait(passwordTxtByH, passwordByBack);
		//点击“确定”按钮
		base.clickWithWait(okBtn);
		base.sleep(3000);
		//Alter点击确定
		alertString = base.getTextByAlert();System.out.println("对此标审核通过弹出提示信息1：" + alertString);//---------测试
		base.acceptAlert();
		base.sleep(5000);
		//Alter点击确定
		alertString = base.getTextByAlert();System.out.println("对此标审核通过弹出提示信息2：" + alertString);//---------测试
		base.acceptAlert();
//		base.assertEqualsActualExpected(alertString, "该借贷标最终审核通过！");
		base.sleep(3000);
		alertString = base.getTextByAlert();System.out.println("对此标审核通过弹出提示信息3：" + alertString);//---------测试
		if(alertString.equals("此用户的借贷标已经审核过了,不能再审核了！")){
			base.acceptAlert();
		}
		else{
			base.dismissAlert();
		}
		System.out.println("当前窗口个数：" + base.getCurrentWindowHandles());
//		if(base.Windowsize()>1){
//			base.closeWindow(childWindowHandle);
//			base.jumpToWindow(currentWindowHandle);
//		}
	}
	//根据借款标id进行"终审"
	public void FinalAudit(String tenderid){
		base.checkElementVisible(By.xpath(tenderCheckIframe));
		jumpIframe(tenderCheckIframe);
		base.checkElementVisible(By.id("jqgh_brealname"));//"借款人"文本
		base.clickWithWait(By.id(tenderid));
		base.sleep(3000);
//		clickBtnByList("审核(new)");
		base.clickWithWait(By.xpath("//a[contains(@onclick,'tid="+tenderid+"')]"));//终审
		base.jumpToNewWindow();
		base.openBrowser(base.getCurrentUrl().replace("type=25", "type=1"));
		base.clickWithWait(auditThroughBtnByFinalJudgment);
		base.checkElementVisible(passwordTxtByH);
		base.sendKeysWithWait(passwordTxtByH, Data.passwordByBack);
		base.clickWithWait(okBtn);
		base.checkAlertText("确定对此标最终审核通过吗？");
		base.checkAlertText("该借贷标最终审核通过！");
		base.checkAlertText("查看电子借条并下载?");
	}
	
	/**
	 * 校验审核是否成功
	 * @param borrowerName：借款人姓名
	 * @param loanAmount：借款金额
	 * @author 江渤洋 2015-8-12
	 */
	public void checkTenderState(String borrowerName, String loanAmount){
		
		//点击刷新按钮
		base.clickWithWait(refreshBtnByTendList);
		//获取标状态
		String tenderState = getTenderState(borrowerName, loanAmount);
		//查找借款人的标状态是否为“成功”
		base.assertEqualsActualExpected(tenderState, "成功");
	}
	
	/******************************前台页面-购买翼存宝*******************************/
	
	/**
	 * 购买翼存宝
	 * @param loanAmount：借款金额
	 * @param loanPurpose：借款目的
	 * @return id
	 */
	public String buyECunBao(String loanAmount, String loanPurpose){
		
		String id = "";
		//根据标题购买 (loanPurpose)
		id = eCunBaoPage.getProductIDByECunBaoTitle(loanPurpose);
		//根据产品ID，点击抢投
		eCunBaoPage.clickQiangTouBtn(id);
		base.sleep(5000);
//		//根据产品ID，输入金额
//		eCunBaoPage.inputInvestmentAmountTxt(id, loanAmount);
		eCunBaoPage.clickInvestmentAmountTxt(id);
		base.sleep(3000);
		eCunBaoPage.clickMaxMoney(id);
		base.sleep(5000);
		//点击“同意协议并投资”
		eCunBaoPage.clickAgreeInvestmentBtn(id);
		base.sleep(5000);
		//获取操作失败DIV
		if(eCunBaoPage.getOperationFailureDiv()){
			eCunBaoPage.closeOperationFailureDiv();
			System.out.println("翼存宝投资后，显示操作失败~");
		}
		return id;
	}
	
	/******************************前台页面-交易记录*******************************/
	
	/**
	 * 校验扣除成交服务费
	 * @param loanAmount：借款金额
	 * @author 江渤洋 2015-8-11
	 */
	public void checkServiceCharge(String loanAmount, String borrowerEmail){
		
		String row = "";                 //获取交易流水号
		String serviceCharge = "";       //扣除成交服务费
		String uid = "";                 //用户ID
		String loanAmountToMoney = "";   //格式化后的借款金额
		String tenderId = "";            //标ID
		String publishedDate = "";        //当前标的发布时间的毫秒数
		String realdate = "";            //实际还款时间
		String cdate = "";               //应还款时间
		boolean isConform = false;		 //是否符合
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		loanAmountToMoney = base.stringToMoney(loanAmount);
		//获取交易流水号
		row = base.getElementTextWithWait(By.xpath("//td[text()='" + loanAmountToMoney +"']/parent::tr/td[2]"));System.out.println("交易流水号:" + row);//--------测试
		//扣除成交服务费
		serviceCharge = base.getElementTextWithWait(By.xpath("//td[text()='" + row + "']/following-sibling::td[text()='扣除成交服务费']/parent::tr/td[4]"));System.out.println("扣除成交服务费:" + serviceCharge);//--------测试
		//获取用户ID
		uid = dbData.getUID(borrowerEmail);
		//获取6期、已还清的翼企贷标
		hashMap = dbData.getD_TenderTable(uid);
		if(!hashMap.isEmpty()){
			tenderId = hashMap.get("tenderId");
			publishedDate = hashMap.get("publisheddate");
			if(dbData.isEmptyByDetailsTable(tenderId)){
				hashMap = dbData.getD_Tender_Repayment_DetailTable(tenderId);
				realdate = hashMap.get("realdate");
				cdate = hashMap.get("cdate");
				
				if(
						(Double.valueOf(realdate) - Double.valueOf(cdate) <= 40 * 24 * 3600) && (Double.valueOf(publishedDate) - Double.valueOf(realdate) <= 90 * 24 * 3600)
						){
					isConform = true;
				}
			}
		}
		
		if(isConform){
			System.out.println("扣除成交服务费：0.0325%" );
			assertServiceCharge(loanAmount, serviceCharge, 0.0325);
		}
		else{
			System.out.println("扣除成交服务费：0.055%" );
			assertServiceCharge(loanAmount, serviceCharge, 0.055);
		}
	}
	
	/**
	 * 检查扣除成交服务费
	 * @param loanAmount
	 * @param serviceCharge
	 * @param num
	 */
	public void assertServiceCharge(String loanAmount, String serviceCharge, double num){
		
		double tempDouble = Double.valueOf(loanAmount) * num;
		long tempLong;
		if(tempDouble % 1.0 == 0){
			tempLong = (long)tempDouble;
			base.assertEqualsActualExpected(Long.toString(tempLong), serviceCharge);
		}
		else{
			base.assertEqualsActualExpected(new DecimalFormat("#.00").format(tempDouble), serviceCharge);
		}
	}
	
	/**
	 * 将标状态改为“逾期还款”
	 * @param borrowerEmail：借款人邮箱
	 * @param overdueDay:逾期天数
	 */
	public void updateRealDate(String borrowerEmail, String overdueDay){
		
		String tenderId = "";            //标ID
		String uid = "";                 //用户ID
		boolean isTrue = false;
		
		//获取用户ID
		uid = dbData.getUID(borrowerEmail);
		//获取最新的标ID
		tenderId = dbData.getTenderId(uid);System.out.println("标ID：" + tenderId);//------------测试
		//将标状态改为“逾期还款”
		isTrue = dbData.updateRealDate(tenderId, overdueDay);
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
	}
	
	/**
	 * 修改优惠状态，改为1，即不优惠
	 * @param borrowerEmail：借款人邮箱
	 * @author 江渤洋 2015-8-19
	 */
	public void updatePreferentialState(String borrowerEmail){
		
		String tenderId = "";            //标ID
		String uid = "";                 //用户ID
		boolean isTrue = false;
		
		//获取用户ID
		uid = dbData.getUID(borrowerEmail);
		//获取最新的标ID
		tenderId = dbData.getTenderId(uid);System.out.println("标ID：" + tenderId);//------------测试
		//修改优惠状态
		isTrue = dbData.updatePreferentialState(tenderId);
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
	}
	
	/**
	 * 修改“发布日期”
	 * @param borrowerEmail：借款人邮箱
	 * @param amount：借款金额
	 * @param publishedDate:标的发布日期增加相应天数
	 * @author 江渤洋 
	 */
	public void updatePublishedDate(String borrowerEmail, String amount, String publishedDate){
		
		String oldTenderId = "";            //标ID
		String newTenderId = "";            //标ID
		String uid = "";                 	//用户ID
		boolean isTrue = false;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		//获取用户ID
		uid = dbData.getUID(borrowerEmail);
		//查找当前标的ID
		newTenderId = dbData.getTenderId(uid, amount);
		System.out.println("当前标ID: " + newTenderId);
		//查找上次还款标的ID
		hashMap = dbData.getD_TenderTable(uid);
		if(!hashMap.isEmpty()){
			oldTenderId = hashMap.get("tenderId");
			System.out.println("上次还款标ID: " + oldTenderId);
			isTrue = dbData.updatePublishedDate(oldTenderId, newTenderId, publishedDate);
			base.assertEqualsActualExpectedByBoolean(isTrue, true);
		}
		else{
			System.out.println("error_没有上次借款的标");
		}
	}
	
}



















