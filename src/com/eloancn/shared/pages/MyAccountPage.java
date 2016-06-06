package com.eloancn.shared.pages;

import java.awt.Robot;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.*;

/*
 * ���ҵ��˻���-���˻�������ҳ��
 */
public class MyAccountPage {
	Base base = new Base();
	DBData dbData = new DBData();
	
	RechargePage rechargePage = new RechargePage();
	InsideLetterPage insideLetterPage = new InsideLetterPage();
	AccountInfoPage accountInfoPage = new AccountInfoPage();
	SecurityAuthPage securityAuthPage = new SecurityAuthPage();
	ElectronicIOU electronicIOU = new ElectronicIOU();
	public String MyAccountUrl = base.indexURL + "/page/userMgr/myHome.jsp";
	
	By userName = By.id("accountRealName");	//�û���
	By isLoginTrueTxt = By.xpath("//*[contains(text(),'��ӭ��')]");
	By MyAccountLink = By.xpath("//li/a[text()='�ҵ��˻�']");
	
	//��ࡰ�ҵ��˻�������
	By MyAccountTxtinLeft = By.cssSelector("div.m-navlist>h2");			//���ҵ��˻����ı�
	By FivePartinLeft = By.cssSelector("div.m-navlist>ul");
	By AccountOverviewLnk = By.id("myhome_1");							//�˻�����	
	By TransactionRecordLnk = By.id("myhome_2");						//���׼�¼	
	By RechargeLnk = By.id("myhome_3");									//��ֵ	
	By WithdrawLnk = By.id("myhome_4");									//����	
	By MyRewardLnk = By.id("myhome_5");									//�ҵĽ���

	//��ࡰ�ҵĴ���������
	By YiCunBao = By.id("myhome_6");									//��汦
	By SanBiao = By.id("myhome_7");										//ɢ��Ͷ��
	By CreditAssignment = By.id("myhome_8");							//ծȨת��	
	By AutoBid = By.id("myhome_9");										//�Զ�Ͷ��	
//	By AppointBid = By.id("myhome_10");									//ԤԼͶ��
	
	//��ࡰ���Ǽƻ�������
	By MyInvestPlanLnk = By.id("myhome_16");							//�ҵ�Ͷ�ʼƻ�
	By MyLoanPlanLnk = By.id("myhome_17");								//�ҵĽ���ƻ�
	
	
	//��ࡰ�ҵĽ��롱����
	By MyBorrowLnk = By.id("myhome_11");								//�ҵĽ��
	By ApplyforLoanLnk = By.id("myhome_12");							//������
	
	//��ࡰ�˻����á�����
	By AccountInfoLnk = By.id("myhome_13");								//�˻���Ϣ
	By SecurityAuthLnk = By.id("myhome_14");							//��ȫ��֤
	By noticeSettingLnk = By.id("myhome_15");							//֪ͨ����
	
	public static By SelectedLnk = By.cssSelector("a.ico-accuntinfo.accountpandect.cur");//��ѡ�е�ģ��
			
	/****************************�ҵ��˻�-�˻�����ҳ��******************************/
	//�û���Ϣ����
	By AccountOverviewTxt = By.cssSelector("div.main-top-lw.ofv>h1");		//���˻�����������
	By Image = By.cssSelector("a.head > img[title=\"ͷ��\"]");				//�˻�ͷ��
	By TimeTxt = By.id("time_greet2");										//ʱ��
	By UserNameTxt = By.cssSelector("div.tit>span");						//�û���
	By GreetingTxt = By.id("time_greet");									//�ʺ���
	By AccountNameTxt = By.cssSelector("span.user-name");					//���˻�����...��
	By Icon = By.cssSelector("div.user-rz.ofv>a");							//4����֤ͼ��
	By GoMobileAuth = By.cssSelector("div.userrz-tip-c");					//ͼ����ʾ��Ϣ
//	By MobileCertification = By.id("icon-h-1");
//	By Authentication = By.id("icon-h-2");
//	By EmailCertification = By.id("icon-h-3-y");
//	By PayCode = By.id("icon-h-4");
	By SecurityLevel = By.cssSelector("span.safe");							//����ȫ����
	By SecurityImage = By.id("safeLevel");									//��ȫ����ͼ��
	By UpgradeLnk = By.id("safeLevelW");									//��������			
	By HighLevel = By.id("safeLevelW2");									//���ߡ���ȫ����
	
	//����׬����Ϣ���͡��˻����ʲ�������
	By TotalPart = By.cssSelector("div.add-money.overflowV");
	By TotalInterestTxt = By.cssSelector("p.tit");								//����׬����Ϣ��
	By TotalAssetsTxt = By.cssSelector("div.overflowV.clear > span");			//���˻����ʲ���
	By NumberinTotalInterest = By.id("accumulative");							//����Ϣ���
	public By NumberinTotalAssets = By.id("total_assets");								   //���ʲ����		
	By MoneyIconinTotalInterest = By.cssSelector("div.money-icon.posiR.counttotalnumico1");//��Ϣͼ��
	By MoneyIconinTotalAssets =	By.cssSelector("div.money-icon.posiR.counttotalnumico");	//�ʲ�ͼ��
	By EarnInterestTxt = By.cssSelector("#tank3>ul.tankul>li");								//��Ϣͼ����ʾ
	By TotalAssertsTxt = By.cssSelector("div.tank1>ul.tankul>li");							//�ʲ�ͼ����ʾ
	By sanBiaoWaitPrincipalNum = By.cssSelector("#total_balance_info_11");		//��ɢ����ձ���
	By yCBWaitPrincipalNum = By.cssSelector("#total_balance_info_12");			//����汦���ձ���
	By totalWaitInterestNum = By.cssSelector("#total_balance_info_13");			//��������Ϣ��
	By availableBalanceNum = By.cssSelector("#total_balance_info_14");			//��������
	By frozenMoneyNum = By.cssSelector("#total_balance_info_15");				//�������
	By totalAssetsNum = By.cssSelector("#total_balance_info_17"); 				//���˻����ʲ���
	
	//"�������"��"������"����
	By BalancePart = By.cssSelector("div.minus-money");
	By AvailableBalance = By.cssSelector("div.minus-money>div.tit");			//�����������ᡱ	
//	By FrozenMoney = By.cssSelector("div.minus-money>div.tit");					
	public By NumberinAvailableBalance = By.id("statField2");					//�����������
	public By NumberinFrozenMoney = By.id("statField3");						//����������
	By FreezingStatisticsImg = By.xpath("//a[@id='freezingStatistics']/img");	//������ϸͼ��
	By FreezedetailTitleTxt = By.id("saveTitle");								//��������ϸ������
	By FreezeTime = By.xpath("//table[@id='detailstable']/tbody/*/td[2]");		//����ʱ��
	By FreezeMoney = By.xpath("//table[@id='detailstable']/tbody/*/td[1]");		//������
	By FirstFreeze = By.cssSelector("#detailstable>tbody>tr>td");				//��һ�춳����Ϣ
//	By FreezeMoney = By.cssSelector("#detailstable>tbody>tr>td.colorG");
	By CloseFreezeLnk = By.cssSelector("a.tip_close.cpt");
	By rechargeBtn = By.cssSelector("div.buttn-cz>a.BtnOrange.fl.mt10");		//����ֵ��
//	By rechargeBtn = By.xpath("(//a[contains(text(),'��ֵ')])[3]");
	By ImproveProfileTxt = By.xpath("//form[@id='userFrom']/div/table/tbody/tr/td/div/div/h2");						//�����Ƹ�����Ϣ����ʾ
	By WithDrawBtn = By.cssSelector("div.buttn-tx>a.BtnBlue.fl.mt10.ml10");		//�����֡�
	By WithDrawTip = By.cssSelector("h2.u-tt");					//����ȫ��֤����ʾ
	
	//������û��Ͷ��Ŷ���Ͽ�������...�����ֻ��ߡ���ҳ�����ݲ��������Ǽƻ�...��
	By NoInvestmentTxt = By.cssSelector("div.tzyd > p");			//û��Ͷ�ʻ򲻰������Ǽƻ�����Ϣ
	By InvestNowLnk = By.cssSelector("div.tzyd > p > a");			//������Ͷ�ʡ��򡰵���鿴���Ǽƻ���
	
	//"��汦Ͷ��"����
	By YiCunBaoInvestTxt = By.cssSelector("div.tzcp > h1");				//����汦Ͷ�ʡ�
	By YCBEarnInterestTxt = By.cssSelector("div.tzcp-fl > p.tit");		//����׬��Ϣ��
	public By YCBEarnInterestNum= By.id("ycb_had_interest");					//��׬��Ϣ���
	By YCBWaitInterestTxt = By.cssSelector("div.tzcp-fr > p.tit");		//��������Ϣ��
	By YCBWaitPrincipalTxt = By.cssSelector("div.tzcp-fr > p.tit");		//�����ձ���
	By YCBWaitInterestNum = By.id("ycb_wait_interest");					//������Ϣ���
	By YCBWaitPrincipalNum = By.id("ycb_wait_principal");				//���ձ�����
	By YCBViewDetailsLnk = By.cssSelector("p.link > a");				//�鿴����
	
	//��ɢ��Ͷ�ʡ�����
//	By SanBiaoInvestTxt = By.cssSelector("div.tzcp > h1");//YiCunBaoInvestTxt
	By SanBiaoInvestTxt = By.xpath("//div[@id='_content']/div/div[4]/div[2]/h1");
	By SanBiaoInfoTxt = By.cssSelector("div.tzcp >h1 > small");
	By SBEarnInterestTxt = By.xpath("//div[@id='_content']/div/div[4]/div[2]/div/div/p");
	By SBEarnInterestIcon = By.id("qt2s");
	By SBInterestIcon = By.cssSelector("div.tzcp-box>div>p.tit>a.money-icon");
	By SBTootip = By.cssSelector("div.ui-tooltip-content");
	By SBEarnInterestNum = By.id("tender_had_interest");
	By SBWaitPITxt = By.xpath("//div[@id='_content']/div/div[4]/div[2]/div/div[2]/p");
	By SBWaitPINum =By.id("tender_wait_principal_interest");
	By SBWaitPIIcon = By.id("qt3");
	By SBWaitInterestTxt = By.xpath("//div[@id='_content']/div/div[4]/div[2]/div/div[2]/p[2]");
	By SBWaitInterestNum = By.id("tender_wait_interest");
	By SBWaitInterestIcon = By.id("qa4");
	By SBWaitPrincipalTxt = By.xpath("//div[@id='_content']/div/div[4]/div[2]/div/div[2]/p[3]");
	By SBWaitPrincipalNum = By.id("tender_wait_principal");
	By SBViewDetailsLnk = By.xpath("//div[@id='_content']/div/div[4]/div[2]/div/div[2]/p[4]/a");
	
	//���ҵĽ��롱����
	By MyLoanTxt = By.cssSelector("div.main-jrzh-lw > h1");
	By WaitRepayTxt = By.cssSelector("div.main-jrzh-lw > div.tzcp-fl > p.tit");
	By WaitRepayNum = By.id("myloan_wait_money");
	By WaitRepayPITxt = By.cssSelector("div.jrzh-fr > p.tit");
	By WaitRepayPINum = By.id("myloan_wait_principal");
	By WaitRepayInterestTxt = By.xpath("//div[@id='_content']/div/div[5]/div[2]/p[2]");
	By WaitRepayInterestNum = By.id("myloan_wait_interest");
	By LateFeeTxt = By.xpath("//div[@id='_content']/div/div[5]/div[2]/p[3]");
	By LateFeeNum = By.id("myloan_overdue_money");
	By LoanApplicationLnk = By.cssSelector("div.jrzh>p.link>a");
	By MyLoanLnk = By.xpath("//div[3]/p[2]/a");	
	
	/****************************�ҵ��˻�-����******************************/
	
	//����ϲ��������ҵ��˻�������
	public void clickMyAccountLink(){
		base.clickWithWait(MyAccountLink);
		base.checkElementVisible(AccountOverviewTxt);
	}
	//�����ർ�����˻�����������
	public void clickAccountOverviewLnk(){
		base.clickElementNoWait(AccountOverviewLnk);
		base.checkElementVisible(AccountOverviewTxt);
	}
	//�����ർ�������׼�¼������
	public void clickTransactionRecord(){
		base.clickElementNoWait(TransactionRecordLnk);
		base.assertEqualsActualExpected(base.getElementText(TransactionRecordPage.TransactionRecordTxt), "���׼�¼");
	}
	//�����ർ������ֵ������
	public void clickRechargeLnk(){
		base.clickElementNoWait(RechargeLnk);
		base.assertEqualsActualExpected(base.getElementText(RechargePage.OnlineRechargeTxt), "��ֵ");
	}
	//�����ർ�������֡�����
	public void clickWithDrawLnk(){
		base.clickElementNoWait(WithdrawLnk);
		base.assertEqualsActualExpected(base.getElementText(WithDrawPage.WithDrawTxt), "����");
	}
	//�����ർ�����ҵĽ���������
	public void clickMyRewardLnk(){
		base.clickElementNoWait(MyRewardLnk);
		base.assertEqualsActualExpected(base.getElementText(MyRewardPage.MyRedPacksLnk), "�ҵĺ��");		
	}
	//�����ർ�����ҵĴ������е�5������
	public void clickYCBLnk(){		
		base.clickElementNoWait(YiCunBao);
		base.checkElmentText(YCBPage.YCBTxt, "��汦");
	}
	//�����ർ����ɢ��Ͷ�ʡ�����
	public void clickSBInvestLnk(){
		base.clickWithWait(SanBiao);
		base.checkElmentText(SBInvestPage.SBInvestTxt, "ɢ��Ͷ�� ��ɢ��+����ծȨ��");
		new SBInvestPage().ifExistInvest();
	}
	//�����ർ����ծȨת�á�����
	public void clickCreditAssignLnk(){
		base.clickWithWait(CreditAssignment);
		base.checkElmentText(CreditAssignPage.CreditAssignTxt, "ծȨת��");
		new CreditAssignPage().ifshowCredit();
	}
	//�����ർ�����Զ�Ͷ�ꡱ����
	public void clickAutoBidLnk(){
		
		base.clickElementNoWait(AutoBid);
		base.checkElement(AutoBidPage.Main);
	}
	//�����ർ�����ҵ�Ͷ�ʼƻ�������
	public void clickMyInvestPlanLnk(){
		base.clickWithWait(MyInvestPlanLnk);
//		base.checkElement();
	}
	//�����ർ�����ҵĽ���ƻ�������
	public void clickMyDebitPlanLnk(){
		base.clickWithWait(MyLoanPlanLnk);
		base.checkElementVisible(MyDebitPlan.ListContent);
	}
	//�����ർ�����ҵĽ�����
	public void clickMyDebtLnk(){
		base.clickWithWait(MyBorrowLnk);
		base.checkElmentText(MyLoanPage.MyLoanTxt, "�ҵĽ��");
		if(base.Windowsize()>1){
			base.closeWebDriver();
		}
	}
	//�����ർ�����˻���Ϣ������
	public void clickAccountInfoLnk(){
		base.clickWithWait(AccountInfoLnk);
		base.checkElement(AccountInfoPage.AccountInfoTxt);
	}
	
	//�����ർ����ԤԼͶ�ꡱ����
//	public void clickAppointBitLnk(){
//		base.clickElementNoWait(AppointBid);
//		base.checkElmentText(AppointBidPage.AppointBidTxt, "ԤԼͶ��");
//	}
	
	public String getUserID(){
		String text=base.ExecuteJS("var obj1=document.getElementsByTagName('body');var obj2=obj1[0].getElementsByTagName('script');return obj2[11].innerHTML");
		int begin=text.indexOf("cumember['mid']")+17;
		String userid=text.substring(begin, text.indexOf("'", begin));
		return userid;
	}
	
	/****************************�ҵ��˻�-�˻�����******************************/
	
	public void checkDefaultImg(){
		String src = base.getLnkElementText(Image, "src");
		if(base.indexURL.contains("client")){
			base.assertEqualsActualExpected(src.split("\\?")[0], base.indexURL+"/page/userMgr/images/userimg.png");
		}else if(base.indexURL.contains("test")){
			base.assertEqualsActualExpected(src.split("\\?")[0], "http://static66.eloancn.com//page/userMgr/images/userimg.png");
		}else if(base.indexURL.contains("www")){
			base.assertEqualsActualExpected(src.split("\\?")[0], "http://static7.eloancn.com//page/userMgr/images/userimg.png");
		}
	}
	
	//����û�ͷ��
	public void clickUserImageLnk(){
		base.clickElementNoWait(Image);
		base.checkElmentText(AccountInfoPage.AccountInfoTxt, "�˻���Ϣ");
	}
	//����ĸ���֤icon
	public void clickAuthIcon(){
		
		String [] GoAuthTxt = {"�ֻ�δ��֤��ȥ��֤","���δ��֤��ȥ��֤","�ʼ�δ��֤��ȥ��֤","δ����֧�����룬ȥ����"};
		for(int i=0;i<4;i++){
			List<WebElement> IconElements = base.getElements(Icon);
			base.mouseToIndexElement(Icon, i+1);
			if(base.getIndexElementText(GoMobileAuth,i).equals(GoAuthTxt[i])){
				IconElements.get(i+1).click();
				base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "��ȫ��֤");
				clickAccountOverviewLnk();
			}
		}
	}
	
	/**
	 * �ҵ��˻�-�˻�����ҳ��У�� ��֤Icon��ʾ��Ϣ
	 * @param iconName Icon����
	 * @param promptMsg ��ʾ��Ϣ
	 * @author ������ 2015-12-30
	 */
	public void checkUserIconMsgByOne(String iconName, String promptMsg){
		
		List<WebElement> IconElements = base.getElements(Icon);
		int size = IconElements.size();
		String position = "";
		if(size == 4){
			switch (iconName) {
			case "�ֻ�":		position = "2"; break;
			case "���": 		position = "3"; break;
			case "����":		position = "4"; break;
			case "֧������": 	position = "5"; break;
			default:		position = "2"; break;
			}
		}
		else if(size == 5){
			switch (iconName) {
			case "VIP":		position = "2"; promptMsg = "������" + promptMsg; break;
			case "�ֻ�":		position = "3"; break;
			case "���": 		position = "4"; break;
			case "����":		position = "5"; break;
			case "֧������": 	position = "6"; break;
			default:		position = "2"; promptMsg = "������" + promptMsg; break;
			}
		}
		By iconby = By.cssSelector("div.user-rz.ofv>a:nth-child(" + position + ")");
		By msgBy = By.cssSelector("div.user-rz.ofv>a:nth-child(" + position + ") > div >div:nth-child(2)");

		base.mouseToElement(iconby);
		System.out.println("��ҳ��ȡ��" + iconName + " Ԫ�أ�ֵΪ��" + base.getElementText(msgBy));
		base.assertEqualsActualExpected(base.getElementText(msgBy), promptMsg);
	}
	
	/**
	 * �ҵ��˻�-�˻�����ҳ��У�� ������֤Icon��ʾ��Ϣ
	 * @param vipMsg VIP��ʾ��Ϣ(���ݵȼ���ͬ����ʾ����ͬ)����ֵ��ʽ��+0.1%
	 * @author ������ 2015-12-30
	 */
	public void checkUserIconMsgByAll(String vipMsg){
		
		String [] renZhengTxt =	   {"�ֻ�����֤",     "�������֤",      "�ʼ�����֤",     "֧������������"};
		String [] weiRenZhengTxt = {"�ֻ�δ��֤��ȥ��֤","���δ��֤��ȥ��֤","�ʼ�δ��֤��ȥ��֤","δ����֧�����룬ȥ����"};
		
		String msg = "";
		List<WebElement> IconElements = base.getElements(Icon);
		int size = IconElements.size();
		int i = 0;
		if(size == 5){//�����VIP��֤������У��VIP��֤
			msg = IconElements.get(0).getText();
			base.assertEqualsActualExpected(msg, "������" + vipMsg);
			i = 1;
		}
		for(; i < size; i++){
			base.mouseToIndexElement(Icon, i);
			msg = IconElements.get(i).getText();
			if(IconElements.get(i).getAttribute("id").contains("-y")){
				base.assertEqualsActualExpected(msg, renZhengTxt[i]);
			}
			else{
				base.assertEqualsActualExpected(msg, weiRenZhengTxt[i]);
			}
		}
	}
	
	//������ֻ���֤��icon
	public void clickMobileAuthIcon(){
		
		base.clickElement(Icon, 1);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "��ȫ��֤");
	}
	//������ֻ���֤����ʾ����
	public void clickGoMobileAuth(){
		
		base.mouseToIndexElement(Icon, 1);
		base.assertEqualsActualExpected(base.getIndexElementText(GoMobileAuth,0),"�ֻ�δ��֤��ȥ��֤");
		base.clickElement(GoMobileAuth, 0);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "��ȫ��֤");
	}
	//����������֤��icon
	public void clickIdentityAuthIcon(){
		
		base.clickElement(Icon, 2);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "��ȫ��֤");
	}
	//������ֻ���֤����ʾ����
	public void clickGoIdentityAuth(){
		
		base.mouseToIndexElement(Icon, 2);
		base.assertEqualsActualExpected(base.getIndexElementText(GoMobileAuth,1),"���δ��֤��ȥ��֤");	
		base.clickElement(GoMobileAuth, 1);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "��ȫ��֤");
	}
	//��֤��������֤��
	public void checkEmailAuth(){
		
		base.mouseToIndexElement(Icon, 3);
		base.assertEqualsActualExpected(base.getIndexElementText(GoMobileAuth,2),"��������֤");
	}
	//�����������֤��icon
	public void clickEmailAuthIcon(){
		
		base.clickElement(Icon, 3);		
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "��ȫ��֤");
	}
	//�����������֤����ʾ����
	public void clickGoEmailAuth(){
		
		base.mouseToIndexElement(Icon, 3);
		base.assertEqualsActualExpected(base.getIndexElementText(GoMobileAuth,2),"�ʼ�δ��֤��ȥ��֤");	
		base.clickElement(GoMobileAuth, 2);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "��ȫ��֤");
	}
	//�����֧�����롱icon
	public void clickPayPwdIcon(){
		
		base.clickElement(Icon, 4);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "��ȫ��֤");
	}
	//�����֧�����롱��ʾ����
	public void clickGoPayPwdAuth(){
		
		base.mouseToIndexElement(Icon, 4);
		base.assertEqualsActualExpected(base.getIndexElementText(GoMobileAuth,3),"δ����֧�����룬ȥ����");	
		base.clickElement(GoMobileAuth, 3);
		base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "��ȫ��֤");
	}
	//�����ȫ��������������
	public void clickUpgradeLnk(){
		
		if(base.getElementText(HighLevel).equals("��")){
			System.out.println("��ȫ�����Ѿ�����ˣ�");
		}else{
			base.clickElement(UpgradeLnk, 0);
			base.assertEqualsActualExpected(base.getElementText(SecurityAuthPage.SecurityAuthTxt), "��ȫ��֤");
		}
	}
	
	//��顰��׬����Ϣ��icon
	public void checkTotalInterestIcon(){		
		
		base.mouseToIndexElement(MoneyIconinTotalInterest, 0);
		String [] EarnInterest = {"��汦��׬��Ϣ","","ɢ����׬��Ϣ","","��׬����Ϣ"};
		List<WebElement> TxtEarnElement = base.getElements(EarnInterestTxt);
		for(int i=0;i<TxtEarnElement.size();i++){
			switch(i){			
				case 1: base.assertEqualsActualExpected(TxtEarnElement.get(1).getText(),"+");break;
				case 3:	
					base.assertEqualsActualExpected(TxtEarnElement.get(3).getText(),"=");break;
				default: base.assertEqualsActualExpected(TxtEarnElement.get(i).findElement(By.tagName("p")).getText(),EarnInterest[i]);
						 TxtEarnElement.get(i).findElement(By.tagName("span")).isDisplayed();
			}
		}		
	}
	
	//��顰�˻����ʲ���icon
	public void checkTotalAssetIcon(){
		
		base.mouseToIndexElement(MoneyIconinTotalAssets, 0);
		String [] TotalAsset = {"ɢ����ձ���","","��汦���ձ���","","������Ϣ","","�������","","������","","�˻����ʲ�"};	
		List<WebElement> TxtAssets = base.getElements(TotalAssertsTxt);
		for(int i=0;i<TxtAssets.size();i++){
			switch(i){	
				case 1:case 3:case 5: case 7: base.assertEqualsActualExpected(TxtAssets.get(i).getText(),"+");break;
				case 9:base.assertEqualsActualExpected(TxtAssets.get(i).getText(),"=");break;
				default: base.assertEqualsActualExpected(TxtAssets.get(i).findElement(By.tagName("p")).getText(),TotalAsset[i]);
						 TxtAssets.get(i).findElement(By.tagName("span")).isDisplayed();
			}
		}
	}
	
	/**
	 * ��ȡ��������
	 * @return �������
	 * @author ������ 2015-7-22
	 */
	public String getNumberinAvailableBalance(){
		base.sleep(2000);
		//��ȡ�������
		String NumberinAvailableBalanceStr = base.getElementTextWithWait(NumberinAvailableBalance);
		NumberinAvailableBalanceStr = NumberinAvailableBalanceStr.substring(0, NumberinAvailableBalanceStr.indexOf(" "));
		return NumberinAvailableBalanceStr;
	}	
	
	/**
	 * ��ȡ�˻������еĽ��(��������׬����Ϣ���˻����ʲ����������������)
	 * @return ���
	 * @author ������ 2015-10-9
	 */
	public String getMoneyNum(By by){
		String moneyNum = base.getElementTextWithWait(by);
		int length = moneyNum.length();
		moneyNum = moneyNum.substring(0, length-1);        //42,200.00 Ԫ ��Ϊ 42,200.00
		moneyNum = base.stringToReplace(moneyNum, ",", "");//42,200.00 ��Ϊ 42200.00
		moneyNum = moneyNum.trim();
		return moneyNum;
	}
	
	/**
	 * ���������ϸͼƬ
	 * @author ������ 2015-10-9
	 */
	public void clickFreezingStatisticsImg(){
		base.clickWithWait(FreezingStatisticsImg);
	}
	
	/**
	 * ��ȡ�������ʽ���ϸ����ĳ�еļ���
	 * @param columnName: ���� 
	 * @return ĳ�еļ���
	 * @author ������ 2015-10-8
	 */
	public List<WebElement> getFreezingStatistics(String columnName){
		
		By by = null;
		if(columnName.equals("������")){
			by = By.cssSelector(".colorG");
		}
		List<WebElement> list = new ArrayList<WebElement>();
		list = base.getElements(by);
		return list;
	}
	
	/**
	 * �����ʽ���ϸ�ж�����֮��
	 * @param list�����ж�����
	 * @return ������֮��
	 * @author ������ 2015-10-8
	 */
	public double getFreezeMoneySum(List<WebElement> list){
		
		double sum = 0;
		String temp;
		for (WebElement webElement : list) {
			temp = webElement.getText();
			sum += Double.valueOf(temp);
		}
		return sum;
	}
	
	public void isLoginTrue(){
		base.assertNotNullBy(isLoginTrueTxt);
	}
	
	/**
	 * ��ȡ�˻����ʲ���ϸ��Ϣ��������ɢ����ձ�����汦���ձ��𡢴�����Ϣ��������������˻����ʲ���
	 * @return ��Ϣ����
	 * @author ������ 2015-10-9
	 */
	public List<String> getAssets(){
		
		base.mouseToElement(MoneyIconinTotalAssets);
		List<WebElement> TxtAssets = base.getElements(TotalAssertsTxt);
		List<String> assetsList = new ArrayList<String>();
		String temp = null;
		for (int i = 0; i < TxtAssets.size(); i++) {
			switch (i) {
			case 0:case 4:
				temp = TxtAssets.get(i).findElement(By.cssSelector("p:nth-child(2) > span")).getText();break;
			case 2:case 8:case 10:
				temp = TxtAssets.get(i).findElement(By.tagName("span")).getText();break;
			case 6:
				temp = TxtAssets.get(i).findElement(By.tagName("span")).getText();break;
			default:
				break;
			}
			//û�����ݣ������������
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 9){
				continue;
			}
			temp = base.stringToReplace(temp, ",", "");
			assetsList.add(temp);
		}
		return assetsList;
	}
	
	/**
	 * У���˻����ʲ���������ϸ�Ƿ���ȷ
	 * @param list���˻������� ���˻����ʲ�������ϸ
	 * @param waitPrincipalNumStrByLend��ɢ��Ͷ���� �����ձ���
	 * @param waitPrincipalNumStrByECB����汦�����ձ���
	 * @param waitInterestNum���˻������� ��������Ϣ��
	 * @param availableBalanceNum���˻������� ��������
	 * @param frozenMoneyNum���˻������� �������
	 * @param totalAssetsNum���˻������С��˻����ʲ���
	 * @author ������ 2015-10-9
	 */
	public void checkAssets(List<String> list, String waitPrincipalNumStrByLend, String waitPrincipalNumStrByECB, String waitInterestNum, String availableBalanceNum, String frozenMoneyNum, String totalAssetsNum){
		
		double sum = 0;
		//�������һ������˻����ʲ���
		for(int i = 0; i < list.size()-1; i++){
			sum = base.add(sum, Double.valueOf(list.get(i)));
			switch (i) {
			case 0:base.assertEqualsActualExpected(list.get(i), waitPrincipalNumStrByLend);break;
			case 1:base.assertEqualsActualExpected(list.get(i), waitPrincipalNumStrByECB);break;
			case 2:base.assertEqualsActualExpected(list.get(i), waitInterestNum);break;
			case 3:base.assertEqualsActualExpected(list.get(i), availableBalanceNum);break;
			case 4:base.assertEqualsActualExpected(list.get(i), frozenMoneyNum);break;
			default:
				break;
			}
		}
		base.assertEqualsActualExpected(base.appendZero(base.doubleFormat(sum)), totalAssetsNum);
	}
	
	/****************************�ҵ��˻�-�˻�����-������******************************/
	
	//����������ʽ���ϸ��ͼ��
	public void clickFreezeStatisticsImg(){
		base.clickWithWait(FreezingStatisticsImg);
		base.checkElmentText(FreezedetailTitleTxt, "�����ʽ���ϸ");
	}
	//��ȡ��ĿǰΪֹ�Ķ����15248.26
	public double getAllFrozenMoney(){
		String froze = base.getElementTextWithWait(NumberinFrozenMoney);
//		if(froze.contains(",")){
		froze = froze.replaceAll(",", "");
//		}
		froze = froze.replaceAll("Ԫ", "");
		return Double.parseDouble(froze);
	}
	//��ȡ�ϸ��µĶ�����
	public double[] getLastMonthFreezeMoney(){	

		clickFreezeStatisticsImg();
		if(base.getElementTextWithWait(FirstFreeze).equals("�޶����ʽ�")){
			clickCloseFreezeLnk();
			double a[] = {0,0.00};
			return a;
		}else{
			Calendar cal = Calendar.getInstance();
			int day = cal.get(Calendar.DAY_OF_MONTH);
			if(day>=1 && day<5){	
				cal.add(Calendar.MONTH,-1);
			}
			cal.add(Calendar.MONTH, -1);
			String time = new SimpleDateFormat("yyyy-MM").format(cal.getTime());
			List<WebElement> times = base.getElements(FreezeTime);
			List<WebElement> money = base.getElements(FreezeMoney);
			int size = times.size(),withdrawnum=0;
			double amount = 0.0;
			for(int i=0;i<size;i++){
				String freezetime = times.get(i).getText().substring(0,7);
				double freezemoney = Double.parseDouble(money.get(i).getText());
				if(freezetime.equals(time)){
					withdrawnum=withdrawnum+1;
					amount= amount+freezemoney;
				}
			}
			clickCloseFreezeLnk();
			double withdraw[]={withdrawnum,amount};
			return withdraw;
		}
	}
	//��ȡ��ֹ���ϸ��µ׵Ķ�����
	public Double getFreezeMoneyUntilLastMonth(){

		clickFreezeStatisticsImg();
		if(base.getElementTextWithWait(FirstFreeze).equals("�޶����ʽ�")){
			clickCloseFreezeLnk();
			return 0.00;
		}else{
			String time;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			int day = base.getCurrentDay();
			if(day>=1 && day<=5){	
				time = base.getLastMonthDay(-2);
			}else{
				time = base.getLastMonthDay(-1);
			}
			List<WebElement> times = base.getElements(FreezeTime);
			List<WebElement> money = base.getElements(FreezeMoney);
			int size = times.size();
			double amount = 0.0;
			for(int i=0;i<size;i++){
				String freezetime = times.get(i).getText().substring(0,10);
				double freezemoney = Double.parseDouble(money.get(i).getText());
				try {
					if(df.parse(freezetime).getTime()<=df.parse(time).getTime()){
						amount= amount+freezemoney;
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			clickCloseFreezeLnk();
			return amount;
		}	
	}
	public void clickCloseFreezeLnk(){
		base.clickElementNoWait(CloseFreezeLnk);
	}
	
	/****************************�ҵ��˻�-�˻�����-��ֵ/����/���Ǽƻ�******************************/
	
	//�������ֵ����ť
	public void clickRechargeBtn(){
				
		base.clickWithWait(rechargeBtn);
//		base.checkElmentText(RechargePage.OnlineRechargeTxt, "������ֵ");
		if(base.isElementVisible(RechargePage.OnlineRechargeTxt)){
			base.assertEqualsActualExpected(base.getElementText(RechargePage.OnlineRechargeTxt),"������ֵ");
		}else{
			base.assertEqualsActualExpected(base.getElementText(RechargePage.ImproveProfileTxt),"���Ƹ��������Ϣ");
			new RechargePage().closeInfo();
		}
	}
	public void clickCloseImproveBox(){
		
	}
	//��������֡���ť
	public void clickWithDrawBtn(){
		
		base.clickWithWait(WithDrawBtn);
//		base.acceptAlert();
		base.checkElmentText(WithDrawPage.WithDrawTxt, "����");
/*		if(base.getElements(WithDrawPage.WithDrawTxt).isEmpty()){
			base.checkElement(WithDrawPage.WithDrawTip);
		}else{
			base.assertEqualsActualExpected(base.getElementText(WithDrawPage.WithDrawTxt), "����");
		}
*/	}
	//���������Ͷ��>>������
	public void clickInvestNowLnk(){
		
		base.clickElementNoWait(InvestNowLnk);
		base.assertEqualsActualExpected(base.getPageTitle(),PageTitles.yiCunBao);
	}
	
	/****************************�ҵ��˻�-�˻�����-��汦******************************/
	
	//�����汦Ͷ�ʡ��鿴���顱����
	public void clickYCBViewDetailLnk(){
		
		base.clickElementNoWait(YCBViewDetailsLnk);
		base.checkElmentText(YCBPage.YCBTxt, "��汦");
	}
	
	/****************************�ҵ��˻�-�˻�����-ɢ��Ͷ��******************************/
	
	//��顰ɢ��Ͷ�ʡ��е�icon
	public void checkSBInterestIcon(){
		
		String [] Tootips = {"ɢ��+����ծȨ�ľ����棬���治�����Ƹ�����ѣ���������ƽ̨������֧����40����Ϣ","ɢ��+����ծȨ���յı������Ϣ����Ϣ�����Ƹ������","ɢ��+����ծȨ���յ���Ϣ����Ϣ�����Ƹ������"}; 
		for(int i =0; i<3; i++){				
			base.mouseToIndexElement(SBInterestIcon, i);
			base.sleep(1000);
			List<WebElement> ThreeTooltip = base.getElements(SBTootip);		
			base.assertEqualsActualExpected(Tootips[i],ThreeTooltip.get(i).getText());			
		}		
	}
	//���ɢ��Ͷ�ʡ��鿴���顱����
	public void clickSBViewDetailLnk(){
		
		base.clickElementNoWait(SBViewDetailsLnk);
		base.assertEqualsActualExpected(base.getElementText(SBInvestPage.SBInvestTxt),"ɢ��Ͷ�� ��ɢ��+����ծȨ��");
	}
	
	/****************************�ҵ��˻�-�˻�����-�ҵĽ���******************************/
	
	//��������������
	public void clickLoanApplicationLnk(){
		
		base.clickElementNoWait(LoanApplicationLnk);
		base.checkElement(LoanApplicationPage.Main);
		if(base.getElements(LoanApplicationPage.ApplyforLoanTxt).isEmpty()){
			base.checkElmentText(LoanApplicationPage.VerifyAuthBtn, "�ʸ���֤");
		}else{
			base.assertEqualsActualExpected(base.getElementText(LoanApplicationPage.ApplyforLoanTxt), "������");
		}	
/*		
		if(base.getElementNoWait(LoanApplicationPage.ApplyforLoanTxt).isDisplayed()){
			base.assertEqualsActualExpected(base.getElementText(LoanApplicationPage.ApplyforLoanTxt), "������");
		}else if(base.getElementNoWait(LoanApplicationPage.VerifyAuthBtn).isDisplayed()){
			base.checkElmentText(LoanApplicationPage.VerifyAuthBtn, "�ʸ���֤");
		}
*/	}
	
	//������ҵĽ�����
	public void clickMyLoanLnk(){
		base.clickElementNoWait(MyLoanLnk);
		base.checkElmentText(MyLoanPage.MyLoanTxt, "�ҵĽ��");
	}
	//��顰�ҵ��˻���ҳ����ർ������
	public void verifyLeftnavigationData(){
		
		String [] TxtinLeft = {"�ҵ��˻�", "�ҵĴ���", "���Ǽƻ�","�ҵĽ���","�˻�����"};
		String [][] LinkTxtinLeft = {{"�˻�����","���׼�¼","��ֵ","����","�ҵĽ���"},{"��汦","ɢ��Ͷ��","ծȨת��","�Զ�Ͷ��","ԤԼͶ��"},{"�ҵ�Ͷ�ʼƻ�","�ҵĽ���ƻ�"},{"�ҵĽ��","������"},{"�˻���Ϣ","��ȫ��֤","֪ͨ����"}};
		base.checkElement(MyAccountTxtinLeft);
		List<WebElement> TxtElementinLeft = base.getElements(MyAccountTxtinLeft);
		List<WebElement> FivePartsinLeft = base.getElements(FivePartinLeft);
		for(int i =0; i<TxtElementinLeft.size();i++){	
			base.assertEqualsActualExpected(TxtElementinLeft.get(i).getText(),TxtinLeft[i]);
		}
		for(int i = 0; i<FivePartsinLeft.size();i++){
			List<WebElement> LinksinLeft = FivePartsinLeft.get(i).findElements( By.tagName("li"));			
			for(int j = 0;j<LinksinLeft.size();j++){				
				base.assertEqualsActualExpected(LinkTxtinLeft[i][j],LinksinLeft.get(j).getText());
			}			
		}
	}
	public void verifyMyAccountData(){
		try{
			base.getElementText(AccountOverviewTxt).contains("�˻�����");
			base.assertTrueBy(TotalPart);
			base.assertTrueBy(BalancePart);
			base.assertEqualsActualExpected(base.getLnkElementText(FreezingStatisticsImg, "src"),base.indexURL+"/page/userMgr/images/icon.png");	
			base.assertEqualsActualExpected(base.getElementText(rechargeBtn),"��ֵ");
			base.assertEqualsActualExpected(base.getElementText(WithDrawBtn),"����");
			base.assertEqualsActualExpected(base.getElementText(YiCunBaoInvestTxt),"��汦Ͷ��");
			base.assertEqualsActualExpected(base.getElementText(YCBViewDetailsLnk),"�鿴����>>");
			base.assertEqualsActualExpected(base.getElementText(SanBiaoInvestTxt),"ɢ��Ͷ��(ɢ��+����ծȨ)");
			base.assertEqualsActualExpected(base.getElementText(SBViewDetailsLnk),"�鿴����>>");	
			base.assertEqualsActualExpected(base.getElementText(MyLoanTxt),"�ҵĽ���");
			base.assertEqualsActualExpected(base.getElementText(LoanApplicationLnk),"������");
			base.assertEqualsActualExpected(base.getElementText(MyLoanLnk),"�ҵĽ��");
			clickYCBViewDetailLnk();
			clickAccountOverviewLnk();
			clickSBViewDetailLnk();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	public void verifyAccountOverviewData(){
		try{
			
		//�ϲ����˻���������֤
		base.getElementText(AccountOverviewTxt).contains("�˻�����");
		base.assertEqualsActualExpected(base.getElementText(SecurityLevel),"��ȫ����");

		//����Ϣ���ʲ�������֤
		base.assertEqualsActualExpected(base.getElementText(TotalInterestTxt),"��׬����Ϣ");
		base.assertEqualsActualExpected(base.getElementText(TotalAssetsTxt),"�˻����ʲ�");
		base.assertTrueBy(NumberinTotalInterest);
		base.assertTrueBy(NumberinTotalAssets);
		
		//���ö�����������֤
		base.getElementText(AvailableBalance).contains("������");
		base.getWebElementByElements(AvailableBalance,1).getText().contains("�����");
		base.assertTrueBy(NumberinAvailableBalance);
		base.assertTrueBy(NumberinFrozenMoney);		
		base.assertEqualsActualExpected(base.getLnkElementText(FreezingStatisticsImg, "src"),base.indexURL+"/page/userMgr/images/icon.png");	
		base.assertEqualsActualExpected(base.getElementText(rechargeBtn),"��ֵ");
		base.assertEqualsActualExpected(base.getElementText(WithDrawBtn),"����");
		
		//����汦Ͷ�ʡ�������֤
		base.assertEqualsActualExpected(base.getElementText(YiCunBaoInvestTxt),"��汦Ͷ��");
		base.assertEqualsActualExpected(base.getElementText(YCBEarnInterestTxt),"��׬��Ϣ");
		base.assertTrueBy(YCBEarnInterestNum);
		base.getElementText(YCBWaitInterestTxt).contains("������Ϣ��");
		base.assertTrueBy(YCBWaitInterestNum);
		base.getElementText(YCBWaitPrincipalTxt).contains("���ձ���");
		base.assertTrueBy(YCBWaitPrincipalNum);
		base.assertEqualsActualExpected(base.getElementText(YCBViewDetailsLnk),"�鿴����>>");
		//��ɢ��Ͷ�ʡ�������֤
		base.assertEqualsActualExpected(base.getElementText(SanBiaoInvestTxt),"ɢ��Ͷ��(ɢ��+����ծȨ)");
		base.assertEqualsActualExpected(base.getElementText(SBEarnInterestTxt),"��׬��Ϣ");
		base.assertTrueBy(SBEarnInterestNum);
		base.getElementText(SBWaitPITxt).contains("���ձ�Ϣ��");
		base.assertTrueBy(SBWaitPINum);
		base.getElementText(SBWaitInterestTxt).contains("������Ϣ��");
		base.assertTrueBy(SBWaitInterestNum);
		base.getElementText(SBWaitPrincipalTxt).contains("���ձ���");
		base.assertTrueBy(SBWaitPrincipalNum);
		base.assertEqualsActualExpected(base.getElementText(SBViewDetailsLnk),"�鿴����>>");	
		//���ҵĽ��롱������֤
		base.assertEqualsActualExpected(base.getElementText(MyLoanTxt),"�ҵĽ���");
		base.assertEqualsActualExpected(base.getElementText(WaitRepayTxt),"�����ܽ��");
		base.assertTrueBy(WaitRepayNum);
		base.getElementText(WaitRepayPITxt).contains("���ձ���");
		base.assertTrueBy(WaitRepayPINum);
		base.getElementText(WaitRepayInterestTxt).contains("������Ϣ��");
		base.assertTrueBy(WaitRepayInterestNum);
		base.getElementText(LateFeeTxt).contains("���ڷ��ã�");
		base.assertTrueBy(LateFeeNum);
		base.assertEqualsActualExpected(base.getElementText(LoanApplicationLnk),"������");
		base.assertEqualsActualExpected(base.getElementText(MyLoanLnk),"�ҵĽ��");
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	//��֤�Ƿ���ת���ҵ��˻���ĳ��ģ��
	public void isGoMyAccount(String module){
		base.sleep(2000);
		base.assertNotNullBy(By.xpath("//div[@class='m-navlist']//a[text()='" + module + "' and contains(@class,'cur')]"));
	}

	//��ת���ҵ��˻���ĳ��ģ��
	public void turnToMyAccount(String module){
		base.clickWithWait(By.xpath("//div[@class='m-navlist']//a[text()='" + module + "']"));
	}
	
	
	/**
	 * ����������������������...���Ժ򣡡��Ƿ���ʾ
	 * @author ������ 2015-1-5 
	 */
	public void isHardLoadShow(){
		boolean isShow = base.isElementPresent(By.xpath("//div[@id='loadingsx']"));
		if(isShow){
			base.refreshPage();
		}
	}
	
	/**
	 * ����Ԫ
	 * ��ȡ�˻��������
	 */
	public double getBalance(){
		String balance = "";
		String money = "";
		for (int i = 0; i < 3; i++) {
			if (base.checkElementPresent(By.xpath("//*[@id='statField2']/small[contains(text(),'Ԫ')]"), 20)) {
				balance = base.getElementTextWithWait(By.xpath("//*[@id='statField2']"));
				//�����˻����  ����87,897.00 Ԫ->87897.00
				String myBalance[]=balance.split(",");
				for (int j = 0; j < myBalance.length; j++) {
					money += myBalance[j];
				}
				money = money.replaceAll("Ԫ", "");
				break;
			}else {
				base.refreshPage();
			}
		}
		System.out.println("�˻���"+money);
		return Double.parseDouble(money);
	}
	
	/**
	 * �ο�����Ԫ��getBalance()
	 * @return �˻����
	 * @author ������ 2015-11-25
	 */
	public String getBalance_1(){
		String balance = base.getElementTextWithWait(By.xpath("//*[@id='statField2' and contains(text(),'.')]"));
		if(balance.contains("������")){
			base.refreshPage();
			base.sleep(3000);
			balance = base.getElementTextWithWait(By.xpath("//*[@id='statField2' and contains(text(),'.')]"));
		}
		//�����˻����  ����87,897.00 Ԫ->87897.00
		String myBalance[]=balance.split(",");
		String money = "";
		for (int i = 0; i < myBalance.length; i++) {
			money += myBalance[i];
		}
		money = money.replaceAll("Ԫ", "");
		return money;
	}

	
	By phontTxt = By.cssSelector("#mobile");           //�ֻ�����
	By submintBtn = By.cssSelector(".certifisub1");    //ȷ���ύ
	
	/**
	 * �����ȷ���ύ����ť
	 * @author ������ 2015-9-7
	 */
	public void clickSubmintBtn(){
		base.clickWithWait(submintBtn);
	}
	
	/**
	 * �޸��ֻ���
	 * @param noChangeTel��ԭ�ֻ���
	 * @param changeTel���޸ĺ��ֻ���
	 * @param payPass��֧������
	 * @author ������ 2015-9-9
	 */
	public void checkChangeTel(String noChangeTel, String changeTel, String payPass){
		String code = "";
		base.clickWithWait(securityAuthPage.changTel);
		base.clickWithWait(securityAuthPage.changeByOldTel);
		do{
			base.clickWithWait(securityAuthPage.msgCodeBtn);
			if(base.isAlertPresent()){
				base.acceptAlert();
				base.sleep(2000);
			}
			else{
				break;
			}
		}while(true);
		base.sleep(2000);
		boolean actualBool = base.isElementContainsValue(securityAuthPage.msgCodeAlert, "style", "none");
		//��֤������֤��ɹ��������Ƿ񵯳�
		base.assertEqualsActualExpectedByBoolean(actualBool, false);
		base.clickWithWait(securityAuthPage.msgOkBtn);
		//��ȡ��֤��
		code = dbData.getPhoneCode(noChangeTel);
		//������֤��
		base.sendKeysWithWait(securityAuthPage.msgCodeTxt, code);
		base.sleep(2000);
		//�����һ����ť
		base.clickWithWait(securityAuthPage.nextBtn);
		base.sleep(1000);
		base.sendKeysWithWait(securityAuthPage.newTeltxt, changeTel);
		base.clickWithWait(securityAuthPage.newMsgCodeBtn);
		code = dbData.getPhoneCode(changeTel);
		base.sendKeysWithWait(securityAuthPage.newMsgCodeTxt, code);
		base.sendKeysWithWait(securityAuthPage.newPayPasTxt, payPass);
		base.clickWithWait(securityAuthPage.newOKBtn);
		base.assertEqualsActualExpected(base.getElementTextWithVisible(securityAuthPage.newTelNum), changeTel);
	}
	
	/**
	 * ��֤��ֵ�״�������֤��������ʾ��Ϣ
	 * @param msgBy ����������ʾ��Ϣ
	 * @param nameCheckmarkImg //������ȷ��ʾͼƬ
	 * @author ������  2015-9-2
	 */
	public void checkNameNoticeInformation(By msgBy, By nameCheckmarkImgBy){
		String [] nameArray = {"һ", "һ�����������߰˾�ʮ��", "һ�����������߰˾�ʮ", "!@#$%", "abcdef", "���� ", " ����", "�� ��", "����123", "����abc", "����!@#"};
		String [] noticeInformationArray = {"��ʵ����������һ��������!", "�޴�����ʾ��Ϣ,����True", "�޴�����ʾ��Ϣ,����True", "��ʵ��������ȫ��Ϊ����!", "��ʵ��������ȫ��Ϊ����!", "��ʵ��������ȫ��Ϊ����!", "��ʵ��������ȫ��Ϊ����!", "��ʵ��������ȫ��Ϊ����!", "��ʵ��������ȫ��Ϊ����!", "��ʵ��������ȫ��Ϊ����!", "��ʵ��������ȫ��Ϊ����!"};
		int arrayLength = nameArray.length;
		for(int i = 0; i < arrayLength; i++){
			//��������
			rechargePage.setInfoByRealName(nameArray[i]);
			//������֤�ı���
			base.clickWithWait(rechargePage.pidcardTxt);
			//��ʾ��ϢУ��
			if(i == 1 || i == 2){
				//��֤�����Թ�ͼƬ���Ƿ���ʾ
				try {
					base.assertTrueByBoolean(base.isElementVisible(nameCheckmarkImgBy));
				} catch (AssertionError e) {
					Reporter.log("�������룺\'" + nameArray[i] + "\' ʱ���Թ�ͼƬδ��ʾ��");
					System.out.println("�������룺\'" + nameArray[i] + "\' ʱ���Թ�ͼƬδ��ʾ��");
				}
				
			}
			else{
				String msg = base.getElementTextWithWait(msgBy);
				//��֤��ʾ��Ϣ
				try {
					base.assertEqualsActualExpected(msg, noticeInformationArray[i]);
				} catch (AssertionError e) {
					String nameMsg = base.getElementTextWithWait(By.cssSelector("#prealnametipMsg"));
					Reporter.log("�������룺\'" + nameArray[i] + "\' ʱ����ʾ��Ϣ��" + nameMsg + " ��Ԥ�ڽ��������Ԥ�ڽ���� " + noticeInformationArray[i]);
					System.out.println("�������룺\'" + nameArray[i] + "\' ʱ����ʾ��Ϣ��" + nameMsg + " ��Ԥ�ڽ��������Ԥ�ڽ���� " + noticeInformationArray[i]);
				}
			}
		}
	}
	
	
	/**
	 * �ҵ��˻�����>�˻���Ϣ������ֵ
	 * @param by�����������֤���ֻ��ţ�����
	 * @param inputString�������ֵ
	 */
	public void setUserInfo(By by, String inputString){
		base.clickWithWait(by);
		base.sendKeysWithWait(by, inputString);
		base.sleep(2000);
	}
	
	/**
	 * �����ֻ�����
	 * @param phoneNum���ֻ���
	 * @author ������ 2015-9-7
	 */
	public void setPhone(String phoneNum){
		base.clickWithWait(phontTxt);
		base.sendKeysWithWait(phontTxt, phoneNum);
		base.sleep(2000);
	}
	
	/**
	 * ��֤������ʾ��Ϣ
	 * @author ������ 2015-9-8
	 */
	public void checkEmailNoticeInformatin(){
		String [] emailArray = {"1@qq.com","1234567890123456789012345678901234@qq.com","123456789012345678901234567890123@qq.com","abc_123@qq.com","!#$%^@qq.com","�������@qq.com","123@126.com"};//f@qq.com
		String [] noticeInformationArray = {"�޴�����ʾ��Ϣ,����True","Email��ַ̫������������Ч��Email��","�޴�����ʾ��Ϣ,����True","�޴�����ʾ��Ϣ,����True","��������Ч��Email��","��������Ч��Email��","�޴�����ʾ��Ϣ,����True"};
		int arrayLength = emailArray.length;
		for(int index = 0; index < arrayLength; index++){
			//��������
			setUserInfo(accountInfoPage.emailTxt, emailArray[index]);
			//������֤�ı���
			base.clickWithWait(rechargePage.pidcardTxt);
			base.sleep(2000);
			if(index == emailArray.length-1){
				setUserInfo(accountInfoPage.realNameTxt, "����ɽһ");
				setUserInfo(accountInfoPage.idCardTxt, "110102194412308661");
				accountInfoPage.clickOkBtn();
				base.sleep(2000);
				base.acceptAlert();
				base.sleep(2000);
				base.assertEqualsActualExpected(base.getTextByAlert(), "�������ַ�ѱ�ʹ�ã�");
				base.acceptAlert();
			}
			else if(index == 1 || index == 4 || index == 5){
				String msg = base.getElementTextWithWait(accountInfoPage.emailMsg);
				//��֤��ʾ��Ϣ
				try {
					base.assertEqualsActualExpected(msg, noticeInformationArray[index]);
				} catch (Exception e) {
					Reporter.log("�������룺\'" + emailArray[index] + "\' ʱ����ʾ��Ϣ��" + msg + " ��Ԥ�ڽ��������Ԥ�ڽ���� " + noticeInformationArray[index]);
					System.out.println("�������룺\'" + emailArray[index] + "\' ʱ����ʾ��Ϣ��" + msg + " ��Ԥ�ڽ��������Ԥ�ڽ���� " + noticeInformationArray[index]);
				}//System.out.println("��ʾ��Ϣ��" + base.getElementTextWithWait(rechargePage.nameMsg) + " Ԥ�ڽ���� " + noticeInfomationArray[i]);//--------����
			}
			else{
				//��֤�����Թ�ͼƬ���Ƿ���ʾ
				try {
					base.assertEqualsActualExpectedByBoolean(base.isElementPresent(accountInfoPage.emailCheckmarkImg), true);
				} catch (AssertionError e) {
					Reporter.log("�������룺\'" + emailArray[index] + "\' ʱ���Թ�ͼƬδ��ʾ��");
					System.out.println("�������룺\'" + emailArray[index] + "\' ʱ���Թ�ͼƬδ��ʾ��");
				}//System.out.println("��ʾ��Ϣ�Ƿ���ڣ�" + !base.isNone(rechargePage.nameMsg));//--------����
			}
			base.sleep(3000);
		}
	}
	
	/**
	 * ��֤�ֻ�����ʾ��Ϣ
	 * @author ������ 2015-9-7
	 */
	public void checkPhoneNoticeInformation(){
		String msg = "";
		String [] phoneArray = {"1358156770","13581568800","!@#$)(*&^%%","������������","00886518531","53658818001","","����������������������","13581567702"};
		String [] noticeInformationArray = {"��������ֻ���������!","���ֻ����Ѿ���ʹ�ã�","��������ֻ���������!","��������ֻ���������!","��������ֻ���������!","��������ֻ���������!","�ֻ����벻��Ϊ��!","��������ֻ���������!","��������ֻ���֤���������"};
		int arrayLength = phoneArray.length;
		for(int index = 0; index < arrayLength; index++){
			setPhone(phoneArray[index]);
			base.sleep(1000);
			clickSubmintBtn();
			base.sleep(2000);
			msg = base.getElementTextWithWait(By.cssSelector("#stepnote"));
			base.assertEqualsActualExpected(msg, noticeInformationArray[index]);
		}
	}
	
	/**
	 * ɾ���ֻ�ע��ļ�¼��ʹ���Ϊֻ������ע����˻��������˻���
	 * @param email:�û�����
	 * @author ������ 2015-9-7
	 */
	public void deletePhoneRegeditRecords(String email){
		String uid = dbData.getUID(email);
		boolean isTrue = dbData.deletePhoneRegeditRecords(uid);
		base.assertEqualsActualExpectedByBoolean(isTrue, true);
	}
	
	/**
	 * ��֤��ֵ�״������֤�����֤����ʾ��Ϣ
	 * @author ������  2015-7-21
	 */
	public void checkIdCardNoticeInformation(){
		String [] idCardArray = {"11010519850423007X", "11010519850423007x", "110105198504230", "110105198504230071", "������������������������������������", "!!!!!!!!!!!!!!!!!!", "11010519850423007X1", "11010519850423007x1", "abcdabcdabcdabcdcd"};
		String [] noticeInformationArray = {"�޴�����ʾ��Ϣ,����True", "�޴�����ʾ��Ϣ,����True", "���֤��������,����!", "���֤��������,����!", "���֤��������,����!", "���֤��������,����!", "���֤��������,����!", "���֤��������,����!", "���֤��������,����!"};
		int arrayLength = idCardArray.length;
		for(int i = 0; i < arrayLength; i++){
			//������ݺ�
			rechargePage.setInfoByIdCard(idCardArray[i]);
			//��������ı���
			do{
				base.clickWithWait(rechargePage.prealnameTxt);
				base.sleep(2000);//System.out.println("������ʾ��Ϣ�Ƿ���ʾ�� " + base.isElementPresent(By.cssSelector("#prealnametipMsg >span")));//--------����
			}while(!base.isElementPresent(By.cssSelector("#prealnametipMsg >span")));
			//��ʾ��ϢУ��
			if(i == 0 || i == 1){
				//��֤��ʾ��Ϣ���Ƿ���ʾ
				base.assertEqualsActualExpectedByBoolean(base.isNone(rechargePage.idMsg), true);//System.out.println("��ʾ��Ϣ�Ƿ���ڣ�" + !base.isNone(rechargePage.idMsg));//--------����
			}
			else{
				//��֤��ʾ��Ϣ
				base.assertEqualsActualExpected(base.getElementTextWithWait(rechargePage.idMsg), noticeInformationArray[i]);//System.out.println("��ʾ��Ϣ��" + base.getElementTextWithWait(rechargePage.idMsg) + " Ԥ�ڽ���� " + noticeInfomationArray[i]);//--------����
			}
			base.sleep(2000);
		}
	}
	
	/**
	 * ��֤��ֵ�״������֤��֧��������ʾ��Ϣ
	 * ��ע��ִ��ʱ�����ƶ����
	 * @author ������  2015-7-21
	 */
	public void checkPayPasswordNoticeInformation(){
		String [] payPasswordArray = {"12345", "12345678901234567", "123456", "ABCabc", "!@#$%^", "Abc!123", "������������", "   "};
		String [] noticeInformationArray = {"֧�����벻����Ҫ��������6-16���ַ�", "֧�����벻����Ҫ��������6-16���ַ�", "", "", "", "", "", "֧�����벻����Ҫ��������6-16���ַ�"};
		int arrayLength = payPasswordArray.length;
		//������Ƿ�Ϊ�ա�true����,false���ǿ�
		boolean isEmpty = true;
		for(int i = 0; i < arrayLength; i++){System.out.println(payPasswordArray[i]);
			//��6��������ͨ������ճ��ʵ�ֵ�
			if(i != 6){
				//����֧������
				rechargePage.setInfoByPayPassword(payPasswordArray[i], isEmpty);
				//��������ı���
				rechargePage.clickInfoByRealName();
				//��ʾ��ϢУ��
				if(i == 0 || i == 1 || i == 7){
					//��֤��ʾ��Ϣ
					base.assertEqualsActualExpected(base.getElementTextWithWait(rechargePage.payMsg), noticeInformationArray[i]);
				}
				else{
					//��֤��ʾ��Ϣ���Ƿ���ʾ
					base.assertEqualsActualExpectedByBoolean(base.isNone(rechargePage.payMsg), true);
				}
				base.sleep(2000);
				isEmpty = false;
			}
			else{
				Robot robot = null;
				try {
					robot = new Robot();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//������������ı���
				rechargePage.clickInfoByRealName();
				
				//ȫѡ��������
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				//���ơ�������
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				//����֧������
				rechargePage.clickInfoByPayPassword();
				
				//ճ������
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				//��֤��ʾ��Ϣ���Ƿ���ʾ
				base.assertEqualsActualExpectedByBoolean(base.isNone(rechargePage.payMsg), true);
				base.sleep(2000);
				isEmpty = false;
			}
		}
	}
	
	/**
	 * xty
	 * �ѹ�������˻����Աߵġ�С�ˡ������֡�ȥ��֤�����ӣ������ȥ��֤��
	 */
	public void clickAuthentication(){
		base.mouseToElement(By.cssSelector("#icon-h-2"));
		base.clickWithWait(By.cssSelector("#icon-h-2 .userrz-tip-c>i"));
	}
	
	/**
	 * ����Ԫ
	 * ���������ֻ��Ŵ��������ŵ��ֻ��Ŵ�������������ʾ�����������ӣ���ֵ�����֡�Ͷ��
	 * type 1:��ֵ  2������   3��Ͷ��
	 */
	public void mouseToTel(String type){
		base.mouseToElement(By.cssSelector("#accountRealName>a"));
		base.clickWithWait(By.xpath("//p[@class='a_n_o clear']/a["+type+"]"));
	}
	
}
