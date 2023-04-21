package com.example.demo.loggingFilters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LogFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Hello from: " + request.getLocalAddr());
        logger.info("IP: " + request.getRemoteAddr());
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        logger.info("URI: " + servletRequest.getRequestURI());
        chain.doFilter(request, response);

        HttpServletResponse servletResponse = (HttpServletResponse) response;
        logger.info("Response: " + servletResponse.getOutputStream().toString());
    }
}
