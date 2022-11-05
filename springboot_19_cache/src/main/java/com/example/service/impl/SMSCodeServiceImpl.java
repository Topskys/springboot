package com.example.service.impl;

import com.example.domain.SMSCode;
import com.example.service.SMSCodeService;
import com.example.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Override
    // @Cacheable(value="smsCode",key = "#tele")
    @CachePut(value="smsCode",key = "#tele")// 只放
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code=smsCode.getCode();
        String cacheCode = codeUtils.get(smsCode.getTele());
        return  code.equals(cacheCode);
    }
}
