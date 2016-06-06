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
 * ���ڻ�����ĵ��ӽ�����Ͷ�ʳɹ��ĵ��ӽ���
 */
public class ElectronicIOU {

	 Base base = new Base();
	 DBData dbdata = new DBData();
	
	 By PageInfo = By.cssSelector("body>div.showMessageDiv");									//�����ӽ�������Ϣ
	 By BorrowerName = By.xpath("//div[@class='showMessageDiv']/p[2]");							//������ˡ�
	 By LoanPeopleInfo = By.cssSelector("div.showMessageDiv>p");								//������ˡ�����Ͷ���ˡ����������ˡ�������֤�ˡ�
	 public static By BorrowAmountTxt = By.xpath("//p[31]");									//
	 By TimeTxt = By.xpath("//p[208]");
	 By ContractNO = By.cssSelector("div.showMessageDiv>p");									//��ͬ���
	 public static By PDFLnk = By.xpath("//body/p[1]/a[1]");											//""
	 //Ͷ�ʵĵ��ӽ���
	 By PdfDescriptionTxt = By.id("pdf2word");											//pdf������
	 public static By TitleTxt = By.xpath("//font");												//"��������ӽ���"����
	 By ContractAndDate = By.xpath("//p[3]");										//��ͬ����Լ�ǩԼ����
	 By Investor = By.xpath("//div/p[2]");														//������
	 By Borrower = By.xpath("//div/p[3]");														//������
	 By BorrowerName1 = By.xpath("//div/p[3]/u");												//����������
	 By Manager = By.xpath("//div/p[4]");														//����
	 By LenderName = By.xpath("//p[2]/u");											//����������
	 By ManagerName = By.xpath("//p[4]/u");											//��������
	 
	 //�������б�
	 By LenderLines =  By.xpath("//div[@class='showMessageDiv']/table[1]/tbody/tr");//����������
//	 By FirstLenderName = By.xpath("//tr[2]/td");									//��һ������������
//	 By FirstLenderPhase = By.xpath("//tr[2]/td[3]");								//��һ���������
//	 By SecondLineName = By.xpath("//tr[3]/td");									//�ڶ������ĵ�һ����Ϣ
//	 By SecondLineMoney = By.xpath("//tr[3]/td[2]");								//�ڶ������ĵڶ�����Ϣ	
//	 By SecondLenderPhase = By.xpath("//tr[3]/td[3]");								//�ڶ����������
//	 By SecondLineBX = By.xpath("//tr[3]/td[4]");									//�ڶ������ĵ�������Ϣ
	 
	 By BorrowerInfo = By.xpath("//p[16]");	//��������Ϣ����
	 By ManagerInfo = By.xpath("//p[17]");//��������
	 By ThreeParties = By.xpath("//p[18]");//����Լ��	
	 //�����������ģ�		 
	 By BottonLenderName = By.xpath("//p[contains(text(),'����������')]/following::p[2]/u");
	 By BottonBorrower = By.xpath("//p[contains(text(),'����������')]/following::p[3]/u"); 
	 By BottonManager = By.xpath("//p[contains(text(),'����������')]/following::p[6]");
	 
	 //�Ƿ��ڡ����ӽ�����ҳ��
	 public boolean ifinElectronicIOUpage(){
		 return base.isElementPresent(PageInfo);
	 }
	 //������ڻ�����ġ����ӽ������������Ϣ
	 public void checkElectronicIOUInfo(String borrowername,String data[],String UserName,String id){
		 
//		 try{
			 String [] info = {"����ˣ�"+borrowername,"Ͷ���ˣ���ϸ��Ϣ������һ","�����ˣ�����ͬ����������Ƽ����޹�˾","��֤�ˣ��Զ������ԣ�"};
			 List<WebElement> Info = base.getElements(LoanPeopleInfo);
			 for(int i=1;i<5;i++){
				 base.assertEqualsActualExpected(Info.get(i).getText(), info[i-1]);
			 }
			 String borrowBJ;//����
			 data[2]= data[2].replaceAll(",", "");
			 borrowBJ=base.Money(Double.parseDouble(data[2]));
			 Calendar cal = Calendar.getInstance();			 
			 SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat df2=new SimpleDateFormat("yyyy��MM��dd��");
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
			 base.assertEqualsActualExpected(base.getElementTextWithWait(BorrowAmountTxt), "����Ϊ" + borrowBJ + "Ԫ����ң�������ޣ��� "+beginTime+" �� "+endTime+"��");
			 base.assertEqualsActualExpected(base.getElementTextWithWait(TimeTxt), "ʱ�䣺"+fullBidTime);
			 if(base.indexURL.contains("test")||base.indexURL.contains("www")){
//				 base.assertTrueByBoolean(base.getElementTextWithWait(ContractNO).contains("��ͬ��ţ�ELCJ����"+beginTime.substring(0,4)+"-"));2015��Ľ����2016�꣬2016��򿪿�����BUG��ԭ�����
				 base.assertTrueByBoolean(base.getElementTextWithWait(ContractNO).contains("��ͬ��ţ�ELCJ����"+cal.get(Calendar.YEAR)+"-"));
			 }else if(base.indexURL.contains("client")){
				 String uid=String.valueOf(dbdata.getTenderID(id,"ownerid"));
				 String wid = String.valueOf(dbdata.getTenderID(id,"wid"));
				 if(wid.length()!=4){
					 wid = "0000"+wid;
					 wid=wid.substring(wid.length()-4);
				 }
				 base.assertEqualsActualExpected(base.getElementTextWithWait(ContractNO), "��ͬ��ţ�ELCJ����"+cal.get(Calendar.YEAR)+"-"+wid+"("+uid+id+")");//ͬ��
			 }
			 
			 String [][] Investors = {
					 					{"Ͷ�����","����������","���֤�������֯��������","��ϵ�绰"},
					 					{"������Ͷ����","����һ","110102********7045","1352125****"},
					 					{"������Ͷ����","����һ","110102********7045","1352125****"},
					 					{"������Ͷ����","�Զ�������","12345678-1","1358183****"}};
			 String [][] Borrower = {
					 					{"�����","Ͷ��������������","Ͷ�������","����","�������"},
					 					{"��������","����һ","������Ͷ����","7000.00","3"},
					 					{"��������","����һ","������Ͷ����","2000.00","3"},
					 					{"��������","�Զ�������","������Ͷ����","1000.00","3"}};
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
			 
			 base.assertEqualsActualExpected(base.getElementTextWithWait(PDFLnk), "PDF�汾");
			 base.closeAndjumptoOldWindow();
//		 }catch(Exception e){
//			 base.closeAndjumptoOldWindow();
//			 Assert.fail(e.toString());
//		 }catch(AssertionError e){
//			 base.closeAndjumptoOldWindow();
//			 Assert.fail(e.toString());
//		 }
	 }
	 //������ء�PDF�汾������
	 public void clickPDFLnk(){
		
		 try{
			 //����ǰ���õ�ƥ�������ļ��ĸ���
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
	 //��顰�ѽ����Ͷ�ʡ��ĵ��ӽ�������Ϣ
	 public void checkElectronicIOUInfoforInvest(String data[],String borrower,String phase,String rate,String title){
	   try{ 
		 base.assertTrueByBoolean(base.getElementTextWithWait(PdfDescriptionTxt).contains("ͬ���������������Э��:���ص��ӽ��� PDF�汾"));
		 base.assertEqualsActualExpected(base.getElementTextWithWait(TitleTxt), "��������ӽ���");//����
		 String datas = base.getElementTextWithWait(ContractAndDate);//��ͬ��ź�ǩԼ����
		 base.assertTrueByBoolean(datas.contains("��ͬ��ţ�")&&datas.contains("ǩԼ���ڣ�"+data[0]));
		 base.assertTrueByBoolean(base.getElementText(Investor).contains("�����ߣ�") && base.getElementText(Investor).contains("�����³ơ���������;"));
		 String lender = base.getElementText(LenderName);//��ʾ�Ĵ���������
		 String borrowname = base.getElementText(BorrowerName1);
		 String borrow = base.getElementText(Borrower);//�����ߣ�...���³ơ����뷽��; 
		 if(base.indexURL.contains("www")||base.indexURL.contains("test")){
			 borrow=borrow.replace(borrow.substring(4, 5),"*");
		 }
 		 base.assertEqualsActualExpected(borrow, "�����ߣ�"+borrower+"�����³ơ����뷽��;");	 
		 base.assertTrueByBoolean(base.getElementText(Manager).contains("������") && base.getElementText(Manager).contains("���޹�˾�����³ơ���������"));
		 String managername = base.getElementText(ManagerName);
		//��顰�����ߡ������Ϣ
		 String[] user;
		 if(lender.contains(";")){//����������ж����
			 user = lender.split(";");
		 }else{
			 user= new String[1];
			 user[0]=lender;
		 }		 
		 base.assertEqualsActualExpectedByInt(base.getElements(LenderLines).size()-2, user.length);
		 for(int j=1;j<=user.length;j++){
			 base.assertTrueByBoolean(base.getElementText(By.xpath("//tr["+(j+1)+"]/td")).contains(user[j-1]+" �����֤���룺"));
			 base.assertEqualsActualExpected(base.getElementText(By.xpath("//tr["+(j+1)+"]/td[3]")), phase);
		 }
		 //�������߱���·��Ľ����ߡ�����������Լ��
		 String LenderAmount=base.getElementText(By.xpath("//tr["+(user.length+2)+"]/td[2]"));//�ܼƽ�����
		 String BenXi=base.getElementText(By.xpath("//tr["+(user.length+2)+"]/td[4]"));//�ܼ�Ӧ�ձ�Ϣ
		 if(BenXi.substring(BenXi.indexOf(".")+2).equals("0")){
			 BenXi=BenXi.substring(0, BenXi.indexOf(".")+2);
		 }
		 base.assertTrueByBoolean(base.getElementText(BorrowerInfo).contains("������ : "+borrowname+"�����֤���룺"));
		 base.assertEqualsActualExpected(base.getElementText(ManagerInfo), "������"+managername);
		 base.assertEqualsActualExpected(base.getElementText(ThreeParties), "����Լ�����ɹ������𽫴������Ŀ��ת�����������˻���");
		 //��顰��һ�� ��������Ϣ�� 
		 Calendar calendar = Calendar.getInstance();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 calendar.setTime(base.getDate(data[0]));//�Ѽ�Ϣ��ת��date
		 calendar.add(Calendar.DAY_OF_MONTH, -1);//��Ϣ�յ�ǰһ��
		 String lastday=df.format(calendar.getTime()).split("-")[2];
		 if(lastday.substring(0, 1).equals("0")){
			 lastday=lastday.substring(1);//��Ϣ��ǰһ����գ���������
		 }
		 int phases = Integer.parseInt(phase);
		 calendar.add(Calendar.MONTH, phases);//����Ľ�ֹ����
		 String dueDate=df.format(calendar.getTime());
		 String des = null;
		 if(data[2].substring(0, 2).equals("����") && data[2].substring(2, 3).equals("��")){
			 des=data[2].substring(0,2)+borrowname+data[2].substring(2);
		 }else{
			 des= data[2];
		 }
		 String basicInfo[]={data[1],base.integerMoney(LenderAmount),BenXi,phase+"����",rate.substring(0,rate.indexOf("%")),"",title,des,"ÿ��"+lastday+"�գ�24:00ǰ���ڼ��ղ�˳�ӣ�",data[0]+" ����"+dueDate+" ֹ"};
		 for(int k=1;k<=10;k++){
			if(k!=6){
				if(k==2||k==5){
					base.assertTrueByBoolean(base.getElementText(By.xpath("//tr["+k+"]/td[2]/p")).contains(basicInfo[k-1]));
				}else if(k==3){
					double showBX = Double.parseDouble(base.getElementText(By.xpath("//tr[3]/td[2]/p")).replaceAll(",", ""));
					double bxinList = Double.parseDouble(basicInfo[k-1].replaceAll(",", ""));
					
					if(showBX==bxinList){	
						System.out.println("��Ϣ�ܽ����ʾ��ȷ��");
					}else{
						if( ((bxinList-showBX)<1 && (bxinList-showBX)>0) || ((bxinList-showBX)<0 && (bxinList-showBX)>-1)){
							System.out.println("��Ϣ�ܽ�������в���Ƿ�Χ�ɿأ�");
						}else{
							Assert.fail("��Ϣ�ܽ����̫��"+showBX+"----"+bxinList);
						}
					}
				}else{
					base.assertEqualsActualExpected(base.getElementText(By.xpath("//tr["+k+"]/td[2]/p")), basicInfo[k-1]);
				}
			}
		 }
		 //��顰���ڻ����б�
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
		 //��飨���������ģ� 
		 base.assertEqualsActualExpected(base.getElementText(BottonLenderName), lender);
		 base.assertEqualsActualExpected(base.getElementText(BottonBorrower), borrowname);
		 base.assertEqualsActualExpected(base.getElementText(BottonManager), "������"+managername);
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
