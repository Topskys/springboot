package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class MsgServiceImpl implements MsgService {

    private HashMap<String ,String> cache = new HashMap<String,String>();

    // http://localhost:8002/msg/18700001111
    @Override
    public String get(String tele) {
        String code=tele.substring(tele.length()-6);
        cache.put(tele,code);
        return code;
    }

    // http://localhost:8002/msg?tele=18700001111&code=001111
    @Override
    public boolean check(String tele,String code) {
        String queryCode =cache.get(tele);
        return code.equals(queryCode);
    }
}
