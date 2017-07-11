package org.altar.upacademy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="PLATFORM")

public class Platform implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Platform_ID")
	private Integer Platform_ID = 0;
	@Column(name="Platform_Name", nullable = true)
	private String platformName = "plataforma";
	
	public Integer getPlatform_ID() {
		return Platform_ID;
	}
	public void setPlatform_ID(Integer platform_ID) {
		Platform_ID = platform_ID;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
public Platform(){
}
}