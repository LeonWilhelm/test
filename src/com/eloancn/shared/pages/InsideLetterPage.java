package com.eloancn.shared.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;

/**
 * 站内信页面
 * @author 江渤洋
 */
public class InsideLetterPage {

	
	Base base = new Base();
	DBData dbData = new DBData();
	
	/****************************     导 航 栏           ******************************/
	By insideLetter = By.cssSelector("#accountMessage");                                            //站内信
	
	
	/*********************系统消息********************/
	
	By sysMsgTab = By.id("sysinbox");	//系统消息Tab
	By envelopeIconBySysMsg = By.cssSelector("tbody > .c_im_bg_color_0:nth-child(1) > td:nth-child(2) > img"); //第一个信封图标

	String sysMsgIframe = "myhome_app";// 系统消息iframe
	
	By insideLetterSenderInDetailedPage = By.cssSelector(".username2>p");   //站内信详情页-发件人
	By insideLetterTitleInDetailedPage = By.cssSelector(".subject_wrap2");  //站内信详情页-标题
	By insideLetterTimeInDetailedPage = By.cssSelector(".date");		    //站内信详情页-时间
	By insideLetterContentInDetailedPage = By.cssSelector(".astyle");       //站内信详情页-内容
	
	
	/*****************公共*******************/
		
	/**
	 * 格式化邮件的“收件时间”
	 * @param time 收件时间
	 * @return 收件时间
	 * @author 江渤洋 2015-10-21
	 */
	public long formatCdate(String time){
		
		return base.getMilliseconds(time, "yyyy-MM-dd HH:mm:ss") / 1000;
	}
	
	/**
	 * 格式化邮件的“内容”
	 * @param content 邮件内容
	 * @return 邮件内容
	 * @author 江渤洋 2015-10-21
	 */
	public String formantContent(String content){
		
		int length = content.length();
		if(length > 30){
			content = content.substring(0, 30) + "……";
		}
		return content;
	}
	
	/**
	 * 校验站内信是否读过(通过站内信ID获取站内信)
	 * @param insideLetterID 站内信ID
	 * @param isRead 是否读取过 (true: 读取过，false: 未读过)
	 * @author 江渤洋 2015-10-21
	 */
	public void checkMailIsReadByInsideLetterID(String insideLetterID, boolean isRead){
		
		By iconBy = getInsideLetterIconBy(insideLetterID);
		checkMailIsRead(iconBy, isRead);
	}
	
	/**
	 * 校验站内信是否读过
	 * @param icon 邮件图标对象
	 * @param isRead 是否读取过 (true: 读取过，false: 未读过)
	 * @author 江渤洋 2015-10-20
	 */
	public void checkMailIsRead(By icon, boolean isRead){
		
		String iconStr = getInsideLetterIconName(icon);
		if(isRead){
			try {
				base.assertEqualsActualExpected(iconStr, "mailboxread");
			} catch (AssertionError error) {
				Reporter.log("error_已读取的站内信，状态为未读取");
				System.out.println("error_已读取的站内信，状态为未读取");
			}
		}
		else{
			try {
				base.assertEqualsActualExpected(iconStr, "mailboxnoread");
			} catch (AssertionError error) {
				Reporter.log("error_未读取的站内信，状态为已读取");
				System.out.println("error_未读取的站内信，状态为已读取");
			}
		}
	}
	
	
	/*****************公共-列表页*******************/

	
	/**
	 * 列表页，获取站内信邮件图标的图片对象
	 * @param insideLetterID 站内信ID
	 * @return 图片对象
	 * @author 江渤洋 2015-10-20
	 */
	public By getInsideLetterIconBy(String insideLetterID){
		
		By by = By.xpath("//a[contains(@href,'" + insideLetterID + "')]/ancestor::tr//td[2]/img");
		base.checkElement(by);
		return by;
	}
	
	/**
	 * 列表页，获取站内信的发件人姓名
	 * @param insideLetterID 站内信ID
	 * @return 发件人姓名对象
	 * @author 江渤洋 2015-10-21
	 */
	public By getInsideLetterSenderByInListPage(String insideLetterID){
		
		By by = By.xpath("//a[contains(@href,'" + insideLetterID + "')]/ancestor::tr//td[4]/span");
		base.checkElement(by);
		return by;
	}
	
	/**
	 * 列表页，获取站内信的标题对象
	 * @param insideLetterID 站内信ID
	 * @return 标题对象
	 * @author 江渤洋 2015-10-20
	 */
	public By getInsideLetterTitleByInListPage(String insideLetterID){
		
		By by = By.xpath("//a[contains(@href,'" + insideLetterID + "')]");
		base.checkElement(by);
		return by;
	}
	
	/**
	 * 列表页，获取站内信的内容对象
	 * @param insideLetterID 站内信ID
	 * @return 内容对象
	 * @author 江渤洋 2015-10-20
	 */
	public By getInsideLetterContentByInListPage(String insideLetterID){
		
		By by = By.xpath("//a[contains(@href,'" + insideLetterID + "')]/following-sibling::div/a");
		base.checkElement(by);
		return by;
	}
	
	/**
	 * 列表页，获取站内信的时间对象
	 * @param insideLetterID 站内信ID
	 * @return 时间对象
	 * @author 江渤洋 2015-10-20
	 */
	public By getInsideLetterTimeByInListPage(String insideLetterID){
		
		By by = By.xpath("//a[contains(@href,'" + insideLetterID + "')]/ancestor::tr//span[@class='date']");
		base.checkElement(by);
		return by;
	}
	
	/**
	 * 列表页，获取站内信邮件图标的图片名称
	 * @param icon 邮件图标对象
	 * @return 图片名称
	 * @author 江渤洋 2015-10-16
	 */
	public String getInsideLetterIconName(By icon){
		
		base.checkElement(icon);
		String src = base.getAttribute(icon, "src");
		if(src.contains("mailboxread")){
			src = "mailboxread";
		}
		else{
			src = "mailboxnoread";
		}
		return src;
	}
	
	/**
	 * 列表页，获取站内信中的标题
	 * @param title 标题对象
	 * @return 站内信标题
	 * @author 江渤洋 2015-10-16
	 */
	public String getInsideLetterTitleInListPage(By title){
		
		return base.getElementTextWithWait(title);
	}
	
	/**
	 * 列表页，点击站内信中的标题(通过站内信ID获取标题)
	 * @param insideLetterID 站内信ID
	 * @author 江渤洋 2015-10-21
	 */
	public void clickInsideLetterTitleByIDInListPage(String insideLetterID){
		
		By titleBy = getInsideLetterTitleByInListPage(insideLetterID);
		clickInsideLetterTitleInListPage(titleBy);
	}
	
	/**
	 * 列表页，点击站内信中的标题
	 * @param title 标题对象
	 * @author 江渤洋 2015-10-20
	 */
	public void clickInsideLetterTitleInListPage(By title){
		
		base.clickWithWait(title);
		base.checkTitle("站内信");
	}
	
	/**
	 * 列表页，校验站内信的“发件人”、“标题”、“内容”、“收件时间”
	 * @param insideLetterID 站内信ID
	 * @author 江渤洋 2015-10-20
	 */
	public void checkInsideLetterInvestmentInListPage(String insideLetterID){
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap = dbData.getInsideLetterInfo(insideLetterID);
		
		String senderStr = base.getElementTextWithWait(getInsideLetterSenderByInListPage(insideLetterID));
		String titleStr = base.getElementTextWithWait(getInsideLetterTitleByInListPage(insideLetterID));
		String contentStr = base.getElementTextWithWait(getInsideLetterContentByInListPage(insideLetterID));
		String timeStr = base.getElementTextWithWait(getInsideLetterTimeByInListPage(insideLetterID));
		
		base.assertEqualsActualExpected(senderStr, "翼龙贷");
		base.assertEqualsActualExpected(titleStr, hashMap.get("title"));
		base.assertEqualsActualExpected(contentStr, formantContent(hashMap.get("content")));
		base.assertEqualsActualExpectedByLong(formatCdate(timeStr), Long.parseLong(hashMap.get("cdate")));
	}
	

	/*****************公共-详情页*******************/
	

	/**
	 * 详情页，校验站内信的“发件人”、“标题”、“内容”、“收件时间”
	 * @param insideLetterID 站内信ID
	 * @author 江渤洋 2015-10-20
	 */
	public void checkInsideLetterInvestmentInDetailsPage(String insideLetterID){
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap = dbData.getInsideLetterInfo(insideLetterID);
		
		String senderStr = base.getElementTextWithWait(insideLetterSenderInDetailedPage);
		String titleStr = base.getElementTextWithWait(insideLetterTitleInDetailedPage);
		String contentStr = base.getElementTextWithWait(insideLetterContentInDetailedPage);
		String timeStr = base.getElementTextWithWait(insideLetterTimeInDetailedPage);
		
		base.assertEqualsActualExpected(senderStr, "翼龙贷");
		base.assertEqualsActualExpected(titleStr, hashMap.get("title"));
		base.assertEqualsActualExpected(contentStr, hashMap.get("content"));
		base.assertEqualsActualExpectedByLong(formatCdate(timeStr), Long.parseLong(hashMap.get("cdate")));
	}

	
	/*****************公共-其他*******************/
	
	
	/**
	 * 首页获取未读站内信个数
	 * @return 未读站内信个数
	 * @author 江渤洋 2015-10-16
	 */
	public String getInsideLetterNum(){
		
		String insideLetterNum = base.getElementTextWithWait(insideLetter);
		insideLetterNum = insideLetterNum.substring(1, insideLetterNum.length()-1);
		return insideLetterNum;
	}
	
	/**
	 * 校验未读取站内信的个数
	 * @param email 用户邮箱
	 * @author 江渤洋 2015-10-16
	 */
	public void checkInsideLetterNum(String email){
		
		try {
			base.assertEqualsActualExpected(getInsideLetterNum(), dbData.getInsideLetterNum(dbData.getUID(email), "未读"));
		} catch (AssertionError e) {
			Reporter.log("未读取的站内信个数与数据库中不一致。");
			System.out.println("未读取的站内信个数与数据库中不一致。");
		}
	}
	
	/**
	 * 点击“站内信”
	 * @author 江渤洋 2015-10-15
	 */
	public void clickInsideLetter(){
		
		base.fromFrameToDefaultContent();
		base.clickWithWait(insideLetter);
		base.checkTitle("站内信");
		checkSysMsgTab();
		base.switchToFrame("myhome_app");
	}
	
	/**
	 * 验证“系统消息”是否选中
	 * @author 江渤洋 2015-10-15
	 */
	public void checkSysMsgTab(){
		
		base.isElementContainsValue(sysMsgTab, "class", "current");
	}
	
	/**
	 * 校验站内信状态是否更新成功
	 * @param insideLetterID 站内信ID
	 * @param status 站内信状态：1为未读，2为已读
	 * @author 江渤洋 2015-10-20
	 */
	public void checkUpdateReceiverStatus(String insideLetterID, String status){
		
		base.assertEqualsActualExpectedByBoolean(dbData.updateReceiverStatus(insideLetterID, status), true);
		base.refreshPage();
		base.switchToFrame("myhome_app");
	}

	/**
	 * 获取体验期翼存宝的相关信息
	 * 备注：由于体验期翼存宝必须是新用户，所以数据库中查询的翼存宝是唯一的
	 * @param email 用户邮箱
	 * @return 翼存宝的相关信息（包括：加入金额，年化收益率，合约期限，计息时间，到期时间）
	 * @author 江渤洋 2015-10-23
	 */
	public HashMap<String, String> getExperienceECunBaoInfo(String email){
		
		HashMap<String, String> map = new HashMap<String, String>();
		String uid = dbData.getUID(email);
		map = dbData.getD_wmps_recordTable(uid);
		try {
			base.assertEqualsActualExpectedByBoolean(map.isEmpty(), false);
		} catch (Exception e) {
			Reporter.log("数据库没有购买体验期翼存宝的信息");
			System.out.println("");
		}
		return map;
	}
}
