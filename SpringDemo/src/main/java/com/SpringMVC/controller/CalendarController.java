package com.SpringMVC.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringMVC.bean.CalendarShow;
import com.SpringMVC.model.Calendar;
import com.SpringMVC.model.iface.CalendarService;
import com.google.gson.Gson;
/**
 * @author lin
 * 創建行事曆的controller 去搜尋calendar的table
 */
@Controller
@RequestMapping("/Calendar")
public class CalendarController {
	@Autowired
	private CalendarService CalendarService;
	
	@RequestMapping("/index")
	public String toView(){
		return "Calendar";
	}
	
	@RequestMapping("/add")
	public String addCalendar(@RequestParam(value="date") Date date,@RequestParam(value="working")String working,@RequestParam(value="weekday")int weekday){
		CalendarService.addCalendar(date, working, weekday);
		return "Calendar";
	}
	
	//處理日期參數
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String getAllByYear(@RequestParam(value="year") String year){
		List<CalendarShow> showlist = new LinkedList();
		List<Calendar> list = CalendarService.getCalendarByYear(year);
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		for(Calendar c:list){
			CalendarShow calendarshow = new CalendarShow();
			calendarshow.setDate(sdf.format(c.getDate()));
			calendarshow.setWeekday(c.getWeekday());
			calendarshow.setWorking(c.getWorking());
			showlist.add(calendarshow);
		}
		Gson gson = new Gson();
		String json = gson.toJson(showlist);
		return json;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping("/put")
//	public String add() throws ParseException{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat week = new SimpleDateFormat("EEEE");
//		GregorianCalendar firstday = new GregorianCalendar(2017, 01,01);
//		GregorianCalendar lastday = new GregorianCalendar(2018, 01,01);
//		long totalyear = lastday.getTimeInMillis()-firstday.getTimeInMillis();
//		long day=totalyear/24/60/60/1000;
//		String today="2017-01-";
//		int a=01;
//		for(int i=1;i<=day;i++){
//			Date date = sdf.parse(today+a);
//			String working="Y";
//			Integer weekday=0;
//			if(week.format(date).equals("星期六")||week.format(date).equals("星期日")){
//				working="N";
//			}
//			if(week.format(date).equals("星期一")){
//				weekday=1;
//			}else if(week.format(date).equals("星期二")){
//				weekday=2;
//			}else if(week.format(date).equals("星期三")){
//				weekday=3;
//			}else if(week.format(date).equals("星期四")){
//				weekday=4;
//			}else if(week.format(date).equals("星期五")){
//				weekday=5;
//			}else if(week.format(date).equals("星期六")){
//				weekday=6;
//			}else if(week.format(date).equals("星期日")){
//				weekday=7;
//			}
//			CalendarService.addCalendar(date, working, weekday);
//			a++;
//		}
//		return "redirect:index";
//	}
	
}
