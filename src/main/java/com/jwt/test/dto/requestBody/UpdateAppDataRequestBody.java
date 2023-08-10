package com.jwt.test.dto.requestBody;

import com.jwt.test.entity.AppAddress;
import com.jwt.test.entity.SMS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAppDataRequestBody {
    private AppAddress appAddress;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;  // Date of Birth

    private List<SMS> smsList;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
