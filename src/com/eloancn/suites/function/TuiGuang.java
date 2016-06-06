package com.eloancn.suites.function;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.PageTitles;

public class TuiGuang {
	Base base = new Base();
	
	@BeforeClass
	public void setupBefore(){
		base.setup();
	}

	@AfterClass
	public void teardownAfter(){
		base.tearDown();
	}
	
	@Test(invocationCount=1000)
	public void pc1_anquan() {
		Reporter.log("http://www.eloancn.com/tg/tsla.html");
		checkFun("http://www.eloancn.com/tg/tsla.html",".ban");
	}
	
	public void checkFun(String url,String css){
		try {
			base.openBrowser(url); 
			base.checkTitle(PageTitles.tuiGuangYe);
			base.checkElement(By.cssSelector(css));
			base.checkElement(By.cssSelector(".btn"));
			base.checkElement(By.cssSelector(".erweima"));
			//base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#zhuce")), "10秒注册，体验极速的感觉");
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
