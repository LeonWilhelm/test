package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.ECunBaoPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.YCBPage;

/**
 * “翼存宝”用例-江渤洋
 */
public class ECunBao {
	
	Base base = new Base();

	YCBPage ycbPage = new YCBPage();
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	ECunBaoPage eCunBaoPage = new ECunBaoPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
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
	
	/**
	 * 用例名称：列表页
	 * 用例编号：YCB_002
	 * @author 江渤洋
	 */
	@Test (priority = 3, enabled = true)
	public void checkListPage_AT_541_5283(){
		
		Reporter.log("翼存宝：翼存宝列表页——>1.校验《翼龙贷在线居间服务协议》链接；2.校验所有“红包自动匹配返现”链接；3.校验所有“已投资记录”按钮；4.校验所有“抢投”按钮</br>");
		System.out.println("翼存宝：翼存宝列表页——>1.校验《翼龙贷在线居间服务协议》链接；2.校验所有“红包自动匹配返现”链接；3.校验所有“已投资记录”按钮；4.校验所有“抢投”按钮");
		
		//重新登录
		loginPage.reLogin(name, pass);
		//进入“翼存宝”页面
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		//校验banner上显示用户的翼存宝收益
		eCunBaoPage.checkBannerTotalData();
		eCunBaoPage.checkYCBNum();
		//校验“债权详情”按钮
		eCunBaoPage.checkBondDetails();
		//校验所有“红包自动匹配返现”链接
		eCunBaoPage.checkReturnCashTotalLink();
		//校验所有“已投资记录”按钮
		eCunBaoPage.checkRecordTotalBtn();
		//校验所有“抢投”按钮
		eCunBaoPage.checkTenderTotalBtn();
	}
	
	/**
	 * 用例名称：检查banner未登录
	 * 用例编号：YCB_003
	 * @throws InterruptedException 
	 * @author 江渤洋
	 */
	@Test (priority = 1, enabled = true)
	public void checkBannerNoLogin_AT_542(){
		
		Reporter.log("翼存宝：翼存宝列表页_未登录——>1.校验banner中是否有“立即登录”按钮；2.校验点击“立即登录”按钮，是否弹出提示信息</br>");
		System.out.println("翼存宝：翼存宝列表页_未登录——>1.校验banner中是否有“立即登录”按钮；2.校验点击“立即登录”按钮，是否弹出提示信息");
		
		if(!loginPage.isLogout()){
			base.logout();//登出
		}
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		//点击“立即登录”按钮
		eCunBaoPage.clickLoginBtn();
		//检查“登录窗口”提示登录
		eCunBaoPage.checkBannerLoginWindowTitle();
	}

	/**
	 * 用例名称：检查banner已登录
	 * 用例编号：YCB_004
	 * @author 江渤洋 2016-1-6
	 */
	@Test (priority = 4, enabled = true)
	public void checkBannerLogin_AT_543(){
		
		Reporter.log("翼存宝：翼存宝列表页_已登录——>点击“我的翼存宝”按钮——>验证跳转到“我的账户-我的贷出-翼存宝”页面</br>");
		System.out.println("翼存宝：翼存宝列表页_已登录——>点击“我的翼存宝”按钮——>验证跳转到“我的账户-我的贷出-翼存宝”页面");
//		//判断是否登录
//		if(!loginPage.ifLogin()){
//			loginPage.reLogin(name, pass);
//		}
		//进入“翼存宝”页面
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		//点击“我的翼存宝”按钮
		eCunBaoPage.clickMyECunBaoBtn();
		base.isTitle(PageTitles.woDeZhangHu);
		//验证跳转到“我的账户-我的贷出-翼存宝”页面
		myAccountPage.isGoMyAccount("翼存宝");
		base.isTitle(PageTitles.woDeZhangHu);
		//校验翼存宝“待收本金”、“待收利息”，“已赚利息”，“昨日总收息”，“待收笔数”正常显示
		ycbPage.checkECunBaoInfoName();
		//点击“每日收益明细”、“参与中”、“已结清”正常显示
		ycbPage.clickDetail();
		ycbPage.clickPartake();
		ycbPage.clickSettle();
	}
	
	/**
	 * 用例名称：检查列表页点击“抢投”按钮，未登录
	 * 用例编号：YCB_005
	 * @throws InterruptedException 
	 * @author 江渤洋
	 */
	@Test (priority = 2, enabled = true)
	public void checkListPageNoLoginTender_AT_544(){
		
		Reporter.log("翼存宝：翼存宝列表页_未登录——>点击“抢投”按钮——>检查“登录窗口”提示登录</br>");
		System.out.println("翼存宝：翼存宝列表页_未登录——>点击“抢投”按钮——>检查“登录窗口”提示登录");
		
		//进入“翼存宝”页面
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		//点击“抢投”按钮，并检查“登录窗口”提示登录
		eCunBaoPage.checkTenderTotalBtnNoLogin();
	}
	
	/**
	 * 用例名称：检查列表页点击“抢投”按钮，已登录
	 * 用例编号：YCB_006
	 * @author 江渤洋
	 */
	@Test (priority = 5, enabled = true)
	public void checkListPageLoginTender_AT_545(){
		
		Reporter.log("翼存宝：翼存宝列表页_已登录——>点击“抢投”按钮——>校验是否投资成功</br>");
		System.out.println("翼存宝：翼存宝列表页_已登录——>点击“抢投”按钮——>校验是否投资成功");
		
		String money = "100";
		
		if(!money.equals("100")){
			System.out.println("输入金额不是100元，禁止抢投！");
			Reporter.log("输入金额不是100元，禁止抢投！");
			base.assertTrueByBoolean(false);
		}
		//判断是否登录
		boolean isLogin = loginPage.ifLogin();
		if(!isLogin){
			loginPage.reLogin(name, pass);
		}
		
		eCunBaoPage.qiangTou(money);
	}
	
	@Test (priority = 6, enabled = true)
	public void checkBondDetailsInfo_5284(){

		Reporter.log("翼存宝：翼存宝列表页，1.校验债权详情按钮，获取前第一页的数据；2.校验《翼龙贷在线居间服务协议》校验窗口及Title，获取全部附件一的数据；3.校验两个数据是否一致</br>");
		System.out.println("翼存宝：翼存宝列表页，1.校验债权详情按钮，获取前第一页的数据；2.校验《翼龙贷在线居间服务协议》校验窗口及Title，获取全部附件一的数据；3.校验两个数据是否一致");
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		
		//点击第一条翼存宝的债权详情按钮，获取前第一页的数据
		//点击第一条翼存宝的协议，校验窗口及Title，获取全部附件一的数据
		//校验两个List
		eCunBaoPage.checkBondDetailsAndServiceAgreement(eCunBaoPage.getBondDetailsInfo(), eCunBaoPage.checkServiceAgreementAndReturnAccessoriesOne());
	}
	
	@Test (priority = 6, enabled = true)
	public void checkBondDetailsInfo_5269(){
		
		Reporter.log("翼存宝列表页：点击“债权详情”按钮——>点击“查看详情”按钮，窗口是否打开<br/>");
		Reporter.log("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常<br/>");
		Reporter.log("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息<br/>");
		Reporter.log("4.再次点击“查看详情”按钮，标详情关闭<br/>");
		Reporter.log("5.点击关闭按钮，窗口关闭<br/>");
		System.out.println("首页：翼存宝——>1.第一条翼存宝的“债权详情”按钮是否显示；点击按钮，窗口是否打开");
		System.out.println("2.标题显示是否正常；以及姓名列，身份证列，借款标题列，操作列显示是否正常");
		System.out.println("3.点击“查看详情”按钮，只显示详情标，并显示详情标的4个Tab，及相应信息");
		System.out.println("4.再次点击“查看详情”按钮，标详情关闭");
		System.out.println("5.点击关闭按钮，窗口关闭");
		
		base.openBrowser(base.indexURL + "/new/loadAllWmpsRecords.action");
		base.isTitle(PageTitles.yiCunBao);
		
		eCunBaoPage.checkBondDetails();
	}
}
