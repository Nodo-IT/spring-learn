package com.nodoit.event_listener.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nodoit.event_listener.publisher.CustomEventPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EventController {
  
  @Autowired
  private CustomEventPublisher publisher;

  @GetMapping("/publish")
  public String publishEventString(@RequestParam String message) {
    publisher.publishCustomEvent(message);
    return "message pushed";
  }
  
}
