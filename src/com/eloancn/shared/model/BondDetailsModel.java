package com.eloancn.shared.model;

/**
 *	��汦��ծȨ����(�Զ���)
 */
public class BondDetailsModel {
	

	String borrowName;		//���������
	String idCard;			//���֤��
	String address;			//��ַ
	String borrowMoney;		//����ܶ�
	String borrowPurpose;	//�����;
	
	
	
	public BondDetailsModel() {
	}

	public BondDetailsModel(String borrowName, String idCard, String address,
			String borrowMoney, String borrowPurpose) {
		super();
		this.borrowName = borrowName;
		this.idCard = idCard;
		this.address = address;
		this.borrowMoney = borrowMoney;
		this.borrowPurpose = borrowPurpose;
	}
	
	public String getBorrowName() {
		return borrowName;
	}
	public void setBorrowName(String borrowName) {
		this.borrowName = borrowName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBorrowMoney() {
		return borrowMoney;
	}
	public void setBorrowMoney(String borrowMoney) {
		this.borrowMoney = borrowMoney;
	}
	public String getBorrowPurpose() {
		return borrowPurpose;
	}
	public void setBorrowPurpose(String borrowPurpose) {
		this.borrowPurpose = borrowPurpose;
	}

	
	

}
