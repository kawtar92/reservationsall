package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="salle")
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String code;
	private String type;
	private double capacite;
	@OneToMany(mappedBy="salle", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Machine> machines;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Bloc bloc;
	@OneToMany(mappedBy = "salle")
	private List<Reservation> Reservations;

	public Salle() {	
	}
	
	
	public Salle(String code, String type, double capacite) {
		super();
		this.code = code;
		this.type = type;
		this.capacite = capacite;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCapacite() {
		return capacite;
	}

	public void setCapacite(double capacite) {
		this.capacite = capacite;
	}


	public List<Machine> getMachines() {
		return machines;
	}


	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}


	public Bloc getBloc() {
		return bloc;
	}


	public void setBloc(Bloc bloc) {
		this.bloc = bloc;
	}


	public List<Reservation> getReservations() {
		return Reservations;
	}


	public void setReservations(List<Reservation> Reservations) {
		this.Reservations = Reservations;
	}
	
	
	

}
