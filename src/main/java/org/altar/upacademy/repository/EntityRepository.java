package org.altar.upacademy.repository;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
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
	public Entity readFromDb(Integer id){
		System.out.println(2);
		return em.find(Entity.class, id);
	}
	
	@Transactional
	public void updateInDb(E entity){
		em.merge(entity);
	}
	
	@Transactional
	public void removeFromDb(E entity){
		em.remove(entity);
	}
	
	@Transactional
	public void addBatch(E entity, int quantity){
		em.setFlushMode(FlushModeType.COMMIT);
		int batchSize = 30;
		
//		em.getTransaction().begin();
		
		for(int i=0; i < quantity; i++){
			em.persist(entity);
			if (i % batchSize == 0 && i > 0) {
	            em.flush();
	            em.clear();
	        }
		}
		
//		em.getTransaction().commit();
	}
	
	public void editBatch(){
		// Feature to be added later
	}
}
