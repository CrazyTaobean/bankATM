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
	 * ��¼
	 * @return
	 */
	
	int login(String name,String pwd,HttpServletRequest request);
	/**
	 * ����
	 * @param user
	 * @return
	 */
	
	int add(User user);
	/**
	 * չʾ�����û���Ϣ
	 * 
	 */
	List<User> show();
	/**
	 * ģ����ѯ��Ϣ
	 * 
	 */
	List<User> showsome(String name);
}
