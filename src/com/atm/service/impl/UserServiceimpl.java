/**
 * 
 */
package com.atm.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.atm.dao.UserDao;
import com.atm.dao.impl.UserDaoimpl;
import com.atm.pojo.User;
import com.atm.pojo.manage;
import com.atm.service.UserService;

/**
 * @author lilijian
 *
 */
public class UserServiceimpl implements UserService{
	private UserDao ud;
	
	public UserServiceimpl(){
		ud = new UserDaoimpl();
	}
	/* (non-Javadoc)
	 * @see com.atm.service.UserService#login(int, java.lang.String, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public int login(String name, String pwd, HttpServletRequest request) {
		manage manage = ud.login(name);
		if(manage!=null){
			if(pwd.equals(manage.getPassword())){
				request.getSession().setAttribute("manage", manage);
				return 1;
			}else{
				return 0;
				}
			}else{
				return -1;
		}
			
	}

	/* (non-Javadoc)
	 * @see com.atm.service.UserService#add(com.atm.user.User)
	 */
	public int add(User user) {
		return ud.Insone(user);
	}
	/* (non-Javadoc)
	 * @see com.atm.service.UserService#show()
	 */
	@Override
	public List<User> show() {
		return ud.SelAll();
	}
	/* (non-Javadoc)
	 * @see com.atm.service.UserService#showsome()
	 */
	@Override
	public List<User> showsome(String name) {
		return ud.SelOne(name);
	}
	

}
