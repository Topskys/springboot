package com.example.service.impl;

import com.example.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

// 复杂一点的邮件消息
@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private String from="2477350343@qq.com";// *@qq.com  发
    private String to="3122562904@qq.com";  // *@126.com 收
    private String subject="测试邮件";  // 标题
    private String content="<a href='https://github.com/Topskys'>Topskys</a>"; // 正文

    @Override
    public void sendMail(){
        try {
            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message,true); // true 允许加附件

            helper.setFrom(from+"(叉烧肉茄子)");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);

            // 附件
            File f1 = new File("D:\\MyProject\\springboot\\springboot_23_mail\\src\\main\\resources\\static\\images\\girl.jpg");
            // helper.addAttachment(f1.getName(),f1);
            helper.addAttachment("girl.jpg",f1);

            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
