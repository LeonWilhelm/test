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
 * ���ɻ�����̨ҳ��
 */
public class ClientBackPage {

	Base base = new Base();
	Data data = new Data();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	DBData dbData = new DBData();

	/****************************֪ͨ��ҳ��******************************/
	
	//֪ͨ���ı���
	By noticeCodeTxt = By.cssSelector("#noticeCode");
	//֪ͨ���ύ��ť
	By noticeCodeBtn = By.cssSelector("#subm");
	
	/****************************��̨��¼ҳ��******************************/
	
	//�û����ı���
	By userNameTxt = By.id("uname");
	//�����ı���
	By passwordTxt = By.id("upwd");
	//��֤��ͼƬ
	By randImg = By.cssSelector(".yzm>img");
	//��֤���ı���
	By randTxt = By.id("rand");
	//��¼��ť
//	By LoginBtn = By.id("subm");
	By LoginBtn = By.xpath("//input[@id='subm']");
	
	/****************************��̨����ҳ��******************************/
	
	//ϵͳͨ�洰��
	By proclamationDiv = By.cssSelector(".tip_box");  
    //ȷ����ť
	By enterSystemBtn = By.cssSelector("#enterSystem");
	
	/******************************��̨ҳ��-������*******************************/
	
	
	/******************************��̨ҳ��-�˵���*******************************/
	
	
	/******************************��̨ҳ��-������*******************************/
	
	//Tab�رհ�ť
	By tabClose = By.xpath("//a[@class='tabs-close']");
	//��һҳ��ť
	By nextBtn = By.xpath("//td[@id='next']/span");
	//��һҳ��ť��Td��ǩ
	By nextTd = By.xpath("//td[@id='next']");
	
	/******************************��̨ҳ��-������-��Ʋ�Ʒ*******************************/
	
	//iframe------------
	//��Ʋ�Ʒiframe
	public String wmpsIframe = "//iframe[@src='/admin/wmps.jsp']";
	
	//��ť------------
	//�����Ʋ�Ʒ���м�¼
	By addWMP = By.xpath("//button[text()='�����Ʋ�Ʒ���м�¼']");
	//ƥ��ծȨ
	By matchingBondBtnByWMP = By.xpath("//button[text()='ƥ��ծȨ']");
	
	//�б�------------
	//ˢ�°�ť
	public By refreshBtnByWMPSrecordList = By.xpath("//td[@id='refresh_wmpsrecordlist']//span");
	//��Ʋ�Ʒ�б�_��ǰҳ_���б���
	public By wmpsListByTitle = By.xpath("//td[@aria-describedby='wmpsrecordlist_title']");
	
	/******************************��̨ҳ��-������-��Ʋ�Ʒ-�����Ʋ�Ʒ���м�¼*******************************/
	
	//��Ʒ����
	By productTypeDropByWMP = By.xpath("//select[@id='type']");
	//����
	By titleTxtByWMP = By.xpath("//input[@id='title1']");
	//�����
	By maxAmountTxtByWMP = By.xpath("//input[@id='maxAmount']");
	//��������
	By issueRateTxtByWMP = By.xpath("//input[@id='interestrate']");
	//������
	By mainIssueRateTxtByWMP = By.xpath("//input[@id='firstInter']");
	//������
	By viceIssueRateTxtByWMP = By.xpath("//input[@id='secInter']");
	//������Ч��
	By validityPeriodTxtByWMP = By.xpath("//input[@id='valitime']");
	//����
	By timeLimitTxtByWMP = By.xpath("//input[@id='phases1']");
	//���а�ť
	By issueBtnByWMP = By.xpath("//span[text()='����']/parent::button");
	
	/******************************��̨ҳ��-������-���������б�*******************************/
	
	//iframe------------
	//���������б�iframe
	public String trialTendersIframe = "//iframe[@src='/admin/waitTrialTenders.jsp']";
	
	//��ť------------
	//���(new)
	public By auditNewBtn = By.xpath("//button[text()='���(new)']");
	
	//�б�------------
	//���������б�_��ǰҳ_���н��������
	public By tendlistByBorrowerName = By.xpath("//td[@aria-describedby='tendlist_brealname']");
	//�����������
	By borrowerRow = By.xpath("//td[@title='������']/parent::tr");
	//����������еĸ�ѡ��
	By borrowerChk = By.xpath("//tr[@id='91586']//input");
	
	/******************************��̨ҳ��-������-���������б�-���ұ�*******************************/
	
	//������
	By selType = By.xpath("//select[@id='selType']");
	//���ʽ
	By repayType = By.xpath("//select[@id='repayType']");
	
	/******************************��̨ҳ��-������-���������б�-���(new)*******************************/
	
	//������������������ť
//	By allianceBusinessAuditOpinionBtn = By.xpath("//input[@id='hqCheckWTTenderIdea']");
	By allianceBusinessAuditOpinionBtn = By.id("hqCheckWTTenderIdea");
	//���ܲ�����������ť
	By headquartersAuditOpinionBtn = By.xpath("//input[@id='FranCheckWTTenderIdea']");
	//���˱����ͨ������ť
	By firstCheckBtn = By.xpath("//input[@id='btnfirstCheck']");
	//�����ꡱ��ť
	By tenderFailBtn = By.xpath("//input[@id='btncheckWTTenderFail']");
	
	/******************************��̨ҳ��-������-���������б�-��˱�*******************************/
	
	//���ꡰԭ��
	By tenderFailTxt = By.xpath("//textarea[@id='reason' and @rows='12']");
	//�����ꡱ��ť
	By failBtn = By.xpath("//span[text()='����']/parent::button");
	
	/******************************��̨ҳ��-������-���������б�-������������*******************************/
	
	//ͨ����ѡ��ť
	By passRdo = By.xpath("//input[@id='checkWTType' and @value='1']");
	//�����̷�����
	By legalRdoByH = By.xpath("//input[@id='checkWTRole' and @value='11']");
	//�ۺ����
	By synthesizeTxt = By.xpath("//textarea[@id='checkWTIdea']");
	//����������
	By supplyTxt = By.xpath("//textarea[@id='checkWTdataIdea']");
	//ȷ����ť
	public By okBtn = By.xpath("//span[text()='ȷ��']/parent::button");//div[@id='ukVerifyDialog']/parent::div//span[text()='ȷ��']/parent::button
	By okBtn2 = By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'][1]");
	//ȡ����ť
	public By cancelBtn = By.xpath("//span[text()='ȡ��']/parent::button");
	
	//��������
	By passwordTxtByH = By.xpath("//input[@id='deviceRandomCode']");

	/******************************��̨ҳ��-������-���������б�-�ܲ�������*******************************/
	
	//�ܲ�������
	By legalRdoByA = By.xpath("//input[@id='checkWTRole' and @value='01']");
	//���ܲ��ɼ����
	By onlyTxt = By.xpath("//textarea[@id='onlyIdea']");
	
	/******************************��̨ҳ��-������-���������б�-��������ծȨ��*******************************/
	
	//����������ծȨ�ء���ť
	By joinBondBtn = By.xpath("//button[text()='��������ծȨ��']");
	//�����͡������б�
	By productTypeDropByFinancial = By.xpath("//select[@id='wtype']");
	
	/******************************��̨ҳ��-������-ծȨ�ر�*******************************/
	
	//iframe------------
	//ծȨ�ر�iframe
	public String tenderThirdpartyIframe = "//iframe[@src='/admin/tenderThirdparty.jsp']";
	
	//��ť------------
	//����ѯ����ť
	By selectBtnByBond = By.xpath("//button[text()='��ѯ']");
	//�����⡱�ı���
	By titleTxt = By.xpath("//input[@id='title']");
	//��״̬�������б�
	public By statusDropByBond = By.xpath("//select[@id='status']");
	//�����뵽��Ʒ����ť
	By joinProductBtnByBond = By.xpath("//button[text()='���뵽��Ʒ']");
	//�����뵽�ò�Ʒ����ť
	By joinTheProductBtnByBond = By.xpath("//span[text()='���뵽�ò�Ʒ']");
	
	//�б�------------
	//ծȨ�ر�_��ǰҳ_���н��������
	public By tendThirdpartyByBorrowerName = By.xpath("//td[@aria-describedby='tendlist_realname']");
	
	/******************************��̨ҳ��-������-���������б�*******************************/
	
	//iframe------------
	//���������б�iframe
	public String tenderCheckIframe = "//iframe[@src='/admin/tenderCheck.jsp']";
	
	//��ť------------
	//�����Ʋ�Ʒ���м�¼
	By auditNewBtnByFinalJudgment = By.xpath("//button[text()='���(new)']");//��ɾ��
	
	//���Դ˱����ͨ�����򡰽���ȷ��ͨ����
	By auditThroughBtnByFinalJudgment = By.xpath("//input[@id='checkSuccess']");
	
	//�б�------------
	//���������б�_��ǰҳ_���н��������
	public By tenderCheckByBorrowerName = By.xpath("//td[@aria-describedby='tendlist_brealname']");
	//ˢ�°�ť
	public By refreshBtnByTendList = By.xpath("//td[@id='refresh_tendlist']//span");
	
	/******************************��̨ҳ��-������-���������б�-���ұ�*******************************/
	
	//ʡ��
	By provinceDrop = By.xpath("//select[@id='provinceid']");
	//����
	By municipalityDrop = By.xpath("//select[@id='cityid']");
	//����
	By districtDrop = By.xpath("//select[@id='countyid']");
	//�����͡�������ꡱ
	By loanTypeDrop = By.xpath("//select[@id='selType']");
	
	/******************************��̨ҳ��-������-���ν��������б�*******************************/
	
	//iframe------------
	//���ν��������б�iframe
	public String waitTrialTenders2Iframe = "//iframe[@src='/admin/waitTrialTenders2.jsp']";
	
	
	/****************************֪ͨ��ҳ��******************************/
			
	/**
	 * ֪ͨ���¼
	 * @param noticeCode:֪ͨ��
	 * @author ������ 2015-7-29
	 */
	public void LoginByNoticeCode(String noticeCode){
		base.sendKeysWithWait(noticeCodeTxt, noticeCode);
		base.sleep(1000);
		do{
			base.clickWithWait(noticeCodeBtn);
			base.sleep(2000);System.out.println("��ת��ҳ��Title: " + base.getPageTitle());
			if(base.getPageTitle().equals("��̨�����¼")){break;}
		}while(true);
	}
	
	/****************************��̨��¼ҳ��******************************/
	
	/**
	 * ��̨ϵͳ��¼
	 * @param userName:�û���
	 * @param password:����
	 * @author ������ 2015-7-29
	 */
	public void LoginByClientBack(String userName, String password){

		String imgCode = "";
		//�����֤�����������ѭ�����룬ֱ��������ȷΪֹ
		do{
			String currentURL = "";
			base.checkElementVisible(userNameTxt);
			imgCode = data.get(base.getElementWithWait(randImg), base.getWebDriver());
			base.sendKeysWithWait(randTxt, imgCode);
			base.sendKeysWithWait(userNameTxt, userName);
			base.sendKeysWithWait(passwordTxt, password);
//			System.out.println("���ֶ�������֤��....");
//			base.sleep(8000);
//			System.out.println("׼�������¼��ť");
			base.assertEqualsActualExpectedByBoolean(base.isElementPresent(LoginBtn), true);
			base.clickWithWait(LoginBtn);
			System.out.println("��¼��ť������");
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
		//ϵͳͨ�洰�ڵ���ʱ������ȷ����ť
		if(!base.isNone(proclamationDiv)){
			base.sleep(15000);
			//У�顰ȷ������ť�Ƿ���ʾ
			base.assertEqualsActualExpectedByBoolean(base.isDisplayed(enterSystemBtn), true);//System.out.println("ȷ����ť�Ƿ���ʾ��" + base.isDisplayed(enterSystemBtn));//--------����
			base.clickWithWait(enterSystemBtn);
		}
		base.fromFrameToDefaultContent();
		base.sleep(5000);
	}
	
	/**
	 * ��̨��¼
	 * @param URL����̨��ַ
	 * @param noticeCode��֪ͨ��
	 * @param userName���û���
	 * @param password������
	 */
	public void backLogin(String URL, String noticeCode, String userName, String password){
		base.openBrowser(URL);
		base.sleep(2000);
		LoginByNoticeCode(noticeCode);
		LoginByClientBack(userName, password);
	}
	
	/******************************��̨ҳ��-���-�˵���*******************************/
	
	/**
	 * ���һ���˵�
	 * @param panelExpandName���˵�����
	 * @author ������ 2015-7-30
	 */
	public void clickFirstMenu(String menuName){
		By firstMenu = By.xpath("//div[text()='" + menuName + "']");
		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(firstMenu), true);
		base.clickWithWait(firstMenu);
		base.sleep(3000);
	}
	
	/**
	 * ��������˵�
	 * @author ������ 2015-7-30
	 */
	public void clickSubMenu(String menuName){
		By subMenu = By.xpath("//a[text()='" + menuName + "']");
		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(subMenu), true);
		base.clickWithWait(subMenu);
		base.sleep(5000);
	}
	
	/******************************��̨ҳ��-������-����*******************************/
	
	/**
	 * ��ת��iframe
	 * @param iframeURL(���磺//iframe[@src='/admin/wmps.jsp'])
	 * @author ������ 2015-8-4
	 */
	public void jumpIframe(String iframeURL){
		boolean isTrue = base.isElementPresent(By.xpath(iframeURL));
		if(isTrue){
			//��ת����Ӧҳ
			base.switchToFrameByWebElement(base.getElementWithWait(By.xpath(iframeURL)));
		}
		else{
			System.out.println("��iframe������");
		}
	}
	
	/**
	 * �����̨-����ҳ-��ť
	 * @param btnText����ť����
	 */
	public void clickBtnByList(String btnText){
		By tempBtn = By.xpath("//button[text()='" + btnText + "']");
		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(tempBtn), true);
		base.clickWithWait(tempBtn);
	}
	
	/**
	 * ����б�ˢ�°�ť
	 */
	public void clickRefreshBtn(By by){
		base.clickWithWait(by);
	}
	
	/**
	 * ���Һ�̨�б���ĳ���ֶ����Ƿ��С���Ҫ�ҵ�ֵ�������磺�����������
	 * ��ע��ֻ���ҵ���һ����ʾ��ֵ�����磺�����������
	 * @param iframeURL���б�iframe��ַ�����磺//iframe[@src='/admin/waitTrialTenders.jsp']��
	 * @param ListBy��ĳ���ֶμ��ϣ����磺tendlistByBorrowerName = By.xpath("//td[@aria-describedby='tendlist_brealname']")��
	 * @param searchField:�����ֶΣ����磺���������Ϊ���û�������
	 * @return true:�����ֶδ��ڣ�false�������ֶβ�����
	 * @author ������ 2015-7-30
	 */
	public boolean isSearchFieldByList(String iframeURL, By listBy, String searchField){
		
		//�Ƿ����
		boolean isTrue = false;
		String tempNameString = "";
		List<WebElement> borrowerNameList = null;
		
		//��ת�������������б�ҳ
		jumpIframe(iframeURL);
		//��ҳ��������
		do{
			System.out.println("\n-------------��ʼ_���ҽ����----------------\n");//------------����
			borrowerNameList = new ArrayList<WebElement>();
			borrowerNameList = base.getElements(listBy);
			int size = borrowerNameList.size();System.out.println("�б��С��" + size);//------------����
			//����ҵ���ͬ����������ѭ��
			for(int i = 0; i < size; i++){
				tempNameString = base.getElementTextWithWait(borrowerNameList.get(i));System.out.println("��" + (i + 1) + "��: " + tempNameString);//------------����
				if(searchField.equals(tempNameString)){
					isTrue = true;
				}
			}
			
			System.out.println("\n-------------����_���ҽ����----------------\n");//------------����
			
			//���û�У������һҳ
			if(!isTrue){
				boolean isBtnDisabled = false;
				//�Ƿ�����;trueΪ���أ�falseΪ��ʾ
				isBtnDisabled = base.isElementContainsValue(nextTd, "class", "disabled");System.out.println("��һҳ��ť�Ƿ����أ� " + isBtnDisabled);//------------����
				//�жϵ�ǰҳ�Ƿ������һҳ������һҳ��ť�Ƿ�����
				if(isBtnDisabled){
//					System.out.println("error_�б�û���ҵ������");
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
	
	/******************************��̨ҳ��-������-���������б�*******************************/
	
	/**
	 * ��ȡ����������е�ID
	 * @param ���������
	 * @return �е�ID
	 */
	public String getBorrowerID(String borrowerName){
		
		//����˵���ID
		String borrowerID = "";
		//��ȡ�����������
		By borrowerRow = org.openqa.selenium.By.xpath("//td[@title='" + borrowerName + "']/parent::tr");
		//��ȡ��ID
		borrowerID = base.getLnkElementText(borrowerRow, "id");System.out.println("����������е�ID��" + borrowerID);
		return borrowerID;
	}
	
	/**
	 * ��ѡ����˸�ѡ��
	 * @author ������ 2015-7-30
	 */
	public void clickBorrowerChk(String borrowerID){
		
		By borrowerChk = org.openqa.selenium.By.xpath("//tr[@id='" + borrowerID + "']//input");
		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(borrowerChk), true);
		base.clickWithWait(borrowerChk);
	}
	
	/**
	 * ��ѯ��
	 * @author ������ 2015-8-17
	 */
	public void selectLoan(String iframeURL){
		jumpIframe(iframeURL);
		//�������ѯ����ť
		clickBtnByList("����");
		base.sleep(3000);
		//������
		base.elementSelectByVisibleText(selType, "�������");
		base.sleep(1000);
		//�껹�ʽ
		base.elementSelectByVisibleText(repayType, "������Ϣ");
		//�����ȷ������ť
		base.clickWithWait(okBtn);
		base.sleep(2000);
	}
	
	/**
	 * ���������б�����˽��(���μ���������������һ�μ������ó���ͨ����һ���ܲ�������)
	 * ��ע��δ��ʵ�ָ���UK�û�ID�ж��Ƿ���˹�
	 * @param borrowerName:��������� 
	 * @param auditName:����˻�
	 * @param lastSecondCheck:�Ƿ�Ϊ���һ��Ϊ����ͨ��
	 * @param passwordByBack:��̨ȷ������
	 * @author ������ 2015-7-30
	 */
	public void tendlistAuditLoan(String borrowerName, String auditName, boolean lastSecondCheck, String passwordByBack){

		//�������ID
		String borrowerID = "";
		//Alter��ʾ��Ϣ
		String alertString = "";
		//���ھ��
		String parentWindowHandle = "";
		String childWindowHandle = "";
		//���ۺ������
		String synthesizeString = "�������Զ������ԣ��ۺ�������������Զ������ԣ��ۺ�������������Զ������ԣ��ۺ������";
		//��������������
		String supplyString = "�������Զ������ԣ��������������������Զ������ԣ�������������";
		//�����ܲ��ɼ������
		String onlyString = "�������Զ������ԣ����ܲ��ɼ�������������Զ������ԣ����ܲ��ɼ������";
		
		parentWindowHandle = base.getCurrentWindowHandle();System.out.println("�����ھ����" + parentWindowHandle);
		//��ȡ����������е�ID
		borrowerID = getBorrowerID(borrowerName);
		//����ID��ѡ���Ƿ���󡱵ĸ�ѡ��
		clickBorrowerChk(borrowerID);
		base.sleep(5000);
		//��������(new)����ť
		clickBtnByList("���(new)");
		base.sleep(5000);
		if(base.isAlertPresent()){
			//�������ܲ��ѽ��øܸˡ������ȷ��
			alertString = base.getTextByAlert();System.out.println("���(new)������ʾ��Ϣ��" + alertString);//---------����
//			base.assertEqualsActualExpected(alertString, "�ܲ��ѽ��øܸ�");
			base.acceptAlert();
		}
		//�����´��ڣ���ȡ�Ӵ��ڲ���ת
		base.sleep(5000);
		if(base.Windowsize()>1){
			childWindowHandle = base.getChildWindowHandle(parentWindowHandle);System.out.println("�Ӵ��ھ����" + childWindowHandle);//---------����
			base.jumpToWindow(childWindowHandle);System.out.println("��ǰ���ھ����" + base.getCurrentWindowHandle());//---------����
			if(childWindowHandle.equals(parentWindowHandle)){
				base.turnToNewPage();
			}
		}
		base.sleep(8000);//System.out.println("�û�����" + auditName + " �Ƿ����'_': " + auditName.contains("_"));//---------����
		//������_��Ϊ�������û�������Ϊ�ܲ��û�
		if(auditName.contains("_")){
			//�������������������
			do{
				base.clickWithWait(allianceBusinessAuditOpinionBtn);
				base.sleep(2000);
				if(base.isElementContainsValue(By.xpath("//div[@id='checkWTTenderIdeaDiv']/div"), "style", "block")){break;}
			}while(true);
			//�����ͨ������ѡ��ť
			base.clickWithWait(passRdo);
			base.sleep(1000);
			//����������̷����ء���ѡ��ť
			base.clickWithWait(legalRdoByH);
			base.sleep(1000);
			//��д���ۺ������
			base.sendKeyAndWait(synthesizeTxt, synthesizeString);
			base.sleep(1000);
			//��д��������������
			base.sendKeyAndWait(supplyTxt, supplyString);
			base.sleep(1000);
			base.assertEqualsActualExpectedByBoolean(base.isElementPresent(okBtn), true);
			//�����ȷ����ť��
			base.clickWithWait(okBtn);
			base.sleep(2000);
			//��ȡAlter������
			alertString = base.getTextByAlert();System.out.println("���������ȷ����ť��ʾ��Ϣ��" + alertString);//---------����
			if(alertString.equals("���Ըñ����������������ٴβ�����")){
				base.acceptAlert();
				base.sleep(2000);
				base.clickWithWait(cancelBtn);
			}
			else{
				base.acceptAlert();
			}
			base.sleep(5000);
			//���Ϊ�����ڶ��Σ���Ϊ�������ó���ͨ��
			if(lastSecondCheck){
				do {
					if(base.isElementPresent(firstCheckBtn)){
						break;
					}
				} while (true);
				//������˱����ͨ����
				base.clickWithWait(firstCheckBtn);
				base.sleep(2000);
				//��������
				base.sendKeyAndWait(passwordTxtByH, passwordByBack);
				base.sleep(5000);
				//���ȷ����ť
				base.clickWithWait(By.xpath("html/body/div[23]/div[11]/div/button[1]"));
				base.sleep(2000);
				//��ȡAlter������
				alertString = base.getTextByAlert();System.out.println("�����̳���ͨ��ȷ����ť��ʾ��Ϣ1��" + alertString);//---------����
				base.sleep(1000);
				base.acceptAlert();
				base.sleep(3000);
				alertString = base.getTextByAlert();System.out.println("�����̳���ͨ��ȷ����ť��ʾ��Ϣ2��" + alertString);//---------����
				base.sleep(1000);
				base.acceptAlert();
			}
		}
		else{
			//������ܲ���������
			do{
				base.clickWithWait(headquartersAuditOpinionBtn);
				base.sleep(2000);
				if(base.isElementContainsValue(By.xpath("//div[@id='checkWTTenderIdeaDiv']/div"), "style", "block")){break;}
			}while(true);
			base.sleep(1000);
			//�����ͨ������ѡ��ť
			base.clickWithWait(passRdo);
			base.sleep(1000);
			//����������̷����ء���ѡ��ť
			base.clickWithWait(legalRdoByA);
			base.sleep(1000);
			//��д���ۺ������
			base.sendKeyAndWait(synthesizeTxt, synthesizeString);
			base.sleep(1000);
			//��д��������������
			base.sendKeyAndWait(supplyTxt, supplyString);
			base.sleep(1000);
			//��д�����ܲ��ɼ������
			base.assertEqualsActualExpectedByBoolean(base.isElementPresent(onlyTxt), true);
			base.sendKeyAndWait(onlyTxt, onlyString);
			base.sleep(1000);
			//�����ȷ����ť��
			base.clickWithWait(okBtn);
			//��ȡAlter������
			alertString = base.getTextByAlert();System.out.println("�ܲ����ȷ����ť��ʾ��Ϣ��" + alertString);//---------����
			base.assertEqualsActualExpected(alertString, "�����ɹ���");
			base.acceptAlert();
			base.sleep(1000);
		}
		//����������������!�����ڣ����ȷ��������������session����
		//�رյ�ǰ����
		System.out.println("���ڴ�С��" + base.Windowsize());
		if(base.Windowsize()>1){
			base.closeWindow(childWindowHandle);
			base.sleep(3000);
			base.jumpToWindow(parentWindowHandle);
		}
	}
	
	/**
	 * ����
	 * @param borrowerName:���������
	 * @param passwordByBack:��̨ȷ������
	 * @author ������ 2015-8-25
	 */
	public void tenderFail(String borrowerName, String passwordByBack){
		//�������ID
		String borrowerID = "";
		//Alter��ʾ��Ϣ
		String alertString = "";
		//���ھ��
		String parentWindowHandle = "";
		String childWindowHandle = "";
		
		//���ꡰԭ��
		String reasonString = "�������Զ������ԣ�����������������Զ������ԣ����������";
		
		parentWindowHandle = base.getCurrentWindowHandle();System.out.println("�����ھ����" + parentWindowHandle);
		//��ȡ����������е�ID
		borrowerID = getBorrowerID(borrowerName);
		//����ID��ѡ���Ƿ���󡱵ĸ�ѡ��
		clickBorrowerChk(borrowerID);
		base.sleep(5000);
		//��������(new)����ť
		clickBtnByList("���(new)");
		base.sleep(5000);
		if(base.isAlertPresent()){
			//�������ܲ��ѽ��øܸˡ������ȷ��
			alertString = base.getTextByAlert();System.out.println("���(new)������ʾ��Ϣ��" + alertString);//---------����
			base.assertEqualsActualExpected(alertString, "�ܲ��ѽ��øܸ�");
			base.acceptAlert();
		}
		//�����´��ڣ���ȡ�Ӵ��ڲ���ת
		base.sleep(5000);
		if(base.Windowsize()>1){
			childWindowHandle = base.getChildWindowHandle(parentWindowHandle);System.out.println("�Ӵ��ھ����" + childWindowHandle);//---------����
			base.jumpToWindow(childWindowHandle);System.out.println("��ǰ���ھ����" + base.getCurrentWindowHandle());//---------����
			if(childWindowHandle.equals(parentWindowHandle)){
				base.turnToNewPage();
			}
		}
		base.sleep(8000);
		//��������ꡱ��ť
		base.clickWithWait(tenderFailBtn);
		base.sleep(2000);
		//��������
		base.sendKeyAndWait(passwordTxtByH, passwordByBack);
		base.sleep(5000);
		//���ȷ����ť
		base.clickWithWait(By.xpath("html/body/div[24]/div[11]/div/button[1]"));
		base.sleep(2000);
		base.sendKeyAndWait(tenderFailTxt, reasonString);
		base.sleep(1000);
		//��������ꡱ��ť
		base.clickWithWait(failBtn);
		base.sleep(2000);
		alertString = base.getTextByAlert();System.out.println("���굯����ʾ��Ϣ��" + alertString);//---------����
		base.assertEqualsActualExpected(alertString, "ȷ�������˱���");
		base.acceptAlert();
		base.sleep(2000);
		base.acceptAlert();
		if(base.Windowsize()>1){
			base.closeWindow(childWindowHandle);
			base.sleep(3000);
			base.jumpToWindow(parentWindowHandle);
		}
	}
	
	/******************************��̨ҳ��-������-���ν��������б�*******************************/
	
	/**
	 * ��ѯ��
	 * @author ������ 2015-8-17
	 */
	public void selectLoanByTwice(String iframeURL){
		jumpIframe(iframeURL);
		//�������ѯ����ť
		clickBtnByList("����");
		base.sleep(3000);
		//������
		base.elementSelectByVisibleText(selType, "�����");
		base.sleep(1000);
		//�����ȷ������ť
		base.clickWithWait(okBtn);
		base.sleep(2000);
	}
	
	/******************************��̨ҳ��-������-��Ʋ�Ʒ-�����Ʋ�Ʒ���м�¼*******************************/
	
	/**
	 * �����Ʋ�Ʒ
	 * @param loanPurpose:���Ŀ��
	 * @param loanAmount:�����
	 * @author ������ 2015-7-31
	 */
	public void addWMP(String loanPurpose, String loanAmount){
		
		//Alert��ʾ��Ϣ
		String alertString = "";
		
		//��ת������Ʋ�Ʒ��ҳ
		jumpIframe(wmpsIframe);
		base.sleep(2000);
		//����������Ʋ�Ʒ���м�¼��
//		base.clickWithWait(addWMP);
		clickBtnByList("�����Ʋ�Ʒ���м�¼");
		base.sleep(2000);
		//��������
		base.sendKeyAndWait(passwordTxtByH, Data.passwordByBack);
		//�����ȷ������ť
		base.clickWithWait(okBtn);
		base.sleep(2000);
		//��д��Ʒ��Ϣ
		base.elementSelectByVisibleText(productTypeDropByWMP, "��汦");
		//����
		base.sendKeyAndWait(titleTxtByWMP, "�Զ�������" + loanAmount);
		//�����
		base.sendKeyAndWait(maxAmountTxtByWMP, loanAmount);
		//��������
		base.sendKeyAndWait(issueRateTxtByWMP, "12");
		//������
		base.sendKeyAndWait(mainIssueRateTxtByWMP, "10.5");
		//������
		base.sendKeyAndWait(viceIssueRateTxtByWMP, "1.5");
		//������Ч��
		base.sendKeyAndWait(validityPeriodTxtByWMP, "24");
		//����
		base.sendKeyAndWait(timeLimitTxtByWMP, "30");
		//��������С���ť
		base.clickWithWait(issueBtnByWMP);
		base.sleep(3000);
		//Alert
		alertString = base.getTextByAlert();System.out.println("�����Ʋ�Ʒ���м�¼������ʾ��Ϣ��" + alertString);//---------����
//		base.assertEqualsActualExpected(alertString, "�ܲ��ѽ��øܸ�");
		base.acceptAlert();
		base.sleep(3000);
		alertString = base.getTextByAlert();System.out.println("��ӳɹ���ʾ��Ϣ��" + alertString);//---------����
		base.assertEqualsActualExpected(alertString, "�����ɹ�");
		base.acceptAlert();
	}
	
	/**
	 * ����ID���鿴��Ʒ��״̬��
	 * @param id
	 */
	public void checkProductStatus(String id){
		System.out.println(base.getLnkElementText(By.xpath(".//*[@id='" + id + "']/td[17]"), "title"));//-------����
		boolean isTrue = base.isElementContainsValue(By.xpath(".//*[@id='" + id + "']/td[17]"), "title", "�Ϲ���ɣ������ ");
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
	}
	

	/******************************��̨ҳ��-������-���������б�-��������ծȨ��*******************************/

	/**
	 * ��������ծȨ��
	 * @author ������ 2015-8-4
	 */
	public void joinBond(String borrowerName, String passwordByBack){
		
		String borrowerID = "";
		//Alert��ʾ��Ϣ
		String alertString = "";
		//��ȡ����������е�ID
		borrowerID = getBorrowerID(borrowerName);
		base.sleep(2000);
		//����ID��ѡ���Ƿ���󡱵ĸ�ѡ��
		clickBorrowerChk(borrowerID);
		do{
			//�������������ծȯ�ء���ť
			clickBtnByList("��������ծȨ��");
			if(base.isElementContainsValue(By.xpath("//div[@aria-labelledby='ui-dialog-title-ukVerifyDialog']"), "style", "block")){break;}
		}while(true);
		//��������
		base.sendKeyAndWait(passwordTxtByH, passwordByBack);
		//�����ȷ������ť
		base.clickWithWait(By.xpath("//div[@id='ukVerifyDialog']/parent::div//span[text()='ȷ��']/parent::button"));
		//ѡ���������Ϊ����ư���Ʒ��
		base.elementSelectByVisibleText(productTypeDropByFinancial,"��ư���Ʒ");
		//�����ȷ������ť
		base.clickWithWait(By.xpath("//div[@id='wmpsTender_dialog_target']//span[text()='ȷ��']/parent::button"));
		//����Alter�����ȷ��
		alertString = base.getTextByAlert();System.out.println("��������ծȨ�ص�����ʾ��Ϣ��" + alertString);//---------����
		base.acceptAlert();
		base.assertEqualsActualExpected(alertString, "�����ɹ�!");
		base.sleep(2000);
	}
	
	/******************************��̨ҳ��-������-ծȨ�ر�-���뵽��Ʒ*******************************/
	
	/**
	 * ��ѯծȨ
	 */
	public void selectDebt(String iframeURL){
		
		jumpIframe(iframeURL);
		base.sleep(2000);
		//�������ѯ����ť
		clickBtnByList("��ѯ");
		base.sleep(3000);
		base.sendKeyAndWait(titleTxt, "...");
		//״̬Ϊ��δƥ�䡱
		base.elementSelectByVisibleText(statusDropByBond, "δƥ��");
		//�����ȷ������ť
		base.clickWithWait(okBtn);
		base.sleep(2000);
	}
	
	/**
	 * ���ݱ����������������
	 * @param loanPurpose������
	 * @author ������ 2015-8-6
	 */
	public void clickRowByLoanPurposeTitle(String loanPurpose){
		//��ȡ����������
		By loanPurposeRow = org.openqa.selenium.By.xpath("//td[@title='" + loanPurpose + "']/parent::tr");
		base.sleep(2000);
		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(loanPurposeRow), true);
		base.clickWithWait(By.xpath("//td[@title='" + loanPurpose + "']"));
		//У���Ƿ�ѡ�У�aria-selected������ֵ
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(loanPurposeRow, "aria-selected", "true"), true);
	}

	/**
	 * ���뵽��Ʒ
	 * @author ������ 2015-8-5
	 */
	public void joinProduct(String borrowerName, String loanPurpose, String passwordByBack){
		
		//������ID
		String loanPurposeTitleID = "";
		//�������ID
		String borrowerID = "";
		//Alert��ʾ��Ϣ
		String alertString = "";
		//��ȡ����������е�ID
		borrowerID = getBorrowerID(borrowerName);
		base.sleep(2000);
		//����ID��ѡ���Ƿ���󡱵ĸ�ѡ��
		clickBorrowerChk(borrowerID);
		//��������뵽��Ʒ����ť 
		clickBtnByList("���뵽��Ʒ");
		base.sleep(2000);
		//��������
		base.sendKeyAndWait(passwordTxtByH, passwordByBack);
		base.sleep(2000);
//		do{
//			base.assertEqualsActualExpectedByBoolean(base.isElementPresent(okBtn2), true);
			//�����ȷ������ť
		base.clickWithWait(By.xpath("html/body/div[9]/div[11]/div/button[1]"));
		base.sleep(2000);
//			boolean isShow = base.isElementContainsValue(By.xpath("//div[@aria-labelledby='ui-dialog-title-wmpsRecordDialog']"), "style", "display: block;");
//			if(isShow){
//				break;
//			}
//		}while(true);
		//�����һ�е�����
		clickRowByLoanPurposeTitle(loanPurpose);
		base.sleep(2000);
		//��������뵽�ò�Ʒ����ť
		base.clickWithWait(joinTheProductBtnByBond);
		//Alter���ȷ��
		alertString = base.getTextByAlert();System.out.println("���뵽��Ʒ������ʾ��Ϣ��" + alertString);//---------����
		base.acceptAlert();
		//Alter���ȷ��
		alertString = base.getTextByAlert();System.out.println("���뵽��Ʒ�ɹ�������ʾ��Ϣ��" + alertString);//---------����
		base.acceptAlert();
		base.assertEqualsActualExpected(alertString, "�����ɹ�");
		base.sleep(5000);
		
	}
	
	/******************************��̨ҳ��-������-��Ʋ�Ʒ-ƥ��ծȨ*******************************/
	
	/**
	 * ƥ��ծȨ
	 * @author ������ 2015-8-5
	 */
	public void matchingBond(String loanPurpose, String passwordByBack){
		
		//Alert��ʾ��Ϣ
		String alertString = "";
		//�����һ�е�����
		clickRowByLoanPurposeTitle(loanPurpose);
		base.sleep(2000);
		//�����ծȯƥ�䡱��ť
//		base.clickWithWait(matchingBondBtnByWMP);
		clickBtnByList("ƥ��ծȨ");
		//��������
		base.sendKeyAndWait(passwordTxtByH, passwordByBack);
		//�����ȷ������ť
		base.clickWithWait(okBtn);
		//Alter���ȷ��
		alertString = base.getTextByAlert();System.out.println("ծȨƥ�䵯����ʾ��Ϣ��" + alertString);//---------����
		base.acceptAlert();
		base.assertEqualsActualExpected(alertString, "�����ɹ�");
	}

	/******************************��̨ҳ��-������-���������б�*******************************/
	
	/**
	 * �����û��������������
	 * @param borrowerName:���������
	 * @param loanAmount:�����
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
	 * ��ȡ��״̬
	 * @param borrowerName�����������
	 * @param loanAmount�������
	 */
	public String getTenderState(String borrowerName, String loanAmount){
		By loan = By.xpath("//tr/td[@title='" + loanAmount + "']/preceding-sibling::td[@title='" + borrowerName + "']/parent::tr/td[19]");
		String tenderState = base.getElementTextWithWait(loan);
		return tenderState;
	}
	
	/**
	 * ���ұ�
	 * @author ������ 2015-8-7
	 */
	public void selectTender(){
//		//ʡ��ѡ�񡰱����С�
//		base.elementSelectByVisibleText(provinceDrop, "������");
//		//����ѡ�񡰱����С�
//		base.elementSelectByVisibleText(municipalityDrop, "������");
//		//����ѡ�񡰶��ǡ�
//		base.elementSelectByVisibleText(districtDrop, "����");
		//�����͡�������ꡱ
		base.elementSelectByVisibleText(loanTypeDrop, "�������");
		//�����ȷ������ť
		base.clickWithWait(okBtn);
	}
	
	/**
	 * �ܲ�����
	 * @param borrowerName�����������
	 * @param loanAmount�������
	 * @param passwordByBack����̨ȷ������
	 * @author ������ 2015-8-7
	 */
	public void finalJudgment(String borrowerName, String loanAmount, String passwordByBack){
		
		String currentWindowHandle = "";
		String childWindowHandle = "";
		//Alert��ʾ��Ϣ
		String alertString = "";
		
		currentWindowHandle = base.getCurrentWindowHandle();System.out.println("�����ھ����" + currentWindowHandle);
		//��ת�������������б�ҳ
		jumpIframe(tenderCheckIframe);
		//��������ҡ���ť
		clickBtnByList("����");
		base.sleep(3000);
		//���ұ�
		selectTender();
		base.sleep(5000);
		//�����û��������������
		clickLoanByFinalJudgment(borrowerName, loanAmount);
		base.sleep(3000);
		//��������(new)����ť
		clickBtnByList("���(new)");
		if(base.Windowsize()>1){
			childWindowHandle = base.getChildWindowHandle(currentWindowHandle);System.out.println("�Ӵ��ھ����" + childWindowHandle);
			base.jumpToWindow(childWindowHandle);
			if(childWindowHandle.equals(currentWindowHandle)){
				base.turnToNewPage();
			}
		}
		//������Դ˱����ͨ�����򡰽���ȷ��ͨ����
		base.clickWithWait(auditThroughBtnByFinalJudgment);
		//��������
		base.sendKeyAndWait(passwordTxtByH, passwordByBack);
		//�����ȷ������ť
		base.clickWithWait(okBtn);
		base.sleep(3000);
		//Alter���ȷ��
		alertString = base.getTextByAlert();System.out.println("�Դ˱����ͨ��������ʾ��Ϣ1��" + alertString);//---------����
		base.acceptAlert();
		base.sleep(5000);
		//Alter���ȷ��
		alertString = base.getTextByAlert();System.out.println("�Դ˱����ͨ��������ʾ��Ϣ2��" + alertString);//---------����
		base.acceptAlert();
//		base.assertEqualsActualExpected(alertString, "�ý�����������ͨ����");
		base.sleep(3000);
		alertString = base.getTextByAlert();System.out.println("�Դ˱����ͨ��������ʾ��Ϣ3��" + alertString);//---------����
		if(alertString.equals("���û��Ľ�����Ѿ���˹���,����������ˣ�")){
			base.acceptAlert();
		}
		else{
			base.dismissAlert();
		}
		System.out.println("��ǰ���ڸ�����" + base.getCurrentWindowHandles());
//		if(base.Windowsize()>1){
//			base.closeWindow(childWindowHandle);
//			base.jumpToWindow(currentWindowHandle);
//		}
	}
	//���ݽ���id����"����"
	public void FinalAudit(String tenderid){
		base.checkElementVisible(By.xpath(tenderCheckIframe));
		jumpIframe(tenderCheckIframe);
		base.checkElementVisible(By.id("jqgh_brealname"));//"�����"�ı�
		base.clickWithWait(By.id(tenderid));
		base.sleep(3000);
//		clickBtnByList("���(new)");
		base.clickWithWait(By.xpath("//a[contains(@onclick,'tid="+tenderid+"')]"));//����
		base.jumpToNewWindow();
		base.openBrowser(base.getCurrentUrl().replace("type=25", "type=1"));
		base.clickWithWait(auditThroughBtnByFinalJudgment);
		base.checkElementVisible(passwordTxtByH);
		base.sendKeysWithWait(passwordTxtByH, Data.passwordByBack);
		base.clickWithWait(okBtn);
		base.checkAlertText("ȷ���Դ˱��������ͨ����");
		base.checkAlertText("�ý�����������ͨ����");
		base.checkAlertText("�鿴���ӽ���������?");
	}
	
	/**
	 * У������Ƿ�ɹ�
	 * @param borrowerName�����������
	 * @param loanAmount�������
	 * @author ������ 2015-8-12
	 */
	public void checkTenderState(String borrowerName, String loanAmount){
		
		//���ˢ�°�ť
		base.clickWithWait(refreshBtnByTendList);
		//��ȡ��״̬
		String tenderState = getTenderState(borrowerName, loanAmount);
		//���ҽ���˵ı�״̬�Ƿ�Ϊ���ɹ���
		base.assertEqualsActualExpected(tenderState, "�ɹ�");
	}
	
	/******************************ǰ̨ҳ��-������汦*******************************/
	
	/**
	 * ������汦
	 * @param loanAmount�������
	 * @param loanPurpose�����Ŀ��
	 * @return id
	 */
	public String buyECunBao(String loanAmount, String loanPurpose){
		
		String id = "";
		//���ݱ��⹺�� (loanPurpose)
		id = eCunBaoPage.getProductIDByECunBaoTitle(loanPurpose);
		//���ݲ�ƷID�������Ͷ
		eCunBaoPage.clickQiangTouBtn(id);
		base.sleep(5000);
//		//���ݲ�ƷID��������
//		eCunBaoPage.inputInvestmentAmountTxt(id, loanAmount);
		eCunBaoPage.clickInvestmentAmountTxt(id);
		base.sleep(3000);
		eCunBaoPage.clickMaxMoney(id);
		base.sleep(5000);
		//�����ͬ��Э�鲢Ͷ�ʡ�
		eCunBaoPage.clickAgreeInvestmentBtn(id);
		base.sleep(5000);
		//��ȡ����ʧ��DIV
		if(eCunBaoPage.getOperationFailureDiv()){
			eCunBaoPage.closeOperationFailureDiv();
			System.out.println("��汦Ͷ�ʺ���ʾ����ʧ��~");
		}
		return id;
	}
	
	/******************************ǰ̨ҳ��-���׼�¼*******************************/
	
	/**
	 * У��۳��ɽ������
	 * @param loanAmount�������
	 * @author ������ 2015-8-11
	 */
	public void checkServiceCharge(String loanAmount, String borrowerEmail){
		
		String row = "";                 //��ȡ������ˮ��
		String serviceCharge = "";       //�۳��ɽ������
		String uid = "";                 //�û�ID
		String loanAmountToMoney = "";   //��ʽ����Ľ����
		String tenderId = "";            //��ID
		String publishedDate = "";        //��ǰ��ķ���ʱ��ĺ�����
		String realdate = "";            //ʵ�ʻ���ʱ��
		String cdate = "";               //Ӧ����ʱ��
		boolean isConform = false;		 //�Ƿ����
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		loanAmountToMoney = base.stringToMoney(loanAmount);
		//��ȡ������ˮ��
		row = base.getElementTextWithWait(By.xpath("//td[text()='" + loanAmountToMoney +"']/parent::tr/td[2]"));System.out.println("������ˮ��:" + row);//--------����
		//�۳��ɽ������
		serviceCharge = base.getElementTextWithWait(By.xpath("//td[text()='" + row + "']/following-sibling::td[text()='�۳��ɽ������']/parent::tr/td[4]"));System.out.println("�۳��ɽ������:" + serviceCharge);//--------����
		//��ȡ�û�ID
		uid = dbData.getUID(borrowerEmail);
		//��ȡ6�ڡ��ѻ�����������
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
			System.out.println("�۳��ɽ�����ѣ�0.0325%" );
			assertServiceCharge(loanAmount, serviceCharge, 0.0325);
		}
		else{
			System.out.println("�۳��ɽ�����ѣ�0.055%" );
			assertServiceCharge(loanAmount, serviceCharge, 0.055);
		}
	}
	
	/**
	 * ���۳��ɽ������
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
	 * ����״̬��Ϊ�����ڻ��
	 * @param borrowerEmail�����������
	 * @param overdueDay:��������
	 */
	public void updateRealDate(String borrowerEmail, String overdueDay){
		
		String tenderId = "";            //��ID
		String uid = "";                 //�û�ID
		boolean isTrue = false;
		
		//��ȡ�û�ID
		uid = dbData.getUID(borrowerEmail);
		//��ȡ���µı�ID
		tenderId = dbData.getTenderId(uid);System.out.println("��ID��" + tenderId);//------------����
		//����״̬��Ϊ�����ڻ��
		isTrue = dbData.updateRealDate(tenderId, overdueDay);
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
	}
	
	/**
	 * �޸��Ż�״̬����Ϊ1�������Ż�
	 * @param borrowerEmail�����������
	 * @author ������ 2015-8-19
	 */
	public void updatePreferentialState(String borrowerEmail){
		
		String tenderId = "";            //��ID
		String uid = "";                 //�û�ID
		boolean isTrue = false;
		
		//��ȡ�û�ID
		uid = dbData.getUID(borrowerEmail);
		//��ȡ���µı�ID
		tenderId = dbData.getTenderId(uid);System.out.println("��ID��" + tenderId);//------------����
		//�޸��Ż�״̬
		isTrue = dbData.updatePreferentialState(tenderId);
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
	}
	
	/**
	 * �޸ġ��������ڡ�
	 * @param borrowerEmail�����������
	 * @param amount�������
	 * @param publishedDate:��ķ�������������Ӧ����
	 * @author ������ 
	 */
	public void updatePublishedDate(String borrowerEmail, String amount, String publishedDate){
		
		String oldTenderId = "";            //��ID
		String newTenderId = "";            //��ID
		String uid = "";                 	//�û�ID
		boolean isTrue = false;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		//��ȡ�û�ID
		uid = dbData.getUID(borrowerEmail);
		//���ҵ�ǰ���ID
		newTenderId = dbData.getTenderId(uid, amount);
		System.out.println("��ǰ��ID: " + newTenderId);
		//�����ϴλ�����ID
		hashMap = dbData.getD_TenderTable(uid);
		if(!hashMap.isEmpty()){
			oldTenderId = hashMap.get("tenderId");
			System.out.println("�ϴλ����ID: " + oldTenderId);
			isTrue = dbData.updatePublishedDate(oldTenderId, newTenderId, publishedDate);
			base.assertEqualsActualExpectedByBoolean(isTrue, true);
		}
		else{
			System.out.println("error_û���ϴν��ı�");
		}
	}
	
}



















