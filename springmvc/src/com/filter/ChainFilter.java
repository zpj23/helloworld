package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.LocaleResolver;

import com.common.SpringContext;



public class ChainFilter implements Filter{
	protected String endcoding = null;
	protected FilterConfig filterConfig = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		//System.out.println(req.getServletPath());
		servletRequest.setCharacterEncoding(endcoding);
		chain.doFilter(servletRequest, servletResponse);
		
	}
	@Override
	public void init(FilterConfig config) throws ServletException {
		//上下文对象
		SpringContext.context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		SpringContext.localeResolver = (LocaleResolver) SpringContext.context.getBean("localeResolver");
//		SpringContext.messageSource = (MessageSource) SpringContext.context.getBean("messageSource");
//		SpringContext.scheduler  = new StdSchedulerFactory();	
		this.filterConfig=config;
		this.endcoding = filterConfig.getInitParameter("encoding");
	}
	
	
}
