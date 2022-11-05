package com.itheima;

import com.itheima.dao.BookDao;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@SpringBootTest
class ApplicationTests {

//    @Autowired
//    private BookDao bookDao;
//
//    @Test
//    void contextLoads() {
//        bookDao.selectById(2);
//    }

//    @Autowired
//    private ElasticsearchRestTemplate esrTemplate; // 老版本的客户端

    // 高版本
    private RestHighLevelClient client;

    @Test
    void testHighLevelClient() throws Exception{ // 高版本配置
        // HttpHost host=HttpHost.create("http://localhost:9200");
        // RestClientBuilder builder= RestClient.builder(host);
        // client = new RestHighLevelClient(builder);
        // 创建索引
        CreateIndexRequest request=new CreateIndexRequest("books");
        client.indices().create(request,RequestOptions.DEFAULT);
        // 关闭客户端
        // client.close();
    }


    // 下面是每个方法运行前后的操作
    @BeforeEach
    void setUp() {
        HttpHost host=HttpHost.create("http://localhost:9200");
        RestClientBuilder builder= RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    @AfterEach
    void tearDown() throws Exception{
        // 关闭客户端
        client.close();
    }
}
