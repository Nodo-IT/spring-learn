package com.nodoit.conditional_configuration.service;

public class DefaultGreetingService implements GreetingService {

  @Override
  public String greet(String name) {
    return "Hello %s!\n".formatted(name);
  }

}
