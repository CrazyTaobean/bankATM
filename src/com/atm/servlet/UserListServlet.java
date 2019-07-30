package com.atm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atm.pojo.User;
import com.atm.service.UserService;
import com.atm.service.impl.UserServiceimpl;

/**
 * @author lilijian
 *
 */
public class UserListServlet extends HttpServlet {

	UserService us = new UserServiceimpl();
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		List<User> list = us.show();
		// req.setAttribute("list", list);
		req.getSession().setAttribute("list", list);
		//req.getRequestDispatcher("changepage/userlist.jsp").forward(req, resp);
		resp.sendRedirect("/Final/changepage/userlist.jsp");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

}
