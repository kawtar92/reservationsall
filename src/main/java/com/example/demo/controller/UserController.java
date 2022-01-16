package com.example.demo.controller;


import com.example.demo.model.Salle;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/save")
    public void save(@RequestBody User users)
    {userRepository.save(users);}

    @GetMapping("/all")
    public List<User> findAll() { return userRepository.findAll();}




}






