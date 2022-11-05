package com.example.springboot_02_mybatis_plus.domain;


import com.baomidou.mybatisplus.annotation.TableName;

//在数据库表映射的实体类中添加@TableName(“表名”)，否則MP可能映射不到該表
@TableName("ev_article_cate")
public class Article {
    private Integer id;
    private String alias;
    private String name;
    private String is_delete;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", name='" + name + '\'' +
                ", is_delete='" + is_delete + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }
}
