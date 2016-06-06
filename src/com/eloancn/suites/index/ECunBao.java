package com.eloancn.suites.index;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.RegisterPage;

/**
 * 首页“翼存宝”用例
 * @author 江渤洋
 */
public class ECunBao {

	Base base = new Base();
	Data data = new Data();
	DBData dbData = new DBData();
	
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	RegisterPage registerPage = new RegisterPage();
	
	String name,pass,payPass;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(base.indexURL);
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			name = Data.tel_run_EcunBao;
    		pass = Data.password;
			payPass = Data.zzmm;
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			name = Data.test2_tel;
    		pass = Data.test2_password;
			payPass = Data.test2_zzmm;
		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test (priority = 1, enabled = true)
	public void checkECunBaoHomeData_AT_589(){
		
		Reporter.log("首页：翼存宝数据——>校验1、最多显示4期翼存宝   2、先按状态排序:未结束的排在上方；再按时间倒序排列<br/>");
		System.out.println("首页：翼存宝数据——>校验1、最多显示4期翼存宝   2、先按状态排序:未结束的排在上方；再按时间倒序排列");
		List<String> frontPageTitleList = new ArrayList<String>();
		List<String> databasesTitleList = new ArrayList<String>();
		int rowNum = 3,cellNum = 1;//行数，列数
		if(!loginPage.isLogout()){
			base.logout();//登出
		}
		base.isTitle(PageTitles.shouYe);
		//内网测试首页与数据库显示是否一致，是否排序
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			//获取翼存宝首页Title
			frontPageTitleList = indexPage.getECunBaoHomeDataAll(rowNum,cellNum-1);
			//获取翼存宝数据库Title
			databasesTitleList = dbData.getECunBaoTitleTopFour();
			//校验首页Title 和 数据库Title 排序是否一致
			indexPage.checkECunBaoHomeTitle(frontPageTitleList, databasesTitleList);
		}
		//外测试首页是否显示4条数据
		else if(base.indexURL.contains("www") || base.indexURL.contains("test")){
			//获取翼存宝首页Title
			frontPageTitleList = indexPage.getECunBaoHomeDataAll(rowNum,cellNum-1);
			//验证是否显示4条数据
			indexPage.checkECunBaoDataNum(frontPageTitleList);
		}
	}

	@Test (priority = 2, enabled = true)
	public void checkECunBaoTitle_AT_589(){
		
		Reporter.log("首页：翼存宝数据——>校验“标题”、“年化收益”、“合约期限”、“已募集金额”、“总募集金额”与翼存宝列表页中相应期数数据一致<br/>");
		System.out.println("首页：翼存宝数据——>校验“标题”、“年化收益”、“合约期限”、“已募集金额”、“总募集金额”与翼存宝列表页中相应期数数据一致");
		List<String> HomeDataOneList = new ArrayList<String>();
		List<String> eCunBaoDataOneList = new ArrayList<String>();
		String id = "";
		base.openBrowser(base.indexURL);
		if(!loginPage.isLogout()){
			base.logout();//登出
		}
		base.isTitle(PageTitles.shouYe);
		id = indexPage.getECunBaoHomeDataOneId();
		//获取首页翼存宝的相关数据
		HomeDataOneList = indexPage.getECunBaoHomeDataOne(5);
		//跳转到“翼存宝”页面
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		//获取列表页翼存宝的相关数据
		eCunBaoDataOneList = eCunBaoPage.getECunBaoDataOne(id);
		indexPage.checkECunBaoDataOne(HomeDataOneList, eCunBaoDataOneList);
		Reporter.log("翼存宝首页、列表页的“已募集金额”无法校验，请手动测试<br/>");
		System.out.println("翼存宝首页、列表页的“已募集金额”无法校验，请手动测试");
	}
	
	@Test (priority = 3, enabled = true)
	public void checkPopupWindow_AT_590(){
		
		Reporter.log("首页：翼存宝功能_未登录——>1.点击“马上投资”按钮和“投一笔”按钮——>校验是否弹出登录窗口<br/>");
		System.out.println("首页：翼存宝功能_未登录——>1.点击“马上投资”按钮和“投一笔”按钮——>校验是否弹出登录窗口");
		base.openBrowser(base.indexURL);
		if(!loginPage.isLogout()){
			base.logout();//登出
		}
		base.isTitle(PageTitles.shouYe);
		//“投一笔”按钮在Table中的位置：1~3行6列
		int rowNum = 1,cellNum = 6;
		//点击“马上投资”按钮
		if(indexPage.isInvestmentBtn()){
			indexPage.clickInvestmentBtn();
			indexPage.checkLoginTitle();
		}else{
			System.out.println("error_首页翼存宝_'马上投资'按钮无法点击");
			Reporter.log("error_首页翼存宝_'马上投资'按钮无法点击");
		}
		//获取“投一笔”按钮
		WebElement AnIinvestmentBtn = indexPage.getAnIinvestmentBtn(rowNum, cellNum-1);
		//如果“投一笔”按钮存在
		if(AnIinvestmentBtn!=null){
			//点击“投一笔”按钮
			indexPage.clickAnIinvestmentBtn(AnIinvestmentBtn);
			indexPage.checkLoginTitle();
		}
	}

	@Test (priority = 4, enabled = true)
	public void checkFunction_AT_591(){
		
		Reporter.log("首页：翼存宝功能_已登录——>1.点击“债权详情”；2.点击“点我！红包变现”；3.点击“马上投资”按钮；4.点击“投一笔”按钮；5.点击“查看更多翼存宝项目”；校验各功能是否正确<br/>");
		System.out.println("首页：翼存宝功能_已登录——>1.点击“债权详情”；2.点击“点我！红包变现”；3.点击“马上投资”按钮；4.点击“投一笔”按钮；5.点击“查看更多翼存宝项目”；校验各功能是否正确");
		//“投一笔”按钮在Table中的位置：1~3行6列
		int rowNum = 1,cellNum = 6;
		//重新登录
		loginPage.reLogin(name, pass);
		//获得父窗口句柄
		String CurrentWindowHandleString = base.getCurrentWindowHandle();
		//点击“点我！红包变现”
		indexPage.clickRedEnvelopesLink();
		//检查 弹出“红包变现规则”窗口
		indexPage.checkRedEnvelopesTitle();
		//点击“马上投资”按钮
		if(indexPage.isInvestmentBtn()){
			indexPage.clickInvestmentBtn();
			indexPage.checkInvestmentTitle();
		}else{
			System.out.println("error_首页翼存宝_'马上投资'按钮无法点击");
			Reporter.log("error_首页翼存宝_'马上投资'按钮无法点击");
		}
		
		//获取“投一笔”按钮
		WebElement AnIinvestmentBtn = indexPage.getAnIinvestmentBtn(rowNum, cellNum-1);
		//判断“投一笔”按钮是否存在
		if(AnIinvestmentBtn!=null){
			//点击“投一笔”按钮
			indexPage.clickAnIinvestmentBtn(AnIinvestmentBtn);
			//检查 弹出投资窗口
			indexPage.checkInvestmentTitle();
		}
		//点击“查看更多翼存宝项目”
		indexPage.clickMoreLink();
		//链接至“翼存宝”投资列表页
		indexPage.checkInvestmentListTitle(CurrentWindowHandleString);
	}
	
	@Test (priority = 5, enabled = true)
	public void checkInvestment_AT_592(){
		
		Reporter.log("首页：翼存宝功能——>点击“马上投资”按钮——>校验投资是否成功<br/>");
		System.out.println("首页：翼存宝功能——>点击“马上投资”按钮——>校验投资是否成功");
		//“购买份额”
		String buyShareNum = "1";

		//重新登录
		loginPage.reLogin(name, pass);
		base.isTitle(PageTitles.shouYe);
		eCunBaoPage.immediatelyInvestment(buyShareNum,payPass);
		
	}
	
	@Test(priority = 6, enabled = true)
	public void checkBondDetails_AT_5266(){
		
		Reporter.log("首页：翼存宝——>1.第一条翼存宝的“债权详情”按钮是否显示；点击按钮，窗口是否打开<br/>");
		Reporter.log("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常<br/>");
		Reporter.log("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息<br/>");
		Reporter.log("4.再次点击“查看详情”按钮，标详情关闭<br/>");
		Reporter.log("5.点击关闭按钮，窗口关闭<br/>");
		System.out.println("首页：翼存宝——>1.第一条翼存宝的“债权详情”按钮是否显示；点击按钮，窗口是否打开");
		System.out.println("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常");
		System.out.println("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息");
		System.out.println("4.再次点击“查看详情”按钮，标详情关闭");
		System.out.println("5.点击关闭按钮，窗口关闭");
		
		if(loginPage.ifLogin()){//登录
			base.logout();
		}
		loginPage.homeLogin(name, pass);

		indexPage.clickECunBaoDataHomeZhaiQuanOne();
		indexPage.checkECBBondDetailsDIVColumnName();
		indexPage.checkECBBondDetailsDIVColumnValue("借款标题");
		indexPage.checkECBBondDetailsDIVColumnValue("借款人姓名");
		indexPage.checkECBBondDetailsDIVColumnValue("身份证号");
		indexPage.checkECBBondDetailsDIVColumnValue("操作");
		indexPage.checkBondDetails();
	}
	
	@Test(priority = 7, enabled = true)
	public void checkBondDetails_AT_5271(){
		
		Reporter.log("首页：翼存宝——>1.第一条翼存宝的“马上投资”——>点击“债权详情”链接，窗口是否打开<br/>");
		Reporter.log("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常<br/>");
		Reporter.log("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息<br/>");
		Reporter.log("4.再次点击“查看详情”按钮，标详情关闭<br/>");
		Reporter.log("5.点击关闭按钮，窗口关闭<br/>");
		System.out.println("首页：翼存宝——>1.第一条翼存宝的“债权详情”按钮是否显示；点击按钮，窗口是否打开");
		System.out.println("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常");
		System.out.println("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息");
		System.out.println("4.再次点击“查看详情”按钮，标详情关闭");
		System.out.println("5.点击关闭按钮，窗口关闭");
		
		if(loginPage.ifLogin()){//登录
			base.logout();
		}
		loginPage.homeLogin(name, pass);

		if(indexPage.isInvestmentBtn()){
			indexPage.clickInvestmentBtn();
			if(base.isElementContainsValue2(By.cssSelector("#fastLender_1"), "style", "block")){
				indexPage.clickInvestmentBondDetails();
				indexPage.checkECBBondDetailsDIVColumnName();
				indexPage.checkECBBondDetailsDIVColumnValue("借款标题");
				indexPage.checkECBBondDetailsDIVColumnValue("借款人姓名");
				indexPage.checkECBBondDetailsDIVColumnValue("身份证号");
				indexPage.checkECBBondDetailsDIVColumnValue("操作");
				indexPage.checkBondDetails();
			}
			else{
				indexPage.checkInvestmentTitle();
			}

		}else{
			System.out.println("error_首页翼存宝_'马上投资'按钮无法点击");
			Reporter.log("error_首页翼存宝_'马上投资'按钮无法点击");
		}
	}
	
	@Test(priority = 8, enabled = true)
	public void checkBondDetails_AT_5267(){
		
		Reporter.log("首页：翼存宝——>1.第2~4条翼存宝点击“债权详情”链接，窗口是否打开<br/>");
		Reporter.log("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常<br/>");
		Reporter.log("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息<br/>");
		Reporter.log("4.再次点击“查看详情”按钮，标详情关闭<br/>");
		Reporter.log("5.点击关闭按钮，窗口关闭<br/>");
		System.out.println("首页：翼存宝——>1.第一条翼存宝的“债权详情”按钮是否显示；点击按钮，窗口是否打开");
		System.out.println("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常");
		System.out.println("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息");
		System.out.println("4.再次点击“查看详情”按钮，标详情关闭");
		System.out.println("5.点击关闭按钮，窗口关闭");
		
		indexPage.clickECunBaoDataTFBondLink();
		indexPage.checkECBBondDetailsDIVColumnName();
		indexPage.checkECBBondDetailsDIVColumnValue("借款标题");
		indexPage.checkECBBondDetailsDIVColumnValue("借款人姓名");
		indexPage.checkECBBondDetailsDIVColumnValue("身份证号");
		indexPage.checkECBBondDetailsDIVColumnValue("操作");
		indexPage.checkBondDetails();
	}
	
	@Test(priority = 9, enabled = true)
	public void checkBondDetails_AT_5268(){
		
		Reporter.log("首页：翼存宝——>1.第2~4条翼存宝“投一笔”按钮，再点击“债权详情”链接，窗口是否打开<br/>");
		Reporter.log("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常<br/>");
		Reporter.log("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息<br/>");
		Reporter.log("4.再次点击“查看详情”按钮，标详情关闭<br/>");
		Reporter.log("5.点击关闭按钮，窗口关闭<br/>");
		System.out.println("首页：翼存宝——>1.第一条翼存宝的“债权详情”按钮是否显示；点击按钮，窗口是否打开");
		System.out.println("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常");
		System.out.println("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息");
		System.out.println("4.再次点击“查看详情”按钮，标详情关闭");
		System.out.println("5.点击关闭按钮，窗口关闭");
		
		if(loginPage.ifLogin()){//登录
			base.logout();
		}
		loginPage.homeLogin(name, pass);
		if(indexPage.isAnIinvestmentBtn()){
			indexPage.clickAnIinvestmentBtn();
			indexPage.clickInvestmentBondDetails();
			indexPage.checkECBBondDetailsDIVColumnName();
			indexPage.checkECBBondDetailsDIVColumnValue("借款标题");
			indexPage.checkECBBondDetailsDIVColumnValue("借款人姓名");
			indexPage.checkECBBondDetailsDIVColumnValue("身份证号");
			indexPage.checkECBBondDetailsDIVColumnValue("操作");
			indexPage.checkBondDetails();
		}
	}
}
