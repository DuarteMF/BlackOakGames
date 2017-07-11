package org.altar.upacademy.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;

import org.altar.upacademy.model.Category;

@Named("categoryRepository")
@ApplicationScoped
public class CategoryRepository extends EntityRepository<Category>{
	
	public List<Category> getDbCategories(){
		Query query = getDbConnection().createQuery("FROM Category");
		List<Category> dbCategories = (List<Category>) query.getResultList();
		return dbCategories;
	}
}
