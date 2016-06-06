package com.eloancn.shared.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

/**
 * TestNG 失败截图，标注监听器
 */
public class TestngListener extends TestListenerAdapter{
	
	public static final String CONFIG = "config.properties";

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		System.out.println(tr.getName() + " 运行失败，需要重新运行！");
		Reporter.log("<font style=\"color:red;font-size:16px;\">" + tr.getName() + " 运行失败，需要重新运行！</font>");//可以显示在报告中
		takeScreenShot(tr);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
        takeScreenShot(tr);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
	}

	@Override
	public void onFinish(ITestContext context) {

		Iterator<ITestResult> failedTestCases =context.getFailedTests().getAllResults().iterator();
		while (failedTestCases.hasNext()) {
			ITestResult failedTestCase = (ITestResult) failedTestCases.next();
			ITestNGMethod method = failedTestCase.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				System.out.println("重试失败的用例:" + failedTestCase.getTestClass().toString()+"----"+failedTestCase.getName());
				failedTestCases.remove();
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					System.out.println("重试成功的用例:" + failedTestCase.getTestClass().toString()+"----"+failedTestCase.getName());
					failedTestCases.remove();
				}
			}
		}
	}
	
	/**
	 * 自动截图，保存图片到本地以及html结果文件中
	 * @param tr
	 */
	private void takeScreenShot(ITestResult tr) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String mDateTime = formatter.format(new Date());
		String Classname = tr.getTestClass().getName().split("\\.")[4];
		String fileName = Classname + "——" + tr.getName() + "——" + mDateTime + ".png";//加入类名
		
		TakesScreenshot driver = (TakesScreenshot) Base.webDriver;
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		String currentPath = new File("").getAbsolutePath();		//当前路径
		String filePath = currentPath + "\\snapshot\\" + fileName;
		Reporter.setCurrentTestResult(tr);
		try 
		{
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException e) {
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        } 
        finally
        {
            //这里实现把图片链接直接输出到结果文件中，通过邮件发送结果则可以直接显示图片
//        	Reporter.log("<img src=\"../../../snapshot/" + fileName + "\"/>");//必须是相对路径，绝对路径在ff中不显示
        	Reporter.log("<br/><a style=\"color:red;font-size:16px;\" href=\"../../../snapshot/" + fileName + "\">失败截图</a>");
        	System.out.println("<img src=\"../../../snapshot/" + fileName + "\"/>");
        }
	}


}
