package org.altar.upacademy.query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataQuery {

	
	EntityManagerFactory emf;
	EntityManager em;
	
	public DataQuery() {
		emf = Persistence.createEntityManagerFactory("database");
		em = emf.createEntityManager();
	}
	
	
}
