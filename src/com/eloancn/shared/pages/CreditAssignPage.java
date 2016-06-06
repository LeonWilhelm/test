package com.eloancn.shared.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eloancn.shared.common.Base;

/*
 * ���ҵ��˻���-��ծȨת�á�ҳ��
 */
public class CreditAssignPage {
	Base base = new Base();
	
	public static By CreditAssignTxt = By.cssSelector("h1.f-fc333");			//ծȨת���ӱ���
	By SelectedSubTab = By.cssSelector("span.wd140.current");
	public static By NoCreditTxt = By.cssSelector("div.global_tip.textC");					//û�п�ת����ծȨ
//	By CreditContent = By.cssSelector("#cred_tb>tbody");						//"��ת����ծȨ"����
	By CreditAssignLnk = By.xpath("//table[@id='cred_tb']/tbody/tr/td[8]/a");	//��ծȨת�á�����
	public static By FirstCredit = By.cssSelector("#cred_tb>tbody");
	By Credits = By.cssSelector("#cred_tb>tbody>tr");							//��ʾ����ծȨ��Ϣ
	By FirstCreditCheckbox = By.id("subcheck");									//��һ��ծȨ��ѡ��	
	By WaitBJ = By.xpath("//table[@id='cred_tb']/tbody/*/td[4]");			//���д��ձ�����
	By WaitPrincipal = By.xpath("//table[@id='cred_tb']/tbody/tr/td[4]");	//���ձ��������
	By WaitBX = By.xpath("//table[@id='cred_tb']/tbody/*/td[5]");			//���д��ձ�Ϣ���
	By BulkTransferBtn = By.cssSelector("div.btn1 > input[type=\"button\"]");	//����ת��
	
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
	
//	String WaitPrincipalNum = base.getElementText(WaitPrincipal);
	
	//ת����ծȨ
	By TransferDebtLnk = By.id("creditassignlist");
	By collectOverdueLnk = By.xpath("//ul[@id='assignbutton']/li[3]/a");//ϵͳ���ڻ���
	By SearchBtn = By.cssSelector("input.time_submit");
	By FirstTransferDebtTitle = By.cssSelector("#form1>table>tbody>tr>td");
	By SixPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");				//ҳ���ĵ�6������
	By LastPage = By.xpath("//div[@id='Pagination']/ul/li[text()='ĩҳ']");		//ĩҳ
	By LastOnePage = By.xpath("//div[@id='Pagination']/ul/li[text()='>']");		//ĩҳ��ǰһ������
	By LastTwoPage = By.xpath("//div[@id='Pagination']/ul/li[last()-2]");		//ĩҳ��ǰ��������(��������������)
	By FirstPage = By.xpath("//div[@id='Pagination']/ul/li[text()='��ҳ']");		//��ҳ
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");				//Ŀǰҳ
	By DealingAmount = By.xpath("//form[@id='form1']/table/tbody/*/td[3]");		//"ת����ծȨ"�б��еĳɽ����
	By TransferStatus = By.xpath("//form[@id='form1']/table/tbody/*/td[7]");	//"ת����ծȨ"�б��е�״̬
	By DetailActionLnk = By.xpath("//form[@id='form1']/table/tbody/*/td[8]/a[2]");//�������
	By TransferDetailTitle = By.cssSelector("div.tit");//ת������
	By PayDate= By.xpath("//div[@id='showincome1']/table/tbody/*/td[2]");//Ӧ�տ�����
	By ReceivingBX = By.xpath("//div[@id='showincome1']/table/tbody/*/td[5]");//������Ϣ
	By Status = By.xpath("//div[@id='showincome1']/table/tbody/*/td[6]/span");//״̬
	By closeDetailLnk = By.cssSelector("a.close");//�رա�ת�����顱����
	public static By WithDrawLnk = By.cssSelector("a.colorF8");//����
	By WithDrawTransferTitle = By.cssSelector("span.fl");//������
	By InputWithDrawPwd = By.id("paypassword");//
	
	//�ѹ����ծȨ
	By PurchasedDebtLnk = By.id("purchase");
	By PurchasedDebtContent = By.id("tabList0");
	By PurchasedMoney = By.xpath("//div[@id='tabList0']/table/tbody/*/td[2]");
	
	
	//�Ƿ��С���ת����ծȨ��
	public Boolean ifshowCredit(){
		if(base.getElementTextWithWait(FirstCredit).equals("")){
			return false;
		}else{
			return true;
		}
	}
	//�����һ����ծȨת�á�����
	public void clickCreditAssignLnk(){
			base.clickWithWait(CreditAssignLnk);
			base.checkElmentText(PopCreditAssignTxt, "ծȨת��");
	}
	//���롰ת��ԭ��
	public void InputAssignReason(){
		base.elementSendkey(InputAssignReason, "����ծȨת�ù����Ƿ���ȷ");
	}
	//ѡ��ת��ģʽ��һ�ڼۡ�
	public void chooseFixedPrice(){
		base.clickElementNoWait(FixedPriceRadio);
	}
	//ѡ��ת��ģʽ��������
	public void chooseAuction(){
		base.clickElementNoWait(AuctionRadio);
	}
	//ѡ��ת��ģʽ����ת��
	public void chooseSecretAssign(){
		base.clickElementNoWait(SecretAssignRadio);
	}	
	//ѡ����Чʱ�䡱
	public void selectRemainTime(String TimeTxt){
		base.elementSelectByVisibleText(SelectRemainTime, TimeTxt);
	}
	//���롰ת�õ׼ۡ�
	public void InputLowPrice(){
		String WaitPrincipal = base.getElementText(WaitPrincipalTxt);
		if(WaitPrincipal.contains(".")){
			WaitPrincipal = WaitPrincipal.split("\\.")[0];
		}
		base.elementSendkey(InputLowPrice, WaitPrincipal);
	}
	//���롰��ת�롱
	public void InputTransforCode(){
		base.elementSendkey(InputTransforCode, "4521");
	}
//	public void verifyWaitPrincipal(){
//		String num=base.getElementText(WaitPrincipalTxt);
//		String num1= base.getHideElementText(WaitPrincipal);
//		base.assertEqualsActualExpected(base.getHideElementText(WaitPrincipal), num);
//	}
	//���롰֧�����롱
	public void InputPayPwd(String pwd){
		base.elementSendkey(InputPayPwd, pwd);
	}
	//�����ȷ������ť
	public void clickOKBtn(){
		base.clickElementNoWait(OKBtn);
		if(base.getAlertwithWait().getText().equals("��ϲ��ծȨת����Ϣ�ѷ�����")){
			base.getAlert().accept();
		}else{
			base.assertEqualsActualExpected(base.getAlert().getText(), "����ת�óɹ�!");
			base.getAlert().accept();
		}
	}
	//�����ȡ������ť
	public void clickCancelBtn(){
		base.clickWithWait(CancelBtn);
	}
	//ѡ�е�һ��ծȯ
	public void checkFirstCredit(){		
			base.clickWithWait(FirstCreditCheckbox);
	}
	//���������ת�á���ť
	public void clickBulkTransferBtn(){
		base.clickWithWait(BulkTransferBtn);
	}
	//�����ת����ծȨ��
	public void clickTransferDebtLnk(){
		base.clickWithWait(TransferDebtLnk);
		base.checkElementVisible(FirstTransferDebtTitle);
	}
	//������ѹ����ծȨ��
	public void clickPurchasedDebtLnk(){
		base.clickWithWait(PurchasedDebtLnk);
		base.checkElmentText(SelectedSubTab, "�ѹ����ծȨ");
		base.checkElementsVisible(PurchasedDebtContent);
	}
	//�����ϵͳ���ڻ��ա�
	public void clickcollectOverdueLnk(){
		base.clickWithWait(collectOverdueLnk);
		base.checkElementVisible(FirstTransferDebtTitle);
	}
	//��á���ת����ծȨ����ҳ��
	public int getCreditNum(){
		if(base.getElementTextWithWait(FirstCredit).equals("")){
			return 0;
		}else{
			if(base.isElementEmpty(SixPageLnk)){
				return 1;
			}else{
				base.clickWithWait(LastPage);
				int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
				base.clickWithWait(FirstPage);
				base.checkElmentText(CurrentPage, "1");
				return lastPageNum;
			}
		}
	}
	//��������ء�
	public void clickWithDrawLnk(){
		base.clickElementNoWait(WithDrawLnk);
		base.checkElement(WithDrawTransferTitle);
	}
	//���롰ծȨת�ó��ء�����
	public void InputWithDrawPwd(){
		base.elementSendkey(InputWithDrawPwd, "111111");
	}
	//�����ծȨת�ó��ء�ȷ����ť
	public void clickWithdrawOkBtn(){
		base.clickElementNoWait(OKBtn);
		base.assertEqualsActualExpected(base.getAlert().getText(), "��ծȨת���ѳ��أ�");
		base.getAlert().accept();
	}
	//�����ѯ�Ŀ�ʼʱ��ͽ���ʱ��
	public void inputSearchDate(String startdate,String enddate){
		base.setDate("startdate", startdate);
		base.setDate("enddate", enddate);
	}
	//�������ѯ����ť
	public void clickSearchBtn(){
		base.clickWithWait(SearchBtn);
		base.sleep(2000);
	}
	public void clickCloseDetailLnk(){
		base.clickWithWait(closeDetailLnk);
		base.checkNoElement(closeDetailLnk);
	}
	public int getTransferedCreditNum(){
		if(base.getElementTextWithWait(FirstTransferDebtTitle).equals("��Ŀǰ��û�С�ת����ծȨ����")){
			return 0;
		}else{
			if(!base.isElementPresent(SixPageLnk)){
				return 1;
			}else{
				base.clickWithWait(LastPage);
				base.checkElementsVisible(LastTwoPage);
				int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
				base.clickWithWait(FirstPage);
				base.checkElmentText(CurrentPage, "1");
				return lastPageNum;
			}
		}
	}
	//��ȡ���ɹ����ծȨ����ҳ��
	public int getPurchasedDebtPages(){
		if(base.getElementTextWithWait(PurchasedDebtContent).equals("��Ŀǰ��û�С��ѹ����ծȨ����")){
			return 0;
		}else{
			base.clickWithWait(LastPage);
			base.checkElementsVisible(LastTwoPage);
			int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
			base.clickWithWait(FirstPage);
			base.checkElmentText(CurrentPage, "1");
			return lastPageNum;
		}
	}
	//��ȡ�ϸ��»����ϸ��¹���ծȨ���ܽ��ͱ���������ɢ��Ͷ��-�����˵���
	public double[] getPurchasedDebtMoneyandNum(){
		clickPurchasedDebtLnk();
		Calendar calendar = Calendar.getInstance();
		String begin= base.getLastMonthDate(-1),end= base.getLastMonthDay(-1);
		int day = calendar.get(Calendar.DAY_OF_MONTH);	
		if(day>=1 && day<5){	
			begin = base.getLastMonthDate(-2);
			end = base.getLastMonthDay(-2);
		}
		inputSearchDate(begin,end);		
		clickSearchBtn();
		clickSearchBtn();
		int purchasednum=0;
		double purchasedmoney=0;
		int page = getPurchasedDebtPages();
		if(page==0){
			double a[]={0,0};
			return a;
		}else{
			for(int i=1;i<=page;i++){
				base.checkElmentText(CurrentPage, String.valueOf(i));
				List<WebElement> money = base.getElements(PurchasedMoney);
				int size = money.size();
				for(int j=0;j<size;j++){
					String Money = money.get(j).getText();
					purchasedmoney=purchasedmoney+Double.parseDouble(Money);
				}
				purchasednum=purchasednum+size;
				base.clickWithWait(LastOnePage);
			}
		}System.out.println(purchasedmoney);
		double data[]={purchasednum,purchasedmoney};
		return data;
	}
	//��ȡ�ϸ���ծȨת�õ��ܽ��ͱ���
	public double[] getTransferAmountandNum(){
		clickTransferDebtLnk();
		String begin=base.getLastMonthDate(0);
		inputSearchDate(begin,base.dateFormat(base.getTime(), "yyyy-MM-dd"));
		clickSearchBtn();
		clickSearchBtn();
		int transfernum =0;
		double transferamount = 0;
		int page = getTransferedCreditNum();
		if(page==0){
			double a[]={0,0};
			return a;
		}else{
			for(int i=1;i<=page;i++){
				List<WebElement> status = base.getElements(TransferStatus);
				List<WebElement> amount = base.getElements(DealingAmount);
				int size = status.size();
				for(int j=0;j<size;j++){
					String status1 = status.get(j).getText();
					if(status1.equals("��ת��")||status1.equals("�����ѻ���")){
						transfernum =transfernum+1;
						String Amount = amount.get(j).getText();//22900.79
						transferamount=transferamount+Double.parseDouble(Amount);
					}
				}				
				base.clickWithWait(LastOnePage);	
			}
		}
		double data[] = {transfernum,transferamount};
		return data;
	}
	//��ȡ�ϸ��������ѻ���(ת����ծȨ��)���ܽ��ͱ���,����δ��
	public double[] collectedSBAmountandNum(){
		clickTransferDebtLnk();
		clickcollectOverdueLnk();
		String begin,end,lastmonth;
		int day=base.getCurrentDay();
		if(day<5){
			begin=base.getLastMonthDate(-1);//�ϸ��µĵ�һ��
			end = base.getLastMonthDay(-1);//�ϸ��µ����һ��
		}else{
			begin=base.getLastMonthDate(0);//����µĵ�һ��
			end = base.dateFormat(base.getTime(), "yyyy-MM-dd");//����µĵ���
		}
		inputSearchDate(begin,end);
		clickSearchBtn();
		clickSearchBtn();
		if(day<5){
			lastmonth=base.getMonthDate(-2);
		}else{
			lastmonth=base.getMonthDate(-1);
		}
		int overdueNum=0;
		double overdueAmount=0;
		int page = getTransferedCreditNum();
		if(page==0){
			double a[]={0,0};
			return a;
		}else{
			for(int i=1;i<=page;i++){
				List<WebElement> detail = base.getElements(DetailActionLnk);
				int size = detail.size();
				for(int j=0;j<size;j++){
					detail.get(j).click();
					base.checkElmentText(By.xpath("//div["+(4+j)+"]/div[2]/div"), "X\nת������");
					List<WebElement> Paydate = base.getElements(By.xpath("//div[@id='_content_child']/div["+(4+j)+"]/div[2]/div[2]/table/tbody/*/td[2]"));//Ӧ�տ�����
					List<WebElement> benxi = base.getElements(By.xpath("//div["+(4+j)+"]/div[2]/div[2]/table/tbody/*/td[5]"));
					List<WebElement> status = base.getElements(By.xpath("//div["+(4+j)+"]/div[2]/div[2]/table/tbody/*/td[6]/span"));
					int s = Paydate.size();
					for(int k=0;k<s;k++){
						if(Paydate.get(k).getText().contains(lastmonth)&&status.get(k).getText().equals("��ת��")){
							overdueNum= overdueNum+1;
							String benxi1 = benxi.get(k).getText();//2,033.33
//							if(benxi1.contains(",")){
							benxi1=benxi1.replaceAll(",", "");
//							}
							overdueAmount = overdueAmount+Double.parseDouble(benxi1);
						}
					}
					base.clickWithWait(By.xpath("//div["+(4+j)+"]/div[2]/div/a"));
					base.checkNoElement(By.xpath("//div["+(4+j)+"]/div[2]/div/a"));
				}
				base.clickWithWait(LastOnePage);	
			}
			double data[]={overdueNum,overdueAmount};
			return data;
		}	
	}
	//����Ƿ����ϵͳ���ڻ���
	public boolean ifExistCollect(){
		clickTransferDebtLnk();
		clickcollectOverdueLnk();
		if(base.getElementText(FirstTransferDebtTitle).equals("��Ŀǰ��û�С�ת����ծȨ����")){
			return false;
		}else{
			return true;
		}
	}
	
	//��ȡ�ܵô�����Ϣ�����ձ��𣬴��ձ�Ϣ
//	public double[] getReceivingData(){
//		int page= getCreditNum();
//		double receivingBJ=0,receivingBX=0;
//		if(page==0){
//			double a[]={0.00,0.00,0.00};
//			return a;
//		}else{
//			for(int i=1;i<=page;i++){
//				List<WebElement> credit = base.getElements(Credits);
//				int num = credit.size();
//				List<WebElement> bj = base.getElements(WaitBJ);//19524.42
//				List<WebElement> bx = base.getElements(WaitBX);
//				for(int j=0;j<num;j++){
//					receivingBJ=receivingBJ+Double.parseDouble(bj.get(j).getText());
//					receivingBX = receivingBX +Double.parseDouble(bx.get(j).getText());
//				}
//				base.clickWithWait(LastOnePage);	
//			}
//			double data[]= {receivingBX-receivingBJ,receivingBJ,receivingBX};
//			return data;
//		}				
//	}
}
