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

import com.example.demo.model.Salle;
import com.example.demo.model.User;
import com.example.demo.repository.BlocRepository;
import com.example.demo.repository.SalleRepository;
import com.example.demo.repository.UserRepository;
@RestController
@RequestMapping("salles")
public class SalleController {
	
	@Autowired
	private SalleRepository salleRepository;
	
	@Autowired
	private BlocRepository blocRepository;
	

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/save")
	public void save(@RequestBody Salle salle){
		System.out.println(salle);
		salle.setBloc(blocRepository.findById(salle.getBloc().getId()));
		salleRepository.save(salle);
	}
	
	@GetMapping("/all")
	public List<Salle> findAll(){
		return salleRepository.findAll();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		System.out.println("id = "+id);
		Salle salle = salleRepository.findById((id));
		salleRepository.delete(salle);
	}
	
}