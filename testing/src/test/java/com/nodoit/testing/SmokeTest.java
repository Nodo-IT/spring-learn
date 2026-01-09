package com.nodoit.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The @SpringBootTest annotation tells Spring Boot to look for a main
 * configuration class (one with @SpringBootApplication, for instance)
 * and use that to start a Spring application context.
 */
@SpringBootTest
class SmokeTest {

  @Autowired
  private HomeController controller;

  @Test
  void contextLoads() throws Exception {
    assertThat(controller).isNotNull();
  }

}
