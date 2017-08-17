package com.everis.alicante.becajava.Impl;

import javax.persistence.EntityManager;

import com.everis.alicante.becajava.Client;
import com.everis.alicante.becajava.DAO.ClientDAO;

public class ClientDAOJPAImpl implements ClientDAO{

	EntityManager em;
	
	public ClientDAOJPAImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(Client client) {
		em.merge(client);
	}

	public Client readById(int id) {
		
		return em.find(Client.class, id);
	}

	public void update(Client client) {

		em.persist(client);
	}

	public void delete(Client client) {
		
		em.remove(client);
	}

}
