package com.SpringMVC.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringMVC.model.iface.StockDao;
import com.SpringMVC.model.iface.StockService;

@Service("StockService")
@Transactional
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao StockDao ; 
	
	@Override
	public void addStock(Integer id, String name) {
		Stock stock = new Stock();
		stock.setId(id);
		stock.setName(name);
		StockDao.save(stock);		
	}

	@Override
	public List<Stock> getAll() {
		return StockDao.findAll();	
	}
	
	@Override
	public List<Stock> findStockById(Integer id){
		return StockDao.findStockById(id);
	}
}
