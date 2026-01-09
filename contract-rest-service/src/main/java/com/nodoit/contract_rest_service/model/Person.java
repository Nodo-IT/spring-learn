package com.nodoit.contract_rest_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
  private Long id;
  private String name;
  private String surname;
}
