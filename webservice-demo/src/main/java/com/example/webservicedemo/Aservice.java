package com.example.webservicedemo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "User",// 定义Port名称
        serviceName = "Aservice", // 修改WebService服务名称
        targetNamespace = "http://com.example.ws/my" // 定义命名空间，默认为倒置的包名
)
public interface Aservice {

    @WebResult(name = "sum")
    public int add(@WebParam(name = "aa") int a, @WebParam int b);

    public String getUser();

    String addUser(@WebParam(name = "username") String username, @WebParam(name = "desc") String desc, @WebParam(name = "content") String content);

    @WebMethod(exclude = true)    //exclude为true表示不发布该方法
    public String getMessage2();

}