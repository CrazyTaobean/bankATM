package com.atm.dao;

import java.util.List;

import com.atm.pojo.BeanUserAccount;
import com.atm.pojo.PageBean;
import com.atm.pojo.RunMessage;

public interface BeanUserDao {
	/**
	 * ��������ɹ�
	 */
	int CHANGE_PASSWORD_SUCCESS = 1;
	/**
	 * ��������ʧ��
	 */
	int CHANGE_PASSWORD_FALSE = 2;
	/**
	 * �޸ĳɹ�
	 */
	int UPDATE_SUCCESS = 3;
	/**
	 * �޸�ʧ��
	 */
	int UPDATE_FALSE = -4;
	/**
	 * ��¼ʧ��
	 */
	BeanUserAccount LOGIN_FALSE = null;
	/**
	 * ��ѯʧ��
	 */
	int SERCH_FALSE = 5;
	/**
	 * ����
	 */
	int BALANCE_NOT_ENOUGH = 6;
	/**
	 * ת�˳ɹ�
	 */
	int TRANSFER_SUCCESS = 7;
	/**
	 * ת��ʧ��
	 */
	int TRANSFER_FALSE = 8;
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
	public int changePwd(String ICNo,String newPwd);
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
	 * ��ϸ�������
	 * @param ICNo	����
	 * @return
	 */
	public double DetailIn(String ICNo,double Num);
	/**
	 * ��ϸ��������
	 * @param ICNo
	 * @param Num
	 * @return
	 */
	public double DetailOut(String ICNo,double Num);
	/**
	 * ��ѯ��ϸ����
	 * @param ICNo
	 * @return
	 */
	public BeanUserAccount SerchDetaile(String ICNo);
	/**
	 * ��ѯ����
	 */
	public BeanUserAccount SerchPwd(String ICNo);
	/**
	 * �˿�����
	 * @return
	 */
	public int quit();
	/**
	 * ������ˮ����Ϣ
	 * @param rm
	 * @return
	 */
	public int RunMessage(RunMessage rm);
	/**
	 * ��ȡ��ˮ����Ϣ
	 * @param ICNo
	 * @return
	 */
	public List<RunMessage> SelMessage(String ICNo);
	/**
	 * ��ѯ��������
	 * @return
	 */
	public List<RunMessage> finAllMessage(String ICno, int pageNum, int pageSize);
}
