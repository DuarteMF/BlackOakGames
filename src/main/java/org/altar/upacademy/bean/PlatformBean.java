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
import org.primefaces.event.CellEditEvent;



@Named("PlatformBean")
@RequestScoped
public class PlatformBean implements Serializable {
//	private int platformId;
//	private String platformName;
//	
//	public int getPlatformId() {
//		return platformId;
//	}
//	public void setPlatformId(int platformId) {
//		this.platformId = platformId;
//	}
//	public String getPlatformName() {
//		return platformName;
//	}
//	public void setPlatformName(String platformName) {
//		this.platformName = platformName;
//	}
/**
 * 
 */
private static final long serialVersionUID = 1L;
	
//	private Platform selectedPlatform = new Platform();
//	
//	public Platform getSelectedPlatform() {
//		return selectedPlatform;
//	}
//	
//	public void setSelectedPlatform(Platform selectedPlatform) {
//		this.selectedPlatform = selectedPlatform;
//	}
//	
//	private Platform displayedPlatform = new Platform();
//	
//	public Platform getDisplayedPlatform() {
//		return displayedPlatform;
//	}
//
//	public void setDisplayedPlatform(Platform displayedPlatform) {
//		this.displayedPlatform = displayedPlatform;
//	}

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
	
//	public String editProduct() {
//		productService.editEntity(id, name, shelfId, discount, tax, price);
//		return null;
//	}
//
//	public String deleteProduct() {
//		productService.removeEntity(productService.getProductRepository(), selectedProduct);
//		return null;
//	}
//	
//	@Inject
//	private ShelfService shelfService;
//	public List<Integer> existingShelves(){
//		List<Shelf> existingShelvesList = shelfService.getShelfRepository().getDbElements();
//		List<Integer> existingShelvesId = new ArrayList<>();
//		for(Shelf shelf:existingShelvesList){
//			existingShelvesId.add(shelf.getId());
//		}
//		return existingShelvesId;
//	}
//}

}
