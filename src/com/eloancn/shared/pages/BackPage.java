package com.eloancn.shared.pages;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
/**
 * 后台
 * @author 徐天元
 */
public class BackPage {
	Base base = new Base();
	Data data = new Data();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/****************预上线环境获取手机验证码****************/
	/**
	 * 徐天元
	 * 获取手机验证码
	 * type: SMS,短信  ； email,邮箱
	 */
	public String getCode(String value,String type){
		base.openBrowser("http://back.eloancn.com/admin/loadAllCacheMsg.action?destination="+value);
		String code = "";
		try {
			if (type.equals("SMS")) {
				code = getSMSCode();
			}else {
				code = getEmailCode();
			}
		} catch (Exception e) {
			finishNoticeCode();
			//登录   
			int i = 0;
			do {
				i++;
				backLogin();
				base.sleep(3000);
			} while (base.isElementPresentNoWait(By.cssSelector("#errtip")) && base.getElementTextWithWait(By.cssSelector("#errtip"),3).contains("验证码输入错误！") && i<3);
			
//			//if (base.isElementPresentNoWaite(By.cssSelector("#errtip"))) {
//			if (!base.isDisplayed(By.cssSelector(".tip_box"),5)) {
//				if (base.getElementTextWithWait(By.cssSelector("#errtip")).contains("验证码输入错误！")) {
//					backLogin();       
//				}
//			}
			//base.clickWithWait(By.cssSelector("#time>font"));
			base.openBrowser("http://back.eloancn.com/admin/loadAllCacheMsg.action?destination="+value);
			if (type.equals("SMS")) {
				code = getSMSCode();
			}else {
				code = getEmailCode();
			}
		}
		System.out.println(code);
		return code;
	}
	
	/**
	 * 徐天元
	 * 获取短信验证码
	 */
	public String getSMSCode(){
		String json = base.getElementTextWithWait(By.cssSelector("html>body>pre"),3);
		System.out.println(json);
		String code = json.substring(json.indexOf("本次验证码是：")+7,json.indexOf("本次验证码是：")+13);
		return code;
	}
	
	/**
	 * 徐天元
	 * 获取邮箱验证码
	 * {"pageInfo":{"data":[{"cdate":1447294664,"content":"您通过邮箱：111110@qq.com绑定或重置邮箱，本次验证码为：<font color=\"red\">imanTDwkmgvXtjiDhaNl<\/font><br><br>为了确保您的帐号安全，该验证码仅<font color=\"red\">30分钟内<\/font>有效。<br><br>您在翼龙贷网络借贷平台可以享受到以下服务：<br><br>1、如果您正在寻找资金，可以向众多的网络投资者发布消息，方便快捷的借到所需资金。<br><br>2、如果您在找理财投资渠道，请把资金借给正在需要的人，稳定的回收本金和利息，创新高效安全的理财投资模式，期望收益高于银行定期利息。<br><br>希望您在翼龙贷网络借贷平台上得到更多人的帮助，也希望您能在翼龙贷网络借贷平台上帮助更多的人，并从中获得乐趣！ <br><br>","destination":"823993640@qq.com","id":14824411,"returnCode":null,"status":1,"strCdate":"2015-11-12 10:17:44","strContent":"验证码: imanTDwkmgvXtjiDhaNl","strType":"其他","title":"翼龙贷网络借贷平台用户绑定邮箱重置","type":3}],"page":1,"records":1,"rows":10,"sidx":null,"sord":null,"total":1},"tip":null}
	 */
	public String getEmailCode(){
		String json = base.getElementTextWithWait(By.cssSelector("html>body>pre"),3);
		System.out.println(json);
		//int startIndex = json.indexOf("本次验证码为：<font color=\"red\">")+25;
		int startIndex = json.indexOf("\"验证码: ")+6;
		String emailCode = json.substring(startIndex,startIndex+20);
		return emailCode;
	}
	
	
	/**
	 * 徐天元
	 * 完成通知码
	 */
	public void finishNoticeCode(){
		base.openBrowser("http://back.eloancn.com/wpf/admin/FAA98AAE051128843322EB05CFFFD49E.action");
		//通知码
		base.sendKeysWithWait(By.id("noticeCode"), "52eloan5055");//4000292886
		base.clickWithWait(By.id("subm"));
		//base.sleep(2000);
	}
	
	/**
	 * 徐天元
	 * 登录
	 */
	public void backLogin(){
		base.sendKeysWithWait(By.id("uname"), "testjmst");
		base.sendKeysWithWait(By.id("upwd"), "111111");
		String imgCode = data.get(base.getElementWithWait(By.cssSelector(".yzm>img")), base.getWebDriver());
		base.sendKeysWithWait(By.id("rand"), imgCode);
		base.clickWithWait(By.id("subm"));
	}
}
