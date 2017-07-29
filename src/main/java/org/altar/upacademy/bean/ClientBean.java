package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Client;
import org.altar.upacademy.repository.ClientRepository;

@Named("ClientBean")
@RequestScoped
public class ClientBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Client newClient = new Client();
	
	private Client editedClient = new Client();
	
	public Client getNewClient() {
		return newClient;
	}

	public void setNewClient(Client newClient) {
		this.newClient = newClient;
	}

	public Client getEditedClient() {
		return editedClient;
	}

	public void setEditedClient(Client editedClient) {
		this.editedClient = editedClient;
	}

	@Inject
	private ClientRepository clientRepository;
	
	public List<Client> getList(){
		return clientRepository.getDbClient();
	}
	
	public void addClient() {
		clientRepository.addToDb(newClient);
	}

	public void editClient() {
		clientRepository.updateInDb(editedClient);
	}

	public void deleteClient(Client client) {
		clientRepository.removeFromDb(client);
	}
	
	public Client getAddedClient(){
		return clientRepository.getClientByName(newClient.getClientName());
	}
}
