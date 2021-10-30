package com.example.demo.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.annotation.HelloAnnation;
import com.example.demo.dao.HelloDao;
import com.example.demo.pojo.Project;
import com.example.demo.service.HelloService;
import com.example.demo.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class HelloServiceImpl extends ServiceImpl<HelloDao,Project> implements HelloService{

    @Autowired
    private HelloDao helloDao;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisUtil.redisList redisList;

    @Override
    public List<Project> Hello() {

        List<Project> opj=new ArrayList<>();
//        if(redisUtil.hasKey("projectList")){
//            log.info("在redis中获取");
//            List<Object> redisProjectList = redisList.get("projectList",0,-1);
//            for (Object item:redisProjectList
//                 ) {
//                if(item instanceof Project){
//                    Project project = (Project)item;
//                    opj.add(project);
//                }
//            }
//        }else{
            log.info("在数据库中获取");
            opj= helloDao.getListHello();
            log.info(opj.toString());
            log.info("______________存_________________");
            redisList.set("projectList",opj);
            log.info("______________start_______________________");

            log.info(redisList.get("projectList",0,-1).toString());
            log.info("__________________end___________________");
//        }
        return opj;


    }
}
