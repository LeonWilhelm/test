package com.eloancn.suites.debit;

import org.testng.Reporter;
import org.testng.annotations.*;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.AccountInfoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyDebitPlan;
import com.eloancn.shared.pages.MyLoanPage;
import com.eloancn.shared.pages.RechargePage;
import com.eloancn.shared.pages.RegisterPage;
import com.eloancn.shared.pages.SecurityAuthPage;

/*
 * “借入流程”用例-徐天元
 */
public class Debit {
	
	IndexPage indexPage = new IndexPage();
	RegisterPage registerPage = new RegisterPage();
	Base base = new Base();
	MyAccountPage myAccountPage = new MyAccountPage();
	LoginPage loginPage = new LoginPage();
	MyLoanPage myLoanPage = new MyLoanPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	RechargePage rechargePage = new RechargePage();
	MyDebitPlan myDebitPlan = new MyDebitPlan();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	
	public String email = Data.email;
	public String tel = Data.tel;
	String password = Data.password;
	String zzmm = Data.zzmm;
	String idCard = new Data().idConcatenation();
	String bankAccount = "622848181111111";
	String realName = Data.realName;
	String parentAddress = "上地科实大厦";
	String[] names = Data.names;
	String[] tels = Data.tels;
		
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
			tel = Data.test_register_debit_tel;
			idCard = Data.test_register_debit_idCard;
			realName =  Data.test_register_debit_realName;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.logout();
		base.tearDown();
	}
	
	/**
	 * 徐天元
	 * 我要借款-注册-通过运营商借款用户-跳转至“借入者认证”页面
	 */
	@Test
	public void register_AT_449(){
		Reporter.log("借入流程-借入者注册:我要借款-注册-通过运营商借款用户-跳转至“借入者认证”页面,显示身份证认证步骤,1步骤跳过<br/>");
		//首页点击注册
		//indexPage.clickRegisterLink();
		base.openBrowser(base.indexURL + "/page/register/register.jsp");
		Reporter.log("初始手机："+tel+"  身份证："+idCard+"  姓名："+realName+"<br/>");
		System.out.println("借入流程-借入者注册,初始手机："+tel+"  身份证："+idCard+"  姓名："+realName);
		//注册
		tel = registerPage.register("debit", tel, password);
		//验证注册成功
		registerPage.isRegisterOK();
		//点击'通过运营商借款用户'
		registerPage.clickOperatorDebiterBtn();
		//判断进入借入验证界面
		registerPage.isDebitVerifyPage();		
	}
	
	/**
	 * 徐天元
	 * 身份认证
	 */
	@Test(dependsOnMethods="register_AT_449")
	public void idCardIdentification_AT_453(){
		Reporter.log("借入流程-借入者认证页:身份认证,跳转到“填写资料”页面<br/>");
		//身份认证
		String info[] = registerPage.idCardIdentification(realName,idCard);
		realName = info[0];
		idCard = info[1];
		Reporter.log("身份已认证:"+realName+","+idCard+","+tel+"<br/>");
		System.out.println("身份已认证:"+realName+","+idCard+","+tel);
		//进入资料填写界面
		registerPage.isInfoPage();
	}
	
	/**
	 * 徐天元
	 * 资料填写
	 */
	@Test(dependsOnMethods="idCardIdentification_AT_453")
	public void writeInfo_AT_454(){
		Reporter.log("借入流程-借入者认证页:填写资料,跳转到“发标借款”页面<br/>");
		registerPage.writeInfo();
		registerPage.isSuingLoansPage();
	}
	
	/**
	 * 徐天元
	 * 点击“完善信息”，跳转到“我的借款--完善资料”页
	 */
	@Test(dependsOnMethods="writeInfo_AT_454")
	public void addInfo_AT_455(){
		Reporter.log("借入流程-借入者认证页-发标借款:点击“完善信息”，跳转到“我的借款--完善资料”页<br/>");
		registerPage.suingLoansBtnClick("完善信息");
		myAccountPage.isGoMyAccount("我的借款");
		myLoanPage.isCurrentlocationOK("完善资料");
	}
	
	/**
	 * 徐天元
	 * 填写基本资料，跳转到“紧急联系人”页
	 */
	@Test(dependsOnMethods="addInfo_AT_455")
	public void setBaseInfo_AT_460(){
		Reporter.log("借入流程-完善资料页:完善基本资料，跳转到“紧急联系人”页<br/>");
		myLoanPage.baseInfo(parentAddress);
		myLoanPage.isCurrentInfo("紧急联系人");
	}
	
	/**
	 * 徐天元
	 * 紧急联系人资料填写,保存调到信用资料页面
	 */
	@Test(dependsOnMethods="setBaseInfo_AT_460")
	public void setEmergencyContact_AT_461(){
		Reporter.log("借入流程-完善资料页:完善紧急联系人，跳转到“信用资料”页<br/>");
		myLoanPage.writeEmergencyContact(names,tels);
		myLoanPage.isCurrentInfo("信用资料");
	}
	
	/**
	 * 徐天元
	 * 设置我的借款 完善资料 信用资料
	 */
	@Test (dependsOnMethods="setEmergencyContact_AT_461")
	public void setCreditInfo_AT_463(){
		Reporter.log("借入流程-完善资料页:完善信用资料<br/>");
		myLoanPage.writeCreditInfo();
		myLoanPage.isCurrentlocationOK("材料上传");
	}
	
	/**
	 * 徐天元
	 * 上传头像
	 */
	@Test (dependsOnMethods="setCreditInfo_AT_463")
	public void setPhoto_AT_466(){
		//indexPage.clickMenu("我的账户");
//		base.openBrowser("http://client.eloancn.com/page/userMgr/myHome.jsp");
//		loginPage.loginWithNoFrame("13111111121", "111111");
		Reporter.log("借入流程-我的账户:上传用户头像<br/>");
		if(!base.browserType.equals("ie")){
			myAccountPage.turnToMyAccount("账户信息");
			accountInfoPage.updatePhoto();
			accountInfoPage.isUpdateOK("上传头像完成");
			//判断账户总览头像更新
			accountInfoPage.isMyAccountPhotoUpdate();
		}
		else{
			Reporter.log("error_ie不兼容请手动测试！<br/>");
		}
	}
	
	/**
	 * 徐天元
	 * 充值 转账汇款
	 */
//	@Test (priority = 8)
//	public void rechargeTransferRemittance_AT_467(){
//		myAccountPage.turnToMyAccount("充值");
//		rechargePage.rechargeTransferRemittance(realName, idCard, zzmm,"2015-05-01","10","中国银行","1111","自动化测试，请拒！谢谢");
//		//判断是否充值成功
//		rechargePage.isRecharge();
//	}

}
