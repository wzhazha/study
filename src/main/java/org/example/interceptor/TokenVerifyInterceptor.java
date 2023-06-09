package org.example.interceptor;

import org.example.config.JwtTokenConfig;
import org.example.entity.database.UmsAdmin;
import org.example.service.UmsAdminService;
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
  private JwtTokenConfig jwtTokenConfig;
  @Resource
  private UmsAdminService umsAdminService;
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
    String usernameFromToken = jwtTokenConfig.getUsernameFromToken(token);
    if (usernameFromToken == null) {
      if (!allowPass) {
        tips(response,"Login Error!");
      }
      return allowPass;
    }
    UmsAdmin userDetails = this.umsAdminService.loadUserByUsername(usernameFromToken);
    if (!jwtTokenConfig.validateToken(token, userDetails)) {
      if (!allowPass) {
        tips(response,"Login State Expire!");
      }
      return allowPass;
    }
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
