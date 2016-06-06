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
	
	//pc��ר��ҳ��
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
	
	    //��˹��ҳ�棺
	    //360PC����
		Reporter.log("http://www.eloancn.com/tg/tsla360jj.html");
		checkFun("http://www.eloancn.com/tg/tsla360jj.html",".ban");
	    //360PCƷר
		Reporter.log("http://www.eloancn.com/tg/tsla360pz.html");
		checkFun("http://www.eloancn.com/tg/tsla360pz.html",".ban");
        //�ٶ�PC����
		Reporter.log("http://www.eloancn.com/tg/tslabdjj.html");
		checkFun("http://www.eloancn.com/tg/tslabdjj.html",".ban");
	    //�ٶ�PCƷר
		Reporter.log("http://www.eloancn.com/tg/tslabdpz.html");
		checkFun("http://www.eloancn.com/tg/tslabdpz.html",".ban");
        //Ʒ��PCDSP
		Reporter.log("http://www.eloancn.com/tg/tslapydsp.html");
		checkFun("http://www.eloancn.com/tg/tslapydsp.html",".ban");
        //�ѹ�PC����
		Reporter.log("http://www.eloancn.com/tg/tslasgjj.html");
		checkFun("http://www.eloancn.com/tg/tslasgjj.html",".ban");
        //�����е�PC
		Reporter.log("http://www.eloancn.com/tg/tslawyyd.html");
		checkFun("http://www.eloancn.com/tg/tslawyyd.html",".ban");
        //��������PC
		Reporter.log("http://www.eloancn.com/tg/tslaxlhd.html");
		checkFun("http://www.eloancn.com/tg/tslaxlhd.html",".ban");
        //Ӫ��PC EDM
		Reporter.log("http://www.eloancn.com/tg/tslayxedm.html");
		checkFun("http://www.eloancn.com/tg/tslayxedm.html",".ban");
        //��ЧPCDSP
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
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#zhuce")), "10��ע�ᣬ���鼫�ٵĸо�");
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
