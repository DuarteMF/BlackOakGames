package org.altar.upacademy.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
	
	public ProductUnit getProductUnitFromProductId(Integer productId){
		TypedQuery<ProductUnit> query = getDbConnection().createQuery("SELECT p FROM ProductUnit AS p WHERE p.product.productId = :id", ProductUnit.class);
		query.setParameter("id", productId);
		return query.getSingleResult();
	}
	
	public ProductUnit getAvaliableProductUnitFromProductIdAndPlatform(Integer productId, Integer platformId){
		Query query = getDbConnection().createNativeQuery("SELECT * FROM PRODUCT_UNITS WHERE product_Product_ID = :productId AND productPlatform_Platform_ID = :platformId", ProductUnit.class);
		query.setParameter("productId", productId);
		query.setParameter("platformId", platformId);
		return (ProductUnit) query.getResultList().get(0);
	}
}
