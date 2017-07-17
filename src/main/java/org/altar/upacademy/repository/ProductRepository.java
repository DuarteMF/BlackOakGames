package org.altar.upacademy.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.altar.upacademy.model.Category;
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
	
	public Set<Product> getProductsFromNames(List<String> productNames){
		Set<Product> products = new HashSet<>();
		for(String name: productNames){
//			TypedQuery<Category> query = getDbConnection().createQuery("SELECT c FROM Category AS c WHERE c.categoryName = ?", Category.class);
//			query.setParameter(1, name);
			TypedQuery<Product> query = getDbConnection().createQuery("SELECT p FROM Product AS p WHERE p.productName = :name", Product.class);
			query.setParameter("name", name);
			List<Product> results = query.getResultList();
			products.add(results.get(0));
		}
		return products;
	}
}
