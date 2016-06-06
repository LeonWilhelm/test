package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;

/**
 * 投资列表详情页
 */
public class InvestmentDetailPage {
	
	Base base = new Base();
	
	/*************************/
	/******   借款标进度       *******/
	/*************************/
	
	public static By StatusBar = By.cssSelector("div.wrap>div.ld_leftpart>div.ld_status");		//最上层的状态条
	public static By BidFullTime = By.xpath("//p[2]/span[2]");									//“标满”的时间
	
	/*************************/
	/******   借款标信息       *******/
	/*************************/
	
	public static By BorrowType = By.cssSelector("h2.mt10");									//借款类型及目的（借款标题）
	public static By UserName = By.cssSelector("div.ld_user.fl>p>a");							//图片下的用户名
	By ReportLnk = By.cssSelector("li.alert>a");												//"举报此人"链接
	By JoinBlacklistLnk = By.cssSelector("li.blankList>a");										//"加入黑名单"链接
	
	//举报窗口
	By ReportTitle = By.xpath("//div[@id='out_all2']/div/div/span");							//“举报”标题
	By OKReportBtn = By.xpath("//form[@id='reportForm']/div[3]/button");						//确定举报
	By CancelReportBtn = By.xpath("//form[@id='reportForm']/div[3]/button[2]");					//取消举报	
	By SelectReportType = By.id("reportType");													//“举报类型”下拉框
	By InputDescription = By.id("description");													//描述信息 
	
	//“加入黑名单”窗口
	By JoinBlacklistTitle = By.xpath("//div[@id='out_all']/div/div/span");						//“加入黑名单”标题
	By CancelJoinBlacklistBtn = By.xpath("//form[@id='blackForm']/div[3]/button[2]");			//取消介入黑名单
	By OKJoinBlacklistBtn = By.xpath("//form[@id='blackForm']/div[3]/button");					//确定加入黑名单
	By InputSetReason = By.id("blackreason");													//在“请填写设置理由”中输入
	
	//借钱给他
	By InvestLnk = By.cssSelector("input.ld_btn.mt25.fl");//“借钱给他”
	By InvestWindow = By.id("fastLender_1");
	By AutoInputLnk = By.cssSelector("a.ml10");
	By InputPayPwd = By.id("paypassowrd");
	By yanZhengMaImg = By.cssSelector("#checkverificationCode_fast>a>img");
	By InputValidateCode = By.id("tenderRecordRandCode");
	By OKBtn = By.cssSelector("input.f_m_Confirm.ml20");
	By CloseInvestResultLnk = By.cssSelector("div.newFMBox-tit>a.close");//关闭投资成功或投资失败的窗口
	By InvestSuccessTip = By.id("tenderOK");
	By InvestFailTip = By.id("errorMsg");
	
	/*************************/
	/********   Tab  *********/
	/*************************/
	
	/*************************/
	/*******   基本信息     ********/
	/*************************/
	
	public static By BorrowDescription = By.id("borrowdetail");									//借款描述
	
	/*************************/
	/*******   个人资料     ********/
	/*************************/
	
	/*************************/
	/*******   担保增额     ********/
	/*************************/
	
	/*************************/
	/*******   历史统计     ********/
	/*************************/
	
	/*************************/
	/*******   材料信息     ********/
	/*************************/
	
	By materialImgNum = By.cssSelector(".imgListNum");								//材料信息_图片显示数字(共3个)
	By materialImg = By.cssSelector(".imgList>a>img");								//材料信息_图片(共3个)
	By materialBtn = By.cssSelector(".materialsBtn");								//材料信息_图片按钮(共3个)
	By materialPictureDIV = By.cssSelector(".ui-dialog.ui-widget"
			+ ".ui-widget-content.ui-corner-all.ui-draggable.ui-resizable");		//材料信息_图片详情框
	By materialPictureTitle = By.cssSelector("#ui-dialog-title-showPubDataDiv");	//材料信息_图片详情框_Title
	By materialPictureClose = By.cssSelector(".ui-icon.ui-icon-closethick");		//材料信息_图片详情框_右上角X按钮
	By materialPictureCloseBtn = By.cssSelector(".ui-button.ui-widget"
			+ ".ui-state-default.ui-corner-all.ui-button-text-only.ui-state-hover");//材料信息_图片详情框_关闭按钮		

	/*************************/
	/*******   咨询记录     ********/
	/*************************/
	
	//点击“举报此人”链接
	public void clickReportLnk(){
		base.clickWithWait(ReportLnk);
		base.checkElmentText(ReportTitle, "举报");
	}
	//在“举报”窗口点击“取消”举报
	public void clickCancelReportBtn(){
		base.clickWithWait(CancelReportBtn);
		base.checkNoElement(ReportTitle);
	}
	//在“举报”窗口选择“举报类型”
	public String selectReportType(String type){
		base.elementSelectByVisibleText(SelectReportType, type);
		return type;
	}
	//在“举报”窗口选择“描述信息”
	public String inputDescription(){
		base.sendKeysWithWait(InputDescription, "投资此人标请慎重");
		return "投资此人标请慎重";
	}
	//在“举报”窗口点击“确定”举报
	public String clickOKReportBtn(){
		base.clickWithWait(OKReportBtn);
		base.getAlertwithWait();
		if(base.getTextByAlert().equals("此人已经被您举报过了，请手下留情吧！")){
			base.acceptAlert();
			System.out.println("此人已经被您举报过了!");
			Reporter.log("此人已经被您举报过了!");
			return null;
		}else{
			base.checkAlertText("添加成功！");
			return base.dateFormat(base.getTime(), "yyyy-MM-dd");
		}
	}
	
	//点击“加入黑名单”链接
	public void clickJoinBlacklistLnk(){
		base.clickWithWait(JoinBlacklistLnk);
		base.checkElmentText(JoinBlacklistTitle, "加入黑名单");
	}
	//在“加入黑名单”窗口点击“取消”举报
	public void clickCancelJoinBlacklistBtn(){
		base.clickWithWait(CancelJoinBlacklistBtn);
		base.checkNoElement(JoinBlacklistTitle);
	}
	//在“加入黑名单”窗口输入“设置理由 ”
	public String InputSetReason(){
		base.sendKeysWithWait(InputSetReason, "该用户还款信用不好");
		return "该用户还款信用不好";
	}
	//在“加入黑名单”窗口点击“确定”加入黑名单
	public String clickOkJoinBlacklistBtn(boolean acceptNextAlert){
		base.clickWithWait(OKJoinBlacklistBtn);
		base.assertEqualsActualExpected(base.getAlertwithWait().getText(), "您确定要将该用户添加到您的黑名单中吗?");
		if(acceptNextAlert){
			base.acceptAlert();
			base.getAlertwithWait();
			if(base.getTextByAlert().equals("很抱歉，该用户已经在您的黑名单里了！")){
				base.acceptAlert();
				base.openBrowser(new MyAccountPage().MyAccountUrl);
				System.out.println("该用户已经在您的黑名单里了！");
				Reporter.log("<br/>该用户已经在您的黑名单里了！");
				return null;
			}else{
				base.checkAlertText("借入者添加到您的黑名单成功！");
				return base.dateFormat(base.getTime(), "yyyy-MM-dd");
			}
		}else{
			base.dismissAlert();
			base.checkElementVisible(JoinBlacklistTitle);
			return null;
		}
	}
	
	public void clickInvestLnk(){
		if(base.isElementPresent(InvestLnk)){
			base.clickWithWait(InvestLnk);
			base.checkElementVisible(InvestWindow);
		}else{
			System.out.println("已投满！");
		}
	}
	
	public void clickAutoInputLnk(){
		base.clickWithWait(AutoInputLnk);
	}
	public void InputPayPwd(String paypwd){
		base.sendKeysWithWait(InputPayPwd, paypwd);
	}
	public void InputValidateCode(){
		String ValidateCode = new Data().get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
		base.elementSendkey(InputValidateCode, ValidateCode);
//		if(base.browserType.toLowerCase().equals("ie") && !base.indexURL.contains("inclient")){
//			base.getAlertwithWait().accept();
//		}		
	}
	public void clickOKBtn(){
		base.clickWithWait(OKBtn);
		base.checkNoElement(OKBtn);
	}
	public void clickCloseInvestResultLnk(){
		base.clickWithWait(CloseInvestResultLnk);
		base.checkNoElement(CloseInvestResultLnk);
	}

	public void checkInvestSuccess(){
		if(base.getLnkElementText(InvestSuccessTip, "class").contains("hide")){
			String ErrorTxt = base.getElementText(InvestFailTip);
			clickCloseInvestResultLnk();
			base.closeWebDriver();
			Assert.fail("输入错误! "+ErrorTxt);
		}else{
			base.assertEqualsActualExpected(base.getElementTextWithWait(InvestSuccessTip), "投标成功");
			clickCloseInvestResultLnk();
			base.closeWebDriver();
		}
	}
	
	/*************************/
	/********   Tab  *********/
	/*************************/
	
	/**
	 * 获取页面Tab(基本信息、个人资料、担保/增额、历史统计、材料信息)
	 * @param name Tab名称
	 * @return tab对象
	 * @author 江渤洋 2016-2-3
	 */
	public By getTab(String name){
		String num = "";
		switch (name) {
		case "基本信息":	num = "1";		break;
		case "个人资料":	num = "2";		break;
		case "担保/增额":	num = "3";		break;
		case "历史统计":	num = "4";		break;
		case "材料信息":	num = "5";		break;
		default:		num = "1";		break;
		}
		return By.cssSelector(".records.bgFF.pdt10.mt20 > span:nth-child(" + num + ")");
	}
	
	public void checkClickedTab(String name){
		String num = "";
		By by;
		switch (name) {
		case "基本信息":	num = "1";		break;
		case "个人资料":	num = "2";		break;
		case "担保/增额":	num = "3";		break;
		case "历史统计":	num = "4";		break;
		case "材料信息":	num = "5";		break;
		default:		num = "1";		break;
		}
		if(name.equals("基本信息")){
			by = By.cssSelector(".records.bgFF.pdt10.mt20 > span:nth-child(" + num + ")");
		}
		else{
			by = By.cssSelector(".records.bgFF.pdt10.fixed > span:nth-child(" + num + ")");
		}
		base.isElementContainsValue2(by, "class", "current");
	}
	
	/**
	 * 点击页面Tab
	 * @param name Tab名称
	 * @author 江渤洋 2016-2-3
	 */
	public void clickTab(String name){
		By by = getTab(name);
		base.clickWithWait(by);
		checkClickedTab(name);
	}
	
	/*************************/
	/*******   材料信息     ********/
	/*************************/
	
	/**
	 * 校验材料信息图片个数是否小于等于1
	 */
	public void checkMaterialImgNum(){
		List<WebElement> webList = base.getVisibleElements(materialImgNum);
		int num;
		for(int i = 0; i < webList.size(); i++){
			num = Integer.valueOf(webList.get(i).getText());
			Base.assertEquals(num <= 1?true:false, true);
		}
	}
}
