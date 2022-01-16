package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="creneau")
public class Creneau {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String hDebut;
	private String hFin;
	@OneToMany(mappedBy = "creneau")
	private List<Reservation> Reservations;
	
	public Creneau() {
		
	}

	public Creneau(String hDebut, String hFin) {
		this.hDebut = hDebut;
		this.hFin = hFin;
	}

	public Creneau(long id, String hDebut, String hFin) {
		this.id = id;
		this.hDebut = hDebut;
		this.hFin = hFin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String gethDebut() {
		return hDebut;
	}

	public void sethDebut(String hDebut) {
		this.hDebut = hDebut;
	}

	public String gethFin() {
		return hFin;
	}

	public void sethFin(String hFin) {
		this.hFin = hFin;
	}

	public List<Reservation> getReservations() {
		return Reservations;
	}

	public void setReservations(List<Reservation> Reservations) {
		this.Reservations = Reservations;
	}

	
	
}
