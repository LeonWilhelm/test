package com.eloancn.suites.debit;

import org.testng.Reporter;
import org.testng.annotations.*;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.AccountInfoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyDebitPlan;
import com.eloancn.shared.pages.MyLoanPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.RegisterPage;
import com.eloancn.shared.pages.SecurityAuthPage;

/*
 * ���������̡�����-����Ԫ
 */
public class Debit {
	
	IndexPage indexPage = new IndexPage();
	RegisterPage registerPage = new RegisterPage();
	Base base = new Base();
	MyAccountPage myAccountPage = new MyAccountPage();
	LoginPage loginPage = new LoginPage();
	MyLoanPage myLoanPage = new MyLoanPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	RechargePage rechargePage = new RechargePage();
	MyDebitPlan myDebitPlan = new MyDebitPlan();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	
	public String email = Data.email;
	public String tel = Data.tel;
	String password = Data.password;
	String zzmm = Data.zzmm;
	String idCard = new Data().idConcatenation();
	String bankAccount = "622848181111111";
	String realName = Data.realName;
	String parentAddress = "�ϵؿ�ʵ����";
	String[] names = Data.names;
	String[] tels = Data.tels;
		
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_register_debit_tel;
			idCard = Data.test_register_debit_idCard;
			realName =  Data.test_register_debit_realName;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.logout();
		base.tearDown();
	}
	
	/**
	 * ����Ԫ
	 * ��Ҫ���-ע��-ͨ����Ӫ�̽���û�-��ת������������֤��ҳ��
	 */
	@Test
	public void register_AT_449(){
		Reporter.log("��������-������ע��:��Ҫ���-ע��-ͨ����Ӫ�̽���û�-��ת������������֤��ҳ��,��ʾ���֤��֤����,1��������<br/>");
		//��ҳ���ע��
		//indexPage.clickRegisterLink();
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		Reporter.log("��ʼ�ֻ���"+tel+"  ���֤��"+idCard+"  ������"+realName+"<br/>");
		System.out.println("��������-������ע��,��ʼ�ֻ���"+tel+"  ���֤��"+idCard+"  ������"+realName);
		//ע��
		tel = registerPage.register("debit", tel, password);
		//��֤ע��ɹ�
		registerPage.isRegisterOK();
		//���'ͨ����Ӫ�̽���û�'
		registerPage.clickOperatorDebiterBtn();
		//�жϽ��������֤����
		registerPage.isDebitVerifyPage();		
	}
	
	/**
	 * ����Ԫ
	 * �����֤
	 */
	@Test(dependsOnMethods="register_AT_449")
	public void idCardIdentification_AT_453(){
		Reporter.log("��������-��������֤ҳ:�����֤,��ת������д���ϡ�ҳ��<br/>");
		//�����֤
		String info[] = registerPage.idCardIdentification(realName,idCard);
		realName = info[0];
		idCard = info[1];
		Reporter.log("�������֤:"+realName+","+idCard+","+tel+"<br/>");
		System.out.println("�������֤:"+realName+","+idCard+","+tel);
		//����������д����
		registerPage.isInfoPage();
	}
	
	/**
	 * ����Ԫ
	 * ������д
	 */
	@Test(dependsOnMethods="idCardIdentification_AT_453")
	public void writeInfo_AT_454(){
		Reporter.log("��������-��������֤ҳ:��д����,��ת���������ҳ��<br/>");
		registerPage.writeInfo();
		registerPage.isSuingLoansPage();
	}
	
	/**
	 * ����Ԫ
	 * �����������Ϣ������ת�����ҵĽ��--�������ϡ�ҳ
	 */
	@Test(dependsOnMethods="writeInfo_AT_454")
	public void addInfo_AT_455(){
		Reporter.log("��������-��������֤ҳ-������:�����������Ϣ������ת�����ҵĽ��--�������ϡ�ҳ<br/>");
		registerPage.suingLoansBtnClick("������Ϣ");
		myAccountPage.isGoMyAccount("�ҵĽ��");
		myLoanPage.isCurrentlocationOK("��������");
	}
	
	/**
	 * ����Ԫ
	 * ��д�������ϣ���ת����������ϵ�ˡ�ҳ
	 */
	@Test(dependsOnMethods="addInfo_AT_455")
	public void setBaseInfo_AT_460(){
		Reporter.log("��������-��������ҳ:���ƻ������ϣ���ת����������ϵ�ˡ�ҳ<br/>");
		myLoanPage.baseInfo(parentAddress);
		myLoanPage.isCurrentInfo("������ϵ��");
	}
	
	/**
	 * ����Ԫ
	 * ������ϵ��������д,���������������ҳ��
	 */
	@Test(dependsOnMethods="setBaseInfo_AT_460")
	public void setEmergencyContact_AT_461(){
		Reporter.log("��������-��������ҳ:���ƽ�����ϵ�ˣ���ת�����������ϡ�ҳ<br/>");
		myLoanPage.writeEmergencyContact(names,tels);
		myLoanPage.isCurrentInfo("��������");
	}
	
	/**
	 * ����Ԫ
	 * �����ҵĽ�� �������� ��������
	 */
	@Test (dependsOnMethods="setEmergencyContact_AT_461")
	public void setCreditInfo_AT_463(){
		Reporter.log("��������-��������ҳ:������������<br/>");
		myLoanPage.writeCreditInfo();
		myLoanPage.isCurrentlocationOK("�����ϴ�");
	}
	
	/**
	 * ����Ԫ
	 * �ϴ�ͷ��
	 */
	@Test (dependsOnMethods="setCreditInfo_AT_463")
	public void setPhoto_AT_466(){
		//indexPage.clickMenu("�ҵ��˻�");
//		base.openBrowser("http://client.eloancn.com/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame("13111111121", "111111");
		Reporter.log("��������-�ҵ��˻�:�ϴ��û�ͷ��<br/>");
		if(!base.browserType.equals("ie")){
			myAccountPage.turnToMyAccount("�˻���Ϣ");
			accountInfoPage.updatePhoto();
			accountInfoPage.isUpdateOK("�ϴ�ͷ�����");
			//�ж��˻�����ͷ�����
			accountInfoPage.isMyAccountPhotoUpdate();
		}
		else{
			Reporter.log("error_ie���������ֶ����ԣ�<br/>");
		}
	}
	
	/**
	 * ����Ԫ
	 * ��ֵ ת�˻��
	 */
//	@Test (priority = 8)
//	public void rechargeTransferRemittance_AT_467(){
//		myAccountPage.turnToMyAccount("��ֵ");
//		rechargePage.rechargeTransferRemittance(realName, idCard, zzmm,"2015-05-01","10","�й�����","1111","�Զ������ԣ���ܣ�лл");
//		//�ж��Ƿ��ֵ�ɹ�
//		rechargePage.isRecharge();
//	}

}
