package com.ithema;

import com.alibaba.druid.pool.DruidDataSource;
import com.ithema.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ServerConfig.class)
public class S13CApplication {

    // 第三方bean
    @Bean
    @ConfigurationProperties(prefix="datasource") // 引入datasource.driver from *.yml // data-source
    public DruidDataSource dataSource(){
        DruidDataSource ds=new DruidDataSource();
        // ds.setDriverClassName("com.mysql.jdbc.Driver456"); // @ConfigurationProperties(prefix="datasource")
        return ds;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx =SpringApplication.run(S13CApplication.class, args);
        ServerConfig bean=ctx.getBean(ServerConfig.class);
        System.out.println(bean);

        DruidDataSource ds=ctx.getBean(DruidDataSource.class);
        // System.out.println(ds);

        System.out.println(ds.getDriverClassName());
    }

}
