package com.atm.pojo;

/**
 * @author lilijian
 *
 */
public class User {
	private  String icno;
	private  String name;
	private  String pwd;
	private  String mobile;
	private  String idcard;
	private  Double balance;
	public String getIcno() {
		return icno;
	}
	public void setIcno(String icno) {
		this.icno = icno;
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
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "User [icno=" + icno + ", name=" + name + ", pwd=" + pwd + ", mobile=" + mobile + ", idcard=" + idcard
				+ ", balance=" + balance + "]";
	}
	public User(String icno, String name, String pwd, String mobile, String idcard, Double balance) {
		super();
		this.icno = icno;
		this.name = name;
		this.pwd = pwd;
		this.mobile = mobile;
		this.idcard = idcard;
		this.balance = balance;
	}
	public User() {
		super();
	}
	

	}
	