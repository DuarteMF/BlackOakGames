package org.altar.upacademy.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.altar.upacademy.model.Category;

@Named("categoryRepository")
@ApplicationScoped
public class CategoryRepository extends EntityRepository<Category>{
	
	
	
}
