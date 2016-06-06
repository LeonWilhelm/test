package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.YCBPage;

/**
 * ����汦������-������
 */
public class ECunBao {
	
	Base base = new Base();

	YCBPage ycbPage = new YCBPage();
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
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
	
	/**
	 * �������ƣ��б�ҳ
	 * ������ţ�YCB_002
	 * @author ������
	 */
	@Test (priority = 3, enabled = true)
	public void checkListPage_AT_541_5283(){
		
		Reporter.log("��汦����汦�б�ҳ����>1.У�顶���������߾Ӽ����Э�顷���ӣ�2.У�����С�����Զ�ƥ�䷵�֡����ӣ�3.У�����С���Ͷ�ʼ�¼����ť��4.У�����С���Ͷ����ť</br>");
		System.out.println("��汦����汦�б�ҳ����>1.У�顶���������߾Ӽ����Э�顷���ӣ�2.У�����С�����Զ�ƥ�䷵�֡����ӣ�3.У�����С���Ͷ�ʼ�¼����ť��4.У�����С���Ͷ����ť");
		
		//���µ�¼
		loginPage.reLogin(name, pass);
		//���롰��汦��ҳ��
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		//У��banner����ʾ�û�����汦����
		eCunBaoPage.checkBannerTotalData();
		eCunBaoPage.checkYCBNum();
		//У�顰ծȨ���顱��ť
		eCunBaoPage.checkBondDetails();
		//У�����С�����Զ�ƥ�䷵�֡�����
		eCunBaoPage.checkReturnCashTotalLink();
		//У�����С���Ͷ�ʼ�¼����ť
		eCunBaoPage.checkRecordTotalBtn();
		//У�����С���Ͷ����ť
		eCunBaoPage.checkTenderTotalBtn();
	}
	
	/**
	 * �������ƣ����bannerδ��¼
	 * ������ţ�YCB_003
	 * @throws InterruptedException 
	 * @author ������
	 */
	@Test (priority = 1, enabled = true)
	public void checkBannerNoLogin_AT_542(){
		
		Reporter.log("��汦����汦�б�ҳ_δ��¼����>1.У��banner���Ƿ��С�������¼����ť��2.У������������¼����ť���Ƿ񵯳���ʾ��Ϣ</br>");
		System.out.println("��汦����汦�б�ҳ_δ��¼����>1.У��banner���Ƿ��С�������¼����ť��2.У������������¼����ť���Ƿ񵯳���ʾ��Ϣ");
		
		if(!loginPage.isLogout()){
			base.logout();//�ǳ�
		}
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		//�����������¼����ť
		eCunBaoPage.clickLoginBtn();
		//��顰��¼���ڡ���ʾ��¼
		eCunBaoPage.checkBannerLoginWindowTitle();
	}

	/**
	 * �������ƣ����banner�ѵ�¼
	 * ������ţ�YCB_004
	 * @author ������ 2016-1-6
	 */
	@Test (priority = 4, enabled = true)
	public void checkBannerLogin_AT_543(){
		
		Reporter.log("��汦����汦�б�ҳ_�ѵ�¼����>������ҵ���汦����ť����>��֤��ת�����ҵ��˻�-�ҵĴ���-��汦��ҳ��</br>");
		System.out.println("��汦����汦�б�ҳ_�ѵ�¼����>������ҵ���汦����ť����>��֤��ת�����ҵ��˻�-�ҵĴ���-��汦��ҳ��");
//		//�ж��Ƿ��¼
//		if(!loginPage.ifLogin()){
//			loginPage.reLogin(name, pass);
//		}
		//���롰��汦��ҳ��
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		//������ҵ���汦����ť
		eCunBaoPage.clickMyECunBaoBtn();
		base.isTitle(PageTitles.woDeZhangHu);
		//��֤��ת�����ҵ��˻�-�ҵĴ���-��汦��ҳ��
		myAccountPage.isGoMyAccount("��汦");
		base.isTitle(PageTitles.woDeZhangHu);
		//У����汦�����ձ��𡱡���������Ϣ��������׬��Ϣ��������������Ϣ���������ձ�����������ʾ
		ycbPage.checkECunBaoInfoName();
		//�����ÿ��������ϸ�����������С������ѽ��塱������ʾ
		ycbPage.clickDetail();
		ycbPage.clickPartake();
		ycbPage.clickSettle();
	}
	
	/**
	 * �������ƣ�����б�ҳ�������Ͷ����ť��δ��¼
	 * ������ţ�YCB_005
	 * @throws InterruptedException 
	 * @author ������
	 */
	@Test (priority = 2, enabled = true)
	public void checkListPageNoLoginTender_AT_544(){
		
		Reporter.log("��汦����汦�б�ҳ_δ��¼����>�������Ͷ����ť����>��顰��¼���ڡ���ʾ��¼</br>");
		System.out.println("��汦����汦�б�ҳ_δ��¼����>�������Ͷ����ť����>��顰��¼���ڡ���ʾ��¼");
		
		//���롰��汦��ҳ��
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		//�������Ͷ����ť������顰��¼���ڡ���ʾ��¼
		eCunBaoPage.checkTenderTotalBtnNoLogin();
	}
	
	/**
	 * �������ƣ�����б�ҳ�������Ͷ����ť���ѵ�¼
	 * ������ţ�YCB_006
	 * @author ������
	 */
	@Test (priority = 5, enabled = true)
	public void checkListPageLoginTender_AT_545(){
		
		Reporter.log("��汦����汦�б�ҳ_�ѵ�¼����>�������Ͷ����ť����>У���Ƿ�Ͷ�ʳɹ�</br>");
		System.out.println("��汦����汦�б�ҳ_�ѵ�¼����>�������Ͷ����ť����>У���Ƿ�Ͷ�ʳɹ�");
		
		String money = "100";
		
		if(!money.equals("100")){
			System.out.println("�������100Ԫ����ֹ��Ͷ��");
			Reporter.log("�������100Ԫ����ֹ��Ͷ��");
			base.assertTrueByBoolean(false);
		}
		//�ж��Ƿ��¼
		boolean isLogin = loginPage.ifLogin();
		if(!isLogin){
			loginPage.reLogin(name, pass);
		}
		
		eCunBaoPage.qiangTou(money);
	}
	
	@Test (priority = 6, enabled = true)
	public void checkBondDetailsInfo_5284(){

		Reporter.log("��汦����汦�б�ҳ��1.У��ծȨ���鰴ť����ȡǰ��һҳ�����ݣ�2.У�顶���������߾Ӽ����Э�顷У�鴰�ڼ�Title����ȡȫ������һ�����ݣ�3.У�����������Ƿ�һ��</br>");
		System.out.println("��汦����汦�б�ҳ��1.У��ծȨ���鰴ť����ȡǰ��һҳ�����ݣ�2.У�顶���������߾Ӽ����Э�顷У�鴰�ڼ�Title����ȡȫ������һ�����ݣ�3.У�����������Ƿ�һ��");
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		
		//�����һ����汦��ծȨ���鰴ť����ȡǰ��һҳ������
		//�����һ����汦��Э�飬У�鴰�ڼ�Title����ȡȫ������һ������
		//У������List
		eCunBaoPage.checkBondDetailsAndServiceAgreement(eCunBaoPage.getBondDetailsInfo(), eCunBaoPage.checkServiceAgreementAndReturnAccessoriesOne());
	}
	
	@Test (priority = 6, enabled = true)
	public void checkBondDetailsInfo_5269(){
		
		Reporter.log("��汦�б�ҳ�������ծȨ���顱��ť����>������鿴���顱��ť�������Ƿ��<br/>");
		Reporter.log("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����<br/>");
		Reporter.log("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ<br/>");
		Reporter.log("4.�ٴε�����鿴���顱��ť��������ر�<br/>");
		Reporter.log("5.����رհ�ť�����ڹر�<br/>");
		System.out.println("��ҳ����汦����>1.��һ����汦�ġ�ծȨ���顱��ť�Ƿ���ʾ�������ť�������Ƿ��");
		System.out.println("2.������ʾ�Ƿ��������Լ������У����֤�У��������У���������ʾ�Ƿ�����");
		System.out.println("3.������鿴���顱��ť��ֻ��ʾ����꣬����ʾ������4��Tab������Ӧ��Ϣ");
		System.out.println("4.�ٴε�����鿴���顱��ť��������ر�");
		System.out.println("5.����رհ�ť�����ڹر�");
		
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		
		eCunBaoPage.checkBondDetails();
	}
}
