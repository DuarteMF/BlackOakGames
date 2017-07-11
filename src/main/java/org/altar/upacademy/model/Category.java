package org.altar.upacademy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;


@javax.persistence.Entity
@Table(name="CATEGORIES")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="CategoriaId")
	private Integer categoryId = 0;
	@Column(name="CategoriaNome")
	private String categoryName = "CategoryName";
	
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
