package org.altar.upacademy.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
	
	public Set<Product> getProductsFromIds(List<Integer> productIds){
		Set<Product> products = new HashSet<>();
		for(Integer id: productIds){
			TypedQuery<Product> query = getDbConnection().createQuery("SELECT p FROM Product AS p WHERE p.productId = :id", Product.class);
			query.setParameter("id", id);
			List<Product> results = query.getResultList();
			products.add(results.get(0));
		}
		return products;
	}
}
