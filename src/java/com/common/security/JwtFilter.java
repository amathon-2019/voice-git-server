package com.common.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.common.collection.CLog;

public class JwtFilter implements Filter{
	
	@Autowired
	CLog log;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {
	
		log.i("================== 커스텀 필터 Start ==================");
		log.i("================== 커스텀 필터 END ==================");
		
		// 다음 필터 호출
		doFilter(request, response, chain);
	}
}
