package com.eloancn.suites.index;

import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.TotalPage;

public class SBInvestment {

	Base base = new Base();
	Data data = new Data();
	DBData dbData = new DBData();
	
	IndexPage indexPage = new IndexPage();
	InvestmentListPage investmentListPage = new InvestmentListPage();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		base.isTitle(PageTitles.shouYe);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test (priority = 1, enabled = true)
	public void checkSanBiaoHomeData_AT_5253(){
		
		Reporter.log("��ҳ��ɢ��Ͷ�ʡ���>У��1�������ʾ3������   2����ʾ��ʽ  3���������б�ҳһ��<br/>");
		System.out.println("��ҳ��ɢ��Ͷ�ʡ���>У��1�������ʾ3������   2����ʾ��ʽ  3���������б�ҳһ��");
		
		TotalPage.openPage("Ͷ���б�", false);
		List<String> sbTitleList = investmentListPage.getSBInvestmentDataStr("������");
		List<String> sbLevelList = investmentListPage.getSBInvestmentDataStr("����");
		List<String> sbMoneyList = investmentListPage.getSBInvestmentDataStr("�����");
		List<String> sbRateList = investmentListPage.getSBInvestmentDataStr("�������");
		List<String> sbPeriodsList = investmentListPage.getSBInvestmentDataStr("�������");
		TotalPage.openPage("��ҳ", false);
		indexPage.checkProductTitleStyle("ɢ��Ͷ��","text-align", "center");
		List<String> homeTitleList = indexPage.getSBDataStr("����");
		indexPage.checkSBTableColumnName();
		indexPage.checkSBDataNum(homeTitleList);
		indexPage.checkSBData(sbTitleList, sbLevelList, sbMoneyList, sbRateList, sbPeriodsList);
	}

}
