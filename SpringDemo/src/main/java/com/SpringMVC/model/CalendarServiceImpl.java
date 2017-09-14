package com.SpringMVC.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringMVC.model.iface.CalendarDao;
import com.SpringMVC.model.iface.CalendarService;
@Service("CalendarService")
@Transactional
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	CalendarDao CalendarDao;
	
	
	@Override
	public void addCalendar(Date date,String working,Integer weekday) {
		Calendar calendar = new Calendar();
		calendar.setDate(date);
		calendar.setWorking(working);
		calendar.setWeekday(weekday);
		CalendarDao.save(calendar);
	}

	@Override
	public List<Calendar> getCalendarByYear(String year) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

		List<Calendar> list = null;
		Integer nextyear = new Integer(year)+1;
		try {
			list = CalendarDao.findByDateLike(sdf.parse(year),sdf.parse(nextyear.toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return list;
	
	}

}
