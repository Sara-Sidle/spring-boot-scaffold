package com.wukp.boot.filter.session;

import groovy.util.logging.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 *
 * @author:
 * When: 2019/5/19 21:30
 **/
@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/api/*",filterName = "loginFilter")
@Slf4j
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("FLITER INTIT");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FLITER");
        System.out.println("TestFilter1");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("FLITER destroy");
    }
}