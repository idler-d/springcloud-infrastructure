package com.idler.demo.exception.advice;

import com.idler.demo.exception.CustomException;
import com.idler.demo.exception.vo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ResponseResult> customExceptionHandler(final CustomException e) {
    return ResponseEntity.status(e.getResponseResult().getStatusCode()).body(e.getResponseResult());
  }
}
