package com.neuedu.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

@WebServlet(urlPatterns="/pagetest.do")
public class PageContextTest extends HttpServlet{

	
	/**
	 * ����ģʽ
	 */
	private List<String> list = new ArrayList<String>();
	
	@Override
	protected synchronized void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PageContext pagecontext = JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 1024, true);
//		pagecontext.setAttribute("username", "admin");
//		System.out.println(pagecontext.getAttribute("username"));
		synchronized (list) {
			list.add("");
		}
		ServletContext application = req.getServletContext();
		//�����Ŀ��
		String servletcontextname = application.getServletContextName();
		System.out.println(servletcontextname);
		//��÷�������ʵ·��
		String realpath = application.getRealPath("/upload");
		System.out.println(realpath);
		String contextpath = application.getContextPath();
		System.out.println(contextpath);
	}
	
	
	
	
}
