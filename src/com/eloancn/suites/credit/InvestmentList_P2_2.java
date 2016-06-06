package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.DebentureTransferPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoginPage;
/*
 * Ͷ���б�
 */
public class InvestmentList_P2_2 {

	Base base = new Base();
	LoginPage loginpage = new LoginPage();
	InvestmentListPage investListPage = new InvestmentListPage();
	DebentureTransferPage newUserPage = new DebentureTransferPage();

	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(investListPage.Url);
		loginpage.login(Data.tel_Invest, Data.password,"",Data.tel_Invest, Data.password,"");
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}	
	
	@Test (priority = 1)
	//��Ҫ����-Ͷ���б�-����б�ҳ����ʾ
	public void checkDatawithLogin_3897(){	
		Reporter.log("��Ҫ����-Ͷ���б�-����б�ҳ����ʾ");
		investListPage.checkInvestListDatawithLogin();
	}
	
	@Test (priority = 2)
	//��Ҫ����-Ͷ���б�-����¼��δ��¼ʱ"�Զ�Ͷ��"��ת
	public void checkAutoBidLnk_3897(){
		Reporter.log("��Ҫ����-Ͷ���б�-����¼��δ��¼ʱ���Զ�Ͷ�ꡱ����ת");
		investListPage.clickAutoBidBtn(1);
		base.logout();
		base.refreshPage();
		base.openBrowser(investListPage.Url);
		investListPage.clickAutoBidBtn(0);
	}
	
	@Test (priority = 3)
	//��Ҫ����-Ͷ���б�-û�г�ֵ�������ֻ��û�Ͷ��
	public void checkTelUserInvestTip_3908(){
		Reporter.log("��Ҫ����-Ͷ���б�-û�г�ֵ�������ֻ��û�Ͷ��");
		base.openBrowser(investListPage.Url);
		loginpage.login(Data.run_ECunBao_oldtel, Data.password, "", Data.test_run_ECunBao_oldtel, Data.password, "");
		if(investListPage.clickFastInvestBtn()){
			investListPage.clickCloseRechargeLnk();
		}
	}
	
	@Test (priority = 4)
	//����ר��-û�г�ֵ�������ֻ��û�Ͷ��
	public void checkOldTelInvestTip_3924(){
		base.openBrowser(newUserPage.PageUrl);
		newUserPage.clickFastInvestBtn();
		newUserPage.clickCloseRechargeBtn();		
	}
	
	@Test (priority = 5)
	//��Ҫ����-Ͷ���б�-û�г�ֵ�����������û�Ͷ��
	public void checkEmailUserInvestTip_3908(){
		Reporter.log("��Ҫ����-ɢ���б�-û�г�ֵ�����������û�Ͷ��");
		base.logout();
		loginpage.login(Data.run_ECunBao_oldemail, Data.password, "", Data.test_run_ECunBao_oldemail, Data.password, "");
		base.openBrowser(investListPage.Url);
		if(investListPage.clickFastInvestBtn()){
			investListPage.clickCloseRechargeLnk();
		}
	}
	
	@Test (priority = 6)
	//����ר��-û�г�ֵ�����������û�Ͷ��
	public void checkOldEmailInvestTip_3924(){
		base.openBrowser(newUserPage.PageUrl);
		newUserPage.clickFastInvestBtn();
		newUserPage.clickCloseRechargeBtn();	
	}	

	@Test (priority = 7)
	//��Ҫ����-Ͷ���б�-���������-������롰Ͷ�ʽ�
	public void checkInputInvestMoney_3899(){
		Reporter.log("��Ҫ����-Ͷ���б�-���������-������롰Ͷ�ʽ�");
		base.openBrowser(investListPage.Url);
		investListPage.clickIncomeCalculatorLnk();
		investListPage.InputInvestInfos("10000", "10", "1", 1, "");
		investListPage.InputInvestInfos("6541dddd", "", "", 0, "Ͷ�ʽ���ȷ��");
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test (priority = 8)
	//��Ҫ����-Ͷ���б�-���������-������롰�����ʡ�
	public void checkInputLoanRate_3900(){
		Reporter.log("��Ҫ����-Ͷ���б�-���������-������롰�����ʡ�");
		investListPage.clickIncomeCalculatorLnk();
		investListPage.InputInvestInfos("10000", "0", "", 0, "�����ʲ���ȷ��");
		investListPage.InputInvestInfos("10000", "js@#", "", 0, "�����ʲ���ȷ��");
		investListPage.InputInvestInfos("10000", "12", "1", 1, "");
		investListPage.InputInvestInfos("10000", "12.5", "1", 1, "");
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test (priority = 9)
	//��Ҫ����-Ͷ���б�-���������-������롰Ͷ�����ޡ�
	public void checkInputLoanPhase_3901(){
		Reporter.log("��Ҫ����-Ͷ���б�-���������-������롰Ͷ�����ޡ�");
		investListPage.clickIncomeCalculatorLnk();
		investListPage.InputInvestInfos("10000", "10", "1", 1, "");
		investListPage.InputInvestInfos("10000", "10", "12", 1, "");
		investListPage.InputInvestInfos("10000", "10", "24", 1, "");
		investListPage.InputInvestInfos("10000", "10", "3.5", 0, "������޲���ȷ��");
		investListPage.InputInvestInfos("10000", "10", "0", 0, "������޲���ȷ��");
		investListPage.InputInvestInfos("10000", "10", "25", 0, "�������Ӧ��1-24����֮�䣬��������д��");
		investListPage.InputInvestInfos("10000", "10", "fffd#", 0, "������޲���ȷ��");
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test (priority = 10)
	//��Ҫ����-Ͷ���б�-���������-��顰���ʽ��
	public void checkRepayMode_3902(){
		Reporter.log("��Ҫ����-Ͷ���б�-���������-��顰���ʽ��");
		investListPage.clickIncomeCalculatorLnk();
		investListPage.checkDropdownList();
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test (priority = 11)
	//��Ҫ����-Ͷ���б�-���������-����տ��ܶ����Ϣ
	public void checkAmountAndInterest_3903(){
		Reporter.log("��Ҫ����-Ͷ���б�-���������-����տ��ܶ����Ϣ");
		investListPage.clickIncomeCalculatorLnk();
		investListPage.InputInvestInfos("10000", "18", "12", 2, "");
		investListPage.checkAmountAndInterest(false, 10000, 18, 12);
		investListPage.InputInvestInfos("10000", "15", "3", 2, "");
		investListPage.checkShowPlanTable();
		investListPage.clickCalculateNowBtn();
		investListPage.checkAmountAndInterest(true, 10000, 15, 3);
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test (priority = 12)
	//��Ҫ����-Ͷ���б�-���������-����տ�ʱ����е�����
	public void checkDatainTable_3904(){
		Reporter.log("��Ҫ����-Ͷ���б�-���������-����տ�ʱ����е�����");
		investListPage.clickIncomeCalculatorLnk();
		investListPage.InputInvestInfos("10000", "17", "5", 2, "");
		investListPage.checkShowPlanTable();
		investListPage.clickCalculateNowBtn();
		investListPage.checkDatainTable(10000,17,5);
		investListPage.clickCloseCalculatorBtn();
	}
	
	@Test(priority = 13)
	//��Ҫ����-Ͷ���б�-���Ͷ���б�ɸѡ��Ĭ��ֵ
	public void checkDefaultOptions_3909_3913(){
		Reporter.log("��Ҫ����-Ͷ���б�-���Ͷ���б�ɸѡ��Ĭ��ֵ");
		base.openBrowser(investListPage.Url);
		investListPage.checkDefaultOptions();
	}
	
	@Test (priority = 14)
	//��Ҫ����-Ͷ���б�-��黹�ʽɸѡ����
	public void checkRepayMode_3909(){
		Reporter.log("��Ҫ����-Ͷ���б�-��顰���ʽ����ɸѡ����");
		base.openBrowser(investListPage.Url);
		String [] mode = {"�ȶ��","�ȶϢ","������Ϣ"};
		investListPage.clickRepayModeOption(mode[0]);
		investListPage.checkOption(mode[0],"","","");
		investListPage.clickRepayModeOption(mode[1]);
		investListPage.checkOption(mode[1],"","","");
		investListPage.clickRepayModeOption(mode[2]);
		investListPage.checkOption(mode[2],"","","");
	}
	
	@Test (priority = 15)
	//��Ҫ����-Ͷ���б�-���������ɸѡ����
	public void checkLoanPhase_3910(){
		Reporter.log("��Ҫ����-Ͷ���б�-��顰������ޡ���ɸѡ����");
		base.openBrowser(investListPage.Url);
		String [] phase = {"3��������","4��6����","7��11����","12��������"};
		investListPage.clickPhaseOption(phase[0]);
		investListPage.checkOption(phase[0],"","","");
		investListPage.clickPhaseOption(phase[1]);
		investListPage.checkOption(phase[1],"","","");
		investListPage.clickPhaseOption(phase[2]);
		investListPage.checkOption(phase[2],"","","");
		investListPage.clickPhaseOption(phase[3]);
		investListPage.checkOption(phase[3],"","","");
	}
	
	@Test (priority = 16)
	//��Ҫ����-Ͷ���б�-���������ɸѡ����
	public void checkLoanRate_3911(){
		Reporter.log("��Ҫ����-Ͷ���б�-��顰������ʡ���ɸѡ����");
		base.openBrowser(investListPage.Url);
		String [] rate = {"12%����","12%��15%","15%��18%","18%����"};
		investListPage.clickRateOption(rate[0]);
		investListPage.checkOption(rate[0],"","","");
		investListPage.clickRateOption(rate[1]);
		investListPage.checkOption(rate[1],"","","");
		investListPage.clickRateOption(rate[2]);
		investListPage.checkOption(rate[2],"","","");
		investListPage.clickRateOption(rate[3]);
		investListPage.checkOption(rate[3],"","","");
	}
	
	@Test (priority = 17)
	//��Ҫ����-Ͷ���б�-�������������ɸѡ����
	public void checkFilterFunction1_3913(){
		Reporter.log("��Ҫ����-Ͷ���б�-�������������ɸѡ����");
		base.openBrowser(investListPage.Url);
		investListPage.clickRepayModeOption("�ȶ��");
		investListPage.clickPhaseOption("3��������");
		investListPage.clickRateOption("12%����");
		investListPage.clickType("���ý��");
		investListPage.checkOption("�ȶ��","3��������","12%����","���ý��");
	}
	
	@Test (priority = 18)
	//��Ҫ����-Ͷ���б�-�������������ɸѡ����
	public void checkFilterFunction2_3913(){
		Reporter.log("��Ҫ����-Ͷ���б�-�������������ɸѡ����");
		base.openBrowser(investListPage.Url);
		investListPage.clickRepayModeOption("�ȶϢ");
		investListPage.clickPhaseOption("4��6����");
		investListPage.clickRateOption("12%��15%");
		investListPage.clickType("������Ѻ");
		investListPage.checkOption("�ȶϢ","4��6����","12%��15%","������Ѻ");
	}
	
	@Test (priority = 19)
	//��Ҫ����-Ͷ���б�-�������������ɸѡ����
	public void checkFilterFunction3_3913(){
		Reporter.log("��Ҫ����-Ͷ���б�-�������������ɸѡ����");
		base.openBrowser(investListPage.Url);
		investListPage.clickRepayModeOption("������Ϣ");
		investListPage.clickPhaseOption("7��11����");
		investListPage.clickRateOption("15%��18%");
		investListPage.clickType("���ݵ�Ѻ");
		investListPage.checkOption("������Ϣ","7��11����","15%��18%","���ݵ�Ѻ");
	}
	
	@Test (priority = 20)
	//��Ҫ����-Ͷ���б�-�������������ɸѡ����
	public void checkFilterFunction4_3913(){
		Reporter.log("��Ҫ����-Ͷ���б�-�������������ɸѡ����");
		base.openBrowser(investListPage.Url);
		investListPage.clickRepayModeOption("�ȶϢ");
		investListPage.clickPhaseOption("12��������");
		investListPage.clickRateOption("18%����");
		investListPage.clickType("���ý��");
		investListPage.checkOption("�ȶϢ","12��������","18%����","���ý��");
	}

}
