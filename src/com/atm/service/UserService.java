/**
 * 
 */
package com.atm.service;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.atm.pojo.User;

/**
 * @author lilijian
 *
 */
public interface UserService {
	/**
	 * 登录
	 * @return
	 */
	
	int login(String name,String pwd,HttpServletRequest request);
	/**
	 * 新增
	 * @param user
	 * @return
	 */
	
	int add(User user);
	/**
	 * 展示所有用户信息
	 * 
	 */
	List<User> show();
	/**
	 * 模糊查询信息
	 * 
	 */
	List<User> showsome(String name);
}
