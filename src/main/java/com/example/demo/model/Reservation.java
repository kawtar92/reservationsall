package com.example.demo.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="Reservation")
public class Reservation {
	@EmbeddedId
	private ReservationKey id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@JoinColumn(name = "salle", referencedColumnName = "id", insertable = false, updatable = false)
	@ManyToOne
	private Salle salle;
	@JoinColumn(name = "creneau", referencedColumnName = "id", insertable = false, updatable = false)
	@ManyToOne
	private Creneau creneau;
	@JoinColumn(name = "user",  insertable = false, updatable = false)
	@ManyToOne
	private User user;
	public Reservation() {
		
	}
	
	public Reservation(ReservationKey id, Date date, Salle salle, Creneau creneau) {
		super();
		this.id = id;
		this.date = date;
		this.salle = salle;
		this.creneau = creneau;
	}

	public Reservation(Date date, Salle salle, Creneau Creneau, User user) {
		super();
		this.date = date;
		this.salle = salle;
		this.creneau = creneau;
		this.user = user;
	}
	public Reservation(ReservationKey id, Date date, Salle salle, Creneau Creneau, User user) {
		super();
		this.id = id;
		this.date = date;
		this.salle = salle;
		this.creneau = creneau;
		this.user = user;
	}
	public ReservationKey getId() {
		return id;
	}
	public void setId(ReservationKey id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Creneau getCreneau() {
		return creneau;
	}
	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}