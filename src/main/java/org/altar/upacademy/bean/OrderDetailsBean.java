package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.OrderDetails;
import org.altar.upacademy.repository.OrderDetailsRepository;

@Named("OrderDetailsBean")
@RequestScoped
public class OrderDetailsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private OrderDetails newOrderDetails = new OrderDetails();
	
	private OrderDetails editedOrderDetails = new OrderDetails();

	public OrderDetails getNewOrderDetails() {
		return newOrderDetails;
	}

	public void setNewOrderDetails(OrderDetails newOrderDetails) {
		this.newOrderDetails = newOrderDetails;
	}

	public OrderDetails getEditedOrderDetails() {
		return editedOrderDetails;
	}

	public void setEditedOrderDetails(OrderDetails editedOrderDetails) {
		this.editedOrderDetails = editedOrderDetails;
	}
	@Inject
	private OrderDetailsRepository orderdetailsRepository;

	public List<OrderDetails> getList(){
		return orderdetailsRepository.getDbOrderDetails();
	}

	public void addOrderDetails() {
		orderdetailsRepository.addToDb(newOrderDetails);
	}

	public void editOrderDetails() {
		orderdetailsRepository.updateInDb(editedOrderDetails);
	}

	public void deleteClient(OrderDetails orderdetails) {
		orderdetailsRepository.removeFromDb(orderdetails);
	}
}
