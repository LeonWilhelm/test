package com.eloancn.shared.pages;

import java.awt.event.KeyEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
/*
 * 正在还款借款的电子借条或投资成功的电子借条
 */
public class ElectronicIOU {

	 Base base = new Base();
	 DBData dbdata = new DBData();
	
	 By PageInfo = By.cssSelector("body>div.showMessageDiv");									//“电子借条”信息
	 By BorrowerName = By.xpath("//div[@class='showMessageDiv']/p[2]");							//“借款人”
	 By LoanPeopleInfo = By.cssSelector("div.showMessageDiv>p");								//“借款人”，“投资人”，“管理人”，“保证人”
	 public static By BorrowAmountTxt = By.xpath("//p[31]");									//
	 By TimeTxt = By.xpath("//p[208]");
	 By ContractNO = By.cssSelector("div.showMessageDiv>p");									//合同编号
	 public static By PDFLnk = By.xpath("//body/p[1]/a[1]");											//""
	 //投资的电子借条
	 By PdfDescriptionTxt = By.id("pdf2word");											//pdf行描述
	 public static By TitleTxt = By.xpath("//font");												//"网络借款电子借条"标题
	 By ContractAndDate = By.xpath("//p[3]");										//合同编号以及签约日期
	 By Investor = By.xpath("//div/p[2]");														//贷出者
	 By Borrower = By.xpath("//div/p[3]");														//借入者
	 By BorrowerName1 = By.xpath("//div/p[3]/u");												//借入者姓名
	 By Manager = By.xpath("//div/p[4]");														//管理方
	 By LenderName = By.xpath("//p[2]/u");											//贷出者姓名
	 By ManagerName = By.xpath("//p[4]/u");											//管理方姓名
	 
	 //贷出者列表
	 By LenderLines =  By.xpath("//div[@class='showMessageDiv']/table[1]/tbody/tr");//贷出者条数
//	 By FirstLenderName = By.xpath("//tr[2]/td");									//第一条贷出者姓名
//	 By FirstLenderPhase = By.xpath("//tr[2]/td[3]");								//第一条借款期限
//	 By SecondLineName = By.xpath("//tr[3]/td");									//第二条借款的第一列信息
//	 By SecondLineMoney = By.xpath("//tr[3]/td[2]");								//第二条借款的第二列信息	
//	 By SecondLenderPhase = By.xpath("//tr[3]/td[3]");								//第二条借款期限
//	 By SecondLineBX = By.xpath("//tr[3]/td[4]");									//第二条借款的第四列信息
	 
	 By BorrowerInfo = By.xpath("//p[16]");	//借入者信息描述
	 By ManagerInfo = By.xpath("//p[17]");//管理方描述
	 By ThreeParties = By.xpath("//p[18]");//三方约定	
	 //（以下无正文）		 
	 By BottonLenderName = By.xpath("//p[contains(text(),'以下无正文')]/following::p[2]/u");
	 By BottonBorrower = By.xpath("//p[contains(text(),'以下无正文')]/following::p[3]/u"); 
	 By BottonManager = By.xpath("//p[contains(text(),'以下无正文')]/following::p[6]");
	 
	 //是否在“电子借条”页面
	 public boolean ifinElectronicIOUpage(){
		 return base.isElementPresent(PageInfo);
	 }
	 //检查正在还款借款的“电子借条”的相关信息
	 public void checkElectronicIOUInfo(String borrowername,String data[],String UserName,String id){
		 
//		 try{
			 String [] info = {"借款人："+borrowername,"投资人：详细信息见附表一","管理人：北京同城翼龙网络科技有限公司","保证人：自动化测试；"};
			 List<WebElement> Info = base.getElements(LoanPeopleInfo);
			 for(int i=1;i<5;i++){
				 base.assertEqualsActualExpected(Info.get(i).getText(), info[i-1]);
			 }
			 String borrowBJ;//借款本金
			 data[2]= data[2].replaceAll(",", "");
			 borrowBJ=base.Money(Double.parseDouble(data[2]));
			 Calendar cal = Calendar.getInstance();			 
			 SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat df2=new SimpleDateFormat("yyyy年MM月dd日");
			 try {
				cal.setTime(df1.parse(data[0]));
			 } catch (ParseException e) {
				e.printStackTrace();
			 }
			 cal.add(Calendar.DAY_OF_MONTH, +1);
			 String beginTime = df2.format(cal.getTime());
			 cal.add(Calendar.DAY_OF_MONTH, -1);
			 String fullBidTime = df2.format(cal.getTime());
			 cal.add(Calendar.MONTH, Integer.parseInt(data[4]));
			 String endTime = df2.format(cal.getTime());
			 base.assertEqualsActualExpected(base.getElementTextWithWait(BorrowAmountTxt), "借款本金为" + borrowBJ + "元人民币；借款期限：自 "+beginTime+" 至 "+endTime+"；");
			 base.assertEqualsActualExpected(base.getElementTextWithWait(TimeTxt), "时间："+fullBidTime);
			 if(base.indexURL.contains("test")||base.indexURL.contains("www")){
//				 base.assertTrueByBoolean(base.getElementTextWithWait(ContractNO).contains("合同编号：ELCJ借字"+beginTime.substring(0,4)+"-"));2015年的借款，还款到2016年，2016年打开跨年有BUG，原李静负责
				 base.assertTrueByBoolean(base.getElementTextWithWait(ContractNO).contains("合同编号：ELCJ借字"+cal.get(Calendar.YEAR)+"-"));
			 }else if(base.indexURL.contains("client")){
				 String uid=String.valueOf(dbdata.getTenderID(id,"ownerid"));
				 String wid = String.valueOf(dbdata.getTenderID(id,"wid"));
				 if(wid.length()!=4){
					 wid = "0000"+wid;
					 wid=wid.substring(wid.length()-4);
				 }
				 base.assertEqualsActualExpected(base.getElementTextWithWait(ContractNO), "合同编号：ELCJ借字"+cal.get(Calendar.YEAR)+"-"+wid+"("+uid+id+")");//同上
			 }
			 
			 String [][] Investors = {
					 					{"投资类别","姓名或名称","身份证号码或组织机构代码","联系电话"},
					 					{"保障星投资人","单点一","110102********7045","1352125****"},
					 					{"收益星投资人","单点一","110102********7045","1352125****"},
					 					{"责任星投资人","自动化测试","12345678-1","1358183****"}};
			 String [][] Borrower = {
					 					{"借款人","投资人姓名或名称","投资人类别","借款本金","借款期限"},
					 					{"北京长青","单点一","保障星投资人","7000.00","3"},
					 					{"北京长青","单点一","收益星投资人","2000.00","3"},
					 					{"北京长青","自动化测试","责任星投资人","1000.00","3"}};
			 for(int i=0;i<4;i++){
				 for(int j=0;j<4;j++){
					 base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div/table/tbody/tr["+(i+1)+"]/td["+(j+1)+"]")), Investors[i][j]);
				 }
			 }
			 
			 for(int i = 0; i < 4; i++){
				 for(int j = 0; j < 5; j++){
					 base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div/table[2]/tbody/tr["+(i+1)+"]/td["+(j+1)+"]")), Borrower[i][j]);
				 }
			 }
			 
			 base.assertEqualsActualExpected(base.getElementTextWithWait(PDFLnk), "PDF版本");
			 base.closeAndjumptoOldWindow();
//		 }catch(Exception e){
//			 base.closeAndjumptoOldWindow();
//			 Assert.fail(e.toString());
//		 }catch(AssertionError e){
//			 base.closeAndjumptoOldWindow();
//			 Assert.fail(e.toString());
//		 }
	 }
	 //点击下载“PDF版本”链接
	 public void clickPDFLnk(){
		
		 try{
			 //下载前，得到匹配下载文件的个数
			 String Number = base.getLnkElementText(PDFLnk, "href").split("=")[2];
			 String regex = "agreement"+Number+"[\\s\\S]*[.]pdf";
			 String path = "C:"+File.separator;
			 int num1 = base.matchFileNum(regex, path);
			 base.clickWithWait(PDFLnk);
			 base.sleep(5000);
			 if(base.browserType.toLowerCase().equals("ie")){
				 base.pressAltandS(KeyEvent.VK_S);
			 }else if(base.browserType.toLowerCase().equals("ie8")){
				 base.pressAltandS(KeyEvent.VK_S);
				 base.pressAltandS(KeyEvent.VK_S);
			 }
			 base.closeAndjumptoOldWindow();
			 base.assertEqualsActualExpectedByInt(base.matchFileNum(regex, path), num1+1);
		 }catch(Exception e){
			 if(base.Windowsize()!=1){
				 base.closeAndjumptoOldWindow();
			 }
			 Assert.fail(e.toString());
		 }catch(AssertionError e){
			 if(base.Windowsize()!=1)		base.closeAndjumptoOldWindow();
			 Assert.fail(e.toString());
		 }
	 }
	 //检查“已结清的投资”的电子借条的信息
	 public void checkElectronicIOUInfoforInvest(String data[],String borrower,String phase,String rate,String title){
	   try{ 
		 base.assertTrueByBoolean(base.getElementTextWithWait(PdfDescriptionTxt).contains("同城翼龙网络借款服务协议:下载电子借条 PDF版本"));
		 base.assertEqualsActualExpected(base.getElementTextWithWait(TitleTxt), "网络借款电子借条");//标题
		 String datas = base.getElementTextWithWait(ContractAndDate);//合同编号和签约日期
		 base.assertTrueByBoolean(datas.contains("合同编号：")&&datas.contains("签约日期："+data[0]));
		 base.assertTrueByBoolean(base.getElementText(Investor).contains("贷出者：") && base.getElementText(Investor).contains("，以下称“贷出方”;"));
		 String lender = base.getElementText(LenderName);//显示的贷出者姓名
		 String borrowname = base.getElementText(BorrowerName1);
		 String borrow = base.getElementText(Borrower);//借入者：...以下称“借入方”; 
		 if(base.indexURL.contains("www")||base.indexURL.contains("test")){
			 borrow=borrow.replace(borrow.substring(4, 5),"*");
		 }
 		 base.assertEqualsActualExpected(borrow, "借入者："+borrower+"，以下称“借入方”;");	 
		 base.assertTrueByBoolean(base.getElementText(Manager).contains("管理方：") && base.getElementText(Manager).contains("有限公司，以下称“管理方”。"));
		 String managername = base.getElementText(ManagerName);
		//检查“贷出者”表格信息
		 String[] user;
		 if(lender.contains(";")){//如果贷出者有多个人
			 user = lender.split(";");
		 }else{
			 user= new String[1];
			 user[0]=lender;
		 }		 
		 base.assertEqualsActualExpectedByInt(base.getElements(LenderLines).size()-2, user.length);
		 for(int j=1;j<=user.length;j++){
			 base.assertTrueByBoolean(base.getElementText(By.xpath("//tr["+(j+1)+"]/td")).contains(user[j-1]+" （身份证号码："));
			 base.assertEqualsActualExpected(base.getElementText(By.xpath("//tr["+(j+1)+"]/td[3]")), phase);
		 }
		 //检查贷出者表格下方的借入者、管理方、三方约定
		 String LenderAmount=base.getElementText(By.xpath("//tr["+(user.length+2)+"]/td[2]"));//总计借出金额
		 String BenXi=base.getElementText(By.xpath("//tr["+(user.length+2)+"]/td[4]"));//总计应收本息
		 if(BenXi.substring(BenXi.indexOf(".")+2).equals("0")){
			 BenXi=BenXi.substring(0, BenXi.indexOf(".")+2);
		 }
		 base.assertTrueByBoolean(base.getElementText(BorrowerInfo).contains("借入者 : "+borrowname+"（身份证号码："));
		 base.assertEqualsActualExpected(base.getElementText(ManagerInfo), "管理方："+managername);
		 base.assertEqualsActualExpected(base.getElementText(ThreeParties), "三方约定：由管理方负责将贷出方的款项划转至借款方开立的账户。");
		 //检查“第一条 借款基本信息” 
		 Calendar calendar = Calendar.getInstance();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 calendar.setTime(base.getDate(data[0]));//把计息日转成date
		 calendar.add(Calendar.DAY_OF_MONTH, -1);//计息日的前一天
		 String lastday=df.format(calendar.getTime()).split("-")[2];
		 if(lastday.substring(0, 1).equals("0")){
			 lastday=lastday.substring(1);//计息日前一天的日，即还款日
		 }
		 int phases = Integer.parseInt(phase);
		 calendar.add(Calendar.MONTH, phases);//还款的截止日期
		 String dueDate=df.format(calendar.getTime());
		 String des = null;
		 if(data[2].substring(0, 2).equals("本人") && data[2].substring(2, 3).equals("，")){
			 des=data[2].substring(0,2)+borrowname+data[2].substring(2);
		 }else{
			 des= data[2];
		 }
		 String basicInfo[]={data[1],base.integerMoney(LenderAmount),BenXi,phase+"个月",rate.substring(0,rate.indexOf("%")),"",title,des,"每月"+lastday+"日（24:00前，节假日不顺延）",data[0]+" 起，至"+dueDate+" 止"};
		 for(int k=1;k<=10;k++){
			if(k!=6){
				if(k==2||k==5){
					base.assertTrueByBoolean(base.getElementText(By.xpath("//tr["+k+"]/td[2]/p")).contains(basicInfo[k-1]));
				}else if(k==3){
					double showBX = Double.parseDouble(base.getElementText(By.xpath("//tr[3]/td[2]/p")).replaceAll(",", ""));
					double bxinList = Double.parseDouble(basicInfo[k-1].replaceAll(",", ""));
					
					if(showBX==bxinList){	
						System.out.println("本息总金额显示正确！");
					}else{
						if( ((bxinList-showBX)<1 && (bxinList-showBX)>0) || ((bxinList-showBX)<0 && (bxinList-showBX)>-1)){
							System.out.println("本息总金额数额有差，但是范围可控！");
						}else{
							Assert.fail("本息总金额差距太大："+showBX+"----"+bxinList);
						}
					}
				}else{
					base.assertEqualsActualExpected(base.getElementText(By.xpath("//tr["+k+"]/td[2]/p")), basicInfo[k-1]);
				}
			}
		 }
		 //检查“分期还款列表”
		 String dates[] = new String[phases];
		 calendar.add(Calendar.MONTH, -phases);
		 for(int i=0;i<phases;i++){
			 calendar.add(Calendar.MONTH, 1);
			 dates[i]=df.format(calendar.getTime());
		 }
		 for(int j=1;j<=phases;j++){
			 base.assertEqualsActualExpected(base.getElementText(By.xpath("//table[3]/tbody/tr["+(j+1)+"]/td")), String.valueOf(j));
			 base.assertEqualsActualExpected(base.getElementText(By.xpath("//table[3]/tbody/tr["+(j+1)+"]/td[4]")), dates[j-1]);
		 }
		 //检查（以下无正文） 
		 base.assertEqualsActualExpected(base.getElementText(BottonLenderName), lender);
		 base.assertEqualsActualExpected(base.getElementText(BottonBorrower), borrowname);
		 base.assertEqualsActualExpected(base.getElementText(BottonManager), "管理方："+managername);
		 base.closeAndjumptoOldWindow();
	   }catch(Exception e){
		 base.closeAndjumptoOldWindow();
		 e.printStackTrace();
		 Assert.fail(e.toString());
	   }catch(AssertionError a){
		 base.closeAndjumptoOldWindow();
		 Assert.fail(a.toString());
	   }
	 }	   
}
