package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Platform;
import org.altar.upacademy.repository.PlatformRepository;



@Named("PlatformBean")
@RequestScoped
public class PlatformBean implements Serializable {

private static final long serialVersionUID = 1L;
	
	private Platform newPlatform = new Platform();
	
	public Platform getNewPlatform() {
		return newPlatform;
	}

	public void setNewPlatform(Platform newPlatform) {
		this.newPlatform = newPlatform;
	}
	
	private Platform editedPlatform = new Platform();

	public Platform getEditedPlatform() {
		return editedPlatform;
	}

	public void setEditedPlatform(Platform editedPlatform) {
		this.editedPlatform = editedPlatform;
	}

	@Inject
	private PlatformRepository platformRepository;
	
	public List<Platform> getList() {
		return platformRepository.getDbPlatforms();
	}


	public void addPlatform() {
		platformRepository.addToDb(newPlatform);
	}
	
	public void editPlatform() {
		platformRepository.updateInDb(editedPlatform);
	}
	
	public void deletePlatform(Platform platform) {
		platformRepository.removeFromDb(platform);
	}
}
