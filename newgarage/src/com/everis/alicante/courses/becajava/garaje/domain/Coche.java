package com.everis.alicante.courses.becajava.garaje.domain;

import com.everis.alicante.courses.becajava.garaje.interfaces.Aparcable;
import com.everis.alicante.courses.becajava.garaje.interfaces.Lavable;

public class Coche extends Vehiculo implements Aparcable,Lavable{
	
	private String marca;

	
	public String getMarca() {
		return marca;
	}

	
	public void setMarca(String marca) {
		this.marca = marca;
	}


	@Override
	public void aparcar() {
	 System.out.println("puedo aparcar");
		
	}


	@Override
	public void testear() {
		// TODO Auto-generated method stub
		Aparcable.super.testear();
	}
	
	

}
