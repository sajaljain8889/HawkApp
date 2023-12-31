package com.jwt.test.dto.requestBody;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequestBody {
    private String name;
    private String username;
    private String password;
}
