package com.atm.service;


import com.atm.pojo.BeanUserAccount;
import com.atm.pojo.PageBean;
import com.atm.pojo.RunMessage;

public interface BeanUserService {
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
		public int changePwd(String ICNo, String newPwd);
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
		 * 明细流入功能
		 * @param ICNo	卡号
		 * @return
		 */
		public double DetailIn(String ICNo,double Num);
		/**
		 * 明细流出功能
		 * @param ICNo	卡号
		 * @return
		 */
		public double DetailOut(String ICNo,double Num);
		public double SerchDetaile(String ICNo);
		/**
		 * 退卡功能
		 * @return
		 */
		public int quit();
		/**
		 * 查找共有多少数据传给封装好了的Bean对象
		 * @param pageNum 当前是第几页
		 * @param pageSize	一页显示多少个数据
		 * @return
		 */
		public PageBean<RunMessage> finAllRunMessageWithPage(int pageNum, int pageSize, String ICno);
		public PageBean<RunMessage> finAll(int pageNum, int pageSize,String ICno);
}
