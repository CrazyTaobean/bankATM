package com.atm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.dao.BeanUserDao;
import com.atm.dao.impl.BeanUserDaoImpl;
import com.atm.pojo.BeanUserAccount;
import com.atm.service.BeanUserService;
import com.atm.service.impl.BeanUserServiceImpl;

@WebServlet("/UserChange")
public class UserChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		BeanUserAccount bua = new BeanUserAccount();
		Object obj = session.getAttribute("userAccount");
		String ICNo = req.getParameter("icno");
		String oldpwd = req.getParameter("oldpwd");
		String newPwd = req.getParameter("pwd");
		String repeat = req.getParameter("newpwd");
		BeanUserDao bud = new BeanUserDaoImpl();
		bua = bud.SerchPwd((String)obj);
		System.out.println(bua);
		System.out.println("ICNO="+ICNo);
		System.out.println("旧密码="+oldpwd);
		System.out.println("新密码="+newPwd);
		System.out.println("重复密码="+repeat);
		if(!oldpwd.equals(newPwd) && ICNo.equals((String)obj) && repeat.equals(newPwd) 
				&& ICNo!="" && oldpwd!="" && newPwd!="" && repeat!="" && oldpwd.equals(bua.getPwd())) {
			BeanUserService us = new BeanUserServiceImpl();
			int index = us.changePwd((String)obj, newPwd);
			if(index==1) {
				BeanUserAccount ua = us.checkLogin(ICNo, newPwd);
				req.getSession().setAttribute("ua", ua);
				resp.sendRedirect("/Final/changepage/UserIndex.jsp");
			}
		}else if(ICNo==""||oldpwd==""||newPwd==""||repeat=="") {
			req.getSession().setAttribute("error1", "输入不得为空");
			resp.sendRedirect("/Final/changepage/UserChangePwd.jsp");
		}else if(oldpwd.equals(newPwd)){
			req.getSession().setAttribute("error1", "原密码与新密码一致！");
			resp.sendRedirect("/Final/changepage/UserChangePwd.jsp");
		}else if(!ICNo.equals((String)obj)){
			req.getSession().setAttribute("error1", "银行卡号输入错误，请重试");
			resp.sendRedirect("/Final/changepage/UserChangePwd.jsp");
		}else if(!repeat.equals(newPwd)) {
			req.getSession().setAttribute("error1", "两次密码不一致");
			resp.sendRedirect("/Final/changepage/UserChangePwd.jsp");
		}else{
			req.getSession().setAttribute("error1", "密码错误");
			resp.sendRedirect("/Final/changepage/UserChangePwd.jsp");
		}
		
	}
	
}
