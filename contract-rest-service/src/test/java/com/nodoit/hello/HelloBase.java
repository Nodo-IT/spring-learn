package com.nodoit.hello;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.nodoit.contract_rest_service.ContractRestServiceApplication;
import com.nodoit.contract_rest_service.controller.PersonRestController;
import com.nodoit.contract_rest_service.model.Person;
import com.nodoit.contract_rest_service.service.PersonService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * 'classes=':
 * The component classes to use for loading an ApplicationContext. Can also be
 * specified using @ContextConfiguration(classes=...). If no explicit classes
 * are defined the test will look for nested @Configuration classes, before
 * falling back to a @SpringBootConfiguration search.
 */

/**
 * This will capture any internal/external tests performed on the 'hello'
 * contracts
 */
@SpringBootTest
@ContextConfiguration(classes = ContractRestServiceApplication.class)
public abstract class HelloBase {

  @Autowired
  PersonRestController personRestController;

  @MockitoBean
  PersonService personService;

  @BeforeEach
  public void setup() {
    RestAssuredMockMvc.standaloneSetup(personRestController);

    Mockito.when(personService.findById(1L))
        .thenReturn(new Person(1L, "foo", "bee"));
  }

}
