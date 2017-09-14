package com.SpringMVC.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="calendar")
public class Calendar implements Serializable {

	@Id
	@Column(name="DATE_D")
	private Date date;
	@Column(name="WORKING")
	private String working;
	@Column(name="DAY_FOR_WEEK")
	private Integer weekday;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="calendarDate",cascade=CascadeType.ALL)
	private List<StockCalendar> stockCalendar;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getWorking() {
		return working;
	}
	public void setWorking(String working) {
		this.working = working;
	}
	public Integer getWeekday() {
		return weekday;
	}
	public void setWeekday(Integer weekday) {
		this.weekday = weekday;
	}
}
