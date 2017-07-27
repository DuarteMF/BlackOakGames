package org.altar.upacademy.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;

import org.altar.upacademy.model.Login;

@Named("loginRepository")
@ApplicationScoped
public class LoginRepository extends EntityRepository<Login>{
	
	public List<Login> getDbLogin() {
		Query query = getDbConnection().createQuery("FROM Login");
		List<Login> dbLogin = (List<Login>) query.getResultList();
		return dbLogin;
	}
}
