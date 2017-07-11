package org.altar.upacademy.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.altar.upacademy.model.Platform;

@Named("platformRepository")
@ApplicationScoped
public class PlatformRepository extends EntityRepository<Platform> {

	public List<Platform> getDbPlatforms() {
		Query query = getDbConnection().createQuery("FROM Platform");
		List<Platform> dbPlatforms = (List<Platform>) query.getResultList();
		return dbPlatforms;
	}

	@Override
	@Transactional
	public void removeFromDb(Platform platform) {
		Platform platformToRemove = getDbConnection().find(Platform.class, platform.getPlatformId());
		getDbConnection().remove(platformToRemove);
	}
	//
	// @Transactional
	// public void alterInDb(int id, String name, List<Integer> platformId,
	// string platformName){
	// Platform dbPlatform = getDb().find(Platform.class, id);
	// dbPlatform.setName(name);
	// }
}