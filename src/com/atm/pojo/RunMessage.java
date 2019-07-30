package com.atm.pojo;

import java.util.Date;

public class RunMessage {
	private String ICno;//卡号
	private String RM_date;//交易日期
	private String RM_Currency;//货币类型
	private double RM_Balance;//账户余额
	private double RM_Rest;//交易后余额
	public String getICno() {
		return ICno;
	}
	public void setICno(String iCno) {
		ICno = iCno;
	}
	public String getRM_date() {
		return RM_date;
	}
	public void setRM_date(String rM_date) {
		RM_date = rM_date;
	}
	public String getRM_Currency() {
		return RM_Currency;
	}
	public void setRM_Currency(String rM_Currency) {
		RM_Currency = rM_Currency;
	}
	public double getRM_Balance() {
		return RM_Balance;
	}
	public void setRM_Balance(double rM_Balance) {
		RM_Balance = rM_Balance;
	}
	public double getRM_Rest() {
		return RM_Rest;
	}
	public void setRM_Rest(double rM_Rest) {
		RM_Rest = rM_Rest;
	}
	public RunMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RunMessage(String iCno, String rM_date, String rM_Currency, double rM_Balance, double rM_Rest) {
		super();
		ICno = iCno;
		RM_date = rM_date;
		RM_Currency = rM_Currency;
		RM_Balance = rM_Balance;
		RM_Rest = rM_Rest;
	}
	@Override
	public String toString() {
		return "RunMessage [ICno=" + ICno + ", RM_date=" + RM_date + ", RM_Currency=" + RM_Currency + ", RM_Balance="
				+ RM_Balance + ", RM_Rest=" + RM_Rest + "]";
	}
	
	
}
