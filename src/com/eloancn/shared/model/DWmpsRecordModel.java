package com.eloancn.shared.model;

/**
 * ��汦��¼��ʵ����
 */
public class DWmpsRecordModel {
	
	String id;
	String wid;
	String title;
	String amount;
	String maxAmount;
	String interestrate;
	String valitime;
	String status;
	String type;
	String phasesType;
	String phases;
	String buyType;
	String cdate;
	String publisheddate;
	String finisheddate;
	String interdate;
	String enddate;
	String progress;
	String description;
	String chirldType;
	String firstInter;
	String secInter;
	String effectAmount;
	String experience;
	String version;
	
	public DWmpsRecordModel(){
		
	}
	
	/**
	 * ������汦���캯��
	 * @param title			 ��汦���ƣ�����+����ʱ�䣬���磺auto0104161935��
	 * @param maxAmount		 ������������磺10000��
	 * @param interestrate	 �������ʣ����磺0.125��
	 * @param valitime		 ������Ч�ڣ���λСʱ�����磺1��
	 * @param phases		 ��Լ���ޣ��������ޣ�����7/30/90/365/720��
	 * @param cdate			 �������ڣ����磺1451911350��
	 * @param publisheddate	 ��������
	 * @param interdate		 ��Ϣ���ڣ��������� + ������Ч�ڣ�
	 * @param enddate		 �������ڣ���Ϣ���� + ��Լ���ޣ�
	 */
	public DWmpsRecordModel(String title, String maxAmount, String interestrate, String valitime, String phases, String cdate, String publisheddate, String interdate, String enddate) {
		super();
		this.wid = "0";
		this.title = title;
		this.amount = "NULL";
		this.maxAmount = maxAmount + ".00";
		this.interestrate = interestrate;
		this.valitime = valitime;
		this.status = "1";
		this.type = "2";
		this.phasesType = "1";
		this.phases = phases;
		this.buyType = "2";
		this.cdate = cdate;
		this.publisheddate = publisheddate;
		this.finisheddate = "NULL";
		this.interdate = interdate;
		this.enddate = enddate;
		this.progress = "NULL";
		this.description = "NULL";
		this.chirldType = "NULL";
		this.firstInter = "NULL";
		this.secInter = "NULL";
		this.effectAmount = "NULL";
		this.experience = "NULL";
		this.version = "0";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(String maxAmount) {
		this.maxAmount = maxAmount;
	}
	public String getInterestrate() {
		return interestrate;
	}
	public void setInterestrate(String interestrate) {
		this.interestrate = interestrate;
	}
	public String getValitime() {
		return valitime;
	}
	public void setValitime(String valitime) {
		this.valitime = valitime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhasesType() {
		return phasesType;
	}
	public void setPhasesType(String phasesType) {
		this.phasesType = phasesType;
	}
	public String getPhases() {
		return phases;
	}
	public void setPhases(String phases) {
		this.phases = phases;
	}
	public String getBuyType() {
		return buyType;
	}
	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getPublisheddate() {
		return publisheddate;
	}
	public void setPublisheddate(String publisheddate) {
		this.publisheddate = publisheddate;
	}
	public String getFinisheddate() {
		return finisheddate;
	}
	public void setFinisheddate(String finisheddate) {
		this.finisheddate = finisheddate;
	}
	public String getInterdate() {
		return interdate;
	}
	public void setInterdate(String interdate) {
		this.interdate = interdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getChirldType() {
		return chirldType;
	}
	public void setChirldType(String chirldType) {
		this.chirldType = chirldType;
	}
	public String getFirstInter() {
		return firstInter;
	}
	public void setFirstInter(String firstInter) {
		this.firstInter = firstInter;
	}
	public String getSecInter() {
		return secInter;
	}
	public void setSecInter(String secInter) {
		this.secInter = secInter;
	}
	public String getEffectAmount() {
		return effectAmount;
	}
	public void setEffectAmount(String effectAmount) {
		this.effectAmount = effectAmount;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

}
