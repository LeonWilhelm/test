package com.eloancn.shared.pages;

import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
/*
 * 翼星计划详情页
 */
public class EStarDetailPage {
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	
	public static By DetailPart = By.cssSelector("div.wtplan_box_detail.mt25");							//上部翼星计划信息
	
	//左侧状态图显示
	By LeftIcon = By.cssSelector(".wtplan_box_detail.mt25>div"); 										//左侧状态图
	public By compluteIcon = By.cssSelector("div.wtplan_box_left.complute");							//已售罄的状态图
	public By endIcon = By.cssSelector("div.wtplan_box_left.end");										//已结束的状态图
	public By goingIcon = By.cssSelector("div.wtplan_box_left.going");									//进行中的状态图
	By InvestorNum = By.xpath("//div[15]/div/div/div/p/span");											//左侧图片中投资人数
	By PlanMoney = By.xpath("//p[3]/span");																//左侧图片中“计划总额”
	
	//右侧保障星、收益星、责任性显示
	public static By EStarTitleinDetail = By.cssSelector("div.wtplan_box_right.pdb25>div>h1");			//翼星计划详情页的标题
	By OpenSoonTxt = By.cssSelector("span.wtplan_box_left.going");										//右上角的“即将开放”
	By FastInvestLnk = By.xpath("//a[text()='快速投资']");													//“快速投资”链接
	public static By InvestNowLnk = By.cssSelector("a.wtplan_td6.wtplan_line_btn.go");					//有效的“快速投资”链接
	By CloseLoginLnk = By.cssSelector("div.tit>a.close");												//关闭“登录”按钮
	By LoginBackground = By.cssSelector("div.loginBg");													//登录窗口后的背景显示
	public static By Background = By.cssSelector(".wtplan_blackbg");//div.wtplan_blackbg				//弹出投资窗口后的背景显示
	public static By BZStarInvestNowLnk = By.xpath("//body/div[15]/div/div[2]/div[2]/div/div[6]/a");	//保障星“快速投资”链接
	By DetailTxt = By.cssSelector(".wtplan_detail_c");//div.wtplan_detail_c								//保障星或收益星“详情介绍”下的显示内容
	By BZStarInfo = By.xpath("//div[@class='wtplan_box_right pdb25']/div[2]/div/div");				//保障星条目信息（募集金额、利率、借款期限、清算方式）
	By BZStarMoney = By.xpath("//div[2]/div[2]/div/div[2]");											//保障星计划投资金额
	By BZStarInvestRate = By.id("wutInter1");															//保障星利率
	By BZStarDetailLnk = By.xpath("//div[@class='wtplan_box_right pdb25']/div[2]/div[2]");				//保障星“详情介绍”链接
	By BZStarDetailPart = By.xpath("//div[@class='wtplan_box_right pdb25']/div[2]/div[4]");				//保障星“详情介绍”下的显示内容
	By BZStarIntroTxt = By.cssSelector("div.wtplan_detail_l");											//保障星文字介绍:"本息无忧 还款即用 多重保障"
	By PITxt = By.cssSelector("div.wtplan_detail_l>p");													//保障星文字介绍:"本息无忧 还款即用 多重保障"
	By BZStarSaleTimeTxt = By.cssSelector("table.ratetable>tbody>tr>td");								//保障星开售时间：“2015-09-09开售”
	By BZStarjoinmemberTxt = By.xpath("//div[4]/div[2]/table/tbody/tr/td[2]");							//保障星已加入 人次，剩余可投资金 万元
	By BZStarInvestorNum = By.cssSelector("table.ratetable>tbody>tr>td>span.colorfb");					//保障星已加入人次数字
	public static By SYStarInvestNowLnk= By.xpath("//div[@class='wtplan_box_right pdb25']/div[3]/div/div[6]/a");//收益星“快速投资”链接
	By SYStarInfo = By.xpath("//div[@class='wtplan_box_right pdb25']/div[3]/div/div");					//收益星条目信息（募集金额、利率、借款期限、清算方式）
	By SYStarMoney = By.xpath("//div[3]/div/div[2]");													//收益星计划投资金额
	By SYStarInvestRate = By.id("wutInter2");															//收益星利率
	By SYStarDetailLnk = By.xpath("//div[@class='wtplan_box_right pdb25']/div[3]/div[2]");				//收益星“详情介绍”链接
	By SYStarDetailPart = By.xpath("//div[@class='wtplan_box_right pdb25']/div[3]/div[4]");				//收益星“详情介绍”下的显示内容
	By SYStarIntroTxt = By.xpath("//div[@class='wtplan_box_right pdb25']/div[3]/div[4]/div");			//收益星文字介绍:"本息无忧 还款即用 多重保障"
	By SYStarSaleTimeTxt = By.xpath("//div[3]/div[4]/div[2]/table/tbody/tr/td");						//收益星开售时间：“2015-09-09开售”
	By SYStarjoinmemberTxt = By.xpath("//div[3]/div[4]/div[2]/table/tbody/tr/td[2]");					//收益星已加入 人次，剩余可投资金 万元
	By SYStarInvestorNum = By.xpath("//div[3]/div[4]/div[2]/table/tbody/tr/td[2]/span");				//收益星已加入人次数字
	By ZRStarMoney = By.xpath("//div[2]/div[4]/div/div[2]");											//责任星计划投资金额
	
	//详细规则、债权推荐人、债权构成、投资记录、投资评论
	By FiveLnks = By.cssSelector("div.wtplandetail_record_t>ul>li");									//“详细规则、债权推荐人、债权构成、投资记录、投资评论” 链接
	By DetailedRulesLnk = By.xpath("//div[2]/div/ul/li");												//“详细规则”链接
	By RulesLine = By.cssSelector("table.wtplan_ruletable>tbody>tr");									//详细规则第一行或行数
	By RuleNames = By.xpath("//table[@class='wtplan_ruletable']/tbody/*/th");							//详细规则中的副标题
	By RuleDetails = By.xpath("//table[@class='wtplan_ruletable']/tbody/*/td");							//详细规则中的具体时间人数等的说明
	By ReferrerLnk = By.xpath("//div[@class='wtplandetail_record_t']/ul/li[2]");						//"债权推荐人"链接
	public static By ReferrerAddressLnk = By.cssSelector("#wut>div>table>tbody>tr>td>a");				//"债权推荐人"-“担保公司名称”链接
	By InvestRecordLnk = By.xpath("//div[2]/div/ul/li[4]");												//“投资记录”链接
	By RecordSubtile = By.cssSelector("#wut>div.financial_hot_list>table>thead");						//投资记录中的副标题
	By InvestorNumTxt = By.cssSelector("span.colorF0");													//投资记录中的"投资人数"数字
	By LastOnePage = By.xpath("//div[@id='Pagination']/ul/li[text()='>']");								//末页的前一个链接
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");										//目前页
	By SecondLnk = By.xpath("//div[@id='Pagination']/ul/li[2]");
	By SixPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");										//页数的第6个链接
	By LastPage = By.xpath("//div[@id='Pagination']/ul/li[text()='末页']");								//末页
	By LastTwoPage = By.xpath("//div[@id='Pagination']/ul/li[last()-2]");								//末页的前两个链接
	By EmptyPage = By.cssSelector("li.pgNext.pgEmpty");
	By InvestorLines = By.cssSelector("#wut>div.financial_hot_list>table>tbody>tr");					//投资记录列表的行数
	By InvestorTxt = By.xpath("//div[@id='wut']/div/table/tbody/*/td");									//投资人显示
	By InvestRateTxt = By.xpath("//div[@id='wut']/div/table/tbody/*/td[3]");							//投资人的投资利率显示
	By InvestMoneyTxt = By.xpath("//div[@id='wut']/div/table/tbody/*/td[2]");							//投资人的投资金额显示
	By LastInvestTime = By.xpath("//div[@id='wut']/div/table/tbody/tr[last()]/td[4]");
	By InvestCommentLnk = By.xpath("//div[2]/div/ul/li[5]");											//“投资评论”链接
	By CommentTxt = By.cssSelector("div.to_say>p.font18");												//“向债权推荐人进行评论吧”文本
	By InputComment = By.id("content");																	//评论的输入框
	By SubmitBtn = By.cssSelector("a.to_comment");														//“提交”评论按钮
	By SubmittedContent = By.cssSelector("div.qa_content>p.mt5");										//提交后的评论内容
	By SubmittedTime = By.cssSelector("div.qa_content>p.mt5>span");
	By RegisterAndLoginLnk = By.xpath("//div[@id='newsReviewList']/div/p[2]");							//注册成为会员后方可回复  注册|登录
	By Img = By.cssSelector("div.comperson>div.pic");											

	//保障星投资窗口
	public static By BZStarInvestTitle = By.cssSelector("#wtplan_alert1 > div.wtplan_alert_t");			//“投资信息”标题行
	By BZStarNeedAmountTxt = By.id("needAmount1");														//“还需额度”的金额
	By BZStarBalanceTxt = By.id("userBalance1");														//“可用余额”的金额
	By InputAmount = By.id("wutBuyAmount1");															//“输入金额”的输入框
	By AutoInputLnk = By.cssSelector("#wtplan_alert1>div>table>tbody>tr>td>a.hui");						//“自动输入”链接
	By InputBZStarPayPwd = By.id("payPwd1");															//“支付密码”输入框
	By InputBZStarValidateCode = By.id("wutRandCode1");													//“验证码”输入框
	By yanZhengMaImg = By.cssSelector("#checkverificationCode_fast > a > img");							//“验证码”图片
	By BZStarAgreeCheckbox = By.id("xy1");																//“我已阅读并同意《保障星投资人···”的复选框
	By BZStarOkBtn = By.cssSelector("#wtplan_alert1>div>p>input.wtplan_quedingbtn.ml15");				//“确定”投资按钮
	By BZStarCancelBtn = By.cssSelector("#wtplan_alert1>div>p>input.wtplan_quxiaobtn");					//“取消”投资按钮
	By InvestSuccessTxt = By.cssSelector("div.msg_ico.success_ico");									//“投资成功”文本提示
	By CloseInvestSuccessLnk = By.cssSelector("#wtplan_alert4>div>a.wtplan_close_x");					//投资成功窗口“关闭”链接
	By IndividualViewLnk = By.id("tzSuccess");															//“到个人中心查看”链接
	By MonthPlanTxt = By.id("monthBack");																//我的账户-我的投资计划-本月应收的计划

	//收益星投资窗口
	public static By SYStarRiskTitle = By.cssSelector("#wtplan_alert3 > div.wtplan_alert_t");			//“风险提示”标题行
	By SYStarInvestTitle = By.cssSelector("#wtplan_alert2>div.wtplan_alert_t");							//“投资信息”标题行
	By DenyBtn = By.xpath("//input[@value='拒绝']");														//“拒绝”按钮
	By AgreeBtn = By.xpath("//input[@value='同意']");														//“同意”按钮
	By CloseSYStarInvestBoxLnk = By.cssSelector("#wtplan_alert2>div>a.wtplan_close_x");					//投资窗口“关闭”链接
	By SYStarNeedAmountTxt = By.id("needAmount2");														//“还需额度”的金额
	By SYStarBalanceTxt = By.id("userBalance2");														//“可用余额”的金额
	By InputSYStarAmount = By.id("wutBuyAmount2");														//“输入金额”的输入框
	By AutoInputSYStarLnk = By.xpath("//a[contains(text(),'自动输入')]");									//“自动输入”链接
	By InputSYStarPayPwd = By.id("payPwd2");															//“支付密码”输入框
	By InputSYStarValidateCode = By.id("wutRandCode2");													//“验证码”输入框
	By SYStarAgreeCheckbox = By.id("xy2");																//“我已阅读并同意《借款协议》，符合···”的复选框
	By SYStarOkBtn = By.xpath("//input[@value='确定']");													//“确定”投资按钮
	By SYStarCancelBtn = By.xpath("//input[@value='取消']");												//“取消”投资按钮
	
	//检查是否在翼星计划详情页
	public boolean ifinDetailPage(){
		return base.isElementPresent(DetailPart);
	}
	//检查翼星计划详情页
	public void verifyEStarDetail(){
		try{
			base.checkElement(LeftIcon);
			clickBZStarDetailLnk();
			clickSYStarDetailLnk();
	//		base.checkNoElement(DetailTxt);
			base.checkElmentText(DetailTxt, "");
			List<WebElement> FiveLnk = base.getElements(FiveLnks);
			String [] LnkTxts = {"详细规则","债权推荐人","债权构成","投资记录","投资评论"};
			for(int i = 0; i < FiveLnk.size(); i++){
				base.assertEqualsActualExpected(FiveLnk.get(i).getText(), LnkTxts[i]);
			}	
			base.closeAndjumptoOldWindow();
		}catch(Exception e){
			base.closeAndjumptoOldWindow();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//检查投资人次、计划总额、资产包标题显示
	public void checkInvestInfo(String planmoney){
		
//		try{
		String totalNum = base.getElementTextWithWait(InvestorNum);//图片中人次显示
		String BZNum = base.getElementTextWithWait(BZStarInvestorNum);//保障星详情介绍中人次
		String SYNum = base.getElementTextWithWait(SYStarInvestorNum);//收益星详情介绍中人次
		clickCreditReferrerLnk();
		String referrerName = base.getElementTextWithWait(ReferrerAddressLnk);
		if(referrerName.contains("...")){
			referrerName=referrerName.substring(0,referrerName.length()-3);
		}				
		clickInvestRecordLnk();
		String NumTxt = base.getElementTextWithWait(InvestorNumTxt);//记录中显示的投资人数
		int referrernum = 0,size =getRecordNum();//获取记录的总数，并跳转到最后一页
		for(int j=0;j<=1;j++){
			List<WebElement> lastpage = base.getElements(InvestorTxt);
			int lastpagenum=lastpage.size();
			for(int i=0;i<lastpagenum;i++){
				if(lastpage.get(i).getText().contains(referrerName)){
					referrernum=referrernum+1;//投资责任星人次
				}
			}
			String current = base.getElementTextWithWait(CurrentPage);
			base.clickWithWait(SecondLnk);
			base.sleep(2000);
			if(base.getElementTextWithWait(CurrentPage).equals(current)){//如果只有一页退出，否则跳到前一页检查责任星投资
				break;
			}		
		}	
		base.assertTrueByBoolean(NumTxt.equals(totalNum) && size==(Integer.parseInt(BZNum)+Integer.parseInt(SYNum)+referrernum));
		String PlanMoneys = base.getElementTextWithWait(PlanMoney);
		String BZMoney = base.getElementTextWithWait(BZStarMoney);//210万元
		String SYMoney = base.getElementTextWithWait(SYStarMoney);
		String ZRMoney = base.getElementTextWithWait(ZRStarMoney);
		BZMoney = BZMoney.substring(0, BZMoney.length()-2);
		SYMoney = SYMoney.substring(0, SYMoney.length()-2);
		ZRMoney = ZRMoney.substring(0, ZRMoney.length()-2);
		double amount = Double.parseDouble(BZMoney)+Double.parseDouble(SYMoney)+Double.parseDouble(ZRMoney);
		String amount1=new DecimalFormat("###,##0.#").format(amount);
		base.assertTrueByBoolean(PlanMoneys.equals(planmoney) && PlanMoneys.equals(amount1));
		base.closeAndjumptoOldWindow();
//		}catch(Exception e){
//			base.closeAndjumptoOldWindow();
//			Assert.fail(e.toString());
//		}
	}
	//检查保障星—募集金额、利率、借款期限、清算方式跟列表页显示一致
	public void checkBZStarLoanDetail(ArrayList<String> info){
		
		try{
			List<WebElement> detail = base.getElements(BZStarInfo);
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0;i<4;i++){
				String infos = detail.get(i+1).getText();
				if(i==0 && infos.contains(".") && infos.split("\\.")[1].length()==3){
					infos = infos.split("万元")[0]+"0"+"万元";
				}
				list.add(infos);
			}
			base.assertTrueByBoolean(info.size()==list.size());
			base.assertTrueByBoolean(info.equals(list));
			base.closeWebDriver();
		}catch(Exception e){
			base.closeWebDriver();
			e.printStackTrace();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//检查收益星—募集金额、利率、借款期限、清算方式跟列表页显示一致
	public void checkSYStarLoanDetail(ArrayList<String> info){
		
		try{
			List<WebElement> detail = base.getElements(SYStarInfo);
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0;i<4;i++){
				list.add(detail.get(i+1).getText());
			}
			base.assertTrueByBoolean(info.size()==list.size());
			base.assertTrueByBoolean(info.equals(list));
			base.closeWebDriver();
		}catch(Exception e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//检查保障星—详情介绍
	public void checkBZStarDetailIntro(int num){
		
		try{
			base.checkElementVisible(BZStarDetailPart);
			base.assertEqualsActualExpected("本息无忧\n还款即用\n多重保障", base.getElementTextWithWait(BZStarIntroTxt));
			String time = base.getElementTextWithWait(BZStarSaleTimeTxt);//开售时间
			base.assertEqualsActualExpected(time.substring(4,5), "-");
			base.assertEqualsActualExpected(time.substring(7,8), "-");
			base.assertEqualsActualExpected(time.substring(10,12), "开售");
			
			String joinmember = base.getElementTextWithWait(BZStarjoinmemberTxt);//已加入2人次，剩余可投资金1.38万元
			String rate = base.getElementTextWithWait(BZStarInvestRate);//保障星条目中的利率:10.5%
			if(rate.contains(".")){//10.5%
				int index = rate.indexOf(".")+1;
				int index2 = rate.indexOf("%");
				String dian = rate.substring(index,index2);
				if(dian.length()==1){
					dian = dian+"0";
					rate = rate.substring(0,index)+dian+rate.substring(index2);
				}
			}
			clickInvestRecordLnk();
			int j=0,m=0,size=0,page=getRecordPages();
			for(int n=1;n<=page;n++){
				base.checkElmentText(CurrentPage, String.valueOf(n));
				List<WebElement> rates = base.getElements(InvestRateTxt);			//投资利率列表
				List<WebElement> money = base.getElements(InvestMoneyTxt);			//投资金额列表
				size = rates.size();
				for(int i=0;i<size;i++){
					if(rates.get(i).getText().equals(rate)){
						j = j+1;													//投资保障星人数
						String invest = money.get(i).getText().substring(1);		//投资了保障星的投资金额
						invest = invest.replaceAll(",", "");
						m= m+Integer.parseInt(invest);							//已投资保障星的总金额
					}
				}
				base.clickWithWait(LastOnePage);
			}
			String ZRTime = base.getElementTextWithWait(LastInvestTime);
			base.assertEqualsActualExpected(time, ZRTime+"开售");
			String BZMoney = base.getElementTextWithWait(BZStarMoney);
			double amount = Double.parseDouble(BZMoney.substring(0, BZMoney.length()-2));//募集金额
			String investing = new DecimalFormat("###,##0.##").format(amount-m/10000.0);
			base.assertEqualsActualExpected("已加入"+j+"人次，剩余可投资金"+investing+"万元", joinmember);
			if(num == 2){
				base.closeAndjumptoOldWindow();
			}
		}catch(Exception e){
			if(num == 2){
				base.closeAndjumptoOldWindow();
			}
			e.printStackTrace();
			Assert.fail();
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//检查收益星—详情介绍
	public void checkSYStarDetailIntro(int num){
		
		try{
			base.checkElementVisible(SYStarDetailPart);
			base.assertEqualsActualExpected("超高收益\n抵押担保\n风险可控", base.getElementTextWithWait(SYStarIntroTxt));
			String BZtime = base.getElementTextWithWait(BZStarSaleTimeTxt);//开售时间
			String time = base.getElementTextWithWait(SYStarSaleTimeTxt);//开售时间
			base.assertEqualsActualExpected(time, BZtime);
			base.assertEqualsActualExpected(time.substring(4,5), "-");
			base.assertEqualsActualExpected(time.substring(7,8), "-");
			base.assertEqualsActualExpected(time.substring(10,12), "开售");
				
			String joinmember = base.getElementTextWithWait(SYStarjoinmemberTxt);//已加入2人次，剩余可投资金1.38万元
			String rate = base.getElementTextWithWait(SYStarInvestRate);//收益星条目中的利率:16%
			if(rate.contains(".")){//16% 
				int index = rate.indexOf(".")+1;
				int index2 = rate.indexOf("%");
				String dian = rate.substring(index,index2);//5
				if(dian.length()==1){
					dian = dian+"0";//50
					rate = rate.substring(0,index)+dian+rate.substring(index2);
				}
			}
			clickInvestRecordLnk();
			int j=0,m=0,size=0,page=getRecordPages();
			for(int n=1;n<=page;n++){
				base.checkElmentText(CurrentPage, String.valueOf(n));
				List<WebElement> rates = base.getElements(InvestRateTxt);			//投资利率列表
				List<WebElement> money = base.getElements(InvestMoneyTxt);			//投资金额列表
				size = rates.size();
				for(int i=0;i<size;i++){
					if(rates.get(i).getText().equals(rate)){
						j = j+1;													//投资保障星人数
						String invest = money.get(i).getText().substring(1);		//投资了保障星的投资金额
						invest = invest.replaceAll(",", "");
						m= m+Integer.parseInt(invest);							//已投资保障星的总金额
					}
				}
				base.clickWithWait(LastOnePage);
			}
			String SYMoney = base.getElementTextWithWait(SYStarMoney);
			double amount = Double.parseDouble(SYMoney.substring(0, SYMoney.length()-2));//募集金额
			String investing = new DecimalFormat("###,##0.##").format(amount-m/10000.0);
			base.assertEqualsActualExpected("已加入"+j+"人次，剩余可投资金"+investing+"万元", joinmember);
			if(num == 2){
				base.closeWebDriver();
			}
		}catch(Exception e){
			if(num == 2){
				base.closeWebDriver();
			}
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//点击“保障星”详情介绍
	public void clickBZStarDetailLnk(){
		base.clickElementNoWait(BZStarDetailLnk);
	}
	//点击“收益星”详情介绍
	public void clickSYStarDetailLnk(){
		base.clickElementNoWait(SYStarDetailLnk);
	}
	//
	/**
	 * 点击“快速投资”链接
	 * @author 刘京
	 * 2015-7-20  江渤洋，添加checkLoginTitle()方法
	 */
	public void clickFastInvestLnk(){
		if(base.getLnkElementText(new LoginPage().RegisterLnk, "class").contains("hide")){
			base.clickWithWait(InvestNowLnk);
			try{
				base.checkElementVisible(LoginPage.LoginBox);
			}catch(Exception e){
				base.closeAndjumptoOldWindow();
				Assert.fail(e.toString());
			}
		}else{
			base.clickWithWait(InvestNowLnk);
		}
	}
	public void clickCloseLoginLnk(){
		base.clickElementNoWait(CloseLoginLnk);
		base.assertTrueByBoolean(!base.isBlock(LoginBackground));
	}
	//点击“详细规则”链接
	public void clickDetailedRulesLnk(){
		base.clickWithWait(DetailedRulesLnk);
		base.checkElement(RulesLine);
	}
	//检查详细规则中的数据显示
	public void checkDetailedRulesData(int num){
		try{
			String [] name = {"时间","人数","起投金额","收益","计息时间","收息时间","投资期限","付息方式","退出方式"};
			String [] detail ={"以当期发布为准","不限人数","保障星起投金额为100元，并以正整数倍递增；收益星起投金额为500元，并以正整数倍递增","以当期发布为准","满包后次日计息","每月20日收息","以当期发布为准","保障星为每月付息，到期还本。收益星为到期清算","不可退出"};		
			List<WebElement> names = base.getElements(RuleNames);
			List<WebElement> details = base.getElements(RuleDetails);
			for(int i=0;i<9;i++){
				base.assertEqualsActualExpected(names.get(i).getText(), name[i]);
				base.assertEqualsActualExpected(details.get(i).getText(), detail[i]);
			}
			if(num ==2){
				base.closeWebDriver();
			}
		}catch(Exception e){
			if(num ==2){
				base.closeWebDriver();
			}
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//点击“债权推荐人”链接
	public void clickCreditReferrerLnk(){
		base.clickWithWait(ReferrerLnk);
		base.checkElement(ReferrerAddressLnk);
	}
	//点击“债权推荐人”的地址
	public void clickReferrerAddressLnk(){
		int window = base.Windowsize();
		base.clickElementNoWait(ReferrerAddressLnk);
		if(base.Windowsize()==window){
			base.clickElementNoWait(ReferrerAddressLnk);
		}
		base.turnToNewPage();
		base.getWebDriver().manage().window().maximize();
		base.checkElement(CreditReferrerDetailPage.ReferrerPage);
	}
	//点击“投资记录”链接
	public void clickInvestRecordLnk(){
		base.clickWithWait(InvestRecordLnk);
		base.checkElement(RecordSubtile);
	}
	//获取“投资记录”的页数
	public int getRecordPages(){
		int NumTxt = Integer.parseInt(base.getElementTextWithWait(InvestorNumTxt));
		int page;
		if(NumTxt==0){
			page=0;
		}else{
			page =NumTxt%10 == 0 ? (NumTxt/10) : (NumTxt/10)+1;
		}
		return page;
	}
	//获取““投资记录”的条数
	public int getRecordNum(){
		if(base.isElementPresent(SixPageLnk)){
			base.clickWithWait(LastPage);
			base.checkElmentText(EmptyPage, ">");
			base.checkElementVisible(LastTwoPage);
			int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
			return 10*(lastPageNum-1)+base.getElements(InvestorLines).size();
		}else{
			return base.getElements(InvestorLines).size();
		}
		
	}
	//点击“投资评论”链接
	public void clickInvestCommentLnk(){
		base.clickWithWait(InvestCommentLnk);
		base.checkElement(CommentTxt);
	}
	//输入评论内容
	public void InputComment(String content){
		base.sendKeysWithWait(InputComment, content);
	}
	//点击“提交”
	public String clickSubmitBtn(){
		base.clickWithWait(SubmitBtn);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar cal = Calendar.getInstance();
        return dateFormat.format( base.getTime());	  
	}
	//检查未登录时投资评论
	public void checkCommentwithoutLogin(){
		
		try{
			base.checkNoElement(SubmitBtn);
			base.checkElementVisible(InputComment);
			base.assertEqualsActualExpected(base.getElementTextWithWait(RegisterAndLoginLnk), "注册成为会员后方可回复  注册|登录");
			base.closeWebDriver();
		}catch(Exception e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//检查登录时投资评论
	public void checkCommentwithLogin(int num){
		
		try{
			base.assertEqualsActualExpected(base.getElementTextWithWait(SubmitBtn), "提交");
			InputComment("");
			clickSubmitBtn();
			base.assertEqualsActualExpected(base.getAlertwithWait().getText(), "请输入评论内容！");
			base.acceptAlert();
			if(base.indexURL.contains("client")){
				InputComment("1");
				clickSubmitBtn();
				base.checkElmentText(SubmittedContent, "1");
				base.checkElementVisible(InputComment);
				InputComment("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefg");
				clickSubmitBtn();
				base.checkElmentText(SubmittedContent,"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefg");
			}else if(base.indexURL.contains("test")||base.indexURL.contains("www")){
				InputComment("下期翼星计划什么时候发");
				clickSubmitBtn();
				base.checkElmentText(SubmittedContent, "下期翼星计划什么时候发");
			}
			base.checkElementVisible(InputComment);
			InputComment("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefgh");
			clickSubmitBtn();
			base.assertEqualsActualExpected(base.getAlertwithWait().getText(), "输入字数最大500字");
			base.acceptAlert();
			if(num ==2){
				base.closeAndjumptoOldWindow();
			}
		}catch(Exception e){
			if(num ==2){
				base.closeAndjumptoOldWindow();
			}
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	
	//点击保障星“快速投资”链接
	public void clickBZStarInvestNowLnk(){
		if(base.getElementText(IndexPage.userName).equals("")){
			base.clickWithWait(BZStarInvestNowLnk);
			base.checkElement(LoginPage.LoginBox);
		}else{
			base.clickWithWait(BZStarInvestNowLnk);
			base.assertTrueByBoolean(base.getElementTextWithWait(BZStarInvestTitle).contains("投资信息"));			
		}
	}
	//检查保障星“自动输入”
	public void checkBZStarAutoInput(){
		try{
			String NeedAmount = base.getElementText(BZStarNeedAmountTxt);
			String Balance = base.getElementText(BZStarBalanceTxt);
			int NeedMoney = Integer.valueOf(NeedAmount).intValue();
			if(Balance.contains(".")){
				int endIndex = Balance.lastIndexOf(".");
				Balance = Balance.substring(0, endIndex);			
			}
			int BalanceMoney = Integer.valueOf(Balance).intValue();
			if(NeedMoney<=BalanceMoney){
				base.assertEqualsActualExpected(base.getLnkElementText(InputAmount, "value"),String.valueOf(NeedMoney/100));
			}else{
				base.assertEqualsActualExpected(base.getLnkElementText(InputAmount, "value"),String.valueOf(BalanceMoney/100));
			}
			base.closeAndjumptoOldWindow();
		}catch(Exception e){
			base.closeAndjumptoOldWindow();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//点击保障星投资自动输入链接
	public void clickAutoInputBZStarLnk(){
		base.clickElementNoWait(AutoInputLnk);
	}
	//输入保障星投资支付密码
	public void InputBZStarPayPwd(String pwd){
		base.elementSendkey(InputBZStarPayPwd, pwd);
	}
	//输入保障星投资验证码
	public void InputValidateCode(){
		String ValidateCode = new Data().get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
		base.elementSendkey(InputBZStarValidateCode, ValidateCode);
	}
	//选中保障星投资阅读并同意协议
	public void CheckAgreeDeal(){
		base.clickElementNoWait(BZStarAgreeCheckbox);
	}
	//点击保障星投资“确定”按钮
	public void clickOkBtn(){
		base.clickElementNoWait(BZStarOkBtn);
		base.checkElmentText(InvestSuccessTxt, "投资成功");
	}
	
	//点击保障星投资“取消”按钮
	public void clickBZStarCancelBtn(){
		base.clickElementNoWait(BZStarCancelBtn);
		base.checkNoElement(BZStarCancelBtn);
//		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	//关闭“投资成功”窗口
	public void clickCloseSuccessLnk(){
		base.clickElementNoWait(CloseInvestSuccessLnk);
		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	//点击“到个人中心查看”
	public void clickViewLnk(){
		base.clickElementNoWait(IndividualViewLnk);
		base.checkElement(MonthPlanTxt);
	}
	//点击收益星“快速投资”链接
	public void clickSYStarInvestNowLnk(){
		base.clickWithWait(SYStarInvestNowLnk);
	}
	//点击收益星“拒绝”风险提示按钮
	public void clickDenyBtn(){
		base.clickWithWait(DenyBtn);
		base.checkNoElement(DenyBtn);
		base.checkElementVisible(EStarTitleinDetail);
//		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	//点击收益星“同意”风险提示按钮
	public void clickAgreeBtn(){
		base.clickWithWait(AgreeBtn);
		base.assertTrueByBoolean(base.getElementTextWithWait(SYStarInvestTitle).contains("投资信息"));
	}
	//关闭“收益星”投资窗口
	public void clickSYStarCloseBoxBtn(){
		base.clickElementNoWait(CloseSYStarInvestBoxLnk);
		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	//点击收益星投资自动输入链接
	public void clickAutoInputSYStarLnk(){
		base.clickWithWait(AutoInputSYStarLnk);
	}
	//检查收益星“自动输入”
	public void checkSYStarAutoInput(){
		try{
			String NeedAmount = base.getElementText(SYStarNeedAmountTxt);
			String Balance = base.getElementText(SYStarBalanceTxt);
			if(Balance.contains(".")){
				int endIndex = Balance.lastIndexOf(".");
				Balance = Balance.substring(0, endIndex);
			}
			int NeedMoney = Integer.valueOf(NeedAmount).intValue();
			int BalanceMoney = Integer.valueOf(Balance).intValue();
			if(NeedMoney<=BalanceMoney){
				base.assertEqualsActualExpected(base.getLnkElementText(InputSYStarAmount, "value"),String.valueOf(NeedMoney/500));
			}else{			
				base.assertEqualsActualExpected(base.getLnkElementText(InputSYStarAmount, "value"),String.valueOf(BalanceMoney/500));
			}
			base.closeAndjumptoOldWindow();
		}catch(Exception e){
			base.closeAndjumptoOldWindow();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//点击收益星投资支付密码输入框
	public void clickSYStarPayPwd(){
		base.clickElementNoWait(InputSYStarPayPwd);
	}
	//输入收益星投资支付密码
	public void InputSYStarPayPwd(String pwd){
		base.elementSendkey(InputSYStarPayPwd, pwd);
	}
	//输入收益星投资验证码
	public void InputSYStarValidateCode(){
		String ValidateCode = new Data().get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
		base.elementSendkey(InputSYStarValidateCode, ValidateCode);
	}
	//选中收益星投资阅读并同意协议
	public void CheckSYStarAgreeDeal(){
		base.clickElementNoWait(SYStarAgreeCheckbox);
	}
	//点击收益星投资窗口“确定”按钮
	public void clickSYStarOkBtn(){
		base.clickElementNoWait(SYStarOkBtn);
		base.checkElmentText(InvestSuccessTxt, "投资成功");
	}
	//点击收益星投资窗口“取消”按钮
	public void clickSYStarCancelBtn(){
		base.clickWithWait(SYStarCancelBtn);
		base.assertTrueByBoolean(!base.isBlock(Background));
	}
}
