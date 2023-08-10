package com.jwt.test.Controller;

import com.jwt.test.Service.interface_s.AppDataService;
import com.jwt.test.dto.requestBody.AppDataRequestBody;
import com.jwt.test.dto.requestBody.SMSRequestBody;
import com.jwt.test.dto.requestBody.UpdateAppDataRequestBody;
import com.jwt.test.entity.AppData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appdata")
public class AppDataController {

    @Autowired
    private AppDataService appDataService;

    @PostMapping("/addAppData")
    public AppData addAppData(@RequestBody AppDataRequestBody appDataRequestBody){
        return appDataService.addAppData(appDataRequestBody);
    }

    @GetMapping("/getByName/{name}")
    public AppData getAppDataByName(@PathVariable String name){
        return appDataService.getAppDataByName(name);
    }

    @GetMapping("/getAppDataById/{id}")
    public AppData getAppDataById(@PathVariable String id){
        return appDataService.getAppDataById(id);
    }

    @PostMapping("/addSMS/{id}")
    public void addSMS(@RequestBody SMSRequestBody smsRequestBody,@PathVariable String id){
        appDataService.addSMS(smsRequestBody, id);
    }

    @GetMapping("/getAllAppData")
    public List<AppData> getAllAppData(){
        return appDataService.getAllAppData();
    }

     @PutMapping("/updateAppData/{id}")
    public AppData updateAppData(@RequestBody UpdateAppDataRequestBody updateAppDataRequestBody,@PathVariable String id){
        return appDataService.updateAppData(updateAppDataRequestBody,id);
    }

    @DeleteMapping("/deleteAppData/{id}")
    public void deleteAppData(@PathVariable String id){

        appDataService.deleteAppData(id);
    }
}
