package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//类上的RequestMapping与方法的RequestMapping拼在一起才是访问该方法的地址
@Controller
@RequestMapping("/user")
public class UserController {

    // 请求地址  http://localhost:8080/user/quick
    //请求方法为method = RequestMethod.GET
    //请求时必须有“username”字段
    @RequestMapping(value="/quick",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.out.println("Controller save running....");
        return "success";
    }

}
