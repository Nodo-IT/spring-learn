package com.nodoit.conditional_configuration.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nodoit.conditional_configuration.service.DefaultGreetingService;
import com.nodoit.conditional_configuration.service.GreetingService;

@Configuration
public class GreetingAutoConfiguration {
  
  @Bean
  @ConditionalOnProperty(name = "app.greeting.language", havingValue = "es")
  public GreetingService spanishGreetingService() {
    return new GreetingService() {
      @Override
      public String greet(String name) {
        return "Hola %s!\n".formatted(name);
      }
    };
  }

  @Bean
  @ConditionalOnMissingBean
  public GreetingService defaultGreetingService() {
    return new DefaultGreetingService();
  }

}
