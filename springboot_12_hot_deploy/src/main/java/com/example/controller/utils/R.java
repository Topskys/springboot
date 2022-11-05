package com.example.controller.utils;

import lombok.Data;


// 统一处理表现层返回前端数据
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;


    public R(){};

    public R(Boolean flag){
        this.flag=flag;
    }

    public R(Object data){
        this.data=data;
    }

    public R(String msg){
        this.msg=msg;
    }


    public R(Boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }

    public R(Boolean flag,String msg){
        this.flag=flag;
        this.msg=msg;
    }



    public R(Boolean flag,Object data,String msg){
        this.flag=flag;
        this.msg=msg;
        this.data=data;
    }

}
