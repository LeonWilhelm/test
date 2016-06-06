package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;

/*
 * ��ծȨת���б�ҳ��
 */
public class CreditAssignListPage {
	
	Base base = new Base();
	Data data = new Data();
	IndexPage indexPage = new IndexPage();
	public String CreditAssignmentUrl = base.indexURL+"/new/loadAllPublishingCreditAssignList.action";
	
	By Search = By.xpath("//div[@class='wrap mt15 overflowV']/div/*/dl/dt");
	By ModeOption = By.cssSelector("#modeDiv>dl>dd");
	By DsbjOption = By.cssSelector("#dsbjDiv>dl>dd");
	By SyqxOption = By.cssSelector("#syqxDiv>dl>dd");
	By LoanTipTxt = By.cssSelector("h2");
	
	By CreditAssignListTxt = By.cssSelector(".font20");
	By AllCredit = By.cssSelector("div.lendtable>dl>dt");				//�б����ծȨ����
	By AllCreditClient = By.cssSelector(".wd200.fl.h40.pdl25");	
	public static By CreditTitle = By.cssSelector("div.lendtable>dl span");

	By AllPaginationLnk = By.xpath("//div[@id='Pagination']/ul/li");					//ҳ��
	By LastPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");						//ҳ���ĵ�6������
	public static By FirstCreditTitle = By.cssSelector("a.color3");						//��һ��ծȨ����
	public static By WaitPrincipalTxt = By.xpath("//div[2]/div[3]/dl/dd");				//���ձ�����
	public static By WaitPrincipalTxts = By.cssSelector("dd.wd130.fl.h40.textC.colorE6");
	public static By InterestRateTxt = By.xpath("//div[2]/div[3]/dl/dd[2]");			//��������
	public static By CurrentAndAllPeriodTxt = By.xpath("//div[2]/div[3]/dl/dd[3]");		//����/����
	public static By TransferModeTxt = By.xpath("//div[2]/div[3]/dl/dd[4]/i");			//ת��ģʽ
	public static By BuyNoworEndBtn = By.cssSelector("dd.wd140.fl.h40.textC>a");		//���̳��ۻ����̹�����ѽ���
	public static By BuyNowBtn = By.cssSelector("a.fast_money.mt8.ml25");				//���̳��ۻ����̹���
	By EndBtn = By.cssSelector("a.fast_buy.mt8.ml25");									//�ѽ���
	By BuyNowLnk1 = By.id("buy"+"*");
	By CloseLoginLnk = By.cssSelector("div.tit>a.close");	
	By LoginBackground = By.cssSelector("div.loginBg");

	By IncomeCalculatorLnk = By.cssSelector("a.lcjsq.fr");				//���������
	By CloseCalculatorBtn = By.cssSelector("a.count-close.fr");			//�ر����������
	By FAQLnk = By.xpath("//div[@class='loan_tip_auto']/*/a");								//ծȨת�ó�������
	By BeginnerGuide = By.xpath("//a[text()='����ָ��']");				//����ָ��
	By SearchBtn = By.id("findHelpContentBtn");							//��������
	
	By FixedPriceMode = By.xpath("//div[@id='modeDiv']/dl/dd[2]");		//һ�ڼ�
	By AuctionMode = By.xpath("//div[@id='modeDiv']/dl/dd[3]");			//����
	By SecretTransferMode = By.xpath("//div[@id='modeDiv']/dl/dd[4]");	//��ת
//	By SelectedMode = By.cssSelector("dd.bg86");
	By SelectedMode = By.cssSelector("#modeDiv dd.bg86");//������� 2015-7-13
	
	//����������ծȨ������
	public static By BuyCreditTip = By.id("loan_buy_tip");
	By BuyCreditTxt = By.cssSelector("div.tit.bdT > span.fl");
	By CashTip = By.cssSelector("div.lytt>h2.u-tt");
	By InputSecretTransferCode = By.id("transforCode");
	By AddNumberLnk = By.id("addnum");
	By CurrentPrice = By.id("upsetprice");
	By WaitPI = By.id("dfbx");
	By BalancePrice = By.id("userbalance");
	By InputPrice = By.id("currnum");
	By InputPayPwd = By.id("paypassword");
	By InputValidateCode = By.id("creditCode");
//	By yanZhengMaImg = By.cssSelector("#checkverificationCode_fast > a > img");
	By yanZhengMaImg = By.cssSelector("#boximage>img");
	By OkBtn = By.cssSelector("input.loan_btn_Ok");
	By CancelBtn = By.cssSelector("input.loan_btn_Cannel");
	By ContinueBuyBtn = By.xpath("//div[@id='loan_bid_tip1']/p[2]/input");
//	By SuccessTip = By.id("loan_bid_tip");
	By CloseTipLnk = By.cssSelector("#loan_bid_tip>div.tit>a.close");			//�رճɹ�����
	By BackListLnk = By.id("backButton");
	By LoanBackground = By.id("loan_buy_bg");
	public static By SuccessTxt = By.id("buy_success_tip");
	
	public void verifyDataLnk(){
		String [] Searches = {"ת��ģʽ��","���ձ���","ʣ�����ޣ�"};
		base.checkElement(Search);
		List<WebElement> SearchTxt = base.getElements(Search);
		for(int i = 0; i<3; i++){
			base.assertEqualsActualExpected(SearchTxt.get(i).getText(), Searches[i]);
		}
		String [] ModeTxt = {"����","һ�ڼ�","����","��ת"};
		String [] DsbjTxt = {"����","1000Ԫ����","1000��3000Ԫ","3000��10000Ԫ","10000Ԫ����"};
		String [] SyqxTxt = {"����","3��������","4-6����","7-11����","12��������"};
		List<WebElement> Modes = base.getElements(ModeOption);
		List<WebElement> Dsbjs = base.getElements(DsbjOption);
		List<WebElement> Syqxs = base.getElements(SyqxOption);
		for(int i=0;i<4;i++){
			base.assertEqualsActualExpected(Modes.get(i).getText(),ModeTxt[i]);
			base.assertEqualsActualExpected(Dsbjs.get(i).getText(),DsbjTxt[i]);
			base.assertEqualsActualExpected(Syqxs.get(i).getText(),SyqxTxt[i]);
		}
		base.assertEqualsActualExpected(Dsbjs.get(4).getText(),DsbjTxt[4]);
		base.assertEqualsActualExpected(Syqxs.get(4).getText(),SyqxTxt[4]);
		base.assertEqualsActualExpected(base.getElementText(LoanTipTxt),"ծȨת�ó�������");
		String [] Tips = {"ʲô��ծȨת�ã�","���ת�����е�ծȨ��","ծȨת���費��Ҫ֪ͨծ���ˣ�","���ծȨ���Ƿ������ת�ã�"};
		List<WebElement> TipTxt = base.getElements(FAQLnk);
		for(int i=0;i<4;i++){
			base.assertEqualsActualExpected(TipTxt.get(i).getText(),Tips[i]);
			if(i==3){
				base.assertEqualsActualExpected(TipTxt.get(i).getAttribute("href"), "javascript:loadQuest(62);");
			}else{
				base.assertEqualsActualExpected(TipTxt.get(i).getAttribute("href"), "javascript:loadQuest(61);");
			}
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(CreditAssignListTxt),"ծȨת���б�");
		clickIncomeCalculatorLnk();
		clickCloseCalculatorBtn();
	}
	
	//ѡ��һ�ڼۡ�ת��ģʽ
	public void clickFixedPriceMode(){
		base.clickWithWait(FixedPriceMode);
		base.checkElmentText(SelectedMode, "һ�ڼ�");
	}
	//ѡ��������ת��ģʽ
	public void clickAuctionMode(){
		base.clickWithWait(AuctionMode);
		base.checkElmentText(SelectedMode, "����");
	}
	//ѡ����ת��ת��ģʽ
	public void clickSecretTransferMode(){
		base.clickWithWait(SecretTransferMode);
		base.checkElmentText(SelectedMode, "��ת");
	}
	//�����ծȨת�ó������⡱����
	public void clickFQALnk(){
		base.clickElementNoWait(FAQLnk);
//		base.checkTitle("��������������");
		base.checkElement(SearchBtn);
	}
	//����������������
	public void clickIncomeCalculatorLnk(){
		base.clickWithWait(IncomeCalculatorLnk);
		base.checkElement(CloseCalculatorBtn);
	}
	//�ر����������
	public void clickCloseCalculatorBtn(){
		base.clickElementNoWait(CloseCalculatorBtn);
		base.checkElement(IncomeCalculatorLnk);
	}
	//�����һ��ծȨת�õı���
	public void clickFirstCreditTitle(){
		base.clickElementNoWait(FirstCreditTitle);
	}
	public Boolean ifshowCreditAssign(){
		return base.isElementVisible(CreditAssignListPage.FirstCreditTitle);
//		return base.isElementPresent(CreditAssignListPage.FirstCreditTitle);
	}
	//�����һ��ծȨת�õı���
	public void clickFirstDebtTitle(){
		String Title = base.getElementText(FirstCreditTitle);	
//		int window = base.Windowsize();
//		if(base.Windowsize()==window){
		base.clickWithWait(FirstCreditTitle);	
//		}
		base.jumpToNewWindow();
		base.checkElement(CreditDetailPage.DetailPart);
		base.assertEqualsActualExpected(base.getElementTextWithWait(CreditDetailPage.CreditTitleinDetail), Title);
	}
	public Boolean ifshowCreditforBuy(){
		
		Boolean result = false;
		if(base.isElementPresent(CreditAssignListPage.BuyNoworEndBtn)){
			if(!base.getElementText(CreditAssignListPage.BuyNoworEndBtn).equals("�ѽ���")){		
				result = true;
			}
		}	
		return result;
	}
	public void verifyDebtData(){
		try{
			String WaitPrincipal = base.getElementText(WaitPrincipalTxt);
			String InterestRate = base.getElementText(InterestRateTxt);
			String Periods = base.getElementText(CurrentAndAllPeriodTxt);
			int position = Periods.lastIndexOf("/");
			int EndDate =  Integer.valueOf(Periods.substring(position+1)).intValue();
			int BeginDate =  Integer.valueOf(Periods.substring(0,position)).intValue();
			String TransferMode= base.getElementText(TransferModeTxt);
			clickFirstDebtTitle();
			base.assertEqualsActualExpected(base.getElementText(CreditDetailPage.WaitPrincipalTxt), "���ձ��𣺣�"+WaitPrincipal+"Ԫ");
			base.assertEqualsActualExpected(base.getElementText(CreditDetailPage.InterestRateTxt)+"%", InterestRate);
			base.assertEqualsActualExpected(base.getElementText(CreditDetailPage.TransferModeTxt), TransferMode);
			base.assertEqualsActualExpected(base.getElementText(CreditDetailPage.RemainDateTxt), String.valueOf(EndDate-BeginDate+1));
			if(!base.getElements(CreditDetailPage.BuyNowBtn).isEmpty()){
				if(base.getLnkElementText(CreditDetailPage.BuyNowBtn,"value").equals("���̹���")){
					base.assertEqualsActualExpected(base.getLnkElementText(CreditDetailPage.BuyNowBtn,"value"),"���̹���");
				}else{
					base.assertEqualsActualExpected(base.getLnkElementText(CreditDetailPage.BuyNowBtn,"value"),"���̳���");
				}
			}
			base.closeWebDriver();
		}catch(Exception e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//�Ƿ���ڿɹ����С��100Ԫ��ծȨת��
	public Boolean compareCreditMoney(){
		Boolean result = false;
		List<WebElement> BuyNowBtns = base.getElements(BuyNowBtn);
		int size = BuyNowBtns.size();
		for(int i =0 ; i<size ; i++){		
			String onclick = BuyNowBtns.get(i).getAttribute("onclick");
			String id = onclick.split("'")[1];
			String WaitPrincipalTxt = base.getElementText(By.xpath("//dd[@id="+id+"]/preceding::dd[4]"));
			WaitPrincipalTxt=WaitPrincipalTxt.replaceAll(",", "");
			float WaitPrincipal = Float.parseFloat(WaitPrincipalTxt);
			float number;
			if(base.indexURL.contains("test")||base.indexURL.contains("www")){
				number = 100;
			}else{
				number = 5000;
			}		
			if(WaitPrincipal>0 && WaitPrincipal<=number){
				base.clickElement(BuyNowBtn, i);
				if(base.isAlertPresent(10)){
					base.acceptAlert();
					System.out.println("�û����ܹ����Լ���ծȨ�������˺Ź���");
					Reporter.log("<br/>�û����ܹ����Լ���ծȨ�������˺Ź���");
					base.logout();
					new LoginPage().login(Data.tel_run_zhaiquan2,Data.password, Data.zzmm, Data.test4_tel,Data.test4_password, Data.test4_zzmm);
					base.openBrowser(CreditAssignmentUrl);
					base.clickElement(BuyNowBtn, i);
				}	
//				}else{
					String currentprice= base.getElementTextWithWait(CurrentPrice);
					String waitPI = base.getElementText(WaitPI);
					String balancePrice = base.getElementText(BalancePrice);
					waitPI=waitPI.replaceAll(",", "");
					float MyPrice =  Float.parseFloat(currentprice);
					float waitPIPrice = Float.parseFloat(waitPI);
					float balanceprice = Float.parseFloat(balancePrice);
					if((MyPrice+1)<waitPIPrice && balanceprice>=(MyPrice+1)){
						result = true;
						break;
					}else{
						clickCancelBtn();
					}
//				}
			}
		}
		return result;
	}
	
	//���ĳ��ծȨ�ġ����̳��ۡ������̹���
	public void clickIndexBuyNowBtn(int index){
		base.clickElement(BuyNowBtn, index);
	}
	//�Ƿ���ʾ�����̳��ۡ������̹���
	public Boolean ifshowBuyNowBtn(){
		return base.isElementPresent(CreditAssignListPage.BuyNowBtn);
	}
	//�����һ��ծȨ�ġ����̳��ۡ������̹���
	public void clickFirstBuyNowBtn(){
		
		if(base.getLnkElementText(new LoginPage().RegisterLnk, "class").contains("hide")){
			base.clickWithWait(BuyNowBtn);
			base.checkElementVisible(LoginPage.LoginBox);
		}else{
			base.clickWithWait(BuyNowBtn);	
		}	
		if(base.Windowsize()>1){
			base.turnToOldPage();
		}
	}
	//����رյ�¼ҳ
	public void clickCloseLoginLnk(){
		
		if(base.isElementPresentNoWait(LoginPage.Iframe)){
			base.switchToFrame("loginBoxFrame");
		}
		base.clickWithWait(CloseLoginLnk);
		base.fromFrameToDefaultContent();
		base.checkElementVisible(CreditAssignListTxt);
	}
	public void checkAlert(){
		if(base.isAlertPresent(10)){
			base.assertEqualsActualExpected(base.getAlert().getText(), "���ܹ����Լ���ծȨ");
		}
	}
	//���롰��ת�롱
	public void InputTransferCode(){
		base.checkElement(InputSecretTransferCode);
		base.elementSendkey(InputSecretTransferCode, "4521");
	}
	//�����Ҫ���۵ġ�+��
	public void clickAddLnk(){
		base.checkElement(AddNumberLnk);
		base.clickWithWait(AddNumberLnk);
	}
	//�ȽϾ��ļ۸�ʹ��ձ�Ϣ
	public Boolean comparePrice(){
		String currentprice= base.getElementText(CurrentPrice);
		String waitPI = base.getElementText(WaitPI);
		float MyPrice =  Float.valueOf(currentprice).floatValue();
		float waitPIPrice = Float.valueOf(waitPI).floatValue();
		if((MyPrice+1)>waitPIPrice){
			return false;
		}else{			
			return true; 
		}
	}
	//���롰��Ҫ���ۡ��Ľ��
	public void InputMyPrice(){
		String Price= base.getElementText(CurrentPrice);
		int MyPrice =  Integer.valueOf(Price).intValue();
		base.sendKeyAndWait(InputPrice, String.valueOf(MyPrice+1));
	}
	//���롰֧�����롱
	public void InputPayPwd(String pwd){
		base.sendKeyAndWait(InputPayPwd, pwd);
	}
	//���롰��֤�롱
	public void InputValidateCode(){
//		String ValidateCode = data.get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
//		base.elementSendkey(InputValidateCode, ValidateCode);
		base.clickWithWait(yanZhengMaImg);
	}
	//���롰ȷ������ť
	public void clickOkBtn(){
		base.clickElementNoWait(OkBtn);
	}
	public void clickCancelBtn(){
		base.clickElementNoWait(CancelBtn);
		base.assertTrueByBoolean(!base.isBlock(LoanBackground));
	}
	//�����������������ť
	public void clickContinueBtn(){
		base.clickWithWait(ContinueBuyBtn);
		base.sleep(10000);
//		base.checkElmentwithTxt(SuccessTxt, "��ϲ�����۳ɹ�");
	}
	//����ɹ������Ĺر�����
	public void clickCloseSuccessLnk(){
		base.clickWithWait(CloseTipLnk);
		base.checkNoElement(CloseTipLnk);
		base.checkElementVisible(CreditAssignListTxt);
//		base.assertTrueByBoolean(!base.isBlock(LoanBackground));
	}
	//��鹺��ɹ�������ծȨ
	public void CheckBuySuccess(String txt){
		if(base.getElementTextWithWait(SuccessTxt).equals("��֤�����")){
			clickCloseSuccessLnk();
			System.out.println("��֤�����");
			Assert.fail("��֤�����!");
		}else{
			base.assertEqualsActualExpected(base.getElementText(SuccessTxt), txt);
			clickCloseSuccessLnk();
		}
	}
	//���������ծȨת���б�����
	public void clickBackListLnk(){
		base.clickElementNoWait(BackListLnk);
		base.assertTrueByBoolean(!base.isBlock(LoanBackground));
	}
	//���ծȨת�õ�����
	public int getNumofAllCredit(){
		
		if(base.getElements(LastPageLnk).isEmpty()){
			if(base.getElements(AllCredit).isEmpty()){
				return 0;
			}else{
				return base.getElements(AllCredit).size();
			}
		}else{
			int paginationsize = base.getElements(AllPaginationLnk).size();//13
			base.clickElementNoWait(By.xpath("//div[@id='Pagination']/ul/li["+paginationsize+"]"));
			int lastPageNum = Integer.valueOf(base.getElementText(By.xpath("//div[@id='Pagination']/ul/li["+(paginationsize-2)+"]"))).intValue();
			int CreditNuminCurrentPage= base.getElements(AllCredit).size();
			return (lastPageNum-1)*10+CreditNuminCurrentPage;
		}
	}	
	//��֤��ҳ
	public void verifyCreditPagination(){
		
		if(base.getElements(LastPageLnk).isEmpty()){
			if(base.getElements(AllCredit).isEmpty()){
				System.out.println("û��ծȨת����Ϣ��");
				Reporter.log("û��ծȨת����Ϣ��");
			}else{
				int CreditNuminFirstPage = base.getElements(AllCredit).size();
				if(CreditNuminFirstPage<=10){
					System.out.println("��һҳ��"+CreditNuminFirstPage+"��ծȨת����Ϣ��");
				}else{
					Assert.fail("���ֻ����10��ծȨת����Ϣ��");
				}
			}
		}else{
//			int CreditNuminFirstPage = base.getElements(AllCredit).size();//����ԭ������
			//��������ʱ�޸� 2015-7-10
			int CreditNuminFirstPage;
			if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
				CreditNuminFirstPage = base.getElements(AllCreditClient).size();
			}
			else{
				CreditNuminFirstPage = base.getElements(AllCredit).size();
			}
			//�޸�end
			if(CreditNuminFirstPage==10){
				System.out.println("��һҳ��10��ծȨת����Ϣ��");
			}else{
				Assert.fail("��һҳծȨת����Ŀ��ʾ����");
			}
		}
	}		
}
