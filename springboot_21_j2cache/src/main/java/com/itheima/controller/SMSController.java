package com.itheima.controller;


import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    private SMSCodeService smsCodeService;

    // http://localhost:8002/sms?tele=18700001111
    @GetMapping
    public String getCode(String tele) {
        String code =smsCodeService.sendCodeToSMS(tele);
        return code;
    }

    // http://localhost:8002/sms?tele=18700001111&code=941664
    @PostMapping
    public boolean checkCode(SMSCode smsCode) {
        return smsCodeService.checkCode(smsCode);
    }
}
