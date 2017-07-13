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
@Table(name = "PLATFORM")
public class Platform extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Platform_ID")
	private Integer platformId = 0;
	@Column(name = "Platform_Name", nullable = true)
	private String platformName = "plataforma";

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public Platform() {
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
		return this.platformName;
	}
}