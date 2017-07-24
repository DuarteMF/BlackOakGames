package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Seller;
import org.altar.upacademy.repository.SellerRepository;

@Named("SellerBean")
@RequestScoped
public class SellerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Seller newSeller = new Seller();

	private Seller editedSeller = new Seller();

	public Seller getNewSeller() {
		return newSeller;
	}

	public void setNewSeller(Seller newSeller) {
		this.newSeller = newSeller;
	}

	public Seller getEditedSeller() {
		return editedSeller;
	}

	public void setEditedSeller(Seller editedSeller) {
		this.editedSeller = editedSeller;
	}

	@Inject
	private SellerRepository sellerRepository;

	public List<Seller> getList() {
		return sellerRepository.getDbSeller();
	}

	public void addSeller() {
		sellerRepository.addToDb(newSeller);
	}

	public void editSeller() {
		sellerRepository.updateInDb(editedSeller);
	}

	public void deleteSeller(Seller seller) {
		sellerRepository.removeFromDb(seller);
	}
}
