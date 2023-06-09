package org.example.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.experimental.Accessors;
import org.example.entity.database.UmsAdmin;
import org.example.exception.JwtTokenVerifyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Accessors(chain = true)
@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtTokenConfig {
    private static final String CLAIM_KEY_USERNAME = "sub";
    @Value("${jwt.secretKey}")
    private String secretKey;
    @Value("${jwt.expireTime}")
    private long expireTime;
    // JWT令牌标识
    @Value("${jwt.tokenPrefix}")
    private String tokenPrefix;
    @Value("${jwt.headerString}")
    private String headerString;

    /**
     * 生成token
     */
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, username);
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + expireTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    /**
     * 从token中获取JWT中的负载
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims ;
        try {
            claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token.replace(tokenPrefix, ""))
                .getBody();
        } catch (Exception e) {
            throw new JwtTokenVerifyException("Tk format verification failed. Procedure");
        }
        return claims;
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 判断token是否已经失效
     * 过期为ture
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从Token中获取用户名
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 验证token是否还有效
     * 有效为ture
     */
    public boolean validateToken(String token, UmsAdmin userDetails) {
        String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 把token存到请求头中
     */
    public void addTokenToRequest(HttpServletResponse response, String token) {
        response.setHeader(headerString, tokenPrefix + token);
    }

    /**
     * 从请求头中获取Token
     */
    public String getTokenFromRequest(HttpServletRequest request) {
        return request.getHeader(headerString);
    }
}
