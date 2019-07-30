/**
 * 
 */
package com.atm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atm.dao.UserDao;
import com.atm.dao.impl.UserDaoimpl;
import com.atm.pojo.User;

/**
 * @author lilijian
 *
 */
public class UpdateServlet extends HttpServlet {

	private UserDao ud = new UserDaoimpl();
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String ic = req.getParameter("ic");
		String icno = req.getParameter("icno");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String mobile = req.getParameter("mobile");
		String idcard = req.getParameter("idcard");
		String balance = req.getParameter("balance");
		User user = new User();
		user.setIcno(icno);
		user.setName(name);
		user.setPwd(pwd);
		user.setMobile(mobile);
		user.setIdcard(idcard);
		user.setBalance(Double.parseDouble(balance));
		boolean result = ud.UpdOne(user, ic);
		if(result)
			resp.sendRedirect("list");
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doGet(req,resp);
	}

}
