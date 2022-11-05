package com.example.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;


// 实时监听/orders/{id}，不需要/msgs消费了，订单消息需要立即消费
@Component
public class MessageListener {

    @JmsListener(destination = "order.queue.id")// 收到
    @SendTo("order.other.queue.id")// 发到其他地方
    public String receive(String id){   // 收
        System.out.println("已完成发送短信业务（实时监听，立即消费），id："+id);
        return "new:"+id; // 发到其他地方，下一个处理函数
    }
}
