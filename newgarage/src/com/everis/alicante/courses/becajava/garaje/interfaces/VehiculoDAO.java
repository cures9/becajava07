package com.everis.alicante.courses.becajava.garaje.interfaces;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.becajava.garaje.domain.Vehiculo;

public interface VehiculoDAO {
	
	Map<String,Vehiculo> readVehiculos() throws IOException;
	
	void createVehiculo(Vehiculo vehiculo) throws IOException;
	
	Vehiculo readVehiculo(String matricula) throws IOException;
	
	void deleteVehiculo(String matricula) throws IOException;

}
