package com.example.controller;


import com.example.service.IBookServiceMp;
import com.example.domain.Book;
import com.example.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;


    @GetMapping("{tele}")
    public String get(@PathVariable String tele) {
        return  msgService.get(tele);
    }

    @PostMapping
    public boolean check(String tele,String code) {
        return msgService.check(tele,code);
    }

}
