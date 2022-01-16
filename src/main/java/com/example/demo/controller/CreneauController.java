package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Creneau;
import com.example.demo.repository.CreneauRepository;

@RestController
@RequestMapping("creneaux")
public class CreneauController {
	@Autowired
	CreneauRepository CreneauRepository;

	@PostMapping("/save")
	public void save(@RequestBody Creneau Creneau){
		CreneauRepository.save(Creneau);
	}
	
	@GetMapping("/all")
	public List<Creneau> load(){
		return CreneauRepository.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id){
		CreneauRepository.delete(CreneauRepository.findById(id));
	}
	
	
}
