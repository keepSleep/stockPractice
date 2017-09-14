package com.SpringMVC.model;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;
	


//@Repository("StockDao")
public class StockDaoImpl //implements StockDao
{
	
//	 @PersistenceContext 
//	 private EntityManager em; 
	 
	 
	SessionFactory sessionFactory;
	public StockDaoImpl(){
		 sessionFactory = new HibernateUtil().getSessionFactory();
	}
	
	
	public void deleteStock(Stock stock){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		session.delete(stock);
		session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();
			}finally{
			session.close();
			}	
	}
	
	
	public List getAll(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List list = new LinkedList();
		try{
		list = session.createQuery("from Stock").list();
		session.getTransaction().commit();
		}catch(Exception e){
		session.getTransaction().rollback();
		e.printStackTrace();
		}finally{
		session.close();
		}
		
//		Query query;
//		List list = null;
//		em.getTransaction().begin();
//		try{
//		query=em.createQuery("select * from stock");
//		list=query.getResultList();
//		em.getTransaction().commit();
//		}catch(Exception e){
//			em.getTransaction().rollback();
//			e.printStackTrace();
//		}
		return list;
	}



	public void addstock(Stock stock) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		session.save(stock);
		session.getTransaction().commit();
		}catch(Exception e){
		session.getTransaction().rollback();
		e.printStackTrace();
		}finally{
		session.close();
		}
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimplePU");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		try{
//		em.persist(stock);
//		em.getTransaction().commit();
//		}catch(Exception e){
//			em.getTransaction().rollback();
//			e.printStackTrace();
//		}finally{
//		emf.close();
//		}
		
	}
}
