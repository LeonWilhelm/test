package com.eloancn.suites.myAccount;

import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ClientBackPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyLoanPage;


/**
 * �����P1-����׼��
 * @author ������ 
 */
public class EQiDai_P1_DataPreparation {
	
	Base base = new Base();
	ClientBackPage clientBackPage = new ClientBackPage();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	MyLoanPage myLoanPage = new MyLoanPage();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	
	
	String clientBackURL = base.clientBackURL;                              //���ɻ�����̨��ַ
	String noticeCode = Data.noticeCode;                                    //֪ͨ��
	String passwordByBack = Data.passwordByBack;                            //��̨ȷ������
	String[] userNameArray = Data.userNameArray;                            //��̨�û���
	String allianceBusinessUserName1 = Data.allianceBusinessUserName1;      //�������û�
	String headquartersUserName1 = Data.headquartersUserName1;      		//�ܲ��û�
	String headquartersUserName2 = Data.headquartersUserName2;      		//�ܲ��û�
	String lendEmail = Data.lendEmail;                                      //����ծȨ�û�����
	String password = Data.password;
	String eCunBaoId = "";                                                  //��汦ID
	
	String indexURL = "http://client.eloancn.com";                                  //����ǰ̨
	String myAccountURL = "http://client.eloancn.com/page/userMgr/myHome.jsp";      //�ҵ��˻�
	String WmpURL = "http://client.eloancn.com/new/loadAllWmpsRecords.action";      //��汦
	String registerURL = "http://client.eloancn.com/page/register/register.jsp";    //ע��
	
	
	//������������(�����״ο۷ѣ�������ע����֤)
	String borrowerName = Data.borrowerName;
	//�����������ֻ���
	String borrowerPhone = Data.tel_run_EcunBao;
	//��������������
	String borrowerEmail = Data.borrowerEmail;
	
	//���Ŀ��_ǰ̨  | ����_��̨�������ʾ��ǰ��̨һ�£���ʽ��jby�Զ���+����
	String loanPurpose = "�Զ�������";
	//�������
	String timeLimit_6 = "6����";
	String timeLimit_12 = "12����";

	/**
	 * �������ƣ�ǰ̨_�������
	 * ������ţ�754
	 * @author ������
	 */
//	@Test(priority = 2)
	public void issuedLoan(String loanAmountNew, String timeLimit){
		System.out.println("�����P1:ǰ̨_�������");
		base.setup_ff();
		base.drivermanage();
		
		base.openBrowser(indexURL);
		indexPage.clickLoginLink();
		//����˵�¼
		loginPage.loginWithXpath(borrowerPhone, password);
		//�����ҵ��˻�
		base.openBrowser(myAccountURL);
		base.sleep(5000);
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.loanApplication(true, false, "�������", loanAmountNew, timeLimit,"", "16", "7", "����", "������Ϣ", "�����", "�Զ������� ��" + loanAmountNew, "�Զ������ԣ�" + loanAmountNew + "���������뵣����ͬ�ǵ�����ͬ�Ⲣ���ɹ��󣬸���ͬ�ǵ�����ʵ�ʽ����2%�ķ��á�ͬʱ��ʹ���ܹ��������Ľ赽����Ľ�");
		loanApplicationPage.isLoanApplicationOK();
		//�ϴ�����
		myLoanPage.uploadMaterial(loanAmountNew);
		
		base.tearDown();
	}
	
	/**
	 * �������ƣ���̨_����ѷ����Ľ��
	 * ������ţ�754
	 * ��ע��ֻ����������;����UK�޸�Data.userNameArray��ֵ
	 * @author ������
	 */
//	@Test(priority = 3)
	public void tendlistAuditLoan(){
		System.out.println("�����P1:��̨_����ѷ����Ľ��");
		base.setup_ie_x86();
		base.drivermanage();
		
		//���鳤��
		int arrayLength = userNameArray.length;
		for(int i = 3; i < arrayLength; i++){

			String auditName = "";
			//����˻���
			auditName = userNameArray[i];
			System.out.println("��"+ (i+1) + "����ˣ�����ˣ�" + auditName);
			//������һ����
			int arrayNum = arrayLength - 2;
			//�Ƿ�Ϊ�������ͨ�����̡�ѭ�����һ��Ϊ����ͨ��
			boolean lastSecondCheck = false;
			//�жϴ��������б��Ƿ��н��������
			boolean isTrue = false;
			//��¼
			clientBackPage.backLogin(clientBackURL, noticeCode, auditName, passwordByBack);
			clientBackPage.clickFirstMenu("��ع���");
			//����Ǽ����̣����������������б�
			if(auditName.contains("_")){
				clientBackPage.clickSubMenu("���������б�");
				clientBackPage.selectLoan(clientBackPage.trialTendersIframe);
				isTrue = clientBackPage.isSearchFieldByList(clientBackPage.trialTendersIframe, clientBackPage.tendlistByBorrowerName, borrowerName);
			}
			else{
				clientBackPage.clickSubMenu("���ν��������б�");
				clientBackPage.selectLoanByTwice(clientBackPage.waitTrialTenders2Iframe);
				isTrue = clientBackPage.isSearchFieldByList(clientBackPage.waitTrialTenders2Iframe, clientBackPage.tendlistByBorrowerName, borrowerName);
			}
			base.assertEqualsActualExpectedByBoolean(isTrue, true);
			//����˴��ڣ������(���μ���������������һ�μ������ó���ͨ����һ���ܲ�������)
			//����ǵ����ڶ���ѭ������������ͨ������
			if(i == arrayNum){
				lastSecondCheck = true;
			}
			System.out.println("�Ƿ�Ϊ�����ڶ�����ˣ�" + lastSecondCheck);
			//���������б�����˽��
			clientBackPage.tendlistAuditLoan(borrowerName, auditName, lastSecondCheck, passwordByBack);
		}
		base.tearDown();
	}
	
	/**
	 * �������ƣ���̨_������汦(������)
	 * ������ţ�754
	 * @author ������
	 */
//	@Test(priority = 3)
	public void issuedECunBao(String loanAmount){
		System.out.println("�����P1:��̨_������汦");
		base.setup_ie_x86();
		base.drivermanage();
		
		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("��ع���");
		clientBackPage.clickSubMenu("��Ʋ�Ʒ");
		//�����Ʋ�Ʒ�������_ǰ̨  >= �����_��̨ ����Ϊ100����������
		//���Ŀ�ģ������
		clientBackPage.addWMP(loanPurpose+loanAmount, loanAmount);
		
		base.tearDown();
	}
	
	/**
	 * �������ƣ�ǰ̨_�����ѷ�����汦
	 * ������ţ�754
	 * ��ע����ͬ�û���������ṩ��
	 * @author ������
	 */
//	@Test(priority = 4)
	public void buyIssuedECunBao(String loanAmount){
		System.out.println("�����P1:ǰ̨_�����ѷ�����汦");
		base.setup_ff();
		base.drivermanage();
		
		//������汦�б�
		base.openBrowser(WmpURL);
		base.drivermanage();
		indexPage.clickLoginLink();
		//ʹ�����˻���¼
		loginPage.login(lendEmail, password);
		eCunBaoId = clientBackPage.buyECunBao(loanAmount, loanPurpose+loanAmount);
		System.out.println("��汦ID:" + eCunBaoId);
		base.tearDown();
	}
//	
//	/**
//	 * �������ƣ���̨_У����汦״̬
//	 * ������ţ�754
//	 * @author ������
//	 */
//	@Test(priority = 5)
//	public void checkProductStatus(){
//		
//		base.setup_ie_x86();
//		base.drivermanage();
//		
//		//�����̵�¼
//		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
//		clientBackPage.clickFirstMenu("��ع���");
//		clientBackPage.clickSubMenu("��Ʋ�Ʒ");		
//		//��ת������Ʋ�Ʒ��ҳ
//		clientBackPage.jumpIframe(clientBackPage.wmpsIframe);
//		//ˢ����汦�б�
//		clientBackPage.clickRefreshBtn(clientBackPage.refreshBtnByWMPSrecordList);
//		base.sleep(2000);
//		//���ݱ���У����Ʋ�Ʒ����汦��״̬
//		clientBackPage.checkProductStatus(eCunBaoId);//eCunBaoId
//		
//		base.tearDown();
//	}
	
	/**
	 * �������ƣ���̨_����ծȯ��
	 * ������ţ�754
	 * @author ������
	 */
//	@Test(priority = 6)
	public void joinBond(){
		System.out.println("�����P1:��̨_����ծȯ��");
		base.setup_ie_x86();
		base.drivermanage();
		
		//�����̵�¼
		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("��ع���");
		//--------------------------------------------------------------------------------------------����
		clientBackPage.clickSubMenu("���������б�");
		clientBackPage.selectLoan(clientBackPage.trialTendersIframe);
		//�жϴ��������б��Ƿ��н��������
		boolean isTrue = false;
		isTrue = clientBackPage.isSearchFieldByList(clientBackPage.trialTendersIframe, clientBackPage.tendlistByBorrowerName, borrowerName);
		//����˴���
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
		//���������б�����������ծȯ��
		clientBackPage.joinBond(borrowerName, passwordByBack);
		
		base.tearDown();
	}

	/**
	 * �������ƣ���̨_���뵽��Ʒ(������)
	 * ������ţ�754
	 * @author ������
	 */
//	@Test(priority = 7)
	public void joinProduct(String loanAmount){
		System.out.println("�����P1:��̨_���뵽��Ʒ");
		base.setup_ie_x86();
		base.drivermanage();
		
		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("��ع���");
		clientBackPage.clickSubMenu("ծȨ�ر�");
		base.sleep(3000);
		//��ѯծȨ
		clientBackPage.selectDebt(clientBackPage.tenderThirdpartyIframe);
		//�жϴ��������б��Ƿ��н��������
		boolean isTrue = false;
		isTrue = clientBackPage.isSearchFieldByList(clientBackPage.tenderThirdpartyIframe, clientBackPage.tendThirdpartyByBorrowerName, borrowerName);
		//����˴���
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
		//���뵽��Ʒ
		clientBackPage.joinProduct(borrowerName, loanPurpose+loanAmount, passwordByBack);	
		
		base.tearDown();
	}
	
	/**
	 * �������ƣ���̨_ծȨƥ��(������)
	 * ������ţ�754
	 * @author ������
	 */
//	@Test(priority = 8)
	public void debtOwnerMatching(String loanAmount){
		System.out.println("�����P1:��̨_ծȨƥ��");
		base.setup_ie_x86();
		base.drivermanage();
		
		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("��ع���");
		clientBackPage.clickSubMenu("��Ʋ�Ʒ");
		//�ж���Ʋ�Ʒ�б��Ƿ��б���
		boolean isTrue = false;
		isTrue = clientBackPage.isSearchFieldByList(clientBackPage.wmpsIframe, clientBackPage.wmpsListByTitle, loanPurpose+loanAmount);
		//�������
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
		//ծȨƥ��
		clientBackPage.matchingBond(loanPurpose+loanAmount, passwordByBack);
		
		base.tearDown();
	}
	
	/**
	 * �������ƣ���̨_�ܲ�����(�ò����Ѿ�ȡ�������Ǽ��ɻ������뱻���ǣ����ܳ��ָù��ܣ��ʲ����ж�)
	 * ������ţ�754
	 * @author ������
	 */
//	@Test(priority = 9)
	public void finalJudgment(String loanAmount){
		System.out.println("�����P1:��̨_�ܲ�����");
		base.setup_ie_x86();
		base.drivermanage();
		
		//�����̵�¼
		clientBackPage.backLogin(clientBackURL, noticeCode, headquartersUserName2, passwordByBack);
		clientBackPage.clickFirstMenu("��ع���");
		clientBackPage.clickSubMenu("���������б�");
		//�ܲ�����
		clientBackPage.finalJudgment(borrowerName, loanAmount, passwordByBack);
		
		base.tearDown();
	}
	
	/**
	 * �������ƣ�ǰ̨_�û�ȷ��
	 * ������ţ�754
	 * @author ������
	 */
//	@Test(priority = 10)
	public void userConfirm(String loanAmount){
		System.out.println("�����P1:ǰ̨_�û�ȷ��");
		base.setup_ff();
		base.drivermanage();
		
		base.openBrowser(indexURL);
		indexPage.clickLoginLink();
		//����˵�¼
		loginPage.loginWithXpath(borrowerPhone, password);
		//�����ҵ��˻�
		base.openBrowser(myAccountURL);
		base.sleep(3000);
		//�����ҵĽ��
		myAccountPage.turnToMyAccount("�ҵĽ��");
		//�����ѷ����Ľ��
		myLoanPage.clickPublishedTab();
		//ȷ�Ͻ��
		myLoanPage.confirmLoan(borrowerEmail, loanAmount);
		
		base.tearDown();
	}
	
	/**
	 * �������ƣ���̨_ȷ�Ͻ���(�ܲ��û�)
	 * ������ţ�754
	 * @author ������
	 */
	@Test(priority = 11)
	public void confirmTrading(String loanAmount){
		System.out.println("�����P1:��̨_ȷ�Ͻ���(�ܲ��û�)");
		base.setup_ie_x86();
		base.drivermanage();
		
		clientBackPage.backLogin(clientBackURL, noticeCode, headquartersUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("��ع���");
		clientBackPage.clickSubMenu("���������б�");
		//�ܲ�����
		clientBackPage.finalJudgment(borrowerName, loanAmount, passwordByBack);
		//У������Ƿ�ɹ�
//		clientBackPage.checkTenderState(borrowerName, loanAmount);
		
		base.tearDown();
	}
	
	/**
	 * �������ƣ�ǰ̨_����
	 * ������ţ�754
	 * @author ������
	 */
	public void repayment(String repaymentWay){
		base.setup_ff();
		base.drivermanage();
		
		base.openBrowser(indexURL);
		indexPage.clickLoginLink();
		//����˵�¼
		loginPage.loginWithXpath(borrowerPhone, password);
		//�����ҵ��˻�
		base.openBrowser(myAccountURL);
		base.sleep(3000);
		
		myLoanPage.repayment(repaymentWay);
		
		base.tearDown();
	}
	
	/**
	 * �������ƣ���̨_����
	 * ������ţ�812
	 * @author ������
	 */
	public void tenderFail(){
		System.out.println("�����P1:��̨_����");
		
		base.setup_ie_x86();
		base.drivermanage();
		
		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("��ع���");
		clientBackPage.clickSubMenu("���������б�");
		//�жϴ��������б��Ƿ��н��������
		boolean isTrue = false;
		clientBackPage.selectLoan(clientBackPage.trialTendersIframe);
		isTrue = clientBackPage.isSearchFieldByList(clientBackPage.trialTendersIframe, clientBackPage.tendlistByBorrowerName, borrowerName);
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
		//����
		clientBackPage.tenderFail(borrowerName, passwordByBack);
		
		base.tearDown();
	}
	
	/**
	 * ��顰�۳��ɽ�����ѡ��Ƿ���ȷ
	 * @param loanAmount�������
	 */
	public void checkServiceCharge(String loanAmount){
		base.setup_ff();
		base.drivermanage();
		
		base.openBrowser(indexURL);
		indexPage.clickLoginLink();
		loginPage.loginWithXpath(borrowerPhone, password);
		//�����ҵ��˻�
		base.openBrowser(myAccountURL);
		base.sleep(3000);
		//���뽻�׼�¼
		myAccountPage.turnToMyAccount("���׼�¼");
		base.sleep(3000);
		//У�顰�۳��ɽ�����ѡ��Ƿ���ȷ
		clientBackPage.checkServiceCharge(loanAmount, borrowerEmail);
		base.tearDown();
		
		//��ǰ������
		repayment("all");
	}
	
	/**
	 * �����P1׼������
	 * @param loanAmount�������
	 * @param timeLimit���������
	 */
	public void dataPreparation(String loanAmount, String timeLimit){
		
		//ǰ̨_�������
//		issuedLoan(loanAmount, timeLimit);
//		//��̨_����ѷ����Ľ��
//		tendlistAuditLoan();
//		//��̨_������汦
//		issuedECunBao(loanAmount);
		//ǰ̨_�����ѷ�����汦 �� ��̨_У����汦״̬
//		buyIssuedECunBao(loanAmount);
		//��̨_����ծȯ��
		joinBond();
		//��̨_���뵽��Ʒ
		joinProduct(loanAmount);
		//��̨_ծȨƥ��
		debtOwnerMatching(loanAmount);
		//��̨_�ܲ�����(��������ȡ��)
		//finalJudgment();
		//ǰ̨_�û�ȷ��
		userConfirm(loanAmount);
//		//��̨_ȷ�Ͻ���(�ܲ��û�)
//		confirmTrading(loanAmount);
	}
	
	/**
	 * �����P1׼������
	 * ��ע����Ҫ�޸ķ���ʱ�䣬�������һ���޸ġ������Ӱ���������
	 * @param loanAmount�������
	 * @param timeLimit���������
	 * @param borrowerEmail�����������
	 * @param publishedDate����ķ�������������Ӧ����
	 */
	public void dataPreparation(String loanAmount, String timeLimit, String borrowerEmail, String publishedDate){
		
		//ǰ̨_�������
		issuedLoan(loanAmount, timeLimit);
		//��̨_����ѷ����Ľ��
		tendlistAuditLoan();
		//��̨_������汦
		issuedECunBao(loanAmount);
		//ǰ̨_�����ѷ�����汦 �� ��̨_У����汦״̬
		buyIssuedECunBao(loanAmount);
		//��̨_����ծȯ��
		joinBond();
		//��̨_���뵽��Ʒ
		joinProduct(loanAmount);
		//��̨_ծȨƥ��
		debtOwnerMatching(loanAmount);
		//��̨_�ܲ�����(��������ȡ��)
		//finalJudgment();
		//ǰ̨_�û�ȷ��
		userConfirm(loanAmount);
		//����ǰ��ķ���ʱ���Ϊ�ϴλ����90���
		clientBackPage.updatePublishedDate(borrowerEmail, loanAmount, publishedDate);
		//��̨_ȷ�Ͻ���(�ܲ��û�)
		confirmTrading(loanAmount);
	}
	
	/**
	 * ׼����������
	 * @param loanAmount�������
	 * @param timeLimit���������
	 */
	public void dataPreparationByTenderFail(String loanAmount, String timeLimit){
		//ǰ̨_�������
		issuedLoan(loanAmount, timeLimit);
		//��̨_����
		tenderFail();
	}
	
	/**
	 * ׼����������
	 * ��ע����Ҫ�޸ķ���ʱ��
	 * @param loanAmount�������
	 * @param timeLimit���������
	 * @param borrowerEmail�����������
	 * @param publishedDate����ķ�������������Ӧ����
	 */
	public void dataPreparationByTenderFail(String loanAmount, String timeLimit, String borrowerEmail, String publishedDate){
		//ǰ̨_�������
		issuedLoan(loanAmount, timeLimit);
		//����ǰ��ķ���ʱ���Ϊ�ϴλ����90���
		clientBackPage.updatePublishedDate(borrowerEmail, loanAmount, publishedDate);
		//��̨_����
		tenderFail();
	}
	
}
