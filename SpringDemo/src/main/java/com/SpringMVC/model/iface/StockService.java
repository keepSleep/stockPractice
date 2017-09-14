package com.SpringMVC.model.iface;

import java.util.List;

import com.SpringMVC.model.Stock;

public interface StockService {
	public void addStock(Integer id,String name);
	public List<Stock> getAll();
	public List<Stock> findStockById(Integer id);
	
}
