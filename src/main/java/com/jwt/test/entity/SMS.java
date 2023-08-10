package com.jwt.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SMS {
    @Id
    private String id;
    private String sender;
    private String message;

    @CreatedDate
    private Date time;
}
