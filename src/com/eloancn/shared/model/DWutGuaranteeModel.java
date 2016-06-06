package com.eloancn.shared.model;

/**
 * 在后保证人实体类
 */
public class DWutGuaranteeModel {
	
	String id;
	String name;
	String layer;		//法人
	String idCard;
	String addr;		//户籍地址
	String curAddr;		//现住所地址（地址）
	String mobile;
	String email;
	String type;		//类型：1为自然人，2为法人
	String tid;
	
	public DWutGuaranteeModel(){
		
	}
	
	/**
	 * 自然人构造函数
	 * @param name		姓名
	 * @param idCard	身份证号
	 * @param addr		户籍地址
	 * @param curAddr	现住所地址
	 * @param mobile	联系电话
	 * @param email		联系邮箱
	 * @param type		在后保证人类型
	 */
	public DWutGuaranteeModel(String name, String idCard, String addr, String curAddr, String mobile, String email, String type) {
		super();
		this.name = name;
		this.idCard = idCard;
		this.addr = addr;
		this.curAddr = curAddr;
		this.mobile = mobile;
		this.email = email;
		this.type = type;
	}
	
	/**
	 * 法人构造函数
	 * @param name 		名称
	 * @param layer		法定代表人
	 * @param curAddr	地址
	 * @param mobile	联系电话
	 * @param email		联系邮箱
	 * @param type		在后保证人类型
	 */
	public DWutGuaranteeModel(String name, String layer, String curAddr, String mobile, String email, String type) {
		super();
		this.name = name;
		this.layer = layer;
		this.curAddr = curAddr;
		this.mobile = mobile;
		this.email = email;
		this.type = type;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCurAddr() {
		return curAddr;
	}

	public void setCurAddr(String curAddr) {
		this.curAddr = curAddr;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

}
