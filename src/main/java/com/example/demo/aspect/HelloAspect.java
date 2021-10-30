package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    //定义切入点  execution 用于匹配方法执行的连接点  whithin 用于匹配指定类型内的方法执行
    //execution(方法修饰符(可选)  返回类型  类路径 方法名  参数  异常模式(可选))
    //1）execution(public * *(..))——表示匹配所有public方法
    //2）execution(* set*(..))——表示所有以“set”开头的方法
    //3）execution(* com.xyz.service.AccountService.*(..))——表示匹配所有AccountService接口的方法
    //4）execution(* com.xyz.service.*.*(..))——表示匹配service包下所有的方法
    //5）execution(* com.xyz.service..*.*(..))——表示匹配service包和它的子包下的方法
//    @Pointcut("execution(public * com.example.demo..*.*(..))")
//    public void hello(){}

//    @Pointcut("within(com.example.demo.controller.*)")
//    public void hello(){}

     @Pointcut("@annotation(com.example.demo.annotation.HelloAnnation)")
     public void hello(){}

    //通知 前置通知 方法执行前通知
    @Before("hello()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        System.out.println("我是Before 前置通知");
    }
    // 后置通知 方法执行后通知 在目标方法执行后无论是否发生异常都执行通知
    @After("hello()")
    public  void doAfter(JoinPoint joinPoint)throws Throwable{
            System.out.println("我是After 后置通知");
    }
    // 后置通知 在方法正常执行完成进行通知，可以访问到方法的返回值
    @AfterReturning("hello()")
    public  void doAfterReturning(JoinPoint joinPoint)throws Throwable{
        System.out.println("我是 AfterReturning 后置通知");
    }
    // 异常通知 在方法出现异常时进行通知
    @AfterThrowing("hello()")
    public  void doAfterThrowing(JoinPoint joinPoint)throws Throwable{
        System.out.println("我是 AfterThrowing 异常通知");
    }
    //环绕通知  可以将目标方法包裹在前后添加操作
    @Around("hello()")
    public  Object doAround(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("我是Around 环绕通知 前");
        Object reslut = joinPoint.proceed();
        System.out.println("我是Around 环绕通知 后");
        return reslut;
    }


}
