package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 启用web服务器
@AutoConfigureMockMvc // 开启模拟mvc
public class WebTest {

    @Test
    void testRandomPort(){ }

    @Test
    public void testWeb(@Autowired MockMvc mvc) throws Exception {
        // 创建虚拟请求，当前访问 /books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        mvc.perform(builder);
    }

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception{
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


    @Test
     public void testBody(@Autowired MockMvc mvc) throws Exception{
        // 创建虚拟请求，访问当前 /books
        MockHttpServletRequestBuilder builder= MockMvcRequestBuilders.get("/books"); // /books1 路径不存在会报错
        ResultActions action =mvc.perform(builder);// 执行请求
        // 设定预期值，后与真值作比较，判断成功或失败
        ContentResultMatchers content=MockMvcResultMatchers.content();
        ResultMatcher result=content.string("springboot2");
        // 与真值作比较
        action.andExpect(result);
    }



    @Test
    public void testJSON(@Autowired MockMvc mvc) throws Exception{
        // 创建虚拟请求，访问当前 /books
        MockHttpServletRequestBuilder builder= MockMvcRequestBuilders.get("/books"); // /books1 路径不存在会报错
        ResultActions action =mvc.perform(builder);// 执行请求
        // 设定预期值，后与真值作比较，判断成功或失败
        ContentResultMatchers content=MockMvcResultMatchers.content();
        ResultMatcher result=content.json("{\"id\":1,\"name\":\"匹配响应体json\",\"type\":\"springboot\",\"description\":\"Hello world\"}");
        // 与真值作比较
        action.andExpect(result);
    }


    @Test
    public void testContentType(@Autowired MockMvc mvc) throws Exception{
        // 创建虚拟请求，访问当前 /books
        MockHttpServletRequestBuilder builder= MockMvcRequestBuilders.get("/books"); // /books1 路径不存在会报错
        ResultActions action =mvc.perform(builder);// 执行请求
        // 设定预期值，后与真值作比较，判断成功或失败
        HeaderResultMatchers header=MockMvcResultMatchers.header();
        ResultMatcher result=header.string("Content-Type","application/json");
        // 与真值作比较
        action.andExpect(result);
    }



    @Test
    public void testGetById(@Autowired MockMvc mvc) throws Exception{
        // 创建虚拟请求，访问当前 /books
        MockHttpServletRequestBuilder builder= MockMvcRequestBuilders.get("/books"); // /books1 路径不存在会报错
        ResultActions action =mvc.perform(builder);// 执行请求

        StatusResultMatchers status=MockMvcResultMatchers.status();
        ResultMatcher ok=status.isOk();
        action.andExpect(ok);

        HeaderResultMatchers header=MockMvcResultMatchers.header();
        ResultMatcher contentType=header.string("Content-Type","application/json");
        action.andExpect(contentType);

        ContentResultMatchers content=MockMvcResultMatchers.content();
        ResultMatcher resJson=content.json("{\"id\":1,\"name\":\"匹配响应体json\",\"type\":\"springboot\",\"description\":\"Hello world\"}");
        action.andExpect(resJson);
    }
}
