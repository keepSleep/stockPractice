package com.SpringMVC.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SpringMVC.model.Person;



/**
 * @author lin
 *	檢查欄位格式是否正確，錯誤跳出提示
 */
@Controller
@RequestMapping("/form")
public class VaildFormController {
	
	
	@RequestMapping(value="add" ,method={RequestMethod.POST})
	public String add(@Valid Person p,BindingResult br,Map<String,Object> m){
		if(br.getErrorCount()>0){
			return "form";
		}
		m.put("person",p);
		return "addUser";
	}
	
	@RequestMapping(value="add" ,method={RequestMethod.GET})
	public String add(Map<String,Object> m){
		m.put("person", new Person());
		return "form";
	}
}
