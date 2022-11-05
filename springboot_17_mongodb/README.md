# 整合mongodb 2022年10月30日22:53:51


```xml
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>
```

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost/itheima
```

```java
@SpringBootTest
class ApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testMongodb(){
        Book temp=new Book();

        temp.setId(1);
        temp.setName("springboot2");
        temp.setType("springboot2");
        temp.setDescription("Hello world2");

        mongoTemplate.save(temp);
    }
    
    @Test
    void testFind(){
       List<Book> all=mongoTemplate.findAll(Book.class);
       System.out.println(all);
    }
}
```

springboot整合思想
1、引入依赖xml
2、编辑配置yml
3、使用


# ElasticSearch（ES） 2022年10月31日12:32:42
ES是一个分布式全文搜索引擎。倒排索引。

下载地址:
> <a href="https://www.elastic.co/cn/downloads/elasticsearch">https://www.elastic.co/cn/downloads/elasticsearch</a>

运行：  
点击 ../bin/ elasticsearch.bat