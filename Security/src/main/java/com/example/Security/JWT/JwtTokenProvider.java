package com.example.Security.JWT;

import com.example.Security.Security.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UnknownFormatConversionException;

@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${ra.jwt.secret}")
    private String JWT_SECRET;
    @Value(("${ra.jwt.expriration}"))
    private int JWT_EXPIRATION;

    //generation jwt from user's information
    public String generateToken(CustomUserDetails customUserDetails) {
        Date now = new Date();
        Date dateExpired = new Date(now.getTime() + JWT_EXPIRATION);
        //Generate jwt from user name
        return Jwts.builder()
                .setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(dateExpired)
                .signWith(SignatureAlgorithm.ES512, JWT_SECRET)
                .compact();
    }


    // get information's user from token
    public String getUserNameFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token).getBody();
        // response information of user

        return claims.getSubject();
    }

    // validate information jwt
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException exception) {
            log.error("Invalid jwt token");
        } catch (ExpiredJwtException exception) {
            log.error("Expired JWT token");
        } catch (UnknownFormatConversionException exception) {
            log.error("Unsupported jwt token");
        } catch (IllegalArgumentException exception) {
            log.error("jwt claims string is empty");
        }
        return false;
    }
}


