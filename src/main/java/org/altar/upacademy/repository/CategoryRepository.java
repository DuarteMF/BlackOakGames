package org.altar.upacademy.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.altar.upacademy.model.Category;
import org.altar.upacademy.model.Platform;

@Named("categoryRepository")
@ApplicationScoped
public class CategoryRepository extends EntityRepository<Category>{
	
	public List<Category> getDbCategories(){
		Query query = getDbConnection().createQuery("FROM Category");
		List<Category> dbCategories = (List<Category>) query.getResultList();
		return dbCategories;
	}
	
	@Override
	@Transactional
	public void removeFromDb(Category category) {
		Category categoryToRemove = getDbConnection().find(Category.class, category.getCategoryId());
		getDbConnection().remove(categoryToRemove);
	}
}
