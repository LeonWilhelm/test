package com.eloancn.suites.function;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.PageTitles;

public class TeSiLa {
	Base base = new Base();
	int step = 0;
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
	}

	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	//pc端专题页：
	@Test(priority = 1,invocationCount=1000)
	public void pc1_anquan() {
		Reporter.log("http://www.eloancn.com/tg/anquan.html");
		checkFun("http://www.eloancn.com/tg/anquan.html",".ban");
	
		Reporter.log("http://www.eloancn.com/tg/ldyppp.html");
		checkFun("http://www.eloancn.com/tg/ldyppp.html",".ban");
	
		Reporter.log("http://www.eloancn.com/tg/shouyi.html");
		checkFun("http://www.eloancn.com/tg/shouyi.html",".sy_main.overflowV");
	
		Reporter.log("http://www.eloancn.com/tg/luodiyewangdai.html");
		checkFun("http://www.eloancn.com/tg/luodiyewangdai.html",".wangdb");
	
	    //特斯拉页面：
	    //360PC竞价
		Reporter.log("http://www.eloancn.com/tg/tsla360jj.html");
		checkFun("http://www.eloancn.com/tg/tsla360jj.html",".ban");
	    //360PC品专
		Reporter.log("http://www.eloancn.com/tg/tsla360pz.html");
		checkFun("http://www.eloancn.com/tg/tsla360pz.html",".ban");
        //百度PC竞价
		Reporter.log("http://www.eloancn.com/tg/tslabdjj.html");
		checkFun("http://www.eloancn.com/tg/tslabdjj.html",".ban");
	    //百度PC品专
		Reporter.log("http://www.eloancn.com/tg/tslabdpz.html");
		checkFun("http://www.eloancn.com/tg/tslabdpz.html",".ban");
        //品友PCDSP
		Reporter.log("http://www.eloancn.com/tg/tslapydsp.html");
		checkFun("http://www.eloancn.com/tg/tslapydsp.html",".ban");
        //搜狗PC竞价
		Reporter.log("http://www.eloancn.com/tg/tslasgjj.html");
		checkFun("http://www.eloancn.com/tg/tslasgjj.html",".ban");
        //网易有道PC
		Reporter.log("http://www.eloancn.com/tg/tslawyyd.html");
		checkFun("http://www.eloancn.com/tg/tslawyyd.html",".ban");
        //新澜互动PC
		Reporter.log("http://www.eloancn.com/tg/tslaxlhd.html");
		checkFun("http://www.eloancn.com/tg/tslaxlhd.html",".ban");
        //营销PC EDM
		Reporter.log("http://www.eloancn.com/tg/tslayxedm.html");
		checkFun("http://www.eloancn.com/tg/tslayxedm.html",".ban");
        //智效PCDSP
		Reporter.log("http://www.eloancn.com/tg/tslazxdsp.html");
		checkFun("http://www.eloancn.com/tg/tslazxdsp.html",".ban");
		if (step!=14) {
			base.assertTrueByBoolean(false);
		}
	}
	
	public void checkFun(String url,String css){
		try {
			base.openBrowser(url); 
			base.checkTitle(PageTitles.shouYe);
			base.checkElement(By.cssSelector(css));
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#zhuce")), "10秒注册，体验极速的感觉");
			step++;
		} catch (Exception e) {
			Reporter.log(e+"");
			System.out.println(e);
			Reporter.log("title:"+base.getPageTitle());
			System.out.println("title:"+base.getPageTitle());
			Reporter.log(base.getElementTextWithWait(By.cssSelector("html")));
			System.out.println(base.getElementTextWithWait(By.cssSelector("html")));
			base.assertTrueByBoolean(false);
		} catch (AssertionError e) {
			Reporter.log(e+"");
			Reporter.log("title:"+base.getPageTitle());
			System.out.println("title:"+base.getPageTitle());
			System.out.println(e);
			Reporter.log(base.getElementTextWithWait(By.cssSelector("html")));
			System.out.println(base.getElementTextWithWait(By.cssSelector("html")));
			base.assertTrueByBoolean(false);
		}
	}
}
