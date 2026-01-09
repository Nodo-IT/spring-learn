package com.nodoit.contract_rest_client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.nodoit.contract_rest_client.model.Person;

@RestController
@RequestMapping("/message")
class MessageRestController {

  @Autowired
  private RestClient client;

  @RequestMapping("/{personId}")
  String getMessage(@PathVariable Long personId) {
    Person person = this.client.get()
        .uri(URI.create("http://localhost:8080/api/v1/person/"+personId))
        .retrieve()
        .body(Person.class);

    return "Hello " + person.getName();
  }

}