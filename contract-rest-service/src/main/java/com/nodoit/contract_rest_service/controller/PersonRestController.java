package com.nodoit.contract_rest_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodoit.contract_rest_service.model.Person;
import com.nodoit.contract_rest_service.service.PersonService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/person")
public class PersonRestController {

  @Autowired
  private PersonService service;

  @GetMapping("/{id}")
  public ResponseEntity<Person> findById(@PathVariable("id") Long id) {
    ResponseEntity<Person> response = (ResponseEntity<Person>) Optional.of(service.findById(id))
        .map((Person p) -> new ResponseEntity<Person>(p, HttpStatusCode.valueOf(200)))
        .orElse(new ResponseEntity<Person>(HttpStatusCode.valueOf(404)));

    return response;
  }

}