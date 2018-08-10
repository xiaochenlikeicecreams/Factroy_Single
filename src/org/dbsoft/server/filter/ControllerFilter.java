package org.dbsoft.server.filter;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerFilter implements Filter {
	private HttpServletRequest httpServletRequest = null;
	private HttpServletResponse httpServletResponse = null;
	private Object personObject = null;
	private String webPath = null;
	private String path = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		this.characterFilter(request, response, chain);
		httpServletRequest = (HttpServletRequest) request;
		httpServletResponse = (HttpServletResponse)response;
		personObject = httpServletRequest.getSession().getAttribute("person");
		webPath = httpServletRequest.getRequestURI();
		System.out.println("webPath = " + webPath);
		if(personObject == null
				&& !webPath.endsWith("/login.jsp")
				&& !webPath.endsWith("/regist.jsp") 
				&& !webPath.endsWith("ps")
				&& webPath.endsWith("css")) {
			
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/web/login.jsp");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	private void characterFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
	}

	
	}


