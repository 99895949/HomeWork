package com.lx.parkms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @RequestMapping("/a")
    public String hello(){
        return "Hello SpringBoot AAA";
    }
}
