package com.example.webserviceclientdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

@RestController
@RequestMapping("local")
public class testController {

    @GetMapping("addUser")
    public String addUser(String ip, String username) {
        String result = "";
        try {
            URL url = new URL("http://" + ip + ":12345/aservice?wsdl");
            // 指定命名空间和服务名称
            QName qName = new QName("http://com.example.ws/my", "Aservice");
            Service service = Service.create(url, qName);
            // 通过getPort方法返回指定接口
            Aservice myServer = service.getPort(new QName("http://com.example.ws/my", "UserPort"), Aservice.class);
            // 调用方法 获取返回值
            result = myServer.addUser(username, username + "_desc", username + "_content");
            System.out.println(result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("getUser")
    public String getUser(String ip) {
        String result = "";
        try {
            URL url = new URL("http://" + ip + ":12345/aservice?wsdl");
            // 指定命名空间和服务名称
            QName qName = new QName("http://com.example.ws/my", "Aservice");
            Service service = Service.create(url, qName);
            // 通过getPort方法返回指定接口
            Aservice myServer = service.getPort(new QName("http://com.example.ws/my", "UserPort"), Aservice.class);
            // 调用方法 获取返回值
            result = myServer.getUser();
            System.out.println(result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
