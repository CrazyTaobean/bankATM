package com.atm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atm.pojo.BeanUserAccount;
import com.atm.service.BeanUserService;
import com.atm.service.impl.BeanUserServiceImpl;
@WebServlet("/UserLogin")
public class UserLoginServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String ICNo = req.getParameter("ICNo");
		String pwd = req.getParameter("pwd");

		BeanUserService us = new BeanUserServiceImpl();
		BeanUserAccount ua = us.checkLogin(ICNo, pwd);
		if(ua!=null) {
			System.out.println("�û�"+ICNo+" ��½�ɹ���");
			req.getSession().setAttribute("userAccount", ua.getICNo());
			req.getSession().setAttribute("ua", ua);
//			req.setAttribute("userAccount", ua);
//			req.getRequestDispatcher("").forward(req, resp);
			resp.sendRedirect("/Final/changepage/UserIndex.jsp");
		}else {
			System.out.println("UserLoginServlet.service(��shibai��)");
//			req.setAttribute("error", "��¼ʧ�ܣ������û���������");
			req.getSession().setAttribute("error", "��¼ʧ�ܣ������û���������");
//			req.getRequestDispatcher("UserJsp/login.jsp").forward(req, resp);
			resp.sendRedirect("changepage/login.jsp");
		}
	}
}

