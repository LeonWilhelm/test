package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.*;
import com.eloancn.shared.pages.*;
/*
 * �����Ǽƻ���ҳ������-����
 */
public class EStarPlan {
	
	Base base = new Base();
	IndexPage indexpage = new IndexPage();
	LoginPage loginpage = new LoginPage();
	EStarPlanListPage ListPage = new EStarPlanListPage();
	EStarDetailPage DetailPage = new EStarDetailPage();
	CreditReferrerDetailPage ReferrerPage = new CreditReferrerDetailPage();
	String EStarPlanUrl = base.indexURL+"/wut/loadAllWutRecords.action";
	private String MemberBPayPwd;

	@BeforeClass
	public void setupBefore(){
		
		base.setup();
		base.openBrowser(EStarPlanUrl);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(priority = 1) 
	//��顰���Ǽƻ����б�ҳ���ݺ�����
	public void verifyListData_AT_547(){
		Reporter.log("���Ǽƻ��б�ҳ-������ݺ�����");
		ListPage.verifyYXPlanPagination();
		ListPage.verifyDataLnk();
	}
	
	@Test(priority = 2)
	//���δ��¼�ġ�����Ͷ�ʡ�����
	public void FastInvestLnkinList_AT_548(){
		Reporter.log("���Ǽƻ��б�ҳ-���δ��¼�� ����Ͷ�� ����");
		if(ListPage.ifshowInvestNowLnk()){
			ListPage.clickFastInvestLnk();
			ListPage.clickCloseLoginLnk();
		}else{
			System.out.println("���Ǽƻ��б�ҳû�п�Ͷ�ʵĲ�Ʒ��");
			Reporter.log("<br/>���Ǽƻ��б�ҳû�п�Ͷ�ʵĲ�Ʒ��");
		}
	}
	
	@Test(priority = 3)
	//������Ǽƻ�����ҳ
	public void verifyDatainDetailPage_AT_555(){
		Reporter.log("���Ǽƻ�����ҳ-������ݺ�����");
		if(ListPage.ifshowEStarPlan()){
			ListPage.clickFirstEStarTitle();
			DetailPage.verifyEStarDetail();
		}else{
			System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
			Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
		}
	}
	
	@Test(priority = 4)
	//������Ǽƻ�����ҳδ��¼�ġ�����Ͷ�ʡ�����
	public void FastInvestLnkinDetail_AT_559(){
		Reporter.log("���Ǽƻ�����ҳ-���δ��¼�� ����Ͷ�� ����");		
		if(ListPage.ifshowInvestNowLnk()){
			ListPage.clickEStarTitleforInvest();
			DetailPage.clickFastInvestLnk();
			base.closeAndjumptoOldWindow();
		}else{
			System.out.println("���Ǽƻ�����ҳû�п�Ͷ�ʵĲ�Ʒ��");
			Reporter.log("<br/>���Ǽƻ�����ҳû�п�Ͷ�ʵĲ�Ʒ��");
		}
	}
	
	@Test(priority = 5)
	//������Ǽƻ��Ƽ�������ҳ
	public void verifyReferrerDetailPage_AT_562(){
		Reporter.log("���Ǽƻ��Ƽ�������ҳ-������ݺ�����");
		if(ListPage.ifshowEStarPlan()){
			ListPage.clickFirstEStarTitle();
			DetailPage.clickCreditReferrerLnk();
			DetailPage.clickReferrerAddressLnk();
			ReferrerPage.verifyReferrerDetailPage();
		}else{
			System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
			Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
		}
	}
	
	@Test(priority = 6)
	//���δ��¼�����Ǽƻ��Ƽ�������ҳ��ͼƬ
	public void NoQualifiedPhoto_AT_563(){
		Reporter.log("���Ǽƻ��Ƽ�������ҳ-���δ��¼ʱ����ʾͼƬ");
		if(ReferrerPage.ifinReferrerPage()){
			base.assertTrueByBoolean(!base.isElementPresent(CreditReferrerDetailPage.QualifiedPhoto));	
		}else{
			base.openBrowser(EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.clickCreditReferrerLnk();
				DetailPage.clickReferrerAddressLnk();
				base.checkNoElement(CreditReferrerDetailPage.QualifiedPhoto);
				base.closeWebDriver();
			}else{
				System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
				Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
			}
		}
	}
	
	@Test(priority = 7)
	//����ѵ�¼�����Ǽƻ��Ƽ�������ҳ��ͼƬ
	public void ShowQualifiedPhoto_AT_564(){
		Reporter.log("���Ǽƻ��Ƽ�������ҳ-����ѵ�¼ʱ��ʾͼƬ");
		loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		if(ReferrerPage.ifinReferrerPage()){
			base.checkElement(CreditReferrerDetailPage.QualifiedPhoto);	
		}else{
			base.openBrowser(EStarPlanUrl);
			if(ListPage.ifshowEStarPlan()){
				ListPage.clickFirstEStarTitle();
				DetailPage.clickCreditReferrerLnk();
				DetailPage.clickReferrerAddressLnk();
				base.assertTrueByBoolean(base.isElementPresentNoWait(CreditReferrerDetailPage.QualifiedPhoto));
				base.closeWebDriver();
			}else{
				System.out.println("���Ǽƻ��б�ҳû�в�Ʒ��");
				Reporter.log("<br/>���Ǽƻ��б�ҳû�в�Ʒ��");
			}
		}
	}
	
	@Test(priority = 8)
	//����״�Ͷ���б�ҳ������
	public void FirstInvestSYStarinList_AT_737(){
		Reporter.log("���Ǽƻ��б�ҳ-����״�Ͷ��������");
		loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		base.openBrowser(EStarPlanUrl);
		if(ListPage.ifshowSYStarInvestNowLnk()){
			ListPage.clickSYStarInvestNowLnk();	
			if(ListPage.ifFirstInvest()){
				ListPage.clickDenyBtn();
				ListPage.clickSYStarInvestNowLnk();				
				ListPage.clickAgreeBtn();
				ListPage.clickSYStarCancelBtn();		
			}else{
				ListPage.clickSYStarCancelBtn();
				System.out.println("���״�Ͷ���б�ҳ�����ǣ�");
				Reporter.log("<br/>���״�Ͷ���б�ҳ�����ǣ�");
			}
		}else{
			System.out.println("���Ǽƻ��б�ҳû�п�Ͷ�ʵ������ǣ������״�Ͷ�ʲ�����֤��");
			Reporter.log("<br/>���Ǽƻ��б�ҳû�п�Ͷ�ʵ������ǣ������״�Ͷ�ʲ�����֤��");
		}
	}
	
	@Test(priority = 9)
	//����״�Ͷ������ҳ������
	public void FirstInvestSYStarinDetail_AT_738(){
		Reporter.log("���Ǽƻ�����ҳ-����״�Ͷ��������");
		if(ListPage.ifshowSYStarInvestNowLnk()){
			ListPage.clickTitleforInvestSYStar();
			DetailPage.clickSYStarInvestNowLnk();
			if(ListPage.ifFirstInvest()){
				DetailPage.clickDenyBtn();
				DetailPage.clickSYStarInvestNowLnk();
				DetailPage.clickAgreeBtn();
			}else{
				System.out.println("���״�Ͷ������ҳ�����ǣ�");
				Reporter.log("<br/>���״�Ͷ������ҳ�����ǣ�");
			}	
			base.closeAndjumptoOldWindow();
		}else{
			System.out.println("���Ǽƻ�����ҳû�п�Ͷ�ʵ������ǣ������״�Ͷ�ʲ�����֤��");
			Reporter.log("<br/>���Ǽƻ�����ҳû�п�Ͷ�ʵ������ǣ������״�Ͷ�ʲ�����֤��");
		}	
	}

	@Test(priority = 10)
	//���ɹ�Ͷ���б�ҳ������
	public void InvestBZStarinList_AT_549(){
		Reporter.log("���Ǽƻ��б�ҳ-���Ͷ�ʱ����ǳɹ�");
		MemberBPayPwd=loginpage.login(Data.tel_run_zhaiquan1,Data.password, Data.zzmm, Data.test3_tel,Data.test3_password, Data.test3_zzmm);
		if(ListPage.ifshowBZStarInvestNowLnk()){
			ListPage.clickBZStarInvestNowLnk();
 			if(ListPage.BZStarCompareAmount()){
 				ListPage.InputInvestAmount();
				ListPage.InputPayPwd(MemberBPayPwd);
				ListPage.InputValidateCode();
				ListPage.CheckAgreeDeal();
				ListPage.clickBZStarOkBtn();
				ListPage.CheckInvestSuccess();
			}else{
				System.out.println("���㣡");
				Reporter.log("���㣡");
			}
		}else{
			System.out.println("���Ǽƻ��б�ҳû�п�Ͷ�ʵı����ǣ�");
			Reporter.log("<br/>���Ǽƻ��б�ҳû�п�Ͷ�ʵı����ǣ�");
		}
	}
	
	@Test(priority = 11)
	//�������ҳ�����ǵ��Զ�����
	public void AutoInputinBZStarDetail_AT_560(){
		Reporter.log("���Ǽƻ�����ҳ-��鱣���ǵ��Զ�����");
		if(ListPage.ifshowBZStarInvestNowLnk()){
			ListPage.clickTitleforInvestBZStar();
			DetailPage.clickBZStarInvestNowLnk();
			DetailPage.clickAutoInputBZStarLnk();
			DetailPage.checkBZStarAutoInput();
		}else{
			System.out.println("���Ǽƻ�����ҳû�п�Ͷ�ʵı����ǣ�");
			Reporter.log("<br/>���Ǽƻ�����ҳû�п�Ͷ�ʵı����ǣ�");
		}
	}
	
	@Test(priority = 12)
	//�������ҳ�����ǵ��Զ�����
	public void AutoInputinSYStarDetail_AT_561(){
		Reporter.log("���Ǽƻ�����ҳ-��������ǵ��Զ�����");
		base.openBrowser(EStarPlanUrl);
		if(ListPage.ifshowSYStarInvestNowLnk()){
			ListPage.clickTitleforInvestSYStar();
			DetailPage.clickSYStarInvestNowLnk();
			if(ListPage.ifFirstInvest()){
				DetailPage.clickAgreeBtn();
			}
			DetailPage.clickAutoInputSYStarLnk();
			DetailPage.checkSYStarAutoInput();
		}else{
			System.out.println("���Ǽƻ�����ҳû�п�Ͷ�ʵ������ǣ�");
			Reporter.log("<br/>���Ǽƻ�����ҳû�п�Ͷ�ʵ������ǣ�");
		}	
	}

}


