package com.SpringMVC.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringMVC.model.iface.StockService;


public class JPAMain {
	public static void main(String[] args){
//			Stock stock = new Stock();
//			stock.setId(1236);
//			stock.setName("billy公司");
//			new StockDaoImpl().save(stock);
			
			
			
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimplePU");
//			EntityManager em = emf.createEntityManager();
//			em.getTransaction().begin();
//			try{
//			em.persist(stock);
//			em.getTransaction().commit();
//			}catch(Exception e){
//				em.getTransaction().rollback();
//				e.printStackTrace();
//			}finally{
//			emf.close();
//			}
		 ApplicationContext ctx = 
				 new ClassPathXmlApplicationContext("applicationContext.xml"); 
		 StockService service = ctx.getBean("StockService", StockService.class); 
				 
		 service.addStock(1237, "cc");
	}
}
