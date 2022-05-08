package fr.kleecontrib.domain.client.service;

import fr.kleecontrib.domain.client.Client;
import fr.kleecontrib.domain.id.ClientId;

public interface ClientStore {

	Client get(ClientId clientId);

	void save(Client client);
}
