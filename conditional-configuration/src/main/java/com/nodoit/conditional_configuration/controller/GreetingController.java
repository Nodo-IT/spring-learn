package com.nodoit.conditional_configuration.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nodoit.conditional_configuration.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GreetingController {
  
  @Autowired
  private GreetingService service;
  
  @GetMapping("/hello")
  public String greet(@RequestParam("name") String name) {
      return service.greet(name);
  }
  
}
