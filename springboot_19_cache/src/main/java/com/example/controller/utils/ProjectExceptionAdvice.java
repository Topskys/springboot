package com.example.controller.utils;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 作为springMVC的异常统一处理器
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 拦截所有的异常信息
    @ExceptionHandler
    public R  doException(Exception ex){
        ex.printStackTrace();
        return new R(false,null,"请求异常，服务器出现故障，稍后重试！");
    }
}
