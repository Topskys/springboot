package com.itheima.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 统一封装一个类中，通过在pom.xml配置lombok和@Slf4j引入log对象
// private static final Logger log= LoggerFactory.getLogger(BookController.class);

public class LogClass {
    private  Class clazz;
    public static Logger log;

    public LogClass() {
        clazz=this.getClass();
        log= LoggerFactory.getLogger(clazz);
    }
}
