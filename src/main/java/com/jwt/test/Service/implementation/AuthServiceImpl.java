package com.jwt.test.Service.implementation;

import com.jwt.test.dto.requestBody.LoginRequestBody;
import com.jwt.test.dto.requestBody.SignupRequestBody;
import com.jwt.test.entity.User;
import com.jwt.test.Service.interface_s.AuthService;
import com.jwt.test.Service.interface_s.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Value("${myapp.jwt.secret-key}")
    private String jwtSecretKey;

    @Value("${myapp.jwt.expiration-time}")
    private Long jwtExpirationTime;
    @Autowired
    private UserService userService;

    @Override
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", user.getUsername());
        claims.put("created", new Date());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationTime))
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .compact();
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User signup(SignupRequestBody signupRequest) {
        User newUser = new User();
        newUser.setUsername(signupRequest.getUsername());
        newUser.setPassword(signupRequest.getPassword());
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());
        return userService.save(newUser);
    }

    @Override
    public String login(LoginRequestBody loginRequestBody) {
        User user = userService.findByUsername(loginRequestBody.getUsername());
        if (user != null && user.getPassword().equals(loginRequestBody.getPassword())) {
            return generateToken(user);
        }
        return null;
    }
//userService.verifyEncodedPassword(user.getPassword(),loginRequestBody.getPassword())
}
