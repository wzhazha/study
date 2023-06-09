package org.example.controller;

import org.example.api.CommonResult;
import org.example.api.ResultCode;
import org.example.exception.JwtTokenVerifyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdviceController {

  @ExceptionHandler(value = JwtTokenVerifyException.class)
  public CommonResult<String> loginVerifyErrorExceptionHandler(JwtTokenVerifyException ex) {
    String message = ex.getMessage() == null ? "Account Or Password Error!" : ex.getMessage();
    return CommonResult.failed(ResultCode.UNAUTHORIZED, message);
  }
}
