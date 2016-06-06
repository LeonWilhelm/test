package com.eloancn.shared.pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.PageTitles;

/*
 * “我的账户”-“申请借款”页面
 */
public class LoanApplicationPage {
	Base base = new Base();
	InvestmentDetailPage investdetailpage = new InvestmentDetailPage();

	public static By Main = By.cssSelector("div.g-main-c");
	public static By VerifyAuthBtn = By.cssSelector("a.tobuction");
	public static By ApplyforLoanTxt = By.cssSelector("div.newtitle>h3");

	//“我的借入”-“申请借款”-“资格认证”
	By qualification = By.cssSelector(".tobuction");   //资格认证

	
	
	By dejkCbx = By.id("onukaApply");						//“马上大额借款”复选框
	By ftxCbx = By.id("noWithDrawType");					//“非提现标”复选框
	By blxSel = By.id("type");								//“标类型”下拉列表
	By BidTypeOption=By.cssSelector("#type>option");		//
//	By LBDType = By.xpath("//select[@id='type']/option[8]");//联保贷的标类型
	public By LBCode = By.id("td_code");			//联保编码
	public By jkjeTxt = By.id("amount");			//借款金额
	public By BorrowMoneyErrorTxt = By.cssSelector("#amountDiv>strong");
	By BorrowMoneyTips = By.cssSelector("#showAmount>td>div.pub_tip.fl>div>p");
	public By SXmaxMoney= By.xpath("//p/em[2]");	//授信最高可借金额
	By jkqxSel = By.id("phases");			//借款期限
	By BorrowPhaseOption = By.cssSelector("#phases>option");//借款期限的选择项
	By LBPeopleNumSel = By.id("pcount");
	public By LBPeopleNumOption = By.cssSelector("#pcount>option");
	By zgnllTxt = By.id("interestrate");	//最高年利率
	//投标有效期方法在下边selectTBYXQ
	By BidValidityOptionTxt = By.xpath("//tr[13]/td[2]");
	//投标模式
	By BidModeOptionTxt = By.xpath("//tr[14]/td[2]");
	By tbmsjbRad = By.id("mode");//竞标
	By tbmsmbRad = By.id("mode1");//满标
	//还款方式   方法在下边selectRepayStyle
	By RepayModeOptionTxt = By.xpath("//tr[15]/td[2]");
	//借款类型
	By jklxSel = By.id("usetype");
	By BorrowTypeOption = By.cssSelector("#usetype>option");
	//借款区域   
	By provinceSel = By.id("showprovinceid");  
	By citySel = By.id("showcityid");  
	By countrySel = By.id("showcountyid");
	//借款目的
	By jkmdTxt = By.id("purpose");
	//描述信息
	By msxxTxt = By.id("detaildescription");
	//上传资料
	By uploadInfoBtn = By.cssSelector(".big_upload");//.upload_G.mlr7
	By UploadInfoTxt = By.cssSelector("#UploadFileBox>div.tipbg>span.tiptitspan");	//弹出对话框的标题（“上传材料”）
	By SelectFileBtn = By.id("UploadifyUploader");
	By UploadedFile = By.cssSelector("#mvQueueDiv>div.uploadifyQueueItem");					//“上传材料”对话框_已上传图片信息（名称、扩展名、大小、上传状态）
	By UploadFileBtn = By.cssSelector("#UploadFileBox> div.tipsubm >button.tipbuttok"); 
	By uploadBtn = By.xpath(".//*[@id='UploadFileBox']//button[1]");////div[@id='MVUploadFileBox']//button[text()='上传文件']
	//选择文件
	                               
	//发布
	By releaseBtn = By.id("releaseButton");
	By CloseLnk = By.cssSelector("span.lendingR_windclose>a.tip_close");	//发布成功的关闭链接

	public void ApplyLoan(int serialnumber,int ownerid){
		Date date1= base.getTime();
		String date=base.dateFormat(date1, "yyyy-MM-dd HH:mm");
		String cdate=String.valueOf(date1.getTime()).substring(0, 10);	
		int enddate= Integer.parseInt(cdate)+604800;
		String title = "自动化借款"+base.RandomNumber();System.out.println(title);
		String sql="insert into d_tender(serialnumber,title,amount,interestrate,realinterestrate,timelimit,phases,repaymenttype,usetype,mode,type,detaildescription,status,"+
					"ownerid,cdate,publisheddate,enddate,progress,hits,endway,accepttime,areaId,version)VALUES"+
					"("+serialnumber+",'"+title+"',60000.00,0.1800,0.1800,7,12,1,1,2,25,'YND001YND001YND001YND001YND001YND001',9,"+ownerid+","+cdate+","+cdate+","+enddate+",0.0000,0,0,0,1,1)";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
		String sql1="UPDATE d_tender SET STATUS=11 WHERE TITLE='"+title+"'";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql1));
	}

	/****************************资格认证******************************/
	
	/**
	 * 点击“申请借款”页面中的“资格认证”
	 * @author 江渤洋 2015-9-7
	 */
	public void clickQualification(){
		base.clickWithWait(qualification);
		if(base.gethandelsNum()!=1){
			base.turnToNewPage();
		}
		base.checkTitle(PageTitles.jieRuZheShouJiRenZheng);
	}
	
	/****************************申请借款******************************/
	//选择标类型
	public void selectBidType(String type){
		base.elementSelectByVisibleText(blxSel, type);
	}
	//输入借款金额
	public void inputBorrowMoney(String money){
		base.sendKeysWithWait(jkjeTxt, money);
	}
	//选择借款期限
	public void selectBorrowPhase(String phase){
		base.elementSelectByVisibleText(jkqxSel, phase);
		int phase1 = Integer.parseInt(phase.substring(0, phase.length()-2));
		if(phase1>=1 && phase1<=6){	
			base.checkElementwithValue(zgnllTxt, "15");
		}else if(phase1>=7 && phase1<=12){
			base.checkElementwithValue(zgnllTxt, "18");
		}else if(phase1>=13 && phase1<=24){
			base.checkElementwithValue(zgnllTxt, "21");
		}
	}
	//查看联保贷创建人的借款期限
	public void checkLBDLoanPhase(){
		base.clickWithWait(jkqxSel);
		List<WebElement> option = base.getElements(BorrowPhaseOption);
		int size = option.size();
		for(int i=1;i<size;i++){
			base.assertEqualsActualExpected(option.get(i).getText(), i+"个月");
		}
	}
	//选择联保人数
	public void selectLBPeopleNum(String num){
		base.elementSelectByVisibleText(LBPeopleNumSel, num);
	}
	//查看联保贷创建人的联保人数
	public void checkCreaterLBPeopleNum(){
		base.clickWithWait(LBPeopleNumSel);
		List<WebElement> option = base.getElements(LBPeopleNumOption);
		String num[]={"2人","3人","4人","5人"};
		int size = option.size();
		for(int i=0;i<size;i++){
			base.assertEqualsActualExpected(option.get(i).getText(), num[i]);
		}
	}
	
	/**
	 * 徐天元
	 * 还款方式   bj:等额本金   bx:等额本息    fx:还本付息
	 */
	public void selectRepayStyle(String style){
		base.clickWithWait(By.id(style));
	}
	
	/**
	 * 徐天元
	 * 投标有限期
	 */
	public void selectTBYXQ(String days){
		base.clickWithWait(By.xpath("//input[@value='"+days+"']"));
	}
	//点击大额借款的“上传资料”按钮
	public void clickUploadInfoBtn(){
		base.clickWithWait(uploadInfoBtn);
		base.checkElementVisible(UploadInfoTxt);
	}
	//点击上传材料的“选择文件”按钮
	public void clickSelectFileBtn(){
		base.clickWithWait(SelectFileBtn);
	}
	//点击“上传文件”按钮
	public void clickUploadFileBtn(){
		base.clickWithWait(UploadFileBtn);
	}
	
	//点击“发布”借款按钮
	public void clickPublishLoanBtn(){
		base.clickWithWait(releaseBtn);
	}

	/**
	 * 申请借款
	 * @param BigBorrow 		大额借款
	 * @param notWithdrawBid	非提现标
	 * @param bidtype
	 * @param borrowmoney
	 * @param borrowPhase
	 * @param LBPeopleNum
	 * @param highestrate
	 * @param bidvalidity
	 * @param bidmode
	 * @param repaymode
	 * @param borrowtype
	 * @param borrowpurpose
	 * @param msxx
	 * @author 徐天元
	 * @return
	 */
	public String loanApplication(boolean BigBorrow,boolean notWithdrawBid,String bidtype,String borrowmoney,String borrowPhase,String LBPeopleNum,
			String highestrate,String bidvalidity,String bidmode,String repaymode,String borrowtype,String borrowpurpose,String msxx){
		base.sleep(1000);
		if (BigBorrow) {
			base.clickWithWait(dejkCbx);		
			clickUploadInfoBtn();
			clickSelectFileBtn();
			String curPath = new File("").getAbsolutePath();//当前路径
			try {
				Runtime.getRuntime().exec(curPath+"\\exe\\UploadFile.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}				
			base.checkElementVisible(UploadedFile);
			clickUploadFileBtn();
//			Screen screen = new Screen();
//			//选择文件
//			Pattern selectBtn =new Pattern(curPath + "\\images\\xuanzewenjian.png");
//			Pattern uploadBtn =new Pattern(curPath + "\\images\\shangchuanwenjian.png");
//			try {
//				screen.click(selectBtn);
//				Runtime.getRuntime().exec(curPath+"\\exe\\UploadFile.exe");
//				base.sleep(5000);
//				screen.click(uploadBtn);
//			} catch (IOException e) {
//				e.printStackTrace();
//			} 
//			catch(FindFailed ex){
//				ex.printStackTrace();
//			}
	        base.checkAlertText("上传成功");
		}
		if (notWithdrawBid) {
			base.clickWithWait(ftxCbx);
		}
		selectBidType(bidtype);
		base.sendKeysWithWait(jkjeTxt, borrowmoney);
		base.elementSelectByVisibleText(jkqxSel, borrowPhase);
		if(bidtype.equals("联保贷")){
			selectLBPeopleNum(LBPeopleNum);
		}
		if(bidtype.equals("翼农贷") || bidtype.equals("翼商贷")){
			base.sendKeysWithWait(zgnllTxt, highestrate);
		}
		base.clickWithWait(zgnllTxt);
		selectTBYXQ(bidvalidity);
		if (bidmode.equals("竞标")) {
			base.clickWithWait(tbmsjbRad);
		}else {
			base.clickWithWait(tbmsmbRad);
		}
		String hkfsStyle = "";
		if (repaymode.equals("等额本金")) {
			hkfsStyle = "bj";
		}else if (repaymode.equals("等额本息")) {
			hkfsStyle = "bx";
		}else {
			hkfsStyle = "fx";
		}
		selectRepayStyle(hkfsStyle);
		if(!bidtype.equals("翼企贷标")){
			base.elementSelectByVisibleText(jklxSel, borrowtype);
		}
//		base.elementSelectByVisibleText(provinceSel, sheng);
//		base.sleep(1000);
//		base.elementSelectByVisibleText(citySel, shi);
//		base.sleep(1000);
//		base.elementSelectByVisibleText(countrySel, qu);
//		base.sleep(1000);
		base.sendKeysWithWait(jkmdTxt, borrowpurpose);
		base.sendKeysWithWait(msxxTxt, msxx);
		
		base.clickWithWait(releaseBtn);
		return borrowpurpose;
	}
	
	/**
	 * 徐天元
	 * 判断申请借款成功
	 */
	public void isLoanApplicationOK(){
//		base.sleep(5000);
		if(base.isAlertPresent(5)){			
			Reporter.log("发布借款失败！"+base.getTextByAlert());
			base.acceptAlert();
			Assert.fail();
		}else{
			base.assertTrueByBoolean(base.getElementTextWithWait(By.cssSelector(".lendingR_credinfotext")).contains("发布成功，等待初步审核"));
			clickCloseSuccessTipLnk();
		}
	}

	//关闭发布成功窗口
	public void clickCloseSuccessTipLnk(){
		base.clickWithWait(CloseLnk);
		base.checkElementVisible(MyLoanPage.MyLoanTxt);
		base.checkElmentText(MyLoanPage.MyLoanTxt, "我的借款");
		base.checkElmentText(MyLoanPage.SelectedTab, "已发布的借款");
	}
	
	/**
	 * 徐天元
	 * 申请借款界面  判断是否出现资格认证
	 */
	public void isShowIdentityAuthentication(boolean result){
		base.assertEqualsActualExpectedByBoolean(base.getElementTextWithWait(By.cssSelector(".g-main-c")).contains("您还不具备借入资格"), result);
	}
	public void checkDefaultData(){
		String BidTypes[]={"翼农贷","翼商贷","房抵标","房抵标（定期）","DD借款","翼企贷标","翼车贷标","联保贷"};
		List<WebElement> types = base.getElements(BidTypeOption);
		for(int i=0;i<BidTypes.length;i++){
			base.assertEqualsActualExpected(types.get(i).getText(), BidTypes[i]);
		}
		base.checkElementClickable(jkjeTxt, 10);
		base.clickWithWait(jkjeTxt);
		String LBMoney= "4.联保贷2户最高20000/户，3-5户最高30000/户";
		base.assertTrueByBoolean(base.getElementTextWithVisible(BorrowMoneyTips).contains(LBMoney));
		if(!base.getSelectedOptionTxt(blxSel).equals("联保贷")){
			String Phases[]={"请选择","2个月","3个月","4个月","5个月","6个月","7个月","8个月","9个月","10个月","11个月","12个月","15个月","18个月","21个月","24个月"};
			List<WebElement> option = base.getElements(BorrowPhaseOption);
			for(int i=0;i<Phases.length;i++){
				base.assertEqualsActualExpected(option.get(i).getText(), Phases[i]);
			}
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(BidValidityOptionTxt), "*  5天  7天");
		base.assertEqualsActualExpected(base.getElementTextWithWait(BidModeOptionTxt), "*  满标");
		base.assertEqualsActualExpected(base.getElementTextWithWait(RepayModeOptionTxt), "*  等额本金  等额本息  还本付息");		
		String BorrowTypes[]={"个人消费","教育助学","生意周转","网店周转","站内周转","翼企贷","翼车贷","其他"};
		List<WebElement> borrowtype = base.getElements(BorrowTypeOption);
		for(int i=0;i<BorrowTypes.length;i++){
			base.assertEqualsActualExpected(borrowtype.get(i).getText(), BorrowTypes[i]);
		}
	}
	//申请借款-未参加或参加了联保的情况下，查看借款申请页面
	public void checkLBDLoanPage(boolean flag){
		if(flag){//参加联保
			base.checkVisible(LBCode);
//			base.checkElmentwithTxt(LBCode, "一个联保组内不能重复借贷");
		}else{			
			base.assertTrueByBoolean(!base.checkVisible(LBCode,5));//页面不显示联保 编码 
		}
		List<WebElement> option = base.getElements(BorrowPhaseOption);
		for(int i=1;i<option.size();i++){
			base.assertEqualsActualExpected(option.get(i).getText(), i+"个月");
		}
		checkCreaterLBPeopleNum();
		checkDefaultData();
	}
}
