package com.nodoit.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.client.RestTestClient;

/**
 * The test assertion is the same as in the WebApplicationTest case. However, in this
 * test, Spring Boot instantiates only the web layer rather than the whole
 * context. In an application with multiple controllers, you can even ask for
 * only one to be instantiated by using, for
 * example, @WebMvcTest(HomeController.class).
 */
@WebMvcTest(HomeController.class)
@AutoConfigureRestTestClient
class WebLayerTest {

  @Autowired
  private RestTestClient restTestClient;

  @Test
  void greetingShouldReturnDefaultMessage() {
    restTestClient.get().uri("/")
        .exchange()
        .expectBody(String.class)
        .isEqualTo("Hello, World");
  }
}
