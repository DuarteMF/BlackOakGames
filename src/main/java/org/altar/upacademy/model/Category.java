package org.altar.upacademy.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "CATEGORIES")
public class Category extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Category_Id")
	private Integer categoryId = 0;
	@Column(name = "Category_Name", unique = true)
	private String categoryName = null;

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

	public Category() {

	}
	
	@ManyToMany(targetEntity=Product.class, fetch=FetchType.EAGER)
	private Set<Product> productSet;

	public Set<Product> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}

	@Override
	public String toString(){
		return this.categoryName;
	}
	
	@Override
	public boolean equals(Object category){
		return this.categoryId.equals(((Category) category).getCategoryId());
	}
}
