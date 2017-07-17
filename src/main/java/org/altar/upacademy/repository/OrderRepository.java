package org.altar.upacademy.repository;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.altar.upacademy.model.Order;

@Named("orderRepository")
@ApplicationScoped
public class OrderRepository extends EntityRepository<Order> {
	public List<Order> getDbOrder() {
		Query query = getDbConnection().createQuery("FROM Order");
		List<Order> dbOrder = (List<Order>) query.getResultList();
		return dbOrder;
	}
	@Override
	@Transactional
	public void removeFromDb(Order order) {
		Order orderToRemove = getDbConnection().find(Order.class, order.getOrderId());
		getDbConnection().remove(orderToRemove);
	}
}
