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
import org.altar.upacademy.model.Platform;
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
	
	public Product getProductFromName(String productName){
		TypedQuery<Product> query = getDbConnection().createQuery("SELECT p FROM Product AS p WHERE p.productName = :name", Product.class);
		query.setParameter("name", productName);
		return query.getSingleResult();
	}
	
	public Product getProductFromId(Integer productId){
		TypedQuery<Product> query = getDbConnection().createQuery("SELECT p FROM Product AS p WHERE p.productId = :id", Product.class);
		query.setParameter("id", productId);
		System.out.println(productId);
		return query.getSingleResult();
	}
	
	public List<Product> searchFromCatalog(String searchProduct, Integer categoryId, Integer platformId){
	StringBuilder queryString = new StringBuilder("SELECT * FROM PRODUCT");
	if(categoryId!=null){
		queryString.append(" JOIN PRODUCT_CATEGORIES ON PRODUCT.Product_ID = PRODUCT_CATEGORIES.Product_Product_ID");
	}
	if(platformId!=null){
		queryString.append(" JOIN PRODUCT_PLATFORM ON PRODUCT.Product_ID = PRODUCT_PLATFORM.Product_Product_ID");
	}
	if(searchProduct!=null || categoryId!=null || platformId!=null){
		queryString.append(" WHERE 1=1");
	}
	if(searchProduct!=null){
		queryString.append(" AND Product_Name LIKE '%" + searchProduct + "%'");
	}
	if(categoryId!=null){
		queryString.append(" AND PRODUCT_CATEGORIES.categorySet_Category_ID = " + categoryId);
	}
	if(platformId!=null){
		queryString.append(" AND PRODUCT_PLATFORM.platformSet_Platform_ID = " + platformId);
	}
	Query query = getDbConnection().createNativeQuery(queryString.toString(), Product.class);
	return (List<Product>) query.getResultList();
	}
}
