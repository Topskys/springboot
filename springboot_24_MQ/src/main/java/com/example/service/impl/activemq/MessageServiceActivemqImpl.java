package com.example.service.impl.activemq;

import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service // 真正activemq
public class MessageServiceActivemqImpl implements MessageService {

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列，id："+id);
        messagingTemplate.convertAndSend("order.queue.id",id); // 发
    }

    @Override
    public String doMessage() {
        String id=messagingTemplate.receiveAndConvert("order.queue.id",String.class); // 收
        System.out.println("已完成短信发送业务，id："+ id);
        return id;
    }
}
