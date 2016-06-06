package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
/**
 * 新手专区
 * @author 徐天元
 */
public class DebentureTransferPage {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	String currentHandel = "";
	String backHandel = "";
	public String PageUrl = base.indexURL+"/new/loadNewUserTender.action";
	
	/***************新手专区*************/
	//投资列表
	By investList = By.xpath("//div[@class='lendtable']//dt");
	//信用评价图片链接
	By creditEvaluationList = By.cssSelector(".user_img.fl.wd100>a>img");
	//借款详情文字链接
	By creditInfoList = By.cssSelector(".fl>h2");
	//含有“快速投资”的借款详情文字链接
	By haveFaseInvestcreditInfoLinks = By.xpath("//a[@class='fast_money mt8']/parent::dd/preceding-sibling::dd//a");
	//快速投资
	By fastInvestBtn = By.cssSelector(".fast_money.mt8");////a[text()='快速投资']
	By RechargeWindow = By.id("noPerson");
	By TipDetailTxt = By.cssSelector("div.lyct>p.textC");//弹出充值提示的内容
	By GoRechargeBtn = By.cssSelector("input[type='submit']");//"去充值!"按钮
	By InvestWindow = By.id("fastLender_1");//投资窗口
	By CloseRechargeTipLnk = By.cssSelector("a.lyclose");									//关闭充值提示

	
	By moneyTxt = By.id("amount");											//输入金额
	By payPassowrdTxt = By.id("paypassowrd");								//支付密码
	By randCodeTxt = By.id("tenderRecordRandCode");							//验证码
	By randCodeImg = By.cssSelector("#checkverificationCode_fast>a>img");	//验证码图片
	By sureBtn = By.cssSelector(".f_m_Confirm.ml20");						//确定
	
	/*************借款详情**************/
	
	By creditEvaluationImg = By.cssSelector(".ld_user.fl>a>img");			//头像
	By planInfoLink = By.cssSelector(".clear.wd270>a");						//详情
	By lookpLanInfoTxt = By.cssSelector(".fl.font22");						//查看还款计划
	By closeLookpLanInfoBtn = By.cssSelector(".close");						//关闭还款计划
	By registerLink = By.xpath(".//*[@id='record4']//a[text()='注册']");		//注册
	By loginLink = By.xpath(".//*[@id='record4']//a[text()='登录']");			//登录
	By ownerLink = By.cssSelector(".ld_user.fl>p>a");//.font14.ml35>a		//owner
	
	/**
	 * 徐天元
	 * 判断新手专区数据是否正常，每页最多显示10条
	 */
	public void isInvestDataSizeOK(){
		//信用评价
		List<WebElement> invest_List =  base.getElements(investList);
		base.assertTrueByBoolean(invest_List.size()<=10);
	}
	
	/**
	 * 徐天元
	 * 校验投资列表各链接是否正确
	 */
	public void isInvestDataLinkOK(){
		//点击图片进入信用评价界面
		List<WebElement> creditEvaluation_list =  base.getElements(creditEvaluationList);
		verifyDataList(creditEvaluation_list,"信用评价");
		//点击链接进入借款详情界面
		List<WebElement> creditInfo_list =  base.getElements(creditInfoList);
		verifyDataList(creditInfo_list,"借款详情");
	}
	
	/**
	 * 校验List链接进入新页面是否正确
	 * @param list
	 * @param title
	 */
	public void verifyDataList(List<WebElement> list,String title){
		//List<WebElement> titles = new ArrayList<WebElement>();
		for(int i = 0; i < 1; i++){
			if (title.equals("借款详情")) {
				title = list.get(i).getText().length()>10 ? list.get(i).getText().substring(0,10) : list.get(i).getText();
				System.out.println(title);
			}
			currentHandel = base.getCurrentWindowHandle();
			list.get(i).click();
			//base.sleep(2000);
			String newHandel = base.getChildWindowHandle(currentHandel);
			base.jumpToWindow(newHandel);
			base.sleep(2000);
//			verifyMethod.verifyEquals(true, base.checkTitleContains(title));
			Assert.assertTrue(base.checkTitleContains(title));
			//base.sleep(2000);
			base.closeWindow(newHandel);
			base.jumpToWindow(currentHandel);
		}
	}
	
	/**
	 * 徐天元
	 * 是否有“快速投资”按钮
	 */
	public boolean ifHaveFastInvestBtn(){
		return base.isDisplayed(fastInvestBtn);
	}
	
	public void clickFastInvestBtn(){
		List<WebElement> fastInvestBtnList =  base.getElements(fastInvestBtn);
		if(fastInvestBtnList.size()>0){
			fastInvestBtnList.get(0).click();
			base.checkElementVisible(LoginPage.RegisterLnk);
			if(base.getLnkElementText(LoginPage.RegisterLnk, "class").contains("hide")){//未登录
				base.checkElementVisible(LoginPage.LoginBox);
			}else{
				if(base.isBlock(RechargeWindow)){
					base.checkElementVisible(TipDetailTxt);
					base.assertEqualsActualExpected(base.getElementTextWithWait(TipDetailTxt), "亲 请先去充值,再投资!");
					base.assertEqualsActualExpected(base.getLnkElementText(GoRechargeBtn,"value"), "去充值!");										
				}else{
					base.checkElementVisible(InvestWindow);
				}
			}		
		}else{
			System.out.println("新手专区没有可投资的借款标！");
		}
	}
	public void clickCloseRechargeBtn(){
		base.clickWithWait(CloseRechargeTipLnk);
		base.checkNoElement(CloseRechargeTipLnk);
	}

	
	/**
	 * 未登录，点击“快速投资”
	 */
	public void clickFastInvest(){
		base.clickWithWait(fastInvestBtn);
	}
	
	/**
	 * 徐天元
	 * 是否提示登录
	 */
	public void isLogin(){
		base.assertTrueByBoolean(base.isBlock(By.cssSelector(".login")));
		base.assertNotNullBy(By.cssSelector(".fl.font20"));
	}
	
	/**
	 * 徐天元
	 * 关闭登录窗口
	 */
	public void closeLogin(){
		base.clickWithWait(By.cssSelector(".login .close"));
	}
	
	/**
	 * 徐天元
	 * 校验详情页链接
	 */
	public void verifyDetailsInfoLinks(){
		base.getElements(creditInfoList).get(0).click();
		String detailsHandel = base.getChildWindowHandle(currentHandel);//借款详情页
		base.jumpToWindow(detailsHandel);
		//点击借款详情页图片，跳转至信用评价页
		isTurnToCreditEvaluationPage(creditEvaluationImg,currentHandel,detailsHandel);
		//查看还款计划
		base.clickWithWait(planInfoLink);
//		verifyMethod.verifyEquals(base.getElementText(lookpLanInfoTxt), "查看还款计划");
		Assert.assertEquals(base.getElementText(lookpLanInfoTxt), "查看还款计划");
		base.clickWithWait(closeLookpLanInfoBtn);
		//owner
		isTurnToCreditEvaluationPage(ownerLink,currentHandel,detailsHandel);
		base.closeWindow(detailsHandel);
		base.jumpToWindow(currentHandel);
	}
	
	public void isTurnToCreditEvaluationPage(By by,String handel1,String handel2){
		base.clickWithWait(by);
		String creditEvaluationHandel = base.getLastWindowHandle(handel1,handel2);//信用评价
		base.jumpToWindow(creditEvaluationHandel);
//		verifyMethod.verifyEquals(true, base.checkTitleContains(PageTitles.xinYongPingJiaYe));//"信用评价"
		Assert.assertTrue(base.checkTitleContains(PageTitles.xinYongPingJiaYe));
		base.closeWindow(creditEvaluationHandel);
		base.jumpToWindow(handel2);
		base.sleep(2000);
	}
	
	/**
	 * 徐天元
	 * 快速投标
	 */
	public void fastInvest(String money,String payPass){
		base.sendKeysWithWait(moneyTxt, money);
		base.sendKeysWithWait(payPassowrdTxt, payPass);
		String code = new Data().get(base.getElementWithWait(randCodeImg), base.getWebDriver());
		base.sendKeysWithWait(randCodeTxt, code);
		base.clickWithWait(sureBtn);
	}
	
	/**
	 * 徐天元
	 * 是否投资成功
	 */
	public boolean isFastInvestOK(){
		boolean flag = false;
		boolean result = false;
		String msg = "";
		result = base.checkVisible(By.id("fastLender_2"));
		try {
			base.checkElementVisible(By.cssSelector("#tenderOK"),2);
			msg = base.getElementTextWithVisible(By.cssSelector("#tenderOK"));
			flag = true;
		} catch (Exception e) {
			base.checkElementVisible(By.cssSelector("#errorMsg"),2);
			msg = base.getElementTextWithVisible(By.cssSelector("#errorMsg"));
		}
		currentHandel = base.getCurrentWindowHandle();
		//返回投资列表
		base.clickWithWait(By.id("backButton"));
		//关闭
		backHandel= base.getCurrentWindowHandle();
		base.assertTrueByBoolean(result);
		if (msg.equals("投标成功  ")) {
			flag = true;
		}
		if (base.gethandelsNum()>=2) {
			base.closeWebDriver();
		}
		return flag;
	}
	
	/**
	 * 徐天元
	 * 详情页 “借钱给他”
	 */
	public boolean detailsFastInvest(String money,String payPass,String tel,String password){
		currentHandel = base.getCurrentWindowHandle();
		//含有“快速投资”的借款详情文字链接
		base.getElements(haveFaseInvestcreditInfoLinks).get(0).click();
		String detailsHandel = base.getChildWindowHandle(currentHandel);//借款详情页
		base.jumpToWindow(detailsHandel);
		//System.out.print(!loginPage.ifLogin());
		if (!loginPage.ifLogin()) {//解决ie不兼容  未同步登录状态  重新登录
			base.clickWithWait(By.cssSelector("#login_1 .colorFc"));
			loginPage.login(tel, password);
		}
		//点击“借钱给他”
		base.clickWithWait(By.cssSelector(".ld_btn.mt25.fl"));
		fastInvest(money,payPass);
		boolean result = isFastInvestOK();
		if (result) {
			base.closeWindow(detailsHandel);
		}
		return result;
	}
	
	/**
	 * 徐天元
	 * 快速投资个数（新手标个数）
	 */
	public int getDebentureTransferNum(){
		List<WebElement> list = base.getElements(By.cssSelector(".fast_money.mt8"));
		return list.size();
	}
	
	/**
	 * 徐天元
	 * 校验新手标个数是否正确  #newUserLink em
	 */
	public void isDebentureTransferNumOK(int num){
		if (num>0) {
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#newUserLink em")), "["+num+"]");
		}else {
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#newUserLink")), "新手专区[0]");
		}
	}
	
	/**
	 * 徐天元
	 * 创建新手标
	 */
	public void makeNewUserBid(){
		base.logout();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(Data.newUser, "111111");
		MyAccountPage myAccountPage = new MyAccountPage();
		LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
		myAccountPage.turnToMyAccount("申请借款");
		loanApplicationPage.loanApplication(true, false, "翼农贷", "1000", "12个月","","18", "7", "满标", "fx", "个人消费", "张杰借款1", "自动化：个管灌灌灌灌灌高规格灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌");
		new DBData().updateNewUserBid("张杰借款1");
	}
}
