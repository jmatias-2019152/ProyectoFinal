package com.finalgastos.gastosApi.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class UtilJwt {

    private String secreto = "tu_clave_secreta"; // Puede venir de application.properties

    public String generarToken(String nombreUsuario) {
        return Jwts.builder()
                .setSubject(nombreUsuario)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora
                .signWith(SignatureAlgorithm.HS256, secreto)
                .compact();
    }

    public String obtenerNombreUsuarioDelToken(String token) {
        return Jwts.parser().setSigningKey(secreto).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validarToken(String token, UserDetails userDetails) {
        String nombreUsuario = obtenerNombreUsuarioDelToken(token);
        return (nombreUsuario.equals(userDetails.getUsername()) && !estaTokenExpirado(token));
    }

    private boolean estaTokenExpirado(String token) {
        Date fechaExpiracion = Jwts.parser().setSigningKey(secreto).parseClaimsJws(token).getBody().getExpiration();
        return fechaExpiracion.before(new Date());
    }
}