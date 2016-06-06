package com.eloancn.suites.myAccount;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ClientBackPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;

/**
 * 翼企贷P1
 * @author 江渤洋
 */
public class EQiDai_P1 {

	Base base = new Base();
	ClientBackPage clientBackPage = new ClientBackPage();
	LoginPage loginPage = new LoginPage();
	IndexPage indexPage = new IndexPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	EQiDai_P1_DataPreparation dataPreparation = new EQiDai_P1_DataPreparation();
	
	//发布借款的人邮箱
	String borrowerEmail = Data.borrowerEmail;
	//逾期日期(天数 * 24 * 3600)
	String overdueDay41 = "3542400";
	String overdueDay40 = "3456000";
	//标的发布日期增加相应天数
	String publishedDate91 = "7862400";
	String publishedDate90 = "7776000";
	//借款金额_前台  | 最大金额_后台 （前台金额>=后台金额，且为100的整数倍，10条数据内不可重复）
	String loanAmount = Data.loanAmount;
	String loanAmount2 = Data.loanAmount2;
	String loanAmount_Fail = Data.loanAmount_Fail;
//	//借款目的_前台  | 标题_后台（方便标示，前后台一致，格式：jby自动化+借款金额）
//	String loanPurpose = "自动化测试" + loanAmount;
	
	/**
	 * 用例名称：第一次借款6个月的费用(前台_检查借款人服务费)
	 * 用例编号：754
	 * @author 江渤洋
	 */
	@Test(priority = 1)
	public void borrowerServiceCharge_web_754(){
		Reporter.log("翼企贷_P1:第一次借款6个月的费用。扣除成交服务费：0.055%");
		
		//准备数据
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//修改优惠状态，确保是第一次借款
		clientBackPage.updatePreferentialState(borrowerEmail);
		//检查“扣除成交服务费”是否正确		
		dataPreparation.checkServiceCharge(loanAmount);
	}
	
	/**
	 * 第一次借款6个月并在还款时间的90天内，第二次借6个月的费用。扣除成交服务费：0.0325%
	 * 说明：A-B
	 * 用例编号：778
	 * @author 江渤洋
	 */
	@Test(priority = 2)
	public void borrowerServiceCharge_web_778(){
		Reporter.log("第一次借款6个月并在还款时间的90天内，第二次借6个月的费用。A-B。扣除成交服务费：0.0325%");
		
		//准备数据
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//检查“扣除成交服务费”是否正确		
		dataPreparation.checkServiceCharge(loanAmount);
	}
	

	/**
	 * 第一次借款12个月并在还款时间的90天内，第二次借6个月的费用。扣除成交服务费：0.055%
	 * 说明：A12月-B
	 * 用例编号：799
	 * @author 江渤洋
	 */
	@Test(priority = 3)
	public void borrowerServiceCharge_web_799(){
		Reporter.log("翼企贷_P1:借款12个月并在还款时间的90天内，第二次借6个月的费用。A12月-B。扣除成交服务费：0.055%");

		//准备数据
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_12);
		//修改优惠状态，确保是第一次借款
		clientBackPage.updatePreferentialState(borrowerEmail);
		//提前还清借款
		dataPreparation.repayment("all");
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6);
		//检查“扣除成交服务费”是否正确		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * 第一次借款6个月并在还款时间的90天内，第二次借12个月的费用。扣除成交服务费：0.055%
	 * 说明：A-B12月
	 * 用例编号：800
	 * @author 江渤洋
	 */
	@Test(priority = 4)
	public void borrowerServiceCharge_web_800(){
		Reporter.log("翼企贷_P1:借款6个月并在还款时间的90天内，第二次借12个月的费用。A-B12月。扣除成交服务费：0.055%");
		
		//准备数据
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//修改优惠状态，确保是第一次借款
		clientBackPage.updatePreferentialState(borrowerEmail);
		//提前还清借款
		dataPreparation.repayment("all");
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_12);
		//检查“扣除成交服务费”是否正确		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * 第一次借款12个月并在还款时间的90天内，第二次借12个月的费用。扣除成交服务费：0.055%
	 * 说明：A12月-B12月
	 * 用例编号：801
	 * @author 江渤洋
	 */
	@Test(priority = 5)
	public void borrowerServiceCharge_web_801(){
		Reporter.log("翼企贷_P1:借款12个月并在还款时间的90天内，第二次借12个月的费用。A12月-B12月。扣除成交服务费：0.055%");
		
		//准备数据
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_12);
		//修改优惠状态，确保是第一次借款
		clientBackPage.updatePreferentialState(borrowerEmail);
		//提前还清借款
		dataPreparation.repayment("all");
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_12);
		//检查“扣除成交服务费”是否正确		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * 第一次借款6个月逾期40天内还清借款，在还清的90天内继续借6个月的翼企贷借款
	 * 说明：A逾期40天内-B
	 * 用例编号：802
	 * @author 江渤洋
	 */
	@Test(priority = 6)
	public void borrowerServiceCharge_web_802(){
		Reporter.log("翼企贷_P1:第一次借款6个月逾期40天内还清借款，在还清的90天内继续借6个月的翼企贷借款。A逾期40天内-B。扣除成交服务费：0.0325%");
		
		//准备数据
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//修改优惠状态，确保是第一次借款
		clientBackPage.updatePreferentialState(borrowerEmail);
		//提前还清借款
		dataPreparation.repayment("all");
		//将标状态改为“逾期还款”,并在40天还清借款
		clientBackPage.updateRealDate(borrowerEmail, overdueDay40);
		//准备数据，将当前标的发布时间改为上次还清的90内
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6, borrowerEmail, publishedDate90);
		//检查“扣除成交服务费”是否正确		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * 第一次借款6个月逾期40天后还清借款（系统垫付），在还清的90天后继续借6个月的翼企贷借款
	 * 说明：A逾期40天后,B
	 * 用例编号：803
	 * @author 江渤洋
	 */
	@Test(priority = 7)
	public void borrowerServiceCharge_web_803(){
		Reporter.log("翼企贷_P1:第一次借款6个月逾期40天后还清借款（系统垫付），在还清的90天后继续借6个月的翼企贷借款。A逾期40天后,B。扣除成交服务费：0.055%");
		
		//准备数据
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//修改优惠状态，确保是第一次借款
		clientBackPage.updatePreferentialState(borrowerEmail);
		//提前还清借款
		dataPreparation.repayment("all");
		//将标状态改为“逾期还款”，并在41天还清借款
		clientBackPage.updateRealDate(borrowerEmail, overdueDay41);
		//准备数据，将当前标的发布时间改为上次还清的90外
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6, borrowerEmail, publishedDate91);
		//检查“扣除成交服务费”是否正确		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * 第一次借款6个月提前按月还款还清后，在还清的90天内继续借6个月的款
	 * 说明：A-B
	 * 用例编号：804
	 * @author 江渤洋
	 */
	@Test(priority = 8)
	public void borrowerServiceCharge_web_804(){
		Reporter.log("翼企贷_P1:第一次借款6个月提前按月还款还清后，在还清的90天内继续借6个月的款。A-B。扣除成交服务费：0.0325%");
		
		//准备数据
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//修改优惠状态，确保是第一次借款
		clientBackPage.updatePreferentialState(borrowerEmail);
		//提前还清借款
		dataPreparation.repayment("month");
		//准备数据，将当前标的发布时间改为上次还清的90内
		dataPreparation.dataPreparation(Data.loanAmount2, dataPreparation.timeLimit_6, borrowerEmail, publishedDate90);
		//检查“扣除成交服务费”是否正确		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * 第一次借款6个月后按月还款还清后，在还清的90天后继续借6个月的款-----------------------------------未通过
	 * 说明：A,B
	 * 用例编号：805
	 * @author 江渤洋
	 */
	@Test(priority = 9)
	public void borrowerServiceCharge_web_805(){
		Reporter.log("翼企贷_P1:第一次借款6个月后按月还款还清后，在还清的90天后继续借6个月的款。A,B。扣除成交服务费：0.055%");
		
		//准备数据
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//修改优惠状态，确保是第一次借款
		clientBackPage.updatePreferentialState(borrowerEmail);
		//提前还清借款
		dataPreparation.repayment("month");
		//准备数据，将当前标的发布时间改为上次还清的90外
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6, borrowerEmail, publishedDate91);
		//检查“扣除成交服务费”是否正确		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * 第一次借款6个月并在还款的90天内，第二次借6个月后流标，再发布6个月的借款-----------------------------------未测试
	 * 说明:A-B流-C
	 * 用例编号：812
	 * @author 江渤洋
	 */
	@Test(priority = 10)
	public void borrowerServiceCharge_web_812(){
		Reporter.log("翼企贷_P1:第一次借款6个月并在还款的90天内，第二次借6个月后流标，再发布6个月的借款。A-B流-C。扣除成交服务费：0.0325%");
		
		//准备数据
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//修改优惠状态，确保是第一次借款
		clientBackPage.updatePreferentialState(borrowerEmail);
		//提前还清借款
		dataPreparation.repayment("month");
		//发标，并流标
		dataPreparation.dataPreparationByTenderFail(loanAmount_Fail, dataPreparation.timeLimit_6);
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6);
		//检查“扣除成交服务费”是否正确		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
	
	/**
	 * 第一次借款6个月并在还款的90天后，第二次借6个月后流标，再发布6个月的借款-----------------------------------未测试
	 * 说明：A,B流-C
	 * 用例编号：813
	 * @author 江渤洋
	 */
	@Test(priority = 11)
	public void borrowerServiceCharge_web_813(){
		Reporter.log("翼企贷_P1:第一次借款6个月并在还款的90天后，第二次借6个月后流标，再发布6个月的借款。A,B流-C。扣除成交服务费：0.055%");
		
		//准备数据
		dataPreparation.dataPreparation(loanAmount, dataPreparation.timeLimit_6);
		//修改优惠状态，确保是第一次借款
		clientBackPage.updatePreferentialState(borrowerEmail);
		//提前还清借款
		dataPreparation.repayment("month");
		//发标，并流标
		dataPreparation.dataPreparationByTenderFail(loanAmount_Fail, dataPreparation.timeLimit_6, borrowerEmail, publishedDate91);
		dataPreparation.dataPreparation(loanAmount2, dataPreparation.timeLimit_6, borrowerEmail, publishedDate91);
		//检查“扣除成交服务费”是否正确		
		dataPreparation.checkServiceCharge(loanAmount2);
	}
}
