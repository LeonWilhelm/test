package com.eloancn.shared.until;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

/**
 * 	验证码获取类
 */
public class RandCodeUtils {
	

	/**************************** Tesseract-OCR ***************************/
	
    /**
     * 获取验证码
     */
    public String getRandCode(WebDriver driver,WebElement element){
    	try {
			screenShotForElement(driver,element);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	runOcr();
    	sleep(2000);
    	return readTextFile();
    }
    
    /**
     * This method for screen shot element
     * 
     * @param driver
     * @param element
     * @param path
     * @throws InterruptedException
     */
    public static void screenShotForElement(WebDriver driver, WebElement element) throws InterruptedException {
    	
    	String path = FileUtil.getCurrentPath() + File.separator + "ocr" + File.separator + "ranCode.png";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Point p = element.getLocation();
            int width = element.getSize().getWidth();
            int height = element.getSize().getHeight();
            Rectangle rect = new Rectangle(width, height);
            BufferedImage img = ImageIO.read(scrFile);
            BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
            ImageIO.write(dest, "png", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取OCR的安装目录
     * 备注：路径含有空格需用双引号引起来
     * @return 目录路径
     * @author 江渤洋 2016-3-16
     */
    public static String getOCRPath(){
    	
    	FileUtil fileUtil = new FileUtil();
    	String[] pathArr = {												//OCR程序安装目录
    			"C:\\Program Files\\Tesseract-OCR\\tesseract.exe",
    			"C:\\Program Files (x86)\\Tesseract-OCR\\tesseract.exe",
    			"D:\\Program Files\\Tesseract-OCR\\tesseract.exe",
    			"D:\\Program Files (x86)\\Tesseract-OCR\\tesseract.exe"
    			};
    	for(int i = 0; i < pathArr.length; i++){
    		if(fileUtil.isFileExists(pathArr[i])){
    			Reporter.log("OCR的安装目录为：" + pathArr[i]);
    			System.out.println("OCR的安装目录为：" + pathArr[i]);
    			return pathArr[i];
    		}
    	}
    	return pathArr[0];
    }
    
    /**
     * 调用Tesseract-OCR生成text
     */
    public static void runOcr(){
    	
    	Runtime rt = Runtime.getRuntime();
        try {
			rt.exec("cmd.exe /C  \"" + getOCRPath() + "\" " + FileUtil.getCurrentPath() + "\\ocr\\ranCode.png  " + FileUtil.getCurrentPath() + "\\ocr\\test -1 ");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 读取文件内容
     */
    public static String readTextFile() {
    	
    	String lineTxt = null;
        try 
        {
            String encoding = "utf-8";
            File file = new File(FileUtil.getCurrentPath() + "\\ocr\\test.txt");
            if (file.isFile() && file.exists())
            { 
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                while ((lineTxt = bufferedReader.readLine()) != null) 
                {
                	break;
                }
                read.close();
            } 
            else 
            {
                System.out.println("验证码文件，不存在");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("验证码文件，读取文件内容出错");
            e.printStackTrace();
        } 
        return formatRandCode(lineTxt);
    }
    
    /**
     * 处理验证码
     * @param randCode 验证码
     * @return 验证码
     */
    public static String formatRandCode(String randCode){
    	
    	if (randCode.toLowerCase().contains("s")) {
    		randCode = randCode.toLowerCase().replace("s", "5");
		}
        if (randCode.toLowerCase().contains("z")) {
        	randCode = randCode.toLowerCase().replace("z", "2");
		}
        if(randCode.toLowerCase().contains("-")){
        	randCode = randCode.toLowerCase().replace("-", "");
        }
        if(randCode.toLowerCase().contains("i")){
        	randCode = randCode.toLowerCase().replace("i", "1");
        }
        if(randCode.toLowerCase().contains("b")){
        	randCode = randCode.toLowerCase().replace("b", "8");
        }
        if(randCode.toLowerCase().contains("u")){
        	randCode = randCode.toLowerCase().replace("u", "0");
        }
        if(randCode.toLowerCase().contains("l")){
        	randCode = randCode.toLowerCase().replace("l", "1");
        }
        if(randCode.toLowerCase().contains(" ")){
        	randCode = randCode.toLowerCase().replace(" ", "");
        }
        return randCode.trim();
    }
    
	/**
	 * 页面等待
	 * @param time等待时间（单位：毫秒）
	 */
	public void sleep(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
