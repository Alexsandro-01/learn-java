package com.alexsandro.rest.controller;

import com.alexsandro.domain.exception.NotFoundException;
import com.alexsandro.domain.exception.RegraNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type Application controller advice.
 */
@RestControllerAdvice
public class ApplicationControllerAdvice {

  /*
  * Sempre que ocorrer uma excepion do tipo RegraNegocioException
  * a aplicação vai capturar e tratar com esse método.
  * */
  @ExceptionHandler(RegraNegocioException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiErrors handleRegraNegocioException(RegraNegocioException ex) {
    String errorMessage = ex.getMessage();
    return new ApiErrors(errorMessage);
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ApiErrors handleNotFoundException(NotFoundException ex) {
    String errorMessage = ex.getMessage();
    return new ApiErrors(errorMessage);
  }
}
