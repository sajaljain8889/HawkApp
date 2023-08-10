package com.jwt.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "appData")
public class AppData {

    @Id
    private String id;
    private String name;
    private String mobNo;
    private AppAddress appAddress;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;  // Date of Birth

    private List<SMS> smsList;
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

}
