package com.eloancn.shared.pages;

import java.io.File;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.common.VerifyMethod;
/*
 * ��̳ҳ
 */
public class ForumPage {
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	VerifyMethod verifyMethod = new VerifyMethod();
	public String uname = Data.tel;
	
	String currentHandel;
	String newHandel;
	
	//logo
	By logoImg = By.xpath("//img[@alt='��������̳']");
	//�ǳ�
	By unameTxt = By.xpath("//*[@id='uname']");
	//������ǳơ���ť
	By addUnameBtn = By.xpath("//input[@type='image']");
	
	/**
	 * ����Ԫ
	 * �ж��Ƿ���ת����̳����
	 */
	public void isForum(){
		currentHandel = base.getCurrentWindowHandle();
		newHandel = base.getChildWindowHandle(currentHandel);
    	base.jumpToWindow(newHandel);
    	//base.assertTrueByBoolean(base.getPageTitle().contains("����������̳�� - ������"));
    	verifyMethod.verifyTrue(base.checkTitleContains(PageTitles.lunTan));//����������̳�� - ������
	}
	
	/**
	 * ����Ԫ
	 * �ص���̳ҳ���ص��ϸ�����
	 */
	public void closeForumTrunBeforePage(){
		base.closeWindow(newHandel);
		base.jumpToWindow(currentHandel);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println("ok...");
	}
	
	/**
	 * ����Ԫ
	 * ���logo 
	 */
	public void clickLogo(){
//		//��ҳ�������̳��
//		indexPage.goToForm();
//		//��ת����̳ҳ
//		base.turnToNewPage();
//		//�ж��Ƿ����ǳ�
//		isHaveUname();
		//���logo
		base.clickWithWait(logoImg);
	}
	
	/**
	 * ����Ԫ
	 * �ж��Ƿ����ǳ�
	 */
	public void isHaveUname(){
		try {
			Alert alert = base.getAlert();
			alert.accept();
			base.sendKeysWithWait(unameTxt, uname);
			Thread.sleep(3000);
			//base.clickWithWait(By.xpath("//tr[4]/td/input"));//addUnameBtn
			Screen screen = new Screen();
			Pattern addNameBtn = new Pattern(new File("").getAbsolutePath()+"\\images\\addname.png");
			try {
				base.sleep(2000);
				screen.click(addNameBtn);
				Thread.sleep(2000);
				screen.click(addNameBtn);
			} catch (FindFailed e) {
				e.printStackTrace();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			//�����ǳ�
		}
	}
	
	/**
	 * ����Ԫ
	 * ��̳�����¼
	 */
	public void forumClickLogin(){
		base.clickWithWait(By.xpath("//button[text()='��¼']"));
		base.sleep(2000);
	}
}
