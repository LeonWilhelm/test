package com.eloancn.shared.model;

/**
 *	翼存宝，债权详情(自定义)
 */
public class BondDetailsModel {
	

	String borrowName;		//借款人姓名
	String idCard;			//身份证号
	String address;			//地址
	String borrowMoney;		//借款总额
	String borrowPurpose;	//借款用途
	
	
	
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
