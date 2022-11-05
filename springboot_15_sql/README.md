# SQL数据服务 Druid + mybatis-plus + mysql   2022年10月29日17:24:58
数据层技术选型：druid/hikariCp + mp/mybatis/jdbcTemplate + mysql/h2/...

## 使用spring内置数据库管理库库

```yaml
# 默认使用hikariCp
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/database?serverTimezone=UTC # mysql 5 和 8 驱动的区别，5需要配置时区?serverTimezone=UTC 且 修改为 driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: 123456
```
```yaml
# HikariCP DataSource 
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/database?serverTimezone=UTC
    driver-class-name: com.mysql.jdbc.Driver
    username: root
    password: 123456
    hikari: # 替换 DataSource类型
      maximum-pool-size: 50
# tomcat DataSource WEB

# Commons DBCP
```
```yaml
# Druid Database
spring:
  datasource:
    druid: # hikar 、
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/database?serverTimezone=UTC # mysql 5 和 8 驱动的区别，5需要配置时区?serverTimezone=UTC 且 修改为 driver-class-name: com.mysql.cj.jdbc.Driver
      username: root
      password: 123456
```


## 数据层解决方案

### 内置持久化解决方案----jdbcTemplate

配置
```xml
<!--    Jdbc 演示，需要注释mybatis-plus、druid    -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```
使用
```java

import org.springframework.jdbc.core.RowMapper;

@SpringBootTest
class SB15SQLApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testJdbc() {
        String sql = "select * from tbl_book where id=1";
        List<Book> query = jdbcTemplate.query(sql, new RowMapper<Book>(){
           @Override
           public Book mapRow(ResultSet rs,int rowNum) throws SQLException{
               Book temp=new Book();
               temp.setId(rs.getInt("id"));
               temp.setName(rs.getString("name"));
               temp.setType(rs.getString("type"));
               temp.setDescription(rs.getString("description"));
               return temp;
           }
        });
        System.out.println(query);
    }
}
```

## H2、HSQL、Derby 
springboot内置数据库，均使用java编写，提高开发测试效率。内存运行，运行速度快。

H2数据库的使用
```xml
<dependencies>
<!--   H2数据库，演示配置 需要web、h2、jdbc/mybytes-plus、data-jpa   -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
    <!--    MyBatis-Plus    -->
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-boot-starter</artifactId>
                <version>3.4.3</version>
            </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
</dependencies>
```

```yaml
# H2 数据库
spring:
  h2:
    console: # 开启h2数据库控制台
      path: /h2 # http://localhost:8001/h2
      enabled: true
  # H2 第一次使用需要初始化
  datasource:
    url: jdbc:h2:~/test
    driver-class-name: org.h2.Driver # 可选
    username: sa
    password: 123456
    
mybatis-plus:
  global-config:
    db-config:
      table-prefix: tbl_
      id-type: auto
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
    
# 操作SQL语句    
# create table tbl_book (id int , name varchar, type varchar, description varchar)
# select * from tbl_book
# insert into tbl_book values(null,'1','2','3')
```

## NoSql解决方案
like：Redis、Mongo、ES

### Redis
Redis是一款key-value存储结构的内存级NoSql数据库，支持多种数据存储格式，支持持久化，支持集群。
安装：
```js
// 下载地址
<a href="https://github.com/tporadowski/redis/releases/tag/v5.0.14.1">https://github.com/tporadowski/redis/releases/tag/v5.0.14.1</a>
// 按照提示默认安装即可
```
在Redis安装路径cmd，输入以下命令启动：
```js
// 服务端启动命令
redis-server.exe + redis.windows.conf
// 客户端启动命令
redis-cli.exe 
```
由于Redis存在bug，用以上步骤启动服务端会报错，解决：
```
D:\Program Files (x86)\Java\Redis>redis-cli
127.0.0.1:6379> shutdown
not connected> exit

D:\Program Files (x86)\Java\Redis>redis-server.exe redis.windows.conf
```
启动成功新开一个终端窗口，即可使用：
```
redis-cli

// 键值对
set key value
get key

// keya>a1 多个数据
hset keya a1 va1
hset keya a2 va2
hget keya a1
hget keya a2
```