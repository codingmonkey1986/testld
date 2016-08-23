package com.test.mavenproject1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    
    @RequestMapping(value = "/hello")
    public String helloWorld() {
        return "Hello World";
    }
}
