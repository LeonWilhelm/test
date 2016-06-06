package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.*;
import com.eloancn.shared.pages.*;

/*
 * ��ծȨת�á�ҳ������-����
 */
public class CreditAssignment {
	
	Base base = new Base();
	IndexPage indexpage= new IndexPage();
	LoginPage loginpage = new LoginPage();
	CreditAssignListPage list = new CreditAssignListPage();
	CreditDetailPage detailpage = new CreditDetailPage();
	private String MemberBPayPwd;
	
	@BeforeClass
	public void setupBefore(){
		
		base.setup();
		base.openBrowser(list.CreditAssignmentUrl);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(priority = 1) 
	//��顰ծȨת���б�ҳ������ݺ�����
	public void verifyListDataLnk_AT_531(){
		Reporter.log("ծȨת���б�ҳ-������ݼ�����");
		list.verifyCreditPagination();
		list.verifyDataLnk();
	}
	
	@Test(priority = 2) 
	//���δ��¼�ġ���������/�������ۡ�����
	public void FastBuyBtninList_AT_534(){
		Reporter.log("ծȨת���б�ҳ-δ��¼ʱ�� ��������/�������� ����");
		if(list.ifshowBuyNowBtn()){
			list.clickFirstBuyNowBtn();
			list.clickCloseLoginLnk();
		}else{
			System.out.println("û�пɹ����ծȨ��");
			Reporter.log("<br/>û�пɹ����ծȨ��");
		}
	}
	
	@Test(priority = 3)
	//���ɹ�����������ծȨ
	public void BuyAuctionDebt_AT_535(){
		Reporter.log("ծȨת���б�ҳ-����������ծȨ�ɹ�");
		MemberBPayPwd=loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		list.clickAuctionMode();
		if(list.ifshowBuyNowBtn()){
			if(list.compareCreditMoney()){
				list.clickAddLnk();
				list.InputPayPwd(MemberBPayPwd);
				list.InputValidateCode();
				base.sleep(2000);
				list.clickOkBtn();					
				list.clickContinueBtn();			
				list.CheckBuySuccess("��ϲ�����۳ɹ�");
			}else{
				System.out.println("������ծȨ���ϴ󣬻��߾��Ľ����ڻ���ڴ��ձ�Ϣ��");
				Reporter.log("<br/>������ծȨ���ϴ󣬻��߾��Ľ����ڻ���ڴ��ձ�Ϣ��");
			}
		}else{
			System.out.println("û�пɹ��������ծȨ��");
			Reporter.log("<br/>û�пɹ��������ծȨ��");
		}	
	}	
	
	@Test(priority = 4)
	//���ɹ�����һ�ڼ۵�ծȨ
	public void BuyFixedPriceDebt_AT_536(){
		Reporter.log("ծȨת���б�ҳ-����һ�ڼ۵�ծȨ�ɹ�");
		MemberBPayPwd=loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		list.clickFixedPriceMode();
		if(list.ifshowBuyNowBtn()){
			if(list.compareCreditMoney()){
				list.InputPayPwd(MemberBPayPwd);
				list.InputValidateCode();
				base.sleep(2000);
				list.clickOkBtn();
				list.CheckBuySuccess("��ϲ������ծȨ�ɹ�");
			}else{
				System.out.println("һ�ڼ۵�ծȨ���ϴ󣬲��蹺��");
				Reporter.log("<br/>һ�ڼ۵�ծȨ���ϴ󣬲��蹺��");
			}
		}else{
			System.out.println("û�пɹ����һ�ڼ�ծȨ��");
			Reporter.log("<br/>û�пɹ����һ�ڼ�ծȨ��");
		}	
	}
	
	@Test(priority = 5)	
	//���ɹ�������ת��ծȨ
	public void BuySecretTransferDebt_AT_537(){
		Reporter.log("ծȨת���б�ҳ-������ת��ծȨ�ɹ�");
		MemberBPayPwd=loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		list.clickSecretTransferMode();
		if(list.ifshowBuyNowBtn()){
			if(list.compareCreditMoney()){
				list.InputTransferCode();
				list.InputPayPwd(MemberBPayPwd);
				list.InputValidateCode();
				base.sleep(2000);
				list.clickOkBtn();
				list.CheckBuySuccess("��ϲ������ծȨ�ɹ�");
			}else{
				System.out.println("��ת��ծȨ���ϴ󣬲��蹺��");
				Reporter.log("<br/>��ת��ծȨ���ϴ󣬲��蹺��");
			}
		}else{
			System.out.println("û�пɹ������תծȨ��");
			Reporter.log("<br/>û�пɹ������תծȨ��");
		}	
	}
	
	@Test(priority = 6)
	//���ծȨת������ҳ
	public void verifyDebtDetailPage_AT_538(){
		Reporter.log("���ծȨת������ҳ�����ݺ�����");
		base.openBrowser(list.CreditAssignmentUrl);
		if(list.ifshowCreditAssign()){
			list.clickFirstDebtTitle();
			detailpage.verifyCreditDetail();
		}else{
			System.out.println("ծȨ�б�ҳû��ծȨ��");
			Reporter.log("<br/>ծȨ�б�ҳû��ծȨ��");
		}
	}
	
	@Test(priority = 7)
	//���ɹ����ծȨ
	public void verifyDebtDetailData_AT_736(){
		Reporter.log("���ɹ����ծȨ������ҳ�����ݸ��б�ҳ�е�����һ��");
		if(list.ifshowCreditforBuy()){
				list.verifyDebtData();
		}else{
			System.out.println("ծȨ�б�ҳû�пɹ����ծȨ��");
			Reporter.log("<br/>ծȨ�б�ҳû�пɹ����ծȨ��");
		}
	}	

}
