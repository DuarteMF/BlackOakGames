package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
	
	public void checkPlatformName() {
		boolean platformNameAlreadyExists = false;
		for (Platform iteratedPlatform : platformRepository.getDbPlatforms()) {
			if (newPlatform.getPlatformName().equals(iteratedPlatform.getPlatformName())) {
				platformNameAlreadyExists = true;
				break;
			}
		}
		if (!platformNameAlreadyExists) {
			addPlatform();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
					"There is already a platform with the same name. Please choose another name."));
		}
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

//	@PostConstruct
//	public void init() {
//		if (platformRepository.isEmpty()) {
//			Platform firstPlatform = new Platform();
//			firstPlatform.setPlatformName("PC");
//			platformRepository.addToDb(firstPlatform);
//			Platform secondPlatform = new Platform();
//			secondPlatform.setPlatformName("PS4");
//			platformRepository.addToDb(secondPlatform);
//			Platform thirdPlatform = new Platform();
//			thirdPlatform.setPlatformName("Xbox");
//			platformRepository.addToDb(thirdPlatform);
//			Platform fourthPlatform = new Platform();
//			fourthPlatform.setPlatformName("Switch");
//			platformRepository.addToDb(fourthPlatform);
//		}
//	}
}
