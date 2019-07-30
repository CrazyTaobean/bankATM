package com.atm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.dao.BeanUserDao;
import com.atm.dao.impl.BeanUserDaoImpl;
import com.atm.pojo.PageBean;
import com.atm.pojo.RunMessage;
import com.atm.service.BeanUserService;
import com.atm.service.impl.BeanUserServiceImpl;

/**
 * Servlet implementation class UserSerchDetail
 */
@WebServlet("/serchDetaile")
public class UserSerchDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			
			HttpSession session = req.getSession();
			Object obj = session.getAttribute("userAccount");
			BeanUserDao bud = new BeanUserDaoImpl();
			List<RunMessage> list = new ArrayList<RunMessage>();
			int pageNum=0;
//			int pageNum = 1;
			if(req.getParameter("pageNum")==null) {
				pageNum=1;
				list = bud.finAllMessage((String)obj, pageNum, 10);
			}else {
				pageNum = Integer.valueOf(req.getParameter("pageNum"));
				list = bud.finAllMessage((String)obj, pageNum, 10);
			}
			int pageSize = 10;
			
			BeanUserService bus = new BeanUserServiceImpl();
			
//			PageBean<RunMessage> pb = bus.finAllRunMessageWithPage(pageNum, pageSize, (String)obj);
			PageBean<RunMessage> pb = bus.finAll(pageNum, pageSize, (String)obj);
			System.out.println(pb);
			req.getSession().setAttribute("pageBean", pb);
			req.getServletContext().setAttribute("RunMessage", list);
			if(list!=null) {
				resp.sendRedirect("/Final/changepage/UserDetaile.jsp");
			}else {
				System.out.println("≤È—Ø ß∞‹£°");
			}
		}
}
