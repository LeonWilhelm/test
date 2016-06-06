package com.eloancn.suites.index;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;

public class ECunBao_P1 {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	IndexPage indexPage = new IndexPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
	String tel = Data.tel_eCunBao_P1;
	String password = Data.password;
	String zzmm = Data.zzmm;
	double balance = 99;//账户余额
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_tel;
			password = Data.test_password;
			zzmm = Data.test_zzmm;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * 徐天元
	 * 首页已登录 投一笔 马上投资
	 */
	@Test(priority = 1)
	public void indexTouYiBi_web_928_2(){
		Reporter.log("翼存宝P1：首页已登录，投一笔、马上投资两个功能正常投资<br/>");
		//获取账户可用余额
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		try {
			balance = myAccountPage.getBalance();
		} catch (Exception e) {
		}
		
		base.openBrowser(base.indexURL);
		base.sleep(2000);
		//投一笔
		System.out.println("首页翼存宝：投一笔 操作");
		Reporter.log("首页翼存宝：投一笔 操作<br/>");
		eCunBaoPage.touYiBi("1",zzmm,0,balance);
		//马上投资
		System.out.println("首页翼存宝：马上投资 操作");
		Reporter.log("首页翼存宝：马上投资 操作<br/>");
		eCunBaoPage.maShangTouZi("1",zzmm,0,balance);
	}
	
	/**
	 * 徐天元
	 * 首页已登录  校验自动输入功能
	 */
	@Test(priority = 2)
	public void indexTouYiBiAutoInput_web_928_1(){
		Reporter.log("翼存宝P1：首页已登录，投一笔、马上投资两个功能自动输入 操作正常<br/>");
		base.logout();
		//获取账户可用余额
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		try {
			balance = myAccountPage.getBalance();
		} catch (Exception e) {
		}
				
		base.openBrowser(base.indexURL);
		//投一笔  自动输入
		System.out.println("首页翼存宝：投一笔 自动输入 操作");
		Reporter.log("首页翼存宝：投一笔 自动输入 操作<br/>");
		eCunBaoPage.touYiBi("0",zzmm,1,balance);
		//马上投资  自动输入
		System.out.println("首页翼存宝：马上投资 自动输入 操作");
		Reporter.log("首页翼存宝：马上投资 自动输入 操作<br/>");
		eCunBaoPage.maShangTouZi("0",zzmm,1,balance);
	}
	
	/**
	 * 徐天元
	 * 首页已登录  投一笔/马上投资 校验自动输入功能  账户99元  不足100
	 */
	@Test(priority = 3)
	public void indexTouYiBiAutoInputBalanceIn100_web_928_1(){
		Reporter.log("翼存宝P1：首页已登录  投一笔/马上投资 校验自动输入功能  账户99元  不足100,提示金额不足100，不能购买此产品<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			
		}else {
			base.logout();
			Reporter.log("首页投一笔/马上投资 校验自动输入功能  账户99元  不足100<br/>");
			balance = 99;
			tel = Data.run_ECunBao_99;
			base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(tel, password);
			base.openBrowser(base.indexURL);
			base.sleep(2000);
			//投一笔  自动输入
			eCunBaoPage.touYiBi("1",zzmm,1,balance);
			//马上投资  自动输入
			eCunBaoPage.maShangTouZi("1",zzmm,1,balance);
		}
	}
	
	/**
	 * 徐天元
	 * 首页已登录  投一笔/马上投资   账户99元  不足100
	 */
	@Test(priority = 4)
	public void indexTouYiBiBalanceIn100_web_928_4and5(){
		Reporter.log("翼存宝P1：首页已登录  投一笔/马上投资 ，账户99元  不足100，进行投资,提示您的余额不足<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			
		}else {
			base.logout();
			balance = 99;
			tel = Data.run_ECunBao_99;
			base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
			loginPage.loginWithNoFrame(tel, password);
			base.openBrowser(base.indexURL);
			//投一笔 
			eCunBaoPage.touYiBi("1",zzmm,0,balance);
			//马上投资  
			eCunBaoPage.maShangTouZi("1",zzmm,0,balance);
		}
	}
	
	/**
	 * 徐天元
	 * 未登录 点击 投一笔/马上投资  弹出提示
	 */
	@Test(priority = 5)
	public void indexTouYiBiNotLogin_web_926(){
		Reporter.log("翼存宝P1：首页未登录 点击 投一笔/马上投资  弹出提示<br/>");
		base.logout();
		//投一笔 
		eCunBaoPage.touYiBi("0",zzmm,0,balance);
		//马上投资
		eCunBaoPage.maShangTouZi("0",zzmm,0,balance);
	}
	
	/**
	 * 徐天元
	 * 首页投一笔 未充钱用户投资 新注册手机用户,直接点击去投资 提示 亲请先充值在投资
	 */
	@Test(priority = 6)
	public void indexTouYiBiTiShiChongZhiRegister_web_65_1(){
		Reporter.log("翼存宝P1：首页投一笔 未充钱用户投资 新注册手机用户,直接点击去投资 提示 亲请先充值在投资<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_register;
		}else {
			tel = Data.run_ECunBao_register;
		}
		Reporter.log("首页投一笔 未充钱用户投资 新注册手机用户,直接点击去投资 提示 亲请先充值在投资<br/>");
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		//投一笔 
		eCunBaoPage.touYiBi("0",zzmm,0,balance);
	}
	
	/**
	 * 徐天元
	 * 首页投一笔 未充钱用户投资 老手机用户,没充值过的,直接点击去投资  提示 亲请先充值在投资
	 */
	@Test(priority = 7)
	public void indexTouYiBiTiShiChongZhiOldTel_web_65_2(){
		Reporter.log("翼存宝P1：首页投一笔 未充钱用户投资 老手机用户,没充值过的,直接点击去投资  提示 亲请先充值在投资<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_oldtel;
		}else {
			tel = Data.run_ECunBao_oldtel;
		}
		Reporter.log("首页投一笔 未充钱用户投资 老手机用户,没充值过的,直接点击去投资<br/>");
		base.logout();
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		//投一笔 
		eCunBaoPage.touYiBi("0",zzmm,0,balance);
	}
	
	/**
	 * 徐天元
	 * 首页投一笔 未充钱用户投资 老邮箱用户,没充值过的,直接点击去投资  提示 亲请先充值在投资
	 */
	@Test(priority = 8)
	public void indexTouYiBiTiShiChongZhiOldEmail_web_65_3(){
		Reporter.log("翼存宝P1：首页投一笔 未充钱用户投资 老邮箱用户,没充值过的,直接点击去投资  提示 亲请先充值在投资<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_oldemail;
		}else {
			tel = Data.run_ECunBao_oldemail;
		}
		Reporter.log("首页投一笔 未充钱用户投资 老邮箱用户,没充值过的,直接点击去投资<br/>");
		base.logout();
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		//投一笔 
		eCunBaoPage.touYiBi("0",zzmm,0,balance);
	}
	
	/**
	 * 徐天元
	 * 首页马上投资 未充钱用户投资 新注册手机用户,直接点击去投资 提示 亲请先充值在投资
	 */
	@Test(priority = 9)
	public void indexMaShangTouZiTiShiChongZhiRegister_web_64_1(){
		Reporter.log("翼存宝P1：首页马上投资 未充钱用户投资 新注册手机用户,直接点击去投资 提示 亲请先充值在投资<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_register;
		}else {
			tel = Data.run_ECunBao_register;
		}
		Reporter.log("首页马上投资 未充钱用户投资 新注册手机用户,直接点击去投资 提示 亲请先充值在投资<br/>");
		base.logout();
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		//马上投资
		eCunBaoPage.maShangTouZi("0",zzmm,0,balance);
	}
	
	/**
	 * 徐天元
	 * 首页马上投资 未充钱用户投资 老手机用户,没充值过的,直接点击去投资
	 */
	@Test(priority = 10)
	public void indexMaShangTouZiTiShiChongZhiOldTel_web_64_2(){
		Reporter.log("翼存宝P1：首页马上投资 未充钱用户投资 老手机用户,没充值过的,直接点击去投资<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_oldtel;
		}else {
			tel = Data.run_ECunBao_oldtel;
		}
		Reporter.log("首页马上投资 未充钱用户投资 老手机用户,没充值过的,直接点击去投资<br/>");
		base.logout();
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		//马上投资
		eCunBaoPage.maShangTouZi("0",zzmm,0,balance);
	}
	
	/**
	 * 徐天元
	 * 首页马上投资 未充钱用户投资 老邮箱用户,没充值过的,直接点击去投资
	 */
	@Test(priority = 11)
	public void indexMaShangTouZiTiShiChongZhiOldEmail_web_64_3(){
		Reporter.log("翼存宝P1：首页马上投资 未充钱用户投资 老邮箱用户,没充值过的,直接点击去投资<br/>");
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_run_ECunBao_oldemail;
		}else {
			tel = Data.run_ECunBao_oldemail;
		}
		Reporter.log("首页马上投资 未充钱用户投资 老邮箱用户,没充值过的,直接点击去投资<br/>");
		base.logout();
		balance = 0;
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, password);
		base.openBrowser(base.indexURL);
		eCunBaoPage.maShangTouZi("0",zzmm,0,balance);
	}
}
