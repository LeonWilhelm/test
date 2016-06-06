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
 * ���ҵ��˻���-���ҵĽ�����ҳ��
 */
public class MyRewardPage {
	
	Base base = new Base();
	DBData dbData = new DBData();

	public static By MyRedPacksLnk = By.cssSelector("span.current.wd110");	//���ҵĺ����
	By MyExperiencesLnk = By.cssSelector("span.wd140");						//���ҵ������
	By MyDeductions = By.xpath("//span[3]");								//���ҵĵֿ�ȯ��
	
	By interestrate = By.cssSelector("#realInterestrate_1665");                              //�껪����
	By phases = By.cssSelector("#wmpslistdiv td[width='20%']:nth-of-type(2) > .shuzib");     //��������
	By amount = By.cssSelector("#wmpslistdiv td:nth-of-type(3) > .shuzib");            //��ļ�����
	
	By expInvestmentBtn = By.cssSelector("#createExpRecord");                                //����Ͷ�ʰ�ť
	By okBtn = By.cssSelector("#successbtn>input");                                          //ȷ����ť

	By rolesByWeb = By.xpath("//div[@class='red_pack_rule']/p");                           //��������
	
	/**
	 * �ж��Ƿ���롰�ҵĽ�����ҳ��
	 * @author ������ 2015-8-31
	 */
	public void isMyRewardPage(){
		base.assertEqualsActualExpectedByBoolean(base.isElementVisible(MyRedPacksLnk),true);
	}
	
	/**
	 * ������ҵ������
	 * @author ������ 2015-8-31
	 */
	public void clickMyExperiencesLnk(){
		base.clickWithWait(MyExperiencesLnk);
	}
	
	/**
	 * У����ʾ�������¼
	 * @author ������ 2015-8-31
	 */
	public void checkMyExperiencesOfData(){
		try {
			base.isElementVisible(By.cssSelector(".red_pack_list"));
		} catch (Exception e) {
			Reporter.log("�ҵ��˻�_P2���ҵ��˻�����>�ҵĽ�������>���ҵ������û������");
		}
	}
	
	/**
	 * ��ȡ���ҵ�������б��е�Ԫ��
	 * @param name:������
	 * @return ����ֵ�Ķ���
	 * @author ������ 2015-8-31
	 */
	public By getMyExperiencesOfBy(String name){
		
		String index = "";
		By by = null;
		switch (name) {
		case "����":index = "(1)";break;
		case "���":index = "(2)";break;
		case "��Ч��ֹ��":index = "(3)";break;
		case "״̬_��Ч":index = "(4) > span";break;
		case "״̬_ʧЧ":index = "(4) > span";break;
		case "״̬_��ʹ��":index = "(4)";break;
		case "����_����ʹ��":index = "(5) > a";break;
		case "����_--":index = "(5)";break;
		default:
			break;
		}
		by = By.cssSelector(".red_pack_list tr.bgF1 > td:nth-of-type" + index);
		return by;
	}
	
	/**
	 * �����ֻ��ţ���ѯ�û�ע��ʱ��
	 * @param phoneNumber���ֻ���
	 * @return �����û�ע��ʱ��
	 */
	public long getUserCreateTime(String phoneNumber){
		long createTime = 0L;
		//�ֻ���DES����
		phoneNumber = DESUtils.getEncryptString(phoneNumber);
		createTime = Long.parseLong(dbData.selectUserCreateTime(phoneNumber));
		//���ݿ�洢Unixʱ�����ת����ͨʱ�������1000
		createTime *= 1000;
		return createTime;
	}
	
	/**
	 * У�顰��Ч��ֹ�ա��Ƿ�Ϊ�û�ע��ʱ��ĵڶ����ӳ�30��
	 * @param phoneNumber:�ֻ�����
	 */
	public void checkEffectiveClosingDate(String phoneNumber){
		
		int day = 0;
		//�ҵ������ġ���Ч��ֹ�ա�
		long effectiveClosingDateLong = 0L;
		String effectiveClosingDate = "";
		//�û�ע������
		long createDateLong = 0L;

		//��ȡ����Ч��ֹ�ա�
		effectiveClosingDate = base.getElementTextWithWait(getMyExperiencesOfBy("��Ч��ֹ��"));
		effectiveClosingDateLong = base.getMilliseconds(effectiveClosingDate, "yyyy-MM-dd");//System.out.println("��Ч��ֹ��: " + effectiveClosingDateLong);//--------����
		//��ȡ���û�ע�����ڡ�
		createDateLong = getUserCreateTime(phoneNumber);//System.out.println("�û�ע������: " + createDateLong);//--------����
		long between_days=(effectiveClosingDateLong-createDateLong)/(1000*3600*24) + 1;  
        day = Integer.parseInt(String.valueOf(between_days)); 
		base.assertEqualsActualExpectedByInt(day, 30);
	}
	
	//���������ʹ�á���ť
	public void clickOperation(){
		base.clickWithWait(getMyExperiencesOfBy("����_����ʹ��"));
	}
	
	/**
	 * �ж���������汦��¼�Ƿ���ʾ����ֻ��ʾһ��
	 * @author ������ 2015-9-1
	 */
	public void isWMPSListDivShowAndOnlyOne(){
		
		List<WebElement> list = null;
		boolean isShow = false;
		isShow = base.isElementContainsValue(By.cssSelector("#wmpslistdiv"), "style", "block");//System.out.println(isShow);//----����
		base.assertEqualsActualExpectedByBoolean(isShow, true);
		list = base.getElements(By.cssSelector("#wmpslistdiv tr[valign='bottom']"));//System.out.println(list.size());//----����
		base.assertEqualsActualExpectedByInt(list.size(), 1);
	}
	
	/**
	 * У�顰�ҵ�������б��е�Ԫ��(����,���)
	 * @author ������ 2015-8-31
	 */
	public void checkMyExperiencesOfValue(){

		By element = null;
		String[] name = {"����","���"};
		String[] value = {"���û������","10000.00"};
		int nameLength = name.length;
		for(int index = 0; index < nameLength; index++){
			element = getMyExperiencesOfBy(name[index]);
			base.assertEqualsActualExpected(base.getElementTextWithWait(element), value[index]);
		}
	}
	
	/**
	 * У�顰�ҵ�������б��е�Ԫ��(״̬,����)
	 * ��ע����ɫδУ�飬�������
	 * @param flag 1Ϊ��Ͷ�ʣ�0ΪδͶ��
	 * @author ������ 2015-9-1
	 */
	public void checkMyExperiencesOfValue(int flag){
		
		By element = null;
		if(flag == 1){
			//��Ͷ��
			String[] nameByInvestment = {"״̬_��ʹ��","����_--"};
			String[] valueByInvestment = {"��ʹ��","--"};
			int nameLength = nameByInvestment.length;
			for(int index = 0; index < nameLength; index++){
				element = getMyExperiencesOfBy(nameByInvestment[index]);
				base.assertEqualsActualExpected(base.getElementTextWithWait(element), valueByInvestment[index]);
			}
		}
		else if(flag == 0){
			//δͶ��
			String[] nameByNoInvestment = {"״̬_��Ч","����_����ʹ��"};
			String[] valueByNoInvestment = {"��Ч","����ʹ��"};
			int nameLength = nameByNoInvestment.length;
			for(int index = 0; index < nameLength; index++){
				element = getMyExperiencesOfBy(nameByNoInvestment[index]);
				base.assertEqualsActualExpected(base.getElementTextWithWait(element), valueByNoInvestment[index]);
			}
		}
		else{
			System.out.println("�����ڵ���汦�б��������������������");
		}
	}
	
	//У�顰�껯���桱�����������ޡ�������ļ����
	public void checkExperiencePeriodECunBao(){
		
		HashMap<String, String> map = new HashMap<String, String>();
		//�껯����
		String interestrateByData = "";
		Double interestrateDouble = 0.0;
		//��������
		String phasesByData = "";
		//��ļ�����
		String amountByData = "";
		
		String interestrateByWeb = "";
		String phasesByWeb = "";
		String amountByWeb = "";
		//���ݿ��ȡֵ
		
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
		//ǰ̨��ȡֵ
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
	 * У�顰����Ͷ�ʡ��ɹ�
	 */
	public void checkExperienceInvestment(){
		
		String msg = "";
		
		base.clickWithWait(expInvestmentBtn);
		base.sleep(1000);
		msg = base.getElementText(By.cssSelector("#msg"));
		base.assertEqualsActualExpected(msg, "��ϲ��Ͷ�ʳɹ�");
		base.clickWithWait(okBtn);
		base.sleep(3000);
		
	}
	
	/**
	 * ��������汦����
	 * @author ������ 2015-9-2
	 */
	public void checkExperiencePeriodRule(){
		
		String[] rules = {"��������:","1�����������ȡ֮����30������Ч����������;","2�������ֵ����ֱ��Ͷ����������汦;","3��ÿλ��ע���û�ֻ��Ͷ��һ����������汦;","4����ƽ�����10000Ԫ�������ϵͳ�ջأ����������.","5��ÿ��ļ������Ե��췢����ļ�����Ϊ׼."};
		List<WebElement> listEle = new ArrayList<WebElement>();
		listEle = base.getElements(rolesByWeb);
		int size = listEle.size();
		if(size == rules.length){
			for(int i = 0; i < size; i++){
				base.assertEqualsActualExpected(base.getElementTextWithWait(listEle.get(i)), rules[i]);
			}
		}
		else{
			Reporter.log("����������������!");
			System.out.println("����������������!");
			base.assertTrueByBoolean(false);
		}
	}
}










