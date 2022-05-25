package com.project.solr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	
    	//HttpSession session = request.getSession();
        logger.info("[MYTEST] preHandle");
        //logger.info("session"+(String) session.getAttribute("nickname"));
        
        // session 객체를 가져옴
          
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView
    ) throws Exception {
    	
    	//HttpSession session = request.getSession();
        logger.info("[MYTEST] postHandle");
        //logger.info("session"+(String) session.getAttribute("nicknamae"));

    }

    @Override
    public void afterCompletion(
    		HttpServletRequest request, HttpServletResponse response, Object object, Exception ex
    ) throws Exception {
        logger.info("[MYTEST] afterCompletion");
    }
}
