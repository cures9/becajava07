package com.everis.alicante.courses.becajava.garage.interfaces.implementation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.VehiculoDAOJDBC;


public class VehiculoDAOJDBCImpl implements VehiculoDAOJDBC{

	private final String MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String JDBC_CADENA_CONEXION = "jdbc:mysql://localhost:3306/garaje";
	private final String JDBC_USR = "root";
	private final String JDBC_PWD = "";
	
	@Override
	public void create(Vehiculo vehiculo) throws IOException {
		
		Connection cn = null;
		PreparedStatement pst = null;
		
		try {
			
			String sql = "INSERT INTO VEHICULOS(MATRICULA, TIPO_VEHICULO)"
					+ " VALUES (?,?)";
			
			cn = this.getConnection();
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, vehiculo.getMatricula());
			pst.setString(2, vehiculo.getTipoVehiculo());
			
			pst.execute();
			
		}catch(SQLException e) {
			System.out.println("Error al insertar vehiculo: " + e.getMessage());
		}finally {
			try {
				cn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Vehiculo read(String matricula) throws IOException {
		
		Connection cn = null;
		PreparedStatement pst = null;
		Vehiculo vehiculo = null;
		
		try {

			String sql = "select * from vehiculos, tipos_vehiculo where matricula = ? and tipo_vehiculo = id_tipo";
			
			cn = this.getConnection();
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, matricula);
			
			ResultSet rs = pst.executeQuery();
//			boolean hasNext = rs.next();
			while(rs.next()) {
				vehiculo = new Vehiculo();
				vehiculo.setMatricula(rs.getString("matricula"));
				vehiculo.setTipoVehiculo(rs.getString("tipo_vehiculo"));
				System.out.println("El tipo de vehiculo con la matricula: " 
						+ vehiculo.getMatricula() + " es: " + vehiculo.getTipoVehiculo()
						+ ". Y el vehiculo es un: " + rs.getString("nombre_tipo"));
				}
			
		}catch(SQLException e) {
			System.out.println("Error al leer vehiculos: " + e.getMessage());
		}finally {
			try {
				cn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vehiculo;
	}

	@Override
	public void update(Vehiculo vehiculo) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String matricula) throws IOException {
		
		Connection cn = null;
		PreparedStatement pst = null;
		
		try {
			
			String sql = "DELETE FROM VEHICULOS WHERE MATRICULA = ?";
			
			cn = this.getConnection();
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, matricula);
			
			int result = pst.executeUpdate();
			
			if (result == 0) {
				System.out.println("Esa no existe, por lo tanto no la voy a borrar");
			}
			
		}catch(SQLException e) {
			System.out.println("Error al insertar cliente: " + e.getMessage());
		}finally {
			try {
				cn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Connection getConnection() throws IOException {
		
		Connection cn = null;
		try {
//			Carga el driver JDBC
			Class.forName(MYSQL_JDBC_DRIVER);
//			Conexion a la BBDD
			cn = DriverManager.getConnection(JDBC_CADENA_CONEXION, JDBC_USR, JDBC_PWD);
		}catch(Exception e) {
			System.out.println("Error al obtener la conexion");
		}
		return cn;
	}

	@Override
	public List<Vehiculo> readAll() {
		
		Connection cn = null;
		PreparedStatement pst = null;
		Vehiculo vehiculo = null;
		List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		
		try {
	
			String sql = "SELECT * FROM VEHICULOS";
			
			cn = this.getConnection();
			pst = cn.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
//			boolean hasNext = rs.next();
			while(rs.next()) {
				vehiculo = new Vehiculo();
				vehiculo.setMatricula(rs.getString("matricula"));
				vehiculo.setTipoVehiculo(rs.getString("tipo_vehiculo"));
				listaVehiculos.add(vehiculo);
			}
			
		}catch(Exception e) {
			System.out.println("Error al leer vehiculos: " + e.getMessage());
		}finally {
			try {
				cn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaVehiculos;
	}

}
