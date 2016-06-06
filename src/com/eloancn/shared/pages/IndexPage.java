package com.eloancn.shared.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;

/**
 * ��ҳ
 */
public class IndexPage {

	Base base = new Base();
	Data data = new Data();

	RegisterPage registerPage = new RegisterPage();
	InvestmentDetailPage investmentDetailPage = new InvestmentDetailPage();
	
	public By registerLinkXpath = By.cssSelector("#login_2 > a");//By.xpath("//a[text()='ע��']");
	//��ҳ�ĵ������������Ĺ�����е����ע�ᰴť
	By freeRegisterBtn = By.cssSelector(".regLoading_btn.fl");
	By loginBtn = By.cssSelector("#login_1 > a");  //#login_1 > a   #login_1>.colorFc
	public static By userName = By.id("accountRealName");
	By joinIn = By.xpath("//li/a[text()='���̺���']");						//��Ҫ����
	By forumLink = By.xpath("//a[text()='��̳']");						//��̳
	
	/******************************/
	/*********   ��������        **********/
	/******************************/
	
	By credit = By.cssSelector("#load > a");										//��Ҫ����
	By eCuBao = By.cssSelector("#load > ul > li:nth-child(1) > a");					//��汦
	By eStarPlan = By.cssSelector("#load > ul > li:nth-child(2) > a");				//���Ǽƻ�
	By investmentList = By.cssSelector("#load > ul > li:nth-child(3) > a");			//ɢ���б�
	By howLending = By.cssSelector("#load > ul > li:nth-child(4) > a");				//��δ���
	By toolBox = By.cssSelector("#load > ul > li:nth-child(5) > a");				//������
	
	By debit = By.cssSelector("#loan > a");											//��Ҫ����
	By borrow = By.cssSelector("#loan > ul > li:nth-child(1) >a");					//�������
	By howBorrow = By.cssSelector("#loan > ul > li:nth-child(2) >a");				//��ν���
	By welfareLoan = By.cssSelector("#loan > ul > li:nth-child(3) >a");				//�����	
	
	By noviceArea = By.cssSelector("#newUserLink");									//����ר��
	
	By debentureTransfer = By.cssSelector("#loadAll > a");							//ծȨת��
	By transferList = By.cssSelector("#loadAll > ul > li:nth-child(1) > a");		//ת���б�
	By howTransfer = By.cssSelector("#loadAll > ul > li:nth-child(2) > a");			//���ת��
	
	By aboutUs = By.cssSelector("#about > a");											//��������
	By aboutUsContent = By.cssSelector("#contentPanel span.wd110");
	By companyIntroduction = By.cssSelector("#about > ul > li:nth-child(1) > a");		//��˾����
	By companyIntroductionContent = By.cssSelector("#contentPanel span.wd110");
	By leaderIntroduction = By.cssSelector("#about > ul > li:nth-child(2) > a");		//�쵼����
	By leaderIntroductionContent = By.cssSelector("#contentPanel span.wd110");
	By companyPhilosophy = By.cssSelector("#about > ul > li:nth-child(3) > a");			//��˾����
	By companyPhilosophyContent = By.cssSelector("#contentPanel div:nth-child(1) span");
	By recruit = By.cssSelector("#about > ul > li:nth-child(4) > a");					//������ʿ
	By recruitContent = By.cssSelector("#contentPanel span.wd110");
	By contactUs = By.cssSelector("#about > ul > li:nth-child(5) > a");					//��ϵ����
	By contactUsContent = By.cssSelector("#contentPanel span.wd110");
	
	By myAccount = By.cssSelector("#about ~ li >a");						//�ҵ��˻�
	By myAccountBtn = By.xpath("//li/a[text()='�ҵ��˻�']");					//�ҵ��˻�
	
	/******************************/
	/********    banner   *********/
	/******************************/


	
	/******************************/
	/********    �ջݽ���           *********/
	/******************************/
	
	By financeImg = By.cssSelector(".wrap.overflowV > div:nth-child(1) div.phjr_img");	//�ջݽ���_ͼƬ
	By financeInfo = By.cssSelector(".wrap.overflowV div.phjr_info1.bgf60");			//�ջݽ���_����
	
	By profitImg = By.cssSelector(".wrap.overflowV > div:nth-child(2) div.phjr_img");	//����ɹ�ͼƬ
	By profitInfo = By.cssSelector(".wrap.overflowV div.phjr_info.bge2");				//����ɹ�����
	
	By securityImg = By.cssSelector(".wrap.overflowV > div:nth-child(3) div.phjr_img");	//��ȫ����ͼƬ
	By securityInfo = By.cssSelector(".wrap.overflowV div.phjr_info.bg40");				//��ȫ��������
	
	By patternImg = By.cssSelector(".wrap.overflowV > div:nth-child(4) div.phjr_img");	//ͬ��ģʽͼƬ
	By patternInfo = By.cssSelector(".wrap.overflowV div.phjr_info1.bg7c");				//ͬ��ģʽ����
	
	By brandImg = By.cssSelector(".wrap.overflowV > div:nth-child(5) div.phjr_img");	//Ʒ��Ȩ��ͼƬ
	By brandInfo = By.cssSelector(".wrap.overflowV div.phjr_info1.bgf30");				//Ʒ��Ȩ������
	
	/******************************/
	/********    ���������       *********/
	/******************************/
	
	By incomeCalculatorBtn = By.xpath("//a[text()='���������']");									//���������
	By incomeCalculatorH1 = By.xpath("//div[@class='count-tit']//h1");							//�������������Title
	By investmentMoneyTxt = By.xpath("//th[@class='wd80']/parent::tr//input[@name='money']");	//Ͷ�ʽ��
	By annualInterestRateTxt = By.xpath("//input[@name='rate']");								//������
	By investmentPeriodTxt = By.xpath("//input[@name='phases']");								//Ͷ������
	By repaymentDrop = By.xpath("//select[@name='type']");										//���ʽ
	By showScheduleChk = By.xpath("//input[@id='intercheck']");									//��ʾ�ƻ�ʱ���
	By immediatelyCalculateBtn = By.xpath("//a[text()='���ϼ���']");								//���ϼ���
	//����ȡ��Ϣ 
	String monthlyInterest = "";
	By monthlyInterestTxt = By.xpath("//td[text()='" + monthlyInterest + "]/parent::tr//td[3]");
	//����ȡ�ܶ�
	String monthlyTotal  = "";
	By monthlyTotalTxt = By.xpath("//td[text()='" + monthlyInterest + "]/parent::tr//td[5]");
	
	/******************************/
	/***    ��汦_ɢ��Ͷ��_���Ǽƻ�          ***/
	/******************************/
	
	By productTitle = By.cssSelector(".index_part_title>h2");		//Title(��汦��ɢ��Ͷ�ʣ����Ǽƻ�)
	By productMoreLink = By.cssSelector(".hFP_index_more>a");		//�鿴����(�鿴������汦��Ŀ���鿴����ɢ����Ŀ���鿴�������Ǽƻ���Ŀ)
	By productTable = By.cssSelector(".index_table > tbody"); 		//���ݱ��
	
	/******************************/
	/********     ��汦            *********/
	/******************************/
	
	By loginTitle = By.xpath("//span[@class='fl font20']");														//��¼���ڱ���
	By closeBtn = By.xpath("//a[@class='close']");																//��¼���ڹرհ�ť
	
	/******************************/
	/******   ��汦_��һ������       *******/
	/******************************/
	
	By eCunBaoDataHomeId = By.xpath("//div[@class='hFP_count_idx fontW']/input");								//��汦��1������_id
	By eCunBaoDataHomeTitleOne = By.xpath("//div[@class='font30 fontW fl overflowV']/span");					//��汦��1������_�����⡱(���磺��3785�ڣ�)
	By eCunBaoDataHomeAnnualReturnsOne = By.xpath("//span[@id='realvipInterestrate']");							//��汦��1������_���껯���桱
	By eCunBaoDataHomeContractTermOne  = By.xpath("//p[@class='lineT colorFF font20']/span[@class='wd120']");	//��汦��1������_����ͬ���ޡ�
	By eCunBaoDataHomeRaiseMoneyOne = By.xpath("//p[@class='lineT colorFF font20']/span[@class='wd150']");		//��汦��1������_����ļ����
	By eCunBaoDataHomeRaiseTotalMoneyOne = By.xpath("//p[@class='lineT colorFF font20']/span[4]");				//��汦��1������_����ļ����
	By eCunBaoDataHomeZhaiQuanOne = By.cssSelector(".hFPHead.mt30.overflowV>a");								//��汦��1������_��ծȨ���顱
	By redEnvelopesLink = By.xpath("//div[@class='hF-red-paper hF-red-paper_index']/a");						//��汦��1������_�����ң�������֡�
	By InvestmentBtn = By.xpath("//span[@class='hFP_btn_idx']/a");												//��汦��1������_������Ͷ�ʡ���ť
	
	
	/******************************/
	/*****   ��汦_��2~4������        ******/
	/******************************/
	
	By eCunBaoHomeTable = By.xpath("//div[text()='��汦']/parent::div/parent::div/following-sibling::table[1]");	//��汦��2~4������_���ݱ��
	By eCunBaoDataTFBondLink = By.xpath("//span[text()='ծȨ']");													//��汦��2~4������_���С�ծȨ������
	By touYiBiLink = By.xpath("//table[1]//td[@class='hFP_index_more']/parent::tr/preceding-sibling::tr//a[text()='Ͷһ��']");
	
	/******************************/
	/******    ��汦_�鿴����           ******/
	/******************************/

	By moreLink = By.xpath("//td[@class='hFP_index_more']/a");													//���鿴������汦��Ŀ�� ����
	
	
	/******************************/
	/****    ��汦_Ͷ�ʽ���            *****/
	/******************************/
	
	By investmentDiv = By.cssSelector("#fastLender_1");										//Ͷ�ʽ���
	By buyBalance = By.cssSelector("#userBalance"); 										//Ͷ�ʽ���_�������
	By investmentBondDetails = By.cssSelector(".fr.zqbtn.font14");							//Ͷ�ʽ���_��ծȨ���顱����
	By investmentRechargeBtn = By.cssSelector(".fr.hFP_cz.mt2");							//Ͷ�ʽ���_����ֵ����ť
	By buyShareTxt = By.id("wmpsYuGouAmount");												//Ͷ�ʽ���_������ݶ�ı���
	By payPwdTxt = By.cssSelector("#payPwd");												//Ͷ�ʽ���_��֧�����롱�ı���
	By eCunBaoProtocolAgreeChk = By.id("xy");												//Ͷ�ʽ���_�����������߾Ӽ����Э�顱��ѡ��
	By eCunBaoProtocol = By.cssSelector(".mt15.textC.font14>a");							//Ͷ�ʽ���_�������Ķ���ͬ�⡶���������߾Ӽ����Э�顷������
	By verificationCodeImg = By.xpath("//span[@id='checkverificationCode_fast']/a/img");	//Ͷ�ʽ���_����֤�롱ͼƬ
	By verificationCodeTxt = By.id("wmpsRandCode");											//Ͷ�ʽ���_����֤�롱�ı���  
	By investmentOKBtn = By.xpath("//input[@class='hFP_Ok ml35']");							//Ͷ�ʽ���_��ȷ�ϡ���ť
	By investmentCloseBtn = By.cssSelector("div#fastLender_1 .close.fr");  					//Ͷ�ʽ���_���رա���ť


	/******************************/
	/******    ��汦_ծȨ����           ******/
	/******************************/
	
	By eCBBondDetailsDIV = By.cssSelector("#messageBoxCard");									//ծȨ����_����
	By eCBBondDetailsDIVTitle = By.cssSelector("#saveTitle");									//ծȨ����_����_Title
	By eCBBondDetailsDIVColumnName = By.cssSelector("#detailstable>thead>tr>th");				//ծȨ����_����_����(�����������⡢��������������֤�š�����˵���������ܶ����)
	By eCBBondDetailsDIVInfo = By.cssSelector("#tenderBody .font14.color6>td");					//ծȨ����_����_��Ϣ(�����������⡢��������������֤�š�����˵���������ܶ�)
	By eCBBondDetailsDIVBtn = By.cssSelector(".xqbtn");											//ծȨ����_����_���С��鿴���顱��ť
	By eCBBondDetailsSeeDIV = By.cssSelector("#xq_content");									//ծȨ����_����_�鿴����_����
	By eCBBondDetailsDIVTab = By.cssSelector(".xq_content_t");									//ծȨ����_����_�鿴����_����Tab��ť
	By eCBBondDetailsDIVClose = By.cssSelector(".tip_close");									//ծȨ����_����_�鿴����_�رհ�ť
	
	/******************************/
	/**********   ɢ��Ͷ��        *********/
	/******************************/
	
	By sbColumnName = By.cssSelector(".index_table>tbody>tr>th");		//ɢ��Ͷ�ʱ���
	
	/******************************/
	/**********   ���Ǽƻ�        *********/
	/******************************/
	
	By eStarPlanTalbe = By.xpath("//div[text()='��汦']/parent::div/parent::div/following-sibling::table[2]");	//���Ǽƻ����ݱ��
	
	/******************************/
	/********    β��������       *********/
	/******************************/
	
	By joinInOfBottom = By.xpath("//p/a[text()='���̺���']");		//���̺���

	//����������Ķ���ͬ�⡶��汦Ͷ��Э�顷��
	public void clickECunBaoProtocol(){
		base.clickWithWait(eCunBaoProtocol);
	}
	
	//�رա�Ͷ�ʽ�����
	public void clickInvestmentCloseBtn(){
		base.clickWithWait(investmentCloseBtn);
		base.isElementContainsValue(investmentDiv, "style", "none");
	}
	
	//��֤�������Ķ���ͬ�⡶��汦Ͷ��Э�顷��
	public void checkECunBaoProtocol(){
		clickECunBaoProtocol();
		if(base.gethandelsNum() > 1){
			base.jumpToNewWindow();
		}
		base.assertEqualsActualExpectedByBoolean(base.isTitleContains(PageTitles.yiCunBaoTouZiXieYi), true);//"��汦Ͷ��Э��"
		base.turnToNewPage();
	}
	
	//����Ƿ��¼
	public void checkLogout(){
		registerPage.logout();
	}
	
	//�����ע�ᡱ����
	public void clickRegisterLink(){
		base.clickElementNoWait(registerLinkXpath);
	}
	//�������¼������
	public void clickLoginLink(){
		boolean isShow = false;
		int count = 0;
		do{
			base.clickElementByVisible(loginBtn);
			if(base.isElementPresenceNoWait(By.id("loginBoxFrame"))){
				base.switchToFrame("loginBoxFrame");
			}
			isShow  = base.isElementVisible(By.cssSelector("#loginName"), 20);
			System.out.println("�Ƿ����" + isShow);
//			base.fromFrameToDefaultContent();
			if(!isShow){
				base.refreshPage();
				base.isTitleContains(PageTitles.shouYe);
				count += 1;
			}
			System.out.println("ִ�д���:" + count);
		}while(!isShow && count < 3);
		//�رյ����հ�ҳ
		System.out.println("��¼��"+base.gethandelsNum());
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
	}
	
	/**
	 * �������Ҫ���ˡ�
	 */
	public void clickJoinIn(){
		base.clickWithWait(joinIn);
		base.isTitle(PageTitles.zhaoShangHeZuo);
	}
	
	/************����_����*************/
	
	//�������Ҫ����������
	public void clickCreditLink(){
		base.clickWithWait(credit);
	}
	//�����ͣ����Ҫ���������������汦������
	public void clickECuBaoLink(){
		base.mouseToElement(credit);
		base.clickWithWait(eCuBao);
	}
	//�����ͣ����Ҫ����������������Ǽƻ�������
	public void clickEStarPlanLink(){
		base.mouseToElement(credit);
		base.clickWithWait(eStarPlan);
		if(base.Windowsize()!=1){
			base.turnToNewPage();
		}	
	}
	//�����ͣ����Ҫ�������������Ͷ���б�����
	public void clickInvestmentListLink(){
		base.mouseToElement(credit);
		base.clickWithWait(investmentList);
	}
	//�����ͣ����Ҫ���������������δ���������
	public void clickHowLendingLink(){
		base.mouseToElement(credit);
		base.clickWithWait(howLending);
	}
	//�����ͣ����Ҫ������������������䡱����
	public void clickToolBoxLink(){
		base.mouseToElement(credit);
		base.clickWithWait(toolBox);
	}

	//�������Ҫ���롱����
	public void clickDebitLink(){
		base.clickWithWait(debit);
	}
	//�����ͣ����Ҫ���롱�������������롱����
	public void clickBorrowLink(){
		base.mouseToElement(debit);
		base.clickWithWait(borrow);
	}
	//�����ͣ����Ҫ���롱���������ν��롱����
	public void clickHowBorrowLink(){
		base.mouseToElement(debit);
		base.clickWithWait(howBorrow);
	}
	//�����ͣ����Ҫ���롱������������������
	public void clickWelfareLoanLink(){
		base.mouseToElement(debit);
		base.clickWithWait(welfareLoan);
	}
	
	//���������ר��������
	public void clickNoviceAreaLink(){
		base.clickWithWait(noviceArea);
	}
	
	//�����ծȨת�á�����
	public void clickDebentureTransferLink(){
		base.clickWithWait(debentureTransfer);
		if(base.Windowsize()>1){
			base.turnToNewPage();
		}	
	}
	//�����ͣ��ծȨת�á��������ת���б�����
	public void clicktransferListLink(){
		base.mouseToElement(debentureTransfer);
		base.clickWithWait(transferList);
	}
	//�����ͣ��ծȨת�á�����������ת�á�����
	public void clickHowTransferLink(){
		base.mouseToElement(debentureTransfer);
		base.clickWithWait(howTransfer);
	}
	
	//������������ǡ�����
	public void clickAboutUsLink(){
		base.clickWithWait(aboutUs);
	}
	//�����ͣ���������ǡ����������˾���ܡ�����
	public void clickCompanyIntroductionLink(){
		base.mouseToElement(aboutUs);
		base.clickWithWait(companyIntroduction);
	}
	//�����ͣ���������ǡ���������쵼���ܡ�����
	public void clickLeaderIntroductionLink(){
		base.mouseToElement(aboutUs);
		base.clickWithWait(leaderIntroduction);
	}
	//�����ͣ���������ǡ����������˾�������
	public void clickCompanyPhilosophyLink(){
		base.mouseToElement(aboutUs);
		base.clickWithWait(companyPhilosophy);
	}
	//�����ͣ���������ǡ��������������ʿ������
	public void clickRecruitLink(){
		base.mouseToElement(aboutUs);
		base.clickWithWait(recruit);
	}
	//�����ͣ���������ǡ����������ϵ���ǡ�����
	public void clickContactUsLink(){
		base.mouseToElement(aboutUs);
		base.clickWithWait(contactUs);
	}
	
	//������ҵ��˻�������
	public void clickMyAccountLink(){
		base.clickWithWait(myAccount);
	}
	
	//������������������ť
	public void clickIncomeCalculatorBtn(){
		base.clickWithWait(incomeCalculatorBtn);
	}
	//���롰Ͷ�ʽ�
	public void sendKeyInvestmentMoneyTxt(String value){
		base.elementSendkey(investmentMoneyTxt, value);
	}
	//���롰�����ʡ�
	public void sendKeyAnnualInterestRateTxt(String value){
		base.elementSendkey(annualInterestRateTxt, value);
	}
	//���롰Ͷ�����ޡ�
	public void sendKeyInvestmentPeriodTxt(String value){
		base.elementSendkey(investmentPeriodTxt, value);
	}
	//��ѡ����ʾ�ƻ�ʱ���
	public void clickShowScheduleChk(){
		base.clickWithWait(showScheduleChk);
	}
	//��������ϼ��㡱��ť
	public void clickImmediatelyCalculateBtn(){
		base.clickWithWait(immediatelyCalculateBtn);
	}
	
//	/**
//	 * ��� ��������ܰ��ʾ������Title
//	 */
//	public void checkPromptTitle(){
//		base.assertEqualsActualExpected(base.getElementText(By.xpath("//h2[@class='u-tt']")), "��ܰ��ʾ");
//		base.clickElementNoWait(By.xpath("//div[@class='lytt']/a"));
//	}
	
	//��ҳ����
	//eCuBao,eStarPlan,investmentList,howLending,toolBox,debit,borrow,howBorrow,welfareLoan,noviceArea,debentureTransfer,transferList,howTransfer,aboutUs,aboutUsContent,companyIntroduction,leaderIntroduction,leaderIntroductionContent,companyPhilosophy,companyPhilosophyContent,recruit,recruitContent,contactUs,contactUsContent,myAccount
	
	public String getBannerHref(By by){
		String bannerHref = base.getLnkElementText(by, "href");
		if(!bannerHref.contains("http://")){
			bannerHref = base.indexURL + bannerHref;
		}
		return bannerHref;
	}
	
	/**
	 * ����Ԫ
	 * ��ҳ����������̳
	 * @param modelName ģ������
	 */
	public void linkToForum(String modelName){
		System.out.println(modelName + "begin...");
		clickMenu(modelName);
		base.assertNotNullBy(forumLink);
		base.clickWithWait(forumLink);
		System.out.println(modelName + "end...");
	}
	
	/**
	 * ����Ԫ
	 * ����̳ҳ
	 */
	public void goToForm(){
		base.clickWithWait(forumLink);
	}
	
	/**
	 * ���������Ӧģ��
	 * @author ����Ԫ
	 * @�޸�  ������ 2016-3-15
	 */
	public void clickMenu(String modelName){
		if(modelName.equals("��Ҫ����") || modelName.equals("��汦") || modelName.equals("���Ǽƻ�") || modelName.equals("ɢ���б�") || modelName.equals("��δ���") || modelName.equals("������")){
			base.mouseToElement(credit);
		}else if(modelName.equals("��Ҫ����") || modelName.equals("�������") || modelName.equals("��ν���") || modelName.equals("�����")){
			base.mouseToElement(debit);
		}else if(modelName.equals("����ר��")){
			base.mouseToElement(noviceArea);
		}else if(modelName.equals("ծȨת��") || modelName.equals("ת���б�") || modelName.equals("���ת��")){
			base.mouseToElement(debentureTransfer);
		}else if(modelName.equals("��������") || modelName.equals("��˾����") || modelName.equals("�쵼����") || modelName.equals("��˾����") || modelName.equals("������ʿ") || modelName.equals("��ϵ����")){
			base.mouseToElement(aboutUs);
		}
		base.clickWithWait(By.xpath("//div[@class='menu fr']//a[text()='" + modelName + "']"));
		if(modelName.equals("������")){
			base.closeAndjumptoOldWindow();
		}
	}
	
	/**
	 * ����Ԫ
	 * �ж��Ƿ���ת����ҳ   
	 */
	public void isturnToIndexPage(){
		base.assertEqualsActualExpected(base.getPageTitle(), PageTitles.shouYe);
	}
	
	/**
	 * ����Ԫ
	 * ��ҳ�ĵ������������Ĺ�����е����ע�ᰴť
	 */
	public void clickFreeRegister(){
		base.clickWithWait(freeRegisterBtn);
	}
	
	/********************************************/
	/****************   ���������       ****************/
	/********************************************/
	
	//���ء�����ȡ��Ϣ��Ԫ�� 
	public By getMonthlyInterestTxtElement(String investmentPeriod){
		return By.xpath("//td[text()='" + investmentPeriod + "']/parent::tr//td[3]");
	}
	
	//���ء�����ȡ����Ԫ�� 
	public By getMonthlyPrincipalTxtElement(String investmentPeriod){
		return By.xpath("//td[text()='" + investmentPeriod + "']/parent::tr//td[4]");
	}
	
	//���ء�����ȡ�ܶԪ�� 
	public By getmonthlyTotalTxtElement(String investmentPeriod){
		return By.xpath("//td[text()='" + investmentPeriod + "']/parent::tr//td[5]");
	}
	
	/**
     * ����տ������
     * @param  InvestmentMoney(Ͷ�ʽ��)_1000, annualInterestRate(������)_20, investmentPeriod(Ͷ������)_24, repaymentDrop(���ʽ��)
     * @author ������ 2015-5-4
	 */
	public boolean checkReceivablesListData(String InvestmentMoney, String annualInterestRate, String investmentPeriod, String repaymentDrop){
		
		//����ȡ����
		double monthlyPrincipalDouble = -1;
		String monthlyPrincipalStr = "";
		//����ȡ��Ϣ
		double monthlyInterestDouble = -1;
		String monthlyInterestStr = "";
		//����ȡ�ܶ� 
		double monthlyTotalDouble = -1;
		String monthlyTotalStr = "";
		//ԭ�ַ���
		String originalString = "";
		//���滻�ַ�
		String ExcludeString = ",";
		//�滻�ַ�
		String replaceString = "";
		
		boolean isPass = true;
		
		//��ȡ������ȡ��Ϣ ����ֵ
		monthlyInterestStr = base.getElementText(getMonthlyInterestTxtElement(investmentPeriod));
		monthlyInterestDouble = Double.parseDouble(monthlyInterestStr);
//		System.out.println(monthlyInterestDouble);//-------------����
		
		//��ȡ������ȡ���𡱵�ֵ
		originalString = base.getElementText(getMonthlyPrincipalTxtElement(investmentPeriod));
		monthlyPrincipalStr = base.stringToReplace(originalString, ExcludeString, replaceString);
		monthlyPrincipalDouble =  Double.parseDouble(monthlyPrincipalStr);
//		System.out.println(monthlyPrincipalDouble);//-------------����
		
		//ҳ���ȡ������ȡ�ܶ��1,016.66
		originalString = base.getElementText(getmonthlyTotalTxtElement(investmentPeriod));
		//����1,016.66�� ת���ɡ�1016.66��
		monthlyTotalStr = base.stringToReplace(originalString, ExcludeString, replaceString);
		//�� String ת double
		monthlyTotalDouble = Double.parseDouble(monthlyTotalStr);
//		System.out.println(monthlyTotalDouble);//-------------����
		
		//���һ�ڵ� ������ȡ���� �� ��Ͷ�ʽ�� �� �Ƿ����
		if(!(InvestmentMoney.equals(monthlyPrincipalStr))){System.out.println("1");isPass = false;}
//		System.out.println("InvestmentMoney:" + InvestmentMoney);//-----------------------����
//		System.out.println("monthlyPrincipalStr:" + monthlyPrincipalStr);//-----------------------����
		
		//���һ�ڵġ�����ȡ��Ϣ ���Ƿ���ȷ
		Double InvestmentMoneyDouble = Double.parseDouble(InvestmentMoney);
		Double annualInterestRateDouble = Double.parseDouble(annualInterestRate);
//		System.out.println("InvestmentMoneyDouble:" + InvestmentMoneyDouble);//-----------------------����
//		System.out.println("annualInterestRateDouble:" + annualInterestRateDouble);//-----------------------����
//		System.out.println("���������" + base.setRound((InvestmentMoneyDouble * (annualInterestRateDouble * 0.01)) / 12, 2, true));//-----------------------����
		double monthlyInterestCalculationDouble = base.setRound((InvestmentMoneyDouble * (annualInterestRateDouble * 0.01)) / 12, 2, true);
		if((monthlyInterestDouble)!=(monthlyInterestCalculationDouble)){System.out.println("2");isPass = false;}
 		
 		//���һ�ڵġ�����ȡ�ܶ�Ƿ���ȷ
// 		System.out.println("monthlyTotalDouble:" + monthlyTotalDouble);//-----------------------����
// 		System.out.println("monthlyPrincipalDouble:" + monthlyPrincipalDouble);//-----------------------����
// 		System.out.println("monthlyInterestDouble:" + monthlyInterestDouble);//-----------------------����
		if((monthlyTotalDouble)!=(monthlyPrincipalDouble + monthlyInterestDouble)){System.out.println("3");isPass = false;}
 		
		return isPass;
	}
	
	/*****************************************/
	/****************  banner ****************/
	/*****************************************/
	
	/**
	 * ��ҳ��ͼ����
	 * @author ����Ԫ
	 * @�޸� ������
	 */
	public void isBannerOK(String[] banners){
		
		List<WebElement> numList = base.getElements(By.cssSelector("#yq_banner_list a"));	//����
		List<WebElement> imgList = base.getElements(By.cssSelector(".bannger_inbox>img"));	//ͼƬ
		int step = 0;
		Reporter.log("��"+numList.size()+"����ͼ"+"<br/>");
		System.out.println("��"+numList.size()+"����ͼ");
		for (int i = (numList.size() - 1); i >= 0; i--) {
			int j = i + 1;
			numList.get(i).click();//�������i,��ʾ��i����ͼ
			imgList.get(i).click();//�����i����ͼ
			if (base.gethandelsNum() == 2) {
				base.jumpToNewWindow();
				try {
					base.assertTrueByBoolean(base.isTitleContains(banners[i]));
					step += 1;
					Reporter.log("��" + j + "����ͼУ��ɹ�" + "<br/>");
					System.out.println("��" + j + "����ͼУ��ɹ�");
				} catch (AssertionError e) {
					Reporter.log("��" + j + "����ͼУ��ʧ��"+"<br/>");
					System.out.println("��" + j + "����ͼУ��ʧ��");
				}
				base.closeAndjumptoOldWindow();
			}
		}
		Assert.assertEquals(step, banners.length);
	}
	
	/*****************************************/
	/****************  �ջݽ���     ****************/
	/*****************************************/
	
	/**
	 * ��ȡ���ս���ͼƬԪ��
	 * @param name Ԫ������
	 * @return Ԫ�ض���
	 * @author ������ 2015-11-27
	 */
	public By getProjectIcon(String name){
		String icon = null;
		switch(name){
			case "���ս���": icon = "1"; break;
			case "����ɹ�": icon = "2"; break;
			case "��ȫ����": icon = "3"; break;
			case "ͬ��ģʽ": icon = "4"; break;
			case "Ʒ��Ȩ��": icon = "5"; break;
		}
		By iconBy = By.cssSelector(".icon" + icon);
		base.isElementVisible(iconBy);
		return iconBy;
	}
	
	/**
	 * ��ȡ���ս�������Ԫ��
	 * @param name Ԫ������
	 * @return Ԫ�ض���
	 * @author ������  2015-11-27
	 */
	public By getProjectInfo(String name){
		String info = null;
		switch(name){
		case "���ս���": info = "1.bgf60"; break;
		case "����ɹ�": info = ".bge2"; break;
		case "��ȫ����": info = ".bg40"; break;
		case "ͬ��ģʽ": info = "1.bg7c"; break;
		case "Ʒ��Ȩ��": info = "1.bgf30"; break;
	}
		By infoBy = By.cssSelector(".phjr_info" + info);
		base.isElementVisible(infoBy);
		return infoBy;
	}
	
	/**
	 * У����ս�����תTitle
	 * @param name Ԫ������
	 * @author ������ 2015-11-27
	 */
	public void checkProjectTitle(String name){
		String title = null;
		switch(name){
			case "���ս���": 
				title = PageTitles.huiPuJinRong;
				base.assertTrueByBoolean(base.isTitle(title));
				base.assertNotNullBy(By.xpath("//h2[text()='��ũ���ڷ�����ϵؽ������']"));
				break;
			case "����ɹ�": 
				title = PageTitles.shouYiKeGuan;
				base.assertTrueByBoolean(base.isTitle(title));
				base.assertNotNullBy(By.xpath("//h2[text()='����ɹ�']"));
				break;
			case "��ȫ����":
				title = PageTitles.anQuanBaoZhang;
				base.assertTrueByBoolean(base.isTitle(title));
				base.assertNotNullBy(By.xpath("//h3[text()='���汣��']"));
				break;
			case "ͬ��ģʽ":
				title = PageTitles.tongChengMoShi;
				base.assertTrueByBoolean(base.isTitle(title));
				base.assertNotNullBy(By.xpath("//h2[text()='ʲô��ͬ��O2Oģʽ��']"));
				break;
			case "Ʒ��Ȩ��": 
				title = PageTitles.pinPaiQuanWei;
				base.assertTrueByBoolean(base.isTitle(title));
				base.assertNotNullBy(By.xpath("//h2[text()='�������Ƽ���']"));
				break;
		}
		Reporter.log(title + "  У��ɹ���");
		System.out.println(title + "  У��ɹ���");
	}
	
	/**
	 * У����ս�����ת����
	 * @param name Ԫ������
	 * @author ������ 2015-11-27
	 */
	public void checkProjectLink(String name){
		
		By icon,info;
		String parentHandle,childHandle;
		icon = getProjectIcon(name);
		base.mouseToElement(icon);
		parentHandle = base.getCurrentWindowHandle();
		info = getProjectInfo(name);
		base.clickWithWait(info);
		childHandle = base.getChildWindowHandle2(parentHandle);
		base.jumpToWindow(childHandle);
		try {
			checkProjectTitle(name);
		} catch (AssertionError e) {
			base.jumpToWindow(parentHandle);
			System.out.println("error_���ս�����תTitle��֤����");
			Reporter.log("error_���ս�����תTitle��֤����");
			base.assertTrueByBoolean(false);
		}
		base.closeAndjumptoOldWindow();
	}
	
	/******************************/
	/***    ��汦_ɢ��Ͷ��_���Ǽƻ�          ***/
	/******************************/
	
	/**
	 * ��ҳ����ȡ��ƷTitle�����磺��汦��ɢ��Ͷ�ʡ����Ǽƻ���Ͷ��ר����
	 * @param productName ��Ʒ����
	 * @return Title����
	 * @author ������ 2016-2-24
	 */
	public By getProductTitle(String productName){
		return By.xpath("//h2[text()='" + productName + "']");
	}
	
	/**
	 * ��ҳ��У���Ʒ������ʽ
	 * @param productName ��Ʒ���ƣ����磺��汦��ɢ��Ͷ�ʡ����Ǽƻ���Ͷ��ר����
	 * @param styleName ��ʽ����
	 * @param styleValue ��ʽֵ
	 * @author ������ 2016-2-24
	 */
	public void checkProductTitleStyle(String productName, String styleName, String styleValue){
		base.checkCSSValue(getProductTitle(productName), styleName, styleValue);
	}
	
	public List<String> getTableDataOfRow(String name){
		List<WebElement> productTableList = base.getVisibleElements(productTable);
		List<WebElement> productTrList;
		List<WebElement> productTdList;
		List<WebElement> productSpanList;
		List<String> productValueList = new ArrayList<String>();
		
		if(name.equals("��汦")){
			
		}
		else if(name.equals("ɢ��Ͷ��")){
			productTrList = productTableList.get(1).findElements(By.tagName("tr"));
			for(int i = 0; i < productTrList.size(); i++){//1�����⣬���һ�����鿴����ɢ����Ŀ
				if(i != 0 || i != (productTrList.size() - 1)){
					productTdList = productTrList.get(i).findElements(By.tagName("td"));
					for(int j = 0; j < productTdList.size(); j++){
						if(j == 0 || j == (productTdList.size() - 1)){//0������ֵ��1���������һ������ťText
							productSpanList = productTdList.get(j).findElements(By.tagName("span"));
							for(int k = 0; k < productSpanList.size(); k++){
								productValueList.add(productSpanList.get(k).getText());
							}
						}
						else if(j == 1){
							productSpanList = productTdList.get(j).findElements(By.tagName("span"));
							for(int k = 0; k < 1; k++){//�ڶ���ֵΪ�գ����Բ�ȡֵ
								productValueList.add(productSpanList.get(k).getText());
							}
						}
						else{
							productValueList.add(productTdList.get(j).getText());
						}
					}
				}
			}
		}
		
		return productValueList;
	}
	
	/**
	 * ��ҳ����ȡ���鿴���ࡱ����
	 * @param linkName ��������
	 * @return ���鿴���ࡱ����
	 * @author ������ 2016-2-24
	 */
	public By getMoreLinkBy(String linkName){
		return By.xpath("//a[text()='�鿴����" + linkName + "��Ŀ']");
	}
	
	/**
	 * ��ҳ����ȡ���鿴���ࡱ����
	 * @param linkName ��������
	 * @return ���鿴���ࡱ����
	 * @author ������ 2016-2-3
	 */
	public WebElement getMoreLink(String linkName){
		List<WebElement> webList = base.getVisibleElements(productMoreLink);
		WebElement webElement;
		int index;
		switch (linkName) {
		case "��汦":	
					index = 0;
					webElement = webList.get(index);
					base.assertEqualsActualExpected(webElement.getText(), "�鿴������汦��Ŀ");
					break;
		case "ɢ��Ͷ��":	
					index = 1;
					webElement = webList.get(index);
					base.assertEqualsActualExpected(webElement.getText(), "�鿴����ɢ����Ŀ");
					break;
		case "���Ǽƻ�":	
					index = 2;
					webElement = webList.get(index);
					base.assertEqualsActualExpected(webElement.getText(), "�鿴�������Ǽƻ���Ŀ");
					break;
		default:		
					index = 0;
					webElement = webList.get(index);
					base.assertEqualsActualExpected(webElement.getText(), "�鿴������汦��Ŀ");
					break;
		}
		return webElement;
	}
	
	/**
	 * ��ҳ��������鿴���ࡱ����
	 * @param linkName ��������
	 * @author ������
	 */
	public void clickMoreLink(String linkName){
		getMoreLink(linkName).click();
		base.jumpToNewWindow();
		switch (linkName) {
		case "��汦":	base.isTitle(PageTitles.yiCunBao);			break;
		case "ɢ��Ͷ��":	base.isTitle(PageTitles.touZiLieBiao);		break;
		case "���Ǽƻ�":	base.isTitle(PageTitles.yiXingJiHua);		break;
		default:		base.isTitle(PageTitles.yiCunBao);			break;
		}
		base.closeAndjumptoOldWindow();
	}
	
	/**
	 * ��ҳ����ȡ���鿴���ࡱ��ʽ
	 * @param linkName ��������
	 * @author ������ 2016-2-24
	 */
	public void checkMoreLinkStyle(String linkName, String styleName){
		base.assertEqualsActualExpected(base.getCSSValue(getMoreLinkBy(linkName), "text-align"), styleName);
	}
	
	
	

	/*****************************************/
	/****************   ��汦      ****************/
	/*****************************************/
	
	
	/****************   ��汦_��һ������      ****************/
	
	//�����ծȨ���顱����
	public void clickeZhaiQuanXiangQing(){
		base.clickWithWait(eCunBaoDataHomeZhaiQuanOne);
	}
	
	//��������ң�������֡�����
	public void clickRedEnvelopesLink(){
		base.clickWithWait(redEnvelopesLink);
	}
	
	//���������Ͷ�ʡ���ť
	public void clickInvestmentBtn(){
		base.clickWithWait(InvestmentBtn);
	}
	
	//�ж��ǡ�����Ͷ�ʡ���ť�Ƿ��ܵ��
	public boolean isInvestmentBtn(){
		boolean isInvestmentBtn = base.getElementTextWithVisible(InvestmentBtn).equals("����Ͷ��");
		if(isInvestmentBtn){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * ��� ������������ֹ��򡱴���Title
	 * @author ������ 2015-5-11
	 */
	public void checkRedEnvelopesTitle(){
		base.assertEqualsActualExpected(base.getElementTextWithVisible(By.xpath("//div[@class='g_con']/h3")), "��汦������ֹ���");
		base.clickElementNoWait(By.xpath("//div[@class='gui_close']"));
	}
	
	//��ȡ��汦��һ�����ݵı���
	public String getECunBaoOneHomeTitleText(){
		String eCunBaoDataHomeTitleOneStr = base.getElementTextWithVisible(eCunBaoDataHomeTitleOne);
		return eCunBaoDataHomeTitleOneStr.substring(1, eCunBaoDataHomeTitleOneStr.length()-1);
	}
	
	/**
	 * ��ȡ��ҳ��汦��һ�����ݵ�id
	 * @return id
	 * @author ������ 2015-12-11
	 */
	public String getECunBaoHomeDataOneId(){
		base.isElementPresence(eCunBaoDataHomeId);
		String id = base.getAttribute(eCunBaoDataHomeId,"id");
		id = id.substring(id.indexOf("id")+2);
		return id;
	}
	
	/**
	 * ��ȡ��ҳ��汦��һ�����ݣ�����Ϊ1��5��
	 * @param cellNum(����)
	 * @return ���ݼ���
	 * @author ������ 2015-5-7
	 */
	public List<String> getECunBaoHomeDataOne(int cellNum){
		List<String> eCunBaoDataList = new ArrayList<String>();
		//�������Ϊ0���򷵻ر���
		if(cellNum==0){
			eCunBaoDataList.add(this.getECunBaoOneHomeTitleText());//�����⡱
		}
		//����ȫ������
		else{
			eCunBaoDataList.add(this.getECunBaoOneHomeTitleText());									//�����⡱
			eCunBaoDataList.add(base.getElementTextWithVisible(eCunBaoDataHomeAnnualReturnsOne));	//���껯���桱
			eCunBaoDataList.add(base.getElementTextWithVisible(eCunBaoDataHomeContractTermOne));	//����ͬ���ޡ�
			eCunBaoDataList.add(base.getElementTextWithVisible(eCunBaoDataHomeRaiseMoneyOne));		//����ļ����
			eCunBaoDataList.add(base.getElementTextWithVisible(eCunBaoDataHomeRaiseTotalMoneyOne));	//����ļ����
		}
		return eCunBaoDataList;
	}
	
	/****************   ��汦_�ڶ�~��������      ****************/
	
	//��ȡ��汦�ڶ���~����������
	public String getECunBaoHomeTableAppointText(int rowNum, int cellNum){
		return base.getCellElement(eCunBaoHomeTable, rowNum, cellNum).getText().trim();
	}
	
	//�����Ͷһ�ʡ���ť
	public void clickAnIinvestmentBtn(WebElement AnIinvestmentWebElement){
		AnIinvestmentWebElement.click();
	}
	
	/**
	 * �жϡ�Ͷһ�ʡ���ť�Ƿ���ʾ
	 * @return true����ʾ��false������ʾ
	 * @author ������ 2016-2-4
	 */
	public boolean isAnIinvestmentBtn(){
		return base.isElementVisible(touYiBiLink);
	}
	
	/**
	 * �����Ͷһ�ʡ���ť
	 * @author ������ 2016-2-4
	 */
	public void clickAnIinvestmentBtn(){
		List<WebElement> touYiBiList = base.getElements(touYiBiLink);
		for(int i = 0; i < 1; i++){
			touYiBiList.get(i).click();
			base.isElementVisible(By.cssSelector("#fastLender_1"));
		}
	}
	/**
	 * ��ȡ��Ͷһ�ʡ���ť
	 * @param rowNum ����
	 * @param cellNum ����
	 * @return ��Ͷһ�ʡ�����
	 * @author ������
	 */
	public WebElement getAnIinvestmentBtn(int rowNum, int cellNum){
		
		//ͨ������������Table�л�ȡ���С�Ԫ��
		WebElement cellWebElement = base.getCellElement(eCunBaoHomeTable, rowNum, cellNum);
		//�ڡ��С�Ԫ���л�ȡa��ǩ
		WebElement tagA = cellWebElement.findElement(By.tagName("a"));   //System.out.println(tagA.getText());//------------����
		//�����ǩֵΪ��Ͷһ�ʡ�������
		if(tagA.getText().equals("Ͷһ��")){
			return tagA;
		}
		else{
			System.out.println("IndexPage: ��'Ͷһ��'��ť��");
			return null;
		}
	}

	/**
	 * ��ҳ��汦����ȡ��2~4����ĳ�е�����ֵ
	 * @param name ����(���⡢�껯���桢��ļ������ļ����Ͷһ��)
	 * @return ĳ�е�ֵ����
	 * @author ������ 2015-12-30
	 */
	public List<WebElement> getECunBaoCellDataBy(String name){
		
		List<WebElement> list = new ArrayList<WebElement>();
		String cell = "";
		switch (name) {
		case "����":		cell = "1";break;
		case "�껯����":	cell = "2";break;
		case "��ļ�����":	cell = "3";break;
		case "��ļ�����":	cell = "4";break;
		case "Ͷһ��":	cell = "5";break;
		default:
			break;
		}
		By cellby = By.xpath("//table[1]//tr[@class='effect']//td[" + cell + "]");
		list = base.getVisibleElements(cellby);
		return list;
	}
	
	/**
	 * ��ҳ��汦����ȡ��2~4����ĳ�е�����ֵ
	 * @param listWebElement ���󼯺�
	 * @return �ַ�����
	 * @author ������ 2015-12-30
	 */
	public List<String> getECunBaoCellDataStr(String name){
		
		List<WebElement> listWebElement = getECunBaoCellDataBy(name);
		List<String> list = new ArrayList<String>();
		int size = listWebElement.size();
		
		for(int i = 0; i < size; i++){
			list.add(listWebElement.get(i).getText());
		}
		return list;
	}
	
	/**
	 * ��ҳ��汦��У���껯�����VIP���ʺ�ͼ��
	 * @param list �껯�����еļ���
	 * @param rate VIP����
	 * @author ������ 2015-12-30
	 */
	public void checkAnnualReturns(List<String> list, String rate){

		//��1����汦����
		//У��+0.1%
		By rateOneBy = By.xpath("//span[@id='realvipInterestrate']/span/span/span");
		System.out.println("��1���������ʣ�" +  base.getElementTextWithVisible(rateOneBy));
		base.assertEqualsActualExpected(base.getElementTextWithVisible(rateOneBy), rate);
		//У��VIPͼ��
		By vipICOOneBy = By.xpath("//span[@id='realvipInterestrate']//i");
		base.checkElementVisible(vipICOOneBy);
		
		//��2~4����汦����
		//У��+0.1%
		for (String str : list) {
			str = str.substring(str.lastIndexOf("+"));System.out.println("��2~4���������ʣ�" + str);//����-----------------
			base.assertEqualsActualExpected(str, rate);
		}
		//У��VIPͼ��
		By vipICOby = By.xpath("//tr[@class='effect']//td[2]//span/i");
		base.checkElementsVisible(vipICOby);
	}
	
	/****************      ��汦_Ͷ�ʽ��_����              ****************/
	
	//���롰����ݶ
	public void sendKeyBuyShareTxt(String buyShare){
		base.sendKeysWithWait(buyShareTxt, buyShare);
	}
		
	//���롰֧�����롱
	public void sendKeyPayPwdTxt(String payPwd){
		base.checkElementVisible(payPwdTxt);
		base.sendKeysWithWait(payPwdTxt, payPwd);
	}
		
	//��ѡ����汦Ͷ��Э�顱��ѡ��
	public void checkECunBaoProtocolAgree(){
		base.clickWithWait(eCunBaoProtocolAgreeChk);
	}
		
	//��ȡ��֤��ͼƬ
	public WebElement getVerificationCodeImg(){
		return base.getElementNoWait(verificationCodeImg);
	}
		
	//���롰��֤�롱
	public void sendKeyVerificationCode(String verificationCode){
		base.sendKeysWithWait(verificationCodeTxt, verificationCode);
	}
		
	//���Ͷ�ʡ�ȷ������ť
	public void clickInvestmentOKBtn(){
		base.clickWithWait(investmentOKBtn);
		if(base.isAlertPresent()){
			if(base.getTextByAlert().equals("��֤�벻��Ϊ�գ�")){
				base.acceptAlert();
				sendKeyVerificationCode(data.get(getVerificationCodeImg(), base.getWebDriver()));
				base.clickWithWait(investmentOKBtn);
			}
		}
	}
	
	/**
	 * ���Ͷ�ʴ���
	 * ���1���˻���Ǯ������Ͷ�ʴ��ڣ�У�鴰��TitleΪ��Ͷ�ʽ�
	 * ���2���˻�ûǮ��������ֵ��ʾ���ڣ�У�鴰��TitleΪ����ܰ��ʾ��
	 * ���3����Ʒ�ѽ�����У�鴰��TitleΪ�������ˡ�
	 * @author ������
	 */
	public void checkInvestmentTitle(){
		if(base.getElementNoWait(By.xpath("//div[@id='bcardtip']")).isDisplayed()){    //System.out.println(base.getElementText(By.xpath("//h2[@class='u-tt']")));//-----------����
			base.assertEqualsActualExpected(base.getElementText(By.xpath("//h2[@class='u-tt']")), "��ܰ��ʾ");
			base.clickElementNoWait(By.xpath("//div[@class='lytt']/a"));
			System.out.println("��汦Ͷ�ʴ��ڣ��˻�ûǮ��������ֵ��ʾ����");
			Reporter.log("��汦Ͷ�ʴ��ڣ��˻�ûǮ��������ֵ��ʾ����");
		}
		else if(base.isBlock(By.id("fastLender_1"))){
			base.assertEqualsActualExpected(base.getElementText(By.xpath("//span[text()='Ͷ�ʽ��']")), "Ͷ�ʽ��");
			base.clickWithWait(By.xpath("//div[@id='fastLender_1']/div/a"));
//			System.out.println("��汦Ͷ�ʴ��ڣ��˻���Ǯ������Ͷ�ʴ���");
//			Reporter.log("��汦Ͷ�ʴ��ڣ��˻���Ǯ������Ͷ�ʴ���");
		}
		else if(base.isBlock(By.id("fastLender_2"))){
			base.assertEqualsActualExpected(base.getElementText(By.xpath("//span[text()='������']")), "������");
			base.clickWithWait(By.xpath("//div[@id='fastLender_2']/div/a"));
			System.out.println("��汦Ͷ�ʴ��ڣ���Ʒ�ѽ���");
			Reporter.log("��汦Ͷ�ʴ��ڣ���Ʒ�ѽ���");
		}
		else{
			System.out.println("��汦Ͷ�ʴ��ڣ��˻�ûǮ���޷����ԣ��� ��ťʧЧ");
			Reporter.log("��汦Ͷ�ʴ��ڣ��˻�ûǮ���޷����ԣ��� ��ťʧЧ");
		}
	}
	
	/**
	 * У�顰Ͷ�ʳɹ�����Ϣ��ʾ��
	 * @author ������ 2015-5-21
	 */
	public void checkInvestmentSuccessWindow(){
		//��ȡ��Ͷ�ʳɹ���DIV��display����ֵ�Ƿ�Ϊblock���������DIV��ʾ
		boolean isInvestmentSuccess = base.isBlock(By.id("fastLender_2"));
		//�ж�DIV�Ƿ���ʾ
		base.assertEqualsActualExpectedByBoolean(isInvestmentSuccess, true);
		String success = base.getElementTextWithVisible(By.xpath("//div[@id='fastLender_2']/div/span[text()='Ͷ�ʳɹ�']"));
		//�жϴ���TitleͶ�ʳɹ�
		base.assertEqualsActualExpected(success, "Ͷ�ʳɹ�");
		//������رա���ť
		base.clickWithWait(By.xpath("//span[@id='backMsg']/parent::div/a"));
	}
	
	/**
	 * ��ȡ��ҳ��汦�˻����
	 * @author ������ 2015-11-23
	 */
	public String getECunBaoBalance(){
		return base.getElementTextWithWait(buyBalance);
	}
	
	/**
	 * ����Ƿ�����汦
	 * @param buyNumber �������
	 * @return true������false:����
	 * @author ������ 2015-11-23
	 */
	public boolean checkECunBaoBalance(String buyNumber){
		
		String buyBalanceStr = getECunBaoBalance();
		int index  = buyBalanceStr.indexOf(".");
		if(index != -1){
			buyBalanceStr = buyBalanceStr.substring(0, index);
		}
		int buyBalanceInt = Integer.valueOf(buyBalanceStr);//�˻����
		int payAble = Integer.valueOf(buyNumber) * 100;//��Ҫ���ѽ��
		System.out.println("�˻���" + buyBalanceInt + " ���軨�ѣ�" + payAble);
		if(buyBalanceInt > payAble){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*****************************************************/
	/****************      ��汦_ծȨ����              ****************/
	/*****************************************************/
	
	/**
	 * ��ҳ����>��汦_��1�����ݡ���>���������Ͷ�ʡ���ť����>�����ծȨ���顱���ӣ�У�鴰���Ƿ�򿪣������Ƿ����
	 * @author ������ 2016-2-4
	 */
	public void clickInvestmentBondDetails(){
		base.clickWithWait(investmentBondDetails);
		base.checkElementVisible(eCBBondDetailsDIV);
		base.assertEqualsActualExpected(base.getElementTextWithVisible(eCBBondDetailsDIVTitle), "ծȨ����");
		base.assertTrueByBoolean(base.isElementVisible(By.cssSelector("#aq")));//У�鷭ҳ��ť�Ƿ����
	}
	
	/**
	 * ��ҳ����>��汦_��2~4�����ݡ���>�����ծȨ���顱��ť����У�鴰���Ƿ�򿪣������Ƿ����
	 * @author ������ 2016-2-4
	 */
	public void clickECunBaoDataTFBondLink(){
		List<WebElement> webList = base.getVisibleElements(eCunBaoDataTFBondLink);
		for(int i = 0; i < 1; i++){
			webList.get(i).click();
			base.checkElementVisible(eCBBondDetailsDIV);
			base.assertEqualsActualExpected(base.getElementTextWithVisible(eCBBondDetailsDIVTitle), "ծȨ����");
			base.assertTrueByBoolean(base.isElementVisible(By.cssSelector("#aq")));//У�鷭ҳ��ť�Ƿ����
		}
	}
	
	/**
	 * ��ҳ����>��汦_��1�����ݡ���>�����ծȨ���顱��ť����У�鴰���Ƿ�򿪣������Ƿ����
	 * @author ������ 2016-2-4
	 */
	public void clickECunBaoDataHomeZhaiQuanOne(){
		base.clickWithWait(eCunBaoDataHomeZhaiQuanOne);
		base.checkElementVisible(eCBBondDetailsDIV);
		base.assertEqualsActualExpected(base.getElementTextWithVisible(eCBBondDetailsDIVTitle), "ծȨ����");
		base.assertTrueByBoolean(base.isElementVisible(By.cssSelector("#aq")));//У�鷭ҳ��ť�Ƿ����
	}
	
	/**
	 * ��ҳ����>��汦����>�����ծȨ���顱��ť��У�鴰��������ʾ�Ƿ�����
	 * @author ������ 2016-2-4
	 */
	public void checkECBBondDetailsDIVColumnName(){
		String[] columnName = {"������","���������","���֤��","����˵���","����ܶ�","����"};
		List<WebElement> webList = base.getVisibleElements(eCBBondDetailsDIVColumnName);
		int size = webList.size();
		base.assertEqualsActualExpectedByInt(size, columnName.length);
		for(int i = 0; i < size; i++){
			base.assertEqualsActualExpected(webList.get(i).getText(), columnName[i]);
		}
	}
	
	/**
	 * ��ҳ����>��汦����>�����ծȨ���顱��ť����ȡ����ĳ�е�ֵ
	 * @param columnName ����
	 * @return ĳ��ֵ�ļ���
	 * @author ������ 2016-2-4
	 */
	public List<String> getECBBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String index = "1";
		switch (columnName) {
		case "������":	index = "1";	break;		
		case "���������":	index = "2";	break;	
		case "���֤��":	index = "3";	break;	
		case "����˵���":	index = "4";	break;	
		case "����ܶ�":	index = "5";	break;	
		case "����":		index = "6";	break;	
		default:		index = "1";	break;	
		}
		List<WebElement> webList = base.getVisibleElements(By.cssSelector(".font14.color6>td:nth-child(" + index + ")"));
		for(int i = 0; i < webList.size(); i++){
			strList.add(webList.get(i).getText());
		}
		return strList;
	}
	
	/**
	 * ��ҳ����>��汦����>�����ծȨ���顱��ť��У�鴰��ĳ�е�ֵ��ʾ�Ƿ�����
	 * @param columnName ����
	 * @author ������ 2016-2-4
	 */
	public void checkECBBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String temp;
		strList = getECBBondDetailsDIVColumnValue(columnName);
		if(columnName.equals("������")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				if(temp.length() > 5){
					temp = temp.substring(5);
					base.assertTrueByBoolean(temp.equals("..."));
				}
			}
		}
		else if(columnName.equals("���������")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(1);
				base.assertTrueByBoolean(temp.contains("*"));
			}
		}
		else if(columnName.equals("���֤��")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(10);
				base.assertTrueByBoolean(temp.equals("********"));
			}
		}
		else if(columnName.equals("����")){
			for(int i = 0; i < strList.size(); i++){
				base.assertEqualsActualExpected(strList.get(i), "�鿴����");
			}
		}
	}
	
	/**
	 * ��ҳ����>��汦����>�����ծȨ���顱��ť����>������鿴���顱��ť��У��鿴����1.ֻ��ʾ��������Ľ��ꣻ2.��������ʾ�����飨������Ϣ�����������ϣ�������/�������ʷͳ�ƣ���ͳ����Ϣ�������Ϣƥ��
	 * @author ������ 2016-2-4
	 */
	public void checkBondDetails(){
		
		List<WebElement> bondDetailsDIVBtnList;
		List<String> titleList = getECBBondDetailsDIVColumnValue("������");
		bondDetailsDIVBtnList = base.getVisibleElements(eCBBondDetailsDIVBtn);
		for(int i = 0; i < 1; i++){
			bondDetailsDIVBtnList.get(i).click();//������鿴���顱��ť
			base.isElementVisible(By.xpath("//td[text()='" + titleList.get(i) + "']"));
			base.assertEqualsActualExpected(base.getElementTextWithVisible(By.cssSelector(".xq_content_tab_block.border>h3")), "�������");
			clickBondDetailsSeeTab("��������");
			clickBondDetailsSeeTab("��������");
			clickBondDetailsSeeTab("��ʷͳ��");
			bondDetailsDIVBtnList.get(i).click();//������鿴���顱��ť
			base.isElementContainsValue(eCBBondDetailsSeeDIV, "style", "none");
			clickBondDetailsDIVClose();
			base.isElementContainsValue(By.cssSelector("#out_all3"), "style", "none");
		}
	}
	
	/**
	 * ��ҳ����>��汦����>ծȨ���顪��>�鿴���顪��>��ȡTab����
	 * @param tabName Tab����
	 * @return Tab����
	 * @author ������ 2016-2-4
	 */
	public By getBondDetailsSeeTab(String tabName){
		String index;
		By by;
		switch (tabName) {
		case "������Ϣ":	index = "1";	break;
		case "��������":	index = "2";	break;
		case "��������":	index = "3";	break;
		case "��ʷͳ��":	index = "4";	break;
		default:		index = "1";	break;
		}
		by = By.cssSelector(".xq_content_t > li:nth-child(" + index + ")");
		return by;
	}
	
	/**
	 * ��汦�б�ҳ����>ծȨ���顪��>�鿴���顪��>���Tab
	 * @param tabName Tab����
	 * @author ������ 2016-2-4
	 */
	public void clickBondDetailsSeeTab(String tabName){
		By by = getBondDetailsSeeTab(tabName);
		base.clickWithWait(by);
		base.assertTrueByBoolean(base.isElementContainsValue2(by, "class", "cur"));
	}
	
	/**
	 * ��汦�б�ҳ����>ծȨ���顪��>�鿴���顪��>���X��ť
	 * @author ������ 2016-2-4
	 */
	public void clickBondDetailsDIVClose(){
		base.clickWithWait(eCBBondDetailsDIVClose);
		base.isElementInvisibility(eCBBondDetailsDIV);
	}
	 
	/****************      ��汦_����               ****************/
	
	//������鿴������汦��Ŀ������
	public void clickMoreLink(){
		base.clickElementNoWait(moreLink);
	}
	
	//��ȡ������¼ҳ�����
	public String getloginTitle(){
		return base.getElementTextWithVisible(loginTitle);
	}
	
	//�رյ�¼ҳ�洰��
	public void closeLogin(){
		base.clickWithWait(closeBtn);
	}

	/**
	 * ��ȡ��汦��ҳ��ʾ����������
	 * @param rowNum(����)��cellNum(����)
	 * @return �������ݼ���
	 * @author ������ 2015-5-7
	 */
	public List<String> getECunBaoHomeDataAll(int rowNum, int cellNum){
		List<String> eCunBaoDataList = new ArrayList<String>();
		//��ȡ��һ������
		eCunBaoDataList = getECunBaoHomeDataOne(cellNum);   //System.out.println("IndexPage:" + cellNum);//---------------����
		//��ȡ�ڶ��������������ݡ�һ����4��5�е�����
		for(int i = 1; i <= rowNum; i++){
			for(int j = 0; j <= cellNum; j++){   //System.out.println(getECunBaoHomeTableAppointText(i,j));//---------------����
				eCunBaoDataList.add(getECunBaoHomeTableAppointText(i,j));
			}
		}
		return eCunBaoDataList;
	}
	
	/**
	 * У����汦��ҳ�Ƿ���ʾ4������
	 * @param titleList(��ҳ��ȡ����汦���ݼ���)
	 * @author ������ 2015-6-9
	 */
	public void checkECunBaoDataNum(List<String> titleList){
		base.assertEqualsActualExpectedByInt(titleList.size(), 4);
	}
	
	/**
	 * �����ҳ��汦���� �� ���ݿ���ʾһ��
	 * ������������Ȱ�״ֵ̬��С���������ٰ�ʱ�䵹������
	 * @param frontPageTitleList (ǰ̨��������)
	 * @param databasesTitleList (���ݿ��������)
	 * @author ������ 2015-5-7
	 */
	public void checkECunBaoHomeTitle(List<String> frontPageTitleList, List<String> databasesTitleList){
		System.out.println("��ʼ------�����ҳ��汦���� �� ���ݿ���ʾһ��------");
		System.out.print("ǰ̨һ��  " + frontPageTitleList.size() + " ������\t");
		System.out.println("��̨һ��  " + databasesTitleList.size() + " ������");
		for(int i= 0; i < frontPageTitleList.size(); i++){
			System.out.print("ǰ̨���ݣ� " + frontPageTitleList.get(i));System.out.println("   ��̨/�б�ҳ���ݣ� " + databasesTitleList.get(i));
			base.assertEqualsActualExpected(frontPageTitleList.get(i), databasesTitleList.get(i));
		}
		System.out.println("����------�����ҳ��汦���� �� ���ݿ���ʾһ��------");
	}
	
	/**
	 * �޸���汦�ĸ�ʽ(���磺2,721,600 ����> 272.16)
	 * @param money ���
	 * @return
	 */
	public String getECunBaoMoney(String money){
		money = money.replaceAll(",", "");
		money = (Double.valueOf(money)/10000) + "";
		if(money.indexOf('.') != -1){
			if(money.substring(money.indexOf('.')).equals(".0")){
				money = money.substring(0, money.indexOf('.'));
			}
		}
		return money;
	}
	
	/**
	 * У����ҳ��汦����_�����⡱�����껯���桱������Լ���ޡ�������ļ����������ļ��������汦�б�ҳ����Ӧ��������һ��
	 * ��ע������ļ�����޷����Թʴ���ע��
	 * @param homePageList ��ҳ��汦����
	 * @param eCunbaoPageList �б�ҳ��汦����
	 * @author ������ 2015-12-14
	 */
	public void checkECunBaoDataOne(List<String> homePageList, List<String> eCunbaoPageList){
		
		System.out.println("��ʼ------�����ҳ��汦���� �� �б�ҳ��ʾһ��------");
		String homeStr,eCunbaoStr;
		int size = eCunbaoPageList.size();//�б�ҳ����ҳ��1
		for(int i = 0; i < size; i++){
			homeStr = homePageList.get(i);
			eCunbaoStr = eCunbaoPageList.get(i);
			//У�顰�껯���桱
			if (i == 1) {
				System.out.print("��ҳ���ݣ� " + homeStr);System.out.println("   �б�ҳ���ݣ� " + eCunbaoStr);
				base.assertEqualsActualExpected(homeStr.replaceAll(" ", ""), eCunbaoStr);//���껯���桱ȥ�ո�
			}
			//У�顰��ļ����������ļ����
			else if(i == size-1){
				//String yiMu;
				String total;
				//yiMu = getECunBaoMoney(homeStr);
				total = getECunBaoMoney(homePageList.get((i + 1)));
				//homeStr = yiMu + "/" + total;
				//System.out.print("��ҳ���ݣ� " + homeStr);System.out.println("   �б�ҳ���ݣ� " + eCunbaoStr);
				//base.assertEqualsActualExpected(homeStr, eCunbaoStr);
				eCunbaoStr = eCunbaoStr.substring(eCunbaoStr.indexOf("/") + 1);
				System.out.print("��ҳ���ݣ� " + total);System.out.println("   �б�ҳ���ݣ� " + eCunbaoStr);
				base.assertEqualsActualExpected(total, eCunbaoStr);
			}
			//У�顰�껯���桱������Լ���ޡ�
			else{
				System.out.print("��ҳ���ݣ� " + homeStr);System.out.println("   �б�ҳ���ݣ� " + eCunbaoStr);
				base.assertEqualsActualExpected(homeStr, eCunbaoStr);
			}
		}
		System.out.println("����------�����ҳ��汦���� �� �б�ҳ��ʾһ��------");
	}
	
	/**
	 * У�鵯����¼����
	 * @author ������ 2015-5-8
	 */
	public void checkLoginTitle(){
		
		boolean isBlock = base.isBlock(By.xpath("//div[@class='login']"));    //System.out.println("�Ƿ���ʾ�� " + isBlock);//--------����
		if(isBlock){
			try {
				//��ת����¼����
				base.switchToFrame("loginBoxFrame");
			} catch (Exception e) {
			}
			//У��Title�Ƿ�һ��
			base.assertEqualsActualExpected(getloginTitle(), "��¼");
			//�رմ���
			closeLogin();
			//��ȡ��ǰ����
			base.fromFrameToDefaultContent();
		}
		else{
			//�رմ���
			base.clickWithWait(By.cssSelector(".login .close"));
		}
	}
	
	/**
	 * ��� ����������汦��Ͷ���б�ҳ
	 * @author ������ 2015-5-11
	 */
	public void checkInvestmentListTitle(String CurrentWindowHandleString){
		String ChildWindowHandle = base.getChildWindowHandle(CurrentWindowHandleString);
		base.jumpToWindow(ChildWindowHandle);
		base.isTitle(PageTitles.yiCunBao);
		base.closeWindow(ChildWindowHandle);
		base.jumpToWindow(CurrentWindowHandleString);
	}
	

	/*****************************************/
	/***************   ɢ��Ͷ��        ***************/
	/*****************************************/
	
	/**
	 * ��ҳ��ɢ��Ͷ�ʣ�У����������
	 * @author ������ 2016-2-2
	 */
	public void checkSBTableColumnName(){
		String[] nameArr = {"����","�껯����","��Լ����","��ļ����Ԫ��","��ļ����Ԫ��"};
		List<WebElement> webList = base.getVisibleElements(sbColumnName);
		for(int i = 0; i < nameArr.length; i++){
			base.assertEqualsActualExpected(webList.get(i).getText(), nameArr[i]);
		}
	}
	
	/**
	 * ��ҳ��ɢ��Ͷ�ʣ���ȡĳ�е�����ֵ�Ķ���
	 * @param name ����
	 * @return ĳ�е�����ֵ�Ķ���
	 * @author ������ 2016-2-2
	 */
	public List<WebElement> getSBCellDataBy(String name){
		
		List<WebElement> list = new ArrayList<WebElement>();
		String cell = "";
		switch (name) {
		case "����":		cell = "1";break;
		case "�����":	cell = "2";break;
		case "�������":	cell = "3";break;
		case "�������":	cell = "4";break;
		case "ʣ����":	cell = "5";break;
		case "��ť":		cell = "6";break;
		default:		cell = "1";break;
		}
		By cellby = By.xpath("//table[2]//tr[@class='effect']//td[" + cell + "]");
		list = base.getVisibleElements(cellby);
		return list;
	}
	
	/**
	 * ��ҳ��ɢ��Ͷ�ʣ���ȡ������󣨼���û�б꼶��ֻ��Title��
	 * @param name ����
	 * @return �������
	 * @author ������ 2016-2-3
	 */
	public List<WebElement> getSBCellTitleDataWebElement(String name){
		List<WebElement> spanList = new ArrayList<WebElement>();
		List<WebElement> aList = new ArrayList<WebElement>();
		spanList = getSBCellDataBy(name);
		for(int i = 0; i < spanList.size(); i++){
			aList.add(spanList.get(i).findElement(By.tagName("a")));
		}
		return aList;
	}
	
	/**
	 * ��ҳ��У����ɢ��Ͷ���еı�����ת�Ƿ�����
	 * @param colName �������磺���⣩
	 * @author ������ 2016-2-3
	 */
	public void checkSBTitleJump(String colName){
		List<WebElement> titleList = new ArrayList<WebElement>();
		titleList = getSBCellTitleDataWebElement(colName);
		String title;
		for(int i = 0; i < titleList.size(); i++){
			title = titleList.get(i).getText();
			titleList.get(i).click();
			if(base.gethandelsNum() == 2){
				base.jumpToNewWindow();
				base.isTitleContains(title);
				base.closeAndjumptoOldWindow();
			}
		}
	}
	
	/**
	 * ��ҳ��У����ɢ��Ͷ���еı�����ת�Ƿ�������
	 * @param colName �������磺���⣩
	 * @param tabName tab���ƣ��磺������Ϣ��
	 * @author ������ 2016-2-3
	 */
	public void checkSBTitleJumpAndMaterialImgNum(String colName, String tabName){
		List<WebElement> titleList = new ArrayList<>();
		titleList = getSBCellTitleDataWebElement(colName);
		String title;
		for(int i = 0; i < titleList.size(); i++){
			title = titleList.get(i).getText();
			if(title.indexOf(".") != -1){
				title = title.substring(0, title.indexOf("."));
			}
			titleList.get(i).click();
			if(base.gethandelsNum() == 2){
				base.jumpToNewWindow();
				base.isTitleContains(title);
				investmentDetailPage.clickTab(tabName);
				investmentDetailPage.checkMaterialImgNum();
				base.closeAndjumptoOldWindow();
			}
		}
	}
	
	/**
	 * ��ҳɢ��Ͷ�ʣ���ȡĳ�е�����ֵ
	 * @param name ����
	 * @return ĳ�е�����ֵ��ֵ
	 * @author ������ 2016-2-2
	 */
	public List<String> getSBDataStr(String name){
		
		List<WebElement> listWebElement = getSBCellDataBy(name);
		List<String> list = new ArrayList<String>();
		int size = listWebElement.size();
		
		for(int i = 0; i < size; i++){
			list.add(listWebElement.get(i).getText());
		}
		return list;
	}
	
	/**
	 * ��ҳ��У��ɢ��Ͷ����ʾ����
	 * @param homeList
	 */
	public void checkSBDataNum(List<String> homeList){
		base.assertEqualsActualExpectedByInt(homeList.size(), 3);
	}
	
	/**
	 * ��ҳ��У��ɢ��Ͷ�������Ƿ����б�ҳ��ͬ
	 * @param sbTitleList   �б�ҳ_����
	 * @param sbLevelList   �б�ҳ_����
	 * @param sbMoneyList   �б�ҳ_�����
	 * @param sbRateList    �б�ҳ_�������
	 * @param sbPeriodsList �б�ҳ_�������
	 * @author ������ 2016-2-2
	 */
	public void checkSBData(List<String> sbTitleList, List<String> sbLevelList, List<String> sbMoneyList, List<String> sbRateList, List<String> sbPeriodsList){

		List<String> list;
		String sbMoney,homeMoney,sbTitle;
		
		list = getSBDataStr("����");
		for(int i = 0; i < list.size(); i++){
			sbTitle = sbTitleList.get(i);
			sbTitle = sbTitle.substring(sbTitle.indexOf("��") + 2);//�������пո�����+2
			base.assertEqualsActualExpected(list.get(i).replaceAll("\n", ""), sbLevelList.get(i) + sbTitle);
		}
		list = getSBDataStr("�����");
		for(int i = 0; i < list.size(); i++){
			homeMoney = list.get(i);
			sbMoney = sbMoneyList.get(i);
			homeMoney = homeMoney.replaceAll("Ԫ", "");
			sbMoney = sbMoney.replaceAll("��", "");
			base.assertEqualsActualExpected(homeMoney, sbMoney);
		}
		list = getSBDataStr("�������");
		for(int i = 0; i < list.size(); i++){
			base.assertEqualsActualExpected(list.get(i), sbRateList.get(i));
		}
		list = getSBDataStr("�������");
		for(int i = 0; i < list.size(); i++){
			base.assertEqualsActualExpected(list.get(i), sbPeriodsList.get(i));
		}
		list = getSBDataStr("ʣ����");
		for(int i = 0; i < list.size(); i++){
			base.assertEqualsActualExpected(list.get(i), "0Ԫ");
		}
		list = getSBDataStr("��ť");
		for(int i = 0; i < list.size(); i++){
			base.assertEqualsActualExpected(list.get(i), "�ѽ���");
		}
	}
	
	/**********************************/
	/************�ײ�����_����*************/
	/**********************************/
	
	/**
	 * �������Ҫ���ˡ�
	 */
	public void clickJoinInOfBottom(){
		base.clickWithWait(joinInOfBottom);
		base.isTitle(PageTitles.zhaoShangHeZuo);
	}
}







