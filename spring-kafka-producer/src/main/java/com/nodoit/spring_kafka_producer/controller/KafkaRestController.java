package com.nodoit.spring_kafka_producer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nodoit.spring_kafka_producer.service.KafkaProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class KafkaRestController {

  @Autowired
  private KafkaProducerService service;

  @PostMapping("/push")
  public ResponseEntity<String> pushMessage(@RequestBody String entity) {
    return service.publish(entity)
        .map(message -> ResponseEntity.ok().body("Message received: %s\n".formatted(message)))
        .orElse(ResponseEntity.internalServerError().body("Error processing the message"));
  }

}
