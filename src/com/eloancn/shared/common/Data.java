package com.eloancn.shared.common;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.jdesktop.swingx.util.OS;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Screen;
import org.testng.Reporter;

import com.sun.media.imageio.plugins.tiff.TIFFImageWriteParam;
import com.eloancn.shared.common.Base;

public class Data {
	static Data data = new Data();
	Base base = new Base();
	
	/******************************集成环境的注册账户*************************************/
	public static String email = data.emailConcatenation(0,2);
	public static String email2 = data.emailConcatenation(0,2);
	public static String tel = data.phoneConcatenation(0);//借入者
	public static String realName = "李建文";
	public static String tel2 = data.phoneConcatenation(0);//投资者2
	public static String realName2 = "邹海雪";
	public static String tel3 = data.phoneConcatenation(0);//投资者3
	public static String password = "111111";
	
	public static String zzmm = "111111";//支付密码
	//xty
	public static String tel_run_debit2 = "13111122280";//借款者  最好有确认借贷功能的
	public static String realName_run_debit2 = "李永永";
	public static String email_run_debit2 = "13111111171@qq.com";
	public static String idCard_run_debit2 = "11011519620715562X";
	//public static String tel_run_credit = "13111111153";//投资者  有钱
	public static String tel_run_DebentureTransfer = "13632917617";//新手专区投资  投资少于10000(原账号：13689802284)
	public static String idCard_run_credit = "11011519620715561X";
    public static String newUser ="13111111158";//创建新手标用户
	//jby
	public static String tel_run_EcunBao = "13800138002";//翼存宝 13111111155
	public static String tel_run_MyAccount = "13581569929";//我的账户
	public static String name_run_MyAccount = "张三丰";//我的账户姓名 
	public static String id_run_MyAccount = "11010519850423007X";//我的账户身份证
	//lj
	public static String tel_run_zhaiquan1 = "13111111201";
	public static String tel_run_zhaiquan2 = "13111111169";		//贷出者
	
	/*****************P1*******************/
	//ECunBao_P1>>>>>>>>>>>>>>>>>>>>>>>>
	//jby
	public static String run_ECunBao_99 = "13111111188";//账户不足100
	public static String run_ECunBao_register = "13111111177";//未充钱用户投资 新注册手机用户
	public static String run_ECunBao_oldtel = "13111111141";//未充钱用户投资 老手机用户
	public static String run_ECunBao_oldemail = "123@126.com";//未充钱用户投资 老邮箱用户
	public static String ECunBao_Normal_tel = "13581567705";  //普通用户
	public static String ECunBao_VIP10_tel  = "13581567706";  //VIP1.0用户   （后台发布翼存宝，前台直接购买即可。无需借款）
	public static String ECunBao_VIP15_tel  = "13581567707";  //VIP1.5用户   （后台发布翼存宝，前台直接购买即可。无需借款）

	//xty
	public static String tel_eCunBao_P1 = "13111111240";
	//public static String tel_securityAuth_P1 = "13111111241";
	
	/*****************P2*******************/
	public static String tel_balance_49 = "13111111202";//账户49元  散标投资-投资窗口-自动输入
	public static String tel_balance_50 = "13111111203";//账户50元  散标投资-投资窗口-自动输入
	public static String tel_investmentList_P2 = "13111111239";
	//体验期翼存宝
	public static String tel_ExperienceNoInterest_client = "13581568811"; //有体验期的用户（有效期为一个月，过期换号） 13581568800
	public static String tel_ExperienceInterest_client = "13581567600"; //已购买体验期翼存宝，并开始计息
	public static String email_ExperienceInterest_client = "13581567600@163.com";
	public static String tel_ExperienceNoInterest_test = ""; //有体验期的用户（有效期为一个月，过期换号）
	public static String tel_ExperienceInterest_test = ""; //已购买体验期翼存宝，并开始计息
	public static String email_ExperienceInterest_test = "";
	
	public static String email_MyAccountP2 = "13581567702@163.com";//手机未注册的邮箱用户
	public static String client_tel_new = "13581568700"; //新手机注册用户
	public static String client_tel_old = "13581568701"; //老手机注册用户
	public static String tel_change = "13581567703";
	public static String tel_noChange = "13581567699";
	//申请借款-lj
	public static String tel_Loan = "13011887694";										//集成、线上申请借款的用户
	public static String tel_Loan_Name= "赵薇";
	public static String tel_Loan_PayPwd="111111";
	public static String tel_Loan_idCard="34020419760312152X";
	//申请联保贷
	public static String tel_LBDCreaterLoan= "13581838716";
	public static String tel_LBDCreaterName="倪建勋";
	public static String tel_LBDNoncreaterLoan ="13581838717";
	public static String tel_LBDNoncreaterName="李兆根";
	
	//投资-lj
	public static String tel_Invest = "13011879174";//要投资散标
	public static String tel_Invest_Name="刘涛";
	public static String tel_Invest_PayPwd="111111";
	public static String tel_Invest_idCard="360103197807124724";
	//投资列表
//	public static String tel_old_user = "13581838716";	//未充钱用户投资 老手机用户
//	public static String email_old_user = "ligen65@qq.com";	//未充钱用户投资 老邮箱用户
	
	/******************************预上线环境的账户*************************************/
	//借入者注册debit>>>>>>>>>>>>>>>>>>>>>>>>
	public static String test_register_debit_tel = "13011874514";//手机号
	public static String test_register_debit_realName = "周恩挚";//真实姓名
	public static String test_register_debit_idCard = "210181198803168317";
	
	//投资者注册credit>>>>>>>>>>>>>>>>>>>>>>>>
	public static String test_register_credit_tel = "13011885149";//手机号
	public static String test_register_credit_realName = "刘宝山";//真实姓名
	public static String test_register_credit_idCard = "150430198611211499";
	
	//test专用号 18880000200>>>>>>>>>>>>>>>>>
	public static String test_tel = "18880000200";//手机号
	public static String test_password = "111111";//密码
	public static String test_realName = "索鹏";//真实姓名
	public static String test_idCard = "420400197512034215";//身份证号
	public static String test_zzmm = "yqlxzh";//转账密码
	public static String test_email = "eloanxn200@eloancn.com";//邮箱
	
	//test专用号2  未身份认证   18880000199>>>>>>>>
	public static String test2_tel = "18880000199";//手机号
	public static String test2_password = "111111";//密码
	public static String test2_realName = "耿新之";//真实姓名
	public static String test2_idCard = "440607197510046801";//身份证号
	public static String test2_zzmm = "yqlxzh";//转账密码
	public static String test2_email = "eloanxn199@eloancn.com";//邮箱
	
	//test专用号3  未身份认证   18880000198>>>>>>>>
	public static String test3_tel = "18880000198";//手机号
	public static String test3_password = "111111";//密码
	public static String test3_realName = "管恨荷";//真实姓名
	public static String test3_idCard = "360425199009155028";//身份证号
	public static String test3_zzmm = "yqlxzh";//转账密码
	public static String test3_email = "eloanxn198@eloancn.com";//邮箱
	
	//test专用号4  身份已认证   18880000197>>>>>>>>
	public static String test4_tel = "18880000197";//手机号
	public static String test4_password = "111111";//密码
	public static String test4_realName = "赵兰田";//真实姓名
	public static String test4_idCard = "110101194206062035";//身份证号
	public static String test4_zzmm = "yqlxzh";//转账密码
	public static String test4_email = "eloanxn197@eloancn.com";//邮箱
	
	/*****************P1*******************/
	//ECunBao_P1>>>>>>>>>>>>>>>>>>>>>>>>
	public static String test_run_ECunBao_register = "13810367911";//未充钱用户投资 新注册手机用户
	public static String test_run_ECunBao_oldtel = "15011514888";//未充钱用户投资 老手机用户
	public static String test_run_ECunBao_oldemail = "ff@qq.com";//未充钱用户投资 老邮箱用户
	//Register_P1>>>>>>>>>>>>>>>>>>>>>>>>
	public static String test_run_Register_tel = "13011885141";
	//MyAccount_P1
	public static String test_tel_run_MyAccount = "13011887854";

	/*****************P2*******************/
	//投资列表InvestmentList_P2>>>>>>>>>>>>>>>>>>>>>>>>
	public static String[] defaultPlaces = {"深圳","北京","上海","广州","成都","杭州"};//默认地区
	
	//我的账户
	public static String test_myAccount_P2_tel = "13011887724";//已身份验证
	
	/*****************安全认证*******************/
	public static String test_run_SecurityAuth_P1_tel = "13011887642";
	public static String test_run_SecurityAuth_P1_realName = "宋烨韬";
	public static String test_run_SecurityAuth_P1_idCard = "140105198412063716";
	
	public static String test_run_SecurityAuth_P3_tel1 = "13011887469";
	public static String test_run_SecurityAuth_P3_tel2 = "13011879450";
	public static String test_run_SecurityAuth_P3_realName2 = "钟磊";
	public static String test_run_SecurityAuth_P3_idCard2 = "510106197904075116";
	public static String test_run_SecurityAuth_P3_tel3 = "13011879452";
	public static String test_run_SecurityAuth_P3_tel4 = "13011873604";
	public static String test_run_SecurityAuth_P3_realName4 = "许淞";
	public static String test_run_SecurityAuth_P3_idCard4 = "320283199109253237";
	public static String test_run_SecurityAuth_P3_tel5 = "13011876149";
	public static String test_run_SecurityAuth_P3_realName5 = "杜斌";
	public static String test_run_SecurityAuth_P3_idCard5 = "142401198402112118";
	public static String test_run_SecurityAuth_P3_tel6 = "13011884785";
	public static String test_run_SecurityAuth_P3_realName6 = "欧阳剑平";
	public static String test_run_SecurityAuth_P3_idCard6 = "431126198901137618";
	public static String test_run_SecurityAuth_P3_tel8 = "13011873524";
	public static String test_run_SecurityAuth_P3_realName8 = "赵曙光";
	public static String test_run_SecurityAuth_P3_idCard8 = "130625198505032012";
	public static String test_run_SecurityAuth_P3_tel9 = "13011884752";
	public static String test_run_SecurityAuth_P3_realName9 = "吴君龙";
	public static String test_run_SecurityAuth_P3_idCard9 = "330326198605254314";
	public static String test_run_SecurityAuth_P3_tel11 = "13011884709";
	public static String test_run_SecurityAuth_P3_tel12 = "13011871482";
	public static String test_run_SecurityAuth_P3_realName12 = "蒋英杰";
	public static String test_run_SecurityAuth_P3_idCard12 = "450324198803131918";
	public static String test_run_SecurityAuth_P3_tel13_1 = "13011887944";
	public static String test_run_SecurityAuth_P3_realName13_1 = "秦先正";
	public static String test_run_SecurityAuth_P3_idCard13_1 = "211022198107120016";
	public static String test_run_SecurityAuth_P3_tel13_2 = "13011887874";
	public static String test_run_SecurityAuth_P3_realName13_2 = "任亚曦";
	public static String test_run_SecurityAuth_P3_idCard13_2 = "510107199009111817";
	public static String test_run_SecurityAuth_P3_tel13_3 = "13011885384";
	public static String test_run_SecurityAuth_P3_realName13_3 = "何佳俊";
	public static String test_run_SecurityAuth_P3_idCard13_3 = "513401198004215517";
	
	
	/********************************测试数据******************************************/
	public static String bankAccount = "622848181113360";//原数据：622848181113333
	public static String[] names = {"沈一","沈二","沈三","沈四","沈五","沈六"};
	public static String[] tels = data.getTels();//{"13145458001","13145458002","13145458003","13145458004","13145458005","13145458006"};

    //首页banner大图的链接title
	public static String[] banners_client = {"“双十二”全民狂欢，剁手7天 红包赚翻-活动专区-翼龙贷论坛 - 翼龙贷",
											 "冲关200亿活动，每日奖励100名，头名狂送5万元-活动专区-翼龙贷论坛 - 翼龙贷",
											 "红包的最新玩法-邀朋友助力，红包拿到爽-活动专区-翼龙贷论坛 - 翼龙贷",
											 "剁手党再出手！翼存宝周岁加息一个月，错过等明年！-活动专区-翼龙贷论坛 - 翼龙贷",
											 "【翼龙贷理财APP|投资手机客户端iPhone/Android版下载】翼龙贷",
											 "【5月11日中央一套新闻联播正面报道翼龙贷网】-翼龙贷",
											 "【加盟翼龙贷】-翼龙贷"};
	public static String[] banners_test   = {
											 "价值7000元的豪华户外装备、万份红包免费送，先到先得-活动专区-翼龙贷论坛 - 翼龙贷",
											 "小额贷款公司加盟哪家好？-翼龙贷贷款加盟",
											 "北京同城翼龙网络科技有限公司2016最新招聘信息_地址_电话-猎聘企业信息",
											 "春播—互联网金融助力减贫之江南行如火如荼进行中-最新动态-翼龙贷论坛 - 翼龙贷",
											 "博鳌时间|站在农村的视角 看农业的未来发展-最新动态-翼龙贷论坛 - 翼龙贷",
											 "“五”所不知——翼龙贷投资人开放日，周周有！-最新动态-翼龙贷论坛 - 翼龙贷",
											 "2016年好的开端，翼龙贷1月份运营报告出炉啦-最新动态-翼龙贷论坛 - 翼龙贷"
											 };
	/******************************集成环境的后台账户*************************************/
	
	//通知码
	public static String noticeCode = "4000292886d";
	//总部用户名
	public static String headquartersUserName1 = "jby1";
	public static String headquartersUserName2 = "jby2";
	public static String headquartersUserName3 = "jby3";
	//加盟商用户名
	public static String allianceBusinessUserName1 = "jby_1";
	public static String allianceBusinessUserName2 = "jby_2";
	public static String allianceBusinessUserName3 = "jby_3";
	//三个加盟商，一个总部
	public static String userNameArray[] = {"jby_1", "jby_2", "jby_3", "jby1"};
//	public static String userNameArray[] = {"xty_1", "xty_2", "xty_3", "xty1"};
//	public static String userNameArray[] = {"lj_1", "lj_2", "lj_3", "lj1"};

	//加盟商或总部的确认密码
	public static String passwordByBack = "eloancn888";
	//借款人姓名
	public static String borrowerName = "用户二";
	//借款人邮箱
	public static String borrowerEmail = "yh2@11.com";
	//贷出者邮箱
	public static String lendEmail = "mgr06@t01.com";
	//借款金额_前台  | 最大金额_后台 （前台金额>=后台金额，且为100的整数倍，10条数据内不可重复）
	public static String loanAmount = "15900";
	public static String loanAmount2 = "16000";
	public static String loanAmount_Fail = "15600";
	
	/**************************************************************************/
	/**
	 * 生成银行卡号
	 */
	public String getBank(){
		String bank = "62284818";
		bank += (int)(Math.random()*10000000); 
		return bank;
	}
	
	/**
	 * 徐天元
	 * 生成联系人手机号
	 */
	public String[] getTels(){
		String[] telphones = new String[6];
		for (int i = 0; i < telphones.length; i++) {
			telphones[i] = phoneConcatenation(0);
//			logger.info("紧急联系人"+i+"："+telphones[i]);
			Reporter.log("紧急联系人"+i+"："+telphones[i]+"<br/>");
		}
		return telphones;
	}
	
	/********************************获取验证码*******************************************/
	/**
	 * 
	 * @param 
	 * @param 
	 * @return
	 * @author 
	 */
	@Deprecated
	public String get(WebElement yanZhengMa,WebDriver webDriver){
		//获取验证码
		//WebElement yanZhengMa = webDriver.findElement(By.xpath("//img[contains(@src,'/randCode')]"));
		Actions action = new Actions(webDriver);
		//右键单击验证码
		action.contextClick(yanZhengMa).build().perform();
		base.sleep(2000);
		//IE  chrome  firefox
		Screen screen = new Screen();
		String curPath = new File("").getAbsolutePath();//当前路径
		String webdriver = base.getWebDriver().toString();
		String edition = base.getBrowserEdition();
		if (webdriver.contains("InternetExplorerDriver")){
			screen.type("S");
		}else if(webdriver.contains("FirefoxDriver")){
			//使用快捷键"Shift + Alt + v"
			action.keyDown(Keys.SHIFT);
			action.keyDown(Keys.ALT).sendKeys("V").perform();
			action.keyUp(Keys.SHIFT);
			action.keyUp(Keys.ALT);
		}
		else {
			screen.type("V");
		}
		base.sleep(3000);

		//运行AutoIt 编写的脚本
		try {
			if (webdriver.contains("FirefoxDriver")) {
				Runtime.getRuntime().exec(curPath+"\\exe\\HuoQuYanZhengMa.exe");//HuoQuYanZhengMa.exe  yanzhengma_ff.exe
			}else if(webdriver.contains("InternetExplorerDriver")){
				if(edition.contains("8")){
					Runtime.getRuntime().exec(curPath+"\\exe\\yanzhengma_ie8.exe");
				}else{
					Runtime.getRuntime().exec(curPath+"\\exe\\yanzhengma_ie.exe");
				}
			}else{
				Runtime.getRuntime().exec(curPath+"\\exe\\yanzhengma_chrome.exe");
			}
//			else if (base.browserType.equalsIgnoreCase("ie")){
//				Runtime.getRuntime().exec(curPath+"\\exe\\yanzhengma_ie.exe");
//			}
//			else if (base.browserType.equalsIgnoreCase("ie8")){
//				Runtime.getRuntime().exec(curPath+"\\exe\\yanzhengma_ie8.exe");
//			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		//图片文件地址 
		String imagePath = "";
		if(webdriver.contains("FirefoxDriver")||webdriver.contains("ChromeDriver")){
			imagePath = "C://randCode.jsp.jpg";
		}else{
			if(edition.contains("8")){
				imagePath = "C://randCode.jsp.bmp";
			}else{
				imagePath = "C://randCode.jsp.png";  
			}
		}
//		else if (base.browserType.equalsIgnoreCase("ie")) {
//			imagePath = "C://randCode.jsp.png";  
//		}else if (base.browserType.equalsIgnoreCase("ie8")){
//			imagePath = "C://randCode.jsp.bmp";
//		}
        System.out.println("ORC Test Begin......");//-----------------测试  
        String codeString = "";
        try {   
        	//获取扩展名为"jpg"图片文件的内容
        	if(webdriver.contains("FirefoxDriver")||webdriver.contains("ChromeDriver")){
    			codeString = recognizeText(new File(imagePath), "jpg");
        	}else{
    			if(edition.contains("8")){
    				codeString = recognizeText(new File(imagePath), "bmp");  
    			}else{
    				codeString = recognizeText(new File(imagePath), "png");
    			}
        	}
//        	else if (base.browserType.equalsIgnoreCase("ie")) {
//        		codeString = recognizeText(new File(imagePath), "png");  
//        	}else if (base.browserType.equalsIgnoreCase("ie8")) {
//        		codeString = recognizeText(new File(imagePath), "bmp");  
//    		}
            System.out.println(codeString);       
        } 
        catch (IOException e) {       
            e.printStackTrace();       
        } 
        catch (Exception e) {    
            e.printStackTrace();    
        }
        //处理验证码
        if (codeString.toLowerCase().contains("s")) {
        	codeString = codeString.toLowerCase().replace("s", "5");
		}
        if (codeString.toLowerCase().contains("z")) {
        	codeString = codeString.toLowerCase().replace("z", "2");
		}
        if(codeString.toLowerCase().contains("-")){
        	codeString = codeString.toLowerCase().replace("-", "");
        }
        if(codeString.toLowerCase().contains("I")){
        	codeString = codeString.toLowerCase().replace("I", "1");
        }
        if(codeString.toLowerCase().contains("B")){
        	codeString = codeString.toLowerCase().replace("B", "8");
        }
        System.out.println("ORC Test End......");//-----------------测试   
        return codeString.replace(" ", "");
	}
	
	/**
	 * 图片文件转换为tif格式 
     * @param imageFile 读取源图片路径 
     * @param imageFormat 读取图片格式 	 
     * @return
	 * @author 
	 */
	public static File createImage(File imageFile, String imageFormat) {    
        File tempFile = null;    
        try {    
        	//读取一列图片文件
            Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(imageFormat);    
            ImageReader reader = (ImageReader) readers.next();    
            //设置图片输入路径
            ImageInputStream iis = ImageIO.createImageInputStream(imageFile);    
            reader.setInput(iis);    
            //读取元数据（当图像格式只有一个图像时，必须使用元数据）
            IIOMetadata streamMetadata = reader.getStreamMetadata();    
                
            //Set up the writeParam    
            TIFFImageWriteParam tiffWriteParam = new TIFFImageWriteParam(Locale.CHINESE);    
            tiffWriteParam.setCompressionMode(ImageWriteParam.MODE_DISABLED);    
                
            //Get tif writer and set output to file    
            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("tiff");    
            ImageWriter writer = (ImageWriter) writers.next();    
                
            BufferedImage bi = reader.read(0);    //读取第一个图片
            IIOImage image = new IIOImage(bi,null,reader.getImageMetadata(0));   //存储图像，元数据 
            tempFile = tempImageFile(imageFile);    
            ImageOutputStream ios = ImageIO.createImageOutputStream(tempFile);    
            writer.setOutput(ios);    
            writer.write(streamMetadata, image, tiffWriteParam);    
            ios.close();    
                
            writer.dispose();    
            reader.dispose();    
                
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
        return tempFile;    
    }    
    
	/**
	 * 
	 * @param 
	 * @param 
	 * @return
	 * @author 
	 */
    private static File tempImageFile(File imageFile) {    
        String path = imageFile.getPath();    
        StringBuffer strB = new StringBuffer(path);    
        strB.insert(path.lastIndexOf('.'),0);    
        return new File(strB.toString().replaceFirst("(?<=//.)(//w+)$", "tif"));    
    }    
    
    private final String LANG_OPTION = "-l";  //英文字母小写l，并非数字1    
    private final String EOL = System.getProperty("line.separator");  
    //配置你安装的OCR的路径
    private String tessPath = "D://Program Files (x86)//Tesseract-OCR";    
    //private String tessPath = new File("tesseract").getAbsolutePath();    
        
	/**
	 *        
	 * @param 
	 * @param 
	 * @return
	 * @author 
	 */
    public String recognizeText(File imageFile,String imageFormat)throws Exception{    
        File tempImage = createImage(imageFile,imageFormat);    
        File outputFile = new File(imageFile.getParentFile(),"output");    
        StringBuffer strB = new StringBuffer();    
        List<String> cmd = new ArrayList<String>(); 
        if(OS.isWindowsXP()){    
            cmd.add(tessPath+"//tesseract");    
//        	cmd.add(tessPath);
        }else if(OS.isLinux()){    
            cmd.add("tesseract");    
        }else{    
            cmd.add(tessPath+"//tesseract");    
//        	cmd.add(tessPath);
        }    
        cmd.add("");    
        cmd.add(outputFile.getName());    
        cmd.add(LANG_OPTION);    
//        cmd.add("chi_sim");    
        cmd.add("eng");    
            
        ProcessBuilder pb = new ProcessBuilder();    
        pb.directory(imageFile.getParentFile());    
            
        cmd.set(1, tempImage.getName());    
        pb.command(cmd);    
        pb.redirectErrorStream(true);    
            
        Process process = pb.start();    
        //tesseract.exe 1.jpg 1 -l chi_sim    
        int w = process.waitFor();    
            
        //删除临时正在工作文件    
        tempImage.delete();    
            
        if(w==0){    
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile.getAbsolutePath()+".txt"),"UTF-8"));    
                
            String str;    
            while((str = in.readLine())!=null){    
                strB.append(str).append(EOL);    
            }    
            in.close();    
        }else{    
            String msg;    
            switch(w){    
                case 1:    
                    msg = "Errors accessing files.There may be spaces in your image's filename.";    
                    break;    
                case 29:    
                    msg = "Cannot recongnize the image or its selected region.";    
                    break;    
                case 31:    
                    msg = "Unsupported image format.";    
                    break;    
                default:    
                    msg = "Errors occurred.";    
            }    
            tempImage.delete();    
            throw new RuntimeException(msg);    
        }    
        new File(outputFile.getAbsolutePath()+".txt").delete();    
        return strB.toString();    
    } 
    
	/********************************随机生成邮箱*******************************************/
    
	//用户名的长度(3-16位)
	/*
	 * 0：代表任意长度，3:代表长度3，之后以此类推
	 */
	public int getUserNameLength(int length)
	{
		//最大长度
		int maxLength = length;
		//如果长度为0，则随机生成3-16数
		if(maxLength == 0){
			maxLength = (int)(Math.random() * 13 + 3);
			return maxLength;
		}
		else if(maxLength<=16) {
			return maxLength;
		}
		else {
			return -1;
		}
	}
	
	//用户名包括字母
	public char getCharacter(){
		char englishChar=(char)(int)(Math.random() * 26 + 97);
		return englishChar;
	}
	//用户名包括数字
	public char getNum()
	{
		int numInt = (int)(Math.random() * 9);
		String numString = String.valueOf(numInt);
		char numChar = numString.charAt(0);
		return numChar;
	}
	
	//邮件服务器
	public String getEmailDoMain(){
		String doMainArray[] = {"163.com","126.com","188.com","yeah.net","sina.com","sohu.com","tom.com","gmail.com","qq.com","263.net","qq.com"};
		int index = (int)(Math.random() * (doMainArray.length-1));
		return doMainArray[index];
	}
	
	/*
	 * length  0：代表任意长度，3:代表长度3，之后以此类推
	 * sign 0：字母,1：数字，2：字母+数字
	 */
	public String emailConcatenation(int length, int sign){
		StringBuilder emailStringBuilder = new StringBuilder();
		int emailLength = this.getUserNameLength(length);
		if(sign==0){
			for(int i=0;i<emailLength;i++){
				emailStringBuilder.append(this.getCharacter());
			}
			emailStringBuilder.append("@");
			return emailStringBuilder.append(this.getEmailDoMain()).toString();
		}
		else if(sign==1){
			for(int i=0;i<emailLength;i++){
				if(i==0 && this.getNum()!=0){
					emailStringBuilder.append(this.getNum());
				}
				else if(i!=0){
					emailStringBuilder.append(this.getNum());
				}
			}
			emailStringBuilder.append("@");
			return emailStringBuilder.append(this.getEmailDoMain()).toString();
		}
		else if(sign==2){
			int temp = (int)(Math.random() * 13 + 3);
			for(int i=0;i<temp;i++){
				emailStringBuilder.append(this.getCharacter());
			}
			for(int i=0;i<emailLength-temp;i++){
				emailStringBuilder.append(this.getNum());
			}
			emailStringBuilder.append("@");
			return emailStringBuilder.append(this.getEmailDoMain()).toString();
		}
		else {
			return "邮箱名组合错误";
		}
	}
	
	/********************************随机生成手机号*******************************************/
	
	//手机号码都是按照运营商和地区来规划的，前3位是运营商的代码、中间4位是归属地代码、后4位是用户号码
	//移动号段 - 0代表 - 16个（官网：http://service.bj.10086.cn/phone/jxhsimcard/gotone_list.html）
	String mobileArray[] = {"139","138","137","136","135","134","188","187","183","182","159","158","157","152","151","150"};
	//联通号段- 1代表 - 8个（http://num.10010.com/NumApp/chseNumList/init）
	String unicomArray[] = {"186","185","176","156","155","132","131","130"};
	//电信号段- 2代表 - 6个（官网：http://www.189.cn/?cmpid=jt-ppc-baidu-am-ppzq-home#）
	String telecomArray[] = {"189","181","180","177","153","133"};
	
	int mobileLength = mobileArray.length;
	int unicomLength = unicomArray.length;
	int telecomLength = telecomArray.length;
	
	/*
	 * 获取公司号段
	 */
	public String getCompany(int companyName){
		//移动
		if(companyName == 0){
			//返回数组0~15之间的数
			return mobileArray[(int)(Math.random() * mobileLength)];
		}
		//联通
		else if(companyName == 1){
			//返回数组0~7之间的数
			return unicomArray[(int)(Math.random() * unicomLength)];
		}
		//电信
		else if(companyName == 2){
			//返回数组0~5之间的数
			return telecomArray[(int)(Math.random() * telecomLength)];
		}
		//移动 或 联通 或 电信随机获取
		else{
			int temp = -1;
			//随机值为0、1、2
			temp = (int)(Math.random() * 3);
			if(temp == 0){
				return mobileArray[(int)(Math.random() * mobileLength)];
			}
			else if(temp == 1){
				return unicomArray[(int)(Math.random() * unicomLength)];
			}
			else if(temp == 2){
				return telecomArray[(int)(Math.random() * telecomLength)];
			}
		}
		return null;
	}

	/*
	 * 获取地区号段
	 */
	public String getAreaCode(){
		String areaCode = ""; 
		//循环生成地区号，直到长度为4
		while(true){
			//返回0~9999之间的数
			areaCode = Integer.toString((int)(Math.random() * 10000));
			//长度为4时跳出
			if(areaCode.length()==4){
				return areaCode;
			}
		}
	}
	
	/*
	 * 获取四位随机号码
	 */
	public String getUserCode(){
		String userCode = ""; 
		//循环生成随机号，直到长度为4
		while(true){
			//返回0~9999之间的数
			userCode = Integer.toString((int)(Math.random() * 10000));
			//长度为4时跳出
			if(userCode.length()==4){
				return userCode;
			}
		}
	}
	
	/*
	 * 拼接手机号码
	 */
	public String phoneConcatenation(int companyName){
		StringBuilder phoneStringBuilder = new StringBuilder();
		phoneStringBuilder.append(this.getCompany(companyName));
		phoneStringBuilder.append(this.getAreaCode());
		phoneStringBuilder.append(this.getUserCode());
		return phoneStringBuilder.toString();
	}
	
	/*****************************随机生成姓名******************************/
	
	/**
	 * 获取姓
	 * @return 姓
	 */
	public String getFirstName(){
		Random random = new Random();
		/* 598 百家姓 */		
		String[] firstName= {"赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩",""
						+ "杨","朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏",""
						+ "陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚",""
						+ "范","彭","郎","鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳",""
						+ "酆","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗",""
						+ "毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余",""
						+ "元","卜","顾","孟","平","黄","和","穆","萧","尹","姚","邵","湛","汪","祁",""
						+ "毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞",""
						+ "熊","纪","舒","屈","项","祝","董","梁","杜","阮","蓝","闵","席","季","麻",""
						+ "强","贾","路","娄","危","江","童","颜","郭","梅","盛","林","刁","钟","徐",""
						+ "邱","骆","高","夏","蔡","田","樊","胡","凌","霍","虞","万","支","柯","昝",""
						+ "管","卢","莫","经","房","裘","缪","干","解","应","宗","丁","宣","贲","邓",""
						+ "郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚","程","嵇","邢",""
						+ "滑","裴","陆","荣","翁","荀","羊","于","惠","甄","曲","家","封","芮","羿",""
						+ "储","靳","汲","邴","糜","松","井","段","富","巫","乌","焦","巴","弓","牧",""
						+ "隗","山","谷","车","侯","宓","蓬","全","郗","班","仰","秋","仲","伊","宫",""
						+ "宁","仇","栾","暴","甘","钭","厉","戎","祖","武","符","刘","景","詹","束",""
						+ "龙","叶","幸","司","韶","郜","黎","蓟","溥","印","宿","白","怀","蒲","邰",""
						+ "从","鄂","索","咸","籍","赖","卓","蔺","屠","蒙","池","乔","阴","郁","胥",""
						+ "能","苍","双","闻","莘","党","翟","谭","贡","劳","逄","姬","申","扶","堵",""
						+ "冉","宰","郦","雍","却","璩","桑","桂","濮","牛","寿","通","边","扈","燕",""
						+ "冀","浦","尚","农","温","别","庄","晏","柴","瞿","阎","充","慕","连","茹",""
						+ "习","宦","艾","鱼","容","向","古","易","慎","戈","廖","庾","终","暨","居",""
						+ "衡","步","都","耿","满","弘","匡","国","文","寇","广","禄","阙","东","欧",""
						+ "殳","沃","利","蔚","越","夔","隆","师","巩","厍","聂","晁","勾","敖","融",""
						+ "冷","訾","辛","阚","那","简","饶","空","曾","毋","沙","乜","养","鞠","须",""
						+ "丰","巢","关","蒯","相","查","后","荆","红","游","郏","竺","权","逯","盖",""
						+ "益","桓","公","仉","督","岳","帅","缑","亢","况","郈","有","琴","归","海",""
						+ "晋","楚","闫","法","汝","鄢","涂","钦","商","牟","佘","佴","伯","赏","墨",""
						+ "哈","谯","篁","年","爱","阳","佟","言","福","南","火","铁","迟","漆","官",""
						+ "冼","真","展","繁","檀","祭","密","敬","揭","舜","楼","疏","冒","浑","挚",""
						+ "胶","随","高","皋","原","种","练","弥","仓","眭","蹇","覃","阿","门","恽",""
						+ "来","綦","召","仪","风","介","巨","木","京","狐","郇","虎","枚","抗","达",""
						+ "杞","苌","折","麦","庆","过","竹","端","鲜","皇","亓","老","是","秘","畅",""
						+ "邝","还","宾","闾","辜","纵","侴","万俟","司马","上官","欧阳","夏侯","诸葛","闻人","东方",""
						+ "赫连","皇甫","羊舌","尉迟","公羊","澹台","公冶","宗正","濮阳","淳于","单于","太叔","申屠","公孙","仲孙",""
						+ "轩辕","令狐","钟离","宇文","长孙","慕容","鲜于","闾丘","司徒","司空","兀官","司寇","南门","呼延","子车",""
						+ "颛孙","端木","巫马","公西","漆雕","车正","壤驷","公良","拓跋","夹谷","宰父","谷梁","段干","百里","东郭",""
						+ "微生","梁丘","左丘","东门","西门","南宫","第五","公仪","公乘","太史","仲长","叔孙","屈突","尔朱","东乡",""
						+ "相里","胡母","司城","张廖","雍门","毋丘","贺兰","綦毋","屋庐","独孤","南郭","北宫","王孙"};
		
		int index = random.nextInt(firstName.length-1);				
		return firstName[index];
	}
	
	/**
	 * 获取名
	 * @return 返回名
	 */
	public String getName() {		
		String str = null;		
		int highPos, lowPos;		
		Random random = new Random();		
		highPos = (176 + Math.abs(random.nextInt(71)));//区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字		
		random=new Random();		
		lowPos = 161 + Math.abs(random.nextInt(94));//位码，0xA0打头，范围第1~94列		
		byte[] bArr = new byte[2];		
		bArr[0] = (new Integer(highPos)).byteValue();		
		bArr[1] = (new Integer(lowPos)).byteValue();		
		try 
		{			
			str = new String(bArr, "GB2312");	//区位码组合成汉字		
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();		
		}			
		return str;	
	}
	
	/**
	 * 获取姓名
	 * @return 姓名
	 */
	public String getFullName(){
		
		Random random = new Random();
		String fullName = "";
		/* 从常用字中选取一个或两个字作为名 */		
		if(random.nextBoolean()){			
			fullName += getFirstName() + getName() + getName();		
		}
		else{
			fullName += getFirstName() + getName();		
		}
		return fullName;
	}
	
	/****************************身份证号号生成器****************************/
	
	/*
	 * 身份证号生成类
	 * 
	 * @author 江渤洋
	 * @version 1.0.0.0417, 2015-04-17
	 * 
	 * 备注：此类中使用StringBuilder，单线程，非线程安全
	 */

	/*
	 * 18位身份证验证
	 * 根据〖中华人民共和国国家标准 GB 11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
	 * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
	 * 第十八位数字(校验码)的计算方法为：                                                                                         1 1  0 1 0 5 1 9 8 7 1 2  2 2 1 5 1
	 * 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
	 * 2.将这17位数字和系数相乘的结果相加。
	 * 3.用加出来和除以11，看余数是多少？
	 * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
	 * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
	 */
	Calendar calendar = Calendar.getInstance();
	
	public static Map<String, Integer> areaCode = new HashMap<String, Integer>();
	
	/*
	 * 拼接身份证号
	 */
	public String idConcatenation()
	{
		StringBuilder stringBuilder = new StringBuilder();
//		System.out.println(randomAreaCode());
		stringBuilder.append(randomAreaCode());
//		System.out.println(stringBuilder.toString());
		
//		System.out.println(randomBirthday());
		stringBuilder.append(randomBirthday());
//		System.out.println(stringBuilder.toString());
		
//		System.out.println(randomCode());
		stringBuilder.append(randomCode());
//		System.out.println(stringBuilder.toString());
		
//		System.out.println(lastNumber(stringBuilder.toString().toCharArray()));
		stringBuilder.append(lastNumber(stringBuilder.toString().toCharArray()));
		return stringBuilder.toString();
	}
	
	/*
	 * 获取地区代码
	 */
	public String randomAreaCode()
	{
		int code = 0;
		
		int index = -1;
		
		//areaCode.size()应该-1，但是random()获取0~1之间的数，乘以2后无法获取0~2之间的数，只能乘以3来获取0~2之间的数
		//Map是无需的，愁死我了
		index = (int)(Math.random()*(areaCode.size()));
		
		Collection<Integer> collection = areaCode.values();
		
		Iterator<Integer> iterator = collection.iterator();
		
		for(int i=0;i<=index && iterator.hasNext();i++)
		{
			code = iterator.next();
		}
		
		return code + "";
	}
	
	/*
	 * 获取身份证年
	 */
	public int randomYear()
	{
		//年龄范围是18~80岁
		int age = 80;
		//获取距离现在时间相差80年的时间
		//System.out.println("当前年： "+calendar.get(Calendar.YEAR));
		int nowYear = calendar.get(Calendar.YEAR);
		int modernYear = calendar.get(Calendar.YEAR)-age;
		//设置日历的最早日期
		calendar.set(Calendar.YEAR,(int)(Math.random()*61+1) + modernYear);
		//获取年份
		int year = calendar.get(Calendar.YEAR);
		//
		calendar.set(Calendar.YEAR,nowYear);
		return year;
	}
	
	/*
	 * 获取身份证月
	 */
	public int randomMonth()
	{
		calendar.set(Calendar.MONTH, (int)(Math.random()*11+1));
		int month = calendar.get(Calendar.MONTH)+1;
		return month;
	}
	
	/*
	 * 获取身份证日
	 */
	public int randomDay(int year,int month){
		
		int day = -1;
		
		if(month==2){
			//闰年，2月29日
			//四年一闰，百年不闰，四百年再闰
			if((year%4==0 && year%100!=0)||year%400==0){
				calendar.set(Calendar.DATE, (int)(Math.random()*28+1));
				day = calendar.get(Calendar.DATE);
			}
			//平年，2月28日
			else{
				calendar.set(Calendar.DATE, (int)(Math.random()*27+1));
				day = calendar.get(Calendar.DATE);
			}
		}
		else if(month==4 || month==6 || month==9 || month==11){
			calendar.set(Calendar.DATE, (int)(Math.random()*29+1));
			day = calendar.get(Calendar.DATE);
		}
		//一三五七八十腊，三十一天永不差
		else{
			calendar.set(Calendar.DATE, (int)(Math.random()*30+1));
			day = calendar.get(Calendar.DATE);
		}

		return day;
	}
	
	/*
	 * 获取身份证生日
	 */
	public String randomBirthday(){

		int year = randomYear();
		int month = randomMonth();
		int day = randomDay(year,month);
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(year);
		if(month<10){stringBuilder.append("0");}
		stringBuilder.append(month);
		if(day<10){stringBuilder.append("0");}
		stringBuilder.append(day);
				
		return stringBuilder.toString();
	}
	
	/*
	 * 获取身份证倒数2~4位随机码
	 */
	public String randomCode()
	{
		int randomCode = (int)(Math.random()*999);
		
		if(randomCode<10)
		{
			return "00" + randomCode;
		}
		else if(randomCode<100)
		{
			return "0" + randomCode;
		}
		else{
			return "" + randomCode;
		}
	}
	
	/*
	 * 获取身份证最后一位
	 */
	//系数：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
	//余数：                                     0 1 2 3 4 5 6 7 8 9 10
	//对应余数的身份证最后1位:1 0 X 9 8 7 6 5 4 3 2
	public String lastNumber(char seventeenCharArray[]){
		//char seventeenCharArray[] = {'1','1','0','1','0','5','1','9','8','7','1','2','2','2','1','5','1'};
		
		//添加判断上传字符数组为空的情况？？？？？？？？？？？？？？？？？？？？？？？？
		
		//与系数相乘后的和
		int sum = 0;
		//身份证前17位的int数组
		int seventeenIntArray[] = new int[17];
		//系数数组
		int xiShu[] = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		//对应余数的身份证最后1位int数组
		char lastNum[] = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
		
		//将前17位   字符数组   转化为   数字数组
		for(int i=0;i<seventeenCharArray.length;i++)
		{
			//字符数组转化整型数组是已经去处“0”，或者写成((int)(seventeenCharArray[i]-'0')) * xiShu[i]即可
			seventeenIntArray[i] = Integer.parseInt(seventeenCharArray[i]+"");
		}

		//17位身份证号  * 对应系数  求和
		for(int i=0;i<seventeenIntArray.length;i++)
		{
			sum += (seventeenIntArray[i] * xiShu[i]);
		}
		
		//返回  “和” 对11取余 返回 对应字符 
		return lastNum[sum%11]+"";
	}
	
	
	/*
	 * 获取身份证地区代码
	 */
	static
	{
		//北京
		areaCode.put("北京市", 110000);
		areaCode.put("市辖区", 110100);
		areaCode.put("东城区", 110101);
		areaCode.put("西城区", 110102);
		areaCode.put("崇文区", 110103);
		areaCode.put("宣武区", 110104);
		areaCode.put("朝阳区", 110105);
		areaCode.put("丰台区", 110106);
		areaCode.put("石景山区", 110107);
		areaCode.put("海淀区", 110108);
		areaCode.put("门头沟区", 110109);
		areaCode.put("房山区", 110111);
		areaCode.put("通州区", 110112);
		areaCode.put("顺义区", 110113);
		areaCode.put("昌平区", 110114);
		areaCode.put("大兴区", 110115);
		areaCode.put("怀柔区", 110116);
		areaCode.put("平谷区", 110117);
		areaCode.put("县", 110200);
		areaCode.put("密云县", 110228);
		areaCode.put("延庆县", 110229);
	}
	
	public static void main(String args[]){
		Data data = new Data();
		System.out.println(data.phoneConcatenation(3));
		System.out.print(data.idConcatenation());
	}
}
