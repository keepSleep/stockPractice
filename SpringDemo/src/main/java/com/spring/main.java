package com.spring;


import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 
		 HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		 obj.getMessage();
	}
}
