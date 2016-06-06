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
 * ���ҵ��˻���-�������ҳ��
 */
public class LoanApplicationPage {
	Base base = new Base();
	InvestmentDetailPage investdetailpage = new InvestmentDetailPage();

	public static By Main = By.cssSelector("div.g-main-c");
	public static By VerifyAuthBtn = By.cssSelector("a.tobuction");
	public static By ApplyforLoanTxt = By.cssSelector("div.newtitle>h3");

	//���ҵĽ��롱-�������-���ʸ���֤��
	By qualification = By.cssSelector(".tobuction");   //�ʸ���֤

	
	
	By dejkCbx = By.id("onukaApply");						//�����ϴ�����ѡ��
	By ftxCbx = By.id("noWithDrawType");					//�������ֱꡱ��ѡ��
	By blxSel = By.id("type");								//�������͡������б�
	By BidTypeOption=By.cssSelector("#type>option");		//
//	By LBDType = By.xpath("//select[@id='type']/option[8]");//�������ı�����
	public By LBCode = By.id("td_code");			//��������
	public By jkjeTxt = By.id("amount");			//�����
	public By BorrowMoneyErrorTxt = By.cssSelector("#amountDiv>strong");
	By BorrowMoneyTips = By.cssSelector("#showAmount>td>div.pub_tip.fl>div>p");
	public By SXmaxMoney= By.xpath("//p/em[2]");	//������߿ɽ���
	By jkqxSel = By.id("phases");			//�������
	By BorrowPhaseOption = By.cssSelector("#phases>option");//������޵�ѡ����
	By LBPeopleNumSel = By.id("pcount");
	public By LBPeopleNumOption = By.cssSelector("#pcount>option");
	By zgnllTxt = By.id("interestrate");	//���������
	//Ͷ����Ч�ڷ������±�selectTBYXQ
	By BidValidityOptionTxt = By.xpath("//tr[13]/td[2]");
	//Ͷ��ģʽ
	By BidModeOptionTxt = By.xpath("//tr[14]/td[2]");
	By tbmsjbRad = By.id("mode");//����
	By tbmsmbRad = By.id("mode1");//����
	//���ʽ   �������±�selectRepayStyle
	By RepayModeOptionTxt = By.xpath("//tr[15]/td[2]");
	//�������
	By jklxSel = By.id("usetype");
	By BorrowTypeOption = By.cssSelector("#usetype>option");
	//�������   
	By provinceSel = By.id("showprovinceid");  
	By citySel = By.id("showcityid");  
	By countrySel = By.id("showcountyid");
	//���Ŀ��
	By jkmdTxt = By.id("purpose");
	//������Ϣ
	By msxxTxt = By.id("detaildescription");
	//�ϴ�����
	By uploadInfoBtn = By.cssSelector(".big_upload");//.upload_G.mlr7
	By UploadInfoTxt = By.cssSelector("#UploadFileBox>div.tipbg>span.tiptitspan");	//�����Ի���ı��⣨���ϴ����ϡ���
	By SelectFileBtn = By.id("UploadifyUploader");
	By UploadedFile = By.cssSelector("#mvQueueDiv>div.uploadifyQueueItem");					//���ϴ����ϡ��Ի���_���ϴ�ͼƬ��Ϣ�����ơ���չ������С���ϴ�״̬��
	By UploadFileBtn = By.cssSelector("#UploadFileBox> div.tipsubm >button.tipbuttok"); 
	By uploadBtn = By.xpath(".//*[@id='UploadFileBox']//button[1]");////div[@id='MVUploadFileBox']//button[text()='�ϴ��ļ�']
	//ѡ���ļ�
	                               
	//����
	By releaseBtn = By.id("releaseButton");
	By CloseLnk = By.cssSelector("span.lendingR_windclose>a.tip_close");	//�����ɹ��Ĺر�����

	public void ApplyLoan(int serialnumber,int ownerid){
		Date date1= base.getTime();
		String date=base.dateFormat(date1, "yyyy-MM-dd HH:mm");
		String cdate=String.valueOf(date1.getTime()).substring(0, 10);	
		int enddate= Integer.parseInt(cdate)+604800;
		String title = "�Զ������"+base.RandomNumber();System.out.println(title);
		String sql="insert into d_tender(serialnumber,title,amount,interestrate,realinterestrate,timelimit,phases,repaymenttype,usetype,mode,type,detaildescription,status,"+
					"ownerid,cdate,publisheddate,enddate,progress,hits,endway,accepttime,areaId,version)VALUES"+
					"("+serialnumber+",'"+title+"',60000.00,0.1800,0.1800,7,12,1,1,2,25,'YND001YND001YND001YND001YND001YND001',9,"+ownerid+","+cdate+","+cdate+","+enddate+",0.0000,0,0,0,1,1)";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql));
		String sql1="UPDATE d_tender SET STATUS=11 WHERE TITLE='"+title+"'";
		base.assertTrueByBoolean(new DBData().UpdateLoanStatus(sql1));
	}

	/****************************�ʸ���֤******************************/
	
	/**
	 * ����������ҳ���еġ��ʸ���֤��
	 * @author ������ 2015-9-7
	 */
	public void clickQualification(){
		base.clickWithWait(qualification);
		if(base.gethandelsNum()!=1){
			base.turnToNewPage();
		}
		base.checkTitle(PageTitles.jieRuZheShouJiRenZheng);
	}
	
	/****************************������******************************/
	//ѡ�������
	public void selectBidType(String type){
		base.elementSelectByVisibleText(blxSel, type);
	}
	//��������
	public void inputBorrowMoney(String money){
		base.sendKeysWithWait(jkjeTxt, money);
	}
	//ѡ��������
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
	//�鿴�����������˵Ľ������
	public void checkLBDLoanPhase(){
		base.clickWithWait(jkqxSel);
		List<WebElement> option = base.getElements(BorrowPhaseOption);
		int size = option.size();
		for(int i=1;i<size;i++){
			base.assertEqualsActualExpected(option.get(i).getText(), i+"����");
		}
	}
	//ѡ����������
	public void selectLBPeopleNum(String num){
		base.elementSelectByVisibleText(LBPeopleNumSel, num);
	}
	//�鿴�����������˵���������
	public void checkCreaterLBPeopleNum(){
		base.clickWithWait(LBPeopleNumSel);
		List<WebElement> option = base.getElements(LBPeopleNumOption);
		String num[]={"2��","3��","4��","5��"};
		int size = option.size();
		for(int i=0;i<size;i++){
			base.assertEqualsActualExpected(option.get(i).getText(), num[i]);
		}
	}
	
	/**
	 * ����Ԫ
	 * ���ʽ   bj:�ȶ��   bx:�ȶϢ    fx:������Ϣ
	 */
	public void selectRepayStyle(String style){
		base.clickWithWait(By.id(style));
	}
	
	/**
	 * ����Ԫ
	 * Ͷ��������
	 */
	public void selectTBYXQ(String days){
		base.clickWithWait(By.xpath("//input[@value='"+days+"']"));
	}
	//��������ġ��ϴ����ϡ���ť
	public void clickUploadInfoBtn(){
		base.clickWithWait(uploadInfoBtn);
		base.checkElementVisible(UploadInfoTxt);
	}
	//����ϴ����ϵġ�ѡ���ļ�����ť
	public void clickSelectFileBtn(){
		base.clickWithWait(SelectFileBtn);
	}
	//������ϴ��ļ�����ť
	public void clickUploadFileBtn(){
		base.clickWithWait(UploadFileBtn);
	}
	
	//�������������ť
	public void clickPublishLoanBtn(){
		base.clickWithWait(releaseBtn);
	}

	/**
	 * ������
	 * @param BigBorrow 		�����
	 * @param notWithdrawBid	�����ֱ�
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
	 * @author ����Ԫ
	 * @return
	 */
	public String loanApplication(boolean BigBorrow,boolean notWithdrawBid,String bidtype,String borrowmoney,String borrowPhase,String LBPeopleNum,
			String highestrate,String bidvalidity,String bidmode,String repaymode,String borrowtype,String borrowpurpose,String msxx){
		base.sleep(1000);
		if (BigBorrow) {
			base.clickWithWait(dejkCbx);		
			clickUploadInfoBtn();
			clickSelectFileBtn();
			String curPath = new File("").getAbsolutePath();//��ǰ·��
			try {
				Runtime.getRuntime().exec(curPath+"\\exe\\UploadFile.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}				
			base.checkElementVisible(UploadedFile);
			clickUploadFileBtn();
//			Screen screen = new Screen();
//			//ѡ���ļ�
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
	        base.checkAlertText("�ϴ��ɹ�");
		}
		if (notWithdrawBid) {
			base.clickWithWait(ftxCbx);
		}
		selectBidType(bidtype);
		base.sendKeysWithWait(jkjeTxt, borrowmoney);
		base.elementSelectByVisibleText(jkqxSel, borrowPhase);
		if(bidtype.equals("������")){
			selectLBPeopleNum(LBPeopleNum);
		}
		if(bidtype.equals("��ũ��") || bidtype.equals("���̴�")){
			base.sendKeysWithWait(zgnllTxt, highestrate);
		}
		base.clickWithWait(zgnllTxt);
		selectTBYXQ(bidvalidity);
		if (bidmode.equals("����")) {
			base.clickWithWait(tbmsjbRad);
		}else {
			base.clickWithWait(tbmsmbRad);
		}
		String hkfsStyle = "";
		if (repaymode.equals("�ȶ��")) {
			hkfsStyle = "bj";
		}else if (repaymode.equals("�ȶϢ")) {
			hkfsStyle = "bx";
		}else {
			hkfsStyle = "fx";
		}
		selectRepayStyle(hkfsStyle);
		if(!bidtype.equals("�������")){
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
	 * ����Ԫ
	 * �ж�������ɹ�
	 */
	public void isLoanApplicationOK(){
//		base.sleep(5000);
		if(base.isAlertPresent(5)){			
			Reporter.log("�������ʧ�ܣ�"+base.getTextByAlert());
			base.acceptAlert();
			Assert.fail();
		}else{
			base.assertTrueByBoolean(base.getElementTextWithWait(By.cssSelector(".lendingR_credinfotext")).contains("�����ɹ����ȴ��������"));
			clickCloseSuccessTipLnk();
		}
	}

	//�رշ����ɹ�����
	public void clickCloseSuccessTipLnk(){
		base.clickWithWait(CloseLnk);
		base.checkElementVisible(MyLoanPage.MyLoanTxt);
		base.checkElmentText(MyLoanPage.MyLoanTxt, "�ҵĽ��");
		base.checkElmentText(MyLoanPage.SelectedTab, "�ѷ����Ľ��");
	}
	
	/**
	 * ����Ԫ
	 * ���������  �ж��Ƿ�����ʸ���֤
	 */
	public void isShowIdentityAuthentication(boolean result){
		base.assertEqualsActualExpectedByBoolean(base.getElementTextWithWait(By.cssSelector(".g-main-c")).contains("�������߱������ʸ�"), result);
	}
	public void checkDefaultData(){
		String BidTypes[]={"��ũ��","���̴�","���ֱ�","���ֱ꣨���ڣ�","DD���","�������","������","������"};
		List<WebElement> types = base.getElements(BidTypeOption);
		for(int i=0;i<BidTypes.length;i++){
			base.assertEqualsActualExpected(types.get(i).getText(), BidTypes[i]);
		}
		base.checkElementClickable(jkjeTxt, 10);
		base.clickWithWait(jkjeTxt);
		String LBMoney= "4.������2�����20000/����3-5�����30000/��";
		base.assertTrueByBoolean(base.getElementTextWithVisible(BorrowMoneyTips).contains(LBMoney));
		if(!base.getSelectedOptionTxt(blxSel).equals("������")){
			String Phases[]={"��ѡ��","2����","3����","4����","5����","6����","7����","8����","9����","10����","11����","12����","15����","18����","21����","24����"};
			List<WebElement> option = base.getElements(BorrowPhaseOption);
			for(int i=0;i<Phases.length;i++){
				base.assertEqualsActualExpected(option.get(i).getText(), Phases[i]);
			}
		}
		base.assertEqualsActualExpected(base.getElementTextWithWait(BidValidityOptionTxt), "*  5��  7��");
		base.assertEqualsActualExpected(base.getElementTextWithWait(BidModeOptionTxt), "*  ����");
		base.assertEqualsActualExpected(base.getElementTextWithWait(RepayModeOptionTxt), "*  �ȶ��  �ȶϢ  ������Ϣ");		
		String BorrowTypes[]={"��������","������ѧ","������ת","������ת","վ����ת","�����","����","����"};
		List<WebElement> borrowtype = base.getElements(BorrowTypeOption);
		for(int i=0;i<BorrowTypes.length;i++){
			base.assertEqualsActualExpected(borrowtype.get(i).getText(), BorrowTypes[i]);
		}
	}
	//������-δ�μӻ�μ�������������£��鿴�������ҳ��
	public void checkLBDLoanPage(boolean flag){
		if(flag){//�μ�����
			base.checkVisible(LBCode);
//			base.checkElmentwithTxt(LBCode, "һ���������ڲ����ظ����");
		}else{			
			base.assertTrueByBoolean(!base.checkVisible(LBCode,5));//ҳ�治��ʾ���� ���� 
		}
		List<WebElement> option = base.getElements(BorrowPhaseOption);
		for(int i=1;i<option.size();i++){
			base.assertEqualsActualExpected(option.get(i).getText(), i+"����");
		}
		checkCreaterLBPeopleNum();
		checkDefaultData();
	}
}
