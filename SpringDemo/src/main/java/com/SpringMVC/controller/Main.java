package com.SpringMVC.controller;

import java.util.List;

import com.SpringMVC.model.Stock;
import com.SpringMVC.model.StockDaoImpl;


public class Main {
public static void main(String[] args){
	StockDaoImpl stockdao = new StockDaoImpl();
	Stock stock = new Stock();
	stock.setId(1476);
	stock.setName("儒鴻");
	stockdao.deleteStock(stock);
	stockdao.addstock(stock);
	
	List<Stock> list = stockdao.getAll();
	if(list.isEmpty()){
		System.out.println("list is empty");
	}else{
		for(Stock s:list){
			System.out.println(s.getId()+" "+s.getName());
		}
	}
}
	
}
