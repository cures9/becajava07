package com.everis.alicante.becajava.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.everis.alicante.becajava.Client;
import com.everis.alicante.becajava.DAO.ClientDAO;
import com.everis.alicante.becajava.Impl.ClientDAOJPAImpl;

public class Test {

	public static void main(String[] args) {
	
		EntityManager em = createEntityManager();
		
		ClientDAO dao = new ClientDAOJPAImpl(em);
		
		System.out.println("Cliente: " + dao.readById(1));
		
		//Crear un cliente
		Client client = new Client();
		
		client.setName("Pepito");
		client.setSurname("Palotes");
		client.setNif("48717958W");
		client.setPhoneNumber("699111201");
		
		dao.create(client);
	}
	
	static EntityManager createEntityManager() {
		
		return Persistence.createEntityManagerFactory("JPA_TEST").createEntityManager();
	}
}
