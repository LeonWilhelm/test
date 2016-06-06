package com.eloancn.shared.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;

/**
 * վ����ҳ��
 * @author ������
 */
public class InsideLetterPage {

	
	Base base = new Base();
	DBData dbData = new DBData();
	
	/****************************     �� �� ��           ******************************/
	By insideLetter = By.cssSelector("#accountMessage");                                            //վ����
	
	
	/*********************ϵͳ��Ϣ********************/
	
	By sysMsgTab = By.id("sysinbox");	//ϵͳ��ϢTab
	By envelopeIconBySysMsg = By.cssSelector("tbody > .c_im_bg_color_0:nth-child(1) > td:nth-child(2) > img"); //��һ���ŷ�ͼ��

	String sysMsgIframe = "myhome_app";// ϵͳ��Ϣiframe
	
	By insideLetterSenderInDetailedPage = By.cssSelector(".username2>p");   //վ��������ҳ-������
	By insideLetterTitleInDetailedPage = By.cssSelector(".subject_wrap2");  //վ��������ҳ-����
	By insideLetterTimeInDetailedPage = By.cssSelector(".date");		    //վ��������ҳ-ʱ��
	By insideLetterContentInDetailedPage = By.cssSelector(".astyle");       //վ��������ҳ-����
	
	
	/*****************����*******************/
		
	/**
	 * ��ʽ���ʼ��ġ��ռ�ʱ�䡱
	 * @param time �ռ�ʱ��
	 * @return �ռ�ʱ��
	 * @author ������ 2015-10-21
	 */
	public long formatCdate(String time){
		
		return base.getMilliseconds(time, "yyyy-MM-dd HH:mm:ss") / 1000;
	}
	
	/**
	 * ��ʽ���ʼ��ġ����ݡ�
	 * @param content �ʼ�����
	 * @return �ʼ�����
	 * @author ������ 2015-10-21
	 */
	public String formantContent(String content){
		
		int length = content.length();
		if(length > 30){
			content = content.substring(0, 30) + "����";
		}
		return content;
	}
	
	/**
	 * У��վ�����Ƿ����(ͨ��վ����ID��ȡվ����)
	 * @param insideLetterID վ����ID
	 * @param isRead �Ƿ��ȡ�� (true: ��ȡ����false: δ����)
	 * @author ������ 2015-10-21
	 */
	public void checkMailIsReadByInsideLetterID(String insideLetterID, boolean isRead){
		
		By iconBy = getInsideLetterIconBy(insideLetterID);
		checkMailIsRead(iconBy, isRead);
	}
	
	/**
	 * У��վ�����Ƿ����
	 * @param icon �ʼ�ͼ�����
	 * @param isRead �Ƿ��ȡ�� (true: ��ȡ����false: δ����)
	 * @author ������ 2015-10-20
	 */
	public void checkMailIsRead(By icon, boolean isRead){
		
		String iconStr = getInsideLetterIconName(icon);
		if(isRead){
			try {
				base.assertEqualsActualExpected(iconStr, "mailboxread");
			} catch (AssertionError error) {
				Reporter.log("error_�Ѷ�ȡ��վ���ţ�״̬Ϊδ��ȡ");
				System.out.println("error_�Ѷ�ȡ��վ���ţ�״̬Ϊδ��ȡ");
			}
		}
		else{
			try {
				base.assertEqualsActualExpected(iconStr, "mailboxnoread");
			} catch (AssertionError error) {
				Reporter.log("error_δ��ȡ��վ���ţ�״̬Ϊ�Ѷ�ȡ");
				System.out.println("error_δ��ȡ��վ���ţ�״̬Ϊ�Ѷ�ȡ");
			}
		}
	}
	
	
	/*****************����-�б�ҳ*******************/

	
	/**
	 * �б�ҳ����ȡվ�����ʼ�ͼ���ͼƬ����
	 * @param insideLetterID վ����ID
	 * @return ͼƬ����
	 * @author ������ 2015-10-20
	 */
	public By getInsideLetterIconBy(String insideLetterID){
		
		By by = By.xpath("//a[contains(@href,'" + insideLetterID + "')]/ancestor::tr//td[2]/img");
		base.checkElement(by);
		return by;
	}
	
	/**
	 * �б�ҳ����ȡվ���ŵķ���������
	 * @param insideLetterID վ����ID
	 * @return ��������������
	 * @author ������ 2015-10-21
	 */
	public By getInsideLetterSenderByInListPage(String insideLetterID){
		
		By by = By.xpath("//a[contains(@href,'" + insideLetterID + "')]/ancestor::tr//td[4]/span");
		base.checkElement(by);
		return by;
	}
	
	/**
	 * �б�ҳ����ȡվ���ŵı������
	 * @param insideLetterID վ����ID
	 * @return �������
	 * @author ������ 2015-10-20
	 */
	public By getInsideLetterTitleByInListPage(String insideLetterID){
		
		By by = By.xpath("//a[contains(@href,'" + insideLetterID + "')]");
		base.checkElement(by);
		return by;
	}
	
	/**
	 * �б�ҳ����ȡվ���ŵ����ݶ���
	 * @param insideLetterID վ����ID
	 * @return ���ݶ���
	 * @author ������ 2015-10-20
	 */
	public By getInsideLetterContentByInListPage(String insideLetterID){
		
		By by = By.xpath("//a[contains(@href,'" + insideLetterID + "')]/following-sibling::div/a");
		base.checkElement(by);
		return by;
	}
	
	/**
	 * �б�ҳ����ȡվ���ŵ�ʱ�����
	 * @param insideLetterID վ����ID
	 * @return ʱ�����
	 * @author ������ 2015-10-20
	 */
	public By getInsideLetterTimeByInListPage(String insideLetterID){
		
		By by = By.xpath("//a[contains(@href,'" + insideLetterID + "')]/ancestor::tr//span[@class='date']");
		base.checkElement(by);
		return by;
	}
	
	/**
	 * �б�ҳ����ȡվ�����ʼ�ͼ���ͼƬ����
	 * @param icon �ʼ�ͼ�����
	 * @return ͼƬ����
	 * @author ������ 2015-10-16
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
	 * �б�ҳ����ȡվ�����еı���
	 * @param title �������
	 * @return վ���ű���
	 * @author ������ 2015-10-16
	 */
	public String getInsideLetterTitleInListPage(By title){
		
		return base.getElementTextWithWait(title);
	}
	
	/**
	 * �б�ҳ�����վ�����еı���(ͨ��վ����ID��ȡ����)
	 * @param insideLetterID վ����ID
	 * @author ������ 2015-10-21
	 */
	public void clickInsideLetterTitleByIDInListPage(String insideLetterID){
		
		By titleBy = getInsideLetterTitleByInListPage(insideLetterID);
		clickInsideLetterTitleInListPage(titleBy);
	}
	
	/**
	 * �б�ҳ�����վ�����еı���
	 * @param title �������
	 * @author ������ 2015-10-20
	 */
	public void clickInsideLetterTitleInListPage(By title){
		
		base.clickWithWait(title);
		base.checkTitle("վ����");
	}
	
	/**
	 * �б�ҳ��У��վ���ŵġ������ˡ��������⡱�������ݡ������ռ�ʱ�䡱
	 * @param insideLetterID վ����ID
	 * @author ������ 2015-10-20
	 */
	public void checkInsideLetterInvestmentInListPage(String insideLetterID){
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap = dbData.getInsideLetterInfo(insideLetterID);
		
		String senderStr = base.getElementTextWithWait(getInsideLetterSenderByInListPage(insideLetterID));
		String titleStr = base.getElementTextWithWait(getInsideLetterTitleByInListPage(insideLetterID));
		String contentStr = base.getElementTextWithWait(getInsideLetterContentByInListPage(insideLetterID));
		String timeStr = base.getElementTextWithWait(getInsideLetterTimeByInListPage(insideLetterID));
		
		base.assertEqualsActualExpected(senderStr, "������");
		base.assertEqualsActualExpected(titleStr, hashMap.get("title"));
		base.assertEqualsActualExpected(contentStr, formantContent(hashMap.get("content")));
		base.assertEqualsActualExpectedByLong(formatCdate(timeStr), Long.parseLong(hashMap.get("cdate")));
	}
	

	/*****************����-����ҳ*******************/
	

	/**
	 * ����ҳ��У��վ���ŵġ������ˡ��������⡱�������ݡ������ռ�ʱ�䡱
	 * @param insideLetterID վ����ID
	 * @author ������ 2015-10-20
	 */
	public void checkInsideLetterInvestmentInDetailsPage(String insideLetterID){
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap = dbData.getInsideLetterInfo(insideLetterID);
		
		String senderStr = base.getElementTextWithWait(insideLetterSenderInDetailedPage);
		String titleStr = base.getElementTextWithWait(insideLetterTitleInDetailedPage);
		String contentStr = base.getElementTextWithWait(insideLetterContentInDetailedPage);
		String timeStr = base.getElementTextWithWait(insideLetterTimeInDetailedPage);
		
		base.assertEqualsActualExpected(senderStr, "������");
		base.assertEqualsActualExpected(titleStr, hashMap.get("title"));
		base.assertEqualsActualExpected(contentStr, hashMap.get("content"));
		base.assertEqualsActualExpectedByLong(formatCdate(timeStr), Long.parseLong(hashMap.get("cdate")));
	}

	
	/*****************����-����*******************/
	
	
	/**
	 * ��ҳ��ȡδ��վ���Ÿ���
	 * @return δ��վ���Ÿ���
	 * @author ������ 2015-10-16
	 */
	public String getInsideLetterNum(){
		
		String insideLetterNum = base.getElementTextWithWait(insideLetter);
		insideLetterNum = insideLetterNum.substring(1, insideLetterNum.length()-1);
		return insideLetterNum;
	}
	
	/**
	 * У��δ��ȡվ���ŵĸ���
	 * @param email �û�����
	 * @author ������ 2015-10-16
	 */
	public void checkInsideLetterNum(String email){
		
		try {
			base.assertEqualsActualExpected(getInsideLetterNum(), dbData.getInsideLetterNum(dbData.getUID(email), "δ��"));
		} catch (AssertionError e) {
			Reporter.log("δ��ȡ��վ���Ÿ��������ݿ��в�һ�¡�");
			System.out.println("δ��ȡ��վ���Ÿ��������ݿ��в�һ�¡�");
		}
	}
	
	/**
	 * �����վ���š�
	 * @author ������ 2015-10-15
	 */
	public void clickInsideLetter(){
		
		base.fromFrameToDefaultContent();
		base.clickWithWait(insideLetter);
		base.checkTitle("վ����");
		checkSysMsgTab();
		base.switchToFrame("myhome_app");
	}
	
	/**
	 * ��֤��ϵͳ��Ϣ���Ƿ�ѡ��
	 * @author ������ 2015-10-15
	 */
	public void checkSysMsgTab(){
		
		base.isElementContainsValue(sysMsgTab, "class", "current");
	}
	
	/**
	 * У��վ����״̬�Ƿ���³ɹ�
	 * @param insideLetterID վ����ID
	 * @param status վ����״̬��1Ϊδ����2Ϊ�Ѷ�
	 * @author ������ 2015-10-20
	 */
	public void checkUpdateReceiverStatus(String insideLetterID, String status){
		
		base.assertEqualsActualExpectedByBoolean(dbData.updateReceiverStatus(insideLetterID, status), true);
		base.refreshPage();
		base.switchToFrame("myhome_app");
	}

	/**
	 * ��ȡ��������汦�������Ϣ
	 * ��ע��������������汦���������û����������ݿ��в�ѯ����汦��Ψһ��
	 * @param email �û�����
	 * @return ��汦�������Ϣ��������������껯�����ʣ���Լ���ޣ���Ϣʱ�䣬����ʱ�䣩
	 * @author ������ 2015-10-23
	 */
	public HashMap<String, String> getExperienceECunBaoInfo(String email){
		
		HashMap<String, String> map = new HashMap<String, String>();
		String uid = dbData.getUID(email);
		map = dbData.getD_wmps_recordTable(uid);
		try {
			base.assertEqualsActualExpectedByBoolean(map.isEmpty(), false);
		} catch (Exception e) {
			Reporter.log("���ݿ�û�й�����������汦����Ϣ");
			System.out.println("");
		}
		return map;
	}
}
