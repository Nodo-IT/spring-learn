package com.nodoit.contract_rest_service.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nodoit.contract_rest_service.model.Person;

@Service
public class PersonService {
  private final Map<Long, Person> personMap;

  public PersonService() {
    personMap = new HashMap<>();
    personMap.put(1L, new Person(1L, "Chico", "Buarque"));
    personMap.put(2L, new Person(2L, "Luis Alberto", "Spinetta"));
    personMap.put(3L, new Person(3L, "Antonio Carlos", "Jobim"));
  }

  public Person findById(Long id) {
    return personMap.get(id);
  }
}
