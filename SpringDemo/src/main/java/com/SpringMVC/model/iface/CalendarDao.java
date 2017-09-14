package com.SpringMVC.model.iface;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SpringMVC.model.Calendar;
@Repository
public interface CalendarDao extends JpaRepository<Calendar,String>{
	@Query("SELECT c FROM Calendar c WHERE c.date between :year and :year2")
	public List<Calendar> findByDateLike(@Param("year")Date year,@Param("year2")Date year2);
//	
//	public List<Calendar> findByDateStartingWith(Date year);
}
