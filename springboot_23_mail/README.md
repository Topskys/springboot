# JavaMail 2022年11月2日17:49:11

发送邮件需要开通提供商授权码（SMTP、POP3）：邮箱》》设置》》账户》》开启POP3/SMTP服务

导入依赖
```xml
        <!--mail-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>
```
配置yml
```yaml
# 发送邮件配置
spring:
  mail:
    host: smtp.qq.com # smtp.163.com 提供商
    username: 2477350343@qq.com
    password: yuxbpsanuyxneafg
```
使用：（简单邮件消息）
```java
@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private String from="2477350343@qq.com";// *@qq.com  发
    private String to="3122562904@qq.com";  // *@126.com 收
    private String subject="测试邮件";  // 标题
    private String content="测试邮件正文内容"; // 正文

    @Override
    public void sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        // 定时发送...
        javaMailSender.send(message);
    }
}
```


