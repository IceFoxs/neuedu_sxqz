package com.neuedu.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@WebServlet(urlPatterns="/checkcode.do")
public class CheckCodeServlet extends HttpServlet{

	private static final long serialVersionUID = 2602779377997156544L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������ӦjpegͼƬ
		resp.setContentType("image/jpeg");
		//����ͼƬ  60 20 ΪͼƬ��С  ͼƬ��ʾ����
		BufferedImage image = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
		//����һ������
		Graphics g = image.getGraphics();
		//����һ�����������
		Random r = new Random();
		//���ñ���ɫ
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		//��䱳��ɫ
		g.fillRect(0, 0, 60, 20);
		//����ǰ����ɫ, ���ֵ���ɫ
		g.setColor(new Color(0,0,0));
		//���������
//				String number = String.valueOf(r.nextInt(99999));
		//�Ӹ�����
		for (int i = 0; i < 2; i++) {
			g.drawLine(r.nextInt(60), r.nextInt(20), r.nextInt(60), r.nextInt(20));
		}
		String number = "";
		for (int i = 0; i < 5; i++) {
			number += r.nextInt(10);
		}
		HttpSession session = req.getSession();
		session.setAttribute("code", number);
		//�����ֻ���������
		g.drawString(number, 8, 15);
		//ͼƬ������֮����Ӧ�������
		//����ֽ������,��ΪҪ�������ͼ��ѹ��֮����ֽ�����,����,������ PrintWriter��
		OutputStream os = resp.getOutputStream();
		//��ͼƬѹ�������
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		encoder.encode(image);
	}
	
}
