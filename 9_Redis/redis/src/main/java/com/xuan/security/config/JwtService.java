package com.xuan.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "7F3A9C2E1B4D8F6A0E5C3B7D9F2A4E6C1B8D3F5A7E9C2B4D6F8A0E3C5B7D9F1A";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
        //username.equals(userDetails.getUsername()) — 验证用户名是否匹配
        //!isTokenExpired(token) — 验证 token 有没有过期
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        //提取JWT里Payload那一段的所有内容，也就是Claims
        //解析 JWT 的时候，需要用密钥去验证签名，确认这个 token 没有被篡改过。
        //.setSigningKey(getSignInKey()) 就是把密钥传进去，解析器拿着这个密钥去验签，验签通过才能拿到里面的内容，验签失败直接抛异常。
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //SECRET_KEY 是密钥，不是 Payload，跟 Payload 没关系。
    //原因是这样的：加密算法（HS256）需要的输入是字节数组，不是字符串。
    //SECRET_KEY 这个字符串是用 Base64 编码过的，先 decode 拿到原始字节数组，再交给 Keys.hmacShaKeyFor() 生成真正的密钥对象。
    //简单说：算法要字节，不要字符串，所以要先解码。

    //总结一下 JwtService 两个主要功能：
    //generateToken — 生成 token
    //isTokenValid — 验证 token

}
