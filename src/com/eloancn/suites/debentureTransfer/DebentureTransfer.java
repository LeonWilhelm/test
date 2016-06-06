package com.eloancn.suites.debentureTransfer;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.DebentureTransferPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;

/*
 * ��ɢ��Ͷ������ר��������
 */
public class DebentureTransfer {
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	DebentureTransferPage debentureTransferPage = new DebentureTransferPage();
	
	//public String usname = "13111111150";//Data.email  ff@qq.com
	public String tel = Data.tel;		//����ֻ���
	String password = Data.password;
	String zzmm = Data.zzmm;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL+"/new/loadNewUserTender.action");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_tel;
			password = Data.test_password;
			zzmm = Data.test_zzmm;
		}else {
			tel = Data.tel_run_DebentureTransfer;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * ����Ԫ
	 * У������ר��-Ͷ���б������ʾ10������
	 */
	@Test (priority = 1)
	public void verifyDataSize_AT_505(){
		Reporter.log("Ͷ������-����ר�����б�ҳ��ÿҳ�����ʾ10������������Ϣ<br/>");
		//indexPage.clickMenu("����ר��");
		debentureTransferPage.isInvestDataSizeOK();
	}
	
	
	/**
	 * ����Ԫ
	 * ���������Ͷ�ʡ���������¼
	 * 2015-7-20    ���������checkLoginTitle()����
	 */
	@Test (priority = 2)
	public void fastInvestLogin_AT_499(){
		Reporter.log("Ͷ������-����ר�����б�ҳ���û�δ��¼�����������Ͷ�ʡ���������¼<br/>");
		//�Ƿ��С�����Ͷ�ʰ�ť��
		if (base.indexURL.contains("client")) {
			if (!debentureTransferPage.ifHaveFastInvestBtn()) {//û�����ֱ���ȴ���
				debentureTransferPage.makeNewUserBid();
				base.logout();
			}
			fastInvestLogin();
		}else {
			if (debentureTransferPage.ifHaveFastInvestBtn()) {
				fastInvestLogin();
			}
		}
	}
	
	public void fastInvestLogin(){
		//��������Ͷ�ʡ�
		debentureTransferPage.clickFastInvest();
		//�ж��Ƿ񵯳���¼����
		indexPage.checkLoginTitle();
		//�رյ�¼����
		debentureTransferPage.closeLogin();
	}
	
	/**
	 * ����Ԫ
	 * У��Ͷ���б�������Ƿ���ȷ
	 */
	@Test (priority = 3)
	public void verifyDataLinks_AT_505(){
		Reporter.log("Ͷ������-����ר�����б�ҳ������������ʱ������������ҳ����ȷ<br/>");
		base.openBrowser(base.indexURL+"/new/loadNewUserTender.action");
		//�������¼��
		indexPage.clickLoginLink();
		//��¼
		loginPage.login(tel, password);//1112@126.com  //������"ff@qq.com"
		//��֤��¼�Ƿ�ɹ�
		loginPage.isLoginOK();
		//У��Ͷ���б�������Ƿ���ȷ
		debentureTransferPage.isInvestDataLinkOK();
	}
	
	/**
	 * ����Ԫ
	 * ����ҳ����������
	 */
	@Test (priority = 4)
	public void verifyDetailsLinks_AT_507(){
		Reporter.log("Ͷ������-����ר������������ҳ������������ʱ������������ҳ����ȷ<br/>");
		base.openBrowser(base.indexURL+"/new/loadNewUserTender.action");
		if (!loginPage.ifLogin()) {
			//�������¼��
			indexPage.clickLoginLink();
			//��¼
			loginPage.login(tel, password);//1112@126.com  //������"ff@qq.com"
			//��֤��¼�Ƿ�ɹ�
			loginPage.isLoginOK();
		}
		debentureTransferPage.verifyDetailsInfoLinks();
	}
	
	/**
	 * ����Ԫ
	 * ������Ͷ�ʡ�
	 */
	@Test (priority = 5)
	public void fastInvest_AT_500(){
		Reporter.log("Ͷ������-����ר�����б�ҳ�����������Ͷ�ʡ�����ʾͶ�ʳɹ�<br/>");
		base.openBrowser(base.indexURL+"/new/loadNewUserTender.action");
		//�Ƿ��С�����Ͷ�ʰ�ť��
		if (base.indexURL.contains("client")) {
			if (!debentureTransferPage.ifHaveFastInvestBtn()) {//û�����ֱ���ȴ���
				debentureTransferPage.makeNewUserBid();
				base.logout();
				//�������¼��
				indexPage.clickLoginLink();
				//��¼
				loginPage.login(tel, password);
			}
			fastInvest();
		}else {
			if (debentureTransferPage.ifHaveFastInvestBtn()) {
				fastInvest();
			}
		}
	}

	public void fastInvest(){
		if (!loginPage.ifLogin()) {
			//�������¼��
			indexPage.clickLoginLink();
			//��¼
			loginPage.login(tel, password);//1112@126.com  //������"ff@qq.com"
			//��֤��¼�Ƿ�ɹ�
			loginPage.isLoginOK();
		}
		debentureTransferPage.clickFastInvest();
		//Ͷ��
		debentureTransferPage.fastInvest("50",zzmm);
		//У���Ƿ�Ͷ�ʳɹ�
		if (!debentureTransferPage.isFastInvestOK()) {
			if (debentureTransferPage.ifHaveFastInvestBtn()) {
				debentureTransferPage.clickFastInvest();
				//Ͷ��
				debentureTransferPage.fastInvest("50",zzmm);
				if (!debentureTransferPage.isFastInvestOK()) {
					Reporter.log("��֤�������������������룡");
					Assert.assertTrue(false);
				}
			}
		}
	}
	
	/**
	 * ����Ԫ
	 * ����ҳ ����Ǯ������
	 */
	@Test (priority = 6)
	public void detailsFastInvest_AT_504(){
		Reporter.log("Ͷ������-����ר������������ҳ���������Ǯ����������ʾͶ�ʳɹ�<br/>");
		base.openBrowser(base.indexURL+"/new/loadNewUserTender.action");
		//�Ƿ��С�����Ͷ�ʡ���ť
		if (base.indexURL.contains("client")) {
			if (!debentureTransferPage.ifHaveFastInvestBtn()) {//û�����ֱ���ȴ���
				debentureTransferPage.makeNewUserBid();
				base.logout();
				//�������¼��
				indexPage.clickLoginLink();
				//��¼
				loginPage.login(tel, password);//1112@126.com  //������"ff@qq.com"
			}
			detailFastInvest();
		}else {
			if (debentureTransferPage.ifHaveFastInvestBtn()) {
				detailFastInvest();
			}
		}
	}
	
	public void detailFastInvest(){
		if (!loginPage.ifLogin()) {
			//�������¼��
			indexPage.clickLoginLink();
			//��¼
			loginPage.login(tel, password);//1112@126.com  //������"ff@qq.com"
			//��֤��¼�Ƿ�ɹ�
			loginPage.isLoginOK();
		}
		//����ҳ ����Ǯ������
		if (!debentureTransferPage.detailsFastInvest("50",zzmm,tel,password)) {
			if (debentureTransferPage.ifHaveFastInvestBtn()) {
				if (!debentureTransferPage.detailsFastInvest("50",zzmm,tel,password)){
					Reporter.log("��֤�������������������룡");
					Assert.assertTrue(false);
				}
			}
		}
	}
}
