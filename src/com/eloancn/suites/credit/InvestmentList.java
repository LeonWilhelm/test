package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.DebentureTransferPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.TotalPage;

/**
 * Ͷ���б�
 * @author ������
 */
public class InvestmentList {
	
	Base base = new Base();
	
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();	
	DebentureTransferPage debentureTransferPage = new DebentureTransferPage();
	InvestmentListPage investmentListPage = new InvestmentListPage();
	
	String name,pass,payPass,money;
	
	@BeforeClass
	public void setupBefore(){
		
		base.setup();
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			name = Data.tel_run_EcunBao;
    		pass = Data.password;
			payPass = Data.zzmm;
			money = "50";
		}
		else if(base.indexURL.contains("www") || base.indexURL.contains("test")){
			name = Data.test2_tel;
    		pass = Data.test2_password;
			payPass = Data.test2_zzmm;
			money = "50";
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * �������ƣ��б�ҳ_δ��¼
	 * ������ţ�SBTZ_017
	 * @author ������
	 */
	@Test (priority = 1)
	public void checkListPageLoginWindow_AT_510(){
		
		Reporter.log("ɢ��Ͷ������:Ͷ���б�ҳ��_δ��¼����>���������Ͷ�ʡ�����>У���Ƿ񵯳�����¼������</br>");
		System.out.println("ɢ��Ͷ������:Ͷ���б�ҳ��_δ��¼����>���������Ͷ�ʡ�����>У���Ƿ񵯳�����¼������");
		//��ת����Ͷ���б�ҳ
		base.openBrowser(base.indexURL + "/new/loadAllTender.action");
		base.isTitle(PageTitles.touZiLieBiao);
		//���������Ͷ�ʡ���ť���ڣ���������У���¼DIV�Ƿ���ʾ
		investmentListPage.clickFastInvestBtn();
	}
	
	/**
	 * �������ƣ��б�ҳ
	 * ������ţ�SBTZ_016
	 * @author ������
	 */
	@Test (priority = 2)
	public void checkListPageData_AT_509(){
		
		Reporter.log("ɢ��Ͷ������:Ͷ���б�ҳ��_�ѵ�¼����>1.�����ҳ��βҳ�����ʾ10�����ݣ�2.������û�ͼƬ����ת��ȷ�ԣ�3.�����Ͷ�ʱ��⣬��ת��ȷ��</br>");
		System.out.println("ɢ��Ͷ������:Ͷ���б�ҳ��_�ѵ�¼����>1.�����ҳ��βҳ�����ʾ10�����ݣ�2.������û�ͼƬ����ת��ȷ�ԣ�3.�����Ͷ�ʱ��⣬��ת��ȷ��");

		TotalPage.openPage("Ͷ���б�", false);
		if(loginPage.ifLogin()){//��¼
			base.logout();
		}
		loginPage.homeLogin(name, pass);
		TotalPage.openPage("Ͷ���б�", true);//��ת����Ͷ���б�ҳ
		base.assertEqualsActualExpectedByBoolean(loginPage.isLogout(), false);
		//�����ҳ��βҳ�����ʾ10������
		investmentListPage.checkMaxDisplay();
		//������û�ͼƬ����ת��ȷ��
		investmentListPage.checkUserImgJumpList();
		//�����Ͷ�ʱ��⣬��ת��ȷ��
		investmentListPage.checkUserTitleList();
	}
	
	/**
	 * �������ƣ���������ҳ_ҳ����ʾ����ת
	 * ������ţ�SBTZ_019
	 * @author ������
	 */
	@Test (priority = 3)
	public void checkBorrowDetailsPageData_AT_512(){
		
		Reporter.log("ɢ��Ͷ������:��������ҳ����>У�����������ʱ������������ҳ����ȷ��1.����������ҳͼƬ����ת����������ҳ;2.������飬�鿴����ƻ�</br>");
		System.out.println("ɢ��Ͷ������:��������ҳ����>У�����������ʱ������������ҳ����ȷ��1.����������ҳͼƬ����ת����������ҳ;2.������飬�鿴����ƻ�");
		
//		TotalPage.openPage("Ͷ���б�", false);
//		if(loginPage.ifLogin()){//��¼
//			base.logout();
//		}
//		loginPage.homeLogin(name, pass);
//		TotalPage.openPage("Ͷ���б�", true);//��ת����Ͷ���б�ҳ
//		base.assertEqualsActualExpectedByBoolean(loginPage.isLogout(), false);
		//У�顰�������顱ҳ
		investmentListPage.checkDetailsInfoLinks();
	}
	
	/**
	 * �������ƣ�Ͷ�ʴ���_Ͷ��
	 * ������ţ�SBTZ_018
	 * @author ������
	 */
	@Test (priority = 4)
	public void checkInvestmentWindow_AT_511(){
		
		Reporter.log("ɢ��Ͷ������:Ͷ���б�ҳ�桪��>���������Ͷ�ʡ�����>��֤Ͷ���Ƿ�ɹ�</br>");
		System.out.println("ɢ��Ͷ������:Ͷ���б�ҳ�桪��>���������Ͷ�ʡ�����>��֤Ͷ���Ƿ�ɹ�");
		
		TotalPage.openPage("Ͷ���б�", false);
		if(loginPage.ifLogin()){//��¼
			base.logout();
		}
		loginPage.homeLogin(name, pass);
		TotalPage.openPage("Ͷ���б�", true);//��ת����Ͷ���б�ҳ
		base.assertEqualsActualExpectedByBoolean(loginPage.isLogout(), false);
		
		if(money.equals("50")){
			//У�顰����Ͷ�ʡ���ť������Ͷ��
			investmentListPage.checkFastInvest(money, payPass);
		}
	}
	
	/**
	 * �������ƣ���������ҳ_Ͷ��
	 * ������ţ�SBTZ_020
	 * @author ������
	 */
	@Test (priority = 5)
	public void checkBorrowDetailsPageInvestment_AT_513(){
		
		Reporter.log("ɢ��Ͷ������:��������ҳ����>�������Ǯ����������>��֤Ͷ���Ƿ�ɹ�");
		System.out.println("ɢ��Ͷ������:��������ҳ����>�������Ǯ����������>��֤Ͷ���Ƿ�ɹ�");
		/*
		//���µ�¼
		//loginPage.reLogin();
		//��ת����Ͷ���б�ҳ
		//indexPage.clickInvestmentListLink();
		//У�顰��Ǯ��������ť������Ͷ��
		 */
		if(money.equals("50")){
			investmentListPage.checkBorrowMoney(money, payPass);
		}
	}
	
	@Test (priority = 6)
	public void checkReserveBidJump_AT_5251(){
		
		Reporter.log("ɢ��Ͷ���б������ԤԼͶ�ꡱ��ť���鿴��ת�Ƿ�ɹ�</br>");
		System.out.println("ɢ��Ͷ���б������ԤԼͶ�ꡱ��ť���鿴��ת�Ƿ�ɹ�");
		
		base.openBrowser(base.indexURL + "/new/loadAllTender.action");
		base.isTitle(PageTitles.touZiLieBiao);
		investmentListPage.clickReserveBidBtn();
	}
}

