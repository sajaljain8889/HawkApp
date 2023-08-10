package com.jwt.test.Service.implementation;

import com.jwt.test.dto.requestBody.LoginRequestBody;
import com.jwt.test.dto.requestBody.UpdateUserRequestBody;
import com.jwt.test.entity.User;
import com.jwt.test.Repository.UserRepository;
import com.jwt.test.Service.interface_s.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean verifyEncodedPassword(String userPassword,String loginReqPassword){
        if(passwordEncoder.matches(userPassword, loginReqPassword)){
            return true;
        }
        return false;
    }


    @Override
    public boolean userNamePasswordVerifier(LoginRequestBody loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if(user != null & loginRequest.getPassword().equals(user.getPassword())){
            return true ;
        }
        return false ;
    }

    @Override
    public User updateUserDetails(String id, UpdateUserRequestBody updateUserRequestBody) {
        User user = userRepository.findById(id).get();
        user.setUpdatedAt(new Date());
        user.setName(updateUserRequestBody.getName());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users= userRepository.findAll();
        return users;
    }

    @Override
    public String deleteUserDetails(String id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Successfully Deleted";
        }
        return "User Doesn't Exist";
    }

    @Override
    public User save(User user) {
      //  user.setPassword(passwordEncoder.encode(user.getPassword()));
         return userRepository.save(user);
    }
}
