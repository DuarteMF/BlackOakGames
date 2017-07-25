package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Client;
import org.altar.upacademy.model.Order;
import org.altar.upacademy.model.Product;
import org.altar.upacademy.model.ProductUnit;
import org.altar.upacademy.model.Seller;
import org.altar.upacademy.repository.OrderRepository;
import org.altar.upacademy.repository.ProductUnitRepository;

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

//	public void addOrder() {
//		newOrder.setClient(client);
//		newOrder.setSeller(seller);
//		Set<ProductUnit> productUnitSet = new HashSet<>();
//		for(Product product: productSet){
//			productUnitSet.add(productUnitRepository.getProductUnitFromProductId(product.getProductId()));
//		}
//		newOrder.setProductUnitSet(productUnitSet);
//		orderRepository.addToDb(newOrder);
//	}
	
	public void addOrder() {
		newOrder.setClient(client);
		newOrder.setSeller(seller);
		newOrder.setProductUnitSet(productUnitSet);
		orderRepository.addToDb(newOrder);
	}

//	public void editOrder() {
//		editedOrder.setClient(client);
//		editedOrder.setSeller(seller);
//		Set<ProductUnit> productUnitSet = new HashSet<>();
//		for(Product product: productSet){
//			productUnitSet.add(productUnitRepository.getProductUnitFromProductId(product.getProductId()));
//		}
//		newOrder.setProductUnitSet(productUnitSet);
//		orderRepository.updateInDb(editedOrder);
//	}
	
	public void editOrder() {
		editedOrder.setClient(client);
		editedOrder.setSeller(seller);
		editedOrder.setProductUnitSet(productUnitSet);
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
	
	private Set<Product> productSet = new HashSet<>();

	public Set<Product> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}
	
	@Inject
	private ProductUnitRepository productUnitRepository;
	
	private Set<ProductUnit> productUnitSet = new HashSet<>();

	public Set<ProductUnit> getProductUnitSet() {
		return productUnitSet;
	}

	public void setProductUnitSet(Set<ProductUnit> productUnitSet) {
		this.productUnitSet = productUnitSet;
	}
}
