package com.jwt.test.Service.interface_s;

import com.jwt.test.dto.requestBody.AppDataRequestBody;
import com.jwt.test.dto.requestBody.SMSRequestBody;
import com.jwt.test.dto.requestBody.UpdateAppDataRequestBody;
import com.jwt.test.entity.AppData;

import java.util.List;
import java.util.Optional;

public interface AppDataService {
    AppData addAppData(AppDataRequestBody appDataRequestBody);

    AppData getAppDataByName(String name);

    AppData getAppDataById(String id);

    void addSMS(SMSRequestBody smsRequestBody, String id);

    List<AppData> getAllAppData();

    AppData updateAppData(UpdateAppDataRequestBody updateAppDataRequestBody, String id);

    void deleteAppData(String id);
}
