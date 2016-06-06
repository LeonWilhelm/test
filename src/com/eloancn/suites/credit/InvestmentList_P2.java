package com.eloancn.suites.credit;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
import com.eloancn.shared.pages.DebentureTransferPage;
import com.eloancn.shared.pages.IndexPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
/**
 * 投资列表 P2
 * @author 徐天元
 */
public class InvestmentList_P2 {
	LoginPage loginPage = new LoginPage();
	Base base = new Base();
	InvestmentListPage investmentListPage = new InvestmentListPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	IndexPage indexPage = new IndexPage();
	DebentureTransferPage debentureTransferPage = new DebentureTransferPage();
	
//	String tel = Data.tel_investmentList_P2;
//	String password = Data.password;
//	String zzmm = Data.zzmm;//支付密码
	String tel=Data.tel_Invest;
	String password=Data.password;
	String paypassword=Data.zzmm;
	String tel_noRecharge = Data.run_ECunBao_register;				//集成或本地未充值
	String test_tel_noRecharge = Data.test_run_ECunBao_register;	//test未充值
	String tel_49yuan = Data.tel_balance_49;			
	String tel_50yuan=Data.tel_balance_50;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
		base.openBrowser(investmentListPage.Url);
//		if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
//			tel = Data.test_tel;
//			paypassword = Data.test_zzmm;
//		}
	}
	
	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	/**
	 * 投资列表-分页，点击末页、前一页、首页、后一页、第五页，测试翻页功能
	 */
	@Test(priority=1)
	public void turnPage_web_1064(){
		Reporter.log("散标投资P2：投资列表-分页，点击末页、前一页、首页、后一页、第五页，测试翻页功能<br/>");
		int step = 0;
		try {
			if (investmentListPage.ifShowPageBtn("末页")) {
				investmentListPage.clickPage("末页");
				investmentListPage.isTurnPageOK("末页");
				Reporter.log("末页:校验成功");
			}else {
				Reporter.log("末页:不可点击");
			}
			step += 1;
			System.out.println("末页:校验成功");
		} catch (AssertionError e) {
			Reporter.log("末页:校验失败");
		}
		try {
			if (investmentListPage.ifShowPageBtn("前一页")) {
				investmentListPage.clickPage("前一页");
				investmentListPage.isTurnPageOK("前一页");
				Reporter.log("前一页:校验成功");
			}else {
				Reporter.log("前一页:不可点击");
			}
			step += 1;
			System.out.println("前一页:校验成功");
		} catch (AssertionError e) {
			Reporter.log("前一页:校验失败");
		}
		try {
			if (investmentListPage.ifShowPageBtn("首页")) {
				investmentListPage.clickPage("首页");
				investmentListPage.isTurnPageOK("首页");
				Reporter.log("首页:校验成功");
			}else {
				Reporter.log("首页:不可点击");
			}
			step += 1;
			System.out.println("首页:校验成功");
		} catch (AssertionError e) {
			Reporter.log("首页:校验失败");
		}
		try {
			if (investmentListPage.ifShowPageBtn("后一页")) {
				investmentListPage.clickPage("后一页");
				investmentListPage.isTurnPageOK("后一页");
				Reporter.log("后一页:校验成功");
			}else {
				Reporter.log("后一页:不可点击");
			}
			step += 1;
			System.out.println("后一页:校验成功");
		} catch (AssertionError e) {
			Reporter.log("后一页:校验失败");
		}
		try {
			if (investmentListPage.ifShowPageBtn("5")) {
				investmentListPage.clickPage("5");
				investmentListPage.isTurnPageOK("5");
				Reporter.log("第五页:校验成功");
			}else {
				Reporter.log("没有第五页");
			}
			step += 1;
			System.out.println("第五页:校验成功");
		} catch (AssertionError e) {
			Reporter.log("第五页:校验失败");
		}
		if (step==5) {
			base.assertTrueByBoolean(true);
		}else {
			base.assertEqualsActualExpectedByBoolean(true, false);
		}
	}

	/**
	 * 1-1、利率高低右边显示小三角形（利率从小到大）
	 * 1-2、借款期限右边显示小三角形（期限从小到大）
	 * 1-3、完成进度右边显示小三角形（完成进度从小大大）
	 */
	@Test(priority=2)
	public void sort_web_498_1(){
		Reporter.log("散标投资P2：投资列表-排序方式，利率高低、借款期限、完成进度显示向上的三角符号<br/>");
		//利率高低、借款期限、完成进度显示向上的三角符号
		investmentListPage.isSanJiaoOK("all");
		Reporter.log("利率高低、借款期限、完成进度显示向上的三角符号：校验成功");
	}
	
	/**
	 * 2-1、利率高低右边的小三角形变成倒三角形
	 * 2-2、投资列表标利率按从大到小的顺序显示
	 */
	@Test(priority=3)
	public void sort_web_498_2(){
		Reporter.log("散标投资P2：投资列表-排序方式，利率高低右边的小三角形变成倒三角形,利率按从大到小的顺序显示<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">散标投资列表按利率排序一直有问题!</font><br/>");
		//点击利率高低
		investmentListPage.clickSort("利率高低");
		//利率高低、借款期限、完成进度显示向下的三角符号
		investmentListPage.isSanJiaoOK("利率高低");
		Reporter.log("点击利率高低，显示向下的三角符号：校验成功");
		investmentListPage.isSortOK("利率高低");
		Reporter.log("点击利率高低，从大到小排列：校验成功");
	}
	
	/**
	 * 3-1、借款期限右边的小三角形变成倒三角形
	 * 3-2、投资列表标借款期限从大到小顺序显示
	 */
	@Test(priority=4)
	public void sort_web_498_3(){
		Reporter.log("散标投资P2：投资列表-排序方式，借款期限右边的小三角形变成倒三角形,借款期限按从大到小的顺序显示<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">散标投资列表按借款期限排序一直有问题!</font><br/>");
		//点击借款期限
		investmentListPage.clickSort("借款期限");
		//借款期限显示向下的三角符号
		investmentListPage.isSanJiaoOK("借款期限");
		Reporter.log("点击借款期限后，显示向下的三角符号：校验成功");
		investmentListPage.isSortOK("借款期限");
		Reporter.log("点击借款期限后，从大到小排列：校验成功");
	}
	
	/**
	 * 4-1、完成进度右边的小三角形变成倒三角形
	 * 4-2、投资列表标完成进度从大到小显示
	 */
	@Test(priority=5)
	public void sort_web_498_4(){
		Reporter.log("散标投资P2：投资列表-排序方式，完成进度右边的小三角形变成倒三角形,完成进度按从大到小的顺序显示<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">散标投资列表按完成进度排序一直有问题!</font>");
		//点击完成进度
		investmentListPage.clickSort("完成进度");
		//完成进度显示向下的三角符号
		investmentListPage.isSanJiaoOK("完成进度");
		Reporter.log("点击完成进度后，显示向下的三角符号：校验成功");
		investmentListPage.isSortOK("完成进度");
		Reporter.log("点击完成进度后，从大到小排列：校验成功");
	}
	
	/**
	 * 检查默认 显示为：所有地区（右边有倒三角符号）
	 */
	@Test(priority=6)
	public void showAllPlaces_web_502_1(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，检查默认 显示为：所有地区（右边有倒三角符号）<br/>");
		investmentListPage.isPlaces("所有地区");
	}
	
	/**
	 * 鼠标指向或者点击所有地区（或倒三角形）下拉出地区选择详情框
	 */
	@Test(priority=7)
	public void showAllPlacesDiv_web_502_2(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，鼠标指向或者点击所有地区（或倒三角形）下拉出地区选择详情框<br/>");
		//点击所有地区
		investmentListPage.clickPlaces();
		//校验展开所有地区层
		investmentListPage.isOpenAllPlacesDiv();
	}
	
	/**
	 * 输入任意字母（或文字）下拉列表中检索出以该字母开头的省份或城市
	 */
	@Test(priority=8)
	public void showFirstCharPlaces_web_502_4(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，输入任意字母（或文字）下拉列表中检索出以该字母开头的省份或城市<br/>");
		//点击所有地区
		investmentListPage.clickPlaces();
		//地区输入 s
		investmentListPage.inputPlace("s");
		//校验下拉列表中是否检索出以该字母开头的省份或城市
		investmentListPage.isFirstChar("s");
	}
	
	/**
	 *散标投资P2：投资列表-地区选择功能，点击公益贷，输入为空时,下拉列表中显示默认的城市
	 */
	@Test(priority=9)
	public void showDefaultPlaces_web_502_5(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，点击公益贷，输入为空时,下拉列表中显示默认的城市<br/>");
		//点击所有地区
		investmentListPage.clickPlaces();
		//地区输入为空
		investmentListPage.inputPlace("");
		//输入为空，下拉列表中是否显示默认地区
		investmentListPage.isDefaultValue();
	}
	
	/**
	 * 在文本框中输入存在的城市或者省份,点击“搜索”按钮,投资类表中只显示该地区的借款标,地区选择列表收起（只显示选择地区的名称）
	 */
	@Test(priority = 10)
	public void searchPlace_web_502_6(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，在文本框中输入存在的城市或者省份,点击“搜索”按钮,投资类表中只显示该地区的借款标,地区选择列表收起（只显示选择地区的名称）<br/>");
		//点击所有地区
		investmentListPage.clickPlaces();
		//地区输入北京
		investmentListPage.inputAndSelectPlace("深圳");
		//点击“搜索”
		investmentListPage.clickSearch();
		//地区选择列表收起
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("地区选择列表收起:校验成功");
		//只显示选择地区的名称
		investmentListPage.isPlaces("深圳");
		Reporter.log("只显示选择地区的名称:校验成功");
		//校验搜索结果是否属于搜索地区
		investmentListPage.isSearchOK("深圳");
		Reporter.log("投资类表中只显示该地区的借款标:校验成功");
	}
	
	/**
	 * 投资列表-地区选择功能，搜索文本框下方的热门城市中点击任意城市,投资类表中只显示该地区的借款标,地区选择列表收起（只显示选择地区的名称）
	 */
	@Test(priority = 11)
	public void searchPlace_web_502_7(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，搜索文本框下方的热门城市中点击任意城市,投资类表中只显示该地区的借款标,地区选择列表收起（只显示选择地区的名称）<br/>");
		//点击地区
		investmentListPage.clickPlaces();
		//搜索文本框下方的热门城市中点击一个城市
		String city = investmentListPage.clickHotCity();
		System.out.println("您所选的热门城市是："+city);
		base.sleep(2000);
		//点击“搜索”
		base.sleep(3000);
		//地区选择列表收起
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("地区选择列表收起:校验成功<br/>");
		//只显示选择地区的名称
		investmentListPage.isPlaces(city);
		Reporter.log("只显示选择地区的名称:校验成功<br/>");
		//校验搜索结果是否属于搜索地区
		investmentListPage.isSearchOK(city);
		Reporter.log("投资类表中只显示该地区的借款标:校验成功<br/>");
	}
	
	/**
	 * 在热门城市下方的请选择任意省,显示该省分的城市（提示选择城市）；选择城市，投资列表只显示选中城市的借款标，地区选择列表收起（只显示选择地区名称）
	 */
	@Test(priority = 12)
	public void searchPlace_web_502_8and9(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，在热门城市下方的“请选择”选择任意省,显示该省分的城市（提示选择城市）；选择城市，投资列表只显示选中城市的借款标，地区选择列表收起（只显示选择地区名称）<br/>");
		//点击地区
		investmentListPage.clickPlaces();
		//搜索文本框下方的“请选择”中点击一个省份
		String province = investmentListPage.clickProvince();
		System.out.println("您所选的省份是："+province);
		//校验在热门城市下方的请选择任意省,显示该省分的城市（提示选择城市）
		investmentListPage.isShowProvinceCitys();
		Reporter.log("热门城市下方的请选择任意省,显示该省分的城市（提示选择城市）:校验成功<br/>");
		//选择城市
		String city =investmentListPage.selectCity();
		Reporter.log("您所选的城市是："+ city);
		//地区选择列表收起
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("地区选择列表收起:校验成功<br/>");
		//只显示选择地区的名称
		investmentListPage.isPlaces(city);
		Reporter.log("只显示选择地区的名称:校验成功<br/>");
		//校验搜索结果是否属于搜索地区
		investmentListPage.isSearchOK(city);
		Reporter.log("投资类表中只显示该地区的借款标:校验成功<br/>");
	}
	
	/*************************公益贷************************/
	
	/**
	 * 点击公益贷,投资列表显示公益贷标
	 */
	@Test(priority = 13)
	public void gongYiDai_web_503(){
		Reporter.log("散标投资P2：投资列表-公益贷，点击公益贷,投资列表显示公益贷标<br/>");
		base.openBrowser(base.indexURL+"/new/loadAllTender.action");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		//校验显示公益贷标
		investmentListPage.isGongyiDai();
		Reporter.log("点击公益贷，显示公益贷标：校验成功<br/>");
	}
	
	/**
	 * 投资列表-分页，点击末页、前一页、首页、后一页、第五页，测试翻页功能
	 */
	@Test(priority=14)
	public void gongYiDai_turnPage_web_503_3(){
		Reporter.log("散标投资P2：投资列表-公益贷分页，点击末页、前一页、首页、后一页、第五页，测试翻页功能<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		int step = 0;
		try {
			if (investmentListPage.ifShowPageBtn("末页")) {
				//校验显示公益贷标
				investmentListPage.isGongyiDai();
				investmentListPage.clickPage("末页");
				investmentListPage.isTurnPageOK("末页");
				Reporter.log("末页:校验成功");
			}else {
				Reporter.log("末页:不可点击");
			}
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("末页:校验失败");
		}
		try {
			if (investmentListPage.ifShowPageBtn("前一页")) {
				//校验显示公益贷标
				investmentListPage.isGongyiDai();
				investmentListPage.clickPage("前一页");
				investmentListPage.isTurnPageOK("前一页");
				Reporter.log("前一页:校验成功");
			}else {
				Reporter.log("前一页:不可点击");
			}
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("前一页:校验失败");
		}
		try {
			if (investmentListPage.ifShowPageBtn("首页")) {
				//校验显示公益贷标
				investmentListPage.isGongyiDai();
				investmentListPage.clickPage("首页");
				investmentListPage.isTurnPageOK("首页");
				Reporter.log("首页:校验成功");
			}else {
				Reporter.log("首页:不可点击");
			}
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("首页:校验失败");
		}
		try {
			if (investmentListPage.ifShowPageBtn("后一页")) {
				//校验显示公益贷标
				investmentListPage.isGongyiDai();
				investmentListPage.clickPage("后一页");
				investmentListPage.isTurnPageOK("后一页");
				Reporter.log("后一页:校验成功");
			}else {
				Reporter.log("后一页:不可点击");
			}
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("后一页:校验失败");
		}
		try {
			if (investmentListPage.ifShowPageBtn("5")) {
				//校验显示公益贷标
				investmentListPage.isGongyiDai();
				investmentListPage.clickPage("5");
				investmentListPage.isTurnPageOK("5");
				Reporter.log("第五页:校验成功");
			}else {
				Reporter.log("没有第五页");
			}
			step += 1;
		} catch (AssertionError e) {
			Reporter.log("第五页:校验失败");
		}
		if (step==5) {
			base.assertTrueByBoolean(true);
		}else {
			base.assertEqualsActualExpectedByBoolean(true, false);
		}
	}

	/**
	 * 公益贷
	 * 1-1、利率高低右边显示小三角形（利率从小到大）
	 * 1-2、借款期限右边显示小三角形（期限从小到大）
	 * 1-3、完成进度右边显示小三角形（完成进度从小大大）
	 */
	@Test(priority=15)
	public void gongYiDai_sort_web_503_2_1(){
		Reporter.log("散标投资P2：投资列表-公益贷排序方式，利率高低、借款期限、完成进度显示向上的三角符号<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		//利率高低、借款期限、完成进度显示向上的三角符号
		investmentListPage.isSanJiaoOK("all");
		Reporter.log("利率高低、借款期限、完成进度显示向上的三角符号：校验成功<br/>");
	}
	
	/**
	 * 公益贷
	 * 2-1、利率高低右边的小三角形变成倒三角形
	 * 2-2、投资列表标利率按从大到小的顺序显示
	 */
	@Test(priority=16)
	public void gongYiDai_sort_web_503_2_2(){
		Reporter.log("散标投资P2：投资列表-公益贷排序方式，利率高低右边的小三角形变成倒三角形,利率按从大到小的顺序显示<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		//点击利率高低
		investmentListPage.clickSort("利率高低");
		//利率高低、借款期限、完成进度显示向下的三角符号
		investmentListPage.isSanJiaoOK("利率高低");
		Reporter.log("点击利率高低，显示向下的三角符号：校验成功<br/>");
		investmentListPage.isSortOK("利率高低");
		//校验显示公益贷标
		investmentListPage.isGongyiDai();
		Reporter.log("点击利率高低，从大到小排列：校验成功<br/>");
	}
	
	/**
	 * 公益贷
	 * 3-1、借款期限右边的小三角形变成倒三角形
	 * 3-2、投资列表标借款期限从大到小顺序显示
	 */
	@Test(priority=17)
	public void gongYiDai_sort_web_503_2_3(){
		Reporter.log("散标投资P2：投资列表-公益贷排序方式，借款期限右边的小三角形变成倒三角形,借款期限按从大到小的顺序显示<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		//点击借款期限
		investmentListPage.clickSort("借款期限");
		//借款期限显示向下的三角符号
		investmentListPage.isSanJiaoOK("借款期限");
		Reporter.log("点击借款期限后，显示向下的三角符号：校验成功<br/>");
		investmentListPage.isSortOK("借款期限");
		//校验显示公益贷标
		investmentListPage.isGongyiDai();
		Reporter.log("点击借款期限后，从大到小排列：校验成功<br/>");
	}
	
	/**
	 * 4-1、完成进度右边的小三角形变成倒三角形
	 * 4-2、投资列表标完成进度从大到小显示
	 */
	@Test(priority=18)
	public void gongYiDai_sort_web_503_2_4(){
		Reporter.log("散标投资P2：投资列表-公益贷排序方式，完成进度右边的小三角形变成倒三角形,完成进度按从大到小的顺序显示<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		//点击完成进度
		investmentListPage.clickSort("完成进度");
		//完成进度显示向下的三角符号
		investmentListPage.isSanJiaoOK("完成进度");
		Reporter.log("点击完成进度后，显示向下的三角符号：校验成功<br/>");
		investmentListPage.isSortOK("完成进度");
		//校验显示公益贷标
		investmentListPage.isGongyiDai();
		Reporter.log("点击完成进度后，从大到小排列：校验成功<br/>");
	}
	
	/**
	 * 公益贷
	 * 检查默认 显示为：所有地区（右边有倒三角符号）
	 */
	@Test(priority=19)
	public void gongYiDai_showAllPlaces_web_503_4_1(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，点击公益贷，检查默认 显示为：所有地区（右边有倒三角符号）<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		investmentListPage.isPlaces("所有地区");
		//校验显示公益贷标
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * 点击公益贷
	 * 鼠标指向或者点击所有地区（或倒三角形）下拉出地区选择详情框
	 */
	@Test(priority=20)
	public void gongYiDai_showAllPlaces_web_503_4_2(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，点击公益贷，鼠标指向或者点击所有地区（或倒三角形）下拉出地区选择详情框<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		//点击所有地区
		investmentListPage.clickPlaces();
		//校验展开所有地区层
		investmentListPage.isOpenAllPlacesDiv();
		//校验显示公益贷标
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * 点击公益贷，输入任意字母（或文字）下拉列表中检索出以该字母开头的省份或城市
	 */
	@Test(priority=21)
	public void gongYiDai_showFirstPlace_web_503_4_4(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，点击公益贷，输入任意字母（或文字）下拉列表中检索出以该字母开头的省份或城市<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		//点击所有地区
		investmentListPage.clickPlaces();
		//地区输入 s
		investmentListPage.inputPlace("s");
		//校验下拉列表中是否检索出以该字母开头的省份或城市
		investmentListPage.isFirstChar("s");
		//校验显示公益贷标
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * 散标投资P2：投资列表-地区选择功能，点击公益贷，输入为空时,下拉列表中显示默认的城市
	 */
	@Test(priority=22)
	public void gongYiDai_showDefaultPlace_web_503_4_5(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，点击公益贷，输入为空时,下拉列表中显示默认的城市<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		//点击所有地区
		investmentListPage.clickPlaces();
		//地区输入为空
		investmentListPage.inputPlace("");
		//输入为空，下拉列表中是否显示默认地区
		investmentListPage.isDefaultValue();
		//校验显示公益贷标
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * 点击公益贷，在文本框中输入存在的城市或者省份,点击“搜索”按钮,投资类表中只显示该地区的借款标,地区选择列表收起（只显示选择地区的名称）
	 */
	@Test(priority = 23)
	public void gongYiDai_searchPlace_web_503_4_6(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，点击公益贷，在文本框中输入存在的城市或者省份,点击“搜索”按钮,投资类表中只显示该地区的借款标,地区选择列表收起（只显示选择地区的名称）<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		//点击所有地区
		investmentListPage.clickPlaces();
		//地区输入北京
		investmentListPage.inputAndSelectPlace("深圳");
		base.sleep(10000);
		//点击“搜索”
		investmentListPage.clickSearch();
		//地区选择列表收起
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("地区选择列表收起:校验成功<br/>");
		//只显示选择地区的名称
		investmentListPage.isPlaces("深圳");
		Reporter.log("只显示选择地区的名称:校验成功<br/>");
		//校验搜索结果是否属于搜索地区
		investmentListPage.isSearchOK("深圳");
		Reporter.log("投资类表中只显示该地区的借款标:校验成功<br/>");
		//校验显示公益贷标
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * 投资列表-地区选择功能，点击公益贷，搜索文本框下方的热门城市中点击任意城市,投资类表中只显示该地区的借款标,地区选择列表收起（只显示选择地区的名称）
	 */
	@Test(priority = 24)
	public void gongYiDai_searchPlace_web_503_4_7(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，点击公益贷，搜索文本框下方的热门城市中点击任意城市,投资类表中只显示该地区的借款标,地区选择列表收起（只显示选择地区的名称）<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		//点击地区
		investmentListPage.clickPlaces();
		//搜索文本框下方的热门城市中点击一个城市
		String city = investmentListPage.clickHotCity();
		System.out.println("您所选的热门城市是："+city);
		base.sleep(2000);
		//点击“搜索”
		base.sleep(3000);
		//地区选择列表收起
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("地区选择列表收起:校验成功<br/>");
		//只显示选择地区的名称
		investmentListPage.isPlaces(city);
		Reporter.log("只显示选择地区的名称:校验成功<br/>");
		//校验搜索结果是否属于搜索地区
		investmentListPage.isSearchOK(city);
		Reporter.log("投资类表中只显示该地区的借款标:校验成功<br/>");
		//校验显示公益贷标
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * 点击公益贷，在热门城市下方的请选择任意省,显示该省分的城市（提示选择城市）；选择城市，投资列表只显示选中城市的借款标，地区选择列表收起（只显示选择地区名称）
	 */
	@Test(priority = 25)
	public void gongYiDai_hot_web_503_4_8and9(){
		Reporter.log("散标投资P2：投资列表-地区选择功能，点击公益贷，在热门城市下方的请选择任意省,显示该省分的城市（提示选择城市）；选择城市，投资列表只显示选中城市的借款标，地区选择列表收起（只显示选择地区名称）<br/>");
		//点击公益贷
		investmentListPage.clickGongYiDai();
		//点击地区
		investmentListPage.clickPlaces();
		//搜索热门城市下方的“请选择”点击一个省份
		String province = investmentListPage.clickProvince();
		System.out.println("您所选的省份是："+province);
		//校验在热门城市下方的请选择任意省,显示该省分的城市（提示选择城市）
		investmentListPage.isShowProvinceCitys();
		Reporter.log("热门城市下方的请选择任意省,显示该省分的城市（提示选择城市）:校验成功<br/>");
		//选择城市
		String city =investmentListPage.selectCity();
		Reporter.log("您所选的城市是："+ city);
		//地区选择列表收起
		investmentListPage.isNotOpenAllPlacesDiv();
		Reporter.log("地区选择列表收起:校验成功<br/>");
		//只显示选择地区的名称
		investmentListPage.isPlaces(city);
		Reporter.log("只显示选择地区的名称:校验成功<br/>");
		//校验搜索结果是否属于搜索地区
		investmentListPage.isSearchOK(city);
		Reporter.log("投资类表中只显示该地区的借款标:校验成功<br/>");
		//校验显示公益贷标
		investmentListPage.isGongyiDai();
	}
	
	/**
	 * 投资列表-借款类型筛选功能,默认选中不限项,选中项背景为红色
	 */
	@Test(priority = 26)
	public void debitTypeFilter_web_525_1(){
		Reporter.log("散标投资P2：投资列表-借款类型筛选功能,默认选中不限项,选中项背景为红色<br/>");
		base.openBrowser(investmentListPage.Url);
		investmentListPage.isTypeBackgroundRed("不限");
	}
	
	/**
	 * 投资列表-借款类型筛选功能,点击信用借贷,选中项背景为红色,投资列表显示借款类型为信用借贷的标
	 */
	@Test(priority = 27)
	public void debitTypeFilter_web_525_2(){
		Reporter.log("散标投资P2：投资列表-借款类型筛选功能,点击信用借贷项,选中项背景为红色,投资列表显示借款类型为信用借贷的标<br/>");
		investmentListPage.clickType("信用借款");
		investmentListPage.isTypeBackgroundRed("信用借款");
		investmentListPage.isTypeBiao("信用借款");
	}
	
	/**
	 * 投资列表-借款类型筛选功能,点击车辆抵押,选中项背景为红色,投资列表显示借款类型为车辆抵押的标
	 */
	@Test(priority = 28)
	public void debitTypeFilter_web_525_3(){
		Reporter.log("散标投资P2：投资列表-借款类型筛选功能,点击车辆抵押,选中项背景为红色,投资列表显示借款类型为车辆抵押的标<br/>");
		investmentListPage.clickType("车辆抵押");
		investmentListPage.isTypeBackgroundRed("车辆抵押");
		investmentListPage.isTypeBiao("车辆抵押");
	}
	
	/**
	 * 投资列表-借款类型筛选功能,点击房屋抵押,选中项背景为红色,投资列表显示借款类型为房屋抵押的标
	 */
	@Test(priority = 29)
	public void debitTypeFilter_web_525_4(){
		Reporter.log("散标投资P2：投资列表-借款类型筛选功能,点击房屋抵押,选中项背景为红色,投资列表显示借款类型为房屋抵押的标<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">集成环境上“房屋抵押”的标一直有问题，有的标不显示‘房’标志！</font><br/>");
		investmentListPage.clickType("房屋抵押");
		investmentListPage.isTypeBackgroundRed("房屋抵押");
		investmentListPage.isTypeBiao("房屋抵押");
	}
	
	/**
	 * 投资列表-投标金额窗口-数据显示
	 * 检查窗口中年利率是否与标的利率一致
	 * 计算还需额度是否正确（借款总金额-已投资金额=还需金额）
	 * 检查可用余额显示是否正确（与个人账户的可用余额一致）
	 * 点击窗口右上方,关闭投标金额窗口
	 */
	@Test(priority = 30)
	public void verifyBitWindowData_web_596(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-数据显示.检查窗口中年利率是否与标的利率一致,计算还需额度是否正确（借款总金额-已投资金额=还需金额）,检查可用余额显示是否正确（与个人账户的可用余额一致）,点击窗口右上方,关闭投标金额窗口<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">如果在集成环境上报错，可能是定时任务导致的时间结束了“快速投资”还可以点击</font><br/>");
		//去我的账户查看剩余金额
		base.openBrowser(myAccountPage.MyAccountUrl);
		loginPage.loginWithNoFrame(tel, password);
		double balance = myAccountPage.getBalance();
		//校验
		base.openBrowser(investmentListPage.Url);
		investmentListPage.isDebitWindowDataIdentical(balance);
	}
	
	/**
	 * 投资列表--投资窗口部分--链接
	 * 点击充值链接  链接至充值页面
	 */
	@Test(priority = 31)
	public void verifyBitWindowLink_web_597_1(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-链接.点击充值链接  链接至充值页面<br/>");
		base.openBrowser(investmentListPage.Url);
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//点击投资窗口的充值
			investmentListPage.clickRecharge();
			//校验跳转到我的账户  充值
			base.assertTrueByBoolean(base.checkTitleContains(PageTitles.woDeZhangHu));
			myAccountPage.isGoMyAccount("充值");
		}else {
			Reporter.log("没有可投资的散标<br/>");
		}
	}
	
	/**
	 * 投资列表--投资窗口部分--链接
	 * 点击忘记密码链接  转至找回密码页面
	 */
	@Test(priority = 32)
	public void verifyBitWindowLink_web_597_2(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-链接.点击忘记密码链接  转至找回密码页面<br/>");
		base.openBrowser(investmentListPage.Url);
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//点击投资窗口的忘记密码
			investmentListPage.clickForgetPassword();
			base.sleep(1000);
			//校验跳转到找回支付密码页
			base.assertTrueByBoolean(base.checkTitleContains("找回支付密码"));
		}else {
			Reporter.log("没有可投资的散标");
		}
	}
	
	/**
	 * 投资列表--投资窗口部分--链接
	 * 点击自动投标链接  链接自动投标设置页面
	 */
	@Test(priority = 33)
	public void verifyBitWindowLink_web_597_3(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-链接.点击自动投标链接  链接自动投标设置页面<br/>");
		base.openBrowser(investmentListPage.Url);
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//点击投资窗口的自动投标
			investmentListPage.clickAutoBid();
			if(base.gethandelsNum()==2){
				base.turnToNewPage();
			}
			//校验跳转到我的账户  自动投标
			base.assertTrueByBoolean(base.checkTitleContains(PageTitles.woDeZhangHu));
			myAccountPage.isGoMyAccount("自动投标");
		}else {
			Reporter.log("没有可投资的散标");
		}
	}
	
	/**
	 * 投资列表--投资窗口部分--自动输入功能
	 * 可用金额大于50小于还需额度,输入金额文本框显示：可用金额数;可用金额大于还需额度点击自动输入,输入金额文本框显示：还需额度金额数
	 */
	@Test(priority = 34)
	public void autoInput_web_598_4and5(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-自动输入功能.可用金额大于50小于还需额度,输入金额文本框显示：可用金额数;可用金额大于还需额度点击自动输入,输入金额文本框显示：还需额度金额数<br/>");
		base.openBrowser(investmentListPage.Url);
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//校验是否所有可投资的散标自动输入是否正确
		investmentListPage.isAllAutoInputOk();
	}
	
	/**
	 * 投资列表--投资窗口部分--输入金额文本框
	 * 输入金额：为空
	 */
	@Test(priority = 35)
	public void amountInput_web_601(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-输入金额文本框.输入金额为空,提示：投标金额必须是正整数<br/>");
		Reporter.log("散标投资P2：投资列表-投标金额窗口-输入金额文本框.输入金额为fsdfgd,提示：投标金额必须是正整数<br/>");
		Reporter.log("散标投资P2：投资列表-投标金额窗口-输入金额文本框.输入金额为23,提示：投标金额至少50元！<br/>");
		Reporter.log("散标投资P2：投资列表-投标金额窗口-输入金额文本框.输入超过文本框长度,提示：账户余额不足<br/>");
		base.openBrowser(investmentListPage.Url);
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//点击确定
			investmentListPage.clickBidBtn();
			base.checkAlertText("投标金额必须是正整数");
			
			//输入金额为fsdfgd
			investmentListPage.sendKeyInputMoneyTxt("fsdfgd");
			//点击确定
			investmentListPage.clickBidBtn();
			base.checkAlertText("投标金额必须是正整数");
			
			//输入金额为23
			investmentListPage.sendKeyInputMoneyTxt("23");
			//点击确定
			investmentListPage.clickBidBtn();
			base.checkAlertText("投标金额至少50元！");
			
			//输入金额超过可用余额
			investmentListPage.sendKeyInputMoneyTxt("111111111111111111111111111111111111111111111111111111111111");
			//点击确定
			investmentListPage.clickBidBtn();
			base.checkAlertText("账户余额不足");
			//关闭投资窗口
			investmentListPage.closeBitWindow();
		}else {
			Reporter.log("没有可投资的散标");
		}
	}
	
//	/**
//	 * 投资列表--投资窗口部分--输入金额文本框
//	 * 大于还需额度金额数小于账户可用额度,提示：账户余额不足
//	 */
//	@Test(priority = 40)
//	public void amountInput_web_601_4(){
//		Reporter.log("散标投资P2：投资列表-投标金额窗口-输入金额文本框.大于还需额度金额数小于账户可用额度,提示：账户余额不足");
//		base.openBrowser(base.indexURL+"/new/loadAllTender.action");
//		//登录
//		tel = Data.tel_investmentList_P2;
//		//未登录  先登录
//		if (!loginPage.ifLogin()) {
//			indexPage.clickLoginLink();
//			loginPage.login(tel, password);
//		}
//		//是否有快速投资  有的话点击
//		
//	}
	
	/**
	 * 投资列表--投资窗口部分--支付密码文本框
	 * 支付密码：为空,提示：支付密码不能为空
	 */
	@Test(priority = 36)
	public void payPasswordInput_web_608(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-支付密码文本框.支付密码：为空,提示：支付密码不能为空<br/>");
		Reporter.log("散标投资P2：投资列表-投标金额窗口-支付密码文本框.支付密码：小于六位,提示：支付密码格式不对<br/>");
		Reporter.log("散标投资P2：投资列表-投标金额窗口-支付密码文本框.支付密码：错误的密码,验证码：为空,提示：验证码不能为空<br/>");
		Reporter.log("散标投资P2：投资列表-投标金额窗口-支付密码文本框.支付密码：输入超过16位,达到16位时输入无反应（最多只能输入16位）<br/>");
		Reporter.log("散标投资P2：投资列表-投标金额窗口-支付密码文本框.支付密码：正确的密码,验证码：正确验证码,提示：投标成功<br/>");
		//base.openBrowser(base.indexURL+"/new/loadAllTender.action");
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//输入金额为100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//点击确定
			investmentListPage.clickBidBtn();
			base.checkAlertText("支付密码不能为空！");
			
			//输入支付密码
			investmentListPage.sendKeyPayPasswordTxt("111");
			//点击确定
			investmentListPage.clickBidBtn();
			base.checkAlertText("支付密码格式不对！");
			
			//输入错误支付密码
			investmentListPage.sendKeyPayPasswordTxt("111333");
			//点击确定
			investmentListPage.clickBidBtn();
			base.checkAlertText("验证码不能为空！");
			
			//输入错误支付密码
			investmentListPage.sendKeyPayPasswordTxt("111333");
			//输入正确验证码
			investmentListPage.sendKeyVerificationCodeTxt(investmentListPage.getVerificationCode());
			//点击确定
			investmentListPage.clickBidBtn();
			//提示：支付密码错误
			investmentListPage.isWrong("支付密码错误");
			investmentListPage.clickBidSuccessCloseBtn();
		}else {
			Reporter.log("没有可投资的散标<br/>");
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//输入金额为100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//输入超过16位
			investmentListPage.sendKeyPayPasswordTxt("11111111111111111");
			//校验密码长度
			investmentListPage.isPayPasswordLenthOK();
			
			investmentListPage.fastInvest("100",paypassword);
			investmentListPage.isBitOk();
			//关闭投资窗口
			//investmentListPage.closeBitWindow();
			investmentListPage.clickBidSuccessCloseBtn();
		}else {
			Reporter.log("没有可投资的散标<br/>");
		}
	}
	
	/**
	 * 投资列表--投资窗口部分--验证码
	 * 验证码为空,提示：验证码不能为空
	 */
	@Test(priority = 37)
	public void verificationCode_web_609(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-验证码.验证码为空,提示：验证码不能为空<br/>");
		Reporter.log("散标投资P2：投资列表-投标金额窗口-验证码.验证码:错误的验证码（或者超过4为的数字）,提示：验证码输入有误，请重新输入！<br/>");
		Reporter.log("散标投资P2：投资列表-投标金额窗口-验证码.先输入正确验证码，更换验证码,提示：验证码输入有误，请重新输入！<br/>");
		Reporter.log("散标投资P2：投资列表-投标金额窗口-验证码.验证码:输入特殊字符（或者字母或汉字）,提示：验证码输入有误，请重新输入！<br/>");
		//base.openBrowser(base.indexURL+"/new/loadAllTender.action");
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//输入金额为100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//输入支付密码
			investmentListPage.sendKeyPayPasswordTxt(paypassword);
			//点击确定
			investmentListPage.clickBidBtn();
			base.checkAlertText("验证码不能为空！");
		}else {
			Reporter.log("没有可投资的散标<br/>");
		}
		if (investmentListPage.clickKstz()) {	
			//输入金额为100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//输入支付密码
			investmentListPage.sendKeyPayPasswordTxt(paypassword);
			//输入错误验证码
			investmentListPage.sendKeyVerificationCodeTxt("12345");
			//点击确定
			investmentListPage.clickBidBtn();
			investmentListPage.isWrong("验证码输入有误，请重新输入！");
			investmentListPage.clickBidSuccessCloseBtn();
		}
		if (investmentListPage.clickKstz()) {
			//输入金额为100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//输入支付密码
			investmentListPage.sendKeyPayPasswordTxt(paypassword);
			//输入错误验证码
			investmentListPage.sendKeyVerificationCodeTxt(investmentListPage.getVerificationCode());
			//刷新验证码
			investmentListPage.refreshVerificationCode();
			//点击确定
			investmentListPage.clickBidBtn();
			try {
				investmentListPage.isWrong("验证码输入有误，请重新输入！");
			} catch (AssertionError e) {
				Reporter.log("标已结束！<br/>");
				investmentListPage.isWrong("标已结束！");
			}
			investmentListPage.clickBidSuccessCloseBtn();
		}
		if (investmentListPage.clickKstz()) {
			//输入金额为100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//输入支付密码
			investmentListPage.sendKeyPayPasswordTxt(paypassword);
			//输入错误验证码
			investmentListPage.sendKeyVerificationCodeTxt("@!##");
			//点击确定
			investmentListPage.clickBidBtn();
			investmentListPage.isWrong("验证码输入有误，请重新输入！");
			investmentListPage.clickBidSuccessCloseBtn();
		}
	}
	
	/**
	 * 投资列表--投资窗口部分--验证码
	 * 验证码：正确验证码,提示：投标成功
	 */
	@Test(priority = 38,enabled=false)
	public void payPasswordInput_web_609_5(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-验证码文本框.验证码：正确验证码,提示：投标成功<br/>");
		//base.openBrowser(base.indexURL+"/new/loadAllTender.action");
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			investmentListPage.fastInvest("100",paypassword);
			investmentListPage.isBitOk();
		}else {
			Reporter.log("没有可投资的散标<br/>");
		}
	}
	
	/**
	 * 投资列表--投资窗口部分--功能正确性
	 * 输入金额：正确,支付密码：正确,验证码：正确,点击取消按钮,投标金额窗口关闭显示投资列表（未支付成功）
	 */
	@Test(priority = 39)
	public void function_web_612_1(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-功能正确性.输入金额：正确,支付密码：正确,验证码：正确,点击取消按钮,投标金额窗口关闭显示投资列表（未支付成功）<br/>");
		base.openBrowser(investmentListPage.Url);
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//查看我的账户余额
		base.openBrowser(myAccountPage.MyAccountUrl);
		base.refreshPage();
		double balbaceBefore = myAccountPage.getBalance();		
		base.openBrowser(investmentListPage.Url);
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//输入金额为100
			investmentListPage.sendKeyInputMoneyTxt("100");
			//输入支付密码
			investmentListPage.sendKeyPayPasswordTxt(paypassword);
			//输入验证码
			investmentListPage.sendKeyVerificationCodeTxt(investmentListPage.getVerificationCode());
			//点击取消
			investmentListPage.clickCancel();
			//校验投资窗口消失
			investmentListPage.isBitWindowDisappear();
			//校验未支付成功
			base.openBrowser(myAccountPage.MyAccountUrl);
			base.refreshPage();
			double balbaceAfter = myAccountPage.getBalance();
			base.assertEqualsActualExpectedByDouble(balbaceAfter, balbaceBefore);
		}else {
			Reporter.log("没有可投资的散标<br/>");
		}
	}
	
	/**
	 * 投资列表--投资窗口部分--功能正确性
	 * 正常操作，弹出投标成成功提示框,在投标成功提示框中点击返回投资列表按钮，提示框关闭显示投资列表
	 */
	@Test(priority = 40)
	public void function_web_612_2and3(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-功能正确性.正常操作，弹出投标成功提示框,在投标成功提示框中点击返回投资列表按钮,提示框关闭显示投资列表<br/>");
		base.openBrowser(investmentListPage.Url);
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//快速投资
			investmentListPage.fastInvest("100",paypassword);
			//弹出投标成成功提示框
			investmentListPage.isBitOk();
			//点击返回列表
			investmentListPage.clickBackBtn();
			//提示窗口消失
			investmentListPage.isPromptDisappear();
		}else {
			Reporter.log("没有可投资的散标<br/>");
		}
	}
	
	/**
	 * 投资列表--投资窗口部分--功能正确性
	 * 正常操作，弹出投标成成功提示框,在投标成功提示框中点击到我的账户中查看按钮，转至我的账户-散标投资页
	 */
	@Test(priority = 41)
	public void function_web_612_4(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-功能正确性.正常操作，弹出投标成成功提示框,在投标成功提示框中点击到我的账户中查看按钮，转至我的账户-散标投资页<br/>");
		base.openBrowser(investmentListPage.Url);
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//快速投资
			investmentListPage.fastInvest("100",paypassword);
			//弹出投标成成功提示框
			investmentListPage.isBitOk();
			//点击去我的账户查看
			investmentListPage.toUserCenter();
			//转至我的账户-散标投资页
			base.assertTrueByBoolean(base.checkTitleContains(PageTitles.woDeZhangHu));
			myAccountPage.isGoMyAccount("散标投资");
		}else {
			Reporter.log("没有可投资的散标<br/>");
		}
	}
	
	/**
	 * 投资列表--投资窗口部分--功能正确性
	 * 正常操作，弹出投标成功提示框,在投标成功提示框中点击“×”按钮，提示框口关闭显示投资列表
	 */
	@Test(priority = 42)
	public void function_web_612_5(){
		Reporter.log("散标投资P2：投资列表-投标金额窗口-功能正确性.正常操作，弹出投标成成功提示框,在投标成功提示框中点击“×”按钮，提示框口关闭显示投资列表<br/>");
		base.openBrowser(investmentListPage.Url);
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//快速投资
			investmentListPage.fastInvest("100",paypassword);
			//弹出投标成成功提示框
			investmentListPage.isBitOk();
			//点击“关闭”按钮
			investmentListPage.clickBidSuccessCloseBtn();
			//提示窗口消失
			investmentListPage.isPromptDisappear();
		}else {
			Reporter.log("没有可投资的散标<br/>");
		}
	}

	/**
	 * 投资列表
	 * 有充值记录并且登录状态的用户点击快速投资按钮,弹出支付窗口
	 */
	@Test (priority = 43)
	public void bitList_web_567_4(){
		Reporter.log("散标投资P2：投资列表,有充值记录并且登录状态的用户点击快速投资按钮,弹出支付窗口<br/>");
		//登出
		base.logout();
		//跳转到“投资列表”页
		base.openBrowser(investmentListPage.Url);
		//未登录  先登录
		if (!loginPage.ifLogin()) {
			indexPage.clickLoginLink();
			loginPage.login(tel, password);
		}
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			//弹出支付窗口
			investmentListPage.isBitWindowDisplay();
		}else {
			Reporter.log("没有可投资的散标<br/>");
		}
	}

	/**
	 * 投资列表--投资窗口部分--自动输入功能
	 * 可用余额为49点击自动输入
	 */
	@Test(priority = 44)
	public void autoInput_web_598_2(){
		if (base.indexURL.contains("client")) {
			Reporter.log("散标投资P2：投资列表-投标金额窗口-自动输入功能.可用余额为49点击自动输入,提示：金额不足50，不能投标<br/>");
			base.logout();
			base.openBrowser(investmentListPage.Url);
			//登录
//			tel = Data.tel_balance_49;
			indexPage.clickLoginLink();
			loginPage.login(tel_49yuan, password);
			//是否有快速投资  有的话点击
			if (investmentListPage.clickKstz()) {
				//验证自动输入
				investmentListPage.isAutoInputOk();
				//关闭投资窗口
				investmentListPage.closeBitWindow();
			}else {
				Reporter.log("没有可投资的散标");
			}
		}
	}
	
	/**
	 * 投资列表--投资窗口部分--自动输入功能
	 * 可用余额为50点击自动输入
	 */
	@Test(priority = 45)
	public void autoInput_web_598_3(){
		if (base.indexURL.contains("client")) {
			Reporter.log("散标投资P2：投资列表-投标金额窗口-自动输入功能.可用余额为50点击自动输入,输入金额文本框显示：50<br/>");
			base.logout();
			base.openBrowser(investmentListPage.Url);
			//登录
//			tel = Data.tel_balance_50;
			indexPage.clickLoginLink();
			loginPage.login(tel_50yuan, password);
			//是否有快速投资  有的话点击
			if (investmentListPage.clickKstz()) {
				//点击投资窗口的自动输入
				investmentListPage.clickAutoInputBtn();
				base.sleep(2000);
				String autoValue = investmentListPage.getAutoValue();
				//关闭投资窗口
				investmentListPage.closeBitWindow();
				//验证自动输入
				base.assertEqualsActualExpected(autoValue, "50");
			}else {
				Reporter.log("没有可投资的散标<br/>");
			}
		}
	}
	

	/**
	 * 投资列表
	 * 新老注册用户未有充值记录点击快速投资按钮,提示：亲 请先去充值,再投资!
	 */
	@Test(priority = 46)
	public void bitList_web_567_1(){
		Reporter.log("散标投资P2：投资列表--新老注册用户未有充值记录点击快速投资按钮,提示：亲 请先去充值,再投资!<br/>");
		base.logout();
		base.openBrowser(investmentListPage.Url);
		//登录
		loginPage.login(tel_noRecharge,password,"",test_tel_noRecharge,password,"");
		//是否有快速投资  有的话点击
		if (investmentListPage.clickKstz()) {
			investmentListPage.isShowRecharge();
		}else {
			Reporter.log("没有可投资的散标");
		}
	}
	
	/**
	 * 用例名称：列表页_未登录
	 * 徐天元 摘自江渤洋
	 */
	@Test (priority = 47)
	public void bitList_web_567_3(){
		Reporter.log("散标投资P2：投资列表,未注册或未登录用户点击快速投资按钮,校验是否弹出“登录”窗口<br/>");
		//登出
		base.logout();
		//跳转到“投资列表”页
		base.openBrowser(investmentListPage.Url);
		//如果“快速投资”按钮存在，则点击，并校验登录DIV是否显示
		investmentListPage.clickFastInvestBtn();
	}
	
	
	/**
	 * 新手专区-菜单数字显示
	 * 测试新手专区当投资列表有正在进行中的标时，新手专区菜单后面小括号中显示数字（有几个标显示数字几）,新手专区无正在进行中的标时，菜单小括号中不显示
	 */
	@Test (priority = 48)
	public void debentureTransferPageNum_web_743(){
		Reporter.log("散标投资P2：新手专区-菜单数字显示,测试新手专区当投资列表有正在进行中的标时，新手专区菜单后面小括号中显示数字（有几个标显示数字几）,新手专区无正在进行中的标时，菜单小括号中不显示<br/>");
		Reporter.log("<font style=\"color:red;font-size:16px;\">集成环境上新手专区的数字显示一直有问题！</font><br/>");
		//跳转到“新手专区”页
		base.openBrowser(debentureTransferPage.PageUrl);
		//校验新手专区-菜单数字显示
		int num = debentureTransferPage.getDebentureTransferNum();
		debentureTransferPage.isDebentureTransferNumOK(num);
	}
}
