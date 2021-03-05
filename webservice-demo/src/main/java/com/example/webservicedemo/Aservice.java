package com.example.webservicedemo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface Aservice {

    @WebResult(name = "sum")
    public int add(@WebParam(name = "aa") int a, @WebParam int b);

    public String getUser();

    String addUser(String username, String desc, String content);

    @WebMethod(exclude = true)    //exclude为true表示不发布该方法
    public String getMessage2();

}