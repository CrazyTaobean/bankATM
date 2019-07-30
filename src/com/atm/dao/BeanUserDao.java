package com.atm.dao;

import java.util.List;

import com.atm.pojo.BeanUserAccount;
import com.atm.pojo.PageBean;
import com.atm.pojo.RunMessage;

public interface BeanUserDao {
	/**
	 * 更改密码成功
	 */
	int CHANGE_PASSWORD_SUCCESS = 1;
	/**
	 * 更改密码失败
	 */
	int CHANGE_PASSWORD_FALSE = 2;
	/**
	 * 修改成功
	 */
	int UPDATE_SUCCESS = 3;
	/**
	 * 修改失败
	 */
	int UPDATE_FALSE = -4;
	/**
	 * 登录失败
	 */
	BeanUserAccount LOGIN_FALSE = null;
	/**
	 * 查询失败
	 */
	int SERCH_FALSE = 5;
	/**
	 * 余额不足
	 */
	int BALANCE_NOT_ENOUGH = 6;
	/**
	 * 转账成功
	 */
	int TRANSFER_SUCCESS = 7;
	/**
	 * 转账失败
	 */
	int TRANSFER_FALSE = 8;
	/**
	 * 登录功能
	 * @param ICNo 卡号
	 * @param pwd	密码
	 * @return	返回值为UserAccount类型
	 */
	public BeanUserAccount checkLogin(String ICNo, String pwd);
	/**
	 * 改密码功能
	 * @param ICNo	卡号
	 * @return	
	 */
	public int changePwd(String ICNo,String newPwd);
	/**
	 * 查询余额功能
	 * @param ICNo	卡号
	 * @return
	 */
	public double serchBalance(String ICNo);
	/**
	 * 存钱功能
	 * @param ICNo	卡号
	 * @param MoneyNum	要存多少钱
	 * @return
	 */
	public int saveMoney(String ICNo, int MoneyNum);
	/**
	 * 取钱功能
	 * @param ICNo	卡号
	 * @param MoneyNum	取钱的数字
	 * @return
	 */
	public int fetchMoney(String ICNo, int MoneyNum);
	/**
	 * 转账功能
	 * @param transferOut	转出账号
	 * @param transferIn	转入账号
	 * @param MoneyNum	转多少钱的数字
	 * @return
	 */
	public int transfer(String transferOut, String transferIn, double MoneyNum);
	/**
	 * 明细流入金额功能
	 * @param ICNo	卡号
	 * @return
	 */
	public double DetailIn(String ICNo,double Num);
	/**
	 * 明细流出功能
	 * @param ICNo
	 * @param Num
	 * @return
	 */
	public double DetailOut(String ICNo,double Num);
	/**
	 * 查询明细功能
	 * @param ICNo
	 * @return
	 */
	public BeanUserAccount SerchDetaile(String ICNo);
	/**
	 * 查询密码
	 */
	public BeanUserAccount SerchPwd(String ICNo);
	/**
	 * 退卡功能
	 * @return
	 */
	public int quit();
	/**
	 * 插入流水账信息
	 * @param rm
	 * @return
	 */
	public int RunMessage(RunMessage rm);
	/**
	 * 获取流水账信息
	 * @param ICNo
	 * @return
	 */
	public List<RunMessage> SelMessage(String ICNo);
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<RunMessage> finAllMessage(String ICno, int pageNum, int pageSize);
}
