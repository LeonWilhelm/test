package com.eloancn.shared.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.*;
import com.eloancn.shared.model.DWutGuaranteeModel;

/**
 * �ҵ��˻�--���Ǽƻ�--�ҵĽ���ƻ�
 */
public class MyDebitPlan {
	
	Base base = new Base();
	
	MyAccountPage myAccountPage = new MyAccountPage();
	
	public static By LoanPart = By.id("_content");											//���ҵĽ���ƻ�������
	
	By BorrowTop = By.xpath("//div[@id='_content']/div/div/div[*]/h3");						//���ۼƽ��롱���������ܶ���������ܶ
	By BorrowStatisticLnk = By.id("investmentStatisticsForWut");							//"����ͳ��"
	By RechargeLnk = By.cssSelector("a.h30.textD");											//"��ֵ"
	By applyCreditBtn =By.xpath(".//*[@id='_content']//a[text()='�������']");					//"�������"��ť
	By PerfectInfoLnk = By.xpath("//div[@id='_content']/div/div[2]/div/span[2]/a");			//���������ϡ�����
	By ApplyNeedLnks = By.cssSelector("#_content>div>div.starplan_brror_topR>div>span");	//"�������"�����4������
	public static By ListContent = By.id("tabList0");														//�б�����
	By subTabs = By.cssSelector("#_content>div.main-b.mt10>div>span");						//5��tab:"���ڻ���Ľ��","��ȫ������Ľ��"...
	By RepayingLoanLnk = By.id("repaying");													//�����ڻ���Ľ�
	By RepayedLoanLnk = By.id("repayed");													//����ȫ������Ľ�
	public static By PublishedLoanLnk = By.id("published");									//���ѷ����Ľ�
	public static By PublishingLoanLnk = By.id("publishing");								//����δ�����Ľ�
	By PublishingLoanLnk1 = By.cssSelector("span.wd160.current");
	By CollateralDealLoanLnk = By.id("collateralDeal");										//����Ѻ�ﴦ��Ľ�
	
	//���������ϡ�ҳ��
	By BasicInfoTxt = By.id("info0");														//���������ϡ�
	public static By AgeTxt = By.id("age");													//�����䡱��ʾ
	
	//��������ҳ��
	By BorrowPage = By.id("borrowed");														//������������ҳ
	By voucherTxt =By.id("voucher");														//������				
	By amountTxt =By.id("amount");															//�����
	By borrowerTypeSel =By.id("borrowertype");												//����������
	By QiYeType = By.xpath("//select[@id='borrowertype']/option[2]");						//�����ߣ���ҵ
	By QYTip = By.xpath("//tr[@id='showEnterpriseMaterials']/td/div/div/p");				//��ҵ���͵���ʾ
	By FillInQYInfoLnk = By.cssSelector("#showEnterpriseMaterials>td>div.pub_tip.fl>div>p>a.colorG");//"��д��ҵ��Ϣ"����	
	By phasesSel =By.id("phases");															//�������	
	By ThreeMonth = By.xpath("//select[@id='phases']/option[2]");							//3��������
	By Interest = By.id("interestrate");													//���������
	By ManBiaoRadio = By.id("mode1");														//"����"��ѡ��
	By HBFXRadio = By.id("fx");																//��������Ϣ����ѡ��
	By usetypeSel =By.id("usetype");														//�������	
	By BusinessZZ = By.xpath("//select[@id='usetype']/option[3]");							//������ͣ�������ת
	By purposeTxt =By.id("purpose");														//���Ŀ��	
	By phoneTxt = By.id("mobile");															//��ϵ�绰
	By mailTxt = By.id("email");															//��ϵ����
	By addBtn = By.xpath("//input[@value='���']");											//����ӡ���ť���ں�֤�ˣ�
	By baoZhengRenDiv = By.xpath("//div[@class='lywrap' and @style='width:560px;']");		//������ں�֤�ˡ�DIV
	By baoZhengRenSel = By.id("GuaranteeType");												//�ں�֤������
	By baoZhengRen_zrr_name = By.id("nor_name");											//��Ȼ��_���������ı���
	By baoZhengRen_zrr_idCard = By.id("nor_idcard");										//��Ȼ��_�����֤�š��ı���
	By baoZhengRen_zrr_household = By.id("nor_addr");										//��Ȼ��_��������ַ���ı���
	By baoZhengRen_zrr_address = By.id("nor_curr_addr");									//��Ȼ��_����ס����ַ���ı���
	By baoZhengRen_zrr_tel = By.id("nor_mobile");											//��Ȼ��_����ϵ�绰���ı���
	By baoZhengRen_zrr_mail = By.id("nor_email");											//��Ȼ��_����ϵ���䡱�ı���
	By baoZhengRen_zrr_saveBtn = By.xpath("//div[@id='saveoredit']//input[@value='����']");	//��Ȼ��_���水ť
	By baoZhengRen_zrr_cancelBtn = By.xpath("//div[@id='saveoredit']//input[@value='ȡ��']");	//��Ȼ��_ȡ����ť
	By baoZhengRen_closeBtn = By.xpath("//div[@id='addBondsman']//a");						//�رհ�ť
	By baoZhengRen_fr_name = By.id("lay_name");												//����_���ƣ���˾���ƣ�
	By baoZhengRen_fr_deputy = By.id("lay_layer");											//����_����������
	By baoZhengRen_fr_address = By.id("lay_addr");											//����_��ַ����˾��ַ��
	By baoZhengRen_fr_tel = By.id("lay_mobile");											//����_��ϵ�绰����˾�绰��
	By baoZhengRen_fr_mail = By.id("lay_email");											//����_��ϵ���䣨��˾���䣩
	By baoZhengRen_fr_saveBtn = By.xpath("//div[@id='GuaranteeLayer']//input[@value = '����']");//����_���水ť
	By baoZhengRen_fr_cancelBtnBy = By.xpath("//div[@id='GuaranteeLayer']//input[@value = 'ȡ��']");//����_ȡ����ť
	By detaildescriptionTxt =By.id("detaildescription");									//������Ϣ
	By releaseBtn =By.id("releaseButton");													//����
	By SavePreviewBtn = By.id("createButton");												//����Ԥ��

	//�����ġ���ҵ����Ϣ��
	By QYBidInfoTitle = By.cssSelector("h2.u-tt");											//"��ҵ����Ϣ"����
	By InputQiYeName = By.id("enterpriseName");												//����˾���ơ������
	By InputQiYeAddress = By.id("enterpriseAddress");										//����˾��ַ�������
	By InputQiYefoundedtime = By.id("foundedtime");											//������ʱ�䡱�����
	By InputQiYeReferrerName =By.id("enterpriseReferrername");								//��ծȨ�Ƽ������ơ������
	By ReferrerNameTipTxt = By.id("referrernameDiv");										//���롰ծȨ�Ƽ������ơ�����ʾ��Ϣ
	By InputQiYeReferrerIntro = By.id("enterpriseReferrerintro");							//��ծȨ�Ƽ��˼�顱�����
	By ReferrerIntroTipTxt = By.id("referrerintroDiv");										//���롰ծȨ�Ƽ��˼�顱����ʾ��Ϣ
	By InputQiYeBusiness = By.id("enterpriseBusiness");										//����Ӫ��Χ�������
	By InputQiYeRegisteredAmount = By.id("registeredamount");								//��ע��������
	By RegisterAmountTipTxt = By.id("registeredamountDiv");									//���롰ע�������ʾ��Ϣ
	By InputQiYeInvestAmount = By.id("investmentamount");									//��ʵ�ɽ������
	By InputQiYeBusinessState = By.id("businessperformance");								//����Ӫ״���������
	By InputQiYeUseType = By.id("enterpriseusetype");										//�������;�������
	By InputQiyeRepaySource = By.id("repaysource");											//��������Դ�������
	By InputQiyeCounterSecurity = By.id("countersecurity");									//����������ʩ�������
	By InputQiyeSafeGuard = By.id("safeguard");												//�����ϴ�ʩ�������
	By InputQiyeSafeGuardReason = By.id("safeguardreason");									//����������������
	By QiYeSaveBtn = By.id("addButton");													//�����桱��ť
	By QiYeCancelBtn = By.id("canclButton");												//��ȡ������ť
	
	//��ѯ��Ϣ
	By SearchByTimeTxt = By.cssSelector("#form > span");									//"��ʱ�����" 
	By BeginDate = By.id("begindate");														//��ʼʱ��ؼ�
	By EndDate = By.id("enddate");															//����ʱ��ؼ�
	By SearchBtn = By.cssSelector("input.time_submit");										//����ѯ����ť
	By ClearBtn = By.cssSelector("input.time_clear");										//����ա���ť

	//����δ�����Ľ�������Ϣ
	By LoanHead = By.cssSelector("#_content_child>table>thead");							//�����б�ı���
	By NoPublishedLoanTxt = By.cssSelector("#_content_child>table>tbody");					//�������ݣ��޽����н�
	public static By FirstBidType = By.xpath("//div[@id='_content_child']/table/tbody/tr/td[7]");	//��һ��������
	By BidTypes = By.xpath("//div[@id='_content_child']/table/tbody/*/td[9]");				//���б������
	By LoanPurposeLnk = By.cssSelector("a.colorF8");										//��һ����Ľ��Ŀ��
	public By LoanAmount = By.cssSelector("td.colorG");											//��һ����Ľ����
	By Lines = By.cssSelector("#_content_child>table.global_table>tbody>tr");				//��������
	By BorrowInfo = By.cssSelector("#_content_child>table>tbody>tr>td");					//��һ��������Ϣ
	By PreviewLnk = By.cssSelector("a.colorG");												//Ԥ��
	By PublishLnk = By.xpath("//div[@id='_content_child']/table/tbody/tr/td[9]/a[3]");		//����
	//�ѷ����Ľ���
	By StatusTxt = By.xpath("//div[@id='_content_child']/table/tbody/tr/td[6]");			//��һ�������״̬
	By ResultTxt = By.xpath("//div[@id='_content_child']/table/tbody/tr/td[10]");			//��һ�������״̬/���
	By FourthPageLnk = By.xpath("//div[@id='Pagination']/ul/li[4]");						//ҳ���ĵ�4������
	By LastPage = By.xpath("//div[@id='Pagination']/ul/li[text()='ĩҳ']");
	By LastTwoPage = By.xpath("//div[@id='Pagination']/ul/li[last()-2]");
	By FirstPage = By.xpath("//div[@id='Pagination']/ul/li[text()='��ҳ']");
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");
	By LastPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");						    //ҳ���ĵ�6������
	By AllPaginationLnk = By.xpath("//div[@id='Pagination']/ul/li");						//ҳ��
	
	//"���ڻ���Ľ��"
	By OverdueTxt = By.cssSelector("div.showOverDueDiv.font14");							//����
	By RechargeLnk1 = By.cssSelector("dd.wd80 > a");										//����ֵ������
	By FirstRepayLoan = By.id("_content_child");											//"���ڻ���Ľ��"/"��ȫ������Ľ��"�еĵ�һ������ޱ�ʱ��ʾ
	By LoanLnks = By.cssSelector("#_content_child>div.mt15>div.lending_record>a");			//���Ŀ�ģ�һ���Ի��壬������飬�鿴���ص��ӽ�������
	public By LoanDetailLnk = By.xpath("//div[@id='_content_child']/div/div/a[3]");				//��������顱����
	By RepayingIOULnk = By.xpath("//div[@id='_content_child']/div/div/a[4]");			    //���鿴���ص��ӽ���������
	By LoanInfos = By.cssSelector("ul.record_info>li");										//���������ʣ�������
	By QiShuTxt = By.xpath("//div[@id='_content_child']/div/div[2]/ul/li[3]");				//����
	By RepayList = By.cssSelector("table.record_table");									//������Ŀ�ĺ󵯳��Ļ�������
	By FirstRepayTime = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/tr/td[2]"); //��һ�ڻ�������
	By QiShuList = By.xpath("//div[@id='_content_child']/div[1]/div[2]/table/tbody/tr");	//�б��е�����
	By Status = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/*/td[6]");		//״̬
	By RepayBJ = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/*/td[3]");	//Ӧ������
	By RepayLX = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/*/td[4]");	//Ӧ����Ϣ
	By RealBX = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/*/td[5]");		//ʵ����Ϣ
	
	//����ȫ������Ľ�
	By RepayedIOULnk = By.xpath("//div[@id='_content_child']/div/div/a[2]");			//���鿴���ص��ӽ���������
	
	//����б�
	By repayingTab = By.cssSelector("#repaying");                                                             //�����ڻ���Ľ�Tab
	By loanList = By.cssSelector(".mt15");                                                                    //����б�
	By loanListByFirst = By.cssSelector("#_content_child > div.mt15");                           			  //����б��һ������
	By disposablePayOff = By.cssSelector(".lending_record > a:nth-child(2)");                                 //��������
	By disposablePayOffByFirst = By.cssSelector("#_content_child > div:nth-child(4) > div > a:nth-child(2)"); //�������ӵ�һ������_����
	By notPaidMoney = By.xpath("//div[@id='_content_child']//span[@class='colorG']");                         //�������ӵ�һ������_δ�����	
	By outAllWindow = By.cssSelector("#out_all");                                                             //����ȷ�ϵ�����
	By balanceByWindow = By.cssSelector("#balancediv");                                                       //�˻����
	By theWay = By.cssSelector("#allrepay>label");                                                            //���ʽ
	By iNeedRecharge = By.cssSelector("span#balancediv~a");                                                   //����ȷ�ϴ���_��Ҫ��ֵ
	By monthRdo = By.xpath("//input[@id='month']");															  //����ȷ�ϴ���_ÿ�»���
	By disposablePayOffByWindow = By.cssSelector("#allrepay>label");                                          
	By allRdo = By.xpath("//input[@id='all']");																  //����ȷ�ϴ���_��ǰһ���Ի���
	By advanceRdo = By.xpath("//input[@id='advance']");														  //����ȷ�ϴ���_����������Ҫ�����ı��𡱵�ѡ��ť 
	By cancelBtn = By.cssSelector(".RT_cancel");                                                              //����ȷ�ϴ���_ȡ����ť
//	By okBtn = By.cssSelector("#repayButtonSubmit");                                                          
	By okBtn = By.xpath("//button[@id='repayButtonSubmit']");												  //����ȷ�ϴ���_ȷ�ϰ�ť
	By rechargeDiv  = By.cssSelector(".g-main-c");		                                                      //��ֵDIV
	
	//��顰�ҵĽ���ƻ���ҳ�������
	public void checkDatainPage(){
		String [] TopTxt = {"�ۼƽ���","�����ܶ�","�����ܶ�"};
		List<WebElement> BorrowTops = base.getElements(BorrowTop);
		base.assertEqualsActualExpected(base.getElementTextWithWait(BorrowStatisticLnk), "����ͳ��");
		base.assertEqualsActualExpected(base.getElementTextWithWait(RechargeLnk), "��ֵ");
		base.assertEqualsActualExpected(base.getElementTextWithWait(applyCreditBtn), "�������");
		String [] lnks = {"�����ϴ�","��������","�鿴��Ƶ","��ͨ���۹���"};
		List<WebElement> BorrowLnks = base.getElements(ApplyNeedLnks);
		String [] tabs = {"���ڻ���Ľ��","��ȫ������Ľ��","�ѷ����Ľ��","��δ�����Ľ��","��Ѻ�ﴦ��Ľ��"};
		List<WebElement> Tab = base.getElements(subTabs);
		for(int i=0;i<3;i++){
			base.assertEqualsActualExpected(BorrowTops.get(i).getText(),TopTxt[i]);
			base.assertEqualsActualExpected(BorrowLnks.get(i).getText(),lnks[i]);
			base.assertEqualsActualExpected(Tab.get(i).getText(),tabs[i]);
		}
		base.assertEqualsActualExpected(BorrowLnks.get(3).getText(),lnks[3]);
		base.assertEqualsActualExpected(Tab.get(3).getText(),tabs[3]);
		base.assertEqualsActualExpected(Tab.get(4).getText(),tabs[4]);
		base.assertEqualsActualExpected(base.getElementTextWithWait(SearchByTimeTxt),"��ʱ�����");
		base.checkElement(BeginDate);
		base.checkElement(EndDate);
		base.assertEqualsActualExpected(base.getLnkElementText(SearchBtn, "value"), "��ѯ");
		base.assertEqualsActualExpected(base.getLnkElementText(ClearBtn, "value"), "���");
	}
	//���ɻ�����������ҵ����
	public void ApplyforQiYeLoan(String amount,String borrowertype,String phase,String type,String purpose){
		new MyAccountPage().clickMyDebitPlanLnk();
		clickShenQingDaiKuan();
		if(base.indexURL.contains("/client")||base.indexURL.contains("inclient")){
			InputRefereeInviteCode("ElWut1058");
		}else if(base.indexURL.contains("test")||base.indexURL.contains("www")){
			InputRefereeInviteCode("ElWut1001");
		}
		InputBorrowMoney(amount);
		selectBorrowerType(borrowertype);
		if(borrowertype.equals("��ҵ")){
			clickFillInQYInfoLnk();
			ImproveQYBidInfo();
		}
		selectBorrowPhase(phase);
		selectBorrowType(type);
		InputBorrowPurpose(purpose);

		InputDescription();
		clickSavePreviewBtn();
	}
	public void ApplyforQiYeLoan(String amount, String borrowertype, String phase, String type, String purpose, String phone, String mail, DWutGuaranteeModel baoZhengRenZrr, DWutGuaranteeModel baoZhengRenFr){
		new MyAccountPage().clickMyDebitPlanLnk();
		clickShenQingDaiKuan();
		if(base.indexURL.contains("/client")||base.indexURL.contains("inclient")){
			InputRefereeInviteCode("ElWut1058");
		}else if(base.indexURL.contains("test")||base.indexURL.contains("www")){
			InputRefereeInviteCode("ElWut1001");
		}
		InputBorrowMoney(amount);
		selectBorrowerType(borrowertype);
		if(borrowertype.equals("��ҵ")){
			clickFillInQYInfoLnk();
			ImproveQYBidInfo();
		}
		selectBorrowPhase(phase);
		selectBorrowType(type);
		InputBorrowPurpose(purpose);
		inputPhone(phone);
		inputMail(mail);
		clickAddBtn();
		inputBaoZhengRenInfo(baoZhengRenZrr);
		clickAddBtn();
		inputBaoZhengRenInfo(baoZhengRenFr);
		InputDescription();
		clickSavePreviewBtn();
	}
	/**
	 * ����Ԫ
	 * �����������
	 */
	public void clickShenQingDaiKuan(){
		base.clickWithWait(applyCreditBtn);
		base.checkElementVisible(BorrowPage);
	}
	//������������ϡ�����
	public String clickPerfectInfoLnk(){
		base.clickWithWait(PerfectInfoLnk);
		base.checkElement(BasicInfoTxt);
		String Age = base.getLnkElementText(MyDebitPlan.AgeTxt, "value");
		return Age;
	}
	/**
	 * ����Ԫ
	 * �������
	 */
	public void shenQingDaiKuan(String amount,String borrowerType,String phases,String usetype,String purpose,String descrition){
		//������
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			base.sendKeysWithWait(voucherTxt, "ElWut1001");
		}else {
			base.sendKeysWithWait(voucherTxt, new DBData().getVoucherCode());
		}
		base.sleep(1000);
		base.sendKeysWithWait(amountTxt, amount);
		base.sleep(1000);
		base.elementSelectByVisibleText(borrowerTypeSel, borrowerType);
		base.sleep(1000);
		base.elementSelectByVisibleText(phasesSel, phases);
		base.sleep(1000);
		base.elementSelectByVisibleText(usetypeSel, usetype);
		base.sleep(1000);
		base.sendKeysWithWait(purposeTxt, purpose);
		base.sleep(1000);
		base.sendKeysWithWait(detaildescriptionTxt, descrition);
		base.sleep(1000);
		base.clickWithWait(releaseBtn);
	}
	
	/**
	 * ����Ԫ
	 * ��֤�������ɹ�
	 */
	public void isShenQingDaiKuanOK(){
		try {
			base.sleep(3000);
			Alert alert = base.getAlert();
			base.sleep(3000);
			base.assertEqualsActualExpected(alert.getText(), "�����ɹ����ȴ�������ˣ�лл��");
			alert.accept();
		} catch (Exception e) {
		}
	}
	//��������ڻ���Ľ�ѡ��
	public boolean clickRepayingLoanLnk(){
		base.clickWithWait(RepayingLoanLnk);
		base.checkElmentText(PublishingLoanLnk1, "���ڻ���Ľ��");
		if(base.getElementTextWithWait(FirstRepayLoan).equals("��Ŀǰ��û�С����ڻ���Ľ���")){
			return false;
		}else{
			return true;
		}
	}
	//����Ƿ������ڵĽ��
	public boolean ifshowOverdueLoan(){
		
		return base.isElementPresent(OverdueTxt);
	}
	//�����������顱����
	public String[] clickLoanDetailLnk(){
		base.clickWithWait(LoanDetailLnk);
		base.jumpToNewWindow();
		String time = base.getElementTextWithWait(EStarPlanLoanDetailPage.BidFullTime);//2015-09-01
		String title = base.getElementTextWithWait(EStarPlanLoanDetailPage.BorrowTypeAndTitleTxt).split("�� ")[1];
		String borrowmoney = base.getElementTextWithWait(EStarPlanLoanDetailPage.BorrowMoney);
		String Rate = base.getElementTextWithWait(EStarPlanLoanDetailPage.Rate);
		String phase = base.getElementTextWithWait(EStarPlanLoanDetailPage.Phase);
		base.closeAndjumptoOldWindow();
		String data[]={time,title,borrowmoney,Rate,phase};
		return data;
	}
	//��顰���ڻ���Ľ��ı���Ϣ
	public void checkRepayingLoanInfo(String borrow[]){

		String [] links = {borrow[1],"һ���Ի���","�������","�鿴���ص��ӽ���"};
		List<WebElement> Lnks = base.getElements(LoanLnks);
		for(int i =0;i<4;i++){
			base.assertEqualsActualExpected(Lnks.get(i).getText(), links[i]);
		}
		String qishu,day = borrow[0].split("-")[2];
		if(day == "21"){
			qishu = borrow[4];
		}else{
			qishu = String.valueOf(Integer.parseInt(borrow[4])+1);
		}
		double borrowmoney=0; 
//		if(borrow[2].contains(",")){
		borrowmoney= Double.parseDouble(borrow[2].replace(",", ""));
//		}
		double RepayBXEachMonth= Double.parseDouble(base.roundMoney(borrowmoney*Double.parseDouble(borrow[3])/1200));//1012.27
		String ShouldRepayBX = base.roundingMoney(borrowmoney+RepayBXEachMonth*Integer.parseInt(borrow[4]));
		List<WebElement> status = base.getElements(Status);
		List<WebElement> repayBJ = base.getElements(RepayBJ);
		List<WebElement> repayLX = base.getElements(RepayLX);
		double RealPay=0,receivingPay=0;//ʵ����Ϣ,δ�����
		for(int i=0;i<Integer.parseInt(qishu);i++){
			String bj= repayBJ.get(i).getText().substring(1);
			String lx = repayLX.get(i).getText().substring(1);
//			if(bj.contains(",")){
				bj= bj.replaceAll(",", "");
//			}
//			if(lx.contains(",")){
				lx=lx.replaceAll(",", "");
//			}
			double bx= Double.parseDouble(bj)+Double.parseDouble(lx);
			if(status.get(i).getText().equals("�ѻ�")){
				RealPay= RealPay+bx;
			}else if(status.get(i).getText().equals("����")){
				receivingPay=receivingPay+bx;
			}
		}
		
		String [] Infos = {"�����: ��"+borrow[2],"������: "+borrow[3]+"%","����: "+qishu,"Ӧ����Ϣ: ��"+ShouldRepayBX,"ʵ����Ϣ: ��"+base.cutMoney(RealPay),"δ�����:��"+base.roundingMoney(receivingPay)};
		List<WebElement> info = base.getElements(LoanInfos);
		for(int i=0;i<6;i++){
			base.assertEqualsActualExpected(info.get(i).getText(), Infos[i]);
		}
	}
	//��������ڻ���Ľ��е����ڡ���ֵ������
	public void clickOverdueRechargeLnk(){
		base.clickWithWait(RechargeLnk1);
		if(base.isElementVisible(RechargePage.OnlineRechargeTxt)){
			base.assertEqualsActualExpected(base.getElementText(RechargePage.OnlineRechargeTxt),"������ֵ");
		}else{
			base.assertEqualsActualExpected(base.getElementText(RechargePage.ImproveProfileTxt),"���Ƹ��������Ϣ");
			new RechargePage().closeInfo();
		}
	}
	//����������ݺ�����
	public void checkOverdue(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(OverdueTxt), "�����˻���������\n�뼰ʱ ��ֵ");
		clickOverdueRechargeLnk();
	}
	//�������ȫ������Ľ�ѡ��
	public boolean clickRepayedLoanLnk(){
		base.clickWithWait(RepayedLoanLnk);
		base.checkElmentText(PublishingLoanLnk1, "��ȫ������Ľ��");
		if(base.getElementTextWithWait(FirstRepayLoan).equals("��Ŀǰ��û�С���ȫ������Ľ���")){
			return false;
		}else{
			return true;
		}
	}
	//��������Ŀ�ġ�
	public String clickLoanPurpose(){
		base.clickWithWait(LoanLnks);
		base.checkElementVisible(RepayList);
		String RepayTime = base.getElementTextWithWait(FirstRepayTime);
		String RealTime = RepayTime.split("/")[0];//ʵ��������
		return RealTime;
	}
	//��ȡʵ����Ϣ
	public String getRealPayMoney(){
		int qishu=Integer.parseInt(base.getElementTextWithWait(QiShuTxt).substring(4));
		List<WebElement> real = base.getElements(RealBX);
		double amount=0;
		for(int i=0;i<qishu;i++){
			String pay = real.get(i).getText().substring(1);
//			if(pay.contains(",")){
				pay=pay.replaceAll(",", "");
//			}
			amount=amount+Double.parseDouble(pay);
		}
		return base.cutMoney(amount);
	}
	//���"��ȫ������Ľ��"�е�"�鿴���ص��ӽ���"����
	public String clickRepayedIOULnk(){
			
		base.clickWithWait(RepayedIOULnk);
		base.jumpToNewWindow();
		base.checkTitle("���ӽ���");
		String Amount = base.getElementTextWithWait(ElectronicIOU.BorrowAmountTxt);
		String time = Amount.substring(Amount.indexOf("��")+2, Amount.indexOf("��")).trim();//��Ϣ�գ�2015��09��01
		base.closeAndjumptoOldWindow();
		return time;
	}
	//��顰��ȫ������Ľ��ı���Ϣ
	public void checkRepayedLoanInfo(String time){
		String qishu;
		String day = time.substring(time.indexOf("��")+1).trim();
		time = time.replaceAll("[^0-9]", "-");
		if(day == "21"){
			qishu = "3";
		}else{
			qishu = "4";
		}
		String realmoney=getRealPayMoney();
//		int chaday = base.daysBetween(time, RepayTime)+1;
//		double lixi = 10000*0.101/base.getDaysOfYear(2015)*chaday;
//		String benxi = base.intMoney(lixi+10000);
		base.assertEqualsActualExpected(base.getElementTextWithWait(LoanLnks), "�Զ�������ʹ��");
		String [] Infos = {"�����: ��10,000","������: 10.10%","����: "+qishu,"Ӧ����Ϣ: ��10,252.51","ʵ����Ϣ: ��"+realmoney,"δ�����:��0"};
		List<WebElement> info = base.getElements(LoanInfos);
		for(int i=0;i<6;i++){
			base.assertEqualsActualExpected(info.get(i).getText(), Infos[i]);
		}
	}
	//��顰��ȫ������Ľ��еĻ����б�
	public void checkRepayList(String RepayTime,String time){
		String qishu = base.getElementTextWithWait(QiShuTxt).split(":")[1].trim();
		List<WebElement> qishus = base.getElements(QiShuList);
		int size = qishus.size();
		base.assertEqualsActualExpected(String.valueOf(size), qishu);
//		for(int i =0;i<size;i++){
//			base.assertEqualsActualExpected(base.getElementText(By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/tr["+(i+1)+"]/td")), String.valueOf(i+1));
//		}
		String days = time.substring(time.indexOf("��")+1).trim();
		int day = Integer.valueOf(days);
		time = time.replaceAll("[^0-9]", "-");//2015-09-01
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM"); 
		try {
			cal.setTime(df.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String currentDate = date.format(cal.getTime());//2015-09
		cal.add(Calendar.MONTH, 1);
		String nextDate= date.format(cal.getTime());//�¸���ʱ��	
		cal.add(Calendar.MONTH, 1);
		String next2Date = date.format(cal.getTime());//���¸���
		cal.add(Calendar.MONTH, 1);
		String next3Date = date.format(cal.getTime());//�����¸���	
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String next4Date = df.format(cal.getTime());//�����¸��µ�ǰһ��	
		String [] timelist1 = {RepayTime+"/"+currentDate+"-20",RepayTime+"/"+nextDate+"-20",RepayTime+"/"+next2Date+"-20",RepayTime+"/"+next4Date};
		String [] timelist2 = {RepayTime+"/"+nextDate+"-20",RepayTime+"/"+next2Date+"-20",RepayTime+"/"+next3Date+"-20",RepayTime+"/"+next4Date};
		
		int chaday = base.daysBetween(time, RepayTime)+1;//��ǰ����ͼ�Ϣ�ղ������
		int chaday2 =0;
		String [] timelist = null;
		if(1<=day&& day<21){
			chaday2= base.daysBetween(time, currentDate+"-20")+1;//��Ϣ�պͼƻ��ĵ�һ���������ڲ������
			timelist= timelist1;
		}else if(21<day && day<=31){
			chaday2= base.daysBetween(time,nextDate+"-20")+1;
			timelist=timelist2;
		}
		double SHlixi = 10000*0.101/365*chaday;
		double Planlixi = 10000*0.101/365*chaday2;
		String SHbenxi = base.intMoney(SHlixi);
		String PlanInterest = base.intMoney(Planlixi);
		String PlanlastInterest = base.intMoney(84.17-Planlixi);
		String [][] List1 ={{"1","2","3"},{RepayTime+"/"+nextDate+"-20",RepayTime+"/"+next2Date+"-20",RepayTime+"/"+next3Date+"-20"},{"��0","��0","��10,000"},{"��84.17","��84.17","��84.17"},{"��"+SHbenxi,"��0","��10,000"},{"��ǰ����","��ǰ����","��ǰ����"}};
		String [][] List2 ={{"1","2","3","4"},timelist,{"��0","��0","��0","��10,000"},{"��"+PlanInterest,"��84.17","��84.17","��"+PlanlastInterest},{"��"+SHbenxi,"��0","��0","��10,000"},{"��ǰ����","��ǰ����","��ǰ����","��ǰ����"}};
		String [][] Plans;
		if(day == 21){
			Plans = List1;
		}else{
			Plans = List2;
		}
		for(int i=1;i<6;i++){
			for(int j=1;j<size;j++){
				base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/tr["+j+"]/td["+i+"]")), Plans[i-1][j-1]);
			}
		}
	}
	
	//�������δ�����Ľ�ѡ��
	public boolean clickPublishingLoanLnk(){
		base.clickWithWait(PublishingLoanLnk);
		base.checkElmentText(PublishingLoanLnk1, "��δ�����Ľ��");
		if(base.isElementPresent(LoanHead)){
//			base.assertTrueByBoolean(base.isElementPresent(Lines));
			base.checkElmentText(BorrowInfo, "1");
			return true;
		}else{
			base.assertEqualsActualExpected(base.getElementTextWithWait(NoPublishedLoanTxt), "��Ŀǰ��û�С���δ�����Ľ���");
			return false;
		}
	}
	
	//������ѷ����Ľ�ѡ����ؽ������
	public boolean clickPublishedLoanLnk(){
		base.clickWithWait(PublishedLoanLnk);
		base.checkElmentText(PublishingLoanLnk1, "�ѷ����Ľ��");
		if(base.getElementTextWithWait(NoPublishedLoanTxt).equals("��Ŀǰ��û�С��ѷ����Ľ���")){
			return false;
		}else{
			return true;
		}
//		if(base.isElementPresent(LoanHead)){
//			base.checkElmentText(BorrowInfo, "1");
//			return true;
//		}else{
//			base.assertEqualsActualExpected(base.getElementText(NoPublishedLoanTxt), "��Ŀǰ��û�С��ѷ����Ľ���");
//			return false;
//		}
	}
	//��á��ѷ����Ľ�������
	public int getNumofAllLoan(){

		if(base.getElementTextWithWait(NoPublishedLoanTxt).equals("��Ŀǰ��û�С��ѷ����Ľ���")){
			return 0;
		}else if(base.getElementTextWithWait(NoPublishedLoanTxt).equals("��Ŀǰ��û�С���δ�����Ľ���")){
			return 0;
		}else{
			if(base.getElementTextWithWait(FourthPageLnk).equals(">")){
				return base.getElements(Lines).size();
			}else{
				base.clickWithWait(LastPage);
				base.checkElementVisible(LastTwoPage);
				int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
				int NuminLastPage= base.getElements(Lines).size();
				base.clickWithWait(FirstPage);
				base.checkElmentText(CurrentPage, "1");
				return (lastPageNum-1)*10+NuminLastPage;
			}
		}
	}
	//��һ�����Ǽƻ����Ƿ�����ҵ��
	public boolean ifFirstBidisQiYeBid(){
		if(base.getElementTextWithWait(FirstBidType).equals("��ҵ-���Ǽƻ���")){
			return true;
		}else{
			return false;
		}
	}
	//�Ƿ��С���ҵ-���Ǽƻ��ꡱ
	public boolean ifShowQYBid(){
		
		Boolean result = false;
		List<WebElement> Bidtypes = base.getElements(BidTypes);
		int size = Bidtypes.size();
		for(int i=0;i<size;i++){
			if(Bidtypes.get(i).getText().equals("��ҵ-���Ǽƻ���")){
				base.clickWithWait(By.xpath("//div[@id='_content_child']/table/tbody/tr["+(i+1)+"]/td[2]/a"));
				base.jumpToNewWindow();
				base.checkElement(EStarPlanLoanDetailPage.LoanInfoonTop);
				result=true;
				break;
			}
		}
		return result;
	}
	//��������Ŀ�ġ�
	public void clickLoanTitleLnk(){
		base.clickWithWait(LoanPurposeLnk);
		base.jumpToNewWindow();
		base.checkElement(EStarPlanLoanDetailPage.LoanInfoonTop);
	}
	//���롰�Ƽ������롱
	public void InputRefereeInviteCode(String YaoQingMa){
		base.checkElementVisible(voucherTxt);
		base.sendKeysWithWait(voucherTxt, YaoQingMa);
	}
	//���롰����
	public void InputBorrowMoney(String amount){
		base.sendKeysWithWait(amountTxt, amount);
	}
	//ѡ�񡰽��������͡�
	public void selectBorrowerType(String type){
		base.elementSelectByVisibleText(borrowerTypeSel, type);
		if(type.equals("��ҵ")){
			base.checkElementVisible(FillInQYInfoLnk);
		}
	}
	//�������д��ҵ��Ϣ������
	public void clickFillInQYInfoLnk(){
		base.clickWithWait(FillInQYInfoLnk);
		base.checkElement(QYBidInfoTitle);
	}
	//��д��ծȨ�Ƽ������ơ�
	public void InputQYReferrerName(String name){
		base.sendKeysWithWait(InputQiYeReferrerName, name);
	}
	//������롰ծȨ�Ƽ������ơ�
	public void checkInputReferrerName(String input,String result){
		
		InputQYReferrerName(input);
		base.clickWithWait(InputQiYeReferrerIntro);
		base.checkElmentText(ReferrerNameTipTxt, result);
	}
	//��д��ծȨ�Ƽ��˼�顱
	public void InputQYReferrerIntro(String intro){
		base.sendKeysWithWait(InputQiYeReferrerIntro, intro);
	}
	//������롰ծȨ�Ƽ��˼�顱
	public void checkInputReferrerIntro(String input,String result){
			
		InputQYReferrerIntro(input);
		base.clickWithWait(InputQiYeBusiness);
		base.checkElmentText(ReferrerIntroTipTxt, result);
	}
	//��д��ע���
	public void InputRegisterAmount(String amount){
		
		base.sendKeysWithWait(InputQiYeRegisteredAmount, amount);
	}
	//������롰ע���
	public void checkInputRegisterAmount(String amount,String result){
		
		InputRegisterAmount(amount);
		base.clickWithWait(InputQiYeInvestAmount);
		base.checkElmentText(RegisterAmountTipTxt, result);
	}
	
	
	//��������桱��ҵ����Ϣ
	public void clickSaveBtn(){
		base.clickWithWait(QiYeSaveBtn);
		base.checkNoElement(QYBidInfoTitle);
	}
	//�����ȡ������ҵ����Ϣ
	public void clickCancelBtn(){
		base.clickWithWait(QiYeCancelBtn);
		base.checkNoElement(QYBidInfoTitle);
	}

	//��д����ҵ����Ϣ��
	public void ImproveQYBidInfo(){
		base.sendKeysWithWait(InputQiYeName, "��������");
		base.sendKeysWithWait(InputQiYeAddress, "���������йش�");
		base.removeReadOnly("foundedtime");
		base.sendKeysWithWait(InputQiYefoundedtime, "2015-08-01");
		base.sendKeysWithWait(InputQiYeReferrerName, "�����������޹�˾");
		base.sendKeysWithWait(InputQiYeReferrerIntro, "�����������޹�˾��һ�Ҵ��͵�Ͷ�ʹ�˾������һ��������ҵ��������2003��");
		base.sendKeysWithWait(InputQiYeBusiness, "Ŀǰ��ҪͶ�ʺ;�Ӫ�Ĳ�ҵ�У����С�֤ȯ�Ƚ��ڲ�ҵ���ִ�ũҵ���ۿڽ�ͨ��ҵ����Ϣ��ҵ");
		base.sendKeysWithWait(InputQiYeRegisteredAmount, "1000000");
		base.sendKeysWithWait(InputQiYeInvestAmount, "1000000");
		base.sendKeysWithWait(InputQiYeBusinessState, "�ӹ�˾��������Ͷ�ʵĴ󲿷ֹ�˾���Ѿ����˽ϸߵ�ӯ���ر�����չ����");
		base.sendKeysWithWait(InputQiYeUseType, "��Ҫ���ڻ����");
		base.sendKeysWithWait(InputQiyeRepaySource, "��Ҫ�Ǵ��ڶ��Ͷ�ʹ�˾��ӯ�����������������Ǵ������ط�������");
		base.sendKeysWithWait(InputQiyeCounterSecurity, "�������������������޹�˾�����������޹�˾�����������޹�˾�����������޹�˾");
		base.sendKeysWithWait(InputQiyeSafeGuard, "�������粻�����ڳ������б����������޹�˾�����г������б����������޹�˾������");
		base.sendKeysWithWait(InputQiyeSafeGuardReason, "�����������Ϊֻ�����ڻ�����������������˾��ȫ���������������");
		base.clickWithWait(QiYeSaveBtn);
		base.assertEqualsActualExpected(base.getAlertwithWait().getText(), "��Ϣ����ɹ���лл��");
		base.acceptAlert();
	}
	//��顰��ҵ����Ϣ��-��ծȨ�Ƽ������ơ����������
	public void checkQYReferrerName(){
		try{
			checkInputReferrerName("ab","");
			checkInputReferrerName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx","");
			checkInputReferrerName("abcdefghijklmnopqrst","");
			checkInputReferrerName("a","��������2���֣�");
			checkInputReferrerName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy","���ܶ���50���֣�");
			checkInputReferrerName("","ծȨ�Ƽ������Ʋ���Ϊ�գ�");
//			InputQYReferrerName("abcdefghijklmnopqrstuvwxyz");
//			base.CopyAndPaste();
//			base.clickWithWait(InputQiYeReferrerIntro);
//			base.checkElmentText(ReferrerNameTipTxt, "���ܶ���50���֣�");
		}catch(Exception e){
			clickCancelBtn();
			Assert.fail(e.toString());
		}
	}
	
	//��顰��ҵ����Ϣ��-��ծȨ�Ƽ��˼�顱���������
	public void checkQYReferrerIntro(){
		try{
			checkInputReferrerIntro("abcdefghijklmnopqrstuvwxyzabcd","");
			checkInputReferrerIntro("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefg","");
			checkInputReferrerIntro("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqr","");
			checkInputReferrerIntro("abcdefghijklmnopqrstuvwxyzabc","ծȨ�Ƽ��˼���������������30������д��ɣ�");
			checkInputReferrerIntro("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefgh","ծȨ�Ƽ��˼���������������500����");
			checkInputReferrerIntro("","ծȨ�Ƽ��˼�鲻��Ϊ�գ�");
		}catch(Exception e){
			clickCancelBtn();
			Assert.fail(e.toString());
		}
	}
	//��顰��ҵ����Ϣ��-��ע������������
	public void checkQYRegisterAmount(){
		try{
			checkInputRegisterAmount("10000.3","");
			checkInputRegisterAmount("10000.3f","ע�����ʽ����ȷ��");
			checkInputRegisterAmount("","������ע���");
		}catch(Exception e){
			clickCancelBtn();
			Assert.fail(e.toString());
		}
	}
	
	//ѡ�񡰽�����ޡ�
	public void selectBorrowPhase(String QiXian){
		base.checkElementVisible(phasesSel);
		base.elementSelectByVisibleText(phasesSel, QiXian);
	}
	//ѡ�񡰽�����͡�
	public void selectBorrowType(String type){
		base.elementSelectByVisibleText(usetypeSel, type);
	}
	//���롰���Ŀ�ġ�
	public void InputBorrowPurpose(String purpose){
		base.sendKeysWithWait(purposeTxt, purpose);
	}
	//���롰��ϵ�绰��
	public void inputPhone(String phone){
		base.sendKeysWithWait(phoneTxt, phone);
	}
	//���롰��ϵ���䡱
	public void inputMail(String mail){
		base.sendKeysWithWait(mailTxt, mail);
	}
	//�������ӡ���ť���ں�֤�ˣ�
	public void clickAddBtn(){
		base.clickWithWait(addBtn);
		base.checkElementVisible(baoZhengRenDiv);
	}
	//ѡ���ں�֤�����͡�
	public void selectBaoZhengRenType(String type){
		base.elementSelectByVisibleText(baoZhengRenSel, type);
	}
	//�ں�֤������Ϊ����Ȼ�ˡ������롰������
	public void inputBaoZhengRenZrrName(String name){
		base.sendKeysWithWait(baoZhengRen_zrr_name, name);
	}
	//�ں�֤������Ϊ����Ȼ�ˡ������롰���֤�š�
	public void inputBaoZhengRenZrrIdCard(String id){
		base.sendKeysWithWait(baoZhengRen_zrr_idCard, id);
	}
	//�ں�֤������Ϊ����Ȼ�ˡ������롰������ַ��
	public void inputBaoZhengRenZrrHousehold(String household){
		base.sendKeysWithWait(baoZhengRen_zrr_household, household);
	}
	//�ں�֤������Ϊ����Ȼ�ˡ������롰��ס����ַ��
	public void inputBaoZhengRenZrrAddress(String address){
		base.sendKeysWithWait(baoZhengRen_zrr_address, address);
	}
	//�ں�֤������Ϊ����Ȼ�ˡ������롰��ϵ�绰��
	public void inputBaoZhengRenZrrTel(String tel){
		base.sendKeysWithWait(baoZhengRen_zrr_tel, tel);
	}
	//�ں�֤������Ϊ����Ȼ�ˡ������롰��ϵ���䡱
	public void inputBaoZhengRenZrrMail(String mail){
		base.sendKeysWithWait(baoZhengRen_zrr_mail, mail);
	}
	//�ں�֤������Ϊ����Ȼ�ˡ�����������桱��ť
	public void clickBaoZhengRenZrrSaveBtn(){
		base.clickWithWait(baoZhengRen_zrr_saveBtn);
	}
	//�ں�֤������Ϊ�����ˡ������롰���ơ�����˾���ƣ�
	public void inputBaoZhengRenFrName(String name){
		base.sendKeysWithWait(baoZhengRen_fr_name, name);
	}
	//�ں�֤������Ϊ�����ˡ������롰���������ˡ�
	public void inputBaoZhengRenFrDeputy(String deputy){
		base.sendKeysWithWait(baoZhengRen_fr_deputy, deputy);
	}
	//�ں�֤������Ϊ�����ˡ������롰��ַ������˾��ַ��
	public void inputBaoZhengRenFrAddress(String address){
		base.sendKeysWithWait(baoZhengRen_fr_address, address);
	}
	//�ں�֤������Ϊ�����ˡ������롰��ϵ�绰������˾��ַ��
	public void inputBaoZhengRenFrTel(String tel){
		base.sendKeysWithWait(baoZhengRen_fr_tel, tel);
	}
	//�ں�֤������Ϊ�����ˡ������롰��ϵ���䡱����˾��ַ��
	public void inputBaoZhengRenFrMail(String mail){
		base.sendKeysWithWait(baoZhengRen_fr_mail, mail);
	}
	//�ں�֤������Ϊ�����ˡ�����������桱��ť
	public void clickBaoZhengRenFrSaveBtn(){
		base.clickWithWait(baoZhengRen_fr_saveBtn);
	}
	
	/**
	 * ���롰�ں�֤�ˡ���Ϣ
	 * @param type �ں�֤������
	 * @param name ����
	 * @param id ���֤��
	 * @param household ������ַ
	 * @param address ��ס����ַ
	 * @param tel ��ϵ�绰
	 * @param mail ��ϵ����
	 * @author ������ 2016-1-12
	 */
	public void inputBaoZhengRenInfo(DWutGuaranteeModel guarantee){
		String type = guarantee.getType();
		selectBaoZhengRenType(type);
		if(type.equals("��Ȼ��")){
			inputBaoZhengRenZrrName(guarantee.getName());
			inputBaoZhengRenZrrIdCard(guarantee.getIdCard());
			inputBaoZhengRenZrrHousehold(guarantee.getAddr());
			inputBaoZhengRenZrrAddress(guarantee.getCurAddr());
			inputBaoZhengRenZrrTel(guarantee.getMobile());
			inputBaoZhengRenZrrMail(guarantee.getEmail());
			clickBaoZhengRenZrrSaveBtn();
		}
		else if(type.equals("����")){
			inputBaoZhengRenFrName(guarantee.getName());
			inputBaoZhengRenFrDeputy(guarantee.getLayer());
			inputBaoZhengRenFrAddress(guarantee.getCurAddr());
			inputBaoZhengRenFrTel(guarantee.getMobile());
			inputBaoZhengRenFrMail(guarantee.getEmail());
			clickBaoZhengRenFrSaveBtn();
		}
	}

	//���롰������Ϣ��
	public void InputDescription(){
		base.sendKeysWithWait(detaildescriptionTxt, "�Զ�������ʹ�ã��Զ�������ʹ�ã��Զ�������ʹ�ã��Զ�������ʹ��");
	}
	//�������������ť
	public void clickPublishBtn(){
		base.clickWithWait(releaseBtn);
		base.checkAlertText("�����ɹ����ȴ�������ˣ�лл��");
		base.isElementContainsValue(PublishedLoanLnk, "class", "current");
	}
	//�������������ť���鷢����Ϣ
	public void checkPublishedLoan(int num1,int num2){
		
		base.checkElementVisible(LoanPurposeLnk);
		base.assertEqualsActualExpected(base.getElementText(LoanPurposeLnk), "�Զ�������ʹ...");
		base.assertEqualsActualExpected(base.getElementText(StatusTxt), "������");
		base.assertEqualsActualExpectedByInt(getNumofAllLoan(), num1+1);
		clickPublishingLoanLnk();
		base.assertEqualsActualExpectedByInt(getNumofAllLoan(), num2-1);
	}
	//���������Ԥ������ť
	public void clickSavePreviewBtn(){
		base.clickWithWait(SavePreviewBtn);
		base.checkElementVisible(EStarPlanLoanDetailPage.LoanInfoonTop);
	}
	//��顰��δ�����Ľ�-�б��еı���Ϣ
	public void checkPublishingLoanData(){
		
		
		List<WebElement> nums = base.getElements(Lines);
		int num = nums.size();
		for(int i =1;i<=num;i++){
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='_content_child']/table/tbody/tr["+i+"]/td")), String.valueOf(i));
		}
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		String currentDay = d.format(cal.getTime());
		String [] Info = {"1","�Զ�������ʹ...","��10,000","10.30%","3����","������","��ҵ-���Ǽƻ���",currentDay,"Ԥ�� �޸� ���� ɾ��"};
		List<WebElement> Infos = base.getElements(BorrowInfo);
		for(int i=0;i<9;i++){
			base.assertEqualsActualExpected(Infos.get(i).getText(), Info[i]);
		}
		base.assertEqualsActualExpected(base.getLnkElementText(LoanPurposeLnk, "title"), "�Զ�������ʹ��");
	}
	//��顰�ѷ����Ľ�-�б��еı���Ϣ
	public void checkPublishedLoanData(){
		
		List<WebElement> nums = base.getElements(Lines);
		int num = nums.size();
		for(int i =1;i<=num;i++){
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='_content_child']/table/tbody/tr["+i+"]/td")), String.valueOf(i));
		}
		String [] info = {"1","�Զ�������ʹ...","��10,000","10.10%","3����"};
		List<WebElement> Infos = base.getElements(BorrowInfo);
		for(int i=0;i<5;i++){
			base.assertEqualsActualExpected(Infos.get(i).getText(), info[i]);
		}
	}
	//��顰�ѷ����Ľ��еĴ�����״̬
	public void checkPublishedAuditStatus(){
		
		String [] status = {"������","0%","������","��ҵ-���Ǽƻ���","������"};
		List<WebElement> Infos = base.getElements(BorrowInfo);
		for(int i =0;i<5;i++){
			base.assertEqualsActualExpected(Infos.get(i+5).getText(), status[i]);
		}
	}
	
	//��������еġ�Ԥ��������
	public void clickPreviewLnk(){
		
		base.clickWithWait(PreviewLnk);
		base.jumpToNewWindow();
		base.checkElement(EStarPlanLoanDetailPage.LoanInfoonTop);
	}
	//��������еġ�����������
	public void clickPublishLnk(){
		
		base.clickWithWait(PublishLnk);
		base.checkElementVisible(BorrowPage);
	}
	//���֮ǰ��д�Ľ����Ϣ
	public void checkBorrowedInfo(){
		
		base.assertEqualsActualExpected(base.getLnkElementText(voucherTxt,"value"), "ElWut1058");
		base.assertEqualsActualExpected(base.getLnkElementText(amountTxt,"value"), "10000.00");
		base.assertEqualsActualExpected(base.getLnkElementText(Interest,"value"), "10.30");
		base.assertTrueByBoolean(base.getElementWithWait(ManBiaoRadio).isSelected());
		base.assertTrueByBoolean(base.getElementWithWait(HBFXRadio).isSelected());
		base.assertEqualsActualExpected(base.getLnkElementText(purposeTxt,"value"), "�Զ�������ʹ��");
		base.assertEqualsActualExpected(base.getLnkElementText(detaildescriptionTxt,"value"), "�Զ�������ʹ�ã��Զ�������ʹ�ã��Զ�������ʹ�ã��Զ�������ʹ��");
		base.checkElementVisible(borrowerTypeSel);
		base.checkElementVisible(QYTip);
		base.checkElementVisible(ThreeMonth);
		String qiyetip = "����վ��ҵ���ͽ����ߣ����ڷ���ǰ���� ��д��ҵ��Ϣ����������ǽ�������ˡ�";
		base.assertEqualsActualExpected(base.getElementText(QYTip), qiyetip);
		base.assertTrueByBoolean(Boolean.valueOf(base.getLnkElementText(ThreeMonth, "selected")));
		base.assertTrueByBoolean(Boolean.valueOf(base.getLnkElementText(BusinessZZ, "selected")));
	}
	
	//���"���ڻ���Ľ��"�е�"�鿴���ص��ӽ���"����
	public void clickRepayingIOULnk(){
		
		base.clickWithWait(RepayingIOULnk);
		base.jumpToNewWindow();
		base.checkTitle("���ӽ���");
	}
	
	/**
	 * �жϡ����ڻ���Ľ��Ƿ�ѡ��
	 * @author ������ 2015-7-22
	 */
	public void isRepayingTabSelected(){
		boolean isContains = base.isElementContainsValue(repayingTab, "class", "current");
		base.assertEqualsActualExpectedByBoolean(isContains, true);
		base.sleep(2000);
	}
	
	/**
	 * ��֤һ���Ի��幦�ܼ��䴰����ع���
	 * @author ������ 2015-7-22
	 */
	public void checkLoanList(String numberinAvailableBalanceStr){
		boolean isDisplayed = true;
		boolean isShow = false;
		//�ж��Ƿ�������
		isDisplayed = base.isDisplayed(loanListByFirst);System.out.println("�Ƿ������ݣ�" + isDisplayed);//------����
		if(isDisplayed)
		{			
			base.sleep(2000);
			
			//У�顰һ���Ի��塱����
			//1.�����һ���Ի��塱����
			base.clickWithWait(disposablePayOffByFirst);
			base.sleep(1000);
			isShow = !base.isNone(outAllWindow);System.out.println("��������ȷ�Ͽ��Ƿ���ʾ��" + isShow);//------����
			//2.��������ȷ�Ͽ�
			base.assertEqualsActualExpectedByBoolean(isShow, true);
			
			//У�顰��Ҫ��ֵ������
			//1.�������Ҫ��ֵ��
			base.clickWithWait(iNeedRecharge);
			base.sleep(2000);
			//2.У������ֵҳ��
			base.assertEqualsActualExpectedByBoolean(base.isDisplayed(rechargeDiv), true);
			base.sleep(2000);
			//3.���ء��ҵĽ���ƻ���
			myAccountPage.turnToMyAccount("�ҵĽ���ƻ�");
			base.sleep(1000);
			//4.�����һ���Ի��塱����
			base.clickWithWait(disposablePayOffByFirst);
			base.sleep(1000);
			
			//У�顰����˻����������ʽ���Լ���Ӧ������ʾ�Ƿ���ȷ
			//1.У�顰����˻���
			String balanceByWindowStr = base.getElementTextWithWait(balanceByWindow);
			//ȥ����
			balanceByWindowStr = balanceByWindowStr.substring(1);
			if(balanceByWindowStr.equals("0")){
				balanceByWindowStr = balanceByWindowStr + ".00";
			}
			System.out.println("�����˻����:" + balanceByWindowStr);//-----����
			base.assertEqualsActualExpected(balanceByWindowStr, numberinAvailableBalanceStr);
			//2.У�顰���ʽ��
			System.out.println("���ʽ:" + base.getElementTextWithWait(theWay));//-----����
			base.assertEqualsActualExpected(base.getElementTextWithWait(theWay), "��ǰһ���Ի���");
			//3.У�顰Ӧ����
			//��ʽ�������*������/������
			Reporter.log("error_���Ǽƻ�_�ҵĽ���ƻ�_����ȷ�϶Ի���_���ʽ_��ʽ���ӣ����ֶ�У��");
			System.out.println("error_���Ǽƻ�_�ҵĽ���ƻ�_����ȷ�϶Ի���_���ʽ_��ʽ���ӣ����ֶ�У��");
			
			//У��رա�����ȷ�ϡ����ں�ԭ���ڻ����б�
			//1.����رհ�ť
			base.clickWithWait(cancelBtn);
			base.sleep(1000);
			//2.ԭ���ڻ����б�
			base.assertEqualsActualExpectedByBoolean(base.isDisplayed(disposablePayOffByFirst), true);
		}
		else{
			Reporter.log("error_���Ǽƻ�_�ҵĽ���ƻ�_û�����ڻ���Ľ��");
			System.out.println("error_���Ǽƻ�_�ҵĽ���ƻ�_û�����ڻ���Ľ��");
		}
	}
}	
