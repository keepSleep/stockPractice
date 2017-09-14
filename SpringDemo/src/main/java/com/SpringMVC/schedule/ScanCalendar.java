package com.SpringMVC.schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.SpringMVC.model.Calendar;
import com.SpringMVC.model.iface.CalendarService;


@Component
public class ScanCalendar{

	@Autowired
	private CalendarService CalendarService;

//	@Scheduled(cron = "0 * * * * ?")
	public void show(){
		System.out.println("run.............");
	}
	
//	@Scheduled(cron = "0 0 14 * * ?")
	public void checkCalendar() throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
		String year = sdf1.format(new Date());
		Integer thisyear = new Integer(year);
		System.out.println("開始新增");
		for (int j = 0; j < 2; j++) {
			year=thisyear.toString();
			System.out.println(CalendarService);
			List<Calendar> list = CalendarService.getCalendarByYear(year);

			if (list.isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat week = new SimpleDateFormat("EEEE");
//				SimpleDateFormat week = new SimpleDateFormat("u");//數字
				GregorianCalendar firstday = new GregorianCalendar(new Integer(year), 01, 01);
				GregorianCalendar lastday = new GregorianCalendar(new Integer(year) + 1, 01, 01);
				long totalyear = lastday.getTimeInMillis() - firstday.getTimeInMillis();
				long day = totalyear / 24 / 60 / 60 / 1000;
				String today = year + "-01-";
				int a = 01;
				for (int i = 1; i <= day; i++) {
					Date date = sdf.parse(today + a);
					String working = "Y";
					Integer weekday = 0;
					if (week.format(date).equals("星期六") || week.format(date).equals("星期日")) {
						working = "N";
					}
					if (week.format(date).equals("星期一")) {
						weekday = 1;
					} else if (week.format(date).equals("星期二")) {
						weekday = 2;
					} else if (week.format(date).equals("星期三")) {
						weekday = 3;
					} else if (week.format(date).equals("星期四")) {
						weekday = 4;
					} else if (week.format(date).equals("星期五")) {
						weekday = 5;
					} else if (week.format(date).equals("星期六")) {
						weekday = 6;
					} else if (week.format(date).equals("星期日")) {
						weekday = 7;
					}
					CalendarService.addCalendar(date, working, weekday);
					a++;
				}
			}
			thisyear++;
		}
	}
}
