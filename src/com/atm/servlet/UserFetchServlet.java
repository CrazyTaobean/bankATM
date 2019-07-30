package com.atm.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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


@WebServlet("/UserFetch")
public class UserFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=uttf-8");
		int fetchNum = Integer.parseInt(req.getParameter("fetchNum"));
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("userAccount");
		BeanUserService us = new BeanUserServiceImpl();
		double Money = us.serchBalance((String)obj);
		RunMessage rm = new RunMessage();
		BeanUserDao bud = new BeanUserDaoImpl();
		double fushu = -fetchNum;
		
		if(session!=null && fetchNum<=2000 && Money-fetchNum>=0&&fetchNum%50==0
				&& fetchNum>0) {
				rm.setICno((String)obj);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
				rm.setRM_date(df.format(new Date()));
				rm.setRM_Currency("�����");
				rm.setRM_Balance(fushu);
				System.out.println("�û���"+(String)obj+" ȡ��"+fetchNum+"Ԫ");
				rm.setRM_Rest(us.serchBalance((String)obj)-fetchNum);
				BeanUserService bus = new BeanUserServiceImpl(); 
				req.getSession().setAttribute("balance", Money);
				 bus.fetchMoney((String)obj, fetchNum);
				 bud.RunMessage(rm);
//			req.getRequestDispatcher("serch").forward(req, resp);
			resp.sendRedirect("/Final/UserSerch");
		}else if(fetchNum>2000){
			req.getSession().setAttribute("error2", "ȡ��ʧ�ܣ����ó���2000Ԫ");
//			req.getRequestDispatcher("UserJsp/fetchMoney.jsp").forward(req, resp);
			//����ط��������ض�����Ϊ UserJsp/fetchMoney.jsp ���jsp���ύ��ַ��<form action="../fetch">
			//���������һ��������ת��������Ҫ�ض������������ת��,�����ַ��������
			//http://localhost:8080/fetch?fetchNum=�������ȡǮ��Ӧ���ǣ�
			//http://localhost:8080/course/fetch?fetchNum=�������ȡǮ���
			resp.sendRedirect("/Final/changepage/UserFetch.jsp");
		}else if(fetchNum<0) {
			req.getSession().setAttribute("error2", "ȡ����������0!");
			resp.sendRedirect("/Final/changepage/UserFetch.jsp");
		}else if(fetchNum%50!=0) {
			req.getSession().setAttribute("error2", "ֻ��ȡ��50��100Ԫ�ֽ�ı���!");
			resp.sendRedirect("/Final/changepage/UserFetch.jsp");
		}else if(Money-fetchNum<0) {
			req.getSession().setAttribute("error2", "��������!");
			resp.sendRedirect("/Final/changepage/UserFetch.jsp");
		}
	}
}
