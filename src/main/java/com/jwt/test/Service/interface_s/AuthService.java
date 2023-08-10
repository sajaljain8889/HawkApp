package com.jwt.test.Service.interface_s;

import com.jwt.test.dto.requestBody.LoginRequestBody;
import com.jwt.test.dto.requestBody.SignupRequestBody;
import com.jwt.test.entity.User;

public interface AuthService {
    String generateToken(User user);
    boolean validateToken(String token);
    User signup(SignupRequestBody signupRequest);
    String login(LoginRequestBody loginRequestBody);
}
