package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;

/**
 * Ͷ���б�����ҳ
 */
public class InvestmentDetailPage {
	
	Base base = new Base();
	
	/*************************/
	/******   �������       *******/
	/*************************/
	
	public static By StatusBar = By.cssSelector("div.wrap>div.ld_leftpart>div.ld_status");		//���ϲ��״̬��
	public static By BidFullTime = By.xpath("//p[2]/span[2]");									//����������ʱ��
	
	/*************************/
	/******   ������Ϣ       *******/
	/*************************/
	
	public static By BorrowType = By.cssSelector("h2.mt10");									//������ͼ�Ŀ�ģ������⣩
	public static By UserName = By.cssSelector("div.ld_user.fl>p>a");							//ͼƬ�µ��û���
	By ReportLnk = By.cssSelector("li.alert>a");												//"�ٱ�����"����
	By JoinBlacklistLnk = By.cssSelector("li.blankList>a");										//"���������"����
	
	//�ٱ�����
	By ReportTitle = By.xpath("//div[@id='out_all2']/div/div/span");							//���ٱ�������
	By OKReportBtn = By.xpath("//form[@id='reportForm']/div[3]/button");						//ȷ���ٱ�
	By CancelReportBtn = By.xpath("//form[@id='reportForm']/div[3]/button[2]");					//ȡ���ٱ�	
	By SelectReportType = By.id("reportType");													//���ٱ����͡�������
	By InputDescription = By.id("description");													//������Ϣ 
	
	//�����������������
	By JoinBlacklistTitle = By.xpath("//div[@id='out_all']/div/div/span");						//�����������������
	By CancelJoinBlacklistBtn = By.xpath("//form[@id='blackForm']/div[3]/button[2]");			//ȡ�����������
	By OKJoinBlacklistBtn = By.xpath("//form[@id='blackForm']/div[3]/button");					//ȷ�����������
	By InputSetReason = By.id("blackreason");													//�ڡ�����д�������ɡ�������
	
	//��Ǯ����
	By InvestLnk = By.cssSelector("input.ld_btn.mt25.fl");//����Ǯ������
	By InvestWindow = By.id("fastLender_1");
	By AutoInputLnk = By.cssSelector("a.ml10");
	By InputPayPwd = By.id("paypassowrd");
	By yanZhengMaImg = By.cssSelector("#checkverificationCode_fast>a>img");
	By InputValidateCode = By.id("tenderRecordRandCode");
	By OKBtn = By.cssSelector("input.f_m_Confirm.ml20");
	By CloseInvestResultLnk = By.cssSelector("div.newFMBox-tit>a.close");//�ر�Ͷ�ʳɹ���Ͷ��ʧ�ܵĴ���
	By InvestSuccessTip = By.id("tenderOK");
	By InvestFailTip = By.id("errorMsg");
	
	/*************************/
	/********   Tab  *********/
	/*************************/
	
	/*************************/
	/*******   ������Ϣ     ********/
	/*************************/
	
	public static By BorrowDescription = By.id("borrowdetail");									//�������
	
	/*************************/
	/*******   ��������     ********/
	/*************************/
	
	/*************************/
	/*******   ��������     ********/
	/*************************/
	
	/*************************/
	/*******   ��ʷͳ��     ********/
	/*************************/
	
	/*************************/
	/*******   ������Ϣ     ********/
	/*************************/
	
	By materialImgNum = By.cssSelector(".imgListNum");								//������Ϣ_ͼƬ��ʾ����(��3��)
	By materialImg = By.cssSelector(".imgList>a>img");								//������Ϣ_ͼƬ(��3��)
	By materialBtn = By.cssSelector(".materialsBtn");								//������Ϣ_ͼƬ��ť(��3��)
	By materialPictureDIV = By.cssSelector(".ui-dialog.ui-widget"
			+ ".ui-widget-content.ui-corner-all.ui-draggable.ui-resizable");		//������Ϣ_ͼƬ�����
	By materialPictureTitle = By.cssSelector("#ui-dialog-title-showPubDataDiv");	//������Ϣ_ͼƬ�����_Title
	By materialPictureClose = By.cssSelector(".ui-icon.ui-icon-closethick");		//������Ϣ_ͼƬ�����_���Ͻ�X��ť
	By materialPictureCloseBtn = By.cssSelector(".ui-button.ui-widget"
			+ ".ui-state-default.ui-corner-all.ui-button-text-only.ui-state-hover");//������Ϣ_ͼƬ�����_�رհ�ť		

	/*************************/
	/*******   ��ѯ��¼     ********/
	/*************************/
	
	//������ٱ����ˡ�����
	public void clickReportLnk(){
		base.clickWithWait(ReportLnk);
		base.checkElmentText(ReportTitle, "�ٱ�");
	}
	//�ڡ��ٱ������ڵ����ȡ�����ٱ�
	public void clickCancelReportBtn(){
		base.clickWithWait(CancelReportBtn);
		base.checkNoElement(ReportTitle);
	}
	//�ڡ��ٱ�������ѡ�񡰾ٱ����͡�
	public String selectReportType(String type){
		base.elementSelectByVisibleText(SelectReportType, type);
		return type;
	}
	//�ڡ��ٱ�������ѡ��������Ϣ��
	public String inputDescription(){
		base.sendKeysWithWait(InputDescription, "Ͷ�ʴ��˱�������");
		return "Ͷ�ʴ��˱�������";
	}
	//�ڡ��ٱ������ڵ����ȷ�����ٱ�
	public String clickOKReportBtn(){
		base.clickWithWait(OKReportBtn);
		base.getAlertwithWait();
		if(base.getTextByAlert().equals("�����Ѿ������ٱ����ˣ�����������ɣ�")){
			base.acceptAlert();
			System.out.println("�����Ѿ������ٱ�����!");
			Reporter.log("�����Ѿ������ٱ�����!");
			return null;
		}else{
			base.checkAlertText("��ӳɹ���");
			return base.dateFormat(base.getTime(), "yyyy-MM-dd");
		}
	}
	
	//��������������������
	public void clickJoinBlacklistLnk(){
		base.clickWithWait(JoinBlacklistLnk);
		base.checkElmentText(JoinBlacklistTitle, "���������");
	}
	//�ڡ���������������ڵ����ȡ�����ٱ�
	public void clickCancelJoinBlacklistBtn(){
		base.clickWithWait(CancelJoinBlacklistBtn);
		base.checkNoElement(JoinBlacklistTitle);
	}
	//�ڡ�������������������롰�������� ��
	public String InputSetReason(){
		base.sendKeysWithWait(InputSetReason, "���û��������ò���");
		return "���û��������ò���";
	}
	//�ڡ���������������ڵ����ȷ�������������
	public String clickOkJoinBlacklistBtn(boolean acceptNextAlert){
		base.clickWithWait(OKJoinBlacklistBtn);
		base.assertEqualsActualExpected(base.getAlertwithWait().getText(), "��ȷ��Ҫ�����û���ӵ����ĺ���������?");
		if(acceptNextAlert){
			base.acceptAlert();
			base.getAlertwithWait();
			if(base.getTextByAlert().equals("�ܱ�Ǹ�����û��Ѿ������ĺ��������ˣ�")){
				base.acceptAlert();
				base.openBrowser(new MyAccountPage().MyAccountUrl);
				System.out.println("���û��Ѿ������ĺ��������ˣ�");
				Reporter.log("<br/>���û��Ѿ������ĺ��������ˣ�");
				return null;
			}else{
				base.checkAlertText("��������ӵ����ĺ������ɹ���");
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
			System.out.println("��Ͷ����");
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
			Assert.fail("�������! "+ErrorTxt);
		}else{
			base.assertEqualsActualExpected(base.getElementTextWithWait(InvestSuccessTip), "Ͷ��ɹ�");
			clickCloseInvestResultLnk();
			base.closeWebDriver();
		}
	}
	
	/*************************/
	/********   Tab  *********/
	/*************************/
	
	/**
	 * ��ȡҳ��Tab(������Ϣ���������ϡ�����/�����ʷͳ�ơ�������Ϣ)
	 * @param name Tab����
	 * @return tab����
	 * @author ������ 2016-2-3
	 */
	public By getTab(String name){
		String num = "";
		switch (name) {
		case "������Ϣ":	num = "1";		break;
		case "��������":	num = "2";		break;
		case "����/����":	num = "3";		break;
		case "��ʷͳ��":	num = "4";		break;
		case "������Ϣ":	num = "5";		break;
		default:		num = "1";		break;
		}
		return By.cssSelector(".records.bgFF.pdt10.mt20 > span:nth-child(" + num + ")");
	}
	
	public void checkClickedTab(String name){
		String num = "";
		By by;
		switch (name) {
		case "������Ϣ":	num = "1";		break;
		case "��������":	num = "2";		break;
		case "����/����":	num = "3";		break;
		case "��ʷͳ��":	num = "4";		break;
		case "������Ϣ":	num = "5";		break;
		default:		num = "1";		break;
		}
		if(name.equals("������Ϣ")){
			by = By.cssSelector(".records.bgFF.pdt10.mt20 > span:nth-child(" + num + ")");
		}
		else{
			by = By.cssSelector(".records.bgFF.pdt10.fixed > span:nth-child(" + num + ")");
		}
		base.isElementContainsValue2(by, "class", "current");
	}
	
	/**
	 * ���ҳ��Tab
	 * @param name Tab����
	 * @author ������ 2016-2-3
	 */
	public void clickTab(String name){
		By by = getTab(name);
		base.clickWithWait(by);
		checkClickedTab(name);
	}
	
	/*************************/
	/*******   ������Ϣ     ********/
	/*************************/
	
	/**
	 * У�������ϢͼƬ�����Ƿ�С�ڵ���1
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
