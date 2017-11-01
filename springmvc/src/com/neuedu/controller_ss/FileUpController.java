package com.neuedu.controller_ss;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUpController {

	@RequestMapping("fileup.do")
	public String fileup(@RequestParam("file")MultipartFile f,HttpServletRequest request,String username){
		System.out.println(username);
		//��ȡ������·��
		String pathroot = request.getServletContext().getRealPath("");
		//�����ļ�·��
		String path = null;
		//��������ļ���
		if (!f.isEmpty()) {
			//��uuid��Ϊ�ļ���
			String prefix = UUID.randomUUID().toString().replaceAll("-", "");
			//��ȡ�ļ�����
			String contentType = f.getContentType();
			//�����ļ���׺
			String suffix = contentType.substring(contentType.indexOf("/") + 1);
			//ƴ��·��
			path = "/upload/" + prefix + "." + suffix;
			try {
				//д���ļ�
				f.transferTo(new File(pathroot + path));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(path);
		return null;
	}
	
}
