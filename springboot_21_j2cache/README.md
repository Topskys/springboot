#  j2cache 缓存整合 2022年11月2日13:28:51
多级缓存
导入坐标：
```xml
    <dependencies>
        <!--j2cache-core-->
        <dependency>
            <groupId>net.oschina.j2cache</groupId>
            <artifactId>j2cache-core</artifactId>
            <version>2.8.4-release</version>
        </dependency>
        <!--j2cache-->
        <dependency>
            <groupId>net.oschina.j2cache</groupId>
            <artifactId>j2cache-spring-boot2-starter</artifactId>
            <version>2.8.0-release</version>
        </dependency>
    </dependencies>
```
配置：
ehcache.xml
```yaml
j2cache:
  config-location: j2cache.properties
```
```properties
# 一级缓存
j2cache.L1.provider_class=ehcache
ehcache.configXml=ehcache.xml

# 二级缓存
j2cache.L2.provider_class=net.oschina.j2cache.cache.support.redis.SpringRedisProvider
j2cache.L2.config_section=redis
redis.hosts=localhost:6379

# 同步一级缓存到二级缓存
j2cache.broadcast=net.oschina.j2cache.cache.support.redis.SpringRedisPubSubPolicy
```
调用：
```java
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;
    
    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        cacheChannel.set("sms",tele,code);
        return code;
    }
    @Override
    public boolean checkCode(SMSCode smsCode) {
        String cacheCode = cacheChannel.get("sms",smsCode.getTele()).asString();
        return smsCode.getCode().equals(cacheCode);
    }
}
```

由于j2cache使用日志模块与springboot不一致，故报错：  
SLF4J: Class path contains multiple SLF4J bindings.

消除using single，在j2cache.properties配置
redis.mode=single
