package com.eloancn.shared.common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * TestNG ʧ�����Լ�����
 */
public class RetryAnalyzer implements IRetryAnalyzer {
	
	private int retryCount = 0;			//���Դ���
	private int retryMaxCount = 1;		//������Դ���


	@Override
	public boolean retry(ITestResult result) {
//		if (retryCount < retryMaxCount) {
//			Reporter.setCurrentTestResult(result);
//			retryCount++;
//			return true;
//		}
		if (!result.isSuccess()) 
		{
			if (retryCount < retryMaxCount) 
			{
				retryCount++;
				result.setStatus(ITestResult.SUCCESS);
				int resultCount = retryMaxCount + 1 - retryCount;
				String message = Thread.currentThread().getName() + ": Error in " + result.getName() + " ������ " + resultCount + " ��";
				
				System.out.println(message);
				Reporter.log(message);
				return true;
			} 
			else 
			{
				result.setStatus(ITestResult.FAILURE);
			}
		}
		return false;
	}

	public RetryAnalyzer() {
		setCount(retryMaxCount);
	}
	
	public void setCount(int count) {
		retryMaxCount = count;
	}

}
