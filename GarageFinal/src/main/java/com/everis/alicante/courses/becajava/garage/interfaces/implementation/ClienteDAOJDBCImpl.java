package com.everis.alicante.courses.becajava.garage.interfaces.implementation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.interfaces.ClienteDAOJDBC;

public class ClienteDAOJDBCImpl implements ClienteDAOJDBC{

	private final String MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String JDBC_CADENA_CONEXION = "jdbc:mysql://localhost:3306/garaje";
	private final String JDBC_USR = "";
	private final String JDBC_PWD = "";
	
	@Override
	public void create(Cliente cliente) throws IOException {
		
		Connection cn = null;
		Statement st = null;
		
		try {
			
			cn = this.getConnection();
			st = cn.createStatement();
			
			String sql = "INSERT INTO CLIENTES"
					+ " VALUES ('" + cliente.getNif() + "','" + cliente.getNombreCompleto() + "')";
			
		}catch(SQLException e) {
			System.out.println("ERROR");
		}finally {
			try {
				cn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Cliente read(String nif) throws IOException {
		return null;
	}

	@Override
	public void update(Cliente cliente) throws IOException {
		
	}

	@Override
	public void delete(String dni) throws IOException {
		
	}

	@Override
	public Connection getConnection() throws IOException {
		
		Connection cn = null;
		try {
//			Carga el driver JDBC
			Class.forName(MYSQL_JDBC_DRIVER);
//			Conexion a la BBDD
			cn = DriverManager.getConnection(JDBC_CADENA_CONEXION);
		}catch(Exception e) {
			System.out.println("Error al obtener la conexion");
		}
		
		return null;
	}

	@Override
	public List<Cliente> readAll() {

		return null;
	}

}