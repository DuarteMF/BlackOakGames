package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Client;
import org.altar.upacademy.model.Order;
import org.altar.upacademy.model.Seller;
import org.altar.upacademy.repository.OrderRepository;

@Named("OrderBean")
@RequestScoped
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Order newOrder = new Order();

	private Order editedOrder = new Order();

	public Order getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(Order newOrder) {
		this.newOrder = newOrder;
	}

	public Order getEditedOrder() {
		return editedOrder;
	}

	public void setEditedOrder(Order editedOrder) {
		this.editedOrder = editedOrder;
	}

	@Inject
	private OrderRepository orderRepository;

	public List<Order> getList() {
		return orderRepository.getDbOrder();
	}

	public void addOrder() {
		newOrder.setClient(client);
		newOrder.setSeller(seller);
		orderRepository.addToDb(newOrder);
	}

	public void editOrder() {
		editedOrder.setClient(client);
		editedOrder.setSeller(seller);
		orderRepository.updateInDb(editedOrder);
	}

	public void deleteOrder(Order order) {
		orderRepository.removeFromDb(order);
	}
	
	private Client client;
	
	private Seller seller;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
}
