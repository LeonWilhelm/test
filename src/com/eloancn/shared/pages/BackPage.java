package com.eloancn.shared.pages;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
/**
 * ��̨
 * @author ����Ԫ
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
	
	/****************Ԥ���߻�����ȡ�ֻ���֤��****************/
	/**
	 * ����Ԫ
	 * ��ȡ�ֻ���֤��
	 * type: SMS,����  �� email,����
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
			//��¼   
			int i = 0;
			do {
				i++;
				backLogin();
				base.sleep(3000);
			} while (base.isElementPresentNoWait(By.cssSelector("#errtip")) && base.getElementTextWithWait(By.cssSelector("#errtip"),3).contains("��֤���������") && i<3);
			
//			//if (base.isElementPresentNoWaite(By.cssSelector("#errtip"))) {
//			if (!base.isDisplayed(By.cssSelector(".tip_box"),5)) {
//				if (base.getElementTextWithWait(By.cssSelector("#errtip")).contains("��֤���������")) {
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
	 * ����Ԫ
	 * ��ȡ������֤��
	 */
	public String getSMSCode(){
		String json = base.getElementTextWithWait(By.cssSelector("html>body>pre"),3);
		System.out.println(json);
		String code = json.substring(json.indexOf("������֤���ǣ�")+7,json.indexOf("������֤���ǣ�")+13);
		return code;
	}
	
	/**
	 * ����Ԫ
	 * ��ȡ������֤��
	 * {"pageInfo":{"data":[{"cdate":1447294664,"content":"��ͨ�����䣺111110@qq.com�󶨻��������䣬������֤��Ϊ��<font color=\"red\">imanTDwkmgvXtjiDhaNl<\/font><br><br>Ϊ��ȷ�������ʺŰ�ȫ������֤���<font color=\"red\">30������<\/font>��Ч��<br><br>����������������ƽ̨�������ܵ����·���<br><br>1�����������Ѱ���ʽ𣬿������ڶ������Ͷ���߷�����Ϣ�������ݵĽ赽�����ʽ�<br><br>2��������������Ͷ������������ʽ���������Ҫ���ˣ��ȶ��Ļ��ձ������Ϣ�����¸�Ч��ȫ�����Ͷ��ģʽ����������������ж�����Ϣ��<br><br>ϣ������������������ƽ̨�ϵõ������˵İ�����Ҳϣ��������������������ƽ̨�ϰ���������ˣ������л����Ȥ�� <br><br>","destination":"823993640@qq.com","id":14824411,"returnCode":null,"status":1,"strCdate":"2015-11-12 10:17:44","strContent":"��֤��: imanTDwkmgvXtjiDhaNl","strType":"����","title":"������������ƽ̨�û�����������","type":3}],"page":1,"records":1,"rows":10,"sidx":null,"sord":null,"total":1},"tip":null}
	 */
	public String getEmailCode(){
		String json = base.getElementTextWithWait(By.cssSelector("html>body>pre"),3);
		System.out.println(json);
		//int startIndex = json.indexOf("������֤��Ϊ��<font color=\"red\">")+25;
		int startIndex = json.indexOf("\"��֤��: ")+6;
		String emailCode = json.substring(startIndex,startIndex+20);
		return emailCode;
	}
	
	
	/**
	 * ����Ԫ
	 * ���֪ͨ��
	 */
	public void finishNoticeCode(){
		base.openBrowser("http://back.eloancn.com/wpf/admin/FAA98AAE051128843322EB05CFFFD49E.action");
		//֪ͨ��
		base.sendKeysWithWait(By.id("noticeCode"), "52eloan5055");//4000292886
		base.clickWithWait(By.id("subm"));
		//base.sleep(2000);
	}
	
	/**
	 * ����Ԫ
	 * ��¼
	 */
	public void backLogin(){
		base.sendKeysWithWait(By.id("uname"), "testjmst");
		base.sendKeysWithWait(By.id("upwd"), "111111");
		String imgCode = data.get(base.getElementWithWait(By.cssSelector(".yzm>img")), base.getWebDriver());
		base.sendKeysWithWait(By.id("rand"), imgCode);
		base.clickWithWait(By.id("subm"));
	}
}
