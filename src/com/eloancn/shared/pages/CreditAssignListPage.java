package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;

/*
 * “债权转让列表”页面
 */
public class CreditAssignListPage {
	
	Base base = new Base();
	Data data = new Data();
	IndexPage indexPage = new IndexPage();
	public String CreditAssignmentUrl = base.indexURL+"/new/loadAllPublishingCreditAssignList.action";
	
	By Search = By.xpath("//div[@class='wrap mt15 overflowV']/div/*/dl/dt");
	By ModeOption = By.cssSelector("#modeDiv>dl>dd");
	By DsbjOption = By.cssSelector("#dsbjDiv>dl>dd");
	By SyqxOption = By.cssSelector("#syqxDiv>dl>dd");
	By LoanTipTxt = By.cssSelector("h2");
	
	By CreditAssignListTxt = By.cssSelector(".font20");
	By AllCredit = By.cssSelector("div.lendtable>dl>dt");				//列表各个债权标题
	By AllCreditClient = By.cssSelector(".wd200.fl.h40.pdl25");	
	public static By CreditTitle = By.cssSelector("div.lendtable>dl span");

	By AllPaginationLnk = By.xpath("//div[@id='Pagination']/ul/li");					//页数
	By LastPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");						//页数的第6个链接
	public static By FirstCreditTitle = By.cssSelector("a.color3");						//第一个债权标题
	public static By WaitPrincipalTxt = By.xpath("//div[2]/div[3]/dl/dd");				//待收本金金额
	public static By WaitPrincipalTxts = By.cssSelector("dd.wd130.fl.h40.textC.colorE6");
	public static By InterestRateTxt = By.xpath("//div[2]/div[3]/dl/dd[2]");			//利率数量
	public static By CurrentAndAllPeriodTxt = By.xpath("//div[2]/div[3]/dl/dd[3]");		//当期/总期
	public static By TransferModeTxt = By.xpath("//div[2]/div[3]/dl/dd[4]/i");			//转让模式
	public static By BuyNoworEndBtn = By.cssSelector("dd.wd140.fl.h40.textC>a");		//立刻出价或立刻购买或已结束
	public static By BuyNowBtn = By.cssSelector("a.fast_money.mt8.ml25");				//立刻出价或立刻购买
	By EndBtn = By.cssSelector("a.fast_buy.mt8.ml25");									//已结束
	By BuyNowLnk1 = By.id("buy"+"*");
	By CloseLoginLnk = By.cssSelector("div.tit>a.close");	
	By LoginBackground = By.cssSelector("div.loginBg");

	By IncomeCalculatorLnk = By.cssSelector("a.lcjsq.fr");				//收益计算器
	By CloseCalculatorBtn = By.cssSelector("a.count-close.fr");			//关闭收益计算器
	By FAQLnk = By.xpath("//div[@class='loan_tip_auto']/*/a");								//债权转让常见问题
	By BeginnerGuide = By.xpath("//a[text()='新手指南']");				//新手指南
	By SearchBtn = By.id("findHelpContentBtn");							//搜索问题
	
	By FixedPriceMode = By.xpath("//div[@id='modeDiv']/dl/dd[2]");		//一口价
	By AuctionMode = By.xpath("//div[@id='modeDiv']/dl/dd[3]");			//拍卖
	By SecretTransferMode = By.xpath("//div[@id='modeDiv']/dl/dd[4]");	//密转
//	By SelectedMode = By.cssSelector("dd.bg86");
	By SelectedMode = By.cssSelector("#modeDiv dd.bg86");//江渤洋改 2015-7-13
	
	//弹出“购买债权”窗口
	public static By BuyCreditTip = By.id("loan_buy_tip");
	By BuyCreditTxt = By.cssSelector("div.tit.bdT > span.fl");
	By CashTip = By.cssSelector("div.lytt>h2.u-tt");
	By InputSecretTransferCode = By.id("transforCode");
	By AddNumberLnk = By.id("addnum");
	By CurrentPrice = By.id("upsetprice");
	By WaitPI = By.id("dfbx");
	By BalancePrice = By.id("userbalance");
	By InputPrice = By.id("currnum");
	By InputPayPwd = By.id("paypassword");
	By InputValidateCode = By.id("creditCode");
//	By yanZhengMaImg = By.cssSelector("#checkverificationCode_fast > a > img");
	By yanZhengMaImg = By.cssSelector("#boximage>img");
	By OkBtn = By.cssSelector("input.loan_btn_Ok");
	By CancelBtn = By.cssSelector("input.loan_btn_Cannel");
	By ContinueBuyBtn = By.xpath("//div[@id='loan_bid_tip1']/p[2]/input");
//	By SuccessTip = By.id("loan_bid_tip");
	By CloseTipLnk = By.cssSelector("#loan_bid_tip>div.tit>a.close");			//关闭成功窗口
	By BackListLnk = By.id("backButton");
	By LoanBackground = By.id("loan_buy_bg");
	public static By SuccessTxt = By.id("buy_success_tip");
	
	public void verifyDataLnk(){
		String [] Searches = {"转让模式：","待收本金：","剩余期限："};
		base.checkElement(Search);
		List<WebElement> SearchTxt = base.getElements(Search);
		for(int i = 0; i<3; i++){
			base.assertEqualsActualExpected(SearchTxt.get(i).getText(), Searches[i]);
		}
		String [] ModeTxt = {"不限","一口价","拍卖","密转"};
		String [] DsbjTxt = {"不限","1000元以下","1000～3000元","3000～10000元","10000元以上"};
		String [] SyqxTxt = {"不限","3个月以下","4-6个月","7-11个月","12个月以上"};
		List<WebElement> Modes = base.getElements(ModeOption);
		List<WebElement> Dsbjs = base.getElements(DsbjOption);
		List<WebElement> Syqxs = base.getElements(SyqxOption);
		for(int i=0;i<4;i++){
			base.assertEqualsActualExpected(Modes.get(i).getText(),ModeTxt[i]);
			base.assertEqualsActualExpected(Dsbjs.get(i).getText(),DsbjTxt[i]);
			base.assertEqualsActualExpected(Syqxs.get(i).getText(),SyqxTxt[i]);
		}
		base.assertEqualsActualExpected(Dsbjs.get(4).getText(),DsbjTxt[4]);
		base.assertEqualsActualExpected(Syqxs.get(4).getText(),SyqxTxt[4]);
		base.assertEqualsActualExpected(base.getElementText(LoanTipTxt),"债权转让常见问题");
		String [] Tips = {"什么是债权转让？","如何转让已有的债权？","债权转让需不需要通知债务人！","获得债权后是否可以再转让！"};
		List<WebElement> TipTxt = base.getElements(FAQLnk);
		for(int i=0;i<4;i++){
			base.assertEqualsActualExpected(TipTxt.get(i).getText(),Tips[i]);
			if(i==3){
				base.assertEqualsActualExpected(TipTxt.get(i).getAttribute("href"), "javascript:loadQuest(62);");
			}else{
				base.assertEqualsActualExpected(TipTxt.get(i).getAttribute("href"), "javascript:loadQuest(61);");
			}
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(CreditAssignListTxt),"债权转让列表");
		clickIncomeCalculatorLnk();
		clickCloseCalculatorBtn();
	}
	
	//选择“一口价”转让模式
	public void clickFixedPriceMode(){
		base.clickWithWait(FixedPriceMode);
		base.checkElmentText(SelectedMode, "一口价");
	}
	//选择“拍卖”转让模式
	public void clickAuctionMode(){
		base.clickWithWait(AuctionMode);
		base.checkElmentText(SelectedMode, "拍卖");
	}
	//选择“密转”转让模式
	public void clickSecretTransferMode(){
		base.clickWithWait(SecretTransferMode);
		base.checkElmentText(SelectedMode, "密转");
	}
	//点击“债权转让常见问题”链接
	public void clickFQALnk(){
		base.clickElementNoWait(FAQLnk);
//		base.checkTitle("翼龙贷帮助中心");
		base.checkElement(SearchBtn);
	}
	//点击“收益计算器”
	public void clickIncomeCalculatorLnk(){
		base.clickWithWait(IncomeCalculatorLnk);
		base.checkElement(CloseCalculatorBtn);
	}
	//关闭收益计算器
	public void clickCloseCalculatorBtn(){
		base.clickElementNoWait(CloseCalculatorBtn);
		base.checkElement(IncomeCalculatorLnk);
	}
	//点击第一条债权转让的标题
	public void clickFirstCreditTitle(){
		base.clickElementNoWait(FirstCreditTitle);
	}
	public Boolean ifshowCreditAssign(){
		return base.isElementVisible(CreditAssignListPage.FirstCreditTitle);
//		return base.isElementPresent(CreditAssignListPage.FirstCreditTitle);
	}
	//点击第一条债权转让的标题
	public void clickFirstDebtTitle(){
		String Title = base.getElementText(FirstCreditTitle);	
//		int window = base.Windowsize();
//		if(base.Windowsize()==window){
		base.clickWithWait(FirstCreditTitle);	
//		}
		base.jumpToNewWindow();
		base.checkElement(CreditDetailPage.DetailPart);
		base.assertEqualsActualExpected(base.getElementTextWithWait(CreditDetailPage.CreditTitleinDetail), Title);
	}
	public Boolean ifshowCreditforBuy(){
		
		Boolean result = false;
		if(base.isElementPresent(CreditAssignListPage.BuyNoworEndBtn)){
			if(!base.getElementText(CreditAssignListPage.BuyNoworEndBtn).equals("已结束")){		
				result = true;
			}
		}	
		return result;
	}
	public void verifyDebtData(){
		try{
			String WaitPrincipal = base.getElementText(WaitPrincipalTxt);
			String InterestRate = base.getElementText(InterestRateTxt);
			String Periods = base.getElementText(CurrentAndAllPeriodTxt);
			int position = Periods.lastIndexOf("/");
			int EndDate =  Integer.valueOf(Periods.substring(position+1)).intValue();
			int BeginDate =  Integer.valueOf(Periods.substring(0,position)).intValue();
			String TransferMode= base.getElementText(TransferModeTxt);
			clickFirstDebtTitle();
			base.assertEqualsActualExpected(base.getElementText(CreditDetailPage.WaitPrincipalTxt), "待收本金：￥"+WaitPrincipal+"元");
			base.assertEqualsActualExpected(base.getElementText(CreditDetailPage.InterestRateTxt)+"%", InterestRate);
			base.assertEqualsActualExpected(base.getElementText(CreditDetailPage.TransferModeTxt), TransferMode);
			base.assertEqualsActualExpected(base.getElementText(CreditDetailPage.RemainDateTxt), String.valueOf(EndDate-BeginDate+1));
			if(!base.getElements(CreditDetailPage.BuyNowBtn).isEmpty()){
				if(base.getLnkElementText(CreditDetailPage.BuyNowBtn,"value").equals("立刻购买")){
					base.assertEqualsActualExpected(base.getLnkElementText(CreditDetailPage.BuyNowBtn,"value"),"立刻购买");
				}else{
					base.assertEqualsActualExpected(base.getLnkElementText(CreditDetailPage.BuyNowBtn,"value"),"立刻出价");
				}
			}
			base.closeWebDriver();
		}catch(Exception e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//是否存在可购买的小于100元的债权转让
	public Boolean compareCreditMoney(){
		Boolean result = false;
		List<WebElement> BuyNowBtns = base.getElements(BuyNowBtn);
		int size = BuyNowBtns.size();
		for(int i =0 ; i<size ; i++){		
			String onclick = BuyNowBtns.get(i).getAttribute("onclick");
			String id = onclick.split("'")[1];
			String WaitPrincipalTxt = base.getElementText(By.xpath("//dd[@id="+id+"]/preceding::dd[4]"));
			WaitPrincipalTxt=WaitPrincipalTxt.replaceAll(",", "");
			float WaitPrincipal = Float.parseFloat(WaitPrincipalTxt);
			float number;
			if(base.indexURL.contains("test")||base.indexURL.contains("www")){
				number = 100;
			}else{
				number = 5000;
			}		
			if(WaitPrincipal>0 && WaitPrincipal<=number){
				base.clickElement(BuyNowBtn, i);
				if(base.isAlertPresent(10)){
					base.acceptAlert();
					System.out.println("用户不能购买自己的债权！更换账号购买！");
					Reporter.log("<br/>用户不能购买自己的债权！更换账号购买！");
					base.logout();
					new LoginPage().login(Data.tel_run_zhaiquan2,Data.password, Data.zzmm, Data.test4_tel,Data.test4_password, Data.test4_zzmm);
					base.openBrowser(CreditAssignmentUrl);
					base.clickElement(BuyNowBtn, i);
				}	
//				}else{
					String currentprice= base.getElementTextWithWait(CurrentPrice);
					String waitPI = base.getElementText(WaitPI);
					String balancePrice = base.getElementText(BalancePrice);
					waitPI=waitPI.replaceAll(",", "");
					float MyPrice =  Float.parseFloat(currentprice);
					float waitPIPrice = Float.parseFloat(waitPI);
					float balanceprice = Float.parseFloat(balancePrice);
					if((MyPrice+1)<waitPIPrice && balanceprice>=(MyPrice+1)){
						result = true;
						break;
					}else{
						clickCancelBtn();
					}
//				}
			}
		}
		return result;
	}
	
	//点击某个债权的“立刻出价”或“立刻购买”
	public void clickIndexBuyNowBtn(int index){
		base.clickElement(BuyNowBtn, index);
	}
	//是否显示“立刻出价”或“立刻购买”
	public Boolean ifshowBuyNowBtn(){
		return base.isElementPresent(CreditAssignListPage.BuyNowBtn);
	}
	//点击第一条债权的“立刻出价”或“立刻购买”
	public void clickFirstBuyNowBtn(){
		
		if(base.getLnkElementText(new LoginPage().RegisterLnk, "class").contains("hide")){
			base.clickWithWait(BuyNowBtn);
			base.checkElementVisible(LoginPage.LoginBox);
		}else{
			base.clickWithWait(BuyNowBtn);	
		}	
		if(base.Windowsize()>1){
			base.turnToOldPage();
		}
	}
	//点击关闭登录页
	public void clickCloseLoginLnk(){
		
		if(base.isElementPresentNoWait(LoginPage.Iframe)){
			base.switchToFrame("loginBoxFrame");
		}
		base.clickWithWait(CloseLoginLnk);
		base.fromFrameToDefaultContent();
		base.checkElementVisible(CreditAssignListTxt);
	}
	public void checkAlert(){
		if(base.isAlertPresent(10)){
			base.assertEqualsActualExpected(base.getAlert().getText(), "不能购买自己的债权");
		}
	}
	//输入“密转码”
	public void InputTransferCode(){
		base.checkElement(InputSecretTransferCode);
		base.elementSendkey(InputSecretTransferCode, "4521");
	}
	//点击我要出价的“+”
	public void clickAddLnk(){
		base.checkElement(AddNumberLnk);
		base.clickWithWait(AddNumberLnk);
	}
	//比较竞拍价格和代收本息
	public Boolean comparePrice(){
		String currentprice= base.getElementText(CurrentPrice);
		String waitPI = base.getElementText(WaitPI);
		float MyPrice =  Float.valueOf(currentprice).floatValue();
		float waitPIPrice = Float.valueOf(waitPI).floatValue();
		if((MyPrice+1)>waitPIPrice){
			return false;
		}else{			
			return true; 
		}
	}
	//输入“我要出价”的金额
	public void InputMyPrice(){
		String Price= base.getElementText(CurrentPrice);
		int MyPrice =  Integer.valueOf(Price).intValue();
		base.sendKeyAndWait(InputPrice, String.valueOf(MyPrice+1));
	}
	//输入“支付密码”
	public void InputPayPwd(String pwd){
		base.sendKeyAndWait(InputPayPwd, pwd);
	}
	//输入“验证码”
	public void InputValidateCode(){
//		String ValidateCode = data.get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
//		base.elementSendkey(InputValidateCode, ValidateCode);
		base.clickWithWait(yanZhengMaImg);
	}
	//输入“确定”按钮
	public void clickOkBtn(){
		base.clickElementNoWait(OkBtn);
	}
	public void clickCancelBtn(){
		base.clickElementNoWait(CancelBtn);
		base.assertTrueByBoolean(!base.isBlock(LoanBackground));
	}
	//点击“继续拍卖”按钮
	public void clickContinueBtn(){
		base.clickWithWait(ContinueBuyBtn);
		base.sleep(10000);
//		base.checkElmentwithTxt(SuccessTxt, "恭喜您出价成功");
	}
	//点击成功拍卖的关闭链接
	public void clickCloseSuccessLnk(){
		base.clickWithWait(CloseTipLnk);
		base.checkNoElement(CloseTipLnk);
		base.checkElementVisible(CreditAssignListTxt);
//		base.assertTrueByBoolean(!base.isBlock(LoanBackground));
	}
	//检查购买成功拍卖的债权
	public void CheckBuySuccess(String txt){
		if(base.getElementTextWithWait(SuccessTxt).equals("验证码错误")){
			clickCloseSuccessLnk();
			System.out.println("验证码错误");
			Assert.fail("验证码错误!");
		}else{
			base.assertEqualsActualExpected(base.getElementText(SuccessTxt), txt);
			clickCloseSuccessLnk();
		}
	}
	//点击“返回债权转让列表”链接
	public void clickBackListLnk(){
		base.clickElementNoWait(BackListLnk);
		base.assertTrueByBoolean(!base.isBlock(LoanBackground));
	}
	//获得债权转让的总数
	public int getNumofAllCredit(){
		
		if(base.getElements(LastPageLnk).isEmpty()){
			if(base.getElements(AllCredit).isEmpty()){
				return 0;
			}else{
				return base.getElements(AllCredit).size();
			}
		}else{
			int paginationsize = base.getElements(AllPaginationLnk).size();//13
			base.clickElementNoWait(By.xpath("//div[@id='Pagination']/ul/li["+paginationsize+"]"));
			int lastPageNum = Integer.valueOf(base.getElementText(By.xpath("//div[@id='Pagination']/ul/li["+(paginationsize-2)+"]"))).intValue();
			int CreditNuminCurrentPage= base.getElements(AllCredit).size();
			return (lastPageNum-1)*10+CreditNuminCurrentPage;
		}
	}	
	//验证分页
	public void verifyCreditPagination(){
		
		if(base.getElements(LastPageLnk).isEmpty()){
			if(base.getElements(AllCredit).isEmpty()){
				System.out.println("没有债权转让信息！");
				Reporter.log("没有债权转让信息！");
			}else{
				int CreditNuminFirstPage = base.getElements(AllCredit).size();
				if(CreditNuminFirstPage<=10){
					System.out.println("第一页有"+CreditNuminFirstPage+"条债权转让信息！");
				}else{
					Assert.fail("最多只能有10条债权转让信息！");
				}
			}
		}else{
//			int CreditNuminFirstPage = base.getElements(AllCredit).size();//刘京原来代码
			//江渤洋临时修改 2015-7-10
			int CreditNuminFirstPage;
			if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
				CreditNuminFirstPage = base.getElements(AllCreditClient).size();
			}
			else{
				CreditNuminFirstPage = base.getElements(AllCredit).size();
			}
			//修改end
			if(CreditNuminFirstPage==10){
				System.out.println("第一页有10条债权转让信息！");
			}else{
				Assert.fail("第一页债权转让数目显示错误！");
			}
		}
	}		
}
