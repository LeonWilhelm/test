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
 * TestNG ʧ�ܽ�ͼ����ע������
 */
public class TestngListener extends TestListenerAdapter{
	
	public static final String CONFIG = "config.properties";

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		System.out.println(tr.getName() + " ����ʧ�ܣ���Ҫ�������У�");
		Reporter.log("<font style=\"color:red;font-size:16px;\">" + tr.getName() + " ����ʧ�ܣ���Ҫ�������У�</font>");//������ʾ�ڱ�����
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
				System.out.println("����ʧ�ܵ�����:" + failedTestCase.getTestClass().toString()+"----"+failedTestCase.getName());
				failedTestCases.remove();
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					System.out.println("���Գɹ�������:" + failedTestCase.getTestClass().toString()+"----"+failedTestCase.getName());
					failedTestCases.remove();
				}
			}
		}
	}
	
	/**
	 * �Զ���ͼ������ͼƬ�������Լ�html����ļ���
	 * @param tr
	 */
	private void takeScreenShot(ITestResult tr) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String mDateTime = formatter.format(new Date());
		String Classname = tr.getTestClass().getName().split("\\.")[4];
		String fileName = Classname + "����" + tr.getName() + "����" + mDateTime + ".png";//��������
		
		TakesScreenshot driver = (TakesScreenshot) Base.webDriver;
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		String currentPath = new File("").getAbsolutePath();		//��ǰ·��
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
            //����ʵ�ְ�ͼƬ����ֱ�����������ļ��У�ͨ���ʼ����ͽ�������ֱ����ʾͼƬ
//        	Reporter.log("<img src=\"../../../snapshot/" + fileName + "\"/>");//���������·��������·����ff�в���ʾ
        	Reporter.log("<br/><a style=\"color:red;font-size:16px;\" href=\"../../../snapshot/" + fileName + "\">ʧ�ܽ�ͼ</a>");
        	System.out.println("<img src=\"../../../snapshot/" + fileName + "\"/>");
        }
	}


}
