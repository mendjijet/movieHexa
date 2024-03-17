package com.jet.movieHexa.infrastructure.exception;

public class MovieAlreadyExistsException extends RuntimeException {
  public MovieAlreadyExistsException(String message) {
    super(message);
  }
}
