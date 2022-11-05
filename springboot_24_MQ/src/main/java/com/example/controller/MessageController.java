package com.example.controller;


import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/msgs")
public class MessageController {

        @Autowired
        private MessageService messageService;

        // http://localhost:8002/msgs
        @GetMapping
        public String doMessage(){
            String id = messageService.doMessage();
            return id;
        }

}
