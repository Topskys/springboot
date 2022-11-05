# Redis 2022年10月30日20:04:46
SpringBoot整合Redis

```xml
        <!--    Redis    -->
        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
```
```yml
# 可选，已经默认配置
spring: 
  redis:
    host: localhost
    port: 6379
```

```java
// 使用
// RedisTemplate StringRedisTemplate
@SpringBootTest
class Springboot16RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void set() {
       ValueOperations ops=redisTemplate.opsForValue();
       ops.set("age",18);
    }
    @Test
    void get() {
        ValueOperations ops=redisTemplate.opsForValue();
        Object age=ops.get("age");
        System.out.println(age);
    }

    @Test
    void hSet() {
        HashOperations ops=redisTemplate.opsForHash();
        ops.put("info","a","aa");// hset()
    }
    @Test
    void hGet() {
        HashOperations ops=redisTemplate.opsForHash();
        Object val=ops.get("info","a");// hget()
        System.out.println(val);
    }
}
```


# jedis

```xml
<!--    Jedis、lettuce（默认，意为生菜） 客户端实现技术   -->
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
        </dependency>
```

```yaml
spring: # 可选
  redis:
    host: localhost
    port: 6379
    client-type: jedis  # 客户端技术选型 lettuce、jedis
    lettuce:
      pool:
        max-active: 16
    jedis:  # 直连模式，存在线程安全，需要保证访问量接口
      pool:
        max-active: 16
```



# MongoDB 数据库
MongoDB是一个开源、高性能、无模式的文档型数据库。NoSQL数据库产品中的一种，是最像关系型数据库的非关系型数据库。  
特征:永久性存储与临时存储相结合、修改频度较高。

下载：
> <a href="https://www.mongodb.com/try/download">https://www.mongodb.com/try/download<a/>

Windows启动MongoDB服务
```
启动服务端
mongodb --dbpath=..\data
启动客户端
mongodb --host=127.0.0.1 --port=27017
```
客户端可视化操作工具常 robo3t-1.4.4

基本操作
```sql
db.book.save({"name":"springboot",type:"bson"}) # 增
db.book.remove({type:"bson"}) # 条件删除，否则删库
db.book.update({name:"springboot"},($set:{name:"springboot2"})) // 条件，修改
db.getCollection('book').find({}) # 查
db.book.find({type:"bson"}) # 条件查询
```