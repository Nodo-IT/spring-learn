package com.nodoit.custom_beans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nodoit.custom_beans.beans.DogServiceBean;
import com.nodoit.custom_beans.model.Dog;

@Configuration
public class DogConfiguration {

  @Bean
  public DogServiceBean dogConfigurerBean() {
    return new DogServiceBean(
        new Dog(
            "Kali",
            "Sandy yellow",
            1L,
            true,
            'F',
            "Labrador Retriever"));
  }

}
