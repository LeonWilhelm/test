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
public class SecurityAuth_P3_2 {
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
	public void checkDebitIdentityAuthentication_web_3536(){
		Reporter.log("安全认证P2：新用户借入认证身份认证,新用户注册成功，未进行身份认证<br/>");
		Reporter.log("安全认证P2：进入我的账户-我的借入-我的借款，点击申请额度按钮,跳转至借入者资格验证提示页面;点击资格验证,跳转至借款人资格验证，身份证认证步骤<br/>");
		Reporter.log("安全认证P2：进入我的账户-我的借入-我的借款，点击申请借款按钮,跳转至借入者资格验证提示页面;点击资格验证,跳转至借款人资格验证，身份证认证步骤<br/>");
		Reporter.log("安全认证P2：进入我的账户-我的账户-账户总览，点击下方我的借入的申请借款链接,跳转至借入者资格验证提示页面;点击资格验证,跳转至借款人资格验证，身份证认证步骤<br/>");
		Reporter.log("安全认证P2：进入我的账户-我的借入-申请借款,跳转至借入者资格验证提示页面;点击资格验证,跳转至借款人资格验证，身份证认证步骤;填写正确的身份信息进行认证,认证成功<br/>");
		base.logout();
		//注册
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel8;
			realName = Data.test_run_SecurityAuth_P3_realName8;
			idCard = Data.test_run_SecurityAuth_P3_idCard8;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("debit", tel, password);
		//进入我的账户-我的借入-我的借款，点击申请额度按钮
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("我的借款");
		myLoanPage.clickBtn("申请额度");
		checkDIA();
		//进入我的账户-我的借入-我的借款，点击申请借款按钮
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("我的借款");
		myLoanPage.clickLoanApplication();
		checkDIA();
		//进入我的账户-我的账户-账户总览，点击下方我的借入的申请借款链接
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.clickLoanApplicationLnk();
		checkDIA();
		//进入我的账户-我的借入-申请借款,跳转至借入者资格验证提示页面;点击资格验证,跳转至借款人资格验证，身份证认证步骤;填写正确的身份信息进行认证,认证成功
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("申请借款");
		checkDIA();
		String info[] = registerPage.idCardIdentification(realName,idCard);
		realName = info[0];
		idCard = info[1];
		Reporter.log("身份已认证:"+realName+","+idCard+","+tel+"<br/>");
		System.out.println("身份已认证:"+realName+","+idCard+","+tel);
		//进入资料填写界面
		registerPage.isInfoPage();
	}
	
	//校验借入资格认证
	public void checkDIA(){
		base.checkElmentText(LoanApplicationPage.VerifyAuthBtn, "资格验证");
		base.clickWithWait(LoanApplicationPage.VerifyAuthBtn);
		base.assertEqualsActualExpectedByInt(base.turnToTargetCloseOtherPage("借入验证"), 1);
		registerPage.isDebitVerifyPage();
	}
	
	@Test(priority = 2)
	public void checkRegisterIdentityAuthentication_web_3538(){
		Reporter.log("安全认证P2：新用户提现提示安全认证身份认证,新用户注册成功，不按引导走，到网站其他页面浏览<br/>");
		Reporter.log("安全认证P2：进入我的账户-我的账户-提现,提示认证，点击“去安全认证”按钮，跳转至“安全认证”页面，选择实名认证，点击“认证”，下方弹出“身份认证”相关页面<br/>");
		Reporter.log("安全认证P2：进入我的账户-我的账户-账户总览，把光标移至账户名旁边的“小人”，出现“去认证”链接，点击“去认证”，跳转至“安全认证”页面，选择实名认证，点击“认证”，下方弹出“身份认证”相关页面<br/>");
		Reporter.log("安全认证P2：进入我的账户-我的账户-账户总览，点击账户名一行后面的“提升”链接，跳转至“安全认证”页面，选择实名认证，点击“认证”，下方弹出“身份认证”相关页面<br/>");
		Reporter.log("安全认证P2：进入我的账户-账户设置-安全认证，选择实名认证，点击“认证”，下方弹出“身份认证”相关页面，填写正确的身份信息进行认证，认证成功<br/>");
		base.logout();
		//注册
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel9;
			realName = Data.test_run_SecurityAuth_P3_realName9;
			idCard = Data.test_run_SecurityAuth_P3_idCard9;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("debit", tel, password);
		//进入我的账户-我的账户-提现,提示认证，点击“去安全认证”按钮，跳转至“安全认证”页面，选择实名认证，点击“认证”，下方弹出“身份认证”相关页面
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("提现");
		withDrawPage.prompt("为了保障您的账户安全,请先完成安全认证中心支付密码设置后再提现！");
		withDrawPage.clickAuthentication();
		checkIA();
		//进入我的账户-我的账户-账户总览，把光标移至账户名旁边的“小人”，出现“去认证”链接，点击“去认证”，跳转至“安全认证”页面，选择实名认证，点击“认证”，下方弹出“身份认证”相关页面
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		myAccountPage.clickAuthentication();
		checkIA();
		//进入我的账户-我的账户-账户总览，点击账户名一行后面的“提升”链接，跳转至“安全认证”页面，选择实名认证，点击“认证”，下方弹出“身份认证”相关页面
		base.openBrowser(base.indexURL+"/page/userMgr/myHome.jsp");
		securityAuthPage.clickUp();
		checkIA();
		securityAuthPage.sendName(realName);
		securityAuthPage.sendIDCard(idCard);
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		securityAuthPage.isIdentityAuthenticationOK("身份认证成功");
	}
	
	//校验安全认证
	public void checkIA(){
		base.checkContainsTitle(PageTitles.woDeZhangHu,10);
		//base.assertEqualsActualExpectedByInt(base.turnToTargetCloseOtherPage("我的账户"), 1);
		myAccountPage.isGoMyAccount("安全认证");
		//base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.showIdentityAuthentication();
	}
	
	@Test(priority = 3)
	public void checkRegisterIdentityAuthentication_web_3798(){
		Reporter.log("安全认证P2：新注册的账户，未身份认证,顶部导航手机号处，将光标放到手机号处，出现晓得提示窗有三个链接：充值、提现、投资<br/>");
		Reporter.log("安全认证P2：点击提示窗口里面的充值链接,跳转到充值页面,弹出完善个人身份信息弹出框<br/>");
		Reporter.log("安全认证P2：点击提示窗口里面的提现链接,跳转到提现页面,点击“去安全认证”按钮,提示认证，点击去认证按钮，跳转到安全认证--实名认证页面<br/>");
		Reporter.log("安全认证P2：点击提示窗口里面的投资链接，跳转到翼存宝投资页面<br/>");
		base.logout();
		//注册
//		String tel = data.phoneConcatenation(0);
//		String password = Data.password;
//		base.openBrowser(base.indexURL + "/page/register/register.jsp");
//		tel = registerPage.register("debit", tel, password);
		
		//点击提示窗口里面的充值链接,跳转到充值页面,弹出完善个人身份信息弹出框
		String tel = "15095663196";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel1;
		}
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(tel, "111111");
		
		myAccountPage.mouseToTel("1");
		rechargePage.isIdentityInfo();
		rechargePage.closeInfo();
		base.checkContainsTitle(PageTitles.woDeZhangHu,10);
		myAccountPage.isGoMyAccount("充值");
		//点击提示窗口里面的提现链接,跳转到提现页面,点击“去安全认证”按钮,提示认证，点击去认证按钮，跳转到安全认证--实名认证页面
		myAccountPage.mouseToTel("2");
		base.checkContainsTitle(PageTitles.woDeZhangHu,10);
		myAccountPage.isGoMyAccount("提现");
		withDrawPage.clickAuthentication();
		checkIA();
		//#drawtip .lywrap
		//点击提示窗口里面的投资链接，跳转到翼存宝投资页面
		myAccountPage.mouseToTel("3");
		base.checkTitle(PageTitles.yiCunBao);
	}
	
	@Test(priority = 4,enabled=false)
	public void checkIdentityAuthenticationFail_web_3541(){
		Reporter.log("安全认证P2：用户注册成功，未进行身份认证,“真实姓名”文本框输入N多字符进行实名认证，提示认证失败<br/>");
		Reporter.log("安全认证P2：“充值”页面的“认证”窗口只提示设置“支付密码”，无须再身份认证 <br/>");
		Reporter.log("安全认证P2：借款人“资格验证”仍需身份认证<br/>");
		Reporter.log("安全认证P2：安全认证中的实名认证显示未认证<br/>");
		//注册
		base.logout();
		String tel = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel11;
		}else {
			tel = data.phoneConcatenation(0);
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("debit", tel, password);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.identityAuthentication("您就可以继续进行其他认证获取更高的信用评价和借款额度您就可以继续进行其他认证获取更高的信用评价和借款额度",data.idConcatenation());
		//base.turnToTargetCloseOtherPage("我的账户");
		securityAuthPage.isIdentityAuthenticationOK("认证失败！");
		securityAuthPage.closePrompty();
		//点击提示窗口里面的充值链接,跳转到充值页面,弹出完善个人身份信息弹出框
//		String tel = "13590647625";
//		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame(tel, "111111");
		myAccountPage.turnToMyAccount("充值");
		rechargePage.checkShowUserInfoInput(false,false,true);
		rechargePage.closeInfo();
		//借款人“资格验证”仍需身份认证"
		myAccountPage.turnToMyAccount("申请借款");
		base.checkElmentText(LoanApplicationPage.VerifyAuthBtn, "资格验证");
		//安全认证中的实名认证显示未认证
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.isAuthentication("身份证号","未认证");
	}
	
	
	@Test(priority = 5,enabled=false)//15758824744
	public void checkIdentityAuthenticationFail_web_3546(){
		Reporter.log("安全认证P2：认证失败，到我的账户-账户设置-账户信息，完善用户信息<br/>");
		Reporter.log("安全认证P2：到我的账户-账户设置-安全认证中进行身份认证,填入与账户信息不同的姓名,提示：姓名与账户信息中不一致;填入与账户信息不同的身份证号,提示：身份证号与账户信息中不一致,此时，用户可以根据实际情况修改成正确的姓名和身份证号<br/>");
		//注册
		base.logout();
		String tel = "";
		String idCard = "";
		String realName = "";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel = Data.test_run_SecurityAuth_P3_tel9;
			realName = Data.test_run_SecurityAuth_P3_realName9;
			idCard = Data.test_run_SecurityAuth_P3_idCard9;
		}else {
			tel = data.phoneConcatenation(0);
			idCard = new Data().idConcatenation();
			realName = Data.realName2;
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel = registerPage.register("debit", tel, password);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//安全认证  认证失败
		myAccountPage.turnToMyAccount("安全认证");
		//base.turnToTargetCloseOtherPage("我的账户");
		securityAuthPage.identityAuthentication("您就可以继续进行其他认证获取更高的信用评价和借款额度您就可以继续进行其他认证获取更高的信用评价和借款额度",idCard);
		securityAuthPage.isIdentityAuthenticationOK("认证失败！");
		securityAuthPage.closePrompty();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		//账户信息修改
		myAccountPage.turnToMyAccount("账户信息");
		accountInfoPage.clickUpdateBtn();
		//base.turnToTargetCloseOtherPage("我的账户");
		accountInfoPage.updateInfo(realName,idCard,"",tel+"@qq.com");
		accountInfoPage.isUpdateOK("保存成功!");
		//安全认证  与账户信息不同的姓名
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.clickIdentityAuthenticationBtn();
		securityAuthPage.sendName("张四");
		securityAuthPage.sendIDCard(idCard);
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		securityAuthPage.checkIdAuth("您输入的姓名与设置的不一致,请到账户设置里面更改!");
		securityAuthPage.closePrompty();
		//安全认证  与账户信息不同的身份证
		securityAuthPage.sendName(realName);
		String idCard2 = data.idConcatenation();
		securityAuthPage.sendIDCard(idCard2);
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		securityAuthPage.checkIdAuth("此次认证非首次认证！");
		securityAuthPage.clickGoOn();
		securityAuthPage.checkIdAuth("您输入的身份证号与设置的不一致,请到账户设置里面更改!");
		securityAuthPage.closePrompty();
		//安全认证  与账户信息姓名、身份证相同
		securityAuthPage.sendName(realName);
		securityAuthPage.sendIDCard(idCard);
		securityAuthPage.clickIdentityAuthenticationSureBtn();
		securityAuthPage.checkIdAuth("余额不足10.0元，请先充值！如您已直接汇款转账，请等待审核后再试！");
		securityAuthPage.closePrompty();
	}
	
	@Test(priority = 6)
	public void checkIdentityAuthenticationuniversal_web_3539(){
		Reporter.log("安全认证P2：验证身份认证通用性,注册了3个新用户，都未进行身份认证<br/>");
		Reporter.log("安全认证P2：用户1在“充值”页面，弹出的“认证”窗口认证成功,我的账户-账户设置-安全认证中，“实名认证”显示“已认证”，进入我的账户-我的借入-申请借款，点击“资格验证”，“资格验证”页面“身份证认证”已认证通过，直接到下一步骤<br/>");
		Reporter.log("安全认证P2：用户2在“安全认证”页面，实名认证中身份认证成功，“充值”页面弹出的“认证”窗口，“真实姓名”和“身份证号”不可修改，支付密码仍可在该窗口设置，进入我的账户-我的借入-申请借款，点击“资格验证”，“资格验证”页面“身份证认证”已认证通过，直接到下一步骤<br/>");
		Reporter.log("安全认证P2：用户3通过借款人“资格验证”身份认证成功,我的账户-账户设置-安全认证中，“实名认证”显示“已认证”,“充值”页面弹出的“认证”窗口，“真实姓名”和“身份证号”不可修改，支付密码仍可在该窗口设置<br/>");
		//用户1在“充值”页面，弹出的“认证”窗口认证成功,我的账户-账户设置-安全认证中，“实名认证”显示“已认证”，进入我的账户-我的借入-申请借款，点击“资格验证”，“资格验证”页面“身份证认证”已认证通过，直接到下一步骤
		base.logout();
		String tel1 = "";
		String idCard1 = "";
		String realName1 = "用户一";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel1 = Data.test_run_SecurityAuth_P3_tel13_1;
			realName1 = Data.test_run_SecurityAuth_P3_idCard13_1;
			idCard1 = Data.test_run_SecurityAuth_P3_realName13_1;
		}else {
			tel1 = data.phoneConcatenation(0);
			idCard1 = new Data().idConcatenation();
		}
		String password = Data.password;
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel1 = registerPage.register("debit", tel1, password);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("充值");
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
		String info[] = rechargePage.setInfo(realName1,idCard1,"111111");
		idCard1 = info[1];
		myAccountPage.turnToMyAccount("申请借款");
		checkIAOver();
		//用户2在“安全认证”页面，实名认证中身份认证成功，“充值”页面弹出的“认证”窗口，“真实姓名”和“身份证号”不可修改，支付密码仍可在该窗口设置，进入我的账户-我的借入-申请借款，点击“资格验证”，“资格验证”页面“身份证认证”已认证通过，直接到下一步骤
		base.logout();
		String tel2 = "";
		String idCard2 = "";
		String realName2 = "用户二";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel2 = Data.test_run_SecurityAuth_P3_tel13_2;
			idCard2 = Data.test_run_SecurityAuth_P3_idCard13_2;
			realName2 = Data.test_run_SecurityAuth_P3_realName13_2;
		}else {
			tel2 = data.phoneConcatenation(0);
			idCard2 = new Data().idConcatenation();
		}
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel2 = registerPage.register("debit", tel2, password);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		if(base.gethandelsNum()==2){
			base.turnToTargetCloseOtherPage("我的账户");
		}
		securityAuthPage.identityAuthentication(realName2, idCard2);
		securityAuthPage.closePrompty();
		base.turnToTargetCloseOtherPage("我的账户");
		myAccountPage.turnToMyAccount("充值");
		rechargePage.checkShowUserInfoInput(false,false,true);
		myAccountPage.turnToMyAccount("申请借款");
		checkIAOver();
		//用户3通过借款人“资格验证”身份认证成功,我的账户-账户设置-安全认证中，“实名认证”显示“已认证”,“充值”页面弹出的“认证”窗口，“真实姓名”和“身份证号”不可修改，支付密码仍可在该窗口设置
		base.logout();
		String tel3 = "";
		String idCard3 = "";
		String realName3 = "用户三";
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			tel3 = Data.test_run_SecurityAuth_P3_tel13_2;
			idCard3 = Data.test_run_SecurityAuth_P3_idCard13_2;
			realName3 = Data.test_run_SecurityAuth_P3_realName13_2;
		}else {
			tel3 = data.phoneConcatenation(0);
			idCard3 = new Data().idConcatenation();
		}
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		tel3 = registerPage.register("debit", tel3, password);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("申请借款");
		checkDIA();
		registerPage.idCardInfo(realName3,idCard3);
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		myAccountPage.turnToMyAccount("安全认证");
		securityAuthPage.isAuthentication("身份证号","已认证");
		myAccountPage.turnToMyAccount("充值");
		rechargePage.checkShowUserInfoInput(false,false,true);
	}
	
	public void checkIAOver(){
		base.checkElmentText(LoanApplicationPage.VerifyAuthBtn, "资格验证");
		base.clickWithWait(LoanApplicationPage.VerifyAuthBtn);
		base.assertEqualsActualExpectedByInt(base.turnToTargetCloseOtherPage("借入验证"), 1);
		registerPage.isInfoPage();
	}
}
