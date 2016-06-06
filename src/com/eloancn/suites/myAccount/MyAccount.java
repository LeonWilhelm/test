package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.*;
import com.eloancn.shared.pages.*;
/*
 * ���ҵ��˻�������-����
 */
public class MyAccount {

	Base base = new Base();
	LoginPage loginpage = new LoginPage();
	MyAccountPage myaccount = new MyAccountPage();
	IndexPage indexpage = new IndexPage();
	AutoBidPage autobid = new AutoBidPage();
	CreditAssignPage creditassign = new CreditAssignPage();
	SBInvestPage SBInvest = new SBInvestPage();
	private String MemberAPayPwd;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(myaccount.MyAccountUrl);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}	
	
	@Test(priority = 1) 
	//��顰�ҵ��˻���ҳ�������
	public void verifyDatainMyAccount_AT_520(){
		Reporter.log("�˻����� ҳ��������ʾ��ȷ");
		MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		myaccount.verifyLeftnavigationData();
		myaccount.verifyMyAccountData();		
	}
	
	@Test(priority = 2) 
  	//��顰��ֵ��,�����֡���ť������
    public void verifyCashLnk_AT_520(){
		Reporter.log("�˻�����ҳ�� ��ֵ���������ӵ���ȷҳ��");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
		myaccount.clickAccountOverviewLnk();
    	myaccount.clickFreezeStatisticsImg();
    	myaccount.clickCloseFreezeLnk();
		myaccount.clickRechargeBtn();
		myaccount.clickAccountOverviewLnk();
		myaccount.clickWithDrawBtn();
    }
    
    @Test(priority = 3) 
    //��顰�ҵĽ��롱�е�����
    public void verifyMyLoanLnk_AT_520(){
    	Reporter.log("�˻�����ҳ�� ��������ҵĽ�����ӵ���ȷҳ��");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
    	myaccount.clickAccountOverviewLnk();
    	myaccount.clickLoanApplicationLnk();
    	myaccount.clickAccountOverviewLnk();
    	myaccount.clickMyLoanLnk();
    }
     
    @Test(priority = 4) 
    //ծȨ��ת
    public void SecretAssignDebt_AT_526(){
    	Reporter.log("�ҵ��˻�-ծȨת��-��ת����ծȨ-��תģʽת��ծȨ�ɹ�");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
    	myaccount.clickCreditAssignLnk();
    	if(!creditassign.ifshowCredit()){
    		System.out.println("�л��˻��鿴�Ƿ���ڿ�ת����ծȨ��");
    		Reporter.log("<br/>�л��˻��鿴�Ƿ���ڿ�ת����ծȨ��");
    		base.logout();
    		loginpage.loginByMyAccount(Data.tel_run_zhaiquan2,Data.password, Data.zzmm,Data.test4_tel,Data.test4_password,Data.test4_zzmm);
    		myaccount.clickCreditAssignLnk();
    	}   	
    	if(creditassign.ifshowCredit()){
    		creditassign.clickCreditAssignLnk();
    		creditassign.InputAssignReason();
    		creditassign.chooseSecretAssign();
    		creditassign.InputTransforCode();
    		creditassign.InputPayPwd(MemberAPayPwd);
    		creditassign.clickOKBtn();
    	}else{
    		System.out.println("û�п�ת����ծȨ�����Բ�����ת��");
    		Reporter.log("<br/>û�п�ת����ծȨ�����Բ�����ת��");
    	}
    }
    
    @Test(priority = 5) 
    //ծȨһ�ڼ�ת��
    public void APriceAssignDebt_AT_523(){
    	Reporter.log("�ҵ��˻�-ծȨת��-��ת����ծȨ-һ�ڼ�ģʽת��ծȨ�ɹ�");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
    	myaccount.clickCreditAssignLnk();
    	if(creditassign.ifshowCredit()){
        	creditassign.clickCreditAssignLnk();
        	creditassign.InputAssignReason();
        	creditassign.chooseFixedPrice();
        	creditassign.selectRemainTime("1��");
        	creditassign.InputPayPwd(MemberAPayPwd);
        	creditassign.clickOKBtn();
    	}else{
    		System.out.println("û�п�ת����ծȨ�����Բ���һ�ڼ�ת�ã�");
    		Reporter.log("<br/>û�п�ת����ծȨ�����Բ���һ�ڼ�ת�ã�");
    	}
    }  

    @Test(priority = 6) 
    //ծȨ����ת��
    public void AuctionAssignDebt_AT_524(){
    	Reporter.log("�ҵ��˻�-ծȨת��-��ת����ծȨ-����ģʽת��ծȨ�ɹ�");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
    	myaccount.clickCreditAssignLnk();
    	if(creditassign.ifshowCredit()){
    		creditassign.clickCreditAssignLnk();
    		creditassign.InputAssignReason();
    		creditassign.chooseAuction();
    		creditassign.selectRemainTime("1��");
    		creditassign.InputLowPrice();
    		creditassign.InputPayPwd(MemberAPayPwd);
    		creditassign.clickOKBtn();
    	}else{
    		System.out.println("û�п�ת����ծȨ�����Բ���������");
    		Reporter.log("<br/>û�п�ת����ծȨ�����Բ���������");
    	}
    }  
    
    @Test(priority = 7) 
    //ծȨ-����ת��
    public void BulkTransferDebt_AT_528(){
    	Reporter.log("�ҵ��˻�-ծȨת��-��ת����ծȨ-����ת��ģʽת��ծȨ�ɹ�");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
    	myaccount.clickCreditAssignLnk();
    	if(creditassign.ifshowCredit()){
    		creditassign.checkFirstCredit();
    		creditassign.clickBulkTransferBtn();
    		creditassign.InputAssignReason();
    		creditassign.InputPayPwd(MemberAPayPwd);
    		creditassign.clickOKBtn();
    	}else{
    		System.out.println("û�п�ת����ծȨ�����Բ�������ת�ã�");
    		Reporter.log("<br/>û�п�ת����ծȨ�����Բ�������ת�ã�");
    	}
    }   
	    
	 @Test(priority = 8) 
	 //�Զ�Ͷ��-�̶�Ͷ��
	 public void FixedAmountBid_AT_522(){
	 	Reporter.log("�ҵ��˻�-�Զ�Ͷ��-�̶�Ͷ��ɹ�-��֤����");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
	 	myaccount.clickAutoBidLnk();
	 	if(autobid.ifshowAutoBidSetLnk()){
	 		autobid.clickAutoBidBtn();
	 		autobid.checkFixedAmountBid(MemberAPayPwd);
	 	}else{
	 		System.out.println("�̶�Ͷ���Ȩ�޲�����");
	 		Reporter.log("<br/>�̶�Ͷ���Ȩ�޲�����");
	 	}
	 }
	
	 @Test(priority = 9) 
	 //�Զ�Ͷ��-���Ͷ��
	 public void BalanceBid_AT_521(){
	 	Reporter.log("�ҵ��˻�-�Զ�Ͷ��-���Ͷ��ɹ�-��֤����");
		if(!loginpage.ifMyAccountLogin()){
			MemberAPayPwd = loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
	 	myaccount.clickAutoBidLnk();
	 	if(autobid.ifshowAutoBidSetLnk()){
	 		autobid.clickAutoBidBtn();
	 		autobid.checkBalanceBid(MemberAPayPwd);
	 	}else{
	 		System.out.println("���Ͷ���Ȩ�޲�����");
	 		Reporter.log("<br/>���Ͷ���Ȩ�޲�����");
	 	}   	
	 }
	 
	 @Test(priority = 10)
	 //�ر��Զ�Ͷ��
	 public void CloseAutoBid(){
	 	Reporter.log("�ҵ��˻�-�Զ�Ͷ��-�ر��Զ�Ͷ��");
		if(!loginpage.ifMyAccountLogin()){
			loginpage.loginByMyAccount(Data.tel_run_zhaiquan1,Data.password, Data.zzmm,Data.test3_tel,Data.test3_password,Data.test3_zzmm);
		}
	 	myaccount.clickAutoBidLnk();
	 	if(autobid.ifshowAutoBidSetLnk()){
	 		if(autobid.ifAutoBidOpen()){
	 			autobid.clickCloseAutoBidBtn();
	 		}
	 	}
	 }

}
