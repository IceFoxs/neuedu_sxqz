package com.neuedu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/checkcode.do")
public class CheckCode extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��session��ȡ���������֤�� 
		String code = (String)req.getSession().getAttribute("code");
		//���ajax���󴫹�������֤��,ǰ̨�������֤��
		String html_code = req.getParameter("code");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if (code.equals(html_code)) {
			out.print(true);
		}else{
			out.print(false);
		}
		out.close();
	}
	
}
