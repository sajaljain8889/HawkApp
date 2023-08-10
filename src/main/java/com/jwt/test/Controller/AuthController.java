package com.jwt.test.Controller;

import com.jwt.test.dto.requestBody.LoginRequestBody;
import com.jwt.test.dto.requestBody.SignupRequestBody;
import com.jwt.test.Service.interface_s.AuthService;
import com.jwt.test.Service.interface_s.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequestBody signupRequest) {
        authService.signup(signupRequest);
        return "Signup successful!";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestBody loginRequest) {

        String token = authService.login(loginRequest);
        if (token != null) {
            return token;
        } else {
            return "Invalid credentials";
        }

//        if(userService.userNamePasswordVerifier(loginRequest)){
//            return  "Logged in successfully";
//        }else{
//            return "Invalid Credential";
//        }
    }
}
