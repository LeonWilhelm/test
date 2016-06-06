package com.eloancn.shared.pages;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.*;

/**
 * “投资列表”页面
 */
public class InvestmentListPage {
	
	Base base = new Base();
	Data data = new Data();
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	public String Url = base.indexURL + "/new/loadAllTender.action";
	
	/********************************/
	/*********      顶部             **********/
	/********************************/
	
	By homePageLink = By.xpath("//li[@class='global']/a");		//首页
	By logoutLink = By.linkText("退出");							//退出
	
	/********************************/
	/*********    条件筛选           **********/
	/********************************/
	
	By SearchOptionDesTxt = By.cssSelector("div.wrap.mt15.overflowV>div>div>dl>dt");	//还款方式,借款期限,借款利率,借款类型（.lend_search.h168.bgFF.bdD9.overflowV dt）
	
	/********************************/
	/******    条件筛选_借款类型          *******/
	/********************************/
	
	/********************************/
	/****  条件筛选_借款类型 _还款方式        *****/
	/********************************/
	
	public By SelectedMode = By.cssSelector("#repaymentDiv>dl>dd.bg86");		//选中的还款方式
	By RepayModeOptions = By.xpath("//div[@id='repaymentDiv']/dl/dd");			//还款方式（4个）
	
	/********************************/
	/****  条件筛选_借款类型 _借款期限        *****/
	/********************************/
	
	By SelectedPhase = By.cssSelector("#phasesDiv>dl>dd.bg86");					//选中的借款期限
	By PhaseOptions = By.xpath("//div[@id='phasesDiv']/dl/dd");					//借款期限（5个）
	
	/********************************/
	/****  条件筛选_借款类型 _借款利率        *****/
	/********************************/
	
	By SelectedRate = By.cssSelector("#interDiv>dl>dd.bg86");					//选中的借款利率
	
	/********************************/
	/****  条件筛选_借款类型 _借款类型        *****/
	/********************************/
	
	By SelectedType = By.cssSelector("#typeDiv>dl>dd.bg86");					//选中的借款类型
	By CarMortgageLnk = By.xpath("//div[@id='typeDiv']/dl/dd[3]");				//车辆抵押
	By CarOptionImg = By.xpath("//div[@id='typeDiv']/dl/dd[3]/img");			//车辆抵押右上方的消息气泡
	By SelectedCarLnk = By.cssSelector("dd.posiR.overflowV.bg86");				//选中的“车辆抵押”
	
	By HouseMortgageLnk = By.xpath("//div[@id='typeDiv']/dl/dd[4]");			//房屋抵押
	By HouseOptionImg = By.xpath("//div[@id='typeDiv']/dl/dd[4]/img");			//房屋抵押右上方的消息气泡
	By SelectedHouseLnk = By.cssSelector("dd.posiR.overflowV.bg86");			//选中的“房屋抵押”
	
	/********************************/
	/******    条件筛选_预约投标          *******/
	/********************************/
	
	By ReserveBidBtn = By.cssSelector("a.lend_tip_btn.lend_tip_btn1");			//预约投标暂不开放按钮
	By ReserveBidTxt = By.cssSelector("a.lend_tip_btn.lend_tip_btn1>span");		//预约投标暂不开放
	
	/********************************/
	/******    条件筛选_自动投标          *******/
	/********************************/
	
	By AutoBidBtn = By.cssSelector("span.lend_tip_bgimg");						//自动投标
	By AutoBidDescTxt = By.xpath("//div[5]/p[4]");								//没时间抢标，可设置自动投标

	/********************************/
	/*********    投资列表           **********/
	/********************************/
	
	public By ListContent = By.cssSelector("div.lendtable>dl");					//列表list
	public By InvestmentListTxt = By.cssSelector(".font24");					//投资列表文本
	
	/********************************/
	/*****    投资列表_收益计算器            ******/
	/********************************/
	
	By IncomeCalculatorLnk = By.cssSelector("a.lcjsq.fr");						//收益计算器链接
	By CloseCalculatorBtn = By.cssSelector("a.count-close.fr");					//关闭收益计算器
	By InputInvestMoney = By.id("loanMoney");									//输入“投资金额”
	By InputLoanRate = By.id("loanRate");										//输入“年利率”
	By InputloanPhases = By.id("loanPhases");									//输入“投资期限”
	By RepayMode = By.id("loanType");											//还款方式选择框
	By HBFXMode = By.xpath("//select[@id='loanType']/option");					//还本付息的还款方式
	By PlanTableCheckBox = By.id("intercheck");									//"显示计划时间表"复选框
	By CalculateNowBtn = By.cssSelector("a.count-btn.fl");						//“马上计算”
	By SKSJB = By.id("tiemst");													//收款时间表
	By SKSJBTxt = By.cssSelector("#tiemst > h3.ml25");							//"收款时间表"文本
	By subTitle = By.xpath("//table[@id='tableList']/tbody/tr/th");				//期次，收款时间，月收取利息，月收取本金 ，月收取总额，剩余本金
	By AmountAndInterestTxt = By.id("result0");									//描述：收款总额：    利息：
	By AmountTxt = By.id("totalCont");											//收款总额的金额
	By InterestTxt = By.id("rateCont");											//利息的金额
	
	/********************************/
	/*****     投资列表_所有地区             ******/
	/********************************/
	
	By allPlacesBtn = By.cssSelector(".select_place>b");						//所有地区
		
	/********************************/
	/*****     投资列表_借款信息             ******/
	/********************************/
	
	By userImgs = By.xpath("//dt[@class='user_img fl wd100']/a/img");				//用户图片
	By InvestmentDataTitle = By.xpath("//dd[@class='wd300 pdl10 fl']/div/a/h2");	//用户标题
	By InvestmentDataMoney = By.cssSelector(".colorCb.mt10");						//用户借款金额
	By InvestmentDataPeriods = By.cssSelector(".wd130.fl.pdl10 > p.mt10");			//用户借款期限	
	By InvestmentDataRate = By.cssSelector(".colorE6 > span");						//用户借款利率
	By InvestmentDataBtn = By.cssSelector(".fast_money_disable.mt8");				//用户借款按钮
	By investmentDataLevel = By.cssSelector("p.clear > span");						//用户借款级别
	
	
	By fastInvestBtn = By.xpath("//a[@class='fast_money mt8']");							//获取“快速投资”按钮
	By InvestTxt = By.id("fastLender_1");													//弹出的“投标金额”窗口
	By InvestAmountTitle = By.xpath("//div[@id='fastLender_1']/div[2]/h1/span");			//弹出“投标金额”窗口的标题
	By RechargeWindow = By.id("noPerson");
	By TipDetailTxt = By.xpath("//div[@id='noPerson']/table/tbody/tr/td/div/div[2]/p");		//弹出充值提示的内容
	By GoRechargeBtn = By.cssSelector("input[type='submit']");								//"去充值!"按钮
	By CloseRechargeTipLnk = By.cssSelector("a.lyclose");									//关闭充值提示		
	
	
	By requiredAmount = By.xpath("//span[@id='amount1']");						//还需额度
	By inputMoneyTxt = By.xpath("//input[@id='amount']");						//“输入金额”文本框
	By autoInputLink =  By.xpath("//a[text()='自动输入']");						//“自动输入”链接
	By payPasswordTxt = By.xpath("//input[@id='paypassowrd']");					//“支付密码”文本框
	By verificationCodeTxt = By.xpath("//input[@id='tenderRecordRandCode']");	//“验证码”文本框
	By bidBtn = By.cssSelector(".f_m_Confirm.ml20");							//“确认”按钮
	By BidFailTxt = By.id("errorMsg");
	By bidSuccessCloseBtn = By.cssSelector("#fastLender_2 .close");				//投资成功“关闭”按钮
	By backBtn = By.cssSelector("#backButton");									//获取“返回投资列表”按钮
	By borrowMoneyBtn = By.xpath("//input[@class='ld_btn mt25 fl']");			//“借钱给他”按钮
	
	/********************************/
	/*****   投资列表_借款信息_分页栏       *****/
	/********************************/
	
	By pagingBars = By.xpath("//div[@id='Pagination']/ul/li");						//获取分页栏
	
	/********************************/
	/****   投资列表_借款信息_详情页             ****/
	/********************************/
	
	By detailedTitle = By.cssSelector("h2.mt10");						//借款详情页面_用户标题
	By creditEvaluationImg = By.cssSelector(".ld_user.fl>a>img");		//借款详情页面_用户头像
	
	/********************************/
	/*** 投资列表_借款信息_详情页_还款计划      ***/
	/********************************/
	
	By planInfoLink = By.cssSelector(".clear.wd270>a");					//借款详情页面_还款计划_“详情”链接
	By lookpLanInfoTxt = By.cssSelector(".fl.font22");					//借款详情页面_还款计划_“查看还款计划”窗口_Title
	By closeLookpLanInfoBtn = By.cssSelector(".close");					//借款详情页面_还款计划_“查看还款计划”窗口_关闭按钮
	
	
	/********************************/
	/*** 投资列表_借款信息_详情页_材料信息      ***/
	/********************************/
	
	By registerLink = By.xpath(".//*[@id='record4']//a[text()='注册']");	//借款详情页面_点击“材料信息”_“注册”链接
	By loginLink = By.xpath(".//*[@id='record4']//a[text()='登录']");		//借款详情页面_点击“材料信息”_“登录”链接
	
	/********************************/
	/*** 投资列表_借款信息_详情页_咨询记录      ***/
	/********************************/
	
	By ownerLink = By.cssSelector(".font14.ml35>a");					//借款详情页面_咨询记录_借款人姓名
	
	
	By creditInfoList = By.cssSelector(".bao.fl~a");					//借款详情文字链接

	
	/**
	 * 投资列表页，点击“预约投标”按钮，并校验跳转是否正常
	 * @author 江渤洋 2016-2-5
	 */
	public void clickReserveBidBtn(){
		base.clickWithWait(ReserveBidBtn);
		base.isTitle(PageTitles.yuYueTouBiao);
		base.assertEqualsActualExpected(base.getElementTextWithVisible(By.cssSelector(".font24.fl")), "预约投标");
	}
	
	
	/**
	 * 点击首页
	 * @author 江渤洋 2015-6-8
	 */
	public void clickHomePage(){
		base.clickWithWait(homePageLink);
	}
	
	/**
	 * 点击退出
	 * @author 江渤洋 2015-6-8
	 */
	public void clickLogout(){
		base.clickWithWait(logoutLink);
	}
	//检查是否存在散标
	public boolean ifExistSB(){
		if(base.getElementTextWithWait(ListContent).equals("")){
			System.out.println("投资列表页没有数据！");
			Reporter.log("<br/>投资列表页没有数据！"+"<br/>");
			return false;
		}else{
			return true;
		}
	}
	//点击第一条散标
	public String clickFirstTitle(){
		base.clickWithWait(InvestmentDataTitle);
		base.turnToNewPage();
		base.checkElementVisible(InvestmentDetailPage.StatusBar);
		return base.getElementTextWithWait(InvestmentDetailPage.UserName);
	}
	
	/**
	 * 根据每条列表数据的唯一标示，点击用户标题
	 */
	public void clickInvestmentDataTitleById(String investmentId){
		base.clickWithWait(By.xpath("//a[contains(@href,'" + investmentId + "')]"));
	}
	
	/**
	 * “输入金额”文本框，输入值
	 * @param money(金额)
	 * @author 江渤洋 2015-5-25
	 */
	public void sendKeyInputMoneyTxt(String money){
		//base.sleep(5000);
		base.sendKeyAndWait(inputMoneyTxt, money);
	}
	
	/**
	 * “支付密码”文本框，输入值
	 * @param password(密码)
	 * @author 江渤洋 2015-5-25
	 */
	public void sendKeyPayPasswordTxt(String password){
		//base.sleep(5000);
		base.sendKeyAndWait(payPasswordTxt, password);
	}
	
	/**
	 * 徐天元
	 * 获取验证码
	 */
	public String getVerificationCode(){
		return data.get(indexPage.getVerificationCodeImg(), base.getWebDriver());
	}
	
	/**
	 * 徐天元
	 * 刷新验证码
	 */
	public void refreshVerificationCode(){
		base.clickWithWait(By.cssSelector("#checkverificationCode_fast>a>img"));
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
	}
	
	/**
	 * “验证码”文本框，输入值
	 * @param verificationCode(验证码)
	 * @author 江渤洋 2015-5-25
	 */
	public void sendKeyVerificationCodeTxt(String verificationCode){
		base.sendKeyAndWait(verificationCodeTxt, verificationCode);
	}
	
	/**
	 * 点击“确认”按钮
	 * @author 江渤洋 2015-5-25
	 */
	public void clickBidBtn(){
		base.clickWithWait(bidBtn);
	}
	
	/**
	 * 点击，投资成功“关闭”按钮
	 * @author 江渤洋 2015-5-26
	 */
	public void clickBidSuccessCloseBtn(){
		base.clickWithWait(bidSuccessCloseBtn);
		if (base.gethandelsNum()==2) {
			base.turnToOldPage();
		}
	}
	
	/**
	 * 点击“返回投资列表”按钮
	 * @author 江渤洋 2015-5-27
	 */
	public void clickBackBtn(){
		base.clickWithWait(backBtn);
	}
	
	/**
	 * 获取详细页面用户标题
	 * @return 详细页面用户标题
	 * @author 江渤洋 2015-5-22
	 */
	public String getdetailedTitle(){
		WebElement detailedTitleWebElement = base.getElementWithWait(detailedTitle);
		return detailedTitleWebElement.getText();
	}
	
	/**
	 * 获取分页栏
	 * @return 分页栏
	 * @author 江渤洋 2015-5-22
	 */
	public List<WebElement> getPagingBars(){
		base.checkElementVisible(pagingBars);
		List<WebElement> pagingBarsList =  base.getElements(pagingBars);
		return pagingBarsList;
	}
	
	/**
	 * “投资列表”获取所有用户图片
	 * @return 所有用户图片集合
	 * @author 江渤洋 2015-5-22
	 */
	public List<WebElement> getUserImg(){
		base.checkElementVisible(userImgs);
		List<WebElement> usrImgList = base.getElements(userImgs);
		return usrImgList;
	}
	
	/**
	 * “投资列表”获取所有用户标题集合
	 * @return 所有用户标题对象集合
	 * @author 江渤洋 2015-5-22
	 */
	public List<WebElement> getUserTitle(){
		base.checkElementVisible(InvestmentDataTitle);
		List<WebElement> userTitleList = base.getElements(InvestmentDataTitle);
		return userTitleList;
	}
	
	/**
	 * “散标列表” 获取所有用户的某个属性的集合
	 * @param name 属性名称
	 * @return 属性的对象集合
	 * @author 江渤洋 2016-2-2
	 */
	public List<WebElement> getSBInvestmentData(String name){
		By by;
		switch (name) {
		case "借款标题":	by = InvestmentDataTitle;	break;
		case "借款金额":	by = InvestmentDataMoney;	break;
		case "借款期限":	by = InvestmentDataPeriods;	break;
		case "借款利率": 	by = InvestmentDataRate;	break;
		case "借款按钮": 	by = InvestmentDataBtn;		break;
		case "借款级别":	by = investmentDataLevel; 	break;
		default:		by = InvestmentDataTitle;	break;
		}
		base.checkElementVisible(by);
		List<WebElement> userTitleList = base.getElements(by);
		return userTitleList;
	}
	
	/**
	 * “散标列表” 获取所有用户的某个属性的集合
	 * @param name 属性名称
	 * @return 属性的字符集合
	 * @author 江渤洋 2016-2-2
	 */
	public List<String> getSBInvestmentDataStr(String name){
		List<String> list = new ArrayList<String>();
		List<WebElement> webList = getSBInvestmentData(name);
		for(int i = 0; i < webList.size(); i++){
			list.add(webList.get(i).getText());
		}
		return list;
	}
	
	/**
	 * 截取“.”前的字符串
	 * @param titleStr(投资列表标题)
	 * @return 截取后字符串
	 * @author 江渤洋 2015-5-25
	 */
	public String interceptPoint(String titleStr){
		String interceptStr = titleStr;
		//判断“.”的位置
		int index = titleStr.indexOf(".");
		//如果包含“.”，则返回“.”之前的数
		if(index != -1){
			interceptStr = titleStr.substring(0, index);
		}
		return interceptStr;
	}
	
	/**
	 * 判断分页显示数据
	 * @author 江渤洋  2015-5-25
	 * 备注：目前只实现首页的检查，日后完善所有页的
	 */
	public void checkMaxDisplay(){
		//获取分页栏的长度
		int pagingBarsSize = getPagingBars().size();
		//判断是否有第二页。首页：1,上一页：2，第一页：3，下一页：4，尾页：5
		if(pagingBarsSize > 5)
		{
			//判断首页显示数据是否大于10
			base.assertTrueByBoolean(getUserImg().size()>10?false:true);
			//判断尾页显示数据是否大于10
			
			//判断每一页显示数据是否大于10
		}
		//如果没有第二页，则只校验第一页
		else{
			//判断第一页显示数据是否大于10
		}
	}
	
	/**
	 * 检查点击用户所有图片，跳转是否正确
	 * @author 江渤洋 2015-5-22
	 */
	public void checkUserImgJumpList(){
		//“投资列表”所有用户头像集合
		List<WebElement> userImgList = getUserImg();    //System.out.println("图片个数： " + userImgList.size());//---------测试
		//获得父窗口句柄
		String parentWindowHandle = base.getCurrentWindowHandle();
		//子窗口句柄
		String childWindowHandle = "";
		//for(int i = 0; i < userImgList.size(); i++){
		for(int i = 0; i < 1; i++){
			//点击“用户图片”
			userImgList.get(i).click();
			//获取子窗口句柄
			childWindowHandle = base.getChildWindowHandle(parentWindowHandle);
			//跳转到子窗口
			base.jumpToWindow(childWindowHandle);    //System.out.println("第 " + i + "个图片  Title: " + base.getPageTitle());//--------------测试
			//验证页面Title
			base.isTitle(PageTitles.xinYongPingJiaYe);
			//关闭子窗口
			base.closeWindow(childWindowHandle);
			//跳转到父窗口
			base.jumpToWindow(parentWindowHandle);
		}
	}
	
	/**
	 * 检查点击用户标题，跳转是否正确
	 * @author 江渤洋 2015-5-22
	 */
	public void checkUserTitleList(){
		String parentTitle = "";
		String childTitle = "";
		//“投资列表”所有用户标题集合
		List<WebElement> userTitleList = getUserTitle();
		//获得父窗口句柄
		String parentWindowHandle = base.getCurrentWindowHandle();
		//子窗口句柄
		String childWindowHandle = "";
//		for(int i = 0; i < userTitleList.size(); i++){
		for(int i = 0; i < 1; i++){	
			//获取用户标题
			parentTitle = interceptPoint(userTitleList.get(i).getText());    //System.out.println("用户标题: " + parentTitle);//----------测试
			//点击用户标题
			userTitleList.get(i).click();
			//获取子窗口
			childWindowHandle = base.getChildWindowHandle(parentWindowHandle);
			//跳转到子窗口
			base.jumpToWindow(childWindowHandle);    //System.out.println("第 " + i + "个标题 Title: " + base.getPageTitle());//--------------测试
			//获得用户详细页面标题
			childTitle = getdetailedTitle();    //System.out.println("获得用户详细页面标题: " + childTitle);//----------测试
			//如果字符长度大于11则截取到第11位
//			if(childTitle.length() > 11){
//				childTitle = childTitle.substring(0,12);
//			}                                  System.out.println("获得用户详细页面标题截取后: " + childTitle);//----------测试
			//验证页面Title
			base.checkTitleContains(parentTitle);
			//关闭子窗口
			base.closeWindow(childWindowHandle);
			//跳转到父窗口
			base.jumpToWindow(parentWindowHandle);
		}
	}
	
	/**
	 * 如果“快速投资”按钮存在，则点击，并校验登录DIV是否显示
	 * @author 江渤洋 2015-5-25
	 * @return 
	 */
	public boolean clickFastInvestBtn(){
		boolean ifExistInvestBtn = true;
		//获取页面所有的“快速投资”按钮
		List<WebElement> fastInvestBtnList =  base.getElements(fastInvestBtn);    //System.out.println("一共  " + fastInvestBtnList.size() + " 个“快速投资”按钮");//----------测试
		//如果“快速投资”按钮存在
		if(fastInvestBtnList.size()>0){
//			for(int i = 0; i < fastInvestBtnList.size(); i++){
			for(int i = 0; i < 1; i++){
				boolean isLogin = loginPage.ifLogin();//判断是否登录
				//点击“快速投资”按钮
				fastInvestBtnList.get(i).click();
				if(isLogin){
					if(base.isBlock(RechargeWindow)){//账户中没钱
						base.checkElementVisible(TipDetailTxt);
						base.assertEqualsActualExpected(base.getElementTextWithWait(TipDetailTxt), "亲 请先去充值,再投资!");
						base.assertEqualsActualExpected(base.getLnkElementText(GoRechargeBtn,"value"), "去充值!");										
					}else{
						base.checkElementVisible(InvestTxt);
						base.assertEqualsActualExpected(base.getElementTextWithWait(InvestAmountTitle), "投标金额");
					}
				}else{
					By by = By.xpath("//div[@class='login']");//登出
					//校验“登录”窗口是否弹出
					base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(by, "style", "block"), true);
					indexPage.checkLoginTitle();
				}
			}
		}
		else{
			Reporter.log("投资列表页面无“快速投资”按钮!");
			System.out.println("投资列表页面无“快速投资”按钮!");
			ifExistInvestBtn=false;
		}
		return ifExistInvestBtn;
	}
	
	public void clickCloseRechargeLnk(){
		base.clickWithWait(CloseRechargeTipLnk);
		base.checkNoElement(CloseRechargeTipLnk);
	}
	
	/**
	 * 实现投标
	 * @param money(投资金额), password(支付密码)
	 * @author 江渤洋 2015-5-26
	 */
	public void fastInvest(String money, String password){
		//验证码
		String verificationCode = "";
		//“输入金额”，输入值
		sendKeyInputMoneyTxt(money);
		//“支付密码”，输入值
		sendKeyPayPasswordTxt(password);
		//获取验证码
		verificationCode = data.get(indexPage.getVerificationCodeImg(), base.getWebDriver());
		//“验证码”，输入值
		sendKeyVerificationCodeTxt(verificationCode);
		//点击“确认”按钮
		clickBidBtn();
	}
	
	/**
	 * 校验“快速投资”按钮，进行投资
	 * @param money(投资金额), password(支付密码)
	 * @author 江渤洋 2015-5-25
	 */
	public void checkFastInvest(String money, String password){

		//获取页面所有的“快速投资”按钮
		List<WebElement> fastInvestBtnList = base.getElements(fastInvestBtn);
		//如果“快速投资”按钮存在
		if(fastInvestBtnList.size()>0){
//			for(int i = 0; i < fastInvestBtnList.size(); i++){
			String currentHandel = base.getCurrentWindowHandle();  System.out.println("父窗口:" + currentHandel);
			for(int i = 0; i < 1; i++){
				//点击“快速投资”按钮
				fastInvestBtnList.get(i).click();
				//实现投标
				fastInvest(money, password);
				base.sleep(25000);
				//校验“投资成功”对话框是否显示
				By by = By.xpath("//div[@id='fastLender_2']");
				base.assertTrueByBoolean(base.isElementContainsValue2(by,"style", "block"));
				//点击“关闭”按钮
				clickBidSuccessCloseBtn();
				//弹出空白窗口后关闭，并跳转主窗口
				//关闭多弹出的窗口
//				LinkedHashSet<String> windowHandles = (LinkedHashSet<String>) base.getCurrentWindowHandles();
//			    String handels[] = new String[windowHandles.size()];
//			    int j=0;
//			    for (String str : windowHandles) {  
//			        System.out.println(str);  
//			        handels[j] = str;
//			        j++;
//			     } 
				base.sleep(1000);
				//关闭父窗口以外的窗口
				base.closeOtherWindowHandle(currentHandel);
				
				base.sleep(1000);
			    base.jumpToWindow(currentHandel);
				
				//点击“返回列表”按钮，返回时页面加载异常
//				clickBackBtn();
			}
		}
		else{
			System.out.println("投资列表页面无“快速投资”按钮!");
		}
	}
	
	/**
	 * 校验详情页链接
	 * @author 江渤洋(借鉴徐天元)
	 */
	public void checkDetailsInfoLinks(){
		
		base.isTitle(PageTitles.touZiLieBiao);
		String currentHandel = base.getCurrentWindowHandle();//投资列表
		
		base.getVisibleElements(InvestmentDataTitle).get(0).click();
		String detailsHandel = base.getChildWindowHandle(currentHandel);//“借款详情”页面
		base.jumpToWindow(detailsHandel);
		base.checkTitleContains("翼龙贷");
		
		//点击借款详情页图片，跳转至信用评价页
		isTurnToCreditEvaluationPage(creditEvaluationImg,currentHandel,detailsHandel);
		
		//查看还款计划
		base.clickWithWait(planInfoLink);
		base.assertEqualsActualExpected(base.getElementTextWithWait(lookpLanInfoTxt), "查看还款计划");
		base.clickWithWait(closeLookpLanInfoBtn);
		
		//owner
		//非常容易报错的校验点，暂时删除。修改：江渤洋 2015-7-15
//		isTurnToCreditEvaluationPage(ownerLink,currentHandel,detailsHandel);
		base.closeWindow(detailsHandel);
		base.jumpToWindow(currentHandel);
	}
	
	public void isTurnToCreditEvaluationPage(By by,String handel1,String handel2){
		base.clickWithWait(by);
		String creditEvaluationHandel = base.getLastWindowHandle(handel1,handel2);//信用评价
		base.jumpToWindow(creditEvaluationHandel);
		base.isTitle(PageTitles.xinYongPingJiaYe);
		base.closeWindow(creditEvaluationHandel);
		base.jumpToWindow(handel2);
	}
	
	/**
	 * 校验“借钱给他”按钮，进行投资
	 * @param money(投资金额), password(支付密码)
	 * @author 江渤洋 2015-5-28
	 */
	public void checkBorrowMoney(String money, String password){
		//每条投资列表数据的唯一标示
		String investmentId = "";
		//获取父窗口句柄
		String parsentHandel = base.getCurrentWindowHandle();
		
		if(base.isElementVisible(fastInvestBtn)){
			//获取页面所有的“快速投资”按钮
			List<WebElement> fastInvestBtnList =  base.getElements(fastInvestBtn);
			//根据“快速投资”按钮，点击用户“标题”
			//如果“快速投资”按钮存在
//			for(int i = 0; i < fastInvestBtnList.size(); i++){
			for(int i = 0; i < 1; i++){
				//获取“快速投资”按钮的onclick属性
				investmentId = fastInvestBtnList.get(i).getAttribute("onclick");
				//截取onclick属性中“'”之间的值，例如：“onclick="lender.fastLend('87569')"”
				investmentId = investmentId.split("'")[1];    //System.out.println("标题ID： " + investmentId);//-------测试
				//点击用户“标题”
				clickInvestmentDataTitleById(investmentId);
				//获取子窗口句柄
				String childHandel = base.getChildWindowHandle(parsentHandel);    //System.out.println("子窗口句柄： " + childHandel);//-------测试
				
				base.sleep(2000);
				base.jumpToWindow(childHandel);
				//点击“借钱给他”按钮
				base.clickWithWait(By.cssSelector(".ld_btn.mt25.fl"));
				//实现投标
				fastInvest(money, password);
				base.sleep(25000);
				//校验“投资成功”对话框是否显示
				base.assertTrueByBoolean(base.isElementContainsValue2(By.xpath("//div[@id='fastLender_2']"),"style", "block"));
				//点击“关闭”按钮
				clickBidSuccessCloseBtn();
				//关闭父窗口以外的窗口
				base.closeOtherWindowHandle(parsentHandel);
				
				base.sleep(2000);
			    base.jumpToWindow(parsentHandel);
			}
		}
		else{
				System.out.println("投资列表页面无“快速投资”按钮!");
			}
	}
	
	/**
	 * 徐天元
	 * 点击借钱给他
	 */
	public void clickBorrow(){
		base.clickWithWait(By.cssSelector(".ld_btn.mt25.fl"));
	}
	/**
	 * 徐天元
	 * 翻页
	 */
	public void clickPage(String page){
		By css = null;
		if (page.equals("末页")) {
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='末页']");
		}else if (page.equals("首页")) {
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='首页']");
		}else if (page.equals("前一页")) {
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='<']");
		}else if (page.equals("后一页")) {
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='>']");
		}else {
			css = By.xpath(".//*[@id='Pagination']//li[text()='"+page+"']");//第五页
		}
		base.clickWithWait(css);
	}
	
	/**
	 * 徐天元
	 * 翻页按钮是否显示
	 */
	public boolean ifShowPageBtn(String page){
		boolean result = false;
		By css= null;
		if (page.equals("末页")) {
			//css = By.cssSelector(".pages>li:nth-last-of-type(1)");
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='末页']");
		}else if (page.equals("首页")) {
			//css = By.cssSelector(".pages>li:nth-of-type(1)");
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='首页']");
		}else if (page.equals("前一页")) {
			//css = By.cssSelector(".pages>li:nth-of-type(2)");
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='<']");
		}else if (page.equals("后一页")) {
			//css = By.cssSelector(".pages>li:nth-last-of-type(2)");
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='>']");
		}else {
			//css = By.xpath(".//*[@id='Pagination']//li[text()='"+page+"']");//第五页
			css = By.xpath("//*[@id='Pagination']/ul/li[text()='"+page+"']");
		}
		if(page.equals("5")){
			if(base.isElementPresent(css)){
				result = true;
			}
		}else {
			if (!base.getElementWithWait(css).getAttribute("class").contains("pgEmpty")) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * 徐天元
	 * 验证点击分页跳转是否正确
	 */
	public void isTurnPageOK(String page){
		if (page.equals("末页")) {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='末页']")).getAttribute("class").contains("pgEmpty"));
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='>']")).getAttribute("class").contains("pgEmpty"));
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[last()-2]")).getAttribute("class").contains("pgCurrent"));
		}else if (page.equals("首页")) {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='首页']")).getAttribute("class").contains("pgEmpty"));
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='<']")).getAttribute("class").contains("pgEmpty"));
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[position()=3]")).getAttribute("class").contains("pgCurrent"));
		}else if (page.equals("前一页")) {
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='末页']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='>']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[last()-3]")).getAttribute("class").contains("pgCurrent"));
		}else if (page.equals("后一页")) {
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='首页']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='<']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[position()=4]")).getAttribute("class").contains("pgCurrent"));
		}else {//第五页
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='末页']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='>']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='首页']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertEqualsActualExpectedByBoolean(base.getElementWithWait(By.xpath("//*[@id='Pagination']/ul/li[text()='<']")).getAttribute("class").contains("pgEmpty"), false);
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath(".//*[@id='Pagination']//li[text()='"+page+"']")).getAttribute("class").contains("pgCurrent"));
		}
	}
	
	/**
	 * 徐天元
	 * 校验利率高低、借款期限、完成进度三角形正确性
	 * type: 初始asc   点击后desc
	 */
	public void isSanJiaoOK(String type){
		if (type.equals("all")) {
			List<WebElement> lists = base.getElements(By.cssSelector(".filterbarfasc"));
			base.assertEqualsActualExpected(lists.size()+"", "3");
		}else if (type.equals("利率高低")) {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//a[text()='利率高低']")).getAttribute("class").contains("filterbarfdesc"));//By.cssSelector(".sorting>li:nth-child(2)>a")
		}else if (type.equals("借款期限")) {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//a[text()='借款期限']")).getAttribute("class").contains("filterbarfdesc"));//By.cssSelector(".sorting>li:nth-child(3)>a")
		}else {
			base.assertTrueByBoolean(base.getElementWithWait(By.xpath("//a[text()='完成进度']")).getAttribute("class").contains("filterbarfdesc"));//By.cssSelector(".sorting>li:nth-child(4)>a")
		}
	}
	
	/**
	 * 徐天元
	 * 点击利率高低、借款期限、完成进度进行排序
	 */
	public void clickSort(String type){
		if (type.equals("利率高低")) {
			base.clickWithWait(By.xpath("//a[text()='利率高低']"));//By.cssSelector(".sorting>li:nth-child(2)>a")
		}else if (type.equals("借款期限")) {
			base.clickWithWait(By.xpath("//a[text()='借款期限']"));//By.cssSelector(".sorting>li:nth-child(3)>a")
		}else {
			base.clickWithWait(By.xpath("//a[text()='完成进度']"));//By.cssSelector(".sorting>li:nth-child(4)>a")
		}
	}
	
	/**
	 * 徐天元
	 * 校验利率高低、借款期限、完成进度排序是否正常
	 * @param type
	 */
	public void isSortOK(String type){
		//利息 .colorE6>span 进度.plan>em  期限.colorF0
		List<WebElement> lists = null;
		if (type.equals("利率高低")) {
			//利息
			lists = base.getElements(By.cssSelector(".colorE6>span"));
		}else if (type.equals("借款期限")) {
			//借款期限
			lists = base.getElements(By.cssSelector(".colorF0"));
		}else {
			//进度
			lists = base.getElements(By.cssSelector(".plan>em"));
		}
		if (lists.size()>0) {
			double before = 0;
			double now = 0;
			for (int i = 0; i < lists.size()-1; i++) {
				if (type.equals("借款期限")) {
					before = Integer.parseInt(lists.get(i).getText());
					now = Integer.parseInt(lists.get(i+1).getText());
					System.out.println("i:"+(i+1)+",before:"+before+",now:"+now);
				}else {
					before = getLX(lists.get(i).getText());
					now = getLX(lists.get(i+1).getText());
					System.out.println("i:"+(i+1)+",before:"+before+",now:"+now);
				}
				//校验利息、期限、进度倒叙
				base.assertTrueByBoolean(before>=now);
			}
		}
	}
	
	/**
	 * xty
	 * 获取利息、进度数值  去掉“%”
	 * @return
	 */
	public double getLX(String text){
		return Double.parseDouble(text.substring(0, text.length()-1));
	}
	
	/**
	 * 徐天元
	 * 地区（右边有倒三角符号）
	 */
	public void isPlaces(String place){
		if (base.browserType.contains("ie")) {
			base.sleep(3000);
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(allPlacesBtn), place);
	}
	
	/**
	 * 徐天元
	 * 点击所有地区
	 */
	public void clickPlaces(){
		//base.clickWithWait(allPlacesBtn);
		base.mouseToElement(allPlacesBtn);
	}
	
	/**
	 * 徐天元
	 * 校验展开所有地区层
	 */
	public void isOpenAllPlacesDiv(){
		base.assertTrueByBoolean(base.isBlock(By.cssSelector(".select_place_c")));
	}
	
	/**
	 * 徐天元
	 * 校验地区选择列表收起
	 */
	public void isNotOpenAllPlacesDiv(){
		if (base.browserType.contains("ie")) {
			base.sleep(2000);
		}
		base.assertEqualsActualExpectedByBoolean(base.isBlock(By.cssSelector(".select_place_c")),false);
	}
	
	/**
	 * 徐天元
	 * 输入地区
	 */
	public void inputPlace(String value){
		base.getElementWithWait(By.cssSelector("#arrcity")).clear();
		base.sendKeysWithWait(By.cssSelector("#arrcity"), value);
		base.mouseToElement(By.cssSelector("#arrcity"));
		//base.clickWithWait(By.cssSelector(".ac_over>a"));
	}
	
	/**
	 * 徐天元
	 * 输入地区
	 */
	public void inputAndSelectPlace(String value){
		base.sendKeysWithWait(By.cssSelector("#arrcity"), value);
		//base.mouseToElement(By.cssSelector("#arrcity"));
		base.clickWithWait(By.cssSelector(".ac_over>a"));
	}
	
	/**
	 * 徐天元
	 * 校验下拉列表中是否检索出以该字母开头的省份或城市
	 */
	public void isFirstChar(String value){
		List<WebElement> list = base.getElements(By.cssSelector("#suggest li span"));
		for (int i = 0; i < list.size(); i++) {
			base.assertTrueByBoolean(list.get(i).getText().substring(0,1).equalsIgnoreCase(value));
		}
	}
	
	/**
	 * 输入为空，下拉列表中是否显示默认地区
	 */
	public void isDefaultValue(){
		List<WebElement> list = base.getElements(By.cssSelector("#suggest li a"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText()+","+Data.defaultPlaces[i]);
			base.assertTrueByBoolean(list.get(i).getText().contains(Data.defaultPlaces[i]));
		}
	}
	
	/**
	 * 徐天元
	 * 点击“搜索”
	 */
	public void clickSearch(){
		base.clickWithWait(By.cssSelector(".select_p_btn"));
	}
	
	/**
	 * 徐天元
	 * 校验搜索结果是否属于搜索地区
	 */
	public void isSearchOK(String space){
		//当前页所有标
		List<WebElement> allList = base.getElements(By.cssSelector(".lendtable dt"));
		//当前页该地区的标		
		List<WebElement> list = base.getElements(By.cssSelector(".lendtable .clear"));
		if (allList.size()>0) {
			for (int i = 0; i < allList.size(); i++) {
				base.assertTrueByBoolean(list.get(i).getText().contains(space));
			}
		}else {
			Reporter.log("此地区无数据"+"<br/>");
			System.out.println("此地区无数据");
		}
		
	}
	
	/**
	 * 徐天元
	 * 搜索文本框下方的热门城市中点击一个城市
	 */
	public String clickHotCity(){
		String city = base.getElementTextWithWait(By.cssSelector(".select_p_2_list>li>a"));
		base.clickWithWait(By.cssSelector(".select_p_2_list>li>a"));
		return city;
	}
	
	/**
	 * 徐天元
	 * 在热门城市下方的“请选择”选择任意省
	 */
	public String clickProvince(){
		String province = base.getElementTextWithWait(By.cssSelector("#provinceList>li>a"));
		base.clickWithWait(By.cssSelector("#provinceList>li>a"));
		return province;
	}
	
	/**
	 * 徐天元
	 * 校验在热门城市下方的请选择任意省,显示该省分的城市（提示选择城市）
	 */
	public void isShowProvinceCitys(){
		String report = "此省所包含的城市有：";
		List<WebElement> citys = base.getElements(By.cssSelector("#stock_city_item a"));
		for (int i = 0; i < citys.size(); i++) {
			report += citys.get(i).getText()+"  ";
		}
		Reporter.log(report+"<br/>");
		System.out.println(report);
		//显示该省分的城市
		base.assertNotNullBy(By.cssSelector("#stock_city_item a"));
		//省消失 
		base.assertEqualsActualExpectedByBoolean(base.isBlock(By.cssSelector("#stock_province_item")), false);
		//提示选择城市
		base.assertNotNullBy(By.cssSelector(".curr .mtbg"));
	}
	
	/**
	 * 徐天元
	 * 选择完省 选择城市
	 */
	public String selectCity(){
		String city = base.getElementTextWithWait(By.cssSelector("#stock_city_item a"));
		base.clickWithWait(By.cssSelector("#stock_city_item a"));
		return city;
	}
	
	/**
	 * 徐天元
	 * 点击公益贷
	 */
	public void clickGongYiDai(){
		base.clickWithWait(By.cssSelector(".ldgyd.fr.colorE6"));
	}
	
	/**
	 * 徐天元
	 * 校验显示公益贷标
	 */
	public void isGongyiDai(){
		//当前页所有标
		List<WebElement> allList = base.getElements(By.cssSelector(".lendtable dt"));
		//当前页公益贷标
		List<WebElement> gydlist = base.getElements(By.cssSelector(".yi.fl"));
		if (allList.size()>0) {
			for (int i = 0; i < allList.size(); i++) {
				base.assertNotNullWebElement(gydlist.get(i));
			}
		}else {
			Reporter.log("无公益贷标");
		}
	}
	
	/**
	 * 徐天元
	 * 校验借款类型选中项背景为红色
	 * @param type
	 */
	public void isTypeBackgroundRed(String type){
		base.sleep(1000);
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#typeDiv .bg86")), type);
	}
	
	/**
	 * 徐天元
	 * 点击借款类型
	 */
	public void clickType(String type){
		switch (type) {
		case "信用借款":
			base.clickWithWait(By.xpath("//dd[text()='信用借款']"));//By.cssSelector(".overflowV>dd:nth-of-type(2)")
			break;
		case "车辆抵押":
			base.clickWithWait(By.xpath("//dd[text()='车辆抵押']"));//By.cssSelector(".overflowV>dd:nth-of-type(3)")
			break;
		case "房屋抵押":
			base.clickWithWait(By.xpath("//dd[text()='房屋抵押']"));//By.cssSelector(".overflowV>dd:nth-of-type(4)")
			break;
		default:
			Reporter.log("借款类型选择有误，请选择信用借款/车辆抵押/房屋抵押"+"<br/>");
			base.assertTrueByBoolean(false);
			break;
		}
	}
	
	/**
	 * 徐天元
	 * 校验显示指定借款类型的标
	 */
	public void isTypeBiao(String type){
		//当前页所有标
		List<WebElement> allList = base.getElements(By.cssSelector(".lendtable dt"));
		//当前页信用借贷标
		List<WebElement> xyjdlist = base.getElements(By.cssSelector(".bao.fl"));
		//当前页车辆抵押标
		List<WebElement> cldylist = base.getElements(By.cssSelector(".che.fl"));
		//当前页房屋抵押标
		List<WebElement> fwdylist = base.getElements(By.cssSelector(".fang.fl"));
		List<WebElement> fwdylist1 = base.getElements(By.cssSelector(".fl>h2"));//借款标题
		int allnum=allList.size(),fwdynum=fwdylist.size();
		if(allnum>0){
			switch (type) {
			case "信用借贷": 	base.assertEqualsActualExpectedByInt(xyjdlist.size(), allnum);
							break;
			case "车辆抵押":   base.assertEqualsActualExpectedByInt(cldylist.size(), allnum);
							break;
			case "房屋抵押":  
//				for(int i=0;i<allnum;i++){
//					if(fwdylist1.get(i).getText().contains("【房产抵押 】")){
//						fwdynum=fwdynum+1;
//					}
//				}
				base.assertEqualsActualExpectedByInt(fwdynum, allnum);
				break;
			}
		
//		if (allList.size()>0) {
//			for (int i = 0; i < allList.size(); i++) {
//				switch (type) {
//				case "信用借贷":
//					base.assertNotNullWebElement(xyjdlist.get(i));
//					break;
//				case "车辆抵押":
//					base.assertNotNullWebElement(cldylist.get(i));
//					break;
//				case "房屋抵押":
//					base.assertNotNullWebElement(fwdylist.get(i));
//					break;
//				default:
//					break;
//				}
//			}
		}else {
			Reporter.log("无相应标"+"<br/>");
		}
	}
	
	/**
	 * 徐天元
	 * 检查窗口中年利率是否与标的利率一致
	 * 计算还需额度是否正确（借款总金额-已投资金额=还需金额）
	 * 检查可用余额显示是否正确（与个人账户的可用余额一致）
	 * 点击窗口右上方,关闭投标金额窗口
	 */
	public void isDebitWindowDataIdentical(double balance){
		//列表可投资的利率
		List<WebElement> lvList = base.getElements(By.xpath("//dd[a[@class='fast_money mt8']]/preceding-sibling::dd[3]//span"));
		//快速投资
		List<WebElement> kstzList = base.getElements(By.cssSelector(".fast_money.mt8"));
		//完成进度
		List<WebElement> wcjdList = base.getElements(By.xpath("//dd[a[@class='fast_money mt8']]/preceding-sibling::dd[1]//em"));
		List<WebElement> jkjeList = base.getElements(By.xpath("//dd[a[@class='fast_money mt8']]/preceding-sibling::dd[3]//p[1]"));
		//可投的标题
		List<WebElement> titleList = base.getElements(By.xpath("//dd[a[@class='fast_money mt8']]/preceding-sibling::dd[4]//a"));
		
		if (kstzList.size()>0) {
			Reporter.log("共" + lvList.size() + "个标可投资"+"<br/>");
			System.out.println("共" + lvList.size() + "个标可投资");
			for (int i = 0; i < lvList.size(); i++) {
				int j = i+1;
				Reporter.log("第" + j + "个标>>>>>>>>>>>>>"+"<br/>");
				System.out.println("第" + j + "个标>>>>>>>>>>>>>");
				int step = 0;
				//列表可投资的利率
				String lv = lvList.get(i).getText();
				//点击快速投资
				kstzList.get(i).click();
				//关闭弹出空白页
				if (base.gethandelsNum()==2) {
					base.turnToOldPage();
				}
				//投资窗口利率
				String tzckll = base.getElementTextWithWait(By.cssSelector("#interestrate_t"));
				//投资窗口还需金额
//				double amount = Double.parseDouble(base.getElementTextWithWait(By.cssSelector("#amount1")));
				int amount = Integer.parseInt(base.getElementTextWithWait(By.cssSelector("#amount1")));
				//可用余额
				double kyye = Double.parseDouble(base.getElementTextWithWait(By.cssSelector("#userbalance")));
				//检查窗口中年利率是否与标的利率一致
				try {
					base.assertEqualsActualExpected(tzckll, lv);
					Reporter.log("窗口中年利率是否与标的利率一致:校验成功"+"<br/>");
					System.out.println("窗口中年利率是否与标的利率一致:校验成功");
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("窗口中年利率是否与标的利率一致:校验失败，期盼："+lv+",实际："+tzckll+"<br/>");
					System.out.println("窗口中年利率是否与标的利率一致:校验失败，期盼："+lv+",实际："+tzckll);
				}
				//借款金额
				double jkje = Double.parseDouble(jkjeList.get(i).getText().replaceAll(",", "").replace("￥", ""));
				/*********页面获取**********/
				//转换进度
				String progress = wcjdList.get(i).getText().replace("%", "");System.out.println(progress);
				if(base.Money((jkje-amount)/jkje*100).equals(progress)){
					Reporter.log("计算还需额度是否正确:校验成功"+"<br/>");
					System.out.println("计算还需额度是否正确:校验成功");
					step += 1;
				}else{
					Reporter.log("计算还需额度是否正确:校验失败");
					System.out.println("计算还需额度是否正确:校验失败");
				}
				//检查可用余额显示是否正确（与个人账户的可用余额一致）
				try {
					base.assertEqualsActualExpectedByDouble(kyye, balance);
					Reporter.log("检查可用余额显示是否正确（与个人账户的可用余额一致）:校验成功"+"<br/>");
					System.out.println("检查可用余额显示是否正确（与个人账户的可用余额一致）:校验成功");
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("检查可用余额显示是否正确（与个人账户的可用余额一致）:校验失败，期盼："+balance+",实际："+kyye+"<br/>");
					System.out.println("检查可用余额显示是否正确（与个人账户的可用余额一致）:校验失败，期盼："+balance+",实际："+kyye);
				}
				//点击窗口右上方,关闭投标金额窗口
				closeBitWindow();
				try {
					base.sleep(2000);
					base.assertTrueByBoolean(!base.isBlock(By.cssSelector("#fastLender_1")));
					Reporter.log("点击窗口右上方,关闭投标金额窗口:校验成功"+"<br/>");
					System.out.println("点击窗口右上方,关闭投标金额窗口:校验成功");
					step += 1;
				} catch (AssertionError e) {
					Reporter.log("点击窗口右上方,关闭投标金额窗口:校验失败"+"<br/>");
					System.out.println("点击窗口右上方,关闭投标金额窗口:校验失败");
				}
				int result = 4;
//				if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
//					result = 3;
//				}
				if (step == result) {
					base.assertTrueByBoolean(true);
				}else {
					base.assertTrueByBoolean(false);
				}
			}
		}else {
			Reporter.log("没有可投资的散标"+"<br/>");
		}
	}
	
	/**
	 * 徐天元
	 * 关闭投资窗口
	 */
	public void closeBitWindow(){
		base.clickWithWait(By.cssSelector("#fastLender_1 .close.fr"));
		if (base.gethandelsNum()>=2) {
			base.closeWebDriver();
		}
	}
	
	/**
	 * 徐天元
	 * 点击快速投资
	 * 有快速投资返回true  没有返回false
	 */
	public boolean clickKstz(){
		//快速投资
		List<WebElement> kstzList = base.getElements(By.cssSelector(".fast_money.mt8"));
		if (kstzList.size()>0) {
			for (int i = 0; i < 1; i++) {
				kstzList.get(i).click();
				//关闭弹出空白页
				if (base.gethandelsNum()>=2) {
					base.closeWebDriver();
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 徐天元
	 * 点击投资窗口的充值
	 */
	public void clickRecharge(){
		base.clickWithWait(By.cssSelector(".cpt.fl"));
	}
	
	/**
	 * 徐天元
	 * 点击投资窗口的忘记密码
	 */
	public void clickForgetPassword(){
		base.clickWithWait(By.xpath("//input[@id='paypassowrd']/following-sibling::a"));//By.cssSelector(".cont.font14>p:nth-of-type(4)>a")
	}
	
	/**
	 * 徐天元
	 * 点击投资窗口的自动投标
	 */
	public void clickAutoBid(){
		base.clickWithWait(By.cssSelector(".mt15.textC>a"));
	}
	
	/**
	 * 徐天元
	 * 点击自动输入
	 */
	public void clickAutoInputBtn(){
		base.clickWithWait(By.cssSelector(".mt10.borderTF2.h30.pdt20.clear>.ml10"));
	}
	
	/**
	 * 徐天元
	 * 获取计算出来的自动输入值
	 */
	public String getAutoValue(){
		return base.getElementWithWait(By.cssSelector("#amount")).getAttribute("value");
	}
	
	/**
	 * 徐天元
	 * 判断自动输入是否正确
	 */
	public void isAutoInputOk(){
		//还需额度
		int needAmount = Integer.parseInt(base.getElementTextWithWait(By.cssSelector("#amount1")).split("\\.")[0]);
		//余额
		int balance = Integer.parseInt(base.getElementTextWithWait(By.cssSelector("#userbalance")).split("\\.")[0]);
		//点击投资窗口的自动输入
		clickAutoInputBtn();
		//验证自动输入
		if (balance<50) {//余额<50
			base.checkAlertText("金额不足50，不能投标");
		}else if (balance>=50 && balance<needAmount) {//50<=可用金额<还需额度
			System.out.println("50<=可用金额<还需额度");
			base.assertEqualsActualExpected(getAutoValue(), balance+"");
		}else {
			System.out.println("可用金额>还需额度");
			base.assertEqualsActualExpected(getAutoValue(), needAmount+"");
		}
	}
	
	/**
	 * 徐天元
	 * 校验是否所有可投资的散标自动输入是否正确
	 */
	public void isAllAutoInputOk(){
		//快速投资
		List<WebElement> kstzList = base.getElements(By.cssSelector(".fast_money.mt8"));
		if (kstzList.size()>0) {
			for (int i = 0; i < kstzList.size(); i++) {
				kstzList.get(i).click();
				//关闭弹出空白页
				if (base.gethandelsNum()>=2) {
					base.closeWebDriver();
				}
				isAutoInputOk();
				closeBitWindow();
			}	
		}else {
			Reporter.log("没有可投资的散标"+"<br/>");
		}
	}
	
	/**
	 * 徐天元
	 * 校验投资错误提示
	 */
	public void isWrong(String msg){
		//base.sleep(2000);
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#fastLender_2")));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#errorMsg")), msg);
	}
	
	/**
	 * 徐天元
	 * 校验密码长度
	 */
	public void isPayPasswordLenthOK(){
		base.assertEqualsActualExpectedByInt(base.getElementWithWait(By.cssSelector("#paypassowrd")).getAttribute("value").length(), 16);
	}
	
	/**
	 * 徐天元
	 * 校验投资成功
	 */
	public void isBitOk(){
		//base.sleep(3000);
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#fastLender_2")));
		if(base.getElementTextWithWait(BidFailTxt).equals("")){
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#tenderOK")), "投标成功");
		}else{
			String ErrorTxt = base.getElementText(BidFailTxt);
			Reporter.log(ErrorTxt);
			Assert.fail(ErrorTxt);
		}
		//base.assertTrueByBoolean(base.isBlock(By.cssSelector("#fastLender_2")));
	}
	
	/**
	 * 徐天元
	 * 投资窗口 点击取消
	 */
	public void clickCancel(){
		base.clickWithWait(By.cssSelector(".f_m_Cancel.ml76"));
		if (base.gethandelsNum()>=2) {
			base.closeWebDriver();
		}
	}
	
	/**
	 * 徐天元
	 * 投资窗口消失
	 */
	public void isBitWindowDisappear(){
		base.checkNoElement(By.cssSelector("#fastLender_1"));
		//base.assertTrueByBoolean(!base.isBlock(By.cssSelector("#fastLender_1")));
	}
	
	/**
	 * 徐天元
	 * 投资窗口消失
	 */
	public void isBitWindowDisplay(){
		//base.sleep(2000);
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#fastLender_1")));
	}
	
	/**
	 * 徐天元
	 * 点击去我的账户查看
	 */
	public void toUserCenter(){
		base.clickWithWait(By.cssSelector("#userCenter"));
	}
	
	/**
	 * 徐天元
	 * 提示框消失
	 */
	public void isPromptDisappear(){
		//base.sleep(2000);
		//base.assertTrueByBoolean(!base.isElementPresent(By.cssSelector("#fastLender_2")));
		base.checkNoElement(By.cssSelector("#fastLender_2"));
	}
	
	/**
	 * 徐天元
	 * 校验充值提示
	 */
	public void isShowRecharge(){
		base.sleep(2000);
		base.assertTrueByBoolean(base.checkVisible(By.cssSelector("#noPerson")));
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#noPerson .lyct>.textC")), "亲 请先去充值,再投资!");
	}
	//检查“投资列表”页的文字描述
	public void checkInvestListDatawithLogin(){
		
		String [][] search = {{"不限","等额本金","等额本息","还本付息"},{"不限","3个月以下","4～6个月","7～11个月","12个月以上"},{"不限","12%以下","12%～15%","15%～18%","18%以上"},{"不限","信用借款","车辆抵押","房屋抵押"}};
		String [] desc = {"还款方式：","借款期限：","借款利率：","借款类型："};
		List<WebElement> Desc = base.getElements(SearchOptionDesTxt);
		for(int i=1;i<=4;i++){
			base.assertEqualsActualExpected(Desc.get(i-1).getText(), desc[i-1]);
			for(int j=1;j<=search[i-1].length;j++){
				base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@class='wrap mt15 overflowV']/div/div["+i+"]/dl/dd["+j+"]")), search[i-1][j-1]);
			}
		}
		base.assertEqualsActualExpected(base.getElementText(ReserveBidBtn), "预约投标");
		base.assertEqualsActualExpected(base.getElementNoWait(ReserveBidBtn).getCssValue("background-color"), "rgba(255, 117, 0, 1)");
		base.assertEqualsActualExpected(base.getElementNoWait(ReserveBidTxt).getCssValue("color"), "rgba(255, 255, 255, 1)");
		base.assertEqualsActualExpected(base.getElementText(AutoBidBtn), "自动投标");
		base.assertEqualsActualExpected(base.getElementText(AutoBidDescTxt), "没时间抢标，可设置自动投标");
		if(base.indexURL.contains("client")){
			base.assertTrueByBoolean(base.getLnkElementText(CarOptionImg, "src").contains(base.indexURL+"/page/loan/images/new.gif"));
			base.assertTrueByBoolean(base.getLnkElementText(HouseOptionImg, "src").contains(base.indexURL+"/page/loan/images/new.gif"));
		}else if(base.indexURL.contains("test")){
//			base.assertTrueByBoolean(base.getLnkElementText(CarOptionImg, "src").contains("http://static66.eloancn.com//page/loan/images/new.gif"));
//			base.assertTrueByBoolean(base.getLnkElementText(HouseOptionImg, "src").contains("http://static66.eloancn.com//page/loan/images/new.gif"));
			base.assertTrueByBoolean(base.getLnkElementText(CarOptionImg, "src").contains("http://www.eloancn.com/page/loan/images/new.gif"));
			base.assertTrueByBoolean(base.getLnkElementText(HouseOptionImg, "src").contains("http://www.eloancn.com/page/loan/images/new.gif"));
		}else if(base.indexURL.contains("www")){
			base.assertTrueByBoolean(base.getLnkElementText(CarOptionImg, "src").contains("http://static7.eloancn.com//page/loan/images/new.gif"));
			base.assertTrueByBoolean(base.getLnkElementText(HouseOptionImg, "src").contains("http://static7.eloancn.com//page/loan/images/new.gif"));
		}
	}
	//点击“自动投标”链接
	public void clickAutoBidBtn(int flag){
		
//		if(base.isElementPresent(LoginPage.LoginLnk)){
		if(flag==1){//已登录
			base.clickWithWait(AutoBidBtn);
			base.checkElement(AutoBidPage.Main);
			base.checkElmentText(By.cssSelector("a.ico-autobit.cur"), "自动投标");
		}else{
			base.clickWithWait(AutoBidBtn);
			base.checkElementVisible(LoginPage.LoginPart);
		}
	}

	//点击“车辆抵押”的借款类型
	public void clickCarMortgageOption(){
		base.clickWithWait(CarMortgageLnk);
		base.checkElmentText(SelectedCarLnk, "车辆抵押");
	}
	
	//点击“车辆抵押”的借款类型
	public void clickHouseMortgageOption(){
		base.clickWithWait(HouseMortgageLnk);
		base.checkElmentText(SelectedHouseLnk,"房屋抵押");
	}
	
	//点击“收益计算器”图标
	public void clickIncomeCalculatorLnk(){
		base.clickElementNoWait(IncomeCalculatorLnk);
		base.checkElementVisible(CloseCalculatorBtn);
	}
	//收益计算器中输入“投资金额”
	public void InputMoney(String value){
		base.sendKeysWithWait(InputInvestMoney, value);
	}
	//收益计算器中输入“年利率”
	public void InputLoanRate(String value){
		base.sendKeysWithWait(InputLoanRate,value);
	}
	//收益计算器中输入“投资期限”
	public void InputLoanPhases(String value){
		base.sendKeysWithWait(InputloanPhases, value);
	}
	//选中“显示计划时间表”
	public void checkShowPlanTable(){
		base.clickWithWait(PlanTableCheckBox);	
	}
	//收益计算器中点击“马上计算”
	public void clickCalculateNowBtn(){
		base.clickWithWait(CalculateNowBtn);
	}
	
	//关闭收益计算器
	public void clickCloseCalculatorBtn(){
		base.clickWithWait(CloseCalculatorBtn);
		base.checkNoElement(CloseCalculatorBtn);
	}
	//输入“投资金额”，“年利率”，“投资期限”并计算
	public void InputInvestInfos(String money,String rate,String phase,int i,String alert){
		InputMoney(money);
		InputLoanRate(rate);
		InputLoanPhases(phase);
		clickCalculateNowBtn();
		if(i==0){
			base.checkAlertText(alert);
		}else if(i==1){
			base.assertTrueByBoolean(!base.isAlertPresent(8));
		}
	}
	//检查“还款方式”的下拉框选项
	public void checkDropdownList(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(HBFXMode), "还本付息");
		base.assertTrueByBoolean(base.getElementNoWait(HBFXMode).isSelected());
		base.clickWithWait(RepayMode);
		List<WebElement> Options = base.getElements(HBFXMode);
		String [] Mode = {"还本付息","等额本息","等额本金"};
		for(int i=0;i<Options.size();i++){
			base.assertEqualsActualExpected(Options.get(i).getText(), Mode[i]);
		}
	}
	//收益计算器-检查收款总额和利息
	public void checkAmountAndInterest(boolean showPlanTable,double money,double rate, int phase){
		if(showPlanTable){
			base.checkElementVisible(SKSJB);
			base.assertEqualsActualExpected(base.getElementText(SKSJBTxt), "收款时间表");
			String [] txt = {"期次","收款时间","月收取利息","月收取本金" ,"月收取总额","剩余本金"};
			List<WebElement> titles = base.getElements(subTitle);
			for(int i=0;i<6;i++){
				base.assertEqualsActualExpected(titles.get(i).getText(), txt[i]);
			}
		}else{
			base.checkNoElement(SKSJB);
		}
		String amount = new DecimalFormat("###,##0.##").format(money*rate*0.01/12.0*phase+money);
//		System.out.println(money*rate*0.01/12*phase);
		String am="";
		if(amount.contains(",")){
			am= amount.replaceAll(",", "");
		}
		String interest = base.intMoney(Double.parseDouble(am)-money);
		if(interest.contains(",")){
			interest= interest.replaceAll(",", "");
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(AmountAndInterestTxt),"收款总额： "+amount+"元    利息： "+interest+"元（注：实际收款中可能因为月偿还利息为非整数而产生几分钱的误差）");
	}
	public void checkDatainTable(double money,double rate,int phase){
		base.checkElementVisible(SKSJBTxt);
		String qici[]=new String[phase],time[]=new String[phase],MonthLX[]=new String[phase],MonthBJ[]=new String[phase],MonthAmount[]=new String[phase],RemainBJ[]=new String[phase];
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String monthlx=base.cutMoney(money*rate/1200);
		for(int i=0;i<phase;i++){
			qici[i]=String.valueOf(i+1);
			cal.add(Calendar.MONTH, 1);
			time[i]= df.format(cal.getTime());
			MonthLX[i]=monthlx;
			if((i+1)==phase){
				MonthBJ[i]= base.CutMoney(money);
				String monthli = "",monthbj="";
				if(monthlx.contains(",")||MonthBJ[i].contains(",")){
					monthli = monthlx.replace(",", "");
					monthbj = MonthBJ[i].replaceAll(",", "");
				}
				MonthAmount[i]= new DecimalFormat("###,##0.##").format(Double.parseDouble(monthli)+Double.parseDouble(monthbj));
				RemainBJ[i] = "0";
			}else{
				MonthBJ[i]= "0";
				MonthAmount[i]= monthlx;
				RemainBJ[i] = new DecimalFormat("###,##0.##").format(money);
			}
		}
		String table[][]={qici,time,MonthLX,MonthBJ,MonthAmount,RemainBJ};
		for(int i=1;i<=phase;i++){
			for(int j=1;j<6;j++){
				base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//tbody[@id='datatbody']/tr["+j+"]/td["+i+"]")), table[i-1][j-1]);
			}
		}
	}
	
	public void checkDefaultOptions(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(SelectedMode), "不限");
		String color=base.getStyle("document.getElementById('repaymentDiv').getElementsByTagName('dd')[0]" ,"background-color");
		base.assertEqualsActualExpected(color, "rgb(255, 51, 0)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(SelectedPhase), "不限");
		String color1=base.getStyle("document.getElementById('phasesDiv').getElementsByTagName('dd')[0]" ,"background-color");
		base.assertEqualsActualExpected(color1, "rgb(255, 51, 0)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(SelectedRate), "不限");
		String color2=base.getStyle("document.getElementById('interDiv').getElementsByTagName('dd')[0]" ,"background-color");
		base.assertEqualsActualExpected(color2, "rgb(255, 51, 0)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(SelectedType), "不限");
		String color3=base.getStyle("document.getElementById('typeDiv').getElementsByTagName('dd')[0]" ,"background-color");
		base.assertEqualsActualExpected(color3, "rgb(255, 51, 0)");
		if(base.getElementTextWithWait(ListContent).equals("")){
			System.out.println("投资列表页没有数据！");
		}
	}
	public void clickRepayModeOption(String option){
		base.clickWithWait(By.xpath("//div[@id='repaymentDiv']/dl/dd[text()='"+option+"']"));
		base.checkElmentText(SelectedMode, option);
//		if(base.getElementTextWithWait(ListContent).equals("")){
//			System.out.println("没有"+option+"的借款！");
//		}else{
//			int lines = getUserImg().size();
//			for(int j=1;j<=lines;j++){
//				base.assertEqualsActualExpected(base.getElementText(By.xpath("//dd["+(j*5-2)+"]/p[2]")), option);
//			}
//		}
	}

	public void clickPhaseOption(String option){
		base.clickWithWait(By.xpath("//div[@id='phasesDiv']/dl/dd[text()='"+option+"']"));
		base.checkElmentText(SelectedPhase, option);
//		if(base.getElementTextWithWait(ListContent).equals("")){
//			System.out.println("没有"+option+"的借款！");
//		}else{
//			int beginphase = 0,endphase = 0;
//			String shuzi = option.substring(0,option.indexOf("个月"));
//			if(shuzi.equals("3")){
//				beginphase=1;
//				endphase=3;
//			}else if(shuzi.equals("12")){
//				beginphase=12;
//				endphase=24;
//			}else if(shuzi.contains("～")){
//				beginphase = Integer.parseInt(shuzi.split("～")[0]);
//				endphase = Integer.parseInt(shuzi.split("～")[1]);
//			}
//			int lines = getUserImg().size();
//			for(int j=1;j<=lines;j++){
//				int RealPhase= Integer.parseInt(base.getElementTextWithWait(By.xpath("//dd["+(5*j-2)+"]/p/span")));
//				base.assertTrueByBoolean(RealPhase>=beginphase && RealPhase<=endphase);
//			}
//		}
	}
	
	public void clickRateOption(String option){
		base.clickWithWait(By.xpath("//div[@id='interDiv']/dl/dd[text()='"+option+"']"));
		base.checkElmentText(SelectedRate, option);
//		if(base.getElementTextWithWait(ListContent).equals("")){
//			System.out.println("没有"+option+"的借款！");
//		}else{
//			int beginrate = 0,endrate = 0;
//			String rate = option.substring(0,option.lastIndexOf("%"));
//			if(rate.equals("12")){
//				beginrate=1;
//				endrate=11;
//			}else if(rate.equals("18")){
//				beginrate=19;
//				endrate=22;
//			}else if(rate.contains("～")){
//				beginrate = Integer.parseInt(rate.substring(0,2));
//				endrate = Integer.parseInt(rate.split("～")[1]);
//			}
//			int lines = getUserImg().size();
//			for(int j=1;j<=lines;j++){
//				String Realrate= base.getElementTextWithWait(By.xpath("//dd["+(5*j-3)+"]/p[2]/span"));
//				if(!Realrate.equals("20.40%")){
//					int real = Integer.parseInt(Realrate.substring(0, Realrate.indexOf("%")));
//					base.assertTrueByBoolean(real>=beginrate && real<=endrate);
//				}else{
//					base.assertTrueByBoolean(rate.equals("18"));
//				}
//			}
//		}
	}

	public void checkOption(String Repayoption,String phaseoption,String rateoption,String typeoption){
		if(base.getElementTextWithWait(ListContent).equals("")){
			System.out.println("没有"+Repayoption+phaseoption+rateoption+typeoption+"的借款！");
		}else{	
			int lines = getUserImg().size();
			for(int j=1;j<=lines;j++){
				if(Repayoption.equals("等额本金")||Repayoption.equals("等额本息")||Repayoption.equals("还本付息")){
					base.assertEqualsActualExpected(base.getElementText(By.xpath("//dd["+(j*5-2)+"]/p[2]")), Repayoption);
				}else if(phaseoption.equals("3个月以下")||phaseoption.equals("4～6个月")||phaseoption.equals("7～11个月")||phaseoption.equals("12个月以上")){
					int beginphase = 0,endphase = 0;
					String shuzi = phaseoption.substring(0,phaseoption.indexOf("个月"));
					if(shuzi.equals("3")){
						beginphase=1;
						endphase=3;
					}else if(shuzi.equals("12")){
						beginphase=12;
						endphase=24;
					}else if(shuzi.contains("～")){
						beginphase = Integer.parseInt(shuzi.split("～")[0]);
						endphase = Integer.parseInt(shuzi.split("～")[1]);
					}
					int RealPhase= Integer.parseInt(base.getElementTextWithWait(By.xpath("//dd["+(5*j-2)+"]/p/span")));
					base.assertTrueByBoolean(RealPhase>=beginphase && RealPhase<=endphase);
				}else if(rateoption.equals("12%以下")||rateoption.equals("12%～15%")||rateoption.equals("15%～18%")||rateoption.equals("18%以上")){
					int beginrate = 0,endrate = 0;
					String rate = rateoption.substring(0,rateoption.lastIndexOf("%"));
					if(rate.equals("12")){
						beginrate=1;
						endrate=11;
					}else if(rate.equals("18")){
						beginrate=19;
						endrate=22;
					}else if(rate.contains("～")){
						beginrate = Integer.parseInt(rate.substring(0,2));
						endrate = Integer.parseInt(rate.split("～")[1]);
					}
					String Realrate= base.getElementTextWithWait(By.xpath("//dd["+(5*j-3)+"]/p[2]/span"));
					if(!Realrate.equals("20.40%")){
						int real = Integer.parseInt(Realrate.substring(0, Realrate.indexOf("%")));
						base.assertTrueByBoolean(real>=beginrate && real<=endrate);
					}else{
						base.assertTrueByBoolean(rate.equals("18"));
					}
				}else if(typeoption.equals("信用借款")||typeoption.equals("车辆抵押")||typeoption.equals("房屋抵押")){
					String key = "";
					if(typeoption.equals("信用借款")){
						key="保";
					}else if(typeoption.equals("车辆抵押")){
						key="车";
					}else if(typeoption.equals("房屋抵押")){
						key="房";
					}
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//dd["+(5*j-4)+"]/h3/span")), key);
				}
			}
		}
	}
}
