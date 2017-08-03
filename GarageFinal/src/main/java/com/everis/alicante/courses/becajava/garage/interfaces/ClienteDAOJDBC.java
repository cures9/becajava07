package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import java.sql.*;

public interface ClienteDAOJDBC {
	
 Map<String,Cliente> readClientes() throws IOException;
	 
	 void createCliente(Cliente cliente) throws IOException;
	 
	 Cliente readCliente(String nif) throws IOException;
	 
	 void deleteCliente(String nif);
	 
	 public Connection getConnection() throws IOException;
	 public List<Cliente> readAll();
	
}
