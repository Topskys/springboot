package com.itheima.service.impl;


import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


//main----@EnableCreateCacheAnnotation // 开启jetcache缓存方案

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    // local
    @CreateCache(name="jetCache",expire = 20,timeUnit = TimeUnit.SECONDS,cacheType = CacheType.LOCAL)
    private Cache<String,String> jetcache;

    // remote(默认)
    // @CreateCache(area = "sms",name="jetCache",expire = 20) // 声明jetcache缓存空间对象（可创建多个） 3600s
    // private Cache<String,String> jetcache;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetcache.put(tele,code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code=smsCode.getCode();
        String cacheCode = jetcache.get(smsCode.getTele());
        return  code.equals(cacheCode);
    }
}
