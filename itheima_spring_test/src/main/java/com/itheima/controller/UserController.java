package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/user")：设置UserController类的资源访问路径
@RequestMapping("/user")
public class UserController {

    //依赖注入UserService(该单词为该实现类在Spring的配置文件中Bean的id)的实现类对象
    //不需要new对象，直接从spring容器中获取该对象即可
    @Autowired
    private UserService userService;
    //依赖注入RoleService(该单词为该实现类在Spring的配置文件中Bean的id)的实现类对象
    @Autowired
    private RoleService roleService;

    //@RequestMapping("/del/{userId}"):设置del方法的访问路径
    //其中{userId}为用于接收请求参数的占位符
    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId){
        userService.del(userId);
        return "redirect:/user/list";
    }

    @RequestMapping("/save")
    public String save(User user,Long[] roleIds){
        userService.save(user,roleIds);
        return "redirect:/user/list";
    }

    //这个方法是创建用户界面点击"新建"按钮后的跳转的资源方法
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        List<User> userList = userService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

}
