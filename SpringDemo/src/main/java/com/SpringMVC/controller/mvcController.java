package com.SpringMVC.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.SpringMVC.model.Person;



/**
 * @author lin
 * 基礎的controller hello.jsp頁面呼叫的方法都在這
 */
@Controller
@RequestMapping("/mvc")
public class mvcController {

//	測試url呼叫的請求GET , POST方法  http://localhost:8080/SpringMVCparctice/mvc/hello
	@RequestMapping(value = "hello", method = { RequestMethod.GET, RequestMethod.POST })
	public String hello() {
		return "hello";
	}

	@RequestMapping("/person1")
	public String toPerson(Person p) {
		System.out.println(p.getName() + " " + p.getAge());
		return "person1";
	}

	@RequestMapping("/date")
	public String date(Date date,Model model) {
		model.addAttribute("date",date);
		System.out.println(date);
		return "date";
	}
//處理日期參數
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
//利用map參數能直接將值傳到前端
	@RequestMapping("/show")
	public String showPerson(Map<String, Object> map) {
		Person p = new Person();
		map.put("p", p);
		p.setAge(20);
		p.setName("billy");
		return "show";
	}
//頁面重導
	@RequestMapping("/testredirect")
	public String redirect() {
		return "redirect:hello";
	}
//上傳檔案
	@RequestMapping(value = "/upload", method = { RequestMethod.GET, RequestMethod.POST })
	public String upload(HttpServletRequest req) throws IOException {
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		Iterator iter=mreq.getFileNames();
		while(iter.hasNext()){
		MultipartFile file = mreq.getFile(iter.next().toString());
		String fileName = file.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		if(file!=null){
			file.transferTo(new File("E:/linwebcomm/練習/"+req.getSession().getServletContext().getServletContextName() + "/upload/"
					+ sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf("."))));
			}
		}
//		System.out.println(req.getSession().getServletContext().getServletContextName().toString());

//		FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/") + "upload/"
//				+ sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf(".")));
//		fos.write(file.getBytes());
//		fos.flush();
//		fos.close();
		
		return "redirect:hello";
	}
//取得前端參數之資料	
	@RequestMapping("/param")
	public String testRequestParam(@RequestParam(value="id") Integer id ,
			@RequestParam(value="name") String name ,Model model){
		model.addAttribute("id", id);
		model.addAttribute("name",name);
		System.out.println(id+" "+name);		
		return "hello";
	}
//自創一個controller	
	@Controller
	@RequestMapping("/json")
	public class jsonController{
		
		@Autowired
		public jsonController(){}
		
		//使用json格式將資料顯示在前端
		@ResponseBody
		@RequestMapping("/user")
		public Person get(){
			Person p=new Person();
			p.setAge(12);
			p.setName("little little");
			return p;
		}
//		//內部Controller的錯誤攔截
//		@ExceptionHandler
//		public ModelAndView exceptionHandler(Exception ex){
//			ModelAndView mv = new ModelAndView("error");
//			mv.addObject("exception",ex);
//			System.out.println("in textExceptionHandler");		
//			return mv;
//		}
//		
		
		
	}
	//錯誤範例
	@RequestMapping("/error")
	public String error(){
		int i = 5/0;
		return "hello";
	}
	

	
// 測試log4j 	
//	@Controller
//	@RequestMapping("/log4j")
//	public class testLog4j{
//		
//		@Autowired
//		public testLog4j(){};
//		
//		@ResponseBody
//		@RequestMapping("/testlog")
//		public void test(){
//			
//			Logger log =LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
//			String pattern = "Milliseconds since program start: %r %n" + 
//			        "Classname of caller: %C %n" +
//			        "Date in ISO8601 format: %d{ISO8601} %n" +
//			        "Location of log event: %l %n" +
//			        "Message: %m %n %n";
//			log.info("this is info");
//			log.debug("this is debug");
//			
//		}
//		
//	}
}
