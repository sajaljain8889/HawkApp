package com.jwt.test.dto.requestBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppDataRequestBody {
    private String name;
    private String mobNo;
    private boolean isActive;
}

