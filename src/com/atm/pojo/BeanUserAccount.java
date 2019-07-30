package com.atm.pojo;

public class BeanUserAccount {

	private String ICNo;//����
	private String name;//�˻���
	private String pwd;//�˻�����
	private String mobile;//�绰����
	private String IDCard;//���֤��
	private double balance;//���
	private double saveNum;//��Ǯ��
	private double fetchNum;//ȡǮ��
	public BeanUserAccount() {
		super();
	}
	public BeanUserAccount(String iCNo, String name, String pwd, String mobile, String iDCard, double balance,
			double saveNum, double fetchNum) {
		super();
		ICNo = iCNo;
		this.name = name;
		this.pwd = pwd;
		this.mobile = mobile;
		IDCard = iDCard;
		this.balance = balance;
		this.saveNum = saveNum;
		this.fetchNum = fetchNum;
	}
	@Override
	public String toString() {
		return "UserAccount [ICNo=" + ICNo + ", name=" + name + ", pwd=" + pwd + ", mobile=" + mobile + ", IDCard="
				+ IDCard + ", balance=" + balance + ", saveNum=" + saveNum + ", fetchNum=" + fetchNum + "]";
	}
	public double getSaveNum() {
		return saveNum;
	}
	public void setSaveNum(double saveNum) {
		this.saveNum = saveNum;
	}
	public double getFetchNum() {
		return fetchNum;
	}
	public void setFetchNum(double fetchNum) {
		this.fetchNum = fetchNum;
	}
	public String getICNo() {
		return ICNo;
	}
	public void setICNo(String iCNo) {
		ICNo = iCNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
