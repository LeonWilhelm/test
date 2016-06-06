package com.eloancn.shared.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eloancn.shared.common.Base;
/*
 * ���Ǽƻ��������ҳ
 */
public class EStarPlanLoanDetailPage {

	Base base = new Base();
	
	public static By LoanInfoonTop = By.className("ld_leftpart");						//�����ϲ���Ϣ
	public static By BidFullTime = By.xpath("//p[@class='ld_status_list0 ml15 pdt5']/span[2]");		//����������ʱ��
	public static By Photo = By.cssSelector("img[alt='������ϴ�ͷ��']");					//�����ͷ��	
	public static By UserName = By.cssSelector("div.ld_user.fl>p>a");					//�û���
	public static By UserInfoBelowPhoto = By.cssSelector("div.ld_user.fl>p");			//������������
	public static By BorrowTypeAndTitleTxt = By.cssSelector("h2.mt10");					//ͷ���ԱߵĽ�����ͺ�Ŀ��
	By BorrowTxt = By.cssSelector("div.ld_info.fl>ul>li"); 								//�������ʣ����޵���Ϣ
	public static By BorrowMoney = By.cssSelector("span.font22.colorE6");						//�����:10,000
	public static By Rate = By.xpath("//div[2]/ul/li[2]/span");								//����:10.10
	public static By Phase = By.cssSelector("li.wd180 > span.font22.colorE6");					//����:3
	By RepayModeImg = By.cssSelector("li.wd180 > img");									//�����ʽ��ͼ��
	By RepayTipTxt = By.id("ui-tooltip-0-content");										//�����ʽ��ͼ���µ�tip
	By RepayDetailLnk = By.cssSelector("li.clear.wd270 > a");							//����ƻ�����������
	public static By QYBasicInfoTxt = By.cssSelector("#record0>h4.record-title");		//����ҵ������Ϣ��
	By ReferrerNameLnk = By.xpath("//div[@id='record2']/table/tbody/tr/td/a");			//"ծȨ�Ƽ�������"����
	
	//�����Ļ���ƻ�����ҳ
	By CheckRepayPlanTitle = By.xpath("//div[@id='showRepayPlan']/div[2]/div/span");	//���鿴����ƻ�������
	By subRepayTitle = By.cssSelector("#showRepayPlan>div.c>div.cont>table>thead>tr>th");//��š�Ӧ����ʱ�䡢Ӧ����Ϣ��Ӧ������Ӧ����Ϣ
	By closeRepalyPlan = By.xpath("//div[@id='showRepayPlan']/div[2]/div/a");			//�ر�
	
	//��顰��δ�����Ľ�-����������ҳ���ı���Ϣ
	public void checkBidInfo(int num){
		
		try{
			base.assertEqualsActualExpected(base.getElementTextWithWait(BorrowTypeAndTitleTxt), "��������ת�� �Զ�������ʹ��");
			String BorrowInfo[] = null;
			if(base.indexURL.contains("client") || base.indexURL.contains("inclient")){
				BorrowInfo = new String[]{"����10,000Ԫ","���ʣ�10.30%/��","���ޣ�3����","���õȼ���C","�����ȣ�\n0%","���ʽ����Ϣ��","����ƻ�������"};
			}else if(base.indexURL.contains("test") || base.indexURL.contains("www")){
				BorrowInfo = new String[]{"����10,000Ԫ","���ʣ�10.30%/��","���ޣ�3����","���õȼ���C","�����ȣ�\n0%","���ʽ����Ϣ��","����ƻ�������"};
			}
			List<WebElement> BorrowInfos = base.getElements(BorrowTxt);
			for(int i=0;i<7;i++){
				base.assertEqualsActualExpected(BorrowInfos.get(i).getText(), BorrowInfo[i]);
			}
			checkRepayModeImg();
			clickRepayDetailLnk();
			checkReplayPlan();
			if(num == 2){
				base.closeAndjumptoOldWindow();
			}
		}catch(Exception e){
			if(num == 2){
				base.closeAndjumptoOldWindow();
			}
			Assert.fail(e.toString());
		}
		catch(AssertionError e){
			if(num == 2)    base.closeAndjumptoOldWindow();
			Assert.fail(e.toString());
		}
	}
	//��顰���ʽ������ġ�����ͼ��
	public void checkRepayModeImg(){
		base.mouseToElement(RepayModeImg);
		base.checkElementVisible(RepayTipTxt);
		base.assertEqualsActualExpected(base.getElementText(RepayTipTxt), "��Ϣ�󱾣���ָ�ڻ������ڣ�ÿ�³����涨��ȵ���Ϣ�����һ���³���������Ϣ�����б���");
	}
	//���������ƻ������顱����
	public void clickRepayDetailLnk(){
		base.clickWithWait(RepayDetailLnk);
		base.checkElementVisible(CheckRepayPlanTitle);
	}
	//��顰�鿴����ƻ�"�����еĻ���ƻ�
	public void checkReplayPlan(){
		
		double benJin = 10000;	//����
		double liLv = 0.103;	//����
		double lixiOfDay;		//��һ�ڰ��������Ϣ
		double lixiOfMonth;		//����Ϣ
		int daysOfYear;			//��������
		int daysOfMotnth;		//����µļ���
		int chaday = 0;
		int qishu;
		
		String [] subs = {"���","Ӧ����ʱ��","Ӧ����Ϣ","Ӧ������","Ӧ����Ϣ"};	
		List<WebElement> subtitles = base.getElements(subRepayTitle);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM"); 
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		daysOfYear = base.getDaysOfYear(cal.get(Calendar.YEAR));
		daysOfMotnth = cal.get(Calendar.DAY_OF_MONTH); 		//����µļ���
		String currentDay = d.format(cal.getTime());		//����ʱ�䣺2015-09-16
		String currentDate = date.format(cal.getTime());	//����ʱ�䣺2015-09
		cal.add(Calendar.MONTH, 1);
		String nextDate= date.format(cal.getTime());		//�¸���ʱ�䣺2015-10		
		cal.add(Calendar.MONTH, 1);
		String next2Date = date.format(cal.getTime());		//���¸��£�2015-11	
		cal.add(Calendar.MONTH, 1);
		String next3Date = date.format(cal.getTime());		//�����¸��£�2015-12		
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String next4Date = d.format(cal.getTime());			//�����¸��µ�ǰһ�죺2015-12-15	
		 
		if(1 <= daysOfMotnth && daysOfMotnth < 21){
			chaday= base.daysBetween(currentDay, currentDate + "-20")+1;
		}
		else if(21 < daysOfMotnth && daysOfMotnth <= 31){
			chaday= base.daysBetween(currentDay,nextDate + "-20")+1;
		}
		
		lixiOfDay = benJin * liLv / daysOfYear * chaday;
		lixiOfMonth = benJin * liLv / 12;				
		lixiOfMonth = base.setRound(lixiOfMonth, 2, true);  
		lixiOfDay = base.setRound(lixiOfDay, 2, true);
		String interest = base.intMoney(lixiOfDay);
		String lastInterest = base.intMoney(lixiOfMonth - lixiOfDay);
		String benxi = base.intMoney(benJin + lixiOfMonth -lixiOfDay);
		
		String [][] Plan =		 {{"1", currentDate + "-20",	interest+"Ԫ",	"0Ԫ",		interest+"Ԫ"},
								  {"2", nextDate + "-20",	 	"85.83Ԫ",		"0Ԫ",		"85.83Ԫ"},
								  {"3", next2Date + "-20",		"85.83Ԫ",		"0Ԫ",		"85.83Ԫ"},
								  {"4", next4Date,		 		benxi+"Ԫ",		"10,000Ԫ",	lastInterest+"Ԫ"}};
			
		String [][] RepayPlans = {{"1", nextDate + "-20",		"85.83Ԫ",		"0Ԫ",		"85.83Ԫ"},
								  {"1", next2Date + "-20",		"85.83Ԫ",		"0Ԫ",		"85.83Ԫ"},
								  {"1", next3Date + "-20",		"1,0084.17Ԫ",	"10,000Ԫ",	"85.83Ԫ"}};
		
		String [][] details = 	 {{"1", nextDate + "-20",		interest+"Ԫ",	"0Ԫ",		interest+"Ԫ"},
							   	  {"2", next2Date + "-20",	    "85.83Ԫ",		"0Ԫ",		"85.83Ԫ"},
							      {"3", next3Date + "-20",	 	"85.83Ԫ",		"0Ԫ",		"85.83Ԫ"},
							      {"4", next4Date,			  	benxi+"Ԫ",		"10,000Ԫ",	lastInterest+"Ԫ"}};
		
		String [][] Plans;
		if(1 <= daysOfMotnth && daysOfMotnth < 21){
			qishu = 4;
			Plans = Plan;
		}else if(daysOfMotnth == 21){
			qishu = 3;
			Plans = RepayPlans;
		}else{
			qishu = 4;
			Plans = details;
		}
		for(int i = 1; i <= 5; i++){
			for(int j = 1; j <= qishu; j++){
				base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='showRepayPlan']/div[2]/div[2]/table/tbody/tr["+j+"]/td["+i+"]")), Plans[j-1][i-1]);
			}
			base.assertEqualsActualExpected(subtitles.get(i-1).getText(), subs[i-1]);
		}
	}
	//����رա��鿴����ƻ�"����
	public void clickcloseRepalyPlan(){
		base.clickWithWait(closeRepalyPlan);
		base.checkNoElement(closeRepalyPlan);
	}
	//��顰�ҵĽ���ƻ���-����������ҳ���е��û�ͷ������������
	public void checkUserInfo(String photo,String userName,String userAge,int i){
		try{
			String Photo1 = base.getLnkElementText(Photo, "src");
			String UserName1 = base.getElementTextWithWait(UserName);
			String UserInfo = base.getElementTextWithWait(UserInfoBelowPhoto);
			int EndPosition = UserInfo.lastIndexOf("]");
			String UserAge1 = UserInfo.substring(EndPosition+1).trim();
			
			userName = userName.replaceFirst(userName.substring(0, 1), "*");
			base.assertEqualsActualExpected(Photo1, photo);
			base.assertEqualsActualExpected(UserName1, userName);
			base.assertEqualsActualExpected(UserAge1, userAge+"��");
			if(i==1){
				base.closeWebDriver();
			}
		}catch(Exception e){
			if(i==1)	base.closeWebDriver();
			e.printStackTrace();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			if(i==1)	base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//��������ͷ��
	public void clickUserPhoto(){
		
	}
	//����Ƿ������Ǽƻ�������ϸҳ��
	public boolean ifinLoanDetailPage(){
		return base.isElementPresent(LoanInfoonTop);
	}
	//��顰��ҵ������Ϣ��
	public void checkQiYeBasicInfo(int num){
		
		try{
			base.assertEqualsActualExpected(base.getElementTextWithWait(QYBasicInfoTxt), "��ҵ������Ϣ");
			String [][] Info = {{"����:","��������","����ʱ��:","2015��08��"},{"��ַ:","���������йش�","ע���ʱ�:","1,000,000Ԫ(ʵ��1,000,000Ԫ)"},
					{"��Ӫ��Χ:","Ŀǰ��ҪͶ�ʺ;�Ӫ�Ĳ�ҵ�У����С�֤ȯ�Ƚ��ڲ�ҵ���ִ�ũҵ���ۿڽ�ͨ��ҵ����Ϣ��ҵ"},{"�����;:","��Ҫ���ڻ����"},{"��Ӫ���:","�ӹ�˾��������Ͷ�ʵĴ󲿷ֹ�˾���Ѿ����˽ϸߵ�ӯ���ر�����չ����"}};
			for(int i=0;i<5;i++){
				for(int j =0;j<Info[i].length;j++){
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='record0']/table/tbody/tr["+(i+1)+"]/td["+(j+1)+"]")), Info[i][j]);
				}
			}
			if(num == 2){
				base.closeWebDriver();
			}
		}catch(Exception e){
			if(num == 2){
				base.closeWebDriver();
			}
			e.printStackTrace();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			if(num == 2)	base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//��顰��ҵ������Ϣ��
	public void checkQiYeOtherInfo(int num){
		try{
			String [] subtitle = {"������Դ","ծȨ�Ƽ���","������ʩ/���"};
			String [][] Info = {{"��Ҫ�Ǵ��ڶ��Ͷ�ʹ�˾��ӯ�����������������Ǵ������ط�������"},{"�����������޹�˾","�����������޹�˾��һ�Ҵ��͵�Ͷ�ʹ�˾������һ��������ҵ��������2003��"},
					{"���ϴ�ʩ��","�������粻�����ڳ������б����������޹�˾�����г������б����������޹�˾������","��������ʩ��","�������������������޹�˾�����������޹�˾�����������޹�˾�����������޹�˾","���������","�����������Ϊֻ�����ڻ�����������������˾��ȫ���������������"}};
			for(int i=1;i<=3;i++){
				for(int j=1;j<=Info[i-1].length;j++){
					base.assertEqualsActualExpected(base.getElementTextWithWait(By.xpath("//div[@id='record"+i+"']/table/tbody/tr["+j+"]/td")), Info[i-1][j-1]);
					if(i==2 && j==1){			
						clickReferrerName();
					}
				}
				base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#record"+i+">h4.record-title")), subtitle[i-1]);	
			}
			if(num == 2){
				base.closeWebDriver();
			}
		}catch(Exception e){
			if(num == 2){
				base.closeWebDriver();
			}
			Assert.fail(e.toString());
		}catch(AssertionError e){
			if(num == 2) 	base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//�����ծȨ�Ƽ��ˡ�����
	public void clickReferrerName(){
		base.clickWithWait(ReferrerNameLnk);
		base.jumpToNewWindow();
		base.checkTitle("�Ƽ�������");
		if(base.indexURL.contains("client")||base.indexURL.contains("inclient")){
			base.assertEqualsActualExpected(base.getElementTextWithWait(CreditReferrerDetailPage.ReferrerName), "�Զ�������");
		}else if(base.indexURL.contains("test")||base.indexURL.contains("www")){
			base.assertEqualsActualExpected(base.getElementTextWithWait(CreditReferrerDetailPage.ReferrerName), "�ӱ����𵣱����޹�˾");
		}	
		base.closeAndjumptoOldWindow();
	}
}
