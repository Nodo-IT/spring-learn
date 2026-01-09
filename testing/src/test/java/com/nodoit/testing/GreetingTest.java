package com.nodoit.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.mockito.Mockito.when;

@WebMvcTest(GreetingController.class)
@AutoConfigureRestTestClient
public class GreetingTest {

  @Autowired
  private RestTestClient restTestClient;

  /**
   * We use @MockitoBean to create and inject a mock for the GreetingService (if
   * you do not do so, the application context cannot start), and we set its
   * expectations using Mockito.
   */
  @MockitoBean
  private GreetingService service;

  @Test
  void greetingShouldReturnDefaultMessageFromService() throws Exception {
    /**
     * thenReturn changes the return value on a function call
     */
    when(service.greet()).thenReturn("Hello, Mock");
    restTestClient.get().uri("/greeting")
        .exchange()
        .expectBody(String.class)
        .isEqualTo("Hello, Mock");
  }
}
