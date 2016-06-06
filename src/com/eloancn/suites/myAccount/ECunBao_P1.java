package com.eloancn.suites.myAccount;

import java.util.Date;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.SBInvestPage;
import com.eloancn.shared.pages.TotalPage;
import com.eloancn.shared.pages.YCBPage;

/**
 * Ͷ����汦
 */
public class ECunBao_P1 {
	
	Base base = new Base();
	DBData dbData = new DBData();
	YCBPage yCBPage = new YCBPage();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	RechargePage rechargePage = new RechargePage();
	SBInvestPage sBInvestPage = new SBInvestPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
	
	String[] telArray;
	String[] nameArray;
	String[] password;
	String[] payPass;   //֧������
	String day;         //��Լ����
	String eCunBaoName; //��Ʒ����
	String[] creditorDetails;
	String cancel_Tel;   //ע�����֤�˻�
	String cancel_Pass;
	String cancel_PayPass;
	
	//������˺�
	String[] jieKuanRen_Tel;
	String[] jieKuanRen_Pass;
	String   jieKuanRen_PayPass;
	
	//���Ա�
	String jinErDuiBi_Tel;
	String jinErDuiBi_Pass;
	
	//VIP�ȼ�
	String[] vip_Tel;
	String vip_Pass;
	String[] vip_Rate;//VIP����
	
	//��ͨ�û���Ϣ
	String normalInterestAccrual_Tel;
	String normalInterestAccrual_Pass;
	
	String[] telArray_client = {"13581567705","13581567706","13581567707","15255555555"};  //�����뱾�ػ���ʹ���˻�//[0]����ͨ�û���[1]��VIP1.0�û���[2]��VIP1.5�û���[3]:�����û�����ÿ��������ϸ�����ݣ�
	String[] nameArray_client = {"��Ө","��Өһ","��Ө��","���д�"};							   //����
	String[] password_client = {Data.zzmm, Data.zzmm, Data.zzmm, Data.zzmm};               //��¼����
	String[] payPass_client = {Data.zzmm, Data.zzmm, Data.zzmm, Data.zzmm};                //֧������
	String day_client = "730";
	String eCunBaoName_client = "jby����";
	String[] creditorDetails_chient = {"jby����","��**","3501011983********","������","��100000","18%","730��","�鿴����"};
	String cancel_tel_client = "15924193586";											   //ע�������֤���˻�
	String cancel_pass_client = Data.zzmm;
	String cancel_payPass_client = Data.zzmm;
	//[0]δ��������[1]������δ��ˣ�[2]���������ͨ�����������У�δ���ڣ�[3]���������ͨ��������������[4]���ν��ɹ������һ�λ���(δ����)[5]:�����ڼ�¼�������У�δ���ڣ�[6]:������
	String[] jieKuanRen_tel_client = {"13581568821","13581568822","13581568823","13581568824","13581568825","13581568826","13581568827"};
	String[] jieKuanRen_pass_client = {Data.zzmm,Data.zzmm,Data.zzmm,Data.zzmm,Data.zzmm,Data.zzmm,Data.zzmm};
	String jieKuanRen_PayPass_client = Data.zzmm;
	String jinErDuiBi_tel_client = "17665694718";
	String jinErDuiBi_pass_client = Data.zzmm;
	//[0]VIP1 +0.1,[0]VIP2 +0.2,[0]VIP3 +0.3,[0]VIP4 +0.4,[0]VIP5 +0.5,[0]VIP6 +0.6,[0]VIP7 +0.7,[0]VIP8 +0.8,[0]VIP9 +0.9,[0]VIP10 +1,[0]VIP11 +1.5
	String[] vip_tel_client = {"13581595501","13581595502","13581595503","13581595504","13581595505","13581595506","13581595507","13581595508","13581595509","13581595510","13581595511"};
	String vip_pass_client = Data.zzmm;
	String[] vip_rate_client = {"+0.1%","+0.2%","+0.3%","+0.4%","+0.5%","+0.6%","+0.7%","+0.8%","+0.9%","+1.0%","+1.5%"};
	
	String normalInterestAccrual_tel_client = "13581565500";
	String normalInterestAccrual_pass_client = Data.zzmm;
	
	String[] telArray_test = {"18880000199","eloancn04@163.com","13834569527"};            //������test����ʹ���˻�//[0]����ͨ�û���[1]��VIP1.0�û���[2]��VIP1.5�û����������˻�
	String[] nameArray_test = {"����֮","�Թ�֥","������"};	     							   //����
	String[] password_test = {"111111","111111","13834569527"};						       //��¼����
	String[] payPass_test = {Data.test2_zzmm, Data.zzmm, "sunny783117"};                   //֧������
	String day_test = "365";
	String eCunBaoName_test = "2645��";
	String[] creditorDetails_test = {"���δ�����...","��**","3505211983********","Ȫ����","��50000","11.60%","365��","�鿴����"};
	String cancel_tel_test = "13011876410";													//ע�������֤���˻�
	String cancel_pass_test = Data.zzmm;
	String cancel_payPass_test = Data.zzmm;
	String jinErDuiBi_tel_test = Data.test2_tel;
	String jinErDuiBi_pass_test = Data.test2_password;
	
	double balance;                            //�˻��������
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			
			telArray = telArray_client;
			nameArray = nameArray_client;
			password = password_client;
			payPass = payPass_client;
			day = day_client;
			eCunBaoName = eCunBaoName_client;
			cancel_Tel = cancel_tel_client;
			cancel_Pass = cancel_pass_client;
			cancel_PayPass = cancel_payPass_client;
			jieKuanRen_Tel = jieKuanRen_tel_client;
			jieKuanRen_Pass = jieKuanRen_pass_client;
			jieKuanRen_PayPass = jieKuanRen_PayPass_client;
			jinErDuiBi_Tel = jinErDuiBi_tel_client;
			jinErDuiBi_Pass = jinErDuiBi_pass_client;
			vip_Tel = vip_tel_client;
			vip_Pass = vip_pass_client;
			vip_Rate = vip_rate_client;
			normalInterestAccrual_Tel = normalInterestAccrual_tel_client;
			normalInterestAccrual_Pass = normalInterestAccrual_pass_client;
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			
			telArray = telArray_test;
			nameArray = nameArray_test;
			password = password_test;
			payPass = payPass_test;
			day = day_test;
			eCunBaoName = eCunBaoName_test;
			cancel_Tel = cancel_tel_test;
			cancel_Pass = cancel_pass_test;
			cancel_PayPass = cancel_payPass_test;
			jinErDuiBi_Tel = jinErDuiBi_tel_test;
			jinErDuiBi_Pass = jinErDuiBi_pass_test;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}

	@DataProvider(name="user")
	public Object[][] Users(){
		
		Object[][] users = null;
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			users = new Object[][]{
				{telArray[0], nameArray[0], password[0], payPass[0]},       //��ͨ�û�
				{telArray[1], nameArray[1], password[1], payPass[1]},       //VIP1.0�û�
				{telArray[2], nameArray[2], password[2], payPass[2]},       //VIP1.5�û�
				{telArray[3], nameArray[3], password[3], payPass[3]}        //�����û�
			};
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			users = new Object[][]{
				{telArray[0], nameArray[0], password[0], payPass[0]},       //��ͨ�û�
//				{telArray[1], nameArray[1], password[1], payPass[1]},       //VIP1.0�û�
//				{telArray[2], nameArray[2], password[2], payPass[2]},       //VIP1.5�û�
			};
		}
	
		return users;
	}
	
	@DataProvider(name="VIP")
	public Object[][] VIP_Client_Users(){
		
		Object[][] users = null;
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			users = new Object[][]{
				{vip_tel_client[0], vip_pass_client, vip_rate_client[0]},       
				{vip_tel_client[1], vip_pass_client, vip_rate_client[1]}, 
				{vip_tel_client[2], vip_pass_client, vip_rate_client[2]}, 
				{vip_tel_client[3], vip_pass_client, vip_rate_client[3]}, 
				{vip_tel_client[4], vip_pass_client, vip_rate_client[4]}, 
				{vip_tel_client[5], vip_pass_client, vip_rate_client[5]}, 
				{vip_tel_client[6], vip_pass_client, vip_rate_client[6]}, 
				{vip_tel_client[7], vip_pass_client, vip_rate_client[7]}, 
				{vip_tel_client[8], vip_pass_client, vip_rate_client[8]}, 
				{vip_tel_client[9], vip_pass_client, vip_rate_client[9]}, 
				{vip_tel_client[10], vip_pass_client, vip_rate_client[10]}
			};
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			users = new Object[][]{
					{vip_tel_client[0], vip_pass_client, vip_rate_client[0]}
				};
		}
	
		return users;
	}
	
	/*****************************************************/
	/******************   ��汦_��汦Ͷ��          *****************/
	/*****************************************************/
	
	/**
	 * ��ҳ������汦��ʹ�ò�ͬ�˻���
	 * ��ע�����928_2
	 * @param tel:�ֻ���
	 * @param pass����¼����
	 */
	@Test(priority = 1, dataProvider = "user", enabled = true)
	public void buyECunBaoByHomePage_F_1339_1344_1348_1355(String tel, String name, String pass, String payPass){
		
		Reporter.log("��汦Ͷ��_P1:��ҳ����>��ͨ�û�/VIP1.0/VIP1.5/�����˻�Ͷ����汦");
		
		base.logout();
		loginPage.loginByMyAccount(tel, pass);
		//��ȡ�˻��������
		try {
			balance = myAccountPage.getBalance();
		} catch (Exception e) {
			System.out.println("�ҵ��˻����˻���������ȡʧ��");
			Reporter.log("�ҵ��˻����˻���������ȡʧ��");
		}
		base.openBrowser(base.indexURL);
		base.checkTitle(PageTitles.shouYe);
		//Ͷһ��
		try {
			eCunBaoPage.touYiBi("1",payPass,0,balance);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�˻���" + tel + "��ҳ��汦��Ͷһ�� ����ʧ�ܣ�");
			Reporter.log("�˻���" + tel + "��ҳ��汦��Ͷһ�� ����ʧ�ܣ�");
		}
		//����Ͷ��
		System.out.println("��ҳ��汦������Ͷ�� ����");
		Reporter.log("��ҳ��汦������Ͷ�� ����");
		try {
			eCunBaoPage.maShangTouZi("1",payPass,0,balance);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�˻���" + tel + "��ҳ��汦������Ͷ��  ����ʧ�ܣ�");
			Reporter.log("�˻���" + tel + "��ҳ��汦������Ͷ��  ����ʧ�ܣ�");
		}
	}
	
	/**
	 * ��汦�б�ҳ������汦��ʹ�ò����˻���
	 * ��ע��ǰ̨�������¼�����ӳ٣����޷�У��Ͷ����������Ͷ��ʱ�䡢Ͷ�ʽ�����ʽ
	 * @param tel �ֻ���
	 * @param name ����
	 * @param pass ��¼����
	 * @param payPass ֧������
	 * @author ������
	 */
	@Test(priority = 2, dataProvider = "user", enabled = true)
	public void buyECunBaoByECunBaoPage_F_1340_1347_1349_1357(String tel, String name, String pass, String payPass){
		
		Reporter.log("��汦Ͷ��_P1:��汦�б�ҳ����>��ͨ�û�/VIP1.0/VIP1.5/�����˻�Ͷ����汦");
		
		String productId = ""; //��汦��ƷID
		String amount = "100";
		String joinTime = ""; //������汦��ʱ��
		
		base.logout();
		loginPage.loginByMyAccount(tel, pass);
		//��ȡ�˻��������
		try {
			balance = myAccountPage.getBalance();
		} catch (Exception e) {
			System.out.println("�ҵ��˻����˻���������ȡʧ��");
			Reporter.log("�ҵ��˻����˻���������ȡʧ��");
		}
		base.openBrowser(base.indexURL+"/new/loadAllWmpsRecords.action");
		base.checkTitle(PageTitles.yiCunBao);
		//�������Ͷ����ť
		productId = eCunBaoPage.checkTenderTotalBtnRecharge();  //System.out.println("ECunBao id: " + id);//----------����
		//���û�е����޷���Ͷ�Ի�������Ͷ��-1 ����û�а�ť��0 �����������
		if(!productId.equals("0") && !productId.equals("-1")){
			//������
			eCunBaoPage.inputInvestmentAmountTxt(productId, amount);
			//�����ͬ��Э�鲢Ͷ�ʡ�
			eCunBaoPage.clickAgreeInvestmentBtn(productId);      //System.out.println("ECunBao2 id: " + id);
			joinTime = base.dateFormat(base.getTime(), "yyyy-MM-dd HH:mm");
			//��ȡ����ʧ��DIV
			if(eCunBaoPage.getOperationFailureDiv()){
				eCunBaoPage.closeOperationFailureDiv();
				System.out.println("��汦Ͷ�ʺ���ʾ����ʧ��~");
			}
			//�������2�����ӳ٣����޷�У��-----------------
//			//���µ�¼
//			loginPage.reLogin(tel, pass);
//			base.openBrowser(base.indexURL+"/new/loadAllWmpsRecords.action");
//			base.checkTitle("����汦��-������");
//			//�����У�飨ϵͳ�ӳ٣��޷�У�飩
//			eCunBaoPage.checkRecord(productId, "1", name, amount, joinTime);
		}
	}
	
	@Test(priority = 3, dataProvider = "user", enabled = false)
	public void checkFundRunningWater_F_1239_1240_1241_1305(String tel, String name, String pass, String payPass){
		
		Reporter.log("��汦Ͷ��_P1:�ҵ��˻�����>��汦ҳ����>��ͨ�û�/VIP1.0/VIP1.5/�����˻��鿴��汦�ʽ���ˮ");
	
		String waitPrincipalNumStrByLend = "0.00";
		String waitInterestNumStrByLend = "0.00";
	
		base.logout();
		loginPage.loginByMyAccount(tel, pass);
		
		//ɢ��Ͷ�ʡ�������У�顰���ձ��𡱡���������Ϣ��
		myAccountPage.turnToMyAccount("ɢ��Ͷ��");
		base.checkVisible(SBInvestPage.SBInvestTxt);
		base.sleep(2000);
		//ɢ��Ͷ���� �����ձ��� �޷�У��ʴ�ҳ���ȡ
		waitPrincipalNumStrByLend =	sBInvestPage.getRetrieveInfoNum("���ձ���");
		//ɢ��Ͷ���� ��������Ϣ�� �޷�У��ʴ�ҳ���ȡ
		waitInterestNumStrByLend = sBInvestPage.getRetrieveInfoNum("������Ϣ");
		
		//��汦��������У�顰���ձ��𡱡���������Ϣ���������ձ�����
		myAccountPage.turnToMyAccount("��汦");
		base.checkVisible(YCBPage.YCBTxt);
		yCBPage.clickPartake();  //����������С�
		
		String waitPrincipalNumStrByECB = yCBPage.getECunBaoInfoData("���ձ���");
		String waitInterestNumStrByECB = yCBPage.getECunBaoInfoData("������Ϣ");
		String waitEachNumStrByECB = yCBPage.getECunBaoInfoData("���ձ���");
		
		double waitPrincipalNumDouByECB = yCBPage.getColumnSumByPartake("�����ܽ��");
		double waitInterestNumDouByECB = base.subtract(yCBPage.getColumnSumByPartake("Ԥ��������"), yCBPage.getColumnSumByPartake("�ѻ�������"));
		double waitEachNumByDouECB = yCBPage.getColumnSumByPartake("Ͷ���ܱ���");
	
		//��汦�����ձ��� = �����У��������ܽ�֮�ͣ�
		base.assertEqualsActualExpected(waitPrincipalNumStrByECB, base.appendZero(String.valueOf(waitPrincipalNumDouByECB)));
		//��汦��������Ϣ�� = �����У���Ԥ�������桱֮�� - ���ѻ������桱��
		base.assertEqualsActualExpected(waitInterestNumStrByECB, base.appendZero(String.valueOf(waitInterestNumDouByECB)));
		//��汦�����ձ����� = �����У���Ͷ���ܱ�����֮�ͣ�
		base.assertEqualsActualExpected(waitEachNumStrByECB + ".0", String.valueOf(waitEachNumByDouECB));

		//�˻����������������顰�˻����ʲ�����ɢ����ձ��� + ��汦���ձ��� + ������Ϣ + ������� + �����
		//�˻������� ��ɢ����ձ��� = ɢ��Ͷ���� �����ձ���
		//�˻������� ����汦���ձ��� = ��汦�� �����ձ���
		myAccountPage.turnToMyAccount("�˻�����");
		base.sleep(2000);
		//�˻������С��˻����ʲ���
		String totalAssetsNum = myAccountPage.getMoneyNum(myAccountPage.NumberinTotalAssets); 
		//�˻������� ��������Ϣ�� = ɢ��Ͷ���С�������Ϣ�� + ��汦�С�������Ϣ��
		String waitInterestNum = base.add(Double.valueOf(waitInterestNumStrByLend), Double.valueOf(waitInterestNumStrByECB)) + "";
		waitInterestNum = base.appendZero(waitInterestNum);
		//�˻������� �������� �޷�У��ʴ�ҳ���ȡ
		String availableBalanceNum = String.valueOf(base.doubleFormat(myAccountPage.getBalance()));
		availableBalanceNum = base.appendZero(availableBalanceNum);
		//������
		String frozenMoneyNum = myAccountPage.getMoneyNum(myAccountPage.NumberinFrozenMoney);
		
		//�˻������� ������� �����ʽ���ϸ�� �������֮��
		myAccountPage.clickFreezingStatisticsImg();
		String frozenMoneyNumByMA = myAccountPage.getFreezeMoneySum(myAccountPage.getFreezingStatistics("������")) + "";
		frozenMoneyNumByMA = base.appendZero(frozenMoneyNumByMA);
		myAccountPage.clickCloseFreezeLnk();
		base.assertEqualsActualExpected(frozenMoneyNum, frozenMoneyNumByMA);
		//�˻����ʲ���ϸ��Ϣ
		List<String> assetsList = myAccountPage.getAssets();
		myAccountPage.checkAssets(assetsList, waitPrincipalNumStrByLend, waitPrincipalNumStrByECB, waitInterestNum, availableBalanceNum, frozenMoneyNum, totalAssetsNum);
	}
	
	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void checkCancelIDCardInvestECunBao_F_4673(){
		
		Reporter.log("��汦Ͷ��_P1:ע�������֤��Ͷ����汦</br>");
		System.out.println("��汦Ͷ��_P1:ע�������֤��Ͷ����汦");
		
		String buyShareNum = "1";//�������
		String money = "100";
		base.logout();
		loginPage.loginByMyAccount(cancel_Tel, cancel_Pass);
		TotalPage.openPage("��ҳ", true);
		eCunBaoPage.immediatelyInvestment(buyShareNum, cancel_PayPass);
		TotalPage.openPage("��汦�б�ҳ", true);
		eCunBaoPage.qiangTou(money);
	}
	
	
	/*****************************************************/
	/******************     ��汦_������            *****************/
	/*****************************************************/
	
	@Test(priority = 5, dataProvider = "user", enabled = true)
	public void checkDownloadFinancialAgreement_F_1320_1366_1367_1368(String tel, String name, String pass, String payPass){

		Reporter.log("��汦Ͷ��_P1:�ҵ��˻�����>��汦ҳ����>�����С���>��ͨ�û�/VIP1.0/VIP1.5/�����˻��鿴��汦����");
	
		if(name.equals("��Ө") || name.equals("��Өһ") || name.equals("��Ө��") || name.equals("���д�")){
			creditorDetails = creditorDetails_chient;
		}
		else if(name.equals("����֮") || name.equals("������") || name.equals("�Թ�֥")){
			creditorDetails = creditorDetails_test;
		}
		
		if(base.Windowsize() != 1){
			base.closeAndjumptoOldWindow();
		}
		
		base.logout();
		loginPage.loginByMyAccount(tel, pass);
		
		//��汦��������У�顰���ձ��𡱡���������Ϣ���������ձ�����
		myAccountPage.turnToMyAccount("��汦");
		//����������С�
		yCBPage.clickPartake();
		yCBPage.checkPartake();
		yCBPage.clickAppointViewDetails(day);
		yCBPage.checkViewDetails(day);
		yCBPage.checkViewDetailsByValue(eCunBaoName);
		//У�顰ծȨ���顱�б���Ϣ
		yCBPage.checkCreditorDetails(eCunBaoName, creditorDetails);
		//У�顰���Э�顱����PDF
		yCBPage.checkFinanceAgreementByOld(eCunBaoName);
	}
	
	/*****************************************************/
	/****************** ��汦_�����Ͷ����汦    *****************/
	/*****************************************************/
	
	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4888(){
		Reporter.log("��汦_�����Ͷ����汦_P1:δ�������Ͷ����汦</br>");
		System.out.println("��汦_�����Ͷ����汦_P1:δ�������Ͷ����汦</br>");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//�������
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[0], jieKuanRen_Pass[0]);
			TotalPage.openPage("��ҳ", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("��汦�б�ҳ", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4889(){
		Reporter.log("��汦_�����Ͷ����汦_P1����������еĽ��Ͷ����汦</br>");
		System.out.println("��汦_�����Ͷ����汦_P1����������еĽ��Ͷ����汦");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//�������
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[1], jieKuanRen_Pass[1]);
			TotalPage.openPage("��ҳ", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("��汦�б�ҳ", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4890(){
		Reporter.log("��汦_�����Ͷ����汦_P1:������Ͷ����汦</br>");
		System.out.println("��汦_�����Ͷ����汦_P1:������Ͷ����汦");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//�������
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[2], jieKuanRen_Pass[2]);
			TotalPage.openPage("��ҳ", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("��汦�б�ҳ", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 9, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4891(){
		Reporter.log("��汦_�����Ͷ����汦_P1:һ�ν���ѻ����Ͷ����汦</br>");
		System.out.println("��汦_�����Ͷ����汦_P1:һ�ν���ѻ����Ͷ����汦");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//�������
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[3], jieKuanRen_Pass[3]);
			TotalPage.openPage("��ҳ", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("��汦�б�ҳ", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 10, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4892(){
		Reporter.log("��汦_�����Ͷ����汦_P1:��ν��û�����ڼ�¼Ͷ����汦</br>");
		System.out.println("��汦_�����Ͷ����汦_P1:��ν��û�����ڼ�¼Ͷ����汦");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//�������
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[4], jieKuanRen_Pass[4]);
			TotalPage.openPage("��ҳ", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("��汦�б�ҳ", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 11, enabled = true, invocationCount = 1)
	public void checkBorrowerInvestmentECunBao_1_F_4893(){
		Reporter.log("��汦_�����Ͷ����汦_P1:�����Ͷ����汦</br>");
		System.out.println("��汦Ͷ��_P1:�����Ͷ����汦");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String buyShareNum = "1";//�������
			String money = "100";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[5], jieKuanRen_Pass[5]);
			TotalPage.openPage("��ҳ", true);
			eCunBaoPage.immediatelyInvestment(buyShareNum, jieKuanRen_PayPass);
			TotalPage.openPage("��汦�б�ҳ", true);
			eCunBaoPage.qiangTou(money);
		}
	}
	
	@Test(priority = 12, enabled = true, invocationCount = 1)
	public void checkcheckBorrowerInvestmentECunBao_F_4895(){
		
		Reporter.log("��汦_�����Ͷ����汦_P1:���ڽ������Ͷ����汦</br>");
		System.out.println("��汦Ͷ��_P1:���ڽ������Ͷ����汦");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			String msg = "��Ǹ���������Ľ����������ڣ��˻������ᣬ���Ȼ�����ִ�д˲���!";
			base.logout();
			loginPage.loginByMyAccount(jieKuanRen_Tel[6], jieKuanRen_Pass[6]);
			TotalPage.openPage("��ҳ", true);
			eCunBaoPage.checkImmediatelyInvestmentErrorMsg(msg);
			TotalPage.openPage("��汦�б�ҳ", true);
			eCunBaoPage.checkQiangTouBtnErrorMsg(msg);
		}
	}
	
	/*****************************************************/
	/******************    ��汦_���Ա�           *****************/
	/*****************************************************/
	
	@Test(priority = 13, enabled = true, invocationCount = 1)
	public void checkInterestEarned_F_1323(){
		
		Reporter.log("��汦_���ȶ�_P1:Ͷ����汦��鿴���н��䶯</br>");
		System.out.println("��汦_���ȶ�_P1:Ͷ����汦��鿴���н��䶯");
		
		String money = "100";
		base.logout();
		loginPage.loginByMyAccount(jinErDuiBi_Tel, jinErDuiBi_Pass);
		TotalPage.openPage("��汦�б�ҳ", true);
		eCunBaoPage.qiangTou(money);
		
		TotalPage.openPage("�ҵ��˻�", true);
		String yesterdayTotalIncomeByMA = myAccountPage.getMoneyNum(myAccountPage.YCBEarnInterestNum);//�ҵ��˻�->�˻�����->��׬��Ϣ
		System.out.println("�ҵ��˻�->�˻�����->��׬��Ϣ: " + yesterdayTotalIncomeByMA);
		myAccountPage.turnToMyAccount("��汦");
		String yesterdayTotalIncomeByECB = yCBPage.getECunBaoInfoData("��׬��Ϣ");//�ҵ��˻�->��汦->��׬��Ϣ
		System.err.println("�ҵ��˻�->��汦->��׬��Ϣ: " + yesterdayTotalIncomeByECB);
		TotalPage.openPage("��汦�б�ҳ", true);
		String accumulatedIncomeBy = eCunBaoPage.getBannerData("�ۼ�����");//��汦�б�ҳ->banner->�ۼ�����
		System.out.println("�ۼ�����: " + accumulatedIncomeBy);
	}
	
	/*****************************************************/
	/******************    ��汦_VIP����          *****************/
	/*****************************************************/
	
	
	/*****************************************************/
	/*************    ��汦_VIP����_ҳ��Vͼ�����          ************/
	/*****************************************************/
	
	@Test(priority = 14, enabled = true, invocationCount = 1, dataProvider = "VIP")
	public void checkVIPIconByMyAccount_F_4028(String tel, String pass, String rate){
		
		Reporter.log("��汦_VIP����_ҳ��Vͼ�����_P1:�˻�����ҳ���Vͼ��</br>");
		System.out.println("��汦_VIP����_ҳ��Vͼ�����_P1:�˻�����ҳ���Vͼ��");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			base.logout();
			loginPage.loginByMyAccount(tel, pass);
			TotalPage.openPage("�ҵ��˻�", true);
			myAccountPage.checkUserIconMsgByOne("VIP", rate);
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			Reporter.log("test������û�����ݣ����ֹ�����");
			System.out.println("test������û�����ݣ����ֹ�����");
		}
	}
	
	@Test(priority = 15, enabled = true, invocationCount = 1, dataProvider = "VIP")
	public void checkVIPIconByHomePage_F_4029(String tel, String pass, String rate){
		
		Reporter.log("��汦_VIP����_ҳ��Vͼ�����_P1:��ҳͶ�ʴ���ҳ���Vͼ��</br>");
		System.out.println("��汦_VIP����_ҳ��Vͼ�����_P1:��ҳͶ�ʴ���ҳ���Vͼ��");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			base.logout();
			loginPage.loginByMyAccount(tel, pass);
			TotalPage.openPage("��ҳ", true);
			List<String> strLists = indexPage.getECunBaoCellDataStr("�껯����");
			indexPage.checkAnnualReturns(strLists, rate);
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			Reporter.log("test������û�����ݣ����ֹ�����");
			System.out.println("test������û�����ݣ����ֹ�����");
		}
	}
	
	@Test(priority = 16, enabled = true, invocationCount = 1, dataProvider = "VIP")
	public void checkVIPIconByECunBaoPage_F_4030(String tel, String pass, String rate){
		
		Reporter.log("��汦_VIP����_ҳ��Vͼ�����_P1:�����汦��ҳ�����ʵ���ʾ</br>");
		System.out.println("��汦_VIP����_ҳ��Vͼ�����_P1:�����汦��ҳ�����ʵ���ʾ");
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			base.logout();
			loginPage.loginByMyAccount(tel, pass);
			TotalPage.openPage("��汦�б�ҳ", true);
			eCunBaoPage.checkECunBaoInfoByVIP(rate);
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			Reporter.log("test������û�����ݣ����ֹ�����");
			System.out.println("test������û�����ݣ����ֹ�����");
		}
	}
	
	/*****************************************************/
	/***********  ��汦_VIP����_��ɢͶ�ʺϲ���Ϣ������        ***********/
	/*****************************************************/
	
	@Test(priority = 17, enabled = true, invocationCount = 1)
	public void checkbuyECunBaoAccrualAndCount_F_4048(){
		
		Reporter.log("��汦_VIP����_��ɢͶ�ʺϲ���Ϣ������_P1:��ͨ�û���ɢͶ�ʺϲ���Ϣ������</br>");
		System.out.println("��汦_VIP����_��ɢͶ�ʺϲ���Ϣ������_P1:��ͨ�û���ɢͶ�ʺϲ���Ϣ������");
		
		String eCunBaoName = "auto"; 		//��汦����
		String amount = "1000";				//������
		String rate = "0.125";				//��������
		String validity = "1";				//������Ч�ڣ�Сʱ��
		String limit = "3";					//��Լ���ޣ��죩
		String createData = "";				//��������
		String publishedDate = "";			//��������
		String accrualData = "";			//��Ϣ����
		String repaymentData = "";			//��������
		String investSumBefore = "";		//Ͷ���ܱ���
		String investSumAfter = "";
		String addSumBefore = ""; 			//�����ܽ��
		String addSumAfter = "";
		String eCunBaoID = "";				//��汦ID
		String money = "100";				//������汦Ǯ��
		String addBefore = "";				//������
		String addAfter = "";				
		String anticipatedIncome = "";//Ԥ������
		
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
		
			eCunBaoName = eCunBaoName + base.dateFormat(new Date(), "MMddHHmmss");
			createData = publishedDate = base.getTimeStamp();
			accrualData = eCunBaoPage.calculateAccrualData(publishedDate, validity);
			repaymentData = eCunBaoPage.calculateRepaymentData(accrualData, limit);	
			
			base.logout();
			eCunBaoPage.checkPublishECaoBao(eCunBaoName, amount, rate, validity, limit, createData, publishedDate, accrualData, repaymentData);
			loginPage.loginByMyAccount(normalInterestAccrual_Tel, normalInterestAccrual_Pass);
			TotalPage.openPage("�ҵ��˻�", true);
			myAccountPage.turnToMyAccount("��汦");
			myAccountPage.isGoMyAccount("��汦");
			yCBPage.clickPartake();
			investSumBefore = yCBPage.getPartakeValue(limit, "Ͷ���ܱ���");
			investSumBefore = yCBPage.formatInvestSum(investSumBefore);
			addSumBefore = yCBPage.getPartakeValue(limit, "�����ܽ��");
			addSumBefore = base.removeComma(addSumBefore);
			addSumBefore = base.removeZero(addSumBefore);
			System.out.println("Ͷ���ܱ�����Ͷ��ǰ��:" + investSumBefore + " �ʣ������ܽ�Ͷ��ǰ��:" + addSumBefore + " Ԫ");
			Reporter.log("Ͷ���ܱ�����Ͷ��ǰ��:" + investSumBefore + " �ʣ������ܽ�Ͷ��ǰ��:" + addSumBefore + " Ԫ");
			
			//�״ι�����汦
			TotalPage.openPage("��汦�б�ҳ", true);
			eCunBaoID = eCunBaoPage.getProductIDByECunBaoTitle(eCunBaoName);
			eCunBaoPage.qiangTou(eCunBaoID, money);
			
			//�״�У�顰Ͷ���ܱ���������Ͷ���ܽ�
			myAccountPage.turnToMyAccount("��汦");
			myAccountPage.isGoMyAccount("��汦");
			yCBPage.clickPartake();
			investSumAfter = yCBPage.getPartakeValue(limit, "Ͷ���ܱ���");
			investSumAfter = yCBPage.formatInvestSum(investSumAfter);
			addSumAfter = yCBPage.getPartakeValue(limit, "�����ܽ��");
			addSumAfter = base.removeComma(addSumAfter);
			addSumAfter = base.removeZero(addSumAfter);
			System.out.println("Ͷ���ܱ�����Ͷ�ʺ�:" + investSumAfter + " �ʣ������ܽ�Ͷ�ʺ�:" + addSumAfter + " Ԫ");
			Reporter.log("Ͷ���ܱ�����Ͷ�ʺ�:" + investSumAfter + " �ʣ������ܽ�Ͷ�ʺ�:" + addSumAfter + " Ԫ");
			base.assertEqualsActualExpected(investSumAfter, (Integer.parseInt(investSumBefore) + 1) + "");
			base.assertEqualsActualExpected(addSumAfter, (Integer.parseInt(addSumBefore) + Integer.parseInt(money)) + "");
			investSumBefore = investSumAfter;
			addSumBefore = addSumAfter;
			
			//�״�У�顰���������Ԥ�����桱
			yCBPage.clickAppointViewDetails(limit);
			base.assertTrueByBoolean(TotalPage.isSearchFieldByList(yCBPage.getViewDetailsBy("Ͷ������"), eCunBaoName));
			addBefore = yCBPage.getViewDetailsValue(eCunBaoName, "������");
			addBefore = base.removeComma(addBefore);
			addBefore = base.removeZero(addBefore);
			anticipatedIncome = yCBPage.getViewDetailsValue(eCunBaoName, "Ԥ������");
			System.out.println("�����Ͷ��ǰ��:" + addBefore + " Ԫ��Ԥ�����棨Ͷ��ǰ��:" + anticipatedIncome + " Ԫ");
			Reporter.log("�����Ͷ��ǰ��:" + addBefore + " Ԫ��Ԥ�����棨Ͷ��ǰ��:" + anticipatedIncome + " Ԫ");
			base.assertEqualsActualExpected(addBefore, money);
			base.assertEqualsActualExpected(anticipatedIncome, eCunBaoPage.calculateECunBaoIncome(money, rate, limit));
			
			//���ι�����汦
			TotalPage.openPage("��汦�б�ҳ", true);
			eCunBaoPage.qiangTou(eCunBaoID, money);
			
			//����У�顰Ͷ���ܱ���������Ͷ���ܽ�
			myAccountPage.turnToMyAccount("��汦");
			myAccountPage.isGoMyAccount("��汦");
			yCBPage.clickPartake();
			investSumAfter = yCBPage.getPartakeValue(limit, "Ͷ���ܱ���");
			investSumAfter = yCBPage.formatInvestSum(investSumAfter);
			addSumAfter = yCBPage.getPartakeValue(limit, "�����ܽ��");
			addSumAfter = base.removeComma(addSumAfter);
			addSumAfter = base.removeZero(addSumAfter);
			System.out.println("Ͷ���ܱ���������Ͷ�ʺ�:" + investSumAfter + " �ʣ������ܽ�����Ͷ�ʺ�: " + addSumAfter + " Ԫ");
			Reporter.log("Ͷ���ܱ���������Ͷ�ʺ�:" + investSumAfter + " �ʣ������ܽ�����Ͷ�ʺ�: " + addSumAfter + " Ԫ");
			base.assertEqualsActualExpected(investSumAfter, investSumBefore);
			base.assertEqualsActualExpected(addSumAfter, (Integer.parseInt(addSumBefore) + Integer.parseInt(money)) + "");
			
			//����У�顰���������Ԥ�����桱
			yCBPage.clickAppointViewDetails(limit);
			base.assertTrueByBoolean(TotalPage.isSearchFieldByList(yCBPage.getViewDetailsBy("Ͷ������"), eCunBaoName));
			addAfter = yCBPage.getViewDetailsValue(eCunBaoName, "������");
			addAfter = base.removeComma(addAfter);
			addAfter = base.removeZero(addAfter);
			anticipatedIncome = yCBPage.getViewDetailsValue(eCunBaoName, "Ԥ������");
			System.out.println("�����Ͷ�ʺ�:" + addAfter + " Ԫ��Ԥ�����棨Ͷ�ʺ�:" + anticipatedIncome + " Ԫ");
			Reporter.log("�����Ͷ�ʺ�:" + addAfter + " Ԫ��Ԥ�����棨Ͷ�ʺ�:" + anticipatedIncome + " Ԫ");
			base.assertEqualsActualExpected(addAfter, (Integer.parseInt(addBefore) + Integer.parseInt(money)) + "");
			base.assertEqualsActualExpected(anticipatedIncome, eCunBaoPage.calculateECunBaoIncome(addAfter, rate, limit));
		}
		else{
			Reporter.log("error_�������������ֶ�����!");
			System.out.println("error_�������������ֶ�����!");
		}
	}
}






