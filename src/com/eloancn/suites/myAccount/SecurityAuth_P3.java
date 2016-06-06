package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.until.DESUtils;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.AccountInfoPage;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.EStarPlanListPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyLoanPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.RegisterPage;
import com.eloancn.shared.pages.SBInvestPage;
import com.eloancn.shared.pages.SecurityAuthPage;
import com.eloancn.shared.pages.WithDrawPage;

/**
 * 徐天元
 * 安全认证
 */
public class SecurityAuth_P3 {
	LoginPage loginPage = new LoginPage();
	RechargePage rechargePage = new RechargePage();
	Base base = new Base();
	Data data = new Data();
	MyLoanPage myLoanPage = new MyLoanPage();
	RegisterPage registerPage = new RegisterPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	IndexPage indexPage = new IndexPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	EStarPlanListPage eStarPlanListPage = new EStarPlanListPage();
	SBInvestPage sBInvestPage = new SBInvestPage();
	InvestmentListPage investmentListPage = new InvestmentListPage();
	WithDrawPage withDrawPage = new WithDrawPage();
	LoanApplicationPage LoanApplicationPage = new LoanApplicationPage();
	DBData dbData = new DBData();
	DESUtils desUtils = new DESUtils();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
	}

	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(priority = 1)
	public void checkRegisterStatus_web_1275_1(){
		Reporter.log("安全认证P2：新注册手机用户,后,去账户信息查看,姓名-空/身份证号码-空/手机号码-显示注册手机号码,显示前三位,后四位,中间用4个*显示/地点-空/邮箱-空,除手机号码外,其他为可编辑状态 安全中心当中,手机为已认证状态<br/>");
		//注册
		String tel = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel1;
		}else {
			tel = data.phoneConcatenation(0);
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
//		String tel = "15095663196";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("账户信息");
		//校验
		String list[] = {"","",tel.substring(0, 3)+"****"+tel.substring(7, 11),"---"};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.isWrite(true,true,false,true);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.isAuthentication("身份证号","未认证");
		securityAuthPage.isAuthentication("手机号","已认证");
	}
	
	@Test(priority = 2)
	public void checkRegisterStatus_web_1275_2(){
		Reporter.log("安全认证P2：新注册用户,完成充值页面提示的个人信息认证后,点击账户信息,姓名/身份证号码/显示已经认证,不可编辑状态/手机号码-空/现居住地-显示注册填写/邮箱-显示注册填写不可编辑状态    手机号码为可编辑状态<br/>");
		base.logout();
		//注册
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel2;
			realName = Data.test_run_SecurityAuth_P3_realName2;
			idCard = Data.test_run_SecurityAuth_P3_idCard2;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		String zzmm = Data.zzmm;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		String info[] = rechargePage.setInfo(realName,idCard,zzmm);
		realName = info[0];
		idCard = info[1];
//		String tel = "13757009155";
//		String realName = "邹海雪";
//		String idCard = "110112194004261174";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		myAccountPage.turnToMyAccount("账户信息");
		//校验
		tel = tel.substring(0, 3)+"****"+tel.substring(7, 11);
		idCard = idCard.substring(0,3)+"********"+idCard.substring(16,18).toLowerCase();
		String list[] = {realName,idCard,tel,"---"};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.isWrite(false,false,false,true);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.isAuthentication("身份证号","已认证");
		securityAuthPage.isAuthentication("手机号","已认证");
		securityAuthPage.isAuthentication("邮箱","未绑定");
		securityAuthPage.isAuthentication("支付密码","已设置");
	}
	
	@Test(priority = 3)
	public void checkRegisterStatus_web_1275_3(){
		Reporter.log("安全认证P2：新手机注册用户后,去安全认证中,进行邮箱认证,然后查看账户信息状态,姓名-空/身份证号码-空/手机号码-已认证/地点-空/邮箱-已认证,点击编辑后,除邮箱,手机号码都为可编辑状态<br/>");
		base.logout();
		//注册
		String tel = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel3;
		}else {
			tel = data.phoneConcatenation(0);
		}
		String password = Data.password;
		String email = data.emailConcatenation(3,2);
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.emailAuthentication(email);
		
//		String tel = "15895606240";
//		String email = "15895606240@qq.com";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");`
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("账户信息");
		//校验
		tel = tel.substring(0, 3)+"****"+tel.substring(7, 11);
		email = email.substring(0,2)+"****"+email.substring(email.indexOf("@"));
		String list[] = {"","",tel,email};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.isWrite(true,true,false,false);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.isAuthentication("身份证号","未认证");
		securityAuthPage.isAuthentication("手机号","已认证");
		securityAuthPage.isAuthentication("支付密码","未设置");
		securityAuthPage.isAuthentication("邮箱","已绑定");
	}
	
	@Test(priority = 4)
	public void checkRegisterStatus_web_1275_4(){
		Reporter.log("安全认证P2：新老手机用户,注册以后,全部认证过,查看账户信息,账户信息中,身份证,手机,邮箱,都为已认证状态不可修改<br/>");
		base.logout();
		//注册
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel4;
			realName = Data.test_run_SecurityAuth_P3_realName4;
			idCard = Data.test_run_SecurityAuth_P3_idCard4;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		String email = data.emailConcatenation(3,2);//tel+"@qq.com";
		String zzmm = Data.zzmm;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		String info[] = rechargePage.setInfo(realName,idCard,zzmm);
		realName = info[0];
		idCard = info[1];
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.emailAuthentication(email);
//		String tel = "15847123674";
//		String name = "邹海雪";
//		String email = "15895606240@qq.com";
//		String idCard = "110114198105070343";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("账户信息");
		//校验
		idCard = idCard.substring(0,3)+"********"+idCard.substring(16,18).toLowerCase();
		tel = tel.substring(0, 3)+"****"+tel.substring(7, 11);
		email = email.substring(0,2)+"****"+email.substring(email.indexOf("@"));
		String list[] = {realName,idCard,tel,email};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.updateBtnVisible();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.isAuthentication("身份证号","已认证");
		securityAuthPage.isAuthentication("手机号","已认证");
		securityAuthPage.isAuthentication("支付密码","已设置");
		securityAuthPage.isAuthentication("邮箱","已绑定");
	}
	
	@Test(priority = 5)
	public void checkRegisterStatus_web_1275_5(){
		Reporter.log("安全认证P2：新老手机用户,注册以后,安全中心认证身份证,查看账户信息,账户信息中姓名&身份证号码-已经认证/手机号-已认证/地点-空/邮箱-空/点击编辑按钮,邮箱为可编辑状态<br/>");
		base.logout();
		//注册
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel5;
			realName = Data.test_run_SecurityAuth_P3_realName5;
			idCard = Data.test_run_SecurityAuth_P3_idCard5;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.identityAuthentication(realName, idCard);
//		String tel = "15847123674";
//		String name = "邹海雪";
//		String email = "15895606240@qq.com";
//		String idCard = "110114198105070343";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		myAccountPage.turnToMyAccount("账户信息");
		//校验
		idCard = idCard.substring(0,3)+"********"+idCard.substring(16,18).toLowerCase();
		tel = tel.substring(0, 3)+"****"+tel.substring(7, 11);
		String list[] = {realName,idCard,tel,"---"};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.isWrite(false,false,false,true);
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.isAuthentication("身份证号","已认证");
		securityAuthPage.isAuthentication("手机号","已认证");
		securityAuthPage.isAuthentication("支付密码","未设置");
		securityAuthPage.isAuthentication("邮箱","未绑定");
	}
	
	@Test(priority = 6)
	public void checkRegisterStatus_web_1275_6(){
		Reporter.log("安全认证P2：新手机注册用户,注册以后,去账户信息填写信息,填写姓名,身份证号码,地点,邮箱后点击保存,去安全中心查看，安全中心中,身份证,邮箱,支付密码均未认证,手机已认证<br/>");
		base.logout();
		//注册
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel6;
			realName = Data.test_run_SecurityAuth_P3_realName6;
			idCard = Data.test_run_SecurityAuth_P3_idCard6;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		String email = data.emailConcatenation(3,2);
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("credit", tel, password);
		registerPage.clickRecharge();
		myAccountPage.turnToMyAccount("账户信息");
		accountInfoPage.updateInfo(realName,idCard,tel,email);
		accountInfoPage.isUpdateOK("保存成功!");
//		String tel = "15847123674";
//		String name = "邹海雪";
//		String email = "15895606240@qq.com";
//		String idCard = "110114198105070343";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		//校验
		idCard = idCard.substring(0,3)+"********"+idCard.substring(16,18).toLowerCase();
		tel = tel.substring(0, 3)+"****"+tel.substring(7, 11);
		email = email.substring(0,2)+"****"+email.substring(email.indexOf("@"));
		String list[] = {realName,idCard,tel,email};
		accountInfoPage.isUserInfoOk(list);
		accountInfoPage.clickUpdateBtn();
		accountInfoPage.isWrite(true,true,false,true);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.isAuthentication("身份证号","未认证");
		securityAuthPage.isAuthentication("手机号","已认证");
		securityAuthPage.isAuthentication("支付密码","未设置");
		securityAuthPage.isAuthentication("邮箱","未绑定");
	}
	
	@Test(priority = 7)
	public void checkCreditRechargePrompt_web_3532(){
		Reporter.log("安全认证P2：体验店用户,未进行身份认证，翼存宝投一笔 ，弹出提示框，提示亲 请先去充值，再投资！点击充值，跳转到充值界面<br/>");
		Reporter.log("安全认证P2：体验店用户,未进行身份认证，翼星计划 弹出提示框，提示亲 请先去充值，再投资！ 提示框里有个去充值！点击充值，跳转到充值界面<br/>");
		Reporter.log("安全认证P2：体验店用户,未进行身份认证，进入我的账户-我的贷出-散标投资-同城预投标 页面，点击操作列下的投标链接,点击借钱给他按钮,点击”去充值！“按钮,在”认证“窗口填写正确信息进行认证<br/>");
		base.logout();
		String tel = "13111111245";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel1;
		}
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, "111111");
		//翼存宝枪头 ，弹出提示框，提示亲 请先去充值，再投资！ 提示框里有个去充值！按钮
		base.openBrowser(base.indexURL+"/new/loadAllWmpsRecords.action");
		if (eCunBaoPage.clickCreditBtn()) {
			eCunBaoPage.promptRecharge();
			eCunBaoPage.goRecharge();
			base.checkContainsTitle(PageTitles.woDeZhangHu,10);
			myAccountPage.isGoMyAccount("充值");
		}
		//翼星计划 弹出提示框，提示亲 请先去充值，再投资！ 提示框里有个去充值！按钮
		base.openBrowser(base.indexURL+"/wut/loadAllWutRecords.action");
		if (eStarPlanListPage.ifshowBZStarInvestNowLnk()) {
			base.clickWithWait(eStarPlanListPage.BZStarInvestNowLnk);
			eStarPlanListPage.promptRecharge();
			eStarPlanListPage.goRecharge();
			base.checkContainsTitle(PageTitles.woDeZhangHu,10);
			myAccountPage.isGoMyAccount("充值");
		}
		if (base.indexURL.contains("/client") || base.indexURL.contains("inclient")) {
			//进入我的账户-我的贷出-散标投资-同城预投标 页面，点击操作列下的投标链接,点击借钱给他按钮,点击”去充值！“按钮,在”认证“窗口填写正确信息进行认证
			myAccountPage.turnToMyAccount("散标投资");
			sBInvestPage.clickBit();
			if (sBInvestPage.ifHasSameCityBit()) {
				base.turnToNewPage();
				investmentListPage.clickBorrow();
				investmentListPage.isShowRecharge();
				investmentListPage.clickRecharge();
				base.checkContainsTitle(PageTitles.woDeZhangHu,10);
				myAccountPage.isGoMyAccount("充值");
				rechargePage.checkShowUserInfoInput(false,false,true);
			}
		}
	}
}
