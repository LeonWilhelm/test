package com.eloancn.shared.pages;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.*;

/**
 * ��Ͷ���б�ҳ��
 */
public class InvestmentListPage {
	
	Base base = new Base();
	Data data = new Data();
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	public String Url = base.indexURL + "/new/loadAllTender.action";
	
	/********************************/
	/*********      ����             **********/
	/********************************/
	
	By homePageLink = By.xpath("//li[@class='global']/a");		//��ҳ
	By logoutLink = By.linkText("�˳�");							//�˳�
	
	/********************************/
	/*********    ����ɸѡ           **********/
	/********************************/
	
	By SearchOptionDesTxt = By.cssSelector("div.wrap.mt15.overflowV>div>div>dl>dt");	//���ʽ,�������,�������,������ͣ�.lend_search.h168.bgFF.bdD9.overflowV dt��
	
	/********************************/
	/******    ����ɸѡ_�������          *******/
	/********************************/
	
	/********************************/
	/****  ����ɸѡ_������� _���ʽ        *****/
	/********************************/
	
	public By SelectedMode = By.cssSelector("#repaymentDiv>dl>dd.bg86");		//ѡ�еĻ��ʽ
	By RepayModeOptions = By.xpath("//div[@id='repaymentDiv']/dl/dd");			//���ʽ��4����
	
	/********************************/
	/****  ����ɸѡ_������� _�������        *****/
	/********************************/
	
	By SelectedPhase = By.cssSelector("#phasesDiv>dl>dd.bg86");					//ѡ�еĽ������
	By PhaseOptions = By.xpath("//div[@id='phasesDiv']/dl/dd");					//������ޣ�5����
	
	/********************************/
	/****  ����ɸѡ_������� _�������        *****/
	/********************************/
	
	By SelectedRate = By.cssSelector("#interDiv>dl>dd.bg86");					//ѡ�еĽ������
	
	/********************************/
	/****  ����ɸѡ_������� _�������        *****/
	/********************************/
	
	By SelectedType = By.cssSelector("#typeDiv>dl>dd.bg86");					//ѡ�еĽ������
	By CarMortgageLnk = By.xpath("//div[@id='typeDiv']/dl/dd[3]");				//������Ѻ
	By CarOptionImg = By.xpath("//div[@id='typeDiv']/dl/dd[3]/img");			//������Ѻ���Ϸ�����Ϣ����
	By SelectedCarLnk = By.cssSelector("dd.posiR.overflowV.bg86");				//ѡ�еġ�������Ѻ��
	
	By HouseMortgageLnk = By.xpath("//div[@id='typeDiv']/dl/dd[4]");			//���ݵ�Ѻ
	By HouseOptionImg = By.xpath("//div[@id='typeDiv']/dl/dd[4]/img");			//���ݵ�Ѻ���Ϸ�����Ϣ����
	By SelectedHouseLnk = By.cssSelector("dd.posiR.overflowV.bg86");			//ѡ�еġ����ݵ�Ѻ��
	
	/********************************/
	/******    ����ɸѡ_ԤԼͶ��          *******/
	/********************************/
	
	By ReserveBidBtn = By.cssSelector("a.lend_tip_btn.lend_tip_btn1");			//ԤԼͶ���ݲ����Ű�ť
	By ReserveBidTxt = By.cssSelector("a.lend_tip_btn.lend_tip_btn1>span");		//ԤԼͶ���ݲ�����
	
	/********************************/
	/******    ����ɸѡ_�Զ�Ͷ��          *******/
	/********************************/
	
	By AutoBidBtn = By.cssSelector("span.lend_tip_bgimg");						//�Զ�Ͷ��
	By AutoBidDescTxt = By.xpath("//div[5]/p[4]");								//ûʱ�����꣬�������Զ�Ͷ��

	/********************************/
	/*********    Ͷ���б�           **********/
	/********************************/
	
	public By ListContent = By.cssSelector("div.lendtable>dl");					//�б�list
	public By InvestmentListTxt = By.cssSelector(".font24");					//Ͷ���б��ı�
	
	/********************************/
	/*****    Ͷ���б�_���������            ******/
	/********************************/
	
	By IncomeCalculatorLnk = By.cssSelector("a.lcjsq.fr");						//�������������
	By CloseCalculatorBtn = By.cssSelector("a.count-close.fr");					//�ر����������
	By InputInvestMoney = By.id("loanMoney");									//���롰Ͷ�ʽ�
	By InputLoanRate = By.id("loanRate");										//���롰�����ʡ�
	By InputloanPhases = By.id("loanPhases");									//���롰Ͷ�����ޡ�
	By RepayMode = By.id("loanType");											//���ʽѡ���
	By HBFXMode = By.xpath("//select[@id='loanType']/option");					//������Ϣ�Ļ��ʽ
	By PlanTableCheckBox = By.id("intercheck");									//"��ʾ�ƻ�ʱ���"��ѡ��
	By CalculateNowBtn = By.cssSelector("a.count-btn.fl");						//�����ϼ��㡱
	By SKSJB = By.id("tiemst");													//�տ�ʱ���
	By SKSJBTxt = By.cssSelector("#tiemst > h3.ml25");							//"�տ�ʱ���"�ı�
	By subTitle = By.xpath("//table[@id='tableList']/tbody/tr/th");				//�ڴΣ��տ�ʱ�䣬����ȡ��Ϣ������ȡ���� ������ȡ�ܶʣ�౾��
	By AmountAndInterestTxt = By.id("result0");									//�������տ��ܶ    ��Ϣ��
	By AmountTxt = By.id("totalCont");											//�տ��ܶ�Ľ��
	By InterestTxt = By.id("rateCont");											//��Ϣ�Ľ��
	
	/********************************/
	/*****     Ͷ���б�_���е���             ******/
	/********************************/
	
	By allPlacesBtn = By.cssSelector(".select_place>b");						//���е���
		
	/********************************/
	/*****     Ͷ���б�_�����Ϣ             ******/
	/********************************/
	
	By userImgs = By.xpath("//dt[@class='user_img fl wd100']/a/img");				//�û�ͼƬ
	By InvestmentDataTitle = By.xpath("//dd[@class='wd300 pdl10 fl']/div/a/h2");	//�û�����
	By InvestmentDataMoney = By.cssSelector(".colorCb.mt10");						//�û������
	By InvestmentDataPeriods = By.cssSelector(".wd130.fl.pdl10 > p.mt10");			//�û��������	
	By InvestmentDataRate = By.cssSelector(".colorE6 > span");						//�û��������
	By InvestmentDataBtn = By.cssSelector(".fast_money_disable.mt8");				//�û���ť
	By investmentDataLevel = By.cssSelector("p.clear > span");						//�û�����
	
	
	By fastInvestBtn = By.xpath("//a[@class='fast_money mt8']");							//��ȡ������Ͷ�ʡ���ť
	By InvestTxt = By.id("fastLender_1");													//�����ġ�Ͷ�������
	By InvestAmountTitle = By.xpath("//div[@id='fastLender_1']/div[2]/h1/span");			//������Ͷ������ڵı���
	By RechargeWindow = By.id("noPerson");
	By TipDetailTxt = By.xpath("//div[@id='noPerson']/table/tbody/tr/td/div/div[2]/p");		//������ֵ��ʾ������
	By GoRechargeBtn = By.cssSelector("input[type='submit']");								//"ȥ��ֵ!"��ť
	By CloseRechargeTipLnk = By.cssSelector("a.lyclose");									//�رճ�ֵ��ʾ		
	
	
	By requiredAmount = By.xpath("//span[@id='amount1']");						//������
	By inputMoneyTxt = By.xpath("//input[@id='amount']");						//��������ı���
	By autoInputLink =  By.xpath("//a[text()='�Զ�����']");						//���Զ����롱����
	By payPasswordTxt = By.xpath("//input[@id='paypassowrd']");					//��֧�����롱�ı���
	By verificationCodeTxt = By.xpath("//input[@id='tenderRecordRandCode']");	//����֤�롱�ı���
	By bidBtn = By.cssSelector(".f_m_Confirm.ml20");							//��ȷ�ϡ���ť
	By BidFailTxt = By.id("errorMsg");
	By bidSuccessCloseBtn = By.cssSelector("#fastLender_2 .close");				//Ͷ�ʳɹ����رա���ť
	By backBtn = By.cssSelector("#backButton");									//��ȡ������Ͷ���б���ť
	By borrowMoneyBtn = By.xpath("//input[@class='ld_btn mt25 fl']");			//����Ǯ��������ť
	
	/********************************/
	/*****   Ͷ���б�_�����Ϣ_��ҳ��       *****/
	/********************************/
	
	By pagingBars = By.xpath("//div[@id='Pagination']/ul/li");						//��ȡ��ҳ��
	
	/********************************/
	/****   Ͷ���б�_�����Ϣ_����ҳ             ****/
	/********************************/
	
	By detailedTitle = By.cssSelector("h2.mt10");						//�������ҳ��_�û�����
	By creditEvaluationImg = By.cssSelector(".ld_user.fl>a>img");		//�������ҳ��_�û�ͷ��
	
	/********************************/
	/*** Ͷ���б�_�����Ϣ_����ҳ_����ƻ�      ***/
	/********************************/
	
	By planInfoLink = By.cssSelector(".clear.wd270>a");					//�������ҳ��_����ƻ�_�����顱����
	By lookpLanInfoTxt = By.cssSelector(".fl.font22");					//�������ҳ��_����ƻ�_���鿴����ƻ�������_Title
	By closeLookpLanInfoBtn = By.cssSelector(".close");					//�������ҳ��_����ƻ�_���鿴����ƻ�������_�رհ�ť
	
	
	/********************************/
	/*** Ͷ���б�_�����Ϣ_����ҳ_������Ϣ      ***/
	/********************************/
	
	By registerLink = By.xpath(".//*[@id='record4']//a[text()='ע��']");	//�������ҳ��_�����������Ϣ��_��ע�ᡱ����
	By loginLink = By.xpath(".//*[@id='record4']//a[text()='��¼']");		//�������ҳ��_�����������Ϣ��_����¼������
	
	/********************************/
	/*** Ͷ���б�_�����Ϣ_����ҳ_��ѯ��¼      ***/
	/********************************/
	
	By ownerLink = By.cssSelector(".font14.ml35>a");					//�������ҳ��_��ѯ��¼_���������
	
	
	By creditInfoList = By.cssSelector(".bao.fl~a");					//���������������

	
	/**
	 * Ͷ���б�ҳ�������ԤԼͶ�ꡱ��ť����У����ת�Ƿ�����
	 * @author ������ 2016-2-5
	 */
	public void clickReserveBidBtn(){
		base.clickWithWait(ReserveBidBtn);
		base.isTitle(PageTitles.yuYueTouBiao);
		base.assertEqualsActualExpected(base.getElementTextWithVisible(By.cssSelector(".font24.fl")), "ԤԼͶ��");
	}
	
	
	/**
	 * �����ҳ
	 * @author ������ 2015-6-8
	 */
	public void clickHomePage(){
		base.clickWithWait(homePageLink);
	}
	
	/**
	 * ����˳�
	 * @author ������ 2015-6-8
	 */
	public void clickLogout(){
		base.clickWithWait(logoutLink);
	}
	//����Ƿ����ɢ��
	public boolean ifExistSB(){
		if(base.getElementTextWithWait(ListContent).equals("")){
			System.out.println("Ͷ���б�ҳû�����ݣ�");
			Reporter.log("<br/>Ͷ���б�ҳû�����ݣ�"+"<br/>");
			return false;
		}else{
			return true;
		}
	}
	//�����һ��ɢ��
	public String clickFirstTitle(){
		base.clickWithWait(InvestmentDataTitle);
		base.turnToNewPage();
		base.checkElementVisible(InvestmentDetailPage.StatusBar);
		return base.getElementTextWithWait(InvestmentDetailPage.UserName);
	}
	
	/**
	 * ����ÿ���б����ݵ�Ψһ��ʾ������û�����
	 */
	public void clickInvestmentDataTitleById(String investmentId){
		base.clickWithWait(By.xpath("//a[contains(@href,'" + investmentId + "')]"));
	}
	
	/**
	 * ��������ı�������ֵ
	 * @param money(���)
	 * @author ������ 2015-5-25
	 */
	public void sendKeyInputMoneyTxt(String money){
		//base.sleep(5000);
		base.sendKeyAndWait(inputMoneyTxt, money);
	}
	
	/**
	 * ��֧�����롱�ı�������ֵ
	 * @param password(����)
	 * @author ������ 2015-5-25
	 */
	public void sendKeyPayPasswordTxt(String password){
		//base.sleep(5000);
		base.sendKeyAndWait(payPasswordTxt, password);
	}
	
	/**
	 * ����Ԫ
	 * ��ȡ��֤��
	 */
	public String getVerificationCode(){
		return data.get(indexPage.getVerificationCodeImg(), base.getWebDriver());
	}
	
	/**
	 * ����Ԫ
	 * ˢ����֤��
	 */
	public void refreshVerificationCode(){
		base.clickWithWait(By.cssSelector("#checkverificationCode_fast>a>img"));
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
	}
	
	/**
	 * ����֤�롱�ı�������ֵ
	 * @param verificationCode(��֤��)
	 * @author ������ 2015-5-25
	 */
	public void sendKeyVerificationCodeTxt(String verificationCode){
		base.sendKeyAndWait(verificationCodeTxt, verificationCode);
	}
	
	/**
	 * �����ȷ�ϡ���ť
	 * @author ������ 2015-5-25
	 */
	public void clickBidBtn(){
		base.clickWithWait(bidBtn);
	}
	
	/**
	 * �����Ͷ�ʳɹ����رա���ť
	 * @author ������ 2015-5-26
	 */
	public void clickBidSuccessCloseBtn(){
		base.clickWithWait(bidSuccessCloseBtn);
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
	}
	
	/**
	 * ���������Ͷ���б���ť
	 * @author ������ 2015-5-27
	 */
	public void clickBackBtn(){
		base.clickWithWait(backBtn);
	}
	
	/**
	 * ��ȡ��ϸҳ���û�����
	 * @return ��ϸҳ���û�����
	 * @author ������ 2015-5-22
	 */
	public String getdetailedTitle(){
		WebElement detailedTitleWebElement = base.getElementWithWait(detailedTitle);
		return detailedTitleWebElement.getText();
	}
	
	/**
	 * ��ȡ��ҳ��
	 * @return ��ҳ��
	 * @author ������ 2015-5-22
	 */
	public List<WebElement> getPagingBars(){
		base.checkElementVisible(pagingBars);
		List<WebElement> pagingBarsList =  base.getElements(pagingBars);
		return pagingBarsList;
	}
	
	/**
	 * ��Ͷ���б���ȡ�����û�ͼƬ
	 * @return �����û�ͼƬ����
	 * @author ������ 2015-5-22
	 */
	public List<WebElement> getUserImg(){
		base.checkElementVisible(userImgs);
		List<WebElement> usrImgList = base.getElements(userImgs);
		return usrImgList;
	}
	
	/**
	 * ��Ͷ���б���ȡ�����û����⼯��
	 * @return �����û�������󼯺�
	 * @author ������ 2015-5-22
	 */
	public List<WebElement> getUserTitle(){
		base.checkElementVisible(InvestmentDataTitle);
		List<WebElement> userTitleList = base.getElements(InvestmentDataTitle);
		return userTitleList;
	}
	
	/**
	 * ��ɢ���б� ��ȡ�����û���ĳ�����Եļ���
	 * @param name ��������
	 * @return ���ԵĶ��󼯺�
	 * @author ������ 2016-2-2
	 */
	public List<WebElement> getSBInvestmentData(String name){
		By by;
		switch (name) {
		case "������":	by = InvestmentDataTitle;	break;
		case "�����":	by = InvestmentDataMoney;	break;
		case "�������":	by = InvestmentDataPeriods;	break;
		case "�������": 	by = InvestmentDataRate;	break;
		case "��ť": 	by = InvestmentDataBtn;		break;
		case "����":	by = investmentDataLevel; 	break;
		default:		by = InvestmentDataTitle;	break;
		}
		base.checkElementVisible(by);
		List<WebElement> userTitleList = base.getElements(by);
		return userTitleList;
	}
	
	/**
	 * ��ɢ���б� ��ȡ�����û���ĳ�����Եļ���
	 * @param name ��������
	 * @return ���Ե��ַ�����
	 * @author ������ 2016-2-2
	 */
	public List<String> getSBInvestmentDataStr(String name){
		List<String> list = new ArrayList<String>();
		List<WebElement> webList = getSBInvestmentData(name);
		for(int i = 0; i < webList.size(); i++){
			list.add(webList.get(i).getText());
		}
		return list;
	}
	
	/**
	 * ��ȡ��.��ǰ���ַ���
	 * @param titleStr(Ͷ���б����)
	 * @return ��ȡ���ַ���
	 * @author ������ 2015-5-25
	 */
	public String interceptPoint(String titleStr){
		String interceptStr = titleStr;
		//�жϡ�.����λ��
		int index = titleStr.indexOf(".");
		//���������.�����򷵻ء�.��֮ǰ����
		if(index != -1){
			interceptStr = titleStr.substring(0, index);
		}
		return interceptStr;
	}
	
	/**
	 * �жϷ�ҳ��ʾ����
	 * @author ������  2015-5-25
	 * ��ע��Ŀǰֻʵ����ҳ�ļ�飬�պ���������ҳ��
	 */
	public void checkMaxDisplay(){
		//��ȡ��ҳ���ĳ���
		int pagingBarsSize = getPagingBars().size();
		//�ж��Ƿ��еڶ�ҳ����ҳ��1,��һҳ��2����һҳ��3����һҳ��4��βҳ��5
		if(pagingBarsSize > 5)
		{
			//�ж���ҳ��ʾ�����Ƿ����10
			base.assertTrueByBoolean(getUserImg().size()>10?false:true);
			//�ж�βҳ��ʾ�����Ƿ����10
			
			//�ж�ÿһҳ��ʾ�����Ƿ����10
		}
		//���û�еڶ�ҳ����ֻУ���һҳ
		else{
			//�жϵ�һҳ��ʾ�����Ƿ����10
		}
	}
	
	/**
	 * ������û�����ͼƬ����ת�Ƿ���ȷ
	 * @author ������ 2015-5-22
	 */
	public void checkUserImgJumpList(){
		//��Ͷ���б������û�ͷ�񼯺�
		List<WebElement> userImgList = getUserImg();    //System.out.println("ͼƬ������ " + userImgList.size());//---------����
		//��ø����ھ��
		String parentWindowHandle = base.getCurrentWindowHandle();
		//�Ӵ��ھ��
		String childWindowHandle = "";
		//for(int i = 0; i < userImgList.size(); i++){
		for(int i = 0; i < 1; i++){
			//������û�ͼƬ��
			userImgList.get(i).click();
			//��ȡ�Ӵ��ھ��
			childWindowHandle = base.getChildWindowHandle(parentWindowHandle);
			//��ת���Ӵ���
			base.jumpToWindow(childWindowHandle);    //System.out.println("�� " + i + "��ͼƬ  Title: " + base.getPageTitle());//--------------����
			//��֤ҳ��Title
			base.isTitle(PageTitles.xinYongPingJiaYe);
			//�ر��Ӵ���
			base.closeWindow(childWindowHandle);
			//��ת��������
			base.jumpToWindow(parentWindowHandle);
		}
	}
	
	/**
	 * ������û����⣬��ת�Ƿ���ȷ
	 * @author ������ 2015-5-22
	 */
	public void checkUserTitleList(){
		String parentTitle = "";
		String childTitle = "";
		//��Ͷ���б������û����⼯��
		List<WebElement> userTitleList = getUserTitle();
		//��ø����ھ��
		String parentWindowHandle = base.getCurrentWindowHandle();
		//�Ӵ��ھ��
		String childWindowHandle = "";
//		for(int i = 0; i < userTitleList.size(); i++){
		for(int i = 0; i < 1; i++){	
			//��ȡ�û�����
			parentTitle = interceptPoint(userTitleList.get(i).getText());    //System.out.println("�û�����: " + parentTitle);//----------����
			//����û�����
			userTitleList.get(i).click();
			//��ȡ�Ӵ���
			childWindowHandle = base.getChildWindowHandle(parentWindowHandle);
			//��ת���Ӵ���
			base.jumpToWindow(childWindowHandle);    //System.out.println("�� " + i + "������ Title: " + base.getPageTitle());//--------------����
			//����û���ϸҳ�����
			childTitle = getdetailedTitle();    //System.out.println("����û���ϸҳ�����: " + childTitle);//----------����
			//����ַ����ȴ���11���ȡ����11λ
//			if(childTitle.length() > 11){
//				childTitle = childTitle.substring(0,12);
//			}                                  System.out.println("����û���ϸҳ������ȡ��: " + childTitle);//----------����
			//��֤ҳ��Title
			base.checkTitleContains(parentTitle);
			//�ر��Ӵ���
			base.closeWindow(childWindowHandle);
			//��ת��������
			base.jumpToWindow(parentWindowHandle);
		}
	}
	
	/**
	 * ���������Ͷ�ʡ���ť���ڣ���������У���¼DIV�Ƿ���ʾ
	 * @author ������ 2015-5-25
	 * @return 
	 */
	public boolean clickFastInvestBtn(){
		boolean ifExistInvestBtn = true;
		//��ȡҳ�����еġ�����Ͷ�ʡ���ť
		List<WebElement> fastInvestBtnList =  base.getElements(fastInvestBtn);    //System.out.println("һ��  " + fastInvestBtnList.size() + " ��������Ͷ�ʡ���ť");//----------����
		//���������Ͷ�ʡ���ť����
		if(fastInvestBtnList.size()>0){
//			for(int i = 0; i < fastInvestBtnList.size(); i++){
			for(int i = 0; i < 1; i++){
				boolean isLogin = loginPage.ifLogin();//�ж��Ƿ��¼
				//���������Ͷ�ʡ���ť
				fastInvestBtnList.get(i).click();
				if(isLogin){
					if(base.isBlock(RechargeWindow)){//�˻���ûǮ
						base.checkElementVisible(TipDetailTxt);
						base.assertEqualsActualExpected(base.getElementTextWithWait(TipDetailTxt), "�� ����ȥ��ֵ,��Ͷ��!");
						base.assertEqualsActualExpected(base.getLnkElementText(GoRechargeBtn,"value"), "ȥ��ֵ!");										
					}else{
						base.checkElementVisible(InvestTxt);
						base.assertEqualsActualExpected(base.getElementTextWithWait(InvestAmountTitle), "Ͷ����");
					}
				}else{
					By by = By.xpath("//div[@class='login']");//�ǳ�
					//У�顰��¼�������Ƿ񵯳�
					base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(by, "style", "block"), true);
					indexPage.checkLoginTitle();
				}
			}
		}
		else{
			Reporter.log("Ͷ���б�ҳ���ޡ�����Ͷ�ʡ���ť!");
			System.out.println("Ͷ���б�ҳ���ޡ�����Ͷ�ʡ���ť!");
			ifExistInvestBtn=false;
		}
		return ifExistInvestBtn;
	}
	
	public void clickCloseRechargeLnk(){
		base.clickWithWait(CloseRechargeTipLnk);
		base.checkNoElement(CloseRechargeTipLnk);
	}
	
	/**
	 * ʵ��Ͷ��
	 * @param money(Ͷ�ʽ��), password(֧������)
	 * @author ������ 2015-5-26
	 */
	public void fastInvest(String money, String password){
		//��֤��
		String verificationCode = "";
		//�������������ֵ
		sendKeyInputMoneyTxt(money);
		//��֧�����롱������ֵ
		sendKeyPayPasswordTxt(password);
		//��ȡ��֤��
		verificationCode = data.get(indexPage.getVerificationCodeImg(), base.getWebDriver());
		//����֤�롱������ֵ
		sendKeyVerificationCodeTxt(verificationCode);
		//�����ȷ�ϡ���ť
		clickBidBtn();
	}
	
	/**
	 * У�顰����Ͷ�ʡ���ť������Ͷ��
	 * @param money(Ͷ�ʽ��), password(֧������)
	 * @author ������ 2015-5-25
	 */
	public void checkFastInvest(String money, String password){

		//��ȡҳ�����еġ�����Ͷ�ʡ���ť
		List<WebElement> fastInvestBtnList = base.getElements(fastInvestBtn);
		//���������Ͷ�ʡ���ť����
		if(fastInvestBtnList.size()>0){
//			for(int i = 0; i < fastInvestBtnList.size(); i++){
			String currentHandel = base.getCurrentWindowHandle();  System.out.println("������:" + currentHandel);
			for(int i = 0; i < 1; i++){
				//���������Ͷ�ʡ���ť
				fastInvestBtnList.get(i).click();
				//ʵ��Ͷ��
				fastInvest(money, password);
				base.sleep(25000);
				//У�顰Ͷ�ʳɹ����Ի����Ƿ���ʾ
				By by = By.xpath("//div[@id='fastLender_2']");
				base.assertTrueByBoolean(base.isElementContainsValue2(by,"style", "block"));
				//������رա���ť
				clickBidSuccessCloseBtn();
				//�����հ״��ں�رգ�����ת������
				//�رն൯���Ĵ���
//				LinkedHashSet<String> windowHandles = (LinkedHashSet<String>) base.getCurrentWindowHandles();
//			    String handels[] = new String[windowHandles.size()];
//			    int j=0;
//			    for (String str : windowHandles) {  
//			        System.out.println(str);  
//			        handels[j] = str;
//			        j++;
//			     } 
				base.sleep(1000);
				//�رո���������Ĵ���
				base.closeOtherWindowHandle(currentHandel);
				
				base.sleep(1000);
			    base.jumpToWindow(currentHandel);
				
				//����������б���ť������ʱҳ������쳣
//				clickBackBtn();
			}
		}
		else{
			System.out.println("Ͷ���б�ҳ���ޡ�����Ͷ�ʡ���ť!");
		}
	}
	
	/**
	 * У������ҳ����
	 * @author ������(�������Ԫ)
	 */
	public void checkDetailsInfoLinks(){
		
		base.isTitle(PageTitles.touZiLieBiao);
		String currentHandel = base.getCurrentWindowHandle();//Ͷ���б�
		
		base.getVisibleElements(InvestmentDataTitle).get(0).click();
		String detailsHandel = base.getChildWindowHandle(currentHandel);//��������顱ҳ��
		base.jumpToWindow(detailsHandel);
		base.checkTitleContains("������");
		
		//����������ҳͼƬ����ת����������ҳ
		isTurnToCreditEvaluationPage(creditEvaluationImg,currentHandel,detailsHandel);
		
		//�鿴����ƻ�
		base.clickWithWait(planInfoLink);
		base.assertEqualsActualExpected(base.getElementTextWithWait(lookpLanInfoTxt), "�鿴����ƻ�");
		base.clickWithWait(closeLookpLanInfoBtn);
		
		//owner
		//�ǳ����ױ����У��㣬��ʱɾ�����޸ģ������� 2015-7-15
//		isTurnToCreditEvaluationPage(ownerLink,currentHandel,detailsHandel);
		base.closeWindow(detailsHandel);
		base.jumpToWindow(currentHandel);
	}
	
	public void isTurnToCreditEvaluationPage(By by,String handel1,String handel2){
		base.clickWithWait(by);
		String creditEvaluationHandel = base.getLastWindowHandle(handel1,handel2);//��������
		base.jumpToWindow(creditEvaluationHandel);
		base.isTitle(PageTitles.xinYongPingJiaYe);
		base.closeWindow(creditEvaluationHandel);
		base.jumpToWindow(handel2);
	}
	
	/**
	 * У�顰��Ǯ��������ť������Ͷ��
	 * @param money(Ͷ�ʽ��), password(֧������)
	 * @author ������ 2015-5-28
	 */
	public void checkBorrowMoney(String money, String password){
		//ÿ��Ͷ���б����ݵ�Ψһ��ʾ
		String investmentId = "";
		//��ȡ�����ھ��
		String parsentHandel = base.getCurrentWindowHandle();
		
		if(base.isElementVisible(fastInvestBtn)){
			//��ȡҳ�����еġ�����Ͷ�ʡ���ť
			List<WebElement> fastInvestBtnList =  base.getElements(fastInvestBtn);
			//���ݡ�����Ͷ�ʡ���ť������û������⡱
			//���������Ͷ�ʡ���ť����
//			for(int i = 0; i < fastInvestBtnList.size(); i++){
			for(int i = 0; i < 1; i++){
				//��ȡ������Ͷ�ʡ���ť��onclick����
				investmentId = fastInvestBtnList.get(i).getAttribute("onclick");
				//��ȡonclick�����С�'��֮���ֵ�����磺��onclick="lender.fastLend('87569')"��
				investmentId = investmentId.split("'")[1];    //System.out.println("����ID�� " + investmentId);//-------����
				//����û������⡱
				clickInvestmentDataTitleById(investmentId);
				//��ȡ�Ӵ��ھ��
				String childHandel = base.getChildWindowHandle(parsentHandel);    //System.out.println("�Ӵ��ھ���� " + childHandel);//-------����
				
				base.sleep(2000);
				base.jumpToWindow(childHandel);
				//�������Ǯ��������ť
				base.clickWithWait(By.cssSelector(".ld_btn.mt25.fl"));
				//ʵ��Ͷ��
				fastInvest(money, password);
				base.sleep(25000);
				//У�顰Ͷ�ʳɹ����Ի����Ƿ���ʾ
				base.assertTrueByBoolean(base.isElementContainsValue2(By.xpath("//div[@id='fastLender_2']"),"style", "block"));
				//������رա���ť
				clickBidSuccessCloseBtn();
				//�رո���������Ĵ���
				base.closeOtherWindowHandle(parsentHandel);
				
				base.sleep(2000);
			    base.jumpToWindow(parsentHandel);
			}
		}
		else{
				System.out.println("Ͷ���б�ҳ���ޡ�����Ͷ�ʡ���ť!");
			}
	}
	
	/**
	 * ����Ԫ
	 * �����Ǯ����
	 */
	public void clickBorrow(){
		base.clickWithWait(By.cssSelector(".ld_btn.mt25.fl"));
	}
	/**
	 * ����Ԫ
	 * ��ҳ
	 */
	public void clickPage(String page){
		By css = null;
		if (page.equals("ĩҳ")) {
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='ĩҳ']");
		}else if (page.equals("��ҳ")) {
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='��ҳ']");
		}else if (page.equals("ǰһҳ")) {
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='<']");
		}else if (page.equals("��һҳ")) {
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='>']");
		}else {
			css = By.xpath(".//*[@id='Pagination']//li[text()='"+page+"']");//����ҳ
		}
		base.clickWithWait(css);
	}
	
	/**
	 * ����Ԫ
	 * ��ҳ��ť�Ƿ���ʾ
	 */
	public boolean ifShowPageBtn(String page){
		boolean result = false;
		By css= null;
		if (page.equals("ĩҳ")) {
			//css = By.cssSelector(".pages>li:nth-last-of-type(1)");
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='ĩҳ']");
		}else if (page.equals("��ҳ")) {
			//css = By.cssSelector(".pages>li:nth-of-type(1)");
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='��ҳ']");
		}else if (page.equals("ǰһҳ")) {
			//css = By.cssSelector(".pages>li:nth-of-type(2)");
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='<']");
		}else if (page.equals("��һҳ")) {
			//css = By.cssSelector(".pages>li:nth-last-of-type(2)");
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='>']");
		}else {
			//css = By.xpath(".//*[@id='Pagination']//li[text()='"+page+"']");//����ҳ
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='"+page+"']");
		}
		if(page.equals("5")){
			if(base.isElementPresent(css)){
				result = true;
			}
		}else {
			if (!base.getElementWithWait(css).getAttribute("class").contains("pgEmpty")) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * ����Ԫ
	 * ��֤�����ҳ��ת�Ƿ���ȷ
	 */
	public void isTurnPageOK(String page){
		if (page.equals("ĩҳ")) {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='ĩҳ']")).getAttribute("class").contains("pgEmpty"));
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='>']")).getAttribute("class").contains("pgEmpty"));
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[last()-2]")).getAttribute("class").contains("pgCurrent"));
		}else if (page.equals("��ҳ")) {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='��ҳ']")).getAttribute("class").contains("pgEmpty"));
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='<']")).getAttribute("class").contains("pgEmpty"));
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[position()=3]")).getAttribute("class").contains("pgCurrent"));
		}else if (page.equals("ǰһҳ")) {
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='ĩҳ']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='>']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[last()-3]")).getAttribute("class").contains("pgCurrent"));
		}else if (page.equals("��һҳ")) {
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='��ҳ']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='<']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[position()=4]")).getAttribute("class").contains("pgCurrent"));
		}else {//����ҳ
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='ĩҳ']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='>']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='��ҳ']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='<']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath(".//*[@id='Pagination']//li[text()='"+page+"']")).getAttribute("class").contains("pgCurrent"));
		}
	}
	
	/**
	 * ����Ԫ
	 * У�����ʸߵ͡�������ޡ���ɽ�����������ȷ��
	 * type: ��ʼasc   �����desc
	 */
	public void isSanJiaoOK(String type){
		if (type.equals("all")) {
			List<WebElement> lists = base.getElements(By.cssSelector(".filterbarfasc"));
			base.assertEqualsActualExpected(lists.size()+"", "3");
		}else if (type.equals("���ʸߵ�")) {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//a[text()='���ʸߵ�']")).getAttribute("class").contains("filterbarfdesc"));//By.cssSelector(".sorting>li:nth-child(2)>a")
		}else if (type.equals("�������")) {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//a[text()='�������']")).getAttribute("class").contains("filterbarfdesc"));//By.cssSelector(".sorting>li:nth-child(3)>a")
		}else {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//a[text()='��ɽ���']")).getAttribute("class").contains("filterbarfdesc"));//By.cssSelector(".sorting>li:nth-child(4)>a")
		}
	}
	
	/**
	 * ����Ԫ
	 * ������ʸߵ͡�������ޡ���ɽ��Ƚ�������
	 */
	public void clickSort(String type){
		if (type.equals("���ʸߵ�")) {
			base.clickWithWait(By.xpath("//a[text()='���ʸߵ�']"));//By.cssSelector(".sorting>li:nth-child(2)>a")
		}else if (type.equals("�������")) {
			base.clickWithWait(By.xpath("//a[text()='�������']"));//By.cssSelector(".sorting>li:nth-child(3)>a")
		}else {
			base.clickWithWait(By.xpath("//a[text()='��ɽ���']"));//By.cssSelector(".sorting>li:nth-child(4)>a")
		}
	}
	
	/**
	 * ����Ԫ
	 * У�����ʸߵ͡�������ޡ���ɽ��������Ƿ�����
	 * @param type
	 */
	public void isSortOK(String type){
		//��Ϣ .colorE6>span ����.plan>em  ����.colorF0
		List<WebElement> lists = null;
		if (type.equals("���ʸߵ�")) {
			//��Ϣ
			lists = base.getElements(By.cssSelector(".colorE6>span"));
		}else if (type.equals("�������")) {
			//�������
			lists = base.getElements(By.cssSelector(".colorF0"));
		}else {
			//����
			lists = base.getElements(By.cssSelector(".plan>em"));
		}
		if (lists.size()>0) {
			double before = 0;
			double now = 0;
			for (int i = 0; i < lists.size()-1; i++) {
				if (type.equals("�������")) {
					before = Integer.parseInt(lists.get(i).getText());
					now = Integer.parseInt(lists.get(i+1).getText());
					System.out.println("i:"+(i+1)+",before:"+before+",now:"+now);
				}else {
					before = getLX(lists.get(i).getText());
					now = getLX(lists.get(i+1).getText());
					System.out.println("i:"+(i+1)+",before:"+before+",now:"+now);
				}
				//У����Ϣ�����ޡ����ȵ���
				base.assertTrueByBoolean(before>=now);
			}
		}
	}
	
	/**
	 * xty
	 * ��ȡ��Ϣ��������ֵ  ȥ����%��
	 * @return
	 */
	public double getLX(String text){
		return Double.parseDouble(text.substring(0, text.length()-1));
	}
	
	/**
	 * ����Ԫ
	 * �������ұ��е����Ƿ��ţ�
	 */
	public void isPlaces(String place){
		if (base.browserType.contains("ie")) {
			base.sleep(3000);
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(allPlacesBtn), place);
	}
	
	/**
	 * ����Ԫ
	 * ������е���
	 */
	public void clickPlaces(){
		//base.clickWithWait(allPlacesBtn);
		base.mouseToElement(allPlacesBtn);
	}
	
	/**
	 * ����Ԫ
	 * У��չ�����е�����
	 */
	public void isOpenAllPlacesDiv(){
		base.assertTrueByBoolean(base.isBlock(By.cssSelector(".select_place_c")));
	}
	
	/**
	 * ����Ԫ
	 * У�����ѡ���б�����
	 */
	public void isNotOpenAllPlacesDiv(){
		if (base.browserType.contains("ie")) {
			base.sleep(2000);
		}
		base.assertEqualsActualExpectedByBoolean(base.isBlock(By.cssSelector(".select_place_c")),false);
	}
	
	/**
	 * ����Ԫ
	 * �������
	 */
	public void inputPlace(String value){
		base.getElementWithWait(By.cssSelector("#arrcity")).clear();
		base.sendKeysWithWait(By.cssSelector("#arrcity"), value);
		base.mouseToElement(By.cssSelector("#arrcity"));
		//base.clickWithWait(By.cssSelector(".ac_over>a"));
	}
	
	/**
	 * ����Ԫ
	 * �������
	 */
	public void inputAndSelectPlace(String value){
		base.sendKeysWithWait(By.cssSelector("#arrcity"), value);
		//base.mouseToElement(By.cssSelector("#arrcity"));
		base.clickWithWait(By.cssSelector(".ac_over>a"));
	}
	
	/**
	 * ����Ԫ
	 * У�������б����Ƿ�������Ը���ĸ��ͷ��ʡ�ݻ����
	 */
	public void isFirstChar(String value){
		List<WebElement> list = base.getElements(By.cssSelector("#suggest li span"));
		for (int i = 0; i < list.size(); i++) {
			base.assertTrueByBoolean(list.get(i).getText().substring(0,1).equalsIgnoreCase(value));
		}
	}
	
	/**
	 * ����Ϊ�գ������б����Ƿ���ʾĬ�ϵ���
	 */
	public void isDefaultValue(){
		List<WebElement> list = base.getElements(By.cssSelector("#suggest li a"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText()+","+Data.defaultPlaces[i]);
			base.assertTrueByBoolean(list.get(i).getText().contains(Data.defaultPlaces[i]));
		}
	}
	
	/**
	 * ����Ԫ
	 * �����������
	 */
	public void clickSearch(){
		base.clickWithWait(By.cssSelector(".select_p_btn"));
	}
	
	/**
	 * ����Ԫ
	 * У����������Ƿ�������������
	 */
	public void isSearchOK(String space){
		//��ǰҳ���б�
		List<WebElement> allList = base.getElements(By.cssSelector(".lendtable dt"));
		//��ǰҳ�õ����ı�		
		List<WebElement> list = base.getElements(By.cssSelector(".lendtable .clear"));
		if (allList.size()>0) {
			for (int i = 0; i < allList.size(); i++) {
				base.assertTrueByBoolean(list.get(i).getText().contains(space));
			}
		}else {
			Reporter.log("�˵���������"+"<br/>");
			System.out.println("�˵���������");
		}
		
	}
	
	/**
	 * ����Ԫ
	 * �����ı����·������ų����е��һ������
	 */
	public String clickHotCity(){
		String city = base.getElementTextWithWait(By.cssSelector(".select_p_2_list>li>a"));
		base.clickWithWait(By.cssSelector(".select_p_2_list>li>a"));
		return city;
	}
	
	/**
	 * ����Ԫ
	 * �����ų����·��ġ���ѡ��ѡ������ʡ
	 */
	public String clickProvince(){
		String province = base.getElementTextWithWait(By.cssSelector("#provinceList>li>a"));
		base.clickWithWait(By.cssSelector("#provinceList>li>a"));
		return province;
	}
	
	/**
	 * ����Ԫ
	 * У�������ų����·�����ѡ������ʡ,��ʾ��ʡ�ֵĳ��У���ʾѡ����У�
	 */
	public void isShowProvinceCitys(){
		String report = "��ʡ�������ĳ����У�";
		List<WebElement> citys = base.getElements(By.cssSelector("#stock_city_item a"));
		for (int i = 0; i < citys.size(); i++) {
			report += citys.get(i).getText()+"  ";
		}
		Reporter.log(report+"<br/>");
		System.out.println(report);
		//��ʾ��ʡ�ֵĳ���
		base.assertNotNullBy(By.cssSelector("#stock_city_item a"));
		//ʡ��ʧ 
		base.assertEqualsActualExpectedByBoolean(base.isBlock(By.cssSelector("#stock_province_item")), false);
		//��ʾѡ�����
		base.assertNotNullBy(By.cssSelector(".curr .mtbg"));
	}
	
	/**
	 * ����Ԫ
	 * ѡ����ʡ ѡ�����
	 */
	public String selectCity(){
		String city = base.getElementTextWithWait(By.cssSelector("#stock_city_item a"));
		base.clickWithWait(By.cssSelector("#stock_city_item a"));
		return city;
	}
	
	/**
	 * ����Ԫ
	 * ��������
	 */
	public void clickGongYiDai(){
		base.clickWithWait(By.cssSelector(".ldgyd.fr.colorE6"));
	}
	
	/**
	 * ����Ԫ
	 * У����ʾ�������
	 */
	public void isGongyiDai(){
		//��ǰҳ���б�
		List<WebElement> allList = base.getElements(By.cssSelector(".lendtable dt"));
		//��ǰҳ�������
		List<WebElement> gydlist = base.getElements(By.cssSelector(".yi.fl"));
		if (allList.size()>0) {
			for (int i = 0; i < allList.size(); i++) {
				base.assertNotNullWebElement(gydlist.get(i));
			}
		}else {
			Reporter.log("�޹������");
		}
	}
	
	/**
	 * ����Ԫ
	 * У��������ѡ�����Ϊ��ɫ
	 * @param type
	 */
	public void isTypeBackgroundRed(String type){
		base.sleep(1000);
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#typeDiv .bg86")), type);
	}
	
	/**
	 * ����Ԫ
	 * ����������
	 */
	public void clickType(String type){
		switch (type) {
		case "���ý��":
			base.clickWithWait(By.xpath("//dd[text()='���ý��']"));//By.cssSelector(".overflowV>dd:nth-of-type(2)")
			break;
		case "������Ѻ":
			base.clickWithWait(By.xpath("//dd[text()='������Ѻ']"));//By.cssSelector(".overflowV>dd:nth-of-type(3)")
			break;
		case "���ݵ�Ѻ":
			base.clickWithWait(By.xpath("//dd[text()='���ݵ�Ѻ']"));//By.cssSelector(".overflowV>dd:nth-of-type(4)")
			break;
		default:
			Reporter.log("�������ѡ��������ѡ�����ý��/������Ѻ/���ݵ�Ѻ"+"<br/>");
			base.assertTrueByBoolean(false);
			break;
		}
	}
	
	/**
	 * ����Ԫ
	 * У����ʾָ��������͵ı�
	 */
	public void isTypeBiao(String type){
		//��ǰҳ���б�
		List<WebElement> allList = base.getElements(By.cssSelector(".lendtable dt"));
		//��ǰҳ���ý����
		List<WebElement> xyjdlist = base.getElements(By.cssSelector(".bao.fl"));
		//��ǰҳ������Ѻ��
		List<WebElement> cldylist = base.getElements(By.cssSelector(".che.fl"));
		//��ǰҳ���ݵ�Ѻ��
		List<WebElement> fwdylist = base.getElements(By.cssSelector(".fang.fl"));
		List<WebElement> fwdylist1 = base.getElements(By.cssSelector(".fl>h2"));//������
		int allnum=allList.size(),fwdynum=fwdylist.size();
		if(allnum>0){
			switch (type) {
			case "���ý��": 	base.assertEqualsActualExpectedByInt(xyjdlist.size(), allnum);
							break;
			case "������Ѻ":   base.assertEqualsActualExpectedByInt(cldylist.size(), allnum);
							break;
			case "���ݵ�Ѻ":  
//				for(int i=0;i<allnum;i++){
//					if(fwdylist1.get(i).getText().contains("��������Ѻ ��")){
//						fwdynum=fwdynum+1;
//					}
//				}
				base.assertEqualsActualExpectedByInt(fwdynum, allnum);
				break;
			}
		
//		if (allList.size()>0) {
//			for (int i = 0; i < allList.size(); i++) {
//				switch (type) {
//				case "���ý��":
//					base.assertNotNullWebElement(xyjdlist.get(i));
//					break;
//				case "������Ѻ":
//					base.assertNotNullWebElement(cldylist.get(i));
//					break;
//				case "���ݵ�Ѻ":
//					base.assertNotNullWebElement(fwdylist.get(i));
//					break;
//				default:
//					break;
//				}
//			}
		}else {
			Reporter.log("����Ӧ��"+"<br/>");
		}
	}
	
	/**
	 * ����Ԫ
	 * ��鴰�����������Ƿ���������һ��
	 * ���㻹�����Ƿ���ȷ������ܽ��-��Ͷ�ʽ��=�����
	 * �����������ʾ�Ƿ���ȷ��������˻��Ŀ������һ�£�
	 * ����������Ϸ�,�ر�Ͷ�����
	 */
	public void isDebitWindowDataIdentical(double balance){
		//�б��Ͷ�ʵ�����
		List<WebElement> lvList = base.getElements(By.xpath("//dd[a[@class='fast_money mt8']]/preceding-sibling::dd[3]//span"));
		//����Ͷ��
		List<WebElement> kstzList = base.getElements(By.cssSelector(".fast_money.mt8"));
		//��ɽ���
		List<WebElement> wcjdList = base.getElements(By.xpath("//dd[a[@class='fast_money mt8']]/preceding-sibling::dd[1]//em"));
		List<WebElement> jkjeList = base.getElements(By.xpath("//dd[a[@class='fast_money mt8']]/preceding-sibling::dd[3]//p[1]"));
		//��Ͷ�ı���
		List<WebElement> titleList = base.getElements(By.xpath("//dd[a[@class='fast_money mt8']]/preceding-sibling::dd[4]//a"));
		
		if (kstzList.size()>0) {
			Reporter.log("��" + lvList.size() + "�����Ͷ��"+"<br/>");
			System.out.println("��" + lvList.size() + "�����Ͷ��");
			for (int i = 0; i < lvList.size(); i++) {
				int j = i+1;
				Reporter.log("��" + j + "����>>>>>>>>>>>>>"+"<br/>");
				System.out.println("��" + j + "����>>>>>>>>>>>>>");
				int step = 0;
				//�б��Ͷ�ʵ�����
				String lv = lvList.get(i).getText();
				//�������Ͷ��
				kstzList.get(i).click();
				//�رյ����հ�ҳ
				if (base.gethandelsNum()==2) {
					base.turnToOldPage();
				}
				//Ͷ�ʴ�������
				String tzckll = base.getElementTextWithWait(By.cssSelector("#interestrate_t"));
				//Ͷ�ʴ��ڻ�����
//				double amount = Double.parseDouble(base.getElementTextWithWait(By.cssSelector("#amount1")));
				int amount = Integer.parseInt(base.getElementTextWithWait(By.cssSelector("#amount1")));
				//�������
				double kyye = Double.parseDouble(base.getElementTextWithWait(By.cssSelector("#userbalance")));
				//��鴰�����������Ƿ���������һ��
				try {
					base.assertEqualsActualExpected(tzckll, lv);
					Reporter.log("�������������Ƿ���������һ��:У��ɹ�"+"<br/>");
					System.out.println("�������������Ƿ���������һ��:У��ɹ�");
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("�������������Ƿ���������һ��:У��ʧ�ܣ����Σ�"+lv+",ʵ�ʣ�"+tzckll+"<br/>");
					System.out.println("�������������Ƿ���������һ��:У��ʧ�ܣ����Σ�"+lv+",ʵ�ʣ�"+tzckll);
				}
				//�����
				double jkje = Double.parseDouble(jkjeList.get(i).getText().replaceAll(",", "").replace("��", ""));
				/*********ҳ���ȡ**********/
				//ת������
				String progress = wcjdList.get(i).getText().replace("%", "");System.out.println(progress);
				if(base.Money((jkje-amount)/jkje*100).equals(progress)){
					Reporter.log("���㻹�����Ƿ���ȷ:У��ɹ�"+"<br/>");
					System.out.println("���㻹�����Ƿ���ȷ:У��ɹ�");
					step += 1;
				}else{
					Reporter.log("���㻹�����Ƿ���ȷ:У��ʧ��");
					System.out.println("���㻹�����Ƿ���ȷ:У��ʧ��");
				}
				//�����������ʾ�Ƿ���ȷ��������˻��Ŀ������һ�£�
				try {
					base.assertEqualsActualExpectedByDouble(kyye, balance);
					Reporter.log("�����������ʾ�Ƿ���ȷ��������˻��Ŀ������һ�£�:У��ɹ�"+"<br/>");
					System.out.println("�����������ʾ�Ƿ���ȷ��������˻��Ŀ������һ�£�:У��ɹ�");
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("�����������ʾ�Ƿ���ȷ��������˻��Ŀ������һ�£�:У��ʧ�ܣ����Σ�"+balance+",ʵ�ʣ�"+kyye+"<br/>");
					System.out.println("�����������ʾ�Ƿ���ȷ��������˻��Ŀ������һ�£�:У��ʧ�ܣ����Σ�"+balance+",ʵ�ʣ�"+kyye);
				}
				//����������Ϸ�,�ر�Ͷ�����
				closeBitWindow();
				try {
					base.sleep(2000);
					base.assertTrueByBoolean(!base.isBlock(By.cssSelector("#fastLender_1")));
					Reporter.log("����������Ϸ�,�ر�Ͷ�����:У��ɹ�"+"<br/>");
					System.out.println("����������Ϸ�,�ر�Ͷ�����:У��ɹ�");
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("����������Ϸ�,�ر�Ͷ�����:У��ʧ��"+"<br/>");
					System.out.println("����������Ϸ�,�ر�Ͷ�����:У��ʧ��");
				}
				int result = 4;
//				if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
//					result = 3;
//				}
				if (step == result) {
					base.assertTrueByBoolean(true);
				}else {
					base.assertTrueByBoolean(false);
				}
			}
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��"+"<br/>");
		}
	}
	
	/**
	 * ����Ԫ
	 * �ر�Ͷ�ʴ���
	 */
	public void closeBitWindow(){
		base.clickWithWait(By.cssSelector("#fastLender_1 .close.fr"));
		if (base.gethandelsNum()>=2) {
			base.closeWebDriver();
		}
	}
	
	/**
	 * ����Ԫ
	 * �������Ͷ��
	 * �п���Ͷ�ʷ���true  û�з���false
	 */
	public boolean clickKstz(){
		//����Ͷ��
		List<WebElement> kstzList = base.getElements(By.cssSelector(".fast_money.mt8"));
		if (kstzList.size()>0) {
			for (int i = 0; i < 1; i++) {
				kstzList.get(i).click();
				//�رյ����հ�ҳ
				if (base.gethandelsNum()>=2) {
					base.closeWebDriver();
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * ����Ԫ
	 * ���Ͷ�ʴ��ڵĳ�ֵ
	 */
	public void clickRecharge(){
		base.clickWithWait(By.cssSelector(".cpt.fl"));
	}
	
	/**
	 * ����Ԫ
	 * ���Ͷ�ʴ��ڵ���������
	 */
	public void clickForgetPassword(){
		base.clickWithWait(By.xpath("//input[@id='paypassowrd']/following-sibling::a"));//By.cssSelector(".cont.font14>p:nth-of-type(4)>a")
	}
	
	/**
	 * ����Ԫ
	 * ���Ͷ�ʴ��ڵ��Զ�Ͷ��
	 */
	public void clickAutoBid(){
		base.clickWithWait(By.cssSelector(".mt15.textC>a"));
	}
	
	/**
	 * ����Ԫ
	 * ����Զ�����
	 */
	public void clickAutoInputBtn(){
		base.clickWithWait(By.cssSelector(".mt10.borderTF2.h30.pdt20.clear>.ml10"));
	}
	
	/**
	 * ����Ԫ
	 * ��ȡ����������Զ�����ֵ
	 */
	public String getAutoValue(){
		return base.getElementWithWait(By.cssSelector("#amount")).getAttribute("value");
	}
	
	/**
	 * ����Ԫ
	 * �ж��Զ������Ƿ���ȷ
	 */
	public void isAutoInputOk(){
		//������
		int needAmount = Integer.parseInt(base.getElementTextWithWait(By.cssSelector("#amount1")).split("\\.")[0]);
		//���
		int balance = Integer.parseInt(base.getElementTextWithWait(By.cssSelector("#userbalance")).split("\\.")[0]);
		//���Ͷ�ʴ��ڵ��Զ�����
		clickAutoInputBtn();
		//��֤�Զ�����
		if (balance<50) {//���<50
			base.checkAlertText("����50������Ͷ��");
		}else if (balance>=50 && balance<needAmount) {//50<=���ý��<������
			System.out.println("50<=���ý��<������");
			base.assertEqualsActualExpected(getAutoValue(), balance+"");
		}else {
			System.out.println("���ý��>������");
			base.assertEqualsActualExpected(getAutoValue(), needAmount+"");
		}
	}
	
	/**
	 * ����Ԫ
	 * У���Ƿ����п�Ͷ�ʵ�ɢ���Զ������Ƿ���ȷ
	 */
	public void isAllAutoInputOk(){
		//����Ͷ��
		List<WebElement> kstzList = base.getElements(By.cssSelector(".fast_money.mt8"));
		if (kstzList.size()>0) {
			for (int i = 0; i < kstzList.size(); i++) {
				kstzList.get(i).click();
				//�رյ����հ�ҳ
				if (base.gethandelsNum()>=2) {
					base.closeWebDriver();
				}
				isAutoInputOk();
				closeBitWindow();
			}	
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��"+"<br/>");
		}
	}
	
	/**
	 * ����Ԫ
	 * У��Ͷ�ʴ�����ʾ
	 */
	public void isWrong(String msg){
		//base.sleep(2000);
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#fastLender_2")));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#errorMsg")), msg);
	}
	
	/**
	 * ����Ԫ
	 * У�����볤��
	 */
	public void isPayPasswordLenthOK(){
		base.assertEqualsActualExpectedByInt(base.getElementWithWait(By.cssSelector("#paypassowrd")).getAttribute("value").length(), 16);
	}
	
	/**
	 * ����Ԫ
	 * У��Ͷ�ʳɹ�
	 */
	public void isBitOk(){
		//base.sleep(3000);
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#fastLender_2")));
		if(base.getElementTextWithWait(BidFailTxt).equals("")){
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#tenderOK")), "Ͷ��ɹ�");
		}else{
			String ErrorTxt = base.getElementText(BidFailTxt);
			Reporter.log(ErrorTxt);
			Assert.fail(ErrorTxt);
		}
		//base.assertTrueByBoolean(base.isBlock(By.cssSelector("#fastLender_2")));
	}
	
	/**
	 * ����Ԫ
	 * Ͷ�ʴ��� ���ȡ��
	 */
	public void clickCancel(){
		base.clickWithWait(By.cssSelector(".f_m_Cancel.ml76"));
		if (base.gethandelsNum()>=2) {
			base.closeWebDriver();
		}
	}
	
	/**
	 * ����Ԫ
	 * Ͷ�ʴ�����ʧ
	 */
	public void isBitWindowDisappear(){
		base.checkNoElement(By.cssSelector("#fastLender_1"));
		//base.assertTrueByBoolean(!base.isBlock(By.cssSelector("#fastLender_1")));
	}
	
	/**
	 * ����Ԫ
	 * Ͷ�ʴ�����ʧ
	 */
	public void isBitWindowDisplay(){
		//base.sleep(2000);
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#fastLender_1")));
	}
	
	/**
	 * ����Ԫ
	 * ���ȥ�ҵ��˻��鿴
	 */
	public void toUserCenter(){
		base.clickWithWait(By.cssSelector("#userCenter"));
	}
	
	/**
	 * ����Ԫ
	 * ��ʾ����ʧ
	 */
	public void isPromptDisappear(){
		//base.sleep(2000);
		//base.assertTrueByBoolean(!base.isElementPresent(By.cssSelector("#fastLender_2")));
		base.checkNoElement(By.cssSelector("#fastLender_2"));
	}
	
	/**
	 * ����Ԫ
	 * У���ֵ��ʾ
	 */
	public void isShowRecharge(){
		base.sleep(2000);
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#noPerson")));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#noPerson .lyct>.textC")), "�� ����ȥ��ֵ,��Ͷ��!");
	}
	//��顰Ͷ���б�ҳ����������
	public void checkInvestListDatawithLogin(){
		
		String [][] search = {{"����","�ȶ��","�ȶϢ","������Ϣ"},{"����","3��������","4��6����","7��11����","12��������"},{"����","12%����","12%��15%","15%��18%","18%����"},{"����","���ý��","������Ѻ","���ݵ�Ѻ"}};
		String [] desc = {"���ʽ��","������ޣ�","������ʣ�","������ͣ�"};
		List<WebElement> Desc = base.getElements(SearchOptionDesTxt);
		for(int i=1;i<=4;i++){
			base.assertEqualsActualExpected(Desc.get(i-1).getText(), desc[i-1]);
			for(int j=1;j<=search[i-1].length;j++){
				base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@class='wrap mt15 overflowV']/div/div["+i+"]/dl/dd["+j+"]")), search[i-1][j-1]);
			}
		}
		base.assertEqualsActualExpected(base.getElementText(ReserveBidBtn), "ԤԼͶ��");
		base.assertEqualsActualExpected(base.getElementNoWait(ReserveBidBtn).getCssValue("background-color"), "rgba(255, 117, 0, 1)");
		base.assertEqualsActualExpected(base.getElementNoWait(ReserveBidTxt).getCssValue("color"), "rgba(255, 255, 255, 1)");
		base.assertEqualsActualExpected(base.getElementText(AutoBidBtn), "�Զ�Ͷ��");
		base.assertEqualsActualExpected(base.getElementText(AutoBidDescTxt), "ûʱ�����꣬�������Զ�Ͷ��");
		if(base.indexURL.contains("client")){
			base.assertTrueByBoolean(base.getLnkElementText(CarOptionImg, "src").contains(base.indexURL+"/page/loan/images/new.gif"));
			base.assertTrueByBoolean(base.getLnkElementText(HouseOptionImg, "src").contains(base.indexURL+"/page/loan/images/new.gif"));
		}else if(base.indexURL.contains("test")){
//			base.assertTrueByBoolean(base.getLnkElementText(CarOptionImg, "src").contains("http://static66.eloancn.com//page/loan/images/new.gif"));
//			base.assertTrueByBoolean(base.getLnkElementText(HouseOptionImg, "src").contains("http://static66.eloancn.com//page/loan/images/new.gif"));
			base.assertTrueByBoolean(base.getLnkElementText(CarOptionImg, "src").contains("http://www.eloancn.com/page/loan/images/new.gif"));
			base.assertTrueByBoolean(base.getLnkElementText(HouseOptionImg, "src").contains("http://www.eloancn.com/page/loan/images/new.gif"));
		}else if(base.indexURL.contains("www")){
			base.assertTrueByBoolean(base.getLnkElementText(CarOptionImg, "src").contains("http://static7.eloancn.com//page/loan/images/new.gif"));
			base.assertTrueByBoolean(base.getLnkElementText(HouseOptionImg, "src").contains("http://static7.eloancn.com//page/loan/images/new.gif"));
		}
	}
	//������Զ�Ͷ�ꡱ����
	public void clickAutoBidBtn(int flag){
		
//		if(base.isElementPresent(LoginPage.LoginLnk)){
		if(flag==1){//�ѵ�¼
			base.clickWithWait(AutoBidBtn);
			base.checkElement(AutoBidPage.Main);
			base.checkElmentText(By.cssSelector("a.ico-autobit.cur"), "�Զ�Ͷ��");
		}else{
			base.clickWithWait(AutoBidBtn);
			base.checkElementVisible(LoginPage.LoginPart);
		}
	}

	//�����������Ѻ���Ľ������
	public void clickCarMortgageOption(){
		base.clickWithWait(CarMortgageLnk);
		base.checkElmentText(SelectedCarLnk, "������Ѻ");
	}
	
	//�����������Ѻ���Ľ������
	public void clickHouseMortgageOption(){
		base.clickWithWait(HouseMortgageLnk);
		base.checkElmentText(SelectedHouseLnk,"���ݵ�Ѻ");
	}
	
	//����������������ͼ��
	public void clickIncomeCalculatorLnk(){
		base.clickElementNoWait(IncomeCalculatorLnk);
		base.checkElementVisible(CloseCalculatorBtn);
	}
	//��������������롰Ͷ�ʽ�
	public void InputMoney(String value){
		base.sendKeysWithWait(InputInvestMoney, value);
	}
	//��������������롰�����ʡ�
	public void InputLoanRate(String value){
		base.sendKeysWithWait(InputLoanRate,value);
	}
	//��������������롰Ͷ�����ޡ�
	public void InputLoanPhases(String value){
		base.sendKeysWithWait(InputloanPhases, value);
	}
	//ѡ�С���ʾ�ƻ�ʱ���
	public void checkShowPlanTable(){
		base.clickWithWait(PlanTableCheckBox);	
	}
	//����������е�������ϼ��㡱
	public void clickCalculateNowBtn(){
		base.clickWithWait(CalculateNowBtn);
	}
	
	//�ر����������
	public void clickCloseCalculatorBtn(){
		base.clickWithWait(CloseCalculatorBtn);
		base.checkNoElement(CloseCalculatorBtn);
	}
	//���롰Ͷ�ʽ����������ʡ�����Ͷ�����ޡ�������
	public void InputInvestInfos(String money,String rate,String phase,int i,String alert){
		InputMoney(money);
		InputLoanRate(rate);
		InputLoanPhases(phase);
		clickCalculateNowBtn();
		if(i==0){
			base.checkAlertText(alert);
		}else if(i==1){
			base.assertTrueByBoolean(!base.isAlertPresent(8));
		}
	}
	//��顰���ʽ����������ѡ��
	public void checkDropdownList(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(HBFXMode), "������Ϣ");
		base.assertTrueByBoolean(base.getElementNoWait(HBFXMode).isSelected());
		base.clickWithWait(RepayMode);
		List<WebElement> Options = base.getElements(HBFXMode);
		String [] Mode = {"������Ϣ","�ȶϢ","�ȶ��"};
		for(int i=0;i<Options.size();i++){
			base.assertEqualsActualExpected(Options.get(i).getText(), Mode[i]);
		}
	}
	//���������-����տ��ܶ����Ϣ
	public void checkAmountAndInterest(boolean showPlanTable,double money,double rate, int phase){
		if(showPlanTable){
			base.checkElementVisible(SKSJB);
			base.assertEqualsActualExpected(base.getElementText(SKSJBTxt), "�տ�ʱ���");
			String [] txt = {"�ڴ�","�տ�ʱ��","����ȡ��Ϣ","����ȡ����" ,"����ȡ�ܶ�","ʣ�౾��"};
			List<WebElement> titles = base.getElements(subTitle);
			for(int i=0;i<6;i++){
				base.assertEqualsActualExpected(titles.get(i).getText(), txt[i]);
			}
		}else{
			base.checkNoElement(SKSJB);
		}
		String amount = new DecimalFormat("###,##0.##").format(money*rate*0.01/12.0*phase+money);
//		System.out.println(money*rate*0.01/12*phase);
		String am="";
		if(amount.contains(",")){
			am= amount.replaceAll(",", "");
		}
		String interest = base.intMoney(Double.parseDouble(am)-money);
		if(interest.contains(",")){
			interest= interest.replaceAll(",", "");
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(AmountAndInterestTxt),"�տ��ܶ "+amount+"Ԫ    ��Ϣ�� "+interest+"Ԫ��ע��ʵ���տ��п�����Ϊ�³�����ϢΪ����������������Ǯ����");
	}
	public void checkDatainTable(double money,double rate,int phase){
		base.checkElementVisible(SKSJBTxt);
		String qici[]=new String[phase],time[]=new String[phase],MonthLX[]=new String[phase],MonthBJ[]=new String[phase],MonthAmount[]=new String[phase],RemainBJ[]=new String[phase];
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String monthlx=base.cutMoney(money*rate/1200);
		for(int i=0;i<phase;i++){
			qici[i]=String.valueOf(i+1);
			cal.add(Calendar.MONTH, 1);
			time[i]= df.format(cal.getTime());
			MonthLX[i]=monthlx;
			if((i+1)==phase){
				MonthBJ[i]= base.CutMoney(money);
				String monthli = "",monthbj="";
				if(monthlx.contains(",")||MonthBJ[i].contains(",")){
					monthli = monthlx.replace(",", "");
					monthbj = MonthBJ[i].replaceAll(",", "");
				}
				MonthAmount[i]= new DecimalFormat("###,##0.##").format(Double.parseDouble(monthli)+Double.parseDouble(monthbj));
				RemainBJ[i] = "0";
			}else{
				MonthBJ[i]= "0";
				MonthAmount[i]= monthlx;
				RemainBJ[i] = new DecimalFormat("###,##0.##").format(money);
			}
		}
		String table[][]={qici,time,MonthLX,MonthBJ,MonthAmount,RemainBJ};
		for(int i=1;i<=phase;i++){
			for(int j=1;j<6;j++){
				base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//tbody[@id='datatbody']/tr["+j+"]/td["+i+"]")), table[i-1][j-1]);
			}
		}
	}
	
	public void checkDefaultOptions(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(SelectedMode), "����");
		String color=base.getStyle("document.getElementById('repaymentDiv').getElementsByTagName('dd')[0]" ,"background-color");
		base.assertEqualsActualExpected(color, "rgb(255, 51, 0)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(SelectedPhase), "����");
		String color1=base.getStyle("document.getElementById('phasesDiv').getElementsByTagName('dd')[0]" ,"background-color");
		base.assertEqualsActualExpected(color1, "rgb(255, 51, 0)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(SelectedRate), "����");
		String color2=base.getStyle("document.getElementById('interDiv').getElementsByTagName('dd')[0]" ,"background-color");
		base.assertEqualsActualExpected(color2, "rgb(255, 51, 0)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(SelectedType), "����");
		String color3=base.getStyle("document.getElementById('typeDiv').getElementsByTagName('dd')[0]" ,"background-color");
		base.assertEqualsActualExpected(color3, "rgb(255, 51, 0)");
		if(base.getElementTextWithWait(ListContent).equals("")){
			System.out.println("Ͷ���б�ҳû�����ݣ�");
		}
	}
	public void clickRepayModeOption(String option){
		base.clickWithWait(By.xpath("//div[@id='repaymentDiv']/dl/dd[text()='"+option+"']"));
		base.checkElmentText(SelectedMode, option);
//		if(base.getElementTextWithWait(ListContent).equals("")){
//			System.out.println("û��"+option+"�Ľ�");
//		}else{
//			int lines = getUserImg().size();
//			for(int j=1;j<=lines;j++){
//				base.assertEqualsActualExpected(base.getElementText(By.xpath("//dd["+(j*5-2)+"]/p[2]")), option);
//			}
//		}
	}

	public void clickPhaseOption(String option){
		base.clickWithWait(By.xpath("//div[@id='phasesDiv']/dl/dd[text()='"+option+"']"));
		base.checkElmentText(SelectedPhase, option);
//		if(base.getElementTextWithWait(ListContent).equals("")){
//			System.out.println("û��"+option+"�Ľ�");
//		}else{
//			int beginphase = 0,endphase = 0;
//			String shuzi = option.substring(0,option.indexOf("����"));
//			if(shuzi.equals("3")){
//				beginphase=1;
//				endphase=3;
//			}else if(shuzi.equals("12")){
//				beginphase=12;
//				endphase=24;
//			}else if(shuzi.contains("��")){
//				beginphase = Integer.parseInt(shuzi.split("��")[0]);
//				endphase = Integer.parseInt(shuzi.split("��")[1]);
//			}
//			int lines = getUserImg().size();
//			for(int j=1;j<=lines;j++){
//				int RealPhase= Integer.parseInt(base.getElementTextWithWait(By.xpath("//dd["+(5*j-2)+"]/p/span")));
//				base.assertTrueByBoolean(RealPhase>=beginphase && RealPhase<=endphase);
//			}
//		}
	}
	
	public void clickRateOption(String option){
		base.clickWithWait(By.xpath("//div[@id='interDiv']/dl/dd[text()='"+option+"']"));
		base.checkElmentText(SelectedRate, option);
//		if(base.getElementTextWithWait(ListContent).equals("")){
//			System.out.println("û��"+option+"�Ľ�");
//		}else{
//			int beginrate = 0,endrate = 0;
//			String rate = option.substring(0,option.lastIndexOf("%"));
//			if(rate.equals("12")){
//				beginrate=1;
//				endrate=11;
//			}else if(rate.equals("18")){
//				beginrate=19;
//				endrate=22;
//			}else if(rate.contains("��")){
//				beginrate = Integer.parseInt(rate.substring(0,2));
//				endrate = Integer.parseInt(rate.split("��")[1]);
//			}
//			int lines = getUserImg().size();
//			for(int j=1;j<=lines;j++){
//				String Realrate= base.getElementTextWithWait(By.xpath("//dd["+(5*j-3)+"]/p[2]/span"));
//				if(!Realrate.equals("20.40%")){
//					int real = Integer.parseInt(Realrate.substring(0, Realrate.indexOf("%")));
//					base.assertTrueByBoolean(real>=beginrate && real<=endrate);
//				}else{
//					base.assertTrueByBoolean(rate.equals("18"));
//				}
//			}
//		}
	}

	public void checkOption(String Repayoption,String phaseoption,String rateoption,String typeoption){
		if(base.getElementTextWithWait(ListContent).equals("")){
			System.out.println("û��"+Repayoption+phaseoption+rateoption+typeoption+"�Ľ�");
		}else{	
			int lines = getUserImg().size();
			for(int j=1;j<=lines;j++){
				if(Repayoption.equals("�ȶ��")||Repayoption.equals("�ȶϢ")||Repayoption.equals("������Ϣ")){
					base.assertEqualsActualExpected(base.getElementText(By.xpath("//dd["+(j*5-2)+"]/p[2]")), Repayoption);
				}else if(phaseoption.equals("3��������")||phaseoption.equals("4��6����")||phaseoption.equals("7��11����")||phaseoption.equals("12��������")){
					int beginphase = 0,endphase = 0;
					String shuzi = phaseoption.substring(0,phaseoption.indexOf("����"));
					if(shuzi.equals("3")){
						beginphase=1;
						endphase=3;
					}else if(shuzi.equals("12")){
						beginphase=12;
						endphase=24;
					}else if(shuzi.contains("��")){
						beginphase = Integer.parseInt(shuzi.split("��")[0]);
						endphase = Integer.parseInt(shuzi.split("��")[1]);
					}
					int RealPhase= Integer.parseInt(base.getElementTextWithWait(By.xpath("//dd["+(5*j-2)+"]/p/span")));
					base.assertTrueByBoolean(RealPhase>=beginphase && RealPhase<=endphase);
				}else if(rateoption.equals("12%����")||rateoption.equals("12%��15%")||rateoption.equals("15%��18%")||rateoption.equals("18%����")){
					int beginrate = 0,endrate = 0;
					String rate = rateoption.substring(0,rateoption.lastIndexOf("%"));
					if(rate.equals("12")){
						beginrate=1;
						endrate=11;
					}else if(rate.equals("18")){
						beginrate=19;
						endrate=22;
					}else if(rate.contains("��")){
						beginrate = Integer.parseInt(rate.substring(0,2));
						endrate = Integer.parseInt(rate.split("��")[1]);
					}
					String Realrate= base.getElementTextWithWait(By.xpath("//dd["+(5*j-3)+"]/p[2]/span"));
					if(!Realrate.equals("20.40%")){
						int real = Integer.parseInt(Realrate.substring(0, Realrate.indexOf("%")));
						base.assertTrueByBoolean(real>=beginrate && real<=endrate);
					}else{
						base.assertTrueByBoolean(rate.equals("18"));
					}
				}else if(typeoption.equals("���ý��")||typeoption.equals("������Ѻ")||typeoption.equals("���ݵ�Ѻ")){
					String key = "";
					if(typeoption.equals("���ý��")){
						key="��";
					}else if(typeoption.equals("������Ѻ")){
						key="��";
					}else if(typeoption.equals("���ݵ�Ѻ")){
						key="��";
					}
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//dd["+(5*j-4)+"]/h3/span")), key);
				}
			}
		}
	}
}
