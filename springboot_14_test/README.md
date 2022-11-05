# 测试 2022年10月27日21:02:30


## 加载测试专用属性

```java
// 这三种注解不需要在application.properties配置属性了
// @SpringBootTest(properties = {"test.prop=YY"}) // properties = {"test.prop=YY"} 临时属性配置
//@SpringBootTest(args = {"--test.prop=YY"}) // args可为测试添加临时的命令行参数
@SpringBootTest(properties = {"test.prop=YY1"},args = {"--test.prop=YY2"}) // args优先级高
class Springboot14TestApplicationTests {

    @Value("${test.prop}")
    private String msg;

    @Test
    void testProperties() {
        System.out.println(msg);
    }

}
```


## 加载测试专用类配置(局部测试)
```java
@SpringBootTest
@Import(MsgConfig.class)  // 加载当前测试类，不对其他测试类影响
public class ConfigurationTest {

    @Autowired
    private String msg;

    @Test
    void testConfiguration(){
        System.out.println(msg);
    }
}
```

## 表现层测试
需要web，故在pom.xml中配置：
```xml
<!--  spring-boot-starter >  spring-boot-starter-web    -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 启用web服务器
@AutoConfigureMockMvc // 开启模拟mvc
public class WebTest {
    
    @Test
    void testWeb(@Autowired MockMvc mvc) throws Exception{
        // 创建虚拟请求，访问当前 /books
        MockHttpServletRequestBuilder builder= MockMvcRequestBuilders.get("/books"); // /books1 路径不存在会报错
        // 执行请求
        ResultActions action =mvc.perform(builder);

        // 设定预期值，后与真值作比较，判断成功或失败
        StatusResultMatchers status=MockMvcResultMatchers.status();
        // 设置定期值，状态200
        ResultMatcher ok=status.isOk();
        // 与真值作比较
        action.andExpect(ok);

    }
}
```

[comment]: <> (Shift + Alt 多处编辑)



## 错误: 找不到或无法加载主类 com.itheima.Application14Test

```
# Lifecycle
# 先执行 
clean
# 在执行
install
# 重新启动项目即可
```

## Circular view path [test]: would dispatch back to the current handler URL [/upload/test] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)

错误原因：返回页面用@Controller，要想返回数据就用@RestController

把@controller改为@RestController就可以了；



## 关闭test周期产生数据
执行test周期会产生sql数据垃圾，需要关闭
```java
@SpringBootTest
@Transactional  //  添加@Transactional和@Rollback(false)再运行一次，不会产生测试垃圾sql数据 @Rollback()默认false
@Rollback(true) // 回滚
public class DaoTest {

    @Autowired
    private BookService bookService;

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("springboot2");
        book.setType("springboot2");
        book.setDescription("Hello world2");
        bookService.save(book);
    }
}
```

## 使用随机数据测试

```yml
# 配置 *.yml
testcase:
  book:
    id: ${random.int}
    id2: ${random.int(10)}
    type: ${random.int(5,10)} // or [5,10] 、@5,@10  and so on
    name: itheima${random.value}
    uuid: ${random.uuid}
    publishTime: ${random.long}
```
```java
// 接收属性
@Component
@Data
@ConfigurationProperties(prefix = "testcase.book")
public class BookCase {
    private int id;
    private int id2;
    private int type;
    private String name;
    private  String uuid;
    private long publishTime;
}
```
```java
// 运行测试
@SpringBootTest
class ApplicationTests {

    @Autowired
    private BookCase bookCase;

    @Test
    void testBookCase() {
        System.out.println(bookCase);
    }
}
```