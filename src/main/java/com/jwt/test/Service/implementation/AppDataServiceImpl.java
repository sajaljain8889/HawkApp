package com.jwt.test.Service.implementation;

import com.jwt.test.Repository.AppDataRepository;
import com.jwt.test.Service.interface_s.AppDataService;
import com.jwt.test.dto.requestBody.AppDataRequestBody;
import com.jwt.test.dto.requestBody.SMSRequestBody;
import com.jwt.test.dto.requestBody.UpdateAppDataRequestBody;
import com.jwt.test.entity.AppData;
import com.jwt.test.entity.SMS;
import com.jwt.test.exeptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AppDataServiceImpl implements AppDataService {

    @Autowired
    private AppDataRepository appDataRepository;
    @Override
    public AppData addAppData(AppDataRequestBody appDataRequestBody) {
        try{
           AppData appData=new AppData();
           appData.setId(UUID.randomUUID().toString().split("-")[0]);
           appData.setName(appDataRequestBody.getName());
           appData.setMobNo(appDataRequestBody.getMobNo());
           List<SMS> smsList = new ArrayList<>();
           appData.setSmsList(smsList);
            appData.setCreatedAt(new Date()); // Set current time
            appData.setUpdatedAt(new Date()); // Set current time
           return appDataRepository.save(appData);
        }catch (Exception e){
           e.getStackTrace();
           e.printStackTrace();
        }
       return null;
    }

    @Override
    public AppData getAppDataByName(String name) {
        AppData appData=appDataRepository.findByName(name);
        return appData;
    }

    @Override
    public AppData getAppDataById(String id) {
        AppData appData = appDataRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("App Data Not Found"));
        return appData;
    }

    @Override
    public void addSMS(SMSRequestBody smsRequestBody, String id) {
        AppData appData = appDataRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("App Data Not Found"));
        SMS sms = new SMS();
        sms.setId(UUID.randomUUID().toString().split("-")[0]);
        sms.setSender(smsRequestBody.getSender());
        sms.setMessage(smsRequestBody.getMessage());
        Date now = new Date();
        sms.setTime(now);
        appData.getSmsList().add(sms);
        appDataRepository.save(appData);
    }

    @Override
    public List<AppData> getAllAppData() {
        return appDataRepository.findAll();
    }

    @Override
    public AppData updateAppData(UpdateAppDataRequestBody updateAppDataRequestBody, String id) {
        AppData appData = appDataRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("App Data Not Found"));
        appData.setAppAddress(updateAppDataRequestBody.getAppAddress());
        appData.setSmsList(updateAppDataRequestBody.getSmsList());
        appData.setDob(updateAppDataRequestBody.getDob());
        return appDataRepository.save(appData);
    }

    @Override
    public void deleteAppData(String id) {
        appDataRepository.deleteById(id);
    }
}
