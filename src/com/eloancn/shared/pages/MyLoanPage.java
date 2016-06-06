package com.eloancn.shared.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;

import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;

/**
 * ���ҵ��˻���-���ҵĽ�ҳ��
 */
public class MyLoanPage {
	
	Base base = new Base();
	DBData dbData = new DBData();
	
	InsideLetterPage insideLetterPage = new InsideLetterPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	TransactionRecordPage transactionRecordPage = new TransactionRecordPage();
	
	String myLoanHandel = "";
	String openMobileHandel = "";
	
	//�ҵĽ��
	public static By MyLoanTxt =By.cssSelector("div.newtitle>h3");	 
	
	
	//���ڻ���Ľ��
	By loanListByFirst = By.cssSelector("#_content_child > div.mt15");                             //����б��һ������
	By outAllWindow = By.cssSelector("#out_all");                                                             //����ȷ�ϵ�����
	By okBtn = By.xpath("//button[@id='repayButtonSubmit']");												  //����ȷ�ϴ���_ȷ�ϰ�ť
	By allRdo = By.xpath("//input[@id='all']");																  //����ȷ�ϴ���_��ǰһ���Ի���
	By balanceByWindow = By.cssSelector("#balancediv");                                                       //�˻����
	By cancelBtn = By.cssSelector(".RT_cancel");                                                              //����ȷ�ϴ���_ȡ����ť
	By viewDetailsOpenBtn = By.cssSelector(".fl.record_tit.colorF8.record_close");                 //�������򿪰�ť
	By viewDetailsCloseBtn = By.cssSelector(".fl.record_tit.colorF8.record_close.record_open");    //�������رհ�ť
	By loanListByMyLoan = By.cssSelector(".record_table");                                         //����б�
	By monthlyRepaymentLink = By.cssSelector(".lending_record > a:nth-child(2)");                  //��������
	By BorrowDetailLnk = By.xpath("//div[@class='lending_record']/a[3]");
	
	/*****************�ѷ����Ľ��****************/
	//�ѷ����Ľ��Tab
	By publishedtab = By.id("published");
	static By SelectedTab = By.cssSelector("span.wd160.current");
	By AllLoanContent = By.id("_content_child");
	By LastPage=By.xpath("//div[@id='Pagination']/ul/li[text()='ĩҳ']");
	By FourthPageLnk = By.xpath("//div[@id='Pagination']/ul/li[4]");						//ҳ���ĵ�4������
	By LastTwoPage = By.xpath("//div[@id='Pagination']/ul/li[last()-2]");
	By FirstPage = By.xpath("//div[@id='Pagination']/ul/li[text()='��ҳ']");
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");
	By LastOnePage = By.xpath("//div[@id='Pagination']/ul/li[text()='>']");		//ĩҳ��ǰһ������

	//ȷ�Ͻ��
	By sureDebitBtn = By.xpath("//a[text()='ȷ�Ͻ��']");
	By LoanSubTitle = By.cssSelector("#_content_child>table>thead");
	By LoanPurposeLnk = By.xpath("//div[@id='_content_child']/table/tbody/tr/td[2]/a");
	//������������ꡱ�ı����͵�����������Ϣ
	By LBInfoTxt = By.id("addNewCardBackup");
	public By LBDCode = By.cssSelector("div.lyct>table>tbody>tr>td");
	By LBCodeCreater = By.xpath("//div[@class='lyct']/table/tbody/tr[2]");
	By LBCodeBeginTime= By.xpath("//div[@class='lyct']/table/tbody/tr[3]");
	By LBCodeEndTime = By.xpath("//div[@class='lyct']/table/tbody/tr[4]");
	By LBMember1 = By.xpath("//div[@class='lyct']/table/tbody/tr[5]");
	By LBMember2 = By.xpath("//div[@class='lyct']/table/tbody/tr[6]");
	
	//��ȫ������Ľ��
	
	
	//��δ�����Ľ��
	
	/**************************************�����ϴ�*****************************************/
	By CheckFile = By.id("materials_1");							//��˲���
	By CreditFile = By.id("materials_0");
	By IncreaseFile = By.id("materials_2");
	By PublicFile = By.id("materials_3");
	By FileType = By.cssSelector("#materialCont1>table>tbody>tr>th");//��������
	By WarmPromptPart = By.cssSelector("div.msg_cotainer.font12");
	By IncreaseSpeedTxt = By.cssSelector("span.colorF8");
	By RedTips = By.cssSelector("#promptMSG>span");
	By SelectedPart = By.cssSelector("li.selected");				//ѡ�е�����֤������/��˲��ϡ�����
//	By OriginalImgTxt = By.xpath("//p[@id='promptMSG']/span[2]");
//	By ConfirmFalseTxt = By.xpath("//p[@id='promptMSG']/span[3]");
//	By SystemBlacklistTxt = By.xpath("//p[@id='promptMSG']/span[4]");
	
	/*************��������************/
	By Title = By.xpath("//div[@id='_content']/div/div");//���ҵĽ��>�������ϡ�����
	By MyDebtTitle = By.xpath("//div[@id='_content']/div/div/span/a");//���ҵĽ�����
	By BasicInfoLnk = By.id("info0");	//��������
	By EmergencyContactLnk = By.id("info1");//������ϵ��
	By CreditInfoLnk =By.id("info2");//��������
	By CurrentTitle = By.cssSelector("span.wd110.current");
	
	//�����ϴ� �������� ...
	By currentlocationTxt =By.cssSelector(".sqed.ml5");
	//��������>>>>>>>>>>
	By OptionFlag = By.xpath("//form[@id='userNocategoryForm']/table/tbody/*/td[1]");//��ѡ������*
	By ManOption = By.xpath("//input[@name='gendar']");
	By SelectedGendar = By.xpath("//label[input[@checked='checked']]");
	By DisabledGendar = By.xpath("//label[input[@disabled='disabled']]");
	By inputAge= By.id("age");
	By selectNation = By.id("nationality");//ѡ������
	By inputPhone = By.id("phone");														//סլ�绰
	By inputQQNum = By.id("qqnumber");
	By NativePlace = By.id("nativePlace");//�������ڵ�
	//��ĸ���ڵ�
	By parentAddressTxt =By.id("parentAddress");
	By currentAddressTxt = By.id("address");//�־�ס�ص�ַ
	By inputCompanyIndustry = By.id("companyIndustry");
	By inputCompanyName = By.id("companyName");
	By inputCompanyAddress = By.id("companyAddress");
	By inputCompanyPhone = By.id("companyPhone");
	By inputDescription = By.id("description");
	By NotesTxt = By.cssSelector("div.gbobal_questionList.mb15");//������Ϣ�µ�ע����Ϣ
	//�������ϵı��沢������ť
	By baseSaveBtn = By.xpath("//*[@id='materialCont0']/a");
	By ErrorTipTxt = By.id("infortip");
	//������ϵ��>>>>>>>>>
	By ContactContent = By.id("materialCont1");
	By TipsTxt = By.cssSelector("div.pub_tip.mt20>div>p");//��ܰ��ʾ
	By inputInfos = By.cssSelector("#connectionForm>table>tbody>tr>td>input");
	//����
	By namesTxt = By.cssSelector(".pub_text1[id*='friendname']");
	//�ֻ�
	By telTxt = By.cssSelector(".pub_text1[id*='friendmobile']");
	By ContactTipTxt = By.id("connectiontip");
	//������ϵ�˱��沢������ť
	By emergencyContactSaveBtn = By.xpath(".//*[@id='connectionForm']/a");
	//��������>>>>>>>>>>>
	By creditInfos = By.cssSelector("#usercategoryForm tbody>tr>td>select");
	//�ύ
	By creditInfoSaveBtn = By.id("creatOrUpdate");
/*************************��������***************************/
	By QuotaTypeSel = By.id("goodstype");
	By ValidDateSel = By.id("valid");
	By inputExpectQuota = By.id("expectquota");
	By inputDesc = By.id("description");
	By ApplicationBtn = By.cssSelector("button.pub_button.ml22");
	
	//ͨ���������ݿ�ʹ�ý����ܲ�����ͨ���������
	public void UpdateTenderStatuswithSQL(String tenderid,String status){
		String sql="UPDATE d_tender SET STATUS="+status+" WHERE id= "+tenderid;
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}	
	//���ݽ���Ŀ�ĸ������ݿ��н���״̬
	public void UpdateTenderStatusByTitlewithSQL(String purpose,String status){
		String sql="UPDATE d_tender SET STATUS='"+status+"' WHERE title= '"+purpose+"'";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}
	//���ݽ���title��ý���id
	public int getTenderIDwithSQL(String purpose){
		String sql="SELECT id FROM d_tender WHERE title='"+purpose+"'";
		int id=new DBData().ExecuteSelect(sql);
		return id;
	}
	//������̳���ͨ����¼
	public String addFirstTrialRecordwithSQL(String tenderid){
		Date date1= base.getTime();
		String date=base.dateFormat(date1, "yyyy-MM-dd HH:mm");
		String cdate=String.valueOf(date1.getTime()).substring(0, 10);
		String sql="INSERT INTO d_tender_first_trial(tid,operator,cdate,STATUS)VALUES("+tenderid+"/*����id*/,1,"+cdate+",1);";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
		return date;
	}
	//ͨ���������ݿ����������:13581838716,13581838717(320,321);13581838713,13581838714(323,324)
	public void addLBDTwoMemeberswithSQL(String LBDCode){
		String tenderid=LBDCode.substring(11);		
		String sql="UPDATE d_tender_warrant SET tid= "+tenderid+",joinid=(SELECT id FROM d_tender_lbdcode WHERE tenderCode='"+LBDCode+"') WHERE username='"+Data.tel_LBDCreaterName+"' OR username='"+Data.tel_LBDNoncreaterName+"'";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}
	//������������Ϊ������,����Ϊ���Ŀ�Ļ�����������
	public void DisableLBCodewithSQL(String tenderidOrlbcode){
		String sql="";
		if(tenderidOrlbcode.contains("LBD")){
			sql = "UPDATE d_tender_lbdcode SET isUse=2 WHERE tenderCode='"+tenderidOrlbcode+"'";
		}else{
//			String tenderid=String.valueOf(getTenderIDwithSQL(tenderidOrlbcode));
			sql="UPDATE d_tender_lbdcode SET isUse=2 WHERE tenderCode LIKE 'LBD%"+tenderidOrlbcode+"'";
		}
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}
	//ɾ��һ����������
	public void DeleteTenderwithSQL(String purpose){
		String sql = "DELETE FROM d_tender WHERE title='"+purpose+"'";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}

	/**
	 * ����Ԫ
	 * ��ǰ���ڵ��Ƿ���ȷ  ��������
	 */
	public void isCurrentlocationOK(String location){
		base.assertEqualsActualExpected(base.getElementTextWithWait(currentlocationTxt), location);
	}
	
	/**
	 * ����Ԫ
	 * ��������
	 */
	public void baseInfo(String parentAddress){
		base.sendKeysWithWait(parentAddressTxt, parentAddress);
		base.clickWithWait(By.cssSelector("#materialCont0>.pub_button.mt10.mb15.ml115"));//baseSaveBtn
	}
	
	/**
	 * ����Ԫ
	 * �ҵĽ����5����ť  ������ �����ϴ� �������� �鿴��Ƶ ��ͨ���۹���
	 */
	public void clickBtn(String nameBtn){
		if (nameBtn.equals("��ͨ���۹���")) {
			base.clickWithWait(By.cssSelector(".pub_btn_95]"));
		}else {
			base.clickWithWait(By.cssSelector(".pub_btn_75[value='" + nameBtn + "']"));
		}
	}
	//������������ϡ�����
	public void clickBaseInfoLnk(){
		base.clickWithWait(BasicInfoLnk);
		base.checkElementVisible(baseSaveBtn);
	}
	//�����������ϵ�ˡ�����
	public void clickEmergencyContactLnk(){
		base.clickWithWait(EmergencyContactLnk);
		base.checkElementVisible(ContactContent);
	}
	//��������--������ϵ��ҳ��-������ʽ��У��
	public void checkEmergencyNames(){

		String names[]={"������","�е㻭","�㻭��","�����","�����","�ľ���"};
		String tels[] ={"13510000011","13510000012","13510000013","13510000014","13510000015","13510000016"};
		writeEmergencyContact(names,tels);
		base.checkNoElement(ContactTipTxt);
		base.checkElmentText(CurrentTitle, "��������");
		String name[]={"","1526985263","qawsedcxfv","!@#$%^&*()","�� ��",""};
		String name1[]={"��ȻҲ�����Լ���д��һ","��ȻҲ�����Լ���дȻһ","��ȻҲ�����Լ���дҲһ","��ȻҲ�����Լ���д��һ","��ȻҲ�����Լ���д��һ","��ȻҲ�����Լ���д��һ"};
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				clickEmergencyContactLnk();
				List<WebElement> nameList = base.getElements(namesTxt);
				nameList.get(i).click();
				nameList.get(i).clear();
				if(j==5){
					name[j]=name1[i];
				}	
				nameList.get(i).sendKeys(name[j]);
				clickContactSaveBtn();
				int length = name[j].length();
				if(length==0){
					base.checkElmentText(ContactTipTxt, "��"+(i+1)+"����������Ϊ�գ�");
				}else if(length>10 || length<=10){
					if(length>10)		length=10;				
					if(base.isChinese(name[j].substring(0, length))){
						base.checkNoElement(ContactTipTxt);
						base.checkElmentText(CurrentTitle, "��������");
						clickEmergencyContactLnk();
						base.assertEqualsActualExpected(nameList.get(i).getAttribute("value"), name[j].substring(0, length));
					}else{
						base.checkElmentText(ContactTipTxt, "��"+(i+1)+"����������Ϊ���֣�");
					}
				}				
			}
		}		
	}
	//��������--������ϵ��ҳ��-�ֻ���ʽ��У��
	public void checkEmergencyTels(){
		String names[]={"������","�е㻭","�㻭��","�����","�����","�ľ���"};
		String tels[] ={"13510000011","13510000012","13510000013","13510000014","13510000015","13510000016"};
		writeEmergencyContact(names,tels);
		base.checkNoElement(ContactTipTxt);
		base.checkElmentText(CurrentTitle, "��������");
		String tel[]={"","1351000012","��ȻҲ�����Լ���дһ��","!@#$%^&*()+","13510 01252","11111111111","135����tui&*|",""};
		String tel1[]={"135100000012","135100000022","135100000032","135100000042","135100000052","135100000062"};
		for(int i=0;i<6;i++){
			for(int j=0;j<8;j++){
				clickEmergencyContactLnk();
				List<WebElement> telList = base.getElements(telTxt);
				telList.get(i).click();
				telList.get(i).clear();
				if(j==7){
					tel[j]=tel1[i];
				}				
				telList.get(i).sendKeys(tel[j]);
				clickContactSaveBtn();
				int length=tel[j].length();
				if(length==0){
					base.checkElmentText(ContactTipTxt, "��"+(i+1)+"���ֻ�����Ϊ�գ�");
				}else{
					if(length>11)   length=11;
					if(base.isTelephone(tel[j].substring(0, length))){
						base.checkNoElement(ContactTipTxt);
						base.checkElmentText(CurrentTitle, "��������");
						clickEmergencyContactLnk();
						base.assertEqualsActualExpected(telList.get(i).getAttribute("value"), tel[j].substring(0, length));
					}else{
						base.checkElmentText(ContactTipTxt, "��"+(i+1)+"���ֻ���������");
					}
				}
			}
		}			
	}
	//�����������ϵ�ˡ��ġ����沢��������ť	
	public void clickContactSaveBtn(){
		base.clickWithWait(emergencyContactSaveBtn);
	}
	/**
	 * ����Ԫ
	 * �жϵ�ǰ�������ϵ�λ���Ƿ���ȷ  �������� ������ϵ��  ��������
	 */
	public void isCurrentInfo(String currentInfo){
		//base.assertNotNullBy(By.xpath(".//*[contains(@class,'current') and text()='" + currentInfo + "']"));
		String currentID = "";
		if(currentInfo.equals("��������")){
			currentID = "#info0";
		}else if (currentInfo.equals("������ϵ��")) {
			currentID = "#info1";
		}else {
			currentID = "#info2";
		}
		base.checkElement(By.cssSelector(currentID+".current"));
		//base.assertNotNullBy(By.cssSelector(currentID+".current"));
	}
	
	/**
	 * ����Ԫ
	 * ������ϵ��������д
	 */
	public void writeEmergencyContact(String names[],String tels[]){
		List<WebElement> nameList = base.getElements(namesTxt);
		List<WebElement> telList = base.getElements(telTxt);
		System.out.print(nameList.size());
		for (int i = 0; i < nameList.size(); i++) {
			nameList.get(i).clear();
			nameList.get(i).sendKeys(names[i]);
			telList.get(i).clear();
			telList.get(i).sendKeys(tels[i]);
		}
		base.clickWithWait(emergencyContactSaveBtn);		
	}
	
	/**
	 * ����Ԫ
	 * ��д��������
	 */
	public void writeCreditInfo(){
		List<WebElement> creditInfoList = base.getElements(creditInfos);
		System.out.println("��������"+creditInfoList.size());
		for (int i = 0; i < creditInfoList.size(); i++) {
			new Select(creditInfoList.get(i)).selectByIndex(1);
		}
		//�ύ--ȡ��
		base.clickWithWait(creditInfoSaveBtn);
		try {
			Alert alert = base.getAlertwithWait();
			alert.dismiss();
			isCurrentInfo("��������");
		} catch (Exception e) {
		}
		//�ύ--ȷ��
		base.clickWithWait(creditInfoSaveBtn);
		Alert alert = base.getAlertwithWait();
		alert.accept();
	}
	//���ڻ���Ľ��-���ȶ��/�ȶϢ/������Ϣ����Ļ��ʽ
	public void checkMatchingPrincipal(){
		int page = getPages();
		for(int i=1;i<=page;i++){
			List<WebElement> detail = base.getElements(BorrowDetailLnk);
			for(int j=0;j<=detail.size();j++){
				
			}
		}
	}
	
	/**
	 * ����Ԫ
	 * ������ѷ����Ľ�
	 */
	public void clickPublishedTab(){
		//�ѷ����Ľ��Tab
		base.clickWithWait(publishedtab);
		base.checkElmentText(SelectedTab, "�ѷ����Ľ��");
	}
	
	/**
	 * ����Ԫ
	 * �ж��Ƿ�Ϊ��  ȷ�Ͻ��  ��ͨ�ֻ���ݻ���ҵ��  ¼�Ʊ�ȷ����Ƶ
	 */
	public Boolean isDisplayed(String name){
		Boolean result = false;
		if (name.equals("ȷ�Ͻ��")) {
			result = base.isDisplayed(sureDebitBtn);
		}else {
			result = base.isDisplayed(By.cssSelector("input[value='"+name+"']"));
		}
		System.out.println(name+result);
		return result;
	}
	//��ȡ�����ڻ���Ľ������ѷ����Ľ��е�ҳ��
	public int getPages(){
		if(base.getElementTextWithWait(AllLoanContent).equals("��Ŀǰ��û���ѷ����Ľ�")){
			return 0;
		}else if(base.getElementTextWithWait(AllLoanContent).equals("��Ŀǰ��û�����ڻ���Ľ�")){
			return 0;
		}else{
			if(base.getElementTextWithWait(FourthPageLnk).equals(">")){
				return 1;
			}else{
				base.clickWithWait(LastPage);
				base.checkElementVisible(LastTwoPage);
				int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
				base.clickWithWait(FirstPage);
				base.checkElmentText(CurrentPage, "1");
				return lastPageNum;
			}
		}
	}
	//���ݽ��Ŀ�Ļ�ñ��id
	public String getTenderId(String purpose){
		base.checkElementVisible(LoanSubTitle);
		String id=null;
		int page = getPages();
		outer:for(int j=1;j<=page;j++){
			base.checkElmentText(CurrentPage, String.valueOf(j));
			List<WebElement> purposes = base.getElements(LoanPurposeLnk);
			for(int i=0;i<purposes.size();i++){
				if(purposes.get(i).getAttribute("title").equals(purpose)){
					String href = purposes.get(i).getAttribute("href");
					id= href.substring(href.indexOf("=")+1);			
					break outer;
				}
			}
			base.clickWithWait(LastOnePage);	
		}	
		System.out.println("tenderid is: "+id);
		return id;
	}
	//������ѷ����Ľ��н���ġ��������ꡱ����
	public void clickLBDBidType(String CreaterLBDtenderid){
		base.checkElementVisible(LoanSubTitle);
		int page = getPages();
		for(int j=1;j<=page;j++){
			base.checkElmentText(CurrentPage, String.valueOf(j));
			if(base.checkVisible(By.xpath("//a[contains(@onclick,'"+CreaterLBDtenderid+"')]"),5)){
				base.clickWithWait(By.xpath("//a[contains(@onclick,'"+CreaterLBDtenderid+"')]"));
				base.checkElementVisible(LBInfoTxt);
				break;
			}
			base.clickWithWait(LastOnePage);
		}
	}
	//�鿴��������������������������ӵ�����   
	public void checkPopupLBDData(String LBCode,String begindate){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(base.getDate(begindate));
		calendar.add(Calendar.DAY_OF_MONTH, 90);
		String endtime=base.dateFormat(calendar.getTime(), "yyyy-MM-dd ")+begindate.substring(11);
		List<WebElement> LBInfo = base.getElements(LBDCode);
		String infos[]={"���������룺"+LBCode,"�����봴���ˣ�"+Data.tel_LBDCreaterName,"����������Ч��ʼʱ�䣺"+begindate,"����������Ч����ʱ�䣺"+endtime,"�������Ա1:"+Data.tel_LBDNoncreaterName,"�������Ա2:"+Data.tel_LBDCreaterName};
		for(int i=0;i<LBInfo.size();i++){
			base.assertEqualsActualExpected(LBInfo.get(i).getText(), infos[i]);
		}	
	}
	//��ʾ�Լ������������ı꣬���������˽��������겻��ʾ       
	public void showOwnLBD(String Creatertenderid,String Noncreatertenderid){
		base.checkElementVisible(LoanSubTitle);
		boolean result1=false,result2=true;
		int page = getPages();
		for(int j=1;j<=page;j++){
			base.checkElmentText(CurrentPage, String.valueOf(j));
			if(result1==false && base.checkVisible(By.xpath("//a[contains(@onclick,'"+Creatertenderid+"')]"),2)){
				result1=true;
			}
			if(base.checkVisible(By.xpath("//a[contains(@onclick,'"+Noncreatertenderid+"')]"),2)){
				result2=false;
			}else{
				result2 = true;
			}
			base.clickWithWait(LastOnePage);
		}
		base.assertTrueByBoolean(result1);
		base.assertTrueByBoolean(result2);
	}
	
	/**
	 * ����Ԫ
	 * ȷ�Ͻ��
	 */
	public void sureDebit(){
		base.sleep(2000);
		myLoanHandel = base.getCurrentWindowHandle();
		System.out.println("�ҵĽ��"+myLoanHandel);
		//ȷ�Ͻ��
		base.clickWithWait(sureDebitBtn);
		base.sleep(2000);
		openMobileHandel = base.getChildWindowHandle(myLoanHandel);
		base.jumpToWindow(openMobileHandel);
	}
	
	/**
	 * ����Ԫ
	 * ȷ�Ͻ�� �����ť  ��ͨ�ֻ���ݻ���ҵ��  ¼�Ʊ�ȷ����Ƶ
	 */
	public void clickBtn_SureDebit(String name){
		System.out.println("�ֻ�"+myLoanHandel);
		//base.clickWithWait(By.xpath("//input[@value='"+name+"']"));
		base.clickWithWait(By.cssSelector("input[value='"+name+"']"));
		//base.clickWithWait(By.cssSelector("input..firepath-matching-node"));
		//base.clickWithWait(By.xpath("//input[@id='']["+num+"]"));
	}
	//���ݽ���id�����ȷ�Ͻ��������
	public void clickSureDebitBtn(String tenderid){
//		base.clickWithWait(By.xpath("//a[contains(@href,'?id="+tenderid+"')]"));
		int page = getPages();
		for(int i=1;i<=page;i++){
			if(base.checkElementPresent(By.xpath("//a[contains(@href,'?id="+tenderid+"')]"),5)){
				base.clickWithWait(By.xpath("//a[contains(@href,'?id="+tenderid+"')]"));
				break;
			}else{
				base.clickWithWait(LastOnePage);
			}
		}
		base.jumpToNewWindow();
		base.checkElmentText(ElectronicIOU.TitleTxt, "��������ӽ���");
	}
	
	/**
	 * ����Ԫ
	 * ��ͨ�ֻ���ݻ����
	 */
	public void openMobilePay(String idcardNo,String accountNo,String mobile,String province,String city,String bankName){
//		//�������ͨ�ֻ���ݿ��ҵ��
//		base.clickWithWait(By.xpath("//input[@value='��ͨ�ֻ���ݻ���ҵ��']"));
		//������
		//base.sendKeysWithWait(By.id("realName"), realName);
		//���֤��
		base.sendKeysWithWait(By.id("idcardNo"), idcardNo);
		//���п���
		base.sendKeysWithWait(By.id("accountNo"), accountNo);
		//�ֻ���
		base.sendKeysWithWait(By.id("mobile"), mobile);
		//ũҵ����
		base.clickWithWait(By.id("bankType5"));
		//ʡ��
		base.elementSelectByVisibleText(By.id("provinceid"), province);
		//��
		base.elementSelectByVisibleText(By.id("cityid"), city);
		//������֧����
		base.sendKeysWithWait(By.id("bankName"), bankName);
		//ͬ�⿪ͨ
		base.clickWithWait(By.xpath("//span[text()='ͬ�⿪ͨ']"));
	}
	//������ͨ����ġ������С���״̬
	public void checkFirstAuditStatus(String tenderid){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//td[a[contains(@href,'"+tenderid+"')]]/following-sibling::td[5]")), "������");
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//td[a[contains(@href,'"+tenderid+"')]]/following-sibling::td[6]")), "0%");
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//td[a[contains(@href,'"+tenderid+"')]]/following-sibling::td[9]")), "������");
	}
	//ͨ���������ݿ⿪ͨ�ֻ���ݻ����
	public void OpenMobilePaywithSQL(String uid){
		String sql="insert into d_ump_sms_user(uid,mobile,status,cdate) values("+uid+",'y/QTrrbaGzmFBwHbHs+JVw==',1,1436760055);";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}
	//ͨ���������ݿ�ʵ�֡�ȷ�Ͻ����¼��ȷ����Ƶ��
	public void ConfirmVideowithSQL(String userID,String tenderid){
		String sql="INSERT INTO d_tender_ensure_video(tid,uid,STATUS,resultobj,cdate,TYPE)VALUES(/**/"+tenderid+"/*<--��ID*/,/**/"+userID+"/*<---���д�û�UID*/,0,'1410839479929.flv',1427967935,1)";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}
	
	/**
	 * ����Ԫ
	 * �Ƿ��ֻ���ͨ��ݻ���ɹ�
	 */
	public void isOpenMobilePayOK(String realName){
		try {
			Alert alert = base.getAlertwithWait();
			if (alert.getText().equals("��ȷ��Ҫ��ͨ�ֻ���ݻ������")) {
				alert.accept();
				if (base.indexURL.contains("client") || base.indexURL.contains("auto") || base.indexURL.contains("inclient")) {
					//���ݿ��״̬
					int uid = Integer.parseInt(dbData.getUidByRealname(realName));
					System.out.print("..............uid:"+uid);
					Boolean result = dbData.updateOpenMobliePayStatusByUid(uid);
					System.out.println("���ݿ�"+result);
				}
				
				alert = base.getAlertwithWait();
				String msg = alert.getText();
				System.out.println("��ͨ�ֻ���ݻ����:"+msg);
				alert.accept();
				if (base.indexURL.contains("client") || base.indexURL.contains("auto") || base.indexURL.contains("inclient")) {
					if (msg.contains("ʧ��")) {
						base.clickWithWait(By.xpath("//div[@class='ui-dialog-buttonset']/button[2]"));//�ر�
					}
				}
			}
			base.refreshPage();
			base.sleep(3000);
			System.out.println("��ͨ�ֻ���ݻ���ҵ���Ƿ���ʾ��"+base.isBlock(By.cssSelector("input[value='��ͨ�ֻ���ݻ���ҵ��']")));
			base.assertEqualsActualExpectedByBoolean(base.isBlock(By.cssSelector("input[value='��ͨ�ֻ���ݻ���ҵ��']")), false);
		} catch (Exception e) {
		}
	}
	
	/**
	 * ����Ԫ
	 * ��֤��Ƶȷ���Ƿ�ɹ�
	 */
	public void isVedioOK(){
		base.isElementEmpty(By.cssSelector("input[value='¼�Ʊ�ȷ����Ƶ']"));
	}
	
	/**
	 * ����Ԫ
	 * ¼����Ƶ �ر�
	 */
	public void closeVedio(){
		base.clickWithWait(By.cssSelector(".ui-button-text"));
		base.sleep(3000);
		base.refreshPage();
		base.sleep(3000);
	}
	
	/**
	 * ����Ԫ
	 * ȷ�Ͻ����
	 */
	public void isSureDebit(){
		base.clickWithWait(By.cssSelector(".c_afpc_style_26"));
		try {
			Alert alert = base.getAlertwithWait();
			if (alert.getText().equals("ȷ��ͬ��˽���꼰���ӽ�����")) {
				alert.accept();
				alert = base.getAlertwithWait();
				alert.accept();
			}
					
		} catch (Exception e) {
		}
	}

	/**
	 * ����Ԫ
	 * ���Ķ���ͬ����ӽ���
	 */
	public void agree(){
		base.refreshPage();
		base.clickWithWait(By.id("agreeButton"));
		base.clickWithWait(By.cssSelector(".c_afpc_style_26"));
		Alert alert = base.getAlertwithWait();
		//"ȷ��ͬ��˽���꼰���ӽ�����"
		alert.accept();
		//����ȷ�Ͻ���꣬��ȴ����������ɣ�
		String msg = alert.getText();
		//"����ȷ�Ͻ���꣬��ȴ����������ɣ�
		alert.accept();
//		String beforHandel = base.getChildWindowHandle(openMobileHandel);
//		base.closeWindow(openMobileHandel);
//		base.jumpToWindow(beforHandel);
		base.assertEqualsActualExpected(msg, "����ȷ�Ͻ���꣬��ȴ����������ɣ�");
	}
	//��֤ȷ�Ͻ������ʾ���ȴ��ܲ�����״̬
	public void checkShowFinalAuditStatus(String tenderid){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//td[a[contains(@href,'"+tenderid+"')]]/following-sibling::td[5]")), "�ȴ��ܲ�����");
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//td[a[contains(@href,'"+tenderid+"')]]/following-sibling::td[9]")), "�ȴ��ܲ�����");

	}
	
	/**
	 * �û�ȷ��
	 * ��ע�������P1����
	 * @author ������ 2015-8-7
	 */
	public void confirmLoan(String borrowerEmail, String loanAmount){
		
		String parentWindowHandle = "";
		String childWindowHandle = "";
		String uid = "";
		String tenderId = "";
		boolean isSuccess = false;
		boolean isclickConfirmLoan = false;
		
		//��ȡ�û�UID
		uid = dbData.getUID(borrowerEmail);
		//��ȡ��ƷID
		tenderId = dbData.getTenderId(uid);
		//���ȷ����Ƶ��¼���������
		isSuccess = dbData.insertEnsureVideo(tenderId, uid);
		base.assertEqualsActualExpectedByBoolean(isSuccess, true);
		parentWindowHandle = base.getCurrentWindowHandle();System.out.println("�����ھ����" + parentWindowHandle);
		//���ݽ������ȷ�Ͻ����
		isclickConfirmLoan = clickConfirmLoan(loanAmount);
		if(isclickConfirmLoan){
			//��ȡ�Ӵ��ھ��
			if(base.Windowsize()>1){
				childWindowHandle = base.getChildWindowHandle(parentWindowHandle);System.out.println("�Ӵ��ھ����" + childWindowHandle);//---------����
				base.jumpToWindow(childWindowHandle);System.out.println("��ǰ���ھ����" + base.getCurrentWindowHandle());//---------����
				if(childWindowHandle.equals(parentWindowHandle)){
					base.turnToNewPage();
				}
			}
			base.assertEqualsActualExpectedByBoolean(isDisplayed("��ͨ�ֻ���ݻ���ҵ��"), false);
			base.assertEqualsActualExpectedByBoolean(isDisplayed("¼�Ʊ�ȷ����Ƶ"), false);
			//���Ķ���ͬ����ӽ���
			agree();
		}
		else{
			System.out.println("error_�ѷ����Ľ��û��'ȷ�ϽӴ�'��ť");
		}
	}
	
	/**
	 * ��ȡ��һҳ��ť
	 * @author ������ 2015-8-14
	 */
	public String getNextBtn(){
		List<WebElement> liList = new ArrayList<WebElement>();
		liList = base.getElements(By.xpath("//div[@id='Pagination']/ul/li"));
		String value = "";
		int i = 0;
		int size = liList.size();
		for(; i < size; i++){
			value = liList.get(i).getText();System.out.println("li��value:" + value);
			if(value.equals(">")){
				i++;
				break;
			}
		}
		
		return String.valueOf(i);
	}
	
	/**
	 * ���ݽ������ȷ�Ͻ���� ���� ���ϴ����ϡ�
	 * @return
	 * @author ������ 2015-8-7
	 */
	public boolean clickConfirmLoan(String loanAmount){
		
		List<WebElement> rowList = null;
		String tempAmountString = "";
		boolean isTrue = false;
		//����������
		By operation = null;
		String operationValue = "";
		
		do{
			rowList = new ArrayList<WebElement>();
			//��ȡ���н��
			rowList = base.getElements(By.xpath("//div[@id='_content_child']//tbody//tr/td[3]"));
			int size = rowList.size();

			for(int i = 0; i < size; i++){
				tempAmountString = rowList.get(i).getText();
				//�ַ�������
				tempAmountString = base.stringToReplace(tempAmountString, "��", "");
				tempAmountString = base.stringToReplace(tempAmountString, ",", "");System.out.println("��" + tempAmountString);//----------����
				//������ڴ�����
				if(tempAmountString.equals(loanAmount)){System.out.println("���ڣ�" + (i+1));//----------����
					//��ȡ������
					operation = By.xpath("//div[@id='_content_child']//tbody//tr[" + (i+1) + "]/td[12]/a");
	//				operation = By.xpath("//div[@id='_content_child']//tbody//tr[4]/td[12]/a");
					isTrue = base.isElementPresent(operation);System.out.println("���Ƿ���ڣ�" + isTrue);//----------����
					if(isTrue){
						operationValue = base.getElementTextWithWait(operation);System.out.println("�е�ֵ��" + operationValue);//----------����
						if(operationValue.equals("ȷ�Ͻ��") || operationValue.equals("�ϴ�����")){
							base.clickWithWait(operation);
							break;
						}
					}
				}
			}
			
			//���û�У������һҳ
			if(!isTrue){
				boolean isBtnDisabled = false;
				String local = getNextBtn();
				//�Ƿ�����;trueΪ���أ�falseΪ��ʾ
				isBtnDisabled = base.isElementContainsValue(By.xpath("//div[@id='Pagination']/ul/li["+ local +"]"), "class", "pgEmpty");System.out.println("��һҳ��ť�Ƿ����أ� " + isBtnDisabled);//------------����
				//�жϵ�ǰҳ�Ƿ������һҳ������һҳ��ť�Ƿ�����
				if(isBtnDisabled){
					System.out.println("error_�б�û���ҵ������");
					break;
				}
				else{
					base.clickWithWait(By.xpath("//div[@id='Pagination']/ul/li["+ local +"]"));
					base.sleep(5000);
				}
			}
			base.sleep(5000);
		}while(!isTrue);
		
		return isTrue;
	}
	
	/**
	 * �ϴ�����
	 * @param loanAmount:�����
	 * @author ������ 2015-8-14
	 */
	public void uploadMaterial(String loanAmount){
		
		String parentWindowHandle = "";
		String childWindowHandle = "";
		boolean isUploadMaterial = false;
		String curPath = new File("").getAbsolutePath();//��ǰ·��
		String filePath = curPath + "\\images\\das.jpg";
		//ѡ���ļ�
		Pattern selectBtn =new Pattern(curPath + "\\images\\xuanzewenjian.png");
		//�ļ���
		Pattern forderBtn =new Pattern(curPath + "\\images\\wenjianming.png");
		//��
		Pattern openBtn =new Pattern(curPath + "\\images\\dakai.png");
		Screen screen = new Screen();
	
		
		parentWindowHandle = base.getCurrentWindowHandle();System.out.println("�����ھ����" + parentWindowHandle);
		//���ݽ�������ϴ����ϡ�
		isUploadMaterial = clickConfirmLoan(loanAmount);
		base.sleep(5000);
		if(isUploadMaterial){
			//��ȡ�Ӵ��ھ��
			if(base.Windowsize()>1){
				childWindowHandle = base.getChildWindowHandle(parentWindowHandle);System.out.println("�Ӵ��ھ����" + childWindowHandle);//---------����
				base.jumpToWindow(childWindowHandle);System.out.println("��ǰ���ھ����" + base.getCurrentWindowHandle());//---------����
				if(childWindowHandle.equals(parentWindowHandle)){
					base.turnToNewPage();
				}
			}
			//ѡ�񡰽����;��
			base.elementSelectByVisibleText(By.xpath("//select[@id='loanCategory']"), "���������");
			base.clickWithWait(By.xpath("//span[text()='ȷ��']"));
			base.sleep(1000);
			base.acceptAlert();
			base.sleep(3000);
			//�������ͨ��Tab
			base.clickWithWait(By.xpath("//span[@id='spanli3']"));
			base.clickWithWait(By.xpath("//li[@id='datumCateId0']"));
			base.sleep(1000);
			//������ϴ�ͼƬ��
			base.clickWithWait(By.xpath("//div[@id='operateArea']/center/input[1]"));
			
	        try {
				screen.click(selectBtn);
				screen.type(forderBtn,filePath);
				screen.click(openBtn);
				base.sleep(2000);
				base.clickWithWait(By.xpath("html/body/div[5]/div[11]/div/button[1]"));
				base.sleep(5000);
			} catch (FindFailed e1) {
				e1.printStackTrace();
			}
	        
	        base.acceptAlert();
	        base.sleep(2000);
	        base.clickWithWait(By.xpath("html/body/div[5]/div[11]/div/button[2]"));
	        base.sleep(2000);
	        base.closeWindow(childWindowHandle);
		}
		
	}
	
	/**
	 * ����Ԫ
	 * ���������
	 */
	public void clickLoanApplication(){
		base.clickWithWait(By.cssSelector(".pub_btn_138.mt20"));
	}
	
	/**
	 * ����
	 * @param repaymentWay:���ʽ(1:ÿ�»��2����ǰһ���Ի��壻3�� ��������Ҫ�����ı���)
	 * @author ������ 2015-8-17
	 */
	public void repayment(String repaymentWay){
		//�����ҵĽ��
		myAccountPage.turnToMyAccount("�ҵĽ��");
		boolean isDisplayed = false;
		base.sleep(5000);
		//�ж��Ƿ�������
		isDisplayed = base.isDisplayed(loanListByFirst);System.out.println("�ҵĽ��_�����ڻ��������1��" + isDisplayed);//------����
		if(isDisplayed){
			//ÿ�»���
			if(repaymentWay.equals("month")){
				while(true){
					if(!isDisplayed){break;}
					//1.�������
					base.clickWithWait(monthlyRepaymentLink);
					base.sleep(2000);
					//2.��������ȷ�Ͽ�
					base.assertEqualsActualExpectedByBoolean(!base.isNone(outAllWindow), true);
					base.sleep(2000);
						
					base.clickWithWait(okBtn);
					base.sleep(3000);
					if(base.isAlertPresent()){
						base.acceptAlert();
					}
					base.sleep(5000);
					isDisplayed = base.isDisplayed(loanListByFirst);System.out.println("�ҵĽ��_�����ڻ��������2��" + isDisplayed);//------����
				}
			}
			//��ǰһ���Ի���
			else if(repaymentWay.equals("all")){
				//�鿴���׼�¼
				//1.��������ȡ�˻����
				base.clickWithWait(monthlyRepaymentLink);
				base.sleep(2000);
				//2.��������ȷ�Ͽ�
				base.assertEqualsActualExpectedByBoolean(!base.isNone(outAllWindow), true);
				base.sleep(2000);
				//3.�������ǰһ���Ի��塱
				base.clickWithWait(allRdo);
				base.sleep(1000);
				base.clickWithWait(okBtn);
				base.sleep(1000);
				base.acceptAlert();
			}
			//��������Ҫ�����ı���
			else if(repaymentWay.equals("advance")){
				;
			}
			else{
				System.out.println("error_����ȷ�ϴ��ڣ�û����ѡ��Ļ��ʽ��");
			}
		}
		else{
			Reporter.log("error_�ҵ��˻�_�ҵĽ���_�ҵĽ��_û�н������");
			System.out.println("error_�ҵ��˻�_�ҵĽ���_�ҵĽ��_û�н������");
		}
	}
	
	/**
	 * ��֤����ɹ���ı仯
	 * ��ע�����ڲ�������ϡ�٣�δ���л����������������������һ�λ���
	 * @author ������ 2015-7-23
	 */
	public void checkRepaymentChanges(){
		
		//�����ҵĽ��
		myAccountPage.turnToMyAccount("�ҵĽ��");
		boolean isDisplayed = false;
		//�ж��Ƿ�������
		isDisplayed = base.isDisplayed(loanListByFirst);//System.out.println("�ҵĽ��_�����ڻ�������ݣ�" + isDisplayed);//------����
		if(isDisplayed){
			//�鿴�����б�
			//1.����������򿪰�ť
			base.clickWithWait(viewDetailsOpenBtn);
			base.assertEqualsActualExpectedByBoolean(true, base.isElementPresent(viewDetailsCloseBtn));
			base.sleep(1000);
			//2.��֤�����б��Ƿ����
			base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(loanListByMyLoan, "style", "table"), true);
			
			//�鿴���׼�¼
			//1.������������ȡ�˻����
			base.clickWithWait(monthlyRepaymentLink);
			//2.��������ȷ�Ͽ�
			base.assertEqualsActualExpectedByBoolean(!base.isNone(outAllWindow), true);
			base.sleep(2000);
			//3.��ȡ������˻���
			String balanceByWindowStr = base.getElementTextWithWait(balanceByWindow);
			//ȥ����
			balanceByWindowStr = balanceByWindowStr.substring(1);//System.out.println("����ȷ�϶Ի���_�����˻����:" + balanceByWindowStr);//-----����
			//�رա�����ȷ�϶Ի���
			base.clickWithWait(cancelBtn);
			//4.���뽻�׼�¼
			myAccountPage.turnToMyAccount("���׼�¼");
			//5.�ж���¼�Ƿ���ڡ�������ڣ����ȡ��һ�����׼�¼��˵��Ϊ�����»���������Ա�
			base.assertEqualsActualExpectedByBoolean(base.isElementPresent(transactionRecordPage.recordsList), true);
			base.sleep(1000);
			//�жϵ�һ����˵���Ƿ��ǡ����»��
			base.assertEqualsActualExpected(base.getElementTextWithWait(transactionRecordPage.explainRecords), "���»���");
			base.sleep(1000);//System.out.println("���׼�¼_��" + base.getElementTextWithWait(balanceRecords));
			//�жϵ�һ�������
			base.assertEqualsActualExpected(base.getElementTextWithWait(transactionRecordPage.balanceRecords), balanceByWindowStr);
			
			//�鿴վ����
			//1.���վ����
			insideLetterPage.clickInsideLetter();
			//2.��֤��ϵͳ��Ϣ���Ƿ�ѡ��
			//insideLetterPage.checkSysMsgTab();
			//��ȡϵͳ��ϢIframe
			//base.switchToFrame(insideLetterPage.sysMsgIframe);
			//3.�鿴��һ����Ϣ��ͼ���Ƿ�δ��
			boolean isContains = base.isElementContainsValue(insideLetterPage.envelopeIconBySysMsg, "src", "mailboxnoread");
			base.assertEqualsActualExpectedByBoolean(isContains, true);
		}
		else{
			Reporter.log("error_�ҵ��˻�_�ҵĽ���_�ҵĽ��_û�н������");
			System.out.println("error_�ҵ��˻�_�ҵĽ���_�ҵĽ��_û�н������");
		}
	}
	
/**********************************��������*********************************************/	
	//��������-��������-���ҳ����ʾ
	public void checkBasicInfoPage(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(Title), "�ҵĽ��>��������");
		String bluecolor=base.getStyle("document.getElementById('_content').getElementsByTagName('a')[0]","color");
		base.assertEqualsActualExpected(bluecolor, "rgb(0, 144, 240)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(BasicInfoLnk), "��������");
		String redcolor= base.getStyle("document.getElementById('info0')","color");
		base.assertEqualsActualExpected(redcolor, "rgb(248, 24, 32)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(EmergencyContactLnk), "������ϵ��");
		base.assertEqualsActualExpected(base.getElementTextWithWait(CreditInfoLnk), "��������");
		List<WebElement> flag = base.getElements(OptionFlag);
		int num = flag.size()-1,optional=0,required=0;
		for(int i=0;i<num;i++){
			if(flag.get(i).getText().equals("*")){
				required=required+1;
			}else{
				optional=optional+1;
			}
		}
		base.assertEqualsActualExpectedByInt(required, 5);
		base.assertEqualsActualExpectedByInt(optional, 8);
		base.assertEqualsActualExpected(base.getElementText(NotesTxt), "ע������Ӹ�������ʱ����ο�����3����ʾ\n1��������ǹ�н�壬����д�����˹����ͼ�ͥ���������������\n2��������Ǹ��徭Ӫ�ߣ�����д�����˼�ͥ�;�Ӫҵ�񡢹�ģ���ܣ�\n3���������ũ��������д�����˼�ͥ����ʹ�ҵ��Ŀ��ϸ���ܵȡ�");
		base.assertEqualsActualExpected(base.getElementText(baseSaveBtn), "���沢����");
		base.assertEqualsActualExpected(base.getElementNoWait(baseSaveBtn).getCssValue("color"), "rgba(255, 255, 255, 1)");
		String image= base.getElementNoWait(baseSaveBtn).getCssValue("background-image");System.out.println(image);
		if(base.indexURL.contains("client")||base.indexURL.contains("test")){
			base.assertTrueByBoolean(image.contains(base.indexURL+"/page/userMgr/images/myhome_bg.png"));
		}else if(base.indexURL.contains("www")){
			base.assertTrueByBoolean(image.contains("http://static7.eloancn.com//page/userMgr/images/myhome_bg.png"));
		}
	}
	//�Ǳ���ѡ���У��
	public void checkOptionalOption(){
		String optional[]={"����","סլ�绰","QQ����","��λ������ҵ","��λ����","��λ��ַ","��λ�绰","������Ϣ"};
		for(int i=0;i<7;i++){
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//tr[th[span[text()='"+optional[i]+"']]]/td")), "");
		}
		saveBaseInfo("��","11","��ѡ��","","","����","�����в�ƽ��","�����в�ƽ��","","","","","");
		saveBaseInfo("��","11","��ѡ��","12764423","","����","�����в�ƽ��","�����в�ƽ��","","����ͬ������","","4000085","");
	}
	//����ѡ���У��
	public void checkRequiredOption(){
		String required[] = {"�Ա�","����","�������ڵ�","��ĸ���ڵ�","�־�ס�ص�ַ"};
		for(int i=0;i<5;i++){
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//tr[th[span[text()='"+required[i]+"']]]/td")), "*");
		}	
		inputCurrentAddress("");
		clickBaseSavebtn();
		base.checkElmentText(ErrorTipTxt, "�����־�ס�ص�ַ��");
		inputParentAddress("");
		clickBaseSavebtn();
		base.checkElmentText(ErrorTipTxt, "����д��ĸ���ڵأ�");
		selectNativePlace("��ѡ��");
		clickBaseSavebtn();
		base.checkElmentText(ErrorTipTxt, "��ѡ�񻧼����ڵأ�");		
		saveAge("");
	}

	//ѡ���Ա�
	public void selectGendar(String gendar){
		base.clickWithWait(By.xpath("//label[contains(text(),'"+gendar+"')]"));
	}
	//��������
	public void inputAge(String age){
		base.checkElementVisible(inputAge);
		base.sendKeysWithWait(inputAge, age);
	}
	//���������ϵ��Ա����䲻�ɱ༭
	public void checkGendarandAge(){
		base.assertNotNullBy(SelectedGendar);
		String age = base.getLnkElementText(inputAge, "value");
		base.assertNotEqualsActualExpected(age, "");
		String gendar = base.getElementTextWithWait(SelectedGendar);
		if(gendar.equals("Ů")){
			base.assertEqualsActualExpected(base.getElementTextWithWait(DisabledGendar), "��");
			base.clickWithWait(DisabledGendar);
			base.assertEqualsActualExpected(base.getElementText(SelectedGendar), gendar);
		}
		base.assertEqualsActualExpected(base.getLnkElementText(inputAge, "readonly"),"true");
	}
	//��������
	public void saveAge(String age){
//		clickBaseInfoLnk();
		inputAge(age);
		clickBaseSavebtn();
		if(age.equals("")){
			base.checkElmentText(ErrorTipTxt, "���������䣡");
		}else if(!base.isNumeric(age)){
			base.checkElmentText(ErrorTipTxt, "����ֻ������������");
		}
	}
	//ѡ������
	public void selectNation(String nation){
		base.elementSelectByVisibleText(selectNation, nation);
	}
	//����סլ�绰
	public void inputPhone(String phone){
		base.sendKeysWithWait(inputPhone, phone);
		base.clickWithWait(inputAge);
		if(phone.length()>15){
			base.assertEqualsActualExpected(base.getLnkElementText(inputPhone,"value"), phone.substring(0,15));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(inputPhone,"value"), phone);
		}
	}
	//����QQ����
	public void inputQQNum(String QQ){
		base.sendKeysWithWait(inputQQNum, QQ);
		base.clickWithWait(inputAge);
		if(QQ.length()>14){
			base.assertEqualsActualExpected(base.getLnkElementText(inputQQNum,"value"), QQ.substring(0,14));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(inputQQNum,"value"), QQ);
		}
	}
	public void clearQQNum(){
		base.clearTxt(inputQQNum);
		base.assertEqualsActualExpected(base.getLnkElementText(inputQQNum,"value"),"");
	}

	//ѡ�񻧼����ڵ�
	public void selectNativePlace(String place){
		base.elementSelectByVisibleText(NativePlace, place);
	}

	//���븸ĸ���ڵ�
	public void inputParentAddress(String parentaddress){
		base.sendKeysWithWait(parentAddressTxt, parentaddress);
		base.clickWithWait(inputAge);
		if(parentaddress.length()>40){
			base.assertEqualsActualExpected(base.getLnkElementText(parentAddressTxt,"value"), parentaddress.substring(0,40));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(parentAddressTxt,"value"), parentaddress);
		}
	}
	//�����־�ס�ص�ַ
	public void inputCurrentAddress(String address){
		base.sendKeysWithWait(currentAddressTxt, address);
		base.clickWithWait(inputAge);
		if(address.length()>38){
			base.assertEqualsActualExpected(base.getLnkElementText(currentAddressTxt,"value"), address.substring(0,38));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(currentAddressTxt,"value"), address);
		}
	}

	//���뵥λ������ҵ
	public void inputCompanyIndustry(String industry){
		base.sendKeysWithWait(inputCompanyIndustry, industry);
		base.clickWithWait(inputAge);
		if(industry.length()>40){
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyIndustry,"value"), industry.substring(0, 40));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyIndustry,"value"), industry);
		}
	}

	//���뵥λ����
	public void inputCompanyName(String name){
		base.sendKeysWithWait(inputCompanyName, name);	
		base.clickWithWait(inputAge);
		if(name.length()>40){
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyName, "value"), name.substring(0,40));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyName, "value"), name);
		}
	}
	//��������沢��������ť
	public void clickBaseSavebtn(){
		base.clickWithWait(baseSaveBtn);
	}
	public void saveCompanyName(String name){
		clickBaseInfoLnk();
		inputCompanyName(name);
		clickBaseSavebtn();
		if(base.isNumeric(name)){
			base.checkElmentText(ErrorTipTxt, "��λ���Ʋ����Ǵ����֣�");
		}else{
			base.checkNoElement(ErrorTipTxt);
			base.checkElmentText(CurrentTitle, "������ϵ��");
		}
	}
	//���뵥λ�绰
	public void inputCompanyPhone(String phone){
		base.sendKeysWithWait(inputCompanyPhone, phone);
		base.clickWithWait(inputAge);
		if(phone.length()>18){
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyPhone, "value"), phone.substring(0,18));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyPhone, "value"), phone);
		}
	}
	
	//���뵥λ��ַ
	public void inputCompanyAddress(String address){
		base.sendKeysWithWait(inputCompanyAddress, address);
		base.clickWithWait(inputAge);
		if(address.length()>40){
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyAddress, "value"), address.substring(0,40));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyAddress, "value"), address);
		}
	}
	//��鵥λ��ַ
	public void checkCompanyAddress(){
//		base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyAddress, "value"), "");
		inputCompanyAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklmn");
		clickBaseSavebtn();
		base.checkNoElement(ErrorTipTxt);
		base.checkElmentText(CurrentTitle, "������ϵ��");
		clickBaseInfoLnk();
		inputCompanyAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklmno");
	}
	//����������Ϣ
	public void inputDescription(String description){
		base.sendKeysWithWait(inputDescription, description);
	}	
	public void saveDescription(String description){
		clickBaseInfoLnk();
		inputDescription(description);
		clickBaseSavebtn();
		if(description.length()>100){
			base.checkElmentText(CurrentTitle, "��������");
			base.checkElmentText(ErrorTipTxt, "�������ܳ���50���֣�");
		}else{
			base.checkNoElement(ErrorTipTxt);
			base.checkElmentText(CurrentTitle, "������ϵ��");
		}
	}
	//���������Ϣ
	public void checkDescriptionInfo(){
		saveDescription("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuv");
		clickBaseInfoLnk();
		inputDescription("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvw");
		saveDescription("01234567890123456789��λ������������뺺�ֵ�����沢������ť-=_[];~,.+`!{}:<>?abcdefghijklmnopqrstuvwxyzabcdefghijklmnop");
	}
	//������д�Ļ�����Ϣ
	public void saveBaseInfo(String gendar,String age,String nation,String phone,String QQNum,String nativeplace,String parentadd,String currentadd,String companyindustry,String companyname,String companyAdd,String companyPhone,String des){
		clickBaseInfoLnk();
		if(!base.isReadonly(inputAge)){
			inputAge(age);
		}
		if(!base.isElementPresentNoWait(DisabledGendar)){
			selectGendar(gendar);
		}	
		selectNation(nation);
		inputPhone(phone);
		inputQQNum(QQNum);
		selectNativePlace(nativeplace);
		inputParentAddress(parentadd);
		inputCurrentAddress(currentadd);
		inputCompanyIndustry(companyindustry);
		inputCompanyName(companyname);
		inputCompanyAddress(companyAdd);
		inputCompanyPhone(companyPhone);
		inputDescription(des);
		clickBaseSavebtn();
		if(age.equals("")||nativeplace.equals("��ѡ��")||parentadd.equals("")||currentadd.equals("")){
//			base.checkElmentText(CurrentTitle, "��������");
//			if(age.equals(""))					base.checkElmentText(ErrorTipTxt, "���������䣡");
//			else if(nativeplace.equals("��ѡ��"))		base.checkElmentText(ErrorTipTxt, "��ѡ�񻧼����ڵأ�");
//			else if(parentadd.equals(""))			base.checkElmentText(ErrorTipTxt, "����д��ĸ���ڵأ�");
//			else if(currentadd.equals(""))			base.checkElmentText(ErrorTipTxt, "�����־�ס�ص�ַ��");
		}else{
			base.checkNoElement(ErrorTipTxt);
			base.checkElmentText(CurrentTitle, "������ϵ��");
		}
	}
	//����ѱ���Ļ�����Ϣ
	public void checkUpdatedBaseInfo(String gendar,String age,String nation,String phone,String QQNum,String nativeplace,String parentadd,String currentadd,String companyindustry,String companyname,String companyAdd,String companyPhone,String des){
		if(!base.isReadonly(inputAge)){
			base.assertEqualsActualExpected(base.getLnkElementText(inputAge, "value"), age);
		}
		if(!base.isElementPresentNoWait(DisabledGendar)){
			base.checkElementSelected(By.xpath("//label[contains(text(),'"+gendar+"')]/input"),10);
		}	
		base.assertEqualsActualExpected(base.getSelectedOptionTxt(selectNation), nation);
		base.assertEqualsActualExpected(base.getLnkElementText(inputPhone, "value"), phone);
		base.assertEqualsActualExpected(base.getLnkElementText(inputQQNum, "value"), QQNum);	
		base.assertEqualsActualExpected(base.getSelectedOptionTxt(NativePlace), nativeplace);
		base.assertEqualsActualExpected(base.getLnkElementText(parentAddressTxt, "value"), parentadd);
		base.assertEqualsActualExpected(base.getLnkElementText(currentAddressTxt, "value"), currentadd);
		base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyIndustry, "value"), companyindustry);
		base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyName, "value"), companyname);
		base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyAddress, "value"), companyAdd);
		base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyPhone, "value"), companyPhone);
		base.assertEqualsActualExpected(base.getLnkElementText(inputDescription, "value"), des);
	}
	//����������֤-����޸Ļ�����Ϣ
	public void ModifyBaseInfo(){
		saveBaseInfo("��","19","����","123456789012","123456","����","����ʡ��¥��","����ʡ̨����","���������","�����е�","����ʡ̨����","78945201","sdfasd23782502365~��������+|{}������������-=���й��Ļ�");
		myAccountPage.clickMyDebtLnk();
		clickBtn("��������");
		base.checkElementVisible(DisabledGendar);
		base.assertEqualsActualExpected(base.getLnkElementText(inputAge, "readonly"),"true");
		saveBaseInfo("Ů","20","׳��","1234567890","12345678","����","�����к�����","�����в�ƽ��","����������ҵ","����ͬ������","�����к�����","44400088","��������Ϊ����عɳ�Ա��ҵ���ǹ����׳���ͬ��O2O��ģʽ��������ƽ̨");
		myAccountPage.clickMyDebtLnk();
		clickBtn("��������");
		checkUpdatedBaseInfo("Ů","20","׳��","1234567890","12345678","����","�����к�����","�����в�ƽ��","����������ҵ","����ͬ������","�����к�����","44400088","��������Ϊ����عɳ�Ա��ҵ���ǹ����׳���ͬ��O2O��ģʽ��������ƽ̨");
	}
	//δ��������֤-����޸Ļ�����Ϣ
	public void checkUpdateBaseInfo(){
		saveBaseInfo("Ů","19","����","123456789012","123456","����","����ʡ��¥��","����ʡ̨����","���������","�����е�","����ʡ̨����","78945201","sdfasd23782502365~��������+|{}������������-=���й��Ļ�");
		myAccountPage.clickMyDebtLnk();
		clickBtn("��������");
		checkUpdatedBaseInfo("Ů","19","����","123456789012","123456","����","����ʡ��¥��","����ʡ̨����","���������","�����е�","����ʡ̨����","78945201","sdfasd23782502365~��������+|{}������������-=���й��Ļ�");
		saveBaseInfo("��","20","׳��","1234567890","12345678","����","�����к�����","�����в�ƽ��","����������ҵ","����ͬ������","�����к�����","44400088","��������Ϊ����عɳ�Ա��ҵ���ǹ����׳���ͬ��O2O��ģʽ��������ƽ̨");
		myAccountPage.clickMyDebtLnk();
		clickBtn("��������");
		checkUpdatedBaseInfo("��","20","׳��","1234567890","12345678","����","�����к�����","�����в�ƽ��","����������ҵ","����ͬ������","�����к�����","44400088","��������Ϊ����عɳ�Ա��ҵ���ǹ����׳���ͬ��O2O��ģʽ��������ƽ̨");
	}
	//��������-������ϵ��-���ҳ����ʾ
	public void checkContactPage(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(Title), "�ҵĽ��>��������");
		String bluecolor=base.getStyle("document.getElementById('_content').getElementsByTagName('a')[0]","color");
		base.assertEqualsActualExpected(bluecolor, "rgb(0, 144, 240)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(BasicInfoLnk), "��������");
		base.assertEqualsActualExpected(base.getElementTextWithWait(EmergencyContactLnk), "������ϵ��");
		String redcolor= base.getStyle("document.getElementById('info1')","color");
		base.assertEqualsActualExpected(redcolor, "rgb(248, 24, 32)");
		String redline = base.getStyle("document.getElementById('info1')","border-bottom-color");
		String solidline = base.getStyle("document.getElementById('info1')","border-bottom-style");
		base.assertEqualsActualExpected(redline, "rgb(248, 24, 32)");
		base.assertEqualsActualExpected(solidline, "solid");
		base.assertEqualsActualExpected(base.getElementTextWithWait(CreditInfoLnk), "��������");
		base.assertEqualsActualExpected(base.getElementTextWithWait(TipsTxt), "��ܰ��ʾ������д����ϵ������ʱ�����ǿ�����ϵ���ˡ�");
		String subtitles[] = {"����","�������","ͬѧ","ͬ��","��ͨ����","����"};
		String content[]= {"����","�ֻ�"};
		int required = 0;
		for(int i=1;i<=6;i++){
			String title=base.getElementTextWithWait(By.xpath("//form[@id='connectionForm']/h3["+i+"]/span"));
			base.assertEqualsActualExpected(title, subtitles[i-1]);
			for(int j=1;j<=2;j++){
				String nameorphone = base.getElementTextWithWait(By.xpath("//form[@id='connectionForm']/table["+i+"]/tbody/tr["+j+"]/th"));
				String flag = base.getElementTextWithWait(By.xpath("//form[@id='connectionForm']/table["+i+"]/tbody/tr["+j+"]/td"));
				String type= base.getLnkElementText(By.xpath("//form[@id='connectionForm']/table["+i+"]/tbody/tr["+j+"]/td[2]/input"), "type");
				if(flag.equals("*")){
					required=required+1;
				}
				base.assertEqualsActualExpected(nameorphone, content[j-1]);
				base.assertEqualsActualExpected(type, "text");
			}
		}
		base.assertEqualsActualExpectedByInt(required, 12);
		base.assertEqualsActualExpected(base.getElementText(emergencyContactSaveBtn), "���沢����");
		base.assertEqualsActualExpected(base.getElementNoWait(emergencyContactSaveBtn).getCssValue("color"), "rgba(255, 255, 255, 1)");
		String image= base.getElementNoWait(emergencyContactSaveBtn).getCssValue("background-image");
		if(base.indexURL.contains("client")||base.indexURL.contains("test")){
			base.assertTrueByBoolean(image.contains(base.indexURL+"/page/userMgr/images/myhome_bg.png"));
		}else if(base.indexURL.contains("www")){
			base.assertTrueByBoolean(image.contains("http://static7.eloancn.com//page/userMgr/images/myhome_bg.png"));
		}
	}
	//�������ϴ���-�������ϴ�ҳ���Ĭ��״̬
	public void checkUploadDocData(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(Title), "�ҵĽ��>�����ϴ�");
		String bluecolor= base.getElementWithWait(MyDebtTitle).getCssValue("color");
		base.assertEqualsActualExpected(bluecolor, "rgba(0, 144, 240, 1)");
		base.assertTrueByBoolean(base.getLnkElementText(CheckFile, "class").equals("selected"));
		base.assertEqualsActualExpected(base.getElementNoWait(CheckFile).getCssValue("color"), "rgba(255, 255, 255, 1)");
		String image = base.getElementNoWait(CheckFile).getCssValue("background-image");
		if(base.indexURL.contains("client")||base.indexURL.contains("test")){
			base.assertTrueByBoolean(image.contains(base.indexURL+"/page/userMgr/images/myhome_bg.png"));
		}else if(base.indexURL.contains("www")){
			base.assertTrueByBoolean(image.contains("http://static7.eloancn.com/page/userMgr/images/myhome_bg.png"));
		}
		String FileTypes[] = {"�������֤","�������֤","���ڱ�","����","��ʻ֤","�����籣","���ʿ����н�3������ˮ","�ǹ��ʿ����н�3������ˮ","Ӫҵִ��","�̶��绰��3�����굥","֧����������ˮ","ס�������Ƭ","����֤��"};
		String FileTypes1[] = {"�������֤","�������֤","���ڱ�","��ֱϵ������Ӱ��","����","��ʻ֤","�����籣","���ʿ����н�3������ˮ","�ǹ��ʿ����н�3������ˮ","Ӫҵִ��","�̶��绰��3�����굥","֧����������ˮ","ס�������Ƭ","����֤��"};
		List<WebElement> types = base.getElements(FileType);
		if(types.get(3).getText().equals("��ֱϵ������Ӱ��")){
			FileTypes=FileTypes1;
		}
		for(int i=0;i<FileTypes.length;i++){
			base.assertEqualsActualExpected(types.get(i).getText(), FileTypes[i]);
		}
		base.checkElementVisible(WarmPromptPart);
		String redTips[]={"��߽��������ٶȺ͸���","δ���κ�����޸ĵ�ԭͼ","���������ɲ���ȷ��","ϵͳ������"};
		List<WebElement> fourtip = base.getElements(RedTips);
		for(int i=0;i<redTips.length;i++){
			base.assertEqualsActualExpected(fourtip.get(i).getText(), redTips[i]);
			String color= fourtip.get(i).getCssValue("color");
			base.assertEqualsActualExpected(color, "rgba(248, 105, 0, 1)");
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(CreditFile), "����֤������");
		base.assertEqualsActualExpected(base.getElementTextWithWait(CheckFile), "��˲���");
		base.assertEqualsActualExpected(base.getElementTextWithWait(IncreaseFile), "�����������");
		base.assertEqualsActualExpected(base.getElementTextWithWait(PublicFile), "������������");	
	}
	
	//**********************������*******************************
	public void QuotaRequest(String type,String date,String expect,String desc){
		base.elementSelectByVisibleText(QuotaTypeSel, type);
		base.elementSelectByVisibleText(ValidDateSel, date);
		base.sendKeysWithWait(inputExpectQuota, expect);
		base.sleep(1000);
		base.sendKeysWithWait(inputDesc, desc);
		base.clickWithWait(ApplicationBtn);
		base.checkAlertText("����δ��ɣ����ϴ�����֤������!");
		base.checkElmentText(SelectedPart, "�����������");
	}
	
}
