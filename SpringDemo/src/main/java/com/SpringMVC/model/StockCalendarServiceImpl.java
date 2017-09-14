package com.SpringMVC.model;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringMVC.model.iface.StockCalendarDao;
import com.SpringMVC.model.iface.StockCalendarService;

@Service("StockCalendarService")
@Transactional
public class StockCalendarServiceImpl implements StockCalendarService {

	@Autowired
	StockCalendarDao  StockCalendarDao ; 
	
	@Override
	public List<StockCalendar> getStockCalendarByStockAndYear(int Stockid, String year) {

		return null;
	}

}
