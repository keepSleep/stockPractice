package com.SpringMVC.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 自訂一個錯誤攔截器  另一種 放在spring-config.xml內bean設定檔 
//@ControllerAdvice
public class testControllerAdvice {

	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception ex){
		ModelAndView mv =new ModelAndView("error");
		mv.addObject("exception",ex);
		System.out.println("in testControllerAdvice");
		return mv;
	}
	
	
}
