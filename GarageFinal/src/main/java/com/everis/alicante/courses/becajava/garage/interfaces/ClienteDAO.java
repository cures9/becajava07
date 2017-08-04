package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.mysql.jdbc.Connection;

public interface ClienteDAO {

	public void create(Cliente cliente) throws IOException;
	public Cliente read(String nif) throws IOException;
	public void update(Cliente cliente) throws IOException;
	public void delete(String dni) throws IOException;
	public Connection getConnection() throws IOException;
	public List<Cliente> readAll();
	public Map<String, Cliente> readClientes();
	public Cliente readCliente(String string);
	public void createCliente(Cliente cliente);
	
}
