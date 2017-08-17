package com.everis.alicante.becajava;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parking_place database table.
 * 
 */
@Entity
@Table(name="parking_place")
@NamedQuery(name="ParkingPlace.findAll", query="SELECT p FROM ParkingPlace p")
public class ParkingPlace  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_parkingPlace;

	private int parkingNumber;

	private double parkingPrice;

	private double parkingSize;

	private int parkingState;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="parkingPlace")
	private List<Booking> bookings;

	public ParkingPlace() {
	}

	public int getId_parkingPlace() {
		return this.id_parkingPlace;
	}

	public void setId_parkingPlace(int id_parkingPlace) {
		this.id_parkingPlace = id_parkingPlace;
	}

	public int getParkingNumber() {
		return this.parkingNumber;
	}

	public void setParkingNumber(int parkingNumber) {
		this.parkingNumber = parkingNumber;
	}

	public double getParkingPrice() {
		return this.parkingPrice;
	}

	public void setParkingPrice(double parkingPrice) {
		this.parkingPrice = parkingPrice;
	}

	public double getParkingSize() {
		return this.parkingSize;
	}

	public void setParkingSize(double parkingSize) {
		this.parkingSize = parkingSize;
	}

	public int getParkingState() {
		return this.parkingState;
	}

	public void setParkingState(int parkingState) {
		this.parkingState = parkingState;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setParkingPlace(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setParkingPlace(null);

		return booking;
	}

}