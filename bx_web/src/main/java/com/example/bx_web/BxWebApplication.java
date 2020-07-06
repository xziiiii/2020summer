package com.example.bx_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BxWebApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BxWebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BxWebApplication.class, args);
    }

}


//public class BxWebApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(BxWebApplication.class, args);
//    }
//
//}
