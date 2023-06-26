package com.example.demo.domain;

import java.util.UUID;

public class Book {

  private UUID id;

  private String name;

  private String author;

  public Book(String name, String author) {
    this.id = UUID.randomUUID(); // toda nova instânaia terá um novo id
    this.name = name;
    this.author = author;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
