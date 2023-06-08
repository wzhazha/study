package org.example.interceptor;

import org.example.config.JwtTokenConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@Component
public class TokenVerifyInterceptor implements HandlerInterceptor {

  @Resource
  JwtTokenConfig jwtTokenConfig;

  private boolean allowPass = false;

  public TokenVerifyInterceptor() {
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String token = jwtTokenConfig.getTokenFromRequest(request);
    if (token == null || token.length() == 0) {
      if (!allowPass) {
        tips(response,"Need Login First!");
      }
      return allowPass;
    }
    if (!jwtTokenConfig.checkToken(token)) {
      if (!allowPass) {
        tips(response,"Unknown Token!");
      }
      return allowPass;
    }
    if (jwtTokenConfig.isTokenExpired(token)) {
      if (!allowPass) {
        tips(response,"Login State Expire!");
      }
      return allowPass;
    }
    String usernameFromToken = jwtTokenConfig.getUsernameFromToken(token);
    request.setAttribute("token-test", usernameFromToken);
    return !allowPass;
  }

  private void tips(HttpServletResponse response, String data) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    OutputStream stream = response.getOutputStream();
    String responseTips = data;
    stream.write(responseTips.getBytes(StandardCharsets.UTF_8));
  }

}
