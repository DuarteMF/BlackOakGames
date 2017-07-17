package org.altar.upacademy.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.altar.upacademy.model.Category;

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
	
	public Set<Category> getCategoriesFromNames(List<String> categoryNames){
		Set<Category> categories = new HashSet<>();
		for(String name: categoryNames){
//			TypedQuery<Category> query = getDbConnection().createQuery("SELECT c FROM Category AS c WHERE c.categoryName = ?", Category.class);
//			query.setParameter(1, name);
			TypedQuery<Category> query = getDbConnection().createQuery("SELECT c FROM Category AS c WHERE c.categoryName = :name", Category.class);
			query.setParameter("name", name);
			List<Category> results = query.getResultList();
			categories.add(results.get(0));
		}
		return categories;
	}
}
