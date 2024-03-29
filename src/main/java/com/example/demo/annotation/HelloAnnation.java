package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//@Target(ElementType.TYPE)   //接口、类、枚举、注解
//@Target(ElementType.FIELD) //字段、枚举的常量
//@Target(ElementType.METHOD) //方法
//@Target(ElementType.PARAMETER) //方法参数
//@Target(ElementType.CONSTRUCTOR)  //构造函数
//@Target(ElementType.LOCAL_VARIABLE)//局部变量
//@Target(ElementType.ANNOTATION_TYPE)//注解
//@Target(ElementType.PACKAGE) ///包
@Target({ElementType.METHOD,ElementType.TYPE}) // 注解起作用的位子
@Retention(RetentionPolicy.RUNTIME) //保留的环境
public @interface HelloAnnation {
        String value() default "";
}
