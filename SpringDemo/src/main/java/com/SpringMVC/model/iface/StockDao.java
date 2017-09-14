package com.SpringMVC.model.iface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringMVC.model.Stock;


public interface StockDao extends JpaRepository<Stock,String> {
	public List<Stock> findStockById(Integer id);
}
