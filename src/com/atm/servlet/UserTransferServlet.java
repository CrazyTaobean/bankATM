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

@WebServlet("/UserTransfer")
public class UserTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		BeanUserDao budin = new BeanUserDaoImpl();
		BeanUserDao budout = new BeanUserDaoImpl();
		RunMessage rm1 = new RunMessage();
		RunMessage rm2 = new RunMessage();
		
		String transferIn = req.getParameter("transferIn");
		double transferNum = Double.parseDouble(req.getParameter("transferNum"));
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("userAccount");
		double fushu = -transferNum;
		
		BeanUserService us = new BeanUserServiceImpl();
		if(transferNum<10000 && transferNum>0 && us.serchBalance((String)obj)-transferNum>=0) {
			
			us.transfer((String)obj, transferIn, transferNum);
			rm1.setICno((String)obj);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			rm1.setRM_date(df.format(new Date()));
			rm1.setRM_Currency("�����");
			rm1.setRM_Balance(fushu);
			rm1.setRM_Rest(us.serchBalance((String)obj));
			
			rm2.setICno(transferIn);
			rm2.setRM_date(df.format(new Date()));
			rm2.setRM_Currency("�����");
			rm2.setRM_Balance(transferNum);
			rm2.setRM_Rest(us.serchBalance(transferIn));
			
			budout.RunMessage(rm1);
			budin.RunMessage(rm2);
			
			List<RunMessage> list = budout.SelMessage((String)obj);
			List<RunMessage> list1 = budin.SelMessage(transferIn);
			req.getServletContext().setAttribute("RunMessage", list);
			req.getServletContext().setAttribute("RunMessage", list1);
			System.out.println("�û���"+(String)obj+" ת��"+transferNum+"Ԫ");
			resp.getWriter().write("ת�˳ɹ�  3s���Զ���ת����ҳ... ...");
			resp.setHeader("refresh", "3,url=/Final/UserSerch");
//			req.getRequestDispatcher("serch").forward(req, resp);
//			resp.sendRedirect("/Final/UserSerch");
		}else if(us.serchBalance((String)obj)-transferNum<0){
			req.getSession().setAttribute("error4", "��Ǹ�����㣡");
			resp.sendRedirect("/Final/changepage/UserTransfer.jsp");
		}else if(transferNum > 10000) {
			req.getSession().setAttribute("error4", "ת�˽��ø���10,000Ԫ��");
			resp.sendRedirect("/Final/changepage/UserTransfer.jsp");
		}else if(transferNum < 0 ) {
			req.getSession().setAttribute("error4", "���������룡");
			resp.sendRedirect("/Final/changepage/UserTransfer.jsp");
		}
	}
	
}
