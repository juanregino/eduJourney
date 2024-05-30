package com.eduJourney.api.errorHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eduJourney.api.errors.BaseErrorResponse;
import com.eduJourney.api.errors.ErrorsResponse;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST) 
public class BadRequestController {
  public BaseErrorResponse handleBadRequest(MethodArgumentNotValidException exception) {
  
  List<Map<String, String>> errors = new ArrayList<>();
  exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
  Map<String, String> error = new HashMap<>();
  error.put("field", fieldError.getField());
  error.put("error", fieldError.getDefaultMessage());
  errors.add(error);
  });
  return ErrorsResponse.builder()
                      .code(HttpStatus.BAD_REQUEST.value())
                      .status(HttpStatus.BAD_REQUEST.name())
                      .errors(errors)
                      .build();
  }

  @ExceptionHandler(BadRequestException.class)
  public BaseErrorResponse handleError(BadRequestException exception) {
      List <Map<String, String>> errors = new ArrayList<>();
      Map<String, String> error = new HashMap<>();
      error.put("id", exception.getMessage()); 

      errors.add(error);
      return ErrorsResponse.builder()
                          .code(HttpStatus.BAD_REQUEST.value())
                          .status(HttpStatus.BAD_REQUEST.name())
                          .errors(errors)
                          .build();
  }
  }
