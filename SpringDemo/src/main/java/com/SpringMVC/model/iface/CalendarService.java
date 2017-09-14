package com.SpringMVC.model.iface;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.SpringMVC.model.Calendar;
@Repository
public interface CalendarService {
	public void addCalendar(Date date,String working,Integer weekday);
	public List<Calendar> getCalendarByYear(String year);

}
