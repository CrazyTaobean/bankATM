/**
 * 
 */
package com.atm.servlet;

import java.io.IOException;

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

public class InsertServlet extends HttpServlet {

	private UserService us = new UserServiceimpl();
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String icno = req.getParameter("icno");
		String name = req.getParameter("name");
		String mobile = req.getParameter("mobile");
		String idcard = req.getParameter("idcard");
		String balance = req.getParameter("balance");
		User user = new User();
		user.setIcno(icno);
		user.setName(name);
		user.setMobile(mobile);
		user.setIdcard(idcard);
		user.setBalance(Double.parseDouble(balance));
		System.out.println(icno+"----"+name+"----"+mobile+"----"+idcard+"----"+balance);
		int index = us.add(user);
		System.out.println("index="+index);
		if(index>0){
			System.out.println("InsertServlet.doGet(index>0)");
			resp.sendRedirect("list");
		}else{
			System.out.println("InsertServlet.doGet(我失败了)");
			//新增失败跳转到新增功能页面
			req.getRequestDispatcher("changepage/add.jsp").forward(req, resp);
		}
		
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doGet(req,resp);
	}

}
