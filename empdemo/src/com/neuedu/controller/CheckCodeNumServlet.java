package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/checkcodenum.do")
public class CheckCodeNumServlet extends HttpServlet{

	private static final long serialVersionUID = -8447531257564063645L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����������л��ǰ̨�������֤��
		String num = req.getParameter("num");
		//��sessionȡ�����ɵ���֤��
		String code_num = (String)req.getSession().getAttribute("code");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if (num.equals(code_num)) {
			out.print(true);
		}else{
			out.print(false);
		}
		out.close();
	}
	
}
