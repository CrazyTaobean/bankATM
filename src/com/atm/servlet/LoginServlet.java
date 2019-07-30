package com.atm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atm.service.UserService;
import com.atm.service.impl.UserServiceimpl;

/**
 * @author lilijian
 *
 */
public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("name");
		String pwd = req.getParameter("password");
		System.out.println(name+"----"+pwd);
		UserService us = new UserServiceimpl();
		int result = us.login(name, pwd, req);
		System.out.println(result);
		if(result==1){
			System.out.println("�û���¼�ɹ���");
			resp.sendRedirect("list");
		}else if(result==0){
			System.out.println("�û���¼ʧ��");
			req.setAttribute("error", "�������");
			req.getRequestDispatcher("changepage/login.jsp").forward(req, resp);
		}else{
			System.out.println("LoginServlet.doGet(����result==����)");
			req.setAttribute("error", "�û���������");
			req.getRequestDispatcher("changepage/login.jsp").forward(req, resp);
		}
		}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doGet(req,resp);
	
	}

}
