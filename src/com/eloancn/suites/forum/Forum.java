package com.eloancn.suites.forum;

import org.testng.Reporter;
import org.testng.annotations.*;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ForumPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.until.CssUtils;

/*
 * ����̳������
 */
public class Forum {
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	ForumPage forumPage = new ForumPage();
	LoginPage loginPage = new LoginPage();
	
	public String username = Data.tel_run_debit2;//Data.tel Data.email //1112@126.com  //������"ff@qq.com"  13111111112
	public String password = Data.password;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			username = Data.test_tel;//Data.email  18880000200
			password = Data.test_password;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**********δ��¼����ҳ����������̳,����ʾδ��¼״̬������Ԫ��**********/
	@Test(priority = 1)
	public void creditLinkToForum_AT_593_594(){
		Reporter.log("��̳��δ��¼����Ҫ����ҳ����������̳,����ʾδ��¼״̬<br/>");
		indexPage.linkToForum("��Ҫ����");
		forumPage.isForum();
		loginPage.isForumNotLogin();
		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("��汦");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("���Ǽƻ�");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("Ͷ���б�");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("��δ���");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("������");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
	}
	
//	@Test(priority = 2)
//	public void debitLinkToForum_AT_593_594(){
//	    Reporter.log("��̳��δ��¼����ҳ����������̳,����ʾδ��¼״̬");
//		indexPage.linkToForum("��Ҫ����");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("�������");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("��ν���");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("�����");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//	}
//	
//	@Test(priority = 3)
//	public void noviceAreaLinkToForum_AT_593_594(){
//      Reporter.log("��̳��δ��¼����ҳ����������̳,����ʾδ��¼״̬");
//		indexPage.linkToForum("����ר��");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//	    forumPage.closeForumTrunBeforePage();
//	}
//	
//	@Test(priority = 4)
//	public void debentureTransferLinkToForum_AT_593_594(){
//      Reporter.log("��̳��δ��¼����ҳ����������̳,����ʾδ��¼״̬");
//		indexPage.linkToForum("ծȨת��");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//	    forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("ת���б�");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("���ת��");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//	}
//	
	@Test(priority = 2)
	public void aboutUsLinkToForum_AT_593_594(){
	    Reporter.log("��̳��δ��¼����������ҳ����������̳,����ʾδ��¼״̬<br/>");
		base.openBrowser(base.indexURL);
		indexPage.linkToForum("��������");
		forumPage.isForum();
		loginPage.isForumNotLogin();
		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("��˾����");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("�쵼����");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("��˾����");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
//		indexPage.linkToForum("������ʿ");
//		forumPage.isForum();
//		loginPage.isForumNotLogin();
//		forumPage.closeForumTrunBeforePage();
////		indexPage.linkToForum("��ϵ����");
////		forumPage.isForum();
////		loginPage.isNotLogin();
////		forumPage.closeForumTrunBeforePage();
	}
	
	/***δ��¼����̳ҳ�������ҳ/������logo������ת��������������ҳ����ʾΪδ��¼״̬������Ԫ��***/
	@Test(priority = 3)
	public void notLoginClicklogo_AT_687(){
		Reporter.log("��̳��δ��¼����̳ҳ�������ҳ/������logo������ת��������������ҳ����ʾΪδ��¼״̬<br/>");
		base.openBrowser("http://bbs.eloancn.com/");
		//���logo
		forumPage.clickLogo();
		//��֤��ת��������������ҳ
		indexPage.isturnToIndexPage();
		//��ʾΪδ��¼״̬
		loginPage.isNotLogin();
	}
	
	/***��¼����̳ҳ�������ҳ/������logo������ת��������������ҳ����ʾΪ��¼״̬������Ԫ��***/
	@Test(priority = 4)
	public void loginClicklogo_AT_688(){
		Reporter.log("��̳����¼����̳ҳ�������ҳ/������logo������ת��������������ҳ����ʾΪ��¼״̬<br/>");
//		base.openBrowser(base.indexURL);
//		//�������¼��
//		indexPage.clickLoginLink();
//		//��¼
//		loginPage.login(username, password);
		if (base.indexURL.contains("www")) {
			username = Data.test_tel;//Data.email  18880000200
			password = Data.test_password;
			base.openBrowser("http://bbs.eloancn.com/");
			forumPage.forumClickLogin();
			loginPage.loginWithNoFrame(username, password);
			//��֤��¼�Ƿ�ɹ�
			loginPage.isForumLoginOK();
			//������̳ҳ�����logo
			forumPage.clickLogo();
			//��֤��ת��������������ҳ
			indexPage.isturnToIndexPage();
			//�����¼
			indexPage.clickLoginLink();
			//��ʾΪ��¼״̬
			base.sleep(10000);
			loginPage.isLoginOK();
			//�˳�
			base.logout();
		}else {
			Reporter.log(CssUtils.red("�������ܲ⣬���໷���޷�����"));
		}
	}
	
	/**********��¼״̬����������ҳ��������̳��,��ת������̳����ҳ�棬��ʾΪ��¼״̬������Ԫ��**********/
	@Test(priority = 5)
	public void loginLinkToForum_AT_595(){
		Reporter.log("��̳:��¼״̬����������ҳ��������̳��,��ת������̳����ҳ�棬��ʾΪ��¼״̬<br/>");
//		//�������¼��
//		indexPage.clickLoginLink();
//		//��¼
//		loginPage.login(username, password);
		if (base.indexURL.contains("www")) {
			username = Data.test_tel;//Data.email  18880000200
			password = Data.test_password;
			base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(username, password);
			//��֤��¼�Ƿ�ɹ�
			loginPage.isLoginOK();
	//		indexPage.linkToForum("��Ҫ����");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("��汦");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
			indexPage.linkToForum("���Ǽƻ�");
			forumPage.isForum();
			loginPage.isForumLoginOK();
			forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("Ͷ���б�");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("��δ���");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("������");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		
	//		indexPage.linkToForum("��Ҫ����");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("�������");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("��ν���");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("�����");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
			
			indexPage.linkToForum("����ר��");
			forumPage.isForum();
			loginPage.isForumLoginOK();
			forumPage.closeForumTrunBeforePage();
			
	//		indexPage.linkToForum("ծȨת��");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("ת���б�");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("���ת��");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		
	//		indexPage.linkToForum("��������");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("��˾����");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("�쵼����");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("��˾����");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("������ʿ");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
	//		indexPage.linkToForum("��ϵ����");
	//		forumPage.isForum();
	//		loginPage.isForumLoginOK();
	//		forumPage.closeForumTrunBeforePage();
			//base.logout();
		}else {
			Reporter.log(CssUtils.red("�������ܲ⣬���໷���޷�����"));
		}
	}
}
