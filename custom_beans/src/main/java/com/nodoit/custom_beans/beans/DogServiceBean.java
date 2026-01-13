package com.nodoit.custom_beans.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nodoit.custom_beans.model.Dog;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class DogServiceBean {
  private final Logger logger;
  private Dog dog;

  public DogServiceBean(Dog dog) {
    this.logger = LoggerFactory.getLogger(DogServiceBean.class);
    this.dog = dog;
  }

  public void bark() {
    logger.info("Bark bark from: %s".formatted(dog.toString()));
  }

  @PreDestroy
  public void destroy() throws Exception {
    logger.info("Destroying DogServiceBean");
    dog = null;
  }

  @PostConstruct
  public void init() throws Exception {
    logger.info("Initializing DogServiceBean");
  }
}
