package com.eloancn.shared.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
/*
 * ���ҵ��˻���-���˻���Ϣ��ҳ��
 */
public class AccountInfoPage {
	Base base = new Base();
	
	public static By AccountInfoTxt = By.cssSelector("div.newtitle.notice>h3");
	public static By UserNameTxt = By.id("orealname");
	
	By NoticeInfoTxt = By.id("goshow");										 //ע����Ϣ
	By updateInfoBtn = By.id("editInfobtn"); 								 //���޸���Ϣ����ť
	By FourTxt = By.xpath("//div[@id='showUserInfo']/div/p[*]/label");
	By realNameTxt = By.id("prealname");	 								 //����
	By idCardTxt = By.id("pidcard");		 								 //���֤��
	By telTxt = By.id("pmobile");			 								 //�ֻ���
	By emailTxt = By.id("pemail");			 								 //����   //By.xpath("//input[@id='pemail']");//By.cssSelector("#pemail");
	By submitBtn = By.xpath("//input[@value='ȷ��']");                        //ȷ��
	By telphoneTxt = By.id("omobile");                  					 //��ʾ��֤���ֻ���
	public static By photoPic = By.id("smallPhoto");	 					 //ͷ��
	//�ϴ�ͷ�񵯳���ҳ��
	By ImgPopupBox = By.id("upload_before_2");								 //�ϴ�ͷ�񵯳���
	By UploadImgTip = By.xpath("//div[@id='upload_before_2']/h3");			 //��ʾ�ѡ��ͷ��ť��X��ť
	By CloseUploadLnk = By.xpath("//div[@id='upload_before_2']/h3/span"); 	 //"X"��ť
	
	By UpdatePhotoTxt = By.xpath("//div[@id='upload_before_1']/span[2]");	 //���ϴ��޸�ͷ���ı�
	By selectPicBtn = By.id("fileField");									 //ѡ��ͷ��ť
	By uploadBtn = By.id("upload_after_1");									 //�ϴ�ȷ����ť
	
	public By nameCheckmarkImg = By.cssSelector("#prealnametipMsg>img");     //������ȷ��ʾͼƬ
	public By nameMsg = By.id("prealnametipMsg");                            //����������ʾ��Ϣ
	public By emailMsg = By.xpath("//span[@id='pemailMsg']");                //���������ʾ��Ϣ  //By.id("#pemailMsg"); 
	public By emailCheckmarkImg = By.cssSelector("#pemailMsg>img");
	
	//������޸���Ϣ����ť
	public void clickUpdateInfoBtn(){
		base.clickWithWait(updateInfoBtn);
	}
	
	//�����ȷ�ϡ���ť
	public void clickOkBtn(){
		base.clickWithWait(submitBtn);
	}
	
	/**
	 * ����Ԫ
	 * �޸��˻���Ϣ
	 */
	public void updateInfo(String realName,String idCard,String tel,String email){
		base.clickWithWait(updateInfoBtn);
		if (!base.isReadonly(realNameTxt)) {
			base.sendKeysWithWait(realNameTxt,realName);
		}
		if (!base.isReadonly(idCardTxt)) {
			base.sendKeysWithWait(idCardTxt,idCard);
		}
		if (!base.isReadonly(telTxt)) {
			base.sendKeysWithWait(telTxt,tel);
		}
		if (!base.isReadonly(emailTxt)) {
			base.sendKeysWithWait(emailTxt,email);
		}
		base.clickWithWait(submitBtn);
		try {
			Thread.sleep(2000);
			Alert alert = base.getAlert();
			alert.accept();
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	/**
	 * ����Ԫ
	 * �޸��˻���Ϣ�ֻ���
	 */
	public void updateTelInfo(String tel){
		base.sleep(3000);
		base.clickWithWait(updateInfoBtn);
		base.sleep(3000);
		base.sendKeysWithWait(telTxt,tel);
		base.clickWithWait(submitBtn);
		try {
			Thread.sleep(2000);
			Alert alert = base.getAlert();
			alert.accept();
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	/**
	 * ����Ԫ
	 * �޸��˻���Ϣ����
	 */
	public void updateEmailInfo(String email,String name,String idCard){
		base.clickWithWait(updateInfoBtn);
		base.sendKeysWithWait(emailTxt,email);
		//���δ��֤�ɹ�
		if(base.getElementWithWait(By.cssSelector("#prealname")).getAttribute("value").equals("")){
			base.sendKeysWithWait(By.cssSelector("#prealname"),name);
			base.sendKeysWithWait(By.cssSelector("#pidcard"),idCard);
		}
		base.clickWithWait(submitBtn);
		try {
			Thread.sleep(2000);
			Alert alert = base.getAlert();
			alert.accept();
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	/**
	 * ����Ԫ
	 * �޸ĳɹ�
	 */
	public void isUpdateOK(String message){
		try {
			Alert alert = base.getAlert();
			base.assertEqualsActualExpected(alert.getText(), message);
			alert.accept();
			base.sleep(3000);
		} catch (Exception e) {
			base.assertTrueByBoolean(false);//ʧ��
		}
	}
	
	/**
	 * ����Ԫ
	 * ����޸���Ϣ��ť
	 */
	public void clickUpdateBtn(){
		base.clickWithWait(By.cssSelector("#editInfobtn"));
	}

	/**
	 * ����Ԫ
	 * �޸���Ϣ��ť����
	 */
	public void updateBtnVisible(){
		base.checkNoElement(By.cssSelector("#editInfobtn"));
	}
	
	/**
	 * ����Ԫ
	 * У�����������֤�š��ֻ��š������Ƿ�ɱ༭
	 */
	public void isWrite(boolean nameResult,boolean idCardResult,boolean telResult,boolean emailResult){
		base.assertEqualsActualExpectedByBoolean(base.isReadonly(By.cssSelector("#prealname")), !nameResult);
		base.assertEqualsActualExpectedByBoolean(base.isReadonly(By.cssSelector("#pidcard")), !idCardResult);
		base.assertEqualsActualExpectedByBoolean(base.isReadonly(By.cssSelector("#pmobile")), !telResult);
		base.assertEqualsActualExpectedByBoolean(base.isReadonly(By.cssSelector("#pemail")), !emailResult);
	}
	
	/**
	 * ����Ԫ
	 * �޸��˻���Ϣĳһֵ
	 */
	public void updateInfo(String value,String type){
		switch (type) {
		case "email":
			base.sendKeysWithWait(emailTxt,value);
			break;
		case "idCard":
			base.sendKeysWithWait(By.cssSelector("#pidcard"),value);
			break;
		case "name":
			base.sendKeysWithWait(By.cssSelector("#prealname"),value);
			break;
		case "tel":
			base.sendKeysWithWait(By.cssSelector("#pmobile"),value);
			break;
		default:
			break;
		}
		base.clickWithWait(By.cssSelector(".bankLabel.wd100.textR.fl.ml10"));
	}
	
	/**
	 * У���޸��˻���Ϣ��ʾ
	 * //pidcardtipMsg  prealnametipMsg pmobileMsg #pemailMsg
	 * ����Ԫ
	 */
	public void isUpdateInfoOK(String msg,String type){
		if (msg.equals("ok")) {
			base.checkElementVisible(By.cssSelector("#"+type+"Msg>img")); 
		}else if (msg.endsWith("�������ַ�ѱ�ʹ�ã�") || msg.endsWith("���ֻ����Ѿ���ע�����")) {
			base.sendKeysWithWait(By.cssSelector("#prealname"),"����");
			base.sendKeysWithWait(By.cssSelector("#pidcard"),new Data().idConcatenation());
			base.clickWithWait(submitBtn);
			Alert alert = base.getAlertwithWait();
			alert.accept();
			alert = base.getAlertwithWait();
			base.assertEqualsActualExpected(alert.getText(), msg);
			alert.accept();
		}else {
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#"+type+"Msg")), msg);
		}
	}
	//����˻���Ϣͷ������
	public void clickUserPhoto(){
		base.clickWithWait(photoPic);
		base.checkElementVisible(ImgPopupBox);
		base.assertEqualsActualExpected(base.getElementTextWithWait(UploadImgTip), "��\n�ϴ�ͷ���������ϴ�JPG�ļ��ϴ�ͼƬ���4M");
	}
	//����ϴ�ͷ��ġ�X����ť
	public void clickCloseUploadLnk(){
		base.clickWithWait(CloseUploadLnk);
		base.checkNoElement(ImgPopupBox);
	}
	//�����ѡ��ͷ��
	public void clickSelectPicBtn(){
		base.clickWithWait(selectPicBtn);
	}
	/**
	 * ����Ԫ
	 * �޸�ͷ��
	 */
	public void updatePhoto(){
		base.clickWithWait(photoPic);
		//base.clickWithWait(selectPicBtn);
		/*�ϴ��ļ�
		  * element,�ϴ���ť ��  ("//input[@type='file']")
		  * filePath,�ļ�·������ C:\\testContent.pdf ����·��
		 */
		String curPath = new File("").getAbsolutePath();//��ǰ·��
		String filePath = curPath + "\\images\\das.jpg";
		System.out.println(filePath);
		base.sleep(3000);
		base.elementSendkeyNoClear(selectPicBtn, filePath); //ff
//		Screen screen = new Screen();
//		//ѡ��ͷ��
//		Pattern selectBtn =new Pattern(curPath + "\\images\\selectPic.png");
//		//�ļ���
//		Pattern forderBtn =new Pattern(curPath + "\\images\\wenjianming.png");
//		//��
//		Pattern openBtn =new Pattern(curPath + "\\images\\dakai.png");
//        try {
//			screen.doubleClick(selectBtn);
//			screen.type(forderBtn,filePath);
//			screen.click(openBtn);
//		} catch (FindFailed e1) {
//			e1.printStackTrace();
//		}
		base.clickWithWait(uploadBtn);
		base.sleep(5000);
	}
	
	/**
	 * ����Ԫ
	 * �Ƿ��ҵ��˻�-�˻����� ͷ��Ҳ����
	 */
	public void isMyAccountPhotoUpdate(){
		//��ȡ�˻���Ϣ�е�ͼƬURL
		new MyAccountPage().turnToMyAccount("�˻���Ϣ");
		String photoUrl = base.getElementWithWait(photoPic).getAttribute("src");
		//��ȡ�˻������е�ͼƬURL
		new MyAccountPage().turnToMyAccount("�˻�����");
		String accountPhotoUrl = base.getElementWithWait(By.cssSelector(".head>img")).getAttribute("src");
		//�Ƚ��˻���Ϣ �˻�������ͼƬsrc�е�ͼƬ�����Ƿ�һ��
		base.assertEqualsActualExpected(getPhotoName(accountPhotoUrl), getPhotoName(photoUrl));
	}
	
	/**
	 * ��URL��ȡͼ������
	 * @param url
	 * @return
	 */
	public String getPhotoName(String url){
		return url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
	}
	
	/**
	 * ����Ԫ
	 * �û���Ϣ�Ƿ���ȷ  ���� ���֤ �ֻ� ����
	 */
	public void isUserInfoOk(String list[]){
		base.sleep(2000);
		List<WebElement> lists = base.getElements(By.cssSelector(".user-infor.wd300>.mt15>span"));
		for (int i = 0; i < lists.size(); i++) {
			base.assertEqualsActualExpected(lists.get(i).getText(), list[i]);
		}
	}
	
	public void checkAccountInfoPage(){
		base.checkElmentText(MyAccountPage.SelectedLnk, "�˻���Ϣ");
		base.assertEqualsActualExpected(base.getElementTextWithWait(UpdatePhotoTxt), "�ϴ��޸�ͷ��");
		base.assertTrueByBoolean(base.isElementVisible(photoPic));
		List<WebElement> four = base.getElements(FourTxt);
		String txt[] = {"* ������","* ���֤�ţ�","* �ֻ��ţ�","* ���䣺"};
		for(int i=0;i<4;i++){
			base.assertEqualsActualExpected(four.get(i).getText(), txt[i]);
		}
		base.assertEqualsActualExpected(base.getLnkElementText(updateInfoBtn, "class"), "editBtn mt15");
		if(base.isBlock(NoticeInfoTxt)){
			base.checkElementVisible(NoticeInfoTxt);
			base.assertEqualsActualExpected(base.getElementText(NoticeInfoTxt), "ע�⣺��ֵ����������Ϣ����������\n�޸ģ�\n��������? ����ϵ���ǣ�400-080-5055");
		}else{
			System.out.println("�˺���Ϣ�Ѳ����޸ģ�");
		}
	}
	
	//
	public void checkDefaultImg(){
		String src = base.getLnkElementText(photoPic, "src");
		if(base.indexURL.contains("client")){
			base.assertEqualsActualExpected(src, base.indexURL+"/page/userMgr/images/userimgBig.png");
		}else if(base.indexURL.contains("test")){
			base.assertEqualsActualExpected(src, base.indexURL+"/page/userMgr/images/userimgBig.png");
		}else if(base.indexURL.contains("www")){
			base.assertEqualsActualExpected(src, base.indexURL+"/page/userMgr/images/userimgBig.png");
		}
	}
}
