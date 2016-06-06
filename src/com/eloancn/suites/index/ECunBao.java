package com.eloancn.suites.index;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.RegisterPage;

/**
 * ��ҳ����汦������
 * @author ������
 */
public class ECunBao {

	Base base = new Base();
	Data data = new Data();
	DBData dbData = new DBData();
	
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	RegisterPage registerPage = new RegisterPage();
	
	String name,pass,payPass;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			name = Data.tel_run_EcunBao;
    		pass = Data.password;
			payPass = Data.zzmm;
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			name = Data.test2_tel;
    		pass = Data.test2_password;
			payPass = Data.test2_zzmm;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test (priority = 1, enabled = true)
	public void checkECunBaoHomeData_AT_589(){
		
		Reporter.log("��ҳ����汦���ݡ���>У��1�������ʾ4����汦   2���Ȱ�״̬����:δ�����������Ϸ����ٰ�ʱ�䵹������<br/>");
		System.out.println("��ҳ����汦���ݡ���>У��1�������ʾ4����汦   2���Ȱ�״̬����:δ�����������Ϸ����ٰ�ʱ�䵹������");
		List<String> frontPageTitleList = new ArrayList<String>();
		List<String> databasesTitleList = new ArrayList<String>();
		int rowNum = 3,cellNum = 1;//����������
		if(!loginPage.isLogout()){
			base.logout();//�ǳ�
		}
		base.isTitle(PageTitles.shouYe);
		//����������ҳ�����ݿ���ʾ�Ƿ�һ�£��Ƿ�����
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			//��ȡ��汦��ҳTitle
			frontPageTitleList = indexPage.getECunBaoHomeDataAll(rowNum,cellNum-1);
			//��ȡ��汦���ݿ�Title
			databasesTitleList = dbData.getECunBaoTitleTopFour();
			//У����ҳTitle �� ���ݿ�Title �����Ƿ�һ��
			indexPage.checkECunBaoHomeTitle(frontPageTitleList, databasesTitleList);
		}
		//�������ҳ�Ƿ���ʾ4������
		else if(base.indexURL.contains("www") || base.indexURL.contains("test")){
			//��ȡ��汦��ҳTitle
			frontPageTitleList = indexPage.getECunBaoHomeDataAll(rowNum,cellNum-1);
			//��֤�Ƿ���ʾ4������
			indexPage.checkECunBaoDataNum(frontPageTitleList);
		}
	}

	@Test (priority = 2, enabled = true)
	public void checkECunBaoTitle_AT_589(){
		
		Reporter.log("��ҳ����汦���ݡ���>У�顰���⡱�����껯���桱������Լ���ޡ�������ļ����������ļ��������汦�б�ҳ����Ӧ��������һ��<br/>");
		System.out.println("��ҳ����汦���ݡ���>У�顰���⡱�����껯���桱������Լ���ޡ�������ļ����������ļ��������汦�б�ҳ����Ӧ��������һ��");
		List<String> HomeDataOneList = new ArrayList<String>();
		List<String> eCunBaoDataOneList = new ArrayList<String>();
		String id = "";
		base.openBrowser(base.indexURL);
		if(!loginPage.isLogout()){
			base.logout();//�ǳ�
		}
		base.isTitle(PageTitles.shouYe);
		id = indexPage.getECunBaoHomeDataOneId();
		//��ȡ��ҳ��汦���������
		HomeDataOneList = indexPage.getECunBaoHomeDataOne(5);
		//��ת������汦��ҳ��
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		//��ȡ�б�ҳ��汦���������
		eCunBaoDataOneList = eCunBaoPage.getECunBaoDataOne(id);
		indexPage.checkECunBaoDataOne(HomeDataOneList, eCunBaoDataOneList);
		Reporter.log("��汦��ҳ���б�ҳ�ġ���ļ�����޷�У�飬���ֶ�����<br/>");
		System.out.println("��汦��ҳ���б�ҳ�ġ���ļ�����޷�У�飬���ֶ�����");
	}
	
	@Test (priority = 3, enabled = true)
	public void checkPopupWindow_AT_590(){
		
		Reporter.log("��ҳ����汦����_δ��¼����>1.���������Ͷ�ʡ���ť�͡�Ͷһ�ʡ���ť����>У���Ƿ񵯳���¼����<br/>");
		System.out.println("��ҳ����汦����_δ��¼����>1.���������Ͷ�ʡ���ť�͡�Ͷһ�ʡ���ť����>У���Ƿ񵯳���¼����");
		base.openBrowser(base.indexURL);
		if(!loginPage.isLogout()){
			base.logout();//�ǳ�
		}
		base.isTitle(PageTitles.shouYe);
		//��Ͷһ�ʡ���ť��Table�е�λ�ã�1~3��6��
		int rowNum = 1,cellNum = 6;
		//���������Ͷ�ʡ���ť
		if(indexPage.isInvestmentBtn()){
			indexPage.clickInvestmentBtn();
			indexPage.checkLoginTitle();
		}else{
			System.out.println("error_��ҳ��汦_'����Ͷ��'��ť�޷����");
			Reporter.log("error_��ҳ��汦_'����Ͷ��'��ť�޷����");
		}
		//��ȡ��Ͷһ�ʡ���ť
		WebElement AnIinvestmentBtn = indexPage.getAnIinvestmentBtn(rowNum, cellNum-1);
		//�����Ͷһ�ʡ���ť����
		if(AnIinvestmentBtn!=null){
			//�����Ͷһ�ʡ���ť
			indexPage.clickAnIinvestmentBtn(AnIinvestmentBtn);
			indexPage.checkLoginTitle();
		}
	}

	@Test (priority = 4, enabled = true)
	public void checkFunction_AT_591(){
		
		Reporter.log("��ҳ����汦����_�ѵ�¼����>1.�����ծȨ���顱��2.��������ң�������֡���3.���������Ͷ�ʡ���ť��4.�����Ͷһ�ʡ���ť��5.������鿴������汦��Ŀ����У��������Ƿ���ȷ<br/>");
		System.out.println("��ҳ����汦����_�ѵ�¼����>1.�����ծȨ���顱��2.��������ң�������֡���3.���������Ͷ�ʡ���ť��4.�����Ͷһ�ʡ���ť��5.������鿴������汦��Ŀ����У��������Ƿ���ȷ");
		//��Ͷһ�ʡ���ť��Table�е�λ�ã�1~3��6��
		int rowNum = 1,cellNum = 6;
		//���µ�¼
		loginPage.reLogin(name, pass);
		//��ø����ھ��
		String CurrentWindowHandleString = base.getCurrentWindowHandle();
		//��������ң�������֡�
		indexPage.clickRedEnvelopesLink();
		//��� ������������ֹ��򡱴���
		indexPage.checkRedEnvelopesTitle();
		//���������Ͷ�ʡ���ť
		if(indexPage.isInvestmentBtn()){
			indexPage.clickInvestmentBtn();
			indexPage.checkInvestmentTitle();
		}else{
			System.out.println("error_��ҳ��汦_'����Ͷ��'��ť�޷����");
			Reporter.log("error_��ҳ��汦_'����Ͷ��'��ť�޷����");
		}
		
		//��ȡ��Ͷһ�ʡ���ť
		WebElement AnIinvestmentBtn = indexPage.getAnIinvestmentBtn(rowNum, cellNum-1);
		//�жϡ�Ͷһ�ʡ���ť�Ƿ����
		if(AnIinvestmentBtn!=null){
			//�����Ͷһ�ʡ���ť
			indexPage.clickAnIinvestmentBtn(AnIinvestmentBtn);
			//��� ����Ͷ�ʴ���
			indexPage.checkInvestmentTitle();
		}
		//������鿴������汦��Ŀ��
		indexPage.clickMoreLink();
		//����������汦��Ͷ���б�ҳ
		indexPage.checkInvestmentListTitle(CurrentWindowHandleString);
	}
	
	@Test (priority = 5, enabled = true)
	public void checkInvestment_AT_592(){
		
		Reporter.log("��ҳ����汦���ܡ���>���������Ͷ�ʡ���ť����>У��Ͷ���Ƿ�ɹ�<br/>");
		System.out.println("��ҳ����汦���ܡ���>���������Ͷ�ʡ���ť����>У��Ͷ���Ƿ�ɹ�");
		//������ݶ
		String buyShareNum = "1";

		//���µ�¼
		loginPage.reLogin(name, pass);
		base.isTitle(PageTitles.shouYe);
		eCunBaoPage.immediatelyInvestment(buyShareNum,payPass);
		
	}
	
	@Test(priority = 6, enabled = true)
	public void checkBondDetails_AT_5266(){
		
		Reporter.log("��ҳ����汦����>1.��һ����汦�ġ�ծȨ���顱��ť�Ƿ���ʾ�������ť�������Ƿ��<br/>");
		Reporter.log("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����<br/>");
		Reporter.log("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ<br/>");
		Reporter.log("4.�ٴε�����鿴���顱��ť��������ر�<br/>");
		Reporter.log("5.����رհ�ť�����ڹر�<br/>");
		System.out.println("��ҳ����汦����>1.��һ����汦�ġ�ծȨ���顱��ť�Ƿ���ʾ�������ť�������Ƿ��");
		System.out.println("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����");
		System.out.println("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ");
		System.out.println("4.�ٴε�����鿴���顱��ť��������ر�");
		System.out.println("5.����رհ�ť�����ڹر�");
		
		if(loginPage.ifLogin()){//��¼
			base.logout();
		}
		loginPage.homeLogin(name, pass);

		indexPage.clickECunBaoDataHomeZhaiQuanOne();
		indexPage.checkECBBondDetailsDIVColumnName();
		indexPage.checkECBBondDetailsDIVColumnValue("������");
		indexPage.checkECBBondDetailsDIVColumnValue("���������");
		indexPage.checkECBBondDetailsDIVColumnValue("���֤��");
		indexPage.checkECBBondDetailsDIVColumnValue("����");
		indexPage.checkBondDetails();
	}
	
	@Test(priority = 7, enabled = true)
	public void checkBondDetails_AT_5271(){
		
		Reporter.log("��ҳ����汦����>1.��һ����汦�ġ�����Ͷ�ʡ�����>�����ծȨ���顱���ӣ������Ƿ��<br/>");
		Reporter.log("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����<br/>");
		Reporter.log("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ<br/>");
		Reporter.log("4.�ٴε�����鿴���顱��ť��������ر�<br/>");
		Reporter.log("5.����رհ�ť�����ڹر�<br/>");
		System.out.println("��ҳ����汦����>1.��һ����汦�ġ�ծȨ���顱��ť�Ƿ���ʾ�������ť�������Ƿ��");
		System.out.println("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����");
		System.out.println("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ");
		System.out.println("4.�ٴε�����鿴���顱��ť��������ر�");
		System.out.println("5.����رհ�ť�����ڹر�");
		
		if(loginPage.ifLogin()){//��¼
			base.logout();
		}
		loginPage.homeLogin(name, pass);

		if(indexPage.isInvestmentBtn()){
			indexPage.clickInvestmentBtn();
			if(base.isElementContainsValue2(By.cssSelector("#fastLender_1"), "style", "block")){
				indexPage.clickInvestmentBondDetails();
				indexPage.checkECBBondDetailsDIVColumnName();
				indexPage.checkECBBondDetailsDIVColumnValue("������");
				indexPage.checkECBBondDetailsDIVColumnValue("���������");
				indexPage.checkECBBondDetailsDIVColumnValue("���֤��");
				indexPage.checkECBBondDetailsDIVColumnValue("����");
				indexPage.checkBondDetails();
			}
			else{
				indexPage.checkInvestmentTitle();
			}

		}else{
			System.out.println("error_��ҳ��汦_'����Ͷ��'��ť�޷����");
			Reporter.log("error_��ҳ��汦_'����Ͷ��'��ť�޷����");
		}
	}
	
	@Test(priority = 8, enabled = true)
	public void checkBondDetails_AT_5267(){
		
		Reporter.log("��ҳ����汦����>1.��2~4����汦�����ծȨ���顱���ӣ������Ƿ��<br/>");
		Reporter.log("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����<br/>");
		Reporter.log("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ<br/>");
		Reporter.log("4.�ٴε�����鿴���顱��ť��������ر�<br/>");
		Reporter.log("5.����رհ�ť�����ڹر�<br/>");
		System.out.println("��ҳ����汦����>1.��һ����汦�ġ�ծȨ���顱��ť�Ƿ���ʾ�������ť�������Ƿ��");
		System.out.println("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����");
		System.out.println("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ");
		System.out.println("4.�ٴε�����鿴���顱��ť��������ر�");
		System.out.println("5.����رհ�ť�����ڹر�");
		
		indexPage.clickECunBaoDataTFBondLink();
		indexPage.checkECBBondDetailsDIVColumnName();
		indexPage.checkECBBondDetailsDIVColumnValue("������");
		indexPage.checkECBBondDetailsDIVColumnValue("���������");
		indexPage.checkECBBondDetailsDIVColumnValue("���֤��");
		indexPage.checkECBBondDetailsDIVColumnValue("����");
		indexPage.checkBondDetails();
	}
	
	@Test(priority = 9, enabled = true)
	public void checkBondDetails_AT_5268(){
		
		Reporter.log("��ҳ����汦����>1.��2~4����汦��Ͷһ�ʡ���ť���ٵ����ծȨ���顱���ӣ������Ƿ��<br/>");
		Reporter.log("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����<br/>");
		Reporter.log("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ<br/>");
		Reporter.log("4.�ٴε�����鿴���顱��ť��������ر�<br/>");
		Reporter.log("5.����رհ�ť�����ڹر�<br/>");
		System.out.println("��ҳ����汦����>1.��һ����汦�ġ�ծȨ���顱��ť�Ƿ���ʾ�������ť�������Ƿ��");
		System.out.println("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����");
		System.out.println("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ");
		System.out.println("4.�ٴε�����鿴���顱��ť��������ر�");
		System.out.println("5.����رհ�ť�����ڹر�");
		
		if(loginPage.ifLogin()){//��¼
			base.logout();
		}
		loginPage.homeLogin(name, pass);
		if(indexPage.isAnIinvestmentBtn()){
			indexPage.clickAnIinvestmentBtn();
			indexPage.clickInvestmentBondDetails();
			indexPage.checkECBBondDetailsDIVColumnName();
			indexPage.checkECBBondDetailsDIVColumnValue("������");
			indexPage.checkECBBondDetailsDIVColumnValue("���������");
			indexPage.checkECBBondDetailsDIVColumnValue("���֤��");
			indexPage.checkECBBondDetailsDIVColumnValue("����");
			indexPage.checkBondDetails();
		}
	}
}
