package org.altar.upacademy.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
	
	public Set<Platform> getPlatformsFromNames(List<String> platformNames){
		Set<Platform> platforms = new HashSet<>();
		for(String name: platformNames){
//			TypedQuery<Platform> query = getDbConnection().createQuery("SELECT p FROM Platform AS p WHERE p.platformName = ?", Platform.class);
//			query.setParameter(1, name);
			TypedQuery<Platform> query = getDbConnection().createQuery("SELECT p FROM Platform AS p WHERE p.platformName = :name", Platform.class);
			query.setParameter("name", name);
			List<Platform> results = query.getResultList();
			platforms.add(results.get(0));
		}
		return platforms;
	}
}