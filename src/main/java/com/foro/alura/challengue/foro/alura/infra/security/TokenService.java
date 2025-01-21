package com.foro.alura.challengue.foro.alura.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.foro.alura.challengue.foro.alura.operations.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generateToken(Usuario usuario) {

        try{
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("Foro Hub")
                    .withSubject(usuario.getEmail())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaDeExpiracion())
                    .sign(algorithm);

        } catch (JWTCreationException e) {
            throw new RuntimeException("Eror  al generar el token: " + e);
        }
    }

    public String getSubject(String token) {
        if(token == null){
            throw new RuntimeException("Token inválido");
        }
        DecodedJWT verfier = null;
        try{
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verfier = JWT.require(algorithm)
                    .withIssuer("Foro Alura")
                    .build()
                    .verify(token);
            verfier.getSubject();

        }catch (JWTVerificationException exception){
            System.out.println(exception.toString());
        }

        if(verfier.getSubject()==null){
            throw new RuntimeException("Verifier inválido");
        }
        return verfier.getSubject();
    }

    private Instant generarFechaDeExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
