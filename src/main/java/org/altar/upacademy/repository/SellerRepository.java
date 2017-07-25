package org.altar.upacademy.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.altar.upacademy.model.Seller;

@Named("sellerRepository")
@ApplicationScoped
public class SellerRepository extends EntityRepository<Seller> {
	public List<Seller> getDbSeller() {
		Query query = getDbConnection().createQuery("FROM Seller");
		List<Seller> dbSeller = (List<Seller>) query.getResultList();
		return dbSeller;
	}

	@Override
	@Transactional
	public void removeFromDb(Seller seller) {
		Seller sellerToRemove = getDbConnection().find(Seller.class, seller.getSellerId());
		getDbConnection().remove(sellerToRemove);
	}
}
