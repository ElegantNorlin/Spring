package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
    //@Autowired:注入roleService对象
    @Autowired
    private RoleService roleService;

    //@RequestMapping("/save"):设置save方法的访问路径
    //save(Role role)方法中的Role对象是由SpringMVC自动封装的，表单中的属性值和Role对象的属性值一致，框架自动封装该对象
    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/list";
    }

    //@RequestMapping("/list"):设置list方法的访问路径
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        //设置模型
        modelAndView.addObject("roleList",roleList);
        //设置视图
        modelAndView.setViewName("role-list");
        System.out.println(roleList);
        return modelAndView;
    }

}
