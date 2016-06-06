package com.eloancn.suites.index;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.JoinInPage;
import com.eloancn.shared.pages.LoginPage;

/**
 * ��ҳҳ����ת����
 * @author ������
 */
public class Home {
	
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	JoinInPage joinInPage = new JoinInPage();
	
	String name,pass,payPass;
	String banners[] = null;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			name = Data.tel_run_EcunBao;
    		pass = Data.password;
			payPass = Data.zzmm;
			banners = Data.banners_client;
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			name = Data.test2_tel;
    		pass = Data.test2_password;
			payPass = Data.test2_zzmm;
			banners = Data.banners_test;
		}
	}
	
	@BeforeMethod
	public void Method(){
		base.openBrowser(base.indexURL);
		base.isTitle(PageTitles.shouYe);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * �������ƣ�ҳ�浼����_"��Ҫ����"��ת������ҳ���Ƿ���ȷ
	 * @author ������
	 */
	@Test (priority = 1, enabled = true)
	public void checkNavigationCreditLink_AT_585(){
		
		Reporter.log("��ҳ��ҳ�浼����_'��Ҫ����'����>У����ת������ҳ���Ƿ���ȷ<br/>");
		System.out.println("\nҳ�浼����_'��Ҫ����'��ת������ҳ���Ƿ���ȷ����6��Title---------------------\n");
		int step = 0;
		indexPage.clickMenu("��汦");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.yiCunBao));
			Reporter.log("����������Ҫ����-��汦��ת��У��ɹ�");
			System.out.println("����������Ҫ����-��汦��ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������Ҫ����-��汦��ת��У��ʧ��");
			System.out.println("����������Ҫ����-��汦��ת��У��ʧ��");
		}
		indexPage.clickMenu("���Ǽƻ�");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.yiXingJiHua));
			Reporter.log("����������Ҫ����-���Ǽƻ���ת��У��ɹ�");
			System.out.println("����������Ҫ����-���Ǽƻ���ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������Ҫ����-���Ǽƻ���ת��У��ʧ��");
			System.out.println("����������Ҫ����-���Ǽƻ���ת��У��ʧ��");
		}
		/*indexPage.clickMenu("ɢ���б�");//ɢ���¼� 2016-3-22
		try {
			Assert.assertTrue(base.isTitle(PageTitles.touZiLieBiao));
			Reporter.log("����������Ҫ����-ɢ���б���ת��У��ɹ�");
			System.out.println("����������Ҫ����-ɢ���б���ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������Ҫ����-ɢ���б���ת��У��ʧ��");
			System.out.println("����������Ҫ����-ɢ���б���ת��У��ʧ��");
		}*/
		indexPage.clickMenu("��δ���");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.ruHeDaiChu));
			Reporter.log("����������Ҫ����-��δ�����ת��У��ɹ�");
			System.out.println("����������Ҫ����-��δ�����ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������Ҫ����-��δ�����ת��У��ʧ��");
			System.out.println("����������Ҫ����-��δ�����ת��У��ʧ��");
		}
		indexPage.clickMenu("������");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.gongJuXiang));
			Reporter.log("����������Ҫ����-��������ת��У��ɹ�");
			System.out.println("����������Ҫ����-��������ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������Ҫ����-��������ת��У��ʧ��");
			System.out.println("����������Ҫ����-��������ת��У��ʧ��");
		}
		indexPage.clickMenu("��Ҫ����");
		try {
			if(base.isAlertPresent(5)){
				base.acceptAlert();
			}
			Assert.assertTrue(base.isTitle(PageTitles.woYaoDaiChu));
			Reporter.log("����������Ҫ������ת��У��ɹ�");
			System.out.println("����������Ҫ������ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			e.printStackTrace();
			Reporter.log("����������Ҫ������ת��У��ʧ��");
			System.out.println("����������Ҫ������ת��У��ʧ��");
		}
		Assert.assertEquals(step, 5);
	}
	
	/**
	 * �������ƣ�ҳ�浼����_"����ר��"��ת������ҳ���Ƿ���ȷ
	 * @author ������
	 * ��ע������ר���¼� 2016-3-22
	 */
	@Test (priority = 2, enabled = false)
	public void checkNavigationNoviceAreaLink_AT_585(){
		
		Reporter.log("��ҳ��ҳ�浼����_'����ר��'����>У����ת������ҳ���Ƿ���ȷ<br/>");
		System.out.println("\nҳ�浼����_'����ר��'��ת������ҳ���Ƿ���ȷ����1��Title---------------------\n");
		indexPage.clickMenu("����ר��");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.xinShouZhuanQu));
			Reporter.log("������������ר����ת��У��ɹ�");
			System.out.println("������������ר����ת��У��ɹ�");
		} catch (AssertionError e) {
			Reporter.log("������������ר����ת��У��ʧ��");
			System.out.println("������������ר����ת��У��ʧ��");
		}
	}
	
	/**
	 * �������ƣ�ҳ�浼����_"ծȨת��"��ת������ҳ���Ƿ���ȷ
	 * @author ������
	 */
	@Test (priority = 3, enabled = true)
	public void checkNavigationDebentureTransferLink_AT_585(){
		
		Reporter.log("��ҳ��ҳ�浼����_'ծȨת��'����>У����ת������ҳ���Ƿ���ȷ<br/>");
		System.out.println("\nҳ�浼����_'ծȨת��'��ת������ҳ���Ƿ���ȷ����3��Title---------------------\n");
		int step = 0;
		indexPage.clickMenu("ת���б�");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.zhuanRangLieBiao));
			Reporter.log("��������ծȨת��-ת���б���ת��У��ɹ�");
			System.out.println("��������ծȨת��-ת���б���ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("��������ծȨת��-ת���б���ת��У��ʧ��");
			System.out.println("��������ծȨת��-ת���б���ת��У��ʧ��");
		}
		indexPage.clickMenu("���ת��");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.ruheZhuanRang));
			Reporter.log("��������ծȨת��-���ת����ת��У��ɹ�");
			System.out.println("��������ծȨת��-���ת����ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("��������ծȨת��-���ת����ת��У��ʧ��");
			System.out.println("��������ծȨת��-���ת����ת��У��ʧ��");
		}
		indexPage.clickMenu("ծȨת��");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.zhaiQuanZhuanRang));
			Reporter.log("��������ծȨת����ת��У��ɹ�");
			System.out.println("��������ծȨת����ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("��������ծȨת����ת��У��ʧ��");
			System.out.println("��������ծȨת����ת��У��ʧ��");
		}
		Assert.assertEquals(step, 3);
	}
	
	/**
	 * �������ƣ�ҳ�浼����_"��Ҫ����"��ת������ҳ���Ƿ���ȷ
	 * @author ������
	 */
	@Test (priority = 8, enabled = true)
	public void checkNavigationDebitLink_AT_585(){
		
		Reporter.log("��ҳ��ҳ�浼����_'��Ҫ����'����>У����ת������ҳ���Ƿ���ȷ<br/>");
		System.out.println("\nҳ�浼����_'��Ҫ����'��ת������ҳ���Ƿ���ȷ����4��Title---------------------\n");
		int step = 0;
		loginPage.reLogin(name, pass);
		indexPage.clickMenu("�������");
		try {
			base.checkContainsTitle(PageTitles.woDeZhangHu,10);
			Reporter.log("����������Ҫ����-���������ת��У��ɹ�");
			System.out.println("����������Ҫ����-���������ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������Ҫ����-���������ת��У��ʧ��");
			System.out.println("����������Ҫ����-���������ת��У��ʧ��");
		}
		indexPage.clickMenu("��ν���");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.ruHeJieRu));
			Reporter.log("����������Ҫ����-��ν�����ת��У��ɹ�");
			System.out.println("����������Ҫ����-��ν�����ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������Ҫ����-��ν�����ת��У��ʧ��");
			System.out.println("����������Ҫ����-��ν�����ת��У��ʧ��");
		}
		indexPage.clickMenu("�����");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.gongYiDai));
			Reporter.log("����������Ҫ����-�������ת��У��ɹ�");
			System.out.println("����������Ҫ����-�������ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������Ҫ����-�������ת��У��ʧ��");
			System.out.println("����������Ҫ����-�������ת��У��ʧ��");
		}
		indexPage.clickMenu("��Ҫ����");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.woYaoJieRu));
			Reporter.log("����������Ҫ������ת��У��ɹ�");
			System.out.println("����������Ҫ������ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������Ҫ������ת��У��ʧ��");
			System.out.println("����������Ҫ������ת��У��ʧ��");
		}
		Assert.assertEquals(step, 4);
	}

	/**
	 * �������ƣ�ҳ�浼����_"��������"��ת������ҳ���Ƿ���ȷ
	 * @author ������
	 */
	@Test (priority = 9, enabled = true)//(priority = 5)
	public void checkNavigationAboutUsLink_AT_585(){
		
		Reporter.log("��ҳ��ҳ�浼����_'��������'����>У����ת������ҳ���Ƿ���ȷ<br/>");
		System.out.println("\nҳ�浼����_'��������'��ת������ҳ���Ƿ���ȷ---------------------\n");
		int step = 0;
		indexPage.clickMenu("��˾����");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.gongSiJieShao));
			base.isElementPresence(By.xpath("//span[text()='��˾���']"));
			Reporter.log("����������������-��˾������ת��У��ɹ�");
			System.out.println("����������������-��˾������ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������������-��˾������ת��У��ʧ��");
			System.out.println("����������������-��˾������ת��У��ʧ��");
		}
		indexPage.clickMenu("�쵼����");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.guanYuWoMen));
			base.isElementPresence(By.xpath("//span[text()='�쵼���']"));
			Reporter.log("����������������-�쵼������ת��У��ɹ�");
			System.out.println("����������������-�쵼������ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������������-�쵼������ת��У��ʧ��");
			System.out.println("����������������-�쵼������ת��У��ʧ��");
		}
		indexPage.clickMenu("��˾����");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.gongSiLiNian));
			base.isElementPresence(By.xpath("//span[text()='��˾�ں�']"));
			Reporter.log("����������������-��˾������ת��У��ɹ�");
			System.out.println("����������������-��˾������ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������������-��˾������ת��У��ʧ��");
			System.out.println("����������������-��˾������ת��У��ʧ��");
		}
		indexPage.clickMenu("������ʿ");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.zhaoXianNaShi));
			base.isElementPresence(By.xpath("//span[text()='������ʿ']"));
			Reporter.log("����������������-������ʿ��ת��У��ɹ�");
			System.out.println("����������������-������ʿ��ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������������-������ʿ��ת��У��ʧ��");
			System.out.println("����������������-������ʿ��ת��У��ʧ��");
		}
		indexPage.clickMenu("��ϵ����");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.lianXiWoMen));
			base.isElementPresence(By.xpath("//span[text()='��ϵ����']"));
			Reporter.log("����������������-��ϵ������ת��У��ɹ�");
			System.out.println("����������������-��ϵ������ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����������������-��ϵ������ת��У��ʧ��");
			System.out.println("����������������-��ϵ������ת��У��ʧ��");
		}
		indexPage.clickMenu("��������");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.guanYuWoMen));
			base.isElementPresence(By.xpath("//span[text()='��˾���']"));
			Reporter.log("������������������ת��У��ɹ�");
			System.out.println("������������������ת��У��ɹ�");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("������������������ת��У��ʧ��");
			System.out.println("������������������ת��У��ʧ��");
		}
		Assert.assertEquals(step, 6);
	}

	/**
	 * �������ƣ�ҳ�浼����_"�ҵ��˻�"��ת������ҳ���Ƿ���ȷ
	 * @author ������
	 */
	@Test (priority = 6)
	//���"�ҵ��˻�"���ֵ�������ת(��Ҫ��¼)
	public void checkNavigationMyAccountLink_AT_585(){
		
		Reporter.log("��ҳ��ҳ�浼����_'�ҵ��˻�'����>У����ת������ҳ���Ƿ���ȷ<br/>");
		System.out.println("\nҳ�浼����_'�ҵ��˻�'��ת������ҳ���Ƿ���ȷ����1��Title---------------------\n");
		//���µ�¼
		loginPage.reLogin(name, pass);
		//������ҵ��˻�������
		indexPage.clickMenu("�ҵ��˻�");
		try {
			base.isTitle(PageTitles.woDeZhangHu);
			Reporter.log("���������ҵ��˻���ת��У��ɹ�");
			System.out.println("���������ҵ��˻���ת��У��ɹ�");
		} catch (AssertionError e) {
			Reporter.log("���������ҵ��˻���ת��У��ʧ��");
			System.out.println("���������ҵ��˻���ת��У��ʧ��");
		}
	}
	
	/************Banner*************/
	
	/**
	 * �������ƣ�Banner_��ת������ҳ���Ƿ���ȷ
	 * @author ������
	 * ����Ԫ�޸�
	 */
	@Test (priority = 10, enabled = true)
	public void checkBannerLink_AT_586(){
		
		Reporter.log("��ҳ��Banner��ͼ����>У����ת������ҳ���Ƿ���ȷ<br/>");
		System.out.println("\n��ҳ��Banner��ͼ����>У����ת������ҳ���Ƿ���ȷ\n");
		indexPage.isBannerOK(banners);
	}

	/************�ջݽ���*************/
	
	/**
	 * �������ƣ��ջݽ���_��ת������ҳ���Ƿ���ȷ
	 * @author ������
	 */
	@Test (priority = 5, enabled = true)
	public void checkProjectLink_AT_586(){
		
		Reporter.log("��ҳ���ջݽ��ڡ���>У����ת������ҳ���Ƿ���ȷ<br/>");
		System.out.println("\n�ջݽ���_��ת������ҳ���Ƿ���ȷ����5��Title---------------------\n");
		
		indexPage.checkProjectLink("���ս���");
		indexPage.checkProjectLink("����ɹ�");
		indexPage.checkProjectLink("��ȫ����");
		indexPage.checkProjectLink("ͬ��ģʽ");
		indexPage.checkProjectLink("Ʒ��Ȩ��");
	}
	
	@Test(priority = 11, enabled = true)
	public void checkJoinInJump_AT_5256(){
		
		Reporter.log("��ҳ�� ���̺�������>1.У�鶥��������ת�Ƿ�������2.У��β��������ת�Ƿ�������3.У��δ��¼���ύ�����������ת�Ƿ�����<br/>");
		System.out.println("��ҳ�����̺�������>1.У�鶥��������ת�Ƿ�������2.У��β��������ת�Ƿ�������3.У��δ��¼���ύ�����������ת�Ƿ�����");
		
		if(loginPage.ifLogin()){
			base.logout();
		}
		indexPage.clickJoinIn();
		indexPage.clickJoinInOfBottom();
		joinInPage.checkJoinInInfoJumpNoLogin();
	}
	
	//ɢ���¼� 2016-3-22
	@Test(priority = 12, enabled = false)
	public void checkBorrowJumpAndMaterialImgNum_AT_5257(){
		
		Reporter.log("��ҳ��ɢ�ꡪ��>1.У����������ת�Ƿ�������2.У��������ҳ��������Ϣ��ͼƬ�����Ƿ�����<br/>");
		System.out.println("��ҳ��ɢ�ꡪ��>1.У����������ת�Ƿ�������2.У��������ҳ��������Ϣ��ͼƬ�����Ƿ�����");
		
		if(loginPage.ifLogin()){
			base.logout();
		}
		loginPage.homeLogin(name, pass);
		indexPage.checkSBTitleJumpAndMaterialImgNum("����", "������Ϣ");
	}
	
	//ɢ���¼� 2016-3-22
	@Test(priority = 13, enabled = false)
	public void checkMoreLinkJump_AT_5255(){
		
		Reporter.log("��ҳ��ɢ�ꡪ��>1.У�����鿴����ɢ����Ŀ������ת�Ƿ�����<br/>");
		System.out.println("��ҳ��ɢ�ꡪ��>1.У�����鿴����ɢ����Ŀ������ת�Ƿ�����");
		
		indexPage.checkMoreLinkStyle("ɢ��", "center");
		indexPage.clickMoreLink("ɢ��Ͷ��");
	}
	
	@Test(priority = 14, enabled = true)
	public void checkMoreLinkJump_AT_5272(){
		
		Reporter.log("��ҳ�����Ǽƻ�����>1.У�����鿴������Ŀ������ת�Ƿ�����<br/>");//����������
		System.out.println("��ҳ�����Ǽƻ�����>1.У����������ת�Ƿ�������2.У��������ҳ��������Ϣ��ͼƬ�����Ƿ�����");
		
		indexPage.checkMoreLinkStyle("���Ǽƻ�", "center");
		indexPage.clickMoreLink("���Ǽƻ�");
	}
	
}
