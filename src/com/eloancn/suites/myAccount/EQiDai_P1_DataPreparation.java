package com.eloancn.suites.myAccount;

import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ClientBackPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyLoanPage;


/**
 * 翼企贷P1-数据准备
 * @author 江渤洋 
 */
public class EQiDai_P1_DataPreparation {
	
	Base base = new Base();
	ClientBackPage clientBackPage = new ClientBackPage();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	MyLoanPage myLoanPage = new MyLoanPage();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	
	
	String clientBackURL = base.clientBackURL;                              //集成环境后台地址
	String noticeCode = Data.noticeCode;                                    //通知码
	String passwordByBack = Data.passwordByBack;                            //后台确认密码
	String[] userNameArray = Data.userNameArray;                            //后台用户名
	String allianceBusinessUserName1 = Data.allianceBusinessUserName1;      //加盟商用户
	String headquartersUserName1 = Data.headquartersUserName1;      		//总部用户
	String headquartersUserName2 = Data.headquartersUserName2;      		//总部用户
	String lendEmail = Data.lendEmail;                                      //购买债权用户邮箱
	String password = Data.password;
	String eCunBaoId = "";                                                  //翼存宝ID
	
	String indexURL = "http://client.eloancn.com";                                  //集成前台
	String myAccountURL = "http://client.eloancn.com/page/userMgr/myHome.jsp";      //我的账户
	String WmpURL = "http://client.eloancn.com/new/loadAllWmpsRecords.action";      //翼存宝
	String registerURL = "http://client.eloancn.com/page/register/register.jsp";    //注册
	
	
	//发布借款的人名(测试首次扣费，需重新注册认证)
	String borrowerName = Data.borrowerName;
	//发布借款的人手机号
	String borrowerPhone = Data.tel_run_EcunBao;
	//发布借款的人邮箱
	String borrowerEmail = Data.borrowerEmail;
	
	//借款目的_前台  | 标题_后台（方便标示，前后台一致，格式：jby自动化+借款金额）
	String loanPurpose = "自动化测试";
	//借款期限
	String timeLimit_6 = "6个月";
	String timeLimit_12 = "12个月";

	/**
	 * 用例名称：前台_发布借款
	 * 用例编号：754
	 * @author 江渤洋
	 */
//	@Test(priority = 2)
	public void issuedLoan(String loanAmountNew, String timeLimit){
		System.out.println("翼企贷P1:前台_发布借款");
		base.setup_ff();
		base.drivermanage();
		
		base.openBrowser(indexURL);
		indexPage.clickLoginLink();
		//借款人登录
		loginPage.loginWithXpath(borrowerPhone, password);
		//进入我的账户
		base.openBrowser(myAccountURL);
		base.sleep(5000);
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.loanApplication(true, false, "翼企贷标", loanAmountNew, timeLimit,"", "16", "7", "满标", "还本付息", "翼企贷", "自动化测试 ：" + loanAmountNew, "自动化测试：" + loanAmountNew + "借入者申请担保，同城担保人同意并借款成功后，给予同城担保人实际借款金额2%的费用。同时，使您能够快速足额的借到所需的借款。");
		loanApplicationPage.isLoanApplicationOK();
		//上传材料
		myLoanPage.uploadMaterial(loanAmountNew);
		
		base.tearDown();
	}
	
	/**
	 * 用例名称：后台_审核已发布的借款
	 * 用例编号：754
	 * 备注：只在内网测试;根据UK修改Data.userNameArray的值
	 * @author 江渤洋
	 */
//	@Test(priority = 3)
	public void tendlistAuditLoan(){
		System.out.println("翼企贷P1:后台_审核已发布的借款");
		base.setup_ie_x86();
		base.drivermanage();
		
		//数组长度
		int arrayLength = userNameArray.length;
		for(int i = 3; i < arrayLength; i++){

			String auditName = "";
			//审核账户名
			auditName = userNameArray[i];
			System.out.println("第"+ (i+1) + "次审核，审核人：" + auditName);
			//倒数第一个数
			int arrayNum = arrayLength - 2;
			//是否为进入初审通过流程。循环最后一次为初审通过
			boolean lastSecondCheck = false;
			//判断待初审借款列表是否有借款人姓名
			boolean isTrue = false;
			//登录
			clientBackPage.backLogin(clientBackURL, noticeCode, auditName, passwordByBack);
			clientBackPage.clickFirstMenu("风控管理");
			//如果是加盟商，则点击“待初审借款列表”
			if(auditName.contains("_")){
				clientBackPage.clickSubMenu("待初审借款列表");
				clientBackPage.selectLoan(clientBackPage.trialTendersIframe);
				isTrue = clientBackPage.isSearchFieldByList(clientBackPage.trialTendersIframe, clientBackPage.tendlistByBorrowerName, borrowerName);
			}
			else{
				clientBackPage.clickSubMenu("二次借款待初审列表");
				clientBackPage.selectLoanByTwice(clientBackPage.waitTrialTenders2Iframe);
				isTrue = clientBackPage.isSearchFieldByList(clientBackPage.waitTrialTenders2Iframe, clientBackPage.tendlistByBorrowerName, borrowerName);
			}
			base.assertEqualsActualExpectedByBoolean(isTrue, true);
			//借款人存在，则审核(三次加盟商审核意见，再一次加盟商置初审通过，一次总部审核意见)
			//如果是倒数第二次循环，则进入初审通过环节
			if(i == arrayNum){
				lastSecondCheck = true;
			}
			System.out.println("是否为倒数第二次审核：" + lastSecondCheck);
			//待初审借款列表——审核借款
			clientBackPage.tendlistAuditLoan(borrowerName, auditName, lastSecondCheck, passwordByBack);
		}
		base.tearDown();
	}
	
	/**
	 * 用例名称：后台_发布翼存宝(加盟商)
	 * 用例编号：754
	 * @author 江渤洋
	 */
//	@Test(priority = 3)
	public void issuedECunBao(String loanAmount){
		System.out.println("翼企贷P1:后台_发布翼存宝");
		base.setup_ie_x86();
		base.drivermanage();
		
		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("风控管理");
		clientBackPage.clickSubMenu("理财产品");
		//添加理财产品（借款金额_前台  >= 最大金额_后台 ，且为100的整数倍）
		//借款目的，借款金额
		clientBackPage.addWMP(loanPurpose+loanAmount, loanAmount);
		
		base.tearDown();
	}
	
	/**
	 * 用例名称：前台_购买已发布翼存宝
	 * 用例编号：754
	 * 备注：不同用户（李炳辰提供）
	 * @author 江渤洋
	 */
//	@Test(priority = 4)
	public void buyIssuedECunBao(String loanAmount){
		System.out.println("翼企贷P1:前台_购买已发布翼存宝");
		base.setup_ff();
		base.drivermanage();
		
		//进入翼存宝列表
		base.openBrowser(WmpURL);
		base.drivermanage();
		indexPage.clickLoginLink();
		//使用新账户登录
		loginPage.login(lendEmail, password);
		eCunBaoId = clientBackPage.buyECunBao(loanAmount, loanPurpose+loanAmount);
		System.out.println("翼存宝ID:" + eCunBaoId);
		base.tearDown();
	}
//	
//	/**
//	 * 用例名称：后台_校验翼存宝状态
//	 * 用例编号：754
//	 * @author 江渤洋
//	 */
//	@Test(priority = 5)
//	public void checkProductStatus(){
//		
//		base.setup_ie_x86();
//		base.drivermanage();
//		
//		//加盟商登录
//		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
//		clientBackPage.clickFirstMenu("风控管理");
//		clientBackPage.clickSubMenu("理财产品");		
//		//跳转到“理财产品”页
//		clientBackPage.jumpIframe(clientBackPage.wmpsIframe);
//		//刷新翼存宝列表
//		clientBackPage.clickRefreshBtn(clientBackPage.refreshBtnByWMPSrecordList);
//		base.sleep(2000);
//		//根据标题校验理财产品中翼存宝的状态
//		clientBackPage.checkProductStatus(eCunBaoId);//eCunBaoId
//		
//		base.tearDown();
//	}
	
	/**
	 * 用例名称：后台_加入债券池
	 * 用例编号：754
	 * @author 江渤洋
	 */
//	@Test(priority = 6)
	public void joinBond(){
		System.out.println("翼企贷P1:后台_加入债券池");
		base.setup_ie_x86();
		base.drivermanage();
		
		//加盟商登录
		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("风控管理");
		//--------------------------------------------------------------------------------------------测试
		clientBackPage.clickSubMenu("待初审借款列表");
		clientBackPage.selectLoan(clientBackPage.trialTendersIframe);
		//判断待初审借款列表是否有借款人姓名
		boolean isTrue = false;
		isTrue = clientBackPage.isSearchFieldByList(clientBackPage.trialTendersIframe, clientBackPage.tendlistByBorrowerName, borrowerName);
		//借款人存在
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
		//待初审借款列表——批量加入债券池
		clientBackPage.joinBond(borrowerName, passwordByBack);
		
		base.tearDown();
	}

	/**
	 * 用例名称：后台_加入到产品(加盟商)
	 * 用例编号：754
	 * @author 江渤洋
	 */
//	@Test(priority = 7)
	public void joinProduct(String loanAmount){
		System.out.println("翼企贷P1:后台_加入到产品");
		base.setup_ie_x86();
		base.drivermanage();
		
		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("风控管理");
		clientBackPage.clickSubMenu("债权池标");
		base.sleep(3000);
		//查询债权
		clientBackPage.selectDebt(clientBackPage.tenderThirdpartyIframe);
		//判断待初审借款列表是否有借款人姓名
		boolean isTrue = false;
		isTrue = clientBackPage.isSearchFieldByList(clientBackPage.tenderThirdpartyIframe, clientBackPage.tendThirdpartyByBorrowerName, borrowerName);
		//借款人存在
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
		//加入到产品
		clientBackPage.joinProduct(borrowerName, loanPurpose+loanAmount, passwordByBack);	
		
		base.tearDown();
	}
	
	/**
	 * 用例名称：后台_债权匹配(加盟商)
	 * 用例编号：754
	 * @author 江渤洋
	 */
//	@Test(priority = 8)
	public void debtOwnerMatching(String loanAmount){
		System.out.println("翼企贷P1:后台_债权匹配");
		base.setup_ie_x86();
		base.drivermanage();
		
		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("风控管理");
		clientBackPage.clickSubMenu("理财产品");
		//判断理财产品列表是否有标题
		boolean isTrue = false;
		isTrue = clientBackPage.isSearchFieldByList(clientBackPage.wmpsIframe, clientBackPage.wmpsListByTitle, loanPurpose+loanAmount);
		//标题存在
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
		//债权匹配
		clientBackPage.matchingBond(loanPurpose+loanAmount, passwordByBack);
		
		base.tearDown();
	}
	
	/**
	 * 用例名称：后台_总部终审(该步骤已经取消，但是集成环境代码被覆盖，可能出现该功能，故不做判断)
	 * 用例编号：754
	 * @author 江渤洋
	 */
//	@Test(priority = 9)
	public void finalJudgment(String loanAmount){
		System.out.println("翼企贷P1:后台_总部终审");
		base.setup_ie_x86();
		base.drivermanage();
		
		//加盟商登录
		clientBackPage.backLogin(clientBackURL, noticeCode, headquartersUserName2, passwordByBack);
		clientBackPage.clickFirstMenu("风控管理");
		clientBackPage.clickSubMenu("待终审借款列表");
		//总部终审
		clientBackPage.finalJudgment(borrowerName, loanAmount, passwordByBack);
		
		base.tearDown();
	}
	
	/**
	 * 用例名称：前台_用户确认
	 * 用例编号：754
	 * @author 江渤洋
	 */
//	@Test(priority = 10)
	public void userConfirm(String loanAmount){
		System.out.println("翼企贷P1:前台_用户确认");
		base.setup_ff();
		base.drivermanage();
		
		base.openBrowser(indexURL);
		indexPage.clickLoginLink();
		//借款人登录
		loginPage.loginWithXpath(borrowerPhone, password);
		//进入我的账户
		base.openBrowser(myAccountURL);
		base.sleep(3000);
		//进入我的借款
		myAccountPage.turnToMyAccount("我的借款");
		//进入已发布的借款
		myLoanPage.clickPublishedTab();
		//确认借款
		myLoanPage.confirmLoan(borrowerEmail, loanAmount);
		
		base.tearDown();
	}
	
	/**
	 * 用例名称：后台_确认交易(总部用户)
	 * 用例编号：754
	 * @author 江渤洋
	 */
	@Test(priority = 11)
	public void confirmTrading(String loanAmount){
		System.out.println("翼企贷P1:后台_确认交易(总部用户)");
		base.setup_ie_x86();
		base.drivermanage();
		
		clientBackPage.backLogin(clientBackURL, noticeCode, headquartersUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("风控管理");
		clientBackPage.clickSubMenu("待终审借款列表");
		//总部终审
		clientBackPage.finalJudgment(borrowerName, loanAmount, passwordByBack);
		//校验审核是否成功
//		clientBackPage.checkTenderState(borrowerName, loanAmount);
		
		base.tearDown();
	}
	
	/**
	 * 用例名称：前台_还款
	 * 用例编号：754
	 * @author 江渤洋
	 */
	public void repayment(String repaymentWay){
		base.setup_ff();
		base.drivermanage();
		
		base.openBrowser(indexURL);
		indexPage.clickLoginLink();
		//借款人登录
		loginPage.loginWithXpath(borrowerPhone, password);
		//进入我的账户
		base.openBrowser(myAccountURL);
		base.sleep(3000);
		
		myLoanPage.repayment(repaymentWay);
		
		base.tearDown();
	}
	
	/**
	 * 用例名称：后台_流标
	 * 用例编号：812
	 * @author 江渤洋
	 */
	public void tenderFail(){
		System.out.println("翼企贷P1:后台_流标");
		
		base.setup_ie_x86();
		base.drivermanage();
		
		clientBackPage.backLogin(clientBackURL, noticeCode, allianceBusinessUserName1, passwordByBack);
		clientBackPage.clickFirstMenu("风控管理");
		clientBackPage.clickSubMenu("待初审借款列表");
		//判断待初审借款列表是否有借款人姓名
		boolean isTrue = false;
		clientBackPage.selectLoan(clientBackPage.trialTendersIframe);
		isTrue = clientBackPage.isSearchFieldByList(clientBackPage.trialTendersIframe, clientBackPage.tendlistByBorrowerName, borrowerName);
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
		//流标
		clientBackPage.tenderFail(borrowerName, passwordByBack);
		
		base.tearDown();
	}
	
	/**
	 * 检查“扣除成交服务费”是否正确
	 * @param loanAmount：借款金额
	 */
	public void checkServiceCharge(String loanAmount){
		base.setup_ff();
		base.drivermanage();
		
		base.openBrowser(indexURL);
		indexPage.clickLoginLink();
		loginPage.loginWithXpath(borrowerPhone, password);
		//进入我的账户
		base.openBrowser(myAccountURL);
		base.sleep(3000);
		//进入交易记录
		myAccountPage.turnToMyAccount("交易记录");
		base.sleep(3000);
		//校验“扣除成交服务费”是否正确
		clientBackPage.checkServiceCharge(loanAmount, borrowerEmail);
		base.tearDown();
		
		//提前还清借款
		repayment("all");
	}
	
	/**
	 * 翼企贷P1准备数据
	 * @param loanAmount：借款金额
	 * @param timeLimit：借款期限
	 */
	public void dataPreparation(String loanAmount, String timeLimit){
		
		//前台_发布借款
//		issuedLoan(loanAmount, timeLimit);
//		//后台_审核已发布的借款
//		tendlistAuditLoan();
//		//后台_发布翼存宝
//		issuedECunBao(loanAmount);
		//前台_购买已发布翼存宝 和 后台_校验翼存宝状态
//		buyIssuedECunBao(loanAmount);
		//后台_加入债券池
		joinBond();
		//后台_加入到产品
		joinProduct(loanAmount);
		//后台_债权匹配
		debtOwnerMatching(loanAmount);
		//后台_总部终审(该流程已取消)
		//finalJudgment();
		//前台_用户确认
		userConfirm(loanAmount);
//		//后台_确认交易(总部用户)
//		confirmTrading(loanAmount);
	}
	
	/**
	 * 翼企贷P1准备数据
	 * 备注：需要修改发布时间，且在最后一步修改。否则会影响审核流程
	 * @param loanAmount：借款金额
	 * @param timeLimit：借款期限
	 * @param borrowerEmail：借款人邮箱
	 * @param publishedDate：标的发布日期增加相应天数
	 */
	public void dataPreparation(String loanAmount, String timeLimit, String borrowerEmail, String publishedDate){
		
		//前台_发布借款
		issuedLoan(loanAmount, timeLimit);
		//后台_审核已发布的借款
		tendlistAuditLoan();
		//后台_发布翼存宝
		issuedECunBao(loanAmount);
		//前台_购买已发布翼存宝 和 后台_校验翼存宝状态
		buyIssuedECunBao(loanAmount);
		//后台_加入债券池
		joinBond();
		//后台_加入到产品
		joinProduct(loanAmount);
		//后台_债权匹配
		debtOwnerMatching(loanAmount);
		//后台_总部终审(该流程已取消)
		//finalJudgment();
		//前台_用户确认
		userConfirm(loanAmount);
		//将当前标的发布时间改为上次还清的90天后
		clientBackPage.updatePublishedDate(borrowerEmail, loanAmount, publishedDate);
		//后台_确认交易(总部用户)
		confirmTrading(loanAmount);
	}
	
	/**
	 * 准备流标数据
	 * @param loanAmount：借款金额
	 * @param timeLimit：借款期限
	 */
	public void dataPreparationByTenderFail(String loanAmount, String timeLimit){
		//前台_发布借款
		issuedLoan(loanAmount, timeLimit);
		//后台_流标
		tenderFail();
	}
	
	/**
	 * 准备流标数据
	 * 备注：需要修改发布时间
	 * @param loanAmount：借款金额
	 * @param timeLimit：借款期限
	 * @param borrowerEmail：借款人邮箱
	 * @param publishedDate：标的发布日期增加相应天数
	 */
	public void dataPreparationByTenderFail(String loanAmount, String timeLimit, String borrowerEmail, String publishedDate){
		//前台_发布借款
		issuedLoan(loanAmount, timeLimit);
		//将当前标的发布时间改为上次还清的90天后
		clientBackPage.updatePublishedDate(borrowerEmail, loanAmount, publishedDate);
		//后台_流标
		tenderFail();
	}
	
}
