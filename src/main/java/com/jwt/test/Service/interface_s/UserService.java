package com.jwt.test.Service.interface_s;

import com.jwt.test.dto.requestBody.LoginRequestBody;
import com.jwt.test.dto.requestBody.UpdateUserRequestBody;
import com.jwt.test.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByUsername(String username);
    User save(User user);
    boolean verifyEncodedPassword(String userPassword,String loginReqPassword);

    boolean userNamePasswordVerifier(LoginRequestBody loginRequest);

    User updateUserDetails(String id, UpdateUserRequestBody updateUserRequestBody);

    User getUserById(String id);

    List<User> getAllUsers();

    String deleteUserDetails(String id);
}
