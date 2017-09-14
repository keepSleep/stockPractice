package com.SpringMVC.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringMVC.model.Stock;
import com.SpringMVC.model.iface.StockService;
import com.google.gson.Gson;

/**
 * @author lin
 * 測試datatable的controller，傳遞json格式給前台的datatable去接
 */
@Controller
@RequestMapping("/table")
public class DataTableController {
	
	@Autowired
	private StockService StockService;
	
	@RequestMapping(value="list",method={RequestMethod.GET})
	public String getAll(Map<String,Object> m){
		List list = StockService.getAll();
		m.put("tablelist", list);
		return "tablelist";
	}

	@ResponseBody
	@RequestMapping("/json")
	public String get(){
		Map map=new HashMap();
		List<Stock> list = StockService.getAll();
		map.put("aaData", list);
		Gson gson = new Gson();
		String json = gson.toJson(map);
		return json;
	}
	
}
