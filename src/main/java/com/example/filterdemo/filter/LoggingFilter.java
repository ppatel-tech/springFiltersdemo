package com.example.filterdemo.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("request received");

		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String path = httpRequest.getRequestURI();

		System.out.println("request path: " + path);

		if ("/admin".equals(path)) {
			
			httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
			httpResponse.getWriter().write(" Admin access blocked by filter");
			return; // stop here
			
		}

		/* allow other requests */
		chain.doFilter(request, response);

	}

}
