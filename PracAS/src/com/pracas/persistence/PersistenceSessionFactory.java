package com.pracas.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class PersistenceSessionFactory {
	
	private static PersistenceSessionFactory persistenceSessionFactory = null;
	
	private Configuration configuration = null;
	private StandardServiceRegistryBuilder serviceRegistryBuilder = null;
	private ServiceRegistry serviceRegistry = null;
	private SessionFactory sessionFactory = null;
	private Session s = null;
	
	private PersistenceSessionFactory() {
		this.configuration=new Configuration().configure();
		this.serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		this.serviceRegistryBuilder.applySettings(configuration.getProperties());
		this.serviceRegistry = serviceRegistryBuilder.build();
		this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static PersistenceSessionFactory getInstance() {
		if (persistenceSessionFactory == null) {
			persistenceSessionFactory = new PersistenceSessionFactory();
		}
		return persistenceSessionFactory;
	}
	
	public Session openSession() {
		if (s == null) {
			s = sessionFactory.openSession();
		} else {
			if (!s.isOpen()) {
				s = sessionFactory.openSession();
			}
		}
		return s;
	}
	
	public void closeSession() {
		s.close();
	}
	
}
