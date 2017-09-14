package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static final StandardServiceRegistry serviceRegistry;
	static {
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
					configuration.getProperties()).build();
			sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		}catch(Throwable ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void closeAllResources() {
        sessionFactory.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
}
