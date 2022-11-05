# 热部署 2022年10月26日23:31:54

## 配置pom.xml
```
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
```

## 启动，项目已经启动 + Ctrl+F9 或 Build >> Build project

## 关于热部署
重启：restart，自定义开发代码，包含类、页面、配置文件等，加载位置restart类加载器
重载：reload，jar包，加载位置base类加载器


## 自动热部署
1.点击File >> Settings >> Build,E,D >> Compiler >> 勾选 Build project automatically
2.Ctrl+shift+Alt+/ 选Register，勾选compiler.automacke.allow.when.app.running


## 热部署范围及限制
application.yml
```
spring:
  datasource:
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/database?serverTimezone=UTC # mysql 5 和 8 驱动的区别，5需要配置时区?serverTimezone=UTC 且 修改为 driver-class-name: com.mysql.cj.jdbc.Driver
      username: root
      password: 123456
  # 排除热部署目录文件
  devtools:
    restart:
      exclude: static/**,public/**,config/application.yml
```

## 关闭热部署
方案一：
```
spring:
  devtools:
    restart:
      enabled: false
```
方案二：
<div><img src="./src/resources/static/images/no_restart.png"/></div>
```
public static void main(String[] args) {
        // 禁用热部署
        System.setProperty("spring.devtools.restart.enabled","false");
        SpringApplication.run(SSMPApplication.class);
    }
```