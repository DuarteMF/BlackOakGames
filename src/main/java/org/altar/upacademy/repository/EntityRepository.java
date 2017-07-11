package org.altar.upacademy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.altar.upacademy.model.Entity;

public class EntityRepository<E extends Entity> {

	@PersistenceContext(unitName="database")
	private EntityManager em;
	
	public EntityManager getDbConnection(){
		return em;
	}
	
	@Transactional
	public void addToDb(E entity){
		em.persist(entity);
	}
	
	@Transactional
	public void readFromDb(E entity){
		em.find(Entity.class, entity);
	}
	
	@Transactional
	public void updateInDb(E entity){
		em.merge(entity);
	}
	
	@Transactional
	public void removeFromDb(E entity){
		em.remove(entity);
	}
}
