package com.SpringMVC.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="stock")
public class Stock implements Serializable{
	@Id
	private int id;
	
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="stockId",cascade=CascadeType.ALL)
	private List<StockCalendar> stockCalendar;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
