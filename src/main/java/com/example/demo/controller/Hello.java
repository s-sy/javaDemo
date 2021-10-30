package com.example.demo.controller;

import com.example.demo.annotation.HelloAnnation;
import com.example.demo.pojo.Project;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Hello {

    @Autowired
    private HelloService helloService;


    @GetMapping("/hello")
    @HelloAnnation()
    public List<Project> Hello(){

        System.out.println("我是目标方法");
        List<Project> ovObject =helloService.Hello();
        System.out.println(ovObject);
        return  ovObject;
    }


}
