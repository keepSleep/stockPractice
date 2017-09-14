package com.SpringMVC.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(StockCalendar.class)
@Table(name = "stockcalendar")
public class StockCalendar implements Serializable {
	
	@Id
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "STOCK_ID")
	private Stock stockId;
	
	@Id
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "CALENDAR_DATE_D")
	private Calendar calendarDate;
	
	@Column(name="CLOSE_PRICE")
	private int closePrice;
	
	public Stock getStock() {
		return stockId;
	}
	public void setStock(Stock stock) {
		this.stockId = stock;
	}
	public Calendar getCalendar() {
		return calendarDate;
	}
	public void setCalendar(Calendar calendar) {
		this.calendarDate = calendar;
	}
	public int getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(int closePrice) {
		this.closePrice = closePrice;
	}
	
}
