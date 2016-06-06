package com.eloancn.shared.model;

/**
 * �ں�֤��ʵ����
 */
public class DWutGuaranteeModel {
	
	String id;
	String name;
	String layer;		//����
	String idCard;
	String addr;		//������ַ
	String curAddr;		//��ס����ַ����ַ��
	String mobile;
	String email;
	String type;		//���ͣ�1Ϊ��Ȼ�ˣ�2Ϊ����
	String tid;
	
	public DWutGuaranteeModel(){
		
	}
	
	/**
	 * ��Ȼ�˹��캯��
	 * @param name		����
	 * @param idCard	���֤��
	 * @param addr		������ַ
	 * @param curAddr	��ס����ַ
	 * @param mobile	��ϵ�绰
	 * @param email		��ϵ����
	 * @param type		�ں�֤������
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
	 * ���˹��캯��
	 * @param name 		����
	 * @param layer		����������
	 * @param curAddr	��ַ
	 * @param mobile	��ϵ�绰
	 * @param email		��ϵ����
	 * @param type		�ں�֤������
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
