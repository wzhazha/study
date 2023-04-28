package org.example.interceptor;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@Component
public class VerifyInterceptor implements HandlerInterceptor{
    List<String> tokenList = Arrays.asList("111", "222", "333");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String token = request.getHeader("token");
        PrintWriter out;
        if (token == null || !tokenList.contains(token)) {
            JSONObject jst = new JSONObject();
            jst.put("state", "false");
            jst.put("msg", "token is null or wrong");
            out = response.getWriter();
            out.append(jst.toString());
            return false;
        }
        return true;
    }
}
