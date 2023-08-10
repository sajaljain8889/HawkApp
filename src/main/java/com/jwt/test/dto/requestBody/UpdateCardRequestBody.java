package com.jwt.test.dto.requestBody;

import com.jwt.test.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCardRequestBody {
    private String name;
    private String number;
    private Address address;
    private String nameOnCard;
    private String typeOfCard;
    private String cardNumber;
    private String cvv;
    private String expMM;
    private String expYY;
}
