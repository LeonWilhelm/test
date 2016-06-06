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
	
	/******************************���ɻ�����ע���˻�*************************************/
	public static String email = data.emailConcatenation(0,2);
	public static String email2 = data.emailConcatenation(0,2);
	public static String tel = data.phoneConcatenation(0);//������
	public static String realName = "���";
	public static String tel2 = data.phoneConcatenation(0);//Ͷ����2
	public static String realName2 = "�޺�ѩ";
	public static String tel3 = data.phoneConcatenation(0);//Ͷ����3
	public static String password = "111111";
	
	public static String zzmm = "111111";//֧������
	//xty
	public static String tel_run_debit2 = "13111122280";//�����  �����ȷ�Ͻ�����ܵ�
	public static String realName_run_debit2 = "������";
	public static String email_run_debit2 = "13111111171@qq.com";
	public static String idCard_run_debit2 = "11011519620715562X";
	//public static String tel_run_credit = "13111111153";//Ͷ����  ��Ǯ
	public static String tel_run_DebentureTransfer = "13632917617";//����ר��Ͷ��  Ͷ������10000(ԭ�˺ţ�13689802284)
	public static String idCard_run_credit = "11011519620715561X";
    public static String newUser ="13111111158";//�������ֱ��û�
	//jby
	public static String tel_run_EcunBao = "13800138002";//��汦 13111111155
	public static String tel_run_MyAccount = "13581569929";//�ҵ��˻�
	public static String name_run_MyAccount = "������";//�ҵ��˻����� 
	public static String id_run_MyAccount = "11010519850423007X";//�ҵ��˻����֤
	//lj
	public static String tel_run_zhaiquan1 = "13111111201";
	public static String tel_run_zhaiquan2 = "13111111169";		//������
	
	/*****************P1*******************/
	//ECunBao_P1>>>>>>>>>>>>>>>>>>>>>>>>
	//jby
	public static String run_ECunBao_99 = "13111111188";//�˻�����100
	public static String run_ECunBao_register = "13111111177";//δ��Ǯ�û�Ͷ�� ��ע���ֻ��û�
	public static String run_ECunBao_oldtel = "13111111141";//δ��Ǯ�û�Ͷ�� ���ֻ��û�
	public static String run_ECunBao_oldemail = "123@126.com";//δ��Ǯ�û�Ͷ�� �������û�
	public static String ECunBao_Normal_tel = "13581567705";  //��ͨ�û�
	public static String ECunBao_VIP10_tel  = "13581567706";  //VIP1.0�û�   ����̨������汦��ǰֱ̨�ӹ��򼴿ɡ������
	public static String ECunBao_VIP15_tel  = "13581567707";  //VIP1.5�û�   ����̨������汦��ǰֱ̨�ӹ��򼴿ɡ������

	//xty
	public static String tel_eCunBao_P1 = "13111111240";
	//public static String tel_securityAuth_P1 = "13111111241";
	
	/*****************P2*******************/
	public static String tel_balance_49 = "13111111202";//�˻�49Ԫ  ɢ��Ͷ��-Ͷ�ʴ���-�Զ�����
	public static String tel_balance_50 = "13111111203";//�˻�50Ԫ  ɢ��Ͷ��-Ͷ�ʴ���-�Զ�����
	public static String tel_investmentList_P2 = "13111111239";
	//��������汦
	public static String tel_ExperienceNoInterest_client = "13581568811"; //�������ڵ��û�����Ч��Ϊһ���£����ڻ��ţ� 13581568800
	public static String tel_ExperienceInterest_client = "13581567600"; //�ѹ�����������汦������ʼ��Ϣ
	public static String email_ExperienceInterest_client = "13581567600@163.com";
	public static String tel_ExperienceNoInterest_test = ""; //�������ڵ��û�����Ч��Ϊһ���£����ڻ��ţ�
	public static String tel_ExperienceInterest_test = ""; //�ѹ�����������汦������ʼ��Ϣ
	public static String email_ExperienceInterest_test = "";
	
	public static String email_MyAccountP2 = "13581567702@163.com";//�ֻ�δע��������û�
	public static String client_tel_new = "13581568700"; //���ֻ�ע���û�
	public static String client_tel_old = "13581568701"; //���ֻ�ע���û�
	public static String tel_change = "13581567703";
	public static String tel_noChange = "13581567699";
	//������-lj
	public static String tel_Loan = "13011887694";										//���ɡ�������������û�
	public static String tel_Loan_Name= "��ޱ";
	public static String tel_Loan_PayPwd="111111";
	public static String tel_Loan_idCard="34020419760312152X";
	//����������
	public static String tel_LBDCreaterLoan= "13581838716";
	public static String tel_LBDCreaterName="�߽�ѫ";
	public static String tel_LBDNoncreaterLoan ="13581838717";
	public static String tel_LBDNoncreaterName="���׸�";
	
	//Ͷ��-lj
	public static String tel_Invest = "13011879174";//ҪͶ��ɢ��
	public static String tel_Invest_Name="����";
	public static String tel_Invest_PayPwd="111111";
	public static String tel_Invest_idCard="360103197807124724";
	//Ͷ���б�
//	public static String tel_old_user = "13581838716";	//δ��Ǯ�û�Ͷ�� ���ֻ��û�
//	public static String email_old_user = "ligen65@qq.com";	//δ��Ǯ�û�Ͷ�� �������û�
	
	/******************************Ԥ���߻������˻�*************************************/
	//������ע��debit>>>>>>>>>>>>>>>>>>>>>>>>
	public static String test_register_debit_tel = "13011874514";//�ֻ���
	public static String test_register_debit_realName = "�ܶ�ֿ";//��ʵ����
	public static String test_register_debit_idCard = "210181198803168317";
	
	//Ͷ����ע��credit>>>>>>>>>>>>>>>>>>>>>>>>
	public static String test_register_credit_tel = "13011885149";//�ֻ���
	public static String test_register_credit_realName = "����ɽ";//��ʵ����
	public static String test_register_credit_idCard = "150430198611211499";
	
	//testר�ú� 18880000200>>>>>>>>>>>>>>>>>
	public static String test_tel = "18880000200";//�ֻ���
	public static String test_password = "111111";//����
	public static String test_realName = "����";//��ʵ����
	public static String test_idCard = "420400197512034215";//���֤��
	public static String test_zzmm = "yqlxzh";//ת������
	public static String test_email = "eloanxn200@eloancn.com";//����
	
	//testר�ú�2  δ�����֤   18880000199>>>>>>>>
	public static String test2_tel = "18880000199";//�ֻ���
	public static String test2_password = "111111";//����
	public static String test2_realName = "����֮";//��ʵ����
	public static String test2_idCard = "440607197510046801";//���֤��
	public static String test2_zzmm = "yqlxzh";//ת������
	public static String test2_email = "eloanxn199@eloancn.com";//����
	
	//testר�ú�3  δ�����֤   18880000198>>>>>>>>
	public static String test3_tel = "18880000198";//�ֻ���
	public static String test3_password = "111111";//����
	public static String test3_realName = "�ܺ޺�";//��ʵ����
	public static String test3_idCard = "360425199009155028";//���֤��
	public static String test3_zzmm = "yqlxzh";//ת������
	public static String test3_email = "eloanxn198@eloancn.com";//����
	
	//testר�ú�4  �������֤   18880000197>>>>>>>>
	public static String test4_tel = "18880000197";//�ֻ���
	public static String test4_password = "111111";//����
	public static String test4_realName = "������";//��ʵ����
	public static String test4_idCard = "110101194206062035";//���֤��
	public static String test4_zzmm = "yqlxzh";//ת������
	public static String test4_email = "eloanxn197@eloancn.com";//����
	
	/*****************P1*******************/
	//ECunBao_P1>>>>>>>>>>>>>>>>>>>>>>>>
	public static String test_run_ECunBao_register = "13810367911";//δ��Ǯ�û�Ͷ�� ��ע���ֻ��û�
	public static String test_run_ECunBao_oldtel = "15011514888";//δ��Ǯ�û�Ͷ�� ���ֻ��û�
	public static String test_run_ECunBao_oldemail = "ff@qq.com";//δ��Ǯ�û�Ͷ�� �������û�
	//Register_P1>>>>>>>>>>>>>>>>>>>>>>>>
	public static String test_run_Register_tel = "13011885141";
	//MyAccount_P1
	public static String test_tel_run_MyAccount = "13011887854";

	/*****************P2*******************/
	//Ͷ���б�InvestmentList_P2>>>>>>>>>>>>>>>>>>>>>>>>
	public static String[] defaultPlaces = {"����","����","�Ϻ�","����","�ɶ�","����"};//Ĭ�ϵ���
	
	//�ҵ��˻�
	public static String test_myAccount_P2_tel = "13011887724";//�������֤
	
	/*****************��ȫ��֤*******************/
	public static String test_run_SecurityAuth_P1_tel = "13011887642";
	public static String test_run_SecurityAuth_P1_realName = "�����";
	public static String test_run_SecurityAuth_P1_idCard = "140105198412063716";
	
	public static String test_run_SecurityAuth_P3_tel1 = "13011887469";
	public static String test_run_SecurityAuth_P3_tel2 = "13011879450";
	public static String test_run_SecurityAuth_P3_realName2 = "����";
	public static String test_run_SecurityAuth_P3_idCard2 = "510106197904075116";
	public static String test_run_SecurityAuth_P3_tel3 = "13011879452";
	public static String test_run_SecurityAuth_P3_tel4 = "13011873604";
	public static String test_run_SecurityAuth_P3_realName4 = "����";
	public static String test_run_SecurityAuth_P3_idCard4 = "320283199109253237";
	public static String test_run_SecurityAuth_P3_tel5 = "13011876149";
	public static String test_run_SecurityAuth_P3_realName5 = "�ű�";
	public static String test_run_SecurityAuth_P3_idCard5 = "142401198402112118";
	public static String test_run_SecurityAuth_P3_tel6 = "13011884785";
	public static String test_run_SecurityAuth_P3_realName6 = "ŷ����ƽ";
	public static String test_run_SecurityAuth_P3_idCard6 = "431126198901137618";
	public static String test_run_SecurityAuth_P3_tel8 = "13011873524";
	public static String test_run_SecurityAuth_P3_realName8 = "�����";
	public static String test_run_SecurityAuth_P3_idCard8 = "130625198505032012";
	public static String test_run_SecurityAuth_P3_tel9 = "13011884752";
	public static String test_run_SecurityAuth_P3_realName9 = "�����";
	public static String test_run_SecurityAuth_P3_idCard9 = "330326198605254314";
	public static String test_run_SecurityAuth_P3_tel11 = "13011884709";
	public static String test_run_SecurityAuth_P3_tel12 = "13011871482";
	public static String test_run_SecurityAuth_P3_realName12 = "��Ӣ��";
	public static String test_run_SecurityAuth_P3_idCard12 = "450324198803131918";
	public static String test_run_SecurityAuth_P3_tel13_1 = "13011887944";
	public static String test_run_SecurityAuth_P3_realName13_1 = "������";
	public static String test_run_SecurityAuth_P3_idCard13_1 = "211022198107120016";
	public static String test_run_SecurityAuth_P3_tel13_2 = "13011887874";
	public static String test_run_SecurityAuth_P3_realName13_2 = "������";
	public static String test_run_SecurityAuth_P3_idCard13_2 = "510107199009111817";
	public static String test_run_SecurityAuth_P3_tel13_3 = "13011885384";
	public static String test_run_SecurityAuth_P3_realName13_3 = "�μѿ�";
	public static String test_run_SecurityAuth_P3_idCard13_3 = "513401198004215517";
	
	
	/********************************��������******************************************/
	public static String bankAccount = "622848181113360";//ԭ���ݣ�622848181113333
	public static String[] names = {"��һ","���","����","����","����","����"};
	public static String[] tels = data.getTels();//{"13145458001","13145458002","13145458003","13145458004","13145458005","13145458006"};

    //��ҳbanner��ͼ������title
	public static String[] banners_client = {"��˫ʮ����ȫ��񻶣�����7�� ���׬��-�ר��-��������̳ - ������",
											 "���200�ڻ��ÿ�ս���100����ͷ������5��Ԫ-�ר��-��������̳ - ������",
											 "����������淨-����������������õ�ˬ-�ר��-��������̳ - ������",
											 "���ֵ��ٳ��֣���汦�����Ϣһ���£���������꣡-�ר��-��������̳ - ������",
											 "�����������APP|Ͷ���ֻ��ͻ���iPhone/Android�����ء�������",
											 "��5��11������һ�������������汨������������-������",
											 "��������������-������"};
	public static String[] banners_test   = {
											 "��ֵ7000Ԫ�ĺ�������װ������ݺ������ͣ��ȵ��ȵ�-�ר��-��������̳ - ������",
											 "С����˾�����ļҺã�-�������������",
											 "����ͬ����������Ƽ����޹�˾2016������Ƹ��Ϣ_��ַ_�绰-��Ƹ��ҵ��Ϣ",
											 "����������������������ƶ֮�����������ݱ������-���¶�̬-��������̳ - ������",
											 "����ʱ��|վ��ũ����ӽ� ��ũҵ��δ����չ-���¶�̬-��������̳ - ������",
											 "���塱����֪����������Ͷ���˿����գ������У�-���¶�̬-��������̳ - ������",
											 "2016��õĿ��ˣ�������1�·���Ӫ�����¯��-���¶�̬-��������̳ - ������"
											 };
	/******************************���ɻ����ĺ�̨�˻�*************************************/
	
	//֪ͨ��
	public static String noticeCode = "4000292886d";
	//�ܲ��û���
	public static String headquartersUserName1 = "jby1";
	public static String headquartersUserName2 = "jby2";
	public static String headquartersUserName3 = "jby3";
	//�������û���
	public static String allianceBusinessUserName1 = "jby_1";
	public static String allianceBusinessUserName2 = "jby_2";
	public static String allianceBusinessUserName3 = "jby_3";
	//���������̣�һ���ܲ�
	public static String userNameArray[] = {"jby_1", "jby_2", "jby_3", "jby1"};
//	public static String userNameArray[] = {"xty_1", "xty_2", "xty_3", "xty1"};
//	public static String userNameArray[] = {"lj_1", "lj_2", "lj_3", "lj1"};

	//�����̻��ܲ���ȷ������
	public static String passwordByBack = "eloancn888";
	//���������
	public static String borrowerName = "�û���";
	//���������
	public static String borrowerEmail = "yh2@11.com";
	//����������
	public static String lendEmail = "mgr06@t01.com";
	//�����_ǰ̨  | �����_��̨ ��ǰ̨���>=��̨����Ϊ100����������10�������ڲ����ظ���
	public static String loanAmount = "15900";
	public static String loanAmount2 = "16000";
	public static String loanAmount_Fail = "15600";
	
	/**************************************************************************/
	/**
	 * �������п���
	 */
	public String getBank(){
		String bank = "62284818";
		bank += (int)(Math.random()*10000000); 
		return bank;
	}
	
	/**
	 * ����Ԫ
	 * ������ϵ���ֻ���
	 */
	public String[] getTels(){
		String[] telphones = new String[6];
		for (int i = 0; i < telphones.length; i++) {
			telphones[i] = phoneConcatenation(0);
//			logger.info("������ϵ��"+i+"��"+telphones[i]);
			Reporter.log("������ϵ��"+i+"��"+telphones[i]+"<br/>");
		}
		return telphones;
	}
	
	/********************************��ȡ��֤��*******************************************/
	/**
	 * 
	 * @param 
	 * @param 
	 * @return
	 * @author 
	 */
	@Deprecated
	public String get(WebElement yanZhengMa,WebDriver webDriver){
		//��ȡ��֤��
		//WebElement yanZhengMa = webDriver.findElement(By.xpath("//img[contains(@src,'/randCode')]"));
		Actions action = new Actions(webDriver);
		//�Ҽ�������֤��
		action.contextClick(yanZhengMa).build().perform();
		base.sleep(2000);
		//IE  chrome  firefox
		Screen screen = new Screen();
		String curPath = new File("").getAbsolutePath();//��ǰ·��
		String webdriver = base.getWebDriver().toString();
		String edition = base.getBrowserEdition();
		if (webdriver.contains("InternetExplorerDriver")){
			screen.type("S");
		}else if(webdriver.contains("FirefoxDriver")){
			//ʹ�ÿ�ݼ�"Shift + Alt + v"
			action.keyDown(Keys.SHIFT);
			action.keyDown(Keys.ALT).sendKeys("V").perform();
			action.keyUp(Keys.SHIFT);
			action.keyUp(Keys.ALT);
		}
		else {
			screen.type("V");
		}
		base.sleep(3000);

		//����AutoIt ��д�Ľű�
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
		
		//ͼƬ�ļ���ַ 
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
        System.out.println("ORC Test Begin......");//-----------------����  
        String codeString = "";
        try {   
        	//��ȡ��չ��Ϊ"jpg"ͼƬ�ļ�������
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
        //������֤��
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
        System.out.println("ORC Test End......");//-----------------����   
        return codeString.replace(" ", "");
	}
	
	/**
	 * ͼƬ�ļ�ת��Ϊtif��ʽ 
     * @param imageFile ��ȡԴͼƬ·�� 
     * @param imageFormat ��ȡͼƬ��ʽ 	 
     * @return
	 * @author 
	 */
	public static File createImage(File imageFile, String imageFormat) {    
        File tempFile = null;    
        try {    
        	//��ȡһ��ͼƬ�ļ�
            Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(imageFormat);    
            ImageReader reader = (ImageReader) readers.next();    
            //����ͼƬ����·��
            ImageInputStream iis = ImageIO.createImageInputStream(imageFile);    
            reader.setInput(iis);    
            //��ȡԪ���ݣ���ͼ���ʽֻ��һ��ͼ��ʱ������ʹ��Ԫ���ݣ�
            IIOMetadata streamMetadata = reader.getStreamMetadata();    
                
            //Set up the writeParam    
            TIFFImageWriteParam tiffWriteParam = new TIFFImageWriteParam(Locale.CHINESE);    
            tiffWriteParam.setCompressionMode(ImageWriteParam.MODE_DISABLED);    
                
            //Get tif writer and set output to file    
            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("tiff");    
            ImageWriter writer = (ImageWriter) writers.next();    
                
            BufferedImage bi = reader.read(0);    //��ȡ��һ��ͼƬ
            IIOImage image = new IIOImage(bi,null,reader.getImageMetadata(0));   //�洢ͼ��Ԫ���� 
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
    
    private final String LANG_OPTION = "-l";  //Ӣ����ĸСдl����������1    
    private final String EOL = System.getProperty("line.separator");  
    //�����㰲װ��OCR��·��
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
            
        //ɾ����ʱ���ڹ����ļ�    
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
    
	/********************************�����������*******************************************/
    
	//�û����ĳ���(3-16λ)
	/*
	 * 0���������ⳤ�ȣ�3:������3��֮���Դ�����
	 */
	public int getUserNameLength(int length)
	{
		//��󳤶�
		int maxLength = length;
		//�������Ϊ0�����������3-16��
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
	
	//�û���������ĸ
	public char getCharacter(){
		char englishChar=(char)(int)(Math.random() * 26 + 97);
		return englishChar;
	}
	//�û�����������
	public char getNum()
	{
		int numInt = (int)(Math.random() * 9);
		String numString = String.valueOf(numInt);
		char numChar = numString.charAt(0);
		return numChar;
	}
	
	//�ʼ�������
	public String getEmailDoMain(){
		String doMainArray[] = {"163.com","126.com","188.com","yeah.net","sina.com","sohu.com","tom.com","gmail.com","qq.com","263.net","qq.com"};
		int index = (int)(Math.random() * (doMainArray.length-1));
		return doMainArray[index];
	}
	
	/*
	 * length  0���������ⳤ�ȣ�3:������3��֮���Դ�����
	 * sign 0����ĸ,1�����֣�2����ĸ+����
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
			return "��������ϴ���";
		}
	}
	
	/********************************��������ֻ���*******************************************/
	
	//�ֻ����붼�ǰ�����Ӫ�̺͵������滮�ģ�ǰ3λ����Ӫ�̵Ĵ��롢�м�4λ�ǹ����ش��롢��4λ���û�����
	//�ƶ��Ŷ� - 0���� - 16����������http://service.bj.10086.cn/phone/jxhsimcard/gotone_list.html��
	String mobileArray[] = {"139","138","137","136","135","134","188","187","183","182","159","158","157","152","151","150"};
	//��ͨ�Ŷ�- 1���� - 8����http://num.10010.com/NumApp/chseNumList/init��
	String unicomArray[] = {"186","185","176","156","155","132","131","130"};
	//���źŶ�- 2���� - 6����������http://www.189.cn/?cmpid=jt-ppc-baidu-am-ppzq-home#��
	String telecomArray[] = {"189","181","180","177","153","133"};
	
	int mobileLength = mobileArray.length;
	int unicomLength = unicomArray.length;
	int telecomLength = telecomArray.length;
	
	/*
	 * ��ȡ��˾�Ŷ�
	 */
	public String getCompany(int companyName){
		//�ƶ�
		if(companyName == 0){
			//��������0~15֮�����
			return mobileArray[(int)(Math.random() * mobileLength)];
		}
		//��ͨ
		else if(companyName == 1){
			//��������0~7֮�����
			return unicomArray[(int)(Math.random() * unicomLength)];
		}
		//����
		else if(companyName == 2){
			//��������0~5֮�����
			return telecomArray[(int)(Math.random() * telecomLength)];
		}
		//�ƶ� �� ��ͨ �� ���������ȡ
		else{
			int temp = -1;
			//���ֵΪ0��1��2
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
	 * ��ȡ�����Ŷ�
	 */
	public String getAreaCode(){
		String areaCode = ""; 
		//ѭ�����ɵ����ţ�ֱ������Ϊ4
		while(true){
			//����0~9999֮�����
			areaCode = Integer.toString((int)(Math.random() * 10000));
			//����Ϊ4ʱ����
			if(areaCode.length()==4){
				return areaCode;
			}
		}
	}
	
	/*
	 * ��ȡ��λ�������
	 */
	public String getUserCode(){
		String userCode = ""; 
		//ѭ����������ţ�ֱ������Ϊ4
		while(true){
			//����0~9999֮�����
			userCode = Integer.toString((int)(Math.random() * 10000));
			//����Ϊ4ʱ����
			if(userCode.length()==4){
				return userCode;
			}
		}
	}
	
	/*
	 * ƴ���ֻ�����
	 */
	public String phoneConcatenation(int companyName){
		StringBuilder phoneStringBuilder = new StringBuilder();
		phoneStringBuilder.append(this.getCompany(companyName));
		phoneStringBuilder.append(this.getAreaCode());
		phoneStringBuilder.append(this.getUserCode());
		return phoneStringBuilder.toString();
	}
	
	/*****************************�����������******************************/
	
	/**
	 * ��ȡ��
	 * @return ��
	 */
	public String getFirstName(){
		Random random = new Random();
		/* 598 �ټ��� */		
		String[] firstName= {"��","Ǯ","��","��","��","��","֣","��","��","��","��","��","��","��","��",""
						+ "��","��","��","��","��","��","��","ʩ","��","��","��","��","��","��","κ",""
						+ "��","��","��","л","��","��","��","ˮ","�","��","��","��","��","��","��",""
						+ "��","��","��","³","Τ","��","��","��","��","��","��","��","��","Ԭ","��",""
						+ "ۺ","��","ʷ","��","��","��","�","Ѧ","��","��","��","��","��","��","��",""
						+ "��","��","��","��","��","��","��","ʱ","��","Ƥ","��","��","��","��","��",""
						+ "Ԫ","��","��","��","ƽ","��","��","��","��","��","Ҧ","��","տ","��","��",""
						+ "ë","��","��","��","��","��","�","��","��","��","��","̸","��","é","��",""
						+ "��","��","��","��","��","ף","��","��","��","��","��","��","ϯ","��","��",""
						+ "ǿ","��","·","¦","Σ","��","ͯ","��","��","÷","ʢ","��","��","��","��",""
						+ "��","��","��","��","��","��","��","��","��","��","��","��","֧","��","��",""
						+ "��","¬","Ī","��","��","��","��","��","��","Ӧ","��","��","��","��","��",""
						+ "��","��","��","��","��","��","��","ʯ","��","��","ť","��","��","��","��",""
						+ "��","��","½","��","��","��","��","��","��","��","��","��","��","��","��",""
						+ "��","��","��","��","��","��","��","��","��","��","��","��","��","��","��",""
						+ "��","ɽ","��","��","��","�","��","ȫ","ۭ","��","��","��","��","��","��",""
						+ "��","��","��","��","��","��","��","��","��","��","��","��","��","ղ","��",""
						+ "��","Ҷ","��","˾","��","۬","��","��","��","ӡ","��","��","��","��","ۢ",""
						+ "��","��","��","��","��","��","׿","��","��","��","��","��","��","��","��",""
						+ "��","��","˫","��","ݷ","��","��","̷","��","��","��","��","��","��","��",""
						+ "Ƚ","��","۪","Ӻ","ȴ","�","ɣ","��","�","ţ","��","ͨ","��","��","��",""
						+ "��","��","��","ũ","��","��","ׯ","��","��","��","��","��","Ľ","��","��",""
						+ "ϰ","��","��","��","��","��","��","��","��","��","��","��","��","��","��",""
						+ "��","��","��","��","��","��","��","��","��","��","��","»","��","��","ŷ",""
						+ "�","��","��","ε","Խ","��","¡","ʦ","��","��","��","��","��","��","��",""
						+ "��","��","��","��","��","��","��","��","��","��","ɳ","ؿ","��","��","��",""
						+ "��","��","��","��","��","��","��","��","��","��","ۣ","��","Ȩ","��","��",""
						+ "��","��","��","��","��","��","˧","��","��","��","�C","��","��","��","��",""
						+ "��","��","��","��","��","۳","Ϳ","��","��","Ĳ","��","٦","��","��","ī",""
						+ "��","��","��","��","��","��","١","��","��","��","��","��","��","��","��",""
						+ "��","��","չ","��","̴","��","��","��","��","˴","¥","��","ð","��","ֿ",""
						+ "��","��","��","��","ԭ","��","��","��","��","��","�","��","��","��","�",""
						+ "��","��","��","��","��","��","��","ľ","��","��","ۨ","��","ö","��","��",""
						+ "�","��","��","��","��","��","��","��","��","��","��","��","��","��","��",""
						+ "��","��","��","��","��","��","�G","��ٹ","˾��","�Ϲ�","ŷ��","�ĺ�","���","����","����",""
						+ "����","�ʸ�","����","ξ��","����","�̨","��ұ","����","���","����","����","̫��","����","����","����",""
						+ "��ԯ","���","����","����","����","Ľ��","����","����","˾ͽ","˾��","أ��","˾��","����","����","�ӳ�",""
						+ "���","��ľ","����","����","���","����","����","����","�ذ�","�й�","�׸�","����","�θ�","����","����",""
						+ "΢��","����","����","����","����","�Ϲ�","����","����","����","̫ʷ","�ٳ�","����","��ͻ","����","����",""
						+ "����","��ĸ","˾��","����","Ӻ��","����","����","����","��®","����","�Ϲ�","����","����"};
		
		int index = random.nextInt(firstName.length-1);				
		return firstName[index];
	}
	
	/**
	 * ��ȡ��
	 * @return ������
	 */
	public String getName() {		
		String str = null;		
		int highPos, lowPos;		
		Random random = new Random();		
		highPos = (176 + Math.abs(random.nextInt(71)));//���룬0xA0��ͷ���ӵ�16����ʼ����0xB0=11*16=176,16~55һ�����֣�56~87��������		
		random=new Random();		
		lowPos = 161 + Math.abs(random.nextInt(94));//λ�룬0xA0��ͷ����Χ��1~94��		
		byte[] bArr = new byte[2];		
		bArr[0] = (new Integer(highPos)).byteValue();		
		bArr[1] = (new Integer(lowPos)).byteValue();		
		try 
		{			
			str = new String(bArr, "GB2312");	//��λ����ϳɺ���		
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();		
		}			
		return str;	
	}
	
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public String getFullName(){
		
		Random random = new Random();
		String fullName = "";
		/* �ӳ�������ѡȡһ������������Ϊ�� */		
		if(random.nextBoolean()){			
			fullName += getFirstName() + getName() + getName();		
		}
		else{
			fullName += getFirstName() + getName();		
		}
		return fullName;
	}
	
	/****************************���֤�ź�������****************************/
	
	/*
	 * ���֤��������
	 * 
	 * @author ������
	 * @version 1.0.0.0417, 2015-04-17
	 * 
	 * ��ע��������ʹ��StringBuilder�����̣߳����̰߳�ȫ
	 */

	/*
	 * 18λ���֤��֤
	 * ���ݡ��л����񹲺͹����ұ�׼ GB 11643-1999�����йع�����ݺ���Ĺ涨��������ݺ�������������룬��ʮ��λ���ֱ������һλ����У������ɡ�
	 * ����˳�������������Ϊ����λ���ֵ�ַ�룬��λ���ֳ��������룬��λ����˳�����һλ����У���롣
	 * ��ʮ��λ����(У����)�ļ��㷽��Ϊ��                                                                                         1 1  0 1 0 5 1 9 8 7 1 2  2 2 1 5 1
	 * 1.��ǰ������֤����17λ���ֱ���Բ�ͬ��ϵ�����ӵ�һλ����ʮ��λ��ϵ���ֱ�Ϊ��7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
	 * 2.����17λ���ֺ�ϵ����˵Ľ����ӡ�
	 * 3.�üӳ����ͳ���11���������Ƕ��٣�
	 * 4.����ֻ������0 1 2 3 4 5 6 7 8 9 10��11�����֡���ֱ��Ӧ�����һλ���֤�ĺ���Ϊ1 0 X 9 8 7 6 5 4 3 2��
	 * 5.ͨ�������֪���������2���ͻ������֤�ĵ�18λ�����ϳ����������ֵĢ������������10�����֤�����һλ�������2��
	 */
	Calendar calendar = Calendar.getInstance();
	
	public static Map<String, Integer> areaCode = new HashMap<String, Integer>();
	
	/*
	 * ƴ�����֤��
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
	 * ��ȡ��������
	 */
	public String randomAreaCode()
	{
		int code = 0;
		
		int index = -1;
		
		//areaCode.size()Ӧ��-1������random()��ȡ0~1֮�����������2���޷���ȡ0~2֮�������ֻ�ܳ���3����ȡ0~2֮�����
		//Map������ģ���������
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
	 * ��ȡ���֤��
	 */
	public int randomYear()
	{
		//���䷶Χ��18~80��
		int age = 80;
		//��ȡ��������ʱ�����80���ʱ��
		//System.out.println("��ǰ�꣺ "+calendar.get(Calendar.YEAR));
		int nowYear = calendar.get(Calendar.YEAR);
		int modernYear = calendar.get(Calendar.YEAR)-age;
		//������������������
		calendar.set(Calendar.YEAR,(int)(Math.random()*61+1) + modernYear);
		//��ȡ���
		int year = calendar.get(Calendar.YEAR);
		//
		calendar.set(Calendar.YEAR,nowYear);
		return year;
	}
	
	/*
	 * ��ȡ���֤��
	 */
	public int randomMonth()
	{
		calendar.set(Calendar.MONTH, (int)(Math.random()*11+1));
		int month = calendar.get(Calendar.MONTH)+1;
		return month;
	}
	
	/*
	 * ��ȡ���֤��
	 */
	public int randomDay(int year,int month){
		
		int day = -1;
		
		if(month==2){
			//���꣬2��29��
			//����һ�򣬰��겻���İ�������
			if((year%4==0 && year%100!=0)||year%400==0){
				calendar.set(Calendar.DATE, (int)(Math.random()*28+1));
				day = calendar.get(Calendar.DATE);
			}
			//ƽ�꣬2��28��
			else{
				calendar.set(Calendar.DATE, (int)(Math.random()*27+1));
				day = calendar.get(Calendar.DATE);
			}
		}
		else if(month==4 || month==6 || month==9 || month==11){
			calendar.set(Calendar.DATE, (int)(Math.random()*29+1));
			day = calendar.get(Calendar.DATE);
		}
		//һ�����߰�ʮ������ʮһ��������
		else{
			calendar.set(Calendar.DATE, (int)(Math.random()*30+1));
			day = calendar.get(Calendar.DATE);
		}

		return day;
	}
	
	/*
	 * ��ȡ���֤����
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
	 * ��ȡ���֤����2~4λ�����
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
	 * ��ȡ���֤���һλ
	 */
	//ϵ����7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
	//������                                     0 1 2 3 4 5 6 7 8 9 10
	//��Ӧ���������֤���1λ:1 0 X 9 8 7 6 5 4 3 2
	public String lastNumber(char seventeenCharArray[]){
		//char seventeenCharArray[] = {'1','1','0','1','0','5','1','9','8','7','1','2','2','2','1','5','1'};
		
		//����ж��ϴ��ַ�����Ϊ�յ����������������������������������������������������
		
		//��ϵ����˺�ĺ�
		int sum = 0;
		//���֤ǰ17λ��int����
		int seventeenIntArray[] = new int[17];
		//ϵ������
		int xiShu[] = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		//��Ӧ���������֤���1λint����
		char lastNum[] = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
		
		//��ǰ17λ   �ַ�����   ת��Ϊ   ��������
		for(int i=0;i<seventeenCharArray.length;i++)
		{
			//�ַ�����ת�������������Ѿ�ȥ����0��������д��((int)(seventeenCharArray[i]-'0')) * xiShu[i]����
			seventeenIntArray[i] = Integer.parseInt(seventeenCharArray[i]+"");
		}

		//17λ���֤��  * ��Ӧϵ��  ���
		for(int i=0;i<seventeenIntArray.length;i++)
		{
			sum += (seventeenIntArray[i] * xiShu[i]);
		}
		
		//����  ���͡� ��11ȡ�� ���� ��Ӧ�ַ� 
		return lastNum[sum%11]+"";
	}
	
	
	/*
	 * ��ȡ���֤��������
	 */
	static
	{
		//����
		areaCode.put("������", 110000);
		areaCode.put("��Ͻ��", 110100);
		areaCode.put("������", 110101);
		areaCode.put("������", 110102);
		areaCode.put("������", 110103);
		areaCode.put("������", 110104);
		areaCode.put("������", 110105);
		areaCode.put("��̨��", 110106);
		areaCode.put("ʯ��ɽ��", 110107);
		areaCode.put("������", 110108);
		areaCode.put("��ͷ����", 110109);
		areaCode.put("��ɽ��", 110111);
		areaCode.put("ͨ����", 110112);
		areaCode.put("˳����", 110113);
		areaCode.put("��ƽ��", 110114);
		areaCode.put("������", 110115);
		areaCode.put("������", 110116);
		areaCode.put("ƽ����", 110117);
		areaCode.put("��", 110200);
		areaCode.put("������", 110228);
		areaCode.put("������", 110229);
	}
	
	public static void main(String args[]){
		Data data = new Data();
		System.out.println(data.phoneConcatenation(3));
		System.out.print(data.idConcatenation());
	}
}
