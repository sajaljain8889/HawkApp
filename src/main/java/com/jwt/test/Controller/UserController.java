package com.jwt.test.Controller;

import com.jwt.test.Service.interface_s.UserService;
import com.jwt.test.dto.requestBody.UpdateUserRequestBody;
import com.jwt.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUserDetails(@PathVariable String id, @RequestBody UpdateUserRequestBody updateUserRequestBody){
        return userService.updateUserDetails(id,updateUserRequestBody);
    }

    @DeleteMapping("/{id}")
    public String DeleteMapping(@PathVariable String id){
        return userService.deleteUserDetails(id);
    }
}
