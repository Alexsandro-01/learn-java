package com.alexsandro.rest.controller;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

/**
 * The type Api errors.
 */
public class ApiErrors {

  @Getter
  private List<String> errors;

  public ApiErrors(String errorMessage) {
    this.errors = Arrays.asList(errorMessage);
  }

  public ApiErrors(List<String> errors) {
    this.errors = errors;
  }
}
