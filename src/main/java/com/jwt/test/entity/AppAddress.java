package com.jwt.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppAddress {
    private String AddressLine1;
    private String AddressLine2;
    private String state;
    private String city;
    private String pinCode;
}
