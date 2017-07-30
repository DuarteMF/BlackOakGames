package org.altar.upacademy.query;



import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.altar.upacademy.model.Login;

@Named("DataQuery")
@RequestScoped
public class DataQuery {

	
//	EntityManagerFactory emf;
	@PersistenceContext(unitName="database")
	EntityManager em;
	
	public DataQuery() {
//		emf = Persistence.createEntityManagerFactory("database");
//		em = emf.createEntityManager();
//		em.getTransaction().begin();
	}
	
//	@Transactional
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
	
	public Login getUser(String username, String password){
		return em.createNamedQuery("Login.control", Login.class).setParameter("username", username).setParameter("password", password).getSingleResult();
	}
	
}
