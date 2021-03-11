package com.example.webservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class WebserviceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebserviceDemoApplication.class, args);
        String ip = "";
        try {
            ip = String.valueOf(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        String address = "http://" + ip + ":12345/aservice";
        Endpoint.publish(address, new AserviceImpl());
        System.out.println(address);
        System.out.println("publish finish !");

//        address = "http://" + ip + ":12345/hello";
//        System.out.println(address);
//        Endpoint.publish(address, new demoController());

    }

}
