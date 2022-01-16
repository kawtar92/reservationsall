package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Bloc;


public interface BlocRepository  extends JpaRepository<Bloc, Long> {

	Bloc findById(long id);

}
