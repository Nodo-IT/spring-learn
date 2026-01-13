package com.nodoit.custom_beans.model;

public record Dog(
    String name,
    String color,
    long id,
    boolean hasTail,
    char gender,
    String breed) {

  public String toString() {
    return "Dog(name = %s, color = %s, id = %d, hasTail = %b, gender = %c, breed = %s)"
        .formatted(name, color, id, hasTail, gender, breed);
  }

}
