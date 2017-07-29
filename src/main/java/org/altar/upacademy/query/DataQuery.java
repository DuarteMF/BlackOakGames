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
			System.out.println(username);
			System.out.println(password);
			Login l = em.createNamedQuery("Login.control", Login.class).setParameter("username", username).setParameter("password", password).getSingleResult();
//			Login l = (Login) em.createNativeQuery("SELECT * FROM LOGIN WHERE Username = '"+ username + "' and Password = '" + password + "'", Login.class).getResultList().get(0);
//			Login l = (Login) em.createNativeQuery("SELECT * FROM LOGIN", Login.class).getResultList().get(0);
			System.out.println(l);
			if(l != null){
				return true;
			}
			return false;
		}catch (Exception e){
			System.out.println("teste "+ e.getMessage());
			return false;
		}
	}
	
	
}
