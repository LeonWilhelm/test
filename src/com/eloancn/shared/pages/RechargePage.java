package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
/*
 * ���ҵ��˻���-����ֵ��ҳ��
 */
public class RechargePage {
	Base base = new Base();
	
	public static By ImproveProfileTxt = By.xpath("//form[@id='userFrom']/div/table/tbody/tr/td/div/div/h2");//�����Ƹ�����Ϣ����ʾ
	public static By OnlineRechargeTxt=By.cssSelector("span.current.wd110");
	String rechargeHandel = "";
	String jianSheHandel = "";
	
	//ת�˻��
	By transferRemittanceTab = By.cssSelector(".wd140");
	/**************���Ƹ��������Ϣ***********/
	//���Ƹ��������Ϣ
	By identityInfoTxt = By.cssSelector("#userinfo .u-tt");
	//����
	By prealnameTxt = By.cssSelector("#prealname");
	//���֤��
	By pidcardTxt = By.xpath("//input[@id='pidcard']");//By.cssSelector("#pidcard");//By.id("pidcard");
	//֧������
	By zzmmTxt = By.id("zfmm_s");
	By zzmmTxtByCss = By.cssSelector("#zfmm_s");
//	By ppaypasswordTxt = By.id("ppaypassword");
	By ppaypasswordTxt = By.cssSelector("#ppaypassword");
	//��֤������
	By saveBtn = By.xpath("//input[@value='��֤������']");
	//����ȥ��ֵ
	By rechargeBtn = By.xpath("//input[@value='����ȥ��ֵ']");
	//�ر�
	By closeBtn = By.cssSelector(".lyclose");
	//msg
	By msgTxt = By.id("msg");
	//����������ʾ��Ϣ
	public By nameMsg = By.cssSelector("#nametip");
	//������ȷ��ʾͼƬ
	public By nameCheckmarkImg = By.cssSelector("#prealnametipMsg > img");
	//���֤������ʾ��Ϣ
	By idMsg = By.cssSelector("#idcardtip");
	By pidMsg = By.cssSelector("#pidcardtipMsg > span");
	//֧�����������ʾ��Ϣ
	By payMsg = By.cssSelector("#ppaytip"); 
	/***************��ֵ****************/
	//��Ʒ����ֵ
	By giftCardRechargeLink = By.cssSelector(".cardStyle.fr");			//��Ʒ����ֵ
	By giftCardRechargeDiv = By.cssSelector("#giftCardPay");			//��Ʒ����ֵDIV
	By giftCardRechargeNum = By.cssSelector("#serialnumber");			//����
	By giftCardRechargePass = By.cssSelector("#password");				//����
	By giftCardRechargeSubmit = By.cssSelector(".btn1.ml150>input");	//�ύ
	By giftCardRechargeClose =  By.cssSelector("#giftCardPay .close");	//�ر�
	By gittCardRechargeMsgSuccess = By.cssSelector("#tips");			//��ֵ�ɹ���ʾ��Ϣ
	
	//���ת��>>>>>>>>>>>>>>>>>
	//�������
	By dateTxt = By.id("transactionTime");
	//�����
	By moneyTxt = By.id("money");
	//�����
	By outBankTxt = By.id("outBank");
    //����˻�
	By outBankLastTxt = By.id("outBankLast4");
	//�ύ
	By submitBtn = By.id("chongzhi");
	//����
	By resetBtn = By.cssSelector("input[class='ml5'][type='reset']");
	//˵��
	By descriptionTxt = By.cssSelector("#description");//By.id("description");
	//������ֵ>>>>>>>>>>>>>>>>>
	By GuangDaBank = By.cssSelector("#paymentList3 .CEB");
	By jianSheNank = By.cssSelector("#paymentList3 .CCB");
	//��ֵ���
	By rechargeTxt = By.cssSelector("#rechargeAmount #tranAmt");//By.id("tranAmt");
	//��ֵ��ť
	By rechargeCyberBtn = By.id("oltopay");
	//����ɳ�ֵ
	By rechargeOkBtn = By.cssSelector(".btn-fc.btn-cp");
	//��ֵ����
	By rechargeQuestionBtn = By.cssSelector(".btn-fc.btn-qt");
	//��ܰ��ʾ�رհ�ť
	By promptCloseBtn = By.cssSelector("#paytip .lyclose");
	
	/**
	 * �������Ʒ����ֵ��
	 */
	public void clickGiftCardRechargeLink(){
		base.checkElementVisible(giftCardRechargeLink);
		base.clickElementNoWait(giftCardRechargeLink);
		boolean isBlock = base.isElementContainsValue2(giftCardRechargeDiv, "style", "block");
		base.assertEqualsActualExpectedByBoolean(isBlock, true);
	}
	
	/**
	 * ���뿨��
	 * @param num ����
	 * @author ������ 2015-12-1
	 */
	public void inputGiftCardRechargeNum(String num){
		base.checkVisible(giftCardRechargeNum);
		base.elementSendkey(giftCardRechargeNum,num);
	}
	
	/**
	 * ��������
	 * @param pass ����
	 * @author ������ 2015-12-1
	 */
	public void inputGiftCardRechargePass(String pass){
		base.checkVisible(giftCardRechargePass);
		base.elementSendkey(giftCardRechargePass,pass);
	}
	
	/**
	 * ����ύ��ť
	 * @author ������ 2015-12-1
	 */
	public void clickGiftCardRechargeSubmit(){
		base.checkVisible(giftCardRechargeSubmit);
		base.clickElementNoWait(giftCardRechargeSubmit);
	}
	
	/**
	 * ����رհ�ť
	 * @author ������ 2015-12-1
	 */
	public void clickGiftCardRechargeClose(){
		base.checkVisible(giftCardRechargeClose);
		base.clickElementNoWait(giftCardRechargeClose);
		boolean isNone = base.isElementContainsValue(giftCardRechargeDiv, "style", "none");
		base.assertEqualsActualExpectedByBoolean(isNone, true);
	}
	
	/**
	 * У����ʾ��Ϣ�Ƿ�Ϊ��ֵ�ɹ�
	 * @author ������ 2015-12-1
	 */
	public void isGittCardRechargeMsgSuccess(){
		String msg = base.getElementTextWithWait(gittCardRechargeMsgSuccess);
		base.assertEqualsActualExpected(msg, "��ֵ�ɹ�!");
	}
	
	/**
	 * �ύ��Ʒ����ֵ
	 * @param num ����
	 * @param pass ����
	 * @author ������ 2015-12-1
	 */
	public void submitGiftCardRecharge(String num, String pass){
		inputGiftCardRechargeNum(num);
		inputGiftCardRechargePass(pass);
		clickGiftCardRechargeSubmit();
	}
	
	/**
	 * ��ֵ����У����ʾ��Ϣ�Ƿ�Ϊ��ֵ�ɹ�
	 * @param num ����
	 * @param pass ����
	 * @author ������ 2015-12-1
	 */
	public void checkGittCardRechargeMsgSuccess(String num, String numPass){
		submitGiftCardRecharge(num, numPass);
		isGittCardRechargeMsgSuccess();
		clickGiftCardRechargeClose();
	}
	
	/**
	 * ����Ԫ
	 * ��ʾ�����֤
	 */
	public void isIdentityInfo(){
		base.assertEqualsActualExpectedByBoolean(base.checkVisible(By.cssSelector("#userinfo")), true);
	}
	
	/**
	 * ����Ԫ
	 * У��������Ϣ������Ƿ���ʾ
	 */
	public void checkShowUserInfoInput(boolean nameResult,boolean idCardResult,boolean zfmmResult){
		base.assertEqualsActualExpectedByBoolean(base.checkVisibleNoWaite(By.id("nameli")), nameResult);
		base.assertEqualsActualExpectedByBoolean(base.checkVisibleNoWaite(By.id("idcardli")), idCardResult);
		base.assertEqualsActualExpectedByBoolean(base.checkVisibleNoWaite(By.id("paypasswordli")), zfmmResult);
	}
	
	/**
	 * ����Ԫ
	 * ��ֵ ת�˻��
	 */
	public void rechargeTransferRemittance(String realName,String idCard,String zzmm,String date,String money,String outBank,String outBankNum,String description){
		//base.sleep(5000);
		//if(base.isBlock(By.id("nameli")) || base.isBlock(By.id("idcardli")) || base.isBlock(By.id("paypasswordli"))){//���������Ϣ
		if(base.checkVisible(By.cssSelector("#userinfo"))){
			setInfo(realName,idCard,zzmm);
		}
		//ת�˻��
		if(!base.isElementVisible(transferRemittanceTab)){
			base.setDisplayByClassName("wd140", "block");
		}
		base.clickWithWait(transferRemittanceTab);
		//�����
		base.clickWithWait(moneyTxt);
		base.elementSendkeyNoClear(moneyTxt, money);
		//�������
		System.out.println(date);
		base.setDate("transactionTime", date);
		//�����
		base.sendKeysWithWait(outBankTxt, outBank);
		//base.sleep(2000);
		//base.keyBoard(1);
		//����˻�
		base.sendKeysWithWait(outBankLastTxt,outBankNum);
		base.sendKeysWithWait(descriptionTxt,description);
		base.clickWithWait(submitBtn);
	}
	
	/**
	 * ת�˻��¼����Ϣ
	 */
	public void rechargeTransferRemittance(String date,String money,String outBank,String outBankNum,String description){
		base.sleep(3000);
		if(!base.isElementVisible(transferRemittanceTab)){
			base.setDisplayByClassName("wd140", "block");
		}
		//ת�˻��
		base.clickWithWait(transferRemittanceTab);
		//�����
		base.clickWithWait(moneyTxt);
		base.elementSendkeyNoClear(moneyTxt, money);
		//�������
		base.setDate("transactionTime", date);
		//�����
		base.sendKeysWithWait(outBankTxt, outBank);
		//����˻�
		base.sendKeysWithWait(outBankLastTxt,outBankNum);
		//˵��
		base.sendKeysWithWait(descriptionTxt,description);
	}
	
	/**
	 * У�����ð�ť
	 * @author ������ 2015-9-6
	 */
	public void checkResetByTransferRemittance(){
		base.clickWithWait(resetBtn);
		base.assertEqualsActualExpected(base.getElementText(moneyTxt), "");
		base.assertEqualsActualExpected(base.getElementText(dateTxt), "");
		base.assertEqualsActualExpected(base.getElementText(outBankTxt), "");
		base.assertEqualsActualExpected(base.getElementText(outBankLastTxt), "");
		base.assertEqualsActualExpected(base.getElementText(descriptionTxt), "");
	}
	
	/**
	 * ����Ԫ
	 * ��֤�Ƿ��ֵ�ɹ�
	 */
	public void isRecharge(){
		Alert alert = base.getAlertwithWait();
		try {
			base.assertEqualsActualExpected(alert.getText(), "��ϲ������ɹ�����ȴ�ϵͳ��ʵ��");
			alert.accept();
		} catch (AssertionError e) {
			alert.accept();
			base.assertTrueByBoolean(false);
		}
	}
	
	/**
	 * ����Ԫ
	 * �رա����Ƹ��������Ϣ��
	 */
	public void closeInfo(){
		base.clickWithWait(By.cssSelector("#userinfo .lyclose"));//closeBtn
	}
	
	/**
	 * ���Ƹ�����Ϣ
	 * ����Ԫ
	 */
	public String[] setInfo(String realName,String idCard,String zzmm){
		String[] info = {realName,idCard};
		if(base.checkVisible(By.id("nameli"))){//usernameli
			base.sendKeysWithWait(prealnameTxt, realName);
		}
		if(base.checkVisible(By.id("idcardli"))){//relidcardli
			base.sendKeysWithWait(pidcardTxt, idCard);
		}
		if(base.checkVisible(By.id("paypasswordli"))){
			int i = 0;
			do{
				i++;
				base.clickWithWait(zzmmTxtByCss);
			}while(base.checkVisible(zzmmTxtByCss,5) && i<3);//�ж��Ƿ���֧�������ı��򣬷���ѭ�����
			base.sendKeysWithWait(ppaypasswordTxt, zzmm);
		}
		//Reporter.log("test�����������Dataע������test_register_credit_idCard��test_register_credit_realName");
		//�����֤���Ѿ���ע�ᣡ�������� �����֤��
		if (base.checkVisible(By.cssSelector("#idcardtip"),5)) {
			Reporter.log(realName+","+idCard+base.getElementTextWithWait(By.cssSelector("#idcardtip")));
			System.out.println(realName+","+idCard+idCard+base.getElementTextWithWait(By.cssSelector("#idcardtip")));
			if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
				Reporter.log("�����֤����ʹ��");
				System.out.println("�����֤����ʹ��");
				base.assertTrueByBoolean(false);
			}else {
				idCard = new Data().idConcatenation();
			}
			base.sendKeysWithWait(pidcardTxt, idCard);
			Reporter.log("Ͷ������Ϣ����Ϊ��"+realName+","+idCard);
			System.out.println("Ͷ������Ϣ����Ϊ��"+realName+","+idCard);
		}
		base.clickWithWait(saveBtn);
		base.sleep(3000);
		isSetInfoOK();
		Reporter.log(realName+","+idCard+"��������Ϣ");
		System.out.println(realName+","+idCard+"��������Ϣ");
		base.clickWithWait(rechargeBtn);
		info[0] = realName;
		info[1] = idCard;
		return info;
	}
	
	/**
	 * ���Ƹ�����Ϣ_��������ı���
	 * @author ������ 2015-7-21
	 */
	public void clickInfoByRealName(){
		if(base.isBlock(By.id("nameli"))){
			int count = 1;//�������
			do{
				base.clickWithWait(prealnameTxt);
				System.out.println("�����ı�����" + count + "��");
				count++;
			}while(!base.checkVisible(By.cssSelector("#prealnametipMsg > span"),5));
			
			base.sleep(2000);
		}
	}
	
	/**
	 * ���Ƹ�����Ϣ_���֧�������ı���
	 * @author ������ 2015-7-21
	 */
	public void clickInfoByPayPassword(){
		if(base.isBlock(By.id("paypasswordli"))){
			int count = 1;//�������
			do{
				base.clickWithWait(ppaypasswordTxt);
				System.out.println("֧�������ı�����" + count + "��");
				count++;
			}while(!base.checkVisible(By.cssSelector("#ppaypasswordMsg > span"),5));//�ж��Ƿ���֧�������ı��򣬷���ѭ�����

//			base.assertEqualsActualExpectedByBoolean(base.isNone(ppaypasswordTxt), false);
			base.sleep(2000);
		}
	}
	
	/**
	 * ���Ƹ�����Ϣ_����
	 * @param ����
	 * @author ������ 2015-7-21
	 */
	public void setInfoByRealName(String realName){
//		if(base.isBlock(By.id("nameli"))){
			base.clickWithWait(prealnameTxt);
			base.sendKeysWithWait(prealnameTxt, realName);
			base.sleep(2000);
//		}
	}
	
	/**
	 * ���Ƹ�����Ϣ�������֤��
	 * @param ���֤��
	 * @author ������ 2015-7-21
	 */
	public void setInfoByIdCard(String idCard){
		boolean isShow = false;
		try {
			isShow = base.isBlock(By.cssSelector("#idcardli"));
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("���֤���б��ǩliû���ҵ���");
		}
		if(isShow){
			base.clickWithWait(pidcardTxt);
			base.sendKeysWithWait(By.cssSelector("#pidcard"), idCard);//pidcardTxt
			base.sleep(2000);
		}
	}
	
	/**
	 * ���Ƹ�����Ϣ����֧������
	 * @param ֧�������Ƿ�Ϊ��
	 * @author ������ 2015-7-21
	 */
	public void setInfoByPayPassword(String payPassword, boolean isEmpty){
		if(base.isBlock(By.id("paypasswordli"))){System.out.println("֧�������Ƿ�Ϊ��: " + isEmpty);
			//�״�������Ҫ���
			if(isEmpty){
				do{
					base.clickWithWait(zzmmTxtByCss);
					base.sleep(2000);
				}while(!base.checkVisible(By.cssSelector("#ppaypassword"),5));//�ж��Ƿ���֧�������ı��򣬷���ѭ�����
			}
			base.assertEqualsActualExpectedByBoolean(base.isNone(ppaypasswordTxt), false);
			base.sleep(2000);
			base.sendKeysWithWait(ppaypasswordTxt, payPassword);
			base.sleep(2000);
		}
	}
	
	/**
	 * ����Ԫ
	 * ������Ϣ���Ƴɹ�
	 */
	public void isSetInfoOK(){
		//base.assertEqualsActualExpected(base.getElementText(msgTxt), "��֤�������ϲ���������֤�ѳɹ���");
		base.assertTrueByBoolean(base.getElementText(msgTxt).contains("�ɹ�"));
	}
	
	/**
	 * ������Ϣ������ȥ��ֵ
	 * ����Ԫ
	 */
	public void clickGoRecharge(){
		base.clickWithWait(By.cssSelector(".btn1>input[value='����ȥ��ֵ']"));
	}
	
	/**
	 * ����Ԫ
	 * ������ֵ
	 */
	public void rechargeCyberBank(String money){
		//ѡ��������
		base.clickWithWait(jianSheNank);//GuangDaBank
		//��ֵ���
		base.clickWithWait(rechargeTxt);
		base.elementSendkeyNoClear(rechargeTxt, money);
		//��ֵ��ť
		rechargeHandel = base.getCurrentWindowHandle();//System.out.println("�����ھ���� " + rechargeHandel);//-----����
		base.clickWithWait(rechargeCyberBtn);
	}
	
	/**
	 * ѡ������  ����ICBC ����CCB ũҵABC ����CMB
	 * ����Ԫ
	 */
	public void selectBank(String type){
		base.clickWithWait(By.cssSelector("#paymentList3 ."+type));
	}
	
	/**
	 * ����Ԫ
	 * У�����������޶�
	 */
	public void checkAllBankLimit(){
		String banks[] = {"ICBC","CCB","ABC","CMB","BOCOM","SPDB","GDB","SDB","HXBC","CIB","CEB","PSBC","CITIC","CMBC","BOC"};
		boolean result = true;
		base.clickWithWait(By.cssSelector(".cpt"));//��������ֵ��ʽ
		for (int i = 0; i < banks.length; i++) {
			selectBank(banks[i]);
			base.clickWithWait(By.cssSelector("#gfb"));//ѡ�����ͨ
			System.out.println("ѡ�����ͨ");
			Reporter.log("ѡ�����ͨ</br>");
			if (!checkBankLimit(banks[i],"gfb")) {
				result = false;
			}
			base.clickWithWait(By.cssSelector("#yib"));//ѡ���ױ�֧��
			System.out.println("ѡ���ױ�֧��");
			Reporter.log("ѡ���ױ�֧��</br>");
			if (banks[i].equals("SPDB") || banks[i].equals("HXBC") || banks[i].equals("CIB")) {
				base.checkAlertText("�ױ���֧�ָ�����");
			}else {
				if (!checkBankLimit(banks[i],"ybzf")) {
					result = false;
				}
			}
		}
		base.assertTrueByBoolean(result);
	}
	
	/**
	 * �����޶��Ƿ���ȷ
	 * ����Ԫ
	 */
	public boolean checkBankLimit(String bank,String type){
		String title[] = null;
		String limit[] =null;
		String id = "";
		/****************������******************/
		//����ICBC 
		String ICBCTitle[] = {"","����U�ܣ�һ����������","����̬������","����������п������ͨ������֤","����������п��(���迪ͨ������֤)"};
		String ICBCLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","100��","100��","50��","100��","2000","5000","500","1000","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����CCB
		String CCBTitle[] = {"","��̬���","������֤��","�ļ�֤��+��̬���","����������","UKEY+��̬���"};
		String CCBLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","5000","5000","5000","5000","5000","5000","50��","50��","50��","50��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//ũҵABC
		String ABCTitle[] = {" ","��̬����û�","�ƶ�֤���û�(һ��)","�ƶ�֤���û�(����)"};
		String ABCLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","1000","3000","50��","100��","���޶�","���޶�","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����CMB
		String CMBTitle[] = {"","���ڰ�","רҵ��"};
		String CMBLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","5000","5000","���޶�","���޶�","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//��ͨBOCOM
		String BOCOMTitle[] = {"","�ֻ�ע���û�","֤����֤�û�"};
		String BOCOMLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","5��","5��","5��","100��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//�ַ�SPDB
		String SPDBTitle[] = {"","����֤���û�","��̬�����û�"};
		String SPDBLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","���޶�","���޶�","20��","20��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//�㷢GDB
		String GDBTitle[] = {"","�ֻ���̬��֤","Key��"};
		String GDBLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","��̨��ͨ�������̻����ʡ����޶�Ϊ500Ԫ\n���������̻����ʡ����޶�Ϊ3000Ԫ","����̨��ͨ�������̻����ʡ����޶�Ϊ500Ԫ\n���������̻����ʡ����޶�Ϊ2��Ԫ","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//ƽ��SDB
		String SDBTitle[] = {"","��̬����","������"};
		String SDBLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","5��","5��","5��","5��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����HXBC
		String HXBCTitle[] = {"","ֱ��֧��","����Ǯ��ǩԼ"};
		String HXBCLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","300","300","5��","10��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//��ҵCIB
		String CIBTitle[] = {"","�ֻ�������֤","U��֤��"};
		String CIBLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","�����޶�͵����޶�Ϊ5000Ԫ����5��Ԫ����ң�\n�ɿͻ��ڿ�ͨ����֧������ʱ����ѡ��","���޶�","���޶�","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//���CEB
		String CEBTitle[] = {"","���п�ֱ��֧���ֻ���̬������������","���п�ֱ��֧�����ƶ�̬����","����רҵ��֧���ֻ���̬����","����רҵ��֧�����ƶ�̬����","����רҵ��֧����������"};
		String CEBLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","2��","100��","2��","100��","50��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����PSBC
		String PSBCTitle[] = {"","�����������ſͻ�","��������UK+���Ž𿨿ͻ�","��������UK+���Ű׽𿨡���ʯ���ͻ�"};
		String PSBCLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","5��","5��","500��","500��","1000��","1000��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����CITIC
		String CITICTitle[] = {"","����̬����","�����ƶ�֤��","����+֤��","Ukey"};
		String CITICLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","1000","5000","1000","5000","1��","5��","100��","100��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����CMBC
		String CMBCTitle[] = {"","������֤+��������","�����֤��+��������","��̬���ƣ�OTP��","�����U��"};
		String CMBCLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","5000","5000","5000","5000","50��","50��","50��","50��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//�й�BOC
		String BOCTitle[] = {"","�����츶","רҵ��"};
		String BOCLimit[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","1000","5000","5��","50��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		/****************�ױ�֧��******************/
		//����ICBC 
		String ICBCTitle1[] = {"","����ע�������̬����ͻ�","�������п���ͻ���δ��ͨ������֤��","�������п���ͻ�����ͨ������֤��","����������","һ��U�ܿͻ���δ��ͨ������֤��","һ��U�ܿͻ�����ͨ������֤��","����U�ܿͻ�","��������ǩԼ�ͻ�"};
		String ICBCLimit1[] = {"�����޶�(Ԫ)","300","500","2000","20��","50��","100��","100��","5000"
				,"ÿ���޶�(Ԫ)","300","1000","5000","100��","100��","100��","100��","5000","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����CCB
		String CCBTitle1[] = {"","ȫ����ǩԼ��","��̬������ιο���","���Ŷ�̬����","�ļ�֤��","����������","�ļ�֤��+�ιο�","USB Key+��̬���","�����߶˰�","USB Key+���Ŷ�̬����","�ιο�+���Ŷ�̬����","USB Key+����ȷ��","USB Key","��Ƶ��"};
		String CCBLimit1[] = {"�����޶�(Ԫ)","50��","5000","5000","0","50��","5000","50��","50��","50��","���޶�","50��","50��","���޶�"
				,"ÿ���޶�(Ԫ)","50��","5000","5000","0","50��","5000","50��","50��","50��","���޶�","50��","50��","���޶�","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//ũҵABC
		String ABCTitle1[] = {" ","һ��K��","����K��","��̬���","K��֧��"};
		String ABCLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","50��","100��","100��","500��","1000","1000","1000","3000","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����CMB
		String CMBTitle1[] = {"","USBkey","���ڰ�"};
		String CMBLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","���޶�","���޶�","5000","���޶�","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//��ͨBOCOM
		String BOCOMTitle1[] = {"","USBKey(֤����֤��)","���������"};
		String BOCOMLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","100��","100��","5��","5��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//�ַ�SPDB
		String SPDBTitle1[] = {"","�ֻ���̬����","U��"};
		String SPDBLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","20��","20��","100��","100��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//�㷢GDB
		String GDBTitle1[] = {"","USBKey","��̬����","key��"};
		String GDBLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","5000","5000","5000","5000","5000","5000","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//ƽ��SDB
		String SDBTitle1[] = {"","USBKey","��̬����"};
		String SDBLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","5��","5��","5��","5��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����HXBC
		String HXBCTitle1[] = {"","��ǩԼ�û�","ǩԼ�û�"};
		String HXBCLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","300","1000","���޶�","���޶�","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//��ҵCIB
		String CIBTitle1[] = {"","֤��ͻ�","��֤��ͻ�","����֧����(e��)"};
		String CIBLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","���޶�","���޶�","�����޶�͵����޶�Ϊ1000Ԫ����5000Ԫ����ң�\n�ɿͻ��ڿ�ͨ����֧������ʱ����ѡ��","5000","5000","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//���CEB
		String CEBTitle1[] = {"","��̬����","��������","PUSH֧��"};
		String CEBLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","1��","1��","50��","50��","1��","1��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����PSBC
		String PSBCTitle1[] = {"","XXUSBKey","XX��̬����","��������"};
		String PSBCLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"���","200��","200��","1��","1��","20��","20��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����CITIC
		String CITICTitle1[] = {"","��̬����","USBKey"};
		String CITICLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","1000","5000","100��","100��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//����CMBC
		String CMBCTitle1[] = {"","���ڰ�(������֤��)","���ڰ�(�����֤��)","�����(U��)","�����(OTP)"};
		String CMBCLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","5000","5000","5000","5000","50��","50��","50��","50��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		//�й�BOC
		String BOCTitle1[] = {"","���&UKEY"};
		String BOCLimit1[] = {" ","�����޶�(Ԫ)","ÿ���޶�(Ԫ)"
				,"��ǿ�","5��","50��","���ڸ������޶���ʱ�����������޶�����ѯ��������"};
		switch (bank) {
		case "ICBC":
			if(type.equals("gfb")){
				title=ICBCTitle;
				limit = ICBCLimit;
				id = "bankicbc1";
			}else {
				title=ICBCTitle1;
				limit = ICBCLimit1;
				id = "bankicbc7";
			}
			break;
		case "CCB":
			if(type.equals("gfb")){
				title = CCBTitle;
				limit = CCBLimit;
				id = "bankccb1";
			}else {
				title = CCBTitle1;
				limit = CCBLimit1;
				id = "bankccb7";
			}
			break;
		case "ABC":
			if(type.equals("gfb")){
				title = ABCTitle;
				limit = ABCLimit;
				id = "bankabc1";
			}else {
				title = ABCTitle1;
				limit = ABCLimit1;
				id = "bankabc7";
			}
			break;
		case "CMB":
			if(type.equals("gfb")){
				title = CMBTitle;
				limit = CMBLimit;
				id = "bankcmb1";
			}else {
				title = CMBTitle1;
				limit = CMBLimit1;
				id = "bankcmb7";
			}
			break;
		case "BOCOM":
			if(type.equals("gfb")){
				title = BOCOMTitle;
				limit = BOCOMLimit;
				id = "bankbocom1";
			}else {
				title = BOCOMTitle1;
				limit = BOCOMLimit1;
				id = "bankbocom7";
			}
			break;
		case "SPDB":
			if(type.equals("gfb")){
				title = SPDBTitle;
				limit = SPDBLimit;
				id = "bankspdb1";
			}else {
				title = SPDBTitle1;
				limit = SPDBLimit1;
				id = "bankspdb7";
			}
			break;
		case "GDB":
			if(type.equals("gfb")){
				title = GDBTitle;
				limit = GDBLimit;
				id = "bankgdb1";
			}else {
				title = GDBTitle1;
				limit = GDBLimit1;
				id = "bankgdb7";
			}
			break;
		case "SDB":
			if(type.equals("gfb")){
				title = SDBTitle;
				limit = SDBLimit;
				id = "banksdb1";
			}else {
				title = SDBTitle1;
				limit = SDBLimit1;
				id = "banksdb7";
			}
			break;
		case "HXBC":
			if(type.equals("gfb")){
				title = HXBCTitle;
				limit = HXBCLimit;
				id = "bankhxbc1";
			}else {
				title = HXBCTitle1;
				limit = HXBCLimit1;
				id = "bankhxbc7";
			}
			break;
		case "CIB":
			if(type.equals("gfb")){
				title = CIBTitle;
				limit = CIBLimit;
				id = "bankcib1";
			}else {
				title = CIBTitle1;
				limit = CIBLimit1;
				id = "bankcib7";
			}
			break;
		case "CEB":
			if(type.equals("gfb")){
				title = CEBTitle;
				limit = CEBLimit;
				id = "bankceb1";
			}else {
				title = CEBTitle1;
				limit = CEBLimit1;
				id = "bankceb7";
			}
			break;
		case "PSBC":
			if(type.equals("gfb")){
				title = PSBCTitle;
				limit = PSBCLimit;
				id = "bankpsbc1";
			}else {
				title = PSBCTitle1;
				limit = PSBCLimit1;
				id = "bankpsbc7";
			}
			break;
		case "CITIC":
			if(type.equals("gfb")){
				title = CITICTitle;
				limit = CITICLimit;
				id = "bankcitic1";
			}else {
				title = CITICTitle1;
				limit = CITICLimit1;
				id = "bankcitic7";
			}
			break;
		case "CMBC":
			if(type.equals("gfb")){
				title = CMBCTitle;
				limit = CMBCLimit;
				id = "bankcmbc1";
			}else{
				title = CMBCTitle1;
				limit = CMBCLimit1;
				id = "bankcmbc7";
			}
			break;
		case "BOC":
			if(type.equals("gfb")){
				title = BOCTitle;
				limit = BOCLimit;
				id = "bankboc1";
			}else{
				title = BOCTitle1;
				limit = BOCLimit1;
				id = "bankboc7";
			}
			break;
		default:
			break;
		}
		boolean result = true;
		List<WebElement> titleList = base.getElements(By.cssSelector("#"+id+">.new th"));
		for (int i = 0; i < title.length; i++) {
			try {
				base.assertEqualsActualExpected(titleList.get(i).getText(), title[i]);
			} catch (AssertionError e) {
				result = false;
				System.out.println(bank+",title,"+(i+1)+"ʧ�ܣ����Σ�"+title[i]+",ʵ�ʣ�"+titleList.get(i).getText());
				Reporter.log(bank+",title,"+(i+1)+"ʧ�ܣ����Σ�"+title[i]+",ʵ�ʣ�"+titleList.get(i).getText()+"</br>");
			}
		}
		List<WebElement> limitList = base.getElements(By.cssSelector("#"+id+">.new td"));
		for (int i = 0; i < limit.length; i++) {
			try {
				base.assertEqualsActualExpected(limitList.get(i).getText(), limit[i]);
			} catch (AssertionError e) {
				result = false;
				System.out.println(bank+",limit,"+(i+1)+"ʧ�ܣ����Σ�"+limit[i]+",ʵ�ʣ�"+limitList.get(i).getText());
				Reporter.log(bank+",limit,"+(i+1)+"ʧ�ܣ����Σ�"+limit[i]+",ʵ�ʣ�"+limitList.get(i).getText());
			}
		}
		return result;
	}
	
	/**
	 * У����ʾ���г�ֵ
	 * @param money
	 * @author ������ 2015-9-2
	 */
	public void checkPromptMsgOfBank(String money){
		//��ֵ���
		base.clickWithWait(rechargeTxt);
		base.elementSendkeyNoClear(rechargeTxt, money);
		base.clickWithWait(rechargeCyberBtn);
		base.checkAlert();
		String actual = base.getTextByAlert();
		try {
			base.assertEqualsActualExpected(actual, "��ѡ�����߳�ֵ��ʽ��");
		} catch (Exception e) {
			Reporter.log("δѡ���У������Ӧ��ʾ������ѡ�����߳�ֵ��ʽ����������ʾ:��" + actual + "��");
			System.out.println("δѡ���У������Ӧ��ʾ������ѡ�����߳�ֵ��ʽ����������ʾ:��" + actual + "��");
		}
		finally{		
			base.sleep(1000);
			base.acceptAlert();
		}
	}
	
	/**
	 * У����ʾ����ֵ
	 * @author ������ 2015-9-2
	 */
	public void checkPromptMsgOfMoney(){
		//ѡ��������
		base.clickWithWait(jianSheNank);
		base.clickWithWait(rechargeCyberBtn);
		base.sleep(3000);
		String actual = base.getTextByAlert();
		base.assertEqualsActualExpected(actual, "��������Ҫ��ֵ�Ľ�");
		base.acceptAlert();
	}
	
	/**
	 * У���д���
	 * @param money
	 * @author ������ 2015-9-2
	 */
	public void checkCapitalOfMoney(String money){
		//ѡ��������
		base.clickWithWait(jianSheNank);
		//��ֵ���
		base.clickWithWait(rechargeTxt);
		base.elementSendkeyNoClear(rechargeTxt, money);
		String capital = base.getElementTextWithWait(By.cssSelector("#withdraw_zh_balance"));
		base.assertEqualsActualExpected(capital, "Ҽ��");
	}
	
	/**
	 * У���������ҳ��
	 * @author ������ 2015-9-2
	 */
	public void checkBankPage(){
		String parentWindowHandle = base.getCurrentWindowHandle();
		base.clickWithWait(rechargeCyberBtn);
		base.sleep(2000);
		String childWindowHandle = base.getChildWindowHandle(parentWindowHandle);
		base.jumpToWindow(childWindowHandle);
		base.sleep(2000);//������ת���ױ�֧��������ת���й��������С��ױ�֧��ҳ���ȡ����
		boolean isTitleOK = base.checkTitleContains("�й���������");
		base.closeAndjumptoOldWindow();
		//��ܰ��ʾDIV
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(By.cssSelector("#paytip"), "style", "block"), true);
		//���������ɳ�ֵ��
		base.clickWithWait(By.cssSelector(".btn-fc.btn-cp"));
		String actual = base.getTextByAlert();
		base.assertEqualsActualExpected(actual, "��ֵδ�ɹ���δ���,����ɳ�ֵ!");
		base.acceptAlert();
		base.assertTrueByBoolean(isTitleOK);
	}
	
	/**
	 * ����Ԫ
	 * ��֤���뽨�����н���
	 */
	public void isJianShePage(){
		jianSheHandel = base.getChildWindowHandle(rechargeHandel);
		base.jumpToWindow(jianSheHandel);
		System.out.println("1:"+rechargeHandel+"\n2:"+jianSheHandel);
//		base.assertEqualsActualExpected(base.getPageTitle(), "�й��������_��������");
		boolean titleResult = base.checkTitleContains("�й��������� ������������");
		base.closeWindow(jianSheHandel);
		//�ص���ֵҳ  �ص���ܰ��ʾ����
		base.jumpToWindow(rechargeHandel);
		base.sleep(2000);
		base.clickWithWait(promptCloseBtn);
		base.assertTrueByBoolean(titleResult);//�й��������_��������
	}
}
