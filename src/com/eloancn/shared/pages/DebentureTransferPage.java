package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;
/**
 * ����ר��
 * @author ����Ԫ
 */
public class DebentureTransferPage {
	Base base = new Base();
	LoginPage loginPage = new LoginPage();
	String currentHandel = "";
	String backHandel = "";
	public String PageUrl = base.indexURL+"/new/loadNewUserTender.action";
	
	/***************����ר��*************/
	//Ͷ���б�
	By investList = By.xpath("//div[@class='lendtable']//dt");
	//��������ͼƬ����
	By creditEvaluationList = By.cssSelector(".user_img.fl.wd100>a>img");
	//���������������
	By creditInfoList = By.cssSelector(".fl>h2");
	//���С�����Ͷ�ʡ��Ľ��������������
	By haveFaseInvestcreditInfoLinks = By.xpath("//a[@class='fast_money mt8']/parent::dd/preceding-sibling::dd//a");
	//����Ͷ��
	By fastInvestBtn = By.cssSelector(".fast_money.mt8");////a[text()='����Ͷ��']
	By RechargeWindow = By.id("noPerson");
	By TipDetailTxt = By.cssSelector("div.lyct>p.textC");//������ֵ��ʾ������
	By GoRechargeBtn = By.cssSelector("input[type='submit']");//"ȥ��ֵ!"��ť
	By InvestWindow = By.id("fastLender_1");//Ͷ�ʴ���
	By CloseRechargeTipLnk = By.cssSelector("a.lyclose");									//�رճ�ֵ��ʾ

	
	By moneyTxt = By.id("amount");											//������
	By payPassowrdTxt = By.id("paypassowrd");								//֧������
	By randCodeTxt = By.id("tenderRecordRandCode");							//��֤��
	By randCodeImg = By.cssSelector("#checkverificationCode_fast>a>img");	//��֤��ͼƬ
	By sureBtn = By.cssSelector(".f_m_Confirm.ml20");						//ȷ��
	
	/*************�������**************/
	
	By creditEvaluationImg = By.cssSelector(".ld_user.fl>a>img");			//ͷ��
	By planInfoLink = By.cssSelector(".clear.wd270>a");						//����
	By lookpLanInfoTxt = By.cssSelector(".fl.font22");						//�鿴����ƻ�
	By closeLookpLanInfoBtn = By.cssSelector(".close");						//�رջ���ƻ�
	By registerLink = By.xpath(".//*[@id='record4']//a[text()='ע��']");		//ע��
	By loginLink = By.xpath(".//*[@id='record4']//a[text()='��¼']");			//��¼
	By ownerLink = By.cssSelector(".ld_user.fl>p>a");//.font14.ml35>a		//owner
	
	/**
	 * ����Ԫ
	 * �ж�����ר�������Ƿ�������ÿҳ�����ʾ10��
	 */
	public void isInvestDataSizeOK(){
		//��������
		List<WebElement> invest_List =  base.getElements(investList);
		base.assertTrueByBoolean(invest_List.size()<=10);
	}
	
	/**
	 * ����Ԫ
	 * У��Ͷ���б�������Ƿ���ȷ
	 */
	public void isInvestDataLinkOK(){
		//���ͼƬ�����������۽���
		List<WebElement> creditEvaluation_list =  base.getElements(creditEvaluationList);
		verifyDataList(creditEvaluation_list,"��������");
		//������ӽ������������
		List<WebElement> creditInfo_list =  base.getElements(creditInfoList);
		verifyDataList(creditInfo_list,"�������");
	}
	
	/**
	 * У��List���ӽ�����ҳ���Ƿ���ȷ
	 * @param list
	 * @param title
	 */
	public void verifyDataList(List<WebElement> list,String title){
		//List<WebElement> titles = new ArrayList<WebElement>();
		for(int i = 0; i < 1; i++){
			if (title.equals("�������")) {
				title = list.get(i).getText().length()>10 ? list.get(i).getText().substring(0,10) : list.get(i).getText();
				System.out.println(title);
			}
			currentHandel = base.getCurrentWindowHandle();
			list.get(i).click();
			//base.sleep(2000);
			String newHandel = base.getChildWindowHandle(currentHandel);
			base.jumpToWindow(newHandel);
			base.sleep(2000);
//			verifyMethod.verifyEquals(true, base.checkTitleContains(title));
			Assert.assertTrue(base.checkTitleContains(title));
			//base.sleep(2000);
			base.closeWindow(newHandel);
			base.jumpToWindow(currentHandel);
		}
	}
	
	/**
	 * ����Ԫ
	 * �Ƿ��С�����Ͷ�ʡ���ť
	 */
	public boolean ifHaveFastInvestBtn(){
		return base.isDisplayed(fastInvestBtn);
	}
	
	public void clickFastInvestBtn(){
		List<WebElement> fastInvestBtnList =  base.getElements(fastInvestBtn);
		if(fastInvestBtnList.size()>0){
			fastInvestBtnList.get(0).click();
			base.checkElementVisible(LoginPage.RegisterLnk);
			if(base.getLnkElementText(LoginPage.RegisterLnk, "class").contains("hide")){//δ��¼
				base.checkElementVisible(LoginPage.LoginBox);
			}else{
				if(base.isBlock(RechargeWindow)){
					base.checkElementVisible(TipDetailTxt);
					base.assertEqualsActualExpected(base.getElementTextWithWait(TipDetailTxt), "�� ����ȥ��ֵ,��Ͷ��!");
					base.assertEqualsActualExpected(base.getLnkElementText(GoRechargeBtn,"value"), "ȥ��ֵ!");										
				}else{
					base.checkElementVisible(InvestWindow);
				}
			}		
		}else{
			System.out.println("����ר��û�п�Ͷ�ʵĽ��꣡");
		}
	}
	public void clickCloseRechargeBtn(){
		base.clickWithWait(CloseRechargeTipLnk);
		base.checkNoElement(CloseRechargeTipLnk);
	}

	
	/**
	 * δ��¼�����������Ͷ�ʡ�
	 */
	public void clickFastInvest(){
		base.clickWithWait(fastInvestBtn);
	}
	
	/**
	 * ����Ԫ
	 * �Ƿ���ʾ��¼
	 */
	public void isLogin(){
		base.assertTrueByBoolean(base.isBlock(By.cssSelector(".login")));
		base.assertNotNullBy(By.cssSelector(".fl.font20"));
	}
	
	/**
	 * ����Ԫ
	 * �رյ�¼����
	 */
	public void closeLogin(){
		base.clickWithWait(By.cssSelector(".login .close"));
	}
	
	/**
	 * ����Ԫ
	 * У������ҳ����
	 */
	public void verifyDetailsInfoLinks(){
		base.getElements(creditInfoList).get(0).click();
		String detailsHandel = base.getChildWindowHandle(currentHandel);//�������ҳ
		base.jumpToWindow(detailsHandel);
		//����������ҳͼƬ����ת����������ҳ
		isTurnToCreditEvaluationPage(creditEvaluationImg,currentHandel,detailsHandel);
		//�鿴����ƻ�
		base.clickWithWait(planInfoLink);
//		verifyMethod.verifyEquals(base.getElementText(lookpLanInfoTxt), "�鿴����ƻ�");
		Assert.assertEquals(base.getElementText(lookpLanInfoTxt), "�鿴����ƻ�");
		base.clickWithWait(closeLookpLanInfoBtn);
		//owner
		isTurnToCreditEvaluationPage(ownerLink,currentHandel,detailsHandel);
		base.closeWindow(detailsHandel);
		base.jumpToWindow(currentHandel);
	}
	
	public void isTurnToCreditEvaluationPage(By by,String handel1,String handel2){
		base.clickWithWait(by);
		String creditEvaluationHandel = base.getLastWindowHandle(handel1,handel2);//��������
		base.jumpToWindow(creditEvaluationHandel);
//		verifyMethod.verifyEquals(true, base.checkTitleContains(PageTitles.xinYongPingJiaYe));//"��������"
		Assert.assertTrue(base.checkTitleContains(PageTitles.xinYongPingJiaYe));
		base.closeWindow(creditEvaluationHandel);
		base.jumpToWindow(handel2);
		base.sleep(2000);
	}
	
	/**
	 * ����Ԫ
	 * ����Ͷ��
	 */
	public void fastInvest(String money,String payPass){
		base.sendKeysWithWait(moneyTxt, money);
		base.sendKeysWithWait(payPassowrdTxt, payPass);
		String code = new Data().get(base.getElementWithWait(randCodeImg), base.getWebDriver());
		base.sendKeysWithWait(randCodeTxt, code);
		base.clickWithWait(sureBtn);
	}
	
	/**
	 * ����Ԫ
	 * �Ƿ�Ͷ�ʳɹ�
	 */
	public boolean isFastInvestOK(){
		boolean flag = false;
		boolean result = false;
		String msg = "";
		result = base.checkVisible(By.id("fastLender_2"));
		try {
			base.checkElementVisible(By.cssSelector("#tenderOK"),2);
			msg = base.getElementTextWithVisible(By.cssSelector("#tenderOK"));
			flag = true;
		} catch (Exception e) {
			base.checkElementVisible(By.cssSelector("#errorMsg"),2);
			msg = base.getElementTextWithVisible(By.cssSelector("#errorMsg"));
		}
		currentHandel = base.getCurrentWindowHandle();
		//����Ͷ���б�
		base.clickWithWait(By.id("backButton"));
		//�ر�
		backHandel= base.getCurrentWindowHandle();
		base.assertTrueByBoolean(result);
		if (msg.equals("Ͷ��ɹ�  ")) {
			flag = true;
		}
		if (base.gethandelsNum()>=2) {
			base.closeWebDriver();
		}
		return flag;
	}
	
	/**
	 * ����Ԫ
	 * ����ҳ ����Ǯ������
	 */
	public boolean detailsFastInvest(String money,String payPass,String tel,String password){
		currentHandel = base.getCurrentWindowHandle();
		//���С�����Ͷ�ʡ��Ľ��������������
		base.getElements(haveFaseInvestcreditInfoLinks).get(0).click();
		String detailsHandel = base.getChildWindowHandle(currentHandel);//�������ҳ
		base.jumpToWindow(detailsHandel);
		//System.out.print(!loginPage.ifLogin());
		if (!loginPage.ifLogin()) {//���ie������  δͬ����¼״̬  ���µ�¼
			base.clickWithWait(By.cssSelector("#login_1 .colorFc"));
			loginPage.login(tel, password);
		}
		//�������Ǯ������
		base.clickWithWait(By.cssSelector(".ld_btn.mt25.fl"));
		fastInvest(money,payPass);
		boolean result = isFastInvestOK();
		if (result) {
			base.closeWindow(detailsHandel);
		}
		return result;
	}
	
	/**
	 * ����Ԫ
	 * ����Ͷ�ʸ��������ֱ������
	 */
	public int getDebentureTransferNum(){
		List<WebElement> list = base.getElements(By.cssSelector(".fast_money.mt8"));
		return list.size();
	}
	
	/**
	 * ����Ԫ
	 * У�����ֱ�����Ƿ���ȷ  #newUserLink em
	 */
	public void isDebentureTransferNumOK(int num){
		if (num>0) {
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#newUserLink em")), "["+num+"]");
		}else {
			base.assertEqualsActualExpected(base.getElementTextWithWait(By.cssSelector("#newUserLink")), "����ר��[0]");
		}
	}
	
	/**
	 * ����Ԫ
	 * �������ֱ�
	 */
	public void makeNewUserBid(){
		base.logout();
		base.openBrowser(base.indexURL + "/page/userMgr/myHome.jsp");
		loginPage.loginWithNoFrame(Data.newUser, "111111");
		MyAccountPage myAccountPage = new MyAccountPage();
		LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
		myAccountPage.turnToMyAccount("������");
		loanApplicationPage.loanApplication(true, false, "��ũ��", "1000", "12����","","18", "7", "����", "fx", "��������", "�Žܽ��1", "�Զ��������ܹ�����߹�����������������������������������������");
		new DBData().updateNewUserBid("�Žܽ��1");
	}
}
