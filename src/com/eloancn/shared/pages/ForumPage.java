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
 * 论坛页
 */
public class ForumPage {
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	VerifyMethod verifyMethod = new VerifyMethod();
	public String uname = Data.tel;
	
	String currentHandel;
	String newHandel;
	
	//logo
	By logoImg = By.xpath("//img[@alt='翼龙贷论坛']");
	//昵称
	By unameTxt = By.xpath("//*[@id='uname']");
	//“添加昵称”按钮
	By addUnameBtn = By.xpath("//input[@type='image']");
	
	/**
	 * 徐天元
	 * 判断是否跳转至论坛界面
	 */
	public void isForum(){
		currentHandel = base.getCurrentWindowHandle();
		newHandel = base.getChildWindowHandle(currentHandel);
    	base.jumpToWindow(newHandel);
    	//base.assertTrueByBoolean(base.getPageTitle().contains("【翼龙贷论坛】 - 翼龙贷"));
    	verifyMethod.verifyTrue(base.checkTitleContains(PageTitles.lunTan));//【翼龙贷论坛】 - 翼龙贷
	}
	
	/**
	 * 徐天元
	 * 关掉论坛页，回到上个界面
	 */
	public void closeForumTrunBeforePage(){
		base.closeWindow(newHandel);
		base.jumpToWindow(currentHandel);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("ok...");
	}
	
	/**
	 * 徐天元
	 * 点击logo 
	 */
	public void clickLogo(){
//		//首页点击“论坛”
//		indexPage.goToForm();
//		//跳转至论坛页
//		base.turnToNewPage();
//		//判断是否有昵称
//		isHaveUname();
		//点击logo
		base.clickWithWait(logoImg);
	}
	
	/**
	 * 徐天元
	 * 判断是否有昵称
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
			//已有昵称
		}
	}
	
	/**
	 * 徐天元
	 * 论坛点击登录
	 */
	public void forumClickLogin(){
		base.clickWithWait(By.xpath("//button[text()='登录']"));
		base.sleep(2000);
	}
}
