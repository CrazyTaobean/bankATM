package com.atm.dao;

import java.util.List;

import com.atm.pojo.User;
import com.atm.pojo.manage;

/**
 * @author lilijian
 *
 */
public interface UserDao {
	/**
	 * ��¼����--��ѯ���������¼
	 * 
	 */
	manage login(String name);
	
	/**
	 * ��ѯȫ���û�
	 * 
	 */
	List<User> SelAll();
	/**
	 * ����һ���û�
	 */
	int Insone(User user);
	/**
	 * ɾ��һ���û�
	 * 
	 */
	boolean Delone(String name);
	/**
	 * �޸�һ���û�
	 * 
	 */
	boolean UpdOne(User user,String ic);
	/**
	 * ģ����ѯ
	 * 
	 */
	List<User> SelOne(String name);
}
