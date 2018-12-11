package com.tuyano.springboot;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * システムエラー画面へ遷移
 */
@Component
public class ErrorExceptionResolver implements HandlerExceptionResolver {

	@Autowired
	HttpSession session;

    private static final Logger logger = LoggerFactory.getLogger(ErrorExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) {

    	logger.error("ErrorExceptionResolver", ex);

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String stackTrace = sw.toString();
		session.setAttribute("SYSTEM_ERROR_MESSAGE", stackTrace);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        mav.addObject("pageID", "X001");
        mav.addObject("title", "システムエラー");
        return mav;

    }

}