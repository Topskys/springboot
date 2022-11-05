package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.web.bind.annotation.*;


// 简化，统一写在类顶部
//@Controller
//@ResponseBody
@RestController // == @Controller + @ResponseBody
@RequestMapping("/users") // == @RequestMapping(value = "/users")
public class UserController {

    //    @RequestBody:主要用于接收json数据
    //    @RequestParam:主要用于接收url地址传参或表单数据
    //    @PathVariable:主要用于接收路径传参，使用{参数名}描述路径参数

    @PostMapping // ==    @RequestMapping(value = "/users",method = RequestMethod.POST) // REST请求风格，简化接口+method来采取行为。
    //  @ResponseBody
    public String save(){
        System.out.println("user save...");
        return "{'module':'user save'}";
    }

    @DeleteMapping("/{id}")// == @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE) // REST请求风格，简化接口+method来采取行为。
    //    @ResponseBody
    public String delete(@PathVariable Integer id){// PathVariable:路径变量，http.ip:8080/users/1（PathVariable，?id=1）
        System.out.println("user delete..."+id);
        return "{'module':'user delete'}";
    }

    @PutMapping// == @RequestMapping(value = "/users",method = RequestMethod.PUT) // REST请求风格，简化接口+method来采取行为。
    //    @ResponseBody
    public String update(@RequestBody User user){
        System.out.println("user delete..."+user);
        return "{'module':'user update'}";
    }


    @GetMapping("{id}")// ==    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET) // REST请求风格，简化接口+method来采取行为。
    //    @ResponseBody
    public String getById(@PathVariable Integer id){
        System.out.println("user getById..."+id);
        return "{'module':'user getById'}";
    }

    @GetMapping// ==    @RequestMapping(value = "/users",method = RequestMethod.GET) // REST请求风格，简化接口+method来采取行为。
    //    @ResponseBody
    public String getAll(){
        System.out.println("user getAll...");
        return "{'module':'user getAll'}";
    }
}
