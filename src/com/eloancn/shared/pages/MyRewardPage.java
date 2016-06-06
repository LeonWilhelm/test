package com.eloancn.shared.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.until.DESUtils;

/**
 * “我的账户”-“我的奖励”页面
 */
public class MyRewardPage {
	
	Base base = new Base();
	DBData dbData = new DBData();

	public static By MyRedPacksLnk = By.cssSelector("span.current.wd110");	//“我的红包”
	By MyExperiencesLnk = By.cssSelector("span.wd140");						//“我的体验金”
	By MyDeductions = By.xpath("//span[3]");								//“我的抵扣券”
	
	By interestrate = By.cssSelector("#realInterestrate_1665");                              //年华收益
	By phases = By.cssSelector("#wmpslistdiv td[width='20%']:nth-of-type(2) > .shuzib");     //锁定期限
	By amount = By.cssSelector("#wmpslistdiv td:nth-of-type(3) > .shuzib");            //已募集金额
	
	By expInvestmentBtn = By.cssSelector("#createExpRecord");                                //体验投资按钮
	By okBtn = By.cssSelector("#successbtn>input");                                          //确定按钮

	By rolesByWeb = By.xpath("//div[@class='red_pack_rule']/p");                           //体验金规则
	
	/**
	 * 判断是否进入“我的奖励”页面
	 * @author 江渤洋 2015-8-31
	 */
	public void isMyRewardPage(){
		base.assertEqualsActualExpectedByBoolean(base.isElementVisible(MyRedPacksLnk),true);
	}
	
	/**
	 * 点击“我的体验金”
	 * @author 江渤洋 2015-8-31
	 */
	public void clickMyExperiencesLnk(){
		base.clickWithWait(MyExperiencesLnk);
	}
	
	/**
	 * 校验显示体验金额记录
	 * @author 江渤洋 2015-8-31
	 */
	public void checkMyExperiencesOfData(){
		try {
			base.isElementVisible(By.cssSelector(".red_pack_list"));
		} catch (Exception e) {
			Reporter.log("我的账户_P2：我的账户——>我的奖励——>“我的体验金”没有数据");
		}
	}
	
	/**
	 * 获取“我的体验金”列表中的元素
	 * @param name:列名称
	 * @return 列中值的对象
	 * @author 江渤洋 2015-8-31
	 */
	public By getMyExperiencesOfBy(String name){
		
		String index = "";
		By by = null;
		switch (name) {
		case "名称":index = "(1)";break;
		case "金额":index = "(2)";break;
		case "有效截止日":index = "(3)";break;
		case "状态_有效":index = "(4) > span";break;
		case "状态_失效":index = "(4) > span";break;
		case "状态_已使用":index = "(4)";break;
		case "操作_马上使用":index = "(5) > a";break;
		case "操作_--":index = "(5)";break;
		default:
			break;
		}
		by = By.cssSelector(".red_pack_list tr.bgF1 > td:nth-of-type" + index);
		return by;
	}
	
	/**
	 * 根据手机号，查询用户注册时间
	 * @param phoneNumber：手机号
	 * @return 返回用户注册时间
	 */
	public long getUserCreateTime(String phoneNumber){
		long createTime = 0L;
		//手机号DES加密
		phoneNumber = DESUtils.getEncryptString(phoneNumber);
		createTime = Long.parseLong(dbData.selectUserCreateTime(phoneNumber));
		//数据库存储Unix时间戳，转成普通时间需乘以1000
		createTime *= 1000;
		return createTime;
	}
	
	/**
	 * 校验“有效截止日”是否为用户注册时间的第二天延迟30天
	 * @param phoneNumber:手机号码
	 */
	public void checkEffectiveClosingDate(String phoneNumber){
		
		int day = 0;
		//我的体验金的“有效截止日”
		long effectiveClosingDateLong = 0L;
		String effectiveClosingDate = "";
		//用户注册日期
		long createDateLong = 0L;

		//获取“有效截止日”
		effectiveClosingDate = base.getElementTextWithWait(getMyExperiencesOfBy("有效截止日"));
		effectiveClosingDateLong = base.getMilliseconds(effectiveClosingDate, "yyyy-MM-dd");//System.out.println("有效截止日: " + effectiveClosingDateLong);//--------测试
		//获取“用户注册日期”
		createDateLong = getUserCreateTime(phoneNumber);//System.out.println("用户注册日期: " + createDateLong);//--------测试
		long between_days=(effectiveClosingDateLong-createDateLong)/(1000*3600*24) + 1;  
        day = Integer.parseInt(String.valueOf(between_days)); 
		base.assertEqualsActualExpectedByInt(day, 30);
	}
	
	//点击“马上使用”按钮
	public void clickOperation(){
		base.clickWithWait(getMyExperiencesOfBy("操作_马上使用"));
	}
	
	/**
	 * 判断体验期翼存宝记录是否显示，且只显示一条
	 * @author 江渤洋 2015-9-1
	 */
	public void isWMPSListDivShowAndOnlyOne(){
		
		List<WebElement> list = null;
		boolean isShow = false;
		isShow = base.isElementContainsValue(By.cssSelector("#wmpslistdiv"), "style", "block");//System.out.println(isShow);//----测试
		base.assertEqualsActualExpectedByBoolean(isShow, true);
		list = base.getElements(By.cssSelector("#wmpslistdiv tr[valign='bottom']"));//System.out.println(list.size());//----测试
		base.assertEqualsActualExpectedByInt(list.size(), 1);
	}
	
	/**
	 * 校验“我的体验金”列表中的元素(名称,金额)
	 * @author 江渤洋 2015-8-31
	 */
	public void checkMyExperiencesOfValue(){

		By element = null;
		String[] name = {"名称","金额"};
		String[] value = {"新用户体验金","10000.00"};
		int nameLength = name.length;
		for(int index = 0; index < nameLength; index++){
			element = getMyExperiencesOfBy(name[index]);
			base.assertEqualsActualExpected(base.getElementTextWithWait(element), value[index]);
		}
	}
	
	/**
	 * 校验“我的体验金”列表中的元素(状态,操作)
	 * 备注：颜色未校验，后期添加
	 * @param flag 1为已投资，0为未投资
	 * @author 江渤洋 2015-9-1
	 */
	public void checkMyExperiencesOfValue(int flag){
		
		By element = null;
		if(flag == 1){
			//已投资
			String[] nameByInvestment = {"状态_已使用","操作_--"};
			String[] valueByInvestment = {"已使用","--"};
			int nameLength = nameByInvestment.length;
			for(int index = 0; index < nameLength; index++){
				element = getMyExperiencesOfBy(nameByInvestment[index]);
				base.assertEqualsActualExpected(base.getElementTextWithWait(element), valueByInvestment[index]);
			}
		}
		else if(flag == 0){
			//未投资
			String[] nameByNoInvestment = {"状态_有效","操作_马上使用"};
			String[] valueByNoInvestment = {"有效","马上使用"};
			int nameLength = nameByNoInvestment.length;
			for(int index = 0; index < nameLength; index++){
				element = getMyExperiencesOfBy(nameByNoInvestment[index]);
				base.assertEqualsActualExpected(base.getElementTextWithWait(element), valueByNoInvestment[index]);
			}
		}
		else{
			System.out.println("体验期的翼存宝中标记输入有误，请重新输入");
		}
	}
	
	//校验“年化收益”、“锁定期限”、“已募集金额”
	public void checkExperiencePeriodECunBao(){
		
		HashMap<String, String> map = new HashMap<String, String>();
		//年化收益
		String interestrateByData = "";
		Double interestrateDouble = 0.0;
		//锁定期限
		String phasesByData = "";
		//已募集金额
		String amountByData = "";
		
		String interestrateByWeb = "";
		String phasesByWeb = "";
		String amountByWeb = "";
		//数据库获取值
		
		map = dbData.getExperiencePeriodECunBao();
		if(!map.isEmpty()){
			interestrateByData = map.get("interestrate");
			interestrateDouble = Double.valueOf(interestrateByData) * 100;
			interestrateByData = interestrateDouble.intValue() + "";
			phasesByData = map.get("phases");
			amountByData = map.get("amount");
			if(amountByData==null){
				amountByData = "0.00";
			}
			amountByData = amountByData.substring(0, amountByData.indexOf("."));
			if(!amountByData.equals("0")){
				amountByData = (Integer.parseInt(amountByData) / 10000) + "";
			}
		}
		//前台获取值
		interestrateByWeb = base.getElementTextWithWait(interestrate);
		interestrateByWeb = interestrateByWeb.substring(0, interestrateByWeb.indexOf("%"));
		phasesByWeb = base.getElementTextWithWait(phases);
		amountByWeb = base.getElementTextWithWait(amount);
		amountByWeb = amountByWeb.substring(0, amountByWeb.indexOf("/"));
		
		base.assertEqualsActualExpected(interestrateByData, interestrateByWeb);
		base.assertEqualsActualExpected(phasesByData, phasesByWeb);
		base.assertEqualsActualExpected(amountByData, amountByWeb);
	}
	
	/**
	 * 校验“体验投资”成功
	 */
	public void checkExperienceInvestment(){
		
		String msg = "";
		
		base.clickWithWait(expInvestmentBtn);
		base.sleep(1000);
		msg = base.getElementText(By.cssSelector("#msg"));
		base.assertEqualsActualExpected(msg, "恭喜！投资成功");
		base.clickWithWait(okBtn);
		base.sleep(3000);
		
	}
	
	/**
	 * 体验期翼存宝规则
	 * @author 江渤洋 2015-9-2
	 */
	public void checkExperiencePeriodRule(){
		
		String[] rules = {"体验金规则:","1、体验金自领取之日起30日内有效，过期作废;","2、无需充值可以直接投资体验期翼存宝;","3、每位新注册用户只可投资一期体验期翼存宝;","4、理财结束后10000元体验金将由系统收回，收益可提现.","5、每天募集金额以当天发布的募集金额为准."};
		List<WebElement> listEle = new ArrayList<WebElement>();
		listEle = base.getElements(rolesByWeb);
		int size = listEle.size();
		if(size == rules.length){
			for(int i = 0; i < size; i++){
				base.assertEqualsActualExpected(base.getElementTextWithWait(listEle.get(i)), rules[i]);
			}
		}
		else{
			Reporter.log("体验金规则条数错误!");
			System.out.println("体验金规则条数错误!");
			base.assertTrueByBoolean(false);
		}
	}
}










