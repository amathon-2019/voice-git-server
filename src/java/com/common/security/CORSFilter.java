package com.common.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


/**
 * CROSS-SITE-ORIGIN-REQUEST를 허용해주는 필터
 * 
 * @author Dong-Min Seol
 * @since  2019.08.03 
 *
 */
public class CORSFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest sReq, ServletResponse sRes, FilterChain chain) throws IOException, ServletException
	{
	
		HttpServletResponse response = (HttpServletResponse) sRes;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept");
		chain.doFilter(sReq, sRes);
	}
}
