package org.altar.upacademy.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.altar.upacademy.model.Client;

@Named("clientRepository")
@ApplicationScoped
public class ClientRepository extends EntityRepository<Client> {
	public List<Client> getDbClient() {
		Query query = getDbConnection().createQuery("FROM Client");
		List<Client> dbClient = (List<Client>) query.getResultList();
		return dbClient;
	}

	@Override
	@Transactional
	public void removeFromDb(Client client) {
		Client clientToRemove = getDbConnection().find(Client.class, client.getClientId());
		getDbConnection().remove(clientToRemove);
	}
	
	public Client getClientByName(String clientName){
		TypedQuery<Client> query = getDbConnection().createQuery("SELECT c FROM Client AS c WHERE c.clientName = :name", Client.class);
		query.setParameter("name", clientName);
		return query.getSingleResult();
	}
}
