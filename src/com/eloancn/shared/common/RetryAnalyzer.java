package com.eloancn.shared.common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * TestNG 失败重试监听器
 */
public class RetryAnalyzer implements IRetryAnalyzer {
	
	private int retryCount = 0;			//重试次数
	private int retryMaxCount = 1;		//最大重试次数


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
				String message = Thread.currentThread().getName() + ": Error in " + result.getName() + " 重运行 " + resultCount + " 次";
				
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
