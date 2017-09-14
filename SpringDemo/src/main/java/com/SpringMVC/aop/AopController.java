package com.SpringMVC.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface AopController {
	@RequestMapping
	public String toView();
	@RequestMapping(method=RequestMethod.GET)
	public String back();
	
}
