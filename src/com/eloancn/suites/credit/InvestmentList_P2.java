package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.DebentureTransferPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
/**
 * Ͷ���б� P2
 * @author ����Ԫ
 */
public class InvestmentList_P2 {
	LoginPage loginPage = new LoginPage();
	Base base = new Base();
	InvestmentListPage investmentListPage = new InvestmentListPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	IndexPage indexPage = new IndexPage();
	DebentureTransferPage debentureTransferPage = new DebentureTransferPage();
	
//	String tel = Data.tel_investmentList_P2;
//	String password = Data.password;
//	String zzmm = Data.zzmm;//֧������
	String tel=Data.tel_Invest;
	String password=Data.password;
	String paypassword=Data.zzmm;
	String tel_noRecharge = Data.run_ECunBao_register;				//���ɻ򱾵�δ��ֵ
	String test_tel_noRecharge = Data.test_run_ECunBao_register;	//testδ��ֵ
	String tel_49yuan = Data.tel_balance_49;			
	String tel_50yuan=Data.tel_balance_50;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(investmentListPage.Url);
//		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
//			tel = Data.test_tel;
//			paypassword = Data.test_zzmm;
//		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * Ͷ���б�-��ҳ�����ĩҳ��ǰһҳ����ҳ����һҳ������ҳ�����Է�ҳ����
	 */
	@Test(priority=1)
	public void turnPage_web_1064(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-��ҳ�����ĩҳ��ǰһҳ����ҳ����һҳ������ҳ�����Է�ҳ����<br/>");
		int step = 0;
		try {
			if (investmentListPage.ifShowPageBtn("ĩҳ")) {
				investmentListPage.clickPage("ĩҳ");
				investmentListPage.isTurnPageOK("ĩҳ");
				Reporter.log("ĩҳ:У��ɹ�");
			}else {
				Reporter.log("ĩҳ:���ɵ��");
			}
			step += 1;
			System.out.println("ĩҳ:У��ɹ�");
		} catch (AssertionError e) {
			Reporter.log("ĩҳ:У��ʧ��");
		}
		try {
			if (investmentListPage.ifShowPageBtn("ǰһҳ")) {
				investmentListPage.clickPage("ǰһҳ");
				investmentListPage.isTurnPageOK("ǰһҳ");
				Reporter.log("ǰһҳ:У��ɹ�");
			}else {
				Reporter.log("ǰһҳ:���ɵ��");
			}
			step += 1;
			System.out.println("ǰһҳ:У��ɹ�");
		} catch (AssertionError e) {
			Reporter.log("ǰһҳ:У��ʧ��");
		}
		try {
			if (investmentListPage.ifShowPageBtn("��ҳ")) {
				investmentListPage.clickPage("��ҳ");
				investmentListPage.isTurnPageOK("��ҳ");
				Reporter.log("��ҳ:У��ɹ�");
			}else {
				Reporter.log("��ҳ:���ɵ��");
			}
			step += 1;
			System.out.println("��ҳ:У��ɹ�");
		} catch (AssertionError e) {
			Reporter.log("��ҳ:У��ʧ��");
		}
		try {
			if (investmentListPage.ifShowPageBtn("��һҳ")) {
				investmentListPage.clickPage("��һҳ");
				investmentListPage.isTurnPageOK("��һҳ");
				Reporter.log("��һҳ:У��ɹ�");
			}else {
				Reporter.log("��һҳ:���ɵ��");
			}
			step += 1;
			System.out.println("��һҳ:У��ɹ�");
		} catch (AssertionError e) {
			Reporter.log("��һҳ:У��ʧ��");
		}
		try {
			if (investmentListPage.ifShowPageBtn("5")) {
				investmentListPage.clickPage("5");
				investmentListPage.isTurnPageOK("5");
				Reporter.log("����ҳ:У��ɹ�");
			}else {
				Reporter.log("û�е���ҳ");
			}
			step += 1;
			System.out.println("����ҳ:У��ɹ�");
		} catch (AssertionError e) {
			Reporter.log("����ҳ:У��ʧ��");
		}
		if (step==5) {
			base.assertTrueByBoolean(true);
		}else {
			base.assertEqualsActualExpectedByBoolean(true, false);
		}
	}

	/**
	 * 1-1�����ʸߵ��ұ���ʾС�����Σ����ʴ�С����
	 * 1-2����������ұ���ʾС�����Σ����޴�С����
	 * 1-3����ɽ����ұ���ʾС�����Σ���ɽ��ȴ�С���
	 */
	@Test(priority=2)
	public void sort_web_498_1(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ʽ�����ʸߵ͡�������ޡ���ɽ�����ʾ���ϵ����Ƿ���<br/>");
		//���ʸߵ͡�������ޡ���ɽ�����ʾ���ϵ����Ƿ���
		investmentListPage.isSanJiaoOK("all");
		Reporter.log("���ʸߵ͡�������ޡ���ɽ�����ʾ���ϵ����Ƿ��ţ�У��ɹ�");
	}
	
	/**
	 * 2-1�����ʸߵ��ұߵ�С�����α�ɵ�������
	 * 2-2��Ͷ���б�����ʰ��Ӵ�С��˳����ʾ
	 */
	@Test(priority=3)
	public void sort_web_498_2(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ʽ�����ʸߵ��ұߵ�С�����α�ɵ�������,���ʰ��Ӵ�С��˳����ʾ<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">ɢ��Ͷ���б���������һֱ������!</font><br/>");
		//������ʸߵ�
		investmentListPage.clickSort("���ʸߵ�");
		//���ʸߵ͡�������ޡ���ɽ�����ʾ���µ����Ƿ���
		investmentListPage.isSanJiaoOK("���ʸߵ�");
		Reporter.log("������ʸߵͣ���ʾ���µ����Ƿ��ţ�У��ɹ�");
		investmentListPage.isSortOK("���ʸߵ�");
		Reporter.log("������ʸߵͣ��Ӵ�С���У�У��ɹ�");
	}
	
	/**
	 * 3-1����������ұߵ�С�����α�ɵ�������
	 * 3-2��Ͷ���б�������޴Ӵ�С˳����ʾ
	 */
	@Test(priority=4)
	public void sort_web_498_3(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ʽ����������ұߵ�С�����α�ɵ�������,������ް��Ӵ�С��˳����ʾ<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">ɢ��Ͷ���б������������һֱ������!</font><br/>");
		//����������
		investmentListPage.clickSort("�������");
		//���������ʾ���µ����Ƿ���
		investmentListPage.isSanJiaoOK("�������");
		Reporter.log("���������޺���ʾ���µ����Ƿ��ţ�У��ɹ�");
		investmentListPage.isSortOK("�������");
		Reporter.log("���������޺󣬴Ӵ�С���У�У��ɹ�");
	}
	
	/**
	 * 4-1����ɽ����ұߵ�С�����α�ɵ�������
	 * 4-2��Ͷ���б����ɽ��ȴӴ�С��ʾ
	 */
	@Test(priority=5)
	public void sort_web_498_4(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ʽ����ɽ����ұߵ�С�����α�ɵ�������,��ɽ��Ȱ��Ӵ�С��˳����ʾ<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">ɢ��Ͷ���б���ɽ�������һֱ������!</font>");
		//�����ɽ���
		investmentListPage.clickSort("��ɽ���");
		//��ɽ�����ʾ���µ����Ƿ���
		investmentListPage.isSanJiaoOK("��ɽ���");
		Reporter.log("�����ɽ��Ⱥ���ʾ���µ����Ƿ��ţ�У��ɹ�");
		investmentListPage.isSortOK("��ɽ���");
		Reporter.log("�����ɽ��Ⱥ󣬴Ӵ�С���У�У��ɹ�");
	}
	
	/**
	 * ���Ĭ�� ��ʾΪ�����е������ұ��е����Ƿ��ţ�
	 */
	@Test(priority=6)
	public void showAllPlaces_web_502_1(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ����Ĭ�� ��ʾΪ�����е������ұ��е����Ƿ��ţ�<br/>");
		investmentListPage.isPlaces("���е���");
	}
	
	/**
	 * ���ָ����ߵ�����е������������Σ�����������ѡ�������
	 */
	@Test(priority=7)
	public void showAllPlacesDiv_web_502_2(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ����ָ����ߵ�����е������������Σ�����������ѡ�������<br/>");
		//������е���
		investmentListPage.clickPlaces();
		//У��չ�����е�����
		investmentListPage.isOpenAllPlacesDiv();
	}
	
	/**
	 * ����������ĸ�������֣������б��м������Ը���ĸ��ͷ��ʡ�ݻ����
	 */
	@Test(priority=8)
	public void showFirstCharPlaces_web_502_4(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ�����������ĸ�������֣������б��м������Ը���ĸ��ͷ��ʡ�ݻ����<br/>");
		//������е���
		investmentListPage.clickPlaces();
		//�������� s
		investmentListPage.inputPlace("s");
		//У�������б����Ƿ�������Ը���ĸ��ͷ��ʡ�ݻ����
		investmentListPage.isFirstChar("s");
	}
	
	/**
	 *ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ���������������Ϊ��ʱ,�����б�����ʾĬ�ϵĳ���
	 */
	@Test(priority=9)
	public void showDefaultPlaces_web_502_5(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ���������������Ϊ��ʱ,�����б�����ʾĬ�ϵĳ���<br/>");
		//������е���
		investmentListPage.clickPlaces();
		//��������Ϊ��
		investmentListPage.inputPlace("");
		//����Ϊ�գ������б����Ƿ���ʾĬ�ϵ���
		investmentListPage.isDefaultValue();
	}
	
	/**
	 * ���ı�����������ڵĳ��л���ʡ��,�������������ť,Ͷ�������ֻ��ʾ�õ����Ľ���,����ѡ���б�����ֻ��ʾѡ����������ƣ�
	 */
	@Test(priority = 10)
	public void searchPlace_web_502_6(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ����ı�����������ڵĳ��л���ʡ��,�������������ť,Ͷ�������ֻ��ʾ�õ����Ľ���,����ѡ���б�����ֻ��ʾѡ����������ƣ�<br/>");
		//������е���
		investmentListPage.clickPlaces();
		//�������뱱��
		investmentListPage.inputAndSelectPlace("����");
		//�����������
		investmentListPage.clickSearch();
		//����ѡ���б�����
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("����ѡ���б�����:У��ɹ�");
		//ֻ��ʾѡ�����������
		investmentListPage.isPlaces("����");
		Reporter.log("ֻ��ʾѡ�����������:У��ɹ�");
		//У����������Ƿ�������������
		investmentListPage.isSearchOK("����");
		Reporter.log("Ͷ�������ֻ��ʾ�õ����Ľ���:У��ɹ�");
	}
	
	/**
	 * Ͷ���б�-����ѡ���ܣ������ı����·������ų����е���������,Ͷ�������ֻ��ʾ�õ����Ľ���,����ѡ���б�����ֻ��ʾѡ����������ƣ�
	 */
	@Test(priority = 11)
	public void searchPlace_web_502_7(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ������ı����·������ų����е���������,Ͷ�������ֻ��ʾ�õ����Ľ���,����ѡ���б�����ֻ��ʾѡ����������ƣ�<br/>");
		//�������
		investmentListPage.clickPlaces();
		//�����ı����·������ų����е��һ������
		String city = investmentListPage.clickHotCity();
		System.out.println("����ѡ�����ų����ǣ�"+city);
		base.sleep(2000);
		//�����������
		base.sleep(3000);
		//����ѡ���б�����
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("����ѡ���б�����:У��ɹ�<br/>");
		//ֻ��ʾѡ�����������
		investmentListPage.isPlaces(city);
		Reporter.log("ֻ��ʾѡ�����������:У��ɹ�<br/>");
		//У����������Ƿ�������������
		investmentListPage.isSearchOK(city);
		Reporter.log("Ͷ�������ֻ��ʾ�õ����Ľ���:У��ɹ�<br/>");
	}
	
	/**
	 * �����ų����·�����ѡ������ʡ,��ʾ��ʡ�ֵĳ��У���ʾѡ����У���ѡ����У�Ͷ���б�ֻ��ʾѡ�г��еĽ��꣬����ѡ���б�����ֻ��ʾѡ��������ƣ�
	 */
	@Test(priority = 12)
	public void searchPlace_web_502_8and9(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ������ų����·��ġ���ѡ��ѡ������ʡ,��ʾ��ʡ�ֵĳ��У���ʾѡ����У���ѡ����У�Ͷ���б�ֻ��ʾѡ�г��еĽ��꣬����ѡ���б�����ֻ��ʾѡ��������ƣ�<br/>");
		//�������
		investmentListPage.clickPlaces();
		//�����ı����·��ġ���ѡ���е��һ��ʡ��
		String province = investmentListPage.clickProvince();
		System.out.println("����ѡ��ʡ���ǣ�"+province);
		//У�������ų����·�����ѡ������ʡ,��ʾ��ʡ�ֵĳ��У���ʾѡ����У�
		investmentListPage.isShowProvinceCitys();
		Reporter.log("���ų����·�����ѡ������ʡ,��ʾ��ʡ�ֵĳ��У���ʾѡ����У�:У��ɹ�<br/>");
		//ѡ�����
		String city =investmentListPage.selectCity();
		Reporter.log("����ѡ�ĳ����ǣ�"+ city);
		//����ѡ���б�����
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("����ѡ���б�����:У��ɹ�<br/>");
		//ֻ��ʾѡ�����������
		investmentListPage.isPlaces(city);
		Reporter.log("ֻ��ʾѡ�����������:У��ɹ�<br/>");
		//У����������Ƿ�������������
		investmentListPage.isSearchOK(city);
		Reporter.log("Ͷ�������ֻ��ʾ�õ����Ľ���:У��ɹ�<br/>");
	}
	
	/*************************�����************************/
	
	/**
	 * ��������,Ͷ���б���ʾ�������
	 */
	@Test(priority = 13)
	public void gongYiDai_web_503(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-���������������,Ͷ���б���ʾ�������<br/>");
		base.openBrowser(base.indexURL+"/new/loadAllTender.action");
		//��������
		investmentListPage.clickGongYiDai();
		//У����ʾ�������
		investmentListPage.isGongyiDai();
		Reporter.log("������������ʾ������꣺У��ɹ�<br/>");
	}
	
	/**
	 * Ͷ���б�-��ҳ�����ĩҳ��ǰһҳ����ҳ����һҳ������ҳ�����Է�ҳ����
	 */
	@Test(priority=14)
	public void gongYiDai_turnPage_web_503_3(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-�������ҳ�����ĩҳ��ǰһҳ����ҳ����һҳ������ҳ�����Է�ҳ����<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		int step = 0;
		try {
			if (investmentListPage.ifShowPageBtn("ĩҳ")) {
				//У����ʾ�������
				investmentListPage.isGongyiDai();
				investmentListPage.clickPage("ĩҳ");
				investmentListPage.isTurnPageOK("ĩҳ");
				Reporter.log("ĩҳ:У��ɹ�");
			}else {
				Reporter.log("ĩҳ:���ɵ��");
			}
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("ĩҳ:У��ʧ��");
		}
		try {
			if (investmentListPage.ifShowPageBtn("ǰһҳ")) {
				//У����ʾ�������
				investmentListPage.isGongyiDai();
				investmentListPage.clickPage("ǰһҳ");
				investmentListPage.isTurnPageOK("ǰһҳ");
				Reporter.log("ǰһҳ:У��ɹ�");
			}else {
				Reporter.log("ǰһҳ:���ɵ��");
			}
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("ǰһҳ:У��ʧ��");
		}
		try {
			if (investmentListPage.ifShowPageBtn("��ҳ")) {
				//У����ʾ�������
				investmentListPage.isGongyiDai();
				investmentListPage.clickPage("��ҳ");
				investmentListPage.isTurnPageOK("��ҳ");
				Reporter.log("��ҳ:У��ɹ�");
			}else {
				Reporter.log("��ҳ:���ɵ��");
			}
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("��ҳ:У��ʧ��");
		}
		try {
			if (investmentListPage.ifShowPageBtn("��һҳ")) {
				//У����ʾ�������
				investmentListPage.isGongyiDai();
				investmentListPage.clickPage("��һҳ");
				investmentListPage.isTurnPageOK("��һҳ");
				Reporter.log("��һҳ:У��ɹ�");
			}else {
				Reporter.log("��һҳ:���ɵ��");
			}
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("��һҳ:У��ʧ��");
		}
		try {
			if (investmentListPage.ifShowPageBtn("5")) {
				//У����ʾ�������
				investmentListPage.isGongyiDai();
				investmentListPage.clickPage("5");
				investmentListPage.isTurnPageOK("5");
				Reporter.log("����ҳ:У��ɹ�");
			}else {
				Reporter.log("û�е���ҳ");
			}
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("����ҳ:У��ʧ��");
		}
		if (step==5) {
			base.assertTrueByBoolean(true);
		}else {
			base.assertEqualsActualExpectedByBoolean(true, false);
		}
	}

	/**
	 * �����
	 * 1-1�����ʸߵ��ұ���ʾС�����Σ����ʴ�С����
	 * 1-2����������ұ���ʾС�����Σ����޴�С����
	 * 1-3����ɽ����ұ���ʾС�����Σ���ɽ��ȴ�С���
	 */
	@Test(priority=15)
	public void gongYiDai_sort_web_503_2_1(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-���������ʽ�����ʸߵ͡�������ޡ���ɽ�����ʾ���ϵ����Ƿ���<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		//���ʸߵ͡�������ޡ���ɽ�����ʾ���ϵ����Ƿ���
		investmentListPage.isSanJiaoOK("all");
		Reporter.log("���ʸߵ͡�������ޡ���ɽ�����ʾ���ϵ����Ƿ��ţ�У��ɹ�<br/>");
	}
	
	/**
	 * �����
	 * 2-1�����ʸߵ��ұߵ�С�����α�ɵ�������
	 * 2-2��Ͷ���б�����ʰ��Ӵ�С��˳����ʾ
	 */
	@Test(priority=16)
	public void gongYiDai_sort_web_503_2_2(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-���������ʽ�����ʸߵ��ұߵ�С�����α�ɵ�������,���ʰ��Ӵ�С��˳����ʾ<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		//������ʸߵ�
		investmentListPage.clickSort("���ʸߵ�");
		//���ʸߵ͡�������ޡ���ɽ�����ʾ���µ����Ƿ���
		investmentListPage.isSanJiaoOK("���ʸߵ�");
		Reporter.log("������ʸߵͣ���ʾ���µ����Ƿ��ţ�У��ɹ�<br/>");
		investmentListPage.isSortOK("���ʸߵ�");
		//У����ʾ�������
		investmentListPage.isGongyiDai();
		Reporter.log("������ʸߵͣ��Ӵ�С���У�У��ɹ�<br/>");
	}
	
	/**
	 * �����
	 * 3-1����������ұߵ�С�����α�ɵ�������
	 * 3-2��Ͷ���б�������޴Ӵ�С˳����ʾ
	 */
	@Test(priority=17)
	public void gongYiDai_sort_web_503_2_3(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-���������ʽ����������ұߵ�С�����α�ɵ�������,������ް��Ӵ�С��˳����ʾ<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		//����������
		investmentListPage.clickSort("�������");
		//���������ʾ���µ����Ƿ���
		investmentListPage.isSanJiaoOK("�������");
		Reporter.log("���������޺���ʾ���µ����Ƿ��ţ�У��ɹ�<br/>");
		investmentListPage.isSortOK("�������");
		//У����ʾ�������
		investmentListPage.isGongyiDai();
		Reporter.log("���������޺󣬴Ӵ�С���У�У��ɹ�<br/>");
	}
	
	/**
	 * 4-1����ɽ����ұߵ�С�����α�ɵ�������
	 * 4-2��Ͷ���б����ɽ��ȴӴ�С��ʾ
	 */
	@Test(priority=18)
	public void gongYiDai_sort_web_503_2_4(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-���������ʽ����ɽ����ұߵ�С�����α�ɵ�������,��ɽ��Ȱ��Ӵ�С��˳����ʾ<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		//�����ɽ���
		investmentListPage.clickSort("��ɽ���");
		//��ɽ�����ʾ���µ����Ƿ���
		investmentListPage.isSanJiaoOK("��ɽ���");
		Reporter.log("�����ɽ��Ⱥ���ʾ���µ����Ƿ��ţ�У��ɹ�<br/>");
		investmentListPage.isSortOK("��ɽ���");
		//У����ʾ�������
		investmentListPage.isGongyiDai();
		Reporter.log("�����ɽ��Ⱥ󣬴Ӵ�С���У�У��ɹ�<br/>");
	}
	
	/**
	 * �����
	 * ���Ĭ�� ��ʾΪ�����е������ұ��е����Ƿ��ţ�
	 */
	@Test(priority=19)
	public void gongYiDai_showAllPlaces_web_503_4_1(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ��������������Ĭ�� ��ʾΪ�����е������ұ��е����Ƿ��ţ�<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		investmentListPage.isPlaces("���е���");
		//У����ʾ�������
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * ��������
	 * ���ָ����ߵ�����е������������Σ�����������ѡ�������
	 */
	@Test(priority=20)
	public void gongYiDai_showAllPlaces_web_503_4_2(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ��������������ָ����ߵ�����е������������Σ�����������ѡ�������<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		//������е���
		investmentListPage.clickPlaces();
		//У��չ�����е�����
		investmentListPage.isOpenAllPlacesDiv();
		//У����ʾ�������
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * ��������������������ĸ�������֣������б��м������Ը���ĸ��ͷ��ʡ�ݻ����
	 */
	@Test(priority=21)
	public void gongYiDai_showFirstPlace_web_503_4_4(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ���������������������ĸ�������֣������б��м������Ը���ĸ��ͷ��ʡ�ݻ����<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		//������е���
		investmentListPage.clickPlaces();
		//�������� s
		investmentListPage.inputPlace("s");
		//У�������б����Ƿ�������Ը���ĸ��ͷ��ʡ�ݻ����
		investmentListPage.isFirstChar("s");
		//У����ʾ�������
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ���������������Ϊ��ʱ,�����б�����ʾĬ�ϵĳ���
	 */
	@Test(priority=22)
	public void gongYiDai_showDefaultPlace_web_503_4_5(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ���������������Ϊ��ʱ,�����б�����ʾĬ�ϵĳ���<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		//������е���
		investmentListPage.clickPlaces();
		//��������Ϊ��
		investmentListPage.inputPlace("");
		//����Ϊ�գ������б����Ƿ���ʾĬ�ϵ���
		investmentListPage.isDefaultValue();
		//У����ʾ�������
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * �������������ı�����������ڵĳ��л���ʡ��,�������������ť,Ͷ�������ֻ��ʾ�õ����Ľ���,����ѡ���б�����ֻ��ʾѡ����������ƣ�
	 */
	@Test(priority = 23)
	public void gongYiDai_searchPlace_web_503_4_6(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ��������������ı�����������ڵĳ��л���ʡ��,�������������ť,Ͷ�������ֻ��ʾ�õ����Ľ���,����ѡ���б�����ֻ��ʾѡ����������ƣ�<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		//������е���
		investmentListPage.clickPlaces();
		//�������뱱��
		investmentListPage.inputAndSelectPlace("����");
		base.sleep(10000);
		//�����������
		investmentListPage.clickSearch();
		//����ѡ���б�����
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("����ѡ���б�����:У��ɹ�<br/>");
		//ֻ��ʾѡ�����������
		investmentListPage.isPlaces("����");
		Reporter.log("ֻ��ʾѡ�����������:У��ɹ�<br/>");
		//У����������Ƿ�������������
		investmentListPage.isSearchOK("����");
		Reporter.log("Ͷ�������ֻ��ʾ�õ����Ľ���:У��ɹ�<br/>");
		//У����ʾ�������
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * Ͷ���б�-����ѡ���ܣ����������������ı����·������ų����е���������,Ͷ�������ֻ��ʾ�õ����Ľ���,����ѡ���б�����ֻ��ʾѡ����������ƣ�
	 */
	@Test(priority = 24)
	public void gongYiDai_searchPlace_web_503_4_7(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ����������������ı����·������ų����е���������,Ͷ�������ֻ��ʾ�õ����Ľ���,����ѡ���б�����ֻ��ʾѡ����������ƣ�<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		//�������
		investmentListPage.clickPlaces();
		//�����ı����·������ų����е��һ������
		String city = investmentListPage.clickHotCity();
		System.out.println("����ѡ�����ų����ǣ�"+city);
		base.sleep(2000);
		//�����������
		base.sleep(3000);
		//����ѡ���б�����
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("����ѡ���б�����:У��ɹ�<br/>");
		//ֻ��ʾѡ�����������
		investmentListPage.isPlaces(city);
		Reporter.log("ֻ��ʾѡ�����������:У��ɹ�<br/>");
		//У����������Ƿ�������������
		investmentListPage.isSearchOK(city);
		Reporter.log("Ͷ�������ֻ��ʾ�õ����Ľ���:У��ɹ�<br/>");
		//У����ʾ�������
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * ���������������ų����·�����ѡ������ʡ,��ʾ��ʡ�ֵĳ��У���ʾѡ����У���ѡ����У�Ͷ���б�ֻ��ʾѡ�г��еĽ��꣬����ѡ���б�����ֻ��ʾѡ��������ƣ�
	 */
	@Test(priority = 25)
	public void gongYiDai_hot_web_503_4_8and9(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-����ѡ���ܣ����������������ų����·�����ѡ������ʡ,��ʾ��ʡ�ֵĳ��У���ʾѡ����У���ѡ����У�Ͷ���б�ֻ��ʾѡ�г��еĽ��꣬����ѡ���б�����ֻ��ʾѡ��������ƣ�<br/>");
		//��������
		investmentListPage.clickGongYiDai();
		//�������
		investmentListPage.clickPlaces();
		//�������ų����·��ġ���ѡ�񡱵��һ��ʡ��
		String province = investmentListPage.clickProvince();
		System.out.println("����ѡ��ʡ���ǣ�"+province);
		//У�������ų����·�����ѡ������ʡ,��ʾ��ʡ�ֵĳ��У���ʾѡ����У�
		investmentListPage.isShowProvinceCitys();
		Reporter.log("���ų����·�����ѡ������ʡ,��ʾ��ʡ�ֵĳ��У���ʾѡ����У�:У��ɹ�<br/>");
		//ѡ�����
		String city =investmentListPage.selectCity();
		Reporter.log("����ѡ�ĳ����ǣ�"+ city);
		//����ѡ���б�����
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("����ѡ���б�����:У��ɹ�<br/>");
		//ֻ��ʾѡ�����������
		investmentListPage.isPlaces(city);
		Reporter.log("ֻ��ʾѡ�����������:У��ɹ�<br/>");
		//У����������Ƿ�������������
		investmentListPage.isSearchOK(city);
		Reporter.log("Ͷ�������ֻ��ʾ�õ����Ľ���:У��ɹ�<br/>");
		//У����ʾ�������
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * Ͷ���б�-�������ɸѡ����,Ĭ��ѡ�в�����,ѡ�����Ϊ��ɫ
	 */
	@Test(priority = 26)
	public void debitTypeFilter_web_525_1(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-�������ɸѡ����,Ĭ��ѡ�в�����,ѡ�����Ϊ��ɫ<br/>");
		base.openBrowser(investmentListPage.Url);
		investmentListPage.isTypeBackgroundRed("����");
	}
	
	/**
	 * Ͷ���б�-�������ɸѡ����,������ý��,ѡ�����Ϊ��ɫ,Ͷ���б���ʾ�������Ϊ���ý���ı�
	 */
	@Test(priority = 27)
	public void debitTypeFilter_web_525_2(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-�������ɸѡ����,������ý����,ѡ�����Ϊ��ɫ,Ͷ���б���ʾ�������Ϊ���ý���ı�<br/>");
		investmentListPage.clickType("���ý��");
		investmentListPage.isTypeBackgroundRed("���ý��");
		investmentListPage.isTypeBiao("���ý��");
	}
	
	/**
	 * Ͷ���б�-�������ɸѡ����,���������Ѻ,ѡ�����Ϊ��ɫ,Ͷ���б���ʾ�������Ϊ������Ѻ�ı�
	 */
	@Test(priority = 28)
	public void debitTypeFilter_web_525_3(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-�������ɸѡ����,���������Ѻ,ѡ�����Ϊ��ɫ,Ͷ���б���ʾ�������Ϊ������Ѻ�ı�<br/>");
		investmentListPage.clickType("������Ѻ");
		investmentListPage.isTypeBackgroundRed("������Ѻ");
		investmentListPage.isTypeBiao("������Ѻ");
	}
	
	/**
	 * Ͷ���б�-�������ɸѡ����,������ݵ�Ѻ,ѡ�����Ϊ��ɫ,Ͷ���б���ʾ�������Ϊ���ݵ�Ѻ�ı�
	 */
	@Test(priority = 29)
	public void debitTypeFilter_web_525_4(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-�������ɸѡ����,������ݵ�Ѻ,ѡ�����Ϊ��ɫ,Ͷ���б���ʾ�������Ϊ���ݵ�Ѻ�ı�<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">���ɻ����ϡ����ݵ�Ѻ���ı�һֱ�����⣬�еı겻��ʾ��������־��</font><br/>");
		investmentListPage.clickType("���ݵ�Ѻ");
		investmentListPage.isTypeBackgroundRed("���ݵ�Ѻ");
		investmentListPage.isTypeBiao("���ݵ�Ѻ");
	}
	
	/**
	 * Ͷ���б�-Ͷ�����-������ʾ
	 * ��鴰�����������Ƿ���������һ��
	 * ���㻹�����Ƿ���ȷ������ܽ��-��Ͷ�ʽ��=�����
	 * �����������ʾ�Ƿ���ȷ��������˻��Ŀ������һ�£�
	 * ����������Ϸ�,�ر�Ͷ�����
	 */
	@Test(priority = 30)
	public void verifyBitWindowData_web_596(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-������ʾ.��鴰�����������Ƿ���������һ��,���㻹�����Ƿ���ȷ������ܽ��-��Ͷ�ʽ��=�����,�����������ʾ�Ƿ���ȷ��������˻��Ŀ������һ�£�,����������Ϸ�,�ر�Ͷ�����<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">����ڼ��ɻ����ϱ��������Ƕ�ʱ�����µ�ʱ������ˡ�����Ͷ�ʡ������Ե��</font><br/>");
		//ȥ�ҵ��˻��鿴ʣ����
		base.openBrowser(myAccountPage.MyAccountUrl);
		loginPage.loginWithNoFrame(tel, password);
		double balance = myAccountPage.getBalance();
		//У��
		base.openBrowser(investmentListPage.Url);
		investmentListPage.isDebitWindowDataIdentical(balance);
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--����
	 * �����ֵ����  ��������ֵҳ��
	 */
	@Test(priority = 31)
	public void verifyBitWindowLink_web_597_1(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-����.�����ֵ����  ��������ֵҳ��<br/>");
		base.openBrowser(investmentListPage.Url);
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//���Ͷ�ʴ��ڵĳ�ֵ
			investmentListPage.clickRecharge();
			//У����ת���ҵ��˻�  ��ֵ
			base.assertTrueByBoolean(base.checkTitleContains(PageTitles.woDeZhangHu));
			myAccountPage.isGoMyAccount("��ֵ");
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��<br/>");
		}
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--����
	 * ���������������  ת���һ�����ҳ��
	 */
	@Test(priority = 32)
	public void verifyBitWindowLink_web_597_2(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-����.���������������  ת���һ�����ҳ��<br/>");
		base.openBrowser(investmentListPage.Url);
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//���Ͷ�ʴ��ڵ���������
			investmentListPage.clickForgetPassword();
			base.sleep(1000);
			//У����ת���һ�֧������ҳ
			base.assertTrueByBoolean(base.checkTitleContains("�һ�֧������"));
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��");
		}
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--����
	 * ����Զ�Ͷ������  �����Զ�Ͷ������ҳ��
	 */
	@Test(priority = 33)
	public void verifyBitWindowLink_web_597_3(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-����.����Զ�Ͷ������  �����Զ�Ͷ������ҳ��<br/>");
		base.openBrowser(investmentListPage.Url);
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//���Ͷ�ʴ��ڵ��Զ�Ͷ��
			investmentListPage.clickAutoBid();
			if(base.gethandelsNum()==2){
				base.turnToNewPage();
			}
			//У����ת���ҵ��˻�  �Զ�Ͷ��
			base.assertTrueByBoolean(base.checkTitleContains(PageTitles.woDeZhangHu));
			myAccountPage.isGoMyAccount("�Զ�Ͷ��");
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��");
		}
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--�Զ����빦��
	 * ���ý�����50С�ڻ�����,�������ı�����ʾ�����ý����;���ý����ڻ����ȵ���Զ�����,�������ı�����ʾ�������Ƚ����
	 */
	@Test(priority = 34)
	public void autoInput_web_598_4and5(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-�Զ����빦��.���ý�����50С�ڻ�����,�������ı�����ʾ�����ý����;���ý����ڻ����ȵ���Զ�����,�������ı�����ʾ�������Ƚ����<br/>");
		base.openBrowser(investmentListPage.Url);
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//У���Ƿ����п�Ͷ�ʵ�ɢ���Զ������Ƿ���ȷ
		investmentListPage.isAllAutoInputOk();
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--�������ı���
	 * �����Ϊ��
	 */
	@Test(priority = 35)
	public void amountInput_web_601(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-�������ı���.������Ϊ��,��ʾ��Ͷ���������������<br/>");
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-�������ı���.������Ϊfsdfgd,��ʾ��Ͷ���������������<br/>");
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-�������ı���.������Ϊ23,��ʾ��Ͷ��������50Ԫ��<br/>");
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-�������ı���.���볬���ı��򳤶�,��ʾ���˻�����<br/>");
		base.openBrowser(investmentListPage.Url);
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//���ȷ��
			investmentListPage.clickBidBtn();
			base.checkAlertText("Ͷ���������������");
			
			//������Ϊfsdfgd
			investmentListPage.sendKeyInputMoneyTxt("fsdfgd");
			//���ȷ��
			investmentListPage.clickBidBtn();
			base.checkAlertText("Ͷ���������������");
			
			//������Ϊ23
			investmentListPage.sendKeyInputMoneyTxt("23");
			//���ȷ��
			investmentListPage.clickBidBtn();
			base.checkAlertText("Ͷ��������50Ԫ��");
			
			//��������������
			investmentListPage.sendKeyInputMoneyTxt("111111111111111111111111111111111111111111111111111111111111");
			//���ȷ��
			investmentListPage.clickBidBtn();
			base.checkAlertText("�˻�����");
			//�ر�Ͷ�ʴ���
			investmentListPage.closeBitWindow();
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��");
		}
	}
	
//	/**
//	 * Ͷ���б�--Ͷ�ʴ��ڲ���--�������ı���
//	 * ���ڻ����Ƚ����С���˻����ö��,��ʾ���˻�����
//	 */
//	@Test(priority = 40)
//	public void amountInput_web_601_4(){
//		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-�������ı���.���ڻ����Ƚ����С���˻����ö��,��ʾ���˻�����");
//		base.openBrowser(base.indexURL+"/new/loadAllTender.action");
//		//��¼
//		tel = Data.tel_investmentList_P2;
//		//δ��¼  �ȵ�¼
//		if (!loginPage.ifLogin()) {
//			indexPage.clickLoginLink();
//			loginPage.login(tel, password);
//		}
//		//�Ƿ��п���Ͷ��  �еĻ����
//		
//	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--֧�������ı���
	 * ֧�����룺Ϊ��,��ʾ��֧�����벻��Ϊ��
	 */
	@Test(priority = 36)
	public void payPasswordInput_web_608(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-֧�������ı���.֧�����룺Ϊ��,��ʾ��֧�����벻��Ϊ��<br/>");
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-֧�������ı���.֧�����룺С����λ,��ʾ��֧�������ʽ����<br/>");
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-֧�������ı���.֧�����룺���������,��֤�룺Ϊ��,��ʾ����֤�벻��Ϊ��<br/>");
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-֧�������ı���.֧�����룺���볬��16λ,�ﵽ16λʱ�����޷�Ӧ�����ֻ������16λ��<br/>");
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-֧�������ı���.֧�����룺��ȷ������,��֤�룺��ȷ��֤��,��ʾ��Ͷ��ɹ�<br/>");
		//base.openBrowser(base.indexURL+"/new/loadAllTender.action");
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//������Ϊ100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//���ȷ��
			investmentListPage.clickBidBtn();
			base.checkAlertText("֧�����벻��Ϊ�գ�");
			
			//����֧������
			investmentListPage.sendKeyPayPasswordTxt("111");
			//���ȷ��
			investmentListPage.clickBidBtn();
			base.checkAlertText("֧�������ʽ���ԣ�");
			
			//�������֧������
			investmentListPage.sendKeyPayPasswordTxt("111333");
			//���ȷ��
			investmentListPage.clickBidBtn();
			base.checkAlertText("��֤�벻��Ϊ�գ�");
			
			//�������֧������
			investmentListPage.sendKeyPayPasswordTxt("111333");
			//������ȷ��֤��
			investmentListPage.sendKeyVerificationCodeTxt(investmentListPage.getVerificationCode());
			//���ȷ��
			investmentListPage.clickBidBtn();
			//��ʾ��֧���������
			investmentListPage.isWrong("֧���������");
			investmentListPage.clickBidSuccessCloseBtn();
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��<br/>");
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//������Ϊ100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//���볬��16λ
			investmentListPage.sendKeyPayPasswordTxt("11111111111111111");
			//У�����볤��
			investmentListPage.isPayPasswordLenthOK();
			
			investmentListPage.fastInvest("100",paypassword);
			investmentListPage.isBitOk();
			//�ر�Ͷ�ʴ���
			//investmentListPage.closeBitWindow();
			investmentListPage.clickBidSuccessCloseBtn();
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��<br/>");
		}
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--��֤��
	 * ��֤��Ϊ��,��ʾ����֤�벻��Ϊ��
	 */
	@Test(priority = 37)
	public void verificationCode_web_609(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-��֤��.��֤��Ϊ��,��ʾ����֤�벻��Ϊ��<br/>");
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-��֤��.��֤��:�������֤�루���߳���4Ϊ�����֣�,��ʾ����֤�������������������룡<br/>");
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-��֤��.��������ȷ��֤�룬������֤��,��ʾ����֤�������������������룡<br/>");
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-��֤��.��֤��:���������ַ���������ĸ���֣�,��ʾ����֤�������������������룡<br/>");
		//base.openBrowser(base.indexURL+"/new/loadAllTender.action");
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//������Ϊ100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//����֧������
			investmentListPage.sendKeyPayPasswordTxt(paypassword);
			//���ȷ��
			investmentListPage.clickBidBtn();
			base.checkAlertText("��֤�벻��Ϊ�գ�");
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��<br/>");
		}
		if (investmentListPage.clickKstz()) {	
			//������Ϊ100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//����֧������
			investmentListPage.sendKeyPayPasswordTxt(paypassword);
			//���������֤��
			investmentListPage.sendKeyVerificationCodeTxt("12345");
			//���ȷ��
			investmentListPage.clickBidBtn();
			investmentListPage.isWrong("��֤�������������������룡");
			investmentListPage.clickBidSuccessCloseBtn();
		}
		if (investmentListPage.clickKstz()) {
			//������Ϊ100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//����֧������
			investmentListPage.sendKeyPayPasswordTxt(paypassword);
			//���������֤��
			investmentListPage.sendKeyVerificationCodeTxt(investmentListPage.getVerificationCode());
			//ˢ����֤��
			investmentListPage.refreshVerificationCode();
			//���ȷ��
			investmentListPage.clickBidBtn();
			try {
				investmentListPage.isWrong("��֤�������������������룡");
			} catch (AssertionError e) {
				Reporter.log("���ѽ�����<br/>");
				investmentListPage.isWrong("���ѽ�����");
			}
			investmentListPage.clickBidSuccessCloseBtn();
		}
		if (investmentListPage.clickKstz()) {
			//������Ϊ100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//����֧������
			investmentListPage.sendKeyPayPasswordTxt(paypassword);
			//���������֤��
			investmentListPage.sendKeyVerificationCodeTxt("@!##");
			//���ȷ��
			investmentListPage.clickBidBtn();
			investmentListPage.isWrong("��֤�������������������룡");
			investmentListPage.clickBidSuccessCloseBtn();
		}
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--��֤��
	 * ��֤�룺��ȷ��֤��,��ʾ��Ͷ��ɹ�
	 */
	@Test(priority = 38,enabled=false)
	public void payPasswordInput_web_609_5(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-��֤���ı���.��֤�룺��ȷ��֤��,��ʾ��Ͷ��ɹ�<br/>");
		//base.openBrowser(base.indexURL+"/new/loadAllTender.action");
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			investmentListPage.fastInvest("100",paypassword);
			investmentListPage.isBitOk();
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��<br/>");
		}
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--������ȷ��
	 * �������ȷ,֧�����룺��ȷ,��֤�룺��ȷ,���ȡ����ť,Ͷ����ڹر���ʾͶ���б�δ֧���ɹ���
	 */
	@Test(priority = 39)
	public void function_web_612_1(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-������ȷ��.�������ȷ,֧�����룺��ȷ,��֤�룺��ȷ,���ȡ����ť,Ͷ����ڹر���ʾͶ���б�δ֧���ɹ���<br/>");
		base.openBrowser(investmentListPage.Url);
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�鿴�ҵ��˻����
		base.openBrowser(myAccountPage.MyAccountUrl);
		base.refreshPage();
		double balbaceBefore = myAccountPage.getBalance();		
		base.openBrowser(investmentListPage.Url);
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//������Ϊ100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//����֧������
			investmentListPage.sendKeyPayPasswordTxt(paypassword);
			//������֤��
			investmentListPage.sendKeyVerificationCodeTxt(investmentListPage.getVerificationCode());
			//���ȡ��
			investmentListPage.clickCancel();
			//У��Ͷ�ʴ�����ʧ
			investmentListPage.isBitWindowDisappear();
			//У��δ֧���ɹ�
			base.openBrowser(myAccountPage.MyAccountUrl);
			base.refreshPage();
			double balbaceAfter = myAccountPage.getBalance();
			base.assertEqualsActualExpectedByDouble(balbaceAfter, balbaceBefore);
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��<br/>");
		}
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--������ȷ��
	 * ��������������Ͷ��ɳɹ���ʾ��,��Ͷ��ɹ���ʾ���е������Ͷ���б�ť����ʾ��ر���ʾͶ���б�
	 */
	@Test(priority = 40)
	public void function_web_612_2and3(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-������ȷ��.��������������Ͷ��ɹ���ʾ��,��Ͷ��ɹ���ʾ���е������Ͷ���б�ť,��ʾ��ر���ʾͶ���б�<br/>");
		base.openBrowser(investmentListPage.Url);
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//����Ͷ��
			investmentListPage.fastInvest("100",paypassword);
			//����Ͷ��ɳɹ���ʾ��
			investmentListPage.isBitOk();
			//��������б�
			investmentListPage.clickBackBtn();
			//��ʾ������ʧ
			investmentListPage.isPromptDisappear();
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��<br/>");
		}
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--������ȷ��
	 * ��������������Ͷ��ɳɹ���ʾ��,��Ͷ��ɹ���ʾ���е�����ҵ��˻��в鿴��ť��ת���ҵ��˻�-ɢ��Ͷ��ҳ
	 */
	@Test(priority = 41)
	public void function_web_612_4(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-������ȷ��.��������������Ͷ��ɳɹ���ʾ��,��Ͷ��ɹ���ʾ���е�����ҵ��˻��в鿴��ť��ת���ҵ��˻�-ɢ��Ͷ��ҳ<br/>");
		base.openBrowser(investmentListPage.Url);
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//����Ͷ��
			investmentListPage.fastInvest("100",paypassword);
			//����Ͷ��ɳɹ���ʾ��
			investmentListPage.isBitOk();
			//���ȥ�ҵ��˻��鿴
			investmentListPage.toUserCenter();
			//ת���ҵ��˻�-ɢ��Ͷ��ҳ
			base.assertTrueByBoolean(base.checkTitleContains(PageTitles.woDeZhangHu));
			myAccountPage.isGoMyAccount("ɢ��Ͷ��");
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��<br/>");
		}
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--������ȷ��
	 * ��������������Ͷ��ɹ���ʾ��,��Ͷ��ɹ���ʾ���е����������ť����ʾ��ڹر���ʾͶ���б�
	 */
	@Test(priority = 42)
	public void function_web_612_5(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-������ȷ��.��������������Ͷ��ɳɹ���ʾ��,��Ͷ��ɹ���ʾ���е����������ť����ʾ��ڹر���ʾͶ���б�<br/>");
		base.openBrowser(investmentListPage.Url);
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//����Ͷ��
			investmentListPage.fastInvest("100",paypassword);
			//����Ͷ��ɳɹ���ʾ��
			investmentListPage.isBitOk();
			//������رա���ť
			investmentListPage.clickBidSuccessCloseBtn();
			//��ʾ������ʧ
			investmentListPage.isPromptDisappear();
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��<br/>");
		}
	}

	/**
	 * Ͷ���б�
	 * �г�ֵ��¼���ҵ�¼״̬���û��������Ͷ�ʰ�ť,����֧������
	 */
	@Test (priority = 43)
	public void bitList_web_567_4(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�,�г�ֵ��¼���ҵ�¼״̬���û��������Ͷ�ʰ�ť,����֧������<br/>");
		//�ǳ�
		base.logout();
		//��ת����Ͷ���б�ҳ
		base.openBrowser(investmentListPage.Url);
		//δ��¼  �ȵ�¼
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			//����֧������
			investmentListPage.isBitWindowDisplay();
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��<br/>");
		}
	}

	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--�Զ����빦��
	 * �������Ϊ49����Զ�����
	 */
	@Test(priority = 44)
	public void autoInput_web_598_2(){
		if (base.indexURL.contains("client")) {
			Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-�Զ����빦��.�������Ϊ49����Զ�����,��ʾ������50������Ͷ��<br/>");
			base.logout();
			base.openBrowser(investmentListPage.Url);
			//��¼
//			tel = Data.tel_balance_49;
			indexPage.clickLoginLink();
			loginPage.login(tel_49yuan, password);
			//�Ƿ��п���Ͷ��  �еĻ����
			if (investmentListPage.clickKstz()) {
				//��֤�Զ�����
				investmentListPage.isAutoInputOk();
				//�ر�Ͷ�ʴ���
				investmentListPage.closeBitWindow();
			}else {
				Reporter.log("û�п�Ͷ�ʵ�ɢ��");
			}
		}
	}
	
	/**
	 * Ͷ���б�--Ͷ�ʴ��ڲ���--�Զ����빦��
	 * �������Ϊ50����Զ�����
	 */
	@Test(priority = 45)
	public void autoInput_web_598_3(){
		if (base.indexURL.contains("client")) {
			Reporter.log("ɢ��Ͷ��P2��Ͷ���б�-Ͷ�����-�Զ����빦��.�������Ϊ50����Զ�����,�������ı�����ʾ��50<br/>");
			base.logout();
			base.openBrowser(investmentListPage.Url);
			//��¼
//			tel = Data.tel_balance_50;
			indexPage.clickLoginLink();
			loginPage.login(tel_50yuan, password);
			//�Ƿ��п���Ͷ��  �еĻ����
			if (investmentListPage.clickKstz()) {
				//���Ͷ�ʴ��ڵ��Զ�����
				investmentListPage.clickAutoInputBtn();
				base.sleep(2000);
				String autoValue = investmentListPage.getAutoValue();
				//�ر�Ͷ�ʴ���
				investmentListPage.closeBitWindow();
				//��֤�Զ�����
				base.assertEqualsActualExpected(autoValue, "50");
			}else {
				Reporter.log("û�п�Ͷ�ʵ�ɢ��<br/>");
			}
		}
	}
	

	/**
	 * Ͷ���б�
	 * ����ע���û�δ�г�ֵ��¼�������Ͷ�ʰ�ť,��ʾ���� ����ȥ��ֵ,��Ͷ��!
	 */
	@Test(priority = 46)
	public void bitList_web_567_1(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�--����ע���û�δ�г�ֵ��¼�������Ͷ�ʰ�ť,��ʾ���� ����ȥ��ֵ,��Ͷ��!<br/>");
		base.logout();
		base.openBrowser(investmentListPage.Url);
		//��¼
		loginPage.login(tel_noRecharge,password,"",test_tel_noRecharge,password,"");
		//�Ƿ��п���Ͷ��  �еĻ����
		if (investmentListPage.clickKstz()) {
			investmentListPage.isShowRecharge();
		}else {
			Reporter.log("û�п�Ͷ�ʵ�ɢ��");
		}
	}
	
	/**
	 * �������ƣ��б�ҳ_δ��¼
	 * ����Ԫ ժ�Խ�����
	 */
	@Test (priority = 47)
	public void bitList_web_567_3(){
		Reporter.log("ɢ��Ͷ��P2��Ͷ���б�,δע���δ��¼�û��������Ͷ�ʰ�ť,У���Ƿ񵯳�����¼������<br/>");
		//�ǳ�
		base.logout();
		//��ת����Ͷ���б�ҳ
		base.openBrowser(investmentListPage.Url);
		//���������Ͷ�ʡ���ť���ڣ���������У���¼DIV�Ƿ���ʾ
		investmentListPage.clickFastInvestBtn();
	}
	
	
	/**
	 * ����ר��-�˵�������ʾ
	 * ��������ר����Ͷ���б������ڽ����еı�ʱ������ר���˵�����С��������ʾ���֣��м�������ʾ���ּ���,����ר�������ڽ����еı�ʱ���˵�С�����в���ʾ
	 */
	@Test (priority = 48)
	public void debentureTransferPageNum_web_743(){
		Reporter.log("ɢ��Ͷ��P2������ר��-�˵�������ʾ,��������ר����Ͷ���б������ڽ����еı�ʱ������ר���˵�����С��������ʾ���֣��м�������ʾ���ּ���,����ר�������ڽ����еı�ʱ���˵�С�����в���ʾ<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">���ɻ���������ר����������ʾһֱ�����⣡</font><br/>");
		//��ת��������ר����ҳ
		base.openBrowser(debentureTransferPage.PageUrl);
		//У������ר��-�˵�������ʾ
		int num = debentureTransferPage.getDebentureTransferNum();
		debentureTransferPage.isDebentureTransferNumOK(num);
	}
}
