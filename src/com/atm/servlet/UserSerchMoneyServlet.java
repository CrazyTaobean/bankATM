package com.atm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.service.BeanUserService;
import com.atm.service.impl.BeanUserServiceImpl;


@WebServlet("/UserSerch")
public class UserSerchMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("----------------------");
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("userAccount");
		req.setAttribute("QueryBalance", (String)obj);
		BeanUserService us = new BeanUserServiceImpl();
		double Money = us.serchBalance((String)obj);
		System.out.println("用户："+(String)obj+" 当前账户共有："+Money+"元！");
		if(Money!=5) {
			req.getSession().setAttribute("balance", Money);
//			req.getRequestDispatcher("UserJsp/serchBalance.jsp").forward(req, resp);
			resp.sendRedirect("/Final/changepage/SerchBalance.jsp");
		}else {
			resp.sendRedirect("changepage/login.jsp");
		}
	}
}
