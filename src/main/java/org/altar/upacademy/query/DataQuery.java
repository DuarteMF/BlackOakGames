package org.altar.upacademy.query;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.altar.upacademy.model.Login;

public class DataQuery {

	
//	EntityManagerFactory emf;
	EntityManager em;
	
	public DataQuery() {
//		emf = Persistence.createEntityManagerFactory("database");
//		em = emf.createEntityManager();
//		em.getTransaction().begin();
	}
	
	@Transactional
	public boolean loginControl(String username, String password){
		try{
			Login l = em.createNamedQuery("Login.control", Login.class).setParameter("username", username).setParameter("password", password).getSingleResult();
			if(l != null){
				return true;
			}
			return false;
		}catch (Exception e){
			return false;
		}
	}
	
	
}
