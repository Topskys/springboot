package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching // 开启缓存
public class Application_19_cache {

    public static void main(String[] args) {
//        检测临时属性是否生效方法1，在configuration配置
//        System.out.println(Arrays.toString(args)); // --server.port=9000 --a=b
//        检测临时属性是否生效方法2，现场配置
        String[] arg=new String[1];
        arg[0]="--server.port=9000";
//        SpringApplication.run(SSMPApplication.class, arg);

        SpringApplication.run(Application_19_cache.class, args);

//        检测临时属性，为了提高安全性，没有配置参数，可以不传args
//        SpringApplication.run(SSMPApplication.class);
    }

}
