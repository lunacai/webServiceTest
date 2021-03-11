package com.example.webserviceclientdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webservice")
public class demoController {

    @GetMapping("addUser")
    public String addUser(String username) {
        aServiceImplService aservice = new aServiceImplService();
        aservice.getPersonImplPort().addUser(username, username + "_desc", username + "_cont");
        return "";
    }
    @GetMapping("getUser")
    public String getUser() {
        aServiceImplService aservice = new aServiceImplService();
        return aservice.getPersonImplPort().getUser();
    }
}
