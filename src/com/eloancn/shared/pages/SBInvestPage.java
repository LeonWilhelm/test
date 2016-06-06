package com.eloancn.shared.pages;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.PageTitles;
/*
 * ���ҵ��˻���-��ɢ��Ͷ�ʡ�ҳ��
 */
public class SBInvestPage {
	Base base = new Base();
	
	public static By SBInvestTxt = By.xpath("//div[2]/div/h1");				//ҳ�����
	By EarnedInterestImg = By.id("qt1");										//����׬��Ϣ��ͼ��
	By ReceivedFeesImg = By.id("qt2");											//�����ղƸ�����ѡ�ͼ��
	By ReceivingBXImg = By.id("qt3");											//�����ձ�Ϣ��ͼ��
	By ReceivingInterestImg = By.id("qt4");										//��������Ϣ��ͼ��
	By EarnedInterestMoney = By.id("totalBorrowMoney");							//����׬��Ϣ���Ľ��
	By ManagementFeeMoney = By.id("managerAccountMoney");						//�����ղƸ�����ѡ��Ľ��
	By ReceivingBXMoney = By.id("totalToCollectAllMoney");						//�����ձ�Ϣ���Ľ��
	By ReceivingLXMoney = By.id("totalToCollectInterest");						//��������Ϣ���Ľ��
	By ReceivingBJMoney = By.id("totalToCollectMoney");							//�����ձ��𡱵Ľ��
	
	By waitPrincipalNumByLend = By.cssSelector("#totalToCollectMoney");         //���ձ���
	By waitInterestNumByLend = By.cssSelector("#totalToCollectInterest");       //������Ϣ
	By PaybackLnk = By.id("backing");											//"�����е�Ͷ��"����
	By JoiningInvestLnk= By.id("tender");										//�������е�Ͷ�ʡ�����
	By ClosedInvestLnk = By.id("backed");										//���ѽ����Ͷ�ʡ�����
    By EBillLnk = By.cssSelector("li.tb1>a");									//"�����˵�"����
	By retrieveTxt = By.cssSelector("#backing");                                //"�����е�Ͷ��"����
	
	
    By MyReportLnk = By.xpath("//div[@id='_content']/div/div/div[2]/ul/li[3]/a");//���ҵľٱ�������
    By MyBlacklistLnk = By.cssSelector("li.tb5>a.pdl25");						//���ҵĺ�����������
    By LocalPreBidLnk = By.cssSelector("li.tb3 > a");							//��ͬ��ԤͶ�ꡱ����
    By SubTitle = By.xpath("//div[@id='_content']/div/div/h1");					//�ӱ���
    
     //�����˵�
//    By EBillTitle = By.cssSelector("h1.f-fc333");								//"�����˵�"������
    By EBillTime = By.xpath("//div[@id='_content']/div/div/h1/span/span");		//�������˵���ʱ���
    By EBillTxt = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div");  //"�����˵�"����
    //�յĵ����˵�
    By BalanceTxt = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/p");//�˻�����ı�
    By NoRecordTipTxt = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/p[2]");//û�м�¼���ı���ʾ
    By GoInvestBtn = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/p[3]/a");	//��ȥͶ�ʡ���ť
    //�����ݵĵ����˵�
    By TotalIncomeTipImg = By.cssSelector("img.imgTip");						//"�����ܶ�"����ʾͼ��
    By TipTxt = By.cssSelector("div.ui-tooltip-content");						//"�����ܶ�"����ʾ����
    By IncomeAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div/p");//"�����ܶ�"�Ľ��
    By InvestAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div[2]/p");//"Ͷ���ܶ�"�Ľ��
    By RechargeAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div[4]/p");//"��ֵ�ܶ�"�Ľ��
    By TXAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div[5]/p");//"�����ܶ�"�Ľ��
    By AccountBalanceTxt = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div[3]/p");//���˻����Ľ��
    By FreezeMoney = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div/div[6]/p");//"������"�Ľ��
    By FuTouLnk = By.cssSelector("a.fuTou");												//����Ͷ������
    By NormalPayAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p/span[2]");//����������Ľ��
    By NormalPayNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p/span[3]");//����������ı���
    By ReceivedOverdueAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[2]/span[2]");//�������ѻ����Ľ��
    By ReceivedOverdueNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[2]/span[3]");//�������ѻ����ı���	
    By OverdueAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[3]/span[2]");//������δ�����Ľ��
    By OverdueNum1 = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[3]/span[3]");//������δ�����ı���
    By TransferAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[4]/span[2]");//"ծȨת��"�Ľ��
    By TransferNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[4]/span[3]");//"ծȨת��"�ı���
    By InvestSBAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[5]/span[2]");
    By InvestSBNum =By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[5]/span[3]");
    By BuyCreditAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[6]/span[2]");
    By BuyCreditNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[6]/span[3]");
    By RechargeAmount1 = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[7]/span[2]");
    By RechargeNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[7]/span[3]");
    By WithdrawAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[8]/span[2]");
    By WithdrawNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[8]/span[3]");
    By FeeAmount = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[9]/span[2]");
    By FeeNum = By.xpath("//div[@id='_content']/div/div[2]/div[2]/div/div[2]/div/p[9]/span[3]");
    By NormalPayViewLnk  = By.cssSelector("a.see");										//����������Ĳ鿴����
    By NormalPayTxt = By.id("title1");													//"������������6��,����54.66"�ı�
    By PayLines = By.cssSelector("#detailstable1>tbody>tr");							//"��������"������
    By DealAmount = By.xpath("//table[@id='detailstable1']/tbody/*/td[3]");				//���еġ����׽�
    By ExportRecordBtn = By.xpath("//div[@id='messageBoxCard']/input");					//�����׼�¼���� ����ť
    
    //���ҵľٱ���
//    By MyReportTitle = By.xpath("//div[@id='_content']/div/div/h1");					//���ҵľٱ�������
    By FirstLine = By.cssSelector("table.mt10.global_table>tbody>tr");					//��һ�е�����
    By FirstLineInfos = By.cssSelector("table.mt10.global_table>tbody>tr>td");			//��һ���е���Ϣ
    By ReportedUser = By.xpath("//div[@id='_content']/div/div[2]/div[2]/table/tbody/tr/td/a");//��һ���еı��ٱ��� 
    
    //���ҵĺ�������
    By FirstLine1 = By.xpath("//form[@id='form1']/table/tbody/tr");						//���ҵĺ���������һ��
    By FirstLineInfos1 = By.xpath("//form[@id='form1']/table/tbody/tr/td");				//���ҵĺ���������һ���е���Ϣ
    By Checkbox = By.id("id");															//���ҵĺ���������һ���еĸ�ѡ��
    By UserName = By.xpath("//form[@id='form1']/table/tbody/tr/td[2]/a");				//�û�����
    By DeleteLnk = By.xpath("//form[@id='form1']/table/tbody/tr/td[5]/a");				//��ɾ��������
    
    //��ͬ��ԤͶ�ꡱ
    
    //"Ͷ�������"
    By IncomeStatement = By.cssSelector("div.alert_title");								//"Ͷ�������"����
    By BalanceTxtinTable = By.xpath("//div[@id='showincome1']/p");						//"���Ŀ������Ϊ9691.08,�����������ӵ�У�"
    By SubTitleinTable = By.xpath("//div[@id='showincome1']/table/thead/tr/th");		//ÿһ�е�С����
    By CloseTableLnk = By.cssSelector("a.alert_close");
    
	//�����е�Ͷ��
	By huoChuMoneysNum = By.cssSelector(".record_info>li:nth-child(2)");        //�������
	By BidStatusTxt = By.cssSelector("#tenderStatus > span.ml8"); 				//"�����е�Ͷ��"ҳ���еġ�����״̬���ı�
	By InputBorrower = By.id("borrowName");										//���롰 ������� �����ҵ�����
	By SearchBtn = By.cssSelector("input.time_submit");							//����ѯ����ť
	By BackingContent = By.cssSelector("#_content_child>div");					//"�����е�Ͷ��"ҳ����ʾ
	By NoPaybackTxt = By.cssSelector("div.global_tip.textC");					//û�С������е�Ͷ�ʡ�ʱ����ʾ
	By BackingTitle = By.xpath("//div[@id='_content_child']/*/div/a");			//ÿ���������е�Ͷ�ʡ��еı���
	By Borrower = By.xpath("//div[@id='_content_child']/*/div[2]/ul/li/a");		//������
	By InvestMoney = By.xpath("//div[@id='_content_child']/*/div[2]/ul/li[2]");//�������
	By Rate = By.xpath("//div[@id='_content_child']/*/div[2]/ul/li[3]");		//������
	By ReceivingMoney = By.xpath("//div[@id='_content_child']/*/div[2]/ul/li[6]/span");//���ս��
	By PayPlanDetail = By.cssSelector("table.record_table");					//����������е�Ͷ�ʡ��еı��ⵯ�����տ�ƻ�
	By ReceivingBXinTable = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/*/td[5]");//δ�ձ�Ϣ
	By SixPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");				//ҳ���ĵ�6������
	By LastPage = By.xpath("//div[@id='Pagination']/ul/li[text()='ĩҳ']");		//ĩҳ
	By LastOnePage = By.xpath("//div[@id='Pagination']/ul/li[text()='>']");		//ĩҳ��ǰһ������
	By LastTwoPage = By.xpath("//div[@id='Pagination']/ul/li[last()-2]");		//ĩҳ��ǰ��������
	By FirstPage = By.xpath("//div[@id='Pagination']/ul/li[text()='��ҳ']");		//��ҳ
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");				//Ŀǰҳ

	//����Ӧ�յ�Ͷ��
	By Content = By.cssSelector("div.global_table.overflowV>table>tbody");		//"����Ӧ�յ�Ͷ��"ҳ����ʾ
	By ReceivedPrincipal = By.xpath("//div[@id='_content_child']/div/div/ul/li/span");//�����ձ��𡱵Ľ��
	By ReceivedInterest = By.xpath("//div[@id='_content_child']/div/div/ul/li[2]/span");//��������Ϣ���Ľ��
	By ReceivingPrincipal = By.xpath("//div[@id='_content_child']/div/div/ul/li[3]/span");//"���ձ���"�Ľ��
	By ReceivingInterest = By.xpath("//div[@id='_content_child']/div/div/ul/li[4]/span");//"������Ϣ"�Ľ��
	By OverdueNum = By.xpath("//div[@id='_content_child']/div/div/ul[2]/li[3]/span");//�����ڱ�����
	By ReceivedOverdue = By.xpath("//div[@id='_content_child']/div/div/ul[2]/li[4]/span");//���������ڷ�Ϣ��
	By CreditAssignLnk = By.cssSelector("a.fr record_otherlink colorF8");		//ɢ���е�"ծȨת��"����
	By InvestLines = By.xpath("//div[@id='_content_child']/div[2]/table/tbody/tr");//"����Ӧ�յ�Ͷ��"������
	By RealPayDate = By.xpath("//div[@id='_content_child']/div[2]/table/tbody/*/td[9]");//���еġ�ʵ��ʱ�䡱
	By PaymentPlanLnk = By.xpath("//div[@id='_content_child']/div[2]/table/tbody/*/td[10]/a");//"�տ�ƻ�"����
	By PaymentPlanTitle = By.id("saveTitle");									//�����ġ��տ�ƻ�������
	By PlanPayDate = By.xpath("//table[@id='detailstable']/tbody/*/td[2]");		//���е�"Ӧ�տ�����"
	By RealDate = By.xpath("//table[@id='detailstable']/tbody/*/td[3]");		//���е�"ʵ���տ�����"
	By ReceivedBX = By.xpath("//table[@id='detailstable']/tbody/*/td[4]");		//���е�"���ձ�Ϣ"
	By ReceivingBX = By.xpath("//table[@id='detailstable']/tbody/*/td[5]");		//���е�"δ�ձ�Ϣ"
	By FaKuan = By.xpath("//table[@id='detailstable']/tbody/*/td[6]");			//���е�"���ڷ�Ϣ"
	By StatusTxt = By.cssSelector("span.record_statusY");						//���еġ�״̬��
	By ClosePlanLnk = By.xpath("//div[@id='messageBoxCard']/div/span[2]/a");	//�رյ����ġ��տ�ƻ���
	
	//�����е�Ͷ��
	By NoJoiningInvestTxt = By.xpath("//div[@id='_content_child']/div/div/p");//��Ŀǰ��û�в����е�Ͷ�ʿ
	By JoiningLines = By.xpath("//div[@id='_content_child']/div/table/tbody/tr");//�б���
	By Status = By.xpath("//div[@id='_content_child']/div/table/tbody/*/td[8]");//״̬
	By LoanTitle = By.xpath("//div[@id='_content_child']/div/table/tbody/*/td[2]/a");//������
	By LoanUser = By.xpath("//div[@id='_content_child']/div/table/tbody/*/td[3]");//��������
	By EffectiveMoney = By.xpath("//div[@id='_content_child']/div/table/tbody/*/td[5]");//��Ч��� 
	By JoinedRate = By.xpath("//div[@id='_content_child']/div/table/tbody/*/td[6]");//����
	
	//�ѽ����Ͷ��
	By ClosedContent = By.cssSelector("#_content_child>div.mt10");					//"�ѽ����Ͷ��"ҳ���Ͷ��
	public By BorrowTitle = By.xpath("//div[@id='_content_child']/div/div/a");				//������
	By ViewElectronicIOULnk = By.xpath("//div[@id='_content_child']/div/div/a[3]");//"�鿴���ص��ӽ���"����
	By LoanDetailLnk = By.xpath("//div[@id='_content_child']/div/div/a[2]");				//��������顱����
	public By FirstBorrower = By.xpath("//div[@id='_content_child']/div/div[2]/ul/li/a");		//��һ���ġ������ߡ�
	public By FirstRate = By.xpath("//div[@id='_content_child']/div/div[2]/ul/li[2]");				//��һ���ġ������ʡ�
	By FirstPhase = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/tr/td");		//�տ�ƻ��б�ĵ�һ��
	
	//�������ڡ�ծȨת�á�
	By PopCreditAssignTxt = By.cssSelector("div.RT_tit > span.fl");				//ծȨת�ñ���
	By InputAssignReason = By.id("title");										//ת��ԭ�������
	By FixedPriceRadio = By.id("ykjmode");										//һ�ڼ�
	By AuctionRadio = By.id("paimaimode");										//����
	By SecretAssignRadio = By.id("mizhuanmode");								//��ת
	By SelectRemainTime = By.id("duration");									//��Чʱ��
	By WaitPrincipalTxt = By.id("daishou");										//���ձ���
	By InputLowPrice = By.id("upsetprice");										//ת�õ׼������
	By InputTransforCode = By.id("transforCode");								//��ת�������
	By InputPayPwd = By.id("upsetpaypassword");									//֧�����������
	By OKBtn = By.cssSelector("button.RT_ok");									//ȷ��
	By CancelBtn = By.cssSelector("button.RT_cancel");							//ȡ��
	
	/**
	 * ����Ԫ
	 * ����Զ�Ͷ�갴ť
	 */
	public void clickAutoBidBtn(){
		base.clickWithWait(By.cssSelector(".lend_tip_bgimg"));
	}
	
	//������Ϸ�ͼ�꼰����δ����Ϣ������
	public void CheckTopLeftData(boolean collect){
		moveToImgs(EarnedInterestImg,"ɢ��+����ծȨ�ľ����棬���治�����Ƹ�����ѣ���������ƽ̨������֧����40����Ϣ");
		moveToImgs(ReceivedFeesImg,"�����ÿ�»���ʱ��ϵͳ�Զ��۳���Ϣ��10%��Ϊ�Ƹ�����ѣ�����ƽ̨������֧����40����ϢҲ�����Ƹ������");
		moveToImgs(ReceivingBXImg,"ɢ��+����ծȨ���յı������Ϣ����Ϣ�����Ƹ������");
		moveToImgs(ReceivingInterestImg,"ɢ��+����ծȨ���յ���Ϣ����Ϣ�����Ƹ������");
		String begin=base.getLastMonthDate(-24);
		String end=base.getLastMonthDay(24);		
		inputSearchDate(begin,end);	
		clickSearchBtn();
		clickSearchBtn();
		String waitBJ = base.getElementTextWithWait(ReceivingPrincipal).split(" Ԫ")[0];
		String waitLX = base.getElementTextWithWait(ReceivingInterest).split(" Ԫ")[0];
		double waitBX = Double.parseDouble(waitBJ)+Double.parseDouble(waitLX);
		String ReceivedLX = base.getElementTextWithWait(ReceivedInterest).split(" Ԫ")[0];
		String topEarnedLX = base.getElementTextWithWait(EarnedInterestMoney);
		String topFee= base.getElementTextWithWait(ManagementFeeMoney);
		if(collect){
			base.assertEqualsActualExpected(base.roundingMoney(Double.parseDouble(topEarnedLX)+Double.parseDouble(topFee)), ReceivedLX);
		}	
		base.assertEqualsActualExpected(base.getElementTextWithWait(ReceivingBXMoney), base.roundingMoney(waitBX));
		base.assertEqualsActualExpected(base.getElementTextWithWait(ReceivingLXMoney), base.roundingMoney(Double.parseDouble(waitLX)));
		base.assertEqualsActualExpected(base.getElementTextWithWait(ReceivingBJMoney), base.roundingMoney(Double.parseDouble(waitBJ)));
	}
	//��������ͼ���ϼ����ʾ
	public void moveToImgs(By by,String content){
		base.checkElementVisible(by);
		base.mouseToElement(by); base.sleep(2000);
		String id = base.getLnkElementText(by, "aria-describedby")+"-content";
		base.checkElementVisible(By.id(id));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.id(id)), content);
	}

	//����������˵�������(ÿ��5��ʱ��Ż���µ��ϸ��µ����ڣ�����1��5����ʾ���ϸ��µ�����)
	public void clickEBillLnk(){
		base.clickWithWait(EBillLnk);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, 1);//2015-11-01
		if(day>=1 && day<5){		
			calendar.add(Calendar.MONTH,-1);//2015-10-01			
		}
		calendar.add(Calendar.DAY_OF_MONTH, -1);//2015-09-30
		String end = df.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_MONTH, 1);//2015-09-01
		String begin = df.format(calendar.getTime());
		base.checkElmentText(EBillTime, begin+" 00:00 �� "+end+" 23:59");
		base.assertTrueByBoolean(base.getElementTextWithWait(SubTitle).contains("�����˵�"));
	}

	//����Ƿ����ϸ��µĵ����˵���Ϣ
	public boolean ifNoEBill(){
		if(base.getLnkElementText(EBillTxt, "class").equals("eleBill_noData")){//�����˵���������
			System.out.println("�����˵���������!");
			Reporter.log("<br/>�����˵���������!");
			return true;
		}else{
			return false;
		}
	}
	//�������˵�Ϊ�յ�����
	public void checkNoEBillData(Double balance){
		String yue = base.roundingMoney(balance);
		Calendar cal = Calendar.getInstance();	
		int day = cal.get(Calendar.DAY_OF_MONTH);System.out.println(day);
		if(day>=1 && day<5){	
			cal.add(Calendar.MONTH,-2);
		}else{
			cal.add(Calendar.MONTH,-1);
		}
		String month=String.valueOf(cal.get(Calendar.MONTH)+1);System.out.println(month);
		base.assertEqualsActualExpected(base.getElementTextWithWait(BalanceTxt), "�˻���"+yue+"Ԫ");
		base.assertEqualsActualExpected(base.getElementTextWithWait(NoRecordTipTxt),"��Ǹ��"+month+"�·ݻ�û�м�¼��ȥ������Ͷһ�ʰɣ�");
		base.assertEqualsActualExpected(base.getElementTextWithWait(GoInvestBtn), "ȥͶ��");
		base.assertEqualsActualExpected(base.getLnkElementText(GoInvestBtn, "href"), base.indexURL+"/new/loadAllTender.action");
	}
	//û�е����˵���Ϣʱ�����ȥͶ�ʡ���ť
	public void clickGoInvestBtn(){
		base.clickWithWait(GoInvestBtn);
		base.jumpToNewWindow();
//		base.checkTitle("����Ҫ������-������");
		base.checkElmentText(new InvestmentListPage().InvestmentListTxt, "Ͷ���б�");
		base.closeAndjumptoOldWindow();
	}
	//�ƶ���굽�����·������ܶ����ʾͼ��
	public void movetoTotalIncomeTip(){
		base.mouseToElement(TotalIncomeTipImg);
		base.checkElementVisible(TipTxt);
		base.assertEqualsActualExpected(base.getElementText(TipTxt), "����������");
	}
	//�������˵���Ϊ��ʱ�������ܶ����Ͷ���ܶ������ֵ�ܶ���������ܶ����
	public void checktopleftData(double LastMonthTX[],double amount[],double purchaseddebt[]){
		base.assertEqualsActualExpected(base.getElementTextWithWait(IncomeAmount), "��"+base.roundingMoney(amount[1]+amount[11]));
		base.assertEqualsActualExpected(base.getElementTextWithWait(InvestAmount), "��"+base.roundingMoney(purchaseddebt[1]+amount[5]));
//		base.assertEqualsActualExpected(base.getElementTextWithWait(InvestAmount), "��"+base.roundingMoney(amount[3]+amount[5]));
		base.assertEqualsActualExpected(base.getElementTextWithWait(RechargeAmount), "��"+base.roundingMoney(amount[9]));
		base.assertEqualsActualExpected(base.getElementTextWithWait(TXAmount), "��"+base.roundingMoney(LastMonthTX[1]));
	}
	//��顰�˻����������������
	public void checktoprightData(double freezemoney,String balance){
		DecimalFormat df = new DecimalFormat("###,##0.00");
//		if(balance.contains(",")){
			balance= balance.replaceAll(",", "");
//		}
		String remain = df.format(freezemoney+Double.parseDouble(balance));
		String freeze = df.format(freezemoney);
		if(base.getCurrentDay()<5){
			base.assertEqualsActualExpected(base.getElementTextWithWait(BalanceTxt), "���� "+base.getLastMonthDay(-2)+" 23:59");
		}else{
			base.assertEqualsActualExpected(base.getElementTextWithWait(BalanceTxt), "���� "+base.getLastMonthDay(-1)+" 23:59");
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(FreezeMoney), "��"+freeze);
		base.assertEqualsActualExpected(base.getElementTextWithWait(AccountBalanceTxt), "��"+remain);
	}
	//�������Ͷ������
	public void clickFuTouLnk(){
		base.clickWithWait(FuTouLnk);
		base.checkElementVisible(IncomeStatement);
		base.assertEqualsActualExpected(base.getElementText(IncomeStatement), "X\nͶ�������");
	}
	//��顰Ͷ��������е�����
	public void checkIncomeStatementData(String balance){
		String balanceDes = base.getElementTextWithWait(BalanceTxtinTable).replaceAll(",", "");
		base.assertEqualsActualExpected(base.getElementTextWithWait(BalanceTxtinTable), "���Ŀ������Ϊ"+balance.replaceAll(",", "")+",�����������ӵ�У�");
		double balance1 = Double.parseDouble(balanceDes.substring(balanceDes.indexOf("Ϊ")+1, balanceDes.lastIndexOf("��")));
		List<WebElement> titles = base.getElements(SubTitleinTable);
		String subtitle[] = {"����/����","15%","18%","20%","22%"};
		String money[][] ={{"1��","5��","10��","15��","20��","25��","30��"},{base.benxi(balance1, 0.15, 1),base.benxi(balance1, 0.15, 5),base.benxi(balance1, 0.15, 10),base.benxi(balance1, 0.15, 15),
		base.benxi(balance1, 0.15, 20),base.benxi(balance1, 0.15, 25),base.benxi(balance1, 0.15, 30)},{base.benxi(balance1, 0.18, 1),base.benxi(balance1, 0.18, 5),base.benxi(balance1, 0.18, 10),
		base.benxi(balance1, 0.18, 15),base.benxi(balance1, 0.18, 20),base.benxi(balance1, 0.18, 25),base.benxi(balance1, 0.18, 30)},{base.benxi(balance1, 0.20, 1),base.benxi(balance1, 0.20, 5),
		base.benxi(balance1, 0.20, 10),base.benxi(balance1, 0.20, 15),base.benxi(balance1, 0.20, 20),base.benxi(balance1, 0.20, 25),base.benxi(balance1, 0.20, 30)},{base.benxi(balance1, 0.22, 1),
		base.benxi(balance1, 0.22, 5),base.benxi(balance1, 0.22, 10),base.benxi(balance1, 0.22, 15),base.benxi(balance1, 0.22, 20),base.benxi(balance1, 0.22, 25),base.benxi(balance1, 0.22, 30)}};
		int size = titles.size();
		for(int i=1;i<=size;i++){
			base.assertEqualsActualExpected(titles.get(i-1).getText(), subtitle[i-1]);
			for(int j=2;j<=8;j++){
					base.assertEqualsActualExpected(base.getElementText(By.xpath("//div[@id='showincome1']/table/thead/tr["+j+"]/td["+i+"]")), money[i-1][j-2]);
			}
		}
	}
	
	//�رա�Ͷ�������
	public void closeIncomeTableLnk(){
		base.clickWithWait(CloseTableLnk);
		base.checkNoElement(CloseTableLnk);
	}
	//����ϸ����˵�����
	public void checkMiddleData(double overdue[],double SBamount[],double amount[],double LastMonthTX[],double purchaseddebt[]){
		base.assertEqualsActualExpected(base.getElementTextWithWait(NormalPayNum), (int)SBamount[0]+"��");
		base.assertEqualsActualExpected(base.getElementTextWithWait(NormalPayAmount), base.roundingMoney(SBamount[1]));
		base.assertEqualsActualExpected(base.getElementText(ReceivedOverdueNum), (int)SBamount[4]+"��");
		base.assertEqualsActualExpected(base.getElementText(ReceivedOverdueAmount), base.roundingMoney(SBamount[5]+SBamount[6]));
		base.assertEqualsActualExpected(base.getElementText(OverdueNum1), (int)(SBamount[2]+overdue[0])+"��");
		base.assertEqualsActualExpected(base.getElementText(OverdueAmount), base.roundingMoney(SBamount[3]+overdue[1]));
		base.assertEqualsActualExpected(base.getElementText(TransferNum), (int)amount[10]+"��");
		base.assertEqualsActualExpected(base.getElementText(TransferAmount), base.roundingMoney(amount[11]));
		base.assertEqualsActualExpected(base.getElementText(InvestSBNum), (int)amount[4]+"��");
		base.assertEqualsActualExpected(base.getElementText(InvestSBAmount), base.roundingMoney(amount[5]));
//		base.assertEqualsActualExpected(base.getElementText(BuyCreditNum), (int)amount[2]+"��");
//		base.assertEqualsActualExpected(base.getElementText(BuyCreditAmount), base.roundingMoney(amount[3]));
		base.assertEqualsActualExpected(base.getElementText(BuyCreditNum), (int)purchaseddebt[0]+"��");
		base.assertEqualsActualExpected(base.getElementText(BuyCreditAmount), base.roundingMoney(purchaseddebt[1]));
		base.assertEqualsActualExpected(base.getElementText(RechargeNum), (int)amount[8]+"��");
		base.assertEqualsActualExpected(base.getElementText(RechargeAmount1), base.roundingMoney(amount[9]));
		base.assertEqualsActualExpected(base.getElementText(FeeNum), (int)amount[6]+"��");
		base.assertEqualsActualExpected(base.getElementText(FeeAmount), base.roundingMoney(amount[7]));
		base.assertEqualsActualExpected(base.getElementText(WithdrawNum), (int)LastMonthTX[0]+"��");
		base.assertEqualsActualExpected(base.getElementText(WithdrawAmount), base.roundingMoney(LastMonthTX[1]));	
	}
	//�����������ġ��鿴����ť
	public void clickNormalPayViewLnk(){
		base.clickWithWait(NormalPayViewLnk);
		base.checkElementVisible(ExportRecordBtn);
		base.assertEqualsActualExpected(base.getLnkElementText(ExportRecordBtn,"value"), "���׼�¼���� ");
	}
	//��顰������������б�
	public void checkNormalPayData(double num,double Paymoney){
		DecimalFormat df = new DecimalFormat("###0.00");
		base.assertEqualsActualExpected(base.getElementTextWithWait(NormalPayTxt), "������������"+(int)num+"��,����"+df.format(Paymoney));
		base.assertEqualsActualExpectedByInt(base.getElements(PayLines).size(), (int) num);
		double amount=0;
		List<WebElement> money = base.getElements(DealAmount);
		for(int i=1;i<=num;i++){
			String money1 = money.get(i-1).getText();//18437.37
			amount= amount+Double.parseDouble(money1);
		}
		base.assertEqualsActualExpectedByDouble(amount, Paymoney);
		clickClosePlanLnk();
	}
	//��������׼�¼��������ť
	public void clickExportRecordBtn(){
		base.clickWithWait(ExportRecordBtn);
		base.sleep(5000);
	}
	//������ҵľٱ�������
	public void clickMyReportLnk(){
		base.clickWithWait(MyReportLnk);
		base.checkElmentText(SubTitle, "�ҵľٱ�");
		if(base.getElementTextWithWait(FirstLine).equals("�޾ٱ���¼��")){
			System.out.println("û���κεľٱ���Ϣ��");
		}else{
			base.assertTrueByBoolean(base.getElements(FirstLine).size()>0);
		}
	}
	//��������ٱ��ˡ�����
	public void clickReportedName(){
		base.clickWithWait(ReportedUser);
		base.jumpToNewWindow();
		base.checkTitleContains(PageTitles.xinYongPingJiaYe);
		base.closeAndjumptoOldWindow();
	}
	//��顰�ҵľٱ����е���Ϣ
	public void checkReportInformation(String username,String type,String des,String date){
		String report[] = {username,type,des,date,"","---"};
		List<WebElement> info =  base.getElements(FirstLineInfos);
		for(int i=0;i<6;i++){
			base.assertEqualsActualExpected(info.get(i).getText(), report[i]);
		}
	}
	//������ҵĺ�����������
	public int clickMyBlacklistLnk(){
		base.clickWithWait(MyBlacklistLnk);
		base.checkElmentText(SubTitle, "�ҵĺ�����");
		if(base.getElementTextWithWait(FirstLine1).equals("�޺�������¼��")){
			System.out.println("û���κεĺ�������Ϣ��");
			return 0;
		}else{
			int size = base.getElements(FirstLine1).size();
			base.assertTrueByBoolean(size>0);
			return size;
		}
	}
	//��顰�ҵĺ��������е���Ϣ
	public void checkBlacklistInfo(String username,String reason,String date){
		String blacklist[] = {"",username,reason,date,"ɾ��"};
		List<WebElement> info =  base.getElements(FirstLineInfos1);
		for(int i=0;i<5;i++){
			base.assertEqualsActualExpected(info.get(i).getText(), blacklist[i]);
		}
	}
	//������ҵĺ��������н��������
	public void clickBlacklistName(){
		base.clickWithWait(UserName);
		base.jumpToNewWindow();
		base.checkTitleContains(PageTitles.xinYongPingJiaYe);
		base.closeAndjumptoOldWindow();
	}
	//ѡ�С��ҵĺ��������е�һ��ǰ��ĸ�ѡ��
	public void checkFirstCheckbox(){
		base.clickWithWait(Checkbox);
		base.assertTrueByBoolean(base.getElementWithWait(Checkbox).isSelected());
	}
	//�����ɾ��������������
	public void clickDeleteBlacklistLnk(boolean acceptNextAlert){
		base.clickWithWait(DeleteLnk);
		base.assertEqualsActualExpected(base.getAlertwithWait().getText(), "��ȷ�������û������ĺ��������Ƴ���");
		if(acceptNextAlert){
			base.acceptAlert();
			base.checkAlertText("����Ϣɾ���ɹ���");
		}else{
			base.dismissAlert();
			base.checkElementVisible(SubTitle);
		}
	}
	//��֤ɾ��һ�����������¼Сʱ
	public void checkDeleteoneBlacklist(int num){
		int num1=0;
		if(base.getElementTextWithWait(FirstLine1).equals("�޺�������¼��")){
			System.out.println("û���κεĺ�������Ϣ��");
		}else{
			int size = base.getElements(FirstLine1).size();
			num1=size;
		}
		base.assertEqualsActualExpectedByInt(num1, num-1);
	}
	//�����ͬ��ԤͶ�ꡱ����
	public int clickLocalPreBidLnk(){
		base.clickWithWait(LocalPreBidLnk);
		base.checkElmentText(SubTitle, "ͬ��ԤͶ��");
		if(base.getElementTextWithWait(FirstLine).equals("���޿�Ͷ��")){
			return 0;
		}else{
			int size = base.getElements(FirstLine).size();
			base.assertTrueByBoolean(size>0);
			return size;
		}
	}
	//������ѽ����Ͷ�ʡ�
	public boolean clickClosedInvestLnk(){	
		base.clickWithWait(ClosedInvestLnk);
		if(base.getElementTextWithWait(BackingContent).equals("��Ŀǰ��û���ѽ����Ͷ�ʿ")){
			System.out.println("��Ŀǰ��û���ѽ����Ͷ�ʿ");
			Reporter.log("<br/>��Ŀǰ��û���ѽ����Ͷ�ʿ");
			return false;
		}else{
			base.assertTrueByBoolean(base.getElements(ClosedContent).size()>0);
			return true;
		}
	}
	//������ѽ����Ͷ�ʡ�������Ͷ�ʱ���
	public String clickClosedInvestTitle(){
		base.clickWithWait(BorrowTitle);
		base.checkElementVisible(PayPlanDetail);
		return base.getElementTextWithWait(FirstPhase).split("/")[1];
	}
	//���ѽ����Ͷ�ʡ��е�����鿴���ص��ӽ���������
	public void clickElectronicIOULnk(){
		base.clickWithWait(ViewElectronicIOULnk);
		base.jumpToNewWindow();
		base.checkTitle("���ӽ���");
	}
	//���ѽ����Ͷ�ʡ��е����������顱����
	public String[] clickLoanDetailLnk(){
		base.clickWithWait(LoanDetailLnk);
		base.jumpToNewWindow();
		String time = base.getElementTextWithWait(InvestmentDetailPage.BidFullTime);//2015-09-01
		String goal=base.getElementTextWithWait(InvestmentDetailPage.BorrowType);
		String type= goal.substring(goal.indexOf("��")+1,goal.indexOf("��"));
		String des = base.getElementTextWithWait(InvestmentDetailPage.BorrowDescription);
		String data[]={time,type,des};
		base.closeAndjumptoOldWindow();
		return data;
	}
	//����������е�Ͷ�ʡ�
	public void clickPaybackLnk(){
		base.clickElementNoWait(PaybackLnk);
		base.checkElmentText(BidStatusTxt, "����״̬");

	}
	//��ȡ�������е�Ͷ�ʡ��б��ҳ��
	public int getBackingPages(){
		if(base.getElementTextWithWait(BackingContent).equals("��Ŀǰ��û�л����е�Ͷ�ʿ")){
			return 0;
		}else{
			if(base.isElementEmpty(SixPageLnk)){
				return 1;
			}else{
				base.clickWithWait(LastPage);
				base.checkElementVisible(LastTwoPage);
				int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
				base.clickWithWait(FirstPage);
				base.checkElmentText(CurrentPage, "1");
				return lastPageNum;
			}
		}
	}
	
	//����������е�Ͷ�ʡ�
	public boolean clickJoiningInvestLnk(){
		base.clickWithWait(JoiningInvestLnk);
		if(base.isElementPresent(NoJoiningInvestTxt)){
			base.assertEqualsActualExpected(base.getElementText(NoJoiningInvestTxt), "��Ŀǰ��û�в����е�Ͷ�ʿ");
			return false;
		}else{
			base.assertTrueByBoolean(base.getElements(JoiningLines).size()>0);
			return true;
		}
	}
//	public double checkMoneyinBacking(){
//		int page = getBackingPages();
//		double receivingamout=0,receivingLX=0,receivingBJ=0;
//		if(page==0){
//			return 0;
//		}else{
//			for(int i=1;i<=page;i++){
//				
//				List<WebElement> investmoney =  base.getElements(InvestMoney);//�������
//				List<WebElement> rate =  base.getElements(Rate);//������
//				List<WebElement> receivingmoney =  base.getElements(ReceivingMoney);//���ս��
//				List<WebElement> title =  base.getElements(BackingTitle);//����
//				int num=receivingmoney.size();System.out.println(num);
//				for(int j=0;j<num;j++){
//					String money = receivingmoney.get(j).getText().substring(1);
//					receivingamout=receivingamout+Double.parseDouble(money);//���ձ�Ϣ
//					String investmoney1 = investmoney.get(j).getText().split("��")[1];
//					String ratenum = rate.get(j).getText().substring(5, rate.get(j).getText().length()-1);
//					String interests = base.roundingMoney(Double.parseDouble(investmoney1)*Double.parseDouble(ratenum)/12);
//					title.get(j).click();
//					base.checkElementVisible(PayPlanDetail);
//					List<WebElement> receivingbenxi =  base.getElements(ReceivingBXinTable);//δ�ձ�Ϣ
//					int size = receivingbenxi.size();
//					for(int k=0;k<size;k++){
//						String receivingBX1 = receivingbenxi.get(k).getText();
//						if(receivingBX1.equals(interests)){
//							receivingLX=receivingLX+Double.parseDouble(receivingBX1);
//						}else if(receivingBX1.equals(interests+investmoney1)){
//							receivingLX=receivingLX+Double.parseDouble(interests);
//							receivingBJ=receivingBJ+Double.parseDouble(investmoney1);
//						}else if(receivingBX1.equals(Double.parseDouble(investmoney1))){
//							
//						}
//					}				
//				}
//				base.clickWithWait(LastOnePage);
//			}
//			return receivingamout;
//		}
//	}
	//�����ѯ�Ŀ�ʼʱ��ͽ���ʱ��
	public void inputSearchDate(String startdate,String enddate){
		base.setDate("begindate", startdate);
		base.setDate("enddate", enddate);
	}
	//���������
	public void InputBorrower(String name){
		base.sendKeysWithWait(InputBorrower, name);
	}
	//�������ѯ����ť
	public void clickSearchBtn(){
		base.clickWithWait(SearchBtn);
		base.sleep(2000);
	}
	//������Ӧ�յ�Ͷ�ʡ����Ƿ�������
	public boolean ifExistInvest(){
		if(base.getElementTextWithWait(Content).equals("")){
			return false;
		}else{
			return true;
		}
	}

	public void clickClosePlanLnk(){
		base.clickWithWait(ClosePlanLnk);
		base.checkNoElement(ClosePlanLnk);
	}
	//����Ӧ�յ�Ͷ��
	public int getPagesNum(){
		if(base.getElementTextWithWait(Content).equals("")){
			return 0;
		}else{
			if(!base.isElementPresent(SixPageLnk)){
				return 1;
			}else{
				base.clickWithWait(LastPage);
				base.checkElementVisible(LastTwoPage);
				int lastPageNum = Integer.valueOf(base.getElementText(LastTwoPage));
				base.clickWithWait(FirstPage);
				base.checkElmentText(CurrentPage, "1");
				return lastPageNum;
			}
		}
	}
	//��ȡ�ϸ���׼ʱ����,����δ��,�������ջ�����ͱ���
	public double[] getAmountandNum(){
		int day = base.getCurrentDay();
		String begin,end,lastmonth;
		if(day<5){
			end = base.getLastMonthDay(-2);
			begin = base.getLastMonthDate(-3);
		}
		else{
			end = base.getLastMonthDay(-1);
			begin = base.getLastMonthDate(-2);
		}
		inputSearchDate(begin,end);	
		clickSearchBtn();
		clickSearchBtn();
		if(day<5){
			lastmonth=base.getMonthDate(-2);
		}else{
			lastmonth=base.getMonthDate(-1);
		}		
		int receivednum=0,receivingnum=0,receivedOverdueNum=0;
		double receivedmoney=0,payingOverdue=0,paidOverdue =0,fakuanmoney=0;
		int page = getPagesNum();
		if(page==0){
			double a[]= {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
			return a;
		}else{
			for(int p=1;p<=page;p++){
				List<WebElement> realpaytime = base.getElements(RealPayDate);
				List<WebElement> PlanLnk = base.getElements(PaymentPlanLnk);
				int size = realpaytime.size();
				for(int i=0;i<size;i++){
					if(realpaytime.get(i).getText().contains(lastmonth)){
//					if(realpaytime.get(i).getText().substring(0,7).equals(lastmonth)){
						PlanLnk.get(i).click();//������տ�ƻ������ӵ���"�տ�ƻ�"���鴰��
						base.checkElmentText(PaymentPlanTitle, "�տ�ƻ�");
						List<WebElement> realdate = base.getElements(RealDate);
						List<WebElement> status = base.getElements(StatusTxt);
						List<WebElement> received = base.getElements(ReceivedBX);
						List<WebElement> receiving = base.getElements(ReceivingBX);
						List<WebElement> fakuan = base.getElements(FaKuan);
						int num = realdate.size();
						for(int j=0;j<num;j++){
							String month = realdate.get(j).getText();
							if(month.contains(lastmonth) && status.get(j).getText().equals("׼ʱ�տ�")){
								receivednum=receivednum+1;
								String received1 =received.get(j).getText().substring(1);
//								if(received1.contains(",")){
									received1=received1.replaceAll(",", "");
//								}
								receivedmoney =receivedmoney+Double.parseDouble(received1);
							}else if(month.contains(lastmonth) && status.get(j).getText().equals("���ڴ���")){
								receivingnum=receivingnum+1;
								String receiving1 =receiving.get(j).getText().substring(1);
//								if(receiving1.contains(",")){
									receiving1=receiving1.replaceAll(",", "");
//								}
								payingOverdue=payingOverdue+Double.parseDouble(receiving1);
							}else if(month.contains(lastmonth) && status.get(j).getText().equals("�����տ�")){
								receivedOverdueNum=receivedOverdueNum+1;
								String received2 =received.get(j).getText().substring(1);
								String fakuan1 = fakuan.get(j).getText().substring(1);
//								if(received2.contains(",")){
									received2=received2.replaceAll(",", "");
//								}
//								if(fakuan1.contains(",")){
									fakuan1=fakuan1.replaceAll(",", "");
//								}
								paidOverdue =paidOverdue+Double.parseDouble(received2);
								fakuanmoney = fakuanmoney+Double.parseDouble(fakuan1);
							}
						}
						clickClosePlanLnk();
					}
				}	
				base.clickWithWait(LastOnePage);	
			}
			double data[]= {receivednum,receivedmoney,receivingnum,payingOverdue,receivedOverdueNum,paidOverdue,fakuanmoney};//׼ʱ�տ����,׼ʱ�տ���,����δ�ձ���������δ�ս��,�������ձ���,�������ս��,���ڷ�Ϣ
			return data;
		}
	}
	
	//�����һ��Ͷ���еġ�ծȨת�á�����
	public void clickCreditAssignLnk(){
		if(base.getElementWithWait(NoPaybackTxt).isDisplayed()){
			base.assertEqualsActualExpected(base.getElementText(NoPaybackTxt), "��Ŀǰ��û�л����е�Ͷ�ʿ");
		}else{
			base.clickWithWait(CreditAssignLnk);
			base.checkElmentText(PopCreditAssignTxt, "ծȨת��");
		}
	}
	//���롰ת��ԭ��
	public void InputAssignReason(){
		base.elementSendkey(InputAssignReason, "����ծȨת�ù����Ƿ���ȷ");
	}
	//ѡ��ת��ģʽ��һ�ڼۡ�
	public void chooseFixedPriceRadio(){
		base.clickElementNoWait(FixedPriceRadio);
	}
	//ѡ��ת��ģʽ��������
	public void chooseAuctionRadio(){
		base.clickElementNoWait(AuctionRadio);
	}
	//���롰֧�����롱
	public void InputPayPwd(){
		base.elementSendkey(InputPayPwd, "111111");
	}
	//�����ȷ������ť
	public void clickOKBtn(){
		base.clickElementNoWait(OKBtn);
	}
	
	/**
	 * ����Ԫ
	 * ���ͬ��ԤͶ��
	 */
	public void clickBit(){
		base.clickWithWait(By.cssSelector(".tb3>a"));
	}
	
	/**
	 * ����Ԫ
	 * �ж��Ƿ���ͬ��ԤͶ�� �еĻ������һ��
	 */
	public boolean ifHasSameCityBit(){
		List<WebElement> lists = base.getElements(By.cssSelector(".mt10.global_table a"));
		if (lists.size()==0) {
			Reporter.log("û��ͬ��ԤͶ��"+"<br/>");
		}else {
			lists.get(0).click();
		}
		return false;
	}
	
	/**
	 * ����������е�Ͷ�ʡ�
	 * @author ������
	 */
	public void clickRetrieve(){
		base.clickWithWait(retrieveTxt);
	}
	
	/**
	 * ��ȡɢ��Ͷ�������Ϣ��ֵ�����磺���ձ��𡢴�����Ϣ��
	 * @param infoName����Ϣ����
	 * @return ��Ϣ��ֵ
	 * @author ������ 2015-10-8
	 */
	public String getRetrieveInfoNum(String infoName){
		
		String value = null;
		if(infoName.equals("���ձ���")){
			value = base.getElementTextWithWait(waitPrincipalNumByLend);
		}
		else if(infoName.equals("������Ϣ")){
			value = base.getElementTextWithWait(waitInterestNumByLend);
		}
		value = base.stringToReplace(value, ",", "");
		value = value.trim();
		return value;
	}
	
}
