# Cache 缓存 2022年10月31日22:52:28
缓存是一种介于数据永久存储介质与数据应用之间的数据临时存储介质。 
使用缓存可以有效的减少低速数据读取过程的次数（例如磁盘IO)，提高系统性能。
缓存不仅可以用于提高永久性存储介质的数据读取效率，还可以提供临时的数据存储空间。

```java
@Service
public class MsgServiceImpl implements MsgService {

    private HashMap<String ,String> cache = new HashMap<String,String>();

    // http://localhost:8002/msg/18700001111
    @Override
    public String get(String tele) {
        String code=tele.substring(tele.length()-6);
        cache.put(tele,code);
        return code;
    }

    // http://localhost:8002/msg?tele=18700001111&code=001111
    @Override
    public boolean check(String tele,String code) {
        String queryCode =cache.get(tele);
        return code.equals(queryCode);
    }
}
```

## 使用springboot的cache方案(symple)

```xml
<!--   cache     -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
        </dependency>
```
```java
@EnableCaching // 开启缓存
public class Application_19_cache {}
```

```
    // springboot 缓存解决方案
    @Override
    @Cacheable(value = "cacheSpace",key = "#id")// 存储位置cacheSpace>#id //拿到Integer id
    public Book queryBook(Integer id) {
        return bookMap.selectById(id);
    }
```


## springboot整合缓存技术方案

SpringBoot提供的缓存技术除了提供默认的缓存方案（simple），还可以对其他缓存技术进行整合，统一接口，方便缓存技术的开发与管理
Generic
JCache
Ehcache
Hazelcast
Infinispan
Couchbase
Redis
caffenine
simple （默认)
memcached



配置
```xml
<!--   ehcache/...     -->
        <dependency>
            <groupId>net.sf.ehcache</groupId>
            <artifactId>ehcache</artifactId>
        </dependency>
```
```yml
spring:
  cache:
    type: ehcache
    ehcache: # 默认 ehcache.xml
      config: ehcache.xml
```







