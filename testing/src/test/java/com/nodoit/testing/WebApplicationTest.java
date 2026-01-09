package com.nodoit.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

/**
 * 
 * Another useful approach is to not start the server at all but to test only
 * the layer below that, where Spring handles the incoming HTTP request and
 * hands it off to your controller.
 * That way, almost all of the full stack is used, and your code will be called
 * in exactly the same way as if it were processing a real HTTP request but
 * without the cost of starting the server.
 * To do that, we can reuse our previous test using RestTestClient, but this
 * time leaving @SpringBootTest with its default, which is to start a mock
 * server environment. The following listing shows how to do so.
 * 
 * In this test, the full Spring application context is started but without the server
 */
@SpringBootTest
@AutoConfigureRestTestClient
class WebApplicationTest {

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
