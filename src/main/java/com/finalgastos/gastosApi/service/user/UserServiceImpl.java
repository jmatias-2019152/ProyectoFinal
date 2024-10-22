package com.finalgastos.gastosApi.service.user;


import com.finalgastos.gastosApi.model.User;
import com.finalgastos.gastosApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String SECRET_KEY = "tu_clave_secreta"; // Cambia esto por una clave secreta segura
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hora

    @Override
    public User registrarUsuario(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepositorio.save(user);
    }

    @Override
    public String login(String username, String password) {
        User user = userRepositorio.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Genera y retorna un token JWT
            return generarTokenJwt(user);
        }
        throw new RuntimeException("Credenciales inválidas");
    }

    private String generarTokenJwt(User user) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
