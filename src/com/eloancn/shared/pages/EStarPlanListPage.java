package com.eloancn.shared.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;

/*
 * “翼星计划”列表页面
 */
public class EStarPlanListPage {
	
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	
	public String EStarPlanUrl = base.indexURL+"/wut/loadAllWutRecords.action";				
	//上部banner
	public static By ViewDetailLnk = By.cssSelector("a.ban_detailebtn");								//查看详情
	By StarImg = By.cssSelector("div.stars>img");														//星星图标
	By TxtBelowImg = By.cssSelector("div.wrap posiR>div");//size=6										//星星文本
	
	//收益计算器
	By IncomeCalculatorLnk = By.cssSelector("div.calculator_ico");										//收益计算器链接
	By CloseCalculatorBtn = By.cssSelector(".count-close.fr");											//关闭收益计算器  a.count-close.f
	
	//翼星计划页面信息
	public static By AllPlan = By.cssSelector("div.wtplan_box.mt25");									//一整条翼星计划产品
	By SixPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");										//页数的第6个链接
	public static By AllPaginationLnk = By.xpath("//div[@id='Pagination']/ul/li");						//页数
	
	//状态图
	By LeftIconLnk = By.cssSelector("div.wtplan_box.mt25>a");											//产品左侧的状态图
	public By compluteIcon = By.cssSelector("a.wtplan_box_left.complute");								//已售罄的状态图
	public By endIcon = By.cssSelector("a.wtplan_box_left.end");										//已结束的状态图
	public By goingIcon = By.cssSelector("a.wtplan_box_left.going");									//进行中的状态图
	public By PlanMoney = By.xpath("//a/div/p[2]/span");					       			 			//左侧状态图中“计划总额”
	//翼星计划产品
	public static By FirstEStarTitle = By.cssSelector("a.wtplan_link_h1");		   			 			//翼星计划产品标题
	By EStarTitleForInvest = By.xpath("//span[@class='wtplan_td6 wtplan_line_btn go']/ancestor::div[3]/preceding::a[1]");//可投资的翼星计划标题
	By DueDateTxt = By.cssSelector("span.wtplan_time.font20.colorff.fr");								//右上角的截止时间
	By OpenSoonTxt = By.cssSelector("span.wtplan_time.font20.colorff.fr");								//右上角的“即将开放”文字
	public static By InvestNowLnk = By.cssSelector("span.wtplan_td6.wtplan_line_btn.go");				//“快速投资”链接
	By OpenSoonLnk = By.cssSelector("span.wtplan_td6.wtplan_line_btn.over");							//无效的“即将开放、已满、快速投资”链接
	By CloseLoginLnk = By.cssSelector("div.tit>a.close");												//登录窗口的“关闭”链接
	By LoginBackground = By.cssSelector("div.loginBg");													//登录窗口后的背景显示
	public static By Background = By.cssSelector("div.wtplan_blackbg");									//弹出投资窗口后的背景显示

	//保障星，收益星，责任星
	By ThreeLines = By.cssSelector("div.table-container.wtplan_table");									//保障星，收益星，责任星三行
	By BZStarInfo = By.xpath("//div[@class='wtplan_box_right']/div[2]/div/div");						//保障星信息（募集金额、利率、借款期限、清算方式）
	By SYStarInfo = By.xpath("//div[@class='wtplan_box_right']/div[3]/div/div");						//收益星信息（募集金额、利率、借款期限、清算方式）
//	public static By BZStarInvestNowLnk = By.cssSelector("div.wtplan_box_right>div:nth-child(4)>div>div.wtplan_table_td7.fl>span.wtplan_td6.wtplan_line_btn.go");
//	public static By SYStarInvestNowLnk = By.cssSelector("div.wtplan_box_right>div:nth-child(5)>div>div.wtplan_table_td7.fl>span.wtplan_td6.wtplan_line_btn.go");
	public static By BZStarInvestNowLnk = By.xpath("//div[@class='pdb20']/following-sibling::div[1]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']");//保障星有效的“快速投资”按钮
	public static By SYStarInvestNowLnk = By.xpath("//div[@class='pdb20']/following-sibling::div[2]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']");//收益星有效的“快速投资”按钮
	By EStarTitleforInvestBZStar = By.xpath("//div[@class='pdb20']/following-sibling::div[1]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']/ancestor::div[3]/preceding::a[1]");//可投资的保障星的产品标题
	By EStarTitleforInvestSYStar = By.xpath("//div[@class='pdb20']/following-sibling::div[2]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']/ancestor::div[3]/preceding::a[1]");//可投资的收益星的产品标题
	public static By FirstBZStarInvestLnk = By.xpath("//body/div[18]/div[2]/div/div[2]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']");//第一条产品保障星的有效的“快速投资”按钮
	public static By FirstSYStarInvestLnk = By.xpath("//body/div[18]/div[2]/div/div[3]/div/div[7]/span[@class='wtplan_td6 wtplan_line_btn go']");//第一条产品收益星的有效的“快速投资”按钮
	
	//保障星投资窗口
	By BZStarInvestTitle = By.cssSelector("#wtplan_alert1 > div.wtplan_alert_t");						//“投资信息”标题行
	By InputAmount = By.id("wutBuyAmount1");															//“输入金额”的输入框
	By BZStarNeedAmountTxt = By.id("needAmount1");														//“还需额度”的金额
	By BZStarBalanceTxt = By.id("userBalance1");														//“可用余额”的金额
	By BZStarCalculateTxt = By.xpath("//div[@id='wtplan_alert1']/div[2]/table/tbody/tr[4]/td/span");	// *100=100元
	By InputPayPwd = By.id("payPwd1");																	//“支付密码”输入框
	By InputValidateCode = By.id("wutRandCode1");														//“验证码”输入框
	By yanZhengMaImg = By.cssSelector("#checkverificationCode_fast > a > img");							//“验证码”图片
//	By AgreeCheckbox = By.id("xy1");
	By AgreeCheckbox = By.xpath("//div[@id='wtplan_alert1']/div[2]/p/input");							//“我已阅读并同意《保障星投资人···”的复选框
	By OkBtn = By.cssSelector("#wtplan_alert1>div>p>input.wtplan_quedingbtn.ml15");						//“确定”投资按钮
	By InvestSuccessTxt = By.cssSelector("div.msg_ico.success_ico");									//“投资成功”文本提示
	By InvestErrorTxt = By.cssSelector("div.msg_ico.error_ico");										//“输入错误”文本提示
	By ShowErrorTxt = By.id("showError");																//详细的错误信息
	By CloseInvestSuccessLnk = By.cssSelector("#wtplan_alert4>div>a.wtplan_close_x");					//投资成功窗口“关闭”链接
	By CloseInvestErrorLnk = By.cssSelector("#wtplan_alert5>div>a.wtplan_close_x");						//投资失败窗口“关闭”链接
	By IndividualViewLnk = By.id("tzSuccess");															//“到个人中心查看”链接
	By MonthPlanTxt = By.id("monthBack");																//我的账户-我的投资计划-本月应收的计划
	
	//收益星投资窗口
	public static By SYStarRiskTitle = By.cssSelector("#wtplan_alert3 > div.wtplan_alert_t");			//“风险提示”标题行
	public static By SYStarInvestTitle = By.cssSelector("#wtplan_alert2>div.wtplan_alert_t");			//“投资信息”标题行
	By DenyBtn = By.xpath("//input[@value='拒绝']");														//“拒绝”按钮
	By AgreeBtn = By.xpath("//input[@value='同意']");														//“同意”按钮
	By CloseSYStarInvestBoxLnk = By.cssSelector("#wtplan_alert2>div>a.wtplan_close_x");					//投资窗口“关闭”链接
	By InputSYStarAmount = By.id("wutBuyAmount2");														//“输入金额”的输入框
	By SYStarNeedAmountTxt = By.id("needAmount2");														//“还需额度”的金额
	By SYStarCalculateTxt = By.cssSelector("span.font16.color6");										// *500=500元
//	By ShowAmountTxt = By.id("showBuyAmount2");
	By InputSYStarPayPwd = By.id("payPwd2");															//“支付密码”输入框
	By InputSYStarValidateCode = By.id("wutRandCode2");													//“输入金额”的输入框
	By SYStarAgreeCheckbox = By.id("xy2");																//“我已阅读并同意《借款协议》，符合···”的复选框
	By SYStarOkBtn = By.xpath("//input[@value='确定']");													//“确定”投资按钮
	By SYStarCancelBtn = By.xpath("//input[@value='取消']");												//“取消”投资按钮
	
	//检查翼星计划列表页分页
	public void verifyYXPlanPagination(){
		base.checkElement(ViewDetailLnk);
		if(base.isElementPresent(SixPageLnk)){
			int PlanNuminFirstPage = base.getElements(AllPlan).size();
			if(PlanNuminFirstPage==10){
				System.out.println("第一页有10条翼星计划产品信息！");
			}else{
				Assert.fail("第一页债权转让数目显示错误！");
			}

		}else{
			if(base.isElementPresent(AllPlan)){
				int PlanNuminFirstPage = base.getElements(AllPlan).size();
				if(PlanNuminFirstPage<=10){
					System.out.println("第一页只有"+PlanNuminFirstPage+"条翼星计划信息！");
				}else{
					Assert.fail("第一页最多只能有10条翼星计划信息！");
				}
			}else{
				System.out.println("没有翼星计划信息！");
			}

		}
	}
	//获得翼星计划产品的总数
	public int getNumofAllPlan(){
		if(base.getElements(SixPageLnk).isEmpty()){
			if(base.getElements(AllPlan).isEmpty()){
				return 0;
			}else{
				return base.getElements(AllPlan).size();
			}
		}else{
			int paginationsize = base.getElements(AllPaginationLnk).size();
			base.clickElementNoWait(By.xpath("//div[@id='Pagination']/ul/li["+paginationsize+"]"));
			int lastPageNum = Integer.valueOf(base.getElementText(By.xpath("//div[@id='Pagination']/ul/li["+(paginationsize-2)+"]"))).intValue();
			int CreditNuminCurrentPage= base.getElements(AllPlan).size();
			return (lastPageNum-1)*10+CreditNuminCurrentPage;
		}
	}
	//检查翼星计划列表页数据
	public void verifyDataLnk(){
		base.assertEqualsActualExpected(base.getLnkElementText(ViewDetailLnk, "href"), base.indexURL+"/page/wut/wutDetail.jsp");
		List<WebElement> StarImgs = base.getElements(StarImg);
		String ImgUrl = base.indexURL+"/page/wut/images/";
		String [] pngs = {"star1.png","star2.png","star3.png","star4.png"};
		for(int i = 0; i< StarImgs.size();i++){
			base.assertEqualsActualExpected(StarImgs.get(i).getAttribute("src"), ImgUrl+pngs[i]);
		}
		String [] txts = {"分散投资\n债权组包发售，将个案\n控制变为概率控制。","全程透明\n借款人、推荐人、不良率、\n保证金，均为您展示。","双重增信\n担保增信加债权内部增信，\n双重增信，更有保障。","结构收益\n省心投资，专业投资，总\n有一\"颗\"适合您！"};
		List<WebElement> Txt = base.getElements(TxtBelowImg);
		for (int i =0;i<Txt.size();i++){
			base.assertEqualsActualExpected(Txt.get(i+2).getText(), txts[i]);
		}	
		clickIncomeCalculatorLnk();
		clickCloseCalculatorBtn();
		String href = base.indexURL+"/wut/loadWutRecordDetail.action?id=";
		if(base.isElementPresent(AllPlan)){
			List<WebElement> Lines = base.getElements(ThreeLines);
			for(int i = 0 ;i <Lines.size();i++){
				Lines.get(i).isDisplayed();
			}
			String id = base.getLnkElementText(DueDateTxt, "id");
			base.assertEqualsActualExpected(base.getLnkElementText(LeftIconLnk,"href"),href+id);
			base.assertEqualsActualExpected(base.getLnkElementText(FirstEStarTitle,"href"), href+id);
		}
	}
	//点击“查看详情”
	public void clickViewDetailLnk(){
		base.clickElementNoWait(ViewDetailLnk);
	}
	//点击收益计算器图标
	public void clickIncomeCalculatorLnk(){
		base.clickElementNoWait(IncomeCalculatorLnk);
		base.checkElement(CloseCalculatorBtn);
	}
	//关闭收益计算器
	public void clickCloseCalculatorBtn(){
		base.clickWithWait(CloseCalculatorBtn);
		base.checkElement(IncomeCalculatorLnk);
	}
	//是否存在翼星计划产品
	public Boolean ifshowEStarPlan(){
		return base.isElementPresent(EStarPlanListPage.FirstEStarTitle);
	}
	
	//点击状态图
	public void clickIcon(By by1,By by2){
		if(base.isElementPresent(by1)){
			base.clickWithWait(by1);
			base.jumpToNewWindow();
			base.assertTrueBy(by2);
			base.closeAndjumptoOldWindow();
		}else{
			String status = by1.toString().split("\\.")[3];
			System.out.println("没有"+status+"状态的翼星计划！");
			Reporter.log("没有"+status+"状态的翼星计划！"+"<br/>");
		}
	}
	
	//点击第一条翼星计划产品标题
	public void clickFirstEStarTitle(){
		base.checkElement(FirstEStarTitle);
		String Title = base.getElementText(FirstEStarTitle);
		int window = base.Windowsize();
		base.clickElementNoWait(FirstEStarTitle);	
		if(base.Windowsize()==window){
			base.clickElementNoWait(FirstEStarTitle);
		}
		base.jumpToNewWindow();
		base.assertEqualsActualExpected(base.getElementTextWithWait(EStarDetailPage.EStarTitleinDetail), Title);
	}
	
	//点击可以投资的翼星计划产品标题
	public void clickEStarTitleforInvest(){
//		String Title = base.getElementText(EStarTitleForInvest);
		int window = base.Windowsize();
		base.clickElementNoWait(EStarTitleForInvest);	
		if(base.Windowsize()==window){
			base.clickElementNoWait(EStarTitleForInvest);
		}
		base.jumpToNewWindow();
		base.checkElement(EStarDetailPage.DetailPart);
//		base.assertEqualsActualExpected(base.getElementText(EStarDetailPage.EStarTitleinDetail), Title);
	}
	//点击可以投资收益星的翼星计划产品标题
	public void clickTitleforInvestSYStar(){
		base.checkElement(EStarTitleforInvestSYStar);
		String Title = base.getElementText(EStarTitleforInvestSYStar);
		int window = base.Windowsize();
		base.clickElementNoWait(EStarTitleforInvestSYStar);	
		if(base.Windowsize()==window){
			base.clickElementNoWait(EStarTitleforInvestSYStar);
		}
		base.jumpToNewWindow();
		base.checkElement(EStarDetailPage.DetailPart);
		base.assertEqualsActualExpected(base.getElementText(EStarDetailPage.EStarTitleinDetail), Title);
	}
	//点击可以投资保障星的翼星计划产品标题
	public void clickTitleforInvestBZStar(){
		String Title = base.getElementTextWithWait(EStarTitleforInvestBZStar);
		int window = base.Windowsize();
		base.clickElementNoWait(EStarTitleforInvestBZStar);	
		if(base.Windowsize()==window){
			base.clickElementNoWait(EStarTitleforInvestBZStar);
		}
		base.jumpToNewWindow();
		base.checkElement(EStarDetailPage.DetailPart);
		base.assertEqualsActualExpected(base.getElementTextWithWait(EStarDetailPage.EStarTitleinDetail), Title);
	}
	//保障星数据（募集金额、利率、借款期限、清算方式显示）
	public ArrayList<String> BZStarInfo(){
		ArrayList<String> list = new ArrayList<String>();
		List<WebElement> info = base.getElements(BZStarInfo);
		for(int i=0;i<4;i++){
			list.add(info.get(i+1).getText());
		}
		return list;
	}
	
	//收益星数据（募集金额、利率、借款期限、清算方式显示）
	public ArrayList<String> SYStarInfo(){
		ArrayList<String> list = new ArrayList<String>();
		List<WebElement> info = base.getElements(SYStarInfo);
		for(int i=0;i<4;i++){
			list.add(info.get(i+1).getText());
		}
		return list;
	}
	
	//是否显示“快速投资”链接
	public Boolean ifshowInvestNowLnk(){
		return base.isElementPresent(EStarPlanListPage.InvestNowLnk);
	}
	/**
	 * 点击“快速投资”链接
	 * @author 刘京
	 */
	public void clickFastInvestLnk(){
		if(base.getLnkElementText(LoginPage.RegisterLnk, "class").contains("hide")){
			base.clickElementNoWait(InvestNowLnk);
			base.checkElementVisible(LoginPage.LoginBox);
		}else{
			base.clickElementNoWait(InvestNowLnk);
		}		
	}
	public void clickCloseLoginLnk(){
		
		if(base.isElementPresentNoWait(LoginPage.Iframe)){
			base.switchToFrame("loginBoxFrame");
		}
		base.clickWithWait(CloseLoginLnk);
		base.fromFrameToDefaultContent();
		base.checkElementVisible(StarImg);
	}
	//是否显示保障星“快速投资”链接
	public Boolean ifshowBZStarInvestNowLnk(){
		return base.isElementPresent(EStarPlanListPage.BZStarInvestNowLnk);
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
	//输入保障星投资金额
	public void InputInvestAmount(){
		base.sendKeysWithWait(InputAmount, "1");
	}
	//比较保障星投资额和需要额度的大小
	public boolean BZStarCompareAmount(){
//		String calculateTxt = base.getElementText(BZStarCalculateTxt);
//		int EndPosition = calculateTxt.lastIndexOf("=");
//		int EachAmount = Integer.valueOf(calculateTxt.substring(1, EndPosition)).intValue();
//		int TotalAmount = Integer.valueOf(base.getElementText(BZStarNeedAmountTxt)).intValue();
		Double Balance = Double.parseDouble(base.getElementText(BZStarBalanceTxt));
//		if(EachAmount<=TotalAmount)
		if(Balance>=100.0){
			return true;
		}else{
			return false;
		}	
	}
	//输入保障星投资支付密码
	public void InputPayPwd(String pwd){
		base.elementSendkey(InputPayPwd, pwd);
	}
	//输入保障星投资验证码
	public void InputValidateCode(){
		String ValidateCode = new Data().get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
		base.elementSendkey(InputValidateCode, ValidateCode);
		if(base.browserType.toLowerCase().equals("ie") && !base.indexURL.contains("inclient")){
			base.getAlertwithWait().accept();
		}
	}
	//选中保障星投资阅读并同意协议
	public void CheckAgreeDeal(){
		base.clickElementNoWait(AgreeCheckbox);
		base.assertTrueByBoolean(base.getElementNoWait(AgreeCheckbox).isSelected());
	}
	//点击保障星投资“确定”按钮
	public void clickBZStarOkBtn(){
		base.clickElementNoWait(OkBtn);
//		base.sleep(10000);
//		base.checkElmentwithTxt(InvestSuccessTxt, "投资成功");
	}
	//关闭“投资成功”窗口
	public void clickCloseSuccessLnk(){	
		
		base.clickElementNoWait(CloseInvestSuccessLnk);
		base.checkNoElement(CloseInvestSuccessLnk);
	}
	public void clickCloseErrorLnk(){
		base.clickElementNoWait(CloseInvestErrorLnk);
		base.checkNoElement(CloseInvestErrorLnk);
	}
	public void CheckInvestSuccess(){
		if(base.isElementVisible(InvestSuccessTxt)){
			base.assertEqualsActualExpected(base.getElementText(InvestSuccessTxt), "投资成功");
			int window = base.Windowsize();
			clickCloseSuccessLnk();
			if(base.Windowsize()!=window){
				base.turnToOldPage();
			}
		}else{
			base.assertEqualsActualExpected(base.getElementText(InvestErrorTxt),"输入错误");
			String ErrorTxt = base.getElementText(ShowErrorTxt);
			clickCloseErrorLnk();
			Assert.fail("输入错误! "+ErrorTxt);
		}
	}
	//点击“到个人中心查看”
	public void clickViewLnk(){
		base.clickWithWait(IndividualViewLnk);
		base.checkElmentText(MonthPlanTxt, "本月应收的计划");
	}
	//是否显示收益星“快速投资”链接
	public Boolean ifshowSYStarInvestNowLnk(){
		return base.isElementPresent(EStarPlanListPage.SYStarInvestNowLnk);
	}
	//点击收益星“快速投资”链接
	public void clickSYStarInvestNowLnk(){
		base.clickElementNoWait(SYStarInvestNowLnk);
	}
	
	/**
	 * 徐天元
	 * 提示充值
	 */
	public void promptRecharge(){
		base.checkElementVisible(By.cssSelector("#wtplan_alert7"));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#wtplan_alert7 .msg_ico.error_ico")), "亲 请先去充值,再投资!");
	}
	
	/**
	 * 徐天元
	 * 点击充值
	 */
	public void goRecharge(){
		base.clickWithWait(By.cssSelector("#wtplan_alert7 .return_btn"));
	}
	
	//是否是首次投资
	public Boolean ifFirstInvest(){
		if(base.getElementText(EStarPlanListPage.SYStarRiskTitle).equals("")){
			return false;
		}else{
			return true;
		}
	}
	//点击收益星“拒绝”风险提示按钮
	public void clickDenyBtn(){
		base.clickWithWait(DenyBtn);
		base.checkNoElement(DenyBtn);
		base.checkElementVisible(IncomeCalculatorLnk);
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
	//输入收益星投资金额
	public void InputSYStarAmount(){
		base.sendKeysWithWait(InputSYStarAmount, "1");
	}
	//比较收益星投资额和需要额度的大小
	public boolean SYStarCompareAmount(){
		String calculateTxt = base.getElementText(SYStarCalculateTxt);	
		int EndPosition = calculateTxt.lastIndexOf("=");
		int EachAmount = Integer.valueOf(calculateTxt.substring(1, EndPosition)).intValue();
		int TotalAmount = Integer.valueOf(base.getElementText(SYStarNeedAmountTxt)).intValue();
		if(3*EachAmount<=TotalAmount){
			return true;
		}else{
			return false;
		}	
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
		base.sleep(10000);
		base.checkElmentText(InvestSuccessTxt, "投资成功");
	}
	//点击收益星投资窗口“取消”按钮
	public void clickSYStarCancelBtn(){
		base.clickElementNoWait(SYStarCancelBtn);
		base.checkNoElement(SYStarCancelBtn);
//		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	
	/********************收益计算器*********************/
	/**
	 * 徐天元
	 * 点击收益计算器的计息时间
	 */
	public void clickDate(){
		base.clickWithWait(By.cssSelector("#date"));
	}
	
	/**
	 * 徐天元
	 * 输入收益计算器的计息时间
	 */
	public void inputDate(String date){
		base.setDate("date", date);
	}
	
	/**
	 * 徐天元
	 * 校验弹出日历框
	 */
	public void showDate(){
		base.assertTrueByBoolean(base.isBlock(By.cssSelector("#ui-datepicker-div")));
	}
	
	/**
	 * 徐天元
	 * 输入金额
	 */
	public void inputMoney(String value){
		base.sendKeysWithWait(By.cssSelector("#loanMoney"), value);
	}
	
	/**
	 * 徐天元
	 * 输入利率
	 */
	public void inputLoanRate(String value){
		base.sendKeysWithWait(By.cssSelector("#loanRate"), value);
	}
	
	/**
	 * 徐天元
	 * 输入投资期限
	 */
	public void inputLoanPhases(String value){
		base.sendKeysWithWait(By.cssSelector("#loanPhases"), value);
	}
	
	/**
	 * 徐天元
	 * 点击马上计算
	 */
	public void clickCalculate(){
		base.clickWithWait(By.cssSelector(".count-btn.fl"));
	}
	
	/**
	 * 校验正常输入计算器内容，无提示，显示计算结果
	 */
	public void isCalculateNoAlert(){
		base.assertNotEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#totalCont")), "0");
		base.assertNotEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#rateCont")), "0");
	}
	
	/**
	 * 校验计算结果正确
	 */
	public void isCalculateOK(double money,double rate,int phases){
		//收款总额  收款总额=借款金额*年利率/12*借款期限+借款本金
		String totalMoney = base.integerMoney(base.roundingMoney(money * rate / 1200 * phases + money));
		//利息  利息=借款金额*年利率/12*借款期限
		String lxMoney = base.integerMoney(base.roundingMoney(money * rate / 1200 * phases));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#totalCont")), totalMoney);
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#rateCont")), lxMoney);
	}
	
	/**
	 * 徐天元
	 * 点击显示收款时间表
	 */
	public void clickDateList(){
		base.clickWithWait(By.cssSelector("#intercheck"));
	}
	
	/**
	 * 徐天元
	 * 校验显示收款时间表
	 */
	public void isShowDateList(){
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#tiemst")));
		String ecpected[] = {"期次","收款时间","月收取利息","月收取本金","月收取总额","剩余本金"}; 
		List<WebElement> list = base.getElements(By.xpath(".//*[@id='tableList']/tbody[1]/tr/th"));
		for (int i = 0; i < list.size(); i++) {
			base.assertEqualsActualExpected(list.get(i).getText(), ecpected[i]);
		}
	}
	
	/**
	 * 徐天元
	 * 校验收款时间表数据正常
	 */
	public void isDateListOK(String date,double money,double rate,int phases){
		String dateSplit[] = date.split("-");
		int year = Integer.parseInt(dateSplit[0]);
		int month = Integer.parseInt(dateSplit[1])-1;
		int day = Integer.parseInt(dateSplit[2]);
		int daysOfYear = base.getDaysOfYear(year);
		//页面显示收款时间表
		List<WebElement> dateList = base.getElements(By.xpath(".//*[@id='datatbody']/tr"));
		//其次
		int qici = 0;
		if (Integer.parseInt(date.substring(date.length()-2, date.length()))==21) {
			//计息日为：21号，期次数与投资期限数一致
			qici = phases;
		}else {
			//计息日为其他，期次数=投资期限+1
			qici = phases + 1;
		}
		if(dateList.size()==qici){
			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month, day);
			SimpleDateFormat ddFormat = new SimpleDateFormat("yyyy-MM-dd");
			String firstLL = "";//第一次利息	
			for (int i = 1; i <= qici; i++) {
				int step = 0;
				/********************期次************************/
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[1]")), i+"");
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("第"+i+"行期次:校验失败,期盼："+i+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[1]"))+"<br/>");
					System.out.println("第"+i+"行期次:校验失败,期盼："+i+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[1]")));
				}
				/********************收款时间************************/
				String nextDate = "";
				if (i==1) {
					if(day>20){
						calendar.add(Calendar.MONTH, 1);
					}
					calendar.set(Calendar.DATE, 20);
					nextDate = ddFormat.format(calendar.getTime());
				}else if (i==qici) {//最后一次
					if(day<=21){
						calendar.add(Calendar.MONTH, 1);
					}
					calendar.set(Calendar.DATE, day-1);
					nextDate = ddFormat.format(calendar.getTime());
				}else {
					calendar.add(Calendar.MONTH, 1);
					calendar.set(Calendar.DATE, 20);
					nextDate = ddFormat.format(calendar.getTime());
				}
				nextDate = ddFormat.format(calendar.getTime());
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[2]")), nextDate);
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("第"+i+"行收款时间:校验失败,期盼："+nextDate+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[2]"))+"<br/>");
					System.out.println("第"+i+"行收款时间:校验失败,期盼："+nextDate+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[2]")));
				}
				/********************月收取利息************************/
				//月收取利息
				String monthLL = "";
				if(day!=21){
					if (i==1) {
						//相差天数
						int differ = base.daysBetween(date, nextDate)+1;
						//第一个月利息=借款金额*利率/365或366*计息日到下个还款日之间的天数
						firstLL = base.roundingMoney(money * rate / daysOfYear / 100 * differ);
						monthLL = firstLL;
					}else if(i==qici){
						monthLL = base.roundingMoney(Double.parseDouble(base.roundingMoney(money * rate /100 / 12)) - Double.parseDouble(firstLL));
					}else {
						//中间月利息=借款金额*利率/12
						monthLL = base.roundingMoney(money * rate /100 / 12);
					}
				}else {
					monthLL = base.roundingMoney(money * rate /100 / 12);
				}
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[3]")).replaceAll(",", ""), base.integerMoney(monthLL));
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("第"+i+"行月收取利息:校验失败,期盼："+base.integerMoney(monthLL)+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[3]")).replaceAll(",", "")+"<br/>");
					System.out.println("第"+i+"行月收取利息:校验失败,期盼："+base.integerMoney(monthLL)+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[3]")).replaceAll(",", ""));
				}
				/********************月收取本金************************/
				String benJin = "";
				if (i==qici) {
					benJin = money+"";
				}else {
					benJin = "0";
				}
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[4]")).replaceAll(",", ""), base.integerMoney(benJin));
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("第"+i+"行月收取本金:校验失败,期盼："+base.integerMoney(benJin)+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[4]")).replaceAll(",", "")+"<br/>");
					System.out.println("第"+i+"行月收取本金:校验失败,期盼："+base.integerMoney(benJin)+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[4]")).replaceAll(",", ""));
				}
				/********************月收取总额************************/
				//月收取总额
				String zongE = "";
				if (i==qici) {
					zongE = Double.parseDouble(monthLL)+money+"";
				}else {
					zongE = monthLL;
				}
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[5]")).replaceAll(",", ""), base.integerMoney(zongE));
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("第"+i+"行月收取总额:校验失败,期盼："+base.integerMoney(zongE)+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[5]")).replaceAll(",", "")+"<br/>");
					System.out.println("第"+i+"行月收取总额:校验失败,期盼："+base.integerMoney(zongE)+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[5]")).replaceAll(",", ""));
				}
				/********************剩余本金************************/
				//剩余本金
				String sybj = money + "";
				if (qici == phases + 1 && i==qici) {
					sybj = "0";
				}
				try {
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[6]")).replaceAll(",", ""), base.integerMoney(sybj));
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("第"+i+"行剩余本金:校验失败,期盼："+base.integerMoney(sybj)+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[6]")).replaceAll(",", "")+"<br/>");
					System.out.println("第"+i+"行剩余本金:校验失败,期盼："+base.integerMoney(sybj)+",实际："+base.getElementTextWithWait(By.xpath(".//*[@id='datatbody']/tr["+i+"]/td[6]")).replaceAll(",", ""));
				}
				if (step!=6) {
					base.assertTrueByBoolean(false);
				}
			}
		}else {
			Reporter.log("期次校验：失败"+"<br/>");
			base.assertEqualsActualExpectedByInt(dateList.size(), qici);
		}
	}
	
	/**
	 * 徐天元
	 * 前台-翼星计划--投资列表--翼型计划投资列表页--产品详情--产品总详情
	 * 状态图准确性、计划总额=保障星+收益星+责任星募集总额、产品标题及链接正确性、剩余期限正确性
	 */
	public void isDataOfEStarListOK(){
		//已售罄
		checkData("complute");
		//已结束
		checkData("end");
		//进行中
		checkData("going");
	}
	
	public void checkData(String type){
		List<WebElement> list = base.getElements(By.cssSelector(".wtplan_box_left."+type));
		if (list.size()>0) {
			for (int i = 1; i <= list.size(); i++) {
				int step = 0;
				List<WebElement> btnList = null;
				/************校验时间**************/
				try {
					if (type.equals("complute") || type.equals("end")) {
						base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//span[@class='wtplan_time font20 colorff fr']")),"0天00时00分00秒");
					}else {
						base.assertTrueByBoolean(!base.getElementTextWithWait(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//span[@class='wtplan_time font20 colorff fr']")).equals("0天00时00分00秒"));
					}
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("第"+i+"个"+type+"校验时间：失败"+"<br/>");
					System.out.println("第"+i+"个"+type+"校验时间：失败");
				}
				
				/************校验收益星、保障星投资按钮显示**************/
				String style = "";
				String msg = "";
				if (type.equals("complute")) {
					style = "over";
					msg = "已满";
				}else if (type.equals("end")) {
					style = "over";
					msg = "快速投资";
				}else {
					style = "go";
					msg = "快速投资";
				}
				btnList = base.getElements(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//span[@class='wtplan_td6 wtplan_line_btn "+style+"']"));
				try {
					for (int j = 0; j < btnList.size(); j++) {
						if (type.equals("end")) {
							try {
								base.assertEqualsActualExpected(btnList.get(j).getText(), msg);
							} catch (AssertionError e) {
								base.assertEqualsActualExpected(btnList.get(j).getText(), "已满");
							}
						}else {
							base.assertEqualsActualExpected(btnList.get(j).getText(), msg);
						}
					}
					try {
						base.assertEqualsActualExpectedByDouble(btnList.size(), 2);
					} catch (AssertionError e) {
						base.assertEqualsActualExpectedByDouble(btnList.size(), 1);
					}
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("第"+i+"个"+type+"校验收益星、保障星投资按钮显示：失败"+"<br/>");
					System.out.println("第"+i+"个"+type+"校验收益星、保障星投资按钮显示：失败");
				}
				
				/************校验计划总额=保障星+收益星+责任星募集总额**************/
				double zongE = 0;
				if (type.equals("complute") || type.equals("end")) {
					zongE = Double.parseDouble(base.getElementTextWithWait(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//span[@class='font30 colorF0']")).replaceAll(",", ""));
				}else {
					zongE = Double.parseDouble(base.getElementTextWithWait(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//span[@class='font30']")).replaceAll(",", ""));
				}
				
				//三星
				List<WebElement> stars3List = base.getElements(By.xpath("//div[a[@class='wtplan_box_left "+type+"']][position()="+i+"]//div[@class='color3 font18 wtplan_table_td2 fl']"));
				double sum = 0;
				for (int j = 0; j < stars3List.size(); j++) {
					sum = base.add(sum, Double.parseDouble(stars3List.get(j).getText().replaceAll("万元", "").replaceAll(",", "")));
				}
				try {
					base.assertEqualsActualExpectedByDouble(zongE, sum);
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("第"+i+"个"+type+"校验计划总额=保障星+收益星+责任星募集总额：失败"+"<br/>");
					System.out.println("第"+i+"个"+type+"校验计划总额=保障星+收益星+责任星募集总额：失败");
				}
				if (step!=3) {
					base.assertTrueByBoolean(false);
				}
			}
		}else {
			String msg = "";
			if (type.equals("complute")) {
				msg = "已售罄";
			}else if (type.equals("end")) {
				msg = "已结束";
			}else {
				msg = "进行中";
			}
			Reporter.log("首页没有"+msg+"的翼星计划"+"<br/>");
			System.out.println("首页没有"+msg+"的翼星计划");
		}
	}
	
	/**
	 * 徐天元
	 * 点击“产品标题”链接,跳转到投资列表详情页面,检查：产品相关信息与投资列表保持一致（状态，进度，投资按钮，计划总额等）
	 */
	public void isLinkAndDetailDataOK(){
		base.checkElement(FirstEStarTitle);
		//标题
		String title = base.getElementText(FirstEStarTitle);
		//状态
		String status = base.getElementWithWait(By.xpath("//div[@class='wtplan_box mt25'][1]/a")).getAttribute("class");
		//总额
		String zongE = base.getElementTextWithWait(By.xpath("//div[@class='wtplan_box mt25'][1]/a//span"));
		base.clickElementNoWait(FirstEStarTitle);	
		if (base.gethandelsNum()==2) {
			base.turnToNewPage();
		}
		//标题
		base.assertEqualsActualExpected(base.getElementTextWithWait(EStarDetailPage.EStarTitleinDetail), title);
		//状态
		base.assertEqualsActualExpected(base.getElementWithWait(By.xpath("//div[@class='wtplan_box_detail mt25']/div[1]")).getAttribute("class"), status);
		//总额
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@class='wtplan_box_detail mt25']//p[3]/span")), zongE);
	}
	
	/**
	 * 徐天元
	 * 校验保障星数据(验证清算方式显示正确性,还本付息)
	 */
	public void idBaoZhangStarDataOK(){
		List<WebElement> list = base.getElements(By.xpath("//div[@class='wtplan_box_right']/div[2]//div[5]"));
		for (int i = 0; i < list.size(); i++) {
			base.assertEqualsActualExpected(list.get(i).getText(), "先息后本");
		}
	}
}
