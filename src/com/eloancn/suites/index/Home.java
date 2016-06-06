package com.eloancn.suites.index;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.JoinInPage;
import com.eloancn.shared.pages.LoginPage;

/**
 * 首页页面跳转用例
 * @author 江渤洋
 */
public class Home {
	
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	LoginPage loginPage = new LoginPage();
	JoinInPage joinInPage = new JoinInPage();
	
	String name,pass,payPass;
	String banners[] = null;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		if(base.indexURL.contains("/client") || base.indexURL.contains("inclient")){
			name = Data.tel_run_EcunBao;
    		pass = Data.password;
			payPass = Data.zzmm;
			banners = Data.banners_client;
		}
		else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
			name = Data.test2_tel;
    		pass = Data.test2_password;
			payPass = Data.test2_zzmm;
			banners = Data.banners_test;
		}
	}
	
	@BeforeMethod
	public void Method(){
		base.openBrowser(base.indexURL);
		base.isTitle(PageTitles.shouYe);
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * 用例名称：页面导航栏_"我要贷出"跳转各链接页面是否正确
	 * @author 江渤洋
	 */
	@Test (priority = 1, enabled = true)
	public void checkNavigationCreditLink_AT_585(){
		
		Reporter.log("首页：页面导航栏_'我要贷出'——>校验跳转各链接页面是否正确<br/>");
		System.out.println("\n页面导航栏_'我要贷出'跳转各链接页面是否正确，共6个Title---------------------\n");
		int step = 0;
		indexPage.clickMenu("翼存宝");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.yiCunBao));
			Reporter.log("导航栏，我要贷出-翼存宝跳转：校验成功");
			System.out.println("导航栏，我要贷出-翼存宝跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，我要贷出-翼存宝跳转：校验失败");
			System.out.println("导航栏，我要贷出-翼存宝跳转：校验失败");
		}
		indexPage.clickMenu("翼星计划");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.yiXingJiHua));
			Reporter.log("导航栏，我要贷出-翼星计划跳转：校验成功");
			System.out.println("导航栏，我要贷出-翼星计划跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，我要贷出-翼星计划跳转：校验失败");
			System.out.println("导航栏，我要贷出-翼星计划跳转：校验失败");
		}
		/*indexPage.clickMenu("散标列表");//散标下架 2016-3-22
		try {
			Assert.assertTrue(base.isTitle(PageTitles.touZiLieBiao));
			Reporter.log("导航栏，我要贷出-散标列表跳转：校验成功");
			System.out.println("导航栏，我要贷出-散标列表跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，我要贷出-散标列表跳转：校验失败");
			System.out.println("导航栏，我要贷出-散标列表跳转：校验失败");
		}*/
		indexPage.clickMenu("如何贷出");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.ruHeDaiChu));
			Reporter.log("导航栏，我要贷出-如何贷出跳转：校验成功");
			System.out.println("导航栏，我要贷出-如何贷出跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，我要贷出-如何贷出跳转：校验失败");
			System.out.println("导航栏，我要贷出-如何贷出跳转：校验失败");
		}
		indexPage.clickMenu("工具箱");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.gongJuXiang));
			Reporter.log("导航栏，我要贷出-工具箱跳转：校验成功");
			System.out.println("导航栏，我要贷出-工具箱跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，我要贷出-工具箱跳转：校验失败");
			System.out.println("导航栏，我要贷出-工具箱跳转：校验失败");
		}
		indexPage.clickMenu("我要贷出");
		try {
			if(base.isAlertPresent(5)){
				base.acceptAlert();
			}
			Assert.assertTrue(base.isTitle(PageTitles.woYaoDaiChu));
			Reporter.log("导航栏，我要贷出跳转：校验成功");
			System.out.println("导航栏，我要贷出跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			e.printStackTrace();
			Reporter.log("导航栏，我要贷出跳转：校验失败");
			System.out.println("导航栏，我要贷出跳转：校验失败");
		}
		Assert.assertEquals(step, 5);
	}
	
	/**
	 * 用例名称：页面导航栏_"新手专区"跳转各链接页面是否正确
	 * @author 江渤洋
	 * 备注：新手专区下架 2016-3-22
	 */
	@Test (priority = 2, enabled = false)
	public void checkNavigationNoviceAreaLink_AT_585(){
		
		Reporter.log("首页：页面导航栏_'新手专区'——>校验跳转各链接页面是否正确<br/>");
		System.out.println("\n页面导航栏_'新手专区'跳转各链接页面是否正确，共1个Title---------------------\n");
		indexPage.clickMenu("新手专区");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.xinShouZhuanQu));
			Reporter.log("导航栏，新手专区跳转：校验成功");
			System.out.println("导航栏，新手专区跳转：校验成功");
		} catch (AssertionError e) {
			Reporter.log("导航栏，新手专区跳转：校验失败");
			System.out.println("导航栏，新手专区跳转：校验失败");
		}
	}
	
	/**
	 * 用例名称：页面导航栏_"债权转让"跳转各链接页面是否正确
	 * @author 江渤洋
	 */
	@Test (priority = 3, enabled = true)
	public void checkNavigationDebentureTransferLink_AT_585(){
		
		Reporter.log("首页：页面导航栏_'债权转让'——>校验跳转各链接页面是否正确<br/>");
		System.out.println("\n页面导航栏_'债权转让'跳转各链接页面是否正确，共3个Title---------------------\n");
		int step = 0;
		indexPage.clickMenu("转让列表");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.zhuanRangLieBiao));
			Reporter.log("导航栏，债权转让-转让列表跳转：校验成功");
			System.out.println("导航栏，债权转让-转让列表跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，债权转让-转让列表跳转：校验失败");
			System.out.println("导航栏，债权转让-转让列表跳转：校验失败");
		}
		indexPage.clickMenu("如何转让");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.ruheZhuanRang));
			Reporter.log("导航栏，债权转让-如何转让跳转：校验成功");
			System.out.println("导航栏，债权转让-如何转让跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，债权转让-如何转让跳转：校验失败");
			System.out.println("导航栏，债权转让-如何转让跳转：校验失败");
		}
		indexPage.clickMenu("债权转让");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.zhaiQuanZhuanRang));
			Reporter.log("导航栏，债权转让跳转：校验成功");
			System.out.println("导航栏，债权转让跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，债权转让跳转：校验失败");
			System.out.println("导航栏，债权转让跳转：校验失败");
		}
		Assert.assertEquals(step, 3);
	}
	
	/**
	 * 用例名称：页面导航栏_"我要借入"跳转各链接页面是否正确
	 * @author 江渤洋
	 */
	@Test (priority = 8, enabled = true)
	public void checkNavigationDebitLink_AT_585(){
		
		Reporter.log("首页：页面导航栏_'我要借入'——>校验跳转各链接页面是否正确<br/>");
		System.out.println("\n页面导航栏_'我要借入'跳转各链接页面是否正确，共4个Title---------------------\n");
		int step = 0;
		loginPage.reLogin(name, pass);
		indexPage.clickMenu("申请借入");
		try {
			base.checkContainsTitle(PageTitles.woDeZhangHu,10);
			Reporter.log("导航栏，我要借入-申请借入跳转：校验成功");
			System.out.println("导航栏，我要借入-申请借入跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，我要借入-申请借入跳转：校验失败");
			System.out.println("导航栏，我要借入-申请借入跳转：校验失败");
		}
		indexPage.clickMenu("如何借入");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.ruHeJieRu));
			Reporter.log("导航栏，我要借入-如何借入跳转：校验成功");
			System.out.println("导航栏，我要借入-如何借入跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，我要借入-如何借入跳转：校验失败");
			System.out.println("导航栏，我要借入-如何借入跳转：校验失败");
		}
		indexPage.clickMenu("公益贷");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.gongYiDai));
			Reporter.log("导航栏，我要借入-公益贷跳转：校验成功");
			System.out.println("导航栏，我要借入-公益贷跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，我要借入-公益贷跳转：校验失败");
			System.out.println("导航栏，我要借入-公益贷跳转：校验失败");
		}
		indexPage.clickMenu("我要借入");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.woYaoJieRu));
			Reporter.log("导航栏，我要借入跳转：校验成功");
			System.out.println("导航栏，我要借入跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，我要借入跳转：校验失败");
			System.out.println("导航栏，我要借入跳转：校验失败");
		}
		Assert.assertEquals(step, 4);
	}

	/**
	 * 用例名称：页面导航栏_"关于我们"跳转各链接页面是否正确
	 * @author 江渤洋
	 */
	@Test (priority = 9, enabled = true)//(priority = 5)
	public void checkNavigationAboutUsLink_AT_585(){
		
		Reporter.log("首页：页面导航栏_'关于我们'——>校验跳转各链接页面是否正确<br/>");
		System.out.println("\n页面导航栏_'关于我们'跳转各链接页面是否正确---------------------\n");
		int step = 0;
		indexPage.clickMenu("公司介绍");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.gongSiJieShao));
			base.isElementPresence(By.xpath("//span[text()='公司简介']"));
			Reporter.log("导航栏，关于我们-公司介绍跳转：校验成功");
			System.out.println("导航栏，关于我们-公司介绍跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，关于我们-公司介绍跳转：校验失败");
			System.out.println("导航栏，关于我们-公司介绍跳转：校验失败");
		}
		indexPage.clickMenu("领导介绍");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.guanYuWoMen));
			base.isElementPresence(By.xpath("//span[text()='领导简介']"));
			Reporter.log("导航栏，关于我们-领导介绍跳转：校验成功");
			System.out.println("导航栏，关于我们-领导介绍跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，关于我们-领导介绍跳转：校验失败");
			System.out.println("导航栏，关于我们-领导介绍跳转：校验失败");
		}
		indexPage.clickMenu("公司理念");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.gongSiLiNian));
			base.isElementPresence(By.xpath("//span[text()='公司口号']"));
			Reporter.log("导航栏，关于我们-公司理念跳转：校验成功");
			System.out.println("导航栏，关于我们-公司理念跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，关于我们-公司理念跳转：校验失败");
			System.out.println("导航栏，关于我们-公司理念跳转：校验失败");
		}
		indexPage.clickMenu("招贤纳士");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.zhaoXianNaShi));
			base.isElementPresence(By.xpath("//span[text()='招贤纳士']"));
			Reporter.log("导航栏，关于我们-招贤纳士跳转：校验成功");
			System.out.println("导航栏，关于我们-招贤纳士跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，关于我们-招贤纳士跳转：校验失败");
			System.out.println("导航栏，关于我们-招贤纳士跳转：校验失败");
		}
		indexPage.clickMenu("联系我们");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.lianXiWoMen));
			base.isElementPresence(By.xpath("//span[text()='联系我们']"));
			Reporter.log("导航栏，关于我们-联系我们跳转：校验成功");
			System.out.println("导航栏，关于我们-联系我们跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，关于我们-联系我们跳转：校验失败");
			System.out.println("导航栏，关于我们-联系我们跳转：校验失败");
		}
		indexPage.clickMenu("关于我们");
		try {
			Assert.assertTrue(base.isTitle(PageTitles.guanYuWoMen));
			base.isElementPresence(By.xpath("//span[text()='公司简介']"));
			Reporter.log("导航栏，关于我们跳转：校验成功");
			System.out.println("导航栏，关于我们跳转：校验成功");
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("导航栏，关于我们跳转：校验失败");
			System.out.println("导航栏，关于我们跳转：校验失败");
		}
		Assert.assertEquals(step, 6);
	}

	/**
	 * 用例名称：页面导航栏_"我的账户"跳转各链接页面是否正确
	 * @author 江渤洋
	 */
	@Test (priority = 6)
	//检出"我的账户"部分的链接跳转(需要登录)
	public void checkNavigationMyAccountLink_AT_585(){
		
		Reporter.log("首页：页面导航栏_'我的账户'——>校验跳转各链接页面是否正确<br/>");
		System.out.println("\n页面导航栏_'我的账户'跳转各链接页面是否正确，共1个Title---------------------\n");
		//重新登录
		loginPage.reLogin(name, pass);
		//点击“我的账户”链接
		indexPage.clickMenu("我的账户");
		try {
			base.isTitle(PageTitles.woDeZhangHu);
			Reporter.log("导航栏，我的账户跳转：校验成功");
			System.out.println("导航栏，我的账户跳转：校验成功");
		} catch (AssertionError e) {
			Reporter.log("导航栏，我的账户跳转：校验失败");
			System.out.println("导航栏，我的账户跳转：校验失败");
		}
	}
	
	/************Banner*************/
	
	/**
	 * 用例名称：Banner_跳转各链接页面是否正确
	 * @author 江渤洋
	 * 徐天元修改
	 */
	@Test (priority = 10, enabled = true)
	public void checkBannerLink_AT_586(){
		
		Reporter.log("首页：Banner大图——>校验跳转各链接页面是否正确<br/>");
		System.out.println("\n首页：Banner大图——>校验跳转各链接页面是否正确\n");
		indexPage.isBannerOK(banners);
	}

	/************普惠金融*************/
	
	/**
	 * 用例名称：普惠金融_跳转各链接页面是否正确
	 * @author 江渤洋
	 */
	@Test (priority = 5, enabled = true)
	public void checkProjectLink_AT_586(){
		
		Reporter.log("首页：普惠金融——>校验跳转各链接页面是否正确<br/>");
		System.out.println("\n普惠金融_跳转各链接页面是否正确，共5个Title---------------------\n");
		
		indexPage.checkProjectLink("惠普金融");
		indexPage.checkProjectLink("收益可观");
		indexPage.checkProjectLink("安全保障");
		indexPage.checkProjectLink("同城模式");
		indexPage.checkProjectLink("品牌权威");
	}
	
	@Test(priority = 11, enabled = true)
	public void checkJoinInJump_AT_5256(){
		
		Reporter.log("首页： 招商合作——>1.校验顶部导航跳转是否正常；2.校验尾部导航跳转是否正常；3.校验未登录，提交加盟申请表跳转是否正常<br/>");
		System.out.println("首页：招商合作——>1.校验顶部导航跳转是否正常；2.校验尾部导航跳转是否正常；3.校验未登录，提交加盟申请表跳转是否正常");
		
		if(loginPage.ifLogin()){
			base.logout();
		}
		indexPage.clickJoinIn();
		indexPage.clickJoinInOfBottom();
		joinInPage.checkJoinInInfoJumpNoLogin();
	}
	
	//散标下架 2016-3-22
	@Test(priority = 12, enabled = false)
	public void checkBorrowJumpAndMaterialImgNum_AT_5257(){
		
		Reporter.log("首页：散标——>1.校验点击标题跳转是否正常；2.校验借款详情页，材料信息，图片个数是否正常<br/>");
		System.out.println("首页：散标——>1.校验点击标题跳转是否正常；2.校验借款详情页，材料信息，图片个数是否正常");
		
		if(loginPage.ifLogin()){
			base.logout();
		}
		loginPage.homeLogin(name, pass);
		indexPage.checkSBTitleJumpAndMaterialImgNum("标题", "材料信息");
	}
	
	//散标下架 2016-3-22
	@Test(priority = 13, enabled = false)
	public void checkMoreLinkJump_AT_5255(){
		
		Reporter.log("首页：散标——>1.校验点击查看更多散标项目链接跳转是否正常<br/>");
		System.out.println("首页：散标——>1.校验点击查看更多散标项目链接跳转是否正常");
		
		indexPage.checkMoreLinkStyle("散标", "center");
		indexPage.clickMoreLink("散标投资");
	}
	
	@Test(priority = 14, enabled = true)
	public void checkMoreLinkJump_AT_5272(){
		
		Reporter.log("首页：翼星计划——>1.校验点击查看更多项目链接跳转是否正常<br/>");//描述有问题
		System.out.println("首页：翼星计划——>1.校验点击标题跳转是否正常；2.校验借款详情页，材料信息，图片个数是否正常");
		
		indexPage.checkMoreLinkStyle("翼星计划", "center");
		indexPage.clickMoreLink("翼星计划");
	}
	
}
