package com.neuedu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/checkusername.do")
public class CheckUsername extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		//��дjdbc��,д����admin����һ�� 
		PrintWriter out = resp.getWriter();
		if (username.equals("admin")) {
			//�û�������
			out.print("true");
		}else{
			//�û���������
			out.print("false");
		}
		out.close();
	}
	
}
