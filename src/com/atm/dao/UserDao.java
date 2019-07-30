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
	 * 登录方法--查询有数据则登录
	 * 
	 */
	manage login(String name);
	
	/**
	 * 查询全部用户
	 * 
	 */
	List<User> SelAll();
	/**
	 * 新增一个用户
	 */
	int Insone(User user);
	/**
	 * 删除一个用户
	 * 
	 */
	boolean Delone(String name);
	/**
	 * 修改一个用户
	 * 
	 */
	boolean UpdOne(User user,String ic);
	/**
	 * 模糊查询
	 * 
	 */
	List<User> SelOne(String name);
}
