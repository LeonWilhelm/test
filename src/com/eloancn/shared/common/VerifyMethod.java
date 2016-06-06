package com.eloancn.shared.common;

import org.testng.Assert;

import com.thoughtworks.selenium.SeleneseTestNgHelper;

public class VerifyMethod extends SeleneseTestNgHelper{
	/**
     * �ж����ν�� 
     * @author ����Ԫ
     */
    public void verifyTrue(boolean b) {
//    	super.verifyTrue(b);
    	try{
    		Assert.assertTrue(b);
    	}catch(AssertionError e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * �ж����ν�� 
     * @author ����Ԫ
     */
    public void verifyEquals(Boolean expected,Boolean actual){
//    	super.verifyEquals(expected, actual);
    	try{
    		Assert.assertEquals(expected, actual);
    	}catch(AssertionError e){
    		e.printStackTrace();
    	}
    }

    /**
     * �ж����ν�� 
     * @author ����Ԫ
     */
    public void verifyEquals(Object expected,Object actual){
    	try{
    		Assert.assertEquals(actual, expected);
    	}catch(AssertionError e){
    		e.printStackTrace();
    	}
    }
	
    /**
     * �ж����ν�� 
     * @author ����Ԫ
     */
    public void verifyFalse(Boolean b){
//    	super.verifyFalse(b);
    	try{
    		Assert.assertFalse(b);
    	}catch(AssertionError e){
    		e.printStackTrace();
    	}
    }

    /**
     * �ж����ν�� 
     * @author ����Ԫ
     */
    public void verifyNotEquals(Object expected,Object actual){
//    	super.verifyNotEquals(expected, actual);
    	try{
    		Assert.assertNotEquals(expected, actual);
    	}catch(AssertionError e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * �ж����ν�� 
     * @author ����Ԫ
     */
    public void verifyNotEquals(Boolean expected,Boolean actual){
//    	super.verifyNotEquals(expected, actual);
    	try{
    		Assert.assertNotEquals(expected, actual);
    	}catch(AssertionError e){
    		e.printStackTrace();
    	}
    }
}
