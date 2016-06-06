package com.eloancn.suites.index;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.RegisterPage;

public class Register_P1 {
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	RegisterPage registerPage =  new RegisterPage();
	Data data = new Data();
	
	String tel = data.phoneConcatenation(0);
	String password = Data.password;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@AfterMethod
	public void logout(){
		base.logout();
	}
	
	/****************************��ɫ*****************************/

	/**
	 * ����Ԫ
	 * ע�� -������ɫ  Ͷ��-���
	 */
	@Test(priority = 1)
	public void registerUpdateRole_web_18() {
		Reporter.log("ע��P1:������ɫ  Ͷ��-���;���-Ͷ��");
		//����ע��ҳ��
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		//�������ҪͶ�ʡ�
		registerPage.selectRole("��ҪͶ��");
		//������ɫ
		registerPage.updateRole();
		//У�������ɫ  ������һ��ҳ��,��ʾ��ɫѡ��
		registerPage.isUpdateRoleOK();
		//�������Ҫ��
		registerPage.selectRole("��Ҫ���");
		//������ɫ
		registerPage.updateRole();
		//У�������ɫ  ������һ��ҳ��,��ʾ��ɫѡ��
		registerPage.isUpdateRoleOK();
	}
	
	/***************************�ֻ���*****************************/

	/**
	 * ����Ԫ
	 * ע�� -��ȷ�ֻ���  
	 */
	@Test(priority = 2)
	public void registerCheckTel_web_19() {
		Reporter.log("ע��P1:�ֻ���,��ȷ�ֻ���,����ע��,�޴�����ʾ;<br/>");
		Reporter.log("ע��P1:�ֻ���,����10λ�ֻ���,��ʾ����д��Ч��11λ�ֻ�����<br/>");
		Reporter.log("ע��P1:�ֻ���,����12λ�ֻ���,��ʾ����д��Ч��11λ�ֻ�����<br/>");
		Reporter.log("ע��P1:�ֻ���,�����Ѿ�ע����ֻ���,��ʾ���ֻ����Ѿ���ע�����<br/>");
		Reporter.log("ע��P1:�ֻ���,����!@#$)(*^%%,��ʾ����д��Ч��11λ�ֻ�����<br/>");
		Reporter.log("ע��P1:�ֻ���,����������������,��ʾ����д��Ч��11λ�ֻ�����<br/>");
		Reporter.log("ע��P1:�ֻ���,����������Ч���ֻ���,��ʾ����д��Ч��11λ�ֻ�����<br/>");
		Reporter.log("ע��P1:�ֻ���,�������ֻ���,��ʾ�������ֻ�����<br/>");
		Reporter.log("ע��P1:�ֻ���,ȫ��״̬�����ֻ���,��ʾ����д��Ч��11λ�ֻ�����<br/>");
		//����ע��ҳ��
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//�������ҪͶ�ʡ�
		registerPage.selectRole("��Ҫ���");
		//������ȷ���ֻ���
		tel = data.phoneConcatenation(0);
		/**�ֻ���,��ȷ�ֻ���,����ע��,�޴�����ʾ**/
		registerPage.inputTel(tel);
		//�뿪�ֻ��������
		registerPage.onblur();
		base.sleep(2000);
		//У���ֻ��������Ƿ���ȷ
		registerPage.isInputTelOK();
		/**����10λ�ֻ���,��ʾ����д��Ч��11λ�ֻ�����**/
		//����10λ�ֻ���
		registerPage.inputTel("131111111");
		//�뿪�ֻ��������
		registerPage.onblur();
		base.sleep(2000);
		//У���ֻ��������Ƿ���ȷ
		registerPage.isMsgOK("phoneError","����д��Ч��11λ�ֻ�����");
		/**����12λ�ֻ���,��ʾ����д��Ч��11λ�ֻ�����**/
		//����12λ�ֻ���
		registerPage.inputTel("131111111111");
		//�뿪�ֻ��������
		registerPage.onblur();
		base.sleep(2000);
		//У���ֻ��������Ƿ���ȷ
		registerPage.isMsgOK("phoneError","����д��Ч��11λ�ֻ�����");
		/**�����Ѿ�ע����ֻ���,��ʾ���ֻ����Ѿ���ע�����**/
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_tel;
		}else {
			tel = Data.tel_run_debit2;
		}
		registerPage.inputTel(tel);
		//�뿪�ֻ��������
		registerPage.onblur();
		base.sleep(2000);
		//У���ֻ��������Ƿ���ȷ
		registerPage.isMsgOK("phoneError","���ֻ����Ѿ���ע�����");
		/**����!@#$)(*^%% ��ʾ����д��Ч��11λ�ֻ�����**/
		registerPage.inputTel("!@#$)(*^%%");
		//�뿪�ֻ��������
		registerPage.onblur();
		base.sleep(2000);
		//У���ֻ��������Ƿ���ȷ
		registerPage.isMsgOK("phoneError","����д��Ч��11λ�ֻ�����");
		/**����������������**/
		registerPage.inputTel("������������");
		//�뿪�ֻ��������
		registerPage.onblur();
		base.sleep(2000);
		//У���ֻ��������Ƿ���ȷ
		registerPage.isMsgOK("phoneError","����д��Ч��11λ�ֻ�����");
		/**����������Ч���ֻ���**/
		registerPage.inputTel("87111111131");
		//�뿪�ֻ��������
		registerPage.onblur();
		base.sleep(2000);
		//У���ֻ��������Ƿ���ȷ
		registerPage.isMsgOK("phoneError","����д��Ч��11λ�ֻ�����");
		/**�������ֻ���**/
		registerPage.inputTel("");
		//�뿪�ֻ��������
		registerPage.onblur();
		base.sleep(2000);
		//У���ֻ��������Ƿ���ȷ
		registerPage.isMsgOK("phoneError","�������ֻ�����");
		/**ȫ��״̬�����ֻ���**/
		registerPage.inputTel("����������������������");
		//�뿪�ֻ��������
		registerPage.onblur();
		base.sleep(2000);
		//У���ֻ��������Ƿ���ȷ
		registerPage.isMsgOK("phoneError","����д��Ч��11λ�ֻ�����");
	}
	
	/****************************����*****************************/
	
	/**
	 * ����Ԫ
	 * ע�� -����  �������¼����
	 */
	@Test(priority = 3)
	public void registerCheckPassword_web_21() {
		Reporter.log("ע��P1:����,�������¼����,��ʾ������6-16�ַ��ĵ�¼����<br/>");
		Reporter.log("ע��P1:����,����12345,��ʾ����̫�̣�����6���ַ�<br/>");
		Reporter.log("ע��P1:����,����12345678912345678,��ʾ����̫�������16���ַ�<br/>");
		Reporter.log("ע��P1:����,����1234567891234567,�޴�����ʾ<br/>");
		Reporter.log("ע��P1:����,����12345 ��5������ո�,��ʾ���������в��ܰ����ո�<br/>");
		Reporter.log("ע��P1:����,���� 12345��1ǰ����ո�,��ʾ���������в��ܰ����ո�<br/>");
		Reporter.log("ע��P1:����,����12 345��3ǰ����ո�,��ʾ���������в��ܰ����ո�<br/>");
		Reporter.log("ע��P1:����,���������ո�,��ʾ���������в��ܰ����ո�<br/>");
		Reporter.log("ע��P1:����,����!@#$~$%^,�޴�����ʾ<br/>");
		Reporter.log("ע��P1:����,�������Ĳ�������,��ʾ���벻����������<br/>");
		Reporter.log("ע��P1:����,�����ֻ�����,�޴�����ʾ<br/>");
		Reporter.log("ע��P1:����,���롡��������������ȫ�ǿո�,�޴�����ʾ<br/>");
		Reporter.log("ע��P1:����,�������abc,��ʾ���벻����������<br/>");
		//����ע��ҳ��
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//�������ҪͶ�ʡ�
		registerPage.selectRole("��Ҫ���");
		/**����������**/
		registerPage.clickPassword();
		registerPage.inputPassword("");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","������6-16�ַ��ĵ�¼����");
		/** ����12345**/
		registerPage.clickPassword();
		registerPage.inputPassword("12345");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","����̫�̣�����6���ַ�");
		/**����12345678912345678**/
		registerPage.inputPassword("12345678912345678");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","����̫�������16���ַ�");
		/**����1234567891234567**/
		registerPage.inputPassword("1234567891234567");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","");
		/**����12345 5������ո�**/
		registerPage.inputPassword("12345 ");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","���������в��ܰ����ո�");
		/**����123451ǰ����ո�**/
		registerPage.inputPassword(" 12345");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","���������в��ܰ����ո�");
		/**����12 345   3ǰ����ո�**/
		registerPage.inputPassword("12 345");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","���������в��ܰ����ո�");
		/**���������ո�**/
		registerPage.inputPassword("      ");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","���������в��ܰ����ո�");
		/**���������ո�**/
		registerPage.inputPassword("!@#$~$%^");
		//�뿪�ֻ��������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","");
		/**�������Ĳ������Ĳ���**/
		registerPage.inputPassword("���Ĳ������Ĳ���");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","���벻����������");
		/**�����ֻ�����**/
		registerPage.inputPassword(tel);
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","");
		/**���롡��������������ȫ�ǿո�**/
		registerPage.inputPassword("������������");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","");
		/**�������abc**/
		registerPage.inputPassword("����abc");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У�����������Ƿ���ȷ
		registerPage.isMsgOK("password","���벻����������");
	}
	
	/****************************��֤��*****************************/
	/**
	 * ����Ԫ
	 * ע�� -��֤��   ������ȷ����֤��,�����һ��
	 */
	@Test(priority = 4)
	public void registerRandcode_web_22() {
		Reporter.log("ע��P1:��֤��,���뵹����֤��,��ʾ��֤�����<br/>");
		Reporter.log("ע��P1:��֤��,������֤���,���ˢ�°�ť,������֮ǰ����֤��,��ʾ��֤�����<br/>");
		Reporter.log("ע��P1:��֤��,������ȷ����֤��,�����һ�����޴�����ʾ��Ϣ,�Ϸ���������ʾ��֤�ֻ���ҳ��<br/>");
		Reporter.log("ע��P1:��֤��,ȫ��״̬������֤��,��ʾ��֤�����<br/>");
		Reporter.log("ע��P1:��֤��,��������֤��,��ʾ��֤�����<br/>");
		Reporter.log("ע��P1:��֤��,������֤���,���ˢ�°�ť,�������µ���֤��,�޴�����ʾ<br/>");
		//����ע��ҳ��
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//�������ҪͶ�ʡ�
		registerPage.selectRole("��Ҫ���");
		tel = data.phoneConcatenation(0);
		/**���뵹����֤��**/
		registerPage.inputRandcode("desc");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У����֤�������Ƿ���ȷ
		registerPage.isMsgOK("rancode","��֤�����");
		/**�������֤��**/
		registerPage.inputRandcode("refreshInputOld");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У����֤�������Ƿ���ȷ
		registerPage.isMsgOK("rancode","��֤�����");
		/**��������֤��**/
		registerPage.inputRandcode("refreshInputNew");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У����֤�������Ƿ���ȷ
		registerPage.isMsgOK("rancode","");
		/**ȫ��״̬������֤��**/
		registerPage.inputRandcode("SBCCase");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У����֤�������Ƿ���ȷ
		registerPage.isMsgOK("rancode","��֤�����");
		/**��������֤��**/
		registerPage.inputRandcode("no");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У����֤�������Ƿ���ȷ
		registerPage.isMsgOK("rancode","��������֤�룡");
		/**��ȷ��֤��**/
		//�����ֻ���
		registerPage.inputTel(tel);
		//��������
		registerPage.clickPassword();
		registerPage.inputPassword(password);
		//������ȷ��֤��
		registerPage.inputRandcode("");
		//�뿪���������
		registerPage.onblur();
		base.sleep(2000);
		//У����֤�������Ƿ���ȷ
		registerPage.isMsgOK("rancode","");
		//��һ��
		registerPage.clickNestStep();
		base.sleep(2000);
		//�Ϸ���������ʾ��֤�ֻ���ҳ��
		registerPage.isTurnVerifyTelPage();
	}
	
	/**********************������֤��************************/
	/**
	 * ����Ԫ
	 * ע�� -������֤��   ������ȷ�Ķ�����֤��
	 */
	@Test(priority = 5)
	public void registerTrueSMSCode_web_26_1() {
		Reporter.log("ע��P1:������֤��,������ȷ�Ķ�����֤��,�޴�����ʾ<br/>");
		if (base.indexURL.contains("/client") || base.indexURL.contains("inclient")) {
			tel = data.phoneConcatenation(0);
			//����ע��ҳ��
			base.openBrowser(base.indexURL  + "/page/register/register.jsp");
			//�������ҪͶ�ʡ�
			registerPage.selectRole("��Ҫ���");
			//��д�˻���Ϣ
			registerPage.setTelInfo(tel,password);
			//�Ƿ������֤�ֻ�����  �Ϸ���������ʾ��֤�ֻ���ҳ��
			//registerPage.isTurnVerifyTelPage();
			//������ȷ������֤��
			registerPage.inputSMSCode(tel,"");
//			//���ע��
//			registerPage.submit();
			//û����ʾ��Ϣ  ��֤ע��ɹ�
			registerPage.isRegisterOK();
			Reporter.log(tel+"ע��ɹ�");
		}
	}
	
	/**
	 * ����Ԫ
	 * ע�� -������֤��   �����ȡ������֤��,֮��,���޸��ֻ���Ϊ����δע����ֻ���,Ȼ��������֤��
	 */
	@Test(priority = 6)
	public void registerOtherSMSCode_web_26_2() {
		Reporter.log("ע��P1:������֤��,�����ȡ������֤��,֮��,���޸��ֻ���Ϊ����δע����ֻ���,Ȼ��������֤��,��ʾ�ֻ���������֤�벻һ�£�<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_Register_tel;
		}else {
			tel = data.phoneConcatenation(0);
		}
		//����ע��ҳ��
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//�������ҪͶ�ʡ�
		registerPage.selectRole("��Ҫ���");
		//��д�˻���Ϣ
		registerPage.setTelInfo(tel,password);
		//�Ƿ������֤�ֻ�����  �Ϸ���������ʾ��֤�ֻ���ҳ��
		//registerPage.isTurnVerifyTelPage();
		//�����ȡ������֤��,֮��,���޸��ֻ���Ϊ����δע����ֻ���,Ȼ��������֤��
		registerPage.inputSMSCode(tel,"other");
		//��ʾ�ֻ���������֤�벻һ�£�
		registerPage.isMsgOK("msgerror","У���벻��ȷ��");//�ֻ���������֤�벻һ�£�
	}
	
	/**
	 * ����Ԫ
	 * ע�� -������֤��   ��Ŀǰ�ֻ���ΪA,δע���ֻ���ΪB,�޸��ֻ���ΪB,Ȼ���ȡ�ֻ���B����֤��,Ȼ���ٴ��޸��ֻ���ΪA,�����ֻ���B����֤��
	 */
	@Test(priority = 7)
	public void registerOtherTelSMSCode_web_26_3() {
		Reporter.log("ע��P1:������֤��,��Ŀǰ�ֻ���ΪA,δע���ֻ���ΪB,�޸��ֻ���ΪB,Ȼ���ȡ�ֻ���B����֤��,Ȼ���ٴ��޸��ֻ���ΪA,�����ֻ���B����֤��,��ʾ�ֻ���������֤�벻һ�£�<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_Register_tel;
		}else {
			tel = data.phoneConcatenation(0);
		}
		//����ע��ҳ��
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//�������ҪͶ�ʡ�
		registerPage.selectRole("��Ҫ���");
		//��д�˻���Ϣ
		registerPage.setTelInfo(tel,password);
		//�Ƿ������֤�ֻ�����  �Ϸ���������ʾ��֤�ֻ���ҳ��
		//registerPage.isTurnVerifyTelPage();
		//��Ŀǰ�ֻ���ΪA,δע���ֻ���ΪB,�޸��ֻ���ΪB,Ȼ���ȡ�ֻ���B����֤��,Ȼ���ٴ��޸��ֻ���ΪA,�����ֻ���B����֤��
		registerPage.inputSMSCode(tel,"otherTel");
		//��ʾ�ֻ���������֤�벻һ�£�
		registerPage.isMsgOK("msgerror","У���벻��ȷ��");//У���벻��ȷ��   �ֻ���������֤�벻һ�£�
	}
	
	/**
	 * ����Ԫ
	 * ע�� -������֤��   �Ⱥ��ȡ2����֤��,�յ��ڶ�����֤���Ժ�,�����һ����֤��
	 */
	@Test(priority = 8)
	public void registerFirstSMSCode_web_26_4() {
		Reporter.log("ע��P1:������֤��, �Ⱥ��ȡ2����֤��,�յ��ڶ�����֤���Ժ�,�����һ����֤��,��ʾ��֤��������˶ԣ�<br/>");
		Reporter.log("ע��P1:������֤��, ����ȫ����֤��,��ʾ��֤��������˶ԣ�<br/>");
		Reporter.log("ע��P1:������֤��,����������֤��,��ʾ��֤��������˶ԣ�<br/>");
		Reporter.log("ע��P1:������֤��,����������֤��,��ʾ��֤��������˶ԣ�<br/>");
		Reporter.log("ע��P1:������֤��,����1234567,��ʾ��֤��������˶ԣ�<br/>");
		Reporter.log("ע��P1:������֤��,����������������,��ʾ��֤��������˶ԣ�<br/>");
		Reporter.log("ע��P1:������֤��,����abcabc,��ʾ��֤��������˶ԣ�<br/>");
		Reporter.log("ע��P1:������֤��,����!!!!!!,��ʾ��֤��������˶ԣ�<br/>");
		Reporter.log("ע��P1:������֤��,�����������֤��,�����һ������ʾ��֤��������˶ԣ�<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_Register_tel;
		}else {
			tel = data.phoneConcatenation(0);
		}
		//����ע��ҳ��
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//�������ҪͶ�ʡ�
		registerPage.selectRole("��Ҫ���");
		//��д�˻���Ϣ
		registerPage.setTelInfo(tel,password);
		//�Ƿ������֤�ֻ�����  �Ϸ���������ʾ��֤�ֻ���ҳ��
		//registerPage.isTurnVerifyTelPage();
		//�Ⱥ��ȡ2����֤��,�յ��ڶ�����֤���Ժ�,�����һ����֤��
		registerPage.inputSMSCode(tel,"first");
		base.sleep(3000);
		//��ʾ��֤��������˶ԣ�
		try {
			registerPage.isMsgOK("msgerror","У���벻��ȷ��");
		} catch (AssertionError e) {
			registerPage.isMsgOK("msgerror","��֤��������˶ԣ�");
		}
		/////////////////////////////
		String code = registerPage.getTelCode(tel);
		//����ȫ����֤��
		registerPage.inputSMSCodeByCode(code,"SBCCase");
		//��ʾ��֤��������˶ԣ�
		registerPage.isMsgOK("msgerror","��֤��������˶ԣ�");
		//����������֤��
		registerPage.inputSMSCodeByCode(code,"desc");
		//��ʾ��֤��������˶ԣ�
		registerPage.isMsgOK("msgerror","��֤��������˶ԣ�");
		registerPage.inputSMSCodeByCode(code,"confuse");
		//��ʾ��֤��������˶ԣ�
		registerPage.isMsgOK("msgerror","��֤��������˶ԣ�");
		//����1234567
		registerPage.inputSMSCodeByCode(code,"1234567");
		base.sleep(5000);
		//��ʾ��֤��������˶ԣ�
		registerPage.isMsgOK("msgerror","��֤�����");
		//����������������
		registerPage.inputSMSCodeByCode(code,"������������");
		//��ʾ��֤��������˶ԣ�
		registerPage.isMsgOK("msgerror","��֤��������˶ԣ�");
		//����abcabc
		registerPage.inputSMSCodeByCode(code,"abcabc");
		//��ʾ��֤��������˶ԣ�
		registerPage.isMsgOK("msgerror","��֤��������˶ԣ�");
		//����!!!!!!
		registerPage.inputSMSCodeByCode(code,"!!!!!!");
		//��ʾ��֤��������˶ԣ�
		registerPage.isMsgOK("msgerror","��֤��������˶ԣ�");
		//�����������֤��,�����һ��
		registerPage.inputSMSCodeByCode(tel,"no");
		registerPage.submit();
		//��ʾ��֤��������˶ԣ�
		registerPage.isNoSMSCodeMesOK();
	}
	
	/**
	 * ����Ԫ
	 * ע�� -������֤��   �������������д��Ϣ��ť   ������һ��ҳ��,��֤��ˢ��,��������
	 */
	@Test(priority = 9)
	public void registerGobackSMSCode_web_26_16() {
		Reporter.log("ע��P1:������֤��,�������������д��Ϣ��ť   ������һ��ҳ��,��֤��ˢ��,��������<br/>");
		if (!base.browserType.contains("ie")) {
			if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
				tel = Data.test_run_Register_tel;
			}else {
				tel = data.phoneConcatenation(0);
			}
			//����ע��ҳ��
			base.openBrowser(base.indexURL  + "/page/register/register.jsp");
			//�������ҪͶ�ʡ�
			registerPage.selectRole("��Ҫ���");
			//��д�˻���Ϣ
			registerPage.setTelInfo(tel,password);
			//�������������д��Ϣ��ť
			registerPage.goback();
			//��֤������һ��ҳ��  ��������
			registerPage.isGoback();
		}else {
			Reporter.log("IE:�����ϼ����ܲ����ݣ���ע�� -������֤��   �������������д��Ϣ��ť   ������һ��ҳ��,��֤��ˢ��,�������գ�<br/>");
		}
	}
	
	/**************************ע��ɹ�ҳ����ʾ***********************/
//	/**
//	 * ����Ԫ
//	 * ע�� -������֤��   �����������֤��,�����һ��
//	 */
//	@Test(priority = 10)
//	public void registerNoSMSCode_web_26_17() {
//		Reporter.log("ע��P1:������֤��,�����������֤��,�����һ������ʾ��֤��������˶ԣ�");
//		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
//			tel = Data.test_run_Register_tel;
//		}else {
//			tel = data.phoneConcatenation(0);
//		}
//		//����ע��ҳ��
//		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
//		//�������ҪͶ�ʡ�
//		registerPage.selectRole("��Ҫ���");
//		//��д�˻���Ϣ
//		registerPage.setTelInfo(tel,password);
//		//�����������֤��,�����һ��
//		registerPage.inputSMSCode(tel,"no");
//		registerPage.submit();
//		//��ʾ��֤��������˶ԣ�
//		registerPage.isNoSMSCodeMesOK();
//	}
	
	/**************************ע��ɹ�ҳ����ʾ***********************/
	/**
	 * ����Ԫ
	 * ע�� -���ͨ��ע����Ϣ�������ע��  ��ʾ�ɹ�ҳ����ʾ,ͨ����Ӫ�̽���û�;��������������һ��ҳ��,ҳ��ʧЧ�����������
	 */
	@Test(priority = 11,enabled=false)
	public void registerOK_web_12_1() {
		Reporter.log("ע��P1:���ͨ��ע����Ϣ�������ע��  ��ʾ�ɹ�ҳ����ʾ,ͨ����Ӫ�̽���û�;��������������һ��ҳ��,ҳ��ʧЧ�����������<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_Register_tel;
		}else {
			tel = data.phoneConcatenation(0);
		}
		//����ע��ҳ��
		base.openBrowser(base.indexURL  + "/page/register/register.jsp");
		//�������ҪͶ�ʡ�
		registerPage.register("debit", tel, password);
		registerPage.isRegisterOK();
		Reporter.log(tel+"ע��ɹ�");
		if (base.browserType.equals("ff")) {
			base.goBack();
			registerPage.isGoback404();
		}else {
			Reporter.log("IE��chrome:����!��ֻ�����ڻ��(ע�� -���ͨ��ע����Ϣ�������ע��  ��ʾ�ɹ�ҳ����ʾ,ͨ����Ӫ�̽���û�;��������������һ��ҳ��,ҳ��ʧЧ�����������)<br/>");
		}
	}
	
	/**
	 * ����Ԫ
	 * ע�� -���ͨ��ע����Ϣ�������ע��  ��ʾ�ɹ�ҳ����ʾ,ͨ����Ӫ�̽���û�,��ʾ�����֤����,��ʾ�� "2���֤��֤"����,1��������
	 */
	@Test(priority = 12,enabled=false)
	public void registerOK_web_12_3(){
		Reporter.log("ע��P1:���ͨ��ע����Ϣ�������ע��  ��ʾ�ɹ�ҳ����ʾ,ͨ����Ӫ�̽���û�,��ʾ�����֤����,��ʾ�� ��2���֤��֤������,1��������<br/>");
		tel = data.phoneConcatenation(0);
		//��ҳ���ע��
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		Reporter.log("������ע��>>>>>>>>");
		Reporter.log("�ֻ���"+tel);
		//ע��
		registerPage.register("debit", tel, password);
		//��֤ע��ɹ�
		registerPage.isRegisterOK();
		//���'ͨ����Ӫ�̽���û�'
		registerPage.clickOperatorDebiterBtn();
		//�жϽ��������֤����
		registerPage.isDebitVerifyPage();		
	}
}
