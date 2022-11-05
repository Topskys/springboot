# SB整合 Quartz 2022年11月2日16:51:16
springboot也开发类似quartz的spring task

```xml
        <!--quartz-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-quartz</artifactId>
        </dependency>
```
```java
public class MyQuartz extends QuartzJobBean {}
@Configuration
public class QuartzConfig {}
```


# spring Task 
@EnableScheduling // 程序入口 开启定时任务功能 SB整合task
```java
@Component
public class MyBean {

    @Scheduled(cron = "0/1 * * * * ?")
    public void printSBTask() {
        System.out.println("springboot task run...");
    }
}
```
