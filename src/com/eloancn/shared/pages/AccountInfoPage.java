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
 * “我的账户”-“账户信息”页面
 */
public class AccountInfoPage {
	Base base = new Base();
	
	public static By AccountInfoTxt = By.cssSelector("div.newtitle.notice>h3");
	public static By UserNameTxt = By.id("orealname");
	
	By NoticeInfoTxt = By.id("goshow");										 //注意信息
	By updateInfoBtn = By.id("editInfobtn"); 								 //“修改信息”按钮
	By FourTxt = By.xpath("//div[@id='showUserInfo']/div/p[*]/label");
	By realNameTxt = By.id("prealname");	 								 //姓名
	By idCardTxt = By.id("pidcard");		 								 //身份证号
	By telTxt = By.id("pmobile");			 								 //手机号
	By emailTxt = By.id("pemail");			 								 //邮箱   //By.xpath("//input[@id='pemail']");//By.cssSelector("#pemail");
	By submitBtn = By.xpath("//input[@value='确认']");                        //确认
	By telphoneTxt = By.id("omobile");                  					 //显示认证的手机号
	public static By photoPic = By.id("smallPhoto");	 					 //头像
	//上传头像弹出框页面
	By ImgPopupBox = By.id("upload_before_2");								 //上传头像弹出框
	By UploadImgTip = By.xpath("//div[@id='upload_before_2']/h3");			 //提示语、选择头像按钮、X按钮
	By CloseUploadLnk = By.xpath("//div[@id='upload_before_2']/h3/span"); 	 //"X"按钮
	
	By UpdatePhotoTxt = By.xpath("//div[@id='upload_before_1']/span[2]");	 //“上传修改头像”文本
	By selectPicBtn = By.id("fileField");									 //选择头像按钮
	By uploadBtn = By.id("upload_after_1");									 //上传确定按钮
	
	public By nameCheckmarkImg = By.cssSelector("#prealnametipMsg>img");     //姓名正确提示图片
	public By nameMsg = By.id("prealnametipMsg");                            //姓名错误提示信息
	public By emailMsg = By.xpath("//span[@id='pemailMsg']");                //邮箱错误提示信息  //By.id("#pemailMsg"); 
	public By emailCheckmarkImg = By.cssSelector("#pemailMsg>img");
	
	//点击“修改信息”按钮
	public void clickUpdateInfoBtn(){
		base.clickWithWait(updateInfoBtn);
	}
	
	//点击“确认”按钮
	public void clickOkBtn(){
		base.clickWithWait(submitBtn);
	}
	
	/**
	 * 徐天元
	 * 修改账户信息
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
	 * 徐天元
	 * 修改账户信息手机号
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
	 * 徐天元
	 * 修改账户信息邮箱
	 */
	public void updateEmailInfo(String email,String name,String idCard){
		base.clickWithWait(updateInfoBtn);
		base.sendKeysWithWait(emailTxt,email);
		//身份未认证成功
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
	 * 徐天元
	 * 修改成功
	 */
	public void isUpdateOK(String message){
		try {
			Alert alert = base.getAlert();
			base.assertEqualsActualExpected(alert.getText(), message);
			alert.accept();
			base.sleep(3000);
		} catch (Exception e) {
			base.assertTrueByBoolean(false);//失败
		}
	}
	
	/**
	 * 徐天元
	 * 点击修改信息按钮
	 */
	public void clickUpdateBtn(){
		base.clickWithWait(By.cssSelector("#editInfobtn"));
	}

	/**
	 * 徐天元
	 * 修改信息按钮隐藏
	 */
	public void updateBtnVisible(){
		base.checkNoElement(By.cssSelector("#editInfobtn"));
	}
	
	/**
	 * 徐天元
	 * 校验姓名、身份证号、手机号、邮箱是否可编辑
	 */
	public void isWrite(boolean nameResult,boolean idCardResult,boolean telResult,boolean emailResult){
		base.assertEqualsActualExpectedByBoolean(base.isReadonly(By.cssSelector("#prealname")), !nameResult);
		base.assertEqualsActualExpectedByBoolean(base.isReadonly(By.cssSelector("#pidcard")), !idCardResult);
		base.assertEqualsActualExpectedByBoolean(base.isReadonly(By.cssSelector("#pmobile")), !telResult);
		base.assertEqualsActualExpectedByBoolean(base.isReadonly(By.cssSelector("#pemail")), !emailResult);
	}
	
	/**
	 * 徐天元
	 * 修改账户信息某一值
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
	 * 校验修改账户信息提示
	 * //pidcardtipMsg  prealnametipMsg pmobileMsg #pemailMsg
	 * 徐天元
	 */
	public void isUpdateInfoOK(String msg,String type){
		if (msg.equals("ok")) {
			base.checkElementVisible(By.cssSelector("#"+type+"Msg>img")); 
		}else if (msg.endsWith("此邮箱地址已被使用！") || msg.endsWith("此手机号已经被注册过！")) {
			base.sendKeysWithWait(By.cssSelector("#prealname"),"啊啊");
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
	//点击账户信息头像区域
	public void clickUserPhoto(){
		base.clickWithWait(photoPic);
		base.checkElementVisible(ImgPopupBox);
		base.assertEqualsActualExpected(base.getElementTextWithWait(UploadImgTip), "×\n上传头像您可以上传JPG文件上传图片最大4M");
	}
	//点击上传头像的“X”按钮
	public void clickCloseUploadLnk(){
		base.clickWithWait(CloseUploadLnk);
		base.checkNoElement(ImgPopupBox);
	}
	//点击“选择头像”
	public void clickSelectPicBtn(){
		base.clickWithWait(selectPicBtn);
	}
	/**
	 * 徐天元
	 * 修改头像
	 */
	public void updatePhoto(){
		base.clickWithWait(photoPic);
		//base.clickWithWait(selectPicBtn);
		/*上传文件
		  * element,上传按钮 例  ("//input[@type='file']")
		  * filePath,文件路径，例 C:\\testContent.pdf 绝对路径
		 */
		String curPath = new File("").getAbsolutePath();//当前路径
		String filePath = curPath + "\\images\\das.jpg";
		System.out.println(filePath);
		base.sleep(3000);
		base.elementSendkeyNoClear(selectPicBtn, filePath); //ff
//		Screen screen = new Screen();
//		//选择头像
//		Pattern selectBtn =new Pattern(curPath + "\\images\\selectPic.png");
//		//文件名
//		Pattern forderBtn =new Pattern(curPath + "\\images\\wenjianming.png");
//		//打开
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
	 * 徐天元
	 * 是否我的账户-账户总览 头像也更新
	 */
	public void isMyAccountPhotoUpdate(){
		//获取账户信息中的图片URL
		new MyAccountPage().turnToMyAccount("账户信息");
		String photoUrl = base.getElementWithWait(photoPic).getAttribute("src");
		//获取账户总览中的图片URL
		new MyAccountPage().turnToMyAccount("账户总览");
		String accountPhotoUrl = base.getElementWithWait(By.cssSelector(".head>img")).getAttribute("src");
		//比较账户信息 账户总览中图片src中的图片名称是否一致
		base.assertEqualsActualExpected(getPhotoName(accountPhotoUrl), getPhotoName(photoUrl));
	}
	
	/**
	 * 从URL获取图像名称
	 * @param url
	 * @return
	 */
	public String getPhotoName(String url){
		return url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
	}
	
	/**
	 * 徐天元
	 * 用户信息是否正确  姓名 身份证 手机 邮箱
	 */
	public void isUserInfoOk(String list[]){
		base.sleep(2000);
		List<WebElement> lists = base.getElements(By.cssSelector(".user-infor.wd300>.mt15>span"));
		for (int i = 0; i < lists.size(); i++) {
			base.assertEqualsActualExpected(lists.get(i).getText(), list[i]);
		}
	}
	
	public void checkAccountInfoPage(){
		base.checkElmentText(MyAccountPage.SelectedLnk, "账户信息");
		base.assertEqualsActualExpected(base.getElementTextWithWait(UpdatePhotoTxt), "上传修改头像");
		base.assertTrueByBoolean(base.isElementVisible(photoPic));
		List<WebElement> four = base.getElements(FourTxt);
		String txt[] = {"* 姓名：","* 身份证号：","* 手机号：","* 邮箱："};
		for(int i=0;i<4;i++){
			base.assertEqualsActualExpected(four.get(i).getText(), txt[i]);
		}
		base.assertEqualsActualExpected(base.getLnkElementText(updateInfoBtn, "class"), "editBtn mt15");
		if(base.isBlock(NoticeInfoTxt)){
			base.checkElementVisible(NoticeInfoTxt);
			base.assertEqualsActualExpected(base.getElementText(NoticeInfoTxt), "注意：充值后个人身份信息将不能自行\n修改！\n如有疑问? 请联系我们：400-080-5055");
		}else{
			System.out.println("账号信息已不能修改！");
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
