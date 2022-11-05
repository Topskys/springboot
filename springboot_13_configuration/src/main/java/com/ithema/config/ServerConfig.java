package com.ithema.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

//@Component
@Data
@ConfigurationProperties(prefix = "servers") // 从*.yml引入配置servers: *
@Validated
public class ServerConfig {
    private String ipAddress;

    // bean具体数据效验
    @Max(value=8888,message = "端口号最大值<=8888")
    @Min(value=202,message = "端口号最小值>=202")
    private int port;
    private long timeout;  // ms

    // 配置单位
    @DurationUnit(ChronoUnit.MINUTES)
    private Duration serverTimeOut;

    @DataSizeUnit(DataUnit.MEGABYTES) // or 在*.yml >>> dataSize:10MB
    private DataSize dataSize;
}
