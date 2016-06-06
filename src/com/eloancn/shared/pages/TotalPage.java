package com.eloancn.shared.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.PageTitles;

public abstract class TotalPage {

	static Base base = new Base();
	
	
	static By nextBtn = By.xpath("//li[text()='>']");		//��һҳ��ť
	static By nextTd = By.xpath("//td[@id='next']");		//��һҳ��ť��Td��ǩ
	
	/**
	 * ����ĳҳ��
	 * @param pageName ҳ������
	 * @param isLogin �Ƿ��¼��true:��¼��false��δ��¼
	 * @author ������ 2015-12-16
	 */
	public static void openPage(String pageName, boolean isLogin){
		
		String url = "",pageTitle = "";
		
		switch (pageName) {
		case "��ҳ":			pageTitle = PageTitles.shouYe;			break;
		case "��汦�б�ҳ":	url = "/new/loadAllWmpsRecords.action";
							pageTitle = PageTitles.yiCunBao;		break;
		case "Ͷ���б�":		url = "/new/loadAllTender.action";
							pageTitle = PageTitles.touZiLieBiao;	break;
		case "�ҵ��˻�":		url = "/page/userMgr/myHome.jsp";
							if(isLogin){
								pageTitle = PageTitles.woDeZhangHu;
							}
							else {
								pageTitle = PageTitles.huiYuanDengLu;
							}
							break;
		default:			pageTitle = PageTitles.shouYe;			break;
		}
		base.openBrowser(base.indexURL + url);
		base.isTitle(pageTitle);
	}
	
	/**
	 * ��ҳ��������
	 * @param listBy �����ֶμ���
	 * @param searchField �����ֶ�
	 * @return true �����ֶδ��ڣ�false �����ֶβ�����
	 * @author ������ 2016-1-6
	 */
	public static boolean isSearchFieldByList(By listBy, String searchField){
		
		boolean isTrue = false;				//�Ƿ����
		String tempNameString = "";
		List<WebElement> fieldList = null;	//�������ֶ��б�
		
		System.out.println("\n-------------��ʼ_��ҳ����----------------\n");//------------����
		do{
			fieldList = new ArrayList<WebElement>();
			fieldList = base.getVisibleElements(listBy);
			int size = fieldList.size();
			//����ҵ���ͬ����������ѭ��
			for(int i = 0; i < size; i++){
				tempNameString = base.getElementTextWithWait(fieldList.get(i));
				if(searchField.equals(tempNameString)){
					isTrue = true;
				}
			}
			//�����ҳû�У������һҳ
			if(!isTrue){
				//�жϵ�ǰҳ�Ƿ������һҳ������һҳ��ť�Ƿ�����;trueΪ���أ�falseΪ��ʾ
				if(base.isElementContainsValue(nextBtn, "class", "pgEmpty")){
					System.out.println("error_��ҳ���ң�û���ҵ�");
					Reporter.log("error_��ҳ���ң�û���ҵ�");
					break;
				}
				else{
					base.clickWithWait(nextBtn);
				}
			}
			base.sleep(3000);
		}while(!isTrue);

		System.out.println("\n-------------����_��ҳ����----------------\n");//------------����
		return isTrue;
	}

}
