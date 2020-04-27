package com.yz.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//该注解可以拦截所有被Controller注解修饰的请求
@ControllerAdvice
public class ControllerExceptionHandler {
    //获取日志
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //拦截异常器（异常类）
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest req, HttpServletResponse resp,Exception e) throws Exception {
        logger.error("Request url : {}, Exception : {}",req.getRequestURI(),e);
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null){
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",req.getRequestURL());
        mv.addObject("exception",e);
        //转到自定义的错误页面
        mv.setViewName("error/error");
        return mv;
    }
}
