package com.SpringMVC.model.iface;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.SpringMVC.model.StockCalendar;

@Repository
public interface StockCalendarService {
	public List<StockCalendar> getStockCalendarByStockAndYear(int Stockid,String year);
}
