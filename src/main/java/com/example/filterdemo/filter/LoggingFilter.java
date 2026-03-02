package com.example.filterdemo.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

public class LoggingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, 
			             ServletResponse response, 
			             FilterChain chain) throws IOException, ServletException {
		System.out.println("request received");
		
        /* pass the request to the next element in the chain */
		
//		chain.doFilter(request, response);
		
		
		System.out.println("request is blocked by filter");
		
		 HttpServletResponse httpResponse = (HttpServletResponse)response;
		 
		 httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
		 
		 httpResponse.getWriter().write("access blocked by filter");
		 
		
	}

	
	
	
}
