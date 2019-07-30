package com.atm.service.impl;


import java.util.List;

import com.atm.dao.BeanUserDao;
import com.atm.dao.impl.BeanUserDaoImpl;
import com.atm.pojo.BeanUserAccount;
import com.atm.pojo.PageBean;
import com.atm.pojo.RunMessage;

public class BeanUserServiceImpl implements com.atm.service.BeanUserService{
	@Override
	public BeanUserAccount checkLogin(String ICNo, String pwd) {
		BeanUserDao ud = new BeanUserDaoImpl();
		return ud.checkLogin(ICNo, pwd);
	}

	@Override
	public int changePwd(String ICNo, String newPwd) {
		BeanUserDao ud = new BeanUserDaoImpl();
		return ud.changePwd(ICNo, newPwd);
	}

	@Override
	public double serchBalance(String ICNo) {
		BeanUserDao ud = new BeanUserDaoImpl();
		return ud.serchBalance(ICNo);
	}

	@Override
	public int saveMoney(String ICNo, int MoneyNum) {
		BeanUserDao ud = new BeanUserDaoImpl();
		return ud.saveMoney(ICNo, MoneyNum);
	}

	@Override
	public int fetchMoney(String ICNo, int MoneyNum) {
		BeanUserDao ud = new BeanUserDaoImpl();
		return ud.fetchMoney(ICNo, MoneyNum);
	}

	@Override
	public int transfer(String transferOut, String transferIn, double MoneyNum) {
		BeanUserDao ud = new BeanUserDaoImpl();
		return ud.transfer(transferOut, transferIn, MoneyNum);
	}

	@Override
	public double DetailIn(String ICNo,double Num) {
		BeanUserDao ud = new BeanUserDaoImpl();
		return ud.DetailIn(ICNo, Num);
	}

	@Override
	public int quit() {
		BeanUserDao ud = new BeanUserDaoImpl();
		return ud.quit();
	}

	@Override
	public double DetailOut(String ICNo, double Num) {
		BeanUserDao ud = new BeanUserDaoImpl();
		return ud.DetailOut(ICNo, Num);
	}

	@Override
	public double SerchDetaile(String ICNo) {
		BeanUserDao ud = new BeanUserDaoImpl();
		return ud.serchBalance(ICNo);
	}

	@Override
	public PageBean<RunMessage> finAllRunMessageWithPage(int pageNum, int pageSize, String ICno) {
		BeanUserDao bud = new BeanUserDaoImpl();
		List<RunMessage> allMessage = bud.finAllMessage(ICno, pageNum, pageSize);
		int totalRecord = allMessage.size();
		
		PageBean<RunMessage> pb = new PageBean<RunMessage>(pageNum, pageSize, totalRecord);
		
//		int startIndex = pb.getStartIndex();
		
		pb.setList(bud.finAllMessage(ICno, pageNum, pageSize));
		return pb;
	}
	
	public PageBean<RunMessage> finAll(int pageNum, int pageSize,String ICno) {
		BeanUserDao bud = new BeanUserDaoImpl();
//		List<RunMessage> allMessage = bud.finAllMessage(ICno);
		List<RunMessage> all = bud.SelMessage(ICno);
		int totalRecord = all.size();
		
		PageBean<RunMessage> pb = new PageBean<RunMessage>(pageNum, pageSize, totalRecord);
		
//		int startIndex = pb.getStartIndex();
		
		pb.setList(bud.SelMessage(ICno));
		return pb;
	}



}
