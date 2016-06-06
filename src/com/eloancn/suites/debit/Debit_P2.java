package com.eloancn.suites.debit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.*;
import com.eloancn.shared.pages.*;
/*
 * �ҵĽ���
 */
public class Debit_P2{

	Base base = new Base();
	MyAccountPage myAccountPage = new MyAccountPage();
	LoginPage loginpage = new LoginPage();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	MyLoanPage myloanpage = new MyLoanPage();
	AccountInfoPage accountInfo = new AccountInfoPage();
	String CreaterLBDtenderid="",NoncreaterLBDtenderid="";
	String CreaterLBDCode="",NoncreaterLBDCode="";
	String YNDtenderid="";
	String begindate="";
	String LBMembersNum="2��";
	
	String LoanUserName=Data.tel_Loan;
	String UserPwd=Data.password;
	String NoAuthenUserName=Data.run_ECunBao_oldtel;//δ�����֤
	String test_NoAuthenUserName=Data.test_run_ECunBao_oldtel;
	String LBDCreaterUserName=Data.tel_LBDCreaterLoan;
	String LBDNoncreaterUserName=Data.tel_LBDNoncreaterLoan;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(myAccountPage.MyAccountUrl);
	}
	
	@AfterClass	
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test (priority = 1)
	//"�ҵĽ��"-"��������"-����������ҳ����ʾ
	public void checkBasicInfoData_3957(){
		Reporter.log("���ҵĽ�-���������ϡ�-����������ҳ����ʾ<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.checkBasicInfoPage();
	}
	
	@Test (priority = 2)
	//"�ҵĽ��"-"��������"-��������ϵ��ҳ����ʾ
	public void checkEmergencyContact_3958(){
		Reporter.log("���ҵĽ�-���������ϡ�-��������ϵ��ҳ����ʾ<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.clickEmergencyContactLnk();
		myloanpage.checkContactPage();
	}
	
	@Test (priority = 3)
	//���ҵĽ�-�������ϴ���-�������ϴ�ҳ���Ĭ��״̬
	public void checkUploadDocPageData_3962(){
		Reporter.log("���ҵĽ�-���������ϡ�-�������ϴ���-�������ϴ�ҳ���Ĭ��״̬<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("�����ϴ�");
		myloanpage.checkUploadDocData();
	}
	
	@Test (priority = 4)
	//"�ҵĽ��"-"��������"-���������ϡ�-����Ա�����䲻�ɱ༭
	public void checkGendarandAge_3861(){
		Reporter.log("�û�����������֤-���ҵĽ�-���������ϡ�-���������ϡ�-����Ա�����䲻�ɱ༭<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.checkGendarandAge();
	}
	
	@Test (priority = 5)
	//"�ҵĽ��"-"��������"-���������ϡ�-���סլ�绰
	public void checkPhone_3863(){
		Reporter.log("�û�����������֤-���ҵĽ�-���������ϡ�-���������ϡ�-���סլ�绰<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.inputPhone("123456789012310");
		myloanpage.inputPhone("12345678901231050");
	}
	
	@Test (priority = 6)
	//"�ҵĽ��"-"��������"-���������ϡ�-���QQ����
	public void checkQQNum_3864(){
		Reporter.log("�û�����������֤-���ҵĽ�-���������ϡ�-���������ϡ�-���QQ����<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.inputQQNum("123456789012345");
		myloanpage.inputQQNum("12345678901234");
		myloanpage.inputQQNum("123456789");
		myloanpage.clearQQNum();
		myloanpage.inputQQNum("12345678901");	
	}
	
	@Test (priority = 7)
	//"�ҵĽ��"-"��������"-���������ϡ�-��鸸ĸ���ڵء��־�ס�ص�ַ
	public void checkAddress_3866(){
		Reporter.log("�û�����������֤-���ҵĽ�-���������ϡ�-���������ϡ�-��鸸ĸ���ڵء��־�ס�ص�ַ<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.inputParentAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklmn");
		myloanpage.inputCurrentAddress("abcdefghijklmnopqrstuvwxyzabcdefghijkl");
		myloanpage.inputParentAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklmno");
		myloanpage.inputCurrentAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklm");
	}
	
	@Test (priority = 8)
	//"�ҵĽ��"-"��������"-���������ϡ�-��鵥λ������ҵ
	public void checkCompanyIndustry_3890(){
		Reporter.log("�û�����������֤-���ҵĽ�-���������ϡ�-���������ϡ�-��鵥λ������ҵ<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.inputCompanyIndustry("abcdefghijklmnopqrstuvwxyzabcdefghijklmn");
		myloanpage.inputCompanyIndustry("abcdefghijklmnopqrstuvwxyzabcdefghijklmno");
	}
	
	@Test (priority = 9)
	//"�ҵĽ��"-"��������"-���������ϡ�-��鵥λ����
	public void checkCompanyName_3891(){
		Reporter.log("�û�����������֤-���ҵĽ�-���������ϡ�-���������ϡ�-��鵥λ����<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.saveCompanyName("0123456789012345678901234567890123456789");
		myloanpage.saveCompanyName("~!@#$%^&*()_+|{}:<>?,./;'[]+=-`~!@#$%^&*");
		myloanpage.saveCompanyName("��λ������������뺺�ֵ�����沢������ť�����޴�����ʾ��λ������������뺺�ֵ��");
		myloanpage.saveCompanyName("abcdefghijklmnopqrstuvwxyzabcdefghijklmn");
		myloanpage.saveCompanyName("0123456789abcdefghij~!@#$%^&*(��λ������������뺺");
	}
	
	@Test (priority = 10)
	//"�ҵĽ��"-"��������"-���������ϡ�-��鵥λ�绰
	public void checkCompanyNum_3892(){
		Reporter.log("�û�����������֤-���ҵĽ�-���������ϡ�-���������ϡ�-��鵥λ�绰<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.inputCompanyPhone("012345678901234567");
		myloanpage.inputCompanyPhone("0123456789012345678");
	}
	
	@Test (priority = 11)
	//"�ҵĽ��"-"��������"-���������ϡ�-��鵥λ��ַ
	public void checkCompanyAddress_3893(){
		Reporter.log("�û�����������֤-���ҵĽ�-���������ϡ�-���������ϡ�-��鵥λ��ַ<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.checkCompanyAddress();
	}
	
	@Test (priority = 12)
	//"�ҵĽ��"-"��������"-���������ϡ�-���������Ϣ
	public void checkDescriptionInfo_3894(){
		Reporter.log("�û�����������֤-���ҵĽ�-���������ϡ�-���������ϡ�-���������Ϣ<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.checkDescriptionInfo();
	}
	
	@Test (priority = 13)
	//"�ҵĽ��"-"��������"-���������ϡ�-�����Ա�����֮�⣬��������ҳ�����Ϣ���޸�
	public void checkModifyBaseInfo_3956(){
		Reporter.log("�û�����������֤-���ҵĽ�-���������ϡ�-���������ϡ�-�����Ա�����֮�⣬��������ҳ�����Ϣ���޸�<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.ModifyBaseInfo();
	}
	
	@Test (priority = 14)
	//�û�δ��������֤-����������������
	public void checkAge_3896(){
		Reporter.log("�û�δ��������֤-���ҵĽ�-���������ϡ�-���������ϡ�-����������������<br/>");
		base.logout();
		loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.saveAge("ʮ��");
		myloanpage.saveAge("as");
		myloanpage.saveAge(">+");
		myloanpage.saveAge(" 4");
		myloanpage.saveAge("4 ");
	}
	
	@Test (priority = 15)
	//�û�δ��������֤-������ѡ����޸�
	public void checkUpdateBaseInfo_3955(){
		Reporter.log("�û�δ��������֤-���ҵĽ�-���������ϡ�-���������ϡ�-������ѡ����޸�<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.checkUpdateBaseInfo();
	}
	
	@Test (priority = 16)
	//�Ǳ���ѡ���У��
	public void checkOptionalOption_3954(){
		Reporter.log("���ҵĽ�-���������ϡ�-���������ϡ�-���Ǳ���ѡ��<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.checkOptionalOption();
	}
	
	@Test (priority = 17)
	//����ѡ���У��
	public void checkRequiredOption_3952(){
		Reporter.log("���ҵĽ�-���������ϡ�-���������ϡ�-������ѡ��<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.checkRequiredOption();
	}
	
	@Test (priority = 18)
	//��������--������ϵ��ҳ��-������ʽ��У��
	public void checkEmergencyNames_3959(){
		Reporter.log("���ҵĽ�-���������ϡ�-���������ϡ�-��������ϵ��ҳ���������ʽ<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.clickEmergencyContactLnk();
		myloanpage.checkEmergencyNames();
	}
	
	@Test (priority = 19)
	//��������--������ϵ��ҳ��-�ֻ���ʽ��У��
	public void checkEmergencyTels_3960(){
		Reporter.log("���ҵĽ�-���������ϡ�-���������ϡ�-��������ϵ��ҳ����ֻ���ʽ<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("��������");
		myloanpage.clickEmergencyContactLnk();
		myloanpage.checkEmergencyTels();
	}
		
	@Test (priority = 20)
	//�ҵĽ���--������-����������ũ�������ɹ�
	public void verifyPublishAgricultureLoan_1370(){
		Reporter.log("�ҵĽ���--������-����������ũ�������ɹ�<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����������ʱ�ϴ��ļ���sikuli���ƻ�ʧ�ܣ�</font><br/>");
		if(base.indexURL.contains("client")){
			base.logout();
			loginpage.loginByMyAccount(LoanUserName,UserPwd,"","","","");
			myAccountPage.turnToMyAccount("������");
			String purpose=loanApplicationPage.loanApplication(true,false,"��ũ��","500","12����","","18","7","����","fx","��������","�Զ������Դ��"+base.RandomNumber(),"�Զ��������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}
	
	@Test (priority = 21)
	//�ҵĽ���--������-�����������̴������ɹ�
	public void verifyPublishBusinessLoan_1372(){
		Reporter.log("�ҵĽ���--������-�����������̴������ɹ�<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����������ʱ�ϴ��ļ���sikuli���ƻ�ʧ�ܣ�</font><br/>");
		if(base.indexURL.contains("client")){
			base.openBrowser(myAccountPage.MyAccountUrl);
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LoanUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			String purpose=loanApplicationPage.loanApplication(true,false,"���̴�","500","12����","","18","7","����","fx","��������","�Զ������Դ��"+base.RandomNumber(),"�Զ��������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}
	
	@Test (priority = 22)
	//�ҵĽ���--������-��������DD�����ɹ�
	public void verifyPublishDDLoan_1374(){
		Reporter.log("�ҵĽ���--������-��������DD�����ɹ�<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����������ʱ�ϴ��ļ���sikuli���ƻ�ʧ�ܣ�</font><br/>");
		if(base.indexURL.contains("client")){
			base.openBrowser(myAccountPage.MyAccountUrl);
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LoanUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			String purpose=loanApplicationPage.loanApplication(true,false,"DD���","1000","12����","","18","7","����","fx","��������","�Զ������Դ��"+base.RandomNumber(),"�Զ��������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}
	
	@Test (priority = 23)
	//�ҵĽ���--������-�����������������ɹ�
	public void verifyPublishCarLoan_1376(){
		Reporter.log("�ҵĽ���--������-�����������������ɹ�<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����������ʱ�ϴ��ļ���sikuli���ƻ�ʧ�ܣ�</font><br/>");
		if(base.indexURL.contains("client")){
			base.openBrowser(myAccountPage.MyAccountUrl);
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LoanUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			String purpose=loanApplicationPage.loanApplication(true,false,"������","500","6����","","18","7","����","fx","��������","�Զ������Դ��"+base.RandomNumber(),"�Զ��������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}		
	
	@Test (priority = 24)
	//�ҵĽ���--������-δ�μ�����������£��鿴�������ҳ��
	public void verifyNotJoinLB_4248(){
		Reporter.log("�ҵĽ���--������-δ�μ�����������£��鿴�������ҳ��<br/>");
		base.logout();
		loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		base.openBrowser(myAccountPage.MyAccountUrl);
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.checkDefaultData();
		loanApplicationPage.selectBidType("������");
		loanApplicationPage.checkLBDLoanPage(false);
	}
	
	@Test (priority = 25)
	//������ҳ���У��
	public void checkPublishLBDwithoutData_4257(){
		Reporter.log("�ҵĽ���--������-����������ڲ������κ���Ϣʱ���ܷ���<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.selectBidType("������");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("������Ҫ����Ľ�");
	}
	
	@Test (priority = 26)
	public void checkApplyOtherTypeLoan_4266(){
		Reporter.log("�ҵĽ���--������-������û����������͵Ľ���ʱ������������������<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����б������������ݿ����⣡</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			base.openBrowser(myAccountPage.MyAccountUrl);
			myAccountPage.turnToMyAccount("������");
			String purpose=loanApplicationPage.loanApplication(false,false,"��ũ��","500","3����","","12","7","����","fx","��������","�Զ�������"+base.RandomNumber(),"�Զ��������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
			myAccountPage.turnToMyAccount("������");
			purpose=loanApplicationPage.loanApplication(false,false,"������","500","1����","5��","","7","����","�ȶ��","��������","�������Զ���"+base.RandomNumber(),"�Զ��������������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}
	
	@Test (priority = 27)
	public void checkCreaterPhaseandRepayMode_4260(){
		Reporter.log("�ҵĽ���--������-��鴴���˵���������1-12���µĽ�����޿�ѡ���⻹�ʽ��13-24���½������ֻ��ѡ��ȶϢ�Ļ��ʽ<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����б������������ݿ����⣡</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.loanApplication(false,false,"������","500","20����","5��","","7","����","������Ϣ","��������","�Զ�����������","�Զ��������������ܹ�����߹�����������������������������������������");
			base.checkAlertText("13�������ϵĽ����ʽֻ��ѡ��ȶϢ");
			myAccountPage.turnToMyAccount("������");
			String purpose=loanApplicationPage.loanApplication(false, false, "������", "500", "1����","5��", "", "7", "����", "�ȶ��", "��������", "�������Զ���"+base.RandomNumber(), "�Զ��������������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.DisableLBCodewithSQL(purpose);
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
			myAccountPage.turnToMyAccount("������");
			purpose=loanApplicationPage.loanApplication(false, false, "������", "500", "5����","5��", "", "7", "����", "������Ϣ", "��������", "�������Զ���"+base.RandomNumber(), "�Զ��������������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.DisableLBCodewithSQL(purpose);
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
			myAccountPage.turnToMyAccount("������");
			purpose=loanApplicationPage.loanApplication(false, false, "������", "500", "13����","5��", "", "7", "����", "�ȶϢ", "��������", "�������Զ���"+base.RandomNumber(), "�Զ��������������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.DisableLBCodewithSQL(purpose);
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
			myAccountPage.turnToMyAccount("������");
			purpose=loanApplicationPage.loanApplication(false, false, "������", "500", "24����","5��", "", "7", "����", "�ȶϢ", "��������", "�������Զ���"+base.RandomNumber(), "�Զ��������������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.DisableLBCodewithSQL(purpose);
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}

	@Test (priority = 28)
	//�����������Ӱ��������߿ɽ���
	public void checkLBDmaxBorrowMoney_4268(){
		Reporter.log("�ҵĽ���--������-��������������Ӱ��������߿ɽ���<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����б������������ݿ����⣡</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.inputBorrowMoney("10");
			String maxmoney = base.getElementTextWithVisible(loanApplicationPage.SXmaxMoney);
			String purpose=loanApplicationPage.loanApplication(false,false,"������","500","2����",LBMembersNum,"","7","����","�ȶ��","��������","�������Զ���"+base.RandomNumber(),"�Զ��������������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			CreaterLBDtenderid= myloanpage.getTenderId(purpose);
			CreaterLBDCode = "LBD"+base.dateFormat(base.getTime(), "yyyyMMdd")+CreaterLBDtenderid;
			myAccountPage.turnToMyAccount("������");
			base.clickWithWait(loanApplicationPage.jkjeTxt);
			base.checkElmentText(loanApplicationPage.SXmaxMoney, maxmoney);	
		}
	}
	
	@Test (priority = 29)
	//�����˲鿴���������ʽ
	public void checkCreaterLBDCode_4283(){
		Reporter.log("�ҵĽ��--�ѷ����Ľ��-�����˲鿴���������ʽ<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickPublishedTab();
			myloanpage.clickLBDBidType(CreaterLBDtenderid);
			base.checkElmentText(myloanpage.LBDCode, "���������룺"+CreaterLBDCode);
		}
	}
	
	@Test (priority = 30)
	//�ҵĽ���--������-�Ѳμ�����������£��鿴�������ҳ��
	public void verifyJoinLB_4249(){
		Reporter.log("�ҵĽ���--������-�Ѳμ�����������£��鿴�������ҳ��<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.selectBidType("������");
			loanApplicationPage.checkLBDLoanPage(true);
		}
	}
	
	@Test (priority = 31)
	//�ҵĽ���--������-����Ѳμ������Ĵ����˲����ٴ������������������������ٴα��޸�
	public void checkCreaterApplyLBDAgain_4263_4281(){
		Reporter.log("�ҵĽ���--������-����Ѳμ������Ĵ����˲����ٴ������������������������ٴα��޸�<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.selectBidType("������");
			base.checkElmentText(loanApplicationPage.LBCode, "��������һ���������ڲ����ظ����");
			loanApplicationPage.selectLBPeopleNum("4��");
			loanApplicationPage.loanApplication(false,false,"������","500","5����","5��","","7","����","������Ϣ","��������","�������Զ���"+base.RandomNumber(),"�Զ��������������ܹ�����߹�����������������������������������������");
			base.checkAlertText("��������һ���������ڲ����ظ����");			
		}
	}
	
	@Test (priority = 32)
	//���������ȡ������������Ӱ�������������������
	public void checkCreaterBorrowMoney_4286(){
		Reporter.log("��鴴���˽��������ȡ������������Ӱ�������������������<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����������ʱ�ϴ��ļ���sikuli���ƻ�ʧ�ܣ�</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickBtn("������");
			myloanpage.QuotaRequest("����������", "1����", "500", "�Զ�����������");
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.loanApplication(false,false,"������","24000","5����","2��","","7","����","������Ϣ","��������","�������Զ���"+base.RandomNumber(),"�Զ��������������ܹ�����߹�����������������������������������������");
			base.checkAlertText("2���������ֻ�ܽ��2��");
			loanApplicationPage.loanApplication(true,false,"������","24000","5����","2��","","7","����","������Ϣ","��������","�������Զ���"+base.RandomNumber(),"�Զ��������������ܹ�����߹�����������������������������������������");
			base.checkAlertText("2���������ֻ�ܽ��2��");
		}
	}
	
	@Test (priority = 33)
	//�ҵĽ���--������-����Ѳμ������Ĵ����˿��������������͵Ľ���
	public void checkCreaterApplyOtherTypesLoan_4264(){
		Reporter.log("�ҵĽ���--������-����Ѳμ������Ĵ����˿��������������͵Ľ���<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����б������������ݿ����⣡</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			base.openBrowser(myAccountPage.MyAccountUrl);
			myAccountPage.turnToMyAccount("������");
			String purpose=loanApplicationPage.loanApplication(false,false,"��ũ��","500","3����","","12","7","����","fx","��������","�Զ�������"+base.RandomNumber(),"�Զ��������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}
	
	@Test (priority = 34)
	public void checkCreaterLBDBorrowPhase_4258(){
		Reporter.log("�ҵĽ���--������-�鿴�����������˵Ľ������Ϊ1-24����<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.selectBidType("������");
		loanApplicationPage.inputBorrowMoney("500");
		loanApplicationPage.checkLBDLoanPhase();
	}
	
	@Test (priority = 35)
	public void checkCreaterLBPeopleNum_4259(){
		Reporter.log("�ҵĽ���--������-�鿴�����������˵���������Ϊ2-5��<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.selectBidType("������");
		loanApplicationPage.inputBorrowMoney("500");
		loanApplicationPage.selectBorrowPhase("1����");
		loanApplicationPage.checkCreaterLBPeopleNum();
	}
		
	@Test (priority = 36)
	public void checkCreaterBorrowRate_4261(){
		Reporter.log("�ҵĽ���--������-�鿴����������������ʱ������޺����������ƥ��<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.selectBidType("������");
		loanApplicationPage.selectBorrowPhase("1����");
		loanApplicationPage.selectBorrowPhase("6����");
		loanApplicationPage.selectBorrowPhase("7����");
		loanApplicationPage.selectBorrowPhase("12����");
		loanApplicationPage.selectBorrowPhase("13����");
		loanApplicationPage.selectBorrowPhase("24����");
	}
	
	@Test (priority = 37)
	public void checkCreaterBorrowMoneyandPNum_4262(){
		Reporter.log("�ҵĽ���--������-�鿴����������������ʱ��2�˵��������������20000,3-5�������30000<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.loanApplication(false,false,"������","25000","20����","2��","","7","����","������Ϣ","��������","�Զ�����������","�Զ��������������ܹ�����߹�����������������������������������������");
		base.checkAlertText("2���������ֻ�ܽ��2��");
		loanApplicationPage.inputBorrowMoney("35000");
		loanApplicationPage.selectLBPeopleNum("3��");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("3-5���������ֻ�ܽ��3��");
		loanApplicationPage.selectLBPeopleNum("4��");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("3-5���������ֻ�ܽ��3��");
		loanApplicationPage.selectLBPeopleNum("5��");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("3-5���������ֻ�ܽ��3��");
		loanApplicationPage.inputBorrowMoney("200");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("����������");
		base.checkElmentText(loanApplicationPage.BorrowMoneyErrorTxt, "������ܵ���500.00Ԫ��");
		loanApplicationPage.inputBorrowMoney("250");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("����������");
		base.checkElmentText(loanApplicationPage.BorrowMoneyErrorTxt, "��������Ϊ100�ı�����");
	}
	
	@Test (priority = 38)
	//ͨ�����ݿ���������������Ա,���̳���ͨ��
	public void AddLBDMembers(){
		Reporter.log("ͨ�����ݿ���������������Ա,���̳���ͨ��<br/>");
		if(base.indexURL.contains("client")){
			myloanpage.addLBDTwoMemeberswithSQL(CreaterLBDCode);
			begindate=myloanpage.addFirstTrialRecordwithSQL(CreaterLBDtenderid);//�����Ӵ˲����жϳ���û��ͨ��
			myloanpage.UpdateTenderStatuswithSQL(CreaterLBDtenderid, "11");
			base.sleep(3000);
		}
	}
	
	@Test (priority = 39)
	//�Ǵ����˼����������
	public void checkNoncreaterLBMembersNum_4270_4282_4283(){
		Reporter.log("�ҵĽ���--������-�鿴�Ǵ��������������������������Զ���ȡ��ʾ�Ҳ����޸�<br/>");
		if(base.indexURL.contains("client")){
			base.logout();
			loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.selectBidType("������");
			base.checkElementVisible(loanApplicationPage.LBCode);
			base.checkElmentText(loanApplicationPage.LBCode, CreaterLBDCode);//�Ǵ��������������
			base.assertTrueByBoolean(base.getElements(loanApplicationPage.LBPeopleNumOption).size()==1);
			base.assertEqualsActualExpected(base.getElementText(loanApplicationPage.LBPeopleNumOption),LBMembersNum);
		}
	}
	
	@Test (priority = 40)
	//�Ǵ����˼��������
	public void checkNoncreaterLoanPhase_4269(){
		Reporter.log("�ҵĽ���--������-�鿴�Ǵ����������������Ľ������<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.selectBidType("������");
			loanApplicationPage.inputBorrowMoney("500");
			loanApplicationPage.checkLBDLoanPhase();
		}
	}
	
	@Test (priority = 41)
	public void checkNoncreaterPhaseandRepayMode_4271(){
		Reporter.log("�ҵĽ���--������-���Ǵ����˵���������1-12���µĽ�����޿�ѡ���⻹�ʽ��13-24���½������ֻ��ѡ��ȶϢ�Ļ��ʽ<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����б������������ݿ����⣡</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.loanApplication(false,false,"������","500","20����",LBMembersNum,"","7","����","������Ϣ","��������","�Զ�����������","�Զ��������������ܹ�����߹�����������������������������������������");
			base.checkAlertText("13�������ϵĽ����ʽֻ��ѡ��ȶϢ");
			myAccountPage.turnToMyAccount("������");
			String purpose=loanApplicationPage.loanApplication(false, false, "������", "500", "1����",LBMembersNum, "", "7", "����", "�ȶ��", "��������", "�Ǵ������Զ���"+base.RandomNumber(), "�Զ��������������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
			myAccountPage.turnToMyAccount("������");
			purpose=loanApplicationPage.loanApplication(false, false, "������", "500", "5����",LBMembersNum, "", "7", "����", "������Ϣ", "��������", "�Ǵ������Զ���"+base.RandomNumber(), "�Զ��������������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
			myAccountPage.turnToMyAccount("������");
			purpose=loanApplicationPage.loanApplication(false, false, "������", "500", "13����",LBMembersNum, "", "7", "����", "�ȶϢ", "��������", "�Ǵ������Զ���"+base.RandomNumber(), "�Զ��������������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
			myAccountPage.turnToMyAccount("������");
			purpose=loanApplicationPage.loanApplication(false, false, "������", "500", "24����",LBMembersNum, "", "7", "����", "�ȶϢ", "��������", "�Ǵ������Զ���"+base.RandomNumber(), "�Զ��������������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
		}
	}
	
	@Test (priority = 42)
	public void checkNoncreaterBorrowRate_4272(){
		Reporter.log("�ҵĽ���--������-�鿴�Ǵ����˽�����޺����������ƥ��<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.selectBidType("������");
			loanApplicationPage.selectBorrowPhase("1����");
			loanApplicationPage.selectBorrowPhase("6����");
			loanApplicationPage.selectBorrowPhase("7����");
			loanApplicationPage.selectBorrowPhase("12����");
			loanApplicationPage.selectBorrowPhase("13����");
			loanApplicationPage.selectBorrowPhase("24����");
		}
	}
	
	@Test (priority = 43)
	public void checkNoncreaterBorrowMoneyandPNum_4273(){
		Reporter.log("�ҵĽ���--������-�鿴�Ǵ��������������������ʽ���ƥ��<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.loanApplication(false,false,"������","25000","20����",LBMembersNum,"","7","����","������Ϣ","��������","�Ǵ������Զ���","�Զ��������������ܹ�����߹�����������������������������������������");
			base.checkAlertText("2���������ֻ�ܽ��2��");
			loanApplicationPage.inputBorrowMoney("200");
			loanApplicationPage.clickPublishLoanBtn();
			base.checkAlertText("����������");
			base.checkElmentText(loanApplicationPage.BorrowMoneyErrorTxt, "������ܵ���500.00Ԫ��");
			loanApplicationPage.inputBorrowMoney("250");
			loanApplicationPage.clickPublishLoanBtn();
			base.checkAlertText("����������");
			base.checkElmentText(loanApplicationPage.BorrowMoneyErrorTxt, "��������Ϊ100�ı�����");
		}
	}
	
	@Test (priority = 44)
	//�Ǵ����������ȡ������������Ӱ�������������������
	public void checkNoncreaterBorrowMoney_4287(){
		Reporter.log("���Ǵ����˽��������ȡ������������Ӱ�������������������<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����������ʱ�ϴ��ļ���sikuli���ƻ�ʧ�ܣ�</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickBtn("������");
			myloanpage.QuotaRequest("����������", "1����", "500", "�Ǵ������Զ�����������");
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.loanApplication(false,false,"������","24000","5����",LBMembersNum,"","7","����","������Ϣ","��������","�Ǵ������Զ���"+base.RandomNumber(),"�Զ��������������ܹ�����߹�����������������������������������������");
			base.checkAlertText("2���������ֻ�ܽ��2��");
			loanApplicationPage.loanApplication(true,false,"������","24000","5����",LBMembersNum,"","7","����","������Ϣ","��������","�Ǵ������Զ���"+base.RandomNumber(),"�Զ��������������ܹ�����߹�����������������������������������������");
			base.checkAlertText("2���������ֻ�ܽ��2��");
		}
	}
	
	@Test (priority = 45)
	//�������Ǵ����˿��������������͵Ľ���
	public void checkNoncreaterApplyOtherTypesLoan_4275_4277(){
		Reporter.log("����������Ǵ����˿��������������͵Ľ���<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.loanApplication(false,false,"��ũ��","500","3����","","12","7","����","fx","��������","�Զ���������ģ��һ","�Զ��������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
		}
	}
	
	@Test (priority = 46)
	//���Ǵ����������������Ӱ��������߿ɽ���
	public void checkNoncreaterLBDmaxBorrowMoney_4279_4277(){
		Reporter.log("�ҵĽ���--������-���Ǵ����������������Ӱ��������߿ɽ���<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">���ܻ���4271������Ӱ�������ʧ�ܣ�</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			base.clickWithWait(loanApplicationPage.jkjeTxt);
			String maxmoney = base.getElementTextWithVisible(loanApplicationPage.SXmaxMoney);
			String purpose=loanApplicationPage.loanApplication(false,false,"������","500","2����",LBMembersNum,"","7","����","�ȶ��","��������","�Ǵ������Զ���"+base.RandomNumber(),"�Զ��������������ܹ�����߹�����������������������������������������");
			loanApplicationPage.isLoanApplicationOK();
			NoncreaterLBDtenderid= myloanpage.getTenderId(purpose);
			myAccountPage.turnToMyAccount("������");
			base.clickWithWait(loanApplicationPage.jkjeTxt);
			base.checkElmentText(loanApplicationPage.SXmaxMoney, maxmoney);	
		}
	}
	
	@Test (priority = 47)
	//�Ǵ����˷����������󣬲鿴��������
	public void checkNoncreaterLBDCode_4283(){
		Reporter.log("�Ǵ����˷��������������������������˵�����������ͬ<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickPublishedTab();
			myloanpage.clickLBDBidType(NoncreaterLBDtenderid);
			base.checkElmentText(myloanpage.LBDCode, "���������룺"+CreaterLBDCode);	
		}
	}
	
	@Test (priority = 48)
	//�Ѳμ������ķǴ������ٴ�������������
	public void checkNoncreaterApplyLBDAgain_4274(){
		Reporter.log("����Ѳμ������ķǴ�����ֻ������һ����������<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("������");
			loanApplicationPage.selectBidType("������");
			base.checkElmentText(loanApplicationPage.LBCode, "һ���������ڲ����ظ����");
			loanApplicationPage.loanApplication(false,false,"������","500","5����",LBMembersNum,"","7","����","������Ϣ","��������","�Ǵ������Զ���"+base.RandomNumber(),"�Զ��������������ܹ�����߹�����������������������������������������");
			base.checkAlertText("һ���������ڲ����ظ����");			
		}
	}
	
	@Test (priority = 49)
	public void checkShowBorrowerownLBD_4256(){
		Reporter.log("�ҵĽ��--�ѷ����Ľ��-�鿴ֻ��ʾ�Լ������������꣬�������������Ϣ<br/>");
		if(base.indexURL.contains("client")){
			base.logout();
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickPublishedTab();
			myloanpage.showOwnLBD(CreaterLBDtenderid,NoncreaterLBDtenderid);
			myloanpage.clickPublishedTab();
			myloanpage.clickLBDBidType(CreaterLBDtenderid);
			myloanpage.checkPopupLBDData(CreaterLBDCode,begindate);
		}
	}
	
	@Test (priority = 50)
	public void checkFailedBid(){
		Reporter.log("ͨ�����ݿ�ʹ�ô����˵�������������<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����б������������ݿ����⣡</font><br/>");
		if(base.indexURL.contains("client")){
			myloanpage.DisableLBCodewithSQL(CreaterLBDCode);
			myloanpage.UpdateTenderStatuswithSQL(CreaterLBDtenderid, "0");
			myloanpage.UpdateTenderStatuswithSQL(NoncreaterLBDtenderid, "0");
		}
	}
	
//	@Test (priority = 7)
//	//����ҵ��˻���ͷ���ҳ����ת�Լ���ʾ
//	public void checkAccountInfoPage_3918(){
//		Reporter.log("����ҵ��˻���ͷ���ҳ����ת�Լ���ʾ");
//		myAccountPage.clickAccountOverviewLnk();
//		myAccountPage.clickUserImageLnk();
//		accountInfo.checkAccountInfoPage();
//	}
//	
//	@Test (priority = 8,enabled=false)
//	//��ע����˺�-��ʼ״̬��ʾĬ��ͷ��
//	public void checkDefaultImg_3919(){
//		Reporter.log("��ע����˺�-��ʼ״̬��ʾĬ��ͷ��");
//		myAccountPage.clickAccountOverviewLnk();
//		myAccountPage.checkDefaultImg();
//		myAccountPage.clickUserImageLnk();
//		accountInfo.checkDefaultImg();
//	}
//	
//	@Test (priority = 9)
//	//����ϴ��޸�ͷ���ܿ���
//	public void checkUploadImg(){
//		myAccountPage.clickAccountInfoLnk();
//		accountInfo.clickUserPhoto();
//		accountInfo.clickCloseUploadLnk();		
//	} 

}
