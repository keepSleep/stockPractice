package com.SpringMVC.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class WebLogger {

	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void anyRequestMethod(){		
	}
	
	@Pointcut("execution(* com.SpringMVC.aop.*.*(..))")
	public void anyController(){
	}
	
	@Pointcut("execution(public * * (..))")
	public void anyPublicMethod(){
	}
	
	@Pointcut("anyRequestMethod() && anyController() && anyPublicMethod()")
	public void anyInteractionMethod(){
	}
	
	
	@Before("anyInteractionMethod()")
	public void recordIP(JoinPoint pjp) {
	    String remoteAddress = ((ServletRequestAttributes) RequestContextHolder
	             .currentRequestAttributes()).getRequest().getRemoteAddr();
	    System.out.println(pjp.toString() + " ip:" + remoteAddress);
	}
}
