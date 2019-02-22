package com.greenfox.myprogram.security;

import com.greenfox.myprogram.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Component
public class JwtGenerator {
    /*  Date date = new Date();
      long t = date.getTime();
      Date expirationTime = new Date(t + 5000l); // set 5 seconds more*/
    LocalDateTime currentTime = LocalDateTime.now();
    public static final Long TOKEN_EXP_TIME = 1L; //1 min.

    public String generate(JwtUser jwtUser) {


        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());

        return Jwts.builder()
                // .setExpiration(expirationTime)
                .setClaims(claims)
                .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(currentTime
                        .plusMinutes(TOKEN_EXP_TIME)
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}
