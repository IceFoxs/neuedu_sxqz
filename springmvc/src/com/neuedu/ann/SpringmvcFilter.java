package com.neuedu.ann;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SpringmvcFilter implements Filter{

	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//�ж�֮ǰ�Ƿ����ù����뼯,���û����
		encoding = filterConfig.getInitParameter("encoding");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	}

}
