package com.alexander.graduation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    public String hello() {

        return "hello-world";
    }
}
