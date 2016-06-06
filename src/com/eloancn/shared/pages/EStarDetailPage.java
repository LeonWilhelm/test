package com.eloancn.shared.pages;

import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
/*
 * ���Ǽƻ�����ҳ
 */
public class EStarDetailPage {
	Base base = new Base();
	IndexPage indexPage = new IndexPage();
	
	public static By DetailPart = By.cssSelector("div.wtplan_box_detail.mt25");							//�ϲ����Ǽƻ���Ϣ
	
	//���״̬ͼ��ʾ
	By LeftIcon = By.cssSelector(".wtplan_box_detail.mt25>div"); 										//���״̬ͼ
	public By compluteIcon = By.cssSelector("div.wtplan_box_left.complute");							//��������״̬ͼ
	public By endIcon = By.cssSelector("div.wtplan_box_left.end");										//�ѽ�����״̬ͼ
	public By goingIcon = By.cssSelector("div.wtplan_box_left.going");									//�����е�״̬ͼ
	By InvestorNum = By.xpath("//div[15]/div/div/div/p/span");											//���ͼƬ��Ͷ������
	By PlanMoney = By.xpath("//p[3]/span");																//���ͼƬ�С��ƻ��ܶ
	
	//�Ҳౣ���ǡ������ǡ���������ʾ
	public static By EStarTitleinDetail = By.cssSelector("div.wtplan_box_right.pdb25>div>h1");			//���Ǽƻ�����ҳ�ı���
	By OpenSoonTxt = By.cssSelector("span.wtplan_box_left.going");										//���Ͻǵġ��������š�
	By FastInvestLnk = By.xpath("//a[text()='����Ͷ��']");													//������Ͷ�ʡ�����
	public static By InvestNowLnk = By.cssSelector("a.wtplan_td6.wtplan_line_btn.go");					//��Ч�ġ�����Ͷ�ʡ�����
	By CloseLoginLnk = By.cssSelector("div.tit>a.close");												//�رա���¼����ť
	By LoginBackground = By.cssSelector("div.loginBg");													//��¼���ں�ı�����ʾ
	public static By Background = By.cssSelector(".wtplan_blackbg");//div.wtplan_blackbg				//����Ͷ�ʴ��ں�ı�����ʾ
	public static By BZStarInvestNowLnk = By.xpath("//body/div[15]/div/div[2]/div[2]/div/div[6]/a");	//�����ǡ�����Ͷ�ʡ�����
	By DetailTxt = By.cssSelector(".wtplan_detail_c");//div.wtplan_detail_c								//�����ǻ������ǡ�������ܡ��µ���ʾ����
	By BZStarInfo = By.xpath("//div[@class='wtplan_box_right pdb25']/div[2]/div/div");				//��������Ŀ��Ϣ��ļ�������ʡ�������ޡ����㷽ʽ��
	By BZStarMoney = By.xpath("//div[2]/div[2]/div/div[2]");											//�����Ǽƻ�Ͷ�ʽ��
	By BZStarInvestRate = By.id("wutInter1");															//����������
	By BZStarDetailLnk = By.xpath("//div[@class='wtplan_box_right pdb25']/div[2]/div[2]");				//�����ǡ�������ܡ�����
	By BZStarDetailPart = By.xpath("//div[@class='wtplan_box_right pdb25']/div[2]/div[4]");				//�����ǡ�������ܡ��µ���ʾ����
	By BZStarIntroTxt = By.cssSelector("div.wtplan_detail_l");											//���������ֽ���:"��Ϣ���� ����� ���ر���"
	By PITxt = By.cssSelector("div.wtplan_detail_l>p");													//���������ֽ���:"��Ϣ���� ����� ���ر���"
	By BZStarSaleTimeTxt = By.cssSelector("table.ratetable>tbody>tr>td");								//�����ǿ���ʱ�䣺��2015-09-09���ۡ�
	By BZStarjoinmemberTxt = By.xpath("//div[4]/div[2]/table/tbody/tr/td[2]");							//�������Ѽ��� �˴Σ�ʣ���Ͷ�ʽ� ��Ԫ
	By BZStarInvestorNum = By.cssSelector("table.ratetable>tbody>tr>td>span.colorfb");					//�������Ѽ����˴�����
	public static By SYStarInvestNowLnk= By.xpath("//div[@class='wtplan_box_right pdb25']/div[3]/div/div[6]/a");//�����ǡ�����Ͷ�ʡ�����
	By SYStarInfo = By.xpath("//div[@class='wtplan_box_right pdb25']/div[3]/div/div");					//��������Ŀ��Ϣ��ļ�������ʡ�������ޡ����㷽ʽ��
	By SYStarMoney = By.xpath("//div[3]/div/div[2]");													//�����Ǽƻ�Ͷ�ʽ��
	By SYStarInvestRate = By.id("wutInter2");															//����������
	By SYStarDetailLnk = By.xpath("//div[@class='wtplan_box_right pdb25']/div[3]/div[2]");				//�����ǡ�������ܡ�����
	By SYStarDetailPart = By.xpath("//div[@class='wtplan_box_right pdb25']/div[3]/div[4]");				//�����ǡ�������ܡ��µ���ʾ����
	By SYStarIntroTxt = By.xpath("//div[@class='wtplan_box_right pdb25']/div[3]/div[4]/div");			//���������ֽ���:"��Ϣ���� ����� ���ر���"
	By SYStarSaleTimeTxt = By.xpath("//div[3]/div[4]/div[2]/table/tbody/tr/td");						//�����ǿ���ʱ�䣺��2015-09-09���ۡ�
	By SYStarjoinmemberTxt = By.xpath("//div[3]/div[4]/div[2]/table/tbody/tr/td[2]");					//�������Ѽ��� �˴Σ�ʣ���Ͷ�ʽ� ��Ԫ
	By SYStarInvestorNum = By.xpath("//div[3]/div[4]/div[2]/table/tbody/tr/td[2]/span");				//�������Ѽ����˴�����
	By ZRStarMoney = By.xpath("//div[2]/div[4]/div/div[2]");											//�����Ǽƻ�Ͷ�ʽ��
	
	//��ϸ����ծȨ�Ƽ��ˡ�ծȨ���ɡ�Ͷ�ʼ�¼��Ͷ������
	By FiveLnks = By.cssSelector("div.wtplandetail_record_t>ul>li");									//����ϸ����ծȨ�Ƽ��ˡ�ծȨ���ɡ�Ͷ�ʼ�¼��Ͷ�����ۡ� ����
	By DetailedRulesLnk = By.xpath("//div[2]/div/ul/li");												//����ϸ��������
	By RulesLine = By.cssSelector("table.wtplan_ruletable>tbody>tr");									//��ϸ�����һ�л�����
	By RuleNames = By.xpath("//table[@class='wtplan_ruletable']/tbody/*/th");							//��ϸ�����еĸ�����
	By RuleDetails = By.xpath("//table[@class='wtplan_ruletable']/tbody/*/td");							//��ϸ�����еľ���ʱ�������ȵ�˵��
	By ReferrerLnk = By.xpath("//div[@class='wtplandetail_record_t']/ul/li[2]");						//"ծȨ�Ƽ���"����
	public static By ReferrerAddressLnk = By.cssSelector("#wut>div>table>tbody>tr>td>a");				//"ծȨ�Ƽ���"-��������˾���ơ�����
	By InvestRecordLnk = By.xpath("//div[2]/div/ul/li[4]");												//��Ͷ�ʼ�¼������
	By RecordSubtile = By.cssSelector("#wut>div.financial_hot_list>table>thead");						//Ͷ�ʼ�¼�еĸ�����
	By InvestorNumTxt = By.cssSelector("span.colorF0");													//Ͷ�ʼ�¼�е�"Ͷ������"����
	By LastOnePage = By.xpath("//div[@id='Pagination']/ul/li[text()='>']");								//ĩҳ��ǰһ������
	By CurrentPage = By.cssSelector("li.page-number.pgCurrent");										//Ŀǰҳ
	By SecondLnk = By.xpath("//div[@id='Pagination']/ul/li[2]");
	By SixPageLnk = By.xpath("//div[@id='Pagination']/ul/li[6]");										//ҳ���ĵ�6������
	By LastPage = By.xpath("//div[@id='Pagination']/ul/li[text()='ĩҳ']");								//ĩҳ
	By LastTwoPage = By.xpath("//div[@id='Pagination']/ul/li[last()-2]");								//ĩҳ��ǰ��������
	By EmptyPage = By.cssSelector("li.pgNext.pgEmpty");
	By InvestorLines = By.cssSelector("#wut>div.financial_hot_list>table>tbody>tr");					//Ͷ�ʼ�¼�б������
	By InvestorTxt = By.xpath("//div[@id='wut']/div/table/tbody/*/td");									//Ͷ������ʾ
	By InvestRateTxt = By.xpath("//div[@id='wut']/div/table/tbody/*/td[3]");							//Ͷ���˵�Ͷ��������ʾ
	By InvestMoneyTxt = By.xpath("//div[@id='wut']/div/table/tbody/*/td[2]");							//Ͷ���˵�Ͷ�ʽ����ʾ
	By LastInvestTime = By.xpath("//div[@id='wut']/div/table/tbody/tr[last()]/td[4]");
	By InvestCommentLnk = By.xpath("//div[2]/div/ul/li[5]");											//��Ͷ�����ۡ�����
	By CommentTxt = By.cssSelector("div.to_say>p.font18");												//����ծȨ�Ƽ��˽������۰ɡ��ı�
	By InputComment = By.id("content");																	//���۵������
	By SubmitBtn = By.cssSelector("a.to_comment");														//���ύ�����۰�ť
	By SubmittedContent = By.cssSelector("div.qa_content>p.mt5");										//�ύ�����������
	By SubmittedTime = By.cssSelector("div.qa_content>p.mt5>span");
	By RegisterAndLoginLnk = By.xpath("//div[@id='newsReviewList']/div/p[2]");							//ע���Ϊ��Ա�󷽿ɻظ�  ע��|��¼
	By Img = By.cssSelector("div.comperson>div.pic");											

	//������Ͷ�ʴ���
	public static By BZStarInvestTitle = By.cssSelector("#wtplan_alert1 > div.wtplan_alert_t");			//��Ͷ����Ϣ��������
	By BZStarNeedAmountTxt = By.id("needAmount1");														//�������ȡ��Ľ��
	By BZStarBalanceTxt = By.id("userBalance1");														//���������Ľ��
	By InputAmount = By.id("wutBuyAmount1");															//��������������
	By AutoInputLnk = By.cssSelector("#wtplan_alert1>div>table>tbody>tr>td>a.hui");						//���Զ����롱����
	By InputBZStarPayPwd = By.id("payPwd1");															//��֧�����롱�����
	By InputBZStarValidateCode = By.id("wutRandCode1");													//����֤�롱�����
	By yanZhengMaImg = By.cssSelector("#checkverificationCode_fast > a > img");							//����֤�롱ͼƬ
	By BZStarAgreeCheckbox = By.id("xy1");																//�������Ķ���ͬ�⡶������Ͷ���ˡ��������ĸ�ѡ��
	By BZStarOkBtn = By.cssSelector("#wtplan_alert1>div>p>input.wtplan_quedingbtn.ml15");				//��ȷ����Ͷ�ʰ�ť
	By BZStarCancelBtn = By.cssSelector("#wtplan_alert1>div>p>input.wtplan_quxiaobtn");					//��ȡ����Ͷ�ʰ�ť
	By InvestSuccessTxt = By.cssSelector("div.msg_ico.success_ico");									//��Ͷ�ʳɹ����ı���ʾ
	By CloseInvestSuccessLnk = By.cssSelector("#wtplan_alert4>div>a.wtplan_close_x");					//Ͷ�ʳɹ����ڡ��رա�����
	By IndividualViewLnk = By.id("tzSuccess");															//�����������Ĳ鿴������
	By MonthPlanTxt = By.id("monthBack");																//�ҵ��˻�-�ҵ�Ͷ�ʼƻ�-����Ӧ�յļƻ�

	//������Ͷ�ʴ���
	public static By SYStarRiskTitle = By.cssSelector("#wtplan_alert3 > div.wtplan_alert_t");			//��������ʾ��������
	By SYStarInvestTitle = By.cssSelector("#wtplan_alert2>div.wtplan_alert_t");							//��Ͷ����Ϣ��������
	By DenyBtn = By.xpath("//input[@value='�ܾ�']");														//���ܾ�����ť
	By AgreeBtn = By.xpath("//input[@value='ͬ��']");														//��ͬ�⡱��ť
	By CloseSYStarInvestBoxLnk = By.cssSelector("#wtplan_alert2>div>a.wtplan_close_x");					//Ͷ�ʴ��ڡ��رա�����
	By SYStarNeedAmountTxt = By.id("needAmount2");														//�������ȡ��Ľ��
	By SYStarBalanceTxt = By.id("userBalance2");														//���������Ľ��
	By InputSYStarAmount = By.id("wutBuyAmount2");														//��������������
	By AutoInputSYStarLnk = By.xpath("//a[contains(text(),'�Զ�����')]");									//���Զ����롱����
	By InputSYStarPayPwd = By.id("payPwd2");															//��֧�����롱�����
	By InputSYStarValidateCode = By.id("wutRandCode2");													//����֤�롱�����
	By SYStarAgreeCheckbox = By.id("xy2");																//�������Ķ���ͬ�⡶���Э�顷�����ϡ��������ĸ�ѡ��
	By SYStarOkBtn = By.xpath("//input[@value='ȷ��']");													//��ȷ����Ͷ�ʰ�ť
	By SYStarCancelBtn = By.xpath("//input[@value='ȡ��']");												//��ȡ����Ͷ�ʰ�ť
	
	//����Ƿ������Ǽƻ�����ҳ
	public boolean ifinDetailPage(){
		return base.isElementPresent(DetailPart);
	}
	//������Ǽƻ�����ҳ
	public void verifyEStarDetail(){
		try{
			base.checkElement(LeftIcon);
			clickBZStarDetailLnk();
			clickSYStarDetailLnk();
	//		base.checkNoElement(DetailTxt);
			base.checkElmentText(DetailTxt, "");
			List<WebElement> FiveLnk = base.getElements(FiveLnks);
			String [] LnkTxts = {"��ϸ����","ծȨ�Ƽ���","ծȨ����","Ͷ�ʼ�¼","Ͷ������"};
			for(int i = 0; i < FiveLnk.size(); i++){
				base.assertEqualsActualExpected(FiveLnk.get(i).getText(), LnkTxts[i]);
			}	
			base.closeAndjumptoOldWindow();
		}catch(Exception e){
			base.closeAndjumptoOldWindow();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//���Ͷ���˴Ρ��ƻ��ܶ�ʲ���������ʾ
	public void checkInvestInfo(String planmoney){
		
//		try{
		String totalNum = base.getElementTextWithWait(InvestorNum);//ͼƬ���˴���ʾ
		String BZNum = base.getElementTextWithWait(BZStarInvestorNum);//����������������˴�
		String SYNum = base.getElementTextWithWait(SYStarInvestorNum);//����������������˴�
		clickCreditReferrerLnk();
		String referrerName = base.getElementTextWithWait(ReferrerAddressLnk);
		if(referrerName.contains("...")){
			referrerName=referrerName.substring(0,referrerName.length()-3);
		}				
		clickInvestRecordLnk();
		String NumTxt = base.getElementTextWithWait(InvestorNumTxt);//��¼����ʾ��Ͷ������
		int referrernum = 0,size =getRecordNum();//��ȡ��¼������������ת�����һҳ
		for(int j=0;j<=1;j++){
			List<WebElement> lastpage = base.getElements(InvestorTxt);
			int lastpagenum=lastpage.size();
			for(int i=0;i<lastpagenum;i++){
				if(lastpage.get(i).getText().contains(referrerName)){
					referrernum=referrernum+1;//Ͷ���������˴�
				}
			}
			String current = base.getElementTextWithWait(CurrentPage);
			base.clickWithWait(SecondLnk);
			base.sleep(2000);
			if(base.getElementTextWithWait(CurrentPage).equals(current)){//���ֻ��һҳ�˳�����������ǰһҳ���������Ͷ��
				break;
			}		
		}	
		base.assertTrueByBoolean(NumTxt.equals(totalNum) && size==(Integer.parseInt(BZNum)+Integer.parseInt(SYNum)+referrernum));
		String PlanMoneys = base.getElementTextWithWait(PlanMoney);
		String BZMoney = base.getElementTextWithWait(BZStarMoney);//210��Ԫ
		String SYMoney = base.getElementTextWithWait(SYStarMoney);
		String ZRMoney = base.getElementTextWithWait(ZRStarMoney);
		BZMoney = BZMoney.substring(0, BZMoney.length()-2);
		SYMoney = SYMoney.substring(0, SYMoney.length()-2);
		ZRMoney = ZRMoney.substring(0, ZRMoney.length()-2);
		double amount = Double.parseDouble(BZMoney)+Double.parseDouble(SYMoney)+Double.parseDouble(ZRMoney);
		String amount1=new DecimalFormat("###,##0.#").format(amount);
		base.assertTrueByBoolean(PlanMoneys.equals(planmoney) && PlanMoneys.equals(amount1));
		base.closeAndjumptoOldWindow();
//		}catch(Exception e){
//			base.closeAndjumptoOldWindow();
//			Assert.fail(e.toString());
//		}
	}
	//��鱣���ǡ�ļ�������ʡ�������ޡ����㷽ʽ���б�ҳ��ʾһ��
	public void checkBZStarLoanDetail(ArrayList<String> info){
		
		try{
			List<WebElement> detail = base.getElements(BZStarInfo);
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0;i<4;i++){
				String infos = detail.get(i+1).getText();
				if(i==0 && infos.contains(".") && infos.split("\\.")[1].length()==3){
					infos = infos.split("��Ԫ")[0]+"0"+"��Ԫ";
				}
				list.add(infos);
			}
			base.assertTrueByBoolean(info.size()==list.size());
			base.assertTrueByBoolean(info.equals(list));
			base.closeWebDriver();
		}catch(Exception e){
			base.closeWebDriver();
			e.printStackTrace();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//��������ǡ�ļ�������ʡ�������ޡ����㷽ʽ���б�ҳ��ʾһ��
	public void checkSYStarLoanDetail(ArrayList<String> info){
		
		try{
			List<WebElement> detail = base.getElements(SYStarInfo);
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0;i<4;i++){
				list.add(detail.get(i+1).getText());
			}
			base.assertTrueByBoolean(info.size()==list.size());
			base.assertTrueByBoolean(info.equals(list));
			base.closeWebDriver();
		}catch(Exception e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//��鱣���ǡ��������
	public void checkBZStarDetailIntro(int num){
		
		try{
			base.checkElementVisible(BZStarDetailPart);
			base.assertEqualsActualExpected("��Ϣ����\n�����\n���ر���", base.getElementTextWithWait(BZStarIntroTxt));
			String time = base.getElementTextWithWait(BZStarSaleTimeTxt);//����ʱ��
			base.assertEqualsActualExpected(time.substring(4,5), "-");
			base.assertEqualsActualExpected(time.substring(7,8), "-");
			base.assertEqualsActualExpected(time.substring(10,12), "����");
			
			String joinmember = base.getElementTextWithWait(BZStarjoinmemberTxt);//�Ѽ���2�˴Σ�ʣ���Ͷ�ʽ�1.38��Ԫ
			String rate = base.getElementTextWithWait(BZStarInvestRate);//��������Ŀ�е�����:10.5%
			if(rate.contains(".")){//10.5%
				int index = rate.indexOf(".")+1;
				int index2 = rate.indexOf("%");
				String dian = rate.substring(index,index2);
				if(dian.length()==1){
					dian = dian+"0";
					rate = rate.substring(0,index)+dian+rate.substring(index2);
				}
			}
			clickInvestRecordLnk();
			int j=0,m=0,size=0,page=getRecordPages();
			for(int n=1;n<=page;n++){
				base.checkElmentText(CurrentPage, String.valueOf(n));
				List<WebElement> rates = base.getElements(InvestRateTxt);			//Ͷ�������б�
				List<WebElement> money = base.getElements(InvestMoneyTxt);			//Ͷ�ʽ���б�
				size = rates.size();
				for(int i=0;i<size;i++){
					if(rates.get(i).getText().equals(rate)){
						j = j+1;													//Ͷ�ʱ���������
						String invest = money.get(i).getText().substring(1);		//Ͷ���˱����ǵ�Ͷ�ʽ��
						invest = invest.replaceAll(",", "");
						m= m+Integer.parseInt(invest);							//��Ͷ�ʱ����ǵ��ܽ��
					}
				}
				base.clickWithWait(LastOnePage);
			}
			String ZRTime = base.getElementTextWithWait(LastInvestTime);
			base.assertEqualsActualExpected(time, ZRTime+"����");
			String BZMoney = base.getElementTextWithWait(BZStarMoney);
			double amount = Double.parseDouble(BZMoney.substring(0, BZMoney.length()-2));//ļ�����
			String investing = new DecimalFormat("###,##0.##").format(amount-m/10000.0);
			base.assertEqualsActualExpected("�Ѽ���"+j+"�˴Σ�ʣ���Ͷ�ʽ�"+investing+"��Ԫ", joinmember);
			if(num == 2){
				base.closeAndjumptoOldWindow();
			}
		}catch(Exception e){
			if(num == 2){
				base.closeAndjumptoOldWindow();
			}
			e.printStackTrace();
			Assert.fail();
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//��������ǡ��������
	public void checkSYStarDetailIntro(int num){
		
		try{
			base.checkElementVisible(SYStarDetailPart);
			base.assertEqualsActualExpected("��������\n��Ѻ����\n���տɿ�", base.getElementTextWithWait(SYStarIntroTxt));
			String BZtime = base.getElementTextWithWait(BZStarSaleTimeTxt);//����ʱ��
			String time = base.getElementTextWithWait(SYStarSaleTimeTxt);//����ʱ��
			base.assertEqualsActualExpected(time, BZtime);
			base.assertEqualsActualExpected(time.substring(4,5), "-");
			base.assertEqualsActualExpected(time.substring(7,8), "-");
			base.assertEqualsActualExpected(time.substring(10,12), "����");
				
			String joinmember = base.getElementTextWithWait(SYStarjoinmemberTxt);//�Ѽ���2�˴Σ�ʣ���Ͷ�ʽ�1.38��Ԫ
			String rate = base.getElementTextWithWait(SYStarInvestRate);//��������Ŀ�е�����:16%
			if(rate.contains(".")){//16% 
				int index = rate.indexOf(".")+1;
				int index2 = rate.indexOf("%");
				String dian = rate.substring(index,index2);//5
				if(dian.length()==1){
					dian = dian+"0";//50
					rate = rate.substring(0,index)+dian+rate.substring(index2);
				}
			}
			clickInvestRecordLnk();
			int j=0,m=0,size=0,page=getRecordPages();
			for(int n=1;n<=page;n++){
				base.checkElmentText(CurrentPage, String.valueOf(n));
				List<WebElement> rates = base.getElements(InvestRateTxt);			//Ͷ�������б�
				List<WebElement> money = base.getElements(InvestMoneyTxt);			//Ͷ�ʽ���б�
				size = rates.size();
				for(int i=0;i<size;i++){
					if(rates.get(i).getText().equals(rate)){
						j = j+1;													//Ͷ�ʱ���������
						String invest = money.get(i).getText().substring(1);		//Ͷ���˱����ǵ�Ͷ�ʽ��
						invest = invest.replaceAll(",", "");
						m= m+Integer.parseInt(invest);							//��Ͷ�ʱ����ǵ��ܽ��
					}
				}
				base.clickWithWait(LastOnePage);
			}
			String SYMoney = base.getElementTextWithWait(SYStarMoney);
			double amount = Double.parseDouble(SYMoney.substring(0, SYMoney.length()-2));//ļ�����
			String investing = new DecimalFormat("###,##0.##").format(amount-m/10000.0);
			base.assertEqualsActualExpected("�Ѽ���"+j+"�˴Σ�ʣ���Ͷ�ʽ�"+investing+"��Ԫ", joinmember);
			if(num == 2){
				base.closeWebDriver();
			}
		}catch(Exception e){
			if(num == 2){
				base.closeWebDriver();
			}
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//����������ǡ��������
	public void clickBZStarDetailLnk(){
		base.clickElementNoWait(BZStarDetailLnk);
	}
	//����������ǡ��������
	public void clickSYStarDetailLnk(){
		base.clickElementNoWait(SYStarDetailLnk);
	}
	//
	/**
	 * ���������Ͷ�ʡ�����
	 * @author ����
	 * 2015-7-20  ���������checkLoginTitle()����
	 */
	public void clickFastInvestLnk(){
		if(base.getLnkElementText(new LoginPage().RegisterLnk, "class").contains("hide")){
			base.clickWithWait(InvestNowLnk);
			try{
				base.checkElementVisible(LoginPage.LoginBox);
			}catch(Exception e){
				base.closeAndjumptoOldWindow();
				Assert.fail(e.toString());
			}
		}else{
			base.clickWithWait(InvestNowLnk);
		}
	}
	public void clickCloseLoginLnk(){
		base.clickElementNoWait(CloseLoginLnk);
		base.assertTrueByBoolean(!base.isBlock(LoginBackground));
	}
	//�������ϸ��������
	public void clickDetailedRulesLnk(){
		base.clickWithWait(DetailedRulesLnk);
		base.checkElement(RulesLine);
	}
	//�����ϸ�����е�������ʾ
	public void checkDetailedRulesData(int num){
		try{
			String [] name = {"ʱ��","����","��Ͷ���","����","��Ϣʱ��","��Ϣʱ��","Ͷ������","��Ϣ��ʽ","�˳���ʽ"};
			String [] detail ={"�Ե��ڷ���Ϊ׼","��������","��������Ͷ���Ϊ100Ԫ����������������������������Ͷ���Ϊ500Ԫ������������������","�Ե��ڷ���Ϊ׼","��������ռ�Ϣ","ÿ��20����Ϣ","�Ե��ڷ���Ϊ׼","������Ϊÿ�¸�Ϣ�����ڻ�����������Ϊ��������","�����˳�"};		
			List<WebElement> names = base.getElements(RuleNames);
			List<WebElement> details = base.getElements(RuleDetails);
			for(int i=0;i<9;i++){
				base.assertEqualsActualExpected(names.get(i).getText(), name[i]);
				base.assertEqualsActualExpected(details.get(i).getText(), detail[i]);
			}
			if(num ==2){
				base.closeWebDriver();
			}
		}catch(Exception e){
			if(num ==2){
				base.closeWebDriver();
			}
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//�����ծȨ�Ƽ��ˡ�����
	public void clickCreditReferrerLnk(){
		base.clickWithWait(ReferrerLnk);
		base.checkElement(ReferrerAddressLnk);
	}
	//�����ծȨ�Ƽ��ˡ��ĵ�ַ
	public void clickReferrerAddressLnk(){
		int window = base.Windowsize();
		base.clickElementNoWait(ReferrerAddressLnk);
		if(base.Windowsize()==window){
			base.clickElementNoWait(ReferrerAddressLnk);
		}
		base.turnToNewPage();
		base.getWebDriver().manage().window().maximize();
		base.checkElement(CreditReferrerDetailPage.ReferrerPage);
	}
	//�����Ͷ�ʼ�¼������
	public void clickInvestRecordLnk(){
		base.clickWithWait(InvestRecordLnk);
		base.checkElement(RecordSubtile);
	}
	//��ȡ��Ͷ�ʼ�¼����ҳ��
	public int getRecordPages(){
		int NumTxt = Integer.parseInt(base.getElementTextWithWait(InvestorNumTxt));
		int page;
		if(NumTxt==0){
			page=0;
		}else{
			page =NumTxt%10 == 0 ? (NumTxt/10) : (NumTxt/10)+1;
		}
		return page;
	}
	//��ȡ����Ͷ�ʼ�¼��������
	public int getRecordNum(){
		if(base.isElementPresent(SixPageLnk)){
			base.clickWithWait(LastPage);
			base.checkElmentText(EmptyPage, ">");
			base.checkElementVisible(LastTwoPage);
			int lastPageNum = Integer.valueOf(base.getElementTextWithWait(LastTwoPage));
			return 10*(lastPageNum-1)+base.getElements(InvestorLines).size();
		}else{
			return base.getElements(InvestorLines).size();
		}
		
	}
	//�����Ͷ�����ۡ�����
	public void clickInvestCommentLnk(){
		base.clickWithWait(InvestCommentLnk);
		base.checkElement(CommentTxt);
	}
	//������������
	public void InputComment(String content){
		base.sendKeysWithWait(InputComment, content);
	}
	//������ύ��
	public String clickSubmitBtn(){
		base.clickWithWait(SubmitBtn);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar cal = Calendar.getInstance();
        return dateFormat.format( base.getTime());	  
	}
	//���δ��¼ʱͶ������
	public void checkCommentwithoutLogin(){
		
		try{
			base.checkNoElement(SubmitBtn);
			base.checkElementVisible(InputComment);
			base.assertEqualsActualExpected(base.getElementTextWithWait(RegisterAndLoginLnk), "ע���Ϊ��Ա�󷽿ɻظ�  ע��|��¼");
			base.closeWebDriver();
		}catch(Exception e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//����¼ʱͶ������
	public void checkCommentwithLogin(int num){
		
		try{
			base.assertEqualsActualExpected(base.getElementTextWithWait(SubmitBtn), "�ύ");
			InputComment("");
			clickSubmitBtn();
			base.assertEqualsActualExpected(base.getAlertwithWait().getText(), "�������������ݣ�");
			base.acceptAlert();
			if(base.indexURL.contains("client")){
				InputComment("1");
				clickSubmitBtn();
				base.checkElmentText(SubmittedContent, "1");
				base.checkElementVisible(InputComment);
				InputComment("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefg");
				clickSubmitBtn();
				base.checkElmentText(SubmittedContent,"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
						+"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefg");
			}else if(base.indexURL.contains("test")||base.indexURL.contains("www")){
				InputComment("�������Ǽƻ�ʲôʱ��");
				clickSubmitBtn();
				base.checkElmentText(SubmittedContent, "�������Ǽƻ�ʲôʱ��");
			}
			base.checkElementVisible(InputComment);
			InputComment("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
					+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefgh");
			clickSubmitBtn();
			base.assertEqualsActualExpected(base.getAlertwithWait().getText(), "�����������500��");
			base.acceptAlert();
			if(num ==2){
				base.closeAndjumptoOldWindow();
			}
		}catch(Exception e){
			if(num ==2){
				base.closeAndjumptoOldWindow();
			}
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	
	//��������ǡ�����Ͷ�ʡ�����
	public void clickBZStarInvestNowLnk(){
		if(base.getElementText(IndexPage.userName).equals("")){
			base.clickWithWait(BZStarInvestNowLnk);
			base.checkElement(LoginPage.LoginBox);
		}else{
			base.clickWithWait(BZStarInvestNowLnk);
			base.assertTrueByBoolean(base.getElementTextWithWait(BZStarInvestTitle).contains("Ͷ����Ϣ"));			
		}
	}
	//��鱣���ǡ��Զ����롱
	public void checkBZStarAutoInput(){
		try{
			String NeedAmount = base.getElementText(BZStarNeedAmountTxt);
			String Balance = base.getElementText(BZStarBalanceTxt);
			int NeedMoney = Integer.valueOf(NeedAmount).intValue();
			if(Balance.contains(".")){
				int endIndex = Balance.lastIndexOf(".");
				Balance = Balance.substring(0, endIndex);			
			}
			int BalanceMoney = Integer.valueOf(Balance).intValue();
			if(NeedMoney<=BalanceMoney){
				base.assertEqualsActualExpected(base.getLnkElementText(InputAmount, "value"),String.valueOf(NeedMoney/100));
			}else{
				base.assertEqualsActualExpected(base.getLnkElementText(InputAmount, "value"),String.valueOf(BalanceMoney/100));
			}
			base.closeAndjumptoOldWindow();
		}catch(Exception e){
			base.closeAndjumptoOldWindow();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//���������Ͷ���Զ���������
	public void clickAutoInputBZStarLnk(){
		base.clickElementNoWait(AutoInputLnk);
	}
	//���뱣����Ͷ��֧������
	public void InputBZStarPayPwd(String pwd){
		base.elementSendkey(InputBZStarPayPwd, pwd);
	}
	//���뱣����Ͷ����֤��
	public void InputValidateCode(){
		String ValidateCode = new Data().get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
		base.elementSendkey(InputBZStarValidateCode, ValidateCode);
	}
	//ѡ�б�����Ͷ���Ķ���ͬ��Э��
	public void CheckAgreeDeal(){
		base.clickElementNoWait(BZStarAgreeCheckbox);
	}
	//���������Ͷ�ʡ�ȷ������ť
	public void clickOkBtn(){
		base.clickElementNoWait(BZStarOkBtn);
		base.checkElmentText(InvestSuccessTxt, "Ͷ�ʳɹ�");
	}
	
	//���������Ͷ�ʡ�ȡ������ť
	public void clickBZStarCancelBtn(){
		base.clickElementNoWait(BZStarCancelBtn);
		base.checkNoElement(BZStarCancelBtn);
//		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	//�رա�Ͷ�ʳɹ�������
	public void clickCloseSuccessLnk(){
		base.clickElementNoWait(CloseInvestSuccessLnk);
		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	//��������������Ĳ鿴��
	public void clickViewLnk(){
		base.clickElementNoWait(IndividualViewLnk);
		base.checkElement(MonthPlanTxt);
	}
	//��������ǡ�����Ͷ�ʡ�����
	public void clickSYStarInvestNowLnk(){
		base.clickWithWait(SYStarInvestNowLnk);
	}
	//��������ǡ��ܾ���������ʾ��ť
	public void clickDenyBtn(){
		base.clickWithWait(DenyBtn);
		base.checkNoElement(DenyBtn);
		base.checkElementVisible(EStarTitleinDetail);
//		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	//��������ǡ�ͬ�⡱������ʾ��ť
	public void clickAgreeBtn(){
		base.clickWithWait(AgreeBtn);
		base.assertTrueByBoolean(base.getElementTextWithWait(SYStarInvestTitle).contains("Ͷ����Ϣ"));
	}
	//�رա������ǡ�Ͷ�ʴ���
	public void clickSYStarCloseBoxBtn(){
		base.clickElementNoWait(CloseSYStarInvestBoxLnk);
		base.assertTrueByBoolean(!base.isBlock(Background));
	}
	//���������Ͷ���Զ���������
	public void clickAutoInputSYStarLnk(){
		base.clickWithWait(AutoInputSYStarLnk);
	}
	//��������ǡ��Զ����롱
	public void checkSYStarAutoInput(){
		try{
			String NeedAmount = base.getElementText(SYStarNeedAmountTxt);
			String Balance = base.getElementText(SYStarBalanceTxt);
			if(Balance.contains(".")){
				int endIndex = Balance.lastIndexOf(".");
				Balance = Balance.substring(0, endIndex);
			}
			int NeedMoney = Integer.valueOf(NeedAmount).intValue();
			int BalanceMoney = Integer.valueOf(Balance).intValue();
			if(NeedMoney<=BalanceMoney){
				base.assertEqualsActualExpected(base.getLnkElementText(InputSYStarAmount, "value"),String.valueOf(NeedMoney/500));
			}else{			
				base.assertEqualsActualExpected(base.getLnkElementText(InputSYStarAmount, "value"),String.valueOf(BalanceMoney/500));
			}
			base.closeAndjumptoOldWindow();
		}catch(Exception e){
			base.closeAndjumptoOldWindow();
			Assert.fail(e.toString());
		}catch(AssertionError e){
			base.closeWebDriver();
			Assert.fail(e.toString());
		}
	}
	//���������Ͷ��֧�����������
	public void clickSYStarPayPwd(){
		base.clickElementNoWait(InputSYStarPayPwd);
	}
	//����������Ͷ��֧������
	public void InputSYStarPayPwd(String pwd){
		base.elementSendkey(InputSYStarPayPwd, pwd);
	}
	//����������Ͷ����֤��
	public void InputSYStarValidateCode(){
		String ValidateCode = new Data().get(base.getElementWithWait(yanZhengMaImg), base.getWebDriver());
		base.elementSendkey(InputSYStarValidateCode, ValidateCode);
	}
	//ѡ��������Ͷ���Ķ���ͬ��Э��
	public void CheckSYStarAgreeDeal(){
		base.clickElementNoWait(SYStarAgreeCheckbox);
	}
	//���������Ͷ�ʴ��ڡ�ȷ������ť
	public void clickSYStarOkBtn(){
		base.clickElementNoWait(SYStarOkBtn);
		base.checkElmentText(InvestSuccessTxt, "Ͷ�ʳɹ�");
	}
	//���������Ͷ�ʴ��ڡ�ȡ������ť
	public void clickSYStarCancelBtn(){
		base.clickWithWait(SYStarCancelBtn);
		base.assertTrueByBoolean(!base.isBlock(Background));
	}
}
