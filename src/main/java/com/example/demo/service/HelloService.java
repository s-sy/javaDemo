package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Project;

import java.util.List;

public interface HelloService extends IService<Project>{

    List<Project> Hello();
}
