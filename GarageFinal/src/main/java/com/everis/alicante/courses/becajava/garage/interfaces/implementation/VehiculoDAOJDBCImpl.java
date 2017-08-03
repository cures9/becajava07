package com.everis.alicante.courses.becajava.garage.interfaces.implementation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.VehiculoDAOJDBC;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;

public class VehiculoDAOJDBCImpl implements VehiculoDAOJDBC {

	private final String MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String JDBC_CADENA_CONEXION = "jdbc:mysql://localhost:3306/garaje";
	private final String user = "root";
	private final String pwd = "";



	public void deleteVehiculo(String Vehiculo) {

	}

	public Connection getConnection()  {
		// TODO Auto-generated method stub
		Connection cn = null;
		
		try {
			Class.forName(MYSQL_JDBC_DRIVER);
			
			cn = DriverManager.getConnection(JDBC_CADENA_CONEXION, user, pwd);
		}
		catch (Exception e) {
			System.out.println("Error al obtener la conexion");
		}
		return cn;
	}

	public Map<String, Cliente> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Cliente> readVehiculo() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public void createVehiculo(Vehiculo vehiculo) throws IOException {
		// TODO Auto-generated method stub
		
		Connection cn = null;
		Statement st = null;
		
		try {
			
			cn = this.getConnection();
			st = cn.createStatement();
			
			String sql = "INSERT INTO VEHICULOS(MATRICULA, TIPO_VEHICULO)"
					+ " VALUES ('" + "9999" + "','"
					+ 1 + "')";
			st.execute(sql);
		} catch(Exception e) {
			System.out.println("Error al insertar el vehiculo: " + e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Map<String, Vehiculo> readVehiculos() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Vehiculo read(String matricula) throws IOException {
		
		Connection cn = this.getConnection();
		Vehiculo vehiculo = null;
		
		try {
			Statement st = cn.createStatement();
			String sql = "SELECT * FROM VEHICULOS WHERE MATRICULA = '"+ matricula + "'";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				vehiculo = new Vehiculo();
				vehiculo.setMatricula("matricula");
				vehiculo.setTipoVehiculo("tipoVehiculo");
	
			}
			}
			catch(Exception e) {
				System.out.println("Error al leer vehiculo");
		}
		finally {
			try {
				cn.close();
			
		}
		
	}
		
	
	@Override
	public Vehiculo readVehiculo(String matricula) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
