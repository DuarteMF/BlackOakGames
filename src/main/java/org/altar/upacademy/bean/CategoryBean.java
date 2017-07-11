package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Category;
import org.altar.upacademy.repository.CategoryRepository;


@Named("CategoryBean")
@RequestScoped
public class CategoryBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoryRepository categoryRepository;
	
	public List<Category> getList(){
		return categoryRepository.getDbCategories();
	}
	
	private Category newCategory = new Category();
	
	public Category getNewCategory() {
		return newCategory;
	}

	public void setNewCategory(Category newCategory) {
		this.newCategory = newCategory;
	}


	public void addCategory(){
		categoryRepository.addToDb(newCategory);
	}
	
}
