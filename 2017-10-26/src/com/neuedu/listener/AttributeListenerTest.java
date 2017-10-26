package com.neuedu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AttributeListenerTest implements ServletContextAttributeListener{
	
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("�в�������servletcontext");
		System.out.println("����key:"+event.getName());
		System.out.println("����value:"+event.getValue());
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("�в���ɾ��servletcontext");
		System.out.println("����key:"+event.getName());
		System.out.println("����value:"+event.getValue());
	}
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("�в����滻servletcontext");
		System.out.println("����key:"+event.getName());
		System.out.println("����value:"+event.getValue());
	}
	
}
