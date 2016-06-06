package com.eloancn.shared.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.jetty.html.Font;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.model.BondDetailsModel;
import com.eloancn.shared.until.FileUtil;
import com.eloancn.shared.until.RandCodeUtils;

/**
 * 翼存宝
 */
public class ECunBaoPage {
	
	Base base = new Base();
	Data data = new Data();
	DBData dbData = new DBData();
	
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	TransactionRecordPage transactionRecordPage = new TransactionRecordPage();
	
	/***************首页_元素***************/
	
	//首页 投一笔
	By touYiBiLink = By.xpath("//table[1]//td[@class='hFP_index_more']/parent::tr/preceding-sibling::tr//a[text()='投一笔']");

	/***************列表页_元素**************/


	
	/***************列表页_元素_banner**************/
	
	By loginBtn = By.linkText("立即登录");										//“立即登录”按钮
	By loginCloseBtn = By.xpath("//a[text()='关闭']");						//“立即登录”关闭按钮
	By bannerTotalData = By.cssSelector(".gdcon.colorFF > p");				//banner上翼存宝收益所有数据
	By myECunBaoBtn = By.cssSelector(".gdbtn.font16.colorFF.fontW");		//“我的翼存宝”按钮
	
	/***************列表页_元素_列表元素**************/
	
	By eCunBaoDataTitles = By.xpath("//div[@class='wrap']/div/span[3]");					//翼存宝标题集
	By eCunBaoTitle = By.xpath("//span[@class='m_zi2 ml10']");								//所有翼存宝标题
	
	/***************列表页_元素_列表元素_债权详情**************/
	
	By bondDetails = By.cssSelector(".zqlist");												//所有“债权详情”按钮
	By bondDetailsDIV = By.cssSelector("#messageBoxCard");									//债权详情_窗口
	By bondDetailsDIVTitle = By.cssSelector("#saveTitle");									//债权详情_窗口_Title
	By bondDetailsDIVColumnName = By.cssSelector("#detailstable>thead>tr>th");				//债权详情_窗口_列名(包括：借款标题、借款人姓名、身份证号、借款人地区、借款总额、操作)
	By bondDetailsDIVInfo = By.cssSelector("#tenderBody .font14.color6>td");				//债权详情_窗口_信息(包括：借款标题、借款人姓名、身份证号、借款人地区、借款总额)
	By bondDetailsDIVBtn = By.cssSelector(".xqbtn");										//债权详情_窗口_所有“查看详情”按钮
	By bondDetailsSeeDIV = By.cssSelector("#xq_content");									//债权详情_窗口_查看详情_窗口
	By bondDetailsDIVTab = By.cssSelector(".xq_content_t");									//债权详情_窗口_查看详情_所有Tab按钮
	By bondDetailsDIVClose = By.cssSelector(".tip_close");									//债权详情_窗口_查看详情_关闭按钮
	
	/********   列表页_元素_列表元素_翼龙贷在线居间服务协议           **********/
	
	By serviceAgreement = By.cssSelector(".corlan.ml15>a");									//所有《翼龙贷在线居间服务协议》
	By serviceAgreementTitle = By.cssSelector(".WordSection1>p>strong>font");				//翼龙贷在线居间服务协议_title 
	By serviceAgreementAccessories = By.cssSelector("#tenderBody");							//翼龙贷在线居间服务协议_附件
	
	/***************列表页_元素_列表元素_红包自动匹配返现**************/
	
	By returnCashTotalLink = By.cssSelector(".u-blue");										//所有“红包自动匹配返现”链接
	By returnCashCloseBtn = By.xpath("//div[@class='gui_close']");							//红包规则窗口关闭按钮
	
	/***************列表页_元素_列表元素_加入记录**************/
	
	By recordTotalBtn = By.cssSelector(".twojiantou.shang.jiantou.ml10");					//所有“加入记录”按钮
	By inputRecordOpenDiv = By.xpath("//span[@class='twojiantou shang jiantou ml10 xia']/parent::div/parent::div/parent::div/following-sibling::div[1]");
	By inputRecordOpen = By.cssSelector(".overflowV.wrap.list");							//所有加入记录DIV
	
	/***************列表页_元素_列表元素_抢投**************/
	
	By tenderTotalBtn = By.xpath("//a[contains(text(),'抢') and contains(text(),'投')]");		//“抢投”所有按钮
	By tenderDivs = By.xpath("//div[@class='m-layer']");									//“抢投”弹出DIV
	By tenderCloseDivBtn = By.xpath("//a[contains(@onclick,'closeBox(')]");					//关闭“抢投”DIV按钮
	By operationFailureDiv = By.xpath("//div[@id='fastLender_2']");							//操作失败DIV
	By closeOperationFailureDiv = By.xpath("//div[@id='fastLender_2']//a");					//操作失败DIV 关闭按钮
	
	
	
	//获得打开记录层元素
	public WebElement getInputRecordDiv(){
		return base.getElementNoWait(inputRecordOpenDiv);
	}
	
	/**
	 * 徐天元
	 * 提示 充值 
	 */
	public void promptRecharge(){
		base.checkElementVisible(By.cssSelector(".lyct>.textC"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(".lyct>.textC")), "亲 请先去充值,再投资!");
	}
	
	/**
	 * 徐天元
	 * 点击充值
	 */
	public void goRecharge(){
		base.clickWithWait(By.cssSelector(".btn1>input[value='去充值!']"));
	}
	
	/**
	 * 徐天元
	 * 翼存宝投资操作
	 * @param buyShareNum 份数
	 * @param payPwd
	 */
	public void touZi(String buyShareNum,String payPwd,double balance){
		//“购买份额”
		indexPage.sendKeyBuyShareTxt(buyShareNum);
		//“支付密码”
		if (balance<100) {
			base.clickWithWait(By.id("payPwd"));
			//base.sleep(2000);
			Alert alert = base.getAlertwithWait();
			//base.sleep(2000);
			base.assertEqualsActualExpected(alert.getText(), "您的余额不足");
			alert.accept();
			closeTouZiEcunBao();
			return;
		}
		indexPage.sendKeyPayPwdTxt(payPwd);
		//获取验证码
		String verificationCode = data.get(indexPage.getVerificationCodeImg(), base.getWebDriver());
		//输入验证码
		indexPage.sendKeyVerificationCode(verificationCode);
		//勾选《翼存宝投资协议》
		indexPage.checkECunBaoProtocolAgree();
		//点击“确定”按钮
		indexPage.clickInvestmentOKBtn();   
	}
	
	/**
	 * 徐天元
	 * 校验翼存宝投资是否成功
	 */
	public boolean isTouZiOK(){
		Boolean result = false;
		//等待DIV显示
		base.checkElementVisible(By.id("fastLender_2"));
		//获取“投资成功”DIV的display属性值是否为block，如果是则DIV显示
		boolean isInvestmentSuccess = base.isBlock(By.id("fastLender_2"));
		base.assertTrueByBoolean(isInvestmentSuccess);
		//String message = base.getElementText(By.xpath("//div[@id='fastLender_2']/div/span[text()='投资成功']"));
		String message = base.getElementText(By.id("backMsg"));
		//点击“关闭”按钮
		closeEcunBao();
		//判断窗口Title投资成功
		if (message.equals("投资成功")) {
			result = true;
		}else {
			System.out.println("首页翼存宝："+base.getElementTextWithWait(By.id("errorMsg")));
			Reporter.log("首页翼存宝："+base.getElementTextWithWait(By.id("errorMsg"))+"<br/>");
		}
		return result;
	}
	
	/**
	 * 徐天元
	 * 自动输入功能
	 */
	public void auto(double balance){
		//base.sleep(2000);
		//点击 自动输入
		base.clickWithWait(By.cssSelector(".font14.fr.pdr14"));
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
		//base.sleep(3000);
		if (balance < 100) {
			//金额不足100，不能购买此产品
			base.assertTrueByBoolean(base.isAlertPresent(15));
			Alert alert = base.getAlertwithWait();
			base.assertEqualsActualExpected(alert.getText(), "金额不足100，不能购买此产品");
			alert.accept();
		}else {
			//还需余额
			int needMoney = Integer.parseInt(base.getElementText(By.cssSelector("#showYuGouAmount")));
			//购买份额
			String num = base.getElementWithWait(By.id("wmpsYuGouAmount")).getAttribute("value");
			System.out.println("系统计算可购买份额："+num);
			if (balance < needMoney) {
				System.out.println("账户余额可购买翼存宝份额："+(int)balance/100);
				base.assertEqualsActualExpected(num, (int)balance/100+"");
			}else {
				System.out.println("剩余可购买的份额："+needMoney/100+"");
				base.assertEqualsActualExpected(num, needMoney/100+"");
			}
		}
		//点击“关闭”按钮
		closeTouZiEcunBao();
		//base.sleep(2000);
	}
	
	/**
	 * 徐天元
	 * 点击 关闭按钮  投资完/出错
	 * @param args
	 */
	public void closeEcunBao(){
		//点击“关闭”按钮
		base.clickWithWait(By.cssSelector("#fastLender_2 .close.fr"));
	}
	
	/**
	 * 徐天元
	 * 点击 关闭按钮  投资窗体
	 * @param args
	 */
	public void closeTouZiEcunBao(){
		//点击“关闭”按钮
		base.clickWithWait(By.cssSelector("#fastLender_1 .close.fr"));
	}
	
	/*************************************/
	/***************  综合       ***************/
	/*************************************/
	
	/**
	 * 发布翼存宝
	 * @param eCunBaoName	翼存宝名称（名称+本地时间，例如：auto0104161935）
	 * @param amount		购买金额（最大金额，例如：10000）
	 * @param rate			购买利率（例如：0.125）
	 * @param validity		购买有效期（单位小时，例如：1）
	 * @param limit			合约期限（锁定期限。单位天，例如：7/30/90/365/720）
	 * @param createData 	创建日期（例如：1451911350）
	 * @param publishedDate	发布日期
	 * @param accrualData	计息日期（发布日期 + 购买有效期）
	 * @param repaymentData 还本日期（计息日期 + 合约期限）
	 * @return 是否插入成功（true：成功，false：失败）
	 * @author 江渤洋 2016-1-4
	 */
	public void checkPublishECaoBao(String eCunBaoName, String amount, String rate, String validity, String limit, String createData, String publishedDate, String accrualData, String repaymentData){
		
		boolean isTrue = dbData.publishECaoBao(eCunBaoName, amount, rate, validity, limit, createData, publishedDate, accrualData, repaymentData);
		base.assertTrueByBoolean(isTrue);
		System.out.println("翼存宝发布成功，名称：" + eCunBaoName + " 金额： " + amount + " 元  合约期限： " + limit + " 天");
		Reporter.log("翼存宝发布成功，名称：" + eCunBaoName + " 金额： " + amount + " 元  合约期限： " + limit + " 天");
	}
	
	/**
	 * 发布翼存宝_计算“计息时间”
	 * @param publishedDate 发布日期（时间戳格式）
	 * @param validity 购买有效期（单位小时，时间戳格式）
	 * @return 计息时间
	 * @author 江渤洋 2016-1-4
	 */
	public String calculateAccrualData(String publishedDate, String validity){
		
		validity = (Long.parseLong(validity) * 3600) + "";
		return (Long.parseLong(publishedDate) + Long.parseLong(validity)) + "";
	}
	
	/**
	 * 发布翼存宝_计算“还本日期”
	 * @param accrualData 计息时间（时间戳格式）
	 * @param limit 合约期限（单位天，时间戳格式）
	 * @return 还本日期
	 * @author 江渤洋 2016-1-4
	 */
	public String calculateRepaymentData(String accrualData, String limit){
		
		limit = (Long.parseLong(limit) * 86400) + "";
		return (Long.parseLong(accrualData) + Long.parseLong(limit)) + "";
	}
	
	/**
	 * 翼存宝计算利息
	 * @param money 投资翼存宝的金额
	 * @param rate 利率
	 * @param day 购买天数
	 * @return 利息
	 * @author 江渤洋 2016-1-4
	 */
	public String calculateECunBaoIncome(String money, String rate, String day){
		
		double moneyDou = Double.parseDouble(money);
		double dayDou = Double.parseDouble(day);
		double rateDou = Double.parseDouble(rate);
		//1000*0.125/365*7
		double multiplyStr = base.multiply(moneyDou, rateDou);	//1000*0.125
		double divideStr = multiplyStr / 365.0;//base.divide(multiplyStr, 365.0);		//365
		divideStr = base.setRound(divideStr, 2, true);
		double calculation = base.multiply(divideStr, dayDou);	//*7
		return base.setRound(calculation, 2, true) + "";
	}
	
	/*************************************/
	/***************  首页       ***************/
	/*************************************/
	
	/**
	 * 徐天元
	 * 投一笔
	 * @param buyShareNum 份数
	 * @param payPwd 支付密码
	 * @param flag 是否自动输入  0，不自动输入  1，自动输入
	 * @param balance 账户余额
	 */
	public void touYiBi(String buyShareNum, String payPwd, int flag, double balance) {
		base.sleep(3000);
		List<WebElement> touYiBiList = base.getElements(touYiBiLink);
		//base.sleep(3000);
		if (touYiBiList.size() == 0) {
			System.out.println("翼存宝首页：没有“投一笔”,都已结束");
			Reporter.log("翼存宝首页：没有“投一笔”,都已结束"+"<br/>");
			return;
		} else {
			System.out.println("是登录:" + !loginPage.ifLogin());
			if (!loginPage.ifLogin()) {// 未登录
				// 点击“投一笔”
				base.clickWithWait(touYiBiLink);
				base.sleep(2000);
				// 校验弹出提示框
				base.assertTrueByBoolean(base.isDisplayed(By.cssSelector(".login")));
				return;
			} else {// 已登录
				if (balance == 0) {// 请充值
					// 点击“投一笔”
					//base.clickWithWait(touYiBiLink);
					touYiBiList.get(0).click();
					base.sleep(2000);
					// .lyct>.textC 亲 请先去充值,再投资! #bcardtip显示
					base.assertTrueByBoolean(base.checkVisible(By.id("bcardtip")));
					return;
				} else {
					// 投一笔
					System.out.println("size:"+touYiBiList.size());
//					for (int i = 0; i < touYiBiList.size(); i++) {
					for (int i = 0; i < 1; i++) {
//						System.out.println(i);
						// 点击“投一笔”
						touYiBiList.get(i).click();
						base.sleep(5000);
						if (base.isBlock(By.id("fastLender_1"))) {
							balance = Integer.parseInt(base.getElementTextWithWait(By.id("userBalance")).split("\\.")[0]);
							base.sleep(2000);
							if (flag == 1) {
								auto(balance);
								if (balance < 100) {// 小于100 验证一次即可
									return;
								}
								//return;
							} else {
								// 翼存宝投资
								if (balance < 100) {
									touZi(buyShareNum, payPwd, balance);
									return;
								}else {
									touZi(buyShareNum, payPwd, balance);
									//base.sleep(2000);
									// 校验
									if (isTouZiOK()) {
										base.assertTrueByBoolean(true);// 投资成功
										return;
									} else {
										System.out.println("失败的翼存宝产品：" + base.getElements(By.cssSelector(".color3")).get(i).getText());
										Reporter.log("失败的翼存宝产品：" + base.getElements(By.cssSelector(".color3")).get(i).getText()+"<br/>");
									}
								}
							}
						} else {
							String errorMsg = base.getElementTextWithWait(By.id("errorMsg"));
							String productName = base.getElements(By.cssSelector(".color3")).get(i).getText();
							System.out.println("失败的翼存宝产品：" + productName + "," + errorMsg);
							Reporter.log("失败的翼存宝产品：" + productName + "," + errorMsg+"<br/>");
						}
					}
				}
			}
//			System.out.println("翼存宝首页 投一笔：没有数据,产品已结束");
//			Reporter.log("翼存宝首页 投一笔：没有数据,产品已结束");
//			base.assertTrueByBoolean(false);// 出错了
		}
	}
	
	/**
	 * 徐天元
	 * 马上投资
	 * @param buyShareNum 份数
	 * @param payPwd 支付密码
	 * @param flag 是否自动输入  0，不自动输入  1，自动输入
	 * @param balance 账户余额
	 */
	public void maShangTouZi(String buyShareNum,String payPwd,int flag,double balance){
		String text = base.getElementTextWithWait(By.cssSelector(".hFP_btn_idx>a"));//.disBtn
		if (text.equals("已售罄")) {
			System.out.println("首页没有“马上投资，已售罄”");
			Reporter.log("首页没有“马上投资，已售罄”"+"<br/>");
			return;
		}else {
			if (!loginPage.ifLogin()) {
				//点击“马上投资”
				indexPage.clickInvestmentBtn();
				//base.sleep(2000);
				//校验弹出提示框
				base.assertTrueByBoolean(base.isDisplayed(By.cssSelector(".login")));
			}else {
				//已登录
				if (balance == 0) {//请充值
					//点击“马上投资”
					indexPage.clickInvestmentBtn();
					//base.sleep(2000);
					//.lyct>.textC   亲 请先去充值,再投资!  #bcardtip显示
					base.checkElementVisible(By.id("bcardtip"));
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector(".lyct>.textC")), "亲 请先去充值,再投资!");
				}else {
					//点击“马上投资”
					indexPage.clickInvestmentBtn();
					if (balance<100) {
						touZi(buyShareNum,payPwd,balance);
					}else {
						if (base.isBlock(By.id("fastLender_1"))) {
							balance = Integer.parseInt(base.getElementTextWithWait(By.id("userBalance")).split("\\.")[0]);
							//base.sleep(2000);
							if (flag == 1) {
								auto(balance);
							}else {
								//翼存宝投资
								if (balance<100) {
									touZi(buyShareNum,payPwd,balance);
								}else{
									touZi(buyShareNum,payPwd,balance);
									//base.sleep(2000);
									//校验
									if (isTouZiOK()) {
										base.assertTrueByBoolean(true);//投资成功
										return;
									}else {
										String errorMsg = base.getElementTextWithWait(By.id("errorMsg"));
										String productName = base.getElementTextWithWait(By.cssSelector(".color3"));
										System.out.println("失败的翼存宝产品：" + productName + "," + errorMsg);
										Reporter.log("失败的翼存宝产品：" + productName + "," + errorMsg+"<br/>");
									}
								}
							}
						}else {
							String errorMsg = base.getElementTextWithWait(By.id("errorMsg"));
							String productName = base.getElementTextWithWait(By.cssSelector(".color3"));
							System.out.println("失败的翼存宝产品：" + productName + "," + errorMsg);
							Reporter.log("失败的翼存宝产品：" + productName + "," + errorMsg+"<br/>");
						}
					}
				}
			}
		}
	}
	
	/**
	 * 首页翼存宝，马上投资
	 * @param buyShareNum 购买份数
	 * @param payPass 支付密码
	 * @author 江渤洋 2015-12-16
	 */
	public void immediatelyInvestment(String buyShareNum, String payPass){
		//验证码
		String verificationCode = "";
		//判断马上投资按钮是否存在
		if(indexPage.isInvestmentBtn()){
			//点击“马上投资”按钮
			indexPage.clickInvestmentBtn();
			//如果弹出购买窗口
			if(base.isBlock(By.cssSelector("#fastLender_1"))){
				if(indexPage.checkECunBaoBalance(buyShareNum)){
				//“购买份额”输入1
				indexPage.sendKeyBuyShareTxt(buyShareNum);
				//“支付密码”输入
				indexPage.sendKeyPayPwdTxt(payPass);
				//获取验证码
				verificationCode = new RandCodeUtils().getRandCode(base.getWebDriver(), indexPage.getVerificationCodeImg());
				System.out.println("验证码为：" + verificationCode);
				//输入验证码
				indexPage.sendKeyVerificationCode(verificationCode);
				//勾选《翼存宝投资协议》
				indexPage.checkECunBaoProtocolAgree();
				//点击“确定”按钮
				indexPage.clickInvestmentOKBtn();   
				base.sleep(5000);
				//校验“投资成功”信息提示框
				indexPage.checkInvestmentSuccessWindow();
			}
			else{
				indexPage.clickInvestmentCloseBtn();
				Reporter.log("error_首页购买翼存宝，账户余额不足，请手动测试</br>");
				System.out.println("error_首页购买翼存宝，账户余额不足，请手动测试");
				base.assertTrueByBoolean(false);
				}
			}
			else{
				indexPage.checkInvestmentTitle();//检查投资窗口
			}
		}
		else{
			System.out.println("error_首页翼存宝_'马上投资'按钮无法点击");
			Reporter.log("error_首页翼存宝_'马上投资'按钮无法点击");
			base.assertTrueByBoolean(false);
		}
	}
	
	/**
	 * 首页翼存宝，校验“马上投资”错误提示信息
	 * @param msg 预期错误提示信息
	 * @author 江渤洋 2015-12-28
	 */
	public void checkImmediatelyInvestmentErrorMsg(String msg){
		
		String msgStr = "";
		if(!indexPage.isInvestmentBtn()){
			System.out.println("error_首页翼存宝_'马上投资'按钮不存在，请手工校验！");
			Reporter.log("error_首页翼存宝_'马上投资'按钮不存在，请手工校验！");
			base.assertTrueByBoolean(false);
		}
		//点击“马上投资”按钮
		indexPage.clickInvestmentBtn();
		
		if(base.getElementNoWait(By.xpath("//div[@id='bcardtip']")).isDisplayed()){
			base.assertEqualsActualExpected(base.getElementText(By.xpath("//h2[@class='u-tt']")), "温馨提示");
			msgStr = base.getElementTextWithWait(By.cssSelector("#errorMsg"));
			base.clickElementNoWait(By.xpath("//div[@class='lytt']/a"));
			base.assertEqualsActualExpected(msgStr, msg);
			//情况1：翼存宝投资窗口：账户没钱，弹出充值提示窗口
		}
		else if(base.isBlock(By.id("fastLender_2"))){
			base.assertEqualsActualExpected(base.getElementText(By.xpath("//span[text()='出错了']")), "出错了");
			msgStr = base.getElementTextWithWait(By.cssSelector("#errorMsg"));
			base.clickWithWait(By.xpath("//div[@id='fastLender_2']/div/a"));
			base.assertEqualsActualExpected(msgStr, msg);
			//情况1：“翼存宝投资窗口：产品已结束”
			//情况2：“抱歉，您发布的借款出现了逾期，账户被冻结，请先还款再执行此操作!”
		}
	}
	
	/*************************************/
	/*************   列表页_方法    ************/
	/*************************************/
	
	/**
	 * 翼存宝列表页，获取翼存宝ID
	 * @return title 翼存宝标题
	 * @return 翼存宝ID
	 * @author 江渤洋 2015-8-3
	 */
	public String getProductIDByECunBaoTitle(String title){
		
		boolean isVisible = false;
		int count = 0;
		String id = "";
		//抢投层
		By by = By.xpath("//span[text()='" + title + "']/parent::div/parent::div/following::div[@class='wrap'][1]/div/div//div[contains(@id, 'poscontainer')]");

		do{
			isVisible = base.checkVisible(by);
			TotalPage.openPage("翼存宝列表页", true);
			count++;
			base.sleep(2000);
		}while(!isVisible || count < 3);
		
		try {
			id = base.getAttributeWithVisible(by, "id");//此时 ID为"poscontainer+ID" 
		} catch (TimeoutException e) {
			System.out.println("error_翼存宝列表页，没有标题为" + title + "的翼存宝");
			Reporter.log("error_翼存宝列表页，没有标题为" + title + "的翼存宝");
			base.assertTrueByBoolean(false);
		}
		
		int temp = id.indexOf("r");
		id = id.substring(temp + 1, id.length());
		return id;
	}
	
	/**
	 * 翼存宝列表页，获取第一个抢投按钮的翼存宝ID
	 * @return 翼存宝ID
	 * @author 江渤洋 2015-12-17
	 */
	public String getQiangTouBtnID(){
		
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);
		String id = "-1";
		if(tenderTotalBtnList.size() == 0){
			Reporter.log("error_翼存宝列表页面没有抢投按钮<br/>");
			System.out.println("error_翼存宝列表页面没有抢投按钮");
			return id;
		}
		for(int i = 0; i < 1; i++){
			//获取“抢投”按钮的onclick事件中的产品id，例如：onclick="lender.openbuywindow(1,673,'13.50%')
			id = tenderTotalBtnList.get(i).getAttribute("onclick").split(",")[1];
		}
		return id;
	}
	
	/**
	 * 翼存宝列表页，校验翼存宝是否购买成功
	 * @param newBalance 购买前翼存宝余额(无小数部分)
	 * @param oldBalance 购买后翼存宝余额(无小数部分)
	 * @param purchaseAmount 购买金额
	 */
	public void checkBuySuccess(String newBalance, String oldBalance, String purchaseAmount){
		String sub = base.subtract(Double.valueOf(newBalance),Double.valueOf(oldBalance)) + "";
		if(sub.indexOf(".")!= -1){
			sub = sub.substring(0, sub.indexOf("."));
		}
		base.assertEqualsActualExpected(sub, purchaseAmount);
	}
	
	/**
	 * 获得翼存宝页面指定个数的标题
	 * @param count(标题个数)
	 * @return 标题字符串动态数组
	 * @author 江渤洋 2015-5-7
	 */
	public List<String> getECunBaoDataTitles(int count){
		//获取所有span对象
		List<WebElement> eCunBaoDataTitleList = base.getElements(eCunBaoDataTitles);
		List<String> eCunBaoDataTitleStringList = new ArrayList<String>();
		if(eCunBaoDataTitleList.size()>10){
			Reporter.log("翼存宝列表页:翼存宝数据超过10条");
			System.out.println("翼存宝列表页:翼存宝数据超过10条");
		}
		else if(count>10){
			Reporter.log("翼存宝列表页: 显示数据不得超过10条！");
			System.out.println("翼存宝列表页: 显示数据不得超过10条！");
		}
		else{
			//将span元素中的Text添加到字符串动态数组中
			for(int i = 0; i < count; i++){
				eCunBaoDataTitleStringList.add(eCunBaoDataTitleList.get(i).getText());
			}
		}
		return eCunBaoDataTitleStringList;
	}
	
	/**
	 * 翼存宝列表页，校验翼存宝显示个数
	 * @author 江渤洋 2016-2-26
	 */
	public void checkYCBNum(){
		List<WebElement> list = Arrays.asList();
		list = base.getVisibleElements(eCunBaoDataTitles);
		base.assertEqualsActualExpectedByInt(list.size(), 10);
	}
	
	
	/********************************************/
	/***********     列表页_方法_banner   **********/
	/********************************************/
	
	/**
	 * 翼存宝列表页， 点击“立即登录”按钮
	 * @author 江渤洋 2015-5-15
	 */
	public void clickLoginBtn(){
		base.clickWithWait(loginBtn);
	}
	
	/**
	 * 翼存宝列表页，校验“立即登录”按钮，是否存在
	 * @author 江渤洋 2015-7-9
	 */
	public boolean isClickLoginBtnPresent(){
		if(base.isElementVisible(loginBtn)){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * 翼存宝列表页，点击“我的翼存宝”按钮
	 * @author 江渤洋 2015-5-15
	 */
	public void clickMyECunBaoBtn(){
		base.clickWithWait(myECunBaoBtn);
	}
	
	/**
	 * 翼存宝列表页，点击“立即登录”关闭按钮
	 * @author 江渤洋 2015-5-15
	 */
	public void clickLoginCloseBtn(){
		base.clickWithWait(loginCloseBtn);
	}
	
	/**
	 * 首页/列表页，校验“立即登录”窗口Title
	 * @author 江渤洋 2015-5-15
	 * @author 修改 江渤洋 2015-9-9
	 */
	public void checkBannerLoginWindowTitle() {
		
		boolean isShow = false;
		//判断登出窗口是否显示
		base.assertTrueByBoolean(base.isBlock(By.cssSelector(".login")));
		isShow = base.isElementPresent(By.cssSelector("#loginBoxFrame"));
		if(isShow){
			//获取“登录”窗口
			base.switchToFrame("loginBoxFrame"); 
		}
		//判断登录窗口Title是否正确
		base.assertEqualsActualExpected(base.getElementTextWithVisible(By.cssSelector(".fl.font20")), "登录");
		//判断“立即登录”关闭按钮是否存在
		base.assertEqualsActualExpectedByBoolean(base.isElementVisible(loginCloseBtn), true);
		//点击“立即登录”关闭按钮
		clickLoginCloseBtn();
		base.fromFrameToDefaultContent();
	}
	
	/**
	 * 翼存宝列表页， 校验banner上显示用户的翼存宝收益
	 * @author 江渤洋 2015-5-12
	 */
	public void checkBannerTotalData(){
		String txtString[] = {"小翼为您报道翼存宝数据：","昨日收益：","累计收益：","待收笔数：","我的翼存宝"};
		base.checkElementVisible(bannerTotalData);
		List<WebElement> bannerTotalElements = base.getElements(bannerTotalData);
		for(int i = 0; i < bannerTotalElements.size(); i++){
			switch(i){
				//预期结果：小翼为您报道翼存宝数据：
				case 0:
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElement(By.cssSelector("span")).getText(), txtString[i]);
					break;
				//预期结果：昨日收益： ￥，.00(涉及表：d_wmps_day_inter昨日收益)
				case 1:
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(0).getText(), txtString[i]);
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(1).getText(), "￥");
					//需要查询数据库，但不清楚具体校验规则(可咨询陈晓龙)
//					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(2).getText(), "0.00");
					break;
				//预期结果：累计收益：￥，.00(涉及表：d_pro_comm_funds_info 累计收益)
				case 2:
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(0).getText(), txtString[i]);
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(1).getText(), "￥");
//					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(2).getText(), "0.00");
					break;
				//预期结果： 待收笔数：0，笔(涉及表：d_wmps_buy_record  购买笔数)
				case 3:
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(0).getText(), txtString[i]);
//					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(1).getText(), "0");
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.cssSelector("span")).get(2).getText(), "笔");
					break;
				//预期结果：我的翼存宝
				default:
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElement(By.tagName("a")).getText(), txtString[i]);
			}
		}
	}
	
	/**
	 * 翼存宝列表页，校验Banner中“昨日收益”、“累计收益”、“待收笔数”
	 * @param hashMap 体验期翼存宝的产品信息(加入金额，年化收益率，合约期限，计息时间，到期时间)
	 * @author 江渤洋 2015-10-27
	 */
	public void checkBannerToData(HashMap<String, String> hashMap){
		
		String amount = hashMap.get("amount");             //加入金额
		String interestrate = hashMap.get("interestrate"); //年化收益率
		String interdate = hashMap.get("interdate");       //计息时间
		
		String interest = transactionRecordPage.calculationInterest(amount, interestrate);//“昨日收益”
		String cumulative = transactionRecordPage.calcCumulativeGain(interest, interdate);//“累计收益”
		String count = "2";                                                               //“待收笔数”(默认为1笔)
		
		base.checkElement(bannerTotalData);
		List<WebElement> bannerTotalElements = base.getElements(bannerTotalData);
		for(int i = 0; i < bannerTotalElements.size(); i++){
			switch(i){
				case 1:base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(2).getText(), interest);break;
				case 2:
				try {
					base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(2).getText(), cumulative);
				} catch (AssertionError e) {
					Reporter.log("error_我的账户_翼存宝_累计收益错误<br/>");
					System.out.println("error_我的账户_翼存宝_累计收益错误");
				}break;
				case 3:base.assertEqualsActualExpected(bannerTotalElements.get(i).findElements(By.tagName("span")).get(1).getText(), count);break;
				default:break;
			}
		}
	}

	/**
	 * 翼存宝列表页，获取banner中“昨日收益”、“累计收益”、“待收笔数”的数据
	 * @param name 数据名称
	 * @return 对应数据
	 * @author 江渤洋 2015-12-29
	 */
	public String getBannerData(String name){
		
		String data = "";
		By by = null;
		if(name.equals("昨日收益")){
			by = By.cssSelector(".gdcon.colorFF > p:nth-child(2) >span:nth-child(3)");
		}
		else if(name.equals("累计收益")){
			by = By.cssSelector(".gdcon.colorFF > p:nth-child(3) >span:nth-child(3)");
		}
		else if(name.equals("待收笔数")){
			by = By.cssSelector(".gdcon.colorFF > p:nth-child(4) >span:nth-child(2)");
		}
		data = base.getElementTextWithVisible(by);
		data = base.stringToReplace(data, ",", "");
		data = data.trim();
		return data;
	}
	
	/***************************************************************************/
	/******* 列表页_方法_投资协议_标题、年化收益、锁定期限、已募集金额、总金额 、计息时间、还本时间   ********/
	/***************************************************************************/
	
	/**
	 * 翼存宝列表页，获取第一条数据的信息（标题、年化收益、锁定期限、已募集金额、总金额）
	 * @param id 翼存宝ID
	 * @return 列表页信息
	 * @author 江渤洋 2015-12-14
	 */
	public List<String> getECunBaoDataOne(String id){
		List<WebElement> listWeb = new ArrayList<WebElement>();
		List<String> listStr = new ArrayList<String>();
		//标题
		By titleBy = By.xpath("//div[@id='poscontainer" + id + "']/parent::div/parent::div/parent::div/preceding-sibling::div[1]//span[@class='m_zi2 ml10']");
		//年化收益、锁定期限、已募集金额、总金额
		By dataBy =  By.xpath("//div[@id='poscontainer" + id + "']/parent::div/parent::div/parent::div//div[contains(@class, 'con_con')]/div/p[2]");
		base.checkElementVisible(titleBy);
		base.checkElementVisible(dataBy);
		listStr.add(base.getElementText(titleBy));//添加标题
		listWeb = base.getVisibleElements(dataBy);
		for(int i = 0; i < listWeb.size(); i++){
			listStr.add(listWeb.get(i).getText());//添加 年化收益、锁定期限、已募集金额、总金额
		}
		return listStr;
	}
	
	/**
	 * 翼存宝列表页，获取翼存宝某个标示的全部信息。（包括：年化收益，锁定期限，已募集金额，计息，还本）
	 * @param name 标示名称
	 * @return 标示对象
	 * @author 江渤洋 2015-12-31
	 */
	public By getECunBaoInfoAllDataBy(String name){
		
		By by = null;
		switch (name) {
		case "年化收益":	 	by = By.xpath("//p[contains(@id, 'realInterestrate_')]"); 	break;
		case "VIP": 		by = By.cssSelector("i.font16:nth-child(2)");				break;
		case "锁定期限": 		by = By.cssSelector("div.fl.mlp > .size_color_h.mt12");		break;
		case "已募集金额/总": 	by = By.cssSelector("div.fl.mlq > .size_color_h.mt12"); 	break;
		case "计息": 			by = By.cssSelector("div.ycbitem-textL > p.font_w");		break;
		case "还本": 			by = By.cssSelector("div.ycbitem-textR > p.font_w");		break;
		default: 			by = By.xpath("//p[contains(@id, 'realInterestrate_')]"); 	break;
		}
		return by;
	}
	
	/**
	 * 翼存宝列表页，获取翼存宝某个标示的全部信息。（包括：年化收益，锁定期限，已募集金额，计息，还本）
	 * @param name 标示名称
	 * @return 标示内容的集合
	 * @author 江渤洋 2015-12-31
	 */
	public List<String> getECunBaoInfoAllDataStr(String name){
		
		By by = getECunBaoInfoAllDataBy(name);
		List<String> listStr = new ArrayList<String>();
		List<WebElement> listWeb = base.getVisibleElements(by);
		int size = listWeb.size();
		for(int i = 0; i < size; i++){
			listStr.add(listWeb.get(i).getText());
		}
		return listStr;
	}
	
	/**
	 * 翼存宝列表页，校验所有VIP字母和利率
	 * @param expectStr VIP利率(例如:"+0.1%")
	 * @author 江渤洋 2015-12-31
	 */
	public void checkECunBaoInfoByVIP(String expectStr){
		
		expectStr = expectStr.replace("+", "");
		expectStr = "VIP" + expectStr;
		List<String> list = getECunBaoInfoAllDataStr("VIP");
		for (String string : list) {
			string = string.replace("\n", "");
			base.assertEqualsActualExpected(string, expectStr);
		}
	}
	
	/*******************************************/
	/********    列表页_方法_红包自动匹配返现        *********/
	/*******************************************/
	
	/**
	 * 翼存宝列表页，校验所有“红包自动匹配返现”链接
	 * @author 江渤洋 2015-5-12
	 */
	public void checkReturnCashTotalLink(){
		
		base.checkElementsVisible(returnCashTotalLink);
		List<WebElement> returnCashTotalLinkList = base.getElements(returnCashTotalLink);
//		for(int i = 0; i < returnCashTotalLinkList.size(); i++){
		for(int i = 0; i < 1; i++){
			//点击“红包自动匹配返现”
			returnCashTotalLinkList.get(i).click();
			//校验弹出窗口Title
			base.assertEqualsActualExpected(base.getElementTextWithVisible(By.xpath("//h3[text()='翼存宝红包变现规则']")), "翼存宝红包变现规则");
			//点击关闭按钮
			base.clickWithWait(returnCashCloseBtn);
		}
	}
	
	/*******************************************/
	/*********      列表页_方法_债权详情                  ********/
	/*******************************************/
	
	/**
	 * 翼存宝列表页，获取“债权详情”按钮对象
	 * @return 债权详情按钮对象集合
	 * @author 江渤洋 2016-2-4
	 */
	public List<WebElement> getBondDetailsBtn(){
		return base.getVisibleElements(bondDetails);
	}
	
	/**
	 * 翼存宝列表页，获取“债权详情”表格中的数据
	 * @return 数据对象的集合
	 * @author 江渤洋 2016-2-4
	 */
	public List<BondDetailsModel> getBondDetailsInfo(){
		
		List<WebElement> webList = getBondDetailsBtn();
		List<WebElement> infoWebList;
		List<BondDetailsModel> infoModelList = new ArrayList<BondDetailsModel>();
		BondDetailsModel bondDetailsModel = new BondDetailsModel();
		int infoWebListSize = 0;
		int rowNum = 6;
		String temp;
		for(int i = 0; i < 1; i++){
			webList.get(i).click();//点击“债权详情”按钮
			base.checkElementVisible(bondDetailsDIV);
			base.assertEqualsActualExpected(base.getElementTextWithVisible(bondDetailsDIVTitle), "债权详情");
			base.assertTrueByBoolean(base.isElementVisible(By.cssSelector("#aq")));//校验翻页按钮是否存在
			infoWebList = base.getVisibleElements(bondDetailsDIVInfo);//获取“债权详情”当前页的所有数据
			infoWebListSize = infoWebList.size();
			System.out.println("“债权详情”当前页一共 " + infoWebListSize + " 条数据");
			Reporter.log("“债权详情”当前页一共 " + infoWebListSize + " 条数据");
			for(int j = 0; j < infoWebListSize; j++){
				
				temp = infoWebList.get(j).getText();
				if(j % rowNum == 0){
					bondDetailsModel.setBorrowPurpose(temp);
				}
				else if((j - 1) % rowNum == 0){
					bondDetailsModel.setBorrowName(temp);
				}
				else if((j - 2) % rowNum == 0){
					bondDetailsModel.setIdCard(temp);
				}
				else if((j - 3) % rowNum == 0){
					bondDetailsModel.setAddress(temp);
				}
				else if((j - 4) % rowNum == 0){
					bondDetailsModel.setBorrowMoney(temp);
				}
				else if((j - 5) % rowNum == 0){//第6列为“查看详情”按钮，故添加
					infoModelList.add(new BondDetailsModel(bondDetailsModel.getBorrowName(),
							bondDetailsModel.getIdCard(),bondDetailsModel.getAddress(),
							bondDetailsModel.getBorrowMoney(),bondDetailsModel.getBorrowPurpose()));
				}
			}
		}
		clickBondDetailsDIVClose();
		return infoModelList;
	}
	
	/**
	 * 翼存宝列表页，点击“债权详情”按钮——>点击“查看详情”按钮，校验查看详情1.只显示被打开详情的借款标；2.分四栏显示标详情（基本信息）（个人资料）（担保/增额）（历史统计），统计信息与借款标信息匹配
	 * @author 江渤洋 2016-2-3
	 * 修改 江渤洋 2016-2-5
	 */
	public void checkBondDetails(){
		
		List<WebElement> list = getBondDetailsBtn();
		List<WebElement> bondDetailsDIVBtnList;
		for(int i = 0; i < 1; i++){
			list.get(i).click();//点击“债权详情”按钮
			base.checkElementVisible(bondDetailsDIV);
			base.assertEqualsActualExpected(base.getElementTextWithVisible(bondDetailsDIVTitle), "债权详情");
			base.assertTrueByBoolean(base.isElementVisible(By.cssSelector("#aq")));//校验翻页按钮是否存在
			checkBondDetailsDIVColumnValue("借款标题");
			checkBondDetailsDIVColumnValue("借款人姓名");
			checkBondDetailsDIVColumnValue("身份证号");
			checkBondDetailsDIVColumnValue("操作");
			bondDetailsDIVBtnList = base.getVisibleElements(bondDetailsDIVBtn);
			for(int j = 0; j < 1; j++){
				bondDetailsDIVBtnList.get(j).click();//点击“查看详情”按钮
				base.assertEqualsActualExpected(base.getElementTextWithVisible(By.cssSelector(".xq_content_tab_block.border>h3")), "借款描述");
				clickBondDetailsSeeTab("个人资料");
				clickBondDetailsSeeTab("担保增额");
				clickBondDetailsSeeTab("历史统计");
				bondDetailsDIVBtnList.get(i).click();//点击“查看详情”按钮
				base.isElementContainsValue(bondDetailsSeeDIV, "style", "none");
				clickBondDetailsDIVClose();
				base.isElementContainsValue(By.cssSelector("#out_all3"), "style", "none");
			}
		}
	}
	
	/**
	 * 翼存宝列表页——>点击“债权详情”按钮，校验窗口列名显示是否正常
	 * @author 江渤洋 2016-2-4
	 */
	public void checkECBBondDetailsDIVColumnName(){
		String[] columnName = {"借款标题","借款人姓名","身份证号","借款人地区","借款总额","操作"};
		List<WebElement> webList = base.getVisibleElements(bondDetailsDIVColumnName);
		int size = webList.size();
		base.assertEqualsActualExpectedByInt(size, columnName.length);
		for(int i = 0; i < size; i++){
			base.assertEqualsActualExpected(webList.get(i).getText(), columnName[i]);
		}
	}
	
	/**
	 * 翼存宝列表页——>点击“债权详情”按钮，获取窗口某列的值
	 * @param columnName 列名
	 * @return 某列值的集合
	 * @author 江渤洋 2016-2-5
	 */
	public List<String> getBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String index = "1";
		switch (columnName) {
		case "借款标题":	index = "1";	break;		
		case "借款人姓名":	index = "2";	break;	
		case "身份证号":	index = "3";	break;	
		case "借款人地区":	index = "4";	break;
		case "借款总额":	index = "5";	break;	
		case "操作":		index = "6";	break;	
		default:		index = "1";	break;	
		}
		List<WebElement> webList = base.getVisibleElements(By.cssSelector("#tenderBody .font14.color6>td:nth-child(" + index + ")"));
		for(int i = 0; i < webList.size(); i++){
			strList.add(webList.get(i).getText());
		}
		return strList;
	}
	
	/**
	 * 翼存宝列表页——>点击“债权详情”按钮，校验窗口某列的值显示是否正常
	 * @param columnName 列名
	 * @author 江渤洋 2016-2-5
	 */
	public void checkBondDetailsDIVColumnValue(String columnName){
		List<String> strList = new ArrayList<String>();
		String temp;
		strList = getBondDetailsDIVColumnValue(columnName);
		if(columnName.equals("借款标题")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				if(temp.length() > 5){
					temp = temp.substring(5);
					base.assertTrueByBoolean(temp.equals("..."));
				}
			}
		}
		else if(columnName.equals("借款人姓名")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(1);
				base.assertTrueByBoolean(temp.contains("*"));
			}
		}
		else if(columnName.equals("身份证号")){
			for(int i = 0; i < strList.size(); i++){
				temp = strList.get(i);
				temp = temp.substring(10);
				base.assertTrueByBoolean(temp.equals("********"));
			}
		}
		else if(columnName.equals("操作")){
			for(int i = 0; i < strList.size(); i++){
				base.assertEqualsActualExpected(strList.get(i), "查看详情");
			}
		}
	}
	
	/**
	 * 翼存宝列表页——>债权详情——>查看详情——>获取Tab对象
	 * @param tabName Tab名称
	 * @return Tab对象
	 * @author 江渤洋 2016-2-3
	 */
	public By getBondDetailsSeeTab(String tabName){
		String index;
		By by;
		switch (tabName) {
		case "基本信息":	index = "1";	break;
		case "个人资料":	index = "2";	break;
		case "担保增额":	index = "3";	break;
		case "历史统计":	index = "4";	break;
		default:		index = "1";	break;
		}
		by = By.cssSelector(".xq_content_t > li:nth-child(" + index + ")");
		return by;
	}
	
	/**
	 * 翼存宝列表页——>债权详情——>查看详情——>点击Tab
	 * @param tabName Tab名称
	 * @author 江渤洋 2016-2-3
	 */
	public void clickBondDetailsSeeTab(String tabName){
		By by = getBondDetailsSeeTab(tabName);
		base.clickWithWait(by);
		base.assertTrueByBoolean(base.isElementContainsValue2(by, "class", "cur"));
	}
	
	/**
	 * 翼存宝列表页——>债权详情——>查看详情——>点击X按钮
	 * @author 江渤洋 2016-2-3
	 */
	public void clickBondDetailsDIVClose(){
		base.clickWithWait(bondDetailsDIVClose);
		base.checkInvisibility(bondDetailsDIV);
	}
	
	/*******************************************/
	/*********      列表页_方法_服务协议                  ********/
	/*******************************************/
	
	/**
	 * 翼存宝列表页——>获取所有《翼龙贷在线居间服务协议》对象
	 * @return 《翼龙贷在线居间服务协议》对象集合
	 * @author 江渤洋 2016-2-4
	 */
	public List<WebElement> getServiceAgreement(){
		return base.getVisibleElements(serviceAgreement);
	}
	
	/**
	 * 翼存宝列表页——>翼龙贷在线居间服务协议——>校验协议，并返回附件一
	 * @return 债权详情的实体类集合
	 * @author 江渤洋 2016-2-4
	 */
	public List<BondDetailsModel> checkServiceAgreementAndReturnAccessoriesOne(){
		
		List<BondDetailsModel> modelList = new ArrayList<BondDetailsModel>();
		List<WebElement> linkList = getServiceAgreement();
		for(int i = 0; i < 1; i++){
			linkList.get(i).click();
			base.jumpToNewWindow();
			base.isTitle("翼龙贷在线居间服务协议");
			base.assertEqualsActualExpected(base.getElementTextWithVisible(serviceAgreementTitle), "翼龙贷在线居间服务协议");
			if(base.isElementVisible(serviceAgreementAccessories)){
				modelList = getServiceAgreementAccessoriesOne();
			}
			else{
				System.out.println("翼龙贷在线居间服务协议_附件一_没有数据");
				Reporter.log("翼龙贷在线居间服务协议_附件一_没有数据");
			}
		}
		return modelList;
	}
	
	/**
	 * 翼存宝列表页——>翼龙贷在线居间服务协议——>获取附件一的所有数据
	 * @return 债权详情的实体类集合
	 * @author 江渤洋 2016-2-4
	 */
	public List<BondDetailsModel> getServiceAgreementAccessoriesOne(){
		
		BondDetailsModel bondDetailsModel = new BondDetailsModel();//债权详情实体类
		List<BondDetailsModel> modelList = new ArrayList<BondDetailsModel>();
		List<WebElement> trWebList;
		List<WebElement> tdWebList;
		String temp;
		
		trWebList = base.getVisibleElements(By.cssSelector("#tenderBody .font14.color6"));//tr集合
		for(int i = 0; i < trWebList.size(); i++){
			tdWebList = trWebList.get(i).findElements(By.tagName("td"));
			for(int j = 0; j < tdWebList.size(); j++){
				temp = tdWebList.get(j).getText();
				if(j == 0){
					bondDetailsModel.setBorrowName(temp);
				}
				else if(j == 1){
					bondDetailsModel.setIdCard(temp);
				}
				else if(j == 2){
					bondDetailsModel.setAddress(temp);
				}
				else if(j == 3){
					bondDetailsModel.setBorrowMoney(temp);
				}
				else if(j == 4){
					bondDetailsModel.setBorrowPurpose(temp);
				}
			}
			modelList.add(new BondDetailsModel(bondDetailsModel.getBorrowName(),
					bondDetailsModel.getIdCard(),bondDetailsModel.getAddress(),
					bondDetailsModel.getBorrowMoney(),bondDetailsModel.getBorrowPurpose()));
		}
		return modelList;
	}
	
	/*******************************************/
	/******     列表页_方法_债权详情 _服务协议                ******/
	/*******************************************/
	
	/**
	 * 翼存宝列表页——>校验“债权详情”前10条数据与“服务协议附件一”前10条数据的一致性
	 * @param blist 翼存宝列表债权详情实体类集合（小于等于10条）
	 * @param slist 服务协议中债权详情实体类集合（所有数据）
	 * @author 江渤洋 2016-2-4
	 */
	public void checkBondDetailsAndServiceAgreement(List<BondDetailsModel> blist, List<BondDetailsModel> slist){
		BondDetailsModel bBondDetailsModel = new BondDetailsModel();
		BondDetailsModel sBondDetailsModel = new BondDetailsModel();
		for(int i = 0; i < blist.size(); i++){
			bBondDetailsModel = blist.get(i);
			sBondDetailsModel = slist.get(i);
			base.assertEqualsActualExpected(bBondDetailsModel.getBorrowPurpose(), sBondDetailsModel.getBorrowPurpose());
			base.assertEqualsActualExpected(bBondDetailsModel.getBorrowName(), sBondDetailsModel.getBorrowName());
			base.assertEqualsActualExpected(bBondDetailsModel.getIdCard(), sBondDetailsModel.getIdCard());
			base.assertEqualsActualExpected(bBondDetailsModel.getAddress(), sBondDetailsModel.getAddress());
			base.assertEqualsActualExpected(bBondDetailsModel.getBorrowMoney(), sBondDetailsModel.getBorrowMoney());
		}
	}
	
	/*******************************************/
	/*********      列表页_方法_加入记录                  ********/
	/*******************************************/
	
	/**
	 * 翼存宝列表页，获取购买记录元素
	 * @param productId:翼存宝产品ID
	 * @param buyRecordNum：产品记录条数，1为正数第一条，2位正数第二条...以此类推；all为所有记录
	 * @return 购买记录元素
	 * @author 江渤洋
	 */
	public By getBuyRecordBy(String productId, String buyRecordNum){
		By buyRecordBy;
		if(buyRecordNum.equals("all")){
			buyRecordBy = By.xpath("//tbody[@id='ftbody"+ productId +"']/tr/td");
		}
		else{
			buyRecordBy = By.xpath("//tbody[@id='ftbody"+ productId +"']/tr["+ buyRecordNum +"]/td");
		}
		return buyRecordBy;
	}
	
	/**
	 * 翼存宝列表页，将名字变为星号，只保留姓氏
	 * @param name：名字
	 * @return 只有姓氏，名为*
	 * @author 江渤洋
	 */
	public String userNameChange(String name){
		int length = name.length();
		name = name.substring(0, 1);
		for(int i = 0; i < length-1; i++){
			name = name + "*";
		}
		return name;
	}
	
	/**
	 * 翼存宝列表页，点击“加入记录”按钮
	 * @param productId 翼存宝产品ID
	 * @author 江渤洋
	 */
	public void clickRecordBtn(String productId){
		
		By recordBtnBy = By.xpath("//div[div[@id='poscontainer" + productId + "']]/following::div[1]/span[4]");
		try {
			base.assertEqualsActualExpectedByBoolean(base.isElementVisible(recordBtnBy), true);
		} catch (Exception e) {
			Reporter.log("翼存宝列表页，没找到产品ID为" + productId + "的“已投资记录”按钮<br/>");
			System.out.println("翼存宝列表页，没找到产品ID为" + productId + "的“已投资记录”按钮");
		}
		base.clickElementNoWait(recordBtnBy);
		base.checkElementVisible(By.cssSelector(".overflowV.wrap.list.list2263"));//校验"加入记录"列表是否显示
	}
	
	/**
	 * 翼存宝列表页，获取一条/多条购买记录
	 * @param BuyRecordBy:购买记录元素，可传一个，也可传多个
	 * @return 购买记录
	 * @author 江渤洋
	 */
	public List<WebElement> getBuyRecords(By BuyRecordBy){
		List<WebElement> list = new ArrayList<WebElement>();
		list = base.getVisibleElements(BuyRecordBy);
		return list;
	}
	
	/**
	 * 翼存宝列表页，检查翼存宝购买记录
	 * @param productId 翼存宝产品ID
	 * @param buyRecordNum 待检查购买记录条数
	 * @param userName 投资人姓名
	 * @param money 投资金额
	 * @param joinTime 加入时间（购买时间）
	 * @author 江渤洋
	 */
	public void checkRecord(String productId, String buyRecordNum, String userName, String money, String joinTime){
		clickRecordBtn(productId);
		List<WebElement> list = getBuyRecords(getBuyRecordBy(productId, buyRecordNum));
		if(list != null && !list.isEmpty()){
			String tempTime = list.get(3).getText();
			tempTime = tempTime.substring(0, tempTime.length()-3);
	//		base.assertEqualsActualExpected(list.get(0).getText(), userNameChange(userName));//验证投资人
			base.assertEqualsActualExpected(list.get(1).getText(), money + "元");//验证投资金额
			base.assertEqualsActualExpected(list.get(2).getText(), "手动购买");//验证投资方式
	//		base.assertEqualsActualExpected(tempTime, joinTime);//验证加入时间
		}
		else{
			Reporter.log("error_翼存宝列表页_加入记录没有数据<br/>");
			System.out.println("error_翼存宝列表页_加入记录没有数据");
		}
	}
	
	
	/**
	 * 翼存宝列表页，校验所有“加入记录”按钮
	 * @author 江渤洋 2015-5-12
	 */
	public void checkRecordTotalBtn(){
		
		base.checkElementVisible(recordTotalBtn);
		List<WebElement> recordTotalBtnList = base.getElements(recordTotalBtn);
//		for(int i = 0; i < recordTotalBtnList.size(); i++){
		for(int i = 0; i < 1; i++){
			//点击“已投资记录”按钮
			recordTotalBtnList.get(i).click();
			//检查按钮是否变化
			base.assertEqualsActualExpected(recordTotalBtnList.get(i).getAttribute("class"), "twojiantou shang jiantou ml10 xia");
			//校验相关层是否显示
			base.assertTrueByBoolean(getInputRecordDiv().getAttribute("style").contains("block"));
			//再点击“已投资记录”按钮
			recordTotalBtnList.get(i).click();
			//检查按钮是否变化
			base.assertEqualsActualExpected(recordTotalBtnList.get(i).getAttribute("class"), "twojiantou shang jiantou ml10");
		}
	}
	
	
	/***************************************************************/
	/***************列表页_方法_产品信息（“购买有效期”、“抢投”按钮）**************/
	/***************************************************************/
	
	/**
	 * 翼存宝列表页，获取“购买有效期”——时、分、秒
	 * @param id 翼存宝ID
	 * @return “购买有效期”元素
	 * @author 江渤洋 2015-5-15
	 */
	public By getBuyValid(String id){
		return By.xpath("//span[@id='" + id + "']/span[@class='timebj bjdingwei1']");
	}
	
	/**
	 * 翼存宝列表页，校验“购买有效期”是否有效。即，时分秒都不为0
	 * @param id 翼存宝ID
	 * @return true：表示“购买有效期”有效，即时间不全为0
	 *         false:表示“购买有效期”无效，即时间全为0
	 * @author 江渤洋 2015-5-18
	 */
	public boolean checkBuyValid(String id){
		//有效状态：默认无效(false)
		boolean valid = false;
		//获取所有的“购买有效期”元素
		List<WebElement>  buyValidList = base.getElements(getBuyValid(id));

		for(int i = 0; i < buyValidList.size(); i++){
			base.sleep(5000);
			//获取“购买有效期”
			String text = buyValidList.get(i).getText();    System.out.println("i: " + i + " 时间：" + text);//---------测试
			//如果有一位不是0，则时间有效，跳出循环
			if(!(text.equals("0"))){
				//有效状态：有效(true)
				valid = true;
				break;
			}
		}
		return valid;
	}	
	
	/**
	 * 翼存宝列表页，获得抢投按钮元素
	 * @param 翼存宝ID
	 * @author 江渤洋 2015-8-3
	 */
	public By getQiangTouBtn(String eCunBaoID){
		By by = By.xpath("//a[contains(@onclick, '" + eCunBaoID + ",') ]");
		base.checkElementVisible(by);
		return by;
	}
	
	/**
	 * 翼存宝列表页，点击抢投按钮
	 * @param eCunBaoID 翼存宝ID
	 * @author 江渤洋 2015-12-17
	 */
	public void clickQiangTouBtn(String eCunBaoID){
		
		WebElement tenderDiv = null;
//		//校验“购买有效期”是否有效，全不为0为则有效
//		isBuyValid = checkBuyValid(id);	
//		//根据按钮id，获取“时，分，秒”的值
//		if(isBuyValid){
//			return id = "0";
//		}
		//点击“抢投”按钮
		base.clickElementNoWait(getQiangTouBtn(eCunBaoID));
		//获取“抢投”按钮打开的DIV
		tenderDiv = getTenderOpenDiv();
		if(tenderDiv!=null){
			//关闭弹出窗口
			clickTenderCloseDivBtn(tenderDiv);
			Reporter.log("error_翼存宝列表页面无法投资！<br/>");
			System.out.println("error_翼存宝列表页面无法投资！");
		}
	}
	
	/**
	 * 翼存宝列表页，校验“抢投”按钮，已登录
	 * @author 江渤洋 2015-5-14
	 */
	public void checkTenderTotalBtn(){
		
		base.checkElementVisible(tenderTotalBtn);
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);
		WebElement tenderDiv = null;
		if(tenderTotalBtnList.size() != 0){
			for(int i = 0; i < 1; i++){
				//点击“抢投”按钮
				tenderTotalBtnList.get(i).click();
				//获取“抢投”按钮打开的DIV
				tenderDiv = getTenderOpenDiv();
				if(tenderDiv!=null){
					clickTenderCloseDivBtn(tenderDiv);		//关闭错误提示窗口
				}
			}
		}
		else{
			System.out.println("error_翼存宝列表页面没有抢投按钮，请手工校验");
			Reporter.log("error_翼存宝列表页面没有抢投按钮，请手工校验");
			base.assertTrueByBoolean(false);
		}
	}
	
	/**
	 * 翼存宝列表页，校验“抢投”按钮的错误提示信息
	 * @param msg 预期的错误信息
	 * @author 江渤洋 2015-12-28
	 */
	public void checkQiangTouBtnErrorMsg(String msg){
		
		String msgStr = "";
		WebElement tenderDiv = null;
		base.checkElementVisible(tenderTotalBtn);
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);
		
		if(tenderTotalBtnList.size() == 0){
			System.out.println("error_翼存宝列表页面没有抢投按钮，请手工校验");
			Reporter.log("error_翼存宝列表页面没有抢投按钮，请手工校验");
			base.assertTrueByBoolean(false);
		}
		
		for(int i = 0; i < 1; i++){
			tenderTotalBtnList.get(i).click();			//点击“抢投”按钮
			tenderDiv = getTenderErrorDiv();			//获取错误提示窗口
			msgStr = printTenderErrorDiv(tenderDiv);
			if(tenderDiv!=null){
				clickTenderCloseDivBtn(tenderDiv);		//关闭错误提示窗口
			}
			base.assertEqualsActualExpected(msgStr, msg);
		}
	}
	
	/**
	 * 翼存宝列表页， 校验“抢投”按钮，未登录
	 * @author 江渤洋 2015-5-15
	 */
	public void checkTenderTotalBtnNoLogin(){
		
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);
		if(tenderTotalBtnList.size() != 0){
			for(int i = 0; i < 1; i++){
				//点击“抢投”按钮
				tenderTotalBtnList.get(i).click();
				//检查“登录”窗口Title
				checkBannerLoginWindowTitle();
			}
		}
		else{
			System.out.println("error_翼存宝列表页面没有抢投按钮，请手动验证");
			Reporter.log("error_翼存宝列表页面没有抢投按钮，请手动验证");
		}
		
	}
	
	/**
	 * 翼存宝列表页，校验“抢投”按钮，已登录，充值
	 * @return id 翼存宝ID
	 * @author 江渤洋 2015-5-15
	 */
	public String checkTenderTotalBtnRecharge() {
		
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);
		WebElement tenderDiv = null;
//		boolean isBuyValid = false;
		String id = "-1";
		if(tenderTotalBtnList.size() == 0){
			Reporter.log("error_翼存宝列表页面没有抢投按钮<br/>");
			System.out.println("error_翼存宝列表页面没有抢投按钮");
			return id;
		}
		for(int i = 0; i < 1; i++){
			//获取“抢投”按钮的onclick事件中的产品id，例如：onclick="lender.openbuywindow(1,673,'13.50%')
			id = tenderTotalBtnList.get(i).getAttribute("onclick").split(",")[1];
//			//校验“购买有效期”是否有效，全不为0为则有效
//			isBuyValid = checkBuyValid(id);	
//			//根据按钮id，获取“时，分，秒”的值
//			if(isBuyValid){
//				return id = "0";
//			}
			//点击“抢投”按钮
			tenderTotalBtnList.get(i).click();
			//获取“抢投”按钮打开的DIV
			tenderDiv = getTenderOpenDiv();
			if(tenderDiv!=null){
				//关闭弹出窗口
				clickTenderCloseDivBtn(tenderDiv);
				Reporter.log("error_翼存宝列表页面无法投资！<br/>");
				System.out.println("error_翼存宝列表页面无法投资！");
				return id = "0";
			}
		}
		return id;
	}
	
	/**
	 * 徐天元
	 * 点击翼存宝抢投
	 */
	public boolean clickCreditBtn(){
		List<WebElement> tenderTotalBtnList = base.getElements(tenderTotalBtn);  //System.out.println("一共" + tenderTotalBtnList.size() + "个按钮");//--------测试
		if(tenderTotalBtnList.size() == 0){
			System.out.println("error_翼存宝列表页面没有抢投按钮");
		}else{
			for(int i = 0; i < 1; i++){   //System.out.println("第" + (i+1) + "个抢投按钮");//--------测试
				//点击“抢投”按钮
				tenderTotalBtnList.get(i).click();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 翼存宝列表页，获得“抢投”弹出DIV
	 * @return 弹出DIV
	 * @author 江渤洋 2015-5-14
	 */
	public WebElement getTenderOpenDiv(){
		
		String msgStr = "";
		//获取2种提示DIV
		List<WebElement> tenderDivList = base.getElements(tenderDivs);
		int i = 0, size = tenderDivList.size(); 
		//返回打开的DIV的style属性是block的; 关闭的style的属性是none。
		for(; i < size; i++){
			if(tenderDivList.get(i).getAttribute("style").contains("block")){
				if(i == 0){
					msgStr = base.getElementTextWithWait(By.cssSelector("#errorMsg"));
				}
				else if(i == 1){
					msgStr = base.getElementTextWithWait(By.cssSelector("p.textC"));
				}
				Reporter.log("error_翼存宝列表页_单击抢投按钮提示信息： " + msgStr + "<br/>");
				System.out.println("error_翼存宝列表页_单击抢投按钮提示信息： " + msgStr);
				break;
			}
			//如果没有弹出任何DIV，则返回空
			else if(
					(i == (tenderDivList.size()-1)) && (tenderDivList.get(i).getAttribute("style").contains("none"))){
				return null;
			}
		}
		return tenderDivList.get(i);
	}
	
	/**
	 * 翼存宝列表页，获得“抢投”弹出错误信息DIV
	 * @return 错误信息
	 * @author 江渤洋 2015-12-28
	 */
	public WebElement getTenderErrorDiv(){
		//获取2种提示DIV
		List<WebElement> tenderDivList = base.getElements(tenderDivs);
		int i = 0, size = tenderDivList.size(); 
		//返回打开的DIV的style属性是block的; 关闭的style的属性是none。
		for(; i < size; i++){
			if(tenderDivList.get(i).getAttribute("style").contains("block")){
				break;
			}
			else if(//如果没有弹出任何DIV，则返回空
					(i == (tenderDivList.size()-1)) && (tenderDivList.get(i).getAttribute("style").contains("none"))){
				return null;
			}
		}
		return tenderDivList.get(i);
	}
	
	/**
	 * 翼存宝列表页，输出“抢投”弹出错误信息
	 * @param tenderDiv 错误信息对象
	 * @return 错误信息
	 * @author 江渤洋 2015-12-28
	 */
	public String printTenderErrorDiv(WebElement tenderDiv){
		
		String msg = "";
		String id = base.getAttribute(tenderDiv, "id");
		if(id.equals("fastLender_2")){
			msg = base.getElementTextWithWait(By.cssSelector("#errorMsg"));
		}
		else if(id.equals("noPerson")){
			msg = base.getElementTextWithWait(By.cssSelector("p.textC"));
		}
		return msg;
	}
	
	/**
	 * 翼存宝列表页，获取操作失败DIV
	 * @return true：为存在
	 * @author 江渤洋 2015-7-7
	 */
	public boolean getOperationFailureDiv(){
		if(base.isElementContainsValue(operationFailureDiv, "style", "block")){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * 翼存宝列表页，关闭操作失败DIV
	 * @author 江渤洋 2015-7-7
	 */
	public void closeOperationFailureDiv(){
		base.clickWithWait(closeOperationFailureDiv);
	}
	
	/**
	 * 翼存宝列表页，获得关闭“抢投”DIV按钮
	 * @param id (fastLender_2,noPerson两种)
	 * @return 关闭“抢投”DIV按钮
	 * @author 江渤洋 2015-5-14
	 */
	public By getTenderCloseDivBtn(String id){
		return By.xpath("//div[@id='" + id + "']//a");
	}
	
	/**
	 * 翼存宝列表页，点击关闭“抢投”DIV按钮
	 * @param “抢投”DIV按钮
	 * @author 江渤洋 2015-5-14
	 */
	public void clickTenderCloseDivBtn(WebElement tenderDiv){
		
		//校验弹出框是否显示
		base.assertTrueByBoolean(tenderDiv.getAttribute("style").contains("block"));
		String id = tenderDiv.getAttribute("id");
		base.clickElementNoWait(getTenderCloseDivBtn(id));
		//校验弹窗口是否隐藏
		base.assertTrueByBoolean(tenderDiv.getAttribute("style").contains("none"));
	}
	
	/***************列表页_方法_投资信息（点击抢投按钮后的页面）**************/
	
	/**
	 * 翼存宝列表页，获取“可投金额”文本框
	 * @param id (每期产品对应的ID，从页面获取的)
	 * @return “可投金额”文本框
	 * @author 江渤洋 2015-5-18
	 */
	public By getInvestmentAmountTxt(String id){
		id = "wmpsYuGouAmount" + id;//System.out.println(id);//----------测试
		return By.cssSelector("#" + id);
	}
	
	/**
	 * 翼存宝列表页，点击“可投金额”文本框
	 * @param id 
	 * @author 江渤洋 2015-8-13
	 */
	public void clickInvestmentAmountTxt(String id){
		By investmentAmount = getInvestmentAmountTxt(id);
		base.clickWithWait(investmentAmount);
	}
	
	/**
	 * 翼存宝列表页，“可投金额”文本框输入金额数
	 * @param id (每期产品对应的ID，从页面获取的)
	 * @param amount(输入的金额)
	 * @author 江渤洋 2015-5-18
	 */
	public void inputInvestmentAmountTxt(String id, String amount){
		
		By investmentAmountTxt = getInvestmentAmountTxt(id);
		base.checkElement(investmentAmountTxt);
		try {
			base.getElementNoWait(investmentAmountTxt).sendKeys(amount);
		} catch (Exception e) {
			Reporter.log("error_翼存宝列表页，“可投金额”文本框未显示，请手动测试<br/>");
			System.out.println("error_翼存宝列表页，“可投金额”文本框未显示，请手动测试");
			e.printStackTrace();
		}
	}
	
	/**
	 * 翼存宝列表页，获取账户余额
	 * @param eCunBaoID 翼存宝ID
	 * @return 账户余额
	 * @author 江渤洋 2015-11-24
	 */
	public String getAccountBalance(String eCunBaoID){
		
		By accountBalance = By.cssSelector("#userBalance" + eCunBaoID);
		//不能检查“余额”是否存在
//		base.assertEqualsActualExpectedByBoolean(base.isElementPresent(accountBalance), true);
		String balanceStr = base.getElementText(accountBalance);
		balanceStr = balanceStr.substring(0, balanceStr.indexOf(" 元"));
		return balanceStr;
	}
	
	/**
	 * 翼存宝列表页，点击“最大金额”
	 * @param id (每期产品对应的ID，从页面获取的)
	 * @author 江渤洋 2015-8-13
	 */
	public void clickMaxMoney(String id){
		By maxMoney = By.xpath("//a[contains(@href,'(" + id + ")')]");
		base.clickWithWait(maxMoney);
	}
	
	/**
	 * 翼存宝列表页，获取“同意协议并投资”按钮
	 * @param id (每期产品对应的ID，从页面获取的)
	 * @author 江渤洋 2015-5-18
	 */
	public By getAgreeInvestmentBtn(String id){
		return By.xpath("//a[contains(@onclick,'" + id + "') and @class='tongyi btn dis_block reddw']");
	}
	
	/**
	 * 翼存宝列表页， 点击“同意协议并投资”按钮
	 * @param id (每期产品对应的ID，从页面获取的)
	 * @author 江渤洋 2015-5-18
	 */
	public void clickAgreeInvestmentBtn(String id){
		base.getElementNoWait(getAgreeInvestmentBtn(id)).click();
	}
	
	/**
	 * 翼存宝列表页，校验余额是否够买翼存宝
	 * @param buyBalance 账户余额
	 * @param money 购买翼存宝的金额
	 * @return true：可以购买；false:余额不足
	 * @author 江渤洋 2015-11-24
	 */
	public boolean checkECunBaoBalance(String buyBalance, String money){
		
		int moneyInt = Integer.valueOf(money);
		int index  = buyBalance.indexOf(".");
		if(index != -1){
			buyBalance = buyBalance.substring(0, index);
		}
		int buyBalanceInt = Integer.valueOf(buyBalance);//账户余额
		if(buyBalanceInt > moneyInt){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * 翼存宝列表页，点击“抢投”按钮购买翼存宝
	 * @param money 购买金额
	 * @author 江渤洋 2015-12-21
	 */
	public void qiangTou(String money){
		
		String eCunBaoId = "";	//翼存宝产品id
		String balance = ""; 	//账户余额
		
		TotalPage.openPage("我的账户", true);
		myAccountPage.turnToMyAccount("交易记录");
		myAccountPage.turnToMyAccount("账户总览");
		if(base.Windowsize() != 1){
			base.closeWebDriver();
		}
		balance = myAccountPage.getBalance_1() + ""; System.out.println("账户余额1：" + balance);//----------测试
		
		TotalPage.openPage("翼存宝列表页", true);
		eCunBaoId = checkTenderTotalBtnRecharge(); 
		System.out.println("翼存宝ID：" + eCunBaoId);
		
		//如果没有弹出无法抢投对话框，则抢投。-1 代表没有按钮，0 代表弹出错误框
		if(eCunBaoId.equals("0") || eCunBaoId.equals("-1")){
			base.assertTrueByBoolean(false);
		}
		//余额是否够
		if(!checkECunBaoBalance(balance, money)){
			Reporter.log("error_翼存宝列表页_账户余额不足，请手动校验");
			System.out.println("error_翼存宝列表页_账户余额不足，请手动校验");
			base.assertTrueByBoolean(false);
		}
		//输入金额
		inputInvestmentAmountTxt(eCunBaoId, money);
		//点击“同意协议并投资”
		clickAgreeInvestmentBtn(eCunBaoId);
		//获取操作失败DIV
		if(getOperationFailureDiv()){
			closeOperationFailureDiv();
			Reporter.log("翼存宝列表页，投资后，显示操作失败~");
			System.out.println("翼存宝列表页，投资后，显示操作失败~");
			base.assertTrueByBoolean(false);
		}
		
		TotalPage.openPage("我的账户", true);
		myAccountPage.turnToMyAccount("交易记录");
		myAccountPage.turnToMyAccount("账户总览");
		if(base.Windowsize() != 1){
			base.closeWebDriver();
		}
		String newBalance = myAccountPage.getBalance_1() + ""; System.out.println("账户余额2：" + newBalance);//----------测试
		checkBuySuccess(balance, newBalance,money);//校验购买是否成功
	}
	
	public void qiangTou(String eCunBaoId, String money){
		
		String balance = ""; //账户余额
		
		TotalPage.openPage("我的账户", true);
		myAccountPage.turnToMyAccount("交易记录");
		myAccountPage.turnToMyAccount("账户总览");
		if(base.Windowsize() != 1){
			base.closeWebDriver();
		}
		balance = myAccountPage.getBalance_1() + ""; System.out.println("账户余额1：" + balance);//----------测试
		
		TotalPage.openPage("翼存宝列表页", true);
		//余额是否够
		if(!checkECunBaoBalance(balance, money)){
			Reporter.log("error_翼存宝列表页_账户余额不足，请手动校验");
			System.out.println("error_翼存宝列表页_账户余额不足，请手动校验");
			base.assertTrueByBoolean(false);
		}
		//点击“抢投”按钮
		clickQiangTouBtn(eCunBaoId);
		//输入金额
		inputInvestmentAmountTxt(eCunBaoId, money);
		//点击“同意协议并投资”
		clickAgreeInvestmentBtn(eCunBaoId);
		//获取操作失败DIV
		if(getOperationFailureDiv()){
			closeOperationFailureDiv();
			Reporter.log("翼存宝列表页，投资后，显示操作失败~");
			System.out.println("翼存宝列表页，投资后，显示操作失败~");
			base.assertTrueByBoolean(false);
		}
		
		TotalPage.openPage("我的账户", true);
		myAccountPage.turnToMyAccount("交易记录");
		myAccountPage.turnToMyAccount("账户总览");
		if(base.Windowsize() != 1){
			base.closeWebDriver();
		}
		String newBalance = myAccountPage.getBalance_1() + ""; System.out.println("账户余额2：" + newBalance);//----------测试
		checkBuySuccess(balance, newBalance,money);//校验购买是否成功
	}
	
}
