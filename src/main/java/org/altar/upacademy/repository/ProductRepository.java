package org.altar.upacademy.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.altar.upacademy.model.Product;

@Named("productRepository")
@ApplicationScoped
public class ProductRepository extends EntityRepository<Product> {

	public List<Product> getDbProduct() {
		Query query = getDbConnection().createQuery("FROM Product");
		List<Product> dbProduct = (List<Product>) query.getResultList();
		return dbProduct;
	}

	@Override
	@Transactional
	public void removeFromDb(Product product) {
		Product productToRemove = getDbConnection().find(Product.class, product.getProductId());
		getDbConnection().remove(productToRemove);
	}
}
