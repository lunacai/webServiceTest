package com.example.webservicedemo;

import javax.jws.WebService;

/*这里的注解一定要有，jws一般都是基于注解开发（关于注解的配置可参考文章后篇）*/
@WebService
public class demoController {

    public String sayHello(String saySomeThing) {
        System.out.println("hello world !");
        return "hello !" + saySomeThing;
    }
}
