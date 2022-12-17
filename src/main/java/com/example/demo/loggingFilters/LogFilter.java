package com.example.demo.loggingFilters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        logger.info("Hello from: " + request.getLocalAddr());
        logger.info("IP: " + request.getRemoteAddr());
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        logger.info("URI: " + servletRequest.getRequestURI());
        chain.doFilter(request, response);

        HttpServletResponse servletResponse = (HttpServletResponse) response;
        logger.info("Response: " + servletResponse.getOutputStream().toString());
    }
}
