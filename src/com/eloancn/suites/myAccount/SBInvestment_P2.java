package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.CreditAssignPage;
import com.eloancn.shared.pages.ElectronicIOU;
import com.eloancn.shared.pages.InvestmentDetailPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.SBInvestPage;
import com.eloancn.shared.pages.TransactionRecordPage;
/*
 * �ҵ��˻�-ɢ��Ͷ��
 */
public class SBInvestment_P2{
	Base base = new Base();
	LoginPage loginpage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	SBInvestPage sbinvestpage = new SBInvestPage();
	TransactionRecordPage recordpage = new TransactionRecordPage();
	CreditAssignPage creditassignpage = new CreditAssignPage();
	InvestmentDetailPage investDetailPage = new InvestmentDetailPage();
	InvestmentListPage investListPage = new InvestmentListPage();
	ElectronicIOU  ioupage = new ElectronicIOU();

	@BeforeClass
	public void setupBefore(){
		base.setup();
		loginpage.loginByMyAccount(Data.tel_Loan, Data.password);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test (priority = 1)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�������˵�Ϊ�յ�����
//��Ҫ�˻��ĵ����˵�Ϊ��(�˻���Ͷɢ��)	
	public void checkEmptyEBill_3925(){
		Reporter.log("-����ҵ��˻�-�ҵĴ���-ɢ��Ͷ���е����˵�Ϊ�յ�����<br/>");
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickEBillLnk();
		if(sbinvestpage.ifNoEBill()){
			myAccountPage.clickMyAccountLink();
			double balance = myAccountPage.getBalance()+myAccountPage.getAllFrozenMoney();
			myAccountPage.clickSBInvestLnk();
			sbinvestpage.clickEBillLnk();
			sbinvestpage.checkNoEBillData(balance);
			sbinvestpage.clickGoInvestBtn();
		}
	}

	@Test (priority = 2)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�������˵���Ϊ��ʱ���Ϸ��ϸ������롢Ͷ�ʡ���ֵ����������
//��Ҫ�˻��ĵ����˵���Ϊ�գ��˻�Ͷ��ɢ�꣩	
	public void checktopleftDataonEBill_3926(){
		Reporter.log("����ҵ��˻�-�ҵĴ���-ɢ��Ͷ���е����˵���Ϊ��ʱ�����Ϸ��ϸ������롢Ͷ�ʡ���ֵ����������<br/>");
		base.logout();
//		loginpage.login(Data.tel_Invest, Data.password,"",Data.tel_Invest, Data.password,"");
		loginpage.login("13581838710","111111", "111111", "18880000198","111111", "");//13581838712 ����
		myAccountPage.clickMyAccountLink();
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickEBillLnk();
		if(!sbinvestpage.ifNoEBill()){
			myAccountPage.clickMyAccountLink();
			double LastMonthTX[] = myAccountPage.getLastMonthFreezeMoney();
			myAccountPage.clickTransactionRecord();
			double[] amount=recordpage.checkMoney();
			myAccountPage.clickCreditAssignLnk();
			double purchaseddebt[]= creditassignpage.getPurchasedDebtMoneyandNum();
			myAccountPage.clickSBInvestLnk();
			sbinvestpage.clickEBillLnk();
			sbinvestpage.movetoTotalIncomeTip();
			sbinvestpage.checktopleftData(LastMonthTX,amount,purchaseddebt);
		}else{
			Reporter.log("ɢ��Ͷ���е����˵�Ϊ�գ�<br/>");
		}
	}
	
	@Test (priority = 3)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�������˵���Ϊ��ʱ���Ϸ��˻�������������
//��Ҫ�˻��ĵ����˵���Ϊ��
	public void checktoprightDataonEBill_3927(){
		Reporter.log("����ҵ��˻�-�ҵĴ���-ɢ��Ͷ���е����˵���Ϊ��ʱ�����Ϸ��˻�������������<br/>");
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickEBillLnk();
		if(!sbinvestpage.ifNoEBill()){
			myAccountPage.clickMyAccountLink();
			double freezemoney=myAccountPage.getFreezeMoneyUntilLastMonth();
			myAccountPage.clickTransactionRecord();
			String balance =recordpage.checkRemainBalance();
			myAccountPage.clickSBInvestLnk();
			sbinvestpage.clickEBillLnk();			
			sbinvestpage.checktoprightData(freezemoney,balance);
			sbinvestpage.clickFuTouLnk();
			sbinvestpage.checkIncomeStatementData(balance);
			sbinvestpage.closeIncomeTableLnk();
		}
	}
	
	@Test (priority = 4)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�������˵���Ϊ��ʱ�ϸ����˵����������
//��Ҫ�˻��ĵ����˵���Ϊ��	
	public void checkMiddleDataonEBill_3928(){
		Reporter.log("����ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�����˵���Ϊ��ʱ,�ϸ����˵����������<br/>");
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickEBillLnk();
		if(!sbinvestpage.ifNoEBill()){
			myAccountPage.clickMyAccountLink();
			double LastMonthTX[] = myAccountPage.getLastMonthFreezeMoney();
			myAccountPage.clickTransactionRecord();
			double[] amount=recordpage.checkMoney();
			myAccountPage.clickCreditAssignLnk();
			double overdue[]=creditassignpage.collectedSBAmountandNum();
			double purchaseddebt[]= creditassignpage.getPurchasedDebtMoneyandNum();
			myAccountPage.clickSBInvestLnk();
			double SBamount[]=sbinvestpage.getAmountandNum();
			sbinvestpage.clickEBillLnk();
			sbinvestpage.checkMiddleData(overdue,SBamount,amount,LastMonthTX,purchaseddebt);
			sbinvestpage.clickNormalPayViewLnk();
			sbinvestpage.checkNormalPayData(SBamount[0],SBamount[1]);
		}
	}
	
	@Test (priority = 5)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ҵľٱ�-���ȡ���ٱ���رվٱ�����
	public void checkCancelReport_3930(){
		Reporter.log("����ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ҵľٱ���ȡ���ٱ���رվٱ�����<br/>");
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickMyReportLnk();
		base.openBrowser(investListPage.Url);
		if(investListPage.ifExistSB()){
			investListPage.clickFirstTitle();
			investDetailPage.clickReportLnk();
			investDetailPage.clickCancelReportBtn();
		}
	}
	
	@Test (priority = 6)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ҵľٱ�-���ɹ��ٱ�
	public void checkReportSuccess_3930(){
		Reporter.log("�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ҵľٱ�-���ɹ��ٱ�<br/>");
		if(base.indexURL.contains("client")){
			base.openBrowser(investListPage.Url);
			if(investListPage.ifExistSB()){
				String username=investListPage.clickFirstTitle();
				investDetailPage.clickReportLnk();
				String type=investDetailPage.selectReportType("���ɴ����������Ϣ");
				String des=investDetailPage.inputDescription();
				String date=investDetailPage.clickOKReportBtn();
				if(date!=null){
					base.openBrowser(myAccountPage.MyAccountUrl);
					myAccountPage.clickSBInvestLnk();
					sbinvestpage.clickMyReportLnk();
					sbinvestpage.checkReportInformation(username,type,des,date);
					sbinvestpage.clickReportedName();
				}
			}
		}
	}
	
	@Test (priority = 7)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ҵĺ�����-���ȡ�������������رռ������������
//��Ҫ�ҵĺ�����Ϊ��	
	public void checkCancelJoinBlacklist_3931(){
		Reporter.log("�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ҵĺ�����-���ȡ�������������رռ������������<br/>");
		base.openBrowser(myAccountPage.MyAccountUrl);
		myAccountPage.clickSBInvestLnk();
		sbinvestpage.clickMyBlacklistLnk();
		base.openBrowser(investListPage.Url);
		if(investListPage.ifExistSB()){
			investListPage.clickFirstTitle();
			investDetailPage.clickJoinBlacklistLnk();
			investDetailPage.clickCancelJoinBlacklistBtn();
		}	
	}

	@Test (priority = 8)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ҵĺ�����-���ȡ��ȷ�ϼ���������ͳɹ�ȷ�ϼ��������
	public void checkConfirmJoinBlacklist_3931(){
		base.openBrowser(investListPage.Url);
		if(investListPage.ifExistSB()){
			String username=investListPage.clickFirstTitle();
			investDetailPage.clickJoinBlacklistLnk();
			String reason=investDetailPage.InputSetReason();
			investDetailPage.clickOkJoinBlacklistBtn(false);
			String date=investDetailPage.clickOkJoinBlacklistBtn(true);
			if(date!=null){
				base.openBrowser(myAccountPage.MyAccountUrl);
				myAccountPage.clickSBInvestLnk();
				sbinvestpage.clickMyBlacklistLnk();
				sbinvestpage.checkBlacklistInfo(username,reason,date);
				sbinvestpage.clickBlacklistName();
			}
		}
	}	
	
	@Test (priority = 9)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ҵĺ�����-���ȡ��ɾ���������ͳɹ�ɾ��������
	public void checkConfirmDeleteBlacklist_3931(){	
		Reporter.log("�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ҵĺ�����-���ȡ��ɾ���������ͳɹ�ɾ��������<br/>");
		myAccountPage.clickSBInvestLnk();
		int num=sbinvestpage.clickMyBlacklistLnk();
		sbinvestpage.checkFirstCheckbox();
		sbinvestpage.clickDeleteBlacklistLnk(false);
		sbinvestpage.clickDeleteBlacklistLnk(true);
		sbinvestpage.checkDeleteoneBlacklist(num);
	}
	
	@Test (priority = 10,enabled = false)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-���ͬ��ԤͶ��
	public void checkLocalPreBid_3932(){
		Reporter.log("�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-���ͬ��ԤͶ��<br/>");
		myAccountPage.clickSBInvestLnk();
		int num=sbinvestpage.clickLocalPreBidLnk();		
		base.assertTrueByBoolean(num==0);
	}
	
	@Test (priority = 10)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-������Ϸ����ݴ��ձ�Ϣ,��Ϣ,�������ʾ
	public void checkTopLeftData_3933(){
		Reporter.log("�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-������Ϸ����ݴ��ձ�Ϣ,��Ϣ,�������ʾ<br/>");
		myAccountPage.clickCreditAssignLnk();
		boolean collect=creditassignpage.ifExistCollect();
		myAccountPage.clickSBInvestLnk();		
		sbinvestpage.CheckTopLeftData(collect);
	}

	@Test (priority = 11)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ѽ����Ͷ��-�����ӽ�����Ϣ
//��Ҫ�ѽ����Ͷ���в�Ϊ��	
	public void checkClosedInvest_3937(){
		Reporter.log("�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ѽ����Ͷ��-�����ӽ�����Ϣ<br/>");
		base.openBrowser(myAccountPage.MyAccountUrl);
		myAccountPage.clickSBInvestLnk();		
		if(sbinvestpage.clickClosedInvestLnk()){
			String phase=sbinvestpage.clickClosedInvestTitle();
			String title = base.getElementTextWithWait(sbinvestpage.BorrowTitle);
			String Borrower = base.getElementText(sbinvestpage.FirstBorrower);
			String rate = base.getElementText(sbinvestpage.FirstRate).split(": ")[1];
			String data[] = sbinvestpage.clickLoanDetailLnk();
			sbinvestpage.clickElectronicIOULnk();
			ioupage.checkElectronicIOUInfoforInvest(data,Borrower,phase,rate,title);
		}
	}
	
	@Test (priority = 12)
	//�ҵ��˻�-�ҵĴ���-ɢ��Ͷ��-�ѽ����Ͷ��-������ص��ӽ����ɹ�
	public void checkDownloadIOU_3937(){
		base.openBrowser(myAccountPage.MyAccountUrl);
		myAccountPage.clickSBInvestLnk();	
		if(sbinvestpage.clickClosedInvestLnk()){
			sbinvestpage.clickElectronicIOULnk();
			ioupage.clickPDFLnk();
		}
	}		

}
