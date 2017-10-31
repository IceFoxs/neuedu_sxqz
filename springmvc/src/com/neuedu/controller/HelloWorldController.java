package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("testparam")
public class HelloWorldController {

	@RequestMapping(value="/test.do",method=RequestMethod.GET)
	public ModelAndView hello(Integer id,String username,String password){
		System.out.println(username);
		System.out.println(password);
		//model��������ת��ҳ��
		ModelAndView model = new ModelAndView("test");
		//��ǰ̨�󶨲���
		model.addObject("testparam", "���ǲ��Բ���");
		return model;
	}
	
	@RequestMapping(value="/login.do")
	public ModelAndView login(){
		System.out.println("login");
		return new ModelAndView();
	}
	
}
