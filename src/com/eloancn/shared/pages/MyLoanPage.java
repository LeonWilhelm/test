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
 * “我的账户”-“我的借款”页面
 */
public class MyLoanPage {
	
	Base base = new Base();
	DBData dbData = new DBData();
	
	InsideLetterPage insideLetterPage = new InsideLetterPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	TransactionRecordPage transactionRecordPage = new TransactionRecordPage();
	
	String myLoanHandel = "";
	String openMobileHandel = "";
	
	//我的借款
	public static By MyLoanTxt =By.cssSelector("div.newtitle>h3");	 
	
	
	//正在还款的借款
	By loanListByFirst = By.cssSelector("#_content_child > div.mt15");                             //借款列表第一条数据
	By outAllWindow = By.cssSelector("#out_all");                                                             //还款确认弹出框
	By okBtn = By.xpath("//button[@id='repayButtonSubmit']");												  //还款确认窗口_确认按钮
	By allRdo = By.xpath("//input[@id='all']");																  //还款确认窗口_提前一次性还清
	By balanceByWindow = By.cssSelector("#balancediv");                                                       //账户余额
	By cancelBtn = By.cssSelector(".RT_cancel");                                                              //还款确认窗口_取消按钮
	By viewDetailsOpenBtn = By.cssSelector(".fl.record_tit.colorF8.record_close");                 //借款详情打开按钮
	By viewDetailsCloseBtn = By.cssSelector(".fl.record_tit.colorF8.record_close.record_open");    //借款详情关闭按钮
	By loanListByMyLoan = By.cssSelector(".record_table");                                         //借款列表
	By monthlyRepaymentLink = By.cssSelector(".lending_record > a:nth-child(2)");                  //还款链接
	By BorrowDetailLnk = By.xpath("//div[@class='lending_record']/a[3]");
	
	/*****************已发布的借款****************/
	//已发布的借款Tab
	By publishedtab = By.id("published");
	static By SelectedTab = By.cssSelector("span.wd160.current");
	By AllLoanContent = By.id("_content_child");
	By LastPage=By.xpath("//div[@id='Pagination']/ul/li[text()='末页']");
	By FourthPageLnk = By.xpath("//div[@id='Pagination']/ul/li[4]");						//页数的第4个链接
	By LastTwoPage = By.xpath("//div[@id='Pagination']/ul/li[last()-2]");
	By FirstPage = By.xpath("//div[@id='Pagination']/ul/li[text()='首页']");
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");
	By LastOnePage = By.xpath("//div[@id='Pagination']/ul/li[text()='>']");		//末页的前一个链接

	//确认借贷
	By sureDebitBtn = By.xpath("//a[text()='确认借贷']");
	By LoanSubTitle = By.cssSelector("#_content_child>table>thead");
	By LoanPurposeLnk = By.xpath("//div[@id='_content_child']/table/tbody/tr/td[2]/a");
	//点击“联保贷标”的标类型弹出的联保信息
	By LBInfoTxt = By.id("addNewCardBackup");
	public By LBDCode = By.cssSelector("div.lyct>table>tbody>tr>td");
	By LBCodeCreater = By.xpath("//div[@class='lyct']/table/tbody/tr[2]");
	By LBCodeBeginTime= By.xpath("//div[@class='lyct']/table/tbody/tr[3]");
	By LBCodeEndTime = By.xpath("//div[@class='lyct']/table/tbody/tr[4]");
	By LBMember1 = By.xpath("//div[@class='lyct']/table/tbody/tr[5]");
	By LBMember2 = By.xpath("//div[@class='lyct']/table/tbody/tr[6]");
	
	//已全部还清的借款
	
	
	//尚未发布的借款
	
	/**************************************材料上传*****************************************/
	By CheckFile = By.id("materials_1");							//审核材料
	By CreditFile = By.id("materials_0");
	By IncreaseFile = By.id("materials_2");
	By PublicFile = By.id("materials_3");
	By FileType = By.cssSelector("#materialCont1>table>tbody>tr>th");//资料类型
	By WarmPromptPart = By.cssSelector("div.msg_cotainer.font12");
	By IncreaseSpeedTxt = By.cssSelector("span.colorF8");
	By RedTips = By.cssSelector("#promptMSG>span");
	By SelectedPart = By.cssSelector("li.selected");				//选中的信用证明材料/审核材料。。。
//	By OriginalImgTxt = By.xpath("//p[@id='promptMSG']/span[2]");
//	By ConfirmFalseTxt = By.xpath("//p[@id='promptMSG']/span[3]");
//	By SystemBlacklistTxt = By.xpath("//p[@id='promptMSG']/span[4]");
	
	/*************完善资料************/
	By Title = By.xpath("//div[@id='_content']/div/div");//“我的借款>完善资料”标题
	By MyDebtTitle = By.xpath("//div[@id='_content']/div/div/span/a");//“我的借款”标题
	By BasicInfoLnk = By.id("info0");	//基本资料
	By EmergencyContactLnk = By.id("info1");//紧急联系人
	By CreditInfoLnk =By.id("info2");//信用资料
	By CurrentTitle = By.cssSelector("span.wd110.current");
	
	//资料上传 完善资料 ...
	By currentlocationTxt =By.cssSelector(".sqed.ml5");
	//基本资料>>>>>>>>>>
	By OptionFlag = By.xpath("//form[@id='userNocategoryForm']/table/tbody/*/td[1]");//可选或必须的*
	By ManOption = By.xpath("//input[@name='gendar']");
	By SelectedGendar = By.xpath("//label[input[@checked='checked']]");
	By DisabledGendar = By.xpath("//label[input[@disabled='disabled']]");
	By inputAge= By.id("age");
	By selectNation = By.id("nationality");//选择民族
	By inputPhone = By.id("phone");														//住宅电话
	By inputQQNum = By.id("qqnumber");
	By NativePlace = By.id("nativePlace");//户籍所在地
	//父母所在地
	By parentAddressTxt =By.id("parentAddress");
	By currentAddressTxt = By.id("address");//现居住地地址
	By inputCompanyIndustry = By.id("companyIndustry");
	By inputCompanyName = By.id("companyName");
	By inputCompanyAddress = By.id("companyAddress");
	By inputCompanyPhone = By.id("companyPhone");
	By inputDescription = By.id("description");
	By NotesTxt = By.cssSelector("div.gbobal_questionList.mb15");//描述信息下的注意信息
	//基本资料的保存并继续按钮
	By baseSaveBtn = By.xpath("//*[@id='materialCont0']/a");
	By ErrorTipTxt = By.id("infortip");
	//紧急联系人>>>>>>>>>
	By ContactContent = By.id("materialCont1");
	By TipsTxt = By.cssSelector("div.pub_tip.mt20>div>p");//温馨提示
	By inputInfos = By.cssSelector("#connectionForm>table>tbody>tr>td>input");
	//姓名
	By namesTxt = By.cssSelector(".pub_text1[id*='friendname']");
	//手机
	By telTxt = By.cssSelector(".pub_text1[id*='friendmobile']");
	By ContactTipTxt = By.id("connectiontip");
	//紧急联系人保存并继续按钮
	By emergencyContactSaveBtn = By.xpath(".//*[@id='connectionForm']/a");
	//信用资料>>>>>>>>>>>
	By creditInfos = By.cssSelector("#usercategoryForm tbody>tr>td>select");
	//提交
	By creditInfoSaveBtn = By.id("creatOrUpdate");
/*************************申请增额***************************/
	By QuotaTypeSel = By.id("goodstype");
	By ValidDateSel = By.id("valid");
	By inputExpectQuota = By.id("expectquota");
	By inputDesc = By.id("description");
	By ApplicationBtn = By.cssSelector("button.pub_button.ml22");
	
	//通过更改数据库使得借款标总部初审通过或流标等
	public void UpdateTenderStatuswithSQL(String tenderid,String status){
		String sql="UPDATE d_tender SET STATUS="+status+" WHERE id= "+tenderid;
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}	
	//根据借款标目的更改数据库中借款标状态
	public void UpdateTenderStatusByTitlewithSQL(String purpose,String status){
		String sql="UPDATE d_tender SET STATUS='"+status+"' WHERE title= '"+purpose+"'";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}
	//根据借款标title获得借款标id
	public int getTenderIDwithSQL(String purpose){
		String sql="SELECT id FROM d_tender WHERE title='"+purpose+"'";
		int id=new DBData().ExecuteSelect(sql);
		return id;
	}
	//添加盟商初审通过记录
	public String addFirstTrialRecordwithSQL(String tenderid){
		Date date1= base.getTime();
		String date=base.dateFormat(date1, "yyyy-MM-dd HH:mm");
		String cdate=String.valueOf(date1.getTime()).substring(0, 10);
		String sql="INSERT INTO d_tender_first_trial(tid,operator,cdate,STATUS)VALUES("+tenderid+"/*借款标id*/,1,"+cdate+",1);";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
		return date;
	}
	//通过更改数据库添加联保人:13581838716,13581838717(320,321);13581838713,13581838714(323,324)
	public void addLBDTwoMemeberswithSQL(String LBDCode){
		String tenderid=LBDCode.substring(11);		
		String sql="UPDATE d_tender_warrant SET tid= "+tenderid+",joinid=(SELECT id FROM d_tender_lbdcode WHERE tenderCode='"+LBDCode+"') WHERE username='"+Data.tel_LBDCreaterName+"' OR username='"+Data.tel_LBDNoncreaterName+"'";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}
	//更改联保编码为不可用,参数为借款目的或联保贷编码
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
	//删除一条借款标数据
	public void DeleteTenderwithSQL(String purpose){
		String sql = "DELETE FROM d_tender WHERE title='"+purpose+"'";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}

	/**
	 * 徐天元
	 * 当前所在地是否正确  完善资料
	 */
	public void isCurrentlocationOK(String location){
		base.assertEqualsActualExpected(base.getElementTextWithWait(currentlocationTxt), location);
	}
	
	/**
	 * 徐天元
	 * 基本资料
	 */
	public void baseInfo(String parentAddress){
		base.sendKeysWithWait(parentAddressTxt, parentAddress);
		base.clickWithWait(By.cssSelector("#materialCont0>.pub_button.mt10.mb15.ml115"));//baseSaveBtn
	}
	
	/**
	 * 徐天元
	 * 我的借款点击5个按钮  申请额度 材料上传 完善资料 查看视频 开通代扣功能
	 */
	public void clickBtn(String nameBtn){
		if (nameBtn.equals("开通代扣功能")) {
			base.clickWithWait(By.cssSelector(".pub_btn_95]"));
		}else {
			base.clickWithWait(By.cssSelector(".pub_btn_75[value='" + nameBtn + "']"));
		}
	}
	//点击“基本资料”链接
	public void clickBaseInfoLnk(){
		base.clickWithWait(BasicInfoLnk);
		base.checkElementVisible(baseSaveBtn);
	}
	//点击“紧急联系人”链接
	public void clickEmergencyContactLnk(){
		base.clickWithWait(EmergencyContactLnk);
		base.checkElementVisible(ContactContent);
	}
	//完善资料--紧急联系人页面-姓名格式的校验
	public void checkEmergencyNames(){

		String names[]={"觉得这","有点画","点画蛇","来输出","语句来","的就是"};
		String tels[] ={"13510000011","13510000012","13510000013","13510000014","13510000015","13510000016"};
		writeEmergencyContact(names,tels);
		base.checkNoElement(ContactTipTxt);
		base.checkElmentText(CurrentTitle, "信用资料");
		String name[]={"","1526985263","qawsedcxfv","!@#$%^&*()","李 问",""};
		String name1[]={"问然也可以自己再写个一","问然也可以自己再写然一","问然也可以自己再写也一","问然也可以自己再写可一","问然也可以自己再写自一","问然也可以自己再写己一"};
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
					base.checkElmentText(ContactTipTxt, "第"+(i+1)+"个姓名不能为空！");
				}else if(length>10 || length<=10){
					if(length>10)		length=10;				
					if(base.isChinese(name[j].substring(0, length))){
						base.checkNoElement(ContactTipTxt);
						base.checkElmentText(CurrentTitle, "信用资料");
						clickEmergencyContactLnk();
						base.assertEqualsActualExpected(nameList.get(i).getAttribute("value"), name[j].substring(0, length));
					}else{
						base.checkElmentText(ContactTipTxt, "第"+(i+1)+"个姓名必须为汉字！");
					}
				}				
			}
		}		
	}
	//完善资料--紧急联系人页面-手机格式的校验
	public void checkEmergencyTels(){
		String names[]={"觉得这","有点画","点画蛇","来输出","语句来","的就是"};
		String tels[] ={"13510000011","13510000012","13510000013","13510000014","13510000015","13510000016"};
		writeEmergencyContact(names,tels);
		base.checkNoElement(ContactTipTxt);
		base.checkElmentText(CurrentTitle, "信用资料");
		String tel[]={"","1351000012","问然也可以自己再写一个","!@#$%^&*()+","13510 01252","11111111111","135李文tui&*|",""};
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
					base.checkElmentText(ContactTipTxt, "第"+(i+1)+"个手机不能为空！");
				}else{
					if(length>11)   length=11;
					if(base.isTelephone(tel[j].substring(0, length))){
						base.checkNoElement(ContactTipTxt);
						base.checkElmentText(CurrentTitle, "信用资料");
						clickEmergencyContactLnk();
						base.assertEqualsActualExpected(telList.get(i).getAttribute("value"), tel[j].substring(0, length));
					}else{
						base.checkElmentText(ContactTipTxt, "第"+(i+1)+"个手机号码有误！");
					}
				}
			}
		}			
	}
	//点击“紧急联系人”的“保存并继续”按钮	
	public void clickContactSaveBtn(){
		base.clickWithWait(emergencyContactSaveBtn);
	}
	/**
	 * 徐天元
	 * 判断当前完善资料的位置是否正确  基本资料 紧急联系人  信用资料
	 */
	public void isCurrentInfo(String currentInfo){
		//base.assertNotNullBy(By.xpath(".//*[contains(@class,'current') and text()='" + currentInfo + "']"));
		String currentID = "";
		if(currentInfo.equals("基本资料")){
			currentID = "#info0";
		}else if (currentInfo.equals("紧急联系人")) {
			currentID = "#info1";
		}else {
			currentID = "#info2";
		}
		base.checkElement(By.cssSelector(currentID+".current"));
		//base.assertNotNullBy(By.cssSelector(currentID+".current"));
	}
	
	/**
	 * 徐天元
	 * 紧急联系人资料填写
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
	 * 徐天元
	 * 填写信用资料
	 */
	public void writeCreditInfo(){
		List<WebElement> creditInfoList = base.getElements(creditInfos);
		System.out.println("信用资料"+creditInfoList.size());
		for (int i = 0; i < creditInfoList.size(); i++) {
			new Select(creditInfoList.get(i)).selectByIndex(1);
		}
		//提交--取消
		base.clickWithWait(creditInfoSaveBtn);
		try {
			Alert alert = base.getAlertwithWait();
			alert.dismiss();
			isCurrentInfo("信用资料");
		} catch (Exception e) {
		}
		//提交--确定
		base.clickWithWait(creditInfoSaveBtn);
		Alert alert = base.getAlertwithWait();
		alert.accept();
	}
	//正在还款的借款-检查等额本金/等额本息/还本付息借款标的还款方式
	public void checkMatchingPrincipal(){
		int page = getPages();
		for(int i=1;i<=page;i++){
			List<WebElement> detail = base.getElements(BorrowDetailLnk);
			for(int j=0;j<=detail.size();j++){
				
			}
		}
	}
	
	/**
	 * 徐天元
	 * 点击“已发布的借款”
	 */
	public void clickPublishedTab(){
		//已发布的借款Tab
		base.clickWithWait(publishedtab);
		base.checkElmentText(SelectedTab, "已发布的借款");
	}
	
	/**
	 * 徐天元
	 * 判断是否为空  确认借贷  开通手机快捷还款业务  录制标确认视频
	 */
	public Boolean isDisplayed(String name){
		Boolean result = false;
		if (name.equals("确认借贷")) {
			result = base.isDisplayed(sureDebitBtn);
		}else {
			result = base.isDisplayed(By.cssSelector("input[value='"+name+"']"));
		}
		System.out.println(name+result);
		return result;
	}
	//获取“正在还款的借款”，“已发布的借款”中的页数
	public int getPages(){
		if(base.getElementTextWithWait(AllLoanContent).equals("您目前还没有已发布的借款！")){
			return 0;
		}else if(base.getElementTextWithWait(AllLoanContent).equals("您目前还没有正在还款的借款！")){
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
	//根据借款目的获得标的id
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
	//点击“已发布的借款”中借款标的“联保贷标”链接
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
	//查看点击“联保贷”后“联保贷”链接的内容   
	public void checkPopupLBDData(String LBCode,String begindate){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(base.getDate(begindate));
		calendar.add(Calendar.DAY_OF_MONTH, 90);
		String endtime=base.dateFormat(calendar.getTime(), "yyyy-MM-dd ")+begindate.substring(11);
		List<WebElement> LBInfo = base.getElements(LBDCode);
		String infos[]={"联保贷编码："+LBCode,"联保码创建人："+Data.tel_LBDCreaterName,"联保码借款有效开始时间："+begindate,"联保码借款有效结束时间："+endtime,"联保组成员1:"+Data.tel_LBDNoncreaterName,"联保组成员2:"+Data.tel_LBDCreaterName};
		for(int i=0;i<LBInfo.size();i++){
			base.assertEqualsActualExpected(LBInfo.get(i).getText(), infos[i]);
		}	
	}
	//显示自己借款的联保贷的标，组内其他人借联保贷标不显示       
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
	 * 徐天元
	 * 确认借贷
	 */
	public void sureDebit(){
		base.sleep(2000);
		myLoanHandel = base.getCurrentWindowHandle();
		System.out.println("我的借款"+myLoanHandel);
		//确认借贷
		base.clickWithWait(sureDebitBtn);
		base.sleep(2000);
		openMobileHandel = base.getChildWindowHandle(myLoanHandel);
		base.jumpToWindow(openMobileHandel);
	}
	
	/**
	 * 徐天元
	 * 确认借贷 点击按钮  开通手机快捷还款业务  录制标确认视频
	 */
	public void clickBtn_SureDebit(String name){
		System.out.println("手机"+myLoanHandel);
		//base.clickWithWait(By.xpath("//input[@value='"+name+"']"));
		base.clickWithWait(By.cssSelector("input[value='"+name+"']"));
		//base.clickWithWait(By.cssSelector("input..firepath-matching-node"));
		//base.clickWithWait(By.xpath("//input[@id='']["+num+"]"));
	}
	//根据借款标id点击“确认借贷”链接
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
		base.checkElmentText(ElectronicIOU.TitleTxt, "网络借款电子借条");
	}
	
	/**
	 * 徐天元
	 * 开通手机快捷还款功能
	 */
	public void openMobilePay(String idcardNo,String accountNo,String mobile,String province,String city,String bankName){
//		//点击“开通手机快捷款款业务”
//		base.clickWithWait(By.xpath("//input[@value='开通手机快捷还款业务']"));
		//开户名
		//base.sendKeysWithWait(By.id("realName"), realName);
		//身份证号
		base.sendKeysWithWait(By.id("idcardNo"), idcardNo);
		//银行卡号
		base.sendKeysWithWait(By.id("accountNo"), accountNo);
		//手机号
		base.sendKeysWithWait(By.id("mobile"), mobile);
		//农业银行
		base.clickWithWait(By.id("bankType5"));
		//省份
		base.elementSelectByVisibleText(By.id("provinceid"), province);
		//市
		base.elementSelectByVisibleText(By.id("cityid"), city);
		//开户行支行名
		base.sendKeysWithWait(By.id("bankName"), bankName);
		//同意开通
		base.clickWithWait(By.xpath("//span[text()='同意开通']"));
	}
	//检查初审通过后的“进行中”的状态
	public void checkFirstAuditStatus(String tenderid){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//td[a[contains(@href,'"+tenderid+"')]]/following-sibling::td[5]")), "进行中");
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//td[a[contains(@href,'"+tenderid+"')]]/following-sibling::td[6]")), "0%");
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//td[a[contains(@href,'"+tenderid+"')]]/following-sibling::td[9]")), "进行中");
	}
	//通过更改数据库开通手机快捷还款功能
	public void OpenMobilePaywithSQL(String uid){
		String sql="insert into d_ump_sms_user(uid,mobile,status,cdate) values("+uid+",'y/QTrrbaGzmFBwHbHs+JVw==',1,1436760055);";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}
	//通过更改数据库实现“确认借贷的录制确认视频”
	public void ConfirmVideowithSQL(String userID,String tenderid){
		String sql="INSERT INTO d_tender_ensure_video(tid,uid,STATUS,resultobj,cdate,TYPE)VALUES(/**/"+tenderid+"/*<--标ID*/,/**/"+userID+"/*<---左边写用户UID*/,0,'1410839479929.flv',1427967935,1)";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
	}
	
	/**
	 * 徐天元
	 * 是否手机开通快捷还款成功
	 */
	public void isOpenMobilePayOK(String realName){
		try {
			Alert alert = base.getAlertwithWait();
			if (alert.getText().equals("您确定要开通手机快捷还款功能吗？")) {
				alert.accept();
				if (base.indexURL.contains("client") || base.indexURL.contains("auto") || base.indexURL.contains("inclient")) {
					//数据库改状态
					int uid = Integer.parseInt(dbData.getUidByRealname(realName));
					System.out.print("..............uid:"+uid);
					Boolean result = dbData.updateOpenMobliePayStatusByUid(uid);
					System.out.println("数据库"+result);
				}
				
				alert = base.getAlertwithWait();
				String msg = alert.getText();
				System.out.println("开通手机快捷还款功能:"+msg);
				alert.accept();
				if (base.indexURL.contains("client") || base.indexURL.contains("auto") || base.indexURL.contains("inclient")) {
					if (msg.contains("失败")) {
						base.clickWithWait(By.xpath("//div[@class='ui-dialog-buttonset']/button[2]"));//关闭
					}
				}
			}
			base.refreshPage();
			base.sleep(3000);
			System.out.println("开通手机快捷还款业务是否显示："+base.isBlock(By.cssSelector("input[value='开通手机快捷还款业务']")));
			base.assertEqualsActualExpectedByBoolean(base.isBlock(By.cssSelector("input[value='开通手机快捷还款业务']")), false);
		} catch (Exception e) {
		}
	}
	
	/**
	 * 徐天元
	 * 验证视频确认是否成功
	 */
	public void isVedioOK(){
		base.isElementEmpty(By.cssSelector("input[value='录制标确认视频']"));
	}
	
	/**
	 * 徐天元
	 * 录制视频 关闭
	 */
	public void closeVedio(){
		base.clickWithWait(By.cssSelector(".ui-button-text"));
		base.sleep(3000);
		base.refreshPage();
		base.sleep(3000);
	}
	
	/**
	 * 徐天元
	 * 确认借贷款
	 */
	public void isSureDebit(){
		base.clickWithWait(By.cssSelector(".c_afpc_style_26"));
		try {
			Alert alert = base.getAlertwithWait();
			if (alert.getText().equals("确定同意此借贷标及电子借条？")) {
				alert.accept();
				alert = base.getAlertwithWait();
				alert.accept();
			}
					
		} catch (Exception e) {
		}
	}

	/**
	 * 徐天元
	 * 已阅读并同意电子借条
	 */
	public void agree(){
		base.refreshPage();
		base.clickWithWait(By.id("agreeButton"));
		base.clickWithWait(By.cssSelector(".c_afpc_style_26"));
		Alert alert = base.getAlertwithWait();
		//"确定同意此借贷标及电子借条？"
		alert.accept();
		//您已确认借贷标，请等待最终审核完成！
		String msg = alert.getText();
		//"您已确认借贷标，请等待最终审核完成！
		alert.accept();
//		String beforHandel = base.getChildWindowHandle(openMobileHandel);
//		base.closeWindow(openMobileHandel);
//		base.jumpToWindow(beforHandel);
		base.assertEqualsActualExpected(msg, "您已确认借贷标，请等待最终审核完成！");
	}
	//验证确认借贷后显示“等待总部终审”状态
	public void checkShowFinalAuditStatus(String tenderid){
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//td[a[contains(@href,'"+tenderid+"')]]/following-sibling::td[5]")), "等待总部终审");
		base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//td[a[contains(@href,'"+tenderid+"')]]/following-sibling::td[9]")), "等待总部终审");

	}
	
	/**
	 * 用户确认
	 * 备注：翼企贷P1用例
	 * @author 江渤洋 2015-8-7
	 */
	public void confirmLoan(String borrowerEmail, String loanAmount){
		
		String parentWindowHandle = "";
		String childWindowHandle = "";
		String uid = "";
		String tenderId = "";
		boolean isSuccess = false;
		boolean isclickConfirmLoan = false;
		
		//获取用户UID
		uid = dbData.getUID(borrowerEmail);
		//获取产品ID
		tenderId = dbData.getTenderId(uid);
		//向标确认视频记录表插入数据
		isSuccess = dbData.insertEnsureVideo(tenderId, uid);
		base.assertEqualsActualExpectedByBoolean(isSuccess, true);
		parentWindowHandle = base.getCurrentWindowHandle();System.out.println("父窗口句柄：" + parentWindowHandle);
		//根据金额，点击“确认借贷”
		isclickConfirmLoan = clickConfirmLoan(loanAmount);
		if(isclickConfirmLoan){
			//获取子窗口句柄
			if(base.Windowsize()>1){
				childWindowHandle = base.getChildWindowHandle(parentWindowHandle);System.out.println("子窗口句柄：" + childWindowHandle);//---------测试
				base.jumpToWindow(childWindowHandle);System.out.println("当前窗口句柄：" + base.getCurrentWindowHandle());//---------测试
				if(childWindowHandle.equals(parentWindowHandle)){
					base.turnToNewPage();
				}
			}
			base.assertEqualsActualExpectedByBoolean(isDisplayed("开通手机快捷还款业务"), false);
			base.assertEqualsActualExpectedByBoolean(isDisplayed("录制标确认视频"), false);
			//已阅读并同意电子借条
			agree();
		}
		else{
			System.out.println("error_已发布的借款没有'确认接待'按钮");
		}
	}
	
	/**
	 * 获取下一页按钮
	 * @author 江渤洋 2015-8-14
	 */
	public String getNextBtn(){
		List<WebElement> liList = new ArrayList<WebElement>();
		liList = base.getElements(By.xpath("//div[@id='Pagination']/ul/li"));
		String value = "";
		int i = 0;
		int size = liList.size();
		for(; i < size; i++){
			value = liList.get(i).getText();System.out.println("li的value:" + value);
			if(value.equals(">")){
				i++;
				break;
			}
		}
		
		return String.valueOf(i);
	}
	
	/**
	 * 根据金额，点击“确认借贷” 或者 “上传材料”
	 * @return
	 * @author 江渤洋 2015-8-7
	 */
	public boolean clickConfirmLoan(String loanAmount){
		
		List<WebElement> rowList = null;
		String tempAmountString = "";
		boolean isTrue = false;
		//“操作”列
		By operation = null;
		String operationValue = "";
		
		do{
			rowList = new ArrayList<WebElement>();
			//获取所有金额
			rowList = base.getElements(By.xpath("//div[@id='_content_child']//tbody//tr/td[3]"));
			int size = rowList.size();

			for(int i = 0; i < size; i++){
				tempAmountString = rowList.get(i).getText();
				//字符串处理
				tempAmountString = base.stringToReplace(tempAmountString, "￥", "");
				tempAmountString = base.stringToReplace(tempAmountString, ",", "");System.out.println("金额：" + tempAmountString);//----------测试
				//如果等于传入金额
				if(tempAmountString.equals(loanAmount)){System.out.println("我在：" + (i+1));//----------测试
					//获取操作列
					operation = By.xpath("//div[@id='_content_child']//tbody//tr[" + (i+1) + "]/td[12]/a");
	//				operation = By.xpath("//div[@id='_content_child']//tbody//tr[4]/td[12]/a");
					isTrue = base.isElementPresent(operation);System.out.println("列是否存在：" + isTrue);//----------测试
					if(isTrue){
						operationValue = base.getElementTextWithWait(operation);System.out.println("列的值：" + operationValue);//----------测试
						if(operationValue.equals("确认借贷") || operationValue.equals("上传材料")){
							base.clickWithWait(operation);
							break;
						}
					}
				}
			}
			
			//如果没有，点击下一页
			if(!isTrue){
				boolean isBtnDisabled = false;
				String local = getNextBtn();
				//是否隐藏;true为隐藏，false为显示
				isBtnDisabled = base.isElementContainsValue(By.xpath("//div[@id='Pagination']/ul/li["+ local +"]"), "class", "pgEmpty");System.out.println("下一页按钮是否隐藏： " + isBtnDisabled);//------------测试
				//判断当前页是否是最后一页，即下一页按钮是否隐藏
				if(isBtnDisabled){
					System.out.println("error_列表没有找到借款人");
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
	 * 上传材料
	 * @param loanAmount:借款金额
	 * @author 江渤洋 2015-8-14
	 */
	public void uploadMaterial(String loanAmount){
		
		String parentWindowHandle = "";
		String childWindowHandle = "";
		boolean isUploadMaterial = false;
		String curPath = new File("").getAbsolutePath();//当前路径
		String filePath = curPath + "\\images\\das.jpg";
		//选择文件
		Pattern selectBtn =new Pattern(curPath + "\\images\\xuanzewenjian.png");
		//文件名
		Pattern forderBtn =new Pattern(curPath + "\\images\\wenjianming.png");
		//打开
		Pattern openBtn =new Pattern(curPath + "\\images\\dakai.png");
		Screen screen = new Screen();
	
		
		parentWindowHandle = base.getCurrentWindowHandle();System.out.println("父窗口句柄：" + parentWindowHandle);
		//根据金额，点击“上传材料”
		isUploadMaterial = clickConfirmLoan(loanAmount);
		base.sleep(5000);
		if(isUploadMaterial){
			//获取子窗口句柄
			if(base.Windowsize()>1){
				childWindowHandle = base.getChildWindowHandle(parentWindowHandle);System.out.println("子窗口句柄：" + childWindowHandle);//---------测试
				base.jumpToWindow(childWindowHandle);System.out.println("当前窗口句柄：" + base.getCurrentWindowHandle());//---------测试
				if(childWindowHandle.equals(parentWindowHandle)){
					base.turnToNewPage();
				}
			}
			//选择“借款用途”
			base.elementSelectByVisibleText(By.xpath("//select[@id='loanCategory']"), "翼企贷测试");
			base.clickWithWait(By.xpath("//span[text()='确定']"));
			base.sleep(1000);
			base.acceptAlert();
			base.sleep(3000);
			//点击“普通”Tab
			base.clickWithWait(By.xpath("//span[@id='spanli3']"));
			base.clickWithWait(By.xpath("//li[@id='datumCateId0']"));
			base.sleep(1000);
			//点击“上传图片”
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
	 * 徐天元
	 * 点击申请借款
	 */
	public void clickLoanApplication(){
		base.clickWithWait(By.cssSelector(".pub_btn_138.mt20"));
	}
	
	/**
	 * 还款
	 * @param repaymentWay:还款方式(1:每月还款；2：提前一次性还清；3： 请输入您要偿还的本金)
	 * @author 江渤洋 2015-8-17
	 */
	public void repayment(String repaymentWay){
		//进入我的借款
		myAccountPage.turnToMyAccount("我的借款");
		boolean isDisplayed = false;
		base.sleep(5000);
		//判断是否有数据
		isDisplayed = base.isDisplayed(loanListByFirst);System.out.println("我的借款_有正在还款的数据1：" + isDisplayed);//------测试
		if(isDisplayed){
			//每月还款
			if(repaymentWay.equals("month")){
				while(true){
					if(!isDisplayed){break;}
					//1.点击还款
					base.clickWithWait(monthlyRepaymentLink);
					base.sleep(2000);
					//2.弹出还款确认框
					base.assertEqualsActualExpectedByBoolean(!base.isNone(outAllWindow), true);
					base.sleep(2000);
						
					base.clickWithWait(okBtn);
					base.sleep(3000);
					if(base.isAlertPresent()){
						base.acceptAlert();
					}
					base.sleep(5000);
					isDisplayed = base.isDisplayed(loanListByFirst);System.out.println("我的借款_有正在还款的数据2：" + isDisplayed);//------测试
				}
			}
			//提前一次性还清
			else if(repaymentWay.equals("all")){
				//查看交易记录
				//1.点击还款，获取账户余额
				base.clickWithWait(monthlyRepaymentLink);
				base.sleep(2000);
				//2.弹出还款确认框
				base.assertEqualsActualExpectedByBoolean(!base.isNone(outAllWindow), true);
				base.sleep(2000);
				//3.点击“提前一次性还清”
				base.clickWithWait(allRdo);
				base.sleep(1000);
				base.clickWithWait(okBtn);
				base.sleep(1000);
				base.acceptAlert();
			}
			//请输入您要偿还的本金
			else if(repaymentWay.equals("advance")){
				;
			}
			else{
				System.out.println("error_还款确认窗口：没有您选择的还款方式！");
			}
		}
		else{
			Reporter.log("error_我的账户_我的借入_我的借款_没有借款数据");
			System.out.println("error_我的账户_我的借入_我的借款_没有借款数据");
		}
	}
	
	/**
	 * 验证还款成功后的变化
	 * 备注：由于测试数据稀少，未进行还款操作。此用例假设做过一次还款
	 * @author 江渤洋 2015-7-23
	 */
	public void checkRepaymentChanges(){
		
		//进入我的借款
		myAccountPage.turnToMyAccount("我的借款");
		boolean isDisplayed = false;
		//判断是否有数据
		isDisplayed = base.isDisplayed(loanListByFirst);//System.out.println("我的借款_有正在还款的数据：" + isDisplayed);//------测试
		if(isDisplayed){
			//查看还款列表
			//1.点击借款详情打开按钮
			base.clickWithWait(viewDetailsOpenBtn);
			base.assertEqualsActualExpectedByBoolean(true, base.isElementPresent(viewDetailsCloseBtn));
			base.sleep(1000);
			//2.验证还款列表是否存在
			base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(loanListByMyLoan, "style", "table"), true);
			
			//查看交易记录
			//1.点击“还款”，获取账户余额
			base.clickWithWait(monthlyRepaymentLink);
			//2.弹出还款确认框
			base.assertEqualsActualExpectedByBoolean(!base.isNone(outAllWindow), true);
			base.sleep(2000);
			//3.获取“检查账户余额”
			String balanceByWindowStr = base.getElementTextWithWait(balanceByWindow);
			//去掉￥
			balanceByWindowStr = balanceByWindowStr.substring(1);//System.out.println("还款确认对话框_您的账户余额:" + balanceByWindowStr);//-----测试
			//关闭“还款确认对话框”
			base.clickWithWait(cancelBtn);
			//4.进入交易记录
			myAccountPage.turnToMyAccount("交易记录");
			//5.判读记录是否存在。如果存在，则获取第一条交易记录的说明为“按月还款”的余额，并对比
			base.assertEqualsActualExpectedByBoolean(base.isElementPresent(transactionRecordPage.recordsList), true);
			base.sleep(1000);
			//判断第一条的说明是否是“按月还款”
			base.assertEqualsActualExpected(base.getElementTextWithWait(transactionRecordPage.explainRecords), "按月还款");
			base.sleep(1000);//System.out.println("交易记录_余额：" + base.getElementTextWithWait(balanceRecords));
			//判断第一条的余额
			base.assertEqualsActualExpected(base.getElementTextWithWait(transactionRecordPage.balanceRecords), balanceByWindowStr);
			
			//查看站内信
			//1.点击站内信
			insideLetterPage.clickInsideLetter();
			//2.验证“系统消息”是否选中
			//insideLetterPage.checkSysMsgTab();
			//获取系统消息Iframe
			//base.switchToFrame(insideLetterPage.sysMsgIframe);
			//3.查看第一条信息的图标是否未打开
			boolean isContains = base.isElementContainsValue(insideLetterPage.envelopeIconBySysMsg, "src", "mailboxnoread");
			base.assertEqualsActualExpectedByBoolean(isContains, true);
		}
		else{
			Reporter.log("error_我的账户_我的借入_我的借款_没有借款数据");
			System.out.println("error_我的账户_我的借入_我的借款_没有借款数据");
		}
	}
	
/**********************************完善资料*********************************************/	
	//完善资料-基本资料-检查页面显示
	public void checkBasicInfoPage(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(Title), "我的借款>完善资料");
		String bluecolor=base.getStyle("document.getElementById('_content').getElementsByTagName('a')[0]","color");
		base.assertEqualsActualExpected(bluecolor, "rgb(0, 144, 240)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(BasicInfoLnk), "基本资料");
		String redcolor= base.getStyle("document.getElementById('info0')","color");
		base.assertEqualsActualExpected(redcolor, "rgb(248, 24, 32)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(EmergencyContactLnk), "紧急联系人");
		base.assertEqualsActualExpected(base.getElementTextWithWait(CreditInfoLnk), "信用资料");
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
		base.assertEqualsActualExpected(base.getElementText(NotesTxt), "注：在添加个人描述时，请参考如下3种提示\n1、如果您是工薪族，请填写：个人工作和家庭情况、工作经历；\n2、如果您是个体经营者，请填写：个人家庭和经营业务、规模介绍；\n3、如果您是农户，请填写：个人家庭收入和创业项目详细介绍等。");
		base.assertEqualsActualExpected(base.getElementText(baseSaveBtn), "保存并继续");
		base.assertEqualsActualExpected(base.getElementNoWait(baseSaveBtn).getCssValue("color"), "rgba(255, 255, 255, 1)");
		String image= base.getElementNoWait(baseSaveBtn).getCssValue("background-image");System.out.println(image);
		if(base.indexURL.contains("client")||base.indexURL.contains("test")){
			base.assertTrueByBoolean(image.contains(base.indexURL+"/page/userMgr/images/myhome_bg.png"));
		}else if(base.indexURL.contains("www")){
			base.assertTrueByBoolean(image.contains("http://static7.eloancn.com//page/userMgr/images/myhome_bg.png"));
		}
	}
	//非必填选项的校验
	public void checkOptionalOption(){
		String optional[]={"民族","住宅电话","QQ号码","单位从事行业","单位名称","单位地址","单位电话","描述信息"};
		for(int i=0;i<7;i++){
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//tr[th[span[text()='"+optional[i]+"']]]/td")), "");
		}
		saveBaseInfo("男","11","请选择","","","北京","北京市昌平区","北京市昌平区","","","","","");
		saveBaseInfo("男","11","请选择","12764423","","北京","北京市昌平区","北京市昌平区","","北京同城翼龙","","4000085","");
	}
	//必填选项的校验
	public void checkRequiredOption(){
		String required[] = {"性别","年龄","户籍所在地","父母所在地","现居住地地址"};
		for(int i=0;i<5;i++){
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//tr[th[span[text()='"+required[i]+"']]]/td")), "*");
		}	
		inputCurrentAddress("");
		clickBaseSavebtn();
		base.checkElmentText(ErrorTipTxt, "请填现居住地地址！");
		inputParentAddress("");
		clickBaseSavebtn();
		base.checkElmentText(ErrorTipTxt, "请填写父母所在地！");
		selectNativePlace("请选择");
		clickBaseSavebtn();
		base.checkElmentText(ErrorTipTxt, "请选择户籍所在地！");		
		saveAge("");
	}

	//选择性别
	public void selectGendar(String gendar){
		base.clickWithWait(By.xpath("//label[contains(text(),'"+gendar+"')]"));
	}
	//输入年龄
	public void inputAge(String age){
		base.checkElementVisible(inputAge);
		base.sendKeysWithWait(inputAge, age);
	}
	//检查基本资料的性别、年龄不可编辑
	public void checkGendarandAge(){
		base.assertNotNullBy(SelectedGendar);
		String age = base.getLnkElementText(inputAge, "value");
		base.assertNotEqualsActualExpected(age, "");
		String gendar = base.getElementTextWithWait(SelectedGendar);
		if(gendar.equals("女")){
			base.assertEqualsActualExpected(base.getElementTextWithWait(DisabledGendar), "男");
			base.clickWithWait(DisabledGendar);
			base.assertEqualsActualExpected(base.getElementText(SelectedGendar), gendar);
		}
		base.assertEqualsActualExpected(base.getLnkElementText(inputAge, "readonly"),"true");
	}
	//保存年龄
	public void saveAge(String age){
//		clickBaseInfoLnk();
		inputAge(age);
		clickBaseSavebtn();
		if(age.equals("")){
			base.checkElmentText(ErrorTipTxt, "请输入年龄！");
		}else if(!base.isNumeric(age)){
			base.checkElmentText(ErrorTipTxt, "年龄只能输入整数！");
		}
	}
	//选择民族
	public void selectNation(String nation){
		base.elementSelectByVisibleText(selectNation, nation);
	}
	//输入住宅电话
	public void inputPhone(String phone){
		base.sendKeysWithWait(inputPhone, phone);
		base.clickWithWait(inputAge);
		if(phone.length()>15){
			base.assertEqualsActualExpected(base.getLnkElementText(inputPhone,"value"), phone.substring(0,15));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(inputPhone,"value"), phone);
		}
	}
	//输入QQ号码
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

	//选择户籍所在地
	public void selectNativePlace(String place){
		base.elementSelectByVisibleText(NativePlace, place);
	}

	//输入父母所在地
	public void inputParentAddress(String parentaddress){
		base.sendKeysWithWait(parentAddressTxt, parentaddress);
		base.clickWithWait(inputAge);
		if(parentaddress.length()>40){
			base.assertEqualsActualExpected(base.getLnkElementText(parentAddressTxt,"value"), parentaddress.substring(0,40));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(parentAddressTxt,"value"), parentaddress);
		}
	}
	//输入现居住地地址
	public void inputCurrentAddress(String address){
		base.sendKeysWithWait(currentAddressTxt, address);
		base.clickWithWait(inputAge);
		if(address.length()>38){
			base.assertEqualsActualExpected(base.getLnkElementText(currentAddressTxt,"value"), address.substring(0,38));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(currentAddressTxt,"value"), address);
		}
	}

	//输入单位从事行业
	public void inputCompanyIndustry(String industry){
		base.sendKeysWithWait(inputCompanyIndustry, industry);
		base.clickWithWait(inputAge);
		if(industry.length()>40){
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyIndustry,"value"), industry.substring(0, 40));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyIndustry,"value"), industry);
		}
	}

	//输入单位名称
	public void inputCompanyName(String name){
		base.sendKeysWithWait(inputCompanyName, name);	
		base.clickWithWait(inputAge);
		if(name.length()>40){
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyName, "value"), name.substring(0,40));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyName, "value"), name);
		}
	}
	//点击“保存并继续”按钮
	public void clickBaseSavebtn(){
		base.clickWithWait(baseSaveBtn);
	}
	public void saveCompanyName(String name){
		clickBaseInfoLnk();
		inputCompanyName(name);
		clickBaseSavebtn();
		if(base.isNumeric(name)){
			base.checkElmentText(ErrorTipTxt, "单位名称不能是纯数字！");
		}else{
			base.checkNoElement(ErrorTipTxt);
			base.checkElmentText(CurrentTitle, "紧急联系人");
		}
	}
	//输入单位电话
	public void inputCompanyPhone(String phone){
		base.sendKeysWithWait(inputCompanyPhone, phone);
		base.clickWithWait(inputAge);
		if(phone.length()>18){
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyPhone, "value"), phone.substring(0,18));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyPhone, "value"), phone);
		}
	}
	
	//输入单位地址
	public void inputCompanyAddress(String address){
		base.sendKeysWithWait(inputCompanyAddress, address);
		base.clickWithWait(inputAge);
		if(address.length()>40){
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyAddress, "value"), address.substring(0,40));
		}else{
			base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyAddress, "value"), address);
		}
	}
	//检查单位地址
	public void checkCompanyAddress(){
//		base.assertEqualsActualExpected(base.getLnkElementText(inputCompanyAddress, "value"), "");
		inputCompanyAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklmn");
		clickBaseSavebtn();
		base.checkNoElement(ErrorTipTxt);
		base.checkElmentText(CurrentTitle, "紧急联系人");
		clickBaseInfoLnk();
		inputCompanyAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklmno");
	}
	//输入描述信息
	public void inputDescription(String description){
		base.sendKeysWithWait(inputDescription, description);
	}	
	public void saveDescription(String description){
		clickBaseInfoLnk();
		inputDescription(description);
		clickBaseSavebtn();
		if(description.length()>100){
			base.checkElmentText(CurrentTitle, "基本资料");
			base.checkElmentText(ErrorTipTxt, "描述不能超过50个字！");
		}else{
			base.checkNoElement(ErrorTipTxt);
			base.checkElmentText(CurrentTitle, "紧急联系人");
		}
	}
	//检查描述信息
	public void checkDescriptionInfo(){
		saveDescription("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuv");
		clickBaseInfoLnk();
		inputDescription("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvw");
		saveDescription("01234567890123456789单位名称输入框输入汉字点击保存并继续按钮-=_[];~,.+`!{}:<>?abcdefghijklmnopqrstuvwxyzabcdefghijklmnop");
	}
	//保存填写的基本信息
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
		if(age.equals("")||nativeplace.equals("请选择")||parentadd.equals("")||currentadd.equals("")){
//			base.checkElmentText(CurrentTitle, "基本资料");
//			if(age.equals(""))					base.checkElmentText(ErrorTipTxt, "请输入年龄！");
//			else if(nativeplace.equals("请选择"))		base.checkElmentText(ErrorTipTxt, "请选择户籍所在地！");
//			else if(parentadd.equals(""))			base.checkElmentText(ErrorTipTxt, "请填写父母所在地！");
//			else if(currentadd.equals(""))			base.checkElmentText(ErrorTipTxt, "请填现居住地地址！");
		}else{
			base.checkNoElement(ErrorTipTxt);
			base.checkElmentText(CurrentTitle, "紧急联系人");
		}
	}
	//检查已保存的基本信息
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
	//已完成身份认证-检查修改基本信息
	public void ModifyBaseInfo(){
		saveBaseInfo("男","19","回族","123456789012","123456","福建","福建省鼓楼区","福建省台江区","计算机技术","长青有道","福建省台江区","78945201","sdfasd23782502365~！·——+|{}：”《；【】-=、中国文化");
		myAccountPage.clickMyDebtLnk();
		clickBtn("完善资料");
		base.checkElementVisible(DisabledGendar);
		base.assertEqualsActualExpected(base.getLnkElementText(inputAge, "readonly"),"true");
		saveBaseInfo("女","20","壮族","1234567890","12345678","北京","北京市海淀区","北京市昌平区","电子商务行业","北京同城翼龙","北京市海淀区","44400088","翼龙贷作为联想控股成员企业，是国内首倡“同城O2O”模式的网络借贷平台");
		myAccountPage.clickMyDebtLnk();
		clickBtn("完善资料");
		checkUpdatedBaseInfo("女","20","壮族","1234567890","12345678","北京","北京市海淀区","北京市昌平区","电子商务行业","北京同城翼龙","北京市海淀区","44400088","翼龙贷作为联想控股成员企业，是国内首倡“同城O2O”模式的网络借贷平台");
	}
	//未完成身份认证-检查修改基本信息
	public void checkUpdateBaseInfo(){
		saveBaseInfo("女","19","回族","123456789012","123456","福建","福建省鼓楼区","福建省台江区","计算机技术","长青有道","福建省台江区","78945201","sdfasd23782502365~！·——+|{}：”《；【】-=、中国文化");
		myAccountPage.clickMyDebtLnk();
		clickBtn("完善资料");
		checkUpdatedBaseInfo("女","19","回族","123456789012","123456","福建","福建省鼓楼区","福建省台江区","计算机技术","长青有道","福建省台江区","78945201","sdfasd23782502365~！·——+|{}：”《；【】-=、中国文化");
		saveBaseInfo("男","20","壮族","1234567890","12345678","北京","北京市海淀区","北京市昌平区","电子商务行业","北京同城翼龙","北京市海淀区","44400088","翼龙贷作为联想控股成员企业，是国内首倡“同城O2O”模式的网络借贷平台");
		myAccountPage.clickMyDebtLnk();
		clickBtn("完善资料");
		checkUpdatedBaseInfo("男","20","壮族","1234567890","12345678","北京","北京市海淀区","北京市昌平区","电子商务行业","北京同城翼龙","北京市海淀区","44400088","翼龙贷作为联想控股成员企业，是国内首倡“同城O2O”模式的网络借贷平台");
	}
	//完善资料-紧急联系人-检查页面显示
	public void checkContactPage(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(Title), "我的借款>完善资料");
		String bluecolor=base.getStyle("document.getElementById('_content').getElementsByTagName('a')[0]","color");
		base.assertEqualsActualExpected(bluecolor, "rgb(0, 144, 240)");
		base.assertEqualsActualExpected(base.getElementTextWithWait(BasicInfoLnk), "基本资料");
		base.assertEqualsActualExpected(base.getElementTextWithWait(EmergencyContactLnk), "紧急联系人");
		String redcolor= base.getStyle("document.getElementById('info1')","color");
		base.assertEqualsActualExpected(redcolor, "rgb(248, 24, 32)");
		String redline = base.getStyle("document.getElementById('info1')","border-bottom-color");
		String solidline = base.getStyle("document.getElementById('info1')","border-bottom-style");
		base.assertEqualsActualExpected(redline, "rgb(248, 24, 32)");
		base.assertEqualsActualExpected(solidline, "solid");
		base.assertEqualsActualExpected(base.getElementTextWithWait(CreditInfoLnk), "信用资料");
		base.assertEqualsActualExpected(base.getElementTextWithWait(TipsTxt), "温馨提示：请填写当联系不到您时，我们可以联系的人。");
		String subtitles[] = {"亲属","社会朋友","同学","同事","普通朋友","贷友"};
		String content[]= {"姓名","手机"};
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
		base.assertEqualsActualExpected(base.getElementText(emergencyContactSaveBtn), "保存并继续");
		base.assertEqualsActualExpected(base.getElementNoWait(emergencyContactSaveBtn).getCssValue("color"), "rgba(255, 255, 255, 1)");
		String image= base.getElementNoWait(emergencyContactSaveBtn).getCssValue("background-image");
		if(base.indexURL.contains("client")||base.indexURL.contains("test")){
			base.assertTrueByBoolean(image.contains(base.indexURL+"/page/userMgr/images/myhome_bg.png"));
		}else if(base.indexURL.contains("www")){
			base.assertTrueByBoolean(image.contains("http://static7.eloancn.com//page/userMgr/images/myhome_bg.png"));
		}
	}
	//“材料上传”-检查材料上传页面的默认状态
	public void checkUploadDocData(){
		base.assertEqualsActualExpected(base.getElementTextWithWait(Title), "我的借款>材料上传");
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
		String FileTypes[] = {"本人身份证","家属身份证","户口本","驾照","行驶证","个人社保","工资卡银行近3个月流水","非工资卡银行近3个月流水","营业执照","固定电话近3个月详单","支付宝提现流水","住处相关照片","其他证明"};
		String FileTypes1[] = {"本人身份证","家属身份证","户口本","与直系亲属合影照","驾照","行驶证","个人社保","工资卡银行近3个月流水","非工资卡银行近3个月流水","营业执照","固定电话近3个月详单","支付宝提现流水","住处相关照片","其他证明"};
		List<WebElement> types = base.getElements(FileType);
		if(types.get(3).getText().equals("与直系亲属合影照")){
			FileTypes=FileTypes1;
		}
		for(int i=0;i<FileTypes.length;i++){
			base.assertEqualsActualExpected(types.get(i).getText(), FileTypes[i]);
		}
		base.checkElementVisible(WarmPromptPart);
		String redTips[]={"提高借款满标的速度和概率","未经任何软件修改的原图","有作假嫌疑并被确认","系统黑名单"};
		List<WebElement> fourtip = base.getElements(RedTips);
		for(int i=0;i<redTips.length;i++){
			base.assertEqualsActualExpected(fourtip.get(i).getText(), redTips[i]);
			String color= fourtip.get(i).getCssValue("color");
			base.assertEqualsActualExpected(color, "rgba(248, 105, 0, 1)");
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(CreditFile), "信用证明材料");
		base.assertEqualsActualExpected(base.getElementTextWithWait(CheckFile), "审核材料");
		base.assertEqualsActualExpected(base.getElementTextWithWait(IncreaseFile), "增额申请材料");
		base.assertEqualsActualExpected(base.getElementTextWithWait(PublicFile), "公益贷申请材料");	
	}
	
	//**********************申请额度*******************************
	public void QuotaRequest(String type,String date,String expect,String desc){
		base.elementSelectByVisibleText(QuotaTypeSel, type);
		base.elementSelectByVisibleText(ValidDateSel, date);
		base.sendKeysWithWait(inputExpectQuota, expect);
		base.sleep(1000);
		base.sendKeysWithWait(inputDesc, desc);
		base.clickWithWait(ApplicationBtn);
		base.checkAlertText("申请未完成，请上传增额证明材料!");
		base.checkElmentText(SelectedPart, "增额申请材料");
	}
	
}
