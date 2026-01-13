package com.nodoit.conditional_configuration.service;

import org.springframework.stereotype.Service;

@Service
public interface GreetingService {
  String greet(String name);
}
