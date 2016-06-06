package com.eloancn.shared.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
/*
 * “我的账户”-“充值”页面
 */
public class RechargePage {
	Base base = new Base();
	
	public static By ImproveProfileTxt = By.xpath("//form[@id='userFrom']/div/table/tbody/tr/td/div/div/h2");//“完善个人信息”提示
	public static By OnlineRechargeTxt=By.cssSelector("span.current.wd110");
	String rechargeHandel = "";
	String jianSheHandel = "";
	
	//转账汇款
	By transferRemittanceTab = By.cssSelector(".wd140");
	/**************完善个人身份信息***********/
	//完善个人身份信息
	By identityInfoTxt = By.cssSelector("#userinfo .u-tt");
	//姓名
	By prealnameTxt = By.cssSelector("#prealname");
	//身份证号
	By pidcardTxt = By.xpath("//input[@id='pidcard']");//By.cssSelector("#pidcard");//By.id("pidcard");
	//支付密码
	By zzmmTxt = By.id("zfmm_s");
	By zzmmTxtByCss = By.cssSelector("#zfmm_s");
//	By ppaypasswordTxt = By.id("ppaypassword");
	By ppaypasswordTxt = By.cssSelector("#ppaypassword");
	//认证并保存
	By saveBtn = By.xpath("//input[@value='认证并保存']");
	//现在去充值
	By rechargeBtn = By.xpath("//input[@value='现在去充值']");
	//关闭
	By closeBtn = By.cssSelector(".lyclose");
	//msg
	By msgTxt = By.id("msg");
	//姓名错误提示信息
	public By nameMsg = By.cssSelector("#nametip");
	//姓名正确提示图片
	public By nameCheckmarkImg = By.cssSelector("#prealnametipMsg > img");
	//身份证错误提示信息
	By idMsg = By.cssSelector("#idcardtip");
	By pidMsg = By.cssSelector("#pidcardtipMsg > span");
	//支付密码错误提示信息
	By payMsg = By.cssSelector("#ppaytip"); 
	/***************充值****************/
	//礼品卡充值
	By giftCardRechargeLink = By.cssSelector(".cardStyle.fr");			//礼品卡充值
	By giftCardRechargeDiv = By.cssSelector("#giftCardPay");			//礼品卡充值DIV
	By giftCardRechargeNum = By.cssSelector("#serialnumber");			//卡号
	By giftCardRechargePass = By.cssSelector("#password");				//密码
	By giftCardRechargeSubmit = By.cssSelector(".btn1.ml150>input");	//提交
	By giftCardRechargeClose =  By.cssSelector("#giftCardPay .close");	//关闭
	By gittCardRechargeMsgSuccess = By.cssSelector("#tips");			//充值成功提示信息
	
	//汇款转账>>>>>>>>>>>>>>>>>
	//汇款日期
	By dateTxt = By.id("transactionTime");
	//汇款金额
	By moneyTxt = By.id("money");
	//汇出行
	By outBankTxt = By.id("outBank");
    //汇款账户
	By outBankLastTxt = By.id("outBankLast4");
	//提交
	By submitBtn = By.id("chongzhi");
	//重置
	By resetBtn = By.cssSelector("input[class='ml5'][type='reset']");
	//说明
	By descriptionTxt = By.cssSelector("#description");//By.id("description");
	//网银充值>>>>>>>>>>>>>>>>>
	By GuangDaBank = By.cssSelector("#paymentList3 .CEB");
	By jianSheNank = By.cssSelector("#paymentList3 .CCB");
	//充值金额
	By rechargeTxt = By.cssSelector("#rechargeAmount #tranAmt");//By.id("tranAmt");
	//充值按钮
	By rechargeCyberBtn = By.id("oltopay");
	//已完成充值
	By rechargeOkBtn = By.cssSelector(".btn-fc.btn-cp");
	//充值问题
	By rechargeQuestionBtn = By.cssSelector(".btn-fc.btn-qt");
	//温馨提示关闭按钮
	By promptCloseBtn = By.cssSelector("#paytip .lyclose");
	
	/**
	 * 点击“礼品卡充值”
	 */
	public void clickGiftCardRechargeLink(){
		base.checkElementVisible(giftCardRechargeLink);
		base.clickElementNoWait(giftCardRechargeLink);
		boolean isBlock = base.isElementContainsValue2(giftCardRechargeDiv, "style", "block");
		base.assertEqualsActualExpectedByBoolean(isBlock, true);
	}
	
	/**
	 * 输入卡号
	 * @param num 卡号
	 * @author 江渤洋 2015-12-1
	 */
	public void inputGiftCardRechargeNum(String num){
		base.checkVisible(giftCardRechargeNum);
		base.elementSendkey(giftCardRechargeNum,num);
	}
	
	/**
	 * 输入密码
	 * @param pass 密码
	 * @author 江渤洋 2015-12-1
	 */
	public void inputGiftCardRechargePass(String pass){
		base.checkVisible(giftCardRechargePass);
		base.elementSendkey(giftCardRechargePass,pass);
	}
	
	/**
	 * 点击提交按钮
	 * @author 江渤洋 2015-12-1
	 */
	public void clickGiftCardRechargeSubmit(){
		base.checkVisible(giftCardRechargeSubmit);
		base.clickElementNoWait(giftCardRechargeSubmit);
	}
	
	/**
	 * 点击关闭按钮
	 * @author 江渤洋 2015-12-1
	 */
	public void clickGiftCardRechargeClose(){
		base.checkVisible(giftCardRechargeClose);
		base.clickElementNoWait(giftCardRechargeClose);
		boolean isNone = base.isElementContainsValue(giftCardRechargeDiv, "style", "none");
		base.assertEqualsActualExpectedByBoolean(isNone, true);
	}
	
	/**
	 * 校验提示信息是否为充值成功
	 * @author 江渤洋 2015-12-1
	 */
	public void isGittCardRechargeMsgSuccess(){
		String msg = base.getElementTextWithWait(gittCardRechargeMsgSuccess);
		base.assertEqualsActualExpected(msg, "充值成功!");
	}
	
	/**
	 * 提交礼品卡充值
	 * @param num 卡号
	 * @param pass 密码
	 * @author 江渤洋 2015-12-1
	 */
	public void submitGiftCardRecharge(String num, String pass){
		inputGiftCardRechargeNum(num);
		inputGiftCardRechargePass(pass);
		clickGiftCardRechargeSubmit();
	}
	
	/**
	 * 充值，并校验提示信息是否为充值成功
	 * @param num 卡号
	 * @param pass 密码
	 * @author 江渤洋 2015-12-1
	 */
	public void checkGittCardRechargeMsgSuccess(String num, String numPass){
		submitGiftCardRecharge(num, numPass);
		isGittCardRechargeMsgSuccess();
		clickGiftCardRechargeClose();
	}
	
	/**
	 * 徐天元
	 * 提示身份认证
	 */
	public void isIdentityInfo(){
		base.assertEqualsActualExpectedByBoolean(base.checkVisible(By.cssSelector("#userinfo")), true);
	}
	
	/**
	 * 徐天元
	 * 校验完善信息输入框是否显示
	 */
	public void checkShowUserInfoInput(boolean nameResult,boolean idCardResult,boolean zfmmResult){
		base.assertEqualsActualExpectedByBoolean(base.checkVisibleNoWaite(By.id("nameli")), nameResult);
		base.assertEqualsActualExpectedByBoolean(base.checkVisibleNoWaite(By.id("idcardli")), idCardResult);
		base.assertEqualsActualExpectedByBoolean(base.checkVisibleNoWaite(By.id("paypasswordli")), zfmmResult);
	}
	
	/**
	 * 徐天元
	 * 充值 转账汇款
	 */
	public void rechargeTransferRemittance(String realName,String idCard,String zzmm,String date,String money,String outBank,String outBankNum,String description){
		//base.sleep(5000);
		//if(base.isBlock(By.id("nameli")) || base.isBlock(By.id("idcardli")) || base.isBlock(By.id("paypasswordli"))){//完善身份信息
		if(base.checkVisible(By.cssSelector("#userinfo"))){
			setInfo(realName,idCard,zzmm);
		}
		//转账汇款
		if(!base.isElementVisible(transferRemittanceTab)){
			base.setDisplayByClassName("wd140", "block");
		}
		base.clickWithWait(transferRemittanceTab);
		//汇款金额
		base.clickWithWait(moneyTxt);
		base.elementSendkeyNoClear(moneyTxt, money);
		//汇款日期
		System.out.println(date);
		base.setDate("transactionTime", date);
		//汇出行
		base.sendKeysWithWait(outBankTxt, outBank);
		//base.sleep(2000);
		//base.keyBoard(1);
		//汇款账户
		base.sendKeysWithWait(outBankLastTxt,outBankNum);
		base.sendKeysWithWait(descriptionTxt,description);
		base.clickWithWait(submitBtn);
	}
	
	/**
	 * 转账汇款录入信息
	 */
	public void rechargeTransferRemittance(String date,String money,String outBank,String outBankNum,String description){
		base.sleep(3000);
		if(!base.isElementVisible(transferRemittanceTab)){
			base.setDisplayByClassName("wd140", "block");
		}
		//转账汇款
		base.clickWithWait(transferRemittanceTab);
		//汇款金额
		base.clickWithWait(moneyTxt);
		base.elementSendkeyNoClear(moneyTxt, money);
		//汇款日期
		base.setDate("transactionTime", date);
		//汇出行
		base.sendKeysWithWait(outBankTxt, outBank);
		//汇款账户
		base.sendKeysWithWait(outBankLastTxt,outBankNum);
		//说明
		base.sendKeysWithWait(descriptionTxt,description);
	}
	
	/**
	 * 校验重置按钮
	 * @author 江渤洋 2015-9-6
	 */
	public void checkResetByTransferRemittance(){
		base.clickWithWait(resetBtn);
		base.assertEqualsActualExpected(base.getElementText(moneyTxt), "");
		base.assertEqualsActualExpected(base.getElementText(dateTxt), "");
		base.assertEqualsActualExpected(base.getElementText(outBankTxt), "");
		base.assertEqualsActualExpected(base.getElementText(outBankLastTxt), "");
		base.assertEqualsActualExpected(base.getElementText(descriptionTxt), "");
	}
	
	/**
	 * 徐天元
	 * 验证是否充值成功
	 */
	public void isRecharge(){
		Alert alert = base.getAlertwithWait();
		try {
			base.assertEqualsActualExpected(alert.getText(), "恭喜您申请成功，请等待系统核实！");
			alert.accept();
		} catch (AssertionError e) {
			alert.accept();
			base.assertTrueByBoolean(false);
		}
	}
	
	/**
	 * 徐天元
	 * 关闭“完善个人身份信息”
	 */
	public void closeInfo(){
		base.clickWithWait(By.cssSelector("#userinfo .lyclose"));//closeBtn
	}
	
	/**
	 * 完善个人信息
	 * 徐天元
	 */
	public String[] setInfo(String realName,String idCard,String zzmm){
		String[] info = {realName,idCard};
		if(base.checkVisible(By.id("nameli"))){//usernameli
			base.sendKeysWithWait(prealnameTxt, realName);
		}
		if(base.checkVisible(By.id("idcardli"))){//relidcardli
			base.sendKeysWithWait(pidcardTxt, idCard);
		}
		if(base.checkVisible(By.id("paypasswordli"))){
			int i = 0;
			do{
				i++;
				base.clickWithWait(zzmmTxtByCss);
			}while(base.checkVisible(zzmmTxtByCss,5) && i<3);//判断是否点击支付密码文本框，否则循环点击
			base.sendKeysWithWait(ppaypasswordTxt, zzmm);
		}
		//Reporter.log("test环境，请更改Data注册数据test_register_credit_idCard和test_register_credit_realName");
		//此身份证号已经被注册！更换姓名 、身份证号
		if (base.checkVisible(By.cssSelector("#idcardtip"),5)) {
			Reporter.log(realName+","+idCard+base.getElementTextWithWait(By.cssSelector("#idcardtip")));
			System.out.println(realName+","+idCard+idCard+base.getElementTextWithWait(By.cssSelector("#idcardtip")));
			if (base.indexURL.contains("test") || base.indexURL.contains("www")) {
				Reporter.log("此身份证号已使用");
				System.out.println("此身份证号已使用");
				base.assertTrueByBoolean(false);
			}else {
				idCard = new Data().idConcatenation();
			}
			base.sendKeysWithWait(pidcardTxt, idCard);
			Reporter.log("投资者信息更换为："+realName+","+idCard);
			System.out.println("投资者信息更换为："+realName+","+idCard);
		}
		base.clickWithWait(saveBtn);
		base.sleep(3000);
		isSetInfoOK();
		Reporter.log(realName+","+idCard+"已完善信息");
		System.out.println(realName+","+idCard+"已完善信息");
		base.clickWithWait(rechargeBtn);
		info[0] = realName;
		info[1] = idCard;
		return info;
	}
	
	/**
	 * 完善个人信息_点击姓名文本框
	 * @author 江渤洋 2015-7-21
	 */
	public void clickInfoByRealName(){
		if(base.isBlock(By.id("nameli"))){
			int count = 1;//点击次数
			do{
				base.clickWithWait(prealnameTxt);
				System.out.println("姓名文本框点击" + count + "次");
				count++;
			}while(!base.checkVisible(By.cssSelector("#prealnametipMsg > span"),5));
			
			base.sleep(2000);
		}
	}
	
	/**
	 * 完善个人信息_点击支付密码文本框
	 * @author 江渤洋 2015-7-21
	 */
	public void clickInfoByPayPassword(){
		if(base.isBlock(By.id("paypasswordli"))){
			int count = 1;//点击次数
			do{
				base.clickWithWait(ppaypasswordTxt);
				System.out.println("支付密码文本框点击" + count + "次");
				count++;
			}while(!base.checkVisible(By.cssSelector("#ppaypasswordMsg > span"),5));//判断是否点击支付密码文本框，否则循环点击

//			base.assertEqualsActualExpectedByBoolean(base.isNone(ppaypasswordTxt), false);
			base.sleep(2000);
		}
	}
	
	/**
	 * 完善个人信息_姓名
	 * @param 姓名
	 * @author 江渤洋 2015-7-21
	 */
	public void setInfoByRealName(String realName){
//		if(base.isBlock(By.id("nameli"))){
			base.clickWithWait(prealnameTxt);
			base.sendKeysWithWait(prealnameTxt, realName);
			base.sleep(2000);
//		}
	}
	
	/**
	 * 完善个人信息——身份证号
	 * @param 身份证号
	 * @author 江渤洋 2015-7-21
	 */
	public void setInfoByIdCard(String idCard){
		boolean isShow = false;
		try {
			isShow = base.isBlock(By.cssSelector("#idcardli"));
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("身份证号列表标签li没有找到！");
		}
		if(isShow){
			base.clickWithWait(pidcardTxt);
			base.sendKeysWithWait(By.cssSelector("#pidcard"), idCard);//pidcardTxt
			base.sleep(2000);
		}
	}
	
	/**
	 * 完善个人信息——支付密码
	 * @param 支付密码是否为空
	 * @author 江渤洋 2015-7-21
	 */
	public void setInfoByPayPassword(String payPassword, boolean isEmpty){
		if(base.isBlock(By.id("paypasswordli"))){System.out.println("支付密码是否为空: " + isEmpty);
			//首次输入需要点击
			if(isEmpty){
				do{
					base.clickWithWait(zzmmTxtByCss);
					base.sleep(2000);
				}while(!base.checkVisible(By.cssSelector("#ppaypassword"),5));//判断是否点击支付密码文本框，否则循环点击
			}
			base.assertEqualsActualExpectedByBoolean(base.isNone(ppaypasswordTxt), false);
			base.sleep(2000);
			base.sendKeysWithWait(ppaypasswordTxt, payPassword);
			base.sleep(2000);
		}
	}
	
	/**
	 * 徐天元
	 * 个人信息完善成功
	 */
	public void isSetInfoOK(){
		//base.assertEqualsActualExpected(base.getElementText(msgTxt), "认证结果：恭喜您！身份认证已成功！");
		base.assertTrueByBoolean(base.getElementText(msgTxt).contains("成功"));
	}
	
	/**
	 * 完善信息的现在去充值
	 * 徐天元
	 */
	public void clickGoRecharge(){
		base.clickWithWait(By.cssSelector(".btn1>input[value='现在去充值']"));
	}
	
	/**
	 * 徐天元
	 * 网银充值
	 */
	public void rechargeCyberBank(String money){
		//选择建设银行
		base.clickWithWait(jianSheNank);//GuangDaBank
		//充值金额
		base.clickWithWait(rechargeTxt);
		base.elementSendkeyNoClear(rechargeTxt, money);
		//充值按钮
		rechargeHandel = base.getCurrentWindowHandle();//System.out.println("父窗口句柄： " + rechargeHandel);//-----测试
		base.clickWithWait(rechargeCyberBtn);
	}
	
	/**
	 * 选择银行  工商ICBC 建设CCB 农业ABC 招商CMB
	 * 徐天元
	 */
	public void selectBank(String type){
		base.clickWithWait(By.cssSelector("#paymentList3 ."+type));
	}
	
	/**
	 * 徐天元
	 * 校验所有银行限额
	 */
	public void checkAllBankLimit(){
		String banks[] = {"ICBC","CCB","ABC","CMB","BOCOM","SPDB","GDB","SDB","HXBC","CIB","CEB","PSBC","CITIC","CMBC","BOC"};
		boolean result = true;
		base.clickWithWait(By.cssSelector(".cpt"));//点击更多充值方式
		for (int i = 0; i < banks.length; i++) {
			selectBank(banks[i]);
			base.clickWithWait(By.cssSelector("#gfb"));//选择国付通
			System.out.println("选择国付通");
			Reporter.log("选择国付通</br>");
			if (!checkBankLimit(banks[i],"gfb")) {
				result = false;
			}
			base.clickWithWait(By.cssSelector("#yib"));//选择易宝支付
			System.out.println("选择易宝支付");
			Reporter.log("选择易宝支付</br>");
			if (banks[i].equals("SPDB") || banks[i].equals("HXBC") || banks[i].equals("CIB")) {
				base.checkAlertText("易宝不支持该银行");
			}else {
				if (!checkBankLimit(banks[i],"ybzf")) {
					result = false;
				}
			}
		}
		base.assertTrueByBoolean(result);
	}
	
	/**
	 * 银行限额是否正确
	 * 徐天元
	 */
	public boolean checkBankLimit(String bank,String type){
		String title[] = null;
		String limit[] =null;
		String id = "";
		/****************国付宝******************/
		//工商ICBC 
		String ICBCTitle[] = {"","办理U盾（一代、二代）","办理静态密码器","办理电子银行口令卡，开通短信认证","办理电子银行口令卡(无需开通短信认证)"};
		String ICBCLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","100万","100万","50万","100万","2000","5000","500","1000","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//建行CCB
		String CCBTitle[] = {"","动态口令卡","短信验证码","文件证书+动态口令卡","二代网银盾","UKEY+动态口令卡"};
		String CCBLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","5000","5000","5000","5000","5000","5000","50万","50万","50万","50万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//农业ABC
		String ABCTitle[] = {" ","动态口令卡用户","移动证书用户(一代)","移动证书用户(二代)"};
		String ABCLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","1000","3000","50万","100万","无限额","无限额","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//招商CMB
		String CMBTitle[] = {"","大众版","专业版"};
		String CMBLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","5000","5000","无限额","无限额","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//交通BOCOM
		String BOCOMTitle[] = {"","手机注册用户","证书认证用户"};
		String BOCOMLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","5万","5万","5万","100万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//浦发SPDB
		String SPDBTitle[] = {"","数字证书用户","动态密码用户"};
		String SPDBLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","无限额","无限额","20万","20万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//广发GDB
		String GDBTitle[] = {"","手机动态验证","Key盾"};
		String GDBLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","柜台开通虚拟类商户单笔、日限额为500元\n非虚拟类商户单笔、日限额为3000元","单柜台开通虚拟类商户单笔、日限额为500元\n非虚拟类商户单笔、日限额为2万元","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//平安SDB
		String SDBTitle[] = {"","动态口令","网银盾"};
		String SDBLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","5万","5万","5万","5万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//华夏HXBC
		String HXBCTitle[] = {"","直接支付","电子钱包签约"};
		String HXBCLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","300","300","5万","10万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//兴业CIB
		String CIBTitle[] = {"","手机短信验证","U盾证书"};
		String CIBLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","单笔限额和单日限额为5000元或者5万元人民币，\n由客户在开通网上支付功能时自行选择","无限额","无限额","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//光大CEB
		String CEBTitle[] = {"","银行卡直接支付手机动态密码网上银行","银行卡直接支付令牌动态密码","网银专业版支付手机动态密码","网银专业版支付令牌动态密码","网银专业版支付阳光网盾"};
		String CEBLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","2万","100万","2万","100万","50万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//邮政PSBC
		String PSBCTitle[] = {"","个人网银短信客户","个人网银UK+短信金卡客户","个人网银UK+短信白金卡、钻石卡客户"};
		String PSBCLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","5万","5万","500万","500万","1000万","1000万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//中信CITIC
		String CITICTitle[] = {"","办理动态口令","办理移动证书","口令+证书","Ukey"};
		String CITICLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","1000","5000","1000","5000","1万","5万","100万","100万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//民生CMBC
		String CMBCTitle[] = {"","短信验证+交易密码","浏览器证书+交易密码","动态令牌（OTP）","贵宾版U宝"};
		String CMBCLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","5000","5000","5000","5000","50万","50万","50万","50万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//中国BOC
		String BOCTitle[] = {"","网银快付","专业版"};
		String BOCLimit[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","1000","5000","5万","50万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		/****************易宝支付******************/
		//工商ICBC 
		String ICBCTitle1[] = {"","柜面注册存量静态密码客户","电子银行口令卡客户（未开通短信认证）","电子银行口令卡客户（开通短信认证）","电子密码器","一代U盾客户（未开通短信认证）","一代U盾客户（开通短信认证）","二代U盾客户","网银互联签约客户"};
		String ICBCLimit1[] = {"单笔限额(元)","300","500","2000","20万","50万","100万","100万","5000"
				,"每日限额(元)","300","1000","5000","100万","100万","100万","100万","5000","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//建行CCB
		String CCBTitle1[] = {"","全部（签约）","动态口令卡（刮刮卡）","短信动态口令","文件证书","二代网银盾","文件证书+刮刮卡","USB Key+动态口令卡","网银高端版","USB Key+短信动态口令","刮刮卡+短信动态口令","USB Key+短信确认","USB Key","音频盾"};
		String CCBLimit1[] = {"单笔限额(元)","50万","5000","5000","0","50万","5000","50万","50万","50万","无限额","50万","50万","无限额"
				,"每日限额(元)","50万","5000","5000","0","50万","5000","50万","50万","50万","无限额","50万","50万","无限额","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//农业ABC
		String ABCTitle1[] = {" ","一代K宝","二代K宝","动态口令卡","K码支付"};
		String ABCLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","50万","100万","100万","500万","1000","1000","1000","3000","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//招商CMB
		String CMBTitle1[] = {"","USBkey","大众版"};
		String CMBLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","无限额","无限额","5000","无限额","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//交通BOCOM
		String BOCOMTitle1[] = {"","USBKey(证书认证版)","短信密码版"};
		String BOCOMLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","100万","100万","5万","5万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//浦发SPDB
		String SPDBTitle1[] = {"","手机动态口令","U盾"};
		String SPDBLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","20万","20万","100亿","100亿","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//广发GDB
		String GDBTitle1[] = {"","USBKey","动态口令","key令"};
		String GDBLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","5000","5000","5000","5000","5000","5000","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//平安SDB
		String SDBTitle1[] = {"","USBKey","动态口令"};
		String SDBLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","5万","5万","5万","5万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//华夏HXBC
		String HXBCTitle1[] = {"","非签约用户","签约用户"};
		String HXBCLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","300","1000","无限额","无限额","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//兴业CIB
		String CIBTitle1[] = {"","证书客户","非证书客户","电子支付卡(e卡)"};
		String CIBLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","无限额","无限额","单笔限额和单日限额为1000元或者5000元人民币，\n由客户在开通网上支付功能时自行选择","5000","5000","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//光大CEB
		String CEBTitle1[] = {"","动态密码","阳光令牌","PUSH支付"};
		String CEBLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","1万","1万","50万","50万","1万","1万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//邮政PSBC
		String PSBCTitle1[] = {"","XXUSBKey","XX动态口令","电子令牌"};
		String PSBCLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"储蓄卡","200万","200万","1万","1万","20万","20万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//中信CITIC
		String CITICTitle1[] = {"","动态口令","USBKey"};
		String CITICLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","1000","5000","100万","100万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//民生CMBC
		String CMBCTitle1[] = {"","大众版(短信验证码)","大众版(浏览器证书)","贵宾版(U宝)","贵宾版(OTP)"};
		String CMBCLimit1[] = {" ","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)","单笔限额(元)","每日限额(元)"
				,"借记卡","5000","5000","5000","5000","50万","50万","50万","50万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		//中国BOC
		String BOCTitle1[] = {"","口令卡&UKEY"};
		String BOCLimit1[] = {" ","单笔限额(元)","每日限额(元)"
				,"借记卡","5万","50万","由于各银行限额随时调整，具体限额请咨询开户银行"};
		switch (bank) {
		case "ICBC":
			if(type.equals("gfb")){
				title=ICBCTitle;
				limit = ICBCLimit;
				id = "bankicbc1";
			}else {
				title=ICBCTitle1;
				limit = ICBCLimit1;
				id = "bankicbc7";
			}
			break;
		case "CCB":
			if(type.equals("gfb")){
				title = CCBTitle;
				limit = CCBLimit;
				id = "bankccb1";
			}else {
				title = CCBTitle1;
				limit = CCBLimit1;
				id = "bankccb7";
			}
			break;
		case "ABC":
			if(type.equals("gfb")){
				title = ABCTitle;
				limit = ABCLimit;
				id = "bankabc1";
			}else {
				title = ABCTitle1;
				limit = ABCLimit1;
				id = "bankabc7";
			}
			break;
		case "CMB":
			if(type.equals("gfb")){
				title = CMBTitle;
				limit = CMBLimit;
				id = "bankcmb1";
			}else {
				title = CMBTitle1;
				limit = CMBLimit1;
				id = "bankcmb7";
			}
			break;
		case "BOCOM":
			if(type.equals("gfb")){
				title = BOCOMTitle;
				limit = BOCOMLimit;
				id = "bankbocom1";
			}else {
				title = BOCOMTitle1;
				limit = BOCOMLimit1;
				id = "bankbocom7";
			}
			break;
		case "SPDB":
			if(type.equals("gfb")){
				title = SPDBTitle;
				limit = SPDBLimit;
				id = "bankspdb1";
			}else {
				title = SPDBTitle1;
				limit = SPDBLimit1;
				id = "bankspdb7";
			}
			break;
		case "GDB":
			if(type.equals("gfb")){
				title = GDBTitle;
				limit = GDBLimit;
				id = "bankgdb1";
			}else {
				title = GDBTitle1;
				limit = GDBLimit1;
				id = "bankgdb7";
			}
			break;
		case "SDB":
			if(type.equals("gfb")){
				title = SDBTitle;
				limit = SDBLimit;
				id = "banksdb1";
			}else {
				title = SDBTitle1;
				limit = SDBLimit1;
				id = "banksdb7";
			}
			break;
		case "HXBC":
			if(type.equals("gfb")){
				title = HXBCTitle;
				limit = HXBCLimit;
				id = "bankhxbc1";
			}else {
				title = HXBCTitle1;
				limit = HXBCLimit1;
				id = "bankhxbc7";
			}
			break;
		case "CIB":
			if(type.equals("gfb")){
				title = CIBTitle;
				limit = CIBLimit;
				id = "bankcib1";
			}else {
				title = CIBTitle1;
				limit = CIBLimit1;
				id = "bankcib7";
			}
			break;
		case "CEB":
			if(type.equals("gfb")){
				title = CEBTitle;
				limit = CEBLimit;
				id = "bankceb1";
			}else {
				title = CEBTitle1;
				limit = CEBLimit1;
				id = "bankceb7";
			}
			break;
		case "PSBC":
			if(type.equals("gfb")){
				title = PSBCTitle;
				limit = PSBCLimit;
				id = "bankpsbc1";
			}else {
				title = PSBCTitle1;
				limit = PSBCLimit1;
				id = "bankpsbc7";
			}
			break;
		case "CITIC":
			if(type.equals("gfb")){
				title = CITICTitle;
				limit = CITICLimit;
				id = "bankcitic1";
			}else {
				title = CITICTitle1;
				limit = CITICLimit1;
				id = "bankcitic7";
			}
			break;
		case "CMBC":
			if(type.equals("gfb")){
				title = CMBCTitle;
				limit = CMBCLimit;
				id = "bankcmbc1";
			}else{
				title = CMBCTitle1;
				limit = CMBCLimit1;
				id = "bankcmbc7";
			}
			break;
		case "BOC":
			if(type.equals("gfb")){
				title = BOCTitle;
				limit = BOCLimit;
				id = "bankboc1";
			}else{
				title = BOCTitle1;
				limit = BOCLimit1;
				id = "bankboc7";
			}
			break;
		default:
			break;
		}
		boolean result = true;
		List<WebElement> titleList = base.getElements(By.cssSelector("#"+id+">.new th"));
		for (int i = 0; i < title.length; i++) {
			try {
				base.assertEqualsActualExpected(titleList.get(i).getText(), title[i]);
			} catch (AssertionError e) {
				result = false;
				System.out.println(bank+",title,"+(i+1)+"失败，期盼："+title[i]+",实际："+titleList.get(i).getText());
				Reporter.log(bank+",title,"+(i+1)+"失败，期盼："+title[i]+",实际："+titleList.get(i).getText()+"</br>");
			}
		}
		List<WebElement> limitList = base.getElements(By.cssSelector("#"+id+">.new td"));
		for (int i = 0; i < limit.length; i++) {
			try {
				base.assertEqualsActualExpected(limitList.get(i).getText(), limit[i]);
			} catch (AssertionError e) {
				result = false;
				System.out.println(bank+",limit,"+(i+1)+"失败，期盼："+limit[i]+",实际："+limitList.get(i).getText());
				Reporter.log(bank+",limit,"+(i+1)+"失败，期盼："+limit[i]+",实际："+limitList.get(i).getText());
			}
		}
		return result;
	}
	
	/**
	 * 校验提示银行充值
	 * @param money
	 * @author 江渤洋 2015-9-2
	 */
	public void checkPromptMsgOfBank(String money){
		//充值金额
		base.clickWithWait(rechargeTxt);
		base.elementSendkeyNoClear(rechargeTxt, money);
		base.clickWithWait(rechargeCyberBtn);
		base.checkAlert();
		String actual = base.getTextByAlert();
		try {
			base.assertEqualsActualExpected(actual, "请选择在线充值方式！");
		} catch (Exception e) {
			Reporter.log("未选银行，输入金额，应提示：‘请选择在线充值方式！’；但提示:‘" + actual + "’");
			System.out.println("未选银行，输入金额，应提示：‘请选择在线充值方式！’；但提示:‘" + actual + "’");
		}
		finally{		
			base.sleep(1000);
			base.acceptAlert();
		}
	}
	
	/**
	 * 校验提示金额充值
	 * @author 江渤洋 2015-9-2
	 */
	public void checkPromptMsgOfMoney(){
		//选择建设银行
		base.clickWithWait(jianSheNank);
		base.clickWithWait(rechargeCyberBtn);
		base.sleep(3000);
		String actual = base.getTextByAlert();
		base.assertEqualsActualExpected(actual, "请输入您要充值的金额！");
		base.acceptAlert();
	}
	
	/**
	 * 校验大写金额
	 * @param money
	 * @author 江渤洋 2015-9-2
	 */
	public void checkCapitalOfMoney(String money){
		//选择建设银行
		base.clickWithWait(jianSheNank);
		//充值金额
		base.clickWithWait(rechargeTxt);
		base.elementSendkeyNoClear(rechargeTxt, money);
		String capital = base.getElementTextWithWait(By.cssSelector("#withdraw_zh_balance"));
		base.assertEqualsActualExpected(capital, "壹分");
	}
	
	/**
	 * 校验进入银行页面
	 * @author 江渤洋 2015-9-2
	 */
	public void checkBankPage(){
		String parentWindowHandle = base.getCurrentWindowHandle();
		base.clickWithWait(rechargeCyberBtn);
		base.sleep(2000);
		String childWindowHandle = base.getChildWindowHandle(parentWindowHandle);
		base.jumpToWindow(childWindowHandle);
		base.sleep(2000);//会先跳转至易宝支付，再跳转至中国建设银行。易宝支付页面获取不到
		boolean isTitleOK = base.checkTitleContains("中国建设银行");
		base.closeAndjumptoOldWindow();
		//温馨提示DIV
		base.assertEqualsActualExpectedByBoolean(base.isElementContainsValue(By.cssSelector("#paytip"), "style", "block"), true);
		//点击“已完成充值”
		base.clickWithWait(By.cssSelector(".btn-fc.btn-cp"));
		String actual = base.getTextByAlert();
		base.assertEqualsActualExpected(actual, "充值未成功或未完成,请完成充值!");
		base.acceptAlert();
		base.assertTrueByBoolean(isTitleOK);
	}
	
	/**
	 * 徐天元
	 * 验证进入建设银行界面
	 */
	public void isJianShePage(){
		jianSheHandel = base.getChildWindowHandle(rechargeHandel);
		base.jumpToWindow(jianSheHandel);
		System.out.println("1:"+rechargeHandel+"\n2:"+jianSheHandel);
//		base.assertEqualsActualExpected(base.getPageTitle(), "中国光大银行_网上银行");
		boolean titleResult = base.checkTitleContains("中国建设银行 个人网上银行");
		base.closeWindow(jianSheHandel);
		//回到充值页  关掉温馨提示窗口
		base.jumpToWindow(rechargeHandel);
		base.sleep(2000);
		base.clickWithWait(promptCloseBtn);
		base.assertTrueByBoolean(titleResult);//中国光大银行_网上银行
	}
}
