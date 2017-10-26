package com.neuedu.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*@WebListener*/
public class SessionListenerTest implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("��session������");
		HttpSession session = event.getSession();
		System.out.println("idֵ:"+session.getId());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("session������");
		HttpSession session = event.getSession();
		System.out.println("idֵ:"+session.getId());
	}
	
}
