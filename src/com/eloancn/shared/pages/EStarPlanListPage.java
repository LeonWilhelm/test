package com.eloancn.shared.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;

/*
 * �����Ǽƻ����б�ҳ��
 */
public class EStarPlanListPage {
	
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	
	public String EStarPlanUrl = base.indexURL+"/wut/loadAllWutRecords.action";				
	//�ϲ�banner
	public static By ViewDetailLnk = By.cssSelector("a.ban_detailebtn");								//�鿴����
	By StarImg = By.cssSelector("div.stars>img");														//����ͼ��
	By TxtBelowImg = By.cssSelector("div.wrap posiR>div");//size=6										//�����ı�
	
	//���������
	By IncomeCalculatorLnk = By.cssSelector("div.calculator_ico");										//�������������
	By CloseCalculatorBtn = By.cssSelector(".count-close.fr");											//�ر����������  a.count-close.f
	
	//���Ǽƻ�ҳ����Ϣ
	public static By AllPlan = By.cssSelector("div.wtplan_box.mt25");									//һ�������Ǽƻ���Ʒ
	By SixPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");										//ҳ���ĵ�6������
	public static By AllPaginationLnk = By.xpath("//div[@id='Pagination']/ul/li");						//ҳ��
	
	//״̬ͼ
	By LeftIconLnk = By.cssSelector("div.wtplan_box.mt25>a");											//��Ʒ����״̬ͼ
	public By compluteIcon = By.cssSelector("a.wtplan_box_left.complute");								//��������״̬ͼ
	public By endIcon = By.cssSelector("a.wtplan_box_left.end");										//�ѽ�����״̬ͼ
	public By goingIcon = By.cssSelector("a.wtplan_box_left.going");									//�����е�״̬ͼ
	public By PlanMoney = By.xpath("//a/div/p[2]/span");					       			 			//���״̬ͼ�С��ƻ��ܶ
	//���Ǽƻ���Ʒ
	public static By FirstEStarTitle = By.cssSelector("a.wtplan_link_h1");		   			 			//���Ǽƻ���Ʒ����
	By EStarTitleForInvest = By.xpath("//span[@class='wtplan_td6 wtplan_line_btn go']/ancestor::div[3]/preceding::a[1]");//��Ͷ�ʵ����Ǽƻ�����
	By DueDateTxt = By.cssSelector("span.wtplan_time.font20.colorff.fr");								//���ϽǵĽ�ֹʱ��
	By OpenSoonTxt = By.cssSelector("span.wtplan_time.font20.colorff.fr");								//���Ͻǵġ��������š�����
	public static By InvestNowLnk = By.cssSelector("span.wtplan_td6.wtplan_line_btn.go");				//������Ͷ�ʡ�����
	By OpenSoonLnk = By.cssSelector("span.wtplan_td6.wtplan_line_btn.over");							//��Ч�ġ��������š�����������Ͷ�ʡ�����
	By CloseLoginLnk = By.cssSelector("div.tit>a.close");												//��¼���ڵġ��رա�����
	By LoginBackground = By.cssSelector("div.loginBg");													//��¼���ں�ı�����ʾ
	public static By Background = By.cssSelector("div.wtplan_blackbg");									//����Ͷ�ʴ��ں�ı�����ʾ

	//�����ǣ������ǣ�������
	By ThreeLines = By.cssSelector("div.table-container.wtplan_table");									//�����ǣ������ǣ�����������
	By BZStarInfo = By.xpath("//div[@class='wtplan_box_right']/div[2]/div/div");						//��������Ϣ��ļ�������ʡ�������ޡ����㷽ʽ��
	By SYStarInfo = By.xpath("//div[@class='wtplan_box_right']/div[3]/div/div");						//��������Ϣ��ļ�������ʡ�������ޡ����㷽ʽ��
//	public static By BZStarInvestNowLnk = By.cssSelector("div.wtplan_box_right>div:nth-child(4)>div>div.wtplan_table_td7.fl>span.wtplan_td6.wtplan_line_btn.go");
//	public static By SYStarInvestNowLnk = By.cssSelector("div.wtplan_box_right>div:nth-child(5)>div>div.wtplan_table_td7.fl>span.wtplan_td6.wtplan_line_btn.go");
	public static By BZStarInvestNowLnk = By.xpath("//div[@class='pdb20']/following-sibling::div[1]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']");//��������Ч�ġ�����Ͷ�ʡ���ť
	public static By SYStarInvestNowLnk = By.xpath("//div[@class='pdb20']/following-sibling::div[2]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']");//��������Ч�ġ�����Ͷ�ʡ���ť
	By EStarTitleforInvestBZStar = By.xpath("//div[@class='pdb20']/following-sibling::div[1]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']/ancestor::div[3]/preceding::a[1]");//��Ͷ�ʵı����ǵĲ�Ʒ����
	By EStarTitleforInvestSYStar = By.xpath("//div[@class='pdb20']/following-sibling::div[2]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']/ancestor::div[3]/preceding::a[1]");//��Ͷ�ʵ������ǵĲ�Ʒ����
	public static By FirstBZStarInvestLnk = By.xpath("//body/div[18]/div[2]/div/div[2]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']");//��һ����Ʒ�����ǵ���Ч�ġ�����Ͷ�ʡ���ť
	public static By FirstSYStarInvestLnk = By.xpath("//body/div[18]/div[2]/div/div[3]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']");//��һ����Ʒ�����ǵ���Ч�ġ�����Ͷ�ʡ���ť
	
	//������Ͷ�ʴ���
	By BZStarInvestTitle = By.cssSelector("#wtplan_alert1 > div.wtplan_alert_t");						//��Ͷ����Ϣ��������
	By InputAmount = By.id("wutBuyAmount1");															//��������������
	By BZStarNeedAmountTxt = By.id("needAmount1");														//�������ȡ��Ľ��
	By BZStarBalanceTxt = By.id("userBalance1");														//���������Ľ��
	By BZStarCalculateTxt = By.xpath("//div[@id='wtplan_alert1']/div[2]/table/tbody/tr[4]/td/span");	// *100=100Ԫ
	By InputPayPwd = By.id("payPwd1");																	//��֧�����롱�����
	By InputValidateCode = By.id("wutRandCode1");														//����֤�롱�����
	By yanZhengMaImg = By.cssSelector("#checkverificationCode_fast > a > img");							//����֤�롱ͼƬ
//	By AgreeCheckbox = By.id("xy1");
	By AgreeCheckbox = By.xpath("//div[@id='wtplan_alert1']/div[2]/p/input");							//�������Ķ���ͬ�⡶������Ͷ���ˡ��������ĸ�ѡ��
	By OkBtn = By.cssSelector("#wtplan_alert1>div>p>input.wtplan_quedingbtn.ml15");						//��ȷ����Ͷ�ʰ�ť
	By InvestSuccessTxt = By.cssSelector("div.msg_ico.success_ico");									//��Ͷ�ʳɹ����ı���ʾ
	By InvestErrorTxt = By.cssSelector("div.msg_ico.error_ico");										//����������ı���ʾ
	By ShowErrorTxt = By.id("showError");																//��ϸ�Ĵ�����Ϣ
	By CloseInvestSuccessLnk = By.cssSelector("#wtplan_alert4>div>a.wtplan_close_x");					//Ͷ�ʳɹ����ڡ��رա�����
	By CloseInvestErrorLnk = By.cssSelector("#wtplan_alert5>div>a.wtplan_close_x");						//Ͷ��ʧ�ܴ��ڡ��رա�����
	By IndividualViewLnk = By.id("tzSuccess");															//�����������Ĳ鿴������
	By MonthPlanTxt = By.id("monthBack");																//�ҵ��˻�-�ҵ�Ͷ�ʼƻ�-����Ӧ�յļƻ�
	
	//������Ͷ�ʴ���
	public static By SYStarRiskTitle = By.cssSelector("#wtplan_alert3 > div.wtplan_alert_t");			//��������ʾ��������
	public static By SYStarInvestTitle = By.cssSelector("#wtplan_alert2>div.wtplan_alert_t");			//��Ͷ����Ϣ��������
	By DenyBtn = By.xpath("//input[@value='�ܾ�']");														//���ܾ�����ť
	By AgreeBtn = By.xpath("//input[@value='ͬ��']");														//��ͬ�⡱��ť
	By CloseSYStarInvestBoxLnk = By.cssSelector("#wtplan_alert2>div>a.wtplan_close_x");					//Ͷ�ʴ��ڡ��رա�����
	By InputSYStarAmount = By.id("wutBuyAmount2");														//��������������
	By SYStarNeedAmountTxt = By.id("needAmount2");														//�������ȡ��Ľ��
	By SYStarCalculateTxt = By.cssSelector("span.font16.color6");										// *500=500Ԫ
//	By ShowAmountTxt = By.id("showBuyAmount2");
	By InputSYStarPayPwd = By.id("payPwd2");															//��֧�����롱�����
	By InputSYStarValidateCode = By.id("wutRandCode2");													//��������������
	By SYStarAgreeCheckbox = By.id("xy2");																//�������Ķ���ͬ�⡶���Э�顷�����ϡ��������ĸ�ѡ��
	By SYStarOkBtn = By.xpath("//input[@value='ȷ��']");													//��ȷ����Ͷ�ʰ�ť
	By SYStarCancelBtn = By.xpath("//input[@value='ȡ��']");												//��ȡ����Ͷ�ʰ�ť
	
	//������Ǽƻ��б�ҳ��ҳ
	public void verifyYXPlanPagination(){
		base.checkElement(ViewDetailLnk);
		if(base.isElementPresent(SixPageLnk)){
			int PlanNuminFirstPage = base.getElements(AllPlan).size();
			if(PlanNuminFirstPage==10){
				System.out.println("��һҳ��10�����Ǽƻ���Ʒ��Ϣ��");
			}else{
				Assert.fail("��һҳծȨת����Ŀ��ʾ����");
			}

		}else{
			if(base.isElementPresent(AllPlan)){
				int PlanNuminFirstPage = base.getElements(AllPlan).size();
				if(PlanNuminFirstPage<=10){
					System.out.println("��һҳֻ��"+PlanNuminFirstPage+"�����Ǽƻ���Ϣ��");
				}else{
					Assert.fail("��һҳ���ֻ����10�����Ǽƻ���Ϣ��");
				}
			}else{
				System.out.println("û�����Ǽƻ���Ϣ��");
			}

		}
	}
	//������Ǽƻ���Ʒ������
	public int getNumofAllPlan(){
		if(base.getElements(SixPageLnk).isEmpty()){
			if(base.getElements(AllPlan).isEmpty()){
				return 0;
			}else{
				return base.getElements(AllPlan).size();
			}
		}else{
			int paginationsize = base.getElements(AllPaginationLnk).size();
			base.clickElementNoWait(By.xpath("//div[@id='Pagination']/ul/li["+paginationsize+"]"));
			int lastPageNum = Integer.valueOf(base.getElementText(By.xpath("//div[@id='Pagination']/ul/li["+(paginationsize-2)+"]"))).intValue();
			int CreditNuminCurrentPage= base.getElements(AllPlan).size();
			return (lastPageNum-1)*10+CreditNuminCurrentPage;
		}
	}
	//������Ǽƻ��б�ҳ����
	public void verifyDataLnk(){
		base.assertEqualsActualExpected(base.getLnkElementText(ViewDetailLnk, "href"), base.indexURL+"/page/wut/wutDetail.jsp");
		List<WebElement> StarImgs = base.getElements(StarImg);
		String ImgUrl = base.indexURL+"/page/wut/images/";
		String [] pngs = {"star1.png","star2.png","star3.png","star4.png"};
		for(int i = 0; i< StarImgs.size();i++){
			base.assertEqualsActualExpected(StarImgs.get(i).getAttribute("src"), ImgUrl+pngs[i]);
		}
		String [] txts = {"��ɢͶ��\nծȨ������ۣ�������\n���Ʊ�Ϊ���ʿ��ơ�","ȫ��͸��\n����ˡ��Ƽ��ˡ������ʡ�\n��֤�𣬾�Ϊ��չʾ��","˫������\n�������ż�ծȨ�ڲ����ţ�\n˫�����ţ����б��ϡ�","�ṹ����\nʡ��Ͷ�ʣ�רҵͶ�ʣ���\n��һ\"��\"�ʺ�����"};
		List<WebElement> Txt = base.getElements(TxtBelowImg);
		for (int i =0;i<Txt.size();i++){
			base.assertEqualsActualExpected(Txt.get(i+2).getText(), txts[i]);
		}	
		clickIncomeCalculatorLnk();
		clickCloseCalculatorBtn();
		String href = base.indexURL+"/wut/loadWutRecordDetail.action?id=";
		if(base.isElementPresent(AllPlan)){
			List<WebElement> Lines = base.getElements(ThreeLines);
			for(int i = 0 ;i <Lines.size();i++){
				Lines.get(i).isDisplayed();
			}
			String id = base.getLnkElementText(DueDateTxt, "id");
			base.assertEqualsActualExpected(base.getLnkElementText(LeftIconLnk,"href"),href+id);
			base.assertEqualsActualExpected(base.getLnkElementText(FirstEStarTitle,"href"), href+id);
		}
	}
	//������鿴���顱
	public void clickViewDetailLnk(){
		base.clickElementNoWait(ViewDetailLnk);
	}
	//������������ͼ��
	public void clickIncomeCalculatorLnk(){
		base.clickElementNoWait(IncomeCalculatorLnk);
		base.checkElement(CloseCalculatorBtn);
	}
	//�ر����������
	public void clickCloseCalculatorBtn(){
		base.clickWithWait(CloseCalculatorBtn);
		base.checkElement(IncomeCalculatorLnk);
	}
	//�Ƿ�������Ǽƻ���Ʒ
	public Boolean ifshowEStarPlan(){
		return base.isElementPresent(EStarPlanListPage.FirstEStarTitle);
	}
	
	//���״̬ͼ
	public void clickIcon(By by1,By by2){
		if(base.isElementPresent(by1)){
			base.clickWithWait(by1);
			base.jumpToNewWindow();
			base.assertTrueBy(by2);
			base.closeAndjumptoOldWindow();
		}else{
			String status = by1.toString().split("\\.")[3];
			System.out.println("û��"+status+"״̬�����Ǽƻ���");
			Reporter.log("û��"+status+"״̬�����Ǽƻ���"+"<br/>");
		}
	}
	
	//�����һ�����Ǽƻ���Ʒ����
	public void clickFirstEStarTitle(){
		base.checkElement(FirstEStarTitle);
		String Title = base.getElementText(FirstEStarTitle);
		int window = base.Windowsize();
		base.clickElementNoWait(FirstEStarTitle);	
		if(base.Windowsize()==window){
			base.clickElementNoWait(FirstEStarTitle);
		}
		base.jumpToNewWindow();
		base.assertEqualsActualExpected(base.getElementTextWithWait(EStarDetailPage.EStarTitleinDetail), Title);
	}
	
	//�������Ͷ�ʵ����Ǽƻ���Ʒ����
	public void clickEStarTitleforInvest(){
//		String Title = base.getElementText(EStarTitleForInvest);
		int window = base.Windowsize();
		base.clickElementNoWait(EStarTitleForInvest);	
		if(base.Windowsize()==window){
			base.clickElementNoWait(EStarTitleForInvest);
		}
		base.jumpToNewWindow();
		base.checkElement(EStarDetailPage.DetailPart);
//		base.assertEqualsActualExpected(base.getElementText(EStarDetailPage.EStarTitleinDetail), Title);
	}
	//�������Ͷ�������ǵ����Ǽƻ���Ʒ����
	public void clickTitleforInvestSYStar(){
		base.checkElement(EStarTitleforInvestSYStar);
		String Title = base.getElementText(EStarTitleforInvestSYStar);
		int window = base.Windowsize();
		base.clickElementNoWait(EStarTitleforInvestSYStar);	
		if(base.Windowsize()==window){
			base.clickElementNoWait(EStarTitleforInvestSYStar);
		}
		base.jumpToNewWindow();
		base.checkElement(EStarDetailPage.DetailPart);
		base.assertEqualsActualExpected(base.getElementText(EStarDetailPage.EStarTitleinDetail), Title);
	}
	//�������Ͷ�ʱ����ǵ����Ǽƻ���Ʒ����
	public void clickTitleforInvestBZStar(){
		String Title = base.getElementTextWithWait(EStarTitleforInvestBZStar);
		int window = base.Windowsize();
		base.clickElementNoWait(EStarTitleforInvestBZStar);	
		if(base.Windowsize()==window){
			base.clickElementNoWait(EStarTitleforInvestBZStar);
		}
		base.jumpToNewWindow();
		base.checkElement(EStarDetailPage.DetailPart);
		base.assertEqualsActualExpected(base.getElementTextWithWait(EStarDetailPage.EStarTitleinDetail), Title);
	}
	//���������ݣ�ļ�������ʡ�������ޡ����㷽ʽ��ʾ��
	public ArrayList<String> BZStarInfo(){
		ArrayList<String> list = new ArrayList<String>();
		List<WebElement> info = base.getElements(BZStarInfo);
		for(int i=0;i<4;i++){
			list.add(info.get(i+1).getText());
		}
		return list;
	}
	
	//���������ݣ�ļ�������ʡ�������ޡ����㷽ʽ��ʾ��
	public ArrayList<String> SYStarInfo(){
		ArrayList<String> list = new ArrayList<String>();
		List<WebElement> info = base.getElements(SYStarInfo);
		for(int i=0;i<4;i++){
			list.add(info.get(i+1).getText());
		}
		return list;
	}
	
	//�Ƿ���ʾ������Ͷ�ʡ�����
	public Boolean ifshowInvestNowLnk(){
		return base.isElementPresent(EStarPlanListPage.InvestNowLnk);
	}
	/**
	 * ���������Ͷ�ʡ�����
	 * @author ����
	 */
	public void clickFastInvestLnk(){
		if(base.getLnkElementText(LoginPage.RegisterLnk, "class").contains("hide")){
			base.clickElementNoWait(InvestNowLnk);
			base.checkElementVisible(LoginPage.LoginBox);
		}else{
			base.clickElementNoWait(InvestNowLnk);
		}		
	}
	public void clickCloseLoginLnk(){
		
		if(base.isElementPresentNoWait(LoginPage.Iframe)){
			base.switchToFrame("loginBoxFrame");
		}
		base.clickWithWait(CloseLoginLnk);
		base.fromFrameToDefaultContent();
		base.checkElementVisible(StarImg);
	}
	//�Ƿ���ʾ�����ǡ�����Ͷ�ʡ�����
	public Boolean ifshowBZStarInvestNowLnk(){
		return base.isElementPresent(EStarPlanListPage.BZStarInvestNowLnk);
	}
	//��������ǡ�����Ͷ�ʡ�����
	public void clickBZStarInvestNowLnk(){
		if(base.getElementText(IndexPage.userName).equals("")){
			base.clickWithWait(BZStarInvestNowLnk);
			base.checkElement(LoginPage.LoginBox);
		}else{
			base.clickWithWait(BZStarInvestNowLnk);
			base.assertTrueByBoolean(base.getElementTextWithWait(BZStarInvestTitle).contains("Ͷ����Ϣ"));
		}
	}
	//���뱣����Ͷ�ʽ��
	public void InputInvestAmount(){
		base.sendKeysWithWait(InputAmount, "1");
	}
	//�Ƚϱ�����Ͷ�ʶ����Ҫ��ȵĴ�С
	public boolean BZStarCompareAmount(){
//		String calculateTxt = base.getElementText(BZStarCalculateTxt);
//		int EndPosition = calculateTxt.lastIndexOf("=");
//		int EachAmount = Integer.valueOf(calculateTxt.substring(1, EndPosition)).intValue();
//		int TotalAmount = Integer.valueOf(base.getElementText(BZStarNeedAmountTxt)).intValue();
		Double Balance = Double.parseDouble(base.getElementText(BZStarBalanceTxt));
//		if(EachAmount<=TotalAmount)
		if(Balance>=100.0){
			return true;
		}else{
			return false;
		}	
	}
	//���뱣����Ͷ��֧������
	public void InputPayPwd(String pwd){
		base.elementSendkey(InputPayPwd, pwd);
	}
	//���뱣����Ͷ����֤��
	public void InputValidateCode(){
		String ValidateCode = new Data().get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
		base.elementSendkey(InputValidateCode, ValidateCode);
		if(base.browserType.toLowerCase().equals("ie") && !base.indexURL.contains("inclient")){
			base.getAlertwithWait().accept();
		}
	}
	//ѡ�б�����Ͷ���Ķ���ͬ��Э��
	public void CheckAgreeDeal(){
		base.clickElementNoWait(AgreeCheckbox);
		base.assertTrueByBoolean(base.getElementNoWait(AgreeCheckbox).isSelected());
	}
	//���������Ͷ�ʡ�ȷ������ť
	public void clickBZStarOkBtn(){
		base.clickElementNoWait(OkBtn);
//		base.sleep(10000);
//		base.checkElmentwithTxt(InvestSuccessTxt, "Ͷ�ʳɹ�");
	}
	//�رա�Ͷ�ʳɹ�������
	public void clickCloseSuccessLnk(){	
		
		base.clickElementNoWait(CloseInvestSuccessLnk);
		base.checkNoElement(CloseInvestSuccessLnk);
	}
	public void clickCloseErrorLnk(){
		base.clickElementNoWait(CloseInvestErrorLnk);
		base.checkNoElement(CloseInvestErrorLnk);
	}
	public void CheckInvestSuccess(){
		if(base.isElementVisible(InvestSuccessTxt)){
			base.assertEqualsActualExpected(base.getElementText(InvestSuccessTxt), "Ͷ�ʳɹ�");
			int window = base.Windowsize();
			clickCloseSuccessLnk();
			if(base.Windowsize()!=window){
				base.turnToOldPage();
			}
		}else{
			base.assertEqualsActualExpected(base.getElementText(InvestErrorTxt),"�������");
			String ErrorTxt = base.getElementText(ShowErrorTxt);
			clickCloseErrorLnk();
			Assert.fail("�������! "+ErrorTxt);
		}
	}
	//��������������Ĳ鿴��
	public void clickViewLnk(){
		base.clickWithWait(IndividualViewLnk);
		base.checkElmentText(MonthPlanTxt, "����Ӧ�յļƻ�");
	}
	//�Ƿ���ʾ�����ǡ�����Ͷ�ʡ�����
	public Boolean ifshowSYStarInvestNowLnk(){
		return base.isElementPresent(EStarPlanListPage.SYStarInvestNowLnk);
	}
	//��������ǡ�����Ͷ�ʡ�����
	public void clickSYStarInvestNowLnk(){
		base.clickElementNoWait(SYStarInvestNowLnk);
	}
	
	/**
	 * ����Ԫ
	 * ��ʾ��ֵ
	 */
	public void promptRecharge(){
		base.checkElementVisible(By.cssSelector("#wtplan_alert7"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#wtplan_alert7 .msg_ico.error_ico")), "�� ����ȥ��ֵ,��Ͷ��!");
	}
	
	/**
	 * ����Ԫ
	 * �����ֵ
	 */
	public void goRecharge(){
		base.clickWithWait(By.cssSelector("#wtplan_alert7 .return_btn"));
	}
	
	//�Ƿ����״�Ͷ��
	public Boolean ifFirstInvest(){
		if(base.getElementText(EStarPlanListPage.SYStarRiskTitle).equals("")){
			return false;
		}else{
			return true;
		}
	}
	//��������ǡ��ܾ���������ʾ��ť
	public void clickDenyBtn(){
		base.clickWithWait(DenyBtn);
		base.checkNoElement(DenyBtn);
		base.checkElementVisible(IncomeCalculatorLnk);
//		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	//��������ǡ�ͬ�⡱������ʾ��ť
	public void clickAgreeBtn(){
		base.clickWithWait(AgreeBtn);
		base.assertTrueByBoolean(base.getElementTextWithWait(SYStarInvestTitle).contains("Ͷ����Ϣ"));
	}
	//�رա������ǡ�Ͷ�ʴ���
	public void clickSYStarCloseBoxBtn(){
		base.clickElementNoWait(CloseSYStarInvestBoxLnk);
		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	//����������Ͷ�ʽ��
	public void InputSYStarAmount(){
		base.sendKeysWithWait(InputSYStarAmount, "1");
	}
	//�Ƚ�������Ͷ�ʶ����Ҫ��ȵĴ�С
	public boolean SYStarCompareAmount(){
		String calculateTxt = base.getElementText(SYStarCalculateTxt);	
		int EndPosition = calculateTxt.lastIndexOf("=");
		int EachAmount = Integer.valueOf(calculateTxt.substring(1, EndPosition)).intValue();
		int TotalAmount = Integer.valueOf(base.getElementText(SYStarNeedAmountTxt)).intValue();
		if(3*EachAmount<=TotalAmount){
			return true;
		}else{
			return false;
		}	
	}
	//����������Ͷ��֧������
	public void InputSYStarPayPwd(String pwd){
		base.elementSendkey(InputSYStarPayPwd, pwd);
	}
	//����������Ͷ����֤��
	public void InputSYStarValidateCode(){
		String ValidateCode = new Data().get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
		base.elementSendkey(InputSYStarValidateCode, ValidateCode);
	}
	//ѡ��������Ͷ���Ķ���ͬ��Э��
	public void CheckSYStarAgreeDeal(){
		base.clickElementNoWait(SYStarAgreeCheckbox);
	}
	//���������Ͷ�ʴ��ڡ�ȷ������ť
	public void clickSYStarOkBtn(){
		base.clickElementNoWait(SYStarOkBtn);
		base.sleep(10000);
		base.checkElmentText(InvestSuccessTxt, "Ͷ�ʳɹ�");
	}
	//���������Ͷ�ʴ��ڡ�ȡ������ť
	public void clickSYStarCancelBtn(){
		base.clickElementNoWait(SYStarCancelBtn);
		base.checkNoElement(SYStarCancelBtn);
//		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	
	/********************���������*********************/
	/**
	 * ����Ԫ
	 * �������������ļ�Ϣʱ��
	 */
	public void clickDate(){
		base.clickWithWait(By.cssSelector("#date"));
	}
	
	/**
	 * ����Ԫ
	 * ��������������ļ�Ϣʱ��
	 */
	public void inputDate(String date){
		base.setDate("date", date);
	}
	
	/**
	 * ����Ԫ
	 * У�鵯��������
	 */
	public void showDate(){
		base.assertTrueByBoolean(base.isBlock(By.cssSelector("#ui-datepicker-div")));
	}
	
	/**
	 * ����Ԫ
	 * ������
	 */
	public void inputMoney(String value){
		base.sendKeysWithWait(By.cssSelector("#loanMoney"), value);
	}
	
	/**
	 * ����Ԫ
	 * ��������
	 */
	public void inputLoanRate(String value){
		base.sendKeysWithWait(By.cssSelector("#loanRate"), value);
	}
	
	/**
	 * ����Ԫ
	 * ����Ͷ������
	 */
	public void inputLoanPhases(String value){
		base.sendKeysWithWait(By.cssSelector("#loanPhases"), value);
	}
	
	/**
	 * ����Ԫ
	 * ������ϼ���
	 */
	public void clickCalculate(){
		base.clickWithWait(By.cssSelector(".count-btn.fl"));
	}
	
	/**
	 * У������������������ݣ�����ʾ����ʾ������
	 */
	public void isCalculateNoAlert(){
		base.assertNotEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#totalCont")), "0");
		base.assertNotEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#rateCont")), "0");
	}
	
	/**
	 * У���������ȷ
	 */
	public void isCalculateOK(double money,double rate,int phases){
		//�տ��ܶ�  �տ��ܶ�=�����*������/12*�������+����
		String totalMoney = base.integerMoney(base.roundingMoney(money * rate / 1200 * phases + money));
		//��Ϣ  ��Ϣ=�����*������/12*�������
		String lxMoney = base.integerMoney(base.roundingMoney(money * rate / 1200 * phases));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#totalCont")), totalMoney);
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#rateCont")), lxMoney);
	}
	
	/**
	 * ����Ԫ
	 * �����ʾ�տ�ʱ���
	 */
	public void clickDateList(){
		base.clickWithWait(By.cssSelector("#intercheck"));
	}
	
	/**
	 * ����Ԫ
	 * У����ʾ�տ�ʱ���
	 */
	public void isShowDateList(){
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#tiemst")));
		String ecpected[] = {"�ڴ�","�տ�ʱ��","����ȡ��Ϣ","����ȡ����","����ȡ�ܶ�","ʣ�౾��"}; 
		List<WebElement> list = base.getElements(By.xpath(".//*[@id='tableList']/tbody[1]/tr/th"));
		for (int i = 0; i < list.size(); i++) {
			base.assertEqualsActualExpected(list.get(i).getText(), ecpected[i]);
		}
	}
	
	/**
	 * ����Ԫ
	 * У���տ�ʱ�����������
	 */
	public void isDateListOK(String date,double money,double rate,int phases){
		String dateSplit[] = date.split("-");
		int year = Integer.parseInt(dateSplit[0]);
		int month = Integer.parseInt(dateSplit[1])-1;
		int day = Integer.parseInt(dateSplit[2]);
		int daysOfYear = base.getDaysOfYear(year);
		//ҳ����ʾ�տ�ʱ���
		List<WebElement> dateList = base.getElements(By.xpath(".//*[@id='datatbody']/tr"));
		//���
		int qici = 0;
		if (Integer.parseInt(date.substring(date.length()-2, date.length()))==21) {
			//��Ϣ��Ϊ��21�ţ��ڴ�����Ͷ��������һ��
			qici = phases;
		}else {
			//��Ϣ��Ϊ�������ڴ���=Ͷ������+1
			qici = phases + 1;
		}
		if(dateList.size()==qici){
			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month, day);
			SimpleDateFormat ddFormat = new SimpleDateFormat("yyyy-MM-dd");
			String firstLL = "";//��һ����Ϣ	
			for (int i = 1; i <= qici; i++) {
				int step = 0;
				/********************�ڴ�************************/
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[1]")), i+"");
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("��"+i+"���ڴ�:У��ʧ��,���Σ�"+i+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[1]"))+"<br/>");
					System.out.println("��"+i+"���ڴ�:У��ʧ��,���Σ�"+i+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[1]")));
				}
				/********************�տ�ʱ��************************/
				String nextDate = "";
				if (i==1) {
					if(day>20){
						calendar.add(Calendar.MONTH, 1);
					}
					calendar.set(Calendar.DATE, 20);
					nextDate = ddFormat.format(calendar.getTime());
				}else if (i==qici) {//���һ��
					if(day<=21){
						calendar.add(Calendar.MONTH, 1);
					}
					calendar.set(Calendar.DATE, day-1);
					nextDate = ddFormat.format(calendar.getTime());
				}else {
					calendar.add(Calendar.MONTH, 1);
					calendar.set(Calendar.DATE, 20);
					nextDate = ddFormat.format(calendar.getTime());
				}
				nextDate = ddFormat.format(calendar.getTime());
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[2]")), nextDate);
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("��"+i+"���տ�ʱ��:У��ʧ��,���Σ�"+nextDate+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[2]"))+"<br/>");
					System.out.println("��"+i+"���տ�ʱ��:У��ʧ��,���Σ�"+nextDate+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[2]")));
				}
				/********************����ȡ��Ϣ************************/
				//����ȡ��Ϣ
				String monthLL = "";
				if(day!=21){
					if (i==1) {
						//�������
						int differ = base.daysBetween(date, nextDate)+1;
						//��һ������Ϣ=�����*����/365��366*��Ϣ�յ��¸�������֮�������
						firstLL = base.roundingMoney(money * rate / daysOfYear / 100 * differ);
						monthLL = firstLL;
					}else if(i==qici){
						monthLL = base.roundingMoney(Double.parseDouble(base.roundingMoney(money * rate /100 / 12)) - Double.parseDouble(firstLL));
					}else {
						//�м�����Ϣ=�����*����/12
						monthLL = base.roundingMoney(money * rate /100 / 12);
					}
				}else {
					monthLL = base.roundingMoney(money * rate /100 / 12);
				}
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[3]")).replaceAll(",", ""), base.integerMoney(monthLL));
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("��"+i+"������ȡ��Ϣ:У��ʧ��,���Σ�"+base.integerMoney(monthLL)+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[3]")).replaceAll(",", "")+"<br/>");
					System.out.println("��"+i+"������ȡ��Ϣ:У��ʧ��,���Σ�"+base.integerMoney(monthLL)+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[3]")).replaceAll(",", ""));
				}
				/********************����ȡ����************************/
				String benJin = "";
				if (i==qici) {
					benJin = money+"";
				}else {
					benJin = "0";
				}
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[4]")).replaceAll(",", ""), base.integerMoney(benJin));
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("��"+i+"������ȡ����:У��ʧ��,���Σ�"+base.integerMoney(benJin)+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[4]")).replaceAll(",", "")+"<br/>");
					System.out.println("��"+i+"������ȡ����:У��ʧ��,���Σ�"+base.integerMoney(benJin)+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[4]")).replaceAll(",", ""));
				}
				/********************����ȡ�ܶ�************************/
				//����ȡ�ܶ�
				String zongE = "";
				if (i==qici) {
					zongE = Double.parseDouble(monthLL)+money+"";
				}else {
					zongE = monthLL;
				}
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[5]")).replaceAll(",", ""), base.integerMoney(zongE));
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("��"+i+"������ȡ�ܶ�:У��ʧ��,���Σ�"+base.integerMoney(zongE)+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[5]")).replaceAll(",", "")+"<br/>");
					System.out.println("��"+i+"������ȡ�ܶ�:У��ʧ��,���Σ�"+base.integerMoney(zongE)+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[5]")).replaceAll(",", ""));
				}
				/********************ʣ�౾��************************/
				//ʣ�౾��
				String sybj = money + "";
				if (qici == phases + 1 && i==qici) {
					sybj = "0";
				}
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[6]")).replaceAll(",", ""), base.integerMoney(sybj));
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("��"+i+"��ʣ�౾��:У��ʧ��,���Σ�"+base.integerMoney(sybj)+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[6]")).replaceAll(",", "")+"<br/>");
					System.out.println("��"+i+"��ʣ�౾��:У��ʧ��,���Σ�"+base.integerMoney(sybj)+",ʵ�ʣ�"+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[6]")).replaceAll(",", ""));
				}
				if (step!=6) {
					base.assertTrueByBoolean(false);
				}
			}
		}else {
			Reporter.log("�ڴ�У�飺ʧ��"+"<br/>");
			base.assertEqualsActualExpectedByInt(dateList.size(), qici);
		}
	}
	
	/**
	 * ����Ԫ
	 * ǰ̨-���Ǽƻ�--Ͷ���б�--���ͼƻ�Ͷ���б�ҳ--��Ʒ����--��Ʒ������
	 * ״̬ͼ׼ȷ�ԡ��ƻ��ܶ�=������+������+������ļ���ܶ��Ʒ���⼰������ȷ�ԡ�ʣ��������ȷ��
	 */
	public void isDataOfEStarListOK(){
		//������
		checkData("complute");
		//�ѽ���
		checkData("end");
		//������
		checkData("going");
	}
	
	public void checkData(String type){
		List<WebElement> list = base.getElements(By.cssSelector(".wtplan_box_left."+type));
		if (list.size()>0) {
			for (int i = 1; i <= list.size(); i++) {
				int step = 0;
				List<WebElement> btnList = null;
				/************У��ʱ��**************/
				try {
					if (type.equals("complute") || type.equals("end")) {
						base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//span[@class='wtplan_time font20 colorff fr']")),"0��00ʱ00��00��");
					}else {
						base.assertTrueByBoolean(!base.getElementTextWithWait(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//span[@class='wtplan_time font20 colorff fr']")).equals("0��00ʱ00��00��"));
					}
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("��"+i+"��"+type+"У��ʱ�䣺ʧ��"+"<br/>");
					System.out.println("��"+i+"��"+type+"У��ʱ�䣺ʧ��");
				}
				
				/************У�������ǡ�������Ͷ�ʰ�ť��ʾ**************/
				String style = "";
				String msg = "";
				if (type.equals("complute")) {
					style = "over";
					msg = "����";
				}else if (type.equals("end")) {
					style = "over";
					msg = "����Ͷ��";
				}else {
					style = "go";
					msg = "����Ͷ��";
				}
				btnList = base.getElements(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//span[@class='wtplan_td6 wtplan_line_btn "+style+"']"));
				try {
					for (int j = 0; j < btnList.size(); j++) {
						if (type.equals("end")) {
							try {
								base.assertEqualsActualExpected(btnList.get(j).getText(), msg);
							} catch (AssertionError e) {
								base.assertEqualsActualExpected(btnList.get(j).getText(), "����");
							}
						}else {
							base.assertEqualsActualExpected(btnList.get(j).getText(), msg);
						}
					}
					try {
						base.assertEqualsActualExpectedByDouble(btnList.size(), 2);
					} catch (AssertionError e) {
						base.assertEqualsActualExpectedByDouble(btnList.size(), 1);
					}
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("��"+i+"��"+type+"У�������ǡ�������Ͷ�ʰ�ť��ʾ��ʧ��"+"<br/>");
					System.out.println("��"+i+"��"+type+"У�������ǡ�������Ͷ�ʰ�ť��ʾ��ʧ��");
				}
				
				/************У��ƻ��ܶ�=������+������+������ļ���ܶ�**************/
				double zongE = 0;
				if (type.equals("complute") || type.equals("end")) {
					zongE = Double.parseDouble(base.getElementTextWithWait(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//span[@class='font30 colorF0']")).replaceAll(",", ""));
				}else {
					zongE = Double.parseDouble(base.getElementTextWithWait(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//span[@class='font30']")).replaceAll(",", ""));
				}
				
				//����
				List<WebElement> stars3List = base.getElements(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//div[@class='color3 font18 wtplan_table_td2 fl']"));
				double sum = 0;
				for (int j = 0; j < stars3List.size(); j++) {
					sum = base.add(sum, Double.parseDouble(stars3List.get(j).getText().replaceAll("��Ԫ", "").replaceAll(",", "")));
				}
				try {
					base.assertEqualsActualExpectedByDouble(zongE, sum);
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("��"+i+"��"+type+"У��ƻ��ܶ�=������+������+������ļ���ܶʧ��"+"<br/>");
					System.out.println("��"+i+"��"+type+"У��ƻ��ܶ�=������+������+������ļ���ܶʧ��");
				}
				if (step!=3) {
					base.assertTrueByBoolean(false);
				}
			}
		}else {
			String msg = "";
			if (type.equals("complute")) {
				msg = "������";
			}else if (type.equals("end")) {
				msg = "�ѽ���";
			}else {
				msg = "������";
			}
			Reporter.log("��ҳû��"+msg+"�����Ǽƻ�"+"<br/>");
			System.out.println("��ҳû��"+msg+"�����Ǽƻ�");
		}
	}
	
	/**
	 * ����Ԫ
	 * �������Ʒ���⡱����,��ת��Ͷ���б�����ҳ��,��飺��Ʒ�����Ϣ��Ͷ���б���һ�£�״̬�����ȣ�Ͷ�ʰ�ť���ƻ��ܶ�ȣ�
	 */
	public void isLinkAndDetailDataOK(){
		base.checkElement(FirstEStarTitle);
		//����
		String title = base.getElementText(FirstEStarTitle);
		//״̬
		String status = base.getElementWithWait(By.xpath("//div[@class='wtplan_box mt25'][1]/a")).getAttribute("class");
		//�ܶ�
		String zongE = base.getElementTextWithWait(By.xpath("//div[@class='wtplan_box mt25'][1]/a//span"));
		base.clickElementNoWait(FirstEStarTitle);	
		if (base.gethandelsNum()==2) {
			base.turnToNewPage();
		}
		//����
		base.assertEqualsActualExpected(base.getElementTextWithWait(EStarDetailPage.EStarTitleinDetail), title);
		//״̬
		base.assertEqualsActualExpected(base.getElementWithWait(By.xpath("//div[@class='wtplan_box_detail mt25']/div[1]")).getAttribute("class"), status);
		//�ܶ�
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@class='wtplan_box_detail mt25']//p[3]/span")), zongE);
	}
	
	/**
	 * ����Ԫ
	 * У�鱣��������(��֤���㷽ʽ��ʾ��ȷ��,������Ϣ)
	 */
	public void idBaoZhangStarDataOK(){
		List<WebElement> list = base.getElements(By.xpath("//div[@class='wtplan_box_right']/div[2]//div[5]"));
		for (int i = 0; i < list.size(); i++) {
			base.assertEqualsActualExpected(list.get(i).getText(), "��Ϣ��");
		}
	}
}
