package com.eloancn.suites.index;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;

public class ECunBao_P1 {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	IndexPage indexPage = new IndexPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
	String tel = Data.tel_eCunBao_P1;
	String password = Data.password;
	String zzmm = Data.zzmm;
	double balance = 99;//�˻����
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_tel;
			password = Data.test_password;
			zzmm = Data.test_zzmm;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * ����Ԫ
	 * ��ҳ�ѵ�¼ Ͷһ�� ����Ͷ��
	 */
	@Test(priority = 1)
	public void indexTouYiBi_web_928_2(){
		Reporter.log("��汦P1����ҳ�ѵ�¼��Ͷһ�ʡ�����Ͷ��������������Ͷ��<br/>");
		//��ȡ�˻��������
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		try {
			balance = myAccountPage.getBalance();
		} catch (Exception e) {
		}
		
		base.openBrowser(base.indexURL);
		base.sleep(2000);
		//Ͷһ��
		System.out.println("��ҳ��汦��Ͷһ�� ����");
		Reporter.log("��ҳ��汦��Ͷһ�� ����<br/>");
		eCunBaoPage.touYiBi("1",zzmm,0,balance);
		//����Ͷ��
		System.out.println("��ҳ��汦������Ͷ�� ����");
		Reporter.log("��ҳ��汦������Ͷ�� ����<br/>");
		eCunBaoPage.maShangTouZi("1",zzmm,0,balance);
	}
	
	/**
	 * ����Ԫ
	 * ��ҳ�ѵ�¼  У���Զ����빦��
	 */
	@Test(priority = 2)
	public void indexTouYiBiAutoInput_web_928_1(){
		Reporter.log("��汦P1����ҳ�ѵ�¼��Ͷһ�ʡ�����Ͷ�����������Զ����� ��������<br/>");
		base.logout();
		//��ȡ�˻��������
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		try {
			balance = myAccountPage.getBalance();
		} catch (Exception e) {
		}
				
		base.openBrowser(base.indexURL);
		//Ͷһ��  �Զ�����
		System.out.println("��ҳ��汦��Ͷһ�� �Զ����� ����");
		Reporter.log("��ҳ��汦��Ͷһ�� �Զ����� ����<br/>");
		eCunBaoPage.touYiBi("0",zzmm,1,balance);
		//����Ͷ��  �Զ�����
		System.out.println("��ҳ��汦������Ͷ�� �Զ����� ����");
		Reporter.log("��ҳ��汦������Ͷ�� �Զ����� ����<br/>");
		eCunBaoPage.maShangTouZi("0",zzmm,1,balance);
	}
	
	/**
	 * ����Ԫ
	 * ��ҳ�ѵ�¼  Ͷһ��/����Ͷ�� У���Զ����빦��  �˻�99Ԫ  ����100
	 */
	@Test(priority = 3)
	public void indexTouYiBiAutoInputBalanceIn100_web_928_1(){
		Reporter.log("��汦P1����ҳ�ѵ�¼  Ͷһ��/����Ͷ�� У���Զ����빦��  �˻�99Ԫ  ����100,��ʾ����100�����ܹ���˲�Ʒ<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			
		}else {
			base.logout();
			Reporter.log("��ҳͶһ��/����Ͷ�� У���Զ����빦��  �˻�99Ԫ  ����100<br/>");
			balance = 99;
			tel = Data.run_ECunBao_99;
			base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(tel, password);
			base.openBrowser(base.indexURL);
			base.sleep(2000);
			//Ͷһ��  �Զ�����
			eCunBaoPage.touYiBi("1",zzmm,1,balance);
			//����Ͷ��  �Զ�����
			eCunBaoPage.maShangTouZi("1",zzmm,1,balance);
		}
	}
	
	/**
	 * ����Ԫ
	 * ��ҳ�ѵ�¼  Ͷһ��/����Ͷ��   �˻�99Ԫ  ����100
	 */
	@Test(priority = 4)
	public void indexTouYiBiBalanceIn100_web_928_4and5(){
		Reporter.log("��汦P1����ҳ�ѵ�¼  Ͷһ��/����Ͷ�� ���˻�99Ԫ  ����100������Ͷ��,��ʾ��������<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			
		}else {
			base.logout();
			balance = 99;
			tel = Data.run_ECunBao_99;
			base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(tel, password);
			base.openBrowser(base.indexURL);
			//Ͷһ�� 
			eCunBaoPage.touYiBi("1",zzmm,0,balance);
			//����Ͷ��  
			eCunBaoPage.maShangTouZi("1",zzmm,0,balance);
		}
	}
	
	/**
	 * ����Ԫ
	 * δ��¼ ��� Ͷһ��/����Ͷ��  ������ʾ
	 */
	@Test(priority = 5)
	public void indexTouYiBiNotLogin_web_926(){
		Reporter.log("��汦P1����ҳδ��¼ ��� Ͷһ��/����Ͷ��  ������ʾ<br/>");
		base.logout();
		//Ͷһ�� 
		eCunBaoPage.touYiBi("0",zzmm,0,balance);
		//����Ͷ��
		eCunBaoPage.maShangTouZi("0",zzmm,0,balance);
	}
	
	/**
	 * ����Ԫ
	 * ��ҳͶһ�� δ��Ǯ�û�Ͷ�� ��ע���ֻ��û�,ֱ�ӵ��ȥͶ�� ��ʾ �����ȳ�ֵ��Ͷ��
	 */
	@Test(priority = 6)
	public void indexTouYiBiTiShiChongZhiRegister_web_65_1(){
		Reporter.log("��汦P1����ҳͶһ�� δ��Ǯ�û�Ͷ�� ��ע���ֻ��û�,ֱ�ӵ��ȥͶ�� ��ʾ �����ȳ�ֵ��Ͷ��<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_register;
		}else {
			tel = Data.run_ECunBao_register;
		}
		Reporter.log("��ҳͶһ�� δ��Ǯ�û�Ͷ�� ��ע���ֻ��û�,ֱ�ӵ��ȥͶ�� ��ʾ �����ȳ�ֵ��Ͷ��<br/>");
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		//Ͷһ�� 
		eCunBaoPage.touYiBi("0",zzmm,0,balance);
	}
	
	/**
	 * ����Ԫ
	 * ��ҳͶһ�� δ��Ǯ�û�Ͷ�� ���ֻ��û�,û��ֵ����,ֱ�ӵ��ȥͶ��  ��ʾ �����ȳ�ֵ��Ͷ��
	 */
	@Test(priority = 7)
	public void indexTouYiBiTiShiChongZhiOldTel_web_65_2(){
		Reporter.log("��汦P1����ҳͶһ�� δ��Ǯ�û�Ͷ�� ���ֻ��û�,û��ֵ����,ֱ�ӵ��ȥͶ��  ��ʾ �����ȳ�ֵ��Ͷ��<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_oldtel;
		}else {
			tel = Data.run_ECunBao_oldtel;
		}
		Reporter.log("��ҳͶһ�� δ��Ǯ�û�Ͷ�� ���ֻ��û�,û��ֵ����,ֱ�ӵ��ȥͶ��<br/>");
		base.logout();
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		//Ͷһ�� 
		eCunBaoPage.touYiBi("0",zzmm,0,balance);
	}
	
	/**
	 * ����Ԫ
	 * ��ҳͶһ�� δ��Ǯ�û�Ͷ�� �������û�,û��ֵ����,ֱ�ӵ��ȥͶ��  ��ʾ �����ȳ�ֵ��Ͷ��
	 */
	@Test(priority = 8)
	public void indexTouYiBiTiShiChongZhiOldEmail_web_65_3(){
		Reporter.log("��汦P1����ҳͶһ�� δ��Ǯ�û�Ͷ�� �������û�,û��ֵ����,ֱ�ӵ��ȥͶ��  ��ʾ �����ȳ�ֵ��Ͷ��<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_oldemail;
		}else {
			tel = Data.run_ECunBao_oldemail;
		}
		Reporter.log("��ҳͶһ�� δ��Ǯ�û�Ͷ�� �������û�,û��ֵ����,ֱ�ӵ��ȥͶ��<br/>");
		base.logout();
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		//Ͷһ�� 
		eCunBaoPage.touYiBi("0",zzmm,0,balance);
	}
	
	/**
	 * ����Ԫ
	 * ��ҳ����Ͷ�� δ��Ǯ�û�Ͷ�� ��ע���ֻ��û�,ֱ�ӵ��ȥͶ�� ��ʾ �����ȳ�ֵ��Ͷ��
	 */
	@Test(priority = 9)
	public void indexMaShangTouZiTiShiChongZhiRegister_web_64_1(){
		Reporter.log("��汦P1����ҳ����Ͷ�� δ��Ǯ�û�Ͷ�� ��ע���ֻ��û�,ֱ�ӵ��ȥͶ�� ��ʾ �����ȳ�ֵ��Ͷ��<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_register;
		}else {
			tel = Data.run_ECunBao_register;
		}
		Reporter.log("��ҳ����Ͷ�� δ��Ǯ�û�Ͷ�� ��ע���ֻ��û�,ֱ�ӵ��ȥͶ�� ��ʾ �����ȳ�ֵ��Ͷ��<br/>");
		base.logout();
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		//����Ͷ��
		eCunBaoPage.maShangTouZi("0",zzmm,0,balance);
	}
	
	/**
	 * ����Ԫ
	 * ��ҳ����Ͷ�� δ��Ǯ�û�Ͷ�� ���ֻ��û�,û��ֵ����,ֱ�ӵ��ȥͶ��
	 */
	@Test(priority = 10)
	public void indexMaShangTouZiTiShiChongZhiOldTel_web_64_2(){
		Reporter.log("��汦P1����ҳ����Ͷ�� δ��Ǯ�û�Ͷ�� ���ֻ��û�,û��ֵ����,ֱ�ӵ��ȥͶ��<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_oldtel;
		}else {
			tel = Data.run_ECunBao_oldtel;
		}
		Reporter.log("��ҳ����Ͷ�� δ��Ǯ�û�Ͷ�� ���ֻ��û�,û��ֵ����,ֱ�ӵ��ȥͶ��<br/>");
		base.logout();
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		//����Ͷ��
		eCunBaoPage.maShangTouZi("0",zzmm,0,balance);
	}
	
	/**
	 * ����Ԫ
	 * ��ҳ����Ͷ�� δ��Ǯ�û�Ͷ�� �������û�,û��ֵ����,ֱ�ӵ��ȥͶ��
	 */
	@Test(priority = 11)
	public void indexMaShangTouZiTiShiChongZhiOldEmail_web_64_3(){
		Reporter.log("��汦P1����ҳ����Ͷ�� δ��Ǯ�û�Ͷ�� �������û�,û��ֵ����,ֱ�ӵ��ȥͶ��<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_oldemail;
		}else {
			tel = Data.run_ECunBao_oldemail;
		}
		Reporter.log("��ҳ����Ͷ�� δ��Ǯ�û�Ͷ�� �������û�,û��ֵ����,ֱ�ӵ��ȥͶ��<br/>");
		base.logout();
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		eCunBaoPage.maShangTouZi("0",zzmm,0,balance);
	}
}
