package org.altar.upacademy.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.altar.upacademy.model.ProductUnit;

@Named("productUnitRepository")
@ApplicationScoped
public class ProductUnitRepository extends EntityRepository<ProductUnit> {
	public List<ProductUnit> getDbProductUnit() {
		Query query = getDbConnection().createQuery("FROM ProductUnit");
		List<ProductUnit> dbProductUnit = (List<ProductUnit>) query.getResultList();
		return dbProductUnit;
	}

	@Override
	@Transactional
	public void removeFromDb(ProductUnit productUnit) {
		ProductUnit productUnitToRemove = getDbConnection().find(ProductUnit.class, productUnit.getProductUnitId());
		getDbConnection().remove(productUnitToRemove);
	}
}
