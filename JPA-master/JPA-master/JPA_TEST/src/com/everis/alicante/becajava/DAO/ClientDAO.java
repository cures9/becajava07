package com.everis.alicante.becajava.DAO;

import com.everis.alicante.becajava.Client;

public interface ClientDAO {

	void create(Client client);
	
	Client readById(int id);
	
	void update(Client client);
	
	void delete(Client client);
}
