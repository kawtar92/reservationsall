package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reservation;
import com.example.demo.model.ReservationKey;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.CreneauRepository;
import com.example.demo.repository.SalleRepository;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("reservations")
public class ReservationController {
	@Autowired
	private ReservationRepository ReservationRepository;

	@Autowired
	private CreneauRepository CreneauRepository;
	
	@Autowired
	private SalleRepository salleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/save")
	public void save(@RequestBody Reservation reservation){
//		System.out.println(Reservation);
//		Reservation.setCreneau(CreneauRepository.findById(Reservation.getCreneau().getId()));
//		Reservation.setSalle(salleRepository.findById(Reservation.getSalle().getId()));
//		ReservationRepository.save(Reservation);
		Reservation crs2 = new Reservation(new ReservationKey(reservation.getSalle().getId(),reservation.getCreneau().getId()),reservation.getDate(),reservation.getSalle(),reservation.getCreneau());
		ReservationRepository.save(crs2);
	}
	
	@GetMapping("/all")
	public List<Reservation> findAll(){
		return ReservationRepository.findAll();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		System.out.println("id = "+id);
		Reservation	Reservation = ReservationRepository.findById((id));
		ReservationRepository.delete(Reservation);
	}
}
