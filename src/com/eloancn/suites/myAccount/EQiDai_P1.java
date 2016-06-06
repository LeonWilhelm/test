package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ClientBackPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;

/**
 * �����P1
 * @author ������
 */
public class EQiDai_P1 {

	Base base = new Base();
	ClientBackPage clientBackPage = new ClientBackPage();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	EQiDai_P1_DataPreparation dataPreparation = new EQiDai_P1_DataPreparation();
	
	//��������������
	String borrowerEmail = Data.borrowerEmail;
	//��������(���� * 24 * 3600)
	String overdueDay41 = "3542400";
	String overdueDay40 = "3456000";
	//��ķ�������������Ӧ����
	String publishedDate91 = "7862400";
	String publishedDate90 = "7776000";
	//�����_ǰ̨  | �����_��̨ ��ǰ̨���>=��̨����Ϊ100����������10�������ڲ����ظ���
	String loanAmount = Data.loanAmount;
	String loanAmount2 = Data.loanAmount2;
	String loanAmount_Fail = Data.loanAmount_Fail;
//	//���Ŀ��_ǰ̨  | ����_��̨�������ʾ��ǰ��̨һ�£���ʽ��jby�Զ���+����
//	String loanPurpose = "�Զ�������" + loanAmount;
	
	/**
	 * �������ƣ���һ�ν��6���µķ���(ǰ̨_������˷����)
	 * ������ţ�754
	 * @author ������
	 */
	@Test(priority = 1)
	public void borrowerServiceCharge_web_754(){
		Reporter.log("�����_P1:��һ�ν��6���µķ��á��۳��ɽ�����ѣ�0.055%");
		
		//׼������
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//�޸��Ż�״̬��ȷ���ǵ�һ�ν��
		clientBackPage.updatePreferentialState(borrowerEmail);
		//��顰�۳��ɽ�����ѡ��Ƿ���ȷ		
		dataPreparation.checkServiceCharge(loanAmount);
	}
	
	/**
	 * ��һ�ν��6���²��ڻ���ʱ���90���ڣ��ڶ��ν�6���µķ��á��۳��ɽ�����ѣ�0.0325%
	 * ˵����A-B
	 * ������ţ�778
	 * @author ������
	 */
	@Test(priority = 2)
	public void borrowerServiceCharge_web_778(){
		Reporter.log("��һ�ν��6���²��ڻ���ʱ���90���ڣ��ڶ��ν�6���µķ��á�A-B���۳��ɽ�����ѣ�0.0325%");
		
		//׼������
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//��顰�۳��ɽ�����ѡ��Ƿ���ȷ		
		dataPreparation.checkServiceCharge(loanAmount);
	}
	

	/**
	 * ��һ�ν��12���²��ڻ���ʱ���90���ڣ��ڶ��ν�6���µķ��á��۳��ɽ�����ѣ�0.055%
	 * ˵����A12��-B
	 * ������ţ�799
	 * @author ������
	 */
	@Test(priority = 3)
	public void borrowerServiceCharge_web_799(){
		Reporter.log("�����_P1:���12���²��ڻ���ʱ���90���ڣ��ڶ��ν�6���µķ��á�A12��-B���۳��ɽ�����ѣ�0.055%");

		//׼������
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_12);
		//�޸��Ż�״̬��ȷ���ǵ�һ�ν��
		clientBackPage.updatePreferentialState(borrowerEmail);
		//��ǰ������
		dataPreparation.repayment("all");
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6);
		//��顰�۳��ɽ�����ѡ��Ƿ���ȷ		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * ��һ�ν��6���²��ڻ���ʱ���90���ڣ��ڶ��ν�12���µķ��á��۳��ɽ�����ѣ�0.055%
	 * ˵����A-B12��
	 * ������ţ�800
	 * @author ������
	 */
	@Test(priority = 4)
	public void borrowerServiceCharge_web_800(){
		Reporter.log("�����_P1:���6���²��ڻ���ʱ���90���ڣ��ڶ��ν�12���µķ��á�A-B12�¡��۳��ɽ�����ѣ�0.055%");
		
		//׼������
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//�޸��Ż�״̬��ȷ���ǵ�һ�ν��
		clientBackPage.updatePreferentialState(borrowerEmail);
		//��ǰ������
		dataPreparation.repayment("all");
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_12);
		//��顰�۳��ɽ�����ѡ��Ƿ���ȷ		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * ��һ�ν��12���²��ڻ���ʱ���90���ڣ��ڶ��ν�12���µķ��á��۳��ɽ�����ѣ�0.055%
	 * ˵����A12��-B12��
	 * ������ţ�801
	 * @author ������
	 */
	@Test(priority = 5)
	public void borrowerServiceCharge_web_801(){
		Reporter.log("�����_P1:���12���²��ڻ���ʱ���90���ڣ��ڶ��ν�12���µķ��á�A12��-B12�¡��۳��ɽ�����ѣ�0.055%");
		
		//׼������
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_12);
		//�޸��Ż�״̬��ȷ���ǵ�һ�ν��
		clientBackPage.updatePreferentialState(borrowerEmail);
		//��ǰ������
		dataPreparation.repayment("all");
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_12);
		//��顰�۳��ɽ�����ѡ��Ƿ���ȷ		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * ��һ�ν��6��������40���ڻ�����ڻ����90���ڼ�����6���µ���������
	 * ˵����A����40����-B
	 * ������ţ�802
	 * @author ������
	 */
	@Test(priority = 6)
	public void borrowerServiceCharge_web_802(){
		Reporter.log("�����_P1:��һ�ν��6��������40���ڻ�����ڻ����90���ڼ�����6���µ��������A����40����-B���۳��ɽ�����ѣ�0.0325%");
		
		//׼������
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//�޸��Ż�״̬��ȷ���ǵ�һ�ν��
		clientBackPage.updatePreferentialState(borrowerEmail);
		//��ǰ������
		dataPreparation.repayment("all");
		//����״̬��Ϊ�����ڻ��,����40�컹����
		clientBackPage.updateRealDate(borrowerEmail, overdueDay40);
		//׼�����ݣ�����ǰ��ķ���ʱ���Ϊ�ϴλ����90��
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6, borrowerEmail, publishedDate90);
		//��顰�۳��ɽ�����ѡ��Ƿ���ȷ		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * ��һ�ν��6��������40������ϵͳ�渶�����ڻ����90��������6���µ���������
	 * ˵����A����40���,B
	 * ������ţ�803
	 * @author ������
	 */
	@Test(priority = 7)
	public void borrowerServiceCharge_web_803(){
		Reporter.log("�����_P1:��һ�ν��6��������40������ϵͳ�渶�����ڻ����90��������6���µ��������A����40���,B���۳��ɽ�����ѣ�0.055%");
		
		//׼������
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//�޸��Ż�״̬��ȷ���ǵ�һ�ν��
		clientBackPage.updatePreferentialState(borrowerEmail);
		//��ǰ������
		dataPreparation.repayment("all");
		//����״̬��Ϊ�����ڻ��������41�컹����
		clientBackPage.updateRealDate(borrowerEmail, overdueDay41);
		//׼�����ݣ�����ǰ��ķ���ʱ���Ϊ�ϴλ����90��
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6, borrowerEmail, publishedDate91);
		//��顰�۳��ɽ�����ѡ��Ƿ���ȷ		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * ��һ�ν��6������ǰ���»������ڻ����90���ڼ�����6���µĿ�
	 * ˵����A-B
	 * ������ţ�804
	 * @author ������
	 */
	@Test(priority = 8)
	public void borrowerServiceCharge_web_804(){
		Reporter.log("�����_P1:��һ�ν��6������ǰ���»������ڻ����90���ڼ�����6���µĿA-B���۳��ɽ�����ѣ�0.0325%");
		
		//׼������
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//�޸��Ż�״̬��ȷ���ǵ�һ�ν��
		clientBackPage.updatePreferentialState(borrowerEmail);
		//��ǰ������
		dataPreparation.repayment("month");
		//׼�����ݣ�����ǰ��ķ���ʱ���Ϊ�ϴλ����90��
		dataPreparation.dataPreparation(Data.loanAmount2, dataPreparation.timeLimit_6, borrowerEmail, publishedDate90);
		//��顰�۳��ɽ�����ѡ��Ƿ���ȷ		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * ��һ�ν��6���º��»������ڻ����90��������6���µĿ�-----------------------------------δͨ��
	 * ˵����A,B
	 * ������ţ�805
	 * @author ������
	 */
	@Test(priority = 9)
	public void borrowerServiceCharge_web_805(){
		Reporter.log("�����_P1:��һ�ν��6���º��»������ڻ����90��������6���µĿA,B���۳��ɽ�����ѣ�0.055%");
		
		//׼������
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//�޸��Ż�״̬��ȷ���ǵ�һ�ν��
		clientBackPage.updatePreferentialState(borrowerEmail);
		//��ǰ������
		dataPreparation.repayment("month");
		//׼�����ݣ�����ǰ��ķ���ʱ���Ϊ�ϴλ����90��
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6, borrowerEmail, publishedDate91);
		//��顰�۳��ɽ�����ѡ��Ƿ���ȷ		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * ��һ�ν��6���²��ڻ����90���ڣ��ڶ��ν�6���º����꣬�ٷ���6���µĽ��-----------------------------------δ����
	 * ˵��:A-B��-C
	 * ������ţ�812
	 * @author ������
	 */
	@Test(priority = 10)
	public void borrowerServiceCharge_web_812(){
		Reporter.log("�����_P1:��һ�ν��6���²��ڻ����90���ڣ��ڶ��ν�6���º����꣬�ٷ���6���µĽ�A-B��-C���۳��ɽ�����ѣ�0.0325%");
		
		//׼������
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//�޸��Ż�״̬��ȷ���ǵ�һ�ν��
		clientBackPage.updatePreferentialState(borrowerEmail);
		//��ǰ������
		dataPreparation.repayment("month");
		//���꣬������
		dataPreparation.dataPreparationByTenderFail(loanAmount_Fail, dataPreparation.timeLimit_6);
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6);
		//��顰�۳��ɽ�����ѡ��Ƿ���ȷ		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * ��һ�ν��6���²��ڻ����90��󣬵ڶ��ν�6���º����꣬�ٷ���6���µĽ��-----------------------------------δ����
	 * ˵����A,B��-C
	 * ������ţ�813
	 * @author ������
	 */
	@Test(priority = 11)
	public void borrowerServiceCharge_web_813(){
		Reporter.log("�����_P1:��һ�ν��6���²��ڻ����90��󣬵ڶ��ν�6���º����꣬�ٷ���6���µĽ�A,B��-C���۳��ɽ�����ѣ�0.055%");
		
		//׼������
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//�޸��Ż�״̬��ȷ���ǵ�һ�ν��
		clientBackPage.updatePreferentialState(borrowerEmail);
		//��ǰ������
		dataPreparation.repayment("month");
		//���꣬������
		dataPreparation.dataPreparationByTenderFail(loanAmount_Fail, dataPreparation.timeLimit_6, borrowerEmail, publishedDate91);
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6, borrowerEmail, publishedDate91);
		//��顰�۳��ɽ�����ѡ��Ƿ���ȷ		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
}
