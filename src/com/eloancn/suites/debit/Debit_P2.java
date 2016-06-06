package com.eloancn.suites.debit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.*;
import com.eloancn.shared.pages.*;
/*
 * 我的借入
 */
public class Debit_P2{

	Base base = new Base();
	MyAccountPage myAccountPage = new MyAccountPage();
	LoginPage loginpage = new LoginPage();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	MyLoanPage myloanpage = new MyLoanPage();
	AccountInfoPage accountInfo = new AccountInfoPage();
	String CreaterLBDtenderid="",NoncreaterLBDtenderid="";
	String CreaterLBDCode="",NoncreaterLBDCode="";
	String YNDtenderid="";
	String begindate="";
	String LBMembersNum="2人";
	
	String LoanUserName=Data.tel_Loan;
	String UserPwd=Data.password;
	String NoAuthenUserName=Data.run_ECunBao_oldtel;//未身份认证
	String test_NoAuthenUserName=Data.test_run_ECunBao_oldtel;
	String LBDCreaterUserName=Data.tel_LBDCreaterLoan;
	String LBDNoncreaterUserName=Data.tel_LBDNoncreaterLoan;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(myAccountPage.MyAccountUrl);
	}
	
	@AfterClass	
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test (priority = 1)
	//"我的借款"-"完善资料"-检查基本资料页面显示
	public void checkBasicInfoData_3957(){
		Reporter.log("“我的借款”-“完善资料”-检查基本资料页面显示<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.checkBasicInfoPage();
	}
	
	@Test (priority = 2)
	//"我的借款"-"完善资料"-检查紧急联系人页面显示
	public void checkEmergencyContact_3958(){
		Reporter.log("“我的借款”-“完善资料”-检查紧急联系人页面显示<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.clickEmergencyContactLnk();
		myloanpage.checkContactPage();
	}
	
	@Test (priority = 3)
	//“我的借款”-“材料上传”-检查材料上传页面的默认状态
	public void checkUploadDocPageData_3962(){
		Reporter.log("“我的借款”-“完善资料”-“材料上传”-检查材料上传页面的默认状态<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("材料上传");
		myloanpage.checkUploadDocData();
	}
	
	@Test (priority = 4)
	//"我的借款"-"完善资料"-“基本资料”-检查性别和年龄不可编辑
	public void checkGendarandAge_3861(){
		Reporter.log("用户已完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查性别和年龄不可编辑<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.checkGendarandAge();
	}
	
	@Test (priority = 5)
	//"我的借款"-"完善资料"-“基本资料”-检查住宅电话
	public void checkPhone_3863(){
		Reporter.log("用户已完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查住宅电话<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.inputPhone("123456789012310");
		myloanpage.inputPhone("12345678901231050");
	}
	
	@Test (priority = 6)
	//"我的借款"-"完善资料"-“基本资料”-检查QQ号码
	public void checkQQNum_3864(){
		Reporter.log("用户已完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查QQ号码<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.inputQQNum("123456789012345");
		myloanpage.inputQQNum("12345678901234");
		myloanpage.inputQQNum("123456789");
		myloanpage.clearQQNum();
		myloanpage.inputQQNum("12345678901");	
	}
	
	@Test (priority = 7)
	//"我的借款"-"完善资料"-“基本资料”-检查父母所在地、现居住地地址
	public void checkAddress_3866(){
		Reporter.log("用户已完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查父母所在地、现居住地地址<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.inputParentAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklmn");
		myloanpage.inputCurrentAddress("abcdefghijklmnopqrstuvwxyzabcdefghijkl");
		myloanpage.inputParentAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklmno");
		myloanpage.inputCurrentAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklm");
	}
	
	@Test (priority = 8)
	//"我的借款"-"完善资料"-“基本资料”-检查单位从事行业
	public void checkCompanyIndustry_3890(){
		Reporter.log("用户已完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查单位从事行业<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.inputCompanyIndustry("abcdefghijklmnopqrstuvwxyzabcdefghijklmn");
		myloanpage.inputCompanyIndustry("abcdefghijklmnopqrstuvwxyzabcdefghijklmno");
	}
	
	@Test (priority = 9)
	//"我的借款"-"完善资料"-“基本资料”-检查单位名称
	public void checkCompanyName_3891(){
		Reporter.log("用户已完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查单位名称<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.saveCompanyName("0123456789012345678901234567890123456789");
		myloanpage.saveCompanyName("~!@#$%^&*()_+|{}:<>?,./;'[]+=-`~!@#$%^&*");
		myloanpage.saveCompanyName("单位名称输入框输入汉字点击保存并继续按钮正常无错误提示单位名称输入框输入汉字点击");
		myloanpage.saveCompanyName("abcdefghijklmnopqrstuvwxyzabcdefghijklmn");
		myloanpage.saveCompanyName("0123456789abcdefghij~!@#$%^&*(单位名称输入框输入汉");
	}
	
	@Test (priority = 10)
	//"我的借款"-"完善资料"-“基本资料”-检查单位电话
	public void checkCompanyNum_3892(){
		Reporter.log("用户已完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查单位电话<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.inputCompanyPhone("012345678901234567");
		myloanpage.inputCompanyPhone("0123456789012345678");
	}
	
	@Test (priority = 11)
	//"我的借款"-"完善资料"-“基本资料”-检查单位地址
	public void checkCompanyAddress_3893(){
		Reporter.log("用户已完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查单位地址<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.checkCompanyAddress();
	}
	
	@Test (priority = 12)
	//"我的借款"-"完善资料"-“基本资料”-检查描述信息
	public void checkDescriptionInfo_3894(){
		Reporter.log("用户已完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查描述信息<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.checkDescriptionInfo();
	}
	
	@Test (priority = 13)
	//"我的借款"-"完善资料"-“基本资料”-检查除性别、年龄之外，基本资料页面的信息可修改
	public void checkModifyBaseInfo_3956(){
		Reporter.log("用户已完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查除性别、年龄之外，基本资料页面的信息可修改<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LoanUserName, UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.ModifyBaseInfo();
	}
	
	@Test (priority = 14)
	//用户未完成身份认证-检查年龄的输入类型
	public void checkAge_3896(){
		Reporter.log("用户未完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查年龄的输入类型<br/>");
		base.logout();
		loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.saveAge("十八");
		myloanpage.saveAge("as");
		myloanpage.saveAge(">+");
		myloanpage.saveAge(" 4");
		myloanpage.saveAge("4 ");
	}
	
	@Test (priority = 15)
	//用户未完成身份认证-检查各个选项可修改
	public void checkUpdateBaseInfo_3955(){
		Reporter.log("用户未完成身份认证-“我的借款”-“完善资料”-“基本资料”-检查各个选项可修改<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.checkUpdateBaseInfo();
	}
	
	@Test (priority = 16)
	//非必填选项的校验
	public void checkOptionalOption_3954(){
		Reporter.log("“我的借款”-“完善资料”-“基本资料”-检查非必填选项<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.checkOptionalOption();
	}
	
	@Test (priority = 17)
	//必填选项的校验
	public void checkRequiredOption_3952(){
		Reporter.log("“我的借款”-“完善资料”-“基本资料”-检查必填选项<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.checkRequiredOption();
	}
	
	@Test (priority = 18)
	//完善资料--紧急联系人页面-姓名格式的校验
	public void checkEmergencyNames_3959(){
		Reporter.log("“我的借款”-“完善资料”-“基本资料”-检查紧急联系人页面的姓名格式<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.clickEmergencyContactLnk();
		myloanpage.checkEmergencyNames();
	}
	
	@Test (priority = 19)
	//完善资料--紧急联系人页面-手机格式的校验
	public void checkEmergencyTels_3960(){
		Reporter.log("“我的借款”-“完善资料”-“基本资料”-检查紧急联系人页面的手机格式<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(NoAuthenUserName,UserPwd,"",test_NoAuthenUserName,UserPwd,"");
		}
		myAccountPage.clickMyDebtLnk();
		myloanpage.clickBtn("完善资料");
		myloanpage.clickEmergencyContactLnk();
		myloanpage.checkEmergencyTels();
	}
		
	@Test (priority = 20)
	//我的借入--申请借款-检查申请大额“翼农贷”借款成功
	public void verifyPublishAgricultureLoan_1370(){
		Reporter.log("我的借入--申请借款-检查申请大额“翼农贷”借款成功<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">虚拟机大额借款时上传文件受sikuli限制会失败！</font><br/>");
		if(base.indexURL.contains("client")){
			base.logout();
			loginpage.loginByMyAccount(LoanUserName,UserPwd,"","","","");
			myAccountPage.turnToMyAccount("申请借款");
			String purpose=loanApplicationPage.loanApplication(true,false,"翼农贷","500","12个月","","18","7","满标","fx","个人消费","自动化测试大额"+base.RandomNumber(),"自动化：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}
	
	@Test (priority = 21)
	//我的借入--申请借款-检查申请大额“翼商贷”借款成功
	public void verifyPublishBusinessLoan_1372(){
		Reporter.log("我的借入--申请借款-检查申请大额“翼商贷”借款成功<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">虚拟机大额借款时上传文件受sikuli限制会失败！</font><br/>");
		if(base.indexURL.contains("client")){
			base.openBrowser(myAccountPage.MyAccountUrl);
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LoanUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			String purpose=loanApplicationPage.loanApplication(true,false,"翼商贷","500","12个月","","18","7","满标","fx","个人消费","自动化测试大额"+base.RandomNumber(),"自动化：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}
	
	@Test (priority = 22)
	//我的借入--申请借款-检查申请大额“DD借款”借款成功
	public void verifyPublishDDLoan_1374(){
		Reporter.log("我的借入--申请借款-检查申请大额“DD借款”借款成功<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">虚拟机大额借款时上传文件受sikuli限制会失败！</font><br/>");
		if(base.indexURL.contains("client")){
			base.openBrowser(myAccountPage.MyAccountUrl);
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LoanUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			String purpose=loanApplicationPage.loanApplication(true,false,"DD借款","1000","12个月","","18","7","满标","fx","个人消费","自动化测试大额"+base.RandomNumber(),"自动化：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}
	
	@Test (priority = 23)
	//我的借入--申请借款-检查申请大额“翼车贷”借款成功
	public void verifyPublishCarLoan_1376(){
		Reporter.log("我的借入--申请借款-检查申请大额“翼车贷”借款成功<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">虚拟机大额借款时上传文件受sikuli限制会失败！</font><br/>");
		if(base.indexURL.contains("client")){
			base.openBrowser(myAccountPage.MyAccountUrl);
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LoanUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			String purpose=loanApplicationPage.loanApplication(true,false,"翼车贷标","500","6个月","","18","7","满标","fx","个人消费","自动化测试大额"+base.RandomNumber(),"自动化：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}		
	
	@Test (priority = 24)
	//我的借入--申请借款-未参加联保的情况下，查看借款申请页面
	public void verifyNotJoinLB_4248(){
		Reporter.log("我的借入--申请借款-未参加联保的情况下，查看借款申请页面<br/>");
		base.logout();
		loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		base.openBrowser(myAccountPage.MyAccountUrl);
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.checkDefaultData();
		loanApplicationPage.selectBidType("联保贷");
		loanApplicationPage.checkLBDLoanPage(false);
	}
	
	@Test (priority = 25)
	//申请借款页面空校验
	public void checkPublishLBDwithoutData_4257(){
		Reporter.log("我的借入--申请借款-检查联保贷在不输入任何信息时不能发布<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.selectBidType("联保贷");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("请输入要借贷的金额！");
	}
	
	@Test (priority = 26)
	public void checkApplyOtherTypeLoan_4266(){
		Reporter.log("我的借入--申请借款-检查借款用户有其他类型的借款标时，可以申请联保贷标<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">如果有报错，可能是数据库问题！</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			base.openBrowser(myAccountPage.MyAccountUrl);
			myAccountPage.turnToMyAccount("申请借款");
			String purpose=loanApplicationPage.loanApplication(false,false,"翼农贷","500","3个月","","12","7","满标","fx","个人消费","自动化测试"+base.RandomNumber(),"自动化：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
			myAccountPage.turnToMyAccount("申请借款");
			purpose=loanApplicationPage.loanApplication(false,false,"联保贷","500","1个月","5人","","7","满标","等额本金","个人消费","创建人自动化"+base.RandomNumber(),"自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}
	
	@Test (priority = 27)
	public void checkCreaterPhaseandRepayMode_4260(){
		Reporter.log("我的借入--申请借款-检查创建人的联保贷，1-12个月的借款期限可选任意还款方式，13-24个月借款期限只能选择等额本息的还款方式<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">如果有报错，可能是数据库问题！</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.loanApplication(false,false,"联保贷","500","20个月","5人","","7","满标","还本付息","个人消费","自动化联保贷标","自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			base.checkAlertText("13个月以上的借款，还款方式只能选择等额本息");
			myAccountPage.turnToMyAccount("申请借款");
			String purpose=loanApplicationPage.loanApplication(false, false, "联保贷", "500", "1个月","5人", "", "7", "满标", "等额本金", "个人消费", "创建人自动化"+base.RandomNumber(), "自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.DisableLBCodewithSQL(purpose);
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
			myAccountPage.turnToMyAccount("申请借款");
			purpose=loanApplicationPage.loanApplication(false, false, "联保贷", "500", "5个月","5人", "", "7", "满标", "还本付息", "个人消费", "创建人自动化"+base.RandomNumber(), "自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.DisableLBCodewithSQL(purpose);
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
			myAccountPage.turnToMyAccount("申请借款");
			purpose=loanApplicationPage.loanApplication(false, false, "联保贷", "500", "13个月","5人", "", "7", "满标", "等额本息", "个人消费", "创建人自动化"+base.RandomNumber(), "自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.DisableLBCodewithSQL(purpose);
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
			myAccountPage.turnToMyAccount("申请借款");
			purpose=loanApplicationPage.loanApplication(false, false, "联保贷", "500", "24个月","5人", "", "7", "满标", "等额本息", "个人消费", "创建人自动化"+base.RandomNumber(), "自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.DisableLBCodewithSQL(purpose);
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}

	@Test (priority = 28)
	//联保贷借贷金额不影响授信最高可借金额
	public void checkLBDmaxBorrowMoney_4268(){
		Reporter.log("我的借入--申请借款-检查联保贷借贷金额不影响授信最高可借金额<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">如果有报错，可能是数据库问题！</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.inputBorrowMoney("10");
			String maxmoney = base.getElementTextWithVisible(loanApplicationPage.SXmaxMoney);
			String purpose=loanApplicationPage.loanApplication(false,false,"联保贷","500","2个月",LBMembersNum,"","7","满标","等额本金","个人消费","创建人自动化"+base.RandomNumber(),"自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			CreaterLBDtenderid= myloanpage.getTenderId(purpose);
			CreaterLBDCode = "LBD"+base.dateFormat(base.getTime(), "yyyyMMdd")+CreaterLBDtenderid;
			myAccountPage.turnToMyAccount("申请借款");
			base.clickWithWait(loanApplicationPage.jkjeTxt);
			base.checkElmentText(loanApplicationPage.SXmaxMoney, maxmoney);	
		}
	}
	
	@Test (priority = 29)
	//创建人查看联保编码格式
	public void checkCreaterLBDCode_4283(){
		Reporter.log("我的借款--已发布的借款-创建人查看联保编码格式<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickPublishedTab();
			myloanpage.clickLBDBidType(CreaterLBDtenderid);
			base.checkElmentText(myloanpage.LBDCode, "联保贷编码："+CreaterLBDCode);
		}
	}
	
	@Test (priority = 30)
	//我的借入--申请借款-已参加联保的情况下，查看借款申请页面
	public void verifyJoinLB_4249(){
		Reporter.log("我的借入--申请借款-已参加联保的情况下，查看借款申请页面<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.selectBidType("联保贷");
			loanApplicationPage.checkLBDLoanPage(true);
		}
	}
	
	@Test (priority = 31)
	//我的借入--申请借款-检查已参加联保的创建人不能再次申请联保贷，联保人数可再次被修改
	public void checkCreaterApplyLBDAgain_4263_4281(){
		Reporter.log("我的借入--申请借款-检查已参加联保的创建人不能再次申请联保贷，联保人数可再次被修改<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.selectBidType("联保贷");
			base.checkElmentText(loanApplicationPage.LBCode, "主贷人在一个联保组内不能重复借贷");
			loanApplicationPage.selectLBPeopleNum("4人");
			loanApplicationPage.loanApplication(false,false,"联保贷","500","5个月","5人","","7","满标","还本付息","个人消费","创建人自动化"+base.RandomNumber(),"自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			base.checkAlertText("主贷人在一个联保组内不能重复借贷");			
		}
	}
	
	@Test (priority = 32)
	//进行申请额度、大额标操作，不影响联保贷标借款金额的限制
	public void checkCreaterBorrowMoney_4286(){
		Reporter.log("检查创建人进行申请额度、大额标操作，不影响联保贷标借款金额的限制<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">虚拟机大额借款时上传文件受sikuli限制会失败！</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickBtn("申请额度");
			myloanpage.QuotaRequest("车担保增额", "1个月", "500", "自动化申请增额");
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.loanApplication(false,false,"联保贷","24000","5个月","2人","","7","满标","还本付息","个人消费","创建人自动化"+base.RandomNumber(),"自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			base.checkAlertText("2户联保最高只能借款2万");
			loanApplicationPage.loanApplication(true,false,"联保贷","24000","5个月","2人","","7","满标","还本付息","个人消费","创建人自动化"+base.RandomNumber(),"自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			base.checkAlertText("2户联保最高只能借款2万");
		}
	}
	
	@Test (priority = 33)
	//我的借入--申请借款-检查已参加联保的创建人可以申请其他类型的借款标
	public void checkCreaterApplyOtherTypesLoan_4264(){
		Reporter.log("我的借入--申请借款-检查已参加联保的创建人可以申请其他类型的借款标<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">如果有报错，可能是数据库问题！</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			}
			base.openBrowser(myAccountPage.MyAccountUrl);
			myAccountPage.turnToMyAccount("申请借款");
			String purpose=loanApplicationPage.loanApplication(false,false,"翼农贷","500","3个月","","12","7","满标","fx","个人消费","自动化测试"+base.RandomNumber(),"自动化：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
//			myloanpage.UpdateTenderStatusByTitlewithSQL(purpose, "0");
		}
	}
	
	@Test (priority = 34)
	public void checkCreaterLBDBorrowPhase_4258(){
		Reporter.log("我的借入--申请借款-查看联保贷创建人的借款期限为1-24个月<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.selectBidType("联保贷");
		loanApplicationPage.inputBorrowMoney("500");
		loanApplicationPage.checkLBDLoanPhase();
	}
	
	@Test (priority = 35)
	public void checkCreaterLBPeopleNum_4259(){
		Reporter.log("我的借入--申请借款-查看联保贷创建人的联保人数为2-5人<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.selectBidType("联保贷");
		loanApplicationPage.inputBorrowMoney("500");
		loanApplicationPage.selectBorrowPhase("1个月");
		loanApplicationPage.checkCreaterLBPeopleNum();
	}
		
	@Test (priority = 36)
	public void checkCreaterBorrowRate_4261(){
		Reporter.log("我的借入--申请借款-查看创建人申请联保贷时借款期限和最高年利率匹配<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.selectBidType("联保贷");
		loanApplicationPage.selectBorrowPhase("1个月");
		loanApplicationPage.selectBorrowPhase("6个月");
		loanApplicationPage.selectBorrowPhase("7个月");
		loanApplicationPage.selectBorrowPhase("12个月");
		loanApplicationPage.selectBorrowPhase("13个月");
		loanApplicationPage.selectBorrowPhase("24个月");
	}
	
	@Test (priority = 37)
	public void checkCreaterBorrowMoneyandPNum_4262(){
		Reporter.log("我的借入--申请借款-查看创建人申请联保贷时，2人的联保人数最多借款20000,3-5人最多借款30000<br/>");
		if(!loginpage.ifLogin()){
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"",LoanUserName,UserPwd,"");
		}
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.loanApplication(false,false,"联保贷","25000","20个月","2人","","7","满标","还本付息","个人消费","自动化联保贷标","自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
		base.checkAlertText("2户联保最高只能借款2万");
		loanApplicationPage.inputBorrowMoney("35000");
		loanApplicationPage.selectLBPeopleNum("3人");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("3-5户联保最高只能借款3万");
		loanApplicationPage.selectLBPeopleNum("4人");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("3-5户联保最高只能借款3万");
		loanApplicationPage.selectLBPeopleNum("5人");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("3-5户联保最高只能借款3万");
		loanApplicationPage.inputBorrowMoney("200");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("输入金额有误！");
		base.checkElmentText(loanApplicationPage.BorrowMoneyErrorTxt, "借贷金额不能低于500.00元！");
		loanApplicationPage.inputBorrowMoney("250");
		loanApplicationPage.clickPublishLoanBtn();
		base.checkAlertText("输入金额有误！");
		base.checkElmentText(loanApplicationPage.BorrowMoneyErrorTxt, "借款金额必须为100的倍数！");
	}
	
	@Test (priority = 38)
	//通过数据库添加两名联保组成员,盟商初审通过
	public void AddLBDMembers(){
		Reporter.log("通过数据库添加两名联保组成员,盟商初审通过<br/>");
		if(base.indexURL.contains("client")){
			myloanpage.addLBDTwoMemeberswithSQL(CreaterLBDCode);
			begindate=myloanpage.addFirstTrialRecordwithSQL(CreaterLBDtenderid);//若不加此步，判断初审没有通过
			myloanpage.UpdateTenderStatuswithSQL(CreaterLBDtenderid, "11");
			base.sleep(3000);
		}
	}
	
	@Test (priority = 39)
	//非创建人检查联保人数
	public void checkNoncreaterLBMembersNum_4270_4282_4283(){
		Reporter.log("我的借入--申请借款-查看非创建人申请联保贷的联保人数自动获取显示且不可修改<br/>");
		if(base.indexURL.contains("client")){
			base.logout();
			loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.selectBidType("联保贷");
			base.checkElementVisible(loanApplicationPage.LBCode);
			base.checkElmentText(loanApplicationPage.LBCode, CreaterLBDCode);//非创建人联保组编码
			base.assertTrueByBoolean(base.getElements(loanApplicationPage.LBPeopleNumOption).size()==1);
			base.assertEqualsActualExpected(base.getElementText(loanApplicationPage.LBPeopleNumOption),LBMembersNum);
		}
	}
	
	@Test (priority = 40)
	//非创建人检查借款期限
	public void checkNoncreaterLoanPhase_4269(){
		Reporter.log("我的借入--申请借款-查看非创建人申请联保贷的借款期限<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.selectBidType("联保贷");
			loanApplicationPage.inputBorrowMoney("500");
			loanApplicationPage.checkLBDLoanPhase();
		}
	}
	
	@Test (priority = 41)
	public void checkNoncreaterPhaseandRepayMode_4271(){
		Reporter.log("我的借入--申请借款-检查非创建人的联保贷，1-12个月的借款期限可选任意还款方式，13-24个月借款期限只能选择等额本息的还款方式<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">如果有报错，可能是数据库问题！</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.loanApplication(false,false,"联保贷","500","20个月",LBMembersNum,"","7","满标","还本付息","个人消费","自动化联保贷标","自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			base.checkAlertText("13个月以上的借款，还款方式只能选择等额本息");
			myAccountPage.turnToMyAccount("申请借款");
			String purpose=loanApplicationPage.loanApplication(false, false, "联保贷", "500", "1个月",LBMembersNum, "", "7", "满标", "等额本金", "个人消费", "非创建人自动化"+base.RandomNumber(), "自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			String id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
			myAccountPage.turnToMyAccount("申请借款");
			purpose=loanApplicationPage.loanApplication(false, false, "联保贷", "500", "5个月",LBMembersNum, "", "7", "满标", "还本付息", "个人消费", "非创建人自动化"+base.RandomNumber(), "自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
			myAccountPage.turnToMyAccount("申请借款");
			purpose=loanApplicationPage.loanApplication(false, false, "联保贷", "500", "13个月",LBMembersNum, "", "7", "满标", "等额本息", "个人消费", "非创建人自动化"+base.RandomNumber(), "自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
			myAccountPage.turnToMyAccount("申请借款");
			purpose=loanApplicationPage.loanApplication(false, false, "联保贷", "500", "24个月",LBMembersNum, "", "7", "满标", "等额本息", "个人消费", "非创建人自动化"+base.RandomNumber(), "自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			id= myloanpage.getTenderId(purpose);
			myloanpage.DisableLBCodewithSQL(id);
			myloanpage.UpdateTenderStatuswithSQL(id, "0");
		}
	}
	
	@Test (priority = 42)
	public void checkNoncreaterBorrowRate_4272(){
		Reporter.log("我的借入--申请借款-查看非创建人借款期限和最高年利率匹配<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.selectBidType("联保贷");
			loanApplicationPage.selectBorrowPhase("1个月");
			loanApplicationPage.selectBorrowPhase("6个月");
			loanApplicationPage.selectBorrowPhase("7个月");
			loanApplicationPage.selectBorrowPhase("12个月");
			loanApplicationPage.selectBorrowPhase("13个月");
			loanApplicationPage.selectBorrowPhase("24个月");
		}
	}
	
	@Test (priority = 43)
	public void checkNoncreaterBorrowMoneyandPNum_4273(){
		Reporter.log("我的借入--申请借款-查看非创建人申请联保人数与资金额度匹配<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.loanApplication(false,false,"联保贷","25000","20个月",LBMembersNum,"","7","满标","还本付息","个人消费","非创建人自动化","自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			base.checkAlertText("2户联保最高只能借款2万");
			loanApplicationPage.inputBorrowMoney("200");
			loanApplicationPage.clickPublishLoanBtn();
			base.checkAlertText("输入金额有误！");
			base.checkElmentText(loanApplicationPage.BorrowMoneyErrorTxt, "借贷金额不能低于500.00元！");
			loanApplicationPage.inputBorrowMoney("250");
			loanApplicationPage.clickPublishLoanBtn();
			base.checkAlertText("输入金额有误！");
			base.checkElmentText(loanApplicationPage.BorrowMoneyErrorTxt, "借款金额必须为100的倍数！");
		}
	}
	
	@Test (priority = 44)
	//非创建人申请额度、大额标操作，不影响联保贷标借款金额的限制
	public void checkNoncreaterBorrowMoney_4287(){
		Reporter.log("检查非创建人进行申请额度、大额标操作，不影响联保贷标借款金额的限制<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">虚拟机大额借款时上传文件受sikuli限制会失败！</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickBtn("申请额度");
			myloanpage.QuotaRequest("车担保增额", "1个月", "500", "非创建人自动化申请增额");
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.loanApplication(false,false,"联保贷","24000","5个月",LBMembersNum,"","7","满标","还本付息","个人消费","非创建人自动化"+base.RandomNumber(),"自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			base.checkAlertText("2户联保最高只能借款2万");
			loanApplicationPage.loanApplication(true,false,"联保贷","24000","5个月",LBMembersNum,"","7","满标","还本付息","个人消费","非创建人自动化"+base.RandomNumber(),"自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			base.checkAlertText("2户联保最高只能借款2万");
		}
	}
	
	@Test (priority = 45)
	//联保贷非创建人可以申请其他类型的借款标
	public void checkNoncreaterApplyOtherTypesLoan_4275_4277(){
		Reporter.log("检查联保贷非创建人可以申请其他类型的借款标<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.loanApplication(false,false,"翼农贷","500","3个月","","12","7","满标","fx","个人消费","自动化：测试模块一","自动化：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
		}
	}
	
	@Test (priority = 46)
	//检查非创建人联保贷借贷金额不影响授信最高可借金额
	public void checkNoncreaterLBDmaxBorrowMoney_4279_4277(){
		Reporter.log("我的借入--申请借款-检查非创建人联保贷借贷金额不影响授信最高可借金额<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">可能会受4271条用例影响而导致失败！</font><br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			base.clickWithWait(loanApplicationPage.jkjeTxt);
			String maxmoney = base.getElementTextWithVisible(loanApplicationPage.SXmaxMoney);
			String purpose=loanApplicationPage.loanApplication(false,false,"联保贷","500","2个月",LBMembersNum,"","7","满标","等额本金","个人消费","非创建人自动化"+base.RandomNumber(),"自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			loanApplicationPage.isLoanApplicationOK();
			NoncreaterLBDtenderid= myloanpage.getTenderId(purpose);
			myAccountPage.turnToMyAccount("申请借款");
			base.clickWithWait(loanApplicationPage.jkjeTxt);
			base.checkElmentText(loanApplicationPage.SXmaxMoney, maxmoney);	
		}
	}
	
	@Test (priority = 47)
	//非创建人发布联保贷后，查看联保编码
	public void checkNoncreaterLBDCode_4283(){
		Reporter.log("非创建人发布联保贷后的联保编码跟创建人的联保编码相同<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickPublishedTab();
			myloanpage.clickLBDBidType(NoncreaterLBDtenderid);
			base.checkElmentText(myloanpage.LBDCode, "联保贷编码："+CreaterLBDCode);	
		}
	}
	
	@Test (priority = 48)
	//已参加联保的非创建人再次申请联保贷标
	public void checkNoncreaterApplyLBDAgain_4274(){
		Reporter.log("检查已参加联保的非创建人只能申请一次联保贷标<br/>");
		if(base.indexURL.contains("client")){
			if(!loginpage.ifLogin()){
				loginpage.loginByMyAccount(LBDNoncreaterUserName,UserPwd,"","","","");
			}
			myAccountPage.turnToMyAccount("申请借款");
			loanApplicationPage.selectBidType("联保贷");
			base.checkElmentText(loanApplicationPage.LBCode, "一个联保组内不能重复借贷");
			loanApplicationPage.loanApplication(false,false,"联保贷","500","5个月",LBMembersNum,"","7","满标","还本付息","个人消费","非创建人自动化"+base.RandomNumber(),"自动化联保贷：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
			base.checkAlertText("一个联保组内不能重复借贷");			
		}
	}
	
	@Test (priority = 49)
	public void checkShowBorrowerownLBD_4256(){
		Reporter.log("我的借款--已发布的借款-查看只显示自己借款的联保贷标，并检查联保组信息<br/>");
		if(base.indexURL.contains("client")){
			base.logout();
			loginpage.loginByMyAccount(LBDCreaterUserName,UserPwd,"","","","");
			myAccountPage.clickMyDebtLnk();
			myloanpage.clickPublishedTab();
			myloanpage.showOwnLBD(CreaterLBDtenderid,NoncreaterLBDtenderid);
			myloanpage.clickPublishedTab();
			myloanpage.clickLBDBidType(CreaterLBDtenderid);
			myloanpage.checkPopupLBDData(CreaterLBDCode,begindate);
		}
	}
	
	@Test (priority = 50)
	public void checkFailedBid(){
		Reporter.log("通过数据库使得创建人的联保贷标流标<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">如果有报错，可能是数据库问题！</font><br/>");
		if(base.indexURL.contains("client")){
			myloanpage.DisableLBCodewithSQL(CreaterLBDCode);
			myloanpage.UpdateTenderStatuswithSQL(CreaterLBDtenderid, "0");
			myloanpage.UpdateTenderStatuswithSQL(NoncreaterLBDtenderid, "0");
		}
	}
	
//	@Test (priority = 7)
//	//检查我的账户中头像的页面跳转以及显示
//	public void checkAccountInfoPage_3918(){
//		Reporter.log("检查我的账户中头像的页面跳转以及显示");
//		myAccountPage.clickAccountOverviewLnk();
//		myAccountPage.clickUserImageLnk();
//		accountInfo.checkAccountInfoPage();
//	}
//	
//	@Test (priority = 8,enabled=false)
//	//新注册的账号-初始状态显示默认头像
//	public void checkDefaultImg_3919(){
//		Reporter.log("新注册的账号-初始状态显示默认头像");
//		myAccountPage.clickAccountOverviewLnk();
//		myAccountPage.checkDefaultImg();
//		myAccountPage.clickUserImageLnk();
//		accountInfo.checkDefaultImg();
//	}
//	
//	@Test (priority = 9)
//	//检查上传修改头像功能可用
//	public void checkUploadImg(){
//		myAccountPage.clickAccountInfoLnk();
//		accountInfo.clickUserPhoto();
//		accountInfo.clickCloseUploadLnk();		
//	} 

}
