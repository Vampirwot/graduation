package com.alexander.graduation;

import com.alexander.graduation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class GraduationApplication {

    @Autowired
    private User user;

    public static void main(String[] args) {
        SpringApplication.run(GraduationApplication.class, args);
    }
}
