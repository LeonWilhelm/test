package com.eloancn.suites.credit;

import java.util.ArrayList;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.model.DWutGuaranteeModel;
import com.eloancn.shared.pages.*;

/*
 * �����Ǽƻ���P2����-����
 */
public class EStarPlan_P2 {

	Base base = new Base();
	Data data = new Data();
	
	LoginPage loginpage = new LoginPage();
	MyAccountPage myaccount = new MyAccountPage();
	MyDebitPlan mydebitplan = new MyDebitPlan();
	ElectronicIOU  ioupage = new ElectronicIOU();
	EStarPlanListPage ListPage = new EStarPlanListPage();
	EStarDetailPage DetailPage = new EStarDetailPage();
	CreditReferrerDetailPage ReferrerPage = new CreditReferrerDetailPage();
	EStarPlanLoanDetailPage loandetailpage = new EStarPlanLoanDetailPage();
	
	DWutGuaranteeModel baoZhengRenZrr;	//��Ȼ��
	DWutGuaranteeModel baoZhengRenFr;	//����
	
	private String UserName,Photo,Age;
	
	@BeforeClass
	public void setupBefore(){
		
		base.setup();//27��
		loginpage.loginByMyAccount(Data.tel_Loan, Data.password,"",Data.tel_Loan, Data.password,"");
		myaccount.clickAccountInfoLnk();
		base.checkElementVisible(AccountInfoPage.UserNameTxt);
		UserName = base.getElementTextWithWait(AccountInfoPage.UserNameTxt);	
		Photo = base.getLnkElementText(AccountInfoPage.photoPic, "src");
		myaccount.clickMyDebitPlanLnk();
		Age = mydebitplan.clickPerfectInfoLnk();
		baoZhengRenZrr = new DWutGuaranteeModel(data.getFullName(),data.idConcatenation(), "������", "������", data.phoneConcatenation(3), data.emailConcatenation(6, 2), "��Ȼ��");
		baoZhengRenFr  = new DWutGuaranteeModel(data.getFullName(), data.getFullName(), "������", data.phoneConcatenation(3), data.emailConcatenation(6, 2), "����");		
		mydebitplan.ApplyforQiYeLoan("10000", "��ҵ", "3����", "������ת", "�Զ�������ʹ��", data.phoneConcatenation(3), data.emailConcatenation(7, 2), baoZhengRenZrr, baoZhengRenFr);
		base.openBrowser(myaccount.MyAccountUrl);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(priority = 1) 
	//��顰���Ǽƻ���-���ҵĽ���ƻ���-����ҵ������ҳ���е��û�ͷ������������
	public void AccountInfoonBidDetail_web_573(){
		Reporter.log("��顰���Ǽƻ���-���ҵĽ���ƻ���-����ҵ������ҳ���е��û�ͷ������������");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickPublishingLoanLnk();
		if(mydebitplan.ifFirstBidisQiYeBid()){
			mydebitplan.clickLoanTitleLnk();
			loandetailpage.checkUserInfo(Photo,UserName,Age,1);
		}else{
			System.out.println("��һ�����겻����ҵ�꣡");
			Reporter.log("<br/>��һ�����겻����ҵ�꣡");
		}
	}
	
	@Test(priority = 2)
	//��顰���Ǽƻ���-���ҵĽ���ƻ���-����ҵ������ҳ���е���ҵ������Ϣ
	public void QYInfoonBidDetail_web_574(){
		Reporter.log("��顰���Ǽƻ���-���ҵĽ���ƻ���-����ҵ������ҳ���е���ҵ������Ϣ");
		if(loandetailpage.ifinLoanDetailPage()){
			loandetailpage.checkQiYeBasicInfo(1);
		}else{
			myaccount.clickMyDebitPlanLnk();
			mydebitplan.clickPublishingLoanLnk();
			if(mydebitplan.ifFirstBidisQiYeBid()){
				mydebitplan.clickLoanTitleLnk();
				loandetailpage.checkQiYeBasicInfo(2);
			}else{
				System.out.println("��һ�����겻����ҵ�꣡");
				Reporter.log("<br/>��һ�����겻����ҵ�꣡");
			}
		}
	}
	
	@Test(priority = 3)
	//��顰���Ǽƻ���-���ҵĽ���ƻ���-����ҵ������ҳ���еĻ�����Դ��ծȨ�Ƽ��ˡ�������ʩ/���
	public void QYOtherInfo_web_575(){
		Reporter.log("��顰���Ǽƻ���-���ҵĽ���ƻ���-����ҵ������ҳ���еĻ�����Դ��ծȨ�Ƽ��ˡ�������ʩ/���");
		if(loandetailpage.ifinLoanDetailPage()){
			loandetailpage.checkQiYeOtherInfo(1);
		}else{
			myaccount.clickMyDebitPlanLnk();
			mydebitplan.clickPublishingLoanLnk();
			if(mydebitplan.ifFirstBidisQiYeBid()){
				mydebitplan.clickLoanTitleLnk();
				loandetailpage.checkQiYeOtherInfo(2);
			}else{
				System.out.println("��һ�����겻����ҵ�꣡");
				Reporter.log("<br/>��һ�����겻����ҵ�꣡");
			}
		}
	}
	
	@Test(priority = 4) 
	//��顰���Ǽƻ���-���ҵĽ���ƻ���-����ҵ������ҳ���еĽ�����Ϣ(���õȼ�������Ҫ�޸�)
	public void LoanInfoonBidDetail_web_539(){
		Reporter.log("��顰���Ǽƻ���-���ҵĽ���ƻ���-����ҵ������ҳ���еĽ�����Ϣ");
		if(loandetailpage.ifinLoanDetailPage()){
			loandetailpage.checkBidInfo(1);
		}else{
			myaccount.clickMyDebitPlanLnk();
			mydebitplan.clickPublishingLoanLnk();
			if(mydebitplan.ifFirstBidisQiYeBid()){
				mydebitplan.clickLoanTitleLnk();
				loandetailpage.checkBidInfo(2);	
			}else{
				System.out.println("��һ�����겻����ҵ�꣡");
				Reporter.log("<br/>��һ�����겻����ҵ�꣡");
			}
		}
	}
	
	@Test(priority = 5) 
	//��顰�ҵ��˻���-���ҵĽ���ƻ�����ҳ����ʾ
	public void checkMyLoanPlanPage_web_58(){
		Reporter.log("��顰�ҵ��˻���-���ҵĽ���ƻ�����ҳ����ʾ");
		base.openBrowser(myaccount.MyAccountUrl);
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.checkDatainPage();
	}
	
	
	@Test(priority = 6) 
	//����ҵ��Ϣ����ҳ�桱-��ծȨ�Ƽ������ơ�--�������
	public void checkReferrerName_web_473(){
		Reporter.log("��顰��ҵ��Ϣ����ҳ�桱-��ծȨ�Ƽ������ơ����������");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickShenQingDaiKuan();
		mydebitplan.selectBorrowerType("��ҵ");
		mydebitplan.clickFillInQYInfoLnk();
		mydebitplan.checkQYReferrerName();
		mydebitplan.clickCancelBtn();
	}
	
	@Test(priority = 7) 
	//"��ҵ��Ϣ����ҳ��"-"ծȨ�Ƽ��˼��"--�������
	public void checkReferrerIntro_web_476(){
		Reporter.log("��顰��ҵ��Ϣ����ҳ�桱-��ծȨ�Ƽ��˼�顱���������");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickShenQingDaiKuan();
		mydebitplan.selectBorrowerType("��ҵ");
		mydebitplan.clickFillInQYInfoLnk();
		mydebitplan.checkQYReferrerIntro();
		mydebitplan.clickCancelBtn();
	}
	
	@Test(priority = 8) 
	//"��ҵ��Ϣ����ҳ��"-"ע����"--�������
	public void checkRegisteredAmount_web_481(){
		Reporter.log("��顰��ҵ��Ϣ����ҳ�桱-��ע������������");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickShenQingDaiKuan();
		mydebitplan.selectBorrowerType("��ҵ");
		mydebitplan.clickFillInQYInfoLnk();
		mydebitplan.checkQYRegisterAmount();
		mydebitplan.clickCancelBtn();
	}
	
	@Test(priority = 9) 
	//��顰�ҵĽ���ƻ���-����δ�����Ľ�-�б�ı���Ϣ
	public void checkPublishingLoanData_web_852(){
		Reporter.log("��顰�ҵĽ���ҳ�桱-����δ�����Ľ�-�б�ı���Ϣ");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickPublishingLoanLnk();
		mydebitplan.checkPublishingLoanData();
	}
	
	@Test(priority = 10) 
	//���ҵĽ���ƻ���-����δ�����Ľ�-Ԥ�����ܼ�Ԥ��ҳ����Ϣ
	public void checkPreviewfunction_web_334(){
		Reporter.log("��顰�ҵĽ���ҳ�桱-����δ�����Ľ�-Ԥ�����ܼ�Ԥ��ҳ����Ϣ");
		myaccount.clickMyDebitPlanLnk();
		mydebitplan.clickPublishingLoanLnk();
		mydebitplan.clickPreviewLnk();
		loandetailpage.checkUserInfo(Photo,UserName,Age,2);
		loandetailpage.checkBidInfo(2);
	}
	
	@Test(priority = 11) 
	//���ҵĽ���ƻ���-����δ�����Ľ�-��������
	public void checkPublishfunction_web_366(){
		if(base.indexURL.contains("client")){
			Reporter.log("��顰�ҵĽ���ҳ�桱-����δ�����Ľ�-��������");
			myaccount.clickMyDebitPlanLnk();
			mydebitplan.clickPublishedLoanLnk();
			int num1 = mydebitplan.getNumofAllLoan();
			mydebitplan.clickPublishingLoanLnk();
			int num2 = mydebitplan.getNumofAllLoan();
			mydebitplan.clickPublishLnk();
			mydebitplan.checkBorrowedInfo();
			mydebitplan.clickPublishBtn();
			mydebitplan.checkPublishedLoan(num1,num2);
		}
	}
	
	@Test(priority = 12) 
	//���ҵĽ���ƻ���-���ѷ����Ľ�-�б�ı���Ϣ
	public void checkPublishedLoanData_web_853(){
		if(base.indexURL.contains("client")){
			Reporter.log("��顰�ҵĽ���ҳ�桱-���ѷ����Ľ�-�б�ı���Ϣ");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickPublishedLoanLnk()){
				mydebitplan.checkPublishedLoanData();
			}else{
				System.out.println("û���ѷ����Ľ�");
				Reporter.log("<br/>û���ѷ����Ľ�");
			}
		}
	}
	
	@Test(priority = 13) 
	//���ҵĽ���ƻ���-���ѷ����Ľ�-������״̬
	public void checkPublishedAuditStatus_web_383(){
		if(base.indexURL.contains("client")){
			Reporter.log("���ҵĽ���ҳ�桱-���ѷ����Ľ�-���ǰ̨������״̬");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickPublishedLoanLnk()){
				mydebitplan.checkPublishedAuditStatus();
			}else{
				System.out.println("û���ѷ����Ľ�");
				Reporter.log("<br/>û���ѷ����Ľ�");
			}
		}
	}
	
	@Test(priority = 14) 
	//���ҵĽ���ƻ���-�����ڻ���Ľ�-�б�ı���Ϣ
	public void checkRepayingLoanData_web_877(){
		if(base.indexURL.contains("client")){
			Reporter.log("��顰�ҵĽ���ҳ�桱-�����ڻ���Ľ�-�б�ı���Ϣ");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayingLoanLnk()){
				String borrow[] = mydebitplan.clickLoanDetailLnk();
				mydebitplan.clickLoanPurpose();
				mydebitplan.checkRepayingLoanInfo(borrow);	//ʵ����Ϣ,δ������Ҫ����
			}else{
				System.out.println("û�����ڻ���Ľ�");
				Reporter.log("<br/>û�����ڻ���Ľ�");
			}
		}
	}
	
	@Test(priority = 15) 
	//���ҵĽ���ƻ���-�����ڻ���Ľ�-�б�Ĳ鿴���ص��ӽ���(���Ͷ���˶��ǵ���1�˻�)
	public void checkElectronicLoan_web_416(){
		if(base.indexURL.contains("client")){
			Reporter.log("��顰�ҵĽ���ҳ�桱-�����ڻ���Ľ�-�б�Ĳ鿴���ص��ӽ���");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayingLoanLnk()){
//				String name = base.getElementText(IndexPage.userName);
				String company = "��������";//��Ϊ���������ҵ���ƣ�������ѯ����Ӣ
				String id = base.getLnkElementText(mydebitplan.LoanDetailLnk,"href").split("=")[1];
				String data[] = mydebitplan.clickLoanDetailLnk();
				mydebitplan.clickRepayingIOULnk();
				ioupage.checkElectronicIOUInfo(company,data,UserName,id);
			}else{
				System.out.println("û�����ڻ���Ľ�");
				Reporter.log("<br/>û�����ڻ���Ľ�");
			}
		}
	}
	
	@Test(priority = 16) 
	//���ҵĽ���ƻ���-�����ڻ���Ľ�-�б�Ĳ鿴���ص��ӽ���-���سɹ�
	public void checkDownloadElectronicLoan_web_416(){
		if(base.indexURL.contains("client")){
			Reporter.log("��顰�ҵĽ���ҳ�桱-�����ڻ���Ľ�-�б�Ĳ鿴���ص��ӽ���-���سɹ�");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayingLoanLnk()){
				mydebitplan.clickRepayingIOULnk();
				ioupage.clickPDFLnk();
			}else{
				System.out.println("û�����ڻ���Ľ�");
				Reporter.log("<br/>û�����ڻ���Ľ�");
			}
		}
	}
	
	@Test(priority = 17) 
	//���ҵĽ���ƻ���-����ȫ������Ľ�-�б�ı���Ϣ
	public void checkRepayedLoanData_web_433(){
		if(base.indexURL.contains("client")){
			Reporter.log("��顰�ҵĽ���ҳ�桱-����ȫ������Ľ�-�б�ı���Ϣ");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayedLoanLnk()){
				mydebitplan.clickLoanPurpose();
				String time = mydebitplan.clickRepayedIOULnk();
				mydebitplan.checkRepayedLoanInfo(time);
			}else{
				System.out.println("û����ȫ������Ľ�");
				Reporter.log("<br/>û����ȫ������Ľ�");
			}
		}
	}
	
	@Test(priority = 18) 
	//���ҵĽ���ƻ���-����ȫ������Ľ�-�����б�
	public void checkRepayedList_web_882(){
		if(base.indexURL.contains("client")){
			Reporter.log("��顰�ҵĽ���ҳ�桱-����ȫ������Ľ�-�����б�");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayedLoanLnk()){
				String RepayTime = mydebitplan.clickLoanPurpose();
				String time = mydebitplan.clickRepayedIOULnk();
				mydebitplan.checkRepayList(RepayTime,time);
			}else{
				System.out.println("û����ȫ������Ľ�");
				Reporter.log("<br/>û����ȫ������Ľ�");
			}
		}
	}
	
	@Test(priority = 19) 
	//���ҵĽ���ƻ���-�����ڻ���Ľ�-������δ����ʱ
	public void checkOverdue_web_900(){
		if(base.indexURL.contains("client")){
			Reporter.log("��顰�ҵĽ���ҳ�桱-�����ڻ���Ľ�-������δ����ʱ������ʾ");
			myaccount.clickMyDebitPlanLnk();
			if(mydebitplan.clickRepayingLoanLnk()){
				if(mydebitplan.ifshowOverdueLoan()){
					mydebitplan.checkOverdue();
				}else{
					System.out.println("���ڻ���Ľ����û�����ڵĽ�");
					Reporter.log("<br/>���ڻ���Ľ����û�����ڵĽ�");
				}
			}else{
				System.out.println("û�����ڻ���Ľ�");
				Reporter.log("<br/>û�����ڻ���Ľ�");
			}
		}
	}
	
	@Test(priority = 20) 
	//Ͷ���б�-ծȨ�Ƽ�������ҳ-����������Ϣ������������
	public void checkLoanManageInfo_web_426(){
		Reporter.log("���Ͷ���б�-ծȨ�Ƽ�������ҳ-����������Ϣ������������");
		base.openBrowser(ListPage.EStarPlanUrl);
		if(ListPage.ifshowEStarPlan()){
			ListPage.clickFirstEStarTitle();
			DetailPage.clickCreditReferrerLnk();
			DetailPage.clickReferrerAddressLnk();
			ReferrerPage.checkLoanManageInfo();
		}else{
			System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
			Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
		}
	}
	
	@Test(priority = 21) 
	//Ͷ���б�-���Ǽƻ�Ͷ������ҳ-״̬ͼ��ʾ��Ͷ��ҳ��״̬һ��
	public void checkLoanManageInfo_web_427(){
		Reporter.log("���Ͷ���б�-ծȨ�Ƽ�������ҳ-״̬ͼ��ʾ��Ͷ��ҳ��״̬һ��");
		base.openBrowser(ListPage.EStarPlanUrl);
		ListPage.clickIcon(ListPage.compluteIcon, DetailPage.compluteIcon);
		ListPage.clickIcon(ListPage.endIcon, DetailPage.endIcon);
		ListPage.clickIcon(ListPage.goingIcon, DetailPage.goingIcon);
	}
	
	@Test(priority = 22) 
	//Ͷ���б�-���Ǽƻ�Ͷ������ҳ-���Ͷ���˴Ρ��ƻ��ܶ�ʲ���������ʾ
	public void checkInvestInfo_web_428(){
		Reporter.log("Ͷ���б�-ծȨ�Ƽ�������ҳ-���Ͷ���˴Ρ��ƻ��ܶ�ʲ���������ʾ");
		if(ListPage.ifshowEStarPlan()){
			String planmoney = base.getElementTextWithWait(ListPage.PlanMoney);
			ListPage.clickFirstEStarTitle();
			DetailPage.checkInvestInfo(planmoney);
		}else{
			System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
			Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
		}
	}
	
	@Test(priority = 23) 
	//Ͷ���б�-���Ǽƻ�Ͷ������ҳ-��鱣���ǡ�ļ�������ʡ�������ޡ����㷽ʽ���б�ҳ��ʾһ��
	public void checkBZStarLoanInfo_web_429(){
		Reporter.log("Ͷ���б�-ծȨ�Ƽ�������ҳ-��鱣���ǡ�ļ�������ʡ�������ޡ����㷽ʽ���б�ҳ��ʾһ��");
		base.openBrowser(ListPage.EStarPlanUrl);
		if(ListPage.ifshowEStarPlan()){
			ArrayList<String> BZInfo = ListPage.BZStarInfo();
			ListPage.clickFirstEStarTitle();
			DetailPage.checkBZStarLoanDetail(BZInfo);
		}else{
			System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
			Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
		}
	}
	
	@Test(priority = 24) 
	//Ͷ���б�-���Ǽƻ�Ͷ������ҳ-��鱣���ǡ��������
	public void checkBZStarDetailIntro_web_430(){
		Reporter.log("Ͷ���б�-ծȨ�Ƽ�������ҳ-��鱣���ǡ��������");
		if(DetailPage.ifinDetailPage()){
			DetailPage.checkBZStarDetailIntro(1);
		}else{	
			base.openBrowser(ListPage.EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.checkBZStarDetailIntro(2);
			}else{
				System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
				Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
			}
		}

	}
	
	@Test(priority = 25) 
	//Ͷ���б�-���Ǽƻ�Ͷ������ҳ-��������ǡ�ļ�������ʡ�������ޡ����㷽ʽ���б�ҳ��ʾһ��
	public void checkSYStarLoanInfo_web_434(){
		Reporter.log("Ͷ���б�-ծȨ�Ƽ�������ҳ-��������ǵ�ļ�������ʡ�������ޡ����㷽ʽ���б�ҳ��ʾһ��");
		base.openBrowser(ListPage.EStarPlanUrl);
		if(ListPage.ifshowEStarPlan()){
			ArrayList<String> SYInfo = ListPage.SYStarInfo();
			ListPage.clickFirstEStarTitle();
			DetailPage.checkSYStarLoanDetail(SYInfo);
		}else{
			System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
			Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
		}
	}
	
	@Test(priority = 26) 
	//Ͷ���б�-���Ǽƻ�Ͷ������ҳ-��������ǡ��������
	public void checkSYStarDetailIntro_web_436(){
		Reporter.log("Ͷ���б�-ծȨ�Ƽ�������ҳ-��������ǵ��������");
		if(DetailPage.ifinDetailPage()){
			DetailPage.checkSYStarDetailIntro(1);
		}else{
			base.openBrowser(ListPage.EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.checkSYStarDetailIntro(2);
			}else{
				System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
				Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
			}
		}
	}
	
	@Test(priority = 27) 
	//Ͷ���б�-���Ǽƻ�Ͷ������ҳ-�����ϸ�����е�������ʾ
	public void checkDetailedRulesData_web_439(){
		Reporter.log("Ͷ���б�-ծȨ�Ƽ�������ҳ-�����ϸ�����е�������ʾ");
		if(DetailPage.ifinDetailPage()){
			DetailPage.clickDetailedRulesLnk();
			DetailPage.checkDetailedRulesData(1);
		}else{
			base.openBrowser(ListPage.EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.checkDetailedRulesData(2);
			}else{
				System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
				Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
			}
		}
	}
	
	@Test(priority = 28, enabled = false) //��Ͷ�����ۡ���������ȥ��������������
	//Ͷ���б�-���Ǽƻ�Ͷ������ҳ-���δ��¼ʱͶ������
	public void checkComment_web_456(){
		Reporter.log("Ͷ���б�-ծȨ�Ƽ�������ҳ-���δ��¼ʱͶ������");
		base.logout();
		base.openBrowser(ListPage.EStarPlanUrl);
		if(ListPage.ifshowEStarPlan()){
			ListPage.clickFirstEStarTitle();
			DetailPage.clickInvestCommentLnk();
			DetailPage.checkCommentwithoutLogin();
		}else{
			System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
			Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
		}	
	}
	
	@Test(priority = 29, enabled = false)  //��Ͷ�����ۡ���������ȥ��������������
	//Ͷ���б�-���Ǽƻ�Ͷ������ҳ-����¼ʱͶ������
	public void checkCommentwithLogin_web_456(){
		Reporter.log("Ͷ���б�-ծȨ�Ƽ�������ҳ-����¼ʱͶ������");
		loginpage.loginByMyAccount(Data.tel_Loan, Data.password);
		if(DetailPage.ifinDetailPage()){
			DetailPage.clickInvestCommentLnk();
			DetailPage.checkCommentwithLogin(1);
		}else{
			base.openBrowser(ListPage.EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.clickInvestCommentLnk();
				DetailPage.checkCommentwithLogin(2);
			}
		}
	}

}
