package com.atm.service;


import com.atm.pojo.BeanUserAccount;
import com.atm.pojo.PageBean;
import com.atm.pojo.RunMessage;

public interface BeanUserService {
		/**
		 * ��¼����
		 * @param ICNo ����
		 * @param pwd	����
		 * @return	����ֵΪUserAccount����
		 */
		public BeanUserAccount checkLogin(String ICNo, String pwd);
		/**
		 * �����빦��
		 * @param ICNo	����
		 * @return	
		 */
		public int changePwd(String ICNo, String newPwd);
		/**
		 * ��ѯ����
		 * @param ICNo	����
		 * @return
		 */
		public double serchBalance(String ICNo);
		/**
		 * ��Ǯ����
		 * @param ICNo	����
		 * @param MoneyNum	Ҫ�����Ǯ
		 * @return
		 */
		public int saveMoney(String ICNo, int MoneyNum);
		/**
		 * ȡǮ����
		 * @param ICNo	����
		 * @param MoneyNum	ȡǮ������
		 * @return
		 */
		public int fetchMoney(String ICNo, int MoneyNum);
		/**
		 * ת�˹���
		 * @param transferOut	ת���˺�
		 * @param transferIn	ת���˺�
		 * @param MoneyNum	ת����Ǯ������
		 * @return
		 */
		public int transfer(String transferOut, String transferIn, double MoneyNum);
		/**
		 * ��ϸ���빦��
		 * @param ICNo	����
		 * @return
		 */
		public double DetailIn(String ICNo,double Num);
		/**
		 * ��ϸ��������
		 * @param ICNo	����
		 * @return
		 */
		public double DetailOut(String ICNo,double Num);
		public double SerchDetaile(String ICNo);
		/**
		 * �˿�����
		 * @return
		 */
		public int quit();
		/**
		 * ���ҹ��ж������ݴ�����װ���˵�Bean����
		 * @param pageNum ��ǰ�ǵڼ�ҳ
		 * @param pageSize	һҳ��ʾ���ٸ�����
		 * @return
		 */
		public PageBean<RunMessage> finAllRunMessageWithPage(int pageNum, int pageSize, String ICno);
		public PageBean<RunMessage> finAll(int pageNum, int pageSize,String ICno);
}
