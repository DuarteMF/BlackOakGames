package org.altar.upacademy.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.altar.upacademy.model.Login;

@Named("loginRepository")
@ApplicationScoped
public class LoginRepository extends EntityRepository<Login>{
	
	public List<Login> getDbLogin() {
		Query query = getDbConnection().createQuery("FROM Login");
		List<Login> dbLogin = (List<Login>) query.getResultList();
		return dbLogin;
	}
	
	public List<Login> getLoginFromName(String loginName){
		TypedQuery<Login> query = getDbConnection().createQuery("SELECT l FROM Login AS l WHERE l.username = :name", Login.class);
		query.setParameter("name", loginName);
		return query.getResultList();
	}
}
