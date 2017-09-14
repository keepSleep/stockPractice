package com.SpringMVC.model.iface;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SpringMVC.model.StockCalendar;
@Repository
public interface StockCalendarDao extends JpaRepository<StockCalendar,String> {
//	@Query("SELECT sc FROM StockCalendar sc WHERE sc.stock.id = :id and sc.calendar.date= :year")
//	public List<StockCalendar> find(@Param("id")Integer stockid,@Param("year")Date year);
}
