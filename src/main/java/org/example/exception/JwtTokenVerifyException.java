package org.example.exception;

import io.jsonwebtoken.JwtException;

public class JwtTokenVerifyException extends JwtException {
  public JwtTokenVerifyException(String format, Object... objects) {
    super(String.format(format, objects));
  }
}
