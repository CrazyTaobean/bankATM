package com.atm.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.dao.BeanUserDao;
import com.atm.dao.impl.BeanUserDaoImpl;
import com.atm.pojo.RunMessage;
import com.atm.service.BeanUserService;
import com.atm.service.impl.BeanUserServiceImpl;

@WebServlet("/UserStore")
public class UserStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=uttf-8");
		RunMessage rm = new RunMessage();
		BeanUserDao bud = new BeanUserDaoImpl();
		int result = 0;
		int saveNum = Integer.parseInt(req.getParameter("saveNum"));
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("userAccount");
		BeanUserService us = new BeanUserServiceImpl();
		double Money = us.serchBalance((String)obj);
		if(session!=null && saveNum<=2000 && saveNum%50==0 && saveNum >0) {
			BeanUserService bus = new BeanUserServiceImpl();
			bus.saveMoney((String)obj, saveNum);
			rm.setICno((String)obj);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			rm.setRM_date(df.format(new Date()));
			rm.setRM_Currency("�����");
			rm.setRM_Balance(saveNum);
			rm.setRM_Rest(us.serchBalance((String)obj));
			bud.RunMessage(rm);
				req.getSession().setAttribute("balance", Money);
				List<RunMessage> list = bud.SelMessage((String)obj);
				req.getServletContext().setAttribute("RunMessage", list);
//				req.getRequestDispatcher("serch").forward(req, resp);
				resp.sendRedirect("/Final/UserSerch");
				System.out.println("�û���"+(String)obj+" ���"+saveNum+"Ԫ");
//			resp.sendRedirect("serch");
		}else if (result == 4 && session != null) {
//			req.getRequestDispatcher("UserJsp/saveMoney.jsp").forward(req, resp);
			resp.sendRedirect("/Final/changepage/UserStore.jsp");
		}else if(saveNum>2000){
			req.getSession().setAttribute("error3", "�洢ʧ�ܣ����ó���2000Ԫ");
//			req.getRequestDispatcher("UserJsp/saveMoney.jsp").forward(req, resp);
//			resp.sendRedirect("UserJsp/saveMoney.jsp");
			resp.sendRedirect("/Final/changepage/UserStore.jsp");
		}else if(saveNum%50!=0) {
			req.getSession().setAttribute("error3", "ֻ��Ͷ��50Ԫ��100Ԫ�ĳ�Ʊ��");
//			req.getRequestDispatcher("UserJsp/saveMoney.jsp").forward(req, resp);
//			resp.sendRedirect("UserJsp/saveMoney.jsp");
			resp.sendRedirect("/Final/changepage/UserStore.jsp");
		}else if(saveNum<0) {
			req.getSession().setAttribute("error3", "�����������0��");
//			req.getRequestDispatcher("UserJsp/saveMoney.jsp").forward(req, resp);
//			resp.sendRedirect("UserJsp/saveMoney.jsp");
			resp.sendRedirect("/Final/changepage/UserStore.jsp");
		}
	}
}
