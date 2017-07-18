package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.altar.upacademy.model.Category;
import org.altar.upacademy.repository.CategoryRepository;

@Named("CategoryBean")
@RequestScoped
public class CategoryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoryRepository categoryRepository;

	public List<Category> getList() {
		return categoryRepository.getDbCategories();
	}

	private Category newCategory = new Category();

	public Category getNewCategory() {
		return newCategory;
	}

	public void setNewCategory(Category newCategory) {
		this.newCategory = newCategory;
	}

	private Category editedCategory = new Category();

	public Category getEditedCategory() {
		return editedCategory;
	}

	public void setEditedCategory(Category editedCategory) {
		this.editedCategory = editedCategory;
	}

	public void addCategory() {
		categoryRepository.addToDb(newCategory);
	}

	public void editCategory() {
		categoryRepository.updateInDb(editedCategory);
	}

	public void deleteCategory(Category category) {
		categoryRepository.removeFromDb(category);
	}

//	@PostConstruct
//	public void init() {
//		if (categoryRepository.isEmpty()) {
//			Category firstCategory = new Category();
//			firstCategory.setCategoryName("Aventura");
//			categoryRepository.addToDb(firstCategory);
//			Category secondCategory = new Category();
//			secondCategory.setCategoryName("Acção");
//			categoryRepository.addToDb(secondCategory);
//			Category thirdCategory = new Category();
//			thirdCategory.setCategoryName("FPS");
//			categoryRepository.addToDb(thirdCategory);
//			Category fourthCategory = new Category();
//			fourthCategory.setCategoryName("Puzzle");
//			categoryRepository.addToDb(fourthCategory);
//		}
//	}
}
