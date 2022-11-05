package com.itheima;

import com.itheima.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

// 这三种注解不需要在application.properties配置属性了
// @SpringBootTest(properties = {"test.prop=YY"}) // properties = {"test.prop=YY"} 临时属性配置
//@SpringBootTest(args = {"--test.prop=YY"}) // args可为测试添加临时的命令行参数
@SpringBootTest(properties = {"test.prop=YY1"},args = {"--test.prop=YY2"}) // args优先级高
class ApplicationTests {

    @Value("${test.prop}")
    private String msg;

    @Autowired
    private BookCase bookCase;

    @Test
    void contextLoads() { }

    @Test
    void testProperties() {
        System.out.println(msg);
    }

    @Test
    void testBookCase() {
        System.out.println(bookCase);
    }

}
