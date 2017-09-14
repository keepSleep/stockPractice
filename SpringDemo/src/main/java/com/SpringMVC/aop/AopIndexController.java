package com.SpringMVC.aop;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aop")
public class AopIndexController implements AopController {

	@Override
	@RequestMapping("/toView")
	public String toView() {
		return "aop";
	}

	@Override
	@RequestMapping("/back")
	public String back() {
		return "redirect:../mvc/hello";
	}

}
