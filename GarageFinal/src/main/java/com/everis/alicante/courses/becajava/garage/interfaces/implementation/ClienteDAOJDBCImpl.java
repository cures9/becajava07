package com.everis.alicante.courses.becajava.garage.interfaces.implementation;

import java.io.IOException;
import java.util.Map;
import com.everis.alicante.courses.becajava.garage.ClientDAOJDBC;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import java.sql.*;


public class ClienteDAOJDBCImpl implements ClientDAOJDBC {
	
	private final String MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String JDBC_CADENA_CONEXION = "jdbc:mysql://localhost:3306/garaje";



	@Override
	public void deleteCliente(String nif) {

	}

	@Override
	public Connection getConnection()  {
		// TODO Auto-generated method stub
		Connection cn = null;
		
		try {
			Class.forName(MYSQL_JDBC_DRIVER);
			
			cn = DriverManager.getConnection(JDBC_CADENA_CONEXION);
		}
		catch (Exception e) {
			System.out.println("Error al obtener la conexion");
		}
		return cn;
	}

	@Override
	public Map<String, Cliente> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Cliente> readClientes() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCliente(Cliente cliente) throws IOException {
		// TODO Auto-generated method stub
		
		Connection cn = null;
		Statement st = null;
		
		try {
			
			cn = this.getConnection();
			st = cn.createStatement();
			
			String sql = " INSERT INTO VEHICULOS(MARTRICULA, TIPO_VEHICULO)"
					+ "VALUES ('"+ cliente.getNif() + "," + cliente.getVehiculo() + ","
					+ cliente.getNombreCompleto() + "')";
			st.execute(sql);
		} catch(Exception e) {
			System.out.println("Error al insertar el cliente" + e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Cliente readCliente(String nif) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
