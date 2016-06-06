package com.eloancn.shared.pages;

import org.openqa.selenium.By;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.common.PageTitles;

/**
 *	������ˣ���ҳ����>��Ҫ���ˣ�
 */
public class JoinInPage {
	
	Base base = new Base();
	Data data = new Data();

	/*********************************/
	/**********   ���������          **********/
	/*********************************/
	
	By name = By.cssSelector("#name");						//��������
	By tel = By.cssSelector("#mobile");						//���ĵ绰
	By level = By.cssSelector(".rad>label>input");			//���ļ�������㼶(���������м���Ӫ���ġ����ؼ����̡������Ʒ )
	By province = By.cssSelector("#province");				//���ļ�����������_ʡ
	By city = By.cssSelector("#city");						//���ļ�����������_��
	By county = By.cssSelector("#county");					//���ļ�����������_��
	By refereeMobile = By.cssSelector("#refereeMobile");	//�Ƽ����ֻ���
	By joinInBtn = By.cssSelector(".sqjm");					//��������ˡ���ť
	
	/**
	 * ��д����������Ϣ
	 */
	public void inputJoinInInfo(){
		
		base.sendKeysWithWait(name, data.getFullName());
		base.sendKeysWithWait(tel, data.phoneConcatenation(3));
		clickLevel("���ؼ�����");
		base.elementSelectByIndex(province, 1);
		base.elementSelectByIndex(city, 1);
		base.elementSelectByIndex(county, 1);
		base.sendKeysWithWait(refereeMobile, data.phoneConcatenation(3));
	}
	
	/**
	 * ��������ļ�������㼶����ѡ��ť
	 * @param name �㼶����(���������м���Ӫ���ġ����ؼ����̡������Ʒ )
	 */
	public void clickLevel(String name){
		
		int index = 0;
		switch (name) {
		case "���м���Ӫ����":	index = 0;break;
		case "���ؼ�����":		index = 1;break;	
		case "�����Ʒ ":		index = 2;break;
		default:			index = 1;break;
		}
		base.clickElementVisibleByIndex(level, index);
	}
	
	/**
	 * �������Ҫ���ˡ���ť
	 */
	public void clickJoinInBtn(){
		
		base.clickWithWait(joinInBtn);
	}
	
	/**
	 * У���ύ������Ϣ����ת�Ƿ�������δ��¼��
	 */
	public void checkJoinInInfoJumpNoLogin(){
		inputJoinInInfo();
		clickJoinInBtn();
		base.isTitle(PageTitles.huiYuanDengLu);
	}
}
