
package com.example.webserviceclientdemo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 */
@WebService(name = "Aservice", targetNamespace = "http://com.example.ws/my")
public interface Aservice {


    @WebResult(name = "sum")
    public int add(@WebParam(name = "aa") int a, @WebParam int b);

    public String getUser();

    String addUser(@WebParam(name = "username") String username, @WebParam(name = "desc") String desc, @WebParam(name = "content") String content);

    @WebMethod(exclude = true)    //exclude为true表示不发布该方法
    public String getMessage2();
}
