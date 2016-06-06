package com.eloancn.suites.debit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ClientBackPage;
import com.eloancn.shared.pages.InvestmentDetailPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyLoanPage;
/**
 * ����Ҫ����Ľ���ʱ���ã�����Ҫÿ��ִ��
 */
public class Debit_P2_2{

	Base base = new Base();
	DBData dbdata = new DBData();
	MyAccountPage myAccountPage = new MyAccountPage();
	LoginPage loginpage = new LoginPage();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	MyLoanPage myloanpage = new MyLoanPage();
	InvestmentListPage investlistpage = new InvestmentListPage();
	InvestmentDetailPage investdetailpage = new InvestmentDetailPage();
	ClientBackPage backpage = new ClientBackPage();
	String tenderid="";
	String UserID="";
	String blx="��ũ��";
	public String borrowtype="fx";

	@AfterClass	
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test (priority = 1)
	//��������ܲ�����ͨ��
	public void PassFirstAudit(){
		if(base.indexURL.contains("client")){
			base.setup_ff();
			base.drivermanage();
			loginpage.loginByMyAccount(Data.tel_Loan, Data.password);
			base.openBrowser(myAccountPage.MyAccountUrl);
			UserID=myAccountPage.getUserID();
			myAccountPage.turnToMyAccount("������");
			String LoanPurpose=loanApplicationPage.loanApplication(false, false, blx, "500", "3����","","5", "7", "����", borrowtype, "��������", "�Զ�"+base.RandomNumber(), "�Զ��������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			tenderid= myloanpage.getTenderId(LoanPurpose);
			myloanpage.UpdateTenderStatuswithSQL(tenderid,"1");
		}
	}
		
	@Test (priority =2,dependsOnMethods={"PassFirstAudit"})
	//һ���û�Ͷ����
	public void InvestSB(){
		if(base.indexURL.contains("client")){
			base.logout();
			base.openBrowser(investlistpage.Url);
			String paypwd=loginpage.login("13581838712","111111","111111", Data.tel_Invest, Data.test_password, Data.tel_Invest_PayPwd);
			investlistpage.clickInvestmentDataTitleById(tenderid);
			base.turnToNewPage();
			investdetailpage.clickInvestLnk();
			investdetailpage.clickAutoInputLnk();
			investdetailpage.InputPayPwd(paypwd);
			investdetailpage.InputValidateCode();
			investdetailpage.clickOKBtn();
			investdetailpage.checkInvestSuccess();		
		}
	}
	
	@Test (priority =3,dependsOnMethods={"InvestSB"})
	//�û�ȷ�Ͻ��
	public void ConfirmBorrow(){
		if(base.indexURL.contains("client")){
			base.logout();
			loginpage.loginByMyAccount(Data.tel_Loan, Data.password);
			myloanpage.OpenMobilePaywithSQL(UserID);
			myloanpage.ConfirmVideowithSQL(UserID,tenderid);
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickPublishedTab();
			myloanpage.clickSureDebitBtn(tenderid);
			myloanpage.agree();
			base.tearDown();
		}
	}
	
	@Test (priority =4,dependsOnMethods={"ConfirmBorrow"})
	//�ܲ�����ͨ��(����ͨ�������ݿ�״̬ʵ�֣�����ͨ����̨����)
	public void PassFinalAudit(){
		if(base.indexURL.contains("client")){			
			base.setup_ie();
			base.drivermanage();
			backpage.backLogin(base.clientBackURL, Data.noticeCode, "lj1", "eloancn888");
			backpage.clickFirstMenu("��ع���");
			backpage.clickSubMenu("���������б�");
			backpage.FinalAudit(tenderid);
			base.tearDown();
		}
	}
	
}
