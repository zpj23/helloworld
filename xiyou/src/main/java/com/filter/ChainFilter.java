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
import com.sys.entity.UserInfo;



public class ChainFilter implements Filter{
	protected String endcoding = null;
	protected FilterConfig filterConfig = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	// 获取访问全路径
		private String getCurrentURL(HttpServletRequest request) {
			StringBuffer sb = new StringBuffer();
			sb.append(request.getServletPath());
			String queryString = request.getQueryString();
			if (queryString != null && !queryString.equals("")) {
				sb.append("?");
				sb.append(queryString);
			}
			return sb.toString();
		}
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		//设置字符集  
				servletRequest.setCharacterEncoding(endcoding);
				HttpServletRequest req = (HttpServletRequest) servletRequest;
				String str_href = this.getCurrentURL(req); 
				try{
					
					boolean isLogin = false;
					System.out.println("tomcat "+req.getSession().getId());
					System.out.println("执行时间："+System.currentTimeMillis());
					// 获取session中用户信息jluserinfo
					UserInfo user = (UserInfo) req.getSession().getAttribute("jluserinfo");		
					if (user != null) {
						isLogin = true;
					}
					if(isLogin){
//						if(str_href.indexOf("Action_")!=-1){
//							// 判断是否有访问权限
//							boolean b = true;//this.checkLimit(str_href);
//							if (b == true) {
								chain.doFilter(servletRequest, servletResponse);
//							} else {
//								req.setAttribute("msg", "您没有权限访问该URL链接地址!");
//								req.getRequestDispatcher("/error.jsp").forward(req, servletResponse);
//							}
//						}else{
//							chain.doFilter(req, servletResponse);
//						}
					}else if(str_href.indexOf("/springmvc")>-1){
						req.getRequestDispatcher("/login.jsp").forward(req, servletResponse);
					}else if(str_href.indexOf("druid")!=-1){
						chain.doFilter(servletRequest, servletResponse);
					}else{
						chain.doFilter(servletRequest, servletResponse);
					}
				}catch (Exception e) {
					System.out.println("错误请求链接："+str_href);
					throw e;
				}
		
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
