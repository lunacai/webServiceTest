package com.example.webservicedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("addUser")
    public void addUser(String content) {
        AserviceImpl aservice = new AserviceImpl();
        aservice.addUser(content, "webService", "testContent");
    }

    @GetMapping("getUser")
    public String getUser() {
        AserviceImpl aservice = new AserviceImpl();
        return aservice.getUser();
    }
}
