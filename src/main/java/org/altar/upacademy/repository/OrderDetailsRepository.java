package org.altar.upacademy.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.altar.upacademy.model.OrderDetails;

@Named("orderdetailsRepository")
@ApplicationScoped
public class OrderDetailsRepository extends EntityRepository<OrderDetails> {
	public List<OrderDetails> getDbOrderDetails() {
		Query query = getDbConnection().createQuery("FROM OrderDetails");
		List<OrderDetails> dbOrderDetails = (List<OrderDetails>) query.getResultList();
		return dbOrderDetails;
	}
	@Override
	@Transactional
	public void removeFromDb(OrderDetails orderdetails) {
		OrderDetails orderdetailsToRemove = getDbConnection().find(OrderDetails.class, orderdetails.getOrderDetailsId());
		getDbConnection().remove(orderdetailsToRemove);
	}
}
