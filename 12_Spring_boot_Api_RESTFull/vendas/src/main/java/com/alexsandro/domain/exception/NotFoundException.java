package com.alexsandro.domain.exception;

/**
 * The type Not found exception.
 */
public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
