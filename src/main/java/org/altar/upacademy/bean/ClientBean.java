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
	
	private Client edtiedClient = new Client();
	
	@Inject
	private ClientRepository clientRepository;
	
	public List<Client> getList(){
		return clientRepository.getDbClient();
	}
	
	public void addClient() {
		clientRepository.addToDb(newClient);
	}

	public void editClient() {
		clientRepository.updateInDb(edtiedClient);
	}

	public void deleteClient(Client client) {
		clientRepository.removeFromDb(client);
	}
}
