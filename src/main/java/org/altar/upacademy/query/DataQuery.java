package org.altar.upacademy.query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.altar.upacademy.model.Login;

public class DataQuery {

	
	EntityManagerFactory emf;
	EntityManager em;
	
	public DataQuery() {
		emf = Persistence.createEntityManagerFactory("database");
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}
	
	public boolean loginControl(String username, String password){
		Login l = em.createNamedQuery("Login.control", Login.class).setParameter("username", username).setParameter("password", password).getSingleResult();
		return false;
	}
	
	
}
