package org.example.config;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Accessors(chain = true)
@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtTokenConfig {
    @Value("${jwt.secretKey}")
    private String secretKey;
    @Value("${jwt.expireTime}")
    private long expireTime;
    // JWT令牌标识
    @Value("${jwt.tokenPrefix}")
    private String tokenPrefix;
    @Value("${jwt.headerString}")
    private String headerString;

    // 生成token
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + expireTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // 从Token中获取用户名
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token.replace(tokenPrefix, ""))
                .getBody()
                .get("username")
                .toString();
    }

    // 检查Token是否过期
    public boolean checkToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token.replace(tokenPrefix, ""));
            return true;
        } catch (JwtException ex) {
            return false;
        }
    }

    // 从请求头中获取Token
    public String getTokenFromRequest(HttpServletRequest request) {
        return request.getHeader(headerString);
    }
}
