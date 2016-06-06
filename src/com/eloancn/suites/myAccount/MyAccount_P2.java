package com.eloancn.suites.myAccount;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.AccountInfoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyRewardPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.SecurityAuthPage;

/**
 * “我的账户”P2用例
 * @author 江渤洋
 */
public class MyAccount_P2 {
	
	Base base = new Base();
	DBData dbData = new DBData();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	RechargePage rechargePage = new RechargePage();
	IndexPage indexPage = new IndexPage();
	MyRewardPage myRewardPage = new MyRewardPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	
	String MyAccountUrl = base.indexURL + "/page/userMgr/myHome.jsp";
	String tel;
	String email;
	String pass;
	String money ="0.01";
	String newTel;
	String oldTel;
	String changeTel;
	String noChangeTel;
	
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			tel = Data.tel_run_EcunBao;
			pass = Data.zzmm;
			email = Data.email_MyAccountP2;
			newTel = Data.client_tel_new;
			oldTel = Data.client_tel_old;
			changeTel = Data.tel_change;
			noChangeTel = Data.tel_noChange;
		}
		else if (base.indexURL.contains("test") || base.indexURL.contains("www")){
			tel = Data.test_myAccount_P2_tel;
			pass = Data.zzmm;
			email = Data.test_run_ECunBao_oldemail;
			newTel = Data.test_run_ECunBao_register;
			oldTel = Data.test_run_ECunBao_oldtel;
		}
	}

	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * 验证充值方式，1-转账汇款
	 * @author 江渤洋
	 */
	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void checkOnlineRechargeNoticeInfomation_web_319(){
		
		Reporter.log("我的账户_P2：我的账户——>充值——>验证充值方式，1-线上充值<br/>");
		System.out.println("我的账户_P2：我的账户——>充值——>验证充值方式，1-线上充值");
		
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(tel, pass);
		//进入充值页面
		myAccountPage.turnToMyAccount("充值");
		//判断是否跳转至充值界面
//		myAccountPage.isGoMyAccount("充值");	
		//校验提示银行充值
		rechargePage.checkPromptMsgOfBank(money);
		myAccountPage.turnToMyAccount("充值");
		//校验提示金额充值
		rechargePage.checkPromptMsgOfMoney();
		myAccountPage.turnToMyAccount("充值");
		//校验大写金额
		rechargePage.checkCapitalOfMoney(money);
		//校验进入银行页面
		rechargePage.checkBankPage();
	}
	
	/**
	 * 验证充值方式，2-转账汇款-重置按钮
	 * 备注：改功能已下线
	 * @author 江渤洋
	 */
	@Test(priority = 2, enabled = false)
	public void checkTransferRemittanceByReset_web_320(){
		
		Reporter.log("我的账户_P2：我的账户——>充值——>验证充值方式，2-转账汇款-重置按钮<br/>");
		System.out.println("我的账户_P2：我的账户——>充值——>验证充值方式，2-转账汇款-重置按钮");
		
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(tel, pass);
		myAccountPage.turnToMyAccount("充值");
		//判断是否跳转至充值界面
		myAccountPage.isGoMyAccount("充值");	
		rechargePage.rechargeTransferRemittance("2015-05-01","10","中国银行","3333","自动化测试，请拒！谢谢");
		rechargePage.checkResetByTransferRemittance();
	}
	
	/**
	 * 验证提现，添加银行卡链接及页面显示
	 * @author 江渤洋
	 */
	@Test(priority = 3, enabled = true)
	public void checkAddBankByShow_web_530(){
		
		Reporter.log("我的账户_P2：我的账户——>提现——>验证添加银行卡，链接及页面显示<br/>");
		System.out.println("我的账户_P2：我的账户——>提现——>验证添加银行卡，链接及页面显示");
		
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(tel, pass);
		myAccountPage.turnToMyAccount("安全认证");
		myAccountPage.isGoMyAccount("安全认证");
		//点击 银行卡管理
		securityAuthPage.clickBankManage();
		base.isElementVisible(securityAuthPage.addBackDiv);
		//校验页面显示
		securityAuthPage.checkAddBankPageByShow();
	}
	
	/**
	 * 验证提现，添加银行卡链接及页面显示
	 * @author 江渤洋
	 */
	@Test(priority = 4, enabled = true)
	public void checkPhoneNumber_web_74(){
		
		Reporter.log("我的账户_P2：我的账户——>我的借入——>申请借款——>四步流程输入框——>验证手机号<br/>");
		System.out.println("我的账户_P2：我的账户——>我的借入——>申请借款——>四步流程输入框——>验证手机号");
		
		if(!base.indexURL.contains("/client") && !base.indexURL.contains("inclient")){
			Reporter.log("非集成/本地环境，请手动测试！<br/>");
			System.out.println("非集成/本地环境，请手动测试！");
			base.assertTrueByBoolean(false);
		}
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(email, pass);
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.clickQualification();
		String temp = base.getElementTextWithWait(By.cssSelector(".certifitit>label"));
		if(temp.equals("身份证认证")){
			myAccountPage.deletePhoneRegeditRecords(email);
		}
		myAccountPage.checkPhoneNoticeInformation();
		myAccountPage.deletePhoneRegeditRecords(email);
		base.logout();
	}

	
	@DataProvider(name="user")
	public Object[][] Users(){
		return new Object[][]{
			{newTel, pass},       //新手机注册用户
//			{oldTel, pass},       //老手机注册用户
			{email, pass}         //老邮箱注册用户
		};
	}
	
	/**
	 * 验证注册后，从账户信息中输入姓名的提示信息
	 * @author 江渤洋
	 */
	@Test(priority = 5, dataProvider="user")
	public void checkNameNoticeInfomation_web_37(String name, String pass){
		
		Reporter.log("我的账户_P2：我的账户——>账户信息——>修改信息——>验证输入姓名的提示信息<br/>");
		System.out.println("我的账户_P2：我的账户——>账户信息——>修改信息——>验证输入姓名的提示信息");
		
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(name, pass);
		myAccountPage.turnToMyAccount("账户信息");
		myAccountPage.isGoMyAccount("账户信息");
		accountInfoPage.clickUpdateInfoBtn();
		//输入姓名，并验证输入是否正确
		myAccountPage.checkNameNoticeInformation(accountInfoPage.nameMsg, accountInfoPage.nameCheckmarkImg);
		base.logout();
		indexPage.clickLoginLink();
	}
	
	/**
	 * 验证注册后，从账户信息中输入邮箱的提示信息
	 * @author 江渤洋
	 */
	@Test(priority = 6)
	public void checkEmailNoticeInfomation_web_41(){
		
		Reporter.log("我的账户_P2：我的账户——>账户信息——>修改信息——>验证输入邮箱的提示信息<br/>");
		System.out.println("我的账户_P2：我的账户——>账户信息——>修改信息——>验证输入邮箱的提示信息");
		
		base.openBrowser(MyAccountUrl);
		loginPage.logoutByMyAccount();
		loginPage.loginByMyAccount(newTel, pass);
		myAccountPage.turnToMyAccount("账户信息");
		accountInfoPage.clickUpdateInfoBtn();
		//输入邮箱，并验证输入是否正确
		myAccountPage.checkEmailNoticeInformatin();
		base.logout();
	}
	
	/**
	 * 验证注册后，从账户信息中输入邮箱的提示信息       --------------------未修改
	 * @author 江渤洋
	 */
	@Test(priority = 7)
	public void changePhoneNumber_web_1230(){
		
		Reporter.log("我的账户_P2：我的账户——>账户信息——>修改信息——>验证输入邮箱的提示信息<br/>");//--------------------未修改
		System.out.println("我的账户_P2：我的账户——>账户信息——>修改信息——>验证输入邮箱的提示信息");
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			int num;
			String uid,phone;
			uid = dbData.getUID("fangwenshan3@163.com");
			phone = dbData.getPhoneNum("fangwenshan3@163.com");
			System.out.println("手机号为：" + phone);
			num = dbData.selectMobileChangeNum(uid);
			if (num != 2){
				dbData.deleteMobileChangeInfos(uid);
			}
			base.openBrowser(MyAccountUrl);
			loginPage.logoutByMyAccount();
			if(phone.equals(noChangeTel)){
				loginPage.loginByMyAccount(noChangeTel, pass);
				//进入充值页面
				myAccountPage.turnToMyAccount("安全认证");
				myAccountPage.checkChangeTel(noChangeTel, changeTel, pass);
				base.sleep(30000);
				myAccountPage.turnToMyAccount("安全认证");
				myAccountPage.checkChangeTel(changeTel, noChangeTel, pass);
			}
			else{
				loginPage.loginByMyAccount(changeTel, pass);
				//进入充值页面
				myAccountPage.turnToMyAccount("安全认证");
				myAccountPage.checkChangeTel(changeTel, noChangeTel, pass);
				base.sleep(30000);
				myAccountPage.turnToMyAccount("安全认证");
				myAccountPage.checkChangeTel(noChangeTel, changeTel, pass);
			}
			System.out.println(uid);
			//查询是否有两条记录
			num = dbData.selectMobileChangeNum(uid);
			//删除表中数据
			boolean isTrue = dbData.deleteMobileChangeInfos(uid);
			try {
				base.assertEqualsActualExpectedByBoolean(isTrue, true);
			} catch (AssertionError e) {
				Reporter.log("删除'd_mobile_changehistory'表中的数据报错，可能是没有删除权限或其他原因");
				System.out.println("删除'd_mobile_changehistory'表中的数据报错，可能是没有删除权限或其他原因");
			}
			base.logout();
			
			try {
				base.assertEqualsActualExpectedByInt(num, 2);
			} catch (AssertionError e) {
				Reporter.log("'d_mobile_changehistory'表中的数据为：" + num + "条，可能是上次误操作，或本次存储错误！ ");
				System.out.println("'d_mobile_changehistory'表中的数据为：" + num + "条，可能是上次误操作，或本次存储错误！ ");
			}
		}
		else{
			Reporter.log("非集成/本地环境，请手动测试！<br/>");
			System.out.println("非集成/本地环境，请手动测试！");
		}
	}
	
}
