package com.atm.servlet;

import java.io.IOException;
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
public class SelectServlet extends HttpServlet {

	UserService us = new UserServiceimpl();
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("name");
		List<User> list2 = us.showsome(name);
		//req.setAttribute("list2", list2);
		//req.getServletContext().setAttribute("list2", list2);
		req.getSession().setAttribute("list2", list2);
		resp.sendRedirect("changepage/userlist.jsp");
		//req.getRequestDispatcher("changepage/userlist.jsp").forward(req, resp);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doGet(req,resp);
	}

}
