package com.yz.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

//开启aop
@Aspect
@Component
public class LogAspect {

    private final Logger logger =  LoggerFactory.getLogger(this.getClass());
    //横切的方法（这样定义更方便多个增强切入同一个切入点）
    @Pointcut("execution(* com.yz.controller.*.*(..))")
    public void log(){}

    //在执行方法前切入
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //获取信息
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog log = new RequestLog(url, ip, classMethod, args);
        //具体的日志输出
        logger.info("访问者信息 : {}", log);
    }

    //定义内部类，封装访问者信息
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        public RequestLog() {
        }

        @Override
        public String toString() {
            return "访问url：'" + url + '\'' +
                    ", 请求的ipv6地址：'" + ip + '\'' +
                    ", 请求的方法：'" + classMethod + '\'' +
                    ", 请求参数：" + Arrays.toString(args);
        }
    }
}