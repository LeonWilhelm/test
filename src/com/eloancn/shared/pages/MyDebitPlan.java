package com.eloancn.shared.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.*;
import com.eloancn.shared.model.DWutGuaranteeModel;

/**
 * 我的账户--翼星计划--我的借入计划
 */
public class MyDebitPlan {
	
	Base base = new Base();
	
	MyAccountPage myAccountPage = new MyAccountPage();
	
	public static By LoanPart = By.id("_content");											//“我的借入计划”内容
	
	By BorrowTop = By.xpath("//div[@id='_content']/div/div/div[*]/h3");						//“累计借入”，“待还总额”，“逾期总额”
	By BorrowStatisticLnk = By.id("investmentStatisticsForWut");							//"借入统计"
	By RechargeLnk = By.cssSelector("a.h30.textD");											//"充值"
	By applyCreditBtn =By.xpath(".//*[@id='_content']//a[text()='申请贷款']");					//"申请贷款"按钮
	By PerfectInfoLnk = By.xpath("//div[@id='_content']/div/div[2]/div/span[2]/a");			//“完善资料”链接
	By ApplyNeedLnks = By.cssSelector("#_content>div>div.starplan_brror_topR>div>span");	//"申请贷款"下面的4个链接
	public static By ListContent = By.id("tabList0");														//列表内容
	By subTabs = By.cssSelector("#_content>div.main-b.mt10>div>span");						//5个tab:"正在还款的借款","已全部还清的借款"...
	By RepayingLoanLnk = By.id("repaying");													//“正在还款的借款”
	By RepayedLoanLnk = By.id("repayed");													//“已全部还清的借款”
	public static By PublishedLoanLnk = By.id("published");									//“已发布的借款”
	public static By PublishingLoanLnk = By.id("publishing");								//“尚未发布的借款”
	By PublishingLoanLnk1 = By.cssSelector("span.wd160.current");
	By CollateralDealLoanLnk = By.id("collateralDeal");										//“抵押物处理的借款”
	
	//“完善资料”页面
	By BasicInfoTxt = By.id("info0");														//“基本资料”
	public static By AgeTxt = By.id("age");													//“年龄”显示
	
	//“申请贷款”页面
	By BorrowPage = By.id("borrowed");														//“申请贷款”详情页
	By voucherTxt =By.id("voucher");														//邀请码				
	By amountTxt =By.id("amount");															//借款金额
	By borrowerTypeSel =By.id("borrowertype");												//借入者类型
	By QiYeType = By.xpath("//select[@id='borrowertype']/option[2]");						//借入者：企业
	By QYTip = By.xpath("//tr[@id='showEnterpriseMaterials']/td/div/div/p");				//企业类型的提示
	By FillInQYInfoLnk = By.cssSelector("#showEnterpriseMaterials>td>div.pub_tip.fl>div>p>a.colorG");//"填写企业信息"链接	
	By phasesSel =By.id("phases");															//借款期限	
	By ThreeMonth = By.xpath("//select[@id='phases']/option[2]");							//3个月期限
	By Interest = By.id("interestrate");													//最高年利率
	By ManBiaoRadio = By.id("mode1");														//"满标"单选框
	By HBFXRadio = By.id("fx");																//“还本付息”单选框
	By usetypeSel =By.id("usetype");														//借款类型	
	By BusinessZZ = By.xpath("//select[@id='usetype']/option[3]");							//借款类型：生意周转
	By purposeTxt =By.id("purpose");														//借款目的	
	By phoneTxt = By.id("mobile");															//联系电话
	By mailTxt = By.id("email");															//联系邮箱
	By addBtn = By.xpath("//input[@value='添加']");											//“添加”按钮（在后保证人）
	By baoZhengRenDiv = By.xpath("//div[@class='lywrap' and @style='width:560px;']");		//“添加在后保证人”DIV
	By baoZhengRenSel = By.id("GuaranteeType");												//在后保证人类型
	By baoZhengRen_zrr_name = By.id("nor_name");											//自然人_“姓名”文本框
	By baoZhengRen_zrr_idCard = By.id("nor_idcard");										//自然人_“身份证号”文本框
	By baoZhengRen_zrr_household = By.id("nor_addr");										//自然人_“户籍地址”文本框
	By baoZhengRen_zrr_address = By.id("nor_curr_addr");									//自然人_“现住所地址”文本框
	By baoZhengRen_zrr_tel = By.id("nor_mobile");											//自然人_“联系电话”文本框
	By baoZhengRen_zrr_mail = By.id("nor_email");											//自然人_“联系邮箱”文本框
	By baoZhengRen_zrr_saveBtn = By.xpath("//div[@id='saveoredit']//input[@value='保存']");	//自然人_保存按钮
	By baoZhengRen_zrr_cancelBtn = By.xpath("//div[@id='saveoredit']//input[@value='取消']");	//自然人_取消按钮
	By baoZhengRen_closeBtn = By.xpath("//div[@id='addBondsman']//a");						//关闭按钮
	By baoZhengRen_fr_name = By.id("lay_name");												//法人_名称（公司名称）
	By baoZhengRen_fr_deputy = By.id("lay_layer");											//法人_法定代表人
	By baoZhengRen_fr_address = By.id("lay_addr");											//法人_地址（公司地址）
	By baoZhengRen_fr_tel = By.id("lay_mobile");											//法人_联系电话（公司电话）
	By baoZhengRen_fr_mail = By.id("lay_email");											//法人_联系邮箱（公司邮箱）
	By baoZhengRen_fr_saveBtn = By.xpath("//div[@id='GuaranteeLayer']//input[@value = '保存']");//法人_保存按钮
	By baoZhengRen_fr_cancelBtnBy = By.xpath("//div[@id='GuaranteeLayer']//input[@value = '取消']");//法人_取消按钮
	By detaildescriptionTxt =By.id("detaildescription");									//描述信息
	By releaseBtn =By.id("releaseButton");													//发布
	By SavePreviewBtn = By.id("createButton");												//保存预览

	//弹出的“企业标信息”
	By QYBidInfoTitle = By.cssSelector("h2.u-tt");											//"企业标信息"标题
	By InputQiYeName = By.id("enterpriseName");												//“公司名称”输入框
	By InputQiYeAddress = By.id("enterpriseAddress");										//“公司地址”输入框
	By InputQiYefoundedtime = By.id("foundedtime");											//“成立时间”输入框
	By InputQiYeReferrerName =By.id("enterpriseReferrername");								//“债权推荐人名称”输入框
	By ReferrerNameTipTxt = By.id("referrernameDiv");										//输入“债权推荐人名称”的提示信息
	By InputQiYeReferrerIntro = By.id("enterpriseReferrerintro");							//“债权推荐人简介”输入框
	By ReferrerIntroTipTxt = By.id("referrerintroDiv");										//输入“债权推荐人简介”的提示信息
	By InputQiYeBusiness = By.id("enterpriseBusiness");										//“经营范围”输入框
	By InputQiYeRegisteredAmount = By.id("registeredamount");								//“注册金额”输入框
	By RegisterAmountTipTxt = By.id("registeredamountDiv");									//输入“注册金额”的提示信息
	By InputQiYeInvestAmount = By.id("investmentamount");									//“实缴金额”输入框
	By InputQiYeBusinessState = By.id("businessperformance");								//“经营状况”输入框
	By InputQiYeUseType = By.id("enterpriseusetype");										//“借款用途”输入框
	By InputQiyeRepaySource = By.id("repaysource");											//“还款来源”输入框
	By InputQiyeCounterSecurity = By.id("countersecurity");									//“反担保措施”输入框
	By InputQiyeSafeGuard = By.id("safeguard");												//“保障措施”输入框
	By InputQiyeSafeGuardReason = By.id("safeguardreason");									//“担保意见”输入框
	By QiYeSaveBtn = By.id("addButton");													//“保存”按钮
	By QiYeCancelBtn = By.id("canclButton");												//“取消”按钮
	
	//查询信息
	By SearchByTimeTxt = By.cssSelector("#form > span");									//"按时间查找" 
	By BeginDate = By.id("begindate");														//开始时间控件
	By EndDate = By.id("enddate");															//结束时间控件
	By SearchBtn = By.cssSelector("input.time_submit");										//“查询”按钮
	By ClearBtn = By.cssSelector("input.time_clear");										//“清空”按钮

	//“尚未发布的借款”借款标信息
	By LoanHead = By.cssSelector("#_content_child>table>thead");							//借款标列表的标题
	By NoPublishedLoanTxt = By.cssSelector("#_content_child>table>tbody");					//借款的内容（无借款或有借款）
	public static By FirstBidType = By.xpath("//div[@id='_content_child']/table/tbody/tr/td[7]");	//第一条标类型
	By BidTypes = By.xpath("//div[@id='_content_child']/table/tbody/*/td[9]");				//所有标的类型
	By LoanPurposeLnk = By.cssSelector("a.colorF8");										//第一条标的借款目的
	public By LoanAmount = By.cssSelector("td.colorG");											//第一条标的借款金额
	By Lines = By.cssSelector("#_content_child>table.global_table>tbody>tr");				//借款标条数
	By BorrowInfo = By.cssSelector("#_content_child>table>tbody>tr>td");					//第一条借款标信息
	By PreviewLnk = By.cssSelector("a.colorG");												//预览
	By PublishLnk = By.xpath("//div[@id='_content_child']/table/tbody/tr/td[9]/a[3]");		//发布
	//已发布的借款标
	By StatusTxt = By.xpath("//div[@id='_content_child']/table/tbody/tr/td[6]");			//第一条借款标的状态
	By ResultTxt = By.xpath("//div[@id='_content_child']/table/tbody/tr/td[10]");			//第一条借款标的状态/结果
	By FourthPageLnk = By.xpath("//div[@id='Pagination']/ul/li[4]");						//页数的第4个链接
	By LastPage = By.xpath("//div[@id='Pagination']/ul/li[text()='末页']");
	By LastTwoPage = By.xpath("//div[@id='Pagination']/ul/li[last()-2]");
	By FirstPage = By.xpath("//div[@id='Pagination']/ul/li[text()='首页']");
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");
	By LastPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");						    //页数的第6个链接
	By AllPaginationLnk = By.xpath("//div[@id='Pagination']/ul/li");						//页数
	
	//"正在还款的借款"
	By OverdueTxt = By.cssSelector("div.showOverDueDiv.font14");							//逾期
	By RechargeLnk1 = By.cssSelector("dd.wd80 > a");										//“充值”链接
	By FirstRepayLoan = By.id("_content_child");											//"正在还款的借款"/"已全部还清的借款"中的第一条标或无标时提示
	By LoanLnks = By.cssSelector("#_content_child>div.mt15>div.lending_record>a");			//借款目的，一次性还清，借款详情，查看下载电子借条链接
	public By LoanDetailLnk = By.xpath("//div[@id='_content_child']/div/div/a[3]");				//“借款详情”链接
	By RepayingIOULnk = By.xpath("//div[@id='_content_child']/div/div/a[4]");			    //“查看下载电子借条”链接
	By LoanInfos = By.cssSelector("ul.record_info>li");										//借款金额，年利率，期数等
	By QiShuTxt = By.xpath("//div[@id='_content_child']/div/div[2]/ul/li[3]");				//期数
	By RepayList = By.cssSelector("table.record_table");									//点击借款目的后弹出的还款详情
	By FirstRepayTime = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/tr/td[2]"); //第一期还款日期
	By QiShuList = By.xpath("//div[@id='_content_child']/div[1]/div[2]/table/tbody/tr");	//列表中的期数
	By Status = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/*/td[6]");		//状态
	By RepayBJ = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/*/td[3]");	//应还本金
	By RepayLX = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/*/td[4]");	//应还利息
	By RealBX = By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/*/td[5]");		//实还本息
	
	//“已全部还清的借款”
	By RepayedIOULnk = By.xpath("//div[@id='_content_child']/div/div/a[2]");			//“查看下载电子借条”链接
	
	//借款列表
	By repayingTab = By.cssSelector("#repaying");                                                             //“正在还款的借款”Tab
	By loanList = By.cssSelector(".mt15");                                                                    //借款列表
	By loanListByFirst = By.cssSelector("#_content_child > div.mt15");                           			  //借款列表第一条数据
	By disposablePayOff = By.cssSelector(".lending_record > a:nth-child(2)");                                 //还清链接
	By disposablePayOffByFirst = By.cssSelector("#_content_child > div:nth-child(4) > div > a:nth-child(2)"); //还清链接第一条数据_还款
	By notPaidMoney = By.xpath("//div[@id='_content_child']//span[@class='colorG']");                         //还清链接第一条数据_未还金额	
	By outAllWindow = By.cssSelector("#out_all");                                                             //还款确认弹出框
	By balanceByWindow = By.cssSelector("#balancediv");                                                       //账户余额
	By theWay = By.cssSelector("#allrepay>label");                                                            //还款方式
	By iNeedRecharge = By.cssSelector("span#balancediv~a");                                                   //还款确认窗口_我要充值
	By monthRdo = By.xpath("//input[@id='month']");															  //还款确认窗口_每月还款
	By disposablePayOffByWindow = By.cssSelector("#allrepay>label");                                          
	By allRdo = By.xpath("//input[@id='all']");																  //还款确认窗口_提前一次性还清
	By advanceRdo = By.xpath("//input[@id='advance']");														  //还款确认窗口_“请输入您要偿还的本金”单选按钮 
	By cancelBtn = By.cssSelector(".RT_cancel");                                                              //还款确认窗口_取消按钮
//	By okBtn = By.cssSelector("#repayButtonSubmit");                                                          
	By okBtn = By.xpath("//button[@id='repayButtonSubmit']");												  //还款确认窗口_确认按钮
	By rechargeDiv  = By.cssSelector(".g-main-c");		                                                      //充值DIV
	
	//检查“我的借入计划”页面的数据
	public void checkDatainPage(){
		String [] TopTxt = {"累计借入","待还总额","逾期总额"};
		List<WebElement> BorrowTops = base.getElements(BorrowTop);
		base.assertEqualsActualExpected(base.getElementTextWithWait(BorrowStatisticLnk), "借入统计");
		base.assertEqualsActualExpected(base.getElementTextWithWait(RechargeLnk), "充值");
		base.assertEqualsActualExpected(base.getElementTextWithWait(applyCreditBtn), "申请贷款");
		String [] lnks = {"材料上传","完善资料","查看视频","开通代扣功能"};
		List<WebElement> BorrowLnks = base.getElements(ApplyNeedLnks);
		String [] tabs = {"正在还款的借款","已全部还清的借款","已发布的借款","尚未发布的借款","抵押物处理的借款"};
		List<WebElement> Tab = base.getElements(subTabs);
		for(int i=0;i<3;i++){
			base.assertEqualsActualExpected(BorrowTops.get(i).getText(),TopTxt[i]);
			base.assertEqualsActualExpected(BorrowLnks.get(i).getText(),lnks[i]);
			base.assertEqualsActualExpected(Tab.get(i).getText(),tabs[i]);
		}
		base.assertEqualsActualExpected(BorrowLnks.get(3).getText(),lnks[3]);
		base.assertEqualsActualExpected(Tab.get(3).getText(),tabs[3]);
		base.assertEqualsActualExpected(Tab.get(4).getText(),tabs[4]);
		base.assertEqualsActualExpected(base.getElementTextWithWait(SearchByTimeTxt),"按时间查找");
		base.checkElement(BeginDate);
		base.checkElement(EndDate);
		base.assertEqualsActualExpected(base.getLnkElementText(SearchBtn, "value"), "查询");
		base.assertEqualsActualExpected(base.getLnkElementText(ClearBtn, "value"), "清空");
	}
	//集成环境：申请企业贷款
	public void ApplyforQiYeLoan(String amount,String borrowertype,String phase,String type,String purpose){
		new MyAccountPage().clickMyDebitPlanLnk();
		clickShenQingDaiKuan();
		if(base.indexURL.contains("/client")||base.indexURL.contains("inclient")){
			InputRefereeInviteCode("ElWut1058");
		}else if(base.indexURL.contains("test")||base.indexURL.contains("www")){
			InputRefereeInviteCode("ElWut1001");
		}
		InputBorrowMoney(amount);
		selectBorrowerType(borrowertype);
		if(borrowertype.equals("企业")){
			clickFillInQYInfoLnk();
			ImproveQYBidInfo();
		}
		selectBorrowPhase(phase);
		selectBorrowType(type);
		InputBorrowPurpose(purpose);

		InputDescription();
		clickSavePreviewBtn();
	}
	public void ApplyforQiYeLoan(String amount, String borrowertype, String phase, String type, String purpose, String phone, String mail, DWutGuaranteeModel baoZhengRenZrr, DWutGuaranteeModel baoZhengRenFr){
		new MyAccountPage().clickMyDebitPlanLnk();
		clickShenQingDaiKuan();
		if(base.indexURL.contains("/client")||base.indexURL.contains("inclient")){
			InputRefereeInviteCode("ElWut1058");
		}else if(base.indexURL.contains("test")||base.indexURL.contains("www")){
			InputRefereeInviteCode("ElWut1001");
		}
		InputBorrowMoney(amount);
		selectBorrowerType(borrowertype);
		if(borrowertype.equals("企业")){
			clickFillInQYInfoLnk();
			ImproveQYBidInfo();
		}
		selectBorrowPhase(phase);
		selectBorrowType(type);
		InputBorrowPurpose(purpose);
		inputPhone(phone);
		inputMail(mail);
		clickAddBtn();
		inputBaoZhengRenInfo(baoZhengRenZrr);
		clickAddBtn();
		inputBaoZhengRenInfo(baoZhengRenFr);
		InputDescription();
		clickSavePreviewBtn();
	}
	/**
	 * 徐天元
	 * 点击“申请贷款”
	 */
	public void clickShenQingDaiKuan(){
		base.clickWithWait(applyCreditBtn);
		base.checkElementVisible(BorrowPage);
	}
	//点击“完善资料”链接
	public String clickPerfectInfoLnk(){
		base.clickWithWait(PerfectInfoLnk);
		base.checkElement(BasicInfoTxt);
		String Age = base.getLnkElementText(MyDebitPlan.AgeTxt, "value");
		return Age;
	}
	/**
	 * 徐天元
	 * 申请贷款
	 */
	public void shenQingDaiKuan(String amount,String borrowerType,String phases,String usetype,String purpose,String descrition){
		//邀请码
		if (base.indexURL.contains("www") || base.indexURL.contains("test")) {
			base.sendKeysWithWait(voucherTxt, "ElWut1001");
		}else {
			base.sendKeysWithWait(voucherTxt, new DBData().getVoucherCode());
		}
		base.sleep(1000);
		base.sendKeysWithWait(amountTxt, amount);
		base.sleep(1000);
		base.elementSelectByVisibleText(borrowerTypeSel, borrowerType);
		base.sleep(1000);
		base.elementSelectByVisibleText(phasesSel, phases);
		base.sleep(1000);
		base.elementSelectByVisibleText(usetypeSel, usetype);
		base.sleep(1000);
		base.sendKeysWithWait(purposeTxt, purpose);
		base.sleep(1000);
		base.sendKeysWithWait(detaildescriptionTxt, descrition);
		base.sleep(1000);
		base.clickWithWait(releaseBtn);
	}
	
	/**
	 * 徐天元
	 * 验证申请贷款成功
	 */
	public void isShenQingDaiKuanOK(){
		try {
			base.sleep(3000);
			Alert alert = base.getAlert();
			base.sleep(3000);
			base.assertEqualsActualExpected(alert.getText(), "发布成功，等待初步审核，谢谢！");
			alert.accept();
		} catch (Exception e) {
		}
	}
	//点击“正在还款的借款”选项
	public boolean clickRepayingLoanLnk(){
		base.clickWithWait(RepayingLoanLnk);
		base.checkElmentText(PublishingLoanLnk1, "正在还款的借款");
		if(base.getElementTextWithWait(FirstRepayLoan).equals("您目前还没有“正在还款的借款”！")){
			return false;
		}else{
			return true;
		}
	}
	//检查是否有逾期的借款
	public boolean ifshowOverdueLoan(){
		
		return base.isElementPresent(OverdueTxt);
	}
	//点击“借款详情”链接
	public String[] clickLoanDetailLnk(){
		base.clickWithWait(LoanDetailLnk);
		base.jumpToNewWindow();
		String time = base.getElementTextWithWait(EStarPlanLoanDetailPage.BidFullTime);//2015-09-01
		String title = base.getElementTextWithWait(EStarPlanLoanDetailPage.BorrowTypeAndTitleTxt).split("】 ")[1];
		String borrowmoney = base.getElementTextWithWait(EStarPlanLoanDetailPage.BorrowMoney);
		String Rate = base.getElementTextWithWait(EStarPlanLoanDetailPage.Rate);
		String phase = base.getElementTextWithWait(EStarPlanLoanDetailPage.Phase);
		base.closeAndjumptoOldWindow();
		String data[]={time,title,borrowmoney,Rate,phase};
		return data;
	}
	//检查“正在还款的借款”的标信息
	public void checkRepayingLoanInfo(String borrow[]){

		String [] links = {borrow[1],"一次性还清","借款详情","查看下载电子借条"};
		List<WebElement> Lnks = base.getElements(LoanLnks);
		for(int i =0;i<4;i++){
			base.assertEqualsActualExpected(Lnks.get(i).getText(), links[i]);
		}
		String qishu,day = borrow[0].split("-")[2];
		if(day == "21"){
			qishu = borrow[4];
		}else{
			qishu = String.valueOf(Integer.parseInt(borrow[4])+1);
		}
		double borrowmoney=0; 
//		if(borrow[2].contains(",")){
		borrowmoney= Double.parseDouble(borrow[2].replace(",", ""));
//		}
		double RepayBXEachMonth= Double.parseDouble(base.roundMoney(borrowmoney*Double.parseDouble(borrow[3])/1200));//1012.27
		String ShouldRepayBX = base.roundingMoney(borrowmoney+RepayBXEachMonth*Integer.parseInt(borrow[4]));
		List<WebElement> status = base.getElements(Status);
		List<WebElement> repayBJ = base.getElements(RepayBJ);
		List<WebElement> repayLX = base.getElements(RepayLX);
		double RealPay=0,receivingPay=0;//实还本息,未还金额
		for(int i=0;i<Integer.parseInt(qishu);i++){
			String bj= repayBJ.get(i).getText().substring(1);
			String lx = repayLX.get(i).getText().substring(1);
//			if(bj.contains(",")){
				bj= bj.replaceAll(",", "");
//			}
//			if(lx.contains(",")){
				lx=lx.replaceAll(",", "");
//			}
			double bx= Double.parseDouble(bj)+Double.parseDouble(lx);
			if(status.get(i).getText().equals("已还")){
				RealPay= RealPay+bx;
			}else if(status.get(i).getText().equals("待还")){
				receivingPay=receivingPay+bx;
			}
		}
		
		String [] Infos = {"借款金额: ￥"+borrow[2],"年利率: "+borrow[3]+"%","期数: "+qishu,"应还本息: ￥"+ShouldRepayBX,"实还本息: ￥"+base.cutMoney(RealPay),"未还金额:￥"+base.roundingMoney(receivingPay)};
		List<WebElement> info = base.getElements(LoanInfos);
		for(int i=0;i<6;i++){
			base.assertEqualsActualExpected(info.get(i).getText(), Infos[i]);
		}
	}
	//点击“正在还款的借款”中的逾期“充值”链接
	public void clickOverdueRechargeLnk(){
		base.clickWithWait(RechargeLnk1);
		if(base.isElementVisible(RechargePage.OnlineRechargeTxt)){
			base.assertEqualsActualExpected(base.getElementText(RechargePage.OnlineRechargeTxt),"网银充值");
		}else{
			base.assertEqualsActualExpected(base.getElementText(RechargePage.ImproveProfileTxt),"完善个人身份信息");
			new RechargePage().closeInfo();
		}
	}
	//检查逾期数据和链接
	public void checkOverdue(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(OverdueTxt), "您的账户出现逾期\n请及时 充值");
		clickOverdueRechargeLnk();
	}
	//点击“已全部还清的借款”选项
	public boolean clickRepayedLoanLnk(){
		base.clickWithWait(RepayedLoanLnk);
		base.checkElmentText(PublishingLoanLnk1, "已全部还清的借款");
		if(base.getElementTextWithWait(FirstRepayLoan).equals("您目前还没有“已全部还清的借款”！")){
			return false;
		}else{
			return true;
		}
	}
	//点击“借款目的”
	public String clickLoanPurpose(){
		base.clickWithWait(LoanLnks);
		base.checkElementVisible(RepayList);
		String RepayTime = base.getElementTextWithWait(FirstRepayTime);
		String RealTime = RepayTime.split("/")[0];//实还款日期
		return RealTime;
	}
	//获取实还本息
	public String getRealPayMoney(){
		int qishu=Integer.parseInt(base.getElementTextWithWait(QiShuTxt).substring(4));
		List<WebElement> real = base.getElements(RealBX);
		double amount=0;
		for(int i=0;i<qishu;i++){
			String pay = real.get(i).getText().substring(1);
//			if(pay.contains(",")){
				pay=pay.replaceAll(",", "");
//			}
			amount=amount+Double.parseDouble(pay);
		}
		return base.cutMoney(amount);
	}
	//点击"已全部还清的借款"中的"查看下载电子借条"链接
	public String clickRepayedIOULnk(){
			
		base.clickWithWait(RepayedIOULnk);
		base.jumpToNewWindow();
		base.checkTitle("电子借条");
		String Amount = base.getElementTextWithWait(ElectronicIOU.BorrowAmountTxt);
		String time = Amount.substring(Amount.indexOf("自")+2, Amount.indexOf("日")).trim();//计息日：2015年09月01
		base.closeAndjumptoOldWindow();
		return time;
	}
	//检查“已全部还清的借款”的标信息
	public void checkRepayedLoanInfo(String time){
		String qishu;
		String day = time.substring(time.indexOf("月")+1).trim();
		time = time.replaceAll("[^0-9]", "-");
		if(day == "21"){
			qishu = "3";
		}else{
			qishu = "4";
		}
		String realmoney=getRealPayMoney();
//		int chaday = base.daysBetween(time, RepayTime)+1;
//		double lixi = 10000*0.101/base.getDaysOfYear(2015)*chaday;
//		String benxi = base.intMoney(lixi+10000);
		base.assertEqualsActualExpected(base.getElementTextWithWait(LoanLnks), "自动化测试使用");
		String [] Infos = {"借款金额: ￥10,000","年利率: 10.10%","期数: "+qishu,"应还本息: ￥10,252.51","实还本息: ￥"+realmoney,"未还金额:￥0"};
		List<WebElement> info = base.getElements(LoanInfos);
		for(int i=0;i<6;i++){
			base.assertEqualsActualExpected(info.get(i).getText(), Infos[i]);
		}
	}
	//检查“已全部还清的借款”中的还款列表
	public void checkRepayList(String RepayTime,String time){
		String qishu = base.getElementTextWithWait(QiShuTxt).split(":")[1].trim();
		List<WebElement> qishus = base.getElements(QiShuList);
		int size = qishus.size();
		base.assertEqualsActualExpected(String.valueOf(size), qishu);
//		for(int i =0;i<size;i++){
//			base.assertEqualsActualExpected(base.getElementText(By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/tr["+(i+1)+"]/td")), String.valueOf(i+1));
//		}
		String days = time.substring(time.indexOf("月")+1).trim();
		int day = Integer.valueOf(days);
		time = time.replaceAll("[^0-9]", "-");//2015-09-01
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM"); 
		try {
			cal.setTime(df.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String currentDate = date.format(cal.getTime());//2015-09
		cal.add(Calendar.MONTH, 1);
		String nextDate= date.format(cal.getTime());//下个月时间	
		cal.add(Calendar.MONTH, 1);
		String next2Date = date.format(cal.getTime());//下下个月
		cal.add(Calendar.MONTH, 1);
		String next3Date = date.format(cal.getTime());//下下下个月	
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String next4Date = df.format(cal.getTime());//下下下个月的前一天	
		String [] timelist1 = {RepayTime+"/"+currentDate+"-20",RepayTime+"/"+nextDate+"-20",RepayTime+"/"+next2Date+"-20",RepayTime+"/"+next4Date};
		String [] timelist2 = {RepayTime+"/"+nextDate+"-20",RepayTime+"/"+next2Date+"-20",RepayTime+"/"+next3Date+"-20",RepayTime+"/"+next4Date};
		
		int chaday = base.daysBetween(time, RepayTime)+1;//提前还款和计息日差的天数
		int chaday2 =0;
		String [] timelist = null;
		if(1<=day&& day<21){
			chaday2= base.daysBetween(time, currentDate+"-20")+1;//计息日和计划的第一个还款日期差的天数
			timelist= timelist1;
		}else if(21<day && day<=31){
			chaday2= base.daysBetween(time,nextDate+"-20")+1;
			timelist=timelist2;
		}
		double SHlixi = 10000*0.101/365*chaday;
		double Planlixi = 10000*0.101/365*chaday2;
		String SHbenxi = base.intMoney(SHlixi);
		String PlanInterest = base.intMoney(Planlixi);
		String PlanlastInterest = base.intMoney(84.17-Planlixi);
		String [][] List1 ={{"1","2","3"},{RepayTime+"/"+nextDate+"-20",RepayTime+"/"+next2Date+"-20",RepayTime+"/"+next3Date+"-20"},{"￥0","￥0","￥10,000"},{"￥84.17","￥84.17","￥84.17"},{"￥"+SHbenxi,"￥0","￥10,000"},{"提前还款","提前还款","提前还款"}};
		String [][] List2 ={{"1","2","3","4"},timelist,{"￥0","￥0","￥0","￥10,000"},{"￥"+PlanInterest,"￥84.17","￥84.17","￥"+PlanlastInterest},{"￥"+SHbenxi,"￥0","￥0","￥10,000"},{"提前还款","提前还款","提前还款","提前还款"}};
		String [][] Plans;
		if(day == 21){
			Plans = List1;
		}else{
			Plans = List2;
		}
		for(int i=1;i<6;i++){
			for(int j=1;j<size;j++){
				base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='_content_child']/div/div[2]/table/tbody/tr["+j+"]/td["+i+"]")), Plans[i-1][j-1]);
			}
		}
	}
	
	//点击“尚未发布的借款”选项
	public boolean clickPublishingLoanLnk(){
		base.clickWithWait(PublishingLoanLnk);
		base.checkElmentText(PublishingLoanLnk1, "尚未发布的借款");
		if(base.isElementPresent(LoanHead)){
//			base.assertTrueByBoolean(base.isElementPresent(Lines));
			base.checkElmentText(BorrowInfo, "1");
			return true;
		}else{
			base.assertEqualsActualExpected(base.getElementTextWithWait(NoPublishedLoanTxt), "您目前还没有“尚未发布的借款”！");
			return false;
		}
	}
	
	//点击“已发布的借款”选项并返回借款数量
	public boolean clickPublishedLoanLnk(){
		base.clickWithWait(PublishedLoanLnk);
		base.checkElmentText(PublishingLoanLnk1, "已发布的借款");
		if(base.getElementTextWithWait(NoPublishedLoanTxt).equals("您目前还没有“已发布的借款”！")){
			return false;
		}else{
			return true;
		}
//		if(base.isElementPresent(LoanHead)){
//			base.checkElmentText(BorrowInfo, "1");
//			return true;
//		}else{
//			base.assertEqualsActualExpected(base.getElementText(NoPublishedLoanTxt), "您目前还没有“已发布的借款”！");
//			return false;
//		}
	}
	//获得“已发布的借款”的总数
	public int getNumofAllLoan(){

		if(base.getElementTextWithWait(NoPublishedLoanTxt).equals("您目前还没有“已发布的借款”！")){
			return 0;
		}else if(base.getElementTextWithWait(NoPublishedLoanTxt).equals("您目前还没有“尚未发布的借款”！")){
			return 0;
		}else{
			if(base.getElementTextWithWait(FourthPageLnk).equals(">")){
				return base.getElements(Lines).size();
			}else{
				base.clickWithWait(LastPage);
				base.checkElementVisible(LastTwoPage);
				int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
				int NuminLastPage= base.getElements(Lines).size();
				base.clickWithWait(FirstPage);
				base.checkElmentText(CurrentPage, "1");
				return (lastPageNum-1)*10+NuminLastPage;
			}
		}
	}
	//第一条翼星计划标是否是企业标
	public boolean ifFirstBidisQiYeBid(){
		if(base.getElementTextWithWait(FirstBidType).equals("企业-翼星计划标")){
			return true;
		}else{
			return false;
		}
	}
	//是否有“企业-翼星计划标”
	public boolean ifShowQYBid(){
		
		Boolean result = false;
		List<WebElement> Bidtypes = base.getElements(BidTypes);
		int size = Bidtypes.size();
		for(int i=0;i<size;i++){
			if(Bidtypes.get(i).getText().equals("企业-翼星计划标")){
				base.clickWithWait(By.xpath("//div[@id='_content_child']/table/tbody/tr["+(i+1)+"]/td[2]/a"));
				base.jumpToNewWindow();
				base.checkElement(EStarPlanLoanDetailPage.LoanInfoonTop);
				result=true;
				break;
			}
		}
		return result;
	}
	//点击“借款目的”
	public void clickLoanTitleLnk(){
		base.clickWithWait(LoanPurposeLnk);
		base.jumpToNewWindow();
		base.checkElement(EStarPlanLoanDetailPage.LoanInfoonTop);
	}
	//输入“推荐邀请码”
	public void InputRefereeInviteCode(String YaoQingMa){
		base.checkElementVisible(voucherTxt);
		base.sendKeysWithWait(voucherTxt, YaoQingMa);
	}
	//输入“借款金额”
	public void InputBorrowMoney(String amount){
		base.sendKeysWithWait(amountTxt, amount);
	}
	//选择“借入者类型”
	public void selectBorrowerType(String type){
		base.elementSelectByVisibleText(borrowerTypeSel, type);
		if(type.equals("企业")){
			base.checkElementVisible(FillInQYInfoLnk);
		}
	}
	//点击“填写企业信息”链接
	public void clickFillInQYInfoLnk(){
		base.clickWithWait(FillInQYInfoLnk);
		base.checkElement(QYBidInfoTitle);
	}
	//填写“债权推荐人名称”
	public void InputQYReferrerName(String name){
		base.sendKeysWithWait(InputQiYeReferrerName, name);
	}
	//检查输入“债权推荐人名称”
	public void checkInputReferrerName(String input,String result){
		
		InputQYReferrerName(input);
		base.clickWithWait(InputQiYeReferrerIntro);
		base.checkElmentText(ReferrerNameTipTxt, result);
	}
	//填写“债权推荐人简介”
	public void InputQYReferrerIntro(String intro){
		base.sendKeysWithWait(InputQiYeReferrerIntro, intro);
	}
	//检查输入“债权推荐人简介”
	public void checkInputReferrerIntro(String input,String result){
			
		InputQYReferrerIntro(input);
		base.clickWithWait(InputQiYeBusiness);
		base.checkElmentText(ReferrerIntroTipTxt, result);
	}
	//填写“注册金额”
	public void InputRegisterAmount(String amount){
		
		base.sendKeysWithWait(InputQiYeRegisteredAmount, amount);
	}
	//检查输入“注册金额”
	public void checkInputRegisterAmount(String amount,String result){
		
		InputRegisterAmount(amount);
		base.clickWithWait(InputQiYeInvestAmount);
		base.checkElmentText(RegisterAmountTipTxt, result);
	}
	
	
	//点击“保存”企业标信息
	public void clickSaveBtn(){
		base.clickWithWait(QiYeSaveBtn);
		base.checkNoElement(QYBidInfoTitle);
	}
	//点击“取消”企业标信息
	public void clickCancelBtn(){
		base.clickWithWait(QiYeCancelBtn);
		base.checkNoElement(QYBidInfoTitle);
	}

	//填写“企业标信息”
	public void ImproveQYBidInfo(){
		base.sendKeysWithWait(InputQiYeName, "北京长青");
		base.sendKeysWithWait(InputQiYeAddress, "北京海淀中关村");
		base.removeReadOnly("foundedtime");
		base.sendKeysWithWait(InputQiYefoundedtime, "2015-08-01");
		base.sendKeysWithWait(InputQiYeReferrerName, "北京东方有限公司");
		base.sendKeysWithWait(InputQiYeReferrerIntro, "北京东方有限公司是一家大型的投资公司，它是一个家族企业，成立于2003年");
		base.sendKeysWithWait(InputQiYeBusiness, "目前主要投资和经营的产业有：银行、证券等金融产业、现代农业、港口交通产业、信息产业");
		base.sendKeysWithWait(InputQiYeRegisteredAmount, "1000000");
		base.sendKeysWithWait(InputQiYeInvestAmount, "1000000");
		base.sendKeysWithWait(InputQiYeBusinessState, "从公司成立至今，投资的大部分公司都已经有了较高的盈利回报，发展良好");
		base.sendKeysWithWait(InputQiYeUseType, "主要用于活动基金");
		base.sendKeysWithWait(InputQiyeRepaySource, "主要是从众多的投资公司的盈利中来偿还借款，或者是从其他地方拆借而来");
		base.sendKeysWithWait(InputQiyeCounterSecurity, "反担保：北京东方有限公司北京东方有限公司北京东方有限公司北京东方有限公司");
		base.sendKeysWithWait(InputQiyeSafeGuard, "担保：如不能如期偿还，有北京东方有限公司来进行偿还，有北京东方有限公司来偿还");
		base.sendKeysWithWait(InputQiyeSafeGuardReason, "担保意见：因为只是用于活动基金，所以相信这个公司完全有能力来偿还借款");
		base.clickWithWait(QiYeSaveBtn);
		base.assertEqualsActualExpected(base.getAlertwithWait().getText(), "信息保存成功，谢谢！");
		base.acceptAlert();
	}
	//检查“企业标信息”-“债权推荐人名称”的输入框功能
	public void checkQYReferrerName(){
		try{
			checkInputReferrerName("ab","");
			checkInputReferrerName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx","");
			checkInputReferrerName("abcdefghijklmnopqrst","");
			checkInputReferrerName("a","不能少于2个字！");
			checkInputReferrerName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy","不能多于50个字！");
			checkInputReferrerName("","债权推荐人名称不能为空！");
//			InputQYReferrerName("abcdefghijklmnopqrstuvwxyz");
//			base.CopyAndPaste();
//			base.clickWithWait(InputQiYeReferrerIntro);
//			base.checkElmentText(ReferrerNameTipTxt, "不能多于50个字！");
		}catch(Exception e){
			clickCancelBtn();
			Assert.fail(e.toString());
		}
	}
	
	//检查“企业标信息”-“债权推荐人简介”的输入框功能
	public void checkQYReferrerIntro(){
		try{
			checkInputReferrerIntro("abcdefghijklmnopqrstuvwxyzabcd","");
			checkInputReferrerIntro("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefg","");
			checkInputReferrerIntro("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqr","");
			checkInputReferrerIntro("abcdefghijklmnopqrstuvwxyzabc","债权推荐人简介输入的字数少于30个，再写点吧！");
			checkInputReferrerIntro("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefgh","债权推荐人简介输入的字数多于500个！");
			checkInputReferrerIntro("","债权推荐人简介不能为空！");
		}catch(Exception e){
			clickCancelBtn();
			Assert.fail(e.toString());
		}
	}
	//检查“企业标信息”-“注册金额”的输入框功能
	public void checkQYRegisterAmount(){
		try{
			checkInputRegisterAmount("10000.3","");
			checkInputRegisterAmount("10000.3f","注册金额格式不正确！");
			checkInputRegisterAmount("","请输入注册金额！");
		}catch(Exception e){
			clickCancelBtn();
			Assert.fail(e.toString());
		}
	}
	
	//选择“借款期限”
	public void selectBorrowPhase(String QiXian){
		base.checkElementVisible(phasesSel);
		base.elementSelectByVisibleText(phasesSel, QiXian);
	}
	//选择“借款类型”
	public void selectBorrowType(String type){
		base.elementSelectByVisibleText(usetypeSel, type);
	}
	//输入“借款目的”
	public void InputBorrowPurpose(String purpose){
		base.sendKeysWithWait(purposeTxt, purpose);
	}
	//输入“联系电话”
	public void inputPhone(String phone){
		base.sendKeysWithWait(phoneTxt, phone);
	}
	//输入“联系邮箱”
	public void inputMail(String mail){
		base.sendKeysWithWait(mailTxt, mail);
	}
	//点击“添加”按钮（在后保证人）
	public void clickAddBtn(){
		base.clickWithWait(addBtn);
		base.checkElementVisible(baoZhengRenDiv);
	}
	//选择“在后保证人类型”
	public void selectBaoZhengRenType(String type){
		base.elementSelectByVisibleText(baoZhengRenSel, type);
	}
	//在后保证人类型为“自然人”，输入“姓名”
	public void inputBaoZhengRenZrrName(String name){
		base.sendKeysWithWait(baoZhengRen_zrr_name, name);
	}
	//在后保证人类型为“自然人”，输入“身份证号”
	public void inputBaoZhengRenZrrIdCard(String id){
		base.sendKeysWithWait(baoZhengRen_zrr_idCard, id);
	}
	//在后保证人类型为“自然人”，输入“户籍地址”
	public void inputBaoZhengRenZrrHousehold(String household){
		base.sendKeysWithWait(baoZhengRen_zrr_household, household);
	}
	//在后保证人类型为“自然人”，输入“现住所地址”
	public void inputBaoZhengRenZrrAddress(String address){
		base.sendKeysWithWait(baoZhengRen_zrr_address, address);
	}
	//在后保证人类型为“自然人”，输入“联系电话”
	public void inputBaoZhengRenZrrTel(String tel){
		base.sendKeysWithWait(baoZhengRen_zrr_tel, tel);
	}
	//在后保证人类型为“自然人”，输入“联系邮箱”
	public void inputBaoZhengRenZrrMail(String mail){
		base.sendKeysWithWait(baoZhengRen_zrr_mail, mail);
	}
	//在后保证人类型为“自然人”，点击“保存”按钮
	public void clickBaoZhengRenZrrSaveBtn(){
		base.clickWithWait(baoZhengRen_zrr_saveBtn);
	}
	//在后保证人类型为“法人”，输入“名称”（公司名称）
	public void inputBaoZhengRenFrName(String name){
		base.sendKeysWithWait(baoZhengRen_fr_name, name);
	}
	//在后保证人类型为“法人”，输入“法定代表人”
	public void inputBaoZhengRenFrDeputy(String deputy){
		base.sendKeysWithWait(baoZhengRen_fr_deputy, deputy);
	}
	//在后保证人类型为“法人”，输入“地址”（公司地址）
	public void inputBaoZhengRenFrAddress(String address){
		base.sendKeysWithWait(baoZhengRen_fr_address, address);
	}
	//在后保证人类型为“法人”，输入“联系电话”（公司地址）
	public void inputBaoZhengRenFrTel(String tel){
		base.sendKeysWithWait(baoZhengRen_fr_tel, tel);
	}
	//在后保证人类型为“法人”，输入“联系邮箱”（公司地址）
	public void inputBaoZhengRenFrMail(String mail){
		base.sendKeysWithWait(baoZhengRen_fr_mail, mail);
	}
	//在后保证人类型为“法人”，点击“保存”按钮
	public void clickBaoZhengRenFrSaveBtn(){
		base.clickWithWait(baoZhengRen_fr_saveBtn);
	}
	
	/**
	 * 输入“在后保证人”信息
	 * @param type 在后保证人类型
	 * @param name 姓名
	 * @param id 身份证号
	 * @param household 户籍地址
	 * @param address 现住所地址
	 * @param tel 联系电话
	 * @param mail 联系邮箱
	 * @author 江渤洋 2016-1-12
	 */
	public void inputBaoZhengRenInfo(DWutGuaranteeModel guarantee){
		String type = guarantee.getType();
		selectBaoZhengRenType(type);
		if(type.equals("自然人")){
			inputBaoZhengRenZrrName(guarantee.getName());
			inputBaoZhengRenZrrIdCard(guarantee.getIdCard());
			inputBaoZhengRenZrrHousehold(guarantee.getAddr());
			inputBaoZhengRenZrrAddress(guarantee.getCurAddr());
			inputBaoZhengRenZrrTel(guarantee.getMobile());
			inputBaoZhengRenZrrMail(guarantee.getEmail());
			clickBaoZhengRenZrrSaveBtn();
		}
		else if(type.equals("法人")){
			inputBaoZhengRenFrName(guarantee.getName());
			inputBaoZhengRenFrDeputy(guarantee.getLayer());
			inputBaoZhengRenFrAddress(guarantee.getCurAddr());
			inputBaoZhengRenFrTel(guarantee.getMobile());
			inputBaoZhengRenFrMail(guarantee.getEmail());
			clickBaoZhengRenFrSaveBtn();
		}
	}

	//输入“描述信息”
	public void InputDescription(){
		base.sendKeysWithWait(detaildescriptionTxt, "自动化测试使用，自动化测试使用，自动化测试使用，自动化测试使用");
	}
	//点击“发布”按钮
	public void clickPublishBtn(){
		base.clickWithWait(releaseBtn);
		base.checkAlertText("发布成功，等待初步审核，谢谢！");
		base.isElementContainsValue(PublishedLoanLnk, "class", "current");
	}
	//点击“发布”按钮后检查发布信息
	public void checkPublishedLoan(int num1,int num2){
		
		base.checkElementVisible(LoanPurposeLnk);
		base.assertEqualsActualExpected(base.getElementText(LoanPurposeLnk), "自动化测试使...");
		base.assertEqualsActualExpected(base.getElementText(StatusTxt), "待初审");
		base.assertEqualsActualExpectedByInt(getNumofAllLoan(), num1+1);
		clickPublishingLoanLnk();
		base.assertEqualsActualExpectedByInt(getNumofAllLoan(), num2-1);
	}
	//点击“保存预览”按钮
	public void clickSavePreviewBtn(){
		base.clickWithWait(SavePreviewBtn);
		base.checkElementVisible(EStarPlanLoanDetailPage.LoanInfoonTop);
	}
	//检查“尚未发布的借款”-列表中的标信息
	public void checkPublishingLoanData(){
		
		
		List<WebElement> nums = base.getElements(Lines);
		int num = nums.size();
		for(int i =1;i<=num;i++){
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='_content_child']/table/tbody/tr["+i+"]/td")), String.valueOf(i));
		}
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		String currentDay = d.format(cal.getTime());
		String [] Info = {"1","自动化测试使...","￥10,000","10.30%","3个月","待发布","企业-翼星计划标",currentDay,"预览 修改 发布 删除"};
		List<WebElement> Infos = base.getElements(BorrowInfo);
		for(int i=0;i<9;i++){
			base.assertEqualsActualExpected(Infos.get(i).getText(), Info[i]);
		}
		base.assertEqualsActualExpected(base.getLnkElementText(LoanPurposeLnk, "title"), "自动化测试使用");
	}
	//检查“已发布的借款”-列表中的标信息
	public void checkPublishedLoanData(){
		
		List<WebElement> nums = base.getElements(Lines);
		int num = nums.size();
		for(int i =1;i<=num;i++){
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='_content_child']/table/tbody/tr["+i+"]/td")), String.valueOf(i));
		}
		String [] info = {"1","自动化测试使...","￥10,000","10.10%","3个月"};
		List<WebElement> Infos = base.getElements(BorrowInfo);
		for(int i=0;i<5;i++){
			base.assertEqualsActualExpected(Infos.get(i).getText(), info[i]);
		}
	}
	//检查“已发布的借款”中的待初审状态
	public void checkPublishedAuditStatus(){
		
		String [] status = {"待初审","0%","待初审","企业-翼星计划标","待初审"};
		List<WebElement> Infos = base.getElements(BorrowInfo);
		for(int i =0;i<5;i++){
			base.assertEqualsActualExpected(Infos.get(i+5).getText(), status[i]);
		}
	}
	
	//点击操作中的“预览”链接
	public void clickPreviewLnk(){
		
		base.clickWithWait(PreviewLnk);
		base.jumpToNewWindow();
		base.checkElement(EStarPlanLoanDetailPage.LoanInfoonTop);
	}
	//点击操作中的“发布”链接
	public void clickPublishLnk(){
		
		base.clickWithWait(PublishLnk);
		base.checkElementVisible(BorrowPage);
	}
	//检查之前填写的借款信息
	public void checkBorrowedInfo(){
		
		base.assertEqualsActualExpected(base.getLnkElementText(voucherTxt,"value"), "ElWut1058");
		base.assertEqualsActualExpected(base.getLnkElementText(amountTxt,"value"), "10000.00");
		base.assertEqualsActualExpected(base.getLnkElementText(Interest,"value"), "10.30");
		base.assertTrueByBoolean(base.getElementWithWait(ManBiaoRadio).isSelected());
		base.assertTrueByBoolean(base.getElementWithWait(HBFXRadio).isSelected());
		base.assertEqualsActualExpected(base.getLnkElementText(purposeTxt,"value"), "自动化测试使用");
		base.assertEqualsActualExpected(base.getLnkElementText(detaildescriptionTxt,"value"), "自动化测试使用，自动化测试使用，自动化测试使用，自动化测试使用");
		base.checkElementVisible(borrowerTypeSel);
		base.checkElementVisible(QYTip);
		base.checkElementVisible(ThreeMonth);
		String qiyetip = "本网站企业类型借入者，请在发标前尽量 填写企业信息，发标后我们将进行审核。";
		base.assertEqualsActualExpected(base.getElementText(QYTip), qiyetip);
		base.assertTrueByBoolean(Boolean.valueOf(base.getLnkElementText(ThreeMonth, "selected")));
		base.assertTrueByBoolean(Boolean.valueOf(base.getLnkElementText(BusinessZZ, "selected")));
	}
	
	//点击"正在还款的借款"中的"查看下载电子借条"链接
	public void clickRepayingIOULnk(){
		
		base.clickWithWait(RepayingIOULnk);
		base.jumpToNewWindow();
		base.checkTitle("电子借条");
	}
	
	/**
	 * 判断“正在还款的借款”是否被选中
	 * @author 江渤洋 2015-7-22
	 */
	public void isRepayingTabSelected(){
		boolean isContains = base.isElementContainsValue(repayingTab, "class", "current");
		base.assertEqualsActualExpectedByBoolean(isContains, true);
		base.sleep(2000);
	}
	
	/**
	 * 验证一次性还清功能及其窗口相关功能
	 * @author 江渤洋 2015-7-22
	 */
	public void checkLoanList(String numberinAvailableBalanceStr){
		boolean isDisplayed = true;
		boolean isShow = false;
		//判断是否有数据
		isDisplayed = base.isDisplayed(loanListByFirst);System.out.println("是否有数据：" + isDisplayed);//------测试
		if(isDisplayed)
		{			
			base.sleep(2000);
			
			//校验“一次性还清”链接
			//1.点击“一次性还清”链接
			base.clickWithWait(disposablePayOffByFirst);
			base.sleep(1000);
			isShow = !base.isNone(outAllWindow);System.out.println("弹出还款确认框是否显示：" + isShow);//------测试
			//2.弹出还款确认框
			base.assertEqualsActualExpectedByBoolean(isShow, true);
			
			//校验“我要充值”链接
			//1.点击“我要充值”
			base.clickWithWait(iNeedRecharge);
			base.sleep(2000);
			//2.校验进入充值页面
			base.assertEqualsActualExpectedByBoolean(base.isDisplayed(rechargeDiv), true);
			base.sleep(2000);
			//3.返回“我的借入计划”
			myAccountPage.turnToMyAccount("我的借入计划");
			base.sleep(1000);
			//4.点击“一次性还清”链接
			base.clickWithWait(disposablePayOffByFirst);
			base.sleep(1000);
			
			//校验“检查账户余额”、“还款方式”以及“应还金额”显示是否正确
			//1.校验“检查账户余额”
			String balanceByWindowStr = base.getElementTextWithWait(balanceByWindow);
			//去掉￥
			balanceByWindowStr = balanceByWindowStr.substring(1);
			if(balanceByWindowStr.equals("0")){
				balanceByWindowStr = balanceByWindowStr + ".00";
			}
			System.out.println("您的账户余额:" + balanceByWindowStr);//-----测试
			base.assertEqualsActualExpected(balanceByWindowStr, numberinAvailableBalanceStr);
			//2.校验“还款方式”
			System.out.println("还款方式:" + base.getElementTextWithWait(theWay));//-----测试
			base.assertEqualsActualExpected(base.getElementTextWithWait(theWay), "提前一次性还清");
			//3.校验“应还金额”
			//公式：借款金额*年利率/年天数
			Reporter.log("error_翼星计划_我的借入计划_还款确认对话框_还款方式_公式复杂，请手动校验");
			System.out.println("error_翼星计划_我的借入计划_还款确认对话框_还款方式_公式复杂，请手动校验");
			
			//校验关闭“还款确认”窗口后，原借款还在还款列表
			//1.点击关闭按钮
			base.clickWithWait(cancelBtn);
			base.sleep(1000);
			//2.原借款还在还款列表
			base.assertEqualsActualExpectedByBoolean(base.isDisplayed(disposablePayOffByFirst), true);
		}
		else{
			Reporter.log("error_翼星计划_我的借入计划_没有正在还款的借款");
			System.out.println("error_翼星计划_我的借入计划_没有正在还款的借款");
		}
	}
}	
