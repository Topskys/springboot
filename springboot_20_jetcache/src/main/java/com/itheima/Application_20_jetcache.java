package com.itheima;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCreateCacheAnnotation // 开启jetcache缓存方案
@EnableMethodCache(basePackages = "com.itheima") // 开启jetCache方法缓存
public class Application_20_jetcache {

    //    程序入口
    public static void main(String[] args) {
      SpringApplication.run(Application_20_jetcache.class, args);
        System.out.print("Hello,World");
    }

}
