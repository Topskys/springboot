package com.example.service.impl;

import com.example.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//@Service 暂用
public class SendMailServiceImpl2 implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private String from="2477350343@qq.com";// *@qq.com  发
    private String to="3122562904@qq.com";  // *@126.com 收
    private String subject="测试邮件";  // 标题
    private String content="测试邮件正文内容"; // 正文

    @Override
    public void sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();// 简单邮件消息
        message.setFrom(from+"(小姐姐)");// 发送人----小姐姐
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        // 定时发送...
        javaMailSender.send(message);
    }

}
