package com.eloancn.shared.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.jetty.html.Font;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.model.BondDetailsModel;
import com.eloancn.shared.until.FileUtil;
import com.eloancn.shared.until.RandCodeUtils;

/**
 * ��汦
 */
public class ECunBaoPage {
	
	Base base = new Base();
	Data data = new Data();
	DBData dbData = new DBData();
	
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	TransactionRecordPage transactionRecordPage = new TransactionRecordPage();
	
	/***************��ҳ_Ԫ��***************/
	
	//��ҳ Ͷһ��
	By touYiBiLink = By.xpath("//table[1]//td[@class='hFP_index_more']/parent::tr/preceding-sibling::tr//a[text()='Ͷһ��']");

	/***************�б�ҳ_Ԫ��**************/


	
	/***************�б�ҳ_Ԫ��_banner**************/
	
	By loginBtn = By.linkText("������¼");										//��������¼����ť
	By loginCloseBtn = By.xpath("//a[text()='�ر�']");						//��������¼���رհ�ť
	By bannerTotalData = By.cssSelector(".gdcon.colorFF > p");				//banner����汦������������
	By myECunBaoBtn = By.cssSelector(".gdbtn.font16.colorFF.fontW");		//���ҵ���汦����ť
	
	/***************�б�ҳ_Ԫ��_�б�Ԫ��**************/
	
	By eCunBaoDataTitles = By.xpath("//div[@class='wrap']/div/span[3]");					//��汦���⼯
	By eCunBaoTitle = By.xpath("//span[@class='m_zi2 ml10']");								//������汦����
	
	/***************�б�ҳ_Ԫ��_�б�Ԫ��_ծȨ����**************/
	
	By bondDetails = By.cssSelector(".zqlist");												//���С�ծȨ���顱��ť
	By bondDetailsDIV = By.cssSelector("#messageBoxCard");									//ծȨ����_����
	By bondDetailsDIVTitle = By.cssSelector("#saveTitle");									//ծȨ����_����_Title
	By bondDetailsDIVColumnName = By.cssSelector("#detailstable>thead>tr>th");				//ծȨ����_����_����(�����������⡢��������������֤�š�����˵���������ܶ����)
	By bondDetailsDIVInfo = By.cssSelector("#tenderBody .font14.color6>td");				//ծȨ����_����_��Ϣ(�����������⡢��������������֤�š�����˵���������ܶ�)
	By bondDetailsDIVBtn = By.cssSelector(".xqbtn");										//ծȨ����_����_���С��鿴���顱��ť
	By bondDetailsSeeDIV = By.cssSelector("#xq_content");									//ծȨ����_����_�鿴����_����
	By bondDetailsDIVTab = By.cssSelector(".xq_content_t");									//ծȨ����_����_�鿴����_����Tab��ť
	By bondDetailsDIVClose = By.cssSelector(".tip_close");									//ծȨ����_����_�鿴����_�رհ�ť
	
	/********   �б�ҳ_Ԫ��_�б�Ԫ��_���������߾Ӽ����Э��           **********/
	
	By serviceAgreement = By.cssSelector(".corlan.ml15>a");									//���С����������߾Ӽ����Э�顷
	By serviceAgreementTitle = By.cssSelector(".WordSection1>p>strong>font");				//���������߾Ӽ����Э��_title 
	By serviceAgreementAccessories = By.cssSelector("#tenderBody");							//���������߾Ӽ����Э��_����
	
	/***************�б�ҳ_Ԫ��_�б�Ԫ��_����Զ�ƥ�䷵��**************/
	
	By returnCashTotalLink = By.cssSelector(".u-blue");										//���С�����Զ�ƥ�䷵�֡�����
	By returnCashCloseBtn = By.xpath("//div[@class='gui_close']");							//������򴰿ڹرհ�ť
	
	/***************�б�ҳ_Ԫ��_�б�Ԫ��_�����¼**************/
	
	By recordTotalBtn = By.cssSelector(".twojiantou.shang.jiantou.ml10");					//���С������¼����ť
	By inputRecordOpenDiv = By.xpath("//span[@class='twojiantou shang jiantou ml10 xia']/parent::div/parent::div/parent::div/following-sibling::div[1]");
	By inputRecordOpen = By.cssSelector(".overflowV.wrap.list");							//���м����¼DIV
	
	/***************�б�ҳ_Ԫ��_�б�Ԫ��_��Ͷ**************/
	
	By tenderTotalBtn = By.xpath("//a[contains(text(),'��') and contains(text(),'Ͷ')]");		//����Ͷ�����а�ť
	By tenderDivs = By.xpath("//div[@class='m-layer']");									//����Ͷ������DIV
	By tenderCloseDivBtn = By.xpath("//a[contains(@onclick,'closeBox(')]");					//�رա���Ͷ��DIV��ť
	By operationFailureDiv = By.xpath("//div[@id='fastLender_2']");							//����ʧ��DIV
	By closeOperationFailureDiv = By.xpath("//div[@id='fastLender_2']//a");					//����ʧ��DIV �رհ�ť
	
	
	
	//��ô򿪼�¼��Ԫ��
	public WebElement getInputRecordDiv(){
		return base.getElementNoWait(inputRecordOpenDiv);
	}
	
	/**
	 * ����Ԫ
	 * ��ʾ ��ֵ 
	 */
	public void promptRecharge(){
		base.checkElementVisible(By.cssSelector(".lyct>.textC"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(".lyct>.textC")), "�� ����ȥ��ֵ,��Ͷ��!");
	}
	
	/**
	 * ����Ԫ
	 * �����ֵ
	 */
	public void goRecharge(){
		base.clickWithWait(By.cssSelector(".btn1>input[value='ȥ��ֵ!']"));
	}
	
	/**
	 * ����Ԫ
	 * ��汦Ͷ�ʲ���
	 * @param buyShareNum ����
	 * @param payPwd
	 */
	public void touZi(String buyShareNum,String payPwd,double balance){
		//������ݶ
		indexPage.sendKeyBuyShareTxt(buyShareNum);
		//��֧�����롱
		if (balance<100) {
			base.clickWithWait(By.id("payPwd"));
			//base.sleep(2000);
			Alert alert = base.getAlertwithWait();
			//base.sleep(2000);
			base.assertEqualsActualExpected(alert.getText(), "��������");
			alert.accept();
			closeTouZiEcunBao();
			return;
		}
		indexPage.sendKeyPayPwdTxt(payPwd);
		//��ȡ��֤��
		String verificationCode = data.get(indexPage.getVerificationCodeImg(), base.getWebDriver());
		//������֤��
		indexPage.sendKeyVerificationCode(verificationCode);
		//��ѡ����汦Ͷ��Э�顷
		indexPage.checkECunBaoProtocolAgree();
		//�����ȷ������ť
		indexPage.clickInvestmentOKBtn();   
	}
	
	/**
	 * ����Ԫ
	 * У����汦Ͷ���Ƿ�ɹ�
	 */
	public boolean isTouZiOK(){
		Boolean result = false;
		//�ȴ�DIV��ʾ
		base.checkElementVisible(By.id("fastLender_2"));
		//��ȡ��Ͷ�ʳɹ���DIV��display����ֵ�Ƿ�Ϊblock���������DIV��ʾ
		boolean isInvestmentSuccess = base.isBlock(By.id("fastLender_2"));
		base.assertTrueByBoolean(isInvestmentSuccess);
		//String message = base.getElementText(By.xpath("//div[@id='fastLender_2']/div/span[text()='Ͷ�ʳɹ�']"));
		String message = base.getElementText(By.id("backMsg"));
		//������رա���ť
		closeEcunBao();
		//�жϴ���TitleͶ�ʳɹ�
		if (message.equals("Ͷ�ʳɹ�")) {
			result = true;
		}else {
			System.out.println("��ҳ��汦��"+base.getElementTextWithWait(By.id("errorMsg")));
			Reporter.log("��ҳ��汦��"+base.getElementTextWithWait(By.id("errorMsg"))+"<br/>");
		}
		return result;
	}
	
	/**
	 * ����Ԫ
	 * �Զ����빦��
	 */
	public void auto(double balance){
		//base.sleep(2000);
		//��� �Զ�����
		base.clickWithWait(By.cssSelector(".font14.fr.pdr14"));
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
		//base.sleep(3000);
		if (balance < 100) {
			//����100�����ܹ���˲�Ʒ
			base.assertTrueByBoolean(base.isAlertPresent(15));
			Alert alert = base.getAlertwithWait();
			base.assertEqualsActualExpected(alert.getText(), "����100�����ܹ���˲�Ʒ");
			alert.accept();
		}else {
			//�������
			int needMoney = Integer.parseInt(base.getElementText(By.cssSelector("#showYuGouAmount")));
			//����ݶ�
			String num = base.getElementWithWait(By.id("wmpsYuGouAmount")).getAttribute("value");
			System.out.println("ϵͳ����ɹ���ݶ"+num);
			if (balance < needMoney) {
				System.out.println("�˻����ɹ�����汦�ݶ"+(int)balance/100);
				base.assertEqualsActualExpected(num, (int)balance/100+"");
			}else {
				System.out.println("ʣ��ɹ���ķݶ"+needMoney/100+"");
				base.assertEqualsActualExpected(num, needMoney/100+"");
			}
		}
		//������رա���ť
		closeTouZiEcunBao();
		//base.sleep(2000);
	}
	
	/**
	 * ����Ԫ
	 * ��� �رհ�ť  Ͷ����/����
	 * @param args
	 */
	public void closeEcunBao(){
		//������رա���ť
		base.clickWithWait(By.cssSelector("#fastLender_2 .close.fr"));
	}
	
	/**
	 * ����Ԫ
	 * ��� �رհ�ť  Ͷ�ʴ���
	 * @param args
	 */
	public void closeTouZiEcunBao(){
		//������رա���ť
		base.clickWithWait(By.cssSelector("#fastLender_1 .close.fr"));
	}
	
	/*************************************/
	/***************  �ۺ�       ***************/
	/*************************************/
	
	/**
	 * ������汦
	 * @param eCunBaoName	��汦���ƣ�����+����ʱ�䣬���磺auto0104161935��
	 * @param amount		������������磺10000��
	 * @param rate			�������ʣ����磺0.125��
	 * @param validity		������Ч�ڣ���λСʱ�����磺1��
	 * @param limit			��Լ���ޣ��������ޡ���λ�죬���磺7/30/90/365/720��
	 * @param createData 	�������ڣ����磺1451911350��
	 * @param publishedDate	��������
	 * @param accrualData	��Ϣ���ڣ��������� + ������Ч�ڣ�
	 * @param repaymentData �������ڣ���Ϣ���� + ��Լ���ޣ�
	 * @return �Ƿ����ɹ���true���ɹ���false��ʧ�ܣ�
	 * @author ������ 2016-1-4
	 */
	public void checkPublishECaoBao(String eCunBaoName, String amount, String rate, String validity, String limit, String createData, String publishedDate, String accrualData, String repaymentData){
		
		boolean isTrue = dbData.publishECaoBao(eCunBaoName, amount, rate, validity, limit, createData, publishedDate, accrualData, repaymentData);
		base.assertTrueByBoolean(isTrue);
		System.out.println("��汦�����ɹ������ƣ�" + eCunBaoName + " �� " + amount + " Ԫ  ��Լ���ޣ� " + limit + " ��");
		Reporter.log("��汦�����ɹ������ƣ�" + eCunBaoName + " �� " + amount + " Ԫ  ��Լ���ޣ� " + limit + " ��");
	}
	
	/**
	 * ������汦_���㡰��Ϣʱ�䡱
	 * @param publishedDate �������ڣ�ʱ�����ʽ��
	 * @param validity ������Ч�ڣ���λСʱ��ʱ�����ʽ��
	 * @return ��Ϣʱ��
	 * @author ������ 2016-1-4
	 */
	public String calculateAccrualData(String publishedDate, String validity){
		
		validity = (Long.parseLong(validity) * 3600) + "";
		return (Long.parseLong(publishedDate) + Long.parseLong(validity)) + "";
	}
	
	/**
	 * ������汦_���㡰�������ڡ�
	 * @param accrualData ��Ϣʱ�䣨ʱ�����ʽ��
	 * @param limit ��Լ���ޣ���λ�죬ʱ�����ʽ��
	 * @return ��������
	 * @author ������ 2016-1-4
	 */
	public String calculateRepaymentData(String accrualData, String limit){
		
		limit = (Long.parseLong(limit) * 86400) + "";
		return (Long.parseLong(accrualData) + Long.parseLong(limit)) + "";
	}
	
	/**
	 * ��汦������Ϣ
	 * @param money Ͷ����汦�Ľ��
	 * @param rate ����
	 * @param day ��������
	 * @return ��Ϣ
	 * @author ������ 2016-1-4
	 */
	public String calculateECunBaoIncome(String money, String rate, String day){
		
		double moneyDou = Double.parseDouble(money);
		double dayDou = Double.parseDouble(day);
		double rateDou = Double.parseDouble(rate);
		//1000*0.125/365*7
		double multiplyStr = base.multiply(moneyDou, rateDou);	//1000*0.125
		double divideStr = multiplyStr / 365.0;//base.divide(multiplyStr, 365.0);		//365
		divideStr = base.setRound(divideStr, 2, true);
		double calculation = base.multiply(divideStr, dayDou);	//*7
		return base.setRound(calculation, 2, true) + "";
	}
	
	/*************************************/
	/***************  ��ҳ       ***************/
	/*************************************/
	
	/**
	 * ����Ԫ
	 * Ͷһ��
	 * @param buyShareNum ����
	 * @param payPwd ֧������
	 * @param flag �Ƿ��Զ�����  0�����Զ�����  1���Զ�����
	 * @param balance �˻����
	 */
	public void touYiBi(String buyShareNum, String payPwd, int flag, double balance) {
		base.sleep(3000);
		List<WebElement> touYiBiList = base.getElements(touYiBiLink);
		//base.sleep(3000);
		if (touYiBiList.size() == 0) {
			System.out.println("��汦��ҳ��û�С�Ͷһ�ʡ�,���ѽ���");
			Reporter.log("��汦��ҳ��û�С�Ͷһ�ʡ�,���ѽ���"+"<br/>");
			return;
		} else {
			System.out.println("�ǵ�¼:" + !loginPage.ifLogin());
			if (!loginPage.ifLogin()) {// δ��¼
				// �����Ͷһ�ʡ�
				base.clickWithWait(touYiBiLink);
				base.sleep(2000);
				// У�鵯����ʾ��
				base.assertTrueByBoolean(base.isDisplayed(By.cssSelector(".login")));
				return;
			} else {// �ѵ�¼
				if (balance == 0) {// ���ֵ
					// �����Ͷһ�ʡ�
					//base.clickWithWait(touYiBiLink);
					touYiBiList.get(0).click();
					base.sleep(2000);
					// .lyct>.textC �� ����ȥ��ֵ,��Ͷ��! #bcardtip��ʾ
					base.assertTrueByBoolean(base.checkVisible(By.id("bcardtip")));
					return;
				} else {
					// Ͷһ��
					System.out.println("size:"+touYiBiList.size());
//					for (int i = 0; i < touYiBiList.size(); i++) {
					for (int i = 0; i < 1; i++) {
//						System.out.println(i);
						// �����Ͷһ�ʡ�
						touYiBiList.get(i).click();
						base.sleep(5000);
						if (base.isBlock(By.id("fastLender_1"))) {
							balance = Integer.parseInt(base.getElementTextWithWait(By.id("userBalance")).split("\\.")[0]);
							base.sleep(2000);
							if (flag == 1) {
								auto(balance);
								if (balance < 100) {// С��100 ��֤һ�μ���
									return;
								}
								//return;
							} else {
								// ��汦Ͷ��
								if (balance < 100) {
									touZi(buyShareNum, payPwd, balance);
									return;
								}else {
									touZi(buyShareNum, payPwd, balance);
									//base.sleep(2000);
									// У��
									if (isTouZiOK()) {
										base.assertTrueByBoolean(true);// Ͷ�ʳɹ�
										return;
									} else {
										System.out.println("ʧ�ܵ���汦��Ʒ��" + base.getElements(By.cssSelector(".color3")).get(i).getText());
										Reporter.log("ʧ�ܵ���汦��Ʒ��" + base.getElements(By.cssSelector(".color3")).get(i).getText()+"<br/>");
									}
								}
							}
						} else {
							String errorMsg = base.getElementTextWithWait(By.id("errorMsg"));
							String productName = base.getElements(By.cssSelector(".color3")).get(i).getText();
							System.out.println("ʧ�ܵ���汦��Ʒ��" + productName + "," + errorMsg);
							Reporter.log("ʧ�ܵ���汦��Ʒ��" + productName + "," + errorMsg+"<br/>");
						}
					}
				}
			}
//			System.out.println("��汦��ҳ Ͷһ�ʣ�û������,��Ʒ�ѽ���");
//			Reporter.log("��汦��ҳ Ͷһ�ʣ�û������,��Ʒ�ѽ���");
//			base.assertTrueByBoolean(false);// ������
		}
	}
	
	/**
	 * ����Ԫ
	 * ����Ͷ��
	 * @param buyShareNum ����
	 * @param payPwd ֧������
	 * @param flag �Ƿ��Զ�����  0�����Զ�����  1���Զ�����
	 * @param balance �˻����
	 */
	public void maShangTouZi(String buyShareNum,String payPwd,int flag,double balance){
		String text = base.getElementTextWithWait(By.cssSelector(".hFP_btn_idx>a"));//.disBtn
		if (text.equals("������")) {
			System.out.println("��ҳû�С�����Ͷ�ʣ���������");
			Reporter.log("��ҳû�С�����Ͷ�ʣ���������"+"<br/>");
			return;
		}else {
			if (!loginPage.ifLogin()) {
				//���������Ͷ�ʡ�
				indexPage.clickInvestmentBtn();
				//base.sleep(2000);
				//У�鵯����ʾ��
				base.assertTrueByBoolean(base.isDisplayed(By.cssSelector(".login")));
			}else {
				//�ѵ�¼
				if (balance == 0) {//���ֵ
					//���������Ͷ�ʡ�
					indexPage.clickInvestmentBtn();
					//base.sleep(2000);
					//.lyct>.textC   �� ����ȥ��ֵ,��Ͷ��!  #bcardtip��ʾ
					base.checkElementVisible(By.id("bcardtip"));
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(".lyct>.textC")), "�� ����ȥ��ֵ,��Ͷ��!");
				}else {
					//���������Ͷ�ʡ�
					indexPage.clickInvestmentBtn();
					if (balance<100) {
						touZi(buyShareNum,payPwd,balance);
					}else {
						if (base.isBlock(By.id("fastLender_1"))) {
							balance = Integer.parseInt(base.getElementTextWithWait(By.id("userBalance")).split("\\.")[0]);
							//base.sleep(2000);
							if (flag == 1) {
								auto(balance);
							}else {
								//��汦Ͷ��
								if (balance<100) {
									touZi(buyShareNum,payPwd,balance);
								}else{
									touZi(buyShareNum,payPwd,balance);
									//base.sleep(2000);
									//У��
									if (isTouZiOK()) {
										base.assertTrueByBoolean(true);//Ͷ�ʳɹ�
										return;
									}else {
										String errorMsg = base.getElementTextWithWait(By.id("errorMsg"));
										String productName = base.getElementTextWithWait(By.cssSelector(".color3"));
										System.out.println("ʧ�ܵ���汦��Ʒ��" + productName + "," + errorMsg);
										Reporter.log("ʧ�ܵ���汦��Ʒ��" + productName + "," + errorMsg+"<br/>");
									}
								}
							}
						}else {
							String errorMsg = base.getElementTextWithWait(By.id("errorMsg"));
							String productName = base.getElementTextWithWait(By.cssSelector(".color3"));
							System.out.println("ʧ�ܵ���汦��Ʒ��" + productName + "," + errorMsg);
							Reporter.log("ʧ�ܵ���汦��Ʒ��" + productName + "," + errorMsg+"<br/>");
						}
					}
				}
			}
		}
	}
	
	/**
	 * ��ҳ��汦������Ͷ��
	 * @param buyShareNum �������
	 * @param payPass ֧������
	 * @author ������ 2015-12-16
	 */
	public void immediatelyInvestment(String buyShareNum, String payPass){
		//��֤��
		String verificationCode = "";
		//�ж�����Ͷ�ʰ�ť�Ƿ����
		if(indexPage.isInvestmentBtn()){
			//���������Ͷ�ʡ���ť
			indexPage.clickInvestmentBtn();
			//����������򴰿�
			if(base.isBlock(By.cssSelector("#fastLender_1"))){
				if(indexPage.checkECunBaoBalance(buyShareNum)){
				//������ݶ����1
				indexPage.sendKeyBuyShareTxt(buyShareNum);
				//��֧�����롱����
				indexPage.sendKeyPayPwdTxt(payPass);
				//��ȡ��֤��
				verificationCode = new RandCodeUtils().getRandCode(base.getWebDriver(), indexPage.getVerificationCodeImg());
				System.out.println("��֤��Ϊ��" + verificationCode);
				//������֤��
				indexPage.sendKeyVerificationCode(verificationCode);
				//��ѡ����汦Ͷ��Э�顷
				indexPage.checkECunBaoProtocolAgree();
				//�����ȷ������ť
				indexPage.clickInvestmentOKBtn();   
				base.sleep(5000);
				//У�顰Ͷ�ʳɹ�����Ϣ��ʾ��
				indexPage.checkInvestmentSuccessWindow();
			}
			else{
				indexPage.clickInvestmentCloseBtn();
				Reporter.log("error_��ҳ������汦���˻����㣬���ֶ�����</br>");
				System.out.println("error_��ҳ������汦���˻����㣬���ֶ�����");
				base.assertTrueByBoolean(false);
				}
			}
			else{
				indexPage.checkInvestmentTitle();//���Ͷ�ʴ���
			}
		}
		else{
			System.out.println("error_��ҳ��汦_'����Ͷ��'��ť�޷����");
			Reporter.log("error_��ҳ��汦_'����Ͷ��'��ť�޷����");
			base.assertTrueByBoolean(false);
		}
	}
	
	/**
	 * ��ҳ��汦��У�顰����Ͷ�ʡ�������ʾ��Ϣ
	 * @param msg Ԥ�ڴ�����ʾ��Ϣ
	 * @author ������ 2015-12-28
	 */
	public void checkImmediatelyInvestmentErrorMsg(String msg){
		
		String msgStr = "";
		if(!indexPage.isInvestmentBtn()){
			System.out.println("error_��ҳ��汦_'����Ͷ��'��ť�����ڣ����ֹ�У�飡");
			Reporter.log("error_��ҳ��汦_'����Ͷ��'��ť�����ڣ����ֹ�У�飡");
			base.assertTrueByBoolean(false);
		}
		//���������Ͷ�ʡ���ť
		indexPage.clickInvestmentBtn();
		
		if(base.getElementNoWait(By.xpath("//div[@id='bcardtip']")).isDisplayed()){
			base.assertEqualsActualExpected(base.getElementText(By.xpath("//h2[@class='u-tt']")), "��ܰ��ʾ");
			msgStr = base.getElementTextWithWait(By.cssSelector("#errorMsg"));
			base.clickElementNoWait(By.xpath("//div[@class='lytt']/a"));
			base.assertEqualsActualExpected(msgStr, msg);
			//���1����汦Ͷ�ʴ��ڣ��˻�ûǮ��������ֵ��ʾ����
		}
		else if(base.isBlock(By.id("fastLender_2"))){
			base.assertEqualsActualExpected(base.getElementText(By.xpath("//span[text()='������']")), "������");
			msgStr = base.getElementTextWithWait(By.cssSelector("#errorMsg"));
			base.clickWithWait(By.xpath("//div[@id='fastLender_2']/div/a"));
			base.assertEqualsActualExpected(msgStr, msg);
			//���1������汦Ͷ�ʴ��ڣ���Ʒ�ѽ�����
			//���2������Ǹ���������Ľ����������ڣ��˻������ᣬ���Ȼ�����ִ�д˲���!��
		}
	}
	
	/*************************************/
	/*************   �б�ҳ_����    ************/
	/*************************************/
	
	/**
	 * ��汦�б�ҳ����ȡ��汦ID
	 * @return title ��汦����
	 * @return ��汦ID
	 * @author ������ 2015-8-3
	 */
	public String getProductIDByECunBaoTitle(String title){
		
		boolean isVisible = false;
		int count = 0;
		String id = "";
		//��Ͷ��
		By by = By.xpath("//span[text()='" + title + "']/parent::div/parent::div/following::div[@class='wrap'][1]/div/div//div[contains(@id, 'poscontainer')]");

		do{
			isVisible = base.checkVisible(by);
			TotalPage.openPage("��汦�б�ҳ", true);
			count++;
			base.sleep(2000);
		}while(!isVisible || count < 3);
		
		try {
			id = base.getAttributeWithVisible(by, "id");//��ʱ IDΪ"poscontainer+ID" 
		} catch (TimeoutException e) {
			System.out.println("error_��汦�б�ҳ��û�б���Ϊ" + title + "����汦");
			Reporter.log("error_��汦�б�ҳ��û�б���Ϊ" + title + "����汦");
			base.assertTrueByBoolean(false);
		}
		
		int temp = id.indexOf("r");
		id = id.substring(temp + 1, id.length());
		return id;
	}
	
	/**
	 * ��汦�б�ҳ����ȡ��һ����Ͷ��ť����汦ID
	 * @return ��汦ID
	 * @author ������ 2015-12-17
	 */
	public String getQiangTouBtnID(){
		
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);
		String id = "-1";
		if(tenderTotalBtnList.size() == 0){
			Reporter.log("error_��汦�б�ҳ��û����Ͷ��ť<br/>");
			System.out.println("error_��汦�б�ҳ��û����Ͷ��ť");
			return id;
		}
		for(int i = 0; i < 1; i++){
			//��ȡ����Ͷ����ť��onclick�¼��еĲ�Ʒid�����磺onclick="lender.openbuywindow(1,673,'13.50%')
			id = tenderTotalBtnList.get(i).getAttribute("onclick").split(",")[1];
		}
		return id;
	}
	
	/**
	 * ��汦�б�ҳ��У����汦�Ƿ���ɹ�
	 * @param newBalance ����ǰ��汦���(��С������)
	 * @param oldBalance �������汦���(��С������)
	 * @param purchaseAmount ������
	 */
	public void checkBuySuccess(String newBalance, String oldBalance, String purchaseAmount){
		String sub = base.subtract(Double.valueOf(newBalance),Double.valueOf(oldBalance)) + "";
		if(sub.indexOf(".")!= -1){
			sub = sub.substring(0, sub.indexOf("."));
		}
		base.assertEqualsActualExpected(sub, purchaseAmount);
	}
	
	/**
	 * �����汦ҳ��ָ�������ı���
	 * @param count(�������)
	 * @return �����ַ�����̬����
	 * @author ������ 2015-5-7
	 */
	public List<String> getECunBaoDataTitles(int count){
		//��ȡ����span����
		List<WebElement> eCunBaoDataTitleList = base.getElements(eCunBaoDataTitles);
		List<String> eCunBaoDataTitleStringList = new ArrayList<String>();
		if(eCunBaoDataTitleList.size()>10){
			Reporter.log("��汦�б�ҳ:��汦���ݳ���10��");
			System.out.println("��汦�б�ҳ:��汦���ݳ���10��");
		}
		else if(count>10){
			Reporter.log("��汦�б�ҳ: ��ʾ���ݲ��ó���10����");
			System.out.println("��汦�б�ҳ: ��ʾ���ݲ��ó���10����");
		}
		else{
			//��spanԪ���е�Text��ӵ��ַ�����̬������
			for(int i = 0; i < count; i++){
				eCunBaoDataTitleStringList.add(eCunBaoDataTitleList.get(i).getText());
			}
		}
		return eCunBaoDataTitleStringList;
	}
	
	/**
	 * ��汦�б�ҳ��У����汦��ʾ����
	 * @author ������ 2016-2-26
	 */
	public void checkYCBNum(){
		List<WebElement> list = Arrays.asList();
		list = base.getVisibleElements(eCunBaoDataTitles);
		base.assertEqualsActualExpectedByInt(list.size(), 10);
	}
	
	
	/********************************************/
	/***********     �б�ҳ_����_banner   **********/
	/********************************************/
	
	/**
	 * ��汦�б�ҳ�� �����������¼����ť
	 * @author ������ 2015-5-15
	 */
	public void clickLoginBtn(){
		base.clickWithWait(loginBtn);
	}
	
	/**
	 * ��汦�б�ҳ��У�顰������¼����ť���Ƿ����
	 * @author ������ 2015-7-9
	 */
	public boolean isClickLoginBtnPresent(){
		if(base.isElementVisible(loginBtn)){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * ��汦�б�ҳ��������ҵ���汦����ť
	 * @author ������ 2015-5-15
	 */
	public void clickMyECunBaoBtn(){
		base.clickWithWait(myECunBaoBtn);
	}
	
	/**
	 * ��汦�б�ҳ�������������¼���رհ�ť
	 * @author ������ 2015-5-15
	 */
	public void clickLoginCloseBtn(){
		base.clickWithWait(loginCloseBtn);
	}
	
	/**
	 * ��ҳ/�б�ҳ��У�顰������¼������Title
	 * @author ������ 2015-5-15
	 * @author �޸� ������ 2015-9-9
	 */
	public void checkBannerLoginWindowTitle() {
		
		boolean isShow = false;
		//�жϵǳ������Ƿ���ʾ
		base.assertTrueByBoolean(base.isBlock(By.cssSelector(".login")));
		isShow = base.isElementPresent(By.cssSelector("#loginBoxFrame"));
		if(isShow){
			//��ȡ����¼������
			base.switchToFrame("loginBoxFrame"); 
		}
		//�жϵ�¼����Title�Ƿ���ȷ
		base.assertEqualsActualExpected(base.getElementTextWithVisible(By.cssSelector(".fl.font20")), "��¼");
		//�жϡ�������¼���رհ�ť�Ƿ����
		base.assertEqualsActualExpectedByBoolean(base.isElementVisible(loginCloseBtn), true);
		//�����������¼���رհ�ť
		clickLoginCloseBtn();
		base.fromFrameToDefaultContent();
	}
	
	/**
	 * ��汦�б�ҳ�� У��banner����ʾ�û�����汦����
	 * @author ������ 2015-5-12
	 */
	public void checkBannerTotalData(){
		String txtString[] = {"С��Ϊ��������汦���ݣ�","�������棺","�ۼ����棺","���ձ�����","�ҵ���汦"};
		base.checkElementVisible(bannerTotalData);
		List<WebElement> bannerTotalElements = base.getElements(bannerTotalData);
		for(int i = 0; i < bannerTotalElements.size(); i++){
			switch(i){
				//Ԥ�ڽ����С��Ϊ��������汦���ݣ�
				case 0:
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElement(By.cssSelector("span")).getText(), txtString[i]);
					break;
				//Ԥ�ڽ�����������棺 ����.00(�漰��d_wmps_day_inter��������)
				case 1:
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(0).getText(), txtString[i]);
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(1).getText(), "��");
					//��Ҫ��ѯ���ݿ⣬�����������У�����(����ѯ������)
//					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(2).getText(), "0.00");
					break;
				//Ԥ�ڽ�����ۼ����棺����.00(�漰��d_pro_comm_funds_info �ۼ�����)
				case 2:
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(0).getText(), txtString[i]);
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(1).getText(), "��");
//					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(2).getText(), "0.00");
					break;
				//Ԥ�ڽ���� ���ձ�����0����(�漰��d_wmps_buy_record  �������)
				case 3:
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(0).getText(), txtString[i]);
//					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(1).getText(), "0");
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(2).getText(), "��");
					break;
				//Ԥ�ڽ�����ҵ���汦
				default:
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElement(By.tagName("a")).getText(), txtString[i]);
			}
		}
	}
	
	/**
	 * ��汦�б�ҳ��У��Banner�С��������桱�����ۼ����桱�������ձ�����
	 * @param hashMap ��������汦�Ĳ�Ʒ��Ϣ(������껯�����ʣ���Լ���ޣ���Ϣʱ�䣬����ʱ��)
	 * @author ������ 2015-10-27
	 */
	public void checkBannerToData(HashMap<String, String> hashMap){
		
		String amount = hashMap.get("amount");             //������
		String interestrate = hashMap.get("interestrate"); //�껯������
		String interdate = hashMap.get("interdate");       //��Ϣʱ��
		
		String interest = transactionRecordPage.calculationInterest(amount, interestrate);//���������桱
		String cumulative = transactionRecordPage.calcCumulativeGain(interest, interdate);//���ۼ����桱
		String count = "2";                                                               //�����ձ�����(Ĭ��Ϊ1��)
		
		base.checkElement(bannerTotalData);
		List<WebElement> bannerTotalElements = base.getElements(bannerTotalData);
		for(int i = 0; i < bannerTotalElements.size(); i++){
			switch(i){
				case 1:base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(2).getText(), interest);break;
				case 2:
				try {
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(2).getText(), cumulative);
				} catch (AssertionError e) {
					Reporter.log("error_�ҵ��˻�_��汦_�ۼ��������<br/>");
					System.out.println("error_�ҵ��˻�_��汦_�ۼ��������");
				}break;
				case 3:base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(1).getText(), count);break;
				default:break;
			}
		}
	}

	/**
	 * ��汦�б�ҳ����ȡbanner�С��������桱�����ۼ����桱�������ձ�����������
	 * @param name ��������
	 * @return ��Ӧ����
	 * @author ������ 2015-12-29
	 */
	public String getBannerData(String name){
		
		String data = "";
		By by = null;
		if(name.equals("��������")){
			by = By.cssSelector(".gdcon.colorFF > p:nth-child(2) >span:nth-child(3)");
		}
		else if(name.equals("�ۼ�����")){
			by = By.cssSelector(".gdcon.colorFF > p:nth-child(3) >span:nth-child(3)");
		}
		else if(name.equals("���ձ���")){
			by = By.cssSelector(".gdcon.colorFF > p:nth-child(4) >span:nth-child(2)");
		}
		data = base.getElementTextWithVisible(by);
		data = base.stringToReplace(data, ",", "");
		data = data.trim();
		return data;
	}
	
	/***************************************************************************/
	/******* �б�ҳ_����_Ͷ��Э��_���⡢�껯���桢�������ޡ���ļ�����ܽ�� ����Ϣʱ�䡢����ʱ��   ********/
	/***************************************************************************/
	
	/**
	 * ��汦�б�ҳ����ȡ��һ�����ݵ���Ϣ�����⡢�껯���桢�������ޡ���ļ�����ܽ�
	 * @param id ��汦ID
	 * @return �б�ҳ��Ϣ
	 * @author ������ 2015-12-14
	 */
	public List<String> getECunBaoDataOne(String id){
		List<WebElement> listWeb = new ArrayList<WebElement>();
		List<String> listStr = new ArrayList<String>();
		//����
		By titleBy = By.xpath("//div[@id='poscontainer" + id + "']/parent::div/parent::div/parent::div/preceding-sibling::div[1]//span[@class='m_zi2 ml10']");
		//�껯���桢�������ޡ���ļ�����ܽ��
		By dataBy =  By.xpath("//div[@id='poscontainer" + id + "']/parent::div/parent::div/parent::div//div[contains(@class, 'con_con')]/div/p[2]");
		base.checkElementVisible(titleBy);
		base.checkElementVisible(dataBy);
		listStr.add(base.getElementText(titleBy));//��ӱ���
		listWeb = base.getVisibleElements(dataBy);
		for(int i = 0; i < listWeb.size(); i++){
			listStr.add(listWeb.get(i).getText());//��� �껯���桢�������ޡ���ļ�����ܽ��
		}
		return listStr;
	}
	
	/**
	 * ��汦�б�ҳ����ȡ��汦ĳ����ʾ��ȫ����Ϣ�����������껯���棬�������ޣ���ļ������Ϣ��������
	 * @param name ��ʾ����
	 * @return ��ʾ����
	 * @author ������ 2015-12-31
	 */
	public By getECunBaoInfoAllDataBy(String name){
		
		By by = null;
		switch (name) {
		case "�껯����":	 	by = By.xpath("//p[contains(@id, 'realInterestrate_')]"); 	break;
		case "VIP": 		by = By.cssSelector("i.font16:nth-child(2)");				break;
		case "��������": 		by = By.cssSelector("div.fl.mlp > .size_color_h.mt12");		break;
		case "��ļ�����/��": 	by = By.cssSelector("div.fl.mlq > .size_color_h.mt12"); 	break;
		case "��Ϣ": 			by = By.cssSelector("div.ycbitem-textL > p.font_w");		break;
		case "����": 			by = By.cssSelector("div.ycbitem-textR > p.font_w");		break;
		default: 			by = By.xpath("//p[contains(@id, 'realInterestrate_')]"); 	break;
		}
		return by;
	}
	
	/**
	 * ��汦�б�ҳ����ȡ��汦ĳ����ʾ��ȫ����Ϣ�����������껯���棬�������ޣ���ļ������Ϣ��������
	 * @param name ��ʾ����
	 * @return ��ʾ���ݵļ���
	 * @author ������ 2015-12-31
	 */
	public List<String> getECunBaoInfoAllDataStr(String name){
		
		By by = getECunBaoInfoAllDataBy(name);
		List<String> listStr = new ArrayList<String>();
		List<WebElement> listWeb = base.getVisibleElements(by);
		int size = listWeb.size();
		for(int i = 0; i < size; i++){
			listStr.add(listWeb.get(i).getText());
		}
		return listStr;
	}
	
	/**
	 * ��汦�б�ҳ��У������VIP��ĸ������
	 * @param expectStr VIP����(����:"+0.1%")
	 * @author ������ 2015-12-31
	 */
	public void checkECunBaoInfoByVIP(String expectStr){
		
		expectStr = expectStr.replace("+", "");
		expectStr = "VIP" + expectStr;
		List<String> list = getECunBaoInfoAllDataStr("VIP");
		for (String string : list) {
			string = string.replace("\n", "");
			base.assertEqualsActualExpected(string, expectStr);
		}
	}
	
	/*******************************************/
	/********    �б�ҳ_����_����Զ�ƥ�䷵��        *********/
	/*******************************************/
	
	/**
	 * ��汦�б�ҳ��У�����С�����Զ�ƥ�䷵�֡�����
	 * @author ������ 2015-5-12
	 */
	public void checkReturnCashTotalLink(){
		
		base.checkElementsVisible(returnCashTotalLink);
		List<WebElement> returnCashTotalLinkList = base.getElements(returnCashTotalLink);
//		for(int i = 0; i < returnCashTotalLinkList.size(); i++){
		for(int i = 0; i < 1; i++){
			//���������Զ�ƥ�䷵�֡�
			returnCashTotalLinkList.get(i).click();
			//У�鵯������Title
			base.assertEqualsActualExpected(base.getElementTextWithVisible(By.xpath("//h3[text()='��汦������ֹ���']")), "��汦������ֹ���");
			//����رհ�ť
			base.clickWithWait(returnCashCloseBtn);
		}
	}
	
	/*******************************************/
	/*********      �б�ҳ_����_ծȨ����                  ********/
	/*******************************************/
	
	/**
	 * ��汦�б�ҳ����ȡ��ծȨ���顱��ť����
	 * @return ծȨ���鰴ť���󼯺�
	 * @author ������ 2016-2-4
	 */
	public List<WebElement> getBondDetailsBtn(){
		return base.getVisibleElements(bondDetails);
	}
	
	/**
	 * ��汦�б�ҳ����ȡ��ծȨ���顱����е�����
	 * @return ���ݶ���ļ���
	 * @author ������ 2016-2-4
	 */
	public List<BondDetailsModel> getBondDetailsInfo(){
		
		List<WebElement> webList = getBondDetailsBtn();
		List<WebElement> infoWebList;
		List<BondDetailsModel> infoModelList = new ArrayList<BondDetailsModel>();
		BondDetailsModel bondDetailsModel = new BondDetailsModel();
		int infoWebListSize = 0;
		int rowNum = 6;
		String temp;
		for(int i = 0; i < 1; i++){
			webList.get(i).click();//�����ծȨ���顱��ť
			base.checkElementVisible(bondDetailsDIV);
			base.assertEqualsActualExpected(base.getElementTextWithVisible(bondDetailsDIVTitle), "ծȨ����");
			base.assertTrueByBoolean(base.isElementVisible(By.cssSelector("#aq")));//У�鷭ҳ��ť�Ƿ����
			infoWebList = base.getVisibleElements(bondDetailsDIVInfo);//��ȡ��ծȨ���顱��ǰҳ����������
			infoWebListSize = infoWebList.size();
			System.out.println("��ծȨ���顱��ǰҳһ�� " + infoWebListSize + " ������");
			Reporter.log("��ծȨ���顱��ǰҳһ�� " + infoWebListSize + " ������");
			for(int j = 0; j < infoWebListSize; j++){
				
				temp = infoWebList.get(j).getText();
				if(j % rowNum == 0){
					bondDetailsModel.setBorrowPurpose(temp);
				}
				else if((j - 1) % rowNum == 0){
					bondDetailsModel.setBorrowName(temp);
				}
				else if((j - 2) % rowNum == 0){
					bondDetailsModel.setIdCard(temp);
				}
				else if((j - 3) % rowNum == 0){
					bondDetailsModel.setAddress(temp);
				}
				else if((j - 4) % rowNum == 0){
					bondDetailsModel.setBorrowMoney(temp);
				}
				else if((j - 5) % rowNum == 0){//��6��Ϊ���鿴���顱��ť�������
					infoModelList.add(new BondDetailsModel(bondDetailsModel.getBorrowName(),
							bondDetailsModel.getIdCard(),bondDetailsModel.getAddress(),
							bondDetailsModel.getBorrowMoney(),bondDetailsModel.getBorrowPurpose()));
				}
			}
		}
		clickBondDetailsDIVClose();
		return infoModelList;
	}
	
	/**
	 * ��汦�б�ҳ�������ծȨ���顱��ť����>������鿴���顱��ť��У��鿴����1.ֻ��ʾ��������Ľ��ꣻ2.��������ʾ�����飨������Ϣ�����������ϣ�������/�������ʷͳ�ƣ���ͳ����Ϣ�������Ϣƥ��
	 * @author ������ 2016-2-3
	 * �޸� ������ 2016-2-5
	 */
	public void checkBondDetails(){
		
		List<WebElement> list = getBondDetailsBtn();
		List<WebElement> bondDetailsDIVBtnList;
		for(int i = 0; i < 1; i++){
			list.get(i).click();//�����ծȨ���顱��ť
			base.checkElementVisible(bondDetailsDIV);
			base.assertEqualsActualExpected(base.getElementTextWithVisible(bondDetailsDIVTitle), "ծȨ����");
			base.assertTrueByBoolean(base.isElementVisible(By.cssSelector("#aq")));//У�鷭ҳ��ť�Ƿ����
			checkBondDetailsDIVColumnValue("������");
			checkBondDetailsDIVColumnValue("���������");
			checkBondDetailsDIVColumnValue("���֤��");
			checkBondDetailsDIVColumnValue("����");
			bondDetailsDIVBtnList = base.getVisibleElements(bondDetailsDIVBtn);
			for(int j = 0; j < 1; j++){
				bondDetailsDIVBtnList.get(j).click();//������鿴���顱��ť
				base.assertEqualsActualExpected(base.getElementTextWithVisible(By.cssSelector(".xq_content_tab_block.border>h3")), "�������");
				clickBondDetailsSeeTab("��������");
				clickBondDetailsSeeTab("��������");
				clickBondDetailsSeeTab("��ʷͳ��");
				bondDetailsDIVBtnList.get(i).click();//������鿴���顱��ť
				base.isElementContainsValue(bondDetailsSeeDIV, "style", "none");
				clickBondDetailsDIVClose();
				base.isElementContainsValue(By.cssSelector("#out_all3"), "style", "none");
			}
		}
	}
	
	/**
	 * ��汦�б�ҳ����>�����ծȨ���顱��ť��У�鴰��������ʾ�Ƿ�����
	 * @author ������ 2016-2-4
	 */
	public void checkECBBondDetailsDIVColumnName(){
		String[] columnName = {"������","���������","���֤��","����˵���","����ܶ�","����"};
		List<WebElement> webList = base.getVisibleElements(bondDetailsDIVColumnName);
		int size = webList.size();
		base.assertEqualsActualExpectedByInt(size, columnName.length);
		for(int i = 0; i < size; i++){
			base.assertEqualsActualExpected(webList.get(i).getText(), columnName[i]);
		}
	}
	
	/**
	 * ��汦�б�ҳ����>�����ծȨ���顱��ť����ȡ����ĳ�е�ֵ
	 * @param columnName ����
	 * @return ĳ��ֵ�ļ���
	 * @author ������ 2016-2-5
	 */
	public List<String> getBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String index = "1";
		switch (columnName) {
		case "������":	index = "1";	break;		
		case "���������":	index = "2";	break;	
		case "���֤��":	index = "3";	break;	
		case "����˵���":	index = "4";	break;
		case "����ܶ�":	index = "5";	break;	
		case "����":		index = "6";	break;	
		default:		index = "1";	break;	
		}
		List<WebElement> webList = base.getVisibleElements(By.cssSelector("#tenderBody .font14.color6>td:nth-child(" + index + ")"));
		for(int i = 0; i < webList.size(); i++){
			strList.add(webList.get(i).getText());
		}
		return strList;
	}
	
	/**
	 * ��汦�б�ҳ����>�����ծȨ���顱��ť��У�鴰��ĳ�е�ֵ��ʾ�Ƿ�����
	 * @param columnName ����
	 * @author ������ 2016-2-5
	 */
	public void checkBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String temp;
		strList = getBondDetailsDIVColumnValue(columnName);
		if(columnName.equals("������")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				if(temp.length() > 5){
					temp = temp.substring(5);
					base.assertTrueByBoolean(temp.equals("..."));
				}
			}
		}
		else if(columnName.equals("���������")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(1);
				base.assertTrueByBoolean(temp.contains("*"));
			}
		}
		else if(columnName.equals("���֤��")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(10);
				base.assertTrueByBoolean(temp.equals("********"));
			}
		}
		else if(columnName.equals("����")){
			for(int i = 0; i < strList.size(); i++){
				base.assertEqualsActualExpected(strList.get(i), "�鿴����");
			}
		}
	}
	
	/**
	 * ��汦�б�ҳ����>ծȨ���顪��>�鿴���顪��>��ȡTab����
	 * @param tabName Tab����
	 * @return Tab����
	 * @author ������ 2016-2-3
	 */
	public By getBondDetailsSeeTab(String tabName){
		String index;
		By by;
		switch (tabName) {
		case "������Ϣ":	index = "1";	break;
		case "��������":	index = "2";	break;
		case "��������":	index = "3";	break;
		case "��ʷͳ��":	index = "4";	break;
		default:		index = "1";	break;
		}
		by = By.cssSelector(".xq_content_t > li:nth-child(" + index + ")");
		return by;
	}
	
	/**
	 * ��汦�б�ҳ����>ծȨ���顪��>�鿴���顪��>���Tab
	 * @param tabName Tab����
	 * @author ������ 2016-2-3
	 */
	public void clickBondDetailsSeeTab(String tabName){
		By by = getBondDetailsSeeTab(tabName);
		base.clickWithWait(by);
		base.assertTrueByBoolean(base.isElementContainsValue2(by, "class", "cur"));
	}
	
	/**
	 * ��汦�б�ҳ����>ծȨ���顪��>�鿴���顪��>���X��ť
	 * @author ������ 2016-2-3
	 */
	public void clickBondDetailsDIVClose(){
		base.clickWithWait(bondDetailsDIVClose);
		base.checkInvisibility(bondDetailsDIV);
	}
	
	/*******************************************/
	/*********      �б�ҳ_����_����Э��                  ********/
	/*******************************************/
	
	/**
	 * ��汦�б�ҳ����>��ȡ���С����������߾Ӽ����Э�顷����
	 * @return �����������߾Ӽ����Э�顷���󼯺�
	 * @author ������ 2016-2-4
	 */
	public List<WebElement> getServiceAgreement(){
		return base.getVisibleElements(serviceAgreement);
	}
	
	/**
	 * ��汦�б�ҳ����>���������߾Ӽ����Э�顪��>У��Э�飬�����ظ���һ
	 * @return ծȨ�����ʵ���༯��
	 * @author ������ 2016-2-4
	 */
	public List<BondDetailsModel> checkServiceAgreementAndReturnAccessoriesOne(){
		
		List<BondDetailsModel> modelList = new ArrayList<BondDetailsModel>();
		List<WebElement> linkList = getServiceAgreement();
		for(int i = 0; i < 1; i++){
			linkList.get(i).click();
			base.jumpToNewWindow();
			base.isTitle("���������߾Ӽ����Э��");
			base.assertEqualsActualExpected(base.getElementTextWithVisible(serviceAgreementTitle), "���������߾Ӽ����Э��");
			if(base.isElementVisible(serviceAgreementAccessories)){
				modelList = getServiceAgreementAccessoriesOne();
			}
			else{
				System.out.println("���������߾Ӽ����Э��_����һ_û������");
				Reporter.log("���������߾Ӽ����Э��_����һ_û������");
			}
		}
		return modelList;
	}
	
	/**
	 * ��汦�б�ҳ����>���������߾Ӽ����Э�顪��>��ȡ����һ����������
	 * @return ծȨ�����ʵ���༯��
	 * @author ������ 2016-2-4
	 */
	public List<BondDetailsModel> getServiceAgreementAccessoriesOne(){
		
		BondDetailsModel bondDetailsModel = new BondDetailsModel();//ծȨ����ʵ����
		List<BondDetailsModel> modelList = new ArrayList<BondDetailsModel>();
		List<WebElement> trWebList;
		List<WebElement> tdWebList;
		String temp;
		
		trWebList = base.getVisibleElements(By.cssSelector("#tenderBody .font14.color6"));//tr����
		for(int i = 0; i < trWebList.size(); i++){
			tdWebList = trWebList.get(i).findElements(By.tagName("td"));
			for(int j = 0; j < tdWebList.size(); j++){
				temp = tdWebList.get(j).getText();
				if(j == 0){
					bondDetailsModel.setBorrowName(temp);
				}
				else if(j == 1){
					bondDetailsModel.setIdCard(temp);
				}
				else if(j == 2){
					bondDetailsModel.setAddress(temp);
				}
				else if(j == 3){
					bondDetailsModel.setBorrowMoney(temp);
				}
				else if(j == 4){
					bondDetailsModel.setBorrowPurpose(temp);
				}
			}
			modelList.add(new BondDetailsModel(bondDetailsModel.getBorrowName(),
					bondDetailsModel.getIdCard(),bondDetailsModel.getAddress(),
					bondDetailsModel.getBorrowMoney(),bondDetailsModel.getBorrowPurpose()));
		}
		return modelList;
	}
	
	/*******************************************/
	/******     �б�ҳ_����_ծȨ���� _����Э��                ******/
	/*******************************************/
	
	/**
	 * ��汦�б�ҳ����>У�顰ծȨ���顱ǰ10�������롰����Э�鸽��һ��ǰ10�����ݵ�һ����
	 * @param blist ��汦�б�ծȨ����ʵ���༯�ϣ�С�ڵ���10����
	 * @param slist ����Э����ծȨ����ʵ���༯�ϣ��������ݣ�
	 * @author ������ 2016-2-4
	 */
	public void checkBondDetailsAndServiceAgreement(List<BondDetailsModel> blist, List<BondDetailsModel> slist){
		BondDetailsModel bBondDetailsModel = new BondDetailsModel();
		BondDetailsModel sBondDetailsModel = new BondDetailsModel();
		for(int i = 0; i < blist.size(); i++){
			bBondDetailsModel = blist.get(i);
			sBondDetailsModel = slist.get(i);
			base.assertEqualsActualExpected(bBondDetailsModel.getBorrowPurpose(), sBondDetailsModel.getBorrowPurpose());
			base.assertEqualsActualExpected(bBondDetailsModel.getBorrowName(), sBondDetailsModel.getBorrowName());
			base.assertEqualsActualExpected(bBondDetailsModel.getIdCard(), sBondDetailsModel.getIdCard());
			base.assertEqualsActualExpected(bBondDetailsModel.getAddress(), sBondDetailsModel.getAddress());
			base.assertEqualsActualExpected(bBondDetailsModel.getBorrowMoney(), sBondDetailsModel.getBorrowMoney());
		}
	}
	
	/*******************************************/
	/*********      �б�ҳ_����_�����¼                  ********/
	/*******************************************/
	
	/**
	 * ��汦�б�ҳ����ȡ�����¼Ԫ��
	 * @param productId:��汦��ƷID
	 * @param buyRecordNum����Ʒ��¼������1Ϊ������һ����2λ�����ڶ���...�Դ����ƣ�allΪ���м�¼
	 * @return �����¼Ԫ��
	 * @author ������
	 */
	public By getBuyRecordBy(String productId, String buyRecordNum){
		By buyRecordBy;
		if(buyRecordNum.equals("all")){
			buyRecordBy = By.xpath("//tbody[@id='ftbody"+ productId +"']/tr/td");
		}
		else{
			buyRecordBy = By.xpath("//tbody[@id='ftbody"+ productId +"']/tr["+ buyRecordNum +"]/td");
		}
		return buyRecordBy;
	}
	
	/**
	 * ��汦�б�ҳ�������ֱ�Ϊ�Ǻţ�ֻ��������
	 * @param name������
	 * @return ֻ�����ϣ���Ϊ*
	 * @author ������
	 */
	public String userNameChange(String name){
		int length = name.length();
		name = name.substring(0, 1);
		for(int i = 0; i < length-1; i++){
			name = name + "*";
		}
		return name;
	}
	
	/**
	 * ��汦�б�ҳ������������¼����ť
	 * @param productId ��汦��ƷID
	 * @author ������
	 */
	public void clickRecordBtn(String productId){
		
		By recordBtnBy = By.xpath("//div[div[@id='poscontainer" + productId + "']]/following::div[1]/span[4]");
		try {
			base.assertEqualsActualExpectedByBoolean(base.isElementVisible(recordBtnBy), true);
		} catch (Exception e) {
			Reporter.log("��汦�б�ҳ��û�ҵ���ƷIDΪ" + productId + "�ġ���Ͷ�ʼ�¼����ť<br/>");
			System.out.println("��汦�б�ҳ��û�ҵ���ƷIDΪ" + productId + "�ġ���Ͷ�ʼ�¼����ť");
		}
		base.clickElementNoWait(recordBtnBy);
		base.checkElementVisible(By.cssSelector(".overflowV.wrap.list.list2263"));//У��"�����¼"�б��Ƿ���ʾ
	}
	
	/**
	 * ��汦�б�ҳ����ȡһ��/���������¼
	 * @param BuyRecordBy:�����¼Ԫ�أ��ɴ�һ����Ҳ�ɴ����
	 * @return �����¼
	 * @author ������
	 */
	public List<WebElement> getBuyRecords(By BuyRecordBy){
		List<WebElement> list = new ArrayList<WebElement>();
		list = base.getVisibleElements(BuyRecordBy);
		return list;
	}
	
	/**
	 * ��汦�б�ҳ�������汦�����¼
	 * @param productId ��汦��ƷID
	 * @param buyRecordNum ����鹺���¼����
	 * @param userName Ͷ��������
	 * @param money Ͷ�ʽ��
	 * @param joinTime ����ʱ�䣨����ʱ�䣩
	 * @author ������
	 */
	public void checkRecord(String productId, String buyRecordNum, String userName, String money, String joinTime){
		clickRecordBtn(productId);
		List<WebElement> list = getBuyRecords(getBuyRecordBy(productId, buyRecordNum));
		if(list != null && !list.isEmpty()){
			String tempTime = list.get(3).getText();
			tempTime = tempTime.substring(0, tempTime.length()-3);
	//		base.assertEqualsActualExpected(list.get(0).getText(), userNameChange(userName));//��֤Ͷ����
			base.assertEqualsActualExpected(list.get(1).getText(), money + "Ԫ");//��֤Ͷ�ʽ��
			base.assertEqualsActualExpected(list.get(2).getText(), "�ֶ�����");//��֤Ͷ�ʷ�ʽ
	//		base.assertEqualsActualExpected(tempTime, joinTime);//��֤����ʱ��
		}
		else{
			Reporter.log("error_��汦�б�ҳ_�����¼û������<br/>");
			System.out.println("error_��汦�б�ҳ_�����¼û������");
		}
	}
	
	
	/**
	 * ��汦�б�ҳ��У�����С������¼����ť
	 * @author ������ 2015-5-12
	 */
	public void checkRecordTotalBtn(){
		
		base.checkElementVisible(recordTotalBtn);
		List<WebElement> recordTotalBtnList = base.getElements(recordTotalBtn);
//		for(int i = 0; i < recordTotalBtnList.size(); i++){
		for(int i = 0; i < 1; i++){
			//�������Ͷ�ʼ�¼����ť
			recordTotalBtnList.get(i).click();
			//��鰴ť�Ƿ�仯
			base.assertEqualsActualExpected(recordTotalBtnList.get(i).getAttribute("class"), "twojiantou shang jiantou ml10 xia");
			//У����ز��Ƿ���ʾ
			base.assertTrueByBoolean(getInputRecordDiv().getAttribute("style").contains("block"));
			//�ٵ������Ͷ�ʼ�¼����ť
			recordTotalBtnList.get(i).click();
			//��鰴ť�Ƿ�仯
			base.assertEqualsActualExpected(recordTotalBtnList.get(i).getAttribute("class"), "twojiantou shang jiantou ml10");
		}
	}
	
	
	/***************************************************************/
	/***************�б�ҳ_����_��Ʒ��Ϣ����������Ч�ڡ�������Ͷ����ť��**************/
	/***************************************************************/
	
	/**
	 * ��汦�б�ҳ����ȡ��������Ч�ڡ�����ʱ���֡���
	 * @param id ��汦ID
	 * @return ��������Ч�ڡ�Ԫ��
	 * @author ������ 2015-5-15
	 */
	public By getBuyValid(String id){
		return By.xpath("//span[@id='" + id + "']/span[@class='timebj bjdingwei1']");
	}
	
	/**
	 * ��汦�б�ҳ��У�顰������Ч�ڡ��Ƿ���Ч������ʱ���붼��Ϊ0
	 * @param id ��汦ID
	 * @return true����ʾ��������Ч�ڡ���Ч����ʱ�䲻ȫΪ0
	 *         false:��ʾ��������Ч�ڡ���Ч����ʱ��ȫΪ0
	 * @author ������ 2015-5-18
	 */
	public boolean checkBuyValid(String id){
		//��Ч״̬��Ĭ����Ч(false)
		boolean valid = false;
		//��ȡ���еġ�������Ч�ڡ�Ԫ��
		List<WebElement>  buyValidList = base.getElements(getBuyValid(id));

		for(int i = 0; i < buyValidList.size(); i++){
			base.sleep(5000);
			//��ȡ��������Ч�ڡ�
			String text = buyValidList.get(i).getText();    System.out.println("i: " + i + " ʱ�䣺" + text);//---------����
			//�����һλ����0����ʱ����Ч������ѭ��
			if(!(text.equals("0"))){
				//��Ч״̬����Ч(true)
				valid = true;
				break;
			}
		}
		return valid;
	}	
	
	/**
	 * ��汦�б�ҳ�������Ͷ��ťԪ��
	 * @param ��汦ID
	 * @author ������ 2015-8-3
	 */
	public By getQiangTouBtn(String eCunBaoID){
		By by = By.xpath("//a[contains(@onclick, '" + eCunBaoID + ",') ]");
		base.checkElementVisible(by);
		return by;
	}
	
	/**
	 * ��汦�б�ҳ�������Ͷ��ť
	 * @param eCunBaoID ��汦ID
	 * @author ������ 2015-12-17
	 */
	public void clickQiangTouBtn(String eCunBaoID){
		
		WebElement tenderDiv = null;
//		//У�顰������Ч�ڡ��Ƿ���Ч��ȫ��Ϊ0Ϊ����Ч
//		isBuyValid = checkBuyValid(id);	
//		//���ݰ�ťid����ȡ��ʱ���֣��롱��ֵ
//		if(isBuyValid){
//			return id = "0";
//		}
		//�������Ͷ����ť
		base.clickElementNoWait(getQiangTouBtn(eCunBaoID));
		//��ȡ����Ͷ����ť�򿪵�DIV
		tenderDiv = getTenderOpenDiv();
		if(tenderDiv!=null){
			//�رյ�������
			clickTenderCloseDivBtn(tenderDiv);
			Reporter.log("error_��汦�б�ҳ���޷�Ͷ�ʣ�<br/>");
			System.out.println("error_��汦�б�ҳ���޷�Ͷ�ʣ�");
		}
	}
	
	/**
	 * ��汦�б�ҳ��У�顰��Ͷ����ť���ѵ�¼
	 * @author ������ 2015-5-14
	 */
	public void checkTenderTotalBtn(){
		
		base.checkElementVisible(tenderTotalBtn);
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);
		WebElement tenderDiv = null;
		if(tenderTotalBtnList.size() != 0){
			for(int i = 0; i < 1; i++){
				//�������Ͷ����ť
				tenderTotalBtnList.get(i).click();
				//��ȡ����Ͷ����ť�򿪵�DIV
				tenderDiv = getTenderOpenDiv();
				if(tenderDiv!=null){
					clickTenderCloseDivBtn(tenderDiv);		//�رմ�����ʾ����
				}
			}
		}
		else{
			System.out.println("error_��汦�б�ҳ��û����Ͷ��ť�����ֹ�У��");
			Reporter.log("error_��汦�б�ҳ��û����Ͷ��ť�����ֹ�У��");
			base.assertTrueByBoolean(false);
		}
	}
	
	/**
	 * ��汦�б�ҳ��У�顰��Ͷ����ť�Ĵ�����ʾ��Ϣ
	 * @param msg Ԥ�ڵĴ�����Ϣ
	 * @author ������ 2015-12-28
	 */
	public void checkQiangTouBtnErrorMsg(String msg){
		
		String msgStr = "";
		WebElement tenderDiv = null;
		base.checkElementVisible(tenderTotalBtn);
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);
		
		if(tenderTotalBtnList.size() == 0){
			System.out.println("error_��汦�б�ҳ��û����Ͷ��ť�����ֹ�У��");
			Reporter.log("error_��汦�б�ҳ��û����Ͷ��ť�����ֹ�У��");
			base.assertTrueByBoolean(false);
		}
		
		for(int i = 0; i < 1; i++){
			tenderTotalBtnList.get(i).click();			//�������Ͷ����ť
			tenderDiv = getTenderErrorDiv();			//��ȡ������ʾ����
			msgStr = printTenderErrorDiv(tenderDiv);
			if(tenderDiv!=null){
				clickTenderCloseDivBtn(tenderDiv);		//�رմ�����ʾ����
			}
			base.assertEqualsActualExpected(msgStr, msg);
		}
	}
	
	/**
	 * ��汦�б�ҳ�� У�顰��Ͷ����ť��δ��¼
	 * @author ������ 2015-5-15
	 */
	public void checkTenderTotalBtnNoLogin(){
		
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);
		if(tenderTotalBtnList.size() != 0){
			for(int i = 0; i < 1; i++){
				//�������Ͷ����ť
				tenderTotalBtnList.get(i).click();
				//��顰��¼������Title
				checkBannerLoginWindowTitle();
			}
		}
		else{
			System.out.println("error_��汦�б�ҳ��û����Ͷ��ť�����ֶ���֤");
			Reporter.log("error_��汦�б�ҳ��û����Ͷ��ť�����ֶ���֤");
		}
		
	}
	
	/**
	 * ��汦�б�ҳ��У�顰��Ͷ����ť���ѵ�¼����ֵ
	 * @return id ��汦ID
	 * @author ������ 2015-5-15
	 */
	public String checkTenderTotalBtnRecharge() {
		
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);
		WebElement tenderDiv = null;
//		boolean isBuyValid = false;
		String id = "-1";
		if(tenderTotalBtnList.size() == 0){
			Reporter.log("error_��汦�б�ҳ��û����Ͷ��ť<br/>");
			System.out.println("error_��汦�б�ҳ��û����Ͷ��ť");
			return id;
		}
		for(int i = 0; i < 1; i++){
			//��ȡ����Ͷ����ť��onclick�¼��еĲ�Ʒid�����磺onclick="lender.openbuywindow(1,673,'13.50%')
			id = tenderTotalBtnList.get(i).getAttribute("onclick").split(",")[1];
//			//У�顰������Ч�ڡ��Ƿ���Ч��ȫ��Ϊ0Ϊ����Ч
//			isBuyValid = checkBuyValid(id);	
//			//���ݰ�ťid����ȡ��ʱ���֣��롱��ֵ
//			if(isBuyValid){
//				return id = "0";
//			}
			//�������Ͷ����ť
			tenderTotalBtnList.get(i).click();
			//��ȡ����Ͷ����ť�򿪵�DIV
			tenderDiv = getTenderOpenDiv();
			if(tenderDiv!=null){
				//�رյ�������
				clickTenderCloseDivBtn(tenderDiv);
				Reporter.log("error_��汦�б�ҳ���޷�Ͷ�ʣ�<br/>");
				System.out.println("error_��汦�б�ҳ���޷�Ͷ�ʣ�");
				return id = "0";
			}
		}
		return id;
	}
	
	/**
	 * ����Ԫ
	 * �����汦��Ͷ
	 */
	public boolean clickCreditBtn(){
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);  //System.out.println("һ��" + tenderTotalBtnList.size() + "����ť");//--------����
		if(tenderTotalBtnList.size() == 0){
			System.out.println("error_��汦�б�ҳ��û����Ͷ��ť");
		}else{
			for(int i = 0; i < 1; i++){   //System.out.println("��" + (i+1) + "����Ͷ��ť");//--------����
				//�������Ͷ����ť
				tenderTotalBtnList.get(i).click();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ��汦�б�ҳ����á���Ͷ������DIV
	 * @return ����DIV
	 * @author ������ 2015-5-14
	 */
	public WebElement getTenderOpenDiv(){
		
		String msgStr = "";
		//��ȡ2����ʾDIV
		List<WebElement> tenderDivList = base.getElements(tenderDivs);
		int i = 0, size = tenderDivList.size(); 
		//���ش򿪵�DIV��style������block��; �رյ�style��������none��
		for(; i < size; i++){
			if(tenderDivList.get(i).getAttribute("style").contains("block")){
				if(i == 0){
					msgStr = base.getElementTextWithWait(By.cssSelector("#errorMsg"));
				}
				else if(i == 1){
					msgStr = base.getElementTextWithWait(By.cssSelector("p.textC"));
				}
				Reporter.log("error_��汦�б�ҳ_������Ͷ��ť��ʾ��Ϣ�� " + msgStr + "<br/>");
				System.out.println("error_��汦�б�ҳ_������Ͷ��ť��ʾ��Ϣ�� " + msgStr);
				break;
			}
			//���û�е����κ�DIV���򷵻ؿ�
			else if(
					(i == (tenderDivList.size()-1)) && (tenderDivList.get(i).getAttribute("style").contains("none"))){
				return null;
			}
		}
		return tenderDivList.get(i);
	}
	
	/**
	 * ��汦�б�ҳ����á���Ͷ������������ϢDIV
	 * @return ������Ϣ
	 * @author ������ 2015-12-28
	 */
	public WebElement getTenderErrorDiv(){
		//��ȡ2����ʾDIV
		List<WebElement> tenderDivList = base.getElements(tenderDivs);
		int i = 0, size = tenderDivList.size(); 
		//���ش򿪵�DIV��style������block��; �رյ�style��������none��
		for(; i < size; i++){
			if(tenderDivList.get(i).getAttribute("style").contains("block")){
				break;
			}
			else if(//���û�е����κ�DIV���򷵻ؿ�
					(i == (tenderDivList.size()-1)) && (tenderDivList.get(i).getAttribute("style").contains("none"))){
				return null;
			}
		}
		return tenderDivList.get(i);
	}
	
	/**
	 * ��汦�б�ҳ���������Ͷ������������Ϣ
	 * @param tenderDiv ������Ϣ����
	 * @return ������Ϣ
	 * @author ������ 2015-12-28
	 */
	public String printTenderErrorDiv(WebElement tenderDiv){
		
		String msg = "";
		String id = base.getAttribute(tenderDiv, "id");
		if(id.equals("fastLender_2")){
			msg = base.getElementTextWithWait(By.cssSelector("#errorMsg"));
		}
		else if(id.equals("noPerson")){
			msg = base.getElementTextWithWait(By.cssSelector("p.textC"));
		}
		return msg;
	}
	
	/**
	 * ��汦�б�ҳ����ȡ����ʧ��DIV
	 * @return true��Ϊ����
	 * @author ������ 2015-7-7
	 */
	public boolean getOperationFailureDiv(){
		if(base.isElementContainsValue(operationFailureDiv, "style", "block")){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * ��汦�б�ҳ���رղ���ʧ��DIV
	 * @author ������ 2015-7-7
	 */
	public void closeOperationFailureDiv(){
		base.clickWithWait(closeOperationFailureDiv);
	}
	
	/**
	 * ��汦�б�ҳ����ùرա���Ͷ��DIV��ť
	 * @param id (fastLender_2,noPerson����)
	 * @return �رա���Ͷ��DIV��ť
	 * @author ������ 2015-5-14
	 */
	public By getTenderCloseDivBtn(String id){
		return By.xpath("//div[@id='" + id + "']//a");
	}
	
	/**
	 * ��汦�б�ҳ������رա���Ͷ��DIV��ť
	 * @param ����Ͷ��DIV��ť
	 * @author ������ 2015-5-14
	 */
	public void clickTenderCloseDivBtn(WebElement tenderDiv){
		
		//У�鵯�����Ƿ���ʾ
		base.assertTrueByBoolean(tenderDiv.getAttribute("style").contains("block"));
		String id = tenderDiv.getAttribute("id");
		base.clickElementNoWait(getTenderCloseDivBtn(id));
		//У�鵯�����Ƿ�����
		base.assertTrueByBoolean(tenderDiv.getAttribute("style").contains("none"));
	}
	
	/***************�б�ҳ_����_Ͷ����Ϣ�������Ͷ��ť���ҳ�棩**************/
	
	/**
	 * ��汦�б�ҳ����ȡ����Ͷ���ı���
	 * @param id (ÿ�ڲ�Ʒ��Ӧ��ID����ҳ���ȡ��)
	 * @return ����Ͷ���ı���
	 * @author ������ 2015-5-18
	 */
	public By getInvestmentAmountTxt(String id){
		id = "wmpsYuGouAmount" + id;//System.out.println(id);//----------����
		return By.cssSelector("#" + id);
	}
	
	/**
	 * ��汦�б�ҳ���������Ͷ���ı���
	 * @param id 
	 * @author ������ 2015-8-13
	 */
	public void clickInvestmentAmountTxt(String id){
		By investmentAmount = getInvestmentAmountTxt(id);
		base.clickWithWait(investmentAmount);
	}
	
	/**
	 * ��汦�б�ҳ������Ͷ���ı�����������
	 * @param id (ÿ�ڲ�Ʒ��Ӧ��ID����ҳ���ȡ��)
	 * @param amount(����Ľ��)
	 * @author ������ 2015-5-18
	 */
	public void inputInvestmentAmountTxt(String id, String amount){
		
		By investmentAmountTxt = getInvestmentAmountTxt(id);
		base.checkElement(investmentAmountTxt);
		try {
			base.getElementNoWait(investmentAmountTxt).sendKeys(amount);
		} catch (Exception e) {
			Reporter.log("error_��汦�б�ҳ������Ͷ���ı���δ��ʾ�����ֶ�����<br/>");
			System.out.println("error_��汦�б�ҳ������Ͷ���ı���δ��ʾ�����ֶ�����");
			e.printStackTrace();
		}
	}
	
	/**
	 * ��汦�б�ҳ����ȡ�˻����
	 * @param eCunBaoID ��汦ID
	 * @return �˻����
	 * @author ������ 2015-11-24
	 */
	public String getAccountBalance(String eCunBaoID){
		
		By accountBalance = By.cssSelector("#userBalance" + eCunBaoID);
		//���ܼ�顰���Ƿ����
//		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(accountBalance), true);
		String balanceStr = base.getElementText(accountBalance);
		balanceStr = balanceStr.substring(0, balanceStr.indexOf(" Ԫ"));
		return balanceStr;
	}
	
	/**
	 * ��汦�б�ҳ�����������
	 * @param id (ÿ�ڲ�Ʒ��Ӧ��ID����ҳ���ȡ��)
	 * @author ������ 2015-8-13
	 */
	public void clickMaxMoney(String id){
		By maxMoney = By.xpath("//a[contains(@href,'(" + id + ")')]");
		base.clickWithWait(maxMoney);
	}
	
	/**
	 * ��汦�б�ҳ����ȡ��ͬ��Э�鲢Ͷ�ʡ���ť
	 * @param id (ÿ�ڲ�Ʒ��Ӧ��ID����ҳ���ȡ��)
	 * @author ������ 2015-5-18
	 */
	public By getAgreeInvestmentBtn(String id){
		return By.xpath("//a[contains(@onclick,'" + id + "') and @class='tongyi btn dis_block reddw']");
	}
	
	/**
	 * ��汦�б�ҳ�� �����ͬ��Э�鲢Ͷ�ʡ���ť
	 * @param id (ÿ�ڲ�Ʒ��Ӧ��ID����ҳ���ȡ��)
	 * @author ������ 2015-5-18
	 */
	public void clickAgreeInvestmentBtn(String id){
		base.getElementNoWait(getAgreeInvestmentBtn(id)).click();
	}
	
	/**
	 * ��汦�б�ҳ��У������Ƿ�����汦
	 * @param buyBalance �˻����
	 * @param money ������汦�Ľ��
	 * @return true�����Թ���false:����
	 * @author ������ 2015-11-24
	 */
	public boolean checkECunBaoBalance(String buyBalance, String money){
		
		int moneyInt = Integer.valueOf(money);
		int index  = buyBalance.indexOf(".");
		if(index != -1){
			buyBalance = buyBalance.substring(0, index);
		}
		int buyBalanceInt = Integer.valueOf(buyBalance);//�˻����
		if(buyBalanceInt > moneyInt){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * ��汦�б�ҳ���������Ͷ����ť������汦
	 * @param money ������
	 * @author ������ 2015-12-21
	 */
	public void qiangTou(String money){
		
		String eCunBaoId = "";	//��汦��Ʒid
		String balance = ""; 	//�˻����
		
		TotalPage.openPage("�ҵ��˻�", true);
		myAccountPage.turnToMyAccount("���׼�¼");
		myAccountPage.turnToMyAccount("�˻�����");
		if(base.Windowsize() != 1){
			base.closeWebDriver();
		}
		balance = myAccountPage.getBalance_1() + ""; System.out.println("�˻����1��" + balance);//----------����
		
		TotalPage.openPage("��汦�б�ҳ", true);
		eCunBaoId = checkTenderTotalBtnRecharge(); 
		System.out.println("��汦ID��" + eCunBaoId);
		
		//���û�е����޷���Ͷ�Ի�������Ͷ��-1 ����û�а�ť��0 �����������
		if(eCunBaoId.equals("0") || eCunBaoId.equals("-1")){
			base.assertTrueByBoolean(false);
		}
		//����Ƿ�
		if(!checkECunBaoBalance(balance, money)){
			Reporter.log("error_��汦�б�ҳ_�˻����㣬���ֶ�У��");
			System.out.println("error_��汦�б�ҳ_�˻����㣬���ֶ�У��");
			base.assertTrueByBoolean(false);
		}
		//������
		inputInvestmentAmountTxt(eCunBaoId, money);
		//�����ͬ��Э�鲢Ͷ�ʡ�
		clickAgreeInvestmentBtn(eCunBaoId);
		//��ȡ����ʧ��DIV
		if(getOperationFailureDiv()){
			closeOperationFailureDiv();
			Reporter.log("��汦�б�ҳ��Ͷ�ʺ���ʾ����ʧ��~");
			System.out.println("��汦�б�ҳ��Ͷ�ʺ���ʾ����ʧ��~");
			base.assertTrueByBoolean(false);
		}
		
		TotalPage.openPage("�ҵ��˻�", true);
		myAccountPage.turnToMyAccount("���׼�¼");
		myAccountPage.turnToMyAccount("�˻�����");
		if(base.Windowsize() != 1){
			base.closeWebDriver();
		}
		String newBalance = myAccountPage.getBalance_1() + ""; System.out.println("�˻����2��" + newBalance);//----------����
		checkBuySuccess(balance, newBalance,money);//У�鹺���Ƿ�ɹ�
	}
	
	public void qiangTou(String eCunBaoId, String money){
		
		String balance = ""; //�˻����
		
		TotalPage.openPage("�ҵ��˻�", true);
		myAccountPage.turnToMyAccount("���׼�¼");
		myAccountPage.turnToMyAccount("�˻�����");
		if(base.Windowsize() != 1){
			base.closeWebDriver();
		}
		balance = myAccountPage.getBalance_1() + ""; System.out.println("�˻����1��" + balance);//----------����
		
		TotalPage.openPage("��汦�б�ҳ", true);
		//����Ƿ�
		if(!checkECunBaoBalance(balance, money)){
			Reporter.log("error_��汦�б�ҳ_�˻����㣬���ֶ�У��");
			System.out.println("error_��汦�б�ҳ_�˻����㣬���ֶ�У��");
			base.assertTrueByBoolean(false);
		}
		//�������Ͷ����ť
		clickQiangTouBtn(eCunBaoId);
		//������
		inputInvestmentAmountTxt(eCunBaoId, money);
		//�����ͬ��Э�鲢Ͷ�ʡ�
		clickAgreeInvestmentBtn(eCunBaoId);
		//��ȡ����ʧ��DIV
		if(getOperationFailureDiv()){
			closeOperationFailureDiv();
			Reporter.log("��汦�б�ҳ��Ͷ�ʺ���ʾ����ʧ��~");
			System.out.println("��汦�б�ҳ��Ͷ�ʺ���ʾ����ʧ��~");
			base.assertTrueByBoolean(false);
		}
		
		TotalPage.openPage("�ҵ��˻�", true);
		myAccountPage.turnToMyAccount("���׼�¼");
		myAccountPage.turnToMyAccount("�˻�����");
		if(base.Windowsize() != 1){
			base.closeWebDriver();
		}
		String newBalance = myAccountPage.getBalance_1() + ""; System.out.println("�˻����2��" + newBalance);//----------����
		checkBuySuccess(balance, newBalance,money);//У�鹺���Ƿ�ɹ�
	}
	
}
