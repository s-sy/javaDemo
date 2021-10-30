package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Project;


import java.util.List;


public interface HelloDao extends BaseMapper<Project> {


   List<Project> getListHello();
}
