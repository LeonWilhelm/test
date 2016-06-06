package com.eloancn.shared.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.common.VerifyMethod;


/*
 	����		����				��׺		ʾ��
	�ı���	TextBox			txt		nameTxt
	�����б��	DropDownList	drop	nameDrop
	��ѡ��	CheckBox		chk		nameChk
	��ť		Button			btn		nameBtn
	ͼƬ                Image           img     nameImg

 */
/*
 * ע��ҳ
 */
public class RegisterPage {
	Base base = new Base();
	Data data = new Data();
	DBData dbData = new DBData();
	VerifyMethod verifyMethod = new VerifyMethod();
	BackPage backPage = new BackPage();
	
	String registerHandle = "";
	String idCardHandle = "";
	String code = "";
	
	//��ҪͶ��
//	By creditBtn = By.xpath("//a[text()='��ҪͶ��']");
	By creditBtn = By.xpath("//*[@id='registerinit']/p/a[1]");
	//��Ҫ���
//	By debitBtn = By.xpath("//a[text()='��Ҫ���']");
	By debitBtn = By.xpath("//*[@id='registerinit']/p/a[2]");
	/*************ע��***********/
	//�ֻ���
	By phoneTxt = By.cssSelector("#phone");
	//������ʾ��
//	By dlmm_sTxt = By.id("dlmm_s");
	By dlmm_sTxt = By.cssSelector("#dlmm_s");
	//����������
	By passwordTxt = By.cssSelector("#password");
	//��һ��
	By nextStepBtn = By.cssSelector(".btn");//xpath("//input[@value='��һ��']");
	//��֤��ͼƬ
	By yanZhengMaImg = By.xpath("//*[@id='yancode']/img");
	//��֤��
//	By ranCodeTxt = By.id("rancode");
	By ranCodeTxt = By.cssSelector("#rancode");
	/**********�ֻ���֤*********/
	//��ȡ������֤��
	By sendCodeBtn = By.cssSelector("#sendcode");
	//������֤��
	By mobileCodeTxt = By.id("mobileCode");
	//���ע��
	By submitBtn = By.id("registersubmit");
	//ע��ɹ�
	By registerOK = By.cssSelector("p.gx");//By.id("//p[text()='��ϲ����ע��ɹ���']")
	//��Ҫ���>>>>>>>>>>>>>>>>>>
	//ͨ����Ӫ�̽���û�
	By operatorDebiterBtn = By.cssSelector("#jiekuan>a");////a[text()='ͨ����Ӫ�̽���û�']
	//��Ҫ����>>>>>>>>>>>>>>>>>>
	//ȥ��ֵ
	By rechargeBtn = By.xpath(".//*[@id='touzi']/a[1]");
	/*********�����֤***********/
	//��������ֻ���֤���������
	By telIdentificationOK = By.cssSelector(".stepnote.visible");
	//��ʵ����
	By realNameTxt = By.cssSelector("#realname");
	//���֤����
	By idCardTxt = By.cssSelector("#idcard");
	//�����֤��ť
	By idCardIdentificationBtn = By.cssSelector(".certifisub1");
	//��ֵ
	By Rechargelink = By.cssSelector(".g_secr_a2");
	//�����֤ȷ�ϰ�ť
	By idCardOK = By.cssSelector(".tipbuttok");
	/*************��д����*************/
	//������������֤���������
	By idCardIdentificationOK = By.cssSelector(".//*[@id='stepnote']/span");
	//����  ʡ
	By provinceSel = By.id("provinceid");
	//��
	By citySel = By.id("cityid");
	//��
	By countySel = By.id("countyid");
	//����
	By nativePlaceSel = By.id("nativePlace");
	//�־�ס�ص�ַ
	By addressTxt = By.id("address");
	//�����̶�
	By educationSel = By.xpath("//td[text()='�����̶ȣ�']/following-sibling::td//select");
	//ְҵ
	By workSel = By.xpath("//td[text()='ְҵ��']/following-sibling::td//select");
	//���ھ�ס��
	By addressSel = By.xpath("//td[text()='���ھ�ס�أ�']/following-sibling::td//select");
	//������
	By moneySel = By.xpath("//td[text()='�����룺']/following-sibling::td//select");
	//�ύ
	By infoSubmitBtn = By.id("personalmaterialok");
	/********������*********/
	//�������������д���������
	By writeInfoOK = By.cssSelector(".stepnote.visible");
	//a[text()='������Ϣ']
	//a[text()='������']    title:�������ҵ��˻�   //a[contains(@class,'cur')]  ������
	//a[text()='�������ǽ��']
	//�˳�
	By quitBtn = By.xpath("a[text()='�˳�']");////a[text()='�˳�'] //a[@href='/logout.jsp']

	/**
	 * ע��
	 * @param type credit����ҪͶ��  debit����Ҫ���
	 * @param tel
	 * @param password
	 */
	public String register(String type,String tel,String password){
		if (type.equals("debit")) {
			base.clickWithWait(debitBtn);
		}else {
			base.clickWithWait(creditBtn);
		}
		if (base.gethandelsNum()==2) {
			base.turnToNewPage();
		}
		base.sendKeysWithWait(phoneTxt, tel);
//		int i = 0;
//		do {
//			i++;
//			base.clickWithWait(dlmm_sTxt);
//		} while (base.checkVisible(dlmm_sTxt, 5) && i<3);
		base.setDisplayById("dlmm_s","none");
		base.setDisplayById("password","block");
		base.sendKeysWithWait(passwordTxt, password);
		//���ֻ����Ѿ���ע����������ֻ���
		if (base.checkVisible(By.cssSelector("#phoneErrorMsg"),3)) {
			Reporter.log(base.getElementTextWithWait(By.cssSelector("#phoneErrorMsg"))+"<br/>");
			if (base.getElementText(By.cssSelector("#phoneErrorMsg")).equals("���ֻ����Ѿ���ע�����")) {
				Reporter.log(tel+"���ֻ����Ѿ���ע�����"+"<br/>");
				System.out.println(tel+"���ֻ����Ѿ���ע�����");
				if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
					System.out.println("���ֻ�����ʹ��");
					base.assertTrueByBoolean(false);
				}else{
					tel = data.phoneConcatenation(0);
				}
				Reporter.log("ע���ֻ��Ÿ���Ϊ��"+tel+"<br/>");
				System.out.println("ע���ֻ��Ÿ���Ϊ��"+tel);
				base.sendKeysWithWait(phoneTxt, tel);
			}
		}
		String identifyingCode = data.get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
		base.sendKeysWithWait(ranCodeTxt,identifyingCode);
		onblur();
		//base.sleep(2000);
		//��֤�����
		if (base.checkVisible(By.cssSelector("#rancodeMsg"),3)) {
			if (base.getElementTextWithWait(By.cssSelector("#rancodeMsg")).equals("��֤�����")) {
				System.out.println(base.getElementTextWithWait(By.cssSelector("#rancodeMsg")).equals("��֤�����"));
				identifyingCode = data.get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
				base.sendKeysWithWait(ranCodeTxt,identifyingCode);
			}
		}
		onblur();
		base.clickWithWait(nextStepBtn);
		
		//��ȡ������֤��
		registerHandle = base.getCurrentWindowHandle();
		int j = 0;
		do {
			j++;
			inputPicCode();
		} while (base.isElementContainsValue(By.cssSelector("#rancode"), "class", "yzm") && j<3);
		System.out.println(tel);
		//��֤��
		String code = "";
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {//Ԥ���߻���
			//String registerHandel = base.getCurrentWindowHandle();
//			base.clickWithWait(By.cssSelector(".global.helper>a"));//Ϊ�˿���һ���µı�ǩҳ
			base.clickWithWait(By.cssSelector(".global.helper>a[href='http://bbs.eloancn.com']"));//Ϊ�˿���һ���µı�ǩҳ
			String BBSHandel = base.getChildWindowHandle(registerHandle);
			base.jumpToWindow(BBSHandel);
			code = backPage.getCode(tel,"SMS");
			base.closeOtherWindowHandle(registerHandle);
			base.jumpToWindow(registerHandle);
		}else {
			code = dbData.getPhoneCode(tel);
		}
		base.sendKeysWithWait(mobileCodeTxt, code);
		//base.setValueById("tfat",DESUtils.getEncryptString("99"));//�ƹ������֤
		base.sleep(2000);
		base.getElementWithWait(submitBtn).click();
		base.sleep(2000);
		return tel;
	}
	
	/**
	 * ����Ԫ
	 * ������֤�������ͼƬ��֤��
	 */
	public void inputPicCode(){
		base.clickWithWait(sendCodeBtn);
		base.sleep(1500);
		base.checkElementVisible(By.cssSelector("#out_all"));
		String code = data.get(base.getElementWithWait(By.cssSelector("#yancode>img")), base.webDriver);
		base.sendKeysWithWait(By.cssSelector("#rancode"), code);
		//base.sleep(2000);
		base.clickWithWait(By.cssSelector("input[value='��ȡ��֤��']"));
		base.sleep(5000);
	}
	
	/**
	 * ����Ԫ
	 * ���'�˳�'
	 */
	public void logout(){
		base.clickWithWait(quitBtn);
	}
	
	/**
	 * ����Ԫ
	 * �ж�ע��ɹ�
	 */
	public void isRegisterOK(){
		//base.assertNotNullBy(By.cssSelector(".gx"));//By.xpath("//span[text()='ע��ɹ�']"
		//verifyMethod.verifyTrue(base.getElementWithWait(By.cssSelector(".step3")).getAttribute("class").contains("st"));
		verifyMethod.verifyEquals("��ϲ����ע��ɹ���", base.getElementWithWait(registerOK).getText());
		base.checkElement(By.cssSelector("#jiekuan>a"));
	}
	
	/**
	 * ����Ԫ
	 * ���'ͨ����Ӫ�̽���û�'
	 */
	public void clickOperatorDebiterBtn(){
		base.clickWithWait(operatorDebiterBtn);
	}
	
	/**
	 * ����Ԫ
	 * �ֻ���֤���жϽ��������֤���棬���������֤����
	 */
	public void isDebitVerifyPage(){
		if (base.gethandelsNum() == 2) {
			base.turnToNewPage();
		}
		base.checkTitle(PageTitles.jieRuYanZheng);
		//��������ֻ���֤���������
		verifyMethod.verifyEquals("��������ֻ���֤���������", base.getElementText(telIdentificationOK));//By.xpath("//span[text()='��������ֻ���֤���������']")
		//���֤��֤����,1��������
		base.assertTrueByBoolean(base.getElementWithWait(By.cssSelector("#steps")).getAttribute("class").contains("step1"));
	}
	
	/**
	 * ����Ԫ
	 * �����֤
	 */
	public String[] idCardIdentification(String realName,String idCard){
		String info[] = {realName,idCard};
		idCardInfo(realName,idCard);
		//�����֤���Ѿ���ע�ᣡ   ��֤��������������֤�Ų�ƥ�䣡
		//Reporter.log("test�����������Data�Ľ�����ע�������test_register_credit_realName��test_register_credit_idCard");
		if (base.isElementPresent(By.cssSelector(".stepnote.visible")) && !base.getElementTextWithWait(By.cssSelector(".stepnote.visible")).equals("������������֤���������")) {
			Reporter.log(realName+","+idCard+base.getElementTextWithWait(By.cssSelector(".stepnote.visible"))+"<br/>");
			if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
				System.out.println("�����֤����ʹ��");
				base.assertTrueByBoolean(false);
			}else {
				info[1] = new Data().idConcatenation();
			}
			Reporter.log("������ϢΪ��"+info[0]+","+info[1]+"<br/>");
			idCardInfo(info[0],info[1]);
		}
		Reporter.log(info[0]+","+info[1]+base.getElementTextWithWait(By.cssSelector(".stepnote.visible"))+"<br/>");
		return info;
	}
	
	public void idCardInfo(String realName,String idCard){
		base.sendKeysWithWait(realNameTxt, realName);
		base.sendKeysWithWait(idCardTxt, idCard);
		base.clickWithWait(idCardIdentificationBtn);
		//base.getElementWithWait(idCardIdentificationBtn).submit();
		base.clickWithWait(idCardOK);
	}
	
	/**
	 * ����Ԫ
	 * �����֤���жϽ���������д����
	 */
	public void isInfoPage(){
		//String infoPageHandle = base.getChildWindowHandle(idCardHandle);
		//base.jumpToWindow(infoPageHandle);
		base.sleep(5000);
		//��������ֻ���֤���������
		//verifyMethod.verifyEquals("������������֤���������", base.getElementText(idCardIdentificationOK));//By.xpath("//span[text()='��������ֻ���֤���������']")
		base.assertNotNullBy(By.cssSelector(".step2"));
	}
	
	/**
	 * ����Ԫ
	 * ������д
	 */
	public void writeInfo(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		base.elementSelectByIndex(provinceSel, 1);
		base.elementSelectByIndex(citySel, 1);
		base.elementSelectByIndex(countySel, 1);
		base.elementSelectByIndex(nativePlaceSel, 3);
		base.elementSelectByIndex(provinceSel, 1);
		base.sendKeysWithWait(addressTxt, "������������ʵ����");
		base.elementSelectByIndex(educationSel, 1);
		base.elementSelectByIndex(workSel, 1);
		base.elementSelectByIndex(addressSel, 1);
		base.elementSelectByIndex(moneySel, 3);
		base.clickWithWait(infoSubmitBtn);
	}
	
	/**
	 * ����Ԫ
	 * �ж��Ƿ���뷢�������
	 */
	public void isSuingLoansPage(){
		verifyMethod.verifyEquals("�������������д���������", base.getElementText(writeInfoOK));
	}
	
	/**
	 * ����Ԫ
	 * �����ť���   ������Ϣ  ������  �������ǽ��
	 */
	public void suingLoansBtnClick(String name){
		base.clickWithWait(By.xpath("//a[text()='" + name + "']"));
		try {
			Thread.sleep(3000);
			Alert alert = base.getAlert();
			alert.accept();
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	/*****************Ͷ����******************/
	/**
	 * ����Ԫ
	 * ע���꣬�����ȥ��ֵ��
	 */
	public void clickRecharge(){
		base.clickWithWait(rechargeBtn);
		if (base.gethandelsNum()==2) {
			base.turnToNewPage();
		}
	}
	
	/******************************P1********************************/
	/**
	 * ����Ԫ
	 * ѡ���ɫ
	 */
	public void selectRole(String type){
		if (type.equals("��ҪͶ��")) {
			base.clickWithWait(By.xpath("//*[@id='registerinit']/p/a[1]"));
		}else {
			base.clickWithWait(By.xpath("//*[@id='registerinit']/p/a[2]"));
		}
		if (base.gethandelsNum()==2) {
			base.turnToNewPage();
		}
	}
	
	/**
	 * ����Ԫ
	 * ������ɫ
	 */
	public void updateRole(){
		base.clickWithWait(By.cssSelector("#checkregisterForm>p>a"));
	}
	
	/**
	 * ����Ԫ
	 * ������һ��ҳ��,��ʾ��ɫѡ��
	 */
	public void isUpdateRoleOK(){
		base.checkTitle(PageTitles.zhuCe);
		base.checkElement(By.cssSelector(".tzr>a:nth-child(1)"));
		base.checkElement(By.cssSelector(".tzr>a:nth-child(2)"));
	}
	
	/**
	 * ����Ԫ
	 * ����ƿ������   ģ��onblur�¼�  ����������˻���
	 */
	public void onblur(){
		base.clickWithWait(By.cssSelector(".xz.zh2"));
	}
	
	/**
	 * ����Ԫ
	 * �����ֻ���
	 */
	public void inputTel(String tel){
		base.sendKeysWithWait(By.cssSelector("#phone"), tel);
	}
	
	/**
	 * ����Ԫ
	 * У���ֻ���������ȷ
	 */
	public void isInputTelOK(){
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#phoneRightMsg")));
	}
	
	/**
	 * ����Ԫ
	 * У����ʾ��Ϣ�Ƿ���ȷ
	 * type:phoneError,�ֻ�;  password,����;  rancode,��֤��; #msgerror,������֤��
	 */
	public void isMsgOK(String type,String expectedMsg){
		if (type.equals("msgerror")) {//������֤��
			//base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#"+type)));
			base.checkElement(By.cssSelector("#"+type));
			//base.checkElement(By.xpath("//*[@id='"+type+"' and text()='"+expectedMsg+"']"));
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#"+type)), expectedMsg);
		}else {//#rancodeMsg  #passwordMsg  #phoneErrorMsg
			base.checkElement(By.cssSelector("#"+type+"Msg"));
			//base.checkElement(By.xpath("//*[@id='"+type+"Msg' and text()='"+expectedMsg+"']"));
			//base.assertTrueByBoolean(base.checkElement(By.cssSelector("#"+type+"Msg")));
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#"+type+"Msg")), expectedMsg);
		}
	}
	
	/**
	 * ����Ԫ
	 * ��������
	 */
	public void clickPassword(){
		base.clickWithWait(By.cssSelector("#dlmm_s"));
	}
	
	/**
	 * ����Ԫ
	 * �������룬�����ô˷������ȵ����ϱ߷������ֿ���������;
	 */
	public void inputPassword(String password){
		base.sendKeysWithWait(By.cssSelector("#password"), password);
	}
	
	/**
	 * ����Ԫ
	 * ������֤��
	 */
	public void inputRandcode(String type){
		String identifyingCode = "";
		if (!type.equals("refreshInputNew") && !type.equals("no")) {
			identifyingCode = data.get(base.getElementWithWait(By.cssSelector("#yancode>img")), base.getWebDriver());
		}
		if (type.equals("desc")) {//����
			identifyingCode = base.desc(identifyingCode);
		}
		if (type.contains("refresh")) {
			base.clickWithWait(By.cssSelector("#yancode>img"));//���ˢ�°�ť   .sx
		}
		if (type.equals("refreshInputNew")) {//���ˢ��  ��������֤��
			identifyingCode = data.get(base.getElementWithWait(By.cssSelector("#yancode>img")), base.getWebDriver());
		}
		if (type.equals("SBCCase")) {//ת����ȫ��
			identifyingCode = base.btoQ(identifyingCode.substring(0,4));
		}
		if (type.equals("no")) {//��������֤��
			identifyingCode = "";
		}
		base.sendKeysWithWait(By.cssSelector("#rancode"),identifyingCode);
	}
	
	/**
	 * ����Ԫ
	 * ��һ��
	 */
	public void clickNestStep(){
		base.clickWithWait(By.cssSelector(".btn"));
	}
	
	/**
	 * ����Ԫ
	 * �Ƿ������֤�ֻ�����  �Ϸ���������ʾ��֤�ֻ���ҳ��
	 */
	public void isTurnVerifyTelPage(){
		base.assertTrueByBoolean(base.isElementPresent(By.cssSelector(".step2.st")));
	}
	
	/**
	 * ����Ԫ
	 * ��д�˻���Ϣ
	 */
	public void setTelInfo(String tel,String password){
		//�����ֻ���
		inputTel(tel);
		//��������
		clickPassword();
		inputPassword(password);
		//������ȷ������֤��
		inputRandcode("");
		//��һ��
		clickNestStep();
	}
	
	/**
	 * ����Ԫ
	 * ������֤��
	 * type: other,�����ȡ������֤��,֮��,���޸��ֻ���Ϊ����δע����ֻ���,Ȼ��������֤��;otherTel,��Ŀǰ�ֻ���ΪA,δע���ֻ���ΪB,�޸��ֻ���ΪB,Ȼ���ȡ�ֻ���B����֤��,Ȼ���ٴ��޸��ֻ���ΪA,�����ֻ���B����֤��
	 */
	public void inputSMSCode(String tel,String type){
		String tel2 = data.phoneConcatenation(0);
		//��ȡ������֤��
		registerHandle = base.getCurrentWindowHandle();
		inputPicCode();
//		if (type.equals("first")) {//�Ⱥ��ȡ2����֤��,�յ��ڶ�����֤���Ժ�,�����һ����֤��
//			inputPicCode();
//		}
		if (type.contains("other")) {// other:�����ȡ������֤��,֮��,���޸��ֻ���Ϊ����δע����ֻ���,Ȼ��������֤��
			updateTel(tel2);
		}
		if (type.equals("otherTel")) {
			//inputPicCode();
			inputTel(tel);
			tel = tel2;//Ŀ�ģ���ȡtel2����֤��
		}
		//��֤��
		code = "";
		//��ȡ�ֻ���֤��
		code = getTelCode(tel);
		if (type.equals("first")) {//�Ⱥ��ȡ2����֤��,�յ��ڶ�����֤���Ժ�,�����һ����֤��
			base.sleep(62000);
			inputPicCode();
		}
		base.sleep(5000);
		base.sendKeysWithWait(mobileCodeTxt, code);
		base.clickWithWait(By.cssSelector("#registersubmit"));
	}
	
	public void inputSMSCodeByCode(String code,String type){
		switch (type) {
		case "SBCCase":
			//����ȫ����֤��
			code = base.btoQ(code);
			break;
		case "desc":
			//����������֤��
			code = base.desc(code);
			break;
		case "confuse":
			//����������֤��
			code = base.confuse(code);
			break;
		case "no":
			//����������֤��
			code = "";
			break;
		default:
			code = type;
			break;
		}
		base.sendKeysWithWait(mobileCodeTxt, code);
	}
	
	/**
	 * xty
	 * ��ȡ��֤��ĵȴ�ʱ����ʧ  ��ʾΪ��ȡ��֤��
	 */
	public void waiterGetCodeBtn(){
		base.checkElement(By.cssSelector("input[value='��ȡ������֤��']"),62000);
	}
	
	/**
	 * ����Ԫ
	 * �����ֻ���
	 */
	public void updateTel(String tel){
		base.clickWithWait(By.cssSelector("#changeMobile"));
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
//		String OtherTelhandel = base.getChildWindowHandle(registerHandle);
//		base.closeWindow(OtherTelhandel);
//		base.jumpToWindow(registerHandle);
		inputTel(tel);
	}
	
	/**
	 * ����Ԫ
	 * ��ȡ�ֻ���֤��
	 */
	public String getTelCode(String tel){
		String code = "";
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {//Ԥ���߻���
			String registerHandel = base.getCurrentWindowHandle();
			base.clickWithWait(By.cssSelector(".global.helper>a[href='http://bbs.eloancn.com']"));//Ϊ�˿���һ���µı�ǩҳ
			String BBSHandel = base.getChildWindowHandle(registerHandel);
			base.jumpToWindow(BBSHandel);
			code = backPage.getCode(tel,"SMS");
			base.closeOtherWindowHandle(registerHandel);
			base.jumpToWindow(registerHandel);
			//base.sleep(2000);
		}else {
			code = dbData.getPhoneCode(tel);
		}
		return code;
	}
	
	/**
	 * ����Ԫ
	 * ����У���� �����ע�ᡱ
	 */
	public void submit(){
		base.getElementWithWait(submitBtn).submit();
		//base.sleep(20000);
	}
	
	/**
	 * ����Ԫ
	 * ��֤�ֻ���ҳ��  ����������д��Ϣ
	 */
	public void goback(){
		base.clickWithWait(By.cssSelector(".wc>a"));
		if (base.gethandelsNum()==2) {
			base.turnToNewPage();
		}
		//base.sleep(2000);
	}
	
	/**
	 * ����Ԫ
	 * ��֤�ֻ���ҳ��  ���������������д��Ϣ��  ��֤������һ��ҳ��,��֤��ˢ��,��������
	 */
	public void isGoback(){
		base.assertTrueByBoolean(!base.isDisplayed(By.cssSelector(".step2.st")));
		base.assertTrueByBoolean(base.isDisplayed(By.cssSelector("#dlmm_s")));
		base.assertTrueByBoolean(!base.isBlock(By.cssSelector("#password")));
		String newCode = data.get(base.getElementWithWait(By.cssSelector("#yancode>img")), base.getWebDriver());
		base.assertNotEqualsActualExpected(code, newCode);
	}
	
	/**
	 * ����Ԫ
	 * �����������֤��  ��ʾУ��
	 */
	public void isNoSMSCodeMesOK(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//p[@class='ts'][2]")), "��֤��������˶ԣ�");
	}
	
	/**
	 * ����Ԫ
	 * ���ͨ��ע����Ϣ�������ע��  ��������������һ��ҳ��   
	 */
	public void isGoback404(){
		base.assertTrueByBoolean(base.checkTitleContains("����"));
		//base.assertTrueByBoolean(base.getElementTextWithWait(By.cssSelector("html>body>h1")).contains("404"));
	}
	
	/**
	 * ����Ԫ
	 * �Ƿ����ע��ҳ
	 */
	public void isTurnRegisterPage(){
		base.assertTrueByBoolean(base.checkTitleContains(PageTitles.zhuCe));
	}
	
	/**
	 * ���������ѡ��
	 * ����Ԫ
	 */
	public void clickYaoQingMa(){
		base.clickWithWait(By.cssSelector("#incodespan"));
	}
	
	/**
	 * ����Ԫ
	 * ����������
	 */
	public void inputYaoQingMa(String value){
		base.sendKeyAndWait(By.cssSelector("#refranchiseecode"), value);
		base.clickWithWait(By.cssSelector("#rancode"));
	}
	
	/**
	 * ����Ԫ
	 * ���������
	 */
	public void clearYaoQingMa(){
		base.getElementWithWait(By.cssSelector("#refranchiseecode")).clear();
	}
	
	/**
	 * ����Ԫ
	 * �����������ʾ  ����д��ȷ�������룬�޿ɲ��
	 */
	public void isYaoQingMaWrong(String msg){
		base.isElementContainsValue(By.cssSelector("#refranchiseecodeMsg"), "class", "zym");
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#refranchiseecodeMsg")), msg);
	}
	
	/**
	 * ����Ԫ
	 * ��������ȷ
	 */
	public void isYaoQingMaOK(){
		base.isElementContainsValue(By.cssSelector("#refranchiseecodeMsg"), "class", "zq");
	}
	
	/**
	 * ����Ԫ
	 * ���ͬ��������Э��
	 */
	public void clickAgree(){
		base.clickWithWait(By.cssSelector("#checkregisterForm>a"));
	}
	
	/**
	 * ����Ԫ
	 * ��ʾЭ��
	 */
	public void showAgree(){
		base.checkElementVisible(By.cssSelector("#to_agree"));
	}
	
	/**
	 * ����Ԫ
	 * �ر�Э��
	 */
	public void closeAgree(){
		base.clickWithWait(By.cssSelector(".tip_close.cpt"));
	}
	
	/**
	 * ����Ԫ
	 * ���ȡ��Э�鸴ѡ��
	 */
	public void cancleAgree(){
		base.clickWithWait(By.cssSelector("#agreebox"));
	}
	
	/**
	 * ����Ԫ
	 * ��ʾ��ѡͬ��Э��
	 */
	public void isAgreeWrong(){
		base.isElementContainsValue(By.cssSelector("#agreeMsg"), "class", "zym");
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#agreeMsg")), "�빴ѡͬ��������Э�飡");
	}
}
