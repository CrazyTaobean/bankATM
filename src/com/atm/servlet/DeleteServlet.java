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

/**
 * @author lilijian
 *
 */
public class DeleteServlet extends HttpServlet {

	private UserDao ud = new UserDaoimpl();
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String icno = req.getParameter("icno");
		boolean result = ud.Delone(icno);
		if(result)
			req.getRequestDispatcher("list").forward(req, resp);
	
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	doGet(req,resp);
	}

}
