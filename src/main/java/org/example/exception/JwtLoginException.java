package org.example.exception;

import io.jsonwebtoken.JwtException;

public class JwtLoginException extends JwtException {
  public JwtLoginException(String format, Object... objects) {
    super(String.format(format, objects));
  }
}
