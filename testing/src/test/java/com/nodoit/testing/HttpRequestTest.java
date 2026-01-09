package com.nodoit.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.client.RestTestClient;

/**
 * Note the use of webEnvironment=RANDOM_PORT to start the server with a random
 * port (useful to avoid conflicts in test environments) and the injection of
 * the port with @LocalServerPort. Also, note that Spring Boot has automatically
 * provided a RestTestClient for you because we expressed the need for it
 * with @AutoConfigureRestTestClient. All you have to do after that is to
 * add @Autowired to the field.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class HttpRequestTest {

  @LocalServerPort
  private int port;

  @Autowired
  private RestTestClient restTestClient;

  @Test
  void greetingShouldReturnDefaultMessage() {
    restTestClient.get()
        .uri("http://localhost:%d/".formatted(port))
        .exchange()
        .expectBody(String.class)
        .isEqualTo("Hello, World");
  }

}
